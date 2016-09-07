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
    <script>require(['dijit/Dialog', 'dijit/registry']);</script>
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/resources/Grid.css" rel="stylesheet" />
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/resources/soriaGrid.css" rel="stylesheet" />
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/css/fontawesome/font-awesome.css" rel="stylesheet" />
    <style>
        .soria .dojoxGridRowOver .dojoxGridCell {
            background-color: none !important;
            color: black !important;
        }
    </style>
    <div id="addActivityDialog_<%= resID %>" data-dojo-type="dijit.Dialog" title="Agregar actividad" execute="alert('submitted w/args:\n' + dojo.toJson(arguments[0], true));">
        <div class="swbform">
            <div id="addActivityTabContainer_<%= resID %>" data-dojo-type="dijit.layout.TabContainer" style="width: 400px; height: 300px;">
                <div data-dojo-type="dijit.layout.ContentPane" title="Propiedades" id="propertiesPane_<%= resID %>">
                    <fieldset>
                        <table>
                            <tr>
                                <td>
                                    <label>Nombre:</label>
                                </td>
                                <td>
                                    <input name="title" id="title" data-dojo-type="dijit.form.TextBox"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>Descripción:</label>
                                </td>
                                <td>
                                    <textarea name="description" id="description" data-dojo-type="dijit.form.Textarea"></textarea>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <fieldset><legend>Duración</legend>
                        <table>
                            <tr>
                                <td>
                                    <label>Días:</label>
                                </td>
                                <td>
                                    <input name="days" id="days" data-dojo-type="dijit.form.TextBox" style="width:3em;"/>
                                </td>
                                <td>
                                    <label>Horas:</label>
                                </td>
                                <td>
                                    <input name="hours" id="hours" data-dojo-type="dijit.form.TextBox" style="width:3em;"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </div>
                <div data-dojo-type="dijit.layout.ContentPane" title="Usuarios">
                    <div id="activityUsers_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit.layout.ContentPane" title="Roles">
                    <div id="activityRoles_<%= resID %>"></div>
                </div>
            </div>
            <fieldset>
                <button data-dojo-type="dijit.form.Button" type="submit">Aceptar</button>
                <button id="addActivityDialogCancel_<%= resID %>">Cancelar</button>
            </fieldset>
        </div>
    </div>
    <div id="container_<%= resID %>" data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
            <button id="saveButton_<%= resID %>" type="button"></button>
            <div style="float: right;"><b><%= paramRequest.getLocaleString("lblFlowVersion") %>:</b><span id="filterVersion_<%= resID %>"></span></div>
        </div>
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
            <div id="mainPanel_<%= resID %>" data-dojo-type="dijit/layout/TabContainer" style="width: 100%; height:100%;">
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblRTypesTab") %>" data-dojo-props="selected:true">
                    <div id="resourceTypes_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="<%= paramRequest.getLocaleString("lblDesignTab") %>">
                    <div data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
                        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
                            <svg
   xmlns:svg="http://www.w3.org/2000/svg"
   xmlns="http://www.w3.org/2000/svg"
   version="1.1"
   id="svg2"
   viewBox="0 0 1212.0243 252.29062"
   height="35.202019mm"
   width="342.06018mm">
  <defs
     id="defs4" />
  <g
     transform="translate(-155.98444,-182.10917)"
     id="layer1">
    <rect
       transform="scale(1,-1)"
       y="-370.34192"
       x="156.48444"
       height="122.85714"
       width="85.714287"
       id="rect4138"
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1" />
    <rect
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1"
       id="rect4140"
       width="85.714287"
       height="122.85714"
       x="311.03778"
       y="-370.34192"
       transform="scale(1,-1)" />
    <rect
       transform="scale(1,-1)"
       y="-370.34192"
       x="468.62155"
       height="122.85714"
       width="85.714287"
       id="rect4142"
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1" />
    <path
       id="path4144"
       d="m 195.96959,246.26047 c 0,0 18.19012,-62.69462 78.7919,-63.63961 64.78084,-1.01016 79.80205,63.63961 79.80205,63.63961"
       style="opacity:1;fill:none;fill-opacity:1;stroke:#008000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1" />
    <path
       style="opacity:1;fill:none;fill-opacity:1;stroke:#008000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1"
       d="m 355.96959,246.26047 c 0,0 18.19012,-62.69462 78.7919,-63.63961 64.78084,-1.01016 79.80205,63.63961 79.80205,63.63961"
       id="path4146" />
    <path
       style="opacity:1;fill:none;fill-opacity:1;stroke:#ff0000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1"
       d="m 195.96959,370.24849 c 0,0 18.19012,62.69462 78.7919,63.63961 64.78084,1.01016 79.80205,-63.63961 79.80205,-63.63961"
       id="path4148" />
    <rect
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1"
       id="rect4147"
       width="85.714287"
       height="122.85714"
       x="603.98199"
       y="-370.34192"
       transform="scale(1,-1)" />
    <rect
       transform="scale(1,-1)"
       y="-370.34192"
       x="755.50488"
       height="122.85714"
       width="85.714287"
       id="rect4149"
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1" />
    <rect
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1"
       id="rect4151"
       width="85.714287"
       height="122.85714"
       x="922.18005"
       y="-370.34192"
       transform="scale(1,-1)" />
    <rect
       transform="scale(1,-1)"
       y="-370.34192"
       x="1092.8959"
       height="122.85714"
       width="85.714287"
       id="rect4153"
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1" />
    <rect
       style="opacity:1;fill:none;fill-opacity:1;stroke:#000000;stroke-width:1;stroke-linecap:butt;stroke-linejoin:miter;stroke-miterlimit:4;stroke-dasharray:none;stroke-dashoffset:0;stroke-opacity:1"
       id="rect4155"
       width="85.714287"
       height="122.85714"
       x="1281.7944"
       y="-370.34192"
       transform="scale(1,-1)" />
  </g>
</svg>




                        </div>
                        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
                            <button id="addActivity_<%= resID %>" type="button"></button><button id="addASequence_<%= resID %>" data-dojo-type="dijit/form/Button" type="button">Agregar secuencia</button>
                            <div id="activities_<%= resID %>"></div>
                        </div>
                    </div>
                </div>
                <script type="dojo/method">
                    require(['dojo/store/Memory','dojo/data/ObjectStore', 
                        'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                        'dojox/widget/Standby', 'dijit/form/Button', 'dijit/registry',
                        'dojox/grid/DataGrid', 'dijit/form/CheckBox'],
                    function(Memory, ObjectStore, ready, dom, xhr, StandBy, Button, registry, DataGrid, CheckBox) {
                        var saveButton_<%= resID %>, standby = new StandBy({target: "container_<%= resID %>"}),
                            rtypesGrid_<%= resID %>, activitiesGrid_<%= resID %>;
                        document.body.appendChild(standby.domNode);
                        standby.startup();
                        standby.show();
                        
                        var createActions = function (rowObj) {
                            console.log(rowObj);
                            var div = document.createElement("div");
    
                            var btn = new Button({
                                iconClass: "fa fa-pencil",
                                showLabel: false,
                                name: "idBtn"
                            });

                            var btn2 = new Button({
                                showLabel: false,
                                iconClass: "fa fa-arrow-up",
                                name: "idBtn2"
                            });
                            
                            var btn3 = new Button({
                                showLabel: false,
                                iconClass: "fa fa-arrow-down",
                                name: "idBtn3"
                            });

                            div.appendChild(btn.domNode);
                            div.appendChild(btn2.domNode);
                            div.appendChild(btn3.domNode);
                            return div.innerHTML;
                        };
                        
                        function GridWidget (_data, structure, container) {
                            var store = new ObjectStore({ objectStore:new Memory({ data: _data }) });
                            var grid = new DataGrid({
                                store: store,
                                query: {id:"*"},
                                selectionMode: "none",
                                structure: structure,
                            }, container);

                            grid.startup();
                            
                            return {
                                getSelectedItems: function() {
                                    console.log("Get the selected items from store ");
                                    console.log(store);
                                },
                                selectItem: function(item) {
                                    
                                }
                            };
                        };
                        
                        var addActivity_<%= resID %> = new Button({
                            label: "Agregar actividad",
                            iconClass:'fa fa-plus-sign',
                            onClick: function(evt) {
                                registry.byId('addActivityDialog_<%= resID %>').show();
                            }
                        }, "addActivity_<%= resID %>").startup();
                        
                        new Button({
                            label: "Cancelar",
                            onClick: function(evt) {
                                registry.byId('addActivityDialog_<%= resID %>').hide();
                                registry.byId('addActivityDialog_<%= resID %>').reset();
                                registry.byId('addActivityTabContainer_<%= resID %>').selectChild(registry.byId('propertiesPane_<%= resID %>'));
                            }
                        }, "addActivityDialogCancel_<%= resID %>").startup();
                        
                        saveButton_<%= resID %> = new Button({
                            label: "<%= paramRequest.getLocaleString("lblSave") %>",
                            iconClass:'dijitEditorIcon dijitEditorIconSave',
                            onClick: function(evt) {
                                
                            }, 
                            busy: function(val) {
                                this.set("iconClass", val ? "dijitIconLoading" : "dijitEditorIcon dijitEditorIconSave");
                                this.set("disabled", val);
                            }
                        }, "saveButton_<%= resID %>").startup();

                        activityUsers_<%= resID %> = new GridWidget([{id:"e.sanchez"},{id:"c.lopez"},{id:"l.sanchez"}], 
                            [
                                { name: "Acciones", field: "_item", formatter: createActions, width: "10%" },
                                { name: "id", field: "id", width: "20%" }
                            ], "activityUsers_<%= resID %>");

                        xhr("<%= data %>", {
                            handleAs: "json"
                        }).then(function(_data) {
                            dom.byId("filterVersion_<%= resID %>").innerHTML = _data.version;
                            
                            rtypesGrid_<%= resID %> = new GridWidget(_data.resourceTypes, 
                                [
                                    { name: "Utilizar", field: "_item", width: "5%",
                                        formatter: function(item) {
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
                                    },
                                    { name: "Tipo de recurso", field: "name", width: "20%" },
                                    { name: "Descripción", field: "description", width: "30%" }
                                ], "resourceTypes_<%= resID %>");
                            
                                activitiesGrid_<%= resID %> = new GridWidget(_data.activities, 
                                [
                                    { name: "Acciones", field: "_item", formatter: createActions, width: "10%" },
                                    { name: "Actividad", field: "name", width: "20%" },
                                    { name: "Descripción", field: "description", width: "20%" },
                                    { name: "Usuarios", field: "_item", width: "20%" },
                                    { name: "Roles", field: "_item", width: "20%" }
                                ], "activities_<%= resID %>");
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