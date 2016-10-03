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
String resID = af.getId();

SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getWorkflow");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateWorkflow");
save.setParameter("suri", request.getParameter("suri"));
save.setParameter("id", resID);

User user = SWBContext.getAdminUser();
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
            width: 100%;
        }
    </style>
    <div id="addActivityDialog_<%= resID %>" data-dojo-type="dijit.Dialog" title="Agregar actividad">
        <div class="swbform">
            <div id="addActivityTabContainer_<%= resID %>" data-dojo-type="dijit.layout.TabContainer" style="width: 400px; height: 300px;">
                <div data-dojo-type="dijit.layout.ContentPane" title="Propiedades" id="propertiesPane_<%= resID %>">
                    <form data-dojo-type="dijit.form.Form" id="addActivity_form<%= resID %>">
                        <fieldset>
                            <table>
                                <tr>
                                    <td>
                                        <label>Nombre:</label>
                                    </td>
                                    <td>
                                        <input name="name" id="name<%= resID %>" data-dojo-type="dijit.form.TextBox"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label>Descripción:</label>
                                    </td>
                                    <td>
                                        <textarea name="description" id="description<%= resID %>" data-dojo-type="dijit.form.Textarea"></textarea>
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
                                        <input name="days" id="days<%= resID %>" data-dojo-type="dijit.form.TextBox" style="width:3em;"/>
                                    </td>
                                    <td>
                                        <label>Horas:</label>
                                    </td>
                                    <td>
                                        <input name="hours" id="hours<%= resID %>" data-dojo-type="dijit.form.TextBox" style="width:3em;"/>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </form>
                </div>
                <div data-dojo-type="dijit.layout.ContentPane" title="Usuarios">
                    <div id="activityUsers_<%= resID %>"></div>
                </div>
                <div data-dojo-type="dijit.layout.ContentPane" title="Roles">
                    <div id="activityRoles_<%= resID %>"></div>
                </div>
            </div>
            <fieldset>
                <button id="addActivityDialogOk_<%= resID %>">Aceptar</button>
                <button id="addActivityDialogCancel_<%= resID %>">Cancelar</button>
            </fieldset>
        </div>
    </div>
    
    <!-- Transition Dialog -->
    <div id="addTransitionDialog_<%= resID %>" data-dojo-type="dijit.Dialog" title="Agregar secuencia">
        <div class="swbform">
            <div id="addTransitionTabContainer_<%= resID %>" data-dojo-type="dijit.layout.TabContainer" style="width: 400px; height: 300px;">
                <div data-dojo-type="dijit.layout.ContentPane" title="Transición" id="infoPane_<%= resID %>">
                    <form data-dojo-type="dijit.form.Form" id="addTransition_form<%= resID %>">
                        <fieldset>
                            <table>
                                <tr>
                                    <td>
                                        <input name="name2" type="radio" data-dojo-type="dijit.form.RadioButton"/><label>Terminar flujo</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" data-dojo-type="dijit.form.CheckBox"/><label>Publicar automáticamente</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="checkbox" data-dojo-type="dijit.form.CheckBox"/><label>Autorizado</label>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                        <fieldset>
                            <table>
                                <tr>
                                    <td>
                                        <input name="name2" type="radio" data-dojo-type="dijit.form.RadioButton"/><label>Enviar al autor del contenido</label>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                        <fieldset>
                            <table>
                                <tr>
                                    <td>
                                        <input name="name2" type="radio" data-dojo-type="dijit.form.RadioButton"/><label>Enviar a otra actividad</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <select name="nextAct" id="nextAct<%= resID %>" data-dojo-type="dijit/form/Select">
                                        </select>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </form>
                </div>
                <div data-dojo-type="dijit.layout.ContentPane" title="Avisos">
                    <div id="notifications_<%= resID %>">
                        <div data-dojo-type="dijit.layout.TabContainer" style="width: 400px; height: 300px;">
                            <div data-dojo-type="dijit.layout.ContentPane" title="Usuarios">
                                <div id="sequenceNotificationUsers_<%= resID %>"></div>
                            </div>
                            <div data-dojo-type="dijit.layout.ContentPane" title="Roles">
                                <div id="sequenceNotificationRoles_<%= resID %>"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <fieldset>
                <button >Aceptar</button>
                <button >Cancelar</button>
            </fieldset>
        </div>
    </div>
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
                <script type="dojo/method">
                    require({packages: [{name: "d3",location: "<%= SWBPlatform.getContextPath() %>/swbadmin/js/d3/",main: "d3"}]}, 
                        ['d3', 'dojo/store/Memory','dojo/data/ObjectStore', 
                        'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                        'dojox/widget/Standby', 'dijit/form/Button', 'dijit/registry',
                        'dojox/grid/EnhancedGrid', 'dijit/form/CheckBox', 'dojo/dom-construct',
                        'dojox/grid/enhanced/plugins/IndirectSelection'],
                    function(d3, Memory, ObjectStore, ready, dom, xhr, StandBy, Button, registry, EnhancedGrid, CheckBox, domConstruct) {
                        var saveButton_<%= resID %>, standby = new StandBy({target: "container_<%= resID %>"}),
                            rtypesGrid_<%= resID %>, activitiesGrid_<%= resID %>, dialogData<%= resID %>, activitiesGrid<%= resID %>,
                            activitiesModel<%= resID %>, startX = 40, w = 40, h = 50;
                        document.body.appendChild(standby.domNode);
                        standby.startup();
                        standby.show();
                        
                        function guid() {
                            function s4() {
                                return Math.floor((1 + Math.random()) * 0x10000)
                                    .toString(16)
                                    .substring(1);
                            }
                            return s4() + s4() + '-' + s4() + '-' + s4() + '-' + s4() + '-' + s4() + s4() + s4();
                        };
                        
                        //DataModel Object
                        function PFlowDataModel (nodes, links) {
                            var _items = nodes, _links = links;
                            
                            function setCoordinates() {
                                _items.forEach(function(item, idx) {
                                    console.log(item);
                                    item.x = idx * 2 * w + startX;
                                    item.y = 50;
                                });
                            };
                            
                            if (_items.length > 2) {
                                var tmp = _items[_items.length - 2];
                                _items.splice(2,1);
                                _items.splice(0,0,tmp);
                            }
                            
                            setCoordinates();
                            
                            return {
                                getItems: function(filter) {
                                    if (filter && typeof filter == "function") {
                                        return _items.filter(filter);
                                    }
                                    return _items;
                                },
                                addItem: function(item, idx) {
                                    if (item !== undefined) {
                                        if(!item.hasOwnProperty("uuid")) {
                                            item.uuid = guid();
                                        }
                                        _items.splice(_items.length - 1, 0, item);
                                    }
                                    setCoordinates();
                                    return this;
                                },
                                removeItem: function (uuid) {
                                    var idx = _items.findIndex(function(item) { return item.uuid === uuid; });
                                    if (idx > -1) {
                                        var ret = _items.splice(idx, 1)[0];
                                        setCoordinates();
                                        return ret;
                                    }
                                    return undefined;
                                },
                                getItem: function(uuid) {
                                    return _items.find(function(item) { return item.id === uuid; });
                                },
                                getItemByName: function(iname) {
                                    return _items.find(function(item) { return item.name === iname; });
                                },
                                getItemIndex: function(uuid) {
                                    return _items.findIndex(function(item) { return item.id === uuid; });
                                },
                                swapItems: function(index1, index2) {
                                    var tmp = _items[index1];
                                    _items[index1] = _items[index2];
                                    _items[index2] = tmp;
                                    setCoordinates();
                                },
                                getItems4Select: function() {
                                    var t =  _items.filter(function(item){return item.type==="Activity"}).map(function(item) {
                                        return {
                                            label: item.name,
                                            value: item.uuid,
                                            selected: false
                                        }
                                    });
                                    return t;
                                },
                                getLinks: function(linkType) {
                                    if (linkType) {
                                        return _links.filter(function(item){return item.type===linkType});
                                    }
                                    
                                    return _links;
                                }
                            }
                        }
                        
                        function hideDialog(dialog) {
                            registry.byId(dialog).reset();
                            registry.byId(dialog).hide();
                        };
                        
                        function showAddDialog() {
                            dialogData<%= resID %> = {};
                            registry.byId('addActivityDialog_<%= resID %>').show();
                        };
                        
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
                            
                            //Add item to grid store
                            activitiesModel<%= resID %>.addItem(payload);
                            updateViews();
                            
                            //Close dialog and update activity select in sequence dialog
                            hideDialog('addActivityDialog_<%= resID %>');
                        }
                        
                        function renderGraph() {
                            d3.select("#svgContainer svg").remove();
                            var acts = activitiesModel<%= resID %>.getItems();
                            var svgContainer = d3.select("#svgContainer").append("svg");
                            var defs = svgContainer.append("defs");
                                
                            var reviewer = defs.append("g")
                                .attr("id", "book")
                                .attr("transform", "translate(0,-1001.8766)");
                            
                            reviewer.append("path")
                                .attr("d", "m 6.0264005,1046.7649 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -33.22907463,-20.2925 29.77758063,0 9.516387,9.7216 0,39.5724 -39.29396763,0 z m 29.68429763,0.1135 0,9.7014 9.608209,0")
                                .attr("fill", "white")
                                .attr("stroke", "black");
                        
                            reviewer.append("path")
                                .attr("d", "m 19.403859,1018.2197 c -5.977286,-8e-4 -10.8230216,4.845 -10.8222646,10.8222 3.21e-4,5.9766 4.8457416,10.8211 10.8222646,10.8204 1.310261,-0 2.609336,-0.2412 3.833985,-0.7071 1.278681,-0.6057 2.111197,-0.8486 3.0625,-1.7871 2.481982,-2.053 3.920306,-5.1051 3.923828,-8.3262 7.57e-4,-5.9765 -4.84379,-10.8219 -10.820313,-10.8222 z m 6.896485,19.1484 c -0.915625,0.7601 -1.950347,1.3639 -3.0625,1.7871 l 5.486328,9.7344 3.08789,-1.7402 z")
                                .attr("fill", "white")
                                .attr("stroke", "black");
                            
                            var publish = defs.append("g")
                                .attr("id", "bookOk")
                                .attr("transform", "translate(0,-1001.8766)");
                            
                            publish.append("path")
                                .attr("d", "m 6.0264005,1046.7649 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -27.7985085,-6 27.7985085,0 m -33.22907463,-20.2925 29.77758063,0 9.516387,9.7216 0,39.5724 -39.29396763,0 z m 29.68429763,0.1135 0,9.7014 9.608209,0")
                                .attr("fill", "white")
                                .attr("stroke", "black");
                        
                            publish.append("path")
                                .attr("d", "m 5.5970149,1032.5861 9.5149251,10.2612 19.029851,-23.8806")
                                .attr("fill", "none")
                                .attr("stroke", "red")
                                .attr("stroke-width", "3");

                            var publisher = defs.append("g")
                                .attr("id", "bookPublisher")
                                .attr("transform", "translate(0,-1001.8766)");
                        
                            publisher.append("path")
                                .attr("d", "m 30.280132,1002.5859 0,9.7014 9.608209,0 m -39.29250663,-9.8149 29.77758063,0 9.516387,9.7216 0,39.5724 -39.29396763,0 z m 5.43056613,20.2925 27.7985085,0 m -27.7985085,6 27.7985085,0 m -27.7985085,6 27.7985085,0 m -27.7985085,6 27.7985085,0 m -27.7985085,6 27.7985085,0")
                                .attr("fill", "white")
                                .attr("stroke", "black");
                            publisher.append("path")
                                .attr("d", "m 20.244038,1023.5071 -3.434804,5.9468 -3.432363,5.9468 4.301439,0 0,10.4925 5.129016,0 0,-10.4925 4.301439,0 -3.432363,-5.9468 -3.432364,-5.9468 z")
                                .attr("fill", "white")
                                .attr("stroke", "green");
                        
                            
                            var g = svgContainer.selectAll("groups")
                                .data(acts)
                                .enter()
                                .append("g")
                                .attr("transform", function(d, i) {
                                    return "translate("+d.x+", "+d.y+")";
                                });
                            
                            var test = g.append("use")
                                .attr("xlink:href", function(item) {
                                    if (item.type==="Activity") {
                                        return "#book";
                                    } else if (item.type==="AuthorActivity") {
                                        return "#bookPublisher";
                                    } else if (item.type==="EndActivity") {
                                        return "#bookOk";
                                    }
                                })
                                .on("dblclick", function(d){console.log("editing...");})
                                .append("svg:title")
                                    .text(function(d) { return d.name });
                                
                            var labels = g.append("text")
                                .attr("text-anchor", "middle")
                                .attr("x", function(d) {
                                    return w/2;
                                })
                                .attr("y", "13")
                                    .text(function(d, i){return i > 0 && i < acts.length - 1 ? i : null});
                            
                            /*activitiesModel<%= resID %>.getLinks().forEach(function(item) {
                                if (item.type==="authorized") {
                                    console.log("from:"+item.from);
                                    console.log(activitiesModel<%= resID %>.getItemByName(item.from));
                                    console.log(activitiesModel<%= resID %>.getItemByName(item.from).x);
                                    console.log("to:"+item.to);
                                    console.log(activitiesModel<%= resID %>.getItemByName(item.to));
                                    console.log(activitiesModel<%= resID %>.getItemByName(item.to).x);
                                }
                            });*/
                                
                                var acceptFlows = svgContainer.selectAll("paths")
                                    .data(activitiesModel<%= resID %>.getLinks())
                                    .enter()
                                    .append("path")
                                    .on("dblclick", function(d){console.log("editing...");})
                                    .attr("d", function(d, i) {
                                        var fromX = activitiesModel<%= resID %>.getItemByName(d.from).x;
                                        var toX = activitiesModel<%= resID %>.getItemByName(d.to).x;
                                        
                                        if (fromX > toX) {
                                            var tmp = fromX;
                                            fromX = toX;
                                            toX = tmp;
                                        }
                                        
                                        if (d.type === "authorized") {
                                            return "M"+(fromX + w/2)+",50 A"+(toX-fromX)+",130 0 0,1 "+(toX + w/2)+",50";
                                        } else if (d.type === "unauthorized") {
                                            return "M"+(fromX + w/2)+",100 A"+(toX-fromX)+",130 0 0,0 "+(toX + w/2)+",100";
                                        }
                                        return null;
                                    })
                                    .attr("fill", "none")
                                    .attr("stroke", function(d){ return d.type === "authorized" ? "green" : "red"})
                                    .attr("stroke-width", 3);
                                    //.attr("marker-end", "url(#markerArrow)");
                            
                                /*var rejectFlows = svgContainer.selectAll("paths")
                                    .data(activitiesLinks<%= resID %>.filter(function(d){return d.type==="unauthorized"}))
                                    .enter()
                                    .append("path")
                                    .on("dblclick", function(d){console.log("editing...");})
                                    .attr("d", function(d, i) {
                                        var xt = i * 2 * w;
                                        return "M"+(xt + w/2)+","+2*h+" A80,130 0 0,0 "+(xt + 2.5 *w)+","+2*h;
                                    })
                                    .attr("fill", "none")
                                    .attr("stroke", "red")
                                    .attr("stroke-width", 3);*/
                        };
                        
                        function updateViews() {
                            registry.byId('nextAct<%= resID %>').set("options", activitiesModel<%= resID %>.getItems4Select()).reset();
                            activitiesGrid<%= resID %>.init();
                            renderGraph();
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
                        
                        function GridWidget (_data, structure, container, sortKeys) {
                            var store = new ObjectStore({ objectStore:new Memory({ data: _data }) });
                            var options = {
                                store: store,
                                query: {id:"*"},
                                selectionMode: "multiple",
                                structure: structure,
                                keepSelection: true,
                                plugins: {
                                    indirectSelection: true
                                }
                            };
                            
                            var grid = new EnhancedGrid(options, container);
                            grid.startup();
                            grid.render();
                            
                            return {
                                updateData: function(_data) {
                                    store = new ObjectStore({ objectStore:new Memory({ data: _data }) });
                                    grid.setStore(store);
                                    grid.render();
                                },
                                addRowItem: function(item) {
                                    if (item) {
                                        item.uuid = guid();
                                        store.newItem(item);
                                        grid.render();
                                    }
                                },
                                getItems4Select: function() {
                                    if (store.objectStore.data.length) {
                                        return store.objectStore.data.map(function(item) {
                                            return {
                                                label: item.name,
                                                value: item.uuid,
                                                selected:false
                                            }
                                        });
                                    }
                                    return [];
                                }
                            };
                        };

                        var addActivity_<%= resID %> = new Button({
                            label: "Agregar actividad",
                            iconClass:'fa fa-plus',
                            onClick: function(evt) {
                                showAddDialog();
                            }
                        }, "addActivity_<%= resID %>").startup();

                        var addSequence_<%= resID %> = new Button({
                            label: "Agregar secuencia",
                            iconClass:'fa fa-plus',
                            onClick: function(evt) {
                                registry.byId('addTransitionDialog_<%= resID %>').show();
                            }
                        }, "addSequence_<%= resID %>").startup();

                        new Button({
                            label: "Cancelar",
                            onClick: function(evt) {
                                registry.byId('addActivityDialog_<%= resID %>').hide();
                                registry.byId('addActivityDialog_<%= resID %>').reset();
                                registry.byId('addActivityTabContainer_<%= resID %>').selectChild(registry.byId('propertiesPane_<%= resID %>'));
                            }
                        }, "addActivityDialogCancel_<%= resID %>").startup();

                        new Button({
                            label: "Aceptar",
                            onClick: function(evt) {
                                saveAddDialogData();
                                evt.preventDefault();
                            }
                        }, "addActivityDialogOk_<%= resID %>").startup();

                        saveButton_<%= resID %> = new Button({
                            label: "<%= paramRequest.getLocaleString("lblSave") %>",
                            iconClass:'fa fa-save',
                            onClick: function(evt) {

                            }, 
                            busy: function(val) {
                                this.set("iconClass", val ? "dijitIconLoading" : "dijitEditorIcon dijitEditorIconSave");
                                this.set("disabled", val);
                            }
                        }, "saveButton_<%= resID %>").startup();

                        xhr("<%= data %>", {
                            handleAs: "json"
                        }).then(function(_data) {
                            dom.byId("filterVersion_<%= resID %>").innerHTML = _data.version;

                            rtypesGrid_<%= resID %> = new GridWidget(_data.resourceTypes, 
                                [
                                    { name: "Tipo de recurso", field: "name", width: "20%" },
                                    { name: "Descripción", field: "description", width: "30%" }
                                ], "resourceTypes_<%= resID %>");

                                activitiesModel<%= resID %> = new PFlowDataModel(_data.activities, _data.links);
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
                        new GridWidget(usrData, 
                            [
                                { name: "Usuario", field: "login", width: "80%" }
                            ], "activityUsers_<%= resID %>");

                        new GridWidget(roleData, 
                            [
                                { name: "Rol", field: "name", width: "80%" }
                            ], "activityRoles_<%= resID %>");

                        new GridWidget(usrData, 
                            [
                                { name: "Usuario", field: "login", width: "80%" }
                            ], "sequenceNotificationUsers_<%= resID %>");

                        new GridWidget(roleData, 
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