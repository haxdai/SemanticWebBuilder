<%-- 
Document   : ajax
Created on : 17/04/2012, 06:36:23 PM
Author     : rene.jara
--%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.HashMap"%>
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
    String modo = request.getParameter("mode");
    SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();

    if (classid != null && !classid.equals("")&&modo!=null&&modo.equals("tile")) {
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
            boton = "<button dojoType=\"dijit.form.Button\" type=\"submit\" >Guardar</button>";
            frmgr.addButton(boton);
            //frmgr.addButton(SWBFormButton.newCancelButton());
            frmgr.addButton(SWBFormButton.newSaveButton());
%>
<%=frmgr.renderForm(request)%>
<%
    }
}  else if (wsid!= null && !wsid.trim().equals("")&&modo!=null&&modo.equals("member")) {
        WorkSpace wspace = WorkSpace.ClassMgr.getWorkSpace(wsid, ws);
        
        HashMap<User,Member> hmusrmbr = new HashMap<User,Member>();
        Iterator<Member> itmbr = wspace.listMembers();
        while(itmbr.hasNext()){
            Member mbr = itmbr.next();
            hmusrmbr.put(mbr.getUser(), mbr);
        }
    
        SWBResourceURL urlupdate = paramRequest.getActionUrl();
        urlupdate.setAction("addmember");
        urlupdate.setMode(SWBResourceURL.Mode_VIEW);
        urlupdate.setCallMethod(SWBResourceURL.Call_CONTENT);      
 
%>

            <form  dojoType="dijit.form.Form" id="form2mbr" name="form2mbr" method="post" action="<%=urlupdate%>">
                <input type="hidden" name="wsid" value="<%=wsid%>"/>
                <label for="usrid">Usuario:</label>
                <select name="usrid" dojoType="dijit.form.FilteringSelect">
                    <option value="-1">Selecciona....</option>
                        <%
                            Iterator<User> itusr = ws.getUserRepository().listUsers();
                            itusr=SWBComparator.sortSermanticObjects(new orderByFullName(),itusr);

                            while (itusr.hasNext()) {
                                User usr = itusr.next();
                                if(hmusrmbr.get(usr)!=null) continue;
                                
                        %>
                        <option value="<%=usr.getId()%>"><%=usr.getFullName()%></option>
                        <%
                            }
                        %>
                </select>
                <label for="mbrtype">Tipo:</label>
                <select name="mbrtype" >
                    <option value="-1">Selecciona....</option>
                    <option value="No miembro">No miembro</option>
                    <option value="Invitado">Invitado</option>
                    <option value="Miembro">Miembro</option>
                    <option value="Coordinador">Coordinador</option>
                    <option value="Administrador">Administrador</option>
                </select>
                <button dojoType="dijit.form.Button" onclick="enviar2();return false;">Agregar</button>
            </form>



<%//=frmgr.renderForm(request)%>
<%
        

    }
%><%!
    class orderByFullName implements Comparator<org.semanticwb.model.User>{
        public int compare(org.semanticwb.model.User u1, org.semanticwb.model.User u2) {
            String n1, n2;
            n1=u1.getFullName();
            n2=u2.getFullName();
            return n1.compareTo(n2);
        }
    }
%>