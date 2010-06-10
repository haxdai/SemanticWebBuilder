package org.semanticwb.scian;

import java.util.HashSet;
import java.util.Iterator;
import org.semanticwb.platform.SemanticObject;


public class Rama extends org.semanticwb.scian.base.RamaBase 
{
    public Rama(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public Iterator<SubRama> getSubRamas()
    {
        HashSet<SubRama> getSubRamas=new HashSet<SubRama>();
        Iterator<SubRama> ramas=SubRama.ClassMgr.listSubRamas();
        while(ramas.hasNext())
        {
            SubRama temp=ramas.next();
            SemanticObject superobj=getSuper(temp.getSemanticObject(), sclass);
            if(superobj!=null && superobj.getURI().equals(getURI()))
            {
                getSubRamas.add(temp);
            }
        }
        return getSubRamas.iterator();
    }
}
