<%-- 
    Document   : facebookTabs
    Created on : 15/01/2014, 01:01:31 PM
    Author     : francisco.jimenez
--%>
<%@page import="org.semanticwb.social.Facebook"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.semanticwb.*,org.semanticwb.platform.*,org.semanticwb.model.*,java.util.*,org.semanticwb.base.util.*,org.semanticwb.portal.api.*"%>
<%@page import="static org.semanticwb.social.admin.resources.FacebookWall.*"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%!
    String replaceId(String id)
    {
        id=id.substring(id.lastIndexOf('/')+1);
        id=id.replace('#', ':');        
        return id;
    }
%>
<%
    User user = SWBContext.getAdminUser();
    if (user == null) {
        response.sendError(403);
        return;
    }
    String lang = "es";
    if (user != null) {
        lang = user.getLanguage();
    }
    response.setHeader("Cache-Control", "no-cache"); 
    response.setHeader("Pragma", "no-cache"); 

    String objUri = request.getParameter("suri");
    String model = SWBContext.WEBSITE_ADMIN;
    String webPageId = paramRequest.getWebPage().getId();
    String resourcePath = "/" + lang + "/" + model + "/" + webPageId + "?";
    String loading = "<BR/><center><img src='" + SWBPlatform.getContextPath() +
            "/swbadmin/images/loading.gif'/></center>";
    Facebook facebook = (Facebook) SemanticObject.createSemanticObject(objUri).createGenericInstance();
    String wallPermissions = !facebook.isIsFanPage() ? facebook.hasPermissions(WALL_PERMISSIONS) : "true";
    if (wallPermissions.equals("true")) {
        
        String username;
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("access_token", facebook.getAccessToken());
        String graphAnswer = postRequest(params, Facebook.FACEBOOKGRAPH + "me",
                            Facebook.USER_AGENT, "GET");
        JSONObject userObj = new JSONObject(graphAnswer);
        if (!userObj.isNull("name")) {
            username = userObj.getString("name");
        } else {
            username = facebook.getTitle();
        }
        
        String param = "suri=" + URLEncoder.encode(objUri) + "&title=" + URLEncoder.encode(username) + "&contentTabId=";
        
        //Div dummy para detectar evento de carga y modificar titulo
        out.println("<div dojoType=\"dijit.layout.ContentPane\"/>");

        //out.println("<div dojoType=\"dijit.layout.TabContainer\" region=\"center\" id=\""+replaceId(objUri)+"_tabs_twitter\">");
        if (facebook.isIsFanPage()) {
            out.println("<div class=\"swbform timelineCont\" style=\" width : 600px; overflow-y: hidden; height:500px;\">");
        } else {
            out.println("<div class=\"swbform timelineCont\" style=\" width : 2400px; overflow-y: hidden; height:500px;\">");
        }
        //TODO:Modificar este codigo para recarga de clases, posible cambio por onLoad
        out.println("    <script type=\"dojo/connect\">");
        out.println("       this.watch(\"selectedChildWidget\", function(name, oval, nval){");
        out.println("           onClickTab(nval);");
        out.println("       });    ");
        out.println("    </script>");

        if (facebook.isIsFanPage()) {
            out.println("<div class=\"pub-redes\" style=\"width: 600px; height:500px;\" id=\"" +
                    objUri + WALL_TAB + "\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
                    paramRequest.getLocaleString("myWall") + "\" refreshOnShow=\"" + "false" + "\" href=\"" +
                    resourcePath + param + WALL_TAB + "\" _loadingMessage=\"" + loading +
                    "\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
            out.println("</div>");
            out.println("    <script type=\"dojo/connect\">");
            out.println("       var facebook" + facebook.getId() + "Wall = dijit.byId('" + objUri + WALL_TAB + "')");
            out.println("    </script>");
        } else {
            //No se puede por permisos: read_stream
            //out.println("<div class=\"pub-redes\" style=\"width: 600px; height:500px;\" id=\"" +
            //objUri + NEWS_FEED_TAB + "\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
            //paramRequest.getLocaleString("newsFeed") + "\" refreshOnShow=\"" + "false" +
            //"\" href=\"" + resourcePath + param + NEWS_FEED_TAB + "\" _loadingMessage=\"" + loading +
            //"\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
            //out.println("</div>");

            out.println("<div class=\"pub-redes\" style=\"width:600px;height:500px;\" id=\"" +
                    objUri + WALL_TAB + "\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
                    paramRequest.getLocaleString("myWall") + "\" refreshOnShow=\"" + "false" +
                    "\" href=\"" + resourcePath + param + WALL_TAB + "\" _loadingMessage=\"" + loading +
                    "\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
            out.println("</div>");

            out.println("<div class=\"pub-redes\" style=\"width: 600px; height:500px;\" id=\"" +
                    objUri + PICTURES_TAB + "\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
                    paramRequest.getLocaleString("myImages") + "\" refreshOnShow=\"" + "false" +
                    "\" href=\"" + resourcePath + param + PICTURES_TAB + "\" _loadingMessage=\"" + loading +
                    "\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
            out.println("</div>");

            out.println("<div class=\"pub-redes\" style=\"width: 600px; height:500px;\" id=\"" +
                    objUri + VIDEOS_TAB + "\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
                    paramRequest.getLocaleString("myVideos") + "\" refreshOnShow=\"" + "false" +
                    "\" href=\"" + resourcePath + param + VIDEOS_TAB + "\" _loadingMessage=\"" + loading +
                    "\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
            out.println("</div>");

            out.println("<div class=\"pub-redes\" style=\"width: 400px; height:500px;\" id=\"" +
                    objUri + FRIENDS_TAB + "\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
                    paramRequest.getLocaleString("myConnections") + "\" refreshOnShow=\"" + "false" +
                    "\" href=\"" + resourcePath + param + FRIENDS_TAB + "\" _loadingMessage=\"" + loading +
                    "\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
            out.println("</div>");

    //No se puede, el endpoint quedo depreciado desde v2.0 del API de Facebook
    //        out.println("<div class=\"pub-redes\" style=\"width: 400px; height:500px;\" id=\"" +
    //        objUri + FOLLOWERS_TAB +"\" dojoType=\"dijit.layout.ContentPane\" title=\"" +
    //        paramRequest.getLocaleString("myConnections") + "\" refreshOnShow=\"" + "false" +
    //        "\" href=\"" + resourcePath + param + FOLLOWERS_TAB + "\" _loadingMessage=\"" + loading +
    //        "\" style=\"overflow:auto;\" style_=\"border:0px; width:100%; height:100%\" onLoad_=\"onLoadTab(this);\">");
    //        out.println("</div>");
        }
        out.println("</div><!-- end Bottom TabContainer -->");
    } else {
        SWBResourceURL permissionURL = paramRequest.getRenderUrl().
                setMode("getPermission").
                setParameter("suri", objUri).
                setParameter("currentTab", "facebook" + facebook.getId() + "Wall").
                setParameter("permission", WALL_PERMISSIONS);
        if (wallPermissions.equals("declined") || wallPermissions.equals("false")) {
            permissionURL = permissionURL.setParameter("retry", "true");
        }
        SWBResourceURL formReloadUrl = paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW);
%>
    <div id="<%=objUri%>checkPermission" dojoType="dijit.layout.ContentPane">
        <div align="center" style="margin-bottom: 10px;">
            <label>
                Para que cuentes con toda la funcionalidad de interacci&oacute;n con Facebook 
                (tus publicaciones, im&aacute;genes, videos, tus amigos y que puedas hacer 
                comentarios sobre diferentes elementos),
                se necesita que concedas los permisos correspondientes.
                Lo puedes hacer dando clic 
                <a href="#" onclick="myFunction('<%=permissionURL.toString()%>&containerId='+this.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id); return false;">aqu&iacute;</a>
            </label>
            
        </div>
    </div>
    <form id="permission<%=facebook.getEncodedURI()%>" action="<%=formReloadUrl.toString()%>"
          onsubmit="try{document.getElementById('csLoading<%=facebook.getEncodedURI()%>').style.display='inline';}catch(noe){}; setTimeout(function(){submitForm('permission<%=facebook.getEncodedURI()%>')},1000); return false;\">
        <input type="hidden" name="suri" value="<%=objUri%>">
    </form>
<%
        }
%>
