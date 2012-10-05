package com.infotec.eworkplace.swb.formelements.base;


   /**
   * Caja de texto para capturar moneda, guarda el valor como decimal 
   */
public abstract class CurrencyBase extends org.semanticwb.model.base.FormElementBase 
{
   /**
   * Formato a usar para capturar moneda, no tiene limitante
   */
    public static final org.semanticwb.platform.SemanticProperty intraxf_format=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet/formelements#format");
   /**
   * Caja de texto para capturar moneda, guarda el valor como decimal
   */
    public static final org.semanticwb.platform.SemanticClass intraxf_Currency=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet/formelements#Currency");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet/formelements#Currency");

    public static class ClassMgr
    {
       /**
       * Returns a list of Currency for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.formelements.Currency
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.formelements.Currency> listCurrencies(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.formelements.Currency>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.formelements.Currency for all models
       * @return Iterator of com.infotec.eworkplace.swb.formelements.Currency
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.formelements.Currency> listCurrencies()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.formelements.Currency>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.formelements.Currency
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Currency
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Currency
       * @return A com.infotec.eworkplace.swb.formelements.Currency
       */
        public static com.infotec.eworkplace.swb.formelements.Currency getCurrency(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.formelements.Currency)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.formelements.Currency
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Currency
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Currency
       * @return A com.infotec.eworkplace.swb.formelements.Currency
       */
        public static com.infotec.eworkplace.swb.formelements.Currency createCurrency(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.formelements.Currency)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.formelements.Currency
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Currency
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Currency
       */
        public static void removeCurrency(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.formelements.Currency
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Currency
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Currency
       * @return true if the com.infotec.eworkplace.swb.formelements.Currency exists, false otherwise
       */

        public static boolean hasCurrency(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCurrency(id, model)!=null);
        }
    }

   /**
   * Constructs a CurrencyBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Currency
   */
    public CurrencyBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Format property
* @return String with the Format
*/
    public String getFormat()
    {
        return getSemanticObject().getProperty(intraxf_format);
    }

/**
* Sets the Format property
* @param value long with the Format
*/
    public void setFormat(String value)
    {
        getSemanticObject().setProperty(intraxf_format, value);
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
