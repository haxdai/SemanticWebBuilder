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
import java.net.SocketException;
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
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Traceable;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.Dns;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.community.Claimable;
import org.semanticwb.portal.community.Comment;
import org.semanticwb.portal.community.DirectoryObject;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.portal.community.MicroSiteUtil;
import org.semanticwb.portal.community.MicroSiteWebPageUtil;
import org.semanticwb.portal.community.Organization;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.searcher.SearchDocument;
import org.semanticwb.portal.indexer.searcher.SearchQuery;
import org.semanticwb.portal.indexer.searcher.SearchResults;
import org.semanticwb.portal.indexer.searcher.SearchTerm;
import org.semanticwb.servlet.internal.UploadFormElement;

public class DirectoryResource extends org.semanticwb.pymtur.base.DirectoryResourceBase
{
    private static Logger log = SWBUtils.getLogger(DirectoryResource.class);    

    public DirectoryResource() {}

    public DirectoryResource(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out=response.getWriter();
        out.println("<div id=\""+getSemanticObject().getURI()+"/admform\" dojoType=\"dijit.layout.ContentPane\">");
        SWBFormMgr mgr=new SWBFormMgr(getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
        mgr.setSubmitByAjax(true);
        mgr.addButton(SWBFormButton.newSaveButton());
        mgr.setType(SWBFormMgr.TYPE_DOJO);
        if("update".equals(paramRequest.getAction()))
        {
            try
            {
                mgr.processForm(request);
            }catch(FormValidateException e){log.error(e);}
            response.sendRedirect(paramRequest.getRenderUrl().setAction(null).toString());
        }else
        {
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
                    "  </fieldset></form>"+
                    "</div>");
        out.println("</div>");
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        Enumeration<String> names = request.getParameterNames();
        HashMap<String, String> pars = new HashMap<String, String>();

        while (names.hasMoreElements()) {
            String key = names.nextElement();
            if (!request.getParameter(key).trim().equals("")) {
                pars.put(key, request.getParameter(key));
            }
        }
        
        if (paramRequest.getAction().equals("excel"))
        {
            response.setContentType("application/vnd.ms-excel");
        }
        String act = request.getParameter("act");
        if (act == null)
        {
            act = "view";
        }

        String path = "/swbadmin/jsp/microsite/directory/directoryView.jsp";
        if (act.equals("view") && getListJsp() != null)
        {
            path = getListJsp();
        }
        else if (act.equals("add") && getAddJsp() == null)
        {
            path = "/swbadmin/jsp/microsite/directory/directoryAdd.jsp";
            String paquete=request.getParameter("paq");
            if(paquete!=null && paquete.equals("f")) path+="?paq=f";
            else if(paquete!=null && paquete.equals("m")) path+="?paq=m";
        }
        else if (act.equals("add") && getAddJsp() != null)
        {
            path = getAddJsp();
        }
        else if (act.equals("edit") && getEditJsp() == null)
        {
            path = "/swbadmin/jsp/microsite/directory/directoryEdit.jsp";
        }
        else if (act.equals("edit") && getEditJsp() != null)
        {
            path = getEditJsp();
        }
        else if (act.equals("detail") && getDetailJsp() == null)
        {
            path = "/swbadmin/jsp/microsite/directory/directoryDetail.jsp";
        }
        else if (act.equals("detail") && getDetailJsp() != null)
        {
            path = getDetailJsp();
        }

        RequestDispatcher dis = request.getRequestDispatcher(path);        
        try
        {
            request.setAttribute("itDirObjs", getDirectoryObjects(paramRequest, pars));
            request.setAttribute("sobj", getDirectoryClass());
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }
        catch (Exception e)
        {
            log.error(e);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equals("returnRank"))
        {
            returnRank(request, response);
        }
        else if (paramRequest.getMode().equals("returnStateMessage"))
        {
            returnStateMessage(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    private void getSpam(HttpServletRequest request,
            SWBActionResponse response)
    {

        String message = null;
        String suri = request.getParameter("uri");
        String commentId = request.getParameter("commentId");
        SemanticObject so = null;

        if (commentId == null)
        {
            return;
        }
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject mse = (DirectoryObject) so.getGenericInstance();
            GenericIterator<Comment> iterator = mse.listComments();
            while (iterator.hasNext())
            {
                Comment comment = iterator.next();
                if (comment.getId().equals(commentId))
                {
                    message = String.valueOf(comment.getSpam());
                    break;
                }
            }
        }
        response.setMode("returnStateMessage");
        response.setRenderParameter("message",
                message != null || "".equals(message)
                ? message : "");
    }

    @Override
    public String replaceTags(String str, HttpServletRequest request, SWBActionResponse response)
    {
        DirectoryObject dob = null;
        SemanticObject so = SemanticObject.createSemanticObject(request.getParameter("uri"));
        if (so != null) {
            dob = (DirectoryObject) so.createGenericInstance();
        }

        if(str==null || str.trim().length()==0)
            return "";

        if (dob != null)
        {
            str=SWBUtils.TEXT.replaceAll(str, "{direlement.title}", dob.getTitle());
            str=SWBUtils.TEXT.replaceAll(str, "{direlement.description}", dob.getDescription());
            str=SWBUtils.TEXT.replaceAll(str, "{direlement.claimjustify}", ((Claimable)dob).getClaimJustify());
            str=SWBUtils.TEXT.replaceAll(str, "{direlement.encodeduri}", dob.getEncodedURI());
            str=SWBUtils.TEXT.replaceAll(str, "{direlement.uri}", dob.getURI());
            str=SWBUtils.TEXT.replaceAll(str, "{direlement.webpage}", dob.getWebPage().getUrl());
        }

        str=SWBUtils.TEXT.replaceAll(str, "{user.login}", response.getUser().getLogin());
        str=SWBUtils.TEXT.replaceAll(str, "{user.fullname}", response.getUser().getFullName());
        str=SWBUtils.TEXT.replaceAll(str, "{user.email}", response.getUser().getEmail());
        str=SWBUtils.TEXT.replaceAll(str, "{user.language}", response.getUser().getLanguage());
        str=SWBUtils.TEXT.replaceAll(str, "{webpath}", SWBPortal.getContextPath());
        str=SWBUtils.TEXT.replaceAll(str, "{distpath}", SWBPortal.getDistributorPath());
        str=SWBUtils.TEXT.replaceAll(str, "{webworkpath}", SWBPortal.getWebWorkPath());
        str=SWBUtils.TEXT.replaceAll(str, "{workpath}", SWBPortal.getWorkPath());
        str=SWBUtils.TEXT.replaceAll(str, "{websiteid}", response.getWebPage().getWebSiteId());
        return str;
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        WebSite wsite=response.getWebPage().getWebSite();
        SemanticObject semObjTmp=null;
        User mem = response.getUser();
        Resource base = response.getResourceBase();
        boolean isAdministrator = false;
        User user = response.getUser();
        if (user != null)
        {
            GenericIterator<UserGroup> groups = user.listUserGroups();
            while (groups.hasNext())
            {
                UserGroup group = groups.next();
                if (group != null && group.getId().equals("admin"))
                {
                    isAdministrator = true;
                    break;
                }
            }
        }
        if (!mem.isSigned())
        {
            return;                                       //si el usuario no pertenece a la red sale;
        }
        
        //String action = request.getParameter("act");
        String action2 = response.getAction();
        try
        {
            /*
            if ("vote".equals(action))
            {
                rank(request, response);
                return;
            }
            else if ("abuseReport".equals(action))
            {
                abusedStateChange(request, response);
                return;
            }
            else if ("deletecomment".equals(action))
            {
                String suri = request.getParameter("uricomment");
                String commentId = request.getParameter("commentId");
                SemanticObject so = null;
                if (null != suri && commentId != null)
                {
                    so = SemanticObject.createSemanticObject(suri);
                }
                if (so.getGenericInstance() instanceof DirectoryObject && isAdministrator)
                {
                    DirectoryObject element = (DirectoryObject) so.getGenericInstance();
                    if (element != null)
                    {
                        GenericIterator<Comment> comments = element.listComments();
                        while (comments.hasNext())
                        {
                            Comment comment = comments.next();
                            if (comment.getId().equals(commentId))
                            {
                                comment.remove();
                                break;
                            }
                        }
                    }
                }
            }
            else if ("getAbused".equals(action))
            {
                getAbused(request, response);
                return;
            }
            else if ("getSpam".equals(action))
            {
                getSpam(request, response);
                return;
            }
            else if ("addComment".equals(action))
            {
                addComment(request, response, mem);
            }
            else if ("spamReport".equals(action))
            {
                spamStateChange(request, response);
                return;
            }
            else if ("claim".equals(action))
            {
                claim(request, response);
            }
            else if ("accept".equals(action))
            {
                acceptClaim(request, response);
            }
            else if ("reject".equals(action) || "unclaim".equals(action))
            {
                unClaim(request, response);
            }
            else*/ if (action2.equals(response.Action_EDIT))
            {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
                try
                {
                    ServiceProvider dirObj = (ServiceProvider) semObject.createGenericInstance();
                    mgr.processForm(request);

                    String dirPhoto = request.getParameter("dirPhotoHidden");
                    if (dirPhoto != null)
                    {
                        dirObj.setPhoto(dirPhoto);

                    }
                    dirPhoto = request.getParameter("PhotoLogoHidden");
                    if (dirPhoto != null)
                    {
                        dirObj.setPhotoLogo(dirPhoto);

                    }
                    processFiles(request, wsite, dirObj.getSemanticObject());
                    semObjTmp=dirObj.getSemanticObject();
                }
                catch (FormValidateException e)
                {
                    log.event(e);
                }
            }
            else if (action2.equals(response.Action_REMOVE))
            {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                semObject.remove();
                semObjTmp=semObject;
                //SWBUtils.IO.removeDirectory(SWBPortal.getWorkPath() + "/" + semObject.getWorkPath());
            }
            else if (action2.equals(response.Action_ADD))
            {
                SemanticClass cls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(request.getParameter("uri"));
                SWBFormMgr mgr = new SWBFormMgr(cls, wsite.getSemanticObject(), null);
                mgr.setFilterRequired(false);
                try
                {
                    SemanticObject sobj = mgr.processForm(request);
                    ServiceProvider dirObj = (ServiceProvider) sobj.createGenericInstance();
                    dirObj.setDirectoryResource(this);
                    dirObj.setWebPage(response.getWebPage());
                    dirObj.setSpCreator(user);
                    dirObj.setCreated(new Date());
                    dirObj.setSpStatus(1);

                    String refirect=null;
                    if(request.getParameter("destination")!=null) {
                        WebPage wdestination=wsite.getWebPage(request.getParameter("destination"));
                        if(wdestination!=null && wdestination instanceof Destination){
                            Destination dest=(Destination)wdestination;
                            dirObj.setDestination(dest);
                            refirect=dest.getUrl();
                        }
                    }
                    if(request.getParameter("destinationSec")!=null) {
                        WebPage wdestination=wsite.getWebPage(request.getParameter("destinationSec"));
                        if(wdestination!=null && wdestination instanceof Destination){
                            Destination dest=(Destination)wdestination;
                            dirObj.setDestinationSec(dest);
                            if(refirect==null) refirect=dest.getUrl();
                        }
                    }
                    int pymetype=1;
                    if(request.getParameter("pymetype")!=null) pymetype=Integer.parseInt(request.getParameter("pymetype"));
                    dirObj.setPymePaqueteType(pymetype);
                    processFiles(request, wsite, dirObj.getSemanticObject());
                    semObjTmp=dirObj.getSemanticObject();

                    if(pymetype==3 || pymetype==4){
                        MicroSitePyme ms = MicroSitePyme.ClassMgr.createMicroSitePyme("Microsite_"+dirObj.getId(),wsite); //TODO:Hacer que sea con el nombre de la pyme en formato de ID
                        if(pymetype==3) ms.setParent(wsite.getWebPage("Micrositios"));
                        else if(pymetype==4) ms.setParent(wsite.getWebPage("MsPremier"));
                        ms.setTitle(dirObj.getTitle());
                        ms.setDescription(dirObj.getDescription());
                        ms.setTags(dirObj.getTags());
                        ms.setActive(Boolean.TRUE);

                        String sdomain=request.getParameter("pymeDomain");
                        if(pymetype==4 && sdomain!=null && sdomain.trim().length()>0){ //Se asigna el DNS al Micrositio siempre y cuando sea de tipo 4 (PREMIER)
                            Dns newDns=Dns.ClassMgr.createDns(wsite);
                            newDns.setDns(request.getParameter("pymeDomain"));
                            newDns.setWebPage(ms);
                            newDns.setCreator(user);
                        }

                        //Le asigna el tipo de comunidad y el service provider al micrositio
                        MicroSiteType mstype=null;
                        if(pymetype==3) mstype=MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wsite);
                        else if(pymetype==4) mstype=MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wsite);
                        if(mstype!=null){
                            ms.setType(mstype);
                        }

                        ms.setServiceProvider(dirObj);

                        if(mstype!=null)
                        {
                            GenericIterator <MicroSiteUtil> gitmu=mstype.listMicroSiteUtils();
                            while(gitmu.hasNext())
                            {
                                MicroSiteUtil msu = (MicroSiteUtil)gitmu.next();
                                MicroSiteWebPageUtil mswpu = MicroSiteWebPageUtil.ClassMgr.createMicroSiteWebPageUtil(ms.getId()+"_"+msu.getId(), wsite);
                                mswpu.setTitle(msu.getTitle());

                                if(msu.getDescription()!=null && msu.getDescription().trim().length()>0)
                                {
                                    mswpu.setSortName(msu.getDescription());
                                }

                                mswpu.setMicroSite(ms);
                                mswpu.setMicroSiteUtil(msu);

                                mswpu.setParent(ms);
                                mswpu.setActive(Boolean.TRUE);
                            }
                        }
                    }
                    if(refirect!=null) response.sendRedirect(refirect); //Redirecciona al destino en el que se generó la pyme
                }
                catch (FormValidateException e)
                {
                    log.event(e);
                }
            }
            else if (action2.equals("admin_update"))
            {
                String editaccess = request.getParameter("editar");
                if (editaccess != null)
                {
                    base.setAttribute("editRole", editaccess);
                    base.updateAttributesToDB();
                }
            } else if (action2.equals("acceptRegistry"))
            {
                SemanticObject semObject = SemanticObject.createSemanticObject(URLDecoder.decode(request.getParameter("uri")));
                ServiceProvider servProp = (ServiceProvider) semObject.createGenericInstance();
                servProp.setSpStatus(2);

                String statComm = request.getParameter("statusComment");
                if (statComm != null) {
                    servProp.setSpStatusComment(statComm);
                }
            } else if (action2.equals("unRegister")) {
                SemanticObject semObject = SemanticObject.createSemanticObject(URLDecoder.decode(request.getParameter("uri")));
                ServiceProvider servProp = (ServiceProvider) semObject.createGenericInstance();
                servProp.setSpStatus(4);

                String statComm = request.getParameter("statusComment");
                if (statComm != null) {
                    servProp.setSpStatusComment(statComm);
                }
            }/*
            else if (action.equals("removeAttach"))
            {
                if (request.getParameter("removeAttach") != null)
                {
                    SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                    DirectoryObject dirObj = (DirectoryObject) semObject.createGenericInstance();
                    dirObj.removeExtraPhoto(request.getParameter("removeAttach"));
                    File file = new File(SWBPortal.getWorkPath() + "/" + semObject.getWorkPath() + "/" + request.getParameter("removeAttach"));
                    file.delete();
                    semObjTmp=dirObj.getSemanticObject();
                }
            }*/
        }
        catch (Exception e)
        {
            log.error(e);
        }
        String redirect=request.getParameter("redirect");
        if(redirect!=null){
            if(redirect.equals("detail")){
                response.setRenderParameter("act", "detail");
                response.setRenderParameter("uri", semObjTmp.getURI());

            }
        }
        response.setMode(response.Mode_VIEW);
    }

    private void getAbused(HttpServletRequest request,
            SWBActionResponse response)
    {
        String message = null;
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject mse = (DirectoryObject) so.getGenericInstance();
            message = String.valueOf(mse.getAbused());
        }
        response.setRenderParameter("message",
                message != null ? message : "Not OK");
        response.setMode("returnStateMessage");
    }

    private void processFiles(HttpServletRequest request, WebSite website, SemanticObject sobj)
    {
        String basepath = SWBPortal.getWorkPath() + sobj.getWorkPath() + "/";
        if (request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED) != null)
        {
            Iterator itfilesUploaded = ((List) request.getSession().getAttribute(UploadFormElement.FILES_UPLOADED)).iterator();
            while (itfilesUploaded.hasNext())
            {
                FileItem item = (FileItem) itfilesUploaded.next();
                if (!item.isFormField())
                { //Es un campo de tipo file
                    int fileSize = ((Long) item.getSize()).intValue();
                    String value = item.getName();
                    if (value != null && value.trim().length() > 0)
                    {
                        value = value.replace("\\", "/");
                        int pos = value.lastIndexOf("/");
                        if (pos > -1)
                        {
                            value = value.substring(pos + 1);
                        }
                        File fichero = new File(basepath);
                        if (!fichero.exists())
                        {
                            fichero.mkdirs();
                        }
                        fichero = new File(basepath + value);


                        ServiceProvider dirObj = (ServiceProvider) sobj.createGenericInstance();
                        if (item.getFieldName().equals("dirPhoto"))  {
                            String tmpPhoto=dirObj.getPhoto();
                            dirObj.setPhoto(value);
                            File file = new File(basepath + tmpPhoto);
                            file.delete();
                        }else if (item.getFieldName().equals("PhotoLogo"))  {
                            String tmpPhoto=dirObj.getPhotoLogo();
                            dirObj.setPhotoLogo(value);
                            File file = new File(basepath + tmpPhoto);
                            file.delete();
                        }

                        String ext = "";
                        pos = -1;
                        pos = value.indexOf(".");
                        if (pos > -1)
                        {
                            ext = value.substring(pos + 1);
                        }

                        try
                        {
                            item.write(fichero);
                            ImageResizer.resize(fichero, 180, true, fichero, ext);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            log.debug(e);
                        }
                    }
                }
            }
            request.getSession().setAttribute(UploadFormElement.FILES_UPLOADED, null);
        }
    }

    private void unClaim(HttpServletRequest request, SWBActionResponse response)
    {
        String suri = request.getParameter("uri");
        SemanticObject sobj = null;
        User user = response.getUser();

        if (suri != null && !suri.equals("null"))
        {
            sobj = SemanticObject.createSemanticObject(suri);
        }

        if (sobj.getGenericInstance() instanceof DirectoryObject)
        {
            if (user.isSigned())
            {
                if (sobj != null)
                {
                    sobj.removeProperty(Claimable.swbcomm_claimJustify);
                    sobj.removeProperty(Claimable.swbcomm_claimer);
                }
            }
        }

        response.setRenderParameter("uri", suri);
        response.setRenderParameter("act", "detail");
        response.setMode(SWBParamRequest.Mode_VIEW);
    }

    private void claim(HttpServletRequest request, SWBActionResponse response) throws SocketException
    {
        String suri = request.getParameter("uri");
        SemanticObject sobj = null;
        User user = response.getUser();

        String justify = request.getParameter("justify");
        if (justify == null || justify.equals("null"))
        {
            justify = "";
        }

        if (suri != null && !suri.equals("null"))
        {
            sobj = SemanticObject.createSemanticObject(suri);
        }

        if (sobj.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject dob = (DirectoryObject) sobj.createGenericInstance();
            Organization org = (Organization) sobj.createGenericInstance();
            org.setClaimer(user);
            org.setClaimJustify(justify);

            String realURL = "http://" + request.getServerName() + ":" + request.getServerPort() +
                    SWBPortal.getContextPath() + dob.getWebPage().getUrl() + "?act=detail&uri=" + dob.getEncodedURI();

            String defMessageBody = "El elemento \"" + dob.getTitle() + "\" ha sido reclamado por el usuario " +
                    user.getFullName() + " con la siguiente justificación:<br><br>\n\n" +
                    "\"" + sobj.getProperty(Claimable.swbcomm_claimJustify) + "\".<br><br>\n\n" +
                    "Para aceptar o rechazar el reclamo visite la siguiente liga: " +
                    "<a href=\"" + realURL + "\">" + realURL + "</a>";

            String messageBody = getDirClaimMessage();
            if (messageBody == null || messageBody.trim().equals("")) {
                messageBody = defMessageBody;
            } else {
                messageBody = replaceTags(messageBody, request, response);
            }
            String addressList = getAdminEMails(request, response);
            if (org.getCreator().getEmail() != null && !org.getCreator().getEmail().trim().equals(""))
            {
                addressList += ";" + org.getCreator().getEmail();
            }
            SWBUtils.EMAIL.sendBGEmail(addressList, "Notificación de reclamo", messageBody);
        }

        response.setRenderParameter("uri", suri);
        response.setRenderParameter("act", "detail");
        response.setMode(SWBParamRequest.Mode_VIEW);
    }

    private void acceptClaim(HttpServletRequest request, SWBActionResponse response) throws SocketException
    {
        String suri = request.getParameter("uri");
        SemanticObject sobj = null;

        if (suri != null && !suri.equals("null"))
        {
            sobj = SemanticObject.createSemanticObject(suri);
        }

        if (sobj.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject dob = (DirectoryObject) sobj.createGenericInstance();
            User claimer = (User) sobj.getObjectProperty(Claimable.swbcomm_claimer).createGenericInstance();

            String realURL = "http://" + request.getServerName() + ":" + request.getServerPort() +
                    SWBPortal.getContextPath() + dob.getWebPage().getUrl() + "?act=detail&uri=" + dob.getEncodedURI();

            String defMessageBody = "Su reclamo sobre el elemento \"" + dob.getTitle() + "\" ha sido aceptado. Ahora usted " +
                    "es responsable de la administración del mismo. Para ver los detalles del elemento, visite la" +
                    "siguiente liga:\n\n" + "<a href=\"" + realURL + "\">" + realURL + "</a>";

            String messageBody = getDirAcceptClaimMessage();
            if (messageBody == null || messageBody.trim().equals("")) {
                messageBody = defMessageBody;
            } else {
                messageBody = replaceTags(messageBody, request, response);
            }

            sobj.setObjectProperty(Traceable.swb_creator, claimer.getSemanticObject());
            sobj.removeProperty(Claimable.swbcomm_claimer);
            sobj.removeProperty(Claimable.swbcomm_claimJustify);

            SWBUtils.EMAIL.sendBGEmail(claimer.getEmail(), "Notificación de reclamo", messageBody);
        }

        response.setRenderParameter("uri", suri);
        response.setRenderParameter("act", "detail");
        response.setMode(SWBParamRequest.Mode_VIEW);
    }

    private void rank(HttpServletRequest request, SWBActionResponse response)
    {
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject mse = (DirectoryObject) so.createGenericInstance();
            int vote = 0;
            try
            {
                vote = Integer.parseInt(request.getParameter("value"));
            }
            catch (Exception ne)
            {
            }
            double rank = mse.getRank();

            long rev = mse.getReviews();

            response.setRenderParameter("uri", suri);

            rank = rank * rev;
            rev++;
            rank = rank + vote;
            rank = rank / rev;

            request.getSession().setAttribute("vote"+suri, true);
            mse.setRank(rank);
            mse.setReviews(rev);
        }
        response.setMode("returnRank");
    }

    private void abusedStateChange(HttpServletRequest request,
            SWBActionResponse response)
    {

        String message = null;
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject mse = (DirectoryObject) so.getGenericInstance();
            mse.setAbused(mse.getAbused() + 1);
            request.getSession().setAttribute(suri, "true");
        }
        response.setMode("returnStateMessage");
        response.setRenderParameter("message",
                message != null ? message : "Not OK");
    }

    private void addComment(HttpServletRequest request,
            SWBActionResponse response, User mem)
    {

        String suri = request.getParameter("uri");
        String desc = request.getParameter("comentario");

        GenericObject gen = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(suri);

        if (desc == null)
        {
            desc = "";
        }
        if (gen != null && gen instanceof DirectoryObject)
        {
            DirectoryObject mse = (DirectoryObject) gen;
            if (mse.canComment(mem) && desc.length() > 0)
            {
                Comment comment = Comment.ClassMgr.createComment(response.getWebPage().getWebSite());
                comment.setDescription(desc);
                mse.addComment(comment);
            }
        }
        response.setRenderParameter("uri", suri);
        response.setRenderParameter("act", "detail");
        response.setMode(SWBParamRequest.Mode_VIEW);
    }

    private void spamStateChange(HttpServletRequest request,
            SWBActionResponse response)
    {

        String message = null;
        String suri = request.getParameter("uri");
        String commentId = request.getParameter("commentId");
        SemanticObject so = null;
        if (commentId == null)
        {
            return;
        }
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject mse = (DirectoryObject) so.getGenericInstance();
            GenericIterator<Comment> iterator = mse.listComments();
            while (iterator.hasNext())
            {
                Comment comment = iterator.next();
                if (comment.getId().equals(commentId))
                {
                    try
                    {
                        comment.setSpam(comment.getSpam() + 1);
                    }
                    catch (Exception e)
                    {
                        comment.setSpam(1);
                    }
                    request.getSession().setAttribute(comment.getURI(), "true");
                    break;
                }
            }
        }
        response.setMode("returnStateMessage");
        response.setRenderParameter("message",
                message != null || "".equals(message)
                ? message : "Not OK");
    }

    private void returnRank(HttpServletRequest request, HttpServletResponse response)
    {
        String message = null;
        String suri = request.getParameter("uri");
        SemanticObject so = null;
        if (null != suri)
        {
            so = SemanticObject.createSemanticObject(suri);
        }
        if (so.getGenericInstance() instanceof DirectoryObject)
        {
            DirectoryObject mse = (DirectoryObject) so.createGenericInstance();
            message = mse.getRank() + "|" + mse.getReviews();

        }
        try
        {
            response.getWriter().print(message != null ? message : "Not OK");
        }
        catch (IOException ioe)
        {
        }
    }

    private void returnStateMessage(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
    {

        String message = request.getParameter("message");
        try
        {
            response.getWriter().print(message != null ? message : "Not OK");
        }
        catch (IOException ioe)
        {
        }
    }

    private String getAdminEMails(HttpServletRequest request, SWBActionResponse response)
    {
        String res = "";
        UserGroup ag = response.getWebPage().getWebSite().getUserRepository().getUserGroup("admin");

        if (ag != null)
        {
            Iterator<User> admUsers = ag.listUsers();
            while (admUsers.hasNext())
            {
                User usr = admUsers.next();
                if (usr.getEmail() != null && !usr.getEmail().trim().equals(""))
                {
                    res += usr.getEmail();
                    if (admUsers.hasNext())
                    {
                        res += ";";
                    }
                }
            }
        }
        return res;
    }

    private Iterator<ServiceProvider> getDirectoryObjects(SWBParamRequest paramRequest, HashMap<String, String> pars) {
        Destination dest = null;
        SPType type = null;
        ArrayList<ServiceProvider> providers = new ArrayList<ServiceProvider>();
        SearchQuery query = new SearchQuery();

        //Consulta para obtener todos los ServiceProviders
        query.addTerm(new SearchTerm(SWBIndexer.ATT_CLASS, "ServiceProvider", SearchTerm.OPER_AND));
        
        if (paramRequest.getWebPage() instanceof Destination) {
            dest = (Destination)paramRequest.getWebPage();
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
            } else {
                query.addTerm(new SearchTerm(SWBIndexer.ATT_CATEGORY, "Hotel", SearchTerm.OPER_AND));
            }
        }
        
        if (paramRequest.getWebPage() instanceof SPType) {
            type = (SPType)paramRequest.getWebPage();
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
        while(docs.hasNext()) {
            SearchDocument doc = docs.next();
            if (doc.getSearchable() != null) {
                ServiceProvider sp = (ServiceProvider)doc.getSearchable().getSemanticObject().createGenericInstance();
                providers.add(sp);
            }
        }
        
        return providers.iterator();
    }
}