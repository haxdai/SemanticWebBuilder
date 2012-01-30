package com.infotec.eworkplace.swb.base;


public abstract class EscrituraBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Escritura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Escritura");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Escritura");

    public static class ClassMgr
    {
       /**
       * Returns a list of Escritura for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Escritura
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Escritura> listEscrituras(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Escritura>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Escritura for all models
       * @return Iterator of com.infotec.eworkplace.swb.Escritura
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Escritura> listEscrituras()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Escritura>(it, true);
        }

        public static com.infotec.eworkplace.swb.Escritura createEscritura(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Escritura.ClassMgr.createEscritura(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Escritura
       * @param id Identifier for com.infotec.eworkplace.swb.Escritura
       * @param model Model of the com.infotec.eworkplace.swb.Escritura
       * @return A com.infotec.eworkplace.swb.Escritura
       */
        public static com.infotec.eworkplace.swb.Escritura getEscritura(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Escritura)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Escritura
       * @param id Identifier for com.infotec.eworkplace.swb.Escritura
       * @param model Model of the com.infotec.eworkplace.swb.Escritura
       * @return A com.infotec.eworkplace.swb.Escritura
       */
        public static com.infotec.eworkplace.swb.Escritura createEscritura(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Escritura)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Escritura
       * @param id Identifier for com.infotec.eworkplace.swb.Escritura
       * @param model Model of the com.infotec.eworkplace.swb.Escritura
       */
        public static void removeEscritura(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Escritura
       * @param id Identifier for com.infotec.eworkplace.swb.Escritura
       * @param model Model of the com.infotec.eworkplace.swb.Escritura
       * @return true if the com.infotec.eworkplace.swb.Escritura exists, false otherwise
       */

        public static boolean hasEscritura(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEscritura(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Escritura with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Escritura
       * @return Iterator with all the com.infotec.eworkplace.swb.Escritura
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Escritura> listEscrituraByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Escritura> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Escritura with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Escritura
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Escritura> listEscrituraByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Escritura> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Escritura with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Escritura
       * @return Iterator with all the com.infotec.eworkplace.swb.Escritura
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Escritura> listEscrituraByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Escritura> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Escritura with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Escritura
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Escritura> listEscrituraByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Escritura> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EscrituraBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Escritura
   */
    public EscrituraBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
