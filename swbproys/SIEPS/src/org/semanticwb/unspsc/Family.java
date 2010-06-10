package org.semanticwb.unspsc;

import java.util.HashSet;
import java.util.Iterator;
import org.semanticwb.platform.SemanticObject;


public class Family extends org.semanticwb.unspsc.base.FamilyBase 
{
    public Family(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public Class getClass1()
    {
        Iterator<Class> values=Class.ClassMgr.listClasses();
        while(values.hasNext())
        {
            Class value=values.next();
            SemanticObject superobj=getSuper(value.getSemanticObject(), sclass);
            if(superobj!=null && superobj.getURI().equals(this.getURI()))
            {
                return value;
            }
        }
        return null;
    }
    public Iterator<Class> getClasses()
    {
        HashSet<Class> valueToReturn=new HashSet<Class>();
        Iterator<Class> ramas=Class.ClassMgr.listClasses();
        while(ramas.hasNext())
        {
            Class rama=ramas.next();
            SemanticObject superobj=getSuper(rama.getSemanticObject(), sclass);
            if(superobj!=null && superobj.getURI().equals(this.getURI()))
            {
                valueToReturn.add(rama);
            }
        }
        return valueToReturn.iterator();
    }
}
