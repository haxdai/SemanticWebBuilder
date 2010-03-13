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
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.Rate;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author jorge.jimenez
 */
public class SPRates extends GenericResource {

    private static Logger log = SWBUtils.getLogger(SPRates.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
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
            path = "/work/models/etour/jsp/pymestur/microsite/spRates.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            path = "/work/models/etour/jsp/pymestur/premier/spRates.jsp";
        }

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        String action=response.getAction();
        if(action.equals("add_rate")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(Rate.sclass, semObject, null);
            mgr.setFilterRequired(false);
            try {
                if(isValidValue(request.getParameter("planType")) && isValidNumber(request.getParameter("HighSeason")) && isValidNumber(request.getParameter("Capacity")) && isValidNumber(request.getParameter("lowSeason")) && isValidValue(request.getParameter("serviceType")) ) {
                    SemanticObject sobj = mgr.processForm(request);
                    Rate rate = (Rate) sobj.createGenericInstance();
                    ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                    serviceProv.addRate(rate);
                }
            }catch(Exception e){
                log.error(e);
            }
        }else if(action.equals("edit_rate")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            mgr.setFilterRequired(false);
            try
            {
                mgr.processForm(request);
            }catch(Exception e){
                log.error(e);
            }
        }else if(action.equals("remove_rate")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            Rate rate = (Rate) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removeRate(rate);
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
}
