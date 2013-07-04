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
public class UseDSBean {
    private long Hits;
    private long views;
    private String Institution;
    private String dataset;
    private Date lastDownload;
    private Date lastView;

    public long getHits() {
        return Hits;
    }

    public void setHits(long Hits) {
        this.Hits = Hits;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public String getInstitution() {
        return Institution;
    }

    public void setInstitution(String Institution) {
        this.Institution = Institution;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public Date getLastDownload() {
        return lastDownload;
    }

    public void setLastDownload(Date lastDownload) {
        this.lastDownload = lastDownload;
    }

    public Date getLastView() {
        return lastView;
    }

    public void setLastView(Date lastView) {
        this.lastView = lastView;
    }

    public UseDSBean(String Institution,String dataset,long Hits,Date lastDownload,long views,Date lastView) {
        this.Hits = Hits;
        this.views = views;
        this.Institution = Institution;
        this.dataset = dataset;
        this.lastDownload = lastDownload;
        this.lastView = lastView;
    }
}
