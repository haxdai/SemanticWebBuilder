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
 * GenericTreeRender.java
 *
 * Created on 24 de junio de 2004, 04:25 PM
 */

package applets.generictree;

import javax.swing.tree.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.*;

import applets.commons.*;
/**
 * Clase que imprime los elementos del �rbol.
 *
 * Class that prints the tree elements.
 *
 * @author Javier Solis Gonzalez
 */
public class GenericTreeRender extends DefaultTreeCellRenderer
{
    private HashMap icons=new HashMap();
    
    /** Creates a new instance of GenericTreeRender */
    public GenericTreeRender()
    {
    }
    
    /** Getter for property icons.
     * @return Value of property icons.
     *
     */
    public HashMap getIcons()
    {
        return icons;
    }
    
    /** Setter for property icons.
     * @param icons New value of property icons.
     *
     */
    public void setIcons(HashMap icons)
    {
        this.icons = icons;
    }
    
/*    
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawLine(0,0, 10,10);
    }
*/    
    public Component getTreeCellRendererComponent(JTree tree,Object value,boolean sel,boolean expanded,boolean leaf,int row,boolean hasFocus) 
    {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode dnode =(DefaultMutableTreeNode)value;
        if(dnode.getUserObject() instanceof WBTreeNode)
        {
            WBTreeNode node=(WBTreeNode)dnode.getUserObject();

            String icon=node.getAttribute("icon");
            if(icon!=null && icons.get(icon)!=null)
            {
                setIcon((Icon)icons.get(icon));
            }
            String alt=node.getAttribute("alt");
            if(alt!=null)
            {
                setToolTipText(alt);
            }else
            {
                setToolTipText("");
            }
        }else
        {
            setToolTipText("");
        }
        return this;
    }
    
    
}
