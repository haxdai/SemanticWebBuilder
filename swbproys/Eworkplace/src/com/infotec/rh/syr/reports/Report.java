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
import com.infotec.cvi.swb.SolicitudRecurso;
import com.infotec.rh.syr.reports.utils.DateArithmetic;
import com.infotec.rh.syr.reports.utils.NumberToLetterConverter;
import com.infotec.rh.syr.swb.Contrato;
import com.infotec.rh.syr.swb.SeguimientoSolicitudPromocion;
import com.infotec.rh.syr.swb.SeguimientoSolicitudRecurso;
import com.infotec.rh.syr.swb.SolicitudBajaRecurso;
import com.infotec.rh.syr.swb.SolicitudPromocion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.process.model.Instance;

import mx.com.infotec.intranet.login.Services;
import mx.com.infotec.intranet.login.UserInformation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.semanticwb.Logger;

public class Report {
    private static Logger log = SWBUtils.getLogger(Report.class);
    
    Instance instance;
    User candidato;

    Contrato contrato;
    SimpleDateFormat MM;
    SimpleDateFormat MMM;
    SimpleDateFormat MMMM;
    NumberFormat currency;
    WebSite webSite;
    //UserInformation userInfo;
    Services service;
    
    public Report(final Instance instance) throws Exception
    {
        this(instance, Locale.getAvailableLocales()[53]); //es_MX
    }
    
    public Report(final Instance instance, Locale locale) throws Exception
    {
        this.instance = instance;
        webSite = instance.getProcessInstance().getProcessType().getProcessWebPage().getWebSite();
        service = new Services();
        
        MM = new SimpleDateFormat("dd/MM/yyyy", locale);
        MMM = new SimpleDateFormat("dd/MMM/yyyy", locale);
        MMMM = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", locale);
        currency = NumberFormat.getCurrencyInstance(locale);
    }
    
    public boolean exportToFile(final SeguimientoSolicitudRecurso seguimiento, final Contrato contrato) throws Exception {
        return exportToFile(seguimiento, contrato, ";");
    }
    
    public boolean exportToFile(final SeguimientoSolicitudRecurso seguimiento, final Contrato contrato, String delimitador) throws Exception {
        SolicitudRecurso solicitud = seguimiento.getSolicitudRecurso();
        if(delimitador==null)
            delimitador = ";";
        
        this.contrato = contrato;
        candidato = solicitud.getCandidatoSeleccionado();
        CV cv = CV.getCVClassMgr().getCV(candidato.getId(), webSite);
        //userInfo = service.getUserInformation(candidato.getLogin());
        StringBuilder info = new StringBuilder();
        info.append(MMM.format(solicitud.getFechaInicioContrato())).append(delimitador);
        info.append(MMM.format(seguimiento.getFechaRecepcionSolicitud())).append(delimitador);
        info.append(solicitud.getFolio()).append(delimitador);
        info.append(solicitud.getAdscripcionSolicitante()).append(delimitador);
        info.append(solicitud.getContratacion().getTitle()).append(delimitador);
        info.append(contrato.getObservacionesContrato()).append(delimitador);
        info.append(contrato.getFolioContrato()).append(delimitador);
        info.append(contrato.getReferenciaContratacion()).append(delimitador);
        info.append(contrato.getEstatusContrato()).append(delimitador);
        info.append(contrato.getNumEmpleado()).append(delimitador);
        info.append(candidato.getFullName()).append(delimitador);
        info.append(contrato.getRFC()).append(delimitador);
        info.append(cv.getPersona().getCurp()).append(delimitador);
        info.append(contrato.getDocumentosPresentados()).append(delimitador);
        info.append(cv.getAcademia().getMaxNivelEstudios()).append(delimitador);
        info.append(cv.getAcademia().getDisciplina()).append(delimitador);
        info.append(cv.getAcademia().getCarrera()).append(delimitador);
        info.append(cv.getPersona().getDomicilio().toString()).append(delimitador);
        info.append(contrato.getClabeInterbancaria()).append(delimitador);
        info.append(contrato.getBanco().getTitle()).append(delimitador);
        info.append(contrato.getSeguridadSocial()).append(delimitador);
        info.append(MMMM.format(contrato.getFechaIngresoInfotec())).append(delimitador);
        info.append(MMMM.format(solicitud.getFechaInicioContrato())).append(delimitador);
        info.append(MMMM.format(solicitud.getFechaFinContrato())).append(delimitador);
        int rangeMonths = DateArithmetic.rangeOfMonthsBetweenDates(solicitud.getFechaInicioContrato(), solicitud.getFechaFinContrato())+1;
        info.append(rangeMonths).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(rangeMonths)).append(delimitador);
        info.append(MMM.format(solicitud.getFechaInicioContrato())).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(contrato.getNumeroPagos()).append(delimitador);
        info.append(contrato.getPeriodoPagos().getTitle()).append(delimitador);
        BigDecimal sueldoBruto = new BigDecimal(solicitud.getSueldoBruto());
        info.append(currency.format(sueldoBruto)).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(sueldoBruto.doubleValue(), "Pesos", "Centavos")).append(delimitador);
        BigDecimal periodoPago = new BigDecimal(contrato.getPeriodoPagos().getIndex());
        BigDecimal parcialidad = sueldoBruto.divide(periodoPago);
        info.append(currency.format(parcialidad)).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(parcialidad.doubleValue(), "Pesos", "Centavos")).append(delimitador);
        info.append(delimitador);
        BigDecimal pagoTotal = new BigDecimal(contrato.getNumeroPagos()*solicitud.getSueldoBruto());
        info.append(currency.format(pagoTotal)).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(pagoTotal.doubleValue(), "Pesos", "Centavos")).append(delimitador);
        info.append(contrato.getSedeRecurso().getTitle()).append(delimitador);
        info.append(solicitud.getProyectoAsignado().getNumeroProyecto()).append(delimitador);
        info.append(solicitud.getProyectoAsignado().getTitle()).append(delimitador);
        info.append(solicitud.getProyectoAsignado().getTitle()).append(delimitador);
        info.append("to do").append(delimitador);
        info.append(solicitud.getAdscripcionSolicitante()).append(delimitador);
        info.append(solicitud.getAutoriza()).append(delimitador);
        info.append(contrato.getCargoAutorizasolicitudContrato()).append(delimitador);
        info.append(solicitud.getSolicitante().getFullName()).append(delimitador);
        info.append(solicitud.getCapituloSuficiencia().getTitle()).append(delimitador);
        info.append(contrato.isPresentaDeclaracion()?"Si":"No").append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(contrato.getFileConstanciaSFP()).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(solicitud.getFuncionPrincipal()).append(delimitador);
        info.append(solicitud.getContratacion().getTitle()).append(delimitador);
        info.append(solicitud.getContratacion().getTitle()).append(delimitador);
        info.append(candidato.getLastName()).append(delimitador);
        info.append(candidato.getSecondLastName()).append(delimitador);
        info.append(candidato.getFirstName()).append(delimitador);
        info.append(contrato.getRFC().substring(0, 10)).append(delimitador);
        //info.append(contrato.getRFC().substring(10)).append(delimitador);
        info.append(delimitador);
        info.append(MM.format(cv.getPersona().getNacimiento())).append(delimitador);
        info.append(DateArithmetic.getYear(cv.getPersona().getNacimiento())).append(delimitador);
        info.append(DateArithmetic.rangeOfYearsBetweenDates(cv.getPersona().getNacimiento(), new Date())).append(delimitador);
        info.append(cv.getPersona().isGenero()?"H":"M").append(delimitador);
        info.append(cv.getPersona().isGenero()?"El":"La").append(delimitador);
        info.append(cv.getPersona().getEstadoNacimiento().getTitle()).append(delimitador);
        info.append(cv.getPersona().getLugarNacimiento()==null?"-":cv.getPersona().getLugarNacimiento().getTitle()).append(delimitador);
        info.append(cv.getPersona().getNacionalidad()==null?"-":cv.getPersona().getNacionalidad().getTitle()).append(delimitador);
        info.append(MMMM.format(contrato.getFechaEntregaRH()));
        try {
            write(info.toString());
            return true;
        }catch(Exception e) {
            log.error(e);
            return false;
        }
    }
    
    public boolean exportToFile(final SeguimientoSolicitudPromocion seguimiento, final Contrato contrato) throws Exception {
        return exportToFile(seguimiento, contrato, ";");
    }
    
    public boolean exportToFile(final SeguimientoSolicitudPromocion seguimiento, final Contrato contrato, String delimitador) throws Exception
    {
        SolicitudPromocion solicitud = seguimiento.getSolicitudPromocion();
        if(delimitador==null)
            delimitador = ";";
        
        this.contrato = contrato;
        candidato = solicitud.getRecursoPromocionar();
        UserInformation userInfo = service.getUserInformation(candidato.getLogin());
        CV cv = CV.getCVClassMgr().getCV(candidato.getId(), webSite);
        //userInfo = service.getUserInformation(candidato.getLogin());
        StringBuilder info = new StringBuilder();
        info.append(MMM.format(solicitud.getFechaInicioNuevoPuesto()));
        info.append(delimitador);
        info.append(solicitud.getFolio()).append(delimitador);
        info.append(solicitud.getAdscripcionSolicitante()).append(delimitador);
        info.append(userInfo.getTipoContratacion().getDescription()).append(delimitador);
        info.append(contrato.getObservacionesContrato()).append(delimitador);
        info.append(contrato.getFolioContrato()).append(delimitador);
        info.append(contrato.getReferenciaContratacion()).append(delimitador);
        info.append(contrato.getEstatusContrato()).append(delimitador);
        info.append(contrato.getNumEmpleado()).append(delimitador);
        info.append(userInfo.getFullName()).append(delimitador);
        info.append(userInfo.getRFC()).append(delimitador);
        info.append(userInfo.getCurp()).append(delimitador);
        info.append(contrato.getDocumentosPresentados()).append(delimitador);
        info.append(cv.getAcademia().getMaxNivelEstudios()).append(delimitador);
        info.append(cv.getAcademia().getDisciplina()).append(delimitador);
        info.append(cv.getAcademia().getCarrera()).append(delimitador);
        info.append(cv.getPersona().getDomicilio().toString()).append(delimitador);
        info.append(contrato.getClabeInterbancaria()).append(delimitador);
        info.append(contrato.getBanco().getTitle()).append(delimitador);
        info.append(contrato.getSeguridadSocial()).append(delimitador);
        info.append(MMMM.format(contrato.getFechaIngresoInfotec())).append(delimitador);
        info.append(MMMM.format(solicitud.getFechaInicioNuevoPuesto())).append(delimitador);
        info.append(MMMM.format(solicitud.getFechaTerminoNuevoPuesto())).append(delimitador);
        int rangeMonths = DateArithmetic.rangeOfMonthsBetweenDates(solicitud.getFechaInicioNuevoPuesto(), solicitud.getFechaTerminoNuevoPuesto())+1;
        info.append(rangeMonths).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(rangeMonths)).append(delimitador);
        info.append(MMM.format(solicitud.getFechaInicioNuevoPuesto())).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(contrato.getNumeroPagos()).append(delimitador);
        info.append(contrato.getPeriodoPagos().getTitle()).append(delimitador);
        BigDecimal sueldoBruto = new BigDecimal(solicitud.getSueldoBrutoPropuesto());
        info.append(currency.format(sueldoBruto)).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(sueldoBruto.doubleValue(), "Pesos", "Centavos")).append(delimitador);
        BigDecimal periodoPago = new BigDecimal(contrato.getPeriodoPagos().getIndex());
        BigDecimal parcialidad = sueldoBruto.divide(periodoPago);
        info.append(currency.format(parcialidad)).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(parcialidad.doubleValue(), "Pesos", "Centavos")).append(delimitador);
        info.append(delimitador);
        BigDecimal pagoTotal = new BigDecimal(contrato.getNumeroPagos()*solicitud.getSueldoBrutoPropuesto());
        info.append(currency.format(pagoTotal)).append(delimitador);
        info.append(NumberToLetterConverter.convertNumberToLetter(pagoTotal.doubleValue(), "Pesos", "Centavos")).append(delimitador);
        info.append(contrato.getSedeRecurso().getTitle()).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append("to do").append(delimitador);
        info.append(userInfo.getArea()).append(delimitador);
        info.append(delimitador); //seguimientoPromocion.autorizadoDirectorPromocion
        info.append(contrato.getCargoAutorizasolicitudContrato()).append(delimitador);
        info.append(solicitud.getSolicitante().getFullName()).append(delimitador);
        info.append(delimitador); //seguimientoPromocion.capituloSuficiencia
        info.append(contrato.isPresentaDeclaracion()?"Si":"No").append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(contrato.getFileConstanciaSFP()).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador); //solicitudRecurso.funcionPrincipal
        info.append(userInfo.getTipoContratacion().getDescription()).append(delimitador);
        info.append(userInfo.getTipoContratacion().getDescription()).append(delimitador);
        info.append(userInfo.getPApellido()).append(delimitador);
        info.append(userInfo.getSApellido()).append(delimitador);
        info.append(userInfo.getPrimerNombre()+(userInfo.getSegundoNombre()==null?"":" "+userInfo.getSegundoNombre())).append(delimitador);
        info.append(userInfo.getRFC().substring(0, 10)).append(delimitador);
        //info.append(contrato.getRFC().substring(10)).append(delimitador);
        info.append(delimitador);
        info.append(MM.format(cv.getPersona().getNacimiento())).append(delimitador);
        info.append(DateArithmetic.getYear(cv.getPersona().getNacimiento())).append(delimitador);
        info.append(DateArithmetic.rangeOfYearsBetweenDates(cv.getPersona().getNacimiento(), new Date())).append(delimitador);
        info.append(cv.getPersona().isGenero()?"H":"M").append(delimitador);
        info.append(cv.getPersona().isGenero()?"El":"La").append(delimitador);
        info.append(cv.getPersona().getEstadoNacimiento().getTitle()).append(delimitador);
        info.append(cv.getPersona().getLugarNacimiento()==null?"-":cv.getPersona().getLugarNacimiento().getTitle()).append(delimitador);
        info.append(cv.getPersona().getNacionalidad()==null?"-":cv.getPersona().getNacionalidad().getTitle()).append(delimitador);
        info.append(MMMM.format(contrato.getFechaEntregaRH()));
        try {
            write(info.toString());
            return true;
        }catch(Exception e) {
            log.error(e);
            return false;
        }
    }
    
    public boolean exportToFile(final SolicitudBajaRecurso solicitud, final Contrato contrato) throws Exception {
        return exportToFile(solicitud, contrato, ";");
    }
    
    public boolean exportToFile(final SolicitudBajaRecurso solicitud, final Contrato contrato, String delimitador) throws Exception
    {
        if(delimitador==null)
            delimitador = ";";
        
        this.contrato = contrato;
        candidato = solicitud.getEmpleadoBaja();
        UserInformation userInfo = service.getUserInformation(candidato.getLogin());
        CV cv = CV.getCVClassMgr().getCV(candidato.getId(), webSite);
        //userInfo = service.getUserInformation(candidato.getLogin());
        StringBuilder info = new StringBuilder();
        info.append(MMM.format(solicitud.getFechaFinContratoBaja()));
        info.append(delimitador);
        info.append(solicitud.getFolio()).append(delimitador);
        info.append(solicitud.getAdscripcionSolicitante()).append(delimitador);
        info.append(userInfo.getTipoContratacion().getDescription()).append(delimitador);
        info.append(contrato.getObservacionesContrato()).append(delimitador);
        info.append(contrato.getFolioContrato()).append(delimitador);
        info.append(contrato.getReferenciaContratacion()).append(delimitador);
        info.append(contrato.getEstatusContrato()).append(delimitador);
        info.append(contrato.getNumEmpleado()).append(delimitador);
        info.append(userInfo.getFullName()).append(delimitador);
        info.append(userInfo.getRFC()).append(delimitador);
        info.append(userInfo.getCurp()).append(delimitador);
        info.append(contrato.getDocumentosPresentados()).append(delimitador);
        info.append(cv.getAcademia().getMaxNivelEstudios()).append(delimitador);
        info.append(cv.getAcademia().getDisciplina()).append(delimitador);
        info.append(cv.getAcademia().getCarrera()).append(delimitador);
        info.append(cv.getPersona().getDomicilio().toString()).append(delimitador);
        info.append(contrato.getClabeInterbancaria()).append(delimitador);
        info.append(contrato.getBanco().getTitle()).append(delimitador);
        info.append(contrato.getSeguridadSocial()).append(delimitador);
        info.append(MMMM.format(contrato.getFechaIngresoInfotec())).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        //int rangeMonths = DateArithmetic.rangeOfMonthsBetweenDates(solicitud.getFechaInicioNuevoPuesto(), solicitud.getFechaTerminoNuevoPuesto())+1;
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(MMMM.format(solicitud.getFechaFinContratoBaja()));
        info.append(solicitud.getMotivoBaja());
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(contrato.getSedeRecurso().getTitle()).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append("to do").append(delimitador);
        info.append(userInfo.getArea()).append(delimitador);
        info.append(contrato.getCargoAutorizasolicitudContrato()).append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(delimitador);
        info.append(userInfo.getTipoContratacion().getDescription()).append(delimitador);
        info.append(userInfo.getTipoContratacion().getDescription()).append(delimitador);
        info.append(userInfo.getPApellido()).append(delimitador);
        info.append(userInfo.getSApellido()).append(delimitador);
        info.append(userInfo.getPrimerNombre()+(userInfo.getSegundoNombre()==null?"":" "+userInfo.getSegundoNombre())).append(delimitador);
        info.append(userInfo.getRFC().substring(0, 10)).append(delimitador);
        //info.append(contrato.getRFC().substring(10)).append(delimitador);
        info.append(delimitador);
        info.append(MM.format(cv.getPersona().getNacimiento())).append(delimitador);
        info.append(DateArithmetic.getYear(cv.getPersona().getNacimiento())).append(delimitador);
        info.append(DateArithmetic.rangeOfYearsBetweenDates(cv.getPersona().getNacimiento(), new Date())).append(delimitador);
        info.append(cv.getPersona().isGenero()?"H":"M").append(delimitador);
        info.append(cv.getPersona().isGenero()?"El":"La").append(delimitador);
        info.append(cv.getPersona().getEstadoNacimiento().getTitle()).append(delimitador);
        info.append(cv.getPersona().getLugarNacimiento()==null?"-":cv.getPersona().getLugarNacimiento().getTitle()).append(delimitador);
        info.append(cv.getPersona().getNacionalidad()==null?"-":cv.getPersona().getNacionalidad().getTitle()).append(delimitador);
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


