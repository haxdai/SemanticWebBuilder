package org.semanticwb.scian;

import java.util.HashSet;
import java.util.Iterator;
import org.semanticwb.platform.SemanticObject;


public class SubRama extends org.semanticwb.scian.base.SubRamaBase 
{
    public SubRama(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public Iterator<Clase> getClasses()
    {
        HashSet<Clase> getClasses=new HashSet<Clase>();
        Iterator<Clase> classes=Clase.ClassMgr.listClases();
        while(classes.hasNext())
        {
            Clase temp=classes.next();
            SemanticObject superobj=getSuper(temp.getSemanticObject(), sclass);
            if(superobj!=null && superobj.getURI().equals(getURI()))
            {
                getClasses.add(temp);
            }
        }
        return getClasses.iterator();
    }
}
