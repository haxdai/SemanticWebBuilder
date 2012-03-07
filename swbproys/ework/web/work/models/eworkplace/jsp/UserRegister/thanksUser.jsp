<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.User"%>
<jsp:useBean id="msg" scope="request" type="java.lang.String"/>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
            /*    String msg = request.getParameter("msg");
            if(msg==null)
            msg = (String)request.getAttribute("msg");
            if(msg!=null) {
            if(msg.equalsIgnoreCase("ok")){
             */
%>
<div id="icv">
    <div id="icv-data">
        <p><strong><%=msg%></strong></p>
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
