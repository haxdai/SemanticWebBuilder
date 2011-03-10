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
public class ActivityRefParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Actividad en Destino";
    }

    @Override
    public String getType(Searchable gen) {
        return "ActivityRef";
    }

    @Override
    public String getImage(Searchable gen) {
        ActivityRef activityRef = (ActivityRef)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_activityRef.png";
        if(activityRef.getPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + activityRef.getWorkPath() + "/" + activityRef.cptm_photo.getName() + "_" + activityRef.getId()+"_"+activityRef.getPhoto();
        }
        return ret;
    }

}