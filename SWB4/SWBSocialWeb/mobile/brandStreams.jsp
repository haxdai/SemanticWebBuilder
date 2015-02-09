<%-- 
    Document   : SocialSiteStreams
    Created on : 5/09/2014, 01:19:25 PM
    Author     : jorge.jimenez
--%>

 <!-- showStreams -->
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
if(request.getParameter("brandId")!=null && request.getParameter("userId")!=null)
{
    SocialSite socialSite=SocialSite.ClassMgr.getSocialSite(request.getParameter("brandId"));
    User user=SWBContext.getAdminWebSite().getUserRepository().getUser(request.getParameter("userId"));
    
    //returnMsg.append("<div id=\""+socialSite.getId()+"\">");
    //returnMsg.append("    <div id=\"site_"+socialSite.getId()+"\">");	
    returnMsg.append("        <ul>"); 
                
                    Iterator<Stream> itStreams=socialSite.listStreams();
                    while(itStreams.hasNext())
                    {
                        Stream stream=itStreams.next();
                        if(!stream.isDeleted() && stream.isActive())
                        {
                            returnMsg.append("<li><a href=\"javascript:getStreamData('"+stream.getId()+"','"+socialSite.getId()+"');\">"+stream.getDisplayTitle(user.getLanguage())+" </a></li>");                      
                        }
                    }
    returnMsg.append("      </ul>");
    //returnMsg.append("  </div>");
    //returnMsg.append("</div>");
}
try { 
            //System.out.println("Message:"+message);
            response.getWriter().println(returnMsg.length() > 2 ? returnMsg.toString().substring(0, returnMsg.length() - 2) : "Not OK");
    } catch (IOException ioe) {}
%>