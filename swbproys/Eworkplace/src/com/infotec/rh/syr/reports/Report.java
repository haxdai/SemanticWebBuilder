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
import com.infotec.rh.syr.reports.utils.DateArithmetic;
import com.infotec.rh.syr.reports.utils.NumberToLetterConverter;
import com.infotec.rh.syr.swb.Contrato;
import com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.semanticwb.Logger;

public class Report {
    private static Logger log = SWBUtils.getLogger(Report.class);
    
    Instance instance;
    User candidato;
    SolicitudRecurso solicitud;
    SeguimientoSolicitudRecurso seguimiento;
    Contrato contrato;
    SimpleDateFormat MM = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat MMM = new SimpleDateFormat("dd/MMM/yyyy");
    SimpleDateFormat MMMM = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getAvailableLocales()[53]); // "es_MX"
    WebSite webSite;
    UserInformation userInfo;
    Services service;
    
    public Report(final Instance instance) throws Exception
    {
        webSite = instance.getProcessInstance().getProcessType().getProcessWebPage().getWebSite();
        service = new Services();
    }
    
    public boolean exportToFile(final SeguimientoSolicitudRecurso seguimiento, final Contrato contrato) throws Exception {
        this.seguimiento = seguimiento;
        solicitud = seguimiento.getSolicitudRecurso();
        this.contrato = contrato;
        candidato = solicitud.getCandidato();
        CV cv = CV.ClassMgr.getCV(candidato.getId(), webSite);
        //userInfo = service.getUserInformation(candidato.getLogin());
        
        StringBuilder info = new StringBuilder();
        info.append(MMM.format(solicitud.getFechaInicioContrato()));
        info.append(MMM.format(seguimiento.getFechaRecepcionSolicitud()));
        info.append(solicitud.getFolio());
        info.append(solicitud.getAdscripcionSolicitante());
        info.append(solicitud.getContratacion().getTitle());
        info.append(contrato.getObservacionesContrato());
        info.append(contrato.getFolioContrato());
        info.append(contrato.getReferenciaContratacion());
        info.append(contrato.getEstatusContrato());
        info.append(contrato.getNumEmpleado());
        info.append(candidato.getFullName());
        info.append(contrato.getRFC());
        info.append(cv.getPersona().getCurp());
        info.append(contrato.getDocumentosPresentados());
        info.append(cv.getAcademia().getMaxNivelEstudios());
        info.append(cv.getAcademia().getDisciplina());
        info.append(cv.getAcademia().getCarrera());
        info.append(cv.getPersona().getDomicilio().toString());
        info.append(contrato.getClabeInterbancaria());
        info.append(contrato.getBanco().getTitle());
        info.append(contrato.getSeguridadSocial());
        info.append(MMMM.format(solicitud.getFechaInicioContrato()));
        info.append(MMMM.format(solicitud.getFechaFinContrato()));
        int rangeMonths = DateArithmetic.rangeOfMonthsBetweenDates(solicitud.getFechaInicioContrato(), solicitud.getFechaFinContrato());
        info.append(rangeMonths);
        info.append(NumberToLetterConverter.convertNumberToLetter(rangeMonths));
        info.append(MMM.format(solicitud.getFechaInicioContrato()));
        info.append(",");
        info.append(",");
        info.append(contrato.getNumeroPagos());
        info.append(contrato.getPeriodoPagos().getTitle());
        info.append(currency.format(solicitud.getSueldoBruto()));
        info.append(NumberToLetterConverter.convertNumberToLetter(solicitud.getSueldoBruto(), "Pesos", "Centavos"));
        info.append(",");
        float pagoTotal = contrato.getNumeroPagos()*solicitud.getSueldoBruto();
        info.append(currency.format(pagoTotal));
        info.append(NumberToLetterConverter.convertNumberToLetter(pagoTotal, "Pesos", "Centavos"));
        info.append(contrato.getSedeRecurso().getTitle());
        info.append(solicitud.getProyectoAsignado().getNumeroProyecto());
        info.append(solicitud.getProyectoAsignado().getTitle());
        info.append(solicitud.getProyectoAsignado().getTitle());
        info.append("to do");
        info.append(solicitud.getAdscripcionSolicitante());
        info.append(solicitud.getAutoriza());
        info.append(contrato.getCargoAutorizasolicitudContrato());
        info.append(solicitud.getSolicitante().getFullName());
        info.append(solicitud.getCapituloSuficiencia().getTitle());
        info.append(contrato.isPresentaDeclaracion()?"Si":"No");
        info.append(",");
        info.append(",");
        info.append(",");
        info.append(contrato.getFileConstanciaSFP());
        info.append(",");
        info.append(",");
        info.append(solicitud.getFuncionPrincipal());
        info.append(solicitud.getContratacion().getTitle());
        info.append(solicitud.getContratacion().getTitle());
        info.append(candidato.getLastName());
        info.append(candidato.getSecondLastName());
        info.append(candidato.getFirstName());
        info.append(contrato.getRFC().substring(0, 11));
        info.append(",");
        info.append(MM.format(cv.getPersona().getNacimiento()));
        info.append(DateArithmetic.getYear(cv.getPersona().getNacimiento()));
        info.append(DateArithmetic.rangeOfYearsBetweenDates(cv.getPersona().getNacimiento(), new Date()));
        info.append(cv.getPersona().isGenero()?"H":"M");
        info.append(cv.getPersona().isGenero()?"El":"La");
        info.append(cv.getPersona().getEstadoNacimiento().getTitle());
        info.append(cv.getPersona().getLugarNacimiento().getTitle());
        info.append(cv.getPersona().getNacionalidad().getTitle());
        info.append(MMMM.format(contrato.getFechaEntregaRH()));
        try {
            write(info.toString());
            return true;
        }catch(Exception e) {
            log.error(e);
            return false;
        }
    }
    
    private boolean write(final String info) throws Exception {
        boolean res = false;
        BufferedWriter bfw = null;
        final String path = SWBUtils.getApplicationPath()+"/work/models/"+instance.getProcessInstance().getProcessType().getProcessWebPage().getWebSiteId()+"/data/procesos/contratos/"+contrato.getId()+".csv";
        try
        {
            File fichero = new File(path);
            FileWriter fstream = new FileWriter(fichero);
            bfw = new BufferedWriter(fstream);
            bfw.write(info);
            res = true;
        }
        /*catch (Exception e)
        {
            System.err.println("Error: " + e.getMessage());
            log.error(e);
        }*/      
        finally
        {
            if(bfw!=null)
            {
                try {
                    bfw.close();
                }catch(IOException ioe) {
                }
            }
            bfw = null;
        }
        return res;
    }
}


