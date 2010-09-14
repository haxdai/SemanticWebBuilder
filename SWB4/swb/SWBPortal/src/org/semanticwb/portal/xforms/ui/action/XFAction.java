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
 * XFText.java
 *
 * Created on 1 de julio de 2008, 06:58 PM
 */

package org.semanticwb.portal.xforms.ui.action;

import org.semanticwb.xforms.lib.WBXformsContainer;
import java.util.*;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.xforms.ElementsProp;
import org.semanticwb.portal.xforms.ui.XFButton;

// TODO: Auto-generated Javadoc
/**
 * The Class XFAction.
 * 
 * @author  jorge.jimenez
 */
public class XFAction extends WBXformsContainer
{
    
    /** The log. */
    private static Logger log = SWBUtils.getLogger(XFAction.class);
    
    /** The elements prop. */
    protected ElementsProp elementsProp=null;
    
    /** The instance elements. */
    protected HashMap instanceElements=new HashMap();
    
    /**
     * Instantiates a new xF action.
     * 
     * @param elementsProp the elements prop
     */
    public XFAction(ElementsProp elementsProp){
        this.elementsProp=elementsProp;
        setRDFAttributes();
    }
    
    /**
     * Instantiates a new xF action.
     * 
     * @param elementsProp the elements prop
     * @param instanceElements the instance elements
     */
    public XFAction(ElementsProp elementsProp,HashMap instanceElements){
        this.elementsProp=elementsProp;
        this.instanceElements=instanceElements;
        setRDFAttributes();
    }
    
    // Sets
    
       
    // Gets   
   
    
    /**
     * Sets the rdf attributes.
     */
    public void setRDFAttributes(){
        if(elementsProp.getId()!=null) {
            id=elementsProp.getId();
        }
        if(elementsProp.getSType()!=null) {
            subType=elementsProp.getSType();
        }
        
        if(elementsProp.getElements().size()>0) {
            Iterator itElements=elementsProp.getElements().iterator();
            while(itElements.hasNext()) {
                ElementsProp elementsProp=(ElementsProp)itElements.next();
                if(elementsProp.getType()!=null && elementsProp.getType().equalsIgnoreCase("BUTTON")) {
                    XFButton xfButton = new XFButton(elementsProp);
                    this.add(xfButton);
                }else if(elementsProp.getType()!=null && elementsProp.getType().equalsIgnoreCase("TOGGLE")) {
                    XFToggle xfToggle = new XFToggle(elementsProp);
                    this.add(xfToggle);
                }
            }
        }
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.xforms.lib.XformsBaseImp#getXml()
     */
    /**
     * Gets the xml.
     * 
     * @return the xml
     */
    @Override
    public String getXml() 
    {
        StringBuffer strbXml=new StringBuffer();
        try {
            strbXml.append("<action");
            
            if(id!=null){
                strbXml.append(" id=\""+id+"\"");
            }
            
            strbXml.append(">");
            
            strbXml.append(this.show());
            
            strbXml.append("</action>");
        }
        catch(Exception e) {log.error(e); }
        return strbXml.toString();
    }
    
    /* (non-Javadoc)
     * @see org.semanticwb.xforms.lib.XformsBaseImp#setXml(java.lang.String)
     */
    /**
     * Sets the xml.
     * 
     * @param xml the new xml
     */
    @Override
    public void setXml(String xml) {
        this.xml=xml;
    }
}
