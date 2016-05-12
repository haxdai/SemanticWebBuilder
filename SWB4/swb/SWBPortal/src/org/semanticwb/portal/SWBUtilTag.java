/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal;

import java.util.HashMap;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;

/**
 *
 * @author javiersolis
 */
public class SWBUtilTag 
{
    
    /**
     * Attributes:
     *   name: nombre de la propiedad
     *   default: valor por defecto
     * @param map
     * @return 
     */
    public String getEnv(HashMap<String,String> map)
    {
        String name=map.get("name");
        String def=map.get("default");
        String ret=SWBPlatform.getEnv(name,def);
        return ret;
    }
    
}
