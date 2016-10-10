<%-- 
    Document   : view
    Created on : 04-ago-2016, 16:25:14
    Author     : hasdai
--%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.UserRepository"%>
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
String resID = af.getWebSite().getId()+"_"+af.getId();

SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getWorkflow");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateWorkflow");
save.setParameter("suri", request.getParameter("suri"));
save.setParameter("id", resID);

User user = SWBContext.getAdminUser();
String pathAct = SWBPlatform.getContextPath()+"/swbadmin/jsp/SWBAWorkflow/activity.jsp";
String pathTrans = SWBPlatform.getContextPath()+"/swbadmin/jsp/SWBAWorkflow/transition.jsp";

if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite()) && null != user) {
    %>
    <script>require(['dijit/Dialog', 'dijit/registry', 'dijit/form/Select']);</script>
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/enhanced/resources/EnhancedGrid.css" rel="stylesheet" />
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/resources/soriaGrid.css" rel="stylesheet" />
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/css/fontawesome/font-awesome.css" rel="stylesheet" />
    <style>
        .soria .dojoxGridRowOver .dojoxGridCell {
            background-color: none !important;
            color: black !important;
        }
        
        .activityTable {
            width: 100%;
        }
        
        .activityTable th {
            width:20%;
            padding: 5px;
        }
        
        .activityTable th.actions {
            width:10% !important;
        }
        
        .activityTable th.steps {
            width:5% !important;
        }
        
        .activityTable tbody tr:nth-child(even) {
           background-color: #E1EBFB;
        }
        
        rect.docActivity {
            -webkit-user-select: none; /* webkit (safari, chrome) browsers */
            -moz-user-select: none; /* mozilla browsers */
            -khtml-user-select: none; /* webkit (konqueror) browsers */
            -ms-user-select: none; /* IE10+ */
        }
        
        div#svgContainer {
            width: 100%;
        }
        
        div#svgContainer svg {
            width: 1280px;
        }
    </style>
    <jsp:include page="<%= pathAct %>" />
    <jsp:include page="<%= pathTrans %>" />
    <div id="container_<%= resID %>" data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
            <button id="saveButton_<%= resID %>" type="button"></button>
            <button id="addActivity_<%= resID %>" type="button"></button>
            <button id="addSequence_<%= resID %>" type="button">Agregar secuencia</button>
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
                            <div id="svgContainer">
                                <svg></svg>
                            </div>
                        </div>
                        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false">
                            <table class="activityTable">
                                <thead>
                                    <tr>
                                        <th class="steps">Paso</th>
                                        <th class="actions"></th>
                                        <th>Actividad</th>
                                        <th>Descripción</th>
                                        <th>Usuarios</th>
                                        <th>Roles</th>
                                    </tr>
                                </thead>
                                <tbody id="activities_<%= resID %>"></tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <script type="dojo/method" src="<%= SWBPlatform.getContextPath() %>/swbadmin/jsp/SWBAWorkflow/workflow.js"></script>
                <script type="dojo/method">
                    require({packages: [
                            {
                                name: "d3",
                                location: "<%= SWBPlatform.getContextPath() %>/swbadmin/js/d3/",
                                main: "d3"
                            },
                            {
                                name: "workflow",
                                location: "<%= SWBPlatform.getContextPath() %>/swbadmin/jsp/SWBAWorkflow/",
                                main: "workflow"
                            }
                            ]}, 
                        ['d3','workflow', 'dojo/store/Memory','dojo/data/ObjectStore', 
                        'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                        'dojox/widget/Standby', 'dijit/form/Button', 'dijit/registry',
                        'dojox/grid/EnhancedGrid', 'dijit/form/CheckBox', 'dojo/dom-construct',
                        'dojox/grid/enhanced/plugins/IndirectSelection'],
                    function(d3, workflowApp, Memory, ObjectStore, ready, dom, xhr, StandBy, Button, registry, EnhancedGrid, CheckBox, domConstruct) {
                        var saveButton_<%= resID %>, standby = new StandBy({target: "container_<%= resID %>"}),
                            rtypesGrid_<%= resID %>, activitiesGrid_<%= resID %>, dialogData<%= resID %>, activitiesGrid<%= resID %>,
                            activitiesModel<%= resID %>, startX = 40, w = 40, h = 50;
                        document.body.appendChild(standby.domNode);
                        standby.startup();
                        standby.show();
                        
                        workflowApp.initUI("<%= resID %>");
                        
                        function saveAddDialogData() {
                            //Get form values
                            var payload = {};
                            payload = registry.byId('addActivity_form<%= resID %>').getValues();
                            payload.type = "Activity";

                            //Get selected users from users grid
                            var gd = registry.byId('activityUsers_<%= resID %>');
                            var items = gd.selection.getSelected();
                            if (items.length) {
                                payload.users = items.map(function(i) { return i.login; });
                            }
                            gd.selection.clear();

                            //Get selected roles from roles grid
                            gd = registry.byId('activityRoles_<%= resID %>');
                            var items = gd.selection.getSelected();
                            if (items.length) {
                                payload.roles = items.map(function(i) { return i.id; });
                            }
                            gd.selection.clear();
                            console.log(payload);
                            //Add item to grid store
                            activitiesModel<%= resID %>.addItem(payload);
                            updateViews();
                            
                            //Close dialog and update activity select in sequence dialog
                            hideDialog('addActivityDialog_<%= resID %>');
                        }
                        
                        function updateViews() {
                            registry.byId('nextAct<%= resID %>').set("options", activitiesModel<%= resID %>.getItems4Select()).reset();
                            registry.byId('fromAct<%= resID %>').set("options", activitiesModel<%= resID %>.getItems4Select()).reset();
                            activitiesGrid<%= resID %>.init();
                            workflowApp.renderFlow(activitiesModel<%= resID %>, "svgContainer");
                        };
                        
                        //Custom Table for activities
                        function DataTable (model, placeholder) {
                            var _model = model,
                                tpl = "<tr><td>__itemidx__</td><td><span id='__itemid__'></span></td><td>__name__</td><td>__desc__</td><td>__users__</td><td>__roles__</td></tr>";
                            
                            function render() {
                                domConstruct.empty(placeholder);
                                var finalItems = _model.getItems();
                                finalItems.forEach(function(item, idx) {
                                    var cuid = item.uuid.replace(/-/g,"_");
                                    var t = tpl.replace("__name__", item.name || "").replace("__desc__", item.description || "")
                                        .replace("__users__", item.users || "").replace("__roles__", item.roles || "")
                                        .replace("__itemid__", cuid).replace("__itemidx__", idx > 0 && idx < finalItems.length - 1 ? idx : "");
                                    var d = domConstruct.toDom(t);
                                    domConstruct.place(d, placeholder);

                                    //Create action buttons
                                    if (idx > 0 && idx < finalItems.length - 2) {
                                        var btn = new Button({
                                            iconClass: "fa fa-arrow-down",
                                            showLabel: false,
                                            onClick: function(evt) {
                                                _model.swapItems(idx + 1, idx);
                                                updateViews();
                                            }
                                        });
                                        btn._destroyOnRemove = true;
                                        //Place and start button separately because dojo fails when startup is done on create function
                                        dojo.place(btn.domNode, cuid, "last");
                                        btn.startup();
                                    }
                                    
                                    if (idx > 1 && idx < finalItems.length - 1) {
                                        var btn = new Button({
                                            iconClass: "fa fa-arrow-up",
                                            showLabel: false,
                                            onClick: function(evt) {
                                                _model.swapItems(idx - 1, idx);
                                                updateViews();
                                            }
                                        });
                                        
                                        btn._destroyOnRemove = true;
                                        dojo.place(btn.domNode, cuid, "last");
                                        btn.startup();
                                    }
                                    
                                    if (idx > 0 && idx < finalItems.length - 1) {
                                        var btn = new Button({
                                            iconClass: "fa fa-trash-o",
                                            showLabel: false,
                                            onClick: function(evt) {
                                                _model.removeItem(item.uuid);
                                                updateViews();
                                            }
                                        });

                                        btn._destroyOnRemove = true;
                                        dojo.place(btn.domNode, cuid, "last");
                                        btn.startup();
                                    }
                                });
                            };
                            
                            return {
                                init: function() {
                                    render();
                                    return this;
                                }
                            };
                        };

                        xhr("<%= data %>", {
                            handleAs: "json"
                        }).then(function(_data) {
                            dom.byId("filterVersion_<%= resID %>").innerHTML = _data.version;

                            rtypesGrid_<%= resID %> = workflowApp.createGridWidget(_data.resourceTypes, 
                                [
                                    { name: "Tipo de recurso", field: "name", width: "20%" },
                                    { name: "Descripción", field: "description", width: "30%" }
                                ], "resourceTypes_<%= resID %>");

                                activitiesModel<%= resID %> = workflowApp.createWorkFlowModel("activities", _data.activities, _data.links);//new PFlowDataModel(_data.activities, _data.links);
                                activitiesGrid<%= resID %> = new DataTable(activitiesModel<%= resID %>, 'activities_<%= resID %>').init();
                                updateViews();
                        }, function(err) {
                            alert("<%= paramRequest.getLocaleString("msgError") %>");
                        });
                        standby.hide();

                        //Create users and roles grid for Dialogs
                        <%
                        String usrdata = "[]";
                        UserRepository adminRep = SWBContext.getAdminRepository();
                        Iterator<User> adminUsers = adminRep.listUsers();
                        if (adminUsers.hasNext()) {
                            usrdata =  "[";
                            while (adminUsers.hasNext()) {
                                User usr = adminUsers.next();
                                usrdata+="{\"id\":\""+usr.getId()+"\",";
                                usrdata+="\"login\":\""+usr.getLogin()+"\"}";
                                if (adminUsers.hasNext()) usrdata+=",";
                            }
                            usrdata += "]";
                        }

                        String roledata = "[]";
                        Iterator<Role> adminRoles = adminRep.listRoles();
                        if (adminRoles.hasNext()) {
                            roledata =  "[";
                            while (adminRoles.hasNext()) {
                                Role role = adminRoles.next();
                                roledata+="{\"id\":\""+role.getId()+"\",";
                                roledata+="\"name\":\""+role.getTitle()+"\"}";
                                if (adminRoles.hasNext()) roledata+=",";
                            }
                            roledata += "]";
                        }

                        %>
                        var usrData = <%= usrdata %>;
                        var roleData = <%= roledata %>;
                        workflowApp.createGridWidget(usrData, 
                            [
                                { name: "Usuario", field: "login", width: "80%" }
                            ], "activityUsers_<%= resID %>");

                        workflowApp.createGridWidget(roleData, 
                            [
                                { name: "Rol", field: "name", width: "80%" }
                            ], "activityRoles_<%= resID %>");

                        workflowApp.createGridWidget(usrData, 
                            [
                                { name: "Usuario", field: "login", width: "80%" }
                            ], "sequenceNotificationUsers_<%= resID %>");

                        workflowApp.createGridWidget(roleData, 
                            [
                                { name: "Rol", field: "name", width: "80%" }
                            ], "sequenceNotificationRoles_<%= resID %>");
                    });
                </script>
            </div>
        </div>
    </div>
    <%
    }
%>