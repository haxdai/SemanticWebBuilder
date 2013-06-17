package org.semanticwb.bsc.element.base;


public abstract class InitiativeBase extends org.semanticwb.bsc.element.BSCElement implements org.semanticwb.bsc.Schedule,org.semanticwb.model.Traceable,org.semanticwb.bsc.Committable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable,org.semanticwb.bsc.Updateable
{
    public static final org.semanticwb.platform.SemanticProperty bsc_index=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#index");
    public static final org.semanticwb.platform.SemanticClass bsc_Deliverable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Deliverable");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasDeliverable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasDeliverable");
    public static final org.semanticwb.platform.SemanticClass bsc_Initiative=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Initiative");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Initiative");

    public static class ClassMgr
    {
       /**
       * Returns a list of Initiative for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiatives(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.element.Initiative for all models
       * @return Iterator of org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiatives()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative>(it, true);
        }

        public static org.semanticwb.bsc.element.Initiative createInitiative(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.element.Initiative.ClassMgr.createInitiative(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.element.Initiative
       * @param id Identifier for org.semanticwb.bsc.element.Initiative
       * @param model Model of the org.semanticwb.bsc.element.Initiative
       * @return A org.semanticwb.bsc.element.Initiative
       */
        public static org.semanticwb.bsc.element.Initiative getInitiative(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Initiative)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.element.Initiative
       * @param id Identifier for org.semanticwb.bsc.element.Initiative
       * @param model Model of the org.semanticwb.bsc.element.Initiative
       * @return A org.semanticwb.bsc.element.Initiative
       */
        public static org.semanticwb.bsc.element.Initiative createInitiative(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Initiative)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.element.Initiative
       * @param id Identifier for org.semanticwb.bsc.element.Initiative
       * @param model Model of the org.semanticwb.bsc.element.Initiative
       */
        public static void removeInitiative(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.element.Initiative
       * @param id Identifier for org.semanticwb.bsc.element.Initiative
       * @param model Model of the org.semanticwb.bsc.element.Initiative
       * @return true if the org.semanticwb.bsc.element.Initiative exists, false otherwise
       */

        public static boolean hasInitiative(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInitiative(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.element.Initiative with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Initiative
       * @return Iterator with all the org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiativeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Initiative with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiativeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Initiative with a determined Deliverable
       * @param value Deliverable of the type org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Initiative
       * @return Iterator with all the org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiativeByDeliverable(org.semanticwb.bsc.element.Deliverable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasDeliverable, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Initiative with a determined Deliverable
       * @param value Deliverable of the type org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiativeByDeliverable(org.semanticwb.bsc.element.Deliverable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasDeliverable,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Initiative with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Initiative
       * @return Iterator with all the org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiativeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Initiative with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Initiative
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Initiative> listInitiativeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a InitiativeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Initiative
   */
    public InitiativeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the PercentageProgress property
* @return float with the PercentageProgress
*/
    public float getPercentageProgress()
    {
        return getSemanticObject().getFloatProperty(bsc_percentageProgress);
    }

/**
* Sets the PercentageProgress property
* @param value long with the PercentageProgress
*/
    public void setPercentageProgress(float value)
    {
        getSemanticObject().setFloatProperty(bsc_percentageProgress, value);
    }

/**
* Gets the PlannedEnd property
* @return java.util.Date with the PlannedEnd
*/
    public java.util.Date getPlannedEnd()
    {
        return getSemanticObject().getDateProperty(bsc_plannedEnd);
    }

/**
* Sets the PlannedEnd property
* @param value long with the PlannedEnd
*/
    public void setPlannedEnd(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_plannedEnd, value);
    }

/**
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        return getSemanticObject().getIntProperty(bsc_index);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(bsc_index, value);
    }

/**
* Gets the Recommendations property
* @return String with the Recommendations
*/
    public String getRecommendations()
    {
        return getSemanticObject().getProperty(bsc_recommendations);
    }

/**
* Sets the Recommendations property
* @param value long with the Recommendations
*/
    public void setRecommendations(String value)
    {
        getSemanticObject().setProperty(bsc_recommendations, value);
    }
   /**
   * Gets all the org.semanticwb.bsc.element.Deliverable
   * @return A GenericIterator with all the org.semanticwb.bsc.element.Deliverable
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> listDeliverables()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable>(getSemanticObject().listObjectProperties(bsc_hasDeliverable));
    }

   /**
   * Gets true if has a Deliverable
   * @param value org.semanticwb.bsc.element.Deliverable to verify
   * @return true if the org.semanticwb.bsc.element.Deliverable exists, false otherwise
   */
    public boolean hasDeliverable(org.semanticwb.bsc.element.Deliverable value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasDeliverable,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Deliverable
   * @param value org.semanticwb.bsc.element.Deliverable to add
   */

    public void addDeliverable(org.semanticwb.bsc.element.Deliverable value)
    {
        getSemanticObject().addObjectProperty(bsc_hasDeliverable, value.getSemanticObject());
    }
   /**
   * Removes all the Deliverable
   */

    public void removeAllDeliverable()
    {
        getSemanticObject().removeProperty(bsc_hasDeliverable);
    }
   /**
   * Removes a Deliverable
   * @param value org.semanticwb.bsc.element.Deliverable to remove
   */

    public void removeDeliverable(org.semanticwb.bsc.element.Deliverable value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasDeliverable,value.getSemanticObject());
    }

   /**
   * Gets the Deliverable
   * @return a org.semanticwb.bsc.element.Deliverable
   */
    public org.semanticwb.bsc.element.Deliverable getDeliverable()
    {
         org.semanticwb.bsc.element.Deliverable ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasDeliverable);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.element.Deliverable)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PlannedStart property
* @return java.util.Date with the PlannedStart
*/
    public java.util.Date getPlannedStart()
    {
        return getSemanticObject().getDateProperty(bsc_plannedStart);
    }

/**
* Sets the PlannedStart property
* @param value long with the PlannedStart
*/
    public void setPlannedStart(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_plannedStart, value);
    }

/**
* Gets the ActualEnd property
* @return java.util.Date with the ActualEnd
*/
    public java.util.Date getActualEnd()
    {
        return getSemanticObject().getDateProperty(bsc_actualEnd);
    }

/**
* Sets the ActualEnd property
* @param value long with the ActualEnd
*/
    public void setActualEnd(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_actualEnd, value);
    }

/**
* Gets the Analysis property
* @return String with the Analysis
*/
    public String getAnalysis()
    {
        return getSemanticObject().getProperty(bsc_analysis);
    }

/**
* Sets the Analysis property
* @param value long with the Analysis
*/
    public void setAnalysis(String value)
    {
        getSemanticObject().setProperty(bsc_analysis, value);
    }

/**
* Gets the Commited property
* @return boolean with the Commited
*/
    public boolean isCommited()
    {
        return getSemanticObject().getBooleanProperty(bsc_commited);
    }

/**
* Sets the Commited property
* @param value long with the Commited
*/
    public void setCommited(boolean value)
    {
        getSemanticObject().setBooleanProperty(bsc_commited, value);
    }

/**
* Gets the ActualStart property
* @return java.util.Date with the ActualStart
*/
    public java.util.Date getActualStart()
    {
        return getSemanticObject().getDateProperty(bsc_actualStart);
    }

/**
* Sets the ActualStart property
* @param value long with the ActualStart
*/
    public void setActualStart(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_actualStart, value);
    }

   /**
   * Gets the BSC
   * @return a instance of org.semanticwb.bsc.BSC
   */
    public org.semanticwb.bsc.BSC getBSC()
    {
        return (org.semanticwb.bsc.BSC)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
