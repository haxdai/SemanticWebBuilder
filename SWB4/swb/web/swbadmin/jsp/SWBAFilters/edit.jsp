<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.model.SWBModel"%>
<%@page import="org.semanticwb.model.UserRepository"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="java.io.File"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getFilter");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateFilter");
save.setParameter("suri", request.getParameter("suri"));
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
<div data-dojo-type="dijit/layout/ContentPane">
    <div data-dojo-type="dijit/form/Button" data-dojo-props="iconClass:'dijitEditorIcon dijitEditorIconSave', showLabel: false" type="button">
        <script type="dojo/on" data-dojo-event="click" data-dojo-args="evt">
            require(['dojo/topic'], function(topic) {
                topic.publish("adminFilter/update");
                evt.preventDefault();
                evt.stopPropagation();
            });
        </script>
    </div>
    <div id="mainPanel" data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height:100%;">
        <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre sitios" data-dojo-props="selected:true">
            <div class="adminFilterTree" id="serverTree"></div>
        </div>
        <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre menus">
            <div class="adminFilterTree" id="menuTree"></div>
        </div>
        <div data-dojo-type="dijit/layout/ContentPane" title="Configuración de vista">
            <div class="adminFilterTree" id="viewTree"></div>
        </div>
        <div data-dojo-type="dijit/layout/ContentPane" title="Documentos del servidor">
            <div class="adminFilterTree" id="filesTree"></div>
        </div>
        <script type="dojo/method">
            require(['dojo/store/Memory','dijit/tree/ObjectStoreModel', 'dijit/Tree', 'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 'dojox/widget/Standby', 'dojo/topic'], function(Memory, ObjectStoreModel, Tree, ready, dom, xhr, StandBy, topic) {
                var standby = new StandBy({target: "mainPanel"});
                document.body.appendChild(standby.domNode);
                standby.startup();
                standby.show();
        
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
                            topic.publish("adminFilter/nodechange", {node: tnode, state: obj.target.checked});
                            var theItem = tnode.item;
                            theItem.selected=obj.target.checked;
                            store.put(theItem);
                            console.log(theItem);
                            obj.stopPropagation()
                        });

                        return tnode;
                    };
                
                    if (treeData && treeData.length) {
                        store = new Memory({
                            data: treeData,
                            getChildren: function(object) {
                                return this.query({parent: object.id});
                            },
                            getSelectedChilds: function() {
                                return this.query({selected: true});
                            }
                        });

                        model = new ObjectStoreModel({
                            store: store,
                            query: {id: rootId},
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
                                topic.publish("adminFilter/nodeexpand", {node: _node, item: _item});
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
                
                var server, menus, dirs, behave;
            
                xhr("<%= data%>", {
                    handleAs: "json"
                }).then(function(_data) {
                    //Create server tree
                    if (_data.sites) server = new TreeWidget(_data.sites, 'serverTree', 'Server');
                    server.getSelectedItems();
                    //Create menues tree
                    if (_data.menus) {
                        _data.menus.push({id:'WBAd_Menus', name:'Menus'});
                        menus = new TreeWidget(_data.menus, 'menuTree', 'WBAd_Menus');
                    }
                
                    //Create behaviours tree
                    if (_data.elements) {
                        _data.elements.push({id:'ObjectBehavior', name:'Comportamientos'});
                        behave = new TreeWidget(_data.elements, 'viewTree', 'ObjectBehavior');
                    }
                
                    //Create files tree
                    if (_data.dirs) {
                        dirs = new TreeWidget(_data.dirs, 'filesTree', '<%= (new File(SWBUtils.getApplicationPath())).getName()%>');
                    }
                    standby.hide();
                }, function(err){
                    console.log("error");
                });
                
                topic.subscribe("adminFilter/nodechange", function(args) {
                    var state = args.state || false;
                    if (args.node) {
                        state ? args.node.disableChilds() : args.node.enableChilds();
                        state ? dojo.addClass(args.node.labelNode, "styleChecked") : dojo.removeClass(args.node.labelNode, "styleChecked");
                        state && dojo.removeClass(args.node.labelNode, "styleHighlight");
                        args.node.highlightParents(state);    
                    }
                });
                topic.subscribe("adminFilter/nodeexpand", function(args) {
                    if (args.node.isCheckboxActive()) {
                        args.node.disableChilds();
                    }
                });
                topic.subscribe("adminFilter/update", function(args) {
                    var xhrhttp = new XMLHttpRequest(), payload = {};
                    xhrhttp.open("POST", '<%= save %>', true);
                    xhrhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');

                    if (server.getSelectedItems().total > 0) {
                        payload.server = server.getSelectedItems();
                    }
                    if (menus.getSelectedItems().total > 0) {
                        payload.menus = menus.getSelectedItems();
                    }
                    if (behave.getSelectedItems().total > 0) {
                        payload.behave = behave.getSelectedItems();
                    }
                    if (dirs.getSelectedItems().total > 0) {
                        payload.dirs = dirs.getSelectedItems();
                    }
                    
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