/**  
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
**/ 
 

package org.semanticwb.portal.resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

// TODO: Auto-generated Javadoc
/**
 * IFrameContent se encarga de desplegar y administrar un contenido de tipo remoto en un frame independiente
 * bajo ciertos criterios (configuraci�n de recurso).
 *
 * IFrameContent is in charge to unfold and to administer a content of remote type in
 * independent frame under certain criteria (resource configuration). 
 *
 * @author : Vanessa Arredondo Nunez
 * @version 1.0
 */

public class IFrameContent extends GenericAdmResource 
{
    
    /** The log. */
    private static Logger log = SWBUtils.getLogger(IFrameContent.class);
    
    /**
     * Creates a new instance of IFrameContent.
     */
    public IFrameContent() {
    }

    /**
     * Do view.
     * 
     * @param request the request
     * @param response the response
     * @param paramRequest the param request
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SWBResourceException the sWB resource exception
     */    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();

        if (paramRequest.getCallMethod()==paramRequest.Call_CONTENT) {
            String width = paramRequest.getArgument("width", base.getAttribute("width"));
            try {
                Integer.parseInt( width.replaceAll("\\D", "") );
            }catch(Exception e) {
                width = null;
            }
            String height = paramRequest.getArgument("height", base.getAttribute("height"));
            try {
                Integer.parseInt( height.replaceAll("\\D", "") );
            }catch(Exception e) {
                height = null;
            }

            String userAgent = request.getHeader("User-Agent")==null?null:request.getHeader("User-Agent").toLowerCase();
            if( userAgent!=null && (userAgent.indexOf("msie 5")>=0 || userAgent.indexOf("msie 6")>=0 || userAgent.indexOf("msie 7")>=0) ) {
                out.print("<iframe ");
                out.print(" src=\""+base.getAttribute("url")+"\" ");
                if(width!=null)
                    out.print(" width=\""+width+"\"");
                if(height!=null)
                    out.print(" height=\""+height+"\"");
                out.println(" class=\"swb-ifc\">");
                out.println("</iframe>");
            }else {
                out.print("<object type=\"text/html\"");
                if( userAgent!=null && userAgent.indexOf("msie")>=0 )
                    out.print(" classid=\"clsid:25336920-03F9-11CF-8FD0-00AA00686F13\"");
                out.print(" data=\""+base.getAttribute("url")+"\"");
                if(width!=null)
                    out.print(" width=\""+width+"\"");
                if(height!=null)
                    out.print(" height=\""+height+"\"");
                out.println(" class=\"swb-ifc\">");
                out.print("<iframe ");
                out.print(" src=\""+base.getAttribute("url")+"\" ");
                if(width!=null)
                    out.print(" width=\""+width+"\"");
                if(height!=null)
                    out.print(" height=\""+height+"\"");
                out.println(" class=\"swb-ifc\">");
                out.println("</iframe>");
                out.println("</object>");
            }
        }else {
            URL page = new URL(base.getAttribute("url").trim());
            URLConnection conn = page.openConnection();
            InputStream in = conn.getInputStream();
            out.print(SWBUtils.IO.readInputStream(in));
        }
       out.flush();
       out.close();
    }
}