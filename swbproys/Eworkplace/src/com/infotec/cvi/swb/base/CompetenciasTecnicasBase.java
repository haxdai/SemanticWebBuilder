package com.infotec.cvi.swb.base;


public abstract class CompetenciasTecnicasBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasTecnicas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasTecnicas");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasTecnicas");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompetenciasTecnicas for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.CompetenciasTecnicas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasTecnicas> listCompetenciasTecnicases(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasTecnicas>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.CompetenciasTecnicas for all models
       * @return Iterator of com.infotec.cvi.swb.CompetenciasTecnicas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasTecnicas> listCompetenciasTecnicases()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasTecnicas>(it, true);
        }

        public static com.infotec.cvi.swb.CompetenciasTecnicas createCompetenciasTecnicas(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.CompetenciasTecnicas.ClassMgr.createCompetenciasTecnicas(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.CompetenciasTecnicas
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasTecnicas
       * @param model Model of the com.infotec.cvi.swb.CompetenciasTecnicas
       * @return A com.infotec.cvi.swb.CompetenciasTecnicas
       */
        public static com.infotec.cvi.swb.CompetenciasTecnicas getCompetenciasTecnicas(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CompetenciasTecnicas)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.CompetenciasTecnicas
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasTecnicas
       * @param model Model of the com.infotec.cvi.swb.CompetenciasTecnicas
       * @return A com.infotec.cvi.swb.CompetenciasTecnicas
       */
        public static com.infotec.cvi.swb.CompetenciasTecnicas createCompetenciasTecnicas(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.CompetenciasTecnicas)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.CompetenciasTecnicas
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasTecnicas
       * @param model Model of the com.infotec.cvi.swb.CompetenciasTecnicas
       */
        public static void removeCompetenciasTecnicas(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.CompetenciasTecnicas
       * @param id Identifier for com.infotec.cvi.swb.CompetenciasTecnicas
       * @param model Model of the com.infotec.cvi.swb.CompetenciasTecnicas
       * @return true if the com.infotec.cvi.swb.CompetenciasTecnicas exists, false otherwise
       */

        public static boolean hasCompetenciasTecnicas(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompetenciasTecnicas(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasTecnicas with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CompetenciasTecnicas
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasTecnicas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasTecnicas> listCompetenciasTecnicasByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasTecnicas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasTecnicas with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasTecnicas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasTecnicas> listCompetenciasTecnicasByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasTecnicas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasTecnicas with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.CompetenciasTecnicas
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasTecnicas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasTecnicas> listCompetenciasTecnicasByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasTecnicas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.CompetenciasTecnicas with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.CompetenciasTecnicas
       */

        public static java.util.Iterator<com.infotec.cvi.swb.CompetenciasTecnicas> listCompetenciasTecnicasByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.CompetenciasTecnicas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompetenciasTecnicasBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompetenciasTecnicas
   */
    public CompetenciasTecnicasBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
