<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%
	String idWebSite	=	paramRequest.getWebPage().getWebSiteId();
	String userLang		=	paramRequest.getUser().getLanguage();
	String query 		= 	request.getParameter("query") == null ? "" : request.getParameter("query") ;
%>
    <form id="frmSearch" name="frmSearch" method="post" action="/<%=userLang%>/<%=idWebSite%>/Resultados_Empresas">
      <input type="hidden" name="act" id="act" value="results" />
      <p>
        <label for="query">Buscar</label>
        <input type="text" name="query" id="query" value="<%=query%>" />
        <label for="btnSearch">Buscar</label>
        <input type="submit" name="btnSearch" id="btnSearch" value="Buscar" onclick="javascript:this.form.submit();"/>
      </p>
                  <p class="ejemplo">Ejemplo: Empresas en el estado de Veracruz, Empresas cuya actividad es elaboraci�n de refrescos, Empresas que fabrican Great Cola, Empresas que fabrican galletas, Productos que su categoria es 010123</p>
    </form>