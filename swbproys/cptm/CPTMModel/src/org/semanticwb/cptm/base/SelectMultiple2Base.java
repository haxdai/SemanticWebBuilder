package org.semanticwb.cptm.base;


   /**
   * Select Multiple2 
   */
public abstract class SelectMultiple2Base extends org.semanticwb.model.base.FormElementBase 
{
    public static final org.semanticwb.platform.SemanticProperty cptm_sm2_globalScope=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#sm2_globalScope");
    public static final org.semanticwb.platform.SemanticProperty cptm_sm2_nullSuport=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#sm2_nullSuport");
   /**
   * Select Multiple2
   */
    public static final org.semanticwb.platform.SemanticClass cptm_SelectMultiple2=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#SelectMultiple2");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#SelectMultiple2");

    public static class ClassMgr
    {
       /**
       * Returns a list of SelectMultiple2 for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.SelectMultiple2
       */

        public static java.util.Iterator<org.semanticwb.cptm.SelectMultiple2> listSelectMultiple2s(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.SelectMultiple2>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.SelectMultiple2 for all models
       * @return Iterator of org.semanticwb.cptm.SelectMultiple2
       */

        public static java.util.Iterator<org.semanticwb.cptm.SelectMultiple2> listSelectMultiple2s()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.SelectMultiple2>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.SelectMultiple2
       * @param id Identifier for org.semanticwb.cptm.SelectMultiple2
       * @param model Model of the org.semanticwb.cptm.SelectMultiple2
       * @return A org.semanticwb.cptm.SelectMultiple2
       */
        public static org.semanticwb.cptm.SelectMultiple2 getSelectMultiple2(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.SelectMultiple2)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.SelectMultiple2
       * @param id Identifier for org.semanticwb.cptm.SelectMultiple2
       * @param model Model of the org.semanticwb.cptm.SelectMultiple2
       * @return A org.semanticwb.cptm.SelectMultiple2
       */
        public static org.semanticwb.cptm.SelectMultiple2 createSelectMultiple2(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.SelectMultiple2)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.SelectMultiple2
       * @param id Identifier for org.semanticwb.cptm.SelectMultiple2
       * @param model Model of the org.semanticwb.cptm.SelectMultiple2
       */
        public static void removeSelectMultiple2(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.SelectMultiple2
       * @param id Identifier for org.semanticwb.cptm.SelectMultiple2
       * @param model Model of the org.semanticwb.cptm.SelectMultiple2
       * @return true if the org.semanticwb.cptm.SelectMultiple2 exists, false otherwise
       */

        public static boolean hasSelectMultiple2(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSelectMultiple2(id, model)!=null);
        }
    }

   /**
   * Constructs a SelectMultiple2Base with a SemanticObject
   * @param base The SemanticObject with the properties for the SelectMultiple2
   */
    public SelectMultiple2Base(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the GlobalScope property
* @return boolean with the GlobalScope
*/
    public boolean isGlobalScope()
    {
        return getSemanticObject().getBooleanProperty(cptm_sm2_globalScope);
    }

/**
* Sets the GlobalScope property
* @param value long with the GlobalScope
*/
    public void setGlobalScope(boolean value)
    {
        getSemanticObject().setBooleanProperty(cptm_sm2_globalScope, value);
    }

/**
* Gets the NullSuport property
* @return boolean with the NullSuport
*/
    public boolean isNullSuport()
    {
        return getSemanticObject().getBooleanProperty(cptm_sm2_nullSuport);
    }

/**
* Sets the NullSuport property
* @param value long with the NullSuport
*/
    public void setNullSuport(boolean value)
    {
        getSemanticObject().setBooleanProperty(cptm_sm2_nullSuport, value);
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
