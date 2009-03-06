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
 * Activity.java
 *
 * Created on 11 de octubre de 2004, 06:49 PM
 */

package applets.workflowadmin;
import java.util.*;
/**
 * Clase que representa una actividad dentro de un flujo de publicaci�n.
 * @author Victor Lorenzana
 */
public class Activity
{
    
    String name;
    String description;
    jTableRolesModel rolemodel;
    jTableUserModel usermodel;
    
    Links links=new Links();
    
    /** Creates a new instance of Activity */
    int dias=0;    
    int horas=0;
    boolean hasDuration;
    boolean enviaraviso=false;
    
    
    public Activity(String name,String description,Locale locale)
    {
        this.name=name;
        this.description=description;
        setLocale(locale);
        
    }  
    public Activity(String name,String description)
    {
        this.name=name;
        this.description=description;        
        
    } 
    public void setLocale(Locale locale)
    {
        rolemodel=new jTableRolesModel(locale);
        usermodel=new jTableUserModel(locale);
    }
    
    
    
    public Links getLinks()
    {
        return links;
    }
    public void setAviso(boolean enviaraviso)
    {
        this.enviaraviso=enviaraviso;
    }
    public boolean hasAviso()
    {
        return enviaraviso;
    }
    public void setDuraction(boolean hasDuration)
    {
        this.hasDuration=hasDuration;
        this.dias=0;        
        this.horas=0;
    }
    public void setDuraction(int dias,int horas)
    {
        this.dias=dias;        
        this.horas=horas;
        if(dias==0 && horas==0)
        {
            this.hasDuration=false;
        }
        else
        {
            this.hasDuration=true;
        }
    }
    public boolean hasDuration()
    {
        return hasDuration;
    }
    public void addLink(Link link)
    {
        this.links.add(link);
    }
     
    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return this.description;
    }
    public jTableRolesModel getRoleModel()
    {
        return rolemodel;
    }
    public jTableUserModel getUserModel()
    {
        return usermodel;
    }
   
    public void setName(String name)
    {
        this.name=name;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public int getDias()
    {
        return dias;
    }
    public void setDias(int dias)
    {
        this.dias=dias;
    }
    public int getHours()
    {
        return this.horas;
    }
    public void setHours(int horas)
    {
        this.horas=horas;
    }
    
    
    
    public boolean equals(Object obj)
    {
        if(obj instanceof Activity)
        {
            Activity activity=(Activity)obj;
            if(activity.getName().equals(this.getName()))
            {
                return true;
            }
        }
        return false;
    }
    
}
