package mx.gob.stps.portalempleo.swb.resources;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import javax.servlet.http.*;
import mx.gob.stps.portalempleo.swb.search.Search;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.User;
import org.semanticwb.model.VersionInfo;
import org.semanticwb.model.Versionable;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.indexer.SWBIndexer;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.portal.util.ContentUtils;

public class HTMLReferencedContent extends mx.gob.stps.portalempleo.swb.resources.base.HTMLReferencedContentBase 
{
    private static Logger log = SWBUtils.getLogger(HTMLReferencedContent.class);

    public HTMLReferencedContent()
    {
    }

   /**
   * Constructs a HTMLReferencedContent with a SemanticObject
   * @param base The SemanticObject with the properties for the HTMLReferencedContent
   */
    public HTMLReferencedContent(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /**
     * Busca por palabras clave de la WebPage a la que pertenece este recurso y le agrega hipervínculos a otras WebPages, dentro del mismo portal,
     * que tienen referencias de las misma palabras clave.
     * @param datos - Contenido que integra las instancias de este recurso
     * @param wp - WebPage a la que pertenece la instancia de este recurso
     * @param url - URL de la instancia de este recurso
     * @return El contenido que se recibió en el parámetro datos pero con las modificaciones para visitar los vínculos
     *         especificados en url.
     */
    private String kw(String datos, WebPage wp, SWBResourceURL url) {
        url.setCallMethod(SWBParamRequest.Call_DIRECT).setMode("ref");
        try {
            String[]tkns = wp.getTags().split(",");
            StringBuilder aol = new StringBuilder();
            aol.append("\n<script type=\"text/javascript\">\n");
            aol.append("dojo.require(\"dijit.dijit\");\n");
            aol.append("function s(evt) {\n");
            aol.append("  dojo.byId('d1').style.display='none';\n");
            aol.append("  dojo.byId('d1').style.visibility='hidden';\n");
            aol.append("  postHtml('"+url+"'+'?tkn='+evt.target.innerHTML,'d1');\n");
            aol.append("  dojo.byId('d1').style.display='block';\n");
            aol.append("  dojo.byId('d1').style.visibility='visible';\n");
            aol.append("  dojo.byId('d1').style.top=evt.pageY+'px';\n");
            aol.append("  dojo.byId('d1').style.left=evt.pageX+'px';\n");
            aol.append("}\n");
            aol.append("dojo.addOnLoad ( function() {\n");
            String tkn;
            for(int i=0; i<tkns.length; i++) {
                tkn = tkns[i];
                //datos = datos.replaceAll(tkn, "<a id=\"rf_"+i+"\" href=\"#\" class=\"kw\">"+tkn+"</a>");
                datos = datos.replaceFirst(tkn, "<a id=\"rf_"+i+"\" href=\"#\" class=\"kw\">"+tkn+"</a>");
                aol.append("dojo.connect(dojo.byId('rf_"+i+"'),'onclick','s');\n");
            }
            aol.append("});\n");
            aol.append("</script>\n");
            aol.append("<div id=\"d1\" style=\"background-color:#CCCCCC; border:solid 1px #666666; position:absolute; display:none; visibility:hidden;\"></div>");
            datos=datos+aol;
        }catch(Exception e) {
        }
        return datos;
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equals("ref")) {
            doRef(request, response, paramRequest);
        }else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

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
                paginated = isContentPaginated();
            } catch (Exception e) {
                log.error("HTMLContent - Getting \"paginated\" property", e);
            }
            if (fileContent.indexOf("content=\"Microsoft Word") > 0) {
                boolean deleteStyles = false;
                try {
                    deleteStyles = isDeleteStyles();
                } catch (Exception e) {
                    log.error("HTMLContent - Getting \"deleteStyles\" property.", e);
                }
                ContentUtils contentUtils = new ContentUtils();
                fileContent = contentUtils.predefinedStyles(fileContent, resource, true); //Estilos predefinidos
                //fileContent = contentUtils.predefinedStyles(fileContent, base, isTpred()); //Estilos predefinidos
                if (paginated) {
                    fileContent = contentUtils.paginationMsWord(fileContent, page, request.getParameter("page"), resource, snpages, stxtant, stxtsig, stfont, position);
                }//Paginación
                fileContent = cleanHTML(fileContent, deleteStyles);
            }else {
                fileContent = SWBUtils.TEXT.replaceAll(fileContent, "<workpath/>",
                    SWBPortal.getWebWorkPath() + resource.getWorkPath() + "/" + versionNumber + "/");
                //Paginación (Jorge Jiménez-10/Julio/2009)
                if (getFormerLinkText() != null && !"".equalsIgnoreCase(getFormerLinkText())) {
                    stxtant = getFormerLinkText();
                } else if (paramRequest.getLocaleString("txtant") != null) {
                    stxtant = paramRequest.getLocaleString("txtant");
                }
                if (getNextLinkText() != null && !"".equalsIgnoreCase(getNextLinkText())) {
                    stxtsig = getNextLinkText();
                } else if (paramRequest.getLocaleString("txtsig") != null) {
                    stxtsig = paramRequest.getLocaleString("txtsig");
                }

                SWBResourceURL url = paramRequest.getRenderUrl();
                //url.setCallMethod(paramRequest.Call_DIRECT).setMode("ref");
                fileContent = kw(fileContent, paramRequest.getWebPage(), url);

                if (paginated) {
                    fileContent = new ContentUtils().paginationHtmlContent(fileContent, page, request.getParameter("page"), resource, snpages, stxtant, stxtsig, stfont, position);
                }
                //Termina Páginación
            }
        }

        response.getWriter().println(fileContent);
    }

    public void doRef(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out =  response.getWriter();

        WebPage wp = paramRequest.getWebPage();
        WebSite wsite = wp.getWebSite();
        User user = paramRequest.getUser();

        String tkn = request.getParameter("tkn");

        SWBIndexer indexer = SWBPortal.getIndexMgr().getModelIndexer(wsite);
        Searchable[] refs;
        GenericParser parser;
        Search search = new Search();
        String lang = user.getLanguage();

        refs = search.x(wsite, tkn, user);
        if(refs!=null && refs.length>0) {
            StringBuilder htm = new StringBuilder();
//htm.append("<p>tkn="+tkn+"</p>");
            for(Searchable srch:refs) {
                if(srch.equals(wp))
                    continue;
                parser = indexer.getParser(srch);
                htm.append("<p><a href=\""+parser.getUrl(srch)+"\" title=\"Ir a la referencia\">"+parser.getTitle(srch, lang)+"</a></p>");
            }            
            out.println(htm.toString());
        }else {
            out.println("<p>Sin referencias</p>");
        }
        out.println("<p><a href=\"#\" onclick=\"dojo.byId('d1').style.display='block';dojo.byId('d1').style.visibility='hidden';\" title=\"Cerrar\">[X]</a></p>");
    }
}
