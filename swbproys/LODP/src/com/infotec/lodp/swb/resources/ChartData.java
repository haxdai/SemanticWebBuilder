/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

/**
 *
 * @author Sabino
 */
public class ChartData {
    private String title;
    private long count;

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

    public ChartData() { }

    public ChartData(String title, long count) {
        this.title = title;
        this.count = count;
    }   
}
