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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.Cupon;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;

/**
 *
 * @author carlos.ramos
 */
public class CuponManager extends GenericResource {
    private static Logger log = SWBUtils.getLogger(CuponManager.class);

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
            path = "/work/models/etour/jsp/pymestur/microsite/spCupons.jsp";
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            path = "/work/models/etour/jsp/pymestur/premier/spCupons.jsp";
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
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException  {
        Resource base = getResourceBase();
        String action=response.getAction();
        if(action.equals("add_cupon")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            SWBFormMgr mgr = new SWBFormMgr(Cupon.sclass, semObject, null);
            mgr.setFilterRequired(false);
            if( isValidValue(request.getParameter("title")) && isValidValue(request.getParameter("description")) ) {
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Cupon cupon = (Cupon) sobj.createGenericInstance();
                    cupon.setCuponType(request.getParameter("is"));
                    cupon.setCuponImg(  (request.getParameter("pimg")!=null&&request.getParameter("pimg").length()>0?request.getParameter("pimg"):null)  );
                    cupon.setCuponConditions(request.getParameter("constraint")==null?"":request.getParameter("constraint"));
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date = request.getParameter("datei");
                        Date di = sdf.parse(date);
                        date = request.getParameter("datef");
                        Date df = sdf.parse(date);                        
                        cupon.setCuponPeriodIni(sdf.format(di));
                        cupon.setCuponPeriodFin(sdf.format(df));
                    }catch(ParseException pe) {
                        log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                    }
                    ServiceProvider serviceProv = (ServiceProvider) semObject.createGenericInstance();
                    serviceProv.addCupon(cupon);
                    serviceProv.setSpTotCupones(serviceProv.getSpTotCupones()+1);
                }catch(Exception e){
                    log.error(e);
                }
            }
        }else if(action.equals("edit_cupon")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            mgr.setFilterRequired(false);
            if( isValidValue(request.getParameter("title")) && isValidValue(request.getParameter("description")) && isValidValue(request.getParameter("pimg")) ) {
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    Cupon cupon = (Cupon) sobj.createGenericInstance();
                    cupon.setCuponType(request.getParameter("is"));
                    cupon.setCuponImg(request.getParameter("pimg"));
                    cupon.setCuponConditions(request.getParameter("constraint")==null?"":request.getParameter("constraint"));
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String date = request.getParameter("datei");
                        Date di = sdf.parse(date);
                        date = request.getParameter("datef");
                        Date df = sdf.parse(date);
                        cupon.setCuponPeriodIni(sdf.format(di));
                        cupon.setCuponPeriodFin(sdf.format(df));
                    }catch(ParseException pe) {
                        log.error("Las fechas no son parseables. Resource "+base.getTitle()+" with id "+base.getId(), pe);
                    }
                }catch(Exception e){
                    log.error(e);
                }
            }
        }else if(action.equals("remove_cupon")) {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            Cupon cupon = (Cupon) semObject.createGenericInstance();

            SemanticObject semObjectProv = SemanticObject.createSemanticObject(request.getParameter("sprovider"));
            ServiceProvider serviceProv = (ServiceProvider) semObjectProv.createGenericInstance();

            serviceProv.removeCupon(cupon);
            serviceProv.setSpTotCupones(serviceProv.getSpTotCupones()-1);
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
