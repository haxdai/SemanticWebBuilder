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
 * Directory.java
 *
 * Created on 11 de noviembre de 2004, 11:31 AM
 */

package applets.ftp;

import javax.swing.tree.*;
import javax.swing.*;
import java.awt.*;
/**
 * Clase que representa un directorio existente en el servidor.
 * @author Victor Lorenzana
 */
public class Directory extends DefaultMutableTreeNode {
    
    /** Creates a new instance of Directory */
    String name, path;
    JLabel component=new JLabel();
    boolean selected=false;
    public Directory(String name,String path) {
        this.name=name;
        this.path=path;
        component.setText(name);        
        component.setOpaque(true);
    }
    public void setSelected(boolean selected)
    {
        this.selected=selected;
       /* if(selected)
        {
            this.component.setBackground(new Color(204,204,204));
        }
        else
        {
            this.component.setBackground(Color.white);
        }
        this.component.updateUI();*/
    }
    public void setName(String name)
    {
        this.name=name;  
        this.getComponent().setText(this.name);
        this.getComponent().updateUI();
    }
    public void setDirectory(String path)
    {
        this.path=path;        
    }
    public boolean isSelected()
    {
        return selected;
    }
    public JLabel getComponent()
    {
        return component;
    }
    public String getName()
    {
        return name;
    }
    public String getDirectory()
    {
        return path;
    }
    public void rename(String name)
    {
        this.name=name;
    }
    public String toString()
    {
        return name;
    }
    
}
