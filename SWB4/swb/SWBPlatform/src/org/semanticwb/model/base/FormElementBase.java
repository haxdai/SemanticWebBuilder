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

package org.semanticwb.model.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.FormElement;
import org.semanticwb.model.FormElementURL;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.GenericObject;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;

/**
 *
 * @author Jei
 */
public class FormElementBase extends GenericObjectBase implements FormElement, GenericObject
{
    private static Logger log = SWBUtils.getLogger(FormElementBase.class);

    protected HashMap attributes=null;
    private SemanticModel model=null;

    public FormElementBase(SemanticObject obj)
    {
        super(obj);
        attributes=new HashMap();
    }

    public void validate(HttpServletRequest request, SemanticObject obj, SemanticProperty prop) throws FormValidateException
    {

    }

    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop)
    {
        String smode=request.getParameter("smode");
        //System.out.println("process...:"+obj.getURI()+" "+prop.getURI()+" "+smode);
        //if(smode!=null && smode.equals("create") && !prop.isRequired())return;
        if(prop.getDisplayProperty()==null)return;
        if(prop.isDataTypeProperty())
        {
            String value=request.getParameter(prop.getName());
            String old=obj.getProperty(prop);
            //System.out.println("com:"+old+"-"+value+"-");
            if(prop.isBoolean())
            {
                //System.out.println("prop:"+prop);
                //System.out.println("value:"+value);
                //System.out.println("old:"+old);
                if(value!=null && (value.equals("true") || value.equals("on")) && (old==null || old.equals("false")))obj.setBooleanProperty(prop, true);
                else if((value==null || value.equals("false")) && old!=null && old.equals("true")) obj.setBooleanProperty(prop, false);
            }else
            {
                if(value!=null)
                {
                    if(value.length()>0 && !value.equals(old))
                    {
                        //System.out.println("old:"+old+" value:"+value);
//                        for(int x=0;x<value.length();x++)
//                        {
//                            System.out.print((int)value.charAt(x)+" ");
//                        }
                        if(prop.isFloat())obj.setFloatProperty(prop, Float.parseFloat(value));
                        if(prop.isDouble())obj.setDoubleProperty(prop, Double.parseDouble(value));
                        if(prop.isInt() || prop.isShort() || prop.isByte())obj.setIntProperty(prop, Integer.parseInt(value));
                        if(prop.isLong())obj.setLongProperty(prop, Long.parseLong(value));
                        if(prop.isDate())obj.setDateProperty(prop, new java.util.Date(value));
                        if(prop.isString())obj.setProperty(prop, value);
                    }else if(value.length()==0 && old!=null)
                    {
                        obj.removeProperty(prop);
                    }
                }
            }
        }else if(prop.isObjectProperty())
        {
            String name=prop.getName();
            String uri=request.getParameter(name);
            if(uri!=null)
            {
                //System.out.println("**** obj:"+obj+" uri:"+uri+" name:"+name);
                if(name.startsWith("has"))
                {
                    //TODO:
                }else
                {
                    String ouri="";
                    SemanticObject old=obj.getObjectProperty(prop);
                    if(old!=null)ouri=old.getURI();
                    //System.out.println("uri:"+uri+" "+ouri);
                    if(!(""+uri).equals(""+ouri))
                    {
                        SemanticObject aux=SWBPlatform.getSemanticMgr().getOntology().getSemanticObject(uri);
                        if(aux!=null)
                        {
                            obj.setObjectProperty(prop, aux);
                        }else
                        {
                            obj.removeProperty(prop);
                        }
                    }
                }
            }
        }
    }

    public String renderLabel(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String type, String mode, String lang)
    {
        String ret="";
        String name=prop.getName();
        String label=prop.getDisplayName(lang);
        SemanticObject sobj=prop.getDisplayProperty();
        boolean required=prop.isRequired();

        String reqtxt=" &nbsp;";
        if(required)reqtxt=" <em>*</em>";

        ret="<label for=\""+name+"\">"+label + reqtxt + "</label>";
        return ret;
    }

    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String type, String mode, String lang)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setAttribute(String name, String value)
    {
        if(value!=null)
        {
            attributes.put(name, value);
        }else
        {
            attributes.remove(name);
        }
    }

    public String getAttributes()
    {
        StringBuffer ret=new StringBuffer();
        Iterator<Entry<String,String>> it=attributes.entrySet().iterator();
        while(it.hasNext())
        {
            Entry entry=it.next();
            ret.append(entry.getKey()+"="+"\""+entry.getValue()+"\"");
            if(it.hasNext())ret.append(" ");
        }
        return ret.toString();
    }

    public FormElementURL getRenderURL(SemanticObject obj, SemanticProperty prop, String type, String mode, String lang)
    {
        return new FormElementURL(this,obj, prop, FormElementURL.URLTYPE_RENDER,type, mode, lang);
    }

    public FormElementURL getValidateURL(SemanticObject obj, SemanticProperty prop)
    {
        return new FormElementURL(this,obj, prop, FormElementURL.URLTYPE_VALIDATE,null, null, null);
    }

    public FormElementURL getProcessURL(SemanticObject obj, SemanticProperty prop)
    {
        return new FormElementURL(this,obj, prop, FormElementURL.URLTYPE_PROCESS,null, null, null);
    }

    public String getLocaleString(String key, String lang)
    {
        String ret=null;
        try
        {
            ret=SWBUtils.TEXT.getLocaleString(this.getClass().getName(), key, new Locale(lang),this.getClass().getClassLoader());
        }catch(Exception e){log.error(e);}
        return ret;
    }

    /**
     * @return the model
     */
    public SemanticModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(SemanticModel model) {
        this.model = model;
    }


}
