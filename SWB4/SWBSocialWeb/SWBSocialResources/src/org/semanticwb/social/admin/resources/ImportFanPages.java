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

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.FacePageTab;
import org.semanticwb.social.Facebook;
import org.semanticwb.social.FacebookFanPage;
import org.semanticwb.social.SocialSite;

/**
 *
 * @author francisco.jimenez
 */
public class ImportFanPages extends GenericResource {
    
    
    public static Logger log = SWBUtils.getLogger(ImportFanPages.class);
    
    /** Accion utilizada cuando el sitio relacionado no es instancia de {@code SocialSite} [{@literal importFBPagesForAdmin}] */
    public static String IMPORT_FB_PAGES = "importFBPages";
    
    /** Accion utilizada desde la interface de la administracion [{@literal importFBPagesForAdmin}] */
    public static String IMPORT_FB_PAGES_FOR_ADMIN = "importFBPagesForAdmin";

    /** Permisos relacionados para administrar paginas de Fans {@literal manage_pages,publish_pages} */
    public static String PERMISSIONS = "manage_pages,publish_pages";
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        final String path = SWBPlatform.getContextPath() + "/work/models/" +
                paramRequest.getWebPage().getWebSiteId() + "/jsp/fanPages/importFPFacebook.jsp";
        request.setAttribute("paramRequest", paramRequest);
        
        try {
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.include(request, response);
        } catch (Exception e) {
            ImportFanPages.log.error("Error in: " + e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response)
            throws SWBResourceException, IOException {
        
        String action = response.getAction();
        WebPage rootPage = null;
        if (action.equals(ImportFanPages.IMPORT_FB_PAGES)) {
            String suri = request.getParameter("suri") == null ? "" : request.getParameter("suri");
            String site = request.getParameter("site") == null ? "" : request.getParameter("site");
            String pages[] = request.getParameterValues("pages") == null
                    ? null : request.getParameterValues("pages");
            //add facebook pages
            if (suri.isEmpty() || site.isEmpty() || pages == null) {
                response.setMode(SWBResourceURL.Mode_HELP);
                return;
            }
            
            Facebook facebook = (Facebook) SemanticObject.createSemanticObject(suri).createGenericInstance();
            WebSite wsite = WebSite.ClassMgr.getWebSite(site);
            
            //WebPage homePage = wsite.getHomePage();
            WebPage homePage = WebPage.ClassMgr.getWebPage("Fan_Pages", wsite);
            if (homePage == null) {
                homePage = WebPage.ClassMgr.createWebPage("Fan_Pages", wsite);
                homePage.setTitle("Fan Pages");
                homePage.setParent(wsite.getHomePage());
                homePage.setActive(true);
            }
            WebPage rootFP = WebPage.ClassMgr.getWebPage(facebook.getFacebookUserId(), wsite);
            if (rootFP == null) {
                rootFP = WebPage.ClassMgr.createWebPage(facebook.getFacebookUserId(), wsite);
                rootFP.setActive(true);
            }
            rootPage = rootFP;
            rootFP.setTitle(facebook.getTitle() + " Fan Pages");
            rootFP.setParent(homePage);
            HashMap<String, String> params = new HashMap<String, String>(2);
            
            params.put("access_token", facebook.getAccessToken());
            String respFanPage = facebook.getRequest(params, Facebook.FACEBOOKGRAPH + "me/accounts",
                                Facebook.USER_AGENT);
            try {
                JSONObject responseFP = new JSONObject(respFanPage);
                if (!responseFP.isNull("data")) {
                    if (responseFP.getJSONArray("data").length() > 0) {
                        JSONArray jarr = responseFP.getJSONArray("data");
                        for (int i = 0 ; i <  jarr.length() ; i++) {
                            JSONObject entryFP = jarr.getJSONObject(i);
                            boolean selectedFanPage = false;
                            for (int j = 0; j < pages.length; j++) {//check if the page was selected
                                if (pages[j].equals(entryFP.getString("id"))) {
                                    selectedFanPage = true;
                                    break;
                                }
                            }
                            
                            if (selectedFanPage) {//import this page
                                String id = "";
                                String name = "";
                                String token = "";
                                if (!entryFP.isNull("id")) {
                                    id = entryFP.getString("id");
                                }
                                if (!entryFP.isNull("name")) {
                                    name = entryFP.getString("name");
                                }
                                if (!entryFP.isNull("access_token")) {
                                    token = entryFP.getString("access_token");
                                }
                                if (!id.isEmpty() && !token.isEmpty()) {//Add the Fan Pages
                                    FacebookFanPage ffp = FacebookFanPage.ClassMgr.getFacebookFanPage(id, wsite);
                                    if (ffp == null) {
                                        ffp = FacebookFanPage.ClassMgr.createFacebookFanPage(id, wsite);
                                        ffp.setActive(true);
                                    }
                                    ffp.setPage_id(id);
                                    ffp.setTitle(name);
                                    ffp.setPageAccessToken(token);
                                    ffp.setParent(rootFP);
                                    ffp.setSn_socialNet(facebook);
                                    createFPTabs(facebook, ffp, wsite);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException jsone) {
                ImportFanPages.log.error("Unable to add facebook pages", jsone);
            }
            
            
            /*for(int i = 0; i < pages.length; i++){
                String pageId = pages[i];
                
                try{
                    JSONObject page = new JSONObject(respFanPage);
                    if(page.isNull("error")){
                        log.error("Fan page with id does not exist." + page);
                        continue;
                    }
                    String id = "";
                    String name = "";
                    String description ="";
                    String token = "";
                }catch(JSONException jsone){
                    log.error("Unable to add fan page ", jsone );
                    continue;
                }
                
            }*/
            response.setRenderParameter("accountName", facebook.getTitle());
            response.setRenderParameter("homePageSuri", wsite.getHomePage().getEncodedURI());
            response.setMode(SWBResourceURL.Mode_HELP);
        } else if (action.equals(IMPORT_FB_PAGES_FOR_ADMIN)) {
            String suri = request.getParameter("suri") == null ? "" : request.getParameter("suri");
            String site = request.getParameter("site") == null ? "" : request.getParameter("site");
            String pages[] = request.getParameterValues("pages") == null ? null : request.getParameterValues("pages");
            //add facebook pages
            if (suri.isEmpty() || site.isEmpty() || pages == null) {
                response.setMode(SWBResourceURL.Mode_HELP);
                return;
            }
            Facebook facebook = (Facebook) SemanticObject.createSemanticObject(suri).createGenericInstance();
            SocialSite wsite = SocialSite.ClassMgr.getSocialSite(site);
            HashMap<String, String> params = new HashMap<String, String>(2);
            params.put("access_token", facebook.getAccessToken());
            
            String respFanPage = facebook.getRequest(params,
                    Facebook.FACEBOOKGRAPH + "me/accounts", Facebook.USER_AGENT);
            ////System.out.println("respFanPage:" + respFanPage);
            try {
                JSONObject responseFP = new JSONObject(respFanPage);
                if (!responseFP.isNull("data")) {
                    if (responseFP.getJSONArray("data").length() > 0) {
                        JSONArray jarr = responseFP.getJSONArray("data");
                        for (int i = 0 ; i <  jarr.length() ; i++) {
                            JSONObject entryFP = jarr.getJSONObject(i);
                            boolean selectedFanPage = false;
                            for (int j = 0; j < pages.length; j++) {//check if the page was selected
                                if (pages[j].equals(entryFP.getString("id"))) {
                                    selectedFanPage = true;
                                    break;
                                }
                            }
                            
                            if (selectedFanPage) {//import this page
                                String id = "";
                                String name = "";
                                String token = "";
                                
                                if (!entryFP.isNull("id")) {
                                    id = entryFP.getString("id");
                                }
                                if (!entryFP.isNull("name")) {
                                    name = entryFP.getString("name");
                                }
                                if (!entryFP.isNull("access_token")) {
                                    token = entryFP.getString("access_token");
                                }
                                if (!id.isEmpty() && !token.isEmpty()) {//Add the Fan Pages
                                    Facebook fanpage = Facebook.ClassMgr.createFacebook(wsite);
                                    fanpage.setAccessToken(token);
                                    fanpage.setSn_authenticated(true);
                                    fanpage.setTitle(name);
                                    fanpage.setActive(true);
                                    fanpage.setFacebookUserId(id);
                                    fanpage.setIsFanPage(true);
                                }
                            }
                        }
                    }
                }
                response.setRenderParameter("accountName", facebook.getTitle());
                response.setRenderParameter("reloadGroup", wsite.getEncodedURI());
                response.setMode(SWBResourceURL.Mode_HELP);
            } catch (JSONException jsone) {
                ImportFanPages.log.error("Unable to add facebook pages", jsone);
            }
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
    
        String mode = paramRequest.getMode();
        if (mode != null && mode.equals("getPermission")) {
            doGetPermission(request, response, paramRequest);
        } else if (mode != null && mode.equals("closeWin")) {
            doCloseWin(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
     }

    
    
    @Override
    public void doHelp(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        PrintWriter out = response.getWriter();
        String brandSuri = request.getParameter("reloadGroup") == null
                ? null : URLDecoder.decode(request.getParameter("reloadGroup"));
        //WebPage reloadPage = (WebPage)SemanticObject.createSemanticObject(URLDecoder.decode(request.getParameter("homePageSuri"))).createGenericInstance();
        
        out.println("<div id=\"configuracion_redes\">");
        out.println("<p>Las p&aacute;ginas de Fans seleccionadas de la cuenta <strong>" +
                request.getParameter("accountName") +
                "</strong> fueron importadas correctamente.</p>");
        out.println("</div>");
        out.println("<script type=\"text/javascript\">");        
        if (brandSuri != null) {
            out.println("try{");
            out.println("reloadTreeNodeByURI(\"HN|" + brandSuri +
                    "|http://www.semanticwebbuilder.org/swb4/social#hn_Facebook\");");
            out.println("}catch(e){}");
        } else {
            out.println("updateTreeNodeByURI('" + URLDecoder.decode(request.getParameter("homePageSuri")) + "');");
            out.println("parent.updateTreeNodeByURI('" + URLDecoder.decode(request.getParameter("homePageSuri")) + "');");
            //out.println("parent.parent.updateTreeNodeByURI('"+ URLDecoder.decode(request.getParameter("homePageSuri"))+"');");
        }
        //out.println("addItemByURI(mtreeStore, null, '" + reloadPage.getURI() + "');");
        //out.printl("alert('done');");
        out.println("</script>");

    }
    
    private boolean createFPTabs(Facebook facebook, FacebookFanPage fp, WebSite wsite) {
    
        if (fp == null || facebook == null) {
                return false;
        }

        try {
            HashMap<String, String> params = new HashMap<String, String>(2);
            params.put("access_token", fp.getPageAccessToken());
            String pageTabs = facebook.getRequest(params, Facebook.FACEBOOKGRAPH + fp.getPage_id() + "/tabs",
                    Facebook.USER_AGENT);
            JSONObject jsonObject = new JSONObject(pageTabs);
            if (jsonObject.has("data")) {
                JSONArray data = jsonObject.getJSONArray("data");
                if (data.length() > 0 ) {
                    for (int i =0 ; i < data.length() ; i++) {
                        JSONObject tmp = data.getJSONObject(i);
                        String id = "";
                        String name = "";
                        String position = "";
                        String appId = "";
                        
                        //Do not import page if is not an application
                        //or its the likes/photos tab.
                        if (tmp.isNull("application") ||
                                tmp.getString("name").equalsIgnoreCase("likes") ||
                                tmp.getString("name").equalsIgnoreCase("photos")) {
                            continue;
                        }
                        
                        if (!tmp.isNull("id")) {
                            id = tmp.getString("id");
                            id = id.replace('/', '_');
                            //appId = id.substring(id.lastIndexOf("_") + 1);
                            appId = tmp.getJSONObject("application").getString("id");
                        }
                        if (!tmp.isNull("name")) {
                            name = tmp.getString("name");
                        }
                        if (!tmp.isNull("position")) {
                            position = tmp.getLong("position") + "";
                        }
                        
                        if (id.isEmpty() || name.isEmpty() || position.isEmpty()) {
                            ImportFanPages.log.error("Fan page tab not added to Social:" + tmp);
                            continue;
                        }
                        
                        FacePageTab tmpftp = FacePageTab.ClassMgr.getFacePageTab(id, wsite);
                        if (tmpftp == null) {
                            //Search a facebook tab defined manually inside the fan page
                            Iterator<WebPage> tabs = fp.listChilds();
                            while (tabs.hasNext()) {
                                FacePageTab tab = (FacePageTab)tabs.next();
                                if (tab.getFace_appid() != null) {
                                    if (tab.getFace_appid().equals(appId)) {
                                        tmpftp = tab;
                                        break;
                                    }
                                }
                            }
                            
                            //If no fan page tab found then create it!
                            if ( tmpftp == null) {
                                tmpftp = FacePageTab.ClassMgr.createFacePageTab(id, wsite);
                                tmpftp.setActive(true);
                            }
                        }
                        tmpftp.setTitle(name);
                        tmpftp.setFace_appid(appId);
                        tmpftp.setSortName(position);
                        //set the social account!!
                        tmpftp.setParent(fp);
                    }
                }
            }
        } catch (Exception ex) {
            ImportFanPages.log.error("Problem getting list of current tabs from page ", ex );
        }
        return false;
    }
    
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
        if (containerId != null && !containerId.isEmpty()) {
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
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html>");
        out.println("<head>");
        out.println("<script type=\"text/javascript\">");
        out.println("  this.opener.reloadSocialTab('" + containerId + "');");
        out.println("  window.close();");
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
