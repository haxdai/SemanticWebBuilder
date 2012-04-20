<%-- 
Document   : ajax
Created on : 17/04/2012, 06:36:23 PM
Author     : rene.jara
--%><%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Iterator"
        %><%@page import="com.infotec.cvi.swb.*"
        %><%@page import="org.semanticwb.model.*"
%><%@page contentType="text/html" pageEncoding="ISO-8859-1"%><jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/><%
            WebSite ws = paramRequest.getWebPage().getWebSite();
            User user=paramRequest.getUser();
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
//            String zip = request.getParameter("zip");
//            String col = request.getParameter("col");
//            String mun = request.getParameter("mun");
            String edo = request.getParameter("edo");
            String dis = request.getParameter("dis");
            String area = request.getParameter("area");
//            String id = request.getParameter("id");
            if (edo != null && !edo.equals("")) {
                EntidadFederativa entidadFederativa=EntidadFederativa.ClassMgr.getEntidadFederativa(edo, ws);
                Municipio municipio = null;
                Iterator<Municipio> itmu = SWBComparator.sortByDisplayName(Municipio.ClassMgr.listMunicipioByEntidadInv(entidadFederativa, ws),user.getLanguage());
%><select name="mun" id="mun" dojoType="dijit.form.FilteringSelect" required="true">
<option value="" selected>selecciona</option>
<%
                while (itmu.hasNext()) {
                    municipio = itmu.next();
    %><option value="<%=municipio.getId()%>"><%=SWBUtils.TEXT.encodeExtendedCharacters(municipio.getTitle())%></option>
    <%
               }
    %></select><%
            }else if (dis != null && !dis.equals("")) {
                TipoCarrera tipoCarrera=TipoCarrera.ClassMgr.getTipoCarrera(dis,ws);
                if(tipoCarrera!=null){
                Iterator<AreaCarrera> itac = SWBComparator.sortByDisplayName(AreaCarrera.ClassMgr.listAreaCarreraByTipoCarreraInv(tipoCarrera,ws),user.getLanguage());
%><select name="area" id="area" dojoType="dijit.form.FilteringSelect" required="false" onclick="loadCar()">
<option value="" selected>selecciona</option>
<%
                while (itac.hasNext()) {
                    AreaCarrera areaCarrera = itac.next();
    %><option value="<%=areaCarrera.getId()%>"><%=areaCarrera.getId()%>-<%=SWBUtils.TEXT.encodeExtendedCharacters(areaCarrera.getTitle())%></option>
    <%
               }
    %></select><%
            }
        }else if (area != null && !area.equals("")) {
                AreaCarrera areaCarrera=AreaCarrera.ClassMgr.getAreaCarrera(area,ws);
                if(areaCarrera!=null){
            Iterator<Carrera> itca = SWBComparator.sortByDisplayName(Carrera.ClassMgr.listCarreraByAreaCarrera(areaCarrera,ws),user.getLanguage());
%><select name="car" id="car" dojoType="dijit.form.FilteringSelect" required="true">
<option value="" selected>selecciona</option>
<%
                while (itca.hasNext()) {
                    Carrera carrera = itca.next();
    %><option value="<%=carrera.getId()%>"><%=carrera.getId()%>-<%=SWBUtils.TEXT.encodeExtendedCharacters(carrera.getTitle())%></option>
    <%
               }
    %></select><%
            }
        }
%>