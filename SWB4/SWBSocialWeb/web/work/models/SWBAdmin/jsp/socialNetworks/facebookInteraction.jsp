<%-- 
    Document   : facebookInteraction
    Created on : 9/07/2014, 01:46:43 PM
    Author     : francisco.jimenez
--%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Comparator"%>
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.social.admin.resources.util.SWBSocialResUtil"%>
<%@page import="org.semanticwb.social.PostIn"%>
<%@page import="org.semanticwb.model.UserGroup"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.semanticwb.platform.SemanticProperty"%>
<%@page import="java.io.Closeable"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.UnsupportedEncodingException"%>
<%@page import="java.util.Collection"%>
<%@page import="org.semanticwb.social.SocialNetwork"%>
<%@page import="org.semanticwb.social.Facebook"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.SWBModel"%>
<%@page import="java.io.Reader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.io.Writer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.HashMap"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<html>
<%
    Calendar currentCalendar = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat month = new SimpleDateFormat("MMMM", new Locale("es", "MX"));
    Date currentDate = null;
    SocialNetwork sn = null;
    String path = "";
    try {
        String suri = request.getParameter("suri");
        sn = (SocialNetwork) SemanticObject.createSemanticObject(suri).createGenericInstance();
        currentDate = currentCalendar.getTime();
        path = paramRequest.getRenderUrl().
                setMode("chartData").
                setCallMethod(SWBResourceURL.Call_DIRECT).
                setParameter("suri", suri).toString();
        Facebook fb = null;
        if (!(sn instanceof Facebook)) {
            return;
        } else {
            fb = (Facebook)sn;
        }
        if (!fb.isSn_authenticated() || fb.getAccessToken() == null) {
            out.println("<link href=\"/swbadmin/css/swbsocial.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("<div id=\"configuracion_redes\">");
            out.println("<div id=\"autenticacion\">");
            out.println("<p>      La cuenta no ha sido autenticada correctamente</p>");
            out.println("</div>");
            out.println("</div>");
            return;
        }
        
    } catch (Exception e) {
        out.print("Problem displaying Wall: " + e.getMessage());
    }
%>
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
#chart1 svg{
  height: 500px;
  min-width: 100px;
  min-height: 100px;
}
</style>
<script src="/work/models/SWBAdmin/js/d3.v3.js"></script>
<script src="/work/models/SWBAdmin/js/nv.d3.js"></script>
<body>
<div>
    <div align="center" style="width:100%">
        ACTIVIDAD DEL &Uacute;LTIMO MES EN LA RED SOCIAL.
    </div>
    <div align="center">
        <p>
            <span id="csLoading<%=sn.getURI()%>" style="width: 100px; display: inline" align="center">
                <img src="<%=SWBPlatform.getContextPath()%>/swbadmin/images/loading.gif"/>
                <br><span style="color: #BBBBBB">Obteniendo datos, esto puede tardar varios segundos...</span>
            </span>
        </p>
    </div>
    <div id="chart1">
        <svg></svg>
    </div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div align="center" style="width:100%">
    <p>TOP TEN DE MENSAJES POR LIKES Y COMENTARIOS.</p>
</div>
<div class="clear"></div>
<div id="tableContainer"></div>
<script type="text/javascript">

var xmlhttp;
var txt,x,i;
if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
} else {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
}
xmlhttp.onreadystatechange=function() {
  if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
    txt = eval(xmlhttp.responseText);
    var element = document.getElementById("csLoading<%=sn.getURI()%>");
    element.style.display = "none";
    
    nv.addGraph(function() {
      var chart = nv.models.discreteBarChart()
          .x(function(d) { return d.label })
          .y(function(d) { return d.value })
          .staggerLabels(true)
          .tooltips(true)
          .showValues(true)
          .transitionDuration(250)
          .margin({top: 30, right: 20, bottom: 60, left: 80})
      chart.yAxis.axisLabel("Numero de posts")
      chart.xAxis.axisLabel("Actividad por dia del mes de <%=month.format(currentDate)%>")
      chart.valueFormat(d3.format('d'))
      chart.yAxis.tickFormat(d3.format('d'))
      d3.select('#chart1 svg').datum(txt[0].chartData).call(chart);
      nv.utils.windowResize(chart.update);

      return chart;
    });
    
    var likesTxt = "<div style=\"padding: 10px; float: left; width: 45%; text-align: justify;\">" +
            "<table width=\"100%\">" +
            "<tr bgcolor=\"#ffc46a\">" +
                "<th style=\"color: #cc6600;\">Posici&oacute;n</th>" +
                "<th style=\"color: #cc6600;\">Mensaje</th>" +
                "<th style=\"color: #cc6600;\">Likes</th>" +
            "</tr>";
    for (var i = 0; i < txt[0].likesTable.length; i++) {
        var register = txt[0].likesTable[i];
        likesTxt += "<tr" + (i % 2 === 0 ? " bgcolor=\"#fff7e2\"" : "") + ">";
        likesTxt += "    <td>" + register.index + "</td>";
        likesTxt += "    <td><a href=\"" + register.link + "\" target=\"_blank\">" + register.msgTxt + "</a></td>";
        likesTxt += "   <td>" + register.likes + "</td>";
        likesTxt += "</tr>";
    }
    likesTxt += "  </table>";
    likesTxt += "</div>";
            
    var commentsTxt = "<div style=\"padding: 10px; float: right; width: 45%; text-align: justify;\">" +
            "<table width=\"100%\">" +
                "<tr bgcolor=\"#ffc46a\">" +
                    "<th style=\"color: #cc6600;\">Posici&oacute;n</th>" +
                    "<th style=\"color: #cc6600;\">Mensaje</th>" +
                    "<th style=\"color: #cc6600;\">Comentarios</th>" +
                "</tr>";
    for (var i = 0; i < txt[0].commentsTable.length; i++) {
        var register = txt[0].commentsTable[i];
        commentsTxt += "<tr" + (i % 2 === 0 ? " bgcolor=\"#fff7e2\"" : "") + ">";
        commentsTxt += "    <td>" + register.index +"</td>";
        commentsTxt += "    <td><a href=\"" + register.link + "\" target=\"_blank\">" + register.msgTxt + "</a></td>";
        commentsTxt += "   <td>" + register.comments + "</td>";
        commentsTxt += "</tr>";
    }
    commentsTxt += "  </table>";
    commentsTxt += "</div>";
    document.getElementById("tableContainer").innerHTML = likesTxt + commentsTxt;
    
  }
}
xmlhttp.open("GET", "<%=path%>", true);
xmlhttp.send();

</script>
</body>
</html>
