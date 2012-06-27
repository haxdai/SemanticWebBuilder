package org.semanticwb.cptm.base;


   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias (Ej. Bodas, Parejas) 
   */
public abstract class ExperienceBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.cptm.Videoable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.model.RuleRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable,org.semanticwb.cptm.CptmGeo
{
   /**
   * Notas Editoriales
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EditNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasEditNoteExperienceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasEditNoteExperienceInv");
   /**
   * Clase que se encarga de administrar el catálogo de Actividades (Buceo, Pesca, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
   /**
   * Actividades referenciadas a una Experiencia
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasExpActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasExpActivity");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");
    public static final org.semanticwb.platform.SemanticProperty cptm_expExperienceInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#expExperienceInv");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasExpReferencedActivities=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasExpReferencedActivities");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
   /**
   * Destinos referenciados a una Experiencia
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasExpLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasExpLocality");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias (Ej. Bodas, Parejas)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");

    public static class ClassMgr
    {
       /**
       * Returns a list of Experience for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperiences(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.Experience for all models
       * @return Iterator of org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperiences()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.Experience
       * @param id Identifier for org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return A org.semanticwb.cptm.Experience
       */
        public static org.semanticwb.cptm.Experience getExperience(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Experience)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.Experience
       * @param id Identifier for org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return A org.semanticwb.cptm.Experience
       */
        public static org.semanticwb.cptm.Experience createExperience(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.Experience)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.Experience
       * @param id Identifier for org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.Experience
       */
        public static void removeExperience(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.Experience
       * @param id Identifier for org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return true if the org.semanticwb.cptm.Experience exists, false otherwise
       */

        public static boolean hasExperience(String id, org.semanticwb.model.SWBModel model)
        {
            return (getExperience(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined EditNoteExperienceInv
       * @param value EditNoteExperienceInv of the type org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByEditNoteExperienceInv(org.semanticwb.cptm.EditNote value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEditNoteExperienceInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined EditNoteExperienceInv
       * @param value EditNoteExperienceInv of the type org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByEditNoteExperienceInv(org.semanticwb.cptm.EditNote value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasEditNoteExperienceInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpActivity
       * @param value ExpActivity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExpActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpActivity
       * @param value ExpActivity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExpActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpExperienceInv
       * @param value ExpExperienceInv of the type org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpExperienceInv(org.semanticwb.cptm.ExperienceRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_expExperienceInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpExperienceInv
       * @param value ExpExperienceInv of the type org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpExperienceInv(org.semanticwb.cptm.ExperienceRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_expExperienceInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpReferencedActivities
       * @param value ExpReferencedActivities of the type org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpReferencedActivities(org.semanticwb.cptm.ActivityRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExpReferencedActivities, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpReferencedActivities
       * @param value ExpReferencedActivities of the type org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpReferencedActivities(org.semanticwb.cptm.ActivityRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExpReferencedActivities,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpLocality
       * @param value ExpLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExpLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined ExpLocality
       * @param value ExpLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByExpLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasExpLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.Experience with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.Experience
       */

        public static java.util.Iterator<org.semanticwb.cptm.Experience> listExperienceByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ExperienceBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Experience
   */
    public ExperienceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Videoyoutube property
* @return String with the Videoyoutube
*/
    public String getVideoyoutube()
    {
        return getSemanticObject().getProperty(cptm_videoyoutube);
    }

/**
* Sets the Videoyoutube property
* @param value long with the Videoyoutube
*/
    public void setVideoyoutube(String value)
    {
        getSemanticObject().setProperty(cptm_videoyoutube, value);
    }

/**
* Gets the Cptm_latitude property
* @return float with the Cptm_latitude
*/
    public float getCptm_latitude()
    {
        return getSemanticObject().getFloatProperty(cptm_cptm_latitude);
    }

/**
* Sets the Cptm_latitude property
* @param value long with the Cptm_latitude
*/
    public void setCptm_latitude(float value)
    {
        getSemanticObject().setFloatProperty(cptm_cptm_latitude, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.EditNote
   * @return A GenericIterator with all the org.semanticwb.cptm.EditNote
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> listEditNoteExperienceInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote>(getSemanticObject().listObjectProperties(cptm_hasEditNoteExperienceInv));
    }

   /**
   * Gets true if has a EditNoteExperienceInv
   * @param value org.semanticwb.cptm.EditNote to verify
   * @return true if the org.semanticwb.cptm.EditNote exists, false otherwise
   */
    public boolean hasEditNoteExperienceInv(org.semanticwb.cptm.EditNote value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasEditNoteExperienceInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the EditNoteExperienceInv
   * @return a org.semanticwb.cptm.EditNote
   */
    public org.semanticwb.cptm.EditNote getEditNoteExperienceInv()
    {
         org.semanticwb.cptm.EditNote ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasEditNoteExperienceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EditNote)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Activity
   * @return A GenericIterator with all the org.semanticwb.cptm.Activity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> listExpActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity>(getSemanticObject().listObjectProperties(cptm_hasExpActivity));
    }

   /**
   * Gets true if has a ExpActivity
   * @param value org.semanticwb.cptm.Activity to verify
   * @return true if the org.semanticwb.cptm.Activity exists, false otherwise
   */
    public boolean hasExpActivity(org.semanticwb.cptm.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasExpActivity,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ExpActivity
   * @param value org.semanticwb.cptm.Activity to add
   */

    public void addExpActivity(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().addObjectProperty(cptm_hasExpActivity, value.getSemanticObject());
    }
   /**
   * Removes all the ExpActivity
   */

    public void removeAllExpActivity()
    {
        getSemanticObject().removeProperty(cptm_hasExpActivity);
    }
   /**
   * Removes a ExpActivity
   * @param value org.semanticwb.cptm.Activity to remove
   */

    public void removeExpActivity(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasExpActivity,value.getSemanticObject());
    }

   /**
   * Gets the ExpActivity
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getExpActivity()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasExpActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Activity)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Cptm_longitude property
* @return float with the Cptm_longitude
*/
    public float getCptm_longitude()
    {
        return getSemanticObject().getFloatProperty(cptm_cptm_longitude);
    }

/**
* Sets the Cptm_longitude property
* @param value long with the Cptm_longitude
*/
    public void setCptm_longitude(float value)
    {
        getSemanticObject().setFloatProperty(cptm_cptm_longitude, value);
    }
   /**
   * Sets the value for the property ExpExperienceInv
   * @param value ExpExperienceInv to set
   */

    public void setExpExperienceInv(org.semanticwb.cptm.ExperienceRef value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_expExperienceInv, value.getSemanticObject());
        }else
        {
            removeExpExperienceInv();
        }
    }
   /**
   * Remove the value for ExpExperienceInv property
   */

    public void removeExpExperienceInv()
    {
        getSemanticObject().removeProperty(cptm_expExperienceInv);
    }

   /**
   * Gets the ExpExperienceInv
   * @return a org.semanticwb.cptm.ExperienceRef
   */
    public org.semanticwb.cptm.ExperienceRef getExpExperienceInv()
    {
         org.semanticwb.cptm.ExperienceRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_expExperienceInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ExperienceRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.ActivityRef
   * @return A GenericIterator with all the org.semanticwb.cptm.ActivityRef
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> listExpReferencedActivitieses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(getSemanticObject().listObjectProperties(cptm_hasExpReferencedActivities));
    }

   /**
   * Gets true if has a ExpReferencedActivities
   * @param value org.semanticwb.cptm.ActivityRef to verify
   * @return true if the org.semanticwb.cptm.ActivityRef exists, false otherwise
   */
    public boolean hasExpReferencedActivities(org.semanticwb.cptm.ActivityRef value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasExpReferencedActivities,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ExpReferencedActivities
   * @param value org.semanticwb.cptm.ActivityRef to add
   */

    public void addExpReferencedActivities(org.semanticwb.cptm.ActivityRef value)
    {
        getSemanticObject().addObjectProperty(cptm_hasExpReferencedActivities, value.getSemanticObject());
    }
   /**
   * Removes all the ExpReferencedActivities
   */

    public void removeAllExpReferencedActivities()
    {
        getSemanticObject().removeProperty(cptm_hasExpReferencedActivities);
    }
   /**
   * Removes a ExpReferencedActivities
   * @param value org.semanticwb.cptm.ActivityRef to remove
   */

    public void removeExpReferencedActivities(org.semanticwb.cptm.ActivityRef value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasExpReferencedActivities,value.getSemanticObject());
    }

   /**
   * Gets the ExpReferencedActivities
   * @return a org.semanticwb.cptm.ActivityRef
   */
    public org.semanticwb.cptm.ActivityRef getExpReferencedActivities()
    {
         org.semanticwb.cptm.ActivityRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasExpReferencedActivities);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.ActivityRef)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listExpLocalities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasExpLocality));
    }

   /**
   * Gets true if has a ExpLocality
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasExpLocality(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasExpLocality,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a ExpLocality
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addExpLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasExpLocality, value.getSemanticObject());
    }
   /**
   * Removes all the ExpLocality
   */

    public void removeAllExpLocality()
    {
        getSemanticObject().removeProperty(cptm_hasExpLocality);
    }
   /**
   * Removes a ExpLocality
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeExpLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasExpLocality,value.getSemanticObject());
    }

   /**
   * Gets the ExpLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getExpLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasExpLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the CPTMWebSite
   * @return a instance of org.semanticwb.cptm.CPTMWebSite
   */
    public org.semanticwb.cptm.CPTMWebSite getCPTMWebSite()
    {
        return (org.semanticwb.cptm.CPTMWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
