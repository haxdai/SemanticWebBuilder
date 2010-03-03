
package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.Promotion;
import org.semanticwb.pymtur.ServiceProvider;
import sun.security.krb5.internal.p;

/**
 *
 * @author carlos.ramos
 */


public class PromotionManager extends GenericResource {
    private static Logger log = SWBUtils.getLogger(PromotionManager.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
            response.setContentType("text/html; charset=ISO-8859-1");
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");

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


//urlAction.setAction(urlAction.Action_REMOVE+"_promo");
//urlAction.setParameter("sprovider", sprovider.getEncodedURI());
out.println("<h4>PROMOCIONES</h4>");
out.println("<ul>");
Iterator<Promotion> itpromos = sprovider.listPromotions();
while(itpromos.hasNext()) {
    Promotion promo = itpromos.next();
    out.println("  <li><a href=\"#\">"+promo.getDisplayTitle(paramRequest.getUser().getLanguage())+"</a></li>");
}
out.println("</ul>");
out.flush();



//            out.println("<h4>PROMOCIONES</h4>");
//            out.println("<ul>");
//            out.println("  <li><a href=\"#\">Promociones en modo estrategia...</a></li>");
//            out.println("  <li><a href=\"#\">Promo 1. Cuarta noche grátis durante el invierno.</a></li>");
//            out.println("  <li><a href=\"#\">Promo 2. Paseo en bote nocturno.</a></li>");
//            out.println("  <li><a href=\"#\">Promo 3. 20% de descuento en tarifas, alimentos y bebidas.</a></li>");
//            out.println("  <li><a href=\"#\">Promo 4. 35% de descuento en habitaci&oacute;n doble.</a></li>");
//            out.println("</ul>");
            out.flush();
        }else {
            RequestDispatcher dis = request.getRequestDispatcher("/work/models/etour/jsp/pymestur/microsite/spPromotions.jsp");
            try {
                request.setAttribute("paramRequest", paramRequest);
                dis.include(request, response);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        String action=response.getAction();
        if(action.equals("add_promo")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(Promotion.sclass, semObject, null);
            mgr.setFilterRequired(false);
            try
            {
                SemanticObject sobj = mgr.processForm(request);
                Promotion promo = (Promotion) sobj.createGenericInstance();

                ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                serviceProv.addPromotion(promo);
            }catch(Exception e){
                log.error(e);
            }
        }else if(action.equals("edit_promo")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            mgr.setFilterRequired(false);
            try
            {
                mgr.processForm(request);
            }catch(Exception e){
                log.error(e);
            }
        }else if(action.equals("remove_promo")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            Promotion promo = (Promotion) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removePromotion(promo);
            semObject.remove();
        }
    }
}
