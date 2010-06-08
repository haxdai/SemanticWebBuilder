package org.semanticwb.sieps.base;


public abstract class CertificadoBase extends org.semanticwb.model.base.GenericObjectBase 
{
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty sieps_usuario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#usuario");
    public static final org.semanticwb.platform.SemanticClass sieps_Empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Empresa");
    public static final org.semanticwb.platform.SemanticProperty sieps_empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#empresa");
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticProperty sieps_certificado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#certificado");
    public static final org.semanticwb.platform.SemanticClass sieps_Certificado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Certificado");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Certificado");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Certificado> listCertificados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Certificado>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Certificado> listCertificados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Certificado>(it, true);
        }

        public static org.semanticwb.sieps.Certificado getCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Certificado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Certificado createCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Certificado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasCertificado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCertificado(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Certificado> listCertificadoByUsuario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Certificado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Certificado> listCertificadoByUsuario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Certificado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Certificado> listCertificadoByEmpresa(org.semanticwb.sieps.Empresa value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Certificado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_empresa, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Certificado> listCertificadoByEmpresa(org.semanticwb.sieps.Empresa value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Certificado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_empresa,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public CertificadoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setUsuario(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(sieps_usuario, value.getSemanticObject());
    }

    public void removeUsuario()
    {
        getSemanticObject().removeProperty(sieps_usuario);
    }

    public org.semanticwb.model.User getUsuario()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_usuario);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

    public void setEmpresa(org.semanticwb.sieps.Empresa value)
    {
        getSemanticObject().setObjectProperty(sieps_empresa, value.getSemanticObject());
    }

    public void removeEmpresa()
    {
        getSemanticObject().removeProperty(sieps_empresa);
    }

    public org.semanticwb.sieps.Empresa getEmpresa()
    {
         org.semanticwb.sieps.Empresa ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_empresa);
         if(obj!=null)
         {
             ret=(org.semanticwb.sieps.Empresa)obj.createGenericInstance();
         }
         return ret;
    }

    public boolean isValid()
    {
        //Override this method in Certificado object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

    public void setValid(boolean value)
    {
        //Override this method in Certificado object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

    public String getCertificado()
    {
        return getSemanticObject().getProperty(sieps_certificado);
    }

    public void setCertificado(String value)
    {
        getSemanticObject().setProperty(sieps_certificado, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
