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
    if (request.getAttribute("rssNew") == null) {
        return;
    }

    SemanticObject semObj = (SemanticObject) request.getAttribute("rssNew");
    if (semObj == null) {
        return;
    }

    WebSite wsite = WebSite.ClassMgr.getWebSite(semObj.getModel().getName());
    if (wsite == null) {
        return;
    }

    RssNew rssNew = (RssNew) semObj.getGenericInstance();
    //Un mensaje de entrada siempre debe estar atachado a un usuario de la red social de la que proviene, de esta manera, es como desde swbsocial
    //se respondería a un mensaje
   
    String rssSourcePhoto = "/swbadmin/css/images/profileDefImg.jpg";
    RssSource rssSource=rssNew.getRssSource(); 
    if(rssNew.getRssSource()!=null) 
    {
        rssSourcePhoto = SWBPortal.getWebWorkPath()+rssSource.getWorkPath()+"/"+rssNew.getRssSource().getRssPhoto(); //Sacar la foto de la fuente RSS;
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
            <p><%=rssNew.getRssSource()!=null && rssNew.getRssSource().getTitle()!=null?rssNew.getRssSource().getTitle():"Sin Fuente Rss"%></p>
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
                    <span><%=SWBUtils.TEXT.encode(paramRequest.getLocaleString("created"), "utf8")%></span>
                </th>
                <th>
                    <span><%=paramRequest.getLocaleString("sentiment")%></span>
                </th>
                <%if(request.getParameter("mobileMode")==null)
                {
                %>
                <th>
                    <span><%=paramRequest.getLocaleString("intensity")%></span>
                </th>
                <%}%>                
            </tr>
        </thead>


        <tbody>
            <tr>

                <%
                     String title="";
                     if(SWBUtils.TEXT.encode(rssNew.getTitle(), "utf-8")!=null) title=SWBUtils.TEXT.encode(rssNew.getTitle(), "utf-8");
                     title=title.replaceAll("\n", ""); 
                     String description="";
                     if(SWBUtils.TEXT.encode(rssNew.getDescription(), "utf-8")!=null) description=SWBUtils.TEXT.encode(rssNew.getDescription(), "utf-8");
                     description=description.replaceAll("\n", ""); 
                    //System.out.println("Name:"+Photo.social_Photo.getName()); 
                    //System.out.println("ClassID:"+Photo.social_Photo.getClassId()); 
                    //System.out.println("Canonical:"+Photo.social_Photo.getCanonicalName());
                    //Puse ese tolowercase porque el nombre de la propiedad lo pone en mayuscula, quien sabe porque, si esta en minuscula 
%>
                    <td>
                        <span id="msgText"></span>
                        <%=rssNew.getRssLink()!=null?"<a target=\"rssNew_New\" href=\""+rssNew.getRssLink()+"\">"+title+"</a>":title%> 
                    </td>
                    <td>
                        <span id="msgText"></span>
                        <%=description%> 
                    </td>
                    <td>
                        <span id="msgText"></span>
                        <%=rssNew.getRssPubDate()!=null?rssNew.getRssPubDate():""%>   
                    </td> 
                    
                    <td>
                    <%
                    if (rssNew.getRssNewSentimentalType() == 0) {
                    %>
                    ---
                    <% } else if (rssNew.getRssNewSentimentalType() == 1) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/pos.png">
                    <%
                    } else if (rssNew.getRssNewSentimentalType() == 2) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/neg.png">
                    <%
                        }
                    %>
                  </td>
                <%if(request.getParameter("mobileMode")==null)
                {
                %>  
                <td>
                    <!--<%=rssNew.getRssNewIntensityType() == 0 ? paramRequest.getLocaleString("low") : rssNew.getRssNewIntensityType() == 1 ? paramRequest.getLocaleString("medium") : rssNew.getRssNewIntensityType() == 2 ? paramRequest.getLocaleString("high") : "---"%>-->

                    <%
                        if (rssNew.getRssNewIntensityType() == 0) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/ibaja.png" width="25" height="25" alt="<%=paramRequest.getLocaleString("low")%>">
                    <%        } else if (rssNew.getRssNewIntensityType() == 1) {
                    %>    
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/imedia.png" width="25" height="25" alt="<%=paramRequest.getLocaleString("medium")%>">
                    <%
                    } else if (rssNew.getRssNewIntensityType() == 2) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/ialta.png" width="25" height="25" alt="<%=paramRequest.getLocaleString("high")%>">
                    <%
                    } else {
                    %>
                    ----
                    <%}%>
                </td> 
                <%}%>
            </tr>
            <tr>
            <td colspan="5">
                <%=rssNew.getMediaContent()!=null?"<img src=\""+rssNew.getMediaContent()+"\"/>":""%> 
            </td>
            </tr>
        </tbody>
    </table>
</div>
<%if(request.getParameter("mobileMode")!=null){%>
  </div> 
<%}%>  