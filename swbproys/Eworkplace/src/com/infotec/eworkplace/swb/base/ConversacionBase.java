package com.infotec.eworkplace.swb.base;


public abstract class ConversacionBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Conversacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Conversacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Conversacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Conversacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Conversacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conversacion> listConversacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conversacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Conversacion for all models
       * @return Iterator of com.infotec.eworkplace.swb.Conversacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conversacion> listConversacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conversacion>(it, true);
        }

        public static com.infotec.eworkplace.swb.Conversacion createConversacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Conversacion.ClassMgr.createConversacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Conversacion
       * @param id Identifier for com.infotec.eworkplace.swb.Conversacion
       * @param model Model of the com.infotec.eworkplace.swb.Conversacion
       * @return A com.infotec.eworkplace.swb.Conversacion
       */
        public static com.infotec.eworkplace.swb.Conversacion getConversacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Conversacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Conversacion
       * @param id Identifier for com.infotec.eworkplace.swb.Conversacion
       * @param model Model of the com.infotec.eworkplace.swb.Conversacion
       * @return A com.infotec.eworkplace.swb.Conversacion
       */
        public static com.infotec.eworkplace.swb.Conversacion createConversacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Conversacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Conversacion
       * @param id Identifier for com.infotec.eworkplace.swb.Conversacion
       * @param model Model of the com.infotec.eworkplace.swb.Conversacion
       */
        public static void removeConversacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Conversacion
       * @param id Identifier for com.infotec.eworkplace.swb.Conversacion
       * @param model Model of the com.infotec.eworkplace.swb.Conversacion
       * @return true if the com.infotec.eworkplace.swb.Conversacion exists, false otherwise
       */

        public static boolean hasConversacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getConversacion(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Conversacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Conversacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Conversacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conversacion> listConversacionByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conversacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Conversacion with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Conversacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conversacion> listConversacionByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conversacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Conversacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Conversacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Conversacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conversacion> listConversacionByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conversacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Conversacion with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Conversacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Conversacion> listConversacionByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conversacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ConversacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Conversacion
   */
    public ConversacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
