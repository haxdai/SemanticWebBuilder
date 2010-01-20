/*
 * INFOTEC WebBuilder es una herramienta para el desarrollo de portales de conocimiento, colaboraci�n e integraci�n para Internet,
 * la cual, es una creaci�n original del Fondo de Informaci�n y Documentaci�n para la Industria INFOTEC, misma que se encuentra
 * debidamente registrada ante el Registro P�blico del Derecho de Autor de los Estados Unidos Mexicanos con el
 * No. 03-2002-052312015400-14, para la versi�n 1; No. 03-2003-012112473900 para la versi�n 2, y No. 03-2006-012012004000-01
 * para la versi�n 3, respectivamente.
 *
 * INFOTEC pone a su disposici�n la herramienta INFOTEC WebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
 * en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
 * aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
 * todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
 * de INFOTEC WebBuilder 3.2.
 *
 * INFOTEC no otorga garant�a sobre INFOTEC WebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
 * siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
 * de la misma.
 *
 * Si usted tiene cualquier duda o comentario sobre INFOTEC WebBuilder, INFOTEC pone a su disposici�n la siguiente
 * direcci�n electr�nica:
 *
 *                                          http://www.webbuilder.org.mx
 */


/*
 * TMUtil.java
 *
 * Created on 26 de agosto de 2005, 04:39 PM
 */

package com.infotec.topicmaps.util;

import com.infotec.topicmaps.Occurrence;
import com.infotec.topicmaps.Topic;
import com.infotec.topicmaps.TopicMap;
import com.infotec.topicmaps.bean.TopicMgr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class TMUtil
{
    
    /** Creates a new instance of TMUtil */
    public TMUtil()
    {
    }
    
    /*
     * Regresa HashMap con la informacion almacenada en el resourceData de todas las
     * ocurrencias del topicmap.
     *  ket del hashmap = resourceData
     *  value del hashmap Objeto Topic
     *
     */
    public static Map getOccurrenceDataOfType(String topicmapid, String type)
    {
        HashMap map=new HashMap();
        TopicMap tm=TopicMgr.getInstance().getTopicMap(topicmapid);
        Iterator it=new ArrayList(tm.getTopics().values()).iterator();
        while(it.hasNext())
        {
            Topic tp=(Topic)it.next();
            Iterator occs=tp.getOccurrencesOfType(type);
            while(occs.hasNext())
            {
                Occurrence occ=(Occurrence)occs.next();
                if(!occ.isResourceRef())
                {
                    map.put(occ.getResourceData(), tp);
                }
            }
        }
        return map;
    }
    
}
