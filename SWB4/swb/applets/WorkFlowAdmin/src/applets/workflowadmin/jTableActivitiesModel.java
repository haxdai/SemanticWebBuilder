/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 


/*
 * jTableActivities.java
 *
 * Created on 11 de octubre de 2004, 11:49 PM
 */

package applets.workflowadmin;

import javax.swing.table.*;
import java.util.*;
import javax.swing.*;
/**
 * Clase que representa el modelo de datos para actividades.
 * @author Victor Lorenzana
 */
public class jTableActivitiesModel extends AbstractTableModel{
     private String[] columnNames =new String[2];
     Activities activities=new Activities();
     JTable table;
    /** Creates a new instance of jTableActivities */
     public jTableActivitiesModel(JTable table,Locale locale) {         
         this.table=table;
         columnNames[0]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableActivitiesModel",locale).getString("Actividad");
         columnNames[1]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableActivitiesModel",locale).getString("Descripcion");
    }
    public jTableActivitiesModel(Locale locale) {         
         this.table=table;
         columnNames[0]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableActivitiesModel",locale).getString("Actividad");
         columnNames[1]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableActivitiesModel",locale).getString("Descripcion");
    }
    public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    public int getRowCount() 
    {
        return this.activities.size();
    }
    public int getColumnCount()
    {
        return columnNames.length; 
    }
    public int up(Activity activity)
    {
        int pos=this.activities.up(activity);
        if(table!=null)
            table.updateUI();
        return pos;
    }
    public int down(Activity activity)
    {
        int pos=this.activities.down(activity);
        if(table!=null)
            table.updateUI();
        return pos;
        
    }
    public Object getValueAt(int row, int col)
    {
        Activity activity=(Activity)activities.toArray()[row];
        switch(col)
        {
            case 0:                
                return activity.getName();                
            case 1:
                return activity.getDescription();                
            default:
                return null;
        }        
    }
    public boolean isCellEditable(int row, int col)
    {
        return false; 
    }
    public void setValueAt(Object value, int row, int col) {
        
    }
    public Activity getActivity(int index)
    {
        return (Activity)this.activities.toArray()[index];
    }
    public void addActivity(Activity activity)
    {
        activities.add(activity);                
        
        if(table!=null)
            table.updateUI();
        
    }
    public void addFirstActivity(Activity activity)
    {
        activities.insertFirst(activity);                
        
        if(table!=null)
            table.updateUI();
        
    }
    public int size()
    {
        return this.activities.size();
    }
    public boolean contains(Activity activity)
    {
        return this.activities.contains(activity);
    }
    public void clear()
    {
        this.activities.clear();
    }
    public void setTable(JTable table)
    {
        this.table=table;
    }
     public Activities getActivities()
     {
         return this.activities;
     }     
    /*public int size()
    {
        return this.activities.size();
    }*/
    public void removeActivity(Activity activity)
    {
        Iterator activities=this.activities.iterator();
        while(activities.hasNext())
        {
            Activity oactivity=(Activity)activities.next();            
            Iterator links=oactivity.getLinks().iterator();
            while(links.hasNext())
            {
                Link link=(Link)links.next();
                if(link.getActivityFrom().equals(activity) || link.getActivityTo().equals(activity))
                {
                    oactivity.getLinks().remove(link);
                }
            }
        }
        this.activities.remove(activity);
        if(table!=null)
            table.updateUI();
        
    }

    
}
