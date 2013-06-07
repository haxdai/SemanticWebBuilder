/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotec.lodp.swb.resources;

/**
 *
 * @author Sabino Pariente
 */
public class DSByIntBean {
    private String institution = null;     
    private int numDS;

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    public int getNumDS() {
        return numDS;
    }

    public void setNumDS(int numDS) {
        this.numDS = numDS;
    }  

    public DSByIntBean(String institution,int numDS) {
        this.institution = institution;
        this.numDS = numDS;
    }
    
}
