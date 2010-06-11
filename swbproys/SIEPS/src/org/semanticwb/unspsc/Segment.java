package org.semanticwb.unspsc;

import java.util.HashSet;
import java.util.Iterator;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;


public class Segment extends org.semanticwb.unspsc.base.SegmentBase 
{
    public static SemanticObject getSuper(SemanticObject obj,SemanticClass clazz)
    {
        org.semanticwb.platform.SemanticProperty prop=obj.getModel().getSemanticProperty(org.semanticwb.platform.SemanticVocabulary.RDFS_SUBCLASSOF);
        Iterator<org.semanticwb.platform.SemanticObject> parents=obj.listObjectProperties(prop);
        while(parents.hasNext())
        {
            org.semanticwb.platform.SemanticObject temp=parents.next();
            if(clazz.equals(temp.getSemanticClass()))
            {
                return temp;
            }
        }
        return null;
    }
    public Segment(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public Family getFamily()
    {
        Iterator<Family> values=Family.ClassMgr.listFamilies();
        while(values.hasNext())
        {
            Family value=values.next();
            SemanticObject superobj=getSuper(value.getSemanticObject(), sclass);
            if(superobj!=null && superobj.getURI().equals(this.getURI()))
            {
                return value;
            }
        }
        return null;
    }
    public Iterator<Family> getFamilies()
    {
        HashSet<Family> valueToReturn=new HashSet<Family>();
        Iterator<Family> ramas=Family.ClassMgr.listFamilies();
        while(ramas.hasNext())
        {
            Family rama=ramas.next();
            SemanticObject superobj=getSuper(rama.getSemanticObject(), sclass);
            if(superobj!=null && superobj.getURI().equals(this.getURI()))
            {
                valueToReturn.add(rama);
            }
        }
        return valueToReturn.iterator();
    }
}
