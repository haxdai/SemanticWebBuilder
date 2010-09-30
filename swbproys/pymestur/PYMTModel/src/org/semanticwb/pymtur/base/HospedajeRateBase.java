package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar las tarifas para el giro de Hospedaje. En este momento es la única que se utiliza.Esta clase se asigna en algún giro especifico para que de esta manera las mipymes adscritas a dicho giro manejen dicha clase. 
   */
public abstract class HospedajeRateBase extends org.semanticwb.pymtur.Rate 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_lowSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#lowSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_Capacity=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#Capacity");
    public static final org.semanticwb.platform.SemanticProperty pymtur_HighSeason=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#HighSeason");
    public static final org.semanticwb.platform.SemanticProperty pymtur_roomsNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#roomsNumber");
    public static final org.semanticwb.platform.SemanticProperty pymtur_planType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#planType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_serviceType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#serviceType");
    public static final org.semanticwb.platform.SemanticProperty pymtur_weekedRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#weekedRate");
   /**
   * Clase que se encarga de administrar las tarifas para el giro de Hospedaje. En este momento es la única que se utiliza.Esta clase se asigna en algún giro especifico para que de esta manera las mipymes adscritas a dicho giro manejen dicha clase.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_HospedajeRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#HospedajeRate");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#HospedajeRate");

    public static class ClassMgr
    {
       /**
       * Returns a list of HospedajeRate for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.HospedajeRate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.HospedajeRate> listHospedajeRates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.HospedajeRate>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.HospedajeRate for all models
       * @return Iterator of org.semanticwb.pymtur.HospedajeRate
       */

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
       /**
       * Gets a org.semanticwb.pymtur.HospedajeRate
       * @param id Identifier for org.semanticwb.pymtur.HospedajeRate
       * @param model Model of the org.semanticwb.pymtur.HospedajeRate
       * @return A org.semanticwb.pymtur.HospedajeRate
       */
        public static org.semanticwb.pymtur.HospedajeRate getHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.HospedajeRate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.HospedajeRate
       * @param id Identifier for org.semanticwb.pymtur.HospedajeRate
       * @param model Model of the org.semanticwb.pymtur.HospedajeRate
       * @return A org.semanticwb.pymtur.HospedajeRate
       */
        public static org.semanticwb.pymtur.HospedajeRate createHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.HospedajeRate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.HospedajeRate
       * @param id Identifier for org.semanticwb.pymtur.HospedajeRate
       * @param model Model of the org.semanticwb.pymtur.HospedajeRate
       */
        public static void removeHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.HospedajeRate
       * @param id Identifier for org.semanticwb.pymtur.HospedajeRate
       * @param model Model of the org.semanticwb.pymtur.HospedajeRate
       * @return true if the org.semanticwb.pymtur.HospedajeRate exists, false otherwise
       */

        public static boolean hasHospedajeRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getHospedajeRate(id, model)!=null);
        }
    }

   /**
   * Constructs a HospedajeRateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the HospedajeRate
   */
    public HospedajeRateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the LowSeason property
* @return float with the LowSeason
*/
    public float getLowSeason()
    {
        return getSemanticObject().getFloatProperty(pymtur_lowSeason);
    }

/**
* Sets the LowSeason property
* @param value long with the LowSeason
*/
    public void setLowSeason(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_lowSeason, value);
    }

/**
* Gets the Capacity property
* @return int with the Capacity
*/
    public int getCapacity()
    {
        return getSemanticObject().getIntProperty(pymtur_Capacity);
    }

/**
* Sets the Capacity property
* @param value long with the Capacity
*/
    public void setCapacity(int value)
    {
        getSemanticObject().setIntProperty(pymtur_Capacity, value);
    }

/**
* Gets the HighSeason property
* @return float with the HighSeason
*/
    public float getHighSeason()
    {
        return getSemanticObject().getFloatProperty(pymtur_HighSeason);
    }

/**
* Sets the HighSeason property
* @param value long with the HighSeason
*/
    public void setHighSeason(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_HighSeason, value);
    }

/**
* Gets the RoomsNumber property
* @return int with the RoomsNumber
*/
    public int getRoomsNumber()
    {
        return getSemanticObject().getIntProperty(pymtur_roomsNumber);
    }

/**
* Sets the RoomsNumber property
* @param value long with the RoomsNumber
*/
    public void setRoomsNumber(int value)
    {
        getSemanticObject().setIntProperty(pymtur_roomsNumber, value);
    }

/**
* Gets the PlanType property
* @return String with the PlanType
*/
    public String getPlanType()
    {
        return getSemanticObject().getProperty(pymtur_planType);
    }

/**
* Sets the PlanType property
* @param value long with the PlanType
*/
    public void setPlanType(String value)
    {
        getSemanticObject().setProperty(pymtur_planType, value);
    }

/**
* Gets the ServiceType property
* @return String with the ServiceType
*/
    public String getServiceType()
    {
        return getSemanticObject().getProperty(pymtur_serviceType);
    }

/**
* Sets the ServiceType property
* @param value long with the ServiceType
*/
    public void setServiceType(String value)
    {
        getSemanticObject().setProperty(pymtur_serviceType, value);
    }

/**
* Gets the WeekedRate property
* @return float with the WeekedRate
*/
    public float getWeekedRate()
    {
        return getSemanticObject().getFloatProperty(pymtur_weekedRate);
    }

/**
* Sets the WeekedRate property
* @param value long with the WeekedRate
*/
    public void setWeekedRate(float value)
    {
        getSemanticObject().setFloatProperty(pymtur_weekedRate, value);
    }

   /**
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
