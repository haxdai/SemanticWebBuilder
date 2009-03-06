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
 * jTableRolesModel.java
 *
 * Created on 12 de octubre de 2004, 04:13 PM
 */

package applets.workflowadmin;
import javax.swing.table.*;
import java.util.*;
/**
 * Clase que representa el modelo de datos para roles que se muestran al editar un
 * actividad a traves de una tabla.
 * @author Victor Lorenzana
 */
public class jTableRolesModel extends AbstractTableModel{
    
    private String[] columnNames =new String[2];
     Vector roles=new Vector();
    /** Creates a new instance of jTableActivities */
     public jTableRolesModel(Locale locale)
     {
         columnNames[0]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableRolesModel",locale).getString("Rol");
         columnNames[1]=java.util.ResourceBundle.getBundle("applets/workflowadmin/jTableRolesModel",locale).getString("Utilizar");
    }
    public void addRole(Role role)
    {
        this.roles.add(role);
    }
    public void clear()
    {
        this.roles.clear();
    }
    public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    public int getRowCount() 
    {
        return this.roles.size();
    }
    public int size()
    {
        return roles.size();
    }
    public Role getRole(int index)
    {
        return (Role)roles.toArray()[index];
    }
    public Class getColumnClass(int col)
    {      
        
        switch(col)
        {
            case 0:                
                return String.class;               
            case 1:
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
        Role role=(Role)roles.toArray()[row];
        switch(col)
        {
            case 0:                
                return role.getName();                
            case 1:
                return new Boolean(role.isChecked());
            default:
                return null;
        }        
    }
    public boolean isCellEditable(int row, int col)
    {
        if(col==1)
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
            Role role=(Role)roles.toArray()[row];
            switch(col)
            {
               case 1:
                    role.setChecked(value.booleanValue());
            } 
        }
    }
    
}
