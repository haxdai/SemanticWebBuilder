<%-- 
    Document   : streamData
    Created on : 5/09/2014, 05:44:01 PM
    Author     : jorge.jimenez
--%>

<!-- showStreamData -->
<%@page import="org.semanticwb.portal.SWBUserMgr"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.social.util.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>

<!-- showStreams -->
<%
StringBuilder returnMsg = new StringBuilder(300);
System.out.println("StreamId:"+request.getParameter("streamId")+",socialSite:"+request.getParameter("siteId")); 
if(request.getParameter("streamId")!=null && request.getParameter("siteId")!=null && request.getParameter("userId")!=null)
{
    SocialSite socialSite=(SocialSite)WebSite.ClassMgr.getWebSite(request.getParameter("siteId"));

    Stream stream=Stream.ClassMgr.getStream(request.getParameter("streamId"), socialSite);
    
    User user=SWBContext.getAdminWebSite().getUserRepository().getUser(request.getParameter("userId"));
    
    returnMsg.append("Se despliegan datos de Stream:"+stream.getDisplayTitle(user.getLanguage()));
    }
    try { 
                //System.out.println("Message:"+message);
                response.getWriter().println(returnMsg.length() > 2 ? returnMsg.toString().substring(0, returnMsg.length() - 2) : "Not OK");
    } catch (IOException ioe) {}
%>
