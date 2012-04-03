package com.infotec.eworkplace.swb;


public class ReservacionSala extends com.infotec.eworkplace.swb.base.ReservacionSalaBase 
{
    public enum TipoReunion {
        Interna,
        Externa;
    }
    
    public ReservacionSala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
