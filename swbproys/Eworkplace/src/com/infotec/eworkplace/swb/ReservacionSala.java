package com.infotec.eworkplace.swb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.semanticwb.SWBUtils;
import org.semanticwb.model.SWBContext;
import org.semanticwb.platform.SemanticModel;
import org.semanticwb.platform.SemanticObject;


public class ReservacionSala extends com.infotec.eworkplace.swb.base.ReservacionSalaBase 
{   
    public enum TipoReunion {
        Interna,
        Externa
    }
    
    public enum Cafeteria {
        Sencilla,
        Especial
    }
    
    public enum Horario {
        Durante,
        Receso
    }
    
    public ReservacionSala(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    @Override
    public String toString()
    {
        String lang = SWBContext.getSessionUser().getLanguage();
        Locale locale = new Locale(lang);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy HH:mm", locale);
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(getSala().getDisplayTitle(lang));
            sb.append(", ");
            sb.append(getPId());
            sb.append(", ");
            sb.append(sdf.format(getFechaInicio()));
            sb.append(", ");
            sb.append(sdf.format(getFechaFinal()));
            sb.append(", ");
            sb.append(getCreator().getFullName());
            sb.append(", ");
            sb.append(getMotivo());
            sb.append(", ");
            sb.append(getAsistentes());
            sb.append(", ");
            sb.append(getTipoReunion());
            if(isRequiereProyector()) {
                sb.append(", ").append(SWBUtils.TEXT.getLocaleString("com.infotec.eworkplace.swb.resources.sem.ReservaSalaManager", "lblRequireProjector", locale));
            }
            if(isRequiereComputo()) {
                sb.append(", ").append(SWBUtils.TEXT.getLocaleString("com.infotec.eworkplace.swb.resources.sem.ReservaSalaManager", "lblRequireComputer", locale));
            }
        }catch(Exception e) {            
        }
        return sb.toString();
    }
    
    public static List<ReservacionSala> getReservationsByDay(Date day, SemanticModel model) {
        List<ReservacionSala> ret = new ArrayList<ReservacionSala>();
        
        String stamp = SWBUtils.TEXT.iso8601DateFormat(day);
        Iterator<SemanticObject> itsubj = model.listSubjects(ReservacionSala.intranet_hasFechaReservada, stamp);
        while (itsubj.hasNext()) {
            SemanticObject sobj = itsubj.next();
            if (sobj != null && sobj.instanceOf(ReservacionSala.sclass)) {
                ret.add((ReservacionSala)sobj.createGenericInstance());
            }
        }
        return ret;
    }

    @Override
    public void setFechaInicio(Date value) {
        super.setFechaInicio(value);
        setReservedDates();
    }

    @Override
    public void setFechaFinal(Date value) {
        super.setFechaFinal(value);
        setReservedDates();
    }
    
    private void setReservedDates() {
        if (getFechaInicio() != null && getFechaFinal() != null) {
            removeAllFechaReservada();
            Calendar _s = GregorianCalendar.getInstance();
            Calendar _e = GregorianCalendar.getInstance();
            _s.setTime(getFechaInicio());
            _e.setTime(getFechaFinal());

            _s.set(Calendar.HOUR_OF_DAY, 0);
            _s.set(Calendar.MINUTE, 0);
            _e.set(Calendar.HOUR_OF_DAY, 0);
            _e.set(Calendar.MINUTE, 0);

            addFechaReservada(SWBUtils.TEXT.iso8601DateFormat(_s.getTime()));
            while (_s.compareTo(_e) < 0) {
                _s.add(Calendar.DAY_OF_MONTH, 1);
                addFechaReservada(SWBUtils.TEXT.iso8601DateFormat(_s.getTime()));
            }
        }
    }
}