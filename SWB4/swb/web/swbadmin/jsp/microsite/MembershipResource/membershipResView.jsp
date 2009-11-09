<%@page contentType="text/html"%>
<%@page import="org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>

<%!
    private Member getMember(User user, MicroSite site)
    {
        if (site != null)
        {
            Iterator<Member> it = Member.listMemberByUser(user, site.getWebSite());
            while (it.hasNext())
            {
                Member mem = it.next();
                if (mem.getMicroSite().equals(site))
                {
                    return mem;
                }
            }
        }
        return null;
    }
%>
<%

            SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
            User user = paramRequest.getUser();
            WebPage wp = paramRequest.getWebPage();
            SWBResourceURL urle = paramRequest.getRenderUrl();
            urle.setParameter("act", "edit");
            MicroSite site = MicroSite.getMicroSite(paramRequest.getWebPage());
            Member member = getMember(user, site);
            if (!(wp.getSemanticObject().getGenericInstance() instanceof MicroSite))
            {
                return;
            }
            String pathPhoto = "/swbadmin/jsp/microsite/MembershipResource/userIMG.jpg";

            if (site.getPhoto() != null)
            {
                pathPhoto = SWBPortal.getContextPath() + SWBPortal.getWebWorkPath() + site.getPhoto();
            }
%>

<div class="columnaIzquierda">
    <%
            if (site.getDescription() != null)
            {
                out.println("<p>" + site.getDescription() + "</p>");
            }
            if (site.getTags() != null && site.getTags().trim().length() > 0 && !site.getTags().equals("null"))
            {
                out.println("<p>Palabras clave: " + site.getTags() + "</p>");
            }
            out.println("<p>Creador: " + site.getCreator().getFullName() + "</p>");
            out.println("<p>Creada: " + SWBUtils.TEXT.getTimeAgo(site.getCreated(), user.getLanguage()) + "</p>");
            out.println("<p>Modificada: " + SWBUtils.TEXT.getTimeAgo(site.getUpdated(), user.getLanguage()) + "</p>");
    %>
</div>

<div class="columnaCentro">
    <h2 class="blogTitle"><%=site.getTitle()%></h2>
    <p><img src="<%=pathPhoto%>" alt="Imagen comunidad"  ></p>
        <%
            if (null != member && member.getAccessLevel() == Member.LEVEL_OWNER && user.isRegistered())
            {

        %>
    <p><a href="<%=urle%>">[Cambiar imagen]</a></p>

    <%
            }
    %>
    <ul class="miContenido">
       <%
        SWBResourceURL urla = paramRequest.getActionUrl();
        if (user.isRegistered())
        {
            if (member == null)
            {
                urla.setParameter("act", "subscribe");
        %>
        <li><a href="<%=urla%>">Suscribirse a esta comunidad</a></li>
        <%
    }
    else
    {
        urla.setParameter("act", "unsubscribe");
        %>
        <li><a href="<%=urla%>">Cancelar suscripci�n</a></li>
        <%
    }
}%>
    </ul>
</div>
<%--

            SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
            User user = paramRequest.getUser();
            WebPage wp = paramRequest.getWebPage();

            MicroSite site = MicroSite.getMicroSite(paramRequest.getWebPage());

            String pathPhoto = "/swbadmin/jsp/microsite/MembershipResource/userIMG.jpg";

            if (site.getPhoto() != null)
            {
                pathPhoto = SWBPortal.getContextPath() + SWBPortal.getWebWorkPath() + site.getPhoto();
            }


            Member member = getMember(user, site);
            if (wp.getSemanticObject().getGenericInstance() instanceof MicroSite)
            {
%>
<div class="columnaIzquierda">
    <h2><%=site.getDisplayName()%></h2>

    <%        
        if (site.getDescription() != null)
        {
            out.println("<p>" + site.getDescription() + "</p>");
        }
        if (site.getTags() != null && site.getTags().trim().length() > 0 && !site.getTags().equals("null"))
        {
            out.println("<p>Palabras clave: " + site.getTags() + "</p>");
        }
        out.println("<p>Creador: " + site.getCreator().getFullName() + "</p>");
        out.println("<p>Creada: " + SWBUtils.TEXT.getTimeAgo(site.getCreated(), user.getLanguage()) + "</p>");
        out.println("<p>Modificada: " + SWBUtils.TEXT.getTimeAgo(site.getUpdated(), user.getLanguage()) + "</p>");
    %>

</div>
<div id="columnaCentro">
    <p><img src="<%=pathPhoto%>" alt="Imagen comunidad"  ></p>
    <%

    if (null != member && member.getAccessLevel() == Member.LEVEL_OWNER && user.isRegistered())
    {
        SWBResourceURL urle = paramRequest.getRenderUrl();
        urle.setParameter("act", "edit");
        //urle.setCallMethod(SWBResourceURL.Call_DIRECT);
    %>
    <p><a href="<%=urle%>">[Cambiar imagen]</a></p>

    <%
            }
    %>
    <ul class="miContenido">
        <%
        SWBResourceURL urla = paramRequest.getActionUrl();
        if (user.isRegistered())
        {
            if (member == null)
            {
                urla.setParameter("act", "subscribe");
        %>
        <li><a href="<%=urla%>">Suscribirse a esta comunidad</a></li>
        <%
    }
    else
    {
        urla.setParameter("act", "unsubscribe");
        %>
        <li><a href="<%=urla%>">Cancelar suscripci�n</a></li>
        <%
    }
}%>

    </ul>

</div>
<%
            }
%>

--%>