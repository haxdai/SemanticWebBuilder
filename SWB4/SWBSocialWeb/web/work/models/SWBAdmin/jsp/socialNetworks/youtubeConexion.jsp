<%-- 
    Document   : youtubeConexion
    Created on : 9/01/2014, 05:14:46 PM
    Author     : gabriela.rosales
--%>
<%@page import="org.semanticwb.social.Youtube"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.SWBModel"%>
<%@page import="org.semanticwb.social.SocialTopic"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.SWBModel"%>
<%@page import="static org.semanticwb.social.admin.resources.YoutubeWall.*"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page import="java.util.HashMap"%>
<%!
    public static String getMySubscriptions(Youtube youtube) {
       
        HashMap<String, String> paramsVideo = new HashMap<String, String>(4);
        paramsVideo.put("part", "snippet");
        paramsVideo.put("mine", "true");
        paramsVideo.put("maxResults", "50");
        String response = null;
        try {
            response = youtube.getRequest(paramsVideo, Youtube.API_URL + "/subscriptions",
                                          Youtube.USER_AGENT, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
%>

<%
    String uri = (String) request.getParameter("suri");
    SemanticObject semanticObject = SemanticObject.createSemanticObject(uri);
    Youtube youtube = (Youtube) semanticObject.createGenericInstance();
    
    if (!youtube.validateToken()) {//If was unable to refresh the token
        //System.out.println("unable to refresh the token!");
        out.println("Problem refreshing access token");
        return;
    }
    
    String usrSubscriptions = getMySubscriptions(youtube);
    JSONObject usrResp = new JSONObject(usrSubscriptions);
    JSONArray usrData = usrResp.getJSONArray("items");
    JSONObject object = new JSONObject();
    JSONObject objectID = new JSONObject();
%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<!DOCTYPE html>
<div class="timelineTab" style="padding:10px 5px 10px 5px; overflow-y: scroll; height: 400px;">
<%                                
    //out.println("<div align=\"center\"><h2>  </br> Siguiendo</h2><br/></div>");
    out.println("  <div class=\"timelineTab-title\"><p><strong>Conexiones</strong>Personas que sigo</p></div>");
//    String name = null;
    for (int k = 0; k < usrData.length(); k++) {
        object = usrData.getJSONObject(k);
        JSONObject snippet = object.getJSONObject("snippet");
        objectID = snippet.getJSONObject("resourceId");
        String name = !snippet.isNull("title")
                      ? snippet.getString("title")
                      : !snippet.isNull("channelTitle") ? snippet.getString("channelTitle") : "" ; //(JSONObject) object.get("yt$username");
        JSONObject thumbnail = null;
        if (!snippet.isNull("thumbnails")) {
            if (!snippet.getJSONObject("thumbnails").isNull("default")) {
                thumbnail = snippet.getJSONObject("thumbnails").getJSONObject("default");
            } else if (!snippet.getJSONObject("thumbnails").isNull("medium")) {
                thumbnail = snippet.getJSONObject("thumbnails").getJSONObject("medium");
            }
        }
%>
    <div class="timeline timelinetweeter">
        <p class="tweeter">
            <a onclick="showDialog('<%=paramRequest.getRenderUrl().setMode("showUserProfile").setParameter("id", objectID.getString("channelId")).setParameter("suri", uri)%>', '<%=name%>'); return false;" href="#"><%=name%></a>
        </p>
        <p class="tweeter">
<%      if (thumbnail != null) {%>
            <a href="#" onclick="showDialog('<%=paramRequest.getRenderUrl().setMode("showUserProfile").setParameter("id", objectID.getString("channelId")).setParameter("suri", uri)%>', '<%=name%>'); return false;">
                <img src="<%=thumbnail.getString("url")%>" width="88" height="88"/>
            </a>
<%      }%>
        </p>
        <p class="tweet">
        </p>
    </div>
<%
    }
%>
</div>
