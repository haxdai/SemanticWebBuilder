<%@page contentType="text/html"%>
<%@page import="org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%
    SWBParamRequest paramRequest=(SWBParamRequest)request.getAttribute("paramRequest");
    User user=paramRequest.getUser();
    WebPage wpage=paramRequest.getWebPage();

    if(user.isRegistered()&&wpage.getLevel()==3)
        {
%>
<div class="editarInfo" style="float:right;"><p><a href="<%=paramRequest.getRenderUrl().setParameter("act","add").setWindowState(SWBResourceURL.WinState_MAXIMIZED)%>">Crear Comunidad</a></p></div>
<%
        }
%>