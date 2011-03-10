/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.portal.indexer.parser.WebPageParser;

/**
 *
 * @author jorge.jimenez
 */
public class LocalityParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Destino";
    }

    @Override
    public String getType(Searchable gen) {
        return "Locality";
    }

    @Override
    public String getImage(Searchable gen) {
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_locality.png";
        if(gen instanceof GeographicPoint){
            GeographicPoint gp=(GeographicPoint)gen;
            if(gp.getPhoto()!=null){
                ret=SWBPortal.getWebWorkPath() + gp.getWorkPath() + "/" + gp.cptm_photo.getName() + "_" + gp.getId()+"_"+gp.getPhoto();
            }
        }else if(gen instanceof RegionalBrand){
            RegionalBrand gb=(RegionalBrand)gen;
            if(gb.getPhoto()!=null){
                ret=SWBPortal.getWebWorkPath() + gb.getWorkPath() + "/" + gb.cptm_photo.getName() + "_" + gb.getId()+"_"+gb.getPhoto();
            }
        }
        return ret;
    }

}