package org.semanticwb.process.model.base;


public abstract class CollectionArtifactBase extends org.semanticwb.process.model.DataObject implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass swp_CollectionArtifact=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#CollectionArtifact");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#CollectionArtifact");

    public static class ClassMgr
    {
       /**
       * Returns a list of CollectionArtifact for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifacts(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.CollectionArtifact for all models
       * @return Iterator of org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifacts()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact>(it, true);
        }

        public static org.semanticwb.process.model.CollectionArtifact createCollectionArtifact(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.model.CollectionArtifact.ClassMgr.createCollectionArtifact(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.process.model.CollectionArtifact
       * @param id Identifier for org.semanticwb.process.model.CollectionArtifact
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return A org.semanticwb.process.model.CollectionArtifact
       */
        public static org.semanticwb.process.model.CollectionArtifact getCollectionArtifact(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.CollectionArtifact)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.CollectionArtifact
       * @param id Identifier for org.semanticwb.process.model.CollectionArtifact
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return A org.semanticwb.process.model.CollectionArtifact
       */
        public static org.semanticwb.process.model.CollectionArtifact createCollectionArtifact(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.CollectionArtifact)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.CollectionArtifact
       * @param id Identifier for org.semanticwb.process.model.CollectionArtifact
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       */
        public static void removeCollectionArtifact(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.CollectionArtifact
       * @param id Identifier for org.semanticwb.process.model.CollectionArtifact
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return true if the org.semanticwb.process.model.CollectionArtifact exists, false otherwise
       */

        public static boolean hasCollectionArtifact(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCollectionArtifact(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByContainer(org.semanticwb.process.model.Containerable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_container, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByContainer(org.semanticwb.process.model.Containerable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_container,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByChild(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByChild(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.CollectionArtifact
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByParent(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_parent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.CollectionArtifact with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.CollectionArtifact
       */

        public static java.util.Iterator<org.semanticwb.process.model.CollectionArtifact> listCollectionArtifactByParent(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.CollectionArtifact> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_parent,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CollectionArtifactBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CollectionArtifact
   */
    public CollectionArtifactBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
