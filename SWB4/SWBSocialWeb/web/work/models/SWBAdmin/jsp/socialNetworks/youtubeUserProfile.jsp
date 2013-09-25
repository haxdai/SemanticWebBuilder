<%-- 
    Document   : youtubeUserProfile
    Created on : 17/09/2013, 11:25:38 AM
    Author     : francisco.jimenez
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

<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<!DOCTYPE html>

<%!      
    public static String getFullUserProfileFromId(String id){
        HashMap<String, String> params = new HashMap<String, String>(3);    
        params.put("v", "2");
        params.put("alt","json");
    
        String response = null;
        try{
         response = getRequest(params, "https://gdata.youtube.com/feeds/api/users/" + id,
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95");

        }catch(Exception e){
            System.out.println("Error getting user information"  + e.getMessage());
        }
        return response;
    }
%>

<%
    String target = (String) request.getParameter("id");
    String objUri = (String) request.getParameter("suri");
    if(target == null || objUri == null){
        //return;
        target = "UCbaSliTsedbczHN7fPqmyKA";
    }
    
    String usrProfile = getFullUserProfileFromId(target);
    System.out.println("userprofile:" + usrProfile);    
        
    JSONObject usrResp = new JSONObject(usrProfile);
    if(usrResp.has("entry")){
        //usrResp = usrResp.getJSONObject("entry");        
    }
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
    
    
    System.out.println("Displaying user information!!");
    JSONObject information = usrResp.getJSONObject("entry");      

    
    if(!information.isNull("title")){
        name = information.getJSONObject("title").getString("$t");
    }
    if(!information.isNull("summary")){
        aboutMe = information.getJSONObject("summary").getString("$t");
    }
    
    if(!information.isNull("media$thumbnail")){
        picture = information.getJSONObject("media$thumbnail").getString("url");
    }

    if(!information.isNull("yt$location")){
        locationName = information.getJSONObject("yt$location").getString("$t");
    }
    if(!information.isNull("birthday_date")){
        birthday = information.getString("birthday_date");
    }
    if(!information.isNull("yt$statistics")){
        if(!information.getJSONObject("yt$statistics").isNull("subscriberCount")){
            subscribers = information.getJSONObject("yt$statistics").getString("subscriberCount");
        }
    }
%>

<div class="swbform" style="width: 500px">
    
    <fieldset>
        <div align="center"><a href="#" title="View profile on Youtube"  target="_blank"><img src="<%=picture%>"/></a></div>
    </fieldset>
    
    <fieldset>
        <div align="center"><%=name%></div>
    </fieldset>
<%
    if(!aboutMe.isEmpty()){
%>
    <fieldset>
        <legend>About me:</legend>
        <div align="left"><%=aboutMe%></div>
    </fieldset>
<%
    }
%>

<%
    if(!birthday.isEmpty()){
%>
    <fieldset>
        <legend>Birthday:</legend>
        <div align="left"><%=birthday%></div>
    </fieldset>
<%
    }
%>


<%
    if(!subscribers.isEmpty()){
%>
    <fieldset>
         <legend>Subscribers:</legend>
         
            <div align="left">
                Subscribers: <%=subscribers%>
            </div>
    </fieldset>
<%
    }
%>

<%
    if(!locationName.isEmpty()){
%>
    <fieldset>
        <legend>Location:</legend>
        <div align="left">
             Region code: <a href="http://www.facebook.com/profile.php?id=<%=locationId%>" title="View profile on Facebook"  target="_blank"><%=locationName%></a>
        </div>                  
    </fieldset>
<%
    }
%>


<%
    if(!profileUrl.isEmpty()){
%>
    <fieldset>
        <legend>Profile URL:</legend>
        <div align="left">
             <a href="<%=profileUrl%>" title="View profile on Facebook"  target="_blank"><%=profileUrl%></a>
        </div>
    </fieldset>
<%
    }
%>

<%
    if(!sex.isEmpty()){
%>
    <fieldset>
         <legend>Gender:</legend>
         <div align="left"><%=sex%></div>
    </fieldset>
<%
    }
%>
</div>

<%  
%>