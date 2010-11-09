package org.semanticwb.pymtur.registry;


import java.io.IOException;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import org.semanticwb.SWBPortal;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBParamRequest;

/**
 * Gestiona el flujo de informacion entre las pantallas necesarias para realizar
 * el registro de empresas.
 * @author jose.jimenez
 */
public class ControlRegistry extends GenericResource {


    private static Logger log = SWBUtils.getLogger(ControlRegistry.class);


    public ControlRegistry() {}

    /*
    @Override
    public void processRequest(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {

        if (paramRequest.getMode().equals("formaPago")) {
            formaPago(request, response, paramRequest);
        } else if (paramRequest.getMode().equals("capturaDatos")) {
            capturaDatos(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }
     */

    @Override
    public void processAction(HttpServletRequest request,
            SWBActionResponse response) throws SWBResourceException, IOException {

        String action = response.getAction();
        HttpSession session = request.getSession();
        if (action.equalsIgnoreCase("formaPago")) {
            RegistryVO reg = new RegistryVO();
            reg.setTiempoPublicacion(Integer.parseInt(request.getParameter("tiempo")));
            reg.setBanco(request.getParameter("Banco"));
            reg.setCuentaBanco(request.getParameter("Cuenta"));
            reg.setClabeBanco(request.getParameter("Clabe"));
            reg.setReferenciaBanco(request.getParameter("Referencia"));
            session.setAttribute("datosRegistro", reg);
            request.setAttribute("action", "formaPago");
            if (reg.getBanco().equalsIgnoreCase("") || reg.getCuentaBanco().equalsIgnoreCase("")) {
                request.setAttribute("error", "si");
            }
        } else if (action.equalsIgnoreCase("formaRegistro")) {
            RegistryVO reg = (RegistryVO) session.getAttribute("datosRegistro");
            if (reg != null) {
                reg.setNombreUsuario(request.getParameter("Usuario"));
                reg.setContrasenia(request.getParameter("Contrasenia"));
                reg.setRazonSocial(request.getParameter("RazonSocial"));
                reg.setCalle(request.getParameter("CalleFiscal1"));
                reg.setColonia(request.getParameter("ColoniaFiscal1"));
                reg.setCp(request.getParameter("CodigoPostalFiscal1"));
                reg.setEstado(Integer.parseInt(request.getParameter("EstadoFiscal1")));
                reg.setMunicipio(Integer.parseInt(request.getParameter("DelegacionMunicipioFiscal1")));
                reg.setCiudad(request.getParameter("CiudadFiscal1"));
                reg.setGiro(request.getParameter("Giro"));
                reg.setTipoEmpresa(request.getParameter("Tipo"));
                reg.setServicios(request.getParameter("Servicios"));
                reg.setInstalaciones(request.getParameter("Instalaciones"));
                reg.setRfc(request.getParameter("RFC"));
                reg.setCalleFiscal(request.getParameter("CalleFiscal2"));
                reg.setColoniaFiscal(request.getParameter("ColoniaFiscal2"));
                reg.setCpFiscal(request.getParameter("CodigoPostalFiscal2"));
                reg.setEstadoFiscal(Integer.parseInt(request.getParameter("EstadoFiscal2")));
                reg.setMunicipioFiscal(Integer.parseInt(request.getParameter("DelegacionMunicipioFiscal2")));
                reg.setCiudadFiscal(request.getParameter("CiudadFiscal2"));
                reg.setNombre(request.getParameter("Nombre"));
                reg.setPaterno(request.getParameter("ApellidoPaterno"));
                reg.setMaterno(request.getParameter("ApellidoMaterno"));
                reg.setCorreo(request.getParameter("Email"));
                reg.setLada(request.getParameter("Lada"));
                reg.setTelefono(request.getParameter("Telefono"));
                session.setAttribute("datosRegistro", reg);
                request.setAttribute("action", "formaRegistro");
                if (reg.getRazonSocial().equalsIgnoreCase("") ||
                        reg.getGiro().equalsIgnoreCase("") ||
                        reg.getTipoEmpresa().equalsIgnoreCase("") ||
                        reg.getPaterno().equalsIgnoreCase("") ||
                        reg.getCorreo().equalsIgnoreCase("") ||
                        reg.getTelefono().equalsIgnoreCase("")) {
                    request.setAttribute("error", "si");
                }
            }
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest reqParams) throws IOException, SWBResourceException {

        String action = (String) request.getAttribute("action");
        String error = (String) request.getAttribute("error");
        String siteWorkDir = SWBPortal.getWebWorkPath() + "/models/" + reqParams.getWebPage().getWebSiteId();
        String path = siteWorkDir + "/jsp/pymestur/registry/";


        if (action.equalsIgnoreCase("formaPago")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(path + "Registro.jsp");
            if (dispatcher != null) {
                try {
                    dispatcher.include(request, response);
                } catch (javax.servlet.ServletException se) {
                    ControlRegistry.log.error("Error al ejecutar JSP", se);
                }
            }
        } else if (action.equalsIgnoreCase("formaRegistro")) {
            String programa = null;
            HttpSession session = request.getSession();
            RegistryVO reg = (RegistryVO) session.getAttribute("datosRegistro");

            if (reg.getPaquete() == 0) {
                programa = "Activacion.jsp";
            } else {
                programa = "Pago.jsp";
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(path + programa);
            if (dispatcher != null) {
                try {
                    dispatcher.include(request, response);
                } catch (javax.servlet.ServletException se) {
                    ControlRegistry.log.error("Error al ejecutar JSP", se);
                }
            }
        }
    }

}
