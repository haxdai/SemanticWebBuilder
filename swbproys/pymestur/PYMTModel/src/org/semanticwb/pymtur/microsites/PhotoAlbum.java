package org.semanticwb.pymtur.microsites;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;

import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.pymtur.PymePhoto;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.model.Role;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.community.MicroSiteType;
import org.semanticwb.portal.community.MicroSiteWebPageUtil;
import org.semanticwb.pymtur.Paquete;

/**
 *
 * @author carlos.ramos
 */

public final class PhotoAlbum extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(PhotoAlbum.class);

    private static final String _thumbnail = "thumbn_";
    private static int maxPictPreview = 6;
    private static long maxSizeAcceptedByPict = 4194304L; //bits

    public PhotoAlbum() {
        super();
    }

    public PhotoAlbum(Resource base) {
        super();
        setResourceBase(base);
    }

    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            try {
                maxSizeAcceptedByPict = Long.parseLong(base.getAttribute("size","4194304L"));
            }catch(NumberFormatException nfe) {
                maxSizeAcceptedByPict = 4194304L;
            }
            try {
                maxPictPreview = Integer.parseInt(base.getAttribute("maxpreview","6"));
            }catch(NumberFormatException nfe) {
                maxPictPreview = 6;
            }
        }catch(Exception e) {            
            log.error("PyMES. Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);
        }


    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        ServiceProvider sprovider = null;
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;
        
        if(wp instanceof MicroSitePyme) {
            community = wp;
        }else {
            community = wp.getParent();
        }
        MicroSitePyme ms = (MicroSitePyme)community;
        sprovider = ms.getServiceProvider();
//        String siteUri = ((MicroSitePyme) community).getType().getURI();

//        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri))
//            renderResourceForMiPyme(request, response, paramRequest, sprovider);
//        else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri))
            display(request, response, paramRequest, sprovider);
    }

    private String getFormManager(SWBParamRequest paramRequest, ServiceProvider sprovider) {

        Resource base = getResourceBase();
        StringBuilder html = new StringBuilder();
        final int numMaxPhotos = Paquete.ClassMgr.getPaquete(Integer.toString(sprovider.getPymePaqueteType()),
                paramRequest.getWebPage().getWebSite()).getPaq_NumMaxPhotos();

        html.append("<script type=\"text/javascript\">\n");
        html.append("<!--\n");
        html.append("  var opened_"+base.getId()+"=0;\n");
        html.append("  loaded = " + sprovider.getSpTotPhotos() + ";\n");
        html.append("  limit = " + numMaxPhotos + ";\n");
        html.append("  var loadedIn" + base.getId() + " = 0;\n");
        html.append("-->\n");
        html.append("</script>\n");
        
        SWBResourceURL url = paramRequest.getActionUrl();
        url.setAction(paramRequest.Action_ADD+"_"+base.getAttribute("gpophotos"));
        url.setParameter("uri", sprovider.getURI());

        html.append("<div class=\"photoAdminWrapper\">\n");
        html.append("  <a href=\"#\" id=\"showadm_"+base.getId()+"\" onclick=\"if(opened_"+base.getId()+"==1){collapse('admPhotoAlbum_"+base.getId()+"',250,150);this.innerHTML='Editar';z_"+base.getId()+"();opened_"+base.getId()+"=0;}else{a_"+base.getId()+"();expande('admPhotoAlbum_"+base.getId()+"',250,150);this.style.display='none';opened_"+base.getId()+"=1;}\">Editar</a>\n");
        html.append("  <div class=\"swbform\" id=\"admPhotoAlbum_"+base.getId()+"\" >\n");
        html.append("  <h2>Administraci&oacute;n de im&aacute;genes</h2>\n");

        html.append("  <form id=\"frm_pa_"+base.getId()+"\" name=\"frm_pa_"+base.getId()+"\" method=\"post\" enctype=\"multipart/form-data\" action=\""+ url+"\">\n");
//        if(userCanAdd(paramRequest.getWebPage().getWebSite(), sprovider)) {
//            html.append("\n <div class=\"btnAddPhotoAdmin\">");
//            html.append("\n    <input type=\"button\" value=\"Agregar\" onclick=\"addRowToTable_"+base.getId()+"('igtbl_"+base.getId()+"'); this.disabled=true; this.form.cancel.disabled=false;\" name=\"add\" /> ");
//            html.append("\n    <input type=\"button\" value=\"Cancelar\" onclick=\"removeRowFromTable('igtbl_"+base.getId()+"'); this.disabled=true; this.form.add.disabled=false;\" name=\"cancel\" disabled=\"disabled\" /> ");
//            html.append("\n </div>");
//        }
        html.append("\n  <table id=\"igtbl_"+base.getId()+"\" width=\"99%\" cellspacing=\"1\" align=\"center\"> ");
        html.append("\n  <caption>Lista de im&aacute;genes <span class=\"italic\">"+(base.getAttribute("fileformat")==null?"Sin formato definido":Arrays.toString(base.getAttribute("fileformat").split(",")))+"</span></caption>");
        html.append("\n  <tr> ");
        html.append("\n    <th align=\"center\" scope=\"col\" width=\"20\" height=\"20\" nowrap=\"nowrap\">&nbsp;</th> ");
        html.append("\n    <th align=\"center\" scope=\"col\" height=\"20\" nowrap=\"nowrap\">Editar</th> ");
        html.append("\n    <th align=\"center\" scope=\"col\" height=\"20\" nowrap=\"nowrap\">Eliminar</th> ");
        html.append("\n    <th align=\"center\" scope=\"col\" width=\"40%\" height=\"20\" nowrap=\"nowrap\">Archivo</th> ");
        html.append("\n    <th align=\"center\" scope=\"col\" width=\"40%\" height=\"20\" nowrap=\"nowrap\">Imagen</th> ");
        html.append("\n  </tr> ");
        html.append("\n  </table> ");

        html.append("\n <div class=\"btnPhotoAdmin\">");
        html.append("\n    <input type=\"button\" value=\"Agregar\" onclick=\"addRowToTable_"+base.getId()+"('igtbl_"+base.getId()+"');this.disabled=true;\" name=\"add\" id=\"add_"+base.getId()+"\" /> ");
//        html.append("\n    <input type=\"button\" value=\"Cancelar\" onclick=\"removeRowFromTable('igtbl_"+base.getId()+"'); this.disabled=true; this.form.add.disabled=false;\" name=\"cancel\" disabled=\"disabled\" /> ");
        html.append("\n    <input type=\"button\" value=\"Cancelar\" onclick=\"collapse('admPhotoAlbum_"+base.getId()+"',250,150);loaded-=loadedIn" + base.getId() + ";dojo.byId('showadm_"+base.getId()+"').style.display='block';dojo.byId('add_"+base.getId()+"').disabled=false;z_"+base.getId()+"();opened_"+base.getId()+"=0;\" name=\"cancel\" /> ");  //z();
        html.append("\n    <input type=\"submit\" dojo_Type=\"dijit.form.Button\" name=\"submitImgGal\" value=\"Guardar\" />&nbsp;");
//      html.append("\n    <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submitImgGal\" value=\"Submit\" >Guardar</button>&nbsp;");
//        html.append("\n <button dojoType=\"dijit.form.Button\" type=\"reset\">Restablecer</button>");
        html.append("\n </div>");
        html.append("\n</form>  ");
        html.append("\n</div>  ");
        html.append("\n </div>");
        
        html.append("\n<script type=\"text/javascript\">\n");
        html.append("<!--\n");
        html.append("dojo.addOnLoad(function(){collapse('admPhotoAlbum_"+base.getId()+"',0,0)});");

        html.append("\nfunction addRowToTable_"+base.getId()+"(tblId, filename, img, cellSufix) { ");
        html.append("\n    if (img || (!img && loaded < limit)) {");
        html.append("\n        var tbl = document.getElementById(tblId); ");
        html.append("\n        var lastRow = tbl.rows.length; ");
        html.append("\n        var iteration = lastRow; // descontar el renglon de titulo ");
        html.append("\n        var row = tbl.insertRow(lastRow); ");
        
        html.append("\n        // celda folio ");
        html.append("\n        var folioCell = row.insertCell(0); ");
        html.append("\n        folioCell.style.textAlign = 'right'; ");
        html.append("\n        var folioTextNode = document.createTextNode(iteration); ");
        html.append("\n        folioCell.appendChild(folioTextNode); ");
        
        html.append("\n        // cell check edit ");
        html.append("\n        var editCheckCell = row.insertCell(1); ");
        html.append("\n        editCheckCell.style.textAlign = 'center'; ");
        html.append("\n        var editCheckInput = document.createElement('input'); ");
        html.append("\n        editCheckInput.type = 'checkbox'; ");
        html.append("\n        if (cellSufix) { ");
        html.append("\n            editCheckInput.name = 'edit'; ");
        html.append("\n            editCheckInput.id = 'edit_'+cellSufix; ");
        html.append("\n            editCheckInput.value = cellSufix; ");
        html.append("\n        } else { ");
        html.append("\n            editCheckInput.name = 'edit_"+base.getId()+"_'+iteration; ");
        html.append("\n            editCheckInput.id = 'edit_"+base.getId()+"_'+iteration; ");
        html.append("\n        }");
        html.append("\n        editCheckInput.alt = 'Marcar para editar esta imagen'; ");
        html.append("\n        editCheckInput.disabled = true; ");
        html.append("\n        editCheckInput.onclick = function() { ");
        html.append("\n            if (editCheckInput.checked) { ");
        html.append("\n                row.cells[row.cells.length-1].innerHTML = '<input type=\"file\" id=\"imggallery_"+base.getId()+"_'+iteration+'\" name=\"imggallery_"+base.getId()+"_'+iteration+'\" size=\"40\" />'; ");
        html.append("\n            } ");
        html.append("\n        }; ");
        html.append("\n        editCheckCell.appendChild(editCheckInput); ");

        html.append("\n        // cell check remove ");
        html.append("\n        var removeCheckCell = row.insertCell(2); ");
        html.append("\n        removeCheckCell.style.textAlign = 'center'; ");
        html.append("\n        var removeCheckInput = document.createElement('input'); ");
        html.append("\n        removeCheckInput.type = 'checkbox'; ");
        html.append("\n        if (cellSufix) { ");
        html.append("\n            removeCheckInput.name = 'remove'; ");
        html.append("\n            removeCheckInput.id = 'remove_'+cellSufix; ");
        html.append("\n            removeCheckInput.value = cellSufix; ");
        html.append("\n        } else { ");
        html.append("\n            removeCheckInput.name = 'remove_"+base.getId()+"_'+iteration; ");
        html.append("\n            removeCheckInput.id = 'remove_"+base.getId()+"_'+iteration; ");
        html.append("\n        }");
        html.append("\n        removeCheckInput.alt = 'Marcar para eliminar esta imagen'; ");
        html.append("\n        if (filename && img) { ");
        html.append("\n            removeCheckInput.disabled = false; ");
        html.append("\n        } else { ");
        html.append("\n            removeCheckInput.disabled = true; ");
        html.append("\n        } ");
        html.append("\n        removeCheckCell.appendChild(removeCheckInput); ");
        html.append("\n     ");
        html.append("\n        // celda nombre de archivo ");
        html.append("\n        var filenameCell = row.insertCell(3); ");
        html.append("\n        if (filename) { ");
        html.append("\n            var fnTxt = document.createTextNode(filename); ");
        html.append("\n            filenameCell.appendChild(fnTxt); ");
        html.append("\n        } ");
        html.append("\n        filenameCell.style.textAlign = 'left'; ");

        html.append("\n        // celda input file ");
        html.append("\n        var imgCell = row.insertCell(4); ");
        html.append("\n        if (img) { ");
        html.append("\n            imgCell.style.textAlign = 'center'; ");
        html.append("\n            imgCell.innerHTML = img; ");
        html.append("\n            editCheckInput.disabled = false; ");
        html.append("\n        } else { ");
        html.append("\n            // file uploader ");
        html.append("\n            imgCell.style.textAlign = 'left'; ");
        html.append("\n            var fileInput = document.createElement('input'); ");
        html.append("\n            fileInput.type = 'file'; ");
        html.append("\n            fileInput.name = 'imggallery_"+base.getId()+"_'+iteration; ");
        html.append("\n            fileInput.id = 'imggallery_"+base.getId()+"_'+iteration; ");
        //html.append("\n        fileInput.size = 40; ");
        html.append("\n            fileInput.onchange = function() {");
        html.append("\n                if (this.value != undefined && this.value != \"\") {");
        html.append("\n                    var fileName = \"\";");
        html.append("\n                    if (this.value.lastIndexOf(\"\\\\\") > -1) {");
        html.append("\n                        fileName = this.value.substring(this.value.lastIndexOf(\"\\\\\") + 1);");
        html.append("\n                    } else {");
        html.append("\n                        fileName = this.value");
        html.append("\n                    } ");
        html.append("\n                ");
        html.append("\n                    if (fileName.indexOf(\" \") > -1) {");
        html.append("\n                        alert(\"El nombre del archivo a cargar no debe contener espacios en blanco.\")");
        html.append("\n                        this.form.add.disabled = true;");
        html.append("\n                        this.value = \"\";");
        html.append("\n                    } else {");
        html.append("\n                        this.form.add.disabled = false;");
        html.append("\n                    }");
        html.append("\n                }");
        html.append("\n            }");
        html.append("\n            imgCell.appendChild(fileInput); ");
        html.append("\n            loaded++;");
        html.append("\n            loadedIn" + base.getId() + "++;");
        html.append("\n        } ");
        html.append("\n    } else if (!img && loaded >= limit) { //cierre de validacion para agregar archivos");
        html.append("\n        alert(\"Se ha llegado al límite de fotografías que se pueden cargar.\");");
        html.append("\n    } ");
        html.append("\n} ");

        html.append("\nfunction removeRowFromTable(tblId) {\n");
        html.append("    var tbl = document.getElementById(tblId);\n");
//        html.append("    var lastRow = tbl.rows.length;\n");
//        html.append("    if(lastRow >= 2) {\n");
//        html.append("        tbl.deleteRow(lastRow - 1);\n");
//        html.append("    }\n"); 
        html.append("while(tbl.rows.length>1) \n");
        html.append("  tbl.deleteRow(tbl.rows.length-1);\n");
        html.append("}\n");
//        html.append("\nfunction checkForBlanks(inputElement) {");
//        html.append("\n    if (inputElement.value != undefined && inputElement.value != \"\") {");
//        html.append("\n        var fileName = \"\";");
//        html.append("\n        if (inputElement.value.lastIndexOf(\"\\\\\") > -1) {");
//        html.append("\n            fileName = inputElement.value.substring(inputElement.value.lastIndexOf(\"\\\\\") + 1);");
//        html.append("\n        } else {");
//        html.append("\n            fileName = inputElement.value");
//        html.append("\n        } ");
//        html.append("\n        ");
//        html.append("\n        if (fileName.indexOf(\" \") > -1) {");
//        html.append("\n            alert(\"El nombre del archivo a cargar no debe contener espacios en blanco.\")");
//        html.append("\n            inputElement.form.add.disabled = true;");
//        html.append("\n            inputElement.value = \"\";");
//        html.append("\n        } else {");
//        html.append("\n            inputElement.form.add.disabled = false;");
//        html.append("\n        }");
//        html.append("\n    }");
//        html.append("}\n");
        
        final String path = sprovider.getWorkPath()+"/photos/"+base.getAttribute("gpophotos")+"/";
        Iterator<PymePhoto> it = null;
        if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
            it = sprovider.listEstablishmentPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
            it = sprovider.listInstalationsPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("category")) {
            it = sprovider.listSpCategoryPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
            it = sprovider.listMorePymePhotos();
        }
        
        html.append("function a_"+base.getId()+"() {\n");
        while(it.hasNext()) {
            PymePhoto pp = it.next();
            String img = "<img src=\""+SWBPortal.getWebWorkPath()+path+pp.getPhotoThumbnail()+"\" alt=\""+pp.getPhotoImage()+"\" />";
            html.append("addRowToTable_"+base.getId()+"('igtbl_"+base.getId()+"', '"+pp.getPhotoImage()+"', '"+img+"', '"+pp.getId()+"');\n");
        }
        html.append("}\n");
        
        html.append("function z_"+base.getId()+"() {\n");
        html.append("  removeRowFromTable('igtbl_"+base.getId()+"');\n");
        html.append("}\n");
        html.append("-->\n");
        html.append("</script>\n");

        return html.toString();
    }

    private void add(HttpServletRequest request, ServiceProvider sprovider,
            WebSite model) throws SWBResourceException, IOException {

        Resource base = getResourceBase();
        File sprovDir = new File(SWBPortal.getWorkPath()+sprovider.getWorkPath());
        StringBuilder msg = new StringBuilder(16);

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

        String[] fileFormats = base.getAttribute("fileformat") == null ? new String[] {""} : base.getAttribute("fileformat").toLowerCase().split(",");
        Arrays.sort(fileFormats);
        try {
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                File tmpwrk = new File(SWBPortal.getWorkPath() + "/tmp");
                if (!tmpwrk.exists()) {
                    tmpwrk.mkdirs();
                }
                FileItemFactory factory = new DiskFileItemFactory(1 * 1024 * 1024, tmpwrk);
                ServletFileUpload upload = new ServletFileUpload(factory);
                ProgressListener progressListener = new ProgressListener() {
                    private long kBytes = -1;
                    public void update(long pBytesRead, long pContentLength, int pItems) {
                        long mBytes = pBytesRead / 10000;
                        if (kBytes == mBytes) {
                            return;
                        }
                        kBytes = mBytes;
                        int percent = (int) (pBytesRead * 100 / pContentLength);
                    }
                };
                upload.setProgressListener(progressListener);
                List items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (item.isFormField()) {
                        String action = item.getFieldName();
                        String value = item.getString();
                        PymePhoto pp = PymePhoto.ClassMgr.getPymePhoto(value, sprovider.getWebPage().getWebSite());
                        if (pp != null) {
                            if ("remove".equalsIgnoreCase(action) || "edit".equalsIgnoreCase(action)) {
                                if (base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
                                    try {
                                        File f = new File(fspath+pp.getPhotoImage());
                                        f.delete();
                                        f = new File(fspath+_thumbnail+pp.getPhotoImage());
                                        f.delete();
                                        sprovider.removeEstablishmentPymePhoto(pp);
                                        sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()-1);
                                        pp.remove();
                                    } catch (Exception e) {
                                        log.error("Error while deletting file in resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), e);
                                    }
                                } else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
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
                                } else if(base.getAttribute("gpophotos").equalsIgnoreCase("category")) {
                                    try {
                                        File f = new File(fspath+pp.getPhotoImage());
                                        f.delete();
                                        f = new File(fspath+_thumbnail+pp.getPhotoImage());
                                        f.delete();
                                        sprovider.removeSpCategoryPymePhoto(pp);
                                        sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()-1);
                                        pp.remove();
                                    } catch (Exception e) {
                                        log.error("Error while deletting file in resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), e);
                                    }
                                } else if (base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
                                    try {
                                        File f = new File(fspath+pp.getPhotoImage());
                                        f.delete();
                                        f = new File(fspath+_thumbnail+pp.getPhotoImage());
                                        f.delete();
                                        sprovider.removeMorePymePhoto(pp);
                                        sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()-1);
                                        pp.remove();
                                    } catch (Exception e) {
                                        log.error("Error while deletting file in resource instance PhotoAlbum with id: "+base.getId() +"-"+ base.getTitle(), e);
                                    }
                                }
                            }
                        }
                    } else {
                        if (item.getSize() == 0 || item.getSize() > maxSizeAcceptedByPict) {
                            msg.append("1,");
                            item.delete();
                            continue;
                        }
                        if (!userCanAdd(model, sprovider)) {
                            msg.append("3,");
                            item.delete();
                            break;
                        }
//                        if( sprovider.getSpTotPhotos()>MAX_PICT_ACCEPTED )
//                            continue;
                        String ext;
                        try {
                            ext = item.getName().substring(item.getName().lastIndexOf(".") + 1).toLowerCase();
                        } catch (StringIndexOutOfBoundsException iobe) {
                            msg.append("5,");
                            item.delete();
                            continue;
                        }
                        if (item.getName().indexOf(" ") != -1) {
                            msg.append("11,");
                            item.delete();
                            continue;
                        }
                        if (Arrays.binarySearch(fileFormats, ext) < 0) {
                            msg.append("7,");
                            item.delete();
                            continue;
                        }

                        long serial = (new Date()).getTime();
                        String filename;
                        try {
                            filename = serial + "_" + item.getFieldName() + item.getName().substring(item.getName().lastIndexOf("."));
                        } catch (StringIndexOutOfBoundsException iobe) {
                            msg.append("9,");
                            item.delete();
                            continue;
                        }

                        File image = new File(fspath + filename);
                        File shrink = new File(fspath +"_"+ filename);
                        boolean shrinked = false;
                        try {
                            item.write(image);
                            shrinked = ImageResizer.shrinkTo(image, width, height, shrink, "jpeg");                            
                        } catch (Exception e) {
                            log.error("Error while writting file in resource instance PhotoAlbumSheet with id: "+base.getId() +"-"+ base.getTitle(), e);
                        }
                        File thumbnail = new File(fspath + _thumbnail + filename);
                        try {
                            //ImageResizer.resizeCrop(image, width, thumbnail, "jpeg");
                            ImageResizer.shrinkTo(image, thnWidth, thnHeight, thumbnail, "jpeg");
                        } catch (IOException e) {
                            log.error("Error while writting thumbnail in resource instance PhotoAlbumSheet with id: "+base.getId() +"-"+ base.getTitle(), e);
                        }
                        if (shrinked) {
                            image.delete();
                            shrink.renameTo(image);
                            image = shrink;
                        }
                        
                        PymePhoto pp = PymePhoto.ClassMgr.createPymePhoto(sprovider.getWebPage().getWebSite());
                        pp.setPhotoImage(filename);
                        pp.setPhotoThumbnail(_thumbnail+filename);
                        pp.setPhotoSize(SWBUtils.IO.getFileSize(image));
                        if (base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
                            sprovider.addEstablishmentPymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        } else if (base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
                            sprovider.addInstalationsPymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        } else if (base.getAttribute("gpophotos").equalsIgnoreCase("category")) {
                            sprovider.addSpCategoryPymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        } else if (base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
                            sprovider.addMorePymePhoto(pp);
                            sprovider.setSpTotPhotos(sprovider.getSpTotPhotos()+1);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            log.error("Error while adding attributos to resource instance PhotoAlbum with id: "
                    + base.getId() + "-" + base.getTitle(), ex);
            ex.printStackTrace();
        }
        if (msg.length() > 0) {
            request.setAttribute("msg", msg.toString());
        }
    }

    private void display(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest, ServiceProvider sprovider)
            throws SWBResourceException, IOException {

        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        Iterator<PymePhoto> it = null;
        StringBuilder script = new StringBuilder();
        User user = paramRequest.getUser();
        boolean userCanEdit = userCanEdit(user);

        userCanEdit = userCanEdit || (user.getURI() != null && sprovider.getCreator().getURI().equals(user.getURI()));
        final int numMaxPhotos = Paquete.ClassMgr.getPaquete(Integer.toString(sprovider.getPymePaqueteType()),
                paramRequest.getWebPage().getWebSite()).getPaq_NumMaxPhotos();

        if (paramRequest.getCallMethod() == paramRequest.Call_STRATEGY) {
            Random random = new Random();
            random.setSeed(new Date().getTime());

            String path = SWBPortal.getWebWorkPath() + sprovider.getWorkPath() + "/photos/establishment/";
            ArrayList<String> photos = new ArrayList<String>(16);
            it = sprovider.listEstablishmentPymePhotos();
            while (it.hasNext()) {
                photos.add(path + it.next().getPhotoThumbnail());
            }

            path = SWBPortal.getWebWorkPath() + sprovider.getWorkPath() + "/photos/instalation/";
            it = sprovider.listInstalationsPymePhotos();
            while (it.hasNext()) {
                photos.add(path + it.next().getPhotoThumbnail());
            }

            path = SWBPortal.getWebWorkPath() + sprovider.getWorkPath() + "/photos/category/";
            it = sprovider.listSpCategoryPymePhotos();
            while (it.hasNext()) {
                photos.add(path + it.next().getPhotoThumbnail());
            }

            path = SWBPortal.getWebWorkPath() + sprovider.getWorkPath() + "/photos/more/";
            it = sprovider.listMorePymePhotos();
            while (it.hasNext()) {
                photos.add(path + it.next().getPhotoThumbnail());
            }
            photos.trimToSize();

            if (userCanEdit && this.userCanAdd(paramRequest.getWebPage().getWebSite(), sprovider)) {
                out.println("<h2 class=\"incomplete-charge\">Fotos</h2>");
            }  else {
                out.println("<h2>Fotos</h2>");
            }

            if (photos.size() > 0) {
                out.println("<div class=\"photosHolder\">");
                for (int i = 0; i < maxPictPreview && photos.size() > 0; i++) {
                    int r = random.nextInt(photos.size());
                    String image = photos.get(r);
                    out.println("<a href=\"#\" id=\""+"pa_"+i+"_"+base.getId()+"\" group=\"group1\">");
                    out.println("<img height=\"62\" width=\"82\" alt=\""+image+"\" src=\""+image+"\" />");
                    out.println("</a>");

                    script.append("var lb_"+i+"_"+base.getId()+" = new dojox.image.Lightbox({ title:'',  href:'"+image.replaceFirst(_thumbnail, "")+"', group:'group_2_"+base.getId()+"' }, 'pa_"+i+"_"+base.getId()+"');\n");
                    script.append("lb_"+i+"_"+base.getId()+".startup();\n");

                    photos.remove(r);
                }
                out.println("</div>");
                out.println("<script type=\"text/javascript\">");
                out.println("<!--");
                out.println("dojo.require(\"dojox.image.Lightbox\");");
                out.println("dojo.addOnLoad(function() {");
                out.println(script);

//                out.println("var dialog = new dojox.image.LightboxDialog({});");
//                for(int i=0; i<nde && i<photos.size(); i++) {
//                    out.println("dialog.addImage( lb_"+i+", 'group2' );");
//                }
//                out.println("        dialog.startup();");
                out.println("    });");

//                out.println("    function showdialog() {");
//                out.println("        var dialog = dijit.byId('dojoxLightboxDialog');");
//                out.println("        dialog.show( { group:'group2'} );");
//                out.println("    }");
                out.println("-->");
                out.println("</script>");
            }
            String surl = "javascript:showdialog()";
            MicroSitePyme ms = sprovider.getMicroSitePymeInv();
            Iterator<MicroSiteWebPageUtil> msutils = ms.listMicroSiteUtils();
            while (msutils.hasNext()) {
                MicroSiteWebPageUtil msu = msutils.next();
                if (msu.getTitle().toLowerCase().endsWith("fotos")) {
                    surl = msu.getUrl();
                    break;
                }
            }
            out.println("<a href=\""+surl+"\">Ver todas las fotos</a>");
        } else {
            final String path = SWBPortal.getWebWorkPath()+sprovider.getWorkPath()+"/photos/"+base.getAttribute("gpophotos")+"/";
            if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
                it = sprovider.listEstablishmentPymePhotos();
            }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
                it = sprovider.listInstalationsPymePhotos();
            }else if(base.getAttribute("gpophotos").equalsIgnoreCase("category")) {
                it = sprovider.listSpCategoryPymePhotos();
            }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
                it = sprovider.listMorePymePhotos();
            }
            
            if( userCanEdit || it.hasNext() ) {
                String action = paramRequest.getAction();
                if (action != null &&
                        action.equalsIgnoreCase(paramRequest.Action_ADD + "_"
                                + base.getAttribute("gpophotos"))) {
                    if (request.getParameter("msg") != null) {
                        String[] messages = request.getParameter("msg").split(",");
                        int j = 0;
                        out.print("<div id=\"message\"><p>\nOcurri&oacute; alg&uacute;n problema ");
                        out.print("con la carga de los archivos enviados, en seguida se muestra el detalle,");
                        out.println("por favor rev&iacute;salo para que puedas concluir la operaci&oacute;n deseada:<br/>");
                        while (j < messages.length) {
                            String msg = null;
                            int msgNum = 0;
                            try {
                                msgNum = Integer.parseInt(messages[j]);
                            } catch (NumberFormatException nfe) {
                                msgNum = 0;
                            }
                            switch (msgNum) {
                                case 1: msg = "Al menos una fotograf&iacute;a excede el l&iacute;mite del tamaño permitido.<br/>";
                                        break;
                                case 3: msg = "Se ha alcanzado el l&iacute;mite de fotograf&iacute;as a cargar.<br/>";
                                        break;
                                case 5: msg = "No se detect&oacute; la extensi&oacute;n de alguna de las fotograf&iacute;as enviadas.<br/>";
                                        break;
                                case 7: msg = "Se detect&oacute; que al menos una fotograf&iacute;a no tiene por extensi&oacute;n alguna de las permitidas.<br>";
                                        break;
                                case 9: msg = "No se detect&oacute; la extensi&oacute;n de alguna de las fotograf&iacute;as enviadas.<br/>";
                                        break;
                                case 11: msg = "Al menos un nombre de archivo conten&iacute;a espacios en blanco.<br/>";
                                        break;
                                default: msg = "";
                            }
                            out.println(msg);
                            out.println("</p></div>");
                            j++;
                        }
                    }
                }
                if (base.getAttribute("gpophotos").equalsIgnoreCase("category")) {
                    if (sprovider.getSemanticObject().getSemanticClass().getName().equalsIgnoreCase("hospedaje")){
                        out.println("<h3 class=\"subtitleLevel2\">FOTOS DE HABITACIONES&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    } else if (sprovider.getSemanticObject().getSemanticClass().getName().equalsIgnoreCase("restaurante")){
                        out.println("<h3 class=\"subtitleLevel2\">FOTOS DE PLATILLOS&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                    }
                    if (userCanEdit) {
                        out.println("<span class=\"tooltipWrapper\">?");
                        out.println("   <span class=\"tooltip\">");
                        out.println("       Puedes subir un máximo de " + numMaxPhotos + " fotos en tu página web. Selecciona una imagen desde tu computadora (4mb máximo). Los formatos de imágenes aceptados son: gif, jpg, png. Al cargar el archivo de una imagen, confirmas que tienes los derechos de uso y distribución, y que ello no infringe las condiciones del servicio.");
                        out.println("   </span>");
                        out.println("</span>");
                    }
                    out.println("</h3>");
                } else {
                    String title = base.getDisplayTitle(paramRequest.getUser().getLanguage());
                    if (title.equalsIgnoreCase("establecimiento") || title.equalsIgnoreCase("establishment")) {
                        out.println("<h2 class=\"subtitleLevel2\">"+title+"</h2>");
                    } else {
                        out.println("<h3 class=\"subtitleLevel2\">"+title+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                        if (userCanEdit) {
                            out.println("<span class=\"tooltipWrapper\">?");
                            out.println("   <span class=\"tooltip\">");
                            out.println("       Puedes subir un máximo de " + numMaxPhotos + " fotos en tu página web. Selecciona una imagen desde tu computadora (4mb máximo). Los formatos de imágenes aceptados son: gif, jpg, png. Al cargar el archivo de una imagen, confirmas que tienes los derechos de uso y distribución, y que ello no infringe las condiciones del servicio.");
                            out.println("   </span>");
                            out.println("</span>");
                        }
                        out.println("</h3>");
                    }
                }

                if (it != null && it.hasNext()) {
                    out.println("<div class=\"holderPhotoPreviews\">");
                    int i = 0;
                    while (it.hasNext()) {
                        PymePhoto pp = it.next();
                        if (i % 3 == 0) {
                            out.println("<div class=\"photoRow\">");
                        }
                        out.println("<div class=\"photoPreview\">");
                        out.println("<img alt=\""+pp.getPhotoImage()+"\" src=\""+path+pp.getPhotoThumbnail()+"\" />");
                        out.println("<input type=\"button\" value=\"ver foto\" id=\""+"pac_"+i+"_"+base.getId()+"\" />");
                        out.println("</div>");

                        script.append("var lb_"+i+"_"+base.getId()+" = new dojox.image.Lightbox({ title:'', href:'"+path+pp.getPhotoImage()+"', group:'group"+base.getId()+"' }, 'pac_"+i+"_"+base.getId()+"');\n");
                        script.append("lb_"+i+"_"+base.getId()+".startup();\n");

                        i++;
                        if(i%3==0 || !it.hasNext())
                            out.println("</div>");
                    }
                    if ( base.getAttribute("gpophotos").equalsIgnoreCase("establishment") ) {
                        out.println("<p class=\"previewsDescription\">"+( sprovider.getSpEstablishmentPymePhotosComments()==null?"&nbsp;":sprovider.getSpEstablishmentPymePhotosComments() )+"</p>");
                    } else if ( base.getAttribute("gpophotos").equalsIgnoreCase("instalation") ) {
                        out.println("<p class=\"previewsDescription\">"+( sprovider.getSpInstalationsPymePhotosComments()==null?"&nbsp;":sprovider.getSpInstalationsPymePhotosComments() )+"</p>");
                    } else if ( base.getAttribute("gpophotos").equalsIgnoreCase("category") ) {
                        out.println("<p class=\"previewsDescription\">"+( sprovider.getSpCategoryPymePhotoCommens()==null?"&nbsp;":sprovider.getSpCategoryPymePhotoCommens() )+"</p>");
                    } else if (base.getAttribute("gpophotos").equalsIgnoreCase("more") ) {
                        out.println("<p class=\"previewsDescription\">"+( sprovider.getSpMorePymePhotosComments()==null?"&nbsp":sprovider.getSpMorePymePhotosComments() )+"</p>");
                    }
                    out.println("</div>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("<!--");
                    out.println("dojo.require(\"dojox.image.Lightbox\");");
                    out.println("dojo.addOnLoad(function(){");
                    out.println(script);
                    out.println("});");
                    out.println("-->");
                    out.println("</script>");
                }
            }

            if (userCanEdit) {
                out.print(getFormManager(paramRequest, sprovider));
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response)
            throws SWBResourceException, IOException {

        Resource base = getResourceBase();
        String action = response.getAction();

        if (action != null &&
                        action.equalsIgnoreCase(response.Action_ADD + "_"
                                + base.getAttribute("gpophotos"))) {
            if (request.getParameter("uri") != null) {
                SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri"));
                ServiceProvider sprovider = (ServiceProvider) semObject.createGenericInstance();
                if (sprovider != null && sprovider.getPymePaqueteType() > 2) {
                    add(request, sprovider, response.getWebPage().getWebSite());
                    if (request.getAttribute("msg") != null) {
                        response.setRenderParameter("msg", (String) request.getAttribute("msg"));
                    }
                }
            }
        }
    }

    private boolean userCanAdd(WebSite model, ServiceProvider sprovider) {

        boolean canAdd = false;
        final int totPhotos = sprovider.getSpTotPhotos();
        final int packageType = sprovider.getPymePaqueteType();
        final int numMaxPhotos = Paquete.ClassMgr.getPaquete(Integer.toString(packageType), model).getPaq_NumMaxPhotos();

        if (totPhotos < numMaxPhotos) {
            canAdd = true;
        }
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
