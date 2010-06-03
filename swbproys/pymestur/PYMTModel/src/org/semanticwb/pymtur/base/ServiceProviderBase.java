package org.semanticwb.pymtur.base;


public abstract class ServiceProviderBase extends org.semanticwb.portal.community.DirectoryObject implements org.semanticwb.model.Traceable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Tagable,org.semanticwb.model.Rankable,org.semanticwb.portal.community.Contactable,org.semanticwb.model.Searchable,org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTotPhotos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTotPhotos");
    public static final org.semanticwb.platform.SemanticClass pymtur_Instalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Instalation");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalation");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spSlogan=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSlogan");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spStatus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spStatus");
    public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasService");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCuponsComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCuponsComment");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcExternalNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcExternalNumber");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcRazonSocial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcRazonSocial");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcCityCouncil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcCityCouncil");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcState=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcState");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spPromotionsComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spPromotionsComment");
    public static final org.semanticwb.platform.SemanticClass pymtur_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasPromotion");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spReservationPhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spReservationPhone");
    public static final org.semanticwb.platform.SemanticClass pymtur_PymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasMorePymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasMorePymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_contactSecondName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#contactSecondName");
    public static final org.semanticwb.platform.SemanticProperty pymtur_sp_zipcode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#sp_zipcode");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeWebSite");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCelularPhone=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCelularPhone");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spEndAnnuncePeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spEndAnnuncePeriod");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalationsPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalationsPymePhoto");
    public static final org.semanticwb.platform.SemanticClass pymtur_Nearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Nearest");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasNearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasNearest");
    public static final org.semanticwb.platform.SemanticProperty pymtur_MaxRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MaxRate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeArrive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeArrive");
    public static final org.semanticwb.platform.SemanticProperty pymtur_ladaNacional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#ladaNacional");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spFacebookUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spFacebookUser");
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
    public static final org.semanticwb.platform.SemanticProperty pymtur_destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destination");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcSuburb=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcSuburb");
    public static final org.semanticwb.platform.SemanticClass pymtur_VideoYouTube=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VideoYouTube");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spVideoYouTube=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spVideoYouTube");
    public static final org.semanticwb.platform.SemanticClass pymtur_RateSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RateSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasRateLowSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasRateLowSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasEstablishmentPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasEstablishmentPymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spContractPeiod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spContractPeiod");
    public static final org.semanticwb.platform.SemanticClass pymtur_VariantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VariantPaqTemplate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_variantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#variantPaqTemplate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_NearestDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#NearestDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcInternalNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcInternalNumber");
    public static final org.semanticwb.platform.SemanticProperty pymtur_destinationSec=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destinationSec");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcPersonType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcPersonType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTwitterUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTwitterUser");
    public static final org.semanticwb.platform.SemanticClass pymtur_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Activity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasSPActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasSPActivity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_SpCategoryPymePhotoCommens=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#SpCategoryPymePhotoCommens");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spActivitiesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spActivitiesDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spEstablishmentPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spEstablishmentPymePhotosComments");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spStatusComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spStatusComment");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCreator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCreator");
    public static final org.semanticwb.platform.SemanticClass swb_Dns=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Dns");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeDomain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeDomain");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spSuburb=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSuburb");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spYouTubeChannel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spYouTubeChannel");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfc");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spServicesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spServicesDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTotPromotions=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTotPromotions");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcCity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcCity");
    public static final org.semanticwb.platform.SemanticClass pymtur_Cupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasCupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCupon");
    public static final org.semanticwb.platform.SemanticProperty pymtur_contactFirstName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#contactFirstName");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spAcceptedDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spAcceptedDate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spMorePymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spMorePymePhotosComments");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcZipCode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcZipCode");
    public static final org.semanticwb.platform.SemanticProperty pymtur_MinRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MinRate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spRatesComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spRatesComments");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcStreet=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcStreet");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeSubDomainWildCard=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeSubDomainWildCard");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spTotCupones=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spTotCupones");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsPymePhotosComments");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasSpCategoryPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasSpCategoryPymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasRateHighSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasRateHighSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymePaqueteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymePaqueteType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spSkypeAccount=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSkypeAccount");
    public static final org.semanticwb.platform.SemanticClass pymtur_MicroSitePyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MicroSitePyme");
    public static final org.semanticwb.platform.SemanticProperty pymtur_microSitePymeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#microSitePymeInv");
    public static final org.semanticwb.platform.SemanticProperty pymtur_PhotoLogo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoLogo");
    public static final org.semanticwb.platform.SemanticClass pymtur_Rate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Rate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasRate");
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(it, true);
        }

        public static org.semanticwb.pymtur.ServiceProvider getServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.ServiceProvider)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.ServiceProvider createServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.ServiceProvider)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasServiceProvider(String id, org.semanticwb.model.SWBModel model)
        {
            return (getServiceProvider(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalation(org.semanticwb.pymtur.Instalation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalation(org.semanticwb.pymtur.Instalation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateLowSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateLowSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySPActivity(org.semanticwb.pymtur.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySPActivity(org.semanticwb.pymtur.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeDomain(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeDomain(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeSubDomainWildCard(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPymeSubDomainWildCard(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateHighSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRateHighSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public ServiceProviderBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getExtNumber()
    {
        return getSemanticObject().getProperty(swbcomm_extNumber);
    }

    public void setExtNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_extNumber, value);
    }

    public int getSpTotPhotos()
    {
        return getSemanticObject().getIntProperty(pymtur_spTotPhotos);
    }

    public void setSpTotPhotos(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spTotPhotos, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation> listInstalations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation>(getSemanticObject().listObjectProperties(pymtur_hasInstalation));
    }

    public boolean hasInstalation(org.semanticwb.pymtur.Instalation value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasInstalation,value.getSemanticObject());
        }
        return ret;
    }

    public void addInstalation(org.semanticwb.pymtur.Instalation value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasInstalation, value.getSemanticObject());
    }

    public void removeAllInstalation()
    {
        getSemanticObject().removeProperty(pymtur_hasInstalation);
    }

    public void removeInstalation(org.semanticwb.pymtur.Instalation value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasInstalation,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.Instalation getInstalation()
    {
         org.semanticwb.pymtur.Instalation ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasInstalation);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Instalation)obj.createGenericInstance();
         }
         return ret;
    }

    public String getSpSlogan()
    {
        return getSemanticObject().getProperty(pymtur_spSlogan);
    }

    public void setSpSlogan(String value)
    {
        getSemanticObject().setProperty(pymtur_spSlogan, value);
    }

    public int getSpStatus()
    {
        return getSemanticObject().getIntProperty(pymtur_spStatus);
    }

    public void setSpStatus(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spStatus, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> listServices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service>(getSemanticObject().listObjectProperties(pymtur_hasService));
    }

    public boolean hasService(org.semanticwb.pymtur.Service value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasService,value.getSemanticObject());
        }
        return ret;
    }

    public void addService(org.semanticwb.pymtur.Service value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasService, value.getSemanticObject());
    }

    public void removeAllService()
    {
        getSemanticObject().removeProperty(pymtur_hasService);
    }

    public void removeService(org.semanticwb.pymtur.Service value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasService,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.Service getService()
    {
         org.semanticwb.pymtur.Service ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasService);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Service)obj.createGenericInstance();
         }
         return ret;
    }

    public String getContactName()
    {
        return getSemanticObject().getProperty(swbcomm_contactName);
    }

    public void setContactName(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactName, value);
    }

    public String getSpCuponsComment()
    {
        return getSemanticObject().getProperty(pymtur_spCuponsComment);
    }

    public void setSpCuponsComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spCuponsComment, value);
    }

    public String getRfcExternalNumber()
    {
        return getSemanticObject().getProperty(pymtur_rfcExternalNumber);
    }

    public void setRfcExternalNumber(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcExternalNumber, value);
    }

    public String getRfcRazonSocial()
    {
        return getSemanticObject().getProperty(pymtur_rfcRazonSocial);
    }

    public void setRfcRazonSocial(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcRazonSocial, value);
    }

    public String getRfcCityCouncil()
    {
        return getSemanticObject().getProperty(pymtur_rfcCityCouncil);
    }

    public void setRfcCityCouncil(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcCityCouncil, value);
    }

    public String getRfcState()
    {
        return getSemanticObject().getProperty(pymtur_rfcState);
    }

    public void setRfcState(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcState, value);
    }

    public String getSpPromotionsComment()
    {
        return getSemanticObject().getProperty(pymtur_spPromotionsComment);
    }

    public void setSpPromotionsComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spPromotionsComment, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion> listPromotions()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion>(getSemanticObject().listObjectProperties(pymtur_hasPromotion));
    }

    public boolean hasPromotion(org.semanticwb.pymtur.Promotion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasPromotion,value.getSemanticObject());
        }
        return ret;
    }

    public void addPromotion(org.semanticwb.pymtur.Promotion value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasPromotion, value.getSemanticObject());
    }

    public void removeAllPromotion()
    {
        getSemanticObject().removeProperty(pymtur_hasPromotion);
    }

    public void removePromotion(org.semanticwb.pymtur.Promotion value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasPromotion,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.Promotion getPromotion()
    {
         org.semanticwb.pymtur.Promotion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasPromotion);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Promotion)obj.createGenericInstance();
         }
         return ret;
    }

    public String getSpReservationPhone()
    {
        return getSemanticObject().getProperty(pymtur_spReservationPhone);
    }

    public void setSpReservationPhone(String value)
    {
        getSemanticObject().setProperty(pymtur_spReservationPhone, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listMorePymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasMorePymePhoto));
    }

    public boolean hasMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasMorePymePhoto,value.getSemanticObject());
        }
        return ret;
    }

    public void addMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasMorePymePhoto, value.getSemanticObject());
    }

    public void removeAllMorePymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasMorePymePhoto);
    }

    public void removeMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasMorePymePhoto,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.PymePhoto getMorePymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasMorePymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }

    public String getState()
    {
        return getSemanticObject().getProperty(swbcomm_state);
    }

    public void setState(String value)
    {
        getSemanticObject().setProperty(swbcomm_state, value);
    }

    public String getContactSecondName()
    {
        return getSemanticObject().getProperty(pymtur_contactSecondName);
    }

    public void setContactSecondName(String value)
    {
        getSemanticObject().setProperty(pymtur_contactSecondName, value);
    }

    public String getSp_zipcode()
    {
        return getSemanticObject().getProperty(pymtur_sp_zipcode);
    }

    public void setSp_zipcode(String value)
    {
        getSemanticObject().setProperty(pymtur_sp_zipcode, value);
    }

    public String getPymeWebSite()
    {
        return getSemanticObject().getProperty(pymtur_pymeWebSite);
    }

    public void setPymeWebSite(String value)
    {
        getSemanticObject().setProperty(pymtur_pymeWebSite, value);
    }

    public String getSpCelularPhone()
    {
        return getSemanticObject().getProperty(pymtur_spCelularPhone);
    }

    public void setSpCelularPhone(String value)
    {
        getSemanticObject().setProperty(pymtur_spCelularPhone, value);
    }

    public java.util.Date getSpEndAnnuncePeriod()
    {
        return getSemanticObject().getDateProperty(pymtur_spEndAnnuncePeriod);
    }

    public void setSpEndAnnuncePeriod(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_spEndAnnuncePeriod, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listInstalationsPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasInstalationsPymePhoto));
    }

    public boolean hasInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasInstalationsPymePhoto,value.getSemanticObject());
        }
        return ret;
    }

    public void addInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasInstalationsPymePhoto, value.getSemanticObject());
    }

    public void removeAllInstalationsPymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasInstalationsPymePhoto);
    }

    public void removeInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasInstalationsPymePhoto,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.PymePhoto getInstalationsPymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasInstalationsPymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Nearest> listNearests()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Nearest>(getSemanticObject().listObjectProperties(pymtur_hasNearest));
    }

    public boolean hasNearest(org.semanticwb.pymtur.Nearest value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasNearest,value.getSemanticObject());
        }
        return ret;
    }

    public void addNearest(org.semanticwb.pymtur.Nearest value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasNearest, value.getSemanticObject());
    }

    public void removeAllNearest()
    {
        getSemanticObject().removeProperty(pymtur_hasNearest);
    }

    public void removeNearest(org.semanticwb.pymtur.Nearest value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasNearest,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.Nearest getNearest()
    {
         org.semanticwb.pymtur.Nearest ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasNearest);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Nearest)obj.createGenericInstance();
         }
         return ret;
    }

    public float getMaxRate()
    {
        return getSemanticObject().getFloatProperty(pymtur_MaxRate);
    }

    public void setMaxRate(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_MaxRate, value);
    }

    public String getSpInstalationsDescr()
    {
        return getSemanticObject().getProperty(pymtur_spInstalationsDescr);
    }

    public void setSpInstalationsDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_spInstalationsDescr, value);
    }

    public String getPymeArrive()
    {
        return getSemanticObject().getProperty(pymtur_pymeArrive);
    }

    public void setPymeArrive(String value)
    {
        getSemanticObject().setProperty(pymtur_pymeArrive, value);
    }

    public String getLadaNacional()
    {
        return getSemanticObject().getProperty(pymtur_ladaNacional);
    }

    public void setLadaNacional(String value)
    {
        getSemanticObject().setProperty(pymtur_ladaNacional, value);
    }

    public String getCity()
    {
        return getSemanticObject().getProperty(swbcomm_city);
    }

    public void setCity(String value)
    {
        getSemanticObject().setProperty(swbcomm_city, value);
    }

    public String getSpFacebookUser()
    {
        return getSemanticObject().getProperty(pymtur_spFacebookUser);
    }

    public void setSpFacebookUser(String value)
    {
        getSemanticObject().setProperty(pymtur_spFacebookUser, value);
    }

    public void setDestination(org.semanticwb.pymtur.Destination value)
    {
        getSemanticObject().setObjectProperty(pymtur_destination, value.getSemanticObject());
    }

    public void removeDestination()
    {
        getSemanticObject().removeProperty(pymtur_destination);
    }

    public org.semanticwb.pymtur.Destination getDestination()
    {
         org.semanticwb.pymtur.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_destination);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Destination)obj.createGenericInstance();
         }
         return ret;
    }

    public String getRfcSuburb()
    {
        return getSemanticObject().getProperty(pymtur_rfcSuburb);
    }

    public void setRfcSuburb(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcSuburb, value);
    }

    public void setSpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value)
    {
        getSemanticObject().setObjectProperty(pymtur_spVideoYouTube, value.getSemanticObject());
    }

    public void removeSpVideoYouTube()
    {
        getSemanticObject().removeProperty(pymtur_spVideoYouTube);
    }

    public org.semanticwb.pymtur.VideoYouTube getSpVideoYouTube()
    {
         org.semanticwb.pymtur.VideoYouTube ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_spVideoYouTube);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.VideoYouTube)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason> listRateLowSeasons()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(getSemanticObject().listObjectProperties(pymtur_hasRateLowSeason));
    }

    public boolean hasRateLowSeason(org.semanticwb.pymtur.RateSeason value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRateLowSeason,value.getSemanticObject());
        }
        return ret;
    }

    public void addRateLowSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasRateLowSeason, value.getSemanticObject());
    }

    public void removeAllRateLowSeason()
    {
        getSemanticObject().removeProperty(pymtur_hasRateLowSeason);
    }

    public void removeRateLowSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRateLowSeason,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.RateSeason getRateLowSeason()
    {
         org.semanticwb.pymtur.RateSeason ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasRateLowSeason);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.RateSeason)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listEstablishmentPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasEstablishmentPymePhoto));
    }

    public boolean hasEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject());
        }
        return ret;
    }

    public void addEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasEstablishmentPymePhoto, value.getSemanticObject());
    }

    public void removeAllEstablishmentPymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasEstablishmentPymePhoto);
    }

    public void removeEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.PymePhoto getEstablishmentPymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasEstablishmentPymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }

    public void setVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value)
    {
        getSemanticObject().setObjectProperty(pymtur_variantPaqTemplate, value.getSemanticObject());
    }

    public void removeVariantPaqTemplate()
    {
        getSemanticObject().removeProperty(pymtur_variantPaqTemplate);
    }

    public org.semanticwb.pymtur.VariantPaqTemplate getVariantPaqTemplate()
    {
         org.semanticwb.pymtur.VariantPaqTemplate ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_variantPaqTemplate);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.VariantPaqTemplate)obj.createGenericInstance();
         }
         return ret;
    }

    public String getNearestDescr()
    {
        return getSemanticObject().getProperty(pymtur_NearestDescr);
    }

    public void setNearestDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_NearestDescr, value);
    }

    public String getContactPhoneNumber()
    {
        return getSemanticObject().getProperty(swbcomm_contactPhoneNumber);
    }

    public void setContactPhoneNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactPhoneNumber, value);
    }

    public String getRfcInternalNumber()
    {
        return getSemanticObject().getProperty(pymtur_rfcInternalNumber);
    }

    public void setRfcInternalNumber(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcInternalNumber, value);
    }

    public void setDestinationSec(org.semanticwb.pymtur.Destination value)
    {
        getSemanticObject().setObjectProperty(pymtur_destinationSec, value.getSemanticObject());
    }

    public void removeDestinationSec()
    {
        getSemanticObject().removeProperty(pymtur_destinationSec);
    }

    public org.semanticwb.pymtur.Destination getDestinationSec()
    {
         org.semanticwb.pymtur.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_destinationSec);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Destination)obj.createGenericInstance();
         }
         return ret;
    }

    public String getRfcPersonType()
    {
        return getSemanticObject().getProperty(pymtur_rfcPersonType);
    }

    public void setRfcPersonType(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcPersonType, value);
    }

    public String getSpTwitterUser()
    {
        return getSemanticObject().getProperty(pymtur_spTwitterUser);
    }

    public void setSpTwitterUser(String value)
    {
        getSemanticObject().setProperty(pymtur_spTwitterUser, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity> listSPActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity>(getSemanticObject().listObjectProperties(pymtur_hasSPActivity));
    }

    public boolean hasSPActivity(org.semanticwb.pymtur.Activity value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasSPActivity,value.getSemanticObject());
        }
        return ret;
    }

    public void addSPActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasSPActivity, value.getSemanticObject());
    }

    public void removeAllSPActivity()
    {
        getSemanticObject().removeProperty(pymtur_hasSPActivity);
    }

    public void removeSPActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasSPActivity,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.Activity getSPActivity()
    {
         org.semanticwb.pymtur.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasSPActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Activity)obj.createGenericInstance();
         }
         return ret;
    }

    public String getSpCategoryPymePhotoCommens()
    {
        return getSemanticObject().getProperty(pymtur_SpCategoryPymePhotoCommens);
    }

    public void setSpCategoryPymePhotoCommens(String value)
    {
        getSemanticObject().setProperty(pymtur_SpCategoryPymePhotoCommens, value);
    }

    public String getSpActivitiesDescr()
    {
        return getSemanticObject().getProperty(pymtur_spActivitiesDescr);
    }

    public void setSpActivitiesDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_spActivitiesDescr, value);
    }

    public int getStep()
    {
        return getSemanticObject().getIntProperty(swb_geoStep);
    }

    public void setStep(int value)
    {
        getSemanticObject().setIntProperty(swb_geoStep, value);
    }

    public String getSpEstablishmentPymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spEstablishmentPymePhotosComments);
    }

    public void setSpEstablishmentPymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spEstablishmentPymePhotosComments, value);
    }

    public String getSpStatusComment()
    {
        return getSemanticObject().getProperty(pymtur_spStatusComment);
    }

    public void setSpStatusComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spStatusComment, value);
    }

    public void setSpCreator(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(pymtur_spCreator, value.getSemanticObject());
    }

    public void removeSpCreator()
    {
        getSemanticObject().removeProperty(pymtur_spCreator);
    }

    public org.semanticwb.model.User getSpCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_spCreator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public void setPymeDomain(org.semanticwb.model.Dns value)
    {
        getSemanticObject().setObjectProperty(pymtur_pymeDomain, value.getSemanticObject());
    }

    public void removePymeDomain()
    {
        getSemanticObject().removeProperty(pymtur_pymeDomain);
    }

    public org.semanticwb.model.Dns getPymeDomain()
    {
         org.semanticwb.model.Dns ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_pymeDomain);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Dns)obj.createGenericInstance();
         }
         return ret;
    }

    public String getIntNumber()
    {
        return getSemanticObject().getProperty(swbcomm_intNumber);
    }

    public void setIntNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_intNumber, value);
    }

    public String getSpSuburb()
    {
        return getSemanticObject().getProperty(pymtur_spSuburb);
    }

    public void setSpSuburb(String value)
    {
        getSemanticObject().setProperty(pymtur_spSuburb, value);
    }

    public String getSpYouTubeChannel()
    {
        return getSemanticObject().getProperty(pymtur_spYouTubeChannel);
    }

    public void setSpYouTubeChannel(String value)
    {
        getSemanticObject().setProperty(pymtur_spYouTubeChannel, value);
    }

    public String getRfc()
    {
        return getSemanticObject().getProperty(pymtur_rfc);
    }

    public void setRfc(String value)
    {
        getSemanticObject().setProperty(pymtur_rfc, value);
    }

    public String getSpServicesDescr()
    {
        return getSemanticObject().getProperty(pymtur_spServicesDescr);
    }

    public void setSpServicesDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_spServicesDescr, value);
    }

    public int getSpTotPromotions()
    {
        return getSemanticObject().getIntProperty(pymtur_spTotPromotions);
    }

    public void setSpTotPromotions(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spTotPromotions, value);
    }

    public String getRfcCity()
    {
        return getSemanticObject().getProperty(pymtur_rfcCity);
    }

    public void setRfcCity(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcCity, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon> listCupons()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon>(getSemanticObject().listObjectProperties(pymtur_hasCupon));
    }

    public boolean hasCupon(org.semanticwb.pymtur.Cupon value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasCupon,value.getSemanticObject());
        }
        return ret;
    }

    public void addCupon(org.semanticwb.pymtur.Cupon value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasCupon, value.getSemanticObject());
    }

    public void removeAllCupon()
    {
        getSemanticObject().removeProperty(pymtur_hasCupon);
    }

    public void removeCupon(org.semanticwb.pymtur.Cupon value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasCupon,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.Cupon getCupon()
    {
         org.semanticwb.pymtur.Cupon ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasCupon);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Cupon)obj.createGenericInstance();
         }
         return ret;
    }

    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(swb_latitude);
    }

    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_latitude, value);
    }

    public String getContactFirstName()
    {
        return getSemanticObject().getProperty(pymtur_contactFirstName);
    }

    public void setContactFirstName(String value)
    {
        getSemanticObject().setProperty(pymtur_contactFirstName, value);
    }

    public java.util.Date getSpAcceptedDate()
    {
        return getSemanticObject().getDateProperty(pymtur_spAcceptedDate);
    }

    public void setSpAcceptedDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(pymtur_spAcceptedDate, value);
    }

    public String getSpMorePymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spMorePymePhotosComments);
    }

    public void setSpMorePymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spMorePymePhotosComments, value);
    }

    public String getRfcZipCode()
    {
        return getSemanticObject().getProperty(pymtur_rfcZipCode);
    }

    public void setRfcZipCode(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcZipCode, value);
    }

    public float getMinRate()
    {
        return getSemanticObject().getFloatProperty(pymtur_MinRate);
    }

    public void setMinRate(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_MinRate, value);
    }

    public String getSpRatesComments()
    {
        return getSemanticObject().getProperty(pymtur_spRatesComments);
    }

    public void setSpRatesComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spRatesComments, value);
    }

    public String getRfcStreet()
    {
        return getSemanticObject().getProperty(pymtur_rfcStreet);
    }

    public void setRfcStreet(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcStreet, value);
    }

    public void setPymeSubDomainWildCard(org.semanticwb.model.Dns value)
    {
        getSemanticObject().setObjectProperty(pymtur_pymeSubDomainWildCard, value.getSemanticObject());
    }

    public void removePymeSubDomainWildCard()
    {
        getSemanticObject().removeProperty(pymtur_pymeSubDomainWildCard);
    }

    public org.semanticwb.model.Dns getPymeSubDomainWildCard()
    {
         org.semanticwb.model.Dns ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_pymeSubDomainWildCard);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Dns)obj.createGenericInstance();
         }
         return ret;
    }

    public int getSpTotCupones()
    {
        return getSemanticObject().getIntProperty(pymtur_spTotCupones);
    }

    public void setSpTotCupones(int value)
    {
        getSemanticObject().setIntProperty(pymtur_spTotCupones, value);
    }

    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(swb_longitude);
    }

    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_longitude, value);
    }

    public String getStreetName()
    {
        return getSemanticObject().getProperty(swbcomm_streetName);
    }

    public void setStreetName(String value)
    {
        getSemanticObject().setProperty(swbcomm_streetName, value);
    }

    public String getSpInstalationsPymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spInstalationsPymePhotosComments);
    }

    public void setSpInstalationsPymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spInstalationsPymePhotosComments, value);
    }

    public String getCityCouncil()
    {
        return getSemanticObject().getProperty(swbcomm_cityCouncil);
    }

    public void setCityCouncil(String value)
    {
        getSemanticObject().setProperty(swbcomm_cityCouncil, value);
    }

    public String getContactEmail()
    {
        return getSemanticObject().getProperty(swbcomm_contactEmail);
    }

    public void setContactEmail(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactEmail, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listSpCategoryPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasSpCategoryPymePhoto));
    }

    public boolean hasSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject());
        }
        return ret;
    }

    public void addSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasSpCategoryPymePhoto, value.getSemanticObject());
    }

    public void removeAllSpCategoryPymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasSpCategoryPymePhoto);
    }

    public void removeSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.PymePhoto getSpCategoryPymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasSpCategoryPymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason> listRateHighSeasons()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RateSeason>(getSemanticObject().listObjectProperties(pymtur_hasRateHighSeason));
    }

    public boolean hasRateHighSeason(org.semanticwb.pymtur.RateSeason value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRateHighSeason,value.getSemanticObject());
        }
        return ret;
    }

    public void addRateHighSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasRateHighSeason, value.getSemanticObject());
    }

    public void removeAllRateHighSeason()
    {
        getSemanticObject().removeProperty(pymtur_hasRateHighSeason);
    }

    public void removeRateHighSeason(org.semanticwb.pymtur.RateSeason value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRateHighSeason,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.RateSeason getRateHighSeason()
    {
         org.semanticwb.pymtur.RateSeason ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasRateHighSeason);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.RateSeason)obj.createGenericInstance();
         }
         return ret;
    }

    public int getPymePaqueteType()
    {
        return getSemanticObject().getIntProperty(pymtur_pymePaqueteType);
    }

    public void setPymePaqueteType(int value)
    {
        getSemanticObject().setIntProperty(pymtur_pymePaqueteType, value);
    }

    public String getSpSkypeAccount()
    {
        return getSemanticObject().getProperty(pymtur_spSkypeAccount);
    }

    public void setSpSkypeAccount(String value)
    {
        getSemanticObject().setProperty(pymtur_spSkypeAccount, value);
    }

    public void setMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value)
    {
        getSemanticObject().setObjectProperty(pymtur_microSitePymeInv, value.getSemanticObject());
    }

    public void removeMicroSitePymeInv()
    {
        getSemanticObject().removeProperty(pymtur_microSitePymeInv);
    }

    public org.semanticwb.pymtur.MicroSitePyme getMicroSitePymeInv()
    {
         org.semanticwb.pymtur.MicroSitePyme ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_microSitePymeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.MicroSitePyme)obj.createGenericInstance();
         }
         return ret;
    }

    public String getPhotoLogo()
    {
        return getSemanticObject().getProperty(pymtur_PhotoLogo);
    }

    public void setPhotoLogo(String value)
    {
        getSemanticObject().setProperty(pymtur_PhotoLogo, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate> listRates()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate>(getSemanticObject().listObjectProperties(pymtur_hasRate));
    }

    public boolean hasRate(org.semanticwb.pymtur.Rate value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRate,value.getSemanticObject());
        }
        return ret;
    }

    public void addRate(org.semanticwb.pymtur.Rate value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasRate, value.getSemanticObject());
    }

    public void removeAllRate()
    {
        getSemanticObject().removeProperty(pymtur_hasRate);
    }

    public void removeRate(org.semanticwb.pymtur.Rate value)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRate,value.getSemanticObject());
    }

    public org.semanticwb.pymtur.Rate getRate()
    {
         org.semanticwb.pymtur.Rate ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasRate);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Rate)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
