/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gob.sep.becas;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
/**
 *
 * @author vanessa.hernandez
 */
public class ActivateSuscripcion extends GenericResource{

    String mensage="<img src=\""+SWBPortal.getContextPath()+"/work/models/Beca_SEP/images/bienvenido.png\" />\n"+
        "<h3>{$nombre}, tu cuenta ha sido activada</h3>\n"+
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

    String messError="<h3>ERROR: Liga inv&aacute;lida</h3>";

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        String path = request.getRequestURL().toString();
        String token = path.substring(path.lastIndexOf('/')+1);
        try {
        //String token = SWBUtils.CryptoWrapper.byteArrayToHexString(SWBUtils.CryptoWrapper.PBEAES128Cipher("infotec", usrMail.getBytes()));
        String idMail = new String (SWBUtils.CryptoWrapper.PBEAES128Decipher("infotec", SWBUtils.CryptoWrapper.hexStringToByteArray(token)));

        String[] tmp= idMail.split("\\|");
        String id =tmp[0];
        SubscrpcionCorreo sub = SubscrpcionCorreo.ClassMgr.getSubscrpcionCorreo(id, paramRequest.getWebPage().getWebSite());
        if (null !=sub) {
        sub.setSubActivo(true);
        }
        String mail =tmp[1];
        
        response.setContentType("text/html");
        String cad = SWBUtils.TEXT.replaceAll(mensage,"{$nombre}",mail);
        response.getWriter().println(cad);
        } 
        catch (Exception e){}
    }

}
