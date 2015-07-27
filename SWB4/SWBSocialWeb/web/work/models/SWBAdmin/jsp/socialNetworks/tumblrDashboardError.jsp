<%@page import="org.semanticwb.social.admin.resources.TumblrDashboard"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<jsp:useBean id="errorType" scope="request" type="String"/>

<% if(errorType.equals(TumblrDashboard.AUTH_ERROR)){%>
    <div id=\"configuracion_redes\">
        <div id=\"autenticacion\">
            <p>      La cuenta no ha sido autenticada correctamente</p>
        </div>
    </div>
<% } %>