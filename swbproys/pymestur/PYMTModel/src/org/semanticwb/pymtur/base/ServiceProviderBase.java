package org.semanticwb.pymtur.base;


public abstract class ServiceProviderBase extends org.semanticwb.portal.community.DirectoryObject implements org.semanticwb.portal.community.Contactable,org.semanticwb.model.Tagable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Geolocalizable,org.semanticwb.model.Rankable,org.semanticwb.model.Searchable
{
       public static final org.semanticwb.platform.SemanticClass pymtur_Instalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Instalation");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalation");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spSlogan=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSlogan");
       public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasService");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spCuponsComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCuponsComment");
       public static final org.semanticwb.platform.SemanticClass pymtur_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Promotion");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasPromotion");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spPromotionsComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spPromotionsComment");
       public static final org.semanticwb.platform.SemanticProperty pymtur_callCenter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#callCenter");
       public static final org.semanticwb.platform.SemanticClass pymtur_PymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasMorePymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasMorePymePhoto");
       public static final org.semanticwb.platform.SemanticProperty pymtur_pymeWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeWebSite");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalationsPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalationsPymePhoto");
       public static final org.semanticwb.platform.SemanticClass pymtur_Nearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Nearest");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasNearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasNearest");
       public static final org.semanticwb.platform.SemanticProperty pymtur_MaxRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MaxRate");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spZipCode=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spZipCode");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsDescr");
       public static final org.semanticwb.platform.SemanticProperty pymtur_pymeArrive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeArrive");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spCity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spCity");
       public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
       public static final org.semanticwb.platform.SemanticProperty pymtur_destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destination");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasEstablishmentPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasEstablishmentPymePhoto");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spRatesComment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spRatesComment");
       public static final org.semanticwb.platform.SemanticProperty pymtur_pymeRfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeRfc");
       public static final org.semanticwb.platform.SemanticProperty pymtur_NearestDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#NearestDescr");
       public static final org.semanticwb.platform.SemanticProperty pymtur_destinationSec=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destinationSec");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spActivitiesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spActivitiesDescr");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spEstablishmentPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spEstablishmentPymePhotosComments");
       public static final org.semanticwb.platform.SemanticProperty pymtur_pymeDomain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeDomain");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spSuburb=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spSuburb");
       public static final org.semanticwb.platform.SemanticProperty pymtur_micrositeCss=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#micrositeCss");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spServicesDescr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spServicesDescr");
       public static final org.semanticwb.platform.SemanticClass pymtur_Cupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasCupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasCupon");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spMorePymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spMorePymePhotosComments");
       public static final org.semanticwb.platform.SemanticProperty pymtur_MinRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MinRate");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spInstalationsPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spInstalationsPymePhotosComments");
       public static final org.semanticwb.platform.SemanticProperty pymtur_Surroundings=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#Surroundings");
       public static final org.semanticwb.platform.SemanticProperty pymtur_pymePaqueteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymePaqueteType");
       public static final org.semanticwb.platform.SemanticClass pymtur_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ActivityRef");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasActivityRef");
       public static final org.semanticwb.platform.SemanticClass pymtur_ExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ExperienceRef");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasExperienceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasExperienceRef");
       public static final org.semanticwb.platform.SemanticClass pymtur_MicroSitePyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MicroSitePyme");
       public static final org.semanticwb.platform.SemanticProperty pymtur_microSitePymeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#microSitePymeInv");
       public static final org.semanticwb.platform.SemanticProperty pymtur_PhotoLogo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoLogo");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spStreet=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spStreet");
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
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasInstalation, hasinstalation.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalation(org.semanticwb.pymtur.Instalation hasinstalation)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasinstalation.getSemanticObject().getModel().listSubjects(pymtur_hasInstalation,hasinstalation.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service hasservice,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasService, hasservice.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByService(org.semanticwb.pymtur.Service hasservice)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasservice.getSemanticObject().getModel().listSubjects(pymtur_hasService,hasservice.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource, directoryresource.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(directoryresource.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource,directoryresource.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage, hasdirprofilewebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasdirprofilewebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage,hasdirprofilewebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion haspromotion,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasPromotion, haspromotion.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPromotion(org.semanticwb.pymtur.Promotion haspromotion)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(haspromotion.getSemanticObject().getModel().listSubjects(pymtur_hasPromotion,haspromotion.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto hasmorepymephoto,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasMorePymePhoto, hasmorepymephoto.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMorePymePhoto(org.semanticwb.pymtur.PymePhoto hasmorepymephoto)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasmorepymephoto.getSemanticObject().getModel().listSubjects(pymtur_hasMorePymePhoto,hasmorepymephoto.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto hasinstalationspymephoto,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasInstalationsPymePhoto, hasinstalationspymephoto.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto hasinstalationspymephoto)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasinstalationspymephoto.getSemanticObject().getModel().listSubjects(pymtur_hasInstalationsPymePhoto,hasinstalationspymephoto.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest hasnearest,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasNearest, hasnearest.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByNearest(org.semanticwb.pymtur.Nearest hasnearest)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasnearest.getSemanticObject().getModel().listSubjects(pymtur_hasNearest,hasnearest.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination destination,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_destination, destination.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestination(org.semanticwb.pymtur.Destination destination)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(destination.getSemanticObject().getModel().listSubjects(pymtur_destination,destination.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto hasestablishmentpymephoto,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasEstablishmentPymePhoto, hasestablishmentpymephoto.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto hasestablishmentpymephoto)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasestablishmentpymephoto.getSemanticObject().getModel().listSubjects(pymtur_hasEstablishmentPymePhoto,hasestablishmentpymephoto.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination destinationsec,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_destinationSec, destinationsec.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByDestinationSec(org.semanticwb.pymtur.Destination destinationsec)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(destinationsec.getSemanticObject().getModel().listSubjects(pymtur_destinationSec,destinationsec.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon hascupon,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasCupon, hascupon.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByCupon(org.semanticwb.pymtur.Cupon hascupon)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hascupon.getSemanticObject().getModel().listSubjects(pymtur_hasCupon,hascupon.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage dirwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage, dirwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByWebPage(org.semanticwb.model.WebPage dirwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(dirwebpage.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage,dirwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage, hasdirtopicwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasdirtopicwebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage,hasdirtopicwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByActivityRef(org.semanticwb.pymtur.ActivityRef hasactivityref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasActivityRef, hasactivityref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByActivityRef(org.semanticwb.pymtur.ActivityRef hasactivityref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasactivityref.getSemanticObject().getModel().listSubjects(pymtur_hasActivityRef,hasactivityref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment hascomment,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasComment, hascomment.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByComment(org.semanticwb.portal.community.Comment hascomment)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hascomment.getSemanticObject().getModel().listSubjects(swbcomm_hasComment,hascomment.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByExperienceRef(org.semanticwb.pymtur.ExperienceRef hasexperienceref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasExperienceRef, hasexperienceref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByExperienceRef(org.semanticwb.pymtur.ExperienceRef hasexperienceref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasexperienceref.getSemanticObject().getModel().listSubjects(pymtur_hasExperienceRef,hasexperienceref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme micrositepymeinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_microSitePymeInv, micrositepymeinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme micrositepymeinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(micrositepymeinv.getSemanticObject().getModel().listSubjects(pymtur_microSitePymeInv,micrositepymeinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate hasrate,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasRate, hasrate.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByRate(org.semanticwb.pymtur.Rate hasrate)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasrate.getSemanticObject().getModel().listSubjects(pymtur_hasRate,hasrate.getSemanticObject()));
       return it;
   }
    }

    public ServiceProviderBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation> listInstalations()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Instalation>(getSemanticObject().listObjectProperties(pymtur_hasInstalation));
    }

    public boolean hasInstalation(org.semanticwb.pymtur.Instalation instalation)
    {
        if(instalation==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasInstalation,instalation.getSemanticObject());
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service> listServices()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Service>(getSemanticObject().listObjectProperties(pymtur_hasService));
    }

    public boolean hasService(org.semanticwb.pymtur.Service service)
    {
        if(service==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasService,service.getSemanticObject());
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion> listPromotions()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Promotion>(getSemanticObject().listObjectProperties(pymtur_hasPromotion));
    }

    public boolean hasPromotion(org.semanticwb.pymtur.Promotion promotion)
    {
        if(promotion==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasPromotion,promotion.getSemanticObject());
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

    public String getSpPromotionsComment()
    {
        return getSemanticObject().getProperty(pymtur_spPromotionsComment);
    }

    public void setSpPromotionsComment(String value)
    {
        getSemanticObject().setProperty(pymtur_spPromotionsComment, value);
    }

    public String getCallCenter()
    {
        return getSemanticObject().getProperty(pymtur_callCenter);
    }

    public void setCallCenter(String value)
    {
        getSemanticObject().setProperty(pymtur_callCenter, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listMorePymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasMorePymePhoto));
    }

    public boolean hasMorePymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        if(pymephoto==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasMorePymePhoto,pymephoto.getSemanticObject());
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
        if(pymephoto==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasInstalationsPymePhoto,pymephoto.getSemanticObject());
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
        if(nearest==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasNearest,nearest.getSemanticObject());
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

    public String getSpZipCode()
    {
        return getSemanticObject().getProperty(pymtur_spZipCode);
    }

    public void setSpZipCode(String value)
    {
        getSemanticObject().setProperty(pymtur_spZipCode, value);
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

    public String getSpCity()
    {
        return getSemanticObject().getProperty(pymtur_spCity);
    }

    public void setSpCity(String value)
    {
        getSemanticObject().setProperty(pymtur_spCity, value);
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listEstablishmentPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasEstablishmentPymePhoto));
    }

    public boolean hasEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        if(pymephoto==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasEstablishmentPymePhoto,pymephoto.getSemanticObject());
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

    public String getPymeDomain()
    {
        return getSemanticObject().getProperty(pymtur_pymeDomain);
    }

    public void setPymeDomain(String value)
    {
        getSemanticObject().setProperty(pymtur_pymeDomain, value);
    }

    public String getSpSuburb()
    {
        return getSemanticObject().getProperty(pymtur_spSuburb);
    }

    public void setSpSuburb(String value)
    {
        getSemanticObject().setProperty(pymtur_spSuburb, value);
    }

    public String getMicrositeCss()
    {
        return getSemanticObject().getProperty(pymtur_micrositeCss);
    }

    public void setMicrositeCss(String value)
    {
        getSemanticObject().setProperty(pymtur_micrositeCss, value);
    }

    public String getSpServicesDescr()
    {
        return getSemanticObject().getProperty(pymtur_spServicesDescr);
    }

    public void setSpServicesDescr(String value)
    {
        getSemanticObject().setProperty(pymtur_spServicesDescr, value);
    }

    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(swb_latitude);
    }

    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_latitude, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon> listCupons()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon>(getSemanticObject().listObjectProperties(pymtur_hasCupon));
    }

    public boolean hasCupon(org.semanticwb.pymtur.Cupon cupon)
    {
        if(cupon==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasCupon,cupon.getSemanticObject());
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

    public String getSpMorePymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spMorePymePhotosComments);
    }

    public void setSpMorePymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spMorePymePhotosComments, value);
    }

    public float getMinRate()
    {
        return getSemanticObject().getFloatProperty(pymtur_MinRate);
    }

    public void setMinRate(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_MinRate, value);
    }

    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(swb_longitude);
    }

    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_longitude, value);
    }

    public String getSpInstalationsPymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spInstalationsPymePhotosComments);
    }

    public void setSpInstalationsPymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spInstalationsPymePhotosComments, value);
    }

    public String getSurroundings()
    {
        return getSemanticObject().getProperty(pymtur_Surroundings);
    }

    public void setSurroundings(String value)
    {
        getSemanticObject().setProperty(pymtur_Surroundings, value);
    }

    public String getContactEmail()
    {
        return getSemanticObject().getProperty(swbcomm_contactEmail);
    }

    public void setContactEmail(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactEmail, value);
    }

    public int getPymePaqueteType()
    {
        return getSemanticObject().getIntProperty(pymtur_pymePaqueteType);
    }

    public void setPymePaqueteType(int value)
    {
        getSemanticObject().setIntProperty(pymtur_pymePaqueteType, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef> listActivityRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ActivityRef>(getSemanticObject().listObjectProperties(pymtur_hasActivityRef));
    }

    public boolean hasActivityRef(org.semanticwb.pymtur.ActivityRef activityref)
    {
        if(activityref==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasActivityRef,activityref.getSemanticObject());
    }

    public void addActivityRef(org.semanticwb.pymtur.ActivityRef value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasActivityRef, value.getSemanticObject());
    }

    public void removeAllActivityRef()
    {
        getSemanticObject().removeProperty(pymtur_hasActivityRef);
    }

    public void removeActivityRef(org.semanticwb.pymtur.ActivityRef activityref)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasActivityRef,activityref.getSemanticObject());
    }


    public org.semanticwb.pymtur.ActivityRef getActivityRef()
    {
         org.semanticwb.pymtur.ActivityRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasActivityRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ActivityRef)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef> listExperienceRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ExperienceRef>(getSemanticObject().listObjectProperties(pymtur_hasExperienceRef));
    }

    public boolean hasExperienceRef(org.semanticwb.pymtur.ExperienceRef experienceref)
    {
        if(experienceref==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasExperienceRef,experienceref.getSemanticObject());
    }

    public void addExperienceRef(org.semanticwb.pymtur.ExperienceRef value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasExperienceRef, value.getSemanticObject());
    }

    public void removeAllExperienceRef()
    {
        getSemanticObject().removeProperty(pymtur_hasExperienceRef);
    }

    public void removeExperienceRef(org.semanticwb.pymtur.ExperienceRef experienceref)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasExperienceRef,experienceref.getSemanticObject());
    }


    public org.semanticwb.pymtur.ExperienceRef getExperienceRef()
    {
         org.semanticwb.pymtur.ExperienceRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasExperienceRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ExperienceRef)obj.createGenericInstance();
         }
         return ret;
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

    public String getSpStreet()
    {
        return getSemanticObject().getProperty(pymtur_spStreet);
    }

    public void setSpStreet(String value)
    {
        getSemanticObject().setProperty(pymtur_spStreet, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate> listRates()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate>(getSemanticObject().listObjectProperties(pymtur_hasRate));
    }

    public boolean hasRate(org.semanticwb.pymtur.Rate rate)
    {
        if(rate==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasRate,rate.getSemanticObject());
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
