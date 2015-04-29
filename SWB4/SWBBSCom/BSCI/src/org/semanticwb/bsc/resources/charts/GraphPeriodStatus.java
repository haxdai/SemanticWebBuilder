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
import org.semanticwb.Logger;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import org.semanticwb.bsc.element.Objective;
import org.semanticwb.bsc.tracing.PeriodStatus;
import org.semanticwb.bsc.utils.BSCUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.portal.api.GenericAdmResource;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;

/**
 *
 * @author ana.garcias, carlos.ramos
 */
public class GraphPeriodStatus extends GenericAdmResource {
    private static final Logger log = SWBUtils.getLogger(GraphGeneration.class);
    private static String SVG_ID;
    
    @Override
    public void setResourceBase(Resource base) throws SWBResourceException {
        super.setResourceBase(base);
        SVG_ID = "_"+getResourceBase().getId();
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response,
            SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        final String suri = request.getParameter("suri");
        if(suri==null) {
            response.getWriter().println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNoSuchSemanticElement")+"</div>");
            response.flushBuffer();
            return;
        }
        final SemanticObject semanticObj = SemanticObject.getSemanticObject(suri);
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
        final String graphHeight = base.getAttribute("graphPSHeight","300px");
        final String graphWidth = base.getAttribute("graphPSWidth","100%");
        final String marginLeftH = base.getAttribute("marginLeftH","125");
        final String marginRightH = base.getAttribute("marginRightH","175");
        final String marginTopH = base.getAttribute("marginTopH","30");
        final String marginBottomH = base.getAttribute("marginBottomH","40");
        final String marginLeftV = base.getAttribute("marginLeftV","125");
        final String marginRightV = base.getAttribute("marginRightV","175");
        final String marginTopV = base.getAttribute("marginTopV","10");
        final String marginBottomV = base.getAttribute("marginBottomVt","110");
        final String rotateLabels = base.getAttribute("rotateLabelV","-80");
        final String graphColor = base.getAttribute("graphColor", BSCUtils.ColorPalette[0]);
        
        GenericObject genericObj = semanticObj.createGenericInstance();
        if(genericObj instanceof Objective)
        {
            Objective obj = (Objective)genericObj;
            firstOutput.append("<div class=\"panel panel-default panel-detalle\">\n");
            firstOutput.append(" <div id=\""+SVG_ID+"\" class=\'with-3d-shadow with-transitions\'>\n");
            firstOutput.append("  <div class=\"panel-heading head-detalle\">");
            firstOutput.append(semanticObj.getSemanticClass().getDisplayName(lang));
            firstOutput.append(":&nbsp;");
            firstOutput.append(obj.getDisplayTitle(lang));
            firstOutput.append("  </div>\n");
            firstOutput.append("  <div class=\"panel-body body-detalle\">\n");
            firstOutput.append("   <div class=\"centerSvg\">\n");
            firstOutput.append("    <input type=\"radio\" name=\"graphType"+SVG_ID+"\" id=\"hGraph"+SVG_ID+"\" value=\"1\" onclick=\"showGraph"+SVG_ID+"(this);\" checked=\"checked\"><label for=\"hGraph"+SVG_ID+"\">");
            firstOutput.append(paramRequest.getLocaleString("lblLandscape")).append("</label>\n");
            firstOutput.append("    <input type=\"radio\" name=\"graphType"+SVG_ID+"\" id=\"vGraph"+SVG_ID+"\" value=\"2\" onclick=\"showGraph"+SVG_ID+"(this);\"><label for=\"vGraph"+SVG_ID+"\">");
            firstOutput.append(paramRequest.getLocaleString("lblNarrow")).append("</label>\n");
            firstOutput.append("   </div>\n");
            firstOutput.append("  </div><!-- // .panel-body body-detalle -->\n");
            
            List<Period> periodsLst = obj.listValidPeriods();
            Collections.sort(periodsLst);
            Iterator<Period> periods = periodsLst.iterator();
            if(periods.hasNext())
            {
                //output.append("<div>\n");
                output.append("<script type=\"text/javascript\">\n");
                output.append("long_short_data = [\n");
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
                //Recorre los periodos y valores de los estatus para graficarlos
                Period period;
                while(periods.hasNext())
                {
                    period = periods.next();
                    if(period.isCurrent() || period.isFuture()) {
                        break;
                    }
                    PeriodStatus ps = obj.getPeriodStatus(period);
                    if(ps!=null && ps.getStatus()!=null) {
                        State st = ps.getStatus();
                        output.append("{");
                        output.append(" \"label\" : \"");
                        output.append(period.getTitle());
                        output.append("\", ");
                        //if(ps.getStatus().getIndex() == st.getIndex()) {
                            output.append("\"value\" : ");
                            //output.append(ps.getStatus().getIndex());
                            output.append(st.getIndex());
                        //}
                        output.append("}");
                        output.append(periods.hasNext()?",\n":"\n");
                    }
                }
                output.append("  ]\n");
                output.append("}];\n");
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
                output.append("      .tickFormat(d3.format(',.2d'));\n");
                output.append("  d3.select('#"+SVG_ID+" svg')\n");
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
                output.append("      .tickFormat(d3.format(',.2d'));\n");
                output.append("  return chart2;\n");
                output.append("});\n");
                output.append("  function showGraph"+SVG_ID+"(radioBtn) {\n");
                output.append("    if (radioBtn.value == 1 && radioBtn.checked) {\n");
                output.append("      d3.select('#"+SVG_ID+" svg g').remove();\n");
                output.append("      d3.select('#"+SVG_ID+" svg')\n");
                output.append("        .datum(long_short_data)\n");
                output.append("        .call(chart);\n");
                output.append("    }else if (radioBtn.value == 2 && radioBtn.checked) {\n");
                output.append("      d3.select('#"+SVG_ID+" svg g').remove();\n");
                output.append("      d3.select('#"+SVG_ID+" svg')\n");
                output.append("        .datum(long_short_data)\n");
                output.append("        .call(chart2);\n");
                output.append("    }\n");
                output.append("  }\n");
                output.append("  </script>\n");
                //output.append("</div>\n");
            }
            else
            {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">" + paramRequest.getLocaleString("msgNotPeriods") + "</div>");
                out.flush();
                return;
            }
            svgOutput.append("<div class=\"panel-body body-detalle\">\n");
            svgOutput.append(" <div class=\"centerSvg\">\n");
            svgOutput.append("  <svg style=\"height:");
            svgOutput.append(graphHeight);
            svgOutput.append("; width:");
            svgOutput.append(graphWidth);
            svgOutput.append(";\"></svg>\n");
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
            svgOutput.append(" </div>\n");
            svgOutput.append("</div>\n");

            out.println(firstOutput.toString());
            out.println(svgOutput.toString());
            out.println(output.toString());
            out.println("  </div> <!-- //#"+SVG_ID+" -->");
            out.println("</div> <!-- //.panel panel-default panel-detalle -->");
        }
    }
}
