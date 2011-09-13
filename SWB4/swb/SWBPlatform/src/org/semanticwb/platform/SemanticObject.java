/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.platform;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.rdf.model.impl.LiteralImpl;
import com.hp.hpl.jena.vocabulary.RDF;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.URLEncoder;
import org.semanticwb.model.GenericObject;
import org.w3c.dom.Document;

/**
 *
 * @author javier.solis.g
 */
public class SemanticObject 
{
    /** The log. */
    private static Logger log = SWBUtils.getLogger(SemanticObject.class);

    /** The Constant ACT_CREATE. */
    public static final String ACT_CREATE="CREATE";

    /** The Constant ACT_REMOVE. */
    public static final String ACT_REMOVE="REMOVE";

    /** The Constant ACT_ADD. */
    public static final String ACT_ADD="ADD";

    /** The Constant ACT_SET. */
    public static final String ACT_SET="SET";

    /** The Constant ACT_CLONE. */
    public static final String ACT_CLONE="CLONE";

    /** The m_objs. */
    private static Map<String, SemanticObject>m_objs=new ConcurrentHashMap<String, SemanticObject>();
    
    /** The has cache. */
    private static boolean hasCache=true;        

    /** The m_genobj. */
    private GenericObject m_genobj=null;

    /** The m_res. */
    private Resource m_res = null;

    /** The m_model. */
    private SemanticModel m_model = null;
    //Virtual properties
    /** The m_cls. */
    private SemanticClass m_cls = null;

    /** The m_virtual. */
    private boolean m_virtual = false;
        
    private List<Statement> m_props=Collections.synchronizedList(new ArrayList());
    private List<Statement> m_propsInv=null;
    
    /** The lastaccess. */
    private long lastaccess=System.currentTimeMillis();
    
    /** The m_cachepropsrel. */
    private Map m_cachepropsrel=new ConcurrentHashMap<String, Object>();                    //Cache de objetos relacionados a la propiedad    
    
    //No cambian
    /** The ext get methods. */
    private static HashMap<String, Method> extGetMethods=new HashMap();

    /** The ext set methods. */
    private static HashMap<String, Method> extSetMethods=new HashMap();    
    
    /** The wrapper to primitive. */
    private static HashMap<Class,Class> wrapperToPrimitive = new HashMap();
    
    static {
            wrapperToPrimitive.put( Boolean.class, Boolean.TYPE );
            wrapperToPrimitive.put( Byte.class, Byte.TYPE );
            wrapperToPrimitive.put( Short.class, Short.TYPE );
            wrapperToPrimitive.put( Character.class, Character.TYPE );
            wrapperToPrimitive.put( Integer.class, Integer.TYPE );
            wrapperToPrimitive.put( Long.class, Long.TYPE );
            wrapperToPrimitive.put( Float.class, Float.TYPE );
            wrapperToPrimitive.put( Double.class, Double.TYPE );
    }    
    
    public SemanticObject()             
    {
        m_virtual=true;
    }

    public SemanticObject(SemanticModel smodel, SemanticClass scls)             
    {
        m_model=smodel;
        m_cls=scls;
        m_virtual=true;
        m_res=smodel.getRDFModel().createResource();
    }
    
    public SemanticObject(SemanticModel smodel, Resource res, StmtIterator stit) 
    {
        m_model=smodel;
        m_res=res;
        init(stit);
    }
    
    private void init(StmtIterator stit)
    {
        boolean classfound=false;
        while (stit.hasNext()) 
        {            
            Statement st = stit.next();
            m_props.add(st);
            
            if(st.getPredicate().equals(RDF.type))
            {
                if(!classfound)
                {
                    m_cls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(st.getResource().getURI());
                    if(m_cls!=null && m_cls.isSWBClass())
                    {
                        classfound=true;
                        //System.out.println("ClassFound");
                    }
                    //System.out.println("Class:"+m_cls);
                }            
            }
        }
        stit.close();
    }
    
    private void initInverse(StmtIterator stit)
    {
        while (stit.hasNext()) 
        {            
            Statement st = stit.next();
            m_propsInv.add(st);
        }
        stit.close();
    }    
    
    public void reloadProps()
    {
        if(m_res!=null)
        {
            m_props.clear();    
            m_cachepropsrel.clear();
            init(m_res.listProperties());
        }
    }
    
    public void reloadInvProps()
    {
        if(m_propsInv==null)m_propsInv=Collections.synchronizedList(new ArrayList());
        else m_propsInv.clear();
        if(m_res!=null)
        {
            initInverse(m_model.getRDFModel().listStatements(null, null, m_res));
        }
    }  
    
    public void clearInvProps()
    {
        m_propsInv=null;
    }
    
    
    private List getProps()
    {
        return m_props;
    }
    
    private List getPropsInv()
    {
        if(m_propsInv==null)
        {
            reloadInvProps();
        }
        return m_propsInv;
    }
    
    
    /*********************************************** statics ****************************************************************/    
    
    /**
     * Regresa instancia del SemanticObject si existe en Cache, de lo contrario
     * regresa null.
     *
     * @param uri the uri
     * @return the semantic object
     * @return
     */
    public static SemanticObject getSemanticObject(String uri)
    {
        SemanticObject ret=null;
        if(hasCache && null!=uri)ret=m_objs.get(uri);
        return ret;
    }    
    
    /**
     * Regrea una instancia del SemanticObject en base al URI dado.
     * Si el recurso no existe regresa null
     *
     * @param uri the uri
     * @return the semantic object
     * @return
     */
    public static SemanticObject createSemanticObject(String uri)
    {
        return createSemanticObject(uri, null);
    }
    
    /**
     * Creates the semantic object.
     *
     * @param res the res
     * @return the semantic object
     */
    public static SemanticObject createSemanticObject(Resource res)
    {
        //System.out.println("createSemanticObject:"+res);
        if(res==null)return null;
        String uri=res.getURI();
        if(uri!=null)
        {
            return createSemanticObject(uri);
        }else //Anonimos
        {
            SemanticModel smodel=SWBPlatform.getSemanticMgr().getModel(res.getModel());
            StmtIterator stit=res.listProperties();
            if(stit.hasNext())
            {
                return new SemanticObject(smodel,res,stit);
            }else
            {
                return null;
            }            
        }
    }    
    
    
    /**
     * Regrea una instancia del SemanticObject en base al URI dado en el modelo definido.
     * Si el recurso no existe regresa null
     *
     * @param uri the uri
     * @return the semantic object
     * @return
     */
    public static SemanticObject createSemanticObject(String uri, SemanticModel smodel)
    {
        if(null==uri)return null;
        //if(null==uri || uri.length()>0)return null;
        SemanticObject ret=getSemanticObject(uri);
        if(ret==null)
        {
            synchronized(SemanticObject.class)
            {
                ret=getSemanticObject(uri);
                if(ret==null)
                {
                    if(smodel!=null)
                    {
                        Resource res=smodel.getRDFModel().getResource(uri);
                        StmtIterator stit=res.listProperties();
                        if(stit.hasNext())
                        {
                            ret=new SemanticObject(smodel,res,stit);
                        }else
                        {
                            ret=null;
                        }
                    }else 
                    {
                        int i=uri.indexOf('#');
                        if(i==-1)i=uri.lastIndexOf('/');
                        if(i>0)
                        {
                            String base=uri.substring(0,i+1);
                            log.trace("getResource in Model(1):"+uri+" "+base);
                            SemanticModel model=SWBPlatform.getSemanticMgr().getModelByNS(base);
                            if(model!=null)
                            {
                                Resource res=model.getRDFModel().getResource(uri);
                                StmtIterator stit=res.listProperties();
                                if(stit.hasNext())
                                {
                                    ret=new SemanticObject(model,res,stit);
                                }else
                                {
                                    return null;
                                }
                            }
                        }

                        if(ret==null)
                        {
                            log.trace("getResource in Schema(2):");
                            //new Exception().printStackTrace();
                            Model bmodel=SWBPlatform.getSemanticMgr().getSchema().getRDFOntModel();
                            Resource res=bmodel.getResource(uri);
                            SemanticModel model=SWBPlatform.getSemanticMgr().getModel(res.getModel());
                            StmtIterator stit=res.listProperties();
                            if(stit.hasNext())
                            {
                                ret=new SemanticObject(model,res,stit);
                            }
                        }

                        if(ret==null)
                        {
                            log.trace("getResource in All Model(3):");
                            //new Exception().printStackTrace();
                            Iterator<Map.Entry<String, SemanticModel>> it=SWBPlatform.getSemanticMgr().getModels().iterator();
                            while(it.hasNext())
                            {
                                Map.Entry<String, SemanticModel> ent=it.next();
                                SemanticModel model=ent.getValue();
                                Resource res=model.getRDFModel().getResource(uri);
                                StmtIterator stit=res.listProperties();
                                if(stit.hasNext())
                                {
                                    ret=new SemanticObject(model,res,stit);
                                    break;
                                }
                            }
                        }


                    }
                    
                    //System.out.println("createSemanticObject:"+uri+" "+smodel+" "+ret);
                    
                    //TODO:Validar si puede agregarse a cache
                    if(hasCache && ret!=null)
                    {
                        m_objs.put(uri, ret);
                    }                    
                    
                }
            }
        }
        return ret;
    }        
    
    /**
     * Elimina el SemanticObject del cache
     * param uri del SemanticObject a eliminar del cache.
     *
     * @param uri the uri
     */
    public static void removeCache(String uri)
    {
        //System.out.println("removeCache:"+uri);
        m_objs.remove(uri);
    }


    /**
     * Elimina todos los SemanticObject del cache.
     */
    public static void clearCache()
    {
        m_objs.clear();
    }

    /**
     * Regresa numero de elementos en cache.
     *
     * @return the cache size
     */
    public static int getCacheSize()
    {
        return m_objs.size();
    }
    
    public static String shortToFullURI(String shorturi)
    {
        int pos=shorturi.indexOf("#");
        if(pos!=-1)
        {
            throw new IllegalArgumentException();
        }
        pos=shorturi.indexOf(":");
        if(pos!=-1)
        {
            String idmodel=shorturi.substring(0,pos);
            SemanticModel model=SWBPlatform.getSemanticMgr().getModel(idmodel);
            if(model!=null)
            {
                return model.getNameSpace()+shorturi.substring(pos+1);
            }
            throw new IllegalArgumentException("The model was not found "+idmodel);
        }
        else
        {
            throw new IllegalArgumentException("The separator ':' was not found in shorturi "+shorturi);
        }
    }    
    
    /*********************************************** instance ****************************************************************/    
    
    
    /**
     * Gets the URI.
     *
     * @return the URI
     */
    public String getURI()
    {
        String ret=null;
        if (m_res!=null)
        {
            ret=m_res.getURI();
        }
        return ret;
    }    
    
    public String getShortURI()
    {
        String getShortURI=getModel().getModelObject().getId();
        if(getURI()==null)
        {
            throw new IllegalArgumentException();
        }
        int pos=getURI().indexOf("#");
        if(pos!=-1)
        {
            getShortURI=getShortURI+":"+getURI().substring(pos+1);
        }
        else
        {
            throw new IllegalArgumentException();
        }
        return getShortURI;
    }
    
    /**
     * Gets the res id.
     *
     * @return String with the format prefix:localname
     */
    public String getResId()
    {
        if (m_res==null)
        {
            return null;
        }
        String ret=null;
        String pref=null;
        try
        {
            pref=getPrefix();
        }catch(Exception e){log.error("Error getting prefix of:"+this.getURI());}
        if(pref!=null)
        {
            ret=pref+":"+m_res.getLocalName();
        }else
        {
            ret=m_res.getLocalName();
        }
        if(ret==null || ret.length()==0)ret=getId();
        if(ret==null)ret=m_res.toString();
        return ret;
    }    
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId()
    {
        String id=getURI();
        if(id!=null)
        {
            int x = id.indexOf('#');
            if (x > -1)
            {
                id=id.substring(x + 1);
                x = id.indexOf(':');
                if (x > -1)
                {
                    id=id.substring(x + 1);
                }
            }
        }
        return id;
    } 
    
    /*
     * Regresa URI codificado para utilizar en ligas de html.
     *
     * @return URI Codificado
     */
    public String getEncodedURI()
    {
        return URLEncoder.encode(getURI());
    }
    
    /**
     * Gets the rDF name.
     *
     * @return the rDF name
     */
    public String getRDFName()
    {
        String ret=null;
        if (m_res!=null)
        {
            ret=m_res.getLocalName();
        }
        return ret;
    }    
    
    /**
     * Gets the prefix.
     *
     * @return the prefix
     */
    public String getPrefix()
    {
        String ret=null;
        if (m_res!=null && m_res.getNameSpace()!=null)
        {
            ret=m_res.getModel().getNsURIPrefix(m_res.getNameSpace());
        }
        return ret;
    }    
    
    /**
     * Regresa el Modelo de del SemanticObject.
     *
     * @return the model
     * @return
     */
    public SemanticModel getModel()
    {
        return m_model;
    }   
    
    /**
     * Gets the rDF resource.
     *
     * @return the rDF resource
     */
    public Resource getRDFResource()
    {
        return m_res;
    }    
    
    /**
     * Gets the semantic class.
     *
     * @return the semantic class
     */
    public SemanticClass getSemanticClass()
    {
        return m_cls;
    }   
    
    /**
     * List semantic classes.
     *
     * @return the iterator
     */
    public Iterator<SemanticClass> listSemanticClasses()
    {
        return new SemanticClassIterator<SemanticClass>(listProperties(RDF.type));
    }       
    
    /**
     * Adds the semantic class.
     *
     * @param cls the cls
     */
    public void addSemanticClass(SemanticClass cls)
    {
        SWBPlatform.getSemanticMgr().notifyChange(this, cls, null, ACT_ADD);
        if (m_res!=null)
        {
            addResource(RDF.type, cls.getOntClass());
            reloadProps();
        }
    }

    /**
     * Removes the semantic class.
     *
     * @param cls the cls
     * @return the semantic object
     */
    public SemanticObject removeSemanticClass(SemanticClass cls)
    {
        SWBPlatform.getSemanticMgr().notifyChange(this, cls, null, ACT_REMOVE);
        if (m_res!=null)
        {
            Iterator<Statement> stit = listProperties(RDF.type);
            while (stit.hasNext())
            {
                Statement staux = stit.next();
                if (staux.getResource().getURI().equals(cls.getURI()))
                {
                    remove(staux);
                }
            }
            reloadProps();
        }
        return this;
    }    
    
    /**
     * Sets the rDF resource.
     *
     * @param res the new rDF resource
     */
    public void setRDFResource(Resource res)
    {
        m_res=res;
        m_model=SWBPlatform.getSemanticMgr().getModel(res.getModel());
        reloadProps();
        clearInvProps();
    }    
    
    
    /**
     * Checks if is virtual.
     *
     * @return true, if is virtual
     */
    public boolean isVirtual()
    {
        return m_virtual;
    }    
    
    
    /**
     * Regresa tiempo en milisegundos de la ultima consulta del objeto.
     *
     * @return the last access
     * @return
     */
    public long getLastAccess()
    {
        return lastaccess;
    }
    
    /**
     * Regresa una instancia del GenericObject asociado
     * Si ya existe una instancia la regresa, de lo contrario regresa null.
     *
     * @return the generic instance
     * @return
     */
    public GenericObject getGenericInstance()
    {
        lastaccess=System.currentTimeMillis();
        return m_genobj;
    }
    
    /**
     * Asigna una instancia GenericObject del objeto.
     *
     * @param gen the new generic instance
     * @return
     */
    private void setGenericInstance(GenericObject gen)
    {
        m_genobj=gen;
    } 
    
    /**
     * Regresa una instancia del GenericObject asociado
     * Si ya existe una instancia la regresa, de lo contrario la crea.
     *
     * @return the generic object
     * @return
     */
    public GenericObject createGenericInstance()
    {
        GenericObject gen=getGenericInstance();
        if(gen==null)
        {
            synchronized(this)
            {
                gen=getGenericInstance();
                if(gen==null)
                {
                    gen=createNewGenericIntance();
                    if(gen!=null)setGenericInstance(gen);
                }
            }
        }
        return gen;
    }

    /**
     * Crea una nueva instancia del GenericObject asociado
     * @return
     */
    public GenericObject createNewGenericIntance()
    {
        GenericObject gen=null;
        SemanticClass clazz=getSemanticClass();
        if(clazz==null)
        {
            log.error("SemanticObject("+this+") without SemanticClass...");
        }else
        {
            if(clazz.isSWBInterface())
            {
                Iterator<SemanticClass> classes=listSemanticClasses();
                while(classes.hasNext())
                {
                    SemanticClass tempClazz=classes.next();
                    if(tempClazz.isSWBClass())
                    {
                        clazz=tempClazz;
                        break;
                    }
                }
            }
            gen=clazz.construcGenericInstance(this);
        }
        return gen;
    }    
    
 //************************************************************** RDF BASE ***********************************************************   
    
    private Iterator<Statement> listProperties(Property prop)
    {
        ArrayList ret=new ArrayList();        
        List stmts=getProps();
        for(int x=0;x<stmts.size();x++)
        {
            Statement statement=(Statement)stmts.get(x);
            if(statement.getPredicate().equals(prop))
            {
                ret.add(statement);
            }
        }
        return ret.iterator();
    }
    
    private Statement getProperty(Property prop)
    {
        Iterator<Statement> it=listProperties(prop);
        if(it.hasNext())return it.next();
        return null;
    }   
    
    private void remove(Property prop)
    {
        if(!m_virtual)m_res.removeAll(prop);
        Object stmts[]=getProps().toArray();
        for(int x=0;x<stmts.length;x++)
        {
            Statement statement=(Statement)stmts[x];
            if(statement.getPredicate().equals(prop))
            {
                getProps().remove(statement);
            }       
        }
        m_cachepropsrel.remove(prop.getURI());
    }
    
    private boolean remove(Statement stmt)
    {
        if(getProps().remove(stmt))
        {
            if(!m_virtual)m_model.getRDFModel().remove(stmt);
            return true;
        }
        return false;
    }    
    
    private Statement addResource(Property prop, Resource obj)
    {
        Model m=m_model.getRDFModel();
        Statement stmt=m.createStatement(m_res, prop, obj);
        if(!m_virtual)m.add(stmt);
        getProps().add(stmt);        
        return stmt;
    }
    
    private Statement addLiteral(Property prop, Object obj)
    {
        Model m=m_model.getRDFModel();
        Statement stmt=m.createStatement(m_res, prop, m.createTypedLiteral(obj));
        if(!m_virtual)m.add(stmt);
        getProps().add(stmt);
        return stmt;        
    }
    
    private Statement addLiteral(Property prop, String obj, String lang)
    {
        Model m=m_model.getRDFModel();
        Statement stmt=m.createStatement(m_res, prop, m.createLiteral(obj, lang));
        if(!m_virtual)m.add(stmt);
        getProps().add(stmt);
        return stmt;        
    }    
    
    private Statement addLiteral(Property prop, String obj)
    {
        Model m=m_model.getRDFModel();
        
        Statement stmt=m.createStatement(m_res, prop, m.createLiteral(obj));
        if(!m_virtual)m.add(stmt);
        getProps().add(stmt);
        return stmt;        
    }    

//************************************************************** RDF Inv ***********************************************************   
 
    private Iterator<Statement> listInvProperties(Property prop)
    {
        ArrayList ret=new ArrayList();
        List stmts=getPropsInv();
        for(int x=0;x<stmts.size();x++)
        {
            Statement statement=(Statement)stmts.get(x);
            if(statement.getPredicate().equals(prop))
            {
                ret.add(statement);
            }
        }       
        return ret.iterator();
    }    
    
    
    private Statement getInvProperty(Property prop)
    {
        Iterator<Statement> it=listInvProperties(prop);
        if(it.hasNext())return it.next();
        return null;
    }       
    
    private boolean removeInv(Statement stmt)
    {
        if(getPropsInv().remove(stmt))
        {
            return true;
        }
        return false;
    }     
    
    private void removeInv(Property prop)
    {
        Object stmts[]=getPropsInv().toArray();
        for(int x=0;x<stmts.length;x++)
        {
            Statement statement=(Statement)stmts[x];
            if(statement.getPredicate().equals(prop))
            {
                getPropsInv().remove(statement);
            }       
        }        
    }    
    
    private void addInvStatement(Statement stmt)
    {
        getPropsInv().add(stmt);        
    }    
    
    
//************************************************************** RDF End ***********************************************************   
 
    
//    /**
//     * Elimina cache de propiedades del objeto.
//     */
//    public void resetCache()
//    {
//    }    
    
    @Override    
    public String toString()
    {
        if (m_res==null)
        {
            return super.toString();
        }
        return m_res.toString();
    }    
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override    
    public int hashCode()
    {
        if (m_res==null)
        {
            return super.hashCode();
        }
        return m_res.hashCode();
    }    
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        return hashCode() == obj.hashCode();
    }    
    
    /**
     * Instance of.
     *
     * @param cls the cls
     * @return true, if successful
     */
    public boolean instanceOf(SemanticClass cls)
    {
        boolean ret = false;
        SemanticClass cl = getSemanticClass();
        if (cl != null && (cl.equals(cls) || cl.isSubClass(cls)))
        {
            ret = true;
        }
        return ret;
    }
    
//***********************************************************************************************************************/

    /**
     * Gets the dom property.
     *
     * @param prop the prop
     * @return the dom property
     */
    public Document getDomProperty(SemanticProperty prop)
    {
        Document dom=(Document)m_cachepropsrel.get(prop.getURI());
        if(dom==null)
        {
            String xml=getProperty(prop);
            if(xml!=null)
            {
                dom=SWBUtils.XML.xmlToDom(xml);
            }
            if(dom==null)
            {
                dom=SWBUtils.XML.getNewDocument();
            }
            m_cachepropsrel.put(prop.getURI(), dom);
        }
        return dom;
    }


    /**
     * Gets the literal property.
     *
     * @param prop the prop
     * @return the literal property
     */
    public SemanticLiteral getLiteralProperty(SemanticProperty prop)
    {
        SemanticLiteral ret = null;
        if (m_res!=null)
        {
            Statement stm = null;
            
            stm = getProperty(prop.getRDFProperty());
            if (stm != null)
            {
                ret = new SemanticLiteral(stm);
            }
        }
        return ret;
    }

    /**
     * Gets the literal property.
     *
     * @param prop the prop
     * @param lang the lang
     * @return the literal property
     */
    public SemanticLiteral getLiteralProperty(SemanticProperty prop, String lang)
    {
        SemanticLiteral ret = null;
        if (m_res!=null)
        {
            Statement stm = null;
            stm=getLocaleStatement(prop,lang);
            if (stm != null)
            {
                ret = new SemanticLiteral(stm);
            }
        }
        return ret;
    }

    /**
     * Adds the literal property.
     *
     * @param prop the prop
     * @param literal the literal
     */
    public void addLiteralProperty(SemanticProperty prop, SemanticLiteral literal)
    {
        setLiteralProperty(prop, literal, false);
    }

    /**
     * Sets the literal property.
     *
     * @param prop the prop
     * @param literal the literal
     */
    public void setLiteralProperty(SemanticProperty prop, SemanticLiteral literal)
    {
        setLiteralProperty(prop, literal, true);
    }

    /**
     * Sets the literal property.
     *
     * @param prop the prop
     * @param literal the literal
     * @param replace the replace
     */
    protected void setLiteralProperty(SemanticProperty prop, SemanticLiteral literal, boolean replace)
    {
        //System.out.println(prop+" "+literal.getValue());
        //Thread.currentThread().dumpStack();
        if (m_res!=null)
        {
            Object obj=literal.getValue();
            String lang=literal.getLanguage();
            Statement stm = null;
            
            if(replace)
            {
                if(!prop.isLocaleable())
                {
                    //System.out.println("borrar:"+prop.getRDFProperty());                    
                    remove(prop.getRDFProperty());
                }else
                {
                    Iterator<Statement> stit = listProperties(prop.getRDFProperty());
                    while (stit.hasNext())
                    {
                        Statement staux = stit.next();
                        String lg = staux.getLanguage();
                        if(lg!=null && lg.length()==0)lg=null;
                        if ((lang==null && lg==null) || (lg != null && lg.equals(lang)))
                        {
                            remove(staux);
                        }
                    }
                }
            }
            
            if(obj!=null)
            {
                if(obj instanceof String)
                {
                    if(lang!=null)
                    {
                        addLiteral(prop.getRDFProperty(), (String)obj, literal.getLanguage());
                    }else
                    {
                        addLiteral(prop.getRDFProperty(), (String)obj);
                    }
                }else if(obj instanceof java.util.Date)
                {
                    addLiteral(prop.getRDFProperty(), SWBUtils.TEXT.iso8601DateFormat((java.util.Date)obj));
                }else
                {
                    addLiteral(prop.getRDFProperty(), obj);
                }
            }
        }
        
        if(replace)
        {
            SWBPlatform.getSemanticMgr().notifyChange(this, prop, literal.getLanguage(), ACT_SET);
        }else
        {
            SWBPlatform.getSemanticMgr().notifyChange(this, prop, literal.getLanguage(), ACT_ADD);
        }
    }

    /**
     * Removes the property.
     *
     * @param prop the prop
     * @return the semantic object
     */
    public SemanticObject removeProperty(SemanticProperty prop)
    {
        SWBPlatform.getSemanticMgr().notifyChange(this, prop, null, ACT_REMOVE);
        if (m_res!=null)
        {
            try
            {
                if (prop.isBinary())
                {
                    String value = getProperty(prop);
                    if (value != null)
                    {
                        String workPath = this.getWorkPath();
                        if (!(workPath.endsWith("\\") || workPath.equals("/")))
                        {
                            workPath += "/" + value;
                        }
                        SWBPlatform.createInstance().removeFileFromPlatformWorkPath(workPath);
                    }
                }
            }catch(Exception e){log.error(e);}

            Property iprop = prop.getRDFProperty();
            remove(iprop);
            
            //Eliminar cache inversos
            if(prop.isObjectProperty() && prop.isInverseOf())
            {
               Statement st=getProperty(prop.getRDFProperty());
               if(st!=null)
               {
                   Resource res=st.getResource();
                   if(res!=null && res.getURI()!=null)
                   {
                       SemanticObject sobj=getSemanticObject(res.getURI());
                       if(sobj!=null)sobj.removeInv(st);
                   }
               }
            }              
        }
        return this;
    }

    /**
     * Removes the property.
     *
     * @param prop the prop
     * @param lang the lang
     * @return the semantic object
     */
    public SemanticObject removeProperty(SemanticProperty prop, String lang)
    {
        SWBPlatform.getSemanticMgr().notifyChange(this, prop, lang, ACT_REMOVE);
        if (m_res!=null)
        {
            Iterator<Statement> stit = listProperties(prop.getRDFProperty());
            while (stit.hasNext())
            {
                Statement staux = stit.next();
                String lg = staux.getLanguage();
                if (lg != null && lg.equals(lang))
                {
                    remove(staux);
                }
            }
        }
        return this;
    }

    /**
     * Sets the object property.
     *
     * @param prop the prop
     * @param object the object
     * @return the semantic object
     */
    public SemanticObject setObjectProperty(SemanticProperty prop, SemanticObject object)
    {
        //System.out.println("setObjectProperty:"+prop+" "+object);
        if (m_res!=null)
        {
            Property iprop = prop.getRDFProperty();
            
            SemanticProperty inv=null;
            if(prop.isInverseOf())inv=prop.getInverse();
            
            Statement stm = getProperty(iprop);
            //System.out.println("stm:"+stm);
            if (stm != null)
            {
                //Borrar cache inversa anterior
                if(prop.isInverseOf())
                {
                    SemanticObject obj=getObjectProperty(prop);
                    if(obj!=null)
                    {
                        obj.removeInv(stm);
                    }
                }
                remove(stm);
            }
            
            if(object!=null)
            {
                Statement stmt2=addResource(iprop, object.getRDFResource());
                if(prop.isInverseOf())
                {
                    object.addInvStatement(stmt2);
                }
            }
            SWBPlatform.getSemanticMgr().notifyChange(this, prop, null, ACT_SET);
        }
        return this;
    }


     /**
     * Adds the object property.
     *
     * @param prop the prop
     * @param object the object
     * @return the semantic object
     */
    public SemanticObject addObjectProperty(SemanticProperty prop, SemanticObject object)
    {
        return addObjectProperty(prop, object, true);
    }



    /**
     * Adds the object property.
     *
     * @param prop the prop
     * @param object the object
     * @return the semantic object
     */
    public SemanticObject addObjectProperty(SemanticProperty prop, SemanticObject object, boolean notify)
    {
        if (m_res!=null)
        {
            Property iprop = prop.getRDFProperty();
            if(object!=null)
            {
                Statement stmt2=addResource(iprop, object.getRDFResource());
                if(prop.isInverseOf())
                {
                    object.addInvStatement(stmt2);
                }
            }            
            if(notify)SWBPlatform.getSemanticMgr().notifyChange(this, prop, "list", ACT_ADD);
        }
        return this;
    }



    /**
     * Removes the object property.
     *
     * @param prop the prop
     * @param object the object
     * @return the semantic object
     */
    public SemanticObject removeObjectProperty(SemanticProperty prop, SemanticObject object)
    {
        return removeObjectProperty(prop, object, true);
    }

     /**
     * Removes the object property.
     *
     * @param prop the prop
     * @param object the object
     * @return the semantic object
     */
    public SemanticObject removeObjectProperty(SemanticProperty prop, SemanticObject object, boolean notify)
    {
        if(notify) SWBPlatform.getSemanticMgr().notifyChange(this, prop, "list", ACT_REMOVE);
        
        if (m_res!=null && object!=null)
        {        
            Iterator<Statement> it = listProperties(prop.getRDFProperty());
            while (it.hasNext())
            {
                Statement stmt = it.next();
                if (object.getRDFResource().equals(stmt.getResource()))
                {
                    if(prop.isInverseOf())
                    {
                        SemanticObject obj=getObjectProperty(prop);
                        if(obj!=null)
                        {
                            obj.removeInv(stmt);
                        }
                    }                    
                    remove(stmt);
                }
            }
        }
        return this;
    }


    /**
     * List literal properties.
     *
     * @param prop the prop
     * @return the iterator
     */
    public Iterator<SemanticLiteral> listLiteralProperties(SemanticProperty prop)
    {
        ArrayList<SemanticLiteral> ret=new ArrayList();
        if (m_res!=null)
        {
            return new SemanticLiteralIterator(listProperties(prop.getRDFProperty()));
        }
        return ret.iterator();
    }

    /**
     * Removes the object property.
     *
     * @param prop the prop
     * @param object the object
     * @return the semantic object
     */
    public SemanticObject removeLiteralProperty(SemanticProperty prop, SemanticLiteral lit)
    {
        SWBPlatform.getSemanticMgr().notifyChange(this, prop, lit.getLanguage(), ACT_REMOVE);
        if (m_res!=null)
        {
            Iterator<Statement> it = listProperties(prop.getRDFProperty());
            while (it.hasNext())
            {
                Statement stmt = it.next();
                if (lit.getValue().equals(stmt.getLiteral().getValue()))
                {
                    remove(stmt);
                }
            }
        }
        return this;
    }

    /**
     * List properties.
     *
     * @return the iterator
     */
    public Iterator<SemanticProperty> listProperties()
    {
        HashSet<SemanticProperty> properties=new HashSet<SemanticProperty>();
        Iterator<Statement> props=getProps().iterator();
        while(props.hasNext())
        {
            Statement stmt=props.next();
            Property prop=stmt.getPredicate();
            properties.add(getModel().getSemanticProperty(prop.getURI()));
        }
        return properties.iterator();
    }

    /**
     * List object properties.
     *
     * @param prop the prop
     * @return the iterator
     */
    public Iterator<SemanticObject> listObjectProperties(SemanticProperty prop)
    {
        if (m_res!=null)
        {
            if (!prop.hasInverse())
            {
                return new SemanticIterator(listProperties(prop.getRDFProperty()));
            }
            else
            {
                return new SemanticIterator(listInvProperties(prop.getInverse().getRDFProperty()), true);
            }
        }else
        {
            return new ArrayList().iterator();
        }
    }

    /**
     * Filter valid objects.
     *
     * @param it the it
     * @return the iterator
     */
    private Iterator<SemanticObject> filterValidObjects(Iterator<SemanticObject> it)
    {
        SemanticClass cls=null;
        SemanticProperty valid=null;
        ArrayList list=new ArrayList();
        while(it.hasNext())
        {
            SemanticObject obj=it.next();
            boolean add=true;
            //System.out.println("obj:"+obj);
            if(cls==null)
            {
                cls=obj.getSemanticClass();
                valid=cls.getProperty("valid");
            }
            //System.out.println("cls:"+cls+" valid:"+valid);
            if(valid!=null)
            {
                if(!obj.getBooleanProperty(valid))add=false;
            }
            //System.out.println("add:"+add);
            if(add)list.add(obj);
        }
        return list.iterator();
    }

    /**
     * Regresa lista de objetos activos y no borrados relacionados por la propiedad
     * Si no encuentra en el objeto busca en los padres.
     *
     * @param prop the prop
     * @return the iterator
     * @return
     */
    public Iterator<SemanticObject> listInheritProperties(SemanticProperty prop)
    {
        Iterator it=listObjectProperties(prop);
        if(prop.isInheritProperty())
        {
            it=filterValidObjects(it);
            if(!it.hasNext())
            {
                SemanticObject parent=getHerarquicalParent();
                if(parent!=null)
                {
                    it=parent.listInheritProperties(prop);
                }
            }
        }
        return it;
    }

    /**
     * Regresa lista de objetos activos y no borrados relacionados por la propiedad.
     *
     * @param prop the prop
     * @return the iterator
     * @return
     */
    public Iterator<SemanticObject> listValidObjectProperties(SemanticProperty prop)
    {
        Iterator it=filterValidObjects(listObjectProperties(prop));
        return it;
    }

    /**
     * Checks for object property.
     *
     * @param prop the prop
     * @param obj the obj
     * @return true, if successful
     */
    public boolean hasObjectProperty(SemanticProperty prop, SemanticObject obj)
    {

        //System.out.println("hasObjectProperty:"+this+" prop:"+prop+" obj:"+obj);
        boolean ret=false;
        Iterator<SemanticObject> it=listObjectProperties(prop);
        while (it.hasNext()) {
            SemanticObject so = it.next();
            if(so.equals(obj))
            {
                ret=true;
                break;
            }
        }
        return ret;
    }

    /**
     * Checks for object property.
     *
     * @param prop the prop
     * @return true, if successful
     */
    public boolean hasObjectProperty(SemanticProperty prop)
    {
        return getObjectProperty(prop)!=null;
    }


    /**
     * Gets the object property.
     *
     * @param prop the prop
     * @return the object property
     */
    public SemanticObject getObjectProperty(SemanticProperty prop)
    {
        Iterator<SemanticObject> it=listObjectProperties(prop);
        if(it.hasNext()) return it.next();
        return null;
    }

    /**
     * Gets the object property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the object property
     */
    public SemanticObject getObjectProperty(SemanticProperty prop, SemanticObject defValue)
    {
        SemanticObject obj=getObjectProperty(prop);
        if(obj==null)obj=defValue;
        return obj;
    }


    /**
     * Gets the locale statement.
     *
     * @param prop the prop
     * @param lang the lang
     * @return the locale statement
     */
    private Statement getLocaleStatement(SemanticProperty prop, String lang)
    {
        //System.out.println(m_res+" "+prop+" "+lang);
        
        Iterator<Statement> stit = listProperties(prop.getRDFProperty());
        //System.out.println("->"+m_res.getProperty(prop.getRDFProperty()));
        Statement st = null;
        while (stit.hasNext())
        {
            Statement staux = stit.next();
            String lg = staux.getLanguage();
            if(lg!=null && lg.length()==0)lg=null;
            //System.out.println("-->"+lang+" "+lg+" "+staux);
            if ((lang==null && lg==null) || (lg != null && lg.equals(lang)))
            {
                st = staux;
                break;
            }
        }
        return st;
    }

    /**
     * External invoker get.
     *
     * @param prop the prop
     * @return the object
     */
    private Object externalInvokerGet(SemanticProperty prop)
    {
        //System.out.println("externalInvokerGet:"+prop);
        Object ret = null;
        if (!m_virtual)
        {
            GenericObject obj = createGenericInstance();
            Class cls = obj.getClass();
            Method method=extGetMethods.get(cls.getName()+"-"+prop.getURI());
            if(method==null)
            {
                String pre="get";
                if(prop.isBoolean())pre="is";
                String name = prop.getPropertyCodeName();
                if (name == null)
                {
                    name = prop.getName();
                }
                name = pre + name.substring(0, 1).toUpperCase() + name.substring(1);
                try
                {
                    method = cls.getMethod(name);
                    extGetMethods.put(cls.getName()+"-"+prop.getURI(), method);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
                //System.out.println(obj+" "+name+" "+cls+" "+method);
            }
            try
            {
                ret = method.invoke(obj);
            }
            catch (Exception e)
            {
                log.error(e);
            }
        //System.out.println("externalInvoker:"+ret);
        }
        return ret;
    }

    /**
     * External invoker set.
     *
     * @param prop the prop
     * @param values the values
     * @return the object
     */
    private Object externalInvokerSet(SemanticProperty prop, Object... values)
    {
//        System.out.println("externalInvokerSet:"+prop+" "+values);
        Object ret = null;
        if (!m_virtual)
        {
            Object vals[]=null;
            GenericObject obj = this.createGenericInstance();
            Class cls = obj.getClass();
            Method method=extSetMethods.get(cls.getName()+"-"+prop.getURI()+"-"+values.length);
            if(method==null)
            {
                String name = prop.getPropertyCodeName();
                if (name == null)
                {
                    name = prop.getName();
                }
                name = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
//                System.out.println("name:"+name);
                try
                {
                    Class types[]=null;
                    if(prop.isLocaleable())
                    {
                        types=new Class[values.length];
                        //vals=values;
                    }else
                    {
                        types=new Class[1];
                        //vals=new Object[1];
                        //vals[0]=values[0];
                    }

                    Object o=values[0];
                    if(o!=null)types[0]=o.getClass();
                    else
                    {
                        if(prop.isString())types[0]=String.class;
                        else if(prop.isDate())types[0]=Date.class;
                        else if(prop.isObjectProperty())types[0]=prop.getDomainClass().getObjectClass();
                    }
                    Class pri=wrapperToPrimitive.get(types[0]);
                    if(pri!=null)
                    {
                        types[0]=pri;
                    }

                    if(prop.isLocaleable() && values.length>1)
                    {
                        o=values[1];
                        if(o==null)types[1]=String.class;
                        else types[1]=o.getClass();
                    }
//                    System.out.println("getMethod:"+name+" "+types);
                    method = cls.getMethod(name,types);
                    extSetMethods.put(cls.getName()+"-"+prop.getURI()+"-"+values.length, method);
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }  // Movi la generación de "vals" a esta posición
            // por que si esta en caché se pasaba un null al invoke - MAPS
            if (prop.isLocaleable())
            {
                vals = values;
            } else
            {
                vals = new Object[1];
                vals[0] = values[0];
            }

            try
            {
                ret = method.invoke(obj,vals);
            }
            catch (Exception e)
            {
                log.error(e);
            }
        //System.out.println("externalInvoker:"+ret);
        }
        return ret;
    }

    /**
     * Removes the dependencies.
     *
     * @param stack the stack
     */
    public void removeDependencies(ArrayList<SemanticObject> stack)
    {
        Iterator<SemanticProperty> itp=getSemanticClass().listProperties();
        while(itp.hasNext())
        {
            SemanticProperty prop=itp.next();
            if(prop.isRemoveDependency())
            {
                //System.out.println(prop+" "+prop.isRemoveDependency());
                if(prop.getCardinality()==1)
                {
                    SemanticObject dep=getObjectProperty(prop);
                    if(dep!=null)
                    {
                        //System.out.println(dep);
                        try
                        {
                            if(!stack.contains(dep))dep.remove(stack);
                        }catch(Exception e){log.error(e);}
                    }
                }else
                {
                    Iterator<SemanticObject> it=listObjectProperties(prop);
                    while(it.hasNext())
                    {
                        SemanticObject dep=it.next();
                        //System.out.println(dep);
                        try
                        {
                            if(stack!=null && !stack.contains(dep))dep.remove(stack);
                        }catch(Exception e){log.error(e);}
                    }
                }
            }
        }
    }

//    /**
//     * Dispose.
//     */
//    public void dispose()
//    {
//        try
//        {
//            GenericObject gen=getGenericInstance();
//            if(gen!=null)gen.dispose();
//        }catch(Exception e){log.error(e);}
//
//        resetRelatedsCache();
//
//        removeCache(getURI());
//    }

    /**
     * Removes the.
     */
    public void remove()
    {
        remove(new ArrayList());
    }

    /**
     * Removes the.
     *
     * @param stack the stack
     */
    public void remove(ArrayList<SemanticObject> stack)
    {
        stack.add(this);
        if(getModel().getModelObject().equals(this))    //es un modelo
        {
            removeDependencies(stack);
            SWBPlatform.getSemanticMgr().removeModel(getId());
            SWBPlatform.getSemanticMgr().notifyChange(this, null, null, ACT_REMOVE);
        }else                                           //es un objeto
        {
            //TODO:revisar esto de vic
            Iterator<SemanticProperty> properties = this.getSemanticClass().listProperties();
            while (properties.hasNext())
            {
                SemanticProperty prop = properties.next();
                if (prop.isBinary())
                {
                    // removida manualmente por ser binaria
                    removeProperty(prop);
                }
                
                //Eliminar cache inversos
                if(prop.isObjectProperty() && prop.isInverseOf())
                {
                   Statement st=getProperty(prop.getRDFProperty());
                   if(st!=null)
                   {
                       Resource res=st.getResource();
                       if(res!=null && res.getURI()!=null)
                       {
                           SemanticObject sobj=getSemanticObject(res.getURI());
                           if(sobj!=null)sobj.removeInv(st);
                       }
                   }
                }                
            }
            SWBPlatform.getSemanticMgr().notifyChange(this, null, null, ACT_REMOVE);

            //Eliminar dependencias
            removeDependencies(stack);

            //Borrar objeto
            Resource res=getRDFResource();
            if(res!=null)
            {
                SemanticModel model=getModel();
                //System.out.println("remove1:"+res+" model:"+model);
                Iterator<Map.Entry<String,SemanticModel>> it=SWBPlatform.getSemanticMgr().getModels().iterator();
                while(it.hasNext())
                {
                    Map.Entry<String,SemanticModel> ent=it.next();
                    SemanticModel m=ent.getValue();
                    
                    
                    StmtIterator stit = m.getRDFModel().listStatements(null, null, getRDFResource());
                    while (stit.hasNext()) {
                        Statement st = stit.nextStatement();
                        SemanticObject obj=getSemanticObject(st.getSubject().getURI());
                        if(obj!=null)obj.getProps().remove(st);
                    }
                    stit.close();
                    
                    //System.out.println("remove2:"+res+" model:"+m);
                    m.getRDFModel().removeAll(null,null,res);
                    
                }
                model.getRDFModel().removeAll(res,null,null);
                //model.getRDFModel().removeAll(null,null,res);
            }
        }
        removeCache(getURI());
    }

    /**
     * Removes the properties.
     */
    public void removeProperties()
    {
        m_res.removeProperties();
        removeCache(this.getURI());
    }

/**
 * ***************************************************************************************************************.
 *
 * @param prop the prop
 * @param value the value
 * @return the semantic object
 */

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setProperty(SemanticProperty prop, String value)
    {
        return setProperty(prop, value,null);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setProperty(SemanticProperty prop, String value, boolean evalExtInvo)
    {
        return setProperty(prop, value,null,evalExtInvo);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param lang the lang
     * @return SemanticObject para cascada
     */
    public SemanticObject setProperty(SemanticProperty prop, String value, String lang)
    {
        return setProperty(prop, value, lang, true);
    }


    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param lang the lang
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setProperty(SemanticProperty prop, String value, String lang, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value,lang);
        }else
        {
            setLiteralProperty(prop, new SemanticLiteral(value, lang));
        }
        return this;
    }

    /**
     * Regresa valor de la Propiedad especificada.
     *
     * @param prop the prop
     * @return valor de la propiedad, si no existe la propiedad regresa null
     */
    public String getProperty(SemanticProperty prop)
    {
        return getProperty(prop, true);
    }

    /**
     * Regresa valor de la Propiedad especificada.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return valor de la propiedad, si no existe la propiedad regresa null
     */
    public String getProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getProperty(prop, null,evalExtInvo);
    }


    /**
     * Gets the property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the property
     */
    public String getProperty(SemanticProperty prop, String defValue)
    {
        return getProperty(prop,defValue, true);
    }

    /**
     * Gets the property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the property
     */
    public String getProperty(SemanticProperty prop, String defValue, boolean evalExtInvo)
    {
        String ret = null;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            Object aux = externalInvokerGet(prop);
            if (aux!=null)
            {
                ret = "" + aux;
            }
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop,null);
            if(lit!=null)
            {
                ret=lit.getString();
            }
        }
        if (ret == null)
        {
            ret = defValue;
        }
        return ret;
    }

    /**
     * Gets the property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param lang the lang
     * @return the property
     */
    public String getProperty(SemanticProperty prop, String defValue, String lang)
    {
        String ret=null;
        SemanticLiteral lit=getLiteralProperty(prop,lang);
        if(lit!=null)
        {
            ret=lit.getString();
        }
        if (ret == null)
        {
            ret = defValue;
        }
        return ret;
    }

    /**
     * Gets the locale property.
     *
     * @param prop the prop
     * @param lang the lang
     * @return the locale property
     */
    public String getLocaleProperty(SemanticProperty prop, String lang)
    {
        String ret = null;
        if (lang == null)
        {
            ret = getProperty(prop);
        }else
        {
            ret= getProperty(prop, null, lang);
            if(ret==null)
            {
                ret=getProperty(prop);
            }
        }
        return ret;
    }

    /**
     * Gets the int property.
     *
     * @param prop the prop
     * @return the int property
     */
    public int getIntProperty(SemanticProperty prop)
    {
        return getIntProperty(prop, true);
    }

    /**
     * Gets the int property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the int property
     */
    public int getIntProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getIntProperty(prop, 0, evalExtInvo);
    }

    /**
     * Gets the int property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the int property
     */
    public int getIntProperty(SemanticProperty prop, int defValue)
    {
        return getIntProperty(prop, defValue, true);
    }

    /**
     * Gets the int property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the int property
     */
    public int getIntProperty(SemanticProperty prop, int defValue, boolean evalExtInvo)
    {
        Integer ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(Integer)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getInt();
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setIntProperty(SemanticProperty prop, int value)
    {
        return setIntProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setIntProperty(SemanticProperty prop, int value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            setLiteralProperty(prop, new SemanticLiteral(new Integer(value)));
        }
        return this;
    }

    /**
     * Gets the long property.
     *
     * @param prop the prop
     * @return the long property
     */
    public long getLongProperty(SemanticProperty prop)
    {
        return getLongProperty(prop, true);
    }

    /**
     * Gets the long property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the long property
     */
    public long getLongProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getLongProperty(prop, 0L, evalExtInvo);
    }

    /**
     * Gets the long property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the long property
     */
    public long getLongProperty(SemanticProperty prop, long defValue)
    {
        return getLongProperty(prop, defValue, true);
    }

    /**
     * Gets the long property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the long property
     */
    public long getLongProperty(SemanticProperty prop, long defValue, boolean evalExtInvo)
    {
        Long ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(Long)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getLong();
            }
        }
        return ret;
    }

    /**
     * Sets the input stream property.
     *
     * @param prop the prop
     * @param value the value
     * @param name the name
     * @return the semantic object
     * @throws SWBException the sWB exception
     */
    public SemanticObject setInputStreamProperty(SemanticProperty prop, InputStream value, String name) throws SWBException
    {
        String workPath = this.getWorkPath();
        if (!(workPath.endsWith("\\") || workPath.equals("/")))
        {
            workPath += "/" + name;
        }
        setProperty(prop, name);
        SWBPlatform.createInstance().writeFileToPlatformWorkPath(workPath, value);
        return this;
    }

    /**
     * Gets the input stream property.
     *
     * @param prop the prop
     * @return the input stream property
     * @throws SWBException the sWB exception
     */
    public InputStream getInputStreamProperty(SemanticProperty prop) throws SWBException
    {
        String value = getProperty(prop);
        String workPath = this.getWorkPath();
        if (!(workPath.endsWith("\\") || workPath.equals("/")))
        {
            workPath += "/" + value;
        }
        return SWBPlatform.createInstance().getFileFromPlatformWorkPath(workPath);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setLongProperty(SemanticProperty prop, long value)
    {
        return setLongProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setLongProperty(SemanticProperty prop, long value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            setLiteralProperty(prop, new SemanticLiteral(new Long(value)));
        }
        return this;
    }

    /**
     * Gets the float property.
     *
     * @param prop the prop
     * @return the float property
     */
    public float getFloatProperty(SemanticProperty prop)
    {
        return getFloatProperty(prop, true);
    }

    /**
     * Gets the float property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the float property
     */
    public float getFloatProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getFloatProperty(prop, 0F, evalExtInvo);
    }

    /**
     * Gets the float property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the float property
     */
    public float getFloatProperty(SemanticProperty prop, float defValue)
    {
        return getFloatProperty(prop, defValue, true);
    }

    /**
     * Gets the float property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the float property
     */
    public float getFloatProperty(SemanticProperty prop, float defValue, boolean evalExtInvo)
    {
        Float ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(Float)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getFloat();
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setFloatProperty(SemanticProperty prop, float value)
    {
        return setFloatProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setFloatProperty(SemanticProperty prop, float value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            setLiteralProperty(prop, new SemanticLiteral(new Float(value)));
        }
        return this;
    }

    /**
     * Gets the double property.
     *
     * @param prop the prop
     * @return the double property
     */
    public double getDoubleProperty(SemanticProperty prop)
    {
        return getDoubleProperty(prop, true);
    }

    /**
     * Gets the double property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the double property
     */
    public double getDoubleProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getDoubleProperty(prop, 0D,evalExtInvo);
    }

    /**
     * Gets the double property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the double property
     */
    public double getDoubleProperty(SemanticProperty prop, double defValue)
    {
        return getDoubleProperty(prop, defValue, true);
    }

    /**
     * Gets the double property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the double property
     */
    public double getDoubleProperty(SemanticProperty prop, double defValue, boolean evalExtInvo)
    {
        Double ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(Double)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getDouble();
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setDoubleProperty(SemanticProperty prop, double value)
    {
        return setDoubleProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setDoubleProperty(SemanticProperty prop, double value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            setLiteralProperty(prop, new SemanticLiteral(new Double(value)));
        }
        return this;
    }

    /**
     * Gets the boolean property.
     *
     * @param prop the prop
     * @return the boolean property
     */
    public boolean getBooleanProperty(SemanticProperty prop)
    {
        return getBooleanProperty(prop, true);
    }

    /**
     * Gets the boolean property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the boolean property
     */
    public boolean getBooleanProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getBooleanProperty(prop, false, evalExtInvo);
    }

    /**
     * Gets the boolean property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the boolean property
     */
    public boolean getBooleanProperty(SemanticProperty prop, boolean defValue, boolean evalExtInvo)
    {
        Boolean ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(Boolean)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getBoolean();
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setBooleanProperty(SemanticProperty prop, boolean value)
    {
        return setBooleanProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setBooleanProperty(SemanticProperty prop, boolean value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            setLiteralProperty(prop, new SemanticLiteral(new Boolean(value)));
        }
        return this;
    }


    /**
     * Gets the date property.
     *
     * @param prop the prop
     * @return the date property
     */
    public java.util.Date getDateProperty(SemanticProperty prop)
    {
        return getDateProperty(prop, true);
    }

    /**
     * Gets the date property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the date property
     */
    public java.util.Date getDateProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getDateProperty(prop, null, evalExtInvo);
    }

    /**
     * Gets the date property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the date property
     */
    public java.util.Date getDateProperty(SemanticProperty prop, java.util.Date defValue)
    {
        return getDateProperty(prop, defValue, true);
    }

    /**
     * Gets the date property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the date property
     */
    public java.util.Date getDateProperty(SemanticProperty prop, java.util.Date defValue, boolean evalExtInvo)
    {
        java.util.Date ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(java.util.Date)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getDateTime();
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setDateProperty(SemanticProperty prop, java.util.Date value)
    {
        return setDateProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setDateProperty(SemanticProperty prop, java.util.Date value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            if(value!=null)
            {
                setLiteralProperty(prop, new SemanticLiteral(new Timestamp(value.getTime())));
            }else
            {
                removeProperty(prop);
            }
        }
        return this;
    }


    /**
     * Gets the sQL date property.
     *
     * @param prop the prop
     * @return the sQL date property
     */
    public Date getSQLDateProperty(SemanticProperty prop)
    {
        return getSQLDateProperty(prop, true);
    }

    /**
     * Gets the sQL date property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the sQL date property
     */
    public Date getSQLDateProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getSQLDateProperty(prop, null, evalExtInvo);
    }

    /**
     * Gets the sQL date property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the sQL date property
     */
    public Date getSQLDateProperty(SemanticProperty prop, Date defValue)
    {
        return getSQLDateProperty(prop, defValue, true);
    }

    /**
     * Gets the sQL date property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the sQL date property
     */
    public Date getSQLDateProperty(SemanticProperty prop, Date defValue, boolean evalExtInvo)
    {
        Date ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(Date)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getDate();
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setSQLDateProperty(SemanticProperty prop, Date value)
    {
        return setSQLDateProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setSQLDateProperty(SemanticProperty prop, Date value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            setLiteralProperty(prop, new SemanticLiteral(value));
        }
        return this;
    }

    /**
     * Gets the date time property.
     *
     * @param prop the prop
     * @return the date time property
     */
    public Timestamp getDateTimeProperty(SemanticProperty prop)
    {
        return getDateTimeProperty(prop, true);
    }

    /**
     * Gets the date time property.
     *
     * @param prop the prop
     * @param evalExtInvo the eval ext invo
     * @return the date time property
     */
    public Timestamp getDateTimeProperty(SemanticProperty prop, boolean evalExtInvo)
    {
        return getDateTimeProperty(prop, null, evalExtInvo);
    }

    /**
     * Gets the date time property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @return the date time property
     */
    public Timestamp getDateTimeProperty(SemanticProperty prop, Timestamp defValue)
    {
        return getDateTimeProperty(prop, defValue, true);
    }

    /**
     * Gets the date time property.
     *
     * @param prop the prop
     * @param defValue the def value
     * @param evalExtInvo the eval ext invo
     * @return the date time property
     */
    public Timestamp getDateTimeProperty(SemanticProperty prop, Timestamp defValue, boolean evalExtInvo)
    {
        Timestamp ret=defValue;
        if (evalExtInvo && prop.isExternalInvocation())
        {
            ret=(Timestamp)externalInvokerGet(prop);
        }else
        {
            SemanticLiteral lit=getLiteralProperty(prop);
            if(lit!=null)
            {
                ret=lit.getDateTime();
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setDateTimeProperty(SemanticProperty prop, Timestamp value)
    {
        return setDateTimeProperty(prop, value, true);
    }

    /**
     * Asigna la propiedad con el valor especificado.
     *
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @param evalExtInvo the eval ext invo
     * @return SemanticObject para cascada
     */
    public SemanticObject setDateTimeProperty(SemanticProperty prop, Timestamp value, boolean evalExtInvo)
    {
        if (evalExtInvo && prop.isExternalInvocation())
        {
            externalInvokerSet(prop,value);
        }else
        {
            if(value!=null)
            {
                setLiteralProperty(prop, new SemanticLiteral(value));
            }else
            {
                removeProperty(prop);
            }
        }
        return this;
    }

    /**
     * Gets the display name.
     *
     * @return the display name
     */
    public String getDisplayName()
    {
        return getDisplayName(null);
    }

    /**
     * Gets the display name.
     *
     * @param lang the lang
     * @return the display name
     */
    public String getDisplayName(String lang)
    {
        String ret = null;
        SemanticClass cls = getSemanticClass();
        SemanticProperty prop=null;
        if (cls != null)
        {
             prop= cls.getDisplayNameProperty();
        }
        if (prop != null)
        {
            if (prop.isDataTypeProperty())
            {
                ret = getLocaleProperty(prop, lang);
            }
            else if (prop.isObjectProperty())
            {
                SemanticObject obj = getObjectProperty(prop);
                if(obj!=null)
                {
                    ret = obj.getDisplayName(lang);
                }
            }
        }
        if(ret==null)
        {
            ret = getLabel(lang);
            if(ret==null)
            {
                ret=cls.getName()+":"+getId();
                /*
                if(getURI()!=null)
                {
                    
                    int x=getURI().indexOf('#');
                    if(x>0)
                    {
                        ret=getURI().substring(0,x+1);
                        ret=SWBPlatform.getSemanticMgr().getOntology().getRDFOntModel().getNsURIPrefix(ret);
                        if(ret!=null)
                        {
                            ret+=":"+getId();
                        }else
                        {
                            ret=getId();
                        }
                    }else
                    {
                        ret=getId();
                    }
                }else
                {
                    ret=getResId();
                }
                */
            }
        }
        return ret;
    }

    /**
     * Transform to semantic property.
     *
     * @return the semantic property
     */
    public SemanticProperty transformToSemanticProperty()
    {
        SemanticProperty ret = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(getURI());
        return ret;
    }

    /**
     * Transform to semantic class.
     *
     * @return the semantic class
     */
    public SemanticClass transformToSemanticClass()
    {
        SemanticClass ret = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(getURI());
        return ret;
    }

    /**
     * List related objects.
     *
     * @return the iterator
     */
    public Iterator<SemanticObject> listRelatedObjects()
    {
        ArrayList arr=new ArrayList();
        StmtIterator stit = getModel().getRDFModel().listStatements(null, null, getRDFResource());
        Iterator it=new SemanticIterator(stit, true);
        while(it.hasNext())
        {
            arr.add(it.next());
        }
        SemanticClass cls=getSemanticClass();
        it=cls.listProperties();
        while(it.hasNext())
        {
            SemanticProperty prop=(SemanticProperty)it.next();
            if(prop.isObjectProperty() && prop.isInverseOf())
            {
               SemanticObject obj=getObjectProperty(prop);
               if(obj!=null)arr.add(obj);
            }
        }
        return arr.iterator();
    }

    /**
     * List herarquical childs.
     *
     * @return the iterator
     */
    public Iterator<SemanticObject> listHerarquicalChilds()
    {
        ArrayList<SemanticObject> list=new ArrayList();
        SemanticClass cls=getSemanticClass();
        if(cls!=null)
        {
            Iterator<SemanticProperty> it=cls.listHerarquicalProperties();
            while(it.hasNext())
            {
                SemanticProperty prop=it.next();
                SemanticClass hfcls=prop.getHerarquicalRelationFilterClass();
                Iterator<SemanticObject> it2=listObjectProperties(prop);
                while(it2.hasNext())
                {
                    SemanticObject ch=it2.next();
                    if(hfcls!=null)
                    {
                        //System.out.println(this+" "+cls+" "+ch+" "+hfcls);
                        if(!ch.instanceOf(hfcls))continue;
                    }
                    list.add(ch);
                }
            }
        }
        return list.iterator();
    }

    /**
     * Checks for herarquical parents.
     *
     * @return true, if successful
     */
    public boolean hasHerarquicalParents()
    {
        boolean ret=false;
        Iterator<SemanticProperty> it=getSemanticClass().listInverseHerarquicalProperties();
        while(it.hasNext())
        {
            SemanticProperty prop=it.next();
            if(hasObjectProperty(prop))
            {
                ret=true;
                break;
            }
        }
        return ret;
    }

    /**
     * List herarquical parents.
     *
     * @return the iterator
     */
    public Iterator<SemanticObject> listHerarquicalParents()
    {
        HashSet<SemanticObject> list=new HashSet();
        Iterator<SemanticProperty> it=getSemanticClass().listInverseHerarquicalProperties();
        while(it.hasNext())
        {
            SemanticProperty prop=it.next();
            Iterator<SemanticObject> it2=listObjectProperties(prop);
            while(it2.hasNext())
            {
                SemanticObject ch=it2.next();
                if(!ch.equals(this))list.add(ch);
            }
        }
        return list.iterator();
    }

    /**
     * Clona un objeto y sus dependencias, el objeto hash sirve para
     * almacenar las dependencias clonadas.
     *
     * @return the semantic object
     * @return
     */
    public SemanticObject cloneObject()
    {
        //Get URI
        String id=null;
        if(getSemanticClass().isAutogenId())
        {
            id=""+getModel().getCounter(getSemanticClass());
        }else
        {
            int x=1;
            do
            {
                x++;
                id=getId()+x;
            }while(createSemanticObject(id)!=null);
        }
        String uri=getModel().getObjectUri(id, getSemanticClass());
        Resource res=getModel().getRDFModel().createResource(uri);

        //Get Herarquical properties
        ArrayList<SemanticProperty> hp=new ArrayList();
        Iterator<SemanticProperty> ithp=getSemanticClass().listHerarquicalProperties();
        while(ithp.hasNext())
        {
            hp.add(ithp.next());
        }
        ithp=getSemanticClass().listInverseHerarquicalProperties();
        while(ithp.hasNext())
        {
            hp.add(ithp.next());
        }

        //res.addProperty(getModel().getRDFModel().getProperty(SemanticVocabulary.RDF_TYPE), m_cls.getOntClass());
        Iterator<Statement> it=m_res.listProperties();
        while(it.hasNext())
        {
            Statement st=it.next();
            Property prop=st.getPredicate();
            SemanticProperty sprop=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(prop.getURI());
            if(sprop==null || !sprop.isRemoveDependency())
            {
                Statement nst=getModel().getRDFModel().createStatement(res, prop, st.getObject());
                //Statement nst=new StatementImpl(res, prop, st.getObject());
                getModel().getRDFModel().add(nst);
            }else
            {
                System.out.println("Remove dependency prop:"+prop);
            }
        }

        SemanticObject ret=SemanticObject.createSemanticObject(res);
        SWBPlatform.getSemanticMgr().notifyChange(ret, null, null, ACT_CLONE);
        return ret;
    }

    /**
     * Gets the herarquical parent.
     *
     * @return the herarquical parent
     */
    public SemanticObject getHerarquicalParent()
    {
        SemanticObject ret=null;
        Iterator<SemanticObject> it=listHerarquicalParents();
        if(it.hasNext())ret=it.next();
        return ret;
    }

    /**
     * Gets the work path.
     *
     * @return the work path
     */
    public String getWorkPath()
    {
        SemanticClass cls=getSemanticClass();
        if(cls==null)System.out.println("Class null:"+getURI());
        return "/models/"+getModel().getName()+"/"+cls.getClassGroupId()+"/"+getId();
    }

    /**
     * Regresa todos los valores de la propiedad sin importar el idioma
     * Utilizado para la indexación del objeto.
     *
     * @param prop the prop
     * @return the property index data
     * @return
     */
    public String getPropertyIndexData(SemanticProperty prop)
    {
        String ret="";
        StmtIterator stit = m_res.listProperties(prop.getRDFProperty());
        while(stit.hasNext())
        {
            Statement st=stit.nextStatement();
            ret=ret+st.getString()+"\n";
        }
        stit.close();
        return ret;
    }


    /**
     * Regresa el valor de la propiedad rdfs:label del objeto.
     *
     * @return the label
     */
    public String getLabel()
    {
        return getLabel(null);
    }

    /**
     * Regresa el valor de la propiedad rdfs:label del objeto.
     *
     * @param lang the lang
     * @return the label
     */
    public String getLabel(String lang)
    {
        return getLocaleProperty(getModel().getSemanticProperty(SemanticVocabulary.RDFS_LABEL), lang);
    }

    /**
     * Regresa el valor de la propiedad rdfs:comment del objeto.
     *
     * @return the label
     */
    public String getComment()
    {
        return getComment(null);
    }

    /**
     * Regresa el valor de la propiedad rdfs:comment del objeto.
     *
     * @param lang the lang
     * @return the label
     */
    public String getComment(String lang)
    {
        return getLocaleProperty(getModel().getSemanticProperty(SemanticVocabulary.RDFS_COMMENT), lang);
    }    
    
    
    
}
