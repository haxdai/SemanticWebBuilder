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
</style>
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
                    //console.log("creating "+args.label);
                    var getChilds = function(item) {
                        var ret = [], ch = store.getChildren(item);
                        dojo.forEach(ch, function (child) {
                            ret.push(child);
                            ret = ret.concat(getChilds(child));
                        });
                        return ret;
                    };

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
                        _val && cb.set("disabled", _val);
                    };
                   

                    /*if (tnode.item.isActive) {
                      cb.set("checked", true);
                      //tnode.set("disabled", true);
                      //tnode.set("focusable", false);
                    }*/

                    dojo.connect(cb, "onChange", function(obj) {
                        topic.publish("my/topic", tnode);
                        if (obj) {
                            dojo.addClass(tnode.labelNode, "styleChecked");
                            console.log("Must disable node childs and call filter update");
                            console.log(tnode.getChildren());
                        } else {
                            dojo.removeClass(tnode.labelNode, "styleChecked");
                            console.log("Must enable node childs and call filter update");
                            console.log(tnode.getChildren());
                        }
                        //cb.set("disabled", true);
                    });

                    return tnode;
                };
                
                if (treeData && treeData.length) {
                    store = new Memory({
                        data: treeData,
                        getChildren: function(object) {
                          return this.query({parent: object.id});
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
                        getIconClass: function(item,opened) {
                            return "noIcon";
                        },
                        getRowClass: function(item,opened) {},
                        _createTreeNode: createTreeNode,
                        onOpen: function(item, node) { 
                            if (node.isCheckboxActive()) {
                                //Check childs
                                var childs = node.getChildren();
                                if (childs.length) {
                                    dojo.forEach(childs, function (child) {
                                        child.toggleCheckbox(false);
                                        child.toggleCheckBoxState(true);
                                    });
                                }
                            }
                        }
                    });
                    
                    ret.placeAt(placeHolder);
                    ret.startup();
                    return ret;
                }
                
                return {};
            };
            
            xhr("<%= data %>", {
                handleAs: "json"
            }).then(function(_data) {
                console.log(_data);
                //Create server tree
                _data.sites && new TreeWidget(_data.sites, 'serverTree', 'Server');
                
                //Create menues tree
                _data.menus && _data.menus.push({id:'WBAd_Menus', name:'Menus'});
                _data.menus && new TreeWidget(_data.menus, 'menuTree', 'WBAd_Menus');
                
                //Create behaviours tree
                _data.elements && _data.elements.push({id:'ObjectBehavior', name:'Comportamientos'});
                _data.elements && new TreeWidget(_data.elements, 'viewTree', 'ObjectBehavior');
                
                //Create files tree
                _data.dirs && new TreeWidget(_data.dirs, 'filesTree', '<%= (new File(SWBUtils.getApplicationPath())).getName() %>');
                standby.hide();
                
                topic.subscribe("my/topic", function(args) {
                    console.log("----");
                    console.log(args);
                });
            }, function(err){
                console.log("error");
            });
        });
        </script>
</div>