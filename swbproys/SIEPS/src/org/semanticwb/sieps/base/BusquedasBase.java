package org.semanticwb.sieps.base;


public abstract class BusquedasBase extends org.semanticwb.sieps.Perfil 
{
    public static final org.semanticwb.platform.SemanticClass sieps_Busqueda=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Busqueda");
    public static final org.semanticwb.platform.SemanticProperty sieps_hasBusqueda=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#hasBusqueda");
    public static final org.semanticwb.platform.SemanticClass sieps_Busquedas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Busquedas");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Busquedas");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Busquedas> listBusquedases(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busquedas>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Busquedas> listBusquedases()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busquedas>(it, true);
        }

        public static org.semanticwb.sieps.Busquedas getBusquedas(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Busquedas)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Busquedas createBusquedas(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Busquedas)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeBusquedas(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasBusquedas(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBusquedas(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Busquedas> listBusquedasByUsuario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busquedas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Busquedas> listBusquedasByUsuario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busquedas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Busquedas> listBusquedasByBusqueda(org.semanticwb.sieps.Busqueda value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busquedas> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_hasBusqueda, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Busquedas> listBusquedasByBusqueda(org.semanticwb.sieps.Busqueda value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busquedas> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_hasBusqueda,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public BusquedasBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busqueda> listBusquedas()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Busqueda>(getSemanticObject().listObjectProperties(sieps_hasBusqueda));
    }

    public boolean hasBusqueda(org.semanticwb.sieps.Busqueda value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(sieps_hasBusqueda,value.getSemanticObject());
        }
        return ret;
    }

    public void addBusqueda(org.semanticwb.sieps.Busqueda value)
    {
        getSemanticObject().addObjectProperty(sieps_hasBusqueda, value.getSemanticObject());
    }

    public void removeAllBusqueda()
    {
        getSemanticObject().removeProperty(sieps_hasBusqueda);
    }

    public void removeBusqueda(org.semanticwb.sieps.Busqueda value)
    {
        getSemanticObject().removeObjectProperty(sieps_hasBusqueda,value.getSemanticObject());
    }

    public org.semanticwb.sieps.Busqueda getBusqueda()
    {
         org.semanticwb.sieps.Busqueda ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_hasBusqueda);
         if(obj!=null)
         {
             ret=(org.semanticwb.sieps.Busqueda)obj.createGenericInstance();
         }
         return ret;
    }
}
