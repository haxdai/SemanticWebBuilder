/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.social.admin.resources.mobile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.AdminFilter;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBParamRequestImp;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.social.Message;
import org.semanticwb.social.Photo;
import org.semanticwb.social.PostOut;
import org.semanticwb.social.PostOutNet;
import org.semanticwb.social.PostOutPrivacyRelation;
import org.semanticwb.social.SocialNetwork;
import org.semanticwb.social.SocialSite;
import org.semanticwb.social.Video;
import org.semanticwb.social.Youtube;
import org.semanticwb.social.admin.resources.SocialDocumentsToAuhorize;
import org.semanticwb.social.util.SocialLoader;

/**
 *
 * @author jorge.jimenez
 */
public class SocialDocumentsToAuthorizeMobile extends GenericResource {

    /**
     * The log.
     */
    private static Logger log = SWBUtils.getLogger(SocialDocumentsToAuthorizeMobile.class);
    public static final String Mode_SOURCE = "source";
    public static final String Mode_AUTH_OR_REJ = "authOrReject";
    public static final String Mode_RELOAD = "reload";
    private static final String Mode_ShowMoreNets = "showMoreNets";
    private static final String Mode_ViewPostOut = "viewPostOut";
    private static final String Mode_ViewPostIn="viewPostIn";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        ////System.out.println("Entrando al process Request:" + paramRequest.getMode());
        final String mode = paramRequest.getMode();
        if(Mode_ViewPostIn.equals(mode)){
            doShowPostIn(request, response, paramRequest);
        }else if(Mode_ViewPostOut.equals(mode)){
            doShowPostOut(request, response, paramRequest);
        }else if (Mode_SOURCE.equals(mode)) {
            doShowSource(request, response, paramRequest);
        } else if (Mode_ShowMoreNets.equals(mode)) {
            doShowMoreNets(request, response, paramRequest);
        } else if(Mode_AUTH_OR_REJ.equals(mode)){
            doAcceptOrReject(request, response, paramRequest);
        }else if(Mode_RELOAD.equals(mode)){
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("   hideDialog();");
            out.println("   var objid= '" + paramRequest.getWebPage().getURI() +"/tab';");
            out.println("   var tab = dijit.byId(objid);");
            out.println("   if(tab){");
            out.println("       tab.refresh()");
            out.println("   }");
            out.println("   showStatus('" + paramRequest.getLocaleString("updatedMessage") +  "');");
            out.println("</script>");
        }else{
            super.processRequest(request, response, paramRequest);
        }
    }


    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#processAction(javax.servlet.http.HttpServletRequest, org.semanticwb.portal.api.SWBActionResponse)
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        /*//System.out.println("**************************processAction:");
        //System.out.println(request.getParameter("site"));
        //System.out.println(request.getParameter("res"));
        //System.out.println(request.getParameter("wbaction"));
        //System.out.println(request.getParameter("firstLoad"));
        //System.out.println(request.getParameter("msg"));*/
        User user = response.getUser();
        response.setRenderParameter("site", request.getParameter("site"));
        //response.setRenderParameter("firstLoad", request.getParameter("firstLoad"));
        response.setMode(Mode_RELOAD);
        if (request.getParameter("msg") != null && request.getParameter("site") != null && request.getParameter("wbaction") != null && request.getParameter("res") != null) {
            WebSite site = SWBContext.getWebSite(request.getParameter("site"));
            if (site != null) {
                SemanticObject semObj = SemanticObject.getSemanticObject(request.getParameter("res"));
                if (semObj == null) {
                    return;
                }
                if (!(semObj.createGenericInstance() instanceof PostOut)) {
                    return;
                }
                PostOut postOut = (PostOut) semObj.createGenericInstance();
                if (postOut != null && SocialLoader.getPFlowManager().isReviewer(postOut, user)) {
                    String msg = request.getParameter("msg");
                    if (!msg.trim().equals("")) {
                        String action = request.getParameter("wbaction");
                        if (action.equals("a")) {
                            SocialLoader.getPFlowManager().approveResource(postOut, user, msg);
                        }
                        if (action.equals("r")) {
                            SocialLoader.getPFlowManager().rejectResource(postOut, user, msg);
                        }
                    }
                }
                response.setMode(SWBResourceURL.Mode_VIEW);
                response.setRenderParameter("site", site.getId());
            }
        }
    }

    
    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#doView(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.semanticwb.portal.api.SWBParamRequest)
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String lang = paramRequest.getUser().getLanguage();
        int show = 1;
        //String firstLoad = request.getParameter("firstLoad");
        /*//System.out.println("Entrando al doView");
        //System.out.println("First Load:" + request.getParameter("firstLoad"));
        //System.out.println("show:" + request.getParameter("show"));
        //System.out.println("site:" + request.getParameter("site"));*/
        if (request.getParameter("show") != null) {
            try {
                show = Integer.parseInt(request.getParameter("show"));
            } catch (Exception e) {
                log.event(e);
            }
        }
        WebSite sitetoShow = null;
        if (request.getParameter("site") != null) {
            sitetoShow = SWBContext.getWebSite(request.getParameter("site"));
        }
        User user = paramRequest.getUser();
        PrintWriter out = response.getWriter();
        Iterator<WebSite> sites = SWBContext.listWebSites();
        while (sites.hasNext()) {
            WebSite site = sites.next();
            if (!(site.getId().equals(SWBContext.WEBSITE_ADMIN) || site.getId().equals(SWBContext.WEBSITE_GLOBAL) || site.getId().equals(SWBContext.WEBSITE_ONTEDITOR))) {
                if (sitetoShow == null) {
                    sitetoShow = site;

                }
            }
        }
        //if(firstLoad == null){
            ////System.out.println("This is the first time of doView");
            //out.println("<style type=\"text/css\">");
            //out.println("@import \"/swbadmin/js/dojo/dojo/resources/dojo.css\";");
            //out.println("@import \"/swbadmin/js/dojo/dijit/themes/soria/soria.css\";");
            //out.println("@import \"/swbadmin/css/swb.css\";");
            //out.println("@import \"/swbadmin/css/swbsocial.css\";");
            //out.println("@import \"/swbadmin/js/dojo/dojox/grid/resources/soriaGrid.css\";");
            //out.println("@import \"/swbadmin/js/dojo/dojox/grid/resources/Grid.css\";");
            //out.println("");
            //out.println("html, body, #main{");
            //out.println("overflow: auto;");
            //out.println("}");
            //out.println("</style>  ");
            //out.println("");
            //out.println("");
        //}else{
                ////System.out.println("THIS IS ANOTHER CALL (=" + firstLoad);
        //}

        //out.println("<div class=\"swbform\">");
    //out.println("<div class=\"row\">");
    //out.println("<div class=\"col-md-12\">");
    out.println("<div class=\"panel panel-default\">");
    out.println("<div class=\"panel-heading\"> ");
        out.println("<div id=\"pub-detalle_\">");
        out.println("</br>");
        out.println("<form type=\"dijit.form.Form\" id=\"frmseecontentsToAuthorize\" name=\"frmseecontentsToAuthorize\" action=\"" + paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT) + "\" method=\"post\">");
        //out.println("<fieldset>");
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-md-6\">");
        //out.println("<input type='hidden' name='firstLoad' value='false'></input>");
        out.println( paramRequest.getLocaleString("selectABrand") + ":");
        out.println("<select name='site' onchange=\"submitForm(\'frmseecontentsToAuthorize\')\">");
        
        ArrayList<SocialSite> aListSites=new ArrayList();
        
        UserGroup userSuperAdminGrp = SWBContext.getAdminWebSite().getUserRepository().getUserGroup("su");
        if(user.hasUserGroup(userSuperAdminGrp)){//is super user-> can see everything
            Iterator<SocialSite> itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage());
            while(itSocialSites.hasNext())
            {
                SocialSite socialSite=itSocialSites.next();
                if(socialSite.isValid())
                {
                    if (sitetoShow.getId().equals(socialSite.getId())) {
                        out.println("<option selected=\"true\" value='" + socialSite.getId() + "'>" + socialSite.getTitle() + "</option>");
                    } else {
                        out.println("<option value='" + socialSite.getId() + "'>" + socialSite.getTitle() + "</option>");
                    }
                }
            }
        }else{
            Iterator<SocialSite> itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage());  
            while(itSocialSites.hasNext())
            {
                SocialSite socialSite=itSocialSites.next();
                if(socialSite.isValid())
                {
                    Iterator<AdminFilter> userAdmFilters=user.listAdminFilters();
                    while(userAdmFilters.hasNext())
                    {
                        AdminFilter userAdmFilter=userAdmFilters.next();
                        if(userAdmFilter.haveTreeAccessToSemanticObject(socialSite.getSemanticObject()))
                        {
                            aListSites.add(socialSite);
                            if (sitetoShow.getId().equals(socialSite.getId())) {
                                out.println("<option selected=\"true\" value='" + socialSite.getId() + "'>" + socialSite.getTitle() + "</option>");
                            } else {
                                out.println("<option value='" + socialSite.getId() + "'>" + socialSite.getTitle() + "</option>");
                            }
                        }
                    }
                }
            }
            
            if(aListSites.isEmpty() && (!user.listAdminFilters().hasNext())){//User has not admin filters and the data is Empty
                itSocialSites=sortByDisplayNameSet(SocialSite.ClassMgr.listSocialSites(), user.getLanguage());
                while(itSocialSites.hasNext())
                {
                    SocialSite socialSite=itSocialSites.next();
                    if(socialSite.isValid() && user.haveAccess(socialSite))
                    {
                        if (sitetoShow.getId().equals(socialSite.getId())) {
                            out.println("<option selected=\"true\" value='" + socialSite.getId() + "'>" + socialSite.getTitle() + "</option>");
                        } else {
                            out.println("<option value='" + socialSite.getId() + "'>" + socialSite.getTitle() + "</option>");
                        }
                    }
                }
            }
        }

        out.println("</select>");
        out.println("</div>");
        out.println("<div class=\"col-md-6\">");
        String selected = "";
        if (show == 1) {
            selected = "checked";
        }
        out.println("<input " + selected + " onClick=\"submitForm(\'frmseecontentsToAuthorize\')\" dojoType=\"dijit.form.RadioButton\" type='radio' id='show1' name='show' value='1'/>" + paramRequest.getLocaleString("all") + "");
        selected = "";
        if (show == 2) {
            selected = "checked";
        }
        out.println("<input " + selected + " onClick=\"submitForm(\'frmseecontentsToAuthorize\')\" dojoType=\"dijit.form.RadioButton\" type='radio' id='show2'  name='show' value='2'/>" + paramRequest.getLocaleString("mydocuments") + "");
        selected = "";
        if (show == 3) {
            selected = "checked";
        }

        out.println("<input " + selected + " onClick=\"submitForm(\'frmseecontentsToAuthorize\')\" dojoType=\"dijit.form.RadioButton\" type='radio' id='show3' name='show' value='3'/>" + paramRequest.getLocaleString("forauthorize") + "");
        //out.println("</fieldset>");
        out.println("</div>");
        out.println("</div>");
        out.println("</form>");          
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"panel-body swbnopadding\">");
        if (sitetoShow != null) {
            //out.println("<div class=\"row\">");
            //out.println("<div class=\"col-md-12\">");
            PostOut[] resources;
            if (show == 1) {
                resources = SocialLoader.getPFlowManager().getContentsAtFlowAll(sitetoShow);
            } else if (show == 3) {
                resources = SocialLoader.getPFlowManager().getContentsAtFlow(user, sitetoShow);
            } else {
                resources = SocialLoader.getPFlowManager().getContentsAtFlowOfUser(user, sitetoShow);
            }

            if (resources.length > 0) {
                // create dialog                                
                out.println("<form class=\"swbform\" method='post' action='#'>");
                out.println("<fieldset>");

                out.println("<table class=\"tabla1\">");
                out.println("<tr>");
                //out.println("<th class=\"accion\"> ");
                out.println("<th class=\"accion\"> ");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("action"), "UTF-8"));
                out.println("</th>");
                out.println("<th>");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("type"), "UTF-8"));
                out.println("</th>");
                out.println("<th>");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("title"), "UTF-8"));
                out.println("</th>");
                out.println("<th>");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("topic"), "UTF-8"));
                out.println("</th>");
                /*
                out.println("<th>");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("flow"), "UTF-8"));
                out.println("</th>");
                out.println("<th>");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("step"), "UTF-8"));
                out.println("</th>");
                * */
                out.println("<th>");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("socialNet"), "UTF-8"));
                out.println("</th>");
                out.println("<th>");
                out.println(SWBUtils.TEXT.encode(paramRequest.getLocaleString("source"), "UTF-8"));
                out.println("</th>");
                out.println("</tr>");
                for (PostOut resource : resources) {
                    out.println("<tr>");

                    
                    //WebSite wsite = SWBContext.getAdminWebSite();
                    /*
                    WebPage wpShowPostOut = wsite.getWebPage("ShowPostOut");
                    Resource resrPostOut = wsite.getResource("143");
                    request.setAttribute("postOut", resource.getId());

                    SWBParamRequestImp paramreq = new SWBParamRequestImp(request, resrPostOut, wpShowPostOut, user);
                    //SWBResourceURL urlpreview = paramreq.getRenderUrl().setCallMethod(SWBParamRequestImp.Call_DIRECT);
                    SWBResourceURL urlpreview = paramreq.getRenderUrl();
                    urlpreview.setParameter("postOut", resource.getURI());
                    urlpreview.setParameter("wsite", resource.getSemanticObject().getModel().getName());
                    urlpreview.setParameter("mobileMode", "1");
                    * */
                    out.println("<td class=\"accion\">");
                    try {
                        //String id = resource.getEncodedURI().replace('%', '_').replace(':', '_').replace('/', '_');
                        //out.println("<a class=\"ver\" title=\"" + paramRequest.getLocaleString("properties") + "\" onclick=\"showDialog('" + urlpreview + "','" + paramRequest.getLocaleString("postOutMsg") + "'); return false;\" href=\"#\"></a>");
                        //out.println("<a class=\"ver\" title=\"" + paramRequest.getLocaleString("properties") + "\" onclick=\"window.location.href='"+urlpreview+"';\" href=\"#\"></a>");
                        out.println("<a class=\"ver\" title=\"" +  paramRequest.getLocaleString("properties") + "\" href=\"#\" onclick=\"submitUrl('"+paramRequest.getRenderUrl().setMode(Mode_ViewPostOut).setParameter("postOut", resource.getURI())+"',this); return false;\"></a>");
                        if (SocialLoader.getPFlowManager().isReviewer(resource, user)) {
                            //out.println("<a title=\"" + paramRequest.getLocaleString("edit") + "\" href=\"#\" onclick=\"parent.selectTab('" + resource.getURI() + "','" + SWBPortal.getContextPath() + "/swbadmin/jsp/objectTab.jsp','" + "TEST" + "','bh_AdminPorltet');return false;\"><img  src=\"" + imgedit + "\"></a>");
                            //out.println("<a class=\"editar\" title=\"" + paramRequest.getLocaleString("edit") + "\" href=\"#\" onclick=\"parent.selectTab('" + resource.getURI() + "','" + SWBPortal.getContextPath() + "/swbadmin/jsp/objectTab.jsp','" + "TEST" + "','bh_AdminPorltet');return false;\"></a>");
                            //out.println("<a title=\"" + paramRequest.getLocaleString("authorize") + "\" href=\"#\" onclick=\"showAuthorize('" + resource.getURI() + "')\"><img  src=\"" + imgauthorize + "\"></a>");
                            //out.println("<a class=\"autorizar\" title=\"" + paramRequest.getLocaleString("authorize") + "\" href=\"" + paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setParameter("site", sitetoShow.getId()).setParameter("resourceId", resource.getURI()).setParameter("wbaction", "a").setParameter("mobileMode", "1") +"';\"></a>");
                            out.println("<a class=\"autorizar\" title=\"" + paramRequest.getLocaleString("authorize") + "\" href=\"#\" onclick=\"submitUrl('"+paramRequest.getRenderUrl().setMode(Mode_AUTH_OR_REJ).setParameter("site", sitetoShow.getId()).setParameter("resourceId", resource.getURI()).setParameter("wbaction", "a")+"',this); return false;\"></a>");
                            //onclick="submitUrl('<%=url.setAction("deletePhoto").setParameter("idPhoto", sphoto).setParameter("postOut", pOut)%>',this); return false; "
                            //out.println("<a title=\"" + paramRequest.getLocaleString("reject") + "\" href=\"#\" onclick=\"showReject('" + resource.getURI() + "')\"><img  src=\"" + imgreject + "\"></a>");
                            out.println("<a class=\"rechazar\" title=\"" + paramRequest.getLocaleString("reject") + "\" href=\"#\" onclick=\"submitUrl('"+paramRequest.getRenderUrl().setMode(Mode_AUTH_OR_REJ).setParameter("site", sitetoShow.getId()).setParameter("resourceId", resource.getURI()).setParameter("wbaction", "r")+"',this); return false;\"></a>");
                            //out.println("<a class=\"eliminar\" title=\"" + paramRequest.getLocaleString("reject") + "\" href=\"#\" onclick=\"showReject('" + resource.getURI() + "')\"></a>");
                        }
                    } catch (Exception e) {
                        log.error(e);
                    }

                    out.println("</td>");

                    out.println("<td width='10%'>");
                    out.println(resource instanceof Message ? "<img title=\"Texto\" src=\" " + SWBPlatform.getContextPath() + " /swbadmin/css/images/mobile_tipo-txt.jpg\" border=\"0\" alt=\"  " + paramRequest.getLocaleString("message") + "  \">" : resource instanceof Photo ? "<img title=\"Imagen\" src=\" " + SWBPlatform.getContextPath() + " /swbadmin/css/images/mobile_tipo-img.jpg\" border=\"0\" alt=\"  " + paramRequest.getLocaleString("photo") + "  \">" : resource instanceof Video ? "<img title=\"Video\" src=\" " + SWBPlatform.getContextPath() + " /swbadmin/css/images/mobile_tipo-vid.jpg\" border=\"0\" alt=\"  " + paramRequest.getLocaleString("video") + "  \">" : "---");
                    if(resource.getSocialTopic()!=null)
                    {
                        boolean classifyBySentiment = resource.getSocialTopic().isCheckSentPostSentiment();
                        if (classifyBySentiment) {
                        out.println("(");    
                        //Sentiment
                        //out.println("<td align=\"center\">");
                        if (resource.getPostSentimentalType() == 0) {
                            out.println("---");
                        } else if (resource.getPostSentimentalType() == 1) {
                            out.println("<img alt=\"Positivo\" src=\"" + SWBPortal.getContextPath() + "/swbadmin/css/images/pos.png" + "\">");
                        } else if (resource.getPostSentimentalType() == 2) {
                            out.println("<img alt=\"Negativo\" src=\"" + SWBPortal.getContextPath() + "/swbadmin/css/images/neg.png" + "\">");
                        }
                        //out.println("</td>");

                        //Intensity
                        //out.println("<td>");
                        out.println(resource.getPostIntesityType() == 0 ? "<img alt=\"Baja\" src=\" " + SWBPlatform.getContextPath() + " /swbadmin/css/images/ibaja.png\" border=\"0\" alt=\"  " + paramRequest.getLocaleString("low") + "  \">" : resource.getPostIntesityType() == 1 ? "<img alt=\"Media\" src=\" " + SWBPlatform.getContextPath() + " /swbadmin/css/images/imedia.png\" border=\"0\" alt=\"  " + paramRequest.getLocaleString("medium") + "  \">" : resource.getPostIntesityType() == 2 ? "<img alt=\"Alta\" src=\" " + SWBPlatform.getContextPath() + " /swbadmin/css/images/ialta.png\" border=\"0\" alt=\" " + paramRequest.getLocaleString("high") + "  \">" : "---");
                        //out.println("</td>");
                        out.println(")");
                        }   
                    }
                    
                    out.println("</td>");


                    out.println("<td width='40%'>");
                    out.println(resource.getMsg_Text() != null ? SWBUtils.TEXT.encode(resource.getMsg_Text(),"UTF-8") : "");
                    out.println("</td>");
                    out.println("<td width='10%'>");
                    out.println(resource.getSocialTopic().getTitle() != null ? SWBUtils.TEXT.encode(resource.getSocialTopic().getTitle(),"UTF-8") : "");
                    out.println("</td>");
                    /*
                    out.println("<td width='10%'>");
                    out.println(SWBUtils.TEXT.encode(resource.getPflowInstance().getPflow().getDisplayTitle(lang),"UTF-8"));
                    out.println("</td>");
                    out.println("<td width='10%'>");
                    out.println(SWBUtils.TEXT.encode(resource.getPflowInstance().getStep(),"UTF-8"));
                    out.println("</td>");
                    * */
                    //Redes Sociales a las que esta dirigido el mensaje
                    out.println("<td width='10%'>");
                    //out.println(resource.getSocialNetwork()!=null?resource.getSocialNetwork().getDisplayTitle(lang):"---");
                    int cont = 0;
                    String nets = "";
                    Iterator<SocialNetwork> itPostSocialNets = resource.listSocialNetworks();
                    while (itPostSocialNets.hasNext()) {
                        cont++;
                        if (cont > 1) {
                            break; //Determinamos que solo se mostrara una y se mostrara un "ver mas" en dado caso que fueran mas redes sociales.
                        }
                        SocialNetwork socialNet = itPostSocialNets.next();
                        ////System.out.println("socialNet-1:"+socialNet);
                        String sSocialNet = socialNet.getDisplayTitle(lang);
                        String netIcon = "";
                        ////System.out.println("socialNet-2:"+sSocialNet);
                        if(socialNet instanceof Youtube){
                            netIcon = "<img class=\"swbIconYouTube\" src=\"/swbadmin/js/dojo/dojo/resources/blank.gif\"/>";
                        }else{
                            netIcon = "<img class=\"swbIcon" + socialNet.getClass().getSimpleName() + "\" src=\"/swbadmin/js/dojo/dojo/resources/blank.gif\"/>";
                        }
                        if (sSocialNet != null && sSocialNet.trim().length() > 0) {
                            ////System.out.println("socialNet-3:"+sSocialNet);
                            //Sacar privacidad
                            String sPrivacy = null;
                            //Si es necesario, cambiar esto por querys del Jei despues.
                            Iterator<PostOutPrivacyRelation> itpostOutPriRel = PostOutPrivacyRelation.ClassMgr.listPostOutPrivacyRelationByPopr_postOut(resource, sitetoShow);
                            while (itpostOutPriRel.hasNext()) {
                                PostOutPrivacyRelation poPrivRel = itpostOutPriRel.next();
                                if (poPrivRel.getPopr_socialNetwork().getURI().equals(socialNet.getURI())) {
                                    sPrivacy = poPrivRel.getPopr_privacy().getTitle(lang);
                                }
                            }
                            if (sPrivacy == null) {
                                Iterator<PostOutNet> itpostOutNet = PostOutNet.ClassMgr.listPostOutNetBySocialPost(resource, sitetoShow);
                                while (itpostOutNet.hasNext()) {
                                    PostOutNet postOutnet = itpostOutNet.next();
                                    if (postOutnet.getSocialNetwork().getURI().equals(socialNet.getURI()) && postOutnet.getPo_privacy() != null) {
                                        sPrivacy = postOutnet.getPo_privacy().getTitle(lang);
                                    }
                                }
                            }
                            if (sPrivacy == null) {
                                sPrivacy = paramRequest.getLocaleString("public");
                            }

                            //Termina privacidad
                            if (cont == 1) {
                                nets = "<p>" + netIcon +  sSocialNet + "(" + sPrivacy + ")" + "</p>";
                            } else {//Nunca entraría aquí con lo que se determinó, de solo mostrar la primera red social y un "ver mas", en caso de haber mas, se deja este códigp por si cambia esta regla en lo futuro.
                                nets += "<p>" + sSocialNet + "(" + sPrivacy + ")" + "</p>";
                            }
                        }
                    }
                    out.println(nets);

                    if (cont > 1) {
                        out.println("<p><a title=\"" + SWBUtils.TEXT.encode(paramRequest.getLocaleString("watchMore"),"UTF-8") + "\" onclick=\"showDialog('" + paramRequest.getRenderUrl().setMode(Mode_ShowMoreNets).setParameter("postUri", resource.getURI()) + "','" + SWBUtils.TEXT.encode(paramRequest.getLocaleString("watchMore"), "UTF-8") + "'); return false;\" href=\"#\">" + SWBUtils.TEXT.encode(paramRequest.getLocaleString("watchMore"),"UTF-8") + "</p></a>");
                    }

                    out.println("</td>");



                    //PostIn Source 
                    out.println("<td width='10%'>");
                    if (resource.getPostInSource() != null) {
                        /*
                        WebPage wpShowPostIn = wsite.getWebPage("ShowPostIn");
                        Resource resrPostIn = wsite.getResource("150");

                        SWBParamRequestImp paramreqPostIn = new SWBParamRequestImp(request, resrPostIn, wpShowPostIn, user);
                        SWBResourceURL urlpreviewPostIn = paramreqPostIn.getRenderUrl();
                        urlpreviewPostIn.setParameter("wsite", wsite.getId());
                        urlpreviewPostIn.setParameter("postIn", resource.getPostInSource().getURI());
                        urlpreviewPostIn.setParameter("mobileMode", "1");
                        * **/

                        String imgviewSource = SWBPortal.getContextPath() + "/swbadmin/css/images/mobile_ico-origen.png";
                        //out.println("<a title=\"" + paramRequest.getLocaleString("properties") + "\" onclick=\"view('" + urlpreviewPostIn + "','" + idPreSource + "')\" href=\"#\"><img src=\"" + imgviewSource + "\" alt=\"" + paramRequest.getLocaleString("source") + "\">ver 2</a>");
                        ///-Call show Dialog and don't use iframe
                        //out.println("<a title=\"" + paramRequest.getLocaleString("properties") + "\" onclick=\"window.location.href='"+urlpreviewPostIn+"';\" href=\"#\"><img src=\"" + imgviewSource + "\" alt=\"" + paramRequest.getLocaleString("source") + "\"></a>");

                        out.println("<a title=\"" +  paramRequest.getLocaleString("properties") + "\" href=\"#\" onclick=\"submitUrl('"+paramRequest.getRenderUrl().setMode(Mode_ViewPostIn).setParameter("postIn", resource.getPostInSource().getURI())+"',this); return false;\"><img src=\"" + imgviewSource + "\" alt=\"" + paramRequest.getLocaleString("source") + "\"></a>");
                        
                        //onclick=\"showDialog('" + clasifybyTopic + "','" + paramRequest.getLocaleString("reclassify") + " post'); return false;\"
                    } else {
                        out.println("---");
                    }
                    out.println("</td>");

                    out.println("</tr>");

                }

                out.println("</table>");
                out.println("<fieldset>");
                out.println("</form>");
            } else {
                out.println("<div class=\"swbform\">");
                out.println("<p>" + paramRequest.getLocaleString("messageNoContents") + "</p>");
                out.println("</div>");
            }
        } else{
            out.println("<div class=\"swbform\">");
            out.println("<p>" + paramRequest.getLocaleString("messageNoSites") + "</p>");
            out.println("</div>");
        }
        out.println("</div>");
        out.println("</div>");
        //out.println("</div>");
        //out.println("</div>");

        if (request.getParameter("previewSource") != null && request.getParameter("previewSource").equals("true")) {
            if (request.getParameter("sval") != null) {
                try {
                    doShowSource(request, response, paramRequest);
                } catch (Exception e) {
                    out.println("Preview not available...");
                }
            } else {
                out.println("Preview not available...");
            }
        }



        out.close();
    }
    
    public void doShowPostIn(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/mobilev/flow/showPostIn.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(myPath);
            if (dis != null) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("postIn"));
                    request.setAttribute("postIn", semObject);
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }       
    
    
    public void doShowPostOut(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/mobilev/flow/showPostOut.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(myPath);
            if (dis != null) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("postOut"));
                    request.setAttribute("postOut", semObject);
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }            

    /*
     * Show the source message of One PostOut that comes as a parameter "postUri"
     */
    public void doShowSource(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        final String myPath = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/review/showPostIn.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(myPath);
            if (dis != null) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("postUri"));
                    request.setAttribute("postIn", semObject);
                    request.setAttribute("paramRequest", paramRequest);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    /*
     * Muestra todas las redes sociales a las que se envío el mensaje de salida
     */
    private void doShowMoreNets(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) {
        final String path = SWBPlatform.getContextPath() + "/work/models/" + paramRequest.getWebPage().getWebSiteId() + "/jsp/review/showMoreNets.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(path);
        if (dis != null) {
            try {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("postUri"));
                request.setAttribute("postOut", semObject);
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    public void doAcceptOrReject(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String resourceId = request.getParameter("resourceId");
        String site = request.getParameter("site");
        String wbaction = request.getParameter("wbaction");
        WebSite sitetoShow = null;
        
        if (site != null) {
            sitetoShow = SWBContext.getWebSite(site);
        }
        
     out.println("<div class=\"row\">");
        out.println("<div class=\"col-md-12\">");
        out.println("<div class=\"panel panel-default\">");
        out.println("<div class=\"panel-heading\">");    
        String btnMessage = "";//wbaction.equals("a") ? paramRequest.getLocaleString("authorize") :
        if(wbaction.equals("a")){
            btnMessage = paramRequest.getLocaleString("authorize");
            out.println("<a href=\"#\" onclick=\"submitUrl('"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).setParameter("site", sitetoShow.getId())+"',this); return false;\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a>Autorizar Mensaje");
        }else if(wbaction.equals("r")){
            btnMessage = paramRequest.getLocaleString("reject");
             out.println("<a href=\"#\" onclick=\"submitUrl('"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).setParameter("site", sitetoShow.getId())+"',this); return false;\"><span class=\"glyphicon glyphicon-chevron-left\"></span></a>Rechazar Mensaje");
        }
        out.println("</div>");

        SWBResourceURL actionUrl = paramRequest.getActionUrl().setParameter("site", sitetoShow.getId()).setParameter("wbaction", wbaction).setParameter("res", resourceId);
      
        out.println("<div class=\"panel-body \">");
        out.println("<form role=\"form\" name=\"swbfrmResourcesAuthorize\" id=\"swbfrmResourcesAuthorize\" method=\"post\" action=\""+actionUrl+"\" onsubmit=\"submitForm('swbfrmResourcesAuthorize'); return false;\">");
        out.println("<input type='hidden' name='site' value='"+sitetoShow.getId()+"'></input>");
        //out.println("<input type='hidden' name='firstLoad' value='false'></input>");
        out.println("<div class=\"form-group\">");
        out.println("<label for=\"msg\">"+paramRequest.getLocaleString("msg")+"</label>");
        out.println("<textarea class=\"form-control\" rows='6' cols='30' name=\"msg\"></textarea>");
        out.println("</div>");
      
        out.println("<div class=\"form-group\">");
        //out.println("<button onClick=\"submitForm(\'swbfrmResourcesAuthorize\')\" dojoType=\"dijit.form.Button\" type=\"button\">" + btnMessage + "</button>");
        
        out.println("<button type=\"submit\">"+btnMessage+"</button>");
        
        out.println("&nbsp;&nbsp;&nbsp;&nbsp;<button onclick=\"submitUrl('"+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW).setParameter("site", sitetoShow.getId())+"',this); return false;\">" + paramRequest.getLocaleString("cancel") + "</button>");
        out.println("</div>");
        
        out.println("</form>");
        out.println("</div>"); //Panel Body
        
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");

    }
    
    public static Iterator sortByDisplayNameSet(Iterator it, String lang) {
        TreeSet set = new TreeSet(new SWBComparator(lang)); 

        while (it.hasNext()) {
            set.add(it.next());
        }        

        return set.descendingSet().iterator();
    }
}