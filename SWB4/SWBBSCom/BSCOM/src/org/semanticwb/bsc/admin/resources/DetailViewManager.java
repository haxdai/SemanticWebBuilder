package org.semanticwb.bsc.admin.resources;

import org.semanticwb.bsc.Theme;
import org.semanticwb.bsc.Perspective;
import com.arthurdo.parser.HtmlException;
import com.arthurdo.parser.HtmlStreamTokenizer;
import com.arthurdo.parser.HtmlTag;
import com.hp.hpl.jena.rdf.model.Statement;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;
import javax.servlet.http.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.ComponentExportable;
import org.semanticwb.bsc.Detailed;
import org.semanticwb.bsc.PDFExportable;
import static org.semanticwb.bsc.PDFExportable.Mode_StreamPDF;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.*;
import org.semanticwb.bsc.formelement.DateElement;
import org.semanticwb.bsc.formelement.TextAreaElement;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.PeriodStatus;
import org.semanticwb.bsc.utils.DetailView;
import org.semanticwb.bsc.utils.PropertiesComparator;
import org.semanticwb.model.Descriptiveable;
import org.semanticwb.model.FormElement;
import org.semanticwb.model.GenericIterator;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.Template;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticClass;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.SWBFormMgr;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.util.SWBPriorityComparator;
import org.semanticwb.util.UploaderFileCacheUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 * Administra instancias disponibles de tipo {@code DetailView} cuya propiedad
 * {@code objectsType} tenga el mismo valor. También define cual de las
 * instancias de {@code DetailView} ser&aacute; la utilizada por el sistema para
 * presentar los datos de los objetos del BSC.
 *
 * @author jose.jimenez
 */
public class DetailViewManager extends org.semanticwb.bsc.admin.resources.base.DetailViewManagerBase
        implements PDFExportable {

    /**
     * Realiza operaciones en la bitacora de eventos.
     */
    private static Logger log = SWBUtils.getLogger(GenericSemResource.class);
    /**
     * Representa el nombre del archivo asociado a las plantillas creadas con
     * este recurso
     */
    private static final String TEMPLATE_FILENAME = "/templateContent.html";

    /**
     * Genera una instancia de este recurso
     */
    public DetailViewManager() {
    }

    /**
     * Constructs a DetailViewManager with a SemanticObject
     *
     * @param base The SemanticObject with the properties for the
     * DetailViewManager
     */
    public DetailViewManager(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    /**
     * Eval&uacute;a la configuraci&oacute;n hecha al recurso y si es
     * v&aacute;lida, permite el despliegue del listado de instancias
     * disponibles de las vistas detalle cuya propiedad {@code objectsType}
     * coincide con la configuraci&oacute;n del recurso.
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param response la respuesta generada a la petici&oacute;n recibida
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @throws SWBResourceException si durante la ejecuci&oacute;n no se cuenta
     * con los recursos necesarios para atender la petici&oacute;n
     * @throws IOException si durante la ejecuci&oacute;n ocurre alg&uacute;n
     * problema con la generaci&oacute;n o escritura de la respuesta
     */
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        boolean workClassIsValid = false;
        if (this.getWorkClass() != null) {
            SemanticClass semWorkClass = this.getWorkClass().transformToSemanticClass();
            workClassIsValid = semWorkClass.getRootClass().equals(BSCElement.bsc_BSCElement);
        }
        if (workClassIsValid) {
            //Una vez que se especifica la clase de objetos, se puede administrar las instancias
            doShowListing(request, response, paramRequest);
        } else {
            super.doAdmin(request, response, paramRequest);
        }
    }

    /**
     * Eval&uacute;a la configuraci&oacute;n hecha al recurso y si es
     * v&aacute;lida, permite el despliegue del listado de instancias
     * disponibles de las vistas detalle cuya propiedad {@code objectsType}
     * coincide con la configuraci&oacute;n del recurso.
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param response la respuesta generada a la petici&oacute;n recibida
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @throws SWBResourceException si durante la ejecuci&oacute;n no se cuenta
     * con los recursos necesarios para atender la petici&oacute;n
     * @throws IOException si durante la ejecuci&oacute;n ocurre alg&uacute;n
     * problema con la generaci&oacute;n o escritura de la respuesta
     */
    public void doShowListing(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        StringBuilder listCode = new StringBuilder(256);
        String lang = paramRequest.getUser().getLanguage();
        BSC bsc = (BSC) this.getResource().getWebSite();
        SemanticClass workClassSC = this.getWorkClass() != null
                ? this.getWorkClass().transformToSemanticClass()
                : null;
        String statusMsg = request.getParameter("statusMsg");
        String statusErr = request.getParameter("statusErr");
        String objectsType = workClassSC != null ? workClassSC.getURI() : null;
        Resource base = getResourceBase();

        if (bsc != null && objectsType != null) {
            SWBResourceURL urlCreate = paramRequest.getRenderUrl();
            urlCreate.setParameter("operation", "add");
            urlCreate.setMode("editTemplate");

            SWBResourceURL url = paramRequest.getActionUrl();
            url.setAction("setPerm");
            //Se genera el código HTML del encabezado de la tabla que muestra el listado de vistas
            listCode.append("<div class=\"swbform\">\n");

            listCode.append("<form dojoType=\"dijit.form.Form\" name=\"permissionsForm");
            listCode.append(this.getId());
            listCode.append("\" ");
            listCode.append("id=\"permissionsForm");
            listCode.append(this.getId());
            listCode.append("\" class=\"swbform\" onsubmit=\"submitForm('permissionsForm");
            listCode.append(this.getId());
            listCode.append("');return false;\" method=\"post\" action=\"");
            listCode.append(url.toString());
            listCode.append("\">\n");
            listCode.append("  <fieldset>\n");
            listCode.append("    <legend>");
            listCode.append(paramRequest.getLocaleString("lbl_grantsSelection"));
            listCode.append("</legend>\n");

            //Para mostrar la seleccion de otorgamiento de permisos
            String roleSelected = base.getAttribute("editRole", "");
            StringBuilder strRules = new StringBuilder(256);
            strRules.append("        <optgroup label=\"");
            strRules.append(paramRequest.getLocaleString("lbl_roles"));
            strRules.append("\">\n");
            Iterator<Role> iRoles = this.getResource().getWebSite().getUserRepository().listRoles();
            while (iRoles.hasNext()) {
                Role oRole = iRoles.next();
                strRules.append("        <option value=\"");
                strRules.append(oRole.getURI());
                strRules.append("\"");
                strRules.append(roleSelected.equals(oRole.getURI()) ? " selected=\"selected\" " : "");
                strRules.append(">");
                strRules.append(oRole.getDisplayTitle(lang));
                strRules.append("</option>\n");
            }
            strRules.append("        </optgroup>\n");
            strRules.append("        <optgroup label=\"");
            strRules.append(paramRequest.getLocaleString("lbl_userGroups"));
            strRules.append("\">\n");
            Iterator<UserGroup> iugroups = this.getResource().getWebSite().getUserRepository().listUserGroups();
            while (iugroups.hasNext()) {
                UserGroup oUG = iugroups.next();
                strRules.append("        <option value=\"");
                strRules.append(oUG.getURI());
                strRules.append("\"");
                strRules.append(roleSelected.equals(oUG.getURI()) ? " selected=\"selected\" " : "");
                strRules.append(">");
                strRules.append(oUG.getDisplayTitle(lang) == null ? oUG.getTitle() : oUG.getDisplayTitle(lang));
                strRules.append("</option>\n");
            }
            strRules.append("        </optgroup>\n");

            listCode.append("  <ul class=\"swbform-ul\">\n");
            listCode.append("    <li class=\"swbform-li\">\n");
            listCode.append("      <label for=\"updatePermit");
            listCode.append(this.getId());
            listCode.append("\" class=\"swbform-label\">");
            listCode.append(paramRequest.getLocaleString("lbl_permissionsSelect"));
            listCode.append("</label>\n");
            listCode.append("      <select name=\"updatePermit");
            listCode.append(this.getId());
            listCode.append("\">");
            listCode.append(strRules);
            listCode.append("       </select>\n");
            listCode.append("     </li>\n");
            listCode.append("   <li class=\"swbform-li\">");
            listCode.append("       <label for=\"before");
            listCode.append(this.getId());
            listCode.append("\" class=\"swbform-label\">");
            listCode.append(paramRequest.getLocaleString("lbl_timeBefore"));
            listCode.append("</label>");
            listCode.append("       <input type=\"text\" name=\"before\" id=\"before");
            listCode.append(this.getId());
            listCode.append("\" maxlength=\"2\" value=\"");
            listCode.append(base.getAttribute("before", "7"));
            listCode.append("\" regExp=\"\\d{1,2}\" dojoType=\"dijit.form.ValidationTextBox\" invalidMessage=\"");
            listCode.append(paramRequest.getLocaleString("err_incorrectAmount"));
            listCode.append("\"  promptMessage=\"");
            listCode.append(paramRequest.getLocaleString("msg_promptTimeBefore"));
            listCode.append("\" />");
            listCode.append("     </li>");
            listCode.append("   <li class=\"swbform-li\">");
            listCode.append("       <label for=\"after");
            listCode.append(this.getId());
            listCode.append("\" class=\"swbform-label\">");
            listCode.append(paramRequest.getLocaleString("lbl_timeAfter"));
            listCode.append("</label>");
            listCode.append("       <input type=\"text\" name=\"after\" id=\"after");
            listCode.append(this.getId());
            listCode.append("\" maxlength=\"2\" value=\"");
            listCode.append(base.getAttribute("after", "7"));
            listCode.append("\" regExp=\"\\d{1,2}\" dojoType=\"dijit.form.ValidationTextBox\" invalidMessage=\"");
            listCode.append(paramRequest.getLocaleString("err_incorrectAmount"));
            listCode.append("\"  promptMessage=\"");
            listCode.append(paramRequest.getLocaleString("msg_promptTimeAfter"));
            listCode.append("\" />");
            listCode.append("     </li>");
            listCode.append("   <li class=\"swbform-li\">");
            listCode.append("       <label for=\"timeUnit");
            listCode.append(this.getId());
            listCode.append("\" class=\"swbform-label\">");
            listCode.append(paramRequest.getLocaleString("lbl_unitOfTime"));
            listCode.append("</label>");
            listCode.append("       <select id=\"timeUnit");
            listCode.append(this.getId());
            listCode.append("\" name=\"timeUnit\" dojoType=\"dijit.form.FilteringSelect\">");
            listCode.append("         <option");
            listCode.append(base.getAttribute("unitTime", Integer.toString(Calendar.DATE)).equals(Integer.toString(Calendar.DATE)) ? " selected=\"selected\"" : "");
            listCode.append(" value=\"");
            listCode.append(Calendar.DATE);
            listCode.append("\">");
            listCode.append(paramRequest.getLocaleString("lbl_dayMeasure"));
            listCode.append("</option>");
            listCode.append("         <option ");
            listCode.append(base.getAttribute("unitTime", "").equals(Integer.toString(Calendar.WEEK_OF_YEAR)) ? "selected=\"selected\"" : "");
            listCode.append(" value=\"");
            listCode.append(Calendar.WEEK_OF_YEAR);
            listCode.append("\">");
            listCode.append(paramRequest.getLocaleString("lbl_weekMeasure"));
            listCode.append("</option>");
            listCode.append("         <option");
            listCode.append(base.getAttribute("unitTime", "").equals(Integer.toString(Calendar.MONTH)) ? " selected=\"selected\"" : "");
            listCode.append(" value=\"");
            listCode.append(Calendar.MONTH);
            listCode.append("\">");
            listCode.append(paramRequest.getLocaleString("lbl_monthMeasure"));
            listCode.append("</option>");
            listCode.append("         <option ");
            listCode.append(base.getAttribute("unitTime", "").equals(Integer.toString(Calendar.YEAR)) ? "selected=\"selected\"" : "");
            listCode.append(" value=\"");
            listCode.append(Calendar.YEAR);
            listCode.append("\">");
            listCode.append(paramRequest.getLocaleString("lbl_yearMeasure"));
            listCode.append("</option>");
            listCode.append("       </select>");
            listCode.append("     </li>");
            listCode.append("  </ul>\n");
            listCode.append("  </fieldset>\n");
            listCode.append("  <fieldset>\n");
            listCode.append("    <button dojoType=\"dijit.form.Button\" id=\"btnSavePerm");
            listCode.append(this.getId());
            listCode.append("\" type=\"button\">");
            listCode.append(paramRequest.getLocaleString("lbl_btnSubmit"));
            listCode.append("      <script type=\"dojo/method\" event=\"onClick\" args=\"evt\">\n");
            listCode.append("          submitForm(\"permissionsForm");
            listCode.append(this.getId());
            listCode.append("\");\n");
            listCode.append("          return false;\n");
            listCode.append("      </script>\n");
            listCode.append("    </button>\n");
            listCode.append("  </fieldset>\n");
            listCode.append("</form>\n");

            listCode.append("  <fieldset>\n");
            listCode.append("    <legend>");
            listCode.append(paramRequest.getLocaleString("lbl_objectsType"));
            listCode.append(workClassSC.getName());
            listCode.append("</legend>");
            listCode.append("    <table width=\"98%\" >\n");
            listCode.append("      <thead>\n");
            listCode.append("        <tr>\n");
            listCode.append("          <th>");
            listCode.append(paramRequest.getLocaleString("th_action"));
            listCode.append("</th>\n");
            listCode.append("          <th>");
            listCode.append(DetailView.swb_title.getDisplayName(lang));
            listCode.append("</th>\n");
            listCode.append("          <th>");
            listCode.append(DetailView.swb_modifiedBy.getDisplayName(lang));
            listCode.append("</th>\n");
            listCode.append("          <th>");
            listCode.append(DetailView.swb_updated.getDisplayName(lang));
            listCode.append("</th>\n");
            listCode.append("          <th>");
            listCode.append(paramRequest.getLocaleString("th_assigned"));
            listCode.append("</th>\n");
            listCode.append("        </tr>\n");
            listCode.append("      </thead>\n");
            listCode.append("      <tbody>\n");

            Iterator listOfViews = DetailView.ClassMgr.listDetailViews(bsc);

            if (listOfViews != null && listOfViews.hasNext()) {
                ArrayList<DetailView> viewsList = new ArrayList<DetailView>(32);
                while (listOfViews.hasNext()) {
                    DetailView view2Include = (DetailView) listOfViews.next();
                    if (view2Include.getObjectsType() != null
                            && view2Include.getObjectsType().equals(objectsType)) {
                        viewsList.add(view2Include);
                    }
                }
                listOfViews = viewsList.iterator();
            }
            if (listOfViews != null && listOfViews.hasNext()) {
                listOfViews = SWBComparator.sortByDisplayName(listOfViews, lang);

                //Se agrega al listado cada vista creada
                while (listOfViews.hasNext()) {
                    DetailView view = (DetailView) listOfViews.next();

                    SWBResourceURL urlEdit = paramRequest.getRenderUrl();
                    urlEdit.setParameter("operation", "edit");
                    urlEdit.setParameter("viewUri", view.getURI());
                    urlEdit.setMode("editTemplate");

                    SWBResourceURL urlDelete = paramRequest.getActionUrl();
                    urlDelete.setAction("deleteView");
                    urlDelete.setParameter("svUri", view.getURI());

                    SWBResourceURL urlMakeActive = paramRequest.getActionUrl();
                    urlMakeActive.setAction("makeActive");
                    urlMakeActive.setParameter("svUri", view.getURI());

                    //Se genera el HTML para las opciones de edición, eliminación
                    listCode.append("        <tr>\n");
                    listCode.append("          <td>\n");
                    listCode.append("            <a href=\"void(0);\" title=\"");
                    listCode.append(paramRequest.getLocaleString("ttl_lnkEdit"));
                    listCode.append("\" onclick=\"submitUrl('");
                    listCode.append(urlEdit);
                    listCode.append("', this);return false;\"><img src=\"");
                    listCode.append(SWBPlatform.getContextPath());
                    listCode.append("/swbadmin/icons/editar_1.gif\" border=\"0\" alt=\"");
                    listCode.append(paramRequest.getLocaleString("ttl_lnkEdit"));
                    listCode.append("\"></a>\n");
                    listCode.append("            <a href=\"void(0);\" title=\"");
                    listCode.append(paramRequest.getLocaleString("ttl_lnkDelete"));
                    listCode.append("\" onclick=\"if (confirm('");
                    listCode.append(paramRequest.getLocaleString("msg_confirmRemove"));
                    listCode.append(SWBUtils.TEXT.scape4Script(view.getTitle() != null ? view.getTitle() : "xxx"));
                    listCode.append("?')){submitUrl('");
                    listCode.append(urlDelete);
                    listCode.append("', this);}return false;\"><img src=\"");
                    listCode.append(SWBPlatform.getContextPath());
                    listCode.append("/swbadmin/images/delete.gif\" border=\"0\" alt=\"");
                    listCode.append(paramRequest.getLocaleString("ttl_lnkDelete"));
                    listCode.append("\"></a>\n");
                    listCode.append("          </td>\n");
                    listCode.append("          <td>");
                    listCode.append("            <a href=\"void(0);\" title=\"");
                    listCode.append(paramRequest.getLocaleString("ttl_lnkEdit"));
                    listCode.append("\" onclick=\"submitUrl('");
                    listCode.append(urlEdit);
                    listCode.append("', this);return false;\">");
                    listCode.append(view.getTitle() != null ? view.getTitle() : "xxx");
                    listCode.append("</a>\n");
                    listCode.append("          </td>\n");
                    listCode.append("          <td>");
                    listCode.append(view.getModifiedBy() != null ? view.getModifiedBy().getFullName() : "xxx");
                    listCode.append("          </td>\n");
                    listCode.append("          <td>");
                    listCode.append(view.getUpdated() != null ? view.getUpdated() : "xxx");
                    listCode.append("          </td>\n");
                    listCode.append("          <td align=\"center\">");

                    if (this.getActiveDetailView() == null || (this.getActiveDetailView() != null
                            && !this.getActiveDetailView().getURI().equals(view.getURI()))) {
                        //Código HTML para asignación como contenido
                        listCode.append("          <input type=\"radio\" dojoType=\"dijit.form.RadioButton\" ");
                        listCode.append("name=\"asContent\" id=\"asContent");
                        listCode.append(view.getId());
                        listCode.append("\" value=\"");
                        listCode.append(view.getId());
                        listCode.append("\" onclick=\"submitUrl('");
                        listCode.append(urlMakeActive);
                        listCode.append("', this.domNode);return false;\">");
                    } else if (this.getActiveDetailView() != null
                            && this.getActiveDetailView().getURI().equals(view.getURI())) {
                        listCode.append("          <input type=\"radio\" dojoType=\"dijit.form.RadioButton\" ");
                        listCode.append("name=\"asContent\" id=\"asContent");
                        listCode.append(view.getId());
                        listCode.append("\" value=\"");
                        listCode.append(view.getId());
                        listCode.append("\" checked=\"checked\" onclick=\"submitUrl('");
                        listCode.append(urlMakeActive);
                        listCode.append("', this.domNode);return false;\">");
                    }
                    listCode.append("          </td>\n");
                    listCode.append("        </tr>\n");

                }
            }
            listCode.append("      </tbody>\n");
            listCode.append("    </table>\n");
            listCode.append("  </fieldset>\n");
            listCode.append("  <fieldset>\n");
            listCode.append("    <button dojoType=\"dijit.form.Button\" onclick=\"submitUrl('");
            listCode.append(urlCreate);
            listCode.append("', this.domNode); return false;\">");
            listCode.append(paramRequest.getLocaleString("btn_add"));
            listCode.append("</button>\n");
            listCode.append("  </fieldset>\n");
            listCode.append("</div>\n");
        } else {
            DetailViewManager.log.error(new SWBResourceException("Propiedad DetailViewManager.workClass es nula"));
        }

        //Muestra mensaje sobre resultado de la operacion realizada
        if ((statusMsg != null && !statusMsg.isEmpty())
                || (statusErr != null && !statusErr.isEmpty())) {
            listCode.append("<div dojoType=\"dojox.layout.ContentPane\">\n");
            listCode.append("    <script type=\"dojo/method\">\n");
            if (statusMsg != null) {
                statusMsg = paramRequest.getLocaleString(statusMsg);
                listCode.append("        showStatus('" + statusMsg + "');\n");
            } else if (statusErr != null) {
                statusErr = paramRequest.getLocaleString(statusErr);
                listCode.append("        showError('" + statusErr + "');\n");
            }
            listCode.append("    </script>\n");
            listCode.append("</div>\n");
        }

        out.println(listCode.toString());

    }

    /**
     * Muestra la interface para captura de los datos de las vistas detalle,
     * dentro de los cuales se define la configuraci&oacute;n del despliegue de
     * informaci&oacute;n de los objetos del tipo especificado en la
     * configuraci&oacute;n del recurso.
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param response la respuesta generada a la petici&oacute;n recibida
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @throws SWBResourceException si durante la ejecuci&oacute;n no se cuenta
     * con los recursos necesarios para atender la petici&oacute;n
     * @throws IOException si durante la ejecuci&oacute;n ocurre alg&uacute;n
     * problema con la generaci&oacute;n o escritura de la respuesta
     */
    public void doEditTemplate(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        StringBuilder output = new StringBuilder(512);
        String templateContent = "";
        String viewUri = request.getParameter("viewUri") != null
                ? request.getParameter("viewUri") : "";
        String propertiesUrl = paramRequest.getRenderUrl().setMode("getPropertiesInfo").setCallMethod(SWBResourceURLImp.Call_DIRECT).toString();
        String operation = request.getParameter("operation") == null
                ? "add" : request.getParameter("operation");
        String statusMsg = request.getParameter("statusMsg");
        String statusErr = request.getParameter("statusErr");

        String lang = paramRequest.getUser().getLanguage();
        SWBFormMgr formMgr = null;
        String modeUsed = null;
        SWBResourceURL url = paramRequest.getActionUrl();
        DetailView viewSemObject = !viewUri.isEmpty()
                ? (DetailView) SemanticObject.getSemanticObject(viewUri).createGenericInstance()
                : null;

        if (operation.equals("edit")) {
            if (viewSemObject == null) {
                throw new SWBResourceException("View URI is null while editing");
            }
            modeUsed = SWBFormMgr.MODE_EDIT;
            formMgr = new SWBFormMgr(DetailView.bsc_DetailView,
                    viewSemObject.getSemanticObject(), modeUsed);
            url.setAction("editView");
            String filePath = SWBPortal.getWorkPath()
                    + viewSemObject.getWorkPath() + DetailViewManager.TEMPLATE_FILENAME;
            templateContent = SWBUtils.IO.getFileFromPath(filePath);
        } else if (operation.equals("add")) {
            modeUsed = SWBFormMgr.MODE_CREATE;
            formMgr = new SWBFormMgr(DetailView.sclass, null, modeUsed);
            url.setAction("addView");
        }

        //Se genera el código HTML para presentar la forma en que se capturan los datos de la vista detalle
        //para los dos modos: creación y edición
        output.append("        <div>\n");
        output.append("            <form dojoType=\"dijit.form.Form\" name=\"detailViewForm");
        output.append(this.getId());
        output.append("\" ");
        output.append("id=\"detailViewForm");
        output.append(this.getId());
        output.append("\" class=\"swbform\" onsubmit=\"submitForm('detailViewForm");
        output.append(this.getId());
        output.append("');return false;\" method=\"post\" action=\"");
        output.append(url.toString());
        output.append("\">\n");
        output.append("                <input type=\"hidden\" id=\"urlForProperties\" name=\"urlForProperties\" value=\"");
        output.append(propertiesUrl);
        output.append("\">\n");

        if (operation.equals("edit")) {
            output.append("                <input type=\"hidden\" id=\"svUri");
            output.append(this.getId());
            output.append("\" name=\"svUri\" value=\"" + viewUri + "\">\n");
        }
        output.append("<fieldset>\n");
        output.append("    <legend>");
        output.append(paramRequest.getLocaleString("lbl_pageTitle"));
        output.append("</legend>\n");
        output.append("    <table>\n");
        output.append("        <tbody>\n");
        output.append("            <tr>\n");
        output.append("                <td width=\"200px\" align=\"right\">\n");
        output.append("                    ");
        output.append(formMgr.renderLabel(request, DetailView.swb_title, DetailView.swb_title.getName(), modeUsed));
        output.append("                </td>\n");
        output.append("                <td>\n");
        output.append("                    ");
        if (operation.equals("edit") && viewSemObject != null) {
            output.append(
                    formMgr.getFormElement(DetailView.swb_title).renderElement(
                            request, viewSemObject.getSemanticObject(), DetailView.swb_title,
                            DetailView.swb_title.getName(), "dojo", modeUsed, lang));
        } else if (operation.equals("add")) {
            output.append(
                    formMgr.getFormElement(DetailView.swb_title).renderElement(
                            request, null, DetailView.swb_title, DetailView.swb_title.getName(),
                            "dojo", modeUsed, lang));
        }
        output.append("                </td>\n");
        output.append("            </tr>\n");
        output.append("            <tr>\n");
        output.append("                <td width=\"200px\" align=\"right\">\n");
        output.append("                    ");
        output.append(formMgr.renderLabel(request, DetailView.swb_description, modeUsed));
        output.append("                </td>\n");
        output.append("                <td>\n");
        output.append("                    ");
        if (operation.equals("edit") && viewSemObject != null) {
            output.append(
                    formMgr.getFormElement(DetailView.swb_description).renderElement(
                            request, viewSemObject.getSemanticObject(), DetailView.swb_description,
                            DetailView.swb_description.getName(), "dojo", modeUsed, lang));
        } else if (operation.equals("add")) {
            output.append(
                    formMgr.getFormElement(DetailView.swb_description).renderElement(
                            request, null, DetailView.swb_description, DetailView.swb_description.getName(),
                            "dojo", modeUsed, lang));
        }
        output.append("                </td>\n");
        output.append("            </tr>\n");
        output.append("            <tr>\n");
        output.append("                <td align=\"right\">\n");
        output.append("                  <label for=\"FCKeditorDetailView");
        output.append(this.getId());
        output.append("\">\n");
        output.append(paramRequest.getLocaleString("lbl_template"));
        output.append("&nbsp; \n");
        output.append("                  </label>\n");
        output.append("                </td>\n");
        output.append("                <td align=\"left\" width=\"850px\" height=\"600px\">\n");
        output.append("                  <textarea name=\"FCKeditorDetailView");
        output.append(this.getId());
        output.append("\" id=\"FCKeditorDetailView");
        output.append(this.getId());
        output.append("\">");
        output.append(templateContent);
        output.append("</textarea>\n");
        output.append("");
        output.append("<div dojoType=\"dojox.layout.ContentPane\">\n");
        output.append("    <script type=\"dojo/method\">\n");
        output.append("      var oFCKeditor = new FCKeditor( 'FCKeditorDetailView");
        output.append(this.getId());
        output.append("', '100%', '100%' ) ;\n");
        output.append("      oFCKeditor.BasePath = '");
        output.append(SWBPlatform.getContextPath());
        output.append("/swbadmin/js/fckeditor/';\n");
        output.append("      oFCKeditor.Config['CustomConfigurationsPath'] = ");
        output.append(SWBPlatform.getContextPath());
        output.append("'/swbadmin/js/fckeditor/fckconfig_inserter.js';\n");
        output.append("      oFCKeditor.ReplaceTextarea();\n");
        output.append("      oFCKeditor.urlInsertHtmlData = '");
        output.append(SWBUtils.TEXT.scape4Script(propertiesUrl));
        output.append("' ;\n");
        output.append("    </script>\n");
        output.append("</div>\n");
        output.append("                </td>\n");
        output.append("            </tr>\n");
        output.append("        </tbody>\n");
        output.append("    </table>\n");
        output.append("</fieldset>\n");
        //despliegue de botones
        output.append("<fieldset>\n");
        output.append("    <button dojoType=\"dijit.form.Button\" id=\"btnSave");
        output.append(this.getId());
        output.append("\" type=\"button\">");
        output.append(paramRequest.getLocaleString("lbl_btnSubmit"));
        output.append("      <script type=\"dojo/method\" event=\"onClick\" args=\"evt\">\n");
        output.append("        var oEditor = FCKeditorAPI.GetInstance('FCKeditorDetailView");
        output.append(this.getId());
        output.append("') ;\n");
        output.append("        document.getElementById('FCKeditorDetailView");
        output.append(this.getId());
        output.append("').value = oEditor.GetData();\n");
        output.append("        submitForm(\"detailViewForm");
        output.append(this.getId());
        output.append("\");\n");
        output.append("        return false;\n");
        output.append("      </script>\n");
        output.append("    </button>\n");

        SWBResourceURL urlCancel = paramRequest.getRenderUrl();
        urlCancel.setMode("showListing");
        output.append("    <button dojoType=\"dijit.form.Button\" ");
        output.append("type=\"button\" onClick=\"reloadTab('");
        output.append(this.getResource().getURI());
        output.append("');\">\n");
        output.append(paramRequest.getLocaleString("lbl_btnCancel"));
        output.append("    </button>\n");

        output.append("</fieldset>\n");
        output.append("            </form>\n");
        output.append("        </div>\n");

        //Muestra mensaje sobre resultado de la operacion realizada
        if ((statusMsg != null && !statusMsg.isEmpty())
                || (statusErr != null && !statusErr.isEmpty())) {

            output.append("<div dojoType=\"dojox.layout.ContentPane\">\n");
            output.append("    <script type=\"dojo/method\">\n");
            if (statusMsg != null) {
                statusMsg = paramRequest.getLocaleString(statusMsg);
                output.append("        showStatus('" + statusMsg + "');\n");
            } else if (statusErr != null) {
                statusErr = paramRequest.getLocaleString(statusErr);
                output.append("        showError('" + statusErr + "');\n");
            }
            output.append("    </script>\n");
            output.append("</div>\n");
        }

        out.println(output);
    }

    /**
     * Genera el despliegue de los datos asociados a los elementos del BSC, de
     * acuerdo a la configuración hecha para la vista detalle asignada como
     * contenido.
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param response la respuesta generada a la petici&oacute;n recibida
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @throws SWBResourceException si durante la ejecuci&oacute;n no se cuenta
     * con los recursos necesarios para atender la petici&oacute;n
     * @throws IOException si durante la ejecuci&oacute;n ocurre alg&uacute;n
     * problema con la generaci&oacute;n o escritura de la respuesta
     */
    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        PrintWriter out = response.getWriter();
        StringBuilder output = new StringBuilder(256);
        String message = validateInput(request, paramRequest);

        if (message == null) {
            FileReader reader = retrieveTemplate();
            String suri = request.getParameter("suri");
            SemanticObject semObj = SemanticObject.getSemanticObject(suri);
            //Declarar variable para el per&iacte;odo, obteniendo el valor del request
            String modelName = paramRequest.getWebPage().getWebSiteId();
            String periodId = request.getSession().getAttribute(modelName) != null
                    ? (String) request.getSession().getAttribute(modelName)
                    : null;
            String statusStyleClass = "indefinido";
            String secondStatusStyleClass = null;
            //Si no hay sesión, la petición puede ser directa (una liga en un correo). Crear sesión y atributo:
            if (periodId == null) {
                periodId = request.getParameter(modelName) != null ? request.getParameter(modelName) : null;
                if (periodId != null) {
                    request.getSession(true).setAttribute(modelName, periodId);
                }
            }
            Period period = Period.ClassMgr.getPeriod(periodId, paramRequest.getWebPage().getWebSite());

            //periodStatus dejo de servir al introducir Detailed
            //PeriodStatus periodStatus = null;
            UserGroup collaboration = null;
            GenericObject generic = semObj.createGenericInstance();
            Detailed d = (Detailed) generic;
            statusStyleClass = d.getStatusIconClass(period);

            //-Agrega encabezado al cuerpo de la vista detalle, en el que se muestre el estado del objeto
            // para el per&iacte;odo especificado y el t&iacte;tulo del objeto, para lo que:
            //    - Se pide el listado de objetos PeriodStatus asociado al semObj
            //    - Se recorre uno por uno los PeriodStatus relacionados
            //    - Cuando el per&iacte;odo del PeriodStatus = per&iacte;odo del request:
            //        - Se obtiene el status correspondiente y su &iacte;cono relacionado
            //        - Se agrega el &iacte;cono al encabezado y el t&iacte;tulo del objeto semObj
            output.append("<!-- .....Aqui va el iconclass.............. -->").append("\n");
            output.append("<p class=\"fa fa-circle");
            output.append(statusStyleClass);
            output.append("\"></p>");
            output.append("<h4>");
            //secondStatusStyleClass dejo de asignarse desde el 17/06/14 con el uso de Detailed
            if (secondStatusStyleClass != null) {
                output.append("<span class=\"");
                output.append(secondStatusStyleClass);
                output.append("\"> &nbsp; </span>");
            }
            output.append(semObj.getDisplayName());
            output.append("</h4>\n");
            output.append("<hr>\n");
            
            if (reader != null) {
                output.append(generateDisplay(request, paramRequest, reader, semObj, collaboration));
            } else {
                output.append(paramRequest.getLocaleString("fileNotRead"));
            }
        } else { //Si la información de entrada no es válida
            output.append(paramRequest.getLocaleString(message));
        }

        out.println(output.toString());
    }

    /**
     * Genera una estructura de objetos JSON con los datos de las propiedades
     * pertenecientes a la clase configurada en el recurso.
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param response la respuesta generada a la petici&oacute;n recibida
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @throws SWBResourceException si durante la ejecuci&oacute;n no se cuenta
     * con los recursos necesarios para atender la petici&oacute;n
     * @throws IOException si durante la ejecuci&oacute;n ocurre alg&uacute;n
     * problema con la generaci&oacute;n o escritura de la respuesta
     */
    public void doGetPropertiesInfo(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {

        response.setContentType("application/json; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        PrintWriter out = response.getWriter();
        SemanticClass semWorkClass = this.getWorkClass().transformToSemanticClass();
        JSONArray array = new JSONArray();
        String structure = "";

        if (semWorkClass != null) {
            ArrayList<SemanticProperty> propsList
                    = (ArrayList<SemanticProperty>) SWBUtils.Collections.copyIterator(semWorkClass.listSortProperties());
            Collections.sort(propsList, new PropertiesComparator());
            Iterator<SemanticProperty> basePropertiesList = propsList.iterator();
            try {
                while (basePropertiesList.hasNext()) {
                    SemanticProperty prop = basePropertiesList.next();
                    if (prop.getDisplayProperty() != null || displayElementExists(prop)) {
                        //Se crea una estructura de JSON con los datos de las propiedades de la clase en la variable array
                        JSONObject object = new JSONObject();
                        object.put("name", prop.getName());
                        object.put("label", prop.getDisplayName());
                        object.put("uri", prop.getURI());
                        array.put(object);
                    }
                }
                structure = array.toString(2);
            } catch (JSONException jsone) {
                structure = "";
                DetailViewManager.log.error("Al generar estructura de JSON con propiedades semanticas", jsone);
            }
        }
        //Se regresa como respuesta la estructura de JSON creada
        out.println(structure);
    }

    /**
     * Determina el modo a ejecutar, en base a los parámetros recibidos en la
     * petici&oacute;n del cliente
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param response la respuesta generada a la petici&oacute;n recibida
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @throws SWBResourceException si durante la ejecuci&oacute;n no se cuenta
     * con los recursos necesarios para atender la petici&oacute;n
     * @throws IOException si durante la ejecuci&oacute;n ocurre alg&uacute;n
     * problema con la generaci&oacute;n o escritura de la respuesta
     */
    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String mode = paramRequest.getMode();
        if("showListing".equalsIgnoreCase(mode)) {
            doShowListing(request, response, paramRequest);
        }else if("editTemplate".equalsIgnoreCase(mode)) {
            doEditTemplate(request, response, paramRequest);
        }else if("getPropertiesInfo".equalsIgnoreCase(mode)) {
            doGetPropertiesInfo(request, response, paramRequest);
        }else if(Mode_StreamPDF.equalsIgnoreCase(mode)) {
            doGetPDFDocument(request, response, paramRequest);
        }else {
            super.processRequest(request, response, paramRequest);
        }
        /*switch (paramRequest.getMode()) {
            case "showListing":
                doShowListing(request, response, paramRequest);
                break;
            case "editTemplate":
                doEditTemplate(request, response, paramRequest);
                break;
            case "getPropertiesInfo":
                doGetPropertiesInfo(request, response, paramRequest);
                break;
            case Mode_StreamPDF:
                doGetPDFDocument(request, response, paramRequest);
                break;
            default:
                super.processRequest(request, response, paramRequest);
                break;
        }*/
    }

    /**
     * Realiza las operaciones de almacenamiento o eliminaci&oacute;n de
     * informaci&oacute;n de las vistas detalle administradas, asi como la
     * asignaci&oacute;n de una vista detalle seleccionada como contenido.
     *
     * @param request la petici&oacute;n enviada por el cliente
     * @param response la respuesta generada a la petici&oacute;n recibida
     * @throws SWBResourceException si durante la ejecuci&oacute;n no se cuenta
     * con los recursos necesarios para atender la petici&oacute;n
     * @throws IOException si durante la ejecuci&oacute;n ocurre alg&uacute;n
     * problema con la generaci&oacute;n o escritura de la respuesta
     */
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response)
            throws SWBResourceException, IOException {

        String action = response.getAction();
        String title = request.getParameter("title");
        String descrip = request.getParameter("description");
        String configuration = request.getParameter("FCKeditorDetailView" + this.getId()) != null
                ? request.getParameter("FCKeditorDetailView" + this.getId())
                : "";
        String detailViewUri = request.getParameter("svUri");
        String statusMsg = null;
        String errorMsg = null;
        String lang = response.getUser().getLanguage();
        String viewFilePath = null;
        DetailView detailView = null;
        BSC bscModel = (BSC) this.getResource().getWebSite();
        boolean listingRedirect = false;
        boolean formRedirect = false;
        boolean storePath = false;
        if (!"addView".equals(action)) {
            detailView = SemanticObject.getSemanticObject(detailViewUri) != null
                    ? ((DetailView) SemanticObject.getSemanticObject(
                            detailViewUri).createGenericInstance())
                    : null;
        }
        if ("addView".equals(action)
                || "editView".equals(action)) {

            if ("addView".equals(action)) {
                SemanticClass semWorkClass = this.getWorkClass().transformToSemanticClass();

                if (semWorkClass != null) {
                    detailView = DetailView.ClassMgr.createDetailView(bscModel);
                    detailView.setObjectsType(semWorkClass.getURI());

                    statusMsg = "msg_ViewCreated";
                }
            } else if ("editView".equals(action)) {

                statusMsg = "msg_ViewUpdated";
            }
            if (detailView != null) {

                if (!configuration.isEmpty()) {
                    //Almacenar en el archivo asociado el contenido de la configuración
                    viewFilePath = SWBPortal.getWorkPath() + detailView.getWorkPath();
                    FileWriter writer = null;
                    try {
                        boolean filePathExists = true;
                        File filePath = new File(viewFilePath);
                        if (!filePath.exists()) {
                            filePathExists = filePath.mkdirs();
                        }
                        viewFilePath += DetailViewManager.TEMPLATE_FILENAME;
                        File file = new File(viewFilePath);
                        if (detailView.getViewFilePath() == null) {
                            storePath = true;
                        }
                        if (filePathExists) {
                            writer = new FileWriter(file);
                            writer.write(configuration);
                        }
                    } catch (IOException ioe) {
                        DetailViewManager.log.error("Al escribir el contenido de la plantilla", ioe);
                        errorMsg = "msg_FileNotWriten";
                    } finally {
                        if (writer != null) {
                            writer.flush();
                            writer.close();
                        }
                    }
                    if (storePath) {
                        detailView.setViewFilePath(viewFilePath);
                    }
                }
                //Se actualiza informacion de Traceable
                SWBPortal.getServiceMgr().updateTraceable(detailView.getSemanticObject(), response.getUser());
                detailView.setTitle(title, lang);
                detailView.setTitle(title);
                detailView.setDescription(descrip, lang);
                detailView.setDescription(descrip);
                response.setRenderParameter("viewUri", detailView.getURI());
                response.setRenderParameter("operation", "edit");
            }
            formRedirect = true;

        } else if ("deleteView".equals(action)) {

            if (detailView != null) {
                try {
                    boolean viewFileDeleted = false;
                    if (this.getActiveDetailView() != null && this.getActiveDetailView() == detailView) {
                        this.setActiveDetailView(null);
                    }
                    //Se debe eliminar el archivo asociado a la vista detalle a eliminar
                    if (detailView.getViewFilePath() != null) {
                        File toDelete = new File(detailView.getViewFilePath());
                        if (toDelete.canWrite()) {
                            viewFileDeleted = toDelete.delete();
                        }
                    }
                    if (viewFileDeleted) {
                        DetailView.ClassMgr.removeDetailView(detailView.getId(), bscModel);
                        statusMsg = "msg_ViewDeleted";
                    } else {
                        errorMsg = "msg_ViewNotDeleted";
                    }
                } catch (Exception e) {
                    errorMsg = "msg_ViewNotDeleted";
                    DetailViewManager.log.error("Al eliminar una vista detalle", e);
                }
            }
            listingRedirect = true;
        } else if (action.equalsIgnoreCase("makeActive") && detailView != null) {
            //asignar a DetailViewAdm la instancia de DetailView correspondiente al uri recibido en request
            this.setActiveDetailView(detailView);
            statusMsg = "msg_ContentViewAssigned";
            listingRedirect = true;
        } else if (action.equalsIgnoreCase("setPerm")) {
            Resource base = getResourceBase();

            String userType = request.getParameter("updatePermit" + this.getId());
            String atribBefore = request.getParameter("before");
            String atribAfter = request.getParameter("after");
            String propTimeUnit = request.getParameter("timeUnit");
            if (userType != null && !userType.isEmpty()) {
                base.setAttribute("editRole", userType);
            } else {
                base.removeAttribute("editRole");
            }
            if (atribBefore != null && !atribBefore.isEmpty()) {
                base.setAttribute("before", atribBefore);
            } else {
                base.removeAttribute("before");
            }
            if (atribAfter != null && !atribAfter.isEmpty()) {
                base.setAttribute("after", atribAfter);
            } else {
                base.removeAttribute("after");
            }
            if (propTimeUnit != null && !propTimeUnit.isEmpty()) {
                base.setAttribute("unitTime", propTimeUnit);
            } else {
                base.removeAttribute("unitTime");
            }
            statusMsg = "msg_PermissionAssigned";
            listingRedirect = true;
            try {
                base.updateAttributesToDB();
            } catch (SWBException swbe) {
                DetailViewManager.log.error("Al asignar permisos", swbe);
            }
        } else if ("updateProp".equals(action)) {
            String objectUri = request.getParameter("suri");
            String propUri = request.getParameter("propUri");
            String propValue = request.getParameter("value");

            SemanticObject semanticObject = objectUri != null ? SemanticObject.getSemanticObject(objectUri) : null;
            SemanticProperty semProp = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(propUri);

            if (semanticObject != null && propUri != null && propValue != null) {
                String value = propValue;
                if (semProp.isDate()) {
                    try {
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        semanticObject.setDateProperty(semProp, format.parse(value));
                    } catch (Exception e) {
                        log.error(e);
                    }

                } else if (semProp.isString()) {
                    value = SWBUtils.XML.replaceXMLTags(propValue);
                    semanticObject.setProperty(semProp, value);
                }
            }
        } else {
            super.processAction(request, response);
        }

        if (statusMsg != null) {
            response.setRenderParameter("statusMsg", statusMsg);
        }
        if (errorMsg != null) {
            response.setRenderParameter("errorMsg", errorMsg);
        }

        if (listingRedirect) {
            response.setMode("showListing");
        } else if (formRedirect) {
            response.setMode("editTemplate");
        }
    }

    /**
     * Realiza validaciones a los datos de entrada para el despliegue de
     * informaci&oacute;n
     *
     * @param request petici&oacute;n HTTP realizada por el cliente
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @return un String que representa una llave del archivo de propiedades que
     * corresponde al mensaje de error que describe el problema encontrado en
     * los datos, null de lo contrario.
     */
    private String validateInput(HttpServletRequest request, SWBParamRequest paramRequest) {

        String suri = request.getParameter("suri");
        SemanticObject semObj = SemanticObject.getSemanticObject(suri);
        GenericObject genericObject = semObj != null ? semObj.createGenericInstance() : null;
        SemanticClass workClassSC = this.getWorkClass() != null
                ? this.getWorkClass().transformToSemanticClass()
                : null;
        String messageType = null;
        User user = paramRequest.getUser();

        //Variable para evaluar al periodo especificado
        String modelName = paramRequest.getWebPage().getWebSiteId();
        String periodId = request.getSession().getAttribute(modelName) != null
                ? (String) request.getSession().getAttribute(modelName)
                : null;
        if (periodId == null) {
            periodId = request.getParameter(modelName) != null ? request.getParameter(modelName) : null;
        }
        //Revisa configuracion del recurso
        if (workClassSC == null) {
            messageType = "workClassNotConfigured";
        }

        //Revisa datos recibidos en request
        if (messageType == null && genericObject == null) {
            messageType = "uriNotValid";
        }
        //Revisa que el usuario tenga permisos de acceso a la información del objeto especificado
        if (messageType == null && !user.haveAccess(genericObject)) {
            messageType = "userHasNoPermissions";
        }
        if (messageType == null && (genericObject instanceof Objective && workClassSC != Objective.sclass)) {
            messageType = "objectTypeMissmatch";
        } else if (messageType == null && (genericObject instanceof Indicator && workClassSC != Indicator.sclass)) {
            messageType = "objectTypeMissmatch";
        } else if (messageType == null && (genericObject instanceof Initiative && workClassSC != Initiative.sclass)) {
            messageType = "objectTypeMissmatch";
        } else if (messageType == null && (genericObject instanceof Deliverable && workClassSC != Deliverable.sclass)) {
            messageType = "objectTypeMissmatch";
        } else if (messageType == null && (genericObject instanceof Perspective && workClassSC != Perspective.sclass)) {
            messageType = "objectTypeMissmatch";
        } else if (messageType == null && (genericObject instanceof Theme && workClassSC != Theme.sclass)) {
            messageType = "objectTypeMissmatch";
        } else if (messageType == null && (genericObject instanceof Agreement && workClassSC != Agreement.sclass)) {
            messageType = "objectTypeMissmatch";
        } else if (messageType == null && (genericObject instanceof Risk && workClassSC != Risk.sclass)) {
            messageType = "objectTypeMissmatch";
        }

        //Revisa vista asignada como contenido
        if (messageType == null && this.getActiveDetailView() == null) {
            messageType = "withNoActiveView";
        }
        /*
         if (messageType == null && this.getActiveDetailView() != null &&
         this.getActiveDetailView().getViewFilePath() == null) {
         messageType = "activeViewWithNoFile";
         }*/
        if (messageType == null && this.getActiveDetailView() != null
                && this.getActiveDetailView().getViewFilePath() != null) {
            //Revisar que al menos exista un archivo con la ruta y nombre almacenados en this.getActiveDetailView().getViewFilePath()
            File templateFile = new File(SWBPortal.getWorkPath()
                    + this.getActiveDetailView().getWorkPath()
                    + DetailViewManager.TEMPLATE_FILENAME);
            //si no es el caso, asignar el tipo de mensaje:
            if (!templateFile.exists()) {
                messageType = "activeViewWithNoFile";
            }
        }

        //Revisa existencia de un periodo con el identificador recibido en la sesion
        //Si no existe el periodo, asignar el tipo de mensaje a "periodNotExistent"
        if (periodId != null && !Period.ClassMgr.hasPeriod(periodId, paramRequest.getWebPage().getWebSite())) {
            messageType = "periodNotExistent";
        }

        return messageType;
    }

    /**
     * Lee el archivo asociado a la vista detalle asignada como contenido.
     *
     * @return un objeto {@code FileReader} con el contenido del archivo
     * asociado a la vista detalle asignada como contenido.
     */
    private FileReader retrieveTemplate() {

        String filePath = SWBPortal.getWorkPath()
                + this.getActiveDetailView().getWorkPath() + DetailViewManager.TEMPLATE_FILENAME;
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
        } catch (FileNotFoundException fnfe) {
            DetailViewManager.log.error("Al leer plantilla de vista detalle con Id: "
                    + this.getActiveDetailView().getId(), fnfe);
        }
        return reader;
    }

    /**
     * Interpreta el contenido de la plantilla de la vista detalle asignada como
     * contenido, sustituyendo los tags que representan las propiedades de los
     * objetos, por los despliegues de valores de esas propiedades.
     *
     * @param request petici&oacute;n HTTP realizada por el cliente
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @param template el contenido de la vista detalle asignada como contenido
     * @param elementBSC representa el objeto del cual se desea extraer la
     * informaci&oacute;n
     * @return un {@code String} que representa el contenido de la plantilla de
     * la vista detalle correspondiente con el despliegue de los valores de las
     * propiedades configuradas.
     * @throws IOException en caso de que se presente alg&uacute;n problema en
     * el parseo del contenido de la plantilla
     */
    private String generateDisplay(HttpServletRequest request, SWBParamRequest paramRequest,
            FileReader template, SemanticObject elementBSC, final UserGroup collaboration) throws IOException {

        StringBuilder view = new StringBuilder(512);
        StringBuilder javascript = new StringBuilder(256);
        HtmlStreamTokenizer tok = new HtmlStreamTokenizer(template);
        HtmlTag tag = new HtmlTag();
        String lang = paramRequest.getUser().getLanguage();
        SWBResourceURL url = paramRequest.getActionUrl();
        url.setAction("updateProp");
        url.setParameter("suri", request.getParameter("suri"));
        request.setAttribute("urlRequest", url.toString());

        String modelName = paramRequest.getWebPage().getWebSiteId();
        String periodId = request.getSession().getAttribute(modelName) != null
                ? (String) request.getSession().getAttribute(modelName)
                : null;
        Period period = Period.ClassMgr.getPeriod(periodId, paramRequest.getWebPage().getWebSite());
        boolean showDateVariables = false;
        GenericObject generic = elementBSC.createGenericInstance();

        if (generic instanceof Initiative || generic instanceof Deliverable) {
            showDateVariables = true;
            javascript.append("<script type=\"text/javascript\">\n");
        }

        while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF) {
            int ttype = tok.getTokenType();

            if (ttype == HtmlStreamTokenizer.TT_TAG) {

                try {
                    //si no es un tag de imagen, que continue con el siguiente
                    tok.parseTag(tok.getStringValue(), tag);
                } catch (HtmlException htmle) {
                    DetailViewManager.log.error("Al parsear plantilla vista detalle, "
                            + this.getActiveDetailView().getId(), htmle);
                    view = new StringBuilder(16);
                }
                if (!tag.getTagString().toLowerCase().equals("img")) {
                    view.append(tag.toString());
                } else if (tag.getTagString().toLowerCase().equals("img") && !tag.hasParam("tagProp")) {
                    view.append(tag.toString());
                } else if (tag.getTagString().toLowerCase().equals("img") && tag.hasParam("tagProp")) {
                    /*
                     Si es un tag de imagen y tiene el atributo tagProp
                     obtener el valor del atributo tagProp que contiene el uri de la propiedad
                     */
                    String propUri = tag.getParam("tagProp");
                    if (propUri != null) {
                        view.append(renderPropertyValue(request, elementBSC, propUri, lang, period, collaboration));
                        if (showDateVariables) {
                            javascript.append(getDateValue(elementBSC, propUri));
                        }
                    }
                }
            } else if (ttype == HtmlStreamTokenizer.TT_TEXT) {
                view.append(tok.getStringValue());
            } else if (ttype == HtmlStreamTokenizer.TT_COMMENT) {
                view.append("<!--");
                view.append(tok.getStringValue());
                view.append("-->");
            }
            view.append("\n");
        }
        if (showDateVariables) {
            javascript.append("</script>\n");
        }

        return (javascript.toString() + view.toString());
    }

    /**
     * Devuelve el despliegue correspondiente al valor de la propiedad
     * especificada, del objeto indicado.
     *
     * @param request petici&oacute;n HTTP realizada por el cliente
     * @param elementBSC representa el objeto del cual se desea extraer la
     * informaci&oacute;n
     * @param propUri representa la uri de la propiedad semantica de la que se
     * desea obtener su valor
     * @param lang representa el lenguaje en que se desea mostrar el valor de la
     * propiedad indicada
     * @return el despliegue del valor almacenado para la propiedad indicada
     */
    private String renderPropertyValue(HttpServletRequest request, SemanticObject elementBSC,
            String propUri, String lang, Period period, final UserGroup collaboration) {

        String ret = null;
        SWBFormMgr formMgr = new SWBFormMgr(elementBSC, null, SWBFormMgr.MODE_VIEW);
        SemanticProperty semProp = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(propUri);

        //Codigo para obtener el displayElement
        Statement st = semProp.getRDFProperty().getProperty(
                SWBPlatform.getSemanticMgr().getSchema().getRDFOntModel().getProperty(
                        "http://www.semanticwebbuilder.org/swb4/bsc#displayElement"));
        if (st != null) {
            //Se obtiene: SemanticProperty: displayElement de la propiedad en cuestion (prop)
            SemanticObject soDisplayElement = SemanticObject.createSemanticObject(st.getResource());
            if (soDisplayElement != null) {
                SemanticObject formElement = soDisplayElement.getObjectProperty(
                        org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(
                                "http://www.semanticwebbuilder.org/swb4/xforms/ontology#formElement"));
                if (formElement != null) {
                    FormElement fe = (FormElement) formElement.createGenericInstance();
                    boolean applyInlineEdit = false;
                    /*                  Antes se evaluaba de la siguiente forma
                     if ((userCanEdit() && isInMeasurementTime(period) && isEditable(formElement))
                     || (userCanCollaborate(collaboration) && isEditable(formElement))
                     || (elementBSC.createGenericInstance() instanceof Initiative && userCanEdit()
                     && isEditable(formElement)) || (elementBSC.createGenericInstance() instanceof Deliverable
                     && userCanEdit() && isEditable(formElement))) {*/
                    if ((userCanEdit() && isInMeasurementTime(period) && isEditable(formElement))
                            || (this.isNonMeasurableElement(elementBSC) && userCanEdit() && isEditable(formElement))) {
                        applyInlineEdit = true;
                        //atributo agregado para permitir administrar los archivos adjuntos
                        request.setAttribute("usrWithGrants", "true");
                    }
                    if (fe != null) {
                        if (formMgr.getSemanticObject() != null) {
                            fe.setModel(formMgr.getSemanticObject().getModel());
                        }
                        request.setAttribute("downloadEle", "true");
                        ret = fe.renderElement(request, elementBSC, semProp, semProp.getName(),
                                SWBFormMgr.TYPE_XHTML,
                                applyInlineEdit ? "inlineEdit" : SWBFormMgr.MODE_VIEW,
                                lang);
                    }
                }
            }
        }

        if (ret == null) {
            FormElement formElement = formMgr.getFormElement(semProp);
            if (formElement != null) {
                ret = formElement.renderElement(request, elementBSC, semProp, semProp.getName(),
                        SWBFormMgr.TYPE_XHTML, SWBFormMgr.MODE_VIEW, lang);
            }
        }
        return ret != null ? ret : "";
    }

    /**
     * Verifica la existencia de un valor para el displayElement de una
     * propiedad en la ontolog&iacute;a
     *
     * @param property la propiedad sem&aacute;ntica de la que se requiere el
     * displayElement
     * @return {@literal true} si existe un valor para el displayElement en la
     * ontolog&iacute;a, {@literal false} de lo contrario
     */
    private boolean displayElementExists(SemanticProperty property) {

        boolean exists = false;

        Statement st = property.getRDFProperty().getProperty(
                SWBPlatform.getSemanticMgr().getSchema().getRDFOntModel().getProperty(
                        "http://www.semanticwebbuilder.org/swb4/bsc#displayElement"));
        if (st != null) {
            exists = true;
        }
        return exists;
    }

    /**
     * Determina si el usuario en sesi&oacute;n tiene los permisos necesarios
     * para hacer actualizaciones en la informaci&oacute;n del elemento
     * presentado en la vista detalle.
     *
     * @return un boleano que representa la posibilidad del usuario de hacer
     * actualizaciones ({@code true}), de lo contrario devuelve {@code false}.
     */
    private boolean userCanEdit() {
        boolean access = false;
        String str_role = getResourceBase().getAttribute("editRole", null);

        final WebSite scorecard = (WebSite) getSemanticObject().getModel().getModelObject().createGenericInstance();
        final User user = SWBContext.getSessionUser(scorecard.getUserRepository().getId());

        if (user != null && user.isSigned()) {
            if (str_role != null) {
                SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
                GenericObject gobj = null;
                try {
                    gobj = ont.getGenericObject(str_role);
                } catch (Exception e) {
                    DetailViewManager.log.error("Error InlineEdit.userCanEdit()", e);
                    return Boolean.FALSE;
                }

                UserGroup ugrp = null;
                Role urole = null;

                if (gobj != null) {
                    if (gobj instanceof UserGroup) {
                        ugrp = (UserGroup) gobj;
                        if (user.hasUserGroup(ugrp)) {
                            access = true;
                        }
                    } else if (gobj instanceof Role) {
                        urole = (Role) gobj;
                        if (user.hasRole(urole)) {
                            access = true;
                        }
                    }
                } else {
                    access = false;
                }
            }
        }
        return access;
    }

    /**
     * Determina si la fecha actual pertenece al periodo de captura permitido
     * para el periodo indicado como argumento, de acuerdo a la
     * configuraci&oacute;n hecha en la instancia del recurso.
     *
     * @param period periodo a evaluar contra la fecha actual
     * @return un boleano que representa la validez de la fecha actual contra el
     * periodo de captura para el periodo indicado {@code true}, o {@code false}
     * de lo contrario.
     */
    private boolean isInMeasurementTime(final Period period) {
        Resource base = getResourceBase();
        int timeBefore = 0;
        int timeAfter = 0;
        int timeUnit = 0;
        try {
            timeBefore = Integer.parseInt(base.getAttribute("before", "7"));
        } catch (NumberFormatException e) {
            timeBefore = 0;
        }
        try {
            timeAfter = Integer.parseInt(base.getAttribute("after", "7"));
        } catch (NumberFormatException e) {
            timeAfter = 0;
        }

        try {
            timeUnit = Integer.parseInt(base.getAttribute("unitTime",
                    Integer.toString(Calendar.DATE)));
        } catch (NumberFormatException nfe) {
            timeUnit = Calendar.DATE;
        }

        GregorianCalendar current = new GregorianCalendar();
        Date end = period.getEnd();
        if (end == null) {
            return false;
        }
        GregorianCalendar startDate = new GregorianCalendar();
        startDate.setTime(end);
        startDate.add(timeUnit, -timeBefore);
        GregorianCalendar endDate = new GregorianCalendar();
        endDate.setTime(end);
        endDate.add(timeUnit, timeAfter);
        return current.compareTo(startDate) >= 0 && current.compareTo(endDate) <= 0;
    }

    /**
     * Eval&uacute;a si el {@code formElement} indicado es susceptible de
     * edici&oacute;n a fin de presentar la interface de edici&oacue;n en
     * l&iacute;nea.
     *
     * @param formElement el objeto de forma a presentar en la interface
     * @return {@literal true} si el {@code formElement} puede presentar
     * interface de edici&oacute;n, {@literal false} de lo contrario
     */
    private boolean isEditable(SemanticObject formElement) {
        return formElement.getProperty(TextAreaElement.bsc_editable) == null
                ? true : formElement.getBooleanProperty(TextAreaElement.bsc_editable);
    }

    /*
     * Revisa si el usuario en sesi&oacute;n pertenece al grupo de usuarios
     * recibido, devolviendo el resultado de esa revisi&oacute;n
     *
     * @param collaboration un grupo de usuarios, al que se desea saber si
     * pertenece el usuario en sesi&oacute;n
     * @return {@literal true} si el usuario en sesi&oacutee;n pertenece al
     * grupo indicado, {@literal false} de lo contrario
     */
//    private boolean userCanCollaborate(final UserGroup collaboration) {
//        final WebSite scorecard = (WebSite) getSemanticObject().getModel().getModelObject().createGenericInstance();
//        final User user = SWBContext.getSessionUser(scorecard.getUserRepository().getId());
//        return (collaboration != null && user != null) ? collaboration.hasUser(user) : false;
//    }
    /**
     * Obtiene el valor de las propiedades tipo fecha en la declaraci&oacute;n
     * de una variable de javascript. En caso de que la propiedad indicada no
     * sea de tipo fecha, devuelve una cadena vac&iacute;a.
     *
     * @param elementBSC objeto de tipo BSCElement del cual se obtiene la
     * propiedad
     * @param propUri propiedad de la que se intenta obtener el valor, si es de
     * tipo fecha
     * @return un {@literal String} que representa la declaración de una
     * variable en javascript con el valor de la propiedad indicada si
     * &eacute;sta es de tipo fecha, de lo contrario, se devuelve una cadena
     * vac&iacute;a
     */
    private String getDateValue(SemanticObject elementBSC, String propUri) {

        StringBuilder toReturn = new StringBuilder(128);
        SemanticProperty semProp = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(propUri);

        if (semProp.isDate() || semProp.isDateTime()) {
            Date dateValue = elementBSC.getDateProperty(semProp);
            if (dateValue == null) {
                dateValue = new Date();
            }

            //Codigo para obtener el displayElement
            Statement st = semProp.getRDFProperty().getProperty(
                    SWBPlatform.getSemanticMgr().getSchema().getRDFOntModel().getProperty(
                            "http://www.semanticwebbuilder.org/swb4/bsc#displayElement"));
            if (st != null) {
                //Se obtiene: SemanticProperty: displayElement de la propiedad en cuestion (prop)
                SemanticObject soDisplayElement = SemanticObject.createSemanticObject(st.getResource());
                if (soDisplayElement != null) {
                    SemanticObject formElement = soDisplayElement.getObjectProperty(
                            org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(
                                    "http://www.semanticwebbuilder.org/swb4/xforms/ontology#formElement"));
                    if (formElement != null) {
                        FormElement fe = (FormElement) formElement.createGenericInstance();
                        //Solo se consideran los form elements de tipo bsc.formelement.DateElement
                        if (fe instanceof DateElement && ((DateElement) fe).getDateId() != null) {
                            toReturn.append("    var date_");
                            toReturn.append(((DateElement) fe).getDateId());
                            toReturn.append(elementBSC.getId());
                            toReturn.append(" = new Date(");
                            toReturn.append(dateValue.getTime());
                            toReturn.append(");\n");
                        }
                    }
                }
            }
        }

        return toReturn.toString();
    }

    /**
     * Ejecutar&aacute; la exportaci&oacute;n a PDF del elemento actual.
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param response Proporciona funcionalidad especifica HTTP para
     * envi&oacute; en la respuesta
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @throws SWBResourceException SWBResourceException SWBResourceException
     * Excepti&oacute;n utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    public void doGetPDFDocument(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("application/pdf; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        String title = "Undefined";

        if (request.getParameter("suri") != null) {
            String suri = request.getParameter("suri");
            SemanticObject semObj = SemanticObject.getSemanticObject(suri);
            if (semObj != null) {
                GenericObject obj = semObj.createGenericInstance();

                if (obj != null && obj instanceof Descriptiveable) {
                    Descriptiveable descrip = (Descriptiveable) obj;
                    title = descrip.getTitle();
                }
            }
        }
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + title + ".pdf\"");
        StringBuilder sb = getStructureHtml(request, paramRequest);
        if (sb != null && sb.length() > 0) {
            OutputStream os = response.getOutputStream();
            try {
                ITextRenderer renderer = new ITextRenderer();
                String sbStr = replaceHtml(sb);
                renderer.setDocumentFromString(sbStr);
                renderer.layout();
                renderer.createPDF(os);
                renderer.finishPDF();
            } catch (DocumentException ex) {
                log.error("Error in: " + ex);
            } catch (Exception ex) {
                log.error("Check that your style sheet corresponding to the CSS 2.1 specification: "
                        + ex);
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) { /*ignore*/ }
                }
            }
            String uniqueImage = request.getParameter("uniqueImage");
            String path = org.semanticwb.SWBPortal.getWorkPath() + "/models/"
                    + paramRequest.getWebPage().getWebSiteId()
                    + "/ganttChart_" + uniqueImage + ".jpg";
            File fileChart = new File(path);
            if (fileChart.exists()) {
                fileChart.delete();
            }
            path = org.semanticwb.SWBPortal.getWorkPath() + "/models/"
                    + paramRequest.getWebPage().getWebSiteId()
                    + "/graphics_" + uniqueImage + ".jpg";
            fileChart = new File(path);
            if (fileChart.exists()) {
                fileChart.delete();
            }
        }
    }

    /**
     * Reemplaza c&oacute;digo HTML por acentos, esto es para la estructura XML
     * requerida.
     *
     * @param sb el objeto String al cu&aacute; ser&aacute; reemplazados los
     * car&aacutecteres.
     * @return el objeto String modificado
     */
    private String replaceHtml(StringBuilder sb) {
        String sbStr = SWBUtils.TEXT.replaceAll(sb.toString(), "&oacute;", "ó");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&aacute;", "á");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&eacute;", "é");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&iacute;", "í");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&oacute;", "ó");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&uacute;", "ú");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&Aacute;", "Á");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&Eacute;", "É");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&Iacute;", "Í");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&Oacute;", "Ó");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&Uacute;", "Ú");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&nbsp;", " ");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&lt;", "<");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&gt;", ">");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&amp;", "&");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&quot;", "\"");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&iexcl;", "¡");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&iquest;", "¿");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&reg;", "®");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&copy;", "©");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&euro;", "€");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&ntilde;", "ñ");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&uuml", "ü");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&Ntilde;", "Ñ");
        sbStr = SWBUtils.TEXT.replaceAll(sbStr, "&Uuml;", "Ü");
        return sbStr;
    }

    /**
     * Se encarga de obtener los links de la plantilla de la p&aacute;gina
     * actual
     *
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @return el objeto String que representa el c&oacute;digo HTML con los
     * links hacia los CSS respectivos.
     * @throws FileNotFoundException Archivo no ubicado
     * @throws IOException Excepti&oacute;n de IO
     */
    private String getLinks(SWBParamRequest paramRequest, HttpServletRequest request)
            throws FileNotFoundException, IOException {
        User user = paramRequest.getUser();
        WebPage wp = paramRequest.getWebPage();

        Template template = SWBPortal.getTemplateMgr().getTemplate(user, wp);
        String filePath = template.getWorkPath() + "/"
                + template.getActualVersion().getVersionNumber() + "/"
                + template.getFileName(template.getActualVersion().getVersionNumber());
        FileReader reader = null;
        StringBuilder view = new StringBuilder(256);
        reader = new FileReader(filePath);

        String port = "";
        if (request.getServerPort() != 80) {
            port = ":" + request.getServerPort();
        }
        String baserequest = request.getScheme() + "://" + request.getServerName()
                + port;

        HtmlStreamTokenizer tok = new HtmlStreamTokenizer(reader);
        HtmlTag tag = new HtmlTag();
        while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF) {
            int ttype = tok.getTokenType();

            if (ttype == HtmlStreamTokenizer.TT_TAG) {
                try {
                    tok.parseTag(tok.getStringValue(), tag);
                } catch (HtmlException htmle) {
                    DetailViewManager.log.error("Al parsear la plantilla , "
                            + filePath, htmle);
                }
                if (tag.getTagString().toLowerCase().equals("link")) {
                    String tagTxt = tag.toString();
                    if (tagTxt.contains("type=\"text/css\"")) {
                        if (!tagTxt.contains("/>")) {
                            tagTxt = SWBUtils.TEXT.replaceAll(tagTxt, ">", "/>");
                        }
                        if (!tagTxt.contains("{webpath}")) {
                            String tmpTxt = tagTxt.substring(0, (tagTxt.indexOf("href") + 6));
                            String tmpTxtAux = tagTxt.substring((tagTxt.indexOf("href") + 6),
                                    tagTxt.length());
                            tagTxt = tmpTxt + baserequest + tmpTxtAux;
                        } else {
                            tagTxt = SWBUtils.TEXT.replaceAll(tagTxt, "{webpath}", baserequest);
                        }
                        view.append(tagTxt);
                    }
                }
            }
        }
        return view.toString();
    }

    /**
     * Filtra los recursos de tipo ComponentExportable que ser&aacute;n
     * utilizados en la exportaci&oacute;n del PDF y obtiene su c&oacute;digo
     * HTML.
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @return el objeto String que representa el c&oacute;digo HTML con los
     * datos a exportar(Vista detalle y componentes adicionales)
     * @throws SWBResourceException SWBResourceException SWBResourceException
     * Excepti&oacute;n utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    private StringBuilder getStructureHtml(HttpServletRequest request,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        StringBuilder output = new StringBuilder();
        output.append("<html>");
        output.append("<head>");
        output.append(getLinks(paramRequest, request));
        output.append("</head>");
        output.append("<body>");
        output.append(getHtml(request, paramRequest));
        GenericIterator<Resource> it = paramRequest.getWebPage().listResources();
        TreeSet<ComponentExportable> ret = new TreeSet(new SWBPriorityComparator(true));

        while (it.hasNext()) {
            Resource resourceIt = it.next();
            SWBResource base = SWBPortal.getResourceMgr().getResource(resourceIt.getURI());
            try {
                ComponentExportable ce = (ComponentExportable) base;
                ret.add(ce);
            }catch (ClassCastException cce) {
            }catch (NullPointerException cce) {
            }
        }
        Iterator<ComponentExportable> itRes = ret.iterator();
        while (itRes.hasNext()) {
            ComponentExportable compExpor = itRes.next();
            output.append("<br/><br/><br/>");
            output.append(compExpor.doComponentExport(request, paramRequest));
            output.append("");
        }
        output.append("</body>");
        output.append("</html>");
        return output;
    }

    /**
     * Obtiene el HTML de los datos de la vista detalle que se utilizar&aacute;
     * en la exportaci&oacute;n.
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @return el objeto String que representa el c&oacute;digo HTML con los
     * datos de la vista detalle a exportar
     * @throws SWBResourceException SWBResourceException SWBResourceException
     * Excepti&oacute;n utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    private StringBuilder getHtml(HttpServletRequest request, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {
        StringBuilder output = new StringBuilder(256);
        String message = validateInput(request, paramRequest);
        output.append("<div id=\"detalle\" class=\"detalleObjetivo\">\n");

        if (message == null) {
            FileReader reader = retrieveTemplate();
            String suri = request.getParameter("suri");
            SemanticObject semObj = SemanticObject.getSemanticObject(suri);
            //Declarar variable para el per&iacte;odo, obteniendo el valor del request
            String modelName = paramRequest.getWebPage().getWebSiteId();
            String periodId = request.getSession().getAttribute(modelName) != null
                    ? (String) request.getSession().getAttribute(modelName)
                    : null;
            String statusStyleClass = "indefinido";
            String secondStatusStyleClass = null;
            //Si no hay sesión, la petición puede ser directa (una liga en un correo). Crear sesión y atributo:
            if (periodId == null) {
                periodId = request.getParameter(modelName) != null ? request.getParameter(modelName) : null;
                if (periodId != null) {
                    request.getSession(true).setAttribute(modelName, periodId);
                }
            }
            Period period = Period.ClassMgr.getPeriod(periodId, paramRequest.getWebPage().getWebSite());
//            PeriodStatus periodStatus = null;

//            UserGroup collaboration = null;
            GenericObject generic = semObj.createGenericInstance();
            Detailed d = (Detailed) generic;
            statusStyleClass = d.getStatusIconClass(period);

            //Si el semObj es hijo de PeriodStatusAssignable se debe:
//            GenericObject generic = semObj.createGenericInstance();
//            if (generic != null && generic instanceof Objective) {
//                Objective objective = (Objective) generic;
//                periodStatus = objective.getPeriodStatus(period);
//                statusStyleClass = periodStatus.getStatus().getIconClass();
//            } else if (generic != null && generic instanceof Indicator) {
//                Indicator indicator = (Indicator) generic;
//                Measure measure = indicator.getStar() != null
//                        ? indicator.getStar().getMeasure(period) : null;
//                if (measure != null && measure.getEvaluation() != null) {
//                    periodStatus = measure.getEvaluation();
//                    statusStyleClass = periodStatus.getStatus().getIconClass();
//                }
//            } else if (generic != null && generic instanceof Deliverable) {
//                Deliverable deliverable = (Deliverable) generic;
//                statusStyleClass = deliverable.getStatusAssigned() != null
//                        ? deliverable.getStatusAssigned().getIconClass() : "indefinido";
//                secondStatusStyleClass = deliverable.getAutoStatus() != null
//                        ? deliverable.getAutoStatus().getIconClass() : "indefinido";
//            }
            //-Agrega encabezado al cuerpo de la vista detalle, en el que se muestre el estado del objeto
            // para el per&iacte;odo especificado y el t&iacte;tulo del objeto, para lo que:
            //    - Se pide el listado de objetos PeriodStatus asociado al semObj
            //    - Se recorre uno por uno los PeriodStatus relacionados
            //    - Cuando el per&iacte;odo del PeriodStatus = per&iacte;odo del request:
            //        - Se obtiene el status correspondiente y su &iacte;cono relacionado
            //        - Se agrega el &iacte;cono al encabezado y el t&iacte;tulo del objeto semObj
            WebSite ws = paramRequest.getWebPage().getWebSite();
            String lang = paramRequest.getUser().getLanguage();
            String modelSite = ws.getTitle(lang) == null ? ws.getTitle() : ws.getTitle(lang);
            String titlePeriod = period.getTitle(lang) == null ? period.getTitle() : period.getTitle(lang);
            Date date = new Date();
            output.append("<div class=\"headerPDF\" style=\"width:40%;float:left;\">");
            output.append(modelSite);
            output.append("</div>");
            output.append("<div class=\"headerPDF\" style=\"width:30%;float:left;\">");
            output.append(titlePeriod);
            output.append("</div>");
            output.append("<div class=\"headerPDF\" style=\"width:30%;float:left;\">");
            output.append(paramRequest.getLocaleString("lblDateGeneration"));
            output.append(SWBUtils.TEXT.getStrDate(date, "es", "dd/mm/yyyy"));
            output.append("</div>");
            output.append("<br/>");
            output.append("<br/>");
            output.append("<h2");
            output.append(" class=\"");
            output.append(statusStyleClass);
            output.append("\">");
            if (secondStatusStyleClass != null) {
                output.append("<span class=\"");
                output.append(secondStatusStyleClass);
                output.append("\"> &nbsp; </span>");
            }
            output.append(semObj.getDisplayName());
            output.append("</h2>\n");

            if (reader != null) {
                output.append(generateDisplayPDF(request, paramRequest, reader, semObj));
            } else {
                output.append(paramRequest.getLocaleString("fileNotRead"));
            }
        } else { //Si la información de entrada no es válida
            output.append(paramRequest.getLocaleString(message));
        }

        output.append("</div>\n");
        return output;
    }

    /**
     * Interpreta el contenido de la plantilla de la vista detalle asignada como
     * contenido, sustituyendo los tags que representan las propiedades de los
     * objetos, por los despliegues de valores de esas propiedades. Utilizada en
     * la exportación a PDF
     *
     * @param request petici&oacute;n HTTP realizada por el cliente
     * @param paramRequest un objeto de la plataforma de SWB con datos
     * adicionales de la petici&oacute;n
     * @param template el contenido de la vista detalle asignada como contenido
     * @param elementBSC representa el objeto del cual se desea extraer la
     * informaci&oacute;n
     * @return un {@code String} que representa el contenido de la plantilla de
     * la vista detalle correspondiente con el despliegue de los valores de las
     * propiedades configuradas.
     * @throws IOException en caso de que se presente alg&uacute;n problema en
     * el parseo del contenido de la plantilla
     */
    private String generateDisplayPDF(HttpServletRequest request, SWBParamRequest paramRequest,
            FileReader template, SemanticObject elementBSC) throws IOException {
        StringBuilder view = new StringBuilder(512);
        HtmlStreamTokenizer tok = new HtmlStreamTokenizer(template);
        HtmlTag tag = new HtmlTag();
        String lang = paramRequest.getUser().getLanguage();
        SWBResourceURL url = paramRequest.getActionUrl();
        url.setAction("updateProp");
        url.setParameter("suri", request.getParameter("suri"));
        request.setAttribute("urlRequest", url.toString());

        while (tok.nextToken() != HtmlStreamTokenizer.TT_EOF) {
            int ttype = tok.getTokenType();
            if (ttype == HtmlStreamTokenizer.TT_TAG) {
                try {
                    tok.parseTag(tok.getStringValue(), tag);
                } catch (HtmlException htmle) {
                    DetailViewManager.log.error("Al parsear plantilla vista detalle, "
                            + this.getActiveDetailView().getId(), htmle);
                    view = new StringBuilder(16);
                }
                if (!tag.getTagString().toLowerCase().equals("img")) {
                    view.append(tag.toString());
                } else if (tag.getTagString().toLowerCase().equals("img") && !tag.hasParam("tagProp")) {
                    view.append(tag.toString());
                } else if (tag.getTagString().toLowerCase().equals("img") && tag.hasParam("tagProp")) {
                    String propUri = tag.getParam("tagProp");
                    if (propUri != null) {
                        view.append(renderPropertyValuePDF(request, elementBSC, propUri, lang));
                    }
                }
            } else if (ttype == HtmlStreamTokenizer.TT_TEXT) {
                view.append(tok.getStringValue());
            }
            view.append("\n");
        }
        return (view.toString());
    }

    /**
     * Devuelve el despliegue correspondiente al valor de la propiedad
     * especificada, del objeto indicado. La vista que requiere traerse debe ser
     * c&oacute;digo html sin javascript, por lo que se pide el despliegue de la
     * forma en su modo VIEW
     *
     * @param request petici&oacute;n HTTP realizada por el cliente
     * @param elementBSC representa el objeto del cual se desea extraer la
     * informaci&oacute;n
     * @param propUri representa la uri de la propiedad semantica de la que se
     * desea obtener su valor
     * @param lang representa el lenguaje en que se desea mostrar el valor de la
     * propiedad indicada
     * @return el despliegue del valor almacenado para la propiedad indicada
     */
    private String renderPropertyValuePDF(HttpServletRequest request, SemanticObject elementBSC,
            String propUri, String lang) {
        String ret = null;
        SWBFormMgr formMgr = new SWBFormMgr(elementBSC, null, SWBFormMgr.MODE_VIEW);
        SemanticProperty semProp = org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(propUri);

        //Codigo para obtener el displayElement
        Statement st = semProp.getRDFProperty().getProperty(
                SWBPlatform.getSemanticMgr().getSchema().getRDFOntModel().getProperty(
                        "http://www.semanticwebbuilder.org/swb4/bsc#displayElement"));
        if (st != null) {
            //Se obtiene: SemanticProperty: displayElement de la propiedad en cuestion (prop)
            SemanticObject soDisplayElement = SemanticObject.createSemanticObject(st.getResource());
            if (soDisplayElement != null) {
                SemanticObject formElement = soDisplayElement.getObjectProperty(
                        org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty(
                                "http://www.semanticwebbuilder.org/swb4/xforms/ontology#formElement"));
                if (formElement != null) {
                    FormElement fe = (FormElement) formElement.createGenericInstance();
                    if (fe != null) {
                        if (formMgr.getSemanticObject() != null) {
                            fe.setModel(formMgr.getSemanticObject().getModel());
                        }
                        request.setAttribute("pdf", "true");
                        ret = fe.renderElement(request, elementBSC, semProp, semProp.getName(),
                                SWBFormMgr.TYPE_XHTML,
                                SWBFormMgr.MODE_VIEW,
                                lang);
                    }
                }
            }
        }
        if (ret == null) {
            FormElement formElement = formMgr.getFormElement(semProp);
            if (formElement != null) {
                ret = formElement.renderElement(request, elementBSC, semProp, semProp.getName(),
                        SWBFormMgr.TYPE_XHTML, SWBFormMgr.MODE_VIEW, lang);
            }
        }
        return ret != null ? ret : "";
    }

    /**
     * Genera el icono para imprimir el PDF de la vista actual. Envia los
     * par&aacute;metros que se usaran para generar el PDF.
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @return el objeto String que representa el c&oacute;digo HTML con la liga
     * y el icono correspondiente al elemento a exportar.
     * @throws SWBResourceException SWBResourceException SWBResourceException
     * Excepti&oacute;n utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     */
    @Override
    public String doIconExportPDF(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String suri = request.getParameter("suri");

        SWBResourceURL url = new SWBResourceURLImp(request, getResource(), paramRequest.getWebPage(), SWBResourceURL.UrlType_RENDER);
        url.setMode(Mode_StreamPDF);
        url.setCallMethod(SWBResourceURL.Call_DIRECT);
        url.setParameter("suri", suri);

//        String title = paramRequest.getLocaleString("msgPrintPDFDocument");
        StringBuilder ret = new StringBuilder();
        ret.append("<script type=\"text/javascript\">").append("\n");
        ret.append(" function getFile() {").append("\n");
        ret.append("   var form = document.getElementById('frmDetail');").append("\n");
        ret.append("   var svg = document.getElementsByTagName('svg')[0];").append("\n");
        ret.append("   if(svg != null) {").append("\n");
        ret.append("     var svg_xml = (new XMLSerializer).serializeToString(svg);").append("\n");
        ret.append("     document.getElementById('image').value=svg_xml;").append("\n");
        ret.append("   }").append("\n");
        ret.append("   form.submit();").append("\n");
        ret.append(" };").append("\n");
        ret.append("</script>").append("\n");

//        ret.append("<a href=\"javascript:getFile();");
//        ret.append("\" class=\"swbstgy-toolbar-printPdf\" title=\"");
//        ret.append(title);
//        ret.append("\" >");
//        ret.append(title);
//        ret.append("</a>").append("\n");
        ret.append("<button type=\"button\" class=\"btn btn-default\" onclick=\"javascript:getFile()\"><span class=\"glyphicon glyphicon-export\"></span></button>");

        ret.append("<form id=\"frmDetail\" method=\"post\" accept-charset=\"utf-8\" action=\"");
        ret.append(url);
        ret.append("\" style=\"display:none\">").append("\n");
        ret.append("   <input type=\"hidden\" id=\"image\" name=\"image\"/>").append("\n");
        ret.append("   <input type=\"hidden\" id=\"uniqueImage\" name=\"uniqueImage\" value=\"");
        ret.append(UploaderFileCacheUtils.uniqueCad());
        ret.append("\"/>\n");
        ret.append("</form>").append("\n");

        return ret.toString();
    }

    /**
     * Eval&uacute;a si {@code object} es una instancia de alg&uacute;n
     * {@code BSCElement} que no requiere de mediciones en per&iacute;odos.
     *
     * @param object el objeto a evaluar
     * @return si el objeto es una instancia de alg&uacute;n {@code BSCElement}
     * al que no es necesario realizar mediciones peri&oacute;dicas, devuelve
     * {@literal true}, de lo contrario devuelve {
     * @false}
     */
    private boolean isNonMeasurableElement(SemanticObject object) {

        GenericObject generic = object.createGenericInstance();
        return (generic instanceof Initiative || generic instanceof Deliverable
                || generic instanceof Agreement || generic instanceof Risk);
    }
}
