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
    
    public static int rangeOfMonthsBetweenDates(Date start, Date end)
    {
        GregorianCalendar ci = new GregorianCalendar();
        ci.setTime(start);
        GregorianCalendar cf = new GregorianCalendar();
        cf.setTime(end);
        
        int yearRange = cf.get(Calendar.YEAR)-ci.get(Calendar.YEAR);
        int rango = 12 * yearRange + cf.get(Calendar.MONTH) - ci.get(Calendar.MONTH);
        return rango;
    }
    
    public static int rangeOfYearsBetweenDates(Date start, Date end)
    {
        GregorianCalendar ci = new GregorianCalendar();
        ci.setTime(start);
        GregorianCalendar cf = new GregorianCalendar();
        cf.setTime(end);
        
        int range = cf.get(Calendar.YEAR)-ci.get(Calendar.YEAR);
        return range;
    }
    
    public static int rangeOfMonthsBetweenDates(Date start, Date end, Locale locale)
    {
        GregorianCalendar ci = new GregorianCalendar(locale);
        ci.setTime(start);
        GregorianCalendar cf = new GregorianCalendar(locale);
        cf.setTime(end);
        
        int yearRange = cf.get(Calendar.YEAR)-ci.get(Calendar.YEAR);
        int rango = 12 * yearRange + cf.get(Calendar.MONTH) - ci.get(Calendar.MONTH);
        return rango;
    }
    
    public static int getYear(Date date)
    {
        GregorianCalendar cf = new GregorianCalendar();
        cf.setTime(date);
        return cf.get(Calendar.YEAR);
    }
}
