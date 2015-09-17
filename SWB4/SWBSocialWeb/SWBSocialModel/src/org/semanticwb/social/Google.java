package org.semanticwb.social;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.plus.Plus;
import com.google.api.services.plus.model.Activity;
import com.google.api.services.plus.model.Activity.PlusObject.Attachments;
import com.google.api.services.plus.model.ActivityFeed;
import com.google.api.services.plus.model.Person;
import java.io.BufferedReader;
import java.io.Closeable;
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
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.HttpResponseException;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.social.listener.Classifier;
import org.semanticwb.social.util.SWBSocialUtil;


   /**
   * Clase red social para Google+ 
   */
public class Google extends org.semanticwb.social.base.GoogleBase {
    
    
    final private static Logger log = SWBUtils.getLogger(Google.class);
    
    final public static String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95";
    
    
    public Google(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }
    
    /**
     * Realiza los intercambios de informacion entre la aplicacion y Google+ para generar un token valido
     * necesario para realizar peticiones al API de Google+
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
        String clientSecret = this.getSecretKey();
        String uri = getRedirectUrl(request, paramRequest);
        //Google+ no permite enviarle una url dinamica por lo cual se envia a un jsp y nuevamnete se redirecciona
        String uriTemp = "http://" + request.getServerName() + ":" + request.getServerPort() +
                         SWBPortal.getWebWorkPath() + "/models/SWBAdmin/jsp/oauth/callback.jsp";
        //Se crea una variable de sesion para recuperar en el jsp la url dinamica
        HttpSession session = request.getSession(true);
        session.setAttribute("redirectGoogle", uri);
        
        if (code == null) {
            
            out.println("<script type=\"text/javascript\">");
            out.println("   location.href='"+ "https://accounts.google.com/o/oauth2/auth?client_id=" +
                    clientId + "&redirect_uri=" + uriTemp +
                    "&response_type=code&scope=https://www.googleapis.com/auth/plus.login+https://www.googleapis.com/auth/userinfo.profile" +
                    "&access_type=offline&approval_prompt=force&state=/profile'");
            out.println("</script>");
        } else {
            Map<String, String> params = new HashMap<String, String>(8);
            params.put("code", code);
            params.put("client_id", clientId);
            params.put("client_secret", clientSecret);
            params.put("redirect_uri", uriTemp);
            params.put("grant_type", "authorization_code");
            //params.put("access_type", "offline");
            try {
                String res = this.postRequest(params, 
                        "https://www.googleapis.com/oauth2/v3/token", Google.USER_AGENT);
                
                JSONObject userData = new JSONObject(res);
                if (!userData.has("error")) {
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
                    } else {//Si ya no viene el refresh token hay que validar si esa cuenta ya esta dada de alta
                        //en social. Se puede ver a quien pertenece un token usando el endpoint 'tokeninfo'
                    }
                    setSn_authenticated(true);
                }
            } catch (Exception ex) {
                Google.log.error(ex);
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
            session.removeAttribute("redirectGoogle");
        }
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
    
    /**
     * Publica un comentario en Google+
     * @param message el {@code Message} que contiene el texto a publicar
     */
    @Override
    public void postMsg(Message message) {
    }
    
    public String shortMsgText(PostOut postOut) {
        
        SocialSite socialSite = SocialSite.ClassMgr.getSocialSite(
                postOut.getSemanticObject().getModel().getName());
        String msgText = postOut.getMsg_Text();
        WebSite admin = SWBContext.getAdminWebSite();
        WebPage linksRedirector  = admin.getWebPage("linksredirector");
        String absolutePath = SWBPortal.getEnv("swbsocial/absolutePath") == null 
                              ? "" : SWBPortal.getEnv("swbsocial/absolutePath");
        
        Iterator<PostOutLinksHits> savedLinks = PostOutLinksHits.ClassMgr.
                listPostOutLinksHitsByPostOut(postOut, socialSite);
        while (savedLinks.hasNext()) {
            PostOutLinksHits savedLink = savedLinks.next();
            //La misma red
            if (savedLink.getSocialNet().getURI().equals(this.getURI())) {
                //La url existe
                if (msgText.contains(savedLink.getTargetUrl())) {
                    String targetUrl = absolutePath + linksRedirector.getUrl() + "?uri=" +
                            postOut.getEncodedURI() + "&code=" +
                            savedLink.getPol_code() + "&neturi=" + this.getEncodedURI();
                    targetUrl = SWBSocialUtil.Util.shortSingleUrl(targetUrl);
                    msgText = msgText.replace(savedLink.getTargetUrl(), targetUrl);
                }
            }
        }
        return msgText;
    }

    @Override
    public void postVideo(Video video) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getUserKlout(String googlePlusUserID) {
        
        double kloutScore = 0D;
        if (googlePlusUserID != null && !googlePlusUserID.isEmpty()) {
            String url_1 = "http://api.klout.com/v2/identity.json/gp/" + googlePlusUserID;
            String kloutJsonResponse_1 = getKloutData(url_1);

            //Obtener id de json
            try {
                if (kloutJsonResponse_1 != null) {
                    JSONObject userData = new JSONObject(kloutJsonResponse_1);
                    String kloutUserId = userData.get("id") != null ? userData.getString("id") : "";

                    //Segunda llamada a la red social Klout, para obtener Json de Score del usuario (kloutUserId) encontrado
                    if (kloutUserId != null) {
                        String url_2 = "http://api.klout.com/v2/user.json/" + kloutUserId + "/score";
                        String kloutJsonResponse_2 = getKloutData(url_2);

                        if (kloutJsonResponse_2 != null) {
                            JSONObject userScoreData = new JSONObject(kloutJsonResponse_2);
                            double kloutUserScore = userScoreData.get("score") != null
                                                    ? userScoreData.getDouble("score") : 0.00;
                            kloutScore = Math.rint(kloutUserScore);
                        }
                    }
                }
            } catch (JSONException je) {
                Google.log.error("Getting user's Klout data", je);
            }
        }
        return kloutScore;
    }
    
    /**
     * Obtiene la respuesta a la peticion de la URL indicada.
     * @param url indica el recurso de Klout a ejecutar
     * @return la respuesta generada por el recurso ejecutado de Klout
     */
    private static String getKloutData(String url) {
        
        String answer = null;
        String key = SWBSocialUtil.getEnv("swbsocial/kloutKey", "8fkzgz7ngf7bth3nk94gnxkd");
        //System.out.println("key para KLOUT--Gg:"+key);
        if (key != null) {
            url = url + "?key=" + key;
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
                conex.setConnectTimeout(20000); //20 segundos maximo, si no contesta la red Klout, cortamos la conexión
            } catch (Exception nexc) {
                Google.log.error("Klout Error:" + nexc.getMessage());
                conex = null;
            }
            //Analizar la respuesta a la peticion y obtener el access token
            if (conex != null) {
                try {
                    answer = getResponse(conex.getInputStream());
                } catch (Exception e) {
                    //log.error(e);
                }
            }
        }
        return answer;
    }
    
    @Override
    public void postPhoto(Photo photo) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private String dateValue(Calendar dateTime) {
        
        StringBuilder sb = new StringBuilder(64);
        // date
        sb.append(dateTime.get(Calendar.YEAR));
        sb.append('-');
        sb.append(dateTime.get(Calendar.MONTH));
        sb.append('-');
        sb.append(dateTime.get(Calendar.DAY_OF_MONTH));
        sb.append('T');
        sb.append(dateTime.get(Calendar.HOUR_OF_DAY));
        sb.append(':');
        sb.append(dateTime.get(Calendar.MINUTE));
        sb.append(':');
        sb.append(dateTime.get(Calendar.SECOND));

        return sb.toString();
    }
    
    /**
     * Obtiene informacion de Google+ para analizarla y almacenarla localmente
     * @param stream flujo de informacion con cuya configuracion se obtendra 
     * informacion de las publicaciones disponibles en Google+
     */
    @Override
    public void listen(Stream stream) {
        
        if (!this.isSn_authenticated() || this.getAccessToken() == null ) {
            Google.log.event("Not authenticated network: " + getTitle() + "!!!");
            return;
        }
        if (!stream.isActive()) {
            return;
        }
        
        //Valida que este activo el token, de lo contrario lo refresca
        if (!this.validateToken()) {
            Google.log.event("Unable to update the access token inside listen Google!");
            this.validateToken();
        }
        ArrayList<ExternalPost> aListExternalPost = new ArrayList<ExternalPost>(256);
        String searchPhrases = this.formatsGooglePhrases(stream);
        if (searchPhrases == null || searchPhrases.isEmpty()) {
            Google.log.warn("\nNot a valid value to make a Google search:" + searchPhrases);
            return;
        }
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        DecimalFormat df = new DecimalFormat("#.00");
        if (searchPhrases.isEmpty()) {
            return;
        }
        System.out.println("A buscar: " + searchPhrases);
        int blockOfPosts = 500; //this is the default Value,
        int maxResults = 20;
        boolean canGetMoreItems = true;
        int count = 0;
        String index = "";//pagetoken del paginado de respuestas al api
        boolean breakFor = false;
        String uploadedStr = null; //fecha de publicacion del ultimo post extraido de Google
        Plus apiPlus = this.getApiPlusInstance();
        Plus.Activities.Search search = null;
        Date lastPostRetrieved = this.getLastPostDate(stream); //gets the value stored in NextDatetoSearch
//        System.out.println("Fecha de ultimo post en Stream: " + lastPostRetrieved);
        Calendar dateOfLastPost = new GregorianCalendar(TimeZone.getTimeZone("GMT-6"));
        int thisYear = dateOfLastPost.get(Calendar.YEAR);
        dateOfLastPost.setTime(lastPostRetrieved);
        Calendar dateStoredInStream = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        dateStoredInStream.setTime(dateOfLastPost.getTime());
        dateOfLastPost.setTimeZone(TimeZone.getTimeZone("GMT"));
//        System.out.println("Fecha en Original: " + lastPostRetrieved +
//                "\n **Mismo valor en Date: " + dateOfLastPost.getTime() + 
//                "\n En GMT: " + dateValue(dateStoredInStream) + 
//                "\n **GMT en Date: " + dateStoredInStream.getTime());
        int yearOfLastPost = dateOfLastPost.get(Calendar.YEAR);
        if (thisYear - yearOfLastPost == 2) {
            blockOfPosts = 2000;
        }
        try {
            if (apiPlus != null) {
                search = apiPlus.activities().search(searchPhrases);
                search.setOauthToken(this.getAccessToken());
                search.setMaxResults((long) maxResults);
                search.setOrderBy("recent");
            }
        } catch (Exception e) {}
        
        int limit = blockOfPosts / maxResults;
        //System.out.println("Fecha del primer post recuperado anteriormente: " + lastPostRetrieved);
        //Se intentaria obtener maximo 500 publicaciones;
        //cada iteracion podria obtener maxResults = 20 y se realizan limit = 10 iteraciones
        for (int startIndex = 1; startIndex <= limit; startIndex++) {
            if (search != null) {
                //Si se conoce la fecha de publicacion del ultimo video extraido
//                if (lastPostDate != null) {
//                    DateTime since = new DateTime(lastPostDate);
//                    search.setPublishedAfter(since);
//                }
                //index contiene el valor de nextPageToken de la respuesta de cada peticion a Google
                if (index != null && !index.isEmpty()) {
                    search.setPageToken(index);
                }
            }
            
            try {
                //String postsIds = null;
                //System.out.println("Objeto creado para busquedas:\n" + search.toString());
                ActivityFeed searchResponse = search.execute();
                //System.out.println("Respuesta:\n" + searchResponse.getPageInfo().toString()
                //+ "\n++++++++++++++++++++++++++++++");
                if (!searchResponse.isEmpty() && !searchResponse.containsKey("errors")) {
                    Iterator<Activity> iteratorSearchResults = searchResponse.getItems().iterator();
                    //int j = 0;
                    //StringBuilder resourceIds = new StringBuilder(512);
                    while (iteratorSearchResults.hasNext()) {
                        Activity singlePost = iteratorSearchResults.next();
                        //Date published = new Date(singlePost.getPublished().getValue());
                        Calendar published = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
                        Date postPublished = new Date(singlePost.getPublished().getValue());
                        published.setTime(new Date(singlePost.getPublished().getValue()));
//                        System.out.println(" --- ultimo: " +
//                                dateOfLastPost.getTime() + " - este post: " +
//                                postPublished +
//                                "\n ultimo antes de este: " + dateOfLastPost.getTime().before(published.getTime()) +
//                                "\n en milisegundos- ultimo: " + dateOfLastPost.getTimeInMillis() + 
//                                "\n               este post: " + published.getTimeInMillis());
//                        System.out.println("*** Fecha a fijar: " + singlePost.getPublished().toStringRfc3339() + 
//                                           "\n*** En calendar:   " + formatter.format(published.getTime()));
                        
                        if (singlePost.getKind().equals("plus#activity") && dateOfLastPost.getTime().before(postPublished)) {
                            if (uploadedStr == null) {
                                uploadedStr = formatter.format(published.getTime());
                            }
                            ExternalPost external = new ExternalPost();
                            String title = singlePost.getTitle();
                            String description = singlePost.getObject().getOriginalContent();
                            //Annotation only exists for shared content
                            String annotation = singlePost.getAnnotation();
                            String message = annotation != null && !annotation.isEmpty()
                                    ? annotation : description != null && !description.isEmpty() ? description : title;
                            if (description == null || description.equals("")) {
                                description = title;
                            } else {
                                description = title + " / " + description;
                            }
                            Double latitude = null;
                            Double longitude = null;

                            String location = singlePost.getGeocode();
                            if (location != null && location.isEmpty()) {
                                String[] locArray = location.split(" ");
                                latitude = Double.parseDouble(locArray[0]);
                                longitude = Double.parseDouble(locArray[1]);
                            }
                            
                            Date postUploaded = published.getTime();
//                            System.out.println("    ---- uploadedStr del post: " + postUploaded);
                            if (postUploaded.before(lastPostRetrieved) || postUploaded.equals(lastPostRetrieved)) {
                                canGetMoreItems = false;
                            } else if (message != null && !message.isEmpty()) {
                                String actorName = singlePost.getActor().getDisplayName() != null
                                        ? singlePost.getActor().getDisplayName()
                                        : singlePost.getActor().getName().getGivenName();
                                String verb = singlePost.getVerb();
                                external.setPostId(singlePost.getId());
                                external.setCreatorId(singlePost.getActor().getId());
                                external.setCreatorName(actorName);
                                external.setUserUrl(singlePost.getActor().getUrl());
                                external.setPostUrl(singlePost.getUrl());
//                                System.out.println("Actor: " + actorName + " verbo: " + verb + " -- pub: " + formatter.format(published.getTime()));
                                if (postUploaded.after(new Date())) {
                                    external.setCreationTime(new Date());
                                } else {
                                    external.setCreationTime(postUploaded);
                                }
                                external.setUpdateTime(new Date(singlePost.getUpdated().getValue()));
                                external.setMessage(message);
                                external.setSocialNetwork(this);
                                external.setCreatorPhotoUrl(singlePost.getActor().getImage().getUrl());
                                external.setDescription(singlePost.getObject().getContent());
                                external.setFollowers(singlePost.getObject().getPlusoners().size());
//                                System.out.println("   ---->>>> Content vacio? " + singlePost.getObject().getContent() != null ? singlePost.getObject().getContent().isEmpty() : " Nulo" +
//                                        "\n   ---->>>> Annotation vacio? " + annotation != null ? annotation.isEmpty() : " Nulo");
                                if (singlePost.getObject().getAttachments() != null) {
                                    Attachments att = singlePost.getObject().getAttachments().size() > 0
                                            ? singlePost.getObject().getAttachments().get(0) : null;
                                    if (att != null && att.getObjectType() != null) {
                                        if (att.getImage() != null) {
                                            external.setIcon(att.getImage().getUrl());
                                        }
                                        if (att.getObjectType().equals("photo") ||
                                                att.getObjectType().equals("album")) {
                                            Iterator<Attachments> listAtt = singlePost.getObject().getAttachments().iterator();
                                            ArrayList<String> picturesUrls = new ArrayList<String>();
                                            while (listAtt.hasNext()) {
                                                Attachments attach = listAtt.next();
                                                String pictUrl = null;
                                                if (attach.getFullImage() != null) {
                                                    pictUrl = attach.getFullImage().getUrl();
                                                } else if (attach.getImage() != null) {
                                                    pictUrl = attach.getImage().getUrl();
                                                }
                                                if (pictUrl != null) {
                                                    picturesUrls.add(pictUrl);
                                                }
                                            }
                                            if (!picturesUrls.isEmpty()) {
                                                external.setPostType(SWBSocialUtil.PHOTO);
                                                external.setPictures((ArrayList) picturesUrls.clone());
                                            } else if (verb.equalsIgnoreCase("share")) {
                                                //Se reclasifica como mensaje
                                                external.setPostType(SWBSocialUtil.MESSAGE);
                                                //System.out.println("    >>>>> -- verbo: " + singlePost.getVerb());
                                            }
                                        } else if (att.getObjectType().equals("video")) {
                                            String videoUrl = null;
                                            if (att.getEmbed() != null && att.getEmbed().getUrl() != null) {
                                                videoUrl = att.getEmbed().getUrl();
                                            } else {
                                                Iterator<Attachments> listAtt = singlePost.getObject().getAttachments().iterator();
                                                while (listAtt.hasNext()) {
                                                    Attachments attach = listAtt.next();
                                                    if (attach.getEmbed() != null) {
                                                        videoUrl = attach.getEmbed().getUrl();
                                                    }
                                                    if (videoUrl != null) {
                                                        break;
                                                    }
                                                }
                                            }
                                            if (videoUrl != null) {
                                                external.setPostType(SWBSocialUtil.VIDEO);
                                                external.setVideo(videoUrl);
                                            } else if (verb.equalsIgnoreCase("share")) {
                                                external.setPostType(SWBSocialUtil.MESSAGE);
                                            }
                                        }
                                    } else {
                                        external.setPostType(SWBSocialUtil.MESSAGE);
                                    }
                                }
                                external.setLink(singlePost.getUrl());
                                external.setPostName(title);
                                if (singlePost.getObject().getResharers() != null) {
                                    external.setPostShared(singlePost.getObject().getResharers().size());
                                }
                                if (singlePost.getObject().getObjectType().equals("note")) {
                                    external.setPostType(SWBSocialUtil.MESSAGE);
                                    //external.setMessage(singlePost.getObject().getOriginalContent());
                                }
                                if (external.getPostType() == null && external.getMessage() != null && !external.getMessage().isEmpty()) {
                                    external.setPostType(SWBSocialUtil.MESSAGE);
                                }
                                if (latitude != null && longitude != null) {
                                    external.setLatitude(latitude);
                                    external.setLongitude(longitude);
                                    external.setPlace("(" + df.format(latitude) +
                                            "," + df.format(longitude) + ")");
                                }
                                
//                                System.out.println("  --  EXTERNAL POSTTYPE: " + external.getPostType() + 
//                                        "  -- EXTERNAL MESSAGE: " + external.getMessage().length() +
//                                        (external.getMessage().length() < 9 ? "\n" + external.getMessage() : ""));
                                //se incluye el post para procesamiento
                                aListExternalPost.add(external);
                            }
                        } else {
                            breakFor = true;
                            break;// los siguientes post tienen fecha menor al ultimo recuperado
                        }
                        count++;
                    }
                    //postsIds = resourceIds.toString();
                } else if (searchResponse.isEmpty()) {
//                    System.out.println("Respuesta vacia!!! En Google+ listener ");
                }
                if (searchResponse.getNextPageToken() != null &&
                        !searchResponse.getNextPageToken().isEmpty()) {
                    index = searchResponse.getNextPageToken();
                } else {
                    breakFor = true;
                }
                
                if (count > 0) {
                    //Classify the block of posts
                    if (aListExternalPost.size() >= blockOfPosts) {
                        System.out.println("Enviando a clasificar: " + aListExternalPost.size() + " elementos");
                        new Classifier((ArrayList<ExternalPost>) aListExternalPost.clone(), stream, this, true);
                        aListExternalPost.clear();
                    }
                    if (!stream.isActive()) {//If the stream has been disabled stop listening
                        canGetMoreItems = false;
                    }
                    if (canGetMoreItems == false) {
                        break;
                    }
                } else {//There are no video ids to search for
                    canGetMoreItems = false;
                    break;
                }

                //Si ya no hay mas posts que extraer
                if (breakFor) {
                    canGetMoreItems = false;
                    break;
                }
                
            } catch (IOException ioe) {
                if (ioe.getMessage().contains("error") && ioe.getMessage().contains("500")) {
                    System.out.println("Error 500 en Servidor de Google");
                    //error interno del servidor (Google+)
                } else {
                    Google.log.error("Error reading Google's response", ioe);
                }
            } catch (Exception e) {
                Google.log.error("Error reading Google+ stream ", e);
                canGetMoreItems = false;
                break;
            }
            //startIndex = startIndex + (count - 1);
//            System.out.println("iteración en for: " + startIndex);
        }
//        System.out.println("Fecha de ultimo post en Stream: " + formatter.format(lastPostRetrieved));
        if (uploadedStr != null) {
//            System.out.println("Fecha a almacenar de post recuperado: " + uploadedStr);
            this.setLastPostDate(uploadedStr, stream);//uploadedStr
        } else {
//            System.out.println(":$ :$ :$ :$ :$ No se almacena fecha de ultimo post");
        }
        Calendar systemDate = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        //System.out.println("Elementos enviados al clasificador: " + count);
        if (aListExternalPost.size() > 0) {
            System.out.println("Enviando a clasificar: " + aListExternalPost.size() + " elementos");
            new Classifier(aListExternalPost, stream, this, true);
        }
    }
    
    /**
     * Obtiene informacion del perfil de Google+, a traves del identificador de usuario
     * @param userId identificador de usuario en Google+
     * @return un objeto {@code JSON} con los datos del perfil del usuario de Google+ correspondiente
     */
    @Override
    public JSONObject getUserInfobyId(String userId) {

        Plus apiPlus = this.getApiPlusInstance();
        JSONObject userInfo = new JSONObject();

        try {
            if (userId != null && !userId.isEmpty()) {
                Plus.People.Get getPeople = apiPlus.people().get(userId);
                getPeople.setOauthToken(this.getAccessToken());
                Person user = getPeople.execute();
                if (user != null) {
                    userInfo.put("third_party_id", userId);
                    userInfo.put("followers", user.getCircledByCount());
                    userInfo.put("gender", user.getGender() != null ? user.getGender() : "");
                    if (user.getRelationshipStatus() != null) {
                        userInfo.put("relationship_status", user.getRelationshipStatus());
                    }
                    if (user.getCurrentLocation() != null) {
                        userInfo.put("place_name", user.getCurrentLocation());
                    }
                    if (user.getBirthday() != null) {
                        String date = user.getBirthday();
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
                        Date regresa = sdf.parse(date);
                        sdf = new SimpleDateFormat("MM-dd-yyyy");
                        date = sdf.format(regresa);
                        userInfo.put("birthday", date.replace("-", "/"));
                    }
                }
            }
        } catch (Exception e) {
            Google.log.error("Error getting user information", e);
        }
        return userInfo;
    }
    
    /**
     * Fija la fecha del ultimo post recuperado por {@code stream}
     * @param dateVideo la fecha de publicacion de un post recuperado
     * @param stream la instancia del {@Stream} por el cual se recuperaron datos de posts
     */
    private void setLastPostDate(String dateOfPost, Stream stream) {
        
        try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
            Date storedValue = new Date(0L);
            SocialNetStreamSearch socialStreamSerch = SocialNetStreamSearch
                    .getSocialNetStreamSearchbyStreamAndSocialNetwork(stream, this);
            if (socialStreamSerch != null) {
                if (socialStreamSerch.getNextDatetoSearch() != null) {
                    storedValue = formatter.parse(socialStreamSerch.getNextDatetoSearch());
                } else {
                    storedValue = this.getLastPostDate(stream);
                }
                if (dateOfPost != null) {
                    if (formatter.parse(dateOfPost).after(storedValue)) {
                        socialStreamSerch.setNextDatetoSearch(dateOfPost);
                    //} else {
                        //System.out.println("NO GUARDA NADA PORQUE EL VALOR ALMACENADO
                        //YA ES IGUAL O MAYOR AL ACTUAL");
                    }
                }
            }
        } catch (NumberFormatException nfe) {
            Google.log.error("Error in setLastPostDate():" + nfe);
        } catch (ParseException pe) {
            Google.log.error("Error in parseDate():" + pe);
        }
    }
    
    /**
     * Crea una instancia de {@code com.google.api.services.plus.Plus} de manera estandar
     * @return la instancia creada o {@code null} si ocurre un problema durante la creacion de la misma
     */
    public com.google.api.services.plus.Plus getApiPlusInstance() {
        
        com.google.api.services.plus.Plus plus = null;
        try {
            HttpTransport transport = com.google.api.client.googleapis.javanet.
                    GoogleNetHttpTransport.newTrustedTransport();
            // This object is used to make Google+ Data API requests. The last
            // argument is required, but since we don't need anything
            // initialized when the HttpRequest is initialized, we override
            // the interface and provide a no-op function.
            plus = new com.google.api.services.plus.Plus.Builder(
                         transport, new com.google.api.client.json.jackson2.JacksonFactory(),
                         new HttpRequestInitializer() {
                             @Override
                             public void initialize(HttpRequest request) throws IOException {}
                         }).setApplicationName("SWBSocial").build();
        } catch (java.security.GeneralSecurityException gse) {
            Google.log.debug("Problem creating HttpTransport instance for Google+ API objects", gse);
        } catch (IOException ioe) {
            Google.log.debug("Problem creating HttpTransport instance for Google+ API objects", ioe);
        }
        return plus;
    }
    
    /**
     * Revisa si se encuentra vigente el token utilizado para realizar consultas a la API de Google
     * o si es necesario actualizarlo.
     * @return {@code true} si el token actual es valido para su uso en peticiones a la 
     *         API de Google, {@code false} de lo contrario
     */
    public synchronized boolean validateToken() {
        
        boolean tokenIsValid = false;
        Calendar now = new GregorianCalendar();
        int timeLeft = 0;
        try {
            if (this.getTokenExpirationDate() != null) {
                timeLeft = (int) (this.getTokenExpirationDate().getTime() - now.getTime().getTime());
            }
            
            Map<String, String> params = new HashMap<String, String>(4);
            if (timeLeft < 1) {
                String emailApp = this.getAppKey().substring(0, this.getAppKey().indexOf(".apps.googleusercontent.com")) +
                        "@developer.gserviceaccount.com";
                params.clear();
                params.put("refresh_token", this.getRefreshToken());
                params.put("client_id", emailApp); //se debe enviar la cuenta de correo en lugar del Id del cliente
                params.put("client_secret", this.getSecretKey());
                params.put("grant_type", "refresh_token");
                String res = this.postRequest(params, "https://accounts.google.com/o/oauth2/token", Google.USER_AGENT);
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
                            Google.log.error("Respuesta de Google p/refrescar token:\n" + userData.toString(4));
                        }
                    }
                } catch (JSONException jsone) {
                    Google.log.error("Retrieving a refresh token from Google+", jsone);
                }
            } else {
                tokenIsValid = true;
            }
            
        } catch (HttpResponseException e) {
            Google.log.error("Error en conexion para refrescar token", e);
        } catch (IOException ex) {
            Google.log.error("Error validating token: ", ex);
        }
        return tokenIsValid;
    }
    
    /**
     * Obtiene la fecha de publicación del post mas recientemente recuperado por {@code stream}
     * @param stream la instancia de un {@code Stream} para obtener la fecha del post mas recientemente recuperado
     * @return la fecha de publicación del post mas recientemente recuperado por {@code stream}. Si ocurre
     *         algun problema el valor devuelto es igual a la fecha del dia actual menos dos años.
     */
    private Date getLastPostDate(Stream stream) {
        
        Date lastPostDate = new Date();
        SocialNetStreamSearch socialStreamSerch = null;
        try {
            socialStreamSerch = SocialNetStreamSearch.getSocialNetStreamSearchbyStreamAndSocialNetwork(
                    stream, this);
        } catch (NullPointerException npe) {}
        
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Calendar defaultDate = new GregorianCalendar(TimeZone.getTimeZone("GMT-6"));
        try {
            if (socialStreamSerch != null && socialStreamSerch.getNextDatetoSearch() != null) {
                lastPostDate = formatter.parse(socialStreamSerch.getNextDatetoSearch());
            } else {
                defaultDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) - 2);
                lastPostDate = defaultDate.getTime();
            }
        } catch (NumberFormatException nfe) {
            defaultDate.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR) - 2);
            lastPostDate = defaultDate.getTime();
            Google.log.error("Error in getLastVideoID():" + nfe);
        } catch (ParseException pex) {
            Google.log.error("Error in parseDate() in getLastVideoID:" + pex);
        }
        return lastPostDate;
    }
    
    /**
     * Da formato a las frases de busqueda de acuerdo a los requerimientos del API de Google+.
     * Toma todas las frases del campo de busqueda del stream y da formato a las "palabras".
     * @param stream flujo de informacion del que se necesita obtener las frases de busqueda
     * @return las frases de busqueda con formato.
     */
    private String formatsGooglePhrases(Stream stream) {
        
        String parsedPhrases = ""; // parsed phrases - the result
        String orPhrases = "";
        String exactPhrases = "";
        String notPhrases = "";
        String allPhrases ="";

        if (stream.getPhrase() != null && !stream.getPhrase().trim().isEmpty()) {//OR (Default)
            orPhrases = stream.getPhrase();
            //orPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(orPhrases);
            //replace multiple spaces beetwen words for one only one space
            orPhrases = orPhrases.trim().replaceAll("\\s+", " ");
            String words[] = orPhrases.split(" ");
            int wordsNumber = words.length;
            String tmpString = "";
            for (int i = 0; i < wordsNumber; i++) {
                if (!words[i].trim().isEmpty()) {
                    tmpString += words[i];
                    if ((i + 1) < wordsNumber) {
                        tmpString += "|";
                    }
                }
            }
            orPhrases = tmpString;
        }
        
        if (stream.getStream_allPhrases() != null && !stream.getStream_allPhrases().trim().isEmpty()) {//All phrases
            allPhrases = stream.getStream_allPhrases();
            allPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(allPhrases);
            allPhrases = allPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for only one space
            String words[] = allPhrases.split(" ");
            int wordsNumber = words.length;
            String tmpString = "";
            for (int i = 0; i < wordsNumber; i++) {
                if (!words[i].trim().isEmpty()) {
                    tmpString += words[i];
                    if ((i + 1) < wordsNumber) {
                        tmpString += " ";
                    }
                }
            }
            allPhrases = tmpString;
        }
        if (stream.getStream_notPhrase() != null && !stream.getStream_notPhrase().trim().isEmpty()) {//Not phrases
            notPhrases = stream.getStream_notPhrase();
            notPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(notPhrases);
            notPhrases = notPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for one only one space
            String words[] = notPhrases.split(" ");
            int wordsNumber = words.length;
            String tmpString = "";
            for (int i = 0; i < wordsNumber; i++) {
                if (!words[i].trim().isEmpty()) {
                    tmpString += ( i>0 ? " " : "") + "-" + words[i];
                }
            }
            notPhrases = tmpString;
        }
        if (stream.getStream_exactPhrase() != null && !stream.getStream_exactPhrase().trim().isEmpty()) {//Exact phrase
            exactPhrases = stream.getStream_exactPhrase();
            exactPhrases = SWBSocialUtil.Strings.replaceSpecialCharacters(exactPhrases);
            exactPhrases = exactPhrases.trim().replaceAll("\\s+", " "); //replace multiple spaces beetwen words for one only one space
            exactPhrases = "\"" + exactPhrases + "\"";
        }

        if (!allPhrases.isEmpty()) {
            parsedPhrases += allPhrases;
        }
        
        if (!exactPhrases.isEmpty()) {
            if (parsedPhrases.isEmpty()) {
                parsedPhrases = exactPhrases;
            } else {
                parsedPhrases += " " + exactPhrases;
            }
        }
        
        if (!orPhrases.isEmpty()) {
            if (parsedPhrases.isEmpty()) {
                parsedPhrases = orPhrases;
            } else {
                parsedPhrases += " " + orPhrases;
            }
        }

        if (!notPhrases.isEmpty()) {
            if (parsedPhrases.isEmpty()) {
                parsedPhrases = notPhrases;
            } else {
                parsedPhrases += " " + notPhrases;
            }
        }
        
        return parsedPhrases;
    }
    
    @Override
    public HashMap<String, Long> monitorPostOutResponses(PostOut postOut) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Ejecuta una peticion HTTP al API de Google+ de acuerdo a los parametros recibidos
     * @param params contiene las parejas de parametro/valor que forman el query string de la peticion
     * @param url define la URL de la peticion a realizar
     * @param userAgent indica el identificador del navegador Web utilizado en la peticion
     * @return la respuesta a la ejecucion de la peticion. Si la peticion no genera una respuesta,
     *         se devuelve un {@code String} vacio.
     * @throws IOException en caso de ocurrir algun problema con la conexion HTTP
     */
    public String postRequest(Map<String, String> params, String url,
                              String userAgent) throws IOException {

        HttpURLConnection conex = null;
        OutputStream out = null;
        InputStream in = null;
        String response = null;
//        StringBuilder toFile = new StringBuilder(128);

        try {
            CharSequence paramString = (null == params) ? "" : delimit(params.entrySet(), "&", "=", true);
            URL serverUrl = new URL(url);
//            toFile.append("\nHACIENDO PETICION A:**** **** ****\n");
//            toFile.append(url);
//            toFile.append("\nparamString:\n");
//            toFile.append(paramString);
//            toFile.append("\n");
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
            conex.setRequestMethod("POST");
            conex.setDoOutput(true);
            conex.setDoInput(true);
            conex.connect();
            out = conex.getOutputStream();
            out.write(paramString.toString().getBytes("UTF-8"));
            in = conex.getInputStream();
            response = Google.getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex != null) {
                response = getResponse(conex.getErrorStream());
                Google.log.error("ERROR in Google.postRequest() with connexion:\n" + response, ioe);
            } else {
                Google.log.error("ERROR in Google.postRequest() connexion is null: \n", ioe);
            }
        } catch (Exception e) {
            Google.log.error("General ERROR in Google.postRequest():\n" + e.getMessage(), e);
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
//        System.out.println(toFile.toString());
        return response;
    }
    
    /**
     * Ejecuta una peticion a la url indicada cuyo queryString se compone de los 
     * elementos recibidos en {@code params}
     * @param params los parametros para formar el queryString de la peticion con sus correspondientes valores
     * @param url ubicacion de Internet a la que se realiza la peticion
     * @param method metodo HTTP solicitado para ejecutar la peticion
     * @return un {@code String} con la respuesta obtenida por la ejecucion de la peticion
     * @throws IOException en caso de algun problema con la ejecucion de la peticion
     */
    public String apiRequest(Map<String, String> params, String url, String method)
            throws IOException {

        CharSequence paramString = (null == params)
                                   ? "" : delimit(params.entrySet(), "&", "=", true);
        URL serverUrl = null;
        String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95";
        
        if (params != null) {
            serverUrl = new URL(url + "?" + paramString);
        } else {
            serverUrl = new URL(url);
        }
        HttpURLConnection conex = null;
        InputStream in = null;
        String response = null;

        if (method == null) {
            method = "GET";
        }
        try {
            conex = (HttpURLConnection) serverUrl.openConnection();
            conex.setRequestProperty("Host", "www.googleapis.com");
            conex.setRequestProperty("user-agent", userAgent);
            conex.setRequestProperty("Authorization", "Bearer " + this.getAccessToken());
            conex.setConnectTimeout(30000);
            conex.setReadTimeout(60000);
            conex.setRequestMethod(method);
            conex.setDoOutput(true);
            conex.connect();
            in = conex.getInputStream();
            response = Google.getResponse(in);
        } catch (java.io.IOException ioe) {
            if (conex != null) {
                Google.log.error("Ruta soliciatada: " + url + "?" + paramString +
                        "\nERROR in getRequest:" +
                        Google.getResponse(conex.getErrorStream()), ioe);
            } else {
                Google.log.error("ERROR in getRequest", ioe); 
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
    /**
     * Realiza los intercambios de informacion entre la aplicacion y Google+ a fin de refrescar el token
     * de acceso necesario para realizar peticiones al API de Google+
     * @param request la peticion HTTP con los datos a utilizar
     * @param response la respuesta HTTP con la informacion correspondiente a la peticion
     * @param paramRequest el objeto propio de SWB con informacion complementaria de la peticion realizada
     * @throws SWBResourceException en caso de ocurrir algun problema con el API de SWB
     * @throws IOException en caso de ocurrir algun problema de lectura/escritura con la respuesta generada
     */
    public String refreshToken(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
//        POST /oauth2/v3/token HTTP/1.1
//        Host: www.googleapis.com
//        Content-Type: application/x-www-form-urlencoded
//
//        client_id=8819981768.apps.googleusercontent.com&
//        client_secret={client_secret}&
//        refresh_token=1/6BMfW9j53gdGImsiyUH5kU5RsR4zwI9lUVX-tqf8JXQ&
//        grant_type=refresh_token
        return "";
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
    
    private void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException ex) {
            }
        }
    }
}
