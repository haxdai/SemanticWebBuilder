package org.semanticwb.bsc.element.base;


public abstract class DeliverableBase extends org.semanticwb.bsc.element.BSCElement implements org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass bsc_Deliverable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Deliverable");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/bsc#Deliverable");

    public static class ClassMgr
    {
       /**
       * Returns a list of Deliverable for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverables(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.bsc.element.Deliverable for all models
       * @return Iterator of org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverables()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable>(it, true);
        }
       /**
       * Gets a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return A org.semanticwb.bsc.element.Deliverable
       */
        public static org.semanticwb.bsc.element.Deliverable getDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Deliverable)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return A org.semanticwb.bsc.element.Deliverable
       */
        public static org.semanticwb.bsc.element.Deliverable createDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.bsc.element.Deliverable)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       */
        public static void removeDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.bsc.element.Deliverable
       * @param id Identifier for org.semanticwb.bsc.element.Deliverable
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return true if the org.semanticwb.bsc.element.Deliverable exists, false otherwise
       */

        public static boolean hasDeliverable(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDeliverable(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.bsc.element.Deliverable
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.bsc.element.Deliverable with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.bsc.element.Deliverable
       */

        public static java.util.Iterator<org.semanticwb.bsc.element.Deliverable> listDeliverableByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.bsc.element.Deliverable> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DeliverableBase.ClassMgr getDeliverableClassMgr()
    {
        return new DeliverableBase.ClassMgr();
    }

   /**
   * Constructs a DeliverableBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Deliverable
   */
    public DeliverableBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
