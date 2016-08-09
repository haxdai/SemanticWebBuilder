<%-- 
    Document   : view
    Created on : 04-ago-2016, 16:25:14
    Author     : hasdai
--%>
<%@page import="org.semanticwb.SWBPortal"%>
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

SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getWorkflow");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateWorkflow");
save.setParameter("suri", request.getParameter("suri"));
save.setParameter("id", resID);

User user = SWBContext.getAdminUser();
if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite()) && null != user) {
    %>
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/resources/Grid.css" rel="stylesheet" />
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/resources/soriaGrid.css" rel="stylesheet" />
    <style>
        .soria .dojoxGridRowOver .dojoxGridCell {
            background-color: none !important;
            color: black !important;
        }
    </style>
    <div id="container_<%= resID %>" data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
            <button id="saveButton_<%= resID %>" type="button"></button>
        </div>
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
            <div id="mainPanel_<%= resID %>" data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height:100%;">
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblPropsTab") %>" data-dojo-props="selected:true">
                    <div class="swbform">
                        <fieldset>
                            <table>
                                <tbody>
                                    <tr>
                                        <td><b>Nombre:</b></td>
                                        <td id="filterName_<%= resID %>">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td><b>Descripción:</b></td>
                                        <td id="filterDesc_<%= resID %>"></td>
                                    </tr>
                                    <tr>
                                        <td><b>Versión:</b></td>
                                        <td id="filterVersion_<%= resID %>">&nbsp;</td>
                                    </tr>
                                </tbody>
                            </table>
                        </fieldset>
                    </div>
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblRTypesTab") %>">
                    <div id="resourceTypes_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblActivitiesTab") %>">
                    <div class="adminFilterTree" id="viewTree_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblDesignTab") %>">
                    <div class="adminFilterTree" id="filesTree_<%= resID %>"></div>
                </div>
                <script type="dojo/method">
                    require(['dojo/store/Memory','dojo/data/ObjectStore', 
                        'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                        'dojox/widget/Standby', 'dijit/form/Button', 'dijit/registry',
                        'dojox/grid/DataGrid', 'dijit/form/CheckBox'],
                    function(Memory, ObjectStore, ready, dom, xhr, StandBy, Button, registry, DataGrid, CheckBox) {
                        var saveButton_<%= resID %>, standby = new StandBy({target: "container_<%= resID %>"});;
                        var storeResTypes_<%= resID %>;
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

                        xhr("<%= data %>", {
                            handleAs: "json"
                        }).then(function(_data) {
                            storeResTypes_<%= resID %> = new ObjectStore({ objectStore:new Memory({ data: _data.resourceTypes }) });
                            
                            console.log(dom.byId("filterName_<%= resID %>"));
                            dom.byId("filterName_<%= resID %>").innerHTML = _data.name;
                            dom.byId("filterDesc_<%= resID %>").innerHTML = _data.description;
                            dom.byId("filterVersion_<%= resID %>").innerHTML = _data.version;
                            
                            var grid = new DataGrid({
                                store: storeResTypes_<%= resID %>,
                                query: {id:"*"},
                                selectionMode: "none",
                                structure: [
                                    {
                                        name: "Tipo de recurso", 
                                        field: "name", width: "33%"
                                    },
                                    {
                                        name: "Descripción",
                                        field: "description", width: "33%"
                                    },
                                    {
                                        name: "Utilizar", field: "_item", width: "33%",
                                        formatter: function(item) {
                                            console.log(item);
                                            var w = new CheckBox({
                                                label:"Check",
                                                checked: item.selected,
                                                onClick: function (evt) {
                                                    if (evt.target.checked) {
                                                        console.log("Must enable item in store");
                                                        item.selected = true;
                                                    } else {
                                                        console.log("Must disable item in store");
                                                        item.selected = false;
                                                    }
                                                }
                                            });
                                            w._destroyOnRemove=true;
                                            return w;
                                        }
                                    }
                                ]
                            }, "resourceTypes_<%= resID %>");

                            grid.startup();
                            
                        }, function(err){
                            alert("<%= paramRequest.getLocaleString("msgError") %>");
                        });
                        standby.hide();
                    });
                </script>
            </div>
        </div>
    </div>
    <%
    }
%>