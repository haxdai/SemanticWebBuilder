package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos. 
   */
public abstract class EventBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Resourceable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
   /**
   * Referencia de un evento a una determinada actividad ej. Festival de Buceo, no necesariamente puede ocurrir siempre.
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEventActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEventActivityRef");
   /**
   * Fecha de Inicio del Evento
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_eventInitDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#eventInitDate");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de tipos de eventos.pueden ser Ej. "Carnavales", "Congresos", etc
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EventType");
   /**
   * Tipo de Evento al que pertenece un evento
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_eventEventType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#eventEventType");
   /**
   * Fecha final del Evento
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_eventEndDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#eventEndDate");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEventLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEventLocality");
   /**
   * Definie si es un evento destacado o no lo es
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_isLeadingEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#isLeadingEvent");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de Eventos.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Event");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Event");

    public static class ClassMgr
    {
       /**
       * Returns a list of Event for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Event for all models
       * @return Iterator of org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Event
       * @param id Identifier for org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.Event
       * @return A org.semanticwb.cptm.Event
       */
        public static org.semanticwb.cptm.Event getEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Event)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Event
       * @param id Identifier for org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.Event
       * @return A org.semanticwb.cptm.Event
       */
        public static org.semanticwb.cptm.Event createEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Event)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Event
       * @param id Identifier for org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.Event
       */
        public static void removeEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Event
       * @param id Identifier for org.semanticwb.cptm.Event
       * @param model Model of the org.semanticwb.cptm.Event
       * @return true if the org.semanticwb.cptm.Event exists, false otherwise
       */

        public static boolean hasEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEvent(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined EventActivityRef
       * @param value EventActivityRef of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByEventActivityRef(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventActivityRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined EventActivityRef
       * @param value EventActivityRef of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByEventActivityRef(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventActivityRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined EventEventType
       * @param value EventEventType of the type org.semanticwb.cptm.EventType
       * @param model Model of the org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByEventEventType(org.semanticwb.cptm.EventType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_eventEventType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined EventEventType
       * @param value EventEventType of the type org.semanticwb.cptm.EventType
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByEventEventType(org.semanticwb.cptm.EventType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_eventEventType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined EventLocality
       * @param value EventLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByEventLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined EventLocality
       * @param value EventLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByEventLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEventLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Event
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Event
       */

        public static java.util.Iterator<org.semanticwb.cptm.Event> listEventByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EventBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Event
   */
    public EventBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.Activity
   * @return A GenericIterator with all the org.semanticwb.cptm.Activity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> listEventActivityRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity>(getSemanticObject().listObjectProperties(cptm_hasEventActivityRef));
    }

   /**
   * Gets true if has a EventActivityRef
   * @param value org.semanticwb.cptm.Activity to verify
   * @return true if the org.semanticwb.cptm.Activity exists, false otherwise
   */
    public boolean hasEventActivityRef(org.semanticwb.cptm.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEventActivityRef,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EventActivityRef
   * @param value org.semanticwb.cptm.Activity to add
   */

    public void addEventActivityRef(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().addObjectProperty(cptm_hasEventActivityRef, value.getSemanticObject());
    }
   /**
   * Removes all the EventActivityRef
   */

    public void removeAllEventActivityRef()
    {
        getSemanticObject().removeProperty(cptm_hasEventActivityRef);
    }
   /**
   * Removes a EventActivityRef
   * @param value org.semanticwb.cptm.Activity to remove
   */

    public void removeEventActivityRef(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasEventActivityRef,value.getSemanticObject());
    }

   /**
   * Gets the EventActivityRef
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getEventActivityRef()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEventActivityRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Activity)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the EventInitDate property
* @return String with the EventInitDate
*/
    public String getEventInitDate()
    {
        return getSemanticObject().getProperty(cptm_eventInitDate);
    }

/**
* Sets the EventInitDate property
* @param value long with the EventInitDate
*/
    public void setEventInitDate(String value)
    {
        getSemanticObject().setProperty(cptm_eventInitDate, value);
    }

/**
* Gets the Photo property
* @return String with the Photo
*/
    public String getPhoto()
    {
        return getSemanticObject().getProperty(cptm_photo);
    }

/**
* Sets the Photo property
* @param value long with the Photo
*/
    public void setPhoto(String value)
    {
        getSemanticObject().setProperty(cptm_photo, value);
    }
   /**
   * Sets the value for the property EventEventType
   * @param value EventEventType to set
   */

    public void setEventEventType(org.semanticwb.cptm.EventType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_eventEventType, value.getSemanticObject());
        }else
        {
            removeEventEventType();
        }
    }
   /**
   * Remove the value for EventEventType property
   */

    public void removeEventEventType()
    {
        getSemanticObject().removeProperty(cptm_eventEventType);
    }

   /**
   * Gets the EventEventType
   * @return a org.semanticwb.cptm.EventType
   */
    public org.semanticwb.cptm.EventType getEventEventType()
    {
         org.semanticwb.cptm.EventType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_eventEventType);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EventType)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the EventEndDate property
* @return String with the EventEndDate
*/
    public String getEventEndDate()
    {
        return getSemanticObject().getProperty(cptm_eventEndDate);
    }

/**
* Sets the EventEndDate property
* @param value long with the EventEndDate
*/
    public void setEventEndDate(String value)
    {
        getSemanticObject().setProperty(cptm_eventEndDate, value);
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
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listEventLocalities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasEventLocality));
    }

   /**
   * Gets true if has a EventLocality
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasEventLocality(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEventLocality,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EventLocality
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addEventLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasEventLocality, value.getSemanticObject());
    }
   /**
   * Removes all the EventLocality
   */

    public void removeAllEventLocality()
    {
        getSemanticObject().removeProperty(cptm_hasEventLocality);
    }
   /**
   * Removes a EventLocality
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeEventLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasEventLocality,value.getSemanticObject());
    }

   /**
   * Gets the EventLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getEventLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEventLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the IsLeadingEvent property
* @return boolean with the IsLeadingEvent
*/
    public boolean isIsLeadingEvent()
    {
        return getSemanticObject().getBooleanProperty(cptm_isLeadingEvent);
    }

/**
* Sets the IsLeadingEvent property
* @param value long with the IsLeadingEvent
*/
    public void setIsLeadingEvent(boolean value)
    {
        getSemanticObject().setBooleanProperty(cptm_isLeadingEvent, value);
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

    public java.util.Iterator<String> listMorePhotos()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(cptm_hasMorePhoto);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addMorePhoto(String value)
    {
        getSemanticObject().addLiteralProperty(cptm_hasMorePhoto, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllMorePhoto()
    {
        getSemanticObject().removeProperty(cptm_hasMorePhoto);
    }

    public void removeMorePhoto(String value)
    {
        getSemanticObject().removeLiteralProperty(cptm_hasMorePhoto,new org.semanticwb.platform.SemanticLiteral(value));
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
* Gets the PhotoEscudo property
* @return String with the PhotoEscudo
*/
    public String getPhotoEscudo()
    {
        return getSemanticObject().getProperty(cptm_photoEscudo);
    }

/**
* Sets the PhotoEscudo property
* @param value long with the PhotoEscudo
*/
    public void setPhotoEscudo(String value)
    {
        getSemanticObject().setProperty(cptm_photoEscudo, value);
    }

   /**
   * Gets the CPTMWebSite
   * @return a instance of org.semanticwb.cptm.CPTMWebSite
   */
    public org.semanticwb.cptm.CPTMWebSite getCPTMWebSite()
    {
        return (org.semanticwb.cptm.CPTMWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
