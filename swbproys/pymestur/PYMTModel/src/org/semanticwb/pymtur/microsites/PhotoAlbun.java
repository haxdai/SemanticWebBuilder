package org.semanticwb.pymtur.microsites;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
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
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticOntology;

/**
 *
 * @author carlos.ramos
 */

public class PhotoAlbun extends GenericResource {
    private static Logger log = SWBUtils.getLogger(PhotoAlbun.class);
    private WBAdmResourceUtils admResUtils=new WBAdmResourceUtils();
    private String workPath;
    private String webWorkPath;

    private static final String _thumbnail = "thumbn_";
    private static final String ADMIN_AXN = "admin_update";
    private static final String MGR_ATTR = "edit";
    private static final String UPDATE_DONE = "ok";

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
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        super.processRequest(request, response, paramsRequest);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

//        SemanticObject sobj;
//        ServiceProvider sprovider = null;
//        try {
//            sprovider = ((MicroSitePyme)paramsRequest.getWebPage()).getServiceProvider();
//        }catch(Exception e) {
//            String uri = request.getParameter("uri");
//            sobj=SemanticObject.createSemanticObject(uri);
//            if(sobj.getGenericInstance() instanceof MicroSitePyme) {
//                MicroSitePyme msp = (MicroSitePyme) sobj.getGenericInstance();
//                sprovider=msp.getServiceProvider();
//            }
//        }

        /*sprovider.listEstablishmentPymePhotos()
        sprovider.listExtraPhotos()
        sprovider.listInstalationsPymePhotos()
        sprovider.listMorePymePhotos()*/
//final int size = 6;
//ArrayList<PymePhoto> photos = new ArrayList(size);
//Iterator<PymePhoto> it = sprovider.listEstablishmentPymePhotos();
//while(it.hasNext() && photos.size()<size) {
//    photos.add(it.next());
//}
//if(photos.size()<size) {
//    it = sprovider.listInstalationsPymePhotos();
//    while(it.hasNext() && photos.size()<size) {
//        photos.add(it.next());
//    }
//    if(photos.size()<size) {
//        it = sprovider.listMorePymePhotos();
//        while(it.hasNext() && photos.size()<size) {
//            photos.add(it.next());
//        }
//    }
//}
//Hospedaje host = null;
//if(sprovider instanceof Hospedaje) {
//    host = (Hospedaje)sprovider;
//    if(photos.size()<size) {
//        it = host.listRoomPymePhotos();
//        while(it.hasNext() && photos.size()<size) {
//            photos.add(it.next());
//        }
//    }
//}

        ServiceProvider sprovider = null;
        WebPage community = null;
        WebPage currentpage = (WebPage) request.getAttribute("webpage");
        if(currentpage == null) {
            currentpage = paramsRequest.getWebPage();
        }
        if(currentpage instanceof MicroSitePyme) {
            community = currentpage;
        }else {
            community = currentpage.getParent();
        }
        MicroSitePyme ms = (MicroSitePyme)community;
        sprovider = ms.getServiceProvider();



        if(paramsRequest.getCallMethod()==paramsRequest.Call_STRATEGY) {
            ArrayList<String> photos = new ArrayList<String>();
            Iterator<String> it = base.getAttributeNames();
            while(it.hasNext()) {
                String attname = it.next();
                String attval = base.getAttribute(attname);
                if( attval!=null && attname.startsWith("imggallery_") ) {
                    photos.add(webWorkPath + attval);
                }
            }

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
            out.println("<br/>");
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
            ArrayList<String> photos = new ArrayList<String>();
            Iterator<String> it = base.getAttributeNames();
            while(it.hasNext()) {
                String attname = it.next();
                String attval = base.getAttribute(attname);
                if( attval!=null && attname.startsWith("imggallery_") ) {
                    photos.add(webWorkPath + attval);
                }
            }
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
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        PrintWriter out = response.getWriter();

        Resource base=getResourceBase();

        String msg = "Operación indefinida";
        String action = null != request.getParameter("act") && !"".equals(request.getParameter("act").trim()) ? request.getParameter("act").trim() : paramRequest.getAction();

        if(action.equalsIgnoreCase("add") || action.equalsIgnoreCase("edit")) {
            out.println(getForm(request, paramRequest));
        }else if(action.equalsIgnoreCase("update")) {
            FileUpload fup = new FileUpload();
            try {
                fup.getFiles(request, response);
                
                String value = null!=fup.getValue("width") && !"".equals(fup.getValue("width").trim()) ? fup.getValue("width").trim() : "180";
                base.setAttribute("width", value);
                value = null!=fup.getValue("height") && !"".equals(fup.getValue("height").trim()) ? fup.getValue("height").trim() : "180";
                base.setAttribute("height", value);
                
                int i = 1;
                int width = Integer.parseInt(base.getAttribute("width"));
                String filenameAttr, removeChk;
                do {
                //for(int j=0; j<15; j++) {
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
                        value = null!=fup.getFileName(filenameAttr) && !"".equals(fup.getFileName(filenameAttr).trim()) ? fup.getFileName(filenameAttr).trim() : null;
                        if(value!=null) {
                            String filename = admResUtils.getFileName(base, value);
                            if(filename!=null && !filename.trim().equals(""))
                            {
                                if (!admResUtils.isFileType(filename, "bmp|jpg|jpeg|gif|png")){
                                    msg = "El archivo no corresponde a ninguna de las extensiones requeridas: <i>bmp, jpg, jpeg, gif, png</i>: " + filename;
                                }else {
                                    if (admResUtils.uploadFile(base, fup, filenameAttr)){
                                        File image = new File(workPath + filename);
                                        File thumbnail = new File(workPath + _thumbnail + filename);
                                        ImageResizer.resizeCrop(image, width, thumbnail, "jpeg");
                                        base.setAttribute(filenameAttr, filename);
                                    }else {
                                        msg = "No se realizaron correctamente los cambios al subir el archivo <i>" + value + "</i>.";
                                    }
                                }
                            }else {
                                msg = "No se realizaron correctamente los cambios al subir el archivo <i>" + value + "</i>.";
                            }
                        }
                    }
                    i++;
                //}
                } while(value!=null || base.getAttribute(filenameAttr)!=null);

                base.updateAttributesToDB();

                msg = "Se actualiz&oacute; exitosamente el recurso con identificador "+ base.getId();
                out.println("<script type=\"text/javascript\" language=\"JavaScript\">");
                out.println("   alert('"+msg+"');");
                out.println("   location='"+paramRequest.getRenderUrl().setAction("edit").toString()+"';");
                out.println("</script>");
            }catch(Exception e) {
                log.error(e);
                msg = "Se present&oacute; un error al actualizar el recurso con identificador "+ base.getId();
            }
        }
        else if(action.equals("remove"))
        {
            msg=admResUtils.removeResource(base);
            out.println(
                "<script type=\"text/javascript\" language=\"JavaScript\">"+
                "   alert('"+msg+"');"+
                "</script>");
        }
        out.flush();
    }

    private String getForm(javax.servlet.http.HttpServletRequest request, SWBParamRequest paramRequest) {
        StringBuffer ret=new StringBuffer();
        Resource base=getResourceBase();
        try {
            SWBResourceURL url = paramRequest.getRenderUrl().setMode(paramRequest.Mode_ADMIN);
            url.setAction("update");

            ret.append("<script type=\"text/javascript\">");
            ret.append("  dojo.require(\"dijit.form.NumberTextBox\");");
            ret.append("  dojo.require(\"dijit.form.Button\");");
            ret.append("</script>");

            ret.append("\n<div class=\"swbform\"> ");
            ret.append("\n<form id=\"frmIG_"+base.getId()+"\" name=\"frmIG_"+base.getId()+"\" method=\"post\" enctype=\"multipart/form-data\" action=\""+ url.toString()+"\"> ");

            ret.append("\n<fieldset> ");
            ret.append("\n<legend>Datos</legend>");
            ret.append("\n<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");

            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">T&iacute;tulo</td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"text\" size=\"50\" maxlength=\"50\" name=\"title\" value=\""+base.getAttribute("title", "")+"\" />");
            ret.append("\n</td>");
            ret.append("\n</tr>");

            String width = base.getAttribute("width", "220");
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">Ancho</td>");
            ret.append("\n<td>");
            ret.append("\n<input id=\"width\" name=\"width\" type=\"text\" dojoType=\"dijit.form.NumberTextBox\" value=\""+width+"\" invalidMessage=\"Valor inv&aacute;lido\" size=\"5\" maxlength=\"4\" constraints=\"{min:1, pattern:'####'}\" />");
            ret.append("\n</td>");
            ret.append("\n</tr>");

            String height = base.getAttribute("height", "150");
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">Alto</td>");
            ret.append("\n<td>");
            ret.append("\n<input id=\"height\" name=\"height\" type=\"text\" dojoType=\"dijit.form.NumberTextBox\" value=\""+height+"\" invalidMessage=\"Valor inv&aacute;lido\" size=\"5\" maxlength=\"4\" constraints=\"{min:1, pattern:'####'}\" />");
            ret.append("\n</td>");
            ret.append("\n</tr>");

/****************************************************/
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">* Lista de im&aacute;genes (<i>bmp, jpg, jpeg, gif, png</i>)</td>");
            ret.append("\n<td>");
            ret.append("\n<div id=\"igcontainer_"+base.getId()+"\" style=\"background-color:#F0F0F0; width:602px; height:432px; overflow:visible\"> ");
            ret.append("\n<div id=\"iggrid_"+base.getId()+"\" style=\"width:600px;height:400px;left:2px;top:20px;overflow:scroll; background-color:#EFEFEF\"> ");
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
WebSite wsite = paramRequest.getWebPage().getWebSite();
User user = paramRequest.getUser();
String roleName = base.getAttribute(MGR_ATTR, "0");
StringBuffer rulesScript = new StringBuffer("");
String selected = "";
if(roleName.equals("0"))
    selected = " selected=\"selected\" ";
rulesScript.append("<option value=\"0\" "+selected+">Ninguno</option>");

Iterator<Role> roles = wsite.getUserRepository().listRoles();
if(roles.hasNext()) {
    rulesScript.append("<optgroup label=\"Roles\">");
    while (roles.hasNext()) {
        Role oRole = roles.next();
        selected = "";
        if (roleName.equalsIgnoreCase(oRole.getURI())) {
            selected = " selected=\"selected\" ";
        }
        rulesScript.append("<option value=\""+URLEncoder.encode(oRole.getURI(), "UTF-8")+"\" "+selected+">"+oRole.getDisplayTitle(user.getLanguage())+"</option>");
    }
    rulesScript.append("</optgroup>");
}

Iterator<UserGroup> ugroups = wsite.getUserRepository().listUserGroups();
if(ugroups.hasNext()) {
    rulesScript.append("<optgroup label=\"User Groups\">");
    while (ugroups.hasNext()) {
        UserGroup oUG = ugroups.next();
        selected = "";
        if (roleName.equalsIgnoreCase(oUG.getURI())) {
            selected = " selected=\"selected\" ";
        }
        rulesScript.append("<option value=\""+URLEncoder.encode(oUG.getURI(), "UTF-8")+"\" "+selected+">"+oUG.getDisplayTitle(user.getLanguage())+"</option>");
    }
    rulesScript.append("</optgroup>");
}


            ret.append("\n<tr><td colspan=\"2\" height=\"10\"></td></tr>");
            ret.append("\n</table> ");
            ret.append("\n</fieldset> ");

            ret.append("\n<fieldset> ");
            ret.append("\n<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");
            ret.append("\n <tr><td>");
            ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submitImgGal\" value=\"Submit\" onclick=\"if(jsValida())return true; else return false; \">Guardar</button>&nbsp;");
            ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"reset\">Restablecer</button>");
            ret.append("\n </td></tr>");
            ret.append("\n</table> ");
            ret.append("\n</fieldset> ");

            ret.append("\n</form>  ");
            ret.append("\n* Datos requeridos");
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

            ret.append("\n ");
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
        }catch(Exception e) {
            log.error(e);
        }
        return ret.toString();
    }

    private boolean userCanEdit(final User user) {
        boolean access = false;
        String roleName = getResourceBase().getAttribute("editRole", "0");
        try {
            if( user!=null && !roleName.equals("0") ) {
                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                GenericObject gobj = null;
                try {
                    gobj = ont.getGenericObject(roleName);
                } catch (Exception e) {
                    log.error("Errror InlineEdit.userCanEdit()", e);
                }

                UserGroup ugrp = null;
                Role urole = null;

                if(!roleName.equals("0")) {
                    if(gobj != null) {
                        if(gobj instanceof UserGroup) {
                            ugrp = (UserGroup) gobj;
                            if(user.hasUserGroup(ugrp)) {
                                access = true;
                            }
                        }else if(gobj instanceof Role) {
                            urole = (Role) gobj;
                            if(user.hasRole(urole)) {
                                access = true;
                            }
                        }
                    }else {
                        access = true;
                    }
                }else {
                    access = true;
                }
            }
        }catch(Exception e) {
            access = false;
        }

        if( roleName.equals("0") || user==null )
            access=true;

        return access ;
    }
}
