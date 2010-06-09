package org.semanticwb.sieps.base;


public abstract class ProductoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass unspsc_Commodity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ontoview.org/schema/unspsc/1#Commodity");
    public static final org.semanticwb.platform.SemanticProperty sieps_unspsc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#unspsc");
    public static final org.semanticwb.platform.SemanticProperty sieps_foto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#foto");
    public static final org.semanticwb.platform.SemanticProperty sieps_pname=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#pname");
    public static final org.semanticwb.platform.SemanticProperty sieps_unidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#unidad");
    public static final org.semanticwb.platform.SemanticProperty sieps_precioprom=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#precioprom");
    public static final org.semanticwb.platform.SemanticClass sieps_Empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Empresa");
    public static final org.semanticwb.platform.SemanticProperty sieps_fabricaInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#fabricaInv");
    public static final org.semanticwb.platform.SemanticClass sieps_Producto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Producto");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Producto");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Producto> listProductos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Producto> listProductos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto>(it, true);
        }

        public static org.semanticwb.sieps.Producto createProducto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.sieps.Producto.ClassMgr.createProducto(String.valueOf(id), model);
        }

        public static org.semanticwb.sieps.Producto getProducto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Producto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Producto createProducto(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Producto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeProducto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasProducto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getProducto(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Producto> listProductoByUnspsc(org.semanticwb.unspsc.Commodity value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_unspsc, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Producto> listProductoByUnspsc(org.semanticwb.unspsc.Commodity value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_unspsc,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Producto> listProductoByFabrica(org.semanticwb.sieps.Empresa value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_fabricaInv, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Producto> listProductoByFabrica(org.semanticwb.sieps.Empresa value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_fabricaInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public ProductoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setUnspsc(org.semanticwb.unspsc.Commodity value)
    {
        getSemanticObject().setObjectProperty(sieps_unspsc, value.getSemanticObject());
    }

    public void removeUnspsc()
    {
        getSemanticObject().removeProperty(sieps_unspsc);
    }

    public org.semanticwb.unspsc.Commodity getUnspsc()
    {
         org.semanticwb.unspsc.Commodity ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_unspsc);
         if(obj!=null)
         {
             ret=(org.semanticwb.unspsc.Commodity)obj.createGenericInstance();
         }
         return ret;
    }

    public String getFoto()
    {
        return getSemanticObject().getProperty(sieps_foto);
    }

    public void setFoto(String value)
    {
        getSemanticObject().setProperty(sieps_foto, value);
    }

    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

    public String getPname()
    {
        return getSemanticObject().getProperty(sieps_pname);
    }

    public void setPname(String value)
    {
        getSemanticObject().setProperty(sieps_pname, value);
    }

    public String getUnidad()
    {
        return getSemanticObject().getProperty(sieps_unidad);
    }

    public void setUnidad(String value)
    {
        getSemanticObject().setProperty(sieps_unidad, value);
    }

    public float getPrecioprom()
    {
        return getSemanticObject().getFloatProperty(sieps_precioprom);
    }

    public void setPrecioprom(float value)
    {
        getSemanticObject().setFloatProperty(sieps_precioprom, value);
    }

    public void setFabrica(org.semanticwb.sieps.Empresa value)
    {
        getSemanticObject().setObjectProperty(sieps_fabricaInv, value.getSemanticObject());
    }

    public void removeFabrica()
    {
        getSemanticObject().removeProperty(sieps_fabricaInv);
    }

    public org.semanticwb.sieps.Empresa getFabrica()
    {
         org.semanticwb.sieps.Empresa ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_fabricaInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.sieps.Empresa)obj.createGenericInstance();
         }
         return ret;
    }

    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }
}
