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
 * WBTreeRenderer.java
 *
 * Created on 13 de agosto de 2002, 16:34
 */

package applets.mapsadm;

import javax.swing.tree.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.*;

/**
 *
 * @author  Administrador
 * @version 
 */
public class WBNamesRenderer extends DefaultTreeCellRenderer {

    private Icon rootIcon=null;
    private Icon langIcon=null;
    private Hashtable idmIcons;
    
    /** Creates new WBTreeRenderer */
    public WBNamesRenderer() {
        idmIcons=new Hashtable();
    }

    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus) 
    {
        DefaultMutableTreeNode node =(DefaultMutableTreeNode)value;
        
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        
        if(node.getLevel()==0)
        {
            setIcon(rootIcon);
            setToolTipText("Nombres de la Secci�n");
        }
        else if(node.getLevel()==2)
        {
            setIcon(langIcon);
            setToolTipText("Variante de Nombre");
        }
        else if (node.getUserObject() instanceof ScopedName) 
        {
            ScopedName sc=(ScopedName)node.getUserObject();
            Icon icon=null;
            //System.out.println("Scope:"+sc.getScope());
            if(sc.getScope()!=null)
            {
                icon=(Icon)idmIcons.get(sc.getScope());
                //System.out.println("Icon:"+icon);
                if(icon!=null)
                {
                    setIcon(icon);
                    //System.out.println("SetIcon...");
                }
                if(sc.getScope().equals("CNF_WBSortName"))
                    setToolTipText("Nombre de Ordenamiento");
                else
                    setToolTipText("Idioma:"+sc.getLanguage());
            }else
            {
                setToolTipText("Sin idioma asignado");
            }
        }else
        {
            setIcon(langIcon);
            setToolTipText("Sin idioma asignado");
        }
        return this;
    }
    
    /** Getter for property rootIcon.
     * @return Value of property rootIcon.
     */
    public javax.swing.Icon getRootIcon() {
        return rootIcon;
    }
    
    /** Setter for property rootIcon.
     * @param rootIcon New value of property rootIcon.
     */
    public void setRootIcon(javax.swing.Icon rootIcon) {
        this.rootIcon = rootIcon;
    }
    
    /** Getter for property idmIcons.
     * @return Value of property idmIcons.
     */
    public Hashtable getIdmIcons() {
        return idmIcons;
    }
    
    /** Setter for property idmIcons.
     * @param idmIcons New value of property idmIcons.
     */
    public void setIdmIcons(Hashtable idmIcons) {
        this.idmIcons = idmIcons;
    }
    
    /** Getter for property langIcon.
     * @return Value of property langIcon.
     */
    public javax.swing.Icon getLangIcon() {
        return langIcon;
    }
    
    /** Setter for property langIcon.
     * @param langIcon New value of property langIcon.
     */
    public void setLangIcon(javax.swing.Icon langIcon) {
        this.langIcon = langIcon;
    }
    
}
