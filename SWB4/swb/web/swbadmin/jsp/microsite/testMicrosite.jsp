<%@page import="java.util.*" %>
<%@page import="org.semanticwb.model.*" %>
<%@page import="org.semanticwb.portal.community.*" %>
<%-- 
    Document   : testMicrosite
    Created on : 19/11/2009, 03:07:52 PM
    Author     : javier.solis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
    boolean clear=false;
    if("true".equals(request.getParameter("clear")))clear=true;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DirecroyObjects</h1>
<%
        {
            WebSite site=SWBContext.getWebSite("cd");
            Iterator<DirectoryObject> it=DirectoryObject.ClassMgr.listDirectoryObjects(site);
            while(it.hasNext())
            {
                DirectoryObject obj=it.next();
                if(clear)obj.remove();
                out.println(obj);
            }
        }
%>
        <h1>MicroSites</h1>
<%
        {
            WebSite site=SWBContext.getWebSite("cd");
            Iterator<MicroSite> it=MicroSite.ClassMgr.listMicroSites(site);
            while(it.hasNext())
            {
                MicroSite obj=it.next();
                if(clear)obj.remove();
                out.println(obj);
            }
        }

%>
        <h1>MicroSiteElements</h1>
<%
        {
            WebSite site=SWBContext.getWebSite("cd");
            Iterator<MicroSiteElement> it=MicroSiteElement.ClassMgr.listMicroSiteElements(site);
            while(it.hasNext())
            {
                MicroSiteElement obj=it.next();
                if(clear)obj.remove();
                out.println(obj);
            }
        }

%>
    </body>
</html>
