<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURLImp"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="com.infotec.cvi.swb.*"%>
<%@page import="com.infotec.cvi.swb.util.UtilsCVI"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<%
    WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;

    Resource base = paramRequest.getResourceBase();
    String strNumItems = base.getAttribute("numPageItems", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String action = paramRequest.getAction();
    String MODE_EXPORT = "export";
    String export = request.getParameter("export");
    if (null == export) {
        export = "";
    }

    int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (request.getParameter("alertmsg") != null) {
        String strMsg = request.getParameter("alertmsg");
        strMsg = strMsg.replace("<br/>", "\\n\\r");
%>
<script type="text/javascript">
    alert('<%=strMsg%>'); 
</script>
<%
    }
%>
<div >  
    <div id="icv">
        <div id="icv-data">
            <div><span>
                    <%
                        //if(action==null) {
                        if (SWBResourceURL.Action_EDIT.equals(action)) {
                            String wptitle = "Habilidades";

                            TreeMap<String, Integer> ggg = new TreeMap();
                            Iterator<TipoTalento> types = TipoTalento.ClassMgr.listTipoTalentos(wsite);
                            while (types.hasNext()) {
                                TipoTalento tipo = types.next();
                                if (tipo == null) {
                                    continue;
                                }
                                Iterator<AreaTalento> areas = AreaTalento.ClassMgr.listAreaTalentoByTipoAreaTalento(tipo, wsite);
                                while (areas.hasNext()) {
                                    AreaTalento area = areas.next();
                                    if (area == null||(area!=null&&area.getCreator()==null)) {
                                        continue;
                                    }
                                    CV cv = CV.ClassMgr.getCV(area.getCreator().getId(), wsite);
                                    if (!UtilsCVI.isCVIDone(cv)) {
                                        continue;
                                    }
                                    if (ggg.containsKey(tipo.getId())) {
                                        ggg.put(tipo.getId(), ggg.get(tipo.getId()) + 1);
                                    } else {
                                        ggg.put(tipo.getId(), 1);
                                    }
                                }
                            }
                    %>
                    <table>
                        <caption><%=wptitle%></caption>
                        <thead>
                            <%
                                if (ggg.isEmpty()) {
                                    out.println("<tr><th colspan=\"2\">No se encontraron registros</th></tr></thead>");
                                } else {
                            %>
                            <tr>
                                <th>Tipo de habilidad</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                //SWBResourceURL url = paramRequest.getRenderUrl().setParameter("act","skl");
                                SWBResourceURL url = paramRequest.getRenderUrl().setAction("skl");
                                String key;
                                int v;
                                TipoTalento tipoTalento;
                                Iterator<String> keys = ggg.keySet().iterator();
                                while (keys.hasNext()) {
                                    key = keys.next();
                                    tipoTalento = TipoTalento.ClassMgr.getTipoTalento(key, wsite);
                                    v = ggg.get(key);
                                    url.setParameter("eid", key);
                            %>
                            <tr>
                                <td>
                                    <%
                                        if (!export.equals("excel")) {
                                    %>
                                    <a href="<%=url%>" title="Ver detalle"><%=tipoTalento.getTitle()%></a>
                                    <%
                                        } else {
                                            out.print(tipoTalento.getTitle());
                                        }
                                    %>    
                                </td>
                                <td><%=v%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                        <tfoot></tfoot>
                    </table>
                    <%
                        if (!export.equals("excel")) { //&& (acum > 0 || acumno > 0)
                            SWBResourceURL urlExport = paramRequest.getRenderUrl();
                            urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlExport.setMode(MODE_EXPORT);
                            urlExport.setAction(action);
                    %>
                    <form action="<%=urlExport.toString()%>" method="post">
                        <input type="hidden" name="export" value="excel"/>
                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
                        <button type="submit" >Guardar Excel</button>
                    </form>
                    <%
                            }
                        }
                    } else if ("skl".equals(action)) {
                        //suponiendo que estoy en granularidad media
                        TreeMap<String, Integer> mmm = new TreeMap();
                        String tipoTalentoId = SWBUtils.TEXT.decode(request.getParameter("eid"), "UTF-8");
                        TipoTalento tipo = TipoTalento.ClassMgr.getTipoTalento(tipoTalentoId, wsite);
                        if (tipo != null) {
                            String wptitle = tipo.getTitle();
                            Iterator<AreaTalento> areas = AreaTalento.ClassMgr.listAreaTalentoByTipoAreaTalento(tipo, wsite);
                            while (areas.hasNext()) {
                                AreaTalento area = areas.next();
                                if (area == null||(area!=null&&area.getCreator()==null)) {
                                    continue;
                                }
                                CV cv = CV.ClassMgr.getCV(area.getCreator().getId(), wsite);
                                if (!UtilsCVI.isCVIDone(cv)) {
                                    continue;
                                }
                                if (mmm.containsKey(area.getHabilidad().getId())) {
                                    mmm.put(area.getHabilidad().getId(), mmm.get(area.getHabilidad().getId()) + 1);
                                } else {
                                    mmm.put(area.getHabilidad().getId(), 1);
                                }
                            }
                    %>
                    <table>
                        <caption><%=wptitle%></caption>
                        <thead>
                            <%
                                if (mmm.isEmpty()) {
                                    out.println("<tr><th colspan=\"2\">No se encontraron registros</th></tr></thead>");
                                } else {
                            %>
                            <tr>
                                <th>Habilidad o expertise</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                SWBResourceURL url = paramRequest.getRenderUrl().setAction("dtl");
                                String key;
                                int v;
                                Habilidad habilidad;
                                Iterator<String> keys = mmm.keySet().iterator();
                                while (keys.hasNext()) {
                                    key = keys.next();
                                    v = mmm.get(key);
                                    habilidad = Habilidad.ClassMgr.getHabilidad(key, wsite);
                                    url.setParameter("sid", key);
                            %>
                            <tr>
                                <td>
                                    <%
                                        if (!export.equals("excel")) {
                                    %>
                                    <a href="<%=url%>" title="Ver detalle"><%=habilidad.getTitle()%></a>
                                    <%
                                        } else {
                                            out.print(habilidad.getTitle());
                                        }
                                    %>   
                                </td>    
                                <td><%=v%></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                        <tfoot></tfoot>
                    </table>
                    <%
                        if (!export.equals("excel")) { //&& (acum > 0 || acumno > 0)
                            SWBResourceURL urlExport = paramRequest.getRenderUrl();
                            urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlExport.setMode(MODE_EXPORT);
                            urlExport.setAction(action);
                    %>
                    <form action="<%=urlExport.toString()%>" method="post">
                        <input type="hidden" name="export" value="excel"/>
                        <input type="hidden" name="eid" value="<%=tipoTalentoId%>"/>
                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
                        <button type="submit" >Guardar Excel</button>
                    </form>
                    <%
                                }

                            }
                        }
                    } else if ("dtl".equals(action)) {
                        //suponiendo que estoy en granularidad pequena
                        TreeMap<String, User> ppp = new TreeMap();
                        String habilidadId = SWBUtils.TEXT.decode(request.getParameter("sid"), "UTF-8");
                        Habilidad habil = Habilidad.ClassMgr.getHabilidad(habilidadId, wsite);
                        if (habil != null) {
                            String wptitle = habil.getTitle();
                            Iterator<AreaTalento> areas = AreaTalento.ClassMgr.listAreaTalentoByHabilidad(habil, wsite);
                            while (areas.hasNext()) {
                                AreaTalento area = areas.next();
                                if (area == null||(area!=null&&area.getCreator()==null)) {
                                    continue;
                                }
                                CV cv = CV.ClassMgr.getCV(area.getCreator().getId(), wsite);
                                if (!UtilsCVI.isCVIDone(cv)) {
                                    continue;
                                }
                                ppp.put(area.getCreator().getFullName(), area.getCreator());
                            }

                    %>
                    <table>
                        <caption>personas con la habilidad <%=wptitle%></caption>
                        <thead>
                            <%
                                if (ppp.isEmpty()) {
                                    out.println("<tr><th colspan=\"2\">No se encontraron registros</th></tr></thead>");
                                } else {
                            %>
                            <tr>
                                <th>Persona</th>
                                <th>Detalle</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                String urlcv = wsite.getWebPage("ver_CV").getUrl()+"?id=";
                                String key;
                                User user;
                                Iterator<String> keys = ppp.keySet().iterator();
                                while (keys.hasNext()) {
                                    key = keys.next();
                                    user = ppp.get(key);
                            %>
                            <tr>
                                <td><%=key%></td>  
                                <td>
                                    <%
                                        if (!export.equals("excel")) {
                                    %>
                                    <a href="#" onclick="javascript:showDtl('<%=urlcv+user.getId()%>');return false;" target="_blank" title="Ver detalle">ver</a>
                                    <%
                                        } else {
                                            out.print("---");
                                        }
                                    %> 
                                    </td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                        <tfoot></tfoot>
                    </table>
                    <%
                        if (!export.equals("excel")) { 
                            SWBResourceURL urlExport = paramRequest.getRenderUrl();
                            urlExport.setCallMethod(SWBResourceURL.Call_DIRECT);
                            urlExport.setMode(MODE_EXPORT);
                            urlExport.setAction(action);
                    %>
                    <form action="<%=urlExport.toString()%>" method="post">
                        <input type="hidden" name="export" value="excel"/>
                        <input type="hidden" name="sid" value="<%=habilidadId%>"/>
                        <button type="button" onclick="javascript:location='<%=paramRequest.getWebPage().getUrl()%>';" >Regresar</button>
                        <button type="submit" >Guardar Excel</button>
                    </form>
                    <%
                        }
                    %>
                    <script type="text/javascript">
                        <!--
                        function showDtl(url){
                            window.open(url,'CVI','menubar=0,location=0,scrollbars=1,width=650,height=600');
                        }
                        -->
                    </script>
                    <%
                            }
                        }
                    } else if ("cv".equals(action)) {
                        String basePath = "/work/models/" + paramRequest.getWebPage().getWebSite().getId() + "/jsp/ImprimirCV/viewCV.jsp";

                    %>
                    <jsp:include page="<%=basePath%>"/>
                    <%
                    }
                    %>
                </span>
            </div>
        </div><!-- icv-data -->  
    </div>
</div>