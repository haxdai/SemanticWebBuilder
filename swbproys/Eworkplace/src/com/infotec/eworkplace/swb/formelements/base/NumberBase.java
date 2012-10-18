package com.infotec.eworkplace.swb.formelements.base;


   /**
   * Caja de texto para capturar numero a n digitos 
   */
public abstract class NumberBase extends org.semanticwb.model.base.FormElementBase 
{
    public static final org.semanticwb.platform.SemanticProperty intraxf_numberCero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet/formelements#numberCero");
    public static final org.semanticwb.platform.SemanticProperty intraxf_ndigits=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet/formelements#ndigits");
   /**
   * Caja de texto para capturar numero a n digitos
   */
    public static final org.semanticwb.platform.SemanticClass intraxf_Number=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet/formelements#Number");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet/formelements#Number");

    public static class ClassMgr
    {
       /**
       * Returns a list of Number for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.formelements.Number
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.formelements.Number> listNumbers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.formelements.Number>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.formelements.Number for all models
       * @return Iterator of com.infotec.eworkplace.swb.formelements.Number
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.formelements.Number> listNumbers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.formelements.Number>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.formelements.Number
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Number
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Number
       * @return A com.infotec.eworkplace.swb.formelements.Number
       */
        public static com.infotec.eworkplace.swb.formelements.Number getNumber(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.formelements.Number)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.formelements.Number
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Number
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Number
       * @return A com.infotec.eworkplace.swb.formelements.Number
       */
        public static com.infotec.eworkplace.swb.formelements.Number createNumber(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.formelements.Number)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.formelements.Number
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Number
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Number
       */
        public static void removeNumber(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.formelements.Number
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Number
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Number
       * @return true if the com.infotec.eworkplace.swb.formelements.Number exists, false otherwise
       */

        public static boolean hasNumber(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNumber(id, model)!=null);
        }
    }

    public static NumberBase.ClassMgr getNumberClassMgr()
    {
        return new NumberBase.ClassMgr();
    }

   /**
   * Constructs a NumberBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Number
   */
    public NumberBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NumberCero property
* @return boolean with the NumberCero
*/
    public boolean isNumberCero()
    {
        return getSemanticObject().getBooleanProperty(intraxf_numberCero);
    }

/**
* Sets the NumberCero property
* @param value long with the NumberCero
*/
    public void setNumberCero(boolean value)
    {
        getSemanticObject().setBooleanProperty(intraxf_numberCero, value);
    }

/**
* Gets the Ndigits property
* @return int with the Ndigits
*/
    public int getNdigits()
    {
        return getSemanticObject().getIntProperty(intraxf_ndigits);
    }

/**
* Sets the Ndigits property
* @param value long with the Ndigits
*/
    public void setNdigits(int value)
    {
        getSemanticObject().setIntProperty(intraxf_ndigits, value);
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
