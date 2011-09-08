package org.semanticwb.promexico.base;


public abstract class MagazineBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty promx_flashLink=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#flashLink");
   /**
   * Archivo Pdf de la revista
   */
    public static final org.semanticwb.platform.SemanticProperty promx_pdfFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#pdfFile");
    public static final org.semanticwb.platform.SemanticProperty promx_mzPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#mzPhoto");
    public static final org.semanticwb.platform.SemanticProperty promx_flashFile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#flashFile");
    public static final org.semanticwb.platform.SemanticProperty promx_openInSameWindow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#openInSameWindow");
    public static final org.semanticwb.platform.SemanticProperty promx_mzLink=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#mzLink");
    public static final org.semanticwb.platform.SemanticClass promx_Magazine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Magazine");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Magazine");

    public static class ClassMgr
    {
       /**
       * Returns a list of Magazine for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Magazine
       */

        public static java.util.Iterator<org.semanticwb.promexico.Magazine> listMagazines(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Magazine>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Magazine for all models
       * @return Iterator of org.semanticwb.promexico.Magazine
       */

        public static java.util.Iterator<org.semanticwb.promexico.Magazine> listMagazines()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Magazine>(it, true);
        }

        public static org.semanticwb.promexico.Magazine createMagazine(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.Magazine.ClassMgr.createMagazine(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.Magazine
       * @param id Identifier for org.semanticwb.promexico.Magazine
       * @param model Model of the org.semanticwb.promexico.Magazine
       * @return A org.semanticwb.promexico.Magazine
       */
        public static org.semanticwb.promexico.Magazine getMagazine(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Magazine)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Magazine
       * @param id Identifier for org.semanticwb.promexico.Magazine
       * @param model Model of the org.semanticwb.promexico.Magazine
       * @return A org.semanticwb.promexico.Magazine
       */
        public static org.semanticwb.promexico.Magazine createMagazine(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Magazine)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Magazine
       * @param id Identifier for org.semanticwb.promexico.Magazine
       * @param model Model of the org.semanticwb.promexico.Magazine
       */
        public static void removeMagazine(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Magazine
       * @param id Identifier for org.semanticwb.promexico.Magazine
       * @param model Model of the org.semanticwb.promexico.Magazine
       * @return true if the org.semanticwb.promexico.Magazine exists, false otherwise
       */

        public static boolean hasMagazine(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMagazine(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Magazine with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Magazine
       * @return Iterator with all the org.semanticwb.promexico.Magazine
       */

        public static java.util.Iterator<org.semanticwb.promexico.Magazine> listMagazineByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Magazine> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Magazine with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Magazine
       */

        public static java.util.Iterator<org.semanticwb.promexico.Magazine> listMagazineByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Magazine> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Magazine with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Magazine
       * @return Iterator with all the org.semanticwb.promexico.Magazine
       */

        public static java.util.Iterator<org.semanticwb.promexico.Magazine> listMagazineByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Magazine> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Magazine with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Magazine
       */

        public static java.util.Iterator<org.semanticwb.promexico.Magazine> listMagazineByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Magazine> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a MagazineBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Magazine
   */
    public MagazineBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

/**
* Gets the FlashLink property
* @return String with the FlashLink
*/
    public String getFlashLink()
    {
        return getSemanticObject().getProperty(promx_flashLink);
    }

/**
* Sets the FlashLink property
* @param value long with the FlashLink
*/
    public void setFlashLink(String value)
    {
        getSemanticObject().setProperty(promx_flashLink, value);
    }

/**
* Gets the PdfFile property
* @return String with the PdfFile
*/
    public String getPdfFile()
    {
        return getSemanticObject().getProperty(promx_pdfFile);
    }

/**
* Sets the PdfFile property
* @param value long with the PdfFile
*/
    public void setPdfFile(String value)
    {
        getSemanticObject().setProperty(promx_pdfFile, value);
    }

/**
* Gets the MzPhoto property
* @return String with the MzPhoto
*/
    public String getMzPhoto()
    {
        return getSemanticObject().getProperty(promx_mzPhoto);
    }

/**
* Sets the MzPhoto property
* @param value long with the MzPhoto
*/
    public void setMzPhoto(String value)
    {
        getSemanticObject().setProperty(promx_mzPhoto, value);
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

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the FlashFile property
* @return String with the FlashFile
*/
    public String getFlashFile()
    {
        return getSemanticObject().getProperty(promx_flashFile);
    }

/**
* Sets the FlashFile property
* @param value long with the FlashFile
*/
    public void setFlashFile(String value)
    {
        getSemanticObject().setProperty(promx_flashFile, value);
    }

/**
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }

/**
* Gets the OpenInSameWindow property
* @return boolean with the OpenInSameWindow
*/
    public boolean isOpenInSameWindow()
    {
        return getSemanticObject().getBooleanProperty(promx_openInSameWindow);
    }

/**
* Sets the OpenInSameWindow property
* @param value long with the OpenInSameWindow
*/
    public void setOpenInSameWindow(boolean value)
    {
        getSemanticObject().setBooleanProperty(promx_openInSameWindow, value);
    }

/**
* Gets the MzLink property
* @return String with the MzLink
*/
    public String getMzLink()
    {
        return getSemanticObject().getProperty(promx_mzLink);
    }

/**
* Sets the MzLink property
* @param value long with the MzLink
*/
    public void setMzLink(String value)
    {
        getSemanticObject().setProperty(promx_mzLink, value);
    }

   /**
   * Gets the ProMexico
   * @return a instance of org.semanticwb.promexico.ProMexico
   */
    public org.semanticwb.promexico.ProMexico getProMexico()
    {
        return (org.semanticwb.promexico.ProMexico)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
