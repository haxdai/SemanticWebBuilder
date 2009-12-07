<%@page import="java.text.*,java.net.*,org.semanticwb.platform.SemanticObject,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*" %>
<%
            SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");            
            ArrayList<MicroSiteElement> elements = (ArrayList<MicroSiteElement>) request.getAttribute("elements");
            if (paramRequest.getCallMethod() == paramRequest.Call_CONTENT)
            {
%>
<jsp:include flush="true" page="LastMicrositeElementsContent.jsp"></jsp:include>
<%            }
            else
            {
                String path = paramRequest.getWebPage().getWebSite().getWebPage("Lo_ultimo").getUrl();
%>
<h2>Actividad m&aacute;s reciente en el sitio</h2>
<ul class="listaElementos">
    <%
        if (elements.size() == 0)
        {
    %>
    <li>No hay actividad durante las �ltimas dos semanas</li>
    <%                }

    for (MicroSiteElement element : elements)
    {
        User user = paramRequest.getUser();
        boolean canview = false;
        if (element.getWebPage() != null && user != null)
        {
            Member member = Member.getMember(user, element.getWebPage());
            if (member != null)
            {
                canview = element.canView(member);
            }
        }
        String created = "Sin fecha";
        if (element.getCreated() != null)
        {
            //created = iso8601dateFormat.format(element.getCreated());
            created = SWBUtils.TEXT.getTimeAgo(element.getCreated(), user.getLanguage());
        }
        String title = element.getTitle();
        String textcreated = "cre� el elemento ";
        if (element instanceof NewsElement)
        {
            textcreated = "cre� la noticia ";
        }
        if (element instanceof PostElement)
        {
            textcreated = "cre� la entrada ";
        }
        if (element instanceof VideoElement)
        {
            textcreated = "subi� el video ";
        }
        if (element instanceof PhotoElement)
        {
            textcreated = "subi� la imagen ";
        }
        if (element instanceof EventElement)
        {
            textcreated = "registr� el evento ";
        }

        String postAuthor = "Usuario dado de baja";
        if (element.getCreator() != null)
        {
            postAuthor = element.getCreator().getFirstName();
        }
    %>
    <li><%=postAuthor%>  <%=textcreated%>
        <%
if (canview)
{
        %>
        <a href="<%=element.getURL()%>">
            <%=title%>
        </a>
        <%
            }
            else
            {
        %>
        <%=title%>
        <%
}
        %>

						(<%=created%>)</li>
        <%            }
        %>
</ul>
<%-- <p class="vermas"><a href="<%=path%>" >Ver m&aacute;s</a></p> --%>
<%
            }
%>

