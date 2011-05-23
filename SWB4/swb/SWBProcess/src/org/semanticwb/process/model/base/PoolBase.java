package org.semanticwb.process.model.base;


public abstract class PoolBase extends org.semanticwb.process.model.GraphicalElement implements org.semanticwb.process.model.ResourceAssignmentable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass swp_Pool=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#Pool");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/process#Pool");

    public static class ClassMgr
    {
       /**
       * Returns a list of Pool for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPools(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.process.model.Pool for all models
       * @return Iterator of org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPools()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool>(it, true);
        }

        public static org.semanticwb.process.model.Pool createPool(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.process.model.Pool.ClassMgr.createPool(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return A org.semanticwb.process.model.Pool
       */
        public static org.semanticwb.process.model.Pool getPool(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.Pool)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return A org.semanticwb.process.model.Pool
       */
        public static org.semanticwb.process.model.Pool createPool(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.process.model.Pool)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       */
        public static void removePool(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.process.model.Pool
       * @param id Identifier for org.semanticwb.process.model.Pool
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return true if the org.semanticwb.process.model.Pool exists, false otherwise
       */

        public static boolean hasPool(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPool(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByContainer(org.semanticwb.process.model.Containerable value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_container, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Container
       * @param value Container of the type org.semanticwb.process.model.Containerable
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByContainer(org.semanticwb.process.model.Containerable value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_container,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined OutputConnectionObject
       * @param value OutputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByOutputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasOutputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined InputConnectionObject
       * @param value InputConnectionObject of the type org.semanticwb.process.model.ConnectionObject
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByInputConnectionObject(org.semanticwb.process.model.ConnectionObject value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasInputConnectionObjectInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined ResourceAssignment
       * @param value ResourceAssignment of the type org.semanticwb.process.model.ResourceAssignment
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByResourceAssignment(org.semanticwb.process.model.ResourceAssignment value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_resourceAssignment, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined ResourceAssignment
       * @param value ResourceAssignment of the type org.semanticwb.process.model.ResourceAssignment
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByResourceAssignment(org.semanticwb.process.model.ResourceAssignment value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_resourceAssignment,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByChild(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Child
       * @param value Child of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByChild(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_hasChildInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @param model Model of the org.semanticwb.process.model.Pool
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByParent(org.semanticwb.process.model.GraphicalElement value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swp_parent, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.process.model.Pool with a determined Parent
       * @param value Parent of the type org.semanticwb.process.model.GraphicalElement
       * @return Iterator with all the org.semanticwb.process.model.Pool
       */

        public static java.util.Iterator<org.semanticwb.process.model.Pool> listPoolByParent(org.semanticwb.process.model.GraphicalElement value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.process.model.Pool> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swp_parent,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PoolBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Pool
   */
    public PoolBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ResourceAssignment
   * @param value ResourceAssignment to set
   */

    public void setResourceAssignment(org.semanticwb.process.model.ResourceAssignment value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swp_resourceAssignment, value.getSemanticObject());
        }else
        {
            removeResourceAssignment();
        }
    }
   /**
   * Remove the value for ResourceAssignment property
   */

    public void removeResourceAssignment()
    {
        getSemanticObject().removeProperty(swp_resourceAssignment);
    }

   /**
   * Gets the ResourceAssignment
   * @return a org.semanticwb.process.model.ResourceAssignment
   */
    public org.semanticwb.process.model.ResourceAssignment getResourceAssignment()
    {
         org.semanticwb.process.model.ResourceAssignment ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swp_resourceAssignment);
         if(obj!=null)
         {
             ret=(org.semanticwb.process.model.ResourceAssignment)obj.createGenericInstance();
         }
         return ret;
    }

   /**
   * Gets the ProcessSite
   * @return a instance of org.semanticwb.process.model.ProcessSite
   */
    public org.semanticwb.process.model.ProcessSite getProcessSite()
    {
        return (org.semanticwb.process.model.ProcessSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
