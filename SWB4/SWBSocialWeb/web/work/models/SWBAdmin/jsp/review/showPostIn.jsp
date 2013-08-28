<%-- 
    Document   : showPostIn
    Created on : 03-jun-2013, 13:01:48
    Author     : jorge.jimenez
--%>

<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.social.util.*"%>
<%@page import="java.util.*"%>
<%@page import="twitter4j.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<%
    org.semanticwb.model.User user = paramRequest.getUser();
    System.out.println("postInJsp:" + request.getAttribute("postIn"));
    if (request.getAttribute("postIn") == null) {
        return;
    }

    SemanticObject semObj = (SemanticObject) request.getAttribute("postIn");
    if (semObj == null) {
        return;
    }

    WebSite wsite = WebSite.ClassMgr.getWebSite(semObj.getModel().getName());
    if (wsite == null) {
        return;
    }

    PostIn postIn = (PostIn) semObj.getGenericInstance();
    //Un mensaje de entrada siempre debe estar atachado a un usuario de la red social de la que proviene, de esta manera, es como desde swbsocial
    //se responder�a a un mensaje
    if (postIn.getPostInSocialNetworkUser() == null) {
        return;
    }

    SocialNetworkUser socialNetworkUser = postIn.getPostInSocialNetworkUser();
    String userPhoto = socialNetworkUser.getSnu_photoUrl(); //Sacar la foto de la redSocial;
    if (userPhoto == null) {
        userPhoto = "/swbadmin/css/images/profileDefImg.jpg";
    }

%>


<div class="swbform swbpopup usr-pop">
    <div class="perfilgral">
        <div class="perfil">           
            <img src="<%=userPhoto%>"/>
            <p><%=socialNetworkUser.getSnu_name()%></p>
        </div>
        <p><strong><%=socialNetworkUser.getFollowers()%></strong> <%=SWBSocialUtil.Util.getStringFromGenericLocale("followers", user.getLanguage())%></p>
        <p><strong><%=socialNetworkUser.getFriends()%></strong> <%=SWBSocialUtil.Util.getStringFromGenericLocale("friends", user.getLanguage())%></p>
        <p><strong><%=socialNetworkUser.getSnu_klout()%></strong> Klout</p>

        <div class="clear"></div>
    </div>

    <table class="tabla1">
        <thead>
            <tr>               
                <th>
                    <span><%=paramRequest.getLocaleString("post")%></span>
                </th>
                <th>
                    <span><%=paramRequest.getLocaleString("sentiment")%></span>
                </th>
                <th>
                    <span><%=paramRequest.getLocaleString("intensity")%></span>
                </th>
                <th>
                    <span><%=paramRequest.getLocaleString("replies")%></span>
                </th>
                <th>
                    <span><%=paramRequest.getLocaleString("place")%></span>
                </th>
                <th>
                    <span><%=paramRequest.getLocaleString("prioritary")%></span>
                </th>
            </tr>
        </thead>


        <tbody>
            <tr>

                <%
                    if (semObj.getGenericInstance() instanceof MessageIn) {
                        MessageIn message = (MessageIn) semObj.getGenericInstance();
                %>
                <td><span><%=SWBUtils.TEXT.encode(message.getMsg_Text(), "utf8")%></span>
                </td>
                <%
                } else if (semObj.getGenericInstance() instanceof PhotoIn) {
                    PhotoIn photo = (PhotoIn) semObj.getGenericInstance();
                    //System.out.println("Name:"+Photo.social_Photo.getName()); 
                    //System.out.println("ClassID:"+Photo.social_Photo.getClassId()); 
                    //System.out.println("Canonical:"+Photo.social_Photo.getCanonicalName());
                    //Puse ese tolowercase porque el nombre de la propiedad lo pone en mayuscula, quien sabe porque, si esta en minuscula 
                %>
                <td>
                    <%
                        Iterator<String> itPhotos = photo.listPhotos();
                        while (itPhotos.hasNext()) {
                            String sphoto = itPhotos.next();
                    %>    
                    <img src="<%=sphoto%>">
                    <%
                        }
                    %>     
                    <%=SWBUtils.TEXT.encode(photo.getMsg_Text(), "utf8")%>
                </td>
                <%
                } else if (semObj.getGenericInstance() instanceof VideoIn) {
                    VideoIn video = (VideoIn) semObj.getGenericInstance();
                %>    
                <td>
                    <br/><br/><embed src="<%=video.getVideo()%>" width="195" height="150" autostart="false">    
                    <br/><br/><%=SWBUtils.TEXT.encode(video.getMsg_Text(), "utf8")%>
                </td>
                <%
                    }
                %>



                <td>

                    <%
                        if (postIn.getPostSentimentalType() == 0) {
                    %>
                    ---
                    <%                    } else if (postIn.getPostSentimentalType() == 1) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/feelpos.png">
                    <%
                    } else if (postIn.getPostSentimentalType() == 2) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/feelneg.png">
                    <%
                        }
                    %>
                </td>
                <td>
                    <!--<%=postIn.getPostIntesityType() == 0 ? paramRequest.getLocaleString("low") : postIn.getPostSentimentalType() == 1 ? paramRequest.getLocaleString("medium") : postIn.getPostSentimentalType() == 2 ? paramRequest.getLocaleString("high") : "---"%>-->

                    <%
                        if (postIn.getPostIntesityType() == 0) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/ibaja.png" width="25" height="25" alt="<%=paramRequest.getLocaleString("low")%>">
                    <%        } else if (postIn.getPostIntesityType() == 1) {
                    %>    
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/imedia.png" width="25" height="25" alt="<%=paramRequest.getLocaleString("medium")%>">
                    <%
                    } else if (postIn.getPostIntesityType() == 2) {
                    %>
                    <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/ialta.png" width="25" height="25" alt="<%=paramRequest.getLocaleString("high")%>">
                    <%
                    } else {
                    %>
                    ----
                    <%}%>
                </td> 
                <td align="center">
                    <%=postIn.getPostShared()%>
                </td>
                <td align="center">
                    <%=postIn.getPostPlace() == null ? "---" : postIn.getPostPlace()%>
                </td> 
                <td align="center">
                    <%=postIn.isIsPrioritary() ? SWBSocialUtil.Util.getStringFromGenericLocale("yes", user.getLanguage()) : SWBSocialUtil.Util.getStringFromGenericLocale("not", user.getLanguage())%>
                </td> 
            </tr>



            <!--  <tr>
              
            <%

                if (semObj.getGenericInstance() instanceof MessageIn) {
                    MessageIn message = (MessageIn) semObj.getGenericInstance();
            %>
            <td colspan="5"><%=SWBUtils.TEXT.encode(message.getMsg_Text(), "utf8")%>
            </td>
            <%
            } else if (semObj.getGenericInstance() instanceof PhotoIn) {
                PhotoIn photo = (PhotoIn) semObj.getGenericInstance();
                //System.out.println("Name:"+Photo.social_Photo.getName()); 
                //System.out.println("ClassID:"+Photo.social_Photo.getClassId()); 
                //System.out.println("Canonical:"+Photo.social_Photo.getCanonicalName());
                //Puse ese tolowercase porque el nombre de la propiedad lo pone en mayuscula, quien sabe porque, si esta en minuscula 
            %>
                            <td colspan="5">
            <%
                Iterator<String> itPhotos = photo.listPhotos();
                while (itPhotos.hasNext()) {
                    String sphoto = itPhotos.next();
            %>    
                    <img src="<%=SWBPortal.getWebWorkPath()%><%=photo.getWorkPath()%>/<%=Photo.social_hasPhoto.getName().toLowerCase()%>_<%=photo.getId()%>_<%=sphoto%>">
            <%
                }
            %>        
            <br><br><br><%=SWBUtils.TEXT.encode(photo.getMsg_Text(), "utf8")%>
            </td>
            <%
            } else if (semObj.getGenericInstance() instanceof VideoIn) {
                VideoIn video = (VideoIn) semObj.getGenericInstance();
            %>    
                <td colspan="5">
            <%=video.getVideo()%>
            <br/><br/><embed src="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" width="195" height="150" autostart="false">
            <br><br><br><%=SWBUtils.TEXT.encode(video.getMsg_Text(), "utf8")%>
            </td>
            <%
                }
            %>
            </tr>-->
        </tbody>
    </table>
</div>

