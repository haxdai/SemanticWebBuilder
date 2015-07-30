<%-- 
    Document   : tumblrFollowing
    Created on : 22/06/2015, 12:33:47 PM
    Author     : oscar.paredes
--%>

<%@page import="com.tumblr.jumblr.types.Blog"%>
<%@page import="java.lang.String"%>
<%@page import="com.tumblr.jumblr.types.Photo"%>
<%@page import="com.tumblr.jumblr.types.PhotoPost"%>
<%@page import="com.tumblr.jumblr.types.LinkPost"%>
<%@page import="com.tumblr.jumblr.types.ChatPost"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.semanticwb.social.Tumblr"%>
<%@page import="com.tumblr.jumblr.types.AudioPost"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tumblr.jumblr.types.Post"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<jsp:useBean id="userFollowing" scope="request" type="List<Blog>"/>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<jsp:useBean id="urlDoFollow" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoUnFollow" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<main>
    <div class="content">
<%  Iterator<Blog> blogIterator =  userFollowing.iterator();
    while(blogIterator.hasNext()){
        Blog blog =  blogIterator.next();
%>
  <div class="post">
            
            <h4 class="post-title"><%= blog.getName() %></h4>
             <div class="timelineresume">
             <a style="display: none;"  class="follow-button clasifica follow-unfollow" data-urllike="<%= urlDoFollow
                    .setParameter("blogName", blog.getName()) %>"
            >Seguir</a>
            <a class="unfollow-button clasifica follow-unfollow" data-urlunlike="<%= urlDoUnFollow
                .setParameter("blogName", blog.getName()) %>"
            >Dejar de seguir</a>
             </div>
            <img class="avatar-image" src="<%= blog.avatar() %>">
            <p> <%= blog.getTitle() %></p>
            <p> <%= blog.getDescription() %></p>
            
        <br>
        
    </div>
<%
    }    
%>
    </div>
   
</main>
