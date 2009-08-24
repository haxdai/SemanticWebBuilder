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
 
package org.semanticwb.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.base.SWBContextBase;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticVocabulary;

public class SWBContext extends SWBContextBase
{
    private static Logger log=SWBUtils.getLogger(SWBContext.class);
    
    public static String WEBSITE_ADMIN="SWBAdmin";
    public static String WEBSITE_ONTEDITOR="SWBOntEdit";
    public static String WEBSITE_GLOBAL="SWBGlobal";
    public static String USERREPOSITORY_DEFAULT="urswb";
    public static String USERREPOSITORY_ADMIN="uradm";

    private static ArrayList<String> filtered=new ArrayList();
    
    private static SWBContext instance=null;
    static public synchronized SWBContext createInstance()
    {
        if (instance == null)
        {
            instance = new SWBContext();
        }
        return instance;
    }
    
    private SWBContext()
    {
        log.event("Initializing SemanticWebBuilder Context...");
        filtered.add(WEBSITE_ADMIN);
        filtered.add(WEBSITE_ONTEDITOR);
        //filtered.add(WEBSITE_GLOBAL);
    }
    
    public static WebSite getAdminWebSite()
    {
        return getWebSite(WEBSITE_ADMIN);
    }
    
    public static WebSite getOntEditor()
    {
        return getWebSite(WEBSITE_ONTEDITOR);
    }
    
    public static WebSite getGlobalWebSite()
    {
        return getWebSite(WEBSITE_GLOBAL);
    }    
    
    public static UserRepository getDefaultRepository()
    {
        return getUserRepository(USERREPOSITORY_DEFAULT);
    }

    public static UserRepository getAdminRepository()
    {
        return getUserRepository(USERREPOSITORY_ADMIN);
    }
    
    public static FormView getFormView(String id)
    {
        FormView view=null;
        if(id!=null)
        {
            SemanticObject obj=SemanticObject.createSemanticObject(SemanticVocabulary.SWBXF_URI+id);
            if(obj!=null)
            {
                view=(FormView)obj.createGenericInstance();
            }
            //System.out.println("id:"+id+" obj:"+obj);
        }
        return view;
    }

    public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSites()
    {
        return listWebSites(false);
    }


    public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSites(boolean direct)
    {
        if(SWBPlatform.getEnv("swb/adminShow","false").equals("false"))
        {
            ArrayList<org.semanticwb.model.WebSite> arr=new ArrayList();

            Iterator<Entry<String,SemanticModel>> it=SWBPlatform.getSemanticMgr().getModels().iterator();
            while(it.hasNext())
            {
                Entry<String,SemanticModel> entry=it.next();
                SemanticModel model=entry.getValue();
                GenericObject gen=model.getModelObject().createGenericInstance();
                if(gen instanceof WebSite && !filtered.contains(gen.getId())) arr.add((WebSite)gen);
            }
            return arr.iterator();
        }else
        {
            return (java.util.Iterator<org.semanticwb.model.WebSite>)swb_WebSite.listGenericInstances(direct);
            //return SWBContextBase.listWebSites();
        }
    }

    /**
     *
     */
    public static class UTILS {

        public static String getIconClass(SemanticObject obj)
        {
            //System.out.println("getIconClass:"+obj);
            String ret=null;
            SemanticClass cls=obj.getSemanticClass();
            if(cls.hasProperty(Iconable.swb_iconClass.getName()))
            {
                ret=obj.getProperty(Iconable.swb_iconClass);
            }

            if(ret==null)
            {
                SemanticObject cobj=cls.getDisplayObject();
                if(cobj!=null)
                {
                    ret=cobj.getProperty(DisplayObject.swb_iconClass);
                }
            }

            if(ret==null)ret="swbIcon"+cls.getName();
            
            //if(ret!=null)
            {
                //System.out.println("getIconClass:1");
                if(cls.hasProperty(Activeable.swb_active.getName()))
                {
                    if(!obj.getBooleanProperty(Activeable.swb_active))
                    {
                        ret+="U";
                        return ret;
                    }
                    //System.out.println("getIconClass:2");
                }
                if(cls.hasProperty(SWBClass.swb_valid.getName()))
                {
                    if(!obj.getBooleanProperty(SWBClass.swb_valid))
                    {
                        ret+="W";
                        return ret;
                    }
                    //System.out.println("getIconClass:2");
                }
                if(cls.hasProperty(RoleRefable.swb_hasRoleRef.getName()))
                {
                    if(obj.listValidObjectProperties(RoleRefable.swb_hasRoleRef).hasNext())
                    {
                        ret+="F";
                        return ret;
                    }
                    //System.out.println("getIconClass:3");
                }
                if(cls.hasProperty(UserGroupRefable.swb_hasUserGroupRef.getName()))
                {
                    if(obj.listValidObjectProperties(UserGroupRefable.swb_hasUserGroupRef).hasNext())
                    {
                        ret+="F";
                        return ret;
                    }
                    //System.out.println("getIconClass:4");
                }
                if(cls.hasProperty(RuleRefable.swb_hasRuleRef.getName()))
                {
                    if(obj.listValidObjectProperties(RuleRefable.swb_hasRuleRef).hasNext())
                    {
                        ret+="F";
                        return ret;
                    }
                }
                if(cls.hasProperty(CalendarRefable.swb_hasCalendarRef.getName()))
                {
                    if(obj.listValidObjectProperties(CalendarRefable.swb_hasCalendarRef).hasNext())
                    {
                        ret+="F";
                        return ret;
                    }
                }
                if(cls.hasProperty(Versionable.swb_actualVersion.getName()))
                {
                    if(obj.getObjectProperty(Versionable.swb_actualVersion)==null)
                    {
                        ret+="W";
                        return ret;
                    }
                }

            }
            return ret;
        }
    }

}