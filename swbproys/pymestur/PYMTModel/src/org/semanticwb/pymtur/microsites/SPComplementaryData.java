/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.pymtur.microsites;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.Dns;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;
import org.semanticwb.pymtur.VideoYouTube;
import org.semanticwb.pymtur.util.PymturUtils;
import org.semanticwb.servlet.internal.UploadFormElement;


/**
 *
 * @author jose.jimenez
 */
public class SPComplementaryData extends GenericResource {


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
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/"
                + paramRequest.getWebPage().getWebSiteId();

        boolean userCanEdit = false;

        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }

        String siteUri = ((MicroSitePyme) community).getType().getURI();

//        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
//            path = "/work/models/etour/jsp/pymestur/microsite/installations.jsp";
//        } else
        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus",
                wp.getWebSite()).getURI().equals(siteUri)) {

            MicroSitePyme ms = (MicroSitePyme) community;
            userCanEdit = canUserEdit(user, ms);
            request.setAttribute("serviceProvider", ms.getServiceProvider());
            request.setAttribute("paramRequest", paramRequest);
            path = siteWorkDir + "/jsp/pymestur/premier/ComplementaryData.jsp";
        }
        try {
            if (userCanEdit) {
                dis = request.getRequestDispatcher(path);
                dis.include(request, response);
            }
        } catch (Exception e) {
            log.error("Dispatching request for presenting complementary data", e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response)
            throws SWBResourceException, IOException {

        String action = response.getAction();
        WebSite wsite = response.getWebPage().getWebSite();
        WebPage pageFicha = wsite.getWebPage("ficha");
        String server = "http://" + request.getServerName() + ":" + request.getServerPort();
        SemanticObject semObjTmp = null;
        User mem = response.getUser();
        boolean isAdministrator = false;
        boolean isUserIsAdminProvider = false;
        boolean succesfulOp = false;
        User user = response.getUser();
        if (user != null) {
            GenericIterator<UserGroup> groups = user.listUserGroups();
            while (groups.hasNext()) {
                UserGroup group = groups.next();
                if (group != null && group.getId().equals("admin")) {
                    isAdministrator = true;
                    break;
                }
            }
        }
        if (!mem.isSigned()) {
            return;                                       //si el usuario no pertenece a la red sale;
        }
        //TODO: Revisar el uso de estos roles al finalizar la codificación
        Role adminProviderRole = user.getUserRepository().getRole("adminProviders");
        Role superAdm = user.getUserRepository().getRole("superAdmProviders");

        if (adminProviderRole != null && (user.hasRole(adminProviderRole) || user.hasRole(superAdm))) {
            isUserIsAdminProvider = true;
        }
/*        try {
            if (request.getParameter("uri") != null && action != null && action.equalsIgnoreCase("saveInstallations")) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                mgr.clearProperties();
                ServiceProvider sprovider = (ServiceProvider) semObject.createGenericInstance();
                mgr.processForm(request);
            }
        } catch (FormValidateException e) {
            log.error(e);
        }*/
        try {
            if (action.equals(response.Action_EDIT)) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                mgr.clearProperties();
                mgr.addProperty(ServiceProvider.swb_description);
                mgr.addProperty(ServiceProvider.pymtur_spSlogan);
                mgr.addProperty(ServiceProvider.pymtur_PhotoLogo);
                mgr.addProperty(ServiceProvider.swbcomm_dirPhoto);
                mgr.addProperty(ServiceProvider.pymtur_pymeDomain);
                mgr.addProperty(ServiceProvider.pymtur_pymeSubDomainWildCard);
                mgr.addProperty(ServiceProvider.swbcomm_intNumber);
                mgr.addProperty(ServiceProvider.swb_latitude);
                mgr.addProperty(ServiceProvider.swb_longitude);
                mgr.addProperty(ServiceProvider.swb_geoStep);
                mgr.addProperty(ServiceProvider.pymtur_pymeArrive);
                mgr.addProperty(ServiceProvider.pymtur_MinRate);
                mgr.addProperty(ServiceProvider.pymtur_MaxRate);
                mgr.addProperty(ServiceProvider.pymtur_contactSecondName);
                mgr.addProperty(ServiceProvider.pymtur_spReservationPhone);
                mgr.addProperty(ServiceProvider.pymtur_spCelularPhone);
                mgr.addProperty(ServiceProvider.pymtur_spSkypeAccount);
                mgr.addProperty(ServiceProvider.pymtur_spTwitterUser);
                mgr.addProperty(ServiceProvider.pymtur_spFacebookUser);
                mgr.addProperty(ServiceProvider.pymtur_spVideoYouTube);
                mgr.addProperty(ServiceProvider.pymtur_spYouTubeChannel);
                mgr.addProperty(ServiceProvider.pymtur_rfcPersonType);
                mgr.addProperty(ServiceProvider.pymtur_rfcStreet);
                mgr.addProperty(ServiceProvider.pymtur_rfcExternalNumber);
                mgr.addProperty(ServiceProvider.pymtur_rfcInternalNumber);
                mgr.addProperty(ServiceProvider.pymtur_rfcSuburb);
                mgr.addProperty(ServiceProvider.pymtur_rfcCityCouncil);
                mgr.addProperty(ServiceProvider.pymtur_rfcZipCode);
                mgr.addProperty(ServiceProvider.pymtur_rfcState);
                try {
                    ServiceProvider dirObj = (ServiceProvider) semObject.createGenericInstance();
                    User userCreator = dirObj.getCreator();
                    String subdomain = request.getParameter(ServiceProvider.pymtur_pymeSubDomainWildCard.getName());
                    String maindomain = request.getParameter(ServiceProvider.pymtur_pymeDomain.getName());

                    if ((userCreator != null && userCreator.getURI().equals(user.getURI())) ||
                            (isAdministrator || isUserIsAdminProvider)) {
                        if ((subdomain == null || (subdomain != null && subdomain.trim().length() == 0)) &&
                                dirObj.getPymeSubDomainWildCard() != null) {
                            Dns.ClassMgr.removeDns(dirObj.getPymeSubDomainWildCard().getId(), wsite);
                        }
                        if ((maindomain == null || (maindomain != null && maindomain.trim().length() == 0)) &&
                                dirObj.getPymeDomain() != null) {
                            Dns.ClassMgr.removeDns(dirObj.getPymeDomain().getId(), wsite);
                        }

                        if (isFormDataValid(request)) {
                            mgr.processForm(request);
                        } else {
                            throw new FormValidateException("Data received is not valid");
                        }

                        String dirPhoto = request.getParameter("dirPhotoHidden");
                        if (dirPhoto != null) {
                            dirObj.setPhoto(dirPhoto);

                        }
                        dirPhoto = request.getParameter("PhotoLogoHidden");
                        if (dirPhoto != null) {
                            dirObj.setPhotoLogo(dirPhoto);

                        }
                        processFiles(request, wsite, dirObj.getSemanticObject());

                       int pymePaquete=dirObj.getPymePaqueteType();
                       if (pymePaquete == PymturUtils.PAQ_MICROSITIO || pymePaquete == PymturUtils.PAQ_PREMIER) { //Solo para micrositios o premier
                           dirObj.getMicroSitePymeInv().setDescription(dirObj.getDescription());
                            String sdomain = request.getParameter(dirObj.pymtur_pymeDomain.getName());
                            if (dirObj.getPymePaqueteType() == PymturUtils.PAQ_PREMIER && sdomain != null && sdomain.trim().length() > 0) { //Se modifica el DNS al Micrositio siempre y cuando sea de tipo 4 (PREMIER)
                                Dns pymeDns = dirObj.getPymeDomain();
                                if(pymeDns!=null){
                                    pymeDns.setDns(sdomain);
                                    pymeDns.setModifiedBy(user);
                                    dirObj.setPymeDomain(pymeDns);
                                }else{
                                    Dns newDns = Dns.ClassMgr.createDns(wsite);
                                    newDns.setDns(sdomain);
                                    newDns.setWebPage(dirObj.getMicroSitePymeInv());
                                    newDns.setCreator(user);
                                    dirObj.setPymeDomain(newDns);
                                }
                            }

                            if (dirObj.getPymePaqueteType() == PymturUtils.PAQ_PREMIER && subdomain != null && subdomain.trim().length() > 0) { //Se modifica el SubDNS al Micrositio siempre y cuando sea de tipo 4 (PREMIER)
                                subdomain = subdomain + (request.getServerName().startsWith("www.") ? request.getServerName().substring(3) : ("." + request.getServerName()));
                                Dns pymeDns = dirObj.getPymeSubDomainWildCard();
                                if (pymeDns != null) {
                                    pymeDns.setDns(subdomain);
                                    pymeDns.setModifiedBy(user);
                                    dirObj.setPymeSubDomainWildCard(pymeDns);
                                } else {
                                    Dns newDns = Dns.ClassMgr.createDns(wsite);
                                    newDns.setDns(subdomain);
                                    newDns.setWebPage(dirObj.getMicroSitePymeInv());
                                    newDns.setCreator(user);
                                    dirObj.setPymeSubDomainWildCard(newDns);
                                }
                            }

                            String youtubeCode=request.getParameter("youtubeVideoCode");
                            if(youtubeCode!=null && youtubeCode.trim().length()>0)
                            {
                                VideoYouTube youtube=dirObj.getSpVideoYouTube();
                                if(youtube!=null)
                                {
                                    youtube.setYoutubeVideoCode(youtubeCode);
                                    if(request.getParameter("videoYTTitle")!=null) youtube.setTitle(request.getParameter("videoYTTitle"));
                                    if(request.getParameter("videoYTDescr")!=null) youtube.setDescription(request.getParameter("videoYTDescr"));
                                    youtube.setUpdated(new Date());
                                    dirObj.setSpVideoYouTube(youtube);
                                }else{
                                    youtube=VideoYouTube.ClassMgr.createVideoYouTube(wsite);
                                    youtube.setYoutubeVideoCode(youtubeCode);
                                    if(request.getParameter("videoYTTitle")!=null) youtube.setTitle(request.getParameter("videoYTTitle"));
                                    if(request.getParameter("videoYTDescr")!=null) youtube.setDescription(request.getParameter("videoYTDescr"));
                                    youtube.setUpdated(new Date());
                                    dirObj.setSpVideoYouTube(youtube);
                                }
                            }

                       }
                       succesfulOp = true;
                    }
                    semObjTmp = dirObj.getSemanticObject();
                } catch (FormValidateException e) {
                    response.setRenderParameter("errorMsg", "01");
                    log.error(e);
                } catch (NumberFormatException nfe) {
                    response.setRenderParameter("errorMsg", "05");
                    log.error(nfe);
                }
            }
        } catch (Exception e) {
            response.setRenderParameter("errorMsg", "20");
            log.error(e);
        }
        if (succesfulOp) {
            response.setRenderParameter("successMsg", "true");
        }
        response.setMode(response.Mode_VIEW);
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

    private void processFiles(HttpServletRequest request, WebSite website, SemanticObject sobj) {

        String basepath = SWBPortal.getWorkPath() + sobj.getWorkPath() + "/";
        if (request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED) != null) {
            Iterator itfilesUploaded = ((List) request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED)).iterator();
            while (itfilesUploaded.hasNext()) {
                FileItem item = (FileItem) itfilesUploaded.next();
                if (!item.isFormField()) { //Es un campo de tipo file
                    int fileSize = ((Long) item.getSize()).intValue();
                    String value = item.getName();
                    if (value != null && value.trim().length() > 0) {
                        value = value.replace("\\", "/");
                        int pos = value.lastIndexOf("/");
                        if (pos > -1) {
                            value = value.substring(pos + 1);
                        }
                        File fichero = new File(basepath);
                        if (!fichero.exists()) {
                            fichero.mkdirs();
                        }
                        fichero = new File(basepath + value);

                        String ext = "";
                        pos = -1;
                        pos = value.indexOf(".");
                        if (pos > -1) {
                            ext = value.substring(pos + 1);
                        }


                        ServiceProvider dirObj = (ServiceProvider) sobj.createGenericInstance();
                        if (item.getFieldName().equals("dirPhoto")) {
                            String tmpPhoto = dirObj.getPhoto();
                            dirObj.setPhoto(value);
                            File file = new File(basepath + tmpPhoto);
                            file.delete();

                            try {
                                item.write(fichero);
                                ImageResizer.shrinkTo(fichero, 281, 187, fichero, ext);
                                //ImageResizer.resize(fichero, 336, 224, true, fichero, ext);
                            } catch (Exception e) {
                                e.printStackTrace();
                                log.debug(e);
                            }
                        } else if (item.getFieldName().equals("PhotoLogo")) {
                            String tmpPhoto = dirObj.getPhotoLogo();
                            dirObj.setPhotoLogo(value);
                            File file = new File(basepath + tmpPhoto);
                            file.delete();

                            try {
                                item.write(fichero);
                                ImageResizer.shrinkTo(fichero, 90, 67, fichero, ext);
                                //ImageResizer.resize(fichero, 90, 67, true, fichero, ext);
                            } catch (Exception e) {
                                e.printStackTrace();
                                log.debug(e);
                            }
                        }
                    }
                }
            }
            request.getSession().setAttribute(UploadFormElement.FILES_UPLOADED, null);
        }
    }

    /**
     * Valida la informacion recibida en el request
     * @param request la peticion HTTP con los datos a validar
     * @return verdadero si la informacion es valida, falso de lo contrario
     */
    private boolean isFormDataValid(HttpServletRequest request) {

        boolean dataValid = false;
        boolean regexPassed = false;
        String parameter = null;
        int length = 0;
        String fileExtAllowed = (String) request.getAttribute("extensions");

        if (fileExtAllowed != null) {
            fileExtAllowed = fileExtAllowed.toLowerCase() + "|" + fileExtAllowed.toUpperCase();
        } else {
            fileExtAllowed = "gif|jpg|jpeg|png|GIF|JPG|JPEG|PNG";
        }

        parameter = request.getParameter(ServiceProvider.swb_description.getName());
        length = 300 + PymturUtils.countEnterChars(parameter, 300);
        if (parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^([^(<>&%#\\{\\})]{0," + length + "})$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spSlogan.getName());
        length = 300 + PymturUtils.countEnterChars(parameter, 300);
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^([^(<>&%#\\{\\})]{0," + length + "})$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_PhotoLogo.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s_-]+\\.(" + fileExtAllowed + ")$");
        }
        parameter = request.getParameter(ServiceProvider.swbcomm_dirPhoto.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s_-]+\\.(" + fileExtAllowed + ")$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_pymeDomain.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^((www\\.)|([a-zA-Z0-9\\-\\_]+\\.))[a-zA-Z0-9\\-\\_\\.]+(\\:[0-9]{2,4})*$");
            dataValid = dataValid && parameter.trim().length() <= 80 ? true : false;
        }
        parameter = request.getParameter(ServiceProvider.pymtur_pymeSubDomainWildCard.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[a-z_\\d]{2,50}$");
        }
        parameter = request.getParameter(ServiceProvider.swbcomm_intNumber.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.-áéíóúÁÉÍÓÚñÑ]{1,20}$");
        }
        parameter = request.getParameter(ServiceProvider.swb_latitude.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^-?\\d{1,3}\\.\\d{7}$");
        }
        parameter = request.getParameter(ServiceProvider.swb_longitude.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^-?\\d{1,3}\\.\\d{7}$");
        }
        parameter = request.getParameter(ServiceProvider.swb_geoStep.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^\\d{1,2}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_pymeArrive.getName());
        length = 1600 + PymturUtils.countEnterChars(parameter, 1600);
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^([^(<>&%#\\{\\})]{0," + length + "})$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_MinRate.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^\\d{1,8}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_MaxRate.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^\\d{1,8}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_contactSecondName.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.áéíóúÁÉÍÓÚñÑ]{1,30}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spReservationPhone.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "(^[0-9]{7,8}$)");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spCelularPhone.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "(^[0-9]{10}$)");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spSkypeAccount.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s-_\\.áéíóúÁÉÍÓÚñÑ]{1,30}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spTwitterUser.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s-_\\.áéíóúÁÉÍÓÚñÑ]{1,30}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spFacebookUser.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s-_\\.áéíóúÁÉÍÓÚñÑ]{1,30}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spVideoYouTube.getName());
        length = 600 + PymturUtils.countEnterChars(parameter, 600);
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^([^(\\|!\\$\\\\%#\\(\\)\\+\\*\\{\\};)]{0," + length + "})$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_spYouTubeChannel.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^http://www\\.youtube\\.com/([\\w/]+)$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcPersonType.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^pfisica$|^pmoral$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcStreet.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.áéíóúÁÉÍÓÚñÑ]{1,50}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcExternalNumber.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.-]{1,10}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcInternalNumber.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.áéíóúÁÉÍÓÚñÑ-]{1,10}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcSuburb.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.áéíóúÁÉÍÓÚñÑ]{1,50}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcCityCouncil.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.áéíóúÁÉÍÓÚñÑ]{1,30}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcZipCode.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[0-9]{5}$");
        }
        parameter = request.getParameter(ServiceProvider.pymtur_rfcState.getName());
        if (dataValid && parameter != null && parameter.trim().length() > 0) {
            dataValid = PymturUtils.validateRegExp(parameter, "^[\\w\\s\\.áéíóúÁÉÍÓÚ]{1,25}$");
        }
        return dataValid;
    }
}
