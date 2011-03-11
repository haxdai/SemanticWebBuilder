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
public class EditNoteParser extends WebPageParser {

    @Override
    public String getTypeDisplayLabel(Searchable gen) {
        return "Nota Editorial";
    }

    @Override
    public String getType(Searchable gen) {
        return "EditNote";
    }

    @Override
    public String getImage(Searchable gen) {
        EditNote editNote = (EditNote)gen;
        String ret=SWBPortal.getWebWorkPath()+"/models/"+gen.getSemanticObject().getModel().getName()+"/css/images/i_editNote.png";
        if(editNote.getPhoto()!=null){
            ret=SWBPortal.getWebWorkPath() + editNote.getWorkPath() + "/" + editNote.cptm_photo.getName() + "_" + editNote.getId()+"_"+editNote.getPhoto();
        }
        return ret;
    }

}
