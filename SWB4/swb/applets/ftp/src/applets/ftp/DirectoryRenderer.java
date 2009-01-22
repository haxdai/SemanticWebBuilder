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
 * DirectoryRenderer.java
 *
 * Created on 11 de noviembre de 2004, 11:38 AM
 */

package applets.ftp;

import javax.swing.JTree;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;
/**
 * Clase que da la logica de presentaci�n gr�fica de un directorio en el applet.
 * @author Victor Lorenzana
 */
public class DirectoryRenderer extends JPanel implements TreeCellRenderer{
    
    /** Creates a new instance of DirectoryRenderer */
    JTable table;
    public DirectoryRenderer(JTable table) {
        this.table=table;
    }
    
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        if(value instanceof Directory)
        {
            Directory dir=(Directory)value;
            dir.getComponent().setFont(tree.getFont());
            if(expanded)
            {
                dir.getComponent().setIcon(new javax.swing.ImageIcon(getClass().getResource("/applets/ftp/images/open.gif")));
            }
            else
            {
                dir.getComponent().setIcon(new javax.swing.ImageIcon(getClass().getResource("/applets/ftp/images/close.gif")));
            }                 
            if(selected)
            {                
                dir.getComponent().setBackground(table.getSelectionBackground());
                dir.getComponent().setForeground(table.getSelectionForeground());
                //dir.getComponent().setIcon(new javax.swing.ImageIcon(getClass().getResource("/applets/ftp/images/open.gif")));                
            }
            else
            {
                dir.getComponent().setBackground(tree.getBackground());
                dir.getComponent().setForeground(table.getForeground());
            }
            return  dir.getComponent();
        }
        return this;
    }
    
}
