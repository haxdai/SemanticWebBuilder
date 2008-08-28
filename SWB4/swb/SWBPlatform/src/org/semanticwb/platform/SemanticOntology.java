/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.platform;

import com.hp.hpl.jena.ontology.OntModel;
import java.util.Iterator;
import java.util.Map.Entry;
import org.semanticwb.SWBPlatform;
import org.semanticwb.model.GenericObject;

/**
 *
 * @author Jei
 */
public class SemanticOntology
{
    private OntModel m_ontology;
    private String m_name;

    public SemanticOntology(String name, OntModel ontology)
    {
        this.m_ontology=ontology;
        this.m_name=name;
        init();
    }    
    
    private void init()
    {
        
    }

    public String getName() {
        return m_name;
    }
    
    public OntModel getRDFOntModel()
    {
        return m_ontology;
    }
    
    public void addSubModel(SemanticModel model, boolean rebind)
    {
        m_ontology.addSubModel(model.getRDFModel(),rebind);
    }
    
    public void rebind()
    {
        m_ontology.rebind();
    }
    
    public SemanticObject getSemanticObject(String uri)
    {
        SemanticObject ret=null;
        Iterator<Entry<String, SemanticModel>> it=SWBPlatform.getSemanticMgr().getModels().iterator();
        while(it.hasNext())
        {
            Entry<String, SemanticModel> ent=it.next();
            SemanticModel model=ent.getValue();
            ret=model.getSemanticObject(uri);
            if(ret!=null)break;
        }
        return ret;        
    }
    
    public GenericObject getGenericObject(String uri, SemanticClass cls)
    {
        return cls.newGenericInstance(getSemanticObject(uri));        
    }
}
