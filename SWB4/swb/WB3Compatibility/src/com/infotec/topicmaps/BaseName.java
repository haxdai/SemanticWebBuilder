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
 * BaseName.java
 *
 * Created on 22 de abril de 2002, 15:53
 */

package com.infotec.topicmaps;

import java.util.*;

/**
 * Objeto <B>BaseName</B> que es parte de la implementacion del estandar XTM de TopicMaps.
 * <BR>
 * A base name is the base form of a topic name; it is always a string.
 * When an application chooses to use a particular topic name to label a topic,
 * the base name provides the string for the application to use unless a variant exists
 * that is deemed to be more apposite in the processing context.
 * @author Javier Solis Gonzalez
 * @version 1.1
 */
public class BaseName
{

    protected String m_id;

    protected Scope m_scope;
    protected String m_baseNameString;
    protected ArrayList m_variants;    //Variant

    /** Creates new BaseName */
    public BaseName()
    {
        m_variants = new ArrayList();
    }

    /**
     * @param baseNameString  */
    public BaseName(String baseNameString)
    {
        this();
        this.m_baseNameString = baseNameString;
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

    /** Getter for property m_scope.
     * @return Value of property m_scope.
     */
    public Scope getScope()
    {
        return m_scope;
    }

    /** Setter for property m_scope.
     * @param scope New value of property m_scope.
     */
    public void setScope(Scope scope)
    {
        this.m_scope = scope;
    }

    /** Getter for property m_baseName.
     * @return Value of property m_baseName.
     */
    public String getBaseNameString()
    {
        return m_baseNameString;
    }

    /** Setter for property m_baseNameString.
     * @param baseNameString New value of property m_baseNameString.
     */
    public void setBaseNameString(String baseNameString)
    {
        this.m_baseNameString = baseNameString;
    }

    /** Getter for property m_variants.
     * @return Value of property m_variants.
     */
    public ArrayList getVariants()
    {
        return m_variants;
    }

    /** Setter for property m_variants.
     * @param variants New value of property m_variants.
     */
    public void setVariants(ArrayList variants)
    {
        this.m_variants = variants;
    }

}
