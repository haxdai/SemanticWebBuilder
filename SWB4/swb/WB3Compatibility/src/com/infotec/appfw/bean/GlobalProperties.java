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
 * DBBean.java
 *
 * Created on 17 de octubre de 2001, 15:03
 */
package com.infotec.appfw.bean;

import javax.servlet.http.*;
import java.util.*;
import java.io.*;

/** bean: lee variables declaradas en el archivo de propiedades global.properties en el directorio classes
 */
public class GlobalProperties implements HttpSessionBindingListener
{
    private Properties globalProp = null;

    public GlobalProperties()
    {
        InputStream in = getClass().getResourceAsStream("/global.properties");
        globalProp = new Properties();
        try
        {
            globalProp.load(in);
        } catch (Exception e)
        {
            System.err.println("Can't read the properties file. " +
                               "Make sure global.properties is in the CLASSPATH");
            return;
        }
    }

    public void refresh()
    {
        InputStream in = getClass().getResourceAsStream("/global.properties");
        globalProp = new Properties();
        try
        {
            globalProp.load(in);
        } catch (Exception e)
        {
            System.out.println("Can't read the properties file. " +
                               "Make sure global.properties is in the CLASSPATH");
            return;
        }
        //globalProp.notify();
    }

    public String getProperty(String prop)
    {
        return globalProp.getProperty(prop);
    }

    public void valueUnbound(HttpSessionBindingEvent e)
    {
        System.out.println();
    }

    public void valueBound(HttpSessionBindingEvent e)
    {
    }
}

