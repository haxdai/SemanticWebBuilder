package org.semanticwb.sieps.base;


public abstract class EmpresaInteresBase extends org.semanticwb.model.base.GenericObjectBase 
{
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty sieps_usuario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#usuario");
    public static final org.semanticwb.platform.SemanticClass sieps_Empresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Empresa");
    public static final org.semanticwb.platform.SemanticProperty sieps_hasEmpresa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#hasEmpresa");
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticClass sieps_EmpresaInteres=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#EmpresaInteres");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#EmpresaInteres");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.EmpresaInteres> listEmpresaIntereses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.EmpresaInteres>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.EmpresaInteres> listEmpresaIntereses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.EmpresaInteres>(it, true);
        }

        public static org.semanticwb.sieps.EmpresaInteres getEmpresaInteres(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.EmpresaInteres)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.EmpresaInteres createEmpresaInteres(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.EmpresaInteres)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeEmpresaInteres(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasEmpresaInteres(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEmpresaInteres(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.EmpresaInteres> listEmpresaInteresByUsuario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.EmpresaInteres> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.EmpresaInteres> listEmpresaInteresByUsuario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.EmpresaInteres> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.EmpresaInteres> listEmpresaInteresByEmpresa(org.semanticwb.sieps.Empresa value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.EmpresaInteres> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_hasEmpresa, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.EmpresaInteres> listEmpresaInteresByEmpresa(org.semanticwb.sieps.Empresa value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.EmpresaInteres> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_hasEmpresa,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public EmpresaInteresBase(org.semanticwb.platform.SemanticObject base)
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

    public org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa> listEmpresas()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Empresa>(getSemanticObject().listObjectProperties(sieps_hasEmpresa));
    }

    public boolean hasEmpresa(org.semanticwb.sieps.Empresa value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(sieps_hasEmpresa,value.getSemanticObject());
        }
        return ret;
    }

    public void addEmpresa(org.semanticwb.sieps.Empresa value)
    {
        getSemanticObject().addObjectProperty(sieps_hasEmpresa, value.getSemanticObject());
    }

    public void removeAllEmpresa()
    {
        getSemanticObject().removeProperty(sieps_hasEmpresa);
    }

    public void removeEmpresa(org.semanticwb.sieps.Empresa value)
    {
        getSemanticObject().removeObjectProperty(sieps_hasEmpresa,value.getSemanticObject());
    }

    public org.semanticwb.sieps.Empresa getEmpresa()
    {
         org.semanticwb.sieps.Empresa ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_hasEmpresa);
         if(obj!=null)
         {
             ret=(org.semanticwb.sieps.Empresa)obj.createGenericInstance();
         }
         return ret;
    }

    public boolean isValid()
    {
        //Override this method in EmpresaInteres object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

    public void setValid(boolean value)
    {
        //Override this method in EmpresaInteres object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
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
