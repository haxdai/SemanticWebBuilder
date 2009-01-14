/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.platform;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.Property;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;

/**
 *
 * @author Jei
 */
public class SemanticVocabulary 
{
    private static Logger log = SWBUtils.getLogger(SemanticVocabulary.class);
    //RDF
    public static final String RDF_URI="http://www.w3.org/1999/02/22-rdf-syntax-ns#";
    public static final String RDF_TYPE=RDF_URI+"type";
    public static final String RDF_PROPERTY=RDF_URI+"Property";
    
    public static final String RDFS_URI="http://www.w3.org/2000/01/rdf-schema#";
    public static final String RDFS_LABEL=RDFS_URI+"label";
    public static final String RDFS_DOMAIN=RDFS_URI+"domain";
    public static final String RDFS_RANGE=RDFS_URI+"range";
    public static final String RDFS_SUBPROPERTYOF=RDFS_URI+"subPropertyOf";
    public static final String RDFS_SUBCLASSOF=RDFS_URI+"subClassOf";
    
    public static final String XMLS_URI="http://www.w3.org/2001/XMLSchema#";
    public static final String XMLS_DATETIME=XMLS_URI+"dateTime";
    public static final String XMLS_DATE=XMLS_URI+"date";
    public static final String XMLS_BOOLEAN=XMLS_URI+"boolean";
    public static final String XMLS_STRING=XMLS_URI+"string";
    public static final String XMLS_INT=XMLS_URI+"int";
    public static final String XMLS_FLOAT=XMLS_URI+"float";
    public static final String XMLS_DOUBLE=XMLS_URI+"double";
    public static final String XMLS_LONG=XMLS_URI+"long";
    public static final String XMLS_SHORT=XMLS_URI+"short";
    public static final String XMLS_BYTE=XMLS_URI+"byte";
    public static final String XMLS_BASE64BINARY=XMLS_URI+"base64Binary";
    
            
    public static final String OWL_URI="http://www.w3.org/2002/07/owl#";
    public static final String OWL_CLASS=OWL_URI+"Class";
    public static final String OWL_DATATYPEPROPERTY=OWL_URI+"DatatypeProperty";
    public static final String OWL_OBJECTPROPERTY=OWL_URI+"ObjectProperty";
        
    //General
    public static final String URI="http://www.semanticwebbuilder.org/swb4/ontology#";
    public static final String SWBXF_URI="http://www.semanticwebbuilder.org/swb4/xforms/ontology#";

    public static final String SWB_CLASS=URI+"Class";
    public static final String SWB_INTERFACE=URI+"Interface";
    public static final String SWB_MODEL=URI+"Model";
    public static final String SWB_FORMELEMENT=URI+"FormElement";
    public static final String SWB_PROP_VALUE=URI+"value";
    public static final String SWB_PROP_HASCLASS=URI+"hasClass";
    public static final String SWB_PROP_LOCALEABLE=URI+"localeable";
    public static final String SWB_PROP_REQUIRED=URI+"required";
    public static final String SWB_PROP_DISPLAYPROPERTY=URI+"displayProperty";
    public static final String SWB_PROP_DISPLAYOBJECT=URI+"displayObject";
    public static final String SWB_PROP_EXTERNALINVOCATION=URI+"externalInvocation";
    public static final String SWB_PROP_HERARQUICALRELATION=URI+"herarquicalRelation";
    public static final String SWB_PROP_REMOVEDEPENDENCY=URI+"removeDependency";
    public static final String SWB_PROP_HASHERARQUICALNODE=URI+"hasHerarquicalNode";
//    public static final String SWB_PROP_PROPGROUP=URI+"propGroup";
//    public static final String SWB_PROP_PROPINDEX=URI+"propIndex";
    public static final String SWB_ANNOT_CLASSNAME=URI+"className";
    public static final String SWB_ANNOT_AUTOGENID=URI+"autogenId";
    public static final String SWB_ANNOT_CANUSEDASNAME=URI+"canUsedAsName";
    public static final String SWB_PROP_CLASSID=URI+"classID";
    
    //public static final String SWB_NS="swbns";

    public HashMap<String, SemanticClass> classes;
    public HashMap<String, SemanticProperty> properties;
    public HashMap<String, SemanticClass> clsbyid;
    
    
    public SemanticVocabulary()
    {
        classes=new HashMap();
        clsbyid=new HashMap();
        properties=new HashMap();
    }
    
    public void init()
    {
        //SWBClass=getSemanticClass(URI+"SWBClass");
        //SWBInterface=getSemanticClass(URI+"SWBInterface");
        filterProperties();
    }
    
    private void filterProperties()
    {
        //System.out.println("filterProperties");
        Iterator<SemanticClass> tpcit=listSemanticClasses();
        while(tpcit.hasNext())
        {
            SemanticClass tpc=tpcit.next();
            Iterator<SemanticProperty> tppit=tpc.listProperties();
            while(tppit.hasNext())
            {
                SemanticProperty tpp=tppit.next();
                //System.out.println("Prop:"+tpp+"\t"+tpp.getDomainClass()+"\t"+tpc+"\t"+tpc.isSubClass(tpp.getDomainClass()));
                if(tpp.getDomainClass()==null || (tpp.hasInverse() && !(tpc.equals(tpp.getDomainClass())||tpc.isSubClass(tpp.getDomainClass()))))
                {
                    //System.out.println("Remove:"+tpp.getName());
                    tppit.remove();
                    tpc.herarquicalProps.remove(tpp);
                }
            }
        }        
    }
    
    void addSemanticClass(SemanticClass tpc)
    {
        classes.put(tpc.getURI(), tpc);
        String clsid=tpc.getClassId();
        if(clsid!=null)clsbyid.put(clsid, tpc);
    }
    
    public Iterator<SemanticClass> listSemanticClasses()
    {
        return new ArrayList(classes.values()).iterator();
    }
    
    public SemanticClass getSemanticClass(String uri)
    {
        SemanticClass cls=classes.get(uri);
        if(cls==null)
        {
            OntModel ont=SWBPlatform.getSemanticMgr().getOntology().getRDFOntModel();
            try
            {
                OntClass c=ont.getOntClass(uri);
                if(c!=null)
                {
                    cls=new SemanticClass(c);
                    addSemanticClass(cls);
                }
            }catch(Exception e){log.warn(uri,e);}
        }
        return cls;
    }

    public SemanticClass getSemanticClassByID(String classID)
    {
        return clsbyid.get(classID);
    }

    
    void addSemanticProperty(SemanticProperty tpp)
    {
        if(!properties.containsKey(tpp.getURI()))
        {
            properties.put(tpp.getURI(), tpp);
        }
    }
    
    public Iterator<SemanticProperty> listSemanticProperties()
    {
        return properties.values().iterator();
    }

    public SemanticProperty getSemanticProperty(Property property)
    {
        SemanticProperty prop=properties.get(property.getURI());
        if(prop==null)
        {
            prop=new SemanticProperty(property);
            addSemanticProperty(prop);
        }
        return prop;
    }
    
    public SemanticProperty getSemanticProperty(String uri)
    {
        SemanticProperty prop=properties.get(uri);
        if(prop==null)
        {
            OntModel ont=SWBPlatform.getSemanticMgr().getOntology().getRDFOntModel();
            try
            {
                Property p=ont.getProperty(uri);
                if(p!=null)
                {
                    prop=new SemanticProperty(p);
                    addSemanticProperty(prop);
                }
            }catch(Exception e){log.warn(uri,e);}
        }
        return prop;
    }    
    
    public void registerClass(SemanticClass cls)
    {
        log.trace("Registering SemanticClass:"+cls+" --> "+cls.getClassName());
        addSemanticClass(cls);
        Iterator<SemanticProperty> propit=cls.listProperties();
        while(propit.hasNext())
        {
            SemanticProperty prop=propit.next();
            //if(tpc.equals(tpp.getDomainClass()) || tpp.hasInverse())
            {
                addSemanticProperty(prop);
            }
        }
    }    
    
    
}
