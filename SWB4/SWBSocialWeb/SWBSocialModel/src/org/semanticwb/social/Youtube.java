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
 
package org.semanticwb.social;

/*import com.google.api.client.googleapis.json.GoogleJsonResponseException;
 import com.google.api.client.http.HttpRequest;
 import com.google.api.client.http.HttpRequestInitializer;
 import com.google.api.client.http.HttpTransport;
 import com.google.api.client.http.javanet.NetHttpTransport;
 import com.google.api.client.json.JsonFactory;
 import com.google.api.client.json.jackson2.JacksonFactory;
 import com.google.api.services.youtube.YouTube;
 import com.google.api.services.youtube.model.ResourceId;
 import com.google.api.services.youtube.model.SearchListResponse;
 import com.google.api.services.youtube.model.SearchResult;
 import com.google.api.services.youtube.model.SearchResultSnippet;
 */
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.io.SWBFile;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.social.listener.Classifier;
import org.semanticwb.social.util.SWBSocialUtil;
import org.semanticwb.social.youtube.YoutubeChannelInfo;
import org.semanticwb.social.youtube.YoutubeCommentThreadsInfo;
import org.semanticwb.social.youtube.YoutubeVideoInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class Youtube extends org.semanticwb.social.base.YoutubeBase {

    
    private static Logger log = SWBUtils.getLogger(Youtube.class);
    
    static String UPLOAD_URL = "http://uploads.gdata.youtube.com/feeds/api/users/default/uploads";
    
    /**
     * URL para visualizar un video de Youtube dentro de su pagina
     * [{@literal http://www.youtube.com/v/}]
     */
    static String BASE_VIDEO_URL = "http://www.youtube.com/v/";

    final public static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95";

    /**
     * Dominio de youtube al que se hacen peticiones de API
     * [{@literal www.googleapis.com}]
     */
    final public static String HOST = "www.googleapis.com";
    
    /**
     * URL al que se pueden hacer peticiones a Youtube para ejecutar recursos del API
     * [{@literal https://www.googleapis.com/youtube/v3}]
     */
    final public static String API_URL = "https://www.googleapis.com/youtube/v3";
    
    public Youtube(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }  
    
    static {
        Youtube.social_Youtube.registerObserver(new SocialNetSemanticObserver());
    }

    /* public void postVideo(Video video) {
     System.out.println("Video K llega a Youtube:" + video);
     System.out.println("Video id:" + video.getId());
     //System.out.println("Video title:"+video.getTitle());
     //System.out.println("Video descr:"+video.getDescription());
     System.out.println("Video Tags:" + video.getTags());
     System.out.println("Video getVideo:" + video.getVideo());
     YouTubeService service = getYouTubeService();
     if (service == null) {
     return;
     }
     //String action = response.getAction();
     try {
     //if (action.equals("uploadVideo")) {

     //    WebSite wsite=response.getWebPage().getWebSite();

     VideoEntry newEntry = new VideoEntry();


     newEntry.setLocation("Mexico"); // Debe estar desde la configuración de la red social
     YouTubeMediaGroup mg = newEntry.getOrCreateMediaGroup();
     //http://gdata.youtube.com/schemas/2007/categories.cat-->pienso que a una cirta comunidad se le deberÃ­a asignar una categoria en especifico
     //(de las del archivo de la mencionada url, ej. Autos) y serÃ­a con la que se subieran los nuevos videos y de esta manera
     //ya no le mostrarÃ­a un combo con todas las categorias para que el usuario final escogiera, porque en realidad en una comunidad se deberian
     //de subir videos con una cierta categoria solamente, que serÃ­a que tuviera relaciÃ³n con el tipo de comunidad en la que se esta.
     //***El tÃ­tulo, la categoria y por lo menos un keyword son requeridos.

     mg.addCategory(new MediaCategory(YouTubeNamespace.CATEGORY_SCHEME, "Autos"));       // Debe estar desde la configuración de la red social
     mg.addCategory(new MediaCategory(YouTubeNamespace.DEVELOPER_TAG_SCHEME, "xyzzy"));  // Debe estar desde la configuración de la red social

     String title = "SWBSocial"; //TODO:Ver como aparece este título en YouTube y si lo requiere o es opcional
     if (title != null && title.trim().length() > 0) {
     mg.setTitle(new MediaTitle());
     mg.getTitle().setPlainTextContent(title);
     }
     String keywords = video.getTags();
     if (keywords != null && keywords.trim().length() > 0) {
     mg.setKeywords(new MediaKeywords());
     if (keywords.indexOf(",") > -1) {
     StringTokenizer strTokens = new StringTokenizer(keywords, ",");
     while (strTokens.hasMoreTokens()) {
     String token = strTokens.nextToken();
     mg.getKeywords().addKeyword(token);
     }
     } else {
     mg.getKeywords().addKeyword(keywords);
     }
     }
     String description = video.getMsg_Text();
     if (description != null && description.trim().length() > 0) {
     mg.setDescription(new MediaDescription());
     mg.getDescription().setPlainTextContent(description);
     }
     //mg.setPrivate(false);
     //URL uploadUrl = new URL("http://gdata.youtube.com/action/GetUploadToken");
     //FormUploadToken token = service.getFormUploadToken(uploadUrl, newEntry);

     mg.setPrivate(false);


     newEntry.setGeoCoordinates(new GeoRssWhere(37.0, -122.0));       //ver como puedo obtener estos datos (latitud y longitud) dinamicamente
     // alternatively, one could specify just a descriptive string
     // newEntry.setLocation("Mountain View, CA");

     String videoSend = SWBPortal.getWorkPath() + video.getWorkPath() + "/" + video.getVideo();
     MediaFileSource ms = new MediaFileSource(new File(videoSend), "video/quicktime");
     newEntry.setMediaSource(ms);

     VideoEntry entry = service.insert(new URL(UPLOAD_URL), newEntry);
     System.out.println("createdEntry:" + entry);
     System.out.println("createdEntry:" + entry.getId());
     System.out.println("entry sefLink:" + entry.getSelfLink());
     System.out.println("entry getEtag:" + entry.getEtag());
     System.out.println("entry getKind:" + entry.getKind());
     System.out.println("entry getVersionId:" + entry.getVersionId());

     int post = -1;
     post = entry.getId().lastIndexOf(":");
     if (post > -1) {
     String idEntry = entry.getId().substring(post + 1);
     System.out.println("idEntry********:" + idEntry);
     //SWBSocialUtil.MONITOR.persistPost2Monitor(video, idEntry, this, wsite);
     addSentPost(video, idEntry, this);
     }

     System.out.println("createdEntry:" + entry.getPublicationState().getState().name());

     //you upload a video using the direct upload method, then the Upload API response will contain a <link> tag for which the value of the rel attribute is self. To check the status of the uploaded video, send a GET request to the URL identified in this <link> tag.
     //<link rel='self' type='application/atom+xml' href='https://gdata.youtube.com/feeds/api/users/default/uploads/Video_ID'/>

     if (entry.isDraft()) {
     System.out.println("Video is not live");
     YtPublicationState pubState = entry.getPublicationState();
     if (pubState.getState() == YtPublicationState.State.PROCESSING) {
     System.out.println("Video is still being processed.");
     } else if (pubState.getState() == YtPublicationState.State.REJECTED) {
     System.out.print("Video has been rejected because: ");
     System.out.println(pubState.getDescription());
     System.out.print("For help visit: ");
     System.out.println(pubState.getHelpUrl());
     } else if (pubState.getState() == YtPublicationState.State.FAILED) {
     System.out.print("Video failed uploading because: ");
     System.out.println(pubState.getDescription());
     System.out.print("For help visit: ");
     System.out.println(pubState.getHelpUrl());
     }
     }


     //response.setRenderParameter("jspResponse", "/swbadmin/jsp/social/videoable/videoable.jsp");
     //response.setRenderParameter("videoId", newEntry.getId());
     //}
     } catch (Exception e) {
     log.error(e);
     }
     }*/
    
    @Override
    public void postVideo(Video video) {
        if (!isSn_authenticated() || getAccessToken() == null ) {
            Youtube.log.error("Not authenticated network: " + getTitle() + ". Unable to post Video");
            return;
        }
        //System.out.println("Entra al metodo postVideo de YouTube....");
        if (video.getVideo() == null || video.getTitle() == null) {//Required fields
            return;
        }

        //Valida que este activo el token, de lo contrario lo refresca
        if (!this.validateToken()) {
            Youtube.log.error("Unable to update the access token inside postVideo Youtube!");
            return;
        }

        if (video.getMsg_Text() != null && video.getMsg_Text().trim().length() > 1) {
            String messageText = this.shortMsgText(video);
            //video.setMsg_Text(messageText);
        }
        String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String boundary = "";
        for (int i = 0; i < 8; i++) {
            int numero = (int) (Math.random() * base.length());
            String caracter = base.substring(numero, numero + 1);
            boundary = boundary + caracter;
        }
        String url1 = Youtube.API_URL + "/videos?part=snippet";
        URL url;
        HttpURLConnection conn = null;
        StringBuilder toFile = new StringBuilder(128);
        toFile.append("postVideo():\n");
        
        try {
            url = new URL(url1);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setRequestProperty("Host", "www.googleapis.com");
            conn.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
            conn.setRequestProperty("Slug", video.getTitle());
            conn.setRequestProperty("Content-Type", "multipart/related; boundary=\"" + boundary + "\"");
            //conn.setRequestProperty("Content-Length", getLength());
            conn.setRequestProperty("Connection", "close");
            
            toFile.append(conn.getURL() + "\n");
            toFile.append("AccessToken: " + this.getAccessToken());
            toFile.append("Key: " + this.getDeveloperKey());
            DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
            writer.write(("\r\n--" + boundary + "\r\n").getBytes());
            writer.write("Content-Type: application/json; charset=UTF-8\r\n\r\n".getBytes());
            
            String category = video.getCategory() == null || video.getCategory().isEmpty()
                              ? "22" : video.getCategory();  //Categoria 22 = People & blogs
            //System.out.println("THE CATEGORY->" + category + "<-");
            String privacy = this.privacyValue(video);
            
            JSONObject snippet = new JSONObject();
            snippet.put("title", video.getTitle());
            snippet.put("description", video.getMsg_Text() == null ? "" : video.getMsg_Text());
            if (video.getTags() != null) {
                snippet.put("tags", video.getTags());
            }
            snippet.put("categoryId", category);
            JSONObject status = new JSONObject();
            status.put("privacyStatus", 
                       privacy.equalsIgnoreCase("NOT_LISTED") ? "unlisted" : privacy.toLowerCase());
            status.put("embeddable", true);
            status.put("publicStatsViewable", true);
            JSONObject jsonVideo = new JSONObject();
            jsonVideo.put("snippet", snippet);
            jsonVideo.put("status", status);
            
//            String xml = "<?xml version=\"1.0\"?>\r\n"
//                    + " <entry xmlns=\"http://www.w3.org/2005/Atom\"" + "\r\n"
//                    + "xmlns:media=\"http://search.yahoo.com/mrss/\"\r\n"
//                    + "xmlns:yt=\"http://gdata.youtube.com/schemas/2007\"> \r\n"
//                    + " <media:group> \r\n"
//                    + " <media:title type=\"plain\">" + video.getTitle() + "</media:title> \r\n"
//                    + " <media:description type=\"plain\"> \r\n" + (video.getMsg_Text() == null ? "" : video.getMsg_Text()) + "\r\n"
//                    + " </media:description> \r\n"
//                    + " <media:category\r\n"
//                    + "scheme=\"http://gdata.youtube.com/schemas/2007/categories.cat\"> " + category + " \r\n"
//                    + " </media:category> \r\n"
//                    + " <media:keywords>" + (video.getTags() == null ? "" : video.getTags()) + "</media:keywords> \r\n"
//                    + (privacy.equals("PRIVATE") ? " <yt:private/> \r\n" :"")//Ad this tag to make a video PRIVATE
//                    + " </media:group> \r\n"
//                    + (privacy.equals("NOT_LISTED") ? " <yt:accessControl action='list' permission='denied'/> \r\n" : "")
//                    + " </entry> \r\n";
            //System.out.println("XML:" + xml);
            
            writer.write(jsonVideo.toString().getBytes("UTF-8"));
            writer.write(("--" + boundary + "\r\n").getBytes());
            String[] arr = video.getVideo().split("\\.");
            String ext = "Content-Type: video/" + arr[1] + "\r\n";
            writer.write(ext.getBytes());
            writer.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());

            String videoPath = SWBPortal.getWorkPath() + video.getWorkPath() + "/" + video.getVideo();
            SWBFile fileVideo = new SWBFile(videoPath);

            FileInputStream reader = new FileInputStream(fileVideo);
            byte[] array;
            int bufferSize = Math.min(reader.available(), 2048);
            array = new byte[bufferSize];
            int read = 0;
            read = reader.read(array, 0, bufferSize);
            while (read > 0) {
                writer.write(array, 0, bufferSize);
                bufferSize = Math.min(reader.available(), 2048);
                array = new byte[bufferSize];
                read = reader.read(array, 0, bufferSize);
            }
            writer.write(("--" + boundary + "--\r\n").getBytes());
            writer.write(("--" + boundary + "--\r\n").getBytes());
            writer.flush();
            writer.close();
            reader.close();
            BufferedReader readerl = new BufferedReader(new InputStreamReader(conn.getInputStream()));            
            StringBuilder videoInfo = new StringBuilder();
            String line;
            while ((line = readerl.readLine()) != null) {
               videoInfo.append(line);
            }
            line = videoInfo.toString();
            toFile.append(line);
            toFile.append("\n");
            JSONObject newVideo = new JSONObject(line);
            String videoId = !newVideo.isNull(("id")) ? newVideo.getString("id") : null;
            //System.out.println("videoId..." + videoId);
            //Si el videoId es diferente de null manda a preguntar por el status del video
            //de lo contrario manda el error al log
            if (videoId != null) {
                SWBSocialUtil.PostOutUtil.savePostOutNetID(video, this, videoId, null);
            }
        } catch (Exception ex) {
            try {
                String errorMessage = this.getResponse(conn.getErrorStream());
                Youtube.log.error("PROBLEM UPLOADING VIDEO: " + errorMessage);
                if (errorMessage != null  && errorMessage.contains("<error>")) {
                    SWBSocialUtil.PostOutUtil.savePostOutNetID(video, this, null, errorMessage);
                } else if(conn.getResponseMessage() != null) {
                    SWBSocialUtil.PostOutUtil.savePostOutNetID(video, this, null, conn.getResponseMessage());
                }
            } catch (Exception e) {
                //System.out.println("IGNORED:" + e.getMessage());
            }
            Youtube.log.error("ERROR-->", ex);
        }

        /*   try
         {
         System.out.println("Va a Grabar en savePostOutNetID - George/video:"+video+", this:"+this);
         SWBSocialUtil.PostOutUtil.savePostOutNetID(video, this, "12345678");
         }catch(Exception e)
         {
            
         }*/
        Youtube.write2File(toFile);
    }

    /*
    private YouTubeService getYouTubeService() {
        //YouTubeService service = new YouTubeService("SEMANTICWEBBUILDER", "AI39si4crQ_Zn6HmLxroe0TP48ZDkOXI71uodU9xc1QRyl8Y5TaRc2OIIOKMEatsw9Amce81__JcvvwObue_8yXD2yC6bFRhXA");
        YouTubeService service = new YouTubeService(getAppKey(), getSecretKey());
        try {
            //service.setUserCredentials(getLogin(), getPassword());
        } catch (Exception e) {
            log.error("Invalid login credentials:", e);
        }
        return service;
    }
*/

    /**
     * Ejecuta una peticion a la url indicada cuyo queryString se compone de los 
     * elementos recibidos en {@code params}
     * @param params los parametros para formar el queryString de la peticion con sus correspondientes valores
     * @param url ubicacion de Internet a la que se realiza la peticion
     * @param userAgent el user agent desde el que se realiza la peticion
     * @param method metodo solicitado para ejecutar la peticion
     * @return un {@code String} con la respuesta obtenida por la ejecucion de la peticion
     * @throws IOException en caso de algun problema con la ejecucion de la peticion
     */
    public String getRequest(Map<String, String> params, String url,
            String userAgent, String method) throws IOException {
        
        CharSequence paramString = (null == params)
                                   ? "" : delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = null;
        String userAgent2Use = userAgent != null ? userAgent : Youtube.USER_AGENT;
        
        if (params != null) {
            serverUrl = new URL(url + "?" + paramString);
        } else {
            serverUrl = new URL(url);
        }
        HttpURLConnection conex = null;
        InputStream in = null;
        String response = null;
        StringBuilder toFile = new StringBuilder(128);
        toFile.append(url + "?" + paramString);
        toFile.append("\n");

        if (method == null) {
            method = "POST";
        }
        try {
            
            conex = (HttpURLConnection) serverUrl.openConnection();
            conex.setRequestProperty("Host", Youtube.HOST);
            //conex.setRequestProperty("user-agent", userAgent2Use);
            conex.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod(method);
            conex.setDoOutput(true);
            conex.connect();

            in = conex.getInputStream();
            response = this.getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex != null) {
                Youtube.log.error("ERROR in getRequest:" + this.getResponse(conex.getErrorStream()), ioe);
            } else {
                Youtube.log.error("ERROR in getRequest", ioe); 
            }
        } finally {
            close(in);
            if (conex != null) {
                conex.disconnect();
            }
        }
        if (response == null) {
            response = "";
        }
        toFile.append(response);
        toFile.append("\n");
        Youtube.write2File(toFile);
        return response;
    }

    private String getRedirectUrl(HttpServletRequest request, SWBParamRequest paramRequest) {
        //System.out.println("getRedirectUrl....");
        StringBuilder address = new StringBuilder(128);
        address.append("http://").append(request.getServerName()).append(":").append(request.getServerPort()).append("/").append(paramRequest.getUser().getLanguage()).append("/").append(paramRequest.getResourceBase().getWebSiteId()).append("/" + paramRequest.getWebPage().getId() + "/_rid/").append(paramRequest.getResourceBase().getId()).append("/_mod/").append(paramRequest.getMode()).append("/_lang/").append(paramRequest.getUser().getLanguage());
        //System.out.println("URL callback="+address);
        return address.toString();
    }

    CharSequence delimit(Collection<Map.Entry<String, String>> entries,
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

    private String encode(CharSequence target) throws UnsupportedEncodingException {

        String result = "";
        if (target != null) {
            result = target.toString();
            result = URLEncoder.encode(result, "UTF8");
        }
        return result;
    }

    private static String getResponse(InputStream data) throws IOException {

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

    private void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ex) {
            }
        }
    }

    /**
     * Ejecuta una peticion HTTP al API de Youtube de acuerdo a los parametros recibidos
     * @param params contiene las parejas de parametro/valor que forman el query string de la peticion
     * @param url define la URL de la peticion a realizar
     * @param userAgent indica el identificador del navegador Web utilizado en la peticion
     * @param method indica el metodo HTTP utilizado en la peticion
     * @return la respuesta a la ejecucion de la peticion. Si la peticion no genera una respuesta,
     *         se devuelve un {@code String} vacio.
     * @throws IOException en caso de ocurrir algun problema con la conexion HTTP
     */
    public String postRequest(Map<String, String> params, String url,
            String userAgent, String method) throws IOException {

        HttpURLConnection conex = null;
        OutputStream out = null;
        InputStream in = null;
        String response = null;
        StringBuilder toFile = new StringBuilder(128);

        if (method == null) {
            method = "POST";
        }
        try {
            CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
            URL serverUrl = new URL(url);
            toFile.append(url);
            toFile.append("?");
            toFile.append(paramString);
            toFile.append("\n");
            conex = (HttpURLConnection) serverUrl.openConnection();
            if (userAgent != null) {
                conex.setRequestProperty("user-agent", userAgent);
            }
            conex.setRequestProperty("Host", Youtube.HOST);
            conex.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod(method);
            conex.setDoOutput(true);
            conex.connect();
            out = conex.getOutputStream();
            out.write(paramString.toString().getBytes("UTF-8"));
            in = conex.getInputStream();
            response = this.getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex != null) {
                Youtube.log.error("ERROR in Youtube.postRequest():\n" + getResponse(conex.getErrorStream()), ioe);
            } else {
                Youtube.log.error("ERROR in Youtube.postRequest():\n", ioe);
            }
        } finally {
            close(in);
            close(out);
            if (conex != null) {
                conex.disconnect();
            }
        }
        if (response == null) {
            response = "";
        }
        toFile.append(response);
        Youtube.write2File(toFile);
        return response;
    }

    /**
     * Realiza una peticion HTTP al API de Youtube con los parametros recibidos, conteniendo informacion en su cuerpo
     * @param params debe contener las parejas de parametro/valor a incluir en el query string
     *               de la peticion HTTP a realizar
     * @param url ubicacion URL de la peticion a realizar
     * @param object objeto en formato JSON a incluir en el cuerpo de la peticion
     * @param userAgent cadena de identificacion del navegador Web con el que se hace la peticion
     * @param method metodo HTTP a utilizar en la peticion, por defecto: POST
     * @return el cuerpo de la respuesta generada por la ejecucion de la peticion HTTP contenido en un {@code String}
     * @throws IOException derivado de cualquier problema con la conexion realizada
     */
    public String postRequestWithBody(Map<String, String> params, String url,
            JSONObject object, String userAgent, String method) throws IOException {

        CharSequence paramString = (null == params) ? "" : this.delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = new URL(url + "?" + paramString);

        HttpURLConnection conex = null;
        OutputStream out = null;
        InputStream in = null;
        String response = null;
        StringBuilder toFile = new StringBuilder(128);
        toFile.append(url);
        toFile.append("?");
        toFile.append(paramString);
        toFile.append("\n");

        if (method == null) {
            method = "POST";
        }
        try {
            conex = (HttpURLConnection) serverUrl.openConnection();
            if (userAgent != null) {
                conex.setRequestProperty("user-agent", userAgent);
            }
            conex.setRequestProperty("Host", Youtube.HOST);
            conex.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
            conex.setRequestProperty("Content-Type", "application/json");
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod(method);
            conex.setDoInput(true);
            conex.setDoOutput(true);
            conex.setUseCaches(false);
            if (object != null) {
                DataOutputStream writer = new DataOutputStream(conex.getOutputStream());
                writer.write(object.toString().getBytes("UTF-8"));
                writer.flush();
                writer.close();
            }
//            out = conex.getOutputStream();
//            out.write(paramString.toString().getBytes("UTF-8"));
            in = conex.getInputStream();
            response = Youtube.getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex != null) {
                Youtube.log.error("ERROR in postRequestWithBody:" + Youtube.getResponse(conex.getErrorStream()), ioe);
            } else {
                Youtube.log.error("ERROR in postRequestWithBody:", ioe);
            }
        } finally {
            close(in);
            close(out);
            if (conex != null) {
                conex.disconnect();
            }
        }
        if (response == null) {
            response = "";
        }
        toFile.append(response);
        Youtube.write2File(toFile);
        return response;
    }
    
    @Override
    public void authenticate(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String code = request.getParameter("code");
        //System.out.println("Entra al metodo authenticate ...codigo" + code);
        PrintWriter out = response.getWriter();
        String clientId = getAppKey();
        String clientSecret = getSecretKey();
        //String developerKey = getDeveloperKey();
        String uri = getRedirectUrl(request, paramRequest);
        //YouTube no permite enviarle una url dinamica por lo cual se envia a un jsp y nuevamnete se redirecciona
        //String uriTemp = "http://localhost:8080/work/models/SWBAdmin/jsp/oauth/callback.jsp";
        String uriTemp = "http://" + request.getServerName() + ":" + request.getServerPort() + SWBPortal.getWebWorkPath() + "/models/SWBAdmin/jsp/oauth/callback.jsp";
        //Se crea una variable de sesion para recuperar en el jsp la url dinamica
        HttpSession session = request.getSession(true);
        session.setAttribute("redirectYouTube", uri);


        if (code == null) {
            //https://gdata.youtube.com+
            //https://www.googleapis.com/auth/userinfo.email+
            //https://www.googleapis.com/auth/userinfo.profile
            
            out.println("<script type=\"text/javascript\">");
            out.println("   location.href='"+ "https://accounts.google.com/o/oauth2/auth?client_id=" +
                    clientId + "&redirect_uri=" + uriTemp +
                    "&response_type=code&scope=https://www.googleapis.com/auth/youtube+https://www.googleapis.com/auth/youtube.readonly+https://www.googleapis.com/auth/youtube.upload+https://www.googleapis.com/auth/youtube.force-ssl" +
                    "&access_type=offline&state=/profile'");
            out.println("</script>");
        } else {
            Map<String, String> params = new HashMap<String, String>();
            params.put("code", code);
            params.put("client_id", clientId);
            params.put("client_secret", clientSecret);
            params.put("redirect_uri", uriTemp);
            params.put("grant_type", "authorization_code");
            //params.put("access_type", "offline");
            try {
                //"https://accounts.google.com/o/oauth2/token"
                String res = postRequest(params, "https://accounts.google.com/o/oauth2/token", Youtube.USER_AGENT, "POST");
                //System.out.println("respuesta" + res);

                JSONObject userData = new JSONObject(res);
                String tokenAccess = userData.getString("access_token");
                String token_type = userData.getString("token_type");
                String refresh_token = "";
                if (userData.has("refresh_token") && !userData.isNull("refresh_token")) {
                    refresh_token = userData.getString("refresh_token");
                }

                this.setAccessToken(tokenAccess);
                this.setAccessTokenSecret(refresh_token);
                if (!refresh_token.isEmpty()) {
                    this.setRefreshToken(refresh_token);
                } else {//Si ya no viene el refresh token entonces hay que validar si esa cuenta ya esta dada de alta
                    //en social. Se puede ver a quien pertenece un token usando el endpoint 'tokeninfo'
                }
                setSn_authenticated(true);
                /*
                System.out.println("refresh token: " + refresh_token);
                System.out.println("token access:  " + tokenAccess);
                System.out.println("tipo de token: " + token_type);
                System.out.println("developer key: " + developerKey);
                * */

            } catch (Exception ex) {
                System.out.println("Error en la autenticacion: " + ex);
                Youtube.log.error(ex);
            } finally {
                out.println("<script type=\"text/javascript\">");
                out.println("try{" +
                    "var form = window.opener.document.getElementById('authNet/"+ this.getEncodedURI() + "');\n"+
                    "if (form.onsubmit){"+
                        "var result = form.onsubmit.call(form);" +
                    "}" +
                    "if (result !== false){" +
                        "form.submit();" +
                    "}"+
                    "window.close();" +
                "}catch(e){window.opener=self; window.close();}");
                out.println("</script>");
            }
        }
    }

    private Date getLastVideoID(Stream stream) {
        Date lastVideoID = new Date(0L);
        //System.out.println("entrando al metodo getLastVideoID....");
        SocialNetStreamSearch socialStreamSerch = SocialNetStreamSearch.getSocialNetStreamSearchbyStreamAndSocialNetwork(stream, this);
        //System.out.append("NDTS:" + socialStreamSerch.getNextDatetoSearch());
        //socialStreamSerch.setNextDatetoSearch("2013-06-17T15:42:09.000Z");
        //if(1==1)return;

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        //formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
        try {
            if (socialStreamSerch != null && socialStreamSerch.getNextDatetoSearch() != null) {
                //socialStreamSerch.setNextDatetoSearch("2000-07-11T23:05:31.000Z");
                lastVideoID = formatter.parse(socialStreamSerch.getNextDatetoSearch());
                //System.out.println("RECOVERING NEXTDATETOSEARCH: " + socialStreamSerch.getNextDatetoSearch());
            } else {
                lastVideoID = new Date(0L);
            }
        } catch (NumberFormatException nfe) {
            lastVideoID = new Date(0L);
            Youtube.log.error("Error in getLastVideoID():" + nfe);
            //System.out.println("Invalid value found in NextDatetoSearch(). Set:" + lastVideoID);
        } catch (ParseException pex) {
            Youtube.log.error("Error in parseDate() in getLastVideoID:" + pex);
        }
        return lastVideoID;
    }

    private void setLastVideoID(String dateVideo, Stream stream) {
        //System.out.println("entrando al metodo setLastVideoID....");
        //if(1==1)return;
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            
            // formatter.setTimeZone(TimeZone.getTimeZone("GMT-6"));
            Date storedValue = new Date(0L);
            SocialNetStreamSearch socialStreamSerch = SocialNetStreamSearch.getSocialNetStreamSearchbyStreamAndSocialNetwork(stream, this);
            if (socialStreamSerch != null && socialStreamSerch.getNextDatetoSearch() != null) {
                storedValue = formatter.parse(socialStreamSerch.getNextDatetoSearch());
            }
            //System.out.println("Antes de validar las fechas: ");
            //System.out.println("stored Value : " + storedValue + "  dateVideo:  " + formatter.parse(dateVideo));
            if (formatter.parse(dateVideo).after(storedValue)) {
                //if (storedValue.before(formatter.parse(dateVideo))) { //Only stores tweetID if it's greater than the current stored value
                socialStreamSerch.setNextDatetoSearch(dateVideo);
                //System.out.println("GUARDANDO FECHA!!:" + dateVideo);
            } else {
                //System.out.println("NO ESTÁ GUARDANDO NADA PORQUE EL VALOR ALMACENADO YA ES IGUAL O MAYOR AL ACTUAL");
            }
        } catch (NumberFormatException nfe) {
            Youtube.log.error("Error in setLastVideoID():" + nfe);
        } catch (ParseException pe) {
            Youtube.log.error("Error in parseDate():" + pe);
        }
    }

    /*@Override
     public void listen(Stream stream) {
     System.out.println("Listening from youtube... API V3");
     try {
     // instance of the HTTP transport.
     HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
     // instance of the JSON factory. 
     JsonFactory JSON_FACTORY = new JacksonFactory();
     // instance of the max number of videos we want returned (50 = upper limit per page). 
     long NUMBER_OF_VIDEOS_RETURNED = 50;
     //instance of Youtube object to make all API requests. 
     YouTube youtube;
            
     ArrayList<ExternalPost> aListExternalPost = new ArrayList();
     // Words from stream.
     String searchPhrases = getPhrases(stream.getPhrase());
     System.out.println("searching for phrases:" + searchPhrases);
     DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
     Date lastVideoID = getLastVideoID(stream); //gets the value stored in NextDatetoSearch
     System.out.println("storedVideoID:" + lastVideoID);

     //The YouTube object is used to make all API requests. The last argument is required, but
     //because we don't need anything initialized when the HttpRequest is initialized, we override
     //the interface and provide a no-op function.
             
     youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
     public void initialize(HttpRequest request) throws IOException {}
     }).setApplicationName("SWB Social").build();

     YouTube.Search.List search = youtube.search().list("id,snippet");
            
     //It is important to set your developer key from the Google Developer Console for
     //non-authenticated requests (found under the API Access tab at this link:
     //code.google.com/apis/). This is good practice and increased your quota.
             
     String apiKey = "AIzaSyBQ6hGagr0wcKrWqsXEfFdDad2loLclqT8";//this.getDeveloperKey();
     search.setKey(apiKey);
     search.setQ(searchPhrases);
            
     //We are only searching for videos (not playlists or channels). If we were searching for
     //more, we would add them as a string like this: "video,playlist,channel".
             
     search.setType("video");
     search.setOrder("date");
            
     //search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
     search.setFields("items(id/kind,id/videoId,snippet),nextPageToken");
     search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);            

     boolean canGetMoreVideos = false;
     int totalVideos = 0;
     int iterations = 1;
     do{//Iterate to get blocks of videos
     SearchListResponse searchResponse = search.execute();
     List<SearchResult> searchResultList = searchResponse.getItems();

     if (searchResultList != null){
     Iterator<SearchResult> iteratorSearchResults = searchResultList.iterator();
     if(!iteratorSearchResults.hasNext()) {
     System.out.println(" There aren't any results for your query.");
     canGetMoreVideos = false;
     }else{
     if(searchResultList.size() < NUMBER_OF_VIDEOS_RETURNED){//It got less videos than requested, therefore there are not more
     canGetMoreVideos = false;
     }else{
     if(searchResponse.getNextPageToken() != null){
     //System.out.println("HAY TOKEN PARA OTRA PAGINA:" + searchResponse.getNextPageToken());
     search.setPageToken(searchResponse.getNextPageToken());
     canGetMoreVideos = true;
     }else{
     canGetMoreVideos = false;
     }
     }
                      
     System.out.println("Iteracion:" + iterations + " Size of Array:" + searchResultList.size());
     while (iteratorSearchResults.hasNext()){
     SearchResult singleVideo = iteratorSearchResults.next();
     ResourceId rId = singleVideo.getId();

     // Double checks the kind is video.
     if (rId.getKind().equals("youtube#video")){
                               
     SearchResultSnippet result = singleVideo.getSnippet();
     ExternalPost external = new ExternalPost();
     Date published = formatter.parse(result.getPublishedAt().toString());
                               
     if(totalVideos == 0){//Set the date of the most recent video
     setLastVideoID(result.getPublishedAt().toString(), stream);
     }
                               
     if (published.before(lastVideoID) || published.equals(lastVideoID)) {
     System.out.println("Terminar la busqueda, limite alcanzado");
     canGetMoreVideos = false;
     break;
     }
                               
     String desc = result.getDescription();
     String title = result.getTitle();
     //Date published = formatter.parse(result.getPublishedAt().toString());
     if(desc == null || desc.trim().equals("")){
     desc = result.getTitle();
     }else{
     desc = title + " / " + desc;
     }
     external.setPostId(rId.getVideoId());
     //System.out.println("$$" + rId.getVideoId() + "$$" + result.getChannelId() + "$$" + result.getChannelTitle() + "$$" + result.getPublishedAt() );
     if(result.getChannelTitle() == null || result.getChannelTitle().isEmpty()){
     external.setCreatorId(result.getChannelId());
     external.setCreatorName(result.getChannelId());
     }else{
     external.setCreatorId(result.getChannelId());
     external.setCreatorName(result.getChannelTitle());
     }
                               
     external.setMessage(desc);
     if(result.getPublishedAt() != null){
     external.setCreationTime(result.getPublishedAt().toString());
     }
     ////////external.setCategory("");
     external.setSocialNetwork(this);
     external.setVideo(BASE_VIDEO_URL + rId.getVideoId());
     external.setPostType(SWBSocialUtil.VIDEO);
     aListExternalPost.add(external);
     totalVideos++;
     }
     }
     }
     }
     iterations++;
     }while(canGetMoreVideos);
     System.out.println("Videos totales:" +  totalVideos);
            
     if (aListExternalPost.size() > 0) {
     //new Classifier(aListExternalPost, stream, this, false);
     }            
     }catch (GoogleJsonResponseException e) {
     System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
     + e.getDetails().getMessage());
     e.printStackTrace();
     } catch (IOException e) {
     System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
     } catch (Throwable t) {
     t.printStackTrace();
     }
     }*/
    
    /**
     * Obtiene informacion de videos en Yutube para analizar y almacenar
     * @param stream 
     */
    @Override
    public void listen(Stream stream) {
        if (!this.isSn_authenticated() || this.getAccessToken() == null ) {
            Youtube.log.event("Not authenticated network: " + getTitle() + "!!!");
            return;
        }
        
        //Valida que este activo el token, de lo contrario lo refresca
        if (!this.validateToken()) {
            Youtube.log.event("Unable to update the access token inside listen Youtube!");
            this.validateToken();
        }
        //Busca en las categorias: Comedy, Film, Music, People
        //Las palabras "america+pumas"
        //https://gdata.youtube.com/feeds/api/videos?v=2&category=Comedy%7CFilm%7CMusic%7CPeople&max-results=50&alt=jsonc&q=%22america+pumas%22&orderby=published&start-index=1
        //Busca en las mismas categorias que la anterior pero con 3 diferentes palabras
        //https://gdata.youtube.com/feeds/api/videos?v=2&category=Comedy%7CFilm%7CMusic%7CPeople&max-results=50&alt=jsonc&q=horse|cat|dog&orderby=published&start-index=1


        //System.out.println("Entra al metodo listen.... Youtube");
        ArrayList<ExternalPost> aListExternalPost = new ArrayList(256);
        String searchPhrases = this.formatsYoutubePhrases(stream);//getPhrases(stream.getPhrase());
        if (searchPhrases == null || searchPhrases.isEmpty()) {
            Youtube.log.warn("\n Not a valid value to make a youtube search:" + searchPhrases);
            return;
        }
        String category = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        DecimalFormat df = new DecimalFormat("#.00");
        if (searchPhrases == null || searchPhrases.isEmpty()) {
            return;
        }
        
//        Iterator<YouTubeCategory> it = this.listYoutubeCategories();
//        if (it.hasNext()) {//The first category
//            category = it.next().getId();
//        }
//
//        while (it.hasNext()) {//More categories
//            category = category + "|" + it.next().getId();
//        }
        SocialSite socialSite = (SocialSite) WebSite.ClassMgr.getWebSite(stream.getSemanticObject().getModel().getName());
        
        int blockOfVideos = 500; //this is the default Value,
        try {
            if (socialSite.getBlockofMsgToClassify() > 0) {
                blockOfVideos = socialSite.getBlockofMsgToClassify();
            }
        } catch (Exception e) {}
        //System.out.println("Message Block Youtube:" + blockOfVideos);
        
        int limit = 500;
        int maxResults = 50;
        //int totalResources = 0;
        boolean canGetMoreVideos = true;
        //int iteration = 1;
        int count = 0;
        Date lastVideoID = this.getLastVideoID(stream); //gets the value stored in NextDatetoSearch
        String index = "";
        boolean breakFor = false;
        String uploadedStr = null; //fecha de publicacion del ultimo video extraido de Youtube
        
        for (int startIndex = 1; startIndex <= limit; startIndex++) {
            // idClave = idClave.replace("|", "/");
            Map<String, String> params = new HashMap<String, String>();
            params.put("part", "id");
            params.put("type", "video");
            params.put("q", searchPhrases);
            params.put("maxResults", String.valueOf(maxResults));
            params.put("order", "date");
            
            //Si se conoce la fecha de publicacion del ultimo video extraido
            if (lastVideoID != null) {
                params.put("publishedAfter", formatter.format(lastVideoID));
            }
            if (!category.isEmpty()) {
                params.put("category", category);
            }
            if (stream.getGeoCenterLatitude() != 0 && stream.getGeoCenterLongitude() != 0 &&
                    stream.getGeoRadio() > 0) {
                if (stream.getGeoRadio() < 50) {//Default value
                    params.put("location", stream.getGeoCenterLatitude() + "," + stream.getGeoCenterLongitude());// + "!"
                    params.put("locationRadius", "50km");
                    //query.setGeoCode(new GeoLocation(stream.getGeoCenterLatitude(), stream.getGeoCenterLongitude()), 50, "km");//(latitude, longitude), radius, units of distance
                } if (stream.getGeoRadio() > 1000) {//Max value
                    params.put("location", stream.getGeoCenterLatitude() + "," + stream.getGeoCenterLongitude());// +"!"
                    params.put("locationRadius", "1000km");
                    //query.setGeoCode(new GeoLocation(stream.getGeoCenterLatitude(), stream.getGeoCenterLongitude()), 50, "km");//(latitude, longitude), radius, units of distance
                } else {
                    params.put("location", stream.getGeoCenterLatitude() + "," + stream.getGeoCenterLongitude());// +"!"
                    params.put("locationRadius", stream.getGeoRadio() + "km");
                    //query.setGeoCode(new GeoLocation(stream.getGeoCenterLatitude(), stream.getGeoCenterLongitude()), stream.getGeoRadio(), "km");//(latitude, longitude), radius, units of distance
                }
            }
            //index contiene el valor de nextPageToken de la respuesta de cada peticion a Youtube
            if (index != null && !index.isEmpty()) {
                params.put("pageToken", index);
            }

            try {
                String videoIds = null;
                String youtubeResponse = this.getRequest(params, Youtube.API_URL + "/search",
                        Youtube.USER_AGENT, "GET");
                //Convertir la String youtubeResponse a un objeto json
                JSONObject resp = new JSONObject(youtubeResponse);
                JSONArray items = null;
                if (resp.has("items")) {
                    items = resp.getJSONArray("items");
                    count = items.length();

                    for (int j = 0; j < count; j++) {
                        JSONObject videoIdentified = items.getJSONObject(j);
                        if (!videoIdentified.isNull("id") && !videoIdentified.getJSONObject("id").isNull("videoId")) {
                            if (count > 0) {
                                videoIds += ("," + videoIdentified.getJSONObject("id").getString("videoId"));
                            } else {
                                videoIds = videoIdentified.getJSONObject("id").getString("videoId");
                            }
                        }
                    }
                }
                if (!resp.isNull("nextPageToken")) {
                    index = resp.getString("nextPageToken");
                } else {
                    breakFor = true;
                }
                
                if (videoIds != null) {
                    Map<String, String> paramsDetail = new HashMap<String, String>();
                    paramsDetail.put("part", "snippet,contentDetails,recordingDetails");
                    paramsDetail.put("id", videoIds);
                    
                    String detailInfo = this.getRequest(paramsDetail, Youtube.API_URL + "/videos",
                            Youtube.USER_AGENT, "GET");
                    JSONObject videosResp = new JSONObject(detailInfo);
                    items = !videosResp.isNull("items") ? videosResp.getJSONArray("items") : null;
                    if (items != null) {
                        count = items.length();
                    } else {
                        count = 0;
                    }
                    
                    for (int i = 0; i < count; i++) {
                        ExternalPost external = new ExternalPost();
                        JSONObject video = items.getJSONObject(i);
                        //System.out.println("TouTube Listen:"+id.toString());
                        String idItem = video.getString("id");
                        JSONObject snippet = video.getJSONObject("snippet");
                        //String uploader = id.getString("uploader");
                        String updatedItem = snippet.getString("publishedAt");
                        String title = snippet.getString("title");
                        String channel = snippet.getString("channelId");
                        String description = snippet.getString("description");
                        if (description == null || description.equals("")) {
                            description = title;
                        } else {
                            description = title + " / " + description;
                        }
                        String categoryItem = snippet.getString("categoryId");
                        uploadedStr = snippet.getString("publishedAt");
                        Double latitude = null;
                        Double longitude = null;
                        
                        if (!video.isNull("recordingDetails")) {
                            JSONObject recDetails = video.getJSONObject("recordingDetails");
                            JSONObject location = !recDetails.isNull("location")
                                                  ? recDetails.getJSONObject("location") : null;
                            if (location != null && !location.isNull("latitude") &&
                                    !location.isNull("longitude")) {
                                latitude = location.getDouble("latitude");
                                longitude = location.getDouble("longitude");
                            }
                        }
                        
                        Date uploaded = formatter.parse(uploadedStr);
                        if (uploaded.before(lastVideoID) || uploaded.equals(lastVideoID)) {
                            //System.out.println("Terminar la busqueda, limite alcanzado");
                            canGetMoreVideos = false;
                            break;
                        } else {
                            external.setPostId(idItem);
//                            external.setCreatorId(uploader);
//                            external.setCreatorName(uploader);
                            
                            external.setUserUrl("https://www.youtube.com/" + channel);
                            external.setPostUrl("https://www.youtube.com/watch?v=" + idItem + "&feature=youtube_gdata");
                            if (uploaded.after(new Date())) {
                                external.setCreationTime(new Date());
                            } else {
                                external.setCreationTime(uploaded);
                            }
                            //external.setUpdateTime(updatedItem);
                            external.setMessage(description);
                            external.setCategory(categoryItem);
                            external.setSocialNetwork(this);
                            external.setVideo(Youtube.BASE_VIDEO_URL + idItem);
                            external.setPostType(SWBSocialUtil.VIDEO);
                            aListExternalPost.add(external);
                            if (latitude != null && longitude != null) {
                                external.setLatitude(latitude);
                                external.setLongitude(longitude);
                                external.setPlace("(" + df.format(latitude) + "," + df.format(longitude) + ")");
                            }
                            //currentVideoID = uploaded;
                        }

                        //totalResources++;
                    }
                    
                    if ((blockOfVideos > 0) && (aListExternalPost.size() >= blockOfVideos)) {//Classify the block of videos
                        //System.out.println("CLASSIFYING:" + aListExternalPost.size());
                        new Classifier((ArrayList <ExternalPost>) aListExternalPost.clone(), stream, this, true);
                        aListExternalPost.clear();
                    }
                    if (!stream.isActive()) {//If the stream has been disabled stop listening
                        canGetMoreVideos = false;
                    }
                    if (canGetMoreVideos == false) {
                        //System.out.println("Terminando... " + "<=" + lastVideoID);
                        break;
                    }
                } else {//There are no video ids to search for
                    canGetMoreVideos = false;
                    break;
                }

                //Si ya no hay mas videos que extraer de Youtube
                if (breakFor) {
                    canGetMoreVideos = false;
                    break;
                }
                
            } catch (Exception e) {
                Youtube.log.error("Error reading Youtube stream ", e);
                canGetMoreVideos = false;
                break;
            }
            startIndex = startIndex + (count - 1);
        }
        //System.out.println("Total Videos in Array: " + aListExternalPost.size());
        if (uploadedStr != null) {
            //iteration = 0;
            //System.out.println("uploaded:" + uploadedStr + " -- " + lastVideoID);
            //System.out.println("Saving: " + uploadedStr);
            this.setLastVideoID(uploadedStr, stream);//uploadedStr
        }

        if (aListExternalPost.size() > 0) {
            new Classifier(aListExternalPost, stream, this, true);
        }
        //System.out.println("Total Videos: " + totalResources);
    }

    private String getPhrases(String stream) {
        String parsedPhrases = null; // parsed phrases 
        if (stream != null && !stream.isEmpty()) {
            String[] phrasesStream = stream.split(","); //Delimiter            
            parsedPhrases = "";
            String tmp;
            int noOfPhrases = phrasesStream.length;
            for (int i = 0; i < noOfPhrases; i++) {
                if(!phrasesStream[i].trim().isEmpty()){
                    tmp = phrasesStream[i].trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for only one space
                    //parsedPhrases += ((tmp.contains(" ")) ? ("\"" + tmp + "\"") : tmp); // if spaces found, it means more than one word in a phrase
                    parsedPhrases += "\"" + tmp + "\""; // if spaces found, it means more than one word in a phrase
                    if ((i + 1) < noOfPhrases) {
                        parsedPhrases += "|";
                    }
                }
            }
        }
        return parsedPhrases;
    }

    /**
     * Determina si un video ya tiene el estado de publicado en Youtube o se esta procesando al momento de la peticion
     * @param postOutNet
     * @return un {@code boolean} que indica si el estado de un video en Youtube es publicado o no
     */
    @Override
    public boolean isPublished(PostOutNet postOutNet) {
        //System.out.println("Entra al metodo isPublished....");
        //System.out.println("El id del video es...." + postOutNet.getPo_socialNetMsgID());

        boolean exit = false;
        String descriptionReason = "";
        int setErr = 0;
        
        try {
            boolean found = false;
            Map<String, String> params = new HashMap<String, String>(2);
            params.put("part", "processingDetails");
            params.put("id", postOutNet.getPo_socialNetMsgID());
            
            String response = this.getRequest(params, Youtube.API_URL + "/videos", Youtube.USER_AGENT, "GET");
            JSONObject jresp = new JSONObject(response);
            if (!jresp.isNull("items") && jresp.getJSONArray("items").length() > 0) {
                JSONObject video = jresp.getJSONArray("items").getJSONObject(0);
                JSONObject processingDet = !video.isNull("processingDetails")
                                           ? video.getJSONObject("processingDetails") : null;
                if (processingDet != null && !processingDet.isNull("processingStatus")) {
                    //La propiedad puede tener los valores: failed, processing, succeeded y terminated
                    found = true;
                    if (processingDet.getString("processingStatus").equalsIgnoreCase("terminated")) {
                        
                    } else if (processingDet.getString("processingStatus").equalsIgnoreCase("failed")) {
                        descriptionReason = processingDet.getString("processingFailureReason");
                        setErr = 1;
                    }
                }
            }
            
//            HttpClient client = new DefaultHttpClient();
//            HttpGet get = new HttpGet("https://gdata.youtube.com/feeds/api/users/default/uploads/" + postOutNet.getPo_socialNetMsgID());
//            get.setHeader("Authorization", "Bearer " + this.getAccessToken());
//            HttpResponse res = client.execute(get);
//            BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
//            //String dcxml = rd.readLine();
//            StringBuilder videoInfo = new StringBuilder();
//            String dcxml;
//            while((dcxml = rd.readLine()) != null) {
//               videoInfo.append(dcxml);
//            }
//            dcxml = videoInfo.toString();
//            //System.out.println("docxml dentro de isPublished:   " + dcxml);
//            if (dcxml.contains("Video not found")) {
//                //   postOutNet.setError(dcxml);
//                exit = true;
//            }
//            Document doc = SWBUtils.XML.xmlToDom(dcxml);
//            doc.getDocumentElement().normalize();
//            NodeList nodosRaiz = doc.getDocumentElement().getChildNodes();
//            String reasonCode = "";
//            for (int i = 0; i < nodosRaiz.getLength(); i++) {
//                Node childNode = nodosRaiz.item(i);
//                if (childNode.getNodeName().equals("app:control")) {
//                    found = true;
//                    //System.out.println("Entra a app:control....");
//                    NodeList children = childNode.getChildNodes();
//                    for (int j = 0; j < children.getLength(); j++) {
//                        Node children2 = children.item(j);
//                        if (children2.getNodeName().equals("yt:state")) {
//                            String name = children2.getAttributes().getNamedItem("name").getTextContent();
//                            //System.out.println("lo que trae yt:state name: " + name);
//                            if (name.equals("processing")) {
//                                //System.out.println("Entra a la validacion de que el name es igual a processing");
//                                //exit = false;
//                            } else {
//                                reasonCode = children2.getAttributes().getNamedItem("reasonCode").getTextContent();
//                                //System.out.println("lo que trae yt:state reasonCode: " + reasonCode);
//                                descriptionReason = children2.getTextContent();
//                                //System.out.println("lo que trae yt:state: " + descriptionReason);
//                                setErr = 1;
//                            }
//                        }
//                    }
//                    break;
//                }
//            }
            if (found == true) {
                //System.out.println("La variable found es true, si encontro un tag llamado app.control");
                if (setErr == 1) {
                    postOutNet.setStatus(0);
                    postOutNet.setError(descriptionReason);
                    exit = true;
                } else {
                    exit = false;
                }
            } else {
                //System.out.println("No encontro un tag app:control....");
                postOutNet.setStatus(1);
                exit = true;
            }
        } catch (Exception e) {
            Youtube.log.error("Can't determine if video is published", e);
        }
        return exit;
    }

    /**
     * Obtiene informacion del perfil de Google Plus, a traves del identificador de usuario de Youtube proporcionado
     * @param userId identificador de usuario de Youtube
     * @return un objeto {@code JSON} con los datos del perfil del usuario de Google Plus correspondiente
     */
    @Override
    public JSONObject getUserInfobyId(String userId) {
        //Realiza la peticion a Youtube para obtener id de Google+
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("part", "contentDetails,statistics");
        params.put("mine", "true");

        JSONObject userInfo = new JSONObject();
        String responseIdGoogle = null;
        String googlePlusUserId = "";

        try {
            responseIdGoogle = this.getRequest(params, Youtube.API_URL + "/channels", Youtube.USER_AGENT, "GET");

            if (responseIdGoogle.equals("")) {
                return userInfo;
            }
            JSONObject parseUsrInfYoutube = null;
            parseUsrInfYoutube = new JSONObject(responseIdGoogle);

            JSONArray items = parseUsrInfYoutube.getJSONArray("items");
            if (items.length() > 0) {
                JSONObject information = items.getJSONObject(0);
                if (!information.isNull("contentDetails")) {
                    String googlePlusId = information.getJSONObject("contentDetails").getString("googlePlusUserId");
                    if (googlePlusId != null && !googlePlusId.equals("")) {
                        userInfo.putOnce("third_party_id", googlePlusId);
                    }
                }
                if (!information.isNull("statistics")) {
                    String subscribers = information.getJSONObject("statistics").getString("subscriberCount");
                    if (subscribers != null && !subscribers.equals("")) {
                        userInfo.putOnce("followers", subscribers);
                    }
                }
            }
//            if (information.has("yt$googlePlusUserId") && !information.isNull("yt$googlePlusUserId")) {
//                googlePlusUserId = information.getJSONObject("yt$googlePlusUserId").getString("$t");
//               userInfo.put("third_party_id", information.getJSONObject("yt$googlePlusUserId").getString("$t"));
//            }
//            if(information.has("yt$statistics") && !information.isNull("yt$statistics")){       
//                userInfo.put("followers", information.getJSONObject("yt$statistics").getString("subscriberCount"));
//            }
            
        } catch (Exception e) {
            //System.out.println("Error getting user information" + e.getMessage());
        }

        //Se realiza la peticion API Google,para obtener los datos de usuario en google+
        if (googlePlusUserId.equals("")) {
            log.error("El usuario " + userId + " no tiene asociado un id de google");
            return userInfo;
        }

        try {
            String googlePlus = getRequest(null, "https://www.googleapis.com/plus/v1/people/" +
                    googlePlusUserId + "?key=AIzaSyBEbVYqvZudUYdt-UeHkgRl-rkvNHCw4Z8", 
                    Youtube.USER_AGENT, "GET");
            JSONObject parseUsrInf = null;
            try {
                parseUsrInf = new JSONObject(googlePlus);
            } catch (JSONException jse) {
                parseUsrInf = new JSONObject();
            }
            //System.out.println(parseUsrInf);
            if (parseUsrInf.has("gender") && !parseUsrInf.isNull("gender")) {
                userInfo.put("gender", parseUsrInf.getString("gender"));
            } else {
                userInfo.put("gender", "");
            }

            if (parseUsrInf.has("relationshipStatus") && !parseUsrInf.isNull("relationshipStatus")) {
                userInfo.put("relationship_status", parseUsrInf.getString("relationshipStatus"));
            } else {
                userInfo.put("relationship_status", "");
            }

            if (parseUsrInf.has("placesLived") && !parseUsrInf.isNull("placesLived")) {
                JSONArray location = parseUsrInf.getJSONArray("placesLived");

                for (int i = 0; i < location.length(); i++) {
                    JSONObject jo = location.getJSONObject(i);

                    if (jo.has("primary") && !jo.isNull("primary")) {
                        userInfo.put("placesLived", jo.getString("value"));
                        break;
                    } else {
                        userInfo.put("placesLived", "");
                    }
                }
            } else {
                userInfo.put("placesLived", "");
            }

            if (parseUsrInf.has("birthday") && !parseUsrInf.isNull("birthday")) {
                String date = parseUsrInf.getString("birthday");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date regresa = sdf.parse(date);
                sdf = new SimpleDateFormat("MM-dd-yyyy");
                date = sdf.format(regresa);
                userInfo.put("birthday", date.replace("-", "/"));
            } else {
                userInfo.put("birthday", "");
            }

        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Youtube.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Youtube.log.error(ex);
        } catch (IOException ex) {
            Youtube.log.error(ex);
        }

        return userInfo;
    }
    
    public YoutubeVideoInfo getVideoFullInfoById(String videoId){
        String response = null;
        YoutubeVideoInfo videoInfo = null;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("id", videoId);
        //Modificar si se necesita mas informacion
        params.put("part", "snippet,status");
        try {
            response = getRequest(params, Youtube.API_URL + "/videos",
                    Youtube.USER_AGENT, getAccessToken());
            videoInfo = new YoutubeVideoInfo( new JSONObject(response));
        }catch (IOException e) {
            log.error("Error getting video information", e);
        } catch (JSONException e) {
            log.error("Error getting video information", e);
        }
        return videoInfo;
    }
    
    public YoutubeChannelInfo getChannelFullInfoById(String ChannelId){
        String response = null;
        YoutubeChannelInfo channelInfo = null;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("id", ChannelId);
        //Modificar si se necesita mas informacion
        params.put("part", "snippet");
        try {
            response = getRequest(params, Youtube.API_URL + "/channels",
                    Youtube.USER_AGENT, getAccessToken());
            channelInfo = new YoutubeChannelInfo( new JSONObject(response));
        }catch (IOException e) {
            log.error("Error getting channels information", e);
        } catch (JSONException e) {
            log.error("Error getting channels information", e);
        }
        return channelInfo;
    }
    
    public YoutubeCommentThreadsInfo getCommentThreadsFullInfoByVideoId(String videoId){
        String response = null;
        YoutubeCommentThreadsInfo commentThreadsInfo = null;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("videoId", videoId);
        //Modificar si se necesita mas informacion
        params.put("part", "snippet");
        try {
            response = getRequest(params, Youtube.API_URL + "/commentThreads",
                    Youtube.USER_AGENT, getAccessToken());
            commentThreadsInfo = new YoutubeCommentThreadsInfo( new JSONObject(response));
        }catch (IOException e) {
            log.error("Error getting commentThreads information", e);
        } catch (JSONException e) {
            log.error("Error getting commentThreads information", e);
        }
        return commentThreadsInfo;
    }
    
    public boolean validateToken() {
        boolean refreshedToken = false;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost("https://www.googleapis.com/oauth2/v2/tokeninfo?access_token=" + this.getAccessToken());
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = client.execute(post, responseHandler);
            //System.out.println("la respuesta es: " + responseBody);
            refreshedToken = true;//No exception thrown, the token is fine
            //TODO: validate status of the token :)
        } catch (HttpResponseException e) {
            //System.out.println("Msg" + e.getMessage());
            //System.out.println("Error code" + e.getStatusCode());
            if (e.getStatusCode() == 400) {
                //System.out.println("entra al error 400....");
                try {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("refresh_token", this.getRefreshToken());
                    params.put("client_id", this.getAppKey());
                    params.put("client_secret", this.getSecretKey());
                    params.put("grant_type", "refresh_token");
                    String res = postRequest(params, "https://accounts.google.com/o/oauth2/token",
                            Youtube.USER_AGENT, "POST");
                    //System.out.println("respuesta de peticion del token nuevo" + res);
                    JSONObject userData = new JSONObject(res);
                    String tokenAccess = userData.getString("access_token");
                    this.setAccessToken(tokenAccess);
                    refreshedToken = true;
                } catch (IOException io) {
                    Youtube.log.error("Error en la peticion del nuevo accessToken", io);
                } catch (JSONException ex) {
                    Youtube.log.error("Error en la respuesta del nuevo accessToken", ex);
                }
            }
        } catch (IOException ex) {
            Youtube.log.error("Error validating token: ", ex);
        }
        return refreshedToken;
    }

    /**
     * Publica un comentario en Youtube y lo asocia al video correspondiente
     * @param message el {@code Message} que contiene el texto a publicar, asi como el identificador del video
     *                al que se desea asociar el comentario.
     */
    @Override
    public void postMsg(Message message) {
        
        StringBuilder toFile = new StringBuilder(128);
        
        if (!isSn_authenticated() || getAccessToken() == null ) {
            Youtube.log.error("Not authenticated network: " + getTitle() + ". Unable to post Comment");
            return;
        }
        //System.out.println("Posting comment to a video");
        if (message != null && message.getMsg_Text() != null && message.getMsg_Text().trim().length() > 1) {
            if (message.getPostInSource() != null && message.getPostInSource().getSocialNetMsgId() != null) {
                String messageText = this.shortMsgText(message);
                //message.setMsg_Text(messageText);
                //System.out.println("Youtube Making comment:...:" + message.getPostInSource().getPostInSocialNetworkUser().getSnu_name());
                String videoId = message.getPostInSource().getSocialNetMsgId();
                //String comment = message.getMsg_Text();
                
                String urlLocalPost = "";
                Iterator<String> files = message.listFiles();
                if(files.hasNext()){//If at least one file found
                    String absolutePath = SWBPortal.getEnv("swbsocial/absolutePath") == null
                            ? "" : SWBPortal.getEnv("swbsocial/absolutePath");
                    urlLocalPost = absolutePath + "/es/SWBAdmin/ViewPostFiles?uri=" +
                            message.getEncodedURI() + "&neturi=" + this.getEncodedURI();
                    urlLocalPost = SWBSocialUtil.Util.shortSingleUrl(urlLocalPost);
                    messageText += " " + urlLocalPost;
                }
                
                if (!this.validateToken()) {
                    Youtube.log.error("Unable to update the access token inside post Comment!");
                    return;
                }
                
                //String urlComment = "https://gdata.youtube.com/feeds/api/videos/" + videoId + "/comments";
                String urlComment = Youtube.API_URL + "/commentThreads?part=id&shareOnGooglePlus=false";
                URL url;
                HttpURLConnection conn = null;
                try {
                    url = new URL(urlComment);
                    conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setUseCaches(false);
                    conn.setRequestProperty("Host", Youtube.HOST);
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
                    toFile.append(urlComment);
                    toFile.append("\n");
                    
                    Iterator<String> it = conn.getRequestProperties().keySet().iterator();
                    while (it.hasNext()) {
                        String key = it.next();
                        toFile.append(key);
                        toFile.append(": ");
                        toFile.append(conn.getRequestProperties().get(key));
                        toFile.append("\n");
                    }

                    JSONObject commSnippet = new JSONObject();
                    commSnippet.put("textOriginal", messageText);
                    JSONObject topLevelComment = new JSONObject();
                    topLevelComment.put("snippet", commSnippet);
                    JSONObject snippet = new JSONObject();
                    snippet.put("channelId", videoId);
                    snippet.put("isPublic", true);
                    snippet.put("videoId", videoId);
                    snippet.put("topLevelComment", topLevelComment);
                    JSONObject jComment = new JSONObject();
                    jComment.put("snippet", snippet);
                    
                    DataOutputStream writer = new DataOutputStream(conn.getOutputStream());
////                    String xml = "<?xml version=\"1.0\"?>"
////                        + "<entry xmlns=\"http://www.w3.org/2005/Atom\""
////                        + " xmlns:yt=\"http://gdata.youtube.com/schemas/2007\">"
////                        + "<content>" + messageText + "</content>"
////                        + "</entry>";
//                    writer.write(xml.getBytes("UTF-8"));
                    writer.write(jComment.toString().getBytes("UTF-8"));
                    writer.flush();
                    writer.close();
                    BufferedReader readerl = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                    String commentIdCreated = readerl.readLine();
                    StringBuilder commentInfo = new StringBuilder();
                    String docxml;
                    while((docxml = readerl.readLine()) != null) {
                       commentInfo.append(docxml);
                    }
                    JSONObject comment = new JSONObject(commentInfo.toString());

                    if (!comment.isNull("id")) {
                        String commentId = comment.getString("id");
                        SWBSocialUtil.PostOutUtil.savePostOutNetID(message, this, commentId, null);
                    }
                    
                    //SWBSocialUtil.PostOutUtil.savePostOutNetID(message, this, String.valueOf(longStat), null);
//                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//                    DocumentBuilder builder;
//                    builder = factory.newDocumentBuilder();
//                    Document xmlDoc = builder.parse(new InputSource(new StringReader(docxml)));
//                    xmlDoc.getDocumentElement().normalize();
//                    NodeList rootNode = xmlDoc.getDocumentElement().getChildNodes();
//
//                    for (int tmp = 0; tmp < rootNode.getLength(); tmp++) {
//                        Node nNode= rootNode.item(tmp);
//                        if (nNode.getNodeName().equals("id")) {
//                            //System.out.println("id-->" + nNode.getTextContent());
//                            if (nNode.getTextContent().contains("comment:")) {
//                                String commentId = nNode.getTextContent().substring(nNode.getTextContent().indexOf("comment:") + 8);
//                                SWBSocialUtil.PostOutUtil.savePostOutNetID(message, this, commentId, null);
//                                //System.out.println("ID-->" + commentId + "<--");
//                                break;
//                            }
//                        }
//                    }
                    toFile.append(conn.getResponseMessage());
                    Youtube.write2File(toFile);
                } catch (Exception ex) {
                    SWBSocialUtil.PostOutUtil.savePostOutNetID(message, this, null, ex.getMessage());
                    Youtube.log.error("Problem posting comment ", ex);
                    try {
                        if (conn.getResponseMessage() != null) {
                            Youtube.log.error("Error code:" + conn.getResponseCode() + " " + conn.getErrorStream(), ex);
                        }
                    } catch (Exception e) {
                        Youtube.log.error("Reading data from connexion", e);
                    }
                }
            } else {
                Youtube.log.error("Youtube only allows comment to a video not POSTS!");
            }
        }
    }
    
    private String privacyValue(PostOut postout) {
        
        Iterator<PostOutPrivacyRelation> privacyRelation = PostOutPrivacyRelation.ClassMgr.
                listPostOutPrivacyRelationByPopr_postOut(postout);
        String privacy = "";
        try {
            while(privacyRelation.hasNext()) {
                PostOutPrivacyRelation privacyR = privacyRelation.next();
                if (privacyR.getPopr_socialNetwork().getURI().equals(this.getURI())) {
                    if (privacyR.getPopr_privacy() != null) {
                        privacy = privacyR.getPopr_privacy().getId();
                    }
                }
            }
        } catch(Exception e) {
            Youtube.log.error("Problem setting privacy:", e );
        }
        //System.out.println("PRIVACY:" + privacy);
        return privacy;
    }

    @Override
    public HashMap monitorPostOutResponses(PostOut postOut) {
        //throw new UnsupportedOperationException("Not supported yet.");
        HashMap hMapPostOutNets = new HashMap();
        Iterator<PostOutNet> itPostOutNets=PostOutNet.ClassMgr.listPostOutNetBySocialPost(postOut);
        
        if(!this.validateToken()){
            log.error("Unable to update the access token inside post Comment!");
            return hMapPostOutNets;
        }
        
        while(itPostOutNets.hasNext())
        {
            PostOutNet postOutNet=itPostOutNets.next();
            if(postOutNet.getStatus()==1 && postOutNet.getSocialNetwork().getURI().equals(this.getURI()))
            {
                //System.out.println("********** Monitoreando RESPUESTAS de " + postOutNet.getPo_socialNetMsgID() + "*************");
                
                long totalComments = this.comments(postOutNet.getPo_socialNetMsgID());
                //El número que se agrega es la diferencia entre el número de respuesta encontradas en la red social - el que se encuentra en la propiedad postOutNet.getPo_numResponses()
                
                if(totalComments > 0){
                    if(postOutNet.getPo_numResponses() > 0){//Si ya había respuestas
                        if(postOutNet.getPo_numResponses() < totalComments){//Si hay respuestas nuevas
                            hMapPostOutNets.put(postOutNet.getURI(), totalComments - postOutNet.getPo_numResponses());
                        }
                    }else if(postOutNet.getPo_numResponses() == 0){//Si no había respuestas
                        hMapPostOutNets.put(postOutNet.getURI(), totalComments);
                    }
                    postOutNet.setPo_numResponses((int)totalComments);
                }
            }
        }
        return hMapPostOutNets;
    }
    
    /**
     * Calcula el total de comentarios publicados asociados a un video.
     * @param videoId identificador del video del cual se desea conocer el número de comentarios asociados
     * @return el numero de comentarios publicados asociados al video identificado por el valor de {@code videoId}
     */
    public long comments(String videoId) {
        long totalComments = 0L;
        HashMap<String, String> params = new HashMap<String, String>(4);
        params.put("part", "id");
        params.put("videoId", videoId);//alt
        //params.put("start-index","1");//alt
        params.put("maxResults", "1");//alt
        try {
            //String video = getcommentsFromVideoId(videoId);
            //"https://gdata.youtube.com/feeds/api/videos/" + id +"/comments"
            String comThreads = this.getRequest(params, Youtube.API_URL + "/commentThreads",
                                       Youtube.USER_AGENT, "GET");
            JSONObject threadsResp = new JSONObject(comThreads);
            if (!threadsResp.isNull("items")) {
                JSONArray threadsArray = threadsResp.getJSONArray("items");
                //de cada elemento del array, se obtiene el total de comentarios para sumarlos
                for (int i = 0; i < threadsArray.length(); i++) {
                    JSONObject thread = threadsArray.getJSONObject(i);
                    JSONObject threadSnippet = !thread.isNull("snippet") ? thread.getJSONObject("snippet") : null;
                    if (threadSnippet != null && !threadSnippet.isNull("videoId") &&
                            threadSnippet.getString("videoId").equalsIgnoreCase(videoId)) {
                        String threadId = thread.getString("id");
                        totalComments++;
                    }
                    if (threadSnippet != null && !threadSnippet.isNull("totalReplyCount")) {
                        totalComments += threadSnippet.getInt("totalReplyCount");
                    }
                }
            }
        //System.out.println("YOUTUBE:" + videoId + " AND THE NUMBER:" + totalComments);
        } catch (Exception e) {
            Youtube.log.error("Youtube: Not data found for -> " + videoId, e);
        }
        return totalComments;
    }

    /**
     * 
     * @param id
     * @param accessToken
     * @return 
     */
//    public String getcommentsFromVideoId(String id) {
//        
//        HashMap<String, String> params = new HashMap<String, String>(4);
//        params.put("part", "id");
//        params.put("videoId", id);//alt
//        //params.put("start-index","1");//alt
//        params.put("maxResults", "1");//alt
//    
//        String response = null;
//        try {
//            //"https://gdata.youtube.com/feeds/api/videos/" + id +"/comments"
//            response = this.getRequest(params, Youtube.API_URL + "/commentThreads",
//                                       Youtube.USER_AGENT, "GET");
//        } catch (Exception e) {
//            System.out.println("Error getting video information"  + e.getMessage());
//        }
//        return response;
//    }
    
    public String getRequestVideo(Map<String, String> params, String url,
            String userAgent, String accessToken) throws IOException {
        
        CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = new URL(url + "?" +  paramString);       
        //System.out.println("URL:" +  serverUrl);
        StringBuilder toFile = new StringBuilder(128);
        toFile.append(url + "?" +  paramString);
        
        HttpURLConnection conex = null;
        InputStream in = null;
        String response = null;
       
        try {
            conex = (HttpURLConnection) serverUrl.openConnection();
            if (userAgent != null) {
                conex.setRequestProperty("user-agent", userAgent);                
            }
            ///Validate if i am looking for the default user or another
            if(accessToken != null){
                conex.setRequestProperty("Authorization", "Bearer " + accessToken);
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
                //System.out.println("\n\n\nERROR:" +   response);
            }
        } finally {
            close(in);
            if (conex != null) {
                conex.disconnect();
            }
        }
        if (response == null) {
            response = "";
        }
        toFile.append("\n");
        toFile.append(response);
        Youtube.write2File(toFile);
        return response;
    }
    
    //Klout
    @Override
    public double getUserKlout(String youtubeUserID) {
       String userThird_party_id=null;
       WebSite wsite=WebSite.ClassMgr.getWebSite(this.getSemanticObject().getModel().getName());
       SocialNetworkUser socilNetUser=getThird_party_id(youtubeUserID, wsite);
       if(socilNetUser!=null)
       {
           if(socilNetUser.getSnu_third_party_id()!=null)
           {
               userThird_party_id=socilNetUser.getSnu_third_party_id();
           }
       }
       if(userThird_party_id==null)
       {
           //Hacer conexión vía directa a Google+ para obtener Third_party_id del usuario en cuestion.
           userThird_party_id=getYouTubeThird_party_id(youtubeUserID);
       }
        
       if(userThird_party_id!=null)
       {
            String url_1="http://api.klout.com/v2/identity.json/gp/"+userThird_party_id;
            String kloutJsonResponse_1=getData(url_1);
            //System.out.println("kloutResult step-1:"+kloutJsonResponse_1);

            //Obtener id de json
            try
            {
                if(kloutJsonResponse_1!=null)
                {
                    JSONObject userData = new JSONObject(kloutJsonResponse_1);
                    String kloutUserId = userData != null && userData.get("id") != null ? (String) userData.get("id") : "";
                    //System.out.println("kloutId de Resultado en Json:"+kloutUserId);

                    //Segunda llamada a la red social Klout, para obtener Json de Score del usuario (kloutUserId) encontrado
                    if(kloutUserId!=null)
                    {
                        String url_2="http://api.klout.com/v2/user.json/"+kloutUserId+"/score";
                        String kloutJsonResponse_2=getData(url_2);
                        //System.out.println("kloutResult step-2-Json:"+kloutJsonResponse_2);

                        if(kloutJsonResponse_2!=null)
                        {
                             JSONObject userScoreData = new JSONObject(kloutJsonResponse_2);
                             Double kloutUserScore = userScoreData != null && userScoreData.get("score") != null ? (Double) userScoreData.get("score") : 0.00;
                             return Math.rint(kloutUserScore.doubleValue());
                        }
                    }
                }
            }catch(JSONException je)
            {
                
            }
        }
        return 0;
    }
    
    private static String getData(String url)
    {
        String answer = null;
        //String key=SWBContext.getAdminWebSite().getProperty("kloutKey");    //TODO:Ver con Jei x que no funciona esto...
       String key=SWBSocialUtil.getEnv("swbsocial/kloutKey", "8fkzgz7ngf7bth3nk94gnxkd");
        //System.out.println("key para KLOUT--Gg:"+key);
        if(key!=null)
        {
            url=url+"?key="+key;
            URLConnection conex = null;
            try {
                //System.out.println("Url a enviar a Klout:"+url);
                URL pagina = new URL(url);

                String host = pagina.getHost();
                //Se realiza la peticion a la página externa
                conex = pagina.openConnection();
                /*
                if (userAgent != null) {
                    conex.setRequestProperty("user-agent", userAgent);
                }*/
                if (host != null) {
                    conex.setRequestProperty("host", host);
                }
                conex.setDoOutput(true);

                conex.setConnectTimeout(20000); //15 segundos maximo, si no contesta la red Klout, cortamos la conexión
            } catch (Exception nexc) {
                System.out.println("nexc Error:"+nexc.getMessage());
                conex = null;
            }
            //System.out.println("Twitter Klout/conex:"+conex);
            //Analizar la respuesta a la peticion y obtener el access token
            if (conex != null) {
                try
                {
                    //System.out.println("Va a checar esto en Klit:"+conex.getInputStream());
                    answer = getResponse(conex.getInputStream());
                }catch(Exception e)
                {
                    //log.error(e);
                }
                //System.out.println("Twitter Klout/answer-1:"+answer);
            }
        }
        //System.out.println("Twitter Klout/answer-2:"+answer);
        return answer;
    }

    /**
     * Obtiene el identificador de Google+ para el identificador de usuario de Youtube proporcionado
     * @param youtubeUserId identificador de usuario de Youtube
     * @return un {@code String} con el identificador de Google+ correspondiente al identificador
     * de usuario de Youtube proporcionado
     */
    private String getYouTubeThird_party_id(String youtubeUserId) {
        
        String responseIdGoogle = null;
        String idPlus = "";
        HashMap<String, String> params = new HashMap<String, String>(4);
        params.put("part", "contentDetails");
        params.put("id", youtubeUserId);
        params.put("maxResults", "3");

        try {
            responseIdGoogle = this.getRequest(params, Youtube.API_URL + "/channels",
                    Youtube.USER_AGENT, "GET");
            if (responseIdGoogle.equals("")) {
                return idPlus;
            }
            
            JSONObject parseUsrInfYoutube = new JSONObject(responseIdGoogle);
            if (!parseUsrInfYoutube.isNull("items")) {
                JSONArray items = parseUsrInfYoutube.getJSONArray("items");
                for (int i = 0; i < items.length(); i++) {
                    JSONObject item = items.getJSONObject(i);
                    if (!item.isNull("contentDetails") &&
                            !item.getJSONObject("contentDetails").isNull("googlePlusUserId")) {
                        idPlus = item.getJSONObject("contentDetails").getString("googlePlusUserId");
                    }
                    if (!idPlus.equals("")) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error getting user information " + e.getMessage());
        }
        return idPlus;
    }
    
    
    private SocialNetworkUser getThird_party_id(String userId, SWBModel model)
    {
        Iterator<SemanticObject> it=model.getSemanticModel().listSubjects(SocialNetworkUser.social_snu_id, userId); //No encuentra
        while(it.hasNext())
        {
            SemanticObject obj=it.next();
            SocialNetworkUser socialNetUser=(SocialNetworkUser)obj.createGenericInstance();
            //System.out.println("GEOOOOORGGGEEE:socialNetUser.getSnu_SocialNetwork().getId():"+socialNetUser.getSnu_SocialNetworkObj().getId());
            //System.out.println("GEOOOOORGGGEEE:socialNetwork.getSemanticObject().getSemanticClass().getSemanticObject().getId():"+socialNetwork.getSemanticObject().getSemanticClass().getSemanticObject().getId());
            if(socialNetUser.getSnu_SocialNetworkObj()!=null && socialNetUser.getSnu_SocialNetworkObj().getId().equals(this.getSemanticObject().getSemanticClass().getSemanticObject().getId()));
            {
                  return socialNetUser;
            }
        }
        return null;
    }
    
    
    @Override
    public boolean removePostOutfromSocialNet(PostOut postOut, SocialNetwork socialNet) {
        boolean removed = false;
        StringBuilder toFile = new StringBuilder(128);
        try {                        
            Iterator<PostOutNet> ponets = postOut.listPostOutNetInvs();
            while (ponets.hasNext()) {
                PostOutNet postoutnet = ponets.next();
                if (postoutnet.getSocialNetwork().equals(socialNet)) {//PostOut enviado de la red social
                    if (postoutnet.getStatus() == 1) {//publicado
                        //System.out.println("1va a borrar!");
                        if (postoutnet.getPo_socialNetMsgID() != null) {//Tiene id
                            toFile.append(Youtube.API_URL + "/videos  -- " + postoutnet.getPo_socialNetMsgID());
                            toFile.append("\nDELETE");
                            HashMap<String, String> params = new HashMap<String, String>(2);
                            params.put("id", postoutnet.getPo_socialNetMsgID());
                            String response = this.postRequest(params, Youtube.API_URL + "/videos",
                                                Youtube.USER_AGENT, "DELETE");
                            JSONObject jresp = new JSONObject(response);
                            if (!jresp.isNull("id") && jresp.getString("id").equals(postoutnet.getPo_socialNetMsgID())) {
                                removed = true;
                            }
                            
                            
//                            String urlVideo = "http://gdata.youtube.com/feeds/api/users/default/uploads/" + postoutnet.getPo_socialNetMsgID();
//                            URL url;
//                            HttpURLConnection conn = null;
//                            try {
//                                url = new URL(urlVideo);
//                                toFile.append(urlVideo);
//                                toFile.append("\nDELETE");
//                                conn = (HttpURLConnection) url.openConnection();
//                                conn.setDoInput(true);
//                                conn.setDoOutput(true);
//                                conn.setRequestMethod("DELETE");
//                                conn.setUseCaches(false);
//                                conn.setRequestProperty("Host", "gdata.youtube.com");
//                                conn.setRequestProperty("Content-Type", "application/atom+xml");
//                                conn.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
//                                conn.setRequestProperty("GData-Version", "2");
//                                conn.setRequestProperty("X-GData-Key", "key=" + this.getDeveloperKey());
//                                conn.connect();
//                                //System.out.println("Video Borrado:" + getResponse(conn.getInputStream()));
//                                //BufferedReader readerl = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                                //String docxml = readerl.readLine();
//                                //System.out.println("Video Borrado:" + docxml);
//                                toFile.append(conn.getResponseMessage());
//                                toFile.append("\n");
//                                removed = true;
//                            } catch (Exception ex) {
//                                Youtube.log.error("ERROR deleting video", ex);
//                            }
                            toFile.append("Eliminado: " + removed);
                            toFile.append("\n");
                            Youtube.write2File(toFile);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Youtube.log.error("Youtube - Post Not removed!", e);
        }
        return removed;
    }
    
    public String shortMsgText(PostOut postOut){
        SocialSite socialSite = SocialSite.ClassMgr.getSocialSite(postOut.getSemanticObject().getModel().getName());                
        String msgText = postOut.getMsg_Text();
        WebSite admin = SWBContext.getAdminWebSite();
        WebPage linksRedirector  = admin.getWebPage("linksredirector");
        String absolutePath = SWBPortal.getEnv("swbsocial/absolutePath") == null ? "" : SWBPortal.getEnv("swbsocial/absolutePath");
        
        Iterator<PostOutLinksHits> savedLinks = PostOutLinksHits.ClassMgr.listPostOutLinksHitsByPostOut(postOut, socialSite);
        while(savedLinks.hasNext()){
            PostOutLinksHits savedLink = savedLinks.next();
            //System.out.println("--->" + savedLink);
            if(savedLink.getSocialNet().getURI().equals(this.getURI())){//La misma red
                if(msgText.contains(savedLink.getTargetUrl())){//La url existe                    
                    String targetUrl = absolutePath + linksRedirector.getUrl() + "?uri=" + postOut.getEncodedURI() + "&code=" + savedLink.getPol_code() + "&neturi=" + this.getEncodedURI();                    
                    //System.out.println("\n\n---------------\ntarget:" + targetUrl);
                    targetUrl = SWBSocialUtil.Util.shortSingleUrl(targetUrl);                    
                    //System.out.println("shorted:" + targetUrl);
                    msgText = msgText.replace(savedLink.getTargetUrl(), targetUrl);
                    //System.out.println("msg:" + targetUrl);
                }
            }
        }
        //System.out.println("RETURNED MESSAGE:" + msgText);
        return msgText;
    }
    
    /**
     * Formats phrases according to Query requirements.
     * takes all the phrases from the search fields and formats the 'words' according to 
     * the twitter requirements.
     * @param stream
     * @return Formated phrases.
     */
    private String formatsYoutubePhrases(Stream stream){
        String parsedPhrases = ""; // parsed phrases - the result
        String orPhrases = "";
        String exactPhrases = "";
        String notPhrases = "";
        String allPhrases ="";

        if(stream.getPhrase() != null && !stream.getPhrase().trim().isEmpty()){//OR (Default)
            orPhrases = stream.getPhrase();            
            orPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(orPhrases);
            orPhrases = orPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for one only one space
            String words[] = orPhrases.split(" ");
            int wordsNumber = words.length;
            String tmpString = "";
            for (int i = 0; i < wordsNumber; i++) {
                if(!words[i].trim().isEmpty()){ 
                    tmpString += words[i];
                    if ((i + 1) < wordsNumber) {
                        tmpString += "|";
                    }
                }
            }
            orPhrases = tmpString;
        }
        
        if(stream.getStream_allPhrases() != null && !stream.getStream_allPhrases().trim().isEmpty()){//All phrases
            allPhrases = stream.getStream_allPhrases();
            allPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(allPhrases);
            allPhrases = allPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for only one space
            String words[] = allPhrases.split(" ");
            int wordsNumber = words.length;
            String tmpString = "";
            for (int i = 0; i < wordsNumber; i++) {
                if(!words[i].trim().isEmpty()){
                    tmpString += words[i];
                    if ((i + 1) < wordsNumber) {
                        tmpString += " ";
                    }
                }
            }
            allPhrases = tmpString;
        }
        if(stream.getStream_notPhrase() != null && !stream.getStream_notPhrase().trim().isEmpty()){//Not phrases
            notPhrases = stream.getStream_notPhrase();
            notPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(notPhrases);
            notPhrases = notPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for one only one space
            String words[] = notPhrases.split(" ");
            int wordsNumber = words.length;
            String tmpString = "";
            for (int i = 0; i < wordsNumber; i++) {
                if(!words[i].trim().isEmpty()){
                    tmpString += ( i>0 ? " " : "") + "-" + words[i];
                }
            }
            notPhrases = tmpString;
        }
        if(stream.getStream_exactPhrase() != null && !stream.getStream_exactPhrase().trim().isEmpty()){//Exact phrase
            exactPhrases = stream.getStream_exactPhrase();
            exactPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(exactPhrases);
            exactPhrases = exactPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for one only one space
            exactPhrases = "\"" + exactPhrases + "\"";
        }

        if(!allPhrases.isEmpty()){
            parsedPhrases += allPhrases;
        }
        
        if(!exactPhrases.isEmpty()){
            if(parsedPhrases.isEmpty()){
                parsedPhrases = exactPhrases;
            }else{
                parsedPhrases += " " + exactPhrases;
            }
        }
        
        if(!orPhrases.isEmpty()){
            if(parsedPhrases.isEmpty()){
                parsedPhrases = orPhrases;
            }else{
                parsedPhrases += " " + orPhrases;
            }
        }

        if(!notPhrases.isEmpty()){
            if(parsedPhrases.isEmpty()){
                parsedPhrases = notPhrases;
            }else{
                parsedPhrases += " " + notPhrases;
            }
        }
        
        //System.out.println("Youtube Final String-->" + parsedPhrases + "<-");        
        return parsedPhrases;
    }
    
    /**
     * Escribe en un archivo el contenido de {@code toFile}
     * @param toFile el contenido a ser agregado en el archivo
     */
    public static void write2File(StringBuilder toFile) {
        
        File file = new File("D:\\lacarpeta\\sistemas\\documentos\\Social\\docs\\youtube\\APIv2.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(toFile.toString());
            writer.write("\n");
        } catch (IOException ioe) {
            Youtube.log.error("Al abrir el archivo", ioe);
        }
    }
    
    /**
     * Agrega a la lista de favoritos del usuario autenticado en Youtube, el video identificado por {@code videoId}
     * @param videoId identificador del video que se desea agregar a la lista de favoritos
     * @return el identificador del elemento {@literal playlistItem} creado como resultado de la operacion
     */
    public String addFavorite(String videoId) {
        
        String favoriteAdded = null;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("part", "id,contentDetails");
        params.put("mine", "true");
        
        try {
            String ytResponse = this.getRequest(params, Youtube.API_URL + "/channels",
                                                           Youtube.USER_AGENT, "GET");
            JSONObject channelsResponse = new JSONObject(ytResponse);
            JSONArray channelLists = null;
            if (!channelsResponse.isNull("items")) {
                channelLists = channelsResponse.getJSONArray("items");
            }
            if (channelLists != null && channelLists.length() > 0) {
                for (int i = 0; i < channelLists.length(); i++) {
                    JSONObject channel = channelLists.getJSONObject(i);
                    String favoritesList = null;
                    if (!channel.isNull("contentDetails") &&
                            !channel.getJSONObject("contentDetails").isNull("relatedPlaylists")) {
                        JSONObject relatedLists = channel.getJSONObject("contentDetails").getJSONObject("relatedPlaylists");
                        favoritesList = !relatedLists.isNull(("favorites")) 
                                        ? relatedLists.getString("favorites") : null;
                    }
                    //De cada canal, se obtiene la lista de videos cargados
                    if (favoritesList != null) {
                        HashMap<String, String> favParams = new HashMap<String, String>(2);
                        favParams.put("part", "snippet");
                        
                        JSONObject favorite = new JSONObject();
                        JSONObject snippet = new JSONObject();
                        JSONObject resourceId = new JSONObject();
                        snippet.put("playlistId", favoritesList);
                        resourceId.put("kind", "youtube#video");
                        resourceId.put("videoId", videoId);
                        snippet.put("resourceId", resourceId);
                        favorite.put("snippet", snippet);
                        
                        String addingResponse = this.postRequestWithBody(favParams,
                                Youtube.API_URL + "/playlistItems", favorite, Youtube.USER_AGENT, "POST");
                        try {
                            JSONObject response = new JSONObject(addingResponse);
                            if (!response.isNull("id")) {
                                favoriteAdded = response.getString("id");
                                break;
                            }
                        } catch (JSONException jsone) {
                            Youtube.log.event("Unexpected response at adding a favorite in Youtube: " +
                                              addingResponse, jsone);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Youtube.log.error("Adding a favorite", e);
        }
        return favoriteAdded;
    }
}
