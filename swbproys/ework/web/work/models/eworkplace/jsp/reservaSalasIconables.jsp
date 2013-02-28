<%-- 
    Document   : reservaSalasIconables
    Created on : 24-ene-2013, 13:10:36
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.portal.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar icono a las reservaciones</title>
    </head>
    <body>
<%!
    enum Color {
        u("u"),
        v("v"),
        w("w"),
        x("x"),
        y("y"),
        z("z");
        private String desc;
        Color(String desc) {
            this.desc = desc;
        }
        String getDesc() {
            return desc;
        }
        Color next() {
            switch(this) {
                case u: return v;
                case v: return w;
                case w: return x;
                case x: return y;
                case y: return z;
                case z: return x;
                default: return x;
            }
        }
        
    }
%>
<%
    Color iconClass = Color.z;
    String ic = "z";
    final String siteid = "eworkplace";
    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if(site != null)
    {
        ReservacionSala res;
        Iterator<ReservacionSala> reservations = ReservacionSala.ClassMgr.listReservacionSalas();
        reservations = SWBComparator.sortByCreated(reservations);
        while(reservations.hasNext()) {
            res = reservations.next();
            //if(res.getIconClass()==null) {
            iconClass = iconClass.next();
            res.setIconClass(iconClass.getDesc());
            out.println("<p>reservation id="+res.getId()+", icon="+res.getIconClass()+"</p>");
            //}
        }
    }else {
%>
        <p>sitio no existe</p>
<%
    }
%>
    </body>
</html>
