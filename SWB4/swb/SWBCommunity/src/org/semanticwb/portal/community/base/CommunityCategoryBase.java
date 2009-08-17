package org.semanticwb.portal.community.base;


public class CommunityCategoryBase extends org.semanticwb.model.WebPage implements org.semanticwb.model.UserGroupRefable,org.semanticwb.model.Resourceable,org.semanticwb.model.Viewable,org.semanticwb.model.CalendarRefable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Referensable,org.semanticwb.model.Indexable,org.semanticwb.model.Expirable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Activeable,org.semanticwb.model.Hiddenable,org.semanticwb.model.Traceable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Rankable,org.semanticwb.model.Filterable,org.semanticwb.model.Trashable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.RuleRefable
{
    public static final org.semanticwb.platform.SemanticClass swbcomm_CommunityCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#CommunityCategory");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#CommunityCategory");

    public CommunityCategoryBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.portal.community.CommunityCategory> listCommunityCategorys(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.CommunityCategory>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.portal.community.CommunityCategory> listCommunityCategorys()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.CommunityCategory>(it, true);
    }

    public static org.semanticwb.portal.community.CommunityCategory getCommunityCategory(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.portal.community.CommunityCategory)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.portal.community.CommunityCategory createCommunityCategory(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.portal.community.CommunityCategory)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeCommunityCategory(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasCommunityCategory(String id, org.semanticwb.model.SWBModel model)
    {
        return (getCommunityCategory(id, model)!=null);
    }
}
