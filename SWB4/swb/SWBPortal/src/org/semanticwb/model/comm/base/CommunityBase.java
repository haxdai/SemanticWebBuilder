package org.semanticwb.model.comm.base;


public class CommunityBase extends org.semanticwb.model.comm.MicroSite implements org.semanticwb.model.Viewable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable,org.semanticwb.model.Trashable,org.semanticwb.model.TemplateRefable,org.semanticwb.model.Rankable,org.semanticwb.model.RoleRefable,org.semanticwb.model.Indexable,org.semanticwb.model.PFlowRefable,org.semanticwb.model.Calendarable,org.semanticwb.model.Referensable,org.semanticwb.model.Resourceable,org.semanticwb.model.Undeleteable,org.semanticwb.model.Hiddenable,org.semanticwb.model.RuleRefable,org.semanticwb.model.Filterable,org.semanticwb.model.Traceable,org.semanticwb.model.UserGroupRefable
{
    public static final org.semanticwb.platform.SemanticClass swbcomm_Community=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Community");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Community");

    public CommunityBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.model.comm.Community> listCommunitys(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.comm.Community>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.model.comm.Community> listCommunitys()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.comm.Community>(it, true);
    }

    public static org.semanticwb.model.comm.Community getCommunity(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.comm.Community)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.model.comm.Community createCommunity(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.model.comm.Community)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeCommunity(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasCommunity(String id, org.semanticwb.model.SWBModel model)
    {
        return (getCommunity(id, model)!=null);
    }
}
