package org.semanticwb.promexico.base;


   /**
   * Eventos de ProMéxico 
   */
public abstract class EventBase extends org.semanticwb.portal.resources.sem.genericCalendar.Event implements org.semanticwb.model.Descriptiveable,org.semanticwb.promexico.ProSearchAble,org.semanticwb.model.Searchable,org.semanticwb.model.Ruleable,org.semanticwb.model.Resourceable,org.semanticwb.model.Localeable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
   /**
   * Objeto controlador de oficinas
   */
    public static final org.semanticwb.platform.SemanticClass promx_Office=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Office");
   /**
   * Oficinas con las cuales esta relacionado el evento
   */
    public static final org.semanticwb.platform.SemanticProperty promx_hasOffice=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasOffice");
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
    public static final org.semanticwb.platform.SemanticProperty promx_hasSectores=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasSectores");
   /**
   * Foto del Evento
   */
    public static final org.semanticwb.platform.SemanticProperty promx_eventPhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#eventPhoto");
   /**
   * Subtipos de Eventos, despues cambiar la manera de presentar en la administración por combos anidados, es decir, de acuerdo al tipo (Nacional o Internacional), presentar los subtipos.
   */
    public static final org.semanticwb.platform.SemanticClass promx_EventSubType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#EventSubType");
   /**
   * SubTipo de Evento, despues cambiar esto por un combo anidado presentando las opciones de subtipos de acuerdo al typo seleccionado (Nacional o Internacional)
   */
    public static final org.semanticwb.platform.SemanticProperty promx_evSubType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#evSubType");
   /**
   * Eventos de ProMéxico
   */
    public static final org.semanticwb.platform.SemanticClass promx_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Event");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Event");

    public static class ClassMgr
    {
       /**
       * Returns a list of Event for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Event for all models
       * @return Iterator of org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event>(it, true);
        }

        public static org.semanticwb.promexico.Event createEvent(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.promexico.Event.ClassMgr.createEvent(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.promexico.Event
       * @param id Identifier for org.semanticwb.promexico.Event
       * @param model Model of the org.semanticwb.promexico.Event
       * @return A org.semanticwb.promexico.Event
       */
        public static org.semanticwb.promexico.Event getEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Event)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Event
       * @param id Identifier for org.semanticwb.promexico.Event
       * @param model Model of the org.semanticwb.promexico.Event
       * @return A org.semanticwb.promexico.Event
       */
        public static org.semanticwb.promexico.Event createEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Event)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Event
       * @param id Identifier for org.semanticwb.promexico.Event
       * @param model Model of the org.semanticwb.promexico.Event
       */
        public static void removeEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Event
       * @param id Identifier for org.semanticwb.promexico.Event
       * @param model Model of the org.semanticwb.promexico.Event
       * @return true if the org.semanticwb.promexico.Event exists, false otherwise
       */

        public static boolean hasEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEvent(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Office
       * @param value Office of the type org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByOffice(org.semanticwb.promexico.Office value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasOffice, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Office
       * @param value Office of the type org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByOffice(org.semanticwb.promexico.Office value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasOffice,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Sectores
       * @param value Sectores of the type org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventBySectores(org.semanticwb.promexico.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasSectores, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Sectores
       * @param value Sectores of the type org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventBySectores(org.semanticwb.promexico.Sector value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasSectores,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined EvType
       * @param value EvType of the type org.semanticwb.portal.resources.sem.genericCalendar.EventType
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByEvType(org.semanticwb.portal.resources.sem.genericCalendar.EventType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(genCal_evType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined EvType
       * @param value EvType of the type org.semanticwb.portal.resources.sem.genericCalendar.EventType
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByEvType(org.semanticwb.portal.resources.sem.genericCalendar.EventType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(genCal_evType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByRule(org.semanticwb.model.Rule value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByRule(org.semanticwb.model.Rule value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined EvSubType
       * @param value EvSubType of the type org.semanticwb.promexico.EventSubType
       * @param model Model of the org.semanticwb.promexico.Event
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByEvSubType(org.semanticwb.promexico.EventSubType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_evSubType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Event with a determined EvSubType
       * @param value EvSubType of the type org.semanticwb.promexico.EventSubType
       * @return Iterator with all the org.semanticwb.promexico.Event
       */

        public static java.util.Iterator<org.semanticwb.promexico.Event> listEventByEvSubType(org.semanticwb.promexico.EventSubType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Event> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_evSubType,value.getSemanticObject(),sclass));
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
   * Gets all the org.semanticwb.promexico.Office
   * @return A GenericIterator with all the org.semanticwb.promexico.Office
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> listOffices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office>(getSemanticObject().listObjectProperties(promx_hasOffice));
    }

   /**
   * Gets true if has a Office
   * @param value org.semanticwb.promexico.Office to verify
   * @return true if the org.semanticwb.promexico.Office exists, false otherwise
   */
    public boolean hasOffice(org.semanticwb.promexico.Office value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasOffice,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Office
   * @param value org.semanticwb.promexico.Office to add
   */

    public void addOffice(org.semanticwb.promexico.Office value)
    {
        getSemanticObject().addObjectProperty(promx_hasOffice, value.getSemanticObject());
    }
   /**
   * Removes all the Office
   */

    public void removeAllOffice()
    {
        getSemanticObject().removeProperty(promx_hasOffice);
    }
   /**
   * Removes a Office
   * @param value org.semanticwb.promexico.Office to remove
   */

    public void removeOffice(org.semanticwb.promexico.Office value)
    {
        getSemanticObject().removeObjectProperty(promx_hasOffice,value.getSemanticObject());
    }

   /**
   * Gets the Office
   * @return a org.semanticwb.promexico.Office
   */
    public org.semanticwb.promexico.Office getOffice()
    {
         org.semanticwb.promexico.Office ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasOffice);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Office)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.promexico.Sector
   * @return A GenericIterator with all the org.semanticwb.promexico.Sector
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector> listSectoreses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Sector>(getSemanticObject().listObjectProperties(promx_hasSectores));
    }

   /**
   * Gets true if has a Sectores
   * @param value org.semanticwb.promexico.Sector to verify
   * @return true if the org.semanticwb.promexico.Sector exists, false otherwise
   */
    public boolean hasSectores(org.semanticwb.promexico.Sector value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasSectores,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Sectores
   * @param value org.semanticwb.promexico.Sector to add
   */

    public void addSectores(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().addObjectProperty(promx_hasSectores, value.getSemanticObject());
    }
   /**
   * Removes all the Sectores
   */

    public void removeAllSectores()
    {
        getSemanticObject().removeProperty(promx_hasSectores);
    }
   /**
   * Removes a Sectores
   * @param value org.semanticwb.promexico.Sector to remove
   */

    public void removeSectores(org.semanticwb.promexico.Sector value)
    {
        getSemanticObject().removeObjectProperty(promx_hasSectores,value.getSemanticObject());
    }

   /**
   * Gets the Sectores
   * @return a org.semanticwb.promexico.Sector
   */
    public org.semanticwb.promexico.Sector getSectores()
    {
         org.semanticwb.promexico.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasSectores);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Sector)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the EventPhoto property
* @return String with the EventPhoto
*/
    public String getEventPhoto()
    {
        return getSemanticObject().getProperty(promx_eventPhoto);
    }

/**
* Sets the EventPhoto property
* @param value long with the EventPhoto
*/
    public void setEventPhoto(String value)
    {
        getSemanticObject().setProperty(promx_eventPhoto, value);
    }
   /**
   * Gets all the org.semanticwb.model.Rule
   * @return A GenericIterator with all the org.semanticwb.model.Rule
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Rule> listRules()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Rule>(getSemanticObject().listObjectProperties(swb_hasRule));
    }

   /**
   * Gets true if has a Rule
   * @param value org.semanticwb.model.Rule to verify
   * @return true if the org.semanticwb.model.Rule exists, false otherwise
   */
    public boolean hasRule(org.semanticwb.model.Rule value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasRule,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Rule
   * @param value org.semanticwb.model.Rule to add
   */

    public void addRule(org.semanticwb.model.Rule value)
    {
        getSemanticObject().addObjectProperty(swb_hasRule, value.getSemanticObject());
    }
   /**
   * Removes all the Rule
   */

    public void removeAllRule()
    {
        getSemanticObject().removeProperty(swb_hasRule);
    }
   /**
   * Removes a Rule
   * @param value org.semanticwb.model.Rule to remove
   */

    public void removeRule(org.semanticwb.model.Rule value)
    {
        getSemanticObject().removeObjectProperty(swb_hasRule,value.getSemanticObject());
    }

   /**
   * Gets the Rule
   * @return a org.semanticwb.model.Rule
   */
    public org.semanticwb.model.Rule getRule()
    {
         org.semanticwb.model.Rule ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRule);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Rule)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ProSearchDescription property
* @return String with the ProSearchDescription
*/
    public String getProSearchDescription()
    {
        return getSemanticObject().getProperty(promx_proSearchDescription);
    }

/**
* Sets the ProSearchDescription property
* @param value long with the ProSearchDescription
*/
    public void setProSearchDescription(String value)
    {
        getSemanticObject().setProperty(promx_proSearchDescription, value);
    }

    public String getProSearchDescription(String lang)
    {
        return getSemanticObject().getProperty(promx_proSearchDescription, null, lang);
    }

    public String getDisplayProSearchDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(promx_proSearchDescription, lang);
    }

    public void setProSearchDescription(String proSearchDescription, String lang)
    {
        getSemanticObject().setProperty(promx_proSearchDescription, proSearchDescription, lang);
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
   * Sets the value for the property EvSubType
   * @param value EvSubType to set
   */

    public void setEvSubType(org.semanticwb.promexico.EventSubType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(promx_evSubType, value.getSemanticObject());
        }else
        {
            removeEvSubType();
        }
    }
   /**
   * Remove the value for EvSubType property
   */

    public void removeEvSubType()
    {
        getSemanticObject().removeProperty(promx_evSubType);
    }

   /**
   * Gets the EvSubType
   * @return a org.semanticwb.promexico.EventSubType
   */
    public org.semanticwb.promexico.EventSubType getEvSubType()
    {
         org.semanticwb.promexico.EventSubType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_evSubType);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.EventSubType)obj.createGenericInstance();
         }
         return ret;
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
