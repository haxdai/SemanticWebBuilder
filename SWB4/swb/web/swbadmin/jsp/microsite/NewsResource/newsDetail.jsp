<%@page contentType="text/html"%>
<%@page import="java.text.SimpleDateFormat, org.semanticwb.platform.*,org.semanticwb.portal.api.*,org.semanticwb.portal.community.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%
            SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
            Resource base = paramRequest.getResourceBase();
            User user = paramRequest.getUser();
            WebPage wpage = paramRequest.getWebPage();
            Member member = Member.getMember(user, wpage);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

            String uri = request.getParameter("uri");
            String path = SWBPlatform.getWebWorkPath() + base.getWorkPath() + "/";
            NewsElement rec = (NewsElement) SemanticObject.createSemanticObject(uri).createGenericInstance();
            if (rec != null) {
                rec.incViews();                             //Incrementar apariciones
%>
<div class="news">
    <div class="newsimage">
        <img src="<%=path + rec.getNewsPicture()%>" alt="<%=rec.getDescription()%>" width="110" height="150" />
    </div>
    <div class="newstitle">
        <h2><%=rec.getTitle()%> (<%=rec.getCitation()%>)</h2>
    </div>
    <div class="newsbody">
        <%=SWBUtils.TEXT.getTimeAgo(rec.getCreated(), user.getLanguage())%><br>
        Por&nbsp;<%=rec.getAuthor()%><BR><br>
        <%=rec.getFullText()%><br>
        <hr>
        <%=rec.getViews()%> vistas<BR>
    </div>
    <%
            }
            rec.renderGenericElements(request, out, paramRequest);
    %>
    <div class="menuoptions">
        <center>
            <a href="<%=paramRequest.getRenderUrl()%>">Regresar</a>
            <%if (rec.canModify(member)) {%><a href="<%=paramRequest.getRenderUrl().setParameter("act", "edit").setParameter("uri", rec.getURI())%>">Editar Información</a><%}%>
            <%if (rec.canModify(member)) {%><a href="<%=paramRequest.getActionUrl().setParameter("act", "remove").setParameter("uri", rec.getURI())%>">Eliminar Noticia</a><%}%>
        </center>
    </div>
</div>