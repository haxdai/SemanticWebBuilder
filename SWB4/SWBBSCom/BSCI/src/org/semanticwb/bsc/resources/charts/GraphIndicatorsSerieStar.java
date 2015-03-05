/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.semanticwb.bsc.resources.charts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.catalogs.Format;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.Series;
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
 * @author ana.garcias
 */
public class GraphIndicatorsSerieStar extends GenericAdmResource {

    private static final String[] colors = {
        "#0431B4", "#5882FA", "#58FAF4", "#A9A9F5", "#D0A9F5", "#AC58FA"};

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        final String suri = request.getParameter("suri");
        SemanticObject semanticObj = SemanticObject.getSemanticObject(suri);
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        Resource base = getResourceBase();
        final User user = paramRequest.getUser();
        PrintWriter out = response.getWriter();
        StringBuilder output = new StringBuilder(512);
        StringBuilder firstOutput = new StringBuilder(128);
        StringBuilder svgOutput = new StringBuilder(64);
        StringBuilder usedColors = new StringBuilder(32);
        String graphHeight = base.getAttribute("graphPSHeight", "400px");
        String graphWidth = base.getAttribute("graphPSWidth", "100%");
        String marginLeftH = base.getAttribute("marginLeftH", "125");
        String marginRightH = base.getAttribute("marginRightH", "20");
        String marginTopH = base.getAttribute("marginTopH", "30");
        String marginBottomH = base.getAttribute("marginBottomH", "40");
        String marginLeftV = base.getAttribute("marginLeftV", "125");
        String marginRightV = base.getAttribute("marginRightV", "20");
        String marginTopV = base.getAttribute("marginTopV", "10");
        String marginBottomV = base.getAttribute("marginBottomVt", "110");
        String rotateLabels = base.getAttribute("rotateLabelV", "-80");

        if (suri == null) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">" + paramRequest.getLocaleString("msgNoSuchSemanticElement") + "</div>");
            response.flushBuffer();
            return;
        }
        if (!user.isSigned() || !user.haveAccess(semanticObj.getGenericInstance())) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">" + paramRequest.getLocaleString("msgUserHasNotPermissions") + "</div>");
            response.flushBuffer();
            return;
        }

        if (semanticObj != null) {
            GenericObject genericObj = semanticObj.createGenericInstance();
            if (genericObj instanceof Objective) {

                Objective objective = (Objective) genericObj;
                List<Period> periodsList = new java.util.ArrayList<Period>();
                Iterator<Period> listPeriodIndic = null;

                //Codigo HTML para generar la grafica
                firstOutput.append("<div class=\"row\">\n");
                firstOutput.append("<div class=\"col-xs-12\">\n");
                firstOutput.append("<div class=\"panel panel-default panel-detalle\">\n");

                firstOutput.append("<div id=\"graphContainer\">\n");
                firstOutput.append("   <div id=\"chart1Ind\" class=\'with-3d-shadow with-transitions\'>\n");
                firstOutput.append("       <div class=\"panel-heading head-detalle\">");
                firstOutput.append(paramRequest.getLocaleString("msgTitle") + ": " + objective.getTitle());
                firstOutput.append("       </div>\n");
                firstOutput.append("       <div class=\"panel-body body-detalle\">\n");
                firstOutput.append("       <div class=\"centerSvg\">\n");
                firstOutput.append("         <input type=\"radio\" name=\"graphType2\" id=\"hGraph2\" value=\"1\" onclick=\"javascript:showGraph(this);\" checked=\"checked\"><label for=\"hGraph2\">Horizontal</label>\n");
                firstOutput.append("         <input type=\"radio\" name=\"graphType2\" id=\"vGraph2\" value=\"2\" onclick=\"javascript:showGraph(this);\"><label for=\"vGraph2\">Vertical</label>\n");
                firstOutput.append("       </div>\n");
                firstOutput.append("       </div>\n");

                output.append("   </div>\n");
                output.append("<script type=\"text/javascript\">\n");
                output.append("long_short_data2 = [\n");
                short indicCount = 0;
                //Valida que contenga indicadores asociados al objetivo.
                List<Indicator> indic = objective.listValidIndicators();
                if (indic != null) {
                    for (Indicator indicator : indic) {
                        try {
                            listPeriodIndic = indicator.listMeasurablesPeriods();
                            while (listPeriodIndic.hasNext()) {
                                periodsList.add(listPeriodIndic.next());
                            }
                        } catch (UndefinedFrequencyException ex) {
                            Logger.getLogger(GraphIndicatorsSerieStar.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InappropriateFrequencyException ex) {
                            Logger.getLogger(GraphIndicatorsSerieStar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (indicCount > 0) {
                            output.append(",\n");  //separador de series
                        }
                        //Trae la serieStar
                        Series serieSt = indicator.getStar();
                        if (serieSt.isValid()) {
                            Format serieFormat = serieSt.getFormat();
                            output.append("{");
                            output.append("  key: \"");
                            output.append(serieSt.getTitle());
                            output.append(" de ");
                            output.append(indicator.getTitle());
                            if (serieFormat != null) {
                                output.append(" en ");
                                output.append(serieFormat.getTitle());
                            }
                            output.append("\" ,\n");

                            short colorIndex = (short) (Math.random() * colors.length);
                            boolean colorAssigned = false;
                            while (!colorAssigned) {
                                if (usedColors.indexOf(colorIndex + ",") == -1) {
                                    usedColors.append(colorIndex);
                                    usedColors.append(",");
                                    colorAssigned = true;
                                } else {
                                    colorIndex = (short) (Math.random() * colors.length);
                                }
                            }
                            //Se coloca el color a utilizar para la serie
                            output.append("  color: '");
                            output.append(colors[colorIndex]);
                            output.append("',\n");
                            output.append("  values: [\n");

                            int periodsCount = 0;
                            for (Period p : periodsList) {
                                Measure measure = serieSt.getMeasure(p);
                                if (periodsCount > 0) {
                                    output.append(",\n");
                                }
                                output.append("    {");
                                output.append(" \"label\" : \"");
                                output.append(p.getTitle());
                                output.append("\", ");
                                try {
                                    if (measure.getValue() != 0) {
                                        output.append("\"value\" : ");
                                        output.append(measure.getValue());
                                    }
                                } catch (Exception e) {
                                    output.append("\"value\" : 0.0 ");
                                }
                                output.append(" }");
                                periodsCount++;
                            }
                            output.append("  ]");
                            output.append("}");
                            indicCount++;
                        }

                    }
                } else { // No hay indicadores para graficar
                    out.println("<div class=\"alert alert-warning\" role=\"alert\">" + paramRequest.getLocaleString("msgNotIndicators") + "</div>");
                    out.flush();
                    return;
                }

                //Se termina de armar el Javascript para la presentacion de la grafica
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
                output.append("    .tickFormat(d3.format(',.2d'));\n");
                output.append("  d3.select('#chart1Ind svg')\n");
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

                output.append("      .showControls(false)\n");
                output.append("      .groupSpacing(0.2);\n");    /*Distance between each group of bars.*/

                output.append("  chart2Ind.yAxis\n");
                output.append("      .tickFormat(d3.format(',.2d'));\n");
                output.append("  return chart2Ind;\n");
                output.append("});\n");
                output.append("  function showGraph(radioBtn) {\n");
                output.append("    if (radioBtn.value == 1 && radioBtn.checked) {\n");
                output.append("      d3.select('#chart1Ind svg g').remove();\n");
                output.append("      d3.select('#chart1Ind svg')\n");
                output.append("        .datum(long_short_data2)\n");
                output.append("        .call(chartInd);\n");
                output.append("    } else if (radioBtn.value == 2 && radioBtn.checked) {\n");
                output.append("      d3.select('#chart1Ind svg g').remove();\n");
                output.append("      d3.select('#chart1Ind svg')\n");
                output.append("        .datum(long_short_data2)\n");
                output.append("        .call(chart2Ind);\n");
                output.append("    }\n");
                output.append("  }\n");
                output.append("  </script>\n");
                output.append("</div>\n");

                svgOutput.append("       <div class=\"panel-body body-detalle\">\n");
                svgOutput.append("       <div class=\"centerSvg\">\n");
                svgOutput.append("       <svg style=\"height:");
                svgOutput.append(graphHeight);
                svgOutput.append("; width:");
                svgOutput.append(graphWidth);
                svgOutput.append(";");
                svgOutput.append("\"></svg>\n");
                svgOutput.append("   </div>\n");
                svgOutput.append("   </div>\n");

                out.println(firstOutput.toString());
                out.println(svgOutput.toString());
                out.println(output.toString());

            }
        }

    }

}
