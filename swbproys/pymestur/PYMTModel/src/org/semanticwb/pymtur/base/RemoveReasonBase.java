package org.semanticwb.pymtur.base;


public abstract class RemoveReasonBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass pymtur_RemoveReason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RemoveReason");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#RemoveReason");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.RemoveReason> listRemoveReasons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RemoveReason>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.RemoveReason> listRemoveReasons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.RemoveReason>(it, true);
        }

        public static org.semanticwb.pymtur.RemoveReason createRemoveReason(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.RemoveReason.ClassMgr.createRemoveReason(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.RemoveReason getRemoveReason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RemoveReason)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.RemoveReason createRemoveReason(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.RemoveReason)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRemoveReason(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRemoveReason(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRemoveReason(id, model)!=null);
        }
    }

    public RemoveReasonBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
