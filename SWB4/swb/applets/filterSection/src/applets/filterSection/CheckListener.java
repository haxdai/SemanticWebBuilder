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
 * CheckListener.java
 *
 * Created on 7 de enero de 2005, 06:34 PM
 */

package applets.filterSection;

/**
 *
 * @author  Victor Lorenzana
 */
import javax.swing.JTree;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase que permite escuchar cuando se le ha dado click a un elemento de tipo
 * CkeckBox.
 * @author Victor Lorenzana
 */
public class CheckListener extends MouseAdapter {
   public void mousePressed(MouseEvent e) {
      //get the tree
       if(e.getButton()==e.BUTTON1 && e.getClickCount()==1)
       {           
          JTree tree = (JTree)e.getSource ();    
          if(tree.getLastSelectedPathComponent() instanceof SelectableNode && tree.getLastSelectedPathComponent() instanceof Topic)
          {              
              SelectableNode node = 
                 (SelectableNode)tree.getLastSelectedPathComponent ();              
              
              if(node.isSelected())
              {
                  if(node.getCheckBox().isEnabled())
                  {
                     node.nextChecked();
                  }
              }
              
              
          }
          tree.updateUI();
       }
   }
}


