<%-- 
Document   : ajax
Created on : 17/04/2012, 06:36:23 PM
Author     : rene.jara
--%>
<%@page import="org.semanticwb.platform.SemanticOntology"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBResource"%>
<%@page import="org.semanticwb.portal.SWBFormButton"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.platform.SemanticClass"%>
<%@page import="org.semanticwb.portal.SWBFormMgr"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.infotec.conorg.*"%> 
<%@page import="org.semanticwb.model.*"%>
<%@page contentType="text/html" pageEncoding="ISO8859-1"%>
<!DOCTYPE html>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>

<%
//ISO-8859-1

    WebSite ws = paramRequest.getWebPage().getWebSite();
    User user = paramRequest.getUser();
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Pragma", "no-cache");
    String id = request.getParameter("id");
    String wsid = request.getParameter("wsid");
    String classid = request.getParameter("classid");
    SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();

    if (classid != null && !classid.equals("")) {
        SemanticClass sc = null;
        SemanticObject so = ont.getSemanticObject(classid);
        if (so != null) {
            SWBResourceURL urladd = paramRequest.getActionUrl();
            urladd.setAction(SWBResourceURL.Action_ADD);
            urladd.setMode(SWBResourceURL.Mode_VIEW);
            urladd.setCallMethod(SWBResourceURL.Call_CONTENT);
            urladd.setParameter("classid", classid);
            sc = so.transformToSemanticClass();
            SWBFormMgr frmgr = new SWBFormMgr(sc, ws.getSemanticObject(), SWBFormMgr.MODE_CREATE);
            frmgr.setType(SWBFormMgr.TYPE_DOJO);

            if(null!=wsid)frmgr.addHiddenParameter("wsid", wsid);
            frmgr.setAction(urladd.toString());
            frmgr.setLang("es");
            frmgr.setOnSubmit("enviar('" + classid + "/form');");
            
            SWBResourceURL url = paramRequest.getRenderUrl();
            url.setMode(SWBResourceURL.Mode_VIEW);
            url.setCallMethod(SWBResourceURL.Call_CONTENT);
            if(null!=wsid) url.setParameter("wsid", wsid);
            
            
            String boton = "<button dojoType=\"dijit.form.Button\" onclick=\"window.location='" + url + "';return false;\">Cancelar</button>";
            frmgr.addButton(boton);
            //frmgr.addButton(SWBFormButton.newCancelButton());
            frmgr.addButton(SWBFormButton.newSaveButton());
%>
<%=frmgr.renderForm(request)%>
<%
    }
} 
    /*
    else if (id != null && !id.trim().equals("")) {
    SemanticObject so = ont.getSemanticObject(id);
    if (so != null) {
        SWBResourceURL urlupdate = paramRequest.getActionUrl();
        urlupdate.setAction(SWBResourceURL.Action_EDIT);
        urlupdate.setMode(SWBResourceURL.Mode_VIEW);
        urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);
        urlupdate.setParameter("id", id);

        SWBFormMgr frmgr = new SWBFormMgr(so, SWBFormMgr.MODE_EDIT, SWBFormMgr.MODE_EDIT);

        frmgr.setAction(urlupdate.toString());
        frmgr.setLang("es");
        frmgr.setOnSubmit("enviar('" + classid + "/form');");
        frmgr.addButton(SWBFormButton.newCancelButton());
        frmgr.addButton(SWBFormButton.newSaveButton());
 */ 
%>
<%//=frmgr.renderForm(request)%>
<%
        //}

    //}
%>