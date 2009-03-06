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
 * Activities.java
 *
 * Created on 27 de octubre de 2004, 08:00 PM
 */

package applets.workflowadmin;

import java.util.*;
/**
 * Clase coleccion de actividades
 * @author Victor Lorenzana
 */
public class Activities extends Vector{
    
    /** Creates a new instance of Activities */
    public Activities() {
    }    
    public Activity getActivity(int index)
    {
        return (Activity)this.toArray()[index];
    }
    public void addActivity(Activity activity)
    {
        add(this.size(),activity);               
    }  
    public void insertFirst(Activity activity)
    {
        this.add(0, activity);
    }
    public int down(Activity activity)
    {
        int pos=this.lastIndexOf(activity);        
        if(pos>=0)
        {
            if(pos!=this.size()-1)
            {
                this.removeElementAt(pos);                
                this.add(pos+1, activity);                
            }            
        }
        return pos=this.lastIndexOf(activity);
    }
    public int up(Activity activity)
    {
        int pos=this.lastIndexOf(activity);
        if(pos>=1)
        {
            this.removeElementAt(pos);
            this.add(pos-1, activity);
        }
        return pos=this.lastIndexOf(activity);
    }
    
}
