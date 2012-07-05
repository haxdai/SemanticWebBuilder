<%--   
Document   : view Recurso WorkSpaces
Created on : 19/06/2012
Author     : rene.jara
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.conorg.*"%>
<%@page import="org.semanticwb.model.*"%>

<%
            //WebPage wp = paramRequest.getWebPage();
            //WebSite ws = wp.getWebSite();
            //User user = paramRequest.getUser();
            //Member member = Member.ClassMgr.getMember(user.getId(), ws);
            //if (member == null) {
            //    member = Member.ClassMgr.createMember(user.getId(), ws);
            //    member.setUser(user);
            //}
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
            <div><a href="/swb/conorg/workspace?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a></div>
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
            <div><a href="/swb/conorg/workspace?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a></div>
            <div>Descripción:<%=workSpace.getDescription()%></div>
        </li>
        <%
                        }
                    }
        %>
    </ul>
</div>
