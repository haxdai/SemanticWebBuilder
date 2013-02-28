<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="com.infotec.cvi.swb.*" %>
<%@page import="com.infotec.rh.syr.swb.*" %>
<%@page import="mx.com.infotec.intranet.login.*" %>

<%@page import="org.semanticwb.SWBUtils" %>
<%@page import="org.semanticwb.model.*" %>
<%@page import="org.semanticwb.process.model.Instance" %>

<%@page import="java.text.*" %>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@page import="javax.servlet.jsp.JspWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
<%!
    public String getMaxNivelEstudios(CV cv) {
        String maxNivelEstudios = "Sin estudios";
        if(cv.getAcademia().isNoAplicaEstudioSuperior()) {
            return maxNivelEstudios;
        }
            
        TreeMap<Integer, SWBClass> estudios = new TreeMap();
        
        Iterator itso = cv.getAcademia().listEstudioSuperiors();
        while(itso.hasNext())
        {
            EstudioSuperior obj = (EstudioSuperior)itso.next();
            TipoEstudio tipoEstudio = obj.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv();
            estudios.put(tipoEstudio.getIndex()+obj.getGradoAvance().getIndex(), obj);
        }
        itso = cv.getAcademia().listGradoAcademicos();
        while(itso.hasNext())
        {
            GradoAcademico obj = (GradoAcademico)itso.next();
            estudios.put(obj.getGrado().getIndex()+obj.getSituacionAcademica().getIndex(),obj);
        }
        try
        {
            SWBClass swbclass = estudios.get(estudios.lastKey());
            if( swbclass instanceof EstudioSuperior )
            {
                EstudioSuperior obj = (EstudioSuperior)swbclass;
                maxNivelEstudios = obj.getOtroEstudio()==null ? obj.getEstudiosSuperiores().getAreaEstudio().getTitle()+" "+obj.getEstudiosSuperiores().getTitle() : obj.getOtroEstudio(); 
            }else if( swbclass instanceof GradoAcademico )
            {
                GradoAcademico obj = (GradoAcademico)swbclass;
                maxNivelEstudios = obj.getCarrera().getTitle();
            }
        }catch(NoSuchElementException nse)
        {
        }catch(Exception e){}
        return maxNivelEstudios;
    }

    public String getCarrera(CV cv) {
        String profesion = "Sin estudios";
        TreeMap<Integer, SWBClass> estudios = new TreeMap();
        
        Iterator<GradoAcademico> itso = cv.getAcademia().listGradoAcademicos();
        while(itso.hasNext())
        {
            GradoAcademico obj = itso.next();
            estudios.put(obj.getGrado().getIndex()+obj.getSituacionAcademica().getIndex(),obj);
        }
        try
        {
            SWBClass swbclass = estudios.get(estudios.lastKey());
            GradoAcademico obj = (GradoAcademico)swbclass;
            profesion = obj.getCarrera().getTitle();
        }
        catch(NoSuchElementException nse)
        {
        }
        catch(Exception e){
        }
        return profesion;
    }
%>
<%

    final String modelId = "eworkplace";
    WebSite model = SWBContext.getWebSite(modelId);
    
    out.println("<p>site="+model+"</p>");
    final String cvId = "3456";
    CV cv = CV.getCVClassMgr().getCV(cvId, model);
    Academia academia = cv.getAcademia();
    
    String maxNivelEstudios = academia.getMaxNivelEstudios();
    out.println("<p>maxNivelEstudios="+maxNivelEstudios+"</p>");
    
    String carrera = academia.getCarrera();
    out.println("<p>carrera="+carrera+"</p>");
    
    String disciplina = academia.getDisciplina();
    out.println("<p>disciplina="+disciplina+"</p>");
    
    org.semanticwb.model.User candidato = cv.getPropietario();
    org.semanticwb.model.User solicitante = SWBContext.getUserRepository(model.getUserRepository().getId()).getUserByLogin("rene.lira.1");
    org.semanticwb.model.User jefe = SWBContext.getUserRepository(model.getUserRepository().getId()).getUserByLogin("carlos.r1");
    
    /*SolicitudRecurso solicitudRecurso = SolicitudRecurso.getSolicitudRecursoClassMgr().createSolicitudRecurso(model);
    solicitudRecurso.setAdscripcionSolicitante("dac");
    solicitudRecurso.setAniosExpertise(3);
    solicitudRecurso.setAutoriza("cierto representante que autoriza");
    solicitudRecurso.setCandidatoSeleccionado(candidato);
    CapituloPresupuesto capitulo = CapituloPresupuesto.getCapituloPresupuestoClassMgr().getCapituloPresupuesto("1", model);
    solicitudRecurso.setCapituloSuficiencia(capitulo);
    TipoContratacion contratacion = TipoContratacion.getTipoContratacionClassMgr().getTipoContratacion("3", model);
    solicitudRecurso.setEntrevistador(solicitante);
    solicitudRecurso.setFechaFinContrato((new GregorianCalendar(2013,11,31)).getTime());
    solicitudRecurso.setFechaInicioContrato((new GregorianCalendar(2013,0,1)).getTime());
    solicitudRecurso.setFechaSolicita((new GregorianCalendar(2012,10,1)).getTime());
    solicitudRecurso.setFolio("789");
    solicitudRecurso.setMontoTotal(120000);
    solicitudRecurso.setContratacion(contratacion);
    solicitudRecurso.setMotivoContratacion("hace falta manos");
    solicitudRecurso.setFuncionPrincipal("cierta funcion principal");
    solicitudRecurso.setNombreSolicitante("doroteo arango");
    solicitudRecurso.setNotaSolicitud("nota de solicitud");
    solicitudRecurso.setNumeroEmpleado(911);
    solicitudRecurso.setPeriodoContrato(12);
    solicitudRecurso.setPersonalDirecto(0);
    solicitudRecurso.setPersonalIndirecto(100);
    Proyecto proyecto = Proyecto.getProyectoClassMgr().getProyecto("352", model);
    solicitudRecurso.setProyectoAsignado(proyecto);
    solicitudRecurso.setSalarioMax(120000);
    solicitudRecurso.setSalarioMin(120000);
    solicitudRecurso.setSolicitante(solicitante);
    solicitudRecurso.setSueldoBruto(166123);

    SeguimientoSolicitudRecurso seguimiento = SeguimientoSolicitudRecurso.getSeguimientoSolicitudRecursoClassMgr().createSeguimientoSolicitudRecurso(model);
    seguimiento.setSolicitudRecurso(solicitudRecurso);
    seguimiento.setFechaRecepcionSolicitud((new GregorianCalendar(2012,10,3)).getTime());
    
    Contrato contrato = Contrato.getContratoClassMgr().createContrato(model);
    contrato.setObservacionesContrato("No hay ninguna observacion");
    contrato.setFolioContrato("445566");
    contrato.setReferenciaContratacion("una cierta referencia de contratacion");
    contrato.setEstatusContrato("Vigente");
    contrato.setNumEmpleado(777);
    contrato.setDocumentosPresentados("acta de nacimiento, titulo y cedula");
    contrato.setClabeInterbancaria(1234567890);
    Banco bancomer = Banco.getBancoClassMgr().getBanco("38", model);
    contrato.setBanco(bancomer);
    contrato.setSeguridadSocial("seguridasoc");
    contrato.setFechaIngresoInfotec((new GregorianCalendar(2013,0,2).getTime()));
    contrato.setNumeroPagos(23);
    PeriodoPagos quincena = PeriodoPagos.getPeriodoPagosClassMgr().getPeriodoPagos("1", model);
    contrato.setPeriodoPagos(quincena);
    SedeRecurso aqui = SedeRecurso.getSedeRecursoClassMgr().getSedeRecurso("1", model);
    contrato.setSedeRecurso(aqui);
    contrato.setCargoAutorizasolicitudContrato("jefazo");
    contrato.setPresentaDeclaracion(false);
    contrato.setFileConstanciaSFP("mi constancia sfp");
    contrato.setRFC("rulo810816abc");
    contrato.setFechaEntregaRH((new GregorianCalendar(2012,11,5)).getTime());*/
    
    
    Services s = new Services();
    UserInformation userInformation;
    String login = "carlos.r1";
    userInformation = s.getUserInformation(login);
    userInformation.getTipoContratacion();
    
    Proyecto proyecto = Proyecto.getProyectoClassMgr().getProyecto("352", model);
    
    
    SolicitudPromocion solicitudPromocion = SolicitudPromocion.getSolicitudPromocionClassMgr().createSolicitudPromocion(model);
    solicitudPromocion.setFechaInicioNuevoPuesto((new GregorianCalendar(2013,1,1)).getTime());
    solicitudPromocion.setFechaTerminoNuevoPuesto((new GregorianCalendar(2013,11,31)).getTime());
    solicitudPromocion.setFolio("123bbnn");
    solicitudPromocion.setSueldoBrutoPropuesto(43000);
    solicitudPromocion.setSolicitante(solicitante);
    
    SeguimientoSolicitudPromocion seguimiento = SeguimientoSolicitudPromocion.getSeguimientoSolicitudPromocionClassMgr().createSeguimientoSolicitudPromocion(model);
    seguimiento.setAutorizadoDirectorPromocion(true);
    
    
    Contrato contrato = Contrato.getContratoClassMgr().createContrato(model);
    contrato.setObservacionesContrato("No hay ninguna observacion");
    contrato.setFolioContrato("445566");
    contrato.setReferenciaContratacion("una cierta referencia de contratacion");
    contrato.setEstatusContrato("Vigente");
    contrato.setNumEmpleado(777);
    contrato.setDocumentosPresentados("acta de nacimiento, titulo y cedula");
    contrato.setClabeInterbancaria("123456789012345678");
    Banco bancomer = Banco.getBancoClassMgr().getBanco("38", model);
    contrato.setBanco(bancomer);
    contrato.setSeguridadSocial("seguridasoc");
    contrato.setFechaIngresoInfotec((new GregorianCalendar(2013,0,2).getTime()));
    contrato.setNumeroPagos(23);
    PeriodoPagos quincena = PeriodoPagos.getPeriodoPagosClassMgr().getPeriodoPagos("1", model);
    contrato.setPeriodoPagos(quincena);
    SedeRecurso aqui = SedeRecurso.getSedeRecursoClassMgr().getSedeRecurso("1", model);
    contrato.setSedeRecurso(aqui);
    contrato.setCargoAutorizasolicitudContrato("jefazo");
    contrato.setPresentaDeclaracion(false);
    contrato.setFileConstanciaSFP("mi constancia sfp");
    contrato.setRFC("rulo810816abc");
    contrato.setFechaEntregaRH((new GregorianCalendar(2012,11,5)).getTime());
    
%>        
    </body>
</html>
