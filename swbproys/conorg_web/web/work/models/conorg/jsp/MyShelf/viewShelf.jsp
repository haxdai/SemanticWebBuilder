<%--
    Document   : view Recurso Shelf
    Created on : 19/06/2012
    Author     : juan.fernandez
--%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.model.GenericObject"%>
<%@page import="org.semanticwb.model.Versionable"%>
<%@page import="org.semanticwb.model.VersionInfo"%>
<%@page import="com.infotec.conorg.WorkSpace"%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="com.infotec.conorg.resources.MyShelf"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="com.infotec.conorg.Topic"%>
<%@page import="com.infotec.conorg.Video"%>
<%@page import="com.infotec.conorg.Report"%>
<%@page import="com.infotec.conorg.Reference"%>
<%@page import="com.infotec.conorg.Presentation"%>
<%@page import="com.infotec.conorg.Document"%>
<%@page import="com.infotec.conorg.Manual"%>
<%@page import="com.infotec.conorg.Image"%>
<%@page import="com.infotec.conorg.Book"%>
<%@page import="com.infotec.conorg.ChapterBook"%>
<%@page import="com.infotec.conorg.Audio"%>
<%@page import="com.infotec.conorg.Article"%>
<%@page import="com.infotec.conorg.URL"%>
<%@page import="com.infotec.conorg.Mosaic"%>
<%@page import="com.infotec.conorg.Contact"%>
<%@page import="com.infotec.conorg.Tile"%>
<%@page import="com.infotec.conorg.Shelf"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="java.util.Set"%>
<%@page import="org.semanticwb.model.SWBComparator"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.Role"%>
<%@page import="org.semanticwb.model.Resource"%> 
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBUtils"%>

<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />

<%

    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;
    Resource base = paramRequest.getResourceBase();

    String confClass = base.getAttribute(MyShelf.RES_CONF, "http://www.infotec.com/conorg.owl#Shelf");
    String path = SWBPlatform.getContextPath() + "/swbadmin/images/repositoryfile/";

    int luser = 1;
    boolean isShelf = Boolean.FALSE;

    if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
        isShelf = Boolean.TRUE;
    } else if (confClass.equals(Shelf.conorg_Shelf.getURI())) {
        isShelf = Boolean.FALSE;
    }

    Shelf shelf = null;
    WorkSpace workSpace = null;
    long intSize = 0;
    if (isShelf) {
        shelf = Shelf.ClassMgr.getShelf(usr.getId(), wsite);
        if (shelf == null) {
            shelf = Shelf.ClassMgr.createShelf(usr.getId(), wsite);
            shelf.setOwner(usr);
        }
        intSize = SWBUtils.Collections.sizeOf(shelf.listTiles());
    } else {
        //intSize = WorkSpace.ClassMgr.l
    }

    Iterator<Tile> ittil = shelf.listTiles();

    String strNumItems = base.getAttribute("numpag", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String action = request.getParameter("act");

    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    //if (orderby == null) {
    //    orderby = "date";
    //}

    if (action == null) {
        action = "";
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", new Locale("es"));


    //String strOrder = "";

    //todo: ordenamiento
//            list=SWBComparator.sortByCreatedSet(GradoAcademico.ClassMgr.listG(usuario, wsite),false);



    if (request.getParameter("alertmsg") != null) {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br>", "\\n\\r");
%>
<script type="text/javascript">
    alert('<%=strMsg%>');
</script>
<%
    }

%>
<div >
    <div id="conorg">
        <%@include file="tiles.jsp" %>
    </div>
</div>
</div>

<%!
    

%>