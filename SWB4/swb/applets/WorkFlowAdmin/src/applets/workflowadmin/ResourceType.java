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
 * ResourceType.java
 *
 * Created on 11 de octubre de 2004, 06:51 PM
 */

package applets.workflowadmin;
import java.util.*;

/**
 * Clase que representa un tipo de recurso, esta informaci�n est mostrada en una
 * tabla al editar un flujo de publicaci�n.
 * @author Victor Lorenzana
 */
public class ResourceType {
    boolean selected;
    String name;
    String description;
    String id;
    String topicmap;
    String topicmapname;
    /** Creates a new instance of ResourceType */
    public ResourceType(String id,String name,String description,String topicmap,String topicmapname) {
        this.name=name;
        this.description=description;
        this.id=id;
        this.topicmap=topicmap;
        this.topicmapname=topicmapname;
    }
    public String getTopicMapName()
    {
        return topicmapname;
    }
    public String getTopicMap()
    {
        return topicmap;
    }
    public String getID()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return this.description;
    }
    public Boolean isSelected()
    {
        return new Boolean(selected);
    }
    public void setSelected(boolean selected)
    {
        this.selected=selected;
    }
    public boolean equals(Object obj)
    {
        if(obj instanceof ResourceType)
        {
            ResourceType res=(ResourceType)obj;
            if(res.getID().equals(this.getID()) && res.getTopicMap().equals(this.getTopicMap()))
            {
                return true;
            }
        }
        return false;
    }
    
    
    
}
