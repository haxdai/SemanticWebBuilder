package com.infotec.eworkplace.swb.base;


public abstract class AcademiaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Academia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Academia for all models
       * @return Iterator of com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia>(it, true);
        }

        public static com.infotec.eworkplace.swb.Academia createAcademia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Academia.ClassMgr.createAcademia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return A com.infotec.eworkplace.swb.Academia
       */
        public static com.infotec.eworkplace.swb.Academia getAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Academia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return A com.infotec.eworkplace.swb.Academia
       */
        public static com.infotec.eworkplace.swb.Academia createAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Academia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       */
        public static void removeAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return true if the com.infotec.eworkplace.swb.Academia exists, false otherwise
       */

        public static boolean hasAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAcademia(id, model)!=null);
        }
    }

   /**
   * Constructs a AcademiaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Academia
   */
    public AcademiaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
