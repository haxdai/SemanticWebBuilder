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
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.catalogs.Format;
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
        final User user = paramRequest.getUser();
        if(!user.isSigned() || !user.haveAccess(semanticObj.getGenericInstance()))     {
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
        
        GenericObject genericObj = semanticObj.createGenericInstance();
        if (genericObj instanceof Objective) {
            Objective objective = (Objective)genericObj;
            firstOutput.append("<div class=\"panel panel-default panel-detalle\">\n");
            firstOutput.append(" <div id=\"").append(SVG_ID).append("\" class=\'with-3d-shadow with-transitions\'>\n");
            firstOutput.append("  <div class=\"panel-heading head-detalle\">");
            firstOutput.append(paramRequest.getLocaleString("msgTitle"));
            firstOutput.append("&nbsp;");
            firstOutput.append(objective.getDisplayTitle(lang));
            firstOutput.append("  </div>\n");
            firstOutput.append("  <div class=\"panel-body body-detalle\">\n");
            firstOutput.append("   <div class=\"centerSvg\">\n");
            firstOutput.append("    <input type=\"radio\" name=\"graphType")
                    .append(SVG_ID).append("\" id=\"hGraph").append(SVG_ID)
                    .append("\" value=\"1\" onclick=\"showGraph(this);\" checked=\"checked\"><label for=\"hGraph")
                    .append(SVG_ID).append("\">");
            firstOutput.append(paramRequest.getLocaleString("lblLandscape")).append("</label>\n");
            firstOutput.append("    <input type=\"radio\" name=\"graphType")
                    .append(SVG_ID).append("\" id=\"vGraph").append(SVG_ID)
                    .append("\" value=\"2\" onclick=\"showGraph(this);\"><label for=\"vGraph")
                    .append(SVG_ID).append("\">");
            firstOutput.append(paramRequest.getLocaleString("lblNarrow")).append("</label>\n");
            firstOutput.append("   </div>\n");
            firstOutput.append("  </div>\n");
            
            List<Indicator> indicatorLst = objective.listValidIndicators();
            Collections.sort(indicatorLst, new SortByMeasurementFrequency());
            Iterator<Indicator> indicators = indicatorLst.iterator();
            if(indicators.hasNext())
            {
                int colorIndex = -1;
                output.append("<script type=\"text/javascript\">\n");
                output.append("long_short_data2 = [\n");
                SortedSet<Period> periods = new TreeSet<Period>();
                Period p;
                Indicator indicator;
                Iterator<Period> measurablesPeriods;
                while(indicators.hasNext())
                {
                    indicator = indicators.next();
                    try {
                        periods.addAll(SWBUtils.Collections.copyIterator(indicator.listMeasurablesPeriods()));
                    }catch(UndefinedFrequencyException ex) {
                        log.error(ex);
                        continue;
                    }catch(InappropriateFrequencyException ex) {
                        log.error(ex);
                        continue;
                    }
                    measurablesPeriods = periods.iterator();
                    Series star = indicator.getStar();
                    if(null==star || !measurablesPeriods.hasNext()) {
                        continue;
                    }
                    if(!star.isValid()) {
                        continue;
                    }
                    output.append("{");
                    output.append("  key: \"");
                    output.append(star.getDisplayTitle(lang));
                    output.append(" ");
                    output.append(indicator.getDisplayTitle(lang));
                    output.append("\" ,\n");

                    colorIndex = ++colorIndex % ColorPalette.length;
                    output.append("  color: '");
                    output.append(BSCUtils.ColorPalette[colorIndex]);
                    output.append("',\n");
                    output.append("  values: [\n");
                    while(measurablesPeriods.hasNext())
                    {
                        p = measurablesPeriods.next();
                        if(p.isCurrent() || p.isFuture()) {
                            break;
                        }
                        Measure measure = star.getMeasure(p);
                        output.append("{");
                        output.append(" \"label\": \"");
                        output.append(p.getDisplayTitle(lang));
                        output.append("\", ");
                        if(measure==null) {
                            output.append("\"value\": 0.0 ");
                        }else {
                            output.append("\"value\": ");
                            output.append(measure.getValue());
                        }
                        output.append(measurablesPeriods.hasNext()?"},\n":"}\n");
                    }
                    output.append(indicators.hasNext()?"]},\n":"]}\n");
                }
                output.append("];\n");
                output.append("var chartInd;\n");
                output.append("var chart2Ind;\n");
                output.append("nv.addGraph(function() {\n");
                output.append("  chartInd = nv.models.multiBarHorizontalChart()\n");
                output.append("      .x(function(d) { return d.label })\n");
                output.append("      .y(function(d) { return d.value })\n");
                output.append("    .margin({top: ");
                output.append(marginTopH);
                output.append(", right: ");
                output.append(marginRightH);
                output.append(", bottom: ");
                output.append(marginBottomH);
                output.append(", left: ");
                output.append(marginLeftH);
                output.append(" })\n");
                output.append("    .transitionDuration(250)\n");
                output.append("    .showControls(false);\n");
                output.append("  chartInd.yAxis\n");
                output.append("    .tickFormat(d3.format(',.3d'));\n");
                output.append("  d3.select('#").append(SVG_ID).append(" svg')\n");
                output.append("    .datum(long_short_data2)\n");
                output.append("    .call(chartInd);\n");
                output.append("  nv.utils.windowResize(chartInd.update);\n");
                output.append("  return chartInd;\n");
                output.append("});\n");
                output.append("nv.addGraph(function() {\n");
                output.append("  chart2Ind = nv.models.multiBarChart()\n");
                output.append("      .x(function(d) { return d.label })\n");
                output.append("      .y(function(d) { return d.value })\n");
                output.append("    .margin({top: ");
                output.append(marginTopV);
                output.append(", right: ");
                output.append(marginRightV);
                output.append(", bottom: ");
                output.append(marginBottomV);
                output.append(", left: ");
                output.append(marginLeftV);
                output.append(" })\n");
                output.append("      .transitionDuration(350)\n");
                output.append("      .reduceXTicks(false)\n");   /*If 'false', every single x-axis tick label will be rendered.*/
                output.append("      .rotateLabels(");
                output.append(rotateLabels);
                output.append(")\n");
                output.append("      .staggerLabels(true)\n");     /*Intercala etiquetas en el eje 1 arriba, 1 abajo.*/
                output.append("      .showControls(true)\n");
                output.append("      .groupSpacing(0.2);\n");    /*Distance between each group of bars.*/

                output.append("  chart2Ind.yAxis\n");
                output.append("      .tickFormat(d3.format(',.2d'));\n");
                output.append("  return chart2Ind;\n");
                output.append("});\n");
                output.append("  function showGraph(radioBtn) {\n");
                output.append("    if (radioBtn.value == 1 && radioBtn.checked) {\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
                output.append("        .datum(long_short_data2)\n");
                output.append("        .call(chartInd);\n");
                output.append("    } else if (radioBtn.value == 2 && radioBtn.checked) {\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
                output.append("        .datum(long_short_data2)\n");
                output.append("        .call(chart2Ind);\n");
                output.append("    }\n");
                output.append("  }\n");
                output.append("  </script>\n");
            }
            else
            {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">" 
                        + paramRequest.getLocaleString("msgNotIndicators") + "</div>");
                out.flush();
                return;
            }
            svgOutput.append("<div class=\"panel-body body-detalle\">\n");
            svgOutput.append(" <div class=\"centerSvg\">\n");
            svgOutput.append("  <svg style=\"height:");
            svgOutput.append(graphHeight);
            svgOutput.append("; width:");
            svgOutput.append(graphWidth);
            svgOutput.append(";");
            svgOutput.append("\"></svg>\n");
            svgOutput.append(" </div>\n");
            svgOutput.append("</div>\n");
            out.println(firstOutput.toString());
            out.println(svgOutput.toString());
            out.println(output.toString());
            out.println("  </div> <!-- //#chart1 -->");
            out.println("</div> <!-- //.panel panel-default panel-detalle -->");
        }
    }
}

class SortByMeasurementFrequency implements Comparator<Indicator>
{
    @Override
    public int compare(Indicator o1, Indicator o2)
    {
        return o1.getPeriodicity().getNumberOfPeriods() - o2.getPeriodicity().getNumberOfPeriods();
    }

}