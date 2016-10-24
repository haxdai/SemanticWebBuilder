define(["d3", "dojo/data/ObjectStore", "dijit/form/Form" ,"dijit/form/Button", 
    "dojo/dom", "dojo/dom-attr", "dijit/registry", "dojo/store/Memory",
    "dojox/grid/EnhancedGrid", "dojo/dom-construct",
    "dojox/validate/web", "dojox/validate/us", "dojox/validate/check"],
    function (d3, ObjectStore, Form, Button, dom, domAttr, registry, Memory, EnhancedGrid, domConstruct, validate) {
        var startX = 40, w = 40, h = 50, _appID, activitiesGrid, activitiesModel, rtypesGrid, actUserGrid, 
            actRoleGrid, flowUserGrid, flowRoleGrid;
        var _locale = {};
        
        //Custom Table for activities
        function DataTable (placeholder) {
            var tpl = "<tr><td>__itemidx__</td><td><span id='__itemid__'></span></td><td>__name__</td><td>__desc__</td><td>__users__</td><td>__roles__</td></tr>";

            //Render table
            function render() {
                domConstruct.empty(placeholder);
                var finalItems = activitiesModel.getItems();
                finalItems.forEach(function(item, idx) {
                    var cuid = item.uuid.replace(/-/g,"_");
                    var t = tpl.replace("__name__", item.name || "").replace("__desc__", item.description || "")
                        .replace("__users__", item.users || "").replace("__roles__", item.roles || "")
                        .replace("__itemid__", cuid).replace("__itemidx__", idx > 0 && idx < finalItems.length - 1 ? idx : "");
                    var d = domConstruct.toDom(t);
                    domConstruct.place(d, placeholder);

                    //Create action buttons
                    if (idx > 0 && idx < finalItems.length - 2) {
                        var btn = new Button({
                            iconClass: "fa fa-arrow-down",
                            showLabel: false,
                            onClick: function(evt) {
                                activitiesModel.swapItems(idx + 1, idx);
                                updateUI();
                            }
                        });
                        btn._destroyOnRemove = true;
                        //Place and start button separately because dojo fails when startup is done on create function
                        dojo.place(btn.domNode, cuid, "last");
                        btn.startup();
                    }

                    if (idx > 1 && idx < finalItems.length - 1) {
                        var btn = new Button({
                            iconClass: "fa fa-arrow-up",
                            showLabel: false,
                            onClick: function(evt) {
                                activitiesModel.swapItems(idx - 1, idx);
                                updateUI();
                            }
                        });

                        btn._destroyOnRemove = true;
                        dojo.place(btn.domNode, cuid, "last");
                        btn.startup();
                    }

                    if (idx > 0 && idx < finalItems.length - 1) {
                        var btn = new Button({
                            iconClass: "fa fa-trash-o",
                            showLabel: false,
                            onClick: function(evt) {
                                activitiesModel.removeItem(item.uuid);
                                updateUI();
                            }
                        });

                        btn._destroyOnRemove = true;
                        dojo.place(btn.domNode, cuid, "last");
                        btn.startup();
                    }
                });
            };

            return {
                init: function() {
                    render();
                    return this;
                }
            };
        };
        
        //Grid Widget builder based on enhanced grid
        function GridWidget (_data, structure, container, sortKeys) {
            var store = new ObjectStore({ objectStore:new Memory({ data: _data }) });
            var options = {
                store: store,
                query: {id:"*"},
                selectionMode: "multiple",
                structure: structure,
                keepSelection: true,
                plugins: {
                    indirectSelection: true
                }
            };

            var grid = new EnhancedGrid(options, container);
            grid.startup();
            grid.render();

            return {
                updateData: function(_data) {
                    store = new ObjectStore({ objectStore:new Memory({ data: _data }) });
                    grid.setStore(store);
                    grid.render();
                },
                addRowItem: function(item) {
                    if (item) {
                        item.uuid = _uuid();
                        store.newItem(item);
                        grid.render();
                    }
                },
                getItems4Select: function() {
                    if (store.objectStore.data.length) {
                        return store.objectStore.data.map(function(item) {
                            return {
                                label: item.name,
                                value: item.uuid,
                                selected:false
                            };
                        });
                    }
                    return [];
                },
                setSelectedItems: function (items, field) {
                    var rows = grid.rowCount;
                    for (var i = 0; i < rows; i++) {
                        var item = grid.getItem(i);
                        if (item && items.indexOf(item[field]) >= 0) {
                            grid.selection.setSelected(i, true);
                        }
                    }
                    grid.render();
                },
                clearSelection: function() {
                    grid.selection.clear();
                }
            };
        };
        
        
        //DataModel Object for nodes and links
        function PFlowDataModel (name, nodes, links) {
            var _items = nodes, _links = links, stlink = {};

            stlink.type = "startLink";
            stlink.from="Generador de contenido";
            stlink.to=nodes[0].name;
            _links.splice(0,0,stlink);

            function setCoordinates() {
                _items.forEach(function(item, idx) {
                    item.x = idx * 2 * w + startX;
                    item.y = 50;
                });
            };
            
            function updateLinkNodeEnds(oldid, newid) {
                _links.forEach(function(item) {
                    if (item.from === oldid) item.from = newid;
                    if (item.to === oldid) item.to = newid;
                });
            }

            //Sort elements, put authorActivity frst and EndActivity last
            if (_items.length > 2) {
                var tmp, idx;
                
                idx = _items.findIndex(function(item) { return item.type === "AuthorActivity"; });
                tmp = _items.splice(idx, 1);
                _items.splice(0,0,tmp[0]);
                
                idx = _items.findIndex(function(item) { return item.type === "EndActivity"; });
                tmp = _items.splice(idx, 1);
                _items.push(tmp[0]);
            }

            setCoordinates();

            return {
                getItems: function(filter) {
                    if (filter && typeof filter === "function") {
                        return _items.filter(filter);
                    }
                    return _items;
                },
                updateItem: function(nitem) {
                    if (nitem !== undefined) {
                        var idx = _items.findIndex(function(item) { return item.uuid === nitem.uuid; });
                        if (idx > -1) {
                            var oldname = _items[idx].name;
                            _items.splice(idx, 1, nitem);
                            updateLinkNodeEnds(oldname, nitem.name);
                            setCoordinates();
                        }
                    }
                    return this;
                },
                addItem: function(item, idx) {
                    if (item !== undefined) {
                        if(!item.hasOwnProperty("uuid")) {
                            item.uuid = _uuid();
                        }
                        _items.splice(_items.length - 1, 0, item);
                    }
                    setCoordinates();
                    return this;
                },
                removeItem: function (uuid) {
                    var idx = _items.findIndex(function(item) { return item.uuid === uuid; });
                    if (idx > -1) {
                        var ret = _items.splice(idx, 1)[0];
                        setCoordinates();
                        return ret;
                    }
                    return undefined;
                },
                itemExists: function(name) {
                    return this.getItemByName(name) ? true : false;
                },
                getItem: function(uuid) {
                    return _items.find(function(item) { return item.uuid === uuid; });
                },
                getItemByName: function(iname) {
                    var ret = _items.find(function(item) { return item.name === iname; }) || null; 
                    return ret;
                },
                getItemIndex: function(uuid) {
                    return _items.findIndex(function(item) { return item.uuid === uuid; });
                },
                getItemAt: function(index) {
                    if (_items.length && index >= 0 && index < _items.length) {
                        return _items[index];
                    }
                },
                swapItems: function(index1, index2) {
                    var tmp = _items[index1];
                    _items[index1] = _items[index2];
                    _items[index2] = tmp;

                    if (index1 === 1) _links[0].to = _items[index1].name;
                    if (index2 === 1) _links[0].to = _items[index2].name;

                    setCoordinates();
                },
                getItems4Select: function() {
                    var t =  _items.filter(function(item){return item.type==="Activity";}).map(function(item) {
                        return {
                            label: item.name,
                            value: item.uuid,
                            selected: false
                        };
                    });
                    return t;
                },
                getLinks: function(linkType) {
                    if (linkType) {
                        return _links.filter(function(item){return item.type===linkType;});
                    }
                    return _links;
                },
                getLink: function(uid) {
                    return _links.find(function(item) { return item.uuid === uid; });
                },
                updateLink: function(nitem) {
                    if (nitem !== undefined) {
                        var idx = _links.findIndex(function(item) { return item.uuid === nitem.uuid; });
                        if (idx > -1) {
                            _items[idx].from = nitem.from;
                            _items[idx].to = nitem.to;
                            _items[idx].type = nitem.type;
                        }
                    }
                    return this;
                }
            };
        };
        
        //Function to render flow diagram
        function renderGraph(model, placeholder) {
            d3.select("#"+placeholder+" svg").remove();
            var acts = model.getItems();
            var svgContainer = d3.select("#"+placeholder).append("svg");
            var defs = svgContainer.append("defs");

            var reviewer = defs.append("g")
                .attr("id", "book")
                .attr("transform", "translate(0,-1001.8766)");

            reviewer.append("path")
                .attr("d", "m 6.0264005,1046.7649 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -33.22907463,-20.2925 29.77758063,0 9.516387,9.7216 0,39.5724 -39.29396763,0 z m 29.68429763,0.1135 0,9.7014 9.608209,0")
                .attr("fill", "white")
                .attr("stroke", "black");

            reviewer.append("path")
                .attr("d", "m 19.403859,1018.2197 c -5.977286,-8e-4 -10.8230216,4.845 -10.8222646,10.8222 3.21e-4,5.9766 4.8457416,10.8211 10.8222646,10.8204 1.310261,-0 2.609336,-0.2412 3.833985,-0.7071 1.278681,-0.6057 2.111197,-0.8486 3.0625,-1.7871 2.481982,-2.053 3.920306,-5.1051 3.923828,-8.3262 7.57e-4,-5.9765 -4.84379,-10.8219 -10.820313,-10.8222 z m 6.896485,19.1484 c -0.915625,0.7601 -1.950347,1.3639 -3.0625,1.7871 l 5.486328,9.7344 3.08789,-1.7402 z")
                .attr("fill", "white")
                .attr("stroke", "black");

            var publish = defs.append("g")
                .attr("id", "bookOk")
                .attr("transform", "translate(0,-1001.8766)");

            publish.append("path")
                .attr("d", "m 6.0264005,1046.7649 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -33.22907463,-20.2925 29.77758063,0 9.516387,9.7216 0,39.5724 -39.29396763,0 z m 29.68429763,0.1135 0,9.7014 9.608209,0")
                .attr("fill", "white")
                .attr("stroke", "black");

            publish.append("path")
                .attr("d", "m 5.5970149,1032.5861 9.5149251,10.2612 19.029851,-23.8806")
                .attr("fill", "none")
                .attr("stroke", "red")
                .attr("stroke-width", "3");

            var publisher = defs.append("g")
                .attr("id", "bookPublisher")
                .attr("transform", "translate(0,-1001.8766)");

            publisher.append("path")
                .attr("d", "m 30.280132,1002.5859 0,9.7014 9.608209,0 m -39.29250663,-9.8149 29.77758063,0 9.516387,9.7216 0,39.5724 -39.29396763,0 z m 5.43056613,20.2925 27.7985085,0 m -27.7985085,6 27.7985085,0 m -27.7985085,6 27.7985085,0 m -27.7985085,6 27.7985085,0 m -27.7985085,6 27.7985085,0")
                .attr("fill", "white")
                .attr("stroke", "black");
            publisher.append("path")
                .attr("d", "m 20.244038,1023.5071 -3.434804,5.9468 -3.432363,5.9468 4.301439,0 0,10.4925 5.129016,0 0,-10.4925 4.301439,0 -3.432363,-5.9468 -3.432364,-5.9468 z")
                .attr("fill", "white")
                .attr("stroke", "green");


            var g = svgContainer.selectAll("groups")
                .data(acts)
                .enter()
                .append("g")
                .attr("transform", function(d, i) {
                    return "translate("+d.x+", "+d.y+")";
                });

            var test = g.append("use")
                .attr("xlink:href", function(item) {
                    if (item.type==="Activity") {
                        return "#book";
                    } else if (item.type==="AuthorActivity") {
                        return "#bookPublisher";
                    } else if (item.type==="EndActivity") {
                        return "#bookOk";
                    }
                })
                .on("dblclick", function(d) {
                    if (d.type==="Activity") {
                        setActivityFormData(d);
                    }
                })
                .append("svg:title")
                    .text(function(d) { return d.name; });

            var labels = g.append("text")
                .attr("text-anchor", "middle")
                .attr("x", function(d) {
                    return w/2;
                })
                .attr("y", "13")
                    .text(function(d, i){return i > 0 && i < acts.length - 1 ? i : null; });

            var acceptFlows = svgContainer.selectAll("paths")
                .data(model.getLinks())
                .enter()
                .append("path")
                .attr("d", function(d, i) {
                    var fromX, toX;

                    fromX = model.getItemByName(d.from).x;
                    toX = model.getItemByName(d.to).x;

                    if (fromX > toX) {
                        var tmp = fromX;
                        fromX = toX;
                        toX = tmp;
                    }

                    if (d.type === "authorized" || d.type === "startLink") {
                        return "M"+(fromX + w/2)+",50 A"+(toX-fromX)+",130 0 0,1 "+(toX + w/2)+",50";
                    } else if (d.type === "unauthorized") {
                        return "M"+(fromX + w/2)+",100 A"+(toX-fromX)+",130 0 0,0 "+(toX + w/2)+",100";
                    }
                    return "";
                })
                .attr("fill", "none")
                .attr("stroke", function(d) { return d.type === "authorized" || d.type === "startLink" ? "green" : "red"; })
                .attr("stroke-width", 3)
                .on("dblclick", function(d) {
                    if (d.type !== "startLink") {
                        setSequenceFormData(d);
                    }
                });
        };
        
        /*********** utility functions ***********/
        function validateForm(form, profile) { return validate.check(form, profile); };
        function s4() { return Math.floor((1 + Math.random()) * 0x10000).toString(16).substring(1); }
        function _uuid () { return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4(); };
        function showDialog(dId) { registry.byId(dId).show(); };
        function hideDialog(dId) { registry.byId(dId).hide(); };
        function updateUI() {
            registry.byId('toAct_'+_appID).set("options", activitiesModel.getItems4Select()).reset();
            registry.byId('fromAct_'+_appID).set("options", activitiesModel.getItems4Select()).reset();
            activitiesGrid.init();
            renderGraph(activitiesModel, "svgContainer");
        };
        function toggleEndFlowOptions(enable) {
            if (enable) {
                domAttr.set("endflowRadio_"+_appID, "checked", true);
                registry.getEnclosingWidget(dom.byId("endflowRadio_"+_appID)).set("checked", true);
                registry.byId("autoPublish_"+_appID).set("disabled",false);
                registry.byId("authorized_"+_appID).set("disabled",false);
                toggleSendToOtherOptions(false);
                toggleSendStartOptions(false);
            } else {
                domAttr.remove("endflowRadio_"+_appID, "checked");
                registry.byId("autoPublish_"+_appID).set("disabled",true);
                registry.byId("authorized_"+_appID).set("disabled",true);
            }
        };
        
        function toggleSendToOtherOptions(enable) {
            if (enable) {
                domAttr.set("redirectflowRadio_"+_appID, "checked", true);
                registry.getEnclosingWidget(dom.byId("redirectflowRadio_"+_appID)).set("checked", true);
                registry.byId("toAct_"+_appID).set("disabled",false);
                toggleSendStartOptions(false);
                toggleEndFlowOptions(false);
            } else {
                domAttr.remove("redirectflowRadio_"+_appID, "checked");
                registry.byId("toAct_"+_appID).set("disabled",true);
            }
        };
        
        function toggleSendStartOptions(enable) {
            if (enable) {
                domAttr.set("startflowRadio_"+_appID, "checked", "checked");
                registry.getEnclosingWidget(dom.byId("startflowRadio_"+_appID)).set("checked", true);
                toggleEndFlowOptions(false);
                toggleSendToOtherOptions(false);
            } else {
                domAttr.remove("startflowRadio_"+_appID, "checked");
            }
        };
        
        function setSequenceFormData(config) {
            //Clear selections
            flowUserGrid.clearSelection();
            flowRoleGrid.clearSelection();
            //Set form values
            var fromObj, toObj;
                fromObj = activitiesModel.getItemByName(config.from);
                toObj = activitiesModel.getItemByName(config.to);
            
            registry.byId("fromAct_"+_appID).set("value", fromObj.uuid);
            registry.byId("toAct_"+_appID).set("value", toObj.uuid);
            
            if (toObj.name === "Generador de contenido") {
                toggleSendStartOptions(true);
            } else  if (toObj.name === "Terminar flujo") {
                toggleEndFlowOptions(true);
            } else {
                toggleSendToOtherOptions(true);
            }
            
            if (config.type && config.type !== "startLink") {
                registry.byId("linkAct_"+_appID).set("value", config.type);
            }
            
            domAttr.set("uuidFlow_"+_appID, "value", config.uuid);
            domAttr.set("flowAction_"+_appID, "value", "update");

            if (config.users) {
                flowUserGrid.setSelectedItems(config.users,"login");
            }
            if (config.roles) {
                flowRoleGrid.setSelectedItems(config.roles,"id");
            }
            
            showDialog && showDialog("addTransitionDialog_"+_appID);
        };
        
        function setActivityFormData(config) {
            //Clear selections
            actUserGrid.clearSelection();
            actRoleGrid.clearSelection();
            //Set form values
            registry.byId("activityName"+_appID).set("value", config.name);
            registry.byId("activityDescription"+_appID).set("value", config.description);
            domAttr.set("uuidActivity_"+_appID, "value", config.uuid);
            domAttr.set("activityAct_"+_appID, "value", "update");

            if (config.hours > 0) registry.byId("activityHours"+_appID).set("value", config.hours);
            if (config.days > 0) registry.byId("activityDays"+_appID).set("value", config.days);
            if (config.users) {
                actUserGrid.setSelectedItems(config.users,"login");
            }
            if (config.roles) {
                actRoleGrid.setSelectedItems(config.roles,"id");
            }
            
            showDialog && showDialog("addActivityDialog_"+_appID);
        };
        
        function saveSequenceFlow() {
            var valid = false, msg,
                res = validateForm(dojo.byId('addTransition_form'+_appID), {required:["from", "linkType"]}),
                action = domAttr.get("flowAction_"+_appID, "value"), itemUsers, itemRoles,
                gd1 = registry.byId("sequenceNotificationUsers_"+_appID),
                gd2 = registry.byId("sequenceNotificationRoles_"+_appID);


            //Form validation passed, check users and roles
            if(res.isSuccessful()) {
                //Get users or roles selected
                itemUsers = gd1.selection.getSelected();
                itemRoles = gd2.selection.getSelected();

                if (itemUsers.length || itemRoles.length) {
                    valid = true;
                } else {
                    msg = "Debe seleccionar usuarios o roles";
                }
            } else if (res.hasMissing()) {
                valid = false;
                msg = "Verifique que ha introducido los campos requeridos";
            }
            
            if (valid) {
                var payload = registry.byId('addTransition_form'+_appID).getValues();
                payload.users = itemUsers.map(function(i) { return i.login; });
                payload.roles = itemRoles.map(function(i) { return i.id; });
                payload.type = payload.linkType;
                //TOTO:
                if (action === "update") {
                    var uid = domAttr.get("uuidFlow_"+_appID, "value");
                    payload.uuid = uid;
                    //activitiesModel.updateItem(payload);
                } else if (action === "insert") {
                    //var foundItem = activitiesModel.getItemByName(payload.name);
                    //if (foundItem && foundItem.uuid) {
                    //    valid = false;
                    //    msg = "Ya existe una actividad con ese nombre";
                    //} else {
                    //    activitiesModel.addItem(payload);
                    //}
                }
                
                gd1.selection.clear();
                gd2.selection.clear();
                domAttr.set("uuidFlow_"+_appID, "value", "");
                domAttr.set("flowAction_"+_appID, "value", "");

                //Close dialog and update activity select in sequence dialog
                //registry.byId('addActivityDialog_'+_appID).reset();
                //registry.byId('addActivityTabContainer_'+_appID).selectChild(registry.byId('propertiesPane_'+_appID));
                //hideDialog('addActivityDialog_'+_appID);
                
                //updateUI();
                
                console.log(payload);
            } else {
                alert(msg);
            }
        };
        
        function saveActivity() {
            var msg, valid = false,
                res = validateForm(dojo.byId('addActivity_form'+_appID), {required:["name", "description"]}),
                action = domAttr.get("activityAct_"+_appID, "value"),
                itemUsers, itemRoles, gd1 = registry.byId('activityUsers_'+_appID),
                gd2 = registry.byId('activityRoles_'+_appID);

            //Form validation passed, check users and roles
            if(res.isSuccessful()) {
                //Get users or roles selected
                itemUsers = gd1.selection.getSelected();
                itemRoles = gd2.selection.getSelected();
                
                if (itemUsers.length || itemRoles.length) {
                    valid = true;
                } else {
                    msg = "Debe seleccionar usuarios o roles";
                }
            } else if (res.hasMissing()) {
                valid = false;
                msg = "Verifique que ha introducido los campos requeridos";
            }
            
            if (valid) {
                var payload = registry.byId('addActivity_form'+_appID).getValues();
                payload.users = itemUsers.map(function(i) { return i.login; });
                payload.roles = itemRoles.map(function(i) { return i.id; });
                payload.type = "Activity";
                
                if (action === "update") {
                    var uid = domAttr.get("uuidActivity_"+_appID, "value");//dom.byId("uuidActivity_"+_appID).;
                    payload.uuid = uid;
                    activitiesModel.updateItem(payload);
                } else if (action === "insert") {
                    var foundItem = activitiesModel.getItemByName(payload.name);
                    if (foundItem && foundItem.uuid) {
                        valid = false;
                        msg = "Ya existe una actividad con ese nombre";
                    } else {
                        activitiesModel.addItem(payload);
                    }
                }
                
                gd1.selection.clear();
                gd2.selection.clear();
                domAttr.set("uuidActivity_"+_appID, "value", "");
                domAttr.set("activityAct_"+_appID, "value", "");

                //Close dialog and update activity select in sequence dialog
                registry.byId('addActivityDialog_'+_appID).reset();
                registry.byId('addActivityTabContainer_'+_appID).selectChild(registry.byId('propertiesPane_'+_appID));
                hideDialog('addActivityDialog_'+_appID);
                
                updateUI();
            } else {
                alert(msg);
            }
        };
        
        /*************App definition*************/
        var workflowApp = { version:"0.0.2" };
        
        //App methods
        workflowApp.initUI = function(appID, data, locale) {
            _appID = appID;
            activitiesModel = new PFlowDataModel("activities", data.activities, data.links);
            activitiesGrid = new DataTable('activities_'+_appID).init();
            rtypesGrid = new GridWidget(data.resourceTypes, 
                [
                    { name: "Tipo de recurso", field: "name", width: "20%" },
                    { name: "Descripción", field: "description", width: "30%" }
                ], "resourceTypes_"+_appID);
            
            if (locale) _locale = locale;
            
            //Main bar buttons
            new Button({
                label: "Agregar actividad",
                iconClass:'fa fa-plus',
                onClick: function(evt) {
                    domAttr.set("activityAct_"+_appID, "value", "insert");
                    showDialog && showDialog("addActivityDialog_"+_appID);
                }
            }, "addActivity_"+_appID).startup();
            
            new Button({
                label: "Agregar secuencia",
                iconClass:'fa fa-plus',
                onClick: function(evt) {
                    toggleEndFlowOptions(true);
                    showDialog && showDialog("addTransitionDialog_"+_appID);
                }
            }, "addSequence_"+_appID).startup();
            
            new Button({
                label: "Guardar flujo",
                iconClass:'fa fa-save',
                onClick: function(evt) {

                }, 
                busy: function(val) {
                    this.set("iconClass", val ? "dijitIconLoading" : "dijitEditorIcon dijitEditorIconSave");
                    this.set("disabled", val);
                }
            }, "saveButton_"+_appID).startup();
            
            
            //Add transition Dialog buttons
            new Button({
                label: "Cancelar",
                onClick: function(evt) {
                    hideDialog && hideDialog("addTransitionDialog_"+_appID);
                    registry.byId('addTransitionDialog_'+_appID).reset();
                    registry.byId('addTransitionTabContainer_'+_appID).selectChild(registry.byId('infoPane_'+_appID));
                }
            }, "addSequenceCancel_"+_appID).startup();

            new Button({
                label: "Aceptar",
                onClick: function(evt) {
                    saveSequenceFlow();
                    //hideDialog && hideDialog("addTransitionDialog_"+_appID);
                    //registry.byId('addTransitionDialog_'+_appID).reset();
                    //registry.byId('addTransitionTabContainer_'+_appID).selectChild(registry.byId('infoPane_'+_appID));
                }
            }, "addSequenceAccept_"+_appID).startup();
            
            //Add activity dialog buttons
            new Button({
                label: "Cancelar",
                onClick: function(evt) {
                    //Clear selections
                    actUserGrid.clearSelection();
                    actRoleGrid.clearSelection();
                    hideDialog && hideDialog("addActivityDialog_"+_appID);
                    registry.byId('addActivityDialog_'+_appID).reset();
                    registry.byId('addActivityTabContainer_'+_appID).selectChild(registry.byId('propertiesPane_'+_appID));
                }
            }, "addActivityDialogCancel_"+_appID).startup();
            
            new Button({
                label: "Aceptar",
                onClick: function(evt) {
                    saveActivity();
                    evt.preventDefault();
                }
            }, "addActivityDialogOk_"+_appID).startup();
            
            //Add users and roles grids
            actUserGrid = new GridWidget(data.users, 
                [
                    { name: "Usuario", field: "login", width: "80%" }
                ], "activityUsers_"+_appID);

            actRoleGrid = new GridWidget(data.roles, 
                [
                    { name: "Rol", field: "name", width: "80%" }
                ], "activityRoles_"+_appID);

            flowUserGrid = new GridWidget(data.users, 
                [
                    { name: "Usuario", field: "login", width: "80%" }
                ], "sequenceNotificationUsers_"+_appID);

            flowRoleGrid = new GridWidget(data.roles, 
                [
                    { name: "Rol", field: "name", width: "80%" }
                ], "sequenceNotificationRoles_"+_appID);
            
            
            dom.byId("filterVersion_"+_appID).innerHTML = data.version;
            registry.byId("endflowRadio_"+_appID).on("change", function(isChecked) {
                if (isChecked) {
                    toggleEndFlowOptions(true);
                }
            });
            
            registry.byId("startflowRadio_"+_appID).on("change", function(isChecked) {
                if (isChecked) {
                    toggleSendStartOptions(true);
                }
            });
            
            registry.byId("redirectflowRadio_"+_appID).on("change", function(isChecked) {
                if (isChecked) {
                    toggleSendToOtherOptions(true);
                 }
            });
            
            updateUI();
        };
        
        workflowApp.getAppID = function() { return _appID; };
        return workflowApp;
});