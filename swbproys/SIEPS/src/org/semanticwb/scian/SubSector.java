package org.semanticwb.scian;

import java.util.HashSet;
import java.util.Iterator;
import org.semanticwb.platform.SemanticObject;


public class SubSector extends org.semanticwb.scian.base.SubSectorBase 
{
    public SubSector(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public Iterator<Rama> getRamas()
    {
        HashSet<Rama> getRamas=new HashSet<Rama>();
        Iterator<Rama> ramas=Rama.ClassMgr.listRamas();
        while(ramas.hasNext())
        {
            Rama rama=ramas.next();
            SemanticObject superobj=getSuper(rama.getSemanticObject(), SubSector.sclass);
            if(superobj!=null && superobj.getURI().equals(this.getURI()))
            {
                getRamas.add(rama);
            }
        }
        return getRamas.iterator();
    }
}
