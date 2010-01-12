package org.semanticwb.pymtur.base;


public abstract class HospedajeBase extends org.semanticwb.pymtur.ServiceProvider implements org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Rankable,org.semanticwb.model.Tagable
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

       public static org.semanticwb.pymtur.Hospedaje createHospedaje(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.pymtur.Hospedaje.ClassMgr.createHospedaje(String.valueOf(id), model);
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
   public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByActivityRef(org.semanticwb.pymtur.ActivityRef hasactivityref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasActivityRef, hasactivityref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Hospedaje> listHospedajeByActivityRef(org.semanticwb.pymtur.ActivityRef hasactivityref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Hospedaje> it=new org.semanticwb.model.GenericIterator(hasactivityref.getSemanticObject().getModel().listSubjects(pymtur_hasActivityRef,hasactivityref.getSemanticObject()));
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
