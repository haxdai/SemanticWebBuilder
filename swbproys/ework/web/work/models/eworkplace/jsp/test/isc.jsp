<%@page import="com.infotec.rh.syr.reports.*" %>
<%@page import="org.semanticwb.process.model.Instance" %>
<%@page import="com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso" %>
<%@page import="com.infotec.rh.syr.swb.Contrato" %>
<%@page import="org.semanticwb.*"%>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>ISC!</h1>
<%
    Instance instance = null;
    SeguimientoSolicitudRecurso seguimiento = null;
    Contrato contrato = null;

    String contratoNum = contrato.getFolioContrato();
    String path = SWBUtils.getApplicationPath()+"/work/models/"+instance.getProcessInstance().getProcessType().getProcessWebPage().getWebSiteId()+"/data/procesos/contratos/"+contrato.getFolioContrato()+".csv";
%>        
    </body>
</html>
