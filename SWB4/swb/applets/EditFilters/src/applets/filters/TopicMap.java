/**
* SemanticWebBuilder Process (SWB Process) es una plataforma para la gesti?n de procesos de negocio mediante el uso de 
* tecnolog?a sem?ntica, que permite el modelado, configuraci?n, ejecuci?n y monitoreo de los procesos de negocio
* de una organizaci?n, as? como el desarrollo de componentes y aplicaciones orientadas a la gesti?n de procesos.
* 
* Mediante el uso de tecnolog?a sem?ntica, SemanticWebBuilder Process puede generar contextos de informaci?n
* alrededor de alg?n tema de inter?s o bien integrar informaci?n y aplicaciones de diferentes fuentes asociadas a
* un proceso de negocio, donde a la informaci?n se le asigna un significado, de forma que pueda ser interpretada
* y procesada por personas y/o sistemas. SemanticWebBuilder Process es una creaci?n original del Fondo de 
* Informaci?n y Documentaci?n para la Industria INFOTEC.
* 
* INFOTEC pone a su disposici?n la herramienta SemanticWebBuilder Process a trav?s de su licenciamiento abierto 
* al p?blico (?open source?), en virtud del cual, usted podr? usarlo en las mismas condiciones con que INFOTEC 
* lo ha dise?ado y puesto a su disposici?n; aprender de ?l; distribuirlo a terceros; acceder a su c?digo fuente,
* modificarlo y combinarlo (o enlazarlo) con otro software. Todo lo anterior de conformidad con los t?rminos y 
* condiciones de la LICENCIA ABIERTA AL P?BLICO que otorga INFOTEC para la utilizaci?n de SemanticWebBuilder Process. 
* 
* INFOTEC no otorga garant?a sobre SemanticWebBuilder Process, de ninguna especie y naturaleza, ni impl?cita ni 
* expl?cita, siendo usted completamente responsable de la utilizaci?n que le d? y asumiendo la totalidad de los 
* riesgos que puedan derivar de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder Process, INFOTEC pone a su disposici?n la
* siguiente direcci?n electr?nica: 
*  http://www.semanticwebbuilder.org.mx
**/
 


/*
 * TopicMap.java
 *
 * Created on 23 de noviembre de 2004, 12:55 PM
 */

package applets.filters;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
/**
 * Clase que representa un sitio (TopicMap) dentro de los ?rboles de secciones,
 * este elemento es mostrado como un checkbox para seleccionarlo y ser parte de un
 * filtro.
 * @author Victor Lorenzana
 */
public class TopicMap extends DefaultMutableTreeNode implements SelectableNode{
    
    /** Creates a new instance of Topic */
    boolean selected;
    boolean enabled=true;
    JCheckBox chk=new JCheckBox();
    JPanel panel=new JPanel();
    JLabel label=new JLabel();
    boolean checked=false;
    String realoadPath;
    String id;
    String iconName;
    boolean editable=true;
    public TopicMap(String iconName,String id,String text,String realoadPath,ImageIcon img) {
        panel.setOpaque(false);
        this.label.setBackground(Color.WHITE);
        label.setOpaque(false);
        chk.setOpaque(false);
        //panel.setOpaque(true);
        label.setText(text);
        chk.setText("");          
        panel.add(chk);
        panel.add(label); 
        if(img!=null)
            label.setIcon(img);
        this.id=id;
        this.realoadPath=realoadPath;
        this.iconName=iconName;
    }
    public boolean isEditable()
    {
        return this.editable;
    }
    public void setEditable(boolean editable)
    {
        this.editable=editable;
        
    }
    public String getID()
    {
        return id;
    }
    public String getIconName()
    {
        return iconName;
    }
    public javax.swing.JCheckBox getCheckBox() {
        return chk;
    }
    
    public boolean getChecked() {
        return checked;
    }
     public JLabel getLabel()
    {
        return this.label;
    }
    public java.awt.Component getComponent() {
        return panel;
    }
    public String getRealoadPath()
    {
        return realoadPath;
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
    public void setChecked(boolean checked) {
        this.checked=checked;
        this.chk.setSelected(checked);        
        if(checked)
        {            
            for(int i=0;i<this.getChildCount();i++)
            {
                if(this.getChildAt(i) instanceof Topic)
                {
                    Topic topic=(Topic)this.getChildAt(i);
                    topic.setChecked(false);
                    topic.setEnabled(false);
                }
                else if(this.getChildAt(i) instanceof TopicMap)
                {
                    TopicMap topicmap=(TopicMap)this.getChildAt(i);
                    topicmap.setChecked(false);
                    topicmap.setEnabled(false);
                }
            }
            setLabelParent(this,EditFilter.colorPath);
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
                else if(this.getChildAt(i) instanceof TopicMap)
                {
                    TopicMap topicmap=(TopicMap)this.getChildAt(i);
                    topicmap.setEnabled(true);
                }
            }
            setLabelParent(this,Color.BLACK);
        }
    }
    
    public void setSelected(boolean selected)
    {      
        this.selected=selected;
        if(!this.editable)
        {
            this.panel.remove(this.chk);
        }
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    
    
}
