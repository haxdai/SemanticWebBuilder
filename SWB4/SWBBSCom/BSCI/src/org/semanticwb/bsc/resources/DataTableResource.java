
package org.semanticwb.bsc.resources;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.semanticwb.Logger;
import org.semanticwb.SWBException;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.ComponentExportable;
import org.semanticwb.bsc.SM;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.accessory.State;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.bsc.tracing.PeriodStatus;
import org.semanticwb.bsc.tracing.Series;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.GenericResource;
import org.semanticwb.portal.api.SWBActionResponse;
import org.semanticwb.portal.api.SWBParamRequest;
import org.semanticwb.portal.api.SWBResourceException;
import org.semanticwb.portal.api.SWBResourceURL;

/**
 *
 * @author carlos.ramos
 */
public class DataTableResource extends GenericResource implements ComponentExportable{
    private static Logger log = SWBUtils.getLogger(DataTableResource.class);

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        User user = paramRequest.getUser();
        if(user==null || !user.isSigned())
        {
            //response.sendError(403);
            response.flushBuffer();
            return;
        }
        final String lang = user.getLanguage();
         
        final String suri=request.getParameter("suri");
        if(suri==null) {
            response.getWriter().println("No se detect&oacute ning&uacute;n objeto sem&aacute;ntico!");
            return;
        }
        
        SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
        SemanticObject sobj = ont.getSemanticObject(suri);
        if(sobj==null || !(sobj.getGenericInstance() instanceof SM)) {
            response.getWriter().println("No hay instancia de SM");
            return;
        }
        SM sm = (SM)sobj.getGenericInstance();
        Series star = sm.getStar();
        if(star == null) {
            response.getWriter().println("No hay STAR");
            return;
        }
        
        final String prx = getResourceBase().getWebSite().getId() + "_"; 
        
        List<Series> serieses = sm.listValidSerieses();
        Collections.sort(serieses);
        PrintWriter out = response.getWriter();
        
        Iterator<Period> periods;
        try {
            periods = sm.listMeasurablesPeriods();
        }catch(Exception e) {
            List<Period> lperiods = sm.listValidPeriods();
            Collections.sort(lperiods);
            periods = lperiods.iterator();
        }
        out.println("<div class=\"row\">");
        out.println("<div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12 swb-interli\">");
        out.println("<div class=\"table-responsive\">");
        out.println("<table class=\"table table-hover table-striped\">"); 
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>Periodo</th>");
        out.println("<th>Estado</th>");
        for(Series series:serieses) {
            out.println("<th>"+(series.getTitle(lang)==null?series.getTitle():series.getTitle(lang))+"</th>");
        }
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        while(periods.hasNext()) {
            Period period = periods.next();
            boolean inTime = isInMeasurementTime(period);
            out.println("<tr>");
            out.println("<td>");
            out.println(period.getTitle());            
            out.println("</td>");
            out.println("<td>");
            if(star.getMeasure(period)!=null) {
//                Measure measure = Measure.ClassMgr.createMeasure(period.getBSC());
//                star.addMeasure(measure);
//                PeriodStatus ps = PeriodStatus.ClassMgr.createPeriodStatus(period.getBSC());
//                ps.setPeriod(period);
//                measure.setEvaluation(ps);
//                measure.setValue(0);
            
                State state = star.getMeasure(period).getEvaluation().getStatus();
                if(state==null) {
                    state = sm.getMinimumState();
                    star.getMeasure(period).getEvaluation().setStatus(state);
                }
                if(state==null) {
                    out.println("<span class=\"state-unknown\">Desconocido</span>");
                }else {
                    String title = state.getTitle(lang)==null?state.getTitle():state.getTitle(lang);
                    out.println("<span class=\""+(state.getIconClass()==null?"state-undefined":state.getIconClass())+"\">"+title+"</span>");
                }
                
            }else {
                out.println("--");
            }
            out.println("</td>");
            for(Series series:serieses) {
                out.println("<td>");
                String value = series.getMeasure(period)==null?"--":series.getFormatter().format(series.getMeasure(period).getValue());
                if(inTime && !series.isReadOnly() && userCanEdit()) {
                    SWBResourceURL url = paramRequest.getActionUrl();
                    url.setAction(SWBResourceURL.Action_EDIT);
                    url.setParameter("suri", suri);
                    url.setParameter("pid", period.getId());
                    url.setParameter("sid", series.getId());
                    out.println(renderUpdateInline(prx+series.getId(), url.toString(), value, false, "dijit.form.TextBox", "swb-ile"));
                    //out.print("<input type=\"text\" value=\""+value+"\" name=\"a\" onchange=\"\" />");
                }else {                    
                    out.print(value);
                }
                out.println("</td>");
            }
            out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
    }
    
    @Override
    public void doAdmin(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        Resource base = getResourceBase();
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        final String lang = user.getLanguage();

        String action  = paramRequest.getAction();
        if(SWBParamRequest.Action_ADD.equals(action)) {
            out.println("<script type=\"text/javascript\">");
            out.println("<!--");
            out.println("   alert('"+paramRequest.getLocaleString("msg_Admin_OkUpdateResource")+" "+base.getId() + "');");
            out.println("   location='" + paramRequest.getRenderUrl().setAction(paramRequest.Action_EDIT).toString() + "';");
            out.println("-->");
            out.println("</script>");
        }
        
        WebSite wsite = base.getWebSite();

        String str_role = base.getAttribute("editRole", "0");

        SWBResourceURL urlAction = paramRequest.getActionUrl();
        urlAction.setAction(SWBParamRequest.Action_ADD);

        out.println("<div class=\"swbform\">");
        out.println("<form id=\"" + base.getId() + "/InLineEditRes\" action=\""+urlAction+"\" method=\"post\" >");
        out.println("<fieldset>");
        out.println("<legend>");
        out.println(paramRequest.getLocaleString("lbl_Admin_Basic"));
        out.println("</legend>");
        out.println("<ul class=\"swbform-ul\">");
        
        String selected = str_role.equals("0")?" selected=\"selected\" ":"";
       
        StringBuilder strRules = new StringBuilder();
        strRules.append("\n<optgroup label=\"");
        strRules.append(paramRequest.getLocaleString("lbl_Admin_Roles"));
        strRules.append("\">");
        Iterator<Role> iRoles = wsite.getUserRepository().listRoles();
        while (iRoles.hasNext()) {
            Role oRole = iRoles.next();
            selected = str_role.equals(oRole.getURI())?" selected=\"selected\" ":"";
            strRules.append("\n<option value=\"");
            strRules.append(oRole.getURI());
            strRules.append("\"");
            strRules.append(selected);
            strRules.append(">");
            strRules.append(oRole.getDisplayTitle(lang));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        strRules.append("\n<optgroup label=\"");
        strRules.append(paramRequest.getLocaleString("lbl_Admin_UserGroups"));
        strRules.append("\">");
        Iterator<UserGroup> iugroups = wsite.getUserRepository().listUserGroups();
        while (iugroups.hasNext()) {
            UserGroup oUG = iugroups.next();
            selected = str_role.equals(oUG.getURI())?" selected=\"selected\" ":"";
            strRules.append("\n<option value=\"");
            strRules.append(oUG.getURI());
            strRules.append("\"");
            strRules.append(selected);
            strRules.append(">");
            strRules.append(oUG.getDisplayTitle(lang)==null?oUG.getTitle():oUG.getDisplayTitle(lang));
            strRules.append("</option>");
        }
        strRules.append("\n</optgroup>");
        
        out.println("   <li class=\"swbform-li\">");
        out.println("       <label for=\"editar\" class=\"swbform-label\">"+paramRequest.getLocaleString("lbl_Admin_GrantPermissions")+"</label>");
        out.println("       <select name=\"editar\">" + strRules + "</select>");
        out.print("     </li>");
        
//        out.println("   <li class=\"swbform-li\">");
//        out.println("       <label for=\"autosave\" class=\"swbform-label\">"+paramRequest.getLocaleString("lbl_Admin_Autosave")+"</label>");
//        out.println("       <input type=\"checkbox\" name=\"autosave\" id=\"autosave\" value=\"true\" "+(Boolean.parseBoolean(base.getAttribute("autosave"))?"checked=\"checked\"":"")+" dojoType=\"dijit.form.CheckBox\" promptMessage=\""+paramRequest.getLocaleString("msg_Admin_PrompAutosave")+"\" />");
//        out.print("     </li>");
        out.println("   <li class=\"swbform-li\">");
        out.println("       <label for=\"left\" class=\"swbform-label\">"+paramRequest.getLocaleString("lbl_Admin_Before")+"</label>");
        out.println("       <input type=\"text\" name=\"left\" id=\"left\" maxlength=\"2\" value=\""+base.getAttribute("left","7")+"\" regExp=\"\\d{1,2}\" dojoType=\"dijit.form.ValidationTextBox\" invalidMessage=\""+paramRequest.getLocaleString("msg_Admin_IncorrectAmount")+"\"  promptMessage=\""+paramRequest.getLocaleString("msg_Admin_PrompAmountBefore")+"\" />");
        out.print("     </li>");
        out.println("   <li class=\"swbform-li\">");
        out.println("       <label for=\"right\" class=\"swbform-label\">"+paramRequest.getLocaleString("lbl_Admin_After")+"</label>");
        out.println("       <input type=\"text\" name=\"right\" id=\"right\" maxlength=\"2\" value=\""+base.getAttribute("right","7")+"\" regExp=\"\\d{1,2}\" dojoType=\"dijit.form.ValidationTextBox\" invalidMessage=\""+paramRequest.getLocaleString("msg_Admin_IncorrectAmount")+"\"  promptMessage=\""+paramRequest.getLocaleString("msg_Admin_PrompAmountAfter")+"\" />");
        out.print("     </li>");
        out.println("   <li class=\"swbform-li\">");
        out.println("       <label for=\"time\" class=\"swbform-label\">"+paramRequest.getLocaleString("lbl_Admin_UnitOfTime")+"</label>");
        out.println("       <select name=\"time\" dojoType=\"dijit.form.FilteringSelect\">");
        out.println("         <option "+(base.getAttribute("time",Integer.toString(Calendar.DATE)).equals(Integer.toString(Calendar.DATE))?"selected=\"selectted\"":"")+" value=\""+Calendar.DATE+"\">"+paramRequest.getLocaleString("lbl_Admin_Date") +"</option>");
        out.println("         <option "+(base.getAttribute("time","").equals(Integer.toString(Calendar.WEEK_OF_MONTH))?"selected=\"selectted\"":"")+" value=\""+Calendar.WEEK_OF_MONTH+"\">"+paramRequest.getLocaleString("lbl_Admin_WeekOfMonth") +"</option>");
        out.println("         <option "+(base.getAttribute("time","").equals(Integer.toString(Calendar.WEEK_OF_YEAR))?"selected=\"selectted\"":"")+" value=\""+Calendar.WEEK_OF_YEAR+"\">"+paramRequest.getLocaleString("lbl_Admin_WeekOfYear") +"</option>");
        out.println("         <option "+(base.getAttribute("time","").equals(Integer.toString(Calendar.MONTH))?"selected=\"selectted\"":"")+" value=\""+Calendar.MONTH+"\">"+paramRequest.getLocaleString("lbl_Admin_Month") +"</option>");
        out.println("         <option "+(base.getAttribute("time","").equals(Integer.toString(Calendar.YEAR))?"selected=\"selectted\"":"")+" value=\""+Calendar.YEAR+"\">"+paramRequest.getLocaleString("lbl_Admin_Year") +"</option>");
        out.println("       </select>");
        out.print("     </li>");
        out.print("</ul>");
        out.println("</fieldset>");
        out.println("<fieldset>");
        out.println("<button dojoType=\"dijit.form.Button\" type=\"submit\" name=\"btn\" >" + paramRequest.getLocaleString("lbl_Admin_Save") + "</button>");
        out.println("<button dojoType=\"dijit.form.Button\" type=\"reset\" name=\"btn\" >" + paramRequest.getLocaleString("lbl_Admin_Reset") + "</button>");
        out.println("</fieldset>");
        out.println("</form>");
        out.println("</div>");
    }

    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        Resource base = getResourceBase();
        String action = response.getAction();

        if(SWBActionResponse.Action_ADD.equals(action))
        {
            String attr = request.getParameter("editar");
            if(attr != null) {
                base.setAttribute("editRole", attr);                
            }
//            attr = request.getParameter("autosave")==null?"false":"true";
//            base.setAttribute("autosave", attr);
            attr = request.getParameter("left");
            try {
                Integer.parseInt(attr);
                base.setAttribute("left", attr);
            }catch(NumberFormatException nfe) {
                base.setAttribute("left", "10");
            }
            
            attr = request.getParameter("right");
            try {
                Integer.parseInt(attr);
                base.setAttribute("right", attr);
            }catch(NumberFormatException nfe) {
                base.setAttribute("right", "10");
            }
            
            attr = request.getParameter("time");
            base.setAttribute("time", attr);
            
            try {
                base.updateAttributesToDB();
            }catch(SWBException e) {
                log.error("Error al guardar Role/UserGroup para acceso al InlineEdit.",e);
            }finally {
                response.setAction(SWBActionResponse.Action_ADD);
            }
        }
        else
        {
            final String suri = request.getParameter("suri");
            response.setRenderParameter("suri", suri);

            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject sobj = ont.getSemanticObject(suri);
            if(sobj==null) {
                response.setRenderParameter("statmsg", response.getLocaleString("msgNoSuchSemanticElement"));
                return;
            }
            
            String data = request.getParameter("value");
            WebSite model = base.getWebSite();
            String pid = request.getParameter("pid");
            String sid = request.getParameter("sid");
            if(Period.ClassMgr.hasPeriod(pid, model) && Series.ClassMgr.hasSeries(sid, model)) {
                Period period = Period.ClassMgr.getPeriod(pid, model);
                Series series = Series.ClassMgr.getSeries(sid, model);
                Measure measure = series.getMeasure(period);
                if(measure == null) {
                    measure = Measure.ClassMgr.createMeasure(model);
                    PeriodStatus ps = PeriodStatus.ClassMgr.createPeriodStatus(model);
                    ps.setPeriod(period);
                    measure.setEvaluation(ps);
                    series.addMeasure(measure);
                }

                float value = 0;
                try {
                    value = Float.parseFloat(data);
                }catch(NumberFormatException nfe) {
                    try {
                        Number number = series.getFormatter().parse(data);
                        value = number.floatValue();
                    }catch(ParseException pe) {
                        value = 0;
                    }catch(Exception e) {
                        value = 0;
                    }
                }finally {
                    measure.setValue(value);
                    measure.evaluate();
                    series.getSm().updateAppraisal(period);
                }
            }else {
//TODO algo va aqui
            }
            response.sendRedirect(response.getWebPage().getUrl()+"?suri="+URLEncoder.encode(suri,"UTF-8"));
        }
    }
    
    private boolean isInMeasurementTime(final Period period) {
        Resource base = getResourceBase();
        int tleft, tright, type;
        try {
            tleft = Integer.parseInt(base.getAttribute("left", "7"));
        }catch(NumberFormatException e) {
            tleft = 0;
        }
        try {
            tright = Integer.parseInt(base.getAttribute("right", "7"));
        }catch(NumberFormatException e) {
            tright = 0;
        }
        
        
        try {
            type = Integer.parseInt(base.getAttribute("time",Integer.toString(Calendar.DATE)));
        }catch(NumberFormatException nfe) {
            type = Calendar.DATE;
        }
        
        GregorianCalendar current = new GregorianCalendar();
        Date end = period.getEnd();
        if(end==null) {
            return false;
        }
        GregorianCalendar left = new GregorianCalendar();
        left.setTime(end);
        left.add(type, -tleft);
        GregorianCalendar right = new GregorianCalendar();
        right.setTime(end);
        right.add(type, tright);
        return current.compareTo(left)>=0 && current.compareTo(right)<=0;
    }
    
    private boolean userCanEdit() {
        boolean access = false;
        String str_role = getResourceBase().getAttribute("editRole", null);
        final User user = SWBContext.getSessionUser(getResourceBase().getWebSite().getUserRepository().getId());
        
        if(user!=null && str_role!=null)
        {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj = null;
            try {
                gobj = ont.getGenericObject(str_role);
            }catch(Exception e) {
                log.error("Errror InlineEdit.userCanEdit()", e);
                return Boolean.FALSE;
            }

            UserGroup ugrp = null;
            Role urole = null;

            if(gobj != null) {
                if(gobj instanceof UserGroup) {
                    ugrp = (UserGroup) gobj;
                    if(user.hasUserGroup(ugrp)) {
                        access = true;
                    }
                }else if(gobj instanceof Role) {
                    urole = (Role) gobj;
                    if(user.hasRole(urole)) {
                        access = true;
                    }
                }
            }
        }
        return access;
    }
    
    private String renderUpdateInline(final String objId, final String url, final String data, final boolean autosave, final String editor, final String cssClass) {
        StringBuilder script = new StringBuilder();
        script.append("<script type=\"text/javascript\">\n");
        script.append("<!--\n");
        script.append("var iledit_" + objId + ";");
        script.append("dojo.addOnLoad( function() {");
        script.append("    iledit_" + objId + " = new dijit.InlineEditBox({");
        script.append("    id: \"ile_" + objId + "\",");
        script.append("    autoSave: "+autosave+",");
        script.append("    editor: \""+editor+"\",");
        script.append("    editorParams: {trim:true, required:true},");
        script.append("    width: '80px',");
        script.append("    onChange: function(value){");
        //script.append("           getSyncHtml('" + url + (url.contains("?")?"&":"?") + "value='+value);");
        script.append("           location.href='" + url + (url.contains("?")?"&":"?") + "value='+value;");
        script.append("      }");
        script.append("    }, 'eb_" + objId + "');");
        script.append("  }");
        script.append("); iledit_"+objId+".startup();\n");
        script.append("-->\n");
        script.append("</script>\n");
        script.append("<span id=\"eb_" + objId + "\" class=\""+cssClass+"\">" + data + "</span>");
        return script.toString();
    }

    /**
     * Genera el c&oacute;digo HTML de la tabla de datos usado en la 
     * exportaci&oacute;n a PDF del componente
     * 
     * @param request Proporciona informaci&oacute;n de petici&oacute;n HTTP
     * @param paramRequest Objeto con el cual se acceden a los objetos de SWB
     * @return el objeto String que representa el c&oacute;digo HTML con los
     * datos a exportar(Tabla de datos de un indicador)
     * @throws SWBResourceException SWBResourceException SWBResourceException
     * Excepti&oacute;n utilizada para recursos de SWB
     * @throws IOException Excepti&oacute;n de IO
     * 
     */
    @Override
    public String doComponentExport(HttpServletRequest request, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        StringBuilder sb = new StringBuilder();
        User user = paramRequest.getUser();
        final String suri = request.getParameter("suri");

        if (suri == null) {
            sb.append("No se detect&oacute ning&uacute;n objeto sem&aacute;ntico!");
        }
        if (user != null && user.isSigned() && suri != null) {
            final String lang = user.getLanguage();
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            SemanticObject sobj = ont.getSemanticObject(suri);
            if (sobj != null && (sobj.getGenericInstance() instanceof Indicator)) {
                Indicator indicator = (Indicator) sobj.getGenericInstance();
                Series star = indicator.getStar();
                if (star != null) {
                    List<Series> serieses = indicator.listValidSerieses();
                    Collections.sort(serieses);

                    Iterator<Period> periods;
                    try {
                        periods = indicator.listMeasurablesPeriods();
                    } catch (Exception e) {
                        List<Period> lperiods = indicator.listValidPeriods();
                        Collections.sort(lperiods);
                        periods = lperiods.iterator();
                    }
                    sb.append("<table class=\"detail data-table\">");
                    sb.append("<thead>");
                    sb.append("<tr>");
                    sb.append("<th>Periodo</th>");
                    sb.append("<th>Estado</th>");
                    for (Series series : serieses) {
                        sb.append("<th>");
                        sb.append((series.getTitle(lang) == null ? series.getTitle() 
                                : series.getTitle(lang)));
                        sb.append("</th>");
                    }
                    sb.append("</tr>");
                    sb.append("</thead>");
                    sb.append("<tbody>");
                    while (periods.hasNext()) {
                        Period period = periods.next();
                        sb.append("<tr>");
                        sb.append("<td>");
                        sb.append(period.getTitle());
                        sb.append("</td>");
                        sb.append("<td>");
                        if (star.getMeasure(period) != null) {
                            State state = star.getMeasure(period).getEvaluation().
                                    getStatus();
                            if (state == null) {
                                state = indicator.getMinimumState();
                                star.getMeasure(period).getEvaluation().setStatus(state);
                            }
                            String title = state.getTitle(lang) == null ? state.getTitle() : 
                                    state.getTitle(lang);
                            sb.append("<span class=\"");
                            sb.append((state.getIconClass() == null ? "state-undefined" : 
                                    state.getIconClass()));
                            sb.append("\">");
                            sb.append(title);
                            sb.append("</span>");
                        } else {
                            sb.append("--");
                        }
                        sb.append("</td>");
                        for (Series series : serieses) {
                            sb.append("<td>");
                            String value = series.getMeasure(period) == null ? "--" : 
                                    series.getFormatter().format(series.getMeasure(period).
                                    getValue());
                            sb.append(value);
                            sb.append("</td>");
                        }
                        sb.append("</tr>");
                    }
                    sb.append("</tbody>");
                    sb.append("</table>");
                } else {
                    sb.append("No hay STAR");
                }
            } else {
                sb.append("No hay indicador");
            }
        }
        return sb.toString();
    }
}
