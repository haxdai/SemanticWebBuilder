package org.semanticwb.ecosikan.innova;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.ecosikan.innova.util.LastComments;
import org.semanticwb.ecosikan.innova.util.LastIdeas;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;

public class DependenciaManager extends org.semanticwb.ecosikan.innova.base.DependenciaManagerBase 
{
    private static Logger log = SWBUtils.getLogger(DependenciaManager.class);
    private static LastComments lastComments = new LastComments(3);
    private static LastIdeas lastIdeas = new LastIdeas(3);

    public DependenciaManager()
    {
    }

   /**
   * Constructs a DependenciaManager with a SemanticObject
   * @param base The SemanticObject with the properties for the DependenciaManager
   */
    public DependenciaManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        final WebPage wp = paramRequest.getWebPage();
        final WebSite model = wp.getWebSite();
        final String modelId = paramRequest.getWebPage().getWebSiteId();
        final Boolean userCanEdit = userCanEdit(paramRequest.getUser());

        if(wp instanceof Dependencia) {
            Dependencia dependencia = (Dependencia)wp;
            final String path = SWBPortal.getWebWorkPath()+dependencia.getWorkPath()+"/";
            out.println("<div class=\"logosec\">");
            out.println("    <a href=\"#\"><img alt=\"\" src=\""+path+dependencia.getImage()+"\" width=\"216\" height=\"62\" /></a>");
            out.println("</div>");
            out.println("<h2><br />"+dependencia.getTitle()+"<br /></h2>");
        }else {
            String path = "/work/models/"+modelId+"/jsp/dependencia/init.jsp";
            String action = paramRequest.getAction();
            if( paramRequest.Action_ADD.equals(action)&&userCanEdit )
                path = "/work/models/"+modelId+"/jsp/dependencia/add.jsp";
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

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        final boolean userCanEdit = userCanEdit(response.getUser());

        if( response.Action_ADD.equals(action)&&userCanEdit ) {
            try {
                Dependencia dependencia = add(request, response);
                if(dependencia!=null) {
                    response.sendRedirect(dependencia.getRealUrl());
                }
            }catch(Exception e) {
            }


//                Challenge challenge = Challenge.ClassMgr.createChallenge(model);
//                challenge.setParent(model.getHomePage());
//                challenge.setTitle(request.getParameter("title").trim());
//                challenge.setDescription(request.getParameter("desc").trim());
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");
//                try {
//                    System.out.println("adding reto... expire="+request.getParameter("expire")+" 12:00");
//                    challenge.setExpiration(sdf.parse(request.getParameter("expire")+" 12:00"));
//                }catch(ParseException pe) {
//                    GregorianCalendar expire = new GregorianCalendar();
//                    expire.add(GregorianCalendar.MONTH, 1);
//                    challenge.setExpiration(expire.getTime());
//                }
//                challenge.setActive(true);
//                challenge.setPhase(Phases.Opened.name());
//
//                Template tpl = model.getTemplate("7");
//                TemplateRef tref = model.createTemplateRef();
//                tref.setTemplate(tpl);
//                tref.setActive(Boolean.TRUE);
//                tref.setInherit(TemplateRef.INHERIT_ACTUALANDCHILDS);
//                challenge.addTemplateRef(tref);
//
//                Rule r = model.getRule("1");
//                RuleRef rref = model.createRuleRef();
//                rref.setRule(r);
//                rref.setActive(Boolean.TRUE);
//                challenge.addRuleRef(rref);
        }
    }

    private Dependencia add(HttpServletRequest request, SWBActionResponse response) throws Exception {
        Resource base = getResourceBase();
        WebSite site = response.getWebPage().getWebSite();
        Dependencia dependencia = null;
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

                    dependencia = Dependencia.ClassMgr.createDependencia(site);
                    String path = SWBPortal.getWorkPath() + dependencia.getWorkPath();
                    File file = new File(path);
                    if(!file.exists()) {
                        file.mkdirs();
                    }

                    String filename = currentFile.getName().replaceAll(" ", "_").trim();
                    if( filename.isEmpty() )
                        throw new Exception("El archivo es requerido. Resource "+base.getTitle()+" with id "+base.getId());
                    file = new File(path +"/"+ filename);
                    currentFile.write(file);
                    params.put("filename", filename);
                }
            }
        }
        if(dependencia!=null) {
            dependencia.addData(response, params);
            addDependencia(dependencia);
        }
        return dependencia;
    }

    private Boolean userCanEdit(User user) {
//        Role role = Role.ClassMgr.getRole(base.getAttribute("roleId"), wp.getWebSite());
//        User user = paramRequest.getUser();
//        final boolean canEdit = true;//user.hasRole(role);
        return true;
    }
}
