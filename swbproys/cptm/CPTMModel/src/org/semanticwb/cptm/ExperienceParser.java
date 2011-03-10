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
public class ExperienceParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Experiencia";
    }

    @Override
    public String getType(Searchable gen) {
        return "Experience";
    }

    @Override
    public String getImage(Searchable gen) {
        Experience experience = (Experience)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_experience.png";
        if(experience.getPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + experience.getWorkPath() + "/" + experience.cptm_photo.getName() + "_" + experience.getId()+"_"+experience.getPhoto();
        }
        return ret;
    }

}