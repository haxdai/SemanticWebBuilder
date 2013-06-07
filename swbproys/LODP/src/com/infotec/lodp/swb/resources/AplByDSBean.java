/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

public class AplByDSBean{
    private String dataset;
    private String institution;
    private long numApp;
    public String getDataset() {return dataset;}
    public void setDataset(String dataset) {this.dataset = dataset;}
    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }
    public long getNumApp() { return numApp; }
    public void setNumApp(long numApp) { this.numApp = numApp;  }
    public AplByDSBean(String dataset,String institution, long numApp) {
        this.dataset = dataset;
        this.numApp = numApp;
        this.institution = institution;
    }    
}