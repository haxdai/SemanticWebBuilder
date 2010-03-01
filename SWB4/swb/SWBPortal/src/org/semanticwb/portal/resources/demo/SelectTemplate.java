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
 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.portal.resources.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.ResourceSubType;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.TemplateRef;
import org.semanticwb.portal.SWBResourceMgr;
import org.semanticwb.portal.TemplateImp;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBParamRequestImp;
import org.semanticwb.portal.api.SWBResource;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.lib.SWBResponse;
import org.semanticwb.servlet.internal.DistributorParams;

// TODO: Auto-generated Javadoc
/**
 * The Class SelectTemplate.
 * 
 * @author serch
 */
public class SelectTemplate extends GenericResource{

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#doView(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.semanticwb.portal.api.SWBParamRequest)
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        SWBResourceURL url = paramRequest.getActionUrl().setCallMethod(SWBResourceURL.Call_DIRECT);
        PrintWriter out = response.getWriter();
        out.print("<div style=\"position: relative; float: right; width: 360px; height: 30px; background-color: azure;  }\"><table border=\"0\" valign=\"top\"><tr><td>");
        ResourceType rt=paramRequest.getWebPage().getWebSite().getResourceType("WebPageOnLineCreate");
        TemplateImp tpl=(TemplateImp)SWBPortal.getTemplateMgr().getTemplate(paramRequest.getUser(),paramRequest.getWebPage());
        HashMap<String, String> map = new HashMap<String,String>();
        ResourceSubType pst=tpl.getSubType("WebPageOnLineCreate",null);
        DistributorParams distparams=new DistributorParams(request);
        SWBResourceMgr rm = SWBPortal.getResourceMgr();
        Iterator it =  rm.getResources(rt,pst,paramRequest.getUser(),paramRequest.getWebPage(),map,tpl);
        if(it.hasNext())
                            {
                                SWBResource wbres=(SWBResource)it.next();
                                SWBResponse res=new SWBResponse();
                                SWBParamRequestImp resParams = new SWBParamRequestImp(request,wbres.getResourceBase(),paramRequest.getWebPage(),paramRequest.getUser());
                                javax.servlet.http.HttpServletRequest req=distparams.getInternalRequest(request,wbres.getResourceBase().getId());
                                SWBPortal.getResourceMgr().getResourceTraceMgr().renderTraced(wbres, req, res, resParams);
                                out.print(res.toString());
        }
        out.println("</td><td>|</td><td><form method=\"POST\" action=\""+url+"\" name=\"chgTempForm\" id=\"chgTempForm\">");
        out.println("<label for\"template\">Seleccione Plantilla:</label><select id=\"template\" name=\"template\" onchange=\"var forma=document.getElementById('chgTempForm');forma.submit();\">");
        GenericIterator<TemplateRef> git = paramRequest.getWebPage().listTemplateRefs();
        while (git.hasNext())
        {

            TemplateRef temref= git.next();
            String selected = "";
            if (temref.isActive()) selected = " selected=\"selected\" ";

            out.println("<option value=\""+temref.getId()+"\" "+selected+">"+
                    temref.getTemplate().getDisplayTitle(paramRequest.getUser().getLanguage())+"</option>");
        }
        out.print("</select></form>");
        
        out.println("</td></tr></table></div>");
    }

    /* (non-Javadoc)
     * @see org.semanticwb.portal.api.GenericResource#processAction(javax.servlet.http.HttpServletRequest, org.semanticwb.portal.api.SWBActionResponse)
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        String id = request.getParameter("template");
        if (null!=id)
        {
            GenericIterator<TemplateRef> git = response.getWebPage().listTemplateRefs();
            while (git.hasNext())
            {
                TemplateRef temref= git.next();
                if (temref.isActive()) temref.setActive(false);
                if (temref.getId().equals(id)) temref.setActive(true);
            }
        }
        response.setCallMethod(SWBResourceURL.Call_CONTENT);
    }

}
