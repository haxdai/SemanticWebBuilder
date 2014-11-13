package org.semanticwb.bsc.admin.resources.behavior;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.tracing.PeriodStatus;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author ana.garcias
 */
public class GraphPeriodStatus extends GenericResource {

    private static final String[] colors = {
        "#58FAF4", "#9F81F7", "#FA58F4", "#8A0829", "#F5A9D0","#81F7BE"};

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        final String suri = request.getParameter("suri");
        SemanticObject semanticObj = SemanticObject.getSemanticObject(suri);
        final User user = paramRequest.getUser();
        final String lang = user.getLanguage();
        PrintWriter out = response.getWriter();
        StringBuilder output = new StringBuilder(512);
        StringBuilder firstOutput = new StringBuilder(128);
        StringBuilder svgOutput = new StringBuilder(64);
        StringBuilder usedColors = new StringBuilder(32);
        final String graphHeight = "300";
        final String graphWidth = "650";

        /*if(!user.isSigned() || !user.haveAccess(semanticObj.createGenericInstance()))     {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNotPermissions")+"</div>");
            response.flushBuffer();
            return;
        }*/

        if (semanticObj != null)
        {
            GenericObject genericObj = semanticObj.createGenericInstance();
            if (genericObj instanceof Objective)
            {
                Objective obj = (Objective) genericObj;
                Iterator<Period> validList = null;
                List<Period> periodsList = new java.util.ArrayList<Period>();
                Iterator<State> itStates = obj.listValidStates().iterator();

                //Codigo HTML para generar la grafica
                firstOutput.append("<div class=\"row\">\n");
                firstOutput.append("<div class=\"col-xs-12\">\n");
                firstOutput.append("<div class=\"panel panel-default panel-detalle\">\n");

                List<Period> lperiods = obj.listValidPeriods();
                Collections.sort(lperiods);
                validList = lperiods.iterator();
                if (validList != null) {
                    while (validList.hasNext()) {
                        periodsList.add(validList.next());
                    }
                }

                firstOutput.append("<div id=\"graphContainer\">\n");
                firstOutput.append("   <div id=\"chart1\" class=\'with-3d-shadow with-transitions\'>\n");
                firstOutput.append("       <div class=\"panel-heading head-detalle\">");
                firstOutput.append(obj.getTitle());
                firstOutput.append("       </div>\n");
                firstOutput.append("       <div class=\"panel-body body-detalle\">\n");
                firstOutput.append("       <div class=\"centerSvg\">\n");
                firstOutput.append("         <input type=\"radio\" name=\"graphType\" id=\"hGraph\" value=\"1\" onclick=\"javascript:showGraph(this);\" checked=\"checked\"><label for=\"hGraph\">Horizontal</label>\n");
                firstOutput.append("         <input type=\"radio\" name=\"graphType\" id=\"vGraph\" value=\"2\" onclick=\"javascript:showGraph(this);\"><label for=\"vGraph\">Vertical</label>\n");
                firstOutput.append("       </div>\n");
                firstOutput.append("       </div>\n");

                output.append("   </div>\n");
                output.append("<script type=\"text/javascript\">\n");
                output.append("long_short_data = [\n");

                short seriesCount = 0;
                while (itStates != null && itStates.hasNext())
                {
                    State st = itStates.next();
                        //Se selecciona el color de la serie de manera aleatoria
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
                        //Valida que contenga periodos asignados
                        if (periodsList.size() > 0) {
                            if (seriesCount > 0) {
                                output.append(",\n");  //separador de estados
                            }
                            output.append("{");
                            //Se coloca el identificador de cada estado
                            output.append("  key: \"");
                            output.append(st.getTitle() != null?st.getTitle():"Sin título");
                            output.append("\" ,\n");

                            //Se coloca el color a utilizar para cada estado
                            output.append("  color: '");
                            output.append(st.getColorHex()!= null?st.getColorHex():colors[colorIndex]);
                            output.append("',\n");
                            output.append("  values: [\n");

                            int periodsCount = 0;

                            //Recorre los periodos y valores de los estatus para graficarlos
                            for (Period period : periodsList) {
                                PeriodStatus ps = obj.getPeriodStatus(period);
                                if (ps != null && ps.getStatus() != null) {
                                    if (periodsCount > 0) {
                                        output.append(",\n");
                                    }
                                    output.append("    {");
                                    output.append(" \"label\" : \"");
                                    output.append(period.getTitle());
                                    output.append("\", ");
                                    if (ps.getStatus().getIndex() == st.getIndex()) {
                                        output.append("\"value\" : ");
                                        output.append(ps.getStatus().getIndex());
                                    }
                                    output.append(" }");
                                    periodsCount++;
                                }
                            }
                            output.append("  ]");
                            output.append("}");
                        } else {//En caso de que no haya periodos
                            out.println("<div class=\"alert alert-warning\" role=\"alert\">" + paramRequest.getLocaleString("msgNotPeriods") + "</div>");
                            out.flush();
                            return;
                        }
                        seriesCount++;
                }
                //Se termina de armar el Javascript para la presentacion de la grafica
                output.append("];\n");
                output.append("var chart;\n");
                output.append("var chart2;\n");
                output.append("nv.addGraph(function() {\n");
                output.append("  chart = nv.models.multiBarHorizontalChart()\n");
                output.append("      .x(function(d) { return d.label })\n");
                output.append("      .y(function(d) { return d.value })\n");
                output.append("    .margin({top: 30, right: 20, bottom: 40, left: 125})\n");
                output.append("    .transitionDuration(250)\n");
                output.append("    .showControls(false);\n");
                output.append("  chart.yAxis\n");
                output.append("    .tickFormat(d3.format(',.2f'));\n");
                output.append("  d3.select('#chart1 svg')\n");
                output.append("    .datum(long_short_data)\n");
                output.append("    .call(chart);\n");
                output.append("  nv.utils.windowResize(chart.update);\n");
                output.append("  return chart;\n");
                output.append("});\n");
                output.append("nv.addGraph(function() {\n");
                output.append("  chart2 = nv.models.multiBarChart()\n");
                output.append("      .x(function(d) { return d.label })\n");
                output.append("      .y(function(d) { return d.value })\n");
                output.append("    .margin({top: 10, right: 20, bottom: 90, left: 125})\n");
                output.append("      .transitionDuration(350)\n");
                output.append("      .reduceXTicks(false)\n");   //If 'false', every single x-axis tick label will be rendered.
                output.append("      .staggerLabels(true)\n");     //Intercala etiquetas en el eje 1 arriba, 1 abajo.//
                output.append("      .showControls(false)\n");   //Allow user to switch between 'Grouped' and 'Stacked' mode.
                output.append("      .rotateLabels(-90)\n"); 
                output.append("      .groupSpacing(0.1);\n");    //Distance between each group of bars.
                output.append("  chart2.yAxis\n");
                output.append("      .tickFormat(d3.format(',.2f'));\n");
                output.append("  return chart2;\n");
                output.append("});\n");
                output.append("  function showGraph(radioBtn) {\n");
                output.append("    if (radioBtn.value == 1 && radioBtn.checked) {\n");
                output.append("      d3.select('#chart1 svg g').remove();\n");
                output.append("      d3.select('#chart1 svg')\n");
                output.append("        .datum(long_short_data)\n");
                output.append("        .call(chart);\n");
                output.append("    } else if (radioBtn.value == 2 && radioBtn.checked) {\n");
                output.append("      d3.select('#chart1 svg g').remove();\n");
                output.append("      d3.select('#chart1 svg')\n");
                output.append("        .datum(long_short_data)\n");
                output.append("        .call(chart2);\n");
                output.append("    }\n");
                output.append("  }\n");
                output.append("  </script>\n");
                output.append("</div>\n");// cierra graph

                svgOutput.append("       <div class=\"panel-body body-detalle\">\n");
                svgOutput.append("       <div class=\"centerSvg\">\n");
                /*svgOutput.append("       <svg style=\"height:");
                svgOutput.append(graphHeight);
                svgOutput.append("px; width:");
                svgOutput.append(graphWidth);
                svgOutput.append("px;");
                svgOutput.append("\"></svg>\n");*/
                svgOutput.append("       <svg style=\"height:400px\"></svg>");
                svgOutput.append("   </div>\n");
                svgOutput.append("   </div>\n");

                out.println(firstOutput.toString());
                out.println(svgOutput.toString());
                out.println(output.toString());

                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
               
            }
        }
    }
}
