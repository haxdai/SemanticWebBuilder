package org.semanticwb.bsc.resources.reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;
import static org.semanticwb.bsc.utils.BSCUtils.ColorPalette;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.ComponentExportable;
import org.semanticwb.bsc.Perspective;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.Series;

/**
 *
 * @author carlos.ramos
 */
public class CumulativeReport extends GenericResource implements ComponentExportable {
    private static final Logger log = SWBUtils.getLogger(CumulativeReport.class);
    private static  String SVG_ID;
    
    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        SVG_ID = "_"+getResourceBase().getId();
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        final User user = paramRequest.getUser();
        if(!user.isSigned()) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgUserHasNotPermissions")+"</div>");
            response.flushBuffer();
            return;
        }
        
        BSC bsc = (BSC)getResourceBase().getWebSite();
        final String lang;
        lang = paramRequest.getUser().getLanguage();
        final Locale locale;
        locale = new Locale(lang);
        
        StringBuilder html;
        html = new StringBuilder();        
        html.append("<script>\n");
        html.append("require([\"dojo/parser\", \"dijit/form/Form\", \"dijit/form/ValidationTextBox\"\n"
                +", \"dijit/form/FilteringSelect\", \"dijit/form/CheckBox\", \"dijit/form/Button\"]);\n");
        
        html.append("  function showGraph(dato) {\n");
        html.append("    d3.select('#"+SVG_ID+"').selectAll(\"*\").remove();\n");
//html.append("    alert('json.'+JSON.stringify(dato));\n");
        html.append("    \n");
        html.append("    \n");
        html.append("    for(var i=0; i<dato.indicators.length; i++) {");
        html.append("      var chart = nv.models.multiBarChart();\n");
        html.append("      chart.x(function(d) { return d.label });\n");
        html.append("      chart.y(function(d) { return d.value });\n");
        //html.append("      chart.width(500);\n");
        //html.append("      chart.height(500);\n");
        html.append("      chart.margin({top:5, right:60, bottom:170, left:110});\n");
        html.append("      chart.rotateLabels(45);\n");
        html.append("      chart.showControls(true);\n");
        html.append("      chart.groupSpacing(0.1);\n");
        html.append("      chart.transitionDuration(500);\n");
        html.append("      chart.reduceXTicks(false);\n");
        html.append("      chart.staggerLabels(true);\n");
        html.append("      chart.stacked(true);\n");
        html.append("      chart.showLegend(true);\n");
        html.append("      chart.tooltips(true);\n");
        
        html.append("      chart.tooltipContent(function (key, y, e, graph) {\n");
        html.append("            var content = '<p style=\"text-align: center; font-size: 1.2em;"
                + " font-weight: bolder;\">';\n");
        html.append("            content += key + '</p><p style=\"text-align: center;"
                + " font-size: 1.2em; font-weight: normal;\">' + e + \" "+paramRequest.getLocaleString("lblIn")
                +" \" + y + '</p>';\n");
        html.append("            return content;\n");
        html.append("      });\n");
//        html.append("      chart.controlLabels({ \"stacked\": \"")
//                .append(paramRequest.getLocaleString("lblStackedControlLabel"))
//                .append("\",\"grouped\": \"")
//                .append(paramRequest.getLocaleString("lblGroupedControlLabel"))
//                .append("\" });\n");
        html.append("      chart.showLegend(true);\n");
//        html.append("  chart.xAxis.axisLabel('Períodos de mediciones');\n");
//        html.append("  chart.xAxis.axisLabelDistance(35);\n");
//        html.append("  chart.xAxis.showMaxMin(true);\n");
//        html.append("  chart.yAxis.axisLabel('Valores')\n");
//        html.append("  chart.yAxis.axisLabelDistance(20)\n");
        html.append("      chart.yAxis.tickFormat(d3.format(',.2f'));\n");
//        html.append("      chart.yAxis.showMaxMin(true);\n");

        //html.append("      d3.select('#"+SVG_ID+"').append('div').attr('class', '__col-md-6')"
        html.append("      d3.select('#"+SVG_ID+"').append('div').attr('id','"+SVG_ID+"_cntnr_'+i)"
                + ".attr('style','height:300px;');\n");
        html.append("      d3.select('#"+SVG_ID+"_cntnr_'+i).append('h5').text('"
                +paramRequest.getLocaleString("lblKPI")
                +": '+dato.indicators[i].title+' ('+dato.indicators[i].format+')');\n");
        html.append("      d3.select('#"+SVG_ID+"_cntnr_'+i)"
                + ".append('svg').attr('id','"+SVG_ID+"_'+i)"
                + ".attr('width','100%').attr('height','100%')\n");
        html.append("          .datum(dato.indicators[i].data)\n");
        html.append("          .call(chart);\n");
        html.append("      nv.utils.windowResize(chart.update);\n");
        html.append("    }\n"); // for
        html.append("  }\n");   // function showGraph

        html.append("  function getData(url) {\n");
        html.append("    dojo.xhrGet({\n");
        html.append("      url: url,");
        html.append("      handleAs: 'json',\n");
        html.append("      preventCache: true,\n");
        html.append("      load: function(dato, ioargs) {\n");
        html.append("          showGraph(dato);");
        html.append("      },\n");
        html.append("      error: function(error, ioargs) {\n");
        html.append("        alert('Uno o varios campos son incorrectos. Hace falta corregirlos e intentar de nuevo');\n");
        html.append("      }\n");
        html.append("    });\n");
        html.append("  }\n");

        // data store de perspectivas
        Perspective perspective;
        List<Perspective> perspectives = bsc.listValidPerspectives();
        Collections.sort(perspectives);
        Iterator<Perspective> it = perspectives.iterator();
        html.append("var prsps_ = [\n");
        while(it.hasNext()) {
            perspective = it.next();
            html.append("{name: \"");
            html.append(perspective.getDisplayTitle(lang));
            html.append("\", prspid: \"");
            html.append(perspective.getId());
            html.append("\"");
            html.append("}");
            html.append( it.hasNext()?",\n":"\n" );
        }
        html.append("];\n");

        // data store de sponsors
        User usr;
        UserRepository ur;
        ur = bsc.getUserRepository();
        String ugId;
        ugId = "sponsor";
        final Role sponsor = ur.getRole(ugId);
        Iterator<User> usrs = ur.listUsers();
        html.append("var sprs_ = [\n");
        while(usrs.hasNext()) {
            usr = usrs.next();
            if(!usr.hasRole(sponsor)) {
                continue;
            }
            html.append("{name: \"");
            html.append(usr.getFullName());
            html.append("\", usrid: \"");
            html.append(usr.getId());
            html.append("\"");
            html.append("}");
            html.append( usrs.hasNext()?",\n":"\n" );
        }
        html.append("];\n");

        // data store de objetivos
        Objective obj;
        Iterator<Objective> objs = Objective.ClassMgr.listObjectives(bsc);
        html.append("var objs_ = [\n");
        while(objs.hasNext()) {
            obj = objs.next();
            if( !obj.isValid() || !user.haveAccess(obj) ) {
                continue;
            }
            html.append("{name: \"");
            html.append(obj.getDisplayTitle(lang));
            html.append("\", objid: \"");
            html.append(obj.getId());
            html.append("\", prspid: \"");
            html.append(obj.getTheme().getPerspective().getId());
            html.append("\", usrid: \"");
            html.append(obj.getSponsor()==null
                    ? SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","lblUnknown", locale)
                    : obj.getSponsor().getId());
            html.append("\"");
            html.append("}");
            html.append( objs.hasNext()?",\n":"\n" );
        }
        html.append("];\n");

        //data store de periodos
        Period period;
        List<Period> periods = bsc.listValidPeriods();
        Collections.sort(periods);
        Iterator<Period> ps = periods.iterator();
        html.append("var ps_ = [\n");
        while(ps.hasNext()) {
            period = ps.next();
            html.append("{name: \"");
            html.append(period.getDisplayTitle(lang));
            html.append("\", pid: \"");
            html.append(period.getId());
            html.append("\"");
            html.append("}");
            html.append( ps.hasNext()?",\n":"\n" );
        }
        html.append("];\n");

        html.append("require([\n");
        html.append("        'dojo/store/Memory',\n");
        html.append("        'dijit/form/ComboBox', 'dijit/form/FilteringSelect',\n");
        html.append("        'dojo/domReady!'\n");
        html.append("    ], function(Memory, FilteringSelect) {\n");

        // objetivos
        html.append("    new dijit.form.FilteringSelect({\n");
        html.append("        id: 'obj',\n");
        html.append("        store: new Memory({ idProperty: 'objid', data: objs_ }),\n");
        html.append("        autoComplete: true,\n");
        html.append("        query: {objid: /.*/},\n");
        //html.append("        style: 'width: 100%;',\n");
        html.append("        class: 'form-control',\n");
        html.append("        required: false,\n");
        html.append("        promptMessage: 'Objetivo de consulta',\n");
        html.append("        invalidMessage: 'Objetivo no reconocido',\n");
        //html.append("        missingMessage: 'Perspectiva es requerida',\n");
        html.append("        tooltipPosition:['after','above']");
        //html.append("        ,\n");
        //html.append("        onChange: function(state) {\n");
        //html.append("            alert('hola perspectiva id='+state);\n");
        //html.append("        }\n");
        html.append("    }, 'obj').startup();\n");

        // sponsors
        html.append("    new dijit.form.FilteringSelect({\n");
        html.append("        id: 'spr',\n");
        html.append("        store: new Memory({ idProperty: 'usrid', data: sprs_ }),\n");
        html.append("        autoComplete: true,\n");
        html.append("        query: {usrid: /.*/},\n");
        //html.append("        style: 'width: 100%;',\n");
        html.append("        class: 'form-control',\n");
        html.append("        required: false,\n");
        html.append("        promptMessage: 'Sponsor de consulta',\n");
        html.append("        invalidMessage: 'Sponsor no reconocido',\n");
        //html.append("        missingMessage: 'requerido',\n");
        html.append("        tooltipPosition:['after','above'],\n");
        html.append("        onChange: function(state) {\n");
        //html.append("            alert('sponsor='+this.item.usrid+'; perspectiva'+dijit.byId('prsp').item.prspid);\n");
        html.append("          dijit.byId('obj').set('value',null);");
        html.append("          dijit.byId('obj').query.usrid = this.item.usrid;");
        //html.append("          dijit.byId('obj').query.usrid=this.item.usrid && dijit.byId('obj').query.prspid=dijit.byId('prsp').item.prspid;");
        html.append("        }\n");
        html.append("    }, 'spr').startup();\n");

        // perspectivas
        html.append("    new dijit.form.FilteringSelect({\n");
        html.append("        id: 'prsp',\n");
        html.append("        store: new Memory({ idProperty: 'prspid', data: prsps_ }),\n");
        html.append("        autoComplete: true,\n");
        html.append("        query: {prspid: /.*/},\n");
        //html.append("        style: 'width: 100%;',\n");
        html.append("        class: 'form-control',\n");
        html.append("        required: true,\n");
        html.append("        promptMessage: 'Perspectiva de consulta',\n");
        html.append("        invalidMessage: 'Perspectiva de consulta no reconocido',\n");
        html.append("        missingMessage: 'Perspectiva de consulta es requerida',\n");
        html.append("        tooltipPosition:['after','above'],\n");
        html.append("        onChange: function(state) {\n");
        html.append("          dijit.byId('spr').set('value',null);");
        html.append("          dijit.byId('obj').set('value',null);");
        html.append("          dijit.byId('obj').query.prspid = this.item.prspid;");
        html.append("        }\n");
        html.append("    }, 'prsp').startup();\n");

        // periodos hasta
        html.append("    new dijit.form.FilteringSelect({\n");
        html.append("        id: 'pto',\n");
        html.append("        store: new Memory({ idProperty: 'pid', data: ps_ }),\n");
        html.append("        autoComplete: true,\n");
        html.append("        query: {pid: /.*/},\n");
        //html.append("        style: 'width: 100%;',\n");
        html.append("        class: 'form-control',\n");
        html.append("        required: true,\n");
        html.append("        promptMessage: 'Período inicial de consulta',\n");
        html.append("        invalidMessage: 'Período inicial de consulta no reconocido',\n");
        html.append("        missingMessage: 'Período inicial de consulta es requerido',\n");
        html.append("        tooltipPosition:['after','above'],\n");
        html.append("        onChange: function(state) {\n");
        html.append("          dijit.byId('pfr').query.pid <= this.item.pid;");
        html.append("        }\n");
        html.append("    }, 'pto').startup();\n");

        // periodos desde
        html.append("    new dijit.form.FilteringSelect({\n");
        html.append("        id: 'pfr',\n");
        html.append("        store: new Memory({ idProperty: 'pid', data: ps_ }),\n");
        html.append("        autoComplete: true,\n");
        html.append("        query: {pid: /.*/},\n");
        //html.append("        style: 'width: 100%;',\n");
        html.append("        class: 'form-control',\n");
        html.append("        required: true,\n");
        html.append("        promptMessage: 'Período terminal de consulta',\n");
        html.append("        invalidMessage: 'Período terminal de consulta no reconocido',\n");
        html.append("        missingMessage: 'Período terminal de consulta es requerido',\n");
        html.append("        tooltipPosition:['after','above'],\n");
        html.append("        onChange: function(state) {\n");
        //html.append("          dijit.byId('pto').store.query(function(object){return object.pid > state; });");
        html.append("          dijit.byId('pto').query.pid >= this.item.pid;");

        //html.append("this.store.query(function(object){\n");
        //html.append("console.log('object=', object.pid, 'state=', state, 'mayor?', object.pid>state);");
        //html.append(" return object.pid > state;\n");
        //html.append("})\n");
        html.append("        }\n");
        html.append("    }, 'pfr').startup();\n");
        html.append("});\n"); // require

        html.append("</script>\n");
                
        html.append("<div class=\"panel panel-default panel-detalle\">\n");
        html.append(" <div class=\"panel-heading head-detalle\">"
                +getResourceBase().getDisplayTitle(lang)+"</div>\n");
        html.append(" <div class=\"panel-body body-detalle\">\n");
        //html.append("  <div class=\"table-responsive\">\n");
        html.append("  <div class=\"container-fluid\">\n");
        html.append("   <div class=\"row\">\n");
        
        //html.append("<form  id=\"repfrm\" action=\"url\" method=\"post\" dojoType=\"dijit.form.Form\" role=\"form\" >\n");        
        html.append("<div class=\"col-sm-4 col-xs-12\">\n");
        html.append(" <div class=\"form-group\">\n");
        html.append("  <label for=\"prsp\">Perspectiva:</label>");
        html.append("  <input type=\"text\" id=\"prsp\" />");
        html.append(" </div>\n");
        html.append("</div>\n");

        html.append("<div class=\"col-sm-4 col-xs-12\">\n");
        html.append(" <div class=\"form-group\">\n");
        html.append("  <label for=\"spr\">Sponsor:</label>");
        html.append("  <input type=\"text\" id=\"spr\" />");
        html.append(" </div>\n");
        html.append("</div>\n");

        html.append("<div class=\"col-sm-4 col-xs-12\">\n");
        html.append(" <div class=\"form-group\">\n");
        html.append("  <label for=\"obj\">Objetivo:</label>");
        html.append("  <input type=\"text\" id=\"obj\" />");
        html.append(" </div>\n");
        html.append("</div>\n");

        html.append("<div class=\"col-sm-4 col-xs-12\">\n");
        html.append(" <div class=\"form-group\">\n");
        html.append("  <label for=\"pfr\">Desde el período:</label>");
        html.append("  <input type=\"text\" id=\"pfr\" />");
        html.append(" </div>\n");
        html.append("</div>\n");

        html.append("<div class=\"col-sm-4 col-xs-12\">\n");
        html.append(" <div class=\"form-group\">\n");
        html.append("  <label for=\"pto\">Hasta el período:</label>");
        html.append("  <input type=\"text\" id=\"pto\" />");
        html.append(" </div>\n");
        html.append("</div>\n");

        SWBResourceURL url = paramRequest.getRenderUrl();
        url.setCallMethod(paramRequest.Call_DIRECT);
        url.setMode(paramRequest.Mode_INDEX);
        html.append("<div class=\"col-sm-4 col-xs-12\">\n");
        html.append(" <div class=\"form-group\">\n");
        html.append("  <button type=\"button\" data-dojo-type=\"dijit/form/Button\" ");
        html.append(" onclick=\"getData('"+url+"?prsp='+dijit.byId('prsp').get('value')+'&spr='+dijit.byId('spr').get('value')+'&obj='+dijit.byId('obj').get('value')+'&pto='+dijit.byId('pto').get('value')+'&pfr='+dijit.byId('pfr').get('value'))\"");
        html.append(" class=\"btn btn-primary\">");
        html.append("  Enviar");
        html.append("  </button>");
        html.append(" </div>\n");
        html.append("</div>\n");
        //html.append("</form>\n");

        //html.append("<div id=\"rep_cntr\">\n");
        //html.append(" <div id=\"").append(SVG_ID).append("\" class=\"with-3d-shadow with-transitions\" style=\"float:left;width:100%;height:100%;\">\n");
        html.append("<div class=\"clearfix\"></div>");
        html.append(" <div id=\"").append(SVG_ID).append("\" class=\"row\" >\n");
        //html.append("  <div class=\"centerSvg\">\n");
        //html.append("   <svg style=\"height: 300px");
        //html.append(graphHeight);
        //html.append("; width: 400px");
        //html.append(graphWidth);
        //html.append(";\"></svg>\n");
        //html.append("  </div>\n");
        html.append(" </div>\n");
        //html.append("</div>\n");
        
        html.append("   </div> <!-- /.container-fluid -->\n");
        html.append("  </div> <!-- /.row -->\n");
        //html.append("  </div> <!-- /.table-responsive -->\n");
        html.append(" </div> <!-- /.panel-body body-detalle -->\n");
        html.append("</div> <!-- /.panel panel-default panel-detalle -->\n");
        
        response.getWriter().println(html.toString());
        response.flushBuffer();
    }

    @Override
    public void doIndex(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        final String lang = paramRequest.getUser().getLanguage();
        
        String prspId, usrId, objId, pfrId, ptoId;
        prspId = request.getParameter("prsp")==null?"":request.getParameter("prsp");
        usrId = request.getParameter("spr");
        objId = request.getParameter("obj");
        pfrId = request.getParameter("pfr");
        ptoId = request.getParameter("pto");

        //StringBuilder output = new StringBuilder();

        BSC bsc = (BSC)paramRequest.getWebPage().getWebSite();
        if(prspId.isEmpty() || (!prspId.isEmpty() && Perspective.ClassMgr.hasPerspective(prspId, bsc)) ) {
            Perspective perspective = Perspective.ClassMgr.getPerspective(prspId, bsc);
            User sponsor;
            if(bsc.getUserRepository().hasUser(usrId)) {
                sponsor = bsc.getUserRepository().getUser(usrId);
            }else {
                sponsor = null;
            }
            if(Objective.ClassMgr.hasObjective(objId, bsc)) {
                Objective obj = Objective.ClassMgr.getObjective(objId, bsc);
                if(Period.ClassMgr.hasPeriod(pfrId, bsc)) {
                    Period pfr = Period.ClassMgr.getPeriod(pfrId, bsc);
                    if(Period.ClassMgr.hasPeriod(ptoId, bsc)) {
                        Period pto = Period.ClassMgr.getPeriod(ptoId, bsc);
                        if(pto.compareTo(pfr)>=0) {
                            JSONObject objectiveData, indicatorData, seriesData, value;
                            JSONArray indicators, serieses, values;
                            
                            objectiveData = new JSONObject();
                            indicators = new JSONArray();
                            try {
                                objectiveData.put("title", obj.getDisplayTitle(lang));
                            }catch(JSONException jsone) {

                            }
                            
                            Indicator indicator;
                            Iterator<Indicator> indicatorItr = obj.listValidIndicators().iterator();
                            while(indicatorItr.hasNext()) {
                                indicator = indicatorItr.next();
                                indicatorData = new JSONObject();
                                
                                if(indicator.getStar()==null || !indicator.getStar().isValid()) {
                                    continue;
                                }
                                if(indicator.getStar().getFormat()==null) {
                                    try {
                                        indicatorData.put("format", paramRequest.getLocaleString("lblIndex"));
                                    }catch(JSONException jsone) {
                                    }
                                }else {
                                    try {
                                        indicatorData.put("format", indicator.getStar().getFormat().getDisplayTitle(lang));
                                    }catch(JSONException jsone) {
                                    }
                                }
                                
                                try {
                                    indicatorData.put("title", indicator.getDisplayTitle(lang));
                                }catch(JSONException jsone) {
                                    continue;
                                }
                                
                                List<Series> seriesLst = indicator.listValidSerieses();
                                Collections.sort(seriesLst);
                                Iterator<Series> seriesesItr = seriesLst.iterator();
                                if(seriesesItr.hasNext())
                                {
                                    serieses = new JSONArray();
                                    //values = new JSONArray();
                                    int colorIndex = -1;
                                    while(seriesesItr.hasNext()) 
                                    {
                                        Series graphSeries = seriesesItr.next();
                                        seriesData = new JSONObject();
                                        try {
                                            seriesData.put("key", graphSeries.getDisplayTitle(lang));
                                        }catch(JSONException jsone) {
                                        }
                                        
                                        colorIndex = ++colorIndex % ColorPalette.length;
                                        try {
                                            seriesData.put("color", ColorPalette[colorIndex]);
                                        }catch(JSONException jsone) {
                                        }
                                        
                                        //Recorre los periodos y valores de la serie para graficarlos
                                        Period aux;
                                        List<Period> vperiods = bsc.listValidPeriods();
                                        Collections.sort(vperiods);
                                        try {
                                            vperiods = vperiods.subList(vperiods.indexOf(pfr), vperiods.indexOf(pto));
                                        }catch(Exception e) {
                                        }finally{
                                            vperiods.add(pto);
                                        }
                                        values = new JSONArray();
                                        Iterator<Period> periods = vperiods.iterator();
                                        while(periods.hasNext())
                                        {
                                            aux = periods.next();
                                            Measure measure = graphSeries.getMeasure(aux);
                                            
                                            value = new JSONObject();
                                            try {    
                                                value.put("label", aux.getDisplayTitle(lang));
                                            }catch(JSONException jsone) {
                                            }
                                            try
                                            {
                                                if( !Float.isNaN(measure.getValue()) ) {
                                                    value.put("value", measure.getValue());
                                                }else {
                                                    value.put("value", 0.0);
                                                }
                                            }catch(JSONException jsone) {
                                            }catch (Exception e) {
                                                try {
                                                    value.put("value", 0.0);
                                                }catch(JSONException jsone) {
                                                }
                                            }
                                            values.put(value);
                                        }
                                        try {
                                            seriesData.put("values", values);
                                        }catch(JSONException jsone) {
                                            continue;
                                        }
                                        serieses.put(seriesData);
                                    }
                                    try {
                                        indicatorData.put("data", serieses);
                                    }catch(JSONException jsone) {
                                        continue;
                                    }
                                }
                                indicators.put(indicatorData);
                            } // while
                            try {
                                objectiveData.put("indicators", indicators);
                            }catch(JSONException jsone) {
                            }
                            
                            PrintWriter out = response.getWriter();
                            out.write(objectiveData.toString());
                        } // comparator
                    }
                }
            }
        }
        response.flushBuffer();
    }
    
    @Override
    public String doComponentExport(HttpServletRequest request, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException
    {
        return null;
    }
}
