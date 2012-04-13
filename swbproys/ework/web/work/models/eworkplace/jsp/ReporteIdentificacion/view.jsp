<%-- 
    Document   : view.jsp
    Created on : 2/04/2012, 06:54:34 PM
    Author     : rene.jara
--%><%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="com.infotec.cvi.swb.resources.reports.ReporteIdentificacion"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%//@page import="com.hp.hpl.jena.query.QuerySolution"%>
<%//@page import="com.hp.hpl.jena.query.ResultSet"%>
<%//@page import="com.hp.hpl.jena.query.QueryExecution"%>
<%//@page import="org.semanticwb.platform.SemanticModel"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
 //WebSite ws = paramRequest.getWebPage().getWebSite();
      //url = paramRequest.getActionUrl().setMode(ReporteIdentificacion.Mode_PRINT).toString();
    SWBResourceURL urlact = paramRequest.getRenderUrl().setMode(ReporteIdentificacion.Mode_PRINT);

%>
<div id="icv">
    <div id="icv-data">
        <ul>
            <li><a href="<%=urlact.setAction(ReporteIdentificacion.Action_REP_GENDER).toString()%>">Genero</a></li>
            <li><a href="<%=urlact.setAction(ReporteIdentificacion.Action_REP_AGE).toString()%>">Edad</a></li>
            <li><a href="<%=urlact.setAction(ReporteIdentificacion.Action_REP_NATIONATITY).toString()%>">País de nacimiento</a></li>
        </ul>
    </div>
</div>
