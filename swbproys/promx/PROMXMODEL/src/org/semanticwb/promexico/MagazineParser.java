/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.portal.resources.projectdriver.Activity;

/**
 *
 * @author jorge.jimenez
 */
public class MagazineParser extends GenericParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Revista";
    }

    @Override
    public String getType(Searchable gen) {
        return "Magazine";
    }

    @Override
    public String getImage(Searchable gen) {
        Magazine magazine = (Magazine)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/gen_magazine.png";
        if(magazine.getMzPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + magazine.getWorkPath() + "/" + magazine.promx_mzPhoto.getName() + "_" + magazine.getId()+"_"+magazine.getMzPhoto();
        }
        return ret;
    }

}
