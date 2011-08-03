package gob.sep.becas.base;


public abstract class TicketActivateBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty becas_TVRelatedTo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TVRelatedTo");
    public static final org.semanticwb.platform.SemanticProperty becas_TVused=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TVused");
    public static final org.semanticwb.platform.SemanticClass becas_TicketActivate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TicketActivate");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TicketActivate");

    public static class ClassMgr
    {
       /**
       * Returns a list of TicketActivate for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.TicketActivate
       */

        public static java.util.Iterator<gob.sep.becas.TicketActivate> listTicketActivates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.TicketActivate>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.TicketActivate for all models
       * @return Iterator of gob.sep.becas.TicketActivate
       */

        public static java.util.Iterator<gob.sep.becas.TicketActivate> listTicketActivates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.TicketActivate>(it, true);
        }
       /**
       * Gets a gob.sep.becas.TicketActivate
       * @param id Identifier for gob.sep.becas.TicketActivate
       * @param model Model of the gob.sep.becas.TicketActivate
       * @return A gob.sep.becas.TicketActivate
       */
        public static gob.sep.becas.TicketActivate getTicketActivate(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.TicketActivate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.TicketActivate
       * @param id Identifier for gob.sep.becas.TicketActivate
       * @param model Model of the gob.sep.becas.TicketActivate
       * @return A gob.sep.becas.TicketActivate
       */
        public static gob.sep.becas.TicketActivate createTicketActivate(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.TicketActivate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.TicketActivate
       * @param id Identifier for gob.sep.becas.TicketActivate
       * @param model Model of the gob.sep.becas.TicketActivate
       */
        public static void removeTicketActivate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.TicketActivate
       * @param id Identifier for gob.sep.becas.TicketActivate
       * @param model Model of the gob.sep.becas.TicketActivate
       * @return true if the gob.sep.becas.TicketActivate exists, false otherwise
       */

        public static boolean hasTicketActivate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTicketActivate(id, model)!=null);
        }
       /**
       * Gets all gob.sep.becas.TicketActivate with a determined TVRelatedTo
       * @param value TVRelatedTo of the type org.semanticwb.model.User
       * @param model Model of the gob.sep.becas.TicketActivate
       * @return Iterator with all the gob.sep.becas.TicketActivate
       */

        public static java.util.Iterator<gob.sep.becas.TicketActivate> listTicketActivateByTVRelatedTo(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.TicketActivate> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_TVRelatedTo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.TicketActivate with a determined TVRelatedTo
       * @param value TVRelatedTo of the type org.semanticwb.model.User
       * @return Iterator with all the gob.sep.becas.TicketActivate
       */

        public static java.util.Iterator<gob.sep.becas.TicketActivate> listTicketActivateByTVRelatedTo(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.TicketActivate> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_TVRelatedTo,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TicketActivateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TicketActivate
   */
    public TicketActivateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property TVRelatedTo
   * @param value TVRelatedTo to set
   */

    public void setTVRelatedTo(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_TVRelatedTo, value.getSemanticObject());
        }else
        {
            removeTVRelatedTo();
        }
    }
   /**
   * Remove the value for TVRelatedTo property
   */

    public void removeTVRelatedTo()
    {
        getSemanticObject().removeProperty(becas_TVRelatedTo);
    }

   /**
   * Gets the TVRelatedTo
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getTVRelatedTo()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_TVRelatedTo);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the TVused property
* @return boolean with the TVused
*/
    public boolean isTVused()
    {
        return getSemanticObject().getBooleanProperty(becas_TVused);
    }

/**
* Sets the TVused property
* @param value long with the TVused
*/
    public void setTVused(boolean value)
    {
        getSemanticObject().setBooleanProperty(becas_TVused, value);
    }
}
