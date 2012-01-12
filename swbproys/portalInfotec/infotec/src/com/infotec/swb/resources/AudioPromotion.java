package com.infotec.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
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
public class AudioPromotion extends GenericResource {
    private static Logger log = SWBUtils.getLogger(AudioPromotion.class);
    public static final int MIN_LIST = 5;
    private static final String Action_UPDATE = "update";
    
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
        
        String lang = paramRequest.getUser().getLanguage();
        WebPage page = (WebPage)SemanticObject.createSemanticObject(base.getAttribute("page")).createGenericInstance();
        
        Iterator<AudioFile> iresources = AudioFile.ClassMgr.listAudioFiles(base.getWebSite());
        List resources = SWBUtils.Collections.copyIterator(iresources);
        Collections.sort(resources, new AudioFile.SortByReviews());
        iresources = resources.iterator();
        if(iresources.hasNext()) {
            int min = 0;
            out.println("<ul>");
            while(min<MIN_LIST && iresources.hasNext()) {
                AudioFile audio = iresources.next();
                out.println("<li>");
                out.println("<a href=\""+page.getRealUrl(lang)+"?uri="+audio.getEncodedURI()+"\" title=\""+paramRequest.getLocaleString("msgDoViewSeeMore")+"\">"+audio.getDisplayTitle(lang)+"</a>");
                out.println(audio.getDisplayDescription(lang));
                out.println("</li>");
                min++;
            }
            out.println("</ul>");
        }
    }
    
    private void renderWithoutPage(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out =  response.getWriter();
        
        String lang = paramRequest.getUser().getLanguage();
        
        Iterator<AudioFile> iresources = AudioFile.ClassMgr.listAudioFiles(base.getWebSite());
        List resources = SWBUtils.Collections.copyIterator(iresources);
        Collections.sort(resources, new AudioFile.SortByReviews());
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
        out.println("<script type=\"text/javascript\">\n");
        out.println("<!--\n");
        out.println("  dojo.require('dijit.layout.ContentPane');");
        out.println("  dojo.require('dijit.form.Form');");
        out.println("  dojo.require('dijit.form.ValidationTextBox');");
        out.println("  dojo.require('dijit.form.Button');");
        
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
        strTemp.append("<select id=\"uri\" name=\"uri\">\n");
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
        out.println("         <button type=\"submit\" dojoType=\"dijit.form.Button\"\">"+paramRequest.getLocaleString("lblDoAdminSave")+"</button>\n");
        out.println("         <button type=\"reset\" dojoType=\"dijit.form.Button\">"+paramRequest.getLocaleString("lblDoAdminReset")+"</button>\n");
        out.println("      </li>\n");
        out.println("   </ul>\n");
        out.println("</fieldset>\n");
        out.println("</form>\n");
        out.println("</div>\n");
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
