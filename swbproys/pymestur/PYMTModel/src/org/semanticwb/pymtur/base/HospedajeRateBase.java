package org.semanticwb.pymtur.base;


public abstract class HospedajeRateBase extends org.semanticwb.pymtur.Rate 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_lowSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#lowSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_Capacity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#Capacity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_HighSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#HighSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_roomsNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#roomsNumber");
    public static final org.semanticwb.platform.SemanticProperty pymtur_planType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#planType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_serviceType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#serviceType");
    public static final org.semanticwb.platform.SemanticClass pymtur_HospedajeRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#HospedajeRate");
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#HospedajeRate");

    public static class ClassMgr
    {

        public static java.util.Iterator<org.semanticwb.pymtur.HospedajeRate> listHospedajeRates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.HospedajeRate>(it, true);
        }

        public static java.util.Iterator<org.semanticwb.pymtur.HospedajeRate> listHospedajeRates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.HospedajeRate>(it, true);
        }

        public static org.semanticwb.pymtur.HospedajeRate createHospedajeRate(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.HospedajeRate.ClassMgr.createHospedajeRate(String.valueOf(id), model);
        }

        public static org.semanticwb.pymtur.HospedajeRate getHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.HospedajeRate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }

        public static org.semanticwb.pymtur.HospedajeRate createHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.HospedajeRate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id, sclass), sclass);
        }

        public static void removeHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }

        public static boolean hasHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHospedajeRate(id, model)!=null);
        }
    }

    public HospedajeRateBase(org.semanticwb.platform.SemanticObject base)
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

    public int getRoomsNumber()
    {
        return getSemanticObject().getIntProperty(pymtur_roomsNumber);
    }

    public void setRoomsNumber(int value)
    {
        getSemanticObject().setIntProperty(pymtur_roomsNumber, value);
    }

    public String getPlanType()
    {
        return getSemanticObject().getProperty(pymtur_planType);
    }

    public void setPlanType(String value)
    {
        getSemanticObject().setProperty(pymtur_planType, value);
    }

    public String getServiceType()
    {
        return getSemanticObject().getProperty(pymtur_serviceType);
    }

    public void setServiceType(String value)
    {
        getSemanticObject().setProperty(pymtur_serviceType, value);
    }

    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
