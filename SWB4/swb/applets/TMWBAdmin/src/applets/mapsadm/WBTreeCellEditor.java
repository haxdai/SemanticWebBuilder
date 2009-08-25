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
 * WBTreeCellEditor.java
 *
 * Created on 26 de agosto de 2002, 17:12
 */

package applets.mapsadm;

import javax.swing.tree.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

/**
 *
 * @author  Administrador
 * @version 
 */
public class WBTreeCellEditor extends DefaultTreeCellEditor
{
    private JApplet parent=null;
    private JTree tree;
    private ScopedName scope=null;
    
    public WBTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer, TreeCellEditor editor, JApplet parent) 
    {
        this(tree, renderer, editor);
        this.parent=parent;
        this.tree=tree;
    }
    
    public WBTreeCellEditor(final JTree tree, final DefaultTreeCellRenderer renderer, TreeCellEditor editor) 
    {
        super(tree,renderer,editor);
    }
    
    public boolean stopCellEditing()
    {
        //System.out.println("CellEditor stopCellEditing");
        return super.stopCellEditing();
    }
   
    public void prepareForEditing()
    {
        DefaultMutableTreeNode selected=(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
        Object obj=selected.getUserObject();
        if(obj instanceof ScopedName)
        {
            scope=(ScopedName)obj;
        }
        else scope=null;
        //System.out.println("CellEditor prepareForEditing:"+selected);
        //System.out.println("name:"+scope.getName());
        //System.out.println("languege:"+scope.getLanguage());
        //System.out.println("scope:"+scope.getScope());
        super.prepareForEditing();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        //System.out.println("CellEditor actionPerformed:"+e);
        super.actionPerformed(e);
    }

    /** Getter for property scope.
     * @return Value of property scope.
     */
    public ScopedName getScope() {
        return scope;
    }
   
}
