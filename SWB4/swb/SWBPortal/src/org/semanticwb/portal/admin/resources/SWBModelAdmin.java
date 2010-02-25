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
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.admin.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Descriptiveable;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author jorge.jimenez
 */
public class SWBModelAdmin extends GenericResource {

    private static Logger log = SWBUtils.getLogger(SWBImportWebSite.class);
    String PATH = SWBPortal.getWorkPath() + "/";
    String WEBPATH = SWBPortal.getWebWorkPath() + "/sitetemplates/";
    String MODELS = PATH + "models/";
    String ZIPDIRECTORY = PATH + "sitetemplates/";

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if (paramRequest.getMode().equals("viewmodel")) {
            doViewModel(request, response, paramRequest);
        } else if (paramRequest.getMode().equals("installmodel")) {
            doInstallModel(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            PrintWriter out = response.getWriter();
            if (request.getParameter("msgKey") != null) {
                out.println("<script type=\"text/javascript\">");
                if(request.getParameter("msgKey").equals("siteCreated")){
                    out.println("parent.addItemByURI(parent.mtreeStore, null, '" + request.getParameter("wsUri") + "');");
                }
                out.println("parent.showStatus('" + paramRequest.getLocaleString(request.getParameter("msgKey")) + "');");
                out.println("</script>");
            }
            SWBResourceURL url = paramRequest.getRenderUrl();
            SWBResourceURL urlAction = paramRequest.getActionUrl();
            StringBuffer strbf = new StringBuffer();
            File file = new File(SWBPortal.getWorkPath() + "/sitetemplates/");
            File[] files = file.listFiles();
            urlAction.setAction("upload");
            //out.println("<iframe id=\"templates\">");
            //out.println("<div id=\"vtemplates\" dojoType=\"dijit.TitlePane\" title=\"Templates existentes de Sitios \" class=\"admViewTemplates\" open=\"true\" duration=\"150\" minSize_=\"20\" splitter_=\"true\" region=\"bottom\">");

            
            out.println("<script type=\"text/javascript\">"+
                   "dojo.require(\"dojo.parser\");" +
                   "dojo.require(\"dijit.layout.ContentPane\");"+
                   "dojo.require(\"dijit.form.Form\");"+
                   "dojo.require(\"dijit.form.ValidationTextBox\");"+
                   "dojo.require(\"dijit.form.Button\");"+
                   "</script>");
          
            out.println("<div class=\"swbform\">");
            out.println("<fieldset>");
            out.println("<legend>" + paramRequest.getLocaleString("existTpls") + "</legend>");
            out.println("<form action=\"" + urlAction.toString() + "\" method=\"post\" enctype='multipart/form-data'>");
            out.println("<table width=\"100%\">");
            out.println("<tr align=\"left\">");
            out.println("<th><b>" + paramRequest.getLocaleString("tpl") + "</b></th>");
            out.println("<th><b>" + paramRequest.getLocaleString("size") + "</b></th>");
            out.println("<th><b>" + paramRequest.getLocaleString("date") + "</b></th>");
            out.println("<th><b>"+paramRequest.getLocaleString("install") +"</b></th>");
            out.println("<th><b>"+paramRequest.getLocaleString("download") + "</b></th>");
            out.println("<th><b>"+paramRequest.getLocaleString("delete") + "</b></th>");
            out.println("<th><b>" + paramRequest.getLocaleString("up2comunity") + "</b></th>");
            out.println("</tr>");
            for (int i = 0; i < files.length; i++) {
                File filex = files[i];
                String fileName = filex.getName();
                if (filex.isFile() && fileName.endsWith(".zip")) {
                    int pos = fileName.lastIndexOf(".");
                    if (pos > -1) {
                        fileName = fileName.substring(0, pos);
                    }
                    out.println("<tr align=\"left\"><td>");
                    url.setParameter("zipName", filex.getAbsolutePath());
                    url.setMode("viewmodel");
                    out.println("<a href=\"" + url.toString() + "\" onclick=\"submitUrl('" + url.toString() + "',this);return false;\">" + fileName + "</a>");
                    out.println("</td><td>");
                    out.println(filex.length() + " bytes");
                    out.println("</td><td>");
                    Date date=new Date(filex.lastModified());
                    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                    out.println(sdf.format(date));
                    out.println("</td></td>");
                    url.setMode("installmodel");
                    url.setAction("form");
                    url.setParameter("fileName", fileName);
                    out.println("<td align=\"center\"><a href=\"" + url.toString() + "\" onclick=\"submitUrl('" + url.toString() + "',this);return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/iconinst.png\" alt=\""+paramRequest.getLocaleString("install") + "\"/></a></td>");
                    out.println("<td align=\"center\"><a href=\"" + WEBPATH + filex.getName() + "\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/icondesin.png\" alt=\""+paramRequest.getLocaleString("download") + "\"/></a></td>");
                    urlAction.setParameter("zipName", filex.getAbsolutePath());
                    urlAction.setAction("delete");
                    out.println("<td align=\"center\"><a href=\"" + urlAction.toString() + "\" onclick=\"submitUrl('" + urlAction.toString() + "',this);return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/iconelim.png\" alt=\""+paramRequest.getLocaleString("delete") + "\"/></a></td>");
                    out.println("<td align=\"left\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/iconsubcom.png\" alt=\""+paramRequest.getLocaleString("up2comunity") + "\"/></td>");
                    out.println("</tr>");
                }
            }
            out.println("</table>");
            out.println("</fieldset>");
            out.println("<fieldset><span align=\"center\">");
            out.println("" + paramRequest.getLocaleString("upload") + "<input type=\"file\" name=\"zipmodel\" value=\"" + paramRequest.getLocaleString("new") + "\"/><br/>");
            //out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button id=\"send\" type=\"submit\"dojoType=\"dijit.form.Button\">"+paramRequest.getLocaleString("up")+"</button>");
            out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\"submit\" id=\"send\" value=\""+paramRequest.getLocaleString("up")+"\"/>");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("</div>");

            out.println("<div class=\"swbform\" id=\"vsites\" dojoType=\"dijit.TitlePane\" title=\""+paramRequest.getLocaleString("sites2Save")+"\" open=\"false\" duration=\"150\" minSize_=\"20\" splitter_=\"true\" region=\"bottom\">");
            out.println("<fieldset>");
            out.println("<legend>" + paramRequest.getLocaleString("existTpls") + "</legend>");
            out.println("<div class=\"swbform\">");
            out.println("<table width=\"75%\">");
            urlAction.setAction("savesite");
            Iterator<WebSite> itws = SWBContext.listWebSites();
            while (itws.hasNext()) {
                WebSite ws = itws.next();
                out.println("<tr><td>");
                urlAction.setParameter("wsid", ws.getId());
                out.println("<a href=\"" + urlAction.toString() + "\" onclick=\"submitUrl('" + urlAction.toString() + "',this);return false;\">" + ws.getDisplayTitle(paramRequest.getUser().getLanguage()) + "</a>");
                out.println("</td></tr>");
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</fieldset>");
            out.println("</div>");

           

            out.println(strbf.toString());
        } catch (Exception e) {
            log.debug(e);
            e.printStackTrace();
        }
    }

    public void doViewModel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<div class=\"swbform\">");
        out.println("<form>");
        out.println("<table width=\"75%\" border=\"1\">");
        out.println("<tr><td colspan=\"2\" align=\"center\"><b>" + paramRequest.getLocaleString("fileContent") + "  " +request.getParameter("zipName") + ":</b></td></tr>");
        out.println("<tr><td align=\"center\"><b>"+paramRequest.getLocaleString("file")+"</b></td><td align=\"center\"><b>"+paramRequest.getLocaleString("size")+" (bytes)</b></td></tr>");
        for (Iterator<ZipEntry> itfiles = SWBUtils.IO.readZip(request.getParameter("zipName")); itfiles.hasNext();) {
            ZipEntry zen = itfiles.next();
            out.println("<tr><td>" + zen.getName() + "</td><td>"+zen.getSize()+"</td></tr>");
        }
        out.println("<tr><td colspan=\"2\" align=\"center\"><button id=\"send\" dojoType=\"dijit.form.Button\" onClick=\"javascript:history.go(-1);\"/>"+ paramRequest.getLocaleString("return") + "</button></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</div>");
    }

    public void doInstallModel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            PrintWriter out = response.getWriter();
            SWBResourceURL urlAction = paramRequest.getActionUrl();
            if (paramRequest.getAction().equals("form")) {
                try {
                    urlAction.setAction("install");
                    out.println("<form class=\"swbform\" id=\"frmImport1\" action=\"" + urlAction.toString() + "\" dojoType=\"dijit.form.Form\" method=\"post\">");
                    out.println("<fieldset>");
                    out.println("<legend>" + paramRequest.getLocaleString("newsitedata") + "</legend>");
                    out.println("<table>");
                    out.append("<tr><td>");
                    out.println(paramRequest.getLocaleString("msgwsTitle"));
                    out.println("</td>");
                    out.append("<td>");
                    out.println("<input type=\"text\" value=\""+request.getParameter("fileName")+"\" name=\"wstitle\" dojoType=\"dijit.form.ValidationTextBox\" required=\"true\" promptMessage=\"Captura Titulo.\" invalidMessage=\"Titulo es requerido.\" onkeyup=\"dojo.byId('swb_create_id').value=replaceChars4Id(this.textbox.value);dijit.byId('swb_create_id').validate()\" trim=\"true\" >");
                    out.println("</td>");
                    out.append("</tr>");
                    out.append("<tr><td>");
                    out.println("ID:");
                    out.println("</td>");
                    out.append("<td>");
                    out.println("<input id=\"swb_create_id\" type=\"text\" value=\""+request.getParameter("fileName")+"\" name=\"wsid\" dojoType=\"dijit.form.ValidationTextBox\" required=\"true\" promptMessage=\"Captura Identificador.\" isValid=\"return canCreateSemanticObject(this.textbox.value);\" invalidMessage=\"Identificador invalido.\" trim=\"true\" >");
                    out.println("</td>");
                    out.append("</tr>");
                    out.println("</table>");
                    out.println("</fieldset>");
                    out.println("<fieldset><span align=\"center\">");
                    //out.append("<tr>");
                    out.println("<button dojoType='dijit.form.Button' type=\"submit\" onClick=\"if(!dijit.byId('frmImport1').isValid()) return false;\">" + paramRequest.getLocaleString("send") + "</button>");
                    out.println("<button id=\"send\" dojoType=\"dijit.form.Button\" onClick=\"javascript:history.go(-1);\">"+paramRequest.getLocaleString("return")+"</button>");
                    //out.println("</td></tr>");
                    out.println("</span></fieldset>");
                    
                    out.println("<input type=\"hidden\" name=\"zipName\" value=\"" + request.getParameter("zipName") + "\"");
                    out.println("</form>");
                } catch (Exception e) {
                    log.debug(e);
                }
            }
        } catch (Exception e) {
            log.debug(e);
        }
    }

    private String parseRdfContent(String rdfcontent, String oldName, String newName, String oldID, String newID, String newNS) {
        Document dom = null;
        try {
            dom = SWBUtils.XML.xmlToDom(rdfcontent);
            NodeList nodeList = dom.getElementsByTagName("rdf:Description");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node nodeDescr = nodeList.item(i);
                NamedNodeMap nodeMap = nodeDescr.getAttributes();
                for (int j = 0; j < nodeMap.getLength(); j++) {
                    String nvalue = nodeMap.item(j).getNodeValue();
                    if (nvalue != null && nvalue.equalsIgnoreCase(newNS + oldID)) {
                        nodeMap.item(j).setNodeValue(newNS + newID); //ver como tengo que poner el newName, si debe ser con minusculas
                        NodeList nlist = nodeDescr.getChildNodes();
                        for (int k = 0; k < nlist.getLength(); k++) {
                            if (nlist.item(k).getNodeName().endsWith("title")) {
                                nlist.item(k).getFirstChild().setNodeValue(newName);
                            }
                        }
                    }
                }
                NodeList nlist = nodeDescr.getChildNodes();
                for (int k = 0; k < nlist.getLength(); k++) {
                    Node node = nlist.item(k);
                    if (node.getPrefix() != null && node.getPrefix().equals(oldID)) {
                        node.setPrefix(newID);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SWBUtils.TEXT.replaceFirstIgnoreCase(SWBUtils.XML.domToXml(dom), "xmlns:" + oldID, "xmlns:" + newID);
    }

    /**
     * Metodo sobrado en este momento, pero servira para cuando un submodelo (sitio), tenga mas submodelos (sitios,repositorios)
     * @param node
     * @param smodels
     */
    private void iteraModels(Node node, HashMap smodels) {
        HashMap submodel = new HashMap();
        NodeList nlChildModels = node.getChildNodes();
        for (int j = 0; j < nlChildModels.getLength(); j++) {
            Node nodeSModel = nlChildModels.item(j);
            if (nodeSModel.getNodeName().equals("type")) { //Revisar si existe el submodel en la instancia a importar
                NodeList nlSite = node.getChildNodes();
                for (int k = 0; k < nlSite.getLength(); k++) {
                    if (nlSite.item(k).getNodeName().equals("id")) {
                        smodels.put(nlSite.item(k).getFirstChild().getNodeValue(), submodel);
                    }
                }
            } else if (nodeSModel.getNodeName().equals("id")) {
                submodel.put("id", nodeSModel.getFirstChild().getNodeValue());
            } else if (nodeSModel.getNodeName().equals("namespace")) {
                submodel.put("namespace", nodeSModel.getFirstChild().getNodeValue());
            } else if (nodeSModel.getNodeName().equals("title")) {
                submodel.put("title", nodeSModel.getFirstChild().getNodeValue());
            } else if (nodeSModel.getNodeName().equals("description")) {
                submodel.put("description", nodeSModel.getFirstChild().getNodeValue());
            }
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        if (response.getAction().equals("upload")) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fu = new ServletFileUpload(factory);
            try {
                Iterator iter = ((List) fu.parseRequest(request)).iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();
                    if (!item.isFormField()) {
                        String value = item.getName();
                        value = value.replace("\\", "/");
                        int pos = value.lastIndexOf("/");
                        if (pos > -1) {
                            value = value.substring(pos + 1);
                        }
                        File fichero = new File(ZIPDIRECTORY);
                        if (!fichero.exists()) {
                            fichero.mkdirs();
                        }
                        fichero = new File(ZIPDIRECTORY + value);
                        item.write(fichero);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.debug(e);
            }
        } else if (response.getAction().equals("delete")) {
            File fichero = new File(request.getParameter("zipName"));
            fichero.delete();
        } else if (response.getAction().equals("savesite")) {
            try {
                String uri = request.getParameter("wsid");
                WebSite site = SWBContext.getWebSite(uri);
                String path = SWBPortal.getWorkPath() + "/";
                String modelspath = path + "models/";
                String zipdirectory = path + "sitetemplates/";
                String zipFile = zipdirectory + site.getId() + ".zip";
                //---------Generación de archivo zip de carpeta work de sitio especificado-------------
                java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(new FileOutputStream(zipFile));
                java.io.File directory = new File(modelspath + site.getId() + "/");
                java.io.File base = new File(modelspath);
                org.semanticwb.SWBUtils.IO.zip(directory, base, zos);
                //Graba archivo cualquiera
                zos.setComment("Model File SemanticWebBuilderOS");
                try {
                    ZipEntry entry = new ZipEntry("readme.txt");
                    zos.putNextEntry(entry);
                    zos.write("Model File SemanticWebBuilderOS".getBytes());
                    zos.closeEntry();
                } catch (Exception e) {
                }

                //-------------Generación de archivo rdf del sitio especificado----------------
                try {
                    File file = new File(zipdirectory + site.getId() + ".nt");
                    FileOutputStream out = new FileOutputStream(file);
                    site.getSemanticObject().getModel().write(out,"N-TRIPLE");
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //----------Generación de archivo siteInfo.xml del sitio especificado-----------
                ArrayList aFiles = new ArrayList();
                File file = new File(zipdirectory + "siteInfo.xml");
                FileOutputStream out = new FileOutputStream(file);
                StringBuffer strbr = new StringBuffer();
                try {
                    strbr.append("<model>\n");
                    strbr.append("<id>" + site.getId() + "</id>\n");
                    strbr.append("<namespace>" + site.getNameSpace() + "</namespace>\n");
                    strbr.append("<title>" + site.getDisplayTitle(response.getUser().getLanguage()) + "</title>\n");
                    strbr.append("<description>" + site.getDisplayDescription(response.getUser().getLanguage()) + "</description>\n");
                    //--------------Generación de submodelos------------------------------------------------
                    Iterator<SemanticObject> sitSubModels = site.getSemanticObject().listObjectProperties(WebSite.swb_hasSubModel);
                    while (sitSubModels.hasNext()) {
                        SemanticObject sObj = sitSubModels.next();
                        File fileSubModel = new File(zipdirectory + "/" + sObj.getId() + ".nt");
                        FileOutputStream rdfout = new FileOutputStream(fileSubModel);
                        sObj.getModel().write(rdfout,"N-TRIPLE");
                        rdfout.flush();
                        rdfout.close();
                        //Agregar c/archivo .rdf de submodelos a arreglo de archivos
                        aFiles.add(fileSubModel);
                        //graba el directorio work de c/submodelo en archivo zip
                        directory = new File(modelspath + sObj.getId() + "/");
                        org.semanticwb.SWBUtils.IO.zip(directory, base, zos);
                        //Genera datos de c/summodelo en archivo siteInfo.xml
                        strbr.append("<model>\n");
                        strbr.append("<type>" + sObj.getSemanticClass() + "</type>\n");
                        //if(obj.instanceOf(WebSite.sclass)) //Que datos saco si es un rep de usuarios o de documentos y como los parseo despues
                        strbr.append("<id>" + sObj.getId() + "</id>\n");
                        strbr.append("<namespace>" + sObj.getModel().getNameSpace() + "</namespace>\n");
                        strbr.append("<title>" + sObj.getProperty(Descriptiveable.swb_title) + "</title>\n");
                        strbr.append("<description>" + sObj.getProperty(Descriptiveable.swb_description) + "</description>\n");
                        strbr.append("</model>\n");
                    }
                    strbr.append("</model>");
                    out.write(strbr.toString().getBytes("utf-8"));
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    log.debug(e);
                }
                zos.close();


                //--------------Agregar archivo rdf y xml generados a arraylist---------------------
                aFiles.add(new File(zipdirectory + site.getId() + ".nt"));
                aFiles.add(new File(zipdirectory + "siteInfo.xml"));
                //--------------Barrer archivos de arrayList para pasar a arreglo de Files y eliminar---
                File[] files2add = new File[aFiles.size()];
                int cont = 0;
                Iterator<File> itFiles = aFiles.iterator();
                while (itFiles.hasNext()) {
                    File filetmp = itFiles.next();
                    files2add[cont] = filetmp;
                    cont++;
                }
                //Agregar archivos rfd de modelo y submodelos y archivo siteInfo.xml a zip existente
                org.semanticwb.SWBUtils.IO.addFilesToExistingZip(new File(zipFile), files2add);
                itFiles = aFiles.iterator();
                while (itFiles.hasNext()) {
                    File filetmp = itFiles.next();
                    filetmp.delete();
                }

                new File(zipdirectory + site.getId() + ".nt").delete();
                new File(zipdirectory + "siteInfo.xml").delete();


                //Envia mensage de estatus en admin de wb
                response.setMode(response.Mode_VIEW);
                response.setRenderParameter("msgKey", "siteExported");
                response.setRenderParameter("wsUri", uri);

            } catch (Exception e) {
                e.printStackTrace();
                log.debug(e);
            }
        }else if (response.getAction().equals("install")) {
            try{
                File file= new File(request.getParameter("zipName"));
                WebSite website=SWBPortal.UTIL.InstallZip(file, "siteInfo.xml", request.getParameter("wsid"), request.getParameter("wstitle"));
                response.setMode(response.Mode_VIEW);
                response.setRenderParameter("msgKey", "siteCreated");
                response.setRenderParameter("wsUri", website.getURI());
        }catch(Exception e){
            log.error(e);
        }           
      }
    }
}
