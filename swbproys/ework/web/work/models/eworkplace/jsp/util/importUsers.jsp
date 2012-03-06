<%-- 
    Document   : importUsers
    Created on : 06-mar-2012, 13:20:32
    Author     : carlos.ramos
--%>
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
            ArrayList<User> agreados = new ArrayList<User>();
            ArrayList<User> modificados = new ArrayList<User>();

            String path = SWBPortal.getWorkPath() + "/db.txt";
            String siteid = "eworkplace";

            WebSite site = WebSite.ClassMgr.getWebSite(siteid);
            if (site != null)
            {
                UserGroup group = site.getUserRepository().getUserGroup("Empleado_exsitu");
                if (group == null)
                {
%>
<h3>Grupo Empleado_exsitu no existe</h3>
<%                                
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
                        line=line.replace(",,", ",_,");
                        line=line.replace(",,", ",_,");
                        ArrayList<String> campos = new ArrayList<String>();


                        StringTokenizer st = new StringTokenizer(line, ",");

                        while (st.hasMoreTokens())
                        {
                            String token = st.nextToken().trim();
                            if (token.equals("_"))
                            {
                                token = "";
                            }
                            campos.add(token.trim().toLowerCase());
                        }
                        String rfc = campos.get(CAMPOS.RFC.ordinal());
                        
                        User user_toModify = site.getUserRepository().getUserByLogin(rfc);
                        /*Iterator<User> users = site.getUserRepository().listUsers();
                        User user_toModify = null;
                        while (users.hasNext())
                        {
                            User user = users.next();
                            if (rfc.equals(user.getLogin()))
                            {
                                user_toModify = user;
                                break;
                            }
                        }*/
                       
                        if (user_toModify == null)
                        {
                            if (group != null)
                            {
                                user_toModify.addUserGroup(group);
                            }

                            user_toModify = site.getUserRepository().createUser();
                            String email = campos.get(CAMPOS.EMAIL.ordinal());
                            user_toModify.setEmail(createmail(email, toUpperCase(campos.get(CAMPOS.NOMBRE.ordinal())), toUpperCase(campos.get(CAMPOS.PRIMER_APELLIDO.ordinal()))));
                            user_toModify.setValid(true);
                            user_toModify.setLanguage("es");
                            user_toModify.setRequestChangePassword(true);
                            agreados.add(user_toModify);
                            user_toModify.setLogin(rfc);
                            if (user_toModify.getCreated() == null)
                            {
                                user_toModify.setCreated(new Date());
                            }

                            user_toModify.setUpdated(new Date());
                            user_toModify.setActive(true);
                            user_toModify.setPassword(rfc);
                            user_toModify.setFirstName(toUpperCase(campos.get(CAMPOS.NOMBRE.ordinal())));
                            user_toModify.setLastName(toUpperCase(campos.get(CAMPOS.PRIMER_APELLIDO.ordinal())));
                            user_toModify.setSecondLastName(toUpperCase(campos.get(CAMPOS.SEGUNDO_APELLIDO.ordinal())));
                            out.flush();
%>
<p>Usuario agregado: <%=rfc%> nombre: <%=user_toModify.getFullName()%> mail: <%=user_toModify.getEmail()%></p>
<%
                        }
                        else
                        {
                            if (user_toModify.getCreated() == null)
                            {
                                user_toModify.setCreated(new Date());
                            }
                            String email = campos.get(CAMPOS.EMAIL.ordinal());
                            user_toModify.setEmail(createmail(email, toUpperCase(campos.get(CAMPOS.NOMBRE.ordinal())), toUpperCase(campos.get(CAMPOS.PRIMER_APELLIDO.ordinal()))));
                            user_toModify.setUpdated(new Date());
                            if (group != null)
                            {
                                if (!user_toModify.hasUserGroup(group))
                                {
                                    user_toModify.addUserGroup(group);
                                }
                            }
                            user_toModify.setFirstName(toUpperCase(campos.get(CAMPOS.NOMBRE.ordinal())));
                            user_toModify.setLastName(toUpperCase(campos.get(CAMPOS.PRIMER_APELLIDO.ordinal())));
                            user_toModify.setSecondLastName(toUpperCase(campos.get(CAMPOS.SEGUNDO_APELLIDO.ordinal())));
                            modificados.add(user_toModify);
                            out.flush();
%>
<p>Usuario modificado: <%=rfc%> nombre: <%=user_toModify.getFullName()%> mail: <%=user_toModify.getEmail()%></p>
<%
                        }
                        
                        line = br.readLine();
                    }

                    Iterator<User> users = site.getUserRepository().listUsers();
                    while (users.hasNext())
                    {
                        User user = users.next();
                        boolean delete = true;
                        reader = new StringReader(content);
                        br = new BufferedReader(reader);
                        line = br.readLine();
                        while (line != null)
                        {
                            StringTokenizer st = new StringTokenizer(line, ",");
                            ArrayList<String> campos = new ArrayList<String>();
                            while (st.hasMoreTokens())
                            {
                                campos.add(st.nextToken().trim().toLowerCase());
                            }
                            String rfc = campos.get(CAMPOS.RFC.ordinal());
                            if (rfc.equalsIgnoreCase(user.getLogin()))
                            {
                                delete = false;
                            }
                            line = br.readLine();
                        }
                        if (delete)
                        {
                            toDelete.add(user);
                        }
                    }
%>
Removiendo usuarios<br>
<%
                    for (User user : toDelete)
                    {

                        site.getUserRepository().removeUser(user.getId());

%>
Usuario removido: <%=user.getLogin()%><br>
<%

                    }
                }
            }
%>


Fin de carga de usuarios<br>
Usuarios agregados: <%=agreados.size()%><br>
Usuarios modificados <%=modificados.size()%><br>
Usuarios removidos: <%=toDelete.size()%>

<%
            out.flush();
%>