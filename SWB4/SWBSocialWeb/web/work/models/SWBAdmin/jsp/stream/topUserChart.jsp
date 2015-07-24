<%-- 
    Document   : topUserChart
    Created on : 20/05/2014, 11:43:14 AM
    Author     : francisco.jimenez
--%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    LinkedHashMap usersByStream = null;//<SocialNetUser,post number>
    LinkedHashMap<SocialNetworkUser, Integer[]> userCount= new LinkedHashMap<SocialNetworkUser,Integer[]>();//SocialNetUser, [neutrals][positives][negatives]
    boolean isSocialTopic = false;
    SocialTopic st = null;
    String clsName = semObj.createGenericInstance().getClass().getName();
    String clsName2 = semObj.createGenericInstance().getClass().getSimpleName();
    
    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat formatTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName);

    if(sinceDateAnalysis == null) {
        sinceDateAnalysis = request.getParameter("sinceDateAnalysis" + clsName2);
    }
    String toDateAnalysis = request.getParameter("toDateAnalysis" + clsName);
    if(toDateAnalysis == null) {
        toDateAnalysis = request.getParameter("toDateAnalysis" + clsName2);
    }
    String networkSocial = request.getParameter("networkSocial");
    Date sinDateAnalysis = null;
    Date tDateAnalysis = null;
    SemanticObject rdNetworkSocial = SemanticObject.getSemanticObject(networkSocial);
    ArrayList networks = new ArrayList();
    String url = (String)request.getParameter("url");
    String urlRender = (String)request.getParameter("urlExport");
    SocialSite ws = null;

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
    if (semObj.getGenericInstance() instanceof Stream) {
        Stream stream = (Stream) semObj.getGenericInstance();
        title = stream.getTitle();
        usersByStream = SWBSocialUtil.sparql.getSocialUsersInStream(stream); 
        ArrayList nets = SWBSocialUtil.sparql.getStreamSocialNetworks(stream);
        for(int i = 0; i < nets.size(); i++){
            SocialNetwork snet= (SocialNetwork)((SemanticObject)nets.get(i)).createGenericInstance();
            networks.add(snet);
        }
        ws = stream.getSocialSite();
    } else if (semObj.getGenericInstance() instanceof SocialTopic) {
        SocialTopic socialTopic = (SocialTopic) semObj.getGenericInstance();
        title = socialTopic.getTitle();
        usersByStream = SWBSocialUtil.sparql.getSocialUsersInSocialTopic(socialTopic);
        //itObjPostIns = PostIn.ClassMgr.listPostInBySocialTopic(socialTopic, socialTopic.getSocialSite());

        ArrayList nets = SWBSocialUtil.sparql.getSocialTopicSocialNetworks(socialTopic);
        for(int i = 0; i < nets.size(); i++){
            SocialNetwork snet= (SocialNetwork)((SemanticObject)nets.get(i)).createGenericInstance();
            networks.add(snet);
        }
        isSocialTopic = true;
        st = socialTopic;
        ws = socialTopic.getSocialSite();
    }
    Iterator usersToCount =  usersByStream.entrySet().iterator();
    int maxUsers = 0;
    boolean isUserValid = false;
    while(usersToCount.hasNext()) {
        if(isUserValid) ++maxUsers;
        if(maxUsers > 10 )break;
        isUserValid = false;
        Map.Entry pair = (Map.Entry)usersToCount.next();
        SocialNetworkUser snetu= (SocialNetworkUser)((SemanticObject)pair.getKey()).createGenericInstance();
        
        Iterator posts = snetu.listPostInInvs();//Lists user posts 
        if(sinDateAnalysis != null && tDateAnalysis != null) {
            posts = SWBSocialResUtil.Util.getFilterDates(posts, sinDateAnalysis, tDateAnalysis);
        }
        Integer[] sentimentCounter = {0,0,0};//array of posts number [neutrals][positive][neagtive]
        
        while(posts.hasNext()){
            PostIn postIn = (PostIn)posts.next();
            boolean isCount = false;
            if((rdNetworkSocial == null || rdNetworkSocial.equals("")) || 
                    (rdNetworkSocial != null && rdNetworkSocial.equals(postIn.getPostInSocialNetwork()))){
                isCount = true;
            }
            if(isCount) {
                if(isSocialTopic){
                    if(postIn.getSocialTopic() == null){
                        continue;
                    }
                    if(!postIn.getSocialTopic().equals(st)){
                        continue;
                    }
                }
                //adds 1 depending what is the post sentiment
                if(postIn.getPostSentimentalType() >= 0 &&postIn.getPostSentimentalType() <=2 ){
                    sentimentCounter[postIn.getPostSentimentalType()]++;
                }
            }
        }
        if(sentimentCounter[0] != 0 || sentimentCounter[1] != 0 || sentimentCounter[2] != 0) {
            userCount.put(snetu, sentimentCounter);
            isUserValid = true;
        }
    }
    
    if(usersByStream == null || usersByStream.size() <= 0){
%>
<script>
    var ifHour = parent.document.getElementById('<%=suri + "byUser"%>');
    if(ifHour){
        ifHour.style.height = '0px';
    }
    </script>
<%
        return;
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

.aShowGraph {
    padding-bottom: 0px;
}
</style>
<body class='with-3d-shadow with-transitions'>

<div id="chart1" >
  <div align="center" style="margin-left: 100px; width: 700px">USUARIOS CON M&Aacute;S INTERACCI&Oacute;N</div>
  <div>
      <div class="aShowGraph" align="center">
        <a href="javascript:exportFile(document.frmNetworkSocial.networkSocial.value);" 
                onclick="return confirm('&iquest;Desea exportar a excel?')" class="excel">Exportar excel</a>
      </div>
      <form name="frmNetworkSocial">
          <div style="align:center; text-align: center; padding-top: 15px; padding-bottom: 15px">
      <label>Red Social: </label>
      <select name="networkSocial" id="networkSocial">
          <option value="">-- -- -- --</option>
          <%    Iterator it = networks.iterator();
            while(it.hasNext()) {
                SocialNetwork network = (SocialNetwork)it.next();
                String selected = "";
                if(network.equals(rdNetworkSocial)) {
                    selected = " selected";
                }%>
                <option value="<%=network.getURI()%>" <%=selected%>><%=network.getTitle()%></option>
          <%    }%>
      </select>
      <input   type="button" value="Mostrar" onclick="javascript:showNetworkSocial(document.frmNetworkSocial.networkSocial.value)">
      </div>
      </form>
  </div>
  <svg style="height: 430px;"></svg>
</div>

<script src="../../js/d3.v3.js"></script>
<script src="../../js/nv.d3.js"></script>
<script>
    var usrsTopChart = "";
    var args = '&sinceDateAnalysis<%=clsName%>=<%=(sinDateAnalysis != null ? formatDate.format(sinDateAnalysis) : null)%>';
    args += '&toDateAnalysis<%=clsName%>=<%=(tDateAnalysis != null ? formatDate.format(tDateAnalysis) : null)%>';
          
    function showNetworkSocial(netSocial) {
        var urlParams = '&networkSocial=' + escape(netSocial); 
          urlParams += args;
        parent.postHtml('<%=url%>?suri=<%=URLEncoder.encode(suri)%>' + urlParams, 'topUserChart');
    }
    
    function exportFile(netSocial) {
        getUsrsData();
        var url = '?suri=<%=URLEncoder.encode(suri)%>';
        url += args;
        url += "&type=graphChartTopUser&idUsrs="  + usrsTopChart;
        url += '&networkSocial=' + escape(netSocial);
        url += '&ws=<%=ws.getId()%>';
        var ajax_url = '<%=urlRender%>';
        ajax_url += url;
        document.location.href = ajax_url;
    }
    
    function getUsrsData() {
        <%Iterator entries1 =  userCount.entrySet().iterator();
        maxUsers = 0;
        while (entries1.hasNext()) {//while
            if (++maxUsers > 10 ) {
                break;
            }
            Map.Entry entryA = (Map.Entry) entries1.next();
            SocialNetworkUser userEntryA = (SocialNetworkUser) entryA.getKey();
			    %>
            usrsTopChart += '<%=userEntryA.getId()%>';
                usrsTopChart += ',';
       <%} %>
    }
    
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

  return chart;
});

function getChartData() {      
    return[
<%
    String labels[] = {"Neutros","Positivos","Negativos"};
    String colors[] = {"#838383","#008000","#FF0000"};
    for(int i = 0; i < 3 ; i++) {//for
%>
        {
            key:'<%=labels[i]%>',
            color:'<%=colors[i]%>',
            values:[
<%
        maxUsers = 0;
        Iterator entries =  userCount.entrySet().iterator();
        while (entries.hasNext()) {//while
            if (++maxUsers > 10 ) {
                break;
            }
            Map.Entry entry = (Map.Entry) entries.next();
            SocialNetworkUser userEntry = (SocialNetworkUser) entry.getKey();
            String socialNetWork = userEntry.getSnu_SocialNetworkObj().getId();
            if (socialNetWork != null) {
                if (socialNetWork.length() > 4) {
                    socialNetWork = socialNetWork.substring(0, 4);
                }
            } else {
                socialNetWork = "NA";
            }
            int userKlout = userEntry.getSnu_klout();
            Integer entrySentiments[] = (Integer[]) entry.getValue();
%>
            {
                "label": "<%=userEntry.getSnu_name()%>(<%=socialNetWork%>/<%=userKlout%>)",
                "value": <%=entrySentiments[i]%>
            }<%=entries.hasNext() && maxUsers < 10 ? ",":""%>
<%
                }//while
%>
            ]
        }<%=i<2 ?",":""%>
<%
    }//for
%>
    ];
}

</script>