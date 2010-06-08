package org.semanticwb.scian.base;


public abstract class RamaBase extends org.semanticwb.scian.SubSector 
{
    public static final org.semanticwb.platform.SemanticClass scian_Rama=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Rama");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Rama");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.scian.Rama> listRamas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.Rama>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.scian.Rama> listRamas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.Rama>(it, true);
        }

        public static org.semanticwb.scian.Rama getRama(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.Rama)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.scian.Rama createRama(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.Rama)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRama(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRama(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRama(id, model)!=null);
        }
    }

    public RamaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
