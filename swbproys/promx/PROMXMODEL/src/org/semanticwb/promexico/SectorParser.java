/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.portal.indexer.parser.WebPageParser;

/**
 *
 * @author jorge.jimenez
 */
public class SectorParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Sector";
    }

    @Override
    public String getType(Searchable gen) {
        return "Sector";
    }

    @Override
    public String getImage(Searchable gen) {
        Sector sector = (Sector)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/gen_sector.png";
        if(sector.getSectorPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + sector.getWorkPath() + "/" + sector.promx_SectorPhoto.getName() + "_" + sector.getId()+"_"+sector.getSectorPhoto();
        }
        return ret;
    }

}
