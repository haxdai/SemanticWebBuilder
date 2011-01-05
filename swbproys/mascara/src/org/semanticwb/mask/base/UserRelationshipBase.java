package org.semanticwb.mask.base;


public abstract class UserRelationshipBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass mascara_UserRelationship=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#UserRelationship");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/mascara#UserRelationship");

    public static class ClassMgr
    {
       /**
       * Returns a list of UserRelationship for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.mask.UserRelationship
       */

        public static java.util.Iterator<org.semanticwb.mask.UserRelationship> listUserRelationships(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.UserRelationship>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.mask.UserRelationship for all models
       * @return Iterator of org.semanticwb.mask.UserRelationship
       */

        public static java.util.Iterator<org.semanticwb.mask.UserRelationship> listUserRelationships()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.mask.UserRelationship>(it, true);
        }
       /**
       * Gets a org.semanticwb.mask.UserRelationship
       * @param id Identifier for org.semanticwb.mask.UserRelationship
       * @param model Model of the org.semanticwb.mask.UserRelationship
       * @return A org.semanticwb.mask.UserRelationship
       */
        public static org.semanticwb.mask.UserRelationship getUserRelationship(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.UserRelationship)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.mask.UserRelationship
       * @param id Identifier for org.semanticwb.mask.UserRelationship
       * @param model Model of the org.semanticwb.mask.UserRelationship
       * @return A org.semanticwb.mask.UserRelationship
       */
        public static org.semanticwb.mask.UserRelationship createUserRelationship(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.mask.UserRelationship)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.mask.UserRelationship
       * @param id Identifier for org.semanticwb.mask.UserRelationship
       * @param model Model of the org.semanticwb.mask.UserRelationship
       */
        public static void removeUserRelationship(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.mask.UserRelationship
       * @param id Identifier for org.semanticwb.mask.UserRelationship
       * @param model Model of the org.semanticwb.mask.UserRelationship
       * @return true if the org.semanticwb.mask.UserRelationship exists, false otherwise
       */

        public static boolean hasUserRelationship(String id, org.semanticwb.model.SWBModel model)
        {
            return (getUserRelationship(id, model)!=null);
        }
    }

   /**
   * Constructs a UserRelationshipBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UserRelationship
   */
    public UserRelationshipBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
