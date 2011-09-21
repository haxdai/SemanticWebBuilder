<%@page import="java.util.*"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.servlet.SWBHttpServletResponseWrapper"%>
<%@page import="org.semanticwb.portal.api.SWBResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.portal.resources.sem.favoriteWebPages.*"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Country"%>
<%@page import="org.semanticwb.model.Resource"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
/*Iterator<SWBFavoriteWebPage> it = SWBFavoriteWebPage.ClassMgr.listSWBFavoriteWebPages(paramRequest.getWebPage().getWebSite());
while(it.hasNext()) {
    it.next().remove();
}*/
    ArrayList<WebPage> pages = (ArrayList<WebPage>) request.getAttribute("pages");
    if(pages.isEmpty())
    {
%>
    <li><p>No tienes páginas marcadas como favoritas</p></li>
<%
    }
    for (WebPage _page : pages)
    {                
        String title = SWBUtils.TEXT.encodeExtendedCharacters(_page.getDisplayTitle(paramRequest.getUser().getLanguage()));
        String url = _page.getUrl();
%>
        <li><a href="<%=url%>" ><%=title%></a></li>
<%
    }
%>

