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
 * Root.java
 *
 * Created on 24 de enero de 2005, 05:45 PM
 */

package applets.htmleditor;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
/**
 *
 * @author  Victor Lorenzana
 */
public class Root extends DefaultMutableTreeNode {
    
    /** Creates a new instance of Root */
    boolean selected=false;
    JLabel label=new JLabel();
    public Root(String text,ImageIcon img) {
        label.setOpaque(true);
        this.label.setBackground(Color.WHITE);
        label.setText(text);
        label.setIcon(img);
    }
     public Root(String text) {
        label.setOpaque(true);
        this.label.setBackground(Color.WHITE);
        label.setText(text);
        
    }
    
    public java.awt.Component getComponent() {
        return label;
    }
    
    public javax.swing.JLabel getJLabel() {
        return label;
    }
    public JLabel getLabel()
    {
        return this.label;
    }
    public void setSelected(boolean selected) {
       /* if(selected)
        {
            this.label.setBackground(new Color(204,204,204));
        }
        else
        {
            this.label.setBackground(Color.WHITE);
        }*/
        this.selected=selected;
    }
    
}
