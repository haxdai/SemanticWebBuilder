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
 * Scope.java
 *
 * Created on 22 de abril de 2002, 15:52
 */

package com.infotec.topicmaps;

import java.util.*;

/**
 * Objeto <B>Scope</B> que es parte de la implementacion del estandar XTM de TopicMaps.
 * <BR>
 * <B>Scope</B> specifies the extent of the validity of a topic characteristic assignment.
 * It establishes the context in which a name or an occurrence is assigned to a given topic,
 * and the context in which topics are related through associations.
 * Every characteristic has a scope, which may be specified either explicitly,
 * as a set of topics, or implicitly, in which case it is known as the unconstrained scope.
 * Assignments made in the unconstrained scope are always valid.
 *
 * <B>Scope</B> is considered to establish a namespace for the base names of topics.
 * This leads to the constraint, imposed by the topic map paradigm,
 * called the topic naming constraint, that any topics having the same base name
 * in the same scope implicitly refer to the same subject and therefore should be merged.
 * With the exception of this constraint, the interpretation of a characteristic's scope
 * and its effect on processing is left to the application and is in no way constrained by this specification.
 * @author Javier Solis Gonzalez
 * @version 1.1
 */
public class Scope
{
    protected String m_id;

    protected HashMap m_topicrefs;
    protected ArrayList m_subjectindicatorrefs;
    protected ArrayList m_resourceRefs;


    /** Creates new Scop */
    public Scope()
    {
        m_topicrefs = new HashMap();
        m_subjectindicatorrefs = new ArrayList();
        m_resourceRefs = new ArrayList();
    }

    /**
     * @param ref  */
    public Scope(Topic ref)
    {
        this();
        if(ref!=null)
        {
            m_topicrefs.put(ref.getId(), ref);
        }
    }
    
    //regresa otro objeto con la misma informacion que este
    public Scope getCopy()
    {
        Scope aux=new Scope();
        aux.m_id=m_id;
    	aux.m_topicrefs=new HashMap(m_topicrefs);
        aux.m_subjectindicatorrefs=new ArrayList(m_subjectindicatorrefs);
        aux.m_resourceRefs=new ArrayList(m_resourceRefs); 
        return aux;
    }

    /** Getter for property m_id.
     * @return Value of property m_id.
     */
    public String getId()
    {
        return m_id;
    }

    /** Setter for property m_id.
     * @param id New value of property m_id.
     */
    public void setId(String id)
    {
        this.m_id = id;
    }


    /** Getter for property m_topicref.
     * @return Value of property m_topicref.
     */
    public java.util.HashMap getTopicRefs()
    {
        return m_topicrefs;
    }

    /** Setter for property m_topicref.
     * @param topicrefs New value of property m_topicref.
     */
    public void setTopicRefs(java.util.HashMap topicrefs)
    {
        this.m_topicrefs = topicrefs;
    }

    /** Getter for property m_subjectindicatorref.
     * @return Value of property m_subjectindicatorref.
     */
    public java.util.ArrayList getSubjectIndicatorRefs()
    {
        return m_subjectindicatorrefs;
    }

    /** Setter for property m_subjectindicatorref.
     * @param subjectindicatorrefs  */
    public void setSubjectIndicatorRefs(java.util.ArrayList subjectindicatorrefs)
    {
        this.m_subjectindicatorrefs = subjectindicatorrefs;
    }

    /** Getter for property m_resourceRefs.
     * @return Value of property m_resourceRefs.
     */
    public java.util.ArrayList getResourceRefs()
    {
        return m_resourceRefs;
    }

    /** Setter for property m_resourceRefs.
     * @param resourceRefs  */
    public void setResourceRefs(java.util.ArrayList resourceRefs)
    {
        this.m_resourceRefs = resourceRefs;
    }

}

