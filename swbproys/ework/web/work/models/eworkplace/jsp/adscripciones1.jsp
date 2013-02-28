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
<%!
    List<UserGroupable> listUsers(UserGroup ug) {
        return SWBUtils.Collections.copyIterator(ug.listUsers());
    }
%>
<%
    String siteid = "eworkplace";
    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if(site==null) {
        out.println("sitio nulo");
        return;
    }
    UserRepository ur = site.getUserRepository();
    if(ur==null) {
        out.println("repositio nulo");
        return;
    }
    
    UserGroup myOU = null;
    User user = ur.getUserByLogin("carlos.ramos");
    if(user==null) {
        out.println("usuario nulo");
        return;
    }
       
    
    UserGroup corporativo = ur.getUserGroup("OU:Corporativo");
    if(corporativo!=null) {
        out.println("<p>los hijos de corporativo: "+corporativo+"</p>");
        UserGroup us;
        Iterator<UserGroup> it = corporativo.listChilds();
        out.println("<ul>");
        while(it.hasNext()) {
            us = it.next();
            out.println("<li>");            
            out.println("usergroup="+us);            
            if(user.hasUserGroup(us)) {
                myOU = us;
                out.println("......ya tengo OU........");
            }
            out.println("</li>");
        }
        out.println("</ul>");
    }else {
        out.println("corporativo es nulo");
    }
           
    if(myOU!=null) {
        out.println("<p>los hijos de myOU: "+myOU+"</p>");
        List<UserGroupable> users = new ArrayList<UserGroupable>();
        UserGroup us;
        Iterator<UserGroup> it = myOU.listAllChilds();
        out.println("<ul>");
        while(it.hasNext()) {
            us = it.next();
            users.addAll(listUsers(us));
            if(us.equals(myOU)) {
                continue;
            }
            out.println("<li>");            
            out.println("usergroup="+us);
            out.println("</li>");
        }
        out.println("</ul>");
        
        out.println("<p>lista de usuarios en myOU: "+myOU+"</p>");
        out.println("<ul>");
        Iterator<UserGroupable> usgs = users.iterator();
        while(usgs.hasNext()) {
            user = (User)usgs.next();
            out.println("<li>");            
            out.println("*user = "+user.getFullName());
            out.println("</li>");
        }
        out.println("</ul>");
    }
    
    
    
    
%>
    </body>
</html>
