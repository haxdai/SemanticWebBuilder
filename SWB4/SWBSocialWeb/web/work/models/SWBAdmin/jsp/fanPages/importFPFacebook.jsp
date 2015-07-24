<%-- 
    Document   : importFPFacebook
    Created on : 1/07/2014, 01:52:52 PM
    Author     : francisco.jimenez
--%>
<%@page import="org.semanticwb.social.admin.resources.ImportFanPages"%>
<%@page import="org.semanticwb.SWBPlatform"%>
<%@page import="org.semanticwb.social.SocialSite"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.social.SocialNetwork"%>
<%@page import="org.apache.commons.validator.UrlValidator"%>
<%@page import="org.semanticwb.social.util.SWBSocialUtil"%>
<%@page import="org.semanticwb.social.PostIn"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.model.SWBModel"%>
<%@page import="org.semanticwb.social.Facebook"%>
<%@page import="org.semanticwb.platform.SemanticObject"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.Reader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="org.semanticwb.portal.api.SWBParamRequest"%>
<%@page import="java.io.Writer"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>
<%@page import="java.util.HashMap"%>
<%@page import="static org.semanticwb.social.admin.resources.ImportFanPages.*"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONException"%>
<%@page import="org.json.JSONObject"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest"/>
<%@page contentType="text/html" pageEncoding="x-iso-8859-11"%>
<%
    String suri = request.getParameter("suri");
    SocialNetwork sn = (SocialNetwork) SemanticObject.createSemanticObject(suri).createGenericInstance();
    Facebook fb = null;
    if (!(sn instanceof Facebook)) {
        return;
    } else {
        fb = (Facebook) sn;
    }
    String wsite = fb.getSemanticObject().getModel().getName();
    WebSite website = WebSite.ClassMgr.getWebSite(wsite);
    SemanticObject sobj = SemanticObject.createSemanticObject(website.getURI());
    SWBResourceURL formAction = paramRequest.getActionUrl();
    System.out.println("suri en JSP: " + suri);
    if (website instanceof SocialSite) {
        formAction = formAction.setAction(IMPORT_FB_PAGES_FOR_ADMIN).setParameter("suri", suri);
        //System.out.println("---->SOCIALSITE");
    } else if(sobj.createGenericInstance() instanceof WebSite) {
        formAction = formAction.setAction(IMPORT_FB_PAGES).setParameter("suri", suri);
        //System.out.println("<----WEBSITE");
    }
    
    if (!fb.isSn_authenticated()) {
%>
    <div id="configuracion_redes">
        <p>La cuenta no ha sido autenticada correctamente.</p>
    </div>
<%
        return;
    }
    if (fb.isIsFanPage()) {
%>
    <div id="configuracion_redes">
        <p>Tu cuenta actual es una Fan Page, no puedes ejecutar esta acci&oacute;n.</p>
    </div>
<%
        return;
    }
    
    String pagePermissions = fb.hasPermissions(ImportFanPages.PERMISSIONS);
    if (!pagePermissions.equals("true")) {
        SWBResourceURL permissionURL = paramRequest.getRenderUrl().
                setMode("getPermission").
                setParameter("suri", suri).
                setParameter("permission", ImportFanPages.PERMISSIONS);
        if (pagePermissions.equals("declined")) {
            permissionURL = permissionURL.setParameter("retry", "true");
        }
%>
    <div id="configuracion_redes">
        <p>Para poder importar las p&aacute;ginas relacionadas a la cuenta configurada, es necesario que 
            proporciones los permisos necesarios, lo que puedes hacer si das clic 
            <a href="#" onclick="myFunction('<%=permissionURL.toString()%>&containerId='+this.parentElement.parentElement.parentElement.parentElement.parentElement.parentElement.id); return false;">
                aqu&iacute;</a>
        </p>
    </div>
<%
        return;
    }
    
    try {
        Iterator<Facebook> itFb = Facebook.ClassMgr.listFacebooks(website);
        StringBuilder sbFb = new StringBuilder(128);
        String fanPagesNames = null;
        while (itFb.hasNext()) {
            Facebook thisFb = itFb.next();
            if (thisFb.isIsFanPage()) {
                sbFb.append(thisFb.getTitle());
                sbFb.append("---");
            }
        }
        fanPagesNames = sbFb.toString();
        HashMap<String, String> params = new HashMap<String, String>(2);
        params.put("access_token", fb.getAccessToken());
        String respFanPage = fb.getRequest(params, Facebook.FACEBOOKGRAPH + "me/accounts",
                                Facebook.USER_AGENT);
        //System.out.println("Respuesta Fan pages: " + respFanPage);
        JSONObject responseFP = new JSONObject(respFanPage);
        if (!responseFP.isNull("data")) {
            if (responseFP.getJSONArray("data").length() > 0) {
                JSONArray jarr = responseFP.getJSONArray("data");
%>
<form name="formSites<%=fb.getFacebookUserId()%>" id="formSites<%=fb.getFacebookUserId()%>" action="<%=formAction%>" onsubmit="submitForm('formSites<%=fb.getFacebookUserId()%>'); try{document.getElementById('csLoading<%=fb.getFacebookUserId()%>').style.display='inline';}catch(noe){}; return false;">
<table width="50%" border="0px">
   <tr>
       <td colspan="3" style="text-align: center;" class="titulo">
           <div id="msj-eliminar">
                 <div class="bloque bloque2" style="margin-left: 20%;">
                    <p class="bloqtit">Paginas de Facebook</p>
                    <select name="pages" multiple size="5" class="bloqsel">
<%
                for (int i = 0 ; i <  jarr.length() ; i++) {
                    //System.out.println(jarr.getJSONObject(i));
                    JSONObject entryFP = jarr.getJSONObject(i);
                    if (!entryFP.isNull("id") && !entryFP.isNull("name") && !fanPagesNames.contains(entryFP.getString("name"))) {
%>
                        <option value="<%=entryFP.getString("id")%>"><%=entryFP.getString("name")%></option>
<%
                    }
                }
%>
                    </select>
                </div>
            </div>
       </td>
   </tr>
</table>
<input type="hidden" name="site" id="site" value="<%=wsite%>"/>
<div style="width:50%;" align="center">
    <button dojoType="dijit.form.Button" type="submit">Importar</button>
</div>
</form>

<div align="center">
    <span id="csLoading<%=fb.getFacebookUserId()%>" style="width: 100px; display: none" align="center">
        <img src="<%=SWBPlatform.getContextPath()%>/swbadmin/images/loading.gif"/>
    </span>
</div>
<%
            } else {
%>
            <div id="configuracion_redes">
            <p>La cuenta no tiene asociadas p&aacute;ginas de fans.</p>
            </div>
<%
            }
        } else {
%>
            <div id="configuracion_redes">
            <p>La cuenta no tiene asociadas p&aacute;ginas de fans.</p>
            </div>
<%
        }
    } catch (Exception e ) {
        out.print("Problem displaying News feed: " + e.getMessage());
    }
%>