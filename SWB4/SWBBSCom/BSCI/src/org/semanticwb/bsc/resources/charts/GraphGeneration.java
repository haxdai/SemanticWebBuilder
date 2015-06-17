package org.semanticwb.bsc.resources.charts;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.ComponentExportable;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.catalogs.Format;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.Series;
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
import org.semanticwb.util.UploaderFileCacheUtils;
import org.w3c.dom.Document;

/**
 * Genera el c&oacute;digo HTML para presentar una gr&aacute;fica con los datos
 * de las series activas del indicador cuyo uri se recibe.
 *
 * @author carlos.ramos, ana.garcias
 */
public class GraphGeneration extends GenericAdmResource implements ComponentExportable {
    private static final Logger log = SWBUtils.getLogger(GraphGeneration.class);
    private static  String SVG_ID;

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
        final String graphHeight = base.getAttribute("graphPSHeight","500px");
        final String graphWidth = base.getAttribute("graphPSWidth","100%");
        final String marginLeftH = base.getAttribute("marginLeftH","125");
        final String marginRightH = base.getAttribute("marginRightH","20");
        final String marginTopH = base.getAttribute("marginTopH","30");
        final String marginBottomH = base.getAttribute("marginBottomH","40");
        final String marginLeftV = base.getAttribute("marginLeftV","125");
        final String marginRightV = base.getAttribute("marginRightV","20");
        final String marginTopV = base.getAttribute("marginTopV","10");
        final String marginBottomV = base.getAttribute("marginBottomVt","110");
        final String rotateLabels = base.getAttribute("rotateLabelV","-80");
        
        GenericObject genericObj = semanticObj.createGenericInstance();
        if(genericObj instanceof Indicator)
        {
            Indicator indicator = (Indicator)genericObj;
            Iterator<Period> measurablePeriods;
            try {
                measurablePeriods = indicator.listMeasurablesPeriods();
            } catch (UndefinedFrequencyException ex) {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgUndefinedFrequencyException")+"</div>");
                out.flush();
                return;
            } catch (InappropriateFrequencyException ex) {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgInappropriateFrequencyException")+"</div>");
                out.flush();
                return;
            }
            if(!measurablePeriods.hasNext()) {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNotPeriods")+"</div>");
                out.flush();
                return;
            }
            List<Period> periodsList;
            periodsList = SWBUtils.Collections.copyIterator(measurablePeriods);
            Collections.sort(periodsList);

            firstOutput.append("  <div class=\"panel panel-default panel-detalle\">\n");
            firstOutput.append("    <div id=\"").append(SVG_ID).append("\" class=\'with-3d-shadow with-transitions\'>\n");
            firstOutput.append("     <div class=\"panel-heading head-detalle\">");
            firstOutput.append(semanticObj.getSemanticClass().getDisplayName(lang));
            firstOutput.append(":&nbsp;");
            firstOutput.append(indicator.getDisplayTitle(lang));
            firstOutput.append("     </div>\n");
            firstOutput.append("     <div class=\"panel-body body-detalle\">\n");
            firstOutput.append("      <div class=\"centerSvg\">\n");
            firstOutput.append("       <input type=\"radio\" name=\"graphType\" id=\"hGraph").append(SVG_ID).append("\" value=\"1\" onclick=\"showGraph(this);\" checked><label for=\"hGraph").append(SVG_ID).append("\">");
            firstOutput.append(paramRequest.getLocaleString("lblLandscape")).append("</label>\n");
            firstOutput.append("       <input type=\"radio\" name=\"graphType\" id=\"vGraph").append(SVG_ID).append("\" value=\"2\" onclick=\"showGraph(this);\"><label for=\"vGraph").append(SVG_ID).append("\">");
            firstOutput.append(paramRequest.getLocaleString("lblNarrow")).append("</label>\n");
            firstOutput.append("      </div>\n");
            firstOutput.append("     </div>\n");
            
            List<Series> seriesLst = indicator.listValidSerieses();
            Collections.sort(seriesLst);
            Iterator<Series> serieses = seriesLst.iterator();
            if(serieses.hasNext())
            {
                int colorIndex = -1;
                output.append("<script type=\"text/javascript\">\n");
                output.append("var  long_short_data = [\n");
                while(serieses.hasNext()) 
                {
                    Series graphSeries = serieses.next();
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

                    int periodsCount = 0;
                    //Recorre los periodos y valores de la serie para graficarlos
                    for(Period period : periodsList) {
                        Measure measure = graphSeries.getMeasure(period);
                        if (periodsCount > 0) {
                            output.append(",\n");
                        }
                        output.append("    {");
                        output.append(" \"label\" : \"");
                        output.append(period.getDisplayTitle(lang));
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
                    output.append(serieses.hasNext()?",\n":"\n");
                }
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
                output.append("    .showControls(true);\n");
                output.append("  chart.yAxis\n");
                output.append("    .tickFormat(d3.format(',.2f'));\n");
                output.append("  d3.select('#").append(SVG_ID).append(" svg')\n");
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
                output.append("      .transitionDuration(350)\n");
                output.append("      .reduceXTicks(true)\n");   /*If 'false', every single x-axis tick label will be rendered.*/
                output.append("      .rotateLabels(");
                output.append(rotateLabels);
                output.append(")\n"); 
                output.append("      .staggerLabels(true)\n");     /*Intercala etiquetas en el eje 1 arriba, 1 abajo.*/
                output.append("      .showControls(true)\n");   /*Allow user to switch between 'Grouped' and 'Stacked' mode.*/
                output.append("      .groupSpacing(0.1);\n");    /*Distance between each group of bars.*/
                output.append("  chart2.yAxis\n");
                output.append("      .tickFormat(d3.format(',.2f'));\n");
                output.append("  return chart2;\n");
                output.append("});\n");
                output.append("  function showGraph(radioBtn) {\n");
                output.append("    if (radioBtn.value == 1 && radioBtn.checked) {\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
                output.append("        .datum(long_short_data)\n");
                output.append("        .call(chart);\n");
                output.append("    } else if (radioBtn.value == 2 && radioBtn.checked) {\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg g').remove();\n");
                output.append("      d3.select('#").append(SVG_ID).append(" svg')\n");
                output.append("        .datum(long_short_data)\n");
                output.append("        .call(chart2);\n");
                output.append("    }\n");
                output.append("  }\n");
                output.append("</script>\n");
            }
            else
            {
                out.println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgSeriesIsNotActive")+"</div>");
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
            svgOutput.append(" </div>\n");
            svgOutput.append("</div>\n");
            out.println(firstOutput.toString());
            out.println(svgOutput.toString());
            out.println(output.toString());
            out.println("  </div> <!-- //#chart1 -->");
            out.println("</div> <!-- //.panel panel-default panel-detalle -->");
        }
    }

    /**
     * Genera el c&oacute;digo HTML de la gr&aacute;fica (Tabla de datos de un
     * indicador) usado en la exportaci&oacute;n a PDF del componente
     *
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @return el objeto String que representa el c&oacute;digo HTML con los
     * datos a exportar(Gr&aacute;fica de la tabla de datos de un indicador)
     * @throws SWBResourceException SWBResourceException SWBResourceException
     * Excepti&oacute;n utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     *
     */
    @Override
    public String doComponentExport(HttpServletRequest request, SWBParamRequest paramRequest)
            throws SWBResourceException, IOException {
        StringBuilder sb = new StringBuilder();
        Resource base = this.getResourceBase();
        String data = request.getParameter("image");
        String uniqueImage = request.getParameter("uniqueImage");
        if (data.trim().length() > 0) {
            float width = base.getAttribute("width") != null
                    ? Float.parseFloat(base.getAttribute("width")) : 650;
            float height = base.getAttribute("height") != null
                    ? Float.parseFloat(base.getAttribute("height")) : 500;

            int dataIndexOf = data.indexOf("svg");
            int lenght = data.length();

            if (!data.contains("xmlns=")) {
                String data1 = data.substring(0, (dataIndexOf + 3));
                String data2 = data.substring((dataIndexOf + 3), lenght);
                data = (data1) + " xmlns=\"http://www.w3.org/2000/svg\" " + (data2);
            }

            data = SWBUtils.TEXT.replaceAll(data, "NaN", "0");

            Document svg = SWBUtils.XML.xmlToDom(data);
            try {
                String destpath = SWBPlatform.getContextPath() + "/work/models/"
                        + paramRequest.getWebPage().getWebSiteId()
                        + "/graphics_" + uniqueImage + ".jpg";
                saveGraphics(svg, paramRequest.getWebPage().getWebSiteId(), width, height, 
                        uniqueImage);

                sb.append("<p><img src=\"");
                sb.append(destpath);
                sb.append("\" alt=\"graphics\"/></p>");
            } catch (Exception ex) {
                log.error("Error try save Image: " + ex);
            }
        }
        return sb.toString();
    }

    /**
     * Crea y almacena una imagen temporal con la gr&aacute;fica de un indicador
     *
     * @param document archivo XML con informaci&oacute;n de tipo SVG
     * (Gr&aacute;fica)
     * @param idWebSite id del ScoreCard
     * @param width ancho de la imagen a generar
     * @param height alto de la imagen a generar
     * @throws Exception Excepti&oacute;n de IO
     */
    private void saveGraphics(Document document, String idWebSite, float width, float height,
            String uniqueImage)
            throws Exception {
        String destpath = UploaderFileCacheUtils.getHomepath() + "/models/" + idWebSite;
        JPEGTranscoder t = new JPEGTranscoder();
        t.addTranscodingHint(JPEGTranscoder.KEY_QUALITY, new Float(.8));
        t.addTranscodingHint(JPEGTranscoder.KEY_WIDTH, width);
        t.addTranscodingHint(JPEGTranscoder.KEY_HEIGHT, height);

        // Set the transcoder input and output.
        TranscoderInput input = new TranscoderInput(document);
        OutputStream ostream = new FileOutputStream(destpath + "/graphics_" + uniqueImage +".jpg");
        TranscoderOutput output = new TranscoderOutput(ostream);

        // Perform the transcoding.
        t.transcode(input, output);
        ostream.flush();
        ostream.close();
    }
}
