<%--   
    Document   : view Recurso Temas
    Created on : 27/06/2012
    Author     : rene.jara
--%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Comparator"%>
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
            WebPage wptocontent = wsite.getWebPage(base.getAttribute("idwpto", wpage.getId()));
            int numele;
            try {
                numele = Integer.parseInt(base.getAttribute("numele", "3"));
            } catch (Exception ignored) {
                numele = 3;
            }

            Iterator<com.infotec.conorg.Topic> itto=com.infotec.conorg.Topic.ClassMgr.listTopics(wsite);
%>
<!--div-->
    <ul>
        <%
        int count = 0;
         while(itto.hasNext()){
            com.infotec.conorg.Topic topic=itto.next();
             count++;
             if(count<= numele){
            %>
        <li>
            <a href="<%=wptocontent.getUrl()%>?toid=<%=topic.getId()%>"><%=topic.getTitle()%></a>
        </li>
        <%
            }else{
                break;
            }
         }
    %>
    </ul>
    <p class="vertodos"><a href="<%=wptocontent.getUrl()%>">Ver todos</a></p>
<!--/div-->
