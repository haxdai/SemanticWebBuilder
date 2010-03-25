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
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

// TODO: Auto-generated Javadoc
/**
 * The Class Contact.
 */
public class Contact extends GenericAdmResource {
    
    /** The log. */
    private static Logger log = SWBUtils.getLogger(Banner.class);

    /** The web work path. */
    private String webWorkPath= "/work";

    /**
     * Sets the resource base.
     * 
     * @param base the new resource base
     */
    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            webWorkPath = SWBPortal.getWebWorkPath() +  base.getWorkPath();
        }catch(Exception e) {
            log.error("Error while setting resource base: "+base.getId() +"-"+ base.getTitle(), e);
        }
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#processRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.semanticwb.portal.api.SWBParamRequest)
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        if(paramsRequest.getMode().equalsIgnoreCase("sendEmail")) {
            doSendEmail(request,response,paramsRequest);
        }else {
            super.processRequest(request, response, paramsRequest);
        }
    }

    /**
     * Do send email.
     * 
     * @param request the request
     * @param response the response
     * @param paramsRequest the params request
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doSendEmail(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html; charset=utf-8");

        String site = base.getWebSite().getDisplayTitle(paramRequest.getUser().getLanguage());
        String customerName = request.getParameter("name");
        String customerEmail = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        String contactName = base.getAttribute("name");
        String contactEmail = base.getAttribute("email");
        String contactPhone = base.getAttribute("phone");
        String contactAddress = base.getAttribute("address");
        String title = base.getAttribute("title");

        try {
            if( SWBUtils.EMAIL.isValidEmailAddress(customerEmail) && !isEmpty(subject) && !isEmpty(message) && SWBUtils.EMAIL.isValidEmailAddress(contactEmail) ) {
                StringBuilder msgToCustomer = new StringBuilder();
                msgToCustomer.append(paramRequest.getLocaleString("dear")+" "+customerName+" :\n");
                msgToCustomer.append(paramRequest.getLocaleString("greating"));
                msgToCustomer.append(contactName+"\n");
                msgToCustomer.append(contactEmail+"\n");
                msgToCustomer.append(title==null?"":title+"\n");
                msgToCustomer.append(contactPhone==null?"":contactPhone+"\n");                
                msgToCustomer.append(contactAddress==null?"":contactAddress);
                msgToCustomer.append("\n");

                StringBuilder msgToContact = new StringBuilder();
                msgToContact.append("Site: "+site);
                msgToContact.append("\nNombre: "+customerName);
                msgToContact.append("\nemail: "+customerEmail);
                msgToContact.append("\nAsunto: "+subject);
                msgToContact.append("\nMensaje: "+message);

                // send email to contact
                InternetAddress address1 = new InternetAddress();
                address1.setAddress(contactEmail);
                ArrayList<InternetAddress> aAddress = new ArrayList<InternetAddress>();
                aAddress.add(address1);
                SWBUtils.EMAIL.sendMail(customerEmail, customerName, aAddress, null, null, subject, "text/plain", msgToContact.toString(), null, null, null);

                // send email to customer
                address1 = new InternetAddress();
                address1.setAddress(customerEmail);
                aAddress = new ArrayList<InternetAddress>();
                aAddress.add(address1);
                SWBUtils.EMAIL.sendMail(contactEmail, customerName, aAddress, null, null, subject, "text/plain", msgToCustomer.toString(), null, null, null);
                out.print(paramRequest.getLocaleString("thanks"));
            }else {
                out.print(paramRequest.getLocaleString("apologies"));
            }
        } catch (Exception e) {
            log.error("Error in resource Contact, in PymTur Project, while bringing HTML by ajax. ", e);
        }
        out.flush();
        out.close();
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");

        if(email == null) {
            User user = paramRequest.getUser();
            SWBResourceURL url=paramRequest.getRenderUrl().setCallMethod(paramRequest.Call_DIRECT).setMode("sendEmail");
            String title = base.getAttribute("title");
            String contactPhone = base.getAttribute("phone");
            
            boolean modal = Boolean.parseBoolean(base.getAttribute("modal"));
            if (modal) {
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

                out.println("var s = new String('');");
                out.println("s = s.concat('<div id=\"contacto\">');");
                out.println("s = s.concat('<form name=\"frmContact\" id=\"frmContact\" action=\"\" method=\"post\" class=\"form\" >');");
                if(title != null) {
                    out.println("s = s.concat('<h3>" + title + "</h3>');");
                }else {
                    out.println("s = s.concat('<h3>Ponte en contacto con nosotros</h3>');");
                }
                if(contactPhone != null) {
                    out.println("s = s.concat('<p id=\"contactus\">Puedes contactarnos por tel&eacute;fono al n&uacute;mero: " + contactPhone +".<br />');");
                        out.println("s = s.concat('Si lo prefieres, env&iacute;anos un correo electr&oacute;nico proporcionando la siguiente informaci&oacute;n:');");
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
                out.println("s = s.concat('<label for=\"contactoEnviar\">Enviar</label>');");
                out.println("s = s.concat('<input name=\"submit\" id=\"contactoEnviar\" type=\"button\" onclick=\"sendEmail(\\'"+url+"\\'+\\'&name=\\'+dojo.byId(\\'name\\').value+\\'&email=\\'+dojo.byId(\\'email\\').value+\\'&subject=\\'+dojo.byId(\\'subject\\').value+\\'&message=\\'+dojo.byId(\\'message\\').value); removeCoverDiv(\\''+divId+'\\')\" value=\""+paramRequest.getLocaleString("send")+"\" />');");
                out.println("s = s.concat('<label for=\"contactoRestablecer\">Limpiar</label>');");
                out.println("s = s.concat('<input name=\"reset\" id=\"contactoRestablecer\" type=\"reset\" value=\""+paramRequest.getLocaleString("reset")+"\" />');");
                out.println("s = s.concat('<label for=\"contactoCancelar\">Salir</label>');");
                out.println("s = s.concat('<input name=\"cancel\" id=\"contactoCancelar\" type=\"button\" onclick=\"removeCoverDiv(\\'');");
                out.println("s = s.concat(divId);");
                out.println("s = s.concat('\\')\" value=\""+paramRequest.getLocaleString("cancel")+"\" />');");
                out.println("s = s.concat('</p>');");
                out.println("s = s.concat('</form>');");
                out.println("s = s.concat('</div>');");
                out.println("contactContainer.innerHTML = s;");

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
            }else {
                out.println("<script type=\"text/javascript\">");
                out.println("  function sendEmail(url) {");
                out.println("    alert(postText(url));");
                out.println("  }");
                out.println("</script>");

                out.print("<div class=\"swb-contactus\">");
                out.print("<form name=\"frmContact\" id=\"frmContact\" action=\"\" method=\"post\" >");

                if(title != null) {
                    out.println("<h3>" + title + "</h3>");
                }else {
                    out.println("<h3>Ponte en contacto con nosotros</h3>");
                }
                if(contactPhone != null) {
                    out.println("<p id=\"contactus\">Puedes contactarnos por tel&eacute;fono al n&uacute;mero: " + contactPhone +".<br />");
                        out.println("Si lo prefieres, env&iacute;anos un correo electr&oacute;nico proporcionando la siguiente informaci&oacute;n:");
                    out.println("</p>");
                }
                out.println("<hr />");

                out.print("<div>");
                out.print("<label for=\"name\">"+paramRequest.getLocaleString("name")+"</label>");
                out.print("<input name=\"name\" id=\"name\" size=\"50\" value=\""+(user.isSigned()?user.getFullName():"")+"\" />");
                out.print("</div>");

                out.print("<div>");
                out.print("<label for=\"email\">"+paramRequest.getLocaleString("email")+"</label>");
                out.print("<input name=\"email\" id=\"email\" size=\"50\" value=\""+(user.isSigned()?user.getEmail():"")+"\" />");
                out.print("</div>");

                out.print("<div>");
                out.print("<label for=\"subject\">"+paramRequest.getLocaleString("subject")+"</label>");
                out.print("<input name=\"subject\" id=\"subject\" size=\"50\" />");
                out.print("</div>");

                out.print("<div>");
                out.print("<label for=\"message\">"+paramRequest.getLocaleString("message")+"</label>");
                out.print("<textarea name=\"message\" id=\"message\" cols=\"40\" rows=\"5\"></textarea>");
                out.print("</div>");

                out.print("<div>");
//                SWBResourceURL url=paramRequest.getRenderUrl();
//                url.setCallMethod(url.Call_DIRECT).setMode("sendEmail");
                out.print("<label for=\"contactoEnviar\">Enviar</label>");
                out.print("<input name=\"submit\" id=\"contactoEnviar\" type=\"button\" onclick=\"sendEmail('"+url+"'+'?name='+dojo.byId('name').value+'&email='+dojo.byId('email').value+'&subject='+dojo.byId('subject').value+'&message='+dojo.byId('message').value)\" value=\""+paramRequest.getLocaleString("send")+"\" />");
                out.print("<label for=\"contactoRestablecer\">Limpiar</label>");
                out.print("<input name=\"reset\" id=\"contactoRestablecer\" type=\"reset\" value=\""+paramRequest.getLocaleString("reset")+"\" />");
                out.print("</div>");

                out.print("</form>");
                out.print("</div>");
            }
        } else if (email.equals("missdata")) {
            out.println("<pre>");
            out.println("Lo sentimos, por el momento no fue posible enviar su comentario.<br>");
            out.println("Falta información para el envío de su correo:<br/>");
            out.println("Debe escribir su correo electrónico y mensaje como minimo<br/><br/>");
            out.println("<pre>");
        }
    }

    private boolean isEmpty(String param) {
        boolean empty = true;
        if( param!=null && param.trim().length()>0 )
            empty = false;
        return empty;
    }
}
