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
             if(wp.equals(wpparent)){
                 strSelect = "class=\"icv-menu-select\"";  
             }
%>
  		<li <%=strSelect%>><a href="<%=wp.getUrl()%>"><%=wp.getDisplayName(usr.getLanguage())%></a></li>
<%
         }
%>
	</ul>
</div>
<%
if(wpparent.isParentof(wpage)){
         boolean writeBottom = false;
         Iterator<WebPage> itsmwp=wpparent.listChilds();
         if(itsmwp.hasNext())
         {
            writeBottom = true;         
%>
<div id="icv-submenu">
    <ul>
<%
         }
         while(itsmwp.hasNext()){
             WebPage wp = itsmwp.next();
             String strSelect = "";
             if(wp.equals(wpage)){
                 strSelect = "class=\"icv-submenu-select\"";
             }
%>
                     <li <%=strSelect%>><a href="<%=wp.getUrl()%>"><%=wp.getDisplayName(usr.getLanguage())%></a></li>
<%                                      
         }
       if(writeBottom)
       {
%>
	</ul>
</div>        
<%
       }
}         
%>  