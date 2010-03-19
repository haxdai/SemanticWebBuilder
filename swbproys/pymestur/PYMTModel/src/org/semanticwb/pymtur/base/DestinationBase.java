package org.semanticwb.pymtur.base;


public abstract class DestinationBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.Activeable,org.semanticwb.model.Resourceable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Undeleteable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Viewable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Referensable,org.semanticwb.model.Searchable,org.semanticwb.model.Rankable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RoleRefable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Tagable,org.semanticwb.model.Indexable,org.semanticwb.model.Traceable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.FilterableClass,org.semanticwb.model.FilterableNode,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Trashable
{
    public static final org.semanticwb.platform.SemanticClass pymtur_TourismType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#TourismType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasTourismType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasTourismType");
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestServiceProviderInv");
    public static final org.semanticwb.platform.SemanticClass pymtur_Event=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Event");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasEvent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasEvent");
    public static final org.semanticwb.platform.SemanticClass pymtur_Activity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Activity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestinationActivity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestinationActivity");
    public static final org.semanticwb.platform.SemanticClass pymtur_Experience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Experience");
    public static final org.semanticwb.platform.SemanticProperty pymtur_hasDestinationExperience=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#hasDestinationExperience");
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

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember hasassmemberinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv, hasassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByAssMember(org.semanticwb.model.AssMember hasassmemberinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasassmemberinv.getSemanticObject().getModel().listSubjectsByClass(swb_hasAssMemberInv,hasassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTourismType(org.semanticwb.pymtur.TourismType hastourismtype,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasTourismType, hastourismtype.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTourismType(org.semanticwb.pymtur.TourismType hastourismtype)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hastourismtype.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasTourismType,hastourismtype.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent, haswebpagevirtualparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualparent.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualParent,haswebpagevirtualparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef, hascalendarref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hascalendarref.getSemanticObject().getModel().listSubjectsByClass(swb_hasCalendarRef,hascalendarref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByParent(org.semanticwb.model.WebPage webpageparent,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent, webpageparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByParent(org.semanticwb.model.WebPage webpageparent)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(webpageparent.getSemanticObject().getModel().listSubjectsByClass(swb_webPageParent,webpageparent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByServiceProvider(org.semanticwb.pymtur.ServiceProvider hasdestserviceproviderinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestServiceProviderInv, hasdestserviceproviderinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByServiceProvider(org.semanticwb.pymtur.ServiceProvider hasdestserviceproviderinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasdestserviceproviderinv.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestServiceProviderInv,hasdestserviceproviderinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByEvent(org.semanticwb.pymtur.Event hasevent,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEvent, hasevent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByEvent(org.semanticwb.pymtur.Event hasevent)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasevent.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasEvent,hasevent.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, creator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByCreator(org.semanticwb.model.User creator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjectsByClass(swb_creator,creator.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef, hasusergroupref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasusergroupref.getSemanticObject().getModel().listSubjectsByClass(swb_hasUserGroupRef,hasusergroupref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationActivity(org.semanticwb.pymtur.Activity hasdestinationactivity,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationActivity, hasdestinationactivity.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationActivity(org.semanticwb.pymtur.Activity hasdestinationactivity)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasdestinationactivity.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationActivity,hasdestinationactivity.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild, haswebpagevirtualchild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualchild.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageVirtualChild,haswebpagevirtualchild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef haspflowref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef, haspflowref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByPFlowRef(org.semanticwb.model.PFlowRef haspflowref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haspflowref.getSemanticObject().getModel().listSubjectsByClass(swb_hasPFlowRef,haspflowref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef, hastemplateref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hastemplateref.getSemanticObject().getModel().listSubjectsByClass(swb_hasTemplateRef,hastemplateref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByChild(org.semanticwb.model.WebPage haswebpagechild,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild, haswebpagechild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByChild(org.semanticwb.model.WebPage haswebpagechild)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(haswebpagechild.getSemanticObject().getModel().listSubjectsByClass(swb_hasWebPageChild,haswebpagechild.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationExperience(org.semanticwb.pymtur.Experience hasdestinationexperience,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationExperience, hasdestinationexperience.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByDestinationExperience(org.semanticwb.pymtur.Experience hasdestinationexperience)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasdestinationexperience.getSemanticObject().getModel().listSubjectsByClass(pymtur_hasDestinationExperience,hasdestinationexperience.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, modifiedby.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByModifiedBy(org.semanticwb.model.User modifiedby)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,modifiedby.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByResource(org.semanticwb.model.Resource hasresource,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, hasresource.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByResource(org.semanticwb.model.Resource hasresource)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasresource.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,hasresource.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef hasroleref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef, hasroleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRoleRef(org.semanticwb.model.RoleRef hasroleref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasroleref.getSemanticObject().getModel().listSubjectsByClass(swb_hasRoleRef,hasroleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv, hasthisroleassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasthisroleassmemberinv.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisRoleAssMemberInv,hasthisroleassmemberinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef hasruleref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef, hasruleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByRuleRef(org.semanticwb.model.RuleRef hasruleref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasruleref.getSemanticObject().getModel().listSubjectsByClass(swb_hasRuleRef,hasruleref.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv, hasthistypeassociationinv.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Destination> listDestinationByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Destination> it=new org.semanticwb.model.GenericIterator(hasthistypeassociationinv.getSemanticObject().getModel().listSubjectsByClass(swb_hasThisTypeAssociationInv,hasthistypeassociationinv.getSemanticObject(),sclass));
            return it;
        }
    }

    public DestinationBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType> listTourismTypes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.TourismType>(getSemanticObject().listObjectProperties(pymtur_hasTourismType));
    }

    public boolean hasTourismType(org.semanticwb.pymtur.TourismType tourismtype)
    {
        boolean ret=false;
        if(tourismtype!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasTourismType,tourismtype.getSemanticObject());
        }
        return ret;
    }

    public void addTourismType(org.semanticwb.pymtur.TourismType value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasTourismType, value.getSemanticObject());
    }

    public void removeAllTourismType()
    {
        getSemanticObject().removeProperty(pymtur_hasTourismType);
    }

    public void removeTourismType(org.semanticwb.pymtur.TourismType tourismtype)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasTourismType,tourismtype.getSemanticObject());
    }

    public org.semanticwb.pymtur.TourismType getTourismType()
    {
         org.semanticwb.pymtur.TourismType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasTourismType);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.TourismType)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider> listServiceProviders()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.ServiceProvider>(getSemanticObject().listObjectProperties(pymtur_hasDestServiceProviderInv));
    }

    public boolean hasServiceProvider(org.semanticwb.pymtur.ServiceProvider serviceprovider)
    {
        boolean ret=false;
        if(serviceprovider!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestServiceProviderInv,serviceprovider.getSemanticObject());
        }
        return ret;
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event> listEvents()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Event>(getSemanticObject().listObjectProperties(pymtur_hasEvent));
    }

    public boolean hasEvent(org.semanticwb.pymtur.Event event)
    {
        boolean ret=false;
        if(event!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasEvent,event.getSemanticObject());
        }
        return ret;
    }

    public void addEvent(org.semanticwb.pymtur.Event value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasEvent, value.getSemanticObject());
    }

    public void removeAllEvent()
    {
        getSemanticObject().removeProperty(pymtur_hasEvent);
    }

    public void removeEvent(org.semanticwb.pymtur.Event event)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasEvent,event.getSemanticObject());
    }

    public org.semanticwb.pymtur.Event getEvent()
    {
         org.semanticwb.pymtur.Event ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasEvent);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Event)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity> listDestinationActivities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Activity>(getSemanticObject().listObjectProperties(pymtur_hasDestinationActivity));
    }

    public boolean hasDestinationActivity(org.semanticwb.pymtur.Activity activity)
    {
        boolean ret=false;
        if(activity!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestinationActivity,activity.getSemanticObject());
        }
        return ret;
    }

    public void addDestinationActivity(org.semanticwb.pymtur.Activity value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasDestinationActivity, value.getSemanticObject());
    }

    public void removeAllDestinationActivity()
    {
        getSemanticObject().removeProperty(pymtur_hasDestinationActivity);
    }

    public void removeDestinationActivity(org.semanticwb.pymtur.Activity activity)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasDestinationActivity,activity.getSemanticObject());
    }

    public org.semanticwb.pymtur.Activity getDestinationActivity()
    {
         org.semanticwb.pymtur.Activity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestinationActivity);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Activity)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Experience> listDestinationExperiences()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Experience>(getSemanticObject().listObjectProperties(pymtur_hasDestinationExperience));
    }

    public boolean hasDestinationExperience(org.semanticwb.pymtur.Experience experience)
    {
        boolean ret=false;
        if(experience!=null)
        {
           ret=getSemanticObject().hasObjectProperty(pymtur_hasDestinationExperience,experience.getSemanticObject());
        }
        return ret;
    }

    public void addDestinationExperience(org.semanticwb.pymtur.Experience value)
    {
        getSemanticObject().addObjectProperty(pymtur_hasDestinationExperience, value.getSemanticObject());
    }

    public void removeAllDestinationExperience()
    {
        getSemanticObject().removeProperty(pymtur_hasDestinationExperience);
    }

    public void removeDestinationExperience(org.semanticwb.pymtur.Experience experience)
    {
        getSemanticObject().removeObjectProperty(pymtur_hasDestinationExperience,experience.getSemanticObject());
    }

    public org.semanticwb.pymtur.Experience getDestinationExperience()
    {
         org.semanticwb.pymtur.Experience ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_hasDestinationExperience);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.Experience)obj.createGenericInstance();
         }
         return ret;
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
