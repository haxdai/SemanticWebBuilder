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
 * ActivityGModel.java
 *
 * Created on 9 de noviembre de 2004, 11:05 PM
 */

package applets.workflowadmin;
import javax.swing.table.*;
import java.util.*;
import javax.swing.*;
/**
 * Modelo que representa actividades, usado en la pesta�a Dise�o dentro de
 * formulario del flujo.
 * @author Victor Lorenzana
 */
public class ActivityGModel  extends AbstractTableModel{
    ArrayList activities=new ArrayList();
    private String[] columnNames =new String[5];
    Locale locale;
    /** Creates a new instance of ActivityGModel */
    public ActivityGModel(Locale locale) {
        this.locale=locale;
        columnNames[0]=java.util.ResourceBundle.getBundle("applets/workflowadmin/ActivityGModel",locale).getString("step");
        columnNames[1]=java.util.ResourceBundle.getBundle("applets/workflowadmin/ActivityGModel",locale).getString("activity");
        columnNames[2]=java.util.ResourceBundle.getBundle("applets/workflowadmin/ActivityGModel",locale).getString("description");
        columnNames[3]=java.util.ResourceBundle.getBundle("applets/workflowadmin/ActivityGModel",locale).getString("rols");
        columnNames[4]=java.util.ResourceBundle.getBundle("applets/workflowadmin/ActivityGModel",locale).getString("users");
    }
    public ActivityG getActivity(int index)
    {
        return (ActivityG)activities.get(index);
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public void addActivity(ActivityG activity)
    {
        this.activities.add(activity);
    }
     public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    public void clear()
    {
        this.activities.clear();
    }
    public int getRowCount() {
        return activities.size();
    }
    public Object getValueAt(int row, int col)
    {
        ActivityG activity=(ActivityG)activities.toArray()[row];        
        switch(col)
        {
            case 0:                
                return activity.getStep();
            case 1:                
                return activity.getName();                
            case 2:
                return activity.getDescription();   
            case 3:
                String rols="";
                if(activity.getActivity()!=null && activity.getActivity().getRoleModel()!=null)
                {
                    int iRoles=activity.getActivity().getRoleModel().getRowCount();                    
                    for(int i=0;i<iRoles;i++)
                    {
                        Role role=activity.getActivity().getRoleModel().getRole(i);
                        rols+=role.getName()+" , ";
                    }
                }
                if(rols.endsWith(" , "))
                {
                    rols=rols.substring(0,rols.length()-3);
                }
                return rols;
            case 4:
                String users="";
                if(activity.getActivity()!=null && activity.getActivity().getUserModel()!=null)
                {
                    int iUsers=activity.getActivity().getUserModel().getRowCount();                                    
                    for(int i=0;i<iUsers;i++)
                    {
                        User user=activity.getActivity().getUserModel().getUser(i);                        
                        users+=user.getName()+" , ";                        
                    }
                }
                if(users.endsWith(" , "))
                {
                    users=users.substring(0,users.length()-3);
                }
                return users;
            default:
                return null;
        }        
    }
    public Iterator iterator()
    {
        return this.activities.iterator();
    }
    public boolean isCellEditable(int row, int col)
    {
        
        return false; 
    }    
    
}
