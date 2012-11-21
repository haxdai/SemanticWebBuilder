package com.infotec.eworkplace.swb;


public class Domicilio extends com.infotec.eworkplace.swb.base.DomicilioBase 
{
    public Domicilio(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public String toString() {
        StringBuilder d = new StringBuilder();
        d.append(getCalle());
        d.append(" ");
        d.append(getNumExterior());
        d.append(" ");
        if(!getNumInterior().isEmpty()) {            
            d.append("Int."+getNumInterior());
            d.append(" ");
        }
        d.append(getCp());
        d.append(" ");
        d.append(getColonia());
        d.append(" ");
        d.append(getMunicipio()==null?"":getMunicipio().getTitle()+" ");        
        d.append(getEntidad()==null?"":getEntidad().getTitle()+" ");
        d.append(getPais()==null?"":getPais().getTitle()+" ");
        return d.toString();
    }
}
