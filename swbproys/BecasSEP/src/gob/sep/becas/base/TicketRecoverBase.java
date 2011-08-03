package gob.sep.becas.base;


public abstract class TicketRecoverBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty becas_TRused=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TRused");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty becas_TRRelatedTo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TRRelatedTo");
    public static final org.semanticwb.platform.SemanticClass becas_TicketRecover=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TicketRecover");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#TicketRecover");

    public static class ClassMgr
    {
       /**
       * Returns a list of TicketRecover for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.TicketRecover
       */

        public static java.util.Iterator<gob.sep.becas.TicketRecover> listTicketRecovers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.TicketRecover>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.TicketRecover for all models
       * @return Iterator of gob.sep.becas.TicketRecover
       */

        public static java.util.Iterator<gob.sep.becas.TicketRecover> listTicketRecovers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.TicketRecover>(it, true);
        }
       /**
       * Gets a gob.sep.becas.TicketRecover
       * @param id Identifier for gob.sep.becas.TicketRecover
       * @param model Model of the gob.sep.becas.TicketRecover
       * @return A gob.sep.becas.TicketRecover
       */
        public static gob.sep.becas.TicketRecover getTicketRecover(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.TicketRecover)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.TicketRecover
       * @param id Identifier for gob.sep.becas.TicketRecover
       * @param model Model of the gob.sep.becas.TicketRecover
       * @return A gob.sep.becas.TicketRecover
       */
        public static gob.sep.becas.TicketRecover createTicketRecover(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.TicketRecover)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.TicketRecover
       * @param id Identifier for gob.sep.becas.TicketRecover
       * @param model Model of the gob.sep.becas.TicketRecover
       */
        public static void removeTicketRecover(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.TicketRecover
       * @param id Identifier for gob.sep.becas.TicketRecover
       * @param model Model of the gob.sep.becas.TicketRecover
       * @return true if the gob.sep.becas.TicketRecover exists, false otherwise
       */

        public static boolean hasTicketRecover(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTicketRecover(id, model)!=null);
        }
       /**
       * Gets all gob.sep.becas.TicketRecover with a determined TRRelatedTo
       * @param value TRRelatedTo of the type org.semanticwb.model.User
       * @param model Model of the gob.sep.becas.TicketRecover
       * @return Iterator with all the gob.sep.becas.TicketRecover
       */

        public static java.util.Iterator<gob.sep.becas.TicketRecover> listTicketRecoverByTRRelatedTo(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.TicketRecover> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_TRRelatedTo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.TicketRecover with a determined TRRelatedTo
       * @param value TRRelatedTo of the type org.semanticwb.model.User
       * @return Iterator with all the gob.sep.becas.TicketRecover
       */

        public static java.util.Iterator<gob.sep.becas.TicketRecover> listTicketRecoverByTRRelatedTo(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.TicketRecover> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_TRRelatedTo,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TicketRecoverBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TicketRecover
   */
    public TicketRecoverBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the TRused property
* @return boolean with the TRused
*/
    public boolean isTRused()
    {
        return getSemanticObject().getBooleanProperty(becas_TRused);
    }

/**
* Sets the TRused property
* @param value long with the TRused
*/
    public void setTRused(boolean value)
    {
        getSemanticObject().setBooleanProperty(becas_TRused, value);
    }
   /**
   * Sets the value for the property TRRelatedTo
   * @param value TRRelatedTo to set
   */

    public void setTRRelatedTo(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_TRRelatedTo, value.getSemanticObject());
        }else
        {
            removeTRRelatedTo();
        }
    }
   /**
   * Remove the value for TRRelatedTo property
   */

    public void removeTRRelatedTo()
    {
        getSemanticObject().removeProperty(becas_TRRelatedTo);
    }

   /**
   * Gets the TRRelatedTo
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getTRRelatedTo()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_TRRelatedTo);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
