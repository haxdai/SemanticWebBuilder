/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.sep.becas;

import gob.sep.becas.ws.ValidaCURPSEP;
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
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author serch
 */
public class UserRegistration extends GenericResource {
    ///work/models/Beca_SEP/CSS/estilos_lightBox.css
    String tplCURP = "<input type=\"hidden\" name=\"curpchkd\" id=\"curpchkd\" value=\"no\" />\n"+
        "<input type=\"hidden\" name=\"cveEntNac\" id=\"cveEntNac\" value=\"\" />\n"+
        "<input type=\"hidden\" name=\"fechaNac\" id=\"fechaNac\" value=\"\" />\n"+
        "<input type=\"hidden\" name=\"sexo\" id=\"sexo\" value=\"\" />\n"+
         "<p class=\"curpf\">\n"+
        "  <label for=\"CURP\">CURP*</label>\n"+
        "  <input type=\"text\" name=\"CURP\" id=\"CURP\" class=\"inputPop\" /><div id=\"valCURPS\">&nbsp;</div>\n"+
        "<a href=\"javascript:validaCURP()\" class=\"cerrarBoton\">Valida CURP</a></p>"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<script  type=\"text/javascript\">"+
        "function validaCURP(){"+
            "var vCURP=document.getElementById('CURP');"+
            "var curpSpace=document.getElementById('valCURPS');"+
            "curpSpace.innerHTML=\"Validando...\";"+
            "dojo.xhrGet({ url: '{$urlCURP}'+vCURP.value, load: function(response, ioArgs) "+
            "{eval(response);}, "+
            "error: function(response, ioArgs) {alert('Server error: '+response)}});;"+
            "}"+
            "</script>";

    String tplt = "<script  type=\"text/javascript\"> function validatePassowrd(clave) {"+
            "var estado = document.getElementById(\"passwordstatus\");"+
            "if (clave.length<6) { "+
            "estado.innerHTML=\"La contraseña debe tener al menos 6 caracteres\";  "+
            "estado.style.color=\"red\";"+
            "return true; }"+
            "var pRegEx=/^[ A-Za-z0-9\\!\\@\\_\\-\\.]*?([A-Za-z][ A-Za-z0-9\\!\\@\\_\\-\\.]*?[0-9]|[0-9][ A-Za-z0-9\\!\\@\\_\\-\\.]*?[A-Za-z])[ A-Za-z0-9\\!\\@\\_\\-\\.]*$/;"+
            "if (!pRegEx.test(clave)) {"+
            "estado.innerHTML=\"La contraseña puede contener letras, números y los símbolos &quot;!&quot;, &quot;@&quot;, &quot;_&quot;, &quot;-&quot; y &quot;.&quot;.\";  "+
            "estado.style.color=\"red\";"+
            "return true; }"+
           "estado.innerHTML=\"Contraseña aceptable\";  "+
            "estado.style.color=\"green\";"+
            "}\n"+
            "function submitfrm() { "+
            "var forma = document.getElementById(\"formaRegistro\"); "+
            "if (forma.usrName.value.length==0 || forma.usrPrimA.value.length==0 || "+
            "forma.mail.value.length==0 || forma.clave.value.length==0 || "+
            "forma.preguntaSecreta.selectedIndex<1 || !forma.polpriv.checked || (forma.CURP.length>0 && forma.curpchkd.value=='no') || "+
            "forma.respuestaSecreta.value.length==0 || !validateElement('frmCaptchaValue','/frmprocess/validCaptcha?none=1',forma.frmCaptchaValue.value) "+
            ") {alert ('Tus datos se encuentran incompletos. Es necesario que llenes todos los campos obligatorios marcados con \"*\".'); } else { "+
            "forma.submit(); }"+
            "}\n"+
            "function actualizaComboMun(valor) {\n"+
           // "alert('valor:'+valor);\n" +
            "var munele=document.getElementById('MunChg');\n"+
            "dojo.xhrGet({ url: '{$urlMun}'+valor, load: function(response, ioArgs)  "+
            " {munele.innerHTML=response;}, error: function(response, ioArgs) {alert('Server error: '+response)}});"+
//            "var tmp = getHtmlByTag('{$urlMun}'+valor, munele, false, true);" +
//            "alert(tmp);"+
            "}\n"+
            "function validaCURP(){"+
            "var vCURP=document.getElementById('CURP');"+
            "var curpSpace=document.getElementById('valCURPS');"+
            "curpSpace.innerHTML=\"Validando...\";"+
            "dojo.xhrGet({ url: '{$urlCURP}'+vCURP.value, load: function(response, ioArgs) "+
            "{eval(response);}, "+
            "error: function(response, ioArgs) {alert('Server error: '+response)}});;"+
            "}"+
            "</script>"+
        "<script type=\"text/javascript\" src=\""+SWBPortal.getContextPath()+"/swbadmin/js/swb.js\" ></script><form id=\"formaRegistro\" name=\"formaRegistro\" method=\"post\" action=\"{$actionURL}\">"
        + "<link type=\"text/css\" rel=\"stylesheet\" href=\""+SWBPortal.getContextPath()+"/work/models/Beca_SEP/CSS/estilos_lightBox.css\" />\n"+ // /work/estilos_lightBox.css
        "<h2>Crear Cuenta</h2>\n"+
        "<input type=\"hidden\" name=\"curpchkd\" id=\"curpchkd\" value=\"no\" />\n"+ 
        "<input type=\"hidden\" name=\"cveEntNac\" id=\"cveEntNac\" value=\"\" />\n"+
        "<input type=\"hidden\" name=\"fechaNac\" id=\"fechaNac\" value=\"\" />\n"+
        "<input type=\"hidden\" name=\"sexo\" id=\"sexo\" value=\"\" />\n"+
        "<p class=\"introPop\">Bienvenido, para enviarte la informaci&oacute;n actualizada sobre las fechas ofrecidas por el Gobierno Federal, llena los siguientes datos:</p>\n"+
        "<p class=\"introPop\">La cuenta del portal de becas le permite acceder a la informaci&oacute;n y otros servicios. Si ya te registraste en el</p>\n"+
        "<p class=\"introPop\">portal, <a href=\"#\">entra a tu cuenta  aqu&iacute;</a></p>\n"+
        "<h5>Informaci&oacute;n del Usuario</h5>\n"+
        "<p class=\"obligatorio\">*Datos Obligatorios, favor de proporcionarlos</p>\n"+
        "<p class=\"curpf\">\n"+
        "  <label for=\"CURP\">CURP*</label>\n"+
        "  <input type=\"text\" name=\"CURP\" id=\"CURP\" class=\"inputPop\" /><div id=\"valCURPS\">&nbsp;</div>\n"+
        "<a href=\"javascript:validaCURP()\" class=\"cerrarBoton\">Valida CURP</a></p>"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p class=\"csNombre\"><label for=\"usrName\">Nombre(s)*</label>\n"+
        "<input type=\"text\" name=\"usrName\" id=\"usrName\" class=\"inputPop\" /></p>\n"+
//        "<p>&nbsp;</p>\n"+
//        "<p>&nbsp;</p>\n"+
        "<p class=\"csPApe\"><label for=\"usrPrimA\">Primer Apellído*</label>\n"+
        "<input type=\"text\" name=\"usrPrimA\" id=\"usrPrimA\" class=\"inputPop\" /></p>\n"+
//        "<p>&nbsp;</p>\n"+
//        "<p>&nbsp;</p>\n"+
        "<p class=\"csSApe\"><label for=\"usrSegA\">Segundo Apellído</label>\n"+
        "<input type=\"text\" name=\"usrSegA\" id=\"usrSegA\" class=\"inputPop\" /></p>\n"+
//        "<p>&nbsp;</p>\n"+
//        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"mail\">Correo Electr&oacute;nico*</label>\n"+
        "  <input type=\"text\" name=\"mail\" id=\"mail\" class=\"inputPop\" onchange=\" if (!isValidEmail(this.value) || !canAddEmail('{$model}', this.value))"+
        " alert ('El correo electrónico no es válido o ya fue registrado por otro usuario. Verifica que contenga \"@\" o ingresa una nueva dirección de correo electrónico.');\"/>\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"clave\">Contrase&ntilde;a*</label>\n"+
        "  <input type=\"password\" name=\"clave\" id=\"clave\" class=\"inputPop\" onkeyup=\"validatePassowrd(this.value);\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p class=\"popText\">Nivel de Seguridad: <div id=\"passwordstatus\" style=\"color:red\">Proporcione una contraseña</div></p>\n"+
        "<p>\n"+
        "  <label for=\"clave2\">Confirmar contrase&ntilde;a*</label>\n"+
        "  <input type=\"password\" name=\"clave2\" id=\"clave2\" class=\"inputPop\" onchange=\"if (this.value!=clave.value) alert ('La confirmación de tu contraseña es incorrecta. Las contraseñas deben ser iguales.');\" />\n"+
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
        "  <label for=\"respuestaSecreta\">Respuesta*</label>\n"+
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
        "  <input type=\"text\" name=\"frmCaptchaValue\" id=\"frmCaptchaValue\" class=\"inputPop\" onchange=\"if (!validateElement('frmCaptchaValue','/frmprocess/validCaptcha?none=1',this.value)) "+
        "alert('Los caracteres son incorrectos. Asegúrate de escribir el texto tal como se muestra en la imagen.');\"/>\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Nivel de Estudios de tú interés</h5>\n"+
        "<div>\n"+
        "  <p class=\"nivel\">\n"+
        "{$niveles}"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Becas de Inter&eacute;s</h5>\n"+
        "<div>\n"+
        "  <p class=\"instituciones\">\n"+
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
      //  "    <input type=\"text\" name=\"estado\" id=\"estado\" />\n"+
        "{$estado}"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"municipioDel\">\n"+
        "  <p>\n"+
        "    <label for=\"municipio\">Municipio o delegaci&oacute;n</label>\n"+
        //"  </p>\n"+
        //"  <p>&nbsp;</p>\n"+
        //"  <p>\n"+
       // "    <input type=\"text\" name=\"municipio\" id=\"municipio\" />\n"+
        "<div id=\"MunChg\"><select name=\"municipio\" size=\"1\" class=\"inputPop\" id=\"municipio\" >{$currMun}</select></div>\n"+
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
        "<p><input type=\"checkbox\" id=\"polpriv\" name=\"polpriv\" value=\"OK\">He leído y acepto los términos de uso y las políticas de "
        + "<a href=\"/es/Beca_SEP/Politicas_Privacidad\" target=\"_blank\">privacidad del sitio</a>.</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p><a href=\"javascript:submitfrm()\" class=\"cerrarBoton\">Guardar</a></p></form>\n";

    String tpltEd = "<script  type=\"text/javascript\"> \n"+
            "function submitfrm() { "+
            "var forma = document.getElementById(\"formaRegistro\"); "+
            "if (forma.usrName.value.length==0 || forma.usrPrimA.value.length==0 || "+
            "forma.preguntaSecreta.selectedIndex<1 || "+
            "forma.respuestaSecreta.value.length==0 || !validateElement('frmCaptchaValue','/frmprocess/validCaptcha?none=1',forma.frmCaptchaValue.value)"+
            ") {alert ('Tus datos se encuentran incompletos. Es necesario que llenes todos los campos obligatorios marcados con \"*\".'); } else { "+
            "forma.submit(); }"+
            "}"+
            "function actualizaComboMun(valor) {\n"+
           // "alert('valor:'+valor);\n" +
            "var munele=document.getElementById('MunChg');\n"+
            "dojo.xhrGet({ url: '{$urlMun}'+valor, load: function(response, ioArgs)  "+
            " {munele.innerHTML=response;}, error: function(response, ioArgs) {alert('Server error: '+response)}});"+
//            "var tmp = getHtmlByTag('{$urlMun}'+valor, munele, false, true);" +
//            "alert(tmp);"+
            "}"+
            "</script>"+
        "<script type=\"text/javascript\" src=\""+SWBPortal.getContextPath()+"/swbadmin/js/swb.js\" ></script><form id=\"formaRegistro\" name=\"formaRegistro\" method=\"post\" action=\"{$actionURL}\">"
        + "<link type=\"text/css\" rel=\"stylesheet\" href=\""+SWBPortal.getContextPath()+"/work/models/Beca_SEP/CSS/estilos_lightBox.css\" />\n"+ // /work/estilos_lightBox.css
        "<h2>Crear Cuenta</h2>\n"+
//        "<p>&nbsp;</p>\n"+
        "<p class=\"introPop\">Bienvenido, para enviarte la informaci&oacute;n actualizada sobre las fechas ofrecidas por el Gobierno Federal, llena los siguientes datos:</p>\n"+
        "<p class=\"introPop\">La cuenta del portal de becas le permite acceder a la informaci&oacute;n y otros servicios. Si ya te registraste en el</p>\n"+
        "<p class=\"introPop\">portal, <a href=\"#\">entra a tu cuenta  aqu&iacute;</a></p>\n"+
        "<h5>Informaci&oacute;n del Usuario</h5>\n"+
        "<p class=\"obligatorio\">*Datos Obligatorios, favor de proporcionarlos</p>\n"+
        "{$curpdata}\n"+
        "<p class=\"csNombre\"><label for=\"usrName\">Nombre(s)*</label>\n"+
        "<input type=\"text\" name=\"usrName\" id=\"usrName\" class=\"inputPop\" value=\"{$usrName}\"/></p>\n"+
//        "<p>&nbsp;</p>\n"+
//        "<p>&nbsp;</p>\n"+
        "<p class=\"csPApe\"><label for=\"usrPrimA\">Primer Apellído*</label>\n"+
        "<input type=\"text\" name=\"usrPrimA\" id=\"usrPrimA\" class=\"inputPop\" value=\"{$usrPrimA}\" /></p>\n"+
//        "<p>&nbsp;</p>\n"+
//        "<p>&nbsp;</p>\n"+
        "<p class=\"csSApe\"><label for=\"usrSegA\">Segundo Apellído</label>\n"+
        "<input type=\"text\" name=\"usrSegA\" id=\"usrSegA\" class=\"inputPop\"  value=\"{$usrSegA}\"/></p>\n"+
//        "<p>&nbsp;</p>\n"+
//        "<p>&nbsp;</p>\n"+
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
        "  <label for=\"respuestaSecreta\">Respuesta*</label>\n"+
        "  <input type=\"text\" name=\"respuestaSecreta\" id=\"respuestaSecreta\" class=\"inputPop\" value=\"{$respuestaSecreta}\" />\n"+
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
        "  <input type=\"text\" name=\"frmCaptchaValue\" id=\"frmCaptchaValue\" class=\"inputPop\" onchange=\"if (!validateElement('frmCaptchaValue','/frmprocess/validCaptcha?none=1',this.value)) "+
        "alert('Los caracteres son incorrectos. Asegúrate de escribir el texto tal como se muestra en la imagen.');\"/>\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Nivel de Estudios de tú interés</h5>\n"+
        "<div>\n"+
        "  <p class=\"nivel\">\n"+
        "{$niveles}"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Becas de Inter&eacute;s</h5>\n"+
        "<div>\n"+
        "  <p class=\"instituciones\">\n"+
        "{$instituciones}"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Domicilio donde reside actualmente</h5>\n"+
        "<div id=\"codigopostal\">\n"+
        "  <p>\n"+
        "    <label for=\"codigo\">C&oacute;digo Postal</label>\n"+
        "    <input type=\"text\" name=\"codigo\" id=\"codigo\" value=\"{$codigo}\"/>\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"estado\">\n"+
        "  <p>\n"+
        "    <label for=\"estado\">Entidad Federativa</label>\n"+
     //   "    <input type=\"text\" name=\"estado\" id=\"estado\" value=\"{$estado}\"/>\n"+
        "{$estado}"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"municipioDel\">\n"+
        "  <p>\n"+
        "    <label for=\"municipio\">Municipio o delegaci&oacute;n</label>\n"+
        //"  </p>\n"+
        //"  <p>&nbsp;</p>\n"+
        //"  <p>\n"+
         "<div id=\"MunChg\"><select name=\"municipio\" size=\"1\" class=\"inputPop\" id=\"municipio\" >{$currMun}</select></div>\n"+
     //   "    <input type=\"text\" name=\"municipio\" id=\"municipio\" value=\"{$municipio}\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"colonia\">Colonia</label>\n"+
        "  <input type=\"text\" name=\"colonia\" id=\"colonia\" class=\"inputPop\" value=\"{$colonia}\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>\n"+
        "  <label for=\"direccion\">Calle y N&uacute;mero (Calle, n&uacute;mero externo, n&uacute;mero piso, depto.) </label>\n"+
        "  <input type=\"text\" name=\"direccion\" id=\"direccion\" class=\"inputPop\" value=\"{$direccion}\" />\n"+
        "</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<h5>Datos para contactarlo</h5>\n"+
        "<div id=\"tipodetelefono\">\n"+
        "  <p class=\"popText\">Tipo de Tel&eacute;fono</p>\n"+
        "  <p>\n"+
        "    <input type=\"radio\" name=\"tipotel\" id=\"tipotel\" value=\"1\" class=\"radioB\" {$tipotel_1}/>\n"+
        "    <label for=\"tipotel\">fijo</label>\n"+
        "    <input type=\"radio\" name=\"tipotel\" id=\"tipotel\" value=\"0\" class=\"radioB\" {$tipotel_0}/>\n"+
        "    <label for=\"tipotel\">celular</label>\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"lada\">\n"+
        "  <p>\n"+
        "    <label for=\"lada\">Lada</label>\n"+
        "    <input type=\"text\" name=\"lada\" id=\"lada\" value=\"{$lada}\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"telefono\">\n"+
        "  <p>\n"+
        "    <label for=\"telefono\">Tel&eacute;fono</label>\n"+
        "    <input type=\"text\" name=\"telefono\" id=\"telefono\" value=\"{$telefono}\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<div id=\"extension\">\n"+
        "  <p>\n"+
        "    <label for=\"extension\">Extensi&oacute;n</label>\n"+
        "    <input type=\"text\" name=\"extension\" id=\"extension\" value=\"{$extension}\" />\n"+
        "  </p>\n"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p><a href=\"javascript:submitfrm()\" class=\"cerrarBoton\">Guardar</a></p></form>\n";

    String Message="<html><body><p font=\"arial\" size=\"3\"><em>Bienvenido al Portal Becas,  "
            + "donde podrás consultar información acerca de los apoyos disponibles para continuar "
            + "tus estudios, además de las convocatorias impulsadas por las instituciones participantes en el programa.<br><br>"+
            "Agradecemos tu interés por crear una cuenta en el Portal Becas y te invitamos a realizar la "
            + "activación de la cuenta para que puedas disfrutar de los beneficios que el portal te ofrece. </em><br><br>"
            + "Para activar tu cuenta <a href=\"{$link}\">Haz clic aquí</a><br><br>¡No dejes pasar más tiempo, busca tu "
            + "beca y aprovecha todos los beneficios que te ofrece el portal para continuar tus estudios!</p></body></html>";

    String Activacion="<p><img src=\""+SWBPlatform.getContextPath()+"/work/models/Beca_SEP/images/unpaso.png\" alt=\"\" /></p>\n"+
        "<h3>Hola <b>{$nombre}</b>, has creado tu cuenta en el Portal <em>Becas</em>, ahora debes activarla.</h3>\n"+
        "<p>Hemos enviado un mensaje a la cuenta de correo electrónico que nos proporcionaste:</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p style=\"text-align:center;\"><b>{$correo}</b></p>\n"+
        "<p>&nbsp;</p>\n"+
        "<p>Para activar tu cuenta debes consultar el mensaje que te fue enviado y dar clic en el vínculo de activación. "+
        "Si no recibes nuestro mensaje de correo electrónico con el vínculo de activación en 24 horas, por favor contáctanos en "
        + "<a href=\"mailto:ayuda@becas.com\">ayuda@becas.com</a></p>\n";

    String editado="<img src=\""+SWBPortal.getContextPath()+"/work/models/Beca_SEP/images/bienvenido.png\" />\n"+
        "<h3>{$nombre}, tu cuenta ha sido modificada</h3>\n"+
        "<p>Al registrarte con este correo y contrase&ntilde;a podr&aacute;s iniciar sesi&oacute;n en el sitio y "
        + "acceder a los servicios que el portal de Becas tiene para ti. Ingresa peri&oacute;dicamente para que "
        + "est&eacute;s al tanto de las opciones  educativas que te permitir&aacute;n mejorar tu nivel acad&eacute;mico.</p>\n"+
        "<p><b>Como usuario de este sitio, t&uacute; podr&aacute;s:</b></p>\n"+
        "<ul>\n"+
        "    <li>Conocer la oferta de becas que ofrece el Gobierno Federal a trav&eacute;s de diversas instituciones educativas.</li>\n"+
        "    <li>Enterarte de c&oacute;mo puedes continuar tus estudios aprovechando los diversos recursos monetarios que se te brindan.</li>\n"+
        "    <li>Encontrar la beca ideal que se adec&uacute;e a tu perfil profesional, gustos y necesidades.</li>\n"+
        "    <li>Tener a tu disposici&oacute;n el calendario de convocatorias de becas.</li>\n"+
        "    <li>Recibir noticias, actualizaciones y novedades en tu correo electr&oacute;nico.</li>\n"+
        "</ul>\n"+
        "<p><b>Aprovecha los beneficios que te ofrece el portal de Becas para continuar con tu preparaci&oacute;n "
        + "acad&eacute;mica y convi&eacute;rtete en un joven de &eacute;xito.</b></p>\n";

    String Seguridad = "";
    static Logger log = SWBUtils.getLogger(UserRegistration.class);
    String Instituciones ="";
    String Niveles ="";
    String EdosBase = "";
    String MunBase = "";

    HashMap<String, String> pseg;
    HashMap<String, String> inst;
    HashMap<String, String> nive;
    HashMap<String, String> edos;
    HashMap<String, HashMap<String, String>> muni;



    @Override
    public void setResourceBase(Resource base) throws SWBResourceException
    {
        super.setResourceBase(base);
//        System.out.println("In Resource Base!!!!!! ");
//        new Exception().printStackTrace();
        pseg = new HashMap<String, String>();
        inst = new HashMap<String, String>();
        nive = new HashMap<String, String>();
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
                    pseg.put(id, val);
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
             inst.put(id, title);
             ret.append("<input type=\"checkbox\" name=\"interes\" id=\"interes\" class=\"radioB\" value=\""+id+"\" />\n<label for=\"interes\">"+title+"</label>\n");

         }
         Instituciones = ret.toString();

        iter = NivelEstudio.sclass.listInstances();
        ret = new StringBuffer("");
         while (iter.hasNext()){
             SemanticObject so = iter.next();
             String id = so.getId();
             String title  =so.getProperty(Institucion.swb_title);
             nive.put(id, title);
             ret.append("<input type=\"radio\" name=\"nest\" id=\"nest\" class=\"radioB\" value=\""+id+"\" />\n<label for=\"nest\">"+title+"</label>\n");
         }
        Niveles = ret.toString();
        edos = new HashMap<String, String>();
        muni = new HashMap<String, HashMap<String, String>>();
        MunBase = "";
        Iterator<Estado> ieds =Estado.ClassMgr.listEstados();
        String ed1 = null;
        StringBuilder sb= new StringBuilder( "<select name=\"estado\" size=\"1\" class=\"inputPop\" id=\"estado\" onchange=\"actualizaComboMun(this.value)\">");
        while (ieds.hasNext()){
            Estado edo = ieds.next();
            if (null==ed1) {
                ed1="";
                Iterator<Municipio>imun= edo.listMunicipioInvs();
                while (imun.hasNext()){
                    Municipio mun = imun.next();
                    MunBase += "<option value=\""+mun.getId()+"\" >"+mun.getTitle()+"</option>";
                }
            }
            edos.put(edo.getId(), edo.getTitle());
            sb.append("<option value=\"").append(edo.getId()).append("\" >").append(edo.getTitle()).append("</option>");
            //System.out.println("Edo:"+edo.getId()+"-"+edo.getTitle());
            Iterator<Municipio>imun= edo.listMunicipioInvs();
            HashMap<String, String> muniEd = new HashMap<String, String>();
            while (imun.hasNext()){
                Municipio mun = imun.next();
                muniEd.put(mun.getId(), mun.getTitle());
                //System.out.println("Muni:"+mun.getId()+"-"+mun.getTitle());
            }
            muni.put(edo.getId(), muniEd);
            
        }
        sb.append("</select>\n");
        EdosBase = sb.toString();
    }


    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html");
        if (!paramRequest.getUser().isSigned())
        {
            //String tmp = SWBUtils.TEXT.replaceAll(tplt,"{$rutacss}","/work/estilos_lightBox.css");
            String tmp = SWBUtils.TEXT.replaceAll(tplt,"{$actionURL}",paramRequest.getActionUrl().toString(true));
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$preguntas}",Seguridad);
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$instituciones}",Instituciones);
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$niveles}",Niveles);
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$model}",paramRequest.getUser().getUserRepository().getId());
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$estado}",EdosBase);
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$currMun}",MunBase); 
            String urlmun = paramRequest.getRenderUrl().setMode("Municipio").setCallMethod(SWBResourceURL.Call_DIRECT).toString();
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$urlMun}",urlmun+"/");
            String urlCurp = paramRequest.getRenderUrl().setMode("curp").setCallMethod(SWBResourceURL.Call_DIRECT).toString();
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$urlCURP}",urlCurp+"/");

            if (null!=request.getParameter("ERROR")){
                tmp = tmp + "<script>alert('ERROR: "+request.getParameter("ERROR").replace('\'','`')+"');</script>";
            }
            response.getWriter().println(tmp);
        } else {
            //String tmp = SWBUtils.TEXT.replaceAll(tplt,"{$rutacss}","/work/estilos_lightBox.css");
            User user = paramRequest.getUser();
            String tmp = SWBUtils.TEXT.replaceAll(tpltEd,"{$actionURL}",paramRequest.getActionUrl().toString(true));


            StringBuilder prseg = new StringBuilder();
            for (String id:pseg.keySet()){
                String val=pseg.get(id);
                prseg.append("<option value=\"").append(id).append("\" ");
                if (id.equals(""+user.getSecurityQuestion())) prseg.append(" selected ");
                prseg.append(">").append(val).append("</option>");
            }


            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$preguntas}",prseg.toString());
            Iterator<SemanticObject>iter = user.getSemanticObject().listObjectProperties(Becarios.becas_hasInterestIn);
            String checkedalvs = "-";
            while (iter.hasNext()){
                SemanticObject so = iter.next();
                checkedalvs = checkedalvs+"|"+so.getId()+"|";
            }
            prseg = new StringBuilder();
            for (String id:inst.keySet()){
                String val=inst.get(id);
                String ch="";
                if (checkedalvs.indexOf("|"+id+"|")>0) ch=" checked ";
                prseg.append("<input type=\"checkbox\" name=\"interes\" id=\"interes\" class=\"radioB\" value=\""+id+
                        "\" " +ch+ "/>\n<label for=\"interes\">"+val+"</label>\n");
            }


            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$instituciones}",prseg.toString());
            iter = user.getSemanticObject().listObjectProperties(Becarios.becas_usrNivelEstudios);
            SemanticObject ne=null;
            while (iter.hasNext()){
                ne=iter.next();
            }
            prseg = new StringBuilder();
            for (String id:nive.keySet()){
                String val=nive.get(id);
                String ch="";
                if (ne.getId().equals(id)) ch=" checked ";
                prseg.append("<input type=\"radio\" name=\"nest\" id=\"nest\" class=\"radioB\" value=\""+id+
                        "\" "+ch+" />\n<label for=\"nest\">"+val+"</label>\n");
            }


            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$niveles}",prseg.toString());
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$model}",paramRequest.getUser().getUserRepository().getId());

            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$usrName}",user.getFirstName()==null?"":user.getFirstName());
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$usrPrimA}",user.getLastName()==null?"":user.getLastName());
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$usrSegA}",user.getSecondLastName()==null?"":user.getSecondLastName());

            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$respuestaSecreta}",user.getSecurityAnswer()==null?"":user.getSecurityAnswer());

            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$codigo}",user.getExtendedAttribute(Becarios.becas_usrCP)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrCP));
            String selectedEdo = (String)user.getExtendedAttribute(Becarios.becas_usrEntidadFederativa);
            StringBuilder sb= new StringBuilder( "<select name=\"estado\" size=\"1\" class=\"inputPop\" id=\"estado\" onchange=\"actualizaComboMun(this.value)\">");
            Iterator<String> iedo = edos.keySet().iterator();
            while(iedo.hasNext()){
                String edo=iedo.next();
                sb.append("<option value=\"").append(edo).append("\"");
                if (edo.equalsIgnoreCase(selectedEdo)) sb.append(" selected ");
                sb.append("\" >").append(edos.get(edo)).append("</option>");
            }
            sb.append("</select>");
            String edoTmp = sb.toString();
            
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$estado}",edoTmp);
            String urlmun = paramRequest.getRenderUrl().setMode("Municipio").setCallMethod(SWBResourceURL.Call_DIRECT).toString();
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$urlMun}",urlmun+"/");

            String urlCurp = paramRequest.getRenderUrl().setMode("curpEd").setCallMethod(SWBResourceURL.Call_DIRECT).toString();
            String tmpCurp = "";

            if (null==user.getExtendedAttribute(Becarios.becas_usrCURP))
            {
                tmpCurp = SWBUtils.TEXT.replaceAll(tplCURP,"{$urlCURP}",urlCurp+"/");
            }
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$curpdata}",tmpCurp);

            //user.getExtendedAttribute(Becarios.becas_usrEntidadFederativa)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrEntidadFederativa));
            HashMap<String, String> tmpmun=null;
            if (muni.containsKey(selectedEdo)){
                tmpmun = muni.get(selectedEdo);
            }else {
                tmpmun = muni.get(muni.keySet().iterator().next());
            }
            iedo = tmpmun.keySet().iterator();
            String selectedMun = (String)user.getExtendedAttribute(Becarios.becas_usrMunicipio);
            sb= new StringBuilder();
            while(iedo.hasNext()){
                String edo=iedo.next();
                sb.append("<option value=\"").append(edo).append("\"");
                if (edo.equalsIgnoreCase(selectedMun)) sb.append(" selected ");
                sb.append(" >").append(tmpmun.get(edo)).append("</option>");
            }
            String munTmp=sb.toString();
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$currMun}",munTmp);
                    //user.getExtendedAttribute(Becarios.becas_usrMunicipio)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrMunicipio));
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$colonia}",user.getExtendedAttribute(Becarios.becas_usrColonia)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrColonia));
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$direccion}",user.getExtendedAttribute(Becarios.becas_usrDireccion)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrDireccion));
            
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$lada}",user.getExtendedAttribute(Becarios.becas_usrClaveTel)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrClaveTel));
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$telefono}",user.getExtendedAttribute(Becarios.becas_usrTelefono)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrTelefono));
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$extension}",user.getExtendedAttribute(Becarios.becas_usrExtTel)==null?"":(String)user.getExtendedAttribute(Becarios.becas_usrExtTel));

            int tipotel = -1;
            try { tipotel = Integer.parseInt((String)user.getExtendedAttribute(Becarios.becas_usrTipoTel)); } catch (NumberFormatException NoE) {}

            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$tipotel_1}",tipotel==1?"checked":"");
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$tipotel_0}",tipotel==0?"checked":"");

//            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$usrName}",user.getFirstName()==null?"":user.getFirstName());
//            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$usrName}",user.getFirstName()==null?"":user.getFirstName());
//            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$usrName}",user.getFirstName()==null?"":user.getFirstName());

            if (null!=request.getParameter("ERROR")){
                tmp = tmp + "<script>alert('ERROR: "+request.getParameter("ERROR").replace('\'','`')+"');</script>";
            }
            response.getWriter().println(tmp);
        }
        
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if (null==request.getParameter("frmCaptchaValue") || null==request.getSession(true).getAttribute("captchaCad") ||!((String) request.getSession(true).getAttribute("captchaCad")).equalsIgnoreCase(request.getParameter("frmCaptchaValue")))
        {
            response.setRenderParameter("ERROR", "Falló la verificación de palabra");
            return;
        }
        if (response.getUser().isSigned()){
            try {
                    User newUser = response.getUser();
                    if (null!=request.getParameter("usrName") && !"".equals(request.getParameter("usrName").trim())){
                        newUser.setFirstName(request.getParameter("usrName").trim());
                    }
                    if (null!=request.getParameter("usrPrimA") && !"".equals(request.getParameter("usrPrimA").trim())){
                        newUser.setLastName(request.getParameter("usrPrimA").trim());
                    }
                    if (null!=request.getParameter("usrSegA") && !"".equals(request.getParameter("usrSegA").trim())){
                        newUser.setSecondLastName(request.getParameter("usrSegA").trim());
                    }
                    if (null!=request.getParameter("preguntaSecreta") && !"".equals(request.getParameter("preguntaSecreta").trim())){
                        newUser.setSecurityQuestion(Integer.valueOf(request.getParameter("preguntaSecreta").trim()));
                    }
                    if (null!=request.getParameter("respuestaSecreta") && !"".equals(request.getParameter("respuestaSecreta").trim())){
                        newUser.setSecurityAnswer(request.getParameter("respuestaSecreta").trim());
                    }
                    if (null!=request.getParameter("nest") && !"".equals(request.getParameter("nest").trim())){
                        Iterator<SemanticObject>iterso = newUser.getSemanticObject().listObjectProperties(Becarios.becas_usrNivelEstudios);
                        while (iterso.hasNext()){
                            SemanticObject so = iterso.next();
                            newUser.getSemanticObject().removeObjectProperty(Becarios.becas_usrNivelEstudios, so);
                        }
                        NivelEstudio ne = NivelEstudio.ClassMgr.getNivelEstudio(request.getParameter("nest").trim(), response.getWebPage().getWebSite());
                        if (null!= ne)
                            newUser.getSemanticObject().addObjectProperty(Becarios.becas_usrNivelEstudios, ne.getSemanticObject());
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

                    String err = updateCurp(request, response.getWebPage(), newUser);
                    if (null!=err) response.setRenderParameter("ERROR", err);


                    Iterator<SemanticObject>iterso = newUser.getSemanticObject().listObjectProperties(Becarios.becas_hasInterestIn);
                    while (iterso.hasNext()){
                        SemanticObject so = iterso.next();
                        newUser.getSemanticObject().removeObjectProperty(Becarios.becas_hasInterestIn, so);
                    }
                    String [] intereses = request.getParameterValues("interes");
                    if (null != intereses)
                    {
                        for (String interes: intereses){
                            Institucion instit=Institucion.ClassMgr.getInstitucion(interes, response.getWebPage().getWebSite());
                            if (null!= instit)
                                newUser.getSemanticObject().addObjectProperty(Becarios.becas_hasInterestIn, instit.getSemanticObject());
                        }
                    }
                    response.setMode(response.Mode_EDIT);
                } catch (SWBException swbe) {
                    log.error("registrando usuario", swbe);
                }
            return;
        }
        if (null==request.getParameter("clave") || !request.getParameter("clave").equals(request.getParameter("clave2")))
        {
            response.setRenderParameter("ERROR", "Contraseñas no corresponden");
            return;
        }
        if (null==request.getParameter("polpriv"))
        {
            response.setRenderParameter("ERROR", "No aceptó nuestra política de privacidad");
            return;
        }
        String usrLogin = request.getParameter("mail");
        User user = response.getUser();
        UserRepository userRep = response.getWebPage().getWebSite().getUserRepository();
        Subject subject = SWBPortal.getUserMgr().getSubject(request, response.getWebPage().getWebSiteId());
        if (null == user.getSemanticObject().getId())
            {
                if (null != userRep.getUserByLogin(usrLogin))
                {
                    response.setRenderParameter("ERROR", "El correo ya fue registrado con anterioridad");
                    return;
                }
                User newUser = userRep.createUser();
                newUser.setLogin(usrLogin);
                newUser.setEmail(usrLogin);
//                subject.getPrincipals().clear();
//                subject.getPrincipals().add(newUser);
                newUser.setLanguage(user.getLanguage());
                newUser.setIp(user.getIp());
                //newUser.setActive(true);
                newUser.setDevice(user.getDevice());
                try {
                    if (null!=request.getParameter("usrName") && !"".equals(request.getParameter("usrName").trim())){
                        newUser.setFirstName(request.getParameter("usrName").trim());
                    }
                    if (null!=request.getParameter("usrPrimA") && !"".equals(request.getParameter("usrPrimA").trim())){
                        newUser.setLastName(request.getParameter("usrPrimA").trim());
                    }
                    if (null!=request.getParameter("usrSegA") && !"".equals(request.getParameter("usrSegA").trim())){
                        newUser.setSecondLastName(request.getParameter("usrSegA").trim());
                    }
                    if (null!=request.getParameter("clave") && !"".equals(request.getParameter("clave").trim())){
                        newUser.setPassword(request.getParameter("clave").trim());
                    }
                    if (null!=request.getParameter("preguntaSecreta") && !"".equals(request.getParameter("preguntaSecreta").trim())){
                        newUser.setSecurityQuestion(Integer.valueOf(request.getParameter("preguntaSecreta").trim()));
                    }
                    if (null!=request.getParameter("respuestaSecreta") && !"".equals(request.getParameter("respuestaSecreta").trim())){
                        newUser.setSecurityAnswer(request.getParameter("respuestaSecreta").trim());
                    }
                    if (null!=request.getParameter("nest") && !"".equals(request.getParameter("nest").trim())){
                        NivelEstudio ne = NivelEstudio.ClassMgr.getNivelEstudio(request.getParameter("nest").trim(), response.getWebPage().getWebSite());
                        if (null!= ne)
                            newUser.getSemanticObject().addObjectProperty(Becarios.becas_usrNivelEstudios, ne.getSemanticObject());
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

                    String err = updateCurp(request, response.getWebPage(), newUser);
                    if (null!=err) response.setRenderParameter("ERROR", err);

                    String [] intereses = request.getParameterValues("interes");
                    if (null != intereses)
                    {
                        for (String interes: intereses){
                            Institucion instit=Institucion.ClassMgr.getInstitucion(interes, response.getWebPage().getWebSite());
                            if (null!= instit)
                                newUser.getSemanticObject().addObjectProperty(Becarios.becas_hasInterestIn, instit.getSemanticObject());
                        }
                    }
                    response.setMode(response.Mode_EDIT);
                } catch (SWBException swbe) {
                    log.error("registrando usuario", swbe);
                }
                String token = SWBUtils.CryptoWrapper.genCryptoToken();
                while (TicketActivate.ClassMgr.hasTicketActivate(token, userRep)){
                    System.out.println("************************************ "+token);
                    token = SWBUtils.CryptoWrapper.genCryptoToken();
                }
                TicketActivate ta=TicketActivate.ClassMgr.createTicketActivate(token, userRep);
                ta.setTVused(false);
                ta.setTVRelatedTo(newUser);
                
                String url = "http://"+request.getServerName()+":"+request.getServerPort()+response.getWebPage().getWebSite().getWebPage("TicketActivate").getRealUrl()+"/"+token;
                String message = SWBUtils.TEXT.replaceAll(Message,"{$link}",url);
                SWBUtils.EMAIL.sendBGEmail(usrLogin, "Registro al portal de Becas de la SEP", message);
//                System.out.println("*************** "+newUser.isActive());
                //user = newUser;
                request.getSession(true).setAttribute("nombre", newUser.getFirstName());
                request.getSession(true).setAttribute("mail", usrLogin);
//                System.out.println("*************** "+user.isActive());
            }
    }

    String updateCurp(HttpServletRequest request, WebPage webPage, User newUser)
    {
        String ret = null;
        String curp = request.getParameter("CURP");
        if (null != curp && !"".equals(curp.trim()))
        {
            curp=curp.toUpperCase();
            Iterator<SemanticObject> iso = webPage.getWebSite().getUserRepository().getSemanticObject().getModel().listSubjects(Becarios.becas_usrCURP, curp);
            if (iso.hasNext())
            { //System.out.println("Curp EXISTE ***********************");
                ret = "La CURP ya fue dada de alta con anterioridad";
            } else
            {
                try
                {
                    if (null != (new ValidaCURPSEP()).checa(curp))
                    {

                        newUser.setExtendedAttribute(Becarios.becas_usrCURP, curp.toUpperCase());

                        if (null != request.getParameter("cveEntNac") && !"".equals(request.getParameter("cveEntNac").trim()))
                        {
                            newUser.setExtendedAttribute(Becarios.becas_usrCveEntidadNac, request.getParameter("cveEntNac").trim());
                        }
                        if (null != request.getParameter("fechaNac") && !"".equals(request.getParameter("fechaNac").trim()))
                        {
                            newUser.setExtendedAttribute(Becarios.becas_usrFechaNac, request.getParameter("fechaNac").trim());
                        }
                        if (null != request.getParameter("sexo") && !"".equals(request.getParameter("sexo").trim()))
                        {
                            newUser.setExtendedAttribute(Becarios.becas_usrSexo, request.getParameter("sexo").trim());
                        }
                    }
                } catch (Exception noe)
                {
                    ret = "Error al actualizar la CURP";
                }

            }
        }

        return ret;
    }


    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html");
        if (paramRequest.getUser().isSigned()){
            String nombre = paramRequest.getUser().getFullName();
            String tmp = SWBUtils.TEXT.replaceAll(editado,"{$nombre}",nombre);
            response.getWriter().println(tmp);
            if (null!=request.getParameter("ERROR")){
                tmp = tmp + "<script>alert('ERROR: "+request.getParameter("ERROR").replace('\'','`')+"');</script>";
            }
            return;
        }
        String nombre = null!=request.getSession().getAttribute("nombre")?(String)request.getSession().getAttribute("nombre"):"";
        String mail = null!=request.getSession().getAttribute("mail")?(String)request.getSession().getAttribute("mail"):"";
        String tmp = SWBUtils.TEXT.replaceAll(Activacion,"{$nombre}",nombre);
        tmp = SWBUtils.TEXT.replaceAll(tmp,"{$correo}",mail);
        response.getWriter().println(tmp);
    }

    public void doMunicipio(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String edoID = request.getRequestURI();
        edoID = edoID.substring(edoID.lastIndexOf("/")+1);
        //System.out.println(request.getRequestURI()+" - "+edoID);
        response.setContentType("text/html; charset=ISO8859-1");
        
        //Estado edo = Estado.ClassMgr.getEstado(edoID, paramRequest.getWebPage().getWebSite());
        HashMap<String, String>munhash = muni.get(edoID);
        if (null == munhash){
            munhash = muni.get(muni.keySet().iterator().next());
        }
        String muncombo = "<select name=\"municipio\" size=\"1\" class=\"inputPop\" id=\"municipio\" >";
        Iterator<String> imun = munhash.keySet().iterator();
                while (imun.hasNext()){
                    String mun = imun.next();
                    muncombo += "<option value=\""+mun+"\" >"+munhash.get(mun)+"</option>";
                }
        muncombo +="</select>";
        response.getWriter().println(muncombo);

    }

    public void doCURP(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String ret="";
        String curp=request.getRequestURI();
        curp=curp.substring(curp.lastIndexOf("/")+1);
        curp=curp.toUpperCase();
        Iterator<SemanticObject>iso = paramRequest.getWebPage().getWebSite().getUserRepository().getSemanticObject().getModel().listSubjects(Becarios.becas_usrCURP, curp);
        if (!iso.hasNext()) {
        try {
            DatosFromCURPSEP datos = (new ValidaCURPSEP()).checa(curp);
            if (null != datos){
                ret = "var vforma=document.getElementById('formaRegistro'); "
                        + "vforma.curpchkd.value=\"yes\"; "
                        + "vforma.cveEntNac.value=\""+datos.getCveEdoNac()+"\"; "
                        + "vforma.fechaNac.value=\""+datos.getFechaNac()+"\"; "
                        + "vforma.sexo.value=\""+datos.getSexo()+"\"; "
                        + "vforma.usrName.value=\""+datos.getNombres()+"\"; "
                        + "vforma.usrPrimA.value=\""+datos.getApellido1()+"\"; "
                        + "vforma.usrSegA.value=\""+datos.getApellido2()+"\"; "
                        + "curpSpace.innerHTML=\"Validado\";"; //curpchkd cveEntNac fechaNac sexo usrName usrPrimA usrSegA
            } else {
                ret = "alert('CURP NO EXISTE'); curpSpace.innerHTML=\"Inexistente...\";";
            }

        } catch (Exception noe) {
            ret = "alert('Error al validar CURP: "+noe.getMessage()+"'); curpSpace.innerHTML=\"&nbsp;\";";
        }
        } else {
            ret = "alert('Ya se han registrado con esta CURP'); curpSpace.innerHTML=\"Ya registrada...\";";
        }
        response.getWriter().print(ret);
    }

    public void doCURPED(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String ret="";
        String curp=request.getRequestURI();
        curp=curp.substring(curp.lastIndexOf("/")+1);
        curp=curp.toUpperCase();
        Iterator<SemanticObject>iso = paramRequest.getWebPage().getWebSite().getUserRepository().getSemanticObject().getModel().listSubjects(Becarios.becas_usrCURP, curp);
        if (!iso.hasNext()) {
        try {
            DatosFromCURPSEP datos = (new ValidaCURPSEP()).checa(curp);
            if (null != datos){
                ret = "var vforma=document.getElementById('formaRegistro'); "
                        + "vforma.curpchkd.value=\"yes\"; "
                        + "vforma.cveEntNac.value=\""+datos.getCveEdoNac()+"\"; "
                        + "vforma.fechaNac.value=\""+datos.getFechaNac()+"\"; "
                        + "vforma.sexo.value=\""+datos.getSexo()+"\"; "
                        + "vforma.usrName.value=\""+datos.getNombres()+"\"; "
                        + "vforma.usrPrimA.value=\""+datos.getApellido1()+"\"; "
                        + "vforma.usrSegA.value=\""+datos.getApellido2()+"\"; "
                        + "curpSpace.innerHTML=\"Validado\";"; //curpchkd cveEntNac fechaNac sexo usrName usrPrimA usrSegA
            } else {
                ret = "alert('CURP NO EXISTE'); curpSpace.innerHTML=\"Inexistente...\";";
            }

        } catch (Exception noe) {
            ret = "alert('Error al validar CURP: "+noe.getMessage()+"'); curpSpace.innerHTML=\"&nbsp;\";";
        }
        } else {
            ret = "alert('Ya se han registrado con esta CURP'); curpSpace.innerHTML=\"ya registrada...\";";
        }
        response.getWriter().print(ret);
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equalsIgnoreCase("Municipio"))
        {
            doMunicipio(request, response, paramRequest);
        } 
        else if (paramRequest.getMode().equalsIgnoreCase("curp"))
        {
            doCURP(request, response, paramRequest);
        }
        else if (paramRequest.getMode().equalsIgnoreCase("curpEd"))
        {
            doCURPED(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }


}
