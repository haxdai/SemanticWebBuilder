package org.semanticwb.bsc.element.base;


   /**
   * Define las características de un Indicador. 
   */
public abstract class IndicatorBase extends org.semanticwb.bsc.element.BSCElement implements org.semanticwb.model.Roleable,org.semanticwb.model.Undeleteable,org.semanticwb.bsc.FixedMeasurable,org.semanticwb.bsc.SM,org.semanticwb.model.Descriptiveable,org.semanticwb.bsc.Seasonable,org.semanticwb.bsc.InitiativeAssignable,org.semanticwb.model.Filterable,org.semanticwb.model.Traceable,org.semanticwb.bsc.Updateable,org.semanticwb.model.Referensable,org.semanticwb.bsc.Help,org.semanticwb.bsc.Attachmentable,org.semanticwb.model.Trashable,org.semanticwb.bsc.Recognizable,org.semanticwb.bsc.Serializable,org.semanticwb.bsc.Committable,org.semanticwb.model.FilterableNode,org.semanticwb.model.UserGroupable,org.semanticwb.model.Activeable,org.semanticwb.model.RuleRefable,org.semanticwb.model.FilterableClass,org.semanticwb.bsc.Detailed
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * Usuario que se asigna como responsable de conseguir el objetivo
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_champion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#champion");
   /**
   * Persiste la unidad de medida de un indicador
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_unitMesure=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#unitMesure");
   /**
   * Define las características de un Objetivo estratégico.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Objective=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Objective");
   /**
   * Indica el objeto Objective al que está relacionado el objeto Indicator en cuestión
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_objectiveInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#objectiveInv");
   /**
   * Persiste información de una nota a la fórmula de un indicador
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_notesFormula=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#notesFormula");
   /**
   * Persiste una fuente de información de un indicador
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_informationSource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#informationSource");
   /**
   * Persiste información de la descripción de metas en un indicador
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_goals=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#goals");
    public static final org.semanticwb.platform.SemanticClass bsc_Grapher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Grapher");
    public static final org.semanticwb.platform.SemanticProperty bsc_hasGrapher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasGrapher");
   /**
   * Persiste información de una fórmula para el cálculo de un indicador
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_formula=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#formula");
   /**
   * Define las características de un Indicador.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Indicator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Indicator");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Indicator");

    public static class ClassMgr
    {
       /**
       * Returns a list of Indicator for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicators(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.element.Indicator for all models
       * @return Iterator of org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicators()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator>(it, true);
        }

        public static org.semanticwb.bsc.element.Indicator createIndicator(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.element.Indicator.ClassMgr.createIndicator(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.element.Indicator
       * @param id Identifier for org.semanticwb.bsc.element.Indicator
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return A org.semanticwb.bsc.element.Indicator
       */
        public static org.semanticwb.bsc.element.Indicator getIndicator(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Indicator)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.element.Indicator
       * @param id Identifier for org.semanticwb.bsc.element.Indicator
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return A org.semanticwb.bsc.element.Indicator
       */
        public static org.semanticwb.bsc.element.Indicator createIndicator(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Indicator)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.element.Indicator
       * @param id Identifier for org.semanticwb.bsc.element.Indicator
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       */
        public static void removeIndicator(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.element.Indicator
       * @param id Identifier for org.semanticwb.bsc.element.Indicator
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return true if the org.semanticwb.bsc.element.Indicator exists, false otherwise
       */

        public static boolean hasIndicator(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIndicator(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Period
       * @param value Period of the type org.semanticwb.bsc.accessory.Period
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByPeriod(org.semanticwb.bsc.accessory.Period value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasPeriod, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Period
       * @param value Period of the type org.semanticwb.bsc.accessory.Period
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByPeriod(org.semanticwb.bsc.accessory.Period value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasPeriod,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Initiative
       * @param value Initiative of the type org.semanticwb.bsc.element.Initiative
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByInitiative(org.semanticwb.bsc.element.Initiative value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasInitiative, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Initiative
       * @param value Initiative of the type org.semanticwb.bsc.element.Initiative
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByInitiative(org.semanticwb.bsc.element.Initiative value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasInitiative,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Champion
       * @param value Champion of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByChampion(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_champion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Champion
       * @param value Champion of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByChampion(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_champion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByAttachments(org.semanticwb.bsc.catalogs.Attachment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByAttachments(org.semanticwb.bsc.catalogs.Attachment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByUserGroup(org.semanticwb.model.UserGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByUserGroup(org.semanticwb.model.UserGroup value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Objective
       * @param value Objective of the type org.semanticwb.bsc.element.Objective
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByObjective(org.semanticwb.bsc.element.Objective value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_objectiveInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Objective
       * @param value Objective of the type org.semanticwb.bsc.element.Objective
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByObjective(org.semanticwb.bsc.element.Objective value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_objectiveInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByRole(org.semanticwb.model.Role value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByRole(org.semanticwb.model.Role value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Star
       * @param value Star of the type org.semanticwb.bsc.tracing.Series
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByStar(org.semanticwb.bsc.tracing.Series value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_star, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Star
       * @param value Star of the type org.semanticwb.bsc.tracing.Series
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByStar(org.semanticwb.bsc.tracing.Series value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_star,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Series
       * @param value Series of the type org.semanticwb.bsc.tracing.Series
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorBySeries(org.semanticwb.bsc.tracing.Series value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasSeries, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Series
       * @param value Series of the type org.semanticwb.bsc.tracing.Series
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorBySeries(org.semanticwb.bsc.tracing.Series value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasSeries,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Grapher
       * @param value Grapher of the type org.semanticwb.bsc.accessory.Grapher
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByGrapher(org.semanticwb.bsc.accessory.Grapher value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasGrapher, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Grapher
       * @param value Grapher of the type org.semanticwb.bsc.accessory.Grapher
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByGrapher(org.semanticwb.bsc.accessory.Grapher value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasGrapher,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Periodicity
       * @param value Periodicity of the type org.semanticwb.bsc.tracing.MeasurementFrequency
       * @param model Model of the org.semanticwb.bsc.element.Indicator
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByPeriodicity(org.semanticwb.bsc.tracing.MeasurementFrequency value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_periodicity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Indicator with a determined Periodicity
       * @param value Periodicity of the type org.semanticwb.bsc.tracing.MeasurementFrequency
       * @return Iterator with all the org.semanticwb.bsc.element.Indicator
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Indicator> listIndicatorByPeriodicity(org.semanticwb.bsc.tracing.MeasurementFrequency value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Indicator> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_periodicity,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static IndicatorBase.ClassMgr getIndicatorClassMgr()
    {
        return new IndicatorBase.ClassMgr();
    }

   /**
   * Constructs a IndicatorBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Indicator
   */
    public IndicatorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Gets all the org.semanticwb.bsc.element.Initiative
   * @return A GenericIterator with all the org.semanticwb.bsc.element.Initiative
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative> listInitiatives()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Initiative>(getSemanticObject().listObjectProperties(bsc_hasInitiative));
    }

   /**
   * Gets true if has a Initiative
   * @param value org.semanticwb.bsc.element.Initiative to verify
   * @return true if the org.semanticwb.bsc.element.Initiative exists, false otherwise
   */
    public boolean hasInitiative(org.semanticwb.bsc.element.Initiative value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasInitiative,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Initiative
   * @param value org.semanticwb.bsc.element.Initiative to add
   */

    public void addInitiative(org.semanticwb.bsc.element.Initiative value)
    {
        getSemanticObject().addObjectProperty(bsc_hasInitiative, value.getSemanticObject());
    }
   /**
   * Removes all the Initiative
   */

    public void removeAllInitiative()
    {
        getSemanticObject().removeProperty(bsc_hasInitiative);
    }
   /**
   * Removes a Initiative
   * @param value org.semanticwb.bsc.element.Initiative to remove
   */

    public void removeInitiative(org.semanticwb.bsc.element.Initiative value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasInitiative,value.getSemanticObject());
    }

   /**
   * Gets the Initiative
   * @return a org.semanticwb.bsc.element.Initiative
   */
    public org.semanticwb.bsc.element.Initiative getInitiative()
    {
         org.semanticwb.bsc.element.Initiative ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasInitiative);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.element.Initiative)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Champion
   * @param value Champion to set
   */

    public void setChampion(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_champion, value.getSemanticObject());
        }else
        {
            removeChampion();
        }
    }
   /**
   * Remove the value for Champion property
   */

    public void removeChampion()
    {
        getSemanticObject().removeProperty(bsc_champion);
    }

   /**
   * Gets the Champion
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getChampion()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_champion);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the UnitMesure property
* @return String with the UnitMesure
*/
    public String getUnitMesure()
    {
        return getSemanticObject().getProperty(bsc_unitMesure);
    }

/**
* Sets the UnitMesure property
* @param value long with the UnitMesure
*/
    public void setUnitMesure(String value)
    {
        getSemanticObject().setProperty(bsc_unitMesure, value);
    }

/**
* Gets the Prefix property
* @return String with the Prefix
*/
    public String getPrefix()
    {
        //Override this method in Indicator object
        return getSemanticObject().getProperty(bsc_prefix,false);
    }

/**
* Sets the Prefix property
* @param value long with the Prefix
*/
    public void setPrefix(String value)
    {
        //Override this method in Indicator object
        getSemanticObject().setProperty(bsc_prefix, value,false);
    }

/**
* Gets the Recommendations property
* @return String with the Recommendations
*/
    public String getRecommendations()
    {
        return getSemanticObject().getProperty(bsc_recommendations);
    }

/**
* Sets the Recommendations property
* @param value long with the Recommendations
*/
    public void setRecommendations(String value)
    {
        getSemanticObject().setProperty(bsc_recommendations, value);
    }
   /**
   * Sets the value for the property Objective
   * @param value Objective to set
   */

    public void setObjective(org.semanticwb.bsc.element.Objective value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_objectiveInv, value.getSemanticObject());
        }else
        {
            removeObjective();
        }
    }
   /**
   * Remove the value for Objective property
   */

    public void removeObjective()
    {
        getSemanticObject().removeProperty(bsc_objectiveInv);
    }

   /**
   * Gets the Objective
   * @return a org.semanticwb.bsc.element.Objective
   */
    public org.semanticwb.bsc.element.Objective getObjective()
    {
         org.semanticwb.bsc.element.Objective ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_objectiveInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.element.Objective)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Analysis property
* @return String with the Analysis
*/
    public String getAnalysis()
    {
        return getSemanticObject().getProperty(bsc_analysis);
    }

/**
* Sets the Analysis property
* @param value long with the Analysis
*/
    public void setAnalysis(String value)
    {
        getSemanticObject().setProperty(bsc_analysis, value);
    }

/**
* Gets the NotesFormula property
* @return String with the NotesFormula
*/
    public String getNotesFormula()
    {
        return getSemanticObject().getProperty(bsc_notesFormula);
    }

/**
* Sets the NotesFormula property
* @param value long with the NotesFormula
*/
    public void setNotesFormula(String value)
    {
        getSemanticObject().setProperty(bsc_notesFormula, value);
    }

/**
* Gets the Commited property
* @return boolean with the Commited
*/
    public boolean isCommited()
    {
        return getSemanticObject().getBooleanProperty(bsc_commited);
    }

/**
* Sets the Commited property
* @param value long with the Commited
*/
    public void setCommited(boolean value)
    {
        getSemanticObject().setBooleanProperty(bsc_commited, value);
    }

/**
* Gets the Undeleteable property
* @return boolean with the Undeleteable
*/
    public boolean isUndeleteable()
    {
        return getSemanticObject().getBooleanProperty(swb_undeleteable);
    }

/**
* Sets the Undeleteable property
* @param value long with the Undeleteable
*/
    public void setUndeleteable(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_undeleteable, value);
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
* Gets the InformationSource property
* @return String with the InformationSource
*/
    public String getInformationSource()
    {
        return getSemanticObject().getProperty(bsc_informationSource);
    }

/**
* Sets the InformationSource property
* @param value long with the InformationSource
*/
    public void setInformationSource(String value)
    {
        getSemanticObject().setProperty(bsc_informationSource, value);
    }

/**
* Gets the Goals property
* @return String with the Goals
*/
    public String getGoals()
    {
        return getSemanticObject().getProperty(bsc_goals);
    }

/**
* Sets the Goals property
* @param value long with the Goals
*/
    public void setGoals(String value)
    {
        getSemanticObject().setProperty(bsc_goals, value);
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
   * Gets all the org.semanticwb.bsc.accessory.Grapher
   * @return A GenericIterator with all the org.semanticwb.bsc.accessory.Grapher
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Grapher> listGraphers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.accessory.Grapher>(getSemanticObject().listObjectProperties(bsc_hasGrapher));
    }

   /**
   * Gets true if has a Grapher
   * @param value org.semanticwb.bsc.accessory.Grapher to verify
   * @return true if the org.semanticwb.bsc.accessory.Grapher exists, false otherwise
   */
    public boolean hasGrapher(org.semanticwb.bsc.accessory.Grapher value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasGrapher,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Grapher
   * @param value org.semanticwb.bsc.accessory.Grapher to add
   */

    public void addGrapher(org.semanticwb.bsc.accessory.Grapher value)
    {
        getSemanticObject().addObjectProperty(bsc_hasGrapher, value.getSemanticObject());
    }
   /**
   * Removes all the Grapher
   */

    public void removeAllGrapher()
    {
        getSemanticObject().removeProperty(bsc_hasGrapher);
    }
   /**
   * Removes a Grapher
   * @param value org.semanticwb.bsc.accessory.Grapher to remove
   */

    public void removeGrapher(org.semanticwb.bsc.accessory.Grapher value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasGrapher,value.getSemanticObject());
    }

   /**
   * Gets the Grapher
   * @return a org.semanticwb.bsc.accessory.Grapher
   */
    public org.semanticwb.bsc.accessory.Grapher getGrapher()
    {
         org.semanticwb.bsc.accessory.Grapher ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasGrapher);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.accessory.Grapher)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Periodicity
   * @param value Periodicity to set
   */

    public void setPeriodicity(org.semanticwb.bsc.tracing.MeasurementFrequency value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_periodicity, value.getSemanticObject());
        }else
        {
            removePeriodicity();
        }
    }
   /**
   * Remove the value for Periodicity property
   */

    public void removePeriodicity()
    {
        getSemanticObject().removeProperty(bsc_periodicity);
    }

   /**
   * Gets the Periodicity
   * @return a org.semanticwb.bsc.tracing.MeasurementFrequency
   */
    public org.semanticwb.bsc.tracing.MeasurementFrequency getPeriodicity()
    {
         org.semanticwb.bsc.tracing.MeasurementFrequency ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_periodicity);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.tracing.MeasurementFrequency)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Serial property
* @return int with the Serial
*/
    public int getSerial()
    {
        return getSemanticObject().getIntProperty(bsc_serial);
    }

/**
* Sets the Serial property
* @param value long with the Serial
*/
    public void setSerial(int value)
    {
        getSemanticObject().setIntProperty(bsc_serial, value);
    }

/**
* Gets the Formula property
* @return String with the Formula
*/
    public String getFormula()
    {
        return getSemanticObject().getProperty(bsc_formula);
    }

/**
* Sets the Formula property
* @param value long with the Formula
*/
    public void setFormula(String value)
    {
        getSemanticObject().setProperty(bsc_formula, value);
    }

   /**
   * Gets the BSC
   * @return a instance of org.semanticwb.bsc.BSC
   */
    public org.semanticwb.bsc.BSC getBSC()
    {
        return (org.semanticwb.bsc.BSC)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
