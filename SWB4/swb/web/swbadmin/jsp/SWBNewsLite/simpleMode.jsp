<%@page contentType="text/html"%>
<%@page import="org.semanticwb.portal.resources.sem.newslite.*,java.util.*,java.text.SimpleDateFormat, org.semanticwb.portal.api.*,org.semanticwb.*,org.semanticwb.model.*,java.util.*"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    List<New> news=(List) request.getAttribute("news");    
    for(New onew : news)
    {
        SWBResourceURL url=paramRequest.getRenderUrl();
        url.setMode("detail");
        url.setParameter("uri", onew.getURI());
        String title=onew.getTitle();
        String pathPhoto = SWBPortal.getContextPath() + "/swbadmin/jsp/SWBNewsLite/sinfoto.png";
        String path = onew.getWorkPath();
        if (onew.getNewsThumbnail() != null)
        {
            int pos = onew.getNewsThumbnail().lastIndexOf("/");
            if (pos != -1)
            {
                String sphoto = onew.getNewsThumbnail().substring(pos + 1);
                onew.setNewsThumbnail(sphoto);
            }
            pathPhoto = SWBPortal.getWebWorkPath() + path + "/" + onew.getNewsThumbnail();
        }
        %>
          <div class="mainNews">
          <p><%=title%></p>
          <img src="<%=pathPhoto%>" alt="Imagen noticia" />
          <div class="clear">&nbsp;</div>
        </div>
          
        <%
    }
%>					


