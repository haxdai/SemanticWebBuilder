package org.semanticwb.scian.base;


public abstract class SectorBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass scian_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Sector");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Sector");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.scian.Sector> listSectors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.Sector>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.scian.Sector> listSectors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.Sector>(it, true);
        }

        public static org.semanticwb.scian.Sector getSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.Sector)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.scian.Sector createSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.Sector)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeSector(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSector(id, model)!=null);
        }
    }

    public SectorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
