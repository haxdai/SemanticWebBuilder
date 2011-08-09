/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.sep.becas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SWBSoftkHashMap;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author serch
 */
public class RecuperarClave extends GenericResource {

static SWBSoftkHashMap<String, Status> enUso = new SWBSoftkHashMap<String, Status>();

static java.util.HashMap<String,String> preguntas;


String message1 = "<div id=\"cuerpo_pop2\">\n"+
"<link type=\"text/css\" rel=\"stylesheet\" href=\""+SWBPlatform.getContextPath()+"/work/models/Beca_SEP/CSS/estilos_lightBox.css\" />\n"+
"<h2>Restaurar contraseña</h2>\n"+
"<p>&nbsp;</p><form method=\"post\" id=\"frmMail\" name=\"frmMail\">\n"+
"<p class=\"introPop\">Bienvenido, para poder restaurar tu contraseña, necesitamos que nos proporciones las respuestas correctas a las siguientes preguntas:</p>\n"+
"<p class=\"introPop\">&nbsp;</p>\n"+
"<h3 class=\"introPop\">Paso 1</h3>\n"+
"<p class=\"introPop\">\n"+
"  <label for=\"textfield\">Correo Electr&oacute;nico</label>\n"+
"  <input type=\"text\" name=\"mail\" id=\"mail\" class=\"inputPop\" />\n"+
"  <span></span></p>\n"+
"<span>\n"+
"<p>Escribe los caracteres que veas en la siguiente imagen</p>\n"+
"</span>\n"+
"<p><img  src=\""+SWBPlatform.getContextPath()+"/frmprocess/requestCaptcha\" alt=\"captcha\" id=\"captchaimg\" />\n"+
        "<a onclick=\"document.getElementById('captchaimg').src='"+SWBPlatform.getContextPath()+
                        "/frmprocess/requestCaptcha?'+ Math.random(); document.getElementById('captcha').value=''; return false;\">cambiar imagen</a></p>\n"+ //Captcha - width=\"345\" height=\"59\"
        "<p>&nbsp;\n"+
        "  <input type=\"text\" name=\"frmCaptchaValue\" id=\"frmCaptchaValue\" class=\"inputPop\" onchange=\"if (!validateElement('frmCaptchaValue','/frmprocess/validCaptcha?none=1',this.value)) "+
        "alert('Verificación incorrecta');\"/></p>\n"+
"<p>&nbsp;</p>\n"+
"<p><a href=\"javascript:frmMail.submit()\" class=\"cerrarBoton\">Continuar</a></p></form>\n"+
"</div>\n";

String message2="<div id=\"cuerpo_pop2\">\n"+
"<link type=\"text/css\" rel=\"stylesheet\" href=\""+SWBPlatform.getContextPath()+"/work/models/Beca_SEP/CSS/estilos_lightBox.css\" />\n"+
"<h2>Restaurar contraseña</h2>\n"+
"<p>&nbsp;</p><form method=\"post\" id=\"frmSec\" name=\"frmSec\">\n"+
"<p class=\"introPop\">Bienvenido, para poder restaurar tu contraseña, necesitamos que nos proporciones las respuestas correctas a las siguientes preguntas:</p>\n"+
"<p class=\"introPop\">&nbsp;</p>\n"+
"<h3 class=\"introPop\">Paso 2</h3>\n"+
"<p><span class=\"introPop\">Responde tu pregunta secreta:</span></p>\n"+
"<p>{$secreta}</p>\n"+
"<p class=\"introPop\">\n"+
"  <label for=\"textfield\">Respuesta</label>\n"+
"  <input type=\"text\" name=\"secreta\" id=\"secreta\" class=\"inputPop\" />\n"+
"</p>\n"+
"<p class=\"introPop\">&nbsp;</p>\n"+
"<p><a href=\"javascript:frmSec.submit()\" class=\"cerrarBoton\">Continuar</a></p></form>\n"+
"</div>\n";


String message3="<script  type=\"text/javascript\"> function validatePassowrd(clave) {"+
            "var estado = document.getElementById(\"passwordstatus\");"+
            "if (clave.length<6) { "+
            "estado.innerHTML=\"La contraseña debe tener al menos 6 caracteres\";  "+
            "estado.style.color=\"red\";"+
            "return true; }"+
            "var pRegEx=/^[ A-Za-z0-9\\!\\@\\_\\-\\.]*?([A-Za-z][ A-Za-z0-9\\!\\@\\_\\-\\.]*?[0-9]|[0-9][ A-Za-z0-9\\!\\@\\_\\-\\.]*?[A-Za-z])[ A-Za-z0-9\\!\\@\\_\\-\\.]*$/;"+
            "if (!pRegEx.test(clave)) {"+
            "estado.innerHTML=\"La contraseña debe contener letras, números ó los símbolos ! @ _ - .\";  "+
            "estado.style.color=\"red\";"+
            "return true; }"+
           "estado.innerHTML=\"Contraseña aceptable\";  "+
            "estado.style.color=\"green\";"+
            "}\n"+
            "</script><div id=\"cuerpo_pop2\">\n"+
"<link type=\"text/css\" rel=\"stylesheet\" href=\""+SWBPlatform.getContextPath()+"/work/models/Beca_SEP/CSS/estilos_lightBox.css\" />\n"+
"<h2>Restaurar contraseña</h2>\n"+
"<p>&nbsp;</p><form method=\"post\" id=\"frmClave\" name=\"frmClave\" action=\"{$url}\">\n"+
"<p class=\"introPop\">Bienvenido, para poder restaurar tu contraseña, necesitamos que nos proporciones las respuestas correctas a las siguientes preguntas:</p>\n"+
"<p class=\"introPop\">&nbsp;</p>\n"+
"<h3 class=\"introPop\">Paso 3</h3>\n"+
"<p>Ingresa tu nueva contraseña</p>\n"+
"<p>\n"+
"  <label for=\"textfield2\">Contrase&ntilde;a*</label>\n"+
"  <input type=\"password\" name=\"clave\" id=\"clave\" class=\"inputPop\" onkeyup=\"validatePassowrd(this.value);\" />\n"+
"</p>\n"+
"<p>Nivel de Seguridad:<div id=\"passwordstatus\" style=\"color:red\">Proporcione una contraseña</div></p>\n"+
"<p>\n"+
"  <label for=\"textfield3\">Confirmar contrase&ntilde;a*</label>\n"+
"  <input type=\"password\" name=\"clave2\" id=\"clave2\" class=\"inputPop\" onchange=\"if (this.value!=clave.value) alert ('Las contraseñas son diferentes');\" />\n"+
"</p>\n"+
"<p>&nbsp;</p>\n"+
"<p><a href=\"javascript:frmClave.submit()\" class=\"cerrarBoton\">Guardar</a></p></form>\n"+
"</div>\n";


String message4="<div id=\"cuerpo_pop2\">\n"+
"<link type=\"text/css\" rel=\"stylesheet\" href=\""+SWBPlatform.getContextPath()+"/work/models/Beca_SEP/CSS/estilos_lightBox.css\" />\n"+
"<h2>Restaurar contraseña</h2>\n"+
"<p>&nbsp;</p>\n"+
"<h3><strong>¡Tu contraseña ha sido cambiada con éxito!</strong></h3>\n"+
"<p>  Use la nueva contraseña para iniciar sesión en los sitos y servicios del portal de Becas.</p>\n"+
"<p class=\"introPop\">&nbsp;</p>\n"+
"<p><a href=\"/\" class=\"cerrarBoton\">Regresar</a></p>\n"+
"</div>\n";

long tiempo = 1000l * 60 * 5;

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException
    {
        super.setResourceBase(base);
        preguntas=new HashMap<String, String>();
        String selectValues = SWBContext.getUserRepository(base.getWebSite().getUserRepository().getId()).getUserRepSecurityQuestionList("es");
        if (selectValues==null)
            selectValues = SWBContext.getUserRepository(base.getWebSite().getUserRepository().getId()).getUserRepSecurityQuestionList();
        if ((selectValues != null) && (!"".equals(selectValues.trim()))) {
                String[] st = selectValues.split("\\|");
                for(String tok:st) {
                    int    ind = tok.indexOf(':');
                    String id  = tok;
                    String val = tok;

                    if (ind > 0) {
                        id  = tok.substring(0, ind);
                        val = tok.substring(ind + 1);
                    }
                    preguntas.put(id, val);
            }
        }
    }





    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html");
        response.getWriter().println(message4);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html");
        if (null==request.getParameter("mail") && null==request.getParameter("secreta"))
        {
            PrintWriter pw = response.getWriter();
            pw.println(message1);
            String error = (String)request.getSession(true).getAttribute("error");
            if (null!=error){
                pw.println("<script>alert('"+error+"');</script>");
            }

        }
        if (null==request.getParameter("secreta") && null!=request.getParameter("mail"))
        {
            if (null==request.getParameter("frmCaptchaValue") || null==request.getSession(true).getAttribute("captchaCad") ||!((String) request.getSession(true).getAttribute("captchaCad")).equalsIgnoreCase(request.getParameter("frmCaptchaValue")))
            {
                PrintWriter pw = response.getWriter();
                pw.println(message1);
                pw.println("<script>alert('Falló la verificación de la palabra');</script>");
                return;
            }
            String mail=request.getParameter("mail");
            User user = paramRequest.getWebPage().getWebSite().getUserRepository().getUserByLogin(mail);
            if (null==user)
            {
                PrintWriter pw = response.getWriter();
                pw.println(message1);
                pw.println("<script>alert('Verifique su información');</script>");
            }
            else
            {
                int quest = user.getSecurityQuestion();
                if (quest<=0){
                    PrintWriter pw = response.getWriter();
                    pw.println(message1);
                    pw.println("<script>alert('No podemos verificar su identidad');</script>");
                }
                else
                {
                    Status actual = enUso.get(mail);
                    if (null==actual) {
                        actual = new Status();
                        actual.bloqueado=false;
                        actual.intentos=0;
                        actual.login=mail;
                        enUso.put(mail, actual);
                    }
                    if (actual.bloqueado){
                        if ((actual.timestamp+tiempo)<System.currentTimeMillis()) {
                            actual.bloqueado=false;
                            actual.intentos=0;
                        }
                    }
                    if (actual.bloqueado)
                    {
                        PrintWriter pw = response.getWriter();
                        pw.println(message1);
                        pw.println("<script>alert('Demasiados Intentos.');</script>");
                        return;
                    }
                    PrintWriter pw = response.getWriter();
                    String tmp = tmp = SWBUtils.TEXT.replaceAll(message2,"{$secreta}",preguntas.get(""+quest));
                    pw.println(tmp);
                    request.getSession(true).setAttribute("pwdrec", mail);
                }
            }

        }
        if (null==request.getParameter("mail") && null!=request.getParameter("secreta"))
        {
            String mail = (String)request.getSession(true).getAttribute("pwdrec");
            Status actual = enUso.get(mail);
            if (null==mail || null==actual){
                PrintWriter pw = response.getWriter();
                pw.println(message1);
                return;
            }
            if (actual.bloqueado)
                {
                    PrintWriter pw = response.getWriter();
                    pw.println(message1);
                    pw.println("<script>alert('Demasiados Intentos.');</script>");
                    return;
                }
            User user = paramRequest.getWebPage().getWebSite().getUserRepository().getUserByLogin(mail);
            if (user.getSecurityAnswer().equalsIgnoreCase(request.getParameter("secreta")))
            {
                actual.respuesta=request.getParameter("secreta");
                PrintWriter pw = response.getWriter();
                String tmp = tmp = SWBUtils.TEXT.replaceAll(message3,"{$url}",paramRequest.getActionUrl().toString());
                pw.println(tmp);
            } else {
                actual.intentos++;
                if (actual.intentos>=5){
                    actual.bloqueado=true;
                    actual.timestamp=System.currentTimeMillis();
                    PrintWriter pw = response.getWriter();
                    pw.println(message1);
                    pw.println("<script>alert('Demasiados Intentos.');</script>");
                    return;
                } else {
                    int quest = user.getSecurityQuestion();
                    if (quest<=0){
                        PrintWriter pw = response.getWriter();
                        pw.println(message1);
                        pw.println("<script>alert('No podemos verificar su identidad');</script>");
                        return;
                    }
                    PrintWriter pw = response.getWriter();
                    String tmp = tmp = SWBUtils.TEXT.replaceAll(message2,"{$secreta}",preguntas.get(""+quest));
                    pw.println(tmp);
                    pw.println("<script>alert('Respuesta secreta inválida');</script>");
                    request.getSession(true).setAttribute("pwdrec", mail);
                }
            }
            
        }
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        String mail = (String)request.getSession(true).getAttribute("pwdrec");
        Status actual = enUso.get(mail);
        if (null==mail || null==actual){
            response.setMode(response.Mode_VIEW); //System.out.println("Entro Directo");
            return;
        }
        User user = response.getWebPage().getWebSite().getUserRepository().getUserByLogin(mail);
        if (null==request.getParameter("clave") || !request.getParameter("clave").equals(request.getParameter("clave2")))
        {
            response.setMode(response.Mode_VIEW);
            request.getSession(true).setAttribute("error", "Contraseñas diferentes"); //System.out.println("Contraseñas diferentes");
            return;
        }
        user.setPassword(request.getParameter("clave").trim());
        response.setMode(response.Mode_EDIT);
        enUso.remove(mail);
        request.getSession(true).removeAttribute("pwdrec"); //System.out.println("clave cambiada");
    }

}

class Status {
    String login;
    String respuesta;
    boolean bloqueado;
    int intentos;
    long timestamp;
}