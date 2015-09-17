package org.semanticwb.bsc.resources.notify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.semanticwb.base.SWBAppObject;
import org.semanticwb.bsc.utils.BSCUtils;

/**
 *
 * @author carlos.ramos
 */
public class MeasurementNotifyThread extends TimerTask implements SWBAppObject {
    public static final String TIMER_NAME = "MatchTrace";
    public static final int ONE_MIN = 1*60*1000;       // 1 minuto en milisegundos
    public static final int ONE_DAY = 1*24*60*ONE_MIN; // 1 día en milisegundos
    public static final int DEF_PERIOD = 60*1000;//1*ONE_DAY;    // Periodo de ejecución cada 1 día
    public static final int DEF_DELAY = 10*ONE_MIN;
    public static final String START = "22:46";//"00:30"        // Iniciar hilo a las hh:mm
    
    public MeasurementNotifyThread() {
    }
    
    @Override
    public void run() {
        MeasurementNotify.notifyForMeasurmentPeriod();
    }
    
    @Override
    public void init() {
        System.out.println("\n\n>>>>> Iniciando el notificador de tiempo de mediciones para indicadores...");
        System.out.println("Nombre del hilo: "+TIMER_NAME);
        
        if(!isTimerActive()) {
            TimerTask tasknew = new MeasurementNotifyThread();
            Timer measurementNotify = new Timer(TIMER_NAME, true);
            long delay = timeElapseToExecute();
            try {
                System.out.println("Planificando el hilo "+TIMER_NAME+" para dentro de "+delay+" milisegundos");
                measurementNotify.scheduleAtFixedRate(tasknew, delay, DEF_PERIOD);
                System.out.println("Este hilo se ejecuta cada "+DEF_PERIOD+" milisegundos");
            }catch(IllegalArgumentException iae) {
                System.out.println(iae);
            }
        }else {
            System.out.println("El hilo "+TIMER_NAME+" ya se encuentraba activo");
        }
    }
    
    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static long timeElapseToExecute() {
        long t = DEF_DELAY;
        
        Date dateCurr = null, dateExec = null;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            dateCurr = sdf.parse(sdf.format(new Date()));

            String exectime = START;
            if(!BSCUtils.isHHMM(exectime)) {
                System.out.println("tiempo de inicio no esta en formato HH:mm");
                return t;
            }
            dateExec = sdf.parse(exectime);
        }catch(ParseException pe) {
            System.out.println(pe);
            return t;
        }

        GregorianCalendar execSchedule = new GregorianCalendar();
        execSchedule.setTime(dateCurr);
        if(dateCurr!=null && dateExec!=null) {
            long diff = dateExec.getTime()-dateCurr.getTime();
            if(dateExec.compareTo(dateCurr)<0) {
                diff = ONE_DAY + diff;
            }
            execSchedule.add(Calendar.MILLISECOND, (int)diff);
            t = execSchedule.getTimeInMillis() - dateCurr.getTime();
        }
        System.out.println("delay = "+(t));
        return t;
    }
    
    private static Boolean isTimerActive() {
        boolean timerActive = Boolean.FALSE;
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        Thread[] threadArray = threadSet.toArray(new Thread[threadSet.size()]);
        for (Thread tread : threadArray) {
            if (tread.getName().equals(TIMER_NAME)) {
                timerActive = Boolean.TRUE;
            }
        }
        return timerActive;
    }
}
