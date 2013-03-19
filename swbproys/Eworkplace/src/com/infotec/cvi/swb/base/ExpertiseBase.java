package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para almacenar los tipos de Expertise 
   */
public abstract class ExpertiseBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Catálogo utilizado para almacenar los tipos de Expertise
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Expertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Expertise");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Expertise");

    public static class ClassMgr
    {
       /**
       * Returns a list of Expertise for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Expertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Expertise> listExpertises(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Expertise>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Expertise for all models
       * @return Iterator of com.infotec.cvi.swb.Expertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Expertise> listExpertises()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Expertise>(it, true);
        }

        public static com.infotec.cvi.swb.Expertise createExpertise(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Expertise.ClassMgr.createExpertise(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Expertise
       * @param id Identifier for com.infotec.cvi.swb.Expertise
       * @param model Model of the com.infotec.cvi.swb.Expertise
       * @return A com.infotec.cvi.swb.Expertise
       */
        public static com.infotec.cvi.swb.Expertise getExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Expertise)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Expertise
       * @param id Identifier for com.infotec.cvi.swb.Expertise
       * @param model Model of the com.infotec.cvi.swb.Expertise
       * @return A com.infotec.cvi.swb.Expertise
       */
        public static com.infotec.cvi.swb.Expertise createExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Expertise)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Expertise
       * @param id Identifier for com.infotec.cvi.swb.Expertise
       * @param model Model of the com.infotec.cvi.swb.Expertise
       */
        public static void removeExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Expertise
       * @param id Identifier for com.infotec.cvi.swb.Expertise
       * @param model Model of the com.infotec.cvi.swb.Expertise
       * @return true if the com.infotec.cvi.swb.Expertise exists, false otherwise
       */

        public static boolean hasExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            return (getExpertise(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Expertise with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Expertise
       * @return Iterator with all the com.infotec.cvi.swb.Expertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Expertise> listExpertiseByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Expertise> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Expertise with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Expertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Expertise> listExpertiseByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Expertise> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Expertise with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Expertise
       * @return Iterator with all the com.infotec.cvi.swb.Expertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Expertise> listExpertiseByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Expertise> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Expertise with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Expertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Expertise> listExpertiseByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Expertise> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ExpertiseBase.ClassMgr getExpertiseClassMgr()
    {
        return new ExpertiseBase.ClassMgr();
    }

   /**
   * Constructs a ExpertiseBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Expertise
   */
    public ExpertiseBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
