<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.servlet.RequestDispatcher"%>
<%@page import="org.semanticwb.Logger"%>
<%@page import="org.semanticwb.SWBUtils"%>
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
        CV cv = CV.ClassMgr.getCV(user.getId(), paramRequest.getWebPage().getWebSite());
        Academia aca = cv.getAcademia();
        
        out.println("<div class=\"indice\">");
        out.println("<div class=\"intro_indice\">");
        out.println("<h3 class=\"icv-semaforo-tache\">");
        out.println("<a href=\"#\">"+paramRequest.getLocaleString("lblSchooling")+"</a>");
        out.println("</h3>");
        out.println("<p class=\"intro_line\">&nbsp;</p>");
        out.println("</div>");

        out.println("<div class=\"cvi-sf-opcion\">");
        out.println("  <ul>");
        if(aca.listGradoAcademicos().hasNext())
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblDegrees")+"</a></h4></li>");
        else
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblDegrees")+"</a></h4></li>");
        if(aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext())
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblHigherEducation")+"</a></h4></li>");
        else
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblHigherEducation")+"</a></h4></li>");
        if(cv.isSinCurso() || cv.listDiplomados().hasNext() || cv.listCursosTICs().hasNext())
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblCourses")+"</a></h4></li>");
        else
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblCourses")+"</a></h4></li>");
        out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblSpecializationICT")+"</a></h4></li>");
        if(cv.isSinIdioma() || cv.listIdiomas().hasNext())
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblLanguages")+"</a></h4></li>");
        else
            out.println("    <li><h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblLanguages")+"</a></h4></li>");
        out.println("  </ul>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");

        out.println("<div class=\"indice\">");
        out.println("  <div class=\"intro_indice\">");
        out.println("    <h3 class=\"icv-semaforo-paloma\"> <a href=\"#\">"+paramRequest.getLocaleString("lblExperience")+"</a> </h3>");
        out.println("    <p class=\"intro_line\">&nbsp;</p>");
        out.println("  </div>");
        out.println("  <div class=\"cvi-sf-opcion\">");
        out.println("    <ul>");
        out.println("      <li>");
        if(cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext())
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblJobExperience")+"</a></h4>");
        else
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblJobExperience")+"</a></h4>");
        out.println("      </li>");
        out.println("      <li>");
        out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblExpertise")+"</a></h4>");
        out.println("      </li>");
        out.println("      <li>");
        if(cv.isSinDistincion() || cv.listDistincions().hasNext())
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblAwards")+"</a></h4>");
        else
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblAwards")+"</a></h4>");
        out.println("      </li>");
        out.println("    </ul>");
        out.println("  </div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");

        out.println("<div class=\"indice\">");
        out.println("  <div class=\"intro_indice\">");
        out.println("    <h3 class=\"icv-semaforo-tache\"> <a href=\"#\">"+paramRequest.getLocaleString("lblCompetencies")+"</a> </h3>");
        out.println("    <p class=\"intro_line\">&nbsp;</p>");
        out.println("  </div>");
        out.println("  <div class=\"cvi-sf-opcion\">");
        out.println("    <ul>");
        out.println("      <li>");
        if(cv.listCompetencias().hasNext())
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblSelfAssessmentOfSkills")+"</a></h4>");
        else
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblSelfAssessmentOfSkills")+"</a></h4>");
        out.println("      </li>");
        //        out.println("      <li>");
        //        out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-rojo\">Competencias por perfiles de TI</a></h4></li><li>");
        //        out.println("      </li>");
        out.println("    </ul>");
        out.println("  </div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");

        out.println("<div class=\"indice\">");
        out.println("  <div class=\"intro_indice\">");
        out.println("    <h3 class=\"icv-semaforo-tache\"> <a href=\"#\">"+paramRequest.getLocaleString("lblResearchAndTeaching")+"</a></h3>");
        out.println("    <p class=\"intro_line\">&nbsp;</p>");
        out.println("  </div>");
        out.println("  <div class=\"cvi-sf-opcion\">");
        out.println("    <ul>");
        out.println("      <li>");
        if(cv.isSinInvestigacion() || cv.listInvestigacions().hasNext())
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblResearch")+"</a></h4>");
        else
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblResearch")+"</a></h4>");
        out.println("      </li>");
        out.println("      <li>");
        if(cv.isSinDocencia() || cv.listDocencias().hasNext())
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblTeaching")+"</a></h4>");
        else
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblTeaching")+"</a></h4>");
        out.println("      </li>");
        out.println("      <li>");
        if(cv.isSinPublicacion() || cv.listPublicacions().hasNext())
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-verde\">"+paramRequest.getLocaleString("lblPublications")+"</a></h4>");
        else
            out.println("        <h4><a href=\"#\" class=\"cvi-semaforo-rojo\">"+paramRequest.getLocaleString("lblPublications")+"</a></h4>");
        out.println("      </li>");
        out.println("    </ul>");
        out.println("  </div>");
        out.println("</div>");
        out.println("<div style=\"clear: both;\"></div>");
    }
%>