<%-- 
    Document   : importUsers
    Created on : 06-mar-2012, 13:20:32
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.SWBUserMgr"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.io.File"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>append UG</title>
    </head>
    <body>
<h3>iniciando appendLang....</h3>
<%!
    public enum CAMPOS
    {
        RFC, CURP, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NOMBRE, EMAIL, ADSCRIPCION, TIPO_CONTRATACION, PERFIL, NUM_EMPLEADO
    };
%>
<%
    String path = SWBPortal.getWorkPath() + "/db.txt";
    String siteid = "eworkplace";

    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if (site != null)
    {
        Iterator<User> users = site.getUserRepository().listUsers();
        while(users.hasNext()) {
            User user = users.next();
            if(user!=null)
            {
%>
<p>usuario <%=(user.getFullName())%></p>
<%
                user.setLanguage("es");
            }
        }
    }
%>
<p>Fin de modificacion de usuarios</p>
<%
    out.flush();
%>
    </body>
</html>