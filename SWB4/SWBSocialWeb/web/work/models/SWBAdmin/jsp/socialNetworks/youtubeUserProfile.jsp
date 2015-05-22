<%-- 
    Document   : youtubeUserProfile
    Created on : 17/09/2013, 11:25:38 AM
    Author     : francisco.jimenez
--%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="javax.print.attribute.standard.MediaSize.Other"%>
<%@page import="org.semanticwb.social.Youtube"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.io.Writer"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<%@page import="static org.semanticwb.social.admin.resources.YoutubeWall.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<!DOCTYPE html>
<%
    String sex = "";
    String name = "";
    String birthday="";
    String locationName= "";
    String locationCoordinates="";
    String locationId = "";
    String aboutMe = "";
    String picture = "";
    String profileUrl = "";
    String subscribers = "";
    int friendsCount = 0;
    int mutualFriendsCount = 0;
    String target = (String) request.getParameter("id");
    if(target == null) {
        return;
    }
    String objUri = (String) request.getParameter("suri");
    
    if (objUri == null || objUri.isEmpty()) {
        objUri = (String) request.getAttribute("suri");
    }
    SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
    Youtube semanticYoutube = (Youtube) semanticObject.createGenericInstance();
    HashMap<String, String> params = new HashMap<String, String>(2);
    params.put("part", "snippet,statistics");
    params.put("id", target);
    String usrProfile = null;
    try {
        usrProfile = semanticYoutube.getRequest(params, Youtube.API_URL + "/channels", Youtube.USER_AGENT, "GET");
    } catch (Exception e) {
        e.printStackTrace();
    }
//    String usrProfile = getFullUserProfileFromId(target, semanticYoutube);
    //out.println("userprofile:" + usrProfile);
    if (usrProfile != null && !usrProfile.isEmpty()) {
        JSONObject information = null;
        JSONObject result = new JSONObject(usrProfile);
        if (!result.has("error") && !result.isNull("items")) {
            information = result.getJSONArray("items").getJSONObject(0);
        }
        if (information != null) {
            JSONObject snippet = information.getJSONObject("snippet");
            if (!snippet.isNull("title") ){
                name = snippet.getString("title");
            }
            if(!snippet.isNull("description")){
                aboutMe = snippet.getString("description");
            }
            if (!snippet.isNull("thumbnails")) {
                if (!snippet.getJSONObject("thumbnails").isNull("default")) {
                    picture = snippet.getJSONObject("thumbnails").getJSONObject("default").getString("url");
                } else if (!snippet.getJSONObject("thumbnails").isNull("medium")) {
                    picture = snippet.getJSONObject("thumbnails").getJSONObject("medium").getString("url");
                }
            }
            if (!information.isNull("statistics") && !information.getJSONObject("statistics").isNull("subscriberCount")) {
                subscribers = information.getJSONObject("statistics").getString("subscriberCount");
            }
        }
    }
    System.out.println("Name: " + name + ", picture: " + picture);
//    if(!information.isNull("yt$location")){
//        locationName = information.getJSONObject("yt$location").getString("$t");
//    }
//    if(!information.isNull("birthday_date")){
//        birthday = information.getString("birthday_date");
//    }
%>
<div class="swbform" style="width: 500px">
    <fieldset>
        <div align="center"><img src="<%=picture%>" height="150" width="150"/></div>
    </fieldset>
    <fieldset>
        <div align="center"><a title="Ver en YouTube" target="_blank" href="https://www.youtube.com/channel/<%=target%>"><%=name%></a></div>
    </fieldset>
<%
    if (!aboutMe.isEmpty()) {
%>
    <fieldset>
        <legend><%=paramRequest.getLocaleString("aboutMe")%>:</legend>
        <div align="left"><%=aboutMe%></div>
    </fieldset>
<%
    }
    if (!birthday.isEmpty()) {
%>
    <fieldset>
        <legend>Birthday:</legend>
        <div align="left"><%=birthday%></div>
    </fieldset>
<%
    }
    if (!subscribers.isEmpty()) {
%>
    <fieldset>
         <legend><%=paramRequest.getLocaleString("subscribers")%>:</legend>
         
            <div align="left">
                <%=paramRequest.getLocaleString("subscribers")%>: <%=subscribers%>
            </div>
    </fieldset>
<%
    }
    if (!locationName.isEmpty()) {
%>
    <fieldset>
        <legend><%=paramRequest.getLocaleString("countryCode")%>:</legend>
        <div align="left">
             <%=paramRequest.getLocaleString("countryCode")%>: <%=locationName%>
        </div>                  
    </fieldset>
<%
    }
    if (!profileUrl.isEmpty()) {
%>
    <fieldset>
        <legend>Profile URL:</legend>
        <div align="left">
             <a href="<%=profileUrl%>" title="View profile on Facebook"  target="_blank"><%=profileUrl%></a>
        </div>
    </fieldset>
<%
    }
    if (!sex.isEmpty()) {
%>
    <fieldset>
         <legend>Gender:</legend>
         <div align="left"><%=sex%></div>
    </fieldset>
<%
    }
%>
</div>
