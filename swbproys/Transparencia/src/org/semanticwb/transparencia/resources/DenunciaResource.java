/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.transparencia.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.api.SWBResourceURLImp;
import org.semanticwb.transparencia.model.Denuncia;

/**
 *
 * @author juan.fernandez
 */
public class DenunciaResource extends GenericResource {

    private Logger log = SWBUtils.getLogger(DenunciaResource.class);

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        super.doAdmin(request, response, paramRequest);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();

        WebPage wp = paramRequest.getWebPage();
        WebSite ws = wp.getWebSite();

        String alert = request.getParameter("msg");

        if (null != alert && "ok".equals(alert)) {


            System.out.println("Denuncia agregada doView(alert)");

            String id = request.getParameter("suri");
            Denuncia denuncia = Denuncia.ClassMgr.getDenuncia(id, ws);

            StringBuilder msg = new StringBuilder();
            msg.append("<p>¡Gracias por tu denuncia!</p><br/>");
            msg.append("<p>La participación nos fortalece a todos.<br/><br/>");
            msg.append("Se ha enviado un correo a la siguiente dirección \"" + denuncia.getEmailDenunciante() + "\" para que tu denuncia continue el proceso tienes que hacer clic en la liga que se encuentra en tu correo.</p>");

            out.println(msg.toString());
        } else {

            String act = request.getParameter("act");
            if (act == null) {
                act = "";
            }
            if ("".equals(act) || "edit".equals(act)) {
                SWBResourceURL urlnew = paramRequest.getActionUrl();
                urlnew.setAction("add");

                SWBFormMgr mgr = new SWBFormMgr(Denuncia.trans_Denuncia, paramRequest.getWebPage().getWebSite().getSemanticObject().getModel().getModelObject(), SWBFormMgr.MODE_CREATE);
                mgr.setAction(urlnew.toString());
                mgr.addButton(SWBFormButton.newCancelButton());
                mgr.addButton(SWBFormButton.newSaveButton());

                mgr.setType(SWBFormMgr.TYPE_DOJO);
                out.println(mgr.renderForm(request));

//        out.println(" <p>&nbsp; </p> ");
//        out.println("             <p>PASO 1 Registra tu denuncia</p> ");
//        out.println("             <p>&nbsp;</p> ");
//        out.println("       <form id=\"form2\" name=\"form2\" method=\"post\" action=\""+urlnew+"\" > ");
//        out.println("          <label for=\"curp\">CURP: </label> ");
//        out.println("          <input type=\"text\" name=\"curp\" id=\"curp\" /> ");
//        out.println("          <br /> ");
//        out.println("          <label for=\"dependencia\">Dependencia a la que va dirigida a denuncia:</label> ");
//        out.println("                  <select name=\"dependencia\" id=\"dependencia\"> ");
//        out.println("                  </select> ");
//        out.println("                  <br /> ");
//        out.println("                  Área que desea denunciar  ");
//        out.println("                  <select name=\"select2\" id=\"select2\"> ");
//        out.println("                  </select> ");
//        out.println("                  <br /> ");
//        out.println("                  Persona a la que desea denunciar  ");
//        out.println("                  <input type=\"text\" name=\"textfield3\" id=\"textfield3\" /> ");
//        out.println("                  <br /> ");
//        out.println("                  Denuncia ");
//        out.println("                  <textarea name=\"textarea\" id=\"textarea\" cols=\"45\" rows=\"5\"></textarea> ");
//        out.println("                  <br /> ");
//        out.println("                  Tipo de denuncia  ");
//        out.println("                  <select name=\"select3\" id=\"select3\"> ");
//        out.println("                  </select> ");
//        out.println("                  <br /> ");
//        out.println("                  Otro tipo denunicia  ");
//        out.println("                  <input type=\"text\" name=\"textfield4\" id=\"textfield4\" /> ");
//        out.println("                  <br /> ");
//        out.println("                  Correo electrónico  ");
//        out.println("                  <input type=\"text\" name=\"textfield5\" id=\"textfield5\" /> ");
//        out.println("                  <br /> ");
//        out.println("                  IMAGEN BANNER EXPLICACIÓN MECANICA CORREO ELECTRONICO<br /> ");
//        out.println("                  <br /> ");
//        out.println("             </label> ");
//        out.println("             <div class=\"search\"> ");
//        out.println("               <label> ");
//        out.println("               <input type=\"submit\" name=\"button2\" id=\"button2\" value=\"DENUNCIAR\" class=\"srch_btt\" /> ");
//        out.println("               </label> ");
//        out.println("               </div> ");
//        out.println("               <label><br /> ");
//        out.println("               </label> ");
//        out.println("             </form> ");
//        out.println("             <p>&nbsp;</p> ");


                // Paso 2
            } else if ("active".equals(act)) {


                String id = request.getParameter("suri");
                Denuncia denuncia = Denuncia.ClassMgr.getDenuncia(id, ws);
                denuncia.setActiva(true);

                StringBuilder msg = new StringBuilder();
                if (denuncia != null) {
                    // Activar denuncia

                    SWBResourceURL url = paramRequest.getRenderUrl();
                    url.setParameter("act", "seguimiento");

                    msg.append("<p>&nbsp;</p>");
                    msg.append("<p>DENUNCIA ACTIVADA</p>");
                    msg.append("<p>Muchas Gracias " + denuncia.getDenunciante() + ", </p>");
                    msg.append("<p>Tu denuncia ha sido recibida te informaremos a \"" + denuncia.getEmailDenunciante() + "\", cuaquier cambio relevante <br/>puedes dar seguimiento a tu denuncia en cualquier momento dando clic a esta liga ");
                    msg.append("<a href=\"" + url + "\">SEGUIMIENTO</a> o <br/>en la sección de seguimiento a denuncias del portal.</p>");
                }

                out.println(msg.toString());

            } else if ("seguimiento".equals(act)) {

                out.println("Seguimiento a tu Denuncia.");

                String email = request.getParameter("email");

                SWBResourceURL urlsearch = paramRequest.getRenderUrl();
                urlsearch.setParameter("act", "seguimiento");


                out.println("<div class=\"search\">");
                out.println("<form name=\"formSearch\" method=\"post\" action=\""+urlsearch+"\">");
                out.println("<p>");
                out.println("<blockquote>");
                out.println("<label for=\"email\">Correo Electrónico:</label>");
                out.println("</blockquote>");
                out.println("<input type=\"text\" name=\"email\" id=\"email\" class=\"srch_input\" />");
                out.println("<input type=\"submit\" name=\"button2\" id=\"button2\" value=\"Buscar\" class=\"srch_btt\" />");
                out.println("</label>");
                out.println("</p>");
                out.println("</form>");
//                out.println("<blockquote>");
//                out.println("  <p>	Correo Electrónico:</p>");
//                out.println("</blockquote>");
                out.println("</div>");
                out.println("<p>&nbsp;</p>");



                if (email != null && email.trim().length() > 0) {
                    // busqueda de denuncias por email

                    out.println("<p>&nbsp;</p>");
                    out.println("<p>El correo electrónico tiene las siguientes denuncias activas:</p>");
                    out.println("<p>&nbsp;</p>");
                    out.println("<table width=\"752\" border=\"1\">");
                    out.println("  <tr>");
                    out.println("    <th width=\"95\">Denuncia</th>");
                    out.println("    <th width=\"103\">Tipo Denuncia</th>");
                    out.println("    <th width=\"231\">Fecha de Registro</th>");
                    out.println("    <th width=\"295\">Estatus</th>");
                    out.println("  </tr>");

                    Iterator<Denuncia> itden = Denuncia.ClassMgr.listDenuncias();
                    while (itden.hasNext()) {
                        Denuncia denuncia = itden.next();
                        if (null!=denuncia.getEmailDenunciante()&&denuncia.getEmailDenunciante().equals(email)) {
                            // Mostrar tabla de denuncias asociadas al email

                            String txtdenuncia = denuncia.getDenuncia();
                            if(txtdenuncia!=null&&txtdenuncia.trim().length()>30)
                            {
                                txtdenuncia = txtdenuncia.substring(0,30) + "...";
                            }

                            SWBResourceURL urldetail = paramRequest.getRenderUrl();
                            urldetail.setParameter("act","detail");
                            urldetail.setParameter("ract","seguimiento");
                            urldetail.setParameter("email", email);
                            urldetail.setParameter("suri", denuncia.getId());

                            out.println("  <tr>");
                            out.println("    <td><a href=\""+urldetail+"\">"+txtdenuncia+"</a>.</td>");
                            out.println("    <td>"+denuncia.getTipoDenuncia()+"</td>");
                            out.println("    <td>"+denuncia.getCreated()+"</td>");
                            out.println("    <td>"+(!denuncia.isActiva()?"Inactiva":denuncia.getEstatus())+"</td>");
                            out.println("  </tr>");

                        }

                    }

                    out.println("</table>");
                    out.println("<p>&nbsp;</p>");
                }

            } else if ("detail".equals(act)) {

                String iddenuncia = request.getParameter("suri");

                Denuncia denuncia = null;
                if(iddenuncia!=null)
                {
                    denuncia = Denuncia.ClassMgr.getDenuncia(iddenuncia, ws);
                }

                if(denuncia!=null)
                {
                    SWBFormMgr mgr = new SWBFormMgr(denuncia.getSemanticObject(), SWBFormMgr.MODE_VIEW , SWBFormMgr.MODE_VIEW);

                    SWBResourceURL urlbck = paramRequest.getRenderUrl();
                            urlbck.setParameter("act",request.getParameter("ract"));
                            urlbck.setParameter("email", request.getParameter("email"));
                            urlbck.setParameter("suri", denuncia.getId());



                    String bckBtn = "<button type=\"button\" onclick=\"window.location='"+urlbck+"';\" class=\"srch_btt\">Regresar</button>";

                    mgr.addButton(bckBtn);



                    out.println(mgr.renderForm(request));

//                out.println("<p>&nbsp;</p>");
//                out.println("<p>Detalle denuncia</p><br/>");
//                out.println("<p>");
//                out.println("<table>");
//                out.println("<tr>");
//                out.println("<td>Denuncia:</td>");
//                out.println("<td><textarea readonly>"+denuncia.getDenuncia()+"</textarea></td>");
//                out.println("</tr>");
//
//                out.println("<tr>");
//                out.println("<td>Dependencia:</td>");
//                out.println("<td>"+denuncia.getDependencia()+"</td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Área:</td>");
//                out.println("<td>"+denuncia.getArea()+"</td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Persona que se denuncia:</td>");
//                out.println("<td>"+denuncia.getPersonaDenunciar()+"</td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Denuncia:</td>");
//                out.println("<td><textarea readonly>"+denuncia.getDenuncia()+"</textarea></td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Denuncia:</td>");
//                out.println("<td><textarea readonly>"+denuncia.getDenuncia()+"</textarea></td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Denuncia:</td>");
//                out.println("<td><textarea readonly>"+denuncia.getDenuncia()+"</textarea></td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Denuncia:</td>");
//                out.println("<td><textarea readonly>"+denuncia.getDenuncia()+"</textarea></td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Denuncia:</td>");
//                out.println("<td><textarea readonly>"+denuncia.getDenuncia()+"</textarea></td>");
//                out.println("</tr>");
//                out.println("<tr>");
//                out.println("<td>Denuncia:</td>");
//                out.println("<td><textarea readonly>"+denuncia.getDenuncia()+"</textarea></td>");
//                out.println("</tr>");
//
//                out.println("</table>");
//                out.println("</p>");
                }


            }
        }

    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {

        String action = response.getAction();
        WebSite ws = response.getWebPage().getWebSite();
        if (action == null) {
            action = "";
        }

        if ("add".equals(action)) {
            Denuncia denuncia = null;
            SWBFormMgr mgr = new SWBFormMgr(Denuncia.trans_Denuncia, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
            try {
                SemanticObject so = mgr.processForm(request);
                denuncia = (Denuncia) so.createGenericInstance();

//                SWBMail mmsg = new SWBMail();

//                ArrayList<InternetAddress> arrl = new ArrayList<InternetAddress>();
//
//                try {
//                    InternetAddress intadd2 = new InternetAddress();
//                    if (SWBUtils.EMAIL.isValidEmailAddress(denuncia.getEmailDenunciante())) {
//                        intadd2.setAddress(denuncia.getEmailDenunciante());
//                        arrl.add(intadd2);
//                    }
//                } catch (Exception e) {
//                    log.error("Error al revisar el e-mail definido.", e);
//                }




//                mmsg.setFromEmail("antoniof@infotec.com.mx");
//                mmsg.setToEmail(arrl);


                System.out.println("denuncia: " + denuncia.getId());
                System.out.println("email: " + denuncia.getEmailDenunciante());

                StringBuilder msg = new StringBuilder();
                msg.append("Denuncia recibida,\n\n");
                msg.append("Para activar la denuncia da clic en la siguiente liga:\n\n");


                SWBResourceURLImp urlactive = new SWBResourceURLImp(request, getResourceBase(), response.getWebPage(), SWBResourceURL.UrlType_RENDER);
                urlactive.setParameter("act", "active");
                urlactive.setParameter("suri", denuncia.getId());

                msg.append("<a href=\"http://" + request.getServerName() + ":" + request.getServerPort() + urlactive.toString() + "\">Activar denuncia</a>");

//                mmsg.setSubject("Denuncia recibida - Transparencia");
//                mmsg.setData(msg.toString());

                response.setRenderParameter("msg", "ok");
                response.setRenderParameter("suri", denuncia.getId());


                try {
                    SWBUtils.EMAIL.sendBGEmail(denuncia.getEmailDenunciante(), "Denuncia recibida - Transparencia", msg.toString());
                } catch (Exception e) {
                    log.error("Error al enviar el email.", e);
                }


                //envio de email al usuario denunciante para que active la denuncia

            } catch (Exception e) {
                log.error("Error al agregar la denuncia", e);
            }
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        super.processRequest(request, response, paramRequest);
    }
}
