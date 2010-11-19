package org.semanticwb.ecosikan.innova;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import org.semanticwb.Logger;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.*;

public class ThemeManager extends org.semanticwb.ecosikan.innova.base.ThemeManagerBase
{
    private static Logger log = SWBUtils.getLogger(ThemeManager.class);

    public ThemeManager()
    {
    }

   /**
   * Constructs a ThemeManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ThemeManager
   */
    public ThemeManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path = "/work/models/EcoSikan2/jsp/themes/init.jsp";
        String action = paramRequest.getAction();
        System.out.println("ThemeManager. action="+action);
        if( paramRequest.Action_ADD.equals(action) )
            path = "/work/models/EcoSikan2/jsp/themes/add.jsp";
//        else if( paramRequest.Action_EDIT.equals(action) )
//            path = "/work/models/EcoSikan/jsp/themes/edit.jsp";

        RequestDispatcher dis = request.getRequestDispatcher(path);
        try {
            request.setAttribute("paramRequest", paramRequest);
            dis.include(request, response);
        }catch (Exception e) {
            log.error(e);
            System.out.println(e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if( response.Action_ADD.equals(action) ) {
            try {
                add(request, response);
            }catch(Exception e) {
            }
        }
    }

    private void add(HttpServletRequest request, SWBActionResponse response) throws Exception {
        Resource base = getResourceBase();

        Theme theme = null;
        HashMap<String, String> params = new HashMap<String,String>();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart) {
            File tmpwrk = new File(SWBPortal.getWorkPath()+"/tmp");
            if (!tmpwrk.exists()) {
                tmpwrk.mkdirs();
            }
            FileItemFactory factory = new DiskFileItemFactory(1*1024*1024, tmpwrk);
            ServletFileUpload upload = new ServletFileUpload(factory);
            ProgressListener progressListener = new ProgressListener() {
                private long kBytes = -1;
                @Override
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
            List items = null;
            try {
                items = upload.parseRequest(request);
            }catch(FileUploadException fue) {
                throw fue;
            }
            FileItem currentFile = null;
            Iterator iter = items.iterator();
            while(iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if(item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString().trim();
                    params.put(name, value);
                }else {
                    currentFile = item;

                    theme = Theme.ClassMgr.createTheme(getResourceBase().getWebSite());
                    String path = SWBPortal.getWorkPath() + theme.getWorkPath();
                    File file = new File(path);
                    if(!file.exists()) {
                        file.mkdirs();
                    }
                    try {
                        String filename = currentFile.getName().replaceAll(" ", "_").trim();
                        if( filename.equals("") )
                            throw new IOException("El archivo es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                        file = new File(path +"/"+ filename);
                        currentFile.write(file);
                        params.put("filename", filename);
                    }catch(IOException ioe) {
                        response.setRenderParameter("msgErrFilename", "El archivo es requerido.");
                        log.error("El archivo es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                        throw new Exception("El archivo es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                    }
                }
            }
        }
        if(theme!=null) {
            Dependencia dependencia;
            WebSite site = response.getWebPage().getWebSite();

            if( params.containsKey("newsectitle")&&!params.get("newsectitle").isEmpty()&&params.containsKey("newsecdesc")&&!params.get("newsecdesc").isEmpty() ) {
                dependencia = Dependencia.ClassMgr.createDependencia(site);
                dependencia.setParent(site.getHomePage());
                dependencia.setTitle(params.get("newsectitle"));
                dependencia.setDescription(params.get("newsecdesc"));
                //dependencia.setIconClass("dependencia");
                dependencia.setActive(true);
            }else {
                //dependencia = (Dependencia)SemanticObject.createSemanticObject(params.get("dependencia")).createGenericInstance();
                dependencia = Dependencia.ClassMgr.getDependencia(params.get("dependencia"), site);
            }
            //theme.setIconClass("theme");

//            try {
//                String secretariaName = params.get("secret").trim();
//                if( dependencia.equals("") )
//                    throw new Exception("La secretaría es requerida. Resource "+base.getTitle()+" with id "+base.getId());
//                theme.setSecretaria(null);
//            }catch(Exception e) {
//                response.setRenderParameter("msgWrnSecretaria", "La secretaría es requerida.");
//                log.error("La secretaría es requerida. Resource "+base.getTitle()+" with id "+base.getId());
//                throw new Exception("La secretaría es requerida. Resource "+base.getTitle()+" with id "+base.getId());
//            }
            try {
                String title = params.get("title").trim();
                if( title.equals("") )
                    throw new Exception("El título es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                theme.setTitle(title);
            }catch(Exception e) {
                response.setRenderParameter("msgWrnTitle", "El título es requerido.");
                log.error("El título es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                throw new Exception("El título es requerido. Resource "+base.getTitle()+" with id "+base.getId());
            }
            try {
                String desc = params.get("desc").trim();
                if( desc.equals("") )
                    throw new Exception("La descripción es requerida. Resource "+base.getTitle()+" with id "+base.getId());
                theme.setDescription(desc);
            }catch(Exception e) {
                response.setRenderParameter("msgWrnDesc", "La descripción es requerida.");
                log.error("La descripción es requerida. Resource "+base.getTitle()+" with id "+base.getId());
                throw new Exception("La descripción es requerida. Resource "+base.getTitle()+" with id "+base.getId());
            }
//            try {
//                String img = params.get("filename").trim();
//                if( img.equals("") )
//                    throw new Exception("La descripción es requerida. Resource "+base.getTitle()+" with id "+base.getId());
//            }catch(Exception e) {
//                theme.setImage("noHay.jpg");
//                log.error("El tema no trae imagen. Resource "+base.getTitle()+" with id "+base.getId());
//            }
//            addThemes(theme);
            theme.setParent(dependencia);
            theme.setActive(true);
        }
    }
}
