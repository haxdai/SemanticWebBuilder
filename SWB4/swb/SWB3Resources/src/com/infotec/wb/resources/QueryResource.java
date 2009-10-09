/**  
* SemanticWebBuilder es una plataforma para el desarrollo de portales y aplicaciones de integración, 
* colaboración y conocimiento, que gracias al uso de tecnología semántica puede generar contextos de 
* información alrededor de algún tema de interés o bien integrar información y aplicaciones de diferentes 
* fuentes, donde a la información se le asigna un significado, de forma que pueda ser interpretada y 
* procesada por personas y/o sistemas, es una creación original del Fondo de Información y Documentación 
* para la Industria INFOTEC, cuyo registro se encuentra actualmente en trámite. 
* 
* INFOTEC pone a su disposición la herramienta SemanticWebBuilder a través de su licenciamiento abierto al público (‘open source’), 
* en virtud del cual, usted podrá usarlo en las mismas condiciones con que INFOTEC lo ha diseñado y puesto a su disposición; 
* aprender de él; distribuirlo a terceros; acceder a su código fuente y modificarlo, y combinarlo o enlazarlo con otro software, 
* todo ello de conformidad con los términos y condiciones de la LICENCIA ABIERTA AL PÚBLICO que otorga INFOTEC para la utilización 
* del SemanticWebBuilder 4.0. 
* 
* INFOTEC no otorga garantía sobre SemanticWebBuilder, de ninguna especie y naturaleza, ni implícita ni explícita, 
* siendo usted completamente responsable de la utilización que le dé y asumiendo la totalidad de los riesgos que puedan derivar 
* de la misma. 
* 
* Si usted tiene cualquier duda o comentario sobre SemanticWebBuilder, INFOTEC pone a su disposición la siguiente 
* dirección electrónica: 
*  http://www.semanticwebbuilder.org
**/ 
 


package com.infotec.wb.resources;

import java.io.*;
import java.sql.*;
import javax.servlet.http.*;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/** Despliega el resultado de un query proporcionado por el usuario.
 *
 * Displays results of a database query provided by the user.
 *
 * @author: Javier Solis
 * @version 1.1
 */
public class QueryResource extends GenericAdmResource {
    
    /**
     * Format data template.
     */
    private javax.xml.transform.Templates tpl;

    /**
     * XML form definition data.
     */
    private String xml;
    String path = SWBPlatform.getContextPath() +"swbadmin/xsl/QueryResource/";
    private static Logger log = SWBUtils.getLogger(QueryResource.class);
    
    /** 
     * Creates a new instance of QueryResource
     */
    public QueryResource() {
    }

    @Override
    public void setResourceBase(Resource base) {
        try {
            super.setResourceBase(base);
        } catch(Exception e) {
            log.error("Error while setting resource base: " + base.getId(), e);
        }
        if(!"".equals(base.getAttribute("template","").trim())) {
            try { 
                //tpl = com.infotec.appfw.util.AFUtils.getInstance().loadTemplateXSLT(WBUtils.getInstance().getFileFromWorkPath(base.getResourceWorkPath() +"/"+ base.getAttribute("template").trim())); 
                tpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBUtils.IO.getStreamFromString(
                        SWBUtils.IO.getFileFromPath(base.getWorkPath() + "/"
                        + base.getAttribute("template").trim())));
                //path=WBUtils.getInstance().getWebWorkPath() +  base.getResourceWorkPath() + "/";
                path = SWBPortal.getWebWorkPath() + base.getWorkPath() + "/";
            } catch(Exception e) {
                log.error("Error while loading resource template: " 
                          + base.getId(), e);
            }
        }
        if (tpl == null) {
            try {
                //tpl = com.infotec.appfw.util.AFUtils.getInstance().loadTemplateXSLT(WBUtils.getInstance().getAdminFileStream("/wbadmin/xsl/QueryResource/QueryResource.xslt"));
                tpl = SWBUtils.XML.loadTemplateXSLT(
                        SWBPortal.getAdminFileStream(
                        "/swbadmin/xsl/QueryResource/QueryResource.xslt"));
            } catch (Exception e) {
                log.error("Error while loading default resource template: " 
                          + base.getId(), e);
            }
        }
    }
    
    /** 
     * Gets the document that represents the query results.
     *  
     * @param request the action request
     * @param response the action response
     * @param paramsRequest request arguments 
     * @throws SWBResourceException if an exception occurs while trying to get
     *         the document.
     */
    private Document getDom(HttpServletRequest request,
            HttpServletResponse response, SWBParamRequest paramsRequest)
            throws SWBResourceException {
        
        Resource base = getResourceBase();
        Document doc = null;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String query = parse(base.getAttribute("query"), request, paramsRequest);
        String dbcon = base.getAttribute("dbcon");
        if (query != null) {
            try {
                doc = SWBUtils.XML.getNewDocument();
                Element equery = doc.createElement("QUERY");
                doc.appendChild(equery);
                equery.setAttribute("query", query);
                equery.setAttribute("dbcon", dbcon);
                equery.setAttribute("path", path);
                addElem(doc, equery, "title", base.getTitle());
                addElem(doc, equery, "description", base.getDescription());
                Connection con = null;
                if (dbcon != null && dbcon.length() > 0) {
                    con = SWBUtils.DB.getConnection(dbcon,
                            "From QueryResource.getDom()");
                    if (con != null) {
                        Statement st = con.createStatement();
                        if (st != null) {
                            ResultSet rs = st.executeQuery(query);
                            ResultSetMetaData md = rs.getMetaData();
                            int col = md.getColumnCount();
                            equery.setAttribute("ncol", "" + col);
                            Element eheader = doc.createElement("header");
                            equery.appendChild(eheader);
                            
                            for (int x = 1; x <= col; x++) {
                                Element ecol = addElem(doc, eheader, "col_name",
                                                       md.getColumnName(x));
                            }
                            Element eresult = doc.createElement("result");
                            equery.appendChild(eresult);
                            while (rs.next()) {
                                Element erow = doc.createElement("row");
                                eresult.appendChild(erow);
                                for (int x = 1; x <= col; x++) {
                                    String aux = rs.getString(x);
                                    if (aux == null) aux = "";
                                    Element ecol = addElem(doc, erow, "col", aux);
                                }
                            }
                            rs.close();
                            st.close();
                            con.close();
                        }
                    }
                }
            } catch (Exception e) {
                log.error(paramsRequest.getLocaleString(
                        "error_QueryResource_getDom"), e);
            }
        }
        return doc;
    }

    /**
     * Called by <code>render()</code> method when the portlet is in View mode.
     * Intended to contain logic that displays the view page for the portlet.
     * 
     * @param request the action request
     * @param response the action response
     * @param paramsRequest request arguments
     * @throws SWBResourceException if an exception occurs when displaying the 
     *         view page.
     * @throws IOException if streaming causes an I/O problem.
     */    
    @Override
    public void doView(HttpServletRequest request,
                       HttpServletResponse response,
                       SWBParamRequest paramsRequest)
                       throws SWBResourceException, IOException {
        
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        PrintWriter out = new PrintWriter(bout);
        try {
            Document doc = getDom(request, response, paramsRequest);
            out.print(SWBUtils.XML.transformDom(tpl, doc));
        } catch (Exception e) {
            log.error(paramsRequest.getLocaleString(
                    "error_QueryResource_doView"), e);
            out.println(paramsRequest.getLocaleString(
                    "usrmsg_QueryResource_queryError"));
        }
        out.flush();
        //response.getWriter().print(new String(bout.toByteArray()));
        PrintWriter webOut = response.getWriter();
        webOut.println(new String(bout.toByteArray()));
        /*webOut.println("<br><a href=\"" 
                + paramsRequest.getRenderUrl().setMode(paramsRequest.Mode_ADMIN)
                + "\">QueryResource admin</a>");*/
    }

    /** 
     * Adds element to the document received as child of the specified element 
     * with the name and the value received.
     * 
     * @param doc <code>Document</code> base.
     * @param parent new <code>Element</code>'s parent <code>Element</code>.
     * @param elemName new <code>Element</code>'s name.
     * @param elemValue new <code>Element</code>'s value.
     * @return elem <code>Element</code> created.
     */
    private Element addElem(Document doc, Element parent, String elemName,
                            String elemValue) {
        
        Element elem = doc.createElement(elemName);
        elem.appendChild(doc.createTextNode(elemValue));
        parent.appendChild(elem);
        return elem;
    }

    /**
     * Called by <code>getDom()</code> method when query string is analized.
     * 
     * @param query Query String to parse.
     * @param request the action request.
     * @param paramsRequest request arguments.
     * @return string prepared for execute query
     */
    public String parse(String query, 
                        HttpServletRequest request,
                        SWBParamRequest paramsRequest) {
        
        String ret = "";
        if (query == null) {
            return null;
        }
        int l = query.length();
        int a = 0;
        int i = 0;
        int f = 0;
        while ((i = query.indexOf("{", a)) > -1) {
            ret += query.substring(a, i);
            if ((f = query.indexOf("}", i)) > -1) {
                a = f + 1;
                String com = query.substring(i + 1, f);
                if (com.equals("topicmap")) {
                    //ret += paramsRequest.getWebPage().getMap().getId();
                    ret += paramsRequest.getWebPage().getWebSiteId();
                } else if (com.equals("topicid")) {
                    ret += paramsRequest.getWebPage().getId();
                } else if (com.equals("userid")) {
                    //ret += paramsRequest.getUser().getEmail();
                    ret += paramsRequest.getUser().getEmail();
                } else if (com.startsWith("getUserAttribute(") && com.endsWith(")")) {
                    String aux = com.substring(17, com.length() - 1);
                    //ret += paramsRequest.getUser().getAttribute(aux);
                    ret += paramsRequest.getUser().getProperty(aux);
                } else if (com.startsWith("getParameter(") && com.endsWith(")")) {
                    String aux = com.substring(13, com.length() - 1);
                    ret += request.getParameter(aux);
                } else if (com.startsWith("getArgument(") && com.endsWith(")")) {
                    String aux = com.substring(12, com.length() - 1);
                    ret += paramsRequest.getArguments().get(aux);
                } else {
                    ret += query.substring(i, f + 1);
                }
            } else {
                a = l + 1;
            }
        }
        if (a < l) {
            ret += query.substring(a);
        }
        ret = ret.trim();
        log.debug("return " + ret);
        return ret;
    }
}
