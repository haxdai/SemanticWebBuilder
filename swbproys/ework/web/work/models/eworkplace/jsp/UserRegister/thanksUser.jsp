<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
            /*    String msg = request.getParameter("msg");
            if(msg==null)
            msg = (String)request.getAttribute("msg");
            if(msg!=null) {
            if(msg.equalsIgnoreCase("ok")){
             */%>

<div id="icv">
    <%//@include file="../menucvi.jsp" %>
    <div id="icv-data">
        <pre><strong>Gracias por registrarse. El personal calificado ya nos indicará que poner aquí de mensaje</strong></pre>
    </div>
</div>
<%/*
            }
            }else if(request.getAttribute("2confirm")!=null) {
            WebSite website = paramRequest.getWebPage().getWebSite();
            User user=(User)request.getAttribute("user");
             */%>
<%
            //}

%>
