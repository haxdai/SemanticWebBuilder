package org.semanticwb.social.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.social.Google;

/**
 * Genera el despliegue del muro de Google+ en la interface de SWBSocial, asi como
 * la organizacion y las opciones disponibles para la informacion mostrada.
 * @author jose.jimenez
 */
public class GooglePlusWall extends GenericResource {
    
    
    public static final Logger log = SWBUtils.getLogger(GooglePlusWall.class);
    
    /** suffix to identify a tab in the wall interface*/
    public static String HOME_TAB = "/myNovelties";
    
    /** suffix to identify a tab in the wall interface*/
    public static String FOLLOWERS_TAB = "/myFollowers";
    
    /** Url base for user profiles */
    public static final String PROFILE_URLBASE = "https://plus.google.com/";
    
    /**
     * Define el formato a utilizar para el despliegue de fechas [{@value yyyy-MM-dd'T'HH:mm:ss.SSS}]
     */
    public static DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String objUri = (String) request.getParameter("suri");
        String contentTabId = (String) request.getParameter("contentTabId");
        Google google = (Google) SemanticObject.createSemanticObject(objUri).createGenericInstance();
        if (!google.isSn_authenticated() || google.getAccessToken() == null) {
            out.println("<div id=\"configuracion_redes\">");
            out.println("<div id=\"autenticacion\">");
            out.println("<p>      La cuenta no ha sido autenticada correctamente</p>");
            out.println("</div>");
            out.println("</div>");
            return;
        }
        User user = SWBContext.getAdminUser();
        if (user == null) {
            response.sendError(403);
            return;
        }
        
        if (contentTabId == null) {//The resource is loaded for the first time and it needs to display the tabs
            String jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                                 paramRequest.getWebPage().getWebSiteId() + "/jsp/socialNetworks/googlePlusTabs.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception e) {
                GooglePlusWall.log.error("Error loading Google+ tabs", e);
            }
            return;
        }
        
        String jspResponse = "";
        //Each one of the tabs is loaded once
        if (contentTabId.equals(HOME_TAB)) {
            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                          paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/googlePlusNovelties.jsp";
//        } else if (contentTabId.equals(DISCOVER_TAB)) {
//            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
//                          paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/googlePlus.jsp";
//        } else if (contentTabId.equals(CONEXION)) {
//            jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
//                          paramRequest.getWebPage().getWebSiteId() +"/jsp/socialNetworks/googlePlus.jsp";
        }
        
        RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
        
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            GooglePlusWall.log.error("Error in doView() for requestDispatcher" , e);
        }
    }
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String mode = paramRequest.getMode();
        if (mode.equals("getActivities")) {
            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            doGetActivities(request, response, paramRequest);
        } else if (mode.equals("getPeople")) {
            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            doGetPeople(request, response, paramRequest);
        } else if (mode.equals("showUserProfile")) {
            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            RequestDispatcher dis = request.getRequestDispatcher(SWBPlatform.getContextPath() +
                    "/work/models/" + paramRequest.getWebPage().getWebSiteId() +
                    "/jsp/socialNetworks/googleUserProfile.jsp");
            try {
            request.setAttribute("paramRequest", paramRequest);
//                request.setAttribute("suri", objUri);
                dis.include(request, response);
            } catch (Exception e) {
                GooglePlusWall.log.error("Error in mode showUserProfile, dispatching request" , e);
            }
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
    
    /**
     * Obtiene las pubicaciones mas recientes en el perfil del usuario autenticado en bloques de 25
     * @param request la peticion HTTP creada por el cliente
     * @param response la respuesta HTTP generada para contestar la peticion
     * @param paramRequest objeto que contiene datos adicionales de la petición 
     *        del cliente correspondientes a la plataforma de SWB
     * @throws SWBResourceException si ocurre un problema con los elementos de la plataforma de SWB
     * @throws IOException si ocurre algun problema durante la lectura de la peticion del cliente
     *         o la escritura de la respuesta correspondiente
     */
    public void doGetActivities(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String objUri = request.getParameter("suri");
        User user = paramRequest.getUser();
        Google semanticGoogle = (Google) SemanticObject.createSemanticObject(URLDecoder.decode(objUri, "UTF-8")).createGenericInstance();
        String paramNextPageToken = request.getParameter("nextPageToken");//para hacer la peticion a G+
        boolean isFirstTime = paramNextPageToken == null || paramNextPageToken.isEmpty() ? true : false;
        String userAttributes = "http://www.semanticwebbuilder.org/swb4/social#SocialUserExtAttributes";

        if (!semanticGoogle.validateToken()) {//If was unable to refresh the token
            request.setAttribute("problem", "Problem refreshing access token");
        } else {
            HashMap<String, SemanticProperty> mapa = new HashMap<String, SemanticProperty>();
            Iterator<SemanticProperty> list = SWBPlatform.getSemanticMgr().getVocabulary().
                                              getSemanticClass(userAttributes).listProperties();
            while (list.hasNext()) {
                SemanticProperty sp = list.next();
                mapa.put(sp.getName(), sp);
            }
            boolean userCanRetopicMsg = ((Boolean) user.getExtendedAttribute(
                                        mapa.get("userCanReTopicMsg")));
            boolean userCanRespondMsg = ((Boolean) user.getExtendedAttribute(
                                        mapa.get("userCanRespondMsg")));
            boolean userCanRemoveMsg = ((Boolean) user.getExtendedAttribute(
                                       mapa.get("userCanRemoveMsg")));
            //Plus apiPlus = semanticGoogle.getApiPlusInstance();
            request.setAttribute("tabTitle", semanticGoogle.getTitle());
            request.setAttribute("userCanRetopicMsg", userCanRetopicMsg);
            request.setAttribute("userCanRespondMsg", userCanRespondMsg);
            request.setAttribute("userCanRemoveMsg", userCanRemoveMsg);
            
            HashMap<String, String> params = new HashMap<>(2);
            params.put("maxResults", "25");
            if (paramNextPageToken != null && !paramNextPageToken.isEmpty()) {
                params.put("pageToken", paramNextPageToken);
            }
            String googleResponse = semanticGoogle.apiRequest(params,
                    "https://www.googleapis.com/plus/v1/people/me/activities/public", "GET");
            JSONArray activities = null;
            String nextPageToken = null;
            try {
                JSONObject plusResponse = new JSONObject(googleResponse);
                if (!plusResponse.has("error") && plusResponse.has("items")) {
                    activities = plusResponse.getJSONArray("items");
                    nextPageToken = !plusResponse.isNull("nextPageToken") ? plusResponse.getString("nextPageToken") : "";
                }
            } catch (JSONException jsone) {
                GooglePlusWall.log.error("Al obtener actividades del Wall", jsone);
            }
            request.setAttribute("activities", activities);
            request.setAttribute("nextPageToken", nextPageToken);
            request.setAttribute("paramRequest", paramRequest);
            if (isFirstTime) {
                request.setAttribute("initial", isFirstTime);
            }
            String jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                                 paramRequest.getWebPage().getWebSiteId() +
                                 "/jsp/socialNetworks/googlePlusNovelties.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                dis.include(request, response);
            } catch (Exception e) {
                GooglePlusWall.log.error("Error al enviar flujo a googlePlusNovelties.jsp" , e);
            }
        }
    }
    
    /**
     * Obtiene las personas asociadas al perfil del usuario autenticado en bloques de 20 elementos.
     * @param request la peticion HTTP creada por el cliente
     * @param response la respuesta HTTP generada para contestar la peticion
     * @param paramRequest objeto que contiene datos adicionales de la petición 
     *        del cliente correspondientes a la plataforma de SWB
     * @throws SWBResourceException si ocurre un problema con los elementos de la plataforma de SWB
     * @throws IOException si ocurre algun problema durante la lectura de la peticion del cliente
     *         o la escritura de la respuesta correspondiente
     */
    public void doGetPeople(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String objUri = request.getParameter("suri");
//        User user = paramRequest.getUser();
        Google semanticGoogle = (Google) SemanticObject.createSemanticObject(URLDecoder.decode(objUri, "UTF-8")).createGenericInstance();
        String paramNextPageToken = request.getParameter("peopleNextPageToken");//para hacer la peticion a G+
        boolean isFirstTime = paramNextPageToken == null || paramNextPageToken.isEmpty() ? true : false;
        //PrintWriter out = response.getWriter();

        if (!semanticGoogle.validateToken()) {//If was unable to refresh the token
            request.setAttribute("problem", "Problem refreshing access token");
        } else {
            //Plus apiPlus = semanticGoogle.getApiPlusInstance();
            request.setAttribute("tabTitle", semanticGoogle.getTitle());
            
            HashMap<String, String> params = new HashMap<>(2);
            params.put("maxResults", "20");
            if (paramNextPageToken != null && !paramNextPageToken.isEmpty()) {
                params.put("pageToken", paramNextPageToken);
            }
            String googleResponse = semanticGoogle.apiRequest(params,
                    "https://www.googleapis.com/plus/v1/people/me/people/visible", "GET");
            JSONArray people = null;
            String nextPageToken = null;
            try {
                JSONObject plusResponse = new JSONObject(googleResponse);
                if (!plusResponse.has("error") && plusResponse.has("items")) {
                    people = plusResponse.getJSONArray("items");
                    nextPageToken = !plusResponse.isNull("nextPageToken")
                                    ? plusResponse.getString("nextPageToken")
                                    : ""; //para la interface del listado
                }
            } catch (JSONException jsone) {
                GooglePlusWall.log.error("Al obtener contactos del Wall", jsone);
            }
            request.setAttribute("people", people);
            request.setAttribute("peopleNextPageToken", nextPageToken);
            request.setAttribute("paramRequest", paramRequest);
            if (isFirstTime) {
                request.setAttribute("initial", isFirstTime);
            }
            String jspResponse = SWBPlatform.getContextPath() + "/work/models/" +
                                 paramRequest.getWebPage().getWebSiteId() +
                                 "/jsp/socialNetworks/googlePlusCircles.jsp";
            RequestDispatcher dis = request.getRequestDispatcher(jspResponse);
            try {
                dis.include(request, response);
            } catch (Exception e) {
                GooglePlusWall.log.error("Error al enviar flujo a googlePlusCircles.jsp" , e);
            }
        }
    }
    
    /**
     * Crea el HTML a desplegar para un comentario, como parte de una lista de HTML
     * @param comment el objeto plus#comment en formato JSON con la informacion a mostrar
     * @param paramRequest objeto del cual se obtienen los textos internacionalizados a mostrar
     * @param objUri parametro incluido en los vinculos usados en la interface, identifica el objeto de la red social
     * @param actId identificador de la actividad asociada con el comentario mostrado.
     *                Se utiliza como parametro en los vinculos utilizados en la interface
     * @param parentCommentId identificador del comentario de primer nivel asociado al comentario a mostrar
     * @return el String que contiene el HTML generado para el elemento de lista con la 
     *         informacion contenida en {@code comment}
     */
    public static String assembleCommentHtml(JSONObject comment, SWBParamRequest paramRequest,
            String objUri, String actId, String parentCommentId) {

        StringBuilder output = new StringBuilder(256);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy hh:mm a", new Locale("es", "MX"));
        
        output.append("<li>\n");
        try {
            JSONObject actor = comment != null && !comment.isNull("actor")
                               ? comment.getJSONObject("actor") : null;
            String authorId = actor != null && !actor.isNull("id") ? actor.getString("id") : "";
            String authorImageUrl = actor != null && !actor.isNull("image") && !actor.getJSONObject("image").isNull("url")
                                    ? actor.getJSONObject("image").getString("url") : "";
            String authorName = actor != null && !actor.isNull("displayName")
                                ? actor.getString("displayName") : "";
            String userProfileURL = !authorId.isEmpty()
                    ? paramRequest.getRenderUrl().setMode("showUserProfile").setParameter("id", authorId).setParameter("suri", objUri).toString()
                    : "";
            
            if (!userProfileURL.isEmpty() && !authorImageUrl.isEmpty()) {
                output.append("<a href=\"#\" title=\"");
                output.append(paramRequest.getLocaleString("viewProfile"));
                output.append("\" onclick=\"showDialog('");
                output.append(userProfileURL);
                output.append("', '");
                output.append(paramRequest.getLocaleString("viewProfile"));
                output.append("'); return false;\"><img src=\"");
                output.append(authorImageUrl);
                output.append("\" width=\"50\" height=\"50\"/></a>\n");
            }
            output.append("<p>\n");
            output.append("  <a href=\"#\" title=\"");
            output.append(paramRequest.getLocaleString("viewProfile"));
            output.append("\" onclick=\"showDialog('");
            output.append(userProfileURL);
            output.append("', '");
            output.append(paramRequest.getLocaleString("viewProfile"));
            output.append("'); return false;\">");
            output.append(authorName);
            output.append("</a>:\n");
            JSONObject commentObject = comment != null && !comment.isNull("object")
                    ? comment.getJSONObject("object") : null;
            String originalContent = null;
            if (commentObject != null && !commentObject.isNull("content")) {
                originalContent = commentObject.getString("content").replace("\n", "</br>");
                output.append(originalContent);
            }
            output.append("</p>\n");
            output.append("<p class=\"timelinedate\">\n");
            //out.write("<span dojoType=\"dojox.layout.ContentPane\">");
            output.append("<span class=\"inline\">\n");

            if (comment != null && !comment.isNull("published")) {
                Date date = GooglePlusWall.FORMATTER.parse(comment.getString("published"));
                output.append(df.format(date));
            }
            output.append("&nbsp; </span>\n");
            String comentarioId = comment.getString("id");
//            output.append("   <span class=\"inline\">\n");
//            output.append(" <a href=\"\" onclick=\"showDialog('");
//            output.append(paramRequest.getRenderUrl().setMode("commentComment").
//                            setParameter("suri", objUri).
//                            setParameter("actId", actId).
//                            setParameter("commentId", comentarioId));
//            output.append("', 'Comment to ");
//            if (originalContent != null) {
//                output.append(originalContent);
//            }
//            output.append("');return false;\">");
//            output.append(paramRequest.getLocaleString("comment"));
//            output.append("</a>\n");
//            output.append("   </span>\n");
            output.append("</p>\n");
        } catch (org.json.JSONException jsone) {
            GooglePlusWall.log.error("Assembling text for comments", jsone);
        } catch (java.text.ParseException pe) {
            GooglePlusWall.log.error("Assembling text for comments", pe);
        } catch (SWBResourceException swbre) {
            GooglePlusWall.log.error("Assembling text for comments", swbre);
        }
        output.append("</li>\n");
        return output.toString();
    }
    
}
