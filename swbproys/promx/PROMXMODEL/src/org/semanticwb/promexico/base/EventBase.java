package org.semanticwb.promexico.base;


   /**
   * Eventos de ProMéxico 
   */
public abstract class EventBase extends org.semanticwb.portal.resources.sem.calendar.Event implements org.semanticwb.model.Activeable,org.semanticwb.model.Localeable,org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable
{
    public static final org.semanticwb.platform.SemanticClass promx_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Sector");
    public static final org.semanticwb.platform.SemanticProperty promx_hasSectores=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasSectores");
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
   * Gets the ProMexico
   * @return a instance of org.semanticwb.promexico.ProMexico
   */
    public org.semanticwb.promexico.ProMexico getProMexico()
    {
        return (org.semanticwb.promexico.ProMexico)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
