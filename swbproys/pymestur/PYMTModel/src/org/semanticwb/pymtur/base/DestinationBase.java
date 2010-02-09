package org.semanticwb.pymtur.base;


public abstract class DestinationBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Activeable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Viewable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Referensable,org.semanticwb.model.Searchable,org.semanticwb.model.Rankable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Tagable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Trashable
{
       public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
       public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestServiceProviderInv");
       public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
       public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
    public static class ClassMgr
    {

       public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinations(org.semanticwb.model.SWBModel model)
       {
           java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination>(it, true);
       }

       public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinations()
       {
           java.util.Iterator it=sclass.listInstances();
           return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination>(it, true);
       }

       public static org.semanticwb.pymtur.Destination getDestination(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.Destination)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
       }

       public static org.semanticwb.pymtur.Destination createDestination(String id, org.semanticwb.model.SWBModel model)
       {
           return (org.semanticwb.pymtur.Destination)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
       }

       public static void removeDestination(String id, org.semanticwb.model.SWBModel model)
       {
           model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
       }

       public static boolean hasDestination(String id, org.semanticwb.model.SWBModel model)
       {
           return (getDestination(id, model)!=null);
       }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef, hasusergroupref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasusergroupref.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef,hasusergroupref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember hasassmemberinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv, hasassmemberinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember hasassmemberinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv,hasassmemberinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent, haswebpagevirtualparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualparent.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent,haswebpagevirtualparent.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild, haswebpagevirtualchild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualchild.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild,haswebpagevirtualchild.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef haspflowref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef, haspflowref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef haspflowref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haspflowref.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef,haspflowref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef, hastemplateref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hastemplateref.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef,hastemplateref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByChild(org.semanticwb.model.WebPage haswebpagechild,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild, haswebpagechild.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByChild(org.semanticwb.model.WebPage haswebpagechild)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haswebpagechild.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild,haswebpagechild.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef, hascalendarref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hascalendarref.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef,hascalendarref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByParent(org.semanticwb.model.WebPage webpageparent,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_webPageParent, webpageparent.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByParent(org.semanticwb.model.WebPage webpageparent)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(webpageparent.getSemanticObject().getModel().listSubjects(swb_webPageParent,webpageparent.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByServiceProvider(org.semanticwb.pymtur.ServiceProvider hasdestserviceproviderinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_hasDestServiceProviderInv, hasdestserviceproviderinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByServiceProvider(org.semanticwb.pymtur.ServiceProvider hasdestserviceproviderinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasdestserviceproviderinv.getSemanticObject().getModel().listSubjects(pymtur_hasDestServiceProviderInv,hasdestserviceproviderinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByModifiedBy(org.semanticwb.model.User modifiedby)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByResource(org.semanticwb.model.Resource hasresource,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasResource, hasresource.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByResource(org.semanticwb.model.Resource hasresource)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasresource.getSemanticObject().getModel().listSubjects(swb_hasResource,hasresource.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef hasroleref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRoleRef, hasroleref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef hasroleref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasroleref.getSemanticObject().getModel().listSubjects(swb_hasRoleRef,hasroleref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv, hasthisroleassmemberinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasthisroleassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv,hasthisroleassmemberinv.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCreator(org.semanticwb.model.User creator)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef hasruleref,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRuleRef, hasruleref.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef hasruleref)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasruleref.getSemanticObject().getModel().listSubjects(swb_hasRuleRef,hasruleref.getSemanticObject()));
       return it;
   }
   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv,org.semanticwb.model.SWBModel model)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv, hasthistypeassociationinv.getSemanticObject()));
       return it;
   }

   public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv)
   {
       org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasthistypeassociationinv.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv,hasthistypeassociationinv.getSemanticObject()));
       return it;
   }
    }

    public DestinationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(getSemanticObject().listObjectProperties(pymtur_hasDestServiceProviderInv));
    }

    public boolean hasServiceProvider(org.semanticwb.pymtur.ServiceProvider serviceprovider)
    {
        if(serviceprovider==null)return false;
        return getSemanticObject().hasObjectProperty(pymtur_hasDestServiceProviderInv,serviceprovider.getSemanticObject());
    }


    public org.semanticwb.pymtur.ServiceProvider getServiceProvider()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestServiceProviderInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
