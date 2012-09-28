<%--
    Document   : view Recurso Avisos
    Created on : 06/08/2012
    Author     : juan.fernandez
--%>


<%@page import="com.infotec.conorg.resources.Back2WorkSpace"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%
    WebPage wpage = paramRequest.getWebPage();
    WebPage workSpace = Back2WorkSpace.findWorkSpaceParent(wpage);
     if(null==workSpace) return;
    WebPage wpurl = workSpace.getParent();
%>
<div id="back2ws" class="back2ws">
    <h3><a href="<%=wpurl.getUrl()+"?wsid="+workSpace.getId()%>"><%=workSpace.getTitle()%></a></h3>   
</div>
