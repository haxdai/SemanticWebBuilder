

<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.NoSuchElementException"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.xml.xpath.XPath"%>
<%@page import="javax.xml.xpath.XPathConstants"%>
<%@page import="javax.xml.xpath.XPathExpressionException"%>
<%@page import="javax.xml.xpath.XPathFactory"%>

<%@page import="org.semanticwb.Logger"%>
<%@page import="org.semanticwb.SWBException"%>
<%@page import="org.semanticwb.SWBPortal"%>
<%@page import="org.semanticwb.SWBUtils"%>

<%@page import="org.semanticwb.bsc.BSC"%>
<%@page import="org.semanticwb.bsc.Theme"%>
<%@page import="org.semanticwb.bsc.Perspective"%> 
<%@page import="org.semanticwb.bsc.accessory.Period"%>
<%@page import="org.semanticwb.bsc.accessory.StateGroup"%>
<%@page import="org.semanticwb.bsc.accessory.State"%>
<%@page import="org.semanticwb.bsc.element.Objective"%>
<%@page import="org.semanticwb.bsc.element.Initiative"%>
<%@page import="org.semanticwb.bsc.resources.maps.ImpactMap"%>
<%@page import="org.semanticwb.model.Resource"%>
<%@page import="org.semanticwb.model.SWBContext"%>
<%@page import="org.semanticwb.model.User"%>
<%@page import="org.semanticwb.model.WebPage"%>
<%@page import="org.semanticwb.model.WebSite"%>
<%@page import="org.semanticwb.portal.api.GenericResource"%>
<%@page import="org.semanticwb.portal.api.SWBActionResponse"%>
<%@page import="org.semanticwb.portal.api.SWBResourceException"%>
<%@page import="org.semanticwb.portal.api.SWBResourceURL"%>


<%@page import="static org.semanticwb.bsc.PDFExportable.Mode_StreamPDF"%>
<%@page import="static org.semanticwb.bsc.PDFExportable.Mode_StreamPNG"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="paramRequest" scope="request" type="org.semanticwb.portal.api.SWBParamRequest" />
<jsp:useBean id="these" scope="request" type="org.semanticwb.bsc.resources.maps.ImpactMap" />
<%
    final BSC scorecard = (BSC)paramRequest.getWebPage().getWebSite();
    Period period;
    Object periodId = request.getSession(true).getAttribute(scorecard.getId());
    if(periodId!=null && Period.ClassMgr.hasPeriod(periodId.toString(), scorecard)) {
        period = Period.ClassMgr.getPeriod(periodId.toString(), scorecard);
    }else {
        out.println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgNoSuchMeasuringPeriod")+"</div>");
        out.flush();
        return;
    }
    final User user = paramRequest.getUser();
    final String lang = user.getLanguage();
    final String bundle = getClass().getName();
    final Locale locale = new Locale(lang);
    List<Initiative> initiatives = scorecard.listValidInitiatives();
    State minimum;
    StateGroup sg;
    try {
        minimum = initiatives.get(0).getMinimumState();
        sg = minimum.getStateGroup();
    }catch(Exception e) {
        out.println("<div class=\"alert alert-warning\" role=\"alert\">"+paramRequest.getLocaleString("msgInitiativeNotFound")+"</div>");
        out.flush();
        return;
    }
    
    out.println("<div class=\"panel panel-default\"> <!-- panel -->");
    out.println("  <div class=\"panel-heading swbstrgy-panel-heading\">");
    out.println("    <div class=\"row\">");
    out.println("      <div class=\"col-xs-12\">");
    out.println(paramRequest.getLocaleString("lblImpactMap"));
    out.println("      </div>");
    out.println("    </div>");
    out.println("  </div> <!-- /.panel-heading -->");

    out.println(" <div class=\"panel-body swbstrgy-panel-body\"> <!-- panel-body -->");
    out.println("  <div class=\"row impactMapProperties\">");
    List<State>states = sg.listValidStates();
    out.println("  <div class=\"col-xs-8 col-xs-offset-4\">");
    for(State state:states) {
        //out.println("  <div class=\"col-lg-2 col-md-3 col-sm-4 col-xs-12\">");
        out.print("    <span class=\"label swbstrgy-semaphore ");
        out.print(state.getIconClass());
        out.println("\">");
        out.println(state.getDisplayTitle(lang)==null?state.getTitle():state.getDisplayTitle(lang));
        out.print("</span>");
        //out.println("   </div>");
    }
    out.println("   </div>");
    out.println("  </div> <!-- /.row -->");
    StringBuilder table = new StringBuilder();
    table.append("<div class=\"table-responsive\">").append("\n");
    table.append(" <table class=\"table table-hover tabla-mapa-impacto\">").append("\n");
    table.append("  <thead>").append("\n");
    table.append("   <tr>").append("\n");
    table.append("    <th></th>").append("\n"); // Perspectivas
    table.append("    <th></th>").append("\n"); // Objetivos
    for(Initiative initiative : initiatives) {
        if(!initiative.canView()) {
            continue;
        }
        table.append("<th class=\"thimpact\">");
        //table.append("<p class=\"turn\">");
        table.append(initiative.getDisplayTitle(lang)==null?initiative.getTitle():initiative.getDisplayTitle(lang));
        //table.append("</p>");
        table.append("</th>").append("\n");
    }
    table.append("   </tr>").append("\n");
    table.append("  </thead>").append("\n");
    table.append("  <tbody>").append("\n");

    StringBuilder iconClass;
    Objective obj;
    List<Perspective> perspectives = scorecard.listValidPerspectives();
    Collections.sort(perspectives);
    Perspective p;
    for(int i=0; i<perspectives.size(); i++) {
        p = perspectives.get(i);
        String pTitle = p.getDisplayTitle(lang)==null?(p.getTitle()==null?"Desconocido":p.getTitle().replaceAll("['\n]", "")):p.getDisplayTitle(lang).replaceAll("['\n]", "");
        
        List<Objective> objectives = p.listValidObjectives(period);
        int rowspan = objectives.size();
        Iterator<Objective>it = objectives.iterator();
        if(!it.hasNext()) {
            continue;
        }
        obj = it.next();
        table.append("<tr class=\"swbstrgy-imap-p").append(p.getId()).append("\">").append("\n");
        table.append("<td rowspan=\"").append(rowspan).append("\" class=\"swbstrgy-imap-persp-").append(i%4).append("\">");
        table.append(pTitle);
        table.append("</td>").append("\n");
        table.append("<td class=\"swbstrgy-imap-obj-").append(i%4).append("\">");
        table.append(obj.getDisplayTitle(lang)==null?obj.getTitle():obj.getDisplayTitle(lang));
        table.append("</td>").append("\n");
        for(Initiative initiative:initiatives) {
            if(obj.hasInitiative(initiative)) {
                table.append("<td ");
                try {
                    iconClass = new StringBuilder();
                    //iconClass.append(" class=\"")
                    //        .append(initiative.getPeriodStatus(period).getStatus().getIconClass())
                    //        .append("\"");
                    iconClass.append(" style=\"background-color:"+initiative.getPeriodStatus(period).getStatus().getColorHex()+"\"");
                    table.append(iconClass);
                }catch(Exception e) {
                    table.append(" style=\"background-color:#ccc\"");
                }
                table.append(">");
                table.append("</td>");
            }else {
                table.append("<td style=\"background-color:#FFFFFF\">&nbsp;</td>");
            }
            table.append("\n");
        }
        table.append("</tr>").append("\n");
        
        while(it.hasNext()) {
            obj = it.next();
            table.append("<tr class=\"swbstrgy-imap-p").append(p.getId()).append("\">").append("\n");
            table.append("<td class=\"swbstrgy-imap-obj-").append(i%4).append("\">");
            table.append(obj.getDisplayTitle(lang)==null?obj.getTitle():obj.getDisplayTitle(lang));
            table.append("</td>").append("\n");
            for(Initiative initiative:initiatives) {
                if(obj.hasInitiative(initiative)) {
                    table.append("<td style=\"background-color:");
                    try {
                        table.append(initiative.getPeriodStatus(period).getStatus().getColorHex());
                    }catch(Exception e) {
                        table.append("#FFFFFF");
                    }
                    table.append("\">");
                    table.append("&nbsp;");
                    table.append("</td>");
                }else {
                    table.append("<td style=\"background-color:#FFFFFF\">&nbsp;</td>");
                }
                table.append("\n");
            }
            table.append("</tr>").append("\n");
        }
    }
    table.append("  </tbody>").append("\n");
    table.append(" </table>").append("\n");
    table.append("</div> <!-- /.table-responsive -->").append("\n");
    out.print(table.toString());
    out.println("  </div> <!-- /.panel-body -->");
    out.println("</div> <!-- /.panel -->");
%>