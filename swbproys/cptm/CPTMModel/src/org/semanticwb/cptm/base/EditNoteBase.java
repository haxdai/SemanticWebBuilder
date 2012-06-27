package org.semanticwb.cptm.base;


   /**
   * Notas Editoriales 
   */
public abstract class EditNoteBase extends org.semanticwb.cptm.CPTMGeneralWebPage implements org.semanticwb.model.TemplateRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Indexable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.model.FilterableNode,org.semanticwb.model.MetaTagable,org.semanticwb.model.RuleRefable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Activeable,org.semanticwb.cptm.CptmDescriptionPage,org.semanticwb.model.Expirable,org.semanticwb.model.Viewable,org.semanticwb.model.Countryable,org.semanticwb.model.Rankable
{
    public static final org.semanticwb.platform.SemanticProperty cptm_isathome=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#isathome");
   /**
   * Clase que hereda de WebPage.Mediante esta se administra el catálogo de Estados de la República (Ej. Tamaulipas, Morelos)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_State=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#State");
   /**
   * Estado(s)  Relacionado(s) a las Notas Editoriales.
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasNoteState=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasNoteState");
    public static final org.semanticwb.platform.SemanticProperty cptm_noteHomeIndex=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteHomeIndex");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
   /**
   * Destinos relacionados con la nota editorial
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasLocality");
   /**
   * Catalogo de Tipos de Notas (Tipo 1/Primarias|Tipo 2/Secundarias|Tipo 3/Terciarias)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EditNoteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNoteType");
    public static final org.semanticwb.platform.SemanticProperty cptm_noteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#noteType");
   /**
   * Redirección a una ágina interna de la instancia de SWB
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_editNoteInternalURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#editNoteInternalURL");
   /**
   * Clase que hereda de WebPage.Mediante estas se administra el catálogo de experiencias (Ej. Bodas, Parejas)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Experience");
   /**
   * Experiencias asociadas a la nota editorial
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasNoteExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasNoteExperience");
   /**
   * Clase que se encarga de administrar el catálogo de Actividades (Buceo, Pesca, etc)
   */
    public static final org.semanticwb.platform.SemanticClass cptm_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Activity");
   /**
   * Actividades asociadas a la nota editorial
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasNoteActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasNoteActivity");
   /**
   * Notas Editoriales
   */
    public static final org.semanticwb.platform.SemanticClass cptm_EditNote=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#EditNote");

    public static class ClassMgr
    {
       /**
       * Returns a list of EditNote for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNotes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.EditNote for all models
       * @return Iterator of org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNotes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.EditNote
       * @param id Identifier for org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return A org.semanticwb.cptm.EditNote
       */
        public static org.semanticwb.cptm.EditNote getEditNote(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.EditNote)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.EditNote
       * @param id Identifier for org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return A org.semanticwb.cptm.EditNote
       */
        public static org.semanticwb.cptm.EditNote createEditNote(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.EditNote)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.EditNote
       * @param id Identifier for org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.EditNote
       */
        public static void removeEditNote(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.EditNote
       * @param id Identifier for org.semanticwb.cptm.EditNote
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return true if the org.semanticwb.cptm.EditNote exists, false otherwise
       */

        public static boolean hasEditNote(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEditNote(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteState
       * @param value NoteState of the type org.semanticwb.cptm.State
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteState(org.semanticwb.cptm.State value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteState, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteState
       * @param value NoteState of the type org.semanticwb.cptm.State
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteState(org.semanticwb.cptm.State value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteState,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByModelRelation(org.semanticwb.cptm.ModelRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ModelRelation
       * @param value ModelRelation of the type org.semanticwb.cptm.ModelRelation
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByModelRelation(org.semanticwb.cptm.ModelRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasModelRelation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Locality
       * @param value Locality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteType
       * @param value NoteType of the type org.semanticwb.cptm.EditNoteType
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteType(org.semanticwb.cptm.EditNoteType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_noteType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteType
       * @param value NoteType of the type org.semanticwb.cptm.EditNoteType
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteType(org.semanticwb.cptm.EditNoteType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_noteType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteExperience
       * @param value NoteExperience of the type org.semanticwb.cptm.Experience
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteExperience(org.semanticwb.cptm.Experience value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteExperience, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteExperience
       * @param value NoteExperience of the type org.semanticwb.cptm.Experience
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteExperience(org.semanticwb.cptm.Experience value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteExperience,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteActivity
       * @param value NoteActivity of the type org.semanticwb.cptm.Activity
       * @param model Model of the org.semanticwb.cptm.EditNote
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteActivity(org.semanticwb.cptm.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.EditNote with a determined NoteActivity
       * @param value NoteActivity of the type org.semanticwb.cptm.Activity
       * @return Iterator with all the org.semanticwb.cptm.EditNote
       */

        public static java.util.Iterator<org.semanticwb.cptm.EditNote> listEditNoteByNoteActivity(org.semanticwb.cptm.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.EditNote> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasNoteActivity,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EditNoteBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EditNote
   */
    public EditNoteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Isathome property
* @return boolean with the Isathome
*/
    public boolean isIsathome()
    {
        return getSemanticObject().getBooleanProperty(cptm_isathome);
    }

/**
* Sets the Isathome property
* @param value long with the Isathome
*/
    public void setIsathome(boolean value)
    {
        getSemanticObject().setBooleanProperty(cptm_isathome, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.State
   * @return A GenericIterator with all the org.semanticwb.cptm.State
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State> listNoteStates()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.State>(getSemanticObject().listObjectProperties(cptm_hasNoteState));
    }

   /**
   * Gets true if has a NoteState
   * @param value org.semanticwb.cptm.State to verify
   * @return true if the org.semanticwb.cptm.State exists, false otherwise
   */
    public boolean hasNoteState(org.semanticwb.cptm.State value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNoteState,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a NoteState
   * @param value org.semanticwb.cptm.State to add
   */

    public void addNoteState(org.semanticwb.cptm.State value)
    {
        getSemanticObject().addObjectProperty(cptm_hasNoteState, value.getSemanticObject());
    }
   /**
   * Removes all the NoteState
   */

    public void removeAllNoteState()
    {
        getSemanticObject().removeProperty(cptm_hasNoteState);
    }
   /**
   * Removes a NoteState
   * @param value org.semanticwb.cptm.State to remove
   */

    public void removeNoteState(org.semanticwb.cptm.State value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasNoteState,value.getSemanticObject());
    }

   /**
   * Gets the NoteState
   * @return a org.semanticwb.cptm.State
   */
    public org.semanticwb.cptm.State getNoteState()
    {
         org.semanticwb.cptm.State ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNoteState);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.State)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NoteHomeIndex property
* @return int with the NoteHomeIndex
*/
    public int getNoteHomeIndex()
    {
        return getSemanticObject().getIntProperty(cptm_noteHomeIndex);
    }

/**
* Sets the NoteHomeIndex property
* @param value long with the NoteHomeIndex
*/
    public void setNoteHomeIndex(int value)
    {
        getSemanticObject().setIntProperty(cptm_noteHomeIndex, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listLocalities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasLocality));
    }

   /**
   * Gets true if has a Locality
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasLocality(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasLocality,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Locality
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasLocality, value.getSemanticObject());
    }
   /**
   * Removes all the Locality
   */

    public void removeAllLocality()
    {
        getSemanticObject().removeProperty(cptm_hasLocality);
    }
   /**
   * Removes a Locality
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasLocality,value.getSemanticObject());
    }

   /**
   * Gets the Locality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NoteType
   * @param value NoteType to set
   */

    public void setNoteType(org.semanticwb.cptm.EditNoteType value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(cptm_noteType, value.getSemanticObject());
        }else
        {
            removeNoteType();
        }
    }
   /**
   * Remove the value for NoteType property
   */

    public void removeNoteType()
    {
        getSemanticObject().removeProperty(cptm_noteType);
    }

   /**
   * Gets the NoteType
   * @return a org.semanticwb.cptm.EditNoteType
   */
    public org.semanticwb.cptm.EditNoteType getNoteType()
    {
         org.semanticwb.cptm.EditNoteType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_noteType);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.EditNoteType)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the EditNoteInternalURL property
* @return String with the EditNoteInternalURL
*/
    public String getEditNoteInternalURL()
    {
        return getSemanticObject().getProperty(cptm_editNoteInternalURL);
    }

/**
* Sets the EditNoteInternalURL property
* @param value long with the EditNoteInternalURL
*/
    public void setEditNoteInternalURL(String value)
    {
        getSemanticObject().setProperty(cptm_editNoteInternalURL, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.Experience
   * @return A GenericIterator with all the org.semanticwb.cptm.Experience
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience> listNoteExperiences()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Experience>(getSemanticObject().listObjectProperties(cptm_hasNoteExperience));
    }

   /**
   * Gets true if has a NoteExperience
   * @param value org.semanticwb.cptm.Experience to verify
   * @return true if the org.semanticwb.cptm.Experience exists, false otherwise
   */
    public boolean hasNoteExperience(org.semanticwb.cptm.Experience value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNoteExperience,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a NoteExperience
   * @param value org.semanticwb.cptm.Experience to add
   */

    public void addNoteExperience(org.semanticwb.cptm.Experience value)
    {
        getSemanticObject().addObjectProperty(cptm_hasNoteExperience, value.getSemanticObject());
    }
   /**
   * Removes all the NoteExperience
   */

    public void removeAllNoteExperience()
    {
        getSemanticObject().removeProperty(cptm_hasNoteExperience);
    }
   /**
   * Removes a NoteExperience
   * @param value org.semanticwb.cptm.Experience to remove
   */

    public void removeNoteExperience(org.semanticwb.cptm.Experience value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasNoteExperience,value.getSemanticObject());
    }

   /**
   * Gets the NoteExperience
   * @return a org.semanticwb.cptm.Experience
   */
    public org.semanticwb.cptm.Experience getNoteExperience()
    {
         org.semanticwb.cptm.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNoteExperience);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Experience)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.Activity
   * @return A GenericIterator with all the org.semanticwb.cptm.Activity
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity> listNoteActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Activity>(getSemanticObject().listObjectProperties(cptm_hasNoteActivity));
    }

   /**
   * Gets true if has a NoteActivity
   * @param value org.semanticwb.cptm.Activity to verify
   * @return true if the org.semanticwb.cptm.Activity exists, false otherwise
   */
    public boolean hasNoteActivity(org.semanticwb.cptm.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasNoteActivity,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a NoteActivity
   * @param value org.semanticwb.cptm.Activity to add
   */

    public void addNoteActivity(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().addObjectProperty(cptm_hasNoteActivity, value.getSemanticObject());
    }
   /**
   * Removes all the NoteActivity
   */

    public void removeAllNoteActivity()
    {
        getSemanticObject().removeProperty(cptm_hasNoteActivity);
    }
   /**
   * Removes a NoteActivity
   * @param value org.semanticwb.cptm.Activity to remove
   */

    public void removeNoteActivity(org.semanticwb.cptm.Activity value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasNoteActivity,value.getSemanticObject());
    }

   /**
   * Gets the NoteActivity
   * @return a org.semanticwb.cptm.Activity
   */
    public org.semanticwb.cptm.Activity getNoteActivity()
    {
         org.semanticwb.cptm.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasNoteActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Activity)obj.createGenericInstance();
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
