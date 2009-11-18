package org.semanticwb.portal.community.base;


public class JobAreaBase extends org.semanticwb.portal.community.MicroSite implements org.semanticwb.model.RoleRefable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Activeable,org.semanticwb.model.Viewable,org.semanticwb.model.Trashable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Rankable,org.semanticwb.model.Filterable,org.semanticwb.model.Expirable,org.semanticwb.model.Traceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Indexable,org.semanticwb.model.Resourceable,org.semanticwb.model.Referensable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.TemplateRefable
{
       public static final org.semanticwb.platform.SemanticClass swbcomm_JobArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#JobArea");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#JobArea");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreas(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreas()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea>(it, true);
       }

       public static org.semanticwb.portal.community.JobArea getJobArea(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.JobArea)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.portal.community.JobArea createJobArea(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.portal.community.JobArea)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeJobArea(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasJobArea(String id, org.semanticwb.model.SWBModel model)
       {
           return (getJobArea(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef, hasusergroupref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasusergroupref.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef,hasusergroupref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByAssMember(org.semanticwb.model.AssMember hasassmemberinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv, hasassmemberinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByAssMember(org.semanticwb.model.AssMember hasassmemberinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv,hasassmemberinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent, haswebpagevirtualparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualparent.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent,haswebpagevirtualparent.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild, haswebpagevirtualchild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualchild.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild,haswebpagevirtualchild.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByPFlowRef(org.semanticwb.model.PFlowRef haspflowref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef, haspflowref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByPFlowRef(org.semanticwb.model.PFlowRef haspflowref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(haspflowref.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef,haspflowref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef, hastemplateref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hastemplateref.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef,hastemplateref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByChild(org.semanticwb.model.WebPage haswebpagechild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild, haswebpagechild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByChild(org.semanticwb.model.WebPage haswebpagechild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(haswebpagechild.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild,haswebpagechild.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef, hascalendarref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hascalendarref.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef,hascalendarref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByParent(org.semanticwb.model.WebPage webpageparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_webPageParent, webpageparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByParent(org.semanticwb.model.WebPage webpageparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(webpageparent.getSemanticObject().getModel().listSubjects(swb_webPageParent,webpageparent.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteWebPageUtil hasmicrositeutilsinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasMicroSiteUtilsInv, hasmicrositeutilsinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteWebPageUtil hasmicrositeutilsinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasmicrositeutilsinv.getSemanticObject().getModel().listSubjects(swbcomm_hasMicroSiteUtilsInv,hasmicrositeutilsinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByAbout(org.semanticwb.model.WebPage about,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_about, about.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByAbout(org.semanticwb.model.WebPage about)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(about.getSemanticObject().getModel().listSubjects(swbcomm_about,about.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByResource(org.semanticwb.model.Resource hasresource,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasResource, hasresource.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByResource(org.semanticwb.model.Resource hasresource)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasresource.getSemanticObject().getModel().listSubjects(swb_hasResource,hasresource.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByMember(org.semanticwb.portal.community.Member hasmsmembersinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasMSMembersInv, hasmsmembersinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByMember(org.semanticwb.portal.community.Member hasmsmembersinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasmsmembersinv.getSemanticObject().getModel().listSubjects(swbcomm_hasMSMembersInv,hasmsmembersinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByRoleRef(org.semanticwb.model.RoleRef hasroleref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRoleRef, hasroleref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByRoleRef(org.semanticwb.model.RoleRef hasroleref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasroleref.getSemanticObject().getModel().listSubjects(swb_hasRoleRef,hasroleref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByType(org.semanticwb.portal.community.MicroSiteType type,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_type, type.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByType(org.semanticwb.portal.community.MicroSiteType type)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(type.getSemanticObject().getModel().listSubjects(swbcomm_type,type.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv, hasthisroleassmemberinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasthisroleassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv,hasthisroleassmemberinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByRuleRef(org.semanticwb.model.RuleRef hasruleref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRuleRef, hasruleref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByRuleRef(org.semanticwb.model.RuleRef hasruleref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasruleref.getSemanticObject().getModel().listSubjects(swb_hasRuleRef,hasruleref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv, hasthistypeassociationinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.portal.community.JobArea> listJobAreaByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.JobArea> it=new org.semanticwb.model.GenericIterator(hasthistypeassociationinv.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv,hasthistypeassociationinv.getSemanticObject()));
       return it;
   }
    }

    public JobAreaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
