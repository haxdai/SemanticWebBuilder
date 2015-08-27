<%-- 
    Document   : googlePlusTabs
    Created on : 18/08/2015, 12:32:51 PM
    Author     : jose.jimenez
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.semanticwb.*,org.semanticwb.platform.*,org.semanticwb.model.*,java.util.*,org.semanticwb.base.util.*,org.semanticwb.portal.api.*"%>
<%@page import="static org.semanticwb.social.admin.resources.GooglePlusWall.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%
    User user = SWBContext.getAdminUser();
    String lang = "es";
    lang = user.getLanguage();
    response.setHeader("Cache-Control", "no-cache"); 
    response.setHeader("Pragma", "no-cache"); 
    String objUri = request.getParameter("suri");
    String loading = "<BR/><center><img src='" + SWBPlatform.getContextPath() +
            "/swbadmin/images/loading.gif'/><center>";
    String model = SWBContext.WEBSITE_ADMIN;
    String webPageId = paramRequest.getWebPage().getId();
    //String resourcePath = "/" + lang + "/" + model + "/" + webPageId + "?";
    String resourcePath = paramRequest.getRenderUrl().setMode("getActivities").
                          setCallMethod(SWBParameters.Call_DIRECT).
                          setParameter("suri", URLEncoder.encode(request.getParameter("suri"))).
                          setParameter("contentTabId", HOME_TAB).toString();
%>
    <!--Div dummy para detectar evento de carga y modificar titulo -->
    <div dojoType="dijit.layout.ContentPane"/>

    <div class="swbform timelineCont" style="width : 1050px; overflow-y: hidden; height:500px;">
    <!--TODO:Modificar este codigo para recarga de clases, posible cambio por onLoad -->
        <script type="dojo/connect">
            this.watch("selectedChildWidget", function(name, oval, nval) {
                onClickTab(nval);
            });
        </script>
        <!-- usar un modo del recurso para llenar cada tab-->
        <div class="pub-redes" style="width: 650px !important; height:500px;" id="<%=objUri + HOME_TAB%>" dojoType="dijit.layout.ContentPane" title="<%=paramRequest.getLocaleString("myNovelties")%>" refreshOnShow="false" href="<%=resourcePath%>" _loadingMessage="<%=loading%>" style="overflow:auto;" style_="border:0px; width:100%; height:100%" onLoad_="onLoadTab(this);">
        </div>
        <!--div class="pub-redes" style="width: 400px; height:500px;" id="<%=objUri + FOLLOWERS_TAB %>" dojoType="dijit.layout.ContentPane" title="<%=paramRequest.getLocaleString("myFollowers")%>" refreshOnShow="false" href="<%=resourcePath + FOLLOWERS_TAB %>" _loadingMessage="<%=loading%>" style="overflow:auto;" style_="border:0px; width:100%; height:100%" onLoad_="onLoadTab(this);">
        </div-->
    </div><!-- end Bottom TabContainer -->

