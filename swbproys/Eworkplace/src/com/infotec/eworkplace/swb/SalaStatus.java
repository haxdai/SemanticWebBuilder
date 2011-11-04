
package com.infotec.eworkplace.swb;

/**
 *
 * @author carlos.ramos
 */
public enum SalaStatus {
    Disponible("Disponible"),
    Solicitada("Solicitada"),
    Reservada("Reservada"),
    Bloqueada("Bloqueada");
    
    private String description;
    
    SalaStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public SalaStatus reset() {
        return Disponible;
    }
    
    public SalaStatus next() {
        switch(this) {
            case Disponible:
                return Solicitada;
            case Solicitada:
                return Reservada;
            case Reservada:
                return Bloqueada;
            case Bloqueada:
            default:
                return Disponible;
        }
    }
}
