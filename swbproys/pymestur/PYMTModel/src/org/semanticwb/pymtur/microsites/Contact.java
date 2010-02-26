

/**
 *
 * @author carlos.ramos
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.pymtur.MicroSitePyme;
import org.semanticwb.pymtur.ServiceProvider;

public class Contact extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(Contact.class);

    private String webWorkPath= "/work";

    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            webWorkPath = SWBPortal.getWebWorkPath() +  base.getWorkPath();
        }catch(Exception e) {
            log.error("Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        if(paramsRequest.getMode().equalsIgnoreCase("sendEmail")) {
            doSendEmail(request,response,paramsRequest);
        }else {
            super.processRequest(request, response, paramsRequest);
        }
    }

    public void doSendEmail(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        SemanticObject sobj;
        ServiceProvider sprovider = null;
        
        try {
            sprovider = ((MicroSitePyme)paramsRequest.getWebPage()).getServiceProvider();
        }catch(Exception e) {
            String uri = request.getParameter("uri");
            sobj=SemanticObject.createSemanticObject(uri);
            if(sobj.getGenericInstance() instanceof MicroSitePyme) {
                MicroSitePyme msp = (MicroSitePyme) sobj.getGenericInstance();
                sprovider=msp.getServiceProvider();
            }
        }

        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=iso-8859-1");

        String site = base.getWebSite().getDisplayTitle(paramsRequest.getUser().getLanguage());
        String name = request.getParameter("name");
        String customer = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        StringBuilder msgToCustomer = new StringBuilder();
        String cuentaCorreo = sprovider.getContactEmail();

        if (cuentaCorreo == null) {
            cuentaCorreo = sprovider.getCreator().getEmail();
        }

        msgToCustomer.append("Gracias por contactarnos...\nEn un lapso de 24 horas responderemos a tu correo electr\363nico.");
        msgToCustomer.append("Contacto: "+sprovider.getContactName()+"\n");
        msgToCustomer.append(cuentaCorreo+"\n");
        msgToCustomer.append(sprovider.getContactPhoneNumber());

        StringBuilder msgToContact = new StringBuilder();
        msgToContact.append("Site: "+site);
        msgToContact.append("\nNombre: "+name);
        msgToContact.append("\nemail: "+customer);
        msgToContact.append("\nAsunto: "+subject);
        msgToContact.append("\nMensaje: "+message);

        try {
            if (customer!=null && customer.trim().length()>0 && message!=null &&
                    message.trim().length()>0 && cuentaCorreo != null) {
                // send email to contact
                InternetAddress address1 = new InternetAddress();
                address1.setAddress(cuentaCorreo);
                ArrayList<InternetAddress> aAddress = new ArrayList<InternetAddress>();
                aAddress.add(address1);
                SWBUtils.EMAIL.sendMail(customer, name, aAddress, null, null, subject, "text/plain", msgToContact.toString(), null, null, null);

                // send email to customer
                address1 = new InternetAddress();
                address1.setAddress(customer);
                aAddress = new ArrayList<InternetAddress>();
                aAddress.add(address1);
                SWBUtils.EMAIL.sendMail(sprovider.getContactEmail(), name, aAddress, null, null, subject, "text/plain", msgToCustomer.toString(), null, null, null);
                out.print("Su correo fue enviado exitosamente");

            } else {
                out.println("Lo sentimos, por el momento no fue posible enviar su comentario.<br>");
                out.println("Falta información para el envío de su correo:<br/>");
                out.println("Debe escribir su correo electrónico y mensaje como minimo<br/><br/>");
            }
        } catch (Exception e) {
            out.print(e);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        SemanticObject sobj;
        ServiceProvider sprovider = null;

        try {
            sprovider = ((MicroSitePyme)paramsRequest.getWebPage()).getServiceProvider();
        }catch(Exception e) {
            String uri = request.getParameter("uri");
            sobj=SemanticObject.createSemanticObject(uri);
            if(sobj.getGenericInstance() instanceof MicroSitePyme) {
                MicroSitePyme msp = (MicroSitePyme) sobj.getGenericInstance();
                sprovider=msp.getServiceProvider();
            }
        }
        
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");

        String cuentaCorreo = sprovider.getContactEmail();
        if (cuentaCorreo == null) {
            cuentaCorreo = sprovider.getCreator().getEmail();
        }

        if (email == null) {
            User user = paramsRequest.getUser();
            boolean modal = Boolean.parseBoolean(base.getAttribute("modal"));
            if (modal) {
                out.println("<script type=\"text/javascript\">");
                out.println("  function justdoit(url) {");
                out.println("    alert('msg='+postText(url));");
                out.println("  }");

                out.println("  function createCoverDiv(divId, bgcolor, opacity) {");
                out.println("    var layer=document.createElement('div');");
                out.println("    layer.id=divId;");
                out.println("    layer.style.width='100%';");
                out.println("    layer.style.height='100%';");
                out.println("    layer.style.backgroundColor=bgcolor;");
                out.println("    layer.style.position='absolute';");
                out.println("    layer.style.top=0;");
                out.println("    layer.style.left=0;");
                out.println("    layer.style.zIndex=1000;");
                out.println("    layer.style.filter='alpha(opacity='+opacity+')';");
                out.println("    layer.style.opacity=opacity/100;");
                out.println("    document.body.appendChild(layer);");
                out.println("  }");

                out.println("  function removeCoverDiv(divId) {");
                out.println("    var layer=document.getElementById(divId);");
                out.println("    var superlayer=document.getElementById('s_'+divId);");
                out.println("    if(layer && superlayer) {");
                out.println("        document.body.removeChild(superlayer);");
                out.println("        document.body.removeChild(layer);");
                out.println("    }");
                out.println("  }");

                out.println("  function displayImage(divId, bgcolor, opacity) {");
                out.println("    createCoverDiv(divId, bgcolor, opacity);");

                out.println("    var contactContainer=document.createElement('div');");
                out.print("contactContainer.innerHTML = ");
                out.print("'<form action=\"\" method=\"post\" >");
                out.print("<table width=\"90%\" bgcolor=\"#FFFFFF\">");
                out.print("<tr>");
                out.print("<td colspan=\"2\">");
                if (sprovider.getTitle(user.getLanguage()) != null) {
                    out.print("<center>" + sprovider.getTitle(user.getLanguage()) + "</center>");
                } else {
                    out.print("<p align=\"center\">Ponte en contacto con nosotros</p>");
                }
                if (sprovider.getContactPhoneNumber() != null) {
                    out.println("<p>Puedes contact&aacute;rnos por tel&eaucte;fono al n&uacute;mero: " + sprovider.getContactPhoneNumber());
                    if (cuentaCorreo != null) {
                        out.println("<br/>O si lo prefieres, env&iacute;a un correo electr&oacute;nico proporcionando la siguiente informaci&oacute;n:");
                    }
                    out.println("</p>");
                }
                out.print("</td>");
                out.print("</tr>");
                out.print("<tr><td colspan=\"2\"><hr /></td></tr>");
                if (cuentaCorreo != null) {
                    out.print("<tr>");
                    out.print("<td width=\"20%\">"+paramsRequest.getLocaleString("name")+"</td>");
                    out.print("<td><input name=\"name\" id=\"name\" size=\"50\" value=\""+(user.isSigned()?user.getFullName():"")+"\" /></td>");
                    out.print("</tr>");
                    out.print("<tr>");
                    out.print("<td>"+paramsRequest.getLocaleString("email")+"</td>");
                    out.print("<td><input name=\"email\" id=\"email\" size=\"50\" value=\""+(user.isSigned()?user.getEmail():"")+"\" /></td>");
                    out.print("</tr>");
                    out.print("<tr>");
                    out.print("<td>"+paramsRequest.getLocaleString("subject")+"</td>");
                    out.print("<td ><input name=\"subject\" id=\"subject\" size=\"50\" /></td>");
                    out.print("</tr>");
                    out.print("<tr>");
                    out.print("<td>"+paramsRequest.getLocaleString("message")+"</td>");
                    out.print("<td ><textarea name=\"message\" id=\"message\" cols=\"40\" rows=\"5\"></textarea></td>");
                    out.print("</tr>");
                }
                out.print("<tr>");
                out.print("<td colspan=\"2\" align=\"center\"><br>");
                SWBResourceURL url=paramsRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT).setMode("sendEmail").setParameter("uri", request.getParameter("uri"));
                if (cuentaCorreo != null) {
                    out.print("<input name=\"submit\" type=\"button\" onclick=\"justdoit(\\'"+url+"\\'+\\'?name=\\'+dojo.byId(\\'name\\').value+\\'&email=\\'+dojo.byId(\\'email\\').value+\\'&subject=\\'+dojo.byId(\\'subject\\').value+\\'&message=\\'+dojo.byId(\\'message\\').value);removeCoverDiv(\\''+divId+'\\')\" value=\""+paramsRequest.getLocaleString("send")+"\" />");
                    out.print("&nbsp;&nbsp;&nbsp;");
                    out.print("<input name=\"reset\" type=\"reset\" value=\""+paramsRequest.getLocaleString("reset")+"\" />");
                    out.print("&nbsp;&nbsp;&nbsp;");
                }
                out.print("<input name=\"cancel\" type=\"button\" onclick=\"removeCoverDiv(\\''+divId+'\\')\" value=\""+paramsRequest.getLocaleString("cancel")+"\" /><br>");
                out.print("</td>");
                out.print("</tr>");
                out.print("</table>");
                out.print("</form>';");
                out.println("    var cwidth=500;");
                out.println("    var cheight=500;");
                out.println("    contactContainer.id='s_'+divId;");
                out.println("    contactContainer.style.zIndex=1001;");
                out.println("    contactContainer.style.position='absolute';");
                out.println("    contactContainer.style.top='50%';");
                out.println("    contactContainer.style.left='50%';");
                out.println("    contactContainer.style.marginLeft=-cwidth/2+'px';");
                out.println("    contactContainer.style.marginTop=-cheight/2+'px';");
                out.println("    contactContainer.style.width=cwidth+'px';");
                out.println("    contactContainer.style.height=cheight+'px';");
                out.println("    document.body.appendChild(contactContainer);");
                out.println("  }");
                out.println("</script>");
                if ( base.getAttribute("link")!=null )
                    out.println("<a href=\"#\" onclick=\"displayImage('cover01','#000000',80)\">"+base.getAttribute("link")+"</a>");
                else if ( base.getAttribute("label")!=null )
                    out.println("<input type=\"button\" onclick=\"displayImage('cover01','#000000',80)\" value=\""+base.getAttribute("label")+"\" />");
                else
                    out.println("<img alt=\""+base.getAttribute("image")+"\" src=\""+webWorkPath+"/"+base.getAttribute("image")+"\" onclick=\"displayImage('cover01','#000000',80)\" />");
            } else {
                out.print("<form action=\""+paramsRequest.getActionUrl()+"\" method=\"post\">");
                out.print("<table width=\"500\" bgcolor=\"#FFFFFF\">");
                out.print("<tr>");
                out.print("<td width=\"20%\">"+paramsRequest.getLocaleString("name")+"</td>");
                out.print("<td><input name=\"name\" id=\"name\" size=\"50\" value=\""+(user.isSigned()?user.getFullName():"")+"\" /></td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>"+paramsRequest.getLocaleString("email")+"</td>");
                out.print("<td><input name=\"email\" id=\"email\" size=\"50\" value=\""+(user.isSigned()?user.getEmail():"")+"\" /></td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td>"+paramsRequest.getLocaleString("subject")+"</td>");
                out.print("<td ><input name=\"subject\" id=\"subject\" size=\"50\" /></td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td valign=\"middle\">"+paramsRequest.getLocaleString("message")+"</td>");
                out.print("<td ><textarea name=\"message\" cols=\"45\" rows=\"5\"></textarea></td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td colspan=\"2\"> &nbsp; </td>");
                out.print("</tr>");
                out.print("<tr>");
                out.print("<td colspan=\"2\" align=\"center\">");
                out.print("<input name=\"submit\" type=\"submit\" value=\""+paramsRequest.getLocaleString("send")+"\" />");
                out.print("&nbsp;&nbsp;&nbsp;");
                out.print("<input name=\"reset\" type=\"reset\" value=\""+paramsRequest.getLocaleString("reset")+"\" />");
                out.print("</td>");
                out.print("</tr>");
                /*out.print("<tr><td colspan=\"2\"><hr /></td></tr>");
                out.print("<tr>");
                out.print("<td colspan=\"2\">");
                out.print("Contacto: "+sprovider.getContactName());
                out.print(sprovider.getContactEmail());
                out.print(sprovider.getContactPhoneNumber());
                out.print("");
                out.print("</td>");
                out.print("</tr>");*/
                out.print("</table>");
                out.print("</form>");
            }
        } else if (email.equals("missdata")) {
            out.println("<pre>");
            out.println("Lo sentimos, por el momento no fue posible enviar su comentario.<br>");
            out.println("Falta información para el envío de su correo:<br/>");
            out.println("Debe escribir su correo electrónico y mensaje como minimo<br/><br/>");
            out.println("<pre>");
        }
    }
}

