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
 * SelectActivities.java
 *
 * Created on 12 de octubre de 2004, 01:32 AM
 */

package applets.workflowadmin;

import java.awt.event.*;
import javax.swing.*;
/**
 * Clase utiler�a para seleciconar actividades dentro de la tabla de actividades.
 * @author Victor Lorenzana
 */
public class SelectActivities implements MouseListener
{
    JPopupMenu jPopupMenu1;
    
    SelectActivities(JPopupMenu jPopupMenu1)
    {
        this.jPopupMenu1=jPopupMenu1;
        
    }
    public void mouseReleased(MouseEvent e)
    {               
    }
    public void mousePressed(MouseEvent e)
    {
       if(e.getButton()==e.BUTTON3 && e.getClickCount()==1)
       {
           JMenuItem add=(JMenuItem)jPopupMenu1.getComponent(0);
           JMenuItem edit=(JMenuItem)jPopupMenu1.getComponent(1);
           JMenuItem delete=(JMenuItem)jPopupMenu1.getComponent(3);
           add.setEnabled(true);
           edit.setEnabled(true);
           delete.setEnabled(false);           
           
           if(e.getSource() instanceof JTable)
           {               
               JTable table=(JTable)e.getSource();
               if(table.getSelectedRows().length>0)
               {                    
                    delete.setEnabled(true);
                    add.setEnabled(false);                    
                    edit.setEnabled(true);
                    
                    jPopupMenu1.show(table, e.getX(),e.getY());
               }
               else
               {
                   add.setEnabled(true);                   
                   edit.setEnabled(false);
               }
           }
           else if(e.getSource() instanceof JScrollPane)
           { 
               
               add.setEnabled(true);               
               edit.setEnabled(false);
               JScrollPane table=(JScrollPane)e.getSource();
               jPopupMenu1.show(table, e.getX(),e.getY());
           }
       }
    }
    public void mouseExited(MouseEvent e)
    {

    }
    public void mouseEntered(MouseEvent e)
    {

    }
     public void mouseClicked(MouseEvent e)
    {

    }
}
