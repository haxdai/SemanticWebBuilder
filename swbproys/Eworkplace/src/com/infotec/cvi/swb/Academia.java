package com.infotec.cvi.swb;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.semanticwb.model.SWBClass;


public class Academia extends com.infotec.cvi.swb.base.AcademiaBase 
{
    public Academia(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public String getMaxNivelEstudios() {
        String maxNivelEstudios = "Sin estudios";
        if(isNoAplicaEstudioSuperior()) {
            return maxNivelEstudios;
        }
            
        TreeMap<Integer, SWBClass> estudios = new TreeMap();
        
        Iterator itso = listEstudioSuperiors();
        while(itso.hasNext())
        {
            EstudioSuperior obj = (EstudioSuperior)itso.next();
            TipoEstudio tipoEstudio = obj.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv();
            estudios.put(tipoEstudio.getIndex()+obj.getGradoAvance().getIndex(), obj);
        }
        itso = listGradoAcademicos();
        while(itso.hasNext())
        {
            GradoAcademico obj = (GradoAcademico)itso.next();
            estudios.put(obj.getGrado().getIndex()+obj.getSituacionAcademica().getIndex(),obj);
        }
        try
        {
            SWBClass swbclass = estudios.get(estudios.lastKey());
            if( swbclass instanceof EstudioSuperior )
            {
                EstudioSuperior obj = (EstudioSuperior)swbclass;
                maxNivelEstudios = obj.getOtroEstudio()==null ? obj.getEstudiosSuperiores().getAreaEstudio().getTitle()+" "+obj.getEstudiosSuperiores().getTitle() : obj.getOtroEstudio(); 
            }else if( swbclass instanceof GradoAcademico )
            {
                GradoAcademico obj = (GradoAcademico)swbclass;
                maxNivelEstudios = obj.getCarrera().getTitle();
            }
        }catch(NoSuchElementException nse)
        {
        }catch(Exception e){}
        return maxNivelEstudios;
    }
    
    public String getCarrera() {
        String profesion = "Sin estudios";
        if(isNoAplicaEstudioSuperior()) {
            return profesion;
        }
        
        TreeMap<Integer, SWBClass> estudios = new TreeMap();
        
        Iterator<GradoAcademico> itso = listGradoAcademicos();
        while(itso.hasNext())
        {
            GradoAcademico obj = itso.next();
            estudios.put(obj.getGrado().getIndex()+obj.getSituacionAcademica().getIndex(),obj);
        }
        try
        {
            SWBClass swbclass = estudios.get(estudios.lastKey());
            GradoAcademico obj = (GradoAcademico)swbclass;
            profesion = obj.getCarrera().getTitle();
        }
        catch(NoSuchElementException nse)
        {
        }
        catch(Exception e){
        }
        return profesion;
    }
}
