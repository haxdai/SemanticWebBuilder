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
SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getElements");
%>
<style>
    .noIcon {
        display: none !important;
    }
    
    /*#myTree > .soria .dijitTreeIcon {
      display:none !important;
    }

    #myTree .soria .dijitTree:focus {
      outline: 0;
    }

    #myTree .soria .dijitTreeLabel:focus {
      outline: 0;
    }

    #myTree .soria .dijitTreeRowSelected .dijitTreeLabel {
      background: none !important;
      outline: 0 !important;
    }*/

</style>
<div id="mainPanel" data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height:100%;">
    <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre sitios" data-dojo-props="selected:true">
        <div id="serverTree"></div>
    </div>
    <div data-dojo-type="dijit/layout/ContentPane" title="Filtro sobre menus">
        <div id="menuTree"></div>
    </div>
    <div data-dojo-type="dijit/layout/ContentPane" title="Configuración de vista">
        <div id="viewTree"></div>
    </div>
    <div data-dojo-type="dijit/layout/ContentPane" title="Documentos del servidor">
        <div id="filesTree"></div>
    </div>
    <script type="dojo/method">
        require(['dojo/store/Memory','dijit/tree/ObjectStoreModel', 'dijit/Tree', 'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr'], function(Memory, ObjectStoreModel, Tree, ready, dom, xhr) {            
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
                        if (obj) {
                            console.log("Must disable node childs and call filter update");
                            console.log(tnode.getChildren());
                        } else {
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
                console.log("getElements");
                console.log(_data);
                _data && _data.push({id:'ObjectBehavior', name:'Comportamientos'});
                new TreeWidget(_data, 'viewTree', 'ObjectBehavior');
            }, function(err){
                console.log("error");
            });
            
            xhr("<%= data.setAction("getMenus") %>", {
                handleAs: "json"
            }).then(function(_data) {
                console.log("getMenus");
                console.log(_data);
                _data && _data.push({id:'WBAd_Menus', name:'Menus'});
                new TreeWidget(_data, 'menuTree', 'WBAd_Menus');
            }, function(err){
                console.log("error");
            });
            
            xhr("<%= data.setAction("getDirectories") %>", {
                handleAs: "json"
            }).then(function(_data) {
                console.log("getDirectories");
                console.log(_data);
                new TreeWidget(_data, 'filesTree', '<%= (new File(SWBUtils.getApplicationPath())).getName() %>');
            }, function(err){
                console.log("error");
            });
            
            xhr("<%= data.setAction("getServer") %>", {
                handleAs: "json"
            }).then(function(_data) {
                console.log("getServer");
                console.log(_data);
                //_data && _data.push({id:'ObjectBehavior', name:'Comportamientos'});
                new TreeWidget(_data, 'serverTree', 'Server');
                //console.log(_data);
            }, function(err){
                console.log("error");
            });
        });
        </script>
</div>