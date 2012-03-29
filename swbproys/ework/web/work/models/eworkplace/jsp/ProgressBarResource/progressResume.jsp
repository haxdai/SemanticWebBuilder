<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@page import="org.semanticwb.Logger"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.GenericResource"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.portal.api.SWBResourceException"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
    User user = paramRequest.getUser();
    if(user.isSigned()) {
        boolean resume = true;
        boolean done;
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        Academia aca = cv.getAcademia();
        
        final String url = SWBPlatform.getContextPath()+"/"+SWBPlatform.getEnv("swb/distributor")+"/"+wsite.getId()+"/";
        final String lang = "/_lang/"+user.getLanguage();
        
        out.println("<div class=\"indice\">");
        out.println(" <div class=\"intro_indice\">");
        done = aca.listGradoAcademicos().hasNext()&&(aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext())&&(cv.isSinDiplomado() || cv.listDiplomados().hasNext())&&(cv.isSinCurso() || cv.listCursosTICs().hasNext())&&(cv.isSinIdioma() || cv.listIdiomas().hasNext());
        resume = resume && done;
        out.println("  <h3 class=\""+(done?"icv-semaforo-paloma":"icv-semaforo-tache")+"\">");
        out.println("   <a name=\"Conocimiento_Formal\" href=\""+url+"Escolaridad"+lang+"\">"+paramRequest.getLocaleString("lblSchooling")+"</a>");
        out.println("  </h3>");
        out.println("  <p class=\"intro_line\">&nbsp;</p>");
        out.println(" </div>");     
        out.println(" <div class=\"cvi-sf-opcion\">");
        out.println("  <ul>");
        if(aca.listGradoAcademicos().hasNext())
            out.println("<li><h4><a name=\"Escolaridad\" href=\""+url+"Escolaridad"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblDegrees")+"</a></h4></li>");
        else
            out.println("<li><h4><a name=\"Escolaridad\" href=\""+url+"Escolaridad"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblDegrees")+"</a></h4></li>");
        
        if(aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext())
            out.println("<li><h4><a href=\""+url+"Estudios_Superiores"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblHigherEducation")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Estudios_Superiores"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblHigherEducation")+"</a></h4></li>");
        
        if(cv.isSinDiplomado() || cv.listDiplomados().hasNext())
            out.println("<li><h4><a href=\""+url+"Diplomados_cursos_y_certificaciones"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblCourses")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Diplomados_cursos_y_certificaciones"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblCourses")+"</a></h4></li>");
        
        if(cv.isSinCurso() || cv.listCursosTICs().hasNext())
            out.println("<li><h4><a href=\""+url+"Cursos_especiaizados_en_TIC"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblSpecializationICT")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Cursos_especiaizados_en_TIC"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblSpecializationICT")+"</a></h4></li>");
        
        if(cv.isSinIdioma() || cv.listIdiomas().hasNext())
            out.println("<li><h4><a href=\""+url+"Idiomas"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblLanguages")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Idiomas"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblLanguages")+"</a></h4></li>");
        out.println("  </ul>");
        out.println(" </div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");

        out.println("<div class=\"indice\">");
        out.println(" <div class=\"intro_indice\">");
        done = (cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext())&&cv.listAreaTalentos().hasNext()&&(cv.isSinDistincion() || cv.listDistincions().hasNext());
        resume = resume && done;
        out.println("  <h3 class=\""+(done?"icv-semaforo-paloma":"icv-semaforo-tache")+"\">");
        out.println("   <a name=\"Experiencia_Profesional\" href=\""+url+"Experiencia_Laboral"+lang+"\">"+paramRequest.getLocaleString("lblExperience")+"</a>");
        out.println("  </h3>");
        out.println("  <p class=\"intro_line\">&nbsp;</p>");
        out.println(" </div>");
        out.println(" <div class=\"cvi-sf-opcion\">");
        out.println("  <ul>");
        if(cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext())
            out.println("<li><h4><a href=\""+url+"Experiencia_Laboral"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblJobExperience")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Experiencia_Laboral"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblJobExperience")+"</a></h4></li>");
        
        if(cv.listAreaTalentos().hasNext())
            out.println("<li><h4><a href=\""+url+"Areas_de_talento_o_Expertise"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblExpertise")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Areas_de_talento_o_Expertise"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblExpertise")+"</a></h4></li>");

        if(cv.isSinDistincion() || cv.listDistincions().hasNext())
            out.println("<li><h4><a href=\""+url+"Distinciones"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblAwards")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Distinciones"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblAwards")+"</a></h4></li>");
        out.println("  </ul>");
        out.println(" </div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");

        out.println("<div class=\"indice\">");
        out.println(" <div class=\"intro_indice\">");
        done = cv.listCompetencias().hasNext();
        resume = resume && done;
        out.println("  <h3 class=\""+(done?"icv-semaforo-paloma":"icv-semaforo-tache")+"\">");
        out.println("   <a name=\"Competencias\" href=\""+url+"Auto_evaluacion_de_competencias"+lang+"\">"+paramRequest.getLocaleString("lblCompetencies")+"</a>");
        out.println("  </h3>");
        out.println("  <p class=\"intro_line\">&nbsp;</p>");
        out.println(" </div>");
        out.println(" <div class=\"cvi-sf-opcion\">");
        out.println("  <ul>");
        if(cv.listCompetencias().hasNext())
            out.println("<li><h4><a href=\""+url+"Auto_evaluacion_de_competencias"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblSelfAssessmentOfSkills")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Auto_evaluacion_de_competencias"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblSelfAssessmentOfSkills")+"</a></h4></li>");
        out.println("  </ul>");
        out.println(" </div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");

        out.println("<div class=\"indice\">");
        out.println(" <div class=\"intro_indice\">");
        done = (cv.isSinInvestigacion() || cv.listInvestigacions().hasNext())&&(cv.isSinDocencia() || cv.listDocencias().hasNext())&&(cv.isSinPublicacion() || cv.listPublicacions().hasNext());
        resume = resume && done;
        out.println("  <h3 class=\""+(done?"icv-semaforo-paloma":"icv-semaforo-tache")+"\">");
        out.println("   <a name=\"Investigacion_y_docencia\" href=\""+url+"Investigacion/"+lang+"\">"+paramRequest.getLocaleString("lblResearchAndTeaching")+"</a>");
        out.println("  </h3>");
        out.println("  <p class=\"intro_line\">&nbsp;</p>");
        out.println(" </div>");
        out.println(" <div class=\"cvi-sf-opcion\">");
        out.println("  <ul>");
        if(cv.isSinInvestigacion() || cv.listInvestigacions().hasNext())
            out.println("<li><h4><a href=\""+url+"Investigacion"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblResearch")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Investigacion"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblResearch")+"</a></h4></li>");
        
        if(cv.isSinDocencia() || cv.listDocencias().hasNext())
            out.println("<li><h4><a href=\""+url+"Docencia"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblTeaching")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Docencia"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblTeaching")+"</a></h4></li>");
        
        if(cv.isSinPublicacion() || cv.listPublicacions().hasNext())
            out.println("<li><h4><a href=\""+url+"Publicaciones"+lang+"\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblPublications")+"</a></h4></li>");
        else
            out.println("<li><h4><a href=\""+url+"Publicaciones"+lang+"\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblPublications")+"</a></h4></li>");
        out.println("  </ul>");        
        out.println(" </div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");
if(resume)
    out.println("<p class=\"cvi-msg-resume-ok\">Infotec agradece tu inter&eacute;s y participaci&oacute;n</p>");
else
    out.println("<p class=\"cvi-msg-resume-no\">Por favor complementa tu informaci&oacute;n</p>");
    }
%>