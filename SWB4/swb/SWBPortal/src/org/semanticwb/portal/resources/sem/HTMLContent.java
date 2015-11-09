/*
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
 */
package org.semanticwb.portal.resources.sem;

import com.arthurdo.parser.HtmlStreamTokenizer;
import com.arthurdo.parser.HtmlTag;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.semanticwb.model.VersionInfo;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.Versionable;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.util.ContentUtils;
import org.semanticwb.portal.util.WBFileUpload;

/**
 * Componente que permite editar un contenido en HTML utilizando CKEditor.
 */
public class HTMLContent extends org.semanticwb.portal.resources.sem.base.HTMLContentBase 
{
    /** Objeto utilizado para generacion de mensajes en el log. */
    private static Logger log = SWBUtils.getLogger(HTMLContent.class);

    /** Ruta relativa para carpeta de archivos asociados a cada version. */
    protected  static final String FOLDER = "images";

    /** The snpages. */
    protected int snpages = 15;
    
    /** The stxtant. */
    protected String stxtant = "Anterior";
    
    /** The stxtsig. */
    protected String stxtsig = "Siguiente";
    
    /** The stfont. */
    protected String stfont = "font face=\"Verdana, Arial, Helvetica, sans-serif\" size=\"2\" color=\"#000000\"";
    
    /** The position. */
    protected int position = 1;
    
    public static String []swfType = {"swf"};
    public static String []imgTypes = {"tiff", "tif", "gif", "jpeg", "jpg", "jif", "jfif", "jp2", "jpx", "j2k", "j2c", "fpx", "pcd", "png", "svg", "bmp"};
    public static String []docTypes = {"pdf", "doc", "dot", "docx", "docm", "dotx", "dotm", "xls", "xlt", 
            "xlm", "xlsx", "xlsm", "xltx", "xltm", "ppt", "pot", "pps", "pptx", "pptm", "potx", 
            "potm", "ppsx", "ppsm", "pub", "xml", "rtf", "txt", "csv", "odt", "ods", "odp", 
            "odg", "pdf", "eps"};
    public static String []zipTypes = {"a", "ar", "tar", "bz2", "gz", "7z", "rar", "zip", "zipx"};
    
    public static final String ACT_UPLOADFILE = "uploadFile";
    public static final String MOD_UPLOADFILE = "mUploadFile";
    public static final String TYPE_FLASH = "flash";
    public static final String TYPE_DOCS = "document";
    public static final String TYPE_IMAGES = "image";
    public static final String TYPE_ALL = "all";
    public static final String TYPE_ZIP = "zip";
    public static final String ATTR_FILES = "filesMap";

    /**
     * Instantiates a new hTML content.
     */
    public HTMLContent(){}

    /**
     * Instantiates a new hTML content.
     * 
     * @param base the base
     */
    public HTMLContent(org.semanticwb.platform.SemanticObject base) { super(base); }
    
    /**
     * Procesa las peticiones de carga de archivos en el componente.
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse
     * @param paramRequest the SWBParamRequest object
     * @throws SWBResourceException
     * @throws IOException 
     */
    public void doUploadFiles(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        boolean success = false;
        String action = paramRequest.getAction();
        String version = request.getParameter("numversion");
        String type = request.getParameter("type");
        String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
        String CKEditor = request.getParameter("CKEditor");
        String pathToFile = "";
        String msg = "";
        
        if (null == version || version.isEmpty()) version = "1";
        
        String actualcontext = (!"".equals(SWBPlatform.getContextPath()) ? SWBPlatform.getContextPath() : "");
        String workPath = actualcontext+SWBPortal.getWorkPath()+getResourceBase().getWorkPath()+"/"+version+"/images/";
        String webWorkPath = actualcontext+SWBPortal.getWebWorkPath()+getResourceBase().getWorkPath()+"/"+version+"/images/";
        
        ArrayList<String> extensions = HTMLContentUtils.getFileTypes(type);
        
        File wp = new File(workPath);
        if (!wp.exists()) wp.mkdirs();
        
        if (HTMLContentUtils.isEnabledForFileUpload(request) && ACT_UPLOADFILE.equals(action) && ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);

            try {
                List<FileItem> items = sfu.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    if (!item.isFormField()) {
                        String itemName = item.getName();
                        if (HTMLContentUtils.isValidFileType(itemName, extensions)) {
                            String fileName = HTMLContentUtils.sanitizeFileName(itemName);
                            item.write(new File(workPath+fileName));
                            pathToFile = webWorkPath+fileName;
                            break;
                        }
                    }
                }
                success = true;
            } catch (FileUploadException fue) {
                msg = paramRequest.getLocaleString("msgFileUploadError");
                log.error(msg, fue);
            } catch (Exception ex) {
                msg = paramRequest.getLocaleString("msgFileStorageError");;
                log.error(msg, ex);
            }
        }
        
        PrintWriter out = response.getWriter();
        if (null == CKEditor) { //Para el caso de llamada directa, mediante el fileBrowser
            out.write("<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"></head><body><textarea name=\"uploadStatus\">"+(success?"SUCCESS":"FAIL")+"</textarea></body></html>");
        } else if (!CKEditor.isEmpty()) {
            //Escribir el resultado para CKEditor
            out.write("<!DOCTYPE HTML><html><head><meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\"></head><body><script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("+CKEditorFuncNum+", '"+pathToFile+"', '"+msg+"');</script>");
        }
        out.flush();
        out.close();
    }

    /**
     * Limpia estilos en el documento
     * @param datos código HTML
     * @param deletesytyles Indica si se eliminarán los estilos
     * @return HTML limpio
     */
    public static String cleanHTML(String datos, boolean deletesytyles)
    {
        HtmlStreamTokenizer tok = new HtmlStreamTokenizer(new ByteArrayInputStream(datos.getBytes()));
        StringBuilder ret = new StringBuilder();
        HtmlTag tag = new HtmlTag();
        boolean omit = false;
        try
        {
            while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF)
            {
                int ttype = tok.getTokenType();
                if (ttype == HtmlStreamTokenizer.TT_TAG || ttype == HtmlStreamTokenizer.TT_COMMENT)
                {
                    if (ttype == HtmlStreamTokenizer.TT_COMMENT && tok.getRawString().equals("<!-- -->"))
                    {
                        continue;
                    }
                    tok.parseTag(tok.getStringValue(), tag);

                    if (tok.getRawString().toLowerCase().startsWith("<!--[if"))
                    {
                        continue;
                    }
                    else if (deletesytyles && tag.getTagString().toLowerCase().equals("style") && !tag.isEndTag())
                    {
                        omit = true;
                    }
                    else if (deletesytyles && tag.getTagString().toLowerCase().equals("style") && tag.isEndTag())
                    {
                        omit = false;
                    }
                    else if (deletesytyles && (tag.getTagString().toLowerCase().equals("font") || tag.getTagString().toLowerCase().equals("o:p")))
                    {
                    }
                    else if (deletesytyles && (tag.getTagString().toLowerCase().equals("b") || tag.getTagString().toLowerCase().equals("br") || tag.getTagString().toLowerCase().equals("div") || tag.getTagString().toLowerCase().equals("td") || tag.getTagString().toLowerCase().equals("tr") || tag.getTagString().toLowerCase().equals("table") || tag.getTagString().toLowerCase().equals("p") || tag.getTagString().toLowerCase().equals("span")) && !tag.isEndTag() && !tag.isEmpty())
                    {
                        boolean exists = false;
                        int params = tag.getParamCount();
                        for (int i = 0; i < params; i++)
                        {
                            String name = tag.getParamName(i);
                            if (name.toLowerCase().equals("style") || name.toLowerCase().equals("lang") || name.toLowerCase().equals("class"))
                            {
                                exists = true;
                            }
                        }
                        if (!exists)
                        {
                            ret.append(tok.getRawString());
                        }
                        else
                        {
                            ret.append("<");
                            ret.append(tag.getTagString());
                            Enumeration names = tag.getParamNames();
                            while (names.hasMoreElements())
                            {
                                String name = names.nextElement().toString();
                                String svalue = tag.getParam(name);
                                if (!(name.toLowerCase().equals("style") || name.toLowerCase().equals("lang") || name.toLowerCase().equals("class")))
                                {
                                    ret.append(" ");
                                    ret.append(name);
                                    ret.append("=\"");
                                    ret.append(svalue);
                                    ret.append("\"");
                                }
                            }
                            ret.append(">");
                        }
                    }
                    else if ((tag.getTagString().toLowerCase().equals("body") || tag.getTagString().toLowerCase().equals("head") || tag.getTagString().toLowerCase().equals("title") || tag.getTagString().toLowerCase().equals("meta") || tag.getTagString().toLowerCase().equals("html") || tag.getTagString().toLowerCase().equals("link"))&&tag.getTagString().trim().length()>0&&!tag.isEmpty())
                    {
                        if (tag.getTagString().toLowerCase().equals("title") && !tag.isEndTag())
                        {
                            tok.nextToken();
                            //System.out.println("tok-------------:"+tok!=null?tok.getStringValue():"null");
                            if(tok.getStringValue().toString().trim().length()==0) continue;
                            tok.parseTag(tok.getStringValue(), tag);
                            ttype = tok.getTokenType();
                            if (ttype == HtmlStreamTokenizer.TT_TEXT)
                            {
                                tok.nextToken();
                                tok.parseTag(tok.getStringValue(), tag);
                                ttype = tok.getTokenType();
                                if (ttype == HtmlStreamTokenizer.TT_TAG && tag.isEndTag() && tag.getTagString().toLowerCase().equals("title"))
                                {
                                    continue;
                                }
                            }
                            else if (ttype == HtmlStreamTokenizer.TT_TAG && tag.isEndTag() && tag.getTagString().toLowerCase().equals("title"))
                            {
                                continue;

                            }

                        }
                        else
                        {
                            continue;
                        }
                    }
                    else if (tag.getTagString().toLowerCase().equals("a")&&!tag.isEmpty())
                    {
                        String value = tag.getParam("href");
                        if (value != null && value.startsWith("docrep://")) // liga al repositorio
                        {
                            value = value.substring(8);
                            if (value.startsWith("//"))
                            {
                                value = value.substring(1);
                            }
                            String path = SWBPortal.getDistributorPath() + value;
                            ret.append("<a");
                            Enumeration names = tag.getParamNames();
                            while (names.hasMoreElements())
                            {
                                String name = names.nextElement().toString();
                                String svalue = tag.getParam(name);
                                if (!name.toLowerCase().equals("href"))
                                {
                                    if (deletesytyles && !(name.toLowerCase().equals("style") || name.toLowerCase().equals("lang") || name.toLowerCase().equals("class")))
                                    {
                                        ret.append(" ");
                                        ret.append(name);
                                        ret.append("=\"");
                                        ret.append(svalue);
                                        ret.append("\"");
                                    }
                                    else
                                    {
                                        ret.append(" ");
                                        ret.append(name);
                                        ret.append("=\"");
                                        ret.append(svalue);
                                        ret.append("\"");
                                    }
                                }
                                else
                                {
                                    ret.append(" ");
                                    ret.append(name);
                                    ret.append("=\"");
                                    ret.append(path);
                                    ret.append("\"");
                                }


                            }
                            ret.append(">");
                        }
                        else
                        {
                            if (!omit)
                                ret.append(tok.getRawString());
                        }
                    }
                    else
                    {
                        if (!omit)
                            ret.append(tok.getRawString());
                    }
                }
                else if (ttype == HtmlStreamTokenizer.TT_TEXT)
                {
                    if (!omit)
                        ret.append(tok.getRawString());
                }

            }
        }
        catch (Exception e)
        {
            log.error(e);
        }
        return ret.toString().replace("<span></span>", "").replace("<span> </span>", "");
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
            throws SWBResourceException, IOException {
        WebPage page = paramRequest.getWebPage();
        Resource resource = getResourceBase();
        VersionInfo vi = getActualVersion();

        // Genera la version inicial si no existe
        if (null == vi) {
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
        if (numversion != null && numversion.length() > 0) {
            vi = findVersion(Integer.parseInt(numversion));
        }
        int versionNumber = vi.getVersionNumber();
        String fileName = vi.getVersionFile();

        String resourceWorkPath = SWBPortal.getWorkPath()
                + resource.getWorkPath() + "/" + versionNumber + "/" + fileName;

        String fileContent = SWBUtils.IO.getFileFromPath(resourceWorkPath);
        if (fileContent != null) {
            boolean paginated = false;
            try {
                paginated = this.isContentPaginated();
            } catch (Exception e) {
                log.error("HTMLContent - Getting \"paginated\" property", e);
            }
            if (fileContent.indexOf("content=\"Microsoft Word") > 0) {
                fileContent = SWBUtils.TEXT.replaceAll(fileContent, "<workpath/>",
                    SWBPortal.getWebWorkPath() + resource.getWorkPath() + "/" + versionNumber + "/");
                boolean deleteStyles = false;
                try {
                    deleteStyles = this.isDeleteStyles();
                } catch (Exception e) {
                    log.error("HTMLContent - Getting \"deleteStyles\" property.", e);
                }
                ContentUtils contentUtils = new ContentUtils();
                fileContent = contentUtils.predefinedStyles(fileContent, resource, true); //Estilos predefinidos
                //fileContent = contentUtils.predefinedStyles(fileContent, base, isTpred()); //Estilos predefinidos
                if (paginated) {
                    fileContent = contentUtils.paginationMsWord(request,fileContent, page, request.getParameter("page"), resource, snpages, stxtant, stxtsig, stfont, position);
                }//Paginación
                fileContent = cleanHTML(fileContent, deleteStyles);
            } else {
                fileContent = SWBUtils.TEXT.replaceAll(fileContent, "<workpath/>",
                    SWBPortal.getWebWorkPath() + resource.getWorkPath() + "/" + versionNumber + "/");
                //Paginación (Jorge Jiménez-10/Julio/2009)
                if (this.getFormerLinkText() != null && !"".equalsIgnoreCase(this.getFormerLinkText())) {
                    stxtant = this.getFormerLinkText();
                } else if (paramRequest.getLocaleString("txtant") != null) {
                    stxtant = paramRequest.getLocaleString("txtant");
                }
                if (this.getNextLinkText() != null && !"".equalsIgnoreCase(this.getNextLinkText())) {
                    stxtsig = this.getNextLinkText();
                } else if (paramRequest.getLocaleString("txtsig") != null) {
                    stxtsig = paramRequest.getLocaleString("txtsig");
                }
                if (paginated) {
                    fileContent = new ContentUtils().paginationHtmlContent(request,fileContent, page, request.getParameter("page"), resource, snpages, stxtant, stxtsig, stfont, position,request.getParameter("uri"));
                }
                //Termina Páginación
            }
            fileContent = SWBUtils.TEXT.replaceAll(fileContent, "<webpath/>",SWBPortal.getContextPath());
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
        int versionNumber = Integer.parseInt(request.getParameter("numversion"));
        String fileName = null;
        String action = paramRequest.getAction();
        StringBuilder pathToRead = new StringBuilder(64);
        //comentar siguiente linea
        StringBuilder pathToWrite = new StringBuilder(64);
        String content = "";
        //Para mostrar el contenido de una versión temporal
        String tmpPath = request.getParameter("tmpPath");
        VersionInfo vio = findVersion(versionNumber);
        fileName = vio.getVersionFile();

        pathToRead.append(resource.getWorkPath()).append("/");
        //siguiente linea tenía "work/" en lugar de "SWBPortal.getWebWorkPath()"
        String webWorkpath = SWBPortal.getWebWorkPath();
        pathToWrite.append(webWorkpath).append(resource.getWorkPath()).append("/");

        if (action.equalsIgnoreCase(SWBParamRequest.Action_EDIT)
                && versionNumber == 0 && tmpPath == null) {
            action = SWBParamRequest.Action_ADD;
        }

        pathToRead.append(versionNumber).append("/");
        pathToRead.append(fileName);
        //comentar siguientes 2 lineas
        pathToWrite.append(String.valueOf(versionNumber)).append("/");
        request.setAttribute("directory", pathToWrite.toString());

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
                content = paramRequest.getLocaleString("msgFileReadError");
                log.error("Error al leer el archivo del HTMLContent - Id: " + resource.getId(), e);
            }
        }

        try {
            response.setContentType("text/html;charset=ISO-8859-1");
            request.setAttribute("fileContent", content);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("numversion", versionNumber);
            RequestDispatcher rd = request.getRequestDispatcher("/swbadmin/jsp/HtmlContentSemAdmin.jsp");
            rd.include(request, response);
        } catch (Exception e) {
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
        } else if (MOD_UPLOADFILE.equals(paramRequest.getMode())) {
            doUploadFiles(request, response, paramRequest);
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
        String contentPath = resource.getWorkPath() + "/";
        String textToSave = request.getParameter("EditorDefault");
        boolean deleteTmp = (request.getParameter("operation") != null
                && !"".equals(request.getParameter("operation")));
        String filename = null;
        boolean textSaved = false;
        int versionNumber = Integer.parseInt(request.getParameter("numversion"));
        
        contentPath+=versionNumber;
        
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
        VersionInfo vio = null;

        vio = findVersion(versionNumber);
        if (vio != null) {
            filename = vio.getVersionFile();
        } else {
            filename = "index.html";
        }

        if (textToSave != null) {
            try {
                File filePath = new File(SWBPortal.getWorkPath() + contentPath);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                filePath = new File(directoryToCreate);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                File file = new File(SWBPortal.getWorkPath() + contentPath + "/" + filename);
                filename = file.getName();
                FileWriter writer = new FileWriter(file);
                

                if (deleteTmp) {
                    //modifica las rutas de los archivos asociados si se acaba de cargar un archivo HTML antes de guardar
                    String directorioSinTmp = SWBPortal.getWebWorkPath()
                            + resource.getWorkPath() + "/"
                            + (versionToDelete > 1 ? versionToDelete : 1) + "/";
                    String directorioConTmp = directorioSinTmp + "tmp/";
                    textToSave = SWBUtils.TEXT.replaceAll(textToSave, directorioConTmp, directorioSinTmp);
                }
                //Remplaza del contenido las rutas de los archivos relacionados por <workpath/>
                textToSave = SWBUtils.TEXT.replaceAll(textToSave, workingDirectory+"/"+versionNumber+"/", "<workpath/>");

                int i = textToSave.indexOf("<workpath/>");
                //Parsea el contenido en busca de imagenes que no tengan ruta absoluta desde /work...
                while (i > -1) {
                    try {
                        String delimiter = "" + textToSave.charAt(i - 1);
                        if (!delimiter.equalsIgnoreCase("\"") && !delimiter.equalsIgnoreCase("'")) {
                            delimiter = " ";
                        }
                        String fileName = textToSave.substring(i + 11, textToSave.indexOf(delimiter, i + 11));
                        String s = SWBPortal.getWorkPath() + resource.getWorkPath() + "/" + versionNumber + "/" + fileName;
                        int ls = fileName.indexOf("/");
                        if (ls > -1) {
                            fileName = fileName.substring(ls + 1);
                        }
                        //Solo copia archivos de versiones anteriores
                        if (!s.contains(resource.getWorkPath() + "/" + versionNumber)) {
                            SWBUtils.IO.copy(s, directoryToCreate + "/" + fileName, false, "", "");
                        }
                    } catch (Exception e) {
                        log.error("Al barrer el contenido buscando archivos asociados", e);
                    }
                    i = textToSave.indexOf("<workpath/>", i + 11);
                }
                
//                System.out.println("textToSave2:"+textToSave);

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
        SWBPortal.getServiceMgr().updateTraceable(resource.getSemanticObject(), paramRequest.getUser());
        
        if (textSaved) {
            message = paramRequest.getLocaleString("msgContentSaved");
        } else {
            message = paramRequest.getLocaleString("msgContentSaveFailed");
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
        StringBuilder bs = new StringBuilder(256);
        WBFileUpload fUpload = new WBFileUpload();
        fUpload.getFiles(request);
        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setCallMethod(SWBResourceURL.Call_DIRECT);
        url.setMode("edit");
        Resource resource = paramRequest.getResourceBase();
        //String fileContent = null;
        int numversion = 0;
        String portletWorkPath = null;
        String extension = null;
        String clientFilePath = "";
        String localRelativePath = null;
        String filename = null;
        String hiddenPath = null;

        ArrayList values = fUpload.getValue("numversion");
        int g = 0;
        if (values != null && !values.isEmpty()) {
            numversion = Integer.parseInt(((String) values.get(0)).trim());
        }

        values = fUpload.getValue("hiddenPath");
        if (values != null && !values.isEmpty()) {
            hiddenPath = ((String) values.get(0)).trim();
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
        clientFilePath = hiddenPath;
        i = filename.lastIndexOf("/");
        if (i != -1) {
            filename = filename.substring(i + 1);
        }
        //Obtiene la extension del archivo cargado
        if (filename.contains(".")) {
            extension = filename.substring(filename.lastIndexOf("."));
        }

        if (extension != null && (extension.equalsIgnoreCase(".htm")
                || extension.equalsIgnoreCase(".html"))) {
            fUpload.saveFile("NewFile", portletWorkPath);
            String[] filesAttached = strAttaches.split(";");

            //Almacena la ruta relativa (de la máquina cliente) de los archivos relacionados al html.
            if (filesAttached.length > 0 && filesAttached[0].contains("/")) {
                localRelativePath = filesAttached[0].substring(0,
                        filesAttached[0].lastIndexOf("/"));
            } else if (filesAttached.length > 0 && !filesAttached[0].contains("/")) {
                localRelativePath = "";
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
                    if (localRelativePath.length() > 0) {
                        SWBUtils.IO.copy(portletWorkPath + filename,
                                portletWorkPath + "index.html", true,
                                localRelativePath,
                                SWBPortal.getWebWorkPath() + resource.getWorkPath()
                                    + "/" + numversion + "/tmp/" + HTMLContent.FOLDER);
                    } else {
                        SWBUtils.IO.copy(portletWorkPath + filename,
                                portletWorkPath + "index.html", false, "", "");
                    }
                    checkPathsInFile(SWBPortal.getWorkPath() + resource.getWorkPath() + "/" + numversion + "/tmp/index.html",
                            filesAttached, SWBPortal.getWebWorkPath() + resource.getWorkPath() + "/" + numversion + "/tmp/" + HTMLContent.FOLDER);
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
            bs.append("\n              top.frames[i].closeAndReload(window.parent,\"").append(localRelativePath).append("\");");
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
            bs.append("\n  <APPLET WIDTH=\"100%\" HEIGHT=\"100%\" CODE=\"applets.dragdrop.DragDrop.class\" codebase=\"")
                    .append(SWBPlatform.getContextPath())
                    .append("/\" archive=\"swbadmin/lib/SWBAplDragDrop.jar, swbadmin/lib/SWBAplCommons.jar\" border=\"0\">");
            bs.append("\n  <PARAM NAME=\"webpath\" VALUE=\"").append(SWBPlatform.getContextPath()).append("/\">");
            bs.append("\n  <PARAM NAME=\"foreground\" VALUE=\"000000\">");
            bs.append("\n  <PARAM NAME=\"background\" VALUE=\"979FC3\">");
            bs.append("\n  <PARAM NAME=\"foregroundSelection\" VALUE=\"ffffff\">");
            bs.append("\n  <PARAM NAME=\"backgroundSelection\" VALUE=\"666699\">");
            bs.append("\n  <PARAM NAME=\"path\" value=\"").append(portletWorkPath).append(HTMLContent.FOLDER).append("/").append("\">");
            bs.append("\n  <PARAM NAME=\"clientpath\" value=\"").append(clientFilePath).append("\">");
            bs.append("\n  <PARAM NAME=\"files\" value=\"").append(strAttaches).append("\">");
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
     * Check paths in file.
     * 
     * @param filePath the file path
     * @param filesAttached the files attached
     * @param pathToAdd the path to add
     */
    private void checkPathsInFile(String filePath, String[] filesAttached, String pathToAdd) {
        File file = new File(filePath);
        StringBuilder contentRead = null;
        boolean failure = false;
        if (file.exists() && filesAttached != null && filesAttached.length > 0) {

            //Lectura del contenido del archivo index.html en el directorio tmp
            try {
                BufferedReader in = new BufferedReader(new FileReader(filePath));
                contentRead = new StringBuilder(1024);
                String lineRead = in.readLine();
                while (lineRead != null) {
                    StringBuilder sbMod = null;
                    //Se busca cada archivo asociado en el contenido del HTML
                    sbMod = new StringBuilder(512);
                    for (int i = 0; i < filesAttached.length; i++) {
                        String attachment = filesAttached[i];
                        int index = 0;

                        //Solo se modifican las rutas de los archivos que se encontraban
                        //en la misma carpeta que el archivo HTML
                        if (attachment.indexOf('/') == -1) {
                            while (lineRead.indexOf(attachment, index) > -1) {
                                int indexFound = lineRead.indexOf(attachment, index);
                                char charBefore = lineRead.charAt(indexFound - 1);

                                //Se agrega la ruta de la carpeta tmp si el archivo asociado estaba almacenado en la misma carpeta que el HTML
                                if (charBefore == '\"' || charBefore == '=' || charBefore == '\'') {
                                    sbMod.append(lineRead.substring(index, indexFound));
                                    sbMod.append(pathToAdd);
                                    sbMod.append("/");
                                    sbMod.append(attachment);
                                    sbMod.append(lineRead.substring(indexFound + attachment.length(), lineRead.length()));
                                }
                                index = indexFound + attachment.length();
                            }
                        }
                    }
                    if (sbMod != null && sbMod.length() > 0) {
                        contentRead.append(sbMod);
                    } else {
                        contentRead.append(lineRead);
                    }
                    
                    contentRead.append("\n");
                    lineRead = in.readLine();
                }
                in.close();
                in = null;
            } catch (FileNotFoundException fnfe) {
                failure = true;
                log.error("File not found after uploading HTML file.", fnfe);
            } catch (IOException ioe) {
                failure = true;
                log.error("I/O error after uploading HTML file", ioe);
            }
            if (failure) {
                return;
            }

            //Se escribe el nuevo contenido del archivo index.html en la carpeta tmp
            try {
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
                if (null != contentRead) {
                    out.print(contentRead.toString());
                }
                out.flush();
                out.close();
                out = null;
            } catch (IOException ioe) {
                log.error("Error writing HTMLContent file's content, after uploading a HTML file.", ioe);
            }
        }
    }

    /**
     * Muestra un explorador de archivosal insertar elementos mediante el editor HTML.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private void selectFileInterface(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws IOException {
        String actualcontext = (!"".equals(SWBPlatform.getContextPath()) ? SWBPlatform.getContextPath() : "");
        String version = (request.getParameter("numversion") != null && !"".equals(request.getParameter("numversion"))) ? request.getParameter("numversion") : "1";
        String jsp = actualcontext + "/swbadmin/jsp/HTMLContentUploadDialog.jsp";
        String fileType = request.getParameter("type");
        if (null == fileType) fileType = "";
        
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        ArrayList types = HTMLContentUtils.getFileTypes(fileType);
        
        try {
            response.setContentType("text/html;charset=ISO-8859-1");//Forced because of encoding problems
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute(ATTR_FILES, getFileList(request, version, types));
            rd.include(request, response);
        } catch (Exception ex) {
            log.error(ex);
        }
    }

    /**
     * Encuentra el objeto VersionInfo correspondiente al numero de version recibido.
     * @param versionNumber indica el número de version que se desea obtener
     * @return el objeto VersionInfo que contiene la informaci&oacute;n de la
     * versi&oacute;n del objeto recibido.
     */
    protected  VersionInfo findVersion(int versionNumber) {
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
            if(add)return new String[]{SWBParamRequest.Mode_VIEW,SWBParamRequest.Mode_EDIT};
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
    
    /**
     * Obtiene la lista de archivos relacionados a una versión del contenido.
     * @param hsr The HttpServletRequest object
     * @param version Cadena de versión del contenido.
     * @param allowedTypes Arreglo de cadenas con las extensiones a considerar en el listado.
     * @return Mapa con la lista de archivos de la versión del contenido y su tamaño.
     */
    public Map<String, Long> getFileList(HttpServletRequest hsr, String version, ArrayList<String> allowedTypes) {
        Map<String, Long> files = new TreeMap<String, Long>();
        Resource base = getResourceBase();
        String resPath = SWBPlatform.getContextPath()+SWBPortal.getWorkPath()+base.getWorkPath()+"/"+version+"/images/";
        
        if (HTMLContentUtils.isEnabledForFileBrowsing(hsr)) {
            final File resourcePath = new File(resPath);
            if (resourcePath.exists() && resourcePath.isDirectory()) {
                for (final File fileEntry : resourcePath.listFiles(new ExtFilter(allowedTypes))) {
                    files.put(fileEntry.getName(), fileEntry.length());
                }
            }
        }
        return files;
    }
    
    /**
     * Filtro para el listado de archivos en la vista de navegación.
     * Por defecto omite subdirectorios pues no es necesario listarlos en el contexto del componente.
     */
    private class ExtFilter implements FileFilter {
        private ArrayList<String> types = new ArrayList<String>();
        private boolean showHidden = false;
        
        /**
         * Constructor por defecto. 
         * Crea una instancia de {@code ExtFileFilter}.
         * No debe ser usado pues no listará ningún archivo.
         */
        public ExtFilter () {}
        
        /**
         * Constructor.
         * Crea una instancia de {@code ExtFileFilter} con la lista de extensiones válidas en el listado.
         * @param allowedTypes ArrayList con las extensiones a considerar en el listado.
         */
        public ExtFilter(ArrayList<String> allowedTypes) {
            types = allowedTypes;
        }
        
        /**
         * Constructor.
         * Crea una instancia de {@code ExtFileFilter} con la lista de extensiones válidas en el listado.
         * @param allowedTypes ArrayList con las extensiones a considerar en el listado.
         * @param showHiddenFiles Indica si se deben mostrar los archivos marcados como ocultos.
         */
        public ExtFilter(ArrayList<String> allowedTypes, boolean showHiddenFiles) {
            showHidden = showHiddenFiles;
            types = allowedTypes;
        }
        
        @Override
        public boolean accept(File pathname) {
            if (pathname.isDirectory()) return false;
            if (!showHidden && pathname.isHidden()) return false;
            
            String path = pathname.getAbsolutePath().toLowerCase();
            for (int i = 0, n = types.size(); i < n; i++) {
              String extension = types.get(i);
              if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                return true;
              }
            }
            return false;
        }
        
        /**
         * Establece las extensiones válidas para el listado.
         * @param allowedTypes Array de cadenas con las extensiones válidas.
         */
        public void setAllowedTypes(String []allowedTypes) {
            if (null != allowedTypes && allowedTypes.length > 0) {
                types.addAll(Arrays.asList(allowedTypes));
            }
        }
        
        /**
         * Obtiene la lista de extensiones válidas para el listado.
         * @return Arreglo con las extensiones válidas.
         */
        public String[] getAllowedTypes () {
            return types.toArray(new String[types.size()]);
        }
    }
    
    public static class HTMLContentUtils {
        /**
         * Valida si el usuario en sesión tiene permisos suficientes para subir archivos mediante el explorador del widget.
         * @param hsr The request.
         * @return true si el usuario tiene permisos para subir archivos, false en otro caso.
         */
        public static boolean isEnabledForFileUpload(HttpServletRequest hsr) {
            WebSite site = SWBContext.getAdminWebSite();
            User user = SWBPortal.getUserMgr().getUser(hsr, site);
            SWBContext.setSessionUser(user);
            return user.haveAccess(site.getHomePage());
        }

        /**
         * Valida si el usuario en sesión tiene permisos suficientes para navegar por la estructura de archivos mediante el explorador del widget.
         * @param hsr The request.
         * @return true si el usuario tiene permisos para navegar por la estructura de archivos, false en otro caso.
         */
        public static boolean isEnabledForFileBrowsing(HttpServletRequest hsr) {
            WebSite site = SWBContext.getAdminWebSite();
            User user = SWBPortal.getUserMgr().getUser(hsr, site);
            SWBContext.setSessionUser(user);
            return user.haveAccess(site.getHomePage());
        }
        
        /**
         * Elimina caracteres especiales del nombre del archivo para evitar conflicto con rutas directas.
         * @param fileName Nombre original del archivo.
         * @return Nombre de archivo sanitizado, sin caracteres especiales.
         */
        public static String sanitizeFileName(String fileName) {
            String ret = fileName;
            
            if (ret.lastIndexOf(".") > -1) {
                String tfname = ret.substring(0, ret.lastIndexOf("."));
                String tfext = ret.substring(ret.lastIndexOf("."), ret.length());
                ret = SWBUtils.TEXT.replaceSpecialCharactersForFile(tfname, ' ', true) + tfext;
            } else {
                ret = SWBUtils.TEXT.replaceSpecialCharactersForFile(ret, ' ', true);
            }
            return ret;
        }
        
        /**
         * Verifica si un archivo cuenta con la extensión determinada en una lista de exensiones válidas.
         * @param fileName Nombre de archivo a comprobar.
         * @param types Lista de extensiones permitidas.
         * @return true si el archivo contiene alguna de las extensiones permitidas, false en otro caso.
         */
        public static boolean isValidFileType(String fileName, ArrayList<String> types) {
            String path = fileName.toLowerCase();
            for (int i = 0, n = types.size(); i < n; i++) {
                String extension = types.get(i);
                if ((path.endsWith(extension) && (path.charAt(path.length() - extension.length() - 1)) == '.')) {
                    return true;
                }
            }
            return false;
        }
        
        /**
         * Obtiene la lista de extensiones dependiendo del filtro seleccionado.
         * @param typeFilter Alguno entre image|document|flash|zip|all 
         * @return Lista de extensiones filtradas por tipo.
         */
        public static ArrayList<String> getFileTypes(String typeFilter) {
            ArrayList types = new ArrayList<String>();
            if (TYPE_ALL.equals(typeFilter) || TYPE_FLASH.equals(typeFilter)) {
                types.addAll(Arrays.asList(swfType));
            }
            if (TYPE_ALL.equals(typeFilter) || TYPE_DOCS.equals(typeFilter)) {
                types.addAll(Arrays.asList(docTypes));
            }
            if (TYPE_ALL.equals(typeFilter) || TYPE_IMAGES.equals(typeFilter)) {
                types.addAll(Arrays.asList(imgTypes));
            }
            if (TYPE_ALL.equals(typeFilter) || TYPE_ZIP.equals(typeFilter)) {
                types.addAll(Arrays.asList(zipTypes));
            }
            return types;
        }
    }
}
