<%-- 
    Document   : recoverPeriods
    Created on : 08/06/2016, 04:58:02 PM
    Author     : carlos.ramos
--%>
<%@page import="org.semanticwb.model.base.SWBContextBase"%>
<%@page import="org.semanticwb.model.*"%>
<%@page import="org.semanticwb.bsc.*,org.semanticwb.bsc.element.*,org.semanticwb.bsc.accessory.*" %>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Recuperar períodos</h1>
        <p>Lista los periodos existentes y los agrupa por año. Los grupos son de
            tipo PeriodGroup. Si el grupo período no existe entonces es creado</p>
        
<%!
    private PeriodGroup getPeriodGroupByTitle(final WebSite model, final String title) {
System.out.println("°°°°°°° getPeriodGroupByTitle");
        PeriodGroup pg = null;
        Iterator<PeriodGroup> groups = PeriodGroup.ClassMgr.listPeriodGroups(model);
        PeriodGroup aux;
        while(groups.hasNext()) {
            aux = groups.next();
            if(aux==null) {
                continue;
            }
System.out.println("periodGroup="+aux.getTitle());
            if(aux.getTitle().equalsIgnoreCase(title)
                ||
               aux.getTitle("es").equalsIgnoreCase(title))
            {
                return aux;
            }
        }
        return pg;
    }
%>
<%
final String siteid = "infotec";
WebSite model = SWBContext.getWebSite(siteid);
if(model!=null)
{
    SimpleDateFormat yyyy = new SimpleDateFormat("yyyy", new Locale("es","MX"));
    SimpleDateFormat dMy = new SimpleDateFormat("dd/MM/yyyy", new Locale("es","MX"));
    Iterator<Period>periods = Period.ClassMgr.listPeriods(model);
    Period p;
    PeriodGroup pg;
    String year;
    while(periods.hasNext()) {
    //for(int i=0; i<2&&periods.hasNext(); i++) {
        p = periods.next();
        if(p==null) {
            out.println("<p>periodo nulo</p>");
            continue;
        }
        /*if(!p.isValid()) {
            out.println("<p>periodo inválido..........</p>");
            continue;
        }*/
        if(p.getStart()==null) {
            out.println("<p>periodo con fecha inicio nula</p>");
            continue;
        }
        year = yyyy.format(p.getStart());
        pg = getPeriodGroupByTitle(model, year);
        if(pg==null) {
            pg = PeriodGroup.ClassMgr.createPeriodGroup(model);
            pg.setTitle(year);
            pg.setTitle(year, "es");
            pg.setTitle(year, "en");
        }
        if(!pg.hasGroupedPeriod(p)) {
            pg.addGroupedPeriod(p);
        }
        
        out.println("<p>");
        out.println("periodo="+p.getTitle()+", borrable:"+p.isUndeleteable());
        out.println("fecha inicio="+dMy.format(p.getStart()));
        out.println("</p>");
        out.println("<hr>");
    }
}
else
{
    out.println("<h3>Modelo "+siteid+" nulo</h3>");
}
%>        
    </body>
</html>
