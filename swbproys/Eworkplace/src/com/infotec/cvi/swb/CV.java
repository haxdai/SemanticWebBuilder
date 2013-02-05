package com.infotec.cvi.swb;

import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.SWProfile;
import com.infotec.eworkplace.swb.Telefono;

import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CV extends com.infotec.cvi.swb.base.CVBase
{
    public CV(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    
    /**
     * Devuelve un DOM de la informacion del CV de un usuario dado
     *
     * @param user Usuario
     * @return
     */
    public Document toDom(final User user) {
        SWBModel model = (SWBModel)getSemanticObject().getModel().getModelObject().createGenericInstance();
        
        Persona persona = Persona.ClassMgr.getPersona(user.getId(), model);
        Candidato candidato = Candidato.ClassMgr.getCandidato(user.getId(), model);
        CV cv = CV.ClassMgr.getCV(user.getId(), model);
        SWProfile profile = SWProfile.ClassMgr.getSWProfile(user.getId(), model);
        
        Document dom = SWBUtils.XML.getNewDocument();
        Element eleCV = dom.createElement("cv");
        dom.appendChild(eleCV);
        Element elePersona = dom.createElement("persona");
        

        Academia academia = null;
        if (cv != null) {
            academia = cv.getAcademia();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        org.w3c.dom.Element element;
        if (user.getFullName() != null) {
            element = dom.createElement("nombre");
            element.appendChild(dom.createTextNode(user.getFullName()));
            elePersona.appendChild(element);
        }
        String email = "";
        if (user.getEmail() != null) {
            email = user.getEmail();
        }
        if (persona != null) {
            if (persona.getCurp() != null) {
                element = dom.createElement("curp");
                element.appendChild(dom.createTextNode(persona.getCurp()));
                elePersona.appendChild(element);
            }
            String gender = "";
            {
                if (persona.isGenero() == true) {
                    gender = "Femenino";
                } else {
                    gender = "Masculino";
                }
                element = dom.createElement("genero");
                element.appendChild(dom.createTextNode(gender));
                elePersona.appendChild(element);
            }
            if (persona.getNacimiento() != null) {
                element = dom.createElement("nacimiento");
                element.appendChild(dom.createTextNode(sdf.format(persona.getNacimiento())));
                elePersona.appendChild(element);
            }
            if (persona.getEstadoNacimiento() != null) {
                element = dom.createElement("estado");
                element.appendChild(dom.createTextNode(persona.getEstadoNacimiento().getTitle()));
                elePersona.appendChild(element);

            }
            if (persona.getNacionalidad() != null) {
                element = dom.createElement("nacionalidad");
                element.appendChild(dom.createTextNode(persona.getNacionalidad().getTitle()));
                elePersona.appendChild(element);

            }
            if (persona.isFM2()) {
                element = dom.createElement("fm2");
                element.appendChild(dom.createTextNode("Vigente"));
                elePersona.appendChild(element);
            }
        }
        String sLabor = "";

        if (candidato != null) {
            switch (candidato.getSituacionLaboral()) {
                case 1:
                    sLabor = "Empleado";
                    break;
                case 2:
                    sLabor = "Desempleado";
                    break;
                case 3:
                    sLabor = "Estudiante";
                    break;
                case 4:
                    sLabor = "Jubilado";
                    break;
            }
            element = dom.createElement("situacion");
            element.appendChild(dom.createTextNode(sLabor));
            elePersona.appendChild(element);

            /*
            availability = "" + candidato.getDisponibilidad();
            if (candidato.getDisponibilidad() == 1) {
            availability += " día";
            } else {
            availability += " dias";
            }*/
            element = dom.createElement("disponibilidad");
            element.appendChild(dom.createTextNode("" + candidato.getDisponibilidad()));
            elePersona.appendChild(element);
        }
        String pimg = "";
        if (profile != null) {
            if (user.getPhoto() != null) {
                pimg = SWBPortal.getWorkPath() + profile.getWorkPath() + "/" + user.getPhoto();
                element = dom.createElement("foto");
                element.appendChild(dom.createTextNode(pimg));
                elePersona.appendChild(element);
            }
        }
        if (persona != null || !email.equals("")) {
            org.w3c.dom.Element eleMedio = dom.createElement("medio_contacto");
            eleMedio.appendChild(dom.createTextNode(""));
            if (persona != null) {
                Iterator<Telefono> itt = persona.listTelefonos();
                if(itt != null && SWBUtils.Collections.sizeOf(itt) > 0){
                    itt = persona.listTelefonos();
                    org.w3c.dom.Element eleTelefonos = dom.createElement("telefonos");
                    eleTelefonos.appendChild(dom.createTextNode(""));
                    while (itt.hasNext()) {
                        Telefono te = itt.next();
                        org.w3c.dom.Element eleTelefono = dom.createElement("telefono");
                        eleTelefono.appendChild(dom.createTextNode(""));
                        eleTelefono.setAttribute("tipo","" + te.getTipo());
                        if(te.getLada()>0){
                            element = dom.createElement("lada");
                            element.appendChild(dom.createTextNode("" + te.getLada()));
                            eleTelefono.appendChild(element);
                        }
                        element = dom.createElement("numero");
                        element.appendChild(dom.createTextNode("" + te.getNumero()));
                        eleTelefono.appendChild(element);
                        if(te.getExtension()>0){
                            element = dom.createElement("extension");
                            element.appendChild(dom.createTextNode("" + te.getExtension()));
                            eleTelefono.appendChild(element);
                        }
                        /*element = dom.createElement("tipo");
                        element.appendChild(dom.createTextNode("" + te.getTipo()));
                        eleTelefono.appendChild(element);*/
                        eleTelefonos.appendChild(eleTelefono);
                    }
                    eleMedio.appendChild(eleTelefonos);
                }
            }
            if((email != null && !email.equals(""))||(persona != null&&SWBUtils.Collections.sizeOf(persona.listPEmails()) > 0)){
                org.w3c.dom.Element eleEmails = dom.createElement("emails");
                eleEmails.appendChild(dom.createTextNode(""));
                if (email != null && !email.equals("")) {
                    element = dom.createElement("email");
                    element.appendChild(dom.createTextNode(email));
                    eleEmails.appendChild(element);
                }
                if (persona != null) {
                    Iterator<String> item = persona.listPEmails();
                    if (item != null) {
                        while (item.hasNext()) {
                            String pEmail = item.next();
                            element = dom.createElement("email");
                            element.appendChild(dom.createTextNode(pEmail));
                            eleEmails.appendChild(element);
                        }
                    }
                }
                eleMedio.appendChild(eleEmails);
            }

            if (persona.getFacebook() != null&&!persona.getFacebook().equals("")) {
                element = dom.createElement("facebook");
                element.appendChild(dom.createTextNode(persona.getFacebook()));
                eleMedio.appendChild(element);
            }
            if (persona.getSkype() != null&&!persona.getSkype().equals("")) {
                element = dom.createElement("skype");
                element.appendChild(dom.createTextNode(persona.getSkype()));
                eleMedio.appendChild(element);

            }
            if (persona.getMsn() != null&&!persona.getMsn().equals("")) {
                element = dom.createElement("msn");
                element.appendChild(dom.createTextNode(persona.getMsn()));
                eleMedio.appendChild(element);
            }
            if (persona.getLinkedin() != null&&!persona.getLinkedin().equals("")) {
                element = dom.createElement("linkedin");
                element.appendChild(dom.createTextNode(persona.getLinkedin()));
                eleMedio.appendChild(element);
            }
            if (persona.getTwitter() != null&&!persona.getTwitter().equals("")) {
                element = dom.createElement("twitter");
                element.appendChild(dom.createTextNode(persona.getTwitter()));
                eleMedio.appendChild(element);

            }
            elePersona.appendChild(eleMedio);
        }
        eleCV.appendChild(elePersona);

        if (cv != null && academia != null) {

            org.w3c.dom.Element eleAcademia = dom.createElement("formacion_academia");
            eleAcademia.appendChild(dom.createTextNode(""));

            if (academia != null) {
                Iterator<GradoAcademico> itga = academia.listGradoAcademicos();
                if (itga != null && SWBUtils.Collections.sizeOf(itga) > 0) {
                    itga = academia.listGradoAcademicos();
                    org.w3c.dom.Element eleGrados = dom.createElement("grados_academicos");
                    eleGrados.appendChild(dom.createTextNode(""));

                    while (itga.hasNext()) {
                        GradoAcademico ga = itga.next();
                        org.w3c.dom.Element eleGrado = dom.createElement("grado");
                        eleGrado.appendChild(dom.createTextNode(""));
                        element = dom.createElement("nivel");
                        element.appendChild(dom.createTextNode(ga.getGrado().getTitle()));
                        eleGrado.appendChild(element);
                        if (ga.getCarrera() != null&&!ga.getCarrera().equals("")) {
                            element = dom.createElement("carrera");
                            element.appendChild(dom.createTextNode(ga.getCarrera().getTitle()));
                            eleGrado.appendChild(element);
                        }
                        element = dom.createElement("institucion");
                        element.appendChild(dom.createTextNode(ga.getNombreInstitucion()));
                        eleGrado.appendChild(element);
                        element = dom.createElement("situacion");
                        element.appendChild(dom.createTextNode(ga.getSituacionAcademica().getTitle()));
                        eleGrado.appendChild(element);
                        element = dom.createElement("periodo");
                        element.appendChild(dom.createTextNode("" + ga.getPeriodoYears()));
                        eleGrado.appendChild(element);


                        eleGrados.appendChild(eleGrado);

                    }
                    eleAcademia.appendChild(eleGrados);
                }

                Iterator<EstudioSuperior> ites = academia.listEstudioSuperiors();
                if (ites != null && SWBUtils.Collections.sizeOf(ites) > 0) {
                    ites = academia.listEstudioSuperiors();
                    org.w3c.dom.Element eleEstudios = dom.createElement("estudios_superiores");
                    eleEstudios.appendChild(dom.createTextNode(""));

                    while (ites.hasNext()) {
                        EstudioSuperior es = ites.next();
                        org.w3c.dom.Element eleEstudio = dom.createElement("estudio");
                        eleEstudio.appendChild(dom.createTextNode(""));
                        element = dom.createElement("avance");
                        element.appendChild(dom.createTextNode(es.getGradoAvance().getTitle()));
                        eleEstudio.appendChild(element);
                        String estudio="";
                        String tipo="";
                        if(es.getEstudiosSuperiores()!=null && es.getEstudiosSuperiores().getAreaEstudio()!=null&&
                                es.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv()!=null&&
                                es.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv()!=null){
                            tipo=es.getEstudiosSuperiores().getAreaEstudio().getDisciplinaInv().getTipoEstudioInv().getTitle();
                            tipo=tipo+" - ";
                        }
                        if(es.getEstudiosSuperiores()!=null && es.getEstudiosSuperiores().getId().endsWith("_otro")&&es.getEstudiosSuperiores().getTitle().equals("Otro")){
                                estudio = tipo+"Otro / "+es.getOtroEstudio();
                        } else{
                                estudio = tipo + (es.getEstudiosSuperiores()!=null?es.getEstudiosSuperiores().getTitle():"");
                        }
                        element = dom.createElement("nombre");
                        element.appendChild(dom.createTextNode(estudio));
                        eleEstudio.appendChild(element);
                        element = dom.createElement("periodo");
                        element.appendChild(dom.createTextNode("" + es.getPeriodoYears()));
                        eleEstudio.appendChild(element);

                        eleEstudios.appendChild(eleEstudio);
                    }

                    eleAcademia.appendChild(eleEstudios);
                }
            }
            if (cv != null) {
                Iterator<Diplomado> itdi = cv.listDiplomados();
                if (itdi != null && SWBUtils.Collections.sizeOf(itdi) > 0) {
                    itdi = cv.listDiplomados();
                    org.w3c.dom.Element eleDiplomados = dom.createElement("diplomados");
                    eleDiplomados.appendChild(dom.createTextNode(""));
                    while (itdi.hasNext()) {
                        Diplomado di = itdi.next();
                        org.w3c.dom.Element eleDiplomado = dom.createElement("diplomado");
                        eleDiplomado.appendChild(dom.createTextNode(""));

                        element = dom.createElement("nombre");
                        element.appendChild(dom.createTextNode(di.getTitle()));
                        eleDiplomado.appendChild(element);
                        element = dom.createElement("institucion");
                        element.appendChild(dom.createTextNode(di.getNombreInstitucion()));
                        eleDiplomado.appendChild(element);
                        element = dom.createElement("inicio");
                        element.appendChild(dom.createTextNode(""+di.getInicio()));
                        eleDiplomado.appendChild(element);
                        element = dom.createElement("fin");
                        element.appendChild(dom.createTextNode(""+di.getFin()));
                        eleDiplomado.appendChild(element);
                        element = dom.createElement("documento");
                        element.appendChild(dom.createTextNode(di.getDocumentoObtenido()));
                        eleDiplomado.appendChild(element);


                        eleDiplomados.appendChild(eleDiplomado);
                    }
                    eleAcademia.appendChild(eleDiplomados);
                }
                Iterator<CursoTIC> itct = cv.listCursosTICs();
                if (itct != null && SWBUtils.Collections.sizeOf(itct) > 0) {
                    itct = cv.listCursosTICs();
                    org.w3c.dom.Element eleCursos = dom.createElement("cursos_tic");
                    eleCursos.appendChild(dom.createTextNode(""));
                    while (itct.hasNext()) {
                        CursoTIC ct = itct.next();

                        org.w3c.dom.Element eleCurso = dom.createElement("curso");
                        eleCurso.appendChild(dom.createTextNode(""));
                        element = dom.createElement("nombre");
                        element.appendChild(dom.createTextNode(ct.getTitle()));
                        eleCurso.appendChild(element);
                        element = dom.createElement("institucion");
                        element.appendChild(dom.createTextNode(ct.getNombreInstitucion()));
                        eleCurso.appendChild(element);
                        element = dom.createElement("inicio");
                        element.appendChild(dom.createTextNode(""+ct.getInicio()));
                        eleCurso.appendChild(element);
                        element = dom.createElement("fin");
                        element.appendChild(dom.createTextNode(""+ct.getFin()));
                        eleCurso.appendChild(element);
                        element = dom.createElement("documento");
                        element.appendChild(dom.createTextNode(ct.getDocumentoObtenido()));
                        eleCurso.appendChild(element);

                        eleCursos.appendChild(eleCurso);
                    }
                    eleAcademia.appendChild(eleCursos);
                }
                Iterator<Idioma> itid = cv.listIdiomas();
                if (itid != null && SWBUtils.Collections.sizeOf(itid) > 0) {
                    itid = cv.listIdiomas();
                    org.w3c.dom.Element eleIdiomas = dom.createElement("idiomas");
                    eleIdiomas.appendChild(dom.createTextNode(""));

                    while (itid.hasNext()) {
                        Idioma id = itid.next();
                        org.w3c.dom.Element eleIdioma = dom.createElement("idioma");
                        eleIdioma.appendChild(dom.createTextNode(""));

                        element = dom.createElement("nombre");
                        element.appendChild(dom.createTextNode(id.getIdiomas().getTitle()));
                        eleIdioma.appendChild(element);
                        element = dom.createElement("conversacion");
                        element.appendChild(dom.createTextNode(id.getConversacion().getTitle()));
                        eleIdioma.appendChild(element);
                        element = dom.createElement("lectura");
                        element.appendChild(dom.createTextNode(id.getLectura().getTitle()));
                        eleIdioma.appendChild(element);
                        element = dom.createElement("escritura");
                        element.appendChild(dom.createTextNode(id.getEscritura().getTitle()));
                        eleIdioma.appendChild(element);

                        eleIdiomas.appendChild(eleIdioma);
                    }
                    eleAcademia.appendChild(eleIdiomas);
                }
            }
            eleCV.appendChild(eleAcademia);
        }

        if (cv != null) {
            Iterator<Distincion> itdi = cv.listDistincions();
            Iterator<AreaTalento> itat = cv.listAreaTalentos();
            Iterator<ExperienciaLaboral> itel = cv.listExperienciaLaborals();
            if (SWBUtils.Collections.sizeOf(itel) > 0 || SWBUtils.Collections.sizeOf(itat) > 0 || SWBUtils.Collections.sizeOf(itdi) > 0) {

                org.w3c.dom.Element eleExperiencia = dom.createElement("experiencia");
                eleExperiencia.appendChild(dom.createTextNode(""));
                itel = cv.listExperienciaLaborals();
                if (itel != null && SWBUtils.Collections.sizeOf(itel) > 0) {
                    itel = cv.listExperienciaLaborals();
                    org.w3c.dom.Element eleLaborales = dom.createElement("laborales");
                    eleLaborales.appendChild(dom.createTextNode(""));
                    while (itel.hasNext()) {
                        ExperienciaLaboral el = itel.next();
                        org.w3c.dom.Element eleLaboral = dom.createElement("laboral");
                        eleLaboral.appendChild(dom.createTextNode(""));
                        element = dom.createElement("empresa");
                        element.appendChild(dom.createTextNode(el.getEmpresa()));
                        eleLaboral.appendChild(element);
                        element = dom.createElement("inicio");
                        String fini = el.getFechaIni()!=null?sdf.format(el.getFechaIni()):"";
                        element.appendChild(dom.createTextNode(fini));
                        eleLaboral.appendChild(element);
                        element = dom.createElement("fin");
                        String ffin = el.getFechaFin()!=null?sdf.format(el.getFechaFin()):"";
                        element.appendChild(dom.createTextNode(ffin));
                        eleLaboral.appendChild(element);
                        element = dom.createElement("cargo");
                        element.appendChild(dom.createTextNode(el.getCargo()));
                        eleLaboral.appendChild(element);
                        element = dom.createElement("jefe");
                        element.appendChild(dom.createTextNode(el.getJefe()));
                        eleLaboral.appendChild(element);
                        element = dom.createElement("funciones");
                        element.appendChild(dom.createTextNode(el.getFuncionesPrincipales()));
                        eleLaboral.appendChild(element);
                        element = dom.createElement("sector");
                        element.appendChild(dom.createTextNode(el.getSector().getTitle()));
                        eleLaboral.appendChild(element);

                        Telefono te = el.getTelefono();
                        if(te!=null){
                        org.w3c.dom.Element eleTelefono = dom.createElement("telefono");
                        eleTelefono.appendChild(dom.createTextNode(""));
                        if(te.getLada()>0){
                            element = dom.createElement("lada");
                            element.appendChild(dom.createTextNode("" + te.getLada()));
                            eleTelefono.appendChild(element);
                        }
                        element = dom.createElement("numero");
                        element.appendChild(dom.createTextNode("" + te.getNumero()));
                        eleTelefono.appendChild(element);
                        if(te.getExtension()>0){
                            element = dom.createElement("extension");
                            element.appendChild(dom.createTextNode("" + te.getExtension()));
                            eleTelefono.appendChild(element);
                        }
                        eleLaboral.appendChild(eleTelefono);
                        }
                        eleLaborales.appendChild(eleLaboral);
                    }
                    eleExperiencia.appendChild(eleLaborales);

                }
                itat = cv.listAreaTalentos();
                if (itat != null && SWBUtils.Collections.sizeOf(itat) > 0) {
                    itat = cv.listAreaTalentos();
                    org.w3c.dom.Element eleTelentos = dom.createElement("talentos");
                    eleTelentos.appendChild(dom.createTextNode(""));
                    while (itat.hasNext()) {
                        AreaTalento at = itat.next();

                        org.w3c.dom.Element eleTalento = dom.createElement("talento");
                        eleTalento.appendChild(dom.createTextNode(""));
                        element = dom.createElement("nombre");
                        element.appendChild(dom.createTextNode(at.getTipoAreaTalento().getTitle()));
                        eleTalento.appendChild(element);
                        element = dom.createElement("habilidad");
                        element.appendChild(dom.createTextNode(at.getHabilidad().getTitle()));
                        eleTalento.appendChild(element);
                        element = dom.createElement("tiempo");
                        element.appendChild(dom.createTextNode("" + at.getYearExperienceTalento()));
                        eleTalento.appendChild(element);
                        element = dom.createElement("otra");
                        element.appendChild(dom.createTextNode(at.getOtraHabilidad()));
                        eleTalento.appendChild(element);
                        /*if (at.getYearExperienceTalento() > 0) {
                        if (at.getYearExperienceTalento() == 1) {
                        tiempo += at.getYearExperienceTalento() + " año";
                        } else {
                        tiempo += at.getYearExperienceTalento() + " años";
                        }
                        }*/

                        eleTelentos.appendChild(eleTalento);

                    }
                    eleExperiencia.appendChild(eleTelentos);
                }
                itdi = cv.listDistincions();
                if (itdi != null && SWBUtils.Collections.sizeOf(itdi) > 0) {
                    itdi = cv.listDistincions();
                    org.w3c.dom.Element eleDistinciones = dom.createElement("distinciones");
                    eleDistinciones.appendChild(dom.createTextNode(""));
                    while (itdi.hasNext()) {
                        Distincion di = itdi.next();
                        org.w3c.dom.Element eleDistincion = dom.createElement("distincion");
                        eleDistincion.appendChild(dom.createTextNode(""));
                        element = dom.createElement("nombre");
                        element.appendChild(dom.createTextNode(di.getTitle()));
                        eleDistincion.appendChild(element);
                        element = dom.createElement("otorgante");
                        element.appendChild(dom.createTextNode(di.getOtorgante()));
                        eleDistincion.appendChild(element);
                        element = dom.createElement("fecha");
                        element.appendChild(dom.createTextNode(sdf.format(di.getFechaDistincion())));
                        eleDistincion.appendChild(element);


                        eleDistinciones.appendChild(eleDistincion);
                    }
                    eleExperiencia.appendChild(eleDistinciones);
                }
                eleCV.appendChild(eleExperiencia);

            }
        }

        if (cv != null) {
            Iterator<Competencia> itco = cv.listCompetencias();
            if (itco != null && SWBUtils.Collections.sizeOf(itco) > 0) {
                itco = cv.listCompetencias();
                org.w3c.dom.Element eleCompetencias = dom.createElement("competencias");
                eleCompetencias.appendChild(dom.createTextNode(""));
                while (itco.hasNext()) {
                    Competencia co = itco.next();
                    element = dom.createElement("competencia");
                    element.appendChild(dom.createTextNode(co.getTitle()));
                    eleCompetencias.appendChild(element);
                }
                eleCV.appendChild(eleCompetencias);
            }
        }
        if (cv != null) {
            Iterator<Investigacion> itin = cv.listInvestigacions();
            Iterator<Docencia> itdo = cv.listDocencias();
            Iterator<Publicacion> itpu = cv.listPublicacions();
            if (SWBUtils.Collections.sizeOf(itin) > 0 || SWBUtils.Collections.sizeOf(itdo) > 0 || SWBUtils.Collections.sizeOf(itpu) > 0) {
                org.w3c.dom.Element eleInvestigacionDocencia = dom.createElement("investigacion_docencia");
                eleInvestigacionDocencia.appendChild(dom.createTextNode(""));

                itin = cv.listInvestigacions();
                if (itin != null && SWBUtils.Collections.sizeOf(itin) > 0) {
                    itin = cv.listInvestigacions();
                    org.w3c.dom.Element eleInvestigaciones = dom.createElement("investigaciones");
                    eleInvestigaciones.appendChild(dom.createTextNode(""));
                    while (itin.hasNext()) {
                        Investigacion in = itin.next();

                        org.w3c.dom.Element eleInvestigacion = dom.createElement("investigacion");
                        eleInvestigacion.appendChild(dom.createTextNode(""));
                        element = dom.createElement("empresa");
                        element.appendChild(dom.createTextNode(in.getNombreEmpresa()));
                        eleInvestigacion.appendChild(element);
                        element = dom.createElement("area");
                        element.appendChild(dom.createTextNode(in.getAreaInvestigacion()));
                        eleInvestigacion.appendChild(element);
                        element = dom.createElement("tiempo");
                        element.appendChild(dom.createTextNode("" + in.getFechaTermino()));
                        eleInvestigacion.appendChild(element);


                        /*if (in.getFechaTermino() > 0) {
                        if (in.getFechaTermino() == 1) {
                        tiempo += " año";
                        } else {
                        tiempo += " años";
                        }
                        }*/
                        if (in.getNumTelefono() > 0) {
                            element = dom.createElement("telefono");
                            element.appendChild(dom.createTextNode("" + in.getNumTelefono()));
                            eleInvestigacion.appendChild(element);
                        }


                        if (in.getNombrePuesto() != null&& !in.getNombrePuesto().equals("")) {
                            element = dom.createElement("cargo");
                            element.appendChild(dom.createTextNode(in.getNombrePuesto()));
                            eleInvestigacion.appendChild(element);

                        }

                        if (in.getNombreJefePuesto() != null&&!in.getNombreJefePuesto().equals("")) {
                            element = dom.createElement("jefe");
                            element.appendChild(dom.createTextNode(in.getNombreJefePuesto()));
                            eleInvestigacion.appendChild(element);
                        }
                        if (in.getSniConacyt() != null&&!in.getSniConacyt().equals("")) {
                            element = dom.createElement("sni");
                            element.appendChild(dom.createTextNode(in.getSniConacyt()));
                            eleInvestigacion.appendChild(element);
                        }

                        eleInvestigaciones.appendChild(eleInvestigacion);
                    }
                    eleInvestigacionDocencia.appendChild(eleInvestigaciones);
                }
                itdo = cv.listDocencias();
                if (itdo != null && SWBUtils.Collections.sizeOf(itdo) > 0) {
                    itdo = cv.listDocencias();
                    org.w3c.dom.Element eleDocencias = dom.createElement("docencias");
                    eleDocencias.appendChild(dom.createTextNode(""));
                    while (itdo.hasNext()) {
                        Docencia doc = itdo.next();
                        org.w3c.dom.Element eleDocencia = dom.createElement("docencia");
                        eleDocencia.appendChild(dom.createTextNode(""));
                        element = dom.createElement("asignatura");
                        element.appendChild(dom.createTextNode(doc.getAsignatura()));
                        eleDocencia.appendChild(element);
                        element = dom.createElement("institucion");
                        element.appendChild(dom.createTextNode(doc.getInstitucion()));
                        eleDocencia.appendChild(element);


                        if (doc.getNivelDocencia() != null && !doc.getNivelDocencia().equals("")) {
                            element = dom.createElement("nivel");
                            element.appendChild(dom.createTextNode(doc.getNivelDocencia().getTitle()));
                            eleDocencia.appendChild(element);
                        }
                        eleDocencias.appendChild(eleDocencia);
                    }
                    eleInvestigacionDocencia.appendChild(eleDocencias);
                }
                itpu = cv.listPublicacions();
                if (itpu != null && SWBUtils.Collections.sizeOf(itpu) > 0) {
                    itpu = cv.listPublicacions();
                    org.w3c.dom.Element elePublicaciones = dom.createElement("publicaciones");
                    elePublicaciones.appendChild(dom.createTextNode(""));
                    while (itpu.hasNext()) {
                        Publicacion pu = itpu.next();
                        org.w3c.dom.Element elePublicacion = dom.createElement("publicacion");
                        elePublicacion.appendChild(dom.createTextNode(""));
                        element = dom.createElement("titulo");
                        element.appendChild(dom.createTextNode(pu.getTitle()));
                        elePublicacion.appendChild(element);
                        element = dom.createElement("medio");
                        element.appendChild(dom.createTextNode(pu.getPublicado()));
                        elePublicacion.appendChild(element);
                        element = dom.createElement("fecha");
                        element.appendChild(dom.createTextNode("" + pu.getFechapublicado()));
                        elePublicacion.appendChild(element);

                        elePublicaciones.appendChild(elePublicacion);
                    }
                    eleInvestigacionDocencia.appendChild(elePublicaciones);
                }
                eleCV.appendChild(eleInvestigacionDocencia);
            }
        }
        return dom; 
    }
}
