package org.semanticwb.sieps.base;


public abstract class CamaraBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass scian_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.inegi.gob.mx/2002/scian#Sector");
    public static final org.semanticwb.platform.SemanticProperty sieps_industria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#industria");
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty sieps_administrador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/SIEPS#administrador");
    public static final org.semanticwb.platform.SemanticClass sieps_Camara=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Camara");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/SIEPS#Camara");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.sieps.Camara> listCamaras(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Camara>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Camara> listCamaras()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Camara>(it, true);
        }

        public static org.semanticwb.sieps.Camara getCamara(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Camara)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.sieps.Camara createCamara(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.sieps.Camara)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeCamara(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasCamara(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCamara(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.sieps.Camara> listCamaraByIndustria(org.semanticwb.scian.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Camara> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_industria, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Camara> listCamaraByIndustria(org.semanticwb.scian.Sector value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Camara> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_industria,value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Camara> listCamaraByAdministrador(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Camara> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(sieps_administrador, value.getSemanticObject(),sclass));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.sieps.Camara> listCamaraByAdministrador(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.sieps.Camara> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(sieps_administrador,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public CamaraBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public void setIndustria(org.semanticwb.scian.Sector value)
    {
        getSemanticObject().setObjectProperty(sieps_industria, value.getSemanticObject());
    }

    public void removeIndustria()
    {
        getSemanticObject().removeProperty(sieps_industria);
    }

    public org.semanticwb.scian.Sector getIndustria()
    {
         org.semanticwb.scian.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_industria);
         if(obj!=null)
         {
             ret=(org.semanticwb.scian.Sector)obj.createGenericInstance();
         }
         return ret;
    }

    public void setAdministrador(org.semanticwb.model.User value)
    {
        getSemanticObject().setObjectProperty(sieps_administrador, value.getSemanticObject());
    }

    public void removeAdministrador()
    {
        getSemanticObject().removeProperty(sieps_administrador);
    }

    public org.semanticwb.model.User getAdministrador()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(sieps_administrador);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
