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
import org.semanticwb.portal.admin.admresources.util.WBAdmResourceUtils;

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
import org.semanticwb.portal.community.MicroSiteType;

/**
 *
 * @author carlos.ramos
 */

public class PhotoAlbum extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(PhotoAlbum.class);
    private static final String _thumbnail = "thumbn_";

    private WBAdmResourceUtils admResUtils = new WBAdmResourceUtils();
    private String workPath;
    private String webWorkPath;    

    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            workPath = SWBPortal.getWorkPath() +  base.getWorkPath() + "/";
            webWorkPath = SWBPortal.getWebWorkPath() +  base.getWorkPath() + "/";
        }catch(Exception e) {
            log.error("Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);
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
        String path = null;
        if (wp instanceof MicroSitePyme) {
            community = wp;
        } else {
            community = wp.getParent();
        }
        MicroSitePyme ms = (MicroSitePyme)community;
        sprovider = ms.getServiceProvider();
        String siteUri = ((MicroSitePyme) community).getType().getURI();

        if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSite", wp.getWebSite()).getURI().equals(siteUri)) {
            renderResourceForMiPyme(request, response, paramRequest, sprovider);
        } else if (MicroSiteType.ClassMgr.getMicroSiteType("MiPymeSitePlus", wp.getWebSite()).getURI().equals(siteUri)) {
            renderResourceForMiPymePlus(request, response, paramRequest, sprovider);
        }

    }

    private String getFormManager(SWBParamRequest paramRequest, ServiceProvider sprovider) {
        Resource base=getResourceBase();
        StringBuffer ret=new StringBuffer();

        ret.append("<script type=\"text/javascript\">");
        ret.append("  dojo.require(\"dijit.form.NumberTextBox\");");
        ret.append("  dojo.require(\"dijit.form.Button\");");
        ret.append("</script>");

        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setMode(paramRequest.Mode_VIEW);
        url.setAction(paramRequest.Action_ADD+"_"+base.getAttribute("gpophotos"));

        ret.append("\n<div class=\"swbform\"> ");
        ret.append("\n<form id=\"frm_pa_"+base.getId()+"\" name=\"frm_pa_"+base.getId()+"\" method=\"post\" enctype=\"multipart/form-data\" action=\""+ url+"\"> ");

        ret.append("\n<table width=\"98%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");
        /****************************************************/
        ret.append("\n<tr>");
        ret.append("\n<td width=\"200\" align=\"right\">* Lista de im&aacute;genes (<i>bmp, jpg, jpeg, gif, png</i>)</td>");
        ret.append("\n<td>");
        ret.append("\n<div id=\"igcontainer_"+base.getId()+"\" style=\"background-color:#F0F0F0; width:520px; overflow:visible\"> ");
        ret.append("\n<div id=\"iggrid_"+base.getId()+"\" style=\"width:99%;left:2px;top:20px;overflow:scroll; background-color:#EFEFEF\"> ");
        ret.append("\n  <table id=\"igtbl_"+base.getId()+"\" width=\"99%\" cellspacing=\"1\" bgcolor=\"#769CCB\" align=\"center\"> ");
        ret.append("\n  <tr bgcolor=\"#E1EAF7\"> ");
        ret.append("\n    <td align=\"center\" colspan=\"4\">Administraci&oacute;n de im&aacute;genes</td> ");
        ret.append("\n    <td align=\"right\">");
        ret.append("\n    <input type=\"button\" value=\"Agregar\" onclick=\"addRowToTable_"+base.getId()+"('igtbl_"+base.getId()+"');\" />&nbsp;  ");
        ret.append("\n    <input type=\"button\" value=\"Cancelar\" onclick=\"removeRowFromTable('igtbl_"+base.getId()+"');\"/></td> ");
        ret.append("\n    </td>");
        ret.append("\n  </tr> ");
        ret.append("\n  <tr bgcolor=\"#769CCB\"> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" style=\"text-align:center;\" width=\"10\" height=\"20\" nowrap=\"nowrap\">&nbsp;</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" style=\"text-align:center;\" width=\"20\" height=\"20\" nowrap=\"nowrap\">Editar</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" style=\"text-align:center;\" width=\"30\" height=\"20\" nowrap=\"nowrap\">Eliminar</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" style=\"text-align:center;\" width=\"40%\" height=\"20\" nowrap=\"nowrap\">Archivo</th> ");
        ret.append("\n    <th align=\"center\" scope=\"col\" style=\"text-align:center;\" width=\"40%\" height=\"20\" nowrap=\"nowrap\">Imagen</th> ");
        ret.append("\n  </tr> ");
        ret.append("\n</table> ");
        ret.append("\n</div> ");
        ret.append("\n</div> ");
        ret.append("\n</td>  ");
        ret.append("\n</tr>  ");
        /****************************************************/
        ret.append("\n<fieldset> ");
        ret.append("\n<table width=\"99%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");
        ret.append("\n <tr><td>");
        //ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submitImgGal\" value=\"Submit\" onclick=\"if(jsValida())return true; else return false; \">Guardar</button>&nbsp;");
        ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submitImgGal\" value=\"Submit\" >Guardar</button>&nbsp;");
        ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"reset\">Restablecer</button>");
        ret.append("\n </td></tr>");
        ret.append("\n</table> ");

        ret.append("\n</form>  ");
        ret.append("\n</div>  ");

        ret.append("\n<script type=\"text/javascript\"> ");
        ret.append("\nfunction addRowToTable_"+base.getId()+"(tblId, filename, img, cellSufix) { ");
        ret.append("\n    var tbl = document.getElementById(tblId); ");
        ret.append("\n    var lastRow = tbl.rows.length; ");
        ret.append("\n    var iteration = lastRow-1; // descontar el renglon de titulo ");
        ret.append("\n    var row = tbl.insertRow(lastRow); ");
        ret.append("\n    row.style.backgroundColor = '#F4F4DD'; ");
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
        //ret.append("\n        editCheckInput.name = 'edit_'+cellSufix; ");
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
        //ret.append("\n            editCheckInput.checked = false; ");
        //ret.append("\n            editCheckInput.disabled = true; ");
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
        //ret.append("\n        removeCheckInput.name = 'remove_'+cellSufix; ");
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
        //ret.append("\n    removeCheckInput.value = '1'; ");
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
        ret.append("    if(lastRow >= 2) { ");
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

        return ret.toString();
    }

    private void add(HttpServletRequest request, HttpServletResponse response, ServiceProvider sprovider) throws SWBResourceException, IOException {
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
            width = Integer.parseInt(base.getAttribute("width"));
        }catch(NumberFormatException nfe) {
            width = 82;
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
                FileItem currentFile = null;
                Iterator iter = items.iterator();
                while (iter.hasNext())
                {
                    FileItem item = (FileItem) iter.next();

                    if( item.isFormField() ) {                        
                        System.out.println("este campo no es multipart..."+item.getFieldName()+",value="+item.getString());
                        String action = item.getFieldName();
                        String value = item.getString();
                        PymePhoto pp = PymePhoto.ClassMgr.getPymePhoto(value, sprovider.getWebPage().getWebSite());
                        if(pp!=null) {
                            System.out.println("tenemos un pymephoto con imagen "+pp.getPhotoImage());
                            if("remove".equalsIgnoreCase(action) || "edit".equalsIgnoreCase(action)) {
                                System.out.println("eliminando pymephoto "+pp.getId());
                                if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
                                    sprovider.removeEstablishmentPymePhoto(pp);
                                    pp.remove();
                                }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
                                    sprovider.removeInstalationsPymePhoto(pp);
                                    pp.remove();
                                }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
                                    sprovider.removeMorePymePhoto(pp);
                                    pp.remove();
                                }
                            }
                        }
                    }else {
                        System.out.println("este campo es archivo..."+item.getFieldName());
                        currentFile = item;
                        try
                        {
                            long serial = (new Date()).getTime();
                            String filename = serial + "_" + currentFile.getFieldName() + currentFile.getName().substring(currentFile.getName().lastIndexOf("."));

                            File image = new File(fspath + filename);
                            File thumbnail = new File(fspath + "thumbn_" + filename);
                            currentFile.write(image);
                            //ImageResizer.resize(image, width, true, thumbnail, "jpeg" );
                            ImageResizer.resizeCrop(image, width, thumbnail, "jpeg");

                            PymePhoto pp = PymePhoto.ClassMgr.createPymePhoto(sprovider.getWebPage().getWebSite());
                            pp.setPhotoImage(filename);
                            pp.setPhotoThumbnail(_thumbnail+filename);
                            pp.setPhotoSize(SWBUtils.IO.getFileSize(image));
                            if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment"))
                                sprovider.addEstablishmentPymePhoto(pp);
                            else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation"))
                                sprovider.addInstalationsPymePhoto(pp);
                            else if(base.getAttribute("gpophotos").equalsIgnoreCase("more"))
                                sprovider.addMorePymePhoto(pp);

                        } catch (StringIndexOutOfBoundsException iobe)
                        {
                            iobe.printStackTrace();
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

    private void renderResourceForMiPyme(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, ServiceProvider sprovider) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        String action = paramRequest.getAction();
        if( action!=null && action.equalsIgnoreCase(paramRequest.Action_ADD+"_"+base.getAttribute("gpophotos")) ) {
            add(request, response, sprovider);
        }

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
//            out.println("<div id=\"panelFotos\">");
//            out.println("<h4>FOTOS</h4>");
//            out.println("<p>");
            int i=0;
            for(String image : photos) {
                out.println("<span class=\"marco\">");
                out.println("<a href=\"#\" id=\""+"pa_"+i+"_"+base.getId()+"\">");
                out.println("<img height=\"62\" width=\"82\" alt=\""+image+"\" src=\""+SWBPortal.getWebWorkPath()+path+_thumbnail+image+"\" />");
                out.println("</a>");
                out.println("</span>");
                i++;
            }
            out.println("<br />");
            out.println("<a href=\"#\" onclick=\"showdialog()\">Ver todas las fotos</a>");
//            out.println("</p>");
//            out.println("</div>");

            out.println("<script type=\"text/javascript\">");
            out.println("dojo.require(\"dojox.image.Lightbox\");");
            out.println("dojo.addOnLoad(function(){");
            i=0;
            for(String image : photos) {
                out.println("var lb_"+i+" = new dojox.image.Lightbox({ title:'"+image+"',  href:'"+SWBPortal.getWebWorkPath()+path+image+"' }, 'pa_"+i+"_"+base.getId()+"');");
                out.println("lb_"+i+".startup();");
                i++;
            }

            out.println("var dialog = new dojox.image.LightboxDialog({});");
            for(int j=0; j<photos.size(); j++) {
                out.println("dialog.addImage( lb_"+j+", 'group2' );");
            }
            out.println("        dialog.startup();");
            out.println("    });");

            out.println("    function showdialog() {");
            out.println("        var dialog = dijit.byId('dojoxLightboxDialog');");
            out.println("        dialog.show( { group:'group2'} );");
            out.println("    }");
            out.println("</script>");
        }else {
            out.println("<div class=\"reticula_1_columnas\">");
            out.println("<h1>"+base.getDisplayTitle(paramRequest.getUser().getLanguage())+"</h1>");
            out.println("<div class=\"reticula_fotos\">");
            int i=0;
            for(String image : photos) {
                out.println("<span>");
                out.println("<a href=\"#\" id=\""+"pac_"+i+"_"+base.getId()+"\">");
                //out.println("<img alt=\"\" src=\""+image.substring(0, image.lastIndexOf("/"))+"/"+_thumbnail+image.substring(image.lastIndexOf("/")+1)+"\" />");
                out.println("<img alt=\""+image+"\" src=\""+SWBPortal.getWebWorkPath()+path+_thumbnail+image+"\" />");
                out.println("</a>");
                out.println("</span>");
                i++;
            }
            out.println("</div>");
            out.println("</div>");

            out.println("<script type=\"text/javascript\">");
            out.println("dojo.require(\"dojox.image.Lightbox\");");
            out.println("dojo.addOnLoad(function(){");
            i=0;
            for(String image : photos) {
                //out.println("var lb_"+i+" = new dojox.image.Lightbox({ title:'piedra parada', href:'"+image+"' }, 'pac_"+i+"_"+base.getId()+"');");
                out.println("var lb_"+i+" = new dojox.image.Lightbox({ title:'"+image+"', href:'"+SWBPortal.getWebWorkPath()+path+image+"' }, 'pac_"+i+"_"+base.getId()+"');");
                out.println("lb_"+i+".startup();");
                i++;
            }
            out.println("});");
            out.println("</script>");

            boolean userCanEdit=false;
            User user=paramRequest.getUser();
            if(user.getURI()!=null && sprovider.getCreator().getURI().equals(user.getURI()))
                userCanEdit=true;
            if(userCanEdit)
                out.print(getFormManager(paramRequest, sprovider));
        }
    }

    private void renderResourceForMiPymePlus(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest, ServiceProvider sprovider) throws SWBResourceException, IOException {
        System.out.println("a");
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        String action = paramRequest.getAction();
        if( action!=null && action.equalsIgnoreCase(paramRequest.Action_ADD+"_"+base.getAttribute("gpophotos")) ) {
            add(request, response, sprovider);
        }

        System.out.println("b");
        Iterator<PymePhoto> it = null;
        if(base.getAttribute("gpophotos").equalsIgnoreCase("establishment")) {
            System.out.println("cestablishment");
            it = sprovider.listEstablishmentPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("instalation")) {
            System.out.println("cinstalation");
            it = sprovider.listInstalationsPymePhotos();
        }else if(base.getAttribute("gpophotos").equalsIgnoreCase("more")) {
            System.out.println("cmore");
            it = sprovider.listMorePymePhotos();
        }
        ArrayList<String> photos = new ArrayList<String>();
        while(it.hasNext()) {            
            PymePhoto pp = it.next();
            photos.add(pp.getPhotoImage());
            System.out.println("imagen:"+pp.getPhotoImage());
        }
        
        final String path = sprovider.getWorkPath()+"/photos/"+base.getAttribute("gpophotos")+"/";
        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
            System.out.println("Call_STRATEGY");
            int i=0;
            for(String image : photos) {
                out.println("<span class=\"marco\">");
                out.println("<a href=\"#\" id=\""+"pa_"+i+"_"+base.getId()+"\">");
                out.println("<img height=\"62\" width=\"82\" alt=\""+image+"\" src=\""+SWBPortal.getWebWorkPath()+path+_thumbnail+image+"\" />");
                out.println("</a>");
                out.println("</span>");
                i++;
            }
            out.println("<br />");
            out.println("<a href=\"#\" onclick=\"showdialog()\">Ver todas las fotos</a>");

            out.println("<script type=\"text/javascript\">");
            out.println("dojo.require(\"dojox.image.Lightbox\");");
            out.println("dojo.addOnLoad(function(){");
            i=0;
            for(String image : photos) {
                out.println("var lb_"+i+" = new dojox.image.Lightbox({ title:'"+image+"',  href:'"+SWBPortal.getWebWorkPath()+path+image+"' }, 'pa_"+i+"_"+base.getId()+"');");
                out.println("lb_"+i+".startup();");
                i++;
            }

            out.println("var dialog = new dojox.image.LightboxDialog({});");
            for(int j=0; j<photos.size(); j++) {
                out.println("dialog.addImage( lb_"+j+", 'group2' );");
            }
            out.println("        dialog.startup();");
            out.println("    });");

            out.println("    function showdialog() {");
            out.println("        var dialog = dijit.byId('dojoxLightboxDialog');");
            out.println("        dialog.show( { group:'group2'} );");
            out.println("    }");
            out.println("</script>");
        }else {
            System.out.println("Call_CONTENT");
            System.out.println("1");
            out.println("<div class=\"holderPhotoPreviews\">");
            int i=0;
            for(String image : photos) {
                System.out.println("2");
                if(i%3==0)
                    out.println("<div class=\"photoRow\">");
                out.println("<div class=\"photoPreview\">");
                out.println("<img alt=\""+image+"\" src=\""+SWBPortal.getWebWorkPath()+path+_thumbnail+image+"\" />");
                out.println("<input type=\"button\" value=\"ver foto\" id=\""+"pac_"+i+"_"+base.getId()+"\" />");
                out.println("</div>");
                i++;
                if(i%3==0 || i==photos.size())
                    out.println("</div>");                
            }
            out.println("</div>");
            System.out.println("3");

            if(photos.size()>0) {
                System.out.println("4");
                out.println("<script type=\"text/javascript\">");
                out.println("dojo.require(\"dojox.image.Lightbox\");");
                out.println("dojo.addOnLoad(function(){");
                i=0;
                for(String image : photos) {
                    out.println("var lb_"+i+" = new dojox.image.Lightbox({ title:'"+image+"', href:'"+SWBPortal.getWebWorkPath()+path+image+"' }, 'pac_"+i+"_"+base.getId()+"');");
                    out.println("lb_"+i+".startup();");
                    i++;
                }
                out.println("});");
                out.println("</script>");
                System.out.println("5");
            }

            boolean userCanEdit=false;
            User user=paramRequest.getUser();
            if(user.getURI()!=null && sprovider.getCreator().getURI().equals(user.getURI()))
                userCanEdit=true;
            if(userCanEdit)
                out.print(getFormManager(paramRequest, sprovider));
        }
    }
}
