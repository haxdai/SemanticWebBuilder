/**  
* SWB Social es una plataforma que descentraliza la publicación, seguimiento y monitoreo hacia las principales redes sociales. 
* SWB Social escucha y entiende opiniones acerca de una organización, sus productos, sus servicios e inclusive de su competencia, 
* detectando en la información sentimientos, influencia, geolocalización e idioma, entre mucha más información relevante que puede ser 
* útil para la toma de decisiones. 
* 
* SWB Social, es una herramienta basada en la plataforma SemanticWebBuilder. SWB Social, como SemanticWebBuilder, es una creación original 
* del Fondo de Información y Documentación para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SWB Social a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarla en las mismas condiciones con que INFOTEC la ha diseñado y puesto a su disposición; 
* aprender de élla; distribuirla a terceros; acceder a su código fuente y modificarla, y combinarla o enlazarla con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. y SWB Social 1.0
* 
* INFOTEC no otorga garantía sobre SWB Social, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder o SWB Social, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.social.Facebook;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.Message;
import org.semanticwb.social.MessageIn;
import org.semanticwb.social.Photo;
import org.semanticwb.social.PhotoIn;
import org.semanticwb.social.Post;
import org.semanticwb.social.PostIn;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.SocialNetworkUser;
import org.semanticwb.social.SocialPFlow;
import org.semanticwb.social.SocialTopic;
import org.semanticwb.social.Video;
import org.semanticwb.social.VideoIn;
import org.semanticwb.social.admin.resources.util.SWBSocialResUtil;
import org.semanticwb.social.util.SWBSocialUtil;
import org.semanticwb.social.util.SocialLoader;

/**
 * Presenta la interface de usuario que muestra la informacion obtenida de Facebook, a fin de administrar
 * la informacion publicada y realizar operaciones como despliegue de comentarios, numero de likes a un
 * elemento publicado, opciones para contestar y reclasificar una publicacion
 * @author francisco.jimenez
 */
public class FacebookWall extends GenericResource {

    private static final Logger log = SWBUtils.getLogger(FacebookWall.class);
    //public static Facebook facebook;
    /*variables used to define the id of '<div>' for the fields of information, favorite and reweet.
     Each link is in a different '<div>' and it's updated individually*/
    public static final String INFORMATION = "/inf";
    public static final String LIKE = "/lik";
    public static final String REPLY = "/rep";
    public static final String TOPIC = "/topic";
    /*Additionally every div has a suffix to identify if the status is inside the tab of
     newsfeed, wall, pictures */
    public static final String NEWS_FEED_TAB = "/newsfeed";
    public static final String WALL_TAB = "/wall";
    public static final String PICTURES_TAB = "/media";
    public static final String VIDEOS_TAB = "/videos";
    public static final String FRIENDS_TAB = "/friends";
    public static final String FOLLOWERS_TAB = "/followers";
    
    public static final String WALL_PERMISSIONS = "user_friends,user_likes,user_photos,user_posts,user_status,user_videos";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String objUri = (String) request.getParameter("suri");
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebookBean = (Facebook) semanticObject.createGenericInstance();
        String contentTabId = request.getParameter("contentTabId");
        PrintWriter out = response.getWriter();
        
        if (!facebookBean.isSn_authenticated() || null == facebookBean.getAccessToken()) {
            out.println("<div id=\"configuracion_redes\">");
            out.println("<div id=\"autenticacion\">");
            out.println("<p>      La cuenta no ha sido autenticada correctamente</p>");
            out.println("</div>");
            out.println("</div>");
            return;
        }
        if (contentTabId == null) {
            String jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookTabs.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception e) {
                FacebookWall.log.error("Error loading Facebook Tabs ", e);
            }
            return;
        }

        String jspResponse = "";
        if (contentTabId.equals(NEWS_FEED_TAB)) {
            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookNewsFeed.jsp";
        } else if (contentTabId.equals(WALL_TAB)) {
            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookWall.jsp";
        } else if (contentTabId.equals(PICTURES_TAB)) {
            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookPictures.jsp";
        } else if (contentTabId.equals(VIDEOS_TAB)) {
            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookVideos.jsp";
        } else if (contentTabId.equals(FRIENDS_TAB)) {
            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookFriends.jsp";
        } else if (contentTabId.equals(FOLLOWERS_TAB)) {
            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/facebookFollowers.jsp";
        }

        //HttpSession session = request.getSession(true);
        //session.setAttribute("since", "0");// since param used to get newer post
        RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
        try {
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("facebookBean", facebookBean);
            dis.include(request, response);
        } catch (Exception e) {
            FacebookWall.log.error("Error in doView() for requestDispatcher", e);
        }
    }

    /**
     * Realiza peticiones al grafo de Facebook que deban ser enviadas por
     * alg&uacute;n m&eacute;todo en particular
     *
     * @param params contiene los par&aacute;metros a enviar a Facebook para
     * realizar la operaci&oacute;n deseada
     * @param url especifica el objeto del grafo de Facebook con el que se desea
     * interactuar
     * @param userAgent indica el navegador de Internet utilizado en la
     * petici&oacute;n a realizar
     * @param method indica el m&eacute;todo de la petici&oacute; HTTP requerido
     * por Facebook para realizar una operaci&oacute;n, como:
     * {@literal POST}, {@literal DELETE} o {@literal GET}
     * @return un {@code String} que representa la respuesta generada por el
     * grafo de Facebook
     * @throws IOException en caso de que se produzca un error al generar la
     * petici&oacute;n o recibir la respuesta del grafo de Facebook
     */
    public static String postRequest(Map<String, String> params, String url,
            String userAgent, String method) throws IOException {

        CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = new URL(paramString.length() > 0
                                ? (url + "?" + paramString) : url);

        HttpURLConnection conex = null;
        OutputStream out = null;
        InputStream in = null;
        String response = null;

        if (method == null) {
            method = "POST";
        }
        try {
            conex = (HttpURLConnection) serverUrl.openConnection();
            if (userAgent != null) {
                conex.setRequestProperty("user-agent", userAgent);
            }
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod(method);
            conex.setDoOutput(true);
            conex.connect();

            //   out = conex.getOutputStream();
            //   out.write(paramString.toString().getBytes("UTF-8"));
            in = conex.getInputStream();
            response = getResponse(in);

        } catch (java.io.IOException ioe) {
            if (conex.getResponseCode() >= 400) {
                response = getResponse(conex.getErrorStream());
                FacebookWall.log.error("\n\nERROR:" + response);
            }
        } finally {
            close(in);
            //close(out);
            if (conex != null) {
                conex.disconnect();
            }
        }
        if (response == null) {
            response = "";
        }
        return response;
    }

    public static String getRequest(Map<String, String> params, String url,
            String userAgent) throws IOException {

        CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = new URL(paramString.length() > 0 ? (url + "?" + paramString) : url);
        HttpURLConnection conex = null;
        InputStream in = null;
        String response = null;

        try {
            conex = (HttpURLConnection) serverUrl.openConnection();
            if (userAgent != null) {
                conex.setRequestProperty("user-agent", userAgent);
            }
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod("GET");
            conex.setDoOutput(true);
            conex.connect();
            in = conex.getInputStream();
            response = getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex.getResponseCode() < 200 || conex.getResponseCode() >= 400) {
                response = getResponse(conex.getErrorStream());
                FacebookWall.log.error("\n\n\nERROR:" + response);
            }
            FacebookWall.log.event("While getting response for FacebookWall", ioe);
        } finally {
            close(in);
            if (conex != null) {
                conex.disconnect();
            }
        }
        if (response == null) {
            response = "";
        }
        return response;
    }

    public static CharSequence delimit(Collection<Map.Entry<String, String>> entries,
            String delimiter, String equals, boolean doEncode)
            throws UnsupportedEncodingException {

        if (entries == null || entries.isEmpty()) {
            return null;
        }
        StringBuilder buffer = new StringBuilder(64);
        boolean notFirst = false;
        for (Map.Entry<String, String> entry : entries) {
            if (notFirst) {
                buffer.append(delimiter);
            } else {
                notFirst = true;
            }
            CharSequence value = entry.getValue();
            buffer.append(entry.getKey());
            buffer.append(equals);
            buffer.append(doEncode ? encode(value) : value);
        }
        return buffer;
    }

    /**
     * Codifica el valor de {@code target} de acuerdo al c&oacute;digo de
     * caracteres UTF-8
     *
     * @param target representa el texto a codificar
     * @return un {@code String} que representa el valor de {@code target} de
     * acuerdo al c&oacute;digo de caracteres UTF-8
     * @throws UnsupportedEncodingException en caso de ocurrir algun problema en
     * la codificaci&oacute;n a UTF-8
     */
    private static String encode(CharSequence target) throws UnsupportedEncodingException {

        String result = "";
        if (target != null) {
            result = target.toString();
            result = URLEncoder.encode(result, "UTF8");
        }
        return result;
    }

    public static String getResponse(InputStream data) throws IOException {

        Reader in = new BufferedReader(new InputStreamReader(data, "UTF-8"));
        StringBuilder response = new StringBuilder(256);
        char[] buffer = new char[1000];
        int charsRead = 0;
        while (charsRead >= 0) {
            response.append(buffer, 0, charsRead);
            charsRead = in.read(buffer);
        }
        in.close();
        return response.toString();
    }

    public static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ex) {
                FacebookWall.log.error("Error at closing object: " + c.getClass().getName(),
                        ex);
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if (action.equals("doLike")) {
            //Like works for post from your friends and for posts from users you gave likes
            
            String objUri = (String) request.getParameter("suri");
            String postID = (String) request.getParameter("postID");
            SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
            Facebook facebook = (Facebook) semanticObject.createGenericInstance();
            HashMap<String, String> params = new HashMap<String, String>(2);
            params.put("access_token", facebook.getAccessToken());
            String fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + postID + "/likes",
                    Facebook.USER_AGENT, "POST");
            if (!fbResponse.equals("true")) {//If the response is not true, there was an error
                try {
                    JSONObject likeResponse = new JSONObject(fbResponse);
                    if (likeResponse.has("error")) {
                        response.setRenderParameter("error", likeResponse.getJSONObject("error").getString("message"));
                    }
                } catch (JSONException ex) {
                    FacebookWall.log.error("Error doing like action " + ex);
                }
            }
            
            response.setRenderParameter("postID", postID);
            response.setRenderParameter("suri", objUri);
            response.setRenderParameter("currentTab", request.getParameter("currentTab"));
            response.setRenderParameter("liked", "ok");
            
            response.setMode("likeSent"); //show Like Message and update div

        } else if (action.equals("doUnlike")) {    //If you liked a post from your friends you can do unlike simply
            // //If you liked a post from a user you gave like, you cannot give unlike
            String objUri = (String) request.getParameter("suri");
            String postID = (String) request.getParameter("postID");

            SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
            Facebook facebook = (Facebook) semanticObject.createGenericInstance();
            HashMap<String, String> params = new HashMap<String, String>(2);
            params.put("access_token", facebook.getAccessToken());
            
            String fbResponse = "";
            fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + postID + "/likes",
                    Facebook.USER_AGENT, "DELETE");
            if (!fbResponse.equals("true")) {//If the response is not true, there was an error
                
                try {
                    JSONObject likeResponse = new JSONObject(fbResponse);
                    if (likeResponse.has("error")) {
                        response.setRenderParameter("error", likeResponse.getJSONObject("error").getString("message"));
                    }
                } catch (JSONException ex) {
                    FacebookWall.log.error("Error doing like action " + ex);
                }
            }

            response.setRenderParameter("postID", postID);
            response.setRenderParameter("suri", objUri);
            response.setRenderParameter("currentTab", request.getParameter("currentTab"));
            response.setRenderParameter("unliked", "ok");
            response.setMode("unlikeSent"); //show Like Message and update div
        } else if (action.equals("sendReply")) {
            try {
                String answer = request.getParameter("replyText");
                //If you liked a post from a user you gave like, you cannot give unlike
                String objUri = (String) request.getParameter("suri");
                String postID = (String) request.getParameter("postID");
                SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
                Facebook facebook = (Facebook) semanticObject.createGenericInstance();
                HashMap<String, String> params = new HashMap<String, String>(2);
                params.put("access_token", facebook.getAccessToken());
                params.put("message", answer);
                //No se usaba  ¿¿?? antes de los cambios al API v2.3
//                String fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + postID + "/comments",
//                        Facebook.USER_AGENT, "POST");
                response.setRenderParameter("postID", postID);
                response.setRenderParameter("suri", objUri);
                response.setRenderParameter("repliedPost", "ok");
                response.setMode("postSent");
            } catch (Exception ex) {
                FacebookWall.log.error("Error when trying to reply ", ex);
            }//**ini
        } else if (action.equals("setSocialTopic")) {

            Facebook facebook = null;
            String idPost = request.getParameter("id");
            String objUri = request.getParameter("suri");
            try {
                facebook = (Facebook) SemanticObject.getSemanticObject(objUri).getGenericInstance();
            } catch (Exception e) {
                FacebookWall.log.error("Error getting the SocialNetwork " + e);
                return;
            }

            SocialNetwork socialNetwork = null;
            try {
                socialNetwork = (SocialNetwork) SemanticObject.getSemanticObject(objUri).getGenericInstance();
            } catch (Exception e) {
                FacebookWall.log.error("Error getting the SocialNetwork " + e);
                return;
            }
            SocialNetworkUser socialNetUser = null;

            SWBModel model = WebSite.ClassMgr.getWebSite(socialNetwork.getSemanticObject().getModel().getName());

            try {

                JSONObject postData = getPostFromFullId(idPost, facebook);
                socialNetUser = SocialNetworkUser.getSocialNetworkUserbyIDAndSocialNet(postData.getJSONObject("from").getString("id"), socialNetwork, model);

                if (socialNetUser == null) {
                    socialNetUser = SocialNetworkUser.ClassMgr.createSocialNetworkUser(model);//Create a socialNetworkUser
                    socialNetUser.setSnu_id(postData.getJSONObject("from").getString("id"));
                    socialNetUser.setSnu_name(postData.getJSONObject("from").getString("name"));
                    socialNetUser.setSnu_SocialNetworkObj(socialNetwork.getSemanticObject());
                    socialNetUser.setUserUrl("https://www.facebook.com/" + postData.getJSONObject("from").getString("id"));
                    socialNetUser.setSnu_photoUrl(Facebook.FACEBOOKGRAPH + postData.getJSONObject("from").getString("id") + "/picture?width=150&height=150");
                    socialNetUser.setCreated(new Date());
                    socialNetUser.setFollowers(0);
                    socialNetUser.setFriends(0);
                }
                PostIn postIn = PostIn.getPostInbySocialMsgId(model, postData.getString("id"));
                if (postIn == null) {
                    String postType = "";
                    if (postData.has("type")) {
                        postType = postData.getString("type");
                    } else if (postData.has("picture") && postData.has("name") && postData.has("link") && postData.has("description")) {
                        postType = "link";
                    }
                    String message = "";
                    String story = "";

                    if (postType.equals("status") || postType.equals("link") || postType.equals("checkin")) {
                        postIn = MessageIn.ClassMgr.createMessageIn(model);
                        postIn.setPi_type(SWBSocialUtil.POST_TYPE_MESSAGE);
                        if (postType.equals("status")) {
                            if (!postData.isNull("message")) {
                                message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                            } else if (!postData.isNull("story")) {
                                story = (!postData.isNull("story")) ? postData.getString("story") : "";
                                story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                            }
                            if (!message.isEmpty()) {
                                postIn.setMsg_Text(message);
                            } else if (!story.isEmpty()) {
                                postIn.setMsg_Text(story);
                            } else {
                                postIn.setMsg_Text("");
                            }

                        } else if (postType.equals("link")) {
                            if (!postData.isNull("story")) {
                                story = (!postData.isNull("story")) ? postData.getString("story") : "";
                                story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                            }
                            if (!postData.isNull("message")) {
                                message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                            }

                            if (!message.isEmpty()) {
                                postIn.setMsg_Text(message);
                            } else if (!story.isEmpty()) {
                                postIn.setMsg_Text(story);
                            } else {
                                postIn.setMsg_Text("");
                            }
                        }

                        //Information of post IN
                        postIn.setSocialNetMsgId(postData.getString("id"));
                        postIn.setPostInSocialNetwork(socialNetwork);
                        postIn.setPostInStream(null);
                        String facebookDate = postData.getString("created_time");
                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
                        formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));

                        Date postTime = formatter.parse(facebookDate);
                        if(postTime.after(new Date())){
                            postIn.setPi_createdInSocialNet(new Date());
                        }else{
                            postIn.setPi_createdInSocialNet(postTime);
                        }                        
                        postIn.setMsg_url("https://www.facebook.com/" + postData.getJSONObject("from").getString("id") + "/posts/" + postData.getString("id"));
                        postIn.setPostInSocialNetworkUser(socialNetUser);
                        Calendar calendario = Calendar.getInstance();
                        postIn.setPi_created(calendario.getTime());
                        //Sets the social topic
                        if (request.getParameter("newSocialTopic").equals("none")) {
                            postIn.setSocialTopic(null);
                        } else {
                            SemanticObject semObjSocialTopic = SemanticObject.getSemanticObject(request.getParameter("newSocialTopic"));
                            if (semObjSocialTopic != null) {
                                SocialTopic socialTopic = (SocialTopic) semObjSocialTopic.createGenericInstance();
                                postIn.setSocialTopic(socialTopic);//Asigns socialTipic
                            }
                        }
                        response.setRenderParameter("postUri", postIn.getURI());
                    } else if (postType.equals("video") || postType.equals("swf")) {
                        postIn = VideoIn.ClassMgr.createVideoIn(model);
                        postIn.setPi_type(SWBSocialUtil.POST_TYPE_VIDEO);
                        //Get message and/or story
                        if (!postData.isNull("message")) {
                            message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                        } else if (!postData.isNull("story")) {
                            story = (!postData.isNull("story")) ? postData.getString("story") : "";
                            story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                        }

                        if (!message.isEmpty()) {
                            postIn.setMsg_Text(message);
                        } else if (!story.isEmpty()) {
                            postIn.setMsg_Text(story);
                        } else {
                            postIn.setMsg_Text("<a href=\"" + postData.getString("source") + "\" target=\"_blank\">" + postData.getString("name") + "</a>");
                        }

                        if (postData.has("source")) {
                            VideoIn videoIn = (VideoIn) postIn;
                            videoIn.setVideo(postData.getString("source"));
                        }

                        //Information of post IN
                        postIn.setSocialNetMsgId(postData.getString("id"));
                        postIn.setPostInSocialNetwork(socialNetwork);
                        postIn.setPostInStream(null);
                        String facebookDate = postData.getString("created_time");
                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
                        formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));

                        Date postTime = formatter.parse(facebookDate);
                        if(postTime.after(new Date())){
                            postIn.setPi_createdInSocialNet(new Date());
                        }else{
                            postIn.setPi_createdInSocialNet(postTime);
                        }
                        String postId = "";
                        if(postData.getString("id").contains("_")){
                            postId = postData.getString("id").split("_")[1];
                        }else{
                            postId = postData.getString("id");
                        }
                        postIn.setMsg_url("https://www.facebook.com/" + postData.getJSONObject("from").getString("id") + "/posts/" + postId);
                        postIn.setPostInSocialNetworkUser(socialNetUser);
                        Calendar calendario = Calendar.getInstance();
                        postIn.setPi_created(calendario.getTime());
                        //Sets the social topic
                        if (request.getParameter("newSocialTopic").equals("none")) {
                            postIn.setSocialTopic(null);
                        } else {
                            SemanticObject semObjSocialTopic = SemanticObject.getSemanticObject(request.getParameter("newSocialTopic"));
                            if (semObjSocialTopic != null) {
                                SocialTopic socialTopic = (SocialTopic) semObjSocialTopic.createGenericInstance();
                                postIn.setSocialTopic(socialTopic);//Asigns socialTipic
                            }
                        }
                        response.setRenderParameter("postUri", postIn.getURI());
                    } else if (postType.equals("photo")) {
                        postIn = PhotoIn.ClassMgr.createPhotoIn(model);
                        postIn.setPi_type(SWBSocialUtil.POST_TYPE_PHOTO);
                        //Get message and/or story
                        if (!postData.isNull("message")) {
                            message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                        } else if (!postData.isNull("story")) {
                            story = (!postData.isNull("story")) ? postData.getString("story") : "";
                            story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                        }

                        if (!message.isEmpty()) {
                            postIn.setMsg_Text(message);
                        } else if (!story.isEmpty()) {
                            postIn.setMsg_Text(story);
                        } else {
                            postIn.setMsg_Text("");
                        }

                        if (postData.has("picture")) {
                            String photo = postData.getString("picture");
                            PhotoIn photoIn = (PhotoIn) postIn;
                            photoIn.addPhoto(photo);
                        }

                        //Information of post IN
                        postIn.setSocialNetMsgId(postData.getString("id"));
                        postIn.setPostInSocialNetwork(socialNetwork);
                        postIn.setPostInStream(null);
                        String facebookDate = postData.getString("created_time");
                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
                        formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));

                        Date postTime = formatter.parse(facebookDate);
                        if(postTime.after(new Date())){
                            postIn.setPi_createdInSocialNet(new Date());
                        }else{
                            postIn.setPi_createdInSocialNet(postTime);
                        }                        
                        postIn.setMsg_url("https://www.facebook.com/" + postData.getJSONObject("from").getString("id") + "/posts/" + postData.getString("id"));
                        postIn.setPostInSocialNetworkUser(socialNetUser);
                        Calendar calendario = Calendar.getInstance();
                        postIn.setPi_created(calendario.getTime());
                        //Sets the social topic
                        if (request.getParameter("newSocialTopic").equals("none")) {
                            postIn.setSocialTopic(null);
                        } else {
                            SemanticObject semObjSocialTopic = SemanticObject.getSemanticObject(request.getParameter("newSocialTopic"));
                            if (semObjSocialTopic != null) {
                                SocialTopic socialTopic = (SocialTopic) semObjSocialTopic.createGenericInstance();
                                postIn.setSocialTopic(socialTopic);//Asigns socialTipic
                            }
                        }
                        response.setRenderParameter("postUri", postIn.getURI());
                    }
                } else {
                    FacebookWall.log.debug("The post exists, creating another response");
                    //Sets the social topic
                    if (request.getParameter("newSocialTopic").equals("none")) {
                        postIn.setSocialTopic(null);
                    } else {
                        SemanticObject semObjSocialTopic = SemanticObject.getSemanticObject(request.getParameter("newSocialTopic"));
                        if (semObjSocialTopic != null) {
                            SocialTopic socialTopic = (SocialTopic) semObjSocialTopic.createGenericInstance();
                            postIn.setSocialTopic(socialTopic);//Asigns socialTipic
                        }
                    }
                    response.setRenderParameter("postUri", postIn.getURI());
                }
            } catch (Exception e) {
                FacebookWall.log.error("Error trying to setSocialTopic:", e);
            }

            response.setRenderParameter("currentTab", request.getParameter("currentTab"));
            response.setRenderParameter("id", idPost);
            response.setRenderParameter("fbid", facebook.getId());

            response.setMode("assignedPost");
        } else if (action.equals("changeSocialTopic")) {
            if (request.getParameter("postUri") != null && request.getParameter("newSocialTopic") != null) {
                SemanticObject semObj = SemanticObject.getSemanticObject(request.getParameter("postUri"));
                Post post = (Post) semObj.createGenericInstance();
                if (request.getParameter("newSocialTopic").equals("none")) {
                    post.setSocialTopic(null);
                } else {
                    SemanticObject semObjSocialTopic = SemanticObject.getSemanticObject(request.getParameter("newSocialTopic"));
                    if (semObjSocialTopic != null) {
                        SocialTopic socialTopic = (SocialTopic) semObjSocialTopic.createGenericInstance();
                        post.setSocialTopic(socialTopic);
                    }
                }
            }
            response.setMode("reAssignedPost");
        } else if (action.equals("postMessage") || action.equals("uploadPhoto") || action.equals("uploadVideo")) {
            if (request.getParameter("objUri") != null) {

                PostIn postIn = null;
                SocialTopic socialTopic = null;
                String suri = request.getParameter("objUri");

                if (SemanticObject.getSemanticObject(suri).createGenericInstance() instanceof PostIn) {//When is a response from the timeline
                    postIn = (PostIn) SemanticObject.createSemanticObject(suri).createGenericInstance();
                } else if (SemanticObject.getSemanticObject(suri).createGenericInstance() instanceof SocialTopic) {//When is a tweet to some user
                    socialTopic = (SocialTopic) SemanticObject.createSemanticObject(suri).createGenericInstance();
                }
                //SocialTopic stOld = postIn.getSocialTopic();
                ///
                WebSite wsite = WebSite.ClassMgr.getWebSite(request.getParameter("wsite"));
                String socialUri = "";
                int j = 0;
                Enumeration<String> enumParams = request.getParameterNames();
                while (enumParams.hasMoreElements()) {
                    String paramName = enumParams.nextElement();
                    if (paramName.startsWith("http://")) {//get param name starting with http:// -> URIs
                        if (socialUri.trim().length() > 0) {
                            socialUri += "|";
                        }
                        socialUri += paramName;
                        j++;
                    }
                }

                ArrayList aSocialNets = new ArrayList();//Social nets where the post will be published
                String[] socialUris = socialUri.split("\\|");  //Dividir valores
                if (j > 0 && wsite != null) {
                    for (int i = 0; i < socialUris.length; i++) {
                        String tmp_socialUri = socialUris[i];
                        SemanticObject semObject = SemanticObject.createSemanticObject(tmp_socialUri, wsite.getSemanticModel());
                        SocialNetwork socialNet = (SocialNetwork) semObject.createGenericInstance();
                        //Se agrega la red social de salida al post
                        aSocialNets.add(socialNet);
                    }
                }

                String toPost = request.getParameter("toPost");
                String socialFlow = request.getParameter("socialFlow");
                SocialPFlow socialPFlow = null;
                if (socialFlow != null && socialFlow.trim().length() > 0) {
                    socialPFlow = (SocialPFlow) SemanticObject.createSemanticObject(socialFlow).createGenericInstance();
                    //Revisa si el flujo de publicación soporte el tipo de postOut, de lo contrario, asinga null a spflow, para que no 
                    //asigne flujo al mensaje de salida., Esto también esta validado desde el jsp typeOfContent
                    if ((toPost.equals("msg") && !SocialLoader.getPFlowManager().isManagedByPflow(socialPFlow, Message.sclass))
                            || (toPost.equals("photo") && !SocialLoader.getPFlowManager().isManagedByPflow(socialPFlow, Photo.sclass))
                            || (toPost.equals("video") && !SocialLoader.getPFlowManager().isManagedByPflow(socialPFlow, Video.sclass))) {
                        socialPFlow = null;
                    }
                }

                //SWBSocialUtil.PostOutUtil.sendNewPost(postIn, postIn.getSocialTopic(), socialPFlow, aSocialNets, wsite, toPost, request, response);
                if (postIn != null) {//When is a response from the timeline
                    SWBSocialUtil.PostOutUtil.sendNewPost(postIn, postIn.getSocialTopic(), socialPFlow, aSocialNets, wsite, toPost, request, response);
                } else if (socialTopic != null) {//When is new tweet to some user
                    SWBSocialUtil.PostOutUtil.sendNewPost(null, socialTopic, socialPFlow, aSocialNets, wsite, toPost, request, response);
                }

                response.setRenderParameter("repliedPost", "ok");
                response.setMode("postSent");
            }
        }else if(action.equals("deleteMessage")){
            String id = request.getParameter("id");
            String objUri = request.getParameter("suri");
            String currentTab = request.getParameter("currentTab");
            response.setRenderParameter("id", id+"");

            SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
            Facebook facebook = (Facebook) semanticObject.createGenericInstance();
            
            try{                
                HashMap<String, String> params = new HashMap<String, String>(2);
                params.put("access_token", facebook.getAccessToken());
                                
                String fbResponse = "";
                fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + id,
                        Facebook.USER_AGENT, "DELETE");
                if(fbResponse.equalsIgnoreCase("true")){
                    response.setRenderParameter("id", id+"");
                    response.setRenderParameter("currentTab", currentTab);
                    response.setRenderParameter("suri", objUri);                    
                    response.setMode("deletedSent"); //show Deleted Message and removes div
                }else{
                    response.setRenderParameter("id", id+"");
                    response.setRenderParameter("currentTab", currentTab);
                    response.setRenderParameter("suri", objUri);                    
                    response.setMode("showErrorOnDelete"); //show Deleted Message and removes div
                }
            }catch(Exception e){
                response.setRenderParameter("id", id+"");
                response.setRenderParameter("currentTab", currentTab);
                response.setRenderParameter("suri", objUri);                    
                response.setMode("showErrorOnDelete"); //show Deleted Message and removes div
            }
        }    
}    
//**fin

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        String currentTab = request.getParameter("currentTab");
        actionURL.setParameter("suri", request.getParameter("suri"));
        renderURL.setParameter("suri", request.getParameter("suri"));
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm a", new Locale("es", "MX"));
        PrintWriter out = response.getWriter();
        if (mode != null && mode.equals("getMorePosts")) {//Gets older posts
            ////System.out.println("brings more POSTS - OLDER");
            doGetMorePosts(request, response, paramRequest);
        } else if (mode != null && mode.equals("moreComments")) {
            doGetMoreComments(request, response, paramRequest);
        } else if (mode != null && mode.equals("newPostsAvailable")) {//Gets the number of new posts if available
            ////System.out.println("brings more posts - NUMBER OF NEW POSTS");
            doAskIfNewPosts(request, response, paramRequest);
        } else if (mode != null && mode.equals("doGetStreamUser")) {//Gets the new posts of the user and don't reload the page
            ////System.out.println("brings more posts - NEWER");
            doGetNewPosts(request, response, paramRequest);
        } else if (mode != null && mode.equals("doGetStreamPictures")) {//Gets the new posts of the user and don't reload the page
            ////System.out.println("brings more PICTURES - NEWER");
            doGetNewPictures(request, response, paramRequest);
        } else if (mode != null && mode.equals("getMorePictures")) {//Gets older pictures
            ////System.out.println("brings more PICTURES - OLDER");
            doGetMorePictures(request, response, paramRequest);
        } else if (mode != null && mode.equals("getMoreVideos")) {
            ////System.out.println("brings more VIDEOS - OLDER");
            doGetMoreVideos(request, response, paramRequest);
        } else if (mode != null && mode.equals("post")) {
            doCreatePost(request, response, paramRequest);
        } else if (mode != null && (mode.equals("likeSent") || mode.equals("unlikeSent"))) {//Displays updated data of liked/unliked status
            String postID = request.getParameter("postID");
            String objUri = request.getParameter("suri");
            SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
            Facebook facebook = (Facebook) semanticObject.createGenericInstance();
            ////System.out.println("ENTRANDO AL LIKE SENT!");
            try {
                HashMap<String, String> params = new HashMap<String, String>(2);
                params.put("access_token", facebook.getAccessToken());
                params.put("fields", "id,from,likes.summary(true)");
                String fbResponse = getRequest(params, Facebook.FACEBOOKGRAPH + postID + "/",
                        Facebook.USER_AGENT);

                JSONObject likeResp = new JSONObject(fbResponse);
                String facebookDate = likeResp.getString("created_time");
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
                formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));

                Date likeTime = formatter.parse(facebookDate);

                //out.write("<em>" + facebookHumanFriendlyDate(likeTime, paramRequest) + "</em>");
                out.write(df.format(likeTime) +"&nbsp;");
                //IMPRIMIR EL CREATED Y LOS NUEVOS LIKES
                boolean iLikedPost = false;
                if (likeResp.has("likes")) {
                    JSONArray likes = likeResp.getJSONObject("likes").getJSONArray("data");
                    out.write("<strong><span> Likes: </span>");
                    int postLikes = 0;
                    if (!likeResp.getJSONObject("likes").isNull("summary")) {
                        if (!likeResp.getJSONObject("likes").getJSONObject("summary").isNull("total_count")) {
                            postLikes = likeResp.getJSONObject("likes").getJSONObject("summary").getInt("total_count");
                        }
                    }
                    out.println(String.valueOf(postLikes));
                    for (int k = 0; k < likes.length(); k++) {
                        if (likes.getJSONObject(k).getString("id").equals(facebook.getFacebookUserId())) {
                            //My User id is in 'the likes' of this post
                            iLikedPost = true;
                        }
                    }

                    if ((likes.length() < postLikes) && (iLikedPost == false)) {
                        params.clear();
                        params.put("access_token", facebook.getAccessToken());
                        String fbLike = null;

                        try {
                            fbLike = getRequest(params, Facebook.FACEBOOKGRAPH + postID + "/likes",
                                    Facebook.USER_AGENT);
                            JSONObject likeRespCounter = new JSONObject(fbLike);
                            if (likeRespCounter.has("data")) {
                                JSONArray likesArray = likeRespCounter.getJSONArray("data");
                                for (int k = 0; k < likesArray.length(); k++) {
                                    if (likesArray.getJSONObject(k).getString("id").equals(facebook.getFacebookUserId())) {
                                        //My User id is in 'the likes' of this post
                                        iLikedPost = true;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            FacebookWall.log.error("Error getting like information for Facebook post " + postID, e);
                        }
                    }
                    out.write("</strong>");
                } else {
                    out.write("<strong><span> Likes: </span>");
                    out.write("0");
                    out.write("</strong>");
                }

                //MOSTRAR SOLO EL LIKE                
                out.println("<span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
                out.println("<script type=\"dojo/method\">");
                out.println("   var spanId = dijit.byId('" + facebook.getId() +
                        postID + FacebookWall.LIKE + currentTab + "');");
                String likeStatus = null;
                if (iLikedPost) {
                    likeStatus = " <a href=\"#\" title=\"" + paramRequest.getLocaleString("undoLike") +
                            "\" class=\"nolike\" onclick=\"postSocialHtml('" +
                            actionURL.setAction("doUnlike").
                                    setParameter("postID", likeResp.getString("id")).
                                    setParameter("currentTab", currentTab) + "','" +
                            facebook.getId() + postID + FacebookWall.INFORMATION + currentTab +
                            "');return false;" + "\"></a>";
                    if (request.getParameter("error") != null) {
                        out.println("   showStatus('ERROR: " + request.getParameter("error") + "');");
                    } else {
                        out.println("   showStatus('Post liked successfully');");
                    }
                } else {
                    likeStatus = " <a href=\"#\" title=\"" + paramRequest.getLocaleString("like") +
                            "\" class=\"like\" onclick=\"postSocialHtml('" +
                            actionURL.setAction("doLike").
                                    setParameter("postID", likeResp.getString("id")).
                                    setParameter("currentTab", currentTab) + "','" +
                            facebook.getId() + postID + FacebookWall.INFORMATION + currentTab +
                            "');return false;" + "\"></a>";
                    if (request.getParameter("error") != null) {
                        out.println("   showStatus('ERROR: " + request.getParameter("error") + "');");
                    } else {
                        out.println("   showStatus('Post unliked successfully');");
                    }
                }
                out.println("   spanId.attr('content', '" + likeStatus.replace("'", "\\'") + "');");
                out.println("</script>");
                out.println("</span>");
            } catch (Exception ex) {
                FacebookWall.log.error("Error when trying to like/unlike post ", ex);
            }
        } else if (mode != null && mode.equals("replyPost")) {//Displays dialog to create post

            Facebook facebook = null;
            String idPost = request.getParameter("postID");
            String objUri = request.getParameter("suri");
            try {
                facebook = (Facebook) SemanticObject.getSemanticObject(objUri).getGenericInstance();
            } catch (Exception e) {
                FacebookWall.log.error("Error getting the SocialNetwork " + e);
                return;
            }

            SocialNetwork socialNetwork = null;
            try {
                socialNetwork = (SocialNetwork) SemanticObject.getSemanticObject(objUri).getGenericInstance();
            } catch (Exception e) {
                FacebookWall.log.error("Error getting the SocialNetwork " + e);
                return;
            }
            SocialNetworkUser socialNetUser = null;

            SWBModel model = WebSite.ClassMgr.getWebSite(socialNetwork.getSemanticObject().getModel().getName());
            PostIn postIn = null;
            try {
                postIn = PostIn.getPostInbySocialMsgId(model, idPost);

                if (postIn == null) {
                    JSONObject postData = getPostFromFullId(idPost, facebook);
                    socialNetUser = SocialNetworkUser.getSocialNetworkUserbyIDAndSocialNet(
                            postData.getJSONObject("from").getString("id"), socialNetwork, model);
                    
                    if (socialNetUser == null) {
                        //Create a socialNetworkUser
                        socialNetUser = SocialNetworkUser.ClassMgr.createSocialNetworkUser(model);
                        socialNetUser.setSnu_id(postData.getJSONObject("from").getString("id"));
                        socialNetUser.setSnu_name(postData.getJSONObject("from").getString("name"));
                        socialNetUser.setSnu_SocialNetworkObj(socialNetwork.getSemanticObject());
                        socialNetUser.setSnu_photoUrl(Facebook.FACEBOOKGRAPH +
                                postData.getJSONObject("from").getString("id") +
                                "/picture?width=150&height=150");
                        socialNetUser.setUserUrl("https://www.facebook.com/" +
                                postData.getJSONObject("from").getString("id"));
                        socialNetUser.setCreated(new Date());
                        //TODO: Llamar al getUserInfoById
                        socialNetUser.setFollowers(0);
                        socialNetUser.setFriends(0);
                    }

                    String postType = "";
                    if (postData.has("type")) {
                        postType = postData.getString("type");
                    } else if (postData.has("metadata") && postData.getJSONObject("metadata").has("type")) {
                        postType = postData.getJSONObject("metadata").getString("type");
                    } else if (postData.has("picture") && postData.has("name") &&
                            postData.has("link") && postData.has("description")) {
                        postType = "link";
                    } else if (postData.has("width") && postData.has("height") && postData.has("picture")) {
                        postType = "photo";
                    } else if (postData.has("embed_html") && postData.has("picture")) {
                        postType = "video";
                    }
                    String message = "";
                    String story = "";

                    if (postType.equals("status") || postType.equals("link") || postType.equals("checkin")) {
                        postIn = MessageIn.ClassMgr.createMessageIn(model);
                        postIn.setPi_type(SWBSocialUtil.POST_TYPE_MESSAGE);
                        if (postType.equals("status")) {
                            if (!postData.isNull("message")) {
                                message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                            } else if (!postData.isNull("story")) {
                                story = (!postData.isNull("story")) ? postData.getString("story") : "";
                                story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                            }
                            if (!message.isEmpty()) {
                                postIn.setMsg_Text(message);
                            } else if (!story.isEmpty()) {
                                postIn.setMsg_Text(story);
                            } else {
                                postIn.setMsg_Text("");
                            }

                        } else if (postType.equals("link")) {
                            if (!postData.isNull("story")) {
                                story = (!postData.isNull("story")) ? postData.getString("story") : "";
                                story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                            }
                            if (!postData.isNull("message")) {
                                message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                            }
                            if (!message.isEmpty()) {
                                postIn.setMsg_Text(message);
                            } else if (!story.isEmpty()) {
                                postIn.setMsg_Text(story);
                            } else {
                                postIn.setMsg_Text("");
                            }
                        }
                    } else if (postType.equals("video") || postType.equals("swf")) {
                        String videoTitle = postData.has("name") ? postData.getString("name") : "Sin título";
                        String videoSource = "";
                        postIn = VideoIn.ClassMgr.createVideoIn(model);
                        postIn.setPi_type(SWBSocialUtil.POST_TYPE_VIDEO);
                        //Get message and/or story
                        if (!postData.isNull("message")) {
                            message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                        } else if (!postData.isNull("story")) {
                            story = (!postData.isNull("story")) ? postData.getString("story") : "";
                            story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                        }

                        if (postData.has("source")) {
                            ////Setting the VIDEO
                            videoSource = postData.getString("source");
                            VideoIn videoIn = (VideoIn) postIn;
                            videoIn.setVideo(videoSource);
                        }
                        if (!message.isEmpty()) {
                            //SETTING MESSAGE
                            postIn.setMsg_Text(message);
                        } else if (!story.isEmpty()) {
                            //SETTING STORY
                            postIn.setMsg_Text(story);
                        } else {
                            //SETTING ONLY THE NAME
                            postIn.setMsg_Text("<a href=\"" + videoSource +
                                    "\" target=\"_blank\">" + videoTitle + "</a>");
                        }

                        //response.setRenderParameter("postUri", postIn.getURI());
                    } else if (postType.equals("photo")) {
                        postIn = PhotoIn.ClassMgr.createPhotoIn(model);
                        postIn.setPi_type(SWBSocialUtil.POST_TYPE_PHOTO);
                        //Get message and/or story
                        if (!postData.isNull("message")) {
                            message = SWBSocialResUtil.Util.createHttpLink(postData.getString("message"));
                        } else if (!postData.isNull("story")) {
                            story = (!postData.isNull("story")) ? postData.getString("story") : "";
                            story = getTagsFromPost(postData.getJSONObject("story_tags"), story);
                        } else if (!postData.isNull("name")) {
                            message = SWBSocialResUtil.Util.createHttpLink(postData.getString("name"));
                        }

                        if (!message.isEmpty()) {
                            postIn.setMsg_Text(message);
                        } else if (!story.isEmpty()) {
                            postIn.setMsg_Text(story);
                        } else {
                            postIn.setMsg_Text("");
                        }

                        if (postData.has("picture")) {
                            String photo = postData.getString("picture");
                            PhotoIn photoIn = (PhotoIn) postIn;
                            photoIn.addPhoto(photo);
                        }

                        //response.setRenderParameter("postUri", postIn.getURI());
                    }

                    //Information of post IN
                    postIn.setSocialNetMsgId(postData.getString("id"));
                    postIn.setPostInSocialNetwork(socialNetwork);
                    postIn.setPostInStream(null);
                    String facebookDate = postData.getString("created_time");
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
                    formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));

                    Date postTime = formatter.parse(facebookDate);
                    if (postTime.after(new Date())) {
                        postIn.setPi_createdInSocialNet(new Date());
                    } else {
                        postIn.setPi_createdInSocialNet(postTime);
                    }
                    String postId = "";
                    if (postData.getString("id").contains("_")) {
                        postId = postData.getString("id").split("_")[1];
                    } else {
                        postId = postData.getString("id");
                    }
                    postIn.setMsg_url("https://www.facebook.com/" +
                            postData.getJSONObject("from").getString("id") + "/posts/" + postId);
                    postIn.setPostInSocialNetworkUser(socialNetUser);
                    Calendar calendario = Calendar.getInstance();
                    postIn.setPi_created(calendario.getTime());

                    SocialTopic defaultSocialTopic = SocialTopic.ClassMgr.getSocialTopic("DefaultTopic", model);
                    if (defaultSocialTopic != null) {
                        postIn.setSocialTopic(defaultSocialTopic);//Asigns socialTipic
                    } else {
                        postIn.setSocialTopic(null);
                    }
                }
            } catch (Exception e) {
                FacebookWall.log.error("Error trying to setSocialTopic: ", e);
            }

            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            final String path = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialTopic/postInResponse.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (dis != null) {
                try {
                    request.setAttribute("postUri", SemanticObject.createSemanticObject(postIn.getURI()));
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    FacebookWall.log.error(e);
                }
            }
            //Post saved
        } else if (mode != null && mode.equals("postSent")) {//Hides dialog used to create Post
            if (request.getParameter("repliedPost") != null &&
                    request.getParameter("repliedPost").equals("ok")) {
                out.println("<script type=\"text/javascript\">");
                out.println("   hideDialog();");
                out.println("   showStatus('Post sent');");
                out.println("</script>");
            }
        } else if (mode != null && mode.equals("displayPicture")) {
            out.println("<div style=\"width: 640px; height: 480px; border: thick solid #F88D38; overflow: hidden; position: relative; background-color:#CDD0D1;\">");
            out.println("    <img src=\"" +
                    URLDecoder.decode(request.getParameter("pictureUrl"), "UTF-8") +
                    "\"style=\"position: absolute;\" onload=\"showFullImage(this);\"/>");
            out.println("</div>");
        } else if (mode != null && mode.equals("displayVideo")) {
            String jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/playVideo.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                dis.include(request, response);
            } catch (Exception e) {
                FacebookWall.log.error("Error in displayVideo() for requestDispatcher", e);
            }
        } else if (mode.equals("fullProfile")) {//Show user or page profile in dialog
            String profileType = request.getParameter("type") == null ? "" : (String) request.getParameter("type");
            String objUri = (String) request.getParameter("suri");
            SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
            Facebook facebook = (Facebook) semanticObject.createGenericInstance();
            String jspResponse;

            if (profileType.equals("noType")) {
                try {
                    if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
                        JSONObject profile = new JSONObject(getProfileFromId(request.getParameter("id"), facebook));
                        //profile = profile.getJSONArray("data").getJSONObject(0);
                        profileType = profile.has("metadata")
                                      ? profile.getJSONObject("metadata").getString("type") : "";
                    }
                } catch (JSONException jsone) {
                    FacebookWall.log.error("Error getting profile information" + jsone);
                    return;
                }
            }
            if (profileType.equals("user")) {
                jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                        paramRequest.getWebPage().getWebSiteId() +
                        "/jsp/socialNetworks/facebookUserProfile.jsp";
            } else if (profileType.equals("page")) {
                jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                        paramRequest.getWebPage().getWebSiteId() +
                        "/jsp/socialNetworks/facebookPageProfile.jsp";
            } else {
                return;
            }

            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception e) {
                //System.out.println("Error displaying user profile");
            }
        } else if (mode.equals("doShowTopic")) {//**ini
            final String path = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialTopic/assignTopic.jsp";
            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            RequestDispatcher dis = request.getRequestDispatcher(path);
            String objUri = (String) request.getParameter("suri");
            if (dis != null) {
                try {
                    request.setAttribute("suri", objUri);
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    FacebookWall.log.error("Error on doShowTopic: ", e);
                }
            }
        } else if (mode.equals("doReclassifyTopic")) {
            final String path = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/socialTopic/classifybyTopic.jsp";
            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            RequestDispatcher dis = request.getRequestDispatcher(path);
            if (dis != null) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("postUri"));
                    request.setAttribute("postUri", semObject);
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    FacebookWall.log.error("Error on doReclassifyTopic: " + e);
                }
            }
        } else if (mode.equals("assignedPost")) {
            String id = request.getParameter("id");
            String fbid = request.getParameter("fbid");
            String postUri = request.getParameter("postUri");
            SWBResourceURL clasifybyTopic = renderURL.setMode("doReclassifyTopic").
                    setCallMethod(SWBResourceURL.Call_DIRECT).
                    setParameter("id", id).
                    setParameter("postUri", postUri).
                    setParameter("currentTab", currentTab);
            String url = "<a href=\"#\" class=\"clasifica\" title=\"" +
                    paramRequest.getLocaleString("reclassify") + "\" onclick=\"showDialog('" +
                    clasifybyTopic + "','" + paramRequest.getLocaleString("reclassify") +
                    " post'); return false;\"></a>";
            out.println("<span class=\"inline\" dojoType=\"dojox.layout.ContentPane\">");
            out.println("<script type=\"dojo/method\">");
            out.println("   hideDialog(); ");
            out.println("   try{");///////////Falta poner el id de FACEBOOK
            out.println("   var spanId = dijit.byId('" + fbid + id + FacebookWall.TOPIC + currentTab + "');");
            out.println("   spanId.attr('content', '" + url.replace("'", "\\'") + "');");
            out.println("   }catch(noe){alert('Error:' + noe);}");
            out.println("   showStatus('Tema asociado correctamente');");
            out.println("</script>");
            out.println("</span>");
            //response.setRenderParameter("currentTab", request.getParameter("currentTab"));
            //response.setRenderParameter("id", idStatus);
        } else if (mode.equals("reAssignedPost")) {
            out.println("<script type=\"javascript\">");
            out.println("   hideDialog(); ");
            out.println("   showStatus('El tema fue cambiado correctamente');");
            out.println("</script>");
        } else if (mode.equals("storeInterval")) {//Storing the interval for the current uri
            String objUri = request.getParameter("suri");
            if (request.getParameter("interval") != null) {
                HttpSession session = request.getSession(true);
                session.setAttribute(objUri + "pooling", request.getParameter("interval"));
            }
        } else if (mode.equals("more")) {
            try {
                moreContacts(request, response, paramRequest);
            } catch (JSONException ex) {
                FacebookWall.log.error(ex);
            }
        } else if (mode.equals("createPost")) {
            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            String jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                    paramRequest.getWebPage().getWebSiteId() + "/jsp/post/createNewPostToUser.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception e) {
                FacebookWall.log.error(e);
            }

        } else if (mode!= null && mode.equals("deletedSent")) {//Removes HTML and shows message
                String id = request.getParameter("id");
                String objUri = request.getParameter("suri");
                SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
                Facebook semFacebook = (Facebook) semanticObject.createGenericInstance();
                out.println("<script type=\"text/javascript\">");
                out.println("   var news = document.getElementById('" +
                        semFacebook.getId() + id + FacebookWall.NEWS_FEED_TAB + "');");
                out.println("   var wall = document.getElementById('" +
                        semFacebook.getId() + id + FacebookWall.WALL_TAB + "');");
                out.println("   var picture  = document.getElementById('" +
                        semFacebook.getId() + id + FacebookWall.PICTURES_TAB + "');");
                out.println("   var video  = document.getElementById('" +
                        semFacebook.getId() + id + FacebookWall.VIDEOS_TAB + "');");
                out.println("   if(news)");
                out.println("       try{news.parentNode.removeChild( news );}catch(noe){};");
                out.println("   if(wall)");
                out.println("       try{wall.parentNode.removeChild( wall );}catch(noe){};");
                out.println("   if(picture)");
                out.println("       try{picture.parentNode.removeChild( picture );}catch(noe){};");
                out.println("   if(video)");
                out.println("       try{video.parentNode.removeChild( video );}catch(noe){};");
            out.println("   showStatus('El mensaje fue eliminado!');");                    
                out.println("</script>");
        } else if (mode != null && mode.equals("showErrorOnDelete")) {//Displays updated data and shows error
            String id = request.getParameter("id");
            String tabSuffix = request.getParameter("currentTab");
            String objUri = request.getParameter("suri");
            SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
            Facebook semFacebook = (Facebook) semanticObject.createGenericInstance();
            out.println("      <a title=\"" + "Eliminar mensaje" +
                    "\" href=\"#\" class=\"eliminarYoutube\" onclick=\"if(confirm('" +
                    "¿Deseas eliminar el mensaje?" + "')){try{dojo.byId(this.parentNode).innerHTML = '<img src=" +
                    SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" +
                    paramRequest.getActionUrl().setAction("deleteMessage").
                            setParameter("id", id).
                            setParameter("currentTab", tabSuffix).
                            setParameter("suri", objUri) +
                    "','" + semFacebook.getId() + id + "REMOVE" + tabSuffix +
                    "');} return false;\"></a>");
            out.println("<script type=\"text/javascript\">");
            out.println("   showError('No fue posible procesar la solicitud');");
            out.println("</script>");
        } else if (mode != null && mode.equals("showErrorOnDelete")) {//Displays updated data and shows error
            String id = request.getParameter("id");
            String tabSuffix = request.getParameter("currentTab");
            String objUri = request.getParameter("objUri");
            SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
            Facebook semFacebook = (Facebook) semanticObject.createGenericInstance();            
            out.write("      <a title=\"" + "Eliminar Mensaje" +
                    "\" href=\"#\" class=\"eliminarYoutube\" onclick=\"if(confirm('" +
                    "¿Deseas eliminar el mensaje?" + "')){try{dojo.byId(this.parentNode).innerHTML = '<img src=" +
                    SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" +
                    paramRequest.getActionUrl().setAction("deleteMessage").
                            setParameter("id", id).
                            setParameter("currentTab", tabSuffix).
                            setParameter("suri", request.getParameter("suri")) +
                    "','" + semFacebook.getId() + id + "REMOVE" + tabSuffix +
                    "');} return false;\"></a>");
            out.println("<script type=\"text/javascript\">");
            out.println("   showError('No fue posible procesar la solicitud');");
            out.println("</script>");
        } else if (mode != null && mode.equals("getPermission")) {
            doGetPermission(request, response, paramRequest);
        } else if (mode != null && mode.equals("closeWin")) {
            doCloseWin(request, response, paramRequest);
        } else {//**fin
            super.processRequest(request, response, paramRequest);
        }
    }

    /**
     * Obtiene los datos de otro bloque de posts publicados en Facebook previos a los ya mostrados en la interface
     * @param request la peticion HTTP generada por el cliente
     * @param response la respuesta HTTP que se enviara al cliente
     * @param paramRequest contiene datos complementarios a la peticion HTTP necesarios para la plataforma SWB
     * @throws SWBResourceException si ocurre algun problema en la ejecucion del metodo
     * @throws IOException si ocurre algun problema en la lectura o escritura de la peticion o respuesta HTTP del cliente
     */
    public void doGetMorePosts(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        String scope = request.getParameter("scope") == null ? "" : request.getParameter("scope");
        String currentTab = request.getParameter("currentTab") == null ? "" : request.getParameter("currentTab");
        String before = request.getParameter("before");
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();
        SWBModel model = WebSite.ClassMgr.getWebSite(facebook.getSemanticObject().getModel().getName());
        HttpSession session = request.getSession(true);
        if (objUri != null) {
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }
        HashMap<String, String> params = new HashMap<String, String>(3);
        params.put("access_token", facebook.getAccessToken());
        params.put("limit", "5");
        params.put("fields", "id,from,to,message,message_tags,story,story_tags,picture,caption,link,object_id,application,source,name,description,properties,privacy,type,status_type,created_time,actions,likes.summary(true),comments.limit(5).summary(true),place");
        if (before != null && !before.isEmpty()) {
            params.put("since", before);
        }
        String fbResponse = "";
        String untilPost = "";
        try {
            if (scope.equals("newsFeed")) {
                fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + "me/home",
                                         Facebook.USER_AGENT, "GET");
            } else if (scope.equals("wall")) {
                String requestUrl = null;
                boolean fromSession = false;
                if (session.getAttribute(objUri + FacebookWall.WALL_TAB + "nextPage") != null) {
                    requestUrl = (String) session.getAttribute(objUri + FacebookWall.WALL_TAB + "nextPage");
                    fromSession = true;
                    session.setAttribute(objUri + FacebookWall.WALL_TAB + "nextPage", null);
                }
                if (fromSession) {
                    fbResponse = postRequest(null, requestUrl, Facebook.USER_AGENT, "GET");
                } else {
                    fbResponse = postRequest(params,
                            Facebook.FACEBOOKGRAPH + facebook.getFacebookUserId() + "/feed",
                            Facebook.USER_AGENT, "GET");
                }
            }
            untilPost = parseResponse(fbResponse, out, false, request, paramRequest, currentTab, model);
            if (untilPost == null) {//If no exception was thrown but the value is null
                untilPost = request.getParameter("before");//return the original value
            }
        } catch (Exception e) {
            untilPost = request.getParameter("before");//return the original value on exception
            FacebookWall.log.error("Problem recovering more posts", e);
        }
        //CAMBIAR EL ID DEL DIV dependiendo de donde sea llamado
        if (untilPost != null) {
            out.println("<div align=\"center\" style=\"margin-bottom: 10px;\">");
            if (scope.equals("newsFeed")) {
                out.println("<label id=\"" + objUri +
                        "morePostsLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" +
                        renderURL.setMode("getMorePosts").
                                setParameter("before", untilPost).
                                setParameter("scope", scope).
                                setParameter("currentTab", currentTab) +
                        "','" + objUri +
                        "getMorePosts','bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;\">" +
                        paramRequest.getLocaleString("getMorePosts") + "</a></label>");
            } else if (scope.equals("wall")) {
                out.println("<label id=\"" + objUri +
                        "morePostsWallLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" +
                        renderURL.setMode("getMorePosts").
    //                            setParameter("before", untilPost).Ya no se usa
                                setParameter("scope", scope).
                                setParameter("currentTab", currentTab) +
                        "','" + objUri +
                        "getMorePostsWall','bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;\">" +
                        paramRequest.getLocaleString("getMorePosts") + "</a></label>");
            }
            out.println("</div>");
        }
    }

    /**
     * Obtiene los datos de otro bloque de fotos publicadas en Facebook previas a las ya mostradas en la interface
     * @param request la peticion HTTP generada por el cliente
     * @param response la respuesta HTTP que se enviara al cliente
     * @param paramRequest contiene datos complementarios a la peticion HTTP necesarios para la plataforma SWB
     * @throws SWBResourceException si ocurre algun problema en la ejecucion del metodo
     * @throws IOException si ocurre algun problema en la lectura o escritura de la peticion o respuesta HTTP del cliente
     */
    public void doGetMorePictures(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        String beforeCursor = request.getParameter("createdTime");
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();
        SWBModel model = WebSite.ClassMgr.getWebSite(facebook.getSemanticObject().getModel().getName());
        short picturesExpected = 25;
        if (objUri != null) {
            renderURL.setParameter("suri", objUri);
        }
        if (beforeCursor == null) {
            beforeCursor = (String) request.getSession(true).getAttribute(objUri + FacebookWall.PICTURES_TAB + "since");
        }
        String fbResponse = "";
        HashMap<String, String> params = new HashMap<String, String>(4);
//        params.put("q", "{\"pictures\": \"SELECT actor_id, created_time, like_info, post_id, attachment, message, description, description_tags, type, comments FROM stream WHERE filter_key IN "
//                + "( SELECT filter_key FROM stream_filter WHERE uid = me() AND name = 'Photos') AND created_time < " + createdTimeParam + " LIMIT 25\", \"usernames\": \"SELECT uid, name FROM user WHERE uid IN (SELECT actor_id FROM #pictures)\", \"pages\":\"SELECT page_id, name FROM page WHERE page_id IN (SELECT actor_id FROM #pictures)\"}");
        params.put("access_token", facebook.getAccessToken());
        params.put("limit", "" + picturesExpected);
        params.put("before", beforeCursor);

        fbResponse = getRequest(params, Facebook.FACEBOOKGRAPH + "me/photos", Facebook.USER_AGENT);

        String createdTime = picture(fbResponse, out, false, request, paramRequest, model);
        if (createdTime == null || createdTime.isEmpty()) {//A problem was found, recover the original value of the param
            createdTime = beforeCursor;
        } else {
            out.println("<div align=\"center\" style=\"margin-bottom: 10px;\">");
            out.println("<label id=\"" + objUri +
                    "morePicturesLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" +
                    renderURL.setMode("getMorePictures").setParameter("createdTime", createdTime) +
                    "','" + objUri + "getMorePictures','bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;\">" +
                    paramRequest.getLocaleString("getMoreImages") + "</a></label>");
            out.println("</div>");
        }
    }

    /**
     * Obtiene los datos de otro bloque de videos publicados en Facebook previos a los ya mostrados en la interface
     * @param request la peticion HTTP generada por el cliente
     * @param response la respuesta HTTP que se enviara al cliente
     * @param paramRequest contiene datos complementarios a la peticion HTTP necesarios para la plataforma SWB
     * @throws SWBResourceException si ocurre algun problema en la ejecucion del metodo
     * @throws IOException si ocurre algun problema en la lectura o escritura de la peticion o respuesta HTTP del cliente
     */
    public void doGetMoreVideos(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        String beforeCursor = request.getParameter("createdTime");
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();
        SWBModel model = WebSite.ClassMgr.getWebSite(facebook.getSemanticObject().getModel().getName());
        if (objUri != null) {
            renderURL.setParameter("suri", objUri);
        }
        String fbResponse = "";

        if (beforeCursor == null || beforeCursor.isEmpty()) {
            beforeCursor = (String) request.getSession(true).getAttribute(objUri + FacebookWall.VIDEOS_TAB + "after");
        }
        HashMap<String, String> params = new HashMap<String, String>(4);
        params.put("access_token", facebook.getAccessToken());
        params.put("limit", "25");
        params.put("after", beforeCursor);
        params.put("fields", "id,from,picture,created_time,likes.summary(true),source,name,description,tags,comments.limit(5).summary(true)");
        fbResponse = getRequest(params, Facebook.FACEBOOKGRAPH + "me/videos/uploaded", Facebook.USER_AGENT);
        
        String createdTime = video(fbResponse, out, false, request, paramRequest, model);
        if (createdTime == null) {//A problem was found, recover the original value of the param
            createdTime = beforeCursor;
        }
        
        if (createdTime != null && !createdTime.isEmpty()) {
            out.println("<div align=\"center\" style=\"margin-bottom: 10px;\">");
            out.println("<label id=\"" + objUri +
                    "moreVideosLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" +
                    renderURL.setMode("getMoreVideos").
                            setParameter("suri", objUri).
                            setParameter("currentTab", FacebookWall.VIDEOS_TAB).
                            setParameter("createdTime", createdTime) +
                    "','" + objUri + "getMoreVideos','bottom');try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;\">" +
                    paramRequest.getLocaleString("getMoreVideos") + "</a></label>");
            out.println("</div>");
        }
    }

    //get the next comments of a post
    public void doGetMoreComments(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String postId = request.getParameter("postId");
        String objUri = request.getParameter("suri");
        String after = request.getParameter("after");
        String currentTab = request.getParameter("currentTab");
        PrintWriter out = response.getWriter();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm a", new Locale("es", "MX"));
        if (postId == null || objUri == null || after == null || objUri == null) {//If error don't show 'View more comments'
            return;
        }

        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        renderURL.setParameter("suri", objUri);

        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();

        HashMap<String, String> params = new HashMap<String, String>(3);
        params.put("access_token", facebook.getAccessToken());
        params.put("after", after);
        params.put("limit", "10");

        String fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + postId + "/comments",
                Facebook.USER_AGENT, "GET");

        try {
            JSONObject commentsObj = new JSONObject(fbResponse);

            if (commentsObj.has("data")) {
                JSONArray comments = commentsObj.getJSONArray("data");

                for (int k = 0; k < comments.length(); k++) {
                    out.write("<li>");
                    out.write("<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") + "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").setParameter("type", "noType").setParameter("id", comments.getJSONObject(k).getJSONObject("from").getLong("id") + "") + "','" + comments.getJSONObject(k).getJSONObject("from").getString("name") + "'); return false;\"><img src=\"http://graph.facebook.com/" + comments.getJSONObject(k).getJSONObject("from").getLong("id") + "/picture?width=30&height=30\" width=\"30\" height=\"30\"/></a>");

                    out.write("<p>");
                    out.write("<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") + "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").setParameter("type", "noType").setParameter("id", comments.getJSONObject(k).getJSONObject("from").getLong("id") + "") + "','" + comments.getJSONObject(k).getJSONObject("from").getString("name") + "'); return false;\">" + comments.getJSONObject(k).getJSONObject("from").getString("name") + "</a>:");
                    out.write(comments.getJSONObject(k).getString("message").replace("\n", "</br>") + "</br>");
                    out.write("</p>");

                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
                    formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
                    Date commentTime = formatter.parse(comments.getJSONObject(k).getString("created_time"));

                    //out.write("<div id=\"" + facebook.getId() + comments.getJSONObject(k).getString("id") + "_" + postId + "\" dojoType=\"dojox.layout.ContentPane\">");
                    out.write("<p class=\"timelinedate\">");
                    out.write("<span style=\"width:150px;\" dojoType=\"dojox.layout.ContentPane\">");
                    out.write(df.format(commentTime) +"&nbsp;");
                    if (comments.getJSONObject(k).has("like_count")) {
                        out.write("<strong>");
                        out.write("<span> Likes: " + comments.getJSONObject(k).getInt("like_count") + "</span>");
                        out.write("</strong>");
                    }
                    out.write("</span>");
                    out.write("</li>");
                }

                if (commentsObj.has("paging")) {//get link to view additional comments if available
                    JSONObject pagingComments = commentsObj.getJSONObject("paging");
                    if (pagingComments.has("cursors") && pagingComments.has("next")) {
                        out.write("<li class=\"timelinemore\">");
                        SWBResourceURL commentsURL = paramRequest.getRenderUrl().setMode("moreComments").setParameter("suri", request.getParameter("suri")).setParameter("postId", postId);
                        commentsURL = commentsURL.setParameter("after", pagingComments.getJSONObject("cursors").getString("after")).setParameter("currentTab", currentTab);
                        out.write("<label><a href=\"#\" onclick=\"appendHtmlAt('" + commentsURL
                                + "','" + facebook.getId() + postId + currentTab + "/comments', 'bottom');try{this.parentNode.parentNode.removeChild( this.parentNode );}catch(noe){}; return false;\"><span>+</span>" + paramRequest.getLocaleString("moreComments") + "</a></a></label>");
                        out.write("</li>");
                    }
                }
            }
        } catch (Exception e) {//If an exception is thrown return the original message
            out.write("<div align=\"left\" id=\"" + postId + "/" + currentTab +
                    "/comments\" dojoType=\"dojox.layout.ContentPane\">");
            SWBResourceURL commentsURL = paramRequest.getRenderUrl().
                    setMode("moreComments").
                    setParameter("suri", request.getParameter("suri")).
                    setParameter("postId", postId);
            commentsURL = commentsURL.setParameter("after", after).setParameter("currentTab", currentTab);
            out.write("<label id=\"morePostsLabel\"><a href=\"#\" onclick=\"appendHtmlAt('" + commentsURL
                    + "','" + postId + "/" + currentTab +
                    "/comments', 'bottom');try{this.parentNode.parentNode.removeChild( this.parentNode );}catch(noe){}; return false;\">" +
                    paramRequest.getLocaleString("moreComments") + "</a></label>");
            out.write("</div>");

            FacebookWall.log.error("Unable to get additional comments: ", e);
        }
    }

    /**
     * Analiza la respuesta de Facebook y obtiene la informaci&oacute;n de los
     * mensajes publicados en el muro del usuario actual Con base en la
     * estructura del objeto JSON devuelto por Facebook, se revisa que la
     * respuesta cuenta con información de los posts recibidos para
     * posteriormente desplegarlos uno a uno en el objeto de salida indicado. Se
     * obtienen también el valor del parámetro usado para traer el siguiente
     * bloque de posts.
     * @param response representa la respuesta obtenida de Facebook en formato JSON
     * @param out Salida estándar en donde se imprime el contenido del post
     * @param includeSinceParam valor que define si se incluye en la variable de sesi&oacute;n el valor
     *        del último post recibido para posteriormente preguntar a Facebook si hay nuevos posts.
     * @param request est&aacute;ndar HttpServletRequest
     * @param paramRequest est&aacute;ndar SWBParamRequest
     * @param tabSuffix sufijo del nombre del tab en la interface en que se mostrara la informacion
     * @param model el modelo o sitio al que estan relacionados los datos mostrados
     * @return un {@code String} con el valor del cursor que indica el siguiente conjunto de datos en Facebook
     *         a mostrar en la interface
     */
    public static String parseResponse(String response, Writer out, boolean includeSinceParam,
            HttpServletRequest request, SWBParamRequest paramRequest, String tabSuffix,
            SWBModel model) {

        String until = null;
        String since = "";
        String objUri = (String) request.getParameter("suri");
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();

        try {
            JSONObject phraseResp = new JSONObject(response);
            int cont = 0;
            JSONArray postsData = phraseResp.getJSONArray("data");

            org.semanticwb.model.User user = paramRequest.getUser();
            HashMap<String, SemanticProperty> mapa = new HashMap<String, SemanticProperty>();
            Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().
                    getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#SocialUserExtAttributes").listProperties();
            while (list.hasNext()) {
                SemanticProperty sp = list.next();
                mapa.put(sp.getName(),sp);
            }
            boolean userCanRetopicMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanReTopicMsg"))).booleanValue();
            boolean userCanRespondMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRespondMsg"))).booleanValue();
            boolean userCanRemoveMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRemoveMsg"))).booleanValue();
            UserGroup userSuperAdminGrp=SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
            for (int k = 0; k < postsData.length(); k++) {
                cont++;
                doPrintPost(out, postsData.getJSONObject(k), request, paramRequest,
                        tabSuffix, facebook, model, user.hasUserGroup(userSuperAdminGrp),
                        userCanRetopicMsg, userCanRespondMsg, userCanRemoveMsg);
            }
            if (phraseResp.has("paging")) {
                JSONObject pagingData = phraseResp.getJSONObject("paging");
                if (pagingData.has("cursors")) {
                    until = pagingData.getJSONObject("cursors").has("before")
                            ? pagingData.getJSONObject("cursors").getString("before") : "";
                } else {
                    String nextPage = pagingData.getString("next"); // get until param to get OLDER posts
                    Pattern pattern = Pattern.compile("until=[0-9]+");
                    Matcher matcher = pattern.matcher(nextPage);
                    String untilParam = "";
                    HttpSession session = request.getSession(true);
                    session.setAttribute(objUri + tabSuffix + "nextPage", nextPage);
                    if (matcher.find()) {
                        untilParam = matcher.group();
                    }
                    if (!untilParam.isEmpty()) {
                        until = untilParam.substring(untilParam.indexOf("=") + 1);//gets only the value of until param in paging object
                    }
//                    if (includeSinceParam) {//Include value of since param when the tab is loaded and when GetNewPost link is clicked
//                        String previousPage = pagingData.getString("previous"); // get since param to get NEWER posts
//                        pattern = Pattern.compile("since=[0-9]+");
//                        matcher = pattern.matcher(previousPage);
//                        String sinceParam = "";
//
//                        if (matcher.find()) {
//                            sinceParam = matcher.group();
//                        }
//                        if (!sinceParam.isEmpty()) {
//                            since = sinceParam.substring(sinceParam.indexOf("=") + 1);//gets only the value of since param in paging object
//                            session.setAttribute(objUri + tabSuffix + "since", since);
//                        }
//                    }
                }
            }
        } catch (JSONException jsone) {
            FacebookWall.log.error("Problemas al parsear respuesta de Facebook", jsone);
        }
        return until;
    }

    /**
     * Muestra la informacion obtenida de las fotos publicadas en Facebook en formato 
     * HTML de acuerdo al espacio destinado en la interface.
     * @param response datos obtenidos de Facebook en formato JSON
     * @param out la instancia de un objeto {@code Writer} por defecto de una JSP
     * @param includeSinceParam indica si se agrega a la sesion, el atributo que identifica el ultimo elemento devuelto
     * @param request la peticion HTTP hecha por el cliente
     * @param paramRequest objeto con propiedades complementarias de la plataforma de SWB
     * @param model instancia del modelo o sitio al que estan asociados los datos
     * @param picturesExpected numero de imagenes que se esperan en la respuesta
     * @return un {@code String} con el codigo HTML generado para presentar las fotos obtenidas desde Facebook
     */
    public static String picture(String response, Writer out, boolean includeSinceParam,
            HttpServletRequest request, SWBParamRequest paramRequest, SWBModel model) {

        String beforeCursor = null;
        String objUri = (String) request.getParameter("suri");
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();

        try {
            JSONObject phraseResp = new JSONObject(response);
            int cont = 0;
            JSONArray postsData = null;

            if (phraseResp.has("data")) {
                postsData = phraseResp.getJSONArray("data");
            }

            if (postsData != null) {
                cont = postsData.length();
                for (int k = 0; k < postsData.length(); k++) {
                    cont++;
                    JSONObject profileID = postsData.getJSONObject(k).has("from") && !postsData.getJSONObject(k).isNull("from")
                                           ? postsData.getJSONObject(k).getJSONObject("from") : null;
                    JSONObject postComments = null;
                    
                    Map<String, String> params = new HashMap<String, String>(2);
                    params.put("access_token", facebook.getAccessToken());
                    params.put("limit", "5");
                    try {
                        String fbResponse = postRequest(params,
                                Facebook.FACEBOOKGRAPH + postsData.getJSONObject(k).getString("id") + "/comments",
                                Facebook.USER_AGENT,
                                "GET");
                        postComments = new JSONObject(fbResponse);
                    } catch (Exception e) {
                        FacebookWall.log.error("Error getting comments of post",  e);
                    }
                    
                    org.semanticwb.model.User user = paramRequest.getUser();
                    HashMap<String, SemanticProperty> mapa = new HashMap<String, SemanticProperty>();
                    Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().
                            getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#SocialUserExtAttributes").listProperties();
                    while (list.hasNext()) {
                        SemanticProperty sp = list.next();
                        mapa.put(sp.getName(), sp);
                    }
                    boolean userCanRetopicMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanReTopicMsg"))).booleanValue();                
                    boolean userCanRespondMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRespondMsg"))).booleanValue();
                    boolean userCanRemoveMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRemoveMsg"))).booleanValue();
                    UserGroup userSuperAdminGrp = SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
                    beforeCursor = FacebookWall.printPicture(out, postsData.getJSONObject(k), postComments,
                            profileID, request, paramRequest, FacebookWall.PICTURES_TAB, facebook,
                            model, user.hasUserGroup(userSuperAdminGrp), userCanRetopicMsg,
                            userCanRespondMsg, userCanRemoveMsg);
                }
            }
            if (phraseResp.has("paging") && phraseResp.getJSONObject("paging").has("cursors")) {
                beforeCursor = phraseResp.getJSONObject("paging").getJSONObject("cursors").getString("before");
                //Only include the param in session when the page loads the first time and when 
                if (includeSinceParam) {//Only save the most recent picture id (the first), then use this id to ask if new pictures available
                    HttpSession session = request.getSession(true);
                    session.setAttribute(objUri + FacebookWall.PICTURES_TAB + "since", beforeCursor);
                }
            }
            if (cont == 0) {
                beforeCursor = "";
            }
        } catch (Exception jsone) {
            FacebookWall.log.error("Al parsear respuesta de Facebook con fotos", jsone);
            beforeCursor = "";
        }
        return beforeCursor;
    }

    /**
     * Ejecuta el metodo que genera el codigo HTML necesario para mostrar los videos publicados por el usuario autenticado o 
     * aquellos en los que fue etiquetado y la informacion asociada a ellos como comentarios y {@literal likes},
     * proporcionandole la informacion necesaria, tanto del video como de sus comentarios.
     * @param response la respuesta de la peticion hecha a Facebook para obtener la informacion de los videos a mostrar
     * @param out la instancia del {@code Writer} asociado por defecto a las JSP's
     * @param includeSinceParam indica si se agrega a sesion un atributo con el valor de la 
     *        fecha del ultimo video recuperado de Facebook
     * @param request la peticion HTTP hecha por el cliente
     * @param paramRequest el objeto propio de la plataforma de SWB con datos complementarios de la peticion
     * @param model el modelo al que estan relacionados los datos a mostrar
     * @return un {@code String} con el codigo HTML generado para mostrar los videos obtenidos de Facebook
     */
    public static String video(String response, Writer out, boolean includeSinceParam,
            HttpServletRequest request, SWBParamRequest paramRequest, SWBModel model) {

        String afterCursor = null;

        String objUri = (String) request.getParameter("suri");
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();

        try {
            JSONObject phraseResp = new JSONObject(response);
            JSONArray postsData = null;
            org.semanticwb.model.User user = paramRequest.getUser();
            HashMap<String, SemanticProperty> mapa = new HashMap<String, SemanticProperty>();
            Iterator<SemanticProperty> list = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().
                    getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#SocialUserExtAttributes").listProperties();
            while (list.hasNext()) {
                SemanticProperty sp = list.next();
                mapa.put(sp.getName(),sp);
            }
            boolean userCanRetopicMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanReTopicMsg"))).booleanValue();
            boolean userCanRespondMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRespondMsg"))).booleanValue();
            boolean userCanRemoveMsg = ((Boolean) user.getExtendedAttribute(mapa.get("userCanRemoveMsg"))).booleanValue();
            UserGroup userSuperAdminGrp = SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
            if (phraseResp.has("data")) {
                postsData = phraseResp.getJSONArray("data");
            }

            if (postsData != null) {
                for (int k = 0; k < postsData.length(); k++) {
                    JSONObject video = postsData.getJSONObject(k);
                    JSONObject profileID = video.has("from") && !video.isNull("from")
                                           ? video.getJSONObject("from") : null;
                    JSONObject postComments = video.getJSONObject("comments");
                    //make te request for comments of the current post
//                    HashMap<String, String> params = new HashMap<String, String>(2);
//                    params.put("access_token", facebook.getAccessToken());
//                    params.put("limit", "5");
//                    try {
//                        String fbResponse = postRequest(params,
//                                Facebook.FACEBOOKGRAPH + video.getString("id") + "/comments",
//                                Facebook.USER_AGENT,
//                                "GET");
//                        postComments = new JSONObject(fbResponse);
//                    } catch (Exception e) {
//                        FacebookWall.log.error("Error getting comments of post ", e);
//                    }

                    String createdTimeTmp = doPrintVideo(out, video, postComments,
                            profileID, request, paramRequest, FacebookWall.VIDEOS_TAB,
                            facebook, model, user.hasUserGroup(userSuperAdminGrp),
                            userCanRetopicMsg, userCanRespondMsg, userCanRemoveMsg);
                    if (createdTimeTmp != null) {
                        afterCursor = createdTimeTmp;
                    }
                }
            }
            if (phraseResp.has("paging") && phraseResp.getJSONObject("paging").has("cursors")) {
                afterCursor = phraseResp.getJSONObject("paging").getJSONObject("cursors").getString("after");
                //Only include the param in session when the page loads the first time and when 
                if (includeSinceParam) {//Only save the most recent picture id (the first), then use this id to ask if new pictures available
                    HttpSession session = request.getSession(true);
                    session.setAttribute(objUri + FacebookWall.VIDEOS_TAB + "after", afterCursor);
                }
            }
            if (postsData == null || postsData.length() == 0) {
                afterCursor = "";
            }
        } catch (Exception e) {
            FacebookWall.log.error("Problemas al parsear respuesta de Facebook-video", e);
            afterCursor = "";
        }
        return afterCursor;
    }

    public static String getHtmlForTags(JSONArray tagsObject, String postContent, SWBResourceURL renderURL) {
        String postContentWithUrl = postContent;
        String userUrl = "";
        try {
            if (tagsObject != null) {
                for (int i = 0; i < tagsObject.length(); i++) {
                    JSONObject tag = tagsObject.getJSONObject(i);
                    if (tag.has("name") && postContentWithUrl.contains(tag.getString("name"))) {
                        userUrl = "<a href=\"#\" title=\"View profile\" onclick=\"showDialog('" +
                                renderURL.setMode("fullProfile").setParameter("type", "noType").
                                        setParameter("id", tag.getString("id")) +
                                "','" + tag.getString("name") + "'); return false;\">" +
                                tag.getString("name") + "</a> ";
                        postContentWithUrl = postContentWithUrl.replace(tag.getString("name"), userUrl);
                    }
                }
            }
        } catch (JSONException jsone) {
            FacebookWall.log.error("Al sustituir tags", jsone);
        }
        return postContentWithUrl;
    }
    
    public static String getTagsFromPost(JSONObject objectTags, String postContent, SWBResourceURL renderURL) {
        String postContentWithUrl = postContent;
        Iterator<?> keyTags = objectTags.keys();
        try {
            while (keyTags.hasNext()) {
                String key = (String) keyTags.next();
                if (objectTags.get(key) instanceof JSONArray) {
                    JSONArray tag = objectTags.getJSONArray(key);
                    String userUrl = "";
                    if (tag.getJSONObject(0).has("type")) {
                        userUrl = "<a href=\"#\" title=\"" + "View profile" + "\" onclick=\"showDialog('" +
                                renderURL.setMode("fullProfile").
                                        setParameter("type", tag.getJSONObject(0).getString("type")).
                                        setParameter("id", tag.getJSONObject(0).getString("id")) +
                                "','" + tag.getJSONObject(0).getString("name") + "'); return false;\">" +
                                tag.getJSONObject(0).getString("name") + "</a> ";
                    } else {
                        userUrl = "<a href=\"#\" title=\"" + "View profile" + "\" onclick=\"showDialog('" +
                                renderURL.setMode("fullProfile").
                                        setParameter("type", "noType").
                                        setParameter("id", tag.getJSONObject(0).getString("id")) +
                                "','" + tag.getJSONObject(0).getString("name") + "'); return false;\">" +
                                tag.getJSONObject(0).getString("name") + "</a> ";
                    }
                    //userUrl = "<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") + "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").setParameter("type", tag.getJSONObject(0).getString("type")).setParameter("id", tag.getJSONObject(0).getLong("id")+"") + "','" + tag.getJSONObject(0).getString("name") + "'); return false;\">" + tag.getJSONObject(0).getString("name") + "</a>";
                    postContentWithUrl = postContentWithUrl.replace(tag.getJSONObject(0).getString("name"), userUrl);
                }
            }
        } catch (JSONException jSonException) {
            FacebookWall.log.error("Problem parsing associated users:" + objectTags + "\n\n" + postContent);
            jSonException.printStackTrace();
            return postContent;
        }
        return postContentWithUrl;
    }

    public static String getTagsFromPost(JSONObject objectTags, String postContent) {
        String postContentWithUrl = postContent;
        Iterator<?> keyTags = objectTags.keys();
        try {
            while (keyTags.hasNext()) {
                String key = (String) keyTags.next();
                if (objectTags.get(key) instanceof JSONArray) {
                    JSONArray tag = objectTags.getJSONArray(key);
                    String userUrl = "";
                    userUrl = "<a href=\"http://www.facebook.com/" + tag.getJSONObject(0).getString("id") +
                            "\" target=\"_blank\">" + tag.getJSONObject(0).getString("name") + "</a> ";
                    postContentWithUrl = postContentWithUrl.replace(tag.getJSONObject(0).getString("name"), userUrl);
                }
            }
        } catch (JSONException jSonException) {
            FacebookWall.log.error("Problem parsing associated users", jSonException);
            return postContent;
        }
        return postContentWithUrl;
    }

    public static String getTagsFromPostArray(JSONObject objectTags, String postContent, SWBResourceURL renderURL) {
        String postContentWithUrl = postContent;
        try {
            String userUrl = "";
            userUrl = "<a href=\"#\" title=\"" + "View profile" + "\" onclick=\"showDialog('" +
                    renderURL.setMode("fullProfile").
                            setParameter("type", objectTags.getString("type")).
                            setParameter("id", objectTags.getString("id")) + "','" +
                    objectTags.getString("name") + "'); return false;\">" + objectTags.getString("name") + "</a>";
            postContentWithUrl = postContentWithUrl.replace(objectTags.getString("name"), userUrl);

        } catch (JSONException jSonException) {
            FacebookWall.log.error("Problem parsing associated users", jSonException);
        }
        return postContentWithUrl;
    }

    public static JSONObject getPostFromId(String postId, String fields, Facebook facebook) {
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("access_token", facebook.getAccessToken());
        if (fields != null) {
            params.put("fields", fields);
        }

        JSONObject jsonObject = null;
        try {
            String fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + postId.substring(postId.lastIndexOf("_") + 1),
                    Facebook.USER_AGENT, "GET");
            if (!fbResponse.isEmpty()) {
                jsonObject = new JSONObject(fbResponse);
            }
        } catch (IOException ieo) {
            FacebookWall.log.error("Error getting post that user liked:", ieo);
        } catch (JSONException jsone) {
            FacebookWall.log.error("Error parsing information from string recieved:", jsone);
        }
        return jsonObject;
    }

    /**
     * Obtiene la informacion publica de una publicacion a traves del identificador proporcionado
     * @param postId identificador de la publicacion de la que se desea obtener la informacion
     * @param facebook la instancia de la red social asociada a la publicacion identificada por {@code postId}
     * @return la informacion devuelta por Facebook en referencia al identificador recibido en formato {@literal JSON}
     */
    public static JSONObject getPostFromFullId(String postId, Facebook facebook) {
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("access_token", facebook.getAccessToken());
        params.put("metadata", "1");

        JSONObject jsonObject = null;
        try {
            String fbResponse = "";
            boolean failed = false;
            try {
                fbResponse = getRequest(params, Facebook.FACEBOOKGRAPH + postId,
                        Facebook.USER_AGENT);
            } catch (IOException ioe) {
                failed = true;
            }
            if (!fbResponse.isEmpty() || !failed) {
                jsonObject = new JSONObject(fbResponse);
                if (jsonObject.has("error")) {//The request with fullId triggers an error
                    fbResponse = getRequest(params, Facebook.FACEBOOKGRAPH +
                            postId.substring(postId.lastIndexOf("_") + 1) + "/",
                            Facebook.USER_AGENT);
                    if (!fbResponse.isEmpty()) {
                        jsonObject = new JSONObject(fbResponse);
                    }
                }
            }
        } catch (IOException ieo) {
            FacebookWall.log.error("Error getting post from post with, tested both methods:", ieo);
        } catch (JSONException jsone) {
            FacebookWall.log.error("Error parsing information from response recieved:", jsone);
        }
        return jsonObject;
    }

    public static void doPrintPost(Writer writer, JSONObject postsData, HttpServletRequest request,
            SWBParamRequest paramRequest, String tabSuffix, Facebook facebook, SWBModel model,
            boolean userCanDoEveryting, boolean userCanRetopicMsg, boolean userCanRespondMsg,
            boolean userCanRemoveMsg) {
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm a", new Locale("es", "MX"));
        try {
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            actionURL.setParameter("suri", request.getParameter("suri"));
            renderURL.setParameter("suri", request.getParameter("suri"));
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
            String postType = postsData.getString("type");

            String story = "";
            String message = "";
            String caption = "";
            boolean isAPhotoLike = false;
            boolean isALinkLike = false;
            boolean isAPostLike = false;
            boolean isAppCreated = false;
            boolean isAStatusLike = false;
            boolean isFoursquare = false;
            //TODO: FALTA COMMENTED ON A PHOTO
            JSONObject postLike = null;
            JSONObject photoLike = null;
            JSONObject linkLike = null;
            JSONObject applicationCreated = null;
            JSONObject foursquareLink = null;
            JSONObject statusLike = null;

            if (postsData.isNull("actions")) {//You can't like or respond this post
                return;                     //Must NOT be shown in wall
            }

            //If the posts is empty and is application-created don't show it
            if (postsData.isNull("message") && postsData.isNull("story") &&
                    postsData.isNull("name") && postsData.isNull("picture") &&
                    postsData.isNull("link") && postsData.isNull("description") &&
                    !postsData.isNull("application")) {
                return;
            }

            if (postType.equals("photo")) {
                if (!postsData.isNull("story")) {
                    story = (!postsData.isNull("story"))
                            ? postsData.getString("story").replace(postsData.getJSONObject("from").getString("name"), "")
                            : "";
                    if (!postsData.isNull("story_tags")) {//Users tagged in story
                        story = getTagsFromPost(postsData.getJSONObject("story_tags"), story, renderURL);
                    }
                }

                if (!postsData.isNull("message")) {
                    message = SWBSocialResUtil.Util.createHttpLink(postsData.getString("message"));
                    if (!postsData.isNull("message_tags")) {//Users tagged in story
                        message = getTagsFromPost(postsData.getJSONObject("message_tags"), message, renderURL);
                    }
                }
                if (!postsData.isNull("caption")) {
                    caption = postsData.getString("caption").replace("\n", "</br>");
                }
                if (postsData.has("application")) {
                    if (postsData.getJSONObject("application").getString("name").equals("Foursquare")) {
                        return;
                        /*foursquareLink = getPostFromId(postsData.getString("id"), null, facebook);
                         isFoursquare = true;
                         message = "Checked in";
                         */
                    }
                }
                //Story or message or both!!
                //or "status_type": "shared_story", tagged_in_photo
            } else if (postType.equals("link")) {
                //"status_type": "app_created_story",
                if (!postsData.isNull("story")) {
                    story = (!postsData.isNull("story"))
                            ? postsData.getString("story").replace(postsData.getJSONObject("from").getString("name"), "")
                            : "";
                    if (!postsData.isNull("story_tags")) {//Users tagged in story
                        story = getTagsFromPost(postsData.getJSONObject("story_tags"), story, renderURL);
                    }
                    if (story.contains("is going to an event") && postsData.has("link")) {//If the link is an event
                        return;
                        //message = "<a href=\"" + postsData.getString("link") + "\" target=\"_blank\">View event</a>";
                    }
                    if (story.contains("likes a photo")) {
                        return;
                    } else if (story.contains("likes a link")) {
                        return;
                    } else if (story.contains("likes a status")) {
                        return;
                    } else if (story.contains("commented on")) {
                        return;
                    } else if (story.contains("likes")) {
                        return;
                    } else if (story.contains("is going to")) {
                        return;
                    } else if (story.contains("created an event")) {
                        return;
                    }
                }
                if (!postsData.isNull("message")) {
                    message = SWBSocialResUtil.Util.createHttpLink(postsData.getString("message"));
                    if (!postsData.isNull("message_tags")) {//Users tagged in story
                        message = getTagsFromPost(postsData.getJSONObject("message_tags"), message, renderURL);
                    }
                }
                if (postsData.has("application")) {
                    //return;
                    /*
                     if(postsData.getJSONObject("application").getString("name").equals("Instagram")){
                     applicationCreated = getPostFromId(postsData.getString("id"), null, facebook);
                     isAppCreated = true;
                     //System.out.println("\n\n\nAPPLICATION CREATED:" +  applicationCreated);
                     message = "Liked a picture in Instagram";
                     }*/
                }
            } else if (postType.equals("status")) {
                if (postsData.has("story")) {//Do not print the posts when 'User X likes a post'
                    if (postsData.getString("story").contains("likes a post")) {
                        return;
                    }
                }
                if (!postsData.isNull("status_type")) {
                    if (postsData.getString("status_type").equals("wall_post")) {
                        JSONObject toUser = null;
                        if (postsData.has("to")) {
                            toUser = postsData.getJSONObject("to").getJSONArray("data").getJSONObject(0);
                            story = " to " + "<a href=\"#\" title=\"" +
                                    paramRequest.getLocaleString("viewProfile") +
                                    "\" onclick=\"showDialog('" +
                                    renderURL.setMode("fullProfile").
                                            setParameter("type", "noType").
                                            setParameter("id", toUser.getString("id")) +
                                    "','" + toUser.getString("name") + "'); return false;\">" +
                                    toUser.getString("name") + "</a>";
                        }
                    }
                }
                if (!postsData.isNull("message")) {
                    message = SWBSocialResUtil.Util.createHttpLink(postsData.getString("message"));
                    if (!postsData.isNull("message_tags")) {//Users tagged in story
                        JSONObject storyTags = postsData.getJSONObject("message_tags");
                        message = getTagsFromPost(storyTags, message, renderURL);
                    }
                } else if (!postsData.isNull("story")) {
                    story = (!postsData.isNull("story"))
                            ? postsData.getString("story").replace(postsData.getJSONObject("from").getString("name"), "")
                            : "";
                    if (!postsData.isNull("story_tags")) {//Users tagged in story
                        JSONObject storyTags = postsData.getJSONObject("story_tags");
                        story = getTagsFromPost(storyTags, story, renderURL);
                    }
                    if (story.contains("likes a photo")) {
                        /*photoLike = getPostFromId(postsData.getString("id"), "id,from,name,name_tags,picture,source,link,tags", facebook);
                         isAPhotoLike = true;*/
                        return;
                    } else if (story.contains("likes a link")) {//Do not print the posts when 'User X likes a link'
                        /*linkLike = getPostFromId(postsData.getString("id"), "id,from,name,picture,link,tags,message", facebook);
                         isALinkLike = true;*/
                        return;
                    } else if (story.contains("likes a status")) {
                        /*
                         statusLike = getPostFromId(postsData.getString("id"), null, facebook);
                         isAStatusLike = true;
                         //System.out.println("\n\n\nSTATUS LIKED:" +  statusLike);
                         if(statusLike.has("message")){
                         message = statusLike.getString("message");
                         }*/
                        return;
                    } else if (story.contains("commented on")) {
                        return;
                    } else if (story.contains("likes")) {//USER likes PAGE
                        return;
                    } else if (story.contains("is going to")) {//events
                        return;
                    } else if (story.contains("created an event")) {
                        return;
                    }
                } else {//Status must have message OR Story
                    return;
                }
            } else if (postType.equals("video")) {
                if (!postsData.isNull("message")) {
                    message = SWBSocialResUtil.Util.createHttpLink(postsData.getString("message"));
                }
                if (!postsData.isNull("story")) {
                    story = (!postsData.isNull("story"))
                            ? postsData.getString("story").replace(postsData.getJSONObject("from").getString("name"), "")
                            : "";
                    if (!postsData.isNull("story_tags")) {//Users tagged in story
                        JSONObject storyTags = postsData.getJSONObject("story_tags");
                        story = getTagsFromPost(storyTags, story, renderURL);
                    }
                }
            } else if (postType.equals("checkin")) {
                if (!postsData.isNull("message")) {
                    message = SWBSocialResUtil.Util.createHttpLink(postsData.getString("message"));
                    if (!postsData.isNull("message_tags")) {//Users tagged in story
                        JSONObject storyTags = postsData.getJSONObject("message_tags");
                        message = getTagsFromPost(storyTags, message, renderURL);
                    }
                } else {
                    message = postsData.getJSONObject("from").getString("name") + " checked in ";
                }
            } else if (postType.equals("swf")) {
                if (!postsData.isNull("message")) {
                    message = SWBSocialResUtil.Util.createHttpLink(postsData.getString("message"));
                    if (!postsData.isNull("message_tags")) {//Users tagged in story
                        JSONObject storyTags = postsData.getJSONObject("message_tags");
                        message = getTagsFromPost(storyTags, message, renderURL);
                    }
                }
            }
            if (postsData.has("place") && !postsData.isNull("place")) {
                if (postsData.getJSONObject("place").has("name")) {
                    message = message + " at " + "<a href=\"http://facebook.com/" +
                            postsData.getJSONObject("place").getString("id") + "\" target=\"_blank\">" +
                            postsData.getJSONObject("place").getString("name") + "</a>";
                }
            }
            if (isFoursquare) {
                if (foursquareLink.has("place")) {
                    if (foursquareLink.getJSONObject("place").has("name")) {
                        message = message + "by Foursquare AT " + "<a href=\"http://facebook.com/" +
                                foursquareLink.getJSONObject("place").getString("id") +
                                "\" target=\"_blank\">" + foursquareLink.getJSONObject("place").getString("name") +
                                "</a>";
                    }
                }
            }
            //JSONObject profile = new JSONObject(getProfileFromId(postsData.getJSONObject("from").getString("id")+"", facebook));
            //profile = profile.getJSONArray("data").getJSONObject(0);
            writer.write("<div class=\"timeline timelinefacebook\" id=\"" +
                    facebook.getId() + postsData.getString("id") + tabSuffix + "\">");
            //Username and story
            writer.write("<p>");
            writer.write("<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                    "\" onclick=\"showDialog('" +
                    renderURL.setMode("fullProfile").
                            setParameter("type", "noType").
                            setParameter("id", postsData.getJSONObject("from").getString("id")) +
                    "','" + postsData.getJSONObject("from").getString("name") +
                    "'); return false;\">" + postsData.getJSONObject("from").getString("name") +
                    "</a> " + story);
            writer.write("</p>");

            //User image and message
            writer.write("<div class=\"timelineusr\">");
            writer.write("<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                    "\" onclick=\"showDialog('" +
                    renderURL.setMode("fullProfile").
                            setParameter("type", "noType").
                            setParameter("id", postsData.getJSONObject("from").getString("id")) +
                    "','" + postsData.getJSONObject("from").getString("name") +
                    "'); return false;\"><img src=\"http://graph.facebook.com/" +
                    postsData.getJSONObject("from").getString("id") + "/picture\"/></a>");
            writer.write("<p>");
            if (message.isEmpty()) {
                writer.write("&nbsp;");
            } else {
                writer.write(message.replace("\n", "</br>"));
            }
            writer.write("</p>");
            writer.write("</div>");

            //Picture if exists, start
            if (postsData.has("picture") || isAPhotoLike || isALinkLike || isAppCreated) {
                String picture = "";
                if (isAPhotoLike) {
                    if (photoLike.has("source")) {
                        picture = photoLike.getString("source");
                    }
                } else if (isALinkLike) {
                    if (linkLike.has("picture")) {
                        picture = linkLike.getString("picture");
                    }
                } else if (isAPostLike) {
                    if (postLike.has("picture")) {
                        picture = postLike.getString("picture");
                    }
                } else if (isAppCreated) {
                    if (applicationCreated.has("data")) {
                        if (applicationCreated.getJSONObject("data").has("object")) {
                            picture = applicationCreated.getJSONObject("data").
                                    getJSONObject("object").optString("url") + "media";
                        }
                    }
                } else {
                    picture = postsData.getString("picture").replace("_s.", "_n.");
                }
                //Post image
                writer.write("<div class=\"timelineimg\">");
                if (postType.equals("video") || postType.equals("swf")) {
                    writer.write("      <span id=\"vid" + tabSuffix +
                            facebook.getId() + postsData.getString("id") +
                            "\" style=\"width: 250px; height: 250px; border: thick #666666; overflow: hidden; position: relative;\">");
                    writer.write("      <a href=\"#\" onclick=\"showDialog('" +
                            renderURL.setMode("displayVideo").
                                    setParameter("videoUrl", URLEncoder.encode(postsData.getString("source"), "UTF-8")) +
                            "','Video from " + postsData.getJSONObject("from").getString("name") +
                            "'); return false;\"><img src=\"" + picture +
                            "\" style=\"position: relative;\" onerror=\"this.src ='" +
                            picture.replace("_n.", "_s.") + "'\" onload=\"imageLoad(" + "this, 'vid" +
                            tabSuffix + facebook.getId() + postsData.getString("id") + "');\"/></a>");
                    writer.write("      </span>");
                } else {
                    if (isALinkLike) {//If the post is a link -> it has link and name
                        if (linkLike.has("link") && linkLike.has("picture")) {
                            writer.write("      <span id=\"img" +
                                    tabSuffix + facebook.getId() + postsData.getString("id") +
                                    "\" style=\"width: 250px; height: 250px; border: thick #666666; overflow: hidden; position: relative;\">");
                            writer.write("      <a href=\"" + linkLike.getString("link") + "\" target=\"_blank\">" +
                                    "<img src=\"" + picture +
                                    "\" style=\"position: relative;\" onerror=\"this.src ='" +
                                    picture.replace("_n.", "_s.") + "'\" onload=\"imageLoad(" +
                                    "this, 'img" + tabSuffix + facebook.getId() +
                                    postsData.getString("id") + "');\"/></a>");
                            writer.write("      </span>");
                        }
                    } else if (postType.equals("link")) {//If the post is a link -> it has link and name
                        if (postsData.has("name") && postsData.has("link")) {
                            writer.write("      <span id=\"img" +
                                    tabSuffix + facebook.getId() + postsData.getString("id") +
                                    "\" style=\"width: 250px; height: 250px; border: thick #666666; overflow: hidden; position: relative;\">");
                            writer.write("      <a href=\"" + postsData.getString("link") +
                                    "\" target=\"_blank\">" + "<img src=\"" + picture +
                                    "\" style=\"position: relative;\" onerror=\"this.src ='" +
                                    picture.replace("_n.", "_s.") + "'\" onerror=\"this.src ='" +
                                    picture.replace("_n.", "_s.") + "'\" onload=\"imageLoad(" +
                                    "this, 'img" + tabSuffix + facebook.getId() + postsData.getString("id") +
                                    "');\"/></a>");
                            writer.write("      </span>");
                        }
                    } else {
                        writer.write("      <span id=\"img" +
                                tabSuffix + facebook.getId() + postsData.getString("id") +
                                "\" style=\"width: 250px; height: 250px; border: thick #666666; overflow: hidden; position: relative;\">");
                        writer.write("      <a href=\"#\" onclick=\"showDialog('" +
                                renderURL.setMode("displayPicture").
                                        setParameter("pictureUrl", URLEncoder.encode(picture, "UTF-8")) +
                                "','Picture from " + postsData.getJSONObject("from").getString("name") +
                                "'); return false;\"><img src=\"" + picture +
                                "\" style=\"position: relative;\" onerror=\"this.src ='" +
                                picture.replace("_n.", "_s.") + "'\" onload=\"imageLoad(" +
                                "this, 'img" + tabSuffix + facebook.getId() + postsData.getString("id") +
                                "');\"/></a>");
                        writer.write("      </span>");
                    }
                }

                writer.write("<p class=\"imgtitle\">");
                if (postsData.has("link") && postsData.has("name")) {
                    writer.write("<a href=\"" + postsData.getString("link") + "\" target=\"_blank\">" +
                            postsData.getString("name") + "</a>");
                } else if (isALinkLike) {
                    if (linkLike.has("link")) {
                        writer.write("<a href=\"" + linkLike.getString("link") + "\" target=\"_blank\">" +
                                linkLike.getString("name") + "</a>");
                    }
                } else if (isAPostLike) {
                    if (postLike.has("link")) {
                        writer.write("<a href=\"" + postLike.getString("link") + "\" target=\"_blank\">" +
                                postLike.getString("name") + "</a>");
                    }
                } else {
                    writer.write("&nbsp;");
                }
                writer.write("</p>");
                writer.write("<p class =\"imgdesc\">");
                if (isAPhotoLike) {
                    writer.write(photoLike.has("name") ? photoLike.getString("name") : "&nbsp;");
                } else if (isALinkLike) {
                    writer.write(linkLike.has("message") ? linkLike.getString("message") : "&nbsp;");
                } else {
                    writer.write(postsData.has("description") ? postsData.getString("description") : "&nbsp;");
                }
                writer.write("</p>");

                if (!caption.isEmpty()) {
                    writer.write("<p class=\"imgfoot\">");
                    writer.write(caption);
                    writer.write("</p>");
                }
                writer.write("<div class=\"clear\"></div>");
                writer.write("</div>");
            }
            //Picture if exists, end
            //Comments,start
            if (postsData.has("comments")) {
                if (postsData.getJSONObject("comments").has("data")) {
                    JSONArray comments = postsData.getJSONObject("comments").getJSONArray("data");
                    if (comments.length() > 0) {
                        writer.write("<ul id=\"" + facebook.getId() +
                                postsData.getString("id") + tabSuffix + "/comments\">");
                    }
                    for (int k = 0; k < comments.length(); k++) {
                        if (k == 5) {
                            break;
                        }
                        writer.write("<li>");
                        writer.write("<a href=\"#\" title=\"" +
                                paramRequest.getLocaleString("viewProfile") +
                                "\" onclick=\"showDialog('" +
                                renderURL.setMode("fullProfile").
                                        setParameter("type", "noType").
                                        setParameter("id", comments.getJSONObject(k).getJSONObject("from").getString("id")) +
                                "','" + comments.getJSONObject(k).getJSONObject("from").getString("name") +
                                "'); return false;\"><img src=\"http://graph.facebook.com/" +
                                comments.getJSONObject(k).getJSONObject("from").getLong("id") +
                                "/picture?width=30&height=30\" width=\"30\" height=\"30\"/></a>");
                        writer.write("<p style=\"max-width: 390px; overflow: scroll\";>");
                        writer.write("<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                                "\" onclick=\"showDialog('" +
                                renderURL.setMode("fullProfile").
                                        setParameter("type", "noType").
                                        setParameter("id", comments.getJSONObject(k).getJSONObject("from").getString("id")) +
                                "','" + comments.getJSONObject(k).getJSONObject("from").getString("name") +
                                "'); return false;\">" + comments.getJSONObject(k).getJSONObject("from").getString("name") +
                                "</a>:");
                        writer.write(comments.getJSONObject(k).getString("message").replace("\n", "</br>"));
                        writer.write("</br></p>");

                        Date commentTime = formatter.parse(comments.getJSONObject(k).getString("created_time"));

                        writer.write("<p class=\"timelinedate\">");
                        //writer.write("<span id=\"" +facebook.getId() + comments.getJSONObject(k).getString("id") + "_" + postsData.getString("id") + "\" dojoType=\"dojox.layout.ContentPane\">");
                        writer.write("<span style=\"width:150px;\" dojoType=\"dojox.layout.ContentPane\">");

                        //writer.write("<em>" + facebookHumanFriendlyDate(commentTime, paramRequest) + "</em>");
                        //out.write("<em title=\"" + facebookHumanFriendlyDate(commentTime, paramRequest) +"\">&nbsp;</em>");
                        writer.write("" + df.format(commentTime) +"&nbsp;");
                        if (comments.getJSONObject(k).has("like_count")) {
                            writer.write("<strong>");
                            writer.write("<span>Likes:</span> " + comments.getJSONObject(k).getInt("like_count"));
                            writer.write("</strong>");
                        }
                        writer.write("</span>");
                        writer.write("</p>");
                        writer.write("</li>");
                    }

                    if (postsData.getJSONObject("comments").has("paging")) {//Link to get more comments
                        JSONObject pagingComments = postsData.getJSONObject("comments").getJSONObject("paging");
                        if (pagingComments.has("next") && pagingComments.has("cursors")) {
                            writer.write("<li class=\"timelinemore\">");
                            //writer.write("<div id=\"" + facebook.getId() + postsData.getString("id") + tabSuffix + "/comments\" dojoType=\"dojox.layout.ContentPane\">");
                            SWBResourceURL commentsURL = paramRequest.getRenderUrl().
                                    setMode("moreComments").
                                    setParameter("suri", request.getParameter("suri")).
                                    setParameter("postId", postsData.getString("id"));
                            commentsURL = commentsURL.setParameter("after", pagingComments.getJSONObject("cursors").getString("after")).
                                    setParameter("currentTab", tabSuffix);
                            writer.write("<label><a href=\"#\" onclick=\"appendHtmlAt('" +
                                    commentsURL + "','" + facebook.getId() +
                                    postsData.getString("id") + tabSuffix +
                                    "/comments', 'bottom');try{this.parentNode.parentNode.parentNode.removeChild( this.parentNode.parentNode );}catch(noe){}; return false;\"><span>+</span>" +
                                    paramRequest.getLocaleString("moreComments") +
                                    "</a></label>");
                            //writer.write("</div>"); 
                            writer.write("</li>");
                        }
                    }
                    if (comments.length() > 0) {
                        writer.write("</ul>");
                    }
                }
            }

            //writer.write("<span id=\"" + facebook.getId() + postsData.getString("id") + tabSuffix + "/comments\" dojoType=\"dojox.layout.ContentPane\">");
            //writer.write("</span>"); 
            //Comments, end
            writer.write("<div class=\"clear\"></div>");
            Date postTime = null;
            if (postsData.has("created_time")) {
                postTime = formatter.parse(postsData.getString("created_time"));
            }

            writer.write("<div class=\"timelineresume\" dojoType=\"dijit.layout.ContentPane\">");
            if (postsData.has("icon") && !postsData.isNull("icon")) {
                writer.write("<img src=\"" + postsData.getString("icon") + "\"/>");
            }
            writer.write("<span class=\"inline\" id=\"" +
                    facebook.getId() + postsData.getString("id") +
                    FacebookWall.INFORMATION + tabSuffix +
                    "\" dojoType=\"dojox.layout.ContentPane\">");
            //writer.write("<em>" + facebookHumanFriendlyDate(postTime, paramRequest) + "</em>");
            writer.write(postTime != null ? df.format(postTime) : "" +"&nbsp;");
            boolean iLikedPost = false;
            writer.write("<strong><span> Likes: </span>");
            if (postsData.has("likes")) {
                JSONArray likes = postsData.getJSONObject("likes").getJSONArray("data");
                int postLikes = 0;
                if (postsData.getJSONObject("likes").has("summary") && !postsData.getJSONObject("likes").isNull("summary")) {
                    if (!postsData.getJSONObject("likes").getJSONObject("summary").has("total_count")) {
                        postLikes = postsData.getJSONObject("likes").getJSONObject("summary").getInt("total_count");
                    }
                }

                writer.write(String.valueOf(postLikes));
                //Como puede tardar encontrar si el usuario ha dado "like" a un post, se va a eliminar por v2.3 API Facebook
//                for (int k = 0; k < likes.length(); k++) {
//                    if (likes.getJSONObject(k).getString("id").equals(facebook.getFacebookUserId())) {
//                        //My User id is in 'the likes' of this post
//                        iLikedPost = true;
//                    }
//                }
//                if ((likes.length() < postLikes) && (iLikedPost == false)) {
//                    HashMap<String, String> params = new HashMap<String, String>(4);
//                    params.put("access_token", facebook.getAccessToken());
//                    params.put("limit", "50");
//                    String fbLike = null;
//
//                    try {
//                        fbLike = getRequest(params, Facebook.FACEBOOKGRAPH + postsData.getString("id") + "/likes",
//                                Facebook.USER_AGENT);
//                        JSONObject likeResp = new JSONObject(fbLike);
//                        if (likeResp.has("data")) {
//                            JSONArray likesArray = likeResp.getJSONArray("data");
//                            for (int j = 0; j < likesArray.length(); j++) {
//                                if (likesArray.getJSONObject(j).getString("id").equals(facebook.getUserId())) {
//                                    iLikedPost = true;
//                                    break;
//                                }
//                            }
//                        }
//                    } catch (Exception e) {
//                        FacebookWall.log.error("Error getting likes information for Facebook post " +
//                                postsData.getString("id"), e);
//                    }
//                }
            } else {
                writer.write("0");
            }
            writer.write("</strong>");
            writer.write("</span>");

            //Show like/unlike and reply (comment)
            JSONArray actions = postsData.has("actions") ? postsData.getJSONArray("actions") : null;
            if (actions != null && actions.length() > 0) {//Available actions for the post
                for (int i = 0; i < actions.length(); i++) {
                    if (actions.getJSONObject(i).getString("name").equals("Comment")) {//I can comment
                        if (userCanRespondMsg || userCanDoEveryting) {
                            writer.write("   <span class=\"inline\" id=\"" +
                                    facebook.getId() + postsData.getString("id") + FacebookWall.REPLY + tabSuffix +
                                    "\" dojoType=\"dojox.layout.ContentPane\">");
                            writer.write(" <a class=\"answ\" href=\"#\" title=\"Responder\" onclick=\"showDialog('" +
                                    renderURL.setMode("replyPost").setParameter("postID", postsData.getString("id")) +
                                    "','Responder a " + postsData.getJSONObject("from").getString("name") +
                                    "');return false;\"></a>");
                            writer.write("   </span>");
                        }

                        if (linkLike != null) {
                            /*writer.write("   <span class=\"inline\" id=\"" + facebook.getId() + postsData.getString("id") + REPLY + tabSuffix + "\" dojoType=\"dojox.layout.ContentPane\">");
                             writer.write(" <a href=\"\" onclick=\"showDialog('" + renderURL.setMode("replyPost").setParameter("postID", linkLike.getString("id")) + "','Responder a " + postsData.getJSONObject("from").getString("name") + "');return false;\"><span>Reply</span></a>  ");
                             writer.write("   </span>");*/
                        }

                        ///////////////////////If I can post I can Classify it to answer it later
                        if (userCanRetopicMsg || userCanDoEveryting) {
                            PostIn post = PostIn.getPostInbySocialMsgId(model, postsData.getString("id"));
                            writer.write("   <span class=\"inline\" id=\"" +
                                    facebook.getId() + postsData.getString("id") + FacebookWall.TOPIC + tabSuffix +
                                    "\" dojoType=\"dojox.layout.ContentPane\">");
                            if (userCanRetopicMsg || userCanDoEveryting) {
                                if (post != null) {
                                    String socialT = "";
                                    if (post.getSocialTopic() != null) {
                                        socialT = post.getSocialTopic().getTitle();
                                    }
                                    SWBResourceURL clasifybyTopic = renderURL.setMode("doReclassifyTopic").
                                            setCallMethod(SWBResourceURL.Call_DIRECT).
                                            setParameter("id", postsData.getString("id")).
                                            setParameter("postUri", post.getURI()).
                                            setParameter("currentTab", tabSuffix);
                                    writer.write("<a href=\"#\" class=\"clasifica\" title=\"" +
                                            paramRequest.getLocaleString("reclassify") +
                                            "\" onclick=\"showDialog('" + clasifybyTopic + "','" +
                                            paramRequest.getLocaleString("reclassify") +
                                            " post'); return false;\"></a>");
                                } else {
                                    SWBResourceURL clasifybyTopic = renderURL.setMode("doShowTopic").
                                            setCallMethod(SWBResourceURL.Call_DIRECT).
                                            setParameter("id", postsData.getString("id")).
                                            setParameter("currentTab", tabSuffix);
                                    writer.write("<a href=\"#\" class=\"clasifica\" title=\"" +
                                            paramRequest.getLocaleString("classify") +
                                            "\" onclick=\"showDialog('" + clasifybyTopic + "','" +
                                            paramRequest.getLocaleString("classify") +
                                            " Post'); return false;\"></a>");
                                }
                            } else {
                                writer.write("&nbsp;");
                            }
                            writer.write("   </span>");
                        }
//                    } else if (actions.getJSONObject(i).getString("name").equals("Like")) {//I can like
//                        writer.write("   <span class=\"inline\" id=\"" + facebook.getId() +
//                                postsData.getString("id") + FacebookWall.LIKE + tabSuffix +
//                                "\" dojoType=\"dojox.layout.ContentPane\">");
//                        if (iLikedPost) {
//                            writer.write(" <a href=\"#\" title=\"" + paramRequest.getLocaleString("undoLike") +
//                                    "\" class=\"nolike\" onclick=\"postSocialHtml('" +
//                                    actionURL.setAction("doUnlike").
//                                            setParameter("postID", postsData.getString("id")).
//                                            setParameter("currentTab", tabSuffix) + "','" +
//                                    facebook.getId() + postsData.getString("id") + FacebookWall.INFORMATION +
//                                    tabSuffix + "');return false;" + "\"></a>");
//                        } else {
//                            writer.write(" <a href=\"#\" title=\"" + paramRequest.getLocaleString("like") +
//                                    "\" class=\"like\" onclick=\"postSocialHtml('" +
//                                    actionURL.setAction("doLike").
//                                            setParameter("postID", postsData.getString("id")).
//                                            setParameter("currentTab", tabSuffix) + "','" +
//                                    facebook.getId() + postsData.getString("id") + FacebookWall.INFORMATION +
//                                    tabSuffix + "');return false;" + "\"></a>");
//                        }
//                        writer.write("   </span>");
//                    } else {//Other unknown action
                        //writer.write("other:" + actions.getJSONObject(i).getString("name"));
                    }
                }
                String postUser = postsData.getJSONObject("from").getString("id");
                if (postUser.equals(facebook.getFacebookUserId()) && userCanRemoveMsg) {
                    writer.write("   <span class=\"inline\" id=\"" +
                            facebook.getId() + postsData.getString("id") + "REMOVE" + tabSuffix +
                            "\" dojoType=\"dojox.layout.ContentPane\">");
                    writer.write("      <a title=\"" + "Eliminar Mensaje" +
                            "\" href=\"#\" class=\"eliminarYoutube\" onclick=\"if(confirm('" +
                            "¿Deseas eliminar el mensaje?" +
                            "')){try{dojo.byId(this.parentNode).innerHTML = '<img src=" +
                            SWBPlatform.getContextPath() +
                            "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" +
                            paramRequest.getActionUrl().setAction("deleteMessage").
                                    setParameter("id", postsData.getString("id")).
                                    setParameter("currentTab", tabSuffix).
                                    setParameter("suri", request.getParameter("suri")) +
                            "','" + facebook.getId() + postsData.getString("id") + "REMOVE" +
                            tabSuffix + "');} return false;\"></a>");
                    writer.write("   </span>");
                }
            }
            writer.write("  </div>");
            writer.write("</div>");
        } catch (Exception e) {
            FacebookWall.log.error("Error printing post:", e);
            e.printStackTrace();
        }
    }

    public static String printPicture(Writer writer, JSONObject postsData, JSONObject commentsData,
            JSONObject profileData, HttpServletRequest request, SWBParamRequest paramRequest,
            String tabSuffix, Facebook facebook, SWBModel model, boolean userCanDoEverything,
            boolean userCanRetopicMsg, boolean userCanRespondMsg, boolean userCanRemoveMsg) {
        
        String createdTime = "";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm a", new Locale("es", "MX"));
        try {
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            actionURL.setParameter("suri", request.getParameter("suri"));

            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            renderURL.setParameter("suri", request.getParameter("suri"));

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
            String userId = "";
            String postId = postsData.getString("id");
            if (profileData.has("id")) {//Al parecer todos los objetos tendrian esta propiedad
                userId = profileData.getString("id");
            } else if (profileData.has("page_id")) {//Esto aplicaria para v2.0 y anteriores
                userId = profileData.getString("page_id");
            } else {
                return null;
            }

            //TODO: id = A 64-bit int representing the user, group, page, event, or application ID
            JSONArray media = postsData.getJSONArray("images"); //postsData.getJSONObject("attachment").getJSONArray("media");

            writer.write("<div class=\"timeline timelinefacebook\" id=\"" +
                    facebook.getId() + userId + tabSuffix + "\">");
            writer.write("<p>");
            writer.write("      <a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                    "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").
                            setParameter("type", "noType").setParameter("id", userId + "") +
                    "','" + profileData.getString("name") + "'); return false;\">" +
                    profileData.getString("name") + "</a>");
            writer.write("</p>");
            writer.write("<div class=\"timelineusr\">");
            writer.write("      <a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                    "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").
                            setParameter("type", "noType").setParameter("id", userId + "") +
                    "','" + profileData.getString("name") +
                    "'); return false;\"><img src=\"http://graph.facebook.com/" + userId + "/picture\"/></a>");
            if (postsData.has("name_tags") && !postsData.isNull("name_tags") &&
                    postsData.getJSONObject("name_tags").isNull("data")) {
                writer.write(getHtmlForTags(postsData.getJSONObject("name_tags").getJSONArray("data"),
                        postsData.getString("name"), renderURL));
            } else if (postsData.has("name")) {
                writer.write(postsData.getString("name"));
            }
            if (postsData.has("type") && postsData.getString("type").equalsIgnoreCase("photo")) {//Photo posted
                writer.write(postsData.getString("message"));
                //writer.write(":Photos posted");
            } else if (postsData.has("description_tags")) {//Tagged photo
                if (!postsData.isNull("description_tags")) {//Users tagged in story
                    JSONObject descriptionData = postsData.optJSONObject("description_tags");
                    try {
                        if (descriptionData != null) {
                            writer.write(getTagsFromPost(postsData.getJSONObject("description_tags"),
                                    postsData.getString("description"), renderURL));
                        } else {
                            if (postsData.getJSONArray("description_tags").length() > 0) {
                                writer.write(getTagsFromPostArray(
                                        postsData.getJSONArray("description_tags").getJSONArray(0).getJSONObject(0),
                                        postsData.getString("description"),
                                        renderURL));
                            }
                        }
                    } catch (JSONException je) {
                        FacebookWall.log.error("Problem looking for description tags");
                    }
                }
                //writer.write(":Tagged photo");
//            } else if (postsData.getInt("type") == 373) {//Cover update                
//                writer.write(profileData.getString("name") + " has updated cover photo");
                //writer.write(":updated cover photo");
            } else {
                writer.write("&nbsp;");
            }
            if (postsData.has("attachment")) {
                if (!postsData.getJSONObject("attachment").isNull("fb_object_type") &&
                        postsData.getJSONObject("attachment").getString("fb_object_type").equals("album")) {
                    if (!postsData.getJSONObject("attachment").getString("name").isEmpty()) {
                        writer.write(profileData.getString("name") + " has added " + media.length() +
                                " photos to the album " + postsData.getJSONObject("attachment").getString("name"));
                    }
                }
            }
            writer.write("</div>");
            writer.write("<div class=\"timelineimg\">");
            for (int k = 0; k < 1; k++) {
                writer.write("      <span id=\"img" + facebook.getId() + postId +
                        "\" style=\"width: 150px; height: 150px; border: thick #666666; overflow: hidden; position: relative;\">");
                writer.write("      <a href=\"#\" onclick=\"showDialog('" +
                        renderURL.setMode("displayPicture").
                                setParameter("pictureUrl", media.getJSONObject(k).getString("source").replace("_s.", "_n.")) +
                        "','Picture from " + "" + "'); return false;\"><img src=\"" +
                        media.getJSONObject(k).getString("source") +
                        "\" style=\"position: relative;\" onload=\"imageLoad(this, 'img" +
                        facebook.getId() + postId + "');\"/></a>");
                writer.write("      </span>");
            }

            writer.write("<p class=\"imgtitle\">&nbsp;</p>");
            writer.write("<p class=\"imgdesc\">");
            writer.write(postsData.isNull("description") ? "" : postsData.getString("description"));
            writer.write("</p>");
            writer.write("<p class=\"imgfoot\">");
            writer.write("&nbsp;");
            writer.write("</p>");
            writer.write("<div class=\"clear\"></div>");
            writer.write("</div>");

            //Comments,start
            if (commentsData != null && commentsData.has("data") && commentsData.getJSONArray("data").length() > 0) {
                JSONArray comments = commentsData.getJSONArray("data");
                writer.write("<ul id=\"" + facebook.getId() + postId + tabSuffix + "/comments\">");
                for (int k = 0; k < comments.length(); k++) {
                    JSONObject commentProfile = comments.getJSONObject(k).getJSONObject("from");
                    writer.write("<li>");
                    writer.write("<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                            "\" onclick=\"showDialog('" +
                            renderURL.setMode("fullProfile").setParameter("type", "noType").
                                    setParameter("id", commentProfile.getString("id") + "") + "','" +
                            commentProfile.getString("name") + "'); return false;\"><img src=\"http://graph.facebook.com/" +
                            commentProfile.getString("id") + "/picture?width=30&height=30\" width=\"30\" height=\"30\"/></a>");

                    writer.write("<p style=\"max-width: 390px; overflow: scroll\";>");
                    writer.write("      <a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                            "\" onclick=\"showDialog('" +
                            renderURL.setMode("fullProfile").setParameter("type", "noType").
                                    setParameter("id", commentProfile.getLong("id") + "") + "','" +
                            commentProfile.getString("name") + "'); return false;\">" +
                            commentProfile.getString("name") + "</a>:");
                    writer.write(comments.getJSONObject(k).getString("message").replace("\n", "</br>") + "</br>");
                    writer.write("</p>");

                    Date commentTime = formatter.parse(comments.getJSONObject(k).getString("created_time"));

                    writer.write("<p class=\"timelinedate\">");
                    //writer.write("<span id=\"" + comments.getJSONObject(k).getString("id") + "\" dojoType=\"dojox.layout.ContentPane\">");
                    writer.write("<span style=\"width:150px;\" dojoType=\"dojox.layout.ContentPane\">");
                    //writer.write("<em>" + facebookHumanFriendlyDate(commentTime, paramRequest) + "</em>");
                    writer.write(df.format(commentTime) + "&nbsp;");
                    //writer.write("<a href=\"\" onMouseOver=\"dijit.Tooltip.defaultPosition=['above', 'below']\" id=\"TooltipButton\" onclick=\"return false;\"> LIKE/UNLIKE</a>");
                    //writer.write("<div class=\"dijitHidden\"><span data-dojo-type=\"dijit.Tooltip\" data-dojo-props=\"connectId:'TooltipButton'\">I am <strong>above</strong> the button</span></div>");
                    if (comments.getJSONObject(k).has("like_count")) {
                        writer.write("<strong>");
                        writer.write("<span>Likes:</span> " + comments.getJSONObject(k).getInt("like_count"));
                        writer.write("</strong>");
                    }
                    writer.write("</span>");

                    writer.write("</p>");
                    writer.write("</li>");
                }

                if (commentsData.has("paging")) {//Link to get more comments
                    JSONObject pagingComments = commentsData.getJSONObject("paging");

                    if (pagingComments.has("next") && pagingComments.has("cursors")) {
                        writer.write("<li class=\"timelinemore\">");
                        SWBResourceURL commentsURL = paramRequest.getRenderUrl().setMode("moreComments").
                                setParameter("suri", request.getParameter("suri")).
                                setParameter("postId", postId);
                        commentsURL = commentsURL.setParameter("after",
                                        pagingComments.getJSONObject("cursors").getString("after")).
                                setParameter("currentTab", tabSuffix);
                        writer.write("<label><a href=\"#\" onclick=\"appendHtmlAt('" + commentsURL +
                                "','" + facebook.getId() + postId + tabSuffix +
                                "/comments', 'bottom');try{this.parentNode.parentNode.parentNode.removeChild( this.parentNode.parentNode );}catch(noe){}; return false;\"><span>+</span>" +
                                paramRequest.getLocaleString("moreComments") + "</a></a></label>");
                        writer.write("</li>");
                    }
                }
                writer.write("   </ul>");
            }
            
//            Date postTime = new java.util.Date((long) postsData.getString("created_time") * 1000);
            createdTime = df.format(formatter.parse(postsData.getString("created_time")));
            boolean canLike = true;
            //JSONObject likeInfo = null;
            writer.write("<div class=\"timelineresume\" dojoType=\"dijit.layout.ContentPane\">");
            writer.write("   <span class=\"inline\" id=\"" + facebook.getId() +
                    postId + FacebookWall.INFORMATION + FacebookWall.PICTURES_TAB +
                    "\" dojoType=\"dojox.layout.ContentPane\">");
            //writer.write("<em>" + facebookHumanFriendlyDate(postTime, paramRequest) + "</em>");
            writer.write(createdTime + "&nbsp;");

            //Hacer peticion para obtener informacion de likes de la foto
            HashMap<String, String> params = new HashMap<String, String>(2);
            params.put("access_token", facebook.getAccessToken());
            params.put("summary", "true");
            JSONObject postLikes = null;
            try {
                String fbResponse = postRequest(params,
                        Facebook.FACEBOOKGRAPH + postId + "/likes",
                        Facebook.USER_AGENT,
                        "GET");
                postLikes = new JSONObject(fbResponse);
            } catch (Exception e) {
                FacebookWall.log.error("Error getting comments of post",  e);
            }
            
            if (postLikes != null && postLikes.has("summary")) {
                writer.write("<strong>");
                writer.write("<span>Likes:</span> " + postLikes.getJSONObject("summary").getLong("total_count"));
                writer.write("</strong>");
                writer.write("</span>");
                //TODO: Preguntar que debe pasar ahora que no se tiene este dato de facebook
//                if (!likeInfo.isNull("can_like")) {
//                    if (likeInfo.getBoolean("can_like")) {
//                        canLike = true;
//                    }
//                }
            } else {
                writer.write("   </span>");
            }

//            if (postsData.has("comment_info")) {
//                JSONObject comments = postsData.getJSONObject("comment_info");
//
//                if (comments.getBoolean("can_comment")) {
            if (userCanRespondMsg || userCanDoEverything) {
                writer.write("   <span class=\"inline\" id=\"" +
                        facebook.getId() + postId + FacebookWall.REPLY + tabSuffix +
                        "\" dojoType=\"dojox.layout.ContentPane\">");
                writer.write(" <a class=\"answ\" title=\"Responder\" href=\"#\" onclick=\"showDialog('" +
                        renderURL.setMode("replyPost").setParameter("postID", postId) +
                        "','Responder a " + profileData.getString("name") + "');return false;\"></a>  ");
                writer.write("   </span>");
            }

            if (userCanRetopicMsg || userCanDoEverything) {
                ///////////////////////If I can post I can Classify it to answer it later
                PostIn post = PostIn.getPostInbySocialMsgId(model, postId);
                writer.write("   <span class=\"inline\" id=\"" +
                        facebook.getId() + postId + FacebookWall.TOPIC + tabSuffix +
                        "\" dojoType=\"dojox.layout.ContentPane\">");
                if (post != null) {
                    String socialT = "";
                    if (post.getSocialTopic() != null) {
                        socialT = post.getSocialTopic().getTitle();
                    }
                    SWBResourceURL clasifybyTopic = renderURL.setMode("doReclassifyTopic").
                            setCallMethod(SWBResourceURL.Call_DIRECT).
                            setParameter("id", postId).
                            setParameter("postUri", post.getURI()).
                            setParameter("currentTab", tabSuffix);
                    writer.write("<a href=\"#\" class=\"clasifica\" title=\"" +
                            paramRequest.getLocaleString("reclassify") + "\" onclick=\"showDialog('" +
                            clasifybyTopic + "','" + paramRequest.getLocaleString("reclassify") +
                            " post'); return false;\"></a>");
                } else {
                    SWBResourceURL clasifybyTopic = renderURL.setMode("doShowTopic").
                            setCallMethod(SWBResourceURL.Call_DIRECT).
                            setParameter("id", postId).
                            setParameter("currentTab", tabSuffix);
                    writer.write("<a href=\"#\" class=\"clasifica\" title=\"" +
                            paramRequest.getLocaleString("classify") + "\" onclick=\"showDialog('" +
                            clasifybyTopic + "','" + paramRequest.getLocaleString("classify") +
                            " Post'); return false;\"></a>");
                }
                writer.write("   </span>");
            }
//                }
//            }

//            if (canLike) {
//                boolean userLikedIt = false;
//                if (postLikes.has("data") && postLikes.getJSONArray("data").length() > 0) {
//                    JSONArray likesData = postLikes.getJSONArray("data");
//                    for (int j = 0; j < likesData.length(); j++) {
//                        if (likesData.getJSONObject(j).getString("id").equals(userId)) {
//                            userLikedIt = true;
//                            break;
//                        }
//                    }
//                }
//                writer.write("   <span class=\"inline\" id=\"" +
//                        facebook.getId() + postId + FacebookWall.LIKE + FacebookWall.PICTURES_TAB +
//                        "\" dojoType=\"dojox.layout.ContentPane\">");
//                if (userLikedIt) {
//                    writer.write(" <a href=\"#\" title=\"" + paramRequest.getLocaleString("undoLike") +
//                            "\" class=\"nolike\" onclick=\"postSocialHtml('" +
//                            actionURL.setAction("doUnlike").setParameter("postID", postId).
//                                    setParameter("currentTab", FacebookWall.PICTURES_TAB) + "','" +
//                            facebook.getId() + postId + FacebookWall.INFORMATION + FacebookWall.PICTURES_TAB +
//                            "');return false;" + "\"></a>");
//                } else {
//                    writer.write(" <a href=\"#\" title=\"" + paramRequest.getLocaleString("like") +
//                            "\" class=\"like\" onclick=\"postSocialHtml('" +
//                            actionURL.setAction("doLike").setParameter("postID", postId).
//                                    setParameter("currentTab", FacebookWall.PICTURES_TAB) + "','" +
//                            facebook.getId() + postId + FacebookWall.INFORMATION + FacebookWall.PICTURES_TAB +
//                            "');return false;" + "\"></a>");
//                }
//                writer.write("   </span>");
//            }
            
            //String postUser = String.valueOf(id);
            if (userId.equals(facebook.getFacebookUserId()) && userCanRemoveMsg) {
                writer.write("   <span class=\"inline\" id=\"" + facebook.getId() + postId +
                        "REMOVE" + tabSuffix + "\" dojoType=\"dojox.layout.ContentPane\">");
                writer.write("      <a title=\"" + "Eliminar Mensaje" +"\" href=\"#\" class=\"eliminarYoutube\" onclick=\"if(confirm('" +
                        "¿Deseas eliminar la foto?" + "')){try{dojo.byId(this.parentNode).innerHTML = '<img src=" +
                        SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" +
                        paramRequest.getActionUrl().setAction("deleteMessage").
                                setParameter("id", postId).
                                setParameter("currentTab", tabSuffix).
                                setParameter("suri", request.getParameter("suri")) +
                        "','" + facebook.getId() + postId + "REMOVE" + tabSuffix +
                        "');} return false;\"></a>");
                writer.write("   </span>");
            }
            writer.write("   </div>");
            writer.write("   </div>");
        } catch (Exception e) {
            FacebookWall.log.error("ERROR printing Picture", e);
        }
        return createdTime;
    }

    /**
     * Genera el codigo HTML para representar un video y sus comentarios asociados publicados en Facebook
     * @param writer
     * @param postsData
     * @param commentsData
     * @param profileData
     * @param request
     * @param paramRequest
     * @param tabSuffix
     * @param facebook
     * @param model
     * @param userCanDoEverything
     * @param userCanRetopicMsg
     * @param userCanRespongMsg
     * @param userCanRemoveMsg
     * @return un {@code String} con el codigo HTML necesario para representar al video con
     * sus comentarios asociados, o {@literal null} si el video recuperado aun esta en procesamiento o no esta listo
     */
    public static String doPrintVideo(Writer writer, JSONObject postsData, JSONObject commentsData,
            JSONObject profileData, HttpServletRequest request, SWBParamRequest paramRequest,
            String tabSuffix, Facebook facebook, SWBModel model, boolean userCanDoEverything,
            boolean userCanRetopicMsg, boolean userCanRespongMsg, boolean userCanRemoveMsg) {
        
        String createdTime = "";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm a", new Locale("es", "MX"));
        try {
            //Only print published videos
            if (postsData.has("status") &&
                    !postsData.getJSONObject("status").getString("video_status").equalsIgnoreCase("ready")) {
                return null;
            }

            SWBResourceURL actionURL = paramRequest.getActionUrl();
            actionURL.setParameter("suri", request.getParameter("suri"));

            SWBResourceURL renderURL = paramRequest.getRenderUrl();
            renderURL.setParameter("suri", request.getParameter("suri"));

            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSz");
            formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
            String userId = null;
            String postId = postsData.getString("id");
            if (profileData.has("id")) {
                userId = profileData.getString("id");
            } else if (profileData.has("page_id")) {
                userId = profileData.getString("page_id");
            } else {
                return null;
            }

            JSONArray media = null;            
            writer.write("<div class=\"timeline timelinefacebook\" id=\"" +
                    facebook.getId() + postId + tabSuffix + "\">");
            writer.write("<p>");
            writer.write("      <a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                    "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").
                            setParameter("type", "noType").setParameter("id", userId + "") +
                    "','" + profileData.getString("name") + "'); return false;\">" +
                    profileData.getString("name") + "</a>");
            writer.write("</p>");

            writer.write("<div class=\"timelineusr\">");
            writer.write("      <a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                    "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").
                            setParameter("type", "noType").setParameter("id", userId + "") +
                    "','" + profileData.getString("name") +
                    "'); return false;\"><img src=\"http://graph.facebook.com/" +
                    userId + "/picture\"/></a>");

            if (postsData.has("name")) {//Video's name posted
                writer.write(postsData.getString("name"));
            } else {
                writer.write("&nbsp;");
            }

//            if (!postsData.isNull("attachment")) {
//                if (!postsData.getJSONObject("attachment").isNull("media")) {
//                    media = postsData.getJSONObject("attachment").getJSONArray("media");
//                }
//            }
//            if (media == null) {
//                return null;
//            }
            writer.write("</div>\n");
            writer.write("<div class=\"timelineimg\">\n");
//            for (int k = 0; k < 1; k++) {
            writer.write("    <span id=\"vid" + tabSuffix + facebook.getId() + postId +
                    "\" style=\"width: 250px; height: 250px; border: thick #666666; overflow: hidden; position: relative;\">\n");
            writer.write("      <a href=\"#\" onclick=\"showDialog('" +
                    renderURL.setMode("displayVideo").setParameter("videoUrl",
                            URLEncoder.encode(postsData.getString("source"), "UTF-8")) +
                    "','Video'); return false;\">\n");
            if (postsData.has("picture")) {
                writer.write("        <img src=\"" + postsData.getString("picture") +
                        "\" style=\"position: relative;\" '\" onload=\"imageLoad(" + "this, 'vid" +
                        tabSuffix + facebook.getId() + postId + "');\"/>\n");
            } else {
                writer.write("Sin imagen\n");
            }
            writer.write("</a></span>\n");
//            }
            writer.write("<p class=\"imgtitle\">&nbsp;</p>\n");

            writer.write("<p class=\"imgdesc\">\n");
            writer.write(postsData.isNull("description") ? "" : postsData.getString("description"));
            writer.write("</p>\n");
            writer.write("<p class=\"imgfoot\">");
            writer.write("&nbsp;");
            writer.write("</p>\n");
            writer.write("<div class=\"clear\"></div>\n");
            writer.write("</div>\n");

            //Comments,start
            if (commentsData != null && commentsData.has("data") && commentsData.getJSONArray("data").length() > 0) {
                JSONArray comments = commentsData.getJSONArray("data");
                writer.write("<ul id=\"" + facebook.getId() + postId + tabSuffix + "/comments\">");
                for (int k = 0; k < comments.length(); k++) {
                    JSONObject commentProfile = comments.getJSONObject(k).getJSONObject("from");
                    writer.write("<li>");
                    writer.write("<a href=\"#\" title=\"" + paramRequest.getLocaleString("viewProfile") +
                            "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").
                                    setParameter("type", "noType").
                                    setParameter("id", commentProfile.getString("id")) +
                            "','" + commentProfile.getString("name") +
                            "'); return false;\"><img src=\"http://graph.facebook.com/" +
                            commentProfile.getString("id") +
                            "/picture?width=30&height=30\" width=\"30\" height=\"30\"/></a>");

                    writer.write("<p style=\"max-width: 390px; overflow: scroll\";>");
                    writer.write("      <a href=\"#\" title=\"" +
                            paramRequest.getLocaleString("viewProfile") +
                            "\" onclick=\"showDialog('" + renderURL.setMode("fullProfile").
                                    setParameter("type", "noType").
                                    setParameter("id", commentProfile.getString("id")) +
                            "','" + commentProfile.getString("name") + "'); return false;\">" +
                            commentProfile.getString("name") + "</a>:");
                    writer.write(comments.getJSONObject(k).getString("message").replace("\n", "</br>"));
                    writer.write("</br></p>");

                    Date commentTime = formatter.parse(comments.getJSONObject(k).getString("created_time"));

                    writer.write("<p class=\"timelinedate\">");
                    //writer.write("<span id=\"" + comments.getJSONObject(k).getString("id") + "\" dojoType=\"dojox.layout.ContentPane\">");
                    writer.write("<span style=\"width:150px;\" dojoType=\"dojox.layout.ContentPane\">");
                    //writer.write("<em>" + facebookHumanFriendlyDate(commentTime, paramRequest) + "</em>");
                    writer.write("" + df.format(commentTime) + "&nbsp;\n");

                    if (comments.getJSONObject(k).has("like_count")) {
                        writer.write("<strong>");
                        writer.write("<span>Likes:</span> " + comments.getJSONObject(k).getLong("like_count"));
                        writer.write("</strong>\n");
                    }
                    writer.write("</span>\n");
                    writer.write("</p>\n");
                    writer.write("</li>\n");
                }

                if (commentsData.has("paging")) {//Link to get more comments
                    JSONObject pagingComments = commentsData.getJSONObject("paging");

                    if (pagingComments.has("next") && pagingComments.has("cursors")) {
                        writer.write("<li class=\"timelinemore\">");
                        SWBResourceURL commentsURL = paramRequest.getRenderUrl().setMode("moreComments").
                                setParameter("suri", request.getParameter("suri")).
                                setParameter("postId", postId);
                        commentsURL = commentsURL.setParameter("after", 
                                    pagingComments.getJSONObject("cursors").getString("after")).
                                setParameter("currentTab", tabSuffix);
                        writer.write("<label><a href=\"#\" onclick=\"appendHtmlAt('" +
                                commentsURL + "','" + facebook.getId() + postId + tabSuffix +
                                "/comments', 'bottom');try{this.parentNode.parentNode.parentNode.removeChild(" +
                                "this.parentNode.parentNode );}catch(noe){}; return false;\"><span>+</span>" +
                                paramRequest.getLocaleString("moreComments") + "</a></a></label>");
                        writer.write("</li>");
                    }
                }
                writer.write("   </ul>");
            }

//            Date postTime = new java.util.Date((long) postsData.getLong("created_time") * 1000);
//            createdTime = String.valueOf(postsData.getLong("created_time"));
            createdTime = df.format(formatter.parse(postsData.getString("created_time")));
            boolean canLike = true;
            writer.write("<div class=\"timelineresume\" dojoType=\"dijit.layout.ContentPane\">");
            writer.write("   <span class=\"inline\" id=\"" + facebook.getId() +
                    postId + FacebookWall.INFORMATION + FacebookWall.VIDEOS_TAB +
                    "\" dojoType=\"dojox.layout.ContentPane\">");
            //writer.write("<em>" + facebookHumanFriendlyDate(postTime, paramRequest) + "</em>");
            writer.write(createdTime + "&nbsp;");
            
            //Hacer peticion para obtener informacion de likes de la foto
            HashMap<String, String> params = new HashMap<String, String>(2);
            params.put("access_token", facebook.getAccessToken());
            params.put("summary", "true");
            JSONObject postLikes = null;
            try {
                String fbResponse = postRequest(params,
                        Facebook.FACEBOOKGRAPH + postId + "/likes",
                        Facebook.USER_AGENT,
                        "GET");
                postLikes = new JSONObject(fbResponse);
            } catch (Exception e) {
                FacebookWall.log.error("Error getting comments of post",  e);
            }
            
            if (postLikes != null && postLikes.has("summary")) {
                writer.write("<strong>");
                writer.write("<span>Likes:</span> " + postLikes.getJSONObject("summary").getLong("total_count"));
                writer.write("</strong>");
                writer.write("</span>");
                //TODO: Preguntar que debe pasar ahora que no se tiene este dato de facebook
//                likeInfo = postsData.getJSONObject("like_info");
//                if (!likeInfo.isNull("can_like")) {
//                    if (likeInfo.getBoolean("can_like")) {
//                        canLike = true;
//                    }
//                }
            } else {
                writer.write("   </span>");
            }

//            if (postsData.has("comment_info")) {
//                JSONObject comments = postsData.getJSONObject("comment_info");
//
//                if (comments.getBoolean("can_comment")) {
            if (userCanRespongMsg || userCanDoEverything) {
                writer.write("   <span class=\"inline\" id=\"" +
                        facebook.getId() + postId + FacebookWall.REPLY + tabSuffix +
                        "\" dojoType=\"dojox.layout.ContentPane\">");
                writer.write(" <a class=\"answ\" href=\"#\" title=\"Responder\" onclick=\"showDialog('" +
                        renderURL.setMode("replyPost").setParameter("postID", postId) +
                        "','Responder a " + profileData.getString("name") + "');return false;\"></a>");
                writer.write("   </span>");
            }
                    
            if (userCanRetopicMsg || userCanDoEverything) {
                PostIn post = PostIn.getPostInbySocialMsgId(model, postId);
                writer.write("   <span class=\"inline\" id=\"" +
                        facebook.getId() + postId + FacebookWall.TOPIC + tabSuffix +
                        "\" dojoType=\"dojox.layout.ContentPane\">");
                if (post != null) {
                    String socialT = "";
                    if (post.getSocialTopic() != null) {
                        socialT = post.getSocialTopic().getTitle();
                    }
                    SWBResourceURL clasifybyTopic = renderURL.setMode("doReclassifyTopic").
                            setCallMethod(SWBResourceURL.Call_DIRECT).
                            setParameter("id", postId).
                            setParameter("postUri", post.getURI()).
                            setParameter("currentTab", tabSuffix);
                    writer.write("<a href=\"#\" class=\"clasifica\" title=\"" +
                            paramRequest.getLocaleString("reclassify") + "\" onclick=\"showDialog('" +
                            clasifybyTopic + "','" + paramRequest.getLocaleString("reclassify") +
                            " post'); return false;\"></a>");
                } else {
                    SWBResourceURL clasifybyTopic = renderURL.setMode("doShowTopic").
                            setCallMethod(SWBResourceURL.Call_DIRECT).
                            setParameter("id", postId).
                            setParameter("currentTab", tabSuffix);
                    writer.write("<a href=\"#\" class=\"clasifica\" title=\"" +
                            paramRequest.getLocaleString("classify") + "\" onclick=\"showDialog('" +
                            clasifybyTopic + "','" + paramRequest.getLocaleString("classify") +
                            " Post'); return false;\"></a>");
                }
                writer.write("   </span>");
            }
//                }
//            }

//            if (canLike) {
//                boolean userLikedIt = false;
//                if (postLikes.has("data") && postLikes.getJSONArray("data").length() > 0) {
//                    JSONArray likesData = postLikes.getJSONArray("data");
//                    for (int j = 0; j < likesData.length(); j++) {
//                        if (likesData.getJSONObject(j).getString("id").equals(userId)) {
//                            userLikedIt = true;
//                            break;
//                        }
//                    }
//                }
//                writer.write("   <span class=\"inline\" id=\"" +
//                        facebook.getId() + postId + FacebookWall.LIKE + FacebookWall.VIDEOS_TAB +
//                        "\" dojoType=\"dojox.layout.ContentPane\">");
//                if (userLikedIt) {
//                    writer.write(" <a href=\"#\" title=\"" + paramRequest.getLocaleString("undoLike") +
//                            "\" class=\"nolike\" onclick=\"postSocialHtml('" +
//                            actionURL.setAction("doUnlike").setParameter("postID", postId).
//                                    setParameter("currentTab", FacebookWall.VIDEOS_TAB) + "','" +
//                            facebook.getId() + postId + FacebookWall.INFORMATION + FacebookWall.VIDEOS_TAB +
//                            "');return false;\"></a>");
//                } else {
//                    writer.write(" <a href=\"#\" title=\"" + paramRequest.getLocaleString("like") +
//                            "\" class=\"like\" onclick=\"postSocialHtml('" +
//                            actionURL.setAction("doLike").setParameter("postID", postId).
//                                    setParameter("currentTab", FacebookWall.VIDEOS_TAB) + "','" +
//                            facebook.getId() + postId + FacebookWall.INFORMATION + FacebookWall.VIDEOS_TAB +
//                            "');return false;\"></a>");
//                }
//                writer.write("   </span>");
//            }
            //String postUser = String.valueOf(userId);
            if (userId.equals(facebook.getFacebookUserId()) && userCanRemoveMsg) {
                writer.write("   <span class=\"inline\" id=\"" + facebook.getId() + postId +
                        "REMOVE" + tabSuffix + "\" dojoType=\"dojox.layout.ContentPane\">");
                writer.write("      <a title=\"" + "Eliminar Mensaje" +"\" href=\"#\" class=\"eliminarYoutube\" onclick=\"if(confirm('" +
                        "¿Deseas eliminar el video?" + "')){try{dojo.byId(this.parentNode).innerHTML = '<img src=" +
                        SWBPlatform.getContextPath() + "/swbadmin/icons/loading.gif>';}catch(noe){} postSocialHtml('" +
                        paramRequest.getActionUrl().setAction("deleteMessage").
                                setParameter("id", postId).
                                setParameter("currentTab", tabSuffix).
                                setParameter("suri", request.getParameter("suri")) +
                        "','" + facebook.getId() + postId + "REMOVE" + tabSuffix +
                        "');} return false;\"></a>");
                writer.write("   </span>");
            }
            writer.write("   </div>");
            writer.write("   </div>");
        } catch (Exception e) {
            FacebookWall.log.error("ERROR printing Video", e);
        }
        return createdTime;
    }

    /**
     * Ejecuta la peticion a Facebook para conocer cuantos posts se han publicados a partir de cierta fecha o momento
     * indicado en el parametro {@code since} de la peticion
     * @param request la peticion HTTP creada por el cliente
     * @param response la respuesta HTTP correspondiente a la peticion recibida
     * @param paramRequest objeto correspondiente a la plataforma SWB que contiene datos complementarios a la peticion
     * @throws SWBResourceException si ocurre algun problema durante la ejecucion del metodo
     * @throws IOException si ocurre un problema de lectura/escritura con la peticion/respuesta
     */
    public void doAskIfNewPosts(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        String currentTab = request.getParameter("currentTab") == null
                            ? "" : request.getParameter("currentTab");
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();
        if (objUri != null) {
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }

        //SI ESTÁ HACIENDO ALGO EL "doGetStreamUser" no debe mostrar el mensaje hasta que termine
        HttpSession session = request.getSession(true);
        if (session == null) {
            return;
        }
        if (session.getAttribute(objUri + currentTab + "since") == null) {
            return;
        }
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("access_token", facebook.getAccessToken());
        params.put("since", session.getAttribute(objUri + currentTab + "since").toString());// since param used to get newer post
        String fbResponse = postRequest(params, "https://graph.facebook.com/me/home",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95",
                "GET");
        String processing = (String) session.getAttribute(objUri + currentTab + "processing");
        if (processing != null && processing.equals("true")) {
            return;//Don't refresh messages
        }
        try {
            JSONObject phraseResp = new JSONObject(fbResponse);
            if (phraseResp.has("data")) {
                JSONArray postsData = phraseResp.getJSONArray("data");
                int postsToRemove = 0;//Remove all te posts that are not relevant:likes a photo, commented on a photo, likes his/her own link, etc

                for (int i = 0; i < postsData.length(); i++) {
                    String postType = postsData.getJSONObject(i).getString("type");

                    if (postType.equals("photo")) {
                        if (postsData.getJSONObject(i).has("application")) {
                            postsToRemove++;
                        }
                    } else if (postType.equals("link") || postType.equals("status")) {
                        String story;
                        if (!postsData.getJSONObject(i).isNull("story")) {
                            story = (!postsData.getJSONObject(i).isNull("story"))
                                    ? postsData.getJSONObject(i).getString("story") : "";
                            if (story.contains("is going to an event") &&
                                    postsData.getJSONObject(i).has("link")) {//If the link is an event
                                postsToRemove++;
                            } else if (story.contains("likes a photo")) {
                                postsToRemove++;
                            } else if (story.contains("likes a link")) {
                                postsToRemove++;
                            } else if (story.contains("likes a status")) {
                                postsToRemove++;
                            } else if (story.contains("commented on")) {
                                postsToRemove++;
                            } else if (story.contains("likes")) {
                                postsToRemove++;
                            } else if (story.contains("is going to")) {
                                postsToRemove++;
                            } else if (story.contains("created an event")) {
                                postsToRemove++;
                            }
                        }
                    }
                }
                //if(postsData.length()>0){
                if ((postsData.length() - postsToRemove) > 0) {
                    if((postsData.length() - postsToRemove) == 1) {
                        out.println("<a href=\"#\" onclick=\"appendHtmlAt('" +
                                renderURL.setMode("doGetStreamUser").
                                        setParameter("currentTab", currentTab) +
                                "','" + objUri + "facebookStream','top'); try{dojo.byId(this.parentNode.id).innerHTML = '';}catch(noe){}; return false;\">" +
                                paramRequest.getLocaleString("youHave") + " <b>1</b> " +
                                paramRequest.getLocaleString("newPostLabel") + "</a>");
                    } else {
                        out.println("<a href=\"#\" onclick=\"appendHtmlAt('" +
                                renderURL.setMode("doGetStreamUser").
                                        setParameter("currentTab", currentTab) +
                                "','" + objUri + "facebookStream','top'); try{dojo.byId(this.parentNode.id).innerHTML = '';}catch(noe){}; return false;\">" +
                                paramRequest.getLocaleString("youHave") +
                                " <b>" + (postsData.length() - postsToRemove) + "</b> " +
                                paramRequest.getLocaleString("newPostsLabel") + "</a>");
                    }
                }
            }
        } catch (JSONException jsone) {
            FacebookWall.log.error("Problemas al parsear respuesta de Facebook al preguntar si hay nuevos posts" + jsone);
        }
        String sinceIdWall = (String) session.getAttribute(objUri + FacebookWall.WALL_TAB + "since");
        if (sinceIdWall != null) {
            params.put("since", sinceIdWall);
            String fbResponseWall = postRequest(params, "https://graph.facebook.com/me/feed",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95", "GET");
            try {
                JSONObject phraseResp = new JSONObject(fbResponseWall);
                if (phraseResp.has("data")) {
                    JSONArray postsData = phraseResp.getJSONArray("data");
                    int postsToRemove = 0;//Remove all te posts that are not relevant:likes a photo, commented on a photo, likes his/her own link, etc

                    for (int i = 0; i < postsData.length(); i++) {
                        String postType = postsData.getJSONObject(i).getString("type");

                        if (postType.equals("photo")) {
                            if (postsData.getJSONObject(i).has("application")) {
                                postsToRemove++;
                            }
                        } else if (postType.equals("link") || postType.equals("status")) {
                            String story;
                            if (!postsData.getJSONObject(i).isNull("story")) {
                                story = (!postsData.getJSONObject(i).isNull("story"))
                                        ? postsData.getJSONObject(i).getString("story") : "";
                                if (story.contains("is going to an event") &&
                                        postsData.getJSONObject(i).has("link")) {//If the link is an event
                                    postsToRemove++;
                                }
                                if (story.contains("likes a photo")) {
                                    postsToRemove++;
                                } else if (story.contains("likes a link")) {
                                    postsToRemove++;
                                } else if (story.contains("likes a status")) {
                                    postsToRemove++;
                                } else if (story.contains("commented on")) {
                                    postsToRemove++;
                                } else if (story.contains("likes")) {
                                    postsToRemove++;
                                } else if (story.contains("is going to")) {
                                    postsToRemove++;
                                } else if (story.contains("created an event")) {
                                    postsToRemove++;
                                }
                            }
                        }
                    }

                    if ((postsData.length() - postsToRemove) > 0) {
                        out.println("<script type=\"text/javascript\">");
                        /*out.println("   var tabId = '" + objUri + WALL_TAB + "';");
                        out.println("   var pane = dijit.byId(tabId);");
                        out.println("   try{");
                        out.println("       var aux='" + paramRequest.getLocaleString("newPosts") + " (" + (postsData.length() - postsToRemove) + ")';");
                        out.println("       pane.title = aux;");
                        out.println("       pane.controlButton.containerNode.innerHTML = aux;");
                        out.println("   }catch(noe){");
                        out.println("       alert('Error setting title: ' + noe);");
                        out.println("   }");*/

                        out.println("   var wall = '" + objUri + "newPostsWallAvailable';");
                        String textLabel = "";
                        if ((postsData.length() - postsToRemove) == 1) {
                            textLabel = paramRequest.getLocaleString("youHave") +
                                    " <b>1</b> " + paramRequest.getLocaleString("newPostLabel");
                        } else {
                            textLabel = paramRequest.getLocaleString("youHave") +
                                    " <b>" + (postsData.length() - postsToRemove) +
                                    "</b> " + paramRequest.getLocaleString("newPostsLabel");
                        }
                        out.println("   var hrefVal='<a href=\"#\" onclick=\"appendHtmlAt(\\'" +
                                renderURL.setMode("doGetStreamUser").
                                        setParameter("suri", objUri).
                                        setParameter("currentTab", FacebookWall.WALL_TAB) +
                                "\\',\\'" + objUri +
                                "facebookWallStream\\',\\'top\\'); try{dojo.byId(this.parentNode.id).innerHTML = \\'\\';}catch(noe){}; resetTabTitle(\\'" +
                                objUri + "\\', \\'" + FacebookWall.WALL_TAB + "\\', \\'" +
                                paramRequest.getLocaleLogString("myWall") + "\\'); return false;\">" +
                                textLabel + "</a>';");
                        out.println("   try{");
                        out.println("      document.getElementById(wall).innerHTML = hrefVal;");
                        out.println("   }catch(noe){}");
                        out.println("</script>");
                    }
                }
            } catch (JSONException jsone) {
                FacebookWall.log.error("Problemas al parsear respuesta de Facebook al preguntar si hay nuevos posts" + jsone);
            }
        }
        //session.setAttribute(objUri + tabSuffix + "since", since);
        String sinceIdPicture = (String) session.getAttribute(objUri + FacebookWall.PICTURES_TAB + "since");
        if (sinceIdPicture != null) {
            params.put("since", sinceIdPicture);
            params.put("limit", "50");
            params.put("fields", "id,from");//,created_time,likes,picture,name,name_tags,comments.limit(5) --Al fin que solo queremos saber cuantos hay
//            params.put("q", "{\"pictures\": \"SELECT actor_id, created_time, like_info, post_id, attachment, message, description, description_tags, type, comments FROM stream WHERE filter_key IN "
//                    + "( SELECT filter_key FROM stream_filter WHERE uid = me() AND name = 'Photos') AND created_time >" + sinceIdPicture + " LIMIT 50\", \"usernames\": \"SELECT uid, name FROM user WHERE uid IN (SELECT actor_id FROM #pictures)\", \"pages\":\"SELECT page_id, name FROM page WHERE page_id IN (SELECT actor_id FROM #pictures)\"}");
            String fbResponsePic = getRequest(params, "https://graph.facebook.com/me/photos",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95");
            try {
                JSONObject phraseResp = new JSONObject(fbResponsePic);
                JSONArray postsData = phraseResp.has("data") ? phraseResp.getJSONArray("data") : null;

                //Get only the size of pictures array
//                for (int i = 0; i < phraseResp.getJSONArray("data").length(); i++) {
//                    if (phraseResp.getJSONArray("data").getJSONObject(i).getString("name").equals("pictures")) {//All the posts
//                        postsData = phraseResp.getJSONArray("data").getJSONObject(i).getJSONArray("fql_result_set");
//                        break;
//                    }
//                }

                if (postsData != null && postsData.length() > 0) {
                    ////System.out.println("hay posts in PICTURE:" + postsData.length());
                    out.println("<script type=\"text/javascript\">");
                    /*out.println("   var tabId = '" + objUri + PICTURES_TAB + "';");
                    out.println("   var pane = dijit.byId(tabId);");
                    out.println("   try{");
                    out.println("       var aux='" + paramRequest.getLocaleString("newImages") + " (" + postsData.length() + ")';");
                    out.println("       pane.title = aux;");
                    out.println("       pane.controlButton.containerNode.innerHTML = aux;");
                    out.println("   }catch(noe){");
                    out.println("       alert('Error setting title: ' + noe);");
                    out.println("   }");*/

                    out.println("   var wall = '" + objUri + "newPicturesAvailable';");
                    String textLabel = "";
                    if (postsData.length() == 1) {
                        textLabel = paramRequest.getLocaleString("youHave") +
                                " <b>1</b> " + paramRequest.getLocaleString("newImageLabel");
                    } else {
                        textLabel = paramRequest.getLocaleString("youHave") + " <b>" +
                                postsData.length() + "</b> " + paramRequest.getLocaleString("newImagesLabel");
                    }
                    out.println("   var hrefVal='<a href=\"#\" onclick=\"appendHtmlAt(\\'" +
                            renderURL.setMode("doGetStreamPictures").
                                    setParameter("suri", objUri).
                                    setParameter("currentTab", FacebookWall.PICTURES_TAB) +
                            "\\',\\'" + objUri +
                            "picturesStream\\',\\'top\\'); try{dojo.byId(this.parentNode.id).innerHTML = \\'\\';}catch(noe){}; resetTabTitle(\\'" +
                            objUri + "\\', \\'" + FacebookWall.PICTURES_TAB + "\\', \\'" +
                            paramRequest.getLocaleString("myImages") +
                            "\\'); return false;\">" + textLabel + "</a>';");
                    out.println("   try{");
                    out.println("      document.getElementById(wall).innerHTML = hrefVal;");
                    out.println("   }catch(noe){}");
                    out.println("</script>");
                }
            } catch (JSONException jsone) {
                FacebookWall.log.error("Problemas al parsear respuesta de Facebook al preguntar si hay nuevos posts" + jsone);
            }
        }
    }

    public void doGetNewPosts(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        String currentTab = request.getParameter("currentTab") == null ? "" : request.getParameter("currentTab");
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();
        SWBModel model = WebSite.ClassMgr.getWebSite(facebook.getSemanticObject().getModel().getName());
        if (objUri != null) {
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute(objUri + currentTab + "processing", "true");
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("access_token", facebook.getAccessToken());
        params.put("since", session.getAttribute(objUri + currentTab + "since").toString());// since param used to get newer post
        String fbResponse = "";
        if (currentTab.equals(NEWS_FEED_TAB)) {
            fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + "me/home",
                    Facebook.USER_AGENT, "GET");
        } else if (currentTab.equals(WALL_TAB)) {
            fbResponse = postRequest(params, Facebook.FACEBOOKGRAPH + "me/feed",
                    Facebook.USER_AGENT, "GET");
        }
        String untilPost = parseResponse(fbResponse, out, true, request, paramRequest, currentTab, model);
        session.setAttribute(objUri + currentTab + "processing", "false");
    }

    /**
     * Obtiene los datos de las fotos publicadas en Facebook a partir de un momento determinado por el valor del
     * parametro {@code since}
     * @param request la peticion HTTP creada por el cliente
     * @param response la respuesta HTTP correspondiente a la peticion recibida
     * @param paramRequest objeto correspondiente a la plataforma SWB que contiene datos complementarios a la peticion
     * @throws SWBResourceException si ocurre algun problema durante la ejecucion del metodo
     * @throws IOException si ocurre un problema de lectura/escritura con la peticion/respuesta
     */
    public void doGetNewPictures(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String objUri = request.getParameter("suri");
        String currentTab = request.getParameter("currentTab") == null ? "" : request.getParameter("currentTab");
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();
        SWBModel model = WebSite.ClassMgr.getWebSite(facebook.getSemanticObject().getModel().getName());
        if (objUri != null) {
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute(objUri + currentTab + "processing", "true");
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("access_token", facebook.getAccessToken());

        String sinceIdPicture = (String) session.getAttribute(objUri + FacebookWall.PICTURES_TAB + "since");
        if (sinceIdPicture != null) {
            params.put("since", sinceIdPicture);
//            params.put("q", "{\"pictures\": \"SELECT actor_id, created_time, like_info, post_id, attachment, message, description, description_tags, type, comments FROM stream WHERE filter_key IN "
//                    + "( SELECT filter_key FROM stream_filter WHERE uid = me() AND name = 'Photos') AND created_time >" + sinceIdPicture + " LIMIT 50\", \"usernames\": \"SELECT uid, name FROM user WHERE uid IN (SELECT actor_id FROM #pictures)\", \"pages\":\"SELECT page_id, name FROM page WHERE page_id IN (SELECT actor_id FROM #pictures)\"}");
            String fbResponsePic = getRequest(params, "https://graph.facebook.com/me/photos",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95");
            //Gets the newest post and saves the ID of the last one
            String createdTime = picture(fbResponsePic, out, true, request, paramRequest, model);
        }
    }

/**
 * Gets the values of the properties {@literal id}, {@literal name} y {@literal type} assigned by Facebook
 * to the object identified by the value of {@code id}
 * @param id an identifier assigned by Facebook to an object
 * @param facebook the instance of a social network related to a facebook account
 * @return the response facebook gives according to {@code id}. Should be something like:
 * <pre>{
 *    "id": "100001234567890", 
 *    "name": "User's name", 
 *    "metadata": {
 *      "type": "user"
 *    }
 * }</pre>
 */
    public static String getProfileFromId(String id, Facebook facebook) {
        HashMap<String, String> params1 = new HashMap<String, String>(3);
        params1.put("access_token", facebook.getAccessToken());
        params1.put("metadata", "1");
        params1.put("fields", "id,name,metadata{type}");

        String fbResponse = null;
        try {
            fbResponse = getRequest(params1, Facebook.FACEBOOKGRAPH + id,
                    Facebook.USER_AGENT);

        } catch (Exception e) {
            FacebookWall.log.error("Error getting user information", e);
        }
        return fbResponse;
    }

    /**
     * Obtiene el identificador, nombre compuesto y en sus partes del usuario de Facebook identificado
     * por el valor de {@code id}
     * @param id identificador asignado por Facebook a un usuario registrado
     * @param facebook la instancia de la red social asociada a un usuario autenticado
     * @return un {@code String} convertible a JSON cuyo contenido son los datos registrados en Facebook para
     *         el identificador, nombre completo, primer y segundo nombres y apellido de una usuario, como:
     * <pre>
     * {
     *   "id": "100001234567891", 
     *   "name": "Nombre Completo de Usuario", 
     *   "first_name": "PrimerNombre",
     *   "middle_name": "SegundoNombre",
     *   "last_name": "Apellido"
     * }
     * </pre>
     * Algunos campos podrian no estar presentes en la respuesta, de acuerdo a los datos registrados en Facebook
     */
    public static String getUserInfoFromId(String id, Facebook facebook) {
        HashMap<String, String> params1 = new HashMap<String, String>(2);
//        params1.put("q", "SELECT uid, name, first_name, middle_name, last_name FROM user WHERE uid = " + id);
        params1.put("access_token", facebook.getAccessToken());
        params1.put("fields", "id,name,first_name,middle_name,last_name");

        String fbResponse = null;
        try {
            fbResponse = getRequest(params1, Facebook.FACEBOOKGRAPH + id,
                    Facebook.USER_AGENT);

        } catch (Exception e) {
            FacebookWall.log.error("Error getting user information", e);
        }
        return fbResponse;
    }

    /**
     * Obtiene el identificador y nombre registrados en Facebook para el objeto identificado
     * por el valor de {@code id}
     * @param id identificador asignado por Facebook a un objeto
     * @param facebook instancia de la red social asociada a un usuario autenticado
     * @return un {@code String} convertible a JSON con los valores del identificador y nombre
     *         asignados por Facebook a un objeto cuyo identificador equivale a {@code id}
     */
    public static String getPageInfoFromId(String id, Facebook facebook) {
        HashMap<String, String> params1 = new HashMap<String, String>(3);
        params1.put("access_token", facebook.getAccessToken());
        params1.put("fields", "id,name");
//        params1.put("q", "SELECT page_id, name , type FROM page where page_id = " + id);

        String fbResponse = null;
        try {
            fbResponse = getRequest(params1, Facebook.FACEBOOKGRAPH + id,
                    Facebook.USER_AGENT);
        } catch (Exception e) {
            FacebookWall.log.error("Error getting page information", e);
        }
        return fbResponse;
    }

    public static String facebookHumanFriendlyDate(Date created, SWBParamRequest paramRequest) {
        Date today = new Date();
        Long duration = today.getTime() - created.getTime();

        int second = 1000;
        int minute = second * 60;
        int hour = minute * 60;
        int day = hour * 24;
        String date = "";
        try {
            if (duration < second * 7) {//Less than 7 seconds
                date = paramRequest.getLocaleString("rightNow");
            } else if (duration < minute) {
                int n = (int) Math.floor(duration / second);
                date = n + " " + paramRequest.getLocaleString("secondsAgo");
            } else if (duration < minute * 2) {//Less than 2 minutes
                date = paramRequest.getLocaleString("about") + " 1 " + paramRequest.getLocaleString("minuteAgo");
            } else if (duration < hour) {
                int n = (int) Math.floor(duration / minute);
                date = n + " " + paramRequest.getLocaleString("minutesAgo");
            } else if (duration < hour * 2) {//Less than 1 hour
                date = paramRequest.getLocaleString("about") + " 1 " + paramRequest.getLocaleString("hourAgo");
            } else if (duration < day) {
                int n = (int) Math.floor(duration / hour);
                date = n + " " + paramRequest.getLocaleString("hoursAgo");
            } else if (duration > day && duration < day * 2) {
                date = paramRequest.getLocaleString("yesterday");
            } else {
                int n = (int) Math.floor(duration / day);
                date = n + " " + paramRequest.getLocaleString("daysAgo");
            }
        } catch (Exception e) {
            FacebookWall.log.error("Problem found computing time of post. ", e);
        }
        return date;
    }

    public void doCreatePost(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        RequestDispatcher rd = request.getRequestDispatcher(SWBPlatform.getContextPath() +
                "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/post/typeOfContent.jsp");
        request.setAttribute("contentType", request.getParameter("valor"));
        request.setAttribute("wsite", request.getParameter("wsite"));
        request.setAttribute("objUri", request.getParameter("objUri"));
        request.setAttribute("paramRequest", paramRequest);

        try {
            rd.include(request, response);
        } catch (ServletException ex) {
            FacebookWall.log.error("Error al enviar los datos a typeOfContent.jsp " + ex.getMessage());
        }
    }

    private void moreContacts(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws IOException, JSONException {
        
        String url = "";
        SWBResourceURL actionURL = paramRequest.getActionUrl();
        SWBResourceURL renderURL = paramRequest.getRenderUrl();
        String objUri = request.getParameter("suri");
        String fbResponse = "";
        renderURL.setParameter("suri", objUri);
        PrintWriter out = response.getWriter();
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Facebook facebook = (Facebook) semanticObject.createGenericInstance();
        //SWBModel model = WebSite.ClassMgr.getWebSite(facebook.getSemanticObject().getModel().getName());
        //SocialTopic defaultSocialTopic = SocialTopic.ClassMgr.getSocialTopic("DefaultTopic", model);
        if (objUri != null) {
            actionURL.setParameter("suri", objUri);
            renderURL.setParameter("suri", objUri);
        }

        HashMap<String, String> params1 = new HashMap<String, String>(3);
        params1.put("access_token", facebook.getAccessToken());

        if (request.getParameter("type").equals("friends")) {
            url = "https://graph.facebook.com/me/friends";
            params1.put("offset", "" + request.getParameter("offsetFriends") + "");
            params1.put("__after_id", "" + request.getParameter("nextPage") + "");
            params1.put("limit", "20");
        } else if (request.getParameter("type").equals("subscriber")) {
            url = "https://graph.facebook.com/me/subscribers";
            params1.put("limit", "" + request.getParameter("offsetFollow") + "");
            params1.put("after", "" + request.getParameter("nextPage") + "");
            params1.put("limit", "30");
        }

        fbResponse = postRequest(params1, url, "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95", "GET");
        JSONObject phraseResp = new JSONObject(fbResponse);
        int cont = 0;
        JSONArray postsData = phraseResp.getJSONArray("data");
        JSONObject object = new JSONObject();
        String next = "";
        String image = "";
        String name = "";
        for (int k = 0; k < postsData.length(); k++) {
            cont++;
            object = (JSONObject) postsData.get(k);
            image = object.getString("id");
            name = object.getString("name");
            out.println("<div class=\"timeline timelinetweeter\">");
            out.println(" <p class=\"tweeter\">");
            out.println(" <a onclick=\"showDialog(' " +
                    paramRequest.getRenderUrl().setMode("fullProfile").
                            setParameter("suri", objUri).
                            setParameter("type", "noType").
                            setParameter("id", image).
                            setParameter("targetUser", name) +
                    " ',' " + name + " '); return false;\" href=\"#\">" + name + "</a>  ");
            out.println("</p>");
            out.println("<p class=\"tweet\">");
            out.println(" <a onclick=\"showDialog(' " +
                    paramRequest.getRenderUrl().setMode("fullProfile").
                            setParameter("suri", objUri).
                            setParameter("type", "noType").
                            setParameter("id", image).
                            setParameter("targetUser", name) +
                    " ',' " + name + " '); return false;\" href=\"#\">");
            out.println("<img src=\"" + Facebook.FACEBOOKGRAPH + image +
                    "/picture?width=150&height=150\" width=\"150\" height=\"150\" />");
            out.println("</a>");
            out.println("</p>");
            out.println("</div>");

        }

        if (phraseResp.has("paging")) {
            if (phraseResp.getJSONObject("paging").has("next")) {

                next = phraseResp.getJSONObject("paging").getString("next");
                int position = 0;


                if (request.getParameter("type").equals("friends")) {
                    String params[] = next.split("&");
                    String nextSend = null;
                    String offsetFriends = null;
                    for(int i = 0; i < params.length; i++){                        
                        if(params[i].startsWith("__after_id")){
                            nextSend = params[i].substring(params[i].indexOf("=")+1);
                        }else if(params[i].startsWith("offset")){
                            offsetFriends = params[i].substring(params[i].indexOf("=")+1);
                        }
                    }
                                        
                    out.println("<div align=\"center\" style=\"margin-bottom: 10px;\">");
                    out.println("  <label  id=\"" + objUri + "/moreFriendsLabel\" >");
                    out.println("<a href=\"#\" onclick=\"appendHtmlAt('" +
                            paramRequest.getRenderUrl().setAction("more").
                                    setParameter("type", "friends").
                                    setParameter("suri", facebook.getURI()).
                                    setParameter("nextPage", nextSend).
                                    setParameter("offsetFriends", offsetFriends) +
                            " ', '" + objUri +
                            "/getMoreFriendsFacebook',  'bottom'); try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;\" >Mas amigos");
                    out.println("</label>");
                    out.println("</a>");
                    out.println("</div");

                } else if (request.getParameter("type").equals("subscriber")) {
                    String afterId = "";
                    position = next.indexOf("__after_id");
                    afterId = next.substring(position + 11, next.length());
                    position = next.indexOf("after");
                    String nextSend = next.substring(position + 11, next.length());
                    position = next.indexOf("limit");
                    String offsetFollow = next.substring(position + 7, position + 9);
                    out.println("<div align=\"center\" style=\"margin-bottom: 10px;\">");
                    out.println("<label>");
                    out.println("<a href=\"#\" onclick=\"appendHtmlAt('" +
                            paramRequest.getRenderUrl().setAction("more").
                                    setParameter("type", "subscriber").
                                    setParameter("suri", facebook.getURI()).
                                    setParameter("nextPage", nextSend).
                                    setParameter("offsetFollow", offsetFollow).
                                    setParameter("afterId", afterId) +
                            " ', '" + objUri + "/getMoreSubscribers',  'bottom'); try{this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);}catch(noe){}; return false;\" >Mas seguidores");
                    out.println("</label>");
                    out.println("</a>");
                    out.println("</div");
                }
            }
        }
    }

    /*public static String SWBSocialResUtil.Util.createHttpLink(String text){
        StringBuilder result = new StringBuilder();
        String [] words = text.split(" ");
        for(int i=0; i < words.length ;  i++){
            String brTags[] = words[i].split("<br>");
            if(brTags.length > 0){ //found 
                for(int j=0; j < brTags.length ; j++){
                    if(brTags[j].startsWith("http://") || words[j].startsWith("https://")){
                        result.append("<a target=\"_new\" href=\"" + words[i] + "\">" + words[i] + "</a><br>");
                    }else{
                        result.append(brTags[j]);
                    }
                }
            }else{
                if(words[i].startsWith("http://") || words[i].startsWith("https://")){
                    result.append("<a target=\"_new\" href=\"" + words[i] + "\">" + words[i] + "</a> ");
                }else{
                    result.append(words[i] + " ");
                }
            }
        }
        //System.out.println("___________________________________________");
        return result.toString();
    }*/
    
    /**
     * Presenta el cuadro de dialogo de Facebook para que el usuario otorgue el permiso
     * requerido.
     * @param request la peticion HTTP generada por el cliente
     * @param response la respuesta HTTP correspondiente a la peticion
     * @param paramRequest el objeto que contiene valores y objetos complementarios a la
     *                     peticion dependientes de la plataforma SWB
     * @throws SWBResourceException si ocurre algun problema que atañe a la plataforma SWB
     *         durante la ejecucion del metodo
     * @throws IOException si ocurre algun problema de lectura/escritura mientras se lee la
     *         peticion o se escribe la respuesta
     */
    public void doGetPermission(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String objUri = request.getParameter("suri");
        String containerId = request.getParameter("containerId");
        HttpSession session = request.getSession(true);
        request.setAttribute("closeWin", "true");
        
        Facebook facebook = null;
        if (objUri != null) {
            facebook = (Facebook) SemanticObject.createSemanticObject(objUri).createGenericInstance();
            session.setAttribute("suri", objUri);
        } else {
            objUri = (String) session.getAttribute("suri");
            facebook = (Facebook) SemanticObject.createSemanticObject(objUri).createGenericInstance();
        }
        if (containerId != null) {
            session.setAttribute("containerId", containerId);
        }
        facebook.authenticate(request, response, paramRequest);
    }
    
    /**
     * Cierra la ventana utilizada para que el usuario ceda permisos de acceso a la
     * informacion presentada por la pestaña FacebookWall
     * @param request la peticion HTTP generada por el cliente
     * @param response la respuesta HTTP correspondiente a la peticion
     * @param paramRequest el objeto que contiene valores y objetos complementarios a la
     *                     peticion dependientes de la plataforma SWB
     * @throws SWBResourceException si ocurre algun problema que atañe a la plataforma SWB
     *         durante la ejecucion del metodo
     * @throws IOException si ocurre algun problema de lectura/escritura mientras se lee la
     *         peticion o se escribe la respuesta
     */
    public void doCloseWin(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
//        String objUri = request.getParameter("suri");
        HttpSession session = request.getSession(true);
        String containerId = (String) session.getAttribute("containerId");
        
//        Facebook facebook = null;
//        if (objUri != null) {
//            facebook = (Facebook) SemanticObject.createSemanticObject(objUri).createGenericInstance();
//            session.setAttribute("suri", objUri);
//        } else {
//            objUri = (String) session.getAttribute("suri");
//            facebook = (Facebook) SemanticObject.createSemanticObject(objUri).createGenericInstance();
//        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<script type=\"text/javascript\">");
        out.println("  this.opener.reloadSocialTab('" + containerId + "')");
        out.println("    window.close();");
        out.println("  ");
        out.println("</script>");
        out.println("</head>");
        out.println("<body>");
        out.println("</body>");
        out.println("</html>");
        session.removeAttribute("suri");
        session.removeAttribute("containerId");
    }
}