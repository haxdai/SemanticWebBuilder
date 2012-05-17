<%-- 
    Document   : importUsers
    Created on : 06-mar-2012, 13:20:32
    Author     : carlos.ramos
--%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
        <title>importUsers</title>
    </head>
    <body>
        <h3>importUsers....</h3>
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

        RFC, CURP, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NOMBRE, EMAIL, ADSCRIPCION, TIPO_CONTRATACION, PERFIL, NUM_EMPLEADO
    };
%>
<%
            ArrayList<User> toDelete = new ArrayList<User>();
            ArrayList<User> agregados = new ArrayList<User>();
            ArrayList<User> modificados = new ArrayList<User>();

            String path = SWBPortal.getWorkPath() + "/db.csv";
            String siteid = "eworkplace3";

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
                        String rfc = rec[CAMPOS.RFC.ordinal()];
%>
<p style=" font-size:small; font-style:italic;">rfc = <%=rfc%></p>
<%
                        User user_toModify = site.getUserRepository().getUserByLogin(rfc);  
                        if (user_toModify == null)
                        {
                            user_toModify = site.getUserRepository().createUser();
                            String email = rec[CAMPOS.EMAIL.ordinal()];
                            String fname = toUpperCase(rec[CAMPOS.NOMBRE.ordinal()]);
                            String lname = toUpperCase(rec[CAMPOS.PRIMER_APELLIDO.ordinal()]);
                            if(email.isEmpty())
                                user_toModify.setEmail("usuario.desconocido@infotec.com.mx");
                            else
                                user_toModify.setEmail(email);
                            user_toModify.setValid(true);
                            user_toModify.setLanguage("es");
                            user_toModify.setRequestChangePassword(true);
                            agregados.add(user_toModify);
                            user_toModify.setLogin(rfc);
                            if (user_toModify.getCreated() == null)
                            {
                                user_toModify.setCreated(new Date());
                            }
                            if (group != null)
                            {
                                user_toModify.addUserGroup(group);
                            }
                            user_toModify.setUpdated(new Date());
                            user_toModify.setActive(true);
                            user_toModify.setPassword(rfc);
                            user_toModify.setFirstName(fname);
                            user_toModify.setLastName(lname);
                            user_toModify.setSecondLastName(toUpperCase(rec[CAMPOS.SEGUNDO_APELLIDO.ordinal()]));
%>
<p style="color: blue;">Usuario agregado: <%=rfc%></p>
<%
                            out.flush();
                        }
                        else
                        {
                            if (user_toModify.getCreated() == null)
                            {
                                user_toModify.setCreated(new Date());
                            }
                            String email = rec[CAMPOS.EMAIL.ordinal()];
                            String fname = toUpperCase(rec[CAMPOS.NOMBRE.ordinal()]);
                            String lname = toUpperCase(rec[CAMPOS.PRIMER_APELLIDO.ordinal()]);
                            if(email.isEmpty())
                                user_toModify.setEmail("usuario.desconocido@infotec.com.mx");
                            else
                                user_toModify.setEmail(email);
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
                            user_toModify.setSecondLastName(toUpperCase(rec[CAMPOS.SEGUNDO_APELLIDO.ordinal()]));
                            modificados.add(user_toModify);
%>
<p style="color:brown;">Usuario modificado: <%=rfc%> nombre: <%=user_toModify.getFullName()%> mail: <%=user_toModify.getEmail()%></p>
<%
                            out.flush();
                        }                       
                        line = br.readLine();
                    }

                    Iterator<User> users = site.getUserRepository().listUsers();
                    while (users.hasNext())
                    {
                        User user = users.next();
                        if(!agregados.contains(user) && !modificados.contains(user))
                            toDelete.add(user);
                    }
%>
Removiendo usuarios<br>
<%
                    for (User user : toDelete)
                    {
                        /*site.getUserRepository().removeUser(user.getId());*/
%>
Usuario removido: <%=user.getLogin()%><br>
<%
                    }
                }
            }
            else {
%>
<p>sitio nulo</p>
<%
                return;
            }
%>

Fin de carga de usuarios<br/>
Usuarios agregados: <%=agregados.size()%><br/>
Usuarios modificados <%=modificados.size()%><br/>
Usuarios removidos: <%=toDelete.size()%>

<%
            out.flush();
%>
    </body>
</html>