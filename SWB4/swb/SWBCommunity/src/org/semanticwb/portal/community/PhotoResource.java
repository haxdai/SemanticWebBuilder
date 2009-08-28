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

package org.semanticwb.portal.community;

import java.io.*;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.community.utilresources.ImageResizer;

public class PhotoResource extends org.semanticwb.portal.community.base.PhotoResourceBase {
    private static Logger log=SWBUtils.getLogger(PhotoResource.class);

    public PhotoResource() {
    }

    public PhotoResource(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        System.out.println("path="+SWBPlatform.getWebWorkPath()+getResourceBase().getWorkPath()+"/");
        String act=request.getParameter("act");
        if(act==null) {
            act = (String)request.getSession(true).getAttribute("act");
            /*request.getSession(true).setAttribute("act", null);
            request.getSession(true).removeAttribute("act");*/
        }
        if(act==null) {
            act = "view";
        }        

        String path="/swbadmin/jsp/microsite/PhotoResource/photoView.jsp";
        if(act.equals("add"))path="/swbadmin/jsp/microsite/PhotoResource/photoAdd.jsp";
        if(act.equals("edit"))path="/swbadmin/jsp/microsite/PhotoResource/photoEdit.jsp";
        if(act.equals("detail"))path="/swbadmin/jsp/microsite/PhotoResource/photoDetail.jsp";

        RequestDispatcher dis=request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }catch(Exception e){log.error(e);}
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final String path="/../swbadmin/jsp/microsite/PhotoResource/sinfoto.png";
        WebPage page = response.getWebPage();
        Member mem=Member.getMember(response.getUser(),response.getWebPage());
        if(!mem.canView())return;  //si el usuario no pertenece a la red sale;

        String action=request.getParameter("act");
        if(action==null) {
            HashMap<String,String> params = upload(request);
            if(mem.canAdd() && params.containsValue("add")) {
                PhotoElement rec = PhotoElement.createPhotoElement(getResourceBase().getWebSite());
                if(params.containsKey("filename"))
                    rec.setImageURL(params.get("filename"));
                else
                    rec.setImageURL(path);
                if(params.containsKey("thumbnail"))
                    rec.setPhotoThumbnail(params.get("thumbnail"));
                else
                    rec.setPhotoThumbnail(path);
                rec.setTitle(params.get("title"));
                rec.setDescription(params.get("description"));
                rec.setTags(params.get("tags"));
                rec.setVisibility(Integer.parseInt(params.get("level")));
                if(page instanceof MicroSiteWebPageUtil) {
                    ((MicroSiteWebPageUtil)page).sendNotification(rec);
                }
                rec.setPhotoWebPage(page);
            }
        }
        else if("edit".equals(action)) {
            String uri=request.getParameter("uri");
            PhotoElement rec = (PhotoElement)SemanticObject.createSemanticObject(uri).createGenericInstance();
            if(rec!=null && rec.canModify(mem)) {
                rec.setTitle(request.getParameter("title"));
                rec.setDescription(request.getParameter("description"));
                rec.setTags(request.getParameter("tags"));
                rec.setVisibility(Integer.parseInt(request.getParameter("level")));
                if(page instanceof MicroSiteWebPageUtil) {
                    ((MicroSiteWebPageUtil)page).sendNotification(rec);
                }
            }
            response.setRenderParameter("act", "view");
        }
        else if("remove".equals(action)) {
            String uri = request.getParameter("uri");
            PhotoElement rec = (PhotoElement)SemanticObject.createSemanticObject(uri).createGenericInstance();
            if(rec!=null && rec.canModify(mem)) {
                rec.remove();  //elimina el registro
            }
        }else {
            super.processAction(request, response);
        }
    }

    @Override
    public void doAdminHlp(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Member mem=Member.getMember(paramRequest.getUser(), paramRequest.getWebPage());

        if(mem.canAdd()) {
            HashMap<String,String> params = upload(request);

            WebPage page = paramRequest.getWebPage();
            PhotoElement rec = PhotoElement.createPhotoElement(getResourceBase().getWebSite());
            rec.setImageURL(params.get("filename"));


            rec.setTitle(params.get("title"));
            rec.setDescription(params.get("description"));
            rec.setTags(params.get("tags"));
            rec.setVisibility(Integer.parseInt(params.get("level")));
            if(page instanceof MicroSiteWebPageUtil) {
                ((MicroSiteWebPageUtil)page).sendNotification(rec);
            }
            rec.setPhotoWebPage(page);
        }
    }

    private HashMap<String,String> upload(HttpServletRequest request) {
        final String realpath = SWBPlatform.getWorkPath()+getResourceBase().getWorkPath()+"/";
        final String path = getResourceBase().getWorkPath()+"/";
        
        HashMap<String,String> params = new HashMap<String,String>();
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if(isMultipart) {
                File tmpwrk = new File(SWBPlatform.getWorkPath()+"/tmp");
                if (!tmpwrk.exists()) {
                    tmpwrk.mkdirs();
                }
                FileItemFactory factory = new DiskFileItemFactory(1*1024*1024, tmpwrk);
                ServletFileUpload upload = new ServletFileUpload(factory);
                ProgressListener progressListener = new ProgressListener() {
                    private long kBytes = -1;
                    public void update(long pBytesRead, long pContentLength, int pItems) {
                        long mBytes = pBytesRead / 10000;
                        if (kBytes == mBytes) {
                        return;
                        }
                        kBytes = mBytes;
                        int percent = (int)(pBytesRead * 100 / pContentLength);
                    }
                };
                upload.setProgressListener(progressListener);
                List items = upload.parseRequest(request); /* FileItem */
                FileItem currentFile = null;
                Iterator iter = items.iterator();
                while(iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if(item.isFormField()) {
                        String name = item.getFieldName();
                        String value = item.getString();
                        params.put(name, value);
                    }else {
                        currentFile = item;
                        File file = new File(path);
                        if(!file.exists()) {
                            file.mkdirs();
                        }

                        try {
                            long serial = (new Date()).getTime();
                            String filename = serial+"_"+currentFile.getFieldName()+currentFile.getName().substring(currentFile.getName().lastIndexOf("."));

                            File image = new File(realpath);
                            if(!image.exists()) {
                                image.mkdir();
                            }
                            image = new File(realpath+filename);
                            File thumbnail = new File(realpath+"thumbn_"+filename);
                            currentFile.write(image);
                            ImageResizer.resize(image, 130, true, thumbnail, "jpeg" );
                            
                            params.put("filename", path+filename);
                            params.put("thumbnail", path+"thumbn_"+filename);
                        }catch(StringIndexOutOfBoundsException iobe) {
                        }
                    }
                }
            }
        }catch(Exception ex)  {
            ex.printStackTrace();
        }
//        return null;
        return params;
    }
}
