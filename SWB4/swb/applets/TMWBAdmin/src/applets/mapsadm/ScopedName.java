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


package applets.mapsadm;

/*
 * ScopedName.java
 *
 * Created on 5 de septiembre de 2002, 18:30
 */

/**
 *
 * @author  Administrador
 * @version 
 */
public class ScopedName {
    private String name;
    private String scope;
    private String language;

    /** Creates new ScopedName */
    public ScopedName() {
    }

    /** Creates new ScopedName */
    public ScopedName(String name, String scope, String language) {
        this.name=name;
        this.scope=scope;
        this.language=language;
    }

    /** Getter for property name.
     * @return Value of property name.
     */
    public java.lang.String getName() {
        return name;
    }
    
    /** Setter for property name.
     * @param name New value of property name.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }
    
    /** Getter for property scope.
     * @return Value of property scope.
     */
    public java.lang.String getScope() {
        return scope;
    }
    
    /** Setter for property scope.
     * @param scope New value of property scope.
     */
    public void setScope(java.lang.String scope) {
        this.scope = scope;
    }
    
    public String toString()
    {
        String ret=name;
        //if(scope!=null)
            //ret+=" "+scope;
        return ret;
    }
    
    /** Getter for property language.
     * @return Value of property language.
     */
    public java.lang.String getLanguage() {
        return language;
    }
    
    /** Setter for property language.
     * @param language New value of property language.
     */
    public void setLanguage(java.lang.String language) {
        this.language = language;
    }
    
}
