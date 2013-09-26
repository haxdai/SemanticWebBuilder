/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.Youtube;

/**
 *
 * @author francisco.jimenez
 */
public class YoutubeWall extends GenericResource{

    private static Logger log = SWBUtils.getLogger(YoutubeWall.class);
    
    /*variables used to define the id of '<div>' for the fields of information, favorite and reweet.
     Each link is in a different '<div>' and it's updated individually*/
    public static String INFORMATION = "/inf";
    public static String LIKE = "/like";
    public static String DISLIKE = "/unlike";
    public static String TOPIC ="/topic";
    
    /*Additionally every div has a suffix to identify if the status is inside the tab*/ 
    public static String HOME_TAB = "/myvideos";
    public static String DISCOVER_TAB ="/discover";
    
    public static int DEFAULT_VIDEO_COMMENTS = 5;
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String objUri = (String) request.getParameter("suri");
        String contentTabId = (String) request.getParameter("contentTabId");
        System.out.println("suriReceived in YoutubeWall:" + objUri);
        if(contentTabId == null){//The resource is loaded for the first time and it needs to display the tabs
            String jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/youtubeTabs.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            }catch (Exception e) {
                System.out.println("Error loading the Youtube Tabs " + e);
            }
            return;
        }
        
        String jspResponse = "";
        //Each one of the tabs is loaded once
        if(contentTabId != null && contentTabId.equals(HOME_TAB)){
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/youtubeVideos.jsp";
        }else if(contentTabId != null && contentTabId.equals(DISCOVER_TAB)){
            jspResponse = SWBPlatform.getContextPath() +"/work/models/" + paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/youtubeDiscover.jsp";
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
        
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error("Error in doView() for requestDispatcher" , e);
        }
    }
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        System.out.println("\n\n\nModo: " + mode);        
        String objUri = request.getParameter("suri");        
        System.out.println("suri in processRequest:" + objUri);
        PrintWriter out = response.getWriter();
        if(mode!= null && mode.equals("commentVideoSent")){//Feedback of commented video
            //response.getWriter().print("Comment sent");
            out.println("<script type=\"text/javascript\">");
            out.println("   hideDialog();");
            out.println("   showStatus('Comment sent successfully');");
            out.println("</script>");
        }else if(mode!= null && mode.equals("likeSent")){//Feedback of liked video
            response.getWriter().print("like / unlike sent");
        }else if(mode!= null && mode.equals("commentVideo")){//Displays dialog to create a comment
            SWBResourceURL actionURL = paramRequest.getActionUrl();
            actionURL.setParameter("videoId", request.getParameter("videoId"));
            actionURL.setParameter("suri", request.getParameter("suri"));

            out.println("<form type=\"dijit.form.Form\" id=\"createComment\" action=\"" +  actionURL.setAction("createCommentVideo") + "\" method=\"post\" onsubmit=\"submitForm('createComment'); try{document.getElementById('csLoading').style.display='inline';}catch(noe){}; return false;\">");
            out.println("<fieldset>");
            out.println("<table>");
            out.println("<tr>"); 
            out.println("   <td>");
            out.println("       <textarea type=\"dijit.form.Textarea\" name=\"comment\" id=\"comment\" rows=\"4\" cols=\"50\"></textarea>");
            out.println("   </td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("       <td style=\"text-align: center;\"><button dojoType=\"dijit.form.Button\" type=\"submit\">Comment</button></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("<span id=\"csLoading\" style=\"width: 100px; display: none\" align=\"center\">&nbsp;&nbsp;&nbsp;<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/loading.gif\"/></span>");
        }else if(mode != null && mode.equals("getMoreComments")){
            doGetMoreComments(request, response, paramRequest);
        }else{
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doGetMoreComments(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String videoId = request.getParameter("videoId");
        String startIndex = request.getParameter("startIndex");
        String totalComments = request.getParameter("totalComments");
        System.out.println("videoId:" +videoId + "--startIndex:" + startIndex  + "--totalComments:" + totalComments);
        
        try{
            HashMap<String, String> paramsUsr = new HashMap<String, String>(3);
            paramsUsr.put("v", "2");
            paramsUsr.put("fields", "media:thumbnail");
            paramsUsr.put("alt", "json");
        
            HashMap<String, String> paramsComments = new HashMap<String, String>(3);
            paramsComments.put("v", "2");
            paramsComments.put("max-results", "10");
            paramsComments.put("start-index", (Integer.parseInt(startIndex) + 1) + "");
            paramsComments.put("alt", "json");
            String ytComments= getRequest(paramsComments, "https://gdata.youtube.com/feeds/api/videos/" + videoId + "/comments",
                            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95", null);
            JSONObject jsonComments = new JSONObject(ytComments);
            JSONArray arrayComments = null;
            if(!jsonComments.isNull("feed")){
                if(!jsonComments.getJSONObject("feed").isNull("entry")){
                    arrayComments = jsonComments.getJSONObject("feed").getJSONArray("entry");
                }
            }
            
            if(arrayComments != null && arrayComments.length() > 0){//Only print <li></li> because the HTML will be returned inside <ul></ul
                int commentCounter = 0;
                for(int c = 0; c < arrayComments.length(); c++){
                    commentCounter++;
                    JSONObject comment = arrayComments.getJSONObject(c);
                    JSONObject usrCommentProfile = null;
                    if(!comment.isNull("author")){
                        if(!comment.getJSONArray("author").getJSONObject(0).isNull("yt$userId")){
                            String commentProfile = getRequest(paramsUsr, "http://gdata.youtube.com/feeds/api/users/" + comment.getJSONArray("author").getJSONObject(0).getJSONObject("yt$userId").getString("$t"),
                                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95", null);
                            usrCommentProfile = new JSONObject(commentProfile);
                        }
                    }
                    out.print("<li>");
                    out.print("<a href=\"#\" title=\"" + "Ver perfil" + "\" onclick=\"showDialog('" + "#" + "','" + "source" + "'); return false;\"><img src=\"" + usrCommentProfile.getJSONObject("entry").getJSONObject("media$thumbnail").getString("url") + "\" width=\"50\" height=\"50\"/></a>");

                    out.print("<p>");
                    out.print("<a href=\"#\" title=\"" + "Ver perfil" + "\" onclick=\"showDialog('" + "/work/models/SWBAdmin/jsp/socialNetworks/youtubeUserProfile.jsp?suri=null&id=" + comment.getJSONArray("author").getJSONObject(0).getJSONObject("yt$userId").getString("$t") + "','" + "Ver perfil" + "'); return false;\">" + comment.getJSONArray("author").getJSONObject(0).getJSONObject("name").getString("$t") + "</a>:");                            
                    out.print(       comment.getJSONObject("content").getString("$t").replace("\n", "</br>"));
                    out.print("</p>");

                    //Date commentTime = formatter.parse(comments.getJSONObject(k).getString("created_time"));

                    out.print("<p class=\"timelinedate\">");
                    out.print("<span dojoType=\"dojox.layout.ContentPane\">");

                    out.print("<em>" + "creado el: " + comment.getJSONObject("published").getString("$t") +  "</em>");                            
                    out.print("</span>");
                    out.print("</p>");
                    out.print("</li>");
                }
                System.out.println("SE OBTUVIERON :" + commentCounter + " COMENTARIOS");
                if((Integer.parseInt(startIndex) + commentCounter) < Integer.parseInt(totalComments) ){//Link to get more comments
                    out.print("<li class=\"timelinemore\">");
                    out.print("<label><a href=\"#\" onclick=\"appendHtmlAt('" + paramRequest.getRenderUrl().setMode("getMoreComments").setParameter("videoId", videoId).setParameter("startIndex", (commentCounter + Integer.parseInt(startIndex)) +"").setParameter("totalComments", totalComments+"")
                            + "','" + videoId +"/comments', 'bottom');try{this.parentNode.parentNode.removeChild( this.parentNode );}catch(noe){}; return false;\"><span>+</span>View more comments</a></label>");
                    out.print("</li>");
                }
            }
        }catch(Exception e){
            System.out.println("ERROR GETTING MORE COMMENTS");
            log.error("Problem getting more comments", e);
        }
    }

    
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        
        if(action != null && (action.equals("doLike") || action.equals("doDislike"))){//Do a Like
            System.out.println("Doing a like");
            doLikeDislike(request);
            response.setMode("likeSent");
        }else if(action != null && action.equals("createCommentVideo")){
            System.out.println("Commenting a video");
            doCommentVideo(request);
            response.setMode("commentVideoSent");
        }
    }
    private void doLikeDislike(HttpServletRequest request) {
        String action = request.getParameter("action");
        String videoId = request.getParameter("videoId");
        String objUri = request.getParameter("suri");
        if((action == null || action.isEmpty()) || (videoId == null || videoId.isEmpty()) ||
                (objUri == null || objUri.isEmpty())){
            log.error("Problema ejecutando accion Like/Dislike");
            return;
        }

        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Youtube semanticYoutube = (Youtube) semanticObject.createGenericInstance();
        if(!semanticYoutube.validateToken()){
            log.error("Unable to update the access token!");
            return;
        }
        
        String url1 = "http://gdata.youtube.com/feeds/api/videos/" + videoId + "/ratings";
        URL url;
        HttpURLConnection conn = null;
        try {
            url = new URL(url1);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setRequestProperty("Host", "gdata.youtube.com");
            conn.setRequestProperty("Content-Type", "application/atom+xml");
            conn.setRequestProperty("Authorization", "Bearer " + semanticYoutube.getAccessToken());
            conn.setRequestProperty("GData-Version", "2");
            conn.setRequestProperty("X-GData-Key", "key=" + semanticYoutube.getDeveloperKey());

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());                        
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
            " <entry xmlns=\"http://www.w3.org/2005/Atom\"\r\n" +
            " xmlns:yt=\"http://gdata.youtube.com/schemas/2007\">\r\n" +
            " <yt:rating value=\"" + action + "\"/>\r\n" +
            "</entry>\r\n";
            writer.write(xml.getBytes("UTF-8"));
            writer.flush();
            writer.close();                        
            BufferedReader readerl = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String docxml = readerl.readLine();
            System.out.print("--Ejecuted Like/disLike:" + docxml);
        }catch(Exception ex){
            System.out.println("ERROR" + ex.toString());
            ex.printStackTrace();
        }
    }

    private void doCommentVideo(HttpServletRequest request) {
        String videoId = request.getParameter("videoId");
        String objUri = request.getParameter("suri");
        String comment = request.getParameter("comment");
        
        if((videoId == null || videoId.isEmpty()) || (comment == null || comment.isEmpty()) ||
                (objUri == null || objUri.isEmpty())){
            log.error("Problema ejecutando el posteo del comentario");
            return;
        }
        
        SemanticObject semanticObject = SemanticObject.createSemanticObject(objUri);
        Youtube semanticYoutube = (Youtube) semanticObject.createGenericInstance();
        if(!semanticYoutube.validateToken()){
            log.error("Unable to update the access token inside post Comment!");
            return;
        }
        
        String urlComment = "http://gdata.youtube.com/feeds/api/videos/" + videoId + "/comments";
        URL url;
        HttpURLConnection conn = null;
        try {
            url = new URL(urlComment);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setRequestProperty("Host", "gdata.youtube.com");
            conn.setRequestProperty("Content-Type", "application/atom+xml");
            conn.setRequestProperty("Authorization", "Bearer " + semanticYoutube.getAccessToken());
            conn.setRequestProperty("GData-Version", "2");
            conn.setRequestProperty("X-GData-Key", "key=" + semanticYoutube.getDeveloperKey());

            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());                        
            String xml = "<?xml version=\"1.0\"?>"
                + "<entry xmlns=\"http://www.w3.org/2005/Atom\""
                + " xmlns:yt=\"http://gdata.youtube.com/schemas/2007\">"
                + "<content>" + comment + "</content>"
                + "</entry>";
            writer.write(xml.getBytes("UTF-8"));
            writer.flush();
            writer.close();                        
            BufferedReader readerl = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String docxml = readerl.readLine();
            System.out.print("--docxml en post Comment----" + docxml);               
        }catch(Exception ex){
            System.out.println("ERROR" + ex.toString());
            ex.printStackTrace();
        }
    }
    
    public static String getRequest(Map<String, String> params, String url,
            String userAgent, String token) throws IOException {
        
        CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = new URL(url + "?" +  paramString);       
        //System.out.println("URL:" +  serverUrl);
        
        HttpURLConnection conex = null;
        InputStream in = null;
        String response = null;
       
        try {
            conex = (HttpURLConnection) serverUrl.openConnection();
            if (userAgent != null) {
                conex.setRequestProperty("user-agent", userAgent);                
            }
            ///Validate if i am looking for the default user or another
            if(token != null){
                conex.setRequestProperty("Authorization", "Bearer " + "ya29.AHES6ZQJgECzLX3Y5hbAkVMn7qCupPdOJ6RR9d4tO0pEhUziVlAdFwKL4A");
            }
            ///
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod("GET");
            conex.setDoOutput(true);
            conex.connect();
            in = conex.getInputStream();
            response = getResponse(in);
            //System.out.println("RESPONSE:" + response);
                        
        } catch (java.io.IOException ioe) {
            if (conex.getResponseCode() >= 400) {
                response = getResponse(conex.getErrorStream());
                System.out.println("\n\n\nERROR:" +   response);
            }
            ioe.printStackTrace();
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
        StringBuilder buffer
                = new StringBuilder(64);
	boolean notFirst = false;
        for (Map.Entry<String, String> entry : entries ) {
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
     * Codifica el valor de {@code target} de acuerdo al c&oacute;digo de caracteres UTF-8
     * @param target representa el texto a codificar
     * @return un {@code String} que representa el valor de {@code target} de acuerdo al c&oacute;digo de caracteres UTF-8
     * @throws UnsupportedEncodingException en caso de ocurrir algun problema en la codificaci&oacute;n a UTF-8
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
    
    public static void close( Closeable c ) {
        if ( c != null ) {
            try {
                c.close();
            }
            catch ( IOException ex ) {             
            }
        }
    }
}
