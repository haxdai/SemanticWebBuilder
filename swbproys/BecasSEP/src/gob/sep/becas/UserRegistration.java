/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.sep.becas;

import java.io.IOException;
import java.util.*;
import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.*;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticLiteral;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author serch
 */
public class UserRegistration extends GenericResource {
    ///work/models/Beca_SEP/CSS/estilos_lightBox.css
    String tplt = "<form id=\"formaRegistro\" method=\"post\" action=\"{$actionURL}\"><link type=\"text/css\" rel=\"stylesheet\" href=\"{$rutacss}\" />\n"+ // /work/estilos_lightBox.css
        "<h2>Crear Cuenta</h2>\n"+
        "<p>&nbsp;</p>\n"+
        "<p class=\"introPop\">Bienvenido, para enviarte la informaci&oacute;n actualizada sobre las fechas ofrecidas por el Gobierno Federal, llena los siguientes datos:</p>\n"+
        "<p class=\"introPop\">La cuenta del portal de becas le permite acceder a la informaci&oacute;n y otros servicios. Si ya te registraste en el</p>\n"+
        "<p class=\"introPop\">portal, <a href=\"#\">entra a tu cuenta  aqu&iacute;</a></p>\n"+
        "<h5>Informaci&oacute;n del Usuario</h5>\n"+
        "<p class=\"obligatorio\">*Datos Obligatorios, favor de proporcionarlos</p>\n"+
        "<p>\n"+
        "  <label for=\"mail\">Correo Electr&oacute;nico*</label>\n"+
        "  <input type=\"text\" name=\"mail\" id=\"mail\" class=\"inputPop\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"clave\">Contrase&ntilde;a*</label>\n"+
        "  <input type=\"password\" name=\"clave\" id=\"clave\" class=\"inputPop\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p class=\"popText\">Nivel de Seguridad</p>\n"+
        "<p>\n"+
        "  <label for=\"clave2\">Confirmar contrase&ntilde;a*</label>\n"+
        "  <input type=\"password\" name=\"clave2\" id=\"clave2\" class=\"inputPop\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Datos para recuperar contrase&ntilde;a</h5>\n"+
        "<p>\n"+
        "  <label for=\"preguntaSecreta\">Pregunta de seguridad*</label>\n"+
        "  <select name=\"preguntaSecreta\" size=\"1\" class=\"inputPop\" id=\"preguntaSecreta\">\n"+
        "    <option value=\"-1\">selecciona tu pregunta de seguridad</option>\n"+
        "{$preguntas}"+
        "  </select>\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"respuestaSecreta\">Respuesta</label>\n"+
        "  <input type=\"text\" name=\"respuestaSecreta\" id=\"respuestaSecreta\" class=\"inputPop\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<span>\n"+
        "<p>Verificaci&oacute;n de Palabras</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>Escribe los caracteres que veas en la siguiente imagen</p>\n"+
        "</span>\n"+
        "<p><img  src=\""+SWBPlatform.getContextPath()+"/frmprocess/requestCaptcha\" alt=\"captcha\" id=\"captchaimg\" />\n"+
        "<a onclick=\"document.getElementById('captchaimg').src='"+SWBPlatform.getContextPath()+
                        "/frmprocess/requestCaptcha?'+ Math.random(); document.getElementById('captcha').value=''; return false;\">cambiar imagen</a></p>\n"+ //Captcha - width=\"345\" height=\"59\"
        "<p>&nbsp;\n"+
        "  <input type=\"text\" name=\"captcha\" id=\"captcha\" class=\"inputPop\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Nivel de estudios actual</h5>\n"+
        "<div>\n"+
        "  <p>\n"+
        "{$niveles}"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Becas de Inter&eacute;s</h5>\n"+
        "<div>\n"+
        "  <p>\n"+
        "{$instituciones}"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Domicilio donde reside actualmente</h5>\n"+
        "<div id=\"codigopostal\">\n"+
        "  <p>\n"+
        "    <label for=\"codigo\">C&oacute;digo Postal</label>\n"+
        "    <input type=\"text\" name=\"codigo\" id=\"codigo\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"estado\">\n"+
        "  <p>\n"+
        "    <label for=\"estado\">Entidad Federativa</label>\n"+
        "    <input type=\"text\" name=\"estado\" id=\"estado\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"municipioDel\">\n"+
        "  <p>\n"+
        "    <label for=\"municipio\">Municipio o delegaci&oacute;n</label>\n"+
        "  </p>\n"+
        "  <p>&nbsp;</p>\n"+
        "  <p>\n"+
        "    <input type=\"text\" name=\"municipio\" id=\"municipio\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"colonia\">Colonia</label>\n"+
        "  <input type=\"text\" name=\"colonia\" id=\"colonia\" class=\"inputPop\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"direccion\">Calle y N&uacute;mero (Calle, n&uacute;mero externo, n&uacute;mero piso, depto.) </label>\n"+
        "  <input type=\"text\" name=\"direccion\" id=\"direccion\" class=\"inputPop\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Datos para contactarlo</h5>\n"+
        "<div id=\"tipodetelefono\">\n"+
        "  <p class=\"popText\">Tipo de Tel&eacute;fono</p>\n"+
        "  <p>\n"+
        "    <input type=\"radio\" name=\"tipotel\" id=\"tipotel\" value=\"1\" class=\"radioB\" />\n"+
        "    <label for=\"tipotel\">fijo</label>\n"+
        "    <input type=\"radio\" name=\"tipotel\" id=\"tipotel\" value=\"0\" class=\"radioB\" />\n"+
        "    <label for=\"tipotel\">celular</label>\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"lada\">\n"+
        "  <p>\n"+
        "    <label for=\"lada\">Lada</label>\n"+
        "    <input type=\"text\" name=\"lada\" id=\"lada\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"telefono\">\n"+
        "  <p>\n"+
        "    <label for=\"telefono\">Tel&eacute;fono</label>\n"+
        "    <input type=\"text\" name=\"telefono\" id=\"telefono\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"extension\">\n"+
        "  <p>\n"+
        "    <label for=\"extension\">Extensi&oacute;n</label>\n"+
        "    <input type=\"text\" name=\"extension\" id=\"extension\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p><a href=\"javascript:this.submit();\" class=\"cerrarBoton\">Guardar</a></p></form>\n";

    String Seguridad = "";
    static Logger log = SWBUtils.getLogger(UserRegistration.class);
    String Instituciones ="";
    String Niveles ="";

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException
    {
        super.setResourceBase(base);

        String selectValues = SWBContext.getUserRepository(base.getWebSite().getUserRepository().getId()).getUserRepSecurityQuestionList("es");
        if (selectValues==null)
            selectValues = SWBContext.getUserRepository(base.getWebSite().getUserRepository().getId()).getUserRepSecurityQuestionList();
        if ((selectValues != null) && (!"".equals(selectValues.trim()))) {
            StringBuffer ret = new StringBuffer("");
                String[] st = selectValues.split("\\|");
                for(String tok:st) {
                    int    ind = tok.indexOf(':');
                    String id  = tok;
                    String val = tok;

                    if (ind > 0) {
                        id  = tok.substring(0, ind);
                        val = tok.substring(ind + 1);
                    }
                    ret.append("<option value=\"").append(id).append("\" ");
                    ret.append(">").append(val).append("</option>");
                }
                Seguridad = ret.toString();
            }



         Iterator<SemanticObject> iter = Institucion.sclass.listInstances();
         StringBuffer ret = new StringBuffer("");
         while (iter.hasNext()){
             SemanticObject so = iter.next();
             String id = so.getId();
             String title  =so.getProperty(Institucion.swb_title);
             ret.append("<input type=\"checkbox\" name=\"interes\" id=\"interes\" class=\"radioB\" value=\""+id+"\" />\n<label for=\"interes\">"+title+"</label>\n");
         }
         Instituciones = ret.toString();

        System.out.println("***********************************");
        iter = NivelEstudio.sclass.listInstances();
        ret = new StringBuffer("");
         while (iter.hasNext()){
             SemanticObject so = iter.next();
             String id = so.getId();
             String title  =so.getProperty(Institucion.swb_title);
             ret.append("<input type=\"radio\" name=\"nest\" id=\"nest\" class=\"radioB\" value=\""+id+"\" />\n<label for=\"nest\">"+title+"</label>\n");
         }
        Niveles = ret.toString();
        System.out.println("got Niveles:"+Niveles);
    }


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html");
        String tmp = SWBUtils.TEXT.replaceAll(tplt,"{$rutacss}","/work/estilos_lightBox.css");
        tmp = SWBUtils.TEXT.replaceAll(tmp,"{$actionURL}",paramRequest.getActionUrl().toString(true));
        tmp = SWBUtils.TEXT.replaceAll(tmp,"{$preguntas}",Seguridad);
        tmp = SWBUtils.TEXT.replaceAll(tmp,"{$instituciones}",Instituciones);
        tmp = SWBUtils.TEXT.replaceAll(tmp,"{$niveles}",Niveles);
        response.getWriter().println(tmp);
        
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if (null==request.getParameter("captcha") || !((String) request.getSession(true).getAttribute("captchaCad")).equalsIgnoreCase(request.getParameter("captcha")))
        {
            response.setRenderParameter("ERROR", "Fall&oacute; la verificaci&oacute;n de palabra");
        }
        if (null==request.getParameter("clave") || !request.getParameter("clave").equals(request.getParameter("clave2")))
        {
            response.setRenderParameter("ERROR", "Contraseñas no corresponden");
        }
        String usrLogin = request.getParameter("mail");
        User user = response.getUser();
        UserRepository userRep = response.getWebPage().getWebSite().getUserRepository();
        Subject subject = SWBPortal.getUserMgr().getSubject(request, response.getWebPage().getWebSiteId());
        if (null == user.getSemanticObject().getId())
            {
                if (null != userRep.getUserByLogin(usrLogin))
                {
                    //TODO report Error, Loging Already Exists!
                    return;
                }
                User newUser = userRep.createUser();
                newUser.setLogin(usrLogin);
                newUser.setEmail(usrLogin);
                subject.getPrincipals().clear();
                subject.getPrincipals().add(newUser);
                newUser.setLanguage(user.getLanguage());
                newUser.setIp(user.getIp());
                newUser.setActive(true);
                newUser.setDevice(user.getDevice());
                try {
                    if (null!=request.getParameter("clave") && !"".equals(request.getParameter("clave").trim())){
                        newUser.setPassword(request.getParameter("clave").trim());
                    }
                    if (null!=request.getParameter("preguntaSecreta") && !"".equals(request.getParameter("preguntaSecreta").trim())){
                        newUser.setSecurityQuestion(Integer.valueOf(request.getParameter("preguntaSecreta").trim()));
                    }
                    if (null!=request.getParameter("respuestaSecreta") && !"".equals(request.getParameter("respuestaSecreta").trim())){
                        newUser.setPassword(request.getParameter("respuestaSecreta").trim());
                    }
                    if (null!=request.getParameter("nest") && !"".equals(request.getParameter("nest").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrNivelEstudios, request.getParameter("nest").trim());
                    }
                    if (null!=request.getParameter("codigo") && !"".equals(request.getParameter("codigo").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrCP ,request.getParameter("codigo").trim());
                    }
                    if (null!=request.getParameter("estado") && !"".equals(request.getParameter("estado").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrEntidadFederativa , request.getParameter("estado").trim());
                    }
                    if (null!=request.getParameter("municipio") && !"".equals(request.getParameter("municipio").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrMunicipio , request.getParameter("municipio").trim());
                    }
                    if (null!=request.getParameter("colonia") && !"".equals(request.getParameter("colonia").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrColonia , request.getParameter("colonia").trim());
                    }
                    if (null!=request.getParameter("direccion") && !"".equals(request.getParameter("direccion").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrDireccion , request.getParameter("direccion").trim());
                    }
                    if (null!=request.getParameter("tipotel") && !"".equals(request.getParameter("tipotel").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrTipoTel , request.getParameter("tipotel").trim());
                    }
                    if (null!=request.getParameter("lada") && !"".equals(request.getParameter("lada").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrClaveTel , request.getParameter("lada").trim());
                    }
                    if (null!=request.getParameter("telefono") && !"".equals(request.getParameter("telefono").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrTelefono , request.getParameter("telefono").trim());
                    }
                    if (null!=request.getParameter("extension") && !"".equals(request.getParameter("extension").trim())){
                        newUser.setExtendedAttribute(Becarios.becas_usrExtTel , request.getParameter("extension").trim());
                    }
                    String [] intereses = request.getParameterValues("interes");
                    for (String interes: intereses){

                        newUser.getSemanticObject().addLiteralProperty(Becarios.becas_hasInterestIn, new SemanticLiteral(interes));
                    }

                } catch (SWBException swbe) {
                    log.error("registrando usuario", swbe);
                }
//                System.out.println("*************** "+newUser.isActive());
                user = newUser;
//                System.out.println("*************** "+user.isActive());
            }
    }

    

    

}
