<%-- 
    Document   : facebookUserProfile
    Created on : 21/06/2013, 01:49:46 PM
    Author     : francisco.jimenez
    Permisos necesarios de FB: user_friends 
--%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="javax.print.attribute.standard.MediaSize.Other"%>
<%@page import="org.semanticwb.social.Facebook"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.io.Writer"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<%@page import="static org.semanticwb.social.admin.resources.FacebookWall.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<!DOCTYPE html>
<%!
    public static String getFullPageProfileFromId(String id, Facebook facebook) {
        HashMap<String, String> params1 = new HashMap<String, String>(2);
        params1.put("access_token", facebook.getAccessToken());
        params1.put("fields", "id,name");
    
        String fbResponse = null;
        try {
            fbResponse = getRequest(params1, Facebook.FACEBOOKGRAPH + id,
                    Facebook.USER_AGENT);
        } catch (Exception e) {
            //System.out.println("Error getting user information"  + e.getMessage());
        }
        return fbResponse;
    }
    
    public static String getFullUserProfileFromId(String id, Facebook facebook) {
        HashMap<String, String> params1 = new HashMap<String, String>(2);    
        params1.put("access_token", facebook.getAccessToken());
        params1.put("fields", "name,gender,about,birthday,address,friends.summary(true),link");
        
        String fbResponse = null;
        try {
            fbResponse = getRequest(params1, Facebook.FACEBOOKGRAPH + id,
                    Facebook.USER_AGENT);
        } catch (Exception e) {
            fbResponse = e.getMessage();
            System.out.println("Error getting user information"  + e.getMessage());
        }
        return fbResponse;
    }
%>
<%
    String target = (String) request.getParameter("id");
    String objUri = (String) request.getParameter("suri");
    if (target == null || objUri == null) {
        return;
    }
    SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
    Facebook facebook = (Facebook) semanticObject.createGenericInstance();
    
    String usrProfile = getFullUserProfileFromId(target, facebook);
    JSONObject usrResp = new JSONObject(usrProfile);
    //JSONArray usrData = usrResp.getJSONArray("data");
    String sex = "";
    String birthday="";
    String locationName= "";
    String locationCountry = "";
    String locationCoordinates="";
    //String locationId = "";
    String aboutMe = "";
    String profileUrl = "";
    int friendsCount = 0;
    int mutualFriendsCount = 0;
    
    if (usrResp != null && !usrResp.has("error")) {
        if (usrResp.has("gender") && !usrResp.isNull("gender")) {
            sex = usrResp.getString("gender");
            if (sex.equals("male")) {
                sex = "Masculino";
            } else if (sex.equals("female")) {
                sex = "Femenino";
            }
        }
        if (usrResp.has("about") && !usrResp.isNull("about")) {
            aboutMe = usrResp.getString("about");
        }
        profileUrl = usrResp.getString("link");
        if (usrResp.has("friends") && usrResp.getJSONObject("friends").has("summary") &&
                usrResp.getJSONObject("friends").getJSONObject("summary").has("total_count")) {
            friendsCount = usrResp.getJSONObject("friends").getJSONObject("summary").getInt("total_count");
        }
        
        if(!usrResp.isNull("mutual_friend_count")) {
            mutualFriendsCount = usrResp.getInt("mutual_friend_count");
        }
        if (usrResp.has("birthday") && !usrResp.isNull("birthday")) {
            birthday = usrResp.getString("birthday");
        }
        if (usrResp.has("address") && !usrResp.isNull("address")) {
            JSONObject usrlocation = usrResp.getJSONObject("address");
            locationName = usrlocation.getString("name");
            locationCountry = usrlocation.getString("country");
            locationCoordinates = usrlocation.getDouble("latitude") + "," + usrlocation.getDouble("longitude");
        }
        
%>
<div class="swbform" style="width: 500px;">
    <fieldset>
        <div align="center">
            <a href="http://www.facebook.com/<%=target%>" title="<%=paramRequest.getLocaleString("viewProfOnFB")%>"  target="_blank">
                <img src="<%=Facebook.FACEBOOKGRAPH + target%>/picture?width=150&height=150" width="150" height="150"/>
            </a>
        </div>
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
        <legend><%=paramRequest.getLocaleString("birthday")%>:</legend>
        <div align="left"><%=birthday%></div>
    </fieldset>
<%
        }
        if (friendsCount > 0 || mutualFriendsCount > 0) {
%>
    <fieldset>
         <legend><%=paramRequest.getLocaleString("friendsInformation")%>:</legend>
<%
            if (friendsCount>0) {
%>
            <div align="left">
                <%=paramRequest.getLocaleString("totalFriends")%>: <%=friendsCount%>
            </div>
<%
            }
            if (mutualFriendsCount>0) {
%>
            <div align="left">
                <%=paramRequest.getLocaleString("mutualFriends")%>: <%=mutualFriendsCount%>
            </div>
<%
            }
%>
    </fieldset>
<%
        }
        if (!locationName.isEmpty()) {
%>
    <fieldset>
        <legend><%=paramRequest.getLocaleString("location")%>: </legend>
        <div align="left">
             <%=paramRequest.getLocaleString("viewOnFacebook")%>:
             <%=locationName%><%=!locationCountry.isEmpty() ? ", " + locationCountry : ""%>
        </div>
<%
        if (!locationCoordinates.isEmpty()) {
%>
        <div align="left">
            <%=paramRequest.getLocaleString("viewOnGoogle")%>:
            <a href="https://maps.google.com/maps?q=<%=locationCoordinates%>" title="<%=paramRequest.getLocaleString("viewLocGoogle")%>" target="_blank">
                (<%=locationCoordinates%>)
            </a>
        </div>
<%
        }
%>
    </fieldset>
<%
        }
        if (!profileUrl.isEmpty()) {
%>
    <fieldset>
        <legend><%=paramRequest.getLocaleString("profileUrl")%>:</legend>
        <div align="left">
             <a href="<%=profileUrl%>" title="<%=paramRequest.getLocaleString("viewProfOnFB")%>" target="_blank">
                 <%=profileUrl%>
             </a>
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
<%
    } else if (usrResp != null && usrResp.has("error")) {
        String msg = "";
        if (usrResp.getJSONObject("error").getInt("code") == 100) {
            msg = "El perfil de este usuario no es p&uacute;blico";
        }
%>
    <fieldset>
        <div align="left"><%=msg%></div>
    </fieldset>
<%
    }
%>