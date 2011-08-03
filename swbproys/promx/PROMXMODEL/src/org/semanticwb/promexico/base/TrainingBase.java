package org.semanticwb.promexico.base;


public abstract class TrainingBase extends org.semanticwb.promexico.Event implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Localeable,org.semanticwb.model.Resourceable,org.semanticwb.model.Traceable,org.semanticwb.model.Ruleable,org.semanticwb.model.Searchable,org.semanticwb.model.Tagable
{
    public static final org.semanticwb.platform.SemanticClass promx_Training=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Training");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Training");

    public static class ClassMgr
    {
       /**
       * Returns a list of Training for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainings(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Training for all models
       * @return Iterator of org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainings()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       * @return A org.semanticwb.promexico.Training
       */
        public static org.semanticwb.promexico.Training getTraining(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Training)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       * @return A org.semanticwb.promexico.Training
       */
        public static org.semanticwb.promexico.Training createTraining(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Training)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       */
        public static void removeTraining(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Training
       * @param id Identifier for org.semanticwb.promexico.Training
       * @param model Model of the org.semanticwb.promexico.Training
       * @return true if the org.semanticwb.promexico.Training exists, false otherwise
       */

        public static boolean hasTraining(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTraining(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Office
       * @param value Office of the type org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByOffice(org.semanticwb.promexico.Office value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasOffice, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Office
       * @param value Office of the type org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByOffice(org.semanticwb.promexico.Office value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasOffice,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Sectores
       * @param value Sectores of the type org.semanticwb.promexico.Sector
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingBySectores(org.semanticwb.promexico.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasSectores, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Sectores
       * @param value Sectores of the type org.semanticwb.promexico.Sector
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingBySectores(org.semanticwb.promexico.Sector value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasSectores,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined EvType
       * @param value EvType of the type org.semanticwb.portal.resources.sem.genericCalendar.EventType
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByEvType(org.semanticwb.portal.resources.sem.genericCalendar.EventType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(genCal_evType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined EvType
       * @param value EvType of the type org.semanticwb.portal.resources.sem.genericCalendar.EventType
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByEvType(org.semanticwb.portal.resources.sem.genericCalendar.EventType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(genCal_evType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByRule(org.semanticwb.model.Rule value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Rule
       * @param value Rule of the type org.semanticwb.model.Rule
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByRule(org.semanticwb.model.Rule value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRule,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined EvSubType
       * @param value EvSubType of the type org.semanticwb.promexico.EventSubType
       * @param model Model of the org.semanticwb.promexico.Training
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByEvSubType(org.semanticwb.promexico.EventSubType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_evSubType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Training with a determined EvSubType
       * @param value EvSubType of the type org.semanticwb.promexico.EventSubType
       * @return Iterator with all the org.semanticwb.promexico.Training
       */

        public static java.util.Iterator<org.semanticwb.promexico.Training> listTrainingByEvSubType(org.semanticwb.promexico.EventSubType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Training> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_evSubType,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a TrainingBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Training
   */
    public TrainingBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
