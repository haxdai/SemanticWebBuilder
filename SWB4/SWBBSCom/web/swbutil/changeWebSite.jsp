<%-- 
    Document   : changeWebSite
    Created on : 13/06/2011, 06:24:16 PM
    Author     : ciri
--%>
<%@page import="java.util.Iterator"%>
<%@page import="com.hp.hpl.jena.rdf.model.Resource"%>
<%@page import="com.hp.hpl.jena.vocabulary.RDF"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change website</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<%
    WebSite site=SWBContext.getWebSite("SWBGlobal");
    out.println(site);
 
    site.getSemanticObject().getRDFResource().addProperty(RDF.type, site.getSemanticModel().getRDFModel().getResource("http://www.semanticwebbuilder.org/swb4/ontology#WebSite"));
    site.getSemanticModel().getRDFModel().remove(site.getSemanticObject().getRDFResource(), RDF.type, site.getSemanticModel().getRDFModel().getResource("http://www.semanticwebbuilder.org/swb4/bsc#BSC"));

    Iterator it=site.getSemanticObject().getRDFResource().listProperties();
    out.println("<p>lista de propiedades:</p>");
    out.println("<ul>");
    while (it.hasNext())
    {
        out.println("<li>");
        Object elem = it.next();
        out.println(elem);
        out.println("</li>");
    }
    out.println("</ul>");
%>
    </body>
</html>
