package com.infotec.eworkplace.swb;

import com.infotec.eworkplace.swb.Telefono.TipoTelefono;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.semanticwb.SWBUtils;


public class Persona extends com.infotec.eworkplace.swb.base.PersonaBase 
{
    public Persona(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    public java.util.Iterator<com.infotec.eworkplace.swb.Telefono> listTelefonoByTipo(TipoTelefono tipo) {
        List<Telefono> telefonos = new ArrayList(5);
        Iterator<Telefono> it = listTelefonos();
        Telefono tel;
        while(it.hasNext()) {
            tel = it.next();
            try {
                if(TipoTelefono.valueOf(tel.getTipo()) != tipo) {
                    telefonos.add(tel);
                }
            }catch(IllegalArgumentException iae) {
                telefonos.remove(tel);
            }
        }        
        return telefonos.iterator();
    }

    public void removeAllTelefonoByTipo(TipoTelefono tipo) {
        java.util.Iterator<Telefono> telefonos = listTelefonoByTipo(tipo);
        while(telefonos.hasNext()) {
            telefonos.next().remove();
        }
    }
    
    public Telefono getTelefonoByTipo(TipoTelefono tipo) {
        java.util.Iterator<Telefono> it = listTelefonoByTipo(tipo);
        if(it.hasNext())
            return it.next();
        return null;
    }
}
