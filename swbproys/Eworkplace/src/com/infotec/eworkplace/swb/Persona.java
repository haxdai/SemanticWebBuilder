package com.infotec.eworkplace.swb;

import com.infotec.eworkplace.swb.Telefono.TipoTelefono;
import java.util.List;
import org.semanticwb.SWBUtils;


public class Persona extends com.infotec.eworkplace.swb.base.PersonaBase 
{
    public Persona(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public java.util.Iterator<com.infotec.eworkplace.swb.Telefono> listTelefonoByTipo(TipoTelefono tipo) {
        List<Telefono> telefonos = SWBUtils.Collections.copyIterator(listTelefonos());
        for(Telefono tel:telefonos) {
            try {
                if(TipoTelefono.valueOf(tel.getTipo()) != tipo) {
                    telefonos.remove(tel);
                }
            }catch(IllegalArgumentException iae) {
                telefonos.remove(tel);
            }
        }
        return telefonos.iterator();
    }
}
