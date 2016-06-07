package org.semanticwb.bsc.resources.charts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.SM;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.Series;
import org.semanticwb.bsc.utils.BSCUtils;
import static org.semanticwb.bsc.utils.BSCUtils.ColorPalette;
import org.semanticwb.bsc.utils.InappropriateFrequencyException;
import org.semanticwb.bsc.utils.UndefinedFrequencyException;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author carlos.ramos, ana.garcias
 */
public class GraphIndicatorsSerieStar extends GenericAdmResource {
    private static final org.semanticwb.Logger log = SWBUtils.getLogger(GraphGeneration.class);
    private static  String SVG_ID;

    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        SVG_ID = "_"+getResourceBase().getId();
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        final String suri = request.getParameter("suri");
        if(suri==null) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNoSuchSemanticElement")+"</div>");
            response.flushBuffer();
            return;
        }
        SemanticObject semanticObj = SemanticObject.getSemanticObject(suri);
        if(semanticObj==null || !(semanticObj.getGenericInstance() instanceof Objective)) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNoSuchSemanticElement")+"</div>");
            return;
        }
        GenericObject genericObj = semanticObj.createGenericInstance();
        final User user = paramRequest.getUser();
        if(!user.isSigned() || !user.haveAccess(genericObj))     {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgUserHasNotPermissions")+"</div>");
            response.flushBuffer();
            return;
        }
        
        PrintWriter out = response.getWriter();
        Resource base = getResourceBase();
        
        StringBuilder output = new StringBuilder();
        StringBuilder firstOutput = new StringBuilder();
        StringBuilder svgOutput = new StringBuilder();
        
        final String lang = user.getLanguage();
        final String graphHeight = base.getAttribute("graphPSHeight", "400px");
        final String graphWidth = base.getAttribute("graphPSWidth", "100%");
        final String marginLeftH = base.getAttribute("marginLeftH", "125");
        final String marginRightH = base.getAttribute("marginRightH", "20");
        final String marginTopH = base.getAttribute("marginTopH", "30");
        final String marginBottomH = base.getAttribute("marginBottomH", "40");
        final String marginLeftV = base.getAttribute("marginLeftV", "125");
        final String marginRightV = base.getAttribute("marginRightV", "20");
        final String marginTopV = base.getAttribute("marginTopV", "10");
        final String marginBottomV = base.getAttribute("marginBottomVt", "110");
        final String rotateLabels = base.getAttribute("rotateLabelV", "-80");
        
//        if(genericObj instanceof Objective) {
            Objective objective = (Objective)genericObj;
            out.println("<div class=\"panel panel-default panel-detalle\">\n");
            out.println(" <div id=\""+SVG_ID+"\" class=\"with-3d-shadow with-transitions\">\n");
            out.println("  <div class=\"panel-heading head-detalle\">");
            out.println(paramRequest.getLocaleString("msgTitle"));
            out.println("&nbsp;");
            out.println(objective.getDisplayTitle(lang));
            out.println("  </div>\n");
//            out.println("  <div class=\"panel-body body-detalle\">\n");
//            out.println("   <div class=\"centerSvg\">\n");
//            out.println("    <input type=\"radio\" name=\"graphType")
//                    .append(SVG_ID).append("\" id=\"hGraph").append(SVG_ID)
//                    .append("\" value=\"1\" onclick=\"showGraph(this);\" checked=\"checked\"><label for=\"hGraph")
//                    .append(SVG_ID).append("\">");
//            out.println(paramRequest.getLocaleString("lblLandscape")).append("</label>\n");
//            out.println("    <input type=\"radio\" name=\"graphType")
//                    .append(SVG_ID).append("\" id=\"vGraph").append(SVG_ID)
//                    .append("\" value=\"2\" onclick=\"showGraph(this);\"><label for=\"vGraph")
//                    .append(SVG_ID).append("\">");
//            out.println(paramRequest.getLocaleString("lblNarrow")).append("</label>\n");
            out.println("   </div>\n");
            out.println("  </div>\n");
            
            List<Indicator> indicatorLst = objective.listValidIndicators();
            if( !indicatorLst.isEmpty() )
            {
                Collections.sort(indicatorLst, new SortByMeasurementFrequency());
                
                JSONObject objectiveData, indicatorData, seriesData, value;
                JSONArray indicators, serieses, values;

                objectiveData = new JSONObject();
                indicators = new JSONArray();
                try {
                    objectiveData.put("title", objective.getDisplayTitle(lang));
                }catch(JSONException jsone) {

                }
                
                Iterator<Period> measurablesPeriods;
                Period p;
                Indicator indicator;
                Iterator<Indicator> indicatorItr = indicatorLst.iterator();
                while(indicatorItr.hasNext())
                {
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
                            values = new JSONArray();
                            try {
                                measurablesPeriods = indicator.listMeasurablesPeriods();
                            }catch(UndefinedFrequencyException ude) {
                                continue;
                            }catch(InappropriateFrequencyException iae) {
                                continue;
                            }
                            while(measurablesPeriods.hasNext())
                            {
                                p = measurablesPeriods.next();
                                if(p.isCurrent() || p.isFuture()) {
                                    break;
                                }
                                
                                Measure measure = graphSeries.getMeasure(p);
                                value = new JSONObject();
                                try {    
                                    value.put("label", p.getDisplayTitle(lang));
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
                }
                try {
                    objectiveData.put("indicators", indicators);
                }catch(JSONException jsone) {
                }
                
StringBuilder html = new StringBuilder();
try {
for(int i=0; i<objectiveData.getJSONArray("indicators").length(); i++)
{
    html.append("      var chart_"+i+" = nv.models.multiBarChart();\n");
    html.append("      chart_"+i+".x(function(d) { return d.label });\n");
    html.append("      chart_"+i+".y(function(d) { return d.value });\n");
    //html.append("      chart_"+i+".width(500);\n");
    //html.append("      chart_"+i+".height(500);\n");
    html.append("      chart_"+i+".margin({top:5, right:60, bottom:170, left:110});\n");
    html.append("      chart_"+i+".rotateLabels("+rotateLabels+");\n");
    html.append("      chart_"+i+".showControls(true);\n");
    html.append("      chart_"+i+".groupSpacing(0.1);\n");
    html.append("      chart_"+i+".transitionDuration(500);\n");
    html.append("      chart_"+i+".reduceXTicks(false);\n");
    html.append("      chart_"+i+".staggerLabels(true);\n");
    html.append("      chart_"+i+".stacked(false);\n");
    html.append("      chart_"+i+".showLegend(true);\n");
    html.append("      chart_"+i+".tooltips(true);\n");

    html.append("      chart_"+i+".tooltipContent(function (key, y, e, graph) {\n");
    html.append("            var content = '<p style=\"text-align: center; font-size: 1.2em;"
            + " font-weight: bolder;\">';\n");
    html.append("            content += key + '</p><p style=\"text-align: center;"
            + " font-size: 1.2em; font-weight: normal;\">' + e + \" "+paramRequest.getLocaleString("lblIn")
            +" \" + y + '</p>';\n");
    html.append("            return content;\n");
    html.append("      });\n");
    //        html.append("      chart_"+i+".controlLabels({ \"stacked\": \"")
    //                .append(paramRequest.getLocaleString("lblStackedControlLabel"))
    //                .append("\",\"grouped\": \"")
    //                .append(paramRequest.getLocaleString("lblGroupedControlLabel"))
    //                .append("\" });\n");
    html.append("      chart_"+i+".showLegend(true);\n");
    //        html.append("  chart_"+i+".xAxis.axisLabel('Períodos de mediciones');\n");
    //        html.append("  chart_"+i+".xAxis.axisLabelDistance(35);\n");
    //        html.append("  chart_"+i+".xAxis.showMaxMin(true);\n");
    //        html.append("  chart_"+i+".yAxis.axisLabel('Valores')\n");
    //        html.append("  chart_"+i+".yAxis.axisLabelDistance(20)\n");
    html.append("      chart_"+i+".yAxis.tickFormat(d3.format(',.2f'));\n");
    //        html.append("      chart_"+i+".yAxis.showMaxMin(true);\n");

    //html.append("      d3.select('#"+SVG_ID+"').append('div').attr('class', '__col-md-6')"
    html.append("      d3.select('#"+SVG_ID+"').append('div').attr('id','"+SVG_ID+"_cntnr_"+i+"')"
            + ".attr('style','height:300px;');\n");
    html.append("      d3.select('#"+SVG_ID+"_cntnr_"+i+"').append('h5').text('"
            +paramRequest.getLocaleString("lblKPI")
            +": "+objectiveData.getJSONArray("indicators").getJSONObject(i).getString("title")+" ("+objectiveData.getJSONArray("indicators").getJSONObject(i).getString("format")+")');\n");
    html.append("      d3.select('#"+SVG_ID+"_cntnr_"+i+"')"
            + ".append('svg').attr('id','"+SVG_ID+"_"+i+"')"
            + ".attr('width','100%').attr('height','100%')\n");
    html.append("          .datum("+objectiveData.getJSONArray("indicators").getJSONObject(i).getJSONArray("data")+")\n");
    html.append("          .call(chart_"+i+");\n");
    html.append("      nv.utils.windowResize(chart_"+i+".update);\n");
}
out.println("<script type=\"text/javascript\">\n");
out.println(html.toString());
out.println("</script>");
}catch(JSONException jse) {
}
                
//                int colorIndex = -1;
//                output.append("<script type=\"text/javascript\">\n");
//                output.append("long_short_data2 = [\n");
//                SortedSet<Period> periods = new TreeSet<Period>();
//                Period p;
//                Indicator indicator;
//                Iterator<Period> measurablesPeriods;
//                while(indicators.hasNext())
//                {
//                    indicator = indicators.next();
//                    try {
//                        periods.addAll(SWBUtils.Collections.copyIterator(indicator.listMeasurablesPeriods()));
//                    }catch(UndefinedFrequencyException ex) {
//                        log.error(ex);
//                        continue;
//                    }catch(InappropriateFrequencyException ex) {
//                        log.error(ex);
//                        continue;
//                    }
//                    measurablesPeriods = periods.iterator();
//                    Series star = indicator.getStar();
//                    if(null==star || !measurablesPeriods.hasNext()) {
//                        continue;
//                    }
//                    if(!star.isValid()) {
//                        continue;
//                    }
//                    output.append("{");
//                    output.append("  key: \"");
//                    output.append(star.getDisplayTitle(lang));
//                    output.append(" ");
//                    output.append(indicator.getDisplayTitle(lang));
//                    output.append("\" ,\n");
//
//                    colorIndex = ++colorIndex % ColorPalette.length;
//                    output.append("  color: '");
//                    output.append(BSCUtils.ColorPalette[colorIndex]);
//                    output.append("',\n");
//                    output.append("  values: [\n");
//                    while(measurablesPeriods.hasNext())
//                    {
//                        p = measurablesPeriods.next();
//                        if(p.isCurrent() || p.isFuture()) {
//                            break;
//                        }
//                        Measure measure = star.getMeasure(p);
//                        output.append("{");
//                        output.append(" \"label\": \"");
//                        output.append(p.getDisplayTitle(lang));
//                        output.append("\", ");
//                        if(measure==null) {
//                            output.append("\"value\": 0.0 ");
//                        }else {
//                            output.append("\"value\": ");
//                            output.append(measure.getValue());
//                        }
//                        output.append(measurablesPeriods.hasNext()?"},\n":"}\n");
//                    }
//                    output.append(indicators.hasNext()?"]},\n":"]}\n");
//                }
//                output.append("];\n");
//                output.append("var chartInd;\n");
//                output.append("var chart2Ind;\n");
//                output.append("nv.addGraph(function() {\n");
//                output.append("  chartInd = nv.models.multiBarHorizontalChart()\n");
//                output.append("      .x(function(d) { return d.label })\n");
//                output.append("      .y(function(d) { return d.value })\n");
//                output.append("    .margin({top: ");
//                output.append(marginTopH);
//                output.append(", right: ");
//                output.append(marginRightH);
//                output.append(", bottom: ");
//                output.append(marginBottomH);
//                output.append(", left: ");
//                output.append(marginLeftH);
//                output.append(" })\n");
//                output.append("    .transitionDuration(250)\n");
//                output.append("    .showControls(false);\n");
//                output.append("  chartInd.yAxis\n");
//                output.append("    .tickFormat(d3.format(',.3d'));\n");
//                output.append("  d3.select('#").append(SVG_ID).append(" svg')\n");
//                output.append("    .datum(long_short_data2)\n");
//                output.append("    .call(chartInd);\n");
//                output.append("  nv.utils.windowResize(chartInd.update);\n");
//                output.append("  return chartInd;\n");
//                output.append("});\n");
//                output.append("nv.addGraph(function() {\n");
//                output.append("  chart2Ind = nv.models.multiBarChart()\n");
//                output.append("      .x(function(d) { return d.label })\n");
//                output.append("      .y(function(d) { return d.value })\n");
//                output.append("    .margin({top: ");
//                output.append(marginTopV);
//                output.append(", right: ");
//                output.append(marginRightV);
//                output.append(", bottom: ");
//                output.append(marginBottomV);
//                output.append(", left: ");
//                output.append(marginLeftV);
//                output.append(" })\n");
//                output.append("      .transitionDuration(350)\n");
//                output.append("      .reduceXTicks(false)\n");   /*If 'false', every single x-axis tick label will be rendered.*/
//                output.append("      .rotateLabels(");
//                output.append(rotateLabels);
//                output.append(")\n");
//                output.append("      .staggerLabels(true)\n");     /*Intercala etiquetas en el eje 1 arriba, 1 abajo.*/
//                output.append("      .showControls(true)\n");
//                output.append("      .groupSpacing(0.2);\n");    /*Distance between each group of bars.*/
//
//                output.append("  chart2Ind.yAxis\n");
//                output.append("      .tickFormat(d3.format(',.2d'));\n");
//                output.append("  return chart2Ind;\n");
//                output.append("});\n");
//                output.append("  function showGraph(radioBtn) {\n");
//                output.append("    if (radioBtn.value == 1 && radioBtn.checked) {\n");
//                output.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
//                output.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
//                output.append("        .datum(long_short_data2)\n");
//                output.append("        .call(chartInd);\n");
//                output.append("    } else if (radioBtn.value == 2 && radioBtn.checked) {\n");
//                output.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
//                output.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
//                output.append("        .datum(long_short_data2)\n");
//                output.append("        .call(chart2Ind);\n");
//                output.append("    }\n");
//                output.append("  }\n");
//                output.append("  </script>\n");
            }
            else
            {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">" 
                        + paramRequest.getLocaleString("msgNotIndicators") + "</div>");
                out.flush();
                return;
            }
//            svgOutput.append("<div class=\"panel-body body-detalle\">\n");
//            svgOutput.append(" <div class=\"centerSvg\">\n");
//            svgOutput.append("  <svg style=\"height:");
//            svgOutput.append(graphHeight);
//            svgOutput.append("; width:");
//            svgOutput.append(graphWidth);
//            svgOutput.append(";");
//            svgOutput.append("\"></svg>\n");
//            svgOutput.append(" </div>\n");
//            svgOutput.append("</div>\n");
//            out.println(firstOutput.toString());
//            out.println(svgOutput.toString());
//            out.println(output.toString());
//            out.println("  </div> <!-- //#chart1 -->");
//            out.println("</div> <!-- //.panel panel-default panel-detalle -->");
//        }
    }
}

class SortByMeasurementFrequency implements Comparator<Indicator>
{
    @Override
    public int compare(Indicator o1, Indicator o2)
    {
        if(o1.getPeriodicity()==null) {
            return -1;
        }
        if(o2.getPeriodicity()==null) {
            return 1;
        }
        return o1.getPeriodicity().getNumberOfPeriods() - o2.getPeriodicity().getNumberOfPeriods();
    }

}