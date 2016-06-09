<%-- 
    Document   : sendEmailTest
    Created on : 23-may-2014, 16:57:11
    Author     : carlos.ramos
--%>
<%@page import="org.semanticwb.SWBUtils" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviar correo</title>
    </head>
    <body>
        <h1>vecina, envíame el correo, por favor...</h1>
<%
    try{
        SWBUtils.EMAIL.sendMail("carlos.ramos@infotec.com.mx", "test", "testing");
    }catch(Exception e) {
e.printStackTrace(System.out);
    }
%>
    </body>
</html>
