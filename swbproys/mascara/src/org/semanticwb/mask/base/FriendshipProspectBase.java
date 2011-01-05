package org.semanticwb.mask.base;


public abstract class FriendshipProspectBase extends org.semanticwb.mask.UserRelationship 
{
    public static final org.semanticwb.platform.SemanticClass mascara_FriendshipProspect=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#FriendshipProspect");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#FriendshipProspect");

    public static class ClassMgr
    {
       /**
       * Returns a list of FriendshipProspect for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspects(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.mask.FriendshipProspect for all models
       * @return Iterator of org.semanticwb.mask.FriendshipProspect
       */

        public static java.util.Iterator<org.semanticwb.mask.FriendshipProspect> listFriendshipProspects()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.FriendshipProspect>(it, true);
        }

        public static org.semanticwb.mask.FriendshipProspect createFriendshipProspect(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.mask.FriendshipProspect.ClassMgr.createFriendshipProspect(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return A org.semanticwb.mask.FriendshipProspect
       */
        public static org.semanticwb.mask.FriendshipProspect getFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.FriendshipProspect)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return A org.semanticwb.mask.FriendshipProspect
       */
        public static org.semanticwb.mask.FriendshipProspect createFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.FriendshipProspect)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       */
        public static void removeFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.mask.FriendshipProspect
       * @param id Identifier for org.semanticwb.mask.FriendshipProspect
       * @param model Model of the org.semanticwb.mask.FriendshipProspect
       * @return true if the org.semanticwb.mask.FriendshipProspect exists, false otherwise
       */

        public static boolean hasFriendshipProspect(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFriendshipProspect(id, model)!=null);
        }
    }

   /**
   * Constructs a FriendshipProspectBase with a SemanticObject
   * @param base The SemanticObject with the properties for the FriendshipProspect
   */
    public FriendshipProspectBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
