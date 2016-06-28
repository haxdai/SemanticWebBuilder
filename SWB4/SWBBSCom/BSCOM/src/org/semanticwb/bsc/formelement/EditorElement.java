package org.semanticwb.bsc.formelement;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.Updateable;
import org.semanticwb.bsc.catalogs.Analysis;
import org.semanticwb.bsc.catalogs.Recommendation;
import org.semanticwb.model.FormElement;
import org.semanticwb.model.FormElementURL;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticProperty;
import org.semanticwb.portal.SWBFormMgr;

/**
 * FormElement que permite agregar, editar, eliminar y/o listar un conjunto de
 * elementos. El elemento administrado contiene un editor rico en texto.
 *
 * @author martha.jimenez
 */
public class EditorElement extends org.semanticwb.bsc.formelement.base.EditorElementBase {

    /**
     * Realiza operaciones de registro de eventos en bit&cora
     */
    private static final Logger log = SWBUtils.getLogger(Ordinal.class);
    /**
     * La constante Mode_VIEW.
     */
    private static final String Mode_VIEW = "view";
    /**
     * La constante Mode_EDIT_RECOMMENDATION.
     */
    private static final String Mode_EDIT_RECOMMENDATION = "editRecommendations";
    /**
     * La constante Mode_EDIT_ANALYSIS.
     */
    private static final String Mode_EDIT_ANALYSIS = "editAnalysis";
    /**
     * La constante Mode_ADD_ANALYSIS.
     */
    private static final String Mode_ADD_ANALYSIS = "addAnalysis";
    /**
     * La constante Mode_ADD_RECOMMENDATION.
     */
    private static final String Mode_ADD_RECOMMENDATION = "addRecommendations";
    /**
     * La constante Mode_RELOAD_ANALYSIS.
     */
    private static final String Mode_RELOAD_ANALYSIS = "reloadAnalysis";
    /**
     * La constante Mode_RELOAD_ANALYSIS.
     */
    private static final String Mode_RELOAD_RECOMMENDATION = "reloadRecommendations";
    /**
     * La constante Action_ADD_ANALYSIS.
     */
    private static final String Action_ADD_ANALYSIS = "aAddAnalysis";
    /**
     * La constante Action_ADD_RECOMMENDATION.
     */
    private static final String Action_ADD_RECOMMENDATION = "aAddRecommendations";
    /**
     * La constante Action_EDIT.
     */
    private static final String Action_EDIT = "aEdit";
    /**
     * La constante Action_REMOVE.
     */
    private static final String Action_REMOVE = "aDelete";
    /**
     * La constante Mode_INLINE.
     */
    private static final String Mode_INLINE = "inlineEdit";

    public EditorElement(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String type, String mode, String lang) {
        return super.renderElement(request, obj, prop, type, mode, lang); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Genera el c&oacute;digo HTML para representar el valor almacenado en la
     * interface del usuario
     *
     * @param request la petici&oacute;n HTTP generada por el cliente
     * @param obj el objeto al que pertenece la propiedad del valor de
     * inter&eacute;s
     * @param prop la propiedad del valor de inter&eacute;s a representar en la
     * interface
     * @param propName el nombre de la propiedad del valor de inter&eacute;s a
     * representar en la interface
     * @param type el tipo de representacio&acute;n utilizado en la interface
     * (dojo, XHTML)
     * @param mode el modo en que se desea la representaci&oacute;n del valor
     * ({@literal create}, {@literal edit}, {@literal view} o
     * {@literal inlineEdit})
     * @param lang el lenguaje utilizado en la representaci&oacute;n del valor
     * @return un {@code String} que representa el valor de la propiedad
     * especificada considerando el tipo y modo indicados
     */
    @Override
    public String renderElement(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        StringBuilder toReturn = new StringBuilder();
        String modeTmp = request.getParameter("modeTmp");
        String downloadEle = request.getAttribute("downloadEle") != null
                ? request.getAttribute("downloadEle").toString() : null;

        if (modeTmp == null && mode.equals(SWBFormMgr.MODE_VIEW) && downloadEle == null) {
            toReturn.append(renderModeView(request, obj, prop, propName, type, mode, lang));
        } else if ((modeTmp == null) || (modeTmp != null && Mode_VIEW.equals(modeTmp))) {
            toReturn.append(renderElementView(request, obj, prop, propName, type, mode, lang));
        } else if (Mode_ADD_ANALYSIS.equals(modeTmp)) {
            toReturn.append(renderElementAddAnalysis(request, obj, prop, propName, type, mode, lang));
        } else if (Mode_EDIT_ANALYSIS.equals(modeTmp)) {
            toReturn.append(renderElementEditAnalysis(request, obj, prop, propName, type, mode, lang));
        } else if (Mode_RELOAD_ANALYSIS.equals(modeTmp)) {
            toReturn.append(renderElementReload(request, obj, prop, type, mode, lang, true));
        } else if (Mode_ADD_RECOMMENDATION.equals(modeTmp)) {
            toReturn.append(renderElementAddRecommendation(request, obj, prop, propName, type, mode, lang));
        } else if (Mode_EDIT_RECOMMENDATION.equals(modeTmp)) {
            toReturn.append(renderElementEditRecommendation(request, obj, prop, propName, type, mode, lang));
        } else if (Mode_RELOAD_RECOMMENDATION.equals(modeTmp)) {
            toReturn.append(renderElementReload(request, obj, prop, type, mode, lang, false));
        }
        return toReturn.toString();

    }

    /**
     * Presenta un listado de elementos que utilizan un editor rico en texto,
     * tiene la funcionalidad para poder agregar, editar o eliminar un elemento.
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
        StringBuilder toReturn = new StringBuilder();
        String suri = (String) request.getParameter("suri");
        String usrWithGrants = (String) request.getAttribute("usrWithGrants") == null
                ? (String) request.getParameter("usrWithGrants")
                : (String) request.getAttribute("usrWithGrants");
        if (suri != null) {
            if (obj.getGenericInstance() instanceof Updateable) {

                Updateable element = (Updateable) obj.getGenericInstance();
                FormElementURL urlAddFE = getRenderURL(obj, prop, type, mode, lang);
                urlAddFE.setParameter("usrWithGrants", usrWithGrants);
                urlAddFE.setParameter("suri", suri);

                FormElementURL urlFE = getRenderURL(obj, prop, type, mode, lang);
                urlFE.setParameter("suri", suri);
                urlFE.setParameter("usrWithGrants", usrWithGrants);

                String valueStr = null;
                String nomClass = null;
                Iterator<Analysis> itAnalysis = null;
                Iterator<Recommendation> itRecommendations = null;
                int pc_a = 0, pc_r = 0;

                if (prop.getURI().equals(Updateable.bsc_hasAnalysis.getURI())) {
                    valueStr = Analysis.sclass.getClassCodeName();
                    nomClass = Analysis.sclass.getDisplayName(lang);
                    urlAddFE.setParameter("modeTmp", Mode_ADD_ANALYSIS);
                    urlFE.setParameter("modeTmp", Mode_RELOAD_ANALYSIS);
                    List litAna = SWBUtils.Collections.copyIterator(element.listAnalysises());
                    itAnalysis = litAna.iterator();
                    int pageCurrent = 1;
                    pc_a = pageCurrent * 3;
                    if (litAna.size() > pc_a) {
                        pageCurrent++;
                    }
                    request.getSession(true).setAttribute("pc_a", pageCurrent);
                } else if (prop.getURI().equals(Updateable.bsc_hasRecommendation.getURI())) {
                    valueStr = Recommendation.sclass.getClassCodeName();
                    nomClass = Recommendation.sclass.getDisplayName(lang);
                    urlAddFE.setParameter("modeTmp", Mode_ADD_RECOMMENDATION);
                    urlFE.setParameter("modeTmp", Mode_RELOAD_RECOMMENDATION);
                    List litRec = SWBUtils.Collections.copyIterator(element.listRecommendations());
                    itRecommendations = litRec.iterator();
                    int pageCurrent = 1;
                    pc_r = pageCurrent * 3;
                    if (litRec.size() > pc_r) {
                        pageCurrent++;
                    }
                    request.getSession(true).setAttribute("pc_r", pageCurrent);
                }

                toReturn.append("\n<script type=\"text/javascript\">");
                toReturn.append("\n  dojo.require(\"dijit.Dialog\");");
                toReturn.append("\n  dojo.require(\"dijit.form.Button\");");
                toReturn.append("\n  dojo.require(\"dojo.parser\");");
                toReturn.append("\n  dojo.require(\"dojox.layout.ContentPane\");");

                if (prop.getURI().equals(Updateable.bsc_hasAnalysis.getURI())) {
                    toReturn.append(getScript(urlFE, true, lang));
                    toReturn.append("\nfunction processUrlAnalysis(url,id)");
                    toReturn.append("\n{");
                    toReturn.append("\n    dojo.xhrPost({");
                    toReturn.append("\n        url: url,");
                    toReturn.append("\n        load: function(response)");
                    toReturn.append("\n        {");
                    toReturn.append("\n             if(id != null){");
                    toReturn.append("\n               document.getElementById(id).innerHTML ");
                    toReturn.append("= response;");
                    toReturn.append("\n             } else {");
                    toReturn.append("\n               processUrlAnalysis('");
                    toReturn.append(urlFE.setContentType("text/html; charset=UTF-8"));
                    toReturn.append("', 'swbform");
                    toReturn.append(valueStr);
                    toReturn.append("');");
                    toReturn.append("\n             }");
                    toReturn.append("\n        },");
                    toReturn.append("\n        error: function(response)");
                    toReturn.append("\n        {");
                    toReturn.append("\n            return response;");
                    toReturn.append("\n        },");
                    toReturn.append("\n        handleAs: \"text\"");
                    toReturn.append("\n    });");
                    toReturn.append("\n}");
                } else if (prop.getURI().equals(Updateable.bsc_hasRecommendation.getURI())) {
                    toReturn.append(getScript(urlFE, false, lang));
                    toReturn.append("\nfunction processUrlRecommendation(url,id)");
                    toReturn.append("\n{");
                    toReturn.append("\n    dojo.xhrPost({");
                    toReturn.append("\n        url: url,");
                    toReturn.append("\n        load: function(response)");
                    toReturn.append("\n        {");
                    toReturn.append("\n             if(id != null){");
                    toReturn.append("\n               document.getElementById(id).innerHTML ");
                    toReturn.append("= response;");
                    toReturn.append("\n             } else {");
                    toReturn.append("\n               processUrlRecommendation('");
                    toReturn.append(urlFE.setContentType("text/html; charset=UTF-8"));
                    toReturn.append("', 'swbform");
                    toReturn.append(valueStr);
                    toReturn.append("');");
                    toReturn.append("\n             }");
                    toReturn.append("\n        },");
                    toReturn.append("\n        error: function(response)");
                    toReturn.append("\n        {");
                    toReturn.append("\n            return response;");
                    toReturn.append("\n        },");
                    toReturn.append("\n        handleAs: \"text\"");
                    toReturn.append("\n    });");
                    toReturn.append("\n}");
                }

                toReturn.append("\n    function validateDataFrmData(isValid) {");
                toReturn.append("\n        if(document.getElementById('Recommendation_recommendations') != undefined && isValid === 'recommendation' && document.getElementById('Recommendation_recommendations').value === '' ){");
                toReturn.append("\n         alert('");
                toReturn.append(getLocaleString("lb_required_recommendation", lang));
                toReturn.append("');");
                toReturn.append("\n        return false;}");
                toReturn.append("\n        if(document.getElementById('Analysis_analysis') != undefined && isValid === 'analysis' && document.getElementById('Analysis_analysis').value === '') {");
                toReturn.append("\n         alert('");
                toReturn.append(getLocaleString("lb_required_analysis", lang));
                toReturn.append("');");
                toReturn.append("\n        return false;}");
                toReturn.append("\n        return true;");
                toReturn.append("\n    }");

                toReturn.append("\n    function showDialog"
                        + valueStr
                        + "(url, title) {");
                toReturn.append("\n         dojo.xhrGet({");
                toReturn.append("\n             url: url,");
                toReturn.append("\n             load: function(response, ioArgs) {");
                toReturn.append("\n                  dijit.byId('swbDialogImp"
                        + valueStr
                        + "').attr('content', response);");
                toReturn.append("\n                  dijit.byId('swbDialog"
                        + valueStr
                        + "').show();");
                toReturn.append("\n                  setDialogTitle(title);");
                toReturn.append("\n                  return response;");
                toReturn.append("\n             },");
                toReturn.append("\n             error: function(response, ioArgs) {");
                toReturn.append("\n                 showStatus('Error:' + response);");
                toReturn.append("\n                 return response;");
                toReturn.append("\n             },");
                toReturn.append("\n             handleAs: \"text\"");
                toReturn.append("\n         });");
                toReturn.append("\n    }");

                toReturn.append("\n</script>");
                toReturn.append("\n<style type=\"text/css\">");
                toReturn.append("\n  .clsDialog .dijitToolbar span .dijitButtonNode{padding: 0px !important;}");
                toReturn.append("\n</style>");

                toReturn.append("\n<div dojoType=\"dijit.Dialog\" class=\"clsDialog col-lg-12 co-md-12 col-sm-12 col-xs-12 swb-ventana-dialogo \" ");//class=\"soria\"
                toReturn.append("id=\"swbDialog");
                toReturn.append(valueStr);
                toReturn.append("\" title=\"Agregar\" >\n");
                toReturn.append("\n<div class=\"panelDialog panelDialog-default\">");
                toReturn.append("\n<div class=\"swb-panel-cuerpo\">");
                toReturn.append("  <div dojoType=\"dojox.layout.ContentPane\" class=\"soria\" ");
                toReturn.append("id=\"swbDialogImp");
                toReturn.append(valueStr);
                toReturn.append("\" executeScripts=\"true\">\n");
                toReturn.append("    Cargando...\n");
                toReturn.append("  </div>\n");
                toReturn.append("  </div>\n");
                toReturn.append("  </div>\n");
                toReturn.append("</div>\n");

                if ("true".equals(usrWithGrants)) {
                    toReturn.append("<a href=\"#\" id=\"link");
                    toReturn.append(valueStr);
                    toReturn.append("\" class=\"swb-url-lista detalle-archivos\" onclick=\"showDialog");
                    toReturn.append(valueStr);
                    toReturn.append("('");
                    toReturn.append(urlAddFE.setContentType("text/html; charset=UTF-8"));
                    toReturn.append("', '");
                    toReturn.append(nomClass);
                    toReturn.append("');\">");
                    toReturn.append(getLocaleString("add", lang));
                    toReturn.append(" ");
                    toReturn.append(nomClass);
                    toReturn.append("\n</a>");
                }
                toReturn.append("<br/>");
                toReturn.append("\n<div class=\"table-responsive\" id=\"swbform");
                toReturn.append(valueStr);
                toReturn.append("\">");
                if (itAnalysis != null && itAnalysis.hasNext()) {
                    toReturn.append(listAnalysis(itAnalysis, suri, obj, prop, type,
                            mode, lang, usrWithGrants, valueStr, pc_a));
                }
                if (itRecommendations != null && itRecommendations.hasNext()) {
                    toReturn.append(listRecommendations(itRecommendations, suri, obj, prop, type,
                            mode, lang, usrWithGrants, valueStr, pc_r));
                }
                toReturn.append("\n</div>");

            }
        }
        return toReturn.toString();
    }

    /**
     * Presenta un script el cual esta definido por el tipo de propiedad a
     * presentar. Actualmente se consideran sólo dos tipos de propiedad
     * 'An&aacute;lisis' y Recomendaciones.
     *
     * @param urlFE FormElement que representa la propiedad
     * @param name Boolean que representa un valor true para la propiedad
     * 'An&aacute;lisis' y un valor false para la propiedad
     * 'Recomendaci&oacute;n'
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @return Script personalizado para la propiedad 'An&aacute;lisis' o
     * 'Recomendaci&oacute;n'
     */
    private String getScript(FormElementURL urlFE, boolean name, String lang) {
        StringBuilder toReturn = new StringBuilder();
        String valueStr;
        if (name) {
            toReturn.append("\n  function submitFormA(formid, isValid){");
            valueStr = Analysis.sclass.getClassCodeName();
        } else {
            toReturn.append("\n  function submitFormR(formid, isValid){");
            valueStr = Recommendation.sclass.getClassCodeName();
        }
        toReturn.append("\n     var obj = dojo.byId(formid);");
        toReturn.append("\n     var objd = dijit.byId(formid);");
        toReturn.append("\n     var fid = formid;");
        toReturn.append("\n     if (!obj && objd) {");
        toReturn.append("\n         obj = objd.domNode;");
        toReturn.append("\n         fid = obj;");
        toReturn.append("\n      }");
        toReturn.append("\n      if (!objd || objd.isValid()) {");
        toReturn.append("\n         try { ");
        toReturn.append("\n             dojo.fx.wipeOut({node: formid, duration: 500})");
        toReturn.append(".play();");
        toReturn.append("\n         } catch (noe) {}");
        toReturn.append("\n         try {");
        toReturn.append("\n             var framesNames = \"\";");
        toReturn.append("\n             for (var i = 0; i < window.frames.length; i++) {");
        toReturn.append("\n                 try { ");
        toReturn.append("\n                     framesNames += window.frames[i].name;");
        toReturn.append("\n                     if (framesNames && framesNames.");
        toReturn.append("indexOf(\"_editArea\") != -1) {");
        toReturn.append("\n                         area = window.frames[framesNames].");
        toReturn.append("editArea;");
        toReturn.append("\n                         id = framesNames.substr(6);");
        toReturn.append("\n                         document.getElementById(id).value = ");
        toReturn.append("area.textarea.value;");
        toReturn.append("\n                     }");
        toReturn.append("\n                 }catch(e){}");
        toReturn.append("\n             }");
        toReturn.append("\n         } catch (ex) {}");

        toReturn.append("\n         dojo.xhrPost({");
        toReturn.append("\n            contentType: \"application/x-www-form-urlencoded; ");
        toReturn.append("charset=utf-8\",");
        toReturn.append("\n             url: obj.action,");
        toReturn.append("\n             form: fid,");
        toReturn.append("\n             load: function(data) {");
        toReturn.append("\n                  var panel = getContentPanel(obj);");
        toReturn.append("\n                  if (panel) {");
        toReturn.append("\n                    try {");
        toReturn.append("\n                     var aux = panel.href;");
        toReturn.append("\n                     panel.attr('content', data);");
        toReturn.append("\n                     panel.href = aux;");
        toReturn.append("\n                     if (!panel.suportScripts)");
        toReturn.append("\n                         runScripts(data);");
        toReturn.append("\n                     } catch (e) {alert(e.message);}");
        toReturn.append("\n                 }");
        if (name) {
            toReturn.append("\n                 if(dijit.byId('swbDialogAnalysis') != undefined && isValid === 'analysis') {");
            toReturn.append("\n                     dijit.byId('swbDialogAnalysis').hide();");
            toReturn.append("\n                     processUrlAnalysis('");
            toReturn.append(urlFE.setContentType("text/html; charset=UTF-8"));
            toReturn.append("', 'swbform");
            toReturn.append(valueStr);
            toReturn.append("');");
//            toReturn.append("\n                     dijit.byId('swbDialog2Analysis').show();");
            toReturn.append("\n                 }");
        } else {
            toReturn.append("\n                 if(dijit.byId('swbDialogRecommendation') != undefined && isValid === 'recommendation') {");
            toReturn.append("\n                     dijit.byId('swbDialogRecommendation').hide();");
            toReturn.append("\n                     processUrlRecommendation('");
            toReturn.append(urlFE.setContentType("text/html; charset=UTF-8"));
            toReturn.append("', 'swbform");
            toReturn.append(valueStr);
            toReturn.append("');");
//            toReturn.append("\n                      dijit.byId('swbDialog2Recommendation').show();");
            toReturn.append("\n                 }");
        }
        toReturn.append("\n             },");
        toReturn.append("\n             error: function(error) {");
        toReturn.append("\n                 alert('Error: ', error);");
        toReturn.append("\n             }");
        toReturn.append("\n         });");
        toReturn.append("\n     } else {");
        toReturn.append("\n         alert(\"");
        toReturn.append(getLocaleString("invalidData", lang));
        toReturn.append("\");");
        toReturn.append("\n     }");
        toReturn.append("\n  }");
        return toReturn.toString();
    }

    /**
     * Genera el c&oacute;digo HTML para representar la vista para agregar un
     * nuevo an&aacute;lisis
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
    public String renderElementAddAnalysis(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        StringBuilder toReturn = new StringBuilder();
        SWBFormMgr formMgr = new SWBFormMgr(Analysis.bsc_Analysis,
                obj, null);
        formMgr.clearProperties();
        formMgr.addProperty(Analysis.bsc_analysis);
        formMgr.setType(SWBFormMgr.TYPE_DOJO);
        formMgr.setSubmitByAjax(true);
        formMgr.setMode(SWBFormMgr.MODE_CREATE);//

        String url = getProcessURL(obj, prop).setParameter("_action", Action_ADD_ANALYSIS).setParameter("suri", request.getParameter("suri")).toString();
        formMgr.setAction(url);
        toReturn.append("<div id=\"frmAdd\" >");

        SemanticObject semObj = new SemanticObject(obj.getModel(), Analysis.bsc_Analysis);
        String onsubmit = " onsubmit=\"if(validateDataFrmData('analysis')) {submitFormA(this.id, 'analysis');return false;} else {return false;}\"";//
        toReturn.append("<form id=\"");
        toReturn.append(formMgr.getFormName());
        toReturn.append("\" class=\"form-horizontal\" action=\"");
        toReturn.append(url);
        toReturn.append("\"");
        toReturn.append(onsubmit);
        toReturn.append(" method=\"post\" dojoType=\"dijit.form.Form\">\n");
        toReturn.append(formMgr.getFormHiddens());

        Iterator<SemanticProperty> it = SWBComparator.sortSortableObject(formMgr.
                getProperties().iterator());
        FormElement smTmp = null;
        while (it.hasNext()) {
            SemanticProperty prop1 = it.next();

            toReturn.append("<div class=\"form-group\">");
            toReturn.append("<div class=\"col-lg-12\">");
            smTmp = formMgr.getFormElement(prop1);
            toReturn.append(
                    smTmp.renderElement(
                            request, semObj, prop1,
                            prop1.getName(), "XHTML", Mode_INLINE, lang));
            toReturn.append("</div>");
            toReturn.append("</div>");
        }
        String objectId = Analysis.sclass.getClassCodeName() + "_" + "analysis";
        toReturn.append("<input type=\"hidden\" name=\"");
        toReturn.append(objectId);
        toReturn.append("\" value=\"\" id=\"");
        toReturn.append(objectId);
        toReturn.append("\" >");
        toReturn.append("<div>\n");
        toReturn.append("   <div>\n");
        toReturn.append("          <button dojoType=\"dijit.form.Button\" type=\"submit\" class=\"pull-right swb-boton-enviar\" ");//btn btn-default pull-right swb-boton-enviar
        toReturn.append("name=\"enviar\" >");
        toReturn.append(getLocaleString("send", lang));
        toReturn.append("</button>");
        toReturn.append("    </div>\n");
        toReturn.append("   <div>\n");
        toReturn.append("          <button dojoType=\"dijit.form.Button\" class=\"pull-right swb-boton-cancelar\" ");
        toReturn.append("onclick=\"dijit.byId('swbDialogAnalysis').hide()\">");
        toReturn.append(getLocaleString("cancel", lang));
        toReturn.append("</button>");
        toReturn.append("    </div>\n");

        toReturn.append("</div>");
        toReturn.append("</form>");
        toReturn.append("</div>");
        return toReturn.toString();
    }

    /**
     * Genera el c&oacute;digo HTML para representar la vista para agregar una
     * recomendaci&oacute;n.
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
    public String renderElementAddRecommendation(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        StringBuilder toReturn = new StringBuilder();
        SWBFormMgr formMgr = new SWBFormMgr(Recommendation.bsc_Recommendation,
                obj, null);
        formMgr.clearProperties();
        formMgr.addProperty(Recommendation.bsc_recommendations);
        formMgr.setType(SWBFormMgr.TYPE_DOJO);
        formMgr.setSubmitByAjax(true);
        formMgr.setMode(SWBFormMgr.MODE_CREATE);

        String url = getProcessURL(obj, prop).setParameter("_action", Action_ADD_RECOMMENDATION).setParameter("suri", request.getParameter("suri")).toString();
        formMgr.setAction(url);
        toReturn.append("<div id=\"frmAdd\" >");

        SemanticObject semObj = new SemanticObject(obj.getModel(), Recommendation.bsc_Recommendation);
        String onsubmit = " onsubmit=\"if(validateDataFrmData('recommendation')) {submitFormR(this.id, 'recommendation');return false;} else {return false;}\"";
        toReturn.append("<form id=\"");
        toReturn.append(formMgr.getFormName());
        toReturn.append("\" class=\"form-horizontal\" action=\"");
        toReturn.append(url);
        toReturn.append("\"");
        toReturn.append(onsubmit);
        toReturn.append(" method=\"post\" dojoType=\"dijit.form.Form\">\n");
        toReturn.append(formMgr.getFormHiddens());

        Iterator<SemanticProperty> it = SWBComparator.sortSortableObject(formMgr.
                getProperties().iterator());
        while (it.hasNext()) {
            SemanticProperty prop1 = it.next();
            toReturn.append("<div class=\"form-group\">");
            toReturn.append("<div class=\"col-lg-12\">");
            toReturn.append(
                    formMgr.getFormElement(prop1).renderElement(
                            request, semObj, prop1,
                            prop1.getName(), "XHTML", Mode_INLINE, lang));
            toReturn.append("</div>");
            toReturn.append("</div>");
        }
        String objectId = Recommendation.sclass.getClassCodeName() + "_" + "recommendations";
        toReturn.append("<input type=\"hidden\" name=\"");
        toReturn.append(objectId);
        toReturn.append("\" value=\"\" id=\"");
        toReturn.append(objectId);
        toReturn.append("\" >");

        toReturn.append("<div>\n");
        toReturn.append("   <div>\n");
        toReturn.append("          <button dojoType=\"dijit.form.Button\" type=\"submit\" class=\"pull-right swb-boton-enviar\" ");//btn btn-default pull-right swb-boton-enviar
        toReturn.append("name=\"enviar\" >");
        toReturn.append(getLocaleString("send", lang));
        toReturn.append("</button>");
        toReturn.append("    </div>\n");
        toReturn.append("   <div>\n");
        toReturn.append("          <button dojoType=\"dijit.form.Button\" class=\"pull-right swb-boton-cancelar\" ");
        toReturn.append("onclick=\"dijit.byId('swbDialogRecommendation').hide()\">");
        toReturn.append(getLocaleString("cancel", lang));
        toReturn.append("</button>");
        toReturn.append("    </div>\n");

        toReturn.append("</div>");
        toReturn.append("</form>");
        toReturn.append("</div>");
        return toReturn.toString();
    }

    /**
     * Vista utilizada para recargar la vista despu&eacute;s de ejecutar una
     * acci&oacute;n, tal como Agregar, Editar o Eliminar
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
            SemanticProperty prop, String type, String mode, String lang, boolean isAnalysis) {
        StringBuilder toReturn = new StringBuilder();
        String suri = (String) request.getParameter("suri");
        String usrWithGrants = (String) request.getAttribute("usrWithGrants") == null
                ? (String) request.getParameter("usrWithGrants")
                : (String) request.getAttribute("usrWithGrants");
        int pc_a = 0, pc_r = 0;
        if (suri != null) {
            try {
                SemanticObject semObj = SemanticObject.getSemanticObject(URLDecoder.decode(suri, "UTF-8"));
                Updateable element = null;
                if (semObj != null && semObj.createGenericInstance() instanceof Updateable) {
                    element = (Updateable) semObj.createGenericInstance();
                    if (isAnalysis) {
                        String viewLess = (String) request.getParameter("viewLessAn");
                        List litAnal = SWBUtils.Collections.copyIterator(element.listAnalysises());
                        String valueStr = Analysis.sclass.getClassCodeName();
                        int pageCurrent;
                        try {
                            pageCurrent = (Integer) request.getSession(true).getAttribute("pc_a");
                        } catch (Exception e) {
                            pageCurrent = 1;
                        }
                        if ((viewLess != null && viewLess.equals("true"))
                                || (!litAnal.isEmpty() && (litAnal.size() / 3) == 1
                                && litAnal.size() % 3 == 0)) {
                            pageCurrent = 1;
                        }
                        pc_a = pageCurrent * 3;
                        if (litAnal.size() > pc_a) {
                            pageCurrent++;
                        }

                        request.getSession(true).setAttribute("pc_a", pageCurrent);
                        toReturn.append(listAnalysis(litAnal.iterator(), suri, obj, prop, type, mode,
                                lang, usrWithGrants, valueStr, pc_a));
                    } else {
                        String viewLess = (String) request.getParameter("viewLessRec");
                        List litReco = SWBUtils.Collections.copyIterator(element.listRecommendations());
                        String valueStr = valueStr = Recommendation.sclass.getClassCodeName();
                        int pageCurrent;
                        try {
                            pageCurrent = (Integer) request.getSession(true).getAttribute("pc_r");

                        } catch (Exception e) {
                            pageCurrent = 1;
                        }
                        if ((viewLess != null && viewLess.equals("true"))
                                || (!litReco.isEmpty() && (litReco.size() / 3) == 1
                                && litReco.size() % 3 == 0)) {
                            pageCurrent = 1;
                        }
                        pc_r = pageCurrent * 3;
                        if (litReco.size() > pc_r) {
                            pageCurrent++;
                        }
                        request.getSession(true).setAttribute("pc_r", pageCurrent);
                        toReturn.append(listRecommendations(litReco.iterator(), suri, obj, prop, type, mode,
                                lang, usrWithGrants, valueStr, pc_r));
                    }
                }
            } catch (UnsupportedEncodingException ex) {
                log.error("Error in: " + ex);
            }
        }
        return toReturn.toString();
    }

    /**
     * Genera el c&oacute;digo HTML para representar la edici&oacute;n de un
     * an&aacute;lisis.
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
    public String renderElementEditAnalysis(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        StringBuilder toReturn = new StringBuilder();
        String usrWithGrants = (String) request.getAttribute("usrWithGrants");
        try {
            SemanticObject semObject = SemanticObject.createSemanticObject(URLDecoder.
                    decode(request.getParameter("suri"), "UTF-8"));
            SWBFormMgr formMgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            formMgr.clearProperties();
            formMgr.addProperty(Analysis.bsc_analysis);
            formMgr.setType(SWBFormMgr.TYPE_XHTML);
            formMgr.setSubmitByAjax(true);
            formMgr.setMode(SWBFormMgr.MODE_EDIT);

            FormElementURL urlp = getProcessURL(obj, prop);
            urlp.setParameter("_action", Action_EDIT);
            urlp.setParameter("usrWithGrants", usrWithGrants);
            String url = urlp.toString();
            String onsubmit = " onsubmit=\"if(validateDataFrmData('analysis')) {submitFormA(this.id,'analysis');return false;} else {return false;}\"";
            toReturn.append("<div id=\"frmAdd\">");
            toReturn.append("<form id=\"");
            toReturn.append(formMgr.getFormName());
            toReturn.append("\" class=\"form-horizontal\" action=\"");
            toReturn.append(url);
            toReturn.append("\"");
            toReturn.append(onsubmit);
            toReturn.append(" method=\"post\">\n");
            toReturn.append(formMgr.getFormHiddens());

            Iterator<SemanticProperty> it = SWBComparator.sortSortableObject(formMgr.
                    getProperties().iterator());
            while (it.hasNext()) {
                SemanticProperty prop1 = it.next();
                toReturn.append("<div class=\"form-group\">");
                toReturn.append("<div class=\"col-lg-12\">");
                toReturn.append(
                        formMgr.getFormElement(prop1).renderElement(
                                request, semObject, prop1,
                                prop1.getName(), "XHTML", Mode_INLINE, lang));
                toReturn.append("</div>");
                toReturn.append("</div>");
            }
            String objectId = Analysis.sclass.getClassCodeName() + "_" + "analysis";
            toReturn.append("<input type=\"hidden\" name=\"");
            toReturn.append(objectId);
            toReturn.append("\" value=\"\" id=\"");
            toReturn.append(objectId);
            toReturn.append("\" >");

            toReturn.append("<div>\n");
            toReturn.append("   <div>\n");
            toReturn.append("          <button dojoType=\"dijit.form.Button\" class=\"pull-right swb-boton-enviar\" type=\"submit\" ");
            toReturn.append("name=\"enviar\" >");
            toReturn.append(getLocaleString("send", lang));
            toReturn.append("</button>");
            toReturn.append("</div>");
            toReturn.append("   <div>\n");
            toReturn.append("          <button dojoType=\"dijit.form.Button\" class=\"pull-right swb-boton-cancelar\" ");
            toReturn.append("onclick=\"dijit.byId('swbDialogAnalysis').hide()\">");
            toReturn.append(getLocaleString("cancel", lang));
            toReturn.append("</button>");
            toReturn.append("</div>");

            toReturn.append("</div>");
            toReturn.append("</form>\n");
            toReturn.append("</div>");

        } catch (UnsupportedEncodingException ex) {
            log.error("Error in: " + ex);
        }
        return toReturn.toString();
    }

    /**
     * Genera el c&oacute;digo HTML para representar la edici&oacute;n de una
     * recomendaci&oacute;n.
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
    public String renderElementEditRecommendation(HttpServletRequest request, SemanticObject obj,
            SemanticProperty prop, String propName, String type, String mode, String lang) {
        StringBuilder toReturn = new StringBuilder();
        String usrWithGrants = (String) request.getAttribute("usrWithGrants");
        try {
            SemanticObject semObject = SemanticObject.createSemanticObject(URLDecoder.
                    decode(request.getParameter("suri"), "UTF-8"));
            SWBFormMgr formMgr = new SWBFormMgr(semObject, null, SWBFormMgr.MODE_EDIT);
            formMgr.clearProperties();
            formMgr.addProperty(Recommendation.bsc_recommendations);
            formMgr.setType(SWBFormMgr.TYPE_XHTML);
            formMgr.setSubmitByAjax(true);
            formMgr.setMode(SWBFormMgr.MODE_EDIT);

            FormElementURL urlp = getProcessURL(obj, prop);
            urlp.setParameter("_action", Action_EDIT);
            urlp.setParameter("usrWithGrants", usrWithGrants);
            String url = urlp.toString();
            String onsubmit = " onsubmit=\"if(validateDataFrmData('recommendation')) {submitFormR(this.id,'recommendation');return false;} else {return false;}\"";
            toReturn.append("<div id=\"frmAdd\">");
            toReturn.append("<form id=\"");
            toReturn.append(formMgr.getFormName());
            toReturn.append("\" class=\"form-horizontal\" action=\"");
            toReturn.append(url);
            toReturn.append("\"");
            toReturn.append(onsubmit);
            toReturn.append(" method=\"post\">\n");
            toReturn.append(formMgr.getFormHiddens());

            Iterator<SemanticProperty> it = SWBComparator.sortSortableObject(formMgr.
                    getProperties().iterator());
            while (it.hasNext()) {
                SemanticProperty prop1 = it.next();
                toReturn.append("<div class=\"form-group\">");
                toReturn.append("<div class=\"col-lg-12\">");
                toReturn.append(
                        formMgr.getFormElement(prop1).renderElement(
                                request, semObject, prop1,
                                prop1.getName(), "XHTML", Mode_INLINE, lang));
                toReturn.append("</div>");
                toReturn.append("</div>");
            }
            String objectId = Recommendation.sclass.getClassCodeName() + "_" + "recommendations";
            toReturn.append("<input type=\"hidden\" name=\"");
            toReturn.append(objectId);
            toReturn.append("\" value=\"\" id=\"");
            toReturn.append(objectId);
            toReturn.append("\" >");

            toReturn.append("<div>\n");
            toReturn.append("   <div>\n");
            toReturn.append("          <button dojoType=\"dijit.form.Button\" class=\"pull-right swb-boton-enviar\" type=\"submit\" ");
            toReturn.append("name=\"enviar\" >");
            toReturn.append(getLocaleString("send", lang));
            toReturn.append("</button>");
            toReturn.append("</div>");
            toReturn.append("   <div>\n");
            toReturn.append("          <button dojoType=\"dijit.form.Button\" class=\"pull-right swb-boton-cancelar\" ");
            toReturn.append("onclick=\"dijit.byId('swbDialogRecommendation').hide()\">");
            toReturn.append(getLocaleString("cancel", lang));
            toReturn.append("</button>");
            toReturn.append("</div>");

            toReturn.append("</div>");
            toReturn.append("</form>\n");
            toReturn.append("</div>");

        } catch (UnsupportedEncodingException ex) {
            log.error("Error: " + ex);
        }
        return toReturn.toString();
    }

    /**
     * Genera la vista view del elemento de forma.
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
        Updateable element;
        if (obj.getGenericInstance() instanceof Updateable) {
            element = (Updateable) obj.getGenericInstance();
            if (prop.getURI().equals(Updateable.bsc_hasAnalysis.getURI())) {
                html.append("<div class=\"table-responsive\">").append("\n");
                html.append("<table class=\"table table-striped table-condensed table-bordered\">").append("\n");
                html.append(" <tbody>").append("\n");
                Set setAnalysis = SWBComparator.sortByLastUpdateSet(element.listAnalysises(), false);
                Iterator<Analysis> itAnalysis = setAnalysis.iterator();
                while (itAnalysis.hasNext()) {
                    Analysis analysis = itAnalysis.next();
                    html.append("<tr>");

                    html.append("<td>");
                    html.append(analysis.getUpdated() == null ? ""
                            : SWBUtils.TEXT.getStrDate(analysis.getUpdated(), "es", "dd/mm/yyyy hh:mm:ss"));
                    html.append("</td>");
                    html.append("<td scope=\"row\">");
                    html.append(analysis.getAnalysis());
                    html.append("</td>");
                    html.append("<td scope=\"row\">");
                    html.append(analysis.getCreator() == null ? ""
                            : (analysis.getCreator().getFullName() == null ? ""
                                    : analysis.getCreator().getFullName()));
                    html.append("</td>");
                    html.append("</tr>").append("\n");
                }
                html.append(" </tbody>").append("\n");
                html.append("</table>");
                html.append("</div>");
            } else if (prop.getURI().equals(Updateable.bsc_Recommendation.getURI())) {
                html.append("<div class=\"table-responsive\">").append("\n");
                html.append("<table class=\"table table-striped table-condensed table-bordered\">").append("\n");
                html.append(" <tbody>").append("\n");
                Set setRecommendations = SWBComparator.sortByLastUpdateSet(element.listRecommendations(), false);
                Iterator<Recommendation> itRecommendations = setRecommendations.iterator();
                while (itRecommendations.hasNext()) {
                    Recommendation recommendation = itRecommendations.next();
                    html.append("<tr>");

                    html.append("<td>");
                    html.append(recommendation.getUpdated() == null ? ""
                            : SWBUtils.TEXT.getStrDate(recommendation.getUpdated(), "es", "dd/mm/yyyy hh:mm:ss"));
                    html.append("</td>");
                    html.append("<td scope=\"row\">");
                    html.append(recommendation.getRecommendations());
                    html.append("</td>");
                    html.append("<td scope=\"row\">");
                    html.append(recommendation.getCreator() == null ? ""
                            : (recommendation.getCreator().getFullName() == null ? ""
                                    : recommendation.getCreator().getFullName()));
                    html.append("</td>");
                    html.append("</tr>").append("\n");
                }
                html.append(" </tbody>").append("\n");
                html.append("</table>");
                html.append("</div>");
            }

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
    public void process(HttpServletRequest request, SemanticObject obj, SemanticProperty prop, String propName) {
        final String action = request.getParameter("_action");
        WebSite scorecard = (WebSite) obj.getModel().getModelObject().getGenericInstance();
        final User user = SWBContext.getSessionUser(scorecard.getUserRepository().getId());
        if (Action_ADD_ANALYSIS.equals(action)) {
            String sref = request.getParameter("sref");
            SemanticObject semObjRef = SemanticObject.createSemanticObject(sref);
            Updateable updateable = null;
            if ((semObjRef != null) && semObjRef.createGenericInstance() instanceof Updateable
                    && request.getParameter("Analysis_analysis") != null) {
                updateable = (Updateable) semObjRef.createGenericInstance();
                Analysis analysis = Analysis.ClassMgr.createAnalysis(scorecard);
                analysis.setAnalysis(SWBUtils.XML.replaceXMLTags(request.getParameter("Analysis_analysis")));
                analysis.setCreator(user);
                updateable.addAnalysis(analysis);
                request.getSession(true).setAttribute("pc_a", "1");
            }
        } else if (Action_ADD_RECOMMENDATION.equals(action)) {
            String sref = request.getParameter("sref");
            SemanticObject semObjRef = SemanticObject.createSemanticObject(sref);
            Updateable updateable = null;
            if ((semObjRef != null) && semObjRef.createGenericInstance() instanceof Updateable
                    && request.getParameter("Recommendation_recommendations") != null) {
                updateable = (Updateable) semObjRef.createGenericInstance();
                Recommendation recommendation = Recommendation.ClassMgr.createRecommendation(scorecard);
                recommendation.setRecommendations(SWBUtils.XML.replaceXMLTags(request.getParameter("Recommendation_recommendations")));
                recommendation.setCreator(user);
                updateable.addRecommendation(recommendation);
                request.getSession(true).setAttribute("pc_r", "1");
            }
        } else if (Action_EDIT.equals(action)) {
            String suri = request.getParameter("suri");
            SemanticObject semObj = SemanticObject.getSemanticObject(suri);
            if (semObj != null && request.getParameter("Recommendation_recommendations") != null) {
                Recommendation recommendation = (Recommendation) semObj.createGenericInstance();
                recommendation.setRecommendations(SWBUtils.XML.replaceXMLTags(request.getParameter("Recommendation_recommendations")));
                recommendation.setModifiedBy(user);
                recommendation.setUpdated(new Date());
                request.getSession(true).setAttribute("pc_r", "1");
            } else if (semObj != null && request.getParameter("Analysis_analysis") != null) {
                Analysis analysis = (Analysis) semObj.createGenericInstance();
                analysis.setAnalysis(SWBUtils.XML.replaceXMLTags(request.getParameter("Analysis_analysis")));
                analysis.setModifiedBy(user);
                analysis.setUpdated(new Date());
                request.getSession(true).setAttribute("pc_a", "1");
            }
        } else if (Action_REMOVE.equals(action)) {
            String suri = request.getParameter("suri");
            String sobj = request.getParameter("obj");
            SemanticObject semObj = SemanticObject.getSemanticObject(suri);
            SemanticObject semObjElement = SemanticObject.getSemanticObject(sobj);
            if (semObjElement.createGenericInstance() instanceof Updateable) {
                Updateable updElement = (Updateable) semObjElement.createGenericInstance();
                GenericObject genObj = semObj.createGenericInstance();
                if (genObj instanceof Analysis) {
                    Analysis analysis = (Analysis) genObj;
                    updElement.removeAnalysis(analysis);
                    analysis.remove();
                    request.getSession(true).setAttribute("pc_a", "1");
                } else if (genObj instanceof Recommendation) {
                    Recommendation recommendation = (Recommendation) genObj;
                    updElement.removeRecommendation(recommendation);
                    recommendation.remove();
                    request.getSession(true).setAttribute("pc_r", "1");
                }
            }
        }

    }

    /**
     * Lista en HTML las recomendaciones.
     *
     * @param itRecommendations el iterador con las recomendaciones
     * @param suri el objeto que contiene el formElement
     * @param obj la propiedad asociada a este FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param type el tipo de despliegue a generar. Actualmente solo se acepta
     * el valor {@code dojo}
     * @param mode el modo en que se presentar&aacute; el despliegue del
     * FormElement. Los modos soportados son: {@literal edit},
     * {@literal create}, {@literal filter} y {@literal view}
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @param usrWithGrants define si existen permisos para editar o eliminar
     * las recomendaciones.
     * @param valueStr define el nombre de la propiedad
     * @param pageCurrent define la paginaci&oacute;n de la vista
     * @return el objeto String que representa el c&oacute;digo HTML con el
     * conjunto de recomendaciones.
     */
    private String listRecommendations(Iterator<Recommendation> itRecommendations, String suri,
            SemanticObject obj, SemanticProperty prop, String type, String mode, String lang,
            String usrWithGrants, String valueStr, int pageCurrent) {
        StringBuilder toReturn = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss", new Locale(lang));
        FormElementURL urlFE = new FormElementURL(this, obj, prop, FormElementURL.URLTYPE_RENDER, type, mode, lang);//getRenderURL(obj, prop, type, mode, lang);
        urlFE.setParameter("modeTmp", Mode_RELOAD_RECOMMENDATION);
        urlFE.setParameter("suri", suri);
        urlFE.setParameter("usrWithGrants", usrWithGrants);
        toReturn.append("\n<table class=\"tabla-detalle table\">");
        Set setRecommendations = SWBComparator.sortByLastUpdateSet(itRecommendations, false);
        itRecommendations = setRecommendations.iterator();

        toReturn.append("<tbody>");

        for (int i = pageCurrent; i > 0 && itRecommendations.hasNext(); i--) {
            Recommendation recommendation = itRecommendations.next();
            toReturn.append("\n<tr>");

            toReturn.append("\n<td>");
            toReturn.append(recommendation.getUpdated() == null ? ""
                    : sdf.format(recommendation.getUpdated()));
            toReturn.append("\n</td>");

            toReturn.append("\n<td>");
            toReturn.append(recommendation.getRecommendations() == null ? ""
                    : recommendation.getRecommendations());
            toReturn.append("\n</td>");

            toReturn.append("\n<td>");
            toReturn.append(recommendation.getCreator() == null ? ""
                    : (recommendation.getCreator().getFullName() == null ? "" : recommendation.getCreator().getFullName()));
            toReturn.append("\n</td>");

            if ("true".equals(usrWithGrants)) {
                FormElementURL urlEdit = new FormElementURL(this, obj, prop, FormElementURL.URLTYPE_RENDER, type, mode, lang);
                urlEdit.setParameter("modeTmp", Mode_EDIT_RECOMMENDATION);
                urlEdit.setParameter("suri", recommendation.getURI());
                urlEdit.setParameter("usrWithGrants", usrWithGrants);

                FormElementURL urlRemove = getProcessURL(obj, prop);
                urlRemove.setParameter("_action", Action_REMOVE);
                urlRemove.setParameter("suri", recommendation.getURI());
                urlRemove.setParameter("obj", suri);
                urlRemove.setParameter("usrWithGrants", usrWithGrants);
                toReturn.append("\n<td class=\"swb-td-accion\">");
                toReturn.append("\n<a href=\"#linkRecommendation\" onclick=\"showDialog");
                toReturn.append(valueStr);
                toReturn.append("('");
                toReturn.append(urlEdit.setContentType("text/html; charset=UTF-8"));
                toReturn.append("', '");
                toReturn.append(Recommendation.sclass.getDisplayName(lang));
                toReturn.append("');\">");
                toReturn.append("<span class=\"glyphicon glyphicon-pencil\"></span>");
                toReturn.append("\n</a>");
                toReturn.append("\n<a href=\"#linkRecommendation\" onclick=\"if(confirm(\'");
                toReturn.append("¿");
                toReturn.append(getLocaleString("alertDeleteElement", lang));
                toReturn.append("?\')){ ");
                toReturn.append("processUrlRecommendation('");
                toReturn.append(urlRemove);
                toReturn.append("',null); ");
                toReturn.append("} else { return false;}");
                toReturn.append("\">");
                toReturn.append("<span class=\"glyphicon glyphicon-trash\"></span>");
                toReturn.append("\n</a>");
                toReturn.append("\n</td>");
            }
            toReturn.append("\n</tr>");
        }
        toReturn.append("</tbody>");
        toReturn.append("\n</table>");
        String url = urlFE.setParameter("viewLessRec", "false").setContentType("text/html; charset=UTF-8").toString();

        String url2 = urlFE.setParameter("viewLessRec", "true").setContentType("text/html; charset=UTF-8").toString();
        toReturn.append("<ul class=\"list-inline\">");
        if ((pageCurrent / 3) > 1) {
            toReturn.append("<li><a href=\"#linkRecommendation\" onclick=\"javascript:processUrlRecommendation('");
            toReturn.append(url2);
            toReturn.append("','swbform");
            toReturn.append(valueStr);
            toReturn.append("')\" title=\"");
            toReturn.append(getLocaleString("viewLess", lang));
            toReturn.append("\">");
            toReturn.append(getLocaleString("viewLess", lang));
            toReturn.append("</a></li>");
        }
        if (setRecommendations.size() > pageCurrent) {
            toReturn.append("<li><a href=\"#linkRecommendation\" onclick=\"javascript:processUrlRecommendation('");
            toReturn.append(url);
            toReturn.append("','swbform");
            toReturn.append(valueStr);
            toReturn.append("')\" title=\"");
            toReturn.append(getLocaleString("viewMore", lang));
            toReturn.append("\">");
            toReturn.append(getLocaleString("viewMore", lang));
            toReturn.append("</a></li>");
        }
        toReturn.append("</ul>");
        return toReturn.toString();
    }

    /**
     * Lista en HTML el conjunto de an&aacute;lisis.
     *
     * @param itAnalysis el iterador con el conjunto de an&aacute;lisis
     * @param suri el objeto que contiene el formElement
     * @param obj la propiedad asociada a este FormElement
     * @param prop la propiedad asociada a este FormElement
     * @param type el tipo de despliegue a generar. Actualmente solo se acepta
     * el valor {@code dojo}
     * @param mode el modo en que se presentar&aacute; el despliegue del
     * FormElement. Los modos soportados son: {@literal edit},
     * {@literal create}, {@literal filter} y {@literal view}
     * @param lang el lenguaje utilizado en la generaci&oacute;n del
     * c&oacute;digo HTML a regresar
     * @param usrWithGrants define si existen permisos para editar o eliminar
     * las recomendaciones.
     * @param valueStr define el nombre de la propiedad
     * @param pageCurrent define la paginaci&oacute;n de la vista
     * @return el objeto String que representa el c&oacute;digo HTML con el
     * conjunto de an&aacute;lisis.
     */
    private String listAnalysis(Iterator<Analysis> itAnalysis, String suri,
            SemanticObject obj, SemanticProperty prop, String type, String mode, String lang,
            String usrWithGrants, String valueStr, int pageCurrent) {
        StringBuilder toReturn = new StringBuilder();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss", new Locale(lang));
        toReturn.append("\n<table class=\"tabla-detalle table\">");
        Set setAnalysis = SWBComparator.sortByLastUpdateSet(itAnalysis, false);
        itAnalysis = setAnalysis.iterator();
        FormElementURL urlFE = getRenderURL(obj, prop, type, mode, lang);
        urlFE.setParameter("modeTmp", Mode_RELOAD_ANALYSIS);
        urlFE.setParameter("suri", suri);
        urlFE.setParameter("usrWithGrants", usrWithGrants);
        urlFE.setParameter("obj", suri);

        toReturn.append("<tbody>");
        for (int i = pageCurrent; i > 0 && itAnalysis.hasNext(); i--) {
            Analysis analysis = itAnalysis.next();
            toReturn.append("\n<tr>");
            toReturn.append("\n<td>");
            toReturn.append(analysis.getUpdated() == null ? ""
                    : sdf.format(analysis.getUpdated()));
            toReturn.append("\n</td>");
            toReturn.append("\n<td>");
            toReturn.append(analysis.getAnalysis() == null ? ""
                    : analysis.getAnalysis());
            toReturn.append("\n</td>");
            toReturn.append("\n<td>");
            toReturn.append(analysis.getCreator() == null ? ""
                    : (analysis.getCreator().getFullName() == null ? "" : analysis.getCreator().getFullName()));
            toReturn.append("\n</td>");
            if ("true".equals(usrWithGrants)) {
                FormElementURL urlEdit = getRenderURL(obj, prop, type, mode, lang);
                urlEdit.setParameter("modeTmp", Mode_EDIT_ANALYSIS);
                urlEdit.setParameter("suri", analysis.getURI());
                urlEdit.setParameter("usrWithGrants", usrWithGrants);

                FormElementURL urlRemove = getProcessURL(obj, prop);
                urlRemove.setParameter("_action", Action_REMOVE);
                urlRemove.setParameter("suri", analysis.getURI());
                urlRemove.setParameter("obj", suri);
                urlRemove.setParameter("usrWithGrants", usrWithGrants);
                toReturn.append("\n<td class=\"swb-td-accion\">");
                toReturn.append("\n<a href=\"#linkAnalysis\" onclick=\"showDialog");
                toReturn.append(valueStr);
                toReturn.append("('");
                toReturn.append(urlEdit.setContentType("text/html; charset=UTF-8"));
                toReturn.append("', '");
                toReturn.append(Analysis.sclass.getDisplayName(lang));
                toReturn.append("');\">");
                toReturn.append("<span class=\"glyphicon glyphicon-pencil\"></span>");
                toReturn.append("\n</a>");
                toReturn.append("\n<a href=\"#linkAnalysis\" onclick=\"if(confirm(\'");
                toReturn.append("¿");
                toReturn.append(getLocaleString("alertDeleteElement", lang));
                toReturn.append(" ?\')){ ");
                toReturn.append("processUrlAnalysis('");
                toReturn.append(urlRemove);
                toReturn.append("',null); ");
                toReturn.append("} else { return false;}");
                toReturn.append("\">");
                toReturn.append("<span class=\"glyphicon glyphicon-trash\"></span>");
                toReturn.append("\n</a>");
                toReturn.append("\n</td>");

            }
            toReturn.append("\n</tr>");
        }
        toReturn.append("</tbody>");
        toReturn.append("\n</table>");
        String url = urlFE.setParameter("viewLessAn", "false").setContentType("text/html; charset=UTF-8").toString();
        String url2 = urlFE.setParameter("viewLessAn", "true").setContentType("text/html; charset=UTF-8").toString();
        toReturn.append("<ul class=\"list-inline\">");
        if ((pageCurrent / 3) > 1) {
            toReturn.append("<li><a href=\"#linkAnalysis\" onclick=\"javascript:processUrlAnalysis('");
            toReturn.append(url2);
            toReturn.append("','swbform");
            toReturn.append(valueStr);
            toReturn.append("')\" title=\"");
            toReturn.append(getLocaleString("viewLess", lang));
            toReturn.append("\">");
            toReturn.append(getLocaleString("viewLess", lang));
            toReturn.append("</a></li>");
        }

        if (setAnalysis.size() > pageCurrent) {
            toReturn.append("<li><a href=\"#linkAnalysis\" onclick=\"javascript:processUrlAnalysis('");
            toReturn.append(url);
            toReturn.append("','swbform");
            toReturn.append(valueStr);
            toReturn.append("')\" title=\"");
            toReturn.append(getLocaleString("viewMore", lang));
            toReturn.append("\">");
            toReturn.append(getLocaleString("viewMore", lang));
            toReturn.append("</a></li>");
        }
        toReturn.append("</ul>");

        return toReturn.toString();
    }

}
