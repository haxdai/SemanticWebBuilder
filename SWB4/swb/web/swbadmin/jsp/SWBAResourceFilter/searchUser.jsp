<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.UserRepository"%>
<%@page import="java.util.UUID"%>
<%@page import="org.semanticwb.model.GenericObject"%>
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
String resID = UUID.randomUUID().toString().replace("-","_");
UserRepository urep = UserRepository.ClassMgr.getUserRepository(request.getParameter("repId"));
System.out.println(urep);
SWBResourceURL data = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode("gateway").setAction("getFilter");
data.setParameter("suri", request.getParameter("suri"));

SWBResourceURL save = paramRequest.getActionUrl().setAction("updateFilter");
save.setParameter("suri", request.getParameter("suri"));

User user = SWBContext.getAdminUser();

if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite()) && null != user) {
    String usrdata = "[]";
    if(null != urep) {
        Iterator<User> users = urep.listUsers();
        if (users.hasNext()){
            usrdata = "[";
            
            while(users.hasNext()) {
                User usr = users.next();
                usrdata+="{\"id\":\""+usr.getId()+"\",";
                usrdata+="\"login\":\""+usr.getLogin()+"\",";
                usrdata+="\"firstName\":\""+usr.getLastName()+"\",";
                if (null != usr.getSecondLastName() && !usr.getSecondLastName().isEmpty()) {
                    usrdata+="\"lastName\":\""+usr.getSecondLastName()+"\",";
                }
                usrdata+="\"name\":\""+usr.getFirstName()+"\"}";
                if (users.hasNext()) usrdata+=",";
            }
            
            usrdata+="]";
        }
    }
    System.out.println(usrdata);
    %>
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/enhanced/resources/EnhancedGrid.css" rel="stylesheet" />
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
            <form id="searchForm_<%= resID %>" data-dojo-type="dijit/form/Form" action="<%= paramRequest.getRenderUrl() %>" onsubmit="submitForm('searchForm_<%= resID %>'); return false;">
                <select id="repCombo_<%= resID %>" name="repId" data-dojo-type="dijit/form/Select">
                    <option value="-1">Seleccione un repositorio</option>
                    <%
                    Iterator<UserRepository> repos = SWBContext.listUserRepositories();
                    while(repos.hasNext()) {
                        UserRepository repo = repos.next();
                        %>
                        <option value="<%= repo.getId() %>" <%= null != urep && urep.getURI().equals(repo.getURI()) ? "selected=\"selected\"" : "" %>><%= repo.getDisplayTitle("es") %></option>
                        <%
                    }
                    %>
                </select>
                <button data-dojo-type="dijit/form/Button" type="submit">Cargar usuarios</button>
                <button id="editFilter_<%= resID %>" data-dojo-type="dijit/form/Button" type="button">Editar filtro</button>
            </form>
        </div>
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'center', splitter:false" style="width:500px;">
            <div id="users_<%= resID %>"></div>
            <script type="dojo/method">
            require(['dojo/store/Memory','dojo/data/ObjectStore', 
                    'dojo/domReady!', 'dojo/dom', 'dojo/request/xhr', 
                    'dojox/grid/EnhancedGrid', 'dijit/form/Button', 
                    'dijit/registry', 'dojox/grid/enhanced/plugins/Filter',
                    'dojo/on', 'dojox/grid/enhanced/plugins/IndirectSelection'],
            function(Memory, ObjectStore, ready, dom, xhr, EnhancedGrid, Button, registry, Filter, on) {
                function GridWidget (_data, structure, container, useFilter) {
                    var store = new ObjectStore({ objectStore:new Memory({ data: _data }) });
                    var cfg = {
                        store: store,
                        query: {id:"*"},
                        selectionMode: "multiple",
                        structure: structure,
                        //rowSelector: '20px',
                        keepSelection: true,
                        plugins: {
                            indirectSelection: true
                        }
                    };

                    if (useFilter) {
                        cfg.plugins.filter = {ruleCount: 1};
                    }
                    var grid = new EnhancedGrid(cfg, container);

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
                
                on(dom.byId('editFilter_<%= resID %>'), "click", function(evt) {
                    var repSelect = registry.byId('repCombo_<%= resID %>');
                    submitUrl('<%= paramRequest.getRenderUrl().setAction("editFilter") %>?repId='+repSelect.value,this);
                    evt.preventDefault(); 
                });

                var data = <%= usrdata %>;
                if (data.length) {
                    var users_<%= resID %> = new GridWidget(data, 
                    [
                        /*{ name: "Utilizar", field: "_item", width: "10%", filterable: false,
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
                        },*/
                        { name: "Login", field: "login", width: "20%", datatype:"string" },
                        { name: "Apellido paterno", field: "firstName", width: "20%", datatype:"string" },
                        { name: "Apellido materno", field: "lastName", width: "20%", datatype:"string" },
                        { name: "Nombre", field: "name", width: "20%", datatype:"string" }
                    ], "users_<%= resID %>", true);
                }
            });
            </script>
        </div>
    </div>
<%
}%>