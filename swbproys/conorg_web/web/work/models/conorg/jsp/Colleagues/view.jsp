<%--   
    Document   : view Recurso Colleagues
    Created on : 19/06/2012
    Author     : rene.jara
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Comparator"%>
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
            if(colleague==null){
                colleague=Colleague.ClassMgr.createColleague(user.getId(), wsite);
            }
            Iterator<User> itco=colleague.listColleagueses();
            org.semanticwb.model.Resource base = paramRequest.getResourceBase();
            //WebPage wpwscontent = wsite.getWebPage(base.getAttribute("idwpco",wpage.getId()));
            //String editUrl = paramRequest.getActionUrl().setMode(SWBResourceURL.Mode_EDIT).toString();
            ArrayList alus = new ArrayList();
            String remUrl = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_REMOVE).toString();
            String addUrl = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD).toString();
            while(itco.hasNext()){
                User usrCo=itco.next();
                alus.add(usrCo);
            }
            Iterator<User> itus=wsite.getUserRepository().listUsers();
            itus=SWBComparator.sortSermanticObjects(new orderByFullName(),itus);
%>
<div id="directorio">
    <form id="colform" action="<%=addUrl%>" method="post" >
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
        <input type="submit" value="agregar">
    </form>
<table class="conorg-table directorio-vista">
  <thead>
    <tr>
      <th class="titulo"><strong>Nombre</strong></th>
      <th class="mail">Correo</th>
      <th class="accion">&nbsp;</th>
    </tr>
  </thead>
  <tbody>
        <%
        itco=colleague.listColleagueses();
         while(itco.hasNext()){
            User usrCo=itco.next();
//                User us=(User)colleague.listColleagueses();
            %>
        <tr>
      <td class="dir-foto"><%=usrCo.getFullName()%></td>
      <td><span class="icv-mail"><a href="<%=usrCo.getEmail()!=null?"mailto:"+usrCo.getEmail():""%>"><%=usrCo.getEmail()!=null?usrCo.getEmail():""%></a></span></td>
      <td><span class="icv-borrar"><a onclick_="" title="borrar" href="<%=remUrl%>?idco=<%=usrCo.getId()%>">Borrar</a></span></td>
      </tr>
        <%
         }
    %>
  </tbody>
</table>
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