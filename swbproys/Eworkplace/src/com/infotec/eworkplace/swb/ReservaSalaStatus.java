
package com.infotec.eworkplace.swb;

/**
 *
 * @author carlos.ramos
 */

public enum ReservaSalaStatus {
    Enviada("Enviada"),
    Recibida("Recibida"),
    Aceptada("Aceptada"),
    Rechazada("Rechazada"),
    Cancelada("Cancelada"),
    Hecho("Hecho");
    
    private String description;
    
    ReservaSalaStatus(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public ReservaSalaStatus next() {
        switch(this) {
            case Enviada:
                return Recibida;
            case Recibida:
                return Aceptada;
            case Aceptada:
            case Rechazada:
            case Cancelada:
            default:
                return Hecho;
        }
    }
}
