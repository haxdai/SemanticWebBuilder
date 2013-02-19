<%-- 
Document   : gender
Created on : 9/04/2012, 01:40:33 PM
Author     : rene.jara
--%><%@page import="org.semanticwb.SWBException"%><%@page import="org.semanticwb.portal.api.*"%>
<%@page import="com.infotec.cvi.swb.resources.reports.ReporteIdentificacion"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/><%
            WebSite ws = paramRequest.getWebPage().getWebSite();
            int femenino = 0;
            int masculino = 0;
            Iterator<CV> itcv = CV.ClassMgr.listCVs(ws);
            while (itcv.hasNext()) {
                CV cv = itcv.next();
//if (UtilsCVI.isCVIDone(cv)) {
                if (cv.getPersona() != null) {
                    if (cv.getPersona().isGenero()) {
                        femenino++;
                    } else {
                        masculino++;
                    }
                }
//}
            }
            if (femenino > 0 || masculino > 0) {
%>
<div id="icv">
    <div id="icv-data">
        <span>
            <table>
                <caption>
                    Genero
                </caption>
                <thead>
                    <tr>
                        <th>Genero</th>
                        <th>Personas</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>Femenino</th>
                        <td><%=femenino%></td>
                    </tr>
                    <tr>
                        <th>Masculino</th>
                        <td><%=masculino%></td>
                    </tr>
                </tbody>
            </table>
        <%
            SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteIdentificacion.Mode_EXPORT).setAction(ReporteIdentificacion.Action_REP_GENDER);
            if (!paramRequest.getMode().equals(ReporteIdentificacion.Mode_EXPORT)) {
        %>
            <button onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
            <button onclick="javascript:location='<%=url%>'; return false;" >Guardar Excel</button>
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
<%            }
%>