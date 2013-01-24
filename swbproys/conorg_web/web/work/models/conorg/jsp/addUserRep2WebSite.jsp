<%-- 
    Document   : addUserRep
    Created on : 23/01/2013, 01:54:00 PM
    Author     : juan.fernandez
--%>

<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.model.UserRepository"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String wsid = request.getParameter("wsid");
    String error = "";
    String act = request.getParameter("act");
    if(act==null) act="";
    WebSite ws = null;
    if (wsid != null) {
        ws = SWBContext.getWebSite(wsid);
        if (ws == null) {
            error = "No se encontró ningún sitio con el ID: " + wsid;
        }
    }

    String result = "";
    if (error.trim().length() > 0) {
%>
<script type="text/javascript">
    alert('<%=error%>');
</script>
<%
    } 
    
    if(act.equals("createrepo")){
        try {
            createUserRep(wsid);
            assignUserRep2WebSite(ws, wsid);
            addDefaultUserRole(wsid);
            result = "El Repositorio de usuario se creo sin problemas. Se creo rol y usuario administrador.";
        } catch (Exception e) {
            result = "Error al crear repositorio de usuarios.";
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignar Repositorio de Usuarios</title>
    </head>
    <body>
        <%
            if (act.equals("createrepo")){
        %>
        <h1>Resultado</h1>
        <h2><%=result%></h2>
        <hr/>
        <%
                   }
        %>
        <h3>Creación y Asignación de repositorio de usuarios</h3>
        <form method="post">
            <input type="hidden" name="act" value="createrepo"/>
            <label>Identificador del sitio: <input type="text" name="wsid"/></label>
            <button type="submit">Crear y asignar</button>
        </form>
    </body>
</html>
<%!
//CREACION DE REPOSITORIO DE USUARIOS
    void createUserRep(String usrRepId) {

        //System.out.println("rep id:"+usrRepId);
        //Crea repositorio de usuarios
        UserRepository newUsrRep = null;

        if (usrRepId != null) { //Utilizara un repositorio exclusivo
            newUsrRep = SWBContext.getUserRepository(usrRepId + "_usr");
            if (newUsrRep == null) {
                newUsrRep = SWBContext.createUserRepository(usrRepId + "_usr", "http://user." + usrRepId + ".swb#");
                newUsrRep.getSemanticObject().getModel().setTraceable(false);
                newUsrRep.setTitle("Repositorio de usuarios(" + usrRepId + ")");
                newUsrRep.setTitle("Repositorio de usuarios(" + usrRepId + ")", "es");
                newUsrRep.setTitle("Users Repository(" + usrRepId + ")", "en");
                newUsrRep.setUndeleteable(true);
                newUsrRep.setAuthMethod("FORM");
                newUsrRep.setLoginContext("swb4TripleStoreModule");
                newUsrRep.setCallBackHandlerClassName("org.semanticwb.security.auth.SWB4CallbackHandlerLoginPasswordImp");
            }
            if (newUsrRep != null) {
                newUsrRep.getSemanticObject().getModel().setTraceable(true);
            }
        }
    }

//ASIGNACIÓN DE REPOSITORIO DE USUARIOS AL SITIO
    void assignUserRep2WebSite(WebSite site, String usrRepId) {
        String usrreptemp = usrRepId;
        usrreptemp = usrreptemp + "_usr";
        site.getSemanticObject().getModel().setTraceable(false);
        //Revisa repositorio de usuarios para el sitio
        UserRepository exitUsrRep = SWBContext.getUserRepository(usrreptemp);
        site.setUserRepository(exitUsrRep);
        // para que sea exclusivo
        site.addSubModel(exitUsrRep);
    }

    //AGREGANDO ELEMENTOS ROLES Y USUARIOS AL REPOSITORIO DE USUARIOS
    void addDefaultUserRole(String usrRepId) {
        String usrreptemp = usrRepId;
        usrreptemp = usrreptemp + "_usr";

        if (usrRepId != null && usrRepId.trim().length() > 0) {
            //creación de rol
            UserRepository urep = SWBContext.getUserRepository(usrreptemp);
            org.semanticwb.model.Role swbr = org.semanticwb.model.Role.ClassMgr.createRole("conorgAdmin", urep);
            swbr.setTitle("Administrador Conorg");
            swbr.setDescription("Role para administrar Conorg");
            swbr.setTitle("Administrador Conorg", "es");
            // creacion de usuario
            org.semanticwb.model.User usr = org.semanticwb.model.User.ClassMgr.createUser("adminConorg", urep);
            usr.setLogin("adminConorg");
            usr.setPassword("adminConorg");
            usr.setFirstName("Administrador");
            usr.setLastName("CONORG");
            usr.setLanguage("es");
            usr.setEmail("");
            usr.setActive(Boolean.TRUE);
            // agregando rol al usuario
            usr.addRole(swbr);
        }
    }

%>