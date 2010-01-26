/**
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración,
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite.
*
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’),
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición;
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software,
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización
* del SemanticWebBuilder 4.0.
*
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita,
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar
* de la misma.
*
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente
* dirección electrónica:
*  http://www.semanticwebbuilder.org
**/


/*
 * WBResRequest.java
 *
 * Created on 1 de junio de 2004, 01:41 PM
 */

package com.infotec.wb.lib;

import java.util.*;

/**
 * Intefase que extiende de WBParameter la cual contiene los objetos que son pasados
 * al recurso como parametros.
 * Ejemplo: Topic, WBUser..
 * @author Javier Solis Gonzalez
 */
public interface WBParamRequest extends WBParameters
{
    public Map getArguments();

    public String getArgument(String key);

    public String getArgument(String key, String defvalue);
    
    public WBResourceURL getActionUrl();
    
    public WBResourceURL getRenderUrl();
    
    public String getLocaleString(String key) throws com.infotec.appfw.exception.AFException;

    public String getLocaleLogString(String key) throws com.infotec.appfw.exception.AFException;
    
    public java.lang.String getWindowTitle();
    
    public void setWindowTitle(java.lang.String windowTitle);
    
    public void setTemplateHead(String templateHead);
}
