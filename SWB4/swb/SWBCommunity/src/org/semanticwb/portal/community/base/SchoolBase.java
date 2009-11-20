package org.semanticwb.portal.community.base;


public class SchoolBase extends org.semanticwb.portal.community.Organization implements org.semanticwb.portal.community.Interactiveable,org.semanticwb.model.Rankable,org.semanticwb.model.Searchable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Contactable,org.semanticwb.model.Campable,org.semanticwb.portal.community.FacilitiesEnable,org.semanticwb.model.Geolocalizable
{
       public static final org.semanticwb.platform.SemanticProperty swbcomm_bilingual=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#bilingual");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_schoolType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#schoolType");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_extraCurricularClasses=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#extraCurricularClasses");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_isPrivate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#isPrivate");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_sportsFaciliies=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#sportsFaciliies");
       public static final org.semanticwb.platform.SemanticClass swbcomm_School=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#School");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#School");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.portal.community.School> listSchools(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.portal.community.School> listSchools()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School>(it, true);
       }

       public static org.semanticwb.portal.community.School createSchool(org.semanticwb.model.SWBModel model)
       {
           long id=model.getSemanticObject().getModel().getCounter(sclass);
           return org.semanticwb.portal.community.School.ClassMgr.createSchool(String.valueOf(id), model);
       }

       public static org.semanticwb.portal.community.School getSchool(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.School)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.portal.community.School createSchool(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.School)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeSchool(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasSchool(String id, org.semanticwb.model.SWBModel model)
       {
           return (getSchool(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByCamp(org.semanticwb.model.Camp camp,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_camp, camp.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByCamp(org.semanticwb.model.Camp camp)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(camp.getSemanticObject().getModel().listSubjects(swb_camp,camp.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource, directoryresource.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByDirectoryResource(org.semanticwb.portal.community.DirectoryResource directoryresource)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(directoryresource.getSemanticObject().getModel().listSubjects(swbcomm_directoryResource,directoryresource.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage, hasdirprofilewebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByProfile(org.semanticwb.model.WebPage hasdirprofilewebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(hasdirprofilewebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirProfileWebPage,hasdirprofilewebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByWebPage(org.semanticwb.model.WebPage dirwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage, dirwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByWebPage(org.semanticwb.model.WebPage dirwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(dirwebpage.getSemanticObject().getModel().listSubjects(swbcomm_dirWebPage,dirwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage, hasdirtopicwebpage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByTopicWebPage(org.semanticwb.model.WebPage hasdirtopicwebpage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(hasdirtopicwebpage.getSemanticObject().getModel().listSubjects(swbcomm_hasDirTopicWebPage,hasdirtopicwebpage.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByComment(org.semanticwb.portal.community.Comment hascomment,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasComment, hascomment.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.School> listSchoolByComment(org.semanticwb.portal.community.Comment hascomment)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.School> it=new org.semanticwb.model.GenericIterator(hascomment.getSemanticObject().getModel().listSubjects(swbcomm_hasComment,hascomment.getSemanticObject()));
       return it;
   }
    }

    public SchoolBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public boolean isBilingual()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_bilingual);
    }

    public void setBilingual(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_bilingual, value);
    }

    public boolean isFoodCourt()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_foodCourt);
    }

    public void setFoodCourt(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_foodCourt, value);
    }

    public int getSchoolType()
    {
        return getSemanticObject().getIntProperty(swbcomm_schoolType);
    }

    public void setSchoolType(int value)
    {
        getSemanticObject().setIntProperty(swbcomm_schoolType, value);
    }

    public boolean isElevator()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_elevator);
    }

    public void setElevator(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_elevator, value);
    }

    public boolean isExtraCurricularClasses()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_extraCurricularClasses);
    }

    public void setExtraCurricularClasses(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_extraCurricularClasses, value);
    }

    public boolean isIsPrivate()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_isPrivate);
    }

    public void setIsPrivate(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_isPrivate, value);
    }

    public boolean isParkingLot()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_parkingLot);
    }

    public void setParkingLot(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_parkingLot, value);
    }

    public boolean isSportsFaciliies()
    {
        return getSemanticObject().getBooleanProperty(swbcomm_sportsFaciliies);
    }

    public void setSportsFaciliies(boolean value)
    {
        getSemanticObject().setBooleanProperty(swbcomm_sportsFaciliies, value);
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
