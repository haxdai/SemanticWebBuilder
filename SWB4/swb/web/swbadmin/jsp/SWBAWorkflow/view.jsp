<%-- 
    Document   : view
    Created on : 04-ago-2016, 16:25:14
    Author     : hasdai
--%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.io.File"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.PFlow"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
PFlow af = (PFlow) SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
String resID = af.getId();

SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getFilter");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateFilter");
save.setParameter("suri", request.getParameter("suri"));
save.setParameter("id", resID);

User user = SWBContext.getAdminUser();
if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite()) && null != user) {
    %>
    <div id="container_<%= resID %>" data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
            <button id="saveButton_<%= resID %>" type="button"></button>
        </div>
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
            <div id="mainPanel_<%= resID %>" data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height:100%;">
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblPropsTab") %>" data-dojo-props="selected:true">
                    <div class="adminFilterTree" id="serverTree_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblRTypesTab") %>">
                    <div class="adminFilterTree" id="menuTree_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblActivitiesTab") %>">
                    <div class="adminFilterTree" id="viewTree_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblDesignTab") %>">
                    <div class="adminFilterTree" id="filesTree_<%= resID %>"></div>
                </div>
                <script type="dojo/method">
                    require(['dojo/store/Memory','dijit/tree/ObjectStoreModel', 
                        'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                        'dojox/widget/Standby', 'dijit/form/Button', 'dijit/registry'],
                    function(Memory, ObjectStoreModel, ready, dom, xhr, StandBy, Button, registry) {
                        var saveButton_<%= resID %>, standby = new StandBy({target: "container_<%= resID %>"});;

                        document.body.appendChild(standby.domNode);
                        standby.startup();
                        standby.show();
                        
                        saveButton_<%= resID %> = new Button({
                            label: "<%= paramRequest.getLocaleString("lblSave") %>",
                            iconClass:'dijitEditorIcon dijitEditorIconSave',
                            onClick: function(evt) {
                                /*var payload = {id: '<%= af.getId() %>'}, xhrhttp = new XMLHttpRequest(), btn = this;;
                                xhrhttp.open("POST", '<%= save %>', true);
                                xhrhttp.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
                                btn.busy(true);
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
                                };*/
                            }, 
                            busy: function(val) {
                                this.set("iconClass", val ? "dijitIconLoading" : "dijitEditorIcon dijitEditorIconSave");
                                this.set("disabled", val);
                            }
                        }, "saveButton_<%= resID %>").startup();

                        /*xhr("<%= data%>", {
                            handleAs: "json"
                        }).then(function(_data) {
                            standby.hide();
                        }, function(err){
                            alert("<%= paramRequest.getLocaleString("msgError") %>");
                        });*/
                    });
                </script>
            </div>
        </div>
    </div>
    <%
    }
%>