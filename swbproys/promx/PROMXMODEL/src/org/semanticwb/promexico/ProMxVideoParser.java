/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.portal.indexer.parser.GenericParser;

/**
 *
 * @author jorge.jimenez
 */
public class ProMxVideoParser extends GenericParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Video";
    }

    @Override
    public String getType(Searchable gen) {
        return "Video";
    }

    @Override
    public String getImage(Searchable gen) {
        ProMxVideo video = (ProMxVideo)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/gen_video.png";
        if(video.getPmVideoImage()!=null){
            ret=SWBPortal.getWebWorkPath() + video.getWorkPath() + "/" + video.promx_pmVideoImage.getName() + "_" + video.getId()+"_"+video.getPmVideoImage();
        }
        return ret;
    }
}
