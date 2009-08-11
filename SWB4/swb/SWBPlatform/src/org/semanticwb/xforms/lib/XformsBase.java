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
 * XformsBase.java
 *
 * Created on 1 de julio de 2008, 04:47 PM
 */

package org.semanticwb.xforms.lib;

/**
 *
 * @author  jorge.jimenez
 */
public interface XformsBase {
    
    public void setLable(String label);
    
    public String getLabel();
    
    public void setId(String id);
    
    public String getId();
    
    public void setSubType(String subType);
    
    public String getSubType();
    
    public void setRequired(boolean isrequired);
    
    public boolean isRequired();
    
    public void setXml(String xml);
    
    public String getXml();
    
    public void setXmlBind(String xmlBind);
    
    public String getXmlBind();
    
    public void setHelp(String help);
    
    public String getHelp();
    
    public void setHint(String hint);
    
    public String getHint();
    
  
}
