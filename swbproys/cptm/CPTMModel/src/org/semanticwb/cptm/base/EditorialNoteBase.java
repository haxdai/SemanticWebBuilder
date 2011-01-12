package org.semanticwb.cptm.base;


public abstract class EditorialNoteBase extends org.semanticwb.portal.api.GenericSemResource 
{
    public static final org.semanticwb.platform.SemanticProperty cptm_noteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteType");
    public static final org.semanticwb.platform.SemanticProperty cptm_notePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#notePhoto");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticProperty cptm_isinHome=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#isinHome");
    public static final org.semanticwb.platform.SemanticClass cptm_EditorialNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditorialNote");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditorialNote");

    public EditorialNoteBase()
    {
    }

   /**
   * Constructs a EditorialNoteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EditorialNote
   */
    public EditorialNoteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NoteType property
* @return int with the NoteType
*/
    public int getNoteType()
    {
        return getSemanticObject().getIntProperty(cptm_noteType);
    }

/**
* Sets the NoteType property
* @param value long with the NoteType
*/
    public void setNoteType(int value)
    {
        getSemanticObject().setIntProperty(cptm_noteType, value);
    }

/**
* Gets the NotePhoto property
* @return String with the NotePhoto
*/
    public String getNotePhoto()
    {
        return getSemanticObject().getProperty(cptm_notePhoto);
    }

/**
* Sets the NotePhoto property
* @param value long with the NotePhoto
*/
    public void setNotePhoto(String value)
    {
        getSemanticObject().setProperty(cptm_notePhoto, value);
    }
   /**
   * Sets the value for the property Resource
   * @param value Resource to set
   */

    public void setResource(org.semanticwb.model.Resource value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_semanticResourceInv, value.getSemanticObject());
        }else
        {
            removeResource();
        }
    }
   /**
   * Remove the value for Resource property
   */

    public void removeResource()
    {
        getSemanticObject().removeProperty(swb_semanticResourceInv);
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_semanticResourceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the IsinHome property
* @return boolean with the IsinHome
*/
    public boolean isIsinHome()
    {
        return getSemanticObject().getBooleanProperty(cptm_isinHome);
    }

/**
* Sets the IsinHome property
* @param value long with the IsinHome
*/
    public void setIsinHome(boolean value)
    {
        getSemanticObject().setBooleanProperty(cptm_isinHome, value);
    }
}
