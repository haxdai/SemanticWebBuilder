<%-- 
    Document   : showUserStreams
    Created on : 2/09/2014, 03:31:18 PM
    Author     : jorge.jimenez
--%>

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
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title>Estadisticas de Streams</title>
<link href="/work/models/<%=paramRequest.getWebPage().getWebSiteId()%>/jsp/mobile/jquery-mobile/jquery.mobile-1.3.0.min.css" rel="stylesheet" type="text/css"/>
<script src="/work/models/<%=paramRequest.getWebPage().getWebSiteId()%>/jsp/mobile/jquery-mobile/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="/work/models/<%=paramRequest.getWebPage().getWebSiteId()%>/jsp/mobile/jquery-mobile/jquery.mobile-1.3.0.min.js" type="text/javascript"></script>
<link href="<%=SWBPortal.getContextPath()%>/swbadmin/css/swbsocial.css" rel="stylesheet" type="text/css"/>


<script>
function CambiarEstilo() {
    if ($('#mainSiteStreams').hasClass('mobilePage')){
      $('#mainSiteStreams').addClass('leftTotal');
      $('#mainSiteStreams').removeClass('mobilePage');
    }else {
      $('#mainSiteStreams').removeClass('mobilePageleftTotal');
      $('#mainSiteStreams').addClass('mobilePage');
    }
}
</script>
</head> 
<body> 
<div id="botones">
    <input type="button" onclick="javascript:CambiarEstilo();" value="Cambiar estilo" />
</div>   
    
 <div data-role="page" id="mainSiteStreams" >
    <div data-role="header">
      <h1>Marcas</h1>
    </div>
    <div data-role="content">	
        <ul data-role="listview">
<%
    User user=paramRequest.getUser();
    UserGroup userSuperAdminGrp = SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
    ArrayList<SocialSite> aSocialSites=new ArrayList();   
    SWBResourceURL url = paramRequest.getRenderUrl();   
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
                        String uri=socialSite.getURI().substring(7);
                        %>
                        <li><a href="#<%=uri%>"><%=socialSite.getDisplayTitle(user.getLanguage())%> </a></li> 
                        <%
                        aSocialSites.add(socialSite);
                    }
                }
            }else if(user.hasUserGroup(userSuperAdminGrp)) {//Es SuperUsuario
                String uri=socialSite.getURI().substring(7);
                %>
                <li><a href="#<%=uri%>"><%=socialSite.getDisplayTitle(user.getLanguage())%> </a></li> 
                <%
                aSocialSites.add(socialSite);
            }
        }
    }
%>
        </ul>		
    </div>
    <div data-role="footer">
        <h4>SWB Social4Mobile&copy;</h4>
    </div>
</div>


<%
    ArrayList<Stream> aSiteStreams=new ArrayList(); 
    itSocialSites=aSocialSites.iterator(); 
    while(itSocialSites.hasNext())
    {
        SocialSite socialSite=itSocialSites.next();
        String uri=socialSite.getURI().substring(7);
%>           
        <div data-role="page" id="<%=uri%>">
                <div data-role="header">
                <a href="#mainSiteStreams" data-icon="back" data-iconpos="notext">Regresar</a>
                <h1>[img stream]<%=socialSite.getDisplayTitle(user.getLanguage())%></h1>
                </div>
                <div id="data-container" data-role="content">	
                <ul data-role="listview">
                    <%
                        Iterator<Stream> itStreams=socialSite.listStreams();
                        while(itStreams.hasNext())
                        {
                            Stream stream=itStreams.next();
                            if(!stream.isDeleted() && stream.isActive())
                            {
                                String streamUri=stream.getURI().substring(7);
                                %>
                                    <li><a href="#<%=streamUri%>"><%=stream.getDisplayTitle(user.getLanguage())%> </a></li>
                                <%
                                aSiteStreams.add(stream);
                            }
                        }
                    %>
                </ul>
                </div>
                <div data-role="footer">
                    <h4>SWB Social4Mobile&copy;</h4>
                </div>
        </div>    
<%
   }
%>


<%
    Iterator<Stream> itSocialStreams=aSiteStreams.iterator(); 
    while(itSocialStreams.hasNext())
    {
        Stream socialStream=itSocialStreams.next();
        String streamUri=socialStream.getURI().substring(7);
%>           
        <div data-role="page" id="<%=streamUri%>">
                <div data-role="header">
                    <a href="#<%=socialStream.getSocialSite().getURI().substring(7)%>" data-icon="back" data-iconpos="notext">Regresar</a>
                <h1>[img streamStats]<%=socialStream.getDisplayTitle(user.getLanguage())%></h1>
                </div>
                <div id="data-container" data-role="content">	
                    Muestra estadisticas del Stream <%=socialStream.getDisplayTitle(user.getLanguage())%>
                </div>
                <div data-role="footer">
                    <h4>SWB Social4Mobile&copy;</h4>
                </div>
        </div>    
<%
   }
%>


</body>
</html>


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