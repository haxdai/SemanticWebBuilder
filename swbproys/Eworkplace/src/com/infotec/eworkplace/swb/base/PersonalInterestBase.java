package com.infotec.eworkplace.swb.base;


public abstract class PersonalInterestBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ewp_PersonalInterest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#PersonalInterest");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#PersonalInterest");

    public static class ClassMgr
    {
       /**
       * Returns a list of PersonalInterest for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.PersonalInterest
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.PersonalInterest> listPersonalInterests(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.PersonalInterest>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.PersonalInterest for all models
       * @return Iterator of com.infotec.eworkplace.swb.PersonalInterest
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.PersonalInterest> listPersonalInterests()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.PersonalInterest>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.PersonalInterest
       * @param id Identifier for com.infotec.eworkplace.swb.PersonalInterest
       * @param model Model of the com.infotec.eworkplace.swb.PersonalInterest
       * @return A com.infotec.eworkplace.swb.PersonalInterest
       */
        public static com.infotec.eworkplace.swb.PersonalInterest getPersonalInterest(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.PersonalInterest)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.PersonalInterest
       * @param id Identifier for com.infotec.eworkplace.swb.PersonalInterest
       * @param model Model of the com.infotec.eworkplace.swb.PersonalInterest
       * @return A com.infotec.eworkplace.swb.PersonalInterest
       */
        public static com.infotec.eworkplace.swb.PersonalInterest createPersonalInterest(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.PersonalInterest)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.PersonalInterest
       * @param id Identifier for com.infotec.eworkplace.swb.PersonalInterest
       * @param model Model of the com.infotec.eworkplace.swb.PersonalInterest
       */
        public static void removePersonalInterest(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.PersonalInterest
       * @param id Identifier for com.infotec.eworkplace.swb.PersonalInterest
       * @param model Model of the com.infotec.eworkplace.swb.PersonalInterest
       * @return true if the com.infotec.eworkplace.swb.PersonalInterest exists, false otherwise
       */

        public static boolean hasPersonalInterest(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPersonalInterest(id, model)!=null);
        }
    }

   /**
   * Constructs a PersonalInterestBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PersonalInterest
   */
    public PersonalInterestBase(org.semanticwb.platform.SemanticObject base)
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
