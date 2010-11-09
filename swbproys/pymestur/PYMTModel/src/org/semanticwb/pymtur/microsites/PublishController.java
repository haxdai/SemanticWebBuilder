/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.Hospedaje;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;
import org.semanticwb.pymtur.util.PymturUtils;


/**
 *
 * @author jose.jimenez
 */
public class PublishController extends GenericResource {


    private static Logger log = SWBUtils.getLogger(SPComplementaryData.class);


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        RequestDispatcher dis = null;
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        String path = null;
        String action = paramRequest.getAction();
        User user = paramRequest.getUser();
        MicroSitePyme ms = null;
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId();

        boolean userCanEdit = false;

        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }

        String siteUri = ((MicroSitePyme) community).getType().getURI();
        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus",
                wp.getWebSite()).getURI().equals(siteUri)) {

            ms = (MicroSitePyme) community;
            userCanEdit = canUserEdit(user, ms);
            try {
                if (userCanEdit) {
                    request.setAttribute("serviceProvider", ms.getServiceProvider());
                    request.setAttribute("paramRequest", paramRequest);
                    path = siteWorkDir + "/jsp/pymestur/premier/ShowPublishOption.jsp";
                    dis = request.getRequestDispatcher(path);
                    dis.include(request, response);
                }
            } catch (Exception e) {
                log.error("Dispatching request for presenting complementary data", e);
            }
        }
        
    }

    public void doStatusChange(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        String resp = null;
        //response.setContentType("text/plain;charset=UTF-8");
/**/
        String action = request.getParameter("action");
        SemanticObject semObject = null;
        ServiceProvider dirObj = null;
        boolean statusChanged = false;
        boolean userCanEdit = false;
        String message = null;
        response.setContentType("text/html; charset=ISO-8859-1");

        if (request.getParameter("uri") != null) {
            semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
            dirObj = (ServiceProvider) semObject.createGenericInstance();
        }

        userCanEdit = canUserEdit(paramRequest.getUser(), dirObj.getMicroSitePymeInv());

        if (userCanEdit) {
            message = canChangeStatus(dirObj, action);
            if (action.equalsIgnoreCase("Publish") && dirObj != null) {
                if (message.length() == 0) {
                    dirObj.setSpStatus(PymturUtils.ESTATUS_PUBLICADO);
                    statusChanged = true;
                }
            } else if (action.equalsIgnoreCase("UnPublish") && dirObj != null) {
                if (message.length() == 0) {
                    dirObj.setSpStatus(PymturUtils.ESTATUS_ACEPTADO);
                    statusChanged = true;
                }
            }
        }
//        request.setAttribute("statusChanged", Boolean.toString(statusChanged));

/**/
        PrintWriter out = response.getWriter();

//        if (request.getAttribute("statusChanged") != null) {
//            statusChanged = (String) request.getAttribute("statusChanged");
//        }
        if (statusChanged) {
            //String action = paramRequest.getAction();
            if (action.equalsIgnoreCase("Publish")) {
                resp = "UnPublish|";
            } else if (action.equalsIgnoreCase("UnPublish")) {
                resp = "Publish|";
            }
            resp += "OK";
        } else {
            if (message != null && message.length() > 0) {
                resp = message + "|";
            } else if (message == null) {
                resp = "No cuenta con los permisos necesarios para realizar esta operación.|";
            }
            resp += "Not_OK";
        }
        out.print(resp);
//        out.flush();
//        out.close();
    }

    /**
     * Determina si el {@code ServiceProvider} indicado puede ser publicado o despublicado.
     * @param sp {@code ServiceProvider} cuyo estado se verifica asi como su 
     *           informacion para modificar su estado.
     * @return un {@code String} indicando el motivo por el cual no puede modificarse el estatus.
     */
    private String canChangeStatus(ServiceProvider sp, String action) {

        //boolean allowChange = false;
        StringBuilder message = new StringBuilder(512);

        if (action.equalsIgnoreCase("Publish")) {
            if (sp.getSpStatus() == PymturUtils.ESTATUS_ACEPTADO) {
                boolean conditionsAccomplished = false;
                if (sp.getSpReservationPhone() == null || (sp.getSpReservationPhone() != null && "".equals(sp.getSpReservationPhone()))) {
                    message.append("Teléfono para reservaciones");
                }
                if (sp.getDescription() == null || (sp.getDescription() != null && "".equals(sp.getDescription()))) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Descripción de la empresa");
                }
                if (sp.getPhoto() == null) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Imagen principal de la empresa");
                }
                if (sp.getPhotoLogo() == null) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Imagen del logotipo de la empresa");
                }
                if (sp.getLatitude() == 0 && sp.getLongitude() == 0) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Ubicación de la empresa en mapa");
                }
                if (sp.getPymeArrive() == null || (sp.getPymeArrive() != null && "".equals(sp.getPymeArrive()))) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Descripción de cómo llegar");
                }
                if (sp.listServices() == null || (sp.listServices() != null && !sp.listServices().hasNext())) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Servicios y equipamiento");
                }
                if (sp.listInstalations() == null || (sp.listInstalations() != null && !sp.listInstalations().hasNext())) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Instalaciones");
                }
                if (sp.listRates() == null || (sp.listRates() != null && !sp.listRates().hasNext())) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Tarifas");
                }
                if (sp instanceof Hospedaje) {
                    if (((Hospedaje) sp).getCheckIN() == null || (((Hospedaje) sp).getCheckIN() != null && "".equals(((Hospedaje) sp).getCheckIN()))) {
                        if (message.length() > 0) {
                            message.append(", ");
                        }
                        message.append("Hora de Check-in");
                    }
                    if (((Hospedaje) sp).getCheckOUT() == null || (((Hospedaje) sp).getCheckOUT() != null && "".equals(((Hospedaje) sp).getCheckOUT()))) {
                        if (message.length() > 0) {
                            message.append(", ");
                        }
                        message.append("Hora de Check-out");
                    }
                }
                if (sp.listOmnibusLines() == null || (sp.listOmnibusLines() != null && !sp.listOmnibusLines().hasNext())) {
                    if (message.length() > 0) {
                        message.append(", ");
                    }
                    message.append("Líneas de autobuses");
                }
//                if (conditionsAccomplished) {
//                    allowChange = true;
//                }
            }
        } else if (action.equalsIgnoreCase("UnPublish")) {
            if (sp.getSpStatus() != PymturUtils.ESTATUS_PUBLICADO) {
                message.append("La empresa actualmente no está publicada");
            }
        }

        return message.toString();
    }

    /**
     * Determina si el usuario determinado puede hacer modificaciones a la informaci&oacute;n
     * de la empresa relacionada al micrositio.
     * @param user usuario firmado en el sistema
     * @param ms micrositio cuya informaci&oacute;n se desea modificar
     * @return un boleano que indica si el usuario tiene permisos de escritura sobre
     *         la informaci&oacute;n del micrositio
     */
    private boolean canUserEdit(User user, MicroSitePyme ms) {
        boolean userCanEdit = false;
        Role superAdm = user.getUserRepository().getRole("superAdmProviders");

        if (user != null && user.getURI() != null && ms != null &&
                (ms.getServiceProvider().getCreator().getURI().equals(user.getURI()) ||
                 user.hasRole(superAdm))) {
            userCanEdit = true;
        }
        return userCanEdit;
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        if(paramRequest.getMode().equalsIgnoreCase("statusChange")) {
            doStatusChange(request,response,paramRequest);
        }else {
            super.processRequest(request, response, paramRequest);
        }
    }

}
