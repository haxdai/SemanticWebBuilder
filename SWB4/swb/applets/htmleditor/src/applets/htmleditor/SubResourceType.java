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
 * SubResourceType.java
 *
 * Created on 20 de enero de 2005, 06:30 PM
 */

package applets.htmleditor;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
/**
 *
 * @author  Victor Lorenzana
 */
public class SubResourceType extends DefaultMutableTreeNode implements SelectableNode{
    
    /** Creates a new instance of SubResourceType */
    JPanel panel=new JPanel();
    JLabel label=new JLabel();
    JRadioButton radio=new JRadioButton();
    String id,topicmap;
    public SubResourceType(String id,String topicmap,String name,ButtonGroup bg) {
        this.id=id;
        this.topicmap=topicmap;
       label.setText(name);
        label.setOpaque(false);
        radio.setOpaque(false);
        panel.setOpaque(false);
        this.label.setBackground(Color.WHITE);
        bg.add(radio);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/applets/htmleditor/images/f_general.gif")));
        panel.add(radio);
        panel.add(label);  
        this.radio.setBackground(Color.WHITE);
    }
    public String getID()
    {
        return id;
    }
    public String topicMapID()
    {
        return topicmap;
    }
    public String getName()
    {
        return label.getText();
    }
    public Component getComponent()
    {
        return panel;
    }    
    public void setSelected(boolean selected)
    {
        radio.setSelected(selected);
    }
    public boolean isSelected()
    {
        return radio.isSelected();
    }
    
    public JRadioButton getRadioButton() {
        return radio;
    }
    
}
