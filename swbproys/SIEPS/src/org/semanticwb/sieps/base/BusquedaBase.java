package org.semanticwb.sieps.base;


public abstract class BusquedaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty sieps_title=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#title");
    public static final org.semanticwb.platform.SemanticProperty sieps_seach=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#seach");
    public static final org.semanticwb.platform.SemanticClass sieps_Busqueda=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Busqueda");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Busqueda");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Busqueda> listBusquedas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busqueda>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Busqueda> listBusquedas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busqueda>(it, true);
        }

        public static org.semanticwb.sieps.Busqueda getBusqueda(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Busqueda)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Busqueda createBusqueda(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Busqueda)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeBusqueda(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasBusqueda(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBusqueda(id, model)!=null);
        }
    }

    public BusquedaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(sieps_title);
    }

    public void setTitle(String value)
    {
        getSemanticObject().setProperty(sieps_title, value);
    }

    public String getSeach()
    {
        return getSemanticObject().getProperty(sieps_seach);
    }

    public void setSeach(String value)
    {
        getSemanticObject().setProperty(sieps_seach, value);
    }
}
