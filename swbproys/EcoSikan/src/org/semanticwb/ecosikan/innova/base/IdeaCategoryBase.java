package org.semanticwb.ecosikan.innova.base;


public abstract class IdeaCategoryBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ecoskn_Category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Category");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_category=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#category");
    public static final org.semanticwb.platform.SemanticClass ecoskn_Idea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Idea");
    public static final org.semanticwb.platform.SemanticProperty ecoskn_idea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://ecosikan.infotec.com.mx#idea");
    public static final org.semanticwb.platform.SemanticClass ecoskn_IdeaCategory=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#IdeaCategory");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#IdeaCategory");

    public static class ClassMgr
    {
       /**
       * Returns a list of IdeaCategory for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.IdeaCategory
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.IdeaCategory> listIdeaCategories(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.IdeaCategory>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.IdeaCategory for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.IdeaCategory
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.IdeaCategory> listIdeaCategories()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.IdeaCategory>(it, true);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.IdeaCategory
       * @param id Identifier for org.semanticwb.ecosikan.innova.IdeaCategory
       * @param model Model of the org.semanticwb.ecosikan.innova.IdeaCategory
       * @return A org.semanticwb.ecosikan.innova.IdeaCategory
       */
        public static org.semanticwb.ecosikan.innova.IdeaCategory getIdeaCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.IdeaCategory)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.IdeaCategory
       * @param id Identifier for org.semanticwb.ecosikan.innova.IdeaCategory
       * @param model Model of the org.semanticwb.ecosikan.innova.IdeaCategory
       * @return A org.semanticwb.ecosikan.innova.IdeaCategory
       */
        public static org.semanticwb.ecosikan.innova.IdeaCategory createIdeaCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.IdeaCategory)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.IdeaCategory
       * @param id Identifier for org.semanticwb.ecosikan.innova.IdeaCategory
       * @param model Model of the org.semanticwb.ecosikan.innova.IdeaCategory
       */
        public static void removeIdeaCategory(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.IdeaCategory
       * @param id Identifier for org.semanticwb.ecosikan.innova.IdeaCategory
       * @param model Model of the org.semanticwb.ecosikan.innova.IdeaCategory
       * @return true if the org.semanticwb.ecosikan.innova.IdeaCategory exists, false otherwise
       */

        public static boolean hasIdeaCategory(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIdeaCategory(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.IdeaCategory with a determined Category
       * @param value Category of the type org.semanticwb.ecosikan.innova.Category
       * @param model Model of the org.semanticwb.ecosikan.innova.IdeaCategory
       * @return Iterator with all the org.semanticwb.ecosikan.innova.IdeaCategory
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.IdeaCategory> listIdeaCategoryByCategory(org.semanticwb.ecosikan.innova.Category value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.IdeaCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_category, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.IdeaCategory with a determined Category
       * @param value Category of the type org.semanticwb.ecosikan.innova.Category
       * @return Iterator with all the org.semanticwb.ecosikan.innova.IdeaCategory
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.IdeaCategory> listIdeaCategoryByCategory(org.semanticwb.ecosikan.innova.Category value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.IdeaCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_category,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.IdeaCategory with a determined Idea
       * @param value Idea of the type org.semanticwb.ecosikan.innova.Idea
       * @param model Model of the org.semanticwb.ecosikan.innova.IdeaCategory
       * @return Iterator with all the org.semanticwb.ecosikan.innova.IdeaCategory
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.IdeaCategory> listIdeaCategoryByIdea(org.semanticwb.ecosikan.innova.Idea value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.IdeaCategory> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ecoskn_idea, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.ecosikan.innova.IdeaCategory with a determined Idea
       * @param value Idea of the type org.semanticwb.ecosikan.innova.Idea
       * @return Iterator with all the org.semanticwb.ecosikan.innova.IdeaCategory
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.IdeaCategory> listIdeaCategoryByIdea(org.semanticwb.ecosikan.innova.Idea value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.IdeaCategory> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ecoskn_idea,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a IdeaCategoryBase with a SemanticObject
   * @param base The SemanticObject with the properties for the IdeaCategory
   */
    public IdeaCategoryBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Category
   * @param value Category to set
   */

    public void setCategory(org.semanticwb.ecosikan.innova.Category value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ecoskn_category, value.getSemanticObject());
        }else
        {
            removeCategory();
        }
    }
   /**
   * Remove the value for Category property
   */

    public void removeCategory()
    {
        getSemanticObject().removeProperty(ecoskn_category);
    }

   /**
   * Gets the Category
   * @return a org.semanticwb.ecosikan.innova.Category
   */
    public org.semanticwb.ecosikan.innova.Category getCategory()
    {
         org.semanticwb.ecosikan.innova.Category ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_category);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Category)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Idea
   * @param value Idea to set
   */

    public void setIdea(org.semanticwb.ecosikan.innova.Idea value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ecoskn_idea, value.getSemanticObject());
        }else
        {
            removeIdea();
        }
    }
   /**
   * Remove the value for Idea property
   */

    public void removeIdea()
    {
        getSemanticObject().removeProperty(ecoskn_idea);
    }

   /**
   * Gets the Idea
   * @return a org.semanticwb.ecosikan.innova.Idea
   */
    public org.semanticwb.ecosikan.innova.Idea getIdea()
    {
         org.semanticwb.ecosikan.innova.Idea ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ecoskn_idea);
         if(obj!=null)
         {
             ret=(org.semanticwb.ecosikan.innova.Idea)obj.createGenericInstance();
         }
         return ret;
    }
}
