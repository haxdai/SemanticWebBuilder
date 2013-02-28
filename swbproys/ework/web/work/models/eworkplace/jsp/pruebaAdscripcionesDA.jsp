<%-- 
    Document   : pruebaAdscripcionesDA
    Created on : 11-feb-2013, 13:13:49
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.platform.*"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="java.util.*"%>
<%@page import="org.json.*"%>
<%@page import="static com.infotec.eworkplace.swb.resources.SWProfileManager.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>estructura de adscripciones</h1>
        
<%
    String siteid = "eworkplace";
    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if(site==null) {
        out.println("sitio nulo");
        return;
    }
    UserRepository ur = site.getUserRepository();
    //Role subgerente = ur.getRole("Subgerente");
    //Role gerente = ur.getRole("Gerente");
    //Role director = ur.getRole("Director");
    //UserGroup infotec = ur.getUserGroup("Empleado_exsitu");
    UserGroup corporativo = ur.getUserGroup("OU:Corporativo");
    if(corporativo!=null) {
        UserGroup us;
        Iterator<UserGroup> it = corporativo.listAllChilds();
        out.println("<ul>");
        while(it.hasNext()) {
            us = it.next();
            out.println("<li>");            
            out.println("usergroup="+us);
            out.println("<ul>");
            UserGroupable userg;
            User user;
            Iterator<UserGroupable> u = us.listUsers();
            while(u.hasNext()) {
                userg = u.next();
                if(userg instanceof User) {
                    user = (User)userg;
                    out.println("<li>");
                    out.println(user.getEmail()+"---"+user.getFirstName());
                    out.println("</li>");
                }
            }
            out.println("</ul>");
            
            out.println("</li>");
        }
        out.println("</ul>");
    }else {
        out.println("corporativo es nulo");
    }
%>
    </body>
</html>
