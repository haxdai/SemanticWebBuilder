package org.semanticwb.portal.community.base;


public class ComerceBase extends org.semanticwb.portal.community.Organization implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Geolocalizable,org.semanticwb.portal.community.Addressable
{
    public static final org.semanticwb.platform.SemanticClass swbcomm_Comerce=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Comerce");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/community#Comerce");

    public ComerceBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public static java.util.Iterator<org.semanticwb.portal.community.Comerce> listComerces(org.semanticwb.model.SWBModel model)
    {
        java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Comerce>(it, true);
    }

    public static java.util.Iterator<org.semanticwb.portal.community.Comerce> listComerces()
    {
        java.util.Iterator it=sclass.listInstances();
        return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.community.Comerce>(it, true);
    }

    public static org.semanticwb.portal.community.Comerce createComerce(org.semanticwb.model.SWBModel model)
    {
        long id=model.getSemanticObject().getModel().getCounter(sclass);
        return org.semanticwb.portal.community.Comerce.createComerce(String.valueOf(id), model);
    }

    public static org.semanticwb.portal.community.Comerce getComerce(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.portal.community.Comerce)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
    }

    public static org.semanticwb.portal.community.Comerce createComerce(String id, org.semanticwb.model.SWBModel model)
    {
        return (org.semanticwb.portal.community.Comerce)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
    }

    public static void removeComerce(String id, org.semanticwb.model.SWBModel model)
    {
        model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
    }

    public static boolean hasComerce(String id, org.semanticwb.model.SWBModel model)
    {
        return (getComerce(id, model)!=null);
    }
}
