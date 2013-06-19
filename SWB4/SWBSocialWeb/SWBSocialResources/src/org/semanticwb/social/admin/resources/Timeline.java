/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.Kloutable;
import org.semanticwb.social.MessageIn;
import org.semanticwb.social.Post;
import org.semanticwb.social.PostIn;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.SocialNetworkUser;
import org.semanticwb.social.SocialTopic;
import org.semanticwb.social.Twitter;
import org.semanticwb.social.util.SWBSocialUtil;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author francisco.jimenez
 */
public class Timeline extends GenericResource{
    private static Logger log = SWBUtils.getLogger(Timeline.class);
    
    /*variables used to define the id of '<div>' for the fields of information, favorite and reweet.
     Each link is in a different '<div>' and it's updated individually*/
    public static String FAVORITE = "/fav";
    public static String INFORMATION = "/inf";
    public static String RETWEET = "/rt";
    public static String TOPIC ="/topic";
    
    /*Additionally every div has a suffix to identify if the status is inside the tab of
     home, mentions, favorites or myTweets */ 
    public static String HOME_TAB = "/home";
    public static String MENTIONS_TAB = "/mentions";
    public static String FAVORITES_TAB = "/favorites";
    public static String DIRECT_MESSAGES_TAB = "/dmsgs";
    public static String USER_TWEETS_TAB = "/userTweets";
    public static String DISCOVER_TAB ="/discover";
    
    //Variable used to save the users with active session
    private HashMap<String, twitter4j.Twitter> twitterUsers = new HashMap<String,twitter4j.Twitter>();    
    
    private ConfigurationBuilder configureOAuth(org.semanticwb.social.Twitter tw){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey(tw.getAppKey())
          .setOAuthConsumerSecret(tw.getSecretKey())
          .setOAuthAccessToken(tw.getAccessToken())
          .setOAuthAccessTokenSecret(tw.getAccessTokenSecret());
        return cb;
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String objUri = (String) request.getParameter("suri");
        String contentTabId = (String) request.getParameter("contentTabId");
        HttpSession session = request.getSession(true);
        System.out.println("suriReceived in Timeline:" + objUri);
        twitter4j.Twitter twitter = null;
        if(contentTabId == null){//The resource is loaded for the first time and it needs to display the tabs
            String jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterTabs.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            }catch (Exception e) {
                System.out.println("Error loading the Twitter Tabs " + e);
            }
            return;
        }
        
        //Verifies if params are properly set an if the Social Network is authenticated
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Twitter semanticTwitter = (Twitter) semanticObject.createGenericInstance();
        if(semanticTwitter.getAccessToken() == null || semanticTwitter.getAccessTokenSecret() == null ||
                semanticTwitter.getAppKey() == null || semanticTwitter.getSecretKey() == null || !semanticTwitter.isSn_authenticated()){
            out.println("<div class=\"swbform\">");
            out.println("<table width=\"100%\" border=\"0px\">");            
            out.println("   <tr>");
            out.println("       <td style=\"text-align: center;\"><h3>La cuenta no está autenticada correctamente</h3></td>");
            out.println("   </tr>");
            out.println("</table>");
            out.println("</div>");
            return;
        }
        if(twitterUsers.get(objUri) == null){//If user is not logged in, create an instance and add it
            twitter = new TwitterFactory(configureOAuth(semanticTwitter).build()).getInstance();
            System.out.println("LET'S CREATE A NEW TWITTER OBJECT: " + twitter);
            System.out.println("objUri NEW in doView:" + objUri);
            twitterUsers.put(objUri, twitter);
        }else{//The user has been created before, use it.
            twitter = twitterUsers.get(objUri);
            System.out.println("objUri OLD in doView:" + objUri);
            System.out.println("DO NOT CREATE A NEW TWITTER OBJECT");
        }

        try{
            System.out.println("\n*\n*\n*");
            System.out.println("doView suri:" + objUri);
            System.out.println("doView id:" + twitter.getId());
            System.out.println("doView username:" + twitter.getScreenName());        
            System.out.println("\n*\n*\n*");
        }catch(Exception e){ 
            System.out.println("Error doView: " + e.getMessage());
        }
        
        //Start the listener
        TwitterStream twitterStream = null;             //The stream
        SocialUserStreamListener tweetsListener = null; //The listener reads tweets from Twitter        
        
        //Use the suri and the name of the parameter to identify multiple instances of Twitter Listeners
        if((session.getAttribute(objUri + "twitterStream") == null && session.getAttribute(objUri + "tweetsListener") == null) ||
                !((SocialUserStreamListener)session.getAttribute(objUri +"tweetsListener")).isStreamActive()){ //If no stream found for the current account/session, create one.
            twitterStream = new TwitterStreamFactory(configureOAuth(semanticTwitter).build()).getInstance();
            tweetsListener = new SocialUserStreamListener(twitterStream);
            twitterStream.addListener(tweetsListener);//Listening for statuses, mentions, favorites, DMsgs
            
            try{
                tweetsListener.setCurrentUser(twitter.getId());
            }catch(TwitterException te){
                log.error("Error asigning twitter user: " + te.getErrorMessage());
            }
            
            twitterStream.user();//This method internally starts a thread
            session.setAttribute(objUri + "tweetsListener", tweetsListener);
            session.setAttribute(objUri + "twitterStream", twitterStream);
            System.out.println("Listener started!");
        }else{
             System.out.println("Do not Start a new listener we already have one!!");
             if(session.getAttribute(objUri + "tweetsListener") != null){//If the tab is refreshed, clean all 'new' statuses in ArrayList
                 ((SocialUserStreamListener)session.getAttribute( objUri + "tweetsListener")).clearHomeStatus();
                 ((SocialUserStreamListener)session.getAttribute( objUri + "tweetsListener")).clearMentionsStatus();
                 ((SocialUserStreamListener)session.getAttribute( objUri + "tweetsListener")).clearDirectMStatus();
                 ((SocialUserStreamListener)session.getAttribute( objUri + "tweetsListener")).clearFavoritesStatus();
                 ((SocialUserStreamListener)session.getAttribute( objUri + "tweetsListener")).setStartTime( System.currentTimeMillis());
             }
        }
        String jspResponse = "";
        tweetsListener = (SocialUserStreamListener)session.getAttribute(objUri +"tweetsListener");
        
        //Each one of the tabs is loaded once, so when it loads should verify (and clean its own ArrayList)
        if(contentTabId != null && contentTabId.equals("homeTimeline")){
            tweetsListener.clearHomeStatus();
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/timeline.jsp";
        }else if(contentTabId != null && contentTabId.equals("mentions")){
            tweetsListener.clearMentionsStatus();
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterMentions.jsp";
        }else if(contentTabId != null && contentTabId.equals("favorites")){
            tweetsListener.clearFavoritesStatus();
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterFavorites.jsp";
        }else if(contentTabId != null && contentTabId.equals("directMessages")){
            tweetsListener.clearDirectMStatus();
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterDM.jsp";
        }else if(contentTabId != null && contentTabId.equals("discover")){
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterDiscover.jsp";
        }else if(contentTabId != null && contentTabId.equals("userTweets")){
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterMyTweets.jsp";
        }else if(contentTabId != null && contentTabId.equals("showUserProfile")){
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterUserProfile.jsp";
        }else if(contentTabId != null && contentTabId.equals("wordNet")){
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/tagCloud.jsp";
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
        
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("twitterBean", twitter);            
            dis.include(request, response);
        } catch (Exception e) {
            log.error("Error in doView() for requestDispatcher" , e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {        
        String action = response.getAction();
        String objUri = request.getParameter("suri");
        System.out.println("suri in processAction:" + objUri);
        twitter4j.Twitter twitter = twitterUsers.get(objUri);        
        System.out.println("Action:" + response.getAction());
        if(action.equals("doRT")){ //Makes the retweet
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                System.out.println("Tweet to RT in doRT:" + id);
                response.setRenderParameter("retweetId", twitter.retweetStatus(id).getId()+""); //When a RT is made a new id is created and it's used to undo the RT
                response.setRenderParameter("id", id+"");                                       //Id of original status
                response.setRenderParameter("suri", objUri);
                response.setRenderParameter("currentTab", request.getParameter("currentTab"));
                System.out.println("Retwit!");
                response.setMode("retweetSent"); //show RT Message and update div
            } catch (TwitterException ex) {
                log.error("Error when trying to retweet ", ex);
            }
        }else if(action.equals("undoRT")){
            try {
                System.out.println("Undoing Retweet!!");
                Long retweetId = Long.parseLong(request.getParameter("retweetId"));
                Long originalId = Long.parseLong(request.getParameter("id"));
                response.setRenderParameter("suri", objUri);
                response.setRenderParameter("currentTab", request.getParameter("currentTab"));
                twitter.destroyStatus(retweetId); //Destroy Tweet generated when you Retweeted
                response.setRenderParameter("id", originalId+"");
                response.setMode("unretweetSent"); //show RT Message and update div                
            } catch (TwitterException ex) {
                log.error("Error when trying to undo retweet ", ex);
            }
        }else if(action.equals("sendReply")){
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                String answer = request.getParameter("replyText");
                System.out.println("Answer Text:" + answer);
                twitter.updateStatus(new StatusUpdate(answer).inReplyToStatusId(id));
                response.setRenderParameter("repliedTweet", "ok");
                response.setMode("tweetSent");                
            } catch (Exception ex) {
                log.error("Error when trying to reply ", ex);
            }
        }else if(action.equals("sendDM")){
            try {
                String dmText = request.getParameter("dmText");
                String idUser = request.getParameter("userId");
                System.out.println("Answer Text:" + dmText);
                DirectMessage message = twitter.sendDirectMessage(Long.parseLong(idUser), dmText);
                response.setRenderParameter("repliedTweet", "ok");
                response.setMode("tweetSent");                
            } catch (Exception ex) {
                log.error("Error when trying to send DM ", ex);
            }
        }else if(action.equals("doFavorite")){
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                System.out.println("Doing FAVORITE:" + id);
                twitter.createFavorite(id); // El id de st Deberá ser guardado para poder deshacer el Favorite
                response.setRenderParameter("id", id+"");
                response.setRenderParameter("suri", objUri);
                response.setRenderParameter("currentTab", request.getParameter("currentTab"));
                System.out.println("Favorited!");
                response.setMode("favoriteSent"); //show Favorited Message and update div
            }catch(TwitterException ex) {
                if(ex.getErrorCode() == 139){//You have already favorited this status
                    log.error("You have already FAVORITED this status");
                    response.setRenderParameter("suri", objUri);
                    response.setRenderParameter("id", request.getParameter("id"));
                    response.setMode("showError");
                }
            }
        }else if(action.equals("undoFavorite")){
            try {
                Long id = Long.parseLong(request.getParameter("id"));
                System.out.println("UNDOING FAVORITE:" + id);
                twitter.destroyFavorite(id);
                response.setRenderParameter("id", id+"");
                response.setRenderParameter("suri", objUri);
                response.setRenderParameter("currentTab", request.getParameter("currentTab"));
                System.out.println("Unfavorited!");
                response.setMode("favoriteSent"); //show Favorited Message and update div
            } catch (TwitterException ex) { 
                log.error("You have already UNFAVORITED this status ", ex);
                /*if(ex.getErrorCode() == 139){//You retweeted twice
                    log.error("You have already UNFAVORITED this status ");
                    response.setRenderParameter("suri", objUri);
                    response.setRenderParameter("id", request.getParameter("id"));
                    response.setMode("showError");
                }*/
            }
        }else if(action.equals("doFollow")){
            try {
                String friendToAdd = request.getParameter("targetUser");
                twitter.createFriendship(friendToAdd);
                System.out.println("Following user:" + friendToAdd);
                response.setRenderParameter("suri", objUri);
                response.setRenderParameter("targetUser", friendToAdd);               
                response.setMode("followSent"); //show follow message
            } catch (TwitterException ex) {
                log.error("Error when trying to do Follow ", ex);
            }
        }else if(action.equals("undoFollow")){
            try{
                String friendToDelete = request.getParameter("targetUser");
                twitter.destroyFriendship(friendToDelete);
                System.out.println("UNFollowing user:" + friendToDelete);
                response.setRenderParameter("suri", objUri);
                response.setRenderParameter("targetUser", friendToDelete);
                response.setMode("undoFollowSent"); //show unfollow Message
            } catch (TwitterException ex) {
                log.error("Error when trying to retweet ", ex);
            }
        }else if(action.equals("setSocialTopic")){
            SocialNetwork socialNetwork = null;
            Long id = Long.parseLong(request.getParameter("id"));
            String idStatus = request.getParameter("id");            

            try {
                socialNetwork = (SocialNetwork)SemanticObject.getSemanticObject(objUri).getGenericInstance();
            }catch(Exception e){
                System.out.println("Error getting the SocialNetwork " + e);
                return;
            }
            
            try {
                Status status = twitter.showStatus(id);
                String creatorId = status.getUser().getId() + "";
                SWBModel model=WebSite.ClassMgr.getWebSite(socialNetwork.getSemanticObject().getModel().getName());
                SocialNetworkUser socialNetUser = SocialNetworkUser.getSocialNetworkUserbyIDAndSocialNet(""+status.getUser().getId(), socialNetwork, model);
                
                if(socialNetUser != null){//User exists and might or migth not have posts
                    Iterator<PostIn> userPosts = PostIn.ClassMgr.listPostInByPostInSocialNetworkUser(socialNetUser, model);
                    while(userPosts.hasNext()){
                        PostIn post = userPosts.next();
                        if(post.getSocialNetMsgId().equals(idStatus)){//Post have been saved before
                            System.out.println("The post with message:\n"  + post.getMsg_Text() );
                            System.out.println("And ID:" + post.getSocialNetMsgId() + " EXISTS!!!");
                            //response.setMode("assignedPost");
                            return;
                        }
                    }
                
                }
                
                PostIn postIn = null; //The post
                postIn = MessageIn.ClassMgr.createMessageIn(model);
                postIn.setSocialNetMsgId(status.getId()+"");
                postIn.setMsg_Text(status.getText());
                postIn.setPostInSocialNetwork(socialNetwork);
                postIn.setPostInStream(null);
                
                if(socialNetUser != null){//User already exists
                    System.out.println("The user already exists: " + socialNetUser.getSnu_name() + " - " + socialNetUser.getSnu_id() +"="+ status.getUser().getId());
                    int userKloutScore = 0;
                    int days=SWBSocialUtil.Util.Datediff(socialNetUser.getUpdated(), Calendar.getInstance().getTime());
                    if(days > 5){  //Si ya pasaron 5 o mas días de que se actualizó la info del usuario, entonces busca su score en Klout
                        System.out.println("YA PASARON MAS DE 5 DÍAS, BUSCAR KLOUT DE USUARIO...");
                        Kloutable socialNetKloutAble=(Kloutable) socialNetwork;
                        userKloutScore=Double.valueOf(socialNetKloutAble.getUserKlout(creatorId)).intValue(); 
                        System.out.println("userKloutScore K TRAJO:" + userKloutScore);
                        socialNetUser.setSnu_klout(userKloutScore);
                    }

                }else{//User does not exist, create it
                    System.out.println("USUARIO NO EXISTE EN EL SISTEMA, REVISAR QUE KLOUT TIENE");
                    Kloutable socialNetKloutAble=(Kloutable) socialNetwork;
                    int userKloutScore=Double.valueOf(socialNetKloutAble.getUserKlout(creatorId)).intValue();
                    User twitterUser = twitter.showUser(status.getUser().getId());                    
                    
                    socialNetUser=SocialNetworkUser.ClassMgr.createSocialNetworkUser(model);//Create a socialNetworkUser
                    socialNetUser.setSnu_id(status.getUser().getId()+"");
                    socialNetUser.setSnu_klout(userKloutScore);
                    socialNetUser.setSnu_name("@"+status.getUser().getScreenName());
                    socialNetUser.setSnu_SocialNetwork(socialNetwork.getSemanticObject());
                    if(twitterUser != null){
                        socialNetUser.setCreated(twitterUser.getCreatedAt());
                        socialNetUser.setFollowers(twitterUser.getFollowersCount());
                        socialNetUser.setFriends(twitterUser.getFriendsCount());
                    }else{
                        socialNetUser.setCreated(new Date());
                        socialNetUser.setFollowers(0);
                        socialNetUser.setFriends(0);
                    }
                }
                //SocialNetworkUser socialNetUser=SocialNetworkUser.ClassMgr.createSocialNetworkUser(model);//Create a socialNetworkUser
                
                postIn.setPostInSocialNetworkUser(socialNetUser);
                
                if(request.getParameter("newSocialTopic").equals("none"))
                {
                    postIn.setSocialTopic(null);
                }else {
                    SemanticObject semObjSocialTopic=SemanticObject.getSemanticObject(request.getParameter("newSocialTopic"));
                    if(semObjSocialTopic!=null)
                    {
                        SocialTopic socialTopic=(SocialTopic)semObjSocialTopic.createGenericInstance();
                        postIn.setSocialTopic(socialTopic);//Asigns socialTipic
                    }
                }
                response.setRenderParameter("postUri", postIn.getURI());
                System.out.println("POST CREADO CORRECTAMENTE: " + postIn.getId() + " ** " + postIn.getSocialNetMsgId());
            }catch(Exception e){
                System.out.println("Error trying to setSocialTopic");
            }
            response.setRenderParameter("currentTab", request.getParameter("currentTab"));
            response.setRenderParameter("id", idStatus);            
            response.setMode("assignedPost");
        }else if(action.equals("changeSocialTopic"))
        {
            if(request.getParameter("postUri")!=null && request.getParameter("newSocialTopic")!=null){
                SemanticObject semObj=SemanticObject.getSemanticObject(request.getParameter("postUri"));
                Post post=(Post)semObj.createGenericInstance();
                if(request.getParameter("newSocialTopic").equals("none")){
                    post.setSocialTopic(null);
                }else{
                    SemanticObject semObjSocialTopic=SemanticObject.getSemanticObject(request.getParameter("newSocialTopic"));
                    if(semObjSocialTopic!=null){
                        SocialTopic socialTopic=(SocialTopic)semObjSocialTopic.createGenericInstance();
                        post.setSocialTopic(socialTopic);
                    }
                }
            }
            response.setMode("reAssignedPost");
        }
    }
    
   @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        //
        //System.out.println("\n\n+\n+\nEntering process request!");
        String mode = paramRequest.getMode();
        //System.out.println("\n\n+\n+\nModo: " + mode);
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        System.out.println("suri in processRequest:" + objUri);
        twitter4j.Twitter twitter = twitterUsers.get(objUri);
        if(mode!= null && mode.equals("getMoreTweets")){//Gets more Tweets
            System.out.println("brings additional TWEETS");
            doGetMoreTweets(request, response, paramRequest);
        }else if(mode!= null && mode.equals("getMoreMentions")){//Gets more Mentions
            System.out.println("brings additional MENTIONS");
            doGetMoreMentions(request, response, paramRequest);
        }else if(mode!= null && mode.equals("getMoreFavorites")){//Gets more Favorites
            System.out.println("brings additional FAVORITES");
            doGetMoreFavorites(request, response, paramRequest);
        }else if(mode!= null && mode.equals("getMoreDM")){//Gets more Direct Messages
            System.out.println("brings additional DIRECT MESSAGES");
            doGetMoreDMsgs(request, response, paramRequest);
        }else if(mode!= null && mode.equals("retweetSent")){//Displays updated data of retweeted tweet
            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            renderURL.setParameter("suri", request.getParameter("suri"));
            actionURL.setParameter("suri", request.getParameter("suri"));
            Long retweetId = Long.parseLong(request.getParameter("retweetId"));
            Long originalId = Long.parseLong(request.getParameter("id"));
            String currentTab = request.getParameter("currentTab");
            
            try {
                Status originalStatus =  twitter.showStatus(originalId);//get the original tweet
                updateStatusInformation(originalStatus, renderURL, objUri, out);
                
                actionURL.setAction("undoRT");
                /* updates only the DOM of the 'Retweet' message to change it for 'Undo retweet' and change URL also*/
                out.println("<span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
                out.println("<script type=\"dojo/method\">");
                out.println("   var spanId = dijit.byId('" + originalId + RETWEET + currentTab +  "');");
                out.println("   spanId.attr('content', '" + "<a href=\"\"  onclick=\"try{dojo.byId(this.parentNode).innerHTML = \\'<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>\\';}catch(noe){} postSocialHtml(\\'" + actionURL.setParameter("retweetId", retweetId+"").setParameter("id", originalId+"").setParameter("currentTab", currentTab) + "\\',\\'" + originalStatus.getId() + INFORMATION + currentTab + "\\');return false;" +"\">Undo Retweet</a>" +"')");
                out.println("   showStatus('Retweeted sent successfully');");
                out.println("</script>");
                out.println("</span>");
            } catch (Exception ex) {
                log.error("Error when trying to retweet ", ex);
            }
        }else if(mode!= null && mode.equals("unretweetSent")){//Displays updated data of retweeted tweet
            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            renderURL.setParameter("suri", objUri);
            actionURL.setParameter("suri", objUri);
            Long originalId = Long.parseLong(request.getParameter("id"));
            String currentTab = request.getParameter("currentTab");
            
            try {
                Status originalStatus =  twitter.showStatus(originalId);//get the original tweet
                updateStatusInformation(originalStatus, renderURL, objUri, out);
                
                actionURL.setAction("doRT");
                /* updates only the DOM of the 'Undo Retweet' message to change it for 'Retweet' and change URL also*/
                out.println("<span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
                out.println("<script type=\"dojo/method\">");
                out.println("   var spanId = dijit.byId('" + originalId + RETWEET + currentTab + "');");
                out.println("   spanId.attr('content', '" + "<a href=\"#\"  onclick=\"try{dojo.byId(this.parentNode).innerHTML = \\'<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>\\';}catch(noe){} postSocialHtml(\\'" + actionURL.setParameter("id", originalId+"").setParameter("currentTab", currentTab) + "\\',\\'" + originalId + INFORMATION + currentTab + "\\');return false;" +"\">Retweet</a>" +"')");
                out.println("   showStatus('Unretweet sent successfully');");
                out.println("</script>");
                out.println("</span>");
                                
            } catch (Exception ex) {
                log.error("Error when trying to undo retweet ", ex);
            }
        }else if(mode!= null && mode.equals("tweetSent")){//Hides dialog used to create tweet and shows status
            if(request.getParameter("repliedTweet") != null && request.getParameter("repliedTweet").equals("ok")){
                out.println("<script type=\"text/javascript\">");
                out.println("   hideDialog();");
                out.println("   showStatus('Tweet sent');");
                out.println("</script>");
            }
        }else if(mode!= null && mode.equals("replyTweet")){//Displays dialog to create tweet
            String userName = request.getParameter("userName");
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            actionURL.setParameter("id", request.getParameter("id"));
            actionURL.setParameter("suri", request.getParameter("suri"));

            out.println("<form type=\"dijit.form.Form\" id=\"createTweet\" action=\"" +  actionURL.setAction("sendReply") + "\" method=\"post\" onsubmit=\"submitForm('createTweet'); try{document.getElementById('csLoading').style.display='inline';}catch(noe){}; return false;\">");            
            out.println("<fieldset>");
            out.println("<table>");
            out.println("<tr>"); 
            out.println("   <td>");
            out.println("       <textarea type=\"dijit.form.Textarea\" name=\"replyText\" id=\"replyText\" rows=\"4\" cols=\"50\">" + userName + "</textarea>");
            out.println("   </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("       <td style=\"text-align: center;\"><button dojoType=\"dijit.form.Button\" type=\"submit\">Reply</button></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("<span id=\"csLoading\" style=\"width: 100px; display: none\" align=\"center\">&nbsp;&nbsp;&nbsp;<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/loading.gif\"/></span>");
        }else if(mode!= null && mode.equals("replyDM")){//Displays dialog to create tweet
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            actionURL.setParameter("userId", request.getParameter("userId"));
            actionURL.setParameter("suri", request.getParameter("suri"));

            out.println("<form type=\"dijit.form.Form\" id=\"createDM\" action=\"" +  actionURL.setAction("sendDM") + "\" method=\"post\" onsubmit=\"submitForm('createDM'); try{document.getElementById('csLoading').style.display='inline';}catch(noe){}; return false;\">");            
            out.println("<fieldset>");
            out.println("<table>");
            out.println("<tr>"); 
            out.println("   <td>");
            out.println("       <textarea type=\"dijit.form.Textarea\" name=\"dmText\" id=\"dmText\" rows=\"4\" cols=\"50\"></textarea>");
            out.println("   </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("       <td style=\"text-align: center;\"><button dojoType=\"dijit.form.Button\" type=\"submit\">Send</button></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("<span id=\"csLoading\" style=\"width: 100px; display: none\" align=\"center\">&nbsp;&nbsp;&nbsp;<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/loading.gif\"/></span>");
        }else if(mode.equals("doGetHomeStream")){//Displays new home statuses obtained with the stream
            System.out.println("ProcessRequest: doGetHomeStream-> RenderURL:" + paramRequest.getRenderUrl() + " actionURL:" + paramRequest.getActionUrl());
            HttpSession session = request.getSession(true);
            if(session.getAttribute(objUri + "tweetsListener")!=null){
                SocialUserStreamListener tweetsListener = (SocialUserStreamListener)session.getAttribute(objUri + "tweetsListener");
                if(tweetsListener.getHomeStatusSize() > 0){
                    tweetsListener.setProcessing(true);
                    int i;
                    for(i = tweetsListener.getHomeStatusSize() - 1 ; i >= 0 ; i-- ){//Most recent status first
                         try{
                             //--doPrintTweet(request, response, paramRequest, tweetsListener.getHomeStatus(i), twitter, response.getWriter(), recoverConversations(tweetsListener.getHomeStatus(i).getId(), twitter));
                             doPrintTweet(request, response, paramRequest, tweetsListener.getHomeStatus(i), twitter, out, null,HOME_TAB, null);
                         }catch(Exception te){
                            log.error("Error when printing tweet:" , te);
                         }
                    }
                   
                    //As user has requested the tweets in ArrayList
                    //Restart the timer to keep thread alive
                    tweetsListener.setStartTime(System.currentTimeMillis());
                    tweetsListener.clearHomeStatus();
                    tweetsListener.setProcessing(false);
                }
            }
        }else if(mode.equals("doGetFavoritesStream")){//Displays new favorites obtained with the stream
            HttpSession session = request.getSession(true);
            if(session.getAttribute(objUri + "tweetsListener")!=null){
                SocialUserStreamListener tweetsListener = (SocialUserStreamListener)session.getAttribute(objUri + "tweetsListener");
                if(tweetsListener.getFavoritesSize() > 0){
                   tweetsListener.setProcessing(true);
                   int i;
                   for(i = tweetsListener.getFavoritesSize() - 1 ; i >= 0 ; i-- ){//Most recent status first
                       try{
                           //--doPrintTweet(request, response, paramRequest, tweetsListener.getFavoritesStatus(i), twitter, response.getWriter(), recoverConversations(tweetsListener.getFavoritesStatus(i).getId(), twitter));
                           doPrintTweet(request, response, paramRequest, tweetsListener.getFavoritesStatus(i), twitter, response.getWriter(), null, FAVORITES_TAB, null);
                       }catch(Exception te){
                           log.error("Error when printing favorite:" , te);
                       }
                   }
                   //As user has requested the tweets in ArrayList
                   //Restart the timer to keep thread alive
                   tweetsListener.setStartTime(System.currentTimeMillis());
                   tweetsListener.clearFavoritesStatus();
                   tweetsListener.setProcessing(false);
                }
            }
        }else if(mode.equals("doGetMentionsStream")){//Displays new mentions obtained with the stream
            HttpSession session = request.getSession(true);
            if(session.getAttribute(objUri + "tweetsListener")!=null){
                SocialUserStreamListener tweetsListener = (SocialUserStreamListener)session.getAttribute(objUri + "tweetsListener");
                if(tweetsListener.getMentionsSize() > 0){
                   tweetsListener.setProcessing(true);
                   int i;
                   for(i = tweetsListener.getMentionsSize() - 1 ; i >= 0 ; i-- ){//Most recent status first
                       try{
                           //--doPrintTweet(request, response, paramRequest, tweetsListener.getMentionsStatus(i), twitter, response.getWriter(), recoverConversations(tweetsListener.getMentionsStatus(i).getId(), twitter));
                           doPrintTweet(request, response, paramRequest, tweetsListener.getMentionsStatus(i), twitter, response.getWriter(), null,MENTIONS_TAB, null);
                       }catch(Exception te){
                           log.error("Error when printing tweet:" , te);
                       }
                   }                   
                   //As user has requested the tweets in ArrayList
                   //Restart the timer to keep thread alive
                   tweetsListener.setStartTime(System.currentTimeMillis());
                   tweetsListener.clearMentionsStatus();
                   tweetsListener.setProcessing(false);
                }
            }
        }else if(mode.equals("doGetDMsStream")){//Displays new direct messages obtained with the stream
            HttpSession session = request.getSession(true);
            if(session.getAttribute(objUri + "tweetsListener")!=null){
                SocialUserStreamListener tweetsListener = (SocialUserStreamListener)session.getAttribute(objUri + "tweetsListener");
                if(tweetsListener.getDirectMSize() > 0){
                   tweetsListener.setProcessing(true);
                   int i;
                   for(i = tweetsListener.getDirectMSize() - 1 ; i >= 0 ; i-- ){//Most recent status first
                       try{
                           doPrintDM(request, response, paramRequest, tweetsListener.getDirectMStatus(i),twitter.getId() , out);
                       }catch(Exception te){
                           log.error("Error when printing tweet:" , te);
                       }
                   }                   
                   //As user has requested the tweets in ArrayList
                   //Restart the timer to keep thread alive
                   tweetsListener.setStartTime(System.currentTimeMillis());
                   tweetsListener.clearDirectMStatus();
                   tweetsListener.setProcessing(false);
                }
            }
        }else if(mode.equals("newTweets")){//Displays a status message when new tweets received from stream
            HttpSession session = request.getSession(true);
            if(session.getAttribute(objUri +"tweetsListener") != null){
                SocialUserStreamListener tweetsListener = (SocialUserStreamListener)session.getAttribute(objUri + "tweetsListener");
                int noOfNewTweets = tweetsListener.getHomeStatusSize();
                SWBResourceURL renderURL = paramRequest.getRenderUrl();
                if(noOfNewTweets > 0 && tweetsListener.isProcessing() == false){
                    out.println("<a href=\"#\" onclick=\"appendHtmlAt('" + renderURL.setMode("doGetHomeStream").setParameter("suri", objUri) + "','" + objUri +"/stream','top'); try{dojo.byId(this.parentNode.id).innerHTML = '';}catch(noe){}; return false;\">You have <b>" + noOfNewTweets +  "</b> new tweet" + (noOfNewTweets > 1 ? "s" : "") +  "</a>");
                }
                if(tweetsListener.getFavoritesSize() > 0){
                    System.out.println("hay nuevos favoritos:" + tweetsListener.getFavoritesSize() );
                    out.println("<script type=\"text/javascript\">");
                    out.println("   var tabId = '" +objUri + "' + '" + FAVORITES_TAB + "';");
                    out.println("   var pane = dijit.byId(tabId);");                   
                    out.println("   try{");
                    out.println("       var aux='Favorites (" + tweetsListener.getFavoritesSize() + ")';");
                    out.println("       pane.title = aux;");
                    out.println("       pane.controlButton.containerNode.innerHTML = aux;");
                    out.println("   }catch(noe){");
                    out.println("       alert('Error setting title: ' + noe);");
                    out.println("   }");
                   
                    out.println("   var favs = '" + objUri + "/newFavoritesAvailable';");
                    out.println("   var hrefVal='<a href=\"#\" onclick=\"appendHtmlAt(\\'" + renderURL.setMode("doGetFavoritesStream").setParameter("suri", objUri)
                            + "\\',\\'" + objUri +"/favoritesStream\\',\\'top\\'); try{dojo.byId(this.parentNode.id).innerHTML = \\'\\';}catch(noe){}; resetTabTitle(\\'" + objUri + "\\', \\'" + FAVORITES_TAB +  "\\', \\'Favorites\\'); return false;\">You have <b>"
                            + tweetsListener.getFavoritesSize() +  "</b> Favorite" + (tweetsListener.getFavoritesSize() > 1 ? "s" : "") +  "</a>';");
                    out.println("   try{");
                    out.println("      document.getElementById(favs).innerHTML = hrefVal;");
                    out.println("   }catch(noe){}");
                    out.println("</script>");
                }
                
                if(tweetsListener.getMentionsSize() >0 ){
                    System.out.println("hay nuevas menciones:" + tweetsListener.getMentionsSize() );
                    out.println("<script type=\"text/javascript\">");
                    out.println("   var tabId = '" +objUri + "' + '" + MENTIONS_TAB + "';");
                    out.println("   var pane = dijit.byId(tabId);");                   
                    out.println("   try{");
                    out.println("       var aux='Mentions (" + tweetsListener.getMentionsSize() + ")';");
                    out.println("       pane.title = aux;");
                    out.println("       pane.controlButton.containerNode.innerHTML = aux;");
                    out.println("   }catch(noe){");
                    out.println("       alert('Error setting title: ' + noe);");
                    out.println("   }");
                   
                    out.println("   var favs = '" + objUri + "/newMentionsAvailable';");
                    out.println("   var hrefVal='<a href=\"#\" onclick=\"appendHtmlAt(\\'" + renderURL.setMode("doGetMentionsStream").setParameter("suri", objUri) + "\\',\\'" + objUri +"/mentionsStream\\',\\'top\\'); try{dojo.byId(this.parentNode.id).innerHTML = \\'\\';}catch(noe){}; resetTabTitle(\\'" + objUri + "\\', \\'" + MENTIONS_TAB +"\\', \\'Mentions\\'); return false;\">You have <b>" + tweetsListener.getMentionsSize() +  "</b> Mention" + (tweetsListener.getMentionsSize() > 1 ? "s" : "") +  "</a>';");
                    out.println("   try{");
                    out.println("      document.getElementById(favs).innerHTML = hrefVal;");
                    out.println("   }catch(noe){}");
                    out.println("</script>");
                }
                
                if(tweetsListener.getDirectMSize() >0 ){
                    System.out.println("hay nuevos direct msgs:" + tweetsListener.getDirectMSize() );
                    out.println("<script type=\"text/javascript\">");
                    out.println("   var tabId = '" +objUri + "' + '/" + DIRECT_MESSAGES_TAB +"';");
                    out.println("   var pane = dijit.byId(tabId);");                   
                    out.println("   try{");
                    out.println("       var aux='Direct Messages (" + tweetsListener.getDirectMSize() + ")';");
                    out.println("       pane.title = aux;");
                    out.println("       pane.controlButton.containerNode.innerHTML = aux;");
                    out.println("   }catch(noe){");
                    out.println("       alert('Error setting title: ' + noe);");
                    out.println("   }");
                   
                    out.println("   var favs = '" + objUri + "/newDirectMessagesAvailable';");
                    out.println("   var hrefVal='<a href=\"#\" onclick=\"appendHtmlAt(\\'" + renderURL.setMode("doGetDMsStream").setParameter("suri", objUri) + "\\',\\'" + objUri +"/directMessagesStream\\',\\'top\\'); try{dojo.byId(this.parentNode.id).innerHTML = \\'\\';}catch(noe){}; resetTabTitle(\\'" + objUri + "\\', \\'" + DIRECT_MESSAGES_TAB + "\\', \\'Direct Messages\\'); return false;\">You have <b>" + tweetsListener.getDirectMSize() +  "</b> Direct Message" + (tweetsListener.getDirectMSize() > 1 ? "s" : "") +  "</a>';");
                    out.println("   try{");
                    out.println("      document.getElementById(favs).innerHTML = hrefVal;");
                    out.println("   }catch(noe){}");
                    out.println("</script>");
                }
                
            }
        }else if(mode.equals("stopListener")){//Stops the Listener inmediatly!
            HttpSession session = request.getSession(true);
            if(session.getAttribute(objUri + "tweetsListener")!=null){
                SocialUserStreamListener tweetsListener = (SocialUserStreamListener)session.getAttribute(objUri +"tweetsListener");
                System.out.println("El listener se va a detener inmediatamente");
                out.println(tweetsListener.stopListener());
                twitterUsers.remove(request.getParameter("suri"));
            }
        }else if(mode!= null && mode.equals("favoriteSent")){//Displays updated data of favorited tweet
            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            actionURL.setParameter("suri", objUri);
            Long id = Long.parseLong(request.getParameter("id"));
            String currentTab = request.getParameter("currentTab");
            System.out.println("Inside favorite sent: " + id);
            
            try {
                Status originalStatus = twitter.showStatus(id);
                
                updateStatusInformation(originalStatus, renderURL, objUri, out);
                out.println("<span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
                out.println("<script type=\"dojo/method\">");
                out.println("   try{");
                out.println("   var spanId = dijit.byId('" + id + FAVORITE + currentTab +  "');");
                out.println("   spanId.attr('content', '" + checkIfFavorite(originalStatus, actionURL, out, currentTab).replace("'", "\\'") +"');");
                out.println("   showStatus('Favorite sent successfully');");
                out.println("   }catch(noe){alert('Error:' + noe);}");
                out.println("</script>");
                out.println("</span>");
            } catch (TwitterException ex) {
                log.error("Error when trying to show message of Favorite sent ", ex);
            }
        }else if(mode!= null && mode.equals("showError")){//Displays updated data and shows error
            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            Long id = Long.parseLong(request.getParameter("id"));
            System.out.println("Error processing action!!!");
            
            try {
                Status originalStatus = twitter.showStatus(id);
                
                updateStatusInformation(originalStatus, renderURL, objUri, out);
                out.println("<span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
                out.println("<script type=\"dojo/method\">");
                out.println("   showError('No fue posible procesar la solicitud');");
                out.println("</script>");
                out.println("</span>");
            } catch (TwitterException ex) {
                log.error("Error when trying to show message of Favorite sent ", ex);
            }
        }else if(mode.equals("showUserProfile")){
            RequestDispatcher dis = request.getRequestDispatcher(SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/twitterUserProfile.jsp");
            try {
                request.setAttribute("paramRequest", paramRequest);
                request.setAttribute("twitterBean", twitter);            
                dis.include(request, response);
            } catch (Exception e) {
                log.error("Error in processRequest() for requestDispatcher" , e);
            }
        }else if(mode.equals("followSent")){
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            String targetUser = request.getParameter("targetUser");
            actionURL.setParameter("targetUser", targetUser);
            actionURL.setAction("undoFollow");
            out.println("<b><a href=\"#\" onclick=\"try{dojo.byId(this.parentNode.parentNode).innerHTML = '<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" + actionURL + "','" + targetUser + "/relStat'); return false;\">Unfollow</a></b>");
        }else if(mode.equals("undoFollowSent")){
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            String targetUser = request.getParameter("targetUser");
            actionURL.setParameter("targetUser", targetUser);
            actionURL.setAction("doFollow");
            out.println("<b><a href=\"#\" onclick=\"try{dojo.byId(this.parentNode.parentNode).innerHTML = '<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" + actionURL + "','" + targetUser + "/relStat'); return false;\">Follow</a></b>");
        }else if(mode.equals("doShowTopic")){
            final String path = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/socialTopic/assignTopic.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (dis != null) {
                try {
                    request.setAttribute("suri", objUri);
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error("Error on doShowTopic: " + e);
                }
            }
        }else if(mode.equals("doReclassifyTopic")){
            final String path = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/socialTopic/classifybyTopic.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (dis != null) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("postUri"));
                    request.setAttribute("postUri", semObject);
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error("Error on doReclassifyTopic: " + e);
                }
            }
        }else if(mode.equals("assignedPost")){
            String id = request.getParameter("id");
            String currentTab = request.getParameter("currentTab");
            String postUri = request.getParameter("postUri");
            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            SWBResourceURL clasifybyTopic = renderURL.setMode("doReclassifyTopic").setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("id", id).setParameter("postUri", postUri).setParameter("currentTab", currentTab);
            String url= "<a href=\"#\" title=\"" + "Reclasificar" + "\" onclick=\"showDialog('" + clasifybyTopic + "','Reclasificar tweet'); return false;\">Reclasificar</a>";
            out.println("<span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
            out.println("<script type=\"dojo/method\">");
            out.println("   hideDialog(); ");            
            out.println("   try{");
            out.println("   var spanId = dijit.byId('" + id + TOPIC + currentTab +  "');");            
            out.println("   spanId.attr('content', '" + url.replace("'", "\\'") +"');");           
            out.println("   }catch(noe){alert('Error:' + noe);}");
            out.println("   showStatus('Tema asociado correctamente');");
            out.println("</script>");
            out.println("</span>");
            //response.setRenderParameter("currentTab", request.getParameter("currentTab"));
            //response.setRenderParameter("id", idStatus);
        }else if(mode.equals("reAssignedPost")){
            out.println("<script type=\"javascript\">");
            out.println("   hideDialog(); ");
            out.println("   showStatus('El tema fue cambiado correctamente');");
            out.println("</script>");
        }else{
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doGetMoreTweets(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");        
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        twitter4j.Twitter twitter = twitterUsers.get(objUri);
        if(objUri!= null){
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }
        
        Long maxTweetID;
        try{
            maxTweetID = Long.parseLong(request.getParameter("maxTweetID"));
        }catch(NumberFormatException nfe){
            maxTweetID =0L;
        }
        
        try {
            System.out.println("Get the next 25 tweets!!");
            Paging paging = new Paging(); //used to set maxId, count
            paging.count(10);
            if(maxTweetID >0L){
                paging.setMaxId(maxTweetID-1);
            }
            int i = 0;
            for (Status status : twitter.getHomeTimeline(paging)) {
                maxTweetID = status.getId();
                //--doPrintTweet(request, response, paramRequest, status, twitter,response.getWriter(),recoverConversations(maxTweetID, twitter));
                doPrintTweet(request, response, paramRequest, status, twitter,response.getWriter(),null, HOME_TAB, null);
                i++;
            }
            out.println("<label id=\"" + objUri + "/moreTwitLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" + renderURL.setMode("getMoreTweets").setParameter("maxTweetID", maxTweetID+"") + "','" + objUri + "/getMoreTweets','bottom');try{this.parentNode.parentNode.removeChild( this.parentNode );}catch(noe){}; return false;\">More tweets</a></label>");
            System.out.println("Total tweets:" + i);
        } catch (Exception te) {
            log.error("Error when getting timeline: ", te);
        }
        System.out.println("Has finised printing tweets!");
    }
    
    public void doGetMoreMentions(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        twitter4j.Twitter twitter = twitterUsers.get(objUri);
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        if(objUri!= null){
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }
        
        Long maxTweetID;
        try{
            maxTweetID = Long.parseLong(request.getParameter("maxTweetID"));
        }catch(NumberFormatException nfe){
            maxTweetID =0L;
        }
        
        try {
            System.out.println("Get the next 25 tweets!!");
            Paging paging = new Paging(); //used to set maxId, count
            paging.count(20);
            if(maxTweetID >0L){
                paging.setMaxId(maxTweetID-1);
            }
            int i = 0;
            for (Status status : twitter.getMentionsTimeline(paging)) {
                maxTweetID = status.getId();
                //--doPrintTweet(request, response, paramRequest, status, twitter,response.getWriter(),recoverConversations(maxTweetID, twitter));
                doPrintTweet(request, response, paramRequest, status, twitter,response.getWriter(),null,MENTIONS_TAB, null);
                i++;
            }
            out.println("<label id=\"" + objUri + "/moreMentionLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" + renderURL.setMode("getMoreMentions").setParameter("maxTweetID", maxTweetID+"") + "','" + objUri + "/getMoreMentions','bottom');try{this.parentNode.parentNode.removeChild( this.parentNode );}catch(noe){}; return false;\">More Mentions</a></label>");
            System.out.println("Total mentions:" + i);
        } catch (Exception te) {
            log.error("Error when getting mentions timeline: ", te);
        }
    }
    
    public void doGetMoreFavorites(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        twitter4j.Twitter twitter = twitterUsers.get(objUri);
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        if(objUri!= null){
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }
        
        Long maxTweetID;
        try{
            maxTweetID = Long.parseLong(request.getParameter("maxTweetID"));
        }catch(NumberFormatException nfe){
            maxTweetID =0L;
        }
        
        try {
            System.out.println("Get the next 25 favorites!!");
            Paging paging = new Paging(); //used to set maxId, count
            paging.count(20);
            if(maxTweetID >0L){
                paging.setMaxId(maxTweetID-1);
            }
            int i = 0;
            for (Status status : twitter.getFavorites(paging)) {
                maxTweetID = status.getId();
                //--doPrintTweet(request, response, paramRequest, status, twitter,response.getWriter(),recoverConversations(maxTweetID, twitter));
                doPrintTweet(request, response, paramRequest, status, twitter,response.getWriter(), null, FAVORITES_TAB, null);
                i++;
            }
            out.println("<label id=\"" + objUri + "/moreFavoritesLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" + renderURL.setMode("getMoreFavorites").setParameter("maxTweetID", maxTweetID+"") + "','" + objUri + "/getMoreFavorites','bottom');try{this.parentNode.parentNode.removeChild( this.parentNode );}catch(noe){}; return false;\">More Favorites</a></label>");
            System.out.println("Total favorites:" + i);
        } catch (Exception te) {
            log.error("Error when getting more favorites: ", te);
        }
    }
    
    public void doGetMoreDMsgs(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        twitter4j.Twitter twitter = twitterUsers.get(objUri);
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        if(objUri!= null){
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }
        
        Long maxTweetID;
        try{
            maxTweetID = Long.parseLong(request.getParameter("maxTweetID"));
        }catch(NumberFormatException nfe){
            maxTweetID =0L;
        }
        
        try {
            System.out.println("Get the next 25 Direct Messages!!");
            Paging paging = new Paging(); //used to set maxId, count
            paging.count(20);
            if(maxTweetID >0L){
                paging.setMaxId(maxTweetID-1);
            }
            int i = 0;
            for (DirectMessage directMsg : twitter.getDirectMessages(paging)) {
                maxTweetID = directMsg.getId();
                doPrintDM(request, response, paramRequest, directMsg, twitter.getId(), out);
                i++;
            }
            out.println("<label id=\"" + objUri + "/moreDMLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" + renderURL.setMode("getMoreDM").setParameter("maxTweetID", maxTweetID+"") + "','" + objUri + "/getMoreDM','bottom');try{this.parentNode.parentNode.removeChild( this.parentNode );}catch(noe){}; return false;\">More Direct Messages</a></label>");
            System.out.println("Total direct messages:" + i);
        } catch (Exception te) {
            log.error("Error when getting timeline: ", te);
        }
    }
    
    /**
     * Prints a tweet in the spedified output defined by the writer param.
     * @param request the request
     * @param response the response
     * @param paramRequest the paramRequest
     * @param status the status to be printed
     * @param twitter the twitter object to retrieve additional information of a status 
     * @param writer the object where the status will be printed
     * @param conversations array of conversations or null
     * @throws SWBResourceException
     * @throws IOException 
     */
    public static void doPrintTweet(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, Status status, 
            twitter4j.Twitter twitter, java.io.Writer writer, List<Status> conversations, String tabSuffix, String postURI) throws SWBResourceException, IOException {
        String objUri = request.getParameter("suri");        
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        User twitterUser = status.getUser();
        
        if(objUri!= null){
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }
        
        if(status.isRetweet()){//This is a RT of someone else's tweet
            Pattern pattern = Pattern.compile("[a-zA-Z0-9._-]{3,}");//Regex for username
            String rtInformation = status.getText().substring(0, status.getText().indexOf(":"));
            Matcher matcher = pattern.matcher(rtInformation);            
            if (matcher.find()) {
                try{
                    twitterUser = twitter.showUser(matcher.group(0));
                }catch(Exception e){
                    log.error("Error getting the user of RT: " + e.getMessage());
                }
            }else{
                System.out.println("Match not found");
            }
            //Unable to undoRT created in another application
            
            //System.out.println("\n\nstatus.getCurrentUserRetweetId():" + status.getCurrentUserRetweetId());
            //System.out.println("status.getContributors():" + status.getContributors().length);
            //for(long v: status.getContributors()){
                //System.out.println("v:" + v);
            //}
            //Status originalStatus = status.getRetweetedStatus();
            
            //System.out.println("\n\nstatus.getRetweetedStatus()" + status.getRetweetedStatus());
            
            //try{
                  //if(originalStatus.getUser().getId()==0L);
            //                twitter.getRetweets(1l);
            //                System.out.println("userid:" + twitter.getId());                
            //}catch(Exception e){}
        }

        try {
                writer.write("<fieldset>");
                writer.write("<table style=\"width: 100%; border: 0px\">");
                if(status.isRetweet()){
                    writer.write("<tr>");
                    writer.write("  <td colspan=\"2\"><b>Retweeted  by ");
                    writer.write("       <a href=\"#\" onclick=\"showDialog('" + renderURL.setMode("showUserProfile").setParameter("targetUser", status.getUser().getScreenName()) + "','" + status.getUser().getName() + " - @" + status.getUser().getScreenName() + "');return false;\">@"+ status.getUser().getScreenName() + "</a></b> ");
                    writer.write("  </td>");
                    writer.write("</tr>");
                }
                writer.write("<tr>");
                writer.write("   <td colspan=\"2\">");
                writer.write("   " + twitterUser.getName() + " <b><a href=\"#\" onclick=\"showDialog('" +
                    renderURL.setMode("showUserProfile").setParameter("targetUser", twitterUser.getScreenName()) + "','" +
                    twitterUser.getName() + " - @" + twitterUser.getScreenName() + "'); return false;\">" + twitterUser.getScreenName() + "</a></b>");
                writer.write("   </td>");
                writer.write("</tr>");
                writer.write("<tr>");
                writer.write("   <td  width=\"10%\">");
                writer.write("       <a href=\"#\" onclick=\"showDialog('" + renderURL.setMode("showUserProfile").setParameter("targetUser", twitterUser.getScreenName()) + "','" + twitterUser.getName() + " - @" + twitterUser.getScreenName() + "');return false;\"><img src=\"" + twitterUser.getProfileImageURL() + "\"/></a>  ");
                writer.write("   </td>");
                writer.write("   <td width=\"90%\">");
                String statusText = status.getText();
                if(status.isRetweet()){// Remove 'RT @username: ' and show only the text when is a RT
                    statusText = statusText.substring(statusText.indexOf(":") + 2);
                }                                
                statusText = lookForEntities(statusText, renderURL, status.getURLEntities(), status.getMediaEntities(), status.getHashtagEntities(), status.getUserMentionEntities()); 
                writer.write(        statusText);
                writer.write("   </td>");
                writer.write("</tr>");
                writer.write("<tr>");
                writer.write("   <td colspan=\"2\">");
                
                /*creates isolated spans to identify and update only the elemente where the action affects*/
                writer.write("   <span class=\"inline\" id=\"" + status.getId() + INFORMATION + tabSuffix + "\" dojoType=\"dojox.layout.ContentPane\">");
                updateStatusInformation(status, renderURL, objUri, writer);                
                writer.write("   </span>");
                
                writer.write("   <span class=\"inline\" id=\"" + status.getId() + TOPIC + tabSuffix + "\" dojoType=\"dojox.layout.ContentPane\">");
                if(postURI != null){//If post already exists
                    SWBResourceURL clasifybyTopic = renderURL.setMode("doReclassifyTopic").setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("id", status.getId()+"").setParameter("postUri", postURI).setParameter("currentTab", tabSuffix);
                    writer.write("<a href=\"#\" title=\"" + "Reclasificar" + "\" onclick=\"showDialog('" + clasifybyTopic + "','"
                        + "Reclasificar tweet'); return false;\">Reclasificar</a>");
                }else{//If posts does not exists 
                    SWBResourceURL clasifybyTopic = renderURL.setMode("doShowTopic").setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("id", status.getId()+"").setParameter("currentTab", tabSuffix);
                    writer.write("<a href=\"#\" title=\"" + "Clasificar" + "\" onclick=\"showDialog('" + clasifybyTopic + "','"
                        + "Clasificar tweet'); return false;\">Clasificar</a>");
                }
                writer.write("   </span>");
                writer.write("   <span class=\"inline\" id=\"" + status.getId() + RETWEET + tabSuffix + "\" dojoType=\"dojox.layout.ContentPane\">");
                updateStatusRT(status, renderURL, actionURL, objUri, writer, twitter.getId(), tabSuffix);
                writer.write("   </span>");                
                writer.write("   <span class=\"inline\" id=\"" + status.getId() + FAVORITE + tabSuffix + "\" dojoType=\"dojox.layout.ContentPane\">");
                if(status.isRetweet()){//Apparently there's a bug in Twitter4j. isFavorite() is always false unless the status is obtained with showStatus()
                    try{
                        writer.write(checkIfFavorite(twitter.showStatus(status.getId()), actionURL, writer, tabSuffix));
                    }catch(Exception e){
                        log.error("Problem checking if RT is favorited ", e);
                    }
                }else{
                writer.write(checkIfFavorite(status, actionURL, writer,tabSuffix));
                }
                writer.write("   </span>");
                
                if(conversations != null && !conversations.isEmpty()){
                    writer.write("   <span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
                    writer.write(" <a href=\"#\"  onclick=\"showHideConversation('inReplyTo" + status.getId() + "'); return false;" +"\">Show conversation</a> ");
                    writer.write("   </span>");
                                        
                }
                writer.write("   </td>");
                writer.write("</tr>");
                
                if(conversations != null && !conversations.isEmpty()){
                    writer.write("<tr>");
                    writer.write("   <td width=\"9%\">&nbsp;</td>");
                    writer.write("   <td width=\"91%\">");
                    writer.write("   <table id=\"inReplyTo" + status.getId() +  "\" style=\"display: none;\">");
                    for(Status st : conversations){
                                writer.write("<tr>");
                                writer.write("   <td colspan=\"2\">");
                                writer.write("   " + st.getUser().getName() + " <b><a href=\"#\" onclick=\"showDialog('" +
                                    renderURL.setMode("showUserProfile").setParameter("targetUser", st.getUser().getScreenName()) + "','" +
                                    st.getUser().getName() + " - @" + st.getUser().getScreenName() + "'); return false;\">" + st.getUser().getScreenName() + "</a></b>");
                                writer.write("   </td>");
                                writer.write("</tr>");                                
                                writer.write("<tr>");
                                writer.write("   <td  width=\"10%\">");
                                writer.write("       <a href=\"#\" onclick=\"showDialog('" + renderURL.setMode("showUserProfile").setParameter("targetUser", st.getUser().getScreenName()) + "','" + st.getUser().getName() + " - @" + st.getUser().getScreenName() + "');return false;\"><img src=\"" + st.getUser().getProfileImageURL() + "\"/></a>  ");
                                writer.write("   </td>");
                                writer.write("   <td width=\"90%\">");                
                                String statusTextConv = lookForEntities(st.getText(), renderURL, st.getURLEntities(), st.getMediaEntities(), st.getHashtagEntities(),st.getUserMentionEntities());

                                writer.write(        statusTextConv);
                                writer.write("   </td>");
                                writer.write("</tr>");
                                writer.write("<tr>");
                                writer.write("   <td colspan=\"2\">");
                                
                                writer.write("   <span class=\"inline\" id=\"" + st.getId() + INFORMATION + "\" dojoType=\"dojox.layout.ContentPane\">");
                                updateStatusInformation(st, renderURL, objUri, writer);
                                writer.write("   </span>");
                                writer.write("   <span class=\"inline\" id=\"" + st.getId() + RETWEET + "\" dojoType=\"dojox.layout.ContentPane\">");
                                updateStatusRT(st, renderURL, actionURL, objUri, writer, twitter.getId(), tabSuffix);
                                writer.write("   </span>");
                                writer.write("   <span class=\"inline\" id=\"" + st.getId() + FAVORITE + "\" dojoType=\"dojox.layout.ContentPane\">");
                                writer.write(checkIfFavorite(st, actionURL, writer, tabSuffix));
                                writer.write("   </span>");

                                //writer.write("<div id=\"" + st.getId() + "\" dojoType=\"dijit.layout.ContentPane\">");
                                //updateTweetStatus(status, renderURL, actionURL, objUri, writer, twitter.getId());
                                writer.write("   </div>");
                                writer.write("   </td>");
                                writer.write("</tr>");
                    }
                    writer.write("   </table>");
                    writer.write("   </td>");
                    writer.write("</tr>");
                    
                }
                writer.write("</table>");
                writer.write("</fieldset>");             
        } catch (Exception te) {
            log.error("Error when getting timeline: ", te);
        }        
    }
    
    public static void doPrintDM(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, DirectMessage dm, Long currenUser, java.io.Writer writer) throws SWBResourceException, IOException {
        String objUri = request.getParameter("suri");        
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        if(objUri!= null){
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }
        Long maxTweetID;
        try{
            maxTweetID = Long.parseLong(request.getParameter("maxTweetID"));
        }catch(NumberFormatException nfe){
            maxTweetID =0L;
        }
        try {
                maxTweetID = dm.getId();
                writer.write("<fieldset>");
                writer.write("<table style=\"width: 100%; border: 0px\">");
                writer.write("<tr>");
                writer.write("   <td colspan=\"2\">");
                writer.write("   From:" + dm.getSenderScreenName() + " To:<b>" + dm.getRecipientScreenName() + "</b>");
                writer.write("   </td>");
                writer.write("</tr>");
                writer.write("<tr>");
                writer.write("   <td  width=\"10%\">");
                writer.write("       <img src=\"" + dm.getSender().getProfileImageURL() + "\"/>");
                writer.write("   </td>");
                writer.write("   <td width=\"90%\">");                
                String statusText = lookForEntities(dm.getText(), renderURL, dm.getURLEntities(), dm.getMediaEntities(), dm.getHashtagEntities(),dm.getUserMentionEntities()); 
                
                writer.write(        statusText);
                writer.write("   </td>");
                writer.write("</tr>");
                writer.write("<tr>");
                writer.write("   <td colspan=\"2\">");
                
                writer.write("<div id=\"" + dm.getId() + "\" dojoType=\"dijit.layout.ContentPane\">");
                long minutes = (long)(new Date().getTime()/60000) - (dm.getCreatedAt().getTime()/60000);
                writer.write("Created:<b>" + twitterHumanFriendlyDate(dm.getCreatedAt()) + "</b> - - ");                    
                writer.write("<a href=\"\" onclick=\"showDialog('" + renderURL.setMode("replyDM").setParameter("userId", dm.getSenderId()+"") + "','DM to @" + dm.getSenderScreenName()+ "');return false;\">Reply</a>  ");                
                writer.write("   </div>");
                writer.write("   </td>");
                writer.write("</tr>");          
                writer.write("</table>");
                writer.write("</fieldset>");             
        } catch (Exception te) {
            log.error("Error when getting DM timeline: ", te);
        }        
    }
    
    /**
     * Checks if the statusText param contains url, media, hashtag or user entities and adds the href code to the string.
     * @param statusText status text
     * @param urlEnts url entities of the status
     * @param mediaEnts media entities of the status
     * @param htEnts hashtag entities of the status
     * @param usrEnts user Entities of the status
     * @return the status text including the URLs for each one of the entities found
     */
    public static String lookForEntities(String statusText, SWBResourceURL renderURL, URLEntity urlEnts[],  MediaEntity mediaEnts[], HashtagEntity htEnts[], UserMentionEntity usrEnts[]){
        //Looking for URL entities
        if(urlEnts!=null && urlEnts.length >0){
            for(URLEntity urlEnt: urlEnts){                       
                statusText=statusText.replace(urlEnt.getURL(), "<a href=\"" + urlEnt.getURL() +  "\" target=\"_blank\">" + urlEnt.getURL() +"</a>");
            }
        }
        
        //Looking for multimedia entities
        if(mediaEnts!=null && mediaEnts.length >0){
            for(MediaEntity mediaEnt: mediaEnts){       
                statusText=statusText.replace(mediaEnt.getURL(), "<a href=\"" + mediaEnt.getURL() +  "\" target=\"_blank\">" + mediaEnt.getURL() +"</a>");
            }
        }
        
        //Looking for hashtag entities
        if(htEnts!=null && htEnts.length >0){
            for(HashtagEntity htEnt: htEnts){       
                statusText=statusText.replace("#" + htEnt.getText(), "<a href=\"https://twitter.com/search?q=%23" + htEnt.getText() +  "&src=hash\" target=\"_blank\">#"+ htEnt.getText() +"</a>");
            }
        }
        
        //Looking for user entities        
        if(usrEnts!=null && usrEnts.length >0){
            HashMap<String, String> hmUserEntity = new HashMap<String, String>();
            for(UserMentionEntity usrEnt: usrEnts){//In case the username appear more than once
                hmUserEntity.put(usrEnt.getScreenName(), usrEnt.getName());
            }            
            Iterator it = hmUserEntity.keySet().iterator();
            while(it.hasNext()){
                String screen = (String)it.next();//key
                String name= hmUserEntity.get(screen);//value
                statusText=statusText.replaceAll("@" + screen, "<a href=\"#\" onclick=\"showDialog('" + renderURL.setMode("showUserProfile").setParameter("targetUser", screen) + "','" + name + " - @" + screen + "'); return false;\">@"+ screen + "</a></b>");
            }                        
        }
        return statusText;
    }
    
    public static List<Status> recoverConversations(long tweetID, twitter4j.Twitter twitter){
        List<Status> conversations=null;
        try {
            //Show conversation information if exists
            RelatedResults results = twitter.getRelatedResults(tweetID);
            conversations = results.getTweetsWithConversation();
            Status originalStatus = twitter.showStatus(tweetID);
            if (conversations.isEmpty()) {
                conversations = results.getTweetsWithReply();
            }

            if (conversations.isEmpty()) {
                conversations = new ArrayList<Status>();
                Status status1 = originalStatus;
                while (status1.getInReplyToStatusId() > 0) {
                    status1 = twitter.showStatus(status1.getInReplyToStatusId());
                    conversations.add(status1);
                }
            }
            for(Status st : conversations){
                System.out.println("from:" + st.getUser().getScreenName() + " text:" + st.getText() );
            }
        } catch (TwitterException ex) {
            System.out.println("message" + ex.getMessage());
            ex.printStackTrace();
            java.util.logging.Logger.getLogger(Timeline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conversations;
    }
    
    public static String checkIfFavorite(Status originalStatus, SWBResourceURL actionURL, java.io.Writer out, String tabSuffix){
        String favorite;
        if(originalStatus.isFavorited()){
            actionURL.setAction("undoFavorite");
            favorite = "<a href=\"#\"  onclick=\"try{dojo.byId(this.parentNode).innerHTML = '<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" + actionURL.setParameter("id", originalStatus.getId()+"").setParameter("currentTab", tabSuffix) + "','" + originalStatus.getId() + INFORMATION + tabSuffix + "'); return false;" +"\">Unfavorite</a> ";    
        }else{
            actionURL.setAction("doFavorite");
            favorite = "<a href=\"#\"  onclick=\"try{dojo.byId(this.parentNode).innerHTML = '<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" + actionURL.setParameter("id", originalStatus.getId()+"").setParameter("currentTab", tabSuffix) + "','" + originalStatus.getId() + INFORMATION + tabSuffix +  "'); return false;" +"\">Favorite</a> ";
        }
        return favorite;
    }
        
    /**
     * Updates the information of the div when a retweed/favorite is made
     * @param originalStatus
     * @param renderURL
     * @param actionURL
     * @param objUri
     * @param out
     * @param currentUser 
     */
    public static void updateStatusInformation(Status originalStatus, SWBResourceURL renderURL, String objUri, java.io.Writer out){
        try{
            out.write("Created:<b>" + twitterHumanFriendlyDate(originalStatus.getCreatedAt()) + "</b> - - Retweeted: <b>" + originalStatus.getRetweetCount() + "</b> times ");
            out.write("<a href=\"#\" onclick=\"showDialog('" + renderURL.setMode("replyTweet").setParameter("id", originalStatus.getId()+"").setParameter("userName", "@" +
                    originalStatus.getUser().getScreenName()).setParameter("suri", objUri) +
                    "','Reply to @"  + originalStatus.getUser().getScreenName() + "');return false;\">Reply</a> ");            
        }catch(IOException ex){
            System.out.println("Error checking updating Tweet Status!" + ex.getMessage());
        }
    }
    
    public static void updateStatusRT(Status originalStatus, SWBResourceURL renderURL, SWBResourceURL actionURL, String objUri, java.io.Writer out, Long currentUser, String tabSuffix){
        try{
            if(originalStatus.isRetweetedByMe()){
                System.out.println("SI es RT by ME inside update Status!!");
                //actionURL.setAction("undoRT");
                //out.write("<a href=\"#\"  onclick=\"try{dojo.byId(this.parentNode).innerHTML = '<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" + actionURL.setParameter("id", originalStatus.getId()+"").setParameter("currentTab", tabSuffix) + "','" + originalStatus.getId() + INFORMATION + tabSuffix + "'); return false;" +"\">Undo Retweet</a>");
                out.write("<a href=\"#\"  onclick=\"return false;" +"\">Undo Retweet</a>");
            }else if(originalStatus.getUser().getId() == currentUser){ //User cannot retweet its own tweet
                System.out.println(" Is My Tweet ");
                out.write("My tweet");
            }else{
                System.out.println("Vamos a hacer RT");
                actionURL.setAction("doRT");
                out.write("<a href=\"#\"  onclick=\"try{dojo.byId(this.parentNode).innerHTML = '<img src=" + SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" + actionURL.setParameter("id", originalStatus.getId()+"").setParameter("currentTab", tabSuffix) + "','" + originalStatus.getId() + INFORMATION + tabSuffix +  "'); return false;" +"\">Retweet</a> ");
            }
        }catch(IOException ex){
            System.out.println("Error checking updating RT Status!" + ex.getMessage());
        }
    }
    
    public static String twitterHumanFriendlyDate(Date created){
        Date today = new Date();
        Long duration = today.getTime() - created.getTime();

        int second = 1000;
        int minute = second * 60;
        int hour = minute * 60;
        int day = hour * 24;
        String date = "";

        if (duration < second * 7) {//Less than 7 seconds
            date = "right now";
        }else if (duration < minute) {
            int n = (int) Math.floor(duration / second);
            date = n + " seconds ago";
        }else if (duration < minute * 2) {//Less than 2 minutes
            date = "about 1 minute ago";
        }else if (duration < hour) {
            int n = (int) Math.floor(duration / minute);
            date = n + " minutes ago";
        }else if (duration < hour * 2) {//Less than 1 hour
            date = "about 1 hour ago";
        }else if (duration < day) {
            int n = (int) Math.floor(duration / hour);
            date = n + " hours ago";
        }else  if (duration > day && duration < day * 2) {
            date = "yesterday";
        }else{
            int n = (int) Math.floor(duration / day);
            date = n + " days ago";
        }
        /*else  if (duration < day * 365) {
            int n = (int) Math.floor(duration / day);
            System.out.println("TIME:" + n);
            date = n + " days ago";
        }/*else{
            System.out.println("TIME YEAR:" + Math.floor(duration / day));
            date = "over a year ago";
        }*/
        return date;
    }
}