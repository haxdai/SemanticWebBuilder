package com.infotec.cvi.swb.base;


public abstract class SectorExpertiseBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_SectorExpertise=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SectorExpertise");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SectorExpertise");

    public static class ClassMgr
    {
       /**
       * Returns a list of SectorExpertise for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.SectorExpertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SectorExpertise> listSectorExpertises(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SectorExpertise>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.SectorExpertise for all models
       * @return Iterator of com.infotec.cvi.swb.SectorExpertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SectorExpertise> listSectorExpertises()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SectorExpertise>(it, true);
        }

        public static com.infotec.cvi.swb.SectorExpertise createSectorExpertise(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.SectorExpertise.ClassMgr.createSectorExpertise(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.SectorExpertise
       * @param id Identifier for com.infotec.cvi.swb.SectorExpertise
       * @param model Model of the com.infotec.cvi.swb.SectorExpertise
       * @return A com.infotec.cvi.swb.SectorExpertise
       */
        public static com.infotec.cvi.swb.SectorExpertise getSectorExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.SectorExpertise)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.SectorExpertise
       * @param id Identifier for com.infotec.cvi.swb.SectorExpertise
       * @param model Model of the com.infotec.cvi.swb.SectorExpertise
       * @return A com.infotec.cvi.swb.SectorExpertise
       */
        public static com.infotec.cvi.swb.SectorExpertise createSectorExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.SectorExpertise)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.SectorExpertise
       * @param id Identifier for com.infotec.cvi.swb.SectorExpertise
       * @param model Model of the com.infotec.cvi.swb.SectorExpertise
       */
        public static void removeSectorExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.SectorExpertise
       * @param id Identifier for com.infotec.cvi.swb.SectorExpertise
       * @param model Model of the com.infotec.cvi.swb.SectorExpertise
       * @return true if the com.infotec.cvi.swb.SectorExpertise exists, false otherwise
       */

        public static boolean hasSectorExpertise(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSectorExpertise(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.SectorExpertise with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SectorExpertise
       * @return Iterator with all the com.infotec.cvi.swb.SectorExpertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SectorExpertise> listSectorExpertiseByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SectorExpertise> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SectorExpertise with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SectorExpertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SectorExpertise> listSectorExpertiseByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SectorExpertise> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SectorExpertise with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.SectorExpertise
       * @return Iterator with all the com.infotec.cvi.swb.SectorExpertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SectorExpertise> listSectorExpertiseByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SectorExpertise> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.SectorExpertise with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.SectorExpertise
       */

        public static java.util.Iterator<com.infotec.cvi.swb.SectorExpertise> listSectorExpertiseByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.SectorExpertise> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SectorExpertiseBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SectorExpertise
   */
    public SectorExpertiseBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
