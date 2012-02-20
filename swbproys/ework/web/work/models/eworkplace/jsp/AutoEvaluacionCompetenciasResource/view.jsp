<%--   
    Document   : view Recurso AutoEvaluacionCompetenciasResource
    Created on : 17/02/2012
    Author     : carlos.ramos
--%>
<%@page import="com.infotec.cvi.swb.*"%>
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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
    User usr = paramRequest.getUser();
    if(!usr.isSigned())
        return;

    WebPage wpage = paramRequest.getWebPage(); 
    WebSite wsite = wpage.getWebSite();

    final String lang = usr.getLanguage();
    Locale locale = new Locale(lang,(usr.getCountry()==null?"MX":usr.getCountry()));

    Role role=null;

    CV cv = CV.ClassMgr.getCV(usr.getId(), wsite);
    
    Iterator<Competencia> competencias = Competencia.ClassMgr.listCompetencias(wsite);
    String action = request.getParameter("act");
    if (action == null) {
        action = "";
    }

    if(request.getParameter("alertmsg")!=null)
    {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br>", "\\n\\r");
%>
<script type="text/javascript">
    alert('<%=strMsg%>');
</script>
<%
    }
%>
<script type="text/javascript">
<!--
  

    function enviar() {
      return true;  
    }
-->
</script>
<div>  
<div id="icv">
<%-- @include file="../menucvi.jsp" --%>
<div id="icv-data">
<%
System.out.println("...........action="+action);
    /*if(action.equals(""))
    {*/
        if(competencias.hasNext()) {
            SWBResourceURL urladd = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_EDIT);
%>
<form id="form1ga" method="post" action="<%=urladd%>">
 <div class="icv-div-grupo">
  <table class="icv-table">
<%
            while(competencias.hasNext()) {
                Competencia competencia = competencias.next();
%>
    <tr>
        <td><%=competencia.getTitle()%></td>
        <td><%=competencia.getDescription()%></td>
        <td><label><input type="checkbox" name="cmptc" value="<%=competencia.getId()%>" <%=(cv.hasCompetencia(competencia)?"checked=\"checked\"":"")%> /></label></td>
    </tr>
<%
            }
%>
  </table>
  <div class="clearer">&nbsp;</div>
 </div>
 <div class="centro">
  <input type="submit" name="guardar" value="Guardar" />
 </div>
</form>
<%
        }
    //}
%>
</div>
</div><!-- icv-data -->  
</div>