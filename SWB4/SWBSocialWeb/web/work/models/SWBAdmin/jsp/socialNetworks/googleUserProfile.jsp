<%-- 
    Document   : youtubeUserProfile
    Created on : 17/09/2013, 11:25:38 AM
    Author     : francisco.jimenez
--%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="javax.print.attribute.standard.MediaSize.Other"%>
<%@page import="org.semanticwb.social.Google"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.io.Writer"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.semanticwb.social.admin.resources.GooglePlusWall"%>
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
    String target = request.getParameter("id");
    if (target == null) {
        return;
    }
    String objUri = (String) request.getParameter("suri");
    
    if (objUri == null || objUri.isEmpty()) {
        objUri = (String) request.getAttribute("suri");
    }
    Google semanticGoogle = (Google) SemanticObject.createSemanticObject(URLDecoder.decode(objUri, "UTF-8")).createGenericInstance();
    HashMap<String, String> params = new HashMap<String, String>(2);
    String usrProfile = null;
    try {
        usrProfile = semanticGoogle.apiRequest(null, "https://www.googleapis.com/plus/v1/people/" + target, "GET");
    } catch (Exception e) {
        e.printStackTrace();
    }
//    String usrProfile = getFullUserProfileFromId(target, semanticYoutube);
    //out.println("userprofile:" + usrProfile);
    if (usrProfile != null && !usrProfile.isEmpty()) {
        JSONObject information = null;
        JSONObject result = new JSONObject(usrProfile);
        if (!result.has("error")) {
            information = result;
        }
        if (information != null) {
            if (information.has("displayName") && !information.isNull("displayName")) {
                name = information.getString("displayName");
            }
//            if (!snippet.isNull("description")){
//                aboutMe = snippet.getString("description");
//            }
            if (information.has("image") && !information.isNull("image")) {
                if (!information.getJSONObject("image").isNull("url")) {
                    picture = information.getJSONObject("image").getString("url");
                }
            }
            if (information.has("circledByCount") && !information.isNull("circledByCount")) {
                subscribers = Long.toString(information.getLong("circledByCount"));
            }
            if (information.has("gender") && !information.isNull("gender")) {
                sex = information.getString("gender");
            }
        }
    }
    //System.out.println("Name: " + name + ", picture: " + picture);
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
        <div align="center"><a title="Ver en Google+" target="_blank" href="https://plus.google.com/<%=target%>"><%=name%></a></div>
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
         <legend><%=paramRequest.getLocaleString("gender")%>:</legend>
         <div align="left"><%=sex%></div>
    </fieldset>
<%
    }
%>
</div>
