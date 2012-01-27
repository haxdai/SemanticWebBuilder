package com.infotec.eworkplace.swb;


public class Date extends com.infotec.eworkplace.swb.base.DateBase 
{
    public Date(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public int hashCode() {
        return getURI().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        
        if(obj instanceof Date) {
            return hashCode()==obj.hashCode();
        }
        return false;
    }
}
