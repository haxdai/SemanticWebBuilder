package org.semanticwb.promexico.base;


public abstract class TrainingBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Localeable,org.semanticwb.model.Resourceable,org.semanticwb.model.Tagable,org.semanticwb.model.Searchable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty promx_traOpenInNewWindow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traOpenInNewWindow");
    public static final org.semanticwb.platform.SemanticProperty promx_traShowInstitutionsContact=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traShowInstitutionsContact");
    public static final org.semanticwb.platform.SemanticClass promx_TrainingType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#TrainingType");
    public static final org.semanticwb.platform.SemanticProperty promx_traType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traType");
    public static final org.semanticwb.platform.SemanticClass promx_ProStates=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProStates");
    public static final org.semanticwb.platform.SemanticProperty promx_hasProStates=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasProStates");
    public static final org.semanticwb.platform.SemanticProperty promx_traPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traPhoto");
    public static final org.semanticwb.platform.SemanticProperty promx_traEndDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traEndDate");
    public static final org.semanticwb.platform.SemanticProperty promx_traInitDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traInitDate");
    public static final org.semanticwb.platform.SemanticProperty promx_traExternalUrl=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traExternalUrl");
    public static final org.semanticwb.platform.SemanticProperty promx_traHours=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traHours");
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
    public static final org.semanticwb.platform.SemanticProperty promx_hasTraSectores=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasTraSectores");
    public static final org.semanticwb.platform.SemanticProperty promx_traPrice=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traPrice");
    public static final org.semanticwb.platform.SemanticClass promx_TrainingWay=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#TrainingWay");
    public static final org.semanticwb.platform.SemanticProperty promx_hasTrainingWay=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasTrainingWay");
    public static final org.semanticwb.platform.SemanticProperty promx_traContact=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#traContact");
    public static final org.semanticwb.platform.SemanticClass promx_ProInstitutionSupport=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#proInstitutionSupport");
    public static final org.semanticwb.platform.SemanticProperty promx_hasInstitutionsSupport=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasInstitutionsSupport");
    public static final org.semanticwb.platform.SemanticClass promx_Training=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Training");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Training");

    public static class ClassMgr
    {
       /**
       * Returns a list of Training for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainings(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Training for all models
       * @return Iterator of org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainings()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training>(it, true);
        }

        public static org.semanticwb.promexico.Training createTraining(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.Training.ClassMgr.createTraining(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       * @return A org.semanticwb.promexico.Training
       */
        public static org.semanticwb.promexico.Training getTraining(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Training)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       * @return A org.semanticwb.promexico.Training
       */
        public static org.semanticwb.promexico.Training createTraining(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Training)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       */
        public static void removeTraining(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       * @return true if the org.semanticwb.promexico.Training exists, false otherwise
       */

        public static boolean hasTraining(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTraining(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined TraType
       * @param value TraType of the type org.semanticwb.promexico.TrainingType
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByTraType(org.semanticwb.promexico.TrainingType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_traType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined TraType
       * @param value TraType of the type org.semanticwb.promexico.TrainingType
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByTraType(org.semanticwb.promexico.TrainingType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_traType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined ProStates
       * @param value ProStates of the type org.semanticwb.promexico.ProStates
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByProStates(org.semanticwb.promexico.ProStates value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasProStates, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined ProStates
       * @param value ProStates of the type org.semanticwb.promexico.ProStates
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByProStates(org.semanticwb.promexico.ProStates value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasProStates,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined TraSectores
       * @param value TraSectores of the type org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByTraSectores(org.semanticwb.promexico.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasTraSectores, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined TraSectores
       * @param value TraSectores of the type org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByTraSectores(org.semanticwb.promexico.Sector value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasTraSectores,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined TrainingWay
       * @param value TrainingWay of the type org.semanticwb.promexico.TrainingWay
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByTrainingWay(org.semanticwb.promexico.TrainingWay value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasTrainingWay, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined TrainingWay
       * @param value TrainingWay of the type org.semanticwb.promexico.TrainingWay
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByTrainingWay(org.semanticwb.promexico.TrainingWay value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasTrainingWay,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined InstitutionsSupport
       * @param value InstitutionsSupport of the type org.semanticwb.promexico.ProInstitutionSupport
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByInstitutionsSupport(org.semanticwb.promexico.ProInstitutionSupport value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasInstitutionsSupport, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined InstitutionsSupport
       * @param value InstitutionsSupport of the type org.semanticwb.promexico.ProInstitutionSupport
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByInstitutionsSupport(org.semanticwb.promexico.ProInstitutionSupport value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasInstitutionsSupport,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TrainingBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Training
   */
    public TrainingBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the TraOpenInNewWindow property
* @return boolean with the TraOpenInNewWindow
*/
    public boolean isTraOpenInNewWindow()
    {
        return getSemanticObject().getBooleanProperty(promx_traOpenInNewWindow);
    }

/**
* Sets the TraOpenInNewWindow property
* @param value long with the TraOpenInNewWindow
*/
    public void setTraOpenInNewWindow(boolean value)
    {
        getSemanticObject().setBooleanProperty(promx_traOpenInNewWindow, value);
    }

/**
* Gets the TraShowInstitutionsContact property
* @return boolean with the TraShowInstitutionsContact
*/
    public boolean isTraShowInstitutionsContact()
    {
        return getSemanticObject().getBooleanProperty(promx_traShowInstitutionsContact);
    }

/**
* Sets the TraShowInstitutionsContact property
* @param value long with the TraShowInstitutionsContact
*/
    public void setTraShowInstitutionsContact(boolean value)
    {
        getSemanticObject().setBooleanProperty(promx_traShowInstitutionsContact, value);
    }
   /**
   * Sets the value for the property TraType
   * @param value TraType to set
   */

    public void setTraType(org.semanticwb.promexico.TrainingType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(promx_traType, value.getSemanticObject());
        }else
        {
            removeTraType();
        }
    }
   /**
   * Remove the value for TraType property
   */

    public void removeTraType()
    {
        getSemanticObject().removeProperty(promx_traType);
    }

   /**
   * Gets the TraType
   * @return a org.semanticwb.promexico.TrainingType
   */
    public org.semanticwb.promexico.TrainingType getTraType()
    {
         org.semanticwb.promexico.TrainingType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_traType);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.TrainingType)obj.createGenericInstance();
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
   * Gets all the org.semanticwb.promexico.ProStates
   * @return A GenericIterator with all the org.semanticwb.promexico.ProStates
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProStates> listProStateses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProStates>(getSemanticObject().listObjectProperties(promx_hasProStates));
    }

   /**
   * Gets true if has a ProStates
   * @param value org.semanticwb.promexico.ProStates to verify
   * @return true if the org.semanticwb.promexico.ProStates exists, false otherwise
   */
    public boolean hasProStates(org.semanticwb.promexico.ProStates value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasProStates,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ProStates
   * @param value org.semanticwb.promexico.ProStates to add
   */

    public void addProStates(org.semanticwb.promexico.ProStates value)
    {
        getSemanticObject().addObjectProperty(promx_hasProStates, value.getSemanticObject());
    }
   /**
   * Removes all the ProStates
   */

    public void removeAllProStates()
    {
        getSemanticObject().removeProperty(promx_hasProStates);
    }
   /**
   * Removes a ProStates
   * @param value org.semanticwb.promexico.ProStates to remove
   */

    public void removeProStates(org.semanticwb.promexico.ProStates value)
    {
        getSemanticObject().removeObjectProperty(promx_hasProStates,value.getSemanticObject());
    }

   /**
   * Gets the ProStates
   * @return a org.semanticwb.promexico.ProStates
   */
    public org.semanticwb.promexico.ProStates getProStates()
    {
         org.semanticwb.promexico.ProStates ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasProStates);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.ProStates)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the TraPhoto property
* @return String with the TraPhoto
*/
    public String getTraPhoto()
    {
        return getSemanticObject().getProperty(promx_traPhoto);
    }

/**
* Sets the TraPhoto property
* @param value long with the TraPhoto
*/
    public void setTraPhoto(String value)
    {
        getSemanticObject().setProperty(promx_traPhoto, value);
    }

/**
* Gets the TraEndDate property
* @return String with the TraEndDate
*/
    public String getTraEndDate()
    {
        return getSemanticObject().getProperty(promx_traEndDate);
    }

/**
* Sets the TraEndDate property
* @param value long with the TraEndDate
*/
    public void setTraEndDate(String value)
    {
        getSemanticObject().setProperty(promx_traEndDate, value);
    }

/**
* Gets the TraInitDate property
* @return String with the TraInitDate
*/
    public String getTraInitDate()
    {
        return getSemanticObject().getProperty(promx_traInitDate);
    }

/**
* Sets the TraInitDate property
* @param value long with the TraInitDate
*/
    public void setTraInitDate(String value)
    {
        getSemanticObject().setProperty(promx_traInitDate, value);
    }

/**
* Gets the TraExternalUrl property
* @return String with the TraExternalUrl
*/
    public String getTraExternalUrl()
    {
        return getSemanticObject().getProperty(promx_traExternalUrl);
    }

/**
* Sets the TraExternalUrl property
* @param value long with the TraExternalUrl
*/
    public void setTraExternalUrl(String value)
    {
        getSemanticObject().setProperty(promx_traExternalUrl, value);
    }

/**
* Gets the TraHours property
* @return String with the TraHours
*/
    public String getTraHours()
    {
        return getSemanticObject().getProperty(promx_traHours);
    }

/**
* Sets the TraHours property
* @param value long with the TraHours
*/
    public void setTraHours(String value)
    {
        getSemanticObject().setProperty(promx_traHours, value);
    }
   /**
   * Sets the value for the property Language
   * @param value Language to set
   */

    public void setLanguage(org.semanticwb.model.Language value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_language, value.getSemanticObject());
        }else
        {
            removeLanguage();
        }
    }
   /**
   * Remove the value for Language property
   */

    public void removeLanguage()
    {
        getSemanticObject().removeProperty(swb_language);
    }

   /**
   * Gets the Language
   * @return a org.semanticwb.model.Language
   */
    public org.semanticwb.model.Language getLanguage()
    {
         org.semanticwb.model.Language ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_language);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Language)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.promexico.Sector
   * @return A GenericIterator with all the org.semanticwb.promexico.Sector
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> listTraSectoreses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector>(getSemanticObject().listObjectProperties(promx_hasTraSectores));
    }

   /**
   * Gets true if has a TraSectores
   * @param value org.semanticwb.promexico.Sector to verify
   * @return true if the org.semanticwb.promexico.Sector exists, false otherwise
   */
    public boolean hasTraSectores(org.semanticwb.promexico.Sector value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasTraSectores,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a TraSectores
   * @param value org.semanticwb.promexico.Sector to add
   */

    public void addTraSectores(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().addObjectProperty(promx_hasTraSectores, value.getSemanticObject());
    }
   /**
   * Removes all the TraSectores
   */

    public void removeAllTraSectores()
    {
        getSemanticObject().removeProperty(promx_hasTraSectores);
    }
   /**
   * Removes a TraSectores
   * @param value org.semanticwb.promexico.Sector to remove
   */

    public void removeTraSectores(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().removeObjectProperty(promx_hasTraSectores,value.getSemanticObject());
    }

   /**
   * Gets the TraSectores
   * @return a org.semanticwb.promexico.Sector
   */
    public org.semanticwb.promexico.Sector getTraSectores()
    {
         org.semanticwb.promexico.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasTraSectores);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Sector)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the TraPrice property
* @return String with the TraPrice
*/
    public String getTraPrice()
    {
        return getSemanticObject().getProperty(promx_traPrice);
    }

/**
* Sets the TraPrice property
* @param value long with the TraPrice
*/
    public void setTraPrice(String value)
    {
        getSemanticObject().setProperty(promx_traPrice, value);
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
   * Gets all the org.semanticwb.promexico.TrainingWay
   * @return A GenericIterator with all the org.semanticwb.promexico.TrainingWay
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.TrainingWay> listTrainingWays()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.TrainingWay>(getSemanticObject().listObjectProperties(promx_hasTrainingWay));
    }

   /**
   * Gets true if has a TrainingWay
   * @param value org.semanticwb.promexico.TrainingWay to verify
   * @return true if the org.semanticwb.promexico.TrainingWay exists, false otherwise
   */
    public boolean hasTrainingWay(org.semanticwb.promexico.TrainingWay value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasTrainingWay,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a TrainingWay
   * @param value org.semanticwb.promexico.TrainingWay to add
   */

    public void addTrainingWay(org.semanticwb.promexico.TrainingWay value)
    {
        getSemanticObject().addObjectProperty(promx_hasTrainingWay, value.getSemanticObject());
    }
   /**
   * Removes all the TrainingWay
   */

    public void removeAllTrainingWay()
    {
        getSemanticObject().removeProperty(promx_hasTrainingWay);
    }
   /**
   * Removes a TrainingWay
   * @param value org.semanticwb.promexico.TrainingWay to remove
   */

    public void removeTrainingWay(org.semanticwb.promexico.TrainingWay value)
    {
        getSemanticObject().removeObjectProperty(promx_hasTrainingWay,value.getSemanticObject());
    }

   /**
   * Gets the TrainingWay
   * @return a org.semanticwb.promexico.TrainingWay
   */
    public org.semanticwb.promexico.TrainingWay getTrainingWay()
    {
         org.semanticwb.promexico.TrainingWay ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasTrainingWay);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.TrainingWay)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.model.Resource
   * @return A GenericIterator with all the org.semanticwb.model.Resource
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource> listResources()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource>(getSemanticObject().listObjectProperties(swb_hasResource));
    }

   /**
   * Gets true if has a Resource
   * @param value org.semanticwb.model.Resource to verify
   * @return true if the org.semanticwb.model.Resource exists, false otherwise
   */
    public boolean hasResource(org.semanticwb.model.Resource value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasResource,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Resource
   * @param value org.semanticwb.model.Resource to add
   */

    public void addResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().addObjectProperty(swb_hasResource, value.getSemanticObject());
    }
   /**
   * Removes all the Resource
   */

    public void removeAllResource()
    {
        getSemanticObject().removeProperty(swb_hasResource);
    }
   /**
   * Removes a Resource
   * @param value org.semanticwb.model.Resource to remove
   */

    public void removeResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().removeObjectProperty(swb_hasResource,value.getSemanticObject());
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasResource);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
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
* Gets the TraContact property
* @return String with the TraContact
*/
    public String getTraContact()
    {
        return getSemanticObject().getProperty(promx_traContact);
    }

/**
* Sets the TraContact property
* @param value long with the TraContact
*/
    public void setTraContact(String value)
    {
        getSemanticObject().setProperty(promx_traContact, value);
    }
   /**
   * Gets all the org.semanticwb.promexico.ProInstitutionSupport
   * @return A GenericIterator with all the org.semanticwb.promexico.ProInstitutionSupport
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport> listInstitutionsSupports()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProInstitutionSupport>(getSemanticObject().listObjectProperties(promx_hasInstitutionsSupport));
    }

   /**
   * Gets true if has a InstitutionsSupport
   * @param value org.semanticwb.promexico.ProInstitutionSupport to verify
   * @return true if the org.semanticwb.promexico.ProInstitutionSupport exists, false otherwise
   */
    public boolean hasInstitutionsSupport(org.semanticwb.promexico.ProInstitutionSupport value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasInstitutionsSupport,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a InstitutionsSupport
   * @param value org.semanticwb.promexico.ProInstitutionSupport to add
   */

    public void addInstitutionsSupport(org.semanticwb.promexico.ProInstitutionSupport value)
    {
        getSemanticObject().addObjectProperty(promx_hasInstitutionsSupport, value.getSemanticObject());
    }
   /**
   * Removes all the InstitutionsSupport
   */

    public void removeAllInstitutionsSupport()
    {
        getSemanticObject().removeProperty(promx_hasInstitutionsSupport);
    }
   /**
   * Removes a InstitutionsSupport
   * @param value org.semanticwb.promexico.ProInstitutionSupport to remove
   */

    public void removeInstitutionsSupport(org.semanticwb.promexico.ProInstitutionSupport value)
    {
        getSemanticObject().removeObjectProperty(promx_hasInstitutionsSupport,value.getSemanticObject());
    }

   /**
   * Gets the InstitutionsSupport
   * @return a org.semanticwb.promexico.ProInstitutionSupport
   */
    public org.semanticwb.promexico.ProInstitutionSupport getInstitutionsSupport()
    {
         org.semanticwb.promexico.ProInstitutionSupport ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasInstitutionsSupport);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.ProInstitutionSupport)obj.createGenericInstance();
         }
         return ret;
    }
}
