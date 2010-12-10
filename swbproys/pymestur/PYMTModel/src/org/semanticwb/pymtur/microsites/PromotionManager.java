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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.portal.community.MicroSiteWebPageUtil;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.Promotion;
import org.semanticwb.pymtur.ServiceProvider;
import org.semanticwb.pymtur.util.PymturUtils;

/**
 *
 * @author carlos.ramos
 */
public class PromotionManager extends GenericResource {
    private static Logger log = SWBUtils.getLogger(PromotionManager.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId();
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
            PrintWriter out = response.getWriter();
            ServiceProvider sprovider = null;
            WebPage community = null;
            WebPage currentpage = (WebPage) request.getAttribute("webpage");
            if (currentpage == null) {
                currentpage = paramRequest.getWebPage();
            }
            if (currentpage instanceof MicroSitePyme) {
                community = currentpage;
            } else {
                community = currentpage.getParent();
            }
            MicroSitePyme ms = (MicroSitePyme) community;
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
        } else {
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
                path = siteWorkDir + "/jsp/pymestur/microsite/spPromotions.jsp";
            } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
                path = siteWorkDir + "/jsp/pymestur/premier/spPromotions.jsp";
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
        response.setRenderParameter("uri", request.getParameter("uri"));
        response.setRenderParameter("sprovider", request.getParameter("sprovider"));

        if(action.equals("add_promo")) {
            response.setAction("addNewPromotion");
            int descLength = 0;
            String title = request.getParameter("title");
            if(title!=null) {
                if(!PymturUtils.validateRegExp(title, "^[\\wñÑáéíóúüÁÉÍÓÚÜ]([\\w\\sñÑáéíóúüÁÉÍÓÚÜ]{1,99})$")) {
                    response.setRenderParameter("msgErrTitle", "Este campo es Obligatorio. Los caracteres permitidos son: alfabeto, guiones bajos, acentos, dieresis y espacios en blanco. Favor de verificarlo");
                    return;
                }
            }
            String description = request.getParameter("description");
            if(description!=null) {
                descLength=1000+PymturUtils.countEnterChars(description,1000);
                if( !PymturUtils.validateRegExp(description, "^([^(<>&%#)]{1,"+descLength+"})$")) {
                    response.setRenderParameter("msgErrDesc", "Este campo es obligatorio. Verifica que el tamaño del texto no exceda los 1000 caracteres. Los caracteres: '<','>','&','%','#' no son permitidos");
                    return;
                }
            }
            String date1 = request.getParameter("datei");
            if(date1!=null) {
                if(!PymturUtils.validateRegExp(date1, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")) {
                    response.setRenderParameter("msgErrDateS", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                    return;
                }
            }
            String date2 = request.getParameter("datef");
            if(date2!=null) {
                if(!PymturUtils.validateRegExp(date2, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")) {
                    response.setRenderParameter("msgErrDateE", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                    return;
                }
            }
            try {
                String is = request.getParameter("is").trim();
                if(is.length()<=0) {
                    response.setRenderParameter("msgErrPromoType", "El tipo de la promoción es requerido.");
                    return;
                }
            }catch(Exception e) {
                response.setRenderParameter("msgErrPromoType", "El tipo de la promoción es requerido.");
                return;
            }
            String cmts = request.getParameter("cmts");
            if(cmts!=null) {
                descLength=600+PymturUtils.countEnterChars(cmts,600);
                if( !PymturUtils.validateRegExp(cmts, "^([^(<>&%#)]{0,"+descLength+"})$")) {
                    response.setRenderParameter("msgErrCommenPromo", "Verifica que el tamaño del texto no exceda los 600 caracteres. Los caracteres: '<','>','&','%','#' no son permitidos");
                    return;
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date di, df;
            try {
                di = sdf.parse(date1);
                df = sdf.parse(date2);
                if(di.after(df)) {
                    response.setRenderParameter("msgErrDateS", "La fecha inicial de vigencia no puede ser mayor a la final.");
                    return;
                }
                response.setAction(SWBResourceURL.Mode_VIEW);
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
                SWBFormMgr mgr = new SWBFormMgr(Promotion.sclass, semObject, null);
                mgr.setFilterRequired(false);
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Promotion promo = (Promotion) sobj.createGenericInstance();
                    promo.setTitle(title);
                    promo.setDescription(description);
                    promo.setPromoType(request.getParameter("is"));
                    promo.setPromoImg(  (request.getParameter("pimg")!=null&&request.getParameter("pimg").length()>0?request.getParameter("pimg"):null)  );
                    promo.setStartDate(di);
                    promo.setEndDate(df);
                    ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                    serviceProv.addPromotion(promo);
                    serviceProv.setSpTotPromotions(serviceProv.getSpTotPromotions()+1);
                    serviceProv.setSpPromotionsComment(cmts);
                }catch(FormValidateException e) {
                    log.error(e);
                }
            }catch(ParseException pe) {
                log.error("Las fechas no son parseables. ", pe);
            }
        }else if(action.equals("edit_promo")) {
            response.setAction("editPromotion");
            int descLength=0;
            String title = request.getParameter("title");
            if(title!=null) {
                if(!PymturUtils.validateRegExp(title, "^[\\wñÑáéíóúüÁÉÍÓÚÜ]([\\w\\sñÑáéíóúüÁÉÍÓÚÜ]{1,99})$")) {
                    response.setRenderParameter("msgErrTitle", "Este campo es Obligatorio. Los caracteres permitidos son: alfabeto, guiones bajos, acentos, dieresis y espacios en blanco. Favor de verificarlo");
                    return;
                }
            }
            String description = request.getParameter("description");
            if(description!=null) {
                descLength=1000+PymturUtils.countEnterChars(description,1000);
                if( !PymturUtils.validateRegExp(description, "^([^(<>&%#)]{1,"+descLength+"})$")) {
                    response.setRenderParameter("msgErrDesc", "Este campo es obligatorio. Verifica que el tamaño del texto no exceda los 1000 caracteres. Los caracteres: '<','>','&','%','#' no son permitidos");
                    return;
                }
            }
            String date1 = request.getParameter("datei");
            if(date1!=null) {
                if(!PymturUtils.validateRegExp(date1, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")) {
                    response.setRenderParameter("msgErrDateS", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                    return;
                }
            }
            String date2 = request.getParameter("datef");
            if(date2!=null) {
                if(!PymturUtils.validateRegExp(date2, "^2[0-9][0-9][0-9]-[\\d]{1,2}-[\\d]{1,2}$")) {
                    response.setRenderParameter("msgErrDateE", "Este campo es Obligatorio y debe llevar el siguiente formato 'año-mes-día'");
                    return;
                }
            }
            try {
                String is = request.getParameter("is").trim();
                if(is.length()<=0) {
                    response.setRenderParameter("msgErrPromoType", "El tipo de la promoción es requerido.");
                    return;
                }
            }catch(Exception e) {
                response.setRenderParameter("msgErrPromoType", "El tipo de la promoción es requerido.");
                return;
            }
            String cmts = request.getParameter("cmts");
            if(cmts!=null) {
                descLength=600+PymturUtils.countEnterChars(cmts,600);
                if( !PymturUtils.validateRegExp(cmts, "^([^(<>&%#)]{0,"+descLength+"})$")) {
                    response.setRenderParameter("msgErrCommenPromo", "Verifica que el tamaño del texto no exceda los 600 caracteres. Los caracteres: '<','>','&','%','#' no son permitidos");
                    return;
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date di, df;
            try {
                di = sdf.parse(date1);
                df = sdf.parse(date2);
                if(di.after(df)) {
                    response.setRenderParameter("msgErrDateS", "La fecha inicial de vigencia no puede ser mayor a la final.");
                    return;
                }
                response.setAction(SWBResourceURL.Mode_VIEW);
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                mgr.setFilterRequired(false);
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Promotion promo = (Promotion) sobj.createGenericInstance();
                    promo.setTitle(title);
                    promo.setDescription(description);
                    promo.setPromoType(request.getParameter("is"));
                    promo.setPromoImg(request.getParameter("pimg"));
                    promo.setStartDate(di);
                    promo.setEndDate(df);
                    semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
                    ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                    serviceProv.setSpPromotionsComment(cmts);
                }catch(Exception e){
                    log.error(e);
                }
            }catch(ParseException pe) {
                log.error("Las fechas no son parseables. ", pe);
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