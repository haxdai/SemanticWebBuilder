package org.semanticwb.unspsc.base;


public abstract class SegmentBase extends org.semanticwb.model.base.GenericObjectBase 
{
    public static final org.semanticwb.platform.SemanticClass unspsc_Segment=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ontoview.org/schema/unspsc/1#Segment");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ontoview.org/schema/unspsc/1#Segment");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.unspsc.Segment> listSegments(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.unspsc.Segment>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.unspsc.Segment> listSegments()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.unspsc.Segment>(it, true);
        }

        public static org.semanticwb.unspsc.Segment getSegment(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.unspsc.Segment)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.unspsc.Segment createSegment(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.unspsc.Segment)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeSegment(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasSegment(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSegment(id, model)!=null);
        }
    }

    public SegmentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
