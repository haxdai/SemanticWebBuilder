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
 
package org.semanticwb.portal.resources.sem;


import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.model.VersionInfo;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.Versionable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.util.ContentUtils;
import org.semanticwb.portal.util.WBFileUpload;

// TODO: Auto-generated Javadoc
/**
 * The Class HTMLContent.
 */
public class HTMLContent extends org.semanticwb.portal.resources.sem.base.HTMLContentBase 
{

    /** Objeto utilizado para generacion de mensajes en el log. */
    private static Logger log = SWBUtils.getLogger(HTMLContent.class);

    /** Ruta relativa para carpeta de archivos asociados a cada version. */
    private static final String FOLDER = "images";

    /** The snpages. */
    int snpages = 15;
    
    /** The stxtant. */
    String stxtant = "Anterior";
    
    /** The stxtsig. */
    String stxtsig = "Siguiente";
    
    /** The stfont. */
    String stfont = "font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"";
    
    /** The position. */
    int position = 1;


    /**
     * Instantiates a new hTML content.
     */
    public HTMLContent()
    {
    }

    /**
     * Instantiates a new hTML content.
     * 
     * @param base the base
     */
    public HTMLContent(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /**
     * Muestra el contenido definido en la version actual del recurso, si no se indica a traves del
     * objeto HttpServletRequest el valor numerico de una version especifica en un parametro
     * de nombre numversion. De lo contrario, se muestra el contenido definido por
     * la version indicada en el parametro.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        WebPage page = paramRequest.getWebPage();
        Resource resource = getResourceBase();

        VersionInfo vi = getActualVersion();

        //System.out.println("Revisando version..."+vi);

        // Genera la version inicial si no existe
        if(null==vi){
            GenericObject go = SWBPlatform.getSemanticMgr().getOntology().getGenericObject(resource.getResourceData().getURI());
            int vnum=1;
            SWBResource swres = (SWBResource) go;
            vi = swres.getResourceBase().getWebSite().createVersionInfo();
            vi.setVersionFile("index.html");
            vi.setVersionNumber(vnum);
            vi.setVersionComment("Versión Inicial");

            Versionable vswres = (Versionable) go;
            vswres.setActualVersion(vi);
            vswres.setLastVersion(vi);


            String rutaFS_target_path = SWBPortal.getWorkPath() + resource.getWorkPath() + "/" + vnum + "/";
            File f = new File(rutaFS_target_path);
            if (!f.exists()) {
                f.mkdirs();
            }

            File ftmpl = new File(SWBPortal.getWorkPath() + resource.getWorkPath() + "/" + vnum + "/index.html");
            Writer output = null;
            try {
                output = new BufferedWriter(new FileWriter(ftmpl));
                output.write(" ");
            } catch(Exception e){}
            finally {
                try{
                    output.close();
                }
                catch(Exception ex){}
            }
        }

        String numversion=request.getParameter("numversion");
        if (numversion != null && numversion.length()>0)
        {
            vi = findVersion(Integer.parseInt(numversion));
        }
        int versionNumber = vi.getVersionNumber();
        String fileName = vi.getVersionFile();

        String resourceWorkPath = SWBPortal.getWorkPath()
                + resource.getWorkPath() + "/" + versionNumber + "/" + fileName;


        String fileContent = SWBUtils.IO.getFileFromPath(resourceWorkPath);
        if(fileContent!=null)
        {
            if(fileContent.indexOf("content=\"Microsoft Word")>0)
            {
                //System.out.println("HtmlContent: Es de Word");
                Resource base=getResourceBase();
                ContentUtils contentUtils = new ContentUtils();
                fileContent = contentUtils.predefinedStyles(fileContent, base, true); //Estilos predefinidos
                //fileContent = contentUtils.predefinedStyles(fileContent, base, isTpred()); //Estilos predefinidos
                //if (isPages())
                {
                    fileContent = contentUtils.paginationMsWord(fileContent, page, request.getParameter("page"), base, snpages, stxtant, stxtsig, stfont, position);
                } //Paginación
            }else
            {
                //System.out.println("HtmlContent: No es de Word");
                fileContent=SWBUtils.TEXT.replaceAll(fileContent,"<workpath/>"
                    ,SWBPortal.getWebWorkPath() + resource.getWorkPath() + "/" + versionNumber + "/");
                //Paginación (Jorge Jiménez-10/Julio/2009)
                if(paramRequest.getLocaleString("txtant")!=null) stxtant=paramRequest.getLocaleString("txtant");
                if(paramRequest.getLocaleString("txtsig")!=null) stxtsig=paramRequest.getLocaleString("txtsig");
                fileContent=new ContentUtils().paginationHtmlContent(fileContent, page, request.getParameter("page"), resource, snpages, stxtant, stxtsig, stfont, position);
                //Termina Páginación
            }
        }

        response.getWriter().println(fileContent);
    }


    /**
     * Presenta el editor de HTML para generar el contenido relacionado a la version
     * indicada por el valor del parametro numversion.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        Resource resource = paramRequest.getResourceBase();
        HttpSession session = request.getSession();
        int versionNumber = Integer.parseInt(request.getParameter("numversion"));
        String fileName = null;
        String action = paramRequest.getAction();
        StringBuffer pathToRead = new StringBuffer(70);
        StringBuffer pathToWrite = new StringBuffer(70);
        String content = "";
        //Para mostrar el contenido de una versión temporal
        String tmpPath = request.getParameter("tmpPath");
        VersionInfo vio = null;

        vio = findVersion(versionNumber);
        fileName = vio.getVersionFile();

        pathToRead.append(resource.getWorkPath() + "/");
        pathToWrite.append("/work" + resource.getWorkPath() + "/");

        if (action.equalsIgnoreCase(SWBParamRequest.Action_EDIT)
                && versionNumber == 0 && tmpPath == null) {
            action = SWBParamRequest.Action_ADD;
        }

        pathToRead.append(versionNumber + "/");
        pathToRead.append(fileName);
        pathToWrite.append("" + (versionNumber));
        session.setAttribute("directory", pathToWrite.toString());

        if (action.equals(SWBParamRequest.Action_EDIT)) {
            try {
                //Cuando se carga el archivo normalmente
                if (tmpPath == null || "".equals(tmpPath)) {
                    content = SWBUtils.IO.readInputStream(
                            SWBPortal.getFileFromWorkPath(pathToRead.toString()));
                    //Se sustituye el tag insertado por el metodo saveContent en lugar de la ruta logica del archivo
                    content = SWBUtils.TEXT.replaceAll(content, "<workpath/>",
                            SWBPortal.getWebWorkPath() + resource.getWorkPath()
                            + "/" + (versionNumber) + "/");
                } else { //cuando se carga el archivo temporal
                    content = SWBUtils.IO.readInputStream(
                            SWBPortal.getFileFromWorkPath(tmpPath + "index.html"));
                }
            } catch (Exception e) {
                content = "Error al leer el archivo";
                e.printStackTrace();
            }
        }

        try {
            request.setAttribute("fileContent", content);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("numversion", versionNumber);
            RequestDispatcher rd = request.getRequestDispatcher(
                    "/swbadmin/jsp/HtmlContentSemAdmin.jsp");
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e);
        }
    }

    /**
     * Determina el metodo a ejecutar en base al modo que se envia en el objeto
     * HttpServletRequest recibido.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {
        if (paramRequest.getMode().equals("saveContent")) {
            saveContent(request, response, paramRequest);
        } else if (paramRequest.getMode().equals("uploadNewVersion")) {
            uploadNewVersion(request, response, paramRequest);
        } else if (paramRequest.getMode().equals("selectFileInterface")) {
            selectFileInterface(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }


    /**
     * Almacena en un archivo con extensi&oacute;n .html el contenido mostrado
     * en el editor, sustituyendo el contenido anterior de la versi&oacute;n
     * indicada por el parametro numversion.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void saveContent(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        Resource resource = paramRequest.getResourceBase();
        String contentPath = (String) request.getSession().getAttribute("directory");
        String textToSave = request.getParameter("EditorDefault");
        boolean deleteTmp = (request.getParameter("operation") != null
                             && !"".equals(request.getParameter("operation")))
                            ? true : false;
        String filename = null;
        boolean textSaved = false;
        int versionNumber = Integer.parseInt(request.getParameter("numversion"));   //version.getVersionNumber();
        int versionToDelete = versionNumber;
        String directoryToRemove = SWBPortal.getWorkPath()
                + resource.getWorkPath() + "/"
                + (versionToDelete > 1 ? versionToDelete : 1) + "/tmp";
        String directoryToCreate = SWBPortal.getWorkPath()
                + resource.getWorkPath() + "/" + (versionNumber) + "/"
                + HTMLContent.FOLDER;
        String workingDirectory = SWBPortal.getWebWorkPath()
                                  + resource.getWorkPath();
        String message = null;

        if (textToSave != null) {
            try {
                //Quito de una de las dos rutas el directorio -work-, ya que
                //las dos lo tienen.
                File filePath = new File(SWBPortal.getWorkPath().substring(0,
                        SWBPortal.getWorkPath().lastIndexOf("/") + 1)
                        + contentPath);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                filePath = new File(directoryToCreate);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                File file = new File(SWBPortal.getWorkPath().substring(0,
                        SWBPortal.getWorkPath().lastIndexOf("/") + 1)
                        + contentPath + "/index.html");
                filename = file.getName();
                FileWriter writer = new FileWriter(file);
                //System.out.println("workingDirectory:"+workingDirectory);

                //Replace WorkPath
                textToSave = SWBUtils.TEXT.replaceAll(textToSave, workingDirectory+"/"+versionNumber+"/", "<workpath/>");

                int i=textToSave.indexOf("<workpath/>");
                while(i>-1)
                {
                    String fileName=textToSave.substring(i+11,textToSave.indexOf("\"",i+11));
                    String s=SWBPortal.getWorkPath()+resource.getWorkPath()+"/"+versionNumber+"/"+fileName;
                    int ls=fileName.indexOf("/");
                    if(ls>-1)
                    {
                        fileName=fileName.substring(ls+1);
                    }
                    //System.out.println("fileName:"+fileName);
                    //Solo copia archivos de versiones anteriores
                    if (s.indexOf(resource.getWorkPath() + "/" + versionNumber) == -1)
                    {
                        SWBUtils.IO.copy(s, directoryToCreate + "/" + fileName, false, "", "");
                    }
                    i=textToSave.indexOf("<workpath/>",i+11);
                }

                writer.write(textToSave);
                writer.flush();
                writer.close();
                textSaved = true;
                if (deleteTmp) {
                    File imagesDirectory = new File(directoryToRemove + "/"
                            + HTMLContent.FOLDER);
                    //eliminar el directorio tmp de la version anterior
                    if (imagesDirectory.exists()
                            && SWBUtils.IO.createDirectory(directoryToCreate)) {

                        //Copia los archivos del directorio tmp al de la nueva version
                        for (String strFile : imagesDirectory.list()) {
                            SWBUtils.IO.copy(imagesDirectory.getPath() + "/" + strFile,
                                    directoryToCreate + "/" + strFile, false,
                                    "", "");
                        }
                    }
                    SWBUtils.IO.removeDirectory(directoryToRemove);
                }
            } catch (Exception e) {
                textSaved = false;
                log.error("Al escribir el archivo", e);
            }
        }
        //Borrar cache
        SWBPortal.getResourceMgr().getResourceCacheMgr().removeResource(resource);
        
        if (textSaved) {
            message = "El contenido ha sido guardado exit&oacute;samente";
        } else {
            message = "Se produjo un error al almacenar la información, intente de nuevo.";
        }
        request.setAttribute("message", message);
        request.setAttribute("numversion", versionNumber);
        this.doEdit(request, response, paramRequest);

    }

    /**
     * Carga un archivo al file system del servidor en un directorio temporal
     * utilizando la interfaz del FCKEditor y el applet DragDrop.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void uploadNewVersion(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws IOException {

        PrintWriter out = response.getWriter();
        StringBuffer bs = new StringBuffer(700);
        WBFileUpload fUpload = new WBFileUpload();
        fUpload.getFiles(request);
        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setCallMethod(url.Call_DIRECT);
        url.setMode("edit");
        Resource resource = paramRequest.getResourceBase();
        //String fileContent = null;
        int numversion = 0;
        String portletWorkPath = null;
        String extension = null;
        String clientFilePath = "";
        String localRelativePath = null;
        String filename = null;

        ArrayList values = fUpload.getValue("numversion");
        int g = 0;
        if (values != null && !values.isEmpty()) {
            numversion = Integer.parseInt(((String) values.get(0)).trim());
        }
        portletWorkPath = SWBPortal.getWorkPath()
                + resource.getWorkPath() + "/" + numversion + "/tmp/";

        File file = new File(portletWorkPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File fileTmp = new File(portletWorkPath + "index.html");
        if (fileTmp.exists()) {
            fileTmp.delete();
        }

        filename = fUpload.getFileName("NewFile");
        filename = filename.replace('\\', '/');
        int i = filename.lastIndexOf("/");
        String strAttaches = fUpload.FindAttaches("NewFile");
        if (i > -1) {
            clientFilePath = filename.substring(0, i + 1);
            filename = filename.substring(i + 1);
        }
        i = filename.lastIndexOf("/");
        if (i != -1) {
            filename = filename.substring(i + 1);
        }
        //Obtiene la extension del archivo cargado
        if (filename.indexOf(".") != -1) {
            extension = filename.substring(filename.lastIndexOf("."));
        }

        if (extension != null && (extension.equalsIgnoreCase(".htm")
                || extension.equalsIgnoreCase(".html"))) {
            fUpload.saveFile("NewFile", portletWorkPath);
            String[] filesAttached = strAttaches.split(";");

            //Almacena la ruta relativa (de la máquina cliente) de los archivos relacionados al html.
            if (filesAttached.length > 0 && filesAttached[0].indexOf("/") != -1) {
                localRelativePath = filesAttached[0].substring(0,
                        filesAttached[0].lastIndexOf("/"));
            }
            file = new File(portletWorkPath + HTMLContent.FOLDER);
            if (!file.exists()) {
                file.mkdir();
            }

            //Renombrar el nuevo archivo
            try {
                //Se cambian las rutas a los archivos asociados.
                if (strAttaches != null && strAttaches.length() > 0 &&
                        localRelativePath != null) {
                    SWBUtils.IO.copy(portletWorkPath + filename,
                            portletWorkPath + "index.html", true,
                            localRelativePath,
                            SWBPortal.getWebWorkPath() + resource.getWorkPath()
                                + "/" + numversion + "/tmp/" + HTMLContent.FOLDER);
                } else {
                    SWBUtils.IO.copy(portletWorkPath + filename,
                            portletWorkPath + "index.html", false, "", "");
                }
            } catch (Exception e) {
                log.debug(e);
            }
            bs.append("\n<html>");
            bs.append("\n<head>");
            bs.append("\n<script type=\"text/javascript\">");
            bs.append("\n  function searchForm() {");
            bs.append("\n      for (var i = 0; i < top.frames.length; i++) {");
            bs.append("\n          var forma = top.frames[i].document.getElementById('newFileForm'); ");
            bs.append("\n          if (forma != undefined) {");
            bs.append("\n              top.frames[i].closeAndReload(window.parent,\"" + localRelativePath + "\");");
            bs.append("\n          }");
            bs.append("\n      }");
            bs.append("\n  }");
            bs.append("\n");
            bs.append("\n  var button = window.parent.document.getElementById(\"PopupButtons\");");
            bs.append("\n  //button.value = \"Cerrar ventana\";");
            bs.append("\n  var cad = '<div align=\"right\">'");
            bs.append("\n          + '<input id=\"btnCancel\" class=\"Button\" type=\"button\" fcklang=\"DlgBtnCancel\"");
            bs.append(" onclick=\"window.frames[\\'frmMain\\'].searchForm();\" value=\"Mostrar archivo cargado\"/>'");
            bs.append("\n          + '</div>'; ");
            bs.append("\n  button.innerHTML = cad;");
            bs.append("\n  ");
            bs.append("\n  ");
            bs.append("\n</script>");
            bs.append("\n</head>");
            bs.append("\n");
            bs.append("\n<body>");
            bs.append("\n  <APPLET WIDTH=\"100%\" HEIGHT=\"100%\" CODE=\"applets.dragdrop.DragDrop.class\" codebase=\""
                    + SWBPlatform.getContextPath()
                    + "/\" archive=\"swbadmin/lib/SWBAplDragDrop.jar, swbadmin/lib/SWBAplCommons.jar\" border=\"0\">");
            bs.append("\n  <PARAM NAME=\"webpath\" VALUE=\"" + SWBPlatform.getContextPath() + "/\">");
            bs.append("\n  <PARAM NAME=\"foreground\" VALUE=\"000000\">");
            bs.append("\n  <PARAM NAME=\"background\" VALUE=\"979FC3\">");
            bs.append("\n  <PARAM NAME=\"foregroundSelection\" VALUE=\"ffffff\">");
            bs.append("\n  <PARAM NAME=\"backgroundSelection\" VALUE=\"666699\">");
            bs.append("\n  <PARAM NAME=\"path\" value=\"" + portletWorkPath + HTMLContent.FOLDER + "/" + "\">");
            bs.append("\n  <PARAM NAME=\"clientpath\" value=\"" + clientFilePath + "\">");
            bs.append("\n  <PARAM NAME=\"files\" value=\"" + strAttaches + "\">");
            bs.append("\n  </APPLET>");
            bs.append("\n</body>");
            bs.append("\n</html>");
            bs.append("\n");
        } else {
            bs.append("\n<html>");
            bs.append("\n<head>");
            bs.append("\n</head>");
            bs.append("\n");
            bs.append("\n<body>");
            bs.append("\n  <p>El archivo seleccionado debe tener extensi&oacute;n .htm o .html, por favor haga otra seleccion.");
            bs.append("\n  <a href=\"javascript:history.go(-1);\">Regresar</a></p>");
            bs.append("\n</body>");
            bs.append("\n</html>");
        }
        out.println(bs.toString());
    }

    /**
     * Muestra la interfaz para que el usuario seleccione un archivo de la m&aacute;quina
     * cliente y lo env&iacute;e al servidor.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void selectFileInterface(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws IOException {

        StringBuffer output = new StringBuffer(800);
        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setCallMethod(url.Call_DIRECT);
        url.setMode("uploadNewVersion");
        String actualcontext = (!"".equals(SWBPlatform.getContextPath())
                               ? "/" + SWBPlatform.getContextPath()
                               : "");
        int numversion = 0;
        try {
            numversion = Integer.parseInt(request.getParameter("numversion"));
        } catch (NumberFormatException nfe) {
            log.debug("Se recibio parametro no numerico", nfe);
        }

        output.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        output.append("\n<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        output.append("\n<head>");
        output.append("\n	<title>Upload Main File</title>");
        output.append("\n	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        output.append("\n	<meta name=\"robots\" content=\"noindex, nofollow\" />");
        output.append("\n	<script src=\"" + actualcontext
                + "/swbadmin/js/fckeditor/editor/dialog/common/fck_dialog_common.js\" type=\"text/javascript\"></script>");
        output.append("\n	<script type=\"text/javascript\">");
        output.append("\n	  var dialog = window.parent ;");
        output.append("\n	  var oEditor = dialog.InnerDialogLoaded() ;");
        output.append("\n	  var FCK = oEditor.FCK ;");
        output.append("\n	  var FCKBrowserInfo = oEditor.FCKBrowserInfo ;");
        output.append("\n	  var FCKTools = oEditor.FCKTools ;");
        output.append("\n	  var FCKRegexLib = oEditor.FCKRegexLib ;");
        output.append("\n	  var FCKLang = oEditor.FCKLang ;");
        output.append("\n	  var FCKConfig = oEditor.FCKConfig ;");
        output.append("\n	  var FCKDebug = oEditor.FCKDebug ;");
        output.append("\n	  var oDOM = FCK.EditorDocument ;");
        output.append("\n	  document.write( FCKTools.GetStyleHtml( GetCommonDialogCss() ) ) ;");
        output.append("\n	  //#### Regular Expressions library.");
        output.append("\n	  var oRegex = new Object() ;");
        output.append("\n	  oRegex.UriProtocol = /^(((http|https|ftp|news):\\/\\/)|mailto:)/gi ;");
        output.append("\n	  oRegex.UrlOnChangeProtocol = /^(http|https|ftp|news):\\/\\/(?=.)/gi ;");
        output.append("\n	  oRegex.UrlOnChangeTestOther = /^((javascript:)|[#\\/\\.])/gi ;");
        output.append("\n	  oRegex.ReserveTarget = /^_(blank|self|top|parent)$/i ;");
        output.append("\n	  var oParser = new Object() ;");
        output.append("\n// This method simply returns the two inputs in numerical order. You can even");
        output.append("\n// provide strings, as the method would parseInt() the values.");
        output.append("\n	  oParser.SortNumerical = function(a, b) {");
        output.append("\n	    return parseInt( a, 10 ) - parseInt( b, 10 ) ;");
        output.append("\n	  }");
        output.append("\n	window.onload = function() {");
        output.append("\n	// First of all, translate the dialog box texts");
        output.append("\n	oEditor.FCKLanguageManager.TranslatePage(document) ;");
        output.append("\n	// Show/Hide the \"Browse Server\" button.");
        output.append("\n	//GetE('divBrowseServer').style.display = FCKConfig.LinkBrowser ? '' : 'none' ;");
        output.append("\n	// Show the initial dialog content.");
        output.append("\n	GetE('divUpload').style.display = '' ;");
        output.append("\n	// Activate the \"OK\" button.");
        output.append("\n	dialog.SetOkButton( true ) ;");
        output.append("\n       window.parent.SetAutoSize( true ) ;");
        output.append("\n}");
        output.append("\n//#### The OK button was hit.");
        output.append("\nfunction Ok() {");
        output.append("\n	sUri = GetE('txtUploadFile').value ;");
        output.append("\n	if ( sUri.length == 0 ) {");
        output.append("\n	    alert( FCKLang.DlnLnkMsgNoUrl ) ;");
        output.append("\n	    return false ;");
        output.append("\n	}");
        output.append("\n       return true;");
        output.append("\n}");
        output.append("\nfunction BrowseServer() {");
        output.append("\n	OpenFileBrowser( FCKConfig.LinkBrowserURL, FCKConfig.LinkBrowserWindowWidth, FCKConfig.LinkBrowserWindowHeight ) ;");
        output.append("\n}");
        output.append("\nfunction OnUploadCompleted( errorNumber, fileUrl, fileName, customMsg ) {");
        output.append("\n	// Remove animation");
        output.append("\n	window.parent.Throbber.Hide() ;");
        output.append("\n	GetE( 'divUpload' ).style.display  = '' ;");
        output.append("\n	switch ( errorNumber ) {");
        output.append("\n		case 0 :	// No errors");
        output.append("\n			alert( 'Your file has been successfully uploaded' ) ;");
        output.append("\n			break ;");
        output.append("\n		case 1 :	// Custom error");
        output.append("\n			alert( customMsg ) ;");
        output.append("\n			return ;");
        output.append("\n		case 101 :	// Custom warning");
        output.append("\n			alert( customMsg ) ;");
        output.append("\n			break ;");
        output.append("\n		case 201 :");
        output.append("\n			alert( 'A file with the same name is already available. The uploaded file has been renamed to \"' + fileName + '\"' ) ;");
        output.append("\n			break ;");
        output.append("\n		case 202 :");
        output.append("\n			alert( 'Invalid file type' ) ;");
        output.append("\n			return ;");
        output.append("\n		case 203 :");
        output.append("\n			alert( \"Security error. You probably don't have enough permissions to upload. Please check your server.\" ) ;");
        output.append("\n			return ;");
        output.append("\n		case 500 :");
        output.append("\n			alert( 'The connector is disabled' ) ;");
        output.append("\n			break ;");
        output.append("\n		default :");
        output.append("\n			alert( 'Error on file upload. Error number: ' + errorNumber ) ;");
        output.append("\n			return ;");
        output.append("\n	}");
        output.append("\n	GetE('frmUpload').reset() ;");
        output.append("\n}");
        output.append("\nvar oUploadAllowedExtRegex	= new RegExp( FCKConfig.LinkUploadAllowedExtensions, 'i' ) ;");
        output.append("\nvar oUploadDeniedExtRegex	= new RegExp( FCKConfig.LinkUploadDeniedExtensions, 'i' ) ;");
        output.append("\nfunction CheckUpload() {");
        output.append("\n	var sFile = GetE('txtUploadFile').value ;");
        output.append("\n	if ( sFile.length == 0 ) {");
        output.append("\n		alert( 'Please select a file to upload' ) ;");
        output.append("\n		return false ;");
        output.append("\n	}");
        output.append("\n	if ( ( FCKConfig.LinkUploadAllowedExtensions.length > 0 && !oUploadAllowedExtRegex.test( sFile ) ) ||");
        output.append("\n		( FCKConfig.LinkUploadDeniedExtensions.length > 0 && oUploadDeniedExtRegex.test( sFile ) ) ) {");
        output.append("\n                Cancel();");
        output.append("\n		return false ;");
        output.append("\n	}");
        output.append("\n	// Show animation");
        output.append("\n	window.parent.Throbber.Show( 100 ) ;");
        output.append("\n	GetE( 'divUpload' ).style.display  = 'none' ;");
        output.append("\n	return true ;");
        output.append("\n}");
        output.append("\n        function fillHiddenPath() { ");
        output.append("\n          var localName = document.frmUpload.NewFile.value; ");
        output.append("\n          document.frmUpload.hiddenPath.value = localName.substring(0, localName.lastIndexOf(\"\\\\\"));");
        output.append("\n        } ");
        output.append("\n    function isOk() {");
        output.append("\n	     if  (Ok()) {");
        output.append("\n	         var ext = document.frmUpload.NewFile.value.substring(document.frmUpload.NewFile.value.lastIndexOf('.'), document.frmUpload.NewFile.value.length);");
        output.append("\n	         if (ext == '.htm' || ext == '.html') {");
        output.append("\n	             document.frmUpload.submit();");
        output.append("\n	         } else { ");
        output.append("\n	             alert('¡Solo puede seleccionar archivos con extensión .htm o .html!');");
        output.append("\n	         }");
        output.append("\n	     }");
        output.append("\n    }");
        output.append("\n	</script>");
        output.append("\n</head>");
        output.append("\n<body scroll=\"no\" style=\"overflow: hidden\">");
        output.append("\n    <div id=\"divUpload\" style=\"display: none\">");
        output.append("\n        <form id=\"frmUpload\" name=\"frmUpload\" method=\"post\" enctype=\"multipart/form-data\" onsubmit=\"Ok();\" ");
        output.append("\n            action=\"" + url.toString() + "\">");
        output.append("\n            <span fcklang=\"DlgLnkUpload\">Upload</span><br />");
        output.append("\n            <input id=\"txtUploadFile\" style=\"width: 100%\" type=\"file\" size=\"40\" name=\"NewFile\" onchange=\"fillHiddenPath();\" /><br />");
        output.append("\n            <input id=\"hiddenPath\" type=\"hidden\" name=\"hiddenPath\" />");
        output.append("\n            <input id=\"hiddennumversion\" type=\"hidden\" name=\"numversion\" value=\"" + numversion + "\" />");
        output.append("\n            <br />");
        output.append("\n            <input id=\"btnUpload\" type=\"button\" value=\"Send it to the Server\" fcklang=\"DlgLnkBtnUpload\" onclick=\"isOk();\"/>");
        output.append("\n        </form>");
        output.append("\n    </div>");
        output.append("\n</body>");
        output.append("\n</html>");
        output.append("\n");

        response.getWriter().println(output.toString());

    }

    /**
     * Encuentra el objeto VersionInfo correspondiente al numero de version recibido.
     * @param versionNumber indica el número de version que se desea obtener
     * @return el objeto VersionInfo que contiene la informaci&oacute;n de la
     * versi&oacute;n del objeto recibido.
     */
    private VersionInfo findVersion(int versionNumber)
    {
        VersionInfo ver = getLastVersion();
        if (null != ver) {
            while (ver.getVersionNumber() != versionNumber) { //
                if (ver.getPreviousVersion() != null) {
                    ver = ver.getPreviousVersion();
                }
            }
        }
        return ver;
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#getModes(javax.servlet.http.HttpServletRequest, org.semanticwb.portal.api.SWBParamRequest)
     */
    @Override
    public String[] getModes(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, IOException 
    {
        String editable=paramRequest.getArgument("editable","false");
        String usergroup=paramRequest.getArgument("usergroup");
        String role=paramRequest.getArgument("role");
        if(editable.equals("true"))
        {
            User user=paramRequest.getUser();
            boolean add=true;
            if(role!=null && !user.hasRole(user.getUserRepository().getRole(role)))add=false;
            if(usergroup!=null && !user.hasRole(user.getUserRepository().getRole(role)))add=false;
            if(add)return new String[]{paramRequest.Mode_VIEW,paramRequest.Mode_EDIT};
        }
        return super.getModes(request, paramRequest);
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#windowSupport(javax.servlet.http.HttpServletRequest, org.semanticwb.portal.api.SWBParamRequest)
     */
    @Override
    public boolean windowSupport(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String editable=paramRequest.getArgument("editable","false");
        String usergroup=paramRequest.getArgument("usergroup");
        String role=paramRequest.getArgument("role");
        if(editable.equals("true"))
        {
            User user=paramRequest.getUser();
            boolean add=true;
            if(role!=null && !user.hasRole(user.getUserRepository().getRole(role)))add=false;
            if(usergroup!=null && !user.hasRole(user.getUserRepository().getRole(role)))add=false;
            if(add)return true;
        }
        return super.windowSupport(request, paramRequest);
    }





}
