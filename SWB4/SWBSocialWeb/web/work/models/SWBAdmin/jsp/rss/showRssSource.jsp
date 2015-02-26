<%-- 
    Document   : showPostIn
    Created on : 03-jun-2013, 13:01:48
    Author     : jorge.jimenez
--%>
<%@page import="org.semanticwb.social.admin.resources.util.SWBSocialResUtil"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.social.util.*"%>
<%@page import="java.util.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<%
    if (request.getAttribute("rssSource") == null) {
        return;
    }

    SemanticObject semObj = (SemanticObject) request.getAttribute("rssSource");
    if (semObj == null) {
        return;
    }

    WebSite wsite = WebSite.ClassMgr.getWebSite(semObj.getModel().getName());
    if (wsite == null) {
        return;
    }

    RssSource rssSource = (RssSource) semObj.getGenericInstance();
    if(rssSource==null) return;
    //Un mensaje de entrada siempre debe estar atachado a un usuario de la red social de la que proviene, de esta manera, es como desde swbsocial
    //se respondería a un mensaje
   
    String rssSourcePhoto = "/swbadmin/css/images/profileDefImg.jpg";
    if(rssSource.getRssPhoto()!=null) 
    {
        rssSourcePhoto = SWBPortal.getWebWorkPath()+rssSource.getWorkPath()+"/"+rssSource.getRssPhoto(); //Sacar la foto de la fuente RSS;
    }
    
    if(request.getParameter("mobileMode")!=null)
    {
    %>
       <div class="">
          <input type="button" value="Regresar" onclick="history.go(-1);"/>
       </div>
    <%}%>
<div class="swbform swbpopup usr-pop">
    <div class="perfilgral">
        <div class="perfil">           
            <img src="<%=rssSourcePhoto%>"/>            
        </div>
        <div class="clear"></div>
    </div>
    <table class="tabla1">
        <thead>
            <tr>               
                <th>
                    <span><%=SWBUtils.TEXT.encode(paramRequest.getLocaleString("post"), "utf8")%></span>
                </th>
                <th>
                    <span><%=SWBUtils.TEXT.encode(paramRequest.getLocaleString("description"), "utf8")%></span>
                </th>
                <th>
                    <span><%=paramRequest.getLocaleString("url")%></span>
                </th>                          
            </tr>
        </thead>


        <tbody>
            <tr>
                <td>
                    <span id="msgText"></span>
                    <%=rssSource.getTitle()!=null ? rssSource.getTitle():""%>  
                </td>

                <td>
                    <span id="msgText"></span>
                    <%=rssSource.getDescription()!=null ? rssSource.getDescription():""%>  
                </td>

                <td>
                    <span id="msgText"></span>
                    <%=rssSource.getRss_URL()!=null ? "<a target=\"_rssNew\" href=\""+rssSource.getRss_URL()+"\">"+rssSource.getRss_URL()+"</a>":""%>  
                </td>
            </tr>
        </tbody>
    </table>
</div>
<%if(request.getParameter("mobileMode")!=null){%>
  </div> 
<%}%>  