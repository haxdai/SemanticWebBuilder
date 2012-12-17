/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.cvi.swb.util;

import com.infotec.cvi.swb.Academia;
import com.infotec.cvi.swb.AreaEstudio;
import com.infotec.cvi.swb.AreaTalento;
import com.infotec.cvi.swb.Avance;
import com.infotec.cvi.swb.CP;
import com.infotec.cvi.swb.CV;
import com.infotec.cvi.swb.Candidato;
import com.infotec.cvi.swb.Carrera;
import com.infotec.cvi.swb.Colonia;
import com.infotec.cvi.swb.Competencia;
import com.infotec.cvi.swb.Conversacion;
import com.infotec.cvi.swb.CursoTIC;
import com.infotec.cvi.swb.Diplomado;
import com.infotec.cvi.swb.Distincion;
import com.infotec.cvi.swb.Docencia;
import com.infotec.cvi.swb.DocumentoProbatorio;
import com.infotec.cvi.swb.EntidadFederativa;
import com.infotec.cvi.swb.Escritura;
import com.infotec.cvi.swb.EstudioSuperior;
import com.infotec.cvi.swb.Estudios;
import com.infotec.cvi.swb.ExperienciaLaboral;
import com.infotec.cvi.swb.Grado;
import com.infotec.cvi.swb.GradoAcademico;
import com.infotec.cvi.swb.Habilidad;
import com.infotec.cvi.swb.Idioma;
import com.infotec.cvi.swb.Investigacion;
import com.infotec.cvi.swb.Lectura;
import com.infotec.cvi.swb.Municipio;
import com.infotec.cvi.swb.NivelDocencia;
import com.infotec.cvi.swb.Publicacion;
import com.infotec.cvi.swb.Sector;
import com.infotec.cvi.swb.SituacionAcademica;
import com.infotec.cvi.swb.TipoTalento;
import com.infotec.eworkplace.swb.Domicilio;
import com.infotec.eworkplace.swb.Familia;
import com.infotec.eworkplace.swb.Persona;
import com.infotec.eworkplace.swb.Telefono;
import java.text.DecimalFormat;
import java.util.Iterator;
import org.semanticwb.Logger;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Country;
import org.semanticwb.model.Language;
import org.semanticwb.model.WebSite;

/**
 * Utilerias para la operacion del modulo CVI
 *
 * @author juan.fernandez
 */
public class UtilsCVI {

    /**
     * Verifica si el CV esta completo; es decir, si está al 100%<br>
     *
     * @param cv a Curriculum Vitae a verificar si está completo
     * @return un booleano indicando true si está completo o false si está
     * incompleto
     */
    public static boolean isCVIDone(CV cv) {

        Academia aca = cv.getAcademia();
        boolean done = Boolean.FALSE;

        float progress = 0;
        boolean doneSchooling = aca != null && (aca.listGradoAcademicos().hasNext() && (aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext()) && (cv.isSinDiplomado() || cv.listDiplomados().hasNext()) && (cv.isSinCurso() || cv.listCursosTICs().hasNext()) && (cv.isSinIdioma() || cv.listIdiomas().hasNext()));
        if (doneSchooling) {
            progress += 0.25;
        }
        boolean doneExperience = (cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext()) && cv.listAreaTalentos().hasNext() && (cv.isSinDistincion() || cv.listDistincions().hasNext());
        if (doneExperience) {
            progress += 0.25;
        }
        boolean doneCompetencies = cv.listCompetencias().hasNext();
        if (doneCompetencies) {
            progress += 0.25;
        }
        boolean doneResearchAndTeaching = (cv.isSinInvestigacion() || cv.listInvestigacions().hasNext()) && (cv.isSinDocencia() || cv.listDocencias().hasNext()) && (cv.isSinPublicacion() || cv.listPublicacions().hasNext());
        if (doneResearchAndTeaching) {
            progress += 0.25;
        }
        if (progress == 1.0) {
            done = Boolean.TRUE;
        }

        return done;
    }

    /**
     * Verifica el porcentaje de avance del CV<br>
     *
     * @param cv a Curriculum Vitae a verificar avance
     * @return un String indicando el porcentaje de avance
     */
    public static String getCVIProgress(CV cv) {

        Academia aca = cv.getAcademia();
        DecimalFormat df = new DecimalFormat("###");

        float progress = 0;
        boolean doneSchooling = aca != null && (aca.listGradoAcademicos().hasNext() && (aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext()) && (cv.isSinDiplomado() || cv.listDiplomados().hasNext()) && (cv.isSinCurso() || cv.listCursosTICs().hasNext()) && (cv.isSinIdioma() || cv.listIdiomas().hasNext()));
        if (doneSchooling) {
            progress += 0.25;
        }
        boolean doneExperience = (cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext()) && cv.listAreaTalentos().hasNext() && (cv.isSinDistincion() || cv.listDistincions().hasNext());
        if (doneExperience) {
            progress += 0.25;
        }
        boolean doneCompetencies = cv.listCompetencias().hasNext();
        if (doneCompetencies) {
            progress += 0.25;
        }
        boolean doneResearchAndTeaching = (cv.isSinInvestigacion() || cv.listInvestigacions().hasNext()) && (cv.isSinDocencia() || cv.listDocencias().hasNext()) && (cv.isSinPublicacion() || cv.listPublicacions().hasNext());
        if (doneResearchAndTeaching) {
            progress += 0.25;
        }



        return df.format(100 * progress) + "%";
    }

    /**
     * Replaces accented characters and blank spaces in the string given. Makes
     * the changes in a case sensitive manner, the following are some examples
     * of the changes this method makes: <br>
     *
     * @param txt a string in which the characters are going to be replaced
     * @param replaceSpaces a {@code boolean} indicating if blank spaces are
     * going to be replaced or not
     * @return a string similar to {@code txt} but with neither accented or
     * special characters nor symbols in it. un objeto string similar a {@code txt}
     * pero sin caracteres acentuados o especiales y sin s&iacute;mbolos
     * {@literal Á} is replaced by {@literal A} <br>
     * {@literal Ê} is replaced by {@literal E} <br>
     * {@literal Ï} is replaced by {@literal I} <br>
     * {@literal â} is replaced by {@literal a} <br>
     * {@literal ç} is replaced by {@literal c} <br>
     * {@literal ñ} is replaced by {@literal n} <br> and blank spaces are
     * replaced by underscore characters. <p>Reemplaza caracteres acentuados y
     * espacios en blanco en {@code txt}. Realiza los cambios respetando
     * caracteres en may&uacute;sculas o min&uacute;sculas los caracteres en
     * blanco son reemplazados por guiones bajos, cualquier s&iacute;mbolo
     * diferente a gui&oacute;n bajo es eliminado.</p>
     */
    public static String replaceSpecialCharacters(String txt, boolean replaceSpaces) {
        StringBuffer ret = new StringBuffer();
        String aux = txt;
        //aux = aux.toLowerCase();
        aux = aux.replace('Á', 'A');
        aux = aux.replace('Ä', 'A');
        aux = aux.replace('Å', 'A');
        aux = aux.replace('Â', 'A');
        aux = aux.replace('À', 'A');
        aux = aux.replace('Ã', 'A');

        aux = aux.replace('É', 'E');
        aux = aux.replace('Ê', 'E');
        aux = aux.replace('È', 'E');
        aux = aux.replace('Ë', 'E');

        aux = aux.replace('Í', 'I');
        aux = aux.replace('Î', 'I');
        aux = aux.replace('Ï', 'I');
        aux = aux.replace('Ì', 'I');

        aux = aux.replace('Ó', 'O');
        aux = aux.replace('Ö', 'O');
        aux = aux.replace('Ô', 'O');
        aux = aux.replace('Ò', 'O');
        aux = aux.replace('Õ', 'O');

        aux = aux.replace('Ú', 'U');
        aux = aux.replace('Ü', 'U');
        aux = aux.replace('Û', 'U');
        aux = aux.replace('Ù', 'U');

        aux = aux.replace('Ñ', 'N');

        aux = aux.replace('Ç', 'C');
        aux = aux.replace('Ý', 'Y');

        aux = aux.replace('á', 'a');
        aux = aux.replace('à', 'a');
        aux = aux.replace('ã', 'a');
        aux = aux.replace('â', 'a');
        aux = aux.replace('ä', 'a');
        aux = aux.replace('å', 'a');

        aux = aux.replace('é', 'e');
        aux = aux.replace('è', 'e');
        aux = aux.replace('ê', 'e');
        aux = aux.replace('ë', 'e');

        aux = aux.replace('í', 'i');
        aux = aux.replace('ì', 'i');
        aux = aux.replace('î', 'i');
        aux = aux.replace('ï', 'i');

        aux = aux.replace('ó', 'o');
        aux = aux.replace('ò', 'o');
        aux = aux.replace('ô', 'o');
        aux = aux.replace('ö', 'o');
        aux = aux.replace('õ', 'o');

        aux = aux.replace('ú', 'u');
        aux = aux.replace('ù', 'u');
        aux = aux.replace('ü', 'u');
        aux = aux.replace('û', 'u');

        aux = aux.replace('ñ', 'n');

        aux = aux.replace('ç', 'c');
        aux = aux.replace('ÿ', 'y');
        aux = aux.replace('ý', 'y');

        if (replaceSpaces) {
            aux = aux.replace(' ', '_');
        }
        int l = aux.length();
        for (int x = 0; x < l; x++) {
            char ch = aux.charAt(x);
//                if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')
//                        || (ch >= 'A' && ch <= 'Z') || ch == '_')
            {
                ret.append(ch);
            }
        }
        aux = ret.toString();
        return aux;
    }
    static Logger log = SWBUtils.getLogger(UtilsCVI.class);

    static public boolean isEmpty(String obj) {
        if (obj == null || obj.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    static public void copyUser(org.semanticwb.model.User usSource, WebSite wsSource, org.semanticwb.model.User usTarget, WebSite wsTarget) {

        if (usSource != null && usTarget != null) {

            Persona personaSource = Persona.ClassMgr.getPersona(usSource.getId(), wsSource);
            Candidato candidatoSource = Candidato.ClassMgr.getCandidato(usSource.getId(), wsSource);
            CV cvSource = CV.ClassMgr.getCV(usSource.getId(), wsSource);
//            SWProfile profileSource = SWProfile.ClassMgr.getSWProfile(usSource.getId(), wsSource);
            Academia academiaSource = null;
            if (cvSource != null) {
                academiaSource = cvSource.getAcademia();
            }
            try {
                if (!isEmpty(usSource.getFirstName())) {
                    usTarget.setFirstName(usSource.getFirstName());
                }
                if (!isEmpty(usSource.getLastName())) {
                    usTarget.setLastName(usSource.getLastName());
                }
                if (!isEmpty(usSource.getSecondLastName())) {
                    usTarget.setSecondLastName(usSource.getSecondLastName());
                }
            } catch (Exception e) {
                log.error("Error al actualizar User", e);
            }

            Persona personaTarget = null;
            if (personaSource != null) {
                try {
                    personaTarget = Persona.ClassMgr.getPersona(usTarget.getId(), wsTarget);
                    if (personaTarget == null) {
                        personaTarget = Persona.ClassMgr.createPersona(usTarget.getId(), wsTarget);
                    }
                    personaTarget.setOwner(usTarget);
                    if (!isEmpty(personaSource.getCurp())) {
                        personaTarget.setCurp(personaSource.getCurp());
                    }
                    personaTarget.setGenero(personaSource.isGenero());
                    if (personaSource.getNacimiento() != null) {
                        personaTarget.setNacimiento(personaSource.getNacimiento());
                    }
                    personaTarget.setFM2(personaSource.isFM2());
                    if (!isEmpty(personaSource.getFacebook())) {
                        personaTarget.setFacebook(personaSource.getFacebook());
                    }
                    if (!isEmpty(personaSource.getSkype())) {
                        personaTarget.setSkype(personaSource.getSkype());
                    }
                    if (!isEmpty(personaSource.getMsn())) {
                        personaTarget.setMsn(personaSource.getMsn());
                    }
                    if (!isEmpty(personaSource.getLinkedin())) {
                        personaTarget.setLinkedin(personaSource.getLinkedin());
                    }
                    if (!isEmpty(personaSource.getTwitter())) {
                        personaTarget.setTwitter(personaSource.getTwitter());
                    }
                    if (personaSource.getEstadoNacimiento() != null
                            && EntidadFederativa.ClassMgr.hasEntidadFederativa(personaSource.getEstadoNacimiento().getId(), wsTarget)) {
                        personaTarget.setEstadoNacimiento(EntidadFederativa.ClassMgr.getEntidadFederativa(personaSource.getEstadoNacimiento().getId(), wsTarget));
                    }
                    if (personaSource.getNacionalidad() != null
                            && Country.ClassMgr.hasCountry(personaSource.getNacionalidad().getId(), wsTarget)) {
                        personaTarget.setNacionalidad(Country.ClassMgr.getCountry(personaSource.getNacionalidad().getId(), wsTarget));
                    }
                    Domicilio domSource = personaSource.getDomicilio();
                    if (domSource != null) {
                        Domicilio domTarget = Domicilio.ClassMgr.createDomicilio(wsTarget);
                        if (!isEmpty(domSource.getCalle())) {
                            domTarget.setCalle(domSource.getCalle());
                        }
                        if (!isEmpty(domSource.getNumExterior())) {
                            domTarget.setNumExterior(domSource.getNumExterior());
                        }
                        if (!isEmpty(domSource.getNumInterior())) {
                            domTarget.setNumInterior(domSource.getNumInterior());
                        }
                        if (domSource.getCp() != null
                                && CP.ClassMgr.hasCP(domSource.getCp().getId(), wsTarget)) {
                            domTarget.setCp(CP.ClassMgr.getCP(domSource.getCp().getId(), wsTarget));
                        }
                        if (domSource.getColonia() != null
                                && Colonia.ClassMgr.hasColonia(domSource.getColonia().getId(), wsTarget)) {
                            domTarget.setColonia(Colonia.ClassMgr.getColonia(domSource.getColonia().getId(), wsTarget));
                        }
                        if (domSource.getMunicipio() != null
                                && Municipio.ClassMgr.hasMunicipio(domSource.getMunicipio().getId(), wsTarget)) {
                            domTarget.setMunicipio(Municipio.ClassMgr.getMunicipio(domSource.getMunicipio().getId(), wsTarget));
                        }
                        if (domSource.getEntidad() != null
                                && EntidadFederativa.ClassMgr.hasEntidadFederativa(domSource.getEntidad().getId(), wsTarget)) {
                            domTarget.setEntidad(EntidadFederativa.ClassMgr.getEntidadFederativa(domSource.getEntidad().getId(), wsTarget));
                        }
                        if (domSource.getPais() != null
                                && Country.ClassMgr.hasCountry(domSource.getPais().getId(), wsTarget)) {
                            domTarget.setPais(Country.ClassMgr.getCountry(domSource.getPais().getId(), wsTarget));
                        }
                        personaTarget.setDomicilio(domTarget);
                    }
                    Iterator<Telefono> ittSource = personaSource.listTelefonos();
                    if (ittSource != null) {
                        ittSource = personaSource.listTelefonos();
                        while (ittSource.hasNext()) {
                            Telefono teSource = ittSource.next();
                            Telefono teTarget = Telefono.ClassMgr.createTelefono(wsTarget);
                            if (!isEmpty(teSource.getTipo())) {
                                teTarget.setTipo(teSource.getTipo());
                            }
                            teTarget.setLada(teSource.getLada());
                            teTarget.setNumero(teSource.getNumero());
                            teTarget.setExtension(teSource.getExtension());
                            personaTarget.addTelefono(teTarget);
                        }
                    }
                    if (!isEmpty(usSource.getEmail())) {
                        personaTarget.addPEmail(usSource.getEmail());
                    }
                    Iterator<String> itemSource = personaSource.listPEmails();
                    if (itemSource != null) {
                        itemSource = personaSource.listPEmails();
                        while (itemSource.hasNext()) {
                            String pEmail = itemSource.next();
                            personaTarget.addPEmail(pEmail);
                        }
                    }
                } catch (Exception e) {
                    log.error("Error al agregar Persona", e);

                }
            }

            if (candidatoSource != null) {
                try {
                    Candidato candidatoTarget = Candidato.ClassMgr.getCandidato(usTarget.getId(), wsTarget);
                    if (candidatoTarget == null) {
                        candidatoTarget = Candidato.ClassMgr.createCandidato(usTarget.getId(), wsTarget);
                    }
                    candidatoTarget.setSituacionLaboral(candidatoSource.getSituacionLaboral());
                    candidatoTarget.setDisponibilidad(candidatoSource.getDisponibilidad());
                } catch (Exception e) {
                    log.error("Error al agregar Candidato", e);
                }
            }
            if (cvSource != null) {
                try {
                    CV cvTarget = CV.ClassMgr.getCV(usTarget.getId(), wsTarget);
                    if (cvTarget == null) {
                        cvTarget = CV.ClassMgr.createCV(usTarget.getId(), wsTarget);
                    }
                    cvTarget.setPropietario(usTarget);
                    cvTarget.setPersona(personaTarget);
                    if (academiaSource != null) {
                        Academia academiaTarget = Academia.ClassMgr.getAcademia(usTarget.getId(), wsTarget);
                        if (academiaTarget == null) {
                            academiaTarget = Academia.ClassMgr.createAcademia(usTarget.getId(), wsTarget);
                        }
                        cvTarget.setAcademia(academiaTarget);
                        Iterator<GradoAcademico> itgaSource = academiaSource.listGradoAcademicos();
                        if (itgaSource != null) {
                            while (itgaSource.hasNext()) {
                                GradoAcademico gaSource = itgaSource.next();
                                GradoAcademico gaTarget = GradoAcademico.ClassMgr.createGradoAcademico(wsTarget);
                                if (!isEmpty(gaSource.getNombreInstitucion())) {
                                    gaTarget.setNombreInstitucion(gaSource.getNombreInstitucion());
                                }
                                gaTarget.setPeriodoYears(gaSource.getPeriodoYears());
                                if (gaSource.getCarrera() != null
                                        && Carrera.ClassMgr.hasCarrera(gaSource.getCarrera().getId(), wsTarget)) {
                                    gaTarget.setCarrera(Carrera.ClassMgr.getCarrera(gaSource.getCarrera().getId(), wsTarget));
                                }
                                if (gaSource.getGrado() != null
                                        && Grado.ClassMgr.hasGrado(gaSource.getGrado().getId(), wsTarget)) {
                                    gaTarget.setGrado(Grado.ClassMgr.getGrado(gaSource.getGrado().getId(), wsTarget));
                                }
                                if (gaSource.getSituacionAcademica() != null
                                        && SituacionAcademica.ClassMgr.hasSituacionAcademica(gaSource.getSituacionAcademica().getId(), wsTarget)) {
                                    gaTarget.setSituacionAcademica(SituacionAcademica.ClassMgr.getSituacionAcademica(gaSource.getSituacionAcademica().getId(), wsTarget));
                                }
                                academiaTarget.addGradoAcademico(gaTarget);
                            }
                        }
                        academiaTarget.setNoAplicaEstudioSuperior(academiaSource.isNoAplicaEstudioSuperior());
                        Iterator<EstudioSuperior> itesSource = academiaSource.listEstudioSuperiors();
                        if (itesSource != null && !academiaSource.isNoAplicaEstudioSuperior()) {
                            while (itesSource.hasNext()) {
                                EstudioSuperior esSource = itesSource.next();
                                EstudioSuperior esTarget = EstudioSuperior.ClassMgr.createEstudioSuperior(wsTarget);
                                if (!isEmpty(esSource.getOtroEstudio())) {
                                    esTarget.setOtroEstudio(esSource.getOtroEstudio());
                                }
                                if (esSource.getGradoAvance() != null
                                        && Avance.ClassMgr.hasAvance(esSource.getGradoAvance().getId(), wsTarget)) {
                                    esTarget.setGradoAvance(Avance.ClassMgr.getAvance(esSource.getGradoAvance().getId(), wsTarget));
                                }
                                if (esSource.getEstudiosSuperiores() != null) {
                                    if (Estudios.ClassMgr.hasEstudios(esSource.getEstudiosSuperiores().getId(), wsTarget)) {
                                        esTarget.setEstudiosSuperiores(Estudios.ClassMgr.getEstudios(esSource.getEstudiosSuperiores().getId(), wsTarget));
                                    } else {
                                        if (esSource.getEstudiosSuperiores().getId().endsWith("_otro")
                                                && esSource.getEstudiosSuperiores().getTitle().equals("Otro")) {
                                            Estudios eSource = esSource.getEstudiosSuperiores();
                                            Estudios eTarget = Estudios.ClassMgr.createEstudios(eSource.getId(), wsTarget);
                                            if (!isEmpty(eSource.getTitle())) {
                                                eTarget.setTitle(eSource.getTitle());
                                            }
                                            if (!isEmpty(eSource.getDescription())) {
                                                eTarget.setDescription(eSource.getDescription());
                                            }
                                            if (eSource.getAreaEstudio() != null
                                                    && AreaEstudio.ClassMgr.hasAreaEstudio(eSource.getAreaEstudio().getId(), wsTarget)) {
                                                eTarget.setAreaEstudio(AreaEstudio.ClassMgr.getAreaEstudio(eSource.getAreaEstudio().getId(), wsTarget));
                                            }
                                            esTarget.setEstudiosSuperiores(Estudios.ClassMgr.getEstudios(esSource.getEstudiosSuperiores().getId(), wsTarget));
                                        }
                                    }
                                }
                                esTarget.setPeriodoYears(esSource.getPeriodoYears());
                                academiaTarget.addEstudioSuperior(esTarget);
                            }
                        }
                    }
                    cvTarget.setSinDiplomado(cvSource.isSinDiplomado());
                    Iterator<Diplomado> itdiSource = cvSource.listDiplomados();
                    if (itdiSource != null && !cvSource.isSinDiplomado()) {
                        while (itdiSource.hasNext()) {
                            Diplomado diSource = itdiSource.next();
                            Diplomado diTarget = Diplomado.ClassMgr.createDiplomado(wsTarget);
                            if (!isEmpty(diSource.getTitle())) {
                                diTarget.setTitle(diSource.getTitle());
                            }
                            if (!isEmpty(diSource.getNombreInstitucion())) {
                                diTarget.setNombreInstitucion(diSource.getNombreInstitucion());
                            }
                            diTarget.setInicio(diSource.getInicio());
                            diTarget.setFin(diSource.getFin());
                            if (!isEmpty(diSource.getDocumentoObtenido())) {
                                diTarget.setDocumentoObtenido(diSource.getDocumentoObtenido());
                            }
                            cvTarget.addDiplomado(diTarget);
                        }
                    }
                    cvTarget.setSinCurso(cvSource.isSinCurso());
                    Iterator<CursoTIC> itctSource = cvSource.listCursosTICs();
                    if (itctSource != null && !cvSource.isSinCurso()) {
                        while (itctSource.hasNext()) {
                            CursoTIC ctSource = itctSource.next();
                            CursoTIC ctTarget = CursoTIC.ClassMgr.createCursoTIC(wsTarget);
                            if (!isEmpty(ctSource.getTitle())) {
                                ctTarget.setTitle(ctSource.getTitle());
                            }
                            if (!isEmpty(ctSource.getNombreInstitucion())) {
                                ctTarget.setNombreInstitucion(ctSource.getNombreInstitucion());
                            }
                            ctTarget.setInicio(ctSource.getInicio());
                            ctTarget.setFin(ctSource.getFin());
                            if (!isEmpty(ctSource.getDocumentoObtenido())) {
                                ctTarget.setDocumentoObtenido(ctSource.getDocumentoObtenido());
                            }
                            cvTarget.addCursosTIC(ctTarget);
                        }
                    }
                    cvTarget.setSinIdioma(cvSource.isSinIdioma());
                    Iterator<Idioma> itidSource = cvSource.listIdiomas();
                    if (itidSource != null && !cvSource.isSinIdioma()) {
                        while (itidSource.hasNext()) {
                            Idioma idmSource = itidSource.next();
                            Idioma idmTarget = Idioma.ClassMgr.createIdioma(wsTarget);
                            if (idmSource.getIdiomas() != null
                                    && Language.ClassMgr.hasLanguage(idmSource.getIdiomas().getId(), wsTarget)) {
                                idmTarget.setIdiomas(Language.ClassMgr.getLanguage(idmSource.getIdiomas().getId(), wsTarget));
                            }
                            if (idmSource.getConversacion() != null
                                    && Conversacion.ClassMgr.hasConversacion(idmSource.getConversacion().getId(), wsTarget)) {
                                idmTarget.setConversacion(Conversacion.ClassMgr.getConversacion(idmSource.getConversacion().getId(), wsTarget));
                            }
                            if (idmSource.getLectura() != null
                                    && Lectura.ClassMgr.hasLectura(idmSource.getLectura().getId(), wsTarget)) {
                                idmTarget.setLectura(Lectura.ClassMgr.getLectura(idmSource.getLectura().getId(), wsTarget));
                            }
                            if (idmSource.getEscritura() != null
                                    && Escritura.ClassMgr.hasEscritura(idmSource.getEscritura().getId(), wsTarget)) {
                                idmTarget.setEscritura(Escritura.ClassMgr.getEscritura(idmSource.getEscritura().getId(), wsTarget));
                            }
                            cvTarget.addIdioma(idmTarget);
                        }
                    }
                    cvTarget.setSinExperiencia(cvSource.isSinExperiencia());
                    Iterator<ExperienciaLaboral> itelSource = cvSource.listExperienciaLaborals();
                    if (itelSource != null && !cvSource.isSinExperiencia()) {
                        while (itelSource.hasNext()) {
                            ExperienciaLaboral elSource = itelSource.next();
                            ExperienciaLaboral elTarget = ExperienciaLaboral.ClassMgr.createExperienciaLaboral(wsTarget);
                            elTarget.setActual(elTarget.isActual());
                            if (!isEmpty(elSource.getEmpresa())) {
                                elTarget.setEmpresa(elSource.getEmpresa());
                            }
                            if (elSource.getFechaIni() != null) {
                                elTarget.setFechaIni(elSource.getFechaIni());
                            }
                            if (elSource.getFechaFin() != null) {
                                elTarget.setFechaFin(elSource.getFechaFin());
                            }
                            if (!isEmpty(elSource.getCargo())) {
                                elTarget.setCargo(elSource.getCargo());
                            }
                            if (!isEmpty(elSource.getFuncionesPrincipales())) {
                                elTarget.setFuncionesPrincipales(elSource.getFuncionesPrincipales());
                            }
                            if (!isEmpty(elSource.getJefe())) {
                                elTarget.setJefe(elSource.getJefe());
                            }
                            Telefono teSource = elSource.getTelefono();
                            if (teSource != null) {
                                Telefono teTarget = Telefono.ClassMgr.createTelefono(wsTarget);
                                teTarget.setLada(teSource.getLada());
                                teTarget.setNumero(teSource.getNumero());
                                teTarget.setExtension(teSource.getExtension());
                                elTarget.setTelefono(teTarget);
                            }
                            if (elSource.getSector() != null
                                    && Sector.ClassMgr.hasSector(elSource.getSector().getId(), wsTarget)) {
                                elTarget.setSector(Sector.ClassMgr.getSector(elSource.getSector().getId(), wsTarget));
                            }
                            cvTarget.addExperienciaLaboral(elTarget);
                        }
                    }
                    Iterator<AreaTalento> itatSource = cvSource.listAreaTalentos();
                    if (itatSource != null) {
                        itatSource = cvSource.listAreaTalentos();
                        while (itatSource.hasNext()) {
                            AreaTalento atSource = itatSource.next();
                            AreaTalento atTarget = AreaTalento.ClassMgr.createAreaTalento(wsTarget);
                            if (atSource.getTipoAreaTalento() != null
                                    && TipoTalento.ClassMgr.hasTipoTalento(atSource.getTipoAreaTalento().getId(), wsTarget)) {
                                atTarget.setTipoAreaTalento(TipoTalento.ClassMgr.getTipoTalento(atSource.getTipoAreaTalento().getId(), wsTarget));
                            }
                            if (atSource.getHabilidad() != null
                                    && Habilidad.ClassMgr.hasHabilidad(atSource.getHabilidad().getId(), wsTarget)) {
                                atTarget.setHabilidad(Habilidad.ClassMgr.getHabilidad(atSource.getHabilidad().getId(), wsTarget));
                            }
                            atTarget.setYearExperienceTalento(atSource.getYearExperienceTalento());
                            if (!isEmpty(atSource.getOtraHabilidad())) {
                                atTarget.setOtraHabilidad(atSource.getOtraHabilidad());
                            }
                            cvTarget.addAreaTalento(atTarget);
                        }
                    }
                    cvTarget.setSinDistincion(cvSource.isSinDistincion());
                    Iterator<Distincion> itdtSource = cvSource.listDistincions();
                    if (itdtSource != null && !cvSource.isSinDistincion()) {
                        while (itdtSource.hasNext()) {
                            Distincion diSource = itdtSource.next();
                            Distincion diTarget = Distincion.ClassMgr.createDistincion(wsTarget);
                            if (!isEmpty(diSource.getTitle())) {
                                diTarget.setTitle(diSource.getTitle());
                            }
                            if (!isEmpty(diSource.getOtorgante())) {
                                diTarget.setOtorgante(diSource.getOtorgante());
                            }
                            if (diSource.getFechaDistincion() != null) {
                                diTarget.setFechaDistincion(diSource.getFechaDistincion());
                            }
                            cvTarget.addDistincion(diTarget);
                        }
                    }
                    Iterator<Competencia> itcoSource = cvSource.listCompetencias();
                    if (itcoSource != null) {
                        while (itcoSource.hasNext()) {
                            Competencia coSource = itcoSource.next();
                            if (coSource != null
                                    && Competencia.ClassMgr.hasCompetencia(coSource.getId(), wsTarget)) {
                                Competencia coTarget = Competencia.ClassMgr.getCompetencia(coSource.getId(), wsTarget);
                                cvTarget.addCompetencia(coTarget);
                            }
                        }
                    }
                    cvTarget.setSinInvestigacion(cvSource.isSinInvestigacion());
                    Iterator<Investigacion> itinSource = cvSource.listInvestigacions();
                    if (itinSource != null && !cvSource.isSinInvestigacion()) {
                        while (itinSource.hasNext()) {
                            Investigacion inSource = itinSource.next();
                            Investigacion inTarget = Investigacion.ClassMgr.createInvestigacion(wsTarget);
                            if (!isEmpty(inSource.getNombreEmpresa())) {
                                inTarget.setNombreEmpresa(inSource.getNombreEmpresa());
                            }
                            if (!isEmpty(inSource.getAreaInvestigacion())) {
                                inTarget.setAreaInvestigacion(inSource.getAreaInvestigacion());
                            }
                            inTarget.setFechaTermino(inSource.getFechaTermino());
                            inTarget.setNumTelefono(inSource.getNumTelefono());
                            if (!isEmpty(inSource.getNombrePuesto())) {
                                inTarget.setNombrePuesto(inSource.getNombrePuesto());
                            }
                            if (!isEmpty(inSource.getNombreJefePuesto())) {
                                inTarget.setNombreJefePuesto(inSource.getNombreJefePuesto());
                            }
                            if (!isEmpty(inSource.getSniConacyt())) {
                                inTarget.setSniConacyt(inSource.getSniConacyt());
                            }
                            cvTarget.addInvestigacion(inTarget);
                        }
                    }
                    cvTarget.setSinDocencia(cvSource.isSinDocencia());
                    Iterator<Docencia> itdoSource = cvSource.listDocencias();
                    if (itdoSource != null && !cvSource.isSinDocencia()) {
                        while (itdoSource.hasNext()) {
                            Docencia docSource = itdoSource.next();
                            Docencia docTarget = Docencia.ClassMgr.createDocencia(wsTarget);
                            if (!isEmpty(docSource.getAsignatura())) {
                                docTarget.setAsignatura(docSource.getAsignatura());
                            }
                            if (!isEmpty(docSource.getInstitucion())) {
                                docTarget.setInstitucion(docSource.getInstitucion());
                            }
                            if (docSource.getNivelDocencia() != null
                                    && NivelDocencia.ClassMgr.hasNivelDocencia(docSource.getNivelDocencia().getId(), wsTarget)) {
                                docTarget.setNivelDocencia(NivelDocencia.ClassMgr.getNivelDocencia(docSource.getNivelDocencia().getId(), wsTarget));
                            }
                            docTarget.setAniosDocencia(docSource.getAniosDocencia());
                            cvTarget.addDocencia(docTarget);
                        }
                    }
                    cvTarget.setSinPublicacion(cvSource.isSinPublicacion());
                    Iterator<Publicacion> itpuSource = cvSource.listPublicacions();
                    if (itpuSource != null && !cvSource.isSinPublicacion()) {
                        while (itpuSource.hasNext()) {
                            Publicacion puSource = itpuSource.next();
                            Publicacion puTarget = Publicacion.ClassMgr.createPublicacion(wsTarget);
                            if (!isEmpty(puSource.getTitle())) {
                                puTarget.setTitle(puSource.getTitle());
                            }
                            if (!isEmpty(puSource.getPublicado())) {
                                puTarget.setPublicado(puSource.getPublicado());
                            }
                            puTarget.setFechapublicado(puSource.getFechapublicado());
                            cvTarget.addPublicacion(puTarget);
                        }
                    }
                    if (cvSource.getDocumentoProbatorio() != null) {
                        DocumentoProbatorio dpSource = cvSource.getDocumentoProbatorio();
                        DocumentoProbatorio dpTarget = DocumentoProbatorio.ClassMgr.createDocumentoProbatorio(wsTarget);
                        cvTarget.setDocumentoProbatorio(dpTarget);
                        String preStrSource;
                        String preStrTarget;
                        String filename;
                        String pathSource = SWBPortal.getWorkPath() + dpSource.getWorkPath() + "/";
                        String pathTarget = SWBPortal.getWorkPath() + dpTarget.getWorkPath() + "/";

                        SWBUtils.IO.createDirectory(pathTarget);

                        if (!isEmpty(dpSource.getFileActaNacimiento())) {

                            preStrSource = DocumentoProbatorio.intranet_fileActaNacimiento.getName() + "_" + dpSource.getId() + "_";
                            preStrTarget = DocumentoProbatorio.intranet_fileActaNacimiento.getName() + "_" + dpTarget.getId() + "_";
                            filename = dpSource.getFileActaNacimiento().substring(preStrSource.length());

                            SWBUtils.IO.copy(pathSource + dpSource.getFileActaNacimiento(), pathTarget + preStrTarget + filename, false, null, null);
                            dpTarget.setFileActaNacimiento(preStrTarget + filename);
                        }
                        if (!isEmpty(dpSource.getFileActaMatrimonio())) {
                            preStrSource = DocumentoProbatorio.intranet_fileActaMatrimonio.getName() + "_" + dpSource.getId() + "_";
                            preStrTarget = DocumentoProbatorio.intranet_fileActaMatrimonio.getName() + "_" + dpTarget.getId() + "_";
                            filename = dpSource.getFileActaMatrimonio().substring(preStrSource.length());

                            SWBUtils.IO.copy(pathSource + dpSource.getFileActaMatrimonio(), pathTarget + preStrTarget + filename, false, null, null);

                            dpTarget.setFileActaMatrimonio(preStrTarget + filename);
                        }
                        Iterator<String> itanSource = dpSource.listActasNacimientoFamiliareses();
                        if (itanSource != null) {
                            while (itanSource.hasNext()) {
                                String anSource = itanSource.next();
                                if (!isEmpty(anSource)) {
                                    preStrSource = DocumentoProbatorio.intranet_hasActasNacimientoFamiliares.getName() + "_" + dpSource.getId() + "_";
                                    preStrTarget = DocumentoProbatorio.intranet_hasActasNacimientoFamiliares.getName() + "_" + dpTarget.getId() + "_";
                                    filename = anSource.substring(preStrSource.length());

                                    SWBUtils.IO.copy(pathSource + anSource, pathTarget + preStrTarget + filename, false, null, null);

                                    dpTarget.addActasNacimientoFamiliares(preStrTarget + filename);
                                }
                            }
                        }
                        if (!isEmpty(dpSource.getFileFotoTamInfantil())) {
                            preStrSource = DocumentoProbatorio.intranet_fileFotoTamInfantil.getName() + "_" + dpSource.getId() + "_";
                            preStrTarget = DocumentoProbatorio.intranet_fileFotoTamInfantil.getName() + "_" + dpTarget.getId() + "_";
                            filename = dpSource.getFileFotoTamInfantil().substring(preStrSource.length());

                            SWBUtils.IO.copy(pathSource + dpSource.getFileFotoTamInfantil(), pathTarget + preStrTarget + filename, false, null, null);

                            dpTarget.setFileFotoTamInfantil(preStrTarget + filename);
                        }
                        if (!isEmpty(dpSource.getFileCopiaRFC())) {
                            preStrSource = DocumentoProbatorio.intranet_fileCopiaRFC.getName() + "_" + dpSource.getId() + "_";
                            preStrTarget = DocumentoProbatorio.intranet_fileCopiaRFC.getName() + "_" + dpTarget.getId() + "_";
                            filename = dpSource.getFileCopiaRFC().substring(preStrSource.length());

                            SWBUtils.IO.copy(pathSource + dpSource.getFileCopiaRFC(), pathTarget + preStrTarget + filename, false, null, null);

                            dpTarget.setFileCopiaRFC(preStrTarget + filename);
                        }
                        if (!isEmpty(dpSource.getFileCURP())) {
                            preStrSource = DocumentoProbatorio.intranet_fileCURP.getName() + "_" + dpSource.getId() + "_";
                            preStrTarget = DocumentoProbatorio.intranet_fileCURP.getName() + "_" + dpTarget.getId() + "_";
                            filename = dpSource.getFileCURP().substring(preStrSource.length());

                            SWBUtils.IO.copy(pathSource + dpSource.getFileCURP(), pathTarget + preStrTarget + filename, false, null, null);

                            dpTarget.setFileCURP(preStrTarget + filename);
                        }
                        Iterator<String> itceSource = dpSource.listFilesComprobanteEstudios();
                        if (itceSource != null) {
                            while (itceSource.hasNext()) {
                                String ceSource = itceSource.next();
                                if (!isEmpty(ceSource)) {
                                    preStrSource = DocumentoProbatorio.intranet_hasFilesComprobanteEstudio.getName() + "_" + dpSource.getId() + "_";
                                    preStrTarget = DocumentoProbatorio.intranet_hasFilesComprobanteEstudio.getName() + "_" + dpTarget.getId() + "_";
                                    filename = ceSource.substring(preStrSource.length());

                                    SWBUtils.IO.copy(pathSource + ceSource, pathTarget + preStrTarget + filename, false, null, null);

                                    dpTarget.addFilesComprobanteEstudio(preStrTarget + filename);
                                }
                            }
                        }
                        Iterator<String> itioSource = dpSource.listFilesIdentificacionOficials();
                        if (itioSource != null) {
                            while (itioSource.hasNext()) {
                                String ioSource = itioSource.next();
                                if (!isEmpty(ioSource)) {
                                    preStrSource = DocumentoProbatorio.intranet_hasFilesIdentificacionOficial.getName() + "_" + dpSource.getId() + "_";
                                    preStrTarget = DocumentoProbatorio.intranet_hasFilesIdentificacionOficial.getName() + "_" + dpTarget.getId() + "_";
                                    filename = ioSource.substring(preStrSource.length());

                                    SWBUtils.IO.copy(pathSource + ioSource, pathTarget + preStrTarget + filename, false, null, null);

                                    dpTarget.addFilesIdentificacionOficial(preStrTarget + filename);
                                }
                            }
                        }
                        if (!isEmpty(dpSource.getFileComprobanteDomicilio())) {
                            preStrSource = DocumentoProbatorio.intranet_fileComprobanteDomicilio.getName() + "_" + dpSource.getId() + "_";
                            preStrTarget = DocumentoProbatorio.intranet_fileComprobanteDomicilio.getName() + "_" + dpTarget.getId() + "_";
                            filename = dpSource.getFileComprobanteDomicilio().substring(preStrSource.length());

                            SWBUtils.IO.copy(pathSource + dpSource.getFileComprobanteDomicilio(), pathTarget + preStrTarget + filename, false, null, null);

                            dpTarget.setFileComprobanteDomicilio(preStrTarget + filename);
                        }
                        if (!isEmpty(dpSource.getFileNumeroSeguridadSocial())) {
                            preStrSource = DocumentoProbatorio.intranet_fileNumeroSeguridadSocial.getName() + "_" + dpSource.getId() + "_";
                            preStrTarget = DocumentoProbatorio.intranet_fileNumeroSeguridadSocial.getName() + "_" + dpTarget.getId() + "_";
                            filename = dpSource.getFileNumeroSeguridadSocial().substring(preStrSource.length());

                            SWBUtils.IO.copy(pathSource + dpSource.getFileNumeroSeguridadSocial(), pathTarget + preStrTarget + filename, false, null, null);

                            dpTarget.setFileNumeroSeguridadSocial(preStrTarget + filename);
                        }
                    }
                } catch (Exception e) {
                    log.error("Error al agregar CV", e);
                }
            }
        } else {
            log.error("Usuario no existe");
        }
    }

    static public void removeUserCVIData(org.semanticwb.model.User usSource, WebSite wsSource) {

        if (usSource != null) {

            Persona personaSource = Persona.ClassMgr.getPersona(usSource.getId(), wsSource);
            Candidato candidatoSource = Candidato.ClassMgr.getCandidato(usSource.getId(), wsSource);
            CV cvSource = CV.ClassMgr.getCV(usSource.getId(), wsSource);
            Academia academiaSource = null;
            if (cvSource != null) {
                academiaSource = cvSource.getAcademia();
            }

            // elimina familia de la persona
            if (personaSource != null) {
                Iterator<Familia> itfamilia = personaSource.listFamilias();
                while (itfamilia.hasNext()) {
                    Familia familia = itfamilia.next();
                    familia.remove();
                }

                //elimina telefonos de la persona
                Iterator<Telefono> ittel = personaSource.listTelefonos();
                while (ittel.hasNext()) {
                    Telefono telefono = ittel.next();
                    telefono.remove();
                }
                personaSource.remove();
            }

            if (candidatoSource != null) {
                candidatoSource.remove();
            }
            if (cvSource != null) {
                try {

                    if (academiaSource != null) {

                        Iterator<GradoAcademico> itgaSource = academiaSource.listGradoAcademicos();
                        if (itgaSource != null) {
                            while (itgaSource.hasNext()) {
                                GradoAcademico gaSource = itgaSource.next();
                                gaSource.remove();
                            }
                        }

                        Iterator<EstudioSuperior> itesSource = academiaSource.listEstudioSuperiors();
                        if (itesSource != null) {
                            while (itesSource.hasNext()) {
                                EstudioSuperior esSource = itesSource.next();
                                esSource.remove();
                            }
                        }
                        
                        academiaSource.remove();
                    }

                    Iterator<Diplomado> itdiSource = cvSource.listDiplomados();
                    if (itdiSource != null && !cvSource.isSinDiplomado()) {
                        while (itdiSource.hasNext()) {
                            Diplomado diSource = itdiSource.next();
                            diSource.remove();
                        }
                    }

                    Iterator<CursoTIC> itctSource = cvSource.listCursosTICs();
                    if (itctSource != null && !cvSource.isSinCurso()) {
                        while (itctSource.hasNext()) {
                            CursoTIC ctSource = itctSource.next();
                            ctSource.remove();
                        }
                    }

                    Iterator<Idioma> itidSource = cvSource.listIdiomas();
                    if (itidSource != null && !cvSource.isSinIdioma()) {
                        while (itidSource.hasNext()) {
                            Idioma idmSource = itidSource.next();
                            idmSource.remove();
                        }
                    }
                    Iterator<ExperienciaLaboral> itelSource = cvSource.listExperienciaLaborals();
                    if (itelSource != null && !cvSource.isSinExperiencia()) {
                        while (itelSource.hasNext()) {
                            ExperienciaLaboral elSource = itelSource.next();
                            elSource.removeTelefono();
                            elSource.remove();
                        }
                    }
                    Iterator<AreaTalento> itatSource = cvSource.listAreaTalentos();
                    if (itatSource != null) {
                        itatSource = cvSource.listAreaTalentos();
                        while (itatSource.hasNext()) {
                            AreaTalento atSource = itatSource.next();
                            atSource.remove();
                        }
                    }

                    Iterator<Distincion> itdtSource = cvSource.listDistincions();
                    if (itdtSource != null && !cvSource.isSinDistincion()) {
                        while (itdtSource.hasNext()) {
                            Distincion diSource = itdtSource.next();
                            diSource.remove();
                        }
                    }

                    Iterator<Investigacion> itinSource = cvSource.listInvestigacions();
                    if (itinSource != null && !cvSource.isSinInvestigacion()) {
                        while (itinSource.hasNext()) {
                            Investigacion inSource = itinSource.next();
                            inSource.remove();
                        }
                    }

                    Iterator<Docencia> itdoSource = cvSource.listDocencias();
                    if (itdoSource != null && !cvSource.isSinDocencia()) {
                        while (itdoSource.hasNext()) {
                            Docencia docSource = itdoSource.next();
                            docSource.remove();
                        }
                    }
                    Iterator<Publicacion> itpuSource = cvSource.listPublicacions();
                    if (itpuSource != null && !cvSource.isSinPublicacion()) {
                        while (itpuSource.hasNext()) {
                            Publicacion puSource = itpuSource.next();
                            puSource.remove();
                        }
                    }
                    if (cvSource.getDocumentoProbatorio() != null) {
                        DocumentoProbatorio dpSource = cvSource.getDocumentoProbatorio();
                        dpSource.remove();
                    }
                } catch (Exception e) {
                    log.error("Error al agregar CV", e);
                }
                cvSource.remove();
            }
        } else {
            log.error("Usuario no existe");
        }
    }
}
