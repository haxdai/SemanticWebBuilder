package org.semanticwb.promexico.base;


public abstract class ProInstitutionSupportBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty promx_insPhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#insPhone");
    public static final org.semanticwb.platform.SemanticProperty promx_instEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#instEmail");
    public static final org.semanticwb.platform.SemanticProperty promx_instPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#instPhoto");
    public static final org.semanticwb.platform.SemanticProperty promx_insLatitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#insLatitude");
    public static final org.semanticwb.platform.SemanticProperty promx_insAddress=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#insAddress");
    public static final org.semanticwb.platform.SemanticProperty promx_intsLongitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#intsLongitude");
    public static final org.semanticwb.platform.SemanticClass promx_ProInstitutionSupport=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#proInstitutionSupport");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#proInstitutionSupport");

    public static class ClassMgr
    {
       /**
       * Returns a list of ProInstitutionSupport for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.ProInstitutionSupport
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProInstitutionSupport> listProInstitutionSupports(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.ProInstitutionSupport for all models
       * @return Iterator of org.semanticwb.promexico.ProInstitutionSupport
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProInstitutionSupport> listProInstitutionSupports()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport>(it, true);
        }

        public static org.semanticwb.promexico.ProInstitutionSupport createProInstitutionSupport(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.ProInstitutionSupport.ClassMgr.createProInstitutionSupport(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.ProInstitutionSupport
       * @param id Identifier for org.semanticwb.promexico.ProInstitutionSupport
       * @param model Model of the org.semanticwb.promexico.ProInstitutionSupport
       * @return A org.semanticwb.promexico.ProInstitutionSupport
       */
        public static org.semanticwb.promexico.ProInstitutionSupport getProInstitutionSupport(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProInstitutionSupport)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.ProInstitutionSupport
       * @param id Identifier for org.semanticwb.promexico.ProInstitutionSupport
       * @param model Model of the org.semanticwb.promexico.ProInstitutionSupport
       * @return A org.semanticwb.promexico.ProInstitutionSupport
       */
        public static org.semanticwb.promexico.ProInstitutionSupport createProInstitutionSupport(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.ProInstitutionSupport)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.ProInstitutionSupport
       * @param id Identifier for org.semanticwb.promexico.ProInstitutionSupport
       * @param model Model of the org.semanticwb.promexico.ProInstitutionSupport
       */
        public static void removeProInstitutionSupport(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.ProInstitutionSupport
       * @param id Identifier for org.semanticwb.promexico.ProInstitutionSupport
       * @param model Model of the org.semanticwb.promexico.ProInstitutionSupport
       * @return true if the org.semanticwb.promexico.ProInstitutionSupport exists, false otherwise
       */

        public static boolean hasProInstitutionSupport(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProInstitutionSupport(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.ProInstitutionSupport with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProInstitutionSupport
       * @return Iterator with all the org.semanticwb.promexico.ProInstitutionSupport
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProInstitutionSupport> listProInstitutionSupportByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProInstitutionSupport with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProInstitutionSupport
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProInstitutionSupport> listProInstitutionSupportByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProInstitutionSupport with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.ProInstitutionSupport
       * @return Iterator with all the org.semanticwb.promexico.ProInstitutionSupport
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProInstitutionSupport> listProInstitutionSupportByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.ProInstitutionSupport with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.ProInstitutionSupport
       */

        public static java.util.Iterator<org.semanticwb.promexico.ProInstitutionSupport> listProInstitutionSupportByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ProInstitutionSupportBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ProInstitutionSupport
   */
    public ProInstitutionSupportBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the InsPhone property
* @return String with the InsPhone
*/
    public String getInsPhone()
    {
        return getSemanticObject().getProperty(promx_insPhone);
    }

/**
* Sets the InsPhone property
* @param value long with the InsPhone
*/
    public void setInsPhone(String value)
    {
        getSemanticObject().setProperty(promx_insPhone, value);
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
* Gets the InstEmail property
* @return String with the InstEmail
*/
    public String getInstEmail()
    {
        return getSemanticObject().getProperty(promx_instEmail);
    }

/**
* Sets the InstEmail property
* @param value long with the InstEmail
*/
    public void setInstEmail(String value)
    {
        getSemanticObject().setProperty(promx_instEmail, value);
    }

/**
* Gets the InstPhoto property
* @return String with the InstPhoto
*/
    public String getInstPhoto()
    {
        return getSemanticObject().getProperty(promx_instPhoto);
    }

/**
* Sets the InstPhoto property
* @param value long with the InstPhoto
*/
    public void setInstPhoto(String value)
    {
        getSemanticObject().setProperty(promx_instPhoto, value);
    }

/**
* Gets the InsLatitude property
* @return double with the InsLatitude
*/
    public double getInsLatitude()
    {
        return getSemanticObject().getDoubleProperty(promx_insLatitude);
    }

/**
* Sets the InsLatitude property
* @param value long with the InsLatitude
*/
    public void setInsLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(promx_insLatitude, value);
    }

/**
* Gets the InsAddress property
* @return String with the InsAddress
*/
    public String getInsAddress()
    {
        return getSemanticObject().getProperty(promx_insAddress);
    }

/**
* Sets the InsAddress property
* @param value long with the InsAddress
*/
    public void setInsAddress(String value)
    {
        getSemanticObject().setProperty(promx_insAddress, value);
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
* Gets the IntsLongitude property
* @return double with the IntsLongitude
*/
    public double getIntsLongitude()
    {
        return getSemanticObject().getDoubleProperty(promx_intsLongitude);
    }

/**
* Sets the IntsLongitude property
* @param value long with the IntsLongitude
*/
    public void setIntsLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(promx_intsLongitude, value);
    }
}
