/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.sieps.profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericIterator;
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
import org.semanticwb.sieps.Busqueda;
import org.semanticwb.sieps.Busquedas;
import org.semanticwb.sieps.Certificado;
import org.semanticwb.sieps.Empresa;
import org.semanticwb.sieps.EmpresaInteres;
import org.semanticwb.sieps.search.SearchResource;


public class ProfileResource extends GenericResource {
    
    public static final String RUTA_JSP     =   "/swbadmin/jsp"; //SWBPortal.getWebWorkPath() + "/models";
    private static Logger logger            = SWBUtils.getLogger(ProfileResource.class);

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String action   =   response.getAction();
        User user       =   response.getUser();
        boolean isUser  =   (user != null && user.isSigned());
        String mensaje  =   "";
        SWBModel webSite = getResourceBase().getWebSite();
        response.setMode(SWBParamRequest.Mode_VIEW);
        
        try {
            if (isUser) {
                if ("eliminaConsulta".equals(action)) {
                    String[] busquedas   =   request.getParameterValues("checkBusqueda");
                    if (busquedas!= null) {
                        for (String uriBusqueda : busquedas) {
                           Iterator<Busquedas> itBusquedas = Busquedas.ClassMgr.listBusquedases();
                           while (itBusquedas.hasNext()) {
                                Busquedas busquedasUsr = itBusquedas.next();
                                User userBusq   =   busquedasUsr.getUsuario();
                                if (userBusq.equals(user)
                                        && busquedasUsr.getBusqueda().getURI().equals(uriBusqueda)) {
                                    Busquedas.ClassMgr.removeBusquedas(busquedasUsr.getId(), webSite);
                                }                               
                           }
                        }
                    }
                    mensaje = "La(s) búsqueda(s) ha(n) sido eliminada(s) de su carpeta";
                } else if ("eliminaEmpresasInteres".equals(action)) {
                    String[] empresas   =   request.getParameterValues("checkEmpInt");
                    if (empresas != null) {
                        for (String uriEmpresas : empresas) {
                            Iterator<EmpresaInteres> itEmpresas     = EmpresaInteres.ClassMgr.listEmpresaIntereses();
                            while (itEmpresas.hasNext()) {
                                EmpresaInteres empIntUsr    =   itEmpresas.next();
                                User userEmpInt             =   empIntUsr.getUsuario();
                                if (userEmpInt.equals(user)
                                        && empIntUsr.getEmpresa().getId().equals(uriEmpresas)) {
                                    EmpresaInteres.ClassMgr.removeEmpresaInteres(empIntUsr.getId(), webSite);
                                }
                            }
                        }
                    }
                    mensaje = "La(s) empresa(s) ha(n) sido eliminada(s) de su carpeta";
                } else if ("eliminaEmpresasCert".equals(action)) {
                    String[] empresas   =   request.getParameterValues("checkEmpCert");                    
                    if (empresas != null) {
                        for (String uriEmpresas : empresas) {
                            Iterator<Certificado> itCert     = Certificado.ClassMgr.listCertificados();
                            while (itCert.hasNext()) {
                                Certificado cert    =   itCert.next();
                                User userCert       =   cert.getUsuario();
                                if (user.equals(userCert)
                                        && cert.getEmpresa().getURI().equals(uriEmpresas)) {
                                    cert.removeUsuario();
                                }
                            }
                        }
                    }
                    mensaje = "La(s) empresa(s) ha(n) sido eliminada(s) de su carpeta";
                } else {
                    super.processAction(request, response);
                }
            } else {
                mensaje = "El usuario debe de estar firmado en el sistema";
            }
        } catch (Exception e) {
            logger.error(e);
            mensaje = "Imposible agregar a carpeta por el momento";
        }       
        response.setRenderParameter("mensaje", mensaje);
        return;
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if ("PERFIL".equals(mode)) {            
            doPerfil(request, response, paramRequest);
        }  else {
            super.processRequest(request, response, paramRequest);
        }
    }
    /**
     *
     * @param request
     * @param response
     * @param paramRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doPerfil(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        String pathJsp                    = RUTA_JSP + "/" + getResourceBase().getWebSiteId() + "/" + "perfilUsuario.jsp";
        
        List<Busqueda> listBusquedas      = Collections.emptyList();
        List<Empresa> listEmpresasCert    = Collections.emptyList();
        List<Empresa> listEmpresasInteres = Collections.emptyList();

        try {
            SWBModel webSite    =   getResourceBase().getWebSite();
            User user           =   paramRequest.getUser();
            boolean isUser      =   (user != null && user.isSigned());

            if (isUser) {

                //Recupera las búsquedas guardadas...
                Iterator<Busquedas> busquedas = Busquedas.ClassMgr.listBusquedases(webSite);//Busquedas.ClassMgr.listBusquedasByUsuario(user, webSite);
                if (busquedas != null) {
                    listBusquedas   =   new ArrayList<Busqueda>();
                    while (busquedas.hasNext()) {
                        Busquedas busq = busquedas.next();
                        if (busq != null){
                            User usrBusq    =   busq.getUsuario();
                            if (usrBusq != null && user.getURI().equals(usrBusq.getURI())) {
                                listBusquedas.addAll(obtieneBusquedasUsuario(busq.listBusquedas()));
                            }
                        }
                    }
                }
                
                //Recupera empresas certificadas...
                Iterator<Certificado> certificados  =   Certificado.ClassMgr.listCertificados();//Certificado.ClassMgr.listCertificadoByUsuario(user);
                if (certificados != null) {
                    listEmpresasCert = new ArrayList<Empresa>();
                    while (certificados.hasNext()) {
                        Certificado cert = certificados.next();
                        if (cert != null)  {
                            User userCert    = cert.getUsuario();
                            if (userCert != null
                                    && user.getURI().equals(userCert.getURI())
                                    && cert.getEmpresa() != null) {
                                    listEmpresasCert.add(cert.getEmpresa());
                            }
                        }
                    }
                }
                
                //Recupera empresas de interés...
                Iterator<EmpresaInteres> interes = EmpresaInteres.ClassMgr.listEmpresaIntereses(webSite);
                if (interes != null) {
                    listEmpresasInteres =   new ArrayList<Empresa>();
                    while (interes.hasNext()) {
                        EmpresaInteres inter =  interes.next();
                        if (inter != null && inter.getEmpresa() != null)  {
                            User userInteres     =  inter.getUsuario();
                            Empresa e            =  inter.getEmpresa();
                            SemanticObject so   = SemanticObject.createSemanticObject(e.getId());
                            if (so != null) {
                                Empresa eInst   = (Empresa)so.createGenericInstance();
                                if (e.getId() != null) {
                                    if (userInteres != null
                                            && user.getURI().equals(userInteres.getURI())
                                            && inter.getEmpresa() != null
                                            && !listEmpresasInteres.contains(eInst))
                                    listEmpresasInteres.add(eInst);
                                }
                            }
                        }
                    }
                }
            }

            request.setAttribute("seccionResultados", buscaSeccionResultados(getResourceBase().getWebSite()));
            request.setAttribute("busquedas", listBusquedas);
            request.setAttribute("empresasCertificadas", listEmpresasCert);
            request.setAttribute("empresasInteres", listEmpresasInteres);

            request.setAttribute("paramRequest", paramRequest);

            RequestDispatcher rd    =    request.getRequestDispatcher(pathJsp);
            rd.include(request, response);

        } catch (Exception e) {
            logger.error(e);
        }
        return;
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        User user = paramRequest.getUser();
        if (user!= null && user.isSigned()) {
            doPerfil(request, response, paramRequest);
        } else {
            String pathJsp  = RUTA_JSP + "/" + getResourceBase().getWebSiteId() + "/" + "perfilUsuario.jsp";
            request.setAttribute("mensajeUsr", "Funcionalidad exclusiva para usuarios firmados");
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
    /**
     * Construye una colección con las búsquedas a partir de un conjunto de resultados
     * @param busquedas Conjunto de resultados
     * @return Colección con la información
     */
    private List<Busqueda> obtieneBusquedasUsuario(GenericIterator<Busqueda> busquedas) {
        List<Busqueda> listBusquedas = Collections.emptyList();
        if (busquedas != null) {
            listBusquedas   =   new ArrayList<Busqueda>();
            while (busquedas.hasNext()) {
                Busqueda busc   =   busquedas.next();
                if (busc != null && !listBusquedas.contains(busc)) {
                    listBusquedas.add(busc);                    
                }
            }
        }
        return listBusquedas;
    }

    public WebPage buscaSeccionResultados(WebSite webSite) throws SWBResourceException, IOException {
        WebPage webPage =   webSite.getHomePage();
        try {
            Iterator<WebPage> webPages   =  webSite.listWebPages();
            while (webPages.hasNext()) {
                WebPage page    =   webPages.next();
                Iterator<Resource> resources =  page.listResources();
                while (resources.hasNext()) {
                    Resource resource           =   resources.next();
                    ResourceType resourceType   =   resource.getResourceType();
                    if (SearchResource.class.getCanonicalName().equals(resourceType.getResourceClassName())) {
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
}
