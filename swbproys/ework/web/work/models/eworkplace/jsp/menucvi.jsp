<%-- 
    Document   : menucvi
    Created on : 9/02/2012, 12:07:39 PM
    Author     : juan.fernandez
--%>

<%
    WebPage wpbase = wsite.getWebPage("CVI");
    WebPage wpparent = null;
    if(!wpage.getParent().equals(wpbase)){
        wpparent = wpage;
    } else { wpparent = wpage.getParent(); }

    StringBuffer strsubmenu = new StringBuffer("");
%>
<div id="icv-menu">
	<ul>
<%
         Iterator<WebPage> itwp=wpbase.listChilds();
         while(itwp.hasNext()){
             WebPage wp = itwp.next();
             String strSelect = "";
             if(wp.equals(wpparent)||wp.isParentof(wpage)){
                 strSelect = "class=\"icv-menu-select\"";
                 Iterator<WebPage> itcwp = wp.listChilds();
                 if(itcwp.hasNext()){
                    strsubmenu.append("\n<div id=\"icv-submenu\">");
                    strsubmenu.append("\n  <ul>");
                 }
                 boolean isFirst = true;
                 while(itcwp.hasNext()){
                     String strSelect2 = "";
                     WebPage wpsm = itcwp.next();
                     if(isFirst){
                         isFirst=false;
                         strSelect2 = "class=\"icv-submenu-select\"";
                     }
%>
                     <li <%=strSelect2%>><a href="<%=wpsm.getUrl()%>"><%=wpsm.getDisplayName(usr.getLanguage())%></a></li>
<%                     
                    if(!itcwp.hasNext()){
                        strsubmenu.append("\n  </ul>");
                        strsubmenu.append("\n</div>");
                     }
                 }
             }
%>
  		<li <%=strSelect%>><a href="<%=wp.getUrl()%>"><%=wp.getDisplayName(usr.getLanguage())%></a></li>
<%
         }
%>
	</ul>
</div>
        <%=strsubmenu.toString()%>
<!-- div id="icv-submenu">
    
	<ul>
  		<li class="icv-submenu-select"><a href="iCV-conocimiento_1grados.html">Grados académicos</a></li>
  		<li><a href="iCV-conocimiento_2estudios.html">Estudios superiores</a></li>
  		<li><a href="iCV-conocimiento_3diplomados.html">Diplomados, cursos<br /> y certificaciones</a></li>
  		<li><a href="iCV-conocimiento_4especializacion.html">Especialización en TIC</a></li>
  		<li><a href="iCV-conocimiento_5idiomas.html">Idiomas</a></li>
	</ul>
</div -->


