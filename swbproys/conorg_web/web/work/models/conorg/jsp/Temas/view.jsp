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
            WebPage wp = paramRequest.getWebPage();
            WebSite ws = wp.getWebSite();
            User user = paramRequest.getUser();
            String orderby=request.getParameter("ob");
            String url=paramRequest.getRenderUrl().toString();
            org.semanticwb.model.Resource base = paramRequest.getResourceBase();

            long numpag;
            try{
                numpag=Long.parseLong(base.getAttribute("numpag","10"));
            }catch(Exception ignored){
                numpag=10;
            }
            long totpag;
            long curpag;
            long currec=0;
            try{
                curpag=Long.parseLong(request.getParameter("page"));
            }catch(Exception ignored){
                curpag=1;
            }
            Iterator<com.infotec.conorg.Topic> ittmp=com.infotec.conorg.Topic.ClassMgr.listTopics(ws);
            Iterator<com.infotec.conorg.Topic> itto=com.infotec.conorg.Topic.ClassMgr.listTopics(ws);
            long totrec=SWBUtils.Collections.sizeOf(itto);
            totpag=(long)Math.floor(totrec/numpag);

            if((totrec%numpag)>0){
                totpag++;
            }
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
<div>
    <%
            if(orderby!=null&&orderby.equals("n")){
%>
    por nombre
    <%

            }else{
    %>
    <a href="<%=url%>?ob=n">por nombre</a>
    <%

            }
    if(orderby!=null&&orderby.equals("d")){
%>
    por descripcion
    <%

            }else{
    %>
    <a href="<%=url%>?ob=d">por descripcion</a>
    <%

            }
    %>
    <ul>
        <%

         while(itto.hasNext()){
            com.infotec.conorg.Topic topic=itto.next();
            currec++;
            if(currec>((curpag-1)*numpag)&&currec<=(curpag*numpag)){
            %>
        <li>
            <div><%=topic.getTitle()%></div>
            <div><%=topic.getDescription()%></div>
        </li>
        <%
            }else if(currec>(curpag*numpag)){
                break;
            }
         }
    %>
    </ul>
    <ul>
<%
        url+="?";
        if(orderby!=null&&!orderby.equals("")){
            url+="ob="+orderby+"&";
        }
        url+="page=";

    for(int i=1;i<=totpag;i++){
        if(i==curpag){
%>
        <li><%=i%></li>
<%
}else{
%>
        <li><a href="<%=url+i%>"><%=i%></a></li>
<%
}
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
