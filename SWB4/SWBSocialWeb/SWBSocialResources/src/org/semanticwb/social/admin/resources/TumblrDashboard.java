/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.exceptions.JumblrException;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.Tumblr;

/**
 *
 * @author oscar.paredes
 */
public class TumblrDashboard  extends GenericResource {
    private static Logger logger = SWBUtils.getLogger(TumblrDashboard.class);
    public static final String AUTH_ERROR = "AUTH_ERROR";
    public static final String TUMBLR_ERROR = "TUMBLR_ERROR";
    public static final String DO_DASHBOARD = "DO_DASHBOARD";
    public static final String DO_FOLLOWING = "DO_FOLLOWING";
    public static final String DO_FOLLOWERS = "DO_FOLLOWERS";
    
    public static final String DO_FOLLOW = "DO_FOLLOW";
    public static final String DO_UNFOLLOW = "DO_UNFOLLOW";
    public static final String DO_LIKE = "DO_LIKE";
    public static final String DO_UNLIKE = "DO_UNLIKE";
    public static final String DO_REBLOG = "DO_REBLOG";
    
    private final String jspTumblrTabs = "/work/models/SWBAdmin/jsp/socialNetworks/tumblrTabs.jsp" ;
    private final String jspTumblrDashboard = "/work/models/SWBAdmin/jsp/socialNetworks/tumblrDashboard.jsp" ;
    private final String jspTumblrFollowing = "/work/models/SWBAdmin/jsp/socialNetworks/tumblrFollowing.jsp" ;
    private final String jspTumblrFollowers = "/work/models/SWBAdmin/jsp/socialNetworks/tumblrFollowers.jsp" ;    
    private final String jspTumblrDashboardError = "/work/models/SWBAdmin/jsp/socialNetworks/tumblrDashboardError.jsp";
            
    public JumblrClient client = null;
    public Tumblr tumblr = null;
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            WebSite ws = paramRequest.getWebPage().getWebSite();
            SWBResourceURL urlDoDashboard = paramRequest.getRenderUrl().setMode(DO_DASHBOARD);
            SWBResourceURL urlDoFollowing = paramRequest.getRenderUrl().setMode(DO_FOLLOWING);
            SWBResourceURL urlDoFollowers = paramRequest.getRenderUrl().setMode(DO_FOLLOWERS);
            String tumblrUri = (String) request.getParameter("suri");
            RequestDispatcher rd = null;
            if(tumblrUri!=null){
                tumblr = (Tumblr) SemanticObject.createSemanticObject(tumblrUri).createGenericInstance();
                 if(tumblr != null ){
                    if (!tumblr.isSn_authenticated() || tumblr.getAccessToken() == null) {
                        request.setAttribute("errorType", AUTH_ERROR);
                        rd= request.getRequestDispatcher(jspTumblrDashboardError);
                    }else{
                        rd= request.getRequestDispatcher(jspTumblrTabs);  
                        request.setAttribute("urlDoDashboard", urlDoDashboard);
                        request.setAttribute("urlDoFollowing", urlDoFollowing);
                        request.setAttribute("urlDoFollowers", urlDoFollowers);  
                        request.setAttribute("paramRequest", paramRequest);                 
                    }
               }else{
                    rd= request.getRequestDispatcher(jspTumblrDashboardError);
                    request.setAttribute("errorType", TUMBLR_ERROR);
               }
            }else{
                rd= request.getRequestDispatcher(jspTumblrDashboardError);
              
                request.setAttribute("errorType", TUMBLR_ERROR);
                 
            }
            rd.include(request, response);
        } catch (ServletException ex) {
            logger.error(ex);
        }
    }
    

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        SWBResourceURL renderUrl = paramRequest.getRenderUrl();
        //System.out.println(renderUrl.getMode());
        if(renderUrl.getMode().equals(DO_DASHBOARD)){
            doDashBoard(request, response, paramRequest);
        }else if(renderUrl.getMode().equals(DO_FOLLOWING)){
            doFollowing(request, response, paramRequest);
        }else if(renderUrl.getMode().equals(DO_FOLLOWERS)){
            doFollowers(request, response, paramRequest);
        }else if(renderUrl.getMode().equals(DO_FOLLOW)){
            doFollow(request, response, paramRequest);
        }else if(renderUrl.getMode().equals(DO_UNFOLLOW)){
            doUnFollow(request, response, paramRequest);
        }else if(renderUrl.getMode().equals(DO_LIKE)){
            doLike(request, response, paramRequest);
        }else if(renderUrl.getMode().equals(DO_UNLIKE)){
            doUnLike(request, response, paramRequest);
        }else if(renderUrl.getMode().equals(DO_REBLOG)){
            doReblog(request, response, paramRequest);
        }else{
            super.processRequest(request, response, paramRequest); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public void doDashBoard(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            RequestDispatcher rd = null;
            HashMap avatarImages = new HashMap();
            HashMap parameters = new HashMap();
            ArrayList <String> arrayFollowing  = new ArrayList();
            SWBResourceURL urlDoDashboard = paramRequest.getRenderUrl().setMode(DO_DASHBOARD);
            SWBResourceURL urlDoLike = paramRequest.getRenderUrl().setMode(DO_LIKE);
            SWBResourceURL urlDoUnLike = paramRequest.getRenderUrl().setMode(DO_UNLIKE);
            SWBResourceURL urlDoFollow = paramRequest.getRenderUrl().setMode(DO_FOLLOW);
            SWBResourceURL urlDoUnFollow = paramRequest.getRenderUrl().setMode(DO_UNFOLLOW);
            SWBResourceURL urlDoReblog = paramRequest.getRenderUrl().setMode(DO_REBLOG);
            int offset = 0;
            //System.out.println(request.getParameter("offset"));
            if(request.getParameter("offset")!=null){
                offset = Integer.valueOf(request.getParameter("offset"));
            }
            
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0); 
            //Obtengo post de dashboard
            parameters.put("offset",offset*20);
            parameters.put("notes_info",true);
            parameters.put("reblog_info",true);
            List<Post> userDashboardPost = client.userDashboard(parameters);
            //Obtener imagenes de avatar
            Iterator<Post> iteratorPost = userDashboardPost.iterator();
            while(iteratorPost.hasNext()){
                Post next = iteratorPost.next();
                if(!avatarImages.containsKey(next.getBlogName())){
                    avatarImages.put(next.getBlogName(), client.blogAvatar(next.getBlogName()));
                }
            }
            Iterator<Blog> iteratorBlogs = client.userFollowing().iterator();
            while(iteratorBlogs.hasNext()){
                arrayFollowing.add(iteratorBlogs.next().getName());
            }
            rd= request.getRequestDispatcher(jspTumblrDashboard);
            request.setAttribute("urlDoDashboard", urlDoDashboard);
            request.setAttribute("urlDoLike", urlDoLike);
            request.setAttribute("urlDoUnLike", urlDoUnLike);
            request.setAttribute("urlDoFollow", urlDoFollow);
            request.setAttribute("urlDoUnFollow", urlDoUnFollow);
            request.setAttribute("urlDoReblog", urlDoReblog);
            
            request.setAttribute("offset", offset);
            request.setAttribute("userDashboardPost", userDashboardPost);
            request.setAttribute("arrayFollowing", arrayFollowing);
            request.setAttribute("blogName", blog.getName());
            request.setAttribute("avatarImages", avatarImages);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
         
    private void doFollowing(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
         try {
            RequestDispatcher rd = null;
            HashMap parameters = new HashMap();
            ArrayList <String> arrayFollowing  = new ArrayList();
            SWBResourceURL urlDoFollow = paramRequest.getRenderUrl().setMode(DO_FOLLOW);
            SWBResourceURL urlDoUnFollow = paramRequest.getRenderUrl().setMode(DO_UNFOLLOW);
            int offset = 0;
            if(request.getParameter("offset")!=null){
                offset = Integer.valueOf(request.getParameter("offset"));
            }
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
            parameters.put("offset",offset*20);
            List<Blog> userFollowing = client.userFollowing();   
            User user = client.user();
            Blog blog = user.getBlogs().get(0);  
            
            
            rd= request.getRequestDispatcher(jspTumblrFollowing);
            request.setAttribute("urlDoFollow", urlDoFollow);
            request.setAttribute("urlDoUnFollow", urlDoUnFollow);
            request.setAttribute("userFollowing", userFollowing);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void doFollowers(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
         try {
            // System.out.println("Estoy en followers");
            RequestDispatcher rd = null;
            HashMap parameters = new HashMap();
            
            int offset = 0;
            if(request.getParameter("offset")!=null){
                offset = Integer.valueOf(request.getParameter("offset"));
            }
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
             User user = client.user();
            Blog blog = user.getBlogs().get(0);  
            parameters.put("offset",offset*20);
            List<User> blogFollowers = client.blogFollowers(blog.getName());
            rd= request.getRequestDispatcher(jspTumblrFollowers);
            request.setAttribute("blogFollowers", blogFollowers);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doFollow(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
        try {
            //System.out.println("Entro a Follow");
            PrintWriter writer = response.getWriter();
            String blogName =  request.getParameter("blogName");
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0);
            if(blogName!= null && !blogName.isEmpty() ){
                client.follow(blogName);
                 writer.print("ok");
            }else{
                writer.print("error");
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doUnFollow(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
         try {
            //System.out.println("Entro a unFollow");
            PrintWriter writer = response.getWriter();
            String blogName =  request.getParameter("blogName");
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0);
            if(blogName!= null && !blogName.isEmpty() ){
                client.unfollow(blogName);
                 writer.print("ok");
            }else{
                writer.print("error");
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doLike(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
        try {
            //System.out.println("Entro a like");
            PrintWriter writer = response.getWriter();
            String idPost =  request.getParameter("idPost");
            String idReblog = request.getParameter("idReblog");
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0);
            if(idPost!= null && !idPost.isEmpty() && idReblog != null && !idPost.isEmpty()){
                client.like(Long.valueOf(idPost), idReblog);
                writer.print("ok");
            }else{
                writer.print("false");
            }
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void doUnLike(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
        try {
           // System.out.println("Entro a unlike");
            PrintWriter writer = response.getWriter();
            String idPost =  request.getParameter("idPost");
            String idReblog = request.getParameter("idReblog");
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0);
            if(idPost!= null && !idPost.isEmpty() && idReblog != null && !idPost.isEmpty()){
                client.unlike(Long.valueOf(idPost), idReblog);
                writer.print("ok");
            }else{
                 writer.print("false");
            }
           
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     private void doReblog(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
        try {
            //System.out.println("Entro a rebolg");
            HashMap parameters = new HashMap();
            PrintWriter writer = response.getWriter();
            String idPost =  request.getParameter("idPost");
            String idReblog = request.getParameter("idReblog");
            String comment = request.getParameter("comment");
            
            client = new JumblrClient(SWBPortal.getEnv("swbsocial/tumblrAppKey"),
                    SWBPortal.getEnv("swbsocial/tumblrSecretKey"));
            client.setToken(tumblr.getAccessToken(), tumblr.getAccessTokenSecret());
            User user = client.user();
            Blog blog = user.getBlogs().get(0);
            
            parameters.put("comment", comment != null ? comment :"");
            if(idPost!= null && !idPost.isEmpty() && idReblog != null && !idPost.isEmpty()){
                client.postReblog(blog.getName(), Long.valueOf(idPost), idReblog);
                writer.print("ok");
            }else{
                 writer.print("false");
            }
           
        } catch (JumblrException  ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(TumblrDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}