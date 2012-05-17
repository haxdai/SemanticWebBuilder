<%-- 
    Document   : importReservacionesSala
    Created on : 16-may-2012, 13:18:36
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.portal.SWBUserMgr"%>
<%@page import="java.util.Date"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.io.File"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>importReservacionesSala</title>
    </head>
    <body>
        <h3>importReservacionesSala....</h3>
<%!
    public String toUpperCase(String data)
    {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(data, " ");
        while (st.hasMoreTokens())
        {
            String token = st.nextToken();
            token = token.substring(0, 1).toUpperCase() + token.substring(1).toLowerCase();
            sb.append(token);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public String createmail(String email, String nombre, String apellido)
    {
        if (email == null || email.isEmpty())
        {
            return "usuario.desconocido@infotec.com.mx";
        }
        else
        {
            return email.toLowerCase() + "@infotec.com.mx";
        }
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
            ArrayList<User> toDelete = new ArrayList<User>();
            ArrayList<User> agregados = new ArrayList<User>();
            ArrayList<User> modificados = new ArrayList<User>();

            final String path = SWBPortal.getWorkPath() + "/exportacionReservSalasInspyra.csv";
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
                    byte[] bcontent = SWBUtils.IO.readFile(file);
                    String content = new String(bcontent);
                    StringReader reader = new StringReader(content);
                    BufferedReader br = new BufferedReader(reader);
                    String line = br.readLine();
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
                        User user_toModify = site.getUserRepository().getUserByEmail(email);  
                        if (user_toModify == null)
                        {
                            /*if (group != null)
                            {
                                user_toModify.addUserGroup(group);
                            }

                            user_toModify = site.getUserRepository().createUser();
                            String email = campos.get(CAMPOS.EMAIL.ordinal());
                            String fname = toUpperCase(campos.get(CAMPOS.NOMBRE.ordinal()));
                            String lname = toUpperCase(campos.get(CAMPOS.PRIMER_APELLIDO.ordinal()));
                            user_toModify.setEmail(createmail(email,fname, lname));
                            user_toModify.setValid(true);
                            user_toModify.setLanguage("es");
                            user_toModify.setRequestChangePassword(true);
                            agregados.add(user_toModify);
                            user_toModify.setLogin(rfc);
                            if (user_toModify.getCreated() == null)
                            {
                                user_toModify.setCreated(new Date());
                            }

                            user_toModify.setUpdated(new Date());
                            user_toModify.setActive(true);
                            user_toModify.setPassword(rfc);
                            user_toModify.setFirstName(fname);
                            user_toModify.setLastName(lname);
                            user_toModify.setSecondLastName(toUpperCase(campos.get(CAMPOS.SEGUNDO_APELLIDO.ordinal())));*/
%>
<p style="color: blue;">Usuario no existe con email: <%=email%></p>
<%
                            out.flush();
                        }
                        else
                        {
                            /*if (user_toModify.getCreated() == null)
                            {
                                user_toModify.setCreated(new Date());
                            }
                            String email = campos.get(CAMPOS.EMAIL.ordinal());
                            String fname = toUpperCase(campos.get(CAMPOS.NOMBRE.ordinal()));
                            String lname = toUpperCase(campos.get(CAMPOS.PRIMER_APELLIDO.ordinal()));
                            user_toModify.setEmail(createmail(email, fname, lname));
                            user_toModify.setUpdated(new Date());
                            if (group != null)
                            {
                                if (!user_toModify.hasUserGroup(group))
                                {
                                    user_toModify.addUserGroup(group);
                                }
                            }
                            user_toModify.setFirstName(fname);
                            user_toModify.setLastName(lname);
                            user_toModify.setSecondLastName(toUpperCase(campos.get(CAMPOS.SEGUNDO_APELLIDO.ordinal())));*/
                            modificados.add(user_toModify);
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

Fin de carga de usuarios<br>
Usuarios agregados: <%=agregados.size()%><br>
Usuarios modificados <%=modificados.size()%><br>
Usuarios removidos: <%=toDelete.size()%>

<%
            out.flush();
%>
    </body>
</html>