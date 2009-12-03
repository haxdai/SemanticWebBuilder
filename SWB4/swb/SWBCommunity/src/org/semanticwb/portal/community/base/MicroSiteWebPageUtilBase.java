package org.semanticwb.portal.community.base;


public abstract class MicroSiteWebPageUtilBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Activeable,org.semanticwb.model.Traceable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Searchable,org.semanticwb.model.Referensable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Rankable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Trashable,org.semanticwb.model.FilterableNode,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Viewable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Indexable,org.semanticwb.model.Filterable,org.semanticwb.model.Hiddenable,org.semanticwb.model.UserGroupRefable
{
       public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSiteUtil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSiteUtil");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_microSiteUtil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#microSiteUtil");
       public static final org.semanticwb.platform.SemanticClass swbcomm_Member=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Member");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_hasSubscribedMembersInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#hasSubscribedMembersInv");
       public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSite");
       public static final org.semanticwb.platform.SemanticProperty swbcomm_microSite=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/community#microSite");
       public static final org.semanticwb.platform.SemanticClass swbcomm_MicroSiteWebPageUtil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSiteWebPageUtil");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#MicroSiteWebPageUtil");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtils(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtils()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil>(it, true);
       }

       public static org.semanticwb.portal.community.MicroSiteWebPageUtil getMicroSiteWebPageUtil(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.MicroSiteWebPageUtil)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.portal.community.MicroSiteWebPageUtil createMicroSiteWebPageUtil(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.MicroSiteWebPageUtil)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeMicroSiteWebPageUtil(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasMicroSiteWebPageUtil(String id, org.semanticwb.model.SWBModel model)
       {
           return (getMicroSiteWebPageUtil(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef, hasusergroupref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hasusergroupref.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef,hasusergroupref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByAssMember(org.semanticwb.model.AssMember hasassmemberinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv, hasassmemberinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByAssMember(org.semanticwb.model.AssMember hasassmemberinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hasassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv,hasassmemberinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent, haswebpagevirtualparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualparent.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent,haswebpagevirtualparent.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteUtil micrositeutil,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_microSiteUtil, micrositeutil.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteUtil micrositeutil)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(micrositeutil.getSemanticObject().getModel().listSubjects(swbcomm_microSiteUtil,micrositeutil.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild, haswebpagevirtualchild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualchild.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild,haswebpagevirtualchild.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilBySubscribedMember(org.semanticwb.portal.community.Member hassubscribedmembersinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasSubscribedMembersInv, hassubscribedmembersinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilBySubscribedMember(org.semanticwb.portal.community.Member hassubscribedmembersinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hassubscribedmembersinv.getSemanticObject().getModel().listSubjects(swbcomm_hasSubscribedMembersInv,hassubscribedmembersinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByPFlowRef(org.semanticwb.model.PFlowRef haspflowref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef, haspflowref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByPFlowRef(org.semanticwb.model.PFlowRef haspflowref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(haspflowref.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef,haspflowref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef, hastemplateref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hastemplateref.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef,hastemplateref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByChild(org.semanticwb.model.WebPage haswebpagechild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild, haswebpagechild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByChild(org.semanticwb.model.WebPage haswebpagechild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(haswebpagechild.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild,haswebpagechild.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef, hascalendarref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hascalendarref.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef,hascalendarref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByParent(org.semanticwb.model.WebPage webpageparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_webPageParent, webpageparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByParent(org.semanticwb.model.WebPage webpageparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(webpageparent.getSemanticObject().getModel().listSubjects(swb_webPageParent,webpageparent.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByMicroSite(org.semanticwb.portal.community.MicroSite microsite,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_microSite, microsite.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByMicroSite(org.semanticwb.portal.community.MicroSite microsite)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(microsite.getSemanticObject().getModel().listSubjects(swbcomm_microSite,microsite.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByResource(org.semanticwb.model.Resource hasresource,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasResource, hasresource.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByResource(org.semanticwb.model.Resource hasresource)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hasresource.getSemanticObject().getModel().listSubjects(swb_hasResource,hasresource.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByRoleRef(org.semanticwb.model.RoleRef hasroleref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRoleRef, hasroleref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByRoleRef(org.semanticwb.model.RoleRef hasroleref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hasroleref.getSemanticObject().getModel().listSubjects(swb_hasRoleRef,hasroleref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv, hasthisroleassmemberinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hasthisroleassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv,hasthisroleassmemberinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByRuleRef(org.semanticwb.model.RuleRef hasruleref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRuleRef, hasruleref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByRuleRef(org.semanticwb.model.RuleRef hasruleref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hasruleref.getSemanticObject().getModel().listSubjects(swb_hasRuleRef,hasruleref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv, hasthistypeassociationinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> listMicroSiteWebPageUtilByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.MicroSiteWebPageUtil> it=new org.semanticwb.model.GenericIterator(hasthistypeassociationinv.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv,hasthistypeassociationinv.getSemanticObject()));
       return it;
   }
    }

    public MicroSiteWebPageUtilBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setMicroSiteUtil(org.semanticwb.portal.community.MicroSiteUtil value)
    {
        getSemanticObject().setObjectProperty(swbcomm_microSiteUtil, value.getSemanticObject());
    }

    public void removeMicroSiteUtil()
    {
        getSemanticObject().removeProperty(swbcomm_microSiteUtil);
    }


    public org.semanticwb.portal.community.MicroSiteUtil getMicroSiteUtil()
    {
         org.semanticwb.portal.community.MicroSiteUtil ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbcomm_microSiteUtil);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.community.MicroSiteUtil)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Member> listSubscribedMembers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Member>(getSemanticObject().listObjectProperties(swbcomm_hasSubscribedMembersInv));
    }

    public boolean hasSubscribedMember(org.semanticwb.portal.community.Member member)
    {
        if(member==null)return false;
        return getSemanticObject().hasObjectProperty(swbcomm_hasSubscribedMembersInv,member.getSemanticObject());
    }


    public org.semanticwb.portal.community.Member getSubscribedMember()
    {
         org.semanticwb.portal.community.Member ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbcomm_hasSubscribedMembersInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.community.Member)obj.createGenericInstance();
         }
         return ret;
    }

    public void setMicroSite(org.semanticwb.portal.community.MicroSite value)
    {
        getSemanticObject().setObjectProperty(swbcomm_microSite, value.getSemanticObject());
    }

    public void removeMicroSite()
    {
        getSemanticObject().removeProperty(swbcomm_microSite);
    }


    public org.semanticwb.portal.community.MicroSite getMicroSite()
    {
         org.semanticwb.portal.community.MicroSite ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbcomm_microSite);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.community.MicroSite)obj.createGenericInstance();
         }
         return ret;
    }
}
