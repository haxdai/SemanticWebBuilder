package org.semanticwb.model.base;


public class WebPageBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Undeleteable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Trashable,org.semanticwb.model.Calendarable,org.semanticwb.model.Viewable,org.semanticwb.model.Referensable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Resourceable,org.semanticwb.model.Filterable,org.semanticwb.model.Rankable
{
    public static final org.semanticwb.platform.SemanticClass swb_UserGroupRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#UserGroupRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasUserGroupRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasUserGroupRef");
    public static final org.semanticwb.platform.SemanticProperty swb_reviews=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#reviews");
    public static final org.semanticwb.platform.SemanticProperty swb_rank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#rank");
    public static final org.semanticwb.platform.SemanticProperty swb_webPageSortName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#webPageSortName");
    public static final org.semanticwb.platform.SemanticProperty swb_webPageURLType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#webPageURLType");
    public static final org.semanticwb.platform.SemanticProperty swb_deleted=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#deleted");
    public static final org.semanticwb.platform.SemanticClass swb_WebPage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebPage");
    public static final org.semanticwb.platform.SemanticProperty swb_hasWebPageVirtualParent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasWebPageVirtualParent");
    public static final org.semanticwb.platform.SemanticProperty swb_active=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#active");
    public static final org.semanticwb.platform.SemanticProperty swb_webPageTarget=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#webPageTarget");
    public static final org.semanticwb.platform.SemanticProperty swb_hasWebPageVirtualChild=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasWebPageVirtualChild");
    public static final org.semanticwb.platform.SemanticClass swb_TemplateRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#TemplateRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasTemplateRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasTemplateRef");
    public static final org.semanticwb.platform.SemanticClass swb_PFlowRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#PFlowRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasPFlowRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasPFlowRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasWebPageChild=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasWebPageChild");
    public static final org.semanticwb.platform.SemanticProperty swb_webPageParent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#webPageParent");
    public static final org.semanticwb.platform.SemanticProperty swb_undeleteable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#undeleteable");
    public static final org.semanticwb.platform.SemanticProperty swb_maxViews=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#maxViews");
    public static final org.semanticwb.platform.SemanticProperty swb_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#created");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty swb_modifiedBy=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#modifiedBy");
    public static final org.semanticwb.platform.SemanticProperty swb_title=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#title");
    public static final org.semanticwb.platform.SemanticClass swb_Resource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Resource");
    public static final org.semanticwb.platform.SemanticProperty swb_hasResource=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasResource");
    public static final org.semanticwb.platform.SemanticProperty swb_updated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#updated");
    public static final org.semanticwb.platform.SemanticClass swb_Calendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Calendar");
    public static final org.semanticwb.platform.SemanticProperty swb_hasCalendar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasCalendar");
    public static final org.semanticwb.platform.SemanticProperty swb_hidden=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hidden");
    public static final org.semanticwb.platform.SemanticProperty swb_indexable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#indexable");
    public static final org.semanticwb.platform.SemanticProperty swb_webPageDiskUsage=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#webPageDiskUsage");
    public static final org.semanticwb.platform.SemanticClass swb_RoleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RoleRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRoleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRoleRef");
    public static final org.semanticwb.platform.SemanticProperty swb_views=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#views");
    public static final org.semanticwb.platform.SemanticProperty swb_creator=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#creator");
    public static final org.semanticwb.platform.SemanticClass swb_RuleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#RuleRef");
    public static final org.semanticwb.platform.SemanticProperty swb_hasRuleRef=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#hasRuleRef");
    public static final org.semanticwb.platform.SemanticProperty swb_webPageURL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#webPageURL");
    public static final org.semanticwb.platform.SemanticProperty swb_description=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#description");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#WebPage");

    public WebPageBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.WebPage> listWebPages(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.WebPage> listWebPages()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage>(it, true);
    }

    public static org.semanticwb.model.WebPage getWebPage(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.WebPage)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.WebPage createWebPage(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.WebPage)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeWebPage(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasWebPage(String id, org.semanticwb.model.SWBModel model)
    {
        return (getWebPage(id, model)!=null);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef> listUserGroupRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef>(getSemanticObject().listObjectProperties(swb_hasUserGroupRef));
    }

    public boolean hasUserGroupRef(org.semanticwb.model.UserGroupRef usergroupref)
    {
        if(usergroupref==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasUserGroupRef,usergroupref.getSemanticObject());
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef> listInheritUserGroupRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.UserGroupRef>(getSemanticObject().listInheritProperties(swb_hasUserGroupRef));
    }

    public void addUserGroupRef(org.semanticwb.model.UserGroupRef usergroupref)
    {
        getSemanticObject().addObjectProperty(swb_hasUserGroupRef, usergroupref.getSemanticObject());
    }

    public void removeAllUserGroupRef()
    {
        getSemanticObject().removeProperty(swb_hasUserGroupRef);
    }

    public void removeUserGroupRef(org.semanticwb.model.UserGroupRef usergroupref)
    {
        getSemanticObject().removeObjectProperty(swb_hasUserGroupRef,usergroupref.getSemanticObject());
    }

    public org.semanticwb.model.UserGroupRef getUserGroupRef()
    {
         org.semanticwb.model.UserGroupRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasUserGroupRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.UserGroupRef)obj.createGenericInstance();
         }
         return ret;
    }

    public long getReviews()
    {
        return getSemanticObject().getLongProperty(swb_reviews);
    }

    public void setReviews(long reviews)
    {
        getSemanticObject().setLongProperty(swb_reviews, reviews);
    }

    public double getRank()
    {
        return getSemanticObject().getDoubleProperty(swb_rank);
    }

    public void setRank(double rank)
    {
        getSemanticObject().setDoubleProperty(swb_rank, rank);
    }

    public String getSortName()
    {
        return getSemanticObject().getProperty(swb_webPageSortName);
    }

    public void setSortName(String webPageSortName)
    {
        getSemanticObject().setProperty(swb_webPageSortName, webPageSortName);
    }

    public int getWebPageURLType()
    {
        return getSemanticObject().getIntProperty(swb_webPageURLType);
    }

    public void setWebPageURLType(int webPageURLType)
    {
        getSemanticObject().setLongProperty(swb_webPageURLType, webPageURLType);
    }

    public boolean isDeleted()
    {
        return getSemanticObject().getBooleanProperty(swb_deleted);
    }

    public void setDeleted(boolean deleted)
    {
        getSemanticObject().setBooleanProperty(swb_deleted, deleted);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage> listVirtualParents()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage>(getSemanticObject().listObjectProperties(swb_hasWebPageVirtualParent));
    }

    public boolean hasVirtualParent(org.semanticwb.model.WebPage webpage)
    {
        if(webpage==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasWebPageVirtualParent,webpage.getSemanticObject());
    }

    public void addVirtualParent(org.semanticwb.model.WebPage webpage)
    {
        getSemanticObject().addObjectProperty(swb_hasWebPageVirtualParent, webpage.getSemanticObject());
    }

    public void removeAllVirtualParent()
    {
        getSemanticObject().removeProperty(swb_hasWebPageVirtualParent);
    }

    public void removeVirtualParent(org.semanticwb.model.WebPage webpage)
    {
        getSemanticObject().removeObjectProperty(swb_hasWebPageVirtualParent,webpage.getSemanticObject());
    }

    public org.semanticwb.model.WebPage getVirtualParent()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasWebPageVirtualParent);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

    public void setActive(boolean active)
    {
        getSemanticObject().setBooleanProperty(swb_active, active);
    }

    public String getTarget()
    {
        return getSemanticObject().getProperty(swb_webPageTarget);
    }

    public void setTarget(String webPageTarget)
    {
        getSemanticObject().setProperty(swb_webPageTarget, webPageTarget);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage> listWebPageVirtualChilds()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage>(getSemanticObject().listObjectProperties(swb_hasWebPageVirtualChild));
    }

    public boolean hasWebPageVirtualChild(org.semanticwb.model.WebPage webpage)
    {
        if(webpage==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasWebPageVirtualChild,webpage.getSemanticObject());
    }

    public org.semanticwb.model.WebPage getWebPageVirtualChild()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasWebPageVirtualChild);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.TemplateRef> listTemplateRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.TemplateRef>(getSemanticObject().listObjectProperties(swb_hasTemplateRef));
    }

    public boolean hasTemplateRef(org.semanticwb.model.TemplateRef templateref)
    {
        if(templateref==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasTemplateRef,templateref.getSemanticObject());
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.TemplateRef> listInheritTemplateRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.TemplateRef>(getSemanticObject().listInheritProperties(swb_hasTemplateRef));
    }

    public void addTemplateRef(org.semanticwb.model.TemplateRef templateref)
    {
        getSemanticObject().addObjectProperty(swb_hasTemplateRef, templateref.getSemanticObject());
    }

    public void removeAllTemplateRef()
    {
        getSemanticObject().removeProperty(swb_hasTemplateRef);
    }

    public void removeTemplateRef(org.semanticwb.model.TemplateRef templateref)
    {
        getSemanticObject().removeObjectProperty(swb_hasTemplateRef,templateref.getSemanticObject());
    }

    public org.semanticwb.model.TemplateRef getTemplateRef()
    {
         org.semanticwb.model.TemplateRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasTemplateRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.TemplateRef)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowRef> listPFlowRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowRef>(getSemanticObject().listObjectProperties(swb_hasPFlowRef));
    }

    public boolean hasPFlowRef(org.semanticwb.model.PFlowRef pflowref)
    {
        if(pflowref==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasPFlowRef,pflowref.getSemanticObject());
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowRef> listInheritPFlowRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.PFlowRef>(getSemanticObject().listInheritProperties(swb_hasPFlowRef));
    }

    public void addPFlowRef(org.semanticwb.model.PFlowRef pflowref)
    {
        getSemanticObject().addObjectProperty(swb_hasPFlowRef, pflowref.getSemanticObject());
    }

    public void removeAllPFlowRef()
    {
        getSemanticObject().removeProperty(swb_hasPFlowRef);
    }

    public void removePFlowRef(org.semanticwb.model.PFlowRef pflowref)
    {
        getSemanticObject().removeObjectProperty(swb_hasPFlowRef,pflowref.getSemanticObject());
    }

    public org.semanticwb.model.PFlowRef getPFlowRef()
    {
         org.semanticwb.model.PFlowRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasPFlowRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.PFlowRef)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage> listChilds()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.WebPage>(getSemanticObject().listObjectProperties(swb_hasWebPageChild));
    }

    public boolean hasChild(org.semanticwb.model.WebPage webpage)
    {
        if(webpage==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasWebPageChild,webpage.getSemanticObject());
    }

    public org.semanticwb.model.WebPage getChild()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasWebPageChild);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

    public void setParent(org.semanticwb.model.WebPage webpage)
    {
        getSemanticObject().setObjectProperty(swb_webPageParent, webpage.getSemanticObject());
    }

    public void removeParent()
    {
        getSemanticObject().removeProperty(swb_webPageParent);
    }

    public org.semanticwb.model.WebPage getParent()
    {
         org.semanticwb.model.WebPage ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_webPageParent);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.WebPage)obj.createGenericInstance();
         }
         return ret;
    }

    public boolean isUndeleteable()
    {
        return getSemanticObject().getBooleanProperty(swb_undeleteable);
    }

    public void setUndeleteable(boolean undeleteable)
    {
        getSemanticObject().setBooleanProperty(swb_undeleteable, undeleteable);
    }

    public long getMaxViews()
    {
        return getSemanticObject().getLongProperty(swb_maxViews);
    }

    public void setMaxViews(long maxViews)
    {
        getSemanticObject().setLongProperty(swb_maxViews, maxViews);
    }

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

    public void setCreated(java.util.Date created)
    {
        getSemanticObject().setDateProperty(swb_created, created);
    }

    public void setModifiedBy(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(swb_modifiedBy, user.getSemanticObject());
    }

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
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

    public void setTitle(String title)
    {
        getSemanticObject().setProperty(swb_title, title);
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource> listResources()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource>(getSemanticObject().listObjectProperties(swb_hasResource));
    }

    public boolean hasResource(org.semanticwb.model.Resource resource)
    {
        if(resource==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasResource,resource.getSemanticObject());
    }

    public void addResource(org.semanticwb.model.Resource resource)
    {
        getSemanticObject().addObjectProperty(swb_hasResource, resource.getSemanticObject());
    }

    public void removeAllResource()
    {
        getSemanticObject().removeProperty(swb_hasResource);
    }

    public void removeResource(org.semanticwb.model.Resource resource)
    {
        getSemanticObject().removeObjectProperty(swb_hasResource,resource.getSemanticObject());
    }

    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasResource);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }

    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

    public void setUpdated(java.util.Date updated)
    {
        getSemanticObject().setDateProperty(swb_updated, updated);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar> listCalendars()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Calendar>(getSemanticObject().listObjectProperties(swb_hasCalendar));
    }

    public boolean hasCalendar(org.semanticwb.model.Calendar calendar)
    {
        if(calendar==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasCalendar,calendar.getSemanticObject());
    }

    public void addCalendar(org.semanticwb.model.Calendar calendar)
    {
        getSemanticObject().addObjectProperty(swb_hasCalendar, calendar.getSemanticObject());
    }

    public void removeAllCalendar()
    {
        getSemanticObject().removeProperty(swb_hasCalendar);
    }

    public void removeCalendar(org.semanticwb.model.Calendar calendar)
    {
        getSemanticObject().removeObjectProperty(swb_hasCalendar,calendar.getSemanticObject());
    }

    public org.semanticwb.model.Calendar getCalendar()
    {
         org.semanticwb.model.Calendar ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasCalendar);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Calendar)obj.createGenericInstance();
         }
         return ret;
    }

    public boolean isHidden()
    {
        return getSemanticObject().getBooleanProperty(swb_hidden);
    }

    public void setHidden(boolean hidden)
    {
        getSemanticObject().setBooleanProperty(swb_hidden, hidden);
    }

    public boolean isIndexable()
    {
        return getSemanticObject().getBooleanProperty(swb_indexable);
    }

    public void setIndexable(boolean indexable)
    {
        getSemanticObject().setBooleanProperty(swb_indexable, indexable);
    }

    public long getDiskUsage()
    {
        //Override this method in WebPage object
        return getSemanticObject().getLongProperty(swb_webPageDiskUsage,false);
    }

    public void setDiskUsage(long webPageDiskUsage)
    {
        //Override this method in WebPage object
        getSemanticObject().setLongProperty(swb_webPageDiskUsage, webPageDiskUsage,false);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef> listRoleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef>(getSemanticObject().listObjectProperties(swb_hasRoleRef));
    }

    public boolean hasRoleRef(org.semanticwb.model.RoleRef roleref)
    {
        if(roleref==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasRoleRef,roleref.getSemanticObject());
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef> listInheritRoleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RoleRef>(getSemanticObject().listInheritProperties(swb_hasRoleRef));
    }

    public void addRoleRef(org.semanticwb.model.RoleRef roleref)
    {
        getSemanticObject().addObjectProperty(swb_hasRoleRef, roleref.getSemanticObject());
    }

    public void removeAllRoleRef()
    {
        getSemanticObject().removeProperty(swb_hasRoleRef);
    }

    public void removeRoleRef(org.semanticwb.model.RoleRef roleref)
    {
        getSemanticObject().removeObjectProperty(swb_hasRoleRef,roleref.getSemanticObject());
    }

    public org.semanticwb.model.RoleRef getRoleRef()
    {
         org.semanticwb.model.RoleRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRoleRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.RoleRef)obj.createGenericInstance();
         }
         return ret;
    }

    public long getViews()
    {
        //Override this method in WebPage object
        return getSemanticObject().getLongProperty(swb_views,false);
    }

    public void setViews(long views)
    {
        //Override this method in WebPage object
        getSemanticObject().setLongProperty(swb_views, views,false);
    }

    public void setCreator(org.semanticwb.model.User user)
    {
        getSemanticObject().setObjectProperty(swb_creator, user.getSemanticObject());
    }

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef> listRuleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef>(getSemanticObject().listObjectProperties(swb_hasRuleRef));
    }

    public boolean hasRuleRef(org.semanticwb.model.RuleRef ruleref)
    {
        if(ruleref==null)return false;        return getSemanticObject().hasObjectProperty(swb_hasRuleRef,ruleref.getSemanticObject());
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef> listInheritRuleRefs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.RuleRef>(getSemanticObject().listInheritProperties(swb_hasRuleRef));
    }

    public void addRuleRef(org.semanticwb.model.RuleRef ruleref)
    {
        getSemanticObject().addObjectProperty(swb_hasRuleRef, ruleref.getSemanticObject());
    }

    public void removeAllRuleRef()
    {
        getSemanticObject().removeProperty(swb_hasRuleRef);
    }

    public void removeRuleRef(org.semanticwb.model.RuleRef ruleref)
    {
        getSemanticObject().removeObjectProperty(swb_hasRuleRef,ruleref.getSemanticObject());
    }

    public org.semanticwb.model.RuleRef getRuleRef()
    {
         org.semanticwb.model.RuleRef ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasRuleRef);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.RuleRef)obj.createGenericInstance();
         }
         return ret;
    }

    public String getWebPageURL()
    {
        return getSemanticObject().getProperty(swb_webPageURL);
    }

    public void setWebPageURL(String webPageURL)
    {
        getSemanticObject().setProperty(swb_webPageURL, webPageURL);
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

    public void setDescription(String description)
    {
        getSemanticObject().setProperty(swb_description, description);
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

    public org.semanticwb.model.WebSite getWebSite()
    {
        return (org.semanticwb.model.WebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
