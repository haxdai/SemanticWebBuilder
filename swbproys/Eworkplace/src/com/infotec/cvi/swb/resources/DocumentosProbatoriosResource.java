/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.DocumentoProbatorio;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author juan.fernandez
 */
public class DocumentosProbatoriosResource extends GenericResource {

    private Logger log = SWBUtils.getLogger(DocumentosProbatoriosResource.class);
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    static final String MODE_GETFILE ="getFile"; 

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        if(paramRequest.getMode().equals(MODE_GETFILE)){
            doGetFile(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    
    @Override
    public void doView(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/" + this.getClass().getSimpleName() + "/";
        String path = basePath + "view.jsp";
        if (request != null) {
            RequestDispatcher dis = request.getRequestDispatcher(path);

            if (null != dis) {
                try {
                    request.setAttribute("paramRequest", paramRequest);
                    request.setAttribute("this", this);
                    dis.include(request, response);
                } catch (Exception e) {
                    log.error(e);
                }
            }
        }
    }

    public void doGetFile(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        String fileName = request.getParameter("fileid");
        String propURI = request.getParameter("propURI");
        
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticProperty sp = ont.getSemanticProperty(propURI);
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy-hhmmaaa", new Locale("es"));

        User usr = paramRequest.getUser();
        WebSite wsite = paramRequest.getWebPage().getWebSite();

        CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
        if (cv == null) {
            cv = CV.ClassMgr.createCV(usr.getId(), wsite);
            cv.setPropietario(usr);
        }

        DocumentoProbatorio docto = cv.getDocumentoProbatorio();
        if (docto == null) {
            docto = DocumentoProbatorio.ClassMgr.createDocumentoProbatorio(wsite);
            cv.setDocumentoProbatorio(docto);
        }


        String action = paramRequest.getAction();
        try {
            String mime = null;
            mime = DEFAULT_MIME_TYPE;

            InputStream fin = null;
 
            fin = SWBPortal.getFileFromWorkPath(docto.getSemanticObject().getWorkPath() + "/" + fileName);

            String inicio_nombre = sp.getName() + "_" + docto.getSemanticObject().getId();
            if (fileName.startsWith(inicio_nombre)) {
                fileName = fileName.substring(inicio_nombre.length() + 1);
            }

            if (action != null && "inline".equals(action)) {
                response.setContentType(mime);
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
            }

            OutputStream out = response.getOutputStream();
            SWBUtils.IO.copyStream(fin, out); //
        } catch (Exception e) {
            log.error("Error al obtener el archivo del Formato de Validacion S.D.", e);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {

        User usr = response.getUser();
        WebPage wpage = response.getWebPage();
        WebSite wsite = wpage.getWebSite();
        CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
        if (cv == null) {
            cv = CV.ClassMgr.createCV(usr.getId(), wsite);
            cv.setPropietario(usr);
        }

        DocumentoProbatorio docto = cv.getDocumentoProbatorio();
        if (docto == null) {
            docto = DocumentoProbatorio.ClassMgr.createDocumentoProbatorio(wsite);
            cv.setDocumentoProbatorio(docto);
        }
        try {
            SWBFormMgr fmgr = null;
            fmgr = new SWBFormMgr(docto.getSemanticObject(), SWBFormMgr.MODE_EDIT, SWBFormMgr.MODE_EDIT);
            fmgr.processForm(request);

        } catch (Exception exfiles) {
            log.error("Error al procesar la forma - UploadFiles FormatoValidacionDocs.processAction()", exfiles);
        }

    }
}
