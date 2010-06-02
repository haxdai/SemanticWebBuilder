package org.semanticwb.sieps.base;


public abstract class EmpresaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty sieps_address=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#address");
    public static final org.semanticwb.platform.SemanticProperty sieps_logo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#logo");
    public static final org.semanticwb.platform.SemanticProperty sieps_estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#estado");
    public static final org.semanticwb.platform.SemanticProperty sieps_name=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#name");
    public static final org.semanticwb.platform.SemanticProperty sieps_telefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#telefono");
    public static final org.semanticwb.platform.SemanticProperty sieps_cp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#cp");
    public static final org.semanticwb.platform.SemanticClass scian_Clase=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Clase");
    public static final org.semanticwb.platform.SemanticProperty sieps_scian=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#scian");
    public static final org.semanticwb.platform.SemanticProperty sieps_clavesiem=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#clavesiem");
    public static final org.semanticwb.platform.SemanticProperty sieps_colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#colonia");
    public static final org.semanticwb.platform.SemanticProperty sieps_descripcion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#descripcion");
    public static final org.semanticwb.platform.SemanticProperty sieps_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#rfc");
    public static final org.semanticwb.platform.SemanticClass sieps_Producto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Producto");
    public static final org.semanticwb.platform.SemanticProperty sieps_hasProducto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#hasProducto");
    public static final org.semanticwb.platform.SemanticProperty sieps_email=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#email");
    public static final org.semanticwb.platform.SemanticProperty sieps_municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#municipio");
    public static final org.semanticwb.platform.SemanticClass sieps_Empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Empresa");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Empresa");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Empresa> listEmpresas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Empresa> listEmpresas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa>(it, true);
        }

        public static org.semanticwb.sieps.Empresa getEmpresa(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Empresa)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Empresa createEmpresa(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Empresa)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeEmpresa(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasEmpresa(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEmpresa(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Empresa> listEmpresaByScian(org.semanticwb.scian.Clase value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_scian, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Empresa> listEmpresaByScian(org.semanticwb.scian.Clase value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_scian,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Empresa> listEmpresaByProducto(org.semanticwb.sieps.Producto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_hasProducto, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Empresa> listEmpresaByProducto(org.semanticwb.sieps.Producto value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_hasProducto,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public EmpresaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getAddress()
    {
        return getSemanticObject().getProperty(sieps_address);
    }

    public void setAddress(String value)
    {
        getSemanticObject().setProperty(sieps_address, value);
    }

    public String getLogo()
    {
        return getSemanticObject().getProperty(sieps_logo);
    }

    public void setLogo(String value)
    {
        getSemanticObject().setProperty(sieps_logo, value);
    }

    public String getEstado()
    {
        return getSemanticObject().getProperty(sieps_estado);
    }

    public void setEstado(String value)
    {
        getSemanticObject().setProperty(sieps_estado, value);
    }

    public String getName()
    {
        return getSemanticObject().getProperty(sieps_name);
    }

    public void setName(String value)
    {
        getSemanticObject().setProperty(sieps_name, value);
    }

    public String getTelefono()
    {
        return getSemanticObject().getProperty(sieps_telefono);
    }

    public void setTelefono(String value)
    {
        getSemanticObject().setProperty(sieps_telefono, value);
    }

    public String getCp()
    {
        return getSemanticObject().getProperty(sieps_cp);
    }

    public void setCp(String value)
    {
        getSemanticObject().setProperty(sieps_cp, value);
    }

    public void setScian(org.semanticwb.scian.Clase value)
    {
        getSemanticObject().setObjectProperty(sieps_scian, value.getSemanticObject());
    }

    public void removeScian()
    {
        getSemanticObject().removeProperty(sieps_scian);
    }

    public org.semanticwb.scian.Clase getScian()
    {
         org.semanticwb.scian.Clase ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_scian);
         if(obj!=null)
         {
             ret=(org.semanticwb.scian.Clase)obj.createGenericInstance();
         }
         return ret;
    }

    public String getClavesiem()
    {
        return getSemanticObject().getProperty(sieps_clavesiem);
    }

    public void setClavesiem(String value)
    {
        getSemanticObject().setProperty(sieps_clavesiem, value);
    }

    public String getColonia()
    {
        return getSemanticObject().getProperty(sieps_colonia);
    }

    public void setColonia(String value)
    {
        getSemanticObject().setProperty(sieps_colonia, value);
    }

    public String getDescripcion()
    {
        return getSemanticObject().getProperty(sieps_descripcion);
    }

    public void setDescripcion(String value)
    {
        getSemanticObject().setProperty(sieps_descripcion, value);
    }

    public String getRfc()
    {
        return getSemanticObject().getProperty(sieps_rfc);
    }

    public void setRfc(String value)
    {
        getSemanticObject().setProperty(sieps_rfc, value);
    }

    public org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto> listProductos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Producto>(getSemanticObject().listObjectProperties(sieps_hasProducto));
    }

    public boolean hasProducto(org.semanticwb.sieps.Producto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(sieps_hasProducto,value.getSemanticObject());
        }
        return ret;
    }

    public void addProducto(org.semanticwb.sieps.Producto value)
    {
        getSemanticObject().addObjectProperty(sieps_hasProducto, value.getSemanticObject());
    }

    public void removeAllProducto()
    {
        getSemanticObject().removeProperty(sieps_hasProducto);
    }

    public void removeProducto(org.semanticwb.sieps.Producto value)
    {
        getSemanticObject().removeObjectProperty(sieps_hasProducto,value.getSemanticObject());
    }

    public org.semanticwb.sieps.Producto getProducto()
    {
         org.semanticwb.sieps.Producto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_hasProducto);
         if(obj!=null)
         {
             ret=(org.semanticwb.sieps.Producto)obj.createGenericInstance();
         }
         return ret;
    }

    public String getEmail()
    {
        return getSemanticObject().getProperty(sieps_email);
    }

    public void setEmail(String value)
    {
        getSemanticObject().setProperty(sieps_email, value);
    }

    public String getMunicipio()
    {
        return getSemanticObject().getProperty(sieps_municipio);
    }

    public void setMunicipio(String value)
    {
        getSemanticObject().setProperty(sieps_municipio, value);
    }
}
