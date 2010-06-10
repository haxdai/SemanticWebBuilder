package org.semanticwb.unspsc;

import java.util.HashSet;
import java.util.Iterator;
import org.semanticwb.platform.SemanticObject;


public class Class extends org.semanticwb.unspsc.base.ClassBase 
{
    public Class(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public Iterator<Commodity> getCommodities()
    {
        HashSet<Commodity> valueToReturn=new HashSet<Commodity>();
        Iterator<Commodity> values=Commodity.ClassMgr.listCommodities();
        while(values.hasNext())
        {
            Commodity value=values.next();
            SemanticObject superobj=getSuper(value.getSemanticObject(), sclass);
            if(superobj!=null && superobj.getURI().equals(this.getURI()))
            {
                valueToReturn.add(value);
            }
        }
        return valueToReturn.iterator();
    }
}
