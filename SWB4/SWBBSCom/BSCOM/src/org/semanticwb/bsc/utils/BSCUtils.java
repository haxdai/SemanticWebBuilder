package org.semanticwb.bsc.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.semanticwb.SWBPlatform;
import org.semanticwb.SWBUtils;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.tracing.Measure;
import org.semanticwb.model.User;
import org.semanticwb.platform.SemanticProperty;

/**
 *
 * @author carlos.ramos
 */
public class BSCUtils {
    public static final SemanticProperty bsc_usrInitials = SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#usrInitials");
    
    public static final String[] ColorPalette = {
        "#f44336", "#673ab7", "#03a9f4", "#4caf50", "#ffc107",
        "#e91e63", "#3f51b5", "#00bcd4", "#8bc34a", "#ff9800",
        "#9c27b0", "#2196f3", "#009688", "#cddc39", "#ff5722",
        "#d50000", "#311b92", "#01579b", "#1b5e20", "#ffab00",
        "#880e4f", "#1a237e", "#006064", "#33691e", "#ff6f00",
        "#aa00ff", "#0d47a1", "#004d40", "#827717", "#795548"
    };
    
    public static class Formats {
        public static BigDecimal round(float d, int decimalPlace) {
            BigDecimal bd = new BigDecimal(Float.toString(d));
            bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
            return bd;
        }
    }
    
    public static class BSCUser {
        public static String getInitials(final User user) {
            return user.getSemanticObject().getProperty(bsc_usrInitials);
        }
        
        public static String getInitials(final User user, final String defValue) {
            return user.getSemanticObject().getProperty(bsc_usrInitials, defValue);
        }
    }
    
    public static List<String> parseEMailAccounts(String accounts) {
        if(accounts==null || accounts.isEmpty()) {
            return null;
        }
        List<String> list = null;
        String[] mails = accounts.split(",|;",0);
        if(mails.length > 0) {
            for (String account : mails) {
                if (SWBUtils.EMAIL.isValidEmailAddress(account)) {
                    if(list==null) {
                        list = new ArrayList<String>();
                    }
                    list.add(account);
                }
            }
        }
        return list;
    }
    
    public static Period getNearestPeriod(BSC bsc) {
        //final User user = SWBContext.getSessionUser(bsc.getUserRepository().getId());
        
        GregorianCalendar left;
        GregorianCalendar right;        
        /*GregorianCalendar current = new GregorianCalendar(TimeZone.getDefault(),
                new Locale(user.getLanguage() == null ? "es" : user.getLanguage(),
                user.getCountry() == null ? "MX" : user.getCountry()));*/
        GregorianCalendar current = new GregorianCalendar();
        List<Period> periods = bsc.listValidPeriods();
        for (Period period : periods) {
            left = new GregorianCalendar();
            left.setTime(period.getStart());
            left.set(Calendar.HOUR, 0);
            left.set(Calendar.MINUTE, 0);
            left.set(Calendar.SECOND, 0);
            
            right = new GregorianCalendar();
            //Calendar calEnd = new GregorianCalendar();
            right.setTime(period.getEnd());
            right.set(Calendar.HOUR, 23);
            right.set(Calendar.MINUTE, 59);
            right.set(Calendar.SECOND, 59);
            //right.setTime(calEnd.getTime());
            if (current.compareTo(left) >= 0 && current.compareTo(right) <= 0) {
                return period;
            }
        }
        return null;
    }
    
    /**
     *
     * @param value
     * @return
     */
    public static boolean isHHMM(String value) {
        if(value==null) {
            return false;
        }
        return value.matches("^([01]\\d{1}|2[0123]):[012345]\\d{1}$");
    }
    
    public static boolean isEvaluatedFor(final Indicator indicator, final Period p) {
        if(indicator.getStar()==null) {
            return Boolean.TRUE;
        }
        Measure measure = indicator.getStar().getMeasure(p);
        if(measure==null) {
            return Boolean.TRUE;
        }
        return !Float.isNaN(measure.getValue());
    }
    
    
    public static boolean isInMeasureTimeFor(final Period period, final int before, final int after, final int time)
            throws IllegalArgumentException 
    {
        switch(time) {
            case Calendar.YEAR:
            case Calendar.MONTH:
            case Calendar.WEEK_OF_YEAR:
            case Calendar.WEEK_OF_MONTH:
            case Calendar.DATE:
            case Calendar.DAY_OF_YEAR:
                break;
            default:
                throw new IllegalArgumentException("Should correspond to 1,2,3,4,5,6. See java.util.Calendar class");
        }
        if(before<0 || after<0) {
            throw new IllegalArgumentException("Must correspond to positive values");
        }
        
        Date end = period.getEnd();
        if(end==null) {
            return Boolean.FALSE;
        }
        GregorianCalendar left = new GregorianCalendar();
        left.setTime(end);
        left.add(time, -before);
        
        GregorianCalendar right = new GregorianCalendar();
        right.setTime(end);
        right.add(time, after);
        
        GregorianCalendar current = new GregorianCalendar();
        return current.compareTo(left)>=0 && current.compareTo(right)<=0;
    }
}
