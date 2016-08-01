<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.io.File"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.AdminFilter"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<!--%@page contentType="text/html" pageEncoding="UTF-8"%-->
<%
AdminFilter af = (AdminFilter) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
String resID = af.getId();

SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getFilter");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateFilter");
save.setParameter("suri", request.getParameter("suri"));
save.setParameter("id", resID);
%>
<style>
    .noIcon {
        display: none !important;
    }
    
    .adminFilterTree .dijitTreeRowSelected .dijitTreeLabel {
        background: none !important;
        outline: none !important;
    }
    
    .adminFilterTree .dijitTreeNodeFocused .dijitTreeLabel {
        background: none !important;
        outline: none !important;
    }
    
    .styleChecked {
        color: darkblue;
        font-style: italic;
        font-weight: bold !important;
    }
    
    .styleHighlight {
        font-style: italic;
        font-weight: bold !important;
    }
</style>
<div id="container_<%= resID %>" data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
        <button id="saveButton_<%= resID %>" type="button"></button>
    </div>
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
        <div id="mainPanel_<%= resID %>" data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height:100%;">
            <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre sitios" data-dojo-props="selected:true">
                <div class="adminFilterTree" id="serverTree_<%= resID %>"></div>
            </div>
            <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre menus">
                <div class="adminFilterTree" id="menuTree_<%= resID %>"></div>
            </div>
            <div data-dojo-type="dijit/layout/ContentPane" title="Configuraci�n de vista">
                <div class="adminFilterTree" id="viewTree_<%= resID %>"></div>
            </div>
            <div data-dojo-type="dijit/layout/ContentPane" title="Documentos del servidor">
                <div class="adminFilterTree" id="filesTree_<%= resID %>"></div>
            </div>
            <script type="dojo/method">
                require(['dojo/store/Memory','dijit/tree/ObjectStoreModel', 
                    'dijit/Tree', 'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                    'dojox/widget/Standby', 'dojo/topic', 'dijit/form/Button'],
                function(Memory, ObjectStoreModel, Tree, ready, dom, xhr, StandBy, topic, Button) {
                    var server_<%= resID %>, menus_<%= resID %>, dirs_<%= resID %>, behave_<%= resID %>;
                    var saveButton_<%= resID %>;
                       
                    function busy(val) {
                        if (saveButton_<%= resID %>) {
                            saveButton_<%= resID %>.set("disabled", val);
                        }
                    }
    
                    saveButton_<%= resID %> = new Button({
                        label: "Guardar Filtro",
                        iconClass:'dijitEditorIcon dijitEditorIconSave',
                        onClick: function(evt) {
                            var payload = {id: '<%= af.getId() %>'}, xhrhttp = new XMLHttpRequest();
                            xhrhttp.open("POST", '<%= save %>', true);
                            xhrhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
                            busy(true);
                            
                            if (server_<%= resID %>.getSelectedItems().total > 0) {
                                payload.sites = server_<%= resID %>.getSelectedItems();
                            }
                            if (menus_<%= resID %>.getSelectedItems().total > 0) {
                                payload.menus = menus_<%= resID %>.getSelectedItems();
                            }
                            if (behave_<%= resID %>.getSelectedItems().total > 0) {
                                payload.elements = behave_<%= resID %>.getSelectedItems();
                            }

                            if (dirs_<%= resID %>.getSelectedItems().total > 0) {
                                payload.dirs = dirs_<%= resID %>.getSelectedItems();
                            }
                            //console.log(payload);
                            xhrhttp.send(JSON.stringify(payload));
                            xhrhttp.onreadystatechange = function() {
                                if (xhrhttp.readyState == 4 && xhrhttp.status == 200) {
                                  busy(false);
                                }
                            };
                        }
                    }, "saveButton_<%= resID %>").startup();
                    
                    var standby = new StandBy({target: "container_<%= resID %>"});
                    document.body.appendChild(standby.domNode);
                    standby.startup();
                    standby.show();

                    //TODO: Mover la funci�n de creaci�n de �rboles a una biblioteca para que el navegador no almacene la definici�n varias veces
                    function TreeWidget (treeData, placeHolder, rootId) {
                        var store, model;

                        function createTreeNode(args) {
                            var tnode, cb;

                            tnode = new dijit._TreeNode(args);
                            tnode.labelNode.innerHTML = args.label;
                            cb = new dijit.form.CheckBox();
                            cb.placeAt(tnode.labelNode, "first");

                            tnode.isCheckboxActive = function() {
                                return cb && cb.get("checked") === true;
                            };

                            tnode.toggleCheckbox = function(val, recurse) {
                                cb && cb.set("checked", val);
                            };

                            tnode.toggleCheckBoxState = function(val, recurse) {
                                var _val = val || false;
                                cb.set("disabled", _val);
                            };

                            tnode.disableChilds = function() {
                                if (this.isExpanded) {
                                    var childs = this.getChildren();
                                    if (childs.length) {
                                        dojo.forEach(childs, function (child) {
                                            child.toggleCheckbox(false);
                                            child.toggleCheckBoxState(true);
                                            dojo.removeClass(child.labelNode, "styleChecked");
                                            dojo.removeClass(child.labelNode, "styleHighlight");
                                            child.item.selected=false;
                                            child.item.enabled=false;
                                            store.put(child.item);
                                            child.disableChilds();
                                        });
                                    }
                                }
                            };

                            tnode.enableChilds = function() {
                                if (this.isExpanded) {
                                    var childs = this.getChildren();
                                    if (childs.length) {
                                        dojo.forEach(childs, function (child) {
                                            child.item.enabled = true;
                                            store.put(child.item);
                                            child.toggleCheckBoxState(false);
                                            child.enableChilds();
                                        });
                                    }
                                }
                            };

                            tnode.highlightParents = function(val) {
                                var parentId = tnode.item.parent || false, parent;
                                var enable = val || false;

                                parent = parentId && this.tree._itemNodesMap[parentId];
                                if (parent && parent.length) {
                                    parent = parent[0];
                                    enable ? dojo.addClass(parent.labelNode, "styleHighlight") : dojo.removeClass(parent.labelNode, "styleHighlight");
                                }

                                while (parentId) {
                                    parentId = parent.item.parent || false;
                                    parent = this.tree._itemNodesMap[parentId];
                                    if (parent && parent.length) {
                                        parent = parent[0];
                                        enable ? dojo.addClass(parent.labelNode, "styleHighlight") : dojo.removeClass(parent.labelNode, "styleHighlight");
                                    }
                                }
                            };

                            dojo.connect(cb, "onClick", function(obj) {
                                tnode.toggleCheckbox(obj.target.checked);
                                tnode.item.selected=obj.target.checked;
                                store.put(tnode.item);
                                obj.target.checked ? tnode.disableChilds() : tnode.enableChilds();
                                //obj.target.checked ? dojo.addClass(tode.labelNode, "styleChecked") : dojo.removeClass(tode.labelNode, "styleChecked");
                                //obj.target.checked && dojo.removeClass(tnode.labelNode, "styleHighlight");
                                obj.stopPropagation()
                            });

                            if(args.item.selected) {
                                args.item.enabled = true;
                                store.put(args.item);
                                tnode.toggleCheckbox(args.item.selected);
                                args.item.selected ? tnode.disableChilds() : tnode.enableChilds();
                            }

                            return tnode;
                        };

                        if (treeData && treeData.length) {
                            store = new Memory({
                                data: treeData,
                                idProperty: "uuid",
                                getChildren: function(object) {
                                    return this.query({parent: object.uuid});
                                },
                                getSelectedChilds: function() {
                                    return this.query({selected: true});
                                }
                            });

                            model = new ObjectStoreModel({
                                store: store,
                                query: {uuid: rootId},
                                labelAttr: "name",
                                mayHaveChildren: function(item) {
                                    return model.store.getChildren(item).total > 0;
                                },
                                getItemPath: function(id) {
                                    var ret = [], parent = undefined, query;
                                    query = this.store.query({uuid: id});
                                    
                                    if (query.total === 1) {
                                        parent = query[0];
                                    }
                                    
                                    while (parent) {
                                        ret.push(parent.uuid);
                                        query = this.store.query({uuid: parent.parent});
                                    
                                        if (query.total === 1) {
                                            parent = query[0];
                                        } else {
                                            parent = undefined;
                                        }
                                    }

                                    return ret.reverse();
                                }
                            });

                            var ret = new Tree({
                                model: model,
                                getIconClass: function(item, opened) {
                                    return "noIcon";
                                },
                                getRowClass: function(item,opened) {},
                                _createTreeNode: createTreeNode,
                                onOpen: function(_item, _node) {
                                    //Si el nodo est� seleccionado o el nodo est� deshabilitado, deshabilitar los hijos
                                    if (_node.isCheckboxActive() || _item.enabled === false) {
                                        _node.disableChilds();
                                    }
                                },
                                getSelectedItems: function() {
                                    return store.getSelectedChilds();
                                }
                            });

                            ret.placeAt(placeHolder);
                            ret.startup();
                            return ret;
                        }

                        return {};
                    };
                    
                    xhr("<%= data%>", {
                        handleAs: "json"
                    }).then(function(_data) {
                        //Create server tree
                        if (_data.sites) {
                            server_<%= resID %> = new TreeWidget(_data.sites, 'serverTree_<%= resID %>', _data.sitesRoot);
                            server_<%= resID %>.onLoadDeferred.then(function() {
                                _data.paths.forEach(function(item, idx){
                                    console.log(item);
                                });
                                //console.log(_data.paths);
                                // TODO: Expandir paths
                                //server_<%= resID %>.set('paths', [server_<%= resID %>.model.getItemPath(_data.paths[1][0])]);
                            });
                        }
                        //Create menues tree
                        if (_data.menus) {
                            menus_<%= resID %> = new TreeWidget(_data.menus, 'menuTree_<%= resID %>', _data.menusRoot);
                        }

                        //Create behaviours tree
                        if (_data.elements) {
                            behave_<%= resID %> = new TreeWidget(_data.elements, 'viewTree_<%= resID %>', _data.elementsRoot);
                        }

                        //Create files tree
                        if (_data.dirs) {
                            dirs_<%= resID %> = new TreeWidget(_data.dirs, 'filesTree_<%= resID %>', _data.dirsRoot);
                        }
                        standby.hide();
                    }, function(err){
                        alert("Ha ocurrido un error. Intente nuevamente.");
                    });
                });
            </script>
        </div>
    </div>
</div>