package com.infotec.eworkplace.swb.base;


public abstract class CompetenciasComportamientoBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_CompetenciasComportamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasComportamiento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CompetenciasComportamiento");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompetenciasComportamiento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.CompetenciasComportamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> listCompetenciasComportamientos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasComportamiento>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.CompetenciasComportamiento for all models
       * @return Iterator of com.infotec.eworkplace.swb.CompetenciasComportamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> listCompetenciasComportamientos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasComportamiento>(it, true);
        }

        public static com.infotec.eworkplace.swb.CompetenciasComportamiento createCompetenciasComportamiento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.CompetenciasComportamiento.ClassMgr.createCompetenciasComportamiento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @return A com.infotec.eworkplace.swb.CompetenciasComportamiento
       */
        public static com.infotec.eworkplace.swb.CompetenciasComportamiento getCompetenciasComportamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CompetenciasComportamiento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @return A com.infotec.eworkplace.swb.CompetenciasComportamiento
       */
        public static com.infotec.eworkplace.swb.CompetenciasComportamiento createCompetenciasComportamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CompetenciasComportamiento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasComportamiento
       */
        public static void removeCompetenciasComportamiento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param id Identifier for com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @return true if the com.infotec.eworkplace.swb.CompetenciasComportamiento exists, false otherwise
       */

        public static boolean hasCompetenciasComportamiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompetenciasComportamiento(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasComportamiento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasComportamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> listCompetenciasComportamientoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasComportamiento with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasComportamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> listCompetenciasComportamientoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasComportamiento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CompetenciasComportamiento
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasComportamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> listCompetenciasComportamientoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CompetenciasComportamiento with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CompetenciasComportamiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> listCompetenciasComportamientoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CompetenciasComportamiento> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompetenciasComportamientoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompetenciasComportamiento
   */
    public CompetenciasComportamientoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
