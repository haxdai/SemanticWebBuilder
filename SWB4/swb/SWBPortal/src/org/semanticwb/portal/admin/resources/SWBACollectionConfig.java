/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.portal.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Collection;
import org.semanticwb.model.FormElement;
import org.semanticwb.model.FormValidateException;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.Traceable;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.platform.SemanticVocabulary;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author juan.fernandez
 */
public class SWBACollectionConfig extends GenericAdmResource {

    private Logger log = SWBUtils.getLogger(SWBACollectionConfig.class);
    private String MODE_FORM = "FORM";
    private HashMap<String,SemanticObject> hmFormEle = null;

    /**
     * Process the mode request by the session user.
     *
     * @param request , this holds the parameters
     * @param response , an answer to the user request
     * @param paramRequest , a list of objects like user, webpage, Resource, ...
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        if (paramRequest.getMode().equals(MODE_FORM)) {
            doForm(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        log.debug("doView(SWBACollectionConfig...)");
        doEdit(request, response, paramRequest);
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramsRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        User user = paramsRequest.getUser();
        String id = request.getParameter("suri");
        String page = request.getParameter("page");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject gobj = ont.getGenericObject(id);

        if(hmFormEle==null)
        {
            //System.out.println("Cargando HM - Form Element");
            hmFormEle = new HashMap<String, SemanticObject>();
            SemanticOntology sont = SWBPlatform.getSemanticMgr().getSchema();
            SemanticVocabulary sv = SWBPlatform.getSemanticMgr().getVocabulary();
            Iterator<SemanticObject> itfe = sv.getSemanticClass(sv.SWB_FORMELEMENT).listInstances(false);//sont.listInstancesOfClass(sv.getSemanticClass(sv.SWB_FORMELEMENT));
            while (itfe.hasNext()) {
                SemanticObject sofe = itfe.next();
                hmFormEle.put(sofe.getURI(), sofe);
                //System.out.println("formElement: "+sofe.getId());
            }
        }
        String action = request.getParameter("act");
        if (action == null) {
            action = "";
        }

        if (request.getParameter("dialog") != null && request.getParameter("dialog").equals("close")) {
            out.println("<script type=\"javascript\">");
            out.println(" hideDialog(); ");
            out.println(" reloadTab('" + id + "'); ");
            out.println("</script>");
            return;
        }

        out.println("<script type=\"text/javascript\">");
        if (request.getParameter("nsuri") != null && request.getParameter("nsuri").trim().length() > 0) {
            SemanticObject snobj = ont.getSemanticObject(request.getParameter("nsuri"));
            if (snobj != null) {
                log.debug("addNewTab");
                out.println("  addNewTab('" + snobj.getURI() + "','" + SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + SWBUtils.TEXT.scape4Script(snobj.getDisplayName()) + "');");
            }
        }

        if (request.getParameter("statmsg") != null && request.getParameter("statmsg").trim().length() > 0) {
            log.debug("showStatus");
            out.println("   showStatus('" + request.getParameter("statmsg") + "');");
        }

        if (request.getParameter("closetab") != null && request.getParameter("closetab").trim().length() > 0) {
            log.debug("closeTab..." + request.getParameter("closetab"));
            out.println("   closeTab('" + request.getParameter("closetab") + "');");
        }
        out.println("</script>");

        Collection col = null;
        if (action.equals("config")) {
            if (gobj instanceof Collection) {
                col = (Collection) gobj;

                if (col.getCollectionClass() != null) {
                    SemanticClass sccol = col.getCollectionClass().transformToSemanticClass();
                    
                    HashMap<String, String> hmcol = new HashMap();
                    HashMap<String, String> hmbus = new HashMap();
                    HashMap<String, String> hmFE = new HashMap();

                    Iterator<String> its = col.listListPropertieses();
                    while (its.hasNext()) {
                        String spropname = its.next();
                        StringTokenizer stoken = new StringTokenizer(spropname,"|");
                        String suriprop = stoken.nextToken();
                        String surife = stoken.nextToken();
                        String sindice = stoken.nextToken();
                        
                        if(stoken!=null)
                        {
                            hmcol.put(suriprop,sindice);
                        }
                        else
                            hmcol.put(spropname, spropname);
                    }
                    its = col.listSearchPropertieses();
                    while (its.hasNext()) {
                        String spropname = its.next();
                        StringTokenizer stoken = new StringTokenizer(spropname,"|");

                        if(spropname.indexOf("|")!=-1&&stoken!=null)
                        {
                            //System.out.println("tokens: "+spropname);
                            String spropuri = stoken.nextToken();
                            String propFE = stoken.nextToken();
                            String colOrder = stoken.nextToken();
                            hmbus.put(spropuri, colOrder);
                            hmFE.put(spropuri,propFE);
                        }
                        else
                        {
                           hmbus.put(spropname, spropname);
                        }
                    }


                    SWBResourceURL urlconf = paramsRequest.getActionUrl();
                    urlconf.setAction("updconfig");
                    urlconf.setParameter("ract","config");


                    out.println("<div class=\"swbform\">");
                    out.println("<form type=\"dijit.form.Form\" id=\"" + id + "/collectionconfig\" name=\"" + id + "/collectionconfig\" action=\"" + urlconf + "\" method=\"post\" onsubmit=\"submitForm('" + id + "/collectionconfig'); return false;\"  >"); //
                    out.println("<input type=\"hidden\" name=\"suri\" value=\"" + id + "\">");
                    out.println("<input type=\"hidden\" name=\"act\" value=\"\">");
                    out.println("<input type=\"hidden\" id=\""+id+"_actbutton\" name=\"actbutton\" value=\"\">");

                    out.println("<fieldset>");
                    out.println("<legend>" + "Configuración de colección" + " " + col.getDisplayTitle(user.getLanguage()) + "</legend>");
                    out.println("<ul style=\"list-style:none;\">");
                    out.println("<li>");
                    out.println("<label for=\"" + id + "_classname\">" + "Clase asociada" + "</label>");
                    out.println("<input type=\"text\" name=\"classname\" value=\"" + col.getCollectionClass().getDisplayName(user.getLanguage()) + "\" readonly >");

                    SWBResourceURL urln = paramsRequest.getRenderUrl();
                    urln.setParameter("act", "");
                    urln.setParameter("suri", id);
                    urln.setParameter("clsuri", sccol.getURI());
                    urln.setMode(MODE_FORM);

                    out.println("<button dojoType=\"dijit.form.Button\" type=\"button\" onclick=\"submitUrl('" + urln + "',this.domNode); return false;\" >" + paramsRequest.getLocaleString("Add_Instance") + "</button>");

                    out.println("</li>");

                    out.println("</ul>");
                    out.println("</fieldset>");
                    out.println("<fieldset>");
                    out.println("<legend>Seleccionar propiedad a desplegar y el tipo de control a utilizar.</legend>");
                    out.println("<ul style=\"list-style:none;\">");
                    out.println("<li><label for=\""+id+"_semprop\">");
                    out.println("Propiedad/FormElement:");
                    out.println("</label>");
                    out.println("<select id=\""+id+"_semprop\" name=\"semprop\">");
                    out.println("<option value=\"\">");
                    out.println("");
                    out.println("</option>");
                    Iterator<SemanticProperty> itsemprop = sccol.listProperties();
                    while (itsemprop.hasNext()) {
                        SemanticProperty semProp = itsemprop.next();
                        out.println("<option value=\""+semProp.getURI()+"\">");
                        out.println(semProp.getDisplayName(user.getLanguage()));
                        out.println("</option>");
                    }
                    out.println("</select>");
                    out.println("<select id=\"" + id + "_sempropFE\" name=\"sempropFE\" >");
                    out.println(getFESelect(hmFormEle,"",user));
                    out.println("</select>");
                    out.println("</li>");
                    out.println("</ul>");
                    out.println("</fieldset>");
                    out.println("<fieldset>");
                    out.println("<button dojoType=\"dijit.form.Button\" _type=\"button\"  id=\""+id+"_btnDisp\">" + paramsRequest.getLocaleString("btnAdd2display"));
                    out.println("<script type=\"dojo/method\" event=\"onClick\" >");
                    //out.println(" var miform = dojo.byId('"+ id + "/collectionconfig'); ");
                    out.println(" var actbut = dojo.byId('"+id+"_actbutton'); ");
                    out.println(" actbut.value='display'; ");
                    out.println(" submitForm('" + id + "/collectionconfig'); ");
                    out.println(" return false; ");
                    out.println("</script>");
                    out.println("</button>");
                    out.println("<button dojoType=\"dijit.form.Button\" _type=\"submit\"  id=\""+id+"_btnSear\">" + paramsRequest.getLocaleString("btnAdd2search") );
                    out.println("<script type=\"dojo/method\" event=\"onClick\" >");
                    out.println(" var actbut = dojo.byId('"+id+"_actbutton'); ");
                    out.println(" actbut.value='search';");
                    out.println(" submitForm('" + id + "/collectionconfig'); ");
                    out.println(" return false; ");
                    out.println("</script>");
                    out.println("</button>");
                    out.println("<button dojoType=\"dijit.form.Button\" _type=\"submit\"  id=\""+id+"_btnBoth\">" + paramsRequest.getLocaleString("btnAdd2both") );
                    out.println("<script type=\"dojo/method\" event=\"onClick\" >");
                    out.println(" var actbut = dojo.byId('"+id+"_actbutton'); ");
                    out.println(" actbut.value='both';");
                    out.println(" submitForm('" + id + "/collectionconfig'); ");
                    out.println(" return false; ");
                    out.println("</script>");
                    out.println("</button>");
                    out.println("</fieldset>");

                    out.println("<div id=\"configcol/"+id+"\" dojoType=\"dijit.TitlePane\" title=\"Configuración despliegue\" class=\"admViewProperties\" open=\"false\" duration=\"150\" minSize_=\"20\" splitter_=\"true\" region=\"bottom\">");
                    out.println("<fieldset>");

                    out.println("<table width=\"100%\">");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>");
                    out.println(paramsRequest.getLocaleString("th_action"));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(paramsRequest.getLocaleString("th_property"));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(paramsRequest.getLocaleString("th_formelement"));
                    out.println("</th>");
                    out.println("</tr>");
                    out.println("</thead>");

                    out.println("<tbody>");

                    String semprop = null;
                    String sempropFE = null;
                    String sorder = null;

                    Iterator<String> itdis = col.listListPropertieses();
                    while(itdis.hasNext())
                    {
                        String lprop = itdis.next();
                        //System.out.println("valor display ..."+lprop);
                        try
                        {
                            StringTokenizer stoken = new StringTokenizer(lprop,"|");
                            semprop = stoken.nextToken();
                            sempropFE = stoken.nextToken();
                            sorder = stoken.nextToken();
                        }
                        catch(Exception e)
                        {
                            log.error("Error in display class property.", e);
                            continue;
                        }
                        out.println("<tr>");
                        out.println("<td align=\"center\">");
                        SWBResourceURL urlrem = paramsRequest.getActionUrl();
                        urlrem.setAction("remove");
                        urlrem.setParameter("suri", id);
                        urlrem.setParameter("sval", lprop);
                        urlrem.setParameter("prop", "display");
                        urlrem.setParameter("ract", "config");
                        out.println("<a href=\"#\" onclick=\"submitUrl('"+urlrem+"',this); return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" alt=\"" + paramsRequest.getLocaleString("remove") + "\"></a>");
                        out.println("</td>");
                        out.println("<td>");
                        out.println(ont.getSemanticProperty(semprop).getDisplayName(user.getLanguage()));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(ont.getSemanticProperty(sempropFE).getDisplayName(user.getLanguage()));
                        out.println("</td>");
                        out.println("</tr>");
                    }

                    out.println("</tbody>");
                    out.println("</table>");


                    out.println("    <script type=\"dojo/method\" event=\"postCreate\" args=\"\" >");
                    out.println("        if(!this.open){");
                    out.println("            this.hideNode.style.display=this.wipeNode.style.display=\"none\";");
                    out.println("        }");
                    out.println("        this._setCss();");
                    out.println("        dojo.setSelectable(this.titleNode,false);");
                    out.println("        dijit.setWaiState(this.containerNode,\"labelledby\",this.titleNode.id);");
                    out.println("        dijit.setWaiState(this.focusNode,\"haspopup\",\"true\");");
                    out.println("        var _1=this.hideNode,_2=this.wipeNode;");
                    out.println("        this._wipeIn=dojo.fx.wipeIn({");
                    out.println("            node:this.wipeNode,");
                    out.println("            duration:this.duration,");
                    out.println("            beforeBegin:function(){");
                    out.println("                _1.style.display=\"\";");
                    out.println("            },");
                    out.println("            onEnd:function(){");
                    out.println("                //alert(\"open\");");
                    out.println("                dijit.byId(\"leftSplit\").layout();");
                    out.println("            }");
                    out.println("            });");
                    out.println("        this._wipeOut=dojo.fx.wipeOut({");
                    out.println("            node:this.wipeNode,");
                    out.println("            duration:this.duration,");
                    out.println("            onEnd:function(){");
                    out.println("                _1.style.display=\"none\";");
                    out.println("                //alert(\"close\");");
                    out.println("                dijit.byId(\"leftSplit\").layout();");
                    out.println("            }");
                    out.println("            });");
                            //this.inherited(arguments);
                    out.println("    </script>");
                    out.println("</fieldset>");
                    out.println("</div>");

                    
                    out.println("<div id=\"configbus/"+id+"\" dojoType=\"dijit.TitlePane\" title=\"Configuración busqueda\" class=\"admViewProperties\" open=\"false\" duration=\"150\" minSize_=\"20\" splitter_=\"true\" region=\"bottom\">");
                    out.println("<fieldset>");

                    out.println("<table width=\"100%\">");
                    out.println("<thead>");
                    out.println("<tr>");
                    out.println("<th>");
                    out.println(paramsRequest.getLocaleString("th_action"));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(paramsRequest.getLocaleString("th_property"));
                    out.println("</th>");
                    out.println("<th>");
                    out.println(paramsRequest.getLocaleString("th_formelement"));
                    out.println("</th>");
                    out.println("</tr>");
                    out.println("</thead>");

                    out.println("<tbody>");

                    semprop = null;
                    sempropFE = null;
                    sorder = null;

                    itdis = col.listSearchPropertieses();
                    while(itdis.hasNext())
                    {
                        String lprop = itdis.next();
                        try
                        {
                            StringTokenizer stoken = new StringTokenizer(lprop,"|");
                            semprop = stoken.nextToken();
                            sempropFE = stoken.nextToken();
                            sorder = stoken.nextToken();
                        }
                        catch(Exception e)
                        {
                            log.error("Error in search class property.", e);
                            continue;
                        }
                        out.println("<tr>");
                        out.println("<td>");
                        SWBResourceURL urlrem = paramsRequest.getActionUrl();
                        urlrem.setAction("remove");
                        urlrem.setParameter("suri", id);
                        urlrem.setParameter("sval", lprop);
                        urlrem.setParameter("prop", "search");
                        urlrem.setParameter("ract", "config");
                        out.println("<a href=\"#\" onclick=\"submitUrl('"+urlrem+"',this); return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" alt=\"" + paramsRequest.getLocaleString("remove") + "\"></a>");
                        out.println("</td>");
                        out.println("<td>");
                        out.println(ont.getSemanticProperty(semprop).getDisplayName(user.getLanguage()));
                        out.println("</td>");
                        out.println("<td>");
                        out.println(ont.getSemanticProperty(sempropFE).getDisplayName(user.getLanguage()));
                        out.println("</td>");
                        out.println("</tr>");
                    }

                    out.println("</tbody>");
                    out.println("</table>");
                    
                    out.println("    <script type=\"dojo/method\" event=\"postCreate\" args=\"\" >");
                    out.println("        if(!this.open){");
                    out.println("            this.hideNode.style.display=this.wipeNode.style.display=\"none\";");
                    out.println("        }");
                    out.println("        this._setCss();");
                    out.println("        dojo.setSelectable(this.titleNode,false);");
                    out.println("        dijit.setWaiState(this.containerNode,\"labelledby\",this.titleNode.id);");
                    out.println("        dijit.setWaiState(this.focusNode,\"haspopup\",\"true\");");
                    out.println("        var _1=this.hideNode,_2=this.wipeNode;");
                    out.println("        this._wipeIn=dojo.fx.wipeIn({");
                    out.println("            node:this.wipeNode,");
                    out.println("            duration:this.duration,");
                    out.println("            beforeBegin:function(){");
                    out.println("                _1.style.display=\"\";");
                    out.println("            },");
                    out.println("            onEnd:function(){");
                    out.println("                //alert(\"open\");");
                    out.println("                dijit.byId(\"leftSplit\").layout();");
                    out.println("            }");
                    out.println("            });");
                    out.println("        this._wipeOut=dojo.fx.wipeOut({");
                    out.println("            node:this.wipeNode,");
                    out.println("            duration:this.duration,");
                    out.println("            onEnd:function(){");
                    out.println("                _1.style.display=\"none\";");
                    out.println("                //alert(\"close\");");
                    out.println("                dijit.byId(\"leftSplit\").layout();");
                    out.println("            }");
                    out.println("            });");
                            //this.inherited(arguments);
                    out.println("    </script>");
                    out.println("</fieldset>");
                    out.println("</div>");

                    SWBResourceURL url = paramsRequest.getRenderUrl();
                    url.setParameter("act", "stpBusqueda");
                    url.setParameter("suri", id);
                    out.println("<fieldset>");
                    //out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\"  >" + paramsRequest.getLocaleString("Save_config") + "</button>");
                    out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + url + "',this.domNode); return false;\">" + paramsRequest.getLocaleString("frmBusqueda") + "</button>"); //
                    out.println("</fieldset>");
                    out.println("</form >");
                    out.println("</div >");
                } else {
                    out.println("<div class=\"swbform\">");
                    out.println("<fieldset>");
                    out.println("<legend>" + paramsRequest.getLocaleString("erroMsgConfig") + " \"" + col.getDisplayTitle(user.getLanguage()) + "\" </legend>");
                    out.println("<ul style=\"list-style:none;\">");
                    out.println("<li>");
                    out.println(paramsRequest.getLocaleString("msgMissingConfigClass"));
                    out.println("</li>");
                    out.println("<li>");
                    out.println(paramsRequest.getLocaleString("msgConfigInstructions"));
                    out.println("</li>");
                    out.println("</ul>");
                    out.println("</fieldset>");
                    SWBResourceURL urlreload = paramsRequest.getRenderUrl();
                    urlreload.setParameter("act", "");
                    urlreload.setParameter("suri", id);
                    out.println("<fieldset>");
                    out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlreload + "',this.domNode); return false;\">" + paramsRequest.getLocaleString("btnReload") + "</button>"); //
                    out.println("</fieldset>");
                    out.println("</div>");
                }
            }

        } else if ("stpBusqueda".equals(action) || "".equals(action)) {

            //System.out.println("ID: "+id);
            String busqueda = request.getParameter("search");
            if (null == busqueda) {
                busqueda = "";
            }
            busqueda = busqueda.trim();
            HashMap<String, String> hmhasprop = new HashMap(); // uri property, uri form element asociado
            HashMap<String, SemanticProperty> hmhasproporder = new HashMap(); // indice filtro, PROPIEDAD
            HashMap<String, SemanticProperty> hmConfcol = new HashMap();
            HashMap<String, String> hmConfcolFE = new HashMap();
            HashMap<String, SemanticProperty> hmConfbus = new HashMap();
            HashMap<String, SemanticObject> hmfiltro = new HashMap();
            HashMap<String, SemanticObject> hmSearchParam = new HashMap();
            if (gobj instanceof Collection) {
                col = (Collection) gobj;
                if (col.getCollectionClass() == null) {

                    out.println("<div class=\"swbform\">");
                    out.println("<fieldset>");
                    out.println("<legend>" + paramsRequest.getLocaleString("erroMsgConfig") + " \"" + col.getDisplayTitle(user.getLanguage()) + "\" </legend>");
                    out.println("<ul style=\"list-style:none;\">");
                    out.println("<li>");
                    out.println(paramsRequest.getLocaleString("msgMissingConfigClass"));
                    out.println("</li>");
                    out.println("<li>");
                    out.println(paramsRequest.getLocaleString("msgConfigInstructions"));
                    out.println("</li>");
                    out.println("</ul>");
                    out.println("</fieldset>");
                    SWBResourceURL urlreload = paramsRequest.getRenderUrl();
                    urlreload.setParameter("act", "");
                    urlreload.setParameter("suri", id);
                    out.println("<fieldset>");
                    out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlreload + "',this.domNode); return false;\">" + paramsRequest.getLocaleString("btnReload") + "</button>"); //
                    out.println("</fieldset>");
                    out.println("</div>");
                } else {
                    SemanticClass sccol = col.getCollectionClass().transformToSemanticClass();

                    SemanticProperty semProphm = null;
                    Iterator<String> its = col.listListPropertieses();
                    while (its.hasNext()) {
                        String spropname = its.next();
                        StringTokenizer stoken = new StringTokenizer(spropname,"|");
                        //System.out.println("spropname: "+spropname);
                        if(stoken!=null)
                        {
                            String suri = stoken.nextToken();
                            String surife = stoken.nextToken();
                            String suriorder = stoken.nextToken();
                            semProphm = ont.getSemanticProperty(suri);
                            if(semProphm!=null){
                                hmConfcol.put(suriorder, semProphm);
                                hmConfcolFE.put(suriorder,surife);
                            }
                        }
                        else
                        {
                            semProphm = ont.getSemanticProperty(spropname);
                            if(semProphm!=null) hmConfcol.put(spropname, semProphm);
                        }
                    }


                    ArrayList list = new ArrayList(hmConfcol.keySet());
                    Collections.sort(list);

                    semProphm = null;
                    its = col.listSearchPropertieses();
                    while (its.hasNext()) {
                        String spropname = its.next();
                        StringTokenizer stoken = new StringTokenizer(spropname,"|");
                        //System.out.println("spropname: "+spropname);
                        if(stoken!=null)
                        {
                            String suri = stoken.nextToken();
                            String surife = stoken.nextToken();
                            String suriorder = stoken.nextToken();
                            semProphm = ont.getSemanticProperty(suri);
                            //System.out.println("spropnameSearch: "+suri);
                            if(semProphm!=null) hmConfbus.put(suri, semProphm);
                            if(semProphm.isObjectProperty())
                            {
                                hmhasprop.put(suri, surife);
                                hmhasproporder.put(suriorder,semProphm);
                            }
                        }
                        

                    }

                    if (hmConfcol.size() > 0) {

                        //Armado de tabla
                        out.println("<div class=\"swbform\">");
                        out.println("<div id=\"filterprop/"+id+"\" dojoType=\"dijit.TitlePane\" title=\"Búsqueda y Filtrado de elementos\" class=\"admViewProperties\" open=\"false\" duration=\"150\" minSize_=\"20\" splitter_=\"true\" region=\"bottom\">");
                        SWBResourceURL urls = paramsRequest.getRenderUrl();
                        urls.setParameter("act", "stpBusqueda");
                        urls.setParameter("act2", "ssearch");
                        out.println("<form id=\"" + id + "/fsearch\" name=\"" + id + "/fsearch\" method=\"post\" action=\"" + urls + "\" onsubmit=\"submitForm('" + id + "/fsearch');return false;\">");
                        out.println("<input type=\"hidden\" name=\"suri\" value=\"" + id + "\">");
                        out.println("<fieldset>");
                        out.println("<table width=\"100%\" >");
                        out.println("<tr><td colspan=\"2\">&nbsp;</td></tr>");
                        out.println("<tr><td align=\"right\" width=\"200\">");
                        out.println("<label for=\"" + id + "_search\">" + paramsRequest.getLocaleString("searchInProperties") + ": </label>");
                        out.println("</td><td>");
                        out.println("<input type=\"text\" name=\"search\" id=\"" + id + "_search\" value=\"" + busqueda + "\">");
                        out.println("</td><tr>");

                        HashMap<String,SemanticObject> hmFilterSearch = new HashMap();

                        //
                        // REVISION DE OBJECT-PROPERTIES PARA OPCIONES DE FILTRADO
                        //

                        // TODO: Ordenarlo en de acuerdo con el orden de agregado en la configuración

                        ArrayList listfilters = new ArrayList(hmhasproporder.keySet());
                        Collections.sort(listfilters);

                        Iterator<String> itsprop = listfilters.iterator();
                        while (itsprop.hasNext()) {
                            //System.out.println("revisando object properties");
                            String urikey = itsprop.next();
                            SemanticProperty semanticProp = hmhasproporder.get(urikey);
                            SemanticClass sc = semanticProp.getRangeClass();
                            if(sc!=null)
                            {

                                //System.out.println("Property: "+request.getParameter(semanticProp.getName()));

                                out.println("<tr>");
                                String paramsearch = null;
                                if(request.getParameter("search_"+sc.getClassId())!=null&&request.getParameter("search_"+sc.getClassId()).trim().length()>0)
                                {
                                    paramsearch=request.getParameter("search_"+sc.getClassId());
                                    hmSearchParam.put("search_"+sc.getClassId(), ont.getSemanticObject(paramsearch));
                                    
                                }

                                if(request.getParameter(semanticProp.getName())!=null&&request.getParameter(semanticProp.getName()).trim().length()>0)
                                    hmSearchParam.put("search_"+semanticProp.getName(), ont.getSemanticObject(request.getParameter(semanticProp.getName())));

                                out.println("<td align=\"right\">");
                                out.println("<label for=\"" + sc.getURI() + "_search\">" + sc.getDisplayName(user.getLanguage()) + ": </label></td><td><select name=\"search_"+sc.getClassId()+"\" id=\"" + sc.getURI() + "_search\" >");
                                out.println("<option value=\"\" selected >Selecciona filtro");
                                out.println("</option>");

//                                DisplayProperty dp = new DisplayProperty(semanticProp.getDisplayProperty());
//                                if(dp!=null)System.out.println("DisplayProperty:"+dp.getDisplaySelectValues(user.getLanguage()));

                                SemanticModel smodel = gobj.getSemanticObject().getModel();
//                                if(smodel.getModelObject().getGenericInstance()!=null && smodel.getModelObject().getGenericInstance() instanceof WebSite)
//                                {
//
//                                }
                                Iterator<SemanticObject> sobj = smodel.listInstancesOfClass(sc); //sc.listInstances();
                                if(sc.equals(User.swb_User))
                                {
                                    sobj = sc.listInstances();
//                                    if(smodel.getModelObject().getGenericInstance()!=null && smodel.getModelObject().getGenericInstance() instanceof WebSite)
//                                    {
//                                      sobj =  ((WebSite)smodel.getModelObject().getGenericInstance()).getUserRepository().getSemanticObject().getModel().listInstancesOfClass(sc);
//                                    }
                                }

                                

                                while (sobj.hasNext()) {
                                    SemanticObject semanticObject = sobj.next();
                                    out.println("<option value=\"" + semanticObject.getURI() + "\" "+(paramsearch!=null&&paramsearch.equals(semanticObject.getURI())?"selected":"")+">");
                                    out.println(semanticObject.getDisplayName(user.getLanguage()));
                                    out.println("</option>");
                                    if(paramsearch!=null&&paramsearch.equals(semanticObject.getURI()))hmFilterSearch.put(semanticObject.getURI(), semanticObject);
                                }
                                out.println("</select>");

                                SWBFormMgr fmgr = new SWBFormMgr(gobj.getSemanticObject(),SWBFormMgr.MODE_EDIT,SWBFormMgr.MODE_EDIT);

                                //TODO: Hacer el render de la propiedad y el FormElement configurado
                                SemanticObject sofe = ont.getSemanticObject(hmhasprop.get(semanticProp.getURI()));
                                
                                if(null!=sofe)
                                {
                                    System.out.println("FE.asoc..:---"+sofe.getURI()+"---");
                                }
                                else
                                {
                                    System.out.println("No es form Element");
                                }

                                if(null!=semanticProp) out.println(fmgr.renderElement(request, semanticProp, SWBFormMgr.MODE_EDIT));

                               
                                
                                out.println("</td>");
                                out.println("</tr>");
                            }
                        }
                        out.println("<tr><td colspn=\"2\">&nbsp;</td></tr>");
                        out.println("</table>");
                        out.println("</fieldset>");
                        out.println("<fieldset>");
                        out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\">" + paramsRequest.getLocaleString("btnSearch") + "</button>"); //
                        out.println("</fieldset>");
                        out.println("</form>");

                    out.println("    <script type=\"dojo/method\" event=\"postCreate\" args=\"\" >");
                    out.println("        if(!this.open){");
                    out.println("            this.hideNode.style.display=this.wipeNode.style.display=\"none\";");
                    out.println("        }");
                    out.println("        this._setCss();");
                    out.println("        dojo.setSelectable(this.titleNode,false);");
                    out.println("        dijit.setWaiState(this.containerNode,\"labelledby\",this.titleNode.id);");
                    out.println("        dijit.setWaiState(this.focusNode,\"haspopup\",\"true\");");
                    out.println("        var _1=this.hideNode,_2=this.wipeNode;");
                    out.println("        this._wipeIn=dojo.fx.wipeIn({");
                    out.println("            node:this.wipeNode,");
                    out.println("            duration:this.duration,");
                    out.println("            beforeBegin:function(){");
                    out.println("                _1.style.display=\"\";");
                    out.println("            },");
                    out.println("            onEnd:function(){");
                    out.println("                //alert(\"open\");");
                    out.println("                dijit.byId(\"leftSplit\").layout();");
                    out.println("            }");
                    out.println("            });");
                    out.println("        this._wipeOut=dojo.fx.wipeOut({");
                    out.println("            node:this.wipeNode,");
                    out.println("            duration:this.duration,");
                    out.println("            onEnd:function(){");
                    out.println("                _1.style.display=\"none\";");
                    out.println("                //alert(\"close\");");
                    out.println("                dijit.byId(\"leftSplit\").layout();");
                    out.println("            }");
                    out.println("            });");
                            //this.inherited(arguments);
                    out.println("    </script>");
                    out.println("</div>");
                        
                        out.println("<fieldset>");
                        out.println("<table width=\"100%\">");
                        out.println("<thead>");
                        out.println("<tr>");
                        out.println("<th>");
                        out.println("&nbsp;");
                        out.println("</th>");

                        Iterator<String> itcol = list.iterator(); //hmConfcol.keySet().iterator();
                        while (itcol.hasNext()) {
                            String key = itcol.next();
                            SemanticProperty scol = hmConfcol.get(key);
                            out.println("<th>");
                            out.println(scol.getDisplayName(user.getLanguage()));
                            out.println("</th>");
                        }
                        out.println("</tr>");
                        out.println("</thead>");
                        out.println("<tbody>");
                        SemanticObject semO = null;
                        Iterator<SemanticObject> itso = gobj.getSemanticObject().getModel().listInstancesOfClass(sccol); //sccol.listInstances();
                        String urikey = null;
                        SemanticProperty semOProp=null;
                        if (!busqueda.equals("")) {
                            while (itso.hasNext()) {
                                semO = itso.next();
                                itcol = hmConfcol.keySet().iterator();

                                String occ = "";
                                while (itcol.hasNext()) {
                                    String sprop = itcol.next();
                                    semOProp = hmConfcol.get(sprop);
                                    urikey = semOProp.getURI();
                                    if (hmConfbus.get(urikey) != null) {
                                        occ = occ + reviewSemProp(hmConfbus.get(urikey), semO, paramsRequest);
                                    }
                                }
                                occ = occ.toLowerCase();
                                if (occ.indexOf(busqueda.toLowerCase()) > -1) {
                                    hmfiltro.put(semO.getURI(), semO);
                                }
                            }
                        }

                        //Llenado de la tabla

                        if (!busqueda.equals("")||!hmSearchParam.isEmpty()) {

                            HashMap<String, SemanticObject> hmResults = new HashMap();
                            HashMap<String, SemanticObject> hmRemove = new HashMap();
                            Iterator<SemanticObject> itsprop2 = null;
                            if(!busqueda.equals("")||(!busqueda.equals("")&&!hmSearchParam.isEmpty()))
                            {
                                itsprop2 = hmfiltro.values().iterator();
                            }
                            else if(busqueda.equals("")&&!hmSearchParam.isEmpty())
                            {
                                itsprop2 = gobj.getSemanticObject().getModel().listInstancesOfClass(sccol);
                            }

                            if(!hmSearchParam.isEmpty())
                            {
                                while (itsprop2.hasNext())
                                {
                                    //System.out.println("Filtrado por tipo de elementos");
                                    SemanticObject sofil = itsprop2.next();

                                    Iterator<SemanticProperty> sempropit = hmConfbus.values().iterator();
                                    while (sempropit.hasNext()) {

                                        SemanticProperty semanticProp = sempropit.next();
                                        //System.out.println("Revisando propiedad: "+semanticProp.getName());
                                        if(semanticProp.isObjectProperty())
                                        {
                                            //System.out.println("Object property....");
                                            SemanticClass semclass = semanticProp.getRangeClass();
                                            if(semclass!=null)
                                            {
                                                //System.out.println("class id: "+semclass.getClassId());
                                                if(hmSearchParam.get("search_"+semclass.getClassId())!=null)
                                                {
                                                    //System.out.println("Aplica Filtro encontrado...");
                                                    SemanticObject so = hmSearchParam.get("search_"+semclass.getClassId());
                                                    String URIfilter = so.getURI();

                                                    SemanticObject sotmp = sofil.getObjectProperty(semanticProp);
                                                    //System.out.println("comparando "+URIfilter+ " con "+(sotmp!=null?sotmp.getURI():"nulo"));
                                                    if(sotmp!=null&&sotmp.getURI().equals(URIfilter))
                                                    {
                                                        //System.out.println("Conservando elemento.");
                                                        hmResults.put(sofil.getURI(), sofil);
                                                    }
                                                    else
                                                    {
                                                        //System.out.println("Quitando elemento");
                                                        hmRemove.put(sofil.getURI(), sofil);
                                                        
                                                    }
                                                }
                                                if(hmSearchParam.get("search_"+semanticProp.getName())!=null)
                                                {
                                                    //System.out.println("Aplica Filtro encontrado...");
                                                    SemanticObject so = hmSearchParam.get("search_"+semanticProp.getName());
                                                    String URIfilter = so.getURI();

                                                    SemanticObject sotmp = sofil.getObjectProperty(semanticProp);
                                                    //System.out.println("propName comparando "+URIfilter+ " con "+(sotmp!=null?sotmp.getURI():"nulo"));
                                                    if(sotmp!=null&&sotmp.getURI().equals(URIfilter))
                                                    {
                                                        //System.out.println("Conservando elemento.");
                                                        hmResults.put(sofil.getURI(), sofil);
                                                    }
                                                    else
                                                    {
                                                        //System.out.println("Quitando elemento");
                                                        hmRemove.put(sofil.getURI(), sofil);

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                //limpiando el filtro
                                hmfiltro=new HashMap();
                                Iterator<SemanticObject> itresults = hmResults.values().iterator();
                                while (itresults.hasNext()) {
                                    SemanticObject semObject = itresults.next();
                                    if(hmRemove.get(semObject.getURI())==null)
                                    {
                                        //pasando elementos válidos
                                        hmfiltro.put(semObject.getURI(), semObject);
                                    }
                                }
                            }

                            itso = hmfiltro.values().iterator();

                        } else {
                            itso = gobj.getSemanticObject().getModel().listInstancesOfClass(sccol); //sccol.listInstances();
                        }

                        //PAGINACION


                        List<SemanticObject> cplist = SWBUtils.Collections.copyIterator(itso);
                        Set<SemanticObject> setso = null;
                        if(sccol.isSubClass(Traceable.swb_Traceable))
                        {
                            if(cplist.size()>1)
                            {
                                setso = SWBComparator.sortByCreatedSet(cplist.iterator(),false);
                                itso=setso.iterator();
                            }
                            else
                            {

                                itso = cplist.iterator();
                            }
                        }
                        else
                        {
                            itso = cplist.iterator();
                        }
                        int ps=20;
                        int l=cplist.size();
                        int p=0;
                        if(page!=null)p=Integer.parseInt(page);
                        int x=0;
                        //itso=setso.iterator();
                        /////////////////////////////////

                        while (itso.hasNext()) {

                            semO = itso.next();

                            //PAGINACION ////////////////////
                            if(x<p*ps)
                            {
                                x++;
                                continue;
                            }
                            if(x==(p*ps+ps) || x==l)break;
                            x++;
                            /////////////////////////////////

                            out.println("<tr>");
                            out.println("<td>");

                            SWBResourceURL urlr = paramsRequest.getActionUrl();
                            urlr.setParameter("suri", id);
                            urlr.setParameter("sval", semO.getURI());
                            urlr.setParameter("ract", action);
                            //urlr.setParameter("page", ""+p);
                            urlr.setAction("remove");
                            out.println("<a href=\"#\" title=\"" + paramsRequest.getLocaleString("remove") + "\" onclick=\"if(confirm('" + paramsRequest.getLocaleString("confirm_remove") + " " + SWBUtils.TEXT.scape4Script(semO.getDisplayName(user.getLanguage())) + "?')){ submitUrl('" + urlr + "',this); } else { return false;}\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" alt=\"" + paramsRequest.getLocaleString("remove") + "\"></a>");
                            out.println("<a href=\"#\"  title=\"" + paramsRequest.getLocaleString("documentAdmin") + "\" onclick=\"selectTab('" + semO.getURI() + "','" + SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + SWBUtils.TEXT.scape4Script(semO.getDisplayName()) + "','bh_AdminPorltet');return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/editar_1.gif\" border=\"0\" alt=\"" + paramsRequest.getLocaleString("documentAdmin") + "\"></a>");
                            out.println("</td>");
                            //itcol = hmConfcol.keySet().iterator();
                            itcol = list.iterator();
                            while (itcol.hasNext()) {
                                String scol = itcol.next();
                                if (hmConfcol.get(scol) != null) {
                                    out.println("<td>");
                                    out.println(reviewSemProp(hmConfcol.get(scol), semO, paramsRequest));
                                    out.println("</td>");
                                }
                            }
                            out.println("</tr>");

                        }
                        out.println("</tbody>");

                        //boton para agregar instancia
                        out.println("</table>");
                        out.println("</fieldset>");

                        if(p>0 || x<l) //Requiere paginacion
                        {
                            out.println("<fieldset>");
                            out.println("<center>");
                            int pages=(int)(l+ps/2)/ps;
                            for(int z=0;z<pages;z++)
                            {
                                SWBResourceURL urlNew = paramsRequest.getRenderUrl();
                                urlNew.setParameter("suri", id);
                                urlNew.setParameter("page", ""+z);
                                urlNew.setParameter("act", "stpBusqueda");
                                urlNew.setParameter("search",busqueda);
                                urlNew.setParameter("clsuri", sccol.getURI());
                                
                                if(z!=p)
                                {
                                    out.println("<a href=\"#\" onclick=\"submitUrl('" + urlNew + "',this); return false;\">"+(z+1)+"</a> ");
                                }else
                                {
                                    out.println((z+1)+" ");
                                }
                            }
                            out.println("</center>");
                            out.println("</fieldset>");
                        }


                        SWBResourceURL url = paramsRequest.getRenderUrl();
                        url.setParameter("act", "stpBusqueda");
                        url.setParameter("suri", id);
                        url.setParameter("clsuri", sccol.getURI());
                        url.setMode(MODE_FORM);
                        SWBResourceURL urlback = paramsRequest.getRenderUrl();
                        urlback.setParameter("act", "config");
                        urlback.setParameter("suri", id);
                        out.println("<fieldset>");
                        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + url + "',this.domNode); return false;\">" + paramsRequest.getLocaleString("Add_Instance") + "</button>"); //
                        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlback + "',this.domNode); return false;\">" + paramsRequest.getLocaleString("btnConfig") + "</button>"); //
                        out.println("</fieldset>");
                        out.println("</div>");
                    } else {
                        out.println("<div class=\"swbform\">");
                        out.println("<fieldset>");
                        out.println("<legend>" + paramsRequest.getLocaleString("errorMsgConfig") + " \"" + col.getDisplayTitle(user.getLanguage()) + "\" </legend>");
                        out.println("<ul style=\"list-style:none;\">");
                        out.println("<li>");
                        out.println(paramsRequest.getLocaleString("msgMissingConfigProperties"));
                        out.println("</li>");
                        out.println("</ul>");
                        out.println("</fieldset>");
                        SWBResourceURL urlreload = paramsRequest.getRenderUrl();
                        urlreload.setParameter("act", "config");
                        urlreload.setParameter("suri", id);
                        out.println("<fieldset>");
                        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlreload + "',this.domNode); return false;\">" + paramsRequest.getLocaleString("btnReload") + "</button>"); //
                        out.println("</fieldset>");
                        out.println("</div>");

                    }
                }
            }
        }
    }


    public String getFESelect(HashMap<String,SemanticObject> hmFE, String FEsel, User user)
    {
        StringBuilder ret = new StringBuilder();
        ret.append("<option value=\" \"></option>");
        Iterator<SemanticObject> itfe = hmFE.values().iterator();
        while (itfe.hasNext()) {
            SemanticObject sofe = itfe.next();
            ret.append("<option value=\"");
            ret.append(sofe.getURI());
            ret.append("\"");
            if(FEsel.equals(sofe.getURI())) ret.append(" selected ");
            ret.append(">");
            ret.append(sofe.getDisplayName(user.getLanguage()));
            ret.append("</option>");
        }
        return ret.toString();
    }


    public void doForm(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        String id = request.getParameter("suri");
        String cid = request.getParameter("clsuri");
        String act = request.getParameter("act");

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = ont.getSemanticObject(id);
        SemanticClass sclass = ont.getSemanticObject(cid).transformToSemanticClass();

        SWBResourceURL urlPA = paramRequest.getActionUrl();
        urlPA.setAction("new");

        SWBFormMgr fmgr = new SWBFormMgr(sclass, obj.getModel().getModelObject(), SWBFormMgr.MODE_CREATE);
        fmgr.setLang(user.getLanguage());
        fmgr.setAction(urlPA.toString());
        fmgr.setSubmitByAjax(true);
        fmgr.addButton(SWBFormButton.newSaveButton());
        SWBResourceURL urlback = paramRequest.getRenderUrl();
        urlback.setMode(SWBResourceURL.Mode_VIEW);
        urlback.setParameter("suri", id);
        if (null != cid) {
            urlback.setParameter("clsuri", cid);
        }
        if (null != act) {
            urlback.setParameter("act", act);
        }
        fmgr.addButton(SWBFormButton.newCancelButton().setAttribute("onclick", "submitUrl('" + urlback + "',this.domNode);return false;"));
        fmgr.setType(SWBFormMgr.TYPE_DOJO);

        log.debug("new: suri: " + id);
        log.debug("new: clsuri: " + cid);
        log.debug("new: act: " + act);

        fmgr.addHiddenParameter("suri", id);
        fmgr.addHiddenParameter("clsuri", cid);
        fmgr.addHiddenParameter("ract", act);
        fmgr.addHiddenParameter("act", "new");
        out.println(fmgr.renderForm(request));
    }

    public String reviewSemProp(SemanticProperty prop, SemanticObject obj, SWBParamRequest paramsRequest) {
        String ret = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy hh:mm:ss", new Locale(paramsRequest.getUser().getLanguage()));
            if (prop.isDataTypeProperty()) {
                if (prop.isBoolean()) {
                    boolean bvalue = obj.getBooleanProperty(prop);
                    if (bvalue) {
                        ret = paramsRequest.getLocaleString("booleanYes");
                    } else {
                        ret = paramsRequest.getLocaleString("booleanNo");
                    }

                }
                if (prop.isInt() || prop.isDouble() || prop.isLong()) {
                    ret = Long.toString(obj.getLongProperty(prop));
                }
                if (prop.isString()) {
                    ret = obj.getProperty(prop);
                }
                if (prop.isFloat()) {
                    ret = Float.toString(obj.getFloatProperty(prop));
                }
                if (prop.isDate() || prop.isDateTime()) {
                    ret = sdf.format(obj.getDateTimeProperty(prop));
                }
            } else if (prop.isObjectProperty()) {
                SemanticObject so = obj.getObjectProperty(prop);
                if (null != so) {
                    ret = so.getDisplayName(paramsRequest.getUser().getLanguage());
                }
            }
            if (null == ret || (ret != null && ret.trim().equals("null"))) {
                ret = "";
            }

        } catch (Exception e) {
        }
        if(ret==null||(ret!=null&&ret.trim().equals("null"))) ret="";
        return ret;
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {

        String id = request.getParameter("suri");
        String sval = request.getParameter("sval");
        String ract = request.getParameter("ract");
        String action = response.getAction();
        if (action == null) {
            action = "";
        }
        if (action.equals("")) {
            action = request.getParameter("act");
        }
        if (action == null) {
            action = "";
        }

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        GenericObject obj = ont.getGenericObject(id);

        if ("updconfig".equals(action)) {
            if (obj instanceof Collection) {
                Collection col = (Collection) obj;
                
                //quitar anteriores
//                col.removeAllListProperties();
//                col.removeAllSearchProperties();


                String actbutton = request.getParameter("actbutton");
                //System.out.println("actbutton: "+request.getParameter("actbutton"));
                //agregando propiedades de despliegue
                String semprop = request.getParameter("semprop");
                String sempropFE = request.getParameter("sempropFE");
                int semproporder = 0;
                int max=0;
                boolean existe=false;
                if(actbutton.equals("display") || actbutton.equals("both"))
                {
                    Iterator<String> itorder = col.listListPropertieses();
                    while (itorder.hasNext()) {
                        String string = itorder.next();
                        StringTokenizer stoken = new StringTokenizer(string,"|");
                        String temp = stoken.nextToken();
                        if(temp!=null&&temp.equals(semprop)) existe=true;
                        temp= stoken.nextToken();
                        try
                        {
                            semproporder = Integer.parseInt(stoken.nextToken());
                            if(semproporder>max) max = semproporder;

                        } catch(Exception e)
                        {
                            log.error("Error in display order element. SWBACollectionConfig.processAction()",e);
                        }
                    }
                    max++;

                    if(!existe&&semprop!=null&&sempropFE!=null)
                    {
                        col.addListProperties(semprop+"|"+sempropFE+"|"+max);
                    }
                }

                existe=false;
                //agregando propiedades de búsqueda
                if(actbutton.equals("search") || actbutton.equals("both"))
                {
                    semproporder=0;
                    max=0;
                    Iterator<String> itorder = col.listSearchPropertieses();
                    while (itorder.hasNext()) {
                        String string = itorder.next();
                        StringTokenizer stoken = new StringTokenizer(string,"|");
                        String temp = stoken.nextToken();
                        if(temp!=null&&temp.equals(semprop)) existe=true;
                        temp = stoken.nextToken();
                        try
                        {
                            semproporder = Integer.parseInt(stoken.nextToken());
                            if(semproporder>max) max = semproporder;

                        } catch(Exception e)
                        {
                            log.error("Error in search order element. SWBACollectionConfig.processAction()",e);
                        }
                    }
                    max++;

                    if(!existe&&semprop!=null&&sempropFE!=null)
                    {
                        col.addSearchProperties(semprop+"|"+sempropFE+"|"+max);
                    }
                }
            }

        } else if ("new".equals(action)) {


            log.debug("ProcessAction(new) ");

            id = request.getParameter("suri");
            String clsuri = request.getParameter("clsuri");

            SemanticObject so = ont.getSemanticObject(id);
            SemanticClass sclass = ont.getSemanticObject(clsuri).transformToSemanticClass();
            log.debug("ProcessAction(new): sobj: " + id);

            SWBFormMgr fmgr = new SWBFormMgr(sclass, so.getModel().getModelObject(), SWBFormMgr.MODE_CREATE);
            try {
                SemanticObject nso = fmgr.processForm(request);

                if (clsuri != null) {
                    response.setRenderParameter("clsuri", clsuri);
                }
                
                response.setRenderParameter("nsuri", nso.getURI());

            } catch (FormValidateException e) {
                throw new SWBResourceException("Error to process form...", e);
            }

            response.setRenderParameter("statmsg", response.getLocaleString("statmsg1"));
            response.setMode(response.Mode_EDIT);

        } else if ("remove".equals(action)) 
        {
            log.debug("processAction(remove)");
            //System.out.println("sval:"+sval);
            if (obj instanceof Collection) {
                Collection col = (Collection) obj;

                String prop = request.getParameter("prop");
                //System.out.println("Eliminando ... "+prop);

                if(prop!=null&&prop.equals("display"))
                {
                    //System.out.println("quitando display");
                    col.removeListProperties(sval);

                } else if(prop!=null&&prop.equals("search"))
                {
                    //System.out.println("quitando search");
                    col.removeSearchProperties(sval);
                }

            }

            log.debug("remove-closetab:" + sval);
            //response.setRenderParameter("closetab", sval);
            response.setRenderParameter("statmsg", response.getLocaleString("statmsg2"));
            response.setMode(SWBActionResponse.Mode_EDIT);
        }

        if (ract != null) {
            response.setRenderParameter("act", ract);
        }

        if (id != null) {

            response.setRenderParameter("suri", id);
        }

        log.debug("remove-closetab:" + sval);
        response.setMode(response.Mode_EDIT);
    }
}
