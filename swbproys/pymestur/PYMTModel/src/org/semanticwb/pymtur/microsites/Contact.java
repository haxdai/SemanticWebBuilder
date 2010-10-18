

/**
 *
 * @author carlos.ramos
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
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
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        if(paramRequest.getMode().equalsIgnoreCase("sendEmail")) {
            doSendEmail(request,response,paramRequest);
        }else {
            super.processRequest(request, response, paramRequest);
        }
    }

    public void doSendEmail(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        ServiceProvider sprovider = null;
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;

        if(request.getParameter("uri")==null) { //Se ve el recurso desde un micrositio
            if(wp instanceof MicroSitePyme) {
                community = wp;
            }else {
                community = wp.getParent();
            }
            MicroSitePyme ms = (MicroSitePyme)community;
            sprovider = ms.getServiceProvider();
        }else {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri")); //Se ve el recurso desde una ficha
            sprovider = (ServiceProvider) semObject.createGenericInstance();
        }
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        String site = base.getWebSite().getDisplayTitle(paramRequest.getUser().getLanguage());
        String customerName = request.getParameter("name");
        String customerEmail = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        String sproviderEmail = sprovider.getContactEmail();

        if (sproviderEmail == null) {
            sproviderEmail = sprovider.getCreator().getEmail();
        }
        try {
            if( customerEmail!=null && customerEmail.trim().length()>0 && message!=null && message.trim().length()>0 && sproviderEmail!=null ) {
                StringBuilder msgToCustomer = new StringBuilder();
                msgToCustomer.append(paramRequest.getLocaleString("dear")+" "+customerName+" :\n");
                msgToCustomer.append(paramRequest.getLocaleString("greating"));
                msgToCustomer.append(sprovider.getContactName()+"\n");
                msgToCustomer.append(sproviderEmail+"\n");
                msgToCustomer.append(sprovider.getContactPhoneNumber()==null?"":sprovider.getContactPhoneNumber()+"\n");
                msgToCustomer.append(sprovider.getTitle()+"\n");
                msgToCustomer.append(sprovider.getStreetName()==null?"":sprovider.getStreetName()+" ");
                msgToCustomer.append(sprovider.getExtNumber()==null?"":sprovider.getExtNumber()+" ");
                msgToCustomer.append(sprovider.getIntNumber()==null?"":sprovider.getIntNumber()+" ");
                msgToCustomer.append("\n");
                msgToCustomer.append(sprovider.getCityCouncil()==null?"":sprovider.getCityCouncil()+". ");
                msgToCustomer.append(sprovider.getCity()==null?"":sprovider.getCity());
                msgToCustomer.append("\n");
                msgToCustomer.append(sprovider.getState()==null?"":sprovider.getState()+" .");

                StringBuilder msgToContact = new StringBuilder();
                msgToContact.append("Site: "+site);
                msgToContact.append("\nNombre: "+customerName);
                msgToContact.append("\nemail: "+customerEmail);
                msgToContact.append("\nAsunto: "+subject);
                msgToContact.append("\nMensaje: "+message);

                // send email to contact
                InternetAddress address1 = new InternetAddress();
                address1.setAddress(sproviderEmail);
                ArrayList<InternetAddress> aAddress = new ArrayList<InternetAddress>();
                aAddress.add(address1);
                SWBUtils.EMAIL.sendMail(customerEmail, customerName, aAddress, null, null, subject, "text/plain", msgToContact.toString(), null, null, null);

                // send email to customer
                address1 = new InternetAddress();
                address1.setAddress(customerEmail);
                aAddress = new ArrayList<InternetAddress>();
                aAddress.add(address1);
                SWBUtils.EMAIL.sendMail(sprovider.getContactEmail(), customerName, aAddress, null, null, subject, "text/plain", msgToCustomer.toString(), null, null, null);
                out.print(paramRequest.getLocaleString("thanks"));
            } else {
                out.print(paramRequest.getLocaleString("apologies"));
            }
        } catch (Exception e) {
            log.error("Error in resource Contact, in PymTur Project, while bringing HTML by ajax. ", e);
            out.print(paramRequest.getLocaleString("apologies"));
        }
        out.flush();
        out.close();
    }
 
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        User user = paramRequest.getUser();
        ServiceProvider sprovider = null;
        WebPage wp = paramRequest.getWebPage();
        WebPage community = null;

        if(request.getParameter("uri")==null) { //Se ve el recurso desde un micrositio
            if(wp instanceof MicroSitePyme) {
                community = wp;
            }else {
                community = wp.getParent();
            }
            MicroSitePyme ms = (MicroSitePyme)community;
            sprovider = ms.getServiceProvider();
        }else {
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri")); //Se ve el recurso desde una ficha
            sprovider = (ServiceProvider) semObject.createGenericInstance();
        }
        
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");

       
        if(email == null) {
            boolean modal = Boolean.parseBoolean(base.getAttribute("modal"));
            if(modal) {
                out.println("<script type=\"text/javascript\">");

                out.println("  function sendEmail(url) {");
                out.println("    alert(postText(url));");
                out.println("  }");

                out.println("  function createCoverDiv(divId, bgcolor, opacity) {");
                out.println("    var layer=document.createElement('div');");
                out.println("    layer.id=divId;");
                out.println("    layer.style.width='100%';");
                out.println("    layer.style.height='100%';");
                out.println("    layer.style.backgroundColor=bgcolor;");
                out.println("    layer.style.position='fixed';");
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
                
                out.println("var s = new String('');");
                out.println("s = s.concat('<div id=\"contacto\">');");
                out.println("s = s.concat('<form id=\"frmContact\" action=\"\" method=\"post\" class=\"form\" >');");
                if (sprovider.getTitle(user.getLanguage()) != null) {
                    out.println("s = s.concat('<h3>" + sprovider.getTitle(user.getLanguage()) + "</h3>');");
                }else if (sprovider.getTitle() != null) {
                    out.println("s = s.concat('<h3>" + sprovider.getTitle() + "</h3>');");
                }else {
                    out.println("s = s.concat('<h3>Ponte en contacto con nosotros</h3>');");
                }
                if (sprovider.getContactPhoneNumber() != null) {
                    out.println("s = s.concat('<p id=\"contactus\">"+paramRequest.getLocaleString("instruction1")+" "+sprovider.getContactPhoneNumber()+".<br />');");
                        out.println("s = s.concat('"+paramRequest.getLocaleString("instruction2")+"');");
                    out.println("s = s.concat('</p>');");
                }
                out.println("s = s.concat('<hr />');");
                out.println("s = s.concat('<p>')");
                out.println("s = s.concat('<label for=\"name\">"+paramRequest.getLocaleString("name")+"</label>');");
                out.println("s = s.concat('<input name=\"name\" id=\"name\" size=\"50\" value=\""+(user.isSigned()?user.getFullName():"")+"\" />');");
                out.println("s = s.concat('</p>');");

                out.println("s = s.concat('<p>');");
                out.println("s = s.concat('<label for=\"email\">"+paramRequest.getLocaleString("email")+"</label>');");
                out.println("s = s.concat('<input name=\"email\" id=\"email\" size=\"50\" value=\""+(user.isSigned()?user.getEmail():"")+"\" />');");
                out.println("s = s.concat('</p>');");

                out.println("s = s.concat('<p>');");
                out.println("s = s.concat('<label for=\"subject\">"+paramRequest.getLocaleString("subject")+"</label>');");
                out.println("s = s.concat('<input name=\"subject\" id=\"subject\" size=\"50\" />');");
                out.println("s = s.concat('</p>');");
                out.println("s = s.concat('<p>');");
                out.println("s = s.concat('<label for=\"message\">"+paramRequest.getLocaleString("message")+"</label>');");
                out.println("s = s.concat('<textarea name=\"message\" id=\"message\" cols=\"40\" rows=\"5\"></textarea>');");
                out.println("s = s.concat('</p>');");
                out.println("s = s.concat('<p  id=\"cmdContact\">');");
                SWBResourceURL url=paramRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT).setMode("sendEmail").setParameter("uri", sprovider.getURI());
                out.println("s = s.concat('<label for=\"contactoEnviar\">"+paramRequest.getLocaleString("send")+"</label>');");
                out.println("s = s.concat('<input name=\"submit\" id=\"contactoEnviar\" type=\"button\" onclick=\"sendEmail(\\'"+url+"\\'+\\'&name=\\'+dojo.byId(\\'name\\').value+\\'&email=\\'+dojo.byId(\\'email\\').value+\\'&subject=\\'+dojo.byId(\\'subject\\').value+\\'&message=\\'+dojo.byId(\\'message\\').value); removeCoverDiv(\\''+divId+'\\')\" value=\""+paramRequest.getLocaleString("send")+"\" />');");
                out.println("s = s.concat('<label for=\"contactoRestablecer\">"+paramRequest.getLocaleString("reset")+"</label>');");
                out.println("s = s.concat('<input name=\"reset\" id=\"contactoRestablecer\" type=\"reset\" value=\""+paramRequest.getLocaleString("reset")+"\" />');");
                out.println("s = s.concat('<label for=\"contactoCancelar\">"+paramRequest.getLocaleString("cancel")+"</label>');");
                out.println("s = s.concat('<input name=\"cancel\" id=\"contactoCancelar\" type=\"button\" onclick=\"removeCoverDiv(\\'');");
                out.println("s = s.concat(divId);");
                out.println("s = s.concat('\\')\" value=\""+paramRequest.getLocaleString("cancel")+"\" />');");
                out.println("s = s.concat('</p>');");
                out.println("s = s.concat('</form>');");
                out.println("s = s.concat('</div>');");
                out.println("contactContainer.innerHTML = s;");

                out.println("    var cwidth=650;");
                out.println("    var cheight=350;");
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
            }else {
                //if (customerEmail != null) {
                    out.print("<div id=\"contacto\">");
                    out.print("<form id=\"frmContact\" action=\""+paramRequest.getActionUrl()+"\" method=\"post\" class=\"form\" >");
                    out.print("<p>");
                    out.print("<label for=\"name\">"+paramRequest.getLocaleString("name")+"</label>");
                    out.print("<input name=\"name\" id=\"name\" size=\"50\" value=\""+(user.isSigned()?user.getFullName():"")+"\" />");
                    out.print("</p>");

                    out.print("<p>");
                    out.print("<label for=\"email\">"+paramRequest.getLocaleString("email")+"</label>");
                    out.print("<input name=\"email\" id=\"email\" size=\"50\" value=\""+(user.isSigned()?user.getEmail():"")+"\" />");
                    out.print("</p>");

                    out.print("<p>");
                    out.print("<label for=\"subject\">"+paramRequest.getLocaleString("subject")+"</label>");
                    out.print("<input name=\"subject\" id=\"subject\" size=\"50\" />");
                    out.print("</p>");
                    out.print("<p>");
                    out.print("<label for=\"message\">"+paramRequest.getLocaleString("message")+"</label>");
                    out.print("<textarea name=\"message\" id=\"message\" cols=\"40\" rows=\"5\"></textarea>");
                    out.print("</p>");
                //}
                out.print("<p>");
                SWBResourceURL url=paramRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT).setMode("sendEmail").setParameter("uri", request.getParameter("uri"));
                //if (customerEmail != null) {
                    out.print("<label for=\"contactoEnviar\">Enviar</label>");
                    out.print("<input name=\"submit\" id=\"contactoEnviar\" type=\"button\" onclick=\"sendEmail(\\'"+url+"\\'+\\'?name=\\'+dojo.byId(\\'name\\').value+\\'&email=\\'+dojo.byId(\\'email\\').value+\\'&subject=\\'+dojo.byId(\\'subject\\').value+\\'&message=\\'+dojo.byId(\\'message\\').value);removeCoverDiv(\\''+divId+'\\')\" value=\""+paramRequest.getLocaleString("send")+"\" />");
                    out.print("<label for=\"contactoRestablecer\">Enviar</label>");
                    out.print("<input name=\"reset\" id=\"contactoRestablecer\" type=\"reset\" value=\""+paramRequest.getLocaleString("reset")+"\" />");
                //}
                out.print("<label for=\"contactoCancelar\">Enviar</label>");
                out.print("<input name=\"cancel\" id=\"contactoCancelar\" type=\"button\" onclick=\"removeCoverDiv(\\''+divId+'\\')\" value=\""+paramRequest.getLocaleString("cancel")+"\" /><br>");
                out.print("</p>");
                out.print("</form>");
                out.print("</div>");
            }
        } else if (email.equals("missdata")) {
            out.println("<pre>");
            out.println("Lo sentimos, por el momento no fue posible enviar su comentario.<br>");
            out.println("Falta información para el envío de su correo:<br/>");
            out.println("Debe escribir su correo electr&oacute;nico y mensaje como minimo<br/><br/>");
            out.println("<pre>");
        }
    }
}

