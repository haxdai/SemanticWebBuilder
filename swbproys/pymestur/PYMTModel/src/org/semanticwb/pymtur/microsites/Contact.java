

/**
 *
 * @author carlos.ramos
 */

package org.semanticwb.pymtur.microsites;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.mail.internet.InternetAddress;
import javax.servlet.RequestDispatcher;
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
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        ServiceProvider sprovider = null;
        WebPage community = null;
        WebPage currentpage = (WebPage) request.getAttribute("webpage");
        if(currentpage == null) {
            currentpage = paramRequest.getWebPage();
        }
        if(currentpage instanceof MicroSitePyme) {
            community = currentpage;
        }else {
            community = currentpage.getParent();
        }
        MicroSitePyme ms = (MicroSitePyme)community;
        sprovider = ms.getServiceProvider();

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
                msgToCustomer.append(sprovider.getContactPhoneNumber());

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
                out.println(paramRequest.getLocaleString("apologies"));
            }
        } catch (Exception e) {
            out.print(e);
        }
        out.flush();
        out.close();
    }



    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
        response.setHeader("Pragma","no-cache"); //HTTP 1.0
        response.setDateHeader ("Expires", 0); //prevents caching at the proxy server

         try {
            String jspFile=paramRequest.getResourceBase().getAttribute("jspfile","/work/models/etour/jsp/pymestur/microsite/contact.jsp");
            request.setAttribute("webWorkPath", webWorkPath);
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd = request.getRequestDispatcher(jspFile);
            rd.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        String cuentaCorreo=null;
        ServiceProvider sprovider = null;
        User user=paramsRequest.getUser();
        WebPage community = null;
        WebPage currentpage = (WebPage) request.getAttribute("webpage");
        if(currentpage == null) {
            currentpage = paramsRequest.getWebPage();
        }        

       if(paramsRequest.getArgument("iscommunity","false").equals("true")){ //Se ve el recurso desde un micrositio
            if(currentpage instanceof MicroSitePyme) {
                community = currentpage;
            }else {
                community = currentpage.getParent();
            }
            MicroSitePyme ms = (MicroSitePyme)community;
            sprovider = ms.getServiceProvider();
            cuentaCorreo = sprovider.getContactEmail();
            if (cuentaCorreo == null) {
                cuentaCorreo = sprovider.getCreator().getEmail();
            }
        }else if(request.getParameter("uri")!=null){
            SemanticObject semObject = SemanticObject.createSemanticObject(request.getParameter("uri")); //Se ve el recurso desde una ficha
            sprovider = (ServiceProvider) semObject.createGenericInstance();

            cuentaCorreo = sprovider.getContactEmail();
            if (cuentaCorreo == null) {
                cuentaCorreo = sprovider.getCreator().getEmail();
            }
        }else if(user.getEmail()!=null){ //Se ve el recurso desde una página cualquiera
            cuentaCorreo=user.getEmail();
        }else {
            cuentaCorreo="";
        }
        
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");

       
        if (email == null) {
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
                
                //out.print("contactContainer.innerHTML = ");
                out.println("alert('salida 0');");
                out.println("var s = new String('');");

                out.println("s = s.concat('<div id=\"contacto\">');");
                out.println("s = s.concat('<form id=\"frmContact\" action=\"\" method=\"post\" class=\"form\" >');");
                out.println("s = s.concat('<p>');");
                if (sprovider.getTitle(user.getLanguage()) != null) {
                    out.println("s = s.concat('<center>" + sprovider.getTitle(user.getLanguage()) + "</center>');");
                }else if (sprovider.getTitle() != null) {
                    out.println("s = s.concat('<center>" + sprovider.getTitle() + "</center>');");
                }else {
                    out.println("s = s.concat('<p align=\"center\">Ponte en contacto con nosotros</p>');");
                }
                if (sprovider.getContactPhoneNumber() != null) {
                    out.println("s = s.concat('<p>Puedes contactarnos por tel&eacute;fono al n&uacute;mero: " + sprovider.getContactPhoneNumber()+"');");
                    if (cuentaCorreo != null) {
                        out.println("s = s.concat('<br />. Si lo prefieres, env&iacute;anos un correo electr&oacute;nico proporcionando la siguiente informaci&oacute;n:');");
                    }
                    out.println("s = s.concat('</p>');");
                }
                out.println("s = s.concat('</p>');");

                out.println("s = s.concat('<p><hr /></p>');");
                if (cuentaCorreo != null) {
                    out.println("s = s.concat('<p>')");
                    out.println("s = s.concat('<label for=\"name\">"+paramsRequest.getLocaleString("name")+"</label>');");
                    out.println("s = s.concat('<input name=\"name\" id=\"name\" size=\"50\" value=\""+(user.isSigned()?user.getFullName():"")+"\" />');");
                    out.println("s = s.concat('</p>');");

                    out.println("s = s.concat('<p>');");
                    out.println("s = s.concat('<label for=\"email\">"+paramsRequest.getLocaleString("email")+"</label>');");
                    out.println("s = s.concat('<input name=\"email\" id=\"email\" size=\"50\" value=\""+(user.isSigned()?user.getEmail():"")+"\" />');");
                    out.println("s = s.concat('</p>');");

                    out.println("s = s.concat('<p>');");
                    out.println("s = s.concat('<label for=\"subject\">"+paramsRequest.getLocaleString("subject")+"</label>');");
                    out.println("s = s.concat('<input name=\"subject\" id=\"subject\" size=\"50\" />');");
                    out.println("s = s.concat('</p>');");
                    out.println("s = s.concat('<p>');");
                    out.println("s = s.concat('<label for=\"message\">"+paramsRequest.getLocaleString("message")+"</label>');");
                    out.println("s = s.concat('<textarea name=\"message\" id=\"message\" cols=\"40\" rows=\"5\"></textarea>');");
                    out.println("s = s.concat('</p>');");
                }
                out.println("s = s.concat('<p>');");
                SWBResourceURL url=paramsRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT).setMode("sendEmail").setParameter("uri", request.getParameter("uri"));
                if (cuentaCorreo != null) {
                    out.println("s = s.concat('<label for=\"contactoEnviar\">Enviar</label>');");
                    out.println("s = s.concat('<input name=\"submit\" id=\"contactoEnviar\" type=\"button\" onclick=\"sendEmail(\\'"+url+"\\'+\\'?name=\\'+dojo.byId(\\'name\\').value+\\'&email=\\'+dojo.byId(\\'email\\').value+\\'&subject=\\'+dojo.byId(\\'subject\\').value+\\'&message=\\'+dojo.byId(\\'message\\').value);removeCoverDiv(\\''+divId+'\\')\" value=\""+paramsRequest.getLocaleString("send")+"\" />');");
                    out.println("s = s.concat('<label for=\"contactoRestablecer\">Enviar</label>');");
                    out.println("s = s.concat('<input name=\"reset\" id=\"contactoRestablecer\" type=\"reset\" value=\""+paramsRequest.getLocaleString("reset")+"\" />');");
                }
                out.println("s = s.concat('<label for=\"contactoCancelar\">Enviar</label>');");
                //out.println("s.concat('<input name=\"cancel\" id=\"contactoCancelar\" type=\"button\" onclick=\"removeCoverDiv(\\''+divId+'\\')\" value=\""+paramsRequest.getLocaleString("cancel")+"\" />');");
                out.println("s = s.concat('<input name=\"cancel\" id=\"contactoCancelar\" type=\"button\" onclick=\"removeCoverDiv(\\'');");
                out.println("s = s.concat(divId);");
                out.println("s = s.concat('\\')\" value=\""+paramsRequest.getLocaleString("cancel")+"\" />');");
                out.println("s = s.concat('</p>');");
                out.println("s = s.concat('</form>');");
                out.println("s = s.concat('</div>');");
                out.println("contactContainer.innerHTML = s;");
                out.println("alert('salida 1');");
                out.println("alert(s);");

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
                if (cuentaCorreo != null) {
                    out.print("<div id=\"contacto\">");
                    out.print("<form id=\"frmContact\" action=\""+paramsRequest.getActionUrl()+"\" method=\"post\" class=\"form\" >");
                    out.print("<p>");
                    out.print("<label for=\"name\">"+paramsRequest.getLocaleString("name")+"</label>");
                    out.print("<input name=\"name\" id=\"name\" size=\"50\" value=\""+(user.isSigned()?user.getFullName():"")+"\" />");
                    out.print("</p>");

                    out.print("<p>");
                    out.print("<label for=\"email\">"+paramsRequest.getLocaleString("email")+"</label>");
                    out.print("<input name=\"email\" id=\"email\" size=\"50\" value=\""+(user.isSigned()?user.getEmail():"")+"\" />");
                    out.print("</p>");

                    out.print("<p>");
                    out.print("<label for=\"subject\">"+paramsRequest.getLocaleString("subject")+"</label>");
                    out.print("<input name=\"subject\" id=\"subject\" size=\"50\" />");
                    out.print("</p>");
                    out.print("<p>");
                    out.print("<label for=\"message\">"+paramsRequest.getLocaleString("message")+"</label>");
                    out.print("<textarea name=\"message\" id=\"message\" cols=\"40\" rows=\"5\"></textarea>");
                    out.print("</p>");
                }
                out.print("<p>");
                SWBResourceURL url=paramsRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT).setMode("sendEmail").setParameter("uri", request.getParameter("uri"));
                if (cuentaCorreo != null) {
                    out.print("<label for=\"contactoEnviar\">Enviar</label>");
                    out.print("<input name=\"submit\" id=\"contactoEnviar\" type=\"button\" onclick=\"sendEmail(\\'"+url+"\\'+\\'?name=\\'+dojo.byId(\\'name\\').value+\\'&email=\\'+dojo.byId(\\'email\\').value+\\'&subject=\\'+dojo.byId(\\'subject\\').value+\\'&message=\\'+dojo.byId(\\'message\\').value);removeCoverDiv(\\''+divId+'\\')\" value=\""+paramsRequest.getLocaleString("send")+"\" />");
                    out.print("<label for=\"contactoRestablecer\">Enviar</label>");
                    out.print("<input name=\"reset\" id=\"contactoRestablecer\" type=\"reset\" value=\""+paramsRequest.getLocaleString("reset")+"\" />");
                }
                out.print("<label for=\"contactoCancelar\">Enviar</label>");
                out.print("<input name=\"cancel\" id=\"contactoCancelar\" type=\"button\" onclick=\"removeCoverDiv(\\''+divId+'\\')\" value=\""+paramsRequest.getLocaleString("cancel")+"\" /><br>");
                out.print("</p>");
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
    }**/
}

