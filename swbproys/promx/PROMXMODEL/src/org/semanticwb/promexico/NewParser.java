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
public class NewParser extends GenericParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Noticia";
    }

    @Override
    public String getType(Searchable gen) {
        return "New";
    }

    @Override
    public String getImage(Searchable gen) {
        New proNew = (New)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/gen_new.png";
        if(proNew.getNewPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + proNew.getWorkPath() + "/" + proNew.promx_newPhoto.getName() + "_" + proNew.getId()+"_"+proNew.getNewPhoto();
        }
        return ret;
    }

}
