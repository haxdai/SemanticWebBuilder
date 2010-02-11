package org.semanticwb.pymtur.base;


public abstract class ServiceProviderBase extends org.semanticwb.portal.community.DirectoryObject implements org.semanticwb.model.Traceable,org.semanticwb.model.Searchable,org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Rankable,org.semanticwb.portal.community.Contactable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Tagable,org.semanticwb.model.Geolocalizable,org.semanticwb.model.Descriptiveable
{
       public static final org.semanticwb.platform.SemanticClass pymtur_Instalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Instalation");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasInstalation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasInstalation");
       public static final org.semanticwb.platform.SemanticClass pymtur_Service=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Service");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasService=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasService");
       public static final org.semanticwb.platform.SemanticClass pymtur_PhotoPyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoPyme");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasPhotoPyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasPhotoPyme");
       public static final org.semanticwb.platform.SemanticProperty pymtur_callCenter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#callCenter");
       public static final org.semanticwb.platform.SemanticProperty pymtur_pymeWebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymeWebSite");
       public static final org.semanticwb.platform.SemanticClass pymtur_Nearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Nearest");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasNearest=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasNearest");
       public static final org.semanticwb.platform.SemanticProperty pymtur_MaxRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MaxRate");
       public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
       public static final org.semanticwb.platform.SemanticProperty pymtur_destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#destination");
       public static final org.semanticwb.platform.SemanticProperty pymtur_environment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#environment");
       public static final org.semanticwb.platform.SemanticProperty pymtur_MinRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#MinRate");
       public static final org.semanticwb.platform.SemanticProperty pymtur_Surroundings=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#Surroundings");
       public static final org.semanticwb.platform.SemanticProperty pymtur_spDomain=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#spDomain");
       public static final org.semanticwb.platform.SemanticProperty pymtur_pymePaqueteType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#pymePaqueteType");
       public static final org.semanticwb.platform.SemanticClass pymtur_ActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ActivityRef");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasActivityRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasActivityRef");
       public static final org.semanticwb.platform.SemanticProperty pymtur_PhotoLogo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#PhotoLogo");
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

       public static org.semanticwb.pymtur.ServiceProvider createServiceProvider(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.pymtur.ServiceProvider.ClassMgr.createServiceProvider(String.valueOf(id), model);
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
   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPhotoPyme(org.semanticwb.pymtur.PhotoPyme hasphotopyme,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasPhotoPyme, hasphotopyme.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviderByPhotoPyme(org.semanticwb.pymtur.PhotoPyme hasphotopyme)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> it=new org.semanticwb.model.GenericIterator(hasphotopyme.getSemanticObject().getModel().listSubjects(pymtur_hasPhotoPyme,hasphotopyme.getSemanticObject()));
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PhotoPyme> listPhotoPymes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.PhotoPyme>(getSemanticObject().listObjectProperties(pymtur_hasPhotoPyme));
    }

    public boolean hasPhotoPyme(org.semanticwb.pymtur.PhotoPyme photopyme)
    {
        if(photopyme==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasPhotoPyme,photopyme.getSemanticObject());
    }

    public void addPhotoPyme(org.semanticwb.pymtur.PhotoPyme value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasPhotoPyme, value.getSemanticObject());
    }

    public void removeAllPhotoPyme()
    {
        getSemanticObject().removeProperty(pymtur_hasPhotoPyme);
    }

    public void removePhotoPyme(org.semanticwb.pymtur.PhotoPyme photopyme)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasPhotoPyme,photopyme.getSemanticObject());
    }


    public org.semanticwb.pymtur.PhotoPyme getPhotoPyme()
    {
         org.semanticwb.pymtur.PhotoPyme ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasPhotoPyme);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.PhotoPyme)obj.createGenericInstance();
         }
         return ret;
    }

    public String getCallCenter()
    {
        return getSemanticObject().getProperty(pymtur_callCenter);
    }

    public void setCallCenter(String value)
    {
        getSemanticObject().setProperty(pymtur_callCenter, value);
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

    public String getContactPhoneNumber()
    {
        return getSemanticObject().getProperty(swbcomm_contactPhoneNumber);
    }

    public void setContactPhoneNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactPhoneNumber, value);
    }

    public String getEnvironment()
    {
        return getSemanticObject().getProperty(pymtur_environment);
    }

    public void setEnvironment(String value)
    {
        getSemanticObject().setProperty(pymtur_environment, value);
    }

    public int getStep()
    {
        return getSemanticObject().getIntProperty(swb_geoStep);
    }

    public void setStep(int value)
    {
        getSemanticObject().setIntProperty(swb_geoStep, value);
    }

    public String getIntNumber()
    {
        return getSemanticObject().getProperty(swbcomm_intNumber);
    }

    public void setIntNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_intNumber, value);
    }

    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(swb_latitude);
    }

    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_latitude, value);
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

    public String getStreetName()
    {
        return getSemanticObject().getProperty(swbcomm_streetName);
    }

    public void setStreetName(String value)
    {
        getSemanticObject().setProperty(swbcomm_streetName, value);
    }

    public String getSurroundings()
    {
        return getSemanticObject().getProperty(pymtur_Surroundings);
    }

    public void setSurroundings(String value)
    {
        getSemanticObject().setProperty(pymtur_Surroundings, value);
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

    public String getSpDomain()
    {
        return getSemanticObject().getProperty(pymtur_spDomain);
    }

    public void setSpDomain(String value)
    {
        getSemanticObject().setProperty(pymtur_spDomain, value);
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

    public String getPhotoLogo()
    {
        return getSemanticObject().getProperty(pymtur_PhotoLogo);
    }

    public void setPhotoLogo(String value)
    {
        getSemanticObject().setProperty(pymtur_PhotoLogo, value);
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
