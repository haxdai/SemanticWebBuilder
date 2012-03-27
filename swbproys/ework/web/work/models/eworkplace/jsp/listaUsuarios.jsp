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
<%!
    public enum CAMPOS
    {
        USUARIO, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NOMBRE, EMAIL
    };
%>
<p><%=(CAMPOS.USUARIO.name())%>,<%=(CAMPOS.PRIMER_APELLIDO.name())%>,<%=(CAMPOS.SEGUNDO_APELLIDO.name())%>,<%=(CAMPOS.NOMBRE.name())%>,<%=(CAMPOS.EMAIL.name())%></p>
<hr/>
<%
    
    String siteid = "eworkplace";

    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if(site != null)
    {
        int c=0;
        Iterator<User> users = site.getUserRepository().listUsers();
        while (users.hasNext())
        {
            User user = users.next();
            if(user==null)
                continue;
            c++;
%>
<p><%=user.getLogin()%>,<%=user.getLastName()%>,<%=user.getSecondLastName()%>,<%=user.getFirstName()%>,<%=user.getEmail()%></p>
<%
        }
%>
<hr/>
<p>total de usuarios:<%=Integer.toString(c)%></p>
<%
    }
    out.flush();
%>