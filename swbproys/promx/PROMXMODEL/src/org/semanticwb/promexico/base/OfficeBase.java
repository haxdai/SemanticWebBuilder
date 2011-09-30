package org.semanticwb.promexico.base;


   /**
   * Objeto controlador de oficinas 
   */
public abstract class OfficeBase extends org.semanticwb.promexico.ProMxWebPage implements org.semanticwb.model.Activeable,org.semanticwb.model.Expirable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Viewable,org.semanticwb.model.Rankable,org.semanticwb.promexico.Localizable,org.semanticwb.model.Resourceable,org.semanticwb.model.Searchable,org.semanticwb.model.Undeleteable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Referensable,org.semanticwb.model.MetaTagable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Countryable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Trashable,org.semanticwb.model.Localeable,org.semanticwb.model.Filterable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Indexable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.UserGroupRefable
{
    public static final org.semanticwb.platform.SemanticClass promx_ProMxVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#ProMxVideo");
   /**
   * Videos relacionados a una oficina
   */
    public static final org.semanticwb.platform.SemanticProperty promx_hasVideo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasVideo");
    public static final org.semanticwb.platform.SemanticProperty promx_international=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#international");
   /**
   * Datos de un representante, se utiliza para las oficinas y para las regiones
   */
    public static final org.semanticwb.platform.SemanticClass promx_Manager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Manager");
    public static final org.semanticwb.platform.SemanticProperty promx_hasManager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasManager");
   /**
   * Foto de la Oficina
   */
    public static final org.semanticwb.platform.SemanticProperty promx_OfficePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#OfficePhoto");
    public static final org.semanticwb.platform.SemanticClass promx_New=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#New");
    public static final org.semanticwb.platform.SemanticProperty promx_hasNewsOfficeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasNewsOfficeInv");
    public static final org.semanticwb.platform.SemanticProperty promx_OfficeAddress=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#OfficeAddress");
   /**
   * Catalogo de Mercados
   */
    public static final org.semanticwb.platform.SemanticClass promx_Market=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Market");
    public static final org.semanticwb.platform.SemanticProperty promx_hasMarket=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasMarket");
   /**
   * Servicios
   */
    public static final org.semanticwb.platform.SemanticClass promx_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Service");
   /**
   * Servicios Relacionados con la Oficina
   */
    public static final org.semanticwb.platform.SemanticProperty promx_hasService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/promexico#hasService");
   /**
   * Objeto controlador de oficinas
   */
    public static final org.semanticwb.platform.SemanticClass promx_Office=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Office");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/promexico#Office");

    public static class ClassMgr
    {
       /**
       * Returns a list of Office for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOffices(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.promexico.Office for all models
       * @return Iterator of org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOffices()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office>(it, true);
        }
       /**
       * Gets a org.semanticwb.promexico.Office
       * @param id Identifier for org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.Office
       * @return A org.semanticwb.promexico.Office
       */
        public static org.semanticwb.promexico.Office getOffice(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Office)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.promexico.Office
       * @param id Identifier for org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.Office
       * @return A org.semanticwb.promexico.Office
       */
        public static org.semanticwb.promexico.Office createOffice(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.promexico.Office)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.promexico.Office
       * @param id Identifier for org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.Office
       */
        public static void removeOffice(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.promexico.Office
       * @param id Identifier for org.semanticwb.promexico.Office
       * @param model Model of the org.semanticwb.promexico.Office
       * @return true if the org.semanticwb.promexico.Office exists, false otherwise
       */

        public static boolean hasOffice(String id, org.semanticwb.model.SWBModel model)
        {
            return (getOffice(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined AssMember
       * @param value AssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByThisRoleAssMember(org.semanticwb.model.AssMember value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined ThisRoleAssMember
       * @param value ThisRoleAssMember of the type org.semanticwb.model.AssMember
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByThisRoleAssMember(org.semanticwb.model.AssMember value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Child
       * @param value Child of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Video
       * @param value Video of the type org.semanticwb.promexico.ProMxVideo
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByVideo(org.semanticwb.promexico.ProMxVideo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasVideo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Video
       * @param value Video of the type org.semanticwb.promexico.ProMxVideo
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByVideo(org.semanticwb.promexico.ProMxVideo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasVideo,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByMetaTagsValue(org.semanticwb.model.MetaTagValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined MetaTagsValue
       * @param value MetaTagsValue of the type org.semanticwb.model.MetaTagValue
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByMetaTagsValue(org.semanticwb.model.MetaTagValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasMetaTagsValue,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByThisTypeAssociation(org.semanticwb.model.Association value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined ThisTypeAssociation
       * @param value ThisTypeAssociation of the type org.semanticwb.model.Association
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByThisTypeAssociation(org.semanticwb.model.Association value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByTemplateRef(org.semanticwb.model.TemplateRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined TemplateRef
       * @param value TemplateRef of the type org.semanticwb.model.TemplateRef
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByTemplateRef(org.semanticwb.model.TemplateRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByCountry(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_country, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Country
       * @param value Country of the type org.semanticwb.model.Country
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByCountry(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_country,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Parent
       * @param value Parent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByLanguage(org.semanticwb.model.Language value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_language, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Language
       * @param value Language of the type org.semanticwb.model.Language
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByLanguage(org.semanticwb.model.Language value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_language,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Manager
       * @param value Manager of the type org.semanticwb.promexico.Manager
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByManager(org.semanticwb.promexico.Manager value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasManager, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Manager
       * @param value Manager of the type org.semanticwb.promexico.Manager
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByManager(org.semanticwb.promexico.Manager value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasManager,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined NewsOfficeInv
       * @param value NewsOfficeInv of the type org.semanticwb.promexico.New
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByNewsOfficeInv(org.semanticwb.promexico.New value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasNewsOfficeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined NewsOfficeInv
       * @param value NewsOfficeInv of the type org.semanticwb.promexico.New
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByNewsOfficeInv(org.semanticwb.promexico.New value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasNewsOfficeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByRuleRef(org.semanticwb.model.RuleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined RuleRef
       * @param value RuleRef of the type org.semanticwb.model.RuleRef
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByRuleRef(org.semanticwb.model.RuleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByWebPageVirtualChild(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined WebPageVirtualChild
       * @param value WebPageVirtualChild of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByWebPageVirtualChild(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByVirtualParent(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined VirtualParent
       * @param value VirtualParent of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByVirtualParent(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByPFlowRef(org.semanticwb.model.PFlowRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined PFlowRef
       * @param value PFlowRef of the type org.semanticwb.model.PFlowRef
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByPFlowRef(org.semanticwb.model.PFlowRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Market
       * @param value Market of the type org.semanticwb.promexico.Market
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByMarket(org.semanticwb.promexico.Market value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasMarket, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Market
       * @param value Market of the type org.semanticwb.promexico.Market
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByMarket(org.semanticwb.promexico.Market value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasMarket,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Service
       * @param value Service of the type org.semanticwb.promexico.Service
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByService(org.semanticwb.promexico.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(promx_hasService, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined Service
       * @param value Service of the type org.semanticwb.promexico.Service
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByService(org.semanticwb.promexico.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(promx_hasService,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByUserGroupRef(org.semanticwb.model.UserGroupRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined UserGroupRef
       * @param value UserGroupRef of the type org.semanticwb.model.UserGroupRef
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByUserGroupRef(org.semanticwb.model.UserGroupRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByRoleRef(org.semanticwb.model.RoleRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined RoleRef
       * @param value RoleRef of the type org.semanticwb.model.RoleRef
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByRoleRef(org.semanticwb.model.RoleRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByCalendarRef(org.semanticwb.model.CalendarRef value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined CalendarRef
       * @param value CalendarRef of the type org.semanticwb.model.CalendarRef
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByCalendarRef(org.semanticwb.model.CalendarRef value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @param model Model of the org.semanticwb.promexico.Office
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByFriendlyURL(org.semanticwb.model.FriendlyURL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.promexico.Office with a determined FriendlyURL
       * @param value FriendlyURL of the type org.semanticwb.model.FriendlyURL
       * @return Iterator with all the org.semanticwb.promexico.Office
       */

        public static java.util.Iterator<org.semanticwb.promexico.Office> listOfficeByFriendlyURL(org.semanticwb.model.FriendlyURL value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Office> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasFriendlyURL,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a OfficeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Office
   */
    public OfficeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.promexico.ProMxVideo
   * @return A GenericIterator with all the org.semanticwb.promexico.ProMxVideo
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo> listVideos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.ProMxVideo>(getSemanticObject().listObjectProperties(promx_hasVideo));
    }

   /**
   * Gets true if has a Video
   * @param value org.semanticwb.promexico.ProMxVideo to verify
   * @return true if the org.semanticwb.promexico.ProMxVideo exists, false otherwise
   */
    public boolean hasVideo(org.semanticwb.promexico.ProMxVideo value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasVideo,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Video
   * @param value org.semanticwb.promexico.ProMxVideo to add
   */

    public void addVideo(org.semanticwb.promexico.ProMxVideo value)
    {
        getSemanticObject().addObjectProperty(promx_hasVideo, value.getSemanticObject());
    }
   /**
   * Removes all the Video
   */

    public void removeAllVideo()
    {
        getSemanticObject().removeProperty(promx_hasVideo);
    }
   /**
   * Removes a Video
   * @param value org.semanticwb.promexico.ProMxVideo to remove
   */

    public void removeVideo(org.semanticwb.promexico.ProMxVideo value)
    {
        getSemanticObject().removeObjectProperty(promx_hasVideo,value.getSemanticObject());
    }

   /**
   * Gets the Video
   * @return a org.semanticwb.promexico.ProMxVideo
   */
    public org.semanticwb.promexico.ProMxVideo getVideo()
    {
         org.semanticwb.promexico.ProMxVideo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasVideo);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.ProMxVideo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Longitude property
* @return double with the Longitude
*/
    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(promx_longitude);
    }

/**
* Sets the Longitude property
* @param value long with the Longitude
*/
    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(promx_longitude, value);
    }

/**
* Gets the International property
* @return boolean with the International
*/
    public boolean isInternational()
    {
        return getSemanticObject().getBooleanProperty(promx_international);
    }

/**
* Sets the International property
* @param value long with the International
*/
    public void setInternational(boolean value)
    {
        getSemanticObject().setBooleanProperty(promx_international, value);
    }

/**
* Gets the Latitude property
* @return double with the Latitude
*/
    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(promx_latitude);
    }

/**
* Sets the Latitude property
* @param value long with the Latitude
*/
    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(promx_latitude, value);
    }
   /**
   * Gets all the org.semanticwb.promexico.Manager
   * @return A GenericIterator with all the org.semanticwb.promexico.Manager
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager> listManagers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Manager>(getSemanticObject().listObjectProperties(promx_hasManager));
    }

   /**
   * Gets true if has a Manager
   * @param value org.semanticwb.promexico.Manager to verify
   * @return true if the org.semanticwb.promexico.Manager exists, false otherwise
   */
    public boolean hasManager(org.semanticwb.promexico.Manager value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasManager,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Manager
   * @param value org.semanticwb.promexico.Manager to add
   */

    public void addManager(org.semanticwb.promexico.Manager value)
    {
        getSemanticObject().addObjectProperty(promx_hasManager, value.getSemanticObject());
    }
   /**
   * Removes all the Manager
   */

    public void removeAllManager()
    {
        getSemanticObject().removeProperty(promx_hasManager);
    }
   /**
   * Removes a Manager
   * @param value org.semanticwb.promexico.Manager to remove
   */

    public void removeManager(org.semanticwb.promexico.Manager value)
    {
        getSemanticObject().removeObjectProperty(promx_hasManager,value.getSemanticObject());
    }

   /**
   * Gets the Manager
   * @return a org.semanticwb.promexico.Manager
   */
    public org.semanticwb.promexico.Manager getManager()
    {
         org.semanticwb.promexico.Manager ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasManager);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Manager)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the OfficePhoto property
* @return String with the OfficePhoto
*/
    public String getOfficePhoto()
    {
        return getSemanticObject().getProperty(promx_OfficePhoto);
    }

/**
* Sets the OfficePhoto property
* @param value long with the OfficePhoto
*/
    public void setOfficePhoto(String value)
    {
        getSemanticObject().setProperty(promx_OfficePhoto, value);
    }
   /**
   * Gets all the org.semanticwb.promexico.New
   * @return A GenericIterator with all the org.semanticwb.promexico.New
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New> listNewsOfficeInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.New>(getSemanticObject().listObjectProperties(promx_hasNewsOfficeInv));
    }

   /**
   * Gets true if has a NewsOfficeInv
   * @param value org.semanticwb.promexico.New to verify
   * @return true if the org.semanticwb.promexico.New exists, false otherwise
   */
    public boolean hasNewsOfficeInv(org.semanticwb.promexico.New value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasNewsOfficeInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the NewsOfficeInv
   * @return a org.semanticwb.promexico.New
   */
    public org.semanticwb.promexico.New getNewsOfficeInv()
    {
         org.semanticwb.promexico.New ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasNewsOfficeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.New)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.promexico.Market
   * @return A GenericIterator with all the org.semanticwb.promexico.Market
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Market> listMarkets()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Market>(getSemanticObject().listObjectProperties(promx_hasMarket));
    }

   /**
   * Gets true if has a Market
   * @param value org.semanticwb.promexico.Market to verify
   * @return true if the org.semanticwb.promexico.Market exists, false otherwise
   */
    public boolean hasMarket(org.semanticwb.promexico.Market value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasMarket,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Market
   * @param value org.semanticwb.promexico.Market to add
   */

    public void addMarket(org.semanticwb.promexico.Market value)
    {
        getSemanticObject().addObjectProperty(promx_hasMarket, value.getSemanticObject());
    }
   /**
   * Removes all the Market
   */

    public void removeAllMarket()
    {
        getSemanticObject().removeProperty(promx_hasMarket);
    }
   /**
   * Removes a Market
   * @param value org.semanticwb.promexico.Market to remove
   */

    public void removeMarket(org.semanticwb.promexico.Market value)
    {
        getSemanticObject().removeObjectProperty(promx_hasMarket,value.getSemanticObject());
    }

   /**
   * Gets the Market
   * @return a org.semanticwb.promexico.Market
   */
    public org.semanticwb.promexico.Market getMarket()
    {
         org.semanticwb.promexico.Market ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasMarket);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Market)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.promexico.Service
   * @return A GenericIterator with all the org.semanticwb.promexico.Service
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service> listServices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.promexico.Service>(getSemanticObject().listObjectProperties(promx_hasService));
    }

   /**
   * Gets true if has a Service
   * @param value org.semanticwb.promexico.Service to verify
   * @return true if the org.semanticwb.promexico.Service exists, false otherwise
   */
    public boolean hasService(org.semanticwb.promexico.Service value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(promx_hasService,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Service
   * @param value org.semanticwb.promexico.Service to add
   */

    public void addService(org.semanticwb.promexico.Service value)
    {
        getSemanticObject().addObjectProperty(promx_hasService, value.getSemanticObject());
    }
   /**
   * Removes all the Service
   */

    public void removeAllService()
    {
        getSemanticObject().removeProperty(promx_hasService);
    }
   /**
   * Removes a Service
   * @param value org.semanticwb.promexico.Service to remove
   */

    public void removeService(org.semanticwb.promexico.Service value)
    {
        getSemanticObject().removeObjectProperty(promx_hasService,value.getSemanticObject());
    }

   /**
   * Gets the Service
   * @return a org.semanticwb.promexico.Service
   */
    public org.semanticwb.promexico.Service getService()
    {
         org.semanticwb.promexico.Service ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(promx_hasService);
         if(obj!=null)
         {
             ret=(org.semanticwb.promexico.Service)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the ProMexico
   * @return a instance of org.semanticwb.promexico.ProMexico
   */
    public org.semanticwb.promexico.ProMexico getProMexico()
    {
        return (org.semanticwb.promexico.ProMexico)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
