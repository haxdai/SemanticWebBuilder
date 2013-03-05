<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="com.infotec.eworkplace.swb.base.*"%>
<%@page import="org.semanticwb.portal.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<%!
    ReservacionSala getReserva(javax.servlet.jsp.JspWriter out, final  WebSite model, final Sala sala, final java.util.Calendar begin, final java.util.Calendar end) throws IOException
    {
        return getReserva(out, model, sala, begin.getTime(), end.getTime(), end.getTime().getHours(), end.getTime().getMinutes());
    }
    
    ReservacionSala getReserva(javax.servlet.jsp.JspWriter out, final  WebSite model, final Sala sala, final java.util.Date begin, final java.util.Date end, final int hours, final int minutes) throws IOException
    {
        if( begin.getDate()==end.getDate() && begin.getMonth()==end.getMonth() && begin.getYear()==end.getYear() ) {
out.println("1");
            java.util.Calendar inicio = java.util.Calendar.getInstance();
            java.util.Calendar fin = java.util.Calendar.getInstance();
            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(sala, model);
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext()) {
                ReservacionSala reservation = reservations.next();
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(java.util.Calendar.HOUR_OF_DAY, reservation.getFechaFinal().getHours());
                fin.set(java.util.Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
                    if( (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(end)>=0) ||
                        (inicio.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<0) ||
                        (begin.compareTo(inicio.getTime())<=0 && end.compareTo(inicio.getTime())>0 && end.compareTo(fin.getTime())<=0) ||
                        (inicio.getTime().compareTo(begin)<=0 && fin.getTime().compareTo(begin)>0 && fin.getTime().compareTo(end)<=0)) {
                        return reservation;
                    }
                    inicio.add(java.util.Calendar.DATE, 1);
                    fin.add(java.util.Calendar.DATE, 1);
                }
            }
        }else {
out.println("2");
            java.util.Calendar cbegin = java.util.Calendar.getInstance();
            cbegin.setTime(begin);
            java.util.Calendar cend = java.util.Calendar.getInstance();
            cend.setTime(begin);
            cend.set(java.util.Calendar.HOUR_OF_DAY, hours);
            cend.set(java.util.Calendar.MINUTE, minutes);
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
out.println("cbegin="+sdf.format(cbegin.getTime()));
out.println("cend="+sdf.format(cend.getTime()));
            java.util.Calendar inicio = java.util.Calendar.getInstance();
            java.util.Calendar fin = java.util.Calendar.getInstance();

            Iterator<ReservacionSala> reservations = ReservacionSalaBase.ClassMgr.listReservacionSalaBySala(sala, model);
            reservations = SWBComparator.sortByCreated(reservations, false);
            while(reservations.hasNext()) {
                ReservacionSala reservation = reservations.next();
                inicio.setTime(reservation.getFechaInicio());
                fin.setTime(reservation.getFechaInicio());
                fin.set(java.util.Calendar.HOUR_OF_DAY, reservation.getFechaFinal().getHours());
                fin.set(java.util.Calendar.MINUTE, reservation.getFechaFinal().getMinutes());
out.println("<p>inicio="+sdf.format(inicio.getTime()));
out.println("   fin="+sdf.format(fin.getTime()));                
                while(fin.getTime().compareTo(reservation.getFechaFinal())<=0) {
out.println("while...");
                    if( (inicio.getTime().compareTo(cbegin.getTime())<=0 && fin.getTime().compareTo(cend.getTime())>=0) ||
                        (inicio.getTime().compareTo(cbegin.getTime())>=0 && fin.getTime().compareTo(cend.getTime())<=0) ||
                        (cbegin.getTime().compareTo(inicio.getTime())<0 && cend.getTime().compareTo(inicio.getTime())>0 && cend.getTime().compareTo(fin.getTime())<0) ||
                        (inicio.getTime().compareTo(cbegin.getTime())<0 && fin.getTime().compareTo(cbegin.getTime())>0 && fin.getTime().compareTo(cend.getTime())<0)) {
                        return reservation;
                    }
                    cbegin.add(java.util.Calendar.DATE, 1);
                    cend.add(java.util.Calendar.DATE, 1);
                    inicio.add(java.util.Calendar.DATE, 1);
                    fin.add(java.util.Calendar.DATE, 1);
                }
out.println("</p>");
            }
        }
        return null;
    }
%>
<%
    final String siteid = "eworkplace";
    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if(site == null)
    {
        out.println("sitio nulo");
        return;
    }
    Sala cristal = Sala.ClassMgr.getSala("Sala_Cristal", site);
    GregorianCalendar begin = new GregorianCalendar(2013,2,11,7,0,0);
    GregorianCalendar end =new GregorianCalendar(2013,2,15,22,0,0);
    //boolean r = cristal.isReservada(begin, end);
    ReservacionSala rs=null;
    try {
        rs = getReserva(out, site, cristal, begin, end);
        out.println("<p>sala "+cristal+" reservada="+rs+"</p>");
    }catch(IOException ioe) {
        out.println("<p>fallo getReserva</p>");
    }
    
    
    out.println("<ul>");
    Iterator<ReservacionSala> it = ReservacionSala.ClassMgr.listReservacionSalaBySala(cristal);
    it = SWBComparator.sortByCreated(it,true);
    while(it.hasNext()) {
        rs = it.next();
        out.println("<li>"+rs.toString()+"</li>");
    }
    out.println("</ul>");
%>
    </body>
</html>
