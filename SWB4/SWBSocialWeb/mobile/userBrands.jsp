<%-- 
    Document   : SocialSites2User
    Created on : 5/09/2014, 12:55:03 PM
    Author     : jorge.jimenez
--%>

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
/*
returnMsg.append("<div id=\"siteStreams\">");
returnMsg.append("<div id=\"siteStreamsContentHeader\" data-role=\"header\">");
returnMsg.append("<h1>Marcas</h1>");
returnMsg.append("</div>");
returnMsg.append("<div id=\"siteStreamsContent\" data-role=\"content\">");	
 * */
//returnMsg.append("<div id=\"scroller\">");   
returnMsg.append("<ul data-role=\"listview\" class=\"ui-listview\">"); 
        
    if(request.getParameter("userId")!=null)
    {
            User user=SWBContext.getAdminWebSite().getUserRepository().getUser(request.getParameter("userId"));

            UserGroup userSuperAdminGrp = SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
            Iterator<SocialSite> itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage());  
            while(itSocialSites.hasNext())
            {
                SocialSite socialSite=itSocialSites.next();
                if(socialSite.isValid())
                {
                    Iterator<AdminFilter> userAdmFilters=user.listAdminFilters();
                    if(userAdmFilters.hasNext())
                    {
                        while(userAdmFilters.hasNext())
                        {
                            AdminFilter userAdmFilter=userAdmFilters.next();
                            if(userAdmFilter.haveTreeAccessToSemanticObject(socialSite.getSemanticObject()))
                            {
                                returnMsg.append("<li class=\"ui-first-child ui-last-child\"><a class=\"ui-first-child ui-last-child\" href=\"#\" onclick=\"javascript:setHtmlSubHeader('"+socialSite.getDisplayTitle(user.getLanguage()) +"');getBrandStreams('"+socialSite.getId()+"');\">"+socialSite.getDisplayTitle(user.getLanguage())+" </a></li>");                      
                            }
                        }
                    }else if(user.hasUserGroup(userSuperAdminGrp)) {//Es SuperUsuario
                        returnMsg.append("<li class=\"ui-first-child ui-last-child\"><a class=\"ui-btn ui-btn-icon-right ui-icon-carat-r\" href=\"#\" onclick=\"javascript:setHtmlSubHeader('"+socialSite.getDisplayTitle(user.getLanguage()) +"');getBrandStreams('"+socialSite.getId()+"');\">"+socialSite.getDisplayTitle(user.getLanguage())+" </a></li>");                      
                    }
                }
            }
    } 
            returnMsg.append("</ul>");
//        returnMsg.append("</div>");
        /*
    returnMsg.append("</div>");
 returnMsg.append("</div>");    
 * */
    try {
        System.out.println("Message de R:"+returnMsg);
        response.getWriter().println(returnMsg.length() > 2 ? returnMsg.toString().substring(0, returnMsg.length() - 2) : "Not OK");
    } catch (IOException ioe) {}
%>
                
        
<%!

/**
 * Sort by display name set.
 *
 * @param it the it
 * @param lang the lang
 * @return the sets the
 */
public static Iterator sortByDisplayNameSet(Iterator it, String lang) {
    TreeSet set = new TreeSet(new SWBComparator(lang)); 

    while (it.hasNext()) {
        set.add(it.next());
    }        

    return set.iterator();
}

%>
