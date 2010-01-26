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
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.platform;

import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.db.IDBConnection;
import com.hp.hpl.jena.db.ModelRDB;
import com.hp.hpl.jena.db.impl.Driver_Derby_SWB;
import com.hp.hpl.jena.db.impl.Driver_HSQLDB_SWB;
import com.hp.hpl.jena.db.impl.Driver_HSQL_SWB;
import com.hp.hpl.jena.db.impl.Driver_MsSQL_SWB;
import com.hp.hpl.jena.db.impl.Driver_MySQL_SWB;
import com.hp.hpl.jena.db.impl.Driver_Oracle_SWB;
import com.hp.hpl.jena.db.impl.Driver_PostgreSQL_SWB;
import com.hp.hpl.jena.db.impl.IRDBDriver;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.sdb.SDBFactory;
import com.hp.hpl.jena.sdb.StoreDesc;
import com.hp.hpl.jena.sdb.Store;
import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.rdf.model.NsIterator;
import com.hp.hpl.jena.sdb.sql.SDBConnection;
import com.hp.hpl.jena.sdb.store.DatabaseType;
import com.hp.hpl.jena.sdb.store.LayoutType;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.hp.hpl.jena.util.FileManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.db.DBConnectionPool;
import org.semanticwb.rdf.RemoteGraph;

/**
 *
 * @author Jei
 */
public class SemanticMgr implements SWBInstanceObject
{
    private static Logger log = SWBUtils.getLogger(SemanticMgr.class);

    public final static String SWBSystem="SWBSystem";
    public final static String SWBAdmin="SWBAdmin";
    public final static String SWBOntEdit="SWBOntEdit";
    
    private SemanticOntology m_ontology;
//    private SemanticModel m_system;
    //private HashMap<String,SemanticModel> m_schemas;
    private SemanticOntology m_schema;
    private HashMap<String,SemanticModel>m_models=null;
    private HashMap<String,SemanticModel>m_nsmodels=null;
    private HashMap<Model,SemanticModel>m_imodels=null;

    private IDBConnection conn;
    private ModelMaker maker;
    private Store store;
    
    private SemanticVocabulary vocabulary;

    private ArrayList<SemanticObserver> m_observers=null;

    private CodePackage codepkg=null;

    private Timer timer;                        //Commiter

    public void init() 
    {
        log.event("Initializing SemanticMgr...");

        codepkg=new CodePackage();
        
        m_models=new HashMap();                     //Arreglo de SemanticModel por name
        m_nsmodels=new HashMap();                   //Arreglo de SemanticModel por NS
        m_imodels=new HashMap();                    //Arreglo de RDFModel
        //m_schemas=new HashMap();
        m_observers=new ArrayList();

        //Create Schema
        m_schema = new SemanticOntology("SWBSquema",ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_TRANS_INF));
        //Create Ontology
        m_ontology = new SemanticOntology("SWBOntology",ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM));
        //m_ontology = new SemanticOntology("SWBOntology",ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RDFS_INF));

        //Agrega ontologia a los modelos
        SemanticModel ontModel=new SemanticModel("swb_ontology", m_ontology.getRDFOntModel());
//        m_models.put("swb_ontology", ontModel);
        m_imodels.put(ontModel.getRDFModel(), ontModel);

        //Agrega squema a los modelos
        SemanticModel ontSchemaModel=new SemanticModel("swb_schema", m_schema.getRDFOntModel());
//        m_models.put("swb_schema", ontSchemaModel);
        //para busqueda inversa
        m_imodels.put(ontSchemaModel.getRDFModel(), ontSchemaModel);
    }

    public void initializeDB()
    {
        DBConnectionPool pool=SWBUtils.DB.getDefaultPool();
//        String M_DB_URL         = pool.getURL();
//        String M_DB_USER        = pool.getUser();
//        String M_DB_PASSWD      = pool.getPassword();
        String M_DB             = SWBUtils.DB.getDatabaseType(pool.getName());

        if(SWBPlatform.createInstance().getPersistenceType().equalsIgnoreCase(SWBPlatform.PRESIST_TYPE_SDB))
        {
            StoreDesc sd=new StoreDesc(LayoutType.LayoutTripleNodesHash,DatabaseType.fetch(M_DB));
            //SDBConnection con=new SDBConnection(M_DB_URL, M_DB_USER, M_DB_PASSWD);
            SDBConnection con=new SDBConnection(SWBUtils.DB.getDefaultPool().newAutoConnection());
            //SDBConnection con=new SDBConnection_SWB();
            store = SDBFactory.connectStore(con,sd);
            //Revisar si las tablas existen
            List list=store.getConnection().getTableNames();
            System.out.println("list:"+list);
            if(!list.contains("nodes") && !list.contains("triples") && !list.contains("quads"))
            {
                log.event("Formating Database Tables...");
                store.getTableFormatter().create();
            }
        }else if(SWBPlatform.createInstance().getPersistenceType().equalsIgnoreCase(SWBPlatform.PRESIST_TYPE_TDB))
        {
            System.out.println("TDB Detected...,"+SWBPlatform.createInstance().getPlatformWorkPath()+"/data");
            timer=new Timer();
            timer.schedule(new TimerTask()
            {
                @Override
                public void run() {
                    commit();
                }
            },60000,10000);
        }else
        {
            // create a database connection
            //conn = new DBConnection(M_DB_URL, M_DB_USER, M_DB_PASSWD, M_DB);

            // Create database connection
            conn = new DBConnection(SWBUtils.DB.getDefaultPool().newAutoConnection(), M_DB);

            IRDBDriver driver=null;
            if(M_DB.equals(SWBUtils.DB.DBTYPE_MySQL)){driver=new Driver_MySQL_SWB();}
            else if(M_DB.equals(SWBUtils.DB.DBTYPE_Derby)){driver=new Driver_Derby_SWB();}
            else if(M_DB.equals(SWBUtils.DB.DBTYPE_HSQL)){driver=new Driver_HSQLDB_SWB();}
            else if(M_DB.equals(SWBUtils.DB.DBTYPE_MsSQL)){driver=new Driver_MsSQL_SWB();}
            else if(M_DB.equals(SWBUtils.DB.DBTYPE_Oracle)){driver=new Driver_Oracle_SWB();}
            else if(M_DB.equals(SWBUtils.DB.DBTYPE_PostgreSQL)){driver=new Driver_PostgreSQL_SWB();}

            driver.setConnection(conn);
            conn.setDriver(driver);
            conn.getDriver().setTableNamePrefix("swb_");
            conn.getDriver().setDoDuplicateCheck(false);

            maker = ModelFactory.createModelRDBMaker(conn);
        }
        //System.out.println("End initializeDB");
    }

    public SemanticModel addBaseOntology(String owlPath)
    {
        Model model=SWBPlatform.getSemanticMgr().loadRDFFileModel(owlPath);
        SemanticModel smodel=new SemanticModel(new File(owlPath).getName(),model);
//            m_models.put(owlf.getName(),smodel);
//            m_imodels.put(model, smodel);
        getSchema().addSubModel(smodel,false);
        getOntology().addSubModel(smodel,false);


        //agregar todos los NS del schema
        Iterator it=smodel.getRDFModel().getNsPrefixMap().values().iterator();
        while(it.hasNext())
        {
            String key=(String)it.next();
            m_nsmodels.put(key, m_imodels.get(getSchema().getRDFOntModel()));
            log.debug("Add NS:"+key+" "+getSchema().getName());
        }

        //debugModel(swbSquema);
        return smodel;
    }

    public void loadBaseVocabulary()
    {
        //Create Vocabulary
        vocabulary=new SemanticVocabulary();
        Iterator<SemanticClass> tpcit=new SemanticClassIterator(m_schema.getRDFOntModel().listClasses());
        while(tpcit.hasNext())
        {
            SemanticClass cls=tpcit.next();
            vocabulary.registerClass(cls);
        }
        vocabulary.init();
    }

    public Model loadRDFRemoteModel(String uri)
    {
        Model model=null;
        try
        {
            URLConnection u=new URL(uri).openConnection();
            u.connect();
            model=ModelFactory.createModelForGraph(new RemoteGraph(uri));
            log.info("-->Loading Remote Model:"+uri);
        }catch(Exception e)
        {
            log.warn("-->Can´t create remote model:"+uri);
            //log.error("-->"+e.getMessage());
        }
        return model;
    }


    /**
     * Read remote RDFa Model from webpage
     * @param url = url of remote HTML webpage
     * @return RDF Model
     */
    public Model loadRDFaRemoteModel(String url)
    {
        return loadRDFaRemoteModel(url, "HTML");
    }
    /**
     * Read remote RDFa Model from webpage
     * @param url = url of remote webpage
     * @param lang = "HTML" or "XHTML", default HTML
     * @return RDF Model
     */
    public Model loadRDFaRemoteModel(String url, String lang)
    {
        Model model=null;
        try
        {
            Class.forName("net.rootdev.javardfa.RDFaReader");
            model = ModelFactory.createDefaultModel();
            if(lang==null)lang="HTML";
            model.read(url, lang);
            log.info("-->Loading Remote RDFa Model:"+url);
        }catch(Exception e)
        {
            log.warn("-->Can´t create remote RDFa model:"+url);
        }
        return model;
    }

    public SemanticModel loadRemoteModel(String name, String uri, String baseNS, boolean add2Ontology)
    {
        SemanticModel m=null;
        Model model=loadRDFRemoteModel(uri);
        if(model!=null)
        {
            m=new SemanticModel(name, model);
            m.setNameSpace(baseNS);
            //TODO:notify this
            m_models.put(name, m);
            m_nsmodels.put(baseNS, m);
            log.debug("Add NS:"+baseNS+" "+m.getName());
            m_imodels.put(m.getRDFModel(), m);
            //System.out.println("addModel:"+name+" hash:"+m.getRDFModel().toString());
            if(add2Ontology)m_ontology.addSubModel(m,false);
        }
        return m;
    }

    public SemanticModel loadRemoteRDFaModel(String name, String url, String lang, boolean add2Ontology)
    {
        SemanticModel m=null;
        Model model=loadRDFaRemoteModel(url,lang);
        if(model!=null)
        {
            m=new SemanticModel(name, model);
            //TODO
//            m.setNameSpace(baseNS);
//            //TODO:notify this
//            m_models.put(name, m);
//            m_nsmodels.put(baseNS, m);
//            log.debug("Add NS:"+baseNS+" "+m.getName());
//            m_imodels.put(m.getRDFModel(), m);
//            //System.out.println("addModel:"+name+" hash:"+m.getRDFModel().toString());
//            if(add2Ontology)m_ontology.addSubModel(m,false);
        }
        return m;
    }
    
    public Model loadRDFFileModel(String path)
    {
        return FileManager.get().loadModel(path);
    }

    public Model loadRDFFileModel(String path, String baseUri)
    {
        return FileManager.get().loadModel(path,baseUri,null);
    }

    public SemanticModel readRDFFile(String name, String path)
    {
        SemanticModel ret=null;
        Model m=loadRDFFileModel(path);
        if(m!=null)
        {
            ret=new SemanticModel(name, m);
        }
        return ret;
    }
    
    private Model loadRDFDBModel(String name)
    {
        Model ret=null;
        // create or open the default model
        if(SWBPlatform.createInstance().getPersistenceType().equals(SWBPlatform.PRESIST_TYPE_SDB))
        {
            ret=SDBFactory.connectNamedModel(store, name);
        }else if(SWBPlatform.createInstance().getPersistenceType().equals(SWBPlatform.PRESIST_TYPE_TDB))
        {
            ret=TDBFactory.createNamedModel(name,SWBPlatform.createInstance().getPlatformWorkPath()+"/data");
            System.out.println("loadRDFDBModel:"+name);
        }else
        {
            ret=maker.openModel(name);
            ((ModelRDB)(ret)).setDoFastpath(false);
            ((ModelRDB)(ret)).setQueryOnlyAsserted(true);
        }
        return ret;
    }

    
//    public void debugClasses(OntModel model)
//    {
//        log.debug("**************************** debugClasses ********************************");
//        for (Iterator i = model.listClasses();  i.hasNext(); ) {
//            // now list the classes
//            OntClass cls=(OntClass)i.next();
//            log.debug("cls:"+cls.getLocalName());
//            ExtendedIterator it=cls.listInstances();
//            while(it.hasNext())
//            {
//                log.trace("-->inst:"+it.next());
//            }
//            
//            log.debug("  is a Declared Propertie of " );
//            for (Iterator it2 = cls.listDeclaredProperties(false); it2.hasNext();) 
//            {
//                Property prop=(Property)it2.next();
//                log.trace("---->prop:"+prop);
//            }            
//        }        
//    }
    
//    public void debugResource(Resource res)
//    {
//        log.debug("**************************** debugModel ********************************");
//        StmtIterator i = res.listProperties();
//        while(i.hasNext()) 
//        {
//            Statement stm=i.nextStatement();
//            log.trace("stmt:"+stm.getSubject()+" "+stm.getPredicate()+" "+stm.getObject());
//        }        
//    }    
//    
    
//    public void debugModel(Model model)
//    {
//        log.debug("**************************** debugModel ********************************");
//        StmtIterator i = model.listStatements();
//        while(i.hasNext()) 
//        {
//            Statement stm=i.nextStatement();
//            log.trace("stmt:"+stm.getSubject()+" "+stm.getPredicate()+" "+stm.getObject());
//        }        
//    }    
    
    
    
    @Override
    public void finalize()
    {
        log.event("SemanticMgr stoped...");
        if(conn!=null)
        {
            try
            {
                //Close the database connection        
                conn.close();
            }catch(Exception e){log.error(e);}        
        }
    }
    
    public Set<Entry<String, SemanticModel>> getModels()
    {
        return m_models.entrySet();
    }
    
    public SemanticModel getModel(String name)
    {
        return m_models.get(name);
    }

    public SemanticModel getModelByNS(String nameSpace)
    {
        return m_nsmodels.get(nameSpace);
    }

    public SemanticModel getModel(Model model)
    {
        return m_imodels.get(model);
    }
    
    public void loadDBModels()
    {
        log.debug("loadDBModels");
        //LoadModels
        if(SWBPlatform.createInstance().getPersistenceType().equalsIgnoreCase(SWBPlatform.PRESIST_TYPE_SDB))
        {
            Dataset set=SDBFactory.connectDataset(store);
            Iterator<String>it=set.listNames();
            while(it.hasNext())
            {
                String name=it.next();
                log.trace("LoadingModel:"+name);
                SemanticModel model=loadDBModel(name);
            }
            set.close();
        }else if(SWBPlatform.createInstance().getPersistenceType().equalsIgnoreCase(SWBPlatform.PRESIST_TYPE_TDB))
        {
            Dataset set=TDBFactory.createDataset(SWBPlatform.createInstance().getPlatformWorkPath()+"/data");
            Iterator<String>it=set.listNames();
            while(it.hasNext())
            {
                String name=it.next();
                log.trace("LoadingModel:"+name);
                System.out.println("LoadingModel:"+name);
                SemanticModel model=loadDBModel(name);
            }
            set.close();
        }else
        {
            Iterator tpit=maker.listModels();
            while(tpit.hasNext())
            {
                String name=(String)tpit.next();
                log.trace("LoadingModel:"+name);
                loadDBModel(name);
            }
        }
    }
    
    /**
     * Load a Model, if the model don't exist, it will be created 
     * @param name
     * @return
     */
    private SemanticModel loadDBModel(String name)
    {
        Model model=loadRDFDBModel(name);
        if(name.equals(SWBAdmin) && !SWBPlatform.createInstance().isAdminDev())
        {
            //System.out.println(model);
            log.info("Loading SWBAdmin...");
            OntModel omodel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM,model);
            try
            {
                Model m = ModelFactory.createDefaultModel() ;
                FileInputStream in=new FileInputStream(SWBUtils.getApplicationPath()+SWBPlatform.createInstance().getAdminFile());
                m.read(in, null,"N-TRIPLE");
                omodel.addSubModel(m,true);
                in.close();
            }catch(Exception e){log.warn(e.getMessage());}
            model=omodel;
        }else if(name.equals(SWBAdmin))
        {
            NsIterator it=model.listNameSpaces();
            if(!it.hasNext())
            {
                log.info("Importing SWBAdmin...");
                it.close();
                try
                {
                    FileInputStream in=new FileInputStream(SWBUtils.getApplicationPath()+SWBPlatform.createInstance().getAdminFile());
                    if(model instanceof ModelRDB)
                    {
                        ModelRDB m=(ModelRDB)model;
                        try
                        {
                            //m.setDoDuplicateCheck( false );
                            m.begin();
                            m.read(in, null, "N-TRIPLE");
                            in.close();
                        }catch(Exception e){log.error(e);}
                        finally
                        {
                            m.commit();
                            //m.setDoDuplicateCheck(true);
                        }
                    }else
                    {
                        model.read(in, null, "N-TRIPLE");
                        in.close();
                    }
                }catch(Exception e){log.warn(e.getMessage());}
            }
        }else if(name.equals(SWBOntEdit) && !SWBPlatform.createInstance().isAdminDev())
        {
            log.info("Loading SWBOntEdit...");
            OntModel omodel=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM,model);
            try
            {
                Model m = ModelFactory.createDefaultModel();
                FileInputStream in=new FileInputStream(SWBUtils.getApplicationPath()+SWBPlatform.createInstance().getOntEditFile());
                m.read(in, null, "N-TRIPLE");
                omodel.addSubModel(m,true);
                in.close();
            }catch(Exception e){log.warn(e.getMessage());}
            model=omodel;
        }else if(name.equals(SWBOntEdit))
        {
            NsIterator it=model.listNameSpaces();
            if(!it.hasNext())
            {
                log.info("Importing Admin...");
                it.close();
                try
                {
                    FileInputStream in=new FileInputStream(SWBUtils.getApplicationPath()+SWBPlatform.createInstance().getOntEditFile());
                    if(model instanceof ModelRDB)
                    {
                        ModelRDB m=(ModelRDB)model;
                        try
                        {
                            //m.setDoDuplicateCheck( false );
                            m.begin();
                            m.read(in, null, "N-TRIPLE");
                            in.close();
                        }catch(Exception e){log.error(e);}
                        finally
                        {
                            m.commit();
                            //m.setDoDuplicateCheck(true);
                        }
                    }else
                    {
                        model.read(in, null, "N-TRIPLE");
                        in.close();
                    }
                }catch(Exception e){log.warn(e.getMessage());}
            }
        }
        SemanticModel m=new SemanticModel(name, model);
        //TODO:notify this
        m_models.put(name, m);
        m_nsmodels.put(m.getNameSpace(), m);
        log.debug("Add NS:"+m.getNameSpace()+" "+m.getName());
        m_imodels.put(m.getRDFModel(), m);
        //System.out.println("addModel:"+name+" hash:"+m.getRDFModel().toString());
        m_ontology.addSubModel(m,false);
        return m;
    }    
    
    public SemanticModel createModel(String name, String nameSpace)
    {
        //System.out.println("createModel:"+name+" "+nameSpace);
        SemanticModel ret=loadDBModel(name);
        Model model=ret.getRDFModel();
//        model.setNsPrefix(name+"_"+SemanticVocabulary.SWB_NS, nameSpace);
//        model.setNsPrefix(name, SemanticVocabulary.URI+SemanticVocabulary.SWB_NS);
        model.setNsPrefix(name, nameSpace);
        //model.setNsPrefixes(m_schema.getRDFOntModel().getNsPrefixMap());
        return ret;
    }

    public SemanticModel createModelByRDF(String name, String namespace, InputStream in)
    {
        return createModelByRDF(name, namespace, in, null);
    }

    public SemanticModel createModelByRDF(String name, String namespace, InputStream in,String lang)
    {
        SemanticModel ret=createModel(name, namespace);
        Model model=ret.getRDFModel();
        try
        {
            if(model instanceof ModelRDB)
            {
                ModelRDB m=(ModelRDB)model;
                try
                {
                    //m.setDoDuplicateCheck( false );
                    m.begin();
                    m.read(in, null, lang);
                    in.close();
                }catch(Exception e){log.error(e);}
                finally
                {
                    m.commit();
                    //m.setDoDuplicateCheck(true);
                }
            }else
            {
                model.read(in, null, lang);
                in.close();
            }        
//        ret.getRDFModel().read(in, null,lang);
//        try
//        {
//            in.close();
        }catch(Exception e){log.error(e);}
        return ret;
    }
     
    public void removeModel(String name)
    {
        SemanticModel model=m_models.get(name);
        //TODO:notify this
        m_models.remove(name);
        m_nsmodels.remove(model.getNameSpace());
        m_imodels.remove(model.getRDFModel());
        m_ontology.removeSubModel(model,true);
        if(SWBPlatform.createInstance().getPersistenceType().equals(SWBPlatform.PRESIST_TYPE_SDB))
        {
            model.getRDFModel().removeAll();
        }else if(SWBPlatform.createInstance().getPersistenceType().equals(SWBPlatform.PRESIST_TYPE_TDB))
        {
            //TDBFactory.createModel(SWBPlatform.getWorkPath()+"/models/"+name+"/data");
            model.getRDFModel().removeAll();
        }else
        {
            maker.removeModel(name);
        }
    }
            
    public SemanticOntology getOntology() 
    {
        return m_ontology;
    }
    
    public SemanticOntology getSchema()
    {
        return m_schema;
    }

//    public SemanticModel getSchemaModel(String name)
//    {
//        return m_schemas.get(name);
//    }
    
//    public SemanticModel getSystemModel()
//    {
//        return m_system;
//    }
    
//    public OntClass getOntClass(String uri)
//    {
//        return m_ontology.getRDFOntModel().getOntClass(uri);
//    }
    
    public SemanticVocabulary getVocabulary() {
        return vocabulary;
    }

    public void registerObserver(SemanticObserver obs)
    {
        m_observers.add(obs);
    }

    public void removeObserver(SemanticObserver obs)
    {
        m_observers.remove(obs);
    }

    public void notifyChange(SemanticObject obj, Object prop, String action)
    {
        log.trace("obj:"+obj+" prop:"+prop+" "+action);
        if(obj.getURI()!=null)
        {
            if(prop !=null && prop instanceof SemanticProperty)
            {
                if(((SemanticProperty)prop).isNotObservable())return; //No es observable
            }
            Iterator it=m_observers.iterator();
            while(it.hasNext())
            {
                SemanticObserver obs=(SemanticObserver)it.next();
                try
                {
                    obs.notify(obj, prop, action);
                }catch(Exception e){log.error(e);}
            }
        }
    }

    /**
     *
     * @return
     */
    public CodePackage getCodePackage()
    {
        return codepkg;
    }

    /**
     * Commit all models
     */
    public void commit()
    {
        System.out.println("ServerMgr.Commit()");
        Iterator<SemanticModel> it=m_models.values().iterator();
        while (it.hasNext())
        {
            SemanticModel model = it.next();
            model.getRDFModel().commit();
        }
    }

    /**
     * Close all models
     */
    public void close()
    {
        System.out.println("ServerMgr.Close()");
        Iterator<SemanticModel> it=m_models.values().iterator();
        while (it.hasNext())
        {
            SemanticModel model = it.next();
            model.getRDFModel().close();
        }
    }

    /**
     * Destroy method for this filter
     *
     */
    public void destroy()
    {
        close();
    }
}
