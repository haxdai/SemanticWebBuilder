package org.semanticwb.scian.base;


public abstract class SubSectorBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass scian_SubSector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#SubSector");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#SubSector");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.scian.SubSector> listSubSectors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.SubSector>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.scian.SubSector> listSubSectors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.SubSector>(it, true);
        }

        public static org.semanticwb.scian.SubSector getSubSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.SubSector)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.scian.SubSector createSubSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.SubSector)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeSubSector(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasSubSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubSector(id, model)!=null);
        }
    }

    public SubSectorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
