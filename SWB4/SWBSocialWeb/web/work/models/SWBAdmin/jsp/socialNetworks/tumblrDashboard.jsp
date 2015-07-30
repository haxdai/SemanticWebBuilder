<%-- 
    Document   : tumblrDashboard
    Created on : 18/06/2015, 11:26:58 AM
    Author     : oscar.paredes
--%>

<%@page import="com.tumblr.jumblr.types.Video"%>
<%@page import="com.tumblr.jumblr.types.VideoPost"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tumblr.jumblr.types.Blog"%>
<%@page import="com.tumblr.jumblr.types.TextPost"%>
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

<jsp:useBean id="urlDoDashboard" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoLike" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoUnLike" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoFollow" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoUnFollow" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="urlDoReblog" scope="request" type="org.semanticwb.portal.api.SWBResourceURL"/>
<jsp:useBean id="offset" scope="request" type="Integer"/>
<jsp:useBean id="userDashboardPost" scope="request" type="List<Post>"/>
<jsp:useBean id="avatarImages" scope="request" type="HashMap<String,String>"/>
<jsp:useBean id="arrayFollowing" scope="request" type="ArrayList<Blog>"/>
<jsp:useBean id="blogName" scope="request" type="String"/>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>


<main>

    <div class="content">
<%  Iterator<Post> postIterator =  userDashboardPost.iterator();
    while(postIterator.hasNext()){
        Post post =  postIterator.next();
%>
        <div class="post">
           
            <h4 class="post-title"><%= post.getBlogName() %> <%= post.getRebloggedFromName()!= null ? " @ "+  post.getRebloggedFromName()   :"" %></h4>
            <div class="timelineresume">
                <a <%=  arrayFollowing.contains(post.getBlogName()) || blogName.equals(post.getBlogName())  ? "style='display: none; '" : "" %>  
                class="like-button follow-unfollow clasifica" data-urllike="<%= urlDoFollow
                    .setParameter("blogName", post.getBlogName()) %>"
                >Seguir</a>
                <a <%= !arrayFollowing.contains(post.getBlogName()) || blogName.equals(post.getBlogName())  ? "style='display:none;'" : "" %> 
                    class="unlike-button follow-unfollow clasifica" data-urlunlike="<%= urlDoUnFollow
                    .setParameter("blogName", post.getBlogName()) %>"
                >Dejar de seguir</a>
            </div>
            
            <img class="avatar-image" src="<%= avatarImages.get(post.getBlogName()) %>">
            
          
<%
        if(post.getType().equals(Tumblr.TYPE_POST_AUDIO) ) {
            ((AudioPost)post).getEmbedCode();
        }else if(post.getType().equals(Tumblr.TYPE_POST_CHAT) ){
%>
            <div>
                <%= ((ChatPost)post).getTitle() %>
                <%= ((ChatPost)post).getBody() %>
            </div>
<%
        }else if(post.getType().equals(Tumblr.TYPE_POST_LINK) ){
%>
            <div>
                <%= ((LinkPost)post).getTitle() %>
                <%= ((LinkPost)post).getDescription()%>
                <%= ((LinkPost)post).getLinkUrl() %>
            </div>
<%
            
        }else if(post.getType().equals(Tumblr.TYPE_POST_PHOTO) ){
%>
            <div>
                <%  Iterator<Photo> photoIterator =  ((PhotoPost)post).getPhotos().iterator();
                    while (photoIterator.hasNext()){
                %>
                <div>
                    <img class="post-image" src="<%=  photoIterator.next().getOriginalSize().getUrl() %>">  
                </div>
                <%   
                        }
                %>
                <%= ((PhotoPost)post).getCaption()%>
            </div>
<%
           
        }else if(post.getType().equals(Tumblr.TYPE_POST_QUOTE) ){
           
        }else if(post.getType().equals(Tumblr.TYPE_POST_TEXT) ){
%>
            <div>
                <% if( ((TextPost)post).getBody()!= null){ %>
                    <%= ((TextPost)post).getBody()%>
                <%}%>
            </div>
<%  
            
        }else if(post.getType().equals(Tumblr.TYPE_POST_VIDEO) ){
%>
            <div>

                <%=  ((VideoPost)post).getVideos().get(((VideoPost)post).getVideos().size()-1).getEmbedCode() %>
                <%= ((VideoPost)post).getCaption()%>
            </div>
        <%}%>      
        <br>
        <div class="tags">
             <% Iterator <String> tagsIterator =  post.getTags().iterator(); 
                while(tagsIterator.hasNext()){
            %>
                    <span>#<%=tagsIterator.next()%></span>
             <%
                }    
             %>
        </div>
        <br>
        <div class="timelineresume">
            <span><%= post.getNoteCount()%> notas</span>
         
            <a  <%=  post.getRebloggedFromName()!= null && post.getBlogName().equals( blogName )  ? "style='display: none;'" : "" %>  class="like-button retweet" data-urllike="<%= urlDoReblog
                    .setParameter("idPost",String.valueOf(post.getId()))
                    .setParameter("idReblog", post.getReblogKey()) %>"
            >Reblog</a>
            <!--a  <%= !(post.getRebloggedFromName()!= null && post.getBlogName().equals( blogName )) ? "style='display: none;'" : "" %> >Ya Reblogueaste</a-->
            
            <a  <%=  post.isLiked() ? "style='display: none;'" : "" %>  class="like-button like" data-urllike="<%= urlDoLike
                    .setParameter("idPost",String.valueOf(post.getId()))
                    .setParameter("idReblog", post.getReblogKey()) %>"
            >Me gusta</a>
            <a <%= !post.isLiked() ? "style='display:none;'" : "" %>  class="unlike-button nolike" data-urlunlike="<%= urlDoUnLike
                .setParameter("idPost",String.valueOf(post.getId()))
                .setParameter("idReblog", post.getReblogKey()) %>"
            >Ya no me gusta</a>      
        </div>
    </div>
<%
    }    
%>
     <a class="more-post" href="<%= urlDoDashboard.setParameter("offset", String.valueOf(offset+1)) %>">Mas post</a>
    </div>
</main>
