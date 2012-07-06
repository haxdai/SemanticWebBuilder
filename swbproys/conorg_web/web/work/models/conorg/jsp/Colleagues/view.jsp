<%--   
    Document   : view Recurso Colleagues
    Created on : 19/06/2012
    Author     : rene.jara
--%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.conorg.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
            WebPage wpage = paramRequest.getWebPage();
            WebSite wsite = wpage.getWebSite();
            User user = paramRequest.getUser();
            Colleague colleague=Colleague.ClassMgr.getColleague(user.getId(), wsite);
            Iterator<User> itco=colleague.listColleagueses();
            org.semanticwb.model.Resource base = paramRequest.getResourceBase();
            WebPage wpwscontent = wsite.getWebPage(base.getAttribute("idwpws",wpage.getId()));
%>
<div>
    <a href="<%=wpwscontent.getUrl()%>">Administrar contactos</a>
    <ul>
        <%
         while(itco.hasNext()){
            User usrCo=itco.next();
//                User us=(User)colleague.listColleagueses();
            %>
        <li>
            <div><%=usrCo.getFullName()%></div>
        </li>
        <%
         }
    %>
    </ul>
</div>

