package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar las tarifas para el giro de Alimentos. En este momento no se utiliza dado que solo se utiliza por definición el giro de hospedaje.Esta clase se asigna en algún giro especifico para que de esta manera las mipymes adscritas a dicho giro manejen dicha clase. 
   */
public abstract class AlimentosRateBase extends org.semanticwb.pymtur.Rate 
{
    public static final org.semanticwb.platform.SemanticProperty pymtur_tableNumber=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#tableNumber");
   /**
   * Clase que se encarga de administrar las tarifas para el giro de Alimentos. En este momento no se utiliza dado que solo se utiliza por definición el giro de hospedaje.Esta clase se asigna en algún giro especifico para que de esta manera las mipymes adscritas a dicho giro manejen dicha clase.
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_AlimentosRate=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#AlimentosRate");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#AlimentosRate");

    public static class ClassMgr
    {
       /**
       * Returns a list of AlimentosRate for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.AlimentosRate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.AlimentosRate> listAlimentosRates(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.AlimentosRate>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.AlimentosRate for all models
       * @return Iterator of org.semanticwb.pymtur.AlimentosRate
       */

        public static java.util.Iterator<org.semanticwb.pymtur.AlimentosRate> listAlimentosRates()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.AlimentosRate>(it, true);
        }

        public static org.semanticwb.pymtur.AlimentosRate createAlimentosRate(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.pymtur.AlimentosRate.ClassMgr.createAlimentosRate(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.pymtur.AlimentosRate
       * @param id Identifier for org.semanticwb.pymtur.AlimentosRate
       * @param model Model of the org.semanticwb.pymtur.AlimentosRate
       * @return A org.semanticwb.pymtur.AlimentosRate
       */
        public static org.semanticwb.pymtur.AlimentosRate getAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.AlimentosRate)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.AlimentosRate
       * @param id Identifier for org.semanticwb.pymtur.AlimentosRate
       * @param model Model of the org.semanticwb.pymtur.AlimentosRate
       * @return A org.semanticwb.pymtur.AlimentosRate
       */
        public static org.semanticwb.pymtur.AlimentosRate createAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.AlimentosRate)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.AlimentosRate
       * @param id Identifier for org.semanticwb.pymtur.AlimentosRate
       * @param model Model of the org.semanticwb.pymtur.AlimentosRate
       */
        public static void removeAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.AlimentosRate
       * @param id Identifier for org.semanticwb.pymtur.AlimentosRate
       * @param model Model of the org.semanticwb.pymtur.AlimentosRate
       * @return true if the org.semanticwb.pymtur.AlimentosRate exists, false otherwise
       */

        public static boolean hasAlimentosRate(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAlimentosRate(id, model)!=null);
        }
    }

   /**
   * Constructs a AlimentosRateBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AlimentosRate
   */
    public AlimentosRateBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the TableNumber property
* @return int with the TableNumber
*/
    public int getTableNumber()
    {
        return getSemanticObject().getIntProperty(pymtur_tableNumber);
    }

/**
* Sets the TableNumber property
* @param value long with the TableNumber
*/
    public void setTableNumber(int value)
    {
        getSemanticObject().setIntProperty(pymtur_tableNumber, value);
    }
}
