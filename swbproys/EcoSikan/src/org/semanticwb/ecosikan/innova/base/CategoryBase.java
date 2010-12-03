package org.semanticwb.ecosikan.innova.base;


public abstract class CategoryBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass ecoskn_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Category");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Category");

    public static class ClassMgr
    {
       /**
       * Returns a list of Category for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Category
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Category> listCategories(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Category>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Category for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Category
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Category> listCategories()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Category>(it, true);
        }

        public static org.semanticwb.ecosikan.innova.Category createCategory(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.ecosikan.innova.Category.ClassMgr.createCategory(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Category
       * @param id Identifier for org.semanticwb.ecosikan.innova.Category
       * @param model Model of the org.semanticwb.ecosikan.innova.Category
       * @return A org.semanticwb.ecosikan.innova.Category
       */
        public static org.semanticwb.ecosikan.innova.Category getCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Category)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Category
       * @param id Identifier for org.semanticwb.ecosikan.innova.Category
       * @param model Model of the org.semanticwb.ecosikan.innova.Category
       * @return A org.semanticwb.ecosikan.innova.Category
       */
        public static org.semanticwb.ecosikan.innova.Category createCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Category)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Category
       * @param id Identifier for org.semanticwb.ecosikan.innova.Category
       * @param model Model of the org.semanticwb.ecosikan.innova.Category
       */
        public static void removeCategory(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Category
       * @param id Identifier for org.semanticwb.ecosikan.innova.Category
       * @param model Model of the org.semanticwb.ecosikan.innova.Category
       * @return true if the org.semanticwb.ecosikan.innova.Category exists, false otherwise
       */

        public static boolean hasCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCategory(id, model)!=null);
        }
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
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
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

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
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
