<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.portal.monitor.SWBThreadDumper"%>
<%@page import="java.lang.management.ManagementFactory"%>
<%@page import="java.lang.management.ThreadMXBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Threads List</title>
    </head>
    <body>
        <%
            SemanticObject.clearCache();
        %>
        OK
    </body>
</html>
