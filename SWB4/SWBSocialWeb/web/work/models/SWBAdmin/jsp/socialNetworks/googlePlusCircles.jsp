<%-- 
    Document   : googlePlusCircles
    Created on : 7/09/2015, 05:44:14 PM
    Author     : jose.jimenez
--%><%@
page import="org.json.JSONArray"%><%@
page import="org.json.JSONObject"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/><%
    String tabTitle = (String) request.getAttribute("tabTitle");
    JSONArray people = (JSONArray) request.getAttribute("people");
    String nextPageToken = (String) request.getAttribute("peopleNextPageToken");
    String objUri = request.getParameter("suri");
    boolean isFirstTime = request.getAttribute("initial") != null ? (Boolean) request.getAttribute("initial") : false;
    if (isFirstTime) {
%>
<div id="<%=objUri%>/getMorePeople" class="timelineTab" style="padding:10px 5px 10px 5px; overflow-y: scroll; height: 400px;">
    <div class="timelineTab-title">
        <p>
            <strong><%=paramRequest.getLocaleString("circlesTitle")%></strong><%=tabTitle%>
        </p>
    </div>
<%
    }
    for (int i = 0; i < people.length(); i++) {
        JSONObject friend = people.getJSONObject(i);
        String userId = friend.has("id") ? friend.getString("id") : "";
        String name = friend.has("displayName") ? friend.getString("displayName") : "";
        String imageUrl = friend.has("image") ? (friend.getJSONObject("image").has("url") ? friend.getJSONObject("image").getString("url") : "") : "";
        //String url = friend.has("url") ? friend.getString("url") : "";
        //String objectType = friend.has("objectType") ? friend.getString("objectType") : ""; //valores: page / person
        String toProfile = !userId.isEmpty()
                ? paramRequest.getRenderUrl().setMode("showUserProfile").setParameter("id", userId).setParameter("suri", objUri).toString()
                : "";
%>
    <div class="timeline timelinetweeter">
        <p class="tweeter">
            <a onclick="showDialog('<%=toProfile%>', '<%= name + " - " + name%>'); return false;" href="#"><%=name%></a>
        </p>
        <p class="tweet">
            <a onclick="showDialog('<%=toProfile%>', '<%= name + " - " + name%>'); return false;" href="#">
                <img src="<%=imageUrl%>" width="50" height="50"/>
            </a>
        </p>
    </div>
<%
    }
%>
<%
    if (nextPageToken != null && !nextPageToken.isEmpty()) {
%>
    <div dojoType="dojox.layout.ContentPane">
        <div align="center" style="margin-bottom: 10px;">
            <label id="<%=objUri%>/morePeopleLabel">
                <a href="#" onclick="appendHtmlAt('<%=paramRequest.getRenderUrl().setMode("getPeople").
                        setParameter("peopleNextPageToken", nextPageToken).
                        setParameter("suri", objUri)%>', '<%=objUri%>/getMorePeople', 'bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;">
                    <%=paramRequest.getLocaleString("lblMorePeople")%>
                </a></label>
        </div>
    </div>
<%
    }
    if (isFirstTime) {
%>
</div>
<%
    }
%>