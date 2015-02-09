<%-- 
    Document   : communityContent
    Created on : 5/09/2014, 07:24:27 PM
    Author     : jorge.jimenez
--%>
<%@page import="java.io.*"%>
<%
    StringBuilder returnMsg = new StringBuilder(300);
    returnMsg.append("<iframe src=\"http://www.semanticwebbuilder.com.mx/SWBSocial\" class=\"Iframec\"></iframe>");
    try { 
                //System.out.println("Message:"+message);
                response.getWriter().println(returnMsg.length() > 2 ? returnMsg.toString().substring(0, returnMsg.length() - 2) : "Not OK");
    } catch (IOException ioe) {}
%>