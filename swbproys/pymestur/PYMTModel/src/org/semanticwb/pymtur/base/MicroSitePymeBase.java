package org.semanticwb.pymtur.base;


public abstract class MicroSitePymeBase extends org.semanticwb.portal.community.MicroSite implements org.semanticwb.model.Resourceable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Tagable,org.semanticwb.model.FilterableClass,org.semanticwb.model.RuleRefable,org.semanticwb.model.Expirable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Indexable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.Traceable,org.semanticwb.model.Activeable,org.semanticwb.model.Viewable,org.semanticwb.model.RoleRefable,org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Trashable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Rankable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Referensable,org.semanticwb.model.Searchable
{
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticProperty pymtur_serviceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#serviceProvider");
    public static final org.semanticwb.platform.SemanticClass pymtur_MicroSitePyme=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MicroSitePyme");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MicroSitePyme");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme>(it, true);
        }

        public static org.semanticwb.pymtur.MicroSitePyme getMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MicroSitePyme)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.MicroSitePyme createMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MicroSitePyme)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasMicroSitePyme(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMicroSitePyme(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAssMember(org.semanticwb.model.AssMember hasassmemberinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv, hasassmemberinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAssMember(org.semanticwb.model.AssMember hasassmemberinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasAssMemberInv,hasassmemberinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent, haswebpagevirtualparent.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByVirtualParent(org.semanticwb.model.WebPage haswebpagevirtualparent)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualparent.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualParent,haswebpagevirtualparent.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef, hascalendarref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCalendarRef(org.semanticwb.model.CalendarRef hascalendarref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hascalendarref.getSemanticObject().getModel().listSubjects(swb_hasCalendarRef,hascalendarref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByParent(org.semanticwb.model.WebPage webpageparent,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_webPageParent, webpageparent.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByParent(org.semanticwb.model.WebPage webpageparent)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(webpageparent.getSemanticObject().getModel().listSubjects(swb_webPageParent,webpageparent.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAbout(org.semanticwb.model.WebPage about,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_about, about.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByAbout(org.semanticwb.model.WebPage about)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(about.getSemanticObject().getModel().listSubjects(swbcomm_about,about.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMember(org.semanticwb.portal.community.Member hasmsmembersinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasMSMembersInv, hasmsmembersinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMember(org.semanticwb.portal.community.Member hasmsmembersinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasmsmembersinv.getSemanticObject().getModel().listSubjects(swbcomm_hasMSMembersInv,hasmsmembersinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByServiceProvider(org.semanticwb.pymtur.ServiceProvider serviceprovider,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_serviceProvider, serviceprovider.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByServiceProvider(org.semanticwb.pymtur.ServiceProvider serviceprovider)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(serviceprovider.getSemanticObject().getModel().listSubjects(pymtur_serviceProvider,serviceprovider.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCreator(org.semanticwb.model.User creator,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_creator, creator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByCreator(org.semanticwb.model.User creator)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(creator.getSemanticObject().getModel().listSubjects(swb_creator,creator.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef, hasusergroupref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByUserGroupRef(org.semanticwb.model.UserGroupRef hasusergroupref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasusergroupref.getSemanticObject().getModel().listSubjects(swb_hasUserGroupRef,hasusergroupref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild, haswebpagevirtualchild.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByWebPageVirtualChild(org.semanticwb.model.WebPage haswebpagevirtualchild)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(haswebpagevirtualchild.getSemanticObject().getModel().listSubjects(swb_hasWebPageVirtualChild,haswebpagevirtualchild.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByPFlowRef(org.semanticwb.model.PFlowRef haspflowref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef, haspflowref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByPFlowRef(org.semanticwb.model.PFlowRef haspflowref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(haspflowref.getSemanticObject().getModel().listSubjects(swb_hasPFlowRef,haspflowref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef, hastemplateref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByTemplateRef(org.semanticwb.model.TemplateRef hastemplateref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hastemplateref.getSemanticObject().getModel().listSubjects(swb_hasTemplateRef,hastemplateref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByChild(org.semanticwb.model.WebPage haswebpagechild,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild, haswebpagechild.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByChild(org.semanticwb.model.WebPage haswebpagechild)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(haswebpagechild.getSemanticObject().getModel().listSubjects(swb_hasWebPageChild,haswebpagechild.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteWebPageUtil hasmicrositeutilsinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_hasMicroSiteUtilsInv, hasmicrositeutilsinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByMicroSiteUtil(org.semanticwb.portal.community.MicroSiteWebPageUtil hasmicrositeutilsinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasmicrositeutilsinv.getSemanticObject().getModel().listSubjects(swbcomm_hasMicroSiteUtilsInv,hasmicrositeutilsinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByModifiedBy(org.semanticwb.model.User modifiedby,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_modifiedBy, modifiedby.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByModifiedBy(org.semanticwb.model.User modifiedby)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(modifiedby.getSemanticObject().getModel().listSubjects(swb_modifiedBy,modifiedby.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByResource(org.semanticwb.model.Resource hasresource,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasResource, hasresource.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByResource(org.semanticwb.model.Resource hasresource)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasresource.getSemanticObject().getModel().listSubjects(swb_hasResource,hasresource.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRoleRef(org.semanticwb.model.RoleRef hasroleref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRoleRef, hasroleref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRoleRef(org.semanticwb.model.RoleRef hasroleref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasroleref.getSemanticObject().getModel().listSubjects(swb_hasRoleRef,hasroleref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByType(org.semanticwb.portal.community.MicroSiteType type,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbcomm_type, type.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByType(org.semanticwb.portal.community.MicroSiteType type)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(type.getSemanticObject().getModel().listSubjects(swbcomm_type,type.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv, hasthisroleassmemberinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisRoleAssMember(org.semanticwb.model.AssMember hasthisroleassmemberinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasthisroleassmemberinv.getSemanticObject().getModel().listSubjects(swb_hasThisRoleAssMemberInv,hasthisroleassmemberinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRuleRef(org.semanticwb.model.RuleRef hasruleref,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasRuleRef, hasruleref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByRuleRef(org.semanticwb.model.RuleRef hasruleref)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasruleref.getSemanticObject().getModel().listSubjects(swb_hasRuleRef,hasruleref.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv, hasthistypeassociationinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MicroSitePyme> listMicroSitePymeByThisTypeAssociation(org.semanticwb.model.Association hasthistypeassociationinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MicroSitePyme> it=new org.semanticwb.model.GenericIterator(hasthistypeassociationinv.getSemanticObject().getModel().listSubjects(swb_hasThisTypeAssociationInv,hasthistypeassociationinv.getSemanticObject()));
            return it;
        }
    }

    public MicroSitePymeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setServiceProvider(org.semanticwb.pymtur.ServiceProvider value)
    {
        getSemanticObject().setObjectProperty(pymtur_serviceProvider, value.getSemanticObject());
    }

    public void removeServiceProvider()
    {
        getSemanticObject().removeProperty(pymtur_serviceProvider);
    }

    public org.semanticwb.pymtur.ServiceProvider getServiceProvider()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_serviceProvider);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
         }
         return ret;
    }
}
