<%-- 
Document   : nationality
Created on : 9/04/2012, 01:41:12 PM
Author     : rene.jara
--%><%@page import="com.infotec.cvi.swb.resources.reports.ReporteIdentificacion"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
            WebSite ws = paramRequest.getWebPage().getWebSite();
            Iterator<CV> itcv = CV.ClassMgr.listCVs(ws);
            HashMap<String, Integer> hm = new HashMap<String, Integer>();
            HashMap<String, List> hmList = new HashMap<String, List>();
            while (itcv.hasNext()) {
                CV cv = itcv.next();
//if (UtilsCVI.isCVIDone(cv)) {
                if (cv.getPersona() != null && cv.getPersona().getNacionalidad() != null) {
                    Country country = cv.getPersona().getNacionalidad();
                    int count;

                    String key = country.getTitle();
                    if (hm.get(key) != null) {
                        count = hm.get(key);
                        count++;
                        hm.put(key, count);
                        if (cv.getPersona().getOwner() != null) {
                            if (hmList.get(key) != null) {
                                List<String> list = hmList.get(key);
                                list.add(cv.getPersona().getId());
                            } else {
                                List<String> list = new ArrayList<String>();
                                list.add(cv.getPersona().getId());
                                hmList.put(key, list);
                            }
                        }
                    } else {
                        hm.put(key, new Integer(1));
                        if (cv.getPersona().getOwner() != null) {
                            List<String> list = new ArrayList<String>();
                            list.add(cv.getPersona().getId());
                            hmList.put(key, list);
                        }
                    }
                }
//}
            }
            if (!hm.isEmpty()) {
%>
<div id="icv">
    <div id="icv-data">
        <h2>País de nacimiento</h2>
        <span>
            <table>
                <thead>
                    <tr>
                        <th>Nacionalidad</th>
                        <th>Personas</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        if (!hm.isEmpty()) {
                            Iterator<String> itres = hm.keySet().iterator();
                            while (itres.hasNext()) {
                                String key = itres.next();
                    //Country country = Country.ClassMgr.getCountry(key, ws);
                                int count = hm.get(key);
                    %>
                    <tr>
                        <th><%=key%></th>
                        <td><%=count%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
            <table>
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Detalle</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        TreeMap<String, List> sortedList = new TreeMap();
                        sortedList.putAll(hmList);
                        Iterator<String> itList = sortedList.keySet().iterator();
                        while (itList.hasNext()) {
                            String key = itList.next();
                            if (!key.equals("México")) {
                    %>
                    <tr>
                        <th colspan="2">
                            <%=key%>
                        </th>
                    </tr>
                    <%
                        Collections.sort(hmList.get(key), new orderByName(ws));
                        List<String> list = hmList.get(key);
                        for (String userId : list) {
                            User usrcv = ws.getUserRepository().getUser(userId);
                            Resource resource = ws.getResource("997");
                            WebPage wpage = ws.getWebPage("ver_CV");
                            SWBResourceURLImp urldet = new SWBResourceURLImp(request, resource, wpage, SWBResourceURL.UrlType_RENDER);
                            urldet.setParameter("id", usrcv.getId());
                            urldet.setCallMethod(SWBResourceURL.Call_CONTENT);
                    %>
                    <tr>
                        <td>
                            <%=usrcv.getFullName()%>
                        </td>
                        <td><a href="<%=urldet.toString()%>"  target="_blank">ver</a>
                        </td>
                    </tr>
                    <%
                                }
                            }
                        }
                    %>
                </tbody>
            </table>
            <%
                SWBResourceURL url = paramRequest.getRenderUrl().setCallMethod(SWBResourceURL.Call_DIRECT).setMode(ReporteIdentificacion.Mode_EXPORT).setAction(ReporteIdentificacion.Action_REP_NATIONATITY);
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