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
package org.semanticwb.pymtur;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.Dns;
import org.semanticwb.model.Role;
import org.semanticwb.model.Template;
import org.semanticwb.model.TemplateRef;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.community.DirectoryObject;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.portal.community.MicroSiteUtil;
import org.semanticwb.portal.community.MicroSiteWebPageUtil;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.searcher.SearchDocument;
import org.semanticwb.portal.indexer.searcher.SearchQuery;
import org.semanticwb.portal.indexer.searcher.SearchResults;
import org.semanticwb.portal.indexer.searcher.SearchTerm;
import org.semanticwb.pymtur.util.PymturUtils;
import org.semanticwb.servlet.internal.UploadFormElement;

public class DirectoryResource extends org.semanticwb.pymtur.base.DirectoryResourceBase {

    private static Logger log = SWBUtils.getLogger(DirectoryResource.class);

    public DirectoryResource() {
    }

    public DirectoryResource(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if (paramRequest.getMode().equals("returnRank")) {
            returnRank(request, response);
        } else if (paramRequest.getMode().equals("returnStateMessage")) {
            returnStateMessage(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        User user=paramRequest.getUser();
        if (request.getParameter("errorMsg") != null) {
            PrintWriter out=response.getWriter();
            out.println("<font color=\"RED\"><b>");
            if (request.getParameter("errorMsg").equals("01")) {
                out.println("Se Presento un error en la edición del registro, favor de intentarlo nuevamente o contactactar al administrador del portal");
            }else if (request.getParameter("errorMsg").equals("02")) {
                out.println("Se Presento un error en la eliminación del registro, favor de intentarlo nuevamente o contactactar al administrador del portal");
            }else if (request.getParameter("errorMsg").equals("03")) {
                out.println("Se Presento un error en la creación del registro, favor de intentarlo nuevamente o contactactar al administrador del portal");
            }else if (request.getParameter("errorMsg").equals("04")) {
                out.println("Se Presento un error en la aceptación del registro, favor de intentarlo nuevamente o contactactar al administrador del portal");
            }else if (request.getParameter("errorMsg").equals("05")) {
                out.println("Se Presentó un error en el desregistro del elemento, favor de intentarlo nuevamente o contactactar al administrador del portal");
            }else if (request.getParameter("errorMsg").equals("20")) {
                out.println("Se Presentó un error, favor de intentarlo nuevamente o contactactar al administrador del portal");
            }
            out.println("</b></font>");
        }else if (request.getParameter("sucMsg") != null) {
            PrintWriter out=response.getWriter();
            out.println("<font color=\"RED\"><b>");
            if(request.getParameter("sucMsg").equals("01")){
                out.println("Estimado (a) "+user.getFullName()+","+
                            "La edición de tu información ha sido realizada de manera exitosa.");
            }
            out.println("</b></font>");
        }

        Enumeration<String> names = request.getParameterNames();
        HashMap<String, String> pars = new HashMap<String, String>();

        while (names.hasMoreElements()) {
            String key = names.nextElement();
            if (!request.getParameter(key).trim().equals("")) {
                pars.put(key, request.getParameter(key));
            }
        }

        String act = request.getParameter("act");
        if (act == null) {
            act = "view";
        }

        String path = "/swbadmin/jsp/microsite/directory/directoryView.jsp";
        if (act.equals("view") && getListJsp() != null) {
            path = getListJsp();
        } else if (act.equals("add") && getAddJsp() == null) {
            path = "/swbadmin/jsp/microsite/directory/directoryAdd.jsp";
            String paquete = request.getParameter("paq");
            if (paquete != null && paquete.equals("f")) {
                path += "?paq=f";
            } else if (paquete != null && paquete.equals("m")) {
                path += "?paq=m";
            }
        } else if (act.equals("add") && getAddJsp() != null) {
            path = getAddJsp();
        } else if (act.equals("edit") && getEditJsp() == null) {
            path = "/swbadmin/jsp/microsite/directory/directoryEdit.jsp";
        } else if (act.equals("edit") && getEditJsp() != null) {
            path = getEditJsp();
        } else if (act.equals("detail") && getDetailJsp() == null) {
            path = "/swbadmin/jsp/microsite/directory/directoryDetail.jsp";
        } else if (act.equals("detail") && getDetailJsp() != null) {
            path = getDetailJsp();
        }

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("itDirObjs", getDirectoryObjects(paramRequest, pars));
            request.setAttribute("sobj", getDirectoryClass());
            request.setAttribute("DirectoryResource", this);
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<div id=\"" + getSemanticObject().getURI() + "/admform\" dojoType=\"dijit.layout.ContentPane\">");
        SWBFormMgr mgr = new SWBFormMgr(getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
        mgr.setSubmitByAjax(true);
        mgr.addButton(SWBFormButton.newSaveButton());
        mgr.setType(SWBFormMgr.TYPE_DOJO);
        if ("update".equals(paramRequest.getAction())) {
            try {
                mgr.processForm(request);
            } catch (FormValidateException e) {
                log.error(e);
            }
            response.sendRedirect(paramRequest.getRenderUrl().setAction(null).toString());
        } else {
            mgr.setAction(paramRequest.getRenderUrl().setAction("update").toString());
            out.print(mgr.renderForm(request));
        }
        out.println("<div class=\"swbform\"\">\n" +
                "  <form action=\"#\"><fieldset><legend>Tags para texto de reclamos</legend>\n" +
                "      &nbsp;&nbsp;{direlement.title}<BR>" +
                "      &nbsp;&nbsp;{direlement.description}<BR>" +
                "      &nbsp;&nbsp;{direlement.uri}<BR>" +
                "      &nbsp;&nbsp;{direlement.webpage}<BR>" +
                "      &nbsp;&nbsp;{direlement.encodeduri}<BR>" +
                "      &nbsp;&nbsp;{direlement.claimjustify}<BR>" +
                "      &nbsp;&nbsp;{user.login}<BR>" +
                "      &nbsp;&nbsp;{user.fullname}<BR>" +
                "      &nbsp;&nbsp;{user.email}<BR>" +
                "      &nbsp;&nbsp;{user.language}<BR>" +
                "      &nbsp;&nbsp;{webpath}<BR>" +
                "      &nbsp;&nbsp;{distpath}<BR>" +
                "      &nbsp;&nbsp;{webworkpath}<BR>" +
                "      &nbsp;&nbsp;{websiteid}<BR>" +
                "      &nbsp;&nbsp;{workpath}<BR>" +
                "  </fieldset></form>" +
                "</div>");
        out.println("</div>");
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        WebSite wsite = response.getWebPage().getWebSite();
        WebPage pageFicha = wsite.getWebPage("ficha");
        String server = "http://" + request.getServerName() + ":" + request.getServerPort();
        SemanticObject semObjTmp = null;
        User mem = response.getUser();
        Resource base = response.getResourceBase();
        boolean isAdministrator = false;
        boolean isUserIsAdminProvider = false;
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

        Role adminProviderRole = user.getUserRepository().getRole("adminProviders");

        if (adminProviderRole != null && user.hasRole(adminProviderRole)) {
            isUserIsAdminProvider = true;
        }


        String action2 = response.getAction();
        try {
            if (action2.equals(response.Action_EDIT)) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                try {
                    ServiceProvider dirObj = (ServiceProvider) semObject.createGenericInstance();
                    User userCreator = dirObj.getCreator();
                    if ((userCreator != null && userCreator.getURI().equals(user.getURI())) || (isAdministrator || isUserIsAdminProvider)) {
                        mgr.processForm(request);

                        String dirPhoto = request.getParameter("dirPhotoHidden");
                        if (dirPhoto != null) {
                            dirObj.setPhoto(dirPhoto);

                        }
                        dirPhoto = request.getParameter("PhotoLogoHidden");
                        if (dirPhoto != null) {
                            dirObj.setPhotoLogo(dirPhoto);

                        }
                        processFiles(request, wsite, dirObj.getSemanticObject());

                        //Asignacion de plantilla y estilos a la Pag Web (si aplica)
                        if (dirObj.getPymePaqueteType() == PymturUtils.PAQ_PREMIER) {
                            if (request.getParameter("tplURI") != null &&
                                    !dirObj.getMicroSitePymeInv().getTemplateRef().getTemplate().getURI().equalsIgnoreCase(request.getParameter("tplURI"))) {
                                SemanticObject semObjectTmplt = SemanticObject.createSemanticObject(request.getParameter("tplURI"));
                                Template template = (Template) semObjectTmplt.createGenericInstance();
                                TemplateRef tmpRef = dirObj.getMicroSitePymeInv().getTemplateRef();
                                tmpRef.setTemplate(template);
                                tmpRef.setActive(Boolean.TRUE);
                                tmpRef.setInherit(TemplateRef.INHERIT_ACTUALANDCHILDS);
                                tmpRef.setValid(Boolean.TRUE);
                                tmpRef.setPriority(3);
                            }
                            if (request.getParameter("varianTplURI") != null &&
                                    !dirObj.getVariantPaqTemplate().getURI().equalsIgnoreCase(request.getParameter("varianTplURI"))) {
                                SemanticObject semObjectVT = SemanticObject.createSemanticObject(request.getParameter("varianTplURI"));
                                VariantPaqTemplate varianTpl = (VariantPaqTemplate) semObjectVT.createGenericInstance();
                                dirObj.setVariantPaqTemplate(varianTpl);
                            }

                        }
                    }
                    semObjTmp = dirObj.getSemanticObject();
                } catch (FormValidateException e) {
                    response.setRenderParameter("errorMsg", "01");
                    log.error(e);
                }
            } else if (action2.equals(response.Action_REMOVE)) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                    ServiceProvider dirObj = (ServiceProvider) semObject.createGenericInstance();
                    User userCreator = dirObj.getCreator();
                    if ((userCreator != null && userCreator.getURI().equals(user.getURI())) || (isAdministrator || isUserIsAdminProvider)) {
                        semObject.remove();
                        semObjTmp = semObject;
                    }
                } catch (Exception e) {
                    response.setRenderParameter("errorMsg", "02");
                    log.error(e);
                }
            } else if (action2.equals(response.Action_ADD)) {
                SemanticClass cls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(cls, wsite.getSemanticObject(), null);
                mgr.setFilterRequired(false);
                try {
                    SemanticObject sobj = mgr.processForm(request);
                    ServiceProvider dirObj = (ServiceProvider) sobj.createGenericInstance();
                    dirObj.setDirectoryResource(this);
                    dirObj.setWebPage(response.getWebPage());
                    dirObj.setSpCreator(user);
                    dirObj.setCreated(new Date());
                    dirObj.setSpStatus(1);

                    PymturUtils.logServiceProvider(dirObj, 1, "MiPyME Registered", user, wsite);

                    String refirect = null;
                    if (request.getParameter("destination") != null) {
                        WebPage wdestination = wsite.getWebPage(request.getParameter("destination"));
                        if (wdestination != null && wdestination instanceof Destination) {
                            Destination dest = (Destination) wdestination;
                            dirObj.setDestination(dest);
                            refirect = dest.getUrl();
                        }
                    }
                    if (request.getParameter("destinationSec") != null) {
                        WebPage wdestination = wsite.getWebPage(request.getParameter("destinationSec"));
                        if (wdestination != null && wdestination instanceof Destination) {
                            Destination dest = (Destination) wdestination;
                            dirObj.setDestinationSec(dest);
                            if (refirect == null) {
                                refirect = dest.getUrl();
                            }
                        }
                    }
                    int pymetype = PymturUtils.PAQ_DIRECTORIO;
                    if (request.getParameter("pymetype") != null) {
                        pymetype = Integer.parseInt(request.getParameter("pymetype"));
                    }
                    dirObj.setPymePaqueteType(pymetype);
                    processFiles(request, wsite, dirObj.getSemanticObject());
                    semObjTmp = dirObj.getSemanticObject();

                    if (pymetype == PymturUtils.PAQ_MICROSITIO || pymetype == PymturUtils.PAQ_PREMIER) {
                        MicroSitePyme ms = MicroSitePyme.ClassMgr.createMicroSitePyme("Microsite_" + dirObj.getId(), wsite); //TODO:Hacer que sea con el nombre de la pyme en formato de ID
                        if (pymetype == PymturUtils.PAQ_MICROSITIO) {
                            ms.setParent(wsite.getWebPage("Micrositios"));
                        } else if (pymetype == PymturUtils.PAQ_PREMIER) {
                            ms.setParent(wsite.getWebPage("MsPremier"));
                        }
                        ms.setTitle(dirObj.getTitle());
                        ms.setDescription(dirObj.getDescription());
                        ms.setTags(dirObj.getTags());
                        ms.setActive(Boolean.TRUE);

                        //Se asigna plantilla (Por el momento solo si es de paquete tipo 4 - Premier)
                        if (pymetype == PymturUtils.PAQ_PREMIER) {
                            if(request.getParameter("tplURI")!=null){
                                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("tplURI"));
                                Template template = (Template) semObject.createGenericInstance();
                                TemplateRef tmpRef = wsite.createTemplateRef();
                                tmpRef.setTemplate(template);
                                tmpRef.setActive(Boolean.TRUE);
                                tmpRef.setInherit(TemplateRef.INHERIT_ACTUALANDCHILDS);
                                tmpRef.setValid(Boolean.TRUE);
                                tmpRef.setPriority(3);
                                ms.addTemplateRef(tmpRef);
                            }
                            if(request.getParameter("varianTplURI")!=null){
                                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("varianTplURI"));
                                VariantPaqTemplate varianTpl = (VariantPaqTemplate) semObject.createGenericInstance();
                                dirObj.setVariantPaqTemplate(varianTpl);
                            }
                        }

                        String sdomain = request.getParameter("pymeDomain");
                        if (pymetype == PymturUtils.PAQ_PREMIER && sdomain != null && sdomain.trim().length() > 0) { //Se asigna el DNS al Micrositio siempre y cuando sea de tipo 4 (PREMIER)
                            Dns newDns = Dns.ClassMgr.createDns(wsite);
                            newDns.setDns(request.getParameter("pymeDomain"));
                            newDns.setWebPage(ms);
                            newDns.setCreator(user);
                        }

                        //Le asigna el tipo de comunidad y el service provider al micrositio
                        MicroSiteType mstype = null;
                        if (pymetype == PymturUtils.PAQ_MICROSITIO) {
                            mstype = MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wsite);
                        } else if (pymetype == PymturUtils.PAQ_PREMIER) {
                            mstype = MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wsite);
                        }
                        if (mstype != null) {
                            ms.setType(mstype);
                        }

                        ms.setServiceProvider(dirObj);

                        if (mstype != null) {
                            GenericIterator<MicroSiteUtil> gitmu = mstype.listMicroSiteUtils();
                            while (gitmu.hasNext()) {
                                MicroSiteUtil msu = (MicroSiteUtil) gitmu.next();
                                MicroSiteWebPageUtil mswpu = MicroSiteWebPageUtil.ClassMgr.createMicroSiteWebPageUtil(ms.getId() + "_" + msu.getId(), wsite);
                                mswpu.setTitle(msu.getTitle());

                                if (msu.getDescription() != null && msu.getDescription().trim().length() > 0) {
                                    mswpu.setSortName(msu.getDescription());
                                }

                                mswpu.setMicroSite(ms);
                                mswpu.setMicroSiteUtil(msu);

                                mswpu.setParent(ms);
                                mswpu.setActive(Boolean.TRUE);
                            }
                        }
                    }

                    //Envía correo al creador del service provider
                    String siteName = wsite.getDisplayTitle(response.getUser().getLanguage());
                    if (user.getEmail() != null) {
                        EmailText emailText=EmailText.ClassMgr.getEmailText("EMAIL_PYMEREGISTRY", wsite);
                        if(emailText!=null){
                            String staticText = PymturUtils.replaceTagsRegistry(emailText.getEmailText(), request, response, user, siteName, dirObj);
                            /*
                            staticText="Estimado (a) {user} , <br/><br/>"+
                            "Nos complace el registro de tu empresa: <br/>"+
                            "<b>"+dirObj.getTitle()+"</b><br/>" +
                            "Son muchos los beneficios que recibirás para la misma.<br/>"+
                            "En un periodo no mayor a 24 hrs., te notificaremos sobre la publicación de";
                            if(pymetype==PymturUtils.PAQ_FICHA){
                                staticText=staticText+" la ficha, con los datos de tu empresa, en el portal \"Siente México\". <br/><br/>";
                            }else if(pymetype==PymturUtils.PAQ_MICROSITIO){
                                staticText=staticText+" tu Micrositio.<br/><br/>";
                            }else if(pymetype==PymturUtils.PAQ_PREMIER){
                                staticText=staticText+" tu página web.<br/><br/>";
                            }
                            staticText=staticText+"Atentamente tus amigos de:<br/>"+
                            "\"SIENTE MÉXICO\"";
                             * */
                            if(staticText!=null && staticText.trim().length()>0){
                                SWBUtils.EMAIL.sendBGEmail(user.getEmail(), "Contacto del Sitio - Confirmación de registro", staticText);
                            }
                        }
                    }
                    //Termina envío de correo al creador
                    if (refirect != null) {
                        response.sendRedirect(refirect + "?newReg=1&uri="+dirObj.getEncodedURI()); //Redirecciona al destino en el que se generó la pyme
                    }
                } catch (FormValidateException e) {
                    response.setRenderParameter("errorMsg", "03");
                    log.error(e);
                }
            } else if (action2.equals("admin_update")) {
                String editaccess = request.getParameter("editar");
                if (editaccess != null) {
                    base.setAttribute("editRole", editaccess);
                    base.updateAttributesToDB();
                }
            } else if (action2.equals("acceptRegistry") && (isUserIsAdminProvider || isAdministrator)) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(URLDecoder.decode(request.getParameter("uri")));
                    ServiceProvider servProp = (ServiceProvider) semObject.createGenericInstance();
                    servProp.setSpStatus(2);
                    PymturUtils.logServiceProvider(servProp, 2, "MiPyME accept Registry", user, wsite);


                    String statComm = request.getParameter("statusComment");
                    if (statComm != null) {
                        servProp.setSpStatusComment(statComm);
                    }

                    //Envía correo al creador del service provider para confirmar su registro
                    String siteName = wsite.getDisplayTitle(response.getUser().getLanguage());
                    if (servProp.getCreator().getEmail() != null) {
                            EmailText emailText=EmailText.ClassMgr.getEmailText("EMAIL_ACCEPTREGISTRY", wsite);
                            if(emailText!=null){
                                String staticText = PymturUtils.replaceTagsAcceptRegistry(emailText.getEmailText(), request, response, user, siteName, servProp, pageFicha);
                                /*
                                staticText = "Estimado (a) {user} ,<br/><br/>" +
                                "Nos complace informarte que";
                                if (servProp.getPymePaqueteType() == PymturUtils.PAQ_FICHA) {
                                    staticText=staticText+" la ficha";
                                }if (servProp.getPymePaqueteType() == PymturUtils.PAQ_MICROSITIO) {
                                    staticText=staticText+" el Micrositio";
                                }if (servProp.getPymePaqueteType() == PymturUtils.PAQ_PREMIER) {
                                    staticText=staticText+" la página web";
                                }
                                staticText=staticText+ " con los datos de tu empresa:<br/>"+
                                "<b>"+servProp.getTitle()+"</b><br/>"+
                                "ha sido publicada.<br><br/>"+
                                "Puedes consultarla en línea dando click en la siguiente liga<br/><br/>";
                                if (servProp.getPymePaqueteType() > PymturUtils.PAQ_DIRECTORIO && pageFicha != null) {
                                    staticText = staticText + server + pageFicha.getUrl() + "?uri=" + servProp.getEncodedURI() + "&act=detail<br/><br/>";
                                }if (servProp.getPymePaqueteType() > PymturUtils.PAQ_MICROSITIO && servProp.getPymeDomain() != null) {
                                    staticText = staticText + "El dominio registrado es:<br/><br/>" + servProp.getPymeDomain() + "<br/><br/>";
                                }
                                staticText=staticText+"Si deseas editar tu información podrás hacerlo firmándote en el portal \"Siente México\"<br/> con el usuario y contraseña que elegiste para tu registro.<br/><br/>" +
                                "Atentamente sus amigos de:<br/><br/>"+
                                "<b>\"SIENTE MÉXICO</b>\"";
                                 * */
                                if(staticText!=null && staticText.trim().length()>0){
                                    SWBUtils.EMAIL.sendBGEmail(servProp.getCreator().getEmail(), "Contacto del Sitio - Aceptación de registro", staticText);
                                }
                            }
                    }
                } catch (Exception e) {
                    response.setRenderParameter("errorMsg", "04");
                    log.error(e);
                }
            } else if (action2.equals("unRegister") && (isUserIsAdminProvider || isAdministrator)) {
                try {
                    SemanticObject semObject = SemanticObject.createSemanticObject(URLDecoder.decode(request.getParameter("uri")));
                    ServiceProvider servProp = (ServiceProvider) semObject.createGenericInstance();
                    servProp.setSpStatus(4);
                    PymturUtils.logServiceProvider(servProp, 4, "MiPyME unRegister", user, wsite);

                    String statComm = request.getParameter("statusComment");
                    if (statComm != null) {
                        servProp.setSpStatusComment(statComm);
                    }

                    //Envía correo al creador del service provider para notificar su baja
                    String siteName = wsite.getDisplayTitle(response.getUser().getLanguage());
                    if (servProp.getCreator().getEmail() != null) {
                        EmailText emailText=EmailText.ClassMgr.getEmailText("EMAIL_REJECTREGISTRY", wsite);
                        if(emailText!=null){
                            String staticText = PymturUtils.replaceTagsRejectRegistry(emailText.getEmailText(), request, response, user, siteName, servProp);
                            /*
                            staticText="Estimado (a) {user},<br/>"+
                            "Lamentamos informarte que la publicación de tu empresa:</br><br/>" +
                            "<b>"+servProp.getTitle()+"</b></br><br/>";
                            if (statComm != null) {
                                staticText=staticText+"no se pudo concretar debido al siguiente motivo:</br></br>"+
                                statComm+"<br/><br/>";
                            }else{
                                staticText=staticText+
                                "-	Su empresa no es considerada una empresa turística<br/>"+
                                "-	Sus datos están incompletos o son erróneos<br/>";
                            }
                            staticText=staticText+"Si tienes alguna duda consúltanos en:<br/><br/>"+

                            "Atentamente tus amigos de:<br/>"+
                            "\"SIENTE MÉXICO\"";
                             * */

                            if(staticText!=null && staticText.trim().length()>0){
                                SWBUtils.EMAIL.sendBGEmail(servProp.getCreator().getEmail(), "Contacto del Sitio - Revocación de registro", staticText);
                            }
                        }
                    }
                } catch (Exception e) {
                    response.setRenderParameter("errorMsg", "05");
                    log.error(e);
                }
            }
        } catch (Exception e) {
            response.setRenderParameter("errorMsg", "20");
            log.error(e);
        }
        String redirect = request.getParameter("redirect");
        if (redirect != null) {
            if (redirect.equals("detail")) {
                //response.setRenderParameter("act", "detail");
                //response.setRenderParameter("uri", semObjTmp.getURI());
                response.sendRedirect(response.getWebPage().getUrl() + "?act=detail&sucMsg=01&uri=" + semObjTmp.getEncodedURI());

            }
        }
        response.setMode(response.Mode_VIEW);
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
                                ImageResizer.shrinkTo(fichero, 336, 224, fichero, ext);
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

    private void returnRank(HttpServletRequest request, HttpServletResponse response) {
        String message = null;
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri) {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof DirectoryObject) {
            DirectoryObject mse = (DirectoryObject) so.createGenericInstance();
            message = mse.getRank() + "|" + mse.getReviews();

        }
        try {
            response.getWriter().print(message != null ? message : "Not OK");
        } catch (IOException ioe) {
        }
    }

    private void returnStateMessage(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest) {

        String message = request.getParameter("message");
        try {
            response.getWriter().print(message != null ? message : "Not OK");
        } catch (IOException ioe) {
        }
    }

    private Iterator<ServiceProvider> getDirectoryObjects(SWBParamRequest paramRequest, HashMap<String, String> pars) {
        Destination dest = null;
        SPType type = null;
        ArrayList<ServiceProvider> providers = new ArrayList<ServiceProvider>();
        SearchQuery query = new SearchQuery();

        //Consulta para obtener todos los ServiceProviders
        query.addTerm(new SearchTerm(SWBIndexer.ATT_CLASS, "ServiceProvider", SearchTerm.OPER_AND));

        if (paramRequest.getWebPage() instanceof Destination) {
            dest = (Destination) paramRequest.getWebPage();
            //Restringir a que contengan cierto destino
            if (dest != null) {
                query.addTerm(new SearchTerm(ServiceProviderParser.ATT_DESTINATION, dest.getTitle(), SearchTerm.OPER_AND));
            }

            //Restringir a que sean de cierto SPType cuando éste se especifica desde el panel de búsqueda
            //Si no se selecciona nada, por defecto son hoteles
            String spType = pars.get("spType");
            if (spType != null && !spType.trim().equals("")) {
                SPType spt = (SPType) SemanticObject.createSemanticObject(URLDecoder.decode(spType)).createGenericInstance();
                query.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, spt.getId(), SearchTerm.OPER_AND));
            }/* else {
        query.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, "Hotel", SearchTerm.OPER_AND));
        }*/
        }

        if (paramRequest.getWebPage() instanceof SPType) {
            type = (SPType) paramRequest.getWebPage();
            //Restringir a que sean de cierto SPType
            if (type != null) {
                query.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, type.getId(), SearchTerm.OPER_AND));
            }
        }

        if (!(paramRequest.getWebPage() instanceof Destination) && !(paramRequest.getWebPage() instanceof SPType)) {
            String spType = pars.get("spType");
            if (spType != null && !spType.trim().equals("")) {
                SPType spt = (SPType) SemanticObject.createSemanticObject(URLDecoder.decode(spType)).createGenericInstance();
                query.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, spt.getId(), SearchTerm.OPER_AND));
            }
        }

        //Restringir a que sean de cierto SPType cuando éste se especifica por parámetro
        String spType = pars.get("fixedSpType");
        if (spType != null && !spType.trim().equals("")) {
            query.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, spType, SearchTerm.OPER_AND));
        }

        //Ejecutar la busqueda
        SearchResults sres = SWBPortal.getIndexMgr().getDefaultIndexer().search(query, paramRequest.getUser());

        //Obtener la lista de searchables y transformala a una lista de serviceproviders
        Iterator<SearchDocument> docs = sres.listDocuments();
        while (docs.hasNext()) {
            SearchDocument doc = docs.next();
            if (doc.getSearchable() != null) {
                ServiceProvider sp = (ServiceProvider) doc.getSearchable().getSemanticObject().createGenericInstance();
                providers.add(sp);
            }
        }

        return providers.iterator();
    }
    
}