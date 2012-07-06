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

            String wsid = request.getParameter("wsid");
            Member member = Member.ClassMgr.getMember(user.getId(), wsite);
            if (member == null) {
                member = Member.ClassMgr.createMember(user.getId(), wsite);
                member.setUser(user);
            }
            if (wsid == null || wsid.equals("")) {
                ArrayList alwsp = new ArrayList();
                Iterator<WorkSpace> itperws = WorkSpace.ClassMgr.listWorkSpaceByMember(member);
%>
<div>
    <ul>
        <%
            while (itperws.hasNext()) {
                WorkSpace workSpace = itperws.next();
                alwsp.add(workSpace);
        %>
        <li>
            <div><a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a></div>
            <div>
                <div>Descripción:<%=workSpace.getDescription()%></div>
                <div>Temas:
                    <%
                        Iterator<com.infotec.conorg.Topic> itto = workSpace.listTopics();
                        while (itto.hasNext()) {
                            com.infotec.conorg.Topic topic = itto.next();
                    %>
                    <%=topic.getTitle()%>,
                    <%
                        }
                    %>
                </div>
                <%
                    Iterator<Member> itme = workSpace.listMembers();
                %>
                <div>Participante:
                    <ul>
                        <%
                            while (itme.hasNext()) {
                                Member mem = itme.next();
                        %>
                        <li>
                            <%=mem.getUser().getFullName()%>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
                <%
                    Iterator<Tile> itti = workSpace.listTiles();
                %>
                <div>Azulejos:
                    <ul>
                        <%
                            while (itti.hasNext()) {
                                Tile tile = itti.next();
                        %>
                        <li>
                            <%=tile.getTitle()%>
                        </li>
                        <%
                            }
                        %>
                    </ul>
                </div>
            </div>
        </li>
        <%
            }
        %>
    </ul>
</div>
<%
    Iterator<WorkSpace> itpubws = WorkSpace.ClassMgr.listWorkSpaces(wsite);
%>
<div >
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
<%
} else {
    WorkSpace workSpace = WorkSpace.ClassMgr.getWorkSpace(wsid, wsite);
    if (workSpace != null) {
%>
<div>
    <div><%=workSpace.getTitle()%></div>
    <div>
        <div>Descripción:<%=workSpace.getDescription()%></div>
        <div>Temas:
            <%
                Iterator<com.infotec.conorg.Topic> itto = workSpace.listTopics();
                while (itto.hasNext()) {
                    com.infotec.conorg.Topic topic = itto.next();
            %>
            <%=topic.getTitle()%>,
            <%
                }
            %>
        </div>
        <%
            Iterator<Member> itme = workSpace.listMembers();
            boolean isMember = false;
            while (itme.hasNext()) {
                Member mem = itme.next();
                if (mem.getUser().equals(user)) {
                    isMember = true;
                    break;
                }
            }
            if (isMember) {
                itme = workSpace.listMembers();
        %>
        <div>Participante:
            <ul>
                <%
                    while (itme.hasNext()) {
                        Member mem = itme.next();
                %>
                <li>
                    <%=mem.getUser().getFullName()%>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
        <%
            Iterator<Tile> itti = workSpace.listTiles();
        %>
        <div>Azulejos:
            <ul>
                <%
                    while (itti.hasNext()) {
                        Tile tile = itti.next();
                %>
                <li>
                    <%=tile.getTitle()%>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
        <%
            }
        %>
    </div>
</div>
<%
                }
            }
%>
