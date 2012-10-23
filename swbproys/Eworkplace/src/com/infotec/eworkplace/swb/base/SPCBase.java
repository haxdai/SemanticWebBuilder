package com.infotec.eworkplace.swb.base;


public abstract class SPCBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_SPC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SPC");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SPC");

    public static class ClassMgr
    {
       /**
       * Returns a list of SPC for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SPC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SPC> listSPCs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SPC>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SPC for all models
       * @return Iterator of com.infotec.eworkplace.swb.SPC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SPC> listSPCs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SPC>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SPC
       * @param id Identifier for com.infotec.eworkplace.swb.SPC
       * @param model Model of the com.infotec.eworkplace.swb.SPC
       * @return A com.infotec.eworkplace.swb.SPC
       */
        public static com.infotec.eworkplace.swb.SPC getSPC(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SPC)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SPC
       * @param id Identifier for com.infotec.eworkplace.swb.SPC
       * @param model Model of the com.infotec.eworkplace.swb.SPC
       * @return A com.infotec.eworkplace.swb.SPC
       */
        public static com.infotec.eworkplace.swb.SPC createSPC(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SPC)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SPC
       * @param id Identifier for com.infotec.eworkplace.swb.SPC
       * @param model Model of the com.infotec.eworkplace.swb.SPC
       */
        public static void removeSPC(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SPC
       * @param id Identifier for com.infotec.eworkplace.swb.SPC
       * @param model Model of the com.infotec.eworkplace.swb.SPC
       * @return true if the com.infotec.eworkplace.swb.SPC exists, false otherwise
       */

        public static boolean hasSPC(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSPC(id, model)!=null);
        }
    }

    public static SPCBase.ClassMgr getSPCClassMgr()
    {
        return new SPCBase.ClassMgr();
    }

   /**
   * Constructs a SPCBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SPC
   */
    public SPCBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
