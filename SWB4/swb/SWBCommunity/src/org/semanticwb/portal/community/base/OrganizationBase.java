package org.semanticwb.portal.community.base;


public abstract class OrganizationBase extends org.semanticwb.portal.community.DirectoryObject implements org.semanticwb.model.Searchable,org.semanticwb.model.Rankable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Contactable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Claimable,org.semanticwb.portal.community.Interactiveable
{
       public static final org.semanticwb.platform.SemanticProperty swbcomm_webSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#webSite");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_serviceHours=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#serviceHours");
       public static final org.semanticwb.platform.SemanticClass swbcomm_Organization=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Organization");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Organization");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizations(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizations()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization>(it, true);
       }

       public static org.semanticwb.portal.community.Organization createOrganization(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.portal.community.Organization.ClassMgr.createOrganization(String.valueOf(id), model);
       }

       public static org.semanticwb.portal.community.Organization getOrganization(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.Organization)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.portal.community.Organization createOrganization(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.Organization)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeOrganization(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasOrganization(String id, org.semanticwb.model.SWBModel model)
       {
           return (getOrganization(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource, directoryresource.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(directoryresource.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource,directoryresource.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage, hasdirprofilewebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(hasdirprofilewebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage,hasdirprofilewebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByWebPage(org.semanticwb.model.WebPage dirwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage, dirwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByWebPage(org.semanticwb.model.WebPage dirwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(dirwebpage.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage,dirwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage, hasdirtopicwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(hasdirtopicwebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage,hasdirtopicwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByComment(org.semanticwb.portal.community.Comment hascomment,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasComment, hascomment.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByComment(org.semanticwb.portal.community.Comment hascomment)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(hascomment.getSemanticObject().getModel().listSubjects(swbcomm_hasComment,hascomment.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByClaimer(org.semanticwb.model.User claimer,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_claimer, claimer.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Organization> listOrganizationByClaimer(org.semanticwb.model.User claimer)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Organization> it=new org.semanticwb.model.GenericIterator(claimer.getSemanticObject().getModel().listSubjects(swbcomm_claimer,claimer.getSemanticObject()));
       return it;
   }
    }

    public OrganizationBase(org.semanticwb.platform.SemanticObject base)
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

    public String getContactPhoneNumber()
    {
        return getSemanticObject().getProperty(swbcomm_contactPhoneNumber);
    }

    public void setContactPhoneNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactPhoneNumber, value);
    }

    public String getContactName()
    {
        return getSemanticObject().getProperty(swbcomm_contactName);
    }

    public void setContactName(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactName, value);
    }

    public int getStep()
    {
        return getSemanticObject().getIntProperty(swb_geoStep);
    }

    public void setStep(int value)
    {
        getSemanticObject().setIntProperty(swb_geoStep, value);
    }

    public String getWebSite()
    {
        return getSemanticObject().getProperty(swbcomm_webSite);
    }

    public void setWebSite(String value)
    {
        getSemanticObject().setProperty(swbcomm_webSite, value);
    }

    public boolean isClaimable()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_claimable);
    }

    public void setClaimable(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_claimable, value);
    }

    public String getIntNumber()
    {
        return getSemanticObject().getProperty(swbcomm_intNumber);
    }

    public void setIntNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_intNumber, value);
    }

    public String getServiceHours()
    {
        return getSemanticObject().getProperty(swbcomm_serviceHours);
    }

    public void setServiceHours(String value)
    {
        getSemanticObject().setProperty(swbcomm_serviceHours, value);
    }

    public String getState()
    {
        return getSemanticObject().getProperty(swbcomm_state);
    }

    public void setState(String value)
    {
        getSemanticObject().setProperty(swbcomm_state, value);
    }

    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(swb_latitude);
    }

    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_latitude, value);
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

    public String getClaimJustify()
    {
        return getSemanticObject().getProperty(swbcomm_claimJustify);
    }

    public void setClaimJustify(String value)
    {
        getSemanticObject().setProperty(swbcomm_claimJustify, value);
    }

    public String getCityCouncil()
    {
        return getSemanticObject().getProperty(swbcomm_cityCouncil);
    }

    public void setCityCouncil(String value)
    {
        getSemanticObject().setProperty(swbcomm_cityCouncil, value);
    }

    public String getCity()
    {
        return getSemanticObject().getProperty(swbcomm_city);
    }

    public void setCity(String value)
    {
        getSemanticObject().setProperty(swbcomm_city, value);
    }

    public String getContactEmail()
    {
        return getSemanticObject().getProperty(swbcomm_contactEmail);
    }

    public void setContactEmail(String value)
    {
        getSemanticObject().setProperty(swbcomm_contactEmail, value);
    }

    public void setClaimer(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swbcomm_claimer, value.getSemanticObject());
    }

    public void removeClaimer()
    {
        getSemanticObject().removeProperty(swbcomm_claimer);
    }


    public org.semanticwb.model.User getClaimer()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbcomm_claimer);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
