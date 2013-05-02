package com.infotec.lodp.swb.base;


public abstract class CategoryBase extends org.semanticwb.model.base.GenericObjectBase 
{
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticProperty lodp_catName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#catName");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Category");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Category");

    public static class ClassMgr
    {
       /**
       * Returns a list of Category for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Category
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Category> listCategories(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Category>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Category for all models
       * @return Iterator of com.infotec.lodp.swb.Category
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Category> listCategories()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Category>(it, true);
        }

        public static com.infotec.lodp.swb.Category createCategory(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Category.ClassMgr.createCategory(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Category
       * @param id Identifier for com.infotec.lodp.swb.Category
       * @param model Model of the com.infotec.lodp.swb.Category
       * @return A com.infotec.lodp.swb.Category
       */
        public static com.infotec.lodp.swb.Category getCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Category)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Category
       * @param id Identifier for com.infotec.lodp.swb.Category
       * @param model Model of the com.infotec.lodp.swb.Category
       * @return A com.infotec.lodp.swb.Category
       */
        public static com.infotec.lodp.swb.Category createCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Category)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Category
       * @param id Identifier for com.infotec.lodp.swb.Category
       * @param model Model of the com.infotec.lodp.swb.Category
       */
        public static void removeCategory(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Category
       * @param id Identifier for com.infotec.lodp.swb.Category
       * @param model Model of the com.infotec.lodp.swb.Category
       * @return true if the com.infotec.lodp.swb.Category exists, false otherwise
       */

        public static boolean hasCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCategory(id, model)!=null);
        }
    }

    public static CategoryBase.ClassMgr getCategoryClassMgr()
    {
        return new CategoryBase.ClassMgr();
    }

   /**
   * Constructs a CategoryBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Category
   */
    public CategoryBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in Category object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in Category object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

/**
* Gets the CatName property
* @return String with the CatName
*/
    public String getCatName()
    {
        return getSemanticObject().getProperty(lodp_catName);
    }

/**
* Sets the CatName property
* @param value long with the CatName
*/
    public void setCatName(String value)
    {
        getSemanticObject().setProperty(lodp_catName, value);
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
