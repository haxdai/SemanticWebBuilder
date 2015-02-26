/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.bsc.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.Detailed;
import org.semanticwb.bsc.Theme;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author carlos.ramos
 */
public class VectorStrategicDeploymentResource extends GenericResource {
    private static final Logger log = SWBUtils.getLogger(VectorStrategicDeploymentResource.class);
    
    private String urlObjectivePage = null;
    private String urlThemePage = null;

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        urlObjectivePage = base.getWebSite().getWebPage(Objective.class.getSimpleName()).getUrl();
        urlThemePage = base.getWebSite().getWebPage(Theme.class.getSimpleName()).getUrl();
    }
    
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        final String suri = request.getParameter("suri");
        if(suri==null) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNoSuchSemanticElement")+"</div>");
            response.flushBuffer();
            return;
        }
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        if(semObj==null || !(semObj.getGenericInstance() instanceof Theme)) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNoSuchSemanticElement")+"</div>");
            return;
        }
        Theme theme = (Theme)semObj.getGenericInstance();
        
        final User user = paramRequest.getUser();
        if(!user.isSigned() || !user.haveAccess(theme))     {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgUserHasNotPermissions")+"</div>");
            response.flushBuffer();
            return;
        }
        final String lang = user.getLanguage();
        final Period period = getPeriod(request);
        final BSC scorecard = (BSC)getResourceBase().getWebSite();
        Document map = scorecard.getDom(period);
        
//out.println("<div class=\"container\">");
//out.println("  <div class=\"row impactMapProperties\">");
//List<State>states = sg.listValidStates();
//out.println("  <div class=\"col-xs-8 col-xs-offset-4\">");
//for(State state:states) {
//    out.print("    <span class=\"label swbstrgy-semaphore ");
//    out.print(state.getIconClass());
//    out.println("\">");
//    out.println(state.getDisplayTitle(lang)==null?state.getTitle():state.getDisplayTitle(lang));
//    out.print("</span>");
//}
//out.println("   </div>");
//out.println("  </div> <!-- /.row -->");
//out.println("</div> <!-- /.container -->");
        
        out.println("<div class=\"list-group\">");
        out.println("<a href=\""+urlThemePage+"?suri="+theme.getEncodedURI()+"\" class=\"list-group-item active\">");
        out.println("<h4 class=\"list-group-item-heading\">"+theme.getDisplayTitle(lang)+"</h4>");
        out.println("<p class=\"list-group-item-text\">"+(theme.getDisplayDescription(lang)==null?"":theme.getDisplayDescription(lang))+"</p>");
        out.println("</a>");
        try {
            Iterator<Content> valueChain = valueChain(theme.getURI(), "theme", map, period, lang).iterator();
            while(valueChain.hasNext()) {
                Content content = valueChain.next();
                
                out.println("<a href=\""+content.getUrl()+"\" ");
                out.println(" title=\""+paramRequest.getLocaleString("msgViewDetails")+"\"");
                out.println(" class=\"list-group-item\">");
                out.println("<h4 class=\"list-group-item-heading\">");
                out.println("<span class=\""+content.getIcon()+"\"></span>");
                out.println("<span class=\"small\">"+content.getStatus()+".</span>&nbsp;");
                out.println(content.getPrefix()+" - "+content.getTitle());
                out.println("</h4>");
                out.println("<p class=\"list-group-item-text\">"+content.getDesc()+"</p>");
                out.println("</a>");
            }
        }catch(XPathExpressionException xpe) {
            log.error(xpe);
            out.println(xpe.getMessage());
        }
        out.println("</div>");
    }
    
    private List<Content> valueChain(String uri, String type, Document map, Period period, String lang) throws XPathExpressionException
    {
        List<Content> valueChain = new ArrayList<Content>();
        XPath xPath = XPathFactory.newInstance().newXPath();
        Objective obj;
        Node node;
        NamedNodeMap attrs;
        SemanticOntology ont;
        SemanticObject semObj;
        String expression, url;
        Content content;
        
        ont = SWBPlatform.getSemanticMgr().getOntology();
        expression = "//rel[@to='"+uri+"' and @type='"+type+"']/..";
        NodeList nList = (NodeList) xPath.compile(expression).evaluate(map, XPathConstants.NODESET);
        for(int k=0; k<nList.getLength(); k++) {
            node = nList.item(k);
            if(node!=null && node.getNodeType()==Node.ELEMENT_NODE) {
                attrs = node.getAttributes();
                url = urlObjectivePage+"?suri="+attrs.getNamedItem("href").getNodeValue();
                semObj = ont.getSemanticObject(attrs.getNamedItem("id").getNodeValue());
                obj = (Objective)semObj.getGenericInstance();
                if(!obj.hasPeriod(period)) {
                    continue;
                }
                content = new Content(((Detailed)obj).getStatusIconClass(period)
                        , ((Detailed)obj).getStatusTitle(period)
                        , obj.getPrefix()
                        , obj.getDisplayTitle(lang)
                        , obj.getDisplayDescription(lang)
                        , url);
                valueChain.add(content);
                valueChain.addAll(valueChain(obj.getURI(), "objective", map, period, lang));
            }
        }
        return valueChain;
    }
    
    /**
     * Obtiene el periodo seleccionado actual
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param ws sitio web
     * @return un objeto {@code Periodo} que representa el Periodo actual
     * seleccionado
     */
    private Period getPeriod(HttpServletRequest request) {
        WebSite model = getResourceBase().getWebSite();
        Period period = null;
        HttpSession session = request.getSession(true);
        final String pid = (String) session.getAttribute(model.getId());
        if (Period.ClassMgr.hasPeriod(pid, model)) {
            period = Period.ClassMgr.getPeriod(pid, model);
        }
        if(period == null) {
            BSC scorecard = (BSC)model;
            try {
                period = scorecard.listPeriods().next();
            }catch(NoSuchElementException nsee) {
            }
        }
        return period;
    }
    
    private class Content {
        private String icon;
        private String status;
        private String prefix;
        private String title;
        private String desc;
        private String url;
        
        Content(String icon
                , String status
                , String prefix
                , String title
                , String desc
                , String url)
        {
            this.icon = icon;
            this.status = status;
            this.prefix = prefix;
            this.title = title;
            this.desc = desc;
            this.url = url;
        }

        /**
         * @return the title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param title the title to set
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         * @return the desc
         */
        public String getDesc() {
            return desc==null?"":desc;
        }

        /**
         * @param desc the desc to set
         */
        public void setDesc(String desc) {
            this.desc = desc;
        }

        /**
         * @return the url
         */
        public String getUrl() {
            return url;
        }

        /**
         * @param url the url to set
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * @return the prefix
         */
        public String getPrefix() {
            return prefix;
        }

        /**
         * @param prefix the prefix to set
         */
        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }

        /**
         * @return the icon
         */
        public String getIcon() {
            return icon;
        }

        /**
         * @param icon the icon to set
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }
        
        /**
         * @return the status
         */
        public String getStatus() {
            return status;
        }

        /**
         * @param status the icon to set
         */
        public void setStatus(String status) {
            this.status = status;
        }
    }
}
