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
<%
    response.setHeader("X-Frame-Options", "ALLOW-FROM http://localhost:8080");
    User user=paramRequest.getUser();
%>  

<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<title>SWB Social</title>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<link href="<%=SWBPortal.getContextPath()%>/swbadmin/css/swbsocial.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript">
    <!--
    var request = false;
    try {
        request = new XMLHttpRequest();
    } catch (trymicrosoft) {
        try {
            request = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (othermicrosoft) {
            try {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                request = false;
            }
        }
    }
    if (!request)
        alert("Error al inicializar XMLHttpRequest!");
    //var invoke = true;

   
    function getBrandStreams(brandId) {
        var url = "/work/models/SWBAdmin/jsp/mobile/brandStreams.jsp";
        url += "?brandId=" + escape(brandId) + "&userId=<%=user.getId()%>";
        //alert("getBrandStreams/Ruta:"+url);
        console.log(url);
        request.open("GET", url, true);
        request.onreadystatechange = showData;
        request.send(null);
    }

    function getStreamData(streamId, siteId) {
        var url = "/work/models/SWBAdmin/jsp/mobile/streamData.jsp";
        url += "?streamId=" + escape(streamId) + "&siteId="+ escape(siteId) + "&userId=<%=user.getId()%>";
        console.log(url);
        request.open("GET", url, true);
        request.onreadystatechange = showData;
        request.send(null);
    }
    
    function showData() {
        if (request.readyState != 4) return;
        if (request.status == 200) {
            var response = request.responseText;
            if ('Not OK' != response && '' != response) {
                document.getElementById("scroller").innerHTML = response;
            } else {
                alert('Lo sentimos, ha ocurrido un problema al mostrar los datos requeridos..');
            }
            //alert("La respuesta contiene: " + response);
        }
    }
    
    function setBack() {
        alert("setBack J:"+parent.document);
        
        
    }
        
-->
</script>

</head> 
<body> 
 <div id="wrapper">
	<div id="scroller">
        <ul data-role="_listview">
        <%
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
                                %>
                                    <li><a href="javascript:setBack();getBrandStreams('<%=socialSite.getId()%>');"><%=socialSite.getDisplayTitle(user.getLanguage())%></a></li>
                                <%
                            }
                        }
                    }else if(user.hasUserGroup(userSuperAdminGrp)) {//Es SuperUsuario
                        %>
                            <li><a href="javascript:setBack();getBrandStreams('<%=socialSite.getId()%>');"><%=socialSite.getDisplayTitle(user.getLanguage())%></a></li>
                        <%
                    }
                }
            }
          %>  
        </ul>
    </div>                         
 </div>

        
        
<div id="headerX" class="novisible">
    <a href="javascript:window.history.go(-1);" data-icon="back" data-iconpos="notext">Regresar</a>
    <a target="_blank" href="http://www.semanticwebbuilder.com.mx/SWBSocial">SWB Social&copy;</a>
</div>
        
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