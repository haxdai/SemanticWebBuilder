/**
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
*
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
* del SemanticWebBuilder 4.0.
*
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
* de la misma.
*
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
* dirección electrónica:
*  http://www.semanticwebbuilder.org
**/
package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.portal.community.MicroSiteWebPageUtil;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.Promotion;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author carlos.ramos
 */
public class PromotionManager extends GenericResource {
    private static Logger log = SWBUtils.getLogger(PromotionManager.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
            PrintWriter out = response.getWriter();
            ServiceProvider sprovider = null;
            WebPage community = null;
            WebPage currentpage = (WebPage) request.getAttribute("webpage");
            if(currentpage == null) {
                currentpage = paramRequest.getWebPage();
            }
            if(currentpage instanceof MicroSitePyme) {
                community = currentpage;
            }else {
                community = currentpage.getParent();
            }
            MicroSitePyme ms = (MicroSitePyme)community;
            sprovider = ms.getServiceProvider();

            String promoUrl = "#";
            Iterator<MicroSiteWebPageUtil> it_msu = ms.listMicroSiteUtils();
            while (it_msu.hasNext()) {
                MicroSiteWebPageUtil msu = it_msu.next();
                if (msu.getTitle().toLowerCase().endsWith("tarifas")) {
                    promoUrl = msu.getUrl();
                }
            }

            Iterator<Promotion> itpromos = sprovider.listPromotions();
            if(itpromos.hasNext()) {                
                out.println("<ul>");
                while(itpromos.hasNext()) {
                    Promotion promo = itpromos.next();
                    out.println("  <li><a href=\"" + promoUrl + "\">"+promo.getDisplayTitle(paramRequest.getUser().getLanguage())+"</a></li>");
                }
                out.println("</ul>");
            }
            out.flush();
        }else {
            WebPage wp = paramRequest.getWebPage();
            WebPage community = null;
            String path = "";

            if (wp instanceof MicroSitePyme) {
                community = wp;
            } else {
                community = wp.getParent();
            }

            String siteUri = ((MicroSitePyme) community).getType().getURI();

            if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
                path = "/work/models/etour/jsp/pymestur/microsite/spPromotions.jsp";
            } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
                path = "/work/models/etour/jsp/pymestur/premier/spPromotions.jsp";
            }

            RequestDispatcher dis = request.getRequestDispatcher(path);
            try {
                request.setAttribute("paramRequest", paramRequest);
                request.setAttribute("canEdit", userCanEdit(paramRequest.getUser()));
                dis.include(request, response);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action=response.getAction();

        if(action.equals("add_promo")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(Promotion.sclass, semObject, null);
            mgr.setFilterRequired(false);
            if( isValidValue(request.getParameter("title")) && isValidValue(request.getParameter("description")) ) {
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Promotion promo = (Promotion) sobj.createGenericInstance();
                    //PromotionType promoType = PromotionType.ClassMgr.getPromotionType(request.getParameter("is"), response.getWebPage().getWebSite());
                    promo.setPromoType(request.getParameter("is"));
                    promo.setPromoImg(  (request.getParameter("pimg")!=null&&request.getParameter("pimg").length()>0?request.getParameter("pimg"):null)  );
                    ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                    serviceProv.addPromotion(promo);
                    serviceProv.setSpTotPromotions(serviceProv.getSpTotPromotions()+1);
                }catch(Exception e){
                    log.error(e);
                }
            }
        }else if(action.equals("edit_promo")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            mgr.setFilterRequired(false);
            if( isValidValue(request.getParameter("title")) && isValidValue(request.getParameter("description")) && isValidValue(request.getParameter("pimg")) ) {
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Promotion promo = (Promotion) sobj.createGenericInstance();
                    promo.setPromoType(request.getParameter("is"));
                    promo.setPromoImg(request.getParameter("pimg"));
                }catch(Exception e){
                    log.error(e);
                }
            }
        }else if(action.equals("remove_promo")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            Promotion promo = (Promotion) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removePromotion(promo);
            serviceProv.setSpTotPromotions(serviceProv.getSpTotPromotions()-1);
            semObject.remove();
        }
    }

    private boolean isValidValue(String param) {
        boolean validValue = false;
        if( param!=null && param.trim().length()>0 )
            validValue = true;
        return validValue;
    }

    private boolean isValidNumber(String param) {
        boolean validValue = false;
        if( param!=null && param.trim().length()>0 )
            try {
                Double.parseDouble(param);
                validValue = true;
            }catch(NumberFormatException  nfe) {
                validValue = false;
            }
        return validValue;
    }

    private boolean userCanEdit(final User user) {
        boolean access = false;
        Role superAdm = user.getUserRepository().getRole("superAdmProviders");
        if( user.hasRole(superAdm) ) {
            access = true;
        }

//        boolean access = false;
//
//        String roleName = getResourceBase().getAttribute("editRole");
//        if( user!=null && roleName!=null ) {
//            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
//            GenericObject gobj = null;
//            gobj = ont.getGenericObject(roleName);
//
//            if( gobj!=null ) {
//                UserGroup ugrp = null;
//                Role urole = null;
//
//                if(gobj instanceof UserGroup) {
//                    ugrp = (UserGroup) gobj;
//                    if(user.hasUserGroup(ugrp)) {
//                        access = true;
//                    }
//                }else if(gobj instanceof Role) {
//                    urole = (Role) gobj;
//                    if(user.hasRole(urole)) {
//                        access = true;
//                    }
//                }
//            }
//        }
        return access ;
    }
}