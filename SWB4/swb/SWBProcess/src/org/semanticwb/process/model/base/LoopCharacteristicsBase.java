package org.semanticwb.process.model.base;


public abstract class LoopCharacteristicsBase extends org.semanticwb.process.model.BPMNBaseElement implements org.semanticwb.process.model.Documentable
{
    public static final org.semanticwb.platform.SemanticClass swp_LoopCharacteristics=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/swp#LoopCharacteristics");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/swp#LoopCharacteristics");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics>(it, true);
        }

        public static org.semanticwb.process.model.LoopCharacteristics createLoopCharacteristics(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.model.LoopCharacteristics.ClassMgr.createLoopCharacteristics(String.valueOf(id), model);
        }

        public static org.semanticwb.process.model.LoopCharacteristics getLoopCharacteristics(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.LoopCharacteristics)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.process.model.LoopCharacteristics createLoopCharacteristics(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.LoopCharacteristics)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeLoopCharacteristics(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasLoopCharacteristics(String id, org.semanticwb.model.SWBModel model)
        {
            return (getLoopCharacteristics(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicsByDocumentation(org.semanticwb.process.model.Documentation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasDocumentation, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicsByDocumentation(org.semanticwb.process.model.Documentation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasDocumentation,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicsByExtensionDefinition(org.semanticwb.process.model.ExtensionDefinition value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasExtensionDefinition, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicsByExtensionDefinition(org.semanticwb.process.model.ExtensionDefinition value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasExtensionDefinition,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicsByExtensionValue(org.semanticwb.process.model.ExtensionAttributeValue value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasExtensionValue, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.process.model.LoopCharacteristics> listLoopCharacteristicsByExtensionValue(org.semanticwb.process.model.ExtensionAttributeValue value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.LoopCharacteristics> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasExtensionValue,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public LoopCharacteristicsBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
