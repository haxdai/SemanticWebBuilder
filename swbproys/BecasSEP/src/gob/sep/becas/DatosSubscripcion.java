/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.sep.becas;
import java.io.IOException;
import java.util.*;
//import javax.security.auth.Subject;
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
 * @author vanessa.hernandez
 */
public class DatosSubscripcion extends GenericResource {

        String tplt = "<script  type=\"text/javascript\">"+
            "function submitfrm() { "+
            "var forma = document.getElementById(\"formaRegistro\"); "+
            "if (forma.mail.value.length==0 || !validateElement('frmCaptchaValue','/frmprocess/validCaptcha?none=1',forma.frmCaptchaValue.value) "+
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
            "</script>"+
        "<script type=\"text/javascript\" src=\""+SWBPortal.getContextPath()+"/swbadmin/js/swb.js\" ></script><form id=\"formaRegistro\" name=\"formaRegistro\" method=\"post\" action=\"{$actionURL}\">"
        + "<link type=\"text/css\" rel=\"stylesheet\" href=\""+SWBPortal.getContextPath()+"/work/models/Beca_SEP/CSS/estilos_lightBox.css\" />\n"+ // /work/estilos_lightBox.css
        "<h3>Recibir Información</h3>\n"+
        "<p class=\"introPop\">Bienvenido, para mantenerte informado respecto de las convocatorias de tu interés, ayúdanos con la siguiente información:</p>\n"+
        "<p class=\"obligatorio\">*Datos Obligatorios, favor de proporcionarlos</p>\n"+
        "<p>&nbsp;</p>\n"+
        "<h3>Nivel de Estudios de tú interés</h3>\n"+
        "<div>\n"+
        "  <p class=\"nivel\">\n"+
        "{$niveles}"+
        "  </p>\n"+
        "<div style=\"clear:both\">&nbsp;</div>"+
        "</div>\n"+
        "<p>&nbsp;</p>\n"+
      "<h3>Becas de Inter&eacute;s</h3>\n"+
        "<div>\n"+
        "  <p class=\"instituciones\">\n"+
        "{$instituciones}"+
        "  </p>\n"+
        "<div style=\"clear:both\">&nbsp;</div>"+
        "</div>\n"+
      "<h3>Ayúdanos a conocerte</h3>\n"+
        "<div id=\"edad\">\n"+
        "  <p>\n"+
        "    <label for=\"edad\">¿Cuántos años tienes?</label>\n"+
        "       <select id=\"edad\" class=\"inputPop\" size=\"1\" name=\"edad\">\n"+
        "       <option value=\"Menor a 10\">Menor a 10</option>\n"+
        "       <option value=\"10-20\">10-20</option>\n"+
        "       <option value=\"21-30\">21-30</option>\n"+
        "       <option value=\"31-40\">31-40</option>\n"+
        "       <option value=\"41-50\">41-50</option>\n"+
        "       <option value=\"51-60\">51-60</option>\n"+
        "       <option value=\"61-70\">61-70</option>\n"+
        "       <option value=\"71-80\">71-80</option>\n"+
        "       <option value=\"81-90\">81-90</option>\n"+
        "       <option value=\"Mayor a 90\">Mayor a 90</option>\n"+
        "       </select>\n"+
        "  </p>\n"+
        "<div style=\"clear:both\">&nbsp;</div>"+
        "</div>\n"+              
        "<div id=\"tipodetelefono\">\n"+
        "  <p class=\"popText\">¿Cuál es tu género?</p>\n"+
        "  <p>\n"+
        "    <input type=\"radio\" name=\"genero\" id=\"genero\" value=\"M\" class=\"radioB\" />\n"+
        "    <label for=\"genero\">Mujer</label>\n"+
        "    <input type=\"radio\" name=\"genero\" id=\"genero\" value=\"F\" class=\"radioB\" />\n"+
        "    <label for=\"genero\">Hombre</label>\n"+
        "  </p>\n"+
        "<div style=\"clear:both\">&nbsp;</div>"+
        "</div>\n"+
        "<div id=\"estado\">\n"+
        "  <p>\n"+
        "    <label for=\"estado\">¿En qué estado vives?</label>\n"+
        "{$estado}"+
        "  </p>\n"+
        "<div style=\"clear:both\">&nbsp;</div>"+
        "</div>\n"+
        "<div id=\"municipioDel\">\n"+
        "  <p>\n"+
        "    <label for=\"municipio\">¿En qué municipio o delegaci&oacute;n vives?</label>\n"+
        "<div id=\"MunChg\"><select name=\"municipio\" size=\"1\" class=\"inputPop\" id=\"municipio\" >{$currMun}</select></div>\n"+
        "  </p>\n"+
        "<div style=\"clear:both\">&nbsp;</div>"+
        "</div>\n"+
        "  <label for=\"mail\" class=\"obligatorio\">* Si deseas recibir información de las becas que se publiquen en este portal déjanos tu correo electrónico</label>\n"+
        "  <input type=\"text\" name=\"mail\" id=\"mail\" class=\"inputPop\" onchange=\" if (!isValidEmail(this.value))"+
        " alert ('El correo electrónico no es válido o ya fue registrado por otro usuario. Verifica que contenga \"@\" o ingresa una nueva dirección de correo electrónico.');\"/>\n"+
        "</p>\n"+
        "<span>\n"+
        "<p>Verificaci&oacute;n de Palabras</p>\n"+
        "<p>Escribe los caracteres que veas en la siguiente imagen *</p>\n"+
        "</span>\n"+
        "<p><img  src=\""+SWBPlatform.getContextPath()+"/frmprocess/requestCaptcha\" alt=\"captcha\" id=\"captchaimg\" />\n"+
        "<a onclick=\"document.getElementById('captchaimg').src='"+SWBPlatform.getContextPath()+
                        "/frmprocess/requestCaptcha?'+ Math.random(); document.getElementById('captcha').value=''; return false;\">cambiar imagen</a></p>\n"+ //Captcha - width=\"345\" height=\"59\"
        "<p>&nbsp;\n"+
        "  <input type=\"text\" name=\"frmCaptchaValue\" id=\"frmCaptchaValue\" class=\"inputPop\" onchange=\"if (!validateElement('frmCaptchaValue','/frmprocess/validCaptcha?none=1',this.value)) "+
        "alert('Los caracteres son incorrectos. Asegúrate de escribir el texto tal como se muestra en la imagen.');\"/>\n"+
        "</p>\n"+
        "<p><input type=\"checkbox\" id=\"polpriv\" name=\"polpriv\" value=\"OK\">He leído y acepto los términos de uso y las políticas de "
        + "<a href=\"/es/Beca_SEP/Politicas_Privacidad\" target=\"_blank\">privacidad del sitio</a>.</p>\n"+
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
        "<h3>Hola <b>{$nombre}</b>, has creado tu suscripción en el Portal <em>Becas</em>, ahora debes activarla.</h3>\n"+
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

            
            String tmp = SWBUtils.TEXT.replaceAll(tplt,"{$actionURL}",paramRequest.getActionUrl().toString(true));
            //tmp = SWBUtils.TEXT.replaceAll(tmp,"{$preguntas}",Seguridad);
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$instituciones}",Instituciones);
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$niveles}",Niveles);
            //tmp = SWBUtils.TEXT.replaceAll(tmp,"{$model}",paramRequest.getUser().getUserRepository().getId());
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$estado}",EdosBase);
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$currMun}",MunBase);
            String urlmun = paramRequest.getRenderUrl().setMode("Municipio").setCallMethod(SWBResourceURL.Call_DIRECT).toString();
            tmp = SWBUtils.TEXT.replaceAll(tmp,"{$urlMun}",urlmun+"/");

            if (null!=request.getParameter("ERROR")){
                tmp = tmp + "<script>alert('ERROR: "+request.getParameter("ERROR").replace('\'','`')+"');</script>";
            }
            response.getWriter().println(tmp);

    }

@Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        if (null==request.getParameter("frmCaptchaValue") || null==request.getSession(true).getAttribute("captchaCad") ||!((String) request.getSession(true).getAttribute("captchaCad")).equalsIgnoreCase(request.getParameter("frmCaptchaValue")))
        {
            response.setRenderParameter("ERROR", "Falló la verificación de palabra");
            return;
        }
        if (null==request.getParameter("polpriv"))
        {
            response.setRenderParameter("ERROR", "No aceptó nuestra política de privacidad");
            return;
        }
        /* AQUI SE TIENE QUE SUBIR LA INFORMACION EN UNA CLASE COMO USER SUBSCRIPCION */
         
         String usrMail = request.getParameter("mail");
         SubscrpcionCorreo newSub = SubscrpcionCorreo.ClassMgr.createSubscrpcionCorreo(response.getWebPage().getWebSite());
                newSub.setEMail(usrMail);
                try {
                    if (null!=request.getParameter("nest") && !"".equals(request.getParameter("nest").trim())){
                        NivelEstudio ne = NivelEstudio.ClassMgr.getNivelEstudio(request.getParameter("nest").trim(), response.getWebPage().getWebSite());
                        if (null!= ne)
                            newSub.setNivelEducativo(ne);
                    }
                    if (null!=request.getParameter("estado") && !"".equals(request.getParameter("estado").trim())){
                        Estado edo = Estado.ClassMgr.getEstado(request.getParameter("estado").trim(), response.getWebPage().getWebSite());
                        if (null!= edo)
                            newSub.setSubEstado(edo);
                    }
                    if (null!=request.getParameter("municipio") && !"".equals(request.getParameter("municipio").trim())){
                        Municipio mun = Municipio.ClassMgr.getMunicipio(request.getParameter("municipio").trim(), response.getWebPage().getWebSite());
                        if (null!= mun)
                            newSub.setSubMunicipio(mun);
                    }
                    if (null!=request.getParameter("genero") && !"".equals(request.getParameter("genero").trim())){
                        newSub.setSubSexo(request.getParameter("genero").trim());

                    }
                    if (null!=request.getParameter("edad") && !"".equals(request.getParameter("edad").trim())){
                        newSub.setSubRangoEdad(request.getParameter("edad").trim());
                    }

                    String [] intereses = request.getParameterValues("interes");
                    if (null != intereses)
                    {
                        for (String interes: intereses){
                            Institucion instit=Institucion.ClassMgr.getInstitucion(interes, response.getWebPage().getWebSite());
                            if (null!= instit)
                                newSub.addInstituciones(instit);
                        }
                    }
                    newSub.setSubActivo(false);
                    response.setMode(response.Mode_EDIT); //envia a la sig pantalla
                } catch (Exception swbe) {
                    log.error("registrando usuario", swbe);
                }

                //Envio de mail
                try{
                String id=newSub.getId()+"|"+usrMail;
                System.out.println(id);
                System.out.println(usrMail);

                String token = SWBUtils.CryptoWrapper.byteArrayToHexString(SWBUtils.CryptoWrapper.PBEAES128Cipher("infotec", id.getBytes()));
                System.out.println(token);
                String url = "http://"+request.getServerName()+":"+request.getServerPort()+response.getWebPage().getWebSite().getWebPage("TicketActivate").getRealUrl()+"/"+token;
                System.out.println(url); //aqui esta el problema
                String message = SWBUtils.TEXT.replaceAll(Message,"{$link}",url);
                SWBUtils.EMAIL.sendBGEmail(usrMail, "Suscripción al portal de Becas de la SEP", message);
        } catch(Exception e){
        log.error("envio de correo", e);
        }
                 
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
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equalsIgnoreCase("Municipio"))
        {
            doMunicipio(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

}
