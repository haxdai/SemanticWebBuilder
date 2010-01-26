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
 * ObjectEncoder.java
 *
 * Created on 11 de diciembre de 2004, 07:32 PM
 */

package com.infotec.appfw.util.db;

import java.util.*;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class ObjectEncoder
{
    private String name=null;
    private ArrayList list=new ArrayList();
    
    /** Creates a new instance of ObjectEncoder */
    public ObjectEncoder(String name)
    {
        this.name=name;
    }
    
    public void addInt(int val)
    {
        list.add(""+val);
    }
    
    public void addString(String val)
    {
        list.add(replaceStringChars(val));
    }
    
    public void addLong(long val)
    {
        list.add(""+val);
    }
    
    public void addTimestamp(java.sql.Timestamp ts)
    {
        if(ts==null)list.add("_NULL_"); 
        else list.add(""+ts);
    }
/*    
    public void addObject(Object obj)
    {
        list.add(""+obj);
    }
*/    
    public String replaceStringChars(String str)
    {
        if(str==null)return "_NULL_"; 
        StringBuffer ret=new StringBuffer();
        for(int x=0;x<str.length();x++)
        {
            char ch=str.charAt(x);
            switch(ch)
            {
                case '"':
                    ret.append("\\\"");
                    break;
                case '\r':
                    ret.append("\\r");
                    break;
                case '\n':
                    ret.append("\\n");
                    break;
                default:
                    ret.append(ch);
                    break;
            }
            
        }
        return ret.toString();
    }
    
    public String toString()
    {
        StringBuffer ret=new StringBuffer();
        ret.append(name+"(");
        Iterator it=list.iterator();
        while(it.hasNext())
        {
            ret.append("\""+it.next()+"\"");
            if(it.hasNext())ret.append(",");
        }
        ret.append(");");
        return ret.toString();
    }
    
}
