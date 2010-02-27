package org.semanticwb.pymtur.base;


public abstract class HospedajeBase extends org.semanticwb.pymtur.ServiceProvider implements org.semanticwb.model.Tagable,org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Rankable,org.semanticwb.portal.community.Addressable,org.semanticwb.portal.community.Contactable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Geolocalizable,org.semanticwb.model.Searchable
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_spRoomPymePhotosComments=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spRoomPymePhotosComments");
    public static final org.semanticwb.platform.SemanticClass pymtur_PymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PymePhoto");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasRoomPymePhoto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasRoomPymePhoto");
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

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalation(org.semanticwb.pymtur.Instalation hasinstalation,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasInstalation, hasinstalation.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalation(org.semanticwb.pymtur.Instalation hasinstalation)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasinstalation.getSemanticObject().getModel().listSubjects(pymtur_hasInstalation,hasinstalation.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByService(org.semanticwb.pymtur.Service hasservice,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasService, hasservice.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByService(org.semanticwb.pymtur.Service hasservice)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasservice.getSemanticObject().getModel().listSubjects(pymtur_hasService,hasservice.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource, directoryresource.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(directoryresource.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource,directoryresource.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage, hasdirprofilewebpage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasdirprofilewebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage,hasdirprofilewebpage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPromotion(org.semanticwb.pymtur.Promotion haspromotion,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasPromotion, haspromotion.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByPromotion(org.semanticwb.pymtur.Promotion haspromotion)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(haspromotion.getSemanticObject().getModel().listSubjects(pymtur_hasPromotion,haspromotion.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMorePymePhoto(org.semanticwb.pymtur.PymePhoto hasmorepymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasMorePymePhoto, hasmorepymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMorePymePhoto(org.semanticwb.pymtur.PymePhoto hasmorepymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasmorepymephoto.getSemanticObject().getModel().listSubjects(pymtur_hasMorePymePhoto,hasmorepymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto hasinstalationspymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasInstalationsPymePhoto, hasinstalationspymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByInstalationsPymePhoto(org.semanticwb.pymtur.PymePhoto hasinstalationspymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasinstalationspymephoto.getSemanticObject().getModel().listSubjects(pymtur_hasInstalationsPymePhoto,hasinstalationspymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByNearest(org.semanticwb.pymtur.Nearest hasnearest,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasNearest, hasnearest.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByNearest(org.semanticwb.pymtur.Nearest hasnearest)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasnearest.getSemanticObject().getModel().listSubjects(pymtur_hasNearest,hasnearest.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestination(org.semanticwb.pymtur.Destination destination,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_destination, destination.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestination(org.semanticwb.pymtur.Destination destination)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(destination.getSemanticObject().getModel().listSubjects(pymtur_destination,destination.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto hasestablishmentpymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasEstablishmentPymePhoto, hasestablishmentpymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByEstablishmentPymePhoto(org.semanticwb.pymtur.PymePhoto hasestablishmentpymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasestablishmentpymephoto.getSemanticObject().getModel().listSubjects(pymtur_hasEstablishmentPymePhoto,hasestablishmentpymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCreator(org.semanticwb.model.User creator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRoomPymePhoto(org.semanticwb.pymtur.PymePhoto hasroompymephoto,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasRoomPymePhoto, hasroompymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRoomPymePhoto(org.semanticwb.pymtur.PymePhoto hasroompymephoto)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasroompymephoto.getSemanticObject().getModel().listSubjects(pymtur_hasRoomPymePhoto,hasroompymephoto.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestinationSec(org.semanticwb.pymtur.Destination destinationsec,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_destinationSec, destinationsec.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByDestinationSec(org.semanticwb.pymtur.Destination destinationsec)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(destinationsec.getSemanticObject().getModel().listSubjects(pymtur_destinationSec,destinationsec.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySPActivity(org.semanticwb.pymtur.Activity hasspactivity,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasSPActivity, hasspactivity.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySPActivity(org.semanticwb.pymtur.Activity hasspactivity)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasspactivity.getSemanticObject().getModel().listSubjects(pymtur_hasSPActivity,hasspactivity.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCreator(org.semanticwb.model.User spcreator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_spCreator, spcreator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeBySpCreator(org.semanticwb.model.User spcreator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(spcreator.getSemanticObject().getModel().listSubjects(pymtur_spCreator,spcreator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCupon(org.semanticwb.pymtur.Cupon hascupon,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasCupon, hascupon.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByCupon(org.semanticwb.pymtur.Cupon hascupon)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hascupon.getSemanticObject().getModel().listSubjects(pymtur_hasCupon,hascupon.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByModifiedBy(org.semanticwb.model.User modifiedby)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByWebPage(org.semanticwb.model.WebPage dirwebpage,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage, dirwebpage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByWebPage(org.semanticwb.model.WebPage dirwebpage)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(dirwebpage.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage,dirwebpage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage, hasdirtopicwebpage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasdirtopicwebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage,hasdirtopicwebpage.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByComment(org.semanticwb.portal.community.Comment hascomment,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasComment, hascomment.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByComment(org.semanticwb.portal.community.Comment hascomment)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hascomment.getSemanticObject().getModel().listSubjects(swbcomm_hasComment,hascomment.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme micrositepymeinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_microSitePymeInv, micrositepymeinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByMicroSitePymeInv(org.semanticwb.pymtur.MicroSitePyme micrositepymeinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(micrositepymeinv.getSemanticObject().getModel().listSubjects(pymtur_microSitePymeInv,micrositepymeinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRate(org.semanticwb.pymtur.Rate hasrate,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasRate, hasrate.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByRate(org.semanticwb.pymtur.Rate hasrate)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasrate.getSemanticObject().getModel().listSubjects(pymtur_hasRate,hasrate.getSemanticObject()));
            return it;
        }
    }

    public HospedajeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getSpRoomPymePhotosComments()
    {
        return getSemanticObject().getProperty(pymtur_spRoomPymePhotosComments);
    }

    public void setSpRoomPymePhotosComments(String value)
    {
        getSemanticObject().setProperty(pymtur_spRoomPymePhotosComments, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto> listRoomPymePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PymePhoto>(getSemanticObject().listObjectProperties(pymtur_hasRoomPymePhoto));
    }

    public boolean hasRoomPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        boolean ret=false;
        if(pymephoto!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasRoomPymePhoto,pymephoto.getSemanticObject());
        }
        return ret;
    }

    public void addRoomPymePhoto(org.semanticwb.pymtur.PymePhoto value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasRoomPymePhoto, value.getSemanticObject());
    }

    public void removeAllRoomPymePhoto()
    {
        getSemanticObject().removeProperty(pymtur_hasRoomPymePhoto);
    }

    public void removeRoomPymePhoto(org.semanticwb.pymtur.PymePhoto pymephoto)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasRoomPymePhoto,pymephoto.getSemanticObject());
    }

    public org.semanticwb.pymtur.PymePhoto getRoomPymePhoto()
    {
         org.semanticwb.pymtur.PymePhoto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasRoomPymePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PymePhoto)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
