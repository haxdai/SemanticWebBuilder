package com.infotec.swb.resources;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.resources.sem.AudioFile;

/**
 *
 * @author carlos.ramos
 */
public class FavoriteAudios extends GenericResource {
    private static Logger log = SWBUtils.getLogger(AudioPromotion.class);
    private static final int DEFAULT_BUFFER_SIZE = 2048; // 2KB.
    public static final int MIN_LIST = 5;
    private static final String Action_UPDATE = "update";
    public static final String Mode_PLAY = "play";
    
    private final DecimalFormat df = new DecimalFormat("#.00");
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if(Mode_PLAY.equals(mode))
            doPlay(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=UTF-8");
        Resource base = getResourceBase();
        try {
            WebPage page = (WebPage)SemanticObject.createSemanticObject(base.getAttribute("page")).createGenericInstance();
            renderWithPage(request, response, paramRequest);
        }catch(Exception e) {
            renderWithoutPage(request, response, paramRequest);
        }
    }
    
    private void renderWithPage(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out =  response.getWriter();
        
        final User user = paramRequest.getUser();
        final String lang = user.getLanguage();
        final WebPage page = (WebPage)SemanticObject.createSemanticObject(base.getAttribute("page")).createGenericInstance();
        
        Iterator<AudioFile> iresources = AudioFile.ClassMgr.listAudioFiles(base.getWebSite());
        List resources = SWBUtils.Collections.copyIterator(iresources);
        Collections.sort(resources, new AudioFile.SortByRanking());
        Collections.reverse(resources);
        iresources = resources.iterator();
        if(iresources.hasNext()) {
            SWBResourceURL directURL = paramRequest.getRenderUrl().setMode(Mode_PLAY).setCallMethod(paramRequest.Call_DIRECT);
            File f;
            out.println("<div id=\"masGustados\">");
            out.println("<h3>"+paramRequest.getLocaleString("msgDoViewMostLiked")+"</h3>");
            out.println("<ul>");
            for(int i=0; i<MIN_LIST && iresources.hasNext(); i++) {
                AudioFile audiofile = iresources.next();
                if(!audiofile.isValid() || !user.haveAccess(audiofile))
                    continue;
                f = audiofile.getFile();
                if(f!=null && f.isFile()) {
                    out.println("<li>");
                    out.println(" <p class=\"podName\">"+(audiofile.getDisplayTitle(lang)==null?audiofile.getTitle():audiofile.getDisplayTitle(lang))+"</p>");
                    out.println(" <p class=\"podAutor\">"+paramRequest.getLocaleString("lblDoViewBy")+"&nbsp;"+audiofile.getAuthor()+"</p>");
                    out.println(" <p class=\"escuchar_mp3\"><a href=\""+page.getRealUrl(lang)+"?uri="+audiofile.getEncodedURI()+"\" title=\""+paramRequest.getLocaleString("lblDoViewListen")+"\">"+paramRequest.getLocaleString("lblDoViewListen")+"</a></p>");
                    out.println(" <p class=\"descargar_mp3\"><a href=\""+directURL.setParameter("uri", audiofile.getEncodedURI())+"\" title=\""+(audiofile.getDisplayTitle(lang)==null?audiofile.getTitle():audiofile.getDisplayTitle(lang))+"\">"+paramRequest.getLocaleString("lblDoViewDownload")+"</a><span>"+paramRequest.getLocaleString("lblDoViewFormat")+"&nbsp;"+audiofile.getExtension()+" - "+paramRequest.getLocaleString("lblDoViewFileLength")+"&nbsp;"+df.format(f.length()/1048576.0)+" Mb</span></p>");
                    out.println("</li>");
                }
            }
            out.println("</ul>");
            out.println("</div>");
        }else {
            out.println(paramRequest.getLocaleString("msgDoViewNoPodcast"));
        }
    }
    
    private void renderWithoutPage(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out =  response.getWriter();
        
        String lang = paramRequest.getUser().getLanguage();
        
        Iterator<AudioFile> iresources = AudioFile.ClassMgr.listAudioFiles(base.getWebSite());
        List resources = SWBUtils.Collections.copyIterator(iresources);
        Collections.sort(resources, new AudioFile.SortByRanking());
        Collections.reverse(resources);
        iresources = resources.iterator();
        if(iresources.hasNext()) {
            int min = 0;
            out.println("<ul>");
            while(min<MIN_LIST && iresources.hasNext()) {
                AudioFile audio = iresources.next();
                out.println("<li>");
                out.println(audio.getDisplayTitle(lang));
                out.println(audio.getDisplayDescription(lang));
                out.println("</li>");
                min++;
            }
            out.println("</ul>");
        }
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String action = paramRequest.getAction();
        if(SWBResourceURL.Action_ADD.equals(action) || SWBResourceURL.Action_EDIT.equals(action)) {
            getForm(request, response, paramRequest);
        }else if(Action_UPDATE.equals(action)) {
            PrintWriter out =  response.getWriter();
            String msg = request.getParameter("msg");
            out.println("<script type=\"text/javascript\">");
            out.println("   alert('"+msg+"');");
            out.println("   location.href='"+paramRequest.getRenderUrl().setAction(paramRequest.Action_EDIT)+"';");
            out.println("</script>");
        }
    }
    
    private void getForm(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out =  response.getWriter();
        String lang = paramRequest.getUser().getLanguage();
        SWBResourceURL url = paramRequest.getActionUrl().setAction(paramRequest.Action_EDIT);
        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println("  dojo.require('dijit.layout.ContentPane');");
        out.println("  dojo.require('dijit.form.Form');");
        out.println("  dojo.require('dijit.form.ValidationTextBox');");
        out.println("  dojo.require('dijit.form.FilteringSelect');");
        out.println("  dojo.require('dijit.form.Button');");
        
        out.println("function validate() {");
        out.println("    var objd=dijit.byId('form1ud');");
        out.println("    if(objd.validate())");
        out.println("    {");
        out.println("        return true;");
        out.println("    }else {");
        out.println("        alert('Datos incompletos o incorrectos');");
        out.println("    }");
        out.println("    return false;");
        out.println("}");
        
        out.println("-->");
        out.println("</script>");

        out.println("<div class=\"swbform\">");
        out.println("<form id=\"frmAdm\" dojoType=\"dijit.form.Form\" method=\"post\" action=\""+url+"\">");
        out.println("<fieldset>");
        out.println("    <legend>Datos</legend>");
        out.println("    <ul class=\"swbform-ul\">");
        out.println("        <li class=\"swbform-li\">");
        out.println("          <label for=\"title\" class=\"swbform-label\">"+paramRequest.getLocaleString("lblDoAdminPage")+"</label>");
        String str_role = base.getAttribute("page", "0");
        String selected = "";
        if(str_role.equals("0")) {
            selected = " selected=\"selected\"";
        }
        StringBuilder strTemp = new StringBuilder();
        strTemp.append("<select name=\"uri\" dojoType=\"dijit.form.FilteringSelect\" autocomplete=\"true\" required=\"true\" value=\"\">");
        strTemp.append("<option value=\"0\" ");
        strTemp.append(selected);
        strTemp.append(">");
        strTemp.append(paramRequest.getLocaleString("lblDoAdminSelectOne"));
        strTemp.append("</option>\n");
        out.println(strTemp.toString());
        Iterator<WebPage> pages = base.getWebSite().listWebPages();
        while (pages.hasNext()) {
            WebPage page = pages.next();
            if(!page.isValid())
                continue;
            selected = "";
            if(str_role.equals(page.getURI())) {
                selected = " selected=\"selected\"";
            }
            out.print("<option value=\"");
            out.print(page.getURI());
            out.print("\"");
            out.print(selected);
            out.print(">");
            out.print(page.getDisplayTitle(lang));
            out.println("</option>");
        }
        out.println("</select>");
        out.println("        </li>");
        out.println("    </ul>");
        out.println("</fieldset>");

        out.println("<fieldset>\n");
        out.println("   <legend></legend>\n");
        out.println("   <ul class=\"swbform-ul\">\n");
        out.println("      <li>\n");
        out.println("         <button type=\"submit\" dojoType=\"dijit.form.Button\" onclick=\"return validate()\">"+paramRequest.getLocaleString("lblDoAdminSave")+"</button>\n");
        out.println("         <button type=\"reset\" dojoType=\"dijit.form.Button\">"+paramRequest.getLocaleString("lblDoAdminReset")+"</button>\n");
        out.println("      </li>\n");
        out.println("   </ul>\n");
        out.println("</fieldset>\n");
        out.println("</form>\n");
        out.println("</div>\n");
    }
    
    public void doPlay(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String uri = request.getParameter("uri");
        uri = URLDecoder.decode(uri, "UTF-8");
        AudioFile audiofile = null;
        try {
            audiofile = (AudioFile)SemanticObject.createSemanticObject(uri).createGenericInstance();
        }catch(Exception e) {
            log.error(e);
        }
        if(audiofile!=null && audiofile.isValid()) {
            String filename = audiofile.getFilename();
            if(filename.endsWith(".htm"))
                response.setContentType("text/html");
    //        else if(filename.endsWith(".xml"))
    //            response.setContentType("text/xml");
    //        else if(filename.endsWith(".rtf"))
    //            response.setContentType("application/rtf");
    //        else if(filename.endsWith(".pdf"))
    //            response.setContentType("application/pdf");
    //        else if (filename.endsWith(".do"))
    //            response.setContentType("application/msword");
    //        else if(filename.endsWith(".xl"))
    //            response.setContentType("application/vnd.ms-excel");
    //        else if(filename.endsWith(".pp"))
    //            response.setContentType("application/vnd.ms-powerpoint");
    //        else if(filename.endsWith(".msg"))
    //            response.setContentType("application/vnd.ms-outlook");
    //        else if(filename.endsWith(".mpp"))
    //            response.setContentType("application/vnd.ms-project");
    //        else if(filename.endsWith(".iii"))
    //            response.setContentType("application/x-iphone");
    //        else if(filename.endsWith(".mdb"))
    //            response.setContentType("application/x-msaccess");
    //        else if(filename.endsWith(".pub"))
    //            response.setContentType("application/x-mspublisher");
    //        else if(filename.endsWith(".swf"))
    //            response.setContentType("application/x-shockwave-flash");
    //        else if(filename.endsWith(".text"))
    //            response.setContentType("application/x-tex");
            else if (filename.endsWith(".zip"))
                response.setContentType("application/zip");
    //        else if (filename.endsWith(".jp"))
    //            response.setContentType("image/jpeg");
    //        else if (filename.endsWith(".png"))
    //            response.setContentType("image/png");
    //        else if (filename.endsWith(".gif"))
    //            response.setContentType("image/gif");
    //        else if(filename.endsWith(".bmp"))
    //            response.setContentType("image/bmp");
    //        else if(filename.endsWith(".tif"))
    //            response.setContentType("image/tiff");
    //        else if(filename.endsWith(".ico"))
    //            response.setContentType("image/x-icon");
            else if (filename.endsWith(".mp3"))
                response.setContentType("audio/mpeg");
    //        else if(filename.endsWith(".mp"))
    //            response.setContentType("video/mpeg");
    //        else if(filename.endsWith(".mov"))
    //            response.setContentType("video/quicktime");
    //        else if(filename.endsWith(".qt"))
    //            response.setContentType("video/quicktime");
    //        else if(filename.endsWith(".as"))
    //            response.setContentType("video/x-ms-asf");
    //        else if(filename.endsWith(".avi"))
    //            response.setContentType("video/x-msvideo");
    //        else
    //            response.setContentType("application/octet-stream");

            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            String resourceURL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+SWBPortal.getContextPath()+SWBPortal.getWebWorkPath()+audiofile.getWorkPath()+"/"+URLDecoder.decode(audiofile.getFilename(), "UTF-8");
            URL url = new URL(resourceURL);
            //File f=new File(url.getFile());
            BufferedInputStream  bis = new BufferedInputStream(url.openStream());
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[DEFAULT_BUFFER_SIZE];
            int bytesRead;
            while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            bis.close();
            bos.flush();
            bos.close();
        }
    }
    
    @Override
    public void processAction(javax.servlet.http.HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        Resource base = response.getResourceBase();
        String action = response.getAction();
        if(response.Action_EDIT.equals(action)) {
            response.setAction(Action_UPDATE);
            String msg = response.getLocaleString("msgDoAdminUndefinedOperation");
            String uri = request.getParameter("uri");
            if(uri!=null) {
                try {
                    WebPage page = (WebPage)SemanticObject.createSemanticObject(uri).createGenericInstance();
                    base.setAttribute("page",uri);
                }catch(Exception e) {
                    base.removeAttribute("page");
                }finally {
                    msg = response.getLocaleString("msgDoAdminOkUpdateResource")+" "+base.getId();
                }
                try {
                    base.updateAttributesToDB();
                }catch (Exception e) {
                    log.error("URI "+uri+" is invalid", e);
                    msg = response.getLocaleString("msgDoAdminErrUpdateResource")+" "+base.getId();
                }
            }
            response.setRenderParameter("msg", msg);
        }
    }    
}
