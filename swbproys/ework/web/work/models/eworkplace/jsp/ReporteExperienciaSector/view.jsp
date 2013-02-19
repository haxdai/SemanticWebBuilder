<%-- 
    Document   : view
    Created on : 16/04/2012, 01:14:07 PM
    Author     : rene.jara
--%><%@page import="com.infotec.cvi.swb.resources.reports.ReporteExperienciaSector"%>
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
            String strSector = request.getParameter("sector");
            String strDet = request.getParameter("det");
//strSector ="12";
            if (strSector == null || strSector.equals("")) {
%>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.FilteringSelect");
    function enviar() {
        var objd=dijit.byId('form1re');
        if(objd.validate())
        {
            return true;
        }else {
            alert("Datos incompletos");
        }
        return false;
    }
    -->
</script>
<div id="icv">
    <div id="icv-data">
        <form id="form1re" dojoType="dijit.form.Form" class="swbform" action="<%//=url%>" method="post">
            <div class="icv-div-grupo">
  <p class="icv-3col">
   <label for="sector">Sector</label>
   <select name="sector" id="sector" dojoType="dijit.form.FilteringSelect" required="true">
    <option value="" selected="selected">Seleccione...</option>
<%
        Iterator<Sector> sectors = Sector.ClassMgr.listSectors(ws);
        while(sectors.hasNext()) {
        Sector sector = sectors.next();
%>
            <option value="<%=sector.getId()%>"><%=sector.getTitle()%></option>
<%
        }
%>
   </select>
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
    int all=0;
    List<String> list = new ArrayList<String>();
    
    Iterator<CV> itcv = CV.ClassMgr.listCVs(ws);
    while (itcv.hasNext()) {
        CV cv = itcv.next();
        all++;
//if (UtilsCVI.isCVIDone(cv)) {
        if (cv.listExperienciaLaborals()!= null) {
            Iterator<ExperienciaLaboral> itel=cv.listExperienciaLaborals();
            while(itel.hasNext()){
                ExperienciaLaboral el=itel.next();
                if(el.getSector()!=null&&el.getSector().getId().equals(strSector)){
                    count++;
                    if(cv.getPersona()!=null&&cv.getPersona().getOwner()!=null){

                        list.add(cv.getPersona().getOwner().getId());
                     }
                    break;
                }
            }
        }
//}
    }

    if (count > 0)   {
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
                    Experiencia en sector
                </caption>
                <thead>
                    <tr>
                        <th>Sector</th>
                        <th>Encontrados</th>
                        <%
                            if (!paramRequest.getMode().equals(ReporteExperienciaSector.Mode_EXPORT)) {
                        %>
                        <th>Detalle</th>
                        <%    }
                        %>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=Sector.ClassMgr.getSector(strSector, ws).getTitle()%></td>
                        <td><%=count%></td>
                        <%
                            if (!paramRequest.getMode().equals(ReporteExperienciaSector.Mode_EXPORT)) {
                                SWBResourceURL url = paramRequest.getRenderUrl();
                                url.setParameter("sector", strSector);
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
                            if (!paramRequest.getMode().equals(ReporteExperienciaSector.Mode_EXPORT)) {
                        %>
                        <td>&nbsp;</td>
                        <%    }
                        %>
                    </tr>
                </tbody>
            </table>
            <%
                SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteExperienciaSector.Mode_EXPORT);
                url.setParameter("sector", strSector);
                if (!paramRequest.getMode().equals(ReporteExperienciaSector.Mode_EXPORT)) {
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
                            if (!paramRequest.getMode().equals(ReporteExperienciaSector.Mode_EXPORT)) {
                        %>
                        <th>Detalle</th>
                        <%    }
                        %>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Collections.sort(list, new orderByName(ws));
                        for (String userId : list) {
                            User usrcv = ws.getUserRepository().getUser(userId);
                            Persona persona = Persona.ClassMgr.getPersona(userId, ws);
                            //Resource resource = ws.getResource("997");
                            WebPage wpage = ws.getWebPage("ver_CV");
                            String strUrl=wpage.getUrl()+"?id="+userId;
                            //SWBResourceURLImp urldet = new SWBResourceURLImp(request, resource, wpage, SWBResourceURL.UrlType_RENDER);
                            //urldet.setParameter("id", userId);
                            //urldet.setCallMethod(SWBResourceURL.Call_CONTENT);
                    %>
                    <tr>
                        <td>
                            <%=usrcv.getFullName()%>
                        </td>
                        <%
                            if (!paramRequest.getMode().equals(ReporteExperienciaSector.Mode_EXPORT)) {
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
                SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteExperienciaSector.Mode_EXPORT);
                url.setParameter("sector", strSector);
                url.setParameter("det", "det");
                if (!paramRequest.getMode().equals(ReporteExperienciaSector.Mode_EXPORT)) {
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

