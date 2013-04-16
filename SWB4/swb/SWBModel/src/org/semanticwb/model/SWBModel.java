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
package org.semanticwb.model;

// TODO: Auto-generated Javadoc

import java.util.Iterator;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticModel;

/**
 * The Class SWBModel.
 */
public class SWBModel extends org.semanticwb.model.base.SWBModelBase {
    
    /**
     * Instantiates a new sWB model.
     * 
     * @param base the base
     */
    public SWBModel(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    public SemanticModel getSemanticModel()
    {
        return getSemanticObject().getModel();
    }

    public Iterator<GenericObject> listInstancesOfClass(SemanticClass cls)
    {
        return new GenericIterator(getSemanticModel().listInstancesOfClass(cls));
    }

    public void begin()
    {
        SemanticModel model=getSemanticModel();
        model.begin();
    }

    public void commit()
    {
        SemanticModel model=getSemanticModel();
        model.commit();
    }

    public void abort()
    {
        SemanticModel model=getSemanticModel();
        model.abort();
    }

    @Override
    public WebSite getParentWebSite() 
    {
        Iterator<WebSite> it=SWBContext.listWebSites();
        while (it.hasNext()) 
        {
            WebSite ws = it.next();
            if(ws.hasSubModel(this))
            {
                return ws;
            }
        }        
        return null;
    }
    
    public String getModelProperty(String id)
    {
        Iterator<ModelProperty> it=listModelProperties();
        while (it.hasNext())
        {
            ModelProperty modelProperty = it.next();
            if(modelProperty.getId().equals(id))return modelProperty.getValue();
        }
        return null;
    }

}
