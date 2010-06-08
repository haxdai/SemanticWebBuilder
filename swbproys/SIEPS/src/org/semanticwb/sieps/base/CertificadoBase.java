package org.semanticwb.sieps.base;


public abstract class CertificadoBase extends org.semanticwb.sieps.Perfil 
{
    public static final org.semanticwb.platform.SemanticProperty sieps_created=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#created");
    public static final org.semanticwb.platform.SemanticClass sieps_Empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Empresa");
    public static final org.semanticwb.platform.SemanticProperty sieps_empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#empresa");
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

        public static org.semanticwb.sieps.Certificado createCertificado(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.sieps.Certificado.ClassMgr.createCertificado(String.valueOf(id), model);
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

    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(sieps_created);
    }

    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(sieps_created, value);
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

    public String getCertificado()
    {
        return getSemanticObject().getProperty(sieps_certificado);
    }

    public void setCertificado(String value)
    {
        getSemanticObject().setProperty(sieps_certificado, value);
    }
}
