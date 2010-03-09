package org.semanticwb.pymtur.base;


public abstract class EventBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Resourceable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Indexable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.Viewable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Rankable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Trashable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Referensable,org.semanticwb.model.Searchable
{
    public static final org.semanticwb.platform.SemanticClass pymtur_Destination=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Destination");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestinationEventInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestinationEventInv");
    public static final org.semanticwb.platform.SemanticClass pymtur_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Event");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Event");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEvents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEvents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event>(it, true);
        }

        public static org.semanticwb.pymtur.Event createEvent(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.Event.ClassMgr.createEvent(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.Event getEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Event)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.Event createEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Event)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeEvent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasEvent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEvent(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByAssMember(org.semanticwb.model.AssMember hasassmemberinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, hasassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByAssMember(org.semanticwb.model.AssMember hasassmemberinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasassmemberinv.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,hasassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByDestinationEventInv(org.semanticwb.pymtur.Destination hasdestinationeventinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationEventInv, hasdestinationeventinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByDestinationEventInv(org.semanticwb.pymtur.Destination hasdestinationeventinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasdestinationeventinv.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationEventInv,hasdestinationeventinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, haswebpagevirtualparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualparent.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,haswebpagevirtualparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, hascalendarref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hascalendarref.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,hascalendarref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByParent(org.semanticwb.model.WebPage webpageparent,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, webpageparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByParent(org.semanticwb.model.WebPage webpageparent)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(webpageparent.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,webpageparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, creator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByCreator(org.semanticwb.model.User creator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjectsByClass(swb_creator,creator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, hasusergroupref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasusergroupref.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,hasusergroupref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, haswebpagevirtualchild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualchild.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,haswebpagevirtualchild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, hastemplateref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hastemplateref.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,hastemplateref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByPFlowRef(org.semanticwb.model.PFlowRef haspflowref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, haspflowref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByPFlowRef(org.semanticwb.model.PFlowRef haspflowref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(haspflowref.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,haspflowref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByChild(org.semanticwb.model.WebPage haswebpagechild,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, haswebpagechild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByChild(org.semanticwb.model.WebPage haswebpagechild)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(haswebpagechild.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,haswebpagechild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, modifiedby.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByModifiedBy(org.semanticwb.model.User modifiedby)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,modifiedby.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByResource(org.semanticwb.model.Resource hasresource,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, hasresource.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByResource(org.semanticwb.model.Resource hasresource)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasresource.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,hasresource.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByRoleRef(org.semanticwb.model.RoleRef hasroleref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, hasroleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByRoleRef(org.semanticwb.model.RoleRef hasroleref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasroleref.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,hasroleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, hasthisroleassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasthisroleassmemberinv.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,hasthisroleassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByRuleRef(org.semanticwb.model.RuleRef hasruleref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, hasruleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByRuleRef(org.semanticwb.model.RuleRef hasruleref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasruleref.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,hasruleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, hasthistypeassociationinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Event> listEventByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> it=new org.semanticwb.model.GenericIterator(hasthistypeassociationinv.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,hasthistypeassociationinv.getSemanticObject(),sclass));
            return it;
        }
    }

    public EventBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> listDestinationEventInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination>(getSemanticObject().listObjectProperties(pymtur_hasDestinationEventInv));
    }

    public boolean hasDestinationEventInv(org.semanticwb.pymtur.Destination destination)
    {
        boolean ret=false;
        if(destination!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestinationEventInv,destination.getSemanticObject());
        }
        return ret;
    }

    public org.semanticwb.pymtur.Destination getDestinationEventInv()
    {
         org.semanticwb.pymtur.Destination ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestinationEventInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Destination)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
