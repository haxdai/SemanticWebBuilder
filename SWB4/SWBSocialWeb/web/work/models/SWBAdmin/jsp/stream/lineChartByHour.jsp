<%-- 
    Document   : lineChartByHour
    Created on : 2/05/2014, 07:01:56 PM
    Author     : francisco.jimenez
--%>

<%@page import="java.net.URLEncoder"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="org.semanticwb.social.admin.resources.util.SWBSocialResUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.semanticwb.social.SocialTopic"%>
<%@page import="org.semanticwb.social.Stream"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.social.PostIn"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<!DOCTYPE html>

<%
    String suri = request.getParameter("suri");    
    if(suri == null)return;
    SemanticObject semObj = SemanticObject.createSemanticObject(suri);
    String clsName = semObj.createGenericInstance().getClass().getName();
    String clsName2 = semObj.createGenericInstance().getClass().getSimpleName();
    if(semObj == null)return;
    String title = "";
    String lang = request.getParameter("lang") != null ? request.getParameter("lang") : "es";
    String urlRender = (String)request.getParameter("urlRender");
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName + semObj.getId());
    String toDateAnalysis = request.getParameter("toDateAnalysis" + clsName + semObj.getId());
    Date sinDateAnalysis = null;
    Date tDateAnalysis = null;
    if(sinceDateAnalysis != null && toDateAnalysis != null) {
        try {
            sinDateAnalysis = formatDate.parse(sinceDateAnalysis);
        } catch (java.text.ParseException e) {
        }
        try {
            toDateAnalysis += " 23:59:59";
            tDateAnalysis = formatTo.parse(toDateAnalysis);
        } catch(java.text.ParseException e) {
        }
    }
    Iterator<PostIn> itObjPostIns = null;    
    if (semObj.getGenericInstance() instanceof Stream) {
        Stream stream = (Stream) semObj.getGenericInstance();
        itObjPostIns = stream.listPostInStreamInvs();
        title = stream.getTitle();
    } else if (semObj.getGenericInstance() instanceof SocialTopic) {
        SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
        itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
        title = socialTopic.getTitle();
    }    
    if(sinDateAnalysis != null && tDateAnalysis != null) {
        itObjPostIns = SWBSocialResUtil.Util.getFilterDates(itObjPostIns, sinDateAnalysis, tDateAnalysis);
    }
    String args2 = "?suri=" + URLEncoder.encode(suri);
    args2 += "&sinceDateAnalysis" + clsName2 + semObj.getId() + "=" + (sinDateAnalysis != null ? formatDate.format(sinDateAnalysis) : null);
    args2 += "&toDateAnalysis" + clsName2 + semObj.getId() + "=" + (tDateAnalysis != null ? formatDate.format(tDateAnalysis) : null);
    args2 += "&type=graphChartByHour";
    if (itObjPostIns == null || !itObjPostIns.hasNext()) {
%>
<script>
    var ifHour = parent.document.getElementById('<%=suri + "byHour"%>');
    if(ifHour){
        ifHour.style.height = '0px';
    }
    </script>
<%
        return;
    }    
    java.util.Date date = null;
    Calendar calendario = Calendar.getInstance();
    int dataArray[][] = new int[24][3];//positive, negative, neutrals
    int totalPosts = 0;
    while(itObjPostIns.hasNext()){
        PostIn postIn = itObjPostIns.next();
        if (postIn.getPi_createdInSocialNet() != null) {
            date = postIn.getPi_createdInSocialNet();
        }
        
        if(date != null){
            calendario.setTime(date);
        }else{
            continue;
        }

        int hourOfDay = calendario.get(Calendar.HOUR_OF_DAY);
        if (postIn.getPostSentimentalType() == 0) {//neutrals
            dataArray[hourOfDay][2]++;
        } else if (postIn.getPostSentimentalType() == 1) {//positives
            dataArray[hourOfDay][0]++;
        } else if (postIn.getPostSentimentalType() == 2) {//negatives
            dataArray[hourOfDay][1]++;
        }
        totalPosts++;        
    }    
%>

<meta charset="utf-8">
<link href="/swbadmin/css/nv.d3.css" rel="stylesheet" type="text/css">

<style>

body {
  overflow-y:scroll;
}

text {
  font: 12px sans-serif;
}

svg {
  display: block;
}

#chart1 svg {
  height: 500px;
  min-width: 200px;
  min-height: 100px;
/*
  margin: 50px;
  Minimum height and width is a good idea to prevent negative SVG dimensions...
  For example width should be =< margin.left + margin.right + 1,
  of course 1 pixel for the entire chart would not be very useful, BUT should not have errors
*/

}
#chart1 {
  margin-top: 10px;
  margin-left: 100px;
}
.excel{
    background-image:url(/swbadmin/css/images/ico-exp-excel.png); 
    background-repeat:no-repeat; 
    background-position: center; 
    text-indent:-9999px
}
.aShowGraph a {
  display: inline-block;
  height: 30px;
  width: 33px;
  border-radius: 4px;
  -moz-border-radius: 4px;
  -webkit-border-radius: 4px;
  -khtml-border-radius: 4px;

}
</style>
<body class='with-3d-shadow with-transitions'>
<div align="center" class="aShowGraph">
    <div align="center" style="margin-left: 100px; width: 700px">N&Uacute;MERO DE MENSAJES POR HORA DEL D&Iacute;A</div>
    <div align="center">
        <a href="javascript:exportFile();" 
                onclick="return confirm('&iquest;Desea exportar a excel?')" class="excel"><%=SWBSocialResUtil.Util.getStringFromGenericLocale("exportExcel", lang)%></a>
    </div>
</div>
<div id="chart1" >  
  <svg style="height: 500px;"></svg>
</div>

<script src="../../js/d3.v3.js"></script>
<script src="../../js/nv.d3.js"></script>
<script>
// Wrapping in nv.addGraph allows for '0 timeout render', stores rendered charts in nv.graphs, and may do more in the future... it's NOT required
var chart;

nv.addGraph(function() {
  chart = nv.models.lineChart()
  .options({
    margin: {left: 80, bottom: 8},
    x: function(d,i) { return i},
    showXAxis: true,
    showYAxis: true,
    transitionDuration: 250
  })
  ;

  // chart sub-models (ie. xAxis, yAxis, etc) when accessed directly, return themselves, not the parent chart, so need to chain separately
  chart.xAxis
    .axisLabel("Hora del dia")
    .tickFormat(d3.format(',.1d'));

  chart.yAxis
    .axisLabel('Numero de posts')
    .tickFormat(d3.format("d"))
    ;

  d3.select('#chart1 svg')
    .datum(getChartData())
    .call(chart);
    
  //TODO: Figure out a good way to do this automatically
  nv.utils.windowResize(chart.update);
  //nv.utils.windowResize(function() { d3.select('#chart1 svg').call(chart) });

  chart.dispatch.on('stateChange', function(e) { nv.log('New State:', JSON.stringify(e)); });

  return chart;
});

function getChartData() {
  var total = [];
  var positives =[];
  var negatives =[];
  var neutrals =[];
  
       <% for (int i=0; i < dataArray.length; i++) { %>
        positives.push({x:<%=i%>, y: <%= dataArray[i][0] %>});
        negatives.push({x:<%=i%>, y: <%= dataArray[i][1] %>});
        neutrals.push({x:<%=i%>, y: <%= dataArray[i][2] %>});
        total.push({x:<%=i%>, y: <%= dataArray[i][0] + dataArray[i][1] +dataArray[i][2] %>});        
        <% } %>
	
  

  return [
    {
      values: total,
      positivos: positives,
      negativos: negatives,
      neutros: neutrals,
      key: "Datos de <%=title%>",
      color: "#FF6600"
    }
  ];
}

function exportFile() {
    var url = '<%=urlRender%>';
    url += '<%=args2%>';
    document.location.href = url;
}
</script>