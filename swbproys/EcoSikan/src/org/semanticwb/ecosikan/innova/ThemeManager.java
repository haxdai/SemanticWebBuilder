package org.semanticwb.ecosikan.innova;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
import org.semanticwb.model.Template;
import org.semanticwb.model.TemplateRef;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class ThemeManager extends org.semanticwb.ecosikan.innova.base.ThemeManagerBase {
    private static Logger log = SWBUtils.getLogger(ThemeManager.class);
    private static final String Template_ID = "10";
    private static final int List_Last = 3;

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
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = wp.getWebSiteId();
        final Boolean userCanEdit = userCanEdit(paramRequest.getUser());
        
        if(wp instanceof Theme) {
            Theme theme = (Theme)wp;
            final String path = SWBPortal.getWebWorkPath()+theme.getWorkPath()+"/";
            out.println("<h2>Tema: "+theme.getTitle()+"</h2>");
            out.println("<div class=\"pic\">");
            out.println("<img src=\""+path+theme.getImage()+"\" alt=\""+theme.getTitle()+"\" width=\"260\" height=\"198\" />");
            out.println(theme.getTitle());
            out.println("</div>");
            out.println("<p>");
            out.println(theme.getDescription());
            out.println("</p>");
            out.println("<p>&nbsp;</p>");
            //LIST COMMENTS
        }else if(wp instanceof Dependencia) {
            String path = "/work/models/"+modelId+"/jsp/themes/init.jsp";

            String action = paramRequest.getAction();
            if( userCanEdit && paramRequest.Action_ADD.equals(action) )
                path = "/work/models/"+modelId+"/jsp/themes/add.jsp";

            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("userCanEdit", userCanEdit);
            RequestDispatcher dis = request.getRequestDispatcher(path);
            try {
                dis.include(request, response);
            }catch (Exception e) {
                log.error(e);
                e.printStackTrace(System.out);
            }
        }
    }

    private Iterator<Comment> listLastComments(final Theme theme, final int size) {
        Idea idea;
        Iterator<Idea> ideas = theme.listIdeas();
        ArrayList cmnts = new ArrayList();
        while(ideas.hasNext()) {
            idea = ideas.next();
            cmnts.addAll(SWBUtils.Collections.copyIterator(idea.listComments()));
        }
        Collections.sort(cmnts, new Comment.CommentsSortByCreatedDate());
        if(cmnts.size()>List_Last)
            return cmnts.subList(0, List_Last).iterator();
        else
            return cmnts.iterator();
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        final boolean userCanEdit = userCanEdit(response.getUser());

        if(response.Action_ADD.equals(action)&&userCanEdit) {
            try {
                Theme theme = add(request, response);
                if(theme!=null) {
                    response.sendRedirect(theme.getRealUrl());
                }
            }catch(Exception e) {
            }
        }
    }

    private Theme add(HttpServletRequest request, SWBActionResponse response) throws Exception {
        Resource base = getResourceBase();
        WebSite site = response.getWebPage().getWebSite();
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

                    theme = Theme.ClassMgr.createTheme(site);
                    String path = SWBPortal.getWorkPath() + theme.getWorkPath();
                    File file = new File(path);
                    if(!file.exists()) {
                        file.mkdirs();
                    }
                    try {
                        String filename = currentFile.getName().replaceAll(" ", "_").trim();
                        if( filename.isEmpty() )
                            throw new Exception("El archivo es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                        file = new File(path +"/"+ filename);
                        currentFile.write(file);
                        params.put("filename", filename);
                    }catch(Exception ioe) {
                        response.setRenderParameter("msgErrFilename", "El archivo es requerido.");
                        log.error("El archivo es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                        throw new Exception("El archivo es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                    }
                }
            }
        }
        if(theme!=null) {
            if(!params.containsKey("title")||(params.containsKey("title")&&params.get("title").isEmpty())) {
                response.setRenderParameter("", "");
                throw new Exception("Valor requerido. Resource "+base.getTitle()+" with id "+base.getId());
            }
            if(!params.containsKey("desc")||(params.containsKey("desc")&&params.get("desc").isEmpty())) {
                response.setRenderParameter("", "");
                throw new Exception("Valor requerido. Resource "+base.getTitle()+" with id "+base.getId());
            }

            theme.setParent(response.getWebPage());
            theme.setTitle(params.get("title"));
            theme.setDescription(params.get("desc"));
            theme.setImage(params.get("filename"));
            theme.setActive(Boolean.TRUE);
            addThemes(theme);

            Template tpl = site.getTemplate(Template_ID);
            TemplateRef tref = site.createTemplateRef();
            tref.setTemplate(tpl);
            tref.setActive(Boolean.TRUE);
            tref.setInherit(TemplateRef.INHERIT_ACTUAL);
            theme.addTemplateRef(tref);
        }
        return theme;
    }

    private Boolean userCanEdit(User user) {
//        Role role = Role.ClassMgr.getRole(base.getAttribute("roleId"), wp.getWebSite());
//        User user = paramRequest.getUser();
//        final boolean canEdit = true;//user.hasRole(role);
        return true;
    }
}
