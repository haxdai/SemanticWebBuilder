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
<!--jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" /-->
<%
TreeMap treeMap = new TreeMap();
treeMap.put("1","One");
treeMap.put("3","Three");
treeMap.put("2","Two");
treeMap.put("5","Five");
treeMap.put("4","Four");
SortedMap sortedMap = treeMap.headMap("3");
System.out.println("Head Map Contains : " + sortedMap);
sortedMap = treeMap.tailMap("4"); 
System.out.println("Tail Map Contains : " + sortedMap);
    /*WebPage wpage = paramRequest.getWebPage();
    WebSite wsite = wpage.getWebSite();
    User usr = paramRequest.getUser();
    Role role = null;*/

    /*Resource base = paramRequest.getResourceBase();
    String strNumItems = base.getAttribute("numPageItems", "10");
    String npage = request.getParameter("page");
    String orderby = request.getParameter("order");
    String action = request.getParameter("act");
    String MODE_EXPORT = "export";*/

    /*String export = request.getParameter("export");
    if (null == export) {
        export = "";
    }*/

    /*int numPages = 10;
    try {
        numPages = Integer.parseInt(strNumItems);
    } catch (Exception e) {
        numPages = 10;
    }

    if (action == null) {
        action = "";
    }*/


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


//HashMap<String, Integer> hm = new HashMap<String, Integer>(); // grado|situacion
//HashMap<String, Integer> hmes = new HashMap<String, Integer>(); // tipoestudio|situacion
//HashMap<String, String> hmorder = new HashMap<String, String>(); // grado|situacion
//HashMap<String, String> hmesorder = new HashMap<String, String>(); // tipoestudio|situacion

String wptitle = "Habilidades";

final String siteid = "eworkplace3";
WebSite wsite = WebSite.ClassMgr.getWebSite(siteid);



/*Iterator<CV> itcv = CV.ClassMgr.listCVs(wsite);
while (itcv.hasNext()) {
    CV cv = itcv.next();
    if( !UtilsCVI.isCVIDone(cv) )
        continue;
}*/


TreeMap<String,Integer> ggg = new TreeMap();
//TreeMap<String,Integer> mmm = new TreeMap();
//TreeMap<String,Integer> ppp = new TreeMap();
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

System.out.println("Tail Map Contains : " + ggg.toString());

%>