<%--
    Document   : view Recurso UserNotes
    Created on : 23/07/2012
    Author     : juan.fernandez
--%>

<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%
    org.semanticwb.model.User usr = paramRequest.getUser();
    String mynotes = usr.getProperty("mynotes","");
    SWBResourceURL url=paramRequest.getActionUrl();
%>

    <div id="notas">
    <h3>Mis notas</h3>
    <form name="usrNotes" action="<%=url%>" method="post">
        <a href="#" onclick="document.usrNotes.submit();">guardar</a>
    <div class="clear"></div>
    <textarea name="mynotes" cols="" rows=""><%=mynotes%></textarea>
    </form>
    </div>
