<%-- 
    Document   : userHistory
    Created on : 26-jun-2013, 11:48:57
    Author     : jorge.jimenez
--%>

<%@page import="org.semanticwb.social.admin.resources.util.SWBSocialResUtil"%>
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
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<%
    String suri=(String)request.getAttribute("suri");
    //System.out.println("suri UserH:"+suri);
    if(suri==null) return; 
    org.semanticwb.model.User user = paramRequest.getUser();
    if (request.getAttribute("swbSocialUser") == null) {
        return;
    }
    
    SemanticObject semObj = (SemanticObject) request.getAttribute("swbSocialUser");
    if (semObj == null) {
        return;
    }
    //System.out.println("semObj-User:"+semObj);

    WebSite wsite = WebSite.ClassMgr.getWebSite(semObj.getModel().getName());
    if (wsite == null) {
        return;
    }

    SocialNetworkUser socialNetUser = (SocialNetworkUser) semObj.getGenericInstance();
    //System.out.println("socialNetUser:"+socialNetUser);
    //Un mensaje de entrada siempre debe estar atachado a un usuario de la red social de la que proviene, de esta manera, es como desde swbsocial
    //se responder�a a un mensaje
    if (socialNetUser == null) {
        return;
    }

    String userPhoto = socialNetUser.getSnu_photoUrl(); //Sacar la foto de la redSocial;
    if (userPhoto == null) {
        userPhoto = "/swbadmin/css/images/profileDefImg.jpg";
    }
    //System.out.println("JspJ1");
%>

<div class="swbform swbpopup usr-pop">
    <div class="perfilgral">
        <div class="perfil">
            <img src="<%=userPhoto%>"/>        
            <p>
                <%=SWBUtils.TEXT.encode(socialNetUser.getSnu_name(), "utf-8")%>
                <!-- <%=socialNetUser.getSnu_SocialNetworkObj() != null ? socialNetUser.getSnu_SocialNetworkObj().getId() : "---"%>-->
            </p>
        </div>
        <p><strong><%=socialNetUser.getFollowers()%></strong> <%=SWBSocialResUtil.Util.getStringFromGenericLocale("followers", user.getLanguage())%></p>
        <p><strong><%=socialNetUser.getFriends()%></strong> <%=SWBSocialResUtil.Util.getStringFromGenericLocale("friends", user.getLanguage())%></p>
        <p><strong><%=socialNetUser.getSnu_klout()%></strong> Klout</p>
        <p>   
            <%
                //System.out.println(" ver 1");
                long cont=0;
                SemanticObject semObjTab=SemanticObject.getSemanticObject(suri);
                //System.out.println("JspJ2:"+semObjTab);
                if(semObjTab.getGenericInstance() instanceof Stream) 
                {
                    //System.out.println(" ver 1.1");
                    Stream stream=(Stream)semObjTab.getGenericInstance();
                    Iterator<PostIn> itPostIns = socialNetUser.listPostInInvs();
                    while(itPostIns.hasNext())
                    {
                        PostIn postIn=itPostIns.next();
                        //System.out.println("JspJ2.1KP:"+postIn);
                        //System.out.println("JspJ3KP:"+postIn.getPostInStream());
                        if(postIn.getPostInStream()!=null && postIn.getPostInStream().getURI().equals(stream.getURI()))
                        {
                            cont++; 
                        }
                    }                    
                }else if(semObjTab.getGenericInstance() instanceof SocialTopic) 
                {
                    SocialTopic socialTopic=(SocialTopic)semObjTab.getGenericInstance();
                    //System.out.println(" ver 1.2:"+socialTopic);
                    Iterator<PostIn> itPostIns = socialNetUser.listPostInInvs();
                    while(itPostIns.hasNext())
                    {
                        PostIn postIn=itPostIns.next();
                        if(postIn.getSocialTopic()!=null && postIn.getSocialTopic().getURI().equals(socialTopic.getURI()))
                        {
                            cont++; 
                        }
                    }                    
                }
                //System.out.println(" ver 2");
                SWBResourceURL url = paramRequest.getRenderUrl();
                url.setMode(SWBResourceURL.Action_EDIT);
                url.setParameter("swbSocialUser", socialNetUser.getId());
                url.setParameter("dialog", "close");
                url.setParameter("suri", (String) request.getAttribute("suri"));
                url.setParameter("reloadTap", "true");
            %>
            <strong><a href="#" onclick="submitUrl('<%=url.setParameter("swbSocialUser", socialNetUser.getId())%>',this); return false;"><%=cont%></a></strong>  Mensajes de entrada
        </p>
        <div class="clear"></div>
    </div>
</div>



