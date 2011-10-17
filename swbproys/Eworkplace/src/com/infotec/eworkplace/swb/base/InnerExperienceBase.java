package com.infotec.eworkplace.swb.base;


public abstract class InnerExperienceBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ewp_InnerExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#InnerExperience");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#InnerExperience");

    public static class ClassMgr
    {
       /**
       * Returns a list of InnerExperience for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.InnerExperience
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InnerExperience> listInnerExperiences(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InnerExperience>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.InnerExperience for all models
       * @return Iterator of com.infotec.eworkplace.swb.InnerExperience
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.InnerExperience> listInnerExperiences()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.InnerExperience>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.InnerExperience
       * @param id Identifier for com.infotec.eworkplace.swb.InnerExperience
       * @param model Model of the com.infotec.eworkplace.swb.InnerExperience
       * @return A com.infotec.eworkplace.swb.InnerExperience
       */
        public static com.infotec.eworkplace.swb.InnerExperience getInnerExperience(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.InnerExperience)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.InnerExperience
       * @param id Identifier for com.infotec.eworkplace.swb.InnerExperience
       * @param model Model of the com.infotec.eworkplace.swb.InnerExperience
       * @return A com.infotec.eworkplace.swb.InnerExperience
       */
        public static com.infotec.eworkplace.swb.InnerExperience createInnerExperience(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.InnerExperience)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.InnerExperience
       * @param id Identifier for com.infotec.eworkplace.swb.InnerExperience
       * @param model Model of the com.infotec.eworkplace.swb.InnerExperience
       */
        public static void removeInnerExperience(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.InnerExperience
       * @param id Identifier for com.infotec.eworkplace.swb.InnerExperience
       * @param model Model of the com.infotec.eworkplace.swb.InnerExperience
       * @return true if the com.infotec.eworkplace.swb.InnerExperience exists, false otherwise
       */

        public static boolean hasInnerExperience(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInnerExperience(id, model)!=null);
        }
    }

   /**
   * Constructs a InnerExperienceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the InnerExperience
   */
    public InnerExperienceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

   /**
   * Gets the InfotecIntranet
   * @return a instance of com.infotec.eworkplace.swb.InfotecIntranet
   */
    public com.infotec.eworkplace.swb.InfotecIntranet getInfotecIntranet()
    {
        return (com.infotec.eworkplace.swb.InfotecIntranet)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
