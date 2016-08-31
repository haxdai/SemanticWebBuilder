<%@page import="org.semanticwb.platform.SemanticObject"%>
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
UserRepository urep = (UserRepository)SWBPlatform.getSemanticMgr().getOntology().getGenericObject(request.getParameter("suri"));
User user = SWBContext.getAdminUser();
if (SWBContext.getAdminWebSite().equals(paramRequest.getWebPage().getWebSite()) && null != user) {
    String usrdata = "[]";
    if (null != urep) {
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
    %>
    <link href="<%= SWBPortal.getContextPath() %>/swbadmin/js/dojo/dojox/grid/enhanced/resources/EnhancedGrid.css" rel="stylesheet" />
    <div id="afcontainer_<%= resID %>" data-dojo-type="dijit/layout/BorderContainer" data-dojo-props="gutters:true, liveSplitters:false">
        <div data-dojo-type="dijit/layout/ContentPane" data-dojo-props="region:'top', splitter:false">
            <form id="searchForm_<%= resID %>" data-dojo-type="dijit/form/Form" action="<%= paramRequest.getRenderUrl() %>" onsubmit="submitForm('searchForm_<%= resID %>'); return false;">
                <select id="repCombo_<%= resID %>" name="suri" data-dojo-type="dijit/form/Select">
                    <option value="-1">Seleccione un repositorio</option>
                    <%
                    Iterator<UserRepository> repos = SWBContext.listUserRepositories();
                    while(repos.hasNext()) {
                        UserRepository repo = repos.next();
                        %>
                        <option value="<%= repo.getURI() %>" <%= null != urep && urep.getURI().equals(repo.getURI()) ? "selected=\"selected\"" : "" %>><%= repo.getDisplayTitle("es") %></option>
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
                        var store = new ObjectStore({ objectStore:new Memory({ data: _data }) }), grid;
                        var cfg = {
                            store: store,
                            query: {id:"*"},
                            selectionMode: "multiple",
                            structure: structure,
                            keepSelection: true,
                            plugins: {
                                indirectSelection: true
                            }
                        };

                        if (useFilter) {
                            cfg.plugins.filter = {ruleCount: 1};
                        }
                        
                        grid = new EnhancedGrid(cfg, container);
                        grid.startup();

                        return {};
                    };

                    on(dom.byId('editFilter_<%= resID %>'), "click", function(evt) {
                        var repSelect = registry.byId('repCombo_<%= resID %>'), grid = registry.byId('users_<%= resID %>');
                        var items, ids = [];

                        if (repSelect && grid) {
                            items = grid.selection.getSelected();
                            if (items.length) {
                                ids = dojo.map(items, function(item) {
                                    return item.id;
                                });

                                ids = ids.join("|");
                            }
                            submitUrl('<%= paramRequest.getRenderUrl().setAction("editFilter") %>?suri='+encodeURIComponent(repSelect.value)+'&ids='+ids,this);
                            console.log(grid.selection.getSelected());
                        }
                        evt.preventDefault(); 
                    });

                    var data = <%= usrdata %>;
                    if (data.length) {
                        var users_<%= resID %> = new GridWidget(data, 
                        [
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
}
%>