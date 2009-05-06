/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.platform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author javier.solis
 */
public class SWBObjectFilter
{
    public static Iterator<SemanticObject> filter(Iterator<SemanticObject>objects, String filter)
    {
        if(filter!=null)
        {
            ArrayList<SemanticObject> arr=new ArrayList();
            while(objects.hasNext())
            {
                SemanticObject obj=objects.next();
                if(filter(obj, filter))arr.add(obj);
            }
            return arr.iterator();
        }else
        {
            return objects;
        }
    }


    /**
     *
     * @param obj SemanticObject a filtrar
     * @param filter String con filtro
     * @return boolean si clumple o no con el filtro
     */
    public static boolean filter(SemanticObject obj, String filter)
    {
        if(filter==null)return true;
        boolean ret=false;
        StringTokenizer st=new StringTokenizer(filter,",;|&");
        while(st.hasMoreTokens())
        {
            String txt=st.nextToken();
            //System.out.println("txt:"+txt);
            StringTokenizer st2=new StringTokenizer(txt,"=><!");
            while(st2.hasMoreTokens())
            {
                String key=st2.nextToken();
                //System.out.println("key:"+key);
                if(st2.hasMoreTokens())
                {
                    String value=st2.nextToken();
                    String sep=txt.substring(key.length(),txt.length()-value.length());
                    //System.out.println("sep:"+sep);
                    //System.out.println("value:"+value);
                    SemanticClass cls=obj.getSemanticClass();
                    if(cls.hasProperty(key))
                    {
                        String val=obj.getProperty(cls.getProperty(key));
                        if((sep.equals("=") || sep.equals("==")) && value.equals(val))
                        {
                            ret=true;
                        }
                        if((sep.equals("!=") || sep.equals("<>")) && !value.equals(val))
                        {
                            ret=true;
                        }
                        //System.out.println("val:"+val+" "+"sep:"+sep+" value:"+value);
                    }
                }
            }
        }
        return ret;
    }


}
