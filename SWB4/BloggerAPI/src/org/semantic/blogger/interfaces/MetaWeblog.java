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

import org.semanticwb.xmlrpc.*;

/**
 *
 * @author victor.lorenzana
 */
public interface MetaWeblog
{

    @XmlRpcMethod(methodName = "Blogger.newPost")
    public String newPost(String blogid, String userid, String password, Post post, boolean publish) throws Exception;

    @XmlRpcMethod(methodName = "Blogger.editPost")
    public boolean editPost(String postid, String userid, String password, Post post, boolean publish) throws Exception;

    @XmlRpcMethod(methodName = "Blogger.getPost")
    public Post getPost(String postid, String userid, String password) throws Exception;

    @XmlRpcMethod(methodName = "Blogger.getCategories")
    public CategoryInfo[] getCategories(String blogid, String username, String password) throws Exception;

    @XmlRpcMethod(methodName = "Blogger.getRecentPosts")
    public Post[] getRecentPosts(String blogid, String username, String password, int numberOfPosts) throws Exception;

    @XmlRpcMethod(methodName = "Blogger.getUsersBlogs")
    public UserBlog[] getUsersBlogs(String appkey, String username, String password) throws Exception;
}
