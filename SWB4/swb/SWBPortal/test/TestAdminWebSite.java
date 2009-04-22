import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.junit.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Calendarable;
import org.semanticwb.model.Language;
import org.semanticwb.model.ObjectBehavior;
import org.semanticwb.model.PFlowRefable;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.RoleRefable;
import org.semanticwb.model.Roleable;
import org.semanticwb.model.Rule;
import org.semanticwb.model.RuleRefable;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.Template;
import org.semanticwb.model.TemplateGroup;
import org.semanticwb.model.TemplateRef;
import org.semanticwb.model.TemplateRefable;
import org.semanticwb.model.UserRepository;
import org.semanticwb.model.VersionInfo;
import org.semanticwb.model.Versionable;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;



/**
 *
 * @author Jei
 */
public class TestAdminWebSite {
    

    public TestAdminWebSite()
    {
    }

    @BeforeClass
    public static void setUpClass() throws Exception
    {
        //SWBUtils.createInstance("D:/programming/proys/SWB4/swb/build/web/");
        SWBPlatform.createInstance(null);
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    public ResourceType createResourceType(WebSite site, String name, String clsName, int type, String pkg)
    {
        ResourceType pt=site.getResourceType(name);
        if(pt==null)
        {
            pt=site.createResourceType(name);
            pt.setTitle(name);
            pt.setResourceMode(type);
            pt.setResourceClassName(pkg+"."+clsName);
            pt.setResourceBundle(pkg+"."+clsName);
            return pt;
        }
        return null;
    }

    public ObjectBehavior createBehavior(WebSite site, String id, String title, String sort)
    {
        ObjectBehavior obj=ObjectBehavior.getObjectBehavior(id, site);
        if(obj==null)
        {
            obj=ObjectBehavior.createObjectBehavior(id, site);
            obj.setTitle(title);
            obj.setSortName(sort);
            obj.setActive(true);
            return obj;
        }
        return null;
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    //@Test
    public void Admin()
    {
        WebSite site=SWBContext.getAdminWebSite();
        
        if(site==null)
        {
            site=SWBContext.createWebSite("SWBAdmin", "http://www.semanticwb.org/SWBAdmin");
            site.setTitle("Admin");
            site.setDescription("Admin WebSite");
            site.setActive(true);
            
            //Crear lenguajes por defecto
            Language lang=site.createLanguage("es");
            lang.setTitle("Español", "es");
            lang.setTitle("Spanish", "en");
            lang.setTitle("Spanish", "pt");
            lang=site.createLanguage("en");
            lang.setTitle("Ingles", "es");
            lang.setTitle("English", "en");
            lang.setTitle("English", "pt");
            lang=site.createLanguage("pt");
            lang.setTitle("Ingles", "es");
            lang.setTitle("English", "en");
            lang.setTitle("English", "pt");
            
            //Set User Repository
            UserRepository urep=SWBContext.getDefaultRepository();
            site.setUserRepository(urep);
            
            TemplateGroup grp=site.createTemplateGroup();
            grp.setTitle("Default");
            Template tpl=site.createTemplate();
            tpl.setActive(true);
            tpl.setTitle("Main");
            tpl.setGroup(grp);
            
            VersionInfo version=site.createVersionInfo();
            version.setVersionNumber(1);
            version.setVersionFile("template.html");
            tpl.setActualVersion(version);
            tpl.setLastVersion(version);
            
            tpl=site.createTemplate();
            tpl.setActive(true);
            tpl.setTitle("Content");           
            tpl.setGroup(grp);

            version=site.createVersionInfo();
            version.setVersionNumber(1);
            version.setVersionFile("template.html");
            tpl.setActualVersion(version);
            tpl.setLastVersion(version);                       

            tpl=site.createTemplate();
            tpl.setActive(true);
            tpl.setTitle("Content Ajax");
            tpl.setGroup(grp);

            version=site.createVersionInfo();
            version.setVersionNumber(1);
            version.setVersionFile("template.html");
            tpl.setActualVersion(version);
            tpl.setLastVersion(version);
            
            WebPage home=site.createWebPage("home");
            home.setTitle("Home");
            site.setHomePage(home);
            home.setActive(true);

            TemplateRef tplref=site.createTemplateRef();
            tplref.setTemplate(site.getTemplate("1"));
            tplref.setActive(true);
            tplref.setPriority(3);
            site.getHomePage().addTemplateRef(tplref);
        }



        WebPage home=site.getHomePage();
        WebPage ob=site.getWebPage("ObjectBehavior");
        if(ob==null)
        {
            ob=site.createWebPage("ObjectBehavior");
            ob.setActive(true);
            ob.setTitle("Comportamientos");
            ob.setParent(home);

            TemplateRef tplref=site.createTemplateRef();
            tplref.setTemplate(site.getTemplate("3"));
            tplref.setActive(true);
            tplref.setPriority(3);
            ob.addTemplateRef(tplref);
        }

        ResourceType pt=null;
        Resource p=null;

        //Create Resource Types
        pt=createResourceType(site, "JSPResource", "JSPResource",1,"org.semanticwb.portal.resources");
        pt=createResourceType(site, "SemObjPropRefEditor", "SWBASOPropRefEditor",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "CreateUser", "SWBACreateUser",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "DBSparql", "SWBADBSparql",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "Editor", "SWBAEditor",1,"org.semanticwb.portal.admin.resources");
        if(pt!=null)
        {
            p=site.createResource();
            p.setResourceType(pt);
            p.setTitle("Editor");
            p.setActive(true);
        }
        //p=site.getResource("1");
        //p.setResourceType(site.getResourceType("Editor"));
        pt=createResourceType(site, "ExportWebSite", "SWBExportWebSite",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "ImportWebSite", "SWBImportWebSite",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "Logs", "SWBALogs",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "MMemory", "SWBAMMemory",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "Properties", "SWBAProperties",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "Rule", "SWBARule",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "Schedule", "SWBASchedule",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "SearchUsers", "SWBASearchUsers",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "VersionInfo", "SWBAVersionInfo",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "WebPageContents", "SWBAWebPageContents",1,"org.semanticwb.portal.admin.resources");
        pt=createResourceType(site, "GlobalReport", "WBAGlobalReport",1,"org.semanticwb.portal.admin.resources");
        //createResourceType(site, "XX", "XX",1,"org.semanticwb.portal.admin.resources");

        ObjectBehavior obj=createBehavior(site,"bh_Information","Información","10");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("JSPResource"));
            p.setTitle("Information");
            p.setActive(true);
            p.setPriority(3);
            p.setAttribute("jsppath","/swbadmin/jsp/SemObjectEditor.jsp");
            try
            {
                p.updateAttributesToDB();
            }catch(Exception e){e.printStackTrace();}
            obj.addResource(p);
            obj.setParent(ob);
        }

        obj=createBehavior(site,"bh_Contents","Contenidos","20");
        if(obj!=null)
        {
            obj.setBehaviorParams("sprop=swb:hasResource");
            p=site.createResource();
            p.setResourceType(site.getResourceType("WebPageContents"));
            p.setTitle("Contents");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setInterface(Resourceable.swb_Resourceable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_TemplateEdit","Editar Platilla","20");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("JSPResource"));
            p.setTitle("Edit Template");
            p.setActive(true);
            p.setPriority(3);
            p.setAttribute("jsppath","/swbadmin/jsp/templateEdit.jsp");
            try
            {
                p.updateAttributesToDB();
            }catch(Exception e){e.printStackTrace();}
            obj.addResource(p);
            obj.setParent(ob);
            obj.setInterface(Template.sclass.getSemanticObject());
        }

        obj=createBehavior(site,"bh_RuleEditor","Editar Regla","20");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("Rule"));
            p.setTitle("Edit Rule");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setInterface(Rule.sclass.getSemanticObject());
        }

        obj=createBehavior(site,"bh_Templates","Plantillas","20");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("SemObjPropRefEditor"));
            p.setTitle("Templates");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setBehaviorParams("sprop=swb:hasTemplateRef&spropref=swb:template");
            obj.setInterface(TemplateRefable.swb_TemplateRefable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_AdminPorltet","Administrar","30");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("JSPResource"));
            p.setTitle("Admin Resource");
            p.setActive(true);
            p.setPriority(3);
            p.setAttribute("jsppath","/swbadmin/jsp/editResource.jsp");
            try
            {
                p.updateAttributesToDB();
            }catch(Exception e){e.printStackTrace();}
            obj.addResource(p);
            obj.setParent(ob);
            obj.setInterface(Resource.sclass.getSemanticObject());
        }

        obj=createBehavior(site,"bh_PFlows","Flujos de Publicación","40");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("SemObjPropRefEditor"));
            p.setTitle("PFlows");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setBehaviorParams("sprop=swb:hasPFlowRef&spropref=swb:pflow");
            obj.setInterface(PFlowRefable.swb_PFlowRefable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_Versions","Versiones","50");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("VersionInfo"));
            p.setTitle("Version");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setInterface(Versionable.swb_Versionable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_Roles","Roles","60");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("SemObjPropRefEditor"));
            p.setTitle("Roles");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setBehaviorParams("sprop=swb:hasRoleRef&spropref=swb:role");
            obj.setInterface(RoleRefable.swb_RoleRefable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_RolesDirect","Roles","65");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("SemObjPropRefEditor"));
            p.setTitle("Roles Direct");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setBehaviorParams("sprop=swb:hasRole&spropref=swb:hasRole");
            obj.setInterface(Roleable.swb_Roleable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_Rules","Reglas","70");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("SemObjPropRefEditor"));
            p.setTitle("Rules");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setBehaviorParams("sprop=swb:hasRuleRef&spropref=swb:rule");
            obj.setInterface(RuleRefable.swb_RuleRefable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_Schedule","Calendarización","80");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("Schedule"));
            p.setTitle("Schedule");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
            obj.setBehaviorParams("sprop=swb:hasCalendar");
            obj.setInterface(Calendarable.swb_Calendarable.getSemanticObject());
        }

        obj=createBehavior(site,"bh_Log","Bitácora","90");
        if(obj!=null)
        {
            p=site.createResource();
            p.setResourceType(site.getResourceType("Logs"));
            p.setTitle("Logs");
            p.setActive(true);
            p.setPriority(3);
            obj.addResource(p);
            obj.setParent(ob);
        }

    }

    @Test
    public void writeAdmin()
    {
        WebSite site=SWBContext.getAdminWebSite();
        System.out.println("********"+SWBUtils.getApplicationPath());
        File file=new File(SWBUtils.getApplicationPath()+"../web/swbadmin/rdf/SWBAdmin.rdf");
        try
        {
            System.out.println("file:"+file.getCanonicalPath());
            FileOutputStream out=new FileOutputStream(file);
            site.getSemanticObject().getModel().write(out);
        }catch(Exception e){e.printStackTrace();}

        site=SWBContext.getOntEditor();
        System.out.println("********"+SWBUtils.getApplicationPath());
        file=new File(SWBUtils.getApplicationPath()+"../web/swbadmin/rdf/SWBOntEdit.rdf");
        try
        {
            System.out.println("file:"+file.getCanonicalPath());
            FileOutputStream out=new FileOutputStream(file);
            site.getSemanticObject().getModel().write(out);
        }catch(Exception e){e.printStackTrace();}
    }

}
