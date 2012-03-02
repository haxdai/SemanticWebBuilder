<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
<jsp:useBean id="msg" scope="request" type="java.lang.String"/>
<jsp:useBean id="url" scope="request" type="java.lang.String"/>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<div id="icv">
  <div id="icv-data">
    <p><strong><%=msg%></strong></p>
    <p><a href="<%=url%>">Continuar...</a></p>    
  </div>
</div>
