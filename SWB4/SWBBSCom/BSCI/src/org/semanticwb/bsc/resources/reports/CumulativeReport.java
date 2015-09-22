package org.semanticwb.bsc.resources.reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.ComponentExportable;
import org.semanticwb.bsc.Perspective;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.catalogs.Format;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.Series;
import static org.semanticwb.bsc.utils.BSCUtils.ColorPalette;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.User;
import org.semanticwb.model.UserRepository;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

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
        StringBuilder html;
        html = new StringBuilder();
        
        html.append("<script>\n");
        html.append("require([\"dojo/parser\", \"dijit/form/Form\", \"dijit/form/ValidationTextBox\"\n"
                +", \"dijit/form/FilteringSelect\", \"dijit/form/CheckBox\", \"dijit/form/Button\"]);\n");

html.append("  var long_short_data;\n");
html.append("  var chart;\n");
html.append("  var chart2;\n");
html.append("nv.addGraph(function() {\n");
html.append("  chart = nv.models.multiBarHorizontalChart()\n");
html.append("      .x(function(d) { return d.label })\n");
html.append("      .y(function(d) { return d.value })\n");
html.append("    .margin({top: 30");
//html.append(marginTopH);
html.append(", right: 20");
//html.append(marginRightH);
html.append(", bottom: 40");
//html.append(marginBottomH);
html.append(", left: 125");
//html.append(marginLeftH);
html.append(" })\n");
html.append("    .transitionDuration(250)\n");
html.append("    .showControls(false);\n");    /*Allow user to switch between 'Grouped' and 'Stacked' mode.*/
html.append("  chart.yAxis\n");
html.append("    .tickFormat(d3.format(',.2f'));\n");
html.append("  d3.select('#").append(SVG_ID).append(" svg')\n");
html.append("    .datum(long_short_data)\n");
html.append("    .call(chart);\n");
html.append("  nv.utils.windowResize(chart.update);\n");
html.append("  return chart;\n");
html.append("});\n");
html.append("nv.addGraph(function() {\n");
html.append("  chart2 = nv.models.multiBarChart()\n");
html.append("    .x(function(d) { return d.label })\n");
html.append("    .y(function(d) { return d.value })\n");
html.append("    .margin({top: 10");
//html.append(marginTopV);
html.append(", right: 20");
//html.append(marginRightV);
html.append(", bottom: 110");
//html.append(marginBottomV);
html.append(", left: 125");
//html.append(marginLeftV);
html.append(" })\n");
html.append("    .transitionDuration(350)\n");
html.append("    .reduceXTicks(false)\n");   /*If 'false', every single x-axis tick label will be rendered.*/
html.append("    .rotateLabels(-80");
//html.append(rotateLabels);
html.append(")\n"); 
//html.append("    .staggerLabels(true)\n");   /*Intercala etiquetas en el eje 1 arriba, 1 abajo.*/
html.append("    .showControls(false)\n");    /*Allow user to switch between 'Grouped' and 'Stacked' mode.*/
html.append("    .groupSpacing(0.1);\n");    /*Distance between each group of bars.*/
html.append("  chart2.xAxis\n");
//html.append("      .axisLabel('ID of Furry Cat Households'')\n");
//html.append("      .axisLabelDistance(35)\n");
//html.append("      .showMaxMin(false)\n");
html.append("      .tickFormat(d3.format(',.2f'));\n");
//html.append("  chart2.yAxis\n");
//html.append("      .tickFormat(d3.format(',.2f'));\n");
html.append("  d3.select('#").append(SVG_ID).append(" svg')\n");
html.append("    .datum(long_short_data)\n");
html.append("    .call(chart2);\n");
html.append("  nv.utils.windowResize(chart2.update);\n");
html.append("  return chart2;\n");
html.append("});\n");

html.append("  function showGraph() {\n");
//html.append("    if(radioBtn.value == 1 && radioBtn.checked) {\n");
//html.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
//html.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
//html.append("        .datum(long_short_data)\n");
//html.append("        .call(chart);\n");
//html.append("    }else if(radioBtn.value == 2 && radioBtn.checked) {\n");
html.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
html.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
html.append("        .datum(long_short_data)\n");
html.append("        .call(chart2);\n");
//html.append("    }\n");
html.append("  }\n");

html.append("  function getData(url) {\n");
html.append("    dojo.xhrGet({\n");
html.append("      url: url,");
html.append("      handleAs: 'json',\n");
html.append("      preventCache: true,\n");
html.append("      load: function(dato, ioargs) {\n");
html.append("        long_short_data = dato;");
html.append("        showGraph();");
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
System.out.println("sponsor ug="+sponsor);
Iterator<User> usrs = ur.listUsers();
html.append("var sprs_ = [\n");
while(usrs.hasNext()) {
    usr = usrs.next();
System.out.println("usr="+usr.getLogin());
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
    html.append(obj.getSponsor().getId());
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
//html.append("        style: 'width: 150px;',\n");
html.append("        class: 'form-control',\n");
html.append("        required: false,\n");
html.append("        promptMessage: 'Objetivo',\n");
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
//html.append("        style: 'width: 150px;',\n");
html.append("        class: 'form-control',\n");
html.append("        required: false,\n");
html.append("        promptMessage: 'Sponsor',\n");
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
//html.append("        style: 'width: 150px;',\n");
html.append("        class: 'form-control',\n");
html.append("        required: true,\n");
html.append("        promptMessage: 'Perspectiva ',\n");
html.append("        invalidMessage: 'Perspectiva no reconocido',\n");
html.append("        missingMessage: 'Perspectiva es requerida',\n");
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
//html.append("        style: 'width: 150px;',\n");
html.append("        class: 'form-control',\n");
html.append("        required: true,\n");
html.append("        promptMessage: 'Período',\n");
html.append("        invalidMessage: 'Período no reconocido',\n");
html.append("        missingMessage: 'Período es requerida',\n");
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
//html.append("        style: 'width: 150px;',\n");
html.append("        class: 'form-control',\n");
html.append("        required: true,\n");
html.append("        promptMessage: 'Período',\n");
html.append("        invalidMessage: 'Período no reconocido',\n");
html.append("        missingMessage: 'Período es requerida',\n");
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
        html.append(" <div class=\"panel-heading head-detalle\">"+getResourceBase().getDisplayTitle(lang)+"</div>\n");
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
//html.append(" onclick=\"postHtml('"+url+"?prsp='+dijit.byId('prsp').get('value')+'&spr='+dijit.byId('spr').get('value')+'&obj='+dijit.byId('obj').get('value')+'&pto='+dijit.byId('pto').get('value')+'&pfr='+dijit.byId('pfr').get('value'),'rep_cntr')\"");
html.append(" onclick=\"getData('"+url+"?prsp='+dijit.byId('prsp').get('value')+'&spr='+dijit.byId('spr').get('value')+'&obj='+dijit.byId('obj').get('value')+'&pto='+dijit.byId('pto').get('value')+'&pfr='+dijit.byId('pfr').get('value'))\"");
html.append(" class=\"btn btn-primary\">");
html.append("  Enviar");
html.append("  </button>");
html.append(" </div>\n");
html.append("</div>\n");
//html.append("</form>\n");

//html.append("<div id=\"rep_cntr\">\n");
html.append(" <div id=\"").append(SVG_ID).append("\" class=\"with-3d-shadow with-transitions\" style=\"float:left;\">\n");
//html.append("  <div class=\"centerSvg\">\n");
html.append("   <svg style=\"height: 300px");
//html.append(graphHeight);
html.append("; width: 400px");
//html.append(graphWidth);
html.append(";\"></svg>\n");
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

StringBuilder output = new StringBuilder();

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
                            List<Indicator> indicators = obj.listValidIndicators();
                            for(Indicator indicator:indicators) {
                                
System.out.println("indicador="+indicator.getTitle());


List<Series> seriesLst = indicator.listValidSerieses();
Collections.sort(seriesLst);
Iterator<Series> serieses = seriesLst.iterator();
if(serieses.hasNext())
{
    int colorIndex = -1;
    //output.append("<script type=\"text/javascript\">\n");
    output.append("[\n");
    while(serieses.hasNext()) 
    {
        Series graphSeries = serieses.next();
//System.out.println("series="+graphSeries.getTitle());        
        Format seriesFormat = graphSeries.getFormat();
        output.append("{");
        //Se coloca el identificador de cada serie
        if(seriesFormat != null) {
            output.append("  key: \"");
            output.append(graphSeries.getDisplayTitle(lang));
            output.append(" en ");
            output.append(seriesFormat.getDisplayTitle(lang));
            output.append("\" ,\n");
        }else {
            output.append("  key: \"");
            output.append(graphSeries.getDisplayTitle(lang));
            output.append("\" ,\n");
        }
        colorIndex = ++colorIndex % ColorPalette.length;
        output.append("  color: '");
        output.append(ColorPalette[colorIndex]);
        output.append("',\n");
        output.append("  values: [\n");
        
        Period aux = pfr;
        int periodsCount = 0;
        //Recorre los periodos y valores de la serie para graficarlos
        do {
        //for(Period period : periodsList) {
//System.out.println("periodo="+aux.getTitle());
            Measure measure = graphSeries.getMeasure(aux);
            if (periodsCount > 0) {
                output.append(",\n");
            }
            output.append("    {");
            output.append(" \"label\" : \"");
            output.append(aux.getDisplayTitle(lang));
            output.append("\", ");
            output.append("\"value\" : ");
            try {
                if( !Float.isNaN(measure.getValue()) ) {
                //if (measure.getValue() != 0) {
                    output.append(measure.getValue());
                }
            } catch (Exception e) {
                //output.append("\"value\" : 0.0 ");
                output.append("0.0");
            }
            output.append(" }");
            periodsCount++;
            
            aux = aux.getNext();
        }while( aux!=null && aux.compareTo(pto)<=0 );
        
        output.append("  ]\n");
        output.append("}");
        output.append(serieses.hasNext()?",\n":"\n");
    }
    output.append("]");
    //output.append("</script>\n");
}
System.out.println("\n\njson:"+output);
PrintWriter out = response.getWriter();
out.write(output.toString());
                            }
                        }else {
System.out.println("5");
                            response.getWriter().write("periodo final es menor qe periodo inicial");
                        }
                    }else {
System.out.println("4");
                        response.getWriter().write("falta periodo final");
                    }
                }else {
System.out.println("3");
                    response.getWriter().write("falta periodo inicial");
                }
            }else {
System.out.println("2");
                response.getWriter().write("falta objetivo");
            }
        }else {
System.out.println("1");
            response.getWriter().write("falta perspectiva");
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
