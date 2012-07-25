package com.infotec.eworkplace.swb;


public class Proyecto extends com.infotec.eworkplace.swb.base.ProyectoBase 
{
    public Proyecto(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public String getNombreNumero() {
        return getNumeroProyecto() + "-" + getTitle();
    }
}
