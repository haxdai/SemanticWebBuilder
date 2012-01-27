package com.infotec.eworkplace.swb.base;


public abstract class EstudiosBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Estudios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estudios");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estudios");

    public static class ClassMgr
    {
       /**
       * Returns a list of Estudios for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Estudios> listEstudioses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Estudios>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Estudios for all models
       * @return Iterator of com.infotec.eworkplace.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Estudios> listEstudioses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Estudios>(it, true);
        }

        public static com.infotec.eworkplace.swb.Estudios createEstudios(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Estudios.ClassMgr.createEstudios(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Estudios
       * @param id Identifier for com.infotec.eworkplace.swb.Estudios
       * @param model Model of the com.infotec.eworkplace.swb.Estudios
       * @return A com.infotec.eworkplace.swb.Estudios
       */
        public static com.infotec.eworkplace.swb.Estudios getEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Estudios)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Estudios
       * @param id Identifier for com.infotec.eworkplace.swb.Estudios
       * @param model Model of the com.infotec.eworkplace.swb.Estudios
       * @return A com.infotec.eworkplace.swb.Estudios
       */
        public static com.infotec.eworkplace.swb.Estudios createEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Estudios)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Estudios
       * @param id Identifier for com.infotec.eworkplace.swb.Estudios
       * @param model Model of the com.infotec.eworkplace.swb.Estudios
       */
        public static void removeEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Estudios
       * @param id Identifier for com.infotec.eworkplace.swb.Estudios
       * @param model Model of the com.infotec.eworkplace.swb.Estudios
       * @return true if the com.infotec.eworkplace.swb.Estudios exists, false otherwise
       */

        public static boolean hasEstudios(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEstudios(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Estudios with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Estudios
       * @return Iterator with all the com.infotec.eworkplace.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Estudios> listEstudiosByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Estudios> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Estudios with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Estudios> listEstudiosByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Estudios> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Estudios with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Estudios
       * @return Iterator with all the com.infotec.eworkplace.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Estudios> listEstudiosByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Estudios> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Estudios with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Estudios
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Estudios> listEstudiosByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Estudios> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EstudiosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Estudios
   */
    public EstudiosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
