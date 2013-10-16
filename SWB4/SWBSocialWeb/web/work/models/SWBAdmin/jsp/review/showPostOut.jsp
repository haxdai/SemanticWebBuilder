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
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<%
    org.semanticwb.model.User user = paramRequest.getUser();
    if (request.getAttribute("postOut") == null) {
        return;
    }

    SemanticObject semObj = (SemanticObject) request.getAttribute("postOut");
    if (semObj == null) {
        return;
    }
    WebSite wsite = WebSite.ClassMgr.getWebSite(semObj.getModel().getName());
    if (wsite == null) {
        return;
    }

    PostOut postOut = (PostOut) semObj.getGenericInstance();
    //Un mensaje de entrada siempre debe estar atachado a un usuario de la red social de la que proviene, de esta manera, es como desde swbsocial
    //se responderķa a un mensaje

    User userCreator = postOut.getCreator();
    System.out.println("userCreator George:" + userCreator);
    String userPhoto = userCreator.getPhoto();
    if (userPhoto == null) {
        userPhoto = "/swbadmin/css/images/profileDefImg.jpg";
    } else {
        userPhoto = SWBPortal.getWebWorkPath() + userCreator.getWorkPath() + "/" + User.swb_usrPhoto.getName() + "_" + userCreator.getId() + "_" + userPhoto;
    }    
%>


<div class="swbform swbpopup msj-txt">
    <div class="perfilgral">
        <div class="perfil">
            <img src="<%=userPhoto%>" width="150" height="150"/>
            <p><%=userCreator.getFullName()%> </p>

        </div>
        <div class="clear"></div>      
    </div>
    <div class="msj-div"></div>





    <%
       String isSentMgstoClassify=SWBSocialUtil.Util.getModelPropertyValue(wsite, SWBSocialUtil.CLASSIFYSENTMGS_PROPNAME);
       if(isSentMgstoClassify!=null && isSentMgstoClassify.equalsIgnoreCase("true")) //Los mensajes de salida si se deben clasificar por sentimientos e intensidad, tal como los de entrada.
       {
    %>    

    <table><tr>
            <td>
                <%=SWBSocialUtil.Util.getStringFromGenericLocale("sentiment", user.getLanguage())%>:
                <%
                    if (postOut.getPostSentimentalType() == 0) {
                %>
                ---
                <%                  } else if (postOut.getPostSentimentalType() == 1) {
                %>
                <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/pos.png">
                <%
                } else if (postOut.getPostSentimentalType() == 2) {
                %>
                <img src="<%=SWBPortal.getContextPath()%>/swbadmin/css/images/neg.png">
                <%
                    }
                %>
            </td>
            <td align="center">
                <%=SWBSocialUtil.Util.getStringFromGenericLocale("intensity", user.getLanguage())%>:<%=postOut.getPostIntesityType() == 0 ? paramRequest.getLocaleString("low") : postOut.getPostIntesityType() == 1 ? paramRequest.getLocaleString("medium") : postOut.getPostIntesityType() == 2 ? paramRequest.getLocaleString("high") : "---"%>
            </td>
            <td align="center">
                <%=SWBSocialUtil.Util.getStringFromGenericLocale("priority", user.getLanguage())%>:<%=postOut.isIsPrioritary() ? SWBSocialUtil.Util.getStringFromGenericLocale("yes", user.getLanguage()) : SWBSocialUtil.Util.getStringFromGenericLocale("not", user.getLanguage())%>
            </td> 
        </tr>
    </table>
    <%
        }
    %>

    <%

        if (semObj.getGenericInstance() instanceof Message) {
            Message message = (Message) semObj.getGenericInstance();
    %>
    <div class="msj-inf">
        <p>
            <%=SWBUtils.TEXT.encode(message.getMsg_Text(), "utf8")%>
        </p>
    </div>
    <%
    } else if (semObj.getGenericInstance() instanceof Photo) {
        Photo photo = (Photo) semObj.getGenericInstance();
        //System.out.println("Name:"+Photo.social_Photo.getName()); 
        //System.out.println("ClassID:"+Photo.social_Photo.getClassId()); 
        //System.out.println("Canonical:"+Photo.social_Photo.getCanonicalName());
        //Puse ese tolowercase porque el nombre de la propiedad lo pone en mayuscula, quien sabe porque, si esta en minuscula
%>

    <br><%=SWBUtils.TEXT.encode(photo.getMsg_Text(), "utf8")%>

    <%
        Iterator<String> itPhotos = photo.listPhotos();
        while (itPhotos.hasNext()) {
            String sphoto = itPhotos.next();
    %>

    <img src="<%=SWBPortal.getWebWorkPath()%><%=photo.getWorkPath()%>/<%=sphoto%>">

    <%
        }
    %>

    <%
    } else if (semObj.getGenericInstance() instanceof Video) {
        Video video = (Video) semObj.getGenericInstance();
        String videoFormat = "";
        String videoUrl = video.getVideo();
        if (videoUrl.toLowerCase().contains("www.youtube.com")) {//show player from youtube
            videoFormat = "youtube";
        } else if (videoUrl.toLowerCase().contains(".mp4")) {
            videoFormat = "video/mp4";
        } else if (videoUrl.toLowerCase().contains(".swf")) {
            videoFormat = "flash";
        } else if (videoUrl.toLowerCase().contains(".flv")) {
            videoFormat = "flv";
        } else if (videoUrl.toLowerCase().contains(".wav")) {
            videoFormat = "wav";
        }else if (videoUrl.toLowerCase().contains(".wmv")) {
            videoFormat = "wmv";
        }
    %>    

    <%
        if (videoFormat.equals("flv")) {
    %>

    <%=SWBUtils.TEXT.encode(video.getMsg_Text(), "utf8")%>
    <br>
    <object id="video" type="application/x-shockwave-flash" data="<%=SWBPlatform.getContextPath()%>/swbadmin/player_flv_maxi.swf" width="400" height="200">
        <param name="movie" value="<%=SWBPlatform.getContextPath()%>/swbadmin/player_flv_maxi.swf" />
        <param name="FlashVars" value="flv=<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>"/>
    </object>
    <%
    } else if (videoFormat.equals("flash")) {
    %>

    <%=SWBUtils.TEXT.encode(video.getMsg_Text(), "utf8")%>
    <br>
    <object width="400" height="200" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000"   codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0"> 
        <param name="SRC" value="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>">
        <embed src="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" width="400" height="200"></embed>
    </object>



    <%} else if (videoFormat.equals("mp4")) {
    %>   
    <%=SWBUtils.TEXT.encode(video.getMsg_Text(), "utf8")%>
    <br>
    <video width="400" height="200" controls>
        <source src="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" type="video/mp4">
        <object data="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" width="400" height="200">
            <embed src="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" width="400" height="200" autostart="false">    
        </object>
    </video>

    <%
    } else if (videoFormat.equals("wav")) {
    %>
    <%=SWBUtils.TEXT.encode(video.getMsg_Text(), "utf8")%>
    <br>
    <object width="400" height="200" classid="clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B" codebase="http://www.apple.com/qtactivex/qtplugin.cab">
        <param name="src" value="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>">
        <param name="controller" value="true">
    </object>

    <%
    } else if (videoFormat.equals("wmv")) {

    %>    

    <%=SWBUtils.TEXT.encode(video.getMsg_Text(), "utf8")%>
    <br>
    <object width="400" height="200" type="video/x-ms-asf" url="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" data="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6">
        <param name="url" value="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>">
        <param name="filename" value="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>">
        <param name="autostart" value="1">
        <param name="uiMode" value="full">
        <param name="autosize" value="1">
        <param name="playcount" value="1"> 
        <embed type="application/x-mplayer2" src="<%=SWBPortal.getWebWorkPath()%><%=video.getWorkPath()%>/<%=video.getVideo()%>" width="400" height="200" autostart="true" showcontrols="true" pluginspage="http://www.microsoft.com/Windows/MediaPlayer/"></embed>
    </object>

    <%
        }

    %>
    <%
        }
    %>
</table>
</div>