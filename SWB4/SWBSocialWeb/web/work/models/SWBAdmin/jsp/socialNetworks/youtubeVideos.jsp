<%-- 
    Document   : myVideos
    Created on : 12/09/2013, 07:37:35 PM
    Author     : francisco.jimenez
--%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page import="org.w3c.dom.Document"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.w3c.dom.Node"%>
<%@page import="org.w3c.dom.NodeList"%>
<%@page import="java.io.StringReader"%>
<%@page import="java.io.StringReader"%>
<%@page import="javax.xml.parsers.DocumentBuilder"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="javax.xml.parsers.DocumentBuilderFactory"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.social.PostIn"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.social.SocialUserExtAttributes"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.SWBModel"%>
<%@page import="org.semanticwb.social.SocialNetwork"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.social.Youtube"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.w3c.dom.Element"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.Reader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.Closeable"%>
<%@page import="java.util.Collection"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Map"%>
<%@page import="static org.semanticwb.social.admin.resources.YoutubeWall.*"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<!DOCTYPE html>
<style type="text/css">
    span.inline { display:inline; }
</style>
<div class="timelineTab" style="padding:10px 5px 10px 5px; overflow-y: scroll; height: 400px;">
<%
    int totalVideos = 0;
    JSONArray videosArray = null;
    String uploadList = null;
    HashMap<String, String> params = new HashMap<String, String>(4);
    params.put("part", "id,contentDetails");
    params.put("mine", "true");
    params.put("maxResults", "25");
    String objUri = (String)request.getParameter("suri");
    SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
    Youtube semanticYoutube = (Youtube) semanticObject.createGenericInstance();
    if (!semanticYoutube.validateToken()) {//If was unable to refresh the token
        out.println("Problem refreshing access token");
        return;
    }
    out.println("<div class=\"timelineTab-title\" style=\"width: 620px !important;\"><p style=\"width:620px\"><strong>" +
            "Mis Videos" + "</strong>" + semanticYoutube.getTitle() + "</p></div>");
    
    //Primero se obtiene la lista de canales del usuario
    String ytResponse = semanticYoutube.getRequest(params, Youtube.API_URL + "/channels",
                                                   Youtube.USER_AGENT, "GET");
    JSONObject channelsResponse = new JSONObject(ytResponse);
    JSONArray channelLists = null;
    if (!channelsResponse.isNull("items")) {
        channelLists = channelsResponse.getJSONArray("items");
    }
    if (channelLists != null && channelLists.length() > 0) {
        JSONObject channel = channelLists.getJSONObject(0);
        if (!channel.isNull("contentDetails") &&
                !channel.getJSONObject("contentDetails").isNull("relatedPlaylists")) {
            JSONObject relatedLists = channel.getJSONObject("contentDetails").getJSONObject("relatedPlaylists");
            uploadList = !relatedLists.isNull(("uploads")) 
                         ? relatedLists.getString("uploads") : null;
        }
        //Del canal, se obtiene la lista de videos cargados
        if (uploadList != null) {
            HashMap<String, String> videoParams = new HashMap<String, String>(2);
            videoParams.put("part", "id,snippet");
            videoParams.put("playlistId", uploadList);
            videoParams.put("maxResults", "25");//por defecto = 5, maximo 50
                        
            //antes: http://gdata.youtube.com/feeds/api/users/default/uploads
            //se pide el contenido de la lista "uploads"
            String videosResponse = semanticYoutube.getRequest(videoParams,
                                    Youtube.API_URL + "/playlistItems", Youtube.USER_AGENT, "GET");
            JSONObject videosList = new JSONObject(videosResponse);
            if (!videosList.isNull("items")) {
                videosArray = videosList.getJSONArray("items");
            }
            if (!videosList.isNull("pageInfo") &&
                    !videosList.getJSONObject("pageInfo").isNull("totalResults")) {
                totalVideos = videosList.getJSONObject("pageInfo").getInt("totalResults");
            }
        }
    }
    SocialNetwork socialNetwork = (SocialNetwork) semanticYoutube;
    //SWBModel model = WebSite.ClassMgr.getWebSite(socialNetwork.getSemanticObject().getModel().getName());
    String postURI = null;
    org.semanticwb.model.User user = paramRequest.getUser();
    HashMap<String, SemanticProperty> mapa = new HashMap<String, SemanticProperty>();
    Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(
                        "http://www.semanticwebbuilder.org/swb4/social#SocialUserExtAttributes").listProperties();
    while (list.hasNext()) {
        SemanticProperty sp = list.next();
        mapa.put(sp.getName(), sp);
    }
    boolean userCanRetopicMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanReTopicMsg"))).booleanValue();
    boolean userCanRespondMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRespondMsg"))).booleanValue();
    boolean userCanRemoveMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRemoveMsg"))).booleanValue();

    UserGroup userSuperAdminGrp=SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
    //THE INFO OF THE USER SHOULD BE DISPLAYED AT TOP
    if (videosArray != null) {
        for (int i = 0; i < videosArray.length(); i++ ) {
            //totalVideos++;
            JSONObject listItem = videosArray.getJSONObject(i);
            String videoId = null;
            if (!listItem.isNull("snippet") && !listItem.getJSONObject("snippet").isNull("resourceId") &&
                    !listItem.getJSONObject("snippet").getJSONObject("resourceId").isNull("kind") &&
                    listItem.getJSONObject("snippet").getJSONObject("resourceId").getString("kind").equals("youtube#video")) {
                videoId = listItem.getJSONObject("snippet").getJSONObject("resourceId").getString("videoId");
            }
            if (videoId != null) {
                HashMap<String, String> videoParams = new HashMap<String, String>();
                videoParams.put("part", "snippet,status,statistics");
                videoParams.put("id", videoId);
                //TODO: agregar request del video:
                JSONObject listVideo = new JSONObject(semanticYoutube.getRequest(videoParams,
                                           Youtube.API_URL + "/videos", Youtube.USER_AGENT, "GET"));
                if (!listVideo.isNull("items")) {
                    JSONObject video = listVideo.getJSONArray("items").getJSONObject(0);
                    doPrintVideo(request, response, paramRequest, out, postURI, video,
                                 user.hasUserGroup(userSuperAdminGrp), userCanRetopicMsg,
                                 userCanRespondMsg, userCanRemoveMsg);
                }
            }
        }

        if (totalVideos >= 25) {
%>
    <div id="<%=objUri%>/getMoreVideos" dojoType="dojox.layout.ContentPane">
        <div align="center" style="margin-bottom: 10px;">
            <label id="<%=objUri%>/moreVideosLabel">
                <a href="#" onclick="appendHtmlAt('<%=paramRequest.getRenderUrl().setMode("getMoreVideos").
                        setParameter("maxVideoId", totalVideos + "").
                        setParameter("uploadsList", uploadList).
                        setParameter("suri", objUri)%>','<%=objUri%>' + '/getMoreVideos', 'bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;">
                    Mas Videos
                </a></label>
        </div>
    </div>
<%
        }
    }
%>
</div>