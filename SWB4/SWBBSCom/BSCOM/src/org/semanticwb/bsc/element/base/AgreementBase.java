package org.semanticwb.bsc.element.base;


   /**
   * Define las características de un Acuerdo. 
   */
public abstract class AgreementBase extends org.semanticwb.bsc.element.BSCElement implements org.semanticwb.model.Roleable,org.semanticwb.bsc.Help,org.semanticwb.bsc.Recognizable,org.semanticwb.bsc.Detailed,org.semanticwb.model.FilterableNode,org.semanticwb.model.Filterable,org.semanticwb.model.Trashable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.bsc.Attachmentable,org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.UserGroupable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Traceable,org.semanticwb.bsc.Summarized
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty bsc_agreementResponsible=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#agreementResponsible");
   /**
   * Fecha compromiso de un acuerdo
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_commitmentDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#commitmentDate");
   /**
   * Superclase de todos los objetos con persistencia en SemanticWebBuilder
   */
    public static final org.semanticwb.platform.SemanticClass swb_SWBClass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#SWBClass");
   /**
   * Conjunto de usuarios que podra ver y actualizar información de un acuerdo
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_agreementVisibility=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#agreementVisibility");
   /**
   * Un estado define la situación de una medición  en un indicador respecto de las metas de su objetivo.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#State");
   /**
   * Persiste información del estatus de un acuerdo
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_agreementStatus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#agreementStatus");
   /**
   * Define un dueño para el acuerdo
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_agreementSponsor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#agreementSponsor");
   /**
   * Persiste la información de una Sesión. Existen  dos tipos de sesiones: RAE y NOA
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Meeting=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Meeting");
   /**
   * Indica el objeto Meeting relacionado al objeto Agreement en consulta
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_hasAgreementInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasAgreementInv");
   /**
   * Persiste información de los temas a los que se asocia un acuerdo
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_theme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#theme");
   /**
   * Define las características de un Comentario.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Comment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Comment");
   /**
   * Almacena los comentarios que se hagan hacia un acuerdo
   */
    public static final org.semanticwb.platform.SemanticProperty bsc_hasComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/bsc#hasComment");
   /**
   * Define las características de un Acuerdo.
   */
    public static final org.semanticwb.platform.SemanticClass bsc_Agreement=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Agreement");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Agreement");

    public static class ClassMgr
    {
       /**
       * Returns a list of Agreement for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreements(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.element.Agreement for all models
       * @return Iterator of org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreements()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement>(it, true);
        }

        public static org.semanticwb.bsc.element.Agreement createAgreement(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.bsc.element.Agreement.ClassMgr.createAgreement(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.bsc.element.Agreement
       * @param id Identifier for org.semanticwb.bsc.element.Agreement
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return A org.semanticwb.bsc.element.Agreement
       */
        public static org.semanticwb.bsc.element.Agreement getAgreement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Agreement)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.element.Agreement
       * @param id Identifier for org.semanticwb.bsc.element.Agreement
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return A org.semanticwb.bsc.element.Agreement
       */
        public static org.semanticwb.bsc.element.Agreement createAgreement(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Agreement)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.element.Agreement
       * @param id Identifier for org.semanticwb.bsc.element.Agreement
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       */
        public static void removeAgreement(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.element.Agreement
       * @param id Identifier for org.semanticwb.bsc.element.Agreement
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return true if the org.semanticwb.bsc.element.Agreement exists, false otherwise
       */

        public static boolean hasAgreement(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAgreement(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementResponsible
       * @param value AgreementResponsible of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementResponsible(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementResponsible, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementResponsible
       * @param value AgreementResponsible of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementResponsible(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementResponsible,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByUserGroup(org.semanticwb.model.UserGroup value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined UserGroup
       * @param value UserGroup of the type org.semanticwb.model.UserGroup
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByUserGroup(org.semanticwb.model.UserGroup value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroup,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAttachments(org.semanticwb.bsc.catalogs.Attachment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Attachments
       * @param value Attachments of the type org.semanticwb.bsc.catalogs.Attachment
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAttachments(org.semanticwb.bsc.catalogs.Attachment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAttachments,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementVisibility
       * @param value AgreementVisibility of the type org.semanticwb.model.SWBClass
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementVisibility(org.semanticwb.model.SWBClass value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementVisibility, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementVisibility
       * @param value AgreementVisibility of the type org.semanticwb.model.SWBClass
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementVisibility(org.semanticwb.model.SWBClass value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementVisibility,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByRole(org.semanticwb.model.Role value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Role
       * @param value Role of the type org.semanticwb.model.Role
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByRole(org.semanticwb.model.Role value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRole,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementStatus
       * @param value AgreementStatus of the type org.semanticwb.bsc.accessory.State
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementStatus(org.semanticwb.bsc.accessory.State value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementStatus, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementStatus
       * @param value AgreementStatus of the type org.semanticwb.bsc.accessory.State
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementStatus(org.semanticwb.bsc.accessory.State value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementStatus,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementSponsor
       * @param value AgreementSponsor of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementSponsor(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementSponsor, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined AgreementSponsor
       * @param value AgreementSponsor of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByAgreementSponsor(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_agreementSponsor,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Meeting
       * @param value Meeting of the type org.semanticwb.bsc.tracing.Meeting
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByMeeting(org.semanticwb.bsc.tracing.Meeting value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAgreementInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Meeting
       * @param value Meeting of the type org.semanticwb.bsc.tracing.Meeting
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByMeeting(org.semanticwb.bsc.tracing.Meeting value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasAgreementInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Comment
       * @param value Comment of the type org.semanticwb.bsc.catalogs.Comment
       * @param model Model of the org.semanticwb.bsc.element.Agreement
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByComment(org.semanticwb.bsc.catalogs.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(bsc_hasComment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Agreement with a determined Comment
       * @param value Comment of the type org.semanticwb.bsc.catalogs.Comment
       * @return Iterator with all the org.semanticwb.bsc.element.Agreement
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Agreement> listAgreementByComment(org.semanticwb.bsc.catalogs.Comment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Agreement> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(bsc_hasComment,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static AgreementBase.ClassMgr getAgreementClassMgr()
    {
        return new AgreementBase.ClassMgr();
    }

   /**
   * Constructs a AgreementBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Agreement
   */
    public AgreementBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property AgreementResponsible
   * @param value AgreementResponsible to set
   */

    public void setAgreementResponsible(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_agreementResponsible, value.getSemanticObject());
        }else
        {
            removeAgreementResponsible();
        }
    }
   /**
   * Remove the value for AgreementResponsible property
   */

    public void removeAgreementResponsible()
    {
        getSemanticObject().removeProperty(bsc_agreementResponsible);
    }

   /**
   * Gets the AgreementResponsible
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getAgreementResponsible()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_agreementResponsible);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the CommitmentDate property
* @return java.util.Date with the CommitmentDate
*/
    public java.util.Date getCommitmentDate()
    {
        return getSemanticObject().getDateProperty(bsc_commitmentDate);
    }

/**
* Sets the CommitmentDate property
* @param value long with the CommitmentDate
*/
    public void setCommitmentDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(bsc_commitmentDate, value);
    }

/**
* Gets the Prefix property
* @return String with the Prefix
*/
    public String getPrefix()
    {
        //Override this method in Agreement object
        return getSemanticObject().getProperty(bsc_prefix,false);
    }

/**
* Sets the Prefix property
* @param value long with the Prefix
*/
    public void setPrefix(String value)
    {
        //Override this method in Agreement object
        getSemanticObject().setProperty(bsc_prefix, value,false);
    }
   /**
   * Sets the value for the property AgreementVisibility
   * @param value AgreementVisibility to set
   */

    public void setAgreementVisibility(org.semanticwb.model.SWBClass value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_agreementVisibility, value.getSemanticObject());
        }else
        {
            removeAgreementVisibility();
        }
    }
   /**
   * Remove the value for AgreementVisibility property
   */

    public void removeAgreementVisibility()
    {
        getSemanticObject().removeProperty(bsc_agreementVisibility);
    }

   /**
   * Gets the AgreementVisibility
   * @return a org.semanticwb.model.SWBClass
   */
    public org.semanticwb.model.SWBClass getAgreementVisibility()
    {
         org.semanticwb.model.SWBClass ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_agreementVisibility);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.SWBClass)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property AgreementStatus
   * @param value AgreementStatus to set
   */

    public void setAgreementStatus(org.semanticwb.bsc.accessory.State value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_agreementStatus, value.getSemanticObject());
        }else
        {
            removeAgreementStatus();
        }
    }
   /**
   * Remove the value for AgreementStatus property
   */

    public void removeAgreementStatus()
    {
        getSemanticObject().removeProperty(bsc_agreementStatus);
    }

   /**
   * Gets the AgreementStatus
   * @return a org.semanticwb.bsc.accessory.State
   */
    public org.semanticwb.bsc.accessory.State getAgreementStatus()
    {
         org.semanticwb.bsc.accessory.State ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_agreementStatus);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.accessory.State)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property AgreementSponsor
   * @param value AgreementSponsor to set
   */

    public void setAgreementSponsor(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_agreementSponsor, value.getSemanticObject());
        }else
        {
            removeAgreementSponsor();
        }
    }
   /**
   * Remove the value for AgreementSponsor property
   */

    public void removeAgreementSponsor()
    {
        getSemanticObject().removeProperty(bsc_agreementSponsor);
    }

   /**
   * Gets the AgreementSponsor
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getAgreementSponsor()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_agreementSponsor);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Meeting
   * @param value Meeting to set
   */

    public void setMeeting(org.semanticwb.bsc.tracing.Meeting value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(bsc_hasAgreementInv, value.getSemanticObject());
        }else
        {
            removeMeeting();
        }
    }
   /**
   * Remove the value for Meeting property
   */

    public void removeMeeting()
    {
        getSemanticObject().removeProperty(bsc_hasAgreementInv);
    }

   /**
   * Gets the Meeting
   * @return a org.semanticwb.bsc.tracing.Meeting
   */
    public org.semanticwb.bsc.tracing.Meeting getMeeting()
    {
         org.semanticwb.bsc.tracing.Meeting ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasAgreementInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.tracing.Meeting)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Theme property
* @return String with the Theme
*/
    public String getTheme()
    {
        return getSemanticObject().getProperty(bsc_theme);
    }

/**
* Sets the Theme property
* @param value long with the Theme
*/
    public void setTheme(String value)
    {
        getSemanticObject().setProperty(bsc_theme, value);
    }
   /**
   * Gets all the org.semanticwb.bsc.catalogs.Comment
   * @return A GenericIterator with all the org.semanticwb.bsc.catalogs.Comment
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Comment> listComments()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.catalogs.Comment>(getSemanticObject().listObjectProperties(bsc_hasComment));
    }

   /**
   * Gets true if has a Comment
   * @param value org.semanticwb.bsc.catalogs.Comment to verify
   * @return true if the org.semanticwb.bsc.catalogs.Comment exists, false otherwise
   */
    public boolean hasComment(org.semanticwb.bsc.catalogs.Comment value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(bsc_hasComment,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Comment
   * @param value org.semanticwb.bsc.catalogs.Comment to add
   */

    public void addComment(org.semanticwb.bsc.catalogs.Comment value)
    {
        getSemanticObject().addObjectProperty(bsc_hasComment, value.getSemanticObject());
    }
   /**
   * Removes all the Comment
   */

    public void removeAllComment()
    {
        getSemanticObject().removeProperty(bsc_hasComment);
    }
   /**
   * Removes a Comment
   * @param value org.semanticwb.bsc.catalogs.Comment to remove
   */

    public void removeComment(org.semanticwb.bsc.catalogs.Comment value)
    {
        getSemanticObject().removeObjectProperty(bsc_hasComment,value.getSemanticObject());
    }

   /**
   * Gets the Comment
   * @return a org.semanticwb.bsc.catalogs.Comment
   */
    public org.semanticwb.bsc.catalogs.Comment getComment()
    {
         org.semanticwb.bsc.catalogs.Comment ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(bsc_hasComment);
         if(obj!=null)
         {
             ret=(org.semanticwb.bsc.catalogs.Comment)obj.createGenericInstance();
         }
         return ret;
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
