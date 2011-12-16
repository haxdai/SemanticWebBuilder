package org.semanticwb.model;

import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;


   /**
   * TreeSelect 
   */
public class TreeSelect extends org.semanticwb.model.base.TreeSelectBase 
{
    protected static final String pathImages = SWBPlatform.getContextPath() + "/swbadmin/icons/";
    private static Logger log = SWBUtils.getLogger(TreeSelect.class);

    public TreeSelect(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName) {
        if (prop.getDisplayProperty() == null) {
            return;
        }
        String value = request.getParameter("section" + "_" + obj.getShortURI() + "_" + propName);
        String delPages = request.getParameter("deletePages" + "_" + obj.getShortURI() + "_" + propName);
        if ((value != null) && (value.length() > 0)) {
            try {
                obj.setProperty(prop, value);
            } catch (Exception e) {
                log.error("Can't save the value's property in TreeSelect, " + e);
            }
        }
        if(delPages != null) {
            obj.removeProperty(prop);
        }
    }

    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName, String type, String mode, String lang) {
        StringBuffer ret = new StringBuffer(256);
        String style = "";
        StringBuilder params = new StringBuilder("");

        String li = obj.getProperty(prop);
        WebSite site = SWBContext.getWebSite(getModel().getName());
        WebPage home = site.getHomePage();
        String url = SWBPlatform.getContextPath() + "/treeSelect/" + obj.getModel().getModelObject().getId();
        WebPage lip = null;
        String dataProp = obj.getShortURI() + "_" + propName;

        if(li != null && li.length() > 0) {
            ret.append("<input type=\"checkbox\" name=\"deletePages" + "_" + obj.getShortURI() + "_" + propName + "\" value=\"deletePages\">Deseleccionar p&aacute;gina web");
            lip = site.getWebPage(li);
            ret.append("<br><span style=\"font-style:italic; font-weight:bold; padding-top:7px; padding-left: 20px; padding-bottom: 7px; padding-right: 20px; color:#336699;\">" + lip.getDisplayName() + "</span>");
            ret.append("<a href=\"javascript:getHtml('" + url + "?site=" + home.getWebSiteId() + "&reptp=" + home.getId() + params + "&dataProp=" + dataProp + "&li=" + li + "&lang=" + lang + "&edit=true','tree_'+'" + site.getId() + "_" + obj.getShortURI() + "_" + propName + "')\">Mostrar en el &aacute;rbol</a>");
        }

        ret.append("<div id=\"slave\">");
        ret.append("<div class=\"sitesectiontree\" id=\"tree_" + site.getId() + "_" + obj.getShortURI() + "_" + propName + "\">");

        String styleActual = "";
        if(lip == null) {
            styleActual = "style=\"display:inline\"";
        } else {
            styleActual = "style=\"display:none\"";
        }

        ret.append("<ul class=\"treeres\">");
        ret.append("<li "+ styleActual+">"); //style=\"border-color:#6699FF; max-width:400px; min-width:200px;\" -----

        params.append("&" + home.getId() + "=0");
        ret.append("<img src=\"" + pathImages + "/plus.gif\" alt=\"abrir nodo\"  onclick=\"getHtml('" + url + "?site=" + home.getWebSiteId() + "&reptp=" + home.getId() + params + "&dataProp=" + dataProp + "&li=" + li + "&lang=" + lang + "','tree_'+'" + site.getId() + "_" + obj.getShortURI() + "_" + propName + "')\" />");

        if((li != null && li.length() > 0) && li.equalsIgnoreCase(home.getId())) {
            style = " style=\"font-weight:bold;\"";
        }

        ret.append("<a class=\"treeres\" onclick=\"getHtml('" + url + "?site=" + home.getWebSiteId() + "&reptp=" + home.getId() + params + "&dataProp=" + dataProp + "&li=" + li + "&lang=" + lang + "','tree_'+'" + site.getId() + "_" + obj.getShortURI() + "_" + propName + "')\" " + style + ">");
        if(home.isActive()) { //mostrar icono del home(Activo/Desactivo)
            ret.append("<img src=\"" + pathImages + "/icon_homeac.png\" alt=\"seleccionar inicio\" />");
        } else {
            ret.append("<img src=\"" + pathImages + "/icon_homein.png\" alt=\"seleccionar inicio\" />");
        }

        try { //Agregar el título del nodo actual
            ret.append("<span style=\"padding-left:5px\">" + SWBUtils.TEXT.encode(home.getDisplayTitle(lang), SWBUtils.TEXT.CHARSET_UTF8) + "</span>");
        } catch(Exception e) {
            log.error("Can't save the value's property in TreeSelect, " + e);
        }

        ret.append("</a>");
        ret.append("</li>");
        ret.append("</ul>");
        ret.append("</div>");
        ret.append("</div>");
        return ret.toString();
    }
}
