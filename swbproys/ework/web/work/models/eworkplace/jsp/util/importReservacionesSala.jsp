<%-- 
    Document   : importReservacionesSala
    Created on : 16-may-2012, 13:18:36
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.portal.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.io.File"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>importReservacionesSala</title>
    </head>
    <body>
        <h3>importReservacionesSala....</h3>
<%!
    public void reset(java.util.Calendar cal, int hour, int minute) {
        cal.set(java.util.Calendar.HOUR_OF_DAY, hour);
        cal.set(java.util.Calendar.MINUTE, minute);
        cal.set(java.util.Calendar.SECOND, 0);
        cal.set(java.util.Calendar.MILLISECOND, 0);
    }
    
    public void reset(java.util.Calendar cal) {
        reset(cal, 0, 0);
    }

    public enum CAMPOS
    {
        asistentes, fechaInicio, fechaFinal, horarioServCafe,
        motivo, requiereAgua, requiereCafeGrano, requiereCafeSoluble, 
        requiereComputo, requiereGalletas, requiereProyector, requiereRefrescos,
        sala, salaId, serviciosAdicionales, solicitante, 
        login, email, firstName, lastName,
        secondLastName, fullname, tipoCafeteria, tipoReunion,
        requiereServicioContinuo
    };
%>
<%
            ArrayList<String> traslapadas = new ArrayList<String>();
            ArrayList<String> rechazadas = new ArrayList<String>();
            ArrayList<String> agregadas = new ArrayList<String>();

            final String path = SWBPortal.getWorkPath() + "/exportacionReservSalasInspyra.csv";
out.println("path="+path);
            final String siteid = "eworkplace3";

            WebSite site = WebSite.ClassMgr.getWebSite(siteid);
            if (site != null)
            {
                UserGroup group = site.getUserRepository().getUserGroup("Empleado_exsitu");
                if (group == null)
                {
%>
<h3>Grupo Empleado_exsitu no existe</h3>
<%
                    return;
                }
                File file = new File(path);
                if (file.exists())
                {
                    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    
                    
                    byte[] bcontent = SWBUtils.IO.readFile(file);
                    String content = new String(bcontent);
                    StringReader reader = new StringReader(content);
                    BufferedReader br = new BufferedReader(reader);
                    String line = br.readLine(); // encabezados
                    line = br.readLine();
                    while (line != null)
                    {
%>
<p style="background-color:beige; font-size:small;">line: <%=line%></p>
<%
                        String[] rec = line.split(";",-1);
                        String email = rec[CAMPOS.email.ordinal()];
%>
<p style=" font-size:small; font-style:italic;">email = <%=email%></p>
<%
                        final UserRepository ur = site.getUserRepository();
                        User user_toModify = ur.getUserByEmail(email);
                        if (user_toModify == null)
                        {
                            rechazadas.add(line);
%>
<p style="color: blue;">Usuario no existe con email: <%=email%></p>
<%
                            out.flush();
                        }
                        else
                        {
                            Sala sala = null;
                            try {
                                sala = Sala.ClassMgr.getSala(rec[CAMPOS.salaId.ordinal()], site);
                            }catch(Exception e) {
                                e.printStackTrace(System.out);
                            }
                            if(sala==null) {
                                rechazadas.add(line);
                                continue;
                            }
                            Date di = fmt.parse(rec[CAMPOS.fechaInicio.ordinal()]);
                            Date df = fmt.parse(rec[CAMPOS.fechaFinal.ordinal()]);
                            java.util.Calendar csd = java.util.Calendar.getInstance();
                            csd.setTime(di);                        
                            java.util.Calendar cfd = java.util.Calendar.getInstance();
                            cfd.setTime(df);
                            
                            int turnout = 0;
                            try {
                                turnout = Integer.parseInt(rec[CAMPOS.asistentes.ordinal()]);
                            }catch(NumberFormatException e) {
                                rechazadas.add(line);
                                continue;
                            }
                            
                            ReservacionSala.TipoReunion tpmeet = ReservacionSala.TipoReunion.Interna; 
                            try {
                                tpmeet = ReservacionSala.TipoReunion.valueOf(rec[CAMPOS.tipoReunion.ordinal()]);
                            }catch(Exception e) {
                                rechazadas.add(line);
                                continue;
                            }
                            ReservacionSala.Horario tmsrvc = ReservacionSala.Horario.Durante;
                            
                            if(!sala.isReservada(csd, cfd)) {
                                ReservacionSala reservation = ReservacionSala.ClassMgr.createReservacionSala(site);
                                reservation.setSala(sala);
                                reservation.setFechaInicio(csd.getTime());
                                reservation.setFechaFinal(cfd.getTime());
                                reservation.setAsistentes(turnout);
                                reservation.setMotivo(rec[CAMPOS.motivo.ordinal()]);
                                reservation.setTipoReunion(tpmeet.toString());
                                if(ReservacionSala.TipoReunion.Externa == tpmeet) {
                                    reservation.setRequiereCafeGrano(Boolean.parseBoolean(rec[CAMPOS.requiereCafeGrano.ordinal()]));
                                    reservation.setRequiereCafeSoluble(Boolean.parseBoolean(rec[CAMPOS.requiereCafeSoluble.ordinal()]));
                                    reservation.setRequiereRefrescos(Boolean.parseBoolean(rec[CAMPOS.requiereRefrescos.ordinal()]));
                                    reservation.setRequiereAgua(Boolean.parseBoolean(rec[CAMPOS.requiereAgua.ordinal()]));
                                    reservation.setRequiereGalletas(Boolean.parseBoolean(rec[CAMPOS.requiereGalletas.ordinal()]));
                                    if(ReservacionSala.Horario.Receso == tmsrvc) {
                                        reservation.setRequiereServicioContinuo(false);
                                        reservation.setHorarioServicio(rec[CAMPOS.horarioServCafe.ordinal()]);
                                    }else {
                                        reservation.setRequiereServicioContinuo(true);
                                    }
                                }
                                reservation.setRequiereProyector(Boolean.parseBoolean(rec[CAMPOS.requiereProyector.ordinal()]));
                                reservation.setRequiereComputo(Boolean.parseBoolean(rec[CAMPOS.requiereComputo.ordinal()]));
                                if(!rec[CAMPOS.serviciosAdicionales.ordinal()].isEmpty())
                                    reservation.setServiciosAdicionales(rec[CAMPOS.serviciosAdicionales.ordinal()]);
                                agregadas.add(line);
                            }else {
                                traslapadas.add(line);
                            }
%>
<p style="color:brown;">Solicitante: <%=email%> nombre: <%=user_toModify.getFullName()%></p>
<%
                            out.flush();
                        }                       
                        line = br.readLine();
                    }
                }
                else {
%>
<p>archivo no existe</p>
<%
                    return;
                }
            }
            else {
%>
<p>sitio nulo</p>
<%
                return;
            }
%>
<p>
Fin de carga de reservaciones de sala<br/>
Reservaciones agregadas: <%=agregadas.size()%><br/>
Reservaciones traslapadas: <%=traslapadas.size()%><br/>
Reservaciones rechazadas: <%=rechazadas.size()%><br/>
</p>
<%
            out.flush();
%>
    </body>
</html>