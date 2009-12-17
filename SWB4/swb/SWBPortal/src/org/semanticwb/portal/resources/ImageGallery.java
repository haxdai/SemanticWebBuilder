/**
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
*
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
* del SemanticWebBuilder 4.0.
*
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
* de la misma.
*
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
* dirección electrónica:
*  http://www.semanticwebbuilder.org
**/


package org.semanticwb.portal.resources;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.util.FileUpload;
import org.semanticwb.base.util.ImageResizer;
import org.semanticwb.portal.admin.admresources.util.WBAdmResourceUtils;
import org.semanticwb.portal.admin.resources.StyleInner;

/**
 * ImageGallery se encarga de desplegar y administrar una colección de imágenes
 * dispuestas en un carrusel.
 * <p>
 * Cada imagen en el carrusel puede ser seleccionada para verse en detalle a tamaño real.
 *
 * ImageGallery is in charge to unfold and to administer image collection disposes in a round robin.
 * <p> 
 * Every image in the round robin can be selected for detail in real size.
 * 
 * @author : Carlos Ramos Inchaustegui
 * @version 1.0
 */

public class ImageGallery extends GenericResource {
    private static Logger log = SWBUtils.getLogger(ImageGallery.class);
    private WBAdmResourceUtils admResUtils=new WBAdmResourceUtils();
    private String workPath;
    private String webWorkPath;

    private static final String _thumbnail = "thumbn_";

    private StyleInner si;

    @Override
    public void setResourceBase(Resource base) {
        try
        {
            super.setResourceBase(base);
            workPath = SWBPortal.getWorkPath() +  base.getWorkPath() + "/";
            webWorkPath = SWBPortal.getWebWorkPath() +  base.getWorkPath() + "/";
            
            // Si no existen thumbnails se crean
            try {
                int width = Integer.parseInt(base.getAttribute("width"));
                Iterator<String> it = base.getAttributeNames();
                while(it.hasNext()) {
                    String attname = it.next();
                    String attval = base.getAttribute(attname);
                    if( attname.startsWith("imggallery_") && attval!=null ) {
                        String fn = attval.substring(attval.lastIndexOf("/")+1);
                        File img = new File(workPath + fn);
                        File thumbnail = new File(workPath + _thumbnail + fn);
                        if( !thumbnail.exists() ) {
                            try {
                                ImageResizer.resizeCrop(img, width , thumbnail, "jpeg");
                            }catch(IOException ioe) {
                            }
                        }
                    }
                }
            }catch(Exception e) {
            }
        }
        catch(Exception e) { 
            log.error("Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        /*response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
        response.setHeader("Pragma","no-cache"); //HTTP 1.0
        response.setDateHeader ("Expires", 0); //prevents caching at the proxy server*/
        PrintWriter out = response.getWriter();

        Resource base = getResourceBase();
        ArrayList<String> imgpath = new ArrayList<String>();
        Iterator<String> it = base.getAttributeNames();        
        while(it.hasNext()) {
            String attname = it.next();
            String attval = base.getAttribute(attname);
            if( attval!=null && attname.startsWith("imggallery_") ) {
                imgpath.add(webWorkPath + attval);
            }
        }
        String[] ip = new String[imgpath.size()];
        imgpath.toArray(ip);
        String script = getGalleryScript(base.getId(), Integer.parseInt(base.getAttribute("width","220")), Integer.parseInt(base.getAttribute("height","220")), Boolean.valueOf(base.getAttribute("autoplay")), Integer.parseInt(base.getAttribute("pause","2500")), Integer.parseInt(base.getAttribute("fadetime","500")), base.getAttribute("title",""), ip);
        out.print(script);
        out.flush();
    }

    public String getGalleryScript(String oid, int width, int height, boolean autoplay, int pause, int fadetime, String title, String[] imagepath) {
        Resource base = getResourceBase();
        StringBuilder out = new StringBuilder();

        if(base.getAttribute("css")!=null) {
            out.append("<script type=\"text/javascript\">");
            out.append("    setStyleSheetByInstance('"+base.getAttribute("css")+"','"+base.getId()+"');");
            out.append("</script>");
        }
        
        out.append("\n<script type=\"text/javascript\" src=\""+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/jquery-imagegallery.js\"></script>");
        out.append("<script type=\"text/javascript\" src=\""+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/jquery-1.3.js\"></script>");

        out.append("<script type=\"text/javascript\"> ");
        out.append("    simpleGallery_navpanel={ ");
        //customize nav panel container
        out.append("        panel: {height:'45px', opacity:0.5, paddingTop:'5px', fontStyle:'bold 9px Verdana'}, ");
        //nav panel images (in that order)
        out.append("        images: [ '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_rewind_blue.png', '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_play_blue.png', '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_fastforward_blue.png', '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_pause_blue.png'], ");
        //top offset of left, play, and right images, PLUS spacing between the 3 images
        out.append("        imageSpacing: {offsetTop:[-3, 0, -3], spacing:10}, ");
        //duration of slide up animation to reveal panel
        out.append("        slideduration: 500 ");
        out.append("    }; ");

        out.append("    var mygallery=new simpleGallery( { ");
        //ID of main gallery container
        out.append("        wrapperid: 'imggallery_"+ oid +"', ");
        //width/height of gallery in pixels. Should reflect dimensions of the images exactly
        out.append("        dimensions: ["+ width +", "+ height +"], ");
        out.append("        imagearray: [ ");


        for(String image : imagepath) {
            out.append("\n['"+image+"','"+image.substring(0, image.lastIndexOf("/"))+"/"+_thumbnail+image.substring(image.lastIndexOf("/")+1)+"',''],");
        }
        if(imagepath.length>0)
            out.deleteCharAt(out.length()-1);

        out.append("\n      ], ");
        out.append("        autoplay: "+ autoplay +", ");
        out.append("        persist: false, ");
        //pause between slides (milliseconds)
        out.append("        pause: "+ pause +", ");
        //transition duration (milliseconds)
        out.append("        fadeduration: "+ fadetime +", ");
        //event that fires when gallery has initialized/ ready to run
        out.append("        oninit:function(){}, ");
        //event that fires after each slide is shown
        //curslide: returns DOM reference to current slide's DIV (ie: try alert(curslide.innerHTML)
        //i: integer reflecting current image within collection being shown (0=1st image, 1=2nd etc)
        out.append("        onslide:function(curslide, i){} ");
        out.append("        } ");
        out.append("    ); ");
        out.append("</script> ");

        //out.append("<div class=\"swb-galeria\"> ");
        //out.append("<div style=\""+ titlestyle +"\">"+ title +"</div> ");
        out.append("<div class=\"swb-galeria_"+base.getId()+"\"> ");
        out.append("<div class=\"title_"+base.getId()+"\">"+ title +"</div> ");
        out.append("<div id=\"imggallery_"+ oid +"\" style=\"position:relative; visibility:hidden\"></div> ");
        out.append("</div>\n");

        return out.toString();
    }

    public String getGalleryScript(String divId, String title, String[] imgpath) {
        return getGalleryScript(divId, 220, 170, false, 2500, 500, title, imgpath);
    }

    public String getGalleryScript(String[] imgpath) {
        return getGalleryScript(Integer.toString((int)Math.random()*100), 220, 170, false, 2500, 500, "", imgpath);
    }

    public String getGalleryScript(boolean autoplay, String[] imgpath) {
        return getGalleryScript(Integer.toString((int)Math.random()*100), 220, 170, autoplay, 2500, 500, "", imgpath);
    }

    public String getGalleryScript(int width, int height, String[] imgpath) {
        return getGalleryScript(Integer.toString((int)Math.random()*100), width, height, false, 2500, 500, "", imgpath);
    }

    public String getGalleryScript(int width, int height, boolean autoplay, String[] imgpath) {
        return getGalleryScript(Integer.toString((int)Math.random()*100), width, height, autoplay, 2500, 500, "", imgpath);
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        PrintWriter out = response.getWriter();

        Resource base=getResourceBase();

        String msg=paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_undefinedOperation");
        String action = null != request.getParameter("act") && !"".equals(request.getParameter("act").trim()) ? request.getParameter("act").trim() : paramRequest.getAction();

        if(action.equalsIgnoreCase("add") || action.equalsIgnoreCase("edit")) {
            out.println(getForm(request, paramRequest));
        }else if(action.equalsIgnoreCase("update")) {
            FileUpload fup = new FileUpload();
            try {
                fup.getFiles(request, response);

                String value = null!=fup.getValue("title") && !"".equals(fup.getValue("title").trim()) ? fup.getValue("title").trim() : null;
                base.setAttribute("title", value);
                value = null!=fup.getValue("width") && !"".equals(fup.getValue("width").trim()) ? fup.getValue("width").trim() : "180";
                base.setAttribute("width", value);
                value = null!=fup.getValue("height") && !"".equals(fup.getValue("height").trim()) ? fup.getValue("height").trim() : null;
                base.setAttribute("height", value);
                value = null!=fup.getValue("autoplay") && !"".equals(fup.getValue("autoplay").trim()) ? fup.getValue("autoplay").trim() : null;
                base.setAttribute("autoplay", value);
                value = null!=fup.getValue("pause") && !"".equals(fup.getValue("pause").trim()) ? fup.getValue("pause").trim() : null;
                base.setAttribute("pause", value);
                value = null!=fup.getValue("fadetime") && !"".equals(fup.getValue("fadetime").trim()) ? fup.getValue("fadetime").trim() : null;
                base.setAttribute("fadetime", value);
                value = null!=fup.getValue("titlestyle") && !"".equals(fup.getValue("titlestyle").trim()) ? fup.getValue("titlestyle").trim() : null;
                base.setAttribute("titlestyle", value);

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
                                    msg = paramRequest.getLocaleString("msgErrFileType") +" <i>bmp, jpg, jpeg, gif, png</i>: " + filename;
                                }else {
                                    if (admResUtils.uploadFile(base, fup, filenameAttr)){                                        
                                        File image = new File(workPath + filename);
                                        File thumbnail = new File(workPath + _thumbnail + filename);
                                        ImageResizer.resizeCrop(image, width, thumbnail, "jpeg");
                                        base.setAttribute(filenameAttr, filename);
                                    }else {
                                        msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                                    }
                                }
                            }else {
                                msg=paramRequest.getLocaleString("msgErrUploadFile") +" <i>" + value + "</i>.";
                            }
                        }
                    }
                    i++;
                //}
                } while(value!=null || base.getAttribute(filenameAttr)!=null);

                base.updateAttributesToDB();

                msg=paramRequest.getLocaleString("msgOkUpdateResource") +" "+ base.getId();
                out.println("<script type=\"text/javascript\" language=\"JavaScript\">");
                out.println("   alert('"+msg+"');");
                out.println("   location='"+paramRequest.getRenderUrl().setAction("edit").toString()+"';");
                out.println("</script>");
            }catch(Exception e) {
                log.error(e); msg=paramRequest.getLocaleString("msgErrUpdateResource") +" "+ base.getId();
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
ret.append("\n<legend>"+paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_LaF")+"</legend>");
String cssResPath = "/"+SWBUtils.TEXT.replaceAll(getClass().getName(), ".", "/")+".css";
si = new StyleInner(getResourceBase());
String script = null;
try {
    script = si.render(paramRequest, cssResPath);
}catch(NullPointerException e) {
    log.error("Tal vez no exite el archivo "+cssResPath+" en el recurso: "+base.getId() +"-"+ base.getTitle(), e);
}catch(IOException e) {
    log.error("Error al leer el archivo "+cssResPath+" en el recurso: "+base.getId() +"-"+ base.getTitle(), e);
}catch(Exception e) {
    log.error("Error en el recurso: "+base.getId() +"-"+ base.getTitle(), e);
}
ret.append(script);
ret.append("\n</fieldset> ");


            ret.append("\n<fieldset> ");
            ret.append("\n<legend>"+paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_legendData")+"</legend>");
            ret.append("\n<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");

            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">" + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_title") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"text\" size=\"50\" maxlength=\"50\" name=\"title\" ");
            ret.append("\n value=\"" + base.getAttribute("title", "").trim().replaceAll("\"", "&#34;") + "\" />");
            ret.append("\n</td> ");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">" + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_autoplay") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input type=\"checkbox\" value=\"true\" name=\"autoplay\" ");
            if ("true".equalsIgnoreCase(base.getAttribute("autoplay", "false"))) {
                ret.append("\n checked=\"checked\"");
            }
            ret.append("\n/>");
            ret.append("\n</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">" + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_pause") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input id=\"pause\" name=\"pause\" type=\"text\" dojoType=\"dijit.form.NumberTextBox\" value=\""+base.getAttribute("pause", "2500")+"\" invalidMessage=\""+paramRequest.getLocaleString("invmsg_ImageGallery_doAdmin")+"\" size=\"5\" maxlength=\"4\" constraints=\"{min:1,max:9999, pattern:'####'}\" />");
            ret.append("\n</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">" + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_fadetime") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input id=\"fadetime\" name=\"fadetime\" type=\"text\" dojoType=\"dijit.form.NumberTextBox\" value=\""+base.getAttribute("fadetime", "500")+"\" invalidMessage=\""+paramRequest.getLocaleString("invmsg_ImageGallery_doAdmin")+"\" size=\"5\" maxlength=\"4\" constraints=\"{min:1,max:9999, pattern:'####'}\" />");
            ret.append("\n</td>");
            ret.append("\n</tr>");

            String width = base.getAttribute("width", "220");
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">" + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_width") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input id=\"width\" name=\"width\" type=\"text\" dojoType=\"dijit.form.NumberTextBox\" value=\""+width+"\" invalidMessage=\""+paramRequest.getLocaleString("invmsg_ImageGallery_doAdmin")+"\" size=\"5\" maxlength=\"4\" constraints=\"{min:1, pattern:'####'}\" />");
            ret.append("\n</td>");
            ret.append("\n</tr>");

            String height = base.getAttribute("height", "150");
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">" + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_height") + "</td>");
            ret.append("\n<td>");
            ret.append("\n<input id=\"height\" name=\"height\" type=\"text\" dojoType=\"dijit.form.NumberTextBox\" value=\""+height+"\" invalidMessage=\""+paramRequest.getLocaleString("invmsg_ImageGallery_doAdmin")+"\" size=\"5\" maxlength=\"4\" constraints=\"{min:1, pattern:'####'}\" />");
            ret.append("\n</td>");
            ret.append("\n</tr>");
            
            ret.append("\n<tr>");
            ret.append("\n<td width=\"200\" align=\"right\">* " + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_img") + "&nbsp;(<i>bmp, jpg, jpeg, gif, png</i>)</td>");
            ret.append("\n<td>");
            ret.append("\n<div id=\"igcontainer_"+base.getId()+"\" style=\"background-color:#F0F0F0; width:602px; height:432px; overflow:visible\"> ");
//            ret.append("\n<table width=\"99%\" border=\"0\" align=\"center\"> ");
//            ret.append("\n<tr> ");
//            ret.append("\n<td width=\"200\" align=\"right\"><span>" + paramRequest.getLocaleString("usrmsg_ImageGallery_imggrid") + "</span></td> ");
//            ret.append("\n<td align=\"right\"></td> ");
//            ret.append("\n<td align=\"right\"> ");
//            ret.append("\n    <input type=\"button\" value=\"Agregar\" onclick=\"addRowToTable('igtbl_"+base.getId()+"');\" />&nbsp;  ");
//            ret.append("\n    <input type=\"button\" value=\"Cancelar\" onclick=\"removeRowFromTable('igtbl_"+base.getId()+"');\"/></td> ");
//            ret.append("\n</tr> ");
//            ret.append("\n</table> ");
            ret.append("\n<div id=\"iggrid_"+base.getId()+"\" style=\"width:600px;height:400px;left:2px;top:20px;overflow:scroll; background-color:#EFEFEF\"> ");
            ret.append("\n  <table id=\"igtbl_"+base.getId()+"\" width=\"99%\" cellspacing=\"1\" bgcolor=\"#769CCB\" align=\"center\"> ");


ret.append("\n  <tr bgcolor=\"#E1EAF7\"> ");
ret.append("\n    <td align=\"center\" colspan=\"4\">" + paramRequest.getLocaleString("usrmsg_ImageGallery_imggrid") + "</td> ");
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

            ret.append("\n<tr><td colspan=\"2\" height=\"10\"></td></tr>");
            ret.append("\n</table> ");
            ret.append("\n</fieldset> ");

//            ret.append("\n<fieldset> ");
//            ret.append("\n<legend>"+paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_LaF")+"</legend>");
//            String cssResPath = "/"+SWBUtils.TEXT.replaceAll(getClass().getName(), ".", "/")+".css";
//            si = new StyleInner(getResourceBase());
//            String script = null;
//            try {
//                script = si.render(paramRequest, cssResPath);
//            }catch(NullPointerException e) {
//                log.error("Tal vez no exite el archivo "+cssResPath+" en el recurso: "+base.getId() +"-"+ base.getTitle(), e);
//            }catch(IOException e) {
//                log.error("Error al leer el archivo "+cssResPath+" en el recurso: "+base.getId() +"-"+ base.getTitle(), e);
//            }catch(Exception e) {
//                log.error("Error en el recurso: "+base.getId() +"-"+ base.getTitle(), e);
//            }
//            ret.append(script);
//            ret.append("\n</fieldset> ");

            ret.append("\n<fieldset> ");
            ret.append("\n<table width=\"100%\"  border=\"0\" cellpadding=\"5\" cellspacing=\"0\"> ");
            ret.append("\n <tr><td>");
            ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"submitImgGal\" value=\"Submit\" onclick=\"if(jsValida())return true; else return false; \">"+paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_submit")+"</button>&nbsp;");
            ret.append("\n <button dojoType=\"dijit.form.Button\" type=\"reset\">"+paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_reset")+"</button>");
            ret.append("\n </td></tr>");
            ret.append("\n</table> ");
            ret.append("\n</fieldset> ");

            ret.append("\n</form>  ");
            ret.append("\n* " + paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_required"));
            ret.append("\n</div>  ");

            ret.append("\n<script type=\"text/javascript\"> ");
            ret.append("\nfunction addRowToTable(tblId, filename, img, cellSufix) { ");
            ret.append("\n    var tbl = document.getElementById(tblId); ");
            ret.append("\n    var lastRow = tbl.rows.length; ");
            ret.append("\n    var iteration = lastRow; ");
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
            ret.append("\n    editCheckInput.alt = '"+paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_altEdit")+"'; ");
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
            ret.append("\n    removeCheckInput.alt = '"+paramRequest.getLocaleString("usrmsg_ImageGallery_doAdmin_altRemove")+"'; ");
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
                    //String img = "<img src=\""+webWorkPath+_thumbnail+attval+"\" width=\""+width+"\" height=\""+height+"\" alt=\""+attname+"\" border=\"0\" />";
                    String img = "<img src=\""+webWorkPath+_thumbnail+attval+"\" alt=\""+attname+"\" border=\"0\" />";
                    ret.append("\naddRowToTable('igtbl_"+base.getId()+"', '"+base.getAttribute(attname)+"', '"+img+"', '"+attname.substring(11)+"'); ");
                }
            }
            ret.append("\n</script>");
            ret.append(getScript());
        }catch(Exception e) {
            log.error(e);
        }
        return ret.toString();
    }

    private String getScript() {
        StringBuffer ret = new StringBuffer();
        try {
            ret.append("\n<script type=\"text/javascript\">");
            ret.append("function jsValida() {");
            ret.append("    if(!isInt(dojo.byId('pause'))) return false;");
            ret.append("    if(!isInt(dojo.byId('fadetime'))) return false;");
            ret.append("    if(!isInt(dojo.byId('width'))) return false;");
            ret.append("    if(!isInt(dojo.byId('height'))) return false;");
            ret.append("    return true;");
            ret.append("}");
            ret.append(admResUtils.loadIsNumber(10));
            ret.append("</script>\n");
        }catch(Exception e) {
            log.error(e);
        }
        return ret.toString();
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        if(paramsRequest.getMode().equalsIgnoreCase("fillStyle")) {
            doEditStyle(request,response,paramsRequest);
        }else {
            super.processRequest(request, response, paramsRequest);
        }
    }

    public void doEditStyle(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        String stel = request.getParameter("stel");
        String[] tkns = stel.split("@",3);

        HashMap tabs = (HashMap)si.getMm(base.getId());
        if( tabs!=null && tkns[1].length()>0 ) {
            try {
                HashMap t = (HashMap)tabs.get(tkns[0]);
                if(tkns[2].equalsIgnoreCase("empty") || tkns[2].length()==0)
                    t.remove(tkns[1]);
                else
                    t.put(tkns[1], tkns[2]);
                StringBuilder css = new StringBuilder();
                Iterator<String> ittabs = tabs.keySet().iterator();
                while(ittabs.hasNext()) {
                    String tab = ittabs.next();
                    css.append(tab);
                    css.append("{");
                    HashMap selectors = (HashMap)tabs.get(tab);
                    Iterator<String> its = selectors.keySet().iterator();
                    while(its.hasNext()) {
                        String l = its.next();
                        css.append(l+":"+selectors.get(l)+";");
                    }
                    css.append("}");
                }
                base.setAttribute("css", css.toString());
                try{
                    base.updateAttributesToDB();
                }catch(Exception e){
                    log.error("Error al guardar la hoja de estilos del recurso: "+base.getId() +"-"+ base.getTitle(), e);
                }
            }catch(IndexOutOfBoundsException iobe) {
                log.error("Error al editar la hoja de estilos del recurso: "+base.getId() +"-"+ base.getTitle(), iobe);
            }
        }
    }

    public String renderGallery(String[] imgpath) {
        return renderGallery(Integer.toString((int)Math.random()*100), 220, 170, false, 2500, 500, 420, 370, "", "", imgpath);
    }

    public String renderGallery(String oid, int width, int height, boolean autoplay, int pause, int fadetime, int fullwidth, int fullheight, String title, String titlestyle, String[] imagepath) {
        StringBuilder out = new StringBuilder();

        out.append("\n<script type=\"text/javascript\" src=\""+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/jquery-imagegallery.js\"></script>");
        out.append("<script type=\"text/javascript\" src=\""+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/jquery-1.3.js\"></script>");

        out.append("<script type=\"text/javascript\"> ");
        out.append("    simpleGallery_navpanel={ ");
        //customize nav panel container
        out.append("        panel: {height:'45px', opacity:0.5, paddingTop:'5px', fontStyle:'bold 9px Verdana'}, ");
        //nav panel images (in that order)
        out.append("        images: [ '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_rewind_blue.png', '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_play_blue.png', '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_fastforward_blue.png', '"+SWBPlatform.getContextPath()+"/swbadmin/js/jquery/themes/control_pause_blue.png'], ");
        //top offset of left, play, and right images, PLUS spacing between the 3 images
        out.append("        imageSpacing: {offsetTop:[-3, 0, -3], spacing:10}, ");
        //duration of slide up animation to reveal panel
        out.append("        slideduration: 500 ");
        out.append("    }; ");

        out.append("    var mygallery=new simpleGallery( { ");
        //ID of main gallery container
        out.append("        wrapperid: 'imggallery_"+ oid +"', ");
        //width/height of gallery in pixels. Should reflect dimensions of the images exactly
        out.append("        dimensions: ["+ width +", "+ height +"], ");
        out.append("        imagearray: [ ");


        for(String image : imagepath) {
            out.append("\n['"+image+"','"+image+"',''],");
        }
        if(imagepath.length>0)
            out.deleteCharAt(out.length()-1);

        out.append("\n      ], ");
        out.append("        autoplay: "+ autoplay +", ");
        out.append("        persist: false, ");
        //pause between slides (milliseconds)
        out.append("        pause: "+ pause +", ");
        //transition duration (milliseconds)
        out.append("        fadeduration: "+ fadetime +", ");
        //event that fires when gallery has initialized/ ready to run
        out.append("        oninit:function(){}, ");
        //event that fires after each slide is shown
        //curslide: returns DOM reference to current slide's DIV (ie: try alert(curslide.innerHTML)
        //i: integer reflecting current image within collection being shown (0=1st image, 1=2nd etc)
        out.append("        onslide:function(curslide, i){} ");
        out.append("        } ");
        out.append("    ); ");
        out.append("</script> ");

        out.append("<div class=\"swb-galeria\"> ");
        out.append("<div class=\"title\">"+ title +"</div> ");
        out.append("<div id=\"imggallery_"+ oid +"\" style=\"position:relative; visibility:hidden\"></div> ");
        out.append("</div> ");
        out.append("</div>\n");

        return out.toString();
    }
}
