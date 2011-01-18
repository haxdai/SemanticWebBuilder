package org.semanticwb.cptm.base;


public abstract class EditNoteBase extends org.semanticwb.portal.resources.sem.HTMLContent implements org.semanticwb.model.ResourceVersionable,org.semanticwb.model.Traceable,org.semanticwb.model.Versionable
{
    public static final org.semanticwb.platform.SemanticClass cptm_Canal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Canal");
    public static final org.semanticwb.platform.SemanticProperty cptm_noteCanal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteCanal");
    public static final org.semanticwb.platform.SemanticProperty cptm_noteUrl=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteUrl");
    public static final org.semanticwb.platform.SemanticClass swb_VersionInfo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#VersionInfo");
    public static final org.semanticwb.platform.SemanticProperty swb_lastVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#lastVersion");
    public static final org.semanticwb.platform.SemanticProperty cptm_isathome=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#isathome");
    public static final org.semanticwb.platform.SemanticClass cptm_EditNoteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNoteType");
    public static final org.semanticwb.platform.SemanticProperty cptm_noteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteType");
    public static final org.semanticwb.platform.SemanticProperty cptm_noteHomeIndex=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteHomeIndex");
    public static final org.semanticwb.platform.SemanticProperty cptm_notePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#notePhoto");
    public static final org.semanticwb.platform.SemanticProperty swb_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#created");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty swb_modifiedBy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#modifiedBy");
    public static final org.semanticwb.platform.SemanticProperty swb_actualVersion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#actualVersion");
    public static final org.semanticwb.platform.SemanticProperty cptm_noteIndex=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteIndex");
    public static final org.semanticwb.platform.SemanticProperty swb_updated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#updated");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_semanticResourceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#semanticResourceInv");
    public static final org.semanticwb.platform.SemanticProperty swb_creator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#creator");
    public static final org.semanticwb.platform.SemanticClass cptm_EditNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");

    public EditNoteBase()
    {
    }

   /**
   * Constructs a EditNoteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EditNote
   */
    public EditNoteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property NoteCanal
   * @param value NoteCanal to set
   */

    public void setNoteCanal(org.semanticwb.cptm.Canal value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_noteCanal, value.getSemanticObject());
        }else
        {
            removeNoteCanal();
        }
    }
   /**
   * Remove the value for NoteCanal property
   */

    public void removeNoteCanal()
    {
        getSemanticObject().removeProperty(cptm_noteCanal);
    }

   /**
   * Gets the NoteCanal
   * @return a org.semanticwb.cptm.Canal
   */
    public org.semanticwb.cptm.Canal getNoteCanal()
    {
         org.semanticwb.cptm.Canal ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_noteCanal);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Canal)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NoteUrl property
* @return String with the NoteUrl
*/
    public String getNoteUrl()
    {
        return getSemanticObject().getProperty(cptm_noteUrl);
    }

/**
* Sets the NoteUrl property
* @param value long with the NoteUrl
*/
    public void setNoteUrl(String value)
    {
        getSemanticObject().setProperty(cptm_noteUrl, value);
    }
   /**
   * Sets the value for the property LastVersion
   * @param value LastVersion to set
   */

    public void setLastVersion(org.semanticwb.model.VersionInfo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_lastVersion, value.getSemanticObject());
        }else
        {
            removeLastVersion();
        }
    }
   /**
   * Remove the value for LastVersion property
   */

    public void removeLastVersion()
    {
        getSemanticObject().removeProperty(swb_lastVersion);
    }

   /**
   * Gets the LastVersion
   * @return a org.semanticwb.model.VersionInfo
   */
    public org.semanticwb.model.VersionInfo getLastVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_lastVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Isathome property
* @return boolean with the Isathome
*/
    public boolean isIsathome()
    {
        return getSemanticObject().getBooleanProperty(cptm_isathome);
    }

/**
* Sets the Isathome property
* @param value long with the Isathome
*/
    public void setIsathome(boolean value)
    {
        getSemanticObject().setBooleanProperty(cptm_isathome, value);
    }
   /**
   * Sets the value for the property NoteType
   * @param value NoteType to set
   */

    public void setNoteType(org.semanticwb.cptm.EditNoteType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_noteType, value.getSemanticObject());
        }else
        {
            removeNoteType();
        }
    }
   /**
   * Remove the value for NoteType property
   */

    public void removeNoteType()
    {
        getSemanticObject().removeProperty(cptm_noteType);
    }

   /**
   * Gets the NoteType
   * @return a org.semanticwb.cptm.EditNoteType
   */
    public org.semanticwb.cptm.EditNoteType getNoteType()
    {
         org.semanticwb.cptm.EditNoteType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_noteType);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EditNoteType)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NoteHomeIndex property
* @return int with the NoteHomeIndex
*/
    public int getNoteHomeIndex()
    {
        return getSemanticObject().getIntProperty(cptm_noteHomeIndex);
    }

/**
* Sets the NoteHomeIndex property
* @param value long with the NoteHomeIndex
*/
    public void setNoteHomeIndex(int value)
    {
        getSemanticObject().setIntProperty(cptm_noteHomeIndex, value);
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
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ActualVersion
   * @param value ActualVersion to set
   */

    public void setActualVersion(org.semanticwb.model.VersionInfo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_actualVersion, value.getSemanticObject());
        }else
        {
            removeActualVersion();
        }
    }
   /**
   * Remove the value for ActualVersion property
   */

    public void removeActualVersion()
    {
        getSemanticObject().removeProperty(swb_actualVersion);
    }

   /**
   * Gets the ActualVersion
   * @return a org.semanticwb.model.VersionInfo
   */
    public org.semanticwb.model.VersionInfo getActualVersion()
    {
         org.semanticwb.model.VersionInfo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_actualVersion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.VersionInfo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NoteIndex property
* @return int with the NoteIndex
*/
    public int getNoteIndex()
    {
        return getSemanticObject().getIntProperty(cptm_noteIndex);
    }

/**
* Sets the NoteIndex property
* @param value long with the NoteIndex
*/
    public void setNoteIndex(int value)
    {
        getSemanticObject().setIntProperty(cptm_noteIndex, value);
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
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
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
