package mx.gob.stps.portalempleo.swb.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

    /**
    * Representa una estructura para organizar la información del portal que consiste en representar
     *  una lista de secciones recomendadas. Este recurso funciona para cualquier sección que tenga subsecciones.
     * <ul>
     * <li>Título del canal
     * <li>Título de cada subsección del canal
     * <li>Una imagen asociada a la propiedad iconClass del canal
     * </ul>
     * Recommended es un recurso de estrategia dentro del ambiente de SemanticWebBuilder 4.0.
     * Recommended cuenta con una interfaz de administración.
    * @author  Carlos Ramos
    * @version 1.0
    */

public class Recommended extends GenericResource
{

    private static Logger log = SWBUtils.getLogger(Recommended.class);
    private static final String Action_UPDATE = "updt";
    private String strRscType;

    @Override
    public void init()
    {
        Resource base = getResourceBase();
        try
        {
            strRscType = base.getResourceType().getResourceClassName();
        }
        catch (Exception e)
        {
            strRscType = "Recommended";
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        if (paramRequest.getMode().equalsIgnoreCase("bind"))
        {
            doBind(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    /**
     * Despliega la estructura html que representa el Recommended,
     * mostrando la lista de subsecciones marcadas para recomendarlas.
     * @param request - el HttpServletRequest que recibe del contenedor de servlets
     * @param response - el HttpServletResponse que recibe del contenedor de servlets
     * @param paramRequest - el SWBParamRequest que recibe del ambiente SemanticWebBuilder
     * @throws SWBResourceException - if paramRequest arroja una excepción de este tipo
     * @throws IOException - if request o response arroja una excepción de este tipo
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        PrintWriter out = response.getWriter();

        String lang = paramRequest.getUser().getLanguage();

        Resource base = getResourceBase();
        WebSite model = base.getWebSite();

        Iterator<String> attrnames = base.getAttributeNames();

        if (attrnames != null)
        {
            ArrayList<WebPage> pages = new ArrayList<WebPage>();

            while (attrnames.hasNext())
            {
                String wpid = attrnames.next();
                if (wpid.startsWith("swp"))
                    continue;
                WebPage wp = model.getWebPage(base.getAttribute(wpid));
                if (wp == null)
                {
                    log.warn(strRscType + " con id=" + base.getId() + ". El identificador " + wpid + " no corresponde a ninguna página web");
                    continue;
                }
                if (wp.isValid())
                    pages.add(wp);
            }

            if (pages.size() > 0)
            {
                out.println("<div class=\"relacionados\">");
                out.println("<h4>Recomendaciones</h4>");
                out.println("<ul>");
                for (WebPage wp : pages)
                {
                    out.println("<li><a href=\"" + wp.getRealUrl() + "\" title=\"ir a " + wp.getDisplayTitle(lang) + "\">" + wp.getDisplayTitle(lang) + "</a></li>");
                }
                out.println("</ul>");
                out.println("</div>");
            }
        }


        /*while(attrnames.hasNext()) {
        String wpid = attrnames.next();
        if(wpid.startsWith("swp"))
        continue;
        WebPage wp = model.getWebPage(base.getAttribute(wpid));
        if(wp==null) {
        log.warn(strRscType+" con id="+base.getId()+". El identificador "+wpid+" no corresponde a ninguna página web");
        continue;
        }
        out.println("<li><a href=\""+wp.getRealUrl()+"\" title=\"ir a "+wp.getDisplayTitle(lang)+"\">"+wp.getDisplayTitle(lang)+"</a></li>");

        }*/

    }

    /**
     * Maneja la lógica para desplegar la estructura html que muestra las subsecciones de una sección
     * recibida como parámetro de la solicitud http.
     * @param request - el HttpServletRequest que recibe del contenedor de servlets
     * @param response - el HttpServletResponse que recibe del contenedor de servlets
     * @param paramRequest - el SWBParamRequest que recibe del ambiente SemanticWebBuilder
     * @throws SWBResourceException - if paramRequest arroja una excepción de este tipo
     * @throws IOException - if request o response arroja una excepción de este tipo
     */
    public void doBind(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=iso-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();

        String wpId = request.getParameter("wp");
        WebPage node = paramRequest.getWebPage().getWebSite().getWebPage(wpId);
        if (node != null)
        {
            out.println("<label for=\"\" class=\"swbform-label\">Descendientes</label>");
            out.println("<ul>");
            Iterator<WebPage> childs = node.listChilds(paramRequest.getUser().getLanguage(), true, false, false, true);
            while (childs.hasNext())
            {
                WebPage child = childs.next();
                out.println("<ol><label for=\"" + child.getId() + "\"><input type=\"checkbox\" id=\"" + child.getId() + "\" name=\"cs\" value=\"" + child.getId() + "\"/>&nbsp;" + child.getTitle() + "</label></ol>");
            }
            out.println("</ul>");
        }
    }

    /**
     * Maneja la lógica de la administración del recurso Recommended.
     * @param request - el HttpServletRequest que recibe del contenedor de servlets
     * @param response - el HttpServletResponse que recibe del contenedor de servlets
     * @param paramRequest - el SWBParamRequest que recibe del ambiente SemanticWebBuilder
     * @throws SWBResourceException - if paramRequest arroja una excepción de este tipo
     * @throws IOException - if request o response arroja una excepción de este tipo
     */
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();

        String action = null != request.getParameter("act") && !"".equals(request.getParameter("act").trim()) ? request.getParameter("act").trim() : paramRequest.getAction();
        if (paramRequest.Action_ADD.equals(action) || paramRequest.Action_EDIT.equals(action))
        {
            out.println(getForm(request, paramRequest));
        }
        else if (Action_UPDATE.equals(action))
        {
            out.println("<script type=\"text/javascript\" language=\"JavaScript\">");
            out.println("   alert('Se actualizó exitosamente el recurso con identificador " + base.getId() + "');");
            out.println("   window.location.href='" + paramRequest.getRenderUrl().setAction("edit") + "';");
            out.println("</script>");
        }
    }

    /**
     * Despliega la estructura html que representa la interfaz de usuario de la administración
     * del recurso Recommended.
     * @param request - el HttpServletRequest que recibe del contenedor de servlets
     * @param paramRequest - el SWBParamRequest que recibe del ambiente SemanticWebBuilder
     */
    private String getForm(javax.servlet.http.HttpServletRequest request, SWBParamRequest paramRequest)
    {
        Resource base = getResourceBase();
        StringBuilder htm = new StringBuilder();
        String lang = paramRequest.getUser().getLanguage();

        SWBResourceURL url = paramRequest.getActionUrl().setAction(paramRequest.Action_EDIT);
        htm.append("<script type=\"text/javascript\">\n");
        htm.append("<!--\n");
        htm.append("  dojo.require(\"dijit.layout.ContentPane\");\n");
        htm.append("  dojo.require(\"dijit.form.Form\");\n");
        htm.append("  dojo.require(\"dijit.form.ValidationTextBox\");\n");
        htm.append("  dojo.require(\"dijit.form.RadioButton\");\n");
        htm.append("  dojo.require(\"dijit.form.SimpleTextarea\");\n");
        htm.append("  dojo.require(\"dijit.form.Button\");\n");
        htm.append("-->\n");
        htm.append("</script>\n");
        htm.append("<div class=\"swbform\">\n");
        htm.append("<form id=\"frm\" dojoType=\"dijit.form.Form\" method=\"post\" action=\"" + url + "\">\n");
        htm.append("<fieldset>\n");
        htm.append(" <legend>Datos</legend>\n");
        htm.append(" <ul class=\"swbform-ul\">\n");


        String swp = base.getAttribute("swp", "");
        TreeSet<WebPage> set = new TreeSet(new Comparator()
        {

            public int compare(Object o1, Object o2)
            {
                if (o1 instanceof WebPage && o2 instanceof WebPage)
                {
                    String t1 = ((WebPage) o1).getTitle();
                    String t2 = ((WebPage) o2).getTitle();
                    return t1.compareToIgnoreCase(t2);
                }
                else
                {
                    int hc1 = o1.hashCode();
                    int hc2 = o2.hashCode();
                    return hc1 > hc2 ? 1 : -1;
                }
            }
        });
        WebPage home = paramRequest.getWebPage().getWebSite().getHomePage();
        //set.add(home);
        Iterator<WebPage> wps = listChilds(home, paramRequest.getUser().getLanguage(), set);
        htm.append("  <li class=\"swbform-li\">\n");
        htm.append("   <label for=\"swp\" class=\"swbform-label\">Recomendar descendientes de</label>\n");
        htm.append("   <select name=\"swp\" id=\"swp\" onchange=\"postHtml('" + paramRequest.getRenderUrl().setMode("bind").setCallMethod(paramRequest.Call_DIRECT) + "?wp='+this.value,'wpd')\"/>\n");
        htm.append("    <option value=\"\">--Seleccionar--</option>\n");
        while (wps.hasNext())
        {
            WebPage wp = wps.next();
            if (swp.equals(wp.getId()))
                htm.append("<option value=\"" + wp.getId() + "\" selected=\"selected\">" + wp.getDisplayTitle(lang) + "</option>\n");
            else
                htm.append("<option value=\"" + wp.getId() + "\">" + wp.getDisplayTitle(lang) + "</option>\n");
        }
        htm.append("   </select>\n");
        htm.append("  </li>\n");

        htm.append("  <li class=\"swbform-li\" id=\"wpd\">\n");
        htm.append("   <label for=\"\" class=\"swbform-label\">Descendientes</label>");
        WebPage node = paramRequest.getWebPage().getWebSite().getWebPage(swp);
        if (node != null)
        {
            htm.append("   <ul>");
            Iterator<WebPage> childs = node.listChilds(paramRequest.getUser().getLanguage(), true, false, false, true);
            while (childs.hasNext())
            {
                WebPage child = childs.next();
                if (base.getAttribute(child.getId()) != null)
                    htm.append("<ol><label for=\"" + child.getId() + "\"><input type=\"checkbox\" id=\"" + child.getId() + "\" name=\"cs\" value=\"" + child.getId() + "\" checked=\"checked\"/>&nbsp;" + child.getDisplayTitle(lang) + "</label></ol>");
                else
                    htm.append("<ol><label for=\"" + child.getId() + "\"><input type=\"checkbox\" id=\"" + child.getId() + "\" name=\"cs\" value=\"" + child.getId() + "\"/>&nbsp;" + child.getDisplayTitle(lang) + "</label></ol>");
            }
            htm.append("   </ul>");
        }
        htm.append("  </li>\n");
        htm.append(" </ul>\n");
        htm.append("</fieldset>\n");

        htm.append("<fieldset>\n");
        htm.append(" <legend></legend>\n");
        htm.append("  <ul class=\"swbform-ul\">\n");
        htm.append("   <li>\n");
        htm.append("    <button type=\"submit\" dojoType=\"dijit.form.Button\">Guardar</button>\n");
        htm.append("    <button type=\"reset\" dojoType=\"dijit.form.Button\">Restablecer</button>\n");
        htm.append("   </li>\n");
        htm.append("  </ul>\n");
        htm.append("</fieldset>\n");
        htm.append("</form>\n");
        htm.append("</div>\n");

        return htm.toString();
    }

    /**
     * Devuelve un iterador de todas las subsecciones de node, ordenados alfabéticamente de
     * acuerdo al título de la sección
     * @param node - La sección de la que nos interesa obtener su jerarquía de subsecciones
     * @param lang - Idioma que se toma para desplegar el título de las secciones
     * @param res - Iterador que contiene la jerarquía de subsecciones de node, excluido.
     * @return Un iterador conteniendo las subsecciones de node ordenadas alfabéticamente.
     */
    private Iterator<WebPage> listChilds(WebPage node, String lang, TreeSet res)
    {
        WebPage child;
        Iterator<WebPage> childs = node.listChilds(lang, true, false, false, true);
        while (childs.hasNext())
        {
            child = childs.next();
            res.add(child);
            listChilds(child, lang, res);
        }
        return res.iterator();
    }

    /**
     * Guarda los cambios hechos en la administración del recurso
     * @param request
     * @param response
     * @throws SWBResourceException
     * @throws IOException
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {
        Resource base = getResourceBase();
        String action = response.getAction();
        if (response.Action_EDIT.equals(action))
        {
            try
            {
                Iterator<String> attrnames = base.getAttributeNames();
                if (attrnames != null)
                {
                    while (attrnames.hasNext())
                    {
                        base.removeAttribute(attrnames.next());
                    }
                }
                base.setAttribute("swp", request.getParameter("swp"));
                String[] d = request.getParameterValues("cs");
                for (String c : d)
                {
                    base.setAttribute(c, c);
                }
                base.updateAttributesToDB();
                response.setAction(Action_UPDATE);
            }
            catch (Exception e)
            {
                log.error(e);
            }
        }
    }
}
