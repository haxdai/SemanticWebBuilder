package com.infotec.eworkplace.swb;

import com.infotec.cvi.swb.util.ProjectInformation;


public class Proyecto extends com.infotec.eworkplace.swb.base.ProyectoBase 
{
    public Proyecto(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public String getNombreNumero() {
        String ret = null;
        
        if (getNumeroProyecto() == null && getTitle() != null) {
            ret = getTitle();
        } else if (getTitle() == null && getNumeroProyecto() != null) {
            ret = getNumeroProyecto() + "-" + ret;
        } else {
            ret = getNumeroProyecto() + "-" + getTitle();
        }
        return ret;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
	    return true;
	}
	if (obj instanceof Proyecto) {            
            Proyecto another = (Proyecto)obj;
            return getNumeroProyecto().equals(another.getNumeroProyecto());
        }
        else if(obj instanceof ProjectInformation) {
            ProjectInformation another = (ProjectInformation)obj;
            return getNumeroProyecto().equals(another.getNumero());
        }
	return false;
    }
}
