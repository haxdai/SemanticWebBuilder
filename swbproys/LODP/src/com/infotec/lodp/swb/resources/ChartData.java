/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

import java.util.Date;

/**
 *
 * @author Sabino
 */
public class ChartData {
    private String title;
    private long count;
    private Date startDate;
    private Date finalDate;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }   
    
    public ChartData() { }
    
    public ChartData(String title, long count, Date startDate) {
        this.title = title;
        this.count = count;
        this.startDate = startDate;
    }
    
    public ChartData(String title, long count, Date startDate, Date finalDate) {
        this.title = title;
        this.count = count;
        this.startDate = startDate;
        this.finalDate = finalDate;
    }
    public ChartData(String title, long count) {
        this.title = title;
        this.count = count;        
    }
}
