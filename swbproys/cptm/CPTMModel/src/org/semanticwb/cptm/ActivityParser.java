/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.semanticwb.cptm;

import java.util.Iterator;
import java.util.Map;
import org.semanticwb.SWBPortal;
import org.semanticwb.model.Searchable;
import org.semanticwb.model.WebPage;
import org.semanticwb.portal.indexer.IndexTerm;
import org.semanticwb.portal.indexer.parser.GenericParser;
import org.semanticwb.portal.indexer.parser.WebPageParser;

/**
 *
 * @author jorge.jimenez
 */
public class ActivityParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Actividad";
    }

    @Override
    public String getType(Searchable gen) {
        return "Activity";
    }

    @Override
    public String getImage(Searchable gen) {
        Activity activity = (Activity)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_activity.png";
        if(activity.getPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + activity.getWorkPath() + "/" + activity.cptm_photo.getName() + "_" + activity.getId()+"_"+activity.getPhoto();
        }
        return ret;
    }

}
