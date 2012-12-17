<%-- 
    Document   : cleanUsersCVI
    Created on : 17/12/2012, 01:12:31 PM
    Author     : juan.fernandez
--%>
<%@page import="org.semanticwb.model.UserRepository"%>
<%@page import="com.infotec.cvi.swb.resources.AreasTalentoResource"%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Resource"%> 
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="static com.infotec.cvi.swb.resources.AreasTalentoResource.Mode_TLNT"%>
<%@page import="static com.infotec.cvi.swb.resources.AreasTalentoResource.Mode_HBLDS"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    WebSite wsite = WebSite.ClassMgr.getWebSite("eworkplace");
    if(wsite==null){
        out.println("<h2>No existe sitio - Eworkplace</h2>");
        return;
    } 
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page - Clean CVI Users Data</title>
    </head>
    <body>
        <h1>Elimiando CVIs  de los usuarios</h1>
        <ul>
        <%
            UserRepository urep = wsite.getUserRepository();
            Iterator<User> itusr = urep.listUsers();
            while(itusr.hasNext()){
                User usr = itusr.next();
                String idusr = usr.getId();
                removeUserCVIData(usr,wsite);
                %>
                <li><%=idusr%> - datos CVI borrados </li>
                <%
            }
%>
        </ul>
    </body>
</html>
<%!

public void removeUserCVIData(org.semanticwb.model.User usSource, WebSite wsSource) {

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
                   // log.error("Error al agregar CV", e);
                }
                cvSource.remove();
            }
        } else {
           // log.error("Usuario no existe");
        }
    }

%>
