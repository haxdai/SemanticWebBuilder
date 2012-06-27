package org.semanticwb.cptm.base;


   /**
   * Categorías para los tipos de Eventos, ej. "Turisticos", Industria de Negocio" 
   */
public abstract class EventCategoryBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de tipos de eventos.pueden ser Ej. "Carnavales", "Congresos", etc
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EventType");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEventTypeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEventTypeInv");
   /**
   * Categorías para los tipos de Eventos, ej. "Turisticos", Industria de Negocio"
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EventCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EventCategory");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EventCategory");

    public static class ClassMgr
    {
       /**
       * Returns a list of EventCategory for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategories(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.EventCategory for all models
       * @return Iterator of org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategories()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.EventCategory
       * @param id Identifier for org.semanticwb.cptm.EventCategory
       * @param model Model of the org.semanticwb.cptm.EventCategory
       * @return A org.semanticwb.cptm.EventCategory
       */
        public static org.semanticwb.cptm.EventCategory getEventCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.EventCategory)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.EventCategory
       * @param id Identifier for org.semanticwb.cptm.EventCategory
       * @param model Model of the org.semanticwb.cptm.EventCategory
       * @return A org.semanticwb.cptm.EventCategory
       */
        public static org.semanticwb.cptm.EventCategory createEventCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.EventCategory)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.EventCategory
       * @param id Identifier for org.semanticwb.cptm.EventCategory
       * @param model Model of the org.semanticwb.cptm.EventCategory
       */
        public static void removeEventCategory(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.EventCategory
       * @param id Identifier for org.semanticwb.cptm.EventCategory
       * @param model Model of the org.semanticwb.cptm.EventCategory
       * @return true if the org.semanticwb.cptm.EventCategory exists, false otherwise
       */

        public static boolean hasEventCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEventCategory(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.EventCategory with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.EventCategory
       * @return Iterator with all the org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategoryByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EventCategory with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategoryByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EventCategory with a determined EventTypeInv
       * @param value EventTypeInv of the type org.semanticwb.cptm.EventType
       * @param model Model of the org.semanticwb.cptm.EventCategory
       * @return Iterator with all the org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategoryByEventTypeInv(org.semanticwb.cptm.EventType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventTypeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EventCategory with a determined EventTypeInv
       * @param value EventTypeInv of the type org.semanticwb.cptm.EventType
       * @return Iterator with all the org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategoryByEventTypeInv(org.semanticwb.cptm.EventType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventTypeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EventCategory with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.EventCategory
       * @return Iterator with all the org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategoryByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EventCategory with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.EventCategory
       */

        public static java.util.Iterator<org.semanticwb.cptm.EventCategory> listEventCategoryByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EventCategoryBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EventCategory
   */
    public EventCategoryBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.cptm.EventType
   * @return A GenericIterator with all the org.semanticwb.cptm.EventType
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventType> listEventTypeInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EventType>(getSemanticObject().listObjectProperties(cptm_hasEventTypeInv));
    }

   /**
   * Gets true if has a EventTypeInv
   * @param value org.semanticwb.cptm.EventType to verify
   * @return true if the org.semanticwb.cptm.EventType exists, false otherwise
   */
    public boolean hasEventTypeInv(org.semanticwb.cptm.EventType value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEventTypeInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EventTypeInv
   * @return a org.semanticwb.cptm.EventType
   */
    public org.semanticwb.cptm.EventType getEventTypeInv()
    {
         org.semanticwb.cptm.EventType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEventTypeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EventType)obj.createGenericInstance();
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
