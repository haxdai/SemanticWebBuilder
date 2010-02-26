package org.semanticwb.pymtur.base;


public abstract class MiPymeSitePlusBase extends org.semanticwb.pymtur.MiPymeSite 
{
    public static final org.semanticwb.platform.SemanticClass pymtur_MiPymeSitePlus=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSitePlus");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#MiPymeSitePlus");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSitePlus> listMiPymeSitePluses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSitePlus>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.MiPymeSitePlus> listMiPymeSitePluses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.MiPymeSitePlus>(it, true);
        }

        public static org.semanticwb.pymtur.MiPymeSitePlus createMiPymeSitePlus(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.MiPymeSitePlus.ClassMgr.createMiPymeSitePlus(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.MiPymeSitePlus getMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MiPymeSitePlus)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.MiPymeSitePlus createMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.MiPymeSitePlus)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasMiPymeSitePlus(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMiPymeSitePlus(id, model)!=null);
        }
    }

    public MiPymeSitePlusBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
