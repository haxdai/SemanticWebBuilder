<%--   
Document   : view Recurso WorkSpaces
Created on : 19/06/2012
Author     : rene.jara
--%>
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
            org.semanticwb.model.Resource base = paramRequest.getResourceBase();
            WebPage wpwscontent = wsite.getWebPage(base.getAttribute("idwpws",wpage.getId()));
            Member member = Member.ClassMgr.getMember(user.getId(), wsite);
            if (member == null) {
                member = Member.ClassMgr.createMember(user.getId(), wsite);
                member.setUser(user);
            }
            ArrayList alwsp = new ArrayList();
            Iterator<WorkSpace> itperws = WorkSpace.ClassMgr.listWorkSpaceByMember(member);
%>
<div style="float: left">
    <ul>
        <%
                    while (itperws.hasNext()) {
                        WorkSpace workSpace = itperws.next();
                        alwsp.add(workSpace);
        %>
        <li>
            <div><a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a></div>
            <div>Descripción:<%=workSpace.getDescription()%></div>
        </li>
        <%
                    }
        %>
    </ul>
</div>
<%
            Iterator<WorkSpace> itpubws = WorkSpace.ClassMgr.listWorkSpaces(wsite);
%>
<div style="float: left">
    <ul>
        <%
                    while (itpubws.hasNext()) {
                        WorkSpace workSpace = itpubws.next();
                        if (!alwsp.contains(workSpace)) {
        %>
        <li>
            <div><a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a></div>
            <div>Descripción:<%=workSpace.getDescription()%></div>
        </li>
        <%
                        }
                    }
        %>
    </ul>
</div>
