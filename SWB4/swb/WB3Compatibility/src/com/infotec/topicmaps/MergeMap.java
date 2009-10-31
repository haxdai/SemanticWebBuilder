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
 * MergeMap.java
 *
 * Created on 22 de abril de 2002, 15:54
 */

package com.infotec.topicmaps;

import com.infotec.topicmaps.bean.*;

import java.util.*;

/**
 * Objeto <B>MergeMap</B> que es parte de la implementacion del estandar XTM de TopicMaps.
 * <BR>
 * A <B>mergeMap</B> element references an external <B>topicMap</B> element through an xlink:href attribute containing a URI. It is a directive to merge the containing topic map and the referenced topic map according to the rules specified in Annex F: XTM Processing Requirements.
 * The children of <B>mergeMap</B> indicate topics that are to be added to the scopes of all characteristics originating in the referenced topic map. (The reason for modifying the scopes of the merged characteristics may be to prevent topics from merging on account of the topic naming constraint, or to distinguish between characteristics on the basis of their topic map of origin.)
 * Occurs in: <B>topicMap</B>
 * @author Javier Solis Gonzalez
 * @version 1.1
 */
public class MergeMap
{
    protected String m_id;

    protected HashMap m_topicrefs;
    protected ArrayList m_subjectindicatorrefs;
    protected ArrayList m_resourceRefs;


    /** Creates new Scop */
    public MergeMap()
    {
        m_id = TopicMgr.getInstance().getNewId();
        m_topicrefs = new HashMap();
        m_subjectindicatorrefs = new ArrayList();
        m_resourceRefs = new ArrayList();
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

