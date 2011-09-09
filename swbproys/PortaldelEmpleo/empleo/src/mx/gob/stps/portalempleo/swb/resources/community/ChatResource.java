package mx.gob.stps.portalempleo.swb.resources.community;

import mx.gob.stps.portalempleo.swb.resources.community.base.ChatResourceBase;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;
import org.semanticwb.SWBUtils;

import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.*;

    /**
    * Implementación de referencia para una aplicación de chat.
    * @author  Carlos Ramos
    * @version 1.0
    */

public class ChatResource extends ChatResourceBase
{

    public ChatResource()
    {
    }

    public ChatResource(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    /**
     * Despliega la aplicación de chat.
     * @param request El HttpServletRequest que recibe del contenedor de servlets
     * @param response El HttpServletResponse que recibe del contenedor de servlets
     * @param paramRequest El SWBParamRequest que recibe del ambiente SemanticWebBuilder
     * @throws SWBResourceException Si paramRequest arroja una excepción de este tipo
     * @throws IOException Si request o response arroja una excepción de este tipo
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setCallMethod(url.Call_DIRECT).setMode("dpy");
        PrintWriter out = response.getWriter();

        User user  = paramRequest.getUser();
        String userName = isValidValue(user.getFullName())?user.getFullName():(user.getLogin()==null?"Invitado":user.getLogin());
        if(userName.length()>16)
            userName = userName.substring(0, 17)+"...";
        userName = SWBUtils.TEXT.replaceSpecialCharacters(userName, false);

        String commId = getCommId(paramRequest.getWebPage());
        if (null==commId)
            commId = paramRequest.getWebPage().getId();

        out.println("<div class=\"ms-chat\">");
        out.println("  <applet code=\"class_AppletChat.class\"  codebase=\"/swbadmin\" archive=\"appletChat.jar\" width=\"699\" height=\"391\" id=\"chat1\">");
        out.println("    <param name=\"anchoApp\" value=\"614\"/>");
        out.println("    <param name=\"altoApp\" value=\"350\"/>");
        out.println("    <param name=\"puerto\" value=\"9494\"/>");
        out.println("    <param name=\"idUsuario\" value=\"" + userName + "\"/>");
        out.println("    <param name=\"idComunidad\" value=\"" + commId + "\"/>");
        out.println("    <param name=\"header\" value=\"Tienes una entrevista con Margarita Suárez Arriga, Grupo Bimbo\"/>");
        out.println("    <param name=\"formato\" value=\"0-Dialog-ORANGE-12\"/>");
//        out.println("    <param name=\"bg\" value=\"http://192.168.4.228:9020/work/models/empleo/images/chat_fondo_interfaz_small.jpg\"/>");
//        out.println("    <param name=\"photo\" value=\"http://192.168.4.228:9020/work/models/empleo/images/foto.jpg\"/>");
        out.println("    <param name=\"bg\" value=\"http://localhost:8088/work/models/A/images/chat_fondo_interfaz_small.jpg\"/>");
        out.println("    <param name=\"photo\" value=\"http://localhost:8088/work/models/A/images/foto.jpg\"/>");
        out.println("  </applet>");
        out.println("</div>");
    }

    /**
     * Devuelve el canal de comunicación de las sesiones de chat.
     * @param current - La WebPage que contiene al recurso del chat
     * @return El canal de comunicación para las sesiones de chat.
     */
    private String getCommId(WebPage current) {
        String ret = null;
//        if (current instanceof MicroSite) {
//            ret = current.getId();
//        }else if (current instanceof MicroSiteWebPageUtil) {
//            ret = getCommId(((MicroSiteWebPageUtil) current).getMicroSite());
//        }else {
//            ret = current.getWebSiteId();
//        }
        return ret;
    }

    /**
     * Utilería para determinar si un valor es nulo o cadena vacia.
     * @param param - El valor a determinar por nulo o blanco
     * @return true si y sólo si param no es nulo y no es cadena vacia. De lo contrario, false.
     */
    private boolean isValidValue(String param) {
        boolean validValue = false;
        if( param!=null && param.trim().length()>0 )
            validValue = true;
        return validValue;
    }
}



