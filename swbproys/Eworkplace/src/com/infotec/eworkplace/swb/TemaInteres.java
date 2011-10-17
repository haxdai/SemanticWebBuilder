package com.infotec.eworkplace.swb;


public class TemaInteres extends com.infotec.eworkplace.swb.base.TemaInteresBase 
{
    public TemaInteres(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    @Override
    public int hashCode() {
        return getId().hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(obj instanceof TemaInteres) {
            return hashCode()==obj.hashCode();
        }
        return false;
    }
}
