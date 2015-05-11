/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal.resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBException;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class Borrar extends GenericResource {
    public static final String Action_UPDATE = "upd";
    public static final String STTS_MSG = "sttsmsg";
    private String basePath;
    

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        basePath = "/work/models/" + getResourceBase().getWebSiteId() + "/jsp/" + this.getClass().getSimpleName() + "/";
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        Resource base = getResourceBase();
        String fwfe;
        fwfe = base.getWebSite().getModelProperty("framework_front_end");
        String path = basePath+"view"+fwfe+".jsp";
System.out.println("path="+path);
        try {
            RequestDispatcher dis = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            request.setAttribute("res", this);
            dis.include(request, response);
        } catch (IOException e) {
            System.err.println(e);
        } catch (ServletException e) {
            System.err.println(e);
        }
    }
    
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=utf-8");//ISO-8859-1
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        PrintWriter out = response.getWriter();
        
        out.println("<script type=\"text/javascript\">");
        out.println("  dojo.require('dijit.layout.ContentPane');");
        out.println("</script>");
                
        String statmsg = request.getParameter(STTS_MSG);
        if( statmsg!=null && !statmsg.isEmpty())
        {
            out.println("<div dojoType=\"dojox.layout.ContentPane\">");
            out.println("  <script type=\"dojo/method\">");
            out.print("    showStatus('"); 
            out.print(request.getParameter(STTS_MSG));
            out.println("');");
            out.println("  </script>");
            out.println("</div>");
        }
        final SWBResourceURL url = paramRequest.getActionUrl().setAction(Action_UPDATE);
        out.print(getForm(request, paramRequest, url.toString()));
    }
    
    /*@Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=utf-8");//ISO-8859-1
        response.setHeader("Cache-Control","no-cache");
        response.setHeader("Pragma","no-cache");
        PrintWriter out = response.getWriter();
        
        out.println("<script type=\"text/javascript\">");
        out.println("  dojo.require('dijit.layout.ContentPane');");
        out.println("</script>");        
        Resource base=getResourceBase();
        String action = paramRequest.getAction();        
        if(Action_UPDATE.equals(action))
        {
            String x = request.getParameter("x");
            base.setAttribute("x", x);
            try {
                base.updateAttributesToDB();
                out.println("<script type=\"text/javascript\" language=\"JavaScript\">");
                out.println("   alert('Se actualizó exitosamente el recurso con identificador "+base.getId()+"');");
                out.println("   window.location.href='"+paramRequest.getRenderUrl().setAction(SWBResourceURL.Action_ADD)+"';");
                out.println("</script>");
            }catch (SWBException e) {
                System.err.println("--Error al guardar atributos del InlineTextArea. ");
            }
        }
        final SWBResourceURL url = paramRequest.getRenderUrl().setAction(Action_UPDATE);
        out.print(getForm(request, paramRequest, url.toString()));
    }*/
    
    private String getForm(HttpServletRequest request, SWBParamRequest paramRequest, final String URL) {
        final Resource base = getResourceBase();
        StringBuilder htm = new StringBuilder();
        htm.append("<div class=\"swbform\">\n");
        htm.append("<form id=\"recx\" dojoType=\"dijit.form.Form\" method=\"post\" action=\""+URL+"\">\n");
        htm.append("<fieldset>\n");
        htm.append("  <legend>Datos</legend>\n");
        htm.append("  <label for=\"x\" class=\"swbform-label\">Valor X</label>\n");
        htm.append("  <input type=\"text\" id=\"x\" name=\"x\" dojoType=\"dijit.form.ValidationTextBox\" value=\""+base.getAttribute("x","")+"\" />\n");
        htm.append("</fieldset>\n");
        
        htm.append("<fieldset>\n");
        htm.append("  <button type=\"submit\" dojoType=\"dijit.form.Button\">Guardar</button>\n");
        htm.append("  <button type=\"reset\" dojoType=\"dijit.form.Button\">Reestablecer</button>\n");
        htm.append("</fieldset>\n");
        
        htm.append("</form>\n");
        htm.append("</div>\n");
        
        return htm.toString();
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        final String action = response.getAction();
        Resource base = response.getResourceBase();
        
        if(Action_UPDATE.equalsIgnoreCase(action)) {
            String x = request.getParameter("x");
            base.setAttribute("x", x);
            response.setAction(response.Action_ADD);
            try {
                base.updateAttributesToDB();
                response.setRenderParameter(STTS_MSG, "Se actualizó exitosamente el recurso con identificador "+base.getId());
            }catch (SWBException e) {
                System.err.println("--Error al guardar atributos del InlineTextArea. ");
                response.setRenderParameter(STTS_MSG, "Recurso con identificador "+base.getId()+" falló al intentar actualizarse");
            }finally {
                response.setAction(SWBResourceURL.Action_EDIT);
            }
        }
    }
}
