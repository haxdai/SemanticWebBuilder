package org.semanticwb.pymtur.base;


public abstract class CuponBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Iconable
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponPeriod=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponPeriod");
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponConditions=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponConditions");
    public static final org.semanticwb.platform.SemanticClass pymtur_ServiceProvider=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#ServiceProvider");
    public static final org.semanticwb.platform.SemanticProperty pymtur_cuponServiceProviderInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#cuponServiceProviderInv");
    public static final org.semanticwb.platform.SemanticClass pymtur_Cupon=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Cupon");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCupons(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCupons()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon>(it, true);
        }

        public static org.semanticwb.pymtur.Cupon createCupon(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.Cupon.ClassMgr.createCupon(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.Cupon getCupon(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Cupon)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.Cupon createCupon(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Cupon)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeCupon(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasCupon(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCupon(id, model)!=null);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCuponByCuponServiceProviderInv(org.semanticwb.pymtur.ServiceProvider cuponserviceproviderinv,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjects(pymtur_cuponServiceProviderInv, cuponserviceproviderinv.getSemanticObject()));
            return it;
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Cupon> listCuponByCuponServiceProviderInv(org.semanticwb.pymtur.ServiceProvider cuponserviceproviderinv)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Cupon> it=new org.semanticwb.model.GenericIterator(cuponserviceproviderinv.getSemanticObject().getModel().listSubjects(pymtur_cuponServiceProviderInv,cuponserviceproviderinv.getSemanticObject()));
            return it;
        }
    }

    public CuponBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public String getCuponPeriod()
    {
        return getSemanticObject().getProperty(pymtur_cuponPeriod);
    }

    public void setCuponPeriod(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponPeriod, value);
    }

    public String getCuponConditions()
    {
        return getSemanticObject().getProperty(pymtur_cuponConditions);
    }

    public void setCuponConditions(String value)
    {
        getSemanticObject().setProperty(pymtur_cuponConditions, value);
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

    public String getIconClass()
    {
        return getSemanticObject().getProperty(swb_iconClass);
    }

    public void setIconClass(String value)
    {
        getSemanticObject().setProperty(swb_iconClass, value);
    }

    public void setCuponServiceProviderInv(org.semanticwb.pymtur.ServiceProvider value)
    {
        getSemanticObject().setObjectProperty(pymtur_cuponServiceProviderInv, value.getSemanticObject());
    }

    public void removeCuponServiceProviderInv()
    {
        getSemanticObject().removeProperty(pymtur_cuponServiceProviderInv);
    }

    public org.semanticwb.pymtur.ServiceProvider getCuponServiceProviderInv()
    {
         org.semanticwb.pymtur.ServiceProvider ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(pymtur_cuponServiceProviderInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.pymtur.ServiceProvider)obj.createGenericInstance();
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
