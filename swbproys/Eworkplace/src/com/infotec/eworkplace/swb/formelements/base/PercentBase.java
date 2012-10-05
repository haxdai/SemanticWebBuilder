package com.infotec.eworkplace.swb.formelements.base;


   /**
   * Percent texto box 
   */
public abstract class PercentBase extends org.semanticwb.model.base.FormElementBase 
{
    public static final org.semanticwb.platform.SemanticProperty intraxf_percentCero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet/formelements#percentCero");
   /**
   * Percent texto box
   */
    public static final org.semanticwb.platform.SemanticClass intraxf_Percent=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet/formelements#Percent");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet/formelements#Percent");

    public static class ClassMgr
    {
       /**
       * Returns a list of Percent for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.formelements.Percent
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.formelements.Percent> listPercents(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.formelements.Percent>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.formelements.Percent for all models
       * @return Iterator of com.infotec.eworkplace.swb.formelements.Percent
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.formelements.Percent> listPercents()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.formelements.Percent>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.formelements.Percent
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Percent
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Percent
       * @return A com.infotec.eworkplace.swb.formelements.Percent
       */
        public static com.infotec.eworkplace.swb.formelements.Percent getPercent(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.formelements.Percent)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.formelements.Percent
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Percent
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Percent
       * @return A com.infotec.eworkplace.swb.formelements.Percent
       */
        public static com.infotec.eworkplace.swb.formelements.Percent createPercent(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.formelements.Percent)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.formelements.Percent
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Percent
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Percent
       */
        public static void removePercent(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.formelements.Percent
       * @param id Identifier for com.infotec.eworkplace.swb.formelements.Percent
       * @param model Model of the com.infotec.eworkplace.swb.formelements.Percent
       * @return true if the com.infotec.eworkplace.swb.formelements.Percent exists, false otherwise
       */

        public static boolean hasPercent(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPercent(id, model)!=null);
        }
    }

   /**
   * Constructs a PercentBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Percent
   */
    public PercentBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the PercentCero property
* @return boolean with the PercentCero
*/
    public boolean isPercentCero()
    {
        return getSemanticObject().getBooleanProperty(intraxf_percentCero);
    }

/**
* Sets the PercentCero property
* @param value long with the PercentCero
*/
    public void setPercentCero(boolean value)
    {
        getSemanticObject().setBooleanProperty(intraxf_percentCero, value);
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
