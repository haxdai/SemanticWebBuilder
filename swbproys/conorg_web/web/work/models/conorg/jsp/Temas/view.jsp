<%--   
    Document   : view Recurso Temas
    Created on : 27/06/2012
    Author     : rene.jara
--%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.conorg.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
//System.out.println("************************************************************");
            WebPage wp = paramRequest.getWebPage();
            WebSite ws = wp.getWebSite();
            User user = paramRequest.getUser();
            String orderby=request.getParameter("ob");
//System.out.println("user:"+user);
//System.out.println("orderby"+orderby);
            String url=paramRequest.getRenderUrl().toString();

            Iterator<com.infotec.conorg.Topic> ittmp=com.infotec.conorg.Topic.ClassMgr.listTopics(ws);
            Iterator<com.infotec.conorg.Topic> itto;
            if(orderby!=null&&!orderby.equals("")){
                if(orderby.equals("n")){
                    itto=SWBComparator.sortByDisplayName(ittmp,user.getLanguage());
                }else if(orderby.equals("d")){
                    itto=SWBComparator.sortSermanticObjects(new orderByDescription(),ittmp);
                }else{
                    itto=ittmp;
                }
            }else{
                itto=ittmp;
            }

%>
<div><%=orderby%>
    <a href="<%=url%>?ob=n">por nombre</a> <a href="<%=url%>?ob=d">por descripcion</a>
    <ul>
        <%
         while(itto.hasNext()){
            com.infotec.conorg.Topic topic=itto.next();
            %>
        <li>
            <div><%=topic.getTitle()%></div>
            <div><%=topic.getDescription()%></div>
        </li>
        <%
         }
    %>
    </ul>
</div>
<%!


    class orderByDescription implements Comparator<com.infotec.conorg.Topic>{
        public int compare(com.infotec.conorg.Topic t1, com.infotec.conorg.Topic t2) {
            String n1, n2;
            n1=t1.getDescription();
            n2=t2.getDescription();
            return n1.compareTo(n2);
        }
    }

%>
