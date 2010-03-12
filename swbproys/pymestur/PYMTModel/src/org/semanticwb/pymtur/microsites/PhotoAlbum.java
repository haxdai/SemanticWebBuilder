package org.semanticwb.pymtur.microsites;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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

import org.semanticwb.portal.util.FileUpload;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.pymtur.Promotion;
import org.semanticwb.pymtur.PymePhoto;

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
        WebPage community = null;
        WebPage currentpage = (WebPage) request.getAttribute("webpage");
        if(currentpage == null) {
            currentpage = paramRequest.getWebPage();
        }
        if(currentpage instanceof MicroSitePyme) {
            community = currentpage;
        }else {
            community = currentpage.getParent();
        }
        MicroSitePyme ms = (MicroSitePyme)community;
        sprovider = ms.getServiceProvider();


//System.out.println("\n\n");
//System.out.println("sprovider.getId()="+sprovider.getId());
//System.out.println("sprovider.getContactName()="+sprovider.getContactName());
//Iterator<Promotion> ite=sprovider.listPromotions();
//while(ite.hasNext()) {
//    Promotion p=ite.next();
//    System.out.println("promocion --- id="+p.getId()+", title="+p.getTitle()+", desc="+p.getDescription());
//}


        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        String action = paramRequest.getAction();
        System.out.println("\n\n\ndoview action en paramrequest="+paramRequest.getAction());
        if( paramRequest.Action_ADD.equalsIgnoreCase(action) ) {
            System.out.println("add");
            add(request, response, sprovider);
        }
        
        ArrayList<String> photos = new ArrayList<String>();
        Iterator<PymePhoto> it = sprovider.listEstablishmentPymePhotos();
        while(it.hasNext()) {
            PymePhoto pp = it.next();
            System.out.println("url imagen="+pp.getPhotoImage());
            photos.add(pp.getPhotoImage());
        }

        if(paramRequest.getCallMethod()==paramRequest.Call_STRATEGY) {
            out.println("<div id=\"panelFotos\">");
            out.println("<h4>las fotos</h4>");
            out.println("<p>");
            int i=0;
            for(String image : photos) {
                out.println("<span class=\"marco\">");
                out.println("<a href=\"#\" id=\""+"pa_"+i+"_"+base.getId()+"\">");
                out.println("<img height=\"62\" width=\"82\" alt=\"mi descripcion\" src=\""+image.substring(0, image.lastIndexOf("/"))+"/"+_thumbnail+image.substring(image.lastIndexOf("/")+1)+"\" />");
                out.println("</a>");
                out.println("</span>");
                i++;
            }
            out.println("<br />");
            out.println("<a href=\"#\" onclick=\"showdialog()\">Ver todas las fotos</a>");
            out.println("</p>");
            out.println("</div>");

            out.println("<script type=\"text/javascript\">");
            out.println("dojo.require(\"dojox.image.Lightbox\");");
            out.println("dojo.addOnLoad(function(){");
            i=0;
            for(String image : photos) {
                out.println("var lb_"+i+" = new dojox.image.Lightbox({ title:'piedra parada',  href:'"+image+"' }, 'pa_"+i+"_"+base.getId()+"');");
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
//            ArrayList<String> photos = new ArrayList<String>();
//            Iterator<String> it = base.getAttributeNames();
//            while(it.hasNext()) {
//                String attname = it.next();
//                String attval = base.getAttribute(attname);
//                if( attval!=null && attname.startsWith("imggallery_") ) {
//                    photos.add(webWorkPath + attval);
//                }
//            }
            out.println("<div class=\"reticula_1_columnas\">");
            out.println("<h1>FOTOS</h1>");
            out.println("<div class=\"reticula_fotos\">");
            int i=0;
            for(String image : photos) {
                out.println("<span>");
                out.println("<a href=\"#\" id=\""+"pa_"+i+"_"+base.getId()+"\">");
                out.println("<img alt=\"hola mundo\" src=\""+image.substring(0, image.lastIndexOf("/"))+"/"+_thumbnail+image.substring(image.lastIndexOf("/")+1)+"\" />");
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
                out.println("var lb_"+i+" = new dojox.image.Lightbox({ title:'piedra parada', href:'"+image+"' }, 'pa_"+i+"_"+base.getId()+"');");
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
                out.print(getFormManager(paramRequest));
        }
    }

    private String getFormManager(SWBParamRequest paramRequest) {
        Resource base=getResourceBase();
        StringBuffer ret=new StringBuffer();

ret.append("<script type=\"text/javascript\">");
ret.append("  dojo.require(\"dijit.form.NumberTextBox\");");
ret.append("  dojo.require(\"dijit.form.Button\");");
ret.append("</script>");

SWBResourceURL url = paramRequest.getRenderUrl();
url.setMode(paramRequest.Mode_VIEW);
url.setAction(paramRequest.Action_ADD);

ret.append("\n<div class=\"swbform\"> ");
ret.append("\n<form id=\"frm_pa_"+base.getId()+"\" name=\"frm_pa_"+base.getId()+"\" method=\"post\" enctype=\"multipart/form-data\" action=\""+ url+"\"> ");

ret.append("\n<fieldset> ");
ret.append("\n<legend>Datos</legend>");
ret.append("\n<table width=\"98%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");
        /****************************************************/
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">* Lista de im&aacute;genes (<i>bmp, jpg, jpeg, gif, png</i>)</td>");
            ret.append("\n<td>");
            ret.append("\n<div id=\"igcontainer_"+base.getId()+"\" style=\"background-color:#F0F0F0; width:520px; height:300px; overflow:visible\"> ");
            ret.append("\n<div id=\"iggrid_"+base.getId()+"\" style=\"width:520;height:300;left:2px;top:20px;overflow:scroll; background-color:#EFEFEF\"> ");
            ret.append("\n  <table id=\"igtbl_"+base.getId()+"\" width=\"99%\" cellspacing=\"1\" bgcolor=\"#769CCB\" align=\"center\"> ");
            ret.append("\n  <tr bgcolor=\"#E1EAF7\"> ");
            ret.append("\n    <td align=\"center\" colspan=\"4\">Administraci&oacute;n de im&aacute;genes</td> ");
            ret.append("\n    <td align=\"center\">");
            ret.append("\n    <input type=\"button\" value=\"Agregar\" onclick=\"addRowToTable('igtbl_"+base.getId()+"');\" />&nbsp;  ");
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
ret.append("\n<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");
ret.append("\n <tr><td>");
ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submitImgGal\" value=\"Submit\" onclick=\"if(jsValida())return true; else return false; \">Guardar</button>&nbsp;");
ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"reset\">Restablecer</button>");
ret.append("\n </td></tr>");
ret.append("\n</table> ");
ret.append("\n</fieldset> ");
ret.append("\n</form>  ");
ret.append("\n</div>  ");

            ret.append("\n<script type=\"text/javascript\"> ");
            ret.append("\nfunction addRowToTable(tblId, filename, img, cellSufix) { ");
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
            ret.append("\n        editCheckInput.name = 'edit_'+cellSufix; ");
            ret.append("\n        editCheckInput.id = 'edit_'+cellSufix; ");
            ret.append("\n    }else { ");
            ret.append("\n        editCheckInput.name = 'edit_"+base.getId()+"_'+iteration; ");
            ret.append("\n        editCheckInput.id = 'edit_"+base.getId()+"_'+iteration; ");
            ret.append("\n    }");
            ret.append("\n    editCheckInput.alt = 'Marcar para editar esta imagen'; ");
            ret.append("\n    editCheckInput.disabled = true; ");
            ret.append("\n    editCheckInput.onclick = function(){ ");
            ret.append("\n        if(editCheckInput.checked) { ");
            ret.append("\n            row.cells[row.cells.length-1].innerHTML = '<input type=\"file\" id=\"imggallery_"+base.getId()+"_'+iteration+'\" name=\"imggallery_"+base.getId()+"_'+iteration+'\" size=\"40\" />'; ");
            ret.append("\n            editCheckInput.checked = false; ");
            ret.append("\n            editCheckInput.disabled = true; ");
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
            ret.append("\n        removeCheckInput.name = 'remove_'+cellSufix; ");
            ret.append("\n        removeCheckInput.id = 'remove_'+cellSufix; ");
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
            ret.append("\n    removeCheckInput.value = '1'; ");
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
            ret.append("\n    var imgCell = row.insertCell(4); ");
            ret.append("\n    if(img) { ");
            ret.append("\n        imgCell.style.textAlign = 'center'; ");
            ret.append("\n        imgCell.innerHTML = img; ");
            ret.append("\n            editCheckInput.disabled = false; ");
            ret.append("\n    }else { ");
            ret.append("\n        // file uploader ");
            ret.append("\n        imgCell.style.textAlign = 'right'; ");
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


            Iterator<String> it = base.getAttributeNames();
            while(it.hasNext()) {
                String attname = it.next();
                String attval = base.getAttribute(attname);
                if(attval!=null && attname.startsWith("imggallery_")) {
                    String img = "<img src=\""+webWorkPath+_thumbnail+attval+"\" alt=\""+attname+"\" border=\"0\" />";
                    ret.append("\naddRowToTable('igtbl_"+base.getId()+"', '"+base.getAttribute(attname)+"', '"+img+"', '"+attname.substring(11)+"'); ");
                }
            }
            ret.append("\n</script>");


        return ret.toString();
    }

    private void add(HttpServletRequest request, HttpServletResponse response, ServiceProvider sprovider) throws SWBResourceException, IOException {
        System.out.println("\n\nadding.....");
        Resource base = getResourceBase();
        String value;
        FileUpload fup = new FileUpload();
        fup.getFiles(request, response);
        int i = 1;
        int width = Integer.parseInt(base.getAttribute("width"));
        String filenameAttr, removeChk;
        do {
            filenameAttr = "imggallery_" + base.getId() + "_" + i;
            removeChk = "remove_" + base.getId() + "_" + i;
            value = null!=fup.getValue(removeChk) && !"".equals(fup.getValue(removeChk).trim()) ? fup.getValue(removeChk).trim() : "0";

            if("1".equals(value) && base.getAttribute(filenameAttr)!=null) {
                File file = new File(workPath + base.getAttribute(filenameAttr));
                file.delete();
                file = new File(workPath + _thumbnail + base.getAttribute(filenameAttr));
                file.delete();
                base.removeAttribute(filenameAttr);
            }else {
                System.out.println("image="+filenameAttr);
                value = null!=fup.getFileName(filenameAttr) && !"".equals(fup.getFileName(filenameAttr).trim()) ? fup.getFileName(filenameAttr).trim() : null;
                System.out.println("value="+value);
                if(value!=null) {                    
                    String filename = admResUtils.getFileName(base, value);
                    System.out.println("graba archivo "+filename);
                    if( filename!=null && filename.trim().length()>0 )
                    {
                        if(admResUtils.isFileType(filename, "bmp|jpg|jpeg|gif|png")) {
                            if (admResUtils.uploadFile(base, fup, filenameAttr)) {
                                System.out.println("filenameAttr="+filenameAttr);
                                //final String path = SWBPortal.getWorkPath()+sprovider.getWorkPath()+"/gallery/establishment/";
                                final String path = sprovider.getWorkPath()+"/gallery/establishment/";
                                System.out.println("path REAL="+SWBPortal.getWorkPath()+path);
                                File sprovDir = new File(SWBPortal.getWorkPath()+path);
                                System.out.println("sprovDir es directorio? "+sprovDir.isDirectory());
                                System.out.println("sprovDir es archivo? "+sprovDir.isFile());
                                if( !sprovDir.exists() ) {
                                    sprovDir.mkdir();
                                    System.out.println("dir no existia, se creo");
                                }else{
                                    System.out.println("dir ya existe");
                                }
                                
                                
                                //SWBUtils.IO.copy(filename, filename, true, workPath, workPath);
                                File image = new File(workPath + filename);
                                boolean success = image.renameTo(new File(sprovDir, filename));
                                System.out.println("success="+success);
                                if(success) {
                                    System.out.println("path web="+SWBPortal.getWorkPath()+path+filename);
                                    image = new File(SWBPortal.getWorkPath()+path+filename);
                                    File thumbnail = new File(SWBPortal.getWorkPath()+path + _thumbnail + filename);
                                    ImageResizer.resizeCrop(image, width, thumbnail, "jpeg");
                                    /*base.setAttribute(filenameAttr, filename);*/
                                    PymePhoto pp = PymePhoto.ClassMgr.createPymePhoto(sprovider.getWebPage().getWebSite());
                                    pp.setPhotoImage(SWBPortal.getWebWorkPath()+path+filename);
                                    sprovider.addEstablishmentPymePhoto(pp);
                                    System.out.println("imagen added");
                                }
                            }
                        }
                    }
                }
            }
            i++;
        } while(value!=null || base.getAttribute(filenameAttr)!=null);

        try {
            getResourceBase().updateAttributesToDB();
//                response.setRenderParameter(UPDATE_DONE, UPDATE_DONE);
        }catch (Exception e) {
            log.error("Error al guardar Role/UserGroup para acceso al RateManager. ", e);
            System.out.println("error..."+e);
        }
    }
}
