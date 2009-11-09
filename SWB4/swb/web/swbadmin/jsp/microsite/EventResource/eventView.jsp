<%@page contentType="text/html"%>
<%@page import="java.text.SimpleDateFormat, org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%
            SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
            User user = paramRequest.getUser();
            WebPage wpage = paramRequest.getWebPage();
            MicroSiteWebPageUtil wputil = MicroSiteWebPageUtil.getMicroSiteWebPageUtil(wpage);
            Member member = Member.getMember(user, wpage);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
            String urlViewCalendar = paramRequest.getRenderUrl().setParameter("act", "calendar").toString();
            String addEventURL = paramRequest.getRenderUrl().setParameter("act", "add").toString();

%>
<div class="columnaIzquierda">
    <div class="adminTools">
        <%
            if (member.canAdd())
            {
        %>
        <a class="adminTool" href="<%=addEventURL%>">Agregar evento</a>
        <%
            }
            if( member.canView() ) {
        if(!wputil.isSubscribed(member)) {
        %>
        <a class="adminTool" href="<%=paramRequest.getActionUrl().setParameter("act", "subscribe").toString()%>">Suscribirse</a>
        <%
                }else {
        %>
        <a class="adminTool" href="<%=paramRequest.getActionUrl().setParameter("act", "unsubscribe").toString()%>">Cancelar suscripci�n</a>

        <%
                }
            }
        %>
    </div>
    <%
            Iterator<EventElement> it = EventElement.listEventElementByEventWebPage(wpage, wpage.getWebSite());
            while (it.hasNext())
            {
                EventElement event = it.next();
                SWBResourceURL viewUrl = paramRequest.getRenderUrl().setParameter("act", "detail").setParameter("uri", event.getURI());
                if (event.canView(member))
                {
                    java.text.DecimalFormat df = new java.text.DecimalFormat("#0.0#");
                    String rank = df.format(event.getRank());
    %>
    <div class="noticia">
        <img src="<%=SWBPortal.getWebWorkPath() + event.getEventThumbnail()%>" alt="<%= event.getTitle()%>">
        <div class="noticiaTexto">
            <h2><%=event.getTitle()%></h2>
            <p>&nbsp;<br>Por:<%=event.getCreator().getFullName()%><br><%=dateFormat.format(event.getCreated())%> - <%=SWBUtils.TEXT.getTimeAgo(event.getCreated(), user.getLanguage())%></p>
            <p>
                <%=event.getDescription()%> | <a href="<%=viewUrl%>">Ver m�s</a>
            </p>
            <p class="stats">
            	Puntuaci�n: <%=rank%><br>
                <%=event.getViews()%> vistas
            </p>
        </div>
    </div>
    <%
                }
            }
    %>

    <!--div id="paginacion">
     <a href="#"><img src="images/pageArrowLeft.gif" alt="anterior"></a> <a href="#">1</a><a href="#">2</a><a href="#">3</a><a href="#">4</a><a href="#">5</a> <a href="#"><img src="images/pageArrowRight.gif" alt="siguiente"></a>
				</div-->
</div>
<div class="columnaCentro">
    <ul class="miContenido">
<%
            SWBResourceURL urla = paramRequest.getActionUrl();
            if (user.isRegistered())
            {
                if (member == null)
                {
                    urla.setParameter("act", "subscribe");
        %>
        <li><a href="<%=urla%>">Suscribirse a esta comunidad a comunidad</a></li>
        <%
                }
                else
                {
                    urla.setParameter("act", "unsubscribe");
        %>
        <li><a href="<%=urla%>">Cancelar suscripci�n a comunidad</a></li>
        <%
                }
            }
            String pageUri="/swbadmin/jsp/microsite/rss/rss.jsp?event="+java.net.URLEncoder.encode(wpage.getURI());
        %>
        <li><a class="rss" href="<%=pageUri%>">Suscribirse via RSS a canal de eventos</a></li>
        </ul>
</div>
<%--

<%
    if (member.canAdd()) {
%>
<br/>
<div id="panorama">
    <div class="editarInfo"><p><a href="<%=paramRequest.getRenderUrl().setParameter("act", "calendar")%>">Ver calendario</a></p></div>
    <div class="editarInfo">
        <p><a href="<%=paramRequest.getRenderUrl().setParameter("act", "add").toString()%>">Agregar evento</a></p>
    </div>

<%
    if( member.canView() ) {
        if(!wputil.isSubscribed(member)) {
%>
    <div class="editarInfo">
        <p><a href="<%= paramRequest.getActionUrl().setParameter("act", "subscribe").toString()%>">Suscribirse</a></p>
    </div>
<%
        }else {
%>
    <div class="editarInfo">
        <p><a href="<%= paramRequest.getActionUrl().setParameter("act", "unsubscribe").toString()%>">Cancelar suscripci�n</a></p>
    </div>
<%
        }
    }
%>
</div>
<%  }%>

<br/><br/>
<div id="entriesWrapper">
<%
    Iterator<EventElement> it = EventElement.listEventElementByEventWebPage(wpage, wpage.getWebSite());
    while (it.hasNext()) {
        EventElement event = it.next();
        SWBResourceURL viewurl = paramRequest.getRenderUrl().setParameter("act", "detail").setParameter("uri", event.getURI());
        if (event.canView(member)) {
%>
    <div class="entry">
        <a href="<%=viewurl%>">
            <img src="<%=SWBPortal.getWebWorkPath()+event.getEventThumbnail()%>" alt="<%= event.getTitle()%>" border="0" />
        </a>
        <div class="entryInfo">            
            <p><%=SWBUtils.TEXT.getTimeAgo(event.getCreated(), user.getLanguage())%></p>
            <p class="tituloNaranja"><%=event.getTitle()%></p>
            <p class="eventoInicio">Inicia: <strong><%= (event.getStartDate()==null?"":dateFormat.format(event.getStartDate()))%></strong> a las <strong><%= (event.getStartTime()==null?"":timeFormat.format(event.getStartTime()))%></strong></p>
            <p class="eventoFinal">Termina: <strong><%= (event.getEndDate()==null?"":dateFormat.format(event.getEndDate()))%></strong> a las <strong><%= (event.getEndTime()==null?"":timeFormat.format(event.getEndTime()))%></strong></p>
            <p>Valoraci&oacute;n:<%=event.getRank()%></p>
            <p><%=event.getViews()%> vistas</p>
            <div class="clear">&nbsp;</div>
        </div>
    </div>
<%      }
    }
%>
</div>

--%>