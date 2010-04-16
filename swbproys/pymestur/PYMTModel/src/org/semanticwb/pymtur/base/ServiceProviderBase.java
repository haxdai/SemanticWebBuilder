package org.semanticwb.pymtur.base;


public abstract class ServiceProviderBase extends org.semanticwb.portal.community.DirectoryObject implements org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Tagable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.portal.community.Contactable,org.semanticwb.model.Searchable
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
    public static final org.semanticwb.platform.SemanticProperty pymtur_spPromotionsComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spPromotionsComment");
    public static final org.semanticwb.platform.SemanticClass pymtur_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasPromotion");
    public static final org.semanticwb.platform.SemanticClass pymtur_PymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasMorePymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasMorePymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeWebSite");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalationsPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalationsPymePhoto");
    public static final org.semanticwb.platform.SemanticClass pymtur_Nearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Nearest");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasNearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasNearest");
    public static final org.semanticwb.platform.SemanticProperty pymtur_MaxRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MaxRate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeArrive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeArrive");
    public static final org.semanticwb.platform.SemanticProperty pymtur_ladaNacional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#ladaNacional");
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
    public static final org.semanticwb.platform.SemanticProperty pymtur_destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destination");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcSuburb=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcSuburb");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasEstablishmentPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasEstablishmentPymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spRatesComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spRatesComment");
    public static final org.semanticwb.platform.SemanticClass pymtur_VariantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#VariantPaqTemplate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_variantPaqTemplate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#variantPaqTemplate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_NearestDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#NearestDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcInternalNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcInternalNumber");
    public static final org.semanticwb.platform.SemanticProperty pymtur_destinationSec=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destinationSec");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcPersonType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcPersonType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Activity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasSPActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasSPActivity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_SpCategoryPymePhotoCommens=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#SpCategoryPymePhotoCommens");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spActivitiesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spActivitiesDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spEstablishmentPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spEstablishmentPymePhotosComments");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spStatusComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spStatusComment");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spCreator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCreator");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymeDomain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeDomain");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfc");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spServicesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spServicesDescr");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcCity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcCity");
    public static final org.semanticwb.platform.SemanticClass pymtur_Cupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasCupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCupon");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spAcceptedDate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spAcceptedDate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spMorePymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spMorePymePhotosComments");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcZipCode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcZipCode");
    public static final org.semanticwb.platform.SemanticProperty pymtur_MinRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MinRate");
    public static final org.semanticwb.platform.SemanticProperty pymtur_rfcStreet=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#rfcStreet");
    public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsPymePhotosComments");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasSpCategoryPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasSpCategoryPymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_pymePaqueteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymePaqueteType");
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

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalation(org.semanticwb.pymtur.Instalation hasinstalation,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation, hasinstalation.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalation(org.semanticwb.pymtur.Instalation hasinstalation)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasinstalation.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation,hasinstalation.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service hasservice,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService, hasservice.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service hasservice)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasservice.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService,hasservice.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource, directoryresource.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(directoryresource.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource,directoryresource.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage, hasdirprofilewebpage.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasdirprofilewebpage.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage,hasdirprofilewebpage.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion haspromotion,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion, haspromotion.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion haspromotion)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(haspromotion.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion,haspromotion.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto hasmorepymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto, hasmorepymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto hasmorepymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasmorepymephoto.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto,hasmorepymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto hasinstalationspymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto, hasinstalationspymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto hasinstalationspymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasinstalationspymephoto.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto,hasinstalationspymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest hasnearest,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest, hasnearest.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest hasnearest)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasnearest.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest,hasnearest.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination destination,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination, destination.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination destination)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(destination.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination,destination.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto hasestablishmentpymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto, hasestablishmentpymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto hasestablishmentpymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasestablishmentpymephoto.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto,hasestablishmentpymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, creator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User creator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjectsByClass(swb_creator,creator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate variantpaqtemplate,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate, variantpaqtemplate.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate variantpaqtemplate)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(variantpaqtemplate.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate,variantpaqtemplate.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination destinationsec,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec, destinationsec.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination destinationsec)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(destinationsec.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec,destinationsec.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySPActivity(org.semanticwb.pymtur.Activity hasspactivity,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity, hasspactivity.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySPActivity(org.semanticwb.pymtur.Activity hasspactivity)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasspactivity.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity,hasspactivity.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCreator(org.semanticwb.model.User spcreator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator, spcreator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCreator(org.semanticwb.model.User spcreator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(spcreator.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator,spcreator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon hascupon,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon, hascupon.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon hascupon)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hascupon.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon,hascupon.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, modifiedby.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User modifiedby)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,modifiedby.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage dirwebpage,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage, dirwebpage.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage dirwebpage)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(dirwebpage.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage,dirwebpage.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage, hasdirtopicwebpage.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasdirtopicwebpage.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage,hasdirtopicwebpage.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto hasspcategorypymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto, hasspcategorypymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto hasspcategorypymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasspcategorypymephoto.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto,hasspcategorypymephoto.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment hascomment,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment, hascomment.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment hascomment)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hascomment.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment,hascomment.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme micrositepymeinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv, micrositepymeinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme micrositepymeinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(micrositepymeinv.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv,micrositepymeinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate hasrate,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate, hasrate.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate hasrate)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasrate.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate,hasrate.getSemanticObject(),sclass));
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

    public boolean hasInstalation(org.semanticwb.pymtur.Instalation instalation)
    {
        boolean ret=false;
        if(instalation!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasInstalation,instalation.getSemanticObject());
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

    public void removeInstalation(org.semanticwb.pymtur.Instalation instalation)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasInstalation,instalation.getSemanticObject());
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

    public boolean hasService(org.semanticwb.pymtur.Service service)
    {
        boolean ret=false;
        if(service!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasService,service.getSemanticObject());
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

    public void removeService(org.semanticwb.pymtur.Service service)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasService,service.getSemanticObject());
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

    public boolean hasPromotion(org.semanticwb.pymtur.Promotion promotion)
    {
        boolean ret=false;
        if(promotion!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasPromotion,promotion.getSemanticObject());
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

    public void removePromotion(org.semanticwb.pymtur.Promotion promotion)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasPromotion,promotion.getSemanticObject());
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listMorePymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasMorePymePhoto));
    }

    public boolean hasMorePymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        boolean ret=false;
        if(pymephoto!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasMorePymePhoto,pymephoto.getSemanticObject());
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

    public void removeMorePymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasMorePymePhoto,pymephoto.getSemanticObject());
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

    public String getPymeWebSite()
    {
        return getSemanticObject().getProperty(pymtur_pymeWebSite);
    }

    public void setPymeWebSite(String value)
    {
        getSemanticObject().setProperty(pymtur_pymeWebSite, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listInstalationsPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasInstalationsPymePhoto));
    }

    public boolean hasInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        boolean ret=false;
        if(pymephoto!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasInstalationsPymePhoto,pymephoto.getSemanticObject());
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

    public void removeInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasInstalationsPymePhoto,pymephoto.getSemanticObject());
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

    public boolean hasNearest(org.semanticwb.pymtur.Nearest nearest)
    {
        boolean ret=false;
        if(nearest!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasNearest,nearest.getSemanticObject());
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

    public void removeNearest(org.semanticwb.pymtur.Nearest nearest)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasNearest,nearest.getSemanticObject());
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listEstablishmentPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasEstablishmentPymePhoto));
    }

    public boolean hasEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        boolean ret=false;
        if(pymephoto!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasEstablishmentPymePhoto,pymephoto.getSemanticObject());
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

    public void removeEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasEstablishmentPymePhoto,pymephoto.getSemanticObject());
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

    public String getSpRatesComment()
    {
        return getSemanticObject().getProperty(pymtur_spRatesComment);
    }

    public void setSpRatesComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spRatesComment, value);
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity> listSPActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity>(getSemanticObject().listObjectProperties(pymtur_hasSPActivity));
    }

    public boolean hasSPActivity(org.semanticwb.pymtur.Activity activity)
    {
        boolean ret=false;
        if(activity!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasSPActivity,activity.getSemanticObject());
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

    public void removeSPActivity(org.semanticwb.pymtur.Activity activity)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasSPActivity,activity.getSemanticObject());
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

    public String getPymeDomain()
    {
        return getSemanticObject().getProperty(pymtur_pymeDomain);
    }

    public void setPymeDomain(String value)
    {
        getSemanticObject().setProperty(pymtur_pymeDomain, value);
    }

    public String getIntNumber()
    {
        return getSemanticObject().getProperty(swbcomm_intNumber);
    }

    public void setIntNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_intNumber, value);
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

    public boolean hasCupon(org.semanticwb.pymtur.Cupon cupon)
    {
        boolean ret=false;
        if(cupon!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasCupon,cupon.getSemanticObject());
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

    public void removeCupon(org.semanticwb.pymtur.Cupon cupon)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasCupon,cupon.getSemanticObject());
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

    public String getRfcStreet()
    {
        return getSemanticObject().getProperty(pymtur_rfcStreet);
    }

    public void setRfcStreet(String value)
    {
        getSemanticObject().setProperty(pymtur_rfcStreet, value);
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

    public boolean hasSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        boolean ret=false;
        if(pymephoto!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasSpCategoryPymePhoto,pymephoto.getSemanticObject());
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

    public void removeSpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasSpCategoryPymePhoto,pymephoto.getSemanticObject());
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

    public int getPymePaqueteType()
    {
        return getSemanticObject().getIntProperty(pymtur_pymePaqueteType);
    }

    public void setPymePaqueteType(int value)
    {
        getSemanticObject().setIntProperty(pymtur_pymePaqueteType, value);
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

    public boolean hasRate(org.semanticwb.pymtur.Rate rate)
    {
        boolean ret=false;
        if(rate!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRate,rate.getSemanticObject());
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

    public void removeRate(org.semanticwb.pymtur.Rate rate)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRate,rate.getSemanticObject());
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
