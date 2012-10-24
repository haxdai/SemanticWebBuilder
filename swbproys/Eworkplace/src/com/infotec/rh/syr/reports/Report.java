/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.rh.syr.reports;

/**
 *
 * @author carlos.ramos
 */
import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.EstudioSuperior;
import com.infotec.cvi.swb.Grado;
import com.infotec.cvi.swb.GradoAcademico;
import com.infotec.cvi.swb.SolicitudRecurso;
import com.infotec.cvi.swb.TipoEstudio;
import com.infotec.rh.syr.swb.Contrato;
import com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.process.model.Instance;

import mx.com.infotec.intranet.login.Services;
import mx.com.infotec.intranet.login.UserInformation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Report {
    Instance instance;
    User solicitante;
    CV cv;
    SolicitudRecurso solicitud;
    SeguimientoSolicitudRecurso seguimiento;
    Contrato contrato;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    WebSite webSite;
    UserInformation userInfo;
    
    public Report(final Instance instance, final SeguimientoSolicitudRecurso seguimiento, final Contrato contrato) throws Exception
    {
        this.seguimiento = seguimiento;
        this.solicitud = seguimiento.getSolicitudRecurso();
        this.contrato = contrato;
        solicitante = solicitud.getCandidatoSeleccionado();
        cv = CV.ClassMgr.getCV(solicitante.getId(), instance.getProcessInstance().getProcessType().getProcessWebPage().getWebSite());
        Services s = new Services();
        userInfo = s.getUserInformation(solicitante.getLogin());
    }
    
    public String getFechaRecepcionSolicitud() {
        return sdf.format(seguimiento.getFechaRecepcionSolicitud());
    }
    
    public String getFolioMemo() {
        return solicitud.getFolio();
    }
    
    public String getArea() {
        return solicitud.getProyectoAsignado().getAreaDelProyecto();
    }
    
    public String getTipoContratacion() {
        return solicitud.getContratacion().getTitle();
    }
    
    public String getObservaciones() {
        return contrato.getObservacionesContrato();
    }
    
    public String getFolioContrato() {
        return contrato.getFolioContrato();
    }
    
    public String getReferenciaContratacion() {
        return contrato.getReferenciaContratacion();
    }
    
    public String getEstatusContrato() {
        return contrato.getEstatusContrato();
    }
    
    public int getNumeroEmpleado() {
        return contrato.getNumEmpleado();
    }
    
    public String getNombreCompleto() {
        return solicitante.getFullName();
    }
    
    public String getRFC() {
        return userInfo.getRFC();
    }
    
    public String getCURP() {
        return userInfo.getCURP();
    }
    
    public String getConstanciaEstudios() {
        return this.contrato.getDocumentosPresentados();
    }
    
    public String getMaxNivelEstudios() {
        String maxNivelEstudios = "--";
        
        List sortables = new ArrayList();
        Iterator itso = cv.getAcademia().listEstudioSuperiors();
        while(itso.hasNext())
        {
            EstudioSuperior obj = (EstudioSuperior)itso.next();        
            sortables.add(obj.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv());            
        }
        itso = cv.getAcademia().listGradoAcademicos();
        while(itso.hasNext())
        {
            GradoAcademico obj = (GradoAcademico)itso.next();
            sortables.add(obj.getGrado());
        }
        itso = SWBComparator.sortSortableObject(sortables.iterator());
        sortables = SWBUtils.Collections.copyIterator(itso);
        Collections.reverse(sortables);
        if(!sortables.isEmpty())
        {
            if( sortables.get(0) instanceof TipoEstudio )
            {
                maxNivelEstudios = ((TipoEstudio)sortables.get(0)).getTitle();
            }
            else if( sortables.get(0) instanceof Grado )
            {
                maxNivelEstudios = ((Grado)sortables.get(0)).getTitle();
            }
        }
        
                
        /*List sorables = new ArrayList();
        Iterator itso = webSite.getSemanticModel().listInstancesOfClass(Sortable.swb_Sortable);
        Sortable sortable;
        GenericObject gobj;
        while(itso.hasNext()) {
            SemanticObject sobj = (SemanticObject)itso.next();        
            gobj = sobj.getGenericInstance();
            if( gobj instanceof Grado || gobj instanceof TipoEstudio) {
                sortable = (Sortable)gobj;
                System.out.println("sortable="+sortable);
                sortables.add(sortable);
            }
        }
        itso = SWBComparator.sortSortableObject(sortables.iterator());
        sortables = SWBUtils.Collections.copyIterator(itso);
        if(!sortables.isEmpty())
            maxNivelEstudios = ((Catalogo)sortables.get(sortables.size()-1)).getTitle();*/
        return maxNivelEstudios;
    }
    
    public String getConocimientos() {
        StringBuilder conocimientos = new StringBuilder();
        Iterator<EstudioSuperior> it = cv.getAcademia().listEstudioSuperiors();
        while(it.hasNext())
        {
            EstudioSuperior es = it.next();
            conocimientos.append(es.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTitle());
            conocimientos.append(" ");
            conocimientos.append(es.getEstudiosSuperiores().getAreaEstudio().getTitle());
            conocimientos.append(" ");
        }
        return conocimientos.toString();
    }
    
    public String getProfesion() {
        StringBuilder profesion = new StringBuilder();
        Iterator<GradoAcademico> it = cv.getAcademia().listGradoAcademicos();
        while(it.hasNext())
        {
            GradoAcademico ga = it.next();
            profesion.append(ga.getCarrera().getTitle());
            profesion.append(" ");
        }
        return profesion.toString();
    }
    
    int getCveInterbancaria() {
        return this.contrato.getClabeInterbancaria();
    }
    
    String getBanco() {
        return this.contrato.getBanco().getTitle();
    }
    
    String getNSS() {
        return "NSS";
    }
}


