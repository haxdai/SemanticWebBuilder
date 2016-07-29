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
<div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
        <div data-dojo-type="dijit/form/Button" data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconSave'" type="button">Guardar filtro
            <script type="dojo/on" data-dojo-event="click" data-dojo-args="evt">
                require(['dojo/topic'], function(topic) {
                    topic.publish("adminFilter_<%= resID %>/update");
                    evt.preventDefault();
                    evt.stopPropagation();
                });
            </script>
        </div>
    </div>
    <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
        <div id="mainPanel_<%= resID %>" data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height:100%;">
            <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre sitios" data-dojo-props="selected:true">
                <div class="adminFilterTree" id="serverTree_<%= resID %>"></div>
            </div>
            <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre menus">
                <div class="adminFilterTree" id="menuTree_<%= resID %>"></div>
            </div>
            <div data-dojo-type="dijit/layout/ContentPane" title="Configuración de vista">
                <div class="adminFilterTree" id="viewTree_<%= resID %>"></div>
            </div>
            <div data-dojo-type="dijit/layout/ContentPane" title="Documentos del servidor">
                <div class="adminFilterTree" id="filesTree_<%= resID %>"></div>
            </div>
            <script type="dojo/method">
                require(['dojo/store/Memory','dijit/tree/ObjectStoreModel', 'dijit/Tree', 'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 'dojox/widget/Standby', 'dojo/topic'], function(Memory, ObjectStoreModel, Tree, ready, dom, xhr, StandBy, topic) {
                    var standby = new StandBy({target: "mainPanel_<%= resID %>"});
                    document.body.appendChild(standby.domNode);
                    standby.startup();
                    standby.show();

                    //TODO: Mover la función de creación de árboles a una biblioteca para que el navegador no almacene la definición varias veces
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
                                          var theItem = child.item;
                                          theItem.enabled=false;
                                          theItem.selected=false;
                                          store.put(theItem);
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
                                          child.toggleCheckBoxState(false);
                                          child.enableChilds();
                                          var theItem = child.item;
                                          theItem.enabled=true;
                                          store.put(theItem);
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
                                topic.publish("adminFilter_<%= resID %>/nodechange", {node: tnode, state: obj.target.checked});
                                var theItem = tnode.item;
                                theItem.selected=obj.target.checked;
                                store.put(theItem);
                                console.log(theItem);
                                obj.stopPropagation()
                            });

                            if(args.item.selected) {
                                tnode.toggleCheckbox(args.item.selected);
                                topic.publish("adminFilter_<%= resID %>/nodechange", {node: tnode, state: args.item.selected});
                            }

                            return tnode;
                        };

                        if (treeData && treeData.length) {
                            store = new Memory({
                                data: treeData,
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
                                    topic.publish("adminFilter_<%= resID %>/nodeexpand", {node: _node, item: _item});
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

                    var server_<%= resID %>, menus_<%= resID %>, dirs_<%= resID %>, behave_<%= resID %>;

                    xhr("<%= data%>", {
                        handleAs: "json"
                    }).then(function(_data) {
                        console.log(_data.paths);
                        //Create server tree
                        if (_data.sites) server_<%= resID %> = new TreeWidget(_data.sites, 'serverTree_<%= resID %>', _data.sitesRoot);
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

                    topic.subscribe("adminFilter_<%= resID %>/nodechange", function(args) {
                        var state = args.state || false;
                        if (args.node) {
                            state ? args.node.disableChilds() : args.node.enableChilds();
                            state ? dojo.addClass(args.node.labelNode, "styleChecked") : dojo.removeClass(args.node.labelNode, "styleChecked");
                            state && dojo.removeClass(args.node.labelNode, "styleHighlight");
                            args.node.isExpanded && args.node.highlightParents(state);    
                        }
                    });
                    topic.subscribe("adminFilter_<%= resID %>/nodeexpand", function(args) {
                        if (args.node.isCheckboxActive()) {
                            args.node.disableChilds();
                        }
                    });
                    topic.subscribe("adminFilter_<%= resID %>/update", function(args) {
                        var xhrhttp = new XMLHttpRequest(), payload = {id: <%= af.getId() %>};
                        xhrhttp.open("POST", '<%= save %>', true);
                        xhrhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

                        if (server_<%= resID %>.getSelectedItems().total > 0) {
                            payload.server = server_<%= resID %>.getSelectedItems();
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
                        console.log(payload);
                        xhrhttp.send(JSON.stringify(payload));
                        xhrhttp.onreadystatechange = function() {
                            if (xhrhttp.readyState == 4 && xhrhttp.status == 200) {
                              console.log(xhrhttp.responseText);
                            }
                        };
                    });
                });
            </script>
        </div>
    </div>
</div>