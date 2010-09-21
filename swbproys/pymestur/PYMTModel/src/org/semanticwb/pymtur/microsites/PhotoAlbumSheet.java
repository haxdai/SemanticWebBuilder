package org.semanticwb.pymtur.microsites;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

import org.semanticwb.pymtur.PymePhoto;
import org.semanticwb.pymtur.ServiceProvider;

import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.User;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.SWBPlatform;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Role;
import org.semanticwb.model.UserGroup;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.pymtur.Paquete;

/**
 *
 * @author carlos.ramos
 */

public class PhotoAlbumSheet extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(PhotoAlbum.class);
    private static final String _thumbnail = "thumbn_";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        //Se ve el recurso desde un micrositio
        ServiceProvider sprovider = null;
        if(request.getParameter("uri")!=null){
            String suri = request.getParameter("uri");
            SemanticObject semObject = SemanticObject.createSemanticObject(suri);
            sprovider = (ServiceProvider) semObject.createGenericInstance();
            renderResourceForSheet(request, response, paramRequest, sprovider);
        }
    }

    private String getFormManager(SWBParamRequest paramRequest, ServiceProvider sprovider) {
        Resource base=getResourceBase();
        StringBuffer ret=new StringBuffer();

        SWBResourceURL url = paramRequest.getActionUrl();
        url.setAction(paramRequest.Action_ADD);
        url.setParameter("uri", sprovider.getURI());
        url.setCallMethod(paramRequest.Call_DIRECT);

        ret.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        ret.append("<html lang=\"es-mx\">");
        ret.append("<head>");
        ret.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO8859-1\" >");
        ret.append("<title></title>");
        ret.append("<link href=\""+SWBPortal.getWebWorkPath()+"/models/"+base.getWebSiteId()+"/css/images/estilos.css\" rel=\"stylesheet\" type=\"text/css\" ></link>");
        ret.append("<script type=\"text/javascript\" src=\""+SWBPortal.getContextPath()+"/swbadmin/js/dojo/dojo/dojo.js\"></script>");
        ret.append("<script type=\"text/javascript\" src=\""+SWBPortal.getContextPath()+"/swbadmin/js/swb.js\"></script>");
        ret.append("<script type=\"text/javascript\" src=\""+SWBPortal.getWebWorkPath()+"/models/"+base.getWebSiteId()+"/css/pymestur.js\"></script>");
        ret.append("<link rel='stylesheet' type='text/css' media='all' href='"+SWBPortal.getContextPath()+"/swbadmin/js/dojo/dijit/themes/soria/soria.css'></link>");
        ret.append("<script type=\"text/javascript\">");
        ret.append("        var djConfig = {");
        ret.append("            parseOnLoad: true,");
        ret.append("            isDebug: false,");
        ret.append("            locale: 'en-us',");
        ret.append("            extraLocale: ['ja-jp']");
        ret.append("        };");
        ret.append("</script>");
        ret.append("<script type=\"text/javascript\" >");
        ret.append("    dojo.require(\"dijit.form.Form\");");
        ret.append("    dojo.require(\"dijit.form.Button\");");
        ret.append("</script>");
        ret.append("</head>");
        ret.append("<body class=\"soria\">");

        ret.append("\n <div class=\"photoAdminWrapper\">");
        ret.append("\n<div class=\"swbform\"> ");
        ret.append("<h2>Administraci&oacute;n de im&aacute;genes</h2>");
        ret.append("\n<form id=\"frm_pa_"+base.getId()+"\" name=\"frm_pa_"+base.getId()+"\" method=\"post\" enctype=\"multipart/form-data\" action=\""+url+"\"> ");

        if(userCanAdd(paramRequest, sprovider)) {
            ret.append("\n <div class=\"btnAddPhotoAdmin\">");
            ret.append("\n    <input type=\"button\" value=\"Agregar\" onclick=\"addRowToTable_"+base.getId()+"('igtbl_"+base.getId()+"');\" /> ");
            ret.append("\n    <input type=\"button\" value=\"Cancelar\" onclick=\"removeRowFromTable('igtbl_"+base.getId()+"');\" /> ");
            ret.append("\n </div>");
        }
        ret.append("\n  <table id=\"igtbl_"+base.getId()+"\" width=\"99%\" cellspacing=\"1\" align=\"center\"> ");
        ret.append("\n  <caption>Lista de im&aacute;genes <span class=\"italic\">(bmp, jpg, jpeg, gif, png)</span></caption>");
        ret.append("\n  <tr> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" width=\"10\" height=\"20\" nowrap=\"nowrap\">&nbsp;</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" width=\"20\" height=\"20\" nowrap=\"nowrap\">Editar</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" width=\"30\" height=\"20\" nowrap=\"nowrap\">Eliminar</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" width=\"40%\" height=\"20\" nowrap=\"nowrap\">Archivo</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" width=\"40%\" height=\"20\" nowrap=\"nowrap\">Imagen</th> ");
        ret.append("\n  </tr> ");
        ret.append("\n  </table> ");
        ret.append("\n <div class=\"btnPhotoAdmin\">");
        ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submitImgGal\" value=\"Submit\" >Guardar</button>&nbsp;");
        ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"reset\">Limpiar</button>&nbsp;");
        ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"exit\" value=\"exit\" >Salir</button>");
        ret.append("\n </div>");
        ret.append("\n</form>  ");
        ret.append("\n</div>  ");
        ret.append("\n</div>  ");

        ret.append("\n<script type=\"text/javascript\"> ");
        ret.append("\nfunction addRowToTable_"+base.getId()+"(tblId, filename, img, cellSufix) { ");
        ret.append("\n    var tbl = document.getElementById(tblId); ");
        ret.append("\n    var lastRow = tbl.rows.length; ");
        ret.append("\n    var iteration = lastRow-1; // descontar el renglon de titulo ");
        ret.append("\n    var row = tbl.insertRow(lastRow); ");
        ret.append("\n ");
        ret.append("\n    // celda folio ");
        ret.append("\n    var folioCell = row.insertCell(0); ");
        ret.append("\n    folioCell.style.textAlign = 'right'; ");
        ret.append("\n    var folioTextNode = document.createTextNode(iteration); ");
        ret.append("\n    folioCell.appendChild(folioTextNode); ");
        ret.append("\n ");
        ret.append("\n    // cell check edit ");
        ret.append("\n    var editCheckCell = row.insertCell(1); ");
        ret.append("\n    editCheckCell.style.textAlign = 'center'; ");
        ret.append("\n    var editCheckInput = document.createElement('input'); ");
        ret.append("\n    editCheckInput.type = 'checkbox'; ");
        ret.append("\n    if(cellSufix) { ");
        ret.append("\n        editCheckInput.name = 'edit'; ");
        ret.append("\n        editCheckInput.id = 'edit_'+cellSufix; ");
        ret.append("\n        editCheckInput.value = cellSufix; ");
        ret.append("\n    }else { ");
        ret.append("\n        editCheckInput.name = 'edit_"+base.getId()+"_'+iteration; ");
        ret.append("\n        editCheckInput.id = 'edit_"+base.getId()+"_'+iteration; ");
        ret.append("\n    }");
        ret.append("\n    editCheckInput.alt = 'Marcar para editar esta imagen'; ");
        ret.append("\n    editCheckInput.disabled = true; ");
        ret.append("\n    editCheckInput.onclick = function(){ ");
        ret.append("\n        if(editCheckInput.checked) { ");
        ret.append("\n            row.cells[row.cells.length-1].innerHTML = '<input type=\"file\" id=\"imggallery_"+base.getId()+"_'+iteration+'\" name=\"imggallery_"+base.getId()+"_'+iteration+'\" size=\"40\" />'; ");
        ret.append("\n        } ");
        ret.append("\n    }; ");
        ret.append("\n    editCheckCell.appendChild(editCheckInput); ");
        ret.append("\n ");
        ret.append("\n    // cell check remove ");
        ret.append("\n    var removeCheckCell = row.insertCell(2); ");
        ret.append("\n    removeCheckCell.style.textAlign = 'center'; ");
        ret.append("\n    var removeCheckInput = document.createElement('input'); ");
        ret.append("\n    removeCheckInput.type = 'checkbox'; ");
        ret.append("\n    if(cellSufix) { ");
        ret.append("\n        removeCheckInput.name = 'remove'; ");
        ret.append("\n        removeCheckInput.id = 'remove_'+cellSufix; ");
        ret.append("\n        removeCheckInput.value = cellSufix; ");
        ret.append("\n    }else { ");
        ret.append("\n        removeCheckInput.name = 'remove_"+base.getId()+"_'+iteration; ");
        ret.append("\n        removeCheckInput.id = 'remove_"+base.getId()+"_'+iteration; ");
        ret.append("\n    }");
        ret.append("\n    removeCheckInput.alt = 'Marcar para eliminar esta imagen'; ");
        ret.append("\n    if(filename && img) { ");
        ret.append("\n        removeCheckInput.disabled = false; ");
        ret.append("\n    }else { ");
        ret.append("\n        removeCheckInput.disabled = true; ");
        ret.append("\n    } ");
        ret.append("\n    removeCheckCell.appendChild(removeCheckInput); ");
        ret.append("\n ");
        ret.append("\n    // celda nombre de archivo ");
        ret.append("\n    var filenameCell = row.insertCell(3); ");
        ret.append("\n    if(filename) { ");
        ret.append("\n        var fnTxt = document.createTextNode(filename); ");
        ret.append("\n        filenameCell.appendChild(fnTxt); ");
        ret.append("\n    } ");
        ret.append("\n    filenameCell.style.textAlign = 'left'; ");
        ret.append("\n ");
        ret.append("\n    // celda input file ");
        ret.append("\n    var imgCell = row.insertCell(4); ");
        ret.append("\n    if(img) { ");
        ret.append("\n        imgCell.style.textAlign = 'center'; ");
        ret.append("\n        imgCell.innerHTML = img; ");
        ret.append("\n            editCheckInput.disabled = false; ");
        ret.append("\n    }else { ");
        ret.append("\n        // file uploader ");
        ret.append("\n        imgCell.style.textAlign = 'left'; ");
        ret.append("\n        var fileInput = document.createElement('input'); ");
        ret.append("\n        fileInput.type = 'file'; ");
        ret.append("\n        fileInput.name = 'imggallery_"+base.getId()+"_'+iteration; ");
        ret.append("\n        fileInput.id = 'imggallery_"+base.getId()+"_'+iteration; ");
        ret.append("\n        fileInput.size = 40; ");
        ret.append("\n        imgCell.appendChild(fileInput); ");
        ret.append("\n    } ");
        ret.append("\n} ");

        ret.append("\nfunction removeRowFromTable(tblId) { ");
        ret.append("    var tbl = document.getElementById(tblId); ");
        ret.append("    var lastRow = tbl.rows.length; ");
        ret.append("    if(lastRow > 2) { ");
        ret.append("        tbl.deleteRow(lastRow - 1); ");
        ret.append("    } ");
        ret.append("}\n");

        final String path = sprovider.getWorkPath()+"/photos/"+base.getAttribute("gpophotos")+"/";
        Iterator<PymePhoto> it = null;
        if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
            it = sprovider.listEstablishmentPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
            it = sprovider.listInstalationsPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
            it = sprovider.listMorePymePhotos();
        }
        while(it.hasNext()) {
            PymePhoto pp = it.next();
            String img = "<img src=\""+SWBPortal.getWebWorkPath()+path+pp.getPhotoThumbnail()+"\" alt=\""+pp.getPhotoImage()+"\" />";
            ret.append("addRowToTable_"+base.getId()+"('igtbl_"+base.getId()+"', '"+pp.getPhotoImage()+"', '"+img+"', '"+pp.getId()+"'); \n");
        }
        ret.append("\n</script>");
        
        ret.append("</body>");
        ret.append("</html>");
        return ret.toString();
    }

    private void add(HttpServletRequest request, ServiceProvider sprovider) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        File sprovDir = new File(SWBPortal.getWorkPath()+sprovider.getWorkPath());
        if( !sprovDir.exists() )
            sprovDir.mkdir();
        sprovDir = new File(SWBPortal.getWorkPath()+sprovider.getWorkPath()+"/photos/");
        if( !sprovDir.exists() )
            sprovDir.mkdir();
        sprovDir = new File(SWBPortal.getWorkPath()+sprovider.getWorkPath()+"/photos/"+base.getAttribute("gpophotos")+"/");
        if( !sprovDir.exists() )
            sprovDir.mkdir();

        int width;
        try {
            width = Integer.parseInt(base.getAttribute("width","640"));
        }catch(NumberFormatException nfe) {
            width = 640;
        }
        int height;
        try {
            height = Integer.parseInt(base.getAttribute("height","480"));
        }catch(NumberFormatException nfe) {
            height = 480;
        }
        int thnWidth;
        try {
            thnWidth = Integer.parseInt(base.getAttribute("thnwidth","82"));
        }catch(NumberFormatException nfe) {
            thnWidth = 82;
        }
        int thnHeight;
        try {
            thnHeight = Integer.parseInt(base.getAttribute("thnheight","82"));
        }catch(NumberFormatException nfe) {
            thnHeight = 82;
        }

        final String fspath = SWBPortal.getWorkPath()+sprovider.getWorkPath()+"/photos/"+base.getAttribute("gpophotos")+"/";

        try
        {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart)
            {
                File tmpwrk = new File(SWBPortal.getWorkPath() + "/tmp");
                if (!tmpwrk.exists())
                {
                    tmpwrk.mkdirs();
                }
                FileItemFactory factory = new DiskFileItemFactory(1 * 1024 * 1024, tmpwrk);
                ServletFileUpload upload = new ServletFileUpload(factory);
                ProgressListener progressListener = new ProgressListener()
                {

                    private long kBytes = -1;

                    public void update(long pBytesRead, long pContentLength, int pItems)
                    {
                        long mBytes = pBytesRead / 10000;
                        if (kBytes == mBytes)
                        {
                            return;
                        }
                        kBytes = mBytes;
                        int percent = (int) (pBytesRead * 100 / pContentLength);
                    }
                };
                upload.setProgressListener(progressListener);
                List items = upload.parseRequest(request); /* FileItem */
                Iterator iter = items.iterator();
                while (iter.hasNext())
                {
                    FileItem item = (FileItem) iter.next();

                    if( item.isFormField() ) {
                        String action = item.getFieldName();
                        String value = item.getString();
                        PymePhoto pp = PymePhoto.ClassMgr.getPymePhoto(value, sprovider.getWebPage().getWebSite());
                        if(pp!=null) {
                            if("remove".equalsIgnoreCase(action) || "edit".equalsIgnoreCase(action)) {
                                if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
                                    try {
                                        File f = new File(fspath+pp.getPhotoImage());
                                        f.delete();
                                        f = new File(fspath+_thumbnail+pp.getPhotoImage());
                                        f.delete();
                                        sprovider.removeEstablishmentPymePhoto(pp);
                                        sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()-1);
                                        pp.remove();
                                    }catch(Exception e) {
                                        log.error("Error while deletting file in resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), e);
                                    }
                                }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
                                    try {
                                        File f = new File(fspath+pp.getPhotoImage());
                                        f.delete();
                                        f = new File(fspath+_thumbnail+pp.getPhotoImage());
                                        f.delete();
                                        sprovider.removeInstalationsPymePhoto(pp);
                                        sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()-1);
                                        pp.remove();
                                    }catch(Exception e) {
                                        log.error("Error while deletting file in resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), e);
                                    }
                                }else if(base.getAttribute("gpophotos").equalsIgnoreCase("category")) {
                                    try {
                                        File f = new File(fspath+pp.getPhotoImage());
                                        f.delete();
                                        f = new File(fspath+_thumbnail+pp.getPhotoImage());
                                        f.delete();
                                        sprovider.removeSpCategoryPymePhoto(pp);
                                        sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()-1);
                                        pp.remove();
                                    }catch(Exception e) {
                                        log.error("Error while deletting file in resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), e);
                                    }
                                }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
                                    try {
                                        File f = new File(fspath+pp.getPhotoImage());
                                        f.delete();
                                        f = new File(fspath+_thumbnail+pp.getPhotoImage());
                                        f.delete();
                                        sprovider.removeMorePymePhoto(pp);
                                        sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()-1);
                                        pp.remove();
                                    }catch(Exception e) {
                                        log.error("Error while deletting file in resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), e);
                                    }
                                }
                            }
                        }
                    }else {
                        if( item.getSize()==0 )
                            continue;                        
                        long serial = (new Date()).getTime();
                        String filename;// = serial + "_" + item.getFieldName() + item.getName().substring(item.getName().lastIndexOf("."));
                        try {
                            filename = serial + "_" + item.getFieldName() + item.getName().substring(item.getName().lastIndexOf("."));
                        }catch (StringIndexOutOfBoundsException iobe) {
                            continue;
                        }

                        File image = new File(fspath + filename);
                        File shrink = new File(fspath +"_"+ filename);
                        boolean shrinked = false;
                        try {
                            item.write(image);
                            shrinked = ImageResizer.shrinkTo(image, width, height, shrink, "jpeg");
                        }catch(Exception e) {
                            log.error("Error while writting file in resource instance PhotoAlbumSheet with id: "+base.getId() +"-"+ base.getTitle(), e);
                        }
                        File thumbnail = new File(fspath + "thumbn_" + filename);
                        try {
                            ImageResizer.shrinkTo(image, thnWidth, thnHeight, thumbnail, "jpeg");
                        }catch(IOException e) {
                            log.error("Error while writting thumbnail in resource instance PhotoAlbumSheet with id: "+base.getId() +"-"+ base.getTitle(), e);
                        }
                        if(shrinked) {
                            image.delete();
                            shrink.renameTo(image);
                            image = shrink;
                        }

                        PymePhoto pp = PymePhoto.ClassMgr.createPymePhoto(sprovider.getWebPage().getWebSite());
                        pp.setPhotoImage(filename);
                        pp.setPhotoThumbnail(_thumbnail+filename);
                        pp.setPhotoSize(SWBUtils.IO.getFileSize(image));
                        if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
                            sprovider.addEstablishmentPymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
                            sprovider.addInstalationsPymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("category")) {
                            sprovider.addSpCategoryPymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
                            sprovider.addMorePymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        }
                    }
                }
            }
        }catch (Exception ex)
        {
            log.error("Error while adding attributos to resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), ex);
            ex.printStackTrace();
        }
    }

    private void renderResourceForSheet(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, ServiceProvider sprovider) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        Iterator<PymePhoto> it = null;
        if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
            it = sprovider.listEstablishmentPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
            it = sprovider.listInstalationsPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
            it = sprovider.listMorePymePhotos();
        }
        ArrayList<String> photos = new ArrayList<String>();
        while(it.hasNext()) {
            PymePhoto pp = it.next();
            photos.add(pp.getPhotoImage());
        }

        final String path = sprovider.getWorkPath()+"/photos/"+base.getAttribute("gpophotos")+"/";
        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
            int nde;
            try {
                nde = Integer.parseInt(base.getAttribute("maxpreview", "6"));
            }catch(NumberFormatException nfe) {
                nde = 6;
            }
            out.println("<div id=\"photosFrame\">");
            for(int i=0; i<nde && i<photos.size(); i++) {
                String image = photos.get(i);
                out.println("<span class=\"marco\">");
                out.println("<a href=\"#\" id=\""+"pa_"+i+"_"+base.getId()+"\">");
                out.println("<img alt=\""+image+"\" src=\""+SWBPortal.getWebWorkPath()+path+_thumbnail+image+"\" />");
                out.println("</a>");
                out.println("</span>");
            }
            out.println("</div>");
            
            out.println("<script type=\"text/javascript\">");
            out.println("dojo.require(\"dojox.image.Lightbox\");");
            out.println("dojo.addOnLoad(function(){");
            for(int i=0; i<nde && i<photos.size(); i++) {
                String image = photos.get(i);
                out.println("var lbs_"+i+"_"+base.getId()+" = new dojox.image.Lightbox({ title:'', href:'"+SWBPortal.getWebWorkPath()+path+image+"', group:'group"+base.getId()+"' }, 'pa_"+i+"_"+base.getId()+"');");
                out.println("lbs_"+i+"_"+base.getId()+".startup();");
            }

//            out.println("var dialog = new dojox.image.LightboxDialog({});");
//            for(int i=0; i<nde && i<photos.size(); i++) {
//                out.println("dialog.addImage( lb_"+i+", 'group2' );");
//            }
//            out.println("        dialog.startup();");
            out.println("    });");

//            out.println("    function showdialog() {");
//            out.println("        var dialog = dijit.byId('dojoxLightboxDialog');");
//            out.println("        dialog.show( { group:'group2'} );");
//            out.println("    }");
            out.println("</script>");

            User user=paramRequest.getUser();
            if(user.getURI()!=null && sprovider.getCreator().getURI().equals(user.getURI())) {
                SWBResourceURL url = paramRequest.getRenderUrl();
                url.setCallMethod(paramRequest.Call_DIRECT);
                url.setParameter("uri", sprovider.getURI());
                url.setParameter("showAdmPhotos", "true");
                out.println("<div id=\"photosFrameAdm\"><a href=\""+url+"\" class=\"ligaCol2\">Agregar fotos</a></div>");
            }
        }else {
            boolean show = Boolean.parseBoolean(request.getParameter("showAdmPhotos"));
            User user=paramRequest.getUser();
            if( show && (user.getURI()!=null && sprovider.getCreator().getURI().equals(user.getURI()) || userCanEdit(user)) )
                out.print(getFormManager(paramRequest, sprovider));
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();
        if( response.Action_ADD.equals(action) ) {
            if(request.getParameter("uri")!=null) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                ServiceProvider sprovider = (ServiceProvider) semObject.createGenericInstance();
                if( sprovider!=null ) {
                    add(request, sprovider);
                }
                response.sendRedirect(response.getWebPage().getUrl()+"?act=detail&uri="+sprovider.getEncodedURI());
            }
        }
    }

    private boolean userCanAdd(SWBParamRequest paramRequest, ServiceProvider sprovider) {
        boolean canAdd = false;
        int topPhotos = sprovider.getSpTotPhotos();
        int packageType = sprovider.getPymePaqueteType();
        int numMaxPhotos = Paquete.ClassMgr.getPaquete(Integer.toString(packageType), paramRequest.getWebPage().getWebSite()).getPaq_NumMaxPhotos();
        if(topPhotos<numMaxPhotos)
            canAdd = true;
        return canAdd;
    }

    private boolean userCanEdit(final User user) {
        boolean access = false;
        Role superAdm = user.getUserRepository().getRole("superAdmProviders");
        if( user.hasRole(superAdm) ) {
            access = true;
        }
//        boolean access = false;
//
//        String roleName = getResourceBase().getAttribute("editRole");
//        if( user!=null && roleName!=null ) {
//            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
//            GenericObject gobj = null;
//            gobj = ont.getGenericObject(roleName);
//
//            if( gobj!=null ) {
//                UserGroup ugrp = null;
//                Role urole = null;
//
//                if(gobj instanceof UserGroup) {
//                    ugrp = (UserGroup) gobj;
//                    if(user.hasUserGroup(ugrp)) {
//                        access = true;
//                    }
//                }else if(gobj instanceof Role) {
//                    urole = (Role) gobj;
//                    if(user.hasRole(urole)) {
//                        access = true;
//                    }
//                }
//            }
//        }
        return access ;
    }
}