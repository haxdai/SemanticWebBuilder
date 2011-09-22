<%@page contentType="text/html" %>
<%@page import="java.util.*"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.*"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.servlet.SWBHttpServletResponseWrapper"%>
<%@page import="org.semanticwb.portal.api.SWBResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.Country"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.portal.resources.sem.favoriteWebPages.*"%>
<%@page import="static org.semanticwb.portal.resources.sem.favoriteWebPages.SWBFavoriteWebPagesResource.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%!
    static final int MX_DSPLY = 5;
%>
<%
/*Iterator<SWBFavoriteWebPage> it_ = SWBFavoriteWebPage.ClassMgr.listSWBFavoriteWebPages(paramRequest.getWebPage().getWebSite());
while(it_.hasNext()) {
    it_.next().remove();
}*/
    ArrayList<WebPage> pages = (ArrayList<WebPage>) request.getAttribute("pages");
    if(pages.isEmpty()) {
%>
        <li><p>No tienes páginas marcadas como favoritas</p></li>
<%
    }else {
        User user = paramRequest.getUser();
        Iterator<SWBFavoriteWebPage> it = SWBFavoriteWebPage.ClassMgr.listSWBFavoriteWebPageByUser(user, paramRequest.getWebPage().getWebSite());
        List<SWBFavoriteWebPage> list = SWBUtils.Collections.copyIterator(it);
        Collections.sort(list);
        Collections.reverse(list);
       
        String title, surl;
        WebPage _page;
        for(int i=0; i<MX_DSPLY && i<list.size(); i++)
        {
            SWBFavoriteWebPage f = (SWBFavoriteWebPage)list.get(i);
            _page = f.getFavorite();
            try {
                title = SWBUtils.TEXT.encodeExtendedCharacters(_page.getDisplayTitle(paramRequest.getUser().getLanguage())).substring(0,80);
            }catch(IndexOutOfBoundsException iobe) {
                title = SWBUtils.TEXT.encodeExtendedCharacters(_page.getDisplayTitle(paramRequest.getUser().getLanguage()));
            }catch(Exception e) {
                title = "Sin título";
            }
            surl = _page.getUrl();
%>
            <li><a href="<%=surl%>" ><%=title%></a></li>
<%
        }
        if(list.size()>MX_DSPLY) {
            SWBResourceURL url = paramRequest.getRenderUrl().setMode("dtl");
%>
            <li><a title="Ver todos mis favoritos" href="<%=url%>" class="fav_cmd">Ver m&aacute;s</a></li>
<%            
        }
    }
%>