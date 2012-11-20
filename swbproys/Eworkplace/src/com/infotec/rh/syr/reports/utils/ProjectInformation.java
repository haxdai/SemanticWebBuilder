/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.rh.syr.reports.utils;

import com.infotec.eworkplace.swb.Proyecto;
import java.util.Date;

/**
 *
 * @author carlos.ramos
 */
public class ProjectInformation {
    private String titulo;
    private String numero;
    private boolean activo;

    public ProjectInformation(String titulo, String numero, Date vigencia){
        this.titulo = titulo;
        this.numero = numero;
        activo = vigencia.after(new Date());
    }

    public boolean isActive() {
        return activo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNumero() {
        return numero;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
	    return true;
	}
	if (obj instanceof ProjectInformation) {
            ProjectInformation another = (ProjectInformation)obj;
            return this.numero.equals(another.getNumero());
        }
        else if(obj instanceof Proyecto) {
            Proyecto another = (Proyecto)obj;
            return this.numero.equals(another.getNumeroProyecto());
        }
	return false;
    }

    @Override
    public String toString() {
        return "{"+titulo+","+numero+","+activo+"}";
    }
}
