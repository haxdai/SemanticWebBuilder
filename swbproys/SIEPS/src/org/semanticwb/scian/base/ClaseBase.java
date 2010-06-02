package org.semanticwb.scian.base;


public abstract class ClaseBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty scian_code=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.inegi.gob.mx/2002/scian#code");
    public static final org.semanticwb.platform.SemanticClass scian_Clase=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Clase");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Clase");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.scian.Clase> listClases(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.Clase>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.scian.Clase> listClases()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.scian.Clase>(it, true);
        }

        public static org.semanticwb.scian.Clase getClase(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.Clase)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.scian.Clase createClase(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.scian.Clase)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeClase(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasClase(String id, org.semanticwb.model.SWBModel model)
        {
            return (getClase(id, model)!=null);
        }
    }

    public ClaseBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getCode()
    {
        return getSemanticObject().getProperty(scian_code);
    }

    public void setCode(String value)
    {
        getSemanticObject().setProperty(scian_code, value);
    }
}
