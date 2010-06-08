package org.semanticwb.sieps.base;


public abstract class PerfilBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty sieps_usuario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#usuario");
    public static final org.semanticwb.platform.SemanticClass sieps_Perfil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Perfil");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Perfil");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Perfil> listPerfils(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Perfil>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Perfil> listPerfils()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Perfil>(it, true);
        }

        public static org.semanticwb.sieps.Perfil getPerfil(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Perfil)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Perfil createPerfil(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Perfil)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removePerfil(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasPerfil(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPerfil(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Perfil> listPerfilByUsuario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Perfil> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Perfil> listPerfilByUsuario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Perfil> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_usuario,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public PerfilBase(org.semanticwb.platform.SemanticObject base)
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
}
