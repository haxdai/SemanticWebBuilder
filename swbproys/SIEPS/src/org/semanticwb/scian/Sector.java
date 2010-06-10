package org.semanticwb.scian;

import java.util.HashSet;
import java.util.Iterator;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;


public class Sector extends org.semanticwb.scian.base.SectorBase 
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
    public Sector(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    public Iterator<SubSector> getSubSectores()
    {
        HashSet<SubSector> getSubSectores=new HashSet<SubSector>();
        Iterator<SubSector> subsectores=SubSector.ClassMgr.listSubSectors();
        while(subsectores.hasNext())
        {
            SubSector subsector=subsectores.next();
            SemanticObject sector=getSuper(subsector.getSemanticObject(), Sector.sclass);
            if(sector.getURI().equals(this.getURI()))
            {
                getSubSectores.add(subsector);
            }
        }
        return getSubSectores.iterator();
    }
}
