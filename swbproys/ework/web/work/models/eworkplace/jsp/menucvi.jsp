<%-- 
    Document   : menucvi
    Created on : 9/02/2012, 12:07:39 PM
    Author     : juan.fernandez
--%>
<%
    WebPage _wpage = paramRequest.getWebPage(); 
    WebSite _wsite = _wpage.getWebSite();
    User _usr = paramRequest.getUser();

    WebPage wpbase = _wsite.getWebPage("CVI");
    WebPage wpparent = null;
    if(!_wpage.getParent().equals(wpbase)) {
        wpparent = _wpage;
    }else {
        wpparent = _wpage.getParent();
    }

    StringBuffer strsubmenu = new StringBuffer("");
%>
<div id="icv-menu">
   <ul>
<%
         Iterator<WebPage> itwp=wpbase.listChilds(_usr.getLanguage(), true, false, false, true);
         while(itwp.hasNext()){
             WebPage wp = itwp.next();
             if(!_usr.haveAccess(wp))
                 continue;
             String strSelect = "";
             if(wp.equals(_wpage)||wp.isParentof(_wpage)){
                 strSelect = "class=\"icv-menu-select\"";
                 wpparent = wp;
             }
%>
  		<li <%=strSelect%>><a href="<%=wp.getUrl()%>"><%=wp.getDisplayName(_usr.getLanguage())%></a></li>
<%
         }
%>
	</ul>
</div>
<%
if(wpparent.isParentof(_wpage)){
         boolean writeBottom = false;
         Iterator<WebPage> itsmwp=wpparent.listChilds(_usr.getLanguage(), true, false, false, true);
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
             if(!_usr.haveAccess(wp))
                 continue;
             String strSelect = "";
             if(wp.equals(_wpage)){
                 strSelect = "class=\"icv-submenu-select\"";
             }
%>
                     <li <%=strSelect%>><a href="<%=wp.getUrl()%>"><%=wp.getDisplayName(_usr.getLanguage())%></a></li>
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
<div class="clearer">&nbsp;</div>