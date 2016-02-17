<%-- 
    Document   : devicePlatform
    Created on : 22/05/2014, 11:34:52 AM
    Author     : francisco.jimenez
--%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.semanticwb.social.DevicePlatform"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="org.semanticwb.social.util.SWBSocialUtil"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.social.admin.resources.util.SWBSocialResUtil"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.social.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.SWBPortal"%> 
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="org.semanticwb.portal.api.*"%>
<%@page import="org.json.*"%>
<%@page import="java.util.*"%> 
<%@page import="java.util.Calendar"%> 
<%@page import="static org.semanticwb.social.admin.resources.PieChart.*"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<!DOCTYPE html>
<%
    String suri = request.getParameter("suri");    
    if(suri == null)return;
    SemanticObject semObj = SemanticObject.createSemanticObject(suri);
    if(semObj == null)return;
    String title = "";
    String lang = request.getParameter("lang") != null ? request.getParameter("lang") : "es";
    String urlRender = (String)request.getParameter("urlRender");
    String clsName = semObj.createGenericInstance().getClass().getName();
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName +  semObj.getId());
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
    String clsName2 = semObj.createGenericInstance().getClass().getSimpleName();
    String args2 = "?suri=" + URLEncoder.encode(suri) +
    "&sinceDateAnalysis" + clsName2 + semObj.getId()+ "=" + (sinDateAnalysis != null ? formatDate.format(sinDateAnalysis) : null) +
    "&toDateAnalysis" + clsName2 + semObj.getId()+ "=" + (tDateAnalysis != null ? formatDate.format(tDateAnalysis) : null) +
    "&type=graphDevicePlatform";
    String args = "?suri=" + URLEncoder.encode(suri, "UTF-8") + "&type=graphDevPlatfSentim";
    
    Iterator<PostIn> itObjPostIns = null;
    LinkedHashMap<DevicePlatform, Integer[]> lhm = new LinkedHashMap<DevicePlatform,Integer[]>();
    
    if (semObj.getGenericInstance() instanceof Stream) {
        Stream stream = (Stream) semObj.getGenericInstance();
        title = stream.getTitle();
        itObjPostIns = stream.listPostInStreamInvs();
    } else if (semObj.getGenericInstance() instanceof SocialTopic) {
        SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
        title = socialTopic.getTitle();
        itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());
    }
    if(sinDateAnalysis != null && tDateAnalysis != null) {
        itObjPostIns = SWBSocialResUtil.Util.getFilterDates(itObjPostIns, sinDateAnalysis, tDateAnalysis);
    }    
    if(itObjPostIns == null || !itObjPostIns.hasNext()){
%>
<script>
    var ifHour = parent.document.getElementById('<%=suri + "byPlatform"%>');
    if(ifHour){
        ifHour.style.height = '0px';
    }
    </script>
<%
        return;
    }
    Iterator<DevicePlatform> dps = DevicePlatform.ClassMgr.listDevicePlatforms(SWBContext.getGlobalWebSite());
    while(dps.hasNext()){
        DevicePlatform dp = dps.next();
        lhm.put(dp, new Integer[]{0,0,0});
    }
    while(itObjPostIns.hasNext()) {
        PostIn postIn = itObjPostIns.next();
        DevicePlatform pInDP = postIn.getPostInDevicePlatform();
        if(pInDP != null) {
            if(lhm.containsKey(pInDP)) {
                Integer [] tmp = lhm.get(pInDP);//0Neutrals, 1positives, 2negatives
                if(postIn.getPostSentimentalType() >= 0 && postIn.getPostSentimentalType() <= 2 ){
                    tmp[postIn.getPostSentimentalType()]++;
                } 
                lhm.put(pInDP, tmp);
            } 
        }
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

#chart1 {
  margin: 10px;
  min-width: 100px;
  min-height: 100px;
/*
  Minimum height and width is a good idea to prevent negative SVG dimensions...
  For example width should be =< margin.left + margin.right + 1,
  of course 1 pixel for the entire chart would not be very useful, BUT should not have errors
*/
}

#chart1 svg {
  height: 500px;
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
<div id="chart1" >
  <div align="center" style="margin-left: 100px; width: 700px">MENSAJES POR PLATAFORMA M&Oacute;VIL</div>
    <div align="center" style="margin-left: 100px; width: 700px; padding-top: 10px;">** <%=SWBSocialResUtil.Util.getStringFromGenericLocale("grapDisplayOnlyTwitter", lang)%></div>
    <div align="center" style="margin-left: 100px; width: 700px;" class="aShowGraph">
        <a href="javascript:exportFile();" 
                onclick="return confirm('&iquest;Desea exportar a excel?')" class="excel"><%=SWBSocialResUtil.Util.getStringFromGenericLocale("exportExcel", lang)%></a>
    </div>
  <svg style="height: 430px;"></svg>
</div>
<script src="../../js/d3.v3.js"></script>
<script src="../../js/nv.d3.js"></script>
<script>

var chart;
nv.addGraph(function() {
  chart = nv.models.multiBarHorizontalChart()
      .x(function(d) { return d.label })
      .y(function(d) { return d.value })
      .margin({top: 30, right: 20, bottom: 50, left: 175})
      //.showValues(true)
      //.tooltips(false)
      //.barColor(d3.scale.category20().range())
      .transitionDuration(250)
      .stacked(true)
      .showControls(true);

  chart.yAxis
      .axisLabel("No. de mensajes")
      .tickFormat(d3.format(',.1d'));

  d3.select('#chart1 svg')
      .datum(getChartData())
      .call(chart);

  nv.utils.windowResize(chart.update);

  chart.dispatch.on('stateChange', function(e) { nv.log('New State:', JSON.stringify(e)); });
  
  chart.multibar.dispatch.on("elementClick", function(e) {
    if(e != null) {
        if(e.point != null && e.series != null) {
            var url = '<%=urlRender%>';
            url += '<%=args%>&dev=' + e.point.label + '&sent=' +e.series.key;
            document.location.href = url;
        }
    }
});

  return chart;
});

function getChartData() {      
    return[
    <%
        String labels[] = {"Neutros","Positivos","Negativos"};
        String colors[] = {"#838383","#008000","#FF0000"};
        for(int i = 0 ; i < 3 ; i++){
    %>
    {
        key:'<%=labels[i]%>',
        color:'<%=colors[i]%>',
        values:[
        <%
            Iterator it =  lhm.entrySet().iterator();
            while(it.hasNext()){
                
                Map.Entry pair = (Map.Entry)it.next();
                DevicePlatform platform= (DevicePlatform)pair.getKey();
                Integer value[] = (Integer[])pair.getValue();
        %>
            {
                "label": "<%=platform.getId()%>",
                "value": <%=value[i]%>                
            }<%=it.hasNext() ? ",":""%>
        <%
            }
        %>
        ]
    }<%=i<2 ?",":""%>
    <%
       }//cerra el for
    %>
    ];
}
function exportFile() {
    var url = '<%=urlRender%>';
    url += '<%=args2%>';
    document.location.href = url;
}
</script>