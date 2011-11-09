/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.stps.portalempleo.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class Live extends GenericAdmResource {
    private static Logger log = SWBUtils.getLogger(Live.class);
    
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String mode = paramRequest.getMode();
        if("chat".equals(mode))
            doChat(request, response, paramRequest);
        else
            super.processRequest(request, response, paramRequest);
    }

    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        StringBuilder sb = new StringBuilder(1000);
        PrintWriter out = response.getWriter();
        SWBResourceURL url = null;
        url = paramRequest.getRenderUrl().setMode("chat");

        sb.append("\n<script type=\"text/javascript\">");
        sb.append("\n  function valida() {");
        sb.append("\n     var patt1 = new RegExp(\"^[a-z0-9,!#\\$%&'\\*\\+/=\\?\\^_`\\{\\|}~-]+(\\.[a-z0-9,!#\\$%&'\\*\\+/=\\?\\^_`\\{\\|}~-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2,})$\", \"i\");");
        sb.append("\n     if (document.ayuda.firstName.value.match(/^$|^\\s+$/) || document.ayuda.firstName.value == \"\") {");
        sb.append("\n         alert(\"Por favor, capture su nombre.\");");
        sb.append("\n         document.getElementById(\"firstName\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (document.ayuda.lastName.value.match(/^$|^\\s+$/) || document.ayuda.lastName.value == \"\") {");
        sb.append("\n         alert(\"Por favor, capture su apellido paterno.\");");
        sb.append("\n         document.getElementById(\"lastName\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (checkFieldChars(document.ayuda.firstName.value)) {");
        sb.append("\n         alert(\"El nombre no puede contener los carcteres siguientes:\\n \\\\ & + %  \\\" #\")");
        sb.append("\n         document.getElementById(\"firstName\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (checkFieldChars(document.ayuda.lastName.value)) {");
        sb.append("\n         alert(\"El apellido paterno no puede contener los carcteres siguientes:\\n \\\\ & + %  \\\" #\")");
        sb.append("\n         document.getElementById(\"lastName\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (checkFieldChars(document.ayuda.materno.value)) {");
        sb.append("\n         alert(\"El apellido materno no puede contener los caracteres siguientes:\\n \\\\ & + %  \\\" #\")");
        sb.append("\n         document.getElementById(\"materno\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (document.ayuda.tipoUsuario.selectedIndex < 1) {");
        sb.append("\n         alert(\"Por favor, seleccione una opción para la pregunta ¿Usted Es?\");");
        sb.append("\n         document.getElementById(\"tipoUsuario\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (document.ayuda.canal.selectedIndex < 1) {");
        sb.append("\n         alert(\"Por favor, seleccione un canal\");");
        sb.append("\n         document.getElementById(\"canal\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (checkFieldChars(document.ayuda.asunto.value)) {");
        sb.append("\n         alert(\"El asunto no puede contener los carcteres siguientes:\\n \\\\ & + %  \\\" #\")");
        sb.append("\n         document.getElementById(\"asunto\").focus();");
        sb.append("\n         return false;");
        sb.append("\n     }");
        sb.append("\n     if (document.ayuda.asunto.value == \"\") {");
        sb.append("\n         alert(\"Por favor escriba su mensaje.\");");
        sb.append("\n         document.ayuda.asunto.focus();");
        sb.append("\n         return;");
        sb.append("\n    }");
        sb.append("\n    if (document.ayuda.asunto.value.length > 100) {");
        sb.append("\n        alert(\"Escriba no mÃ­s de 100 caracteres.\");");
        sb.append("\n        document.ayuda.asunto.focus();");
        sb.append("\n        return;");
        sb.append("\n    }");
        sb.append("\n     if(document.ayuda.conCopia[0].checked){if (document.ayuda.email.value == \"\") {");
        sb.append("\n         alert(\"Por favor escriba su cuenta de correo.\");");
        sb.append("\n         document.ayuda.email.focus();");
        sb.append("\n         return false;");
        sb.append("\n     } else if(!patt1.test(document.ayuda.email.value)) {");
        sb.append("\n         alert(\"Por favor revise el formato de la cuenta de correo.\");");
        sb.append("\n         document.ayuda.email.focus();");
        sb.append("\n         return false;");
        sb.append("\n    }}");
        sb.append("\n    if (document.ayuda.asunto.value.length > 100) {");
        sb.append("\n        document.ayuda.asunto.value = document.ayuda.asunto.value.substr(0, 99);");
        sb.append("\n    }");
        sb.append("\n  ");
        sb.append("\n  ");
        sb.append("\n    document.ayuda.submit();");
        sb.append("\n  }");
        sb.append("\n  function checkFieldChars(sFieldValue) {");
        sb.append("\n      return (sFieldValue.indexOf(\"&\") != -1  ||");
        sb.append("\n              sFieldValue.indexOf(\"+\") != -1  ||");
        sb.append("\n              sFieldValue.indexOf(\"%\") != -1  ||");
        sb.append("\n              sFieldValue.indexOf(\"#\") != -1  ||");
        sb.append("\n              sFieldValue.indexOf(\"\\\\\") != -1 ||");
        sb.append("\n              sFieldValue.indexOf(\"\\\"\") != -1)");
        sb.append("\n  }");
        sb.append("\n  function showEmail(){document.getElementById('email').disabled= false;}");
        sb.append("\n  function hideEmail(){document.getElementById('email').disabled= true;}");
        sb.append("\n</script>");

        sb.append("\n  <table id=\"ayuda\">");
        sb.append("\n  <tr>");
        sb.append("\n    <td><p align=\"justify\" class=\"textmin\">Este apartado constituye un mecanismo de  comunicaci&oacute;n para asesor&iacute;a en l&iacute;nea sobre la navegaci&oacute;n (operaci&oacute;n) del Portal  del Empleo. La asesor&iacute;a la recibir&aacute; directamente de un ejecutivo capacitado  para ayudarle a resolver sus problemas de operaci&oacute;n y navegaci&oacute;n del sitio. El  horario de servicio es de las 8:00 a 20:00 hrs. de lunes a viernes si tiene  alguna duda en un horario distinto d&eacute;jenos un mensaje a trav&eacute;s de la&nbsp; opci&oacute;n de contacto y nosotros le daremos  respuesta a sus dudas.</p>");

        sb.append("\n      <p align=\"justify\" class=\"textmin\">Es importante que tenga en cuenta que la asesor&iacute;a que se le  brindar&aacute; es s&oacute;lo sobre la navegaci&oacute;n del Portal del Empleo.</p>");

        sb.append("\n      <p align=\"justify\" class=\"textmin\">No se admitir&aacute; contenido Obsceno o que falten el respeto a las  personas, instituciones u organismos.</p>");

        sb.append("\n      <p align=\"justify\" class=\"textmin\">Por favor llene los campos siguientes lo cual nos permitir&aacute; tener  la oportunidad de atenderle mejor.</p>");

        sb.append("\n      <form name=\"ayuda\" method=\"post\" action=\"").append(url).append("\" >");
        sb.append("\n        <table>");
        sb.append("\n          <tr >");
        sb.append("\n            <td><p class=\"textmin\">Nombre:</p></td>");

        sb.append("\n            <td><input name=\"firstName\" id=\"firstName\" type=\"text\" maxlength=\"30\" class=\"textmin\" ></td>");

        sb.append("\n          </tr>");
        sb.append("\n          <tr >");
        sb.append("\n            <td><p class=\"textmin\">Apellido Paterno:</p></td>");

        sb.append("\n            <td><input name=\"lastName\"  id=\"lastName\"type=\"text\" maxlength=\"35\" class=\"textmin\" ></td>");

        sb.append("\n          </tr>");
        sb.append("\n          <tr >");
        sb.append("\n            <td><p class=\"textmin\">Apellido Materno:</p></td>");

        sb.append("\n            <td><input name=\"materno\" id=\"materno\" type=\"text\" maxlength=\"35\" class=\"textmin\" ></td>");

        sb.append("\n          </tr>");
        sb.append("\n          <tr>");
        sb.append("\n            <td class=\"textmin\" >&iquest;Usted Es?&nbsp; </td>");

        sb.append("\n            <td>");
        sb.append("\n              <select name=\"tipoUsuario\" id=\"tipoUsuario\" size=\"1\" class=\"textmin\">");
        sb.append("\n                <option value=\"0\">SELECCIONE UNA OPCI&Oacute;N</option>");
        sb.append("\n                <option value=\"1\">BUSCADOR DE EMPLEO</option>");
        sb.append("\n                <option value=\"2\">EMPRESARIO</option>");
        sb.append("\n                <option value=\"3\">ESTUDIANTE</option>");
        sb.append("\n                <option value=\"4\">TRABAJADOR EN ACTIVO</option>");
        sb.append("\n                <option value=\"5\">OTRO</option>");
        sb.append("\n              </select>");
        sb.append("\n            </td>");
        sb.append("\n          </tr>");
        sb.append("\n          <tr >");
        sb.append("\n            <td class=\"textmin\" >Indique la sección  sobre el que tiene Dudas: </td>");

        sb.append("\n            <td>");
        sb.append("\n              <select name=\"canal\" id=\"canal\" size=\"1\" class=\"textmin\">");
        sb.append("\n                <option value=\"0\">SELECCIONE UNA OPCI&Oacute;N</option>");
//        while(set.hasNext()) { 
//            WebPage wp = set.next();
//            String despliegue = wp.getDisplayTitle(lang);
//            sb.append("\n                <!--option value=\"" + despliegue + "\">" + despliegue + "</option-->");
//        }
        sb.append("\n                <option value=\"1\">Busco empleo</option>");
        sb.append("\n                <option value=\"2\">Ofrezco empleo</option>");
        sb.append("\n                <option value=\"3\">Opciones de capacitaci&oacute;n</option>");
        sb.append("\n                <option value=\"4\">&iquest;Qu&eacute; me conviene estudiar?</option>");
        sb.append("\n                <option value=\"5\">Asesor&iacute;a para el trabajo</option>");
        sb.append("\n                <option value=\"6\">Estad&iacute;sticas del mercado laboral</option>");
        sb.append("\n            </select></td>");
        sb.append("\n          </tr>");
        sb.append("\n          <tr >");
        sb.append("\n            <td class=\"textmin\" ><p>&iquest;En que podemos ayudarle?</p></td>");

        sb.append("\n            <td>");
        sb.append("\n              <textarea name=\"asunto\" id=\"asunto\" maxlength=\"100\" cols=\"40\" rows=\"8\" class=\"textmin\"></textarea>");
        sb.append("\n              <br><font class=\"textmin\">Cuenta con 100 caracteres como m&aacute;ximo para su pregunta inicial</font>");
        sb.append("\n            </td>");
        sb.append("\n          </tr>");
        sb.append("\n          <tr >");
        sb.append("\n            <td class=\"textmin\" >&iquest;Desea  copia de la conversaci&oacute;n?</td>");
        sb.append("\n            <td class=\"textmin\"><input name=\"conCopia\" id=\"conCopia\" type=\"radio\" value=\"1\" onClick=\"showEmail()\">Si<input name=\"conCopia\" id=\"sinCopia\" type=\"radio\" value=\"0\" onClick=\"hideEmail()\">No</td>");
        sb.append("\n          </tr>");
        sb.append("\n          <tr >");
        sb.append("\n            <td class=\"textmin\" >Correo Electr&oacute;nico:</td>");

        sb.append("\n            <td><input name=\"email\" id=\"email\" type=\"text\" maxlength=\"50\" class=\"textmin\" disabled ></td>");

        sb.append("\n          </tr>");
        sb.append("\n        </table>");
        sb.append("\n        <p>");
        sb.append("\n          <input type=\"button\" onclick=\"javascript:valida();\" class=\"btn\" value=\"INICIAR ASESOR&Iacute;A EN L&Iacute;NEA\" >");
        sb.append("\n        </p>");
        sb.append("\n      </form>");
        sb.append("\n      <p align=\"justify\" class=\"textmin\">&nbsp;</p></td>");
        sb.append("\n  </tr>");
        sb.append("\n</table>");

        out.print(sb.toString());
    }
    
    public void doChat(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        StringBuilder sb = new StringBuilder();
        PrintWriter out = response.getWriter();
        String firstName = "";
        String lastName = "";
        String materno = "";
        String email = "";
        int tipoUsuario = 0;
        String canal = "";
        String asunto = "";
        String conCopia = "";
        String enMensaje = "";
        log.info(" >> AtencionEnLinea En doEdit");
        if ((request.getParameter("firstName") != null) && (!"".equals(request.getParameter("firstName")))) {
          firstName = request.getParameter("firstName");
        }
        if ((request.getParameter("lastName") != null) && (!"".equals(request.getParameter("lastName")))) {
          lastName = request.getParameter("lastName");
        }
        if ((request.getParameter("materno") != null) && (!"".equals(request.getParameter("materno")))) {
          materno = request.getParameter("materno");
        }
        if ((request.getParameter("email") != null) && (!"".equals(request.getParameter("email")))) {
          email = request.getParameter("email");
        }
        if ((request.getParameter("tipoUsuario") != null) && (!"".equals(request.getParameter("tipoUsuario")))) {
          try {
            tipoUsuario = Integer.parseInt(request.getParameter("tipoUsuario"));
            switch (tipoUsuario) { case 1:
              enMensaje = "Tipo de usuario: BUSCADOR DE EMPLEO,";
              break;
            case 2:
              enMensaje = "Tipo de usuario: EMPRESARIO,";
              break;
            case 3:
              enMensaje = "Tipo de usuario: ESTUDIANTE,";
              break;
            case 4:
              enMensaje = "Tipo de usuario: TRABAJADOR EN ACTIVO,";
              break;
            case 5:
              enMensaje = "Tipo de usuario: OTRO,"; }
          }
          catch (NumberFormatException nfe)
          {
            log.error("Al convertir el tipo de usuario en chat", nfe);
          }
        }
        if ((request.getParameter("canal") != null) && (!"".equals(request.getParameter("canal")))) {
          canal = request.getParameter("canal");
          if (canal.equals("1")) {
            enMensaje = enMensaje + " Canal: Busco empleo. ";
          }
          if (canal.equals("2")) {
            enMensaje = enMensaje + " Canal: Ofrezco empleo. ";
          }
          if (canal.equals("3")) {
            enMensaje = enMensaje + " Canal: Opciones de capacitaciÃ³n. ";
          }
          if (canal.equals("4")) {
            enMensaje = enMensaje + " Canal: Qué me conviene estudiar?. ";
          }
          if (canal.equals("5")) {
            enMensaje = enMensaje + " Canal: Asesoría para el trabajo. ";
          }
          if (canal.equals("6")) {
            enMensaje = enMensaje + " Canal: Estadasticas del mercado laboral. ";
          }
        }
        if ((request.getParameter("asunto") != null) && (!"".equals(request.getParameter("asunto")))) {
          asunto = request.getParameter("asunto").replace('\n', ' ');
          asunto = asunto.replace('\r', ' ');
        }
        if (request.getParameter("conCopia") != null)
          conCopia = request.getParameter("conCopia");
        else {
          conCopia = "0";
        }

        sb.append("\n    <p align=\"justify\" class=\"textmin\">Comienzo de la charla.</p>");
        sb.append("\n<script type=\"text/javascript\">");
        sb.append("\n  var dir = \"http://cti.toptel.com.mx/cti/chat/?proyecto=sne&p=sne&b=LOGIND&%7Bnombre%7D=").append(firstName).append("%20&%7Bapellidos%7D=").append(lastName).append(" ").append(materno).append("%20&%7Bmail%7D=").append(email).append("&comentarios=Tipo%20de%20usuario:%20").append(tipoUsuario).append(",%20Canal:").append(canal).append("%20").append(asunto).append("&%7Bsendchat%7D=1\";");
        sb.append("\n  window.open(dir, \"chat\", \"width=400,height=400,location=no,menubar=no,directories=no,resizable=no,scrollbars=no,toolbar=no,status=no\");");
        sb.append("\n</script>");
        out.print(sb.toString());
  }
}
