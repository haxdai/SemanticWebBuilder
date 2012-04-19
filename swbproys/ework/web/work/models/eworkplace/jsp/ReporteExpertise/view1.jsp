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
<p>hola </p>
<%
/*
final String siteid = "eworkplace3";
WebSite wsite = WebSite.ClassMgr.getWebSite(siteid);*/

String wptitle = "Habilidades";

TreeMap<String,Integer> ggg = new TreeMap();
Iterator<TipoTalento> types = TipoTalento.ClassMgr.listTipoTalentos(wsite);
while(types.hasNext()) {
    TipoTalento tipo = types.next();
    if(tipo==null)
        continue;
    Iterator<AreaTalento> areas = AreaTalento.ClassMgr.listAreaTalentoByTipoAreaTalento(tipo, wsite);
    while(areas.hasNext()) {
        AreaTalento area = areas.next();
        if(area==null)
            continue;
        CV cv = CV.ClassMgr.getCV(area.getCreator().getId(), wsite);
        if( !UtilsCVI.isCVIDone(cv) )
            continue;
        if(ggg.containsKey(tipo.getTitle()))
            ggg.put(tipo.getTitle(), ggg.get(tipo.getTitle())+1);
        else
            ggg.put(tipo.getTitle(), 1);
    }
}
%>
<table>
    <caption><%=wptitle%></caption>
    <thead>
<%
    if(ggg.isEmpty()) {
        out.println("<tr><th colspan=\"2\">No se encontraron registros</th></tr></thead>");
    }else {
%>
        <tr>
            <th>Tipo de habilidad</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
<%
        SWBResourceURL url = null;
        String key;
        int v;
        Iterator<String> keys = ggg.keySet().iterator();
        while(keys.hasNext()) {
            key = keys.next();
            v = ggg.get(key);
%>
        <tr>
            <td><a href="" title="Ver detalle"><%=key%></a></td>
            <td><%=v%></td>
        </tr>
<%
        }
%>
    </tbody>
    <tfoot></tfoot>
</table>
<%
    }

System.out.println("ggg Map Contains : " + ggg.toString());


//suponiendo que estoy en granularidad media
TreeMap<String,Integer> mmm = new TreeMap();
TipoTalento tipo = TipoTalento.ClassMgr.getTipoTalento("Habilidades_Tecnicas", wsite);
if(tipo!=null) {
    wptitle = tipo.getTitle();
    Iterator<AreaTalento> areas = AreaTalento.ClassMgr.listAreaTalentoByTipoAreaTalento(tipo, wsite);
    while(areas.hasNext()) {
        AreaTalento area = areas.next();
        if(area==null)
            continue;
        CV cv = CV.ClassMgr.getCV(area.getCreator().getId(), wsite);
        if( !UtilsCVI.isCVIDone(cv) )
            continue;
        if(mmm.containsKey(area.getHabilidad().getTitle()))
            mmm.put(area.getHabilidad().getTitle(), ggg.get(tipo.getTitle())+1);
        else
            mmm.put(area.getHabilidad().getTitle(), 1);
    }
System.out.println("mmm Map Contains : " + mmm.toString());
}
%>
<table>
    <caption><%=wptitle%></caption>
    <thead>
<%
    if(mmm.isEmpty()) {
        out.println("<tr><th colspan=\"2\">No se encontraron registros</th></tr></thead>");
    }else {
%>
        <tr>
            <th>Habilidad o expertise</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
<%
        //SWBResourceURL url = null;
        String key;
        int v;
        Iterator<String> keys = mmm.keySet().iterator();
        while(keys.hasNext()) {
            key = keys.next();
            v = mmm.get(key);
%>
        <tr>
            <td><a href="" title="Ver detalle"><%=key%></a></td>
            <td><%=v%></td>
        </tr>
<%
        }
%>
    </tbody>
    <tfoot></tfoot>
</table>
<%
    }


//suponiendo que estoy en granularidad pequena
TreeMap<String,User> ppp = new TreeMap();
Habilidad habil = Habilidad.ClassMgr.getHabilidad("Lenguajes_de_ProgramacionC", wsite);
if(habil!=null) {
    wptitle = habil.getTitle();
    Iterator<AreaTalento> areas = AreaTalento.ClassMgr.listAreaTalentoByHabilidad(habil, wsite);
    while(areas.hasNext()) {
        AreaTalento area = areas.next();
        if(area==null)
            continue;
        CV cv = CV.ClassMgr.getCV(area.getCreator().getId(), wsite);
        if( !UtilsCVI.isCVIDone(cv) )
            continue;
        ppp.put(area.getCreator().getLastName(), area.getCreator());
    }
System.out.println("mmm Map Contains : " + mmm.toString());
}
%>
<table>
    <caption>personas con la habilidad <%=wptitle%></caption>
    <thead>
<%
    if(ppp.isEmpty()) {
        out.println("<tr><th colspan=\"2\">No se encontraron registros</th></tr></thead>");
    }else {
%>
        <tr>
            <th>persona</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
<%
        //SWBResourceURL url = null;
        String key;
        User user;
        Iterator<String> keys = ppp.keySet().iterator();
        while(keys.hasNext()) {
            key = keys.next();
            user = ppp.get(key);
            //AreaTalento.ClassMgr.listAreaTalentoByCreator(user, wsite);
%>
        <tr>
            <td><a href="" title="Ver detalle"><%=key%></a></td>
            <td><%=(user.getFullName())%></td>
        </tr>
<%
        }
%>
    </tbody>
    <tfoot></tfoot>
</table>
<%
    }
%>