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
package org.semanticwb.portal.admin.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.*;
import org.semanticwb.model.*;
import org.semanticwb.platform.*;
import org.semanticwb.portal.PFlowManager;
import org.semanticwb.portal.SWBFormButton;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;

// TODO: Auto-generated Javadoc
/**
 * This resource add and show Contents related to a WebPage.
 *
 * @author juan.fernandez
 */
public class SWBAWebPageContents extends GenericResource {

    /** The log. */
    private Logger log = SWBUtils.getLogger(SWBAWebPageContents.class);
    /** The webpath. */
    String webpath = SWBPlatform.getContextPath();
    /** The distributor. */
    String distributor = SWBPlatform.getEnv("wb/distributor");
    /** The Mode_ action. */
    String Mode_Action = "paction";

    /**
     * Creates a new instance of SWBAWebPageContents.
     */
    public SWBAWebPageContents() {
    }
    /** The MOD e_ id request. */
    static String MODE_IdREQUEST = "FORMID";

    /**
     * User view of the resource, this call to a doEdit() mode.
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
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        log.debug("doView(SWBAWebPageContents...)");
        doEdit(request, response, paramRequest);
    }

    /**
     * User edit view of the resource, this show a list of contents related to a webpage, user can add, remove, activate, deactivate contents.
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
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        log.debug("doEdit()");


        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String id = request.getParameter("suri");
        String idp = request.getParameter("sprop");
        String page = request.getParameter("page");
        String idptype = request.getParameter("sproptype");

        if (request.getParameter("dialog") != null && request.getParameter("dialog").equals("close")) {
            out.println("<script type=\"javascript\">");
            out.println(" hideDialog(); ");
            out.println(" reloadTab('" + id + "'); ");
            out.println("</script>");
            return;
        }

        String action = request.getParameter("act");

        if (id == null) {
            id = paramRequest.getWebPage().getWebSite().getURI();
        }
        if (action == null) {
            action = "";
        }
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = ont.getSemanticObject(id);
        SemanticClass cls = obj.getSemanticClass();

        boolean canAdd = SWBPortal.getAdminFilterMgr().haveClassAction(user, Resourceable.swb_Resource, AdminFilter.ACTION_ADD);
        boolean canEdit = SWBPortal.getAdminFilterMgr().haveClassAction(user, Resourceable.swb_Resource, AdminFilter.ACTION_EDIT);
        boolean canRemove = SWBPortal.getAdminFilterMgr().haveClassAction(user, Resourceable.swb_Resource, AdminFilter.ACTION_DELETE);

        boolean isCollection = false;
        GenericObject go = obj.getGenericInstance();
        ResourceCollection rescol = null;
        ResourceCollectionCategory rescolcat = null;
        String resTypeURI = null;
        if (go instanceof ResourceCollection || go instanceof ResourceCollectionCategory) {
            isCollection = true;
            if (go instanceof ResourceCollection) {
                rescol = (ResourceCollection) go;
                resTypeURI = rescol.getResourceCollectionType().getSemanticObject().getURI();
            } else if (go instanceof ResourceCollectionCategory) {
                rescolcat = (ResourceCollectionCategory) go;
                resTypeURI = rescolcat.getResourceCollection().getResourceCollectionType().getSemanticObject().getURI();
            }
        }

        StringBuffer inheritHeader = new StringBuffer();

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

        if (action.equals("")) { //lista de instancias de tipo propiedad existentes para selecionar
            SemanticProperty prop = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(idp);
            //System.out.println("prop:"+prop+" idp:"+idp);
            SemanticClass clsprop = prop.getRangeClass();
            log.debug("class: " + clsprop.getClassName());
            HashMap<SemanticProperty, SemanticProperty> hmprop = new HashMap();
            Iterator<SemanticProperty> ite_sp = clsprop.listProperties();
            while (ite_sp.hasNext()) {
                SemanticProperty sp = ite_sp.next();
                log.debug("propiedad:" + sp.getDisplayName() + "---" + sp.getName());
                hmprop.put(sp, sp);
            }
            SemanticProperty sptemp = null;

            String busqueda = request.getParameter("search");
            if (null == busqueda) {
                busqueda = "";
            }

            int numcols = 0;
            out.println("<div class=\"swbform\">");
            out.println("<fieldset>");
            SWBResourceURL urls = paramRequest.getRenderUrl();
            urls.setParameter("act", "");
            urls.setParameter("suri", id);
            urls.setParameter("sprop", idp);

            out.println("<form id=\"" + id + "/fsearchwp\" name=\"" + id + "/fsearchwp\" method=\"post\" action=\"" + urls + "\" onsubmit=\"submitForm('" + id + "/fsearchwp');return false;\">");
            out.println("<div align=\"right\">");
            out.println("<input type=\"hidden\" name=\"suri\" value=\"" + id + "\">");
            out.println("<label for=\"" + id + "_searchwp\">" + paramRequest.getLocaleString("searchInProperties") + ": </label><input type=\"text\" name=\"search\" id=\"" + id + "_searchwp\" value=\"" + busqueda + "\">");
            out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\">" + paramRequest.getLocaleString("btnSearch") + "</button>"); //
            out.println("</div>");
            out.println("</form>");
            out.println("</fieldset>");
            out.println("<fieldset>");
            out.println("<table width=\"98%\" >");
            out.println("<thead>");
            inheritHeader.append("<fieldset>");
            inheritHeader.append("<legend>");
            inheritHeader.append(paramRequest.getLocaleString("legend_Inherited"));
            inheritHeader.append("</legend>");
            inheritHeader.append("<table width=\"98%\">");
            inheritHeader.append("<thead>");
            inheritHeader.append("<tr>");
            //inheritHeader.append("<tr>");
            out.println("<tr>");
            out.println("<th>");
            out.println(paramRequest.getLocaleString("th_action"));
            out.println("</th>");
            inheritHeader.append("<th>");
            out.println("<th>");
            numcols++;
            //System.out.println("clsprop:"+clsprop+" user:"+user);
            out.println(clsprop.getDisplayName(user.getLanguage()));
            inheritHeader.append(clsprop.getDisplayName(user.getLanguage()));
            out.println("</th>");
            inheritHeader.append("</th>");
            String propname = "";
            sptemp = hmprop.get(Resource.swb_resourceType);
            if (sptemp != null) {
                propname = sptemp.getName();
                try {
                    propname = sptemp.getDisplayName(user.getLanguage());
                } catch (Exception e) {
                    propname = "";
                }
                out.println("<th>");
                inheritHeader.append("<th>");
                numcols++;
                out.println(propname);
                inheritHeader.append(propname);
                out.println("</th>");
                inheritHeader.append("</th>");
            }
            sptemp = hmprop.get(Traceable.swb_created);
            if (sptemp != null) {
                propname = sptemp.getName();
                try {
                    propname = sptemp.getDisplayName(user.getLanguage());
                } catch (Exception e) {
                    propname = "";
                }
                out.println("<th>");
                inheritHeader.append("<th>");
                numcols++;
                out.println(propname);
                inheritHeader.append(propname);
                out.println("</th>");
                inheritHeader.append("</th>");
            }
            sptemp = hmprop.get(Traceable.swb_updated);
            if (sptemp != null) {
                propname = sptemp.getName();
                try {
                    propname = sptemp.getDisplayName(user.getLanguage());
                } catch (Exception e) {
                    propname = "";
                }
                out.println("<th>");
                inheritHeader.append("<th>");
                numcols++;
                out.println(propname);
                inheritHeader.append(propname);
                out.println("</th>");
                inheritHeader.append("</th>");
            }
            sptemp = hmprop.get(Sortable.swb_index);
            if (hmprop.get(Sortable.swb_index) != null) {
                propname = sptemp.getName();
                try {
                    propname = sptemp.getDisplayName(user.getLanguage());
                } catch (Exception e) {
                    propname = "";
                }
                out.println("<th>");
                inheritHeader.append("<th>");
                numcols++;
                out.println(propname);
                inheritHeader.append(propname);
                out.println("</th>");
                inheritHeader.append("</th>");
            }
            boolean hasActive = false;
            sptemp = hmprop.get(Activeable.swb_active);
            if (sptemp != null) {
                hasActive = true;
                propname = sptemp.getName();
                try {
                    propname = sptemp.getDisplayName(user.getLanguage());
                } catch (Exception e) {
                    propname = "";
                }
                out.println("<th>");
                out.println(propname);
                out.println("</th>");
            }
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody >");
            //out.println("<div dojoType=\"dojo.dnd.Source\" class=\"container\" copyOnly=\"true\">");


            PFlowManager pfmgr = SWBPortal.getPFlowManager();
            Resource res = null;
            boolean isInherit = true;
            boolean isInFlow = false;
            boolean isAuthorized = false;
            boolean needAuthorization = false;
            boolean activeButton = false;
            boolean send2Flow = false;
            boolean hasAsoc = false;
            SemanticProperty semprop = null;
            SemanticProperty sem_p = ont.getSemanticProperty(idp);
            SemanticObject so = obj.getObjectProperty(sem_p);


            busqueda = busqueda.trim();
            HashMap<String, SemanticObject> hmbus = new HashMap();
            HashMap<String, SemanticObject> hmfiltro = new HashMap();
            SemanticObject semO = null;
            Iterator<SemanticProperty> itcol = null;
            Iterator<SemanticObject> itso = obj.listObjectProperties(prop);

            //System.out.println("busqueda:"+busqueda);

            if (!busqueda.equals("")) {
                while (itso.hasNext()) {
                    semO = itso.next();
                    boolean del = false;
                    if (semO.instanceOf(Trashable.swb_Trashable)) {
                        del = semO.getBooleanProperty(Trashable.swb_deleted, false);
                    }
                    if (del) {
                        continue;
                    }

                    hmbus.put(semO.getURI(), semO);
                    itcol = hmprop.keySet().iterator();
                    String occ = "";
                    while (itcol.hasNext()) {
                        SemanticProperty sprop = itcol.next();
                        occ = occ + reviewSemProp(sprop, semO, paramRequest);
                    }
                    //System.out.println("occ:"+occ);
                    occ = occ.toLowerCase();
                    if (occ.indexOf(busqueda.toLowerCase()) > -1) {
                        hmfiltro.put(semO.getURI(), semO);
                    }
                }
            } else {
                while (itso.hasNext()) {
                    semO = itso.next();
                    boolean del = false;
                    if (semO.instanceOf(Trashable.swb_Trashable)) {
                        del = semO.getBooleanProperty(Trashable.swb_deleted, false);
                    }
                    if (del) {
                        continue;
                    }

                    hmbus.put(semO.getURI(), semO);
                }
            }

            if (busqueda.trim().length() == 0) {  //hmfiltro.isEmpty()&&
                itso = hmbus.values().iterator(); //obj.listObjectProperties(prop);
            } else {
                itso = hmfiltro.values().iterator();
            }

            Set<SemanticObject> setso = SWBComparator.sortByCreatedSet(itso, false);
            itso = null;
            int ps = 20;
            int l = setso.size();

            //System.out.println("num cont: "+l);

            int p = 0;
            if (page != null) {
                p = Integer.parseInt(page);
            }



            int x = 0;
            itso = setso.iterator();
            while (itso.hasNext()) {

                SemanticObject sobj = itso.next();

                boolean del = false;
                if (sobj.instanceOf(Trashable.swb_Trashable)) {
                    del = sobj.getBooleanProperty(Trashable.swb_deleted, false);
                }
                if (del) {
                    continue;
                }

                if (x < p * ps) {
                    x++;
                    continue;
                }
                if (x == (p * ps + ps) || x == l) {
                    break;
                }
                x++;

                hasAsoc = true;
                SemanticClass clsobj = sobj.getSemanticClass();
                log.debug("Clase:" + clsobj.getName());

                // revisando contenido en flujo de publicación
                // validacion de botones en relación a los flujos

                isInFlow = false;
                isAuthorized = false;
                needAuthorization = false;
                activeButton = true;
                send2Flow = false;

                res = (Resource) sobj.createGenericInstance();

                isInFlow = pfmgr.isInFlow(res);

                //System.out.println("Recurso esta en flujo: "+isInFlow);

                needAuthorization = pfmgr.needAnAuthorization(res);

                //System.out.println("Necesita autorización: "+needAuthorization);

                if (!isInFlow && !needAuthorization) {
                    activeButton = true;
                }
                if (!isInFlow && needAuthorization) {
                    activeButton = false;
                    send2Flow = true;
                }

                if (isInFlow) {
                    isAuthorized = pfmgr.isAuthorized(res);
                    if (!isAuthorized) {
                        activeButton = false;
                    }
                    if (isAuthorized) {
                        activeButton = true;
                    }
                }

                // fin validación de botones en relacion a flujos

                String stitle = SWBUtils.TEXT.cropText(getDisplaySemObj(sobj, user.getLanguage()), 50);
                out.println("<tr>");

                out.println("<td>");
                SWBResourceURL urlr = paramRequest.getActionUrl();
                urlr.setParameter("suri", id);
                urlr.setParameter("sprop", idp);
                urlr.setParameter("sval", sobj.getURI());
                urlr.setParameter("page", "" + p);
                urlr.setParameter("search", (busqueda.trim().length() > 0 ? busqueda : ""));
                urlr.setParameter(prop.getName(), prop.getURI());
                urlr.setAction("remove");




                if (canRemove) {
                    out.println("<a href=\"#\" title=\"" + paramRequest.getLocaleString("remove") + "\" onclick=\"if(confirm('" + paramRequest.getLocaleString("confirm_remove") + " " + SWBUtils.TEXT.scape4Script(sobj.getDisplayName(user.getLanguage())) + "?')){ submitUrl('" + urlr + "',this); } else { return false;}\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("remove") + "\"></a>");
                } else {
                    out.println("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/delete.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("remove") + "\">");
                }


                SWBResourceURL urlpre = paramRequest.getRenderUrl();
                urlpre.setParameter("suri", id);
                urlpre.setParameter("sprop", idp);
                urlpre.setParameter("act", "");
                urlpre.setParameter("page", "" + p);
                urlpre.setParameter("search", (busqueda.trim().length() > 0 ? busqueda : ""));
                urlpre.setParameter("sval", sobj.getURI());
                if (idptype != null) {
                    urlpre.setParameter("sproptype", idptype);
                }
                urlpre.setParameter("preview", "true");
                out.println("<a href=\"#\" title=\"" + paramRequest.getLocaleString("previewdocument") + "\" onclick=\"submitUrl('" + urlpre + "',this); return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/preview.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("previewdocument") + "\"></a>");
                if (canEdit) {
                    out.println("<a href=\"#\"  title=\"" + paramRequest.getLocaleString("documentAdmin") + "\" onclick=\"selectTab('" + sobj.getURI() + "','" + SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + SWBUtils.TEXT.scape4Script(sobj.getDisplayName()) + "','bh_AdminPorltet');return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/editar_1.gif\" border=\"0\" alt=\"" + "documentAdmin" + "\"></a>");
                } else {
                    out.println("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/icons/editar_1.gif\" border=\"0\" alt=\"" + "documentAdmin" + "\">");
                }

                if (send2Flow) {
                    boolean canSend2Flow = Boolean.TRUE;
                    String pfid = null;
                    PFlow[] arrPf = pfmgr.getFlowsToSendContent(res);
                    if (arrPf.length == 1) {
                        pfid = arrPf[0].getId();
                    }

                    GenericObject gores = sobj.createGenericInstance();
                    if (gores != null && gores instanceof Versionable) {
                        Versionable vgo = (Versionable) gores;
                        if (vgo.getActualVersion() == null || vgo.getLastVersion() == null) {
                            canSend2Flow = Boolean.FALSE;
                        }
                    }

                    if (canSend2Flow) {
                        SWBResourceURL url2flow = paramRequest.getRenderUrl();
                        url2flow.setParameter("suri", id);
                        url2flow.setParameter("sprop", idp);
                        url2flow.setMode("doPflowMsg");
                        url2flow.setParameter("sval", sobj.getURI());
                        url2flow.setParameter("page", "" + p);
                        url2flow.setParameter("pfid", pfid);
                        url2flow.setParameter("search", (busqueda.trim().length() > 0 ? busqueda : ""));
                        if (idptype != null) {
                            url2flow.setParameter("sproptype", idptype);
                        }
                        out.println("<a href=\"#\" title=\"" + paramRequest.getLocaleString("senddocument2flow") + "\" onclick=\"showDialog('" + url2flow + "','" + paramRequest.getLocaleString("comentary") + "'); return false;\"><img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/enviar-flujo.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("senddocument2flow") + "\"></a>");
                    } else {
                        out.println("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/enviar-flujo.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("senddocument2flow") + "\" title=\"" + paramRequest.getLocaleString("canNOTsenddocument2flow") + "\">");
                    }
                } else if (isInFlow && !isAuthorized) {
                    out.println("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/espera_autorizacion.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("documentwaiting") + "\">");
                } else if (isInFlow && isAuthorized) {
                    out.println("<img src=\"" + SWBPlatform.getContextPath() + "/swbadmin/images/enlinea.gif\" border=\"0\" alt=\"" + paramRequest.getLocaleString("Caccepted") + "\">");
                }
                out.println("</td>");
                out.println("<td>");
                SWBResourceURL urlchoose = paramRequest.getRenderUrl();
                urlchoose.setParameter("suri", id);
                urlchoose.setParameter("sprop", idp);
                urlchoose.setParameter("sobj", sobj.getURI());
                urlchoose.setParameter("act", "edit");
                //out.println("<div class=\"dojoDndItem\"><a href=\"#\"  onclick=\"addNewTab('" + sobj.getURI() + "','" + SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + SWBUtils.TEXT.cropText(SWBUtils.TEXT.scape4Script(sobj.getDisplayName()), 25) + "');return false;\">" + stitle + "</a></div>");
                if (canEdit) {
                    out.println("<a href=\"#\"  onclick=\"addNewTab('" + sobj.getURI() + "','" + SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + SWBUtils.TEXT.cropText(SWBUtils.TEXT.scape4Script(sobj.getDisplayName()), 25) + "');return false;\" title=\"" + getDisplaySemObj(sobj, user.getLanguage()) + "\">" + stitle + "</a>");
                } else {
                    out.println(stitle);
                }

                out.println("</td>");
                if (hmprop.get(Resource.swb_resourceType) != null) {
                    semprop = (SemanticProperty) hmprop.get(Resource.swb_resourceType);
                    //System.out.println(semprop);
                    //System.out.println(hmprop);
                    //System.out.println(sobj);
                    //System.out.println("getObjectProperty:"+sobj+" "+sobj.getObjectProperty(semprop));
                    out.println("<td>");
                    out.println(sobj.getObjectProperty(semprop).getDisplayName(user.getLanguage()));
                    out.println("</td>");
                }
                if (hmprop.get(Traceable.swb_created) != null) {
                    semprop = (SemanticProperty) hmprop.get(Traceable.swb_created);
                    out.println("<td>");
                    out.println(getValueSemProp(sobj, semprop));
                    out.println("</td>");
                }
                if (hmprop.get(Traceable.swb_updated) != null) {
                    semprop = (SemanticProperty) hmprop.get(Traceable.swb_updated);
                    out.println("<td>");
                    out.println(getValueSemProp(sobj, semprop));
                    out.println("</td>");
                }
                if (hmprop.get(Sortable.swb_index) != null) {
                    semprop = (SemanticProperty) hmprop.get(Sortable.swb_index);
                    out.println("<td align=\"center\">");
                    SWBResourceURL urlu = paramRequest.getRenderUrl();
                    urlu.setMode(Mode_Action);
                    urlu.setParameter("suri", id);
                    urlu.setParameter("sprop", idp);
                    urlu.setParameter("sval", sobj.getURI());
                    urlu.setParameter("act", "update");
                    urlu.setParameter("search", (busqueda.trim().length() > 0 ? busqueda : ""));
                    if (canEdit) {
                        out.println("<div dojoType=\"dijit.form.NumberSpinner\" id=\"" + id + "/" + base.getId() + "/" + sobj.getId() + "/NS\" jsId=\"" + id + "/" + base.getId() + "/" + sobj.getId() + "/NS\" intermediateChanges=\"true\" smallDelta=\"1\" constraints=\"{min:0,max:999,places:0}\" style=\"width:50px\"  name=\"" + semprop.getName() + "\" maxlength=\"3\"  value=\"" + getValueSemProp(sobj, semprop) + "\" >");
                        out.println("<script type=\"dojo/connect\" event=\"onBlur\">");
                        out.println(" var self=this;   ");
                        out.println(" showStatusURL('" + urlu + "&'+self.attr(\"name\")+'='+self.attr(\"value\"),true);");
                        out.println("</script>");
                        out.println("</div>");
                    } else {
                        out.println("<div dojoType=\"dijit.form.NumberSpinner\" id=\"" + id + "/" + base.getId() + "/" + sobj.getId() + "/NS\" jsId=\"" + id + "/" + base.getId() + "/" + sobj.getId() + "/NS\" intermediateChanges=\"true\" smallDelta=\"1\" constraints=\"{min:0,max:999,places:0}\" style=\"width:50px\"  name=\"" + semprop.getName() + "\" maxlength=\"3\"  value=\"" + getValueSemProp(sobj, semprop) + "\" disabled=\"true\" >");
                        out.println("</div>");
                    }
                    out.println("</td>");
                }
                if (hmprop.get(Activeable.swb_active) != null) {
                    out.println("<td align=\"center\">");
                    boolean activo = false;
                    if (sobj.getBooleanProperty(Activeable.swb_active)) {
                        activo = true;
                        isInherit = false;
                    }
                    if (activeButton) {
                        SWBResourceURL urlu = paramRequest.getRenderUrl();
                        urlu.setMode(Mode_Action);
                        urlu.setParameter("suri", id);
                        urlu.setParameter("sprop", idp);
                        urlu.setParameter("sval", sobj.getURI());
                        urlu.setParameter("act", "updstatus");
                        if (canEdit) {
                            out.println("<input name=\"" + prop.getName() + sobj.getURI() + "\" type=\"checkbox\" value=\"1\" id=\"" + prop.getName() + sobj.getURI() + "\" onclick=\"showStatusURL('" + urlu + "&val='+this.checked,true);\"  " + (activo ? "checked='checked'" : "") + " />");
                        } else {
                            out.println("<input name=\"" + prop.getName() + sobj.getURI() + "\" type=\"checkbox\" value=\"1\" id=\"" + prop.getName() + sobj.getURI() + "\" " + (activo ? "checked='checked'" : "") + " disabled=\"true\" />");
                        }
                    } else {
                        out.println("<input name=\"" + prop.getName() + sobj.getURI() + "\" type=\"checkbox\" value=\"1\" id=\"" + prop.getName() + sobj.getURI() + "\" " + (activo ? "checked='checked'" : "") + " disabled=\"true\">");
                    }
                    out.println("</td>");
                }
                out.println("</tr>");
            }
//            out.println("</div>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("</fieldset>");

            if (p > 0 || x < l) //Requiere paginacion
            {
                out.println("<fieldset>");
                out.println("<center>");

                //int pages=(int)(l+ps/2)/ps;

                int pages = (int) (l / ps);
                if ((l % ps) > 0) {
                    pages++;
                }

                for (int z = 0; z < pages; z++) {
                    SWBResourceURL urlNew = paramRequest.getRenderUrl();
                    urlNew.setParameter("suri", id);
                    urlNew.setParameter("sprop", idp);
                    urlNew.setParameter("sproptype", idptype);
                    urlNew.setParameter("page", "" + z);
                    if (z != p) {
                        out.println("<a href=\"#\" onclick=\"submitUrl('" + urlNew + "',this); return false;\">" + (z + 1) + "</a> ");
                    } else {
                        out.println((z + 1) + " ");
                    }
                }
                out.println("</center>");
                out.println("</fieldset>");
            }
            out.println("<fieldset>");
            SWBResourceURL urlNew = paramRequest.getRenderUrl();
            urlNew.setParameter("suri", id);
            urlNew.setParameter("sprop", idp);
            urlNew.setParameter("sproptype", idptype);
            if (isCollection) {
                urlNew.setParameter("act", "edit");

                urlNew.setParameter("sobj", resTypeURI);
            } else {
                urlNew.setParameter("act", "choose");
            }

            if (canAdd) {
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlNew + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btn_addnew") + "</button>");
            }
            if (hasAsoc) {
                if (hasActive) {
                    SWBResourceURL urlAAll = paramRequest.getRenderUrl();
                    urlAAll.setParameter("suri", id);
                    urlAAll.setParameter("sprop", idp);
                    if (null != idptype) {
                        urlAAll.setParameter("sproptype", idptype);
                    }
                    urlAAll.setParameter("sval", "true");
                    urlAAll.setParameter("act", "activeall");
                    urlAAll.setMode(Mode_Action);
                    if (canEdit) {
                        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlAAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btn_aallnew") + "</button>");
                    }
                    SWBResourceURL urlUAll = paramRequest.getRenderUrl();
                    urlUAll.setParameter("suri", id);
                    urlUAll.setParameter("sprop", idp);
                    if (null != idptype) {
                        urlUAll.setParameter("sproptype", idptype);
                    }
                    urlUAll.setParameter("sval", "false");
                    urlUAll.setParameter("act", "activeall");
                    urlUAll.setMode(Mode_Action);
                    if (canEdit) {
                        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlUAll + "',this.domNode); return false;\">" + paramRequest.getLocaleString("btn_uallnew") + "</button>");
                    }
                }
                SWBResourceURL urlDAll = paramRequest.getActionUrl();
                urlDAll.setParameter("suri", id);
                urlDAll.setParameter("sprop", idp);
                if (null != idptype) {
                    urlDAll.setParameter("sproptype", idptype);
                }
                urlDAll.setParameter("sval", "remove");
                urlDAll.setAction("deleteall");
                if (canRemove) {
                    out.println("<button dojoType=\"dijit.form.Button\" onclick=\"if(confirm('" + paramRequest.getLocaleString("qshure2delete") + "?')){submitUrl('" + urlDAll + "',this.domNode);} return false;\">" + paramRequest.getLocaleString("btn_dallnew") + "</button>");
                }
            }
            out.println("</fieldset>");

            // Para mostrar heredados

            log.debug("PRO: " + sem_p.getName() + " es inheritable " + sem_p.isInheritProperty());

            if (isInherit && sem_p.isInheritProperty()) {
                itso = null;
                itso = obj.listInheritProperties(sem_p);
                if (itso.hasNext()) {
                    out.println(inheritHeader.toString());
                    while (itso.hasNext()) {
                        SemanticObject sobj = itso.next();
                        SemanticClass clsobj = sobj.getSemanticClass();
                        log.debug("Clase:" + clsobj.getName());

                        String stitle = getDisplaySemObj(sobj, user.getLanguage());
                        out.println("<tr>");
                        out.println("<td>");
                        SWBResourceURL urlchoose = paramRequest.getRenderUrl();
                        urlchoose.setParameter("suri", id);
                        urlchoose.setParameter("sprop", idp);
                        urlchoose.setParameter("sobj", sobj.getURI());
                        urlchoose.setParameter("act", "edit");
                        if (canEdit) {
                            out.println("<a href=\"#\"  onclick=\"addNewTab('" + sobj.getURI() + "','" + SWBPlatform.getContextPath() + "/swbadmin/jsp/objectTab.jsp" + "','" + SWBUtils.TEXT.scape4Script(sobj.getDisplayName()) + "');return false;\">" + stitle + "</a>");
                        } else {
                            out.println(stitle);
                        }
                        out.println("</td>");
                        if (hmprop.get(Traceable.swb_created) != null) {
                            semprop = (SemanticProperty) hmprop.get(Traceable.swb_created);
                            out.println("<td>");
                            out.println(getValueSemProp(sobj, semprop));
                            out.println("</td>");
                        }
                        if (hmprop.get(Traceable.swb_updated) != null) {
                            semprop = (SemanticProperty) hmprop.get(Traceable.swb_updated);
                            out.println("<td>");
                            out.println(getValueSemProp(sobj, semprop));
                            out.println("</td>");
                        }
                        if (hmprop.get(Sortable.swb_index) != null) {
                            semprop = (SemanticProperty) hmprop.get(Sortable.swb_index);
                            out.println("<td align=\"center\">");
                            out.println(getValueSemProp(sobj, semprop));
                            out.println("</td>");
                        }
                        out.println("</tr>");
                    }
                    out.println("</table>");
                    out.println("</fieldset>");
                }
            }


            out.println("</div>");

        } else if (action.equals("choose")) { //lista de instancias de tipo propiedad existentes para selecionar
            SemanticProperty prop = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(idp);
            idptype = Resource.swb_resourceType.getURI();
            if (idptype != null) {
                prop = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(idptype);
            }
            SemanticClass clsprop = prop.getRangeClass();
            HashMap hmSO = new HashMap();



            Iterator<SemanticObject> ite_so = obj.listObjectProperties(prop);
            while (ite_so.hasNext()) {
                SemanticObject so = ite_so.next();
                if (null != so) {
                    hmSO.put(so.getURI(), so);
                }
            }

            out.println("<div class=\"swbform\">");
            SWBResourceURL urlAdd = paramRequest.getRenderUrl();
            urlAdd.setMode(SWBResourceURL.Mode_EDIT);
            urlAdd.setParameter("act", "edit");
            out.println("<form id=\"" + id + "/WPContent\" action=\"" + urlAdd + "\" method=\"post\" onsubmit=\"submitForm('" + id + "/WPContent'); return false;\">");
            out.println("<input type=\"hidden\" id=\"" + id + "/suri\" name=\"suri\" value=\"" + id + "\">");
            out.println("<input type=\"hidden\" id=\"" + id + "/sprop\" name=\"sprop\" value=\"" + idp + "\">");
            out.println("<input type=\"hidden\" id=\"" + id + "/sproptype\" name=\"sproptype\" value=\"" + idptype + "\">");

            // Lista de Tipo de portlet disponibles de Global, separados por contenido y sistema

//            Iterator<SemanticObject> itgso = SWBComparator.sortSermanticObjects(SWBContext.getGlobalWebSite().getSemanticObject().getModel().listInstancesOfClass(clsprop),user.getLanguage());
            Iterator<SemanticObject> itgso = SWBContext.getGlobalWebSite().getSemanticObject().getModel().listInstancesOfClass(clsprop);
            HashMap<String, SemanticObject> hmContent = new HashMap();
            HashMap<String, SemanticObject> hmSystem = new HashMap();
            while (itgso.hasNext()) {
                SemanticObject sobj = itgso.next();
                int mode = sobj.getIntProperty(ResourceType.swb_resourceMode);
                if (mode == 1)//tipo contenido
                {
                    hmContent.put(sobj.getId(), sobj);
                } else if (mode == 3)//tipo sistema
                {
                    hmSystem.put(sobj.getId(), sobj);
                }
            }
            if (hmContent.size() > 0 || hmSystem.size() > 0) {
                out.println("<fieldset>");
                out.println("	<legend>Global</legend>");
            }

            //itgso = hmContent.values().iterator();
            itgso = SWBComparator.sortSermanticObjects(user.getLanguage(), hmContent.values().iterator());
            if (hmContent.size() > 0) {
                out.println("<table width=\"98%\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan=\"3\">");
                out.println(paramRequest.getLocaleString("content_type"));
                out.println("</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th width=\"40\" align=\"center\">");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                out.println("</th>");
                out.println("<th width=\"30%\">");
                out.println(paramRequest.getLocaleString("content_name"));
                out.println("</th>");
                out.println("<th  width=\"60%\">");
                out.println(paramRequest.getLocaleString("content_description"));
                out.println("</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody> ");

                while (itgso.hasNext()) {
                    SemanticObject sobj = itgso.next();
                    String stitle = getDisplaySemObj(sobj, user.getLanguage());
                    String sdescription = sobj.getProperty(Descriptiveable.swb_description);
                    out.println("<tr>");
                    out.println("<td align=\"center\">");
                    out.println("<input type=\"radio\" dojoType=\"dijit.form.RadioButton\" name=\"sobj\" id=\"" + sobj.getURI() + "/sptype\" value=\"global|" + sobj.getURI() + "\" >");
                    out.println("</td>");
                    out.println("<td>");

                    SWBResourceURL urladdglobal = paramRequest.getRenderUrl();
                    urladdglobal.setMode(SWBResourceURL.Mode_EDIT);
                    urladdglobal.setParameter("act", "edit");
                    urladdglobal.setParameter("suri", id);
                    urladdglobal.setParameter("sprop", idp);
                    urladdglobal.setParameter("sproptype", idptype);
                    urladdglobal.setParameter("sobj", "global|" + sobj.getURI());

                    if (canEdit) {
                        out.println("<a href=\"#\" onclick=\"submitUrl('" + urladdglobal + "',this); return false;\">");
                        out.println(stitle);
                        out.println("</a");
                    } else {
                        out.println(stitle);
                    }
                    out.println("</td>");
                    out.println("<td>");
                    out.println(sdescription != null ? sdescription : "");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</tbody> ");
                out.println("</table> ");
            }
            //itgso = hmSystem.values().iterator();
            itgso = SWBComparator.sortSermanticObjects(user.getLanguage(), hmSystem.values().iterator());
            if (hmSystem.size() > 0) {
                out.println("<table width=\"98%\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan=\"3\">");
                out.println(paramRequest.getLocaleString("content_system"));
                out.println("</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th width=\"40\" align=\"center\">");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                out.println("</th>");
                out.println("<th width=\"30%\">");
                out.println(paramRequest.getLocaleString("content_name"));
                out.println("</th>");
                out.println("<th  width=\"60%\">");
                out.println(paramRequest.getLocaleString("content_description"));
                out.println("</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody> ");

                while (itgso.hasNext()) {
                    SemanticObject sobj = itgso.next();
                    String stitle = getDisplaySemObj(sobj, user.getLanguage());
                    String sdescription = sobj.getProperty(Descriptiveable.swb_description);
                    out.println("<tr>");
                    out.println("<td align=\"center\">");
                    out.println("<input type=\"radio\" dojoType=\"dijit.form.RadioButton\" name=\"sobj\" id=\"" + sobj.getURI() + "/sptype\" value=\"global|" + sobj.getURI() + "\" >");
                    out.println("</td>");
                    out.println("<td>");

                    SWBResourceURL urladdglobal = paramRequest.getRenderUrl();
                    urladdglobal.setMode(SWBResourceURL.Mode_EDIT);
                    urladdglobal.setParameter("act", "edit");
                    urladdglobal.setParameter("suri", id);
                    urladdglobal.setParameter("sprop", idp);
                    urladdglobal.setParameter("sproptype", idptype);
                    urladdglobal.setParameter("sobj", "global|" + sobj.getURI());

                    if (canEdit) {
                        out.println("<a href=\"#\" onclick=\"submitUrl('" + urladdglobal + "',this); return false;\">");
                        out.println(stitle);
                        out.println("</a");
                    } else {
                        out.println(stitle);
                    }

                    out.println("</td>");
                    out.println("<td>");
                    out.println(sdescription != null ? sdescription : "");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</tbody> ");
                out.println("</table> ");
            }
            if (hmContent.size() > 0 || hmSystem.size() > 0) {
                out.println("</fieldset>");
            }

            // Lista de tipo de portlets disponibles del sitio, separados por contenido y sistema

            out.println("<fieldset>");
            out.println("	<legend>" + obj.getModel().getModelObject().getDisplayName() + "</legend>");

            hmContent = new HashMap();
            hmSystem = new HashMap();

            Iterator<SemanticObject> itso = obj.getModel().listInstancesOfClass(clsprop);
            while (itso.hasNext()) {
                SemanticObject sobj = itso.next();
                log.debug("before:");
                int mode = 0;
                try {
                    mode = sobj.getIntProperty(ResourceType.swb_resourceMode);
                } catch (Exception e) {
                    mode = 0;
                }
                log.debug("after: mode:" + mode);
                if (mode == 1)//tipo contenido
                {
                    hmContent.put(sobj.getId(), sobj);
                } else if (mode == 3)//tipo sistema
                {
                    hmSystem.put(sobj.getId(), sobj);
                }
            }

            //itso = hmContent.values().iterator();
            itso = SWBComparator.sortSermanticObjects(user.getLanguage(), hmContent.values().iterator());
            if (hmContent.size() > 0) {
                out.println("<table width=\"98%\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan=\"3\">");
                out.println(paramRequest.getLocaleString("content_type"));
                out.println("</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th width=\"40\" align=\"center\">");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                out.println("</th>");
                out.println("<th width=\"30%\">");
                out.println(paramRequest.getLocaleString("content_name"));
                out.println("</th>");
                out.println("<th  width=\"60%\">");
                out.println(paramRequest.getLocaleString("content_description"));
                out.println("</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody> ");

                while (itso.hasNext()) {
                    SemanticObject sobj = itso.next();
                    String stitle = getDisplaySemObj(sobj, user.getLanguage());
                    String sdescription = sobj.getProperty(Descriptiveable.swb_description);
                    out.println("<tr>");
                    out.println("<td align=\"center\">");
                    out.println("<input type=\"radio\" dojoType=\"dijit.form.RadioButton\" name=\"sobj\" id=\"" + sobj.getURI() + "/sptype\" value=\"" + sobj.getURI() + "\" >");
                    out.println("</td>");
                    out.println("<td>");

                    SWBResourceURL urladds = paramRequest.getRenderUrl();
                    urladds.setMode(SWBResourceURL.Mode_EDIT);
                    urladds.setParameter("act", "edit");
                    urladds.setParameter("suri", id);
                    urladds.setParameter("sprop", idp);
                    urladds.setParameter("sproptype", idptype);
                    urladds.setParameter("sobj", sobj.getURI());

                    out.println("<a href=\"#\" onclick=\"submitUrl('" + urladds + "',this); return false;\">");
                    out.println(stitle);
                    out.println("</a");

                    out.println("</td>");
                    out.println("<td>");
                    out.println(sdescription != null ? sdescription : "");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</tbody> ");
                out.println("</table> ");
            }
            //itso = hmSystem.values().iterator();


            itso = SWBComparator.sortSermanticObjects(user.getLanguage(), hmSystem.values().iterator());
            if (hmSystem.size() > 0) {
                out.println("<table width=\"98%\">");
                out.println("<thead>");
                out.println("<tr>");
                out.println("<th colspan=\"3\">");
                out.println(paramRequest.getLocaleString("content_system"));
                out.println("</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th width=\"40\" align=\"center\">");
                out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                out.println("</th>");
                out.println("<th width=\"30%\">");
                out.println(paramRequest.getLocaleString("content_name"));
                out.println("</th>");
                out.println("<th  width=\"60%\">");
                out.println(paramRequest.getLocaleString("content_description"));
                out.println("</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tbody> ");

                while (itso.hasNext()) {
                    SemanticObject sobj = itso.next();
                    String stitle = getDisplaySemObj(sobj, user.getLanguage());
                    String sdescription = sobj.getProperty(Descriptiveable.swb_description);
                    out.println("<tr>");
                    out.println("<td align=\"center\">");
                    out.println("<input type=\"radio\" dojoType=\"dijit.form.RadioButton\" name=\"sobj\" id=\"" + sobj.getURI() + "/sptype\" value=\"" + sobj.getURI() + "\" >");
                    out.println("</td>");
                    out.println("<td>");

                    SWBResourceURL urladds = paramRequest.getRenderUrl();
                    urladds.setMode(SWBResourceURL.Mode_EDIT);
                    urladds.setParameter("act", "edit");
                    urladds.setParameter("suri", id);
                    urladds.setParameter("sprop", idp);
                    urladds.setParameter("sproptype", idptype);
                    urladds.setParameter("sobj", sobj.getURI());

                    if (canEdit) {
                        out.println("<a href=\"#\" onclick=\"submitUrl('" + urladds + "',this); return false;\">");
                        out.println(stitle);
                        out.println("</a");
                    } else {
                        out.println(stitle);
                    }

                    out.println("</td>");
                    out.println("<td>");
                    out.println(sdescription != null ? sdescription : "");
                    out.println("</td>");
                    out.println("</tr>");
                }
                out.println("</tbody> ");
                out.println("</table> ");
            }
            out.println("</fieldset>");
            out.println("<fieldset>");
            SWBResourceURL urlBack = paramRequest.getRenderUrl();
            if (id != null) {
                urlBack.setParameter("suri", id);
            }
            if (idp != null) {
                urlBack.setParameter("sprop", idp);
            }
            if (idptype != null) {
                urlBack.setParameter("sproptype", idptype);
            }
            urlBack.setParameter("act", "");
            out.println("<table width=\"98%\">");
            out.println("<tbody>");
            out.println("<tr>");
            out.println("<td>");
            if (canEdit) {
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitForm('" + id + "/WPContent'); return false;\">" + paramRequest.getLocaleString("btn_send") + "</button>");
            }
            if (id != null && idp != null && idptype != null) {
                out.println("<button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('" + urlBack + "',document.getElementById('" + id + "/WPContent')); return false;\">" + paramRequest.getLocaleString("btn_back") + "</button>");
            }
            out.println("</td>");
            out.println("</tr>");
            out.println("</tbody>");
            out.println("</table>");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("</div>");
        } // Parte en donde se presenta la forma para dar de alta el nuevo portlet de tipo contenido o de sistema
        else if (action.equals("edit")) {

            String sobj = request.getParameter("sobj");
            boolean isGlobal = false;
            log.debug("Edit: sobj: " + sobj);
            if (sobj.startsWith("global|")) {
                isGlobal = true;
                sobj = sobj.substring(sobj.indexOf("|") + 1);
            }

            SWBResourceURL urlPA = paramRequest.getActionUrl();
            urlPA.setAction("new");

            obj = ont.getSemanticObject(id);
            cls = obj.getSemanticClass();
            SemanticObject so = ont.getSemanticObject(sobj);
            SWBFormMgr fmgr = new SWBFormMgr(Resource.swb_Resource, obj, null);
            fmgr.setLang(user.getLanguage());
            fmgr.setAction(urlPA.toString());
            fmgr.setSubmitByAjax(true);
            fmgr.addButton(SWBFormButton.newSaveButton());
            SWBResourceURL urlback = paramRequest.getRenderUrl();
            urlback.setMode(SWBResourceURL.Mode_VIEW);
            urlback.setParameter("suri", id);
            if (null != idp) {
                urlback.setParameter("sprop", idp);
            }
            if (null != idptype) {
                urlback.setParameter("sproptype", idptype);
            }
            fmgr.addButton(SWBFormButton.newCancelButton().setAttribute("onclick", "submitUrl('" + urlback + "',this.domNode);return false;"));
            fmgr.setType(SWBFormMgr.TYPE_DOJO);

            log.debug("new: suri: " + id);
            log.debug("new: sprop: " + idp);
            log.debug("new: sproptype: " + idptype);
            log.debug("new: sobj: " + sobj);

            fmgr.addHiddenParameter("suri", id);
            fmgr.addHiddenParameter("sprop", idp);
            fmgr.addHiddenParameter("sproptype", idptype);
            fmgr.addHiddenParameter("sobj", sobj);
            fmgr.addHiddenParameter("isGlobal", Boolean.toString(isGlobal));
            out.println(fmgr.renderForm(request));
        }

        if (request.getParameter("preview") != null && request.getParameter("preview").equals("true")) {
            if (request.getParameter("sval") != null) {
                try {
                    doPreview(request, response, paramRequest);
                } catch (Exception e) {
                    out.println("Preview not available...");
                }
            } else {
                out.println("Preview not available...");
            }
        }
    }

    /**
     * Shows the preview of the content.
     *
     * @param request , this holds the parameters
     * @param response , an answer to the user request
     * @param paramRequest , a list of objects like user, webpage, Resource, ...
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doPreview(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String id = request.getParameter("sval");
        PrintWriter out = response.getWriter();
        out.println("<fieldset>");
        out.println("<legend>" + paramRequest.getLocaleString("previewdocument") + "</legend>");
        try {
            SWBResource res = SWBPortal.getResourceMgr().getResource(id);
            ((SWBParamRequestImp) paramRequest).setResourceBase(res.getResourceBase());
            res.render(request, response, paramRequest);
        } catch (Exception e) {
            log.error("Error while getting content string ,id:" + id, e);
        }
        out.println("</fieldset>");
    }

    /**
     * Show the list of the pflows to select one and send the element to the selected publish flow.
     *
     * @param request , this holds the parameters, an input data
     * @param response , an answer to the user request
     * @param paramRequest , a list of objects like user, webpage, Resource, ...
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doPFlowMessage(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        String id = request.getParameter("suri"); // id recurso
        String resid = request.getParameter("sval"); // id recurso
        String idp = request.getParameter("sprop"); // id recurso
        PrintWriter out = response.getWriter();

        User user = paramRequest.getUser();

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        PFlowManager pfmgr = SWBPortal.getPFlowManager();
        Resource res = (Resource) ont.getGenericObject(resid);

        String pfid = "";
        SemanticObject soref = ont.getSemanticObject(id);
        PFlow[] arrPf = pfmgr.getFlowsToSendContent(res);
        if (arrPf.length == 1) {
            pfid = arrPf[0].getId();
        }
        SWBResourceURL url2flow = paramRequest.getActionUrl();
        url2flow.setAction("send2flow");

        out.println("<div class=\"swbform\">");
        out.println("<form id=\"" + resid + "/" + getResourceBase().getId() + "/PFComment\" action=\"" + url2flow + "\" method=\"post\" onsubmit=\"submitForm('" + resid + "/" + getResourceBase().getId() + "/PFComment');return false;\">"); //reloadTab('" + id + "');
        out.println("<input type=\"hidden\" name=\"suri\" value=\"" + id + "\">");
        out.println("<input type=\"hidden\" name=\"sval\" value=\"" + resid + "\">");
        out.println("<input type=\"hidden\" name=\"sprop\" value=\"" + idp + "\">");
        out.println("<fieldset>");
        out.println("<table>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>");
        out.println(paramRequest.getLocaleString("comentary"));
        out.println("</td>");
        out.println("<td>");
        out.println("<input type=\"text\" name=\"usrmsg\" value=\"\" dojoType=\"dijit.form.TextBox\" required=\"true\"	");
        out.println(" promptMessage=\"" + paramRequest.getLocaleString("commentsend2flow") + "\"  />");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println(paramRequest.getLocaleString("publishflow"));
        out.println("</td>");
        out.println("<td>");
        out.println("<select name=\"pfid\">");
        for (int i = 0; i < arrPf.length; i++) {
            out.println("<option value=\"" + arrPf[i].getURI() + "\" " + (i == 0 ? "selected" : "") + ">" + arrPf[i].getDisplayTitle(user.getLanguage()) + "</option>");
        }
        out.println("</select>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("</filedset>");
        out.println("<filedset>");

        out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" >" + paramRequest.getLocaleString("btnSend2flow") + "</button>"); //_onclick=\"submitForm('"+id+"/"+idvi+"/"+base.getId()+"/FVIComment');return false;\"

        out.println("<button dojoType=\"dijit.form.Button\" onclick=\"hideDialog(); return false;\">" + paramRequest.getLocaleString("btnCancel") + "</button>"); //submitUrl('" + urlb + "',this.domNode); hideDialog();
        out.println("</filedset>");
        out.println("</form>");
        out.println("</div>");
    }

    /**
     * Do a specific action like add, remove, send to a publish flow, delete the reference between WebPage and Content.
     *
     * @param request , this holds the parameters
     * @param response , an answer to the user request, and a list of objects like user, webpage, Resource, ...
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        String id = request.getParameter("suri");
        String sprop = request.getParameter("sprop");
        String sproptype = request.getParameter("sproptype");
        String action = response.getAction();

        //System.out.println("Action: "+action);

        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = SemanticObject.createSemanticObject(id); //WebPage
        SemanticClass cls = obj.getSemanticClass();

        if ("new".equals(action)) {
            log.debug("ProcessAction(new) ");

            //id = request.getParameter("suri");
            //sprop = request.getParameter("sprop");
            //sproptype = request.getParameter("sproptype");
            String sobj = request.getParameter("sobj");

            SemanticProperty prop = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(sprop);
            log.debug("ProcessAction(new): sobj: " + sobj);

            SemanticObject wpage = null;
            wpage = obj;//ont.getSemanticObject(id);

            SWBFormMgr fmgr = new SWBFormMgr(Resource.swb_Resource, wpage, null);
            try {
                SemanticObject nso = fmgr.processForm(request);

                SemanticObject ptype = SemanticObject.createSemanticObject(sobj);
                nso.setObjectProperty(Resource.swb_resourceType, ptype);

                //System.out.println("nso:"+nso);
                //System.out.println("ptype:"+ptype);
                //System.out.println("obj:"+obj);

                if (prop.getName().startsWith("has")) {
                    obj.addObjectProperty(prop, nso);
                } else {
                    obj.setObjectProperty(prop, nso);
                }

                if (id != null) {
                    response.setRenderParameter("suri", id);
                }
                if (sprop != null) {
                    response.setRenderParameter("sprop", sprop);
                }
                if (sproptype != null) {
                    response.setRenderParameter("sproptype", sproptype);
                }
                if (nso != null) {
                    response.setRenderParameter("nsuri", nso.getURI());
                }
            } catch (FormValidateException e) {
                throw new SWBResourceException("Error to process form...", e);
            }

            response.setRenderParameter("statmsg", response.getLocaleString("statmsg1"));
            response.setMode(response.Mode_EDIT);
            response.setRenderParameter("act", "");
        } else if ("remove".equals(action)) //suri, prop
        {
            log.debug("processAction(remove)");

            String sval = request.getParameter("sval");
            Iterator<SemanticProperty> it = cls.listProperties();
            while (it.hasNext()) {
                SemanticProperty prop = it.next();
                String value = request.getParameter(prop.getName());
                //String sval = request.getParameter("sval");
                log.debug(prop.getURI() + ":" + sprop + "----" + (prop.getURI().equals(sprop) ? "true" : "false"));
                if (value != null && value.equals(sprop)) { //se tiene que validar el valor por si es mÃ¡s de una
                    if (sval != null) {
                        SemanticObject so = SemanticObject.createSemanticObject(sval);
                        //obj.removeObjectProperty(prop, so);
                        if (prop.getName().equalsIgnoreCase("userrepository")) {
                            obj.setObjectProperty(prop, ont.getSemanticObject("urswb"));
                        }

                        boolean trash = false;
                        if (so.instanceOf(Trashable.swb_Trashable)) {
                            boolean del = so.getBooleanProperty(Trashable.swb_deleted);
                            if (!del) {
                                trash = true;
                            }
                        }
                        if (!trash) {
                            so.remove();
                        } else {
                            so.setBooleanProperty(Trashable.swb_deleted, true);
                        }
//                        if(so.getSemanticClass().isSubClass(Trashable.swb_Trashable))
//                        {
//                            System.out.println("es trashable");
//                            so.setIntProperty(Trashable.swb_deleted, 1);
//                        }
//                        else
//                        {
//                            so.remove();
//                        }
                    }
                    break;
                }
            }
            if (sproptype != null) {
                response.setRenderParameter("sproptype", sproptype);
            }
            log.debug("remove-closetab:" + sval);
            response.setRenderParameter("closetab", sval);
            response.setRenderParameter("statmsg", response.getLocaleString("statmsg2"));
            response.setMode(SWBActionResponse.Mode_EDIT);
        } else if ("send2flow".equals(action)) {
            PFlowManager pfmgr = SWBPortal.getPFlowManager();
            String sval = request.getParameter("sval"); // id resource
            String pfid = request.getParameter("pfid"); // id pflow
            String usermessage = request.getParameter("usrmsg"); // mensaje del usuario
            PFlow pf = (PFlow) ont.getGenericObject(pfid);
            Resource res = (Resource) ont.getGenericObject(sval);
            pfmgr.sendResourceToAuthorize(res, pf, usermessage, response.getUser());
            response.setRenderParameter("dialog", "close");
            response.setMode(SWBActionResponse.Mode_EDIT);
        } else if ("deleteall".equals(action)) {
            log.debug("processAction(deleteall)" + sprop);
            //System.out.println("processAction(deleteall)");
            SemanticProperty sem_p = ont.getSemanticProperty(sprop);
            SemanticObject so = obj.getObjectProperty(sem_p);
            Iterator<SemanticObject> itso = obj.listObjectProperties(sem_p);
            SemanticObject soc = null;
            while (itso.hasNext()) {
                //System.out.println("revisando deleteAll (ListObjectsProperties)");
                soc = itso.next();
                Iterator<SemanticProperty> it = cls.listProperties();
                while (it.hasNext()) {
                    SemanticProperty prop = it.next();
                    //System.out.println("revisando (ListProperties("+sprop+")) "+ prop.getName());
                    String value = prop.getName();
                    //System.out.println(sem_p.getURI() + ":" + sprop + "----" + (prop.getURI().equals(sprop) ? "true" : "false"));
                    if (value != null && value.equals(sem_p.getName())) { //se tiene que validar el valor por si es más de una
                        //obj.removeObjectProperty(prop, soc);
                        if (sem_p.getName().equalsIgnoreCase("userrepository")) {
                            obj.setObjectProperty(prop, ont.getSemanticObject("urswb"));
                        }

                        boolean trash = false;
                        if (soc.instanceOf(Trashable.swb_Trashable)) {
                            boolean del = soc.getBooleanProperty(Trashable.swb_deleted);
                            if (!del) {
                                trash = true;
                            }
                        }
                        if (!trash) {
                            soc.remove();
                        } else {
                            soc.setBooleanProperty(Trashable.swb_deleted, true);
                        }


//                        if(soc.getSemanticClass().isSubClass(Trashable.swb_Trashable))
//                        {
//                            System.out.println("Es trashable.. delAll.."+soc.getURI());
//                            soc.setIntProperty(Trashable.swb_deleted, 1);
//                        }
//                        else
//                        {
//                            soc.remove();
//                        }

                        break;
                    }
                }

            }
            if (sproptype != null) {
                response.setRenderParameter("sproptype", sproptype);
            }
            response.setMode(SWBActionResponse.Mode_EDIT);
        }
        if (id != null) {
            response.setRenderParameter("suri", id);
        }
        if (sprop != null) {
            response.setRenderParameter("sprop", sprop);
        }
        if (request.getParameter("search") != null && request.getParameter("search").trim().length() > 0) {
            response.setRenderParameter("search", request.getParameter("search"));
        }
    }

    /**
     * Do an update, update status, active or unactive action of a Content element requested by the user.
     *
     * @param request , this holds the parameters
     * @param response , an answer to the user request
     * @param paramRequest , a list of objects like user, webpage, Resource, ...
     * @throws SWBResourceException, a Resource Exception
     * @throws IOException, an In Out Exception
     * @throws SWBResourceException the sWB resource exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void doAction(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        log.debug("doAction()");
        User user = paramRequest.getUser();
        PrintWriter out = response.getWriter();
        String id = request.getParameter("suri");
        String sprop = request.getParameter("sprop");
        String sproptype = request.getParameter("sproptype");
        String action = request.getParameter("act");
        String errormsg = "", actmsg = "";
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject obj = ont.getSemanticObject(id); //WebPage
        SemanticClass cls = obj.getSemanticClass();

        StringBuffer sbreload = new StringBuffer("");
        SemanticObject so = null;
        if ("update".equals(action)) {
            try {
                if (request.getParameter("sval") != null) {
                    obj = ont.getSemanticObject(request.getParameter("sval"));
                }
                cls = obj.getSemanticClass();
                Iterator<SemanticProperty> it = cls.listProperties();
                while (it.hasNext()) {
                    SemanticProperty prop = it.next();
                    if (prop.isDataTypeProperty()) {
                        String value = request.getParameter(prop.getName()); //prop.getName()
                        log.debug("doAction(update): " + prop.getName() + " -- >" + value);
                        if (value != null) {
                            if (value.length() > 0) {
                                if (prop.isBoolean()) {
                                    if (value.equals("true") || value.equals("1")) {
                                        obj.setBooleanProperty(prop, true);
                                    } else if (value.equals("false") || value.equals("0")) {
                                        obj.setBooleanProperty(prop, false);
                                    }
                                }
                                if (prop.isInt()) {
                                    obj.setIntProperty(prop, Integer.parseInt(value));
                                }
                                if (prop.isLong()) {
                                    obj.setLongProperty(prop, Long.parseLong(value));
                                }
                                if (prop.isString()) {
                                    obj.setProperty(prop, value);
                                }
                                if (prop.isFloat()) {
                                    obj.setFloatProperty(prop, Float.parseFloat(value));
                                }

                            } else {
                                obj.removeProperty(prop);
                            }
                        }
                    }
                }
                so = obj;
                actmsg = paramRequest.getLocaleString("upd_priority");
            } catch (Exception e) {
                log.error(e);
                errormsg = paramRequest.getLocaleString("statERRORmsg1");
            }
        } else if ("updstatus".equals(action)) {
            String soid = request.getParameter("sval");
            String value = request.getParameter("val");
            try {
                if (value == null) {
                    value = "0";
                }
                SemanticObject sobj = ont.getSemanticObject(soid);
                sobj.setBooleanProperty(Activeable.swb_active, value.equals("true") ? true : false);

                SemanticClass scls = sobj.getSemanticClass();
                log.debug("doAction(updstatus):" + scls.getClassName() + ": " + value);
                so = sobj;
                actmsg = (value.equals("true") ? paramRequest.getLocaleString("upd_active") : paramRequest.getLocaleString("upd_unactive"));
            } catch (Exception e) {
                log.error(e);
                errormsg = (value.equals("true") ? paramRequest.getLocaleString("statERRORmsg2") : paramRequest.getLocaleString("statERRORmsg3"));
            }
        } // revisar para agregar nuevo semantic object
        else if ("activeall".equals(action)) {
            log.debug("doAction(activeeall)" + sprop);
            String value = request.getParameter("sval");
            //System.out.println("doAction(activeeall)"+value);
            boolean bstat = false;
            if (value != null && "true".equals(value)) {
                bstat = true;
            }


            //System.out.println("processAction(deleteall)" + value);

            PFlowManager pfmgr = SWBPortal.getPFlowManager();
            Resource res = null;
            boolean isInFlow = false;
            boolean isAuthorized = false;
            boolean needAuthorization = false;
            boolean activeButton = false;

            SemanticProperty sem_p = ont.getSemanticProperty(sprop);
            so = obj.getObjectProperty(sem_p);
            Iterator<SemanticObject> itso = obj.listObjectProperties(sem_p);
            SemanticObject soc = null;
            while (itso.hasNext()) {
                //System.out.println("revisando deleteAll (ListObjectsProperties)");
                soc = itso.next();

                isInFlow = false;
                isAuthorized = false;
                needAuthorization = false;
                activeButton = true;
                //send2Flow = false;

                res = (Resource) soc.createGenericInstance();

                isInFlow = pfmgr.isInFlow(res);
                needAuthorization = pfmgr.needAnAuthorization(res);

                if (!isInFlow && !needAuthorization) {
                    activeButton = true;
                }
                if (!isInFlow && needAuthorization) {
                    activeButton = false;
                    //send2Flow = true;
                }

                if (isInFlow) {
                    isAuthorized = pfmgr.isAuthorized(res);
                    if (!isAuthorized) {
                        activeButton = false;
                    }
                    if (isAuthorized) {
                        activeButton = true;
                    }
                }

                try {
                    if (activeButton) {
                        if (bstat) {
                            soc.setBooleanProperty(Activeable.swb_active, true);
                        } else {
                            soc.removeProperty(Activeable.swb_active);
                        }
                        sbreload.append("\n reloadTab('" + soc.getURI() + "'); ");
                        sbreload.append("\n setTabTitle('" + soc.getURI() + "','" + SWBUtils.TEXT.scape4Script(soc.getDisplayName(user.getLanguage())) + "','" + SWBContext.UTILS.getIconClass(soc) + "');");

                    }
                } catch (Exception e) {
                    log.error(e);
                    errormsg = (value.equals("true") ? paramRequest.getLocaleString("statERRORmsg2") : paramRequest.getLocaleString("statERRORmsg3"));
                }
            }
            so = obj;
            actmsg = (value.equals("true") ? paramRequest.getLocaleString("upd_active") : paramRequest.getLocaleString("upd_unactive"));
        }

        if (errormsg.length() == 0) {
            out.println("<script type=\"text/javascript\">");
            out.println(" reloadTab('" + so.getURI() + "');");//so
            out.println(" setTabTitle('" + so.getURI() + "','" + SWBUtils.TEXT.scape4Script(so.getDisplayName(user.getLanguage())) + "','" + SWBContext.UTILS.getIconClass(so) + "')");
//            out.println(" reloadTab('" + obj.getURI() + "');");//so
//            out.println(" setTabTitle('" + obj.getURI() + "','" + obj.getDisplayName(user.getLanguage()) + "','" + SWBContext.UTILS.getIconClass(obj) + "');");
            out.println(sbreload.toString());
            out.println("   showStatus('" + actmsg + "');");
            out.println("</script>");
            //out.println(actmsg);
        } else {
            out.println(errormsg);
        }
    }

    /**
     * Gets a date format based on the language parameter.
     *
     * @param dateTime the date time
     * @param lang the lang
     * @return a string of the date time in a selected language
     */
    public String getDateFormat(long dateTime, String lang) {
        if (null == lang) {
            lang = "es";
        }
        Locale local = new Locale(lang);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, local);
        return df.format(new Date(dateTime));
    }

    /**
     * Gets the string of display name property of a semantic object.
     *
     * @param obj the obj
     * @param lang the lang
     * @return a string value of the DisplayName property
     */
    public String getDisplaySemObj(SemanticObject obj, String lang) {
        String ret = obj.getRDFName();
        try {
            ret = obj.getDisplayName(lang);
        } catch (Exception e) {
            ret = obj.getProperty(Descriptiveable.swb_title);
        }
        return ret;
    }

    /**
     * Gets the property value, it depends on the property type.
     *
     * @param obj the obj
     * @param prop the prop
     * @return get the corresponding property value
     */
    public String getValueSemProp(SemanticObject obj, SemanticProperty prop) {
        String ret = "";
        try {
            if (prop.isDataTypeProperty()) {
                log.debug("getValueSemProp..." + obj.getProperty(prop));
                if (prop.isBoolean()) {
                    ret = "" + obj.getBooleanProperty(prop);
                }
                if (prop.isInt()) {
                    ret = "" + obj.getIntProperty(prop);
                }
                if (prop.isLong()) {
                    ret = "" + obj.getLongProperty(prop);
                }
                if (prop.isFloat()) {
                    ret = "" + obj.getFloatProperty(prop);
                }
                if (prop.isString()) {
                    ret = obj.getProperty(prop);
                }
                if (prop.isDateTime()) {
                    ret = "" + obj.getDateProperty(prop);
                }
            }
        } catch (Exception e) {
            ret = "Not set";
        }
        return ret;
    }

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

        if (paramRequest.getMode().equals("doPflowMsg")) {
            doPFlowMessage(request, response, paramRequest);
        } else if (paramRequest.getMode().equals(Mode_Action)) {
            doAction(request, response, paramRequest);
        } else {
            super.processRequest(request, response, paramRequest);
        }
    }

    /**
     * Review sem prop.
     *
     * @param prop the prop
     * @param obj the obj
     * @param paramsRequest the params request
     * @return the string
     */
    public String reviewSemProp(SemanticProperty prop, SemanticObject obj, SWBParamRequest paramsRequest) {
        String ret = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.", new Locale(paramsRequest.getUser().getLanguage()));
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
        return ret;
    }
}