<%-- 
    Document   : youtubeEditVideo
    Created on : 29/09/2013, 09:58:56 PM
    Author     : francisco.jimenez
--%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.social.PostOutPrivacy"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.social.YouTubeCategory"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.SWBModel"%>
<%@page import="org.semanticwb.social.Youtube"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.HashMap"%>
<%@page import="static org.semanticwb.social.admin.resources.YoutubeWall.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%!
    public static String getVideoInfo(String id, Youtube youtube) {
        HashMap<String, String> params = new HashMap<String, String>(4);
        params.put("part", "snippet,status");
        params.put("id", id);
        String response = null;
        try {
            response = youtube.getRequest(params, Youtube.API_URL + "/videos",
                                          Youtube.USER_AGENT, "GET");
        } catch (Exception e) {
            System.out.println("Error getting user information"  + e.getMessage());
        }
        return response;
    }
%>
<%
    String videoId = (String) request.getParameter("videoId");
    String objUri = (String)request.getParameter("suri");
    if (videoId == null || objUri == null) {
        return;
    }
    
    SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
    Youtube semanticYoutube = (Youtube) semanticObject.createGenericInstance();
    
    if (!semanticYoutube.validateToken()) {//If was unable to refresh the token
        out.println("Problem refreshing access token");
        return;
    }
    
    String videoInfo = getVideoInfo(videoId, semanticYoutube);
    //out.println("userprofile:" + video);    
    //out.print("video:" + video);
    //response.getWriter().write("video:" + video);
    
    JSONObject jsonResp = videoInfo != null ? new JSONObject(videoInfo) : null;
    String title = "";
    String description = "";
    String category = "";
    String keywords = "";
    String privacy = "";
    JSONObject information = jsonResp != null && !jsonResp.isNull("items") && jsonResp.getJSONArray("items").length() > 0
                             ? jsonResp.getJSONArray("items").getJSONObject(0) : null;
    
    if (information != null) {
        JSONObject snippet = (!information.isNull("snippet")) ? information.getJSONObject("snippet") : null;
        if (snippet != null) {
            title = snippet.getString("title");
            description = snippet.getString("description");
            category = snippet.getString("categoryId");
            JSONArray tags = !snippet.isNull("tags") ? snippet.getJSONArray("tags") : null;
            StringBuilder videoTags = new StringBuilder(64);
            if (tags != null) {
                for (int i = 0; i < tags.length(); i++) {
                    videoTags.append(tags.getString(i));
                    if (!tags.getString(i).isEmpty()) {
                        videoTags.append(",");
                    }
                }
            }
            keywords = videoTags.toString().substring(0, videoTags.toString().length() - 1);
        }
        JSONObject status = (!information.isNull("status")) ? information.getJSONObject("status") : null;
        if (status != null) {
            privacy = (!status.isNull("privacyStatus")) ? status.getString("privacyStatus").toUpperCase() : "";
            if (privacy.equals("UNLISTED")) {
                privacy = "NOT_LISTED";
            }
        }
    }
%>
<div class="swbform" style="width: 500px">
    <fieldset>
        <div align="center">
            <embed src="<%=BASE_VIDEO_URL + videoId%>" width="250" height="195" autostart="false" type="application/x-shockwave-flash">
        </div>
    </fieldset>
        
    <form type="dijit.form.Form" id="editedVideo" action="<%=paramRequest.getActionUrl().setAction("doUpdateVideo").setParameter("suri", objUri).setParameter("videoId", videoId)%>"
          method="post" onsubmit="submitForm('editedVideo'); try{document.getElementById('csLoading').style.display='inline';}catch(noe){}; return false;">
        <fieldset>
            <legend><%=paramRequest.getLocaleString("title")%>:</legend>
            <div align="left">
                <input type="text" required="true" onblur="this.value=dojo.trim(this.value);" name="title" size="67" value="<%=title%>"/>
            </div>
        </fieldset>
        <fieldset>
            <legend><%=paramRequest.getLocaleString("description")%>:</legend>
            <div align="left">
                <textarea rows="5" cols="50" name="description"><%=description%></textarea>
            </div>
        </fieldset>
        <fieldset>
            <legend><%=paramRequest.getLocaleString("videoTags")%>:</legend>
            <div align="left">
                <input type="text" name="keywords" size="67" value="<%=keywords%>"/>
            </div>
        </fieldset>
        <fieldset>
            <legend><%=paramRequest.getLocaleString("category")%>:</legend>
            <div align="left">
                <select name="category">
<%
    Iterator<YouTubeCategory> itYtube = YouTubeCategory.ClassMgr.listYouTubeCategories(SWBContext.getGlobalWebSite());
    while (itYtube.hasNext()) {
        YouTubeCategory socialCategory = (YouTubeCategory) itYtube.next();
%>                    <option<%=category.equals(socialCategory.getId()) ? " selected" : ""%> value="<%=socialCategory.getId()%>"><%=socialCategory.getTitle()%></option>
<%
    }
%>
                </select>
            </div>
        </fieldset>
        <fieldset>
            <legend><%=paramRequest.getLocaleString("privacy")%>:</legend>
            <div align="left">
                <select name="privacy">
<%
    Iterator <PostOutPrivacy> postOutPs = PostOutPrivacy.ClassMgr.listPostOutPrivacies();
    while (postOutPs.hasNext()) {
        PostOutPrivacy postOutP = postOutPs.next();
        Iterator<SemanticObject> nets = postOutP.listNetworkTypes();
        while (nets.hasNext()) {
            SemanticObject semObjNetw = nets.next(); 
            SemanticClass sClass = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(semObjNetw.getURI());
            if (sClass.equals(Youtube.social_Youtube)) {
%>                <option value="<%=postOutP.getId()%>"<%=postOutP.getId().equals(privacy) ? " selected" : ""%>><%=postOutP.getTitle()%></option>
<%
            }
        }
    }
%>
                </select>
            </div>
        </fieldset>
        <div align="center">
            <button dojoType="dijit.form.Button" type="submit"><%=paramRequest.getLocaleString("update")%></button>
        </div>
    </form>
</div>
