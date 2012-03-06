<%-- 
    Document   : importUsers
    Created on : 06-mar-2012, 13:20:32
    Author     : carlos.ramos
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page import="org.semanticwb.model.UserRepository"%>
<%@page import="org.semanticwb.portal.SWBUserMgr"%>
<%@page import="java.io.File"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.StringTokenizer"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="java.util.regex.Matcher"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0//EN" "http://www.w3.org/TR/REC-html40/strict.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>append UG</title>
    </head>
    <body>
<h3>iniciando appendEmail....</h3>
<%!
    public boolean isValidEmailAddress(String emailAddress) {
        if(emailAddress==null)
            return false;
        String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = emailAddress;
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.matches();
    }


    public enum CAMPOS
    {
        RFC, CURP, PRIMER_APELLIDO, SEGUNDO_APELLIDO, NOMBRE, EMAIL, ADSCRIPCION, TIPO_CONTRATACION, PERFIL, NUM_EMPLEADO
    };
%>
<%
    String path = SWBPortal.getWorkPath() + "/db.txt";
    String siteid = "eworkplace";

    WebSite site = WebSite.ClassMgr.getWebSite(siteid);
    if (site != null)
    {
        UserRepository ur = site.getUserRepository();
        Iterator<User> users = ur.listUsers();
        String email = null;
        while(users.hasNext()) {
            User user = users.next();
            if(user!=null && !isValidEmailAddress(user.getEmail()))
            {
                String[] fna = user.getFirstName().trim().toLowerCase().split("\\s");
                String ln = user.getLastName().trim().toLowerCase().replaceAll("\\s", "");
                for(String fn:fna) {
                    email = fn+"."+ln+"@infotec.com.mx";
%>
<p>email = <%=email%></p>        
<%
                    if(ur.getUserByEmail(email)!=null)
                        continue;
                    user.setEmail(email);
                }
%>
<p>usuario <%=(user.getFullName())%></p>
<%
            }
        }
    }
%>
<p>Fin de modificacion de usuarios</p>
<%
    out.flush();
%>
    </body>
</html>