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
 * Workflow.java
 *
 * Created on 11 de octubre de 2004, 06:50 PM
 */

package applets.workflowadmin;

import java.util.*;

import applets.commons.*;
/**
 * Clase que representa el flujo que se esta creado o modificando.
 * @author Victor Lorenzana
 */
public class Workflow {
    
    boolean canEdit=false;
    String id;
    String name;
    String description;
    String version="1.0";
    jTableActivitiesModel modelactivities;
    jTableResourceTypeModel modelresoources;
    public Workflow(Locale locale) {
        modelactivities=new jTableActivitiesModel(locale);
    }
    public Workflow(WBTreeNode eworkflow,String id,Locale locale) { 
        this(locale);
        modelresoources=new jTableResourceTypeModel(locale);
        this.id=id;
        
        name=eworkflow.getAttribute("name");
        version=eworkflow.getAttribute("version");        
        if(eworkflow.getAttribute("canEdit")!=null && !eworkflow.getAttribute("canEdit").equals("") && eworkflow.getAttribute("canEdit").equals("true"))
        {
            this.canEdit=true;            
        }
        
        WBTreeNode edescription=eworkflow.getNodebyName("description");
        if(edescription!=null)
        {
            this.description=edescription.getFirstNode().getText();
        }  
        Iterator activities=eworkflow.getNodesbyName("activity");        
        while(activities.hasNext())
        {
            WBTreeNode eactivity=(WBTreeNode)activities.next();
            String type=eactivity.getAttribute("type");            
            if(type.equals("EndActivity"))
            {
                this.modelactivities.addActivity(new EndActivity(locale));   
            }
            else if(type.equals("AuthorActivity"))
            {
                this.modelactivities.addActivity(new AuthorActivity(locale));   
            }
            else
            {                
                
                String desc="";

                WBTreeNode edesc=eactivity.getNodebyName("description");

                if(edesc!=null)
                {
                    desc=edesc.getFirstNode().getText();
                }
                Activity activity=new Activity(eactivity.getAttribute("name"), desc,locale);                
                this.modelactivities.addActivity(activity);   
                
                int days=0;
                int minutes=0;
                int seconds=0;
                int hours=0;
                try
                {
                    days=Integer.parseInt(eactivity.getAttribute("days"));                    
                    if(eactivity.getAttribute("hours")!=null && !eactivity.getAttribute("hours").equals(""))
                    {
                        hours=Integer.parseInt(eactivity.getAttribute("hours"));
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace(System.out);
                }
                activity.setDuraction(days,hours);
                Iterator roles=eactivity.getNodesbyName("role");
                while(roles.hasNext())
                {
                    
                    WBTreeNode erole=(WBTreeNode)roles.next();
                    Role role=new Role(erole.getAttribute("id"),erole.getAttribute("name"),erole.getAttribute("repository"));
                    activity.getRoleModel().addRole(role);
                }
                Iterator users=eactivity.getNodesbyName("user");
                while(users.hasNext())
                {
                    WBTreeNode euser=(WBTreeNode)users.next();
                    User user=new User(euser.getAttribute("id"),euser.getAttribute("name"));
                    activity.getUserModel().addUser(user);
                }
                
            }            
          
            
            
        }
        
        Iterator links=eworkflow.getNodesbyName("link");
        while(links.hasNext())
        {
            WBTreeNode elink=(WBTreeNode)links.next();
            
            
           
            
            String type=elink.getAttribute("type");
            String nameto=elink.getAttribute("to");
            String namefrom=elink.getAttribute("from");
            Activity activityto=null,activityfrom=null;
            activities=this.getActivitiesModel().getActivities().iterator();
            while(activities.hasNext())
            {
                Activity activity=(Activity)activities.next();
                if(activity.getName().equals(nameto))
                {
                    activityto=activity;
                }
                if(activity.getName().equals(namefrom))
                {
                    activityfrom=activity;
                }
            }
            
            if(activityto!=null && activityfrom!=null)
            {
                String linktype=elink.getAttribute("type");
                Link link=new Link(activityto, activityfrom,linktype);
                Iterator itNotifications=elink.getNodesbyName("notification");
                while(itNotifications.hasNext())
                {
                    WBTreeNode eNotification=(WBTreeNode)itNotifications.next();
                    if(eNotification.getAttribute("type").equals("user"))
                    {
                        String userid=eNotification.getAttribute("to");
                        User user=new User(userid, "");
                        link.addUser(user);
                    }
                    else
                    {
                        String roleID=eNotification.getAttribute("to");
                        String repository=eNotification.getAttribute("repository");
                        Role role=new Role(roleID,"",repository);
                        link.addRole(role);
                    }
                }
                link.setAuthorized(Boolean.valueOf(elink.getAttribute("authorized")).booleanValue());
                link.setPublish(Boolean.valueOf(elink.getAttribute("publish")).booleanValue());
                activityfrom.getLinks().add(link);
            }
        }
        Iterator resourceTypes=eworkflow.getNodesbyName("resourceType");
        while(resourceTypes.hasNext())
        {
            WBTreeNode resourceType=(WBTreeNode)resourceTypes.next();
            String idres=resourceType.getAttribute("id");
            ResourceType rs=new ResourceType(idres, "","",resourceType.getAttribute("topicmap"),"");
            this.getResourcesModel().addResourceType(rs);
        }
        boolean again=true;
        do
        {
            Iterator it=this.getActivitiesModel().getActivities().iterator();
            Activity actdel=null;
            while(it.hasNext())
            {
                Activity activity=(Activity)it.next();
                if(activity instanceof EndActivity || activity instanceof AuthorActivity)
                {
                    actdel=activity;
                }
            }
            if(actdel!=null)
            {
                this.getActivitiesModel().getActivities().remove(actdel);
                again=true;
            } 
            else
            {
                again=false;
            }
        }while(again);
        
    }
    public String getDescription()
    {
        return this.description;
    }
    public String getName()
    {
        return name;
    }
    public void setID(String id)
    {
        this.id=id;
    }
    public String getID()
    {
        return id;
    }
    public String getVersion()
    {
        return version;
    }
    public jTableActivitiesModel getActivitiesModel()
    {        
        return this.modelactivities;
    }
    public jTableResourceTypeModel getResourcesModel()
    {
        return this.modelresoources;
    }
    public void setCanEdit(boolean canEdit)
    {
        this.canEdit=canEdit;
    }
    public boolean canEdit()
    {
        return this.canEdit;
    }
}
