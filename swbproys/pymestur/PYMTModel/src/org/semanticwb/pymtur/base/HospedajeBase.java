package org.semanticwb.pymtur.base;


public abstract class HospedajeBase extends org.semanticwb.pymtur.ServiceProvider implements org.semanticwb.model.Geolocalizable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Rankable,org.semanticwb.portal.community.Contactable,org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Searchable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
    public static final org.semanticwb.platform.SemanticClass pymtur_Hospedaje=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Hospedaje");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Hospedaje");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje>(it, true);
        }

        public static org.semanticwb.pymtur.Hospedaje getHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Hospedaje)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.Hospedaje createHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Hospedaje)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasHospedaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHospedaje(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByService(org.semanticwb.pymtur.Service value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByService(org.semanticwb.pymtur.Service value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasService,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateLowSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateLowSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateLowSeason,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEstablishmentPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByVariantPaqTemplate(org.semanticwb.pymtur.VariantPaqTemplate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_variantPaqTemplate,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestinationSec(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestinationSec(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destinationSec,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySPActivity(org.semanticwb.pymtur.Activity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySPActivity(org.semanticwb.pymtur.Activity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSPActivity,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spCreator,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCupon(org.semanticwb.pymtur.Cupon value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCupon(org.semanticwb.pymtur.Cupon value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasCupon,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeSubDomainWildCard(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeSubDomainWildCard(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeSubDomainWildCard,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByTopicWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByTopicWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirTopicWebPage,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCategoryPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasSpCategoryPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_microSitePymeInv,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalation(org.semanticwb.pymtur.Instalation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalation(org.semanticwb.pymtur.Instalation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalation,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDirectoryResource(org.semanticwb.portal.community.DirectoryResource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_directoryResource,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByProfile(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByProfile(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasDirProfileWebPage,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPromotion(org.semanticwb.pymtur.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPromotion(org.semanticwb.pymtur.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasPromotion,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMorePymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasMorePymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasInstalationsPymePhoto,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByNearest(org.semanticwb.pymtur.Nearest value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByNearest(org.semanticwb.pymtur.Nearest value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasNearest,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestination(org.semanticwb.pymtur.Destination value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestination(org.semanticwb.pymtur.Destination value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_destination,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpVideoYouTube(org.semanticwb.pymtur.VideoYouTube value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_spVideoYouTube,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeDomain(org.semanticwb.model.Dns value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPymeDomain(org.semanticwb.model.Dns value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_pymeDomain,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByWebPage(org.semanticwb.model.WebPage value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByWebPage(org.semanticwb.model.WebPage value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_dirWebPage,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateHighSeason(org.semanticwb.pymtur.RateSeason value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRateHighSeason(org.semanticwb.pymtur.RateSeason value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRateHighSeason,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByComment(org.semanticwb.portal.community.Comment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByComment(org.semanticwb.portal.community.Comment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbcomm_hasComment,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRate(org.semanticwb.pymtur.Rate value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRate(org.semanticwb.pymtur.Rate value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasRate,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public HospedajeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
