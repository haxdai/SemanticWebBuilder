/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.promexico;

import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.portal.indexer.parser.WebPageParser;
import org.semanticwb.portal.resources.projectdriver.Activity;

/**
 *
 * @author jorge.jimenez
 */
public class OfficeParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Oficina";
    }

    @Override
    public String getType(Searchable gen) {
        return "Office";
    }

    @Override
    public String getImage(Searchable gen) {
        Office office = (Office)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_activity.png";
        if(office.getOfficePhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + office.getWorkPath() + "/" + office.promx_OfficePhoto.getName() + "_" + office.getId()+"_"+office.getOfficePhoto();
        }
        return ret;
    }

}
