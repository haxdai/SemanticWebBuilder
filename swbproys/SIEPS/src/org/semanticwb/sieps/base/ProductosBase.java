package org.semanticwb.sieps.base;


public abstract class ProductosBase extends org.semanticwb.sieps.Perfil 
{
    public static final org.semanticwb.platform.SemanticClass sieps_Producto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Producto");
    public static final org.semanticwb.platform.SemanticProperty sieps_hasProductos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#hasProductos");
    public static final org.semanticwb.platform.SemanticClass sieps_Productos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Productos");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Productos");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Productos> listProductoses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Productos>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Productos> listProductoses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Productos>(it, true);
        }

        public static org.semanticwb.sieps.Productos getProductos(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Productos)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Productos createProductos(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Productos)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeProductos(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasProductos(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProductos(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Productos> listProductosByUsuario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Productos> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Productos> listProductosByUsuario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Productos> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Productos> listProductosByProductos(org.semanticwb.sieps.Producto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Productos> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_hasProductos, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Productos> listProductosByProductos(org.semanticwb.sieps.Producto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Productos> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_hasProductos,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public ProductosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto> listProductoses()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto>(getSemanticObject().listObjectProperties(sieps_hasProductos));
    }

    public boolean hasProductos(org.semanticwb.sieps.Producto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(sieps_hasProductos,value.getSemanticObject());
        }
        return ret;
    }

    public void addProductos(org.semanticwb.sieps.Producto value)
    {
        getSemanticObject().addObjectProperty(sieps_hasProductos, value.getSemanticObject());
    }

    public void removeAllProductos()
    {
        getSemanticObject().removeProperty(sieps_hasProductos);
    }

    public void removeProductos(org.semanticwb.sieps.Producto value)
    {
        getSemanticObject().removeObjectProperty(sieps_hasProductos,value.getSemanticObject());
    }

    public org.semanticwb.sieps.Producto getProductos()
    {
         org.semanticwb.sieps.Producto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_hasProductos);
         if(obj!=null)
         {
             ret=(org.semanticwb.sieps.Producto)obj.createGenericInstance();
         }
         return ret;
    }
}
