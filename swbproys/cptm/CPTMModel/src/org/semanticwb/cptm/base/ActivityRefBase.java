package org.semanticwb.cptm.base;


   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType 
   */
public abstract class ActivityRefBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.cptm.Videoable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.model.RuleRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable,org.semanticwb.cptm.CptmGeo
{
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefLocality");
   /**
   * Clase que se encarga de administrar el catálogo de Actividades (Buceo, Pesca, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
    public static final org.semanticwb.platform.SemanticProperty cptm_arefActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#arefActivity");
   /**
   * Clase principal del sistema de visit-méxico. Una instancia de esta clase es en donde se almacena toda la información de un proveedor de servicios especifico.
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Company=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Company");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompanyActivityRefInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompanyActivityRefInv");
   /**
   * Actividad en un específico "Destino", si le quisiera agregar un Directorio de empresas aqui, tendría que tener una relación además de con el Destino, con el objeto  SPType
   */
    public static final org.semanticwb.platform.SemanticClass cptm_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#ActivityRef");

    public static class ClassMgr
    {
       /**
       * Returns a list of ActivityRef for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.ActivityRef for all models
       * @return Iterator of org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return A org.semanticwb.cptm.ActivityRef
       */
        public static org.semanticwb.cptm.ActivityRef getActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityRef)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return A org.semanticwb.cptm.ActivityRef
       */
        public static org.semanticwb.cptm.ActivityRef createActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.ActivityRef)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       */
        public static void removeActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.ActivityRef
       * @param id Identifier for org.semanticwb.cptm.ActivityRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return true if the org.semanticwb.cptm.ActivityRef exists, false otherwise
       */

        public static boolean hasActivityRef(String id, org.semanticwb.model.SWBModel model)
        {
            return (getActivityRef(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Activity
       * @param value Activity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Activity
       * @param value Activity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_arefActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined CompanyActivityRefInv
       * @param value CompanyActivityRefInv of the type org.semanticwb.cptm.Company
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCompanyActivityRefInv(org.semanticwb.cptm.Company value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyActivityRefInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined CompanyActivityRefInv
       * @param value CompanyActivityRefInv of the type org.semanticwb.cptm.Company
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCompanyActivityRefInv(org.semanticwb.cptm.Company value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyActivityRefInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.ActivityRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.ActivityRef with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.ActivityRef
       */

        public static java.util.Iterator<org.semanticwb.cptm.ActivityRef> listActivityRefByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.ActivityRef> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ActivityRefBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ActivityRef
   */
    public ActivityRefBase(org.semanticwb.platform.SemanticObject base)
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
   * Sets the value for the property Locality
   * @param value Locality to set
   */

    public void setLocality(org.semanticwb.cptm.LocalityInt value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefLocality, value.getSemanticObject());
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
        getSemanticObject().removeProperty(cptm_arefLocality);
    }

   /**
   * Gets the Locality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Activity
   * @param value Activity to set
   */

    public void setActivity(org.semanticwb.cptm.Activity value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_arefActivity, value.getSemanticObject());
        }else
        {
            removeActivity();
        }
    }
   /**
   * Remove the value for Activity property
   */

    public void removeActivity()
    {
        getSemanticObject().removeProperty(cptm_arefActivity);
    }

   /**
   * Gets the Activity
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getActivity()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_arefActivity);
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
   * Gets all the org.semanticwb.cptm.Company
   * @return A GenericIterator with all the org.semanticwb.cptm.Company
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company> listCompanyActivityRefInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Company>(getSemanticObject().listObjectProperties(cptm_hasCompanyActivityRefInv));
    }

   /**
   * Gets true if has a CompanyActivityRefInv
   * @param value org.semanticwb.cptm.Company to verify
   * @return true if the org.semanticwb.cptm.Company exists, false otherwise
   */
    public boolean hasCompanyActivityRefInv(org.semanticwb.cptm.Company value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompanyActivityRefInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the CompanyActivityRefInv
   * @return a org.semanticwb.cptm.Company
   */
    public org.semanticwb.cptm.Company getCompanyActivityRefInv()
    {
         org.semanticwb.cptm.Company ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompanyActivityRefInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Company)obj.createGenericInstance();
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
