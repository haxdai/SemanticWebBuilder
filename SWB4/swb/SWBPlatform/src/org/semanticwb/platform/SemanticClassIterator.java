/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.platform;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import org.semanticwb.*;

/**
 *
 * @author Jei
 */
public class SemanticClassIterator<T extends SemanticClass> implements Iterator
{
    private Iterator<SemanticClass> m_it;
    private boolean create=false;
    private SemanticClass tmp=null;
    private boolean next=false;
    private boolean retnext=false;
    
    
    public SemanticClassIterator(Iterator it)
    {
        this.m_it=it;
    }

    public boolean hasNext() 
    {
        if(!next)
        {
            boolean ret=m_it.hasNext();
            if(ret)
            {
                tmp=_next();
                if(tmp==null)ret=hasNext();
            }
            next=true;
            retnext=ret;
        }
        return retnext;
    }
    
    private SemanticClass _next()
    {
        Object obj=m_it.next();
        SemanticClass cls=null;
        if(obj instanceof Statement)
        {
            cls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(((Statement)obj).getResource().getURI());
        }else
        {
            OntClass ocls=(OntClass)obj;
            cls=SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass(ocls.getURI());
        }            
        return cls;
    }

    public T next()
    {
        if(!next)
        {
            hasNext();
        }
        next=false;
        return (T)tmp;
    }
    
    public void remove()
    {
        m_it.remove();
    }

}
