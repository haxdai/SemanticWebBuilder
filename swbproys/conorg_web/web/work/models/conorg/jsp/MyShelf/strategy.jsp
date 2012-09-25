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
            alwsp = new ArrayList();
            itperws = WorkSpace.ClassMgr.listWorkSpaces(wsite);
%>
<!--div style="float: left"-->
    <ul>
        <%
            int count = 0;
            while (itperws.hasNext()) {
                WorkSpace workSpace = itperws.next();
                alwsp.add(workSpace);
                count++;
                if (count <= numele) {
        %>
        <li class="wssi">
            <a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"><%=workSpace.getTitle()%></a><br/>
            Descripción:<%=workSpace.getDescription()%>
        </li>
        <%
                } else {
                    break;
                }
            }
        %>
    </ul>
<!--/div-->
<div class="tab-work-div">&nbsp;</div>
<%
            itpubws = WorkSpace.ClassMgr.listWorkSpaces(wsite);
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
            <!--div><a href="<%=wpwscontent.getUrl()%>?wsid=<%=workSpace.getId()%>"-->
            <span><%=workSpace.getTitle()%></span><br/>
            <!--/a></div-->
            Descripción:<%=workSpace.getDescription()%>
        </li>
        <%
                    } else {
                        break;
                    }
                }
            }
        %>
    </ul>
<!--/div-->
