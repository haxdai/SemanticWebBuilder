<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<p>iniciando la limpieza de reservaciones...</p>
<%
    final String siteid = "eworkplace";
    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if(site != null)
    {
        Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalas();
        while(reservations.hasNext()) {
            reservations.next().remove();
        }
    }else {
%>
        <p>sitio no existe</p>
<%
    }
%>
<p>limpieza concluida</p>

