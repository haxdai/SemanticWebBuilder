<%@page import="java.util.Comparator"%><%@page import="java.util.HashMap"%><%@page import="org.semanticwb.model.User"%><%@page import="org.semanticwb.model.WebPage"%><%@page import="org.semanticwb.SWBPortal"%><%@page import="org.semanticwb.portal.util.SWBPriorityComparator"%><%@page import="org.semanticwb.model.SWBComparator"%><%@page import="java.util.*"%><%@page import="org.semanticwb.model.Resource"%><%@page import="org.semanticwb.model.ResourceSubType"%><%@page import="org.semanticwb.model.WebSite"%>

<%
            User user = (User) request.getAttribute("user");
            String lang = user.getLanguage();
            WebPage topic = (WebPage) request.getAttribute("topic");
            if (topic == null)
                return;
            WebSite site = topic.getWebSite();
            Iterator<WebPage> chanels = site.getHomePage().listChilds(lang, true, false, false, true);
            while (chanels.hasNext())
            {
                WebPage chanel = chanels.next();
                String chaneltitle = chanel.getDisplayName(lang);
                String urlchanel = chanel.getRealUrl();
%>
<div>
    <h3><%=chaneltitle%></h3>
    <%
                    Iterator<WebPage> childs = chanel.listChilds(lang, true, false, false, true);
                    if (childs.hasNext())
                    {
    %>
    <ul>
        <%
                                while (childs.hasNext())
                                {
                                    WebPage child = childs.next();
                                    String childtitle = child.getDisplayName(lang);
                                    String urlchild = child.getRealUrl();
        %>
        <li><a href="<%=urlchild%>"><%=childtitle%></a></li>
        <%

                                }

        %>
    </ul>
    <%
    %>
</div>

<%
                }
            }
%>

