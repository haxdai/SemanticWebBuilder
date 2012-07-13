<%--   
    Document   : edit Recurso Colleagues
    Created on : 19/06/2012
    Author     : rene.jara
--%>
<%@page import="java.util.Comparator"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.ArrayList"%>
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
            if(colleague==null){
                colleague=Colleague.ClassMgr.createColleague(user.getId(), wsite);
            }
            Iterator<User> itco=colleague.listColleagueses();
            ArrayList alus = new ArrayList();
			
            String remUrl = paramRequest.getActionUrl().setMode(SWBResourceURL.Mode_EDIT).setAction(SWBResourceURL.Action_REMOVE).toString();
%>
<div>
    <ul>
        <%
         while(itco.hasNext()){
            User usrCo=itco.next();
            alus.add(usrCo);
            %>
        <li>
            <div><%=usrCo.getFullName()%></div>
            <div><a href="<%=remUrl%>?idco=<%=usrCo.getId()%>">Eliminar</a></div>
        </li>
        <%
         }
    %>
    </ul>
</div>
<%
            String addUrl = paramRequest.getActionUrl().setMode(SWBResourceURL.Mode_EDIT).setAction(SWBResourceURL.Action_ADD).toString();
            Iterator<User> itus=wsite.getUserRepository().listUsers();
            itus=SWBComparator.sortSermanticObjects(new orderByFullName(),itus);

%>
<div>agregar uno
    <form action="<%=addUrl%>" method="get">
        <select id="idco" name="idco">
        <%
         while(itus.hasNext()){
            User usrCo=itus.next();
            if(!alus.contains(usrCo)&&!usrCo.equals(user)){
            %>
            <option value="<%=usrCo.getId()%>"><%=usrCo.getFullName()%></option>>
        <%
        }
         }
    %>
        </select>
        <input type="submit" value="enviar"/>
    </form>
</div>
<%!
    class orderByFullName implements Comparator<org.semanticwb.model.User>{
        public int compare(org.semanticwb.model.User u1, org.semanticwb.model.User u2) {
            String n1, n2;
            n1=u1.getFullName();
            n2=u2.getFullName();
            return n1.compareTo(n2);
        }
    }
%>