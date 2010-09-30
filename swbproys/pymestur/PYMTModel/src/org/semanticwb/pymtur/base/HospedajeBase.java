package org.semanticwb.pymtur.base;


   /**
   * Tipo de serviceprovider. En este momento solo existe hoteleria, cuando existan mas tipos de giros pueden heredar de serviceprovider y tener sus propias propiedades aparte. 
   */
public abstract class HospedajeBase extends org.semanticwb.pymtur.ServiceProvider implements org.semanticwb.portal.community.Contactable,org.semanticwb.model.Rankable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Tagable,org.semanticwb.model.Searchable
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_checkOUT=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#checkOUT");
    public static final org.semanticwb.platform.SemanticProperty pymtur_checkIN=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#checkIN");
   /**
   * Tipo de serviceprovider. En este momento solo existe hoteleria, cuando existan mas tipos de giros pueden heredar de serviceprovider y tener sus propias propiedades aparte.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Hospedaje=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Hospedaje");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Hospedaje");

    public static class ClassMgr
    {
       /**
       * Returns a list of Hospedaje for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Hospedaje for all models
       * @return Iterator of org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.Hospedaje
       * @param id Identifier for org.semanticwb.pymtur.Hospedaje
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return A org.semanticwb.pymtur.Hospedaje
       */
        public static org.semanticwb.pymtur.Hospedaje getHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Hospedaje)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Hospedaje
       * @param id Identifier for org.semanticwb.pymtur.Hospedaje
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return A org.semanticwb.pymtur.Hospedaje
       */
        public static org.semanticwb.pymtur.Hospedaje createHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Hospedaje)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Hospedaje
       * @param id Identifier for org.semanticwb.pymtur.Hospedaje
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       */
        public static void removeHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Hospedaje
       * @param id Identifier for org.semanticwb.pymtur.Hospedaje
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return true if the org.semanticwb.pymtur.Hospedaje exists, false otherwise
       */

        public static boolean hasHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHospedaje(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Service
       * @param value Service of the type org.semanticwb.pymtur.Service
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByService(org.semanticwb.pymtur.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Service
       * @param value Service of the type org.semanticwb.pymtur.Service
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByService(org.semanticwb.pymtur.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined RateLowSeason
       * @param value RateLowSeason of the type org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateLowSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined RateLowSeason
       * @param value RateLowSeason of the type org.semanticwb.pymtur.RateSeason
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateLowSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined EstablishmentPymePhoto
       * @param value EstablishmentPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined EstablishmentPymePhoto
       * @param value EstablishmentPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined VariantPaqTemplate
       * @param value VariantPaqTemplate of the type org.semanticwb.pymtur.VariantPaqTemplate
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined VariantPaqTemplate
       * @param value VariantPaqTemplate of the type org.semanticwb.pymtur.VariantPaqTemplate
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined DestinationSec
       * @param value DestinationSec of the type org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestinationSec(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined DestinationSec
       * @param value DestinationSec of the type org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestinationSec(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SPActivity
       * @param value SPActivity of the type org.semanticwb.pymtur.Activity
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySPActivity(org.semanticwb.pymtur.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SPActivity
       * @param value SPActivity of the type org.semanticwb.pymtur.Activity
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySPActivity(org.semanticwb.pymtur.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SpCreator
       * @param value SpCreator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SpCreator
       * @param value SpCreator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Cupon
       * @param value Cupon of the type org.semanticwb.pymtur.Cupon
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCupon(org.semanticwb.pymtur.Cupon value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Cupon
       * @param value Cupon of the type org.semanticwb.pymtur.Cupon
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCupon(org.semanticwb.pymtur.Cupon value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined PymeSubDomainWildCard
       * @param value PymeSubDomainWildCard of the type org.semanticwb.model.Dns
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeSubDomainWildCard(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined PymeSubDomainWildCard
       * @param value PymeSubDomainWildCard of the type org.semanticwb.model.Dns
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeSubDomainWildCard(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined TopicWebPage
       * @param value TopicWebPage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByTopicWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined TopicWebPage
       * @param value TopicWebPage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByTopicWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined OmnibusLine
       * @param value OmnibusLine of the type org.semanticwb.pymtur.OmnibusLines
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByOmnibusLine(org.semanticwb.pymtur.OmnibusLines value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasOmnibusLine, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined OmnibusLine
       * @param value OmnibusLine of the type org.semanticwb.pymtur.OmnibusLines
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByOmnibusLine(org.semanticwb.pymtur.OmnibusLines value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasOmnibusLine,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SpCategoryPymePhoto
       * @param value SpCategoryPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SpCategoryPymePhoto
       * @param value SpCategoryPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined MicroSitePymeInv
       * @param value MicroSitePymeInv of the type org.semanticwb.pymtur.MicroSitePyme
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined MicroSitePymeInv
       * @param value MicroSitePymeInv of the type org.semanticwb.pymtur.MicroSitePyme
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Instalation
       * @param value Instalation of the type org.semanticwb.pymtur.Instalation
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalation(org.semanticwb.pymtur.Instalation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Instalation
       * @param value Instalation of the type org.semanticwb.pymtur.Instalation
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalation(org.semanticwb.pymtur.Instalation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined DirectoryResource
       * @param value DirectoryResource of the type org.semanticwb.portal.community.DirectoryResource
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined DirectoryResource
       * @param value DirectoryResource of the type org.semanticwb.portal.community.DirectoryResource
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Profile
       * @param value Profile of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByProfile(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Profile
       * @param value Profile of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByProfile(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Promotion
       * @param value Promotion of the type org.semanticwb.pymtur.Promotion
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPromotion(org.semanticwb.pymtur.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Promotion
       * @param value Promotion of the type org.semanticwb.pymtur.Promotion
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPromotion(org.semanticwb.pymtur.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined MorePymePhoto
       * @param value MorePymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined MorePymePhoto
       * @param value MorePymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined InstalationsPymePhoto
       * @param value InstalationsPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined InstalationsPymePhoto
       * @param value InstalationsPymePhoto of the type org.semanticwb.pymtur.PymePhoto
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Nearest
       * @param value Nearest of the type org.semanticwb.pymtur.Nearest
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByNearest(org.semanticwb.pymtur.Nearest value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Nearest
       * @param value Nearest of the type org.semanticwb.pymtur.Nearest
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByNearest(org.semanticwb.pymtur.Nearest value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Destination
       * @param value Destination of the type org.semanticwb.pymtur.Destination
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestination(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Destination
       * @param value Destination of the type org.semanticwb.pymtur.Destination
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestination(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SpVideoYouTube
       * @param value SpVideoYouTube of the type org.semanticwb.pymtur.VideoYouTube
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined SpVideoYouTube
       * @param value SpVideoYouTube of the type org.semanticwb.pymtur.VideoYouTube
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined PymeDomain
       * @param value PymeDomain of the type org.semanticwb.model.Dns
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeDomain(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined PymeDomain
       * @param value PymeDomain of the type org.semanticwb.model.Dns
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeDomain(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined WebPage
       * @param value WebPage of the type org.semanticwb.model.WebPage
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined RateHighSeason
       * @param value RateHighSeason of the type org.semanticwb.pymtur.RateSeason
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateHighSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined RateHighSeason
       * @param value RateHighSeason of the type org.semanticwb.pymtur.RateSeason
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateHighSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Certificate
       * @param value Certificate of the type org.semanticwb.pymtur.Certificates
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCertificate(org.semanticwb.pymtur.Certificates value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCertificate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Certificate
       * @param value Certificate of the type org.semanticwb.pymtur.Certificates
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCertificate(org.semanticwb.pymtur.Certificates value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCertificate,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Comment
       * @param value Comment of the type org.semanticwb.portal.community.Comment
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByComment(org.semanticwb.portal.community.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Comment
       * @param value Comment of the type org.semanticwb.portal.community.Comment
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByComment(org.semanticwb.portal.community.Comment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Rate
       * @param value Rate of the type org.semanticwb.pymtur.Rate
       * @param model Model of the org.semanticwb.pymtur.Hospedaje
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRate(org.semanticwb.pymtur.Rate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Hospedaje with a determined Rate
       * @param value Rate of the type org.semanticwb.pymtur.Rate
       * @return Iterator with all the org.semanticwb.pymtur.Hospedaje
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRate(org.semanticwb.pymtur.Rate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a HospedajeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Hospedaje
   */
    public HospedajeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the CheckOUT property
* @return String with the CheckOUT
*/
    public String getCheckOUT()
    {
        return getSemanticObject().getProperty(pymtur_checkOUT);
    }

/**
* Sets the CheckOUT property
* @param value long with the CheckOUT
*/
    public void setCheckOUT(String value)
    {
        getSemanticObject().setProperty(pymtur_checkOUT, value);
    }

/**
* Gets the CheckIN property
* @return String with the CheckIN
*/
    public String getCheckIN()
    {
        return getSemanticObject().getProperty(pymtur_checkIN);
    }

/**
* Sets the CheckIN property
* @param value long with the CheckIN
*/
    public void setCheckIN(String value)
    {
        getSemanticObject().setProperty(pymtur_checkIN, value);
    }

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
