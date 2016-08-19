<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.ResourceFilter"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.io.File"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
ResourceFilter rf = null;
Resource res = (Resource) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
if (null != res) {
    rf = res.getResourceFilter();
}

String resID = rf.getId();

SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getFilter");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateFilter");
save.setParameter("suri", request.getParameter("suri"));
save.setParameter("id", resID);

User user = SWBContext.getAdminUser();
if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite()) && null != user) {
    %>
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dijit/tests/css/dijitTests.css" rel="stylesheet" />
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/form/resources/TriStateCheckBox.css" rel="stylesheet" />
    <style>
        .swbIconServer {
            background-repeat: no-repeat;
            width:20px;
            height: 18px;
            text-align: center;
            padding-right:0px;
            background-image: url('<%= SWBPortal.getContextPath() %>/swbadmin/icons/icons20x18.png'); background-position: -120px -197px;
        }
        .noIcon { display: none !important; }
        .resourceFilterTree .dijitTreeRowSelected .dijitTreeLabel { background: none !important; outline: none !important; }
        .resourceFilterTree .dijitTreeNodeFocused .dijitTreeLabel { background: none !important; outline: none !important; }
        .styleChecked { color: darkblue; font-style: italic; font-weight: bold !important; }
        .styleHighlight { font-style: italic; font-weight: bold !important; }
    </style>
    <div id="container_<%= resID %>" data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
            <button id="saveButton_<%= resID %>" type="button"></button>
            <input type="checkbox" data-dojo-type="dijit/form/CheckBox" />Dar acceso a elementos no seleccionados
        </div>
        <div class="resourceFilterTree claro" data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
            <div id="serverTree_<%= resID %>"></div>
            <script type="dojo/method">
                require(['dojo/store/Memory','dijit/tree/ObjectStoreModel', 
                    'dijit/Tree', 'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                    'dojox/widget/Standby', 'dojo/topic', 'dijit/form/Button', 'dijit/registry', 'dojox/form/TriStateCheckBox'],
                function(Memory, ObjectStoreModel, Tree, ready, dom, xhr, StandBy, topic, Button, registry, TriStateCheckBox) {
                    var server_<%= resID %>;
                    var saveButton_<%= resID %>, standby = new StandBy({target: "container_<%= resID %>"});;

                    document.body.appendChild(standby.domNode);
                    standby.startup();
                    //standby.show();

                    saveButton_<%= resID %> = new Button({
                        label: "Guardar filtro",
                        iconClass:'dijitEditorIcon dijitEditorIconSave',
                        onClick: function(evt) {
                            var payload = {id: '<%= rf.getId() %>'}, xhrhttp = new XMLHttpRequest(), btn = this;;
                            xhrhttp.open("POST", '<%= save %>', true);
                            xhrhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
                            btn.busy(true);
                            if (server_<%= resID %>.getSelectedItems().total > 0) {
                                payload.sites = server_<%= resID %>.getSelectedItems();
                            }

                            xhrhttp.send(JSON.stringify(payload));
                            xhrhttp.onreadystatechange = function() {
                                if (xhrhttp.readyState == 4) {
                                    if (xhrhttp.status == 200) {
                                        showStatus('<%= paramRequest.getLocaleString("msgUpdated") %>');
                                    } else {
                                        alert("<%= paramRequest.getLocaleString("msgError") %>");
                                    }
                                    btn.busy(false);
                                }
                            };
                        }, 
                        busy: function(val) {
                            this.set("iconClass", val ? "dijitIconLoading" : "dijitEditorIcon dijitEditorIconSave");
                            this.set("disabled", val);
                        }
                    }, "saveButton_<%= resID %>").startup();

                    //TODO: Mover la función de creación de árboles a una biblioteca para que el navegador no almacene la definición varias veces
                    function TreeWidget (treeData, siteId, placeHolder, rootId) {
                        var store, model;

                        function createTreeNode(args) {
                            var tnode = new dijit._TreeNode(args), cb;
                            tnode.labelNode.innerHTML = args.label;
                               
                            if (tnode.item.id !== "Server" && tnode.item.id !== siteId) {
                                cb = new TriStateCheckBox({
                                    states: ["mixed", false, true],
                                    checked: false
                                });
                                cb.placeAt(tnode.contentNode, "first");
                            }

                            tnode.getCheckboxState = function() { return cb ? cb.get("checked") : undefined; };
                            tnode.toggleCheckbox = function(val) { cb && cb.set("checked", val); };
                            tnode.toggleCheckBoxState = function(val) { cb.set("disabled", val || false); };
                            tnode.disableChilds = function() {
                                if (this.isExpanded) {
                                    var childs = this.getChildren();
                                    if (childs.length) {
                                        dojo.forEach(childs, function (child) {
                                            child.toggleCheckBoxState(true);
                                            dojo.removeClass(child.labelNode, "styleChecked");
                                            dojo.removeClass(child.labelNode, "styleHighlight");
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
                                            if (child.getCheckboxState() !== "mixed") {
                                                child.enableChilds();
                                            }
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

                            dojo.connect(cb, "onChange", function(obj) {
                                if ("mixed" === obj || true === obj) {
                                    tnode.item.selected = true;
                                }
                                
                                "mixed" === obj ? tnode.disableChilds() : tnode.enableChilds();
                                tnode.item.childs = ("mixed" === obj);
                                store.put(tnode.item);
                                //obj.target.checked ? dojo.addClass(tode.labelNode, "styleChecked") : dojo.removeClass(tode.labelNode, "styleChecked");
                                //obj.target.checked && dojo.removeClass(tnode.labelNode, "styleHighlight");
                            });

                            if(args.item.selected) {
                                tnode.toggleCheckbox(args.item.childs && args.item.childs === true ? "mixed" : true);
                                args.item.childs && args.item.childs === true ? tnode.disableChilds() : tnode.enableChilds();
                            }

                            return tnode;
                        };

                        if (treeData && treeData.length) {
                            store = new Memory({
                                data: treeData,
                                idProperty: "uuid",
                                getChildren: function(object) { return this.query({parent: object.uuid}); },
                                getSelectedChilds: function() { return this.query({selected: true, enabled: true}); }
                            });

                            model = new ObjectStoreModel({
                                store: store,
                                query: {uuid: rootId},
                                labelAttr: "name",
                                mayHaveChildren: function(item) { return model.store.getChildren(item).total > 0; },
                                getItemPath: function(id) {
                                    var ret = [], parent = undefined, query = this.store.query({uuid: id});
                                    if (query.total === 1) parent = query[0];

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
                                getIconClass: function(item, opened) { return item.cssIcon; },
                                getRowClass: function(item,opened) {},
                                _createTreeNode: createTreeNode,
                                onOpen: function(_item, _node) {
                                    //Si el nodo está seleccionado o el nodo está deshabilitado, deshabilitar los hijos
                                    if ("mixed" === _node.getCheckboxState() || _item.enabled === false) {
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
                        if (_data.topics) {
                            server_<%= resID %> = new TreeWidget(_data.topics, _data.id, 'serverTree_<%= resID %>', _data.sitesRoot);
                            server_<%= resID %>.onLoadDeferred.then(function() {
                                _data.paths && _data.paths.forEach(function(item, idx) {
                                    server_<%= resID %>.set('paths', [server_<%= resID %>.model.getItemPath(item)]);
                                });
                            });
                        }
                        standby.hide();
                    }, function(err){
                        alert("<%= paramRequest.getLocaleString("msgError") %>");
                    });
                });
            </script>
        </div>
    </div>
    <%
    }
%>