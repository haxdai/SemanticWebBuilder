package com.infotec.eworkplace.swb.resources.sem;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.*;

import com.infotec.eworkplace.swb.ReservacionSala;
import com.infotec.eworkplace.swb.Sala;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.semanticwb.Logger;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.GenericObject;
import org.semanticwb.model.Resource;
import org.semanticwb.model.ResourceType;
import org.semanticwb.model.Resourceable;
import org.semanticwb.model.Role;
import org.semanticwb.model.SWBComparator;
import org.semanticwb.model.User;
import org.semanticwb.model.UserGroup;
import org.semanticwb.model.WebPage;
import org.semanticwb.model.WebSite;
import org.semanticwb.platform.SemanticObject;
import org.semanticwb.platform.SemanticOntology;
import org.semanticwb.portal.api.*;
import org.semanticwb.portal.api.SWBResourceURL;
import org.semanticwb.process.model.FlowNodeInstance;
import org.semanticwb.process.model.Instance;
import org.semanticwb.process.model.ItemAwareReference;

public class ReservaSalaManager extends com.infotec.eworkplace.swb.resources.sem.base.ReservaSalaManagerBase {
    private static Logger log = SWBUtils.getLogger(ReservaSalaManager.class);
    public static final String Mode_ROLL = "roll";
    public static final String Mode_SALA = "sala";
    public static final String Roll_DATE = "date";
    public static final String Roll_MONTH = "month";
    public static final String Rel = "rel";
    public static final String Roll = "roll";
    public static final String Roll_RIGHT = "right";
    public static final String Roll_LEFT = "left";
    public static final String Set_DATE = "dom";
    
    public static final int Cleaning_Time = 29;
    
    public static final SimpleDateFormat dateDojo = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat HHmm = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat HH = new SimpleDateFormat("HH:");
    public static final int MIN_TIME = 89;
    public static final int QUORUM = 5;
    public static final int START_HOUR = 7; // 07:00 hrs
    public static final int START_MIN = 420; // 07:00 hrs en minutos
    
    private static IconClass iconClass = IconClass.u;
        
    public ReservaSalaManager() {
    }

   /**
   * Constructs a ReservaSalaManager with a SemanticObject
   * @param base The SemanticObject with the properties for the ReservaSalaManager
   */
    public ReservaSalaManager(org.semanticwb.platform.SemanticObject base) {
        super(base);
    }

    @Override
    public void processRequest(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        User user = paramRequest.getUser();
        if(!user.isSigned() || user.haveAccess(this)) {
            return;
        }
        
        String mode = paramRequest.getMode();
        if(Mode_ROLL.equals(mode))
        {
            doRoll(request, response, paramRequest);
        }
        else if(Mode_SALA.equals(mode))
        {
            doViewSala(request, response, paramRequest);
        }
        else
        {
            super.processRequest(request, response, paramRequest);
        }
    }

    @Override
    public void doView(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
            renderReservations(request, response, paramRequest);
    }
    
    private void setRenderParameter(HttpServletRequest request, SWBActionResponse response) {
        response.setRenderParameter("sl", request.getParameter("sl"));
        response.setRenderParameter("fd", request.getParameter("fd"));
        response.setRenderParameter("sh", request.getParameter("sh"));
        response.setRenderParameter("fh", request.getParameter("fh"));
        response.setRenderParameter("turnout", request.getParameter("turnout"));
        response.setRenderParameter("tpmeet", request.getParameter("tpmeet"));
        response.setRenderParameter("cfslb", request.getParameter("cfslb"));
        response.setRenderParameter("cfgrn", request.getParameter("cfgrn"));
        response.setRenderParameter("h2o", request.getParameter("h2o"));
        response.setRenderParameter("sds", request.getParameter("sds"));
        response.setRenderParameter("cks", request.getParameter("cks"));
        response.setRenderParameter("tmsrvc", request.getParameter("tmsrvc"));
        response.setRenderParameter("hrsrvc", request.getParameter("hrsrvc"));
        response.setRenderParameter("mtv", request.getParameter("mtv"));
        response.setRenderParameter("prjctr", request.getParameter("prjctr"));
        response.setRenderParameter("pcs", request.getParameter("pcs"));
        response.setRenderParameter("osrvcs", request.getParameter("osrvcs"));
    }
    
    @Override
    public void processAction(HttpServletRequest request, SWBActionResponse response) throws SWBResourceException, IOException {
        User user = response.getUser();
        if(!user.isSigned() || user.haveAccess(this)) {
            return;
        }
        
        response.setRenderParameter("suri", request.getParameter("suri"));
        Resource base = getResourceBase();
        WebSite model = base.getWebSite();
        String action = response.getAction();
        
        if(response.getMode().equals(SWBResourceURL.Mode_EDIT))
        {
            ReservacionSala reservation = ReservacionSala.ClassMgr.getReservacionSala(request.getParameter("rid"), model);
            FlowNodeInstance fni = getFlowNodeInstance(URLDecoder.decode(request.getParameter("suri"), "UTF-8"));
            if (reservation!=null && fni!=null) {
                //Enviar los datos a process
                LinkReserva(reservation, fni);
                String url = getTaskInboxUrl(fni);
                //Cerrar la tarea
                fni.close(user, Instance.ACTION_ACCEPT);
                if(url != null) {
                    response.sendRedirect(url);
                }
            }
            else
            {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrProcess"));
                response.setMode(SWBResourceURL.Mode_VIEW);
            }
        }
        else if(SWBResourceURL.Action_ADD.equals(action))
        {
            HttpSession session = request.getSession(true);
            GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
            
            Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));

            Sala sala = null;
            try {
                sala = Sala.ClassMgr.getSala(request.getParameter("sl"), model);
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrRoomMismatch"));
                setRenderParameter(request, response);
                return;
            }
            if(sala==null) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrRoomMismatch"));
                setRenderParameter(request, response);
                return;
            }
            
            int sh,fh;
            try {
                sh = Integer.parseInt(request.getParameter("sh"));
                fh = Integer.parseInt(request.getParameter("fh"));
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrHourMismatch"));
                setRenderParameter(request, response);
                return;
            }
            fh += 30;
            if(fh-sh<MIN_TIME) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrHourMismatch"));
                setRenderParameter(request, response);
                return;
            }
            
            GregorianCalendar csd = new GregorianCalendar(locale), cfd = null;
            try {
                csd.setTime(current.getTime());
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrHourMismatch"));
                setRenderParameter(request, response);
                return;
            }

            reset(csd);
            csd.set(Calendar.MINUTE, sh);            
            try {
                Date fd = dateDojo.parse(request.getParameter("fd"));
                cfd = new GregorianCalendar(locale);
            cfd.setTime(fd);
            }catch(ParseException e) {
                response.setRenderParameter("alertmsg", "5 ..."+response.getLocaleString("msgErrHourMismatch"));
                setRenderParameter(request, response);
                return;
            }
            reset(cfd);
            cfd.set(Calendar.MINUTE, fh);
            
            String mtv = SWBUtils.XML.replaceXMLChars(request.getParameter("mtv"));
            if(mtv.isEmpty()) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrMoviteMissing"));
                setRenderParameter(request, response);
                return;
            }

            ReservacionSala.TipoReunion tpmeet; 
            try {
                tpmeet = ReservacionSala.TipoReunion.valueOf(request.getParameter("tpmeet"));
            }catch(Exception e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrMeetTypeMissing"));
                setRenderParameter(request, response);
                return;
            }
            
            ReservacionSala.Horario tmsrvc = null;
            String hrsrvc = null;
            if(ReservacionSala.TipoReunion.Externa == tpmeet) {
                try {
                    tmsrvc = ReservacionSala.Horario.valueOf(request.getParameter("tmsrvc"));
                }catch(Exception e) {
                    response.setRenderParameter("alertmsg", response.getLocaleString("msgErrCafeServiceMissing"));
                    setRenderParameter(request, response);
                    return;
                }
                
                if(ReservacionSala.Horario.Receso == tmsrvc) {
                    hrsrvc = SWBUtils.XML.replaceXMLChars(request.getParameter("hrsrvc"));
                    if(hrsrvc.isEmpty()) {
                        response.setRenderParameter("alertmsg", "10 ..."+response.getLocaleString("msgErrCafeServiceMissing"));
                        setRenderParameter(request, response);
                        return;
                    }
                }
            }
            
            int turnout = 0;
            try {
                turnout = Integer.parseInt(request.getParameter("turnout"));
            }catch(NumberFormatException e) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrTurnOutMissing"));
                setRenderParameter(request, response);
                return;
            }
            if(turnout<QUORUM) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrTurnOutMissingQuorum"));
                setRenderParameter(request, response);
                return;
            }
            if(sala.getCapacidad()<turnout) {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrTurnOutMismatch"));
                setRenderParameter(request, response);
                return;
            }
            
            if(!sala.isReservada(csd, cfd)) {
                ReservacionSala reservation = ReservacionSala.ClassMgr.createReservacionSala(model);
                reservation.setSala(sala);
                reservation.setIconClass(getIconClass());
                reservation.setFechaInicio(csd.getTime());
                reservation.setFechaFinal(cfd.getTime());
                reservation.setAsistentes(turnout);
                reservation.setMotivo(mtv);
                reservation.setTipoReunion(tpmeet.toString());
                if(ReservacionSala.TipoReunion.Externa == tpmeet) {
                    reservation.setRequiereCafeGrano(request.getParameter("cfgrn")!=null);
                    reservation.setRequiereCafeSoluble(request.getParameter("cfslb")!=null);
                    reservation.setRequiereRefrescos(request.getParameter("sds")!=null);
                    reservation.setRequiereAgua(request.getParameter("h2o")!=null);
                    reservation.setRequiereGalletas(request.getParameter("cks")!=null);
                    if(ReservacionSala.Horario.Receso == tmsrvc) {
                        reservation.setRequiereServicioContinuo(false);
                        reservation.setHorarioServicio(hrsrvc);
                    }else {
                        reservation.setRequiereServicioContinuo(true);
                    }
                }
                reservation.setRequiereProyector(request.getParameter("prjctr")!=null);
                reservation.setRequiereComputo(request.getParameter("pcs")!=null);
                if(!request.getParameter("osrvcs").isEmpty()) {
                    reservation.setServiciosAdicionales(request.getParameter("osrvcs").trim());
                }
                                
                FlowNodeInstance fni = getFlowNodeInstance(request.getParameter("suri"));
                if(fni != null) {
                    reservation.setPId(fni.getProcessInstance().getId());
                    response.setRenderParameter("alertmsg", response.getLocaleString("msgReservationDoneOk"));
                    response.setRenderParameter("rid", reservation.getId());
                    response.setMode(SWBResourceURL.Mode_EDIT);
                }else {
                    response.setRenderParameter("alertmsg", response.getLocaleString("msgErrProcess"));
                }
            }else {
                response.setRenderParameter("alertmsg", response.getLocaleString("msgErrReservationMismatch"));
                setRenderParameter(request, response);
            }
        }
    }

    @Override
    public void doEdit(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.addOnLoad(function() {");
        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
            out.println(" alert('"+request.getParameter("alertmsg")+"');");
            out.println(" window.location.href='"+paramRequest.getActionUrl().setParameter("suri", URLEncoder.encode(request.getParameter("suri"), "UTF-8")).setParameter("rid", request.getParameter("rid"))+"';");
        }        
        out.println(" });");
        out.println("-->");
        out.println("</script>");
    }
    
    public void doViewSala(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException {
        response.setContentType("text/html; charset=utf-8");
        
        PrintWriter out = response.getWriter();
        User user = paramRequest.getUser();
        Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
        
        GregorianCalendar current;
        HttpSession session = request.getSession(true);
        if(session.getAttribute("cur")==null) {
            current = new GregorianCalendar(locale);
            session.setAttribute("cur", current);
        }else {
            current = (GregorianCalendar)session.getAttribute("cur");
        }

        
        String uri = SWBUtils.XML.replaceXMLChars(request.getParameter("sl"));
        //String uri = request.getParameter("sl");
        uri = URLDecoder.decode(uri, "UTF-8");
        Sala sala = null;
        try {
            sala = (Sala)SemanticObject.createSemanticObject(uri).createGenericInstance();
        }catch(Exception e) {
            log.error(e);
            e.printStackTrace(System.out);
        }
        
        if(sala==null) {
            out.println("<p>"+paramRequest.getLocaleString("msgErrRoomMismatch")+"</p>");
            return;
        }
        
        Calendar cur =  Calendar.getInstance(locale);
        cur.setMinimalDaysInFirstWeek(1);
        cur.setFirstDayOfWeek(1);
        cur.setTime(current.getTime());
        final int month = cur.get(Calendar.MONTH);
        final int wom = cur.getActualMaximum(Calendar.WEEK_OF_MONTH);
        final int dow = cur.get(Calendar.DAY_OF_WEEK);
        cur.add(Calendar.DAY_OF_MONTH, 1-dow);
        int wk;
        try {
            wk = Integer.parseInt(request.getParameter("wk"));
        }catch(Exception e) {
            wk = cur.get(Calendar.WEEK_OF_MONTH);
        }
        out.println("<div>");
        
//        out.println("<div id=\"salas-regresar\">");
//        out.println(" <a href=\""+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW) +"\" title=\"Regresar\" class=\"backCal\">Regresar</a>");
//        out.println("</div>");
        
        out.println("<div id=\"salas-semanas\">");
        out.println(" <h3 class=\"sala-h3sala\">"+sala.getDisplayTitle(locale.getLanguage())+"</h3>");
        out.println(" <h3 class=\"sala-h3semana\">Semana "+wk+"</h3>");
        out.println("</div>");
//        if(wk>1)
//            out.println("<a href=\"#\" title=\"\">anterior</a>");
//        if(wk<wom)
//            out.println("&nbsp;<a href=\"#\" title=\"\">siguiente</a>");
        out.println("<div>");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd", locale);
        out.println("<table id=\"mainTableCalSemana\">");
        out.println("<thead>");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <th class=\"thCalHora\">Hora</th>");       
        final int fdcw = cur.get(Calendar.DAY_OF_MONTH);
        if(wk==1) {
            for(int k=1; k<=7; k++) {
                if(k>=dow && k<7)
                    out.println("  <th>"+sdf.format(cur.getTime())+"</th>");
                else if(k>1 && k<7)
                    out.println("  <th class=\"deactive\">"+sdf.format(cur.getTime())+"</th>");
                cur.add(Calendar.DATE, 1);
            }
        }else {
            for(int k=1; k<=7; k++) {
                if(month<cur.get(Calendar.MONTH) && k<7)
                    out.println("  <th class=\"deactive\">"+sdf.format(cur.getTime())+"</th>");
                else if(k>1 && k<7)
                    out.println("  <th>"+sdf.format(cur.getTime())+"</th>"); 
                cur.add(Calendar.DATE, 1);
            }
        }
        out.println(" </tr>");
        out.println("</thead>");
        
        sdf = new SimpleDateFormat("HH:mm");
        GregorianCalendar begin = new GregorianCalendar(cur.get(Calendar.YEAR),cur.get(Calendar.MONTH),fdcw,0,0,0);
        begin.set(Calendar.MINUTE, START_MIN);
        GregorianCalendar end = new GregorianCalendar(cur.get(Calendar.YEAR),cur.get(Calendar.MONTH),fdcw,0,0,0);
        end.set(Calendar.MINUTE, 449);
        
        ReservacionSala myReservation;
        out.println("<tbody>");
        for(int i=1; i<=15; i++) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+sdf.format(begin.getTime())+"</p></td>");
            if(wk==1) {
                for(int k=1; k<=7; k++) {
                    if(k>=dow && k<7) {
                        myReservation = sala.getReserva(begin, end);
                        if(myReservation!=null) {
                            out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                        }else {
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                        }
                    }else if(k>1 && k<7) {
                        out.println("  <td title=\"3\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }else {
                 for(int k=1; k<=7; k++) {
                    if(month<cur.get(Calendar.MONTH) && k<7) {
                        out.println("  <td id=\""+sala.getId()+"___"+cur.getTimeInMillis()+"\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }else if(k>1&&k<7) {
                        myReservation = sala.getReserva(begin, end);
                        if(myReservation!=null) {
                            out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                        }else {
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                        }
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }
            out.println(" </tr>");
            begin.set(Calendar.DAY_OF_MONTH, fdcw);
            begin.add(Calendar.MINUTE, 30);
            end.set(Calendar.DAY_OF_MONTH, fdcw);
            end.add(Calendar.MINUTE, 30);
            out.println(" <tr>");
            if(wk==1) {
                for(int k=1; k<=7; k++) {
                    if(k>=dow && k<7) {
                        myReservation = sala.getReserva(begin, end);
                        if(myReservation!=null) {
                            out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                        }else {
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                        }
                    }else if(k>1 && k<7) {
                        out.println("  <td class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }else {
                 for(int k=1; k<=7; k++) {
                    if(month<cur.get(Calendar.MONTH) && k<7) {
                        out.println("  <td title=\"9\" class=\"deactive sltc trCal1\">&nbsp;</td>");
                    }else if(k>1&&k<7) {
                        myReservation = sala.getReserva(begin, end);
                        if(myReservation!=null) {
                            out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                        }else {
                            out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                        }
                    }
                    begin.add(Calendar.DATE, 1);
                    end.add(Calendar.DATE, 1);
                }
            }
            out.println(" </tr>");
            begin.set(Calendar.DAY_OF_MONTH, fdcw);
            begin.add(Calendar.MINUTE, 30);
            end.set(Calendar.DAY_OF_MONTH, fdcw);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<div id=\"salas-regresar\">");
        out.println(" <a href=\""+paramRequest.getRenderUrl().setMode(SWBResourceURL.Mode_VIEW) +"\" title=\"Regresar\" class=\"backCal\">Regresar</a>");
        out.println("</div>");
    }
    
    private String getScript(HttpServletRequest request, SWBParamRequest paramRequest, Locale locale) {
        StringBuilder js = new StringBuilder();
        js.append("\n<script type=\"text/javascript\">");
        js.append("\n<!--");
        
        js.append("\n dojo.require('dojox.layout.ContentPane');");
        js.append("\n dojo.require('dijit.form.Form');");
        js.append("\n dojo.require('dijit.form.CheckBox');");
        js.append("\n dojo.require('dijit.form.DateTextBox');");
        js.append("\n dojo.require('dijit.form.SimpleTextarea');");
        js.append("\n dojo.require('dijit.form.FilteringSelect');");
        js.append("\n dojo.require('dijit.form.ValidationTextBox');");
        js.append("\n dojo.require('dojo.fx');");
        js.append("\n dojo.require('dijit.dijit');");

        js.append("\n dojo.declare(");
        js.append("\n     'ValidationTextarea',");
        js.append("\n     [dijit.form.ValidationTextBox, dijit.form.SimpleTextarea],");
        js.append("\n     {");
        js.append("\n         invalidMessage: 'Este dato es requerido',");
        js.append("\n         promptMessage: 'Ingresa',");
        js.append("\n         postCreate: function() {");
        js.append("\n             this.inherited(arguments);");
        js.append("\n         },");
        js.append("\n         validate: function() {");
        js.append("\n             if(arguments.length==0)");
        js.append("\n                 return this.validate(false);");
        js.append("\n             return this.inherited(arguments);");
        js.append("\n         },");
        js.append("\n         onFocus: function() {");
        js.append("\n             if(!this.isValid()) {");
        js.append("\n                 this.displayMessage(this.getErrorMessage());");
        js.append("\n             }");
        js.append("\n         },");
        js.append("\n         onBlur: function() {");
        js.append("\n             this.validate(false);");
        js.append("\n         }");
        js.append("\n      }");
        js.append("\n );");

        js.append("\n function expande(domId) {");
        js.append("\n  var anim1 = dojo.fx.wipeIn( {node:domId, duration:200 });");
        js.append("\n  var anim2 = dojo.fadeIn({node:domId, duration:250});");
        js.append("\n  dojo.fx.combine([anim1,anim2]).play();");
        js.append("\n }");

        js.append("\n function collapse(domId) {");
        js.append("\n  var anim1 = dojo.fx.wipeOut( {node:domId, duration:200 });");
        js.append("\n  var anim2 = dojo.fadeOut({node:domId, duration:250});");
        js.append("\n  dojo.fx.combine([anim1, anim2]).play();");
        js.append("\n }");

        js.append("\n function validateFrm() {");
        js.append("\n ");
        js.append("\n  var objd = dijit.byId('_rs_');");
        js.append("\n  if(objd.validate()) {");
        js.append("\n   if(dojo.byId('brksrvc').checked==true && isEmpty(dojo.byId('hrsrvc').value)) {");
        js.append("\n    alert('Datos incompletos para el horario de cafetería');");
        js.append("\n    return false;");
        js.append("\n   }");
        js.append("\n   return true;");
        js.append("\n  }else {");
        js.append("\n   alert('Datos incompletos o incorrectos');");
        js.append("\n   return false;");
        js.append("\n  }");
        js.append("\n }");

        js.append("\n-->");
        js.append("\n</script>");
        return js.toString();
    }
    
    private String getForm(HttpServletRequest request, SWBParamRequest paramRequest, List<Sala> salas, Locale locale) {
        StringBuilder html = new StringBuilder();
        
        HttpSession session = request.getSession(true);
        GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy", locale);
        SWBResourceURL url = paramRequest.getActionUrl().setAction(SWBResourceURL.Action_ADD);
        html.append("<form id=\"_rs_\" method=\"post\" dojoType=\"dijit.form.Form\" action=\""+url.toString()+"\">");
        html.append("<input type=\"hidden\" name=\"suri\" value=\"" + request.getParameter("suri") + "\"/>");
        html.append("<div id=\"mainPop\">");
        html.append(" <p id=\"popTop\"></p>");
        html.append(" <div id=\"popMiddle\">");
        
        html.append(" <div class=\"salas4Cols salas-cual\">");
        html.append("  <p><span class=\"blueCalTit\">Sala:</span></p>");
        html.append("  <select name=\"sl\" id=\"sl\" dojoType=\"dijit.form.FilteringSelect\" required=\"true\" promptMessage=\"Selecciona una sala\" invalidMessage=\"La sala es requerida\">");
        html.append("   <option value=\"\"></option>");
        for(Sala sala:salas) {
            html.append("   <option value=\""+sala.getId()+"\" "+(sala.getId().equals(request.getParameter("sl"))?"selected=\"selected\"":"")+">"+sala.getDisplayTitle(locale.getLanguage())+"</option>");
        }
        html.append("  </select>");
        html.append(" </div>");
        html.append(" <div class=\"salas4Cols salas-fecha\">");
        html.append("  <p><span class=\"blueCalTit\">Fecha de reservaci&oacute;n:</span></p>");
        html.append("     <label for=\"sd\">Del: </label><input type=\"text\" name=\"sd\" id=\"sd\" value=\""+sdf.format(current.getTime())+"\" dojoType=\"dijit.form.ValidationTextBox\" readonly=\"readonly\" />");
        final GregorianCalendar lastDateOfYear = new GregorianCalendar(current.get(Calendar.YEAR),11,31,22,0,0);
        html.append("     <label for=\"fd\">al: </label><input type=\"text\" name=\"fd\" id=\"fd\" value=\""+(request.getParameter("fd")==null?dateDojo.format(current.getTime()):request.getParameter("fd"))+"\" dojoType=\"dijit.form.DateTextBox\" constraints=\"{min:'"+dateDojo.format(current.getTime())+"',max:'"+dateDojo.format(lastDateOfYear.getTime())+"',datePattern:'dd/MMM/yyyy'}\"  required=\"true\" trim=\"true\" promptMessage=\"formato de la fecha dd/MM/yyyy\" invalidMessage=\"Invalid date\" />");
        html.append(" </div>");
        html.append("\n <div class=\"salas4Cols salas-hora\">");
        html.append("\n  <p><span class=\"blueCalTit\">Horario de reservaci&oacute;n:</span></p>");
        html.append("\n  <label for=\"sh\">De: </label>");
        html.append("\n  <select name=\"sh\" dojoType=\"dijit.form.FilteringSelect\" required=\"true\" promptMessage=\"Hora inicial\" invalidMessage=\"La hora inicial de la junta es requerida\">");
        StringBuilder fh = new StringBuilder();
        Calendar today = Calendar.getInstance();
        //Calendar next = Calendar.getInstance();
        int h;
        int minutes;
        if(today.get(Calendar.HOUR_OF_DAY)<START_HOUR || current.get(Calendar.DAY_OF_YEAR)>today.get(Calendar.DAY_OF_YEAR)) {
            reset(today, START_HOUR, 0);
            h = START_HOUR;
            minutes = h*60;
        }else {
            h = current.get(Calendar.HOUR_OF_DAY);
            minutes = h*60;
            if(current.get(Calendar.MINUTE)<30) {
                reset(today, h, 30);
                minutes+=30;
            }else {
                h++;
                minutes+=60;
                reset(today, h, 0);
            }
        }
        Calendar next = (Calendar)today.clone();
        next.add(Calendar.MINUTE, 59);
        for(int minute=minutes; minute<1290; minute+=30) {
            html.append("\n<option value=\""+minute+"\">"+HHmm.format(today.getTime())+"</option>");
            today.add(Calendar.MINUTE, 30);
            fh.append("\n<option value=\""+(minute+59)+"\">"+HHmm.format(next.getTime()) +"</option>");
            next.add(Calendar.MINUTE, 30);
        }
        html.append("\n  </select>");
        html.append("\n  <label for=\"fh\">a: </label>");
        html.append("\n  <select  name=\"fh\" dojoType=\"dijit.form.FilteringSelect\" required=\"true\" promptMessage=\"Hora final\" invalidMessage=\"La hora final de la junta es requerida\">");
        html.append(fh);
        html.append("\n  </select>");
        html.append("\n </div>");
        
        html.append(" <div id=\"salas-asistentes\">");
        html.append("  <p><span class=\"blueCalTit\">N&uacute;mero de asistentes:</span></p>");
        html.append("  <label for=\"turnout\"></label><input type=\"text\" name=\"turnout\" id=\"turnout\" value=\""+(request.getParameter("turnout")==null?"":request.getParameter("turnout"))+"\" size=\"10\" maxlength=\"3\" dojoType=\"dijit.form.ValidationTextBox\" required=\"true\" promptMessage=\"Asistentes\" invalidMessage=\"El valor es incorrecto\" regExp=\"\\d{1,3}\" trim=\"true\" />");
        html.append(" </div>");
        
        html.append(" <div class=\"salas4Cols salas-tipo\">");
        html.append("  <p><span class=\"blueCalTit\">Tipo de reuni&oacute;n:</span></p>");
        html.append("  <ul>");
        html.append("   <li><label for=\"meetsng\">Interna <input  type=\"radio\" name=\"tpmeet\" id=\"meetsng\"  value=\""+ReservacionSala.TipoReunion.Interna+"\" onclick=\"collapse('_tpcf_')\" "+(request.getParameter("tpmeet")==null?"checked=\"checked\"":(request.getParameter("tpmeet").equals(ReservacionSala.TipoReunion.Interna.name())?"checked=\"checked\"":""))+" /></label></li>");
        html.append("   <li><label for=\"meetspcl\">Externa <input type=\"radio\" name=\"tpmeet\" id=\"meetspcl\" value=\""+ReservacionSala.TipoReunion.Externa+"\" onclick=\"expande('_tpcf_')\" "+(request.getParameter("tpmeet")==null?"":(request.getParameter("tpmeet").equals(ReservacionSala.TipoReunion.Externa.name())?"checked=\"checked\"":""))+" /></label></li>");
        html.append("  </ul>");
        html.append(" </div>");
        html.append(" <div class=\"clear\">&nbsp;</div>");
        
        html.append(" <div id=\"_tpcf_\">");
        html.append("  <p><span class=\"blueCalTit\">Cafetería:</span></p>");
        html.append("  <div id=\"_tpcf_detalle\">");
        html.append("   <ul>");
        html.append("    <li class=\"cafe_cfsbl\"><input type=\"checkbox\" name=\"cfslb\" id=\"cfslb\" value=\"true\" "+(request.getParameter("cfslb")==null?"":"checked=\"checked\"")+" /><label for=\"cfslb\">Café soluble</label></li>");
        html.append("    <li class=\"cafe_cfgrn\"><input type=\"checkbox\" name=\"cfgrn\" id=\"cfgrn\" value=\"true\" "+(request.getParameter("cfgrn")==null?"":"checked=\"checked\"")+" /><label for=\"cfgrn\">Café de grano</label></li>");
        html.append("    <li class=\"cafe_h2o\"><input type=\"checkbox\" name=\"h2o\" id=\"h2o\" value=\"true\" "+(request.getParameter("h2o")==null?"":"checked=\"checked\"")+" /><label for=\"h2o\">Agua</label></li>");
        html.append("    <li class=\"cafe_sds\"><input type=\"checkbox\" name=\"sds\" id=\"sds\" value=\"true\" "+(request.getParameter("sds")==null?"":"checked=\"checked\"")+" /><label for=\"sds\">Refrescos</label></li>");
        html.append("    <li class=\"cafe_cks\"><input type=\"checkbox\" name=\"cks\" id=\"cks\" value=\"true\" "+(request.getParameter("cks")==null?"":"checked=\"checked\"")+" /><label for=\"cks\">Galletas</label></li>");
        html.append("   </ul>");
        html.append("  </div>");
        html.append("  <div id=\"_tpcf_hora\">");
        html.append("   <p>Horario del servicio: </p>");
        html.append("   <ul>");
        html.append("    <li class=\"cafe_allsrvc\"><label for=\"allsrvc\">Durante</label> <input type=\"radio\" name=\"tmsrvc\" id=\"allsrvc\" value=\""+ReservacionSala.Horario.Durante+"\" onclick=\"collapse('_tmsrvc_')\" "+(request.getParameter("tmsrvc")==null?"checked=\"checked\"":(request.getParameter("tmsrvc").equals(ReservacionSala.Horario.Durante.name())?"checked=\"checked\"":""))+" /></li>");
        html.append("    <li class=\"cafe_brksrvc\"><label for=\"brksrvc\">Receso</label> <input type=\"radio\" name=\"tmsrvc\" id=\"brksrvc\" value=\""+ReservacionSala.Horario.Receso+"\" onclick=\"expande('_tmsrvc_')\" "+(request.getParameter("tmsrvc")==null?"":(request.getParameter("tmsrvc").equals(ReservacionSala.Horario.Receso.name())?"checked=\"checked\"":""))+" /></li>");
        html.append("   </ul>");
        html.append("   <div id=\"_tmsrvc_\">");
        html.append("    <p><label for=\"hrsrvc\">Horario del servicio: <input type=\"text\" name=\"hrsrvc\" id=\"hrsrvc\" value=\""+(request.getParameter("hrsrvc")==null?"":request.getParameter("hrsrvc"))+"\" /></label></p>");
        html.append("   </div>");
        html.append("  </div>");
        html.append(" </div>");
        
        html.append(" <div id=\"salas-motivo\">");
        html.append("  <p><span class=\"blueCalTit\">Motivo de la reuni&oacute;n:</span></p>");
        html.append("  <label for=\"mtv\"></label><textarea name=\"mtv\" id=\"mtv\" dojoType=\"ValidationTextarea\" required=\"true\" promptMessage=\"Motivo\" invalidMessage=\"El motivo de la junta es requerido\" class=\"datosCal\">"+(request.getParameter("mtv")==null?"":request.getParameter("mtv").trim())+"</textarea>");
        html.append(" </div>");
        
        html.append(" <div id=\"salas-material\">");
        html.append("  <p><span class=\"blueCalTit\">Servicios a solicitar:</span></p>");
        html.append("  <ul>");
//        html.append("   <li><label for=\"airc\"><input type=\"checkbox\" name=\"airc\" id=\"airc\" value=\"1\" />Aire acondicionado</label></li>");
        html.append("   <li class=\"prjctr\"><input type=\"checkbox\" name=\"prjctr\" id=\"prjctr\" value=\"1\" "+(request.getParameter("prjctr")==null?"":"checked=\"checked\"")+" /><label for=\"prjctr\">Proyector</label></li>");
        html.append("   <li class=\"pcs\"><input type=\"checkbox\" name=\"pcs\" id=\"pcs\" value=\"1\" "+(request.getParameter("pcs")==null?"":"checked=\"checked\"")+" /><label for=\"pcs\">Computadoras</label></li>");
//        html.append("   <li><label for=\"rtfl\"><input type=\"checkbox\" name=\"rtfl\" id=\"rtfl\" value=\"1\" />Rotafolio</label></li>");
        html.append("   <li class=\"osrvcs\"><label for=\"osrvcs\">Otro: </label><textarea name=\"osrvcs\" id=\"osrvcs\" dojoType=\"ValidationTextarea\" trim=\"true\">"+(request.getParameter("osrvcs")==null?"":request.getParameter("osrvcs").trim())+"</textarea></li>");
        html.append("  </ul>");        
        html.append(" </div>");
        html.append(" <div class=\"clear\">&nbsp;</div>");
        
        html.append("  <p>");
        String backUrl = getTaskInboxUrl(getFlowNodeInstance(request.getParameter("suri")));
        if(backUrl!=null)
            html.append("   <a href=\""+backUrl+"\" title=\"Regresar\" class=\"backCal\">Regresar</a>");
        html.append("   <a href=\"javascript:dojo.byId('_rs_').reset()\" title=\"Limpiar formulario\" class=\"resetCal\">Limpiar</a>");
        html.append("   <a href=\"javascript:if(validateFrm())dojo.byId('_rs_').submit()\" class=\"soliCal\">Solicitar</a>");
        html.append("  </p>");
        html.append("  <p class=\"finePrint\">*Se te enviar&aacute; un email con la respuesta</p>");
        html.append(" </div>");
        html.append(" <p id=\"popBottom\"></p>");
        html.append("</div>");
        html.append("</form>");
        return html.toString();
    }
    
    private String getCalendar(HttpServletRequest request, SWBParamRequest paramRequest, Locale locale) throws SWBResourceException
    {
        StringBuilder html = new StringBuilder();
        
        HttpSession session = request.getSession(true);
        GregorianCalendar current = (GregorianCalendar)session.getAttribute("cur");
        SWBResourceURL url = paramRequest.getRenderUrl().setMode(Mode_ROLL).setParameter("suri", request.getParameter("suri"));
        
        html.append("\n<div id=\"dayselectorCal\">");
        html.append("\n <p class=\"disponibilidadSalas\">"+paramRequest.getLocaleString("lblAvailability")+"</p>");
        url.setParameter(Rel, Roll_DATE);
        url.setParameter(Roll, Roll_LEFT);
        html.append("\n <p><a href=\"javascript:window.location='"+url+"'\" class=\"salasAtras\">atr&aacute;s</a></p>");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE d 'de' MMMM", locale);
        html.append("\n <p id=\"current\" class=\"dayAndMonth\">"+sdf.format(current.getTime())+"</p>");
        url.setParameter(Roll, Roll_RIGHT);
        html.append("\n <p><a href=\"javascript:window.location='"+url+"'\" class=\"salasAdelante\">adelante</a></p>");
        html.append("\n</div>");
        
        html.append("\n<div id=\"salasCal\">");
        url.setParameter(Rel, Roll_MONTH);
        url.setParameter(Roll, Roll_LEFT);
        html.append("\n <a href=\"\" onclick=\"javascript:location.href='"+url+"'; return false;\" class=\"salasAtras\">atr&aacute;s</a>");
        sdf = new SimpleDateFormat("MMMM yyyy", locale);
        html.append("\n <span id=\"month\" class=\"salasMonthYear\">"+sdf.format(current.getTime()) +"</span>");
        url.setParameter(Roll, Roll_RIGHT);
        html.append("\n <a href=\"\" onclick=\"javascript:location.href='"+url+"'; return false;\" class=\"salasAdelante\">adelante</a>");
        html.append("\n <ul class=\"daysTop\">");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblSundayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblMondayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblThrusdayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblWednesdayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblTuesdayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblFridayE")+"</li>");
        html.append("\n  <li>"+paramRequest.getLocaleString("lblSaturdayE")+"</li>");
        html.append("\n </ul>");
        int daysInMonth = current.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        GregorianCalendar ci = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),1,0,0);
        int dayCounter = 1;
        int loopCounter = 1;
        int firstDay = ci.get(GregorianCalendar.DAY_OF_WEEK);
        html.append("\n <ul class=\"daysCal\">");
        sdf = new SimpleDateFormat("dd");
        url.setParameter(Rel, Set_DATE);
        for(int i=1; i<=6; i++) {
            for(int j=1; j<8; j++) {
                html.append("\n<li>");
                if( loopCounter>=firstDay && dayCounter<=daysInMonth ) {
                    url.setParameter(Roll, sdf.format(ci.getTime()));
                    html.append("<a href=\"\" onclick=\"javascript:location.href='"+url+"'; return false;\">");
                    html.append(sdf.format(ci.getTime())+"</a>");
                    
                    ci.add(GregorianCalendar.DAY_OF_MONTH, 1);
                    dayCounter++;
                }
                loopCounter++;
                html.append("</li>");
            }
        }
        html.append("\n </ul>");
        html.append("\n</div>");        
        return html.toString();
    }
    
    private void renderReservations(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=utf-8");
        
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
        PrintWriter out = response.getWriter();
        
        GregorianCalendar current;
        HttpSession session = request.getSession(true);
        if(session.getAttribute("cur")==null) {
            current = new GregorianCalendar(locale);
            session.setAttribute("cur", current);
        }else {
            current = (GregorianCalendar)session.getAttribute("cur");
        }
        
        out.println(getScript(request, paramRequest, locale));       
        out.println("<div id=\"apartadoSalas\">");
        
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);
        List<Sala> _remove=new ArrayList<Sala>();
        for(Sala sala:salas) {
            if(!user.haveAccess(sala) || !sala.isActive())
                //salas.remove(sala);
                _remove.add(sala);

        }
        for(Sala _sala : _remove)
        {
            salas.remove(_sala);
            
        }
        out.println(getCalendar(request, paramRequest, locale));
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<thead>");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <th class=\"thCalHora\">Hora</td>");
        for(Sala sala:salas) {
            out.println("  <th class=\"thCalS_"+sala.getId()+"\"><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\""+sala.getDisplayTitle(lang)+" ("+sala.getCapacidad()+")\">"+sala.getDisplayTitle(lang)+"</a></td>");
        }
        out.println(" </tr>");
        out.println("</thead>");
        
        Calendar today = Calendar.getInstance();//auxiliar
        reset(today,START_HOUR,0);
        GregorianCalendar begin = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        begin.set(Calendar.MINUTE, START_MIN);
        GregorianCalendar end = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        end.set(Calendar.MINUTE, 449);
        
        ReservacionSala myReservation;
        out.println("<tbody>");
        for(int i=START_MIN; i<=1260; i+=30) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+HHmm.format(today.getTime())+"</p></td>");
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    myReservation = null;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            out.println(" <tr>");
            i+=30;
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    myReservation = null;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            today.add(Calendar.HOUR_OF_DAY, 1);
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<br class=\"clear\"/>");
        
        if(current.get(Calendar.DAY_OF_YEAR)>=today.get(Calendar.DAY_OF_YEAR)) {
            out.println(getScript(request, paramRequest, locale));
            out.println(getForm(request, paramRequest, salas, locale));
        }
        
        out.println("</div>");
        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.addOnLoad(function() {");
        out.println(  request.getParameter("tpmeet")==null?"collapse('_tpcf_');":(request.getParameter("tpmeet").equals(ReservacionSala.TipoReunion.Interna.name())?"collapse('_tpcf_');":"expande('_tpcf_');")   );
        out.println(  request.getParameter("tmsrvc")==null?"collapse('_tmsrvc_');":(request.getParameter("tmsrvc").equals(ReservacionSala.Horario.Durante.name())?"collapse('_tmsrvc_');":"expande('_tmsrvc_');")   );
        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
            out.println( "alert('"+request.getParameter("alertmsg")+"');");
        }        
        out.println(" });");
        out.println("-->");
        out.println("</script>");
    }
    
    public void doRoll(HttpServletRequest request, HttpServletResponse response, SWBParamRequest paramRequest) throws SWBResourceException, IOException
    {
        response.setContentType("text/html; charset=ISO-8859-1");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        
        Resource base = getResourceBase();
        User user = paramRequest.getUser();
        String lang = user.getLanguage();
        Locale locale = new Locale(user.getLanguage(),(user.getCountry()==null?"MX":user.getCountry()));
        PrintWriter out = response.getWriter();   
        
        GregorianCalendar current;
        HttpSession session = request.getSession(true);
        if(session.getAttribute("cur")==null) {
            current = new GregorianCalendar(locale);
            session.setAttribute("cur", current);
        }else {
            current = (GregorianCalendar)session.getAttribute("cur");
        }
        
        if(Roll_MONTH.equals(request.getParameter(Rel))) {
            String roll = request.getParameter(Roll);
            if(Roll_LEFT.equals(roll))
                current.add(Calendar.MONTH, -1);
            else
                current.add(Calendar.MONTH, 1);
        }else if(Roll_DATE.equals(request.getParameter(Rel))) {
            String roll = request.getParameter(Roll);
            if(Roll_LEFT.equals(roll))
                current.add(Calendar.DAY_OF_MONTH, -1);
            else
                current.add(Calendar.DAY_OF_MONTH, 1);
        }else if(Set_DATE.equals(request.getParameter(Rel))) {
            try {
                int date = Integer.parseInt(request.getParameter(Roll));
                current.set(Calendar.DATE, date);
            }catch(NumberFormatException nfe) {
            }
        }
        
        out.println(getScript(request, paramRequest, locale));
        out.println("<div id=\"apartadoSalas\">");
        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
            out.println("<h1>"+request.getParameter("alertmsg")+"</h1>");
        }
        Iterator<Sala> isalas = Sala.ClassMgr.listSalas(base.getWebSite());        
        isalas = SWBComparator.sortByDisplayName(isalas, lang);
        List<Sala> salas = SWBUtils.Collections.copyIterator(isalas);

        ArrayList<Sala> _remove=new ArrayList<Sala>();

        for(Sala sala:salas) {
            if(!user.haveAccess(sala) || !sala.isActive())
                //salas.remove(sala);
                _remove.add(sala);

        }
        for(Sala _sala : _remove)
        {
            salas.remove(_sala);
        }
        out.println(getCalendar(request, paramRequest, locale));
        out.println("<table id=\"mainTableCal\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">");
        out.println("<thead>");
        out.println(" <tr class=\"trCalSalas\">");
        out.println("  <th class=\"thCalHora\">Hora</td>");
        for(Sala sala:salas) {
            out.println("  <th class=\"thCalS_"+sala.getId()+"\"><a href=\""+paramRequest.getRenderUrl().setMode(Mode_SALA).setParameter("sl", sala.getEncodedURI()) +"\" title=\""+sala.getDisplayTitle(lang)+" ("+sala.getCapacidad()+")\"\">"+sala.getDisplayTitle(lang)+"</a></td>");
        }
        out.println(" </tr>");
        out.println("</thead>");
        
        Calendar today = Calendar.getInstance();//auxiliar
        reset(today,START_HOUR,0);
        GregorianCalendar begin = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        begin.set(Calendar.MINUTE, START_MIN);
        GregorianCalendar end = new GregorianCalendar(current.get(Calendar.YEAR),current.get(Calendar.MONTH),current.get(Calendar.DATE),0,0,0);
        end.set(Calendar.MINUTE, 449);
        
        ReservacionSala myReservation, raux=null;
        out.println("<tbody>");
        for(int i=START_MIN; i<=1260; i+=30) {
            out.println(" <tr>");
            out.println("  <td rowspan=\"2\" class=\"theHoursCal\"><p>"+HHmm.format(today.getTime())+"</p></td>");
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    raux = myReservation;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            out.println(" <tr>");
            i+=30;
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
            for(Sala sala:salas) {
                myReservation = sala.getReserva(begin.getTime(), end.getTime());
                if(myReservation!=null) {
                    out.println("  <td class=\""+myReservation.getIconClass()+" sltc trCal1\" title=\""+myReservation.toString()+"\">&nbsp;</td>");
                    myReservation = null;
                }else {
                    out.println("  <td class=\"sltc trCal1\">&nbsp;</td>");
                }
            }
            out.println(" </tr>");
            today.add(Calendar.HOUR_OF_DAY, 1);
            begin.add(Calendar.MINUTE, 30);
            end.add(Calendar.MINUTE, 30);
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("<br class=\"clear\"/>");
        
        if(current.get(Calendar.DAY_OF_YEAR)>=today.get(Calendar.DAY_OF_YEAR)) {
            out.println(getScript(request, paramRequest, locale));
            out.println(getForm(request, paramRequest, salas, locale));
        }
        
        out.println("</div>");
        out.println("<script type=\"text/javascript\">");
        out.println("<!--");
        out.println(" dojo.addOnLoad(function() {");
        out.println(  request.getParameter("tpmeet")==null?"collapse('_tpcf_');":(request.getParameter("tpmeet").equals(ReservacionSala.TipoReunion.Interna.name())?"collapse('_tpcf_');":"expande('_tpcf_');")   );
        out.println(  request.getParameter("tmsrvc")==null?"collapse('_tmsrvc_');":(request.getParameter("tmsrvc").equals(ReservacionSala.Horario.Durante.name())?"collapse('_tmsrvc_');":"expande('_tmsrvc_');")   );
        if(request.getParameter("alertmsg")!=null && !request.getParameter("alertmsg").isEmpty()) {
            out.println( "alert('"+request.getParameter("alertmsg")+"');");
        }        
        out.println(" });");
        out.println("-->");
        out.println("</script>");
    }
    
    private boolean userCanEdit(User user) {
        boolean userCanEdit = false;
        String editAccessURI = getResourceBase().getAttribute("editAccess","").trim();
        try {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            GenericObject gobj = null;
            gobj = ont.getGenericObject(editAccessURI);
            if(gobj instanceof UserGroup) {
                UserGroup ugrp = (UserGroup)gobj;
                if(user.hasUserGroup(ugrp)) {
                    userCanEdit = true;
                }
            }else if(gobj instanceof Role) {
                Role urole = (Role)gobj;
                if(user.hasRole(urole)) {
                    userCanEdit = true;
                }
            }
        }catch(Exception e) {
            userCanEdit = false;
            e.printStackTrace(System.out);
        }
        return userCanEdit;
    }
    
    private void reset(Calendar cal, int hour, int minute) {
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }
    
    private void reset(Calendar cal) {
        reset(cal, 0, 0);
    }
    
    private void copyObjects(ReservacionSala from, ReservacionSala to) {
        to.setSala(from.getSala());
        to.setFechaInicio(from.getFechaInicio());
        to.setFechaFinal(from.getFechaFinal());
        to.setAsistentes(from.getAsistentes());
        to.setMotivo(from.getMotivo());
        to.setTipoReunion(from.getTipoReunion());
        if(ReservacionSala.TipoReunion.Externa == ReservacionSala.TipoReunion.valueOf(from.getTipoReunion())) {
            to.setRequiereCafeGrano(from.isRequiereCafeGrano());
            to.setRequiereCafeSoluble(from.isRequiereCafeSoluble());
            to.setRequiereRefrescos(from.isRequiereRefrescos());
            to.setRequiereAgua(from.isRequiereAgua());
            to.setRequiereGalletas(from.isRequiereGalletas());
            to.setRequiereServicioContinuo(from.isRequiereServicioContinuo());
            to.setHorarioServicio(from.getHorarioServicio());
        }
        to.setRequiereProyector(from.isRequiereProyector());
        to.setRequiereComputo(from.isRequiereComputo());
        to.setServiciosAdicionales(from.getServiciosAdicionales());
    }
    
    private void LinkReserva(ReservacionSala res, FlowNodeInstance fni) {
        if (fni != null) {
            //Recorrer objetos de la instancia en busca de la reservación
            Iterator<ItemAwareReference> iawrefs = fni.getProcessInstance().listAllItemAwareReferences();
            while (iawrefs.hasNext()) {
                ItemAwareReference iawr = iawrefs.next();
                if (iawr != null && iawr.getProcessObject() != null) {
                    org.semanticwb.process.model.ItemAware ia = iawr.getItemAware(); 
                    if (ia.getItemSemanticClass().equals(ReservacionSala.intranet_ReservacionSala)) {
                        ReservacionSala copy = (ReservacionSala) iawr.getProcessObject();
                        //Copiar los datos de la reservación
                        copyObjects(res, copy);
                    } else if (ia.getItemSemanticClass().equals(org.semanticwb.process.schema.String.sclass) && ia.getName().equals("uri")) {
                        //Copiar el uri de la reservación
                        org.semanticwb.process.schema.String curi = (org.semanticwb.process.schema.String)iawr.getProcessObject();
                        curi.setValue(res.getURI());
                    }
                }
            }
        }
    }
    
    private FlowNodeInstance getFlowNodeInstance(String uri) {
        FlowNodeInstance ret = null;
        if (uri != null && !uri.trim().equals("")) {
            SemanticOntology ont = SWBPlatform.getSemanticMgr().getOntology();
            ret = (FlowNodeInstance)ont.getGenericObject(uri);
        }
        return ret;
    }
    
    private String getTaskInboxUrl(FlowNodeInstance fni) {
        String ret = null;
        if (fni != null) {
            ret = fni.getProcessWebPage().getUrl();
            Resource base = getResourceBase();
            ResourceType rtype = ResourceType.ClassMgr.getResourceType("ProcessTaskInbox", base.getWebSite());

            if (rtype != null) {
                Resource res = rtype.getResource();
                if(res != null) {
                    Resourceable resable = res.getResourceable();
                    if(resable instanceof WebPage) {
                        ret = ((WebPage)resable).getUrl();
                    }
                }
            }
        }
        return ret;
    }
    
    private synchronized static String getIconClass() {
        iconClass = iconClass.next();
        return iconClass.getDesc();
    }
    
    public enum IconClass {
        u("u"),
        v("v"),
        w("w"),
        x("x"),
        y("y"),
        z("z");
        private String desc;
        IconClass(String desc) {
            this.desc = desc;
        }
        String getDesc() {
            return desc;
        }
        IconClass next() {
            switch(this) {
                case u: return v;
                case v: return w;
                case w: return x;
                case x: return y;
                case y: return z;
                case z: return x;
                default: return x;
            }
        }
        
    }
    
    
}