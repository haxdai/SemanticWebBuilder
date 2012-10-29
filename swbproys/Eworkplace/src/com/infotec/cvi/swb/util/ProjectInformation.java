/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.util;

import java.util.Date;

/**
 *
 * @author carlos.ramos
 */
class ProjectInformation {
    private String titulo;
    private String numero;
    private boolean activo;

    ProjectInformation(String titulo, String numero, Date vigencia){
        this.titulo = titulo;
        this.numero = numero;
        activo = vigencia.after(new Date());
    }

    boolean isActive() {
        return activo;
    }

    String getTitulo() {
        return titulo;
    }

    String getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "{"+titulo+","+numero+","+activo+"}";
    }
}
