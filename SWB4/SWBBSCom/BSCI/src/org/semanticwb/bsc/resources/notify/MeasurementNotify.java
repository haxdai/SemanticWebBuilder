package org.semanticwb.bsc.resources.notify;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.mail.internet.InternetAddress;
import org.semanticwb.SWBPortal;
import org.semanticwb.SWBUtils;
import org.semanticwb.base.util.SWBMail;
import org.semanticwb.bsc.BSC;
import org.semanticwb.bsc.accessory.Period;
import org.semanticwb.bsc.element.Indicator;
import org.semanticwb.bsc.resources.DataTableResource;
import org.semanticwb.bsc.utils.BSCUtils;
import org.semanticwb.bsc.utils.InappropriateFrequencyException;
import org.semanticwb.bsc.utils.UndefinedFrequencyException;
import org.semanticwb.model.Resource;
import org.semanticwb.model.SWBContext;
import org.semanticwb.model.SWBModel;
import org.semanticwb.model.User;
import org.semanticwb.model.WebSite;
import org.semanticwb.portal.api.SWBResource;

/**
 *
 * @author carlos.ramos
 */
public class MeasurementNotify {
    
    
    
    public static void notifyForMeasurmentPeriod() {
//        SWBModel model = (SWBModel) Indicator.bsc_Indicator.listInstances(true).next().getModel().getModelObject().createGenericInstance();
//        BSC bsc = (BSC)(WebSite)model;
//
//        SWBResource res = SWBPortal.getResourceMgr().getResource(bsc.getId(), "21");
//        if( !(res instanceof DataTableResource)) {
//            return;
//        }
//        DataTableResource measurementTable = (DataTableResource)res;
//        Resource base = measurementTable.getResourceBase();
//        int before, after, timeType;
//        try {
//            before = Integer.parseInt(base.getAttribute("left", "7"));
//        }catch(NumberFormatException e) {
//            before = 7;
//        }
//        try {
//            after = Integer.parseInt(base.getAttribute("right", "7"));
//        }catch(NumberFormatException e) {
//            after = 7;
//        }
//        try {
//            timeType = Integer.parseInt(base.getAttribute("time",Integer.toString(Calendar.DATE)));
//        }catch(NumberFormatException nfe) {
//            timeType = Calendar.DATE;
//        }
        boolean inTime, isEvaluated;

        Period p;
        Indicator indicator;
        Iterator<Indicator> indicators;
        //indicators = Indicator.ClassMgr.listIndicators(bsc);
        indicators = Indicator.ClassMgr.listIndicators();
        while(indicators.hasNext()) {
            indicator = indicators.next();
            if(!indicator.isValid()) {
                continue;
            }
System.out.println("\n\nindicator="+indicator.getTitle());
            try {
                p = indicator.nearestMeasurementPeriod();
            }catch(InappropriateFrequencyException e) {
System.out.println("......error"+e);
                continue;
            }catch (UndefinedFrequencyException e) {
System.out.println("......error"+e);
                continue;
            }
System.out.println("p="+p);
            if(p == null) {
                continue;
            }
System.out.println("nearest Period="+p.getTitle());
            p = p.getPrevius(); // Se evalua el periodo anterior al período más cercano
            if(p == null) {
                continue;
            }
System.out.println("previo para revisar="+p.getTitle());


BSC bsc = indicator.getBSC();
System.out.println("bsc="+bsc.getDisplayTitle("es"));
int before, after, timeType;
try {
    before = Integer.parseInt(bsc.getModelProperty("left"));
}catch(NumberFormatException e) {
    before = 7;
}
try {
    after = Integer.parseInt(bsc.getModelProperty("right"));
}catch(NumberFormatException e) {
    after = 7;
}
try {
    timeType = Integer.parseInt(bsc.getModelProperty("time"));
}catch(NumberFormatException nfe) {
    timeType = Calendar.DATE;
}

System.out.println("before="+before+", after="+after+", timetype="+timeType);
            
            inTime = BSCUtils.isInMeasureTimeFor(p, before, after, timeType);
            isEvaluated = BSCUtils.isEvaluatedFor(indicator, p);
System.out.println("inTime="+inTime+", isEvaluated="+isEvaluated);
            if(inTime && !isEvaluated) {
                SWBMail mail = getSWBMail(indicator);
                try {
                    String body = getNotificationMsgFor(indicator, p, before, after, timeType);
System.out.println("body="+body);
                    //mail.setData(body);
                }catch(Exception e) {
System.out.println("un error......."+e);
                }
                /*try {
                    sendMail(mail);
                }catch(Exception e) {
                    System.out.println("\nError al enviar notificacion"+e);
                }*/
            }
        }
System.out.println("---------------------------------------\n");
    }
    
    private static String getNotificationMsgFor(Indicator indicator, Period period, int before, int after, int time) {
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
            throw new IllegalArgumentException("Period Null Pointer");
        }
        
        String data;
        //User user = indicator.getChampion();
        String lang;
        if(indicator.getChampion()==null) {
            lang = "es";
        }else {
            lang = indicator.getChampion().getLanguage();
        }
        Locale locale = new Locale(lang);
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        
        GregorianCalendar left = new GregorianCalendar();
        left.setTime(end);
        left.add(time, -before);
        
        GregorianCalendar right = new GregorianCalendar();
        right.setTime(end);
        right.add(time, after);
        
        data = SWBUtils.TEXT.getLocaleString("locale_swbstrategy_util","msgBodyNotifyInTime", locale);
        data = SWBUtils.TEXT.replaceAll(data, "{updater}", indicator.getChampion().getFullName());
        data = SWBUtils.TEXT.replaceAll(data, "{indicator}", indicator.getDisplayTitle(lang));
        data = SWBUtils.TEXT.replaceAll(data, "{start}", df.format(left.getTime()));
        data = SWBUtils.TEXT.replaceAll(data, "{end}", df.format(right.getTime()));
        
        return data;
    }
    
    private static SWBMail getSWBMail(Indicator indicator) {
        SWBMail mail = new SWBMail();
        mail.setContentType("HTML");
        mail.setFromEmail("carlos.ramos@infotec.mx");
        mail.setFromName("charlie");
        mail.setSubject("testing hits");
        mail.setData("<h3>testing hist.</h3><p>..indicador="+indicator.getTitle()+"</p><br> fecha:"+DateFormat.getDateInstance(DateFormat.FULL, new Locale("es")).format(new Date()));
        InternetAddress ia;
ArrayList<InternetAddress> addresses = null;
List<String> emails;

StringBuilder to = new StringBuilder();
if(indicator.getChampion()!=null) {
    to.append(indicator.getChampion().getEmail());
    to.append(",");
}
if(indicator.getObjective()!=null && indicator.getObjective().getSponsor()!=null) {
    to.append(indicator.getObjective().getSponsor().getEmail());
    to.append(",");
}

//String to = "carlos.ramos@infotec.mx;";
emails = BSCUtils.parseEMailAccounts(to.toString());
if(emails!=null) {
    addresses = new ArrayList();
    for(String em:emails) {
System.out.println("TO em="+em);
        ia = new InternetAddress();
        ia.setAddress(em);
        addresses.add(ia);
    }
    mail.setAddress(addresses);
}

//String cc = "ciramosi@gmail.com;";
//emails = BSCUtils.parseEMailAccounts(cc);
//if(emails!=null) {
//    addresses = new ArrayList();
//    for(String em:emails) {
//System.out.println("CC em="+em);
//        ia = new InternetAddress();
//        ia.setAddress(em);
//        addresses.add(ia);
//    }
//    mail.setCcEmail(addresses);
//}else {
//System.out.println("\n******************CC nulo****************\n");
//return;
//}

        return mail;
    }
    
    private static void sendMail(SWBMail swbmail) throws Exception {
        SWBUtils.EMAIL.sendMail(swbmail);
    }
}
