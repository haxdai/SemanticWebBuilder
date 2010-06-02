package org.semanticwb.scian.base;


public abstract class SubRamaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass scian_SubRama=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#SubRama");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#SubRama");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.scian.SubRama> listSubRamas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.SubRama>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.scian.SubRama> listSubRamas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.SubRama>(it, true);
        }

        public static org.semanticwb.scian.SubRama getSubRama(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.SubRama)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.scian.SubRama createSubRama(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.SubRama)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeSubRama(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasSubRama(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubRama(id, model)!=null);
        }
    }

    public SubRamaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
