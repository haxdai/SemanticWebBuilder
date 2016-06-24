package org.semanticwb.bsc.element.base;


   /**
   * Representa un archivo físico utilizado a manera de evidencia sobre la realización de alguna actividad. 
   */
public abstract class DeliverableBase extends org.semanticwb.bsc.element.BSCElement implements org.semanticwb.bsc.Preference,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupRefable,org.semanticwb.bsc.SM,org.semanticwb.bsc.Seasonable,org.semanticwb.bsc.Schedule,org.semanticwb.bsc.Updateable,org.semanticwb.bsc.Detailed,org.semanticwb.model.RuleRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Referensable,org.semanticwb.model.Filterable,org.semanticwb.bsc.Attachmentable,org.semanticwb.bsc.Help,org.semanticwb.model.Searchable,org.semanticwb.model.Activeable,org.semanticwb.model.FilterableNode,org.semanticwb.model.FilterableClass,org.semanticwb.model.RoleRefable
{
   /**
   * Define las características de una Iniciativa
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Initiative=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Initiative");
   /**
   * Indica el objeto Initiative al que se relaciona el objeto Deliverable en consulta
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_hasDeliverableInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasDeliverableInv");
   /**
   * Porcentaje de avance a reportar
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_progress=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#progress");
   /**
   * Un estado define la situación de una medición  en un indicador respecto de las metas de su objetivo.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#State");
   /**
   * Estatus asignado automáticamente por el sistema
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_autoStatus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#autoStatus");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * El usuario responsable del seguimiento al entregable
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_responsible=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#responsible");
   /**
   * Ruta del archivo físico asociado
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_filePath=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#filePath");
   /**
   * Representa un archivo físico utilizado a manera de evidencia sobre la realización de alguna actividad.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Deliverable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Deliverable");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Deliverable");

    public static class ClassMgr
    {
       /**
       * Returns a list of Deliverable for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverables(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.element.Deliverable for all models
       * @return Iterator of org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverables()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable>(it, true);
        }

        public static org.semanticwb.bsc.element.Deliverable createDeliverable(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.element.Deliverable.ClassMgr.createDeliverable(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return A org.semanticwb.bsc.element.Deliverable
       */
        public static org.semanticwb.bsc.element.Deliverable getDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Deliverable)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return A org.semanticwb.bsc.element.Deliverable
       */
        public static org.semanticwb.bsc.element.Deliverable createDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Deliverable)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       */
        public static void removeDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return true if the org.semanticwb.bsc.element.Deliverable exists, false otherwise
       */

        public static boolean hasDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDeliverable(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Priority
       * @param value Priority of the type org.semanticwb.bsc.catalogs.Priority
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByPriority(org.semanticwb.bsc.catalogs.Priority value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_priority, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Priority
       * @param value Priority of the type org.semanticwb.bsc.catalogs.Priority
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByPriority(org.semanticwb.bsc.catalogs.Priority value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_priority,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Period
       * @param value Period of the type org.semanticwb.bsc.accessory.Period
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByPeriod(org.semanticwb.bsc.accessory.Period value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasPeriod, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Period
       * @param value Period of the type org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByPeriod(org.semanticwb.bsc.accessory.Period value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasPeriod,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Recommendation
       * @param value Recommendation of the type org.semanticwb.bsc.catalogs.Recommendation
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByRecommendation(org.semanticwb.bsc.catalogs.Recommendation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasRecommendation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Recommendation
       * @param value Recommendation of the type org.semanticwb.bsc.catalogs.Recommendation
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByRecommendation(org.semanticwb.bsc.catalogs.Recommendation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasRecommendation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Series
       * @param value Series of the type org.semanticwb.bsc.tracing.Series
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableBySeries(org.semanticwb.bsc.tracing.Series value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasSeries, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Series
       * @param value Series of the type org.semanticwb.bsc.tracing.Series
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableBySeries(org.semanticwb.bsc.tracing.Series value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasSeries,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Initiative
       * @param value Initiative of the type org.semanticwb.bsc.element.Initiative
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByInitiative(org.semanticwb.bsc.element.Initiative value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasDeliverableInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Initiative
       * @param value Initiative of the type org.semanticwb.bsc.element.Initiative
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByInitiative(org.semanticwb.bsc.element.Initiative value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasDeliverableInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByAttachments(org.semanticwb.bsc.catalogs.Attachment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByAttachments(org.semanticwb.bsc.catalogs.Attachment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Star
       * @param value Star of the type org.semanticwb.bsc.tracing.Series
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByStar(org.semanticwb.bsc.tracing.Series value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_star, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Star
       * @param value Star of the type org.semanticwb.bsc.tracing.Series
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByStar(org.semanticwb.bsc.tracing.Series value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_star,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined AutoStatus
       * @param value AutoStatus of the type org.semanticwb.bsc.accessory.State
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByAutoStatus(org.semanticwb.bsc.accessory.State value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_autoStatus, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined AutoStatus
       * @param value AutoStatus of the type org.semanticwb.bsc.accessory.State
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByAutoStatus(org.semanticwb.bsc.accessory.State value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_autoStatus,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Analysis
       * @param value Analysis of the type org.semanticwb.bsc.catalogs.Analysis
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByAnalysis(org.semanticwb.bsc.catalogs.Analysis value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAnalysis, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Analysis
       * @param value Analysis of the type org.semanticwb.bsc.catalogs.Analysis
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByAnalysis(org.semanticwb.bsc.catalogs.Analysis value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAnalysis,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Responsible
       * @param value Responsible of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByResponsible(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_responsible, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Responsible
       * @param value Responsible of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByResponsible(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_responsible,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DeliverableBase.ClassMgr getDeliverableClassMgr()
    {
        return new DeliverableBase.ClassMgr();
    }

   /**
   * Constructs a DeliverableBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Deliverable
   */
    public DeliverableBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Priority
   * @param value Priority to set
   */

    public void setPriority(org.semanticwb.bsc.catalogs.Priority value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_priority, value.getSemanticObject());
        }else
        {
            removePriority();
        }
    }
   /**
   * Remove the value for Priority property
   */

    public void removePriority()
    {
        getSemanticObject().removeProperty(bsc_priority);
    }

   /**
   * Gets the Priority
   * @return a org.semanticwb.bsc.catalogs.Priority
   */
    public org.semanticwb.bsc.catalogs.Priority getPriority()
    {
         org.semanticwb.bsc.catalogs.Priority ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_priority);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.catalogs.Priority)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.bsc.accessory.Period
   * @return A GenericIterator with all the org.semanticwb.bsc.accessory.Period
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period> listPeriods()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Period>(getSemanticObject().listObjectProperties(bsc_hasPeriod));
    }

   /**
   * Gets true if has a Period
   * @param value org.semanticwb.bsc.accessory.Period to verify
   * @return true if the org.semanticwb.bsc.accessory.Period exists, false otherwise
   */
    public boolean hasPeriod(org.semanticwb.bsc.accessory.Period value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasPeriod,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Period
   * @param value org.semanticwb.bsc.accessory.Period to add
   */

    public void addPeriod(org.semanticwb.bsc.accessory.Period value)
    {
        getSemanticObject().addObjectProperty(bsc_hasPeriod, value.getSemanticObject());
    }
   /**
   * Removes all the Period
   */

    public void removeAllPeriod()
    {
        getSemanticObject().removeProperty(bsc_hasPeriod);
    }
   /**
   * Removes a Period
   * @param value org.semanticwb.bsc.accessory.Period to remove
   */

    public void removePeriod(org.semanticwb.bsc.accessory.Period value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasPeriod,value.getSemanticObject());
    }

   /**
   * Gets the Period
   * @return a org.semanticwb.bsc.accessory.Period
   */
    public org.semanticwb.bsc.accessory.Period getPeriod()
    {
         org.semanticwb.bsc.accessory.Period ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasPeriod);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.accessory.Period)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.bsc.catalogs.Recommendation
   * @return A GenericIterator with all the org.semanticwb.bsc.catalogs.Recommendation
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation> listRecommendations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Recommendation>(getSemanticObject().listObjectProperties(bsc_hasRecommendation));
    }

   /**
   * Gets true if has a Recommendation
   * @param value org.semanticwb.bsc.catalogs.Recommendation to verify
   * @return true if the org.semanticwb.bsc.catalogs.Recommendation exists, false otherwise
   */
    public boolean hasRecommendation(org.semanticwb.bsc.catalogs.Recommendation value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasRecommendation,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Recommendation
   * @param value org.semanticwb.bsc.catalogs.Recommendation to add
   */

    public void addRecommendation(org.semanticwb.bsc.catalogs.Recommendation value)
    {
        getSemanticObject().addObjectProperty(bsc_hasRecommendation, value.getSemanticObject());
    }
   /**
   * Removes all the Recommendation
   */

    public void removeAllRecommendation()
    {
        getSemanticObject().removeProperty(bsc_hasRecommendation);
    }
   /**
   * Removes a Recommendation
   * @param value org.semanticwb.bsc.catalogs.Recommendation to remove
   */

    public void removeRecommendation(org.semanticwb.bsc.catalogs.Recommendation value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasRecommendation,value.getSemanticObject());
    }

   /**
   * Gets the Recommendation
   * @return a org.semanticwb.bsc.catalogs.Recommendation
   */
    public org.semanticwb.bsc.catalogs.Recommendation getRecommendation()
    {
         org.semanticwb.bsc.catalogs.Recommendation ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasRecommendation);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.catalogs.Recommendation)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ActualStart property
* @return java.util.Date with the ActualStart
*/
    public java.util.Date getActualStart()
    {
        return getSemanticObject().getDateProperty(bsc_actualStart);
    }

/**
* Sets the ActualStart property
* @param value long with the ActualStart
*/
    public void setActualStart(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_actualStart, value);
    }
   /**
   * Gets all the org.semanticwb.bsc.tracing.Series
   * @return A GenericIterator with all the org.semanticwb.bsc.tracing.Series
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.tracing.Series> listSerieses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.tracing.Series>(getSemanticObject().listObjectProperties(bsc_hasSeries));
    }

   /**
   * Gets true if has a Series
   * @param value org.semanticwb.bsc.tracing.Series to verify
   * @return true if the org.semanticwb.bsc.tracing.Series exists, false otherwise
   */
    public boolean hasSeries(org.semanticwb.bsc.tracing.Series value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasSeries,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Series
   * @param value org.semanticwb.bsc.tracing.Series to add
   */

    public void addSeries(org.semanticwb.bsc.tracing.Series value)
    {
        getSemanticObject().addObjectProperty(bsc_hasSeries, value.getSemanticObject());
    }
   /**
   * Removes all the Series
   */

    public void removeAllSeries()
    {
        getSemanticObject().removeProperty(bsc_hasSeries);
    }
   /**
   * Removes a Series
   * @param value org.semanticwb.bsc.tracing.Series to remove
   */

    public void removeSeries(org.semanticwb.bsc.tracing.Series value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasSeries,value.getSemanticObject());
    }

   /**
   * Gets the Series
   * @return a org.semanticwb.bsc.tracing.Series
   */
    public org.semanticwb.bsc.tracing.Series getSeries()
    {
         org.semanticwb.bsc.tracing.Series ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasSeries);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.tracing.Series)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Initiative
   * @param value Initiative to set
   */

    public void setInitiative(org.semanticwb.bsc.element.Initiative value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_hasDeliverableInv, value.getSemanticObject());
        }else
        {
            removeInitiative();
        }
    }
   /**
   * Remove the value for Initiative property
   */

    public void removeInitiative()
    {
        getSemanticObject().removeProperty(bsc_hasDeliverableInv);
    }

   /**
   * Gets the Initiative
   * @return a org.semanticwb.bsc.element.Initiative
   */
    public org.semanticwb.bsc.element.Initiative getInitiative()
    {
         org.semanticwb.bsc.element.Initiative ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasDeliverableInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.element.Initiative)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Star
   * @param value Star to set
   */

    public void setStar(org.semanticwb.bsc.tracing.Series value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_star, value.getSemanticObject());
        }else
        {
            removeStar();
        }
    }
   /**
   * Remove the value for Star property
   */

    public void removeStar()
    {
        getSemanticObject().removeProperty(bsc_star);
    }

   /**
   * Gets the Star
   * @return a org.semanticwb.bsc.tracing.Series
   */
    public org.semanticwb.bsc.tracing.Series getStar()
    {
         org.semanticwb.bsc.tracing.Series ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_star);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.tracing.Series)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Progress property
* @return float with the Progress
*/
    public float getProgress()
    {
        return getSemanticObject().getFloatProperty(bsc_progress);
    }

/**
* Sets the Progress property
* @param value long with the Progress
*/
    public void setProgress(float value)
    {
        getSemanticObject().setFloatProperty(bsc_progress, value);
    }

/**
* Gets the PlannedStart property
* @return java.util.Date with the PlannedStart
*/
    public java.util.Date getPlannedStart()
    {
        return getSemanticObject().getDateProperty(bsc_plannedStart);
    }

/**
* Sets the PlannedStart property
* @param value long with the PlannedStart
*/
    public void setPlannedStart(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_plannedStart, value);
    }
   /**
   * Sets the value for the property AutoStatus
   * @param value AutoStatus to set
   */

    public void setAutoStatus(org.semanticwb.bsc.accessory.State value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_autoStatus, value.getSemanticObject());
        }else
        {
            removeAutoStatus();
        }
    }
   /**
   * Remove the value for AutoStatus property
   */

    public void removeAutoStatus()
    {
        getSemanticObject().removeProperty(bsc_autoStatus);
    }

   /**
   * Gets the AutoStatus
   * @return a org.semanticwb.bsc.accessory.State
   */
    public org.semanticwb.bsc.accessory.State getAutoStatus()
    {
         org.semanticwb.bsc.accessory.State ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_autoStatus);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.accessory.State)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PlannedEnd property
* @return java.util.Date with the PlannedEnd
*/
    public java.util.Date getPlannedEnd()
    {
        return getSemanticObject().getDateProperty(bsc_plannedEnd);
    }

/**
* Sets the PlannedEnd property
* @param value long with the PlannedEnd
*/
    public void setPlannedEnd(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_plannedEnd, value);
    }
   /**
   * Gets all the org.semanticwb.bsc.catalogs.Analysis
   * @return A GenericIterator with all the org.semanticwb.bsc.catalogs.Analysis
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis> listAnalysises()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Analysis>(getSemanticObject().listObjectProperties(bsc_hasAnalysis));
    }

   /**
   * Gets true if has a Analysis
   * @param value org.semanticwb.bsc.catalogs.Analysis to verify
   * @return true if the org.semanticwb.bsc.catalogs.Analysis exists, false otherwise
   */
    public boolean hasAnalysis(org.semanticwb.bsc.catalogs.Analysis value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasAnalysis,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Analysis
   * @param value org.semanticwb.bsc.catalogs.Analysis to add
   */

    public void addAnalysis(org.semanticwb.bsc.catalogs.Analysis value)
    {
        getSemanticObject().addObjectProperty(bsc_hasAnalysis, value.getSemanticObject());
    }
   /**
   * Removes all the Analysis
   */

    public void removeAllAnalysis()
    {
        getSemanticObject().removeProperty(bsc_hasAnalysis);
    }
   /**
   * Removes a Analysis
   * @param value org.semanticwb.bsc.catalogs.Analysis to remove
   */

    public void removeAnalysis(org.semanticwb.bsc.catalogs.Analysis value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasAnalysis,value.getSemanticObject());
    }

   /**
   * Gets the Analysis
   * @return a org.semanticwb.bsc.catalogs.Analysis
   */
    public org.semanticwb.bsc.catalogs.Analysis getAnalysis()
    {
         org.semanticwb.bsc.catalogs.Analysis ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasAnalysis);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.catalogs.Analysis)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Responsible
   * @param value Responsible to set
   */

    public void setResponsible(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_responsible, value.getSemanticObject());
        }else
        {
            removeResponsible();
        }
    }
   /**
   * Remove the value for Responsible property
   */

    public void removeResponsible()
    {
        getSemanticObject().removeProperty(bsc_responsible);
    }

   /**
   * Gets the Responsible
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getResponsible()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_responsible);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FilePath property
* @return String with the FilePath
*/
    public String getFilePath()
    {
        return getSemanticObject().getProperty(bsc_filePath);
    }

/**
* Sets the FilePath property
* @param value long with the FilePath
*/
    public void setFilePath(String value)
    {
        getSemanticObject().setProperty(bsc_filePath, value);
    }

/**
* Gets the ActualEnd property
* @return java.util.Date with the ActualEnd
*/
    public java.util.Date getActualEnd()
    {
        return getSemanticObject().getDateProperty(bsc_actualEnd);
    }

/**
* Sets the ActualEnd property
* @param value long with the ActualEnd
*/
    public void setActualEnd(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_actualEnd, value);
    }
}
