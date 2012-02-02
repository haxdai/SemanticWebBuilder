package com.infotec.eworkplace.swb.base;


public abstract class CompetenciasDesempenioBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasDesempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasDesempenio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasDesempenio");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompetenciasDesempenio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.CompetenciasDesempenio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> listCompetenciasDesempenios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasDesempenio>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.CompetenciasDesempenio for all models
       * @return Iterator of com.infotec.eworkplace.swb.CompetenciasDesempenio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> listCompetenciasDesempenios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasDesempenio>(it, true);
        }

        public static com.infotec.eworkplace.swb.CompetenciasDesempenio createCompetenciasDesempenio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.CompetenciasDesempenio.ClassMgr.createCompetenciasDesempenio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @return A com.infotec.eworkplace.swb.CompetenciasDesempenio
       */
        public static com.infotec.eworkplace.swb.CompetenciasDesempenio getCompetenciasDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CompetenciasDesempenio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @return A com.infotec.eworkplace.swb.CompetenciasDesempenio
       */
        public static com.infotec.eworkplace.swb.CompetenciasDesempenio createCompetenciasDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CompetenciasDesempenio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasDesempenio
       */
        public static void removeCompetenciasDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @return true if the com.infotec.eworkplace.swb.CompetenciasDesempenio exists, false otherwise
       */

        public static boolean hasCompetenciasDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompetenciasDesempenio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasDesempenio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasDesempenio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> listCompetenciasDesempenioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasDesempenio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasDesempenio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> listCompetenciasDesempenioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasDesempenio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasDesempenio
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasDesempenio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> listCompetenciasDesempenioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasDesempenio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasDesempenio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> listCompetenciasDesempenioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasDesempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompetenciasDesempenioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompetenciasDesempenio
   */
    public CompetenciasDesempenioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
