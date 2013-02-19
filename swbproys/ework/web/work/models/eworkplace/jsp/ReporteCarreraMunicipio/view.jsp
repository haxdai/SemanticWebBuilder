<%-- 
Document   : view
Created on : 17/04/2012, 01:14:07 PM
Author     : rene.jara
--%><%@page import="com.infotec.cvi.swb.resources.reports.ReporteCarreraMunicipio"%>
<%@page import="com.infotec.cvi.swb.resources.reports.ReporteExperienciaSector"%>
<%@page import="com.infotec.eworkplace.swb.*"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
            WebSite ws = paramRequest.getWebPage().getWebSite();
            Resource base = paramRequest.getResourceBase();
            String strMun = request.getParameter("mun");
//String strEdo = request.getParameter("edo");
//String strDis = request.getParameter("dis");
//String strArea = request.getParameter("area");
            String strCar = request.getParameter("car");
            String strDet = request.getParameter("det");
//            if ((strMun == null || strMun.equals("") || strEdo == null || strEdo.equals(""))&&
//            (strDis == null || strDis.equals("") || strArea == null || strArea.equals("")|| strCar == null || strCar.equals(""))) {
            if ((strMun == null || strMun.equals("")) && (strCar == null || strCar.equals(""))) {
                String ajaxUrl = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteCarreraMunicipio.Mode_AJAX).toString();
%>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    dojo.require("dojo.data.ItemFileReadStore");
    function enviar() {
        var objd=dijit.byId('form1cm');
        if(objd.validate()&&validData()){
            return true;
        }else {
            alert("Datos incompletos");
        }
        return false;
    }
    function loadMun(){
        //console.log("loadMun");
        var edov=dijit.byId('edo').getValue();
        if(typeof edov == "undefined"){
            //console.log("edov=undefined");
        }
        getHtml("<%=ajaxUrl%>?edo="+edov, "spMun",true, true);
    }
    function validData(){
        var objDis=dijit.byId('sel_Tipo<%=base.getId()%>');
        var objArea=dijit.byId('sel_Area<%=base.getId()%>');
        var objCar=dijit.byId('sel_Carrera<%=base.getId()%>');
        var objEdo=dijit.byId('edo');
        var objMun=dijit.byId('mun');

        if((!isEmpty(objDis)&&!isEmpty(objArea)&&!isEmpty(objCar))||
            (!isEmpty(objEdo)&&!isEmpty(objMun))){
            return true;
        }else{
            return false;
        }

    }
    function isEmpty(obj){
        if(typeof obj != "undefined"&&
            obj!=null &&
            obj!=''){
            return false;
        }else{
            return true;
        }
    }
    /*
function loadArea(){
console.log("loadArea");
var disv=dijit.byId('dis').getValue();
if(typeof disv == "undefined"){
console.log("disv=undefined");
}
getHtml("<%//=ajaxUrl%>?dis="+disv, "spArea",true, true);
}
function loadCar(){
console.log("loadCar");
var areav=dijit.byId('area').getValue();
if(typeof areav == "undefined"){
console.log("areav=undefined");
}
console.log("areav:"+areav);
getHtml("<%//=ajaxUrl%>?area="+areav, "spCar",true, true);
}
     */
    -->
</script>
<div id="icv">
    <div id="icv-data">
        <form id="form1cm" dojoType="dijit.form.Form" class="swbform" action="<%//=url%>" method="post">
            <!--div class="icv-div-grupo">
            <p class="icv-3col">
            <label for="di">Disciplina</label>
            <select name="dis" id="dis" dojoType="dijit.form.FilteringSelect" required="true" onchange="loadArea()">
            <option value="" selected="selected">Seleccione...</option>
            <%
            //Iterator<TipoCarrera> ittc = TipoCarrera.ClassMgr.listTipoCarreras(ws);
            //while (ittc.hasNext()) {
            //TipoCarrera tc = ittc.next();

            %>
            <option value="<%//=//tc.getId()%>"><%//=//tc.getTitle()%></option>
            <%
            //}
            %>
            </select>
            </p>
            <p class="icv-3col">
            <label for="area">Área</label>
            <span id="spArea">
            <input type="text" name="area" id="area" value="" readonly="true"  dojoType="dijit.form.ValidationTextBox" />
            </span>
            </p>  <p class="icv-3col">
            <label for="car">Carrera</label>
            <span id="spCar">
            <input type="text" name="car" id="car" value="" readonly="true"  dojoType="dijit.form.ValidationTextBox" />
            </span>
            </p>
            <div class="clearer">&nbsp;</div>
            </div-->
            <div class="icv-div-grupo">
                <%
                    SWBResourceURL url = paramRequest.getRenderUrl();
                    url.setCallMethod(SWBResourceURL.Call_DIRECT);
                %>
                <div dojoType="dojo.data.ItemFileReadStore" jsId="tipoCarreraStore<%=base.getId()%>" url="<%=url.setMode("mod_tipo")%>"></div>
                <div dojoType="dojo.data.ItemFileReadStore" jsId="areaCarreraStore<%=base.getId()%>" url="<%=url.setMode("mod_area")%>"></div>
                <div dojoType="dojo.data.ItemFileReadStore" jsId="carreraStore<%=base.getId()%>" url="<%=url.setMode("mod_carrera")%>"></div>
                <p class="icv-3col">
                    <label for="dis">Disciplina</label>
                    <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" required="false" store="tipoCarreraStore<%=base.getId()%>" name="dis" id="sel_Tipo<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').query.tipo = this.value || '*';" />
                </p>
                <p class="icv-3col">
                    <label for="area">Area</label>
                    <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" required="false" store="areaCarreraStore<%=base.getId()%>" name="area" id="sel_Area<%=base.getId()%>" onChange="dijit.byId('sel_Carrera<%=base.getId()%>').query.area = this.value || '*'; dijit.byId('sel_Tipo<%=base.getId()%>').attr('value', (dijit.byId('sel_Area<%=base.getId()%>').item || {tipo: ''}).tipo);" />          <!-- dijit.byId('sel_Carrera<%//=base.getId()%>').attr('value',''); -->
                </p>
                <p class="icv-3col">
                    <label for="car">Carrera</label>
                    <input dojoType="dijit.form.FilteringSelect" value="" autoComplete="true" required="false" store="carreraStore<%=base.getId()%>" name="car" id="sel_Carrera<%=base.getId()%>" onChange="dijit.byId('sel_Area<%=base.getId()%>').attr('value', (dijit.byId('sel_Carrera<%=base.getId()%>').item || {area: ''}).area);" />
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="edo">Estado</label>
                    <select name="edo" id="edo" dojoType="dijit.form.FilteringSelect" required="false" onchange="loadMun()">
                        <option value="" selected="selected">Seleccione...</option>
                        <%
                            Iterator<EntidadFederativa> ites = EntidadFederativa.ClassMgr.listEntidadFederativas(ws);
                            while (ites.hasNext()) {
                                EntidadFederativa estado = ites.next();
                        %>
                        <option value="<%=estado.getId()%>"><%=estado.getTitle()%></option>
                        <%
                            }
                        %>
                    </select>
                </p>
                <p class="icv-3col">
                    <label for="mun">Municipio/Delegación</label>
                    <span id="spMun">
                        <input type="text" name="mun" id="mun" value="" readonly="true"  dojoType="dijit.form.ValidationTextBox" />
                    </span>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="centro">
                <input type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" value="Regresar"/>
                <input type="reset" value="Borrar"/>
                <input type="submit" onclick="return enviar()" value="Enviar"/>
            </div>
        </form>
    </div>
</div>
<%
} else {
    int count = 0;
    int all = 0;
    List<String> list = new ArrayList<String>();
    Iterator<CV> itcv = CV.ClassMgr.listCVs(ws);
    if (strCar != null && !strCar.equals("")) {
        while (itcv.hasNext()) {
            CV cv = itcv.next();
            all++;
//if (UtilsCVI.isCVIDone(cv)) {
            if (cv.getAcademia() != null) {
                Academia academia = cv.getAcademia();
                Iterator<GradoAcademico> itga = academia.listGradoAcademicos();
                while (itga.hasNext()) {
                    GradoAcademico gradoAcademico = itga.next();
                    if (gradoAcademico.getCarrera() != null && gradoAcademico.getCarrera().getId().equals(strCar)) {
                        if (strMun != null && !strMun.equals("")) {
                            if (cv.getPersona() != null
                                    && cv.getPersona().getDomicilio() != null
                                    && cv.getPersona().getDomicilio().getMunicipio() != null
                                    && cv.getPersona().getDomicilio().getMunicipio().getId().equals(strMun)) {
                                count++;
                                if (cv.getPersona() != null && cv.getPersona().getOwner() != null) {
                                    list.add(cv.getPersona().getOwner().getId());
                                }
                                break;
                            }
                        } else {
                            count++;
                            if (cv.getPersona() != null && cv.getPersona().getOwner() != null) {
                                list.add(cv.getPersona().getOwner().getId());
                            }
                            break;
                        }
                    }
                }
            }
//}
        }
    }
    if (all == 0 && strMun != null && !strMun.equals("")) {
        itcv = CV.ClassMgr.listCVs(ws);
        while (itcv.hasNext()) {
            CV cv = itcv.next();
            all++;
//if (UtilsCVI.isCVIDone(cv)) {
            if (cv.getPersona() != null
                    && cv.getPersona().getDomicilio() != null
                    && cv.getPersona().getDomicilio().getMunicipio() != null
                    && cv.getPersona().getDomicilio().getMunicipio().getId().equals(strMun)) {
                count++;
                if (cv.getPersona() != null && cv.getPersona().getOwner() != null) {
                    list.add(cv.getPersona().getOwner().getId());
                }
            }
//}
        }
    }
    if (count > 0) {
%>
<script type="text/javascript">
    function newWin(url){
        window.open(url,'CVI','menubar=0,location=0,scrollbars=1,width=650,height=600');
    }
</script>
<div id="icv">
    <div id="icv-data">
        <span>
<%
   if (strDet == null || strDet.equals("")) {
%>
            <table>
                <caption>
                    Carrera Municipio
                </caption>
                <thead>
                    <tr>
                        <th><%=strCar != null && !strCar.equals("") ? "Carrera" : ""%> <%=strMun != null && !strMun.equals("") ? "Municipio" : ""%></th>
                        <th>Encontrados</th>
                        <%
                                if (!paramRequest.getMode().equals(ReporteCarreraMunicipio.Mode_EXPORT)) {
                        %>
                        <th>Detalle</th>
                        <%        }
                        %>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=strCar != null && !strCar.equals("") ? Carrera.ClassMgr.getCarrera(strCar, ws).getTitle() : ""%> <%=strMun != null && !strMun.equals("") ? Municipio.ClassMgr.getMunicipio(strMun, ws).getTitle() : ""%></td>
                        <td><%=count%></td>
                        <%
                                if (!paramRequest.getMode().equals(ReporteCarreraMunicipio.Mode_EXPORT)) {
                                    SWBResourceURL url = paramRequest.getRenderUrl();
                                    url.setParameter("mun", strMun);
                                    url.setParameter("car", strCar);
                                    url.setParameter("det", "det");
                        %>
                        <td>
                            <a href="<%=url.toString()%>">ver</a>
                        </td>
                        <%
                                }
                        %>
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td><%=all%></td>
                        <%
                                if (!paramRequest.getMode().equals(ReporteCarreraMunicipio.Mode_EXPORT)) {
                        %>
                        <td>&nbsp;</td>
                        <%        }
                        %>
                    </tr>
                </tbody>
            </table>
            <%
                    SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteCarreraMunicipio.Mode_EXPORT);
                    url.setParameter("mun", strMun);
                    url.setParameter("car", strCar);
                    if (!paramRequest.getMode().equals(ReporteCarreraMunicipio.Mode_EXPORT)) {
            %>
            <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
            <button onclick="javascript:location='<%=url%>'; return false;" >Guardar Excel</button>
            <%
                    }
                } else {
            %>
            <table>
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <%
                                if (!paramRequest.getMode().equals(ReporteCarreraMunicipio.Mode_EXPORT)) {
                        %>
                        <th>Detalle</th>
                        <%        }
                        %>
                    </tr>
                </thead>
                <tbody>
                    <%
                            Collections.sort(list, new orderByName(ws));
                            for (String userId : list) {
                                User usrcv = ws.getUserRepository().getUser(userId);
                                Persona persona = Persona.ClassMgr.getPersona(userId, ws);

                    %>
                    <tr>
                        <td>
                            <%=usrcv.getFullName()%>
                        </td>
                        <%
                            if (!paramRequest.getMode().equals(ReporteCarreraMunicipio.Mode_EXPORT)) {
                                //Resource resource = ws.getResource("997");
                                WebPage wpage = ws.getWebPage("ver_CV");
                                String strUrl=wpage.getUrl()+"?id="+userId;
                                //SWBResourceURLImp urldet = new SWBResourceURLImp(request, resource, wpage, SWBResourceURL.UrlType_RENDER);
                                //urldet.setParameter("id", userId);
                                //urldet.setCallMethod(SWBResourceURL.Call_CONTENT);
                        %>
                        <td>
                            <a href="<%=strUrl%>" onclick="javascript:newWin('<%=strUrl%>');return false;" target="_blank">ver</a>
                        </td>
                        <%
                            }
                        %>
                    </tr>
                    <%
                            }
                    %>
                </tbody>
            </table>
            <%
                    SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteCarreraMunicipio.Mode_EXPORT);
                    url.setParameter("mun", strMun);
                    url.setParameter("car", strCar);
                    url.setParameter("det", "det");
                    if (!paramRequest.getMode().equals(ReporteCarreraMunicipio.Mode_EXPORT)) {
            %>
            <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
            <button onclick="javascript:location='<%=url%>'; return false;" >Guardar Excel</button>
            <%
                    }
                }
            %>
        </span>
    </div>
</div>
<%
} else {
%>
<div id="icv">
    <div id="icv-data">
        <span>No se encontraron registros</span>
    </div>
</div>
<%                }
            }
%>
<%!
    class orderByName implements Comparator<String> {

        public WebSite ws;

        public orderByName(WebSite ws) {
            this.ws = ws;
        }

        public int compare(String id1, String id2) {
            String n1, n2;
            n1 = ws.getUserRepository().getUser(id1).getFullName();
            n2 = ws.getUserRepository().getUser(id2).getFullName();
            return n1.compareTo(n2);
        }
    }
%>