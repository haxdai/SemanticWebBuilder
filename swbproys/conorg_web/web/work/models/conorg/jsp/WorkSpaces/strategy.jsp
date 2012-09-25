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
            WebPage wpwscontent = wsite.getWebPage(base.getAttribute("idwpws", wpage.getId()));
            int numele;
            try {
                numele = Integer.parseInt(base.getAttribute("numele", "3"));
            } catch (Exception ignored) {
                numele = 3;
            }
            Iterator<Member> itme=Member.ClassMgr.listMemberByUser(user, wsite);
            /*Member member = Member.ClassMgr.getMember(user.getId(), wsite);
            if (member == null) {
                member = Member.ClassMgr.createMember(user.getId(), wsite);
                member.setUser(user);
            }*/
            ArrayList alwsp = new ArrayList();
%>
<!--div style="float: left"-->
<p class="ws-mios">Mis Espacios de trabajo</p>
    <ul>
        <%
            int count = 0;
            while(itme.hasNext()){
                Member member=itme.next();
                Iterator<WorkSpace> itperws = WorkSpace.ClassMgr.listWorkSpaceByMember(member);

                while (itperws.hasNext()) {
                    WorkSpace workSpace = itperws.next();
                    alwsp.add(workSpace);
                    count++;
                    if (count <= numele) {
        %>
        <li class="wssi">
            <a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a><br/>
            <%=workSpace.getDescription()!=null?workSpace.getDescription():""%>
        </li>
        <%
                    } else {
                        //break;
                    }
                }
            }
        %>
    </ul>
<!--/div-->

      <p class="vertodos"><a href="<%=wpwscontent.getUrl()%>">Ver todos</a></p>
     <!--div class="tab-work-div">&nbsp;</div-->

     <p class="ws-otros">Otros Espacios de trabajo</p>
<%
            Iterator<WorkSpace> itpubws = WorkSpace.ClassMgr.listWorkSpaces(wsite);
%>
<!--div style="float: left"-->
    <ul>
        <%
            count = 0;
            while (itpubws.hasNext()) {
                WorkSpace workSpace = itpubws.next();
                if (!alwsp.contains(workSpace)) {
                    count++;
                    if (count <= numele) {
        %>
        <li class="wsno">
            <span><%=workSpace.getTitle()%></span><br/>
            <%=workSpace.getDescription()!=null?workSpace.getDescription():""%>
        </li>
        <%
                    } else {
                        break;
                    }
                }
            }
        %>
    </ul>
        <p class="vertodos"><a href="<%=wpwscontent.getUrl()%>">Ver todos</a></p>
<!--/div-->
