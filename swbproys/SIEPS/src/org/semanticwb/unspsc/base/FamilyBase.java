package org.semanticwb.unspsc.base;


public abstract class FamilyBase extends org.semanticwb.unspsc.Segment 
{
    public static final org.semanticwb.platform.SemanticClass unspsc_Family=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ontoview.org/schema/unspsc/1#Family");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ontoview.org/schema/unspsc/1#Family");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.unspsc.Family> listFamilies(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.unspsc.Family>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.unspsc.Family> listFamilies()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.unspsc.Family>(it, true);
        }

        public static org.semanticwb.unspsc.Family getFamily(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.unspsc.Family)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.unspsc.Family createFamily(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.unspsc.Family)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeFamily(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasFamily(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFamily(id, model)!=null);
        }
    }

    public FamilyBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
