<%-- 
    Document   : tumblrFollowers
    Created on : 22/06/2015, 01:26:32 PM
    Author     : oscar.paredes
--%>

<%@page import="com.tumblr.jumblr.types.User"%>
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
<jsp:useBean id="blogFollowers" scope="request" type="List<User>"/>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<main>
<%= blogFollowers  %>
    <div class="content">
<%  Iterator<User> userIterator =  blogFollowers.iterator();
    while(userIterator.hasNext()){
        User user =  userIterator.next();
%>
  <div class="post">
            <!--img class="avatar-image" src="<%= user.getBlogs() %>" -->
            <h2 class="post-title"><%= user.getBlogs() %></h2>
            <%/* Iterator<Blog> blogIterator =  user.getBlogs().iterator();
                while(blogIterator.hasNext()){
                   Blog blog =  blogIterator.next();*/
            %>
              
            <%
               //}
            %>
        <br>
        
    </div>
<%
    }    
%>
    </div>
   
</main>
