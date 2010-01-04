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
 * WBResourceModes.java
 *
 * Created on 8 de junio de 2004, 05:57 PM
 */

package com.infotec.wb.lib;

/**
 * Interfase que define las constantes requeridas por WBPartameter
 * @author Javier Solis Gonzalez
 */
public interface WBResourceModes
{
    public static final String WinState_NORMAL="normal";
    public static final String WinState_MAXIMIZED="maximized";
    public static final String WinState_MINIMIZED="minimized";    
    
    public static final String Mode_EDIT="edit";
    public static final String Mode_VIEW="view";
    public static final String Mode_HELP="help";
    public static final String Mode_ADMIN="admin";
    public static final String Mode_ADMHLP="admhlp";
    public static final String Mode_XML="XML";
    public static final String Mode_INDEX="index";
    
    public static final String Action_EDIT="edit";
    public static final String Action_ADD="add";
    public static final String Action_REMOVE="remove";

    public static final int UsrLevel_NONE=0;
    public static final int UsrLevel_SEE=1;
    public static final int UsrLevel_CREATE=2;
    public static final int UsrLevel_MODIFY=3;
    public static final int UsrLevel_REMOVE=4;
    public static final int UsrLevel_ADMIN=5;
    
    public static final int Call_CONTENT=1;
    public static final int Call_STRATEGY=2;
    public static final int Call_DIRECT=3;    
    
    public static final int UrlType_RENDER=0;
    public static final int UrlType_ACTION=1;
}
