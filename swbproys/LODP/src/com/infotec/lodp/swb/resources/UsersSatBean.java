/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

/**
 *
 * @author Sabino
 */
public class UsersSatBean {
    private String institution;
    private String dataset;
    private float average;
    private long numComments;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDataset() {
        return dataset;
    }

    public void setDataset(String dataset) {
        this.dataset = dataset;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public long getNumComments() {
        return numComments;
    }

    public void setNumComments(long numComments) {
        this.numComments = numComments;
    }

    public UsersSatBean(String institution, String dataset, float average, long numComments) {
        this.institution = institution;
        this.dataset = dataset;
        this.average = average;
        this.numComments = numComments;
    }
}
