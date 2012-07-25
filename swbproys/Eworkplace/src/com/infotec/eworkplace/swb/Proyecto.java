package com.infotec.eworkplace.swb;


public class Proyecto extends com.infotec.eworkplace.swb.base.ProyectoBase 
{
    public Proyecto(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public String getNombreNumero() {
        String ret = "Sin nombre";
        
        if (getNumeroProyecto() == null && getTitle() != null) {
            ret = getTitle();
        } else if (getTitle() == null && getNumeroProyecto() != null) {
            ret = getNumeroProyecto() + "-" + ret;
        } else {
            ret = getNumeroProyecto() + "-" + getTitle();
        }
        return ret;
    }
}
