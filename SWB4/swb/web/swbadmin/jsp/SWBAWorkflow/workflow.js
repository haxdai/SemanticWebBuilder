define(["d3", "dojo/data/ObjectStore", "dojo/store/Memory", "dojox/grid/EnhancedGrid", "dojox/validate/web", "dojox/validate/us", "dojox/validate/check"],
    function (d3, ObjectStore, Memory, EnhancedGrid, validate) {
        var startX = 40, w = 40, h = 50;
        
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
                        item.uuid = workflowApp.uuid();
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
                            }
                        });
                    }
                    return [];
                }
            };
        };
        
        
        //DataModel Object
        function PFlowDataModel (name, nodes, links) {
            var _items = nodes, _links = links;

            _links.push({type:"startLink"});

            function setCoordinates() {
                _items.forEach(function(item, idx) {
                    item.x = idx * 2 * w + startX;
                    item.y = 50;
                });
            };

            if (_items.length > 2) {
                var tmp = _items[_items.length - 2];
                _items.splice(2,1);
                _items.splice(0,0,tmp);
            }

            setCoordinates();

            return {
                getItems: function(filter) {
                    if (filter && typeof filter == "function") {
                        return _items.filter(filter);
                    }
                    return _items;
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
                getItem: function(uuid) {
                    return _items.find(function(item) { return item.id === uuid; });
                },
                getItemByName: function(iname) {
                    return _items.find(function(item) { return item.name === iname; });
                },
                getItemIndex: function(uuid) {
                    return _items.findIndex(function(item) { return item.id === uuid; });
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
                    setCoordinates();
                },
                getItems4Select: function() {
                    var t =  _items.filter(function(item){return item.type==="Activity"}).map(function(item) {
                        return {
                            label: item.name,
                            value: item.uuid,
                            selected: false
                        }
                    });
                    return t;
                },
                getLinks: function(linkType) {
                    if (linkType) {
                        return _links.filter(function(item){return item.type===linkType});
                    }

                    return _links;
                }
            }
        }
        
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
                .on("dblclick", function(d){console.log("editing...");})
                .append("svg:title")
                    .text(function(d) { return d.name });

            var labels = g.append("text")
                .attr("text-anchor", "middle")
                .attr("x", function(d) {
                    return w/2;
                })
                .attr("y", "13")
                    .text(function(d, i){return i > 0 && i < acts.length - 1 ? i : null});

            var acceptFlows = svgContainer.selectAll("paths")
                .data(model.getLinks())
                .enter()
                .append("path")
                .on("dblclick", function(d) { console.log("editing..."); })
                .attr("d", function(d, i) {
                    var fromX, toX;

                    if (d.type==="startLink") {
                        fromX = model.getItemAt(0).x;
                        toX = model.getItemAt(1).x;
                    } else {
                        fromX = model.getItemByName(d.from).x;
                        toX = model.getItemByName(d.to).x;
                    }

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
                .attr("stroke", function(d) { return d.type === "authorized" || d.type === "startLink" ? "green" : "red"})
                .attr("stroke-width", 3);
        };
        
        function s4() { return Math.floor((1 + Math.random()) * 0x10000).toString(16).substring(1); }
        function _uuid () { return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4(); };
        
        var workflowApp = {
            version:"0.0.1",
            uuid: function () {
                return _uuid();
            },
            createWorkFlowModel: function(name, nodes, links) {
                return new PFlowDataModel(name, nodes, links);
            },
            renderFlow: function(model, placeholder) {
                renderGraph(model, placeholder);
            },
            createGridWidget: function(_data, structure, container, sortKeys) {
                return new GridWidget (_data, structure, container, sortKeys);
            },
            validateForm: function(form, profile) {
                return validate.check(form, profile);
            }
        };

        return workflowApp;
});