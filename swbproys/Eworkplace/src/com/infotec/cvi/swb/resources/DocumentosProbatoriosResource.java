/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.resources;

import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.DocumentoProbatorio;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
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
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 * Recurso de contenido que permite altas, bajas y cambios del la informacion curricular asociada a un usuario de documentos probatorios
 *
 * @author juan.fernandez
 */
public class DocumentosProbatoriosResource extends GenericResource {

    private Logger log = SWBUtils.getLogger(DocumentosProbatoriosResource.class);
    private static final String DEFAULT_MIME_TYPE = "application/octet-stream";
    /** Modo personalizado para ejecutar getFile  */
    static final String MODE_GETFILE = "getFile";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        if (paramRequest.getMode().equals(MODE_GETFILE)) {
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

    /**
     * Permite al usuario descargar el archivo que previamente se guardó.
     *
     * @param request the request response
     * @param response the response paramRequest
     * @param paramRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred
     */
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
        String action = response.getAction();
        String msg = "";
        if (action == null) {
            action = "";
        }


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

        org.semanticwb.portal.util.FileUpload fup = new org.semanticwb.portal.util.FileUpload();
        if (action.equals(SWBResourceURL.Action_ADD)) {

            fup.getFiles(request, null);
            String factanac = fup.getFileName("actaNacimiento");
            String factamat = fup.getFileName("actaMatrimonio");
            String fhasActas = fup.getFileName("hasActaNacimiento");
            String ffoto = fup.getFileName("fotoInfantil");
            String frfc = fup.getFileName("copiaRFC");
            String fcurp = fup.getFileName("CURP");
            String fhasEstudio = fup.getFileName("hasComprobantesEstudio");
            String fhasId = fup.getFileName("hasIdentificacion");
            String fdomicilio = fup.getFileName("comprobanteDomicilio");
            String fnumss = fup.getFileName("numeroSegSocial");

            byte[] bcont = null;

            if (factanac != null) {
                bcont = fup.getFileData("actaNacimiento");
                if (docto.getFileActaNacimiento() != null) {
                    if (!removeFile(docto.getFileActaNacimiento(), docto)) {
                        msg = "Error al tratar de eliminar el archivo: " + getFileName(docto.getFileActaNacimiento());
                    }
                }
                storeFile(factanac, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_fileActaNacimiento);
                docto.setFileActaNacimiento(DocumentoProbatorio.intranet_fileActaNacimiento.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(factanac));
            }
            if (factamat != null) {
                bcont = fup.getFileData("actaMatrimonio");
                if (docto.getFileActaMatrimonio() != null) {
                    if (!removeFile(docto.getFileActaMatrimonio(), docto)) {
                        msg = "Error al tratar de eliminar el archivo: " + getFileName(docto.getFileActaMatrimonio());
                    }
                }
                storeFile(factamat, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_fileActaMatrimonio);
                docto.setFileActaMatrimonio(DocumentoProbatorio.intranet_fileActaMatrimonio.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(factamat));
            }
            if (fhasActas != null) {
                bcont = fup.getFileData("hasActaNacimiento");
                storeFile(fhasActas, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_hasActasNacimientoFamiliares);
                String fkey = DocumentoProbatorio.intranet_hasActasNacimientoFamiliares.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(fhasActas);
                boolean existe = false;
                Iterator<String> its = docto.listActasNacimientoFamiliareses();
                while (its.hasNext()) {
                    String string = its.next();
                    if(string.equals(fkey)){
                        existe=true;
                        break;
                    }
                }
                if(!existe) docto.addActasNacimientoFamiliares(fkey);
            }
            if (ffoto != null) {
                bcont = fup.getFileData("fotoInfantil");
                if (docto.getFileFotoTamInfantil() != null) {
                    if (!removeFile(docto.getFileFotoTamInfantil(), docto)) {
                        msg = "Error al tratar de eliminar el archivo: " + getFileName(docto.getFileFotoTamInfantil());
                    }
                }
                storeFile(ffoto, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_fileFotoTamInfantil);
                docto.setFileFotoTamInfantil(DocumentoProbatorio.intranet_fileFotoTamInfantil.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(ffoto));
            }
            if (frfc != null) {
                bcont = fup.getFileData("copiaRFC");
                if (docto.getFileCopiaRFC() != null) {
                    if (!removeFile(docto.getFileCopiaRFC(), docto)) {
                        msg = "Error al tratar de eliminar el archivo: " + getFileName(docto.getFileCopiaRFC());
                    }
                }
                storeFile(frfc, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_fileCopiaRFC);
                docto.setFileCopiaRFC(DocumentoProbatorio.intranet_fileCopiaRFC.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(frfc));
            }
            if (fcurp != null) {
                bcont = fup.getFileData("CURP");
                if (docto.getFileCURP() != null) {
                    if (!removeFile(docto.getFileCURP(), docto)) {
                        msg = "Error al tratar de eliminar el archivo: " + getFileName(docto.getFileCURP());
                    }
                }
                storeFile(fcurp, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_fileCURP);
                docto.setFileCURP(DocumentoProbatorio.intranet_fileCURP.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(fcurp));
            }
            if (fhasEstudio != null) {
                bcont = fup.getFileData("hasComprobantesEstudio");
                storeFile(fhasEstudio, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_hasFilesComprobanteEstudio);
                String fkey = DocumentoProbatorio.intranet_hasFilesComprobanteEstudio.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(fhasEstudio);
                boolean existe = false;
                Iterator<String> its = docto.listFilesComprobanteEstudios();
                while (its.hasNext()) {
                    String string = its.next();
                    if(string.equals(fkey)){
                        existe=true;
                        break;
                    }
                }
                if(!existe) docto.addFilesComprobanteEstudio(fkey);
            }
            if (fhasId != null) {
                bcont = fup.getFileData("hasIdentificacion");
                storeFile(fhasId, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_hasFilesIdentificacionOficial);
                String fkey = DocumentoProbatorio.intranet_hasFilesIdentificacionOficial.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(fhasId);
                boolean existe = false;
                Iterator<String> its = docto.listFilesIdentificacionOficials();
                while (its.hasNext()) {
                    String string = its.next();
                    if(string.equals(fkey)){
                        existe=true;
                        break;
                    }
                }
                if(!existe) docto.addFilesIdentificacionOficial(fkey);
            }
            if (fdomicilio != null) {
                bcont = fup.getFileData("comprobanteDomicilio");
                if (docto.getFileComprobanteDomicilio() != null) {
                    if (!removeFile(docto.getFileComprobanteDomicilio(), docto)) {
                        msg = "Error al tratar de eliminar el archivo: " + getFileName(docto.getFileComprobanteDomicilio());
                    }
                }
                storeFile(fdomicilio, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_fileComprobanteDomicilio);
                docto.setFileComprobanteDomicilio(DocumentoProbatorio.intranet_fileComprobanteDomicilio.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(fdomicilio));
            }
            if (fnumss != null) {
                bcont = fup.getFileData("numeroSegSocial");
                if (docto.getFileNumeroSeguridadSocial() != null) {
                    if (!removeFile(docto.getFileNumeroSeguridadSocial(), docto)) {
                        msg = "Error al tratar de eliminar el archivo: " + getFileName(docto.getFileNumeroSeguridadSocial());
                    }
                }
                storeFile(fnumss, new ByteArrayInputStream(bcont), docto, DocumentoProbatorio.intranet_fileNumeroSeguridadSocial);
                docto.setFileNumeroSeguridadSocial(DocumentoProbatorio.intranet_fileNumeroSeguridadSocial.getName() + "_" + docto.getSemanticObject().getId() + "_" + getFileName(fnumss));
            }
        } else if (action.equals(SWBResourceURL.Action_REMOVE)) {

            String spid = request.getParameter("propURI");
            String fileid = request.getParameter("fileid");
            //System.out.println("prop:" + spid);
            //System.out.println("fileid:" + fileid);

            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticProperty sp = ont.getSemanticProperty(spid);

            if (sp.equals(DocumentoProbatorio.intranet_fileActaNacimiento)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.setFileActaNacimiento(null);
            } else if (sp.equals(DocumentoProbatorio.intranet_fileActaMatrimonio)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.setFileActaMatrimonio(null);
            } else if (sp.equals(DocumentoProbatorio.intranet_fileCURP)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.setFileCURP(null);
            } else if (sp.equals(DocumentoProbatorio.intranet_fileComprobanteDomicilio)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.setFileComprobanteDomicilio(null);
            } else if (sp.equals(DocumentoProbatorio.intranet_fileCopiaRFC)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.setFileCopiaRFC(null);
            } else if (sp.equals(DocumentoProbatorio.intranet_fileFotoTamInfantil)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.setFileFotoTamInfantil(null);
            } else if (sp.equals(DocumentoProbatorio.intranet_fileNumeroSeguridadSocial)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.setFileNumeroSeguridadSocial(null);
            } else if (sp.equals(DocumentoProbatorio.intranet_hasActasNacimientoFamiliares)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.removeActasNacimientoFamiliares(fileid);
            } else if (sp.equals(DocumentoProbatorio.intranet_hasFilesComprobanteEstudio)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.removeFilesComprobanteEstudio(fileid);
            } else if (sp.equals(DocumentoProbatorio.intranet_hasFilesIdentificacionOficial)) {
                if (!removeFile(fileid, docto)) {
                    msg = "Error al tratar de eliminar el archivo: " + getFileName(fileid);
                }
                docto.removeFilesIdentificacionOficial(fileid);
            }
            //System.out.println("msg:" + msg);
            if (msg != null && msg.trim().length() > 0) {
                response.setRenderParameter("alertmsg", msg);
            }

        }


//        try {
//            SWBFormMgr fmgr = null;
//            fmgr = new SWBFormMgr(docto.getSemanticObject(), SWBFormMgr.MODE_EDIT, SWBFormMgr.MODE_EDIT);
//            fmgr.processForm(request);
//
//        } catch (Exception exfiles) {
//            log.error("Error al procesar la forma - UploadFiles FormatoValidacionDocs.processAction()", exfiles);
//        }

    }

    /**
     * Al actualizar un archivo, si existe una versión anterior la elimina, revisa y crea la ruta en donde se va almacenar el archivo.
     *
     * @param name Nombre
     * @param doc DocumentoProbatorio
     * @param sp Propiedad semantica
     * @return OutputStream, Stream de salida del archivo en cuestión
     * @throws FileNotFoundException 
     */
    public OutputStream storeFile(String name, DocumentoProbatorio doc, SemanticProperty sp) throws FileNotFoundException {

        String inicio_nombre = sp.getName() + "_" + doc.getSemanticObject().getId();

        if (!sp.getName().startsWith("has") && doc.getProperty(sp.getName()) != null && doc.getProperty(sp.getName()).trim().length() > 0) {
            // eliminar archivo anterior 
            String fileName = doc.getProperty(sp.getName());
            File fileAnt = new File(SWBPortal.getWorkPath() + doc.getSemanticObject().getWorkPath() + fileName);
            fileAnt.delete();
        }

        File file = new File(SWBPortal.getWorkPath() + doc.getSemanticObject().getWorkPath());
        file.mkdirs();
        return new FileOutputStream(SWBPortal.getWorkPath() + doc.getSemanticObject().getWorkPath() + "/" + inicio_nombre + "_" + getFileName(name));
    }

    /**
     * Almacena el archivo en la ruta predefinida del RepositoryFile,
     * Si no existe ninguna version crea una nueva
     * Si existe una version anterior agrega una nueva versión
     * 
     * @param name Nombre
     * @param doc  documentoProbatorio
     * @param in InputStream
     * @param semprop
     */
    public void storeFile(String name, InputStream in, DocumentoProbatorio doc, SemanticProperty semprop) {

        try {
            OutputStream out = storeFile(name, doc, semprop);
            SWBUtils.IO.copyStream(in, out);
            doc.setProperty(semprop.getName(), name);
        } catch (Exception e) {
            log.error(e);
        }
    }

    /**
     * Obtiene el nombre del archivo, quitando la ruta en donde se encuentra el archivo
     *
     * @param name Cadena
     * @return nombre del archivo.
     */
    public String getFileName(String name) {
        if (name.lastIndexOf('/') != -1) {
            int pos = name.lastIndexOf('/');
            name = name.substring(pos + 1);
        }
        if (name.lastIndexOf('\\') != -1) {
            int pos = name.lastIndexOf('\\');
            name = name.substring(pos + 1);
        }
        return name;
    }

    /**
     * Elimina el archivo recibido
     *
     * @param fname Nombre
     * @param docto DocumentoProbatorio
     * @return true, si se eliminó el archivo; false, si ocurrió un error al tratar de eliminarlo
     */
    public boolean removeFile(String fname, DocumentoProbatorio docto) {
        boolean ret = false;
        try {
            String destpath = SWBPortal.getWorkPath() + docto.getSemanticObject().getWorkPath();
            File dir = new File(destpath);
            File dest = new File(dir, fname);
            dest.delete();
            ret = true;
        } catch (Exception e) {
            ret = false;
        }


        return ret;
    }
}
