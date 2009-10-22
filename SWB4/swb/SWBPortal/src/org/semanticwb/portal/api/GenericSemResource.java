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

package org.semanticwb.portal.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.SWBFormMgr;

/**
 *
 * @author javier.solis
 */
public class GenericSemResource extends GenericResource implements org.semanticwb.model.GenericObject
{
    private static Logger log=SWBUtils.getLogger(GenericSemResource.class);

    private SemanticObject m_obj=null;

    public GenericSemResource(SemanticObject obj)
    {
        this.m_obj=obj;
        try
        {
            Iterator<SemanticObject> it=obj.getModel().listSubjects(Resource.ClassMgr.swb_resourceData, obj);
            while(it.hasNext())
            {
                setResourceBase((Resource)it.next().createGenericInstance());
                break;
            }
        }catch(Exception e){log.error(e);}
    }

    public GenericSemResource()
    {
    }

    public SemanticClass getSemanticClass()
    {
        SemanticClass cls=null;
        if(m_obj==null)
        {
            String clsname=getClass().getName();
            cls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClassByJavaName(clsname);
        }else
        {
            cls=getSemanticObject().getSemanticClass();
        }
        return cls;
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out=response.getWriter();
        out.println("<div id=\""+getSemanticObject().getURI()+"/admform\" dojoType=\"dijit.layout.ContentPane\">");
        SWBFormMgr mgr=new SWBFormMgr(getSemanticObject(), null, SWBFormMgr.MODE_EDIT);
        mgr.setSubmitByAjax(true);
        mgr.addButton(SWBFormButton.newSaveButton());
        mgr.setType(SWBFormMgr.TYPE_DOJO);
        if("update".equals(paramRequest.getAction()))
        {
            try
            {
                mgr.processForm(request);
            }catch(FormValidateException e){log.error(e);}
            response.sendRedirect(paramRequest.getRenderUrl().setAction(null).toString());
        }else
        {
            mgr.setAction(paramRequest.getRenderUrl().setAction("update").toString());
            out.print(mgr.renderForm(request));
        }
        out.println("</div>");
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        //TO Override
    }

    public String getURI() {
        return getSemanticObject().getURI();
    }

    public String getId() {
        return getSemanticObject().getId();
    }

    public SemanticObject getSemanticObject()
    {
        if(m_obj==null)
        {
            Resource res=getResourceBase();
            if(res!=null)
            {
                m_obj=res.getResourceData();
                if(m_obj==null)
                {
                    SemanticModel model=getResourceBase().getSemanticObject().getModel();
                    SemanticClass cls=getSemanticClass();
                    if(cls!=null)
                    {
                        m_obj=model.createSemanticObjectById(getResourceBase().getId(), cls);
                        getResourceBase().setResourceData(m_obj);
                    }else
                    {
                        log.error(new SWBResourceException("Class Name:"+getClass()+" not found..."));
                    }
                }
            }
        }
        return m_obj;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public GenericObject setProperty(String prop, String value)
    {
        getSemanticObject().setProperty(_getProperty(prop), value);
        return this;
    }

    public GenericObject removeProperty(String prop)
    {
        getSemanticObject().removeProperty(_getProperty(prop));
        return this;
    }

    public String getProperty(String prop)
    {
        return  getProperty(prop, null);
    }

    public String getProperty(String prop, String defValue)
    {
        return getSemanticObject().getProperty(_getProperty(prop), defValue);
    }

    private SemanticProperty _getProperty(String prop)
    {
        return new SemanticProperty(getSemanticObject().getModel().getRDFModel().createProperty(m_obj.getModel().getNameSpace()+"prop_"+prop));
    }

     /**
     * Regresa ruta de trabajo del objeto relativa al directorio work
     * ejemplo: /sep/Template/1
     *          /dominio/Objeto/id
     *
     * @return String con la ruta relativa al directorio work
     */
    public String getWorkPath() {
        return getResourceBase().getWorkPath();
    }

    public void dispose() {
        
    }

}
