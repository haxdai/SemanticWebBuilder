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
 * jTableLinkModel.java
 *
 * Created on 8 de noviembre de 2004, 09:52 PM
 */

package applets.workflowadmin;
import javax.swing.table.*;
import java.util.*;
import javax.swing.*;
/**
 * Clase que representa un modelo de datos para Links, que se san en las tablas de
 * secuencia de una actividad.
 * @author Victor Lorenzana
 */
public class jTableLinkModel extends AbstractTableModel
{
    private String[] columnNames =new String[2];
    /** Creates a new instance of jTableLinkModel */
    HashSet links=new HashSet();
    JTable table;
    /** Creates a new instance of jTableActivities */
     public jTableLinkModel(Locale locale) {         
         columnNames[0]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableActivitiesModel",locale).getString("Actividad");
         columnNames[1]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableActivitiesModel",locale).getString("Descripcion");
         
    }
     public HashSet getLinks()
     {
        return links;
     }
     public jTableLinkModel(JTable table) {         
         this.table=table;
         
    }
     public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    public int getRowCount() 
    {
        return links.size();
    }
    public int getColumnCount()
    {
        return columnNames.length; 
    }
    
    public Object getValueAt(int row, int col)
    {
        Link link=(Link)links.toArray()[row];
        switch(col)
        {
            case 0:                
                return link.getActivityTo().getName();                
            case 1:
                return link.getActivityTo().getDescription();                
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
    public Link getLink(int index)
    {
        return (Link)this.links.toArray()[index];
    }
    public void addLink(Link link)
    {
        links.add(link);                
        
        if(table!=null)
            table.updateUI();        
    }
    public int size()
    {
        return this.links.size();
    }
    public boolean contains(Link link)
    {
        return this.links.contains(link);
    }
    public void clear()
    {
        this.links.clear();
    }
    public void setTable(JTable table)
    {
        this.table=table;
    }     
    public void removeLink(Link link)
    {
        this.links.remove(link);
        if(table!=null)
            table.updateUI();
        
    }
    
}
