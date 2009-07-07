
package org.semanticwb.portal.admin.resources.reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.model.SWBContext;
import org.semanticwb.portal.util.WebSiteSectionTree;
import org.semanticwb.portal.util.SelectTree;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WBAContentsReport extends GenericResource {
    private static Logger log = SWBUtils.getLogger(WBASectionReport.class);

    private String strRscType;

    /*ContentMonitor content_mon=null;*/

    public WBAContentsReport() {
        /*content_mon = ContentMonitor.getInstance();*/
    }

    @Override
    public void init(){
        Resource base = getResourceBase();
        try {
            strRscType = base.getResourceType().getResourceClassName();
        }catch (Exception e) {
            strRscType = "WBAContentsReport";
        }
    }

    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        if(paramsRequest.getMode().equalsIgnoreCase("rendertree")) {
            doRenderSectionTree(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equalsIgnoreCase("fillgridmtr")) {
            doFillReport(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equalsIgnoreCase("report_excel")) {
            doRepExcel(request,response,paramsRequest);
        }else if(paramsRequest.getMode().equalsIgnoreCase("report_xml")) {
            doRepXml(request,response,paramsRequest);
        }else {
            super.processRequest(request, response, paramsRequest);
        }
    }

    private void doRenderSectionTree(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();

        String websiteId = request.getParameter("site");

        SWBResourceURL url=paramsRequest.getRenderUrl();
        url.setCallMethod(url.Call_DIRECT);
        url.setMode("rendertree");

        String section = request.getParameter("reptp");
        if(section != null) {
            out.println("<input type=\"hidden\" name=\"section\" id=\"section\" value=\""+section+"\" />");
        }

        HashMap params = new HashMap();
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()) {
            String name = names.nextElement();
            params.put(name, request.getParameter(name));
        }
        SelectTree tree = new SelectTree(paramsRequest.getUser().getLanguage());
        out.println(tree.renderXHTML(websiteId, params, url.toString()));
        out.flush();
        out.close();
    }

    private void doFillReport(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {
        response.setContentType("text/json;charset=iso-8859-1");
        String lang = paramsRequest.getUser().getLanguage();
        JSONObject jobj = new JSONObject();
        JSONArray jarr = new JSONArray();
        try {
            //jobj.put("identifier", "uri");
            jobj.put("label", "sect");
            jobj.put("items", jarr);
        }catch (JSONException jse) {
        }
        
        String websiteId = request.getParameter("site");
        WebSite webSite = SWBContext.getWebSite(websiteId);
        String webPageId = request.getParameter("section");
        WebPage webPage = webSite.getWebPage(webPageId);

        Iterator<Resource> portlets = webPage.listResources();
        while(portlets.hasNext()) {
            Resource portlet = portlets.next();
            if(portlet.getResourceType().getResourceMode()==1) {
                JSONObject obj = new JSONObject();
                try {
                    obj.put("id", portlet.getId());
                    obj.put("sect", webPage.getDisplayName(lang));
                    obj.put("tipo", portlet.getResourceType().getDisplayTitle(lang));
                    obj.put("contenido", portlet.getDisplayTitle(lang));
                    obj.put("prior", portlet.getPriority());
                    obj.put("active", portlet.isActive()?"Si":"No");
                    obj.put("loc", portlet.getWorkPath());
                    obj.put("uri", portlet.getURI());
                    obj.put("breaken", "No");
                    jarr.put(obj);
                }catch (JSONException jsone) {
                }

            }
        }
        if(request.getParameter("sons")!=null && request.getParameter("sons").equalsIgnoreCase("1")) {
            doDataStore(webPage, jarr, lang);
        }
        response.getOutputStream().println(jobj.toString());
    }

    private void doDataStore(WebPage node, JSONArray jarr, final String lang) {
        Iterator<WebPage> childs = node.listVisibleChilds(lang);
        while(childs.hasNext()) {
            WebPage webPage = childs.next();
            Iterator<Resource> portlets = webPage.listResources();
            while(portlets.hasNext()) {
                Resource portlet = portlets.next();
                if(portlet.getResourceType().getResourceMode()==1) {
                    JSONObject obj = new JSONObject();
                    try {
                        obj.put("id", portlet.getId());
                        obj.put("sect", webPage.getDisplayName(lang));
                        obj.put("tipo", portlet.getResourceType().getDisplayTitle(lang));
                        obj.put("contenido", portlet.getDisplayTitle(lang));
                        obj.put("prior", portlet.getPriority());
                        obj.put("active", portlet.isActive()?"Si":"No");
                        obj.put("loc", portlet.getWorkPath());
                        obj.put("uri", portlet.getURI());
                        obj.put("breaken", "No");
                        jarr. put(obj);
                    }catch (JSONException jsone) {
                    }
                }
            }
            if(webPage.listChilds().hasNext()) {
                doDataStore(webPage, jarr, lang);
            }
        }
    }

    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("text/html;charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();

        final int I_ACCESS = 0;
        HashMap hm_sites = new HashMap();
        String rtype = null;
        String language = paramsRequest.getUser().getLanguage();

        try {
            // Evaluates if there are sites
            Iterator<WebSite> webSites = SWBContext.listWebSites();
            while(webSites.hasNext()) {
                WebSite site = webSites.next();
                // Evaluates if TopicMap is not Global
                if(!site.getId().equals(SWBContext.getGlobalWebSite().getId())) {
                    // Get access level of this user on this topicmap and if level is greater than "0" then user have access
                    // TODO
//                    i_access = AdmFilterMgr.getInstance().haveAccess2TopicMap(paramsRequest.getUser(),site.getDbdata().getId());
//                    if(I_ACCESS < i_access) {
//                        if(site.getDbdata().getDeleted()==0) {
                            hm_sites.put(site.getId(), site.getDisplayTitle(language));
//                        }
//                    }
                }
            }

            // If there are sites continue
            if(hm_sites.size() > I_ACCESS) {
                String address = paramsRequest.getTopic().getUrl();
                String websiteId = request.getParameter("wb_site")==null ? (String)hm_sites.keySet().iterator().next():request.getParameter("wb_site");

                String topicId = paramsRequest.getTopic().getId();
                if(topicId.lastIndexOf("Daily") != -1) {
                    rtype = "0";
                }else if(topicId.lastIndexOf("Monthly") != -1) {
                    rtype = "1";
                }else {
                    rtype = request.getParameter("wb_rtype");
                }
                if(rtype == null) {
                    rtype = "0";
                }

                SWBResourceURL url = paramsRequest.getRenderUrl();
                url.setCallMethod(url.Call_DIRECT);

                out.println("<script type=\"text/javascript\">");

                out.println("dojo.require(\"dojox.grid.DataGrid\");");
                out.println("dojo.require(\"dojo.data.ItemFileReadStore\");");

                out.println("dojo.addOnLoad(function(){renderTreeSectionsSite('"+url.toString()+"', 'rendertree','"+websiteId+"','slave')});");

                out.println("function renderTreeSectionsSite(url, mode, site, canvasId) {");
                out.println("   postHtml(url+'/_mod/'+mode+'?site='+site, canvasId);");
                out.println("}");

                out.println("function fillGrid(grid, uri, mode, params) {");
                out.println("   grid.store = new dojo.data.ItemFileReadStore({url: uri+'/_mod/'+mode+'?'+params});");
                //out.println("   grid.store = new dojo.data.ItemFileReadStore({url: \"/swb/ice_cream.json\" });");
                out.println("   grid._refresh();");
                out.println("}");

                out.println("var layout= null;");
                out.println("var jStrMaster = null;");
                out.println("var gridMaster = null;");
                out.println("var gridResources = null;");

                out.println("dojo.addOnLoad(function() {");
                out.println("   layout= [");
                out.println("      { field:\"sect\", width:\"100px\", name:\"Sección\" },");
                out.println("      { field:\"id\", width:\"50px\", name:\"Id\" },");
                out.println("      { field:\"tipo\", width:\"100px\", name:\"Tipo contenido\" },");
                out.println("      { field:\"contenido\", width:\"100px\", name:\"Contenido\" },");
                out.println("      { field:\"prior\", width:\"50px\", name:\"Prioridad\" },");
                out.println("      { field:\"active\", width:\"50px\", name:\"Activo\" },");
                out.println("      { field:\"loc\", width:\"100px\", name:\"Localidad\" },");
                out.println("      { field:\"uri\", width:\"150px\", name:\"Uri\" },");
                out.println("      { field:\"breaken\", width: \"50px\", name:\"Liga rota\" },");
                out.println("   ];");

                out.println("   gridMaster = new dojox.grid.DataGrid({");
                out.println("      id: \"gridMaster\",");
                //out.println("      store: jStrMaster,");
                out.println("      structure: layout,");
                out.println("      rowSelector: \"10px\",");
                out.println("      rowsPerPage: \"15\"");
                out.println("   }, \"gridMaster\");");
                out.println("   gridMaster.startup();");
                //out.println("    dojo.connect(dijit.byId('gridMaster'), 'onRowDblClick', getResources);");
                out.println("});");

                out.println("function doXml(size) { ");
                out.println("   var params = '?site='+dojo.byId('wb_site').value;");
                out.println("   if(dojo.byId('section')) {");
                out.println("      params += '&section=' + dojo.byId('section').value;");
                out.println("      if(dojo.byId('wb_show_son').checked) {");
                out.println("         params += '&sons=' + dojo.byId('wb_show_son').value;");
                out.println("      }");
                out.println("      window.open(\"" + paramsRequest.getRenderUrl().setCallMethod(paramsRequest.Call_DIRECT).setMode("report_xml") + "\"+params,\"graphWindow\",size);");
                out.println("   }else {");
                out.println("      alert('Para poder mostrarle el resumen de contenido, primero debe seleccionar una sección');");
                out.println("   }");
                out.println("}");

                out.println("function doExcel(size) { ");
                out.println("   var params = '?site='+dojo.byId('wb_site').value;");
                out.println("   if(dojo.byId('section')) {");
                out.println("      params += '&section=' + dojo.byId('section').value;");
                out.println("      if(dojo.byId('wb_show_son').checked) {");
                out.println("         params += '&sons=' + dojo.byId('wb_show_son').value;");
                out.println("      }");
                out.println("      window.open(\"" + paramsRequest.getRenderUrl().setCallMethod(paramsRequest.Call_DIRECT).setMode("report_excel") + "\"+params,\"graphWindow\",size);");
                out.println("   }else {");
                out.println("      alert('Para poder mostrarle el resumen de contenido, primero debe seleccionar una sección');");
                out.println("   }");
                out.println("}");

                out.println("function doApply() {");
                out.println("   var grid = dijit.byId('gridMaster');");
                out.println("   var params = 'site='+dojo.byId('wb_site').value;");

                out.println("   if(dojo.byId('section')) {");
                //out.println("      dojo.byId('ctnergrid').style.display = 'block';");
                out.println("      params += '&section=' + dojo.byId('section').value;");
                out.println("      if(dojo.byId('wb_show_son').checked) {");
                out.println("         params += '&sons=' + dojo.byId('wb_show_son').value;");
                out.println("      }");
                out.println("      fillGrid(grid, '"+url.toString()+"', 'fillgridmtr', params);");
                out.println("   }else {");
                out.println("      alert('Para poder mostrarle el resumen de contenido, primero debe seleccionar una sección');");
                out.println("   }");
                out.println("}");

                out.println("</script>");
                // javascript

                out.println("<div class=\"swbform\">");
                out.println("<fieldset>");
                out.println(paramsRequest.getLocaleString("description"));
                out.println("</fieldset>");

                out.println("<form id=\"frmrep\" name=\"frmrep\" method=\"post\" action=\"" + address + "\">");
                out.println("<fieldset>");
                out.println("<legend>" + paramsRequest.getLocaleString("contents_report") + "</legend>");
                /*out.println("<form id=\"frmrep\" name=\"frmrep\" method=\"post\" action=\"" + address + "\">");*/
                out.println("<table border=\"0\" width=\"95%\" align=\"center\">");
                out.println("<tr><td width=\"100\"></td><td width=\"200\"></td><td width=\"224\"></td><td width=\"264\"></td></tr>");

                /*out.println("<tr>");
                out.println("<td colspan=\"4\">");
                out.println(paramsRequest.getLocaleString("description"));
                out.println("</td></tr>");*/

                /*out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");
                out.println("<tr>");
                out.println(" <td colspan=\"4\">&nbsp;&nbsp;&nbsp;");
                out.println("   <input type=\"button\" onClick=\"doXml('width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\" value=\"XML\" name=\"btnXml\" />&nbsp;");
                out.println("   <input type=\"button\" onClick=\"doExcel('width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\" value=\"Excel\" name=\"btnExcel\" />&nbsp;");
                out.println("   <input type=\"button\" onClick=\"doApply()\" value=\"" + paramsRequest.getLocaleString("apply") + "\" name=\"btnApply\" />");
                out.println("   <input type=\"hidden\" name=\"tp\" id=\"tp\" />");
                out.println(" </td>");
                out.println("</tr>");
                out.println("<tr><td colspan=\"4\">&nbsp;</td></tr>");*/

                out.println("<tr>");
                out.println("<td>" + paramsRequest.getLocaleString("site") + ":</td>");
                //url.setMode("rendertree");
                out.println("<td colspan=\"2\"><select id=\"wb_site\" name=\"wb_site\" onchange=\"renderTreeSectionsSite('"+url.toString()+"', 'rendertree', this.value, 'slave');\">");
                Iterator<String> itKeys = hm_sites.keySet().iterator();
                while(itKeys.hasNext()) {
                    String key = itKeys.next();
                    out.println("<option value=\"" + key + "\"");
                    if(key.equalsIgnoreCase(websiteId)) {
                        out.println(" selected=\"selected\"");
                    }
                    out.println(">" + (String)hm_sites.get(key) + "</option>");
                }
                out.println("</select>");
                out.println("</td>");
                out.println("<td>&nbsp;</td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td>" + paramsRequest.getLocaleString("section") + ":</td>");
                out.println("<td colspan=\"3\"><div id=\"slave\"></div></td>");
                out.println("</tr>");

                out.println("<tr>");
                out.println("<td colspan=\"4\"><input type=\"checkbox\" id=\"wb_show_son\" name=\"wb_show_son\" value=\"1\" />");
                out.println("<label for=\"wb_show_son\">"+paramsRequest.getLocaleString("descendant")+"</label>");
                out.println("</td>");
                out.println("</tr>");
                out.println("<tr><td colspan=\"4\"><br /></td></tr>");
                out.println("</table></fieldset>");

                out.println("<fieldset>");
                out.println("<table border=\"0\" width=\"95%\">");
                out.println("<tr>");
                out.println(" <td colspan=\"4\">&nbsp;&nbsp;&nbsp;");
                out.println("   <button dojoType=\"dijit.form.Button\" onClick=\"doXml('width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">XML</button>&nbsp;");
                out.println("   <button dojoType=\"dijit.form.Button\" onClick=\"doExcel('width=600, height=550, scrollbars, resizable, alwaysRaised, menubar')\">MS Excel</button>&nbsp;");
                out.println("   <button dojoType=\"dijit.form.Button\" onClick=\"doApply()\">"+paramsRequest.getLocaleString("apply")+"</button>");
                out.println("   <input type=\"hidden\" name=\"tp\" id=\"tp\" />");
                out.println(" </td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</fieldset>");
                out.println("</form>");

                /*out.println("<tr><td colspan=\"4\" height=\"15\"><hr size=\"1\" noshade></td></tr>");*/
                out.println("<fieldset>");
                out.println("<table border=\"0\" width=\"95%\" align=\"center\">");
                out.println("<tr>");
                out.println("<td colspan=\"4\">");
                out.println("<div id=\"ctnergrid\" style=\"height:250px; width:98%; margin: 1px; padding: 0px; border: 1px solid #DAE1FE;\">");
                out.println("  <div id=\"gridMaster\"></div>");
                out.println("</div>");
                out.println("</td>");
                out.println("</tr>");
                out.println("</table>");
                out.println("</fieldset>");

                /*out.println("<tr><td colspan=\"4\"><br /></td></tr>");
                out.println("</table></form></fieldset>");*/
                out.println("</div>");
            }
        }catch (Exception e) {
            log.error("Error on method doView() resource " + strRscType + " with id " + base.getId(), e);
        }
        out.flush();
        out.close();
    }


    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doRepExcel(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=\"ic.xls\"");
        PrintWriter out = response.getWriter();
        StringBuilder html = new StringBuilder();
        String language = paramsRequest.getUser().getLanguage();


        out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        out.println("<head>");
        out.println("<title>"+paramsRequest.getLocaleString("contents_report")+"</title>");
        out.println("</head>");
        out.println("<body>");

        html.append("<table border=\"0\" width=\"95%\">");
        html.append("<tr>");
        html.append("  <th>Sección</th>");
        html.append("  <th>Id</th>");
        html.append("  <th>Tipo contenido</th>");
        html.append("  <th>Contenido</th>");
        html.append("  <th>Prioridad</th>");
        html.append("  <th>Activo</th>");
        html.append("  <th>Localidad</th>");
        html.append("  <th>Uri</th>");
        html.append("  <th>Liga rota</th>");
        html.append("</tr>");

        String websiteId = request.getParameter("site");
        WebSite webSite = SWBContext.getWebSite(websiteId);
        String webPageId = request.getParameter("section");
        WebPage webPage = webSite.getWebPage(webPageId);
        Iterator<Resource> portlets = webPage.listResources();
        while(portlets.hasNext()) {
            Resource portlet = portlets.next();
            if(portlet.getResourceType().getResourceMode()==1) {
                html.append("<tr>");
                html.append("  <td>"+webPage.getDisplayTitle(language)+"</td>");
                html.append("  <td>"+portlet.getId()+"</td>");
                html.append("  <td>"+portlet.getResourceType().getDisplayTitle(language)+"</td>");
                html.append("  <td>"+portlet.getDisplayTitle(language)+"</td>");
                html.append("  <td>"+portlet.getPriority()+"</td>");
                html.append("  <td>"+(portlet.isActive()?"Si":"No")+"</td>");
                html.append("  <td>"+portlet.getWorkPath()+"</td>");
                html.append("  <td>"+portlet.getURI()+"</td>");
                html.append("  <td>No</td>");
                html.append("</tr>");

            }
        }

        if(request.getParameter("sons")!=null && request.getParameter("sons").equalsIgnoreCase("1")) {
            html.append(getContentInHtml(webPage.listChilds(), language));
        }

        html.append("</table>");
        out.print(html.toString());
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    private String getContentInHtml(Iterator<WebPage> childs, String language) {
        StringBuilder html = new StringBuilder();
        while(childs.hasNext()) {
            WebPage webPage = childs.next();
            Iterator<Resource> portlets = webPage.listResources();
            while(portlets.hasNext()) {
                Resource portlet = portlets.next();
                if(portlet.getResourceType().getResourceMode()==1) {
                    html.append("<tr>");
                    html.append("  <td>"+webPage.getDisplayTitle(language)+"</td>");
                    html.append("  <td>"+portlet.getId()+"</td>");
                    html.append("  <td>"+portlet.getResourceType().getDisplayTitle(language)+"</td>");
                    html.append("  <td>"+portlet.getDisplayTitle(language)+"</td>");
                    html.append("  <td>"+portlet.getPriority()+"</td>");
                    html.append("  <td>"+(portlet.isActive()?"Si":"No")+"</td>");
                    html.append("  <td>"+portlet.getWorkPath()+"</td>");
                    html.append("  <td>"+portlet.getURI()+"</td>");
                    html.append("  <td>No</td>");
                    html.append("</tr>");
                }
            }
            if(webPage.listChilds().hasNext()) {
                html.append(getContentInHtml(webPage.listChilds(), language));
            }
        }
        return html.toString();
    }

    /**
     * @param request
     * @param response
     * @param paramsRequest
     * @throws SWBResourceException
     * @throws IOException
     */
    public void doRepXml(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException{
        response.setContentType("text/xml;charset=iso-8859-1");
        PrintWriter out = response.getWriter();
        Document dom = SWBUtils.XML.getNewDocument();
        String language = paramsRequest.getUser().getLanguage();

        Element report = dom.createElement("ContentReport");
        dom.appendChild(report);

        String websiteId = request.getParameter("site");
        WebSite webSite = SWBContext.getWebSite(websiteId);
        String webPageId = request.getParameter("section");
        WebPage webPage = webSite.getWebPage(webPageId);
        Iterator<Resource> portlets = webPage.listResources();
        while(portlets.hasNext()) {
            Resource portlet = portlets.next();
            if(portlet.getResourceType().getResourceMode()==1) {
                Element resource = dom.createElement("resource");
                resource.appendChild(dom.createTextNode(""));
                report.appendChild(resource);

                Element section = dom.createElement("section");
                section.appendChild(dom.createTextNode(webPage.getDisplayTitle(language)));
                resource.appendChild(section);
                Element id = dom.createElement("id");
                id.appendChild(dom.createTextNode(portlet.getId()));
                resource.appendChild(id);
                Element tipo = dom.createElement("type");
                tipo.appendChild(dom.createTextNode(portlet.getResourceType().getDisplayTitle(language)));
                resource.appendChild(tipo);
                Element contenido = dom.createElement("content");
                contenido.appendChild(dom.createTextNode(portlet.getDisplayTitle(language)));
                resource.appendChild(contenido);
                Element prior = dom.createElement("priority");
                prior.appendChild(dom.createTextNode(Integer.toString(portlet.getPriority())));
                resource.appendChild(prior);
                Element active = dom.createElement("active");
                active.appendChild(dom.createTextNode(portlet.isActive()?"Si":"No"));
                resource.appendChild(active);
                Element loc = dom.createElement("location");
                loc.appendChild(dom.createTextNode(portlet.getWorkPath()));
                resource.appendChild(loc);
                Element uri = dom.createElement("uri");
                uri.appendChild(dom.createTextNode(portlet.getURI()));
                resource.appendChild(uri);
                Element broke = dom.createElement("broke");
                broke.appendChild(dom.createTextNode("No"));
                resource.appendChild(broke);
            }
        }

        if(request.getParameter("sons")!=null && request.getParameter("sons").equalsIgnoreCase("1")) {
            getContentInXml(dom, webPage.listChilds(), language);
        }

        out.print(SWBUtils.XML.domToXml(dom));
        out.flush();
        out.close();
    }

    private void getContentInXml(Document dom, Iterator<WebPage> childs, String language) {
        Element report = dom.getDocumentElement();
        while(childs.hasNext()) {
            WebPage webPage = childs.next();
            Iterator<Resource> portlets = webPage.listResources();
            while(portlets.hasNext()) {
                Resource portlet = portlets.next();
                if(portlet.getResourceType().getResourceMode()==1) {
                    Element resource = dom.createElement("resource");
                    resource.appendChild(dom.createTextNode(""));
                    report.appendChild(resource);

                    Element section = dom.createElement("section");
                    section.appendChild(dom.createTextNode(webPage.getDisplayTitle(language)));
                    resource.appendChild(section);
                    Element id = dom.createElement("id");
                    id.appendChild(dom.createTextNode(portlet.getId()));
                    resource.appendChild(id);
                    Element tipo = dom.createElement("type");
                    tipo.appendChild(dom.createTextNode(portlet.getResourceType().getDisplayTitle(language)));
                    resource.appendChild(tipo);
                    Element contenido = dom.createElement("content");
                    contenido.appendChild(dom.createTextNode(portlet.getDisplayTitle(language)));
                    resource.appendChild(contenido);
                    Element prior = dom.createElement("priority");
                    prior.appendChild(dom.createTextNode(Integer.toString(portlet.getPriority())));
                    resource.appendChild(prior);
                    Element active = dom.createElement("active");
                    active.appendChild(dom.createTextNode(portlet.isActive()?"Si":"No"));
                    resource.appendChild(active);
                    Element loc = dom.createElement("location");
                    loc.appendChild(dom.createTextNode(portlet.getWorkPath()));
                    resource.appendChild(loc);
                    Element uri = dom.createElement("uri");
                    uri.appendChild(dom.createTextNode(portlet.getURI()));
                    resource.appendChild(uri);
                    Element broke = dom.createElement("broke");
                    broke.appendChild(dom.createTextNode("No"));
                    resource.appendChild(broke);
                }
            }
            if(webPage.listChilds().hasNext()) {
                getContentInXml(dom, webPage.listChilds(), language);
            }
        }
    }


    public boolean hasBrokenLinks(ArrayList p_datapage, int p_page, String p_content, String p_site) {
        boolean b_return = false;
        /*ContentMonitor content_mon = null;
        int i_size = 0;
        int i_inipage = 0;
        int i_finpage = 0;
        long l_id = 0;

        if(p_content.equals("WBUrlContent") || p_content.equals("FrameContent")){
            content_mon = new ContentMonitor();
            i_size = p_datapage.size();
            i_inipage =  I_PAGE_SIZE * p_page;
            i_finpage = i_size;
            if((i_inipage + I_PAGE_SIZE) < i_finpage){
                i_finpage = i_inipage + I_PAGE_SIZE;
            }
            for(int j=i_inipage;j<i_finpage;j++){
                String[] arr_data = (String[])p_datapage.get(j);
                l_id = Long.parseLong(arr_data[0]);
                if(content_mon.isRemoteContentLinkBreak(p_site,l_id)){
                    b_return = true;
                    break;
                }
            }
        }*/
        return b_return;
    }

    private class Bool {
        private boolean first;

        public Bool() {
            first = true;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst() {
            first = false;
        }

    }
}