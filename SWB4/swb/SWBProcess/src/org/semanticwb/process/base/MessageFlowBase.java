package org.semanticwb.process.base;


public abstract class MessageFlowBase extends org.semanticwb.process.ConnectionObject 
{
    public static final org.semanticwb.platform.SemanticClass swbps_MessageFlow=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#MessageFlow");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#MessageFlow");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.process.MessageFlow> listMessageFlows(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.MessageFlow>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.process.MessageFlow> listMessageFlows()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.MessageFlow>(it, true);
        }

        public static org.semanticwb.process.MessageFlow createMessageFlow(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.MessageFlow.ClassMgr.createMessageFlow(String.valueOf(id), model);
        }

        public static org.semanticwb.process.MessageFlow getMessageFlow(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.MessageFlow)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.process.MessageFlow createMessageFlow(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.MessageFlow)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeMessageFlow(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasMessageFlow(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMessageFlow(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.process.MessageFlow> listMessageFlowByToFlowObject(org.semanticwb.process.FlowObject toflowobject,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.MessageFlow> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbps_toFlowObject, toflowobject.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.MessageFlow> listMessageFlowByToFlowObject(org.semanticwb.process.FlowObject toflowobject)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.MessageFlow> it=new org.semanticwb.model.GenericIterator(toflowobject.getSemanticObject().getModel().listSubjects(swbps_toFlowObject,toflowobject.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.MessageFlow> listMessageFlowByFromFlowObject(org.semanticwb.process.FlowObject fromflowobjectinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.MessageFlow> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(swbps_fromFlowObjectInv, fromflowobjectinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.MessageFlow> listMessageFlowByFromFlowObject(org.semanticwb.process.FlowObject fromflowobjectinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.MessageFlow> it=new org.semanticwb.model.GenericIterator(fromflowobjectinv.getSemanticObject().getModel().listSubjects(swbps_fromFlowObjectInv,fromflowobjectinv.getSemanticObject()));
            return it;
        }
    }

    public MessageFlowBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.process.ProcessSite getProcessSite()
    {
        return (org.semanticwb.process.ProcessSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
