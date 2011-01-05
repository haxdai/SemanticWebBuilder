package org.semanticwb.mask.base;


public abstract class FriendshipBase extends org.semanticwb.mask.UserRelationship 
{
    public static final org.semanticwb.platform.SemanticClass mascara_Friendship=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#Friendship");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#Friendship");

    public static class ClassMgr
    {
       /**
       * Returns a list of Friendship for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.mask.Friendship
       */

        public static java.util.Iterator<org.semanticwb.mask.Friendship> listFriendships(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.Friendship>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.mask.Friendship for all models
       * @return Iterator of org.semanticwb.mask.Friendship
       */

        public static java.util.Iterator<org.semanticwb.mask.Friendship> listFriendships()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.Friendship>(it, true);
        }

        public static org.semanticwb.mask.Friendship createFriendship(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.mask.Friendship.ClassMgr.createFriendship(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.mask.Friendship
       * @param id Identifier for org.semanticwb.mask.Friendship
       * @param model Model of the org.semanticwb.mask.Friendship
       * @return A org.semanticwb.mask.Friendship
       */
        public static org.semanticwb.mask.Friendship getFriendship(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.Friendship)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.mask.Friendship
       * @param id Identifier for org.semanticwb.mask.Friendship
       * @param model Model of the org.semanticwb.mask.Friendship
       * @return A org.semanticwb.mask.Friendship
       */
        public static org.semanticwb.mask.Friendship createFriendship(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.Friendship)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.mask.Friendship
       * @param id Identifier for org.semanticwb.mask.Friendship
       * @param model Model of the org.semanticwb.mask.Friendship
       */
        public static void removeFriendship(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.mask.Friendship
       * @param id Identifier for org.semanticwb.mask.Friendship
       * @param model Model of the org.semanticwb.mask.Friendship
       * @return true if the org.semanticwb.mask.Friendship exists, false otherwise
       */

        public static boolean hasFriendship(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFriendship(id, model)!=null);
        }
    }

   /**
   * Constructs a FriendshipBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Friendship
   */
    public FriendshipBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
