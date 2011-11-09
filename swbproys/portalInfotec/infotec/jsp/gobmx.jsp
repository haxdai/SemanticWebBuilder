
<%@page import="org.semanticwb.SWBUtils"%>
<%@page import="java.net.URLEncoder"%>
<%!

private static String mark = "-_.!~*'()\"";

    public static String encodeURI(String argString) {
        StringBuilder uri = new StringBuilder(); // Encoded URL
        // thanks Marco!

        char[] chars = argString.toCharArray();
        for(int i = 0; i<chars.length; i++) {
            char c = chars[i];
            if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z') || mark.indexOf(c) != -1) {
                uri.append(c);
            }
            else {
                uri.append("%");
                uri.append(Integer.toHexString((int)c));
            }
        }
        return uri.toString();
    }
%>
<%

    String q=request.getParameter("q");
    String word=q;
    q=encodeURI(q);
    String url="http://www.gob.mx/results.html?gobmxq="+ q +"&geo=0&ts=all";
%>
<br>
<br>
<div id="search-gobmx-link-anchor">
    <a href="<%=url%>" target="_new"> Buscar <em><%=word%> </em> en <img alt="imagen gobmx"  src="/work/models/infotec/jsp/gobmxWM.png"></a>
</div>
<br>
<br>
