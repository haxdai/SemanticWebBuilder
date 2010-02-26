package org.semanticwb.pymtur.base;


public abstract class RfcTypeBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass pymtur_RfcType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RfcType");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RfcType");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.RfcType> listRfcTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RfcType>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.RfcType> listRfcTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RfcType>(it, true);
        }

        public static org.semanticwb.pymtur.RfcType getRfcType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RfcType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.RfcType createRfcType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RfcType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRfcType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRfcType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRfcType(id, model)!=null);
        }
    }

    public RfcTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
