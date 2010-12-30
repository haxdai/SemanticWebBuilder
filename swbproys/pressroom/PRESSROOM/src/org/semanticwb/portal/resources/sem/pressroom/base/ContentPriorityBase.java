package org.semanticwb.portal.resources.sem.pressroom.base;


public abstract class ContentPriorityBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass swbpress_Content=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#Content");
    public static final org.semanticwb.platform.SemanticProperty swbpress_contentPriority=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/resources/pressroom#contentPriority");
    public static final org.semanticwb.platform.SemanticClass swbpress_ContentPriority=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#ContentPriority");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/resources/pressroom#ContentPriority");

    public static class ClassMgr
    {
       /**
       * Returns a list of ContentPriority for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority> listContentPriorities(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.portal.resources.sem.pressroom.ContentPriority for all models
       * @return Iterator of org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority> listContentPriorities()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority>(it, true);
        }

        public static org.semanticwb.portal.resources.sem.pressroom.ContentPriority createContentPriority(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.portal.resources.sem.pressroom.ContentPriority.ClassMgr.createContentPriority(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @return A org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       */
        public static org.semanticwb.portal.resources.sem.pressroom.ContentPriority getContentPriority(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.ContentPriority)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @return A org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       */
        public static org.semanticwb.portal.resources.sem.pressroom.ContentPriority createContentPriority(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.portal.resources.sem.pressroom.ContentPriority)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       */
        public static void removeContentPriority(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param id Identifier for org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @return true if the org.semanticwb.portal.resources.sem.pressroom.ContentPriority exists, false otherwise
       */

        public static boolean hasContentPriority(String id, org.semanticwb.model.SWBModel model)
        {
            return (getContentPriority(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.ContentPriority with a determined ContentPriority
       * @param value ContentPriority of the type org.semanticwb.portal.resources.sem.pressroom.Content
       * @param model Model of the org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority> listContentPriorityByContentPriority(org.semanticwb.portal.resources.sem.pressroom.Content value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swbpress_contentPriority, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.portal.resources.sem.pressroom.ContentPriority with a determined ContentPriority
       * @param value ContentPriority of the type org.semanticwb.portal.resources.sem.pressroom.Content
       * @return Iterator with all the org.semanticwb.portal.resources.sem.pressroom.ContentPriority
       */

        public static java.util.Iterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority> listContentPriorityByContentPriority(org.semanticwb.portal.resources.sem.pressroom.Content value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.portal.resources.sem.pressroom.ContentPriority> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swbpress_contentPriority,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ContentPriorityBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ContentPriority
   */
    public ContentPriorityBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ContentPriority
   * @param value ContentPriority to set
   */

    public void setContentPriority(org.semanticwb.portal.resources.sem.pressroom.Content value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swbpress_contentPriority, value.getSemanticObject());
        }else
        {
            removeContentPriority();
        }
    }
   /**
   * Remove the value for ContentPriority property
   */

    public void removeContentPriority()
    {
        getSemanticObject().removeProperty(swbpress_contentPriority);
    }

   /**
   * Gets the ContentPriority
   * @return a org.semanticwb.portal.resources.sem.pressroom.Content
   */
    public org.semanticwb.portal.resources.sem.pressroom.Content getContentPriority()
    {
         org.semanticwb.portal.resources.sem.pressroom.Content ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swbpress_contentPriority);
         if(obj!=null)
         {
             ret=(org.semanticwb.portal.resources.sem.pressroom.Content)obj.createGenericInstance();
         }
         return ret;
    }
}
