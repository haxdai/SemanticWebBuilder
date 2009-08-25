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
 * WBTopicMap.java
 *
 * Created on 8 de agosto de 2002, 18:07
 */

import applets.commons.*;

/**
 *
 * @author  Administrador
 * @version 
 */
public class WBTopicMap {

    WBTreeNode node;
    private String id;
    private String title;
    private String home;
    private String lang="IDM_WBes";
    private boolean active=false;
    private boolean borrado=false;
    
    /** Creates new WBTopicMap */
    public WBTopicMap(WBTreeNode node) {
        this.node=node;
        init();
    }
    
    private void init()
    {
        for(int x=0;x<node.getNodesSize();x++)
        {
            String name=node.getNode(x).getName();
            if(name.equals("id"))
            {
                id=node.getNode(x).getFirstNode().getText();
            }
            else if(name.equals("title"))
            {
                title=node.getNode(x).getFirstNode().getText();
            }
            else if(name.equals("home"))
            {
                home=node.getNode(x).getFirstNode().getText();
            }
            else if(name.equals("language"))
            {
                lang=node.getNode(x).getFirstNode().getText();
            }
            else if(name.equals("active"))
            {
                if(node.getNode(x).getFirstNode().getText().equals("1"))
                active=true;
            }
        }
    }
    
    public String toString()
    {
        return title;
    }

    /** Getter for property id.
     * @return Value of property id.
     */
    public java.lang.String getId() {
        return id;
    }
    
    /** Getter for property title.
     * @return Value of property title.
     */
    public java.lang.String getTitle() {
        return title;
    }
    
    /** Getter for property home.
     * @return Value of property home.
     */
    public java.lang.String getHome() {
        return home;
    }
    
    /** Getter for property lang.
     * @return Value of property lang.
     */
    public java.lang.String getLang() {
        return lang;
    }
    
    /** Getter for property active.
     * @return Value of property active.
     */
    public boolean isActive()
    {
        return active;
    }    
  
    /** Setter for property active.
     * @param active New value of property active.
     */
    public void setActive(boolean active)
    {
        this.active = active;
    }    
   
    /** Getter for property borrado.
     * @return Value of property borrado.
     */
    public boolean isBorrado()
    {
        return borrado;
    }
    
    /** Setter for property borrado.
     * @param borrado New value of property borrado.
     */
    public void setBorrado(boolean borrado)
    {
        this.borrado = borrado;
    }
    
}
