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
 * Topic.java
 *
 * Created on 7 de enero de 2005, 06:36 PM
 */

package applets.filterSection;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.util.*;
/**
 * Clase que representa un topic dentro del �rbol de secciones, este nodo es
 * representado como un checkbox.
 * @author Victor Lorenzana
 */
public class Topic extends DefaultMutableTreeNode implements SelectableNode{
    
    /** Creates a new instance of Topic */
    HashSet listeners=new HashSet();
    boolean selected;
    boolean enabled=true;
    boolean willExpand=false;
    TristateCheckBox chk=new TristateCheckBox();
    JPanel panel=new JPanel();
    JLabel label=new JLabel();
    String id,topicmap;    
    String realoadPath;
    String iconName;
    public Topic(String iconName,String topicmap,String id,String text,String realoadPath,ImageIcon img) {
        panel.setOpaque(false);
        this.label.setBackground(Color.WHITE);
        label.setOpaque(false);
        chk.setOpaque(false);
        //panel.setOpaque(true);
        label.setText(text);
        chk.setText("");
        chk.setState(TristateCheckBox.NOT_SELECTED);
        this.id=id;            
        panel.add(chk);
        panel.add(label);        
        if(img!=null)
            label.setIcon(img);
        this.topicmap=topicmap;
        this.realoadPath=realoadPath;
        this.iconName=iconName;
    }
    public JLabel getLabel()
    {
        return this.label;
    }
    public void addTopicListener(Topic topic)
    {
        if(topic!=this && topic.getRealoadPath()!=null && this.getRealoadPath()!=null && this.getRealoadPath().equals(topic.getRealoadPath()))
        {
            if(topic.getChecked().equals(TristateCheckBox.SELECTED) || topic.getChecked().equals(TristateCheckBox.DONT_CARE))
            {
                this.setCheckedTopic(TristateCheckBox.NOT_SELECTED);
            }
            this.listeners.add(topic);
        }
    }
    public String getIconName()
    {
        return iconName;
    }
    public String getRealoadPath()
    {
        return realoadPath;
    }
    public boolean getWillExpand()
    {
        return this.willExpand;
    }
    public void setWillExpand(boolean willExpand)
    {
        this.willExpand=willExpand;
    }
    public String getTopicMapID()
    {
        return topicmap;
    }
    public String getID()
    {
        return id;
    }
    public TristateCheckBox getCheckBox() {
        return chk;
    }
    
    public TristateCheckBox.State getChecked() {
        return chk.getState();
    }
    
    public java.awt.Component getComponent() {
        return panel;
    }
    public void setLabelParent(SelectableNode lb,Color color)
    {
        
        lb.getLabel().setForeground(color);
        lb.getLabel().updateUI();
        if(lb.getParent() instanceof SelectableNode)
        {
            SelectableNode parent=(SelectableNode)lb.getParent();
            parent.getLabel().setForeground(color);
            parent.getLabel().updateUI();
            setLabelParent(parent,color);
        } 
    }
    public void nextChecked()
    {
        chk.nextState();
        setChecked(chk.getState());
    }
    public void setChecked(TristateCheckBox.State state) {
        this.chk.setState(state);
        if(chk.getState()==TristateCheckBox.SELECTED || chk.getState()==TristateCheckBox.DONT_CARE)
        {
            setLabelParent(this,new Color(81,137,42));     
        }
        if(chk.getState()==TristateCheckBox.DONT_CARE)
        {
                 
            for(int i=0;i<this.getChildCount();i++)
            {
                if(this.getChildAt(i) instanceof Topic)
                {
                    Topic topic=(Topic)this.getChildAt(i);
                    topic.setChecked(TristateCheckBox.NOT_SELECTED);
                    topic.setEnabled(false);
                }
            }
             
        }
        else
        {
                     
            for(int i=0;i<this.getChildCount();i++)
            {
                if(this.getChildAt(i) instanceof Topic)
                {
                    Topic topic=(Topic)this.getChildAt(i);  
                    topic.setEnabled(true);
                }
            }
            setLabelParent(this,Color.BLACK);  
        }
        Iterator topics=this.listeners.iterator();
        while(topics.hasNext())
        {
            Topic topic=(Topic)topics.next();
            topic.setCheckedTopic(state);
        }
    }
    public void setCheckedTopic(TristateCheckBox.State state)
    {
        
        this.chk.setState(state);
        if(this.chk.getState()==TristateCheckBox.SELECTED || this.chk.getState()==TristateCheckBox.DONT_CARE)
        {
            setLabelParent(this,new Color(81,137,42));  
        }
        if(this.chk.getState()==TristateCheckBox.DONT_CARE)
        {
                    
            for(int i=0;i<this.getChildCount();i++)
            {
                if(this.getChildAt(i) instanceof Topic)
                {
                    Topic topic=(Topic)this.getChildAt(i);
                    topic.setCheckedTopic(TristateCheckBox.NOT_SELECTED);
                    topic.setEnabled(false);
                }
            }
            
        }
        else
        {
                     
            for(int i=0;i<this.getChildCount();i++)
            {
                if(this.getChildAt(i) instanceof Topic)
                {
                    Topic topic=(Topic)this.getChildAt(i);  
                    topic.setEnabled(true);
                }
            }
            setLabelParent(this,Color.BLACK);  
        }       
    }
    public void setEnabledTopic(boolean enabled)
    {
        this.enabled=enabled;
        this.panel.setEnabled(enabled);
        this.chk.setEnabled(enabled);
        this.label.setEnabled(enabled);
        for(int i=0;i<this.getChildCount();i++)
        {
            if(this.getChildAt(i) instanceof Topic)
            {
                Topic topic=(Topic)this.getChildAt(i);  
                topic.setEnabled(enabled);
            }
        }        
    }
    public void setEnabled(boolean enabled)
    {
        this.enabled=enabled;
        this.panel.setEnabled(enabled);
        this.chk.setEnabled(enabled);
        this.label.setEnabled(enabled);
        for(int i=0;i<this.getChildCount();i++)
        {
            if(this.getChildAt(i) instanceof Topic)
            {
                Topic topic=(Topic)this.getChildAt(i);  
                topic.setEnabled(enabled);
            }
        }
        Iterator it=this.listeners.iterator();
        while(it.hasNext())
        {
            Topic topic=(Topic)it.next();
            topic.setEnabledTopic(enabled);
        }
    }
    public boolean isEnabled()
    {
        return enabled;
    }
    
    public void setSelected(boolean selected)
    {        
        this.selected=selected;
    }
    
    public boolean isSelected() {
        return selected;
    }
}
