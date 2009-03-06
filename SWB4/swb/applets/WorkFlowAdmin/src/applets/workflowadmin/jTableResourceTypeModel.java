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
 * jTableResourceTypeModel.java
 *
 * Created on 12 de octubre de 2004, 12:00 AM
 */

package applets.workflowadmin;

import javax.swing.table.*;
import java.util.*;
/**
 * Clase que representa el modelo de datos, necesario para mostrarlo en una tabla
 * dentro de la edici�n de un flujo de publicaci�n.
 * @author Victor Lorenzana
 */
public class jTableResourceTypeModel extends AbstractTableModel implements Comparator{
     private String[] columnNames =new String[4];
     ArrayList resourcestypes=new ArrayList();
    /** Creates a new instance of jTableActivities */
     public jTableResourceTypeModel(Locale locale) {
         columnNames[0]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableResourceTypeModel",locale).getString("Tipo_de_recurso");
         columnNames[1]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableResourceTypeModel",locale).getString("mapa");
         columnNames[2]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableResourceTypeModel",locale).getString("Descripci�n");
         columnNames[3]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableResourceTypeModel",locale).getString("Utilizar");
    }
     public Iterator iterator()
     {
         return resourcestypes.iterator();
     }
    public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    public int getRowCount() 
    {
        return this.resourcestypes.size();
    }
    public void addResourceType(ResourceType rs)
    {
        resourcestypes.add(rs);
        Collections.sort(resourcestypes,this);
    }
    public int size()
    {
        return resourcestypes.size();
    }
    public ResourceType getResourceType(int index)
    {
        return (ResourceType)resourcestypes.toArray()[index];
    }
    public ResourceType getResourceType(String name)
    {
        Iterator it=resourcestypes.iterator();
        while(it.hasNext())
        {
            ResourceType rs=(ResourceType)it.next();
            if(rs.getName().equals(name))
            {
                return rs;
            }
        }
        return null;
        
    }

    public Class getColumnClass(int col)
    {      
        
        switch(col)
        {
            case 0:                
                return String.class;               
            case 1:
                return String.class;              
            case 2:
                return String.class;              
            case 3:
                return Boolean.class;
            default:
                return null;
        }   
    }

    public int getColumnCount()
    {
        return columnNames.length; 
    }
    public Object getValueAt(int row, int col)
    {
        ResourceType resourcestype=(ResourceType)resourcestypes.toArray()[row];
        switch(col)
        {
            case 0:                
                return resourcestype.getName();                
            case 1:
                return resourcestype.getTopicMapName();
            case 2:
                return resourcestype.getDescription();                
            case 3:
                return resourcestype.isSelected();
            default:
                return null;
        }        
    }
    public boolean isCellEditable(int row, int col)
    {
        if(col==3)
        {
            return true; 
        }
        else
        {
            return false; 
        }
        
    }
    public void setValueAt(Object ovalue, int row, int col) {
        if(ovalue instanceof Boolean)
        {
            Boolean value=(Boolean)ovalue;
            ResourceType resourcestype=(ResourceType)resourcestypes.toArray()[row];
            switch(col)
            {
               case 3:
                    resourcestype.setSelected(value.booleanValue());
            } 
        }
    }

   public int compare(Object o1, Object o2) {
        if(o1 instanceof ResourceType && o2 instanceof ResourceType)
        {
            ResourceType r1=(ResourceType)o1;
            ResourceType r2=(ResourceType)o2;
            return r1.getName().compareTo(r2.getName());
        }
        return 0;
    }    
    
}
