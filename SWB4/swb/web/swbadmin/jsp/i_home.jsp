<%@page contentType="text/html"%>
<%@page pageEncoding="ISO8859-1"%>
<%@page import="org.semanticwb.*,org.semanticwb.platform.*,org.semanticwb.model.*,java.util.*,org.semanticwb.base.util.*"%>
<%
    response.setHeader("Cache-Control", "no-cache"); 
    response.setHeader("Pragma", "no-cache"); 
    SemanticVocabulary voc=SWBPlatform.getSemanticMgr().getVocabulary();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
         "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>iUI Music Demo</title>
<meta name="viewport" content="width=320; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;"/>
<style type="text/css" media="screen">@import "/swb/swbadmin/js/iui/iui.css";</style>
<script type="application/x-javascript" src="/swb/swbadmin/js/iui/iui.js"></script>
</head>

<body onclick="">
    <div class="toolbar">
        <h1 id="pageTitle"></h1>
        <a id="backButton" class="button" href="#"></a>
        <a class="button" href="#searchForm">Search</a>
    </div>
    
    <ul id="home" title="SemWB Admin" selected="true">
        <li><a href="#sites">Sitios</a></li>
        <li><a href="#userreps">Repositorios de usuarios</a></li>
    </ul>
    <ul id="sites" title="Sitios">
<%
    Iterator<WebSite> sites=SWBContext.listWebSites();
    while(sites.hasNext())
    {
        WebSite site=sites.next();
%>
        <li><a href="i_object.jsp?suri=<%=site.getEncodedURI()%>"><%=site.getTitle()%></a></li>
<%        
    }
%>        
    </ul>
    
    <ul id="userreps" title="Sitios">
<%
    Iterator<UserRepository> usrreps=SWBContext.listUserRepositorys();
    while(usrreps.hasNext())
    {
        UserRepository urep=usrreps.next();
%>
        <li><a href="i_object.jsp?suri=<%=urep.getSemanticObject().getEncodedURI()%>"><%=urep.getTitle()%></a></li>
<%        
    }
%>        
    </ul>
    
</body>
</html>

