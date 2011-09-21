<%@page import="org.semanticwb.platform.SemanticObject,org.semanticwb.portal.api.*,org.semanticwb.*,org.semanticwb.model.*" %>
<%@page import="org.semanticwb.portal.api.*,java.util.*,org.semanticwb.SWBPortal"%>
<%
    SWBParamRequest paramRequest = (SWBParamRequest) request.getAttribute("paramRequest");
    WebPage canal = paramRequest.getWebPage();
    User user = paramRequest.getUser();
    if(canal != null) {
        Iterator<WebPage> it = canal.listVisibleChilds(user.getLanguage());//lista los hijos del canal
        Iterator<WebPage> it2, it3;
        //Iterator<WebPage> it3;
        while(it.hasNext()) {
        WebPage ch = it.next();
        if(user.haveAccess(ch)) {
            it2 = ch.listVisibleChilds(user.getLanguage());//lista los nietos del canal
        %>
        <div class="indice">
            <div class="intro_indice">
                <h3 id="<%=(ch.getIconClass()== null ? "" : ch.getIconClass())%>"><a href="<%=ch.getUrl()%>"><%=ch.getDisplayName(user.getLanguage())%></a></h3>
                <p class="intro_line"><%=(ch.getDisplayDescription(user.getLanguage()) == null ? ((ch.getDescription()==null?"Falta descripción":(ch.getDescription().trim().length()<1?"Falta descripción":ch.getDescription()))) : (ch.getDisplayDescription(user.getLanguage()).trim().length() < 1 ?"Falta Descripcion" : ch.getDisplayDescription(user.getLanguage())))%></p>
            </div>
<%         if(it2.hasNext()) { 
%>          <div class="opciones">
<%            while(it2.hasNext()) {
                WebPage ch1 = it2.next(); int count = 0;
                if(user.haveAccess(ch1)) {
%>              <div class="opcion">
                    <h4><a href="<%=ch1.getUrl()%>"><%=ch1.getDisplayName(user.getLanguage())%></a></h4>
                    <p><%=(ch1.getDisplayDescription(user.getLanguage()) == null ? (ch1.getDescription()==null?"Falta descripción":(ch1.getDescription().trim().length() < 1 ?"Falta descripcion":ch1.getDescription())) : (ch1.getDisplayDescription(user.getLanguage()).trim().length() < 1 ? "Falta descripcion" : ch1.getDisplayDescription(user.getLanguage())))%></p>
<%                  it3 = ch1.listVisibleChilds(user.getLanguage());//lista los bisnietos del canal
                    if(it3.hasNext()) {
%>                  <ul>
<%                        while(it3.hasNext()&& count < 3) { count = count + 1;
                            WebPage ch2 = it3.next();
                            if(user.haveAccess(ch2)) {
%>                          <li><a href="<%=ch2.getUrl()%>"><%=ch2.getDisplayName(user.getLanguage())%></a></li>
<%                          }
                          }
%>                  </ul>
<%                  if(it3.hasNext()) {
%>
                    <a href="<%=ch1.getUrl()%>" class="ver_mas">Ver m&aacute;s</a>
<%                    }
                     }%>
                </div>
<%              }
              }
%>          </div>
<%           }
%>
        </div><div style="clear: both;"></div>
<%          }
        }
    }
%>
