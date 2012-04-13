<%-- 
Document   : age
Created on : 9/04/2012, 01:40:45 PM
Author     : rene.jara
--%><%@page import="com.infotec.cvi.swb.resources.reports.ReporteIdentificacion"%>
<%@page import="com.infotec.eworkplace.swb.Persona"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    if(paramRequest.getMode().equals(ReporteIdentificacion.Mode_EXPORT)){
        response.setHeader("Content-Disposition", " attachment; filename=\"ReporteIdentificacionEdad_"+ System.currentTimeMillis() + ".xls\";");
    }
            int ageFrom = 0;
            int ageTo = 999;
            try {
                ageFrom = Integer.parseInt(request.getParameter("ageFrom"));
            } catch (Exception ignoredException) {
            }
            try {
                ageTo = Integer.parseInt(request.getParameter("ageTo"));
            } catch (Exception ignoredException) {
            }
            if (ageFrom == 0 && ageTo == 999) {
%>
<script type="text/javascript">
    <!--
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Form");
    dojo.require("dijit.form.ValidationTextBox");
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.NumberSpinner");
    function enviar() {
        //var objd=dijit.byId('form1ri');
        if(validateAge())
        {
            return true;
        }else {
            alert("Datos incompletos");
        }
        return false;
    }
    function validateAge(){
        var ageFrom=dijit.byId('ageFrom').getValue();
        var ageTo=dijit.byId('ageTo').getValue();
        if(ageFrom==isNaN()&&ageTo==isNaN()){
            return false;
        }else{
            return true;
        }
    }
</script>
<div id="icv">
    <div id="icv-data">
        <form id="form1ri" dojoType="dijit.form.Form" class="swbform" action="<%//=url%>" method="post">
            <div class="icv-div-grupo">
                <p class="icv-3col">
                    <label for="ageFrom">de</label>
                    <input type="text" name="ageFrom" id="ageFrom" dojoType="dijit.form.NumberSpinner" value="" maxlength="2"  value="" smallDelta="1" required="false" constraints="{min:14,max:99,places:0}" promptMessage="promptMessage" invalidMessage="invalidMessage" isValid_="return validateAge()"/>
                </p>
                <p class="icv-3col">
                    <label for="ageTo">a</label>
                    <input type="text" name="ageTo" id="ageTo" dojoType="dijit.form.NumberSpinner" value="" maxlength="2"  value="" smallDelta="1" required="false" constraints="{min:14,max:99,places:0}" promptMessage="promptMessage" invalidMessage="invalidMessage" isValid_="return validateAge()"/>
                </p>
                <div class="clearer">&nbsp;</div>
            </div>
            <div class="centro">
                <input type="reset" value="borrar"/>
                <input type="submit" onclick="return enviar()" value="enviar"/>
            </div>
        </form>
    </div>
</div>
<%} else {
                WebSite ws = paramRequest.getWebPage().getWebSite();
                List<String> list = new ArrayList<String>();
                int count = 0;
                Iterator<CV> itcv = CV.ClassMgr.listCVs(ws);
                while (itcv.hasNext()) {
                    CV cv = itcv.next();
//if (UtilsCVI.isCVIDone(cv)) {
                    if (cv.getPersona() != null) {
                        Date nacimiento = cv.getPersona().getNacimiento();
                        if (nacimiento != null) {
                            int age = calculateAge(nacimiento);
                            if (age >= ageFrom && age <= ageTo) {
                                if (cv.getPersona().getOwner() != null) {
                                    list.add(cv.getPersona().getOwner().getId());
                                }
                                count++;
                            }
                        }
                    }
//}
                }
                if (count > 0) {
%>
<div id="icv">
    <div id="icv-data">
        <h2>Edad</h2>
        <span>
            <table>
                <thead>
                    <tr>
                        <th>Edad</th>
                        <th>Personas</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th><%=ageFrom > 0 ? "Desde:" + ageFrom : ""%> <%=ageTo < 999 ? "Hasta:" + ageTo : ""%></th>
                        <td><%=count%></td>
                    </tr>
                </tbody>
            </table>
            <script type="text/javascript">
                function newWin(url){
                    window.open(url,'CVI','menubar=0,location=0,scrollbars=1,width=650,height=600');
                }
            </script>
            <table>
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Edad</th>
                        <th>Detalle</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                            Collections.sort(list, new orderByName(ws));
                            for (String userId : list) {
                                User usrcv = ws.getUserRepository().getUser(userId);
                                Persona persona = Persona.ClassMgr.getPersona(userId, ws);
                                Resource resource = ws.getResource("997");
                                WebPage wpage = ws.getWebPage("ver_CV");
                                SWBResourceURLImp urldet = new SWBResourceURLImp(request, resource, wpage, SWBResourceURL.UrlType_RENDER);
                                urldet.setParameter("id", userId);
                                urldet.setCallMethod(SWBResourceURL.Call_CONTENT);
                    %>
                    <tr>
                        <td>
                            <%=usrcv.getFullName()%>
                        </td>
                        <td>
                            <%=calculateAge(persona.getNacimiento())%>
                        </td>
                        <td><a href="<%=urldet.toString()%>" onclick="javascript:newWin('<%=urldet.toString()%>');return false;" target="_blank">ver</a>
                        </td>
                    </tr>
                    <%
                            }
                    %>
                </tbody>
            </table>
            <%
                    SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteIdentificacion.Mode_EXPORT).setAction(ReporteIdentificacion.Action_REP_AGE);
                    url.setParameter("ageFrom", ageFrom + "");
                    url.setParameter("ageTo", ageTo + "");
                    if (!paramRequest.getMode().equals(ReporteIdentificacion.Mode_EXPORT)) {
            %>
            <div><a href="<%=url%>" target="_blank">exportar a Excel</a></div>
            <%
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
<%
              }
            }
%>
<%!
    private static int calculateAge(Date birthday) {
        java.util.Calendar cal = new GregorianCalendar();
        cal.setTime(birthday);
        java.util.Calendar now = new GregorianCalendar();
        int res = now.get(java.util.Calendar.YEAR) - cal.get(java.util.Calendar.YEAR);
        if ((cal.get(java.util.Calendar.MONTH) > now.get(java.util.Calendar.MONTH))
                || (cal.get(java.util.Calendar.MONTH) == now.get(java.util.Calendar.MONTH)
                && cal.get(java.util.Calendar.DAY_OF_MONTH) > now.get(java.util.Calendar.DAY_OF_MONTH))) {
            res--;
        }
        return res;
    }

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
