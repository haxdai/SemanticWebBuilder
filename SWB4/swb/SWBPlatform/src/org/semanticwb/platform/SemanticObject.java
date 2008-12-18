package org.semanticwb.platform;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBUtils;
import org.semanticwb.SWBPlatform;
import org.semanticwb.base.util.URLEncoder;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.base.GenericObjectBase;

/**
 *
 * @author Javier Solis Gonzalez
 */
public class SemanticObject
{
    private static Logger log = SWBUtils.getLogger(SemanticObject.class);

    private static HashMap<String, SemanticObject>m_objs=new HashMap();

    private Resource m_res = null;
    private SemanticModel m_model = null;
    //Virtual properties
    private SemanticClass m_cls = null;
    private boolean m_virtual = false;
    private HashMap m_virtprops;

    private HashMap m_cacheprops;


    private SemanticObject(Resource res)
    {
        m_cacheprops=new HashMap();
        this.m_res = res;
        validateModel();
        //System.out.println("SemanticObject:"+res);
    }

    public static SemanticObject getSemanticObject(String uri)
    {
        SemanticObject ret=m_objs.get(uri);
        return ret;
    }


    public static SemanticObject createSemanticObject(String uri)
    {
        SemanticObject ret=m_objs.get(uri);
        if(ret==null)
        {
            Resource res=SWBPlatform.getSemanticMgr().getOntology().getResource(uri);
            if(res!=null)
            {
                ret=new SemanticObject(res);
                m_objs.put(uri, ret);
            }
        }
        return ret;
    }

    public static SemanticObject createSemanticObject(Resource res)
    {
        SemanticObject ret=m_objs.get(res.getURI());
        if(ret==null)
        {
            ret=new SemanticObject(res);
            m_objs.put(res.getURI(), ret);
        }
        return ret;
    }

    private void setPropertyValueCache(SemanticProperty prop, String lang, Object value)
    {
        m_cacheprops.put(prop.getURI()+"|"+lang, value);
    }

    private Object getPropertyValueCache(SemanticProperty prop, String lang)
    {
        return m_cacheprops.get(prop.getURI()+"|"+lang);
    }

    private void clearPropertyValueCache(SemanticProperty prop, String lang)
    {
        m_cacheprops.remove(prop.getURI()+"|"+lang);
    }

    private void validateModel()
    {
        String ns = getModel().getNameSpace();
        if (ns != null && !m_res.getURI().startsWith(ns))
        {
            m_res = SWBPlatform.getSemanticMgr().getOntology().getResource(m_res.getURI());
            m_model = null;
        }
    }

    public boolean isVirtual()
    {
        return m_virtual;
    }

    public void setRDFResource(Resource res)
    {
        this.m_model = null;
        this.m_virtual = false;
        this.m_res = res;
        validateModel();
    }

    /**
     * Contruye un SemanticObject virtual
     *
     * @param model
     */
    public SemanticObject()
    {
        this(null, null);
    }

    /**
     * Contruye un SemanticObject virtual relacionado al Model y al tipo de elemento
     * 
     * @param model
     */
    public SemanticObject(SemanticModel model, SemanticClass cls)
    {
        m_model = model;
        m_cls = cls;
        m_virtual = true;
        m_virtprops = new HashMap();
        m_cacheprops=new HashMap();
    }

    public String getURI()
    {
        if (m_virtual)
        {
            return null;
        }
        return m_res.getURI();
    }

    public String getId()
    {
        if (m_virtual)
        {
            return null;
        }
        String uri = getURI();
        int x = uri.indexOf('#');
        if (x > -1)
        {
            return uri.substring(x + 1);
        }
        return uri;
    }

    /**
     * Regreasa SemanticID compuesto por /[model name]/[cls name]/[id]
     * @return
     */
    public String getSID()
    {
        return "/" + getModel().getName() + "/" + getSemanticClass().getName() + "/" + getId();
    }

    /**
     * Regresa URI codificado para utilizar en ligas de html
     * @return URI Codificado
     */
    public String getEncodedURI()
    {
        return URLEncoder.encode(getURI());
    }

    public String getRDFName()
    {
        if (m_virtual)
        {
            return null;
        }
        return m_res.getLocalName();
    }

    public SemanticClass getSemanticClass()
    {
        //System.out.print("getSemanticClass:"+getURI());
        if (m_cls == null)
        {
            StmtIterator stmit = m_res.listProperties(m_res.getModel().getProperty(SemanticVocabulary.RDF_TYPE));
            while(stmit.hasNext())
            {
                Statement stm=stmit.nextStatement();
                try
                {
                    m_cls = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(stm.getResource().getURI());
                    if(m_cls!=null)break;
                }
                catch (Exception e)
                {
                    log.error(e);
                }
            }
        }
        //System.out.println(" m_cls:"+m_cls);
        return m_cls;
    }

    public Iterator<SemanticClass> listSemanticClasses()
    {
        if (m_virtual)
        {
            //TODO:
            return null;//m_virtclass;
        }
        return new SemanticClassIterator<SemanticClass>(m_res.listProperties(m_res.getModel().getProperty(SemanticVocabulary.RDF_TYPE)));
    }

    public void addSemanticClass(SemanticClass cls)
    {
        if (m_virtual)
        {
            //TODO:
        }
        else
        {
            m_res.addProperty(m_res.getModel().getProperty(SemanticVocabulary.RDF_TYPE), cls.getOntClass());
        }
    }

    public SemanticObject removeSemanticClass(SemanticClass cls)
    {
        if (m_virtual)
        {
            //TODO:
        }
        else if (m_res != null)
        {
            StmtIterator stit = m_res.listProperties(m_res.getModel().getProperty(SemanticVocabulary.RDF_TYPE));
            while (stit.hasNext())
            {
                Statement staux = stit.nextStatement();
                if (staux.getResource().getURI().equals(cls.getURI()))
                {
                    stit.remove();
                }
            }
        }
        return this;
    }

    /**
     * Regresa el Modelo de del SemanticObject
     * @return
     */
    public SemanticModel getModel()
    {
        if (m_model == null)
        {
            m_model = SWBPlatform.getSemanticMgr().getModel(m_res.getModel());
        }
        return m_model;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setProperty(SemanticProperty prop, String value)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI(), value);
        }
        else
        {
            setPropertyValueCache(prop, null, value);
            Statement stm = m_res.getProperty(prop.getRDFProperty());
            if (stm != null)
            {
                //            System.out.println("Int1:"+stm.getObject().getClass());
                //            if(stm.getObject() instanceof LiteralImpl)
                //            {
                //                LiteralImpl lit=(LiteralImpl)stm.getObject();
                //                System.out.println("Int:"+lit.isResource());
                //                System.out.println("Int:"+lit.isAnon());
                //                System.out.println("Int:"+lit.isURIResource());
                //                System.out.println("Int:"+lit.isValid());
                //                System.out.println("Int:"+lit.isWellFormedXML());
                //            }
                stm.changeObject(value);
            }
            else
            {
                m_res.addProperty(prop.getRDFProperty(), value);
            }
        }
        return this;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setProperty(SemanticProperty prop, String value, String lang)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI() + "|" + lang, value);
        }
        else
        {
            setPropertyValueCache(prop, lang, value);
            Statement stm = getLocaleStatement(prop, lang);
            if (stm != null)
            {
                stm.changeObject(value, lang);
            }
            else
            {
                m_res.addProperty(prop.getRDFProperty(), value, lang);
            }
        }
        return this;
    }

    private Statement getLocaleStatement(SemanticProperty prop, String lang)
    {
        StmtIterator stit = m_res.listProperties(prop.getRDFProperty());
        Statement st = null;
        while (stit.hasNext())
        {
            Statement staux = stit.nextStatement();
            String lg = staux.getLanguage();
            if (lg != null && lg.equals(lang))
            {
                st = staux;
                break;
            }
        }
        return st;
    }

    public SemanticObject removeProperty(SemanticProperty prop)
    {
        if (prop.isBinary())
        {
            String value = getProperty(prop);
            if (value != null)
            {
                GenericObjectBase obj = new GenericObjectBase(this);
                String workPath = obj.getWorkPath();
                if (!(workPath.endsWith("\\") || workPath.equals("/")))
                {
                    workPath += "/" + value;
                }
                SWBPlatform.removeFileFromWorkPath(workPath);
            }
        }
        if (m_virtual)
        {
            m_virtprops.remove(prop.getURI());
        }
        else if (m_res != null)
        {
            Property iprop = prop.getRDFProperty();
            m_res.removeAll(iprop);
            clearPropertyValueCache(prop, null);
        }

        return this;
    }

    public SemanticObject removeProperty(SemanticProperty prop, String lang)
    {
        if (m_virtual)
        {
            m_virtprops.remove(prop.getURI() + "|" + lang);
        }
        else if (m_res != null)
        {
            StmtIterator stit = m_res.listProperties(prop.getRDFProperty());
            while (stit.hasNext())
            {
                Statement staux = stit.nextStatement();
                String lg = staux.getLanguage();
                if (lg != null && lg.equals(lang))
                {
                    stit.remove();
                }
            }
            clearPropertyValueCache(prop, lang);
        }
        return this;
    }

    /**
     * Regresa valor de la Propiedad especificada
     * @param prop
     * @return valor de la propiedad, si no existe la propiedad regresa null
     */
    public String getProperty(SemanticProperty prop)
    {
        return getProperty(prop, null);
    }

    public String getProperty(SemanticProperty prop, String defValue)
    {
        String ret = null;
        //System.out.println("getProperty:"+prop+" "+prop.isExternalInvocation());
        if (prop.isExternalInvocation())
        {
            Object aux = externalInvokerGet(prop);
            if (ret != null)
            {
                ret = "" + aux;
            }
        }
        else if (m_virtual)
        {
            ret = (String) m_virtprops.get(prop.getURI());
        }
        else
        {
            ret=(String)getPropertyValueCache(prop,null);
            if(ret==null)
            {
                Statement stm = m_res.getProperty(prop.getRDFProperty());
                if (stm != null)
                {
                    ret = stm.getString();
                    setPropertyValueCache(prop, null, ret);
                }
            }
        }
        if (ret == null)
        {
            ret = defValue;
        }
        return ret;
    }

    public String getProperty(SemanticProperty prop, String defValue, String lang)
    {
        //System.out.println("getProperty:"+prop+" "+prop.isExternalInvocation());
        if (prop.isExternalInvocation())
        {
            Object ret = externalInvokerGet(prop);
            if (ret == null)
            {
                return null;
            }
            return "" + ret;
        }
        String ret=null;
        if (m_virtual)
        {
            ret = (String) m_virtprops.get(prop.getURI() + "|" + lang);
            if (ret == null)
            {
                ret = defValue;
            }
        }else
        {
            ret=(String)getPropertyValueCache(prop, lang);
            if(ret==null)
            {
                Statement stm = getLocaleStatement(prop, lang);
                if (stm != null)
                {
                    ret = stm.getString();
                    setPropertyValueCache(prop, lang, ret);
                }
            }
            if(ret==null)ret=defValue;
        }
        return ret;
    }

    public String getLocaleProperty(SemanticProperty prop, String lang)
    {
        String ret = null;
        String def = null;
        String other = null;
        if (lang == null)
        {
            ret = getProperty(prop);
        }
        StmtIterator stit = m_res.listProperties(prop.getRDFProperty());
        while (stit.hasNext())
        {
            Statement st = stit.nextStatement();
            other = st.getString();
            String lg = st.getLanguage();
            if (lg == null || lg.length() == 0)
            {
                def = st.getString();
            }
            else if (lg.equals(lang))
            {
                ret = st.getString();
                break;
            }
        }
        if (ret == null)
        {
            ret = def;
        }
        if (ret == null)
        {
            ret = other;
        }
        return ret;
    }

    public int getIntProperty(SemanticProperty prop)
    {
        return getIntProperty(prop, 0);
    }

    public int getIntProperty(SemanticProperty prop, int defValue)
    {
        Integer ret=null;
        if (m_virtual)
        {
            ret = (Integer) m_virtprops.get(prop.getURI());
            if (ret == null)
            {
                ret = defValue;
            }
        }else
        {
            ret = (Integer)getPropertyValueCache(prop, null);
            if(ret==null)
            {
                Statement stm = m_res.getProperty(prop.getRDFProperty());
                if (stm != null)
                {
                    ret = stm.getInt();
                    setPropertyValueCache(prop, null, ret);
                }
            }
            if(ret==null)ret=defValue;
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setIntProperty(SemanticProperty prop, int value)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI(), (Integer) value);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        Statement stm = m_res.getProperty(iprop);
        if (stm != null)
        {
            stm.changeLiteralObject(value);
        }
        else
        {
            m_res.addLiteral(iprop, value);
        }
        return this;
    }

    public long getLongProperty(SemanticProperty prop)
    {
        return getLongProperty(prop, 0L);
    }

    private Object externalInvokerGet(SemanticProperty prop)
    {
        Object ret = null;
        if (!m_virtual)
        {
            GenericObject obj = getSemanticClass().newGenericInstance(this);
            Class cls = obj.getClass();
            String name = prop.getLabel();
            if (name == null)
            {
                name = prop.getName();
            }
            name = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            try
            {
                Method method = cls.getMethod(name);
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

    public long getLongProperty(SemanticProperty prop, long defValue)
    {
        //System.out.println("getLongProperty:"+prop+" "+prop.isExternalInvocation());
        if (prop.isExternalInvocation())
        {
            return (Long) externalInvokerGet(prop);
        }
        if (m_virtual)
        {
            Long ret = (Long) m_virtprops.get(prop.getURI());
            if (ret == null)
            {
                ret = defValue;
            }
            return ret;
        }
        long ret = defValue;
        Statement stm = m_res.getProperty(prop.getRDFProperty());
        if (stm != null)
        {
            ret = stm.getLong();
        }
        return ret;
    }

    public SemanticObject setInputStreamProperty(SemanticProperty prop, InputStream value, String name) throws SWBException
    {
        GenericObjectBase obj = new GenericObjectBase(this);
        String workPath = obj.getWorkPath();
        if (!(workPath.endsWith("\\") || workPath.equals("/")))
        {
            workPath += "/" + name;
        }
        SWBPlatform.writeFileToWorkPath(workPath, value, "");
        return this.setProperty(prop, name);
    }

    public InputStream getInputStreamProperty(SemanticProperty prop) throws SWBException
    {
        String value = getProperty(prop);
        GenericObjectBase obj = new GenericObjectBase(this);
        String workPath = obj.getWorkPath();
        if (!(workPath.endsWith("\\") || workPath.equals("/")))
        {
            workPath += "/" + value;
        }
        return SWBPlatform.getFileFromWorkPath(workPath);
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setLongProperty(SemanticProperty prop, long value)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI(), (Long) value);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        Statement stm = m_res.getProperty(iprop);
        if (stm != null)
        {
            stm.changeLiteralObject(value);
        }
        else
        {
            m_res.addLiteral(iprop, value);
        }
        return this;
    }

    public float getFloatProperty(SemanticProperty prop)
    {
        return getFloatProperty(prop, 0F);
    }

    public float getFloatProperty(SemanticProperty prop, float defValue)
    {
        if (m_virtual)
        {
            Float ret = (Float) m_virtprops.get(prop.getURI());
            if (ret == null)
            {
                ret = defValue;
            }
            return ret;
        }
        float ret = defValue;
        Statement stm = m_res.getProperty(prop.getRDFProperty());
        if (stm != null)
        {
            ret = stm.getFloat();
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setFloatProperty(SemanticProperty prop, float value)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI(), (Float) value);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        Statement stm = m_res.getProperty(iprop);
        if (stm != null)
        {
            stm.changeLiteralObject(value);
        }
        else
        {
            m_res.addLiteral(iprop, value);
        }
        return this;
    }

    public double getDoubleProperty(SemanticProperty prop)
    {
        return getDoubleProperty(prop, 0D);
    }

    public double getDoubleProperty(SemanticProperty prop, double defValue)
    {
        if (m_virtual)
        {
            Double ret = (Double) m_virtprops.get(prop.getURI());
            if (ret == null)
            {
                ret = defValue;
            }
            return ret;
        }
        double ret = defValue;
        Statement stm = m_res.getProperty(prop.getRDFProperty());
        if (stm != null)
        {
            ret = stm.getDouble();
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setDoubleProperty(SemanticProperty prop, double value)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI(), (Double) value);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        Statement stm = m_res.getProperty(iprop);
        if (stm != null)
        {
            stm.changeLiteralObject(value);
        }
        else
        {
            m_res.addLiteral(iprop, value);
        }
        return this;
    }

    public boolean getBooleanProperty(SemanticProperty prop)
    {
        return getBooleanProperty(prop, false);
    }

    public boolean getBooleanProperty(SemanticProperty prop, boolean defValue)
    {
        if (m_virtual)
        {
            Boolean ret = (Boolean) m_virtprops.get(prop.getURI());
            if (ret == null)
            {
                ret = defValue;
            }
            return ret;
        }
        boolean ret = defValue;
        Statement stm = m_res.getProperty(prop.getRDFProperty());
        if (stm != null)
        {
            ret = stm.getBoolean();
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setBooleanProperty(SemanticProperty prop, boolean value)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI(), (Boolean) value);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        Statement stm = m_res.getProperty(iprop);
        if (stm != null)
        {
            stm.changeLiteralObject(value);
        }
        else
        {
            m_res.addLiteral(iprop, value);
        }
        return this;
    }

    public Date getDateProperty(SemanticProperty prop)
    {
        return getDateProperty(prop, null);
    }

    public Date getDateProperty(SemanticProperty prop, Date defValue)
    {
        if (m_virtual)
        {
            Date ret = (Date) m_virtprops.get(prop.getURI());
            if (ret == null)
            {
                ret = defValue;
            }
            return ret;
        }
        Date ret = defValue;
        Statement stm = m_res.getProperty(prop.getRDFProperty());
        if (stm != null)
        {
            try
            {
                ret = SWBUtils.TEXT.iso8601DateParse(stm.getString());
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
        return ret;
    }

    /**
     * Asigna la propiedad con el valor especificado
     * @param prop Propiedad a modificar
     * @param value Valor a asignar
     * @return SemanticObject para cascada
     */
    public SemanticObject setDateProperty(SemanticProperty prop, Date value)
    {
        if (m_virtual)
        {
            m_virtprops.put(prop.getURI(), (Date) value);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        Statement stm = m_res.getProperty(iprop);
        if (stm != null)
        {
            stm.changeObject(SWBUtils.TEXT.iso8601DateFormat(value));
        }
        else
        {
            m_res.addProperty(iprop, SWBUtils.TEXT.iso8601DateFormat(value));
        }
        return this;
    }

    public SemanticObject setObjectProperty(SemanticProperty prop, SemanticObject object)
    {
        if (m_virtual)
        {
            ArrayList list = (ArrayList) m_virtprops.get(prop.getURI());
            if (list == null)
            {
                list = new ArrayList();
                m_virtprops.put(prop.getURI(), list);
            }
            list.clear();
            list.add(object);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        Statement stm = m_res.getProperty(iprop);
        if (stm != null)
        {
            stm.changeObject(object.getRDFResource());
        }
        else
        {
            m_res.addProperty(iprop, object.getRDFResource());
        }
        return this;
    }

    public SemanticObject addObjectProperty(SemanticProperty prop, SemanticObject object)
    {
        if (m_virtual)
        {
            ArrayList list = (ArrayList) m_virtprops.get(prop.getURI());
            if (list == null)
            {
                list = new ArrayList();
                m_virtprops.put(prop.getURI(), list);
            }
            list.add(object);
            return this;
        }
        Property iprop = prop.getRDFProperty();
        m_res.addProperty(iprop, object.getRDFResource());
        return this;
    }

    public SemanticObject removeObjectProperty(SemanticProperty prop, SemanticObject object)
    {
        if (m_virtual)
        {
            ArrayList list = (ArrayList) m_virtprops.get(prop.getURI());
            if (list != null)
            {
                list.remove(object);
            }
            return this;
        }
        StmtIterator it = m_res.listProperties(prop.getRDFProperty());
        while (it.hasNext())
        {
            Statement stmt = it.nextStatement();
            if (object.getRDFResource().equals(stmt.getResource()))
            {
                stmt.remove();
            }
        }
        return this;
    }

    public Iterator<SemanticLiteral> listLiteralProperties(SemanticProperty prop)
    {
        if (m_virtual)
        {
            //TODO
//            ArrayList list=(ArrayList)m_virtprops.get(prop.getURI());
//            if(list!=null)
//            {
//                return list.iterator();
//            }
//            else
//            {
//                return new ArrayList().iterator();
//            }
            return null;
        }
        return new SemanticLiteralIterator(m_res.listProperties(prop.getRDFProperty()));
    }

    /**
     * 
     * @return
     */
//    public Iterator<SemanticProperty> listProperties()
//    {
//        getRDFResource().l
//    }
    public Iterator<SemanticObject> listObjectProperties(SemanticProperty prop)
    {
        if (m_virtual)
        {
            ArrayList list = (ArrayList) m_virtprops.get(prop.getURI());
            if (list != null)
            {
                return list.iterator();
            }
            else
            {
                return new ArrayList().iterator();
            }
        }

        Iterator ret = null;
        if (!prop.hasInverse())
        {
            ret = new SemanticIterator(m_res.listProperties(prop.getRDFProperty()));
        }
        else
        {
            ret = new SemanticIterator(getModel().getRDFModel().listStatements(null, prop.getInverse().getRDFProperty(), getRDFResource()), true);
        }
        return ret;
    }

    public SemanticObject getObjectProperty(SemanticProperty prop)
    {
        return getObjectProperty(prop, null);
    }

    public SemanticObject getObjectProperty(SemanticProperty prop, SemanticObject defValue)
    {
        SemanticObject ret = defValue;
        if (m_virtual)
        {
            ArrayList<SemanticObject> arr = ((ArrayList) m_virtprops.get(prop.getURI()));
            if (arr != null && !arr.isEmpty())
            {
                ret = (SemanticObject) arr.get(0);
            }
            return ret;
        }
        Statement stm = m_res.getProperty(prop.getRDFProperty());
        if (stm != null)
        {
            try
            {
                ret = SemanticObject.createSemanticObject(stm.getResource());
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
        return ret;
    }

    public Resource getRDFResource()
    {
        if (m_virtual)
        {
            return null;
        }
        return m_res;
    }

    @Override
    public String toString()
    {
        if (m_virtual)
        {
            return super.toString();
        }
        return m_res.toString();
    }

    @Override
    public int hashCode()
    {
        if (m_virtual)
        {
            return super.hashCode();
        }
        return m_res.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        return hashCode() == obj.hashCode();
    }

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

    public void remove()
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
        }
        Resource res=getRDFResource();
        if(res!=null)
        {
            SemanticModel model=getModel();
            model.getRDFModel().removeAll(res,null,null);
            model.getRDFModel().removeAll(null,null,res);
        }
        removeCache(getURI());
    }

    public String getDisplayName()
    {
        return getDisplayName(null);
    }

    public String getDisplayName(String lang)
    {
        String ret = null;
        SemanticClass cls = getSemanticClass();
        if (cls != null)
        {
            SemanticProperty prop = cls.getDisplayNameProperty();
            if (prop != null)
            {
                if (prop.isDataTypeProperty())
                {
                    ret = getLocaleProperty(prop, lang);
                }
                else if (prop.isObjectProperty())
                {
                    SemanticObject obj = getObjectProperty(prop);
                    ret = obj.getDisplayName(lang);
                }
            }
            else
            {
                ret = getLocaleProperty(getModel().getSemanticProperty(SemanticVocabulary.RDFS_LABEL), lang);
                if(ret==null)
                {
                    ret=SWBPlatform.getSemanticMgr().getOntology().getRDFOntModel().getNsURIPrefix(getModel().getNameSpace()); //prefijo
                    ret+=":"+getId();
                }
            }
        }
        else
        {
            log.warn("Object does not have cls:" + getURI());
        }
        return ret;
    }

    public SemanticProperty transformToSemanticProperty()
    {
        SemanticProperty ret = null;
        Property pro = getModel().getRDFModel().getProperty(getURI());
        if (pro != null)
        {
            ret = new SemanticProperty(pro);
        }
        return ret;
    }

    public Iterator<SemanticObject> listRelatedObjects()
    {
        StmtIterator stit = getModel().getRDFModel().listStatements(null, null, getRDFResource());
        return new SemanticIterator(stit, true);
    }

    public static void removeCache(String uri)
    {
        m_objs.remove(uri);
    }
}

