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
 * SelectNode.java
 *
 * Created on 3 de noviembre de 2004, 04:27 PM
 */

package applets.workflowadmin;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Clase que permite denir un nodo que puede ser seleccionado.
 * @author Victor Lorenzana
 */
public class SelectNode 
   extends DefaultMutableTreeNode { 
      ArrayList listeners=new ArrayList();
      boolean selected=false;
      Role role;
      JCheckBox c=new JCheckBox();
      public SelectNode(Role role) {
         super(role.getName());                  
         selected = false;
         c.setText(role.getName());         
         c.setBackground(Color.WHITE);
         this.role=role;
         
      }
      public String getText()  {
         return role.getName();
      }
      //can set and get the checked state
      public JCheckBox getCheckBox()
      {
          c.setSelected(selected);
          return c;
      }
      public void setCheckBox(JCheckBox c)
      {          
          this.c=c;
      }
      public void setChecked(boolean b) {
         selected=b;
         c.setSelected(b);                         
         c.updateUI();         
      }
      public boolean getChecked() {
          return selected;
      }  
      public Role getRole()
      {
          return role;
      }
}

