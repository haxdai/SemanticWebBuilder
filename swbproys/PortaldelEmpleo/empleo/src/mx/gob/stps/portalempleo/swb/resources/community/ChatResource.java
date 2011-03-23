package mx.gob.stps.portalempleo.swb.resources.community;

import mx.gob.stps.portalempleo.swb.resources.community.base.ChatResourceBase;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.*;

import org.semanticwb.model.User;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.community.MicroSite;
import org.semanticwb.portal.community.MicroSiteWebPageUtil;

public class ChatResource extends ChatResourceBase
{

    public ChatResource()
    {
    }

    public ChatResource(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        if(paramsRequest.getMode().equalsIgnoreCase("dpy")) {
            doDisplay(request,response,paramsRequest);
        }else {
            super.processRequest(request, response, paramsRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setCallMethod(url.Call_DIRECT).setMode("dpy");
        PrintWriter out = response.getWriter();

        User user  = paramRequest.getUser();
        String userName = isValidValue(user.getFirstName())&&isValidValue(user.getLastName())?user.getFirstName()+" "+user.getLastName():(user.getLogin()==null?"Invitado":user.getLogin());
        userName = encode(userName);
        String commId = getCommId(paramRequest.getWebPage());
        if (null==commId)
            commId = paramRequest.getWebPage().getId();
        out.println("<div class=\"ms-chat\">");
        out.println("  <applet code=\"class_AppletChat.class\"  codebase=\"/swbadmin\" archive=\"appletChat.jar\" width=\"520\" height=\"320\" id=\"chat1\">");
        out.println("    <param name=\"anchoApp\" value=\"508\"/>");
        out.println("    <param name=\"altoApp\" value=\"270\"/>");
        out.println("    <param name=\"puerto\" value=\"9494\"/>");
        out.println("    <param name=\"moderador\" value=\"1\"/>");
        out.println("    <param name=\"locale\" value=\"es\"/>");
        out.println("    <param name=\"idUsuario\" value=\"" + userName + "\"/>");
        out.println("    <param name=\"idComunidad\" value=\"" + commId + "\"/>");
        out.println("  </applet>");
        out.println("</div>");
//        out.println("<script type=\"text/javascript\">");
//        out.println("  dojo.addOnLoad(");
//        out.println("    function() {");
//        out.println("      window.open('"+url+"','MS','status=0,toolbar=0,location=0,menubar=0,directories=0,resizable=0,scrollbars=0,width=550,height=340');");
//        out.println("    }");
//        out.println("  );");
//        out.println("</script>");
    }

    public void doDisplay(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        User user  = paramRequest.getUser();

        String userName = isValidValue(user.getFirstName())&&isValidValue(user.getLastName())?user.getFirstName()+" "+user.getLastName():(user.getLogin()==null?"Invitado":user.getLogin());
        userName = encode(userName);

        String commId = getCommId(paramRequest.getWebPage());
        if (null==commId)
            commId = paramRequest.getWebPage().getId();
        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        out.println("<head>");
        out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"/>");
        out.println("<title>MS</title>");
        out.println("<style type=\"text/css\">");
        out.println("<!--");
        out.println("body {background-color:#1F3D5A;}");
        out.println(".ms-chat {");
        out.println("  background-color: #1F3D5A;");
        out.println("}");
        out.println("-->");
        out.println("</style>");
        out.println("</head>");
        out.println(" <body>");
        out.println("<div class=\"ms-chat\">");
        out.println("  <applet code=\"class_AppletChat.class\"  codebase=\"/swbadmin\" archive=\"appletChat.jar\" width=\"520\" height=\"320\" id=\"chat1\">");
        out.println("    <param name=\"anchoApp\" value=\"508\"/>");
        out.println("    <param name=\"altoApp\" value=\"270\"/>");
        out.println("    <param name=\"puerto\" value=\"9494\"/>");
        out.println("    <param name=\"moderador\" value=\"1\"/>");
        out.println("    <param name=\"locale\" value=\"es\"/>");
        out.println("    <param name=\"idUsuario\" value=\"" + userName + "\"/>");
        out.println("    <param name=\"idComunidad\" value=\"" + commId + "\"/>");
        out.println("  </applet>");
        out.println("</div>");
        out.println(" </body>");
        out.println("</html>");
    }

    private String getCommId(WebPage current)
    {
        String ret = null;
        if (current instanceof MicroSite)
        {
            ret = current.getId();
        } else if (current instanceof MicroSiteWebPageUtil)
        {
            ret = getCommId(((MicroSiteWebPageUtil) current).getMicroSite());
        }
        return ret;

    }

    private boolean isValidValue(String param) {
        boolean validValue = false;
        if( param!=null && param.trim().length()>0 )
            validValue = true;
        return validValue;
    }

    private String encode(String value) {
        if(value==null)
            return null;
        value = value.replace ('á','a');
        value = value.replace ('é','e');
        value = value.replace ('í','i');
        value = value.replace ('ó','o');
        value = value.replace ('ú','u');
        value = value.replace ('ñ','n');
        return value;
    }
}



