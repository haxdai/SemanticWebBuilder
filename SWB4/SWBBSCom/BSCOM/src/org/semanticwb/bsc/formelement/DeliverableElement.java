package org.semanticwb.bsc.formelement;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.Deliverable;
import org.semanticwb.bsc.element.Initiative;
import org.semanticwb.model.FormElementURL;
import org.semanticwb.model.SWBModel;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.SWBFormMgr;

/**
 * Form Element que presentar&aacute; la vista para administrar entregables
 * (Liga para su edici&oacute;n y eliminaci&oacute;n)
 *
 * @author Martha Elvia Jim&eacute;nez Salgado
 * @version %I%, %G%
 * @since 1.0
 */
public class DeliverableElement extends org.semanticwb.bsc.formelement.base.DeliverableElementBase {

    /**
     * La constante Mode_VIEW.
     */
    private static final String Mode_VIEW = "view";
    /**
     * La constante Mode_RELOAD.
     */
    private static final String Mode_RELOAD = "reload";
    /**
     * La constante Action_REMOVE.
     */
    private static final String Action_REMOVE = "aDelete";

    /**
     * Crea instancias de esta clase a partir de un objeto sem&aacute;ntico
     *
     * @param base el objeto sem&aacute;ntico a utilizar para crear la nueva
     * instancia
     */
    public DeliverableElement(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    /**
     * Genera el c&oacute;digo HTML para representar la administraci&eacute;n de
     * los Entregables de los elementos del BSC.
     *
     * @param request la petici&oacute;n HTTP hecha por el cliente
     * @param obj el objeto a quien pertenece la propiedad asociada a este
     * FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param propName el nombre de la propiedad asociada a este FormElement
     * @param type el tipo de despliegue a generar. Actualmente solo se acepta
     * el valor {@code dojo}
     * @param mode el modo en que se presentar&aacute; el despliegue del
     * FormElement. Los modos soportados son: {@literal edit},
     * {@literal create}, {@literal filter} y {@literal view}
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @return el objeto String que representa el c&oacute;digo HTML con la
     * vista correspondiente al modo especificado para este elemento de forma.
     */
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        
        StringBuilder html = new StringBuilder();
        String modeTmp = request.getParameter("modeTmp");
        String downloadEle = request.getAttribute("downloadEle") != null
                ? request.getAttribute("downloadEle").toString() : null;
        if (modeTmp == null && mode.equals(SWBFormMgr.MODE_VIEW) && downloadEle == null) {
            html.append(renderModeView(request, obj, prop, propName, type, mode, lang));
        } else if (modeTmp == null || (modeTmp != null && Mode_VIEW.equals(modeTmp))) {
            html.append(renderElementView(request, obj, prop, propName, type, mode, lang));
        } else if (Mode_RELOAD.equals(modeTmp)) {
            html.append(renderElementReload(request, obj, prop, type));
        }
        return html.toString();
    }

    /**
     * Procesa la informaci&oacute;n enviada por el elemento de forma, para
     * almacenarla en la propiedad del objeto indicado.
     *
     * @param request la petici&oacute;n HTTP hecha por el cliente
     * @param obj el objeto a quien pertenece la propiedad asociada a este
     * FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param propName el nombre de la propiedad asociada a este FormElement
     */
    @Override
    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop,
            String propName) {
        String action = request.getParameter("_action");
        String usrWithGrants = request.getParameter("usrWithGrants");
        if (Action_REMOVE.equals(action)) {
            String suri = request.getParameter("suriDeliv");
            String sobj = request.getParameter("obj");
            SemanticObject semObj = SemanticObject.getSemanticObject(suri);
            SemanticObject semObjDeliv = SemanticObject.getSemanticObject(sobj);
            if (semObjDeliv.createGenericInstance() instanceof Initiative) {
                Initiative objectDeliv = (Initiative) semObjDeliv.createGenericInstance();
                Deliverable deliv = (Deliverable) semObj.createGenericInstance();
                objectDeliv.removeDeliverable(deliv);
                deliv.remove();
            }
            renderElementReload(request, obj, prop, FormElementURL.URLTYPE_RENDER);
        }
        getRenderURL(obj, prop, FormElementURL.URLTYPE_RENDER, null, "es").
                setParameter("usrWithGrants", usrWithGrants);
    }

    /**
     * Presenta la vista de los entregables asociados al elemento BSC,
     * aqu&iacute; se getiona los permisos para los usuarios
     *
     * @param request la petici&oacute;n HTTP hecha por el cliente
     * @param obj el objeto a quien pertenece la propiedad asociada a este
     * FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param propName el nombre de la propiedad asociada a este FormElement
     * @param type el tipo de despliegue a generar. Actualmente solo se acepta
     * el valor {@code dojo}
     * @param mode el modo en que se presentar&aacute; el despliegue del
     * FormElement. Los modos soportados son: {@literal edit},
     * {@literal create}, {@literal filter} y {@literal view}
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @return el objeto String que representa el c&oacute;digo HTML con la
     * vista correspondiente al modo especificado para este elemento de forma.
     */
    public String renderElementView(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        
        StringBuilder html = new StringBuilder();

        String usrWithGrants = (String) request.getAttribute("usrWithGrants") == null
                ? (String) request.getParameter("usrWithGrants")
                : (String) request.getAttribute("usrWithGrants");

        Initiative initiative;            
        if( obj.getGenericInstance() instanceof Initiative )
        {
            initiative = (Initiative)obj.getGenericInstance();

            FormElementURL urlFE = getRenderURL(obj, prop, type, mode, lang);
            urlFE.setParameter("modeTmp", Mode_RELOAD);
            urlFE.setParameter("suri", obj.getURI());
            urlFE.setParameter("usrWithGrants", usrWithGrants);

            html.append("\n<script type=\"text/javascript\">");
            html.append("\n  dojo.require(\"dijit.Dialog\");");
            html.append("\n  dojo.require(\"dijit.form.Button\");");
            html.append("\n  dojo.require(\"dojo.parser\");");
            html.append("\n  dojo.require(\"dojox.layout.ContentPane\");");

            html.append("\nfunction processUrlDeliv(url,id)");
            html.append("\n{");
            html.append("\n    dojo.xhrPost({");
            html.append("\n        url: url,");
            html.append("\n        load: function(response)");
            html.append("\n        {");
            html.append("\n             if(id != null && document.getElementById(id) != null){");
            html.append("\n               document.getElementById(id).innerHTML ");
            html.append("= response;");
            html.append("\n             } else {");
            html.append("\n               processUrlDeliv('");
            html.append(urlFE.setContentType("text/html; charset=UTF-8"));
            html.append("', 'swbDeliverable');");
            html.append("\n                 dijit.byId('swbDialog3').show();");
            html.append("\n             }");
            html.append("\n        },");
            html.append("\n        error: function(response)");
            html.append("\n        {");
            html.append("\n            return response;");
            html.append("\n        },");
            html.append("\n        handleAs: \"text\"");
            html.append("\n    });");
            html.append("\n}");
            html.append("\n</script>");

            html.append("\n<div dojoType=\"dijit.Dialog\" class=\"col-lg-2 col-lg-offset-5 co-md-8 col-sm-8 col-sm-offset-2 col-xs-12 swb-ventana-dialogo\" "); //soria
            html.append("id=\"swbDialog3\" title=\"");
            html.append(getLocaleString("successfulOperation", lang));
            html.append("");
            html.append("\" >\n");
            html.append("\n<div class=\"panelDialog panelDialog-default\">");
            html.append("\n<div class=\"swb-panel-cuerpo\">");
            html.append("  <div dojoType=\"dojox.layout.ContentPane\" class=\"soria\" ");
            html.append("id=\"swbDialogImp3\" executeScripts=\"true\">\n");
            html.append("          <p class=\"text-center bold\"><strong>");
            html.append(getLocaleString("successfulOperation", lang));
            html.append("</strong></p>\n");
            html.append("<div class=\"btn-group col-lg-2 col-lg-offset-3 col-md-12 \">");
            html.append("<button dojoType=\"dijit.form.Button\" class=\"swb-boton-enviar\" ");
            html.append("onclick=\"dijit.byId('swbDialog3').hide()\">");
            html.append(getLocaleString("success", lang));
            html.append("</button>");
            html.append("  </div>\n");

            html.append("  </div>\n");
            html.append("  </div>\n");
            html.append("  </div>\n");
            html.append("</div>\n");

            SWBModel scorecard = initiative.getBSC();
            final String scorecardId = scorecard.getId();
            final String periodId = (String)request.getSession(true).getAttribute(scorecardId);
            if( Period.ClassMgr.hasPeriod(periodId, scorecard) ) {
                Period period = Period.ClassMgr.getPeriod(periodId, scorecard);
                html.append("<div class=\"table-responsive\" id=\"swbDeliverable\">\n");
                html.append(renderDeliverables(initiative, obj, prop, type, period, usrWithGrants));
                html.append("</div>\n");
            }
        }
        return html.toString();
    }

    /**
     * Vista utilizada para recargar la vista despu&eacute;s de ejecutar la
     * acci&oacute;n, de eliminaci&oacute;n.
     *
     * @param request la petici&oacute;n HTTP hecha por el cliente
     * @param obj el objeto a quien pertenece la propiedad asociada a este
     * FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param propName el nombre de la propiedad asociada a este FormElement
     * @param type el tipo de despliegue a generar. Actualmente solo se acepta
     * el valor {@code dojo}
     * @param mode el modo en que se presentar&aacute; el despliegue del
     * FormElement. Los modos soportados son: {@literal edit},
     * {@literal create}, {@literal filter} y {@literal view}
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @return el objeto String que representa el c&oacute;digo HTML con la
     * vista correspondiente al modo especificado para este elemento de forma.
     */
    private String renderElementReload(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String type) {
        StringBuilder html = new StringBuilder();
        String usrWithGrants = (String) request.getAttribute("usrWithGrants") == null
                ? (String) request.getParameter("usrWithGrants")
                : (String) request.getAttribute("usrWithGrants");

        Initiative initiative= null;
        if(obj.getGenericInstance() instanceof Initiative) {
            initiative = (Initiative)obj.getGenericInstance();

            final BSC scorecard = initiative.getBSC();
            final String scorecardId = scorecard.getId();
            final String periodId = (String)request.getSession(true).getAttribute(scorecardId);
            if(Period.ClassMgr.hasPeriod(periodId, scorecard)) {
                Period period = Period.ClassMgr.getPeriod(periodId, scorecard);
                html.append(renderDeliverables(initiative, obj, prop, type, period, usrWithGrants));
            }
        }
        return html.toString();
    }

    /**
     * Lista en HTML los entregables.
     *
     * @param itDeliverables el iterador con los entregables
     * @param suri el objeto que contiene el formElement
     * @param obj el objeto a quien pertenece la propiedad asociada a este
     * FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @param usrWithGrants define si existen permisos para editar o eliminar
     * los archivos adjuntos.
     * @return el objeto String que representa el c&oacute;digo HTML con el
     * conjunto de entregables.
     */
    private String renderDeliverables(Initiative initiative,
            SemanticObject obj, SemanticProperty prop, String lang, final Period period, final String usrWithGrants) {
        
        StringBuilder html = new StringBuilder();        
        List<Deliverable> deliverableLst = initiative.listValidDeliverables();
        Collections.sort(deliverableLst, new SortDeliverablesByPlannedDate());
        Iterator<Deliverable> deliverables = deliverableLst.iterator();
        if(deliverables.hasNext()) {
            Locale locale = new Locale(lang);
            html.append("<div class=\"table-responsive\">\n");
            html.append(" <table class=\"table table-hover table-condensed\">\n");
            html.append("  <thead>\n");
            html.append("   <tr>\n");
            html.append("    <th>").append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblProgress",locale)).append("</th>\n");
            html.append("    <th>").append(Deliverable.swb_title.getDisplayName(lang)).append("</th>\n");
            html.append("    <th>").append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblDatePlan",locale)).append("</th>\n");
html.append("    <th>").append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblDateActual",locale)).append("</th>\n");
            html.append("    <th>").append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblAxn",locale)).append("</th>\n");
            html.append("   </tr>\n");
            html.append("  </thead>").append("\n");
            html.append("  <tbody>\n");
            
            Deliverable deliverable;
            FormElementURL urlRemove;
            while(deliverables.hasNext())
            {
                deliverable = deliverables.next();
                html.append("<tr>\n");
                urlRemove = getProcessURL(obj, prop);
                //urlRemove.setParameter("action", Action_REMOVE);
                urlRemove.setParameter("suriDeliv", deliverable.getURI());
                urlRemove.setParameter("obj", obj.getURI());
                urlRemove.setParameter("usrWithGrants", usrWithGrants);
                html.append(" <td>\n");
                html.append("  <span title=\"").append(deliverable.getStatusTitle(period)).append("\" class=\"");
                html.append(deliverable.getStatusIconClass(period));
                html.append(" swbstrgy-semaphore\"></span>\n");
                html.append(" </td>\n");
                html.append(" <td>\n");
                html.append("  <a class=\"swb-url-lista detalle-archivos\" ");
                html.append(" title=\"");
                html.append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblProgress",locale));
                html.append("\" ");
                html.append("href=\"Deliverable?suri=");
                html.append(deliverable.getEncodedURI());
                html.append("\">\n");
                html.append(deliverable.getDisplayTitle(lang));
                html.append("  </a>\n");
                html.append(" </td>\n");
                html.append(" <td>\n");
                html.append(deliverable.getPlannedStart() == null ? ""
                        : SWBUtils.TEXT.getStrDate(deliverable.getPlannedStart(), "es", "dd/mm/yyyy"));
                html.append(" - ");
                html.append(deliverable.getPlannedEnd() == null ? ""
                        : SWBUtils.TEXT.getStrDate(deliverable.getPlannedEnd(), "es", "dd/mm/yyyy"));
                html.append(" </td>\n");
html.append(" <td>\n");
html.append(deliverable.getActualStart() == null ? ""
        : SWBUtils.TEXT.getStrDate(deliverable.getActualStart(), "es", "dd/mm/yyyy"));
html.append(" - ");
html.append(deliverable.getActualEnd() == null ? ""
        : SWBUtils.TEXT.getStrDate(deliverable.getActualEnd(), "es", "dd/mm/yyyy"));
html.append(" </td>\n");
                if ("true".equals(usrWithGrants)) {
                    html.append(" <td class=\"swb-td-accion\">\n");
                    html.append("  <a href=\"#\" title=\"");
                    html.append(SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblAxnDelete",locale));
                    html.append("\" onclick=\"if(confirm(\'");
                    html.append("¿");
                    html.append(getLocaleString("alertDeleteElement", lang));
                    html.append(" \\'");
                    html.append(deliverable.getTitle());
                    html.append("\\' ?\')){ ");
                    html.append("processUrlDeliv('");
                    html.append(urlRemove);
                    html.append("', 'null'); ");
                    html.append("} else { return false;}");
                    html.append("\">\n");
                    html.append("   <span class=\"glyphicon glyphicon-trash\"></span>\n");
                    html.append("  </a>\n");
                    html.append(" </td>\n");
                }
                html.append("</tr>\n");
            }
            html.append("  </tbody>\n");
            html.append(" </table>\n");
            html.append("</div>\n");
        }
        return html.toString();
    }

    /**
     * Presenta la vista de los entregables asociados al elemento BSC,
     * aqu&iacute; se getiona los permisos para los usuarios
     *
     * @param request la petici&oacute;n HTTP hecha por el cliente
     * @param obj el objeto a quien pertenece la propiedad asociada a este
     * FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param propName el nombre de la propiedad asociada a este FormElement
     * @param type el tipo de despliegue a generar. Actualmente solo se acepta
     * el valor {@code dojo}
     * @param mode el modo en que se presentar&aacute; el despliegue del
     * FormElement. Los modos soportados son: {@literal edit},
     * {@literal create}, {@literal filter} y {@literal view}
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @return el objeto String que representa el c&oacute;digo HTML con la
     * vista correspondiente al modo especificado para este elemento de forma.
     */
    public String renderModeView(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        
        StringBuilder html = new StringBuilder();
        Initiative initiative;
        if(obj.getGenericInstance() instanceof Initiative) {
            initiative = (Initiative) obj.getGenericInstance();
            List<Deliverable> deliverableLst = initiative.listValidDeliverables();
            Collections.sort(deliverableLst, new SortDeliverablesByPlannedDate());
            Iterator<Deliverable> deliverables = deliverableLst.iterator();
            if(deliverables.hasNext()) {
                html.append("<div class=\"table-responsive\">").append("\n");
                html.append("<table class=\"table table-striped table-condensed table-bordered\">").append("\n");
                html.append(" <thead>");
                html.append("  <tr>");
                html.append("   <th>").append(Deliverable.swb_title.getLabel(lang)).append("</th>");
                html.append("   <th>").append(Deliverable.bsc_plannedStart.getLabel(lang)).append("</th>");
                html.append("  </tr>");
                html.append(" </thead>").append("\n");
                html.append(" <tbody>");
                while (deliverables.hasNext()) {
                    Deliverable deliverable = deliverables.next();
                    html.append("  <tr>").append("\n");
                    html.append("   <td scope=\"row\">");
                    html.append(deliverable.getDisplayTitle(lang));
                    html.append("</td>").append("\n");
                    html.append("   <td>");
                    html.append(deliverable.getPlannedStart() == null
                            ? SWBUtils.TEXT.getStrDate(deliverable.getCreated(), lang, "dd/mm/yyyy")
                            : SWBUtils.TEXT.getStrDate(deliverable.getPlannedStart(), lang, "dd/mm/yyyy"));
                    html.append("</td>").append("\n");
                    html.append("  </tr>").append("\n");
                }
                html.append(" </tbody>").append("\n");
                html.append("</table>");
                html.append("</div>");
            }
        }
        return html.toString();
    }
}

class SortDeliverablesByPlannedDate implements Comparator<Deliverable>
{
    @Override
    public int compare(Deliverable o1, Deliverable o2)
    {
        if(o1.getPlannedStart()==null) {
            return -1;
        }
        if(o2.getPlannedStart()==null) {
            return 1;
        }
        return o1.getPlannedStart().compareTo(o2.getPlannedStart());
    }

}
