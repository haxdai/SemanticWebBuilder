/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.sieps.certificate;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.sieps.Certificado;
import org.semanticwb.sieps.Empresa;
import org.semanticwb.sieps.profile.ProfileResource;


public class CertificateResource extends GenericResource {
    
    public static final String RUTA_JSP     =   "/swbadmin/jsp"; //SWBPortal.getWebWorkPath() + "/models";
    private static Logger logger            =   SWBUtils.getLogger(CertificateResource.class);

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if ("ALTA".equals(mode)) {
            doAlta(request, response, paramRequest);
        } else if ("EMPRESA".equals(mode)) {
            doEmpresa(request, response, paramRequest);
        } else if ("CONFIRMACION".equals(mode)) {
            doConfirmacion(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action   =   response.getAction();        
        String mensaje  =   "";
        User user       =   response.getUser();
        //SWBModel model  =   getResourceBase().getWebSite();
        response.setMode("CONFIRMACION");

        boolean isUser  =   (user != null && user.isSigned());
        if (isUser) {
            if ("ALTA".equals(action)) {
                String  certificadoUri     =   request.getParameter("ceritificadoUri"),
                        empresaUri          =   request.getParameter("empresaUri");

                if (certificadoUri != null && empresaUri != null) {
                    try {
                        certificadoUri  =   URLDecoder.decode(certificadoUri, "UTF-8");
                        empresaUri      =   URLDecoder.decode(empresaUri, "UTF-8");
                        //Busca certificado en el modelo...
                        Certificado cert    =   (Certificado)SemanticObject.createSemanticObject(certificadoUri).createGenericInstance();//Certificado.ClassMgr.getCertificado(ceritificadoUri, null);
                        //Empresa empresa     =   (Empresa)SemanticObject.createSemanticObject(empresaUri).createGenericInstance();

                        //Asigna certificado al usuario...
                        cert.setUsuario(user);
                        mensaje = "Empresa asociada";
                    } catch (Exception e) {
                        logger.error(e);
                        mensaje = "Imposible asociar";
                    }

                }

            } else {
                super.processAction(request, response);
            }
        } else {
            mensaje = "El usuario debe de estar firmado en el sitio para continuar";
        }

        response.setRenderParameter("mensaje", mensaje);
        return;
    }

    
    public void doAlta(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String pathJsp = RUTA_JSP + "/" + getResourceBase().getWebSiteId() + "/" + "certificadoAgrega.jsp";
        try {
            request.setAttribute("paramRequest", paramRequest);
            RequestDispatcher rd    =    request.getRequestDispatcher(pathJsp);
            rd.include(request, response);            
        } catch (Exception e) {
            logger.error(e);
        }
        return;
    }
    public WebPage buscaSeccionPerfil(WebSite webSite) throws SWBResourceException, IOException {
        WebPage webPage =   webSite.getHomePage();
        try {            
            Iterator<WebPage> webPages   =  webSite.listWebPages();            
            while (webPages.hasNext()) {
                WebPage page    =   webPages.next();
                Iterator<Resource> resources =  page.listResources();
                while (resources.hasNext()) {
                    Resource resource           =   resources.next();
                    ResourceType resourceType   =   resource.getResourceType();
                    if (ProfileResource.class.getCanonicalName().equals(resourceType.getResourceClassName())) {
                        webPage = page;
                        return webPage;
                    }
                }
            }

        } catch (Exception e) {
            logger.error(e);
        }
        return webPage;
    }
    public void doEmpresa(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {        
        try {
            StringBuilder buffHTML = new StringBuilder();
            String idCert       =   request.getParameter("idCertificado");
            WebSite webSite     =   getResourceBase().getWebSite();

            //Obiene el certificado
            Certificado cert    =   buscaCertificado(idCert, webSite);

            if (cert != null) {
                //Recupera la empresa...
                Empresa empresa     =   cert.getEmpresa();
                String urlLogo      =   SWBPortal.getWebWorkPath()+empresa.getWorkPath()+"/"+empresa.getLogo();
                buffHTML.append("<input type='hidden' name='ceritificadoUri' id='ceritificadoUri' value='").append(cert.getURI()).append("'/>")
                        .append("<input type='hidden' name='empresaUri' id='empresaUri' value='").append(empresa.getURI()).append("'/>")
                        .append("<img src='").append(urlLogo).append("' width='123' height='123' />")
                        .append("<div id='descripcion'>")
                        .append("<h2>").append(empresa.getName()).append("</h2>")
                        .append("<p id='numeroRegistro'><strong>N&uacute;mero de registro:").append(empresa.getScian().getCode()).append("</strong></p>")
                        .append("<p><strong>Calle</strong>").append("No disponible").append("</p>")
                        .append("<p><strong>Colonia</strong>").append(empresa.getColonia()).append("</p>")
                        .append("<p><strong>Municipio</strong>").append(empresa.getMunicipio()).append("</p>")
                        .append("<p><strong>Estado</strong>").append(empresa.getEstado()).append("</p>")
                        .append("<p><strong>C.P.</strong>").append(empresa.getCp()).append("</p>")
                        .append("<p><strong>R.F.C.</strong>").append(empresa.getRfc()).append("</p>")
                        .append("<p><strong>Correo electr&oacute;nico</strong>").append(empresa.getEmail()).append("</p>")
                        .append("<p><strong>Tel&eacute;fono</strong>").append(empresa.getTelefono()).append("</p>")
                        .append("<p class='centrar'>")
                        .append("<input type='button' value='Aceptar' name='aceptar' class='btn-small' onclick='asociaEmpresa(\"")
                                            .append(paramRequest.getActionUrl().setCallMethod(SWBParamRequest.Call_DIRECT).setAction("ALTA"))
                                            .append("\", this)' />")
                        .append("<input type='button' value='Regresar' name='regresar' class='btn-small' onclick='history.go(-1);'/>")
                        .append("</p>")
                        .append("</div>")
                        .append("<div id='cuponFeet'><p>")
                        .append("<a href='#'>&Eacute;sta no es la empresa que quiero certificar</a>")
                        .append("<a href='#'>Ayuda</a>")
                        .append("</p></div>");
            }
            request.setAttribute("certificado", cert);
            request.setAttribute("paramRequest", paramRequest);

            PrintWriter pw = response.getWriter();
            pw.write(buffHTML.toString());            
        } catch (Exception e) {
            logger.error(e);
        }
        return;
    }
    public void doConfirmacion(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        try {
            WebSite webSite         =   getResourceBase().getWebSite();
            WebPage webPagePerfil   =   buscaSeccionPerfil(webSite);
            String mensaje          =   request.getParameter("mensaje");
            
            StringBuilder buffHTML = new StringBuilder()                                           
                                           .append("<h2>").append(mensaje).append("</h2>")
                                           .append("<p><input type='button' value='Ir a mi perfil' name='borrar' class='btn-medium' onclick='document.location=\"").append(webPagePerfil.getUrl()).append("\"'/></p>")
                                           ;
            PrintWriter pw = response.getWriter();
            pw.write(buffHTML.toString());
            
        } catch (Exception e) {
            logger.error(e);
        }
        return;
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {        

        User user = paramRequest.getUser();
        if (user!= null && user.isSigned()) {
            doAlta(request, response, paramRequest);
        } else {
            String pathJsp  = RUTA_JSP + "/" + getResourceBase().getWebSiteId() + "/" + "certificadoAgrega.jsp";
            request.setAttribute("mensaje", "Funcionalidad exclusiva para los usuarios firmados");
            request.setAttribute("paramRequest", paramRequest);
            try {
                RequestDispatcher rd    =    request.getRequestDispatcher(pathJsp);
                rd.include(request, response);
            } catch (Exception e) {
                logger.error(e);
            }
        }
        return;
    }


    private Certificado buscaCertificado(String idCertificado, SWBModel model) {
        Certificado cert = null;
        if (model ==  null) {
            throw new IllegalArgumentException("Argumento inválido, modelo nulo");
        }
        if (idCertificado != null && idCertificado.length() > 0) {
            Iterator<Certificado> certificados = Certificado.ClassMgr.listCertificados();
            if (certificados != null) {
                while (certificados.hasNext()) {
                    Certificado c = certificados.next();
                    if (c != null && c.getCertificado().equals(idCertificado)) {
                        cert = c;
                        break;
                    }
                }
            }
        }
        return cert;
    }
    
}
