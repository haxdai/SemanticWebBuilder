package com.infotec.eworkplace.swb.base;


public abstract class GradoBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Grado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Grado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Grado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Grado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Grado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Grado> listGrados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Grado>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Grado for all models
       * @return Iterator of com.infotec.eworkplace.swb.Grado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Grado> listGrados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Grado>(it, true);
        }

        public static com.infotec.eworkplace.swb.Grado createGrado(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Grado.ClassMgr.createGrado(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Grado
       * @param id Identifier for com.infotec.eworkplace.swb.Grado
       * @param model Model of the com.infotec.eworkplace.swb.Grado
       * @return A com.infotec.eworkplace.swb.Grado
       */
        public static com.infotec.eworkplace.swb.Grado getGrado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Grado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Grado
       * @param id Identifier for com.infotec.eworkplace.swb.Grado
       * @param model Model of the com.infotec.eworkplace.swb.Grado
       * @return A com.infotec.eworkplace.swb.Grado
       */
        public static com.infotec.eworkplace.swb.Grado createGrado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Grado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Grado
       * @param id Identifier for com.infotec.eworkplace.swb.Grado
       * @param model Model of the com.infotec.eworkplace.swb.Grado
       */
        public static void removeGrado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Grado
       * @param id Identifier for com.infotec.eworkplace.swb.Grado
       * @param model Model of the com.infotec.eworkplace.swb.Grado
       * @return true if the com.infotec.eworkplace.swb.Grado exists, false otherwise
       */

        public static boolean hasGrado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGrado(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Grado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Grado
       * @return Iterator with all the com.infotec.eworkplace.swb.Grado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Grado> listGradoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Grado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Grado with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Grado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Grado> listGradoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Grado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Grado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Grado
       * @return Iterator with all the com.infotec.eworkplace.swb.Grado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Grado> listGradoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Grado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Grado with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Grado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Grado> listGradoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Grado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GradoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Grado
   */
    public GradoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
