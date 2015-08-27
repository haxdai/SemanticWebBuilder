<%-- 
    Document   : googlePlusNovelties
    Created on : 18/08/2015, 12:32:23 PM
    Author     : jose.jimenez
--%><%@
page import="org.json.JSONArray"%><%@
page import="org.json.JSONObject"%><%@
page import="java.text.SimpleDateFormat"%><%@
page import="java.util.*"%><%@
page import="java.net.*"%><%@
page import="org.semanticwb.model.*"%><%@
page import="org.semanticwb.social.*"%><%@
page import="org.semanticwb.platform.*"%><%@
page import="org.semanticwb.portal.api.SWBResourceURL"%><%@
page import="org.semanticwb.*"%><%@
page import="org.semanticwb.social.admin.resources.GooglePlusWall"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/><%
String tabTitle = (String) request.getAttribute("tabTitle");
JSONArray activities = (JSONArray) request.getAttribute("activities");
boolean userCanRetopicMsg = (Boolean) request.getAttribute("userCanRetopicMsg");
boolean userCanRespondMsg = (Boolean) request.getAttribute("userCanRespondMsg");
boolean userCanRemoveMsg = (Boolean) request.getAttribute("userCanRemoveMsg");
String nextPageToken = (String) request.getAttribute("nextPageToken");
%>
<style type="text/css">
    span.inline { display:inline; }
</style>
<div class="timelineTab" style="padding:10px 5px 10px 5px; overflow-y: scroll; height: 400px;">
    <div class="timelineTab-title" style="width: 620px !important;">
        <p style="width:620px">
            <strong>Mis Novedades</strong><%=tabTitle%>
        </p>
    </div>
<%
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm a", new Locale("es", "MX"));
    SimpleDateFormat parseDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", new Locale("es", "MX"));
    String startIndex = request.getParameter("startIndex"); //para peticiones de comentarios de cada actividad
    String objUri = request.getParameter("suri");
    Google semanticGoogle = (Google) SemanticObject.createSemanticObject(
            URLDecoder.decode(objUri, "UTF-8")).createGenericInstance();
    SWBModel model = WebSite.ClassMgr.getWebSite(semanticGoogle.getSemanticObject().getModel().getName());
    try {
        for (int i = 0; i < activities.length(); i ++) {
            JSONObject activity = activities.getJSONObject(i);
            String actTitle = !activity.isNull("title")
                              ? activity.getString("title") : "";
            String actId = !activity.isNull("id") ? activity.getString("id") : "";
            String actUrl = !activity.isNull("url") ? activity.getString("url") : "";
%>
    <div id="<%=semanticGoogle.getId() + "/" + actId %>" class="timeline timelinefacebook" dojoType="dojox.layout.ContentPane">
        <div id="<%=semanticGoogle.getId() + "/" + actId%>/detail">
            <p><%=actTitle%></p><!-- Username and story -->
            <div class="timelineimg">
                <span>
<%
            String imgPath = null;
            JSONObject actObject = !activity.isNull("object") ? activity.getJSONObject("object") : null;
            String description = actObject.isNull("content") ?  "" : actObject.getString("content").replace("\ufeff", "");
            if (activity.has("annotation") && !activity.getString("annotation").isEmpty()) {
                description = activity.getString("annotation") + description;
            }
            if (actObject.has("attachments")) {
                JSONArray attachments = actObject.getJSONArray("attachments");
                for (int j = 0; j < attachments.length(); j++) {
                    JSONObject attach = attachments.getJSONObject(j);
                    if (attach.has("image") && !attach.getJSONObject("image").isNull("url")) {
                        imgPath = attach.getJSONObject("image").getString("url");
                    } else if (attach.has("fullImage") && !attach.getJSONObject("fullImage").isNull("url")) {
                        imgPath = attach.getJSONObject("fullImage").getString("url");
                    }
                    if (imgPath != null && !imgPath.isEmpty()) {
                        break;
                    }
                }
            }
            if (imgPath != null && !imgPath.isEmpty()) {
%>
                    <span id="img<%=semanticGoogle.getId() + actId%>" style="width: 250px; height: 250px; border: thick #666666; overflow: hidden; position: relative;">
                        <!--a href="#" onclick="showDialog('<%=paramRequest.getRenderUrl().setMode("displayActivity").
                            setParameter("actUrl", URLEncoder.encode(actUrl, "UTF-8")).toString()%>', '<%=actTitle%>'); return false;"-->
                            <img src="<%=imgPath%>" style="position: relative;" onerror="this.src ='<%=imgPath%>'" onload="imageLoad(this, 'img<%=semanticGoogle.getId() + actId%>');"/>
                        <!--/a-->
                    </span>
<%
            }
%>
                </span>
                <p class="imgtitle"><%=actTitle.replace("\n", "</br>")%></p>
<%
            if (!actTitle.equalsIgnoreCase(description)) {
%>
                <p class ="imgdesc"><%=description.replace("\n", "</br>")%></p>
<%
            }
%>
            </div><!--//End First section-->
        </div>
        <div class="clear"></div>
        <!--Comments-->
<%
            boolean isPrivate = true;
            if (!activity.isNull("access") && !activity.getJSONObject("access").isNull("items")) {
                JSONArray items = activity.getJSONObject("access").getJSONArray("items");
                for (int k = 0; k < items.length(); k++) {
                    if (!items.getJSONObject(k).isNull("type") && items.getJSONObject(k).getString("type").equalsIgnoreCase("public")) {
                        isPrivate = false;
                        break;
                    }
                }
            }
            
            //Comments,start
            String gpComments = "";
            if (!isPrivate) {
                HashMap<String, String> paramsComments = new HashMap<String, String>(2);
                paramsComments.put("maxResults", "5");
                if (startIndex != null && !startIndex.isEmpty()) {
                    paramsComments.put("pageToken", startIndex);
                }
                gpComments = semanticGoogle.apiRequest(paramsComments, "https://www.googleapis.com/plus/v1/activities/" + actId + "/comments", "GET");
                
                JSONObject jsonResponse = new JSONObject(gpComments);
                JSONArray arrayComments = null;
                if (!jsonResponse.isNull("items")) {
                    arrayComments = jsonResponse.getJSONArray("items");
                }
                if (arrayComments != null && arrayComments.length() > 0) {
%>
        <ul id="<%=semanticGoogle.getId() + actId%>/comments">
<%
                    for (int c = 0; c < arrayComments.length(); c++) {
                        JSONObject comment = arrayComments.getJSONObject(c);
                        //Actualmente solo hay comentarios a primer nivel
                        if (comment.has("object") && comment.getJSONObject("object") != null && comment.getJSONObject("object").has("content")) {
                            //JSONObject topLevelComment = comment.getJSONObject("snippet").getJSONObject("topLevelComment");
                            out.write(GooglePlusWall.assembleCommentHtml(comment, paramRequest, objUri, actId, null));
                        }
//                        //Si el comentario tiene comentarios asociados
//                        if (!comment.isNull("inReplyTo") && comment.getJSONArray("inReplyTo").length() > 0) {
//                            JSONArray replies = comment.getJSONObject("replies").getJSONArray("comments");
//                            JSONObject parent = 
//                            for (int j = 0; j < replies.length(); j++) {
//                                out.write(GooglePlusWall.assembleCommentHtml(replies.getJSONObject(j),
//                                        paramRequest, objUri, actId, parentCommentId));
//                            }
//                        }
                    }
                    if (!jsonResponse.isNull("nextPageToken") && !jsonResponse.getString("nextPageToken").isEmpty()) {
                        String nextComments = jsonResponse.getString("nextPageToken");
%>
            <li class="timelinemore">
                <label><a href="#" onclick="appendHtmlAt('<%=paramRequest.getRenderUrl().setMode("getMoreComments").
                                        setParameter("actId", actId).
                                        setParameter("startIndex", nextComments).
                                        setParameter("suri", objUri)%>', '<%=semanticGoogle.getId() + actId%>/comments', 'bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode );}catch(noe){}; return false;"><span>+</span><%=paramRequest.getLocaleString("moreComments")%></a></label>
            </li>
<%
                    }
%>
        </ul>
        <div class="clear"></div>
<%
                }
            }
            Date publishedDate = parseDateFormat.parse(activity.getString("published"));
%>
        <!-- Datos estadisticos -->
        <div class="timelineresume" dojoType="dijit.layout.ContentPane">
            <span id="<%=semanticGoogle.getId() + actId %>/inf" class="inline" dojoType="dojox.layout.ContentPane">
                <%=df.format(publishedDate)%>
<%
            long replies = !actObject.isNull("replies") && !actObject.getJSONObject("replies").isNull("totalItems")
                           ? actObject.getJSONObject("replies").getLong("totalItems") : 0;
            long plusoners = !actObject.isNull("plusoners") && !actObject.getJSONObject("plusoners").isNull("totalItems")
                             ? actObject.getJSONObject("plusoners").getLong("totalItems") : 0;
            long resharers = !actObject.isNull("resharers") && !actObject.getJSONObject("resharers").isNull("totalItems")
                             ? actObject.getJSONObject("resharers").getLong("totalItems") : 0;
%>
                <div style="display:inline"><strong style="background-image: none !important; font-weight: bold"><%=paramRequest.getLocaleString("replies")%>: </strong><%=replies%></div>
                <div style="display:inline"><strong style="background-image: none !important; font-weight: bold"><%=paramRequest.getLocaleString("plusoners")%>: </strong><%=plusoners%></div>
                <div style="display:inline"><strong style="background-image: none !important; font-weight: bold"><%=paramRequest.getLocaleString("resharers")%>: </strong><%=resharers%></div>
            </span>
<%
            if (userCanRespondMsg) {
%>
            <span class="inline" dojoType="dojox.layout.ContentPane">
                <a class="answ" href="#" title="Comentar" onclick="showDialog('<%=paramRequest.getRenderUrl().setMode("commentActivity").setParameter("suri", objUri).
                                setParameter("actId", actId)%>','Comment to <%=actTitle%>');return false;"></a>
            </span>
<%
            }
            String postURI = null;
            PostIn post = PostIn.getPostInbySocialMsgId(model, actId);
            if (post != null) {
                postURI = post.getURI();
            }
            
            if (userCanRetopicMsg) {
%>
            <span class="inline" id="<%=semanticGoogle.getId() + actId%>/topic" dojoType="dojox.layout.ContentPane">
<%
                if (userCanRetopicMsg) {
                    if (postURI != null) {//If post already exists
                        SWBResourceURL clasifybyTopic = paramRequest.getRenderUrl().setMode("doReclassifyTopic").
                                setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("actId", actId).
                                setParameter("postUri", postURI).setParameter("suri", objUri);
%>
                <a href="#" class="clasifica" title="<%=paramRequest.getLocaleString("reclassify")%>" onclick="showDialog('<%=clasifybyTopic%>', '<%=paramRequest.getLocaleString("reclassify")%>'); return false;"></a>
<%
                    } else {//If posts does not exists 
                        SWBResourceURL clasifybyTopic = paramRequest.getRenderUrl().setMode("doShowTopic").
                                setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("id", actId).
                                setParameter("postUri", postURI).setParameter("suri", objUri);
%>
                <a href="#" class="clasifica" class="clasifica" title="<%=paramRequest.getLocaleString("classify")%>" onclick="showDialog('<%=clasifybyTopic%>', '<%=paramRequest.getLocaleString("classify")%>'); return false;"></a>
<%
                    }
                } else {
                    out.write("&nbsp;");
                }
%>
            </span>
<%
            }
%>
        </div><!--timelineresume-->
    </div>
<%
            } //del for
        } catch (Exception e) {
            GooglePlusWall.log.error("Problema imprimiendo novedad", e);
        }
    /*
        if (nextPageToken != null && !nextPageToken.isEmpty()) {
% >
    <div id="<%=objUri% >/getMoreActivities" dojoType="dojox.layout.ContentPane">
        <div align="center" style="margin-bottom: 10px;">
            <label id="<%=objUri% >/moreActsLabel">
                <a href="#" onclick="appendHtmlAt('<%=paramRequest.getRenderUrl().setMode("getMoreActs").
                        setParameter("nextPageToken", nextPageToken).
                        setParameter("suri", objUri)% >', '<%=objUri% >/getMoreActivities', 'bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;">
                    M&aacute;s Actividades
                </a></label>
        </div>
    </div>
< %
        }
            */
%>
</div>