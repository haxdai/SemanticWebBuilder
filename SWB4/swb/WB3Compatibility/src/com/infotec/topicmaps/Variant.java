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
 * Variant.java
 *
 * Created on 22 de abril de 2002, 15:55
 */

package com.infotec.topicmaps;

import java.util.*;

/**
 * Objeto <B>Variant</B> que es parte de la implementacion del estandar XTM de TopicMaps.
 * <BR>
 * The <B>variant</B> element is an alternate form of a topic's base name appropriate for a processing context specified by the variant's <B>parameters</B> child element. Among these contexts may be sorting and display.
 * @author Javier Solis Gonzalez
 * @version 1.1
 */
public class Variant
{

    protected String m_id;
    protected Parameters m_parameters;
    protected VariantName m_variantName;
    protected ArrayList m_variants;    //Variant


    /** Creates new VAriant */
    public Variant()
    {
        m_variants = new ArrayList();
    }

    /**
     * @param variantName  */
    public Variant(String variantName)
    {
        this();
        m_variantName = new VariantName();
        m_variantName.setResourceData(variantName);
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

    /** Getter for property m_parameter.
     * @return Value of property m_parameters.
     */
    public Parameters getParameters()
    {
        return m_parameters;
    }

    /** Setter for property m_parameter.
     * @param parameters New value of property m_parameters.
     */
    public void setParameters(Parameters parameters)
    {
        this.m_parameters = parameters;
    }

    /** Getter for property m_variantName.
     * @return Value of property m_variantName.
     */
    public VariantName getVariantName()
    {
        return m_variantName;
    }

    /** Setter for property m_variantName.
     * @param variantName New value of property m_variantName.
     */
    public void setVariantName(VariantName variantName)
    {
        this.m_variantName = variantName;
    }

    /** Getter for property m_variants.
     * @return Value of property m_variants.
     */
    public ArrayList getVariants()
    {
        return m_variants;
    }
}
