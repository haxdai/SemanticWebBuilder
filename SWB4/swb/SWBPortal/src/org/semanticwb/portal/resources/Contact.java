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
 

package org.semanticwb.portal.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBResourceException;

public class Contact extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(Banner.class);

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        Resource base = getResourceBase();

        String site = response.getWebPage().getWebSite().getDisplayTitle(response.getUser().getLanguage());
        String cto = base.getAttribute("cto");
        // TODO
        /*String name = SWBUtils.stringNullValidate(request.getParameter("name"));
        String email = SWBUtils.stringNullValidate(request.getParameter("email"));
        String subject = SWBUtils.stringNullValidate(request.getParameter("subject"));
        String message = SWBUtils.stringNullValidate(request.getParameter("message"));
        String rating = SWBUtils.stringNullValidate(request.getParameter("rating"));*/
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        String rating = request.getParameter("rating");
        
        String parausuario = (new StringBuilder()).append(name).append(", Muchas gracias por enviar tus comentarios y/o sugerencias acerca de ").append(site).append(".\n").toString();
        parausuario = (new StringBuilder()).append(parausuario).append("En un lapso de 24 horas responderemos a tu correo electr\363nico.\n").toString();
        parausuario = (new StringBuilder()).append(parausuario).append("Su mensaje fue enviado a la siguiente direcci\363n de correo electr\363nico:  ").append(cto).append("\n\n").toString();
        parausuario = (new StringBuilder()).append(parausuario).append("Sinceramente,\n").toString();
        parausuario = (new StringBuilder()).append(parausuario).append(site).append("\n").toString();
        String administrador = "------Formulario de Comentarios y Sugerencias------\n";
        administrador = (new StringBuilder()).append(administrador).append("Nombre completo: ").append(name).append("\n").toString();
        administrador = (new StringBuilder()).append(administrador).append("Email: ").append(email).append("\n").toString();
        administrador = (new StringBuilder()).append(administrador).append("Asunto: ").append(subject).append("\n").toString();
        administrador = (new StringBuilder()).append(administrador).append("Rating: ").append(rating).append("\n").toString();
        administrador = (new StringBuilder()).append(administrador).append("Comentarios: ").append(message).append("\n").toString();
        administrador = (new StringBuilder()).append(administrador).append("----------Informaci\363n de quien me visita----------\n").toString();
        for(Enumeration en = request.getHeaderNames(); en.hasMoreElements();)
        {
            String key = (String)en.nextElement();
            administrador = (new StringBuilder()).append(administrador).append(key).append(": ").append(request.getHeader(key)).append("\n").toString();
        }

        String gracias = "Gracias por contactarnos...";
        try{
            //SWBUtils.EMAIL.sendBGEMail(email, (new StringBuilder()).append("Contacto del Sitio - ").append(subject).toString(), "text/plain", 0, administrador);
            if(email!=null && email.trim().length()>0 && message!=null && message.trim().length()>0)
            {
                InternetAddress address1 = new InternetAddress();
                address1.setAddress(cto);
                ArrayList<InternetAddress> aAddress = new ArrayList<InternetAddress>();
                aAddress.add(address1);

                SWBUtils.EMAIL.sendMail(email, name, aAddress, null, null, (new StringBuilder()).append("Contacto del Sitio - ").append(subject).toString(), "text/plain", message, null, null, null);
                response.setRenderParameter("email", "sended");
                response.setRenderParameter("name", name);
            }else{
                response.setRenderParameter("email", "missdata");
            }
        }catch(Exception e) {
            response.setRenderParameter("email", "error");
        }
        /*if(ok) {
            SWBUtils.EMAIL.sendBGEMail(cto, email, null, null, gracias, "text/plain", 0, parausuario);
            response.setRenderParameter("email", "sended");
            response.setRenderParameter("name", name);
        }else {
            response.setRenderParameter("email", "error");
        }*/
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        if(email == null)
        {
            out.println("<font face=\"Arial, Helvetica, sans-serif\">");
            out.println("<table width=\"100%\">");
            out.println((new StringBuilder()).append("<form action=\"").append(paramsRequest.getActionUrl()).append("\" method=\"post\">").toString());
            out.println("<tr>");
            out.println((new StringBuilder()).append("  <td width=\"20%\"><font size=\"2\"><b>").append(paramsRequest.getLocaleString("name")).append("</b></font></td>").toString());
            out.println("  <td><input name=\"name\" id=\"name\" size=\"50\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println((new StringBuilder()).append("  <td><font size=\"2\"><b>").append(paramsRequest.getLocaleString("email")).append("</b></font></td>").toString());
            out.println("  <td><input name=\"email\" id=\"email\" size=\"50\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println((new StringBuilder()).append("  <td><font size=\"2\"><b>").append(paramsRequest.getLocaleString("subject")).append("</b></font></td>").toString());
            out.println("  <td ><input name=\"subject\" id=\"subject\" size=\"50\" /></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println((new StringBuilder()).append("  <td><font size=\"2\"><b>").append(paramsRequest.getLocaleString("message")).append("</b></font></td>").toString());
            out.println("  <td ><textarea name=\"message\" cols=\"50\" rows=\"5\"></textarea></td>");
            out.println("</tr>");
            out.println("<tr>");
            /*
            out.println("<tr>");
            out.println((new StringBuilder()).append("  <td><font size=\"2\"><b>").append(paramsRequest.getLocaleString("rating")).append("</b></font></td>").toString());
            out.println("  <td><font size=\"2\">");
            out.println((new StringBuilder()).append("     <input TYPE=\"RADIO\" NAME=\"rating\" VALUE=\"Buscadores\" CHECKED style=\"font-weight: 700\"><b>").append(paramsRequest.getLocaleString("searchs")).append("</b>").toString());
            out.println((new StringBuilder()).append("     <input TYPE=\"RADIO\" NAME=\"rating\" VALUE=\"Otras Web\" style=\"font-weight: 700\"><b>").append(paramsRequest.getLocaleString("others")).append("</b>").toString());
            out.println((new StringBuilder()).append("     <input TYPE=\"RADIO\" NAME=\"rating\" VALUE=\"Radio, Televisi\363n, Medios Gr\341ficos, etc\" style=\"font-weight: 700\"><b>").append(paramsRequest.getLocaleString("medias")).append("</b>").toString());
            out.println("\t\t     </font></td>");
            out.println("</tr>");
             * */
            out.println("<tr>");
            out.println("  <td colspan=\"2\" align=\"center\">");
            out.println((new StringBuilder()).append("      <input name=\"submit\" type=\"submit\" value=\"").append(paramsRequest.getLocaleString("send")).append("\" />").toString());
            out.println("    &nbsp;&nbsp;&nbsp;");
            out.println((new StringBuilder()).append("    <input name=\"reset\" type=\"reset\" value=\"").append(paramsRequest.getLocaleString("reset")).append("\" />").toString());
            out.println("  </td>");
            out.println("</tr>");
            out.println("</form>");
            out.println("</table>");
            out.println("</font>");
        }else if(email.equals("sended")) {
            String site = paramsRequest.getWebPage().getWebSite().getDisplayTitle(paramsRequest.getUser().getLanguage());
            String cto = paramsRequest.getResourceBase().getAttribute("cto");
            String name = request.getParameter("name");
            String parausuario = (new StringBuilder()).append(name).append(", Muchas gracias por enviar su comentario y/o sugerencias acerca de ").append(site).append(".\n").toString();
            parausuario = (new StringBuilder()).append(parausuario).append("En un lapso de 24 horas responderemos a su correo electr\363nico.\n").toString();
            parausuario = (new StringBuilder()).append(parausuario).append("Su mensaje fue enviado a la siguiente direcci\363n de correo electr\363nico:  ").append(cto).append("\n\n").toString();
            parausuario = (new StringBuilder()).append(parausuario).append("Sinceramente,\n").toString();
            parausuario = (new StringBuilder()).append(parausuario).append(site).append("\n").toString();
            out.println("<pre>");
            out.println(parausuario);
            out.println("</pre>");
        }else if(email.equals("missdata")) {
            out.println("<pre>");
            out.println("Lo sentimos, por el momento no fue posible enviar su comentario.<br>");
            out.println("Falta información para el envío de su correo:<br>");
            out.println("Debe escribir su correo electrónico y mensaje como minimo<br><br>");
            out.println("<pre>");
        }else {
            String site = paramsRequest.getWebPage().getWebSite().getDisplayTitle(paramsRequest.getUser().getLanguage());
            out.println("Lo sentimos, por el momento no fue posible enviar su comentario, ");
            out.println("le agradeceremos intentarlo más tarde o bien utilizar otro medio.<br><br>");
            out.println("Por su atención, muchas gracias.<br>");
            out.println(site);
        }
    }
}
