/**
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integraci�n,
* colaboraci�n y conocimiento, que gracias al uso de tecnolog�a sem�ntica puede generar contextos de
* informaci�n alrededor de alg�n tema de inter�s o bien integrar informaci�n y aplicaciones de diferentes
* fuentes, donde a la informaci�n se le asigna un significado, de forma que pueda ser interpretada y
* procesada por personas y/o sistemas, es una creaci�n original del Fondo de Informaci�n y Documentaci�n
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en tr�mite.
*
* INFOTEC pone a su disposici�n la herramienta SemanticWebBuilder a trav�s de su licenciamiento abierto al p�blico (�open source�),
* en virtud del cual, usted podr� usarlo en las mismas condiciones con que INFOTEC lo ha dise�ado y puesto a su disposici�n;
* aprender de �l; distribuirlo a terceros; acceder a su c�digo fuente y modificarlo, y combinarlo o enlazarlo con otro software,
* todo ello de conformidad con los t�rminos y condiciones de la LICENCIA ABIERTA AL P�BLICO que otorga INFOTEC para la utilizaci�n
* del SemanticWebBuilder 4.0.
*
* INFOTEC no otorga garant�a sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni impl�cita ni expl�cita,
* siendo usted completamente responsable de la utilizaci�n que le d� y asumiendo la totalidad de los riesgos que puedan derivar
* de la misma.
*
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposici�n la siguiente
* direcci�n electr�nica:
*  http://www.semanticwebbuilder.org
**/ 

package org.semantic.blogger.interfaces;

/**
 *
 * @author victor.lorenzana
 */
public final class UserBlog {
    public String url;
    public boolean isAdmin;
    public String blogid;    
    public String blogName;
    @Override
    public String toString()
    {
        return blogid;
    }
    @Override
    public int hashCode()
    {
        return this.blogid.hashCode();
    }
    @Override
    public boolean equals(Object obj)
    {
        boolean equals=false;
        if(obj instanceof UserBlog)
        {
            equals =((UserBlog)obj).blogid.equals(this.blogid);
        }
        return equals;
    }
}
