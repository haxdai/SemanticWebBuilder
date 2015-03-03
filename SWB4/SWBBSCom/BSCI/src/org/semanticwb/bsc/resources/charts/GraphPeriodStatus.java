package org.semanticwb.bsc.resources.charts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.tracing.PeriodStatus;
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
public class GraphPeriodStatus extends GenericAdmResource {

    private static final String[] colors = {
        "#58FAF4", "#9F81F7", "#FA58F4", "#8A0829", "#F5A9D0","#81F7BE"};

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        Resource base = getResourceBase();
        final String suri = request.getParameter("suri");
        SemanticObject semanticObj = SemanticObject.getSemanticObject(suri);
        final User user = paramRequest.getUser();
        final String lang = user.getLanguage();
        PrintWriter out = response.getWriter();
        StringBuilder output = new StringBuilder(512);
        StringBuilder firstOutput = new StringBuilder(128);
        StringBuilder svgOutput = new StringBuilder(64);
        
        String graphHeight = base.getAttribute("graphPSHeight","300px");
        String graphWidth = base.getAttribute("graphPSWidth","100%");
        String marginLeftH = base.getAttribute("marginLeftH","125");
        String marginRightH = base.getAttribute("marginRightH","175");
        String marginTopH = base.getAttribute("marginTopH","30");
        String marginBottomH = base.getAttribute("marginBottomH","40");
        String marginLeftV = base.getAttribute("marginLeftV","125");
        String marginRightV = base.getAttribute("marginRightV","175");
        String marginTopV = base.getAttribute("marginTopV","10");
        String marginBottomV = base.getAttribute("marginBottomVt","110");
        String rotateLabels = base.getAttribute("rotateLabelV","-80");
        String graphColor = base.getAttribute("graphColor","#A9D0F5");

        if(!user.isSigned() || !user.haveAccess(semanticObj.createGenericInstance()))     {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNotPermissions")+"</div>");
            response.flushBuffer();
            return;
        }

        if (semanticObj != null)
        {//1
            GenericObject genericObj = semanticObj.createGenericInstance();
            if (genericObj instanceof Objective)
            {//2
                Objective obj = (Objective) genericObj;
                
                firstOutput.append("<div class=\"panel panel-default panel-detalle\">\n");
                firstOutput.append("<div class=\"row\">\n");
                firstOutput.append("<div class=\"col-xs-12\">\n");
                firstOutput.append("<div id=\"graphContainer\">\n");
                firstOutput.append("   <div id=\"chart1\" class=\'with-3d-shadow with-transitions\'>\n");
                firstOutput.append("       <div class=\"panel-heading head-detalle\">");
                firstOutput.append(obj.getDisplayTitle(lang)==null?obj.getTitle():obj.getDisplayTitle(lang));
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
                
                List<Period> periodsList = obj.listValidPeriods();
                Collections.sort(periodsList);
                //Valida que contenga periodos asignados
                if(periodsList.size() > 0)
                {
                    output.append("{");
                    //Se coloca el identificador de cada estado
                    output.append("  key: \"");
                    output.append("Estados de los periodos");
                    output.append("\" ,\n");
                    //Se coloca el color a utilizar para la grafica
                    output.append("  color: '");
                    output.append(graphColor);                          
                    output.append("',\n");
                    output.append("  values: [\n");

                    int periodsCount = 0;

                    //Recorre los periodos y valores de los estatus para graficarlos
                    for (Period period : periodsList) {
                        if(period.isCurrent() || period.isFuture()) {
                            break;
                        }
                        PeriodStatus ps = obj.getPeriodStatus(period);
                        if (ps != null && ps.getStatus() != null) {
                            State st = ps.getStatus();
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
                }
                else
                {//En caso de que no haya periodos
                    out.println("<div class=\"alert alert-warning\" role=\"alert\">" + paramRequest.getLocaleString("msgNotPeriods") + "</div>");
                    out.flush();
                    return;
                }
                //}
                //Se termina de armar el Javascript para la presentacion de la grafica
                output.append("];\n");
                output.append("var chart;\n");
                output.append("var chart2;\n");
                output.append("nv.addGraph(function() {\n");
                output.append("  chart = nv.models.multiBarHorizontalChart()\n");
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
                output.append("  chart.yAxis\n");
                output.append("    .tickFormat(d3.format(',1f'));\n");
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
                output.append("    .margin({top: ");
                output.append(marginTopV);
                output.append(", right: ");
                output.append(marginRightV);
                output.append(", bottom: ");
                output.append(marginBottomV);
                output.append(", left: ");
                output.append(marginLeftV);
                output.append(" })\n");
                output.append("      .transitionDuration(250)\n");
                output.append("      .reduceXTicks(false)\n");   //If 'false', every single x-axis tick label will be rendered.
                output.append("      .staggerLabels(false)\n");     //Intercala etiquetas en el eje 1 arriba, 1 abajo.//
                output.append("      .showControls(false)\n");   //Allow user to switch between 'Grouped' and 'Stacked' mode.
                output.append("      .rotateLabels(");
                output.append(rotateLabels);
                output.append(")\n"); 
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
                svgOutput.append("       <svg style=\"height:");
                svgOutput.append(graphHeight);
                svgOutput.append("; width:");
                svgOutput.append(graphWidth);
                svgOutput.append(";");
                svgOutput.append("\"></svg>\n");
                
                // Cuadro de valores
                SortedSet<State> states = new TreeSet<State>();
                states.addAll(obj.listValidStates());
                Iterator<State> iterator = states.iterator();
                if(iterator.hasNext()) {
                    svgOutput.append("<ul class=\"list-group swbstrgy-list-group\">").append("\n");
                    while(iterator.hasNext()) {
                        State st = iterator.next();
                        svgOutput.append("<li class=\"list-group-item swbstrgy-list-group-item\">");
                        svgOutput.append("<span class=\"badge\">");
                        svgOutput.append(st.getIndex());
                        svgOutput.append("</span>");
                        svgOutput.append(st.getDisplayTitle(lang));
                        svgOutput.append("</li>").append("\n");
                    }
                    svgOutput.append("</ul>").append("\n");
                }
                // Cuadro de valores. Fin
                
                svgOutput.append("   </div>\n");
                svgOutput.append("   </div>\n");

                out.println(firstOutput.toString());
                out.println(svgOutput.toString());
                out.println(output.toString());

                out.println("</div>");//.col-xs-12
                out.println("</div>");//.row
                out.println("</div>");//.panel panel-default .panel-detalle
            }//2
        }//1
    }
}
