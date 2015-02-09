<%-- 
    Document   : home
    Created on : 15/10/2014, 12:28:36 PM
    Author     : jorge.jimenez
--%>

<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    SemanticObject semObj=null;
    WebSite wsite=null;
    if(request.getParameter("semObj")!=null)
    {
        semObj=SemanticObject.getSemanticObject(request.getParameter("semObj"));
        wsite=WebSite.ClassMgr.getWebSite(semObj.getModel().getName());
    }
    WebPage streamWebPage=SWBContext.getAdminWebSite().getWebPage("m_Streams"); 
    WebPage socialNetsWebPage=SWBContext.getAdminWebSite().getWebPage("m_SocialNets"); 
    String baseImagePath="/swbadmin/css/images/";
    User user=paramRequest.getUser();
    UserGroup userSuperAdminGrp = SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
    ArrayList<SocialSite> arrSocialSites=new ArrayList();
    Iterator<SocialSite> itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage()); 
    while(itSocialSites.hasNext())
    {
        SocialSite socialSite=itSocialSites.next();
        //if(socialSite.isActive())
        {
            Iterator<AdminFilter> userAdmFilters=user.listAdminFilters();
            if(userAdmFilters.hasNext()){
                while(userAdmFilters.hasNext())
                {
                    AdminFilter userAdmFilter=userAdmFilters.next();
                    if(userAdmFilter.haveTreeAccessToSemanticObject(socialSite.getSemanticObject())) arrSocialSites.add(socialSite);
                }
            }else if(user.hasUserGroup(userSuperAdminGrp)) arrSocialSites.add(socialSite);
        }
    }
    itSocialSites=arrSocialSites.iterator(); 
    while(itSocialSites.hasNext())
    {
        SocialSite socialSite=itSocialSites.next();
        String socialSiteClass="";
        String streamObjClass="";
        String socialNetObjClass="";
        if(wsite!=null && socialSite.getURI().equals(wsite.getURI())) socialSiteClass="active";
        if(semObj!=null && semObj.getGenericInstance() instanceof Stream) streamObjClass="active";
        else if(semObj!=null && semObj.getGenericInstance() instanceof SocialNetwork) socialNetObjClass="active"; 
    %>
        <li class='<%=socialSiteClass%>'>
            <a href="#"><img class="swbIconSocialSite<%=!socialSite.isActive()?"U":""%>" src="/swbadmin/js/dojo/dojo/resources/blank.gif"/><%=socialSite.getDisplayTitle(user.getLanguage())%><span class="fa arrow"></span></a>
            <!--Streams-->
            <ul class="nav nav-second-level">
                <li class='<%=streamObjClass%>'>
                    <a href="#"><img class="swbIconStreamGrp" src="/swbadmin/js/dojo/dojo/resources/blank.gif"/>Streams<span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level">
                    <%        
                        Iterator<Stream> itStreams=SWBComparator.sortByDisplayName(socialSite.listStreams(), user.getLanguage());
                        while(itStreams.hasNext())
                        {
                            Stream stream=itStreams.next();
                            String streamClass="";  
                            if(semObj!=null && semObj.getURI().equals(stream.getURI())) streamClass="active"; 
                     %>
                        <li class="<%=streamClass%>">
                            <a href="<%=streamWebPage.getUrl()+"?semObj="+stream.getEncodedURI()%>"><img class="swbIconStream<%=!stream.isActive()?"U":""%>" src="/swbadmin/js/dojo/dojo/resources/blank.gif"><%=stream.getDisplayTitle(user.getLanguage())%></a> 
                        </li>
                     <%
                        }
                     %>
                     </ul>
                </li>     
            </ul>
            <!--SocialNets Accounts-->
            <ul class="nav nav-second-level">
                <li class='<%=socialNetObjClass%>'>
                    <a href="#"><img class="swbIconSocialNetGrp" src="/swbadmin/js/dojo/dojo/resources/blank.gif"/>Redes Sociales<span class="fa arrow"></span></a>
                    <ul class="nav nav-third-level">
                    <%        
                        Iterator<SocialNetwork> itSocialNets=SWBComparator.sortByDisplayName(socialSite.listSocialNetworks(), user.getLanguage()); 
                        while(itSocialNets.hasNext())
                        {
                            SocialNetwork socialNet=itSocialNets.next();
                            if(!socialNet.isDeleted())
                            {
                                String socialNetClass="";  
                                //String socialNetimgPath=baseImagePath+"socialnet_off.png"; 
                                //if(socialNet.isActive()) socialNetimgPath=baseImagePath+"socialnet_on.png";   
                                //if(semObj!=null && semObj.getURI().equals(socialNet.getURI())) socialNetClass="active"; 
                                %>
                                   <li class="<%=socialNetClass%>">
                                       <a href="<%=socialNetsWebPage.getUrl()+"?semObj="+socialNet.getEncodedURI()%>"><img class="swbIcon<%=socialNet.isActive()?socialNet.getClass().getSimpleName():socialNet.getClass().getSimpleName()+"U"%>" src="/swbadmin/js/dojo/dojo/resources/blank.gif"/><%=socialNet.getDisplayTitle(user.getLanguage())%></a>                                       
                                   </li>
                                <%
                            }
                        }
                     %>
                     </ul>
                </li>     
            </ul>         
        </li>
     <%
    }       
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