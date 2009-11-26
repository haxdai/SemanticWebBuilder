package org.semanticwb.portal.community.base;


public abstract class CommerceBase extends org.semanticwb.portal.community.Organization implements org.semanticwb.model.Searchable,org.semanticwb.model.Rankable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Contactable,org.semanticwb.portal.community.FacilitiesEnable,org.semanticwb.portal.community.Claimable,org.semanticwb.portal.community.Interactiveable
{
       public static final org.semanticwb.platform.SemanticProperty swbcomm_paymentType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#paymentType");
       public static final org.semanticwb.platform.SemanticClass swbcomm_Commerce=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Commerce");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Commerce");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerces(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerces()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce>(it, true);
       }

       public static org.semanticwb.portal.community.Commerce createCommerce(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.portal.community.Commerce.ClassMgr.createCommerce(String.valueOf(id), model);
       }

       public static org.semanticwb.portal.community.Commerce getCommerce(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.Commerce)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.portal.community.Commerce createCommerce(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.Commerce)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeCommerce(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasCommerce(String id, org.semanticwb.model.SWBModel model)
       {
           return (getCommerce(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource, directoryresource.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(directoryresource.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource,directoryresource.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage, hasdirprofilewebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(hasdirprofilewebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage,hasdirprofilewebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByWebPage(org.semanticwb.model.WebPage dirwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage, dirwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByWebPage(org.semanticwb.model.WebPage dirwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(dirwebpage.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage,dirwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage, hasdirtopicwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(hasdirtopicwebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage,hasdirtopicwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByComment(org.semanticwb.portal.community.Comment hascomment,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasComment, hascomment.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByComment(org.semanticwb.portal.community.Comment hascomment)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(hascomment.getSemanticObject().getModel().listSubjects(swbcomm_hasComment,hascomment.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByClaimer(org.semanticwb.model.User claimer,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_claimer, claimer.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.Commerce> listCommerceByClaimer(org.semanticwb.model.User claimer)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Commerce> it=new org.semanticwb.model.GenericIterator(claimer.getSemanticObject().getModel().listSubjects(swbcomm_claimer,claimer.getSemanticObject()));
       return it;
   }
    }

    public CommerceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public int getPaymentType()
    {
        return getSemanticObject().getIntProperty(swbcomm_paymentType);
    }

    public void setPaymentType(int value)
    {
        getSemanticObject().setIntProperty(swbcomm_paymentType, value);
    }

    public boolean isFoodCourt()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_foodCourt);
    }

    public void setFoodCourt(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_foodCourt, value);
    }

    public boolean isElevator()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_elevator);
    }

    public void setElevator(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_elevator, value);
    }

    public boolean isParkingLot()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_parkingLot);
    }

    public void setParkingLot(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_parkingLot, value);
    }

    public boolean isImpairedPeopleAccessible()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_impairedPeopleAccessible);
    }

    public void setImpairedPeopleAccessible(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_impairedPeopleAccessible, value);
    }
}
