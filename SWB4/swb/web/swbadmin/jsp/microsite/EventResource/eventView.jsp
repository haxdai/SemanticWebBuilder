<%@page contentType="text/html"%>
<%@page import="java.text.SimpleDateFormat, org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<script language="Javascript" type="text/javascript">
    function validateremove(url, title)
    {
        if(confirm('�Esta seguro de borrar el evento: '+title+'?'))
        {            
            window.location.href=url;
        }
    }
</script>
<%!    private static final int ELEMENETS_BY_PAGE = 5;
%>
<%

            java.text.DecimalFormat df = new java.text.DecimalFormat("#0.0#");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
            String cssPath = SWBPortal.getWebWorkPath() + "/models/" + paramRequest.getWebPage().getWebSiteId() + "/css/images/";
            User user = paramRequest.getUser();
            WebPage wpage = paramRequest.getWebPage();
            MicroSiteWebPageUtil wputil = MicroSiteWebPageUtil.getMicroSiteWebPageUtil(wpage);
            Member member = Member.getMember(user, wpage);            
            String addEventURL = paramRequest.getRenderUrl().setParameter("act", "add").toString();
            Date today = new Date(System.currentTimeMillis());
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(today);
            cal.add(cal.MONTH, cal.get(cal.MONTH) + 1);
            Date end = cal.getTime();

            Iterator<EventElement> it = EventElement.ClassMgr.listEventElementByEventWebPage(wpage, wpage.getWebSite());
            while (it.hasNext())
            {
                EventElement event = it.next();
                %>
                aaa <%=end.after(event.getEndDate())%>
                <%
                if (end.after(event.getEndDate()) || event.getEndDate().equals(end))
                {
                    event.remove();
                }
            }
            ArrayList<EventElement> elements = new ArrayList();
            int elementos = 0;
            it = EventElement.ClassMgr.listEventElementByEventWebPage(wpage, wpage.getWebSite());
            it = SWBComparator.sortByCreated(it, false);
            while (it.hasNext())
            {
                EventElement event = it.next();
                if (event.canView(member) && (today.after(event.getEndDate()) || event.getEndDate().equals(today)))
                {
                    elements.add(event);
                    elementos++;
                }
            }
            int paginas = elementos / ELEMENETS_BY_PAGE;
            if (elementos % ELEMENETS_BY_PAGE != 0)
            {
                paginas++;
            }
            int inicio = 0;
            int fin = ELEMENETS_BY_PAGE;
            int ipage = 1;
            if (request.getParameter("ipage") != null)
            {
                try
                {
                    ipage = Integer.parseInt(request.getParameter("ipage"));
                    inicio = (ipage * ELEMENETS_BY_PAGE) - ELEMENETS_BY_PAGE;
                    fin = (ipage * ELEMENETS_BY_PAGE);
                }
                catch (NumberFormatException nfe)
                {
                    ipage = 1;
                }
            }
            if (ipage < 1 || ipage > paginas)
            {
                ipage = 1;
            }
            if (inicio < 0)
            {
                inicio = 0;
            }
            if (fin < 0)
            {
                fin = ELEMENETS_BY_PAGE;
            }
            if (fin > elementos)
            {
                fin = elementos;
            }
            if (inicio > fin)
            {
                inicio = 0;
                fin = ELEMENETS_BY_PAGE;
            }
            if (fin - inicio > ELEMENETS_BY_PAGE)
            {
                inicio = 0;
                fin = ELEMENETS_BY_PAGE;
            }
            inicio++;
%>
<div class="columnaIzquierda">


    <%
            if (paginas > 1)
            {
    %>
    <div id="paginacion">


        <%
                String nextURL = "#";
                String previusURL = "#";
                if (ipage < paginas)
                {
                    nextURL = paramRequest.getWebPage().getUrl() + "?ipage=" + (ipage + 1);
                }
                if (ipage > 1)
                {
                    previusURL = paramRequest.getWebPage().getUrl() + "?ipage=" + (ipage - 1);
                }
                if (ipage > 1)
                {
        %>
        <a href="<%=previusURL%>"><img src="<%=cssPath%>pageArrowLeft.gif" alt="anterior"></a>
            <%
                }
                for (int i = 1; i <= paginas; i++)
                {
            %>
        <a href="<%=wpage.getUrl()%>?ipage=<%=i%>"><%
                    if (i == ipage)
                    {
            %>
            <strong>
                <%                    }
                %>
                <%=i%>
                <%
                    if (i == ipage)
                    {
                %>
            </strong>
            <%                    }
            %></a>
        <%
                }
        %>

        <%
                if (ipage != paginas)
                {
        %>
        <a href="<%=nextURL%>"><img src="<%=cssPath%>pageArrowRight.gif" alt="siguiente"></a>
            <%
                }
            %>
    </div>
    <%
            }
    %>

    <div class="adminTools">
        <%
            if (member.canAdd())
            {
        %>
        <a class="adminTool" href="<%=addEventURL%>">Agregar evento</a>
        <%
            }
        %>
    </div>
    <%

            if (elements.size() == 0)
            {
    %>
    <p>No hay eventos registrados en la comunidad</p>
    <%            }

            int iElement = 0;
            for (EventElement event : elements)
            {
                SWBResourceURL viewUrl = paramRequest.getRenderUrl().setParameter("act", "detail").setParameter("uri", event.getURI());
                if (event.canView(member))
                {
                    iElement++;
                    if (iElement > fin)
                    {
                        break;
                    }
                    if (iElement >= inicio && iElement <= fin)
                    {
                        String rank = df.format(event.getRank());
                        String editEventURL = paramRequest.getRenderUrl().setParameter("act", "edit").setParameter("uri", event.getURI()).toString();
                        SWBResourceURL removeUrl = paramRequest.getActionUrl();
                        removeUrl.setParameter("act", "remove");
                        removeUrl.setParameter("uri", event.getEncodedURI());
                        String removeurl = "javascript:validateremove('" + removeUrl + "','" + event.getTitle() + "')";
    %>
    <div class="noticia">
        <img src="<%=SWBPortal.getWebWorkPath() + event.getEventThumbnail()%>" alt="<%= event.getTitle()%>">
        <div class="noticiaTexto">
            <h2><%=event.getTitle()%></h2>
            <p>&nbsp;<br>Por: <%=event.getCreator().getFullName()%><br><%=dateFormat.format(event.getCreated())%> - <%=SWBUtils.TEXT.getTimeAgo(event.getCreated(), user.getLanguage())%></p>
            <p>
                <%=event.getDescription()%> | <a href="<%=viewUrl%>">Ver m�s</a>
                <%
                if (event.canModify(member))
                {
                %>
                | <a href="<%=editEventURL%>">Editar</a> | <a href="<%=removeurl%>">Eliminar</a>
                <%
                }
                %>

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
            }
    %>
    <!-- paginacion -->
    <%
            if (paginas > 1)
            {
    %>
    <div id="paginacion">


        <%
                String nextURL = "#";
                String previusURL = "#";
                if (ipage < paginas)
                {
                    nextURL = paramRequest.getWebPage().getUrl() + "?ipage=" + (ipage + 1);
                }
                if (ipage > 1)
                {
                    previusURL = paramRequest.getWebPage().getUrl() + "?ipage=" + (ipage - 1);
                }
                if (ipage > 1)
                {
        %>
        <a href="<%=previusURL%>"><img src="<%=cssPath%>pageArrowLeft.gif" alt="anterior"></a>
            <%
                }
                for (int i = 1; i <= paginas; i++)
                {
            %>
        <a href="<%=wpage.getUrl()%>?ipage=<%=i%>"><%
                    if (i == ipage)
                    {
            %>
            <strong>
                <%                            }
                %>
                <%=i%>
                <%
                    if (i == ipage)
                    {
                %>
            </strong>
            <%                            }
            %></a>
        <%
                }
        %>


        <%
                if (ipage != paginas)
                {
        %>
        <a href="<%=nextURL%>"><img src="<%=cssPath%>pageArrowRight.gif" alt="siguiente"></a>
            <%
                }
            %>
    </div>
    <%
            }
    %>
    <!-- fin paginacion -->
</div>
<div class="columnaCentro">
    <%
            if (paginas > 1)
            {
    %>
    <br><br>
    <%            }
    %>
    <ul class="miContenido">
        <%
            SWBResourceURL urla = paramRequest.getActionUrl();

            if (member.canView())
            {
                if (!wputil.isSubscribed(member))
                {
                    urla.setParameter("act", "subscribe");
        %>
        <li><a href="<%=urla%>">Suscribirse a eventos</a></li>
        <%
                }
                else
                {
                    urla.setParameter("act", "unsubscribe");
        %>
        <li><a href="<%=urla%>">Cancelar suscripci�n a eventos</a></li>
        <%
                }
            }
            String pageUri = "/swbadmin/jsp/microsite/rss/rss.jsp?event=" + java.net.URLEncoder.encode(wpage.getURI());
        %>
        <li><a class="rss" href="<%=pageUri%>">Suscribirse via RSS al canal de eventos de la comunidad</a></li>
    </ul>
</div>
