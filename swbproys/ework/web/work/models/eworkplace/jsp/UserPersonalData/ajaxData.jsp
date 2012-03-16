<%-- 
Document   : ajaxData
Created on : 6/03/2012, 06:36:23 PM
Author     : rene.jara
--%><%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Iterator"
        %><%@page import="com.infotec.cvi.swb.*"
        %><%@page import="org.semanticwb.model.*"
%><%@page contentType="text/html" pageEncoding="ISO-8859-1"%><jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/><%
            WebSite ws = paramRequest.getWebPage().getWebSite();
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            String zip = request.getParameter("zip");
            String col = request.getParameter("col");
//String mun = request.getParameter("mun");
//String sta = request.getParameter("sta");
            String id = request.getParameter("id");
            if (zip != null && !zip.equals("")) {
                if (CP.ClassMgr.getCP(zip, ws) != null) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } else if (col != null && !col.equals("")) {
                CP cp = CP.ClassMgr.getCP(col, ws);
                Municipio municipio = null;
                Iterator<Colonia> itco = Colonia.ClassMgr.listColoniaByCpInv(cp, ws);
%><select name="addrCol" id="addrCol" dojoType="dijit.form.FilteringSelect" required="true" promptMessage="<%=paramRequest.getLocaleString("promptMsgAddrCol")%>">
<option value="" <%=id == null || id.equals("") ? "selected" : ""%>><%=SWBUtils.TEXT.encodeExtendedCharacters(paramRequest.getLocaleString("promptMsgAddrCol"))%></option>
<%
                while (itco.hasNext()) {
                    Colonia colonia = itco.next();
    %><option value="<%=colonia.getId()%>" <%=colonia.getId().equals(id) ? "selected" : ""%>><%=SWBUtils.TEXT.encodeExtendedCharacters(colonia.getTitle())%></option>
    <%
                }
    %></select>|<%
                Iterator<Municipio> itmu = Municipio.ClassMgr.listMunicipioByCP(cp, ws);
                if (itmu.hasNext()) {
                    municipio = itmu.next();
    %><input type="hidden" name="addrMun" id="addrMun" value="<%=municipio.getId()%>"/>
<input type="text" name="addrMunro" id="addrMunne" dojoType="dijit.form.ValidationTextBox" value="<%=SWBUtils.TEXT.encodeExtendedCharacters(municipio.getTitle())%>" maxlength="5"  promptMessage_="<%=paramRequest.getLocaleString("promptMsgAddrMun")%>" invalidMessage_="<%=paramRequest.getLocaleString("lblAddrZipFault")%>" readonly="true"  trim="true"/>|<%
                }
                Iterator<EntidadFederativa> ites = EntidadFederativa.ClassMgr.listEntidadFederativaByMunicipios(municipio, ws);
                if (ites.hasNext()) {
                    EntidadFederativa estado = ites.next();
%><input type="hidden" name="addrState" id="addrState" value="<%=estado.getId()%>"/>
<input type="text" name="addrStatero" id="addrStatene" dojoType="dijit.form.ValidationTextBox" value="<%=SWBUtils.TEXT.encodeExtendedCharacters(estado.getTitle())%>" maxlength="5"  promptMessage_="<%=paramRequest.getLocaleString("promptMsgAddrState")%>" invalidMessage_="<%=paramRequest.getLocaleString("lblAddrStateFault")%>" readonly="true"  trim="true"/><%
                }
            }
%>