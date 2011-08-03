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
public class ServiceParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Servicio";
    }

    @Override
    public String getType(Searchable gen) {
        return "Service";
    }

    @Override
    public String getImage(Searchable gen) {
        Service service = (Service)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/gen_service.png";
        if(service.getServicePhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + service.getWorkPath() + "/" + service.promx_ServicePhoto.getName() + "_" + service.getId()+"_"+service.getServicePhoto();
        }
        return ret;
    }
}
