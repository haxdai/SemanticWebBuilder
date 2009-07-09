/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author Jorge Jiménez
 */
public class SWBAUserNotes extends GenericAdmResource
{

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramReq) throws SWBResourceException, java.io.IOException {
        User user=paramReq.getUser();
        PrintWriter out = response.getWriter();
        SWBResourceURL url=paramReq.getActionUrl();
        out.println("<div id=\"notas\">");
        out.println("<h2>"+paramReq.getLocaleString("myNotes")+"</h2>");
        out.println("<div id=\"notasEstilo\">");
        out.println("<form name=\"notes\" method=\"post\" action=\""+url.toString()+"\" dojoType=\"dijit.form.Form\" class=\"swbform\">");
        out.println("<ul>");
        out.println("<li id=\"notaGuardar\"><a href=\"javascript:document.notes.submit();\" onClick=\"document.notes.submit();\" title=\""+paramReq.getLocaleString("save")+"\">Guardar</a></li>");
        out.println("</ul>");
        out.println("<textarea id=\"usrNotes\" name=\"usrNotes\" wrap=\"hard\">"+user.getProperty("admNotes","")+"</textarea>");
        //out.println("<button class=\"botonnotas\" dojoType='dijit.form.Button' type=\"submit\">"+paramReq.getLocaleString("save")+"</button>");
       // out.println("<input class=\"botonnotas\" type=\"submit\" value=\""+paramReq.getLocaleString("save")+"\"/>");
        //out.println("<input type=\"button\" onclick=\"postHtml('"+url+"'+'?usrNotes='+this.form.usrNotes.value,'usrNotes');\" value=\""+paramReq.getLocaleString("save")+"\"/>");
        out.println("</form>");
        out.println("<div>");
        out.println("</div>");
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        User user=response.getUser();
        if(request.getParameter("usrNotes")!=null){
            user.setProperty("admNotes", request.getParameter("usrNotes"));
        }
    }
}
