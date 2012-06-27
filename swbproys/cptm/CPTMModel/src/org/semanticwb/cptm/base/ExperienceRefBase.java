package org.semanticwb.cptm.base;


   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class ExperienceRefBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.cptm.Videoable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.model.RuleRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable,org.semanticwb.cptm.CptmGeo
{
   /**
   * Clase principal del sistema de visit-méxico. Una instancia de esta clase es en donde se almacena toda la información de un proveedor de servicios especifico.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Company=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Company");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompanyExperienceRefInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompanyExperienceRefInv");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_ExpLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#ExpLocality");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias (Ej. Bodas, Parejas)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");
    public static final org.semanticwb.platform.SemanticProperty cptm_expExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#expExperience");
   /**
   * Experiencia en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ExperienceRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of ExperienceRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ExperienceRef for all models
       * @return Iterator of org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return A org.semanticwb.cptm.ExperienceRef
       */
        public static org.semanticwb.cptm.ExperienceRef getExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ExperienceRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return A org.semanticwb.cptm.ExperienceRef
       */
        public static org.semanticwb.cptm.ExperienceRef createExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ExperienceRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       */
        public static void removeExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ExperienceRef
       * @param id Identifier for org.semanticwb.cptm.ExperienceRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return true if the org.semanticwb.cptm.ExperienceRef exists, false otherwise
       */

        public static boolean hasExperienceRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getExperienceRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined CompanyExperienceRefInv
       * @param value CompanyExperienceRefInv of the type org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCompanyExperienceRefInv(org.semanticwb.cptm.Company value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyExperienceRefInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined CompanyExperienceRefInv
       * @param value CompanyExperienceRefInv of the type org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCompanyExperienceRefInv(org.semanticwb.cptm.Company value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyExperienceRefInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_ExpLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Experience
       * @param value Experience of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByExperience(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_expExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Experience
       * @param value Experience of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByExperience(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_expExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.ExperienceRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ExperienceRef with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.ExperienceRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ExperienceRef> listExperienceRefByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ExperienceRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ExperienceRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ExperienceRef
   */
    public ExperienceRefBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the org.semanticwb.cptm.Company
   * @return A GenericIterator with all the org.semanticwb.cptm.Company
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> listCompanyExperienceRefInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company>(getSemanticObject().listObjectProperties(cptm_hasCompanyExperienceRefInv));
    }

   /**
   * Gets true if has a CompanyExperienceRefInv
   * @param value org.semanticwb.cptm.Company to verify
   * @return true if the org.semanticwb.cptm.Company exists, false otherwise
   */
    public boolean hasCompanyExperienceRefInv(org.semanticwb.cptm.Company value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompanyExperienceRefInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the CompanyExperienceRefInv
   * @return a org.semanticwb.cptm.Company
   */
    public org.semanticwb.cptm.Company getCompanyExperienceRefInv()
    {
         org.semanticwb.cptm.Company ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompanyExperienceRefInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Company)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Locality
   * @param value Locality to set
   */

    public void setLocality(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_ExpLocality, value.getSemanticObject());
        }else
        {
            removeLocality();
        }
    }
   /**
   * Remove the value for Locality property
   */

    public void removeLocality()
    {
        getSemanticObject().removeProperty(cptm_ExpLocality);
    }

   /**
   * Gets the Locality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_ExpLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
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
   * Sets the value for the property Experience
   * @param value Experience to set
   */

    public void setExperience(org.semanticwb.cptm.Experience value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_expExperience, value.getSemanticObject());
        }else
        {
            removeExperience();
        }
    }
   /**
   * Remove the value for Experience property
   */

    public void removeExperience()
    {
        getSemanticObject().removeProperty(cptm_expExperience);
    }

   /**
   * Gets the Experience
   * @return a org.semanticwb.cptm.Experience
   */
    public org.semanticwb.cptm.Experience getExperience()
    {
         org.semanticwb.cptm.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_expExperience);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Experience)obj.createGenericInstance();
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
