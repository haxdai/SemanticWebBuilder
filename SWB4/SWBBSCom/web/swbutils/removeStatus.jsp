<%-- 
    Document   : RemoveStatus
    Created on : 13-sep-2013, 14:19:49
    Author     : carlos.ramos
--%>
<%@page import="org.semanticwb.bsc.*,org.semanticwb.bsc.element.*,org.semanticwb.bsc.accessory.*" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
final String siteid = "SWBAdmin";
try{
    Iterator<StateGroup>groups = StateGroup.ClassMgr.listStateGroups();
    while(groups.hasNext()) {
        StateGroup sg = groups.next();        
        out.println("<p>grupo="+sg.getTitle()+", borrable:"+sg.isUndeleteable()+"</p>");
        sg.remove();
    }
}catch(Exception e) {
}
%>