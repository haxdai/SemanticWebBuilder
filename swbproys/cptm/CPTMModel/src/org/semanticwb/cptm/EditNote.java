package org.semanticwb.cptm;

import org.semanticwb.SWBPortal;

public class EditNote extends org.semanticwb.cptm.base.EditNoteBase 
{

    static {
        SWBPortal.getIndexMgr().getDefaultIndexer().registerParser(EditNote.class, new EditNoteParser());
    }

   /**
   * Constructs a EditNote with a SemanticObject
   * @param base The SemanticObject with the properties for the EditNote
   */
    public EditNote(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
    

}
