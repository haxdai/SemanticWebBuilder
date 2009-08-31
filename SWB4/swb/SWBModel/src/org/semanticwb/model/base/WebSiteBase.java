package org.semanticwb.model.base;


public class WebSiteBase extends org.semanticwb.model.SWBModel implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Localeable,org.semanticwb.model.Activeable,org.semanticwb.model.Trashable,org.semanticwb.model.Traceable,org.semanticwb.model.Indexable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Filterable
{
    public static final org.semanticwb.platform.SemanticClass swb_UserRepository=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserRepository");
    public static final org.semanticwb.platform.SemanticProperty swb_userRepository=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#userRepository");
    public static final org.semanticwb.platform.SemanticClass swb_WebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebPage");
    public static final org.semanticwb.platform.SemanticProperty swb_homePage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#homePage");
    public static final org.semanticwb.platform.SemanticClass swb_SWBModel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#SWBModel");
    public static final org.semanticwb.platform.SemanticProperty swb_hasSubModel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasSubModel");
    public static final org.semanticwb.platform.SemanticClass swb_ResourceSubType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#ResourceSubType");
    public static final org.semanticwb.platform.SemanticClass swb_Association=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Association");
    public static final org.semanticwb.platform.SemanticClass swb_ResourceRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#ResourceRef");
    public static final org.semanticwb.platform.SemanticClass swb_RuleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RuleRef");
    public static final org.semanticwb.platform.SemanticClass swb_Language=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Language");
    public static final org.semanticwb.platform.SemanticClass swb_Dns=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Dns");
    public static final org.semanticwb.platform.SemanticClass swb_Rule=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Rule");
    public static final org.semanticwb.platform.SemanticClass swb_Camp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Camp");
    public static final org.semanticwb.platform.SemanticClass swb_VersionInfo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#VersionInfo");
    public static final org.semanticwb.platform.SemanticClass swb_Calendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Calendar");
    public static final org.semanticwb.platform.SemanticClass swb_Device=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Device");
    public static final org.semanticwb.platform.SemanticClass swb_AdminFilter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#AdminFilter");
    public static final org.semanticwb.platform.SemanticClass swb_IPFilter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#IPFilter");
    public static final org.semanticwb.platform.SemanticClass swb_PFlowRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#PFlowRef");
    public static final org.semanticwb.platform.SemanticClass swb_Permission=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Permission");
    public static final org.semanticwb.platform.SemanticClass swb_Template=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Template");
    public static final org.semanticwb.platform.SemanticClass swb_PFlow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#PFlow");
    public static final org.semanticwb.platform.SemanticClass swb_ResourceFilter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#ResourceFilter");
    public static final org.semanticwb.platform.SemanticClass swb_TemplateRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#TemplateRef");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticClass swb_ResourceType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#ResourceType");
    public static final org.semanticwb.platform.SemanticClass swb_TemplateGroup=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#TemplateGroup");
    public static final org.semanticwb.platform.SemanticClass swb_RoleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RoleRef");
    public static final org.semanticwb.platform.SemanticClass swb_WebSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebSite");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebSite");

    public WebSiteBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSites(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSites()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite>(it, true);
    }

    public static org.semanticwb.model.WebSite getWebSite(String id)
    {
       org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
       org.semanticwb.model.WebSite ret=null;
       org.semanticwb.platform.SemanticModel model=mgr.getModel(id);
       if(model!=null)
       {
           org.semanticwb.platform.SemanticObject obj=model.getSemanticObject(model.getObjectUri(id,sclass));
           if(obj!=null)
           {
               ret=(org.semanticwb.model.WebSite)obj.createGenericInstance();
           }
       }
       return ret;
    }

    public static org.semanticwb.model.WebSite createWebSite(String id, String namespace)
    {
        org.semanticwb.platform.SemanticMgr mgr=org.semanticwb.SWBPlatform.getSemanticMgr();
        org.semanticwb.platform.SemanticModel model=mgr.createModel(id, namespace);
        return (org.semanticwb.model.WebSite)model.createGenericObject(model.getObjectUri(id, sclass), sclass);
    }

    public static void removeWebSite(String id)
    {
       org.semanticwb.model.WebSite obj=getWebSite(id);
       if(obj!=null)
       {
           obj.remove();
       }
    }

    public static boolean hasWebSite(String id)
    {
        return (getWebSite(id)!=null);
    }

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

    public boolean isIndexable()
    {
        return getSemanticObject().getBooleanProperty(swb_indexable);
    }

    public void setIndexable(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_indexable, value);
    }

    public void setUserRepository(org.semanticwb.model.UserRepository value)
    {
        getSemanticObject().setObjectProperty(swb_userRepository, value.getSemanticObject());
    }

    public void removeUserRepository()
    {
        getSemanticObject().removeProperty(swb_userRepository);
    }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByUserRepository(org.semanticwb.model.UserRepository userrepository,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_userRepository, userrepository.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByUserRepository(org.semanticwb.model.UserRepository userrepository)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(userrepository.getSemanticObject().getModel().listSubjects(swb_userRepository,userrepository.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.UserRepository getUserRepository()
    {
         org.semanticwb.model.UserRepository ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_userRepository);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserRepository)obj.createGenericInstance();
         }
         return ret;
    }

    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
    }

    public boolean isDeleted()
    {
        return getSemanticObject().getBooleanProperty(swb_deleted);
    }

    public void setDeleted(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_deleted, value);
    }

    public void setLanguage(org.semanticwb.model.Language value)
    {
        getSemanticObject().setObjectProperty(swb_language, value.getSemanticObject());
    }

    public void removeLanguage()
    {
        getSemanticObject().removeProperty(swb_language);
    }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByLanguage(org.semanticwb.model.Language language,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_language, language.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByLanguage(org.semanticwb.model.Language language)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(language.getSemanticObject().getModel().listSubjects(swb_language,language.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.Language getLanguage()
    {
         org.semanticwb.model.Language ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_language);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Language)obj.createGenericInstance();
         }
         return ret;
    }

    public void setCreator(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public void setHomePage(org.semanticwb.model.WebPage value)
    {
        getSemanticObject().setObjectProperty(swb_homePage, value.getSemanticObject());
    }

    public void removeHomePage()
    {
        getSemanticObject().removeProperty(swb_homePage);
    }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByHomePage(org.semanticwb.model.WebPage homepage,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_homePage, homepage.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteByHomePage(org.semanticwb.model.WebPage homepage)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(homepage.getSemanticObject().getModel().listSubjects(swb_homePage,homepage.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.WebPage getHomePage()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_homePage);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.SWBModel> listSubModels()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.SWBModel>(getSemanticObject().listObjectProperties(swb_hasSubModel));
    }

    public boolean hasSubModel(org.semanticwb.model.SWBModel swbmodel)
    {
        if(swbmodel==null)return false;
        return getSemanticObject().hasObjectProperty(swb_hasSubModel,swbmodel.getSemanticObject());
    }

    public void addSubModel(org.semanticwb.model.SWBModel value)
    {
        getSemanticObject().addObjectProperty(swb_hasSubModel, value.getSemanticObject());
    }

    public void removeAllSubModel()
    {
        getSemanticObject().removeProperty(swb_hasSubModel);
    }

    public void removeSubModel(org.semanticwb.model.SWBModel swbmodel)
    {
        getSemanticObject().removeObjectProperty(swb_hasSubModel,swbmodel.getSemanticObject());
    }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteBySubModel(org.semanticwb.model.SWBModel hassubmodel,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasSubModel, hassubmodel.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.model.WebSite> listWebSiteBySubModel(org.semanticwb.model.SWBModel hassubmodel)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.model.WebSite> it=new org.semanticwb.model.GenericIterator(hassubmodel.getSemanticObject().getModel().listSubjects(swb_hasSubModel,hassubmodel.getSemanticObject()));
       return it;
   }

    public org.semanticwb.model.SWBModel getSubModel()
    {
         org.semanticwb.model.SWBModel ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasSubModel);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.SWBModel)obj.createGenericInstance();
         }
         return ret;
    }

    public boolean isUndeleteable()
    {
        return getSemanticObject().getBooleanProperty(swb_undeleteable);
    }

    public void setUndeleteable(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_undeleteable, value);
    }

    public org.semanticwb.model.ResourceSubType getResourceSubType(String id)
    {
        return org.semanticwb.model.ResourceSubType.getResourceSubType(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.ResourceSubType> listResourceSubTypes()
    {
        return org.semanticwb.model.ResourceSubType.listResourceSubTypes(this);
    }

    public org.semanticwb.model.ResourceSubType createResourceSubType(String id)
    {
        return org.semanticwb.model.ResourceSubType.createResourceSubType(id,this);
    }

    public void removeResourceSubType(String id)
    {
        org.semanticwb.model.ResourceSubType.removeResourceSubType(id, this);
    }
    public boolean hasResourceSubType(String id)
    {
        return org.semanticwb.model.ResourceSubType.hasResourceSubType(id, this);
    }

    public org.semanticwb.model.Association getAssociation(String id)
    {
        return org.semanticwb.model.Association.getAssociation(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Association> listAssociations()
    {
        return org.semanticwb.model.Association.listAssociations(this);
    }

    public org.semanticwb.model.Association createAssociation(String id)
    {
        return org.semanticwb.model.Association.createAssociation(id,this);
    }

    public org.semanticwb.model.Association createAssociation()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Association);
        return org.semanticwb.model.Association.createAssociation(String.valueOf(id),this);
    } 

    public void removeAssociation(String id)
    {
        org.semanticwb.model.Association.removeAssociation(id, this);
    }
    public boolean hasAssociation(String id)
    {
        return org.semanticwb.model.Association.hasAssociation(id, this);
    }

    public org.semanticwb.model.ResourceRef getResourceRef(String id)
    {
        return org.semanticwb.model.ResourceRef.getResourceRef(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.ResourceRef> listResourceRefs()
    {
        return org.semanticwb.model.ResourceRef.listResourceRefs(this);
    }

    public org.semanticwb.model.ResourceRef createResourceRef(String id)
    {
        return org.semanticwb.model.ResourceRef.createResourceRef(id,this);
    }

    public org.semanticwb.model.ResourceRef createResourceRef()
    {
        long id=getSemanticObject().getModel().getCounter(swb_ResourceRef);
        return org.semanticwb.model.ResourceRef.createResourceRef(String.valueOf(id),this);
    } 

    public void removeResourceRef(String id)
    {
        org.semanticwb.model.ResourceRef.removeResourceRef(id, this);
    }
    public boolean hasResourceRef(String id)
    {
        return org.semanticwb.model.ResourceRef.hasResourceRef(id, this);
    }

    public org.semanticwb.model.RuleRef getRuleRef(String id)
    {
        return org.semanticwb.model.RuleRef.getRuleRef(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.RuleRef> listRuleRefs()
    {
        return org.semanticwb.model.RuleRef.listRuleRefs(this);
    }

    public org.semanticwb.model.RuleRef createRuleRef(String id)
    {
        return org.semanticwb.model.RuleRef.createRuleRef(id,this);
    }

    public org.semanticwb.model.RuleRef createRuleRef()
    {
        long id=getSemanticObject().getModel().getCounter(swb_RuleRef);
        return org.semanticwb.model.RuleRef.createRuleRef(String.valueOf(id),this);
    } 

    public void removeRuleRef(String id)
    {
        org.semanticwb.model.RuleRef.removeRuleRef(id, this);
    }
    public boolean hasRuleRef(String id)
    {
        return org.semanticwb.model.RuleRef.hasRuleRef(id, this);
    }

    public org.semanticwb.model.Language getLanguage(String id)
    {
        return org.semanticwb.model.Language.getLanguage(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Language> listLanguages()
    {
        return org.semanticwb.model.Language.listLanguages(this);
    }

    public org.semanticwb.model.Language createLanguage(String id)
    {
        return org.semanticwb.model.Language.createLanguage(id,this);
    }

    public void removeLanguage(String id)
    {
        org.semanticwb.model.Language.removeLanguage(id, this);
    }
    public boolean hasLanguage(String id)
    {
        return org.semanticwb.model.Language.hasLanguage(id, this);
    }

    public org.semanticwb.model.Dns getDns(String id)
    {
        return org.semanticwb.model.Dns.getDns(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Dns> listDnss()
    {
        return org.semanticwb.model.Dns.listDnss(this);
    }

    public org.semanticwb.model.Dns createDns(String id)
    {
        return org.semanticwb.model.Dns.createDns(id,this);
    }

    public org.semanticwb.model.Dns createDns()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Dns);
        return org.semanticwb.model.Dns.createDns(String.valueOf(id),this);
    } 

    public void removeDns(String id)
    {
        org.semanticwb.model.Dns.removeDns(id, this);
    }
    public boolean hasDns(String id)
    {
        return org.semanticwb.model.Dns.hasDns(id, this);
    }

    public org.semanticwb.model.Rule getRule(String id)
    {
        return org.semanticwb.model.Rule.getRule(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Rule> listRules()
    {
        return org.semanticwb.model.Rule.listRules(this);
    }

    public org.semanticwb.model.Rule createRule(String id)
    {
        return org.semanticwb.model.Rule.createRule(id,this);
    }

    public org.semanticwb.model.Rule createRule()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Rule);
        return org.semanticwb.model.Rule.createRule(String.valueOf(id),this);
    } 

    public void removeRule(String id)
    {
        org.semanticwb.model.Rule.removeRule(id, this);
    }
    public boolean hasRule(String id)
    {
        return org.semanticwb.model.Rule.hasRule(id, this);
    }

    public org.semanticwb.model.Camp getCamp(String id)
    {
        return org.semanticwb.model.Camp.getCamp(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Camp> listCamps()
    {
        return org.semanticwb.model.Camp.listCamps(this);
    }

    public org.semanticwb.model.Camp createCamp(String id)
    {
        return org.semanticwb.model.Camp.createCamp(id,this);
    }

    public org.semanticwb.model.Camp createCamp()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Camp);
        return org.semanticwb.model.Camp.createCamp(String.valueOf(id),this);
    } 

    public void removeCamp(String id)
    {
        org.semanticwb.model.Camp.removeCamp(id, this);
    }
    public boolean hasCamp(String id)
    {
        return org.semanticwb.model.Camp.hasCamp(id, this);
    }

    public org.semanticwb.model.VersionInfo getVersionInfo(String id)
    {
        return org.semanticwb.model.VersionInfo.getVersionInfo(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.VersionInfo> listVersionInfos()
    {
        return org.semanticwb.model.VersionInfo.listVersionInfos(this);
    }

    public org.semanticwb.model.VersionInfo createVersionInfo(String id)
    {
        return org.semanticwb.model.VersionInfo.createVersionInfo(id,this);
    }

    public org.semanticwb.model.VersionInfo createVersionInfo()
    {
        long id=getSemanticObject().getModel().getCounter(swb_VersionInfo);
        return org.semanticwb.model.VersionInfo.createVersionInfo(String.valueOf(id),this);
    } 

    public void removeVersionInfo(String id)
    {
        org.semanticwb.model.VersionInfo.removeVersionInfo(id, this);
    }
    public boolean hasVersionInfo(String id)
    {
        return org.semanticwb.model.VersionInfo.hasVersionInfo(id, this);
    }

    public org.semanticwb.model.WebPage getWebPage(String id)
    {
        return org.semanticwb.model.WebPage.getWebPage(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.WebPage> listWebPages()
    {
        return org.semanticwb.model.WebPage.listWebPages(this);
    }

    public org.semanticwb.model.WebPage createWebPage(String id)
    {
        return org.semanticwb.model.WebPage.createWebPage(id,this);
    }

    public void removeWebPage(String id)
    {
        org.semanticwb.model.WebPage.removeWebPage(id, this);
    }
    public boolean hasWebPage(String id)
    {
        return org.semanticwb.model.WebPage.hasWebPage(id, this);
    }

    public org.semanticwb.model.Calendar getCalendar(String id)
    {
        return org.semanticwb.model.Calendar.getCalendar(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Calendar> listCalendars()
    {
        return org.semanticwb.model.Calendar.listCalendars(this);
    }

    public org.semanticwb.model.Calendar createCalendar(String id)
    {
        return org.semanticwb.model.Calendar.createCalendar(id,this);
    }

    public org.semanticwb.model.Calendar createCalendar()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Calendar);
        return org.semanticwb.model.Calendar.createCalendar(String.valueOf(id),this);
    } 

    public void removeCalendar(String id)
    {
        org.semanticwb.model.Calendar.removeCalendar(id, this);
    }
    public boolean hasCalendar(String id)
    {
        return org.semanticwb.model.Calendar.hasCalendar(id, this);
    }

    public org.semanticwb.model.Device getDevice(String id)
    {
        return org.semanticwb.model.Device.getDevice(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Device> listDevices()
    {
        return org.semanticwb.model.Device.listDevices(this);
    }

    public org.semanticwb.model.Device createDevice(String id)
    {
        return org.semanticwb.model.Device.createDevice(id,this);
    }

    public void removeDevice(String id)
    {
        org.semanticwb.model.Device.removeDevice(id, this);
    }
    public boolean hasDevice(String id)
    {
        return org.semanticwb.model.Device.hasDevice(id, this);
    }

    public org.semanticwb.model.AdminFilter getAdminFilter(String id)
    {
        return org.semanticwb.model.AdminFilter.getAdminFilter(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.AdminFilter> listAdminFilters()
    {
        return org.semanticwb.model.AdminFilter.listAdminFilters(this);
    }

    public org.semanticwb.model.AdminFilter createAdminFilter(String id)
    {
        return org.semanticwb.model.AdminFilter.createAdminFilter(id,this);
    }

    public org.semanticwb.model.AdminFilter createAdminFilter()
    {
        long id=getSemanticObject().getModel().getCounter(swb_AdminFilter);
        return org.semanticwb.model.AdminFilter.createAdminFilter(String.valueOf(id),this);
    } 

    public void removeAdminFilter(String id)
    {
        org.semanticwb.model.AdminFilter.removeAdminFilter(id, this);
    }
    public boolean hasAdminFilter(String id)
    {
        return org.semanticwb.model.AdminFilter.hasAdminFilter(id, this);
    }

    public org.semanticwb.model.IPFilter getIPFilter(String id)
    {
        return org.semanticwb.model.IPFilter.getIPFilter(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.IPFilter> listIPFilters()
    {
        return org.semanticwb.model.IPFilter.listIPFilters(this);
    }

    public org.semanticwb.model.IPFilter createIPFilter(String id)
    {
        return org.semanticwb.model.IPFilter.createIPFilter(id,this);
    }

    public org.semanticwb.model.IPFilter createIPFilter()
    {
        long id=getSemanticObject().getModel().getCounter(swb_IPFilter);
        return org.semanticwb.model.IPFilter.createIPFilter(String.valueOf(id),this);
    } 

    public void removeIPFilter(String id)
    {
        org.semanticwb.model.IPFilter.removeIPFilter(id, this);
    }
    public boolean hasIPFilter(String id)
    {
        return org.semanticwb.model.IPFilter.hasIPFilter(id, this);
    }

    public org.semanticwb.model.PFlowRef getPFlowRef(String id)
    {
        return org.semanticwb.model.PFlowRef.getPFlowRef(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.PFlowRef> listPFlowRefs()
    {
        return org.semanticwb.model.PFlowRef.listPFlowRefs(this);
    }

    public org.semanticwb.model.PFlowRef createPFlowRef(String id)
    {
        return org.semanticwb.model.PFlowRef.createPFlowRef(id,this);
    }

    public org.semanticwb.model.PFlowRef createPFlowRef()
    {
        long id=getSemanticObject().getModel().getCounter(swb_PFlowRef);
        return org.semanticwb.model.PFlowRef.createPFlowRef(String.valueOf(id),this);
    } 

    public void removePFlowRef(String id)
    {
        org.semanticwb.model.PFlowRef.removePFlowRef(id, this);
    }
    public boolean hasPFlowRef(String id)
    {
        return org.semanticwb.model.PFlowRef.hasPFlowRef(id, this);
    }

    public org.semanticwb.model.Permission getPermission(String id)
    {
        return org.semanticwb.model.Permission.getPermission(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Permission> listPermissions()
    {
        return org.semanticwb.model.Permission.listPermissions(this);
    }

    public org.semanticwb.model.Permission createPermission(String id)
    {
        return org.semanticwb.model.Permission.createPermission(id,this);
    }

    public org.semanticwb.model.Permission createPermission()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Permission);
        return org.semanticwb.model.Permission.createPermission(String.valueOf(id),this);
    } 

    public void removePermission(String id)
    {
        org.semanticwb.model.Permission.removePermission(id, this);
    }
    public boolean hasPermission(String id)
    {
        return org.semanticwb.model.Permission.hasPermission(id, this);
    }

    public org.semanticwb.model.Template getTemplate(String id)
    {
        return org.semanticwb.model.Template.getTemplate(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Template> listTemplates()
    {
        return org.semanticwb.model.Template.listTemplates(this);
    }

    public org.semanticwb.model.Template createTemplate(String id)
    {
        return org.semanticwb.model.Template.createTemplate(id,this);
    }

    public org.semanticwb.model.Template createTemplate()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Template);
        return org.semanticwb.model.Template.createTemplate(String.valueOf(id),this);
    } 

    public void removeTemplate(String id)
    {
        org.semanticwb.model.Template.removeTemplate(id, this);
    }
    public boolean hasTemplate(String id)
    {
        return org.semanticwb.model.Template.hasTemplate(id, this);
    }

    public org.semanticwb.model.PFlow getPFlow(String id)
    {
        return org.semanticwb.model.PFlow.getPFlow(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.PFlow> listPFlows()
    {
        return org.semanticwb.model.PFlow.listPFlows(this);
    }

    public org.semanticwb.model.PFlow createPFlow(String id)
    {
        return org.semanticwb.model.PFlow.createPFlow(id,this);
    }

    public org.semanticwb.model.PFlow createPFlow()
    {
        long id=getSemanticObject().getModel().getCounter(swb_PFlow);
        return org.semanticwb.model.PFlow.createPFlow(String.valueOf(id),this);
    } 

    public void removePFlow(String id)
    {
        org.semanticwb.model.PFlow.removePFlow(id, this);
    }
    public boolean hasPFlow(String id)
    {
        return org.semanticwb.model.PFlow.hasPFlow(id, this);
    }

    public org.semanticwb.model.ResourceFilter getResourceFilter(String id)
    {
        return org.semanticwb.model.ResourceFilter.getResourceFilter(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.ResourceFilter> listResourceFilters()
    {
        return org.semanticwb.model.ResourceFilter.listResourceFilters(this);
    }

    public org.semanticwb.model.ResourceFilter createResourceFilter(String id)
    {
        return org.semanticwb.model.ResourceFilter.createResourceFilter(id,this);
    }

    public org.semanticwb.model.ResourceFilter createResourceFilter()
    {
        long id=getSemanticObject().getModel().getCounter(swb_ResourceFilter);
        return org.semanticwb.model.ResourceFilter.createResourceFilter(String.valueOf(id),this);
    } 

    public void removeResourceFilter(String id)
    {
        org.semanticwb.model.ResourceFilter.removeResourceFilter(id, this);
    }
    public boolean hasResourceFilter(String id)
    {
        return org.semanticwb.model.ResourceFilter.hasResourceFilter(id, this);
    }

    public org.semanticwb.model.TemplateRef getTemplateRef(String id)
    {
        return org.semanticwb.model.TemplateRef.getTemplateRef(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.TemplateRef> listTemplateRefs()
    {
        return org.semanticwb.model.TemplateRef.listTemplateRefs(this);
    }

    public org.semanticwb.model.TemplateRef createTemplateRef(String id)
    {
        return org.semanticwb.model.TemplateRef.createTemplateRef(id,this);
    }

    public org.semanticwb.model.TemplateRef createTemplateRef()
    {
        long id=getSemanticObject().getModel().getCounter(swb_TemplateRef);
        return org.semanticwb.model.TemplateRef.createTemplateRef(String.valueOf(id),this);
    } 

    public void removeTemplateRef(String id)
    {
        org.semanticwb.model.TemplateRef.removeTemplateRef(id, this);
    }
    public boolean hasTemplateRef(String id)
    {
        return org.semanticwb.model.TemplateRef.hasTemplateRef(id, this);
    }

    public org.semanticwb.model.Resource getResource(String id)
    {
        return org.semanticwb.model.Resource.getResource(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.Resource> listResources()
    {
        return org.semanticwb.model.Resource.listResources(this);
    }

    public org.semanticwb.model.Resource createResource(String id)
    {
        return org.semanticwb.model.Resource.createResource(id,this);
    }

    public org.semanticwb.model.Resource createResource()
    {
        long id=getSemanticObject().getModel().getCounter(swb_Resource);
        return org.semanticwb.model.Resource.createResource(String.valueOf(id),this);
    } 

    public void removeResource(String id)
    {
        org.semanticwb.model.Resource.removeResource(id, this);
    }
    public boolean hasResource(String id)
    {
        return org.semanticwb.model.Resource.hasResource(id, this);
    }

    public org.semanticwb.model.ResourceType getResourceType(String id)
    {
        return org.semanticwb.model.ResourceType.getResourceType(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.ResourceType> listResourceTypes()
    {
        return org.semanticwb.model.ResourceType.listResourceTypes(this);
    }

    public org.semanticwb.model.ResourceType createResourceType(String id)
    {
        return org.semanticwb.model.ResourceType.createResourceType(id,this);
    }

    public void removeResourceType(String id)
    {
        org.semanticwb.model.ResourceType.removeResourceType(id, this);
    }
    public boolean hasResourceType(String id)
    {
        return org.semanticwb.model.ResourceType.hasResourceType(id, this);
    }

    public org.semanticwb.model.TemplateGroup getTemplateGroup(String id)
    {
        return org.semanticwb.model.TemplateGroup.getTemplateGroup(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.TemplateGroup> listTemplateGroups()
    {
        return org.semanticwb.model.TemplateGroup.listTemplateGroups(this);
    }

    public org.semanticwb.model.TemplateGroup createTemplateGroup(String id)
    {
        return org.semanticwb.model.TemplateGroup.createTemplateGroup(id,this);
    }

    public org.semanticwb.model.TemplateGroup createTemplateGroup()
    {
        long id=getSemanticObject().getModel().getCounter(swb_TemplateGroup);
        return org.semanticwb.model.TemplateGroup.createTemplateGroup(String.valueOf(id),this);
    } 

    public void removeTemplateGroup(String id)
    {
        org.semanticwb.model.TemplateGroup.removeTemplateGroup(id, this);
    }
    public boolean hasTemplateGroup(String id)
    {
        return org.semanticwb.model.TemplateGroup.hasTemplateGroup(id, this);
    }

    public org.semanticwb.model.RoleRef getRoleRef(String id)
    {
        return org.semanticwb.model.RoleRef.getRoleRef(id, this);
    }

    public java.util.Iterator<org.semanticwb.model.RoleRef> listRoleRefs()
    {
        return org.semanticwb.model.RoleRef.listRoleRefs(this);
    }

    public org.semanticwb.model.RoleRef createRoleRef(String id)
    {
        return org.semanticwb.model.RoleRef.createRoleRef(id,this);
    }

    public org.semanticwb.model.RoleRef createRoleRef()
    {
        long id=getSemanticObject().getModel().getCounter(swb_RoleRef);
        return org.semanticwb.model.RoleRef.createRoleRef(String.valueOf(id),this);
    } 

    public void removeRoleRef(String id)
    {
        org.semanticwb.model.RoleRef.removeRoleRef(id, this);
    }
    public boolean hasRoleRef(String id)
    {
        return org.semanticwb.model.RoleRef.hasRoleRef(id, this);
    }
}
