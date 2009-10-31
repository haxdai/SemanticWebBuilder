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
 * RoleSpec.java
 *
 * Created on 22 de abril de 2002, 15:54
 */

package com.infotec.topicmaps;

import java.util.*;

/**
 * Objeto <B>RoleSpec</B> que es parte de la implementacion del estandar XTM de TopicMaps.
 * <BR>
 * The concept of <B>role</B> expresses the nature of a topic's involvement as a member of an
 * association.
 * @author Javier Solis Gonzalez
 * @version 1.1
 */
public class RoleSpec
{

    protected String m_id;

    protected Topic m_topicref;
    protected String m_subjectindicatorref;


    /** Creates new Member */
    public RoleSpec()
    {
    }
    
    //regresa otro objeto con la misma informacion que este
    public RoleSpec getCopy()
    {
        RoleSpec aux=new RoleSpec();
        aux.m_id=m_id;
        aux.m_topicref=m_topicref;
        aux.m_subjectindicatorref=m_subjectindicatorref;
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
    public Topic getTopicRef()
    {
        return m_topicref;
    }

    /** Setter for property m_topicref.
     * @param topicref New value of property m_topicref.
     */
    public void setTopicRef(Topic topicref)
    {
        this.m_topicref = topicref;
    }

    /** Getter for property m_subjectindicatorref.
     * @return Value of property m_subjectindicatorref.
     */
    public java.lang.String getSubjectIndicatorRef()
    {
        return m_subjectindicatorref;
    }

    /** Setter for property m_subjectindicatorref.
     * @param subjectindicatorref New value of property m_subjectindicatorref.
     */
    public void setSubjectIndicatorRef(java.lang.String subjectindicatorref)
    {
        this.m_subjectindicatorref = subjectindicatorref;
    }

}
