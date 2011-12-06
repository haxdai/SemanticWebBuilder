package com.infotec.eworkplace.swb.resources.sem;

import com.infotec.eworkplace.swb.Sala;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import javax.servlet.http.*;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.portal.api.*;

public class ReservaSalaManager extends com.infotec.eworkplace.swb.resources.sem.base.ReservaSalaManagerBase {

    public ReservaSalaManager()
    {
    }

   /**
   * Constructs a ReservaSalaManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaSalaManager
   */
    public ReservaSalaManager(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        
        PrintWriter out = response.getWriter();
        
        Iterator<Sala> salas = Sala.ClassMgr.listSalas(base.getWebSite());
        salas = SWBComparator.sortByDisplayName(salas, lang);
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        GregorianCalendar gc = new GregorianCalendar(2011,0,1,8,0);
        
        out.println("<script type=\"text/javascript\">");
        out.println("var hrs = [];");

        out.println("var f1=function(item,i,pfx) {");
        out.println("    var s = new String(pfx);");
        out.println("    return item.substring(0,2)==s.substring(0,2);");
        out.println("}");

        out.println("function validate() {");
        out.println("    if(hrs.length>0) {");
        out.println("        hrs.sort();");
        out.println("        if(dojo.every(hrs, f1))");
        out.println("            alert('si juegas');");
        out.println("        else {");
        out.println("            alert('no juegas');");
        out.println("            dojo.every(hrs, function(item){dojo.style(dojo.byId(item),'backgroundColor','#ffffff');return true;});");
        out.println("            hrs=[];");
        out.println("        }");
        out.println("    }else {");
        out.println("        alert('para jugar hay que  seleccionar');");
        out.println("    }");
        out.println("}");

        out.println("dojo.addOnLoad (");
        out.println("  function() {");
        out.println("    dojo.query(\".sltc\").connect(\"onclick\", function() {");
        out.println("                                                if(dojo.hasClass(this, 'x'))");
        out.println("                                                    return;");
        out.println("                                                if(dojo.colorFromString(dojo.style(dojo.attr(this, 'id'),'backgroundColor')).toHex()=='#ffffff') {");
        out.println("                                                    dojo.style(dojo.attr(this, 'id'),'backgroundColor','#1d75b9');");
        out.println("                                                    hrs.push(dojo.attr(this, 'id'));");
        out.println("                                                }else {");
        out.println("                                                    dojo.style(dojo.attr(this, 'id'),'backgroundColor','#ffffff');");
        out.println("                                                    var i = dojo.indexOf(hrs, dojo.attr(this, 'id'));");
        out.println("                                                    if(i>=0)");
        out.println("                                                        hrs.splice(i,1);");
        out.println("                                                }");
        out.println("                                               }");
        out.println("    );");
        out.println("  }");
        out.println(");");
        out.println("</script>");

        out.println("<div id=\"dayselectorCal\">");
        out.println(" <p class=\"disponibilidadSalas\">Disponibilidad de salas</p>");
        out.println(" <p><a href=\"#\" class=\"salasAtras\">atr&aacute;s</a></p>");
        out.println(" <p class=\"dayAndMonth\">Domingo 3 de Noviembre</p>");
        out.println(" <p><a href=\"#\" class=\"salasAdelante\">adelante</a></p>");
        out.println("</div>");
        out.println("<br class=\"clear\"/>");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<tr class=\"trCalSalas\">");
        out.println("  <td height=\"30\">Hora</td>");
        while(salas.hasNext()) {
            out.println("  <td height=\"30\">"+salas.next().getDisplayTitle(lang) +"</td>");
        }
        out.println("</tr>");
        for(int i=480; i<=1260; i+=30) {
            out.println("<tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(gc.getTime())+"</p></td>");
            out.println("  <td id=\"am_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s1_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s2_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s3_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s4_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s5_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s6_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s7_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s8_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("  <td id=\"s9_0_"+i+"\"  class=\"sltc trCal1\"></td>");
            out.println("</tr>");
            i+=30;
            out.println("<tr>");
            out.println("  <td id=\"am_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s1_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s2_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s3_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s4_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s5_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s6_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s7_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s8_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("  <td id=\"s9_1_"+i+"\"  class=\"sltc trCal2\"></td>");
            out.println("</tr>");
            gc.add(Calendar.HOUR_OF_DAY, 1);
        }
        out.println("</table>");
        out.println("<p><input type=\"button\" value=\"reservar\" onclick=\"validate()\" /></p>");
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        super.processAction(request, response);
    }
}