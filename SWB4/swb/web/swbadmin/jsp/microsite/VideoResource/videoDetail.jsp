<%@page contentType="text/html"%>
<%@page import="org.semanticwb.portal.lib.*,org.semanticwb.platform.*,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%!    public static final java.text.SimpleDateFormat dateFormat;

    static
    {
        String lang = "es";
        Locale locale = new Locale(lang);
        dateFormat = new java.text.SimpleDateFormat("dd-MMM-yyyy", locale);
        String[] months={"Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};
        java.text.DateFormatSymbols fs=dateFormat.getDateFormatSymbols();
        fs.setShortMonths(months);
        dateFormat.setDateFormatSymbols(fs);
    }
%>
<%
    SWBParamRequest paramRequest=(SWBParamRequest)request.getAttribute("paramRequest");
    User user=paramRequest.getUser();
    WebPage wpage=paramRequest.getWebPage();
    Member member=Member.getMember(user,wpage);    
    java.text.DecimalFormat df = new java.text.DecimalFormat("#0.0#");
%>
<%
        String uri=request.getParameter("uri");
        VideoElement rec=(VideoElement)SemanticObject.createSemanticObject(uri).createGenericInstance();
        rec.incViews();                             //Incrementar apariciones
        if(rec!=null)
        {
            String rank = df.format(rec.getRank());
            String title = "Sin t�tulo";
                        if (rec.getTitle() != null)
                        {
                            title = rec.getTitle();
                        }
                        String description="Sin descripci�n";
                        if (rec.getDescription() != null)
                        {
                            description = rec.getDescription();
                        }
                        String tags="Sin etiquetas";
                        if (rec.getTags() != null)
                        {
                            tags = rec.getTags();
                        }
%>
<div class="columnaIzquierda">    
    <br><%=rec.getCode()%>
    <br>
<%
SWBResponse res=new SWBResponse(response);
rec.renderGenericElements(request, res, paramRequest);
out.write(res.toString());
%>
</div>
<div class="columnaCentro">
    <h2 class="blogTitle"><%=title%></h2><br>
    <p><%=description%></p>
    <p>Creado el: <%=dateFormat.format(rec.getCreated())%></p>
    <p>Etiquetas: <%=tags%></p>
    <p><%=rec.getViews()%> vistas</p>
    <p>Calificaci�n: <%=rank%></p>
    <p><a href="<%=paramRequest.getRenderUrl()%>">[Ver todos los videos]</a></p>    
        <%if(rec.canModify(member)){%><p><a href="<%=paramRequest.getRenderUrl().setParameter("act","edit").setParameter("uri",rec.getURI())%>">[Editar Informaci�n]</a></p><%}%>
        <%if(rec.canModify(member)){%><p><a href="<%=paramRequest.getActionUrl().setParameter("act","remove").setParameter("uri",rec.getURI())%>">[Eliminar]</a></p><%}%>
        
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
        <li><a href="<%=urla%>">Cancelar suscripci�n a comunidad</a></li>
        <%
                }
            }
            String pageUri="/swbadmin/jsp/microsite/rss/rss.jsp?video="+java.net.URLEncoder.encode(wpage.getURI());
        %>
        <li><a class="rss" href="<%=pageUri%>">Suscribirse via RSS al canal de videos de la comunidad</a></li>
        </ul>
</div>


<%
        }
%>   