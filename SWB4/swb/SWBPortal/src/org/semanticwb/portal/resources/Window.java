/*
 * SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
 * colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
 * información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
 * fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
 * procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
 * para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
 *
 * INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
 * en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
 * aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
 * del SemanticWebBuilder 4.0.
 *
 * INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
 * siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
 * dirección electrónica:
 *  http://www.semanticwebbuilder.org
 */
package org.semanticwb.portal.resources;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.api.SWBResourceURLImp;


// TODO: Auto-generated Javadoc
/** Despliega y administra una ventana de tipo pop-up bajo ciertos
 * criterios de configuraci&oacute;n.
 *
 * Displays and manages a pop-up window under some configuration criteria.
 * @author : Jorge Alberto Jim&eacute;nez Sandoval
 * @since : 2.0
 */
public class Window extends GenericAdmResource {
    

    /**
     * contiene la ruta f&iacute;sica de la carpeta de trabajo para este recurso
     * <p>contains this resource's phisical work directory path.</p>
     */
    String workPath = "";

    /**
     * contiene la ruta en Web de la carpeta de trabajo para este recurso
     * <p>contains this resource's Web work directory path.</p>
     */
    String webWorkPath = "/work";

    /**
     * objeto encargado de crear mensajes en los archivos log de SemanticWebBuilder (SWB).
     * <p>object that creates messages in SWB's log file.</p>
     */
    private static Logger log = SWBUtils.getLogger(Window.class);
    
    /**
     * Crea una nueva instancia de esta clase.
     */
    public Window() {
    }

    /**
     * <p>Inicializa este recurso configurando los valores de {@code workPath} y {@code webWorkPath}
     * de acuerdo con la instalaci&oacute;n de SemanticWebBuilder
     * <p>Initializes this resource confiugring the values of {@code workPath} and {@code webWorkPath}
     * accordingly to SemanticWebBuilder instalation.</p>
     * @param base el objeto base para la configuraci&oacute;n de este recurso
     *             <p>the base object for this resource's configuration</p>
     */
    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
            workPath = SWBPortal.getWorkPath() + base.getWorkPath();
            webWorkPath = SWBPortal.getWebWorkPath() + base.getWorkPath();
        } catch (Exception e) {
            log.error("Error while setting resource base: " + base.getId() 
                    + "-" + base.getTitle(), e);
        }
    }

    /**
     * Genera el c&oacute;digo HTML para abrir una ventana, de acuerdo a la
     * configuraci&oacute;n seleccionada en la administraci&oacute;n del recurso.
     * <p>Generates the HTML code needed to open a browser window, according to
     * the configuration selected in this resource's administration view</p>
     * @param request la petici&oacute;n HTTP generada por el usuario. <p>the user's HTTP request</p>
     * @param response la respuesta hacia el usuario.<p>the response to the user</p>
     * @param reqParams el objeto generado por SWB y asociado a la petici&oacute;n
     *        del usuario.<p>the object generated by SWB and asociated to the user's request</p>
     * @throws SWBResourceException si la llamada al m&eacute;todo {@code showWindow}
     *         o la obtenci&oacute;n del <code>Writer</code> del <code>response</code>
     *         correspondiente la propagan.
     *         <p>if it is propagated by calling method {@code showWindow}
     *         or getting the corresponding <code>response</code>'s <code>Writer</code>.</p>
     * @throws IOException si la llamada al m&eacute;todo {@code showWindow} la propaga.
     *         <p>if it is propagated by the call to method {@code showWindow}.</p>
     */
    @Override
    public void doView(HttpServletRequest request,
                       HttpServletResponse response,
                       SWBParamRequest reqParams)
                       throws SWBResourceException, java.io.IOException {
        
        String action = (null != request.getParameter("ven_act") 
                         && !"".equals(request.getParameter("ven_act").trim()))
                         ? request.getParameter("ven_act").trim() 
                         : "ven_step1";
        if ("ven_step2".equals(action)) {
            showWindow(request, response, reqParams); // Nueva ventana pop-up
        } else { // Se invoca la nueva ventana
            Resource base = getResourceBase();
            if ("yes".equals(base.getAttribute("bysession", ""))) {
                if (request.getSession().getAttribute("wbwindow") != null 
                        && String.valueOf(base.getId() + "_" 
                        + base.getWebSiteId()).equals(request.getSession(
                        ).getAttribute("wbwindow"))) {
                    return;
                } else {
                    request.getSession().setAttribute("wbwindow", 
                            base.getId() + "_" + base.getWebSiteId());
                }
            }
            StringBuilder props = new StringBuilder(250);
            props.append("menubar=");
            props.append(base.getAttribute("menubar", "no").trim());
            props.append(",toolbar=");
            props.append(base.getAttribute("toolbar", "no").trim());
            props.append(",status=");
            props.append(base.getAttribute("status", "no").trim());
            props.append(",location=");
            props.append(base.getAttribute("location", "no").trim());
            props.append(",directories=");
            props.append(base.getAttribute("directories", "no").trim());
            props.append(",scrollbars=");
            props.append(base.getAttribute("scrollbars", "no").trim());
            props.append(",resizable=");
            props.append(base.getAttribute("resizable", "no").trim());
            props.append(",width=");
            props.append(base.getAttribute("width", "300").trim());
            props.append(",height=");
            props.append(base.getAttribute("height", "200").trim());
            props.append(",top=");
            props.append(base.getAttribute("top", "10").trim());
            props.append(",left=");
            props.append(base.getAttribute("left", "10").trim());
            
            SWBResourceURLImp url = new SWBResourceURLImp(request, base,
                    reqParams.getWebPage(), SWBResourceURL.UrlType_RENDER);
            url.setResourceBase(base);
            url.setMode(SWBResourceURL.Mode_VIEW);
            url.setWindowState(SWBResourceURL.WinState_MAXIMIZED);
            url.setParameter("ven_act", "ven_step2");
            url.setTopic(reqParams.getWebPage());
            url.setCallMethod(reqParams.Call_DIRECT);
            //response.sendRedirect(url.toString());
            String ret = null;
            ret = "<script type=\"text/javascript\">window.open('" 
                    + url.toString() + "','_newven','" + props + "');</script>";
            
            PrintWriter out = response.getWriter();
            if (ret != null) {
                out.println(ret);
            }
        }
    }

    /**
     * Crea el c&oacute;digo del documento HTML a mostrar en la ventana indicada,
     * seg&uacute;n la configuraci&oacute;n seleccionada en la administraci&oacute;n
     * de este recurso.
     * <p>Creates the HTML code needed to show a browser window with the
     * characteristics indicated in this resource's adminitration view.</p>
     * 
     * @param request la petici&oacute;n HTTP generada por el usuario. <p>the user's HTTP request</p>
     * @param response la respuesta hacia el usuario.<p>the response to the user</p>
     * @param reqParams el objeto generado por SWB y asociado a la petici&oacute;n
     * del usuario.<p>the object generated by SWB and asociated to the user's request</p>
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException al obtener el <code>Writer</code> del <code>response</code>
     * correspondiente. <p>when getting the corresponding <code>response</code>'s
     * <code>Writer</code>.</p>
     */    
    public void showWindow(HttpServletRequest request, 
                           HttpServletResponse response, 
                           SWBParamRequest reqParams)
                           throws SWBResourceException, java.io.IOException {
        
        StringBuffer ret = new StringBuffer("");
        Resource base = getResourceBase();
        
        ret.append("<html> \n");
        ret.append("<head> \n");
        if (!"".equals(base.getAttribute("title", "").trim())) {
            ret.append("<title>" + base.getAttribute("title").trim() + "</title>");
        }
        ret.append("</head> \n");
        ret.append("<body leftmargin=0 topmargin=0 marginwidth=0 marginheight=0");
        if (!"".equals(base.getAttribute("textcolor", "").trim())) {
            ret.append(" text=\"" + base.getAttribute("textcolor").trim() + "\"");
        }
        if (!"".equals(base.getAttribute("backimg", "").trim())) {
            ret.append(" background=\"" + webWorkPath +"/");
            ret.append(base.getAttribute("backimg").trim() + "\"");
        }
        if (!"".equals(base.getAttribute("backcolor", "").trim())) {
            ret.append(" bgcolor=\"" + base.getAttribute("backcolor").trim() + "\"");
        }
        ret.append("> \n");
        ret.append("<center> \n");
        if (!"".equals(base.getAttribute("title", "").trim())) {
            ret.append(base.getAttribute("title"));
            ret.append("<br><br>");
        }
        
        SWBResourceURL wburl = reqParams.getActionUrl();
        String url = base.getAttribute("url", "").trim();
        if (!"".equals(url)) {
            /*
                 0 - en la misma ventana
                 1 - en el window.opener y cerrar ventana
                 2 - en el window.opener y sin cerrar ventana
                 3 - nueva ventana y cerrar la anterior
                 4 - nueva ventana y sin cerrar la anterior (default)
            */
            String target = base.getAttribute("target", "4").trim();
            if ("0".equals(target)) {
                ret.append("<a  href=\"" + wburl.toString() + "\"> \n");
            } else if ("1".equals(target) || "2".equals(target)) {
                ret.append("<script language=\"JavaScript\"> \n");
                ret.append("function redirect(url) \n");
                ret.append("{ \n");
                ret.append("    window.opener.location=url; \n");
                if ("1".equals(target)) ret.append("    window.close(); \n");
                ret.append("} \n");
                ret.append("</script> \n");
                ret.append("<a href=\"javascript:redirect('" + wburl.toString());
                ret.append("');\"> \n");
            } else if ("3".equals(target) || "4".equals(target)) {
                ret.append("<a href=\"#\" onClick=\"javascript:window.open('");
                ret.append(wburl.toString() + "', '_newven2');");
                if ("3".equals(target)) {
                    ret.append(" window.close();");
                }
                ret.append("\"> \n");
            }
        }

        String img = base.getAttribute("img", "").trim();
        
        if (!"".equals(img)) {
            if (img.endsWith(".swf")) {
                ret.append("<object classid=\"clsid:D27CDB6E-AE6D-11cf-96B8-444553540000\" codebase=\"http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,0,0\"> \n");
                ret.append("<param name=movie value=\"" + webWorkPath + "/"
                        + img + "\" />\n");
                ret.append("<param name=\"quality\" value=\"high\" />\n");
                if (!"".equals(url)) {
                    ret.append("<param name=\"FlashVars\" value=\"liga="
                            + wburl.toString() +"\" /> \n");
                }
                ret.append("<embed id=\"" + img + "\" name=\"" + img
                        + "\" src=\"" + webWorkPath + "/" + img);
                ret.append("\" quality=\"high\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" type=\"application/x-shockwave-flash\">");
                ret.append("</embed>\n");
                ret.append("</object>\n");
            } else {
                ret.append("<img ");
                if (!"".equals(base.getAttribute("alt", "").trim())) {
                    ret.append(" alt=\""+base.getAttribute("alt").trim()+"\"");
                }
                ret.append(" src=\"" + webWorkPath + "/" + img + "\" border=0>");
            }
        }
        if (!"".equals(base.getAttribute("text", "").trim())) {
            ret.append(base.getAttribute("text"));
        }
        if (!"".equals(url)) {
            ret.append("</a> \n");
        }
        ret.append("</center> \n");
        ret.append("</body> \n");
        ret.append("</html> \n");
        response.getWriter().print(ret.toString());
    }    


    /**
     * Registra el hit realizado en el contenido de este recurso, cuando se
     * realiza un clic en la liga mostrada por el texto o imagen desplegados para
     * posteriormente redirigir el flujo al destino de la liga.
     * <p>Registers the hit executed by the user on this resource's content, when
     * clicking the link showed to open the window.</p>
     * 
     * @param request la petici&oacute;n HTTP generada por el usuario. <p>the
     * user's HTTP request</p>
     * @param response la respuesta a la acci&oacute;n solicitada por el usuario
     * <p>the response to the action requested by the user.</p>
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */    
    @Override
    public void processAction(HttpServletRequest request,
                              SWBActionResponse response) 
                              throws SWBResourceException, java.io.IOException {
        Resource base = getResourceBase();
        
        base.addHit(request, response.getUser(), response.getWebPage());
        String url = base.getAttribute("url", "").trim();
        if (!url.equals("")) {
            response.sendRedirect(url);
        }
    }
}
