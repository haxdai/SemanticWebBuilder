/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.resources.googlegadgets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author victor.lorenzana
 */
public class GoogleGadget extends GenericResource
{

    private static final String COUNTRY_ATTRIBUTE = "country";
    private static final String GOOGLE_URL = "http://www.google.com";
    private static final String PATH_DIRECTORY = "/ig/directory";
    private static final String LANGUAGE_ATTRIBUTE = "lang";
    private static final String URL_ATTRIBUTE = "url";
    private static String URL_FRAME = "http://www.gmodules.com/ig/ifr";
    private static String URL_DIRECTORY = GOOGLE_URL + PATH_DIRECTORY + "?synd=trogedit&source=gghp";
    private static String LANG_PARAMETER = "hl";
    private static final String URL_TO_FIND = "n_32\\x3durl%3Dhttp";
    private static Logger log = SWBUtils.getLogger(GenericResource.class);

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException
    {

        String url = request.getParameter(URL_ATTRIBUTE);

        if (url != null && !url.equals(""))
        {
            try
            {
                URL urlgadget = new URL(url);

                Iterator<String> names = this.getResourceBase().getAttributeNames();
                while (names.hasNext())
                {
                    String name = names.next();
                    this.getResourceBase().setAttribute(name, null);
                }
                this.getResourceBase().setAttribute(URL_ATTRIBUTE, urlgadget.toString());
                try
                {
                    this.getResourceBase().updateAttributesToDB();
                }
                catch (Exception e)
                {
                    log.error(e);
                }
                response.setMode(response.Mode_ADMIN);
            }
            catch (MalformedURLException mfe)
            {
                log.error(mfe);
            //AFUtils.log(mfe);
            }
        }
        String title = request.getParameter("title");
        if (title != null && !title.equals(""))
        {
            this.getResourceBase().setAttribute(LANGUAGE_ATTRIBUTE, response.getUser().getLanguage());
            this.getResourceBase().setAttribute(COUNTRY_ATTRIBUTE, "ALL");
            Enumeration names = request.getParameterNames();
            while (names.hasMoreElements())
            {
                String name = (String) names.nextElement();
                if (!name.equals("savechanges"))
                {
                    String value = request.getParameter(name);
                    if (value != null && !value.equals(""))
                    {
                        if (!(name.equals(LANGUAGE_ATTRIBUTE) || name.equals("w") || name.equals("h") || name.equals("title")))
                        {
                            name = "up_" + name;
                        }
                        if (name.equals(LANGUAGE_ATTRIBUTE))
                        {
                            int pos = value.indexOf("-");
                            if (pos == -1)
                            {
                                this.getResourceBase().setAttribute(LANGUAGE_ATTRIBUTE, value);
                                this.getResourceBase().setAttribute(COUNTRY_ATTRIBUTE, "ALL");
                            }
                            else
                            {
                                String country = value.substring(pos + 1);
                                String language = value.substring(0, pos);
                                this.getResourceBase().setAttribute(LANGUAGE_ATTRIBUTE, language);
                                this.getResourceBase().setAttribute(COUNTRY_ATTRIBUTE, country);
                            }
                        }
                        this.getResourceBase().setAttribute(name, value);
                    }
                }
            }
            try
            {
                this.getResourceBase().updateAttributesToDB();
            }
            catch (Exception e)
            {
                log.error(e);
            }
            response.setMode(response.Mode_ADMIN);
        }
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException
    {
        if (paramsRequest.getMode().equals("changeConfig"))
        {
            doChangeConfig(request, response, paramsRequest);
        }
        else if (paramsRequest.getMode().equals("changeGadget"))
        {
            doChangeGadget(request, response, paramsRequest);
        }
        else if (paramsRequest.getMode().equals("addFromList"))
        {
            doAddFromList(request, response, paramsRequest);
        }
        else
        {
            super.processRequest(request, response, paramsRequest);
        }
    }

    public void doAddFromList2(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException
    {
        PrintWriter out = response.getWriter();
        String start = request.getParameter("start");
        String sa = request.getParameter("sa");
        if (request.getSession().getAttribute(LANGUAGE_ATTRIBUTE) == null)
        {
            request.getSession().setAttribute(LANGUAGE_ATTRIBUTE, paramsRequest.getUser().getLanguage());
        }
        if (request.getParameter("changelang") != null)
        {
            request.getSession().setAttribute(LANGUAGE_ATTRIBUTE, request.getParameter("changelang"));
            start = null;
            sa = null;
        }
        Locale localeUser = new Locale(request.getSession().getAttribute(LANGUAGE_ATTRIBUTE).toString());
        String directoryURL = URL_DIRECTORY;
        if (start != null && sa != null)
        {
            directoryURL += "&start=" + start + "&sa=" + sa;
        }
        directoryURL += "&" + LANG_PARAMETER + "=" + localeUser.getLanguage();
        URL url = new URL(directoryURL);
        URLConnection con = url.openConnection();
        InputStream in = con.getInputStream();
        StringBuffer html = new StringBuffer();
        byte[] buffer = new byte[8 * 1024];
        int read = in.read(buffer);
        while (read != -1)
        {
            html.append(new String(buffer, 0, read));
            read = in.read(buffer);
        }
        in.close();
        Set<URL> gadgets = getGadgets(html.toString());
        out.println("<div>");
        out.println("<table width='100%'>");
        SWBResourceURL urlback = paramsRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("<tr><td align='center'><a href='" + urlback + "'>" + paramsRequest.getLocaleString("back") + "</a></td></tr></table><br>");
        out.println("<table width='100%'>");
        out.println("<tr>");
        if (start == null)
        {
            out.println("<td><a href='" + paramsRequest.getRenderUrl() + "?start=" + gadgets.size() + "&sa=N'>Siguiente</a></td>");
        }
        else
        {
            out.println("<td><a href='" + paramsRequest.getRenderUrl() + "?start=" + (Integer.parseInt(start) + gadgets.size()) + "&sa=N'>Siguiente</a></td>");
        }
        SWBResourceURL urlChangeLang = paramsRequest.getRenderUrl();
        out.println("<td>Búscar gadgets en:<form action='" + urlChangeLang + "'><select onChange=\"javascript:this.form.submit();\" name='changelang'>");
        String lang = (String) request.getSession().getAttribute(LANGUAGE_ATTRIBUTE);
        out.println("<option " + (lang.equals("es") ? "selected" : "") + " value='es'>Espa&ntilde;ol</option>");
        out.println("<option " + (lang.equals("en") ? "selected" : "") + " value='en'>Ingles</option>");
        out.println("</select></form></td>");
        if (start != null)
        {
            out.println("<td><a href='" + paramsRequest.getRenderUrl() + "?start=" + (Integer.parseInt(start) - gadgets.size()) + "&sa=N'>Anterior</a></td>");
        }
        out.println("</tr>");
        out.println("<br>");
        out.println("</table>");
        out.println("<table width='100%'>");
        int i = 0;
        for (URL urlgadget : gadgets)
        {
            String title = null;
            String imgsrc = null;
            boolean correct = false;
            try
            {
                Gadget gadget = new Gadget(urlgadget);
                title = gadget.getDirectoryTitle(localeUser);
                imgsrc = gadget.getSrcImage(localeUser);
                correct = true;
            }
            catch (Exception e)
            {
                title = null;
                imgsrc = null;
                //AFUtils.log(e);
                log.error(e);
            }
            if (correct && title != null && imgsrc != null)
            {
                i++;
                if (i % 3 == 1) // primero
                {
                    out.println("<tr><td align='center'>");
                }
                else
                {
                    out.println("<td align='center'>");
                }
                out.println("<table width='100%'>");
                out.println("<tr><td align='center'>" + title + "</td></tr>");
                out.println("<tr><td align='center'><img width='120' height='60' src=\"" + imgsrc + "\" border=0></td></tr>");
                out.println("<tr><td align='center'><a href=\"" + paramsRequest.getActionUrl() + "?url=" + urlgadget + "\">Agregar</a></td></tr>");
                out.println("</table>");
                if (i % 3 == 0) // ultimo
                {
                    out.println("</td></tr>");
                    out.println("<tr><td colspan='3'>&nbsp;</td></tr>");
                }
                else
                {
                    out.println("</td>");
                }
            }
        }
        if (i % 3 != 2)
        {
            out.println("</td></tr>");
        }
        out.println("</table></div>");
        out.close();
    }

    public static void replace(StringBuffer html, String startText, String endText, String replace)
    {
        int pos = html.indexOf(startText);
        while (pos != -1)
        {
            int pos2 = html.indexOf(endText, pos);
            if (pos2 != -1 && pos2 > pos)
            {
                html.replace(pos, pos2 + endText.length(), replace);
                pos = html.indexOf(endText);
            }
            else
            {
                pos = -1;
            }
        }
    }

    public static void replace(StringBuffer html, String text, String replace)
    {
        int pos = html.indexOf(text);
        while (pos != -1)
        {
            html.replace(pos, pos + text.length(), replace);
            pos = html.indexOf(text);
        }
    }

    public void doAddFromList(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException
    {

        SWBResourceURL urlaction = paramsRequest.getActionUrl();
        String parameters = "synd=trogedit&num=9&hl=" + paramsRequest.getUser().getLanguage() + "&iframeId=tr_moduleDirectory-iframegoog_1221086410332";
        if (request.getParameter("q") != null)
        {
            parameters += "&q=" + request.getParameter("q");
        }
        if (request.getQueryString() != null && request.getParameter("wblastversion") == null && request.getParameter("tpcomm") == null && request.getParameter("tm") == null)
        {
            parameters = request.getQueryString();
        }
        String url = GOOGLE_URL + PATH_DIRECTORY + "?" + parameters;
        URL urlPage = new URL(url);
        URLConnection con = urlPage.openConnection();
        InputStream in = con.getInputStream();
        String html2 = SWBUtils.IO.readInputStream(in); //AFUtils.getInstance().readInputStream(in);
        StringBuffer html = new StringBuffer(html2);
        replace(html, "<html>", "");
        replace(html, "</html>", "");
        replace(html, "<meta", ">", "");
        replace(html, "More information for developers", "");
        replace(html, "<a href=\"javascript:openAddByUrl();\">", "</a>", "");


        int pos = html.indexOf("/ig/f/ZtcZ_UMr1Ww/ig.js");
        /*if(pos==-1)
        {
        pos = html.indexOf("/ig/f/s-9mlIkxfvs/ig.js");
        }
        if(pos==-1)
        {
        pos = html.indexOf("/ig/f/C0R-Dtev__A/ig.js");
        }*/
        if (pos == -1)
        {
            pos = html.indexOf("<script src=\"/ig/f/");
        }
        if (pos != -1)
        {
            html.insert(pos + 13, GOOGLE_URL);
            String pathTofound = "\"" + PATH_DIRECTORY;
            replace(html, pathTofound, "\"");
            pathTofound = GOOGLE_URL + PATH_DIRECTORY + "?";
            replace(html, pathTofound, "http://" + request.getServerName() + ":" + request.getServerPort() + "" + paramsRequest.getRenderUrl() + "?");
            replace(html, "_IFPC.call(\"tr_moduleDirectory-iframegoog_1221086410332\", \"pickGadget\", [url], \"/ifpc_relay\", null, null);", "if(confirm('¿Desea agregar este gadget?'))location='" + urlaction + "?url='+url;");
            PrintWriter out = response.getWriter();
            out.println("<div>");
            String urlGadget = this.getResourceBase().getAttribute("url");
            if (urlGadget != null && !urlGadget.equals(""))
            {
                out.println("<table width='100%'  border='0' cellpadding='5' cellspacing='0'> ");
                SWBResourceURL urlback = paramsRequest.getRenderUrl();
                urlback.setMode(urlback.Mode_ADMIN);
                out.println("<tr><td align='right'><form name='frmback' method='post' action='" + urlback + "'><input type='hidden' name='back' value='" + paramsRequest.getLocaleString("back") + "'></input><button dojoType=\"dijit.form.Button\" type='button' onClick='frmback.submit();'>" + paramsRequest.getLocaleString("back") + "</button></form></td></tr>");
                out.println("<tr><td ><HR size='1' noshade/></td></tr>");
                out.println("</table>");
            }
            out.println(html.toString());
            out.println("</div>");

            out.close();
        }
        else
        {
            doAddFromList2(request, response, paramsRequest);
        }
    }

    private Set<URL> getGadgets(String html)
    {
        HashSet<URL> getGadgets = new HashSet<URL>();
        //int pos = html.indexOf("&url=http");
        int pos = html.indexOf(URL_TO_FIND);

        while (pos != -1)
        {
            html = html.substring(pos + URL_TO_FIND.length() - 4);
            int posFin = html.indexOf(".xml");
            if (posFin != -1)
            {
                String url = html.substring(0, posFin + 4);
                url = url.replaceAll("%3A", ":");
                try
                {
                    URL tryURL = new URL(url);
                    getGadgets.add(tryURL);
                }
                catch (MalformedURLException mfe)
                {
                    log.error(mfe);
                //AFUtils.log(mfe);
                }
            }
            pos = html.indexOf(URL_TO_FIND);
        }
        return getGadgets;
    }

    public void doChangeGadget(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException
    {
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\" language=\"javascript\">");
        out.println("function createGadget()");
        out.println("{");
        out.println("if(frmasigngadget.url.value=='')");
        out.println("{");
        out.println("alert('" + paramsRequest.getLocaleString("msg1") + "');");
        out.println("return;");
        out.println("}");
        out.println("frmasigngadget.submit();");
        out.println("}");
        out.println("</script>");

        out.println("<div> <table width='100%'  border='0' cellpadding='5' cellspacing='0'> ");

        out.println("<tr><td>");
        out.println("<form name=\"frmasigngadget\" action='" + paramsRequest.getActionUrl() + "' method='post'>");
        out.println("<table><tr><td>URL del Gadget</td><td><input type='text' name='url' size='50' maxlength='225'></td></tr>");
        out.println("<tr><td colspan='2'><button  class='boton' dojoType=\"dijit.form.Button\" type='button' name='save' value='Asignar Gadget' onClick='javascript:createGadget()'>Asignar Gadget</button></td></tr>");
        SWBResourceURL urlback = paramsRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</td></tr><tr><td colspan='2'><a href='" + urlback + "'>" + paramsRequest.getLocaleString("back") + "</a></td></tr></table></form>");
        out.println("</td></tr>");

        out.println("</table></div>");
        out.close();
    }

    public void doChangeConfig(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException
    {
        Locale localeUser = new Locale(paramsRequest.getUser().getLanguage());
        URL url = new URL(this.getResourceBase().getAttribute(URL_ATTRIBUTE));
        PrintWriter out = response.getWriter();
        out.println("<div class=\"swbform\"><form id=\"formaChangeConfig\" name=\"formaChangeConfig\"action='" + paramsRequest.getActionUrl() + "' method='post'>");
        out.println("<script type=\"text/javascript\" language=\"javascript\">");
        out.println("function validData()");
        out.println("{");
        out.println("if(formaChangeConfig.title.value=='')");
        out.println("{");
        out.println("alert('" + paramsRequest.getLocaleString("msg2") + "');");
        out.println("return;");
        out.println("}");
        out.println("if(formaChangeConfig.h.value=='')");
        out.println("{");
        out.println("alert('" + paramsRequest.getLocaleString("msg3") + "');");
        out.println("return;");
        out.println("}");
        out.println("if(formaChangeConfig.w.value=='')");
        out.println("{");
        out.println("alert('" + paramsRequest.getLocaleString("msg4") + "');");
        out.println("return;");
        out.println("}");
        out.println("formaChangeConfig.submit();");
        out.println("}");
        out.println("</script>");
        out.println("<fieldset name=\"frmAdmin\"><table width='100%' cellpadding='5' cellspacing='0'>");
        String title = this.getResourceBase().getAttribute("title", "");
        Gadget gadget = new Gadget(url);
        if (title.equals(""))
        {
            try
            {
                title = gadget.getTitle(localeUser);
            }
            catch (Exception e)
            {
                log.error(e);
            //AFUtils.log(e);
            }
        }
        String w = this.getResourceBase().getAttribute("w", gadget.getWidth());
        String h = this.getResourceBase().getAttribute("h", gadget.getHeight());
        out.println("<tr><td class=\"valores\">" + paramsRequest.getLocaleString("titleOfGadget") + ":</td><td><input type='text' size='50'  maxlength='100' name='title' value='" + title + "'></td></tr>");
        out.println("<tr><td class=\"valores\">" + paramsRequest.getLocaleString("width") + ":</td><td><input  type='text' size='3' maxlength='3' name='w' value='" + w + "'></td></tr>");
        out.println("<tr><td class=\"valores\">" + paramsRequest.getLocaleString("height") + ":</td><td><input type='text' size='3' maxlength='3' name='h' value='" + h + "'></td></tr>");
        if (url != null && !url.toString().equals(""))
        {
            Set<String> languages = gadget.getLanguages();
            if (languages.size() > 0)
            {
                String userlanguage = paramsRequest.getUser().getLanguage();
                out.println("<tr><td class=\"valores\">" + paramsRequest.getLocaleString("language") + ":</td><td>");
                out.println("<select  class=\"valores\" name='lang'>");
                for (String lang : languages)
                {
                    Locale locale;
                    int pos = lang.indexOf("-");
                    if (pos == -1)
                    {
                        locale = new Locale(lang);
                    }
                    else
                    {
                        String language = lang.substring(0, pos);
                        String country = lang.substring(pos + 1);
                        locale = new Locale(language, country);
                    }
                    boolean selected = false;
                    if (userlanguage.equals(lang))
                    {
                        selected = true;
                    }
                    out.println("<option " + (selected ? "selected" : "") + " value='" + lang + "'>" + locale.getDisplayName() + "</option>");
                }
                out.println("</select>");
                out.println("</td></tr>");
            }
            try
            {
                for (String name : gadget.getParameterNames())
                {
                    String label = gadget.getDisplayName(name, localeUser);
                    String defaultValue = gadget.getDefaultValue(name, localeUser);
                    String dataType = gadget.getDataType(name);
                    if (dataType == null && gadget.isRequired(name))
                    {
                        out.println("<tr><td >" + label + "</td><td>");
                        out.println("<input  type='text' size='10' name='" + name + "' value='" + defaultValue + "'>");
                        out.println("</td></tr>");
                    }
                    if (dataType != null && gadget.isEnum(name))
                    {
                        out.println("<tr><td class=\"valores\">" + label + "</td><td>");
                        out.println("<select  name='" + name + "'>");

                        Hashtable<String, String> values = gadget.getValues(name, localeUser);
                        for (String value : values.keySet())
                        {
                            boolean selected = false;
                            String displayValue = values.get(value);
                            if (defaultValue != null && !defaultValue.equals("") && displayValue.equals(defaultValue))
                            {
                                selected = true;
                            }
                            if (this.getResourceBase().getAttribute("up_" + name, "").equals(value))
                            {
                                selected = true;
                            }
                            out.println("<option  " + (selected ? "selected" : "") + " value='" + value + "'>" + displayValue + "</option>");
                        }
                        out.println("</select>");
                        out.println("</td></tr>");
                    }

                }
            }
            catch (Exception e)
            {
                log.error(e);
            //AFUtils.log(e);
            }
        }
        SWBResourceURL urlback = paramsRequest.getRenderUrl();
        urlback.setMode(urlback.Mode_ADMIN);
        out.println("</table></fieldset><fieldset><table width='100%'  border='0' cellpadding='5' cellspacing='0'><tr><td colspan='2'><button type='button' dojoType=\"dijit.form.Button\" class='boton' Onclick='javascript:validData()' name='savechanges' value='" + paramsRequest.getLocaleString("changeConfiguration") + "'>" + paramsRequest.getLocaleString("changeConfiguration") + "</button>&nbsp;&nbsp;&nbsp;<button dojoType=\"dijit.form.Button\" class='boton' type='button' name='back' onClick=\" javascript:document.location='" + urlback + "';\" value='" + paramsRequest.getLocaleString("back") + "'>" + paramsRequest.getLocaleString("back") + "</button></form></fieldset></td></tr>");
        out.println("</table></fieldset>");
        out.println("</div>");
        out.close();
    }

    private void showGadget(PrintWriter out, SWBParamRequest paramsRequest)
    {
        Locale localeUser = new Locale(paramsRequest.getUser().getLanguage());
        String url = this.getResourceBase().getAttribute(URL_ATTRIBUTE);
        if (url != null && !url.equals(""))
        {
            try
            {
                Gadget gadget = new Gadget(new URL(url));
                String parameters = gadget.getParameters(this.getResourceBase(), localeUser);
                String w = this.getResourceBase().getAttribute("w", gadget.getWidth());
                String h = this.getResourceBase().getAttribute("h", gadget.getHeight());
                out.println("<iframe scrolling=\"no\" frameborder=\"0\" width=\"" + w + "px\" height=\"" + h + "px\" src=\"" + URL_FRAME + "?url=" + url + parameters + "\"></iframe>");
            }
            catch (IllegalArgumentException e)
            {
                log.error(e);
            //AFUtils.log(e);
            }
            catch (MalformedURLException e)
            {
                log.error(e);
            //AFUtils.log(e);
            }

        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException
    {
        PrintWriter out = response.getWriter();
        showGadget(out, paramsRequest);
        out.close();
    }

    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramsRequest) throws IOException, SWBResourceException
    {
        Locale localeUser = new Locale(paramsRequest.getUser().getLanguage());
        String url = this.getResourceBase().getAttribute(URL_ATTRIBUTE);
        if (url != null && !url.equals(""))
        {
            try
            {
                new Gadget(new URL(url));
            }
            catch (IllegalArgumentException iae)
            {
                this.getResourceBase().setAttribute(URL_ATTRIBUTE, null);
                try
                {
                    this.getResourceBase().updateAttributesToDB();
                }
                catch (Exception e)
                {
                    log.error(e);
                }
                url = null;
            }

        }
        if (url != null && !url.equals(""))
        {
            PrintWriter out = response.getWriter();
            out.println("<div class=\"swbform\"><table width='100%'  border='0' cellpadding='5' cellspacing='0'> ");
            URL urlGadget = new URL(url);
            Gadget gadget = new Gadget(urlGadget);
            try
            {
                String title = gadget.getTitle(localeUser);
                String description = gadget.getDescription(localeUser);
                String image = gadget.getSrcImage(localeUser);
                out.println("<tr><td class='valores'>" + paramsRequest.getLocaleString("googleTitle") + ":</td><td >" + title + "</td></tr>");
                out.println("<tr><td class='valores' colspan='2'>&nbsp;</td></tr>");
                out.println("<tr><td class='valores'><img width='120' height='60' src=\"" + image + "\"></td><td >" + description + "</td></tr>");
                out.println("<tr><td class='valores' colspan='2'>&nbsp;</td></tr>");

            }
            catch (Exception ex)
            {
                log.error(ex);
            //AFUtils.log(ex);
            }

            out.println("<tr><td >" + paramsRequest.getLocaleString("orign") + ":</td><td ><a href='" + url + "' target='_blank'>" + url + "</a></td></tr>");
            if (gadget.getAuthor() != null)
            {
                out.println("<tr><td >" + paramsRequest.getLocaleString("author") + ":</td><td >" + gadget.getAuthor() + "</td><td>");
            }

            if (gadget.getAuthor_Location() != null)
            {
                out.println("<tr><td >" + paramsRequest.getLocaleString("location") + ":</td><td >" + gadget.getAuthor_Location() + "</td><td>");
            }

            out.println("</td></tr>");
            out.println("<tr><td colspan='2'><HR size='1' noshade/></td></tr>");
            SWBResourceURL urlchangeConfig = paramsRequest.getRenderUrl();
            urlchangeConfig.setMode("changeConfig");
            urlchangeConfig.setCallMethod(urlchangeConfig.Call_CONTENT);

            SWBResourceURL urladdFromList = paramsRequest.getRenderUrl();
            urladdFromList.setMode("addFromList");
            urladdFromList.setCallMethod(urladdFromList.Call_CONTENT);
            out.println("<tr><td><form name='frmcambgad' action='" + urladdFromList + "' method='post'><input type='hidden' name='cambgad' value='" + paramsRequest.getLocaleString("addFromList") + "'></input><button dojoType=\"dijit.form.Button\" onClick=\"frmcambgad.submit();\" >" + paramsRequest.getLocaleString("addFromList") + "</button></form></td><td><form name=\"frmurlchangeConfig\" action='" + urlchangeConfig + "' method='post'><input type='hidden' name='cambgad' value='" + paramsRequest.getLocaleString("changeConfiguration") + "'></input><button onClick=\"frmurlchangeConfig.submit();\" type='button' dojoType=\"dijit.form.Button\">" + paramsRequest.getLocaleString("changeConfiguration") + "</button></form></td></tr>");
            out.println("</table></div>");
            out.close();
        }
        if (url == null || url.equals(""))
        {
            doAddFromList(request, response, paramsRequest);
        }
    }
    public void asignGoogleGadget(String url,Hashtable<String,String> values)
    {
        this.getResourceBase().setAttribute(URL_ATTRIBUTE,url);
        for(String key : values.keySet())
        {
            String value=values.get(key);
            this.getResourceBase().setAttribute(key,value);

        }
        try
        {
            this.getResourceBase().updateAttributesToDB();
        }
        catch(Exception e)
        {
            log.error(e);
        }
    }
}
