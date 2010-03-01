package org.semanticwb.pymtur.base;


public abstract class RateBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_lowSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#lowSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_serviceType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#serviceType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_Capacity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#Capacity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_HighSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#HighSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_planType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#planType");
    public static final org.semanticwb.platform.SemanticClass pymtur_Rate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Rate");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Rate");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.Rate> listRates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.Rate> listRates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Rate>(it, true);
        }

        public static org.semanticwb.pymtur.Rate createRate(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.Rate.ClassMgr.createRate(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.Rate getRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Rate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.Rate createRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Rate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeRate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRate(id, model)!=null);
        }
    }

    public RateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

    public float getLowSeason()
    {
        return getSemanticObject().getFloatProperty(pymtur_lowSeason);
    }

    public void setLowSeason(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_lowSeason, value);
    }

    public String getServiceType()
    {
        return getSemanticObject().getProperty(pymtur_serviceType);
    }

    public void setServiceType(String value)
    {
        getSemanticObject().setProperty(pymtur_serviceType, value);
    }

    public int getCapacity()
    {
        return getSemanticObject().getIntProperty(pymtur_Capacity);
    }

    public void setCapacity(int value)
    {
        getSemanticObject().setIntProperty(pymtur_Capacity, value);
    }

    public float getHighSeason()
    {
        return getSemanticObject().getFloatProperty(pymtur_HighSeason);
    }

    public void setHighSeason(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_HighSeason, value);
    }

    public String getPlanType()
    {
        return getSemanticObject().getProperty(pymtur_planType);
    }

    public void setPlanType(String value)
    {
        getSemanticObject().setProperty(pymtur_planType, value);
    }
}
