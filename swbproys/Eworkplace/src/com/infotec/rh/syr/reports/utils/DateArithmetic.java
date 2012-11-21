/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.rh.syr.reports.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author carlos.ramos
 */
public class DateArithmetic {
    
    public static int RangeOfMonthsBetweenDates(Date start, Date end)
    {
        GregorianCalendar ci = new GregorianCalendar();
        ci.setTime(start);
        GregorianCalendar cf = new GregorianCalendar();
        cf.setTime(end);
        
        int yearRange = cf.get(Calendar.YEAR)-ci.get(Calendar.YEAR);
        int rango = 12 * yearRange + cf.get(Calendar.MONTH) - ci.get(Calendar.MONTH);
        return rango;
    }
    
    public static int RangeOfMonthsBetweenDates(Date start, Date end, Locale locale)
    {
        GregorianCalendar ci = new GregorianCalendar(locale);
        ci.setTime(start);
        GregorianCalendar cf = new GregorianCalendar(locale);
        cf.setTime(end);
        
        int yearRange = cf.get(Calendar.YEAR)-ci.get(Calendar.YEAR);
        int rango = 12 * yearRange + cf.get(Calendar.MONTH) - ci.get(Calendar.MONTH);
        return rango;
    }
}
