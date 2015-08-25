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

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.InputStreamContent;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
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
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.HttpResponseException;
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
import com.google.api.services.youtube.model.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Youtube extends org.semanticwb.social.base.YoutubeBase {

    
    private static final Logger log = SWBUtils.getLogger(Youtube.class);
    
    static String UPLOAD_URL = "http://uploads.gdata.youtube.com/feeds/api/users/default/uploads";
    
    /**
     * URL para visualizar un video de Youtube dentro de su pagina
     * [{@literal http://www.youtube.com/v/}]
     */
    public static String BASE_VIDEO_URL = "http://www.youtube.com/v/";

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

    /**
     * Realiza la publicacion de un video en Youtube
     * @param video contiene los metadatos del video a publicar asi como el archivo del video
     */
    @Override
    public void postVideo(Video video) {
        if (!isSn_authenticated() || getAccessToken() == null ) {
            Youtube.log.error("Not authenticated network: " + this.getTitle() + ". Unable to post Video");
            return;
        }
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
        }
        
        com.google.api.services.youtube.YouTube apiYoutube = this.getApiYoutubeInstance();
        com.google.api.services.youtube.YouTube.Videos.Insert videosInsert = null;
        
        com.google.api.services.youtube.model.Video apiVideo = new com.google.api.services.youtube.model.Video();
        String privacy = this.privacyValue(video);
        String category = video.getCategory() == null || video.getCategory().isEmpty()
                          ? "22" : video.getCategory();  //Categoria 22 = People & blogs
        
        VideoStatus videoStatus = new VideoStatus();
        videoStatus.setPrivacyStatus(privacy.equalsIgnoreCase("NOT_LISTED") ? "unlisted" : privacy.toLowerCase());
        videoStatus.setEmbeddable(Boolean.TRUE);
        videoStatus.setPublicStatsViewable(Boolean.TRUE);
        apiVideo.setStatus(videoStatus);
        
        VideoSnippet videoSnippet = new VideoSnippet();
        videoSnippet.setTitle(video.getTitle());
        videoSnippet.setDescription(video.getMsg_Text() == null ? "" : video.getMsg_Text());
        String[] tags = video.getTags().split(",");
        List<String> snippetTags = new ArrayList<String>();
        snippetTags.addAll(Arrays.asList(tags));
        videoSnippet.setTags(snippetTags);
        videoSnippet.setCategoryId(category);
        apiVideo.setSnippet(videoSnippet);
        
        String[] arr = video.getVideo().split("\\.");
        String videoType = "video/" + this.getMimeType(arr[1]);
        //System.out.println("Mime type: " + videoType);
        String videoPath = SWBPortal.getWorkPath() + video.getWorkPath() + "/" + video.getVideo();
        SWBFile fileVideo = new SWBFile(videoPath);
        try {
            FileInputStream reader = new FileInputStream(fileVideo);
            InputStreamContent mediaContent = new InputStreamContent(videoType, reader);

            // Insert the video. The command sends three arguments. The first
            // specifies which information the API request is setting and which
            // information the API response should return. The second argument
            // is the video resource that contains metadata about the new video.
            // The third argument is the actual video content.
            videosInsert = apiYoutube.videos()
                    .insert("snippet,status", apiVideo, mediaContent);
            videosInsert.setOauthToken(this.getAccessToken());
            
            // Set the upload type and add an event listener.
            MediaHttpUploader uploader = videosInsert.getMediaHttpUploader();
            
            // Indicate whether direct media upload is enabled. A value of
            // "True" indicates that direct media upload is enabled and that
            // the entire media content will be uploaded in a single request.
            // A value of "False," which is the default, indicates that the
            // request will use the resumable media upload protocol, which
            // supports the ability to resume an upload operation after a
            // network interruption or other transmission failure, saving
            // time and bandwidth in the event of network failures.
            uploader.setDirectUploadEnabled(false);
            
            MediaHttpUploaderProgressListener progressListener = new MediaHttpUploaderProgressListener() {
                public void progressChanged(MediaHttpUploader uploader) throws IOException {
                    switch (uploader.getUploadState()) {
                        case INITIATION_STARTED:
                            Youtube.log.info("Initiation Started");
                            break;
                        case INITIATION_COMPLETE:
                            Youtube.log.info("Initiation Completed");
                            break;
                        case MEDIA_IN_PROGRESS:
                            Youtube.log.info("Upload in progress");
                            Youtube.log.info("Upload percentage: " + uploader.getNumBytesUploaded());
                            break;
                        case MEDIA_COMPLETE:
                            Youtube.log.info("Upload Completed!");
                            break;
                        case NOT_STARTED:
                            Youtube.log.info("Upload Not Started!");
                            break;
                    }
                }
            };
            uploader.setProgressListener(progressListener);
            
            // Call the API and upload the video.
            com.google.api.services.youtube.model.Video returnedVideo = videosInsert.execute();
            if (returnedVideo != null && returnedVideo.getId() != null) {
                SWBSocialUtil.PostOutUtil.savePostOutNetID(video, this, returnedVideo.getId(), null);
            } else {
                Youtube.log.debug("returnVideo es nulo!!!  ...?");
            }
        } catch (NullPointerException npe) {
            Youtube.log.error("Que paso???", npe);
        } catch (GoogleJsonResponseException gjre) {
            Youtube.log.error("GoogleJsonResponseException code: " + 
                              (gjre.getDetails() != null ? gjre.getDetails().getCode() : gjre.getStatusCode()) + " : " +
                              (gjre.getDetails() != null ? gjre.getDetails().getMessage() : gjre.getMessage()), gjre);
            SWBSocialUtil.PostOutUtil.savePostOutNetID(video, this, null, gjre.getMessage());
        } catch (IOException ioe) {
            Youtube.log.error("Problem with video upload", ioe);
        } catch (Throwable t) {
            Youtube.log.error("Throwable: " + t.getMessage(), t);
        }
    }

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

        if (method == null) {
            method = "POST";
        }
        try {
            conex = (HttpURLConnection) serverUrl.openConnection();
            conex.setRequestProperty("Host", Youtube.HOST);
            conex.setRequestProperty("user-agent", userAgent2Use);
            conex.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod(method);
            conex.setDoOutput(true);
            conex.connect();

            in = conex.getInputStream();
            response = Youtube.getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex != null) {
                Youtube.log.error("Ruta soliciatada: " + url + "?" + paramString + "\nERROR in getRequest:" + Youtube.getResponse(conex.getErrorStream()), ioe);
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
        return response;
    }

    private String getRedirectUrl(HttpServletRequest request, SWBParamRequest paramRequest) {
        StringBuilder address = new StringBuilder(128);
        address.append("http://").append(request.getServerName()).append(":");
        address.append(request.getServerPort()).append("/").append(paramRequest.getUser().getLanguage());
        address.append("/").append(paramRequest.getResourceBase().getWebSiteId());
        address.append("/").append(paramRequest.getWebPage().getId()).append("/_rid/");
        address.append(paramRequest.getResourceBase().getId()).append("/_mod/");
        address.append(paramRequest.getMode()).append("/_lang/").append(paramRequest.getUser().getLanguage());
        return address.toString();
    }

    private CharSequence delimit(Collection<Map.Entry<String, String>> entries,
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

        StringBuilder response = new StringBuilder(256);
        if (data != null) {
            Reader in = new BufferedReader(new InputStreamReader(data, "UTF-8"));
            char[] buffer = new char[1000];
            int charsRead = 0;
            while (charsRead >= 0) {
                response.append(buffer, 0, charsRead);
                charsRead = in.read(buffer);
            }
            in.close();
        }
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
            toFile.append("\nHACIENDO PETICION A:**** **** ****\n");
            toFile.append(url);
            toFile.append("\nparamString:\n");
            toFile.append(paramString);
            toFile.append("\n");
            conex = (HttpURLConnection) serverUrl.openConnection();
            int hostIndex = url.indexOf(".com");
            hostIndex = url.indexOf("/", hostIndex);
            String host = url.substring(url.indexOf("://") + 3, hostIndex);
            if (userAgent != null) {
                conex.setRequestProperty("user-agent", userAgent);
            }
            conex.setRequestProperty("Host", host);
            conex.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod(method);
            conex.setDoOutput(true);
            conex.setDoInput(true);
            conex.connect();
            out = conex.getOutputStream();
            out.write(paramString.toString().getBytes("UTF-8"));
            in = conex.getInputStream();
            response = Youtube.getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex != null) {
                response = getResponse(conex.getErrorStream());
                Youtube.log.error("ERROR in Youtube.postRequest() with connexion:\n" + response, ioe);
            } else {
                Youtube.log.error("ERROR in Youtube.postRequest() connexion is null: \n", ioe);
            }
        } catch (Exception e) {
            Youtube.log.error("General ERROR in Youtube.postRequest():\n" + e.getMessage(), e);
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
        toFile.append("------ Inicio respuesta en postRequest ------\n");
        toFile.append(response);
        toFile.append("------ Fin respuesta en postRequest ------\n");
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
    
    /**
     * Realiza los intercambios de informacion entre la aplicacion y Youtube para generar un token valido
     * necesario para realizar peticiones al API de Youtube
     * @param request la peticion HTTP con los datos a utilizar
     * @param response la respuesta HTTP con la informacion correspondiente a la peticion
     * @param paramRequest el objeto propio de SWB con informacion complementaria de la peticion realizada
     * @throws SWBResourceException en caso de ocurrir algun problema con el API de SWB
     * @throws IOException en caso de ocurrir algun problema de lectura/escritura con la respuesta generada
     */
    @Override
    public void authenticate(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String code = request.getParameter("code");
        PrintWriter out = response.getWriter();
        String clientId = this.getAppKey();
        String clientSecret = getSecretKey();
        String uri = getRedirectUrl(request, paramRequest);
        //YouTube no permite enviarle una url dinamica por lo cual se envia a un jsp y nuevamnete se redirecciona
        String uriTemp = "http://" + request.getServerName() + ":" + request.getServerPort() +
                         SWBPortal.getWebWorkPath() + "/models/SWBAdmin/jsp/oauth/callback.jsp";
        //Se crea una variable de sesion para recuperar en el jsp la url dinamica
        HttpSession session = request.getSession(true);
        session.setAttribute("redirectYouTube", uri);


        if (code == null) {
            
            out.println("<script type=\"text/javascript\">");
            out.println("   location.href='"+ "https://accounts.google.com/o/oauth2/auth?client_id=" +
                    clientId + "&redirect_uri=" + uriTemp +
                    "&response_type=code&scope=https://www.googleapis.com/auth/youtube+" +
                    "https://www.googleapis.com/auth/youtube.readonly+https://www.googleapis.com/auth/youtube.upload+" +
                    "https://www.googleapis.com/auth/youtube.force-ssl+https://www.googleapis.com/auth/plus.login" +
                    "&access_type=offline&approval_prompt=force&state=/profile'");
            out.println("</script>");
        } else {
            String emailApp = clientId.substring(0, clientId.indexOf(".apps.googleusercontent.com")) +
                    "@developer.gserviceaccount.com";
            Map<String, String> params = new HashMap<String, String>(8);
            params.put("code", code);
            params.put("client_id", emailApp);//se debe enviar la cuenta de correo de la aplicacion en lugar del Id
            params.put("client_secret", clientSecret);
            params.put("redirect_uri", uriTemp);
            params.put("grant_type", "authorization_code");
            //params.put("access_type", "offline");
            try {
                String res = this.postRequest(params, "https://accounts.google.com/o/oauth2/token", Youtube.USER_AGENT, "POST");
                JSONObject userData = new JSONObject(res);
                String tokenAccess = userData.getString("access_token");
                String refresh_token = "";
                Calendar now = new GregorianCalendar();
                int timeLeft = 0;
                if (userData.has("expires_in")) {
                    timeLeft = userData.getInt("expires_in");
                }
                if (userData.has("refresh_token") && !userData.isNull("refresh_token")) {
                    refresh_token = userData.getString("refresh_token");
                }

                this.setAccessToken(tokenAccess);
                this.setAccessTokenSecret(refresh_token);
                now.add(Calendar.SECOND, timeLeft);
                this.setTokenExpirationDate(now.getTime());
                if (!refresh_token.isEmpty()) {
                    this.setRefreshToken(refresh_token);
                } else {//Si ya no viene el refresh token entonces hay que validar si esa cuenta ya esta dada de alta
                    //en social. Se puede ver a quien pertenece un token usando el endpoint 'tokeninfo'
                }
                setSn_authenticated(true);

            } catch (Exception ex) {
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
        
        Date lastVideoID = new Date();
        SocialNetStreamSearch socialStreamSerch = null;
        try {
            socialStreamSerch = SocialNetStreamSearch.getSocialNetStreamSearchbyStreamAndSocialNetwork(stream, this);
        } catch (NullPointerException npe) {}
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Calendar defaultDate = Calendar.getInstance();
        try {
            if (socialStreamSerch != null && socialStreamSerch.getNextDatetoSearch() != null) {
                lastVideoID = formatter.parse(socialStreamSerch.getNextDatetoSearch());
            } else {
                defaultDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) - 2);
                lastVideoID = defaultDate.getTime();
            }
        } catch (NumberFormatException nfe) {
            defaultDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) - 2);
            lastVideoID = defaultDate.getTime();
            Youtube.log.error("Error in getLastVideoID():" + nfe);
        } catch (ParseException pex) {
            Youtube.log.error("Error in parseDate() in getLastVideoID:" + pex);
        }
        return lastVideoID;
    }

    private void setLastVideoID(String dateVideo, Stream stream) {
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            
            Date storedValue = new Date(0L);
            SocialNetStreamSearch socialStreamSerch = SocialNetStreamSearch.getSocialNetStreamSearchbyStreamAndSocialNetwork(stream, this);
            if (socialStreamSerch != null) {
                if (socialStreamSerch.getNextDatetoSearch() != null) {
                    storedValue = formatter.parse(socialStreamSerch.getNextDatetoSearch());
                } else {
                    storedValue = this.getLastVideoID(stream);
                }
            }
            if (dateVideo != null) {
                if (formatter.parse(dateVideo).after(storedValue)) {
                    socialStreamSerch.setNextDatetoSearch(dateVideo);
                } else {
                    //System.out.println("NO ESTÁ GUARDANDO NADA PORQUE EL VALOR ALMACENADO YA ES IGUAL O MAYOR AL ACTUAL");
                }
            }
        } catch (NumberFormatException nfe) {
            Youtube.log.error("Error in setLastVideoID():" + nfe);
        } catch (ParseException pe) {
            Youtube.log.error("Error in parseDate():" + pe);
        }
    }

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
        ArrayList<ExternalPost> aListExternalPost = new ArrayList(256);
        String searchPhrases = this.formatsYoutubePhrases(stream);//getPhrases(stream.getPhrase());
        if (searchPhrases == null || searchPhrases.isEmpty()) {
            Youtube.log.warn("\nNot a valid value to make a youtube search:" + searchPhrases);
            return;
        }
        String category = "";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        DecimalFormat df = new DecimalFormat("#.00");
        if (searchPhrases.isEmpty()) {
            return;
        }
        
        Iterator<YouTubeCategory> it = this.listYoutubeCategories();
        if (it.hasNext()) {//The first category
            category = it.next().getId();
        }
        while (it.hasNext()) {//More categories
            category = category + "|" + it.next().getId();
        }
        
        SocialSite socialSite = (SocialSite) WebSite.ClassMgr.getWebSite(
                stream.getSemanticObject().getModel().getName());
        
        int blockOfVideos = 500; //this is the default Value,
        try {
            if (socialSite.getBlockofMsgToClassify() > 0) {
                blockOfVideos = socialSite.getBlockofMsgToClassify();
            }
        } catch (Exception e) {}
        
        int limit = 10;
        int maxResults = 50;
        boolean canGetMoreVideos = true;
        int count = 0;
        Date lastVideoID = this.getLastVideoID(stream); //gets the value stored in NextDatetoSearch
        String index = "";
        boolean breakFor = false;
        String uploadedStr = null; //fecha de publicacion del ultimo video extraido de Youtube
        com.google.api.services.youtube.YouTube apiYoutube = this.getApiYoutubeInstance();
        com.google.api.services.youtube.YouTube.Search.List search = null;
        try {
            if (apiYoutube != null) {
                search = apiYoutube.search().list("id");
                search.setOauthToken(this.getAccessToken());
                search.setQ(searchPhrases);
                search.setType("video");
                search.setMaxResults((long) maxResults);
                search.setOrder("date");
            }
        } catch (Exception e) {}
        
        //Se intentaria obtener maximo 500 videos; cada iteracion podria obtener maxResults = 50 y se realizan limit = 10 iteraciones
        for (int startIndex = 1; startIndex <= limit; startIndex++) {
            if (search != null) {
                //Si se conoce la fecha de publicacion del ultimo video extraido
                if (lastVideoID != null) {
                    DateTime since = new DateTime(lastVideoID);
                    search.setPublishedAfter(since);
                }
                if (!category.isEmpty()) {
                    search.setVideoCategoryId(category);
                }
                if (stream.getGeoCenterLatitude() != 0 && stream.getGeoCenterLongitude() != 0 &&
                        stream.getGeoRadio() > 0) {
                    search.setLocation(stream.getGeoCenterLatitude() + "," + stream.getGeoCenterLongitude());
                    if (stream.getGeoRadio() < 50) {//Default value
                        search.setLocationRadius("50km");
                    } if (stream.getGeoRadio() > 1000) {//Max value
                        search.setLocationRadius("1000km");
                    } else {
                        search.setLocationRadius(stream.getGeoRadio() + "km");
                    }
                }
                //index contiene el valor de nextPageToken de la respuesta de cada peticion a Youtube
                if (index != null && !index.isEmpty()) {
                    search.setPageToken(index);
                }
            }

            try {
                String videoIds = null;
                //System.out.println("Objeto creado para busquedas:\n" + search.toString());
                SearchListResponse searchResponse = search.execute();
                //System.out.println("Respuesta:\n" + searchResponse.getPageInfo().toString() + "\n++++++++++++++++++++++++++++++");
                List<SearchResult> searchResultList = searchResponse.getItems();
                if (!searchResultList.isEmpty()) {
                    count = searchResultList.size();
                    Iterator<SearchResult> iteratorSearchResults = searchResultList.iterator();
                    int j = 0;
                    while (iteratorSearchResults.hasNext()) {
                        SearchResult singleVideo = iteratorSearchResults.next();
                        ResourceId rId = singleVideo.getId();
                        if (rId.getKind().equals("youtube#video")) {
                            if (j > 0) {
                                videoIds += ("," + rId.getVideoId());
                            } else {
                                videoIds = rId.getVideoId();
                            }
                            j++;
                        }
                    }
                }
                if (searchResponse.getNextPageToken() != null && !searchResponse.getNextPageToken().isEmpty()) {
                    index = searchResponse.getNextPageToken();
                } else {
                    breakFor = true;
                }
                
                if (videoIds != null) {
                    //System.out.println("Videos to search for: \n" + videoIds);
                    Map<String, String> paramsDetail = new HashMap<String, String>();
                    paramsDetail.put("part", "snippet,contentDetails,recordingDetails");
                    paramsDetail.put("id", videoIds);
                    
                    String detailInfo = this.getRequest(paramsDetail, Youtube.API_URL + "/videos",
                            Youtube.USER_AGENT, "GET");
                    JSONObject videosResp = new JSONObject(detailInfo);
                    JSONArray items = !videosResp.isNull("items") ? videosResp.getJSONArray("items") : null;
                    if (items != null) {
                        count = items.length();
                    } else {
                        count = 0;
                    }
                    
                    for (int i = 0; i < count; i++) {
                        ExternalPost external = new ExternalPost();
                        JSONObject video = items.getJSONObject(i);
                        String idItem = video.getString("id");
                        JSONObject snippet = video.getJSONObject("snippet");
                        String uploader = snippet.getString("channelId");
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
                            canGetMoreVideos = false;
                            break;
                        } else {
                            external.setPostId(idItem);
                            external.setCreatorId(uploader);
                            external.setCreatorName(uploader);
                            
                            external.setUserUrl("https://www.youtube.com/" + channel);
                            external.setPostUrl("https://www.youtube.com/watch?v=" + idItem + "&feature=youtube_gdata");
                            if (uploaded.after(new Date())) {
                                external.setCreationTime(new Date());
                            } else {
                                external.setCreationTime(uploaded);
                            }
                            external.setUpdateTime(uploaded);
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
                        }
                    }
                    if ((blockOfVideos > 0) && (aListExternalPost.size() >= blockOfVideos)) {//Classify the block of videos
                        new Classifier((ArrayList <ExternalPost>) aListExternalPost.clone(), stream, this, true);
                        aListExternalPost.clear();
                    }
                    if (!stream.isActive()) {//If the stream has been disabled stop listening
                        canGetMoreVideos = false;
                    }
                    if (canGetMoreVideos == false) {
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
        if (uploadedStr != null) {
            this.setLastVideoID(uploadedStr, stream);//uploadedStr
        }

        if (aListExternalPost.size() > 0) {
            new Classifier(aListExternalPost, stream, this, true);
        }
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
     * Determina si un video ya tiene el estado de publicado en Youtube o se esta procesando al momento de la peticion.
     * En caso de estarse procesando, este metodo sera ejecutado de nuevo periodicamente.
     * @param postOutNet el objeto a publicarse
     * @return un {@code boolean} que indica si el estado de un video en Youtube es publicado o no
     */
    @Override
    public boolean isPublished(PostOutNet postOutNet) {

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
                    //La propiedad processingStatus puede tener los valores: failed, processing, succeeded y terminated
                    found = true;
                    if (processingDet.getString("processingStatus").equalsIgnoreCase("terminated") ||
                            processingDet.getString("processingStatus").equalsIgnoreCase("succeeded")) {
                        found = false;
                    } else if (processingDet.getString("processingStatus").equalsIgnoreCase("failed")) {
                        descriptionReason = processingDet.getString("processingFailureReason");
                        setErr = 1;
                    }
                }
            }
            //found determina si Youtube no ha terminado de procesar el video
            if (found == true) {
                if (setErr == 1) {
                    postOutNet.setStatus(0);
                    postOutNet.setError(descriptionReason);
                    exit = true;
                } else {
                    exit = false;
                }
            } else {
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
        params.put("id", userId);

        JSONObject userInfo = new JSONObject();
        String responseIdGoogle = null;
        String googlePlusUserId = "";

        try {
            responseIdGoogle = this.getRequest(params, Youtube.API_URL + "/channels", Youtube.USER_AGENT, "GET");

            if (responseIdGoogle == null || responseIdGoogle.equals("") || responseIdGoogle.contains("error")) {
                return userInfo;
            }
            JSONObject parseUsrInfYoutube = null;
            parseUsrInfYoutube = new JSONObject(responseIdGoogle);

            JSONArray items = parseUsrInfYoutube.getJSONArray("items");
            if (items.length() > 0) {
                JSONObject information = items.getJSONObject(0);
                if (!information.isNull("contentDetails") &&
                        information.getJSONObject("contentDetails").has("googlePlusUserId")) {
                    String googlePlusId = information.getJSONObject("contentDetails").getString("googlePlusUserId");
                    if (googlePlusId != null && !googlePlusId.isEmpty()) {
                        userInfo.put("third_party_id", googlePlusId);
                        googlePlusUserId = googlePlusId;
                    }
                }
                if (!information.isNull("statistics")) {
                    String subscribers = information.getJSONObject("statistics").getString("subscriberCount");
                    if (subscribers != null && !subscribers.isEmpty()) {
                        userInfo.put("followers", subscribers);
                    }
                }
            }
            
        } catch (Exception e) {
            Youtube.log.error("Error getting user information", e);
        }

        //Se realiza la peticion API Google,para obtener los datos de usuario en google+
        if (googlePlusUserId.isEmpty()) {
            Youtube.log.error("El usuario " + userId + " no tiene asociado un id de google");
            return userInfo;
        }

        try {
            HashMap<String, String> paramsPlus = new HashMap<String, String>(2);
            paramsPlus.put("access_token", this.getAccessToken());
            String googlePlus = this.getRequest(paramsPlus, "https://www.googleapis.com/plus/v1/people/" +
                    googlePlusUserId, 
                    Youtube.USER_AGENT, "GET");  // + "?key=AIzaSyBEbVYqvZudUYdt-UeHkgRl-rkvNHCw4Z8"
            JSONObject parseUsrInf = null;
            try {
                parseUsrInf = new JSONObject(googlePlus);
            } catch (JSONException jse) {
                parseUsrInf = new JSONObject();
            }
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
            Youtube.log.error("Al extraer datos del usuario de Google+", ex);
        } catch (JSONException ex) {
            Youtube.log.error("Al extraer datos del usuario de Google+", ex);
        } catch (IOException ex) {
            Youtube.log.error("Al extraer datos del usuario de Google+", ex);
        }

        return userInfo;
    }

    /**
     * Obtiene la informacion correspondiente al {@literal snippet} y al objeto {@literal status} 
     * almacenada en Youtube sobre un video
     * @param videoId el identificador del video del cual se desea obtener la informacion
     * @return un objeto {@code YoutubeVideoInfo} con la informacion del video obtenida de Youtube
     */
    public YoutubeVideoInfo getVideoFullInfoById(String videoId) {
        String response = null;
        YoutubeVideoInfo videoInfo = null;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("id", videoId);
        params.put("part", "snippet,status");
        try {
            response = this.getRequest(params, Youtube.API_URL + "/videos",
                                       Youtube.USER_AGENT, "GET");
            videoInfo = new YoutubeVideoInfo(new JSONObject(response));
        } catch (IOException e) {
            Youtube.log.error("Error getting video information", e);
        } catch (JSONException e) {
            Youtube.log.error("Error getting video information", e);
        }
        return videoInfo;
    }
    
    /**
     * Obtiene informacion de Youtube, del canal especificado por el identificador recibido 
     * @param ChannelId identificador del canal del que se desea obtener informacion
     * @return un objeto {@code YoutubeChannelInfo} con la informacion de la respuesta obtenida de Youtube
     */
    public YoutubeChannelInfo getChannelFullInfoById(String ChannelId) {
        String response = null;
        YoutubeChannelInfo channelInfo = null;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("id", ChannelId);
        params.put("part", "snippet");
        try {
            response = this.getRequest(params, Youtube.API_URL + "/channels",
                                       Youtube.USER_AGENT, "GET");
            channelInfo = new YoutubeChannelInfo(new JSONObject(response));
        } catch (IOException e) {
            Youtube.log.error("Error getting channels information", e);
        } catch (JSONException e) {
            Youtube.log.error("Error getting channels information", e);
        }
        return channelInfo;
    }
    
    /**
     * Obtiene los comentarios de primer nivel asociados a un video de Youtube en particular. El numero de
     * comentarios obtenidos es el maximo por defecto en Youtube (20).
     * @param videoId el identificador del video del cual se desea obtener los comentarios asociados
     * @return un objeto {@code YoutubeCommentThreadsInfo} con la respuesta, en formato JSON, a la peticion hecha a Youtube
     */
    public YoutubeCommentThreadsInfo getCommentThreadsFullInfoByVideoId(String videoId) {
        String response = null;
        YoutubeCommentThreadsInfo commentThreadsInfo = null;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("videoId", videoId);
        params.put("part", "snippet");
        try {
            response = this.getRequest(params, Youtube.API_URL + "/commentThreads",
                                       Youtube.USER_AGENT, "GET");
            commentThreadsInfo = new YoutubeCommentThreadsInfo(new JSONObject(response));
        } catch (IOException e) {
            Youtube.log.error("Error getting commentThreads information", e);
        } catch (JSONException e) {
            Youtube.log.error("Error getting commentThreads information", e);
        }
        return commentThreadsInfo;
    }
    
    /**
     * Revisa si se encuentra vigente el token utilizado para realizar consultas a la API de Youtube
     * o si es necesario actualizarlo.
     * @return {@code true} si el token actual es valido para su uso en peticiones a la 
     *         API de Youtube, {@code false} de lo contrario
     */
    public synchronized boolean validateToken() {
        
        boolean tokenIsValid = false;
        Calendar now = new GregorianCalendar();
        int timeLeft = 0;
        try {
            if (this.getTokenExpirationDate() != null) {
                timeLeft = (int) (this.getTokenExpirationDate().getTime() - now.getTime().getTime());
//            } else if (this.getTokenExpirationDate() == null ||
//                    now.getTime().getTime() > this.getTokenExpirationDate().getTime()) {
//                Youtube.log.event("**** Token vencido: " + 
//                        this.getTokenExpirationDate() != null ? this.getTokenExpirationDate().toString() : "null");
            }
            
            Map<String, String> params = new HashMap<String, String>(4);
//            params.put("access_token", this.getAccessToken());
//            String responseBody = this.postRequest(params, "https://www.googleapis.com/oauth2/v1/tokeninfo",
//                                                   Youtube.USER_AGENT, "POST");
//
//            if (responseBody != null && !responseBody.isEmpty()) {
//                JSONObject tokenInfo = new JSONObject(responseBody);
//                if (tokenInfo.has("expires_in")) {
//                    timeLeft = tokenInfo.getInt("expires_in");
//                }
//            }
            if (timeLeft < 1) {
                String emailApp = this.getAppKey().substring(0, this.getAppKey().indexOf(".apps.googleusercontent.com")) +
                        "@developer.gserviceaccount.com";
                params.clear();
                params.put("refresh_token", this.getRefreshToken());
                params.put("client_id", emailApp); //se debe enviar la cuenta de correo en lugar del Id del cliente
                params.put("client_secret", this.getSecretKey());
                params.put("grant_type", "refresh_token");
                String res = this.postRequest(params, "https://accounts.google.com/o/oauth2/token",
                                              Youtube.USER_AGENT, "POST");
                try {
                    if (res != null && !res.isEmpty()) {
                        JSONObject userData = new JSONObject(res);
                        if (!userData.has("error")) {
                            String tokenAccess = userData.getString("access_token");
                            timeLeft = userData.getInt("expires_in");
                            now.add(Calendar.SECOND, timeLeft);
                            this.setAccessToken(tokenAccess);
                            this.setTokenExpirationDate(now.getTime());
                            tokenIsValid = true;
                        } else {
                            Youtube.log.error("Respuesta de Youtube p/refrescar token:\n" + userData.toString(4));
                        }
                    }
                } catch (JSONException jsone) {
                    Youtube.log.error("Retrieving a refresh token from Youtube", jsone);
                }
            } else {
                tokenIsValid = true;
            }
            
        } catch (HttpResponseException e) {
            Youtube.log.error("Error en conexion para refrescar token", e);
        } catch (IOException ex) {
            Youtube.log.error("Error validating token: ", ex);
        }
        return tokenIsValid;
    }

    /**
     * Publica un comentario en Youtube y lo asocia al video correspondiente
     * @param message el {@code Message} que contiene el texto a publicar, asi como el identificador del video
     *                al que se desea asociar el comentario.
     */
    @Override
    public void postMsg(Message message) {
        
        if (!isSn_authenticated() || getAccessToken() == null ) {
            Youtube.log.error("Not authenticated network: " + getTitle() + ". Unable to post Comment");
            return;
        }
        if (message != null && message.getMsg_Text() != null && message.getMsg_Text().trim().length() > 1) {
            if (message.getPostInSource() != null && message.getPostInSource().getSocialNetMsgId() != null) {
                String messageText = this.shortMsgText(message);
                String videoId = message.getPostInSource().getSocialNetMsgId();
                
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
                
                com.google.api.services.youtube.YouTube apiYoutube = this.getApiYoutubeInstance();
                com.google.api.services.youtube.YouTube.CommentThreads.Insert commentInsert = null;
                HttpURLConnection conn = null;
                try {
                    CommentSnippet commentSnippet = new CommentSnippet();
                    commentSnippet.setTextOriginal(messageText);
                    Comment topLevelComment = new Comment();
                    topLevelComment.setSnippet(commentSnippet);
                    
                    // Create a comment thread snippet with channelId and top-level comment.
                    CommentThreadSnippet commentThreadSnippet = new CommentThreadSnippet();
                    commentThreadSnippet.setChannelId(videoId);
                    commentThreadSnippet.setVideoId(videoId);
                    commentThreadSnippet.setTopLevelComment(topLevelComment);
                    // Create a comment thread with snippet.
                    CommentThread commentThread = new CommentThread();
                    commentThread.setSnippet(commentThreadSnippet);
                    
                    // Call the YouTube Data API's commentThreads.insert method to create a comment.
                    CommentThread videoCommentInsertResponse = apiYoutube.commentThreads().insert(
                                  "snippet", commentThread).setOauthToken(this.getAccessToken()).execute();
                    
                    if (videoCommentInsertResponse.getId() != null) {
                        SWBSocialUtil.PostOutUtil.savePostOutNetID(message, this,
                                videoCommentInsertResponse.getId(), null);
                    }
                } catch (Exception ex) {
                    SWBSocialUtil.PostOutUtil.savePostOutNetID(message, this, null, ex.getMessage());
                    Youtube.log.error("Problem posting comment ", ex);
                    try {
                        if (conn != null && conn.getResponseMessage() != null) {
                            Youtube.log.error("Error code:" + conn.getResponseCode() + " " + conn.getResponseMessage(), ex);
                        }
                    } catch (Exception e) {
                        Youtube.log.error("Reading data from connexion", e);
                    }
                }
            } else {
                Youtube.log.error("Youtube only allows comment to a video, not POSTS!");
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
        return privacy;
    }

    @Override
    public HashMap monitorPostOutResponses(PostOut postOut) {
        //throw new UnsupportedOperationException("Not supported yet.");
        HashMap hMapPostOutNets = new HashMap();
        Iterator<PostOutNet> itPostOutNets=PostOutNet.ClassMgr.listPostOutNetBySocialPost(postOut);
        
        if (!this.validateToken()) {
            Youtube.log.error("Unable to update the access token inside monitorPostOutResponses!");
            return hMapPostOutNets;
        }
        
        while (itPostOutNets.hasNext()) {
            PostOutNet postOutNet = itPostOutNets.next();
            if (postOutNet.getStatus() == 1 && postOutNet.getSocialNetwork().getURI().equals(this.getURI())) {
                
                long totalComments = 0L;
                if (postOut.getPo_type() == SWBSocialUtil.POST_TYPE_VIDEO) {
                    totalComments = this.comments(postOutNet.getPo_socialNetMsgID());
                } else if (postOut.getPo_type() == SWBSocialUtil.POST_TYPE_MESSAGE) {
                    totalComments = this.commentsOnComment(postOutNet.getPo_socialNetMsgID());
                }
                //El número que se agrega es la diferencia entre el número de respuesta encontradas
                //en la red social - el que se encuentra en la propiedad postOutNet.getPo_numResponses()
                
                if (totalComments > 0) {
                    if (postOutNet.getPo_numResponses() > 0) {//Si ya había respuestas
                        if (postOutNet.getPo_numResponses() < totalComments) {//Si hay respuestas nuevas
                            hMapPostOutNets.put(postOutNet.getURI(),
                                                totalComments - postOutNet.getPo_numResponses());
                        }
                    } else if (postOutNet.getPo_numResponses() == 0) {//Si no había respuestas
                        hMapPostOutNets.put(postOutNet.getURI(), totalComments);
                    }
                    postOutNet.setPo_numResponses((int) totalComments);
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
        if (videoId != null && !videoId.isEmpty()) {
            HashMap<String, String> params = new HashMap<String, String>(4);
            params.put("part", "id");
            params.put("videoId", videoId);//alt
            params.put("maxResults", "1");//alt
            try {
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
            } catch (Exception e) {
                Youtube.log.error("Youtube: Not data found for -> " + videoId, e);
            }
        }
        return totalComments;
    }

    /**
     * Calcula el total de comentarios publicados asociados a un comentario de primer nivel (CommentThread).
     * @param commentId identificador del comentario del cual se desea conocer el n&uacute;mero de comentarios asociados
     * @return el n&uacute;mero de comentarios publicados asociados al comentario identificado por el valor de {@code commentId}
     */
    private long commentsOnComment(String commentThreadId) {
        
        long totalComments = 0L;
        com.google.api.services.youtube.YouTube apiYoutube = this.getApiYoutubeInstance();
        com.google.api.services.youtube.YouTube.CommentThreads.List commentList = null;
        try {
            commentList = apiYoutube.commentThreads().list("snippet");
            commentList.setId(commentThreadId);
            commentList.setOauthToken(this.getAccessToken());
            CommentThreadListResponse commentThreadListResponse = commentList.execute();
            if (!commentThreadListResponse.containsKey("error")) {
                if (commentThreadListResponse.getItems() != null && !commentThreadListResponse.getItems().isEmpty()) {
                    CommentThread commentThread = commentThreadListResponse.getItems().get(0);
                    if (commentThread.getSnippet() != null) {
                        totalComments = commentThread.getSnippet().getTotalReplyCount();
                    }
                }
            }
        } catch (Exception e) {
            Youtube.log.error("While getting comment's total reply count", e);
        }
        return totalComments;
    }
    
    
    public String getRequestVideo(Map<String, String> params, String url,
            String userAgent, String accessToken) throws IOException {
        
        CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = new URL(url + "?" +  paramString);       
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
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod("GET");
            conex.setDoOutput(true);
            conex.connect();
            in = conex.getInputStream();
            response = getResponse(in);
                        
        } catch (java.io.IOException ioe) {
            if (conex != null && conex.getResponseCode() >= 400) {
                response = getResponse(conex.getErrorStream());
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

            //Obtener id de json
            try
            {
                if(kloutJsonResponse_1!=null)
                {
                    JSONObject userData = new JSONObject(kloutJsonResponse_1);
                    String kloutUserId = userData != null && userData.get("id") != null ? (String) userData.get("id") : "";

                    //Segunda llamada a la red social Klout, para obtener Json de Score del usuario (kloutUserId) encontrado
                    if(kloutUserId!=null)
                    {
                        String url_2="http://api.klout.com/v2/user.json/"+kloutUserId+"/score";
                        String kloutJsonResponse_2=getData(url_2);

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
                Youtube.log.error("Klout Error:"+nexc.getMessage());
                conex = null;
            }
            //Analizar la respuesta a la peticion y obtener el access token
            if (conex != null) {
                try
                {
                    answer = getResponse(conex.getInputStream());
                }catch(Exception e)
                {
                    //log.error(e);
                }
            }
        }
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
            Youtube.log.error("Error getting user third party information ", e);
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
            if(savedLink.getSocialNet().getURI().equals(this.getURI())){//La misma red
                if(msgText.contains(savedLink.getTargetUrl())){//La url existe                    
                    String targetUrl = absolutePath + linksRedirector.getUrl() + "?uri=" +
                                       postOut.getEncodedURI() + "&code=" + savedLink.getPol_code() + "&neturi=" + this.getEncodedURI();
                    targetUrl = SWBSocialUtil.Util.shortSingleUrl(targetUrl);                    
                    msgText = msgText.replace(savedLink.getTargetUrl(), targetUrl);
                }
            }
        }
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
        
        return parsedPhrases;
    }
    
    /**
     * Escribe en un archivo el contenido de {@code toFile}
     * @param toFile el contenido a ser agregado en el archivo
     */
    public static void write2File(StringBuilder toFile) {
        
/*        File file = new File("D:\\lacarpeta\\sistemas\\documentos\\Social\\docs\\youtube\\APIv2.txt");
        FileWriter writer = null;
        try {
            if (file.canWrite()) {
                writer = new FileWriter(file, true);
                writer.write(toFile.toString());
                writer.write("\n");
                writer.flush();
                writer.close();
                System.out.println("Ya debio haber escrito: \n" + toFile.toString());
            }
        } catch (IOException ioe) {
            Youtube.log.error("Al escribir en el archivo", ioe);
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ioe2) {}
            }
        }*/
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
    
    /**
     * Obtiene un arreglo de CommentThreads asociados al video identificado por {@code videoId}. 
     * Dicho arreglo puede tener como maximo 100 elementos.
     * @param videoId identifCommentThreads icador del video de Youtube, del que se desea conocer los comentarios asociados
     * @param maxResults indica el numero de resultados maximos que debe tener la respuesta de Youtube.
     *                   Se ignora si su valor esta fuera del rango incluyente [1 - 100] 
     * @return un arreglo de CommentThreads asociados al video indicado. {@literal null} en caso 
     *         de que ocurra algun problema con la peticion, o que la respuesta no incluya resultados
     */
    public JSONObject getVideoCommentThreads(String videoId, int maxResults, String pageToken) {
        
        JSONObject threadsArray = null;
        HashMap<String, String> params = new HashMap<String, String>(4);
        params.put("part", "snippet,replies");
        params.put("videoId", videoId);
        if (maxResults > 0 && maxResults < 101) {
            params.put("maxResults", Integer.toString(maxResults));//max = 100
        }
        if (pageToken != null && !pageToken.isEmpty()) {
            params.put("pageToken", pageToken);
        }
        try {
            String comThreads = this.getRequest(params, Youtube.API_URL + "/commentThreads",
                                       Youtube.USER_AGENT, "GET");
            JSONObject threadsResp = new JSONObject(comThreads);
            if (!threadsResp.isNull("items")) {
                threadsArray = threadsResp;
            }
        } catch (Exception e) {
            Youtube.log.error("Youtube: Not data found for -> " + videoId, e);
        }
        return threadsArray;
    }
    
    /**
     * Crea un comentario en Youtube relacionado a otro comentario (de primer nivel)
     * @param parentCommentId identificador del comentario de primer nivel, al cual se relacionara el nuevo comentario
     * @param commentText el texto del comentario a crear
     * @return {@code true} si la creacion del nuevo comentario es exitosa, {@code false} de lo contrario
     */
    public boolean commentAComment(String parentCommentId, String commentText) {
        
        boolean commentCreated = false;
        com.google.api.services.youtube.YouTube apiYoutube = this.getApiYoutubeInstance();
        com.google.api.services.youtube.YouTube.Comments.Insert commentInsert = null;
        try {
            CommentSnippet commentSnippet = new CommentSnippet();
            commentSnippet.setTextOriginal(commentText);
            commentSnippet.setParentId(parentCommentId);
            Comment comment = new Comment();
            comment.setSnippet(commentSnippet);
            commentInsert = apiYoutube.comments().insert("snippet", comment);
            commentInsert.setOauthToken(this.getAccessToken());
            Comment commentResponse = commentInsert.execute();
            
            if (!commentResponse.containsKey("error")) {
                if (commentResponse.getId() != null && !commentResponse.getId().isEmpty()) {
                    commentCreated = true;
                }
            }
        } catch (Exception e) {
            Youtube.log.error("While getting comment's total reply count", e);
        }
        return commentCreated;
    }
    
    /**
     * Actualiza los metadatos de un video publicado anteriormente en Youtube de acuerdo al contenido de {@code video}
     * @param video contiene la informacion que se desea almacenar en Youtube relacionada al video correspondiente
     * @return {@code true} en caso de que la actualizacion se realice exitosamente, {@code false} de lo contrario
     */
    public boolean updateVideoMetadata(JSONObject video) {
        
        boolean videoUpdated = false;
        com.google.api.services.youtube.YouTube apiYoutube = this.getApiYoutubeInstance();
        com.google.api.services.youtube.YouTube.Videos.Update videoUpdate = null;
        
        try {
            JSONObject snippet = video.getJSONObject("snippet");
            VideoSnippet videoSnippet = new VideoSnippet();
            //videoSnippet.set("id", video.getString("id"));
            videoSnippet.setTitle(snippet.getString("title"));
            videoSnippet.setDescription(snippet.getString("description"));
            int cont = 0;
            List<String> tags = new ArrayList<String>(8);
            while (cont < snippet.getJSONArray("tags").length()) {
                tags.add(snippet.getJSONArray("tags").getString(cont));
                cont++;
            }
            videoSnippet.setTags(tags);
            videoSnippet.setCategoryId(snippet.getString("categoryId"));
            VideoStatus videoStatus = new VideoStatus();
            videoStatus.setPrivacyStatus(video.getJSONObject("status").getString("privacyStatus"));
            com.google.api.services.youtube.model.Video apiVideo = new com.google.api.services.youtube.model.Video();
            apiVideo.setSnippet(videoSnippet);
            apiVideo.setStatus(videoStatus);
            apiVideo.setId(video.getString("id"));
            videoUpdate = apiYoutube.videos().update("snippet,status", apiVideo);
            videoUpdate.setOauthToken(this.getAccessToken());
            com.google.api.services.youtube.model.Video apiVideoModified = videoUpdate.execute();
            if (apiVideoModified.containsKey("id")) {
                videoUpdated = true;
            }
        } catch (JSONException jsone) {
            Youtube.log.error("Creating objects to update video's metadata", jsone);
        } catch (IOException ioe) {
            Youtube.log.error("Creating execution object for update", ioe);
        }
        return videoUpdated;
    }
    
    /**
     * Crea una instancia de {@code com.google.api.services.youtube.YouTube} de manera estandar
     * @return la instancia creada o {@code null} si ocurre un problema durante la creacion de la misma
     */
    private com.google.api.services.youtube.YouTube getApiYoutubeInstance() {
        
        com.google.api.services.youtube.YouTube apiYoutube = null;
        try {
            HttpTransport transport = com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport();
            // This object is used to make YouTube Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.
            apiYoutube = new com.google.api.services.youtube.YouTube.Builder(
                         transport, new com.google.api.client.json.jackson2.JacksonFactory(),
                         new HttpRequestInitializer() {
                             @Override
                             public void initialize(HttpRequest request) throws IOException {}
                         }).setApplicationName("SWBSocial").build();
        } catch (java.security.GeneralSecurityException gse) {
            Youtube.log.debug("Problem creating HttpTransport instance for Youtube API objects", gse);
        } catch (IOException ioe) {
            Youtube.log.debug("Problem creating HttpTransport instance for Youtube API objects", ioe);
        }
        return apiYoutube;
    }
    
    /**
     * Dada una extension de archivo de video, se determina el complemento del mime type correspondiente. Debido a 
     * que Youtube permite los videos cuyo contenido posee un MIME {@literal video/*}, en base a la extension del archivo
     * se determina el complemento que sustituye a ese {@literal *}
     * @param fileExtension extension de un archivo de video
     * @return un {@code String} con el complemento del MIME type correspondiente a la extension de archivo proporcionada que
     *         sigue a {@literal video/} en la definicion del MIME type
     */
    private String getMimeType(String fileExtension) {
        String mime2Return = null;
        //El mapa contiene las extensiones de archivo permitidas para Youtube, definidas en la ontologia.
        //En la propiedad "social:video" la cual posee un displayProperty cuyo formElement define las extensiones de
        //archivos de video permitidas, tanto para Facebook como para Youtube separandolas por ","
        HashMap<String, String> mimeTypes = new HashMap<String, String>(16);
        mimeTypes.put("3gp", "3gpp");
        mimeTypes.put("3gpp", "3gpp");
        mimeTypes.put("avi", "x-msvideo");
        mimeTypes.put("flv", "x-flv");
        mimeTypes.put("mov", "quicktime");
        mimeTypes.put("mp4", "mp4");
        mimeTypes.put("mpeg", "mpeg");
        mimeTypes.put("mpeg4", "mpeg");
        mimeTypes.put("mpegps", "mpeg");
        mimeTypes.put("mpg", "mpeg");
        mimeTypes.put("ts", "MP2T");
        mimeTypes.put("webm", "webm");
        mimeTypes.put("wmv", "x-ms-wmv");
        //incluir?: mkv(video/x-matroska)m4v(video/x-m4v)xvid(x-xvid)
        mime2Return = mimeTypes.get(fileExtension);
        return mime2Return;
    }
}
