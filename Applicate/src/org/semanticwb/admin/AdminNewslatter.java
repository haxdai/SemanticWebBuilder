/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.admin;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.applicate.ListEmail;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author gabriela.rosales
 */
public class AdminNewslatter extends GenericResource {

    private static Logger log = SWBUtils.getLogger(AdminNewslatter.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        try {
            String path = "/swbadmin/jsp/Applicate/newslatter.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            request.setAttribute("paramRequest", paramRequest);
            rd.include(request, response);
        } catch (ServletException ex) {
            log.error("Error in AdminNewslatter : " + ex);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action = response.getAction();

        if (action.equals("sendEmail")) {
            System.out.println("enviara correos");
            String asunto = request.getParameter("asunto");
            String contenido = request.getParameter("content");
            System.out.println("asuntno" + asunto);
            System.out.println("contenido" + contenido);

            Iterator listemail = ListEmail.ClassMgr.listListEmails(response.getWebPage().getWebSite());
            while (listemail.hasNext()) {
                ListEmail email = (ListEmail) listemail.next();
                System.out.println("+++++" + email.isVerificacion());
                if (email.isVerificacion()) {
                    String correo = email.getEmail();
                    SWBUtils.EMAIL.sendBGEmail(correo, asunto, contenido);
                }
            }

            response.setRenderParameter("msg", "Mensajes enviados.");
            response.setMode(SWBResourceURL.Mode_VIEW);

        }


    }
}
