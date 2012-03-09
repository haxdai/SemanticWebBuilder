<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.infotec.cvi.swb.Academia"%>
<%@page import="com.infotec.cvi.swb.CV"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.text.DecimalFormat"%>
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
    if(user.isSigned())
    {
        WebSite wsite = paramRequest.getWebPage().getWebSite();
        CV cv = CV.ClassMgr.getCV(user.getId(), wsite);
        Academia aca = cv.getAcademia();
        
        boolean done = false;
        float progress = 0;
        boolean doneSchooling = aca.listGradoAcademicos().hasNext()&&(aca.isNoAplicaEstudioSuperior() || aca.listEstudioSuperiors().hasNext())&&(cv.isSinDiplomado() || cv.listDiplomados().hasNext())&&(cv.isSinCurso() || cv.listCursosTICs().hasNext())&&(cv.isSinIdioma() || cv.listIdiomas().hasNext());
        if(doneSchooling)
            progress+=0.25;
        boolean doneExperience = (cv.isSinExperiencia() || cv.listExperienciaLaborals().hasNext())&&cv.listAreaTalentos().hasNext()&&(cv.isSinDistincion() || cv.listDistincions().hasNext());
        if(doneExperience)
            progress+=0.25;
        boolean doneCompetencies = cv.listCompetencias().hasNext();
        if(doneCompetencies)
            progress+=0.25;
        boolean doneResearchAndTeaching = (cv.isSinInvestigacion() || cv.listInvestigacions().hasNext())&&(cv.isSinDocencia() || cv.listDocencias().hasNext())&&(cv.isSinPublicacion() || cv.listPublicacions().hasNext());
        if(doneResearchAndTeaching)
            progress+=0.25;
        
        DecimalFormat df = new DecimalFormat("###");
%>
<div class="cuerpo-sem">
 <div id="cvi-semaforo-gral">
  <div id="cvi-semaforo-crece" style="padding-left:<%=df.format(817*progress)%>px;">&nbsp;</div> <!-- 100% = 817px -->
  <div id="cvi-semaforo-flecha"><span><%=df.format(100*progress)%> &#37;</span></div>
  <div class="clearer">&nbsp;</div>
  <div id="cvi-semaforo-pends">
<%
        StringBuilder missing = new StringBuilder();
        if(!doneSchooling)
            missing.append(paramRequest.getLocaleString("lblSchooling")+" - ");
        if(!doneExperience)
            missing.append(paramRequest.getLocaleString("lblExperience")+" - ");
        if(!doneCompetencies)
            missing.append(paramRequest.getLocaleString("lblCompetencies")+" - ");
        if(!doneResearchAndTeaching)
            missing.append(paramRequest.getLocaleString("lblResearchAndTeaching"));
        
        try {
            if(missing.toString().endsWith(" - "))
                out.print(missing.substring(0, missing.toString().lastIndexOf(" - ")));
            else
                out.print(missing.toString());
        }catch(StringIndexOutOfBoundsException e) {
            out.print(missing.toString());
        }
%>
  </div>
 </div>
</div>
<%
    }
%>