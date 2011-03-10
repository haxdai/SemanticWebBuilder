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
public class ExperienceRefParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Experiencia en Destino";
    }

    @Override
    public String getType(Searchable gen) {
        return "ExperienceRef";
    }

    @Override
    public String getImage(Searchable gen) {
        ExperienceRef experienceRef = (ExperienceRef)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_experienceRef.png";
        if(experienceRef.getPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + experienceRef.getWorkPath() + "/" + experienceRef.cptm_photo.getName() + "_" + experienceRef.getId()+"_"+experienceRef.getPhoto();
        }
        return ret;
    }

}