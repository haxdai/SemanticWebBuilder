<%@page contentType="text/html" %>
<%@page import="org.semanticwb.model.Country"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="org.semanticwb.servlet.SWBHttpServletResponseWrapper"%>
<%@page import="org.semanticwb.portal.api.SWBResource"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.*"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="org.semanticwb.portal.resources.sem.favoriteWebPages.*"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="java.util.*"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.User"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    if (!paramRequest.getUser().isSigned())
    {
        return;
    }
    String mode = (String) request.getAttribute("mode");
    
    ArrayList<WebPage> pages = (ArrayList<WebPage>) request.getAttribute("pages");
    boolean exists = false;
    String id = paramRequest.getWebPage().getId();
    SWBResourceURL url = paramRequest.getActionUrl();
    //url.setCallMethod(url.Call_DIRECT);
    if (pages.contains(paramRequest.getWebPage()))
    {
        exists = true;
    }
    if (!exists)
    {
        url.setAction(SWBResourceURL.Action_ADD);
%>
        <div id="bm">
            <input type="button" value="agregar" title="Agregar a Favoritos - Se desplegará en la página principal según tu perfil" onClick="postHtml('<%=url%>','bm')" />
        </div>
<%                        
    }
    else
    {
        url.setAction(SWBResourceURL.Action_REMOVE);
%>
        <div id="bm">
            <input type="button" value="quitar" title="Eliminar de Favoritos" onClick="postHtml('<%=url%>','bm')" />
        </div>
<%
    }
%>