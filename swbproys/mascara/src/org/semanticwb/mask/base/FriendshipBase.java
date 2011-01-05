package org.semanticwb.mask.base;


public abstract class FriendshipBase extends org.semanticwb.mask.UserRelationship 
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty mascara_hasFriend=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/mascara#hasFriend");
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
       /**
       * Gets all org.semanticwb.mask.Friendship with a determined Friend
       * @param value Friend of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.mask.Friendship
       * @return Iterator with all the org.semanticwb.mask.Friendship
       */

        public static java.util.Iterator<org.semanticwb.mask.Friendship> listFriendshipByFriend(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.Friendship> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(mascara_hasFriend, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.mask.Friendship with a determined Friend
       * @param value Friend of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.mask.Friendship
       */

        public static java.util.Iterator<org.semanticwb.mask.Friendship> listFriendshipByFriend(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.mask.Friendship> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(mascara_hasFriend,value.getSemanticObject(),sclass));
            return it;
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
   /**
   * Gets all the org.semanticwb.model.User
   * @return A GenericIterator with all the org.semanticwb.model.User
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.User> listFriends()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.User>(getSemanticObject().listObjectProperties(mascara_hasFriend));
    }

   /**
   * Gets true if has a Friend
   * @param value org.semanticwb.model.User to verify
   * @return true if the org.semanticwb.model.User exists, false otherwise
   */
    public boolean hasFriend(org.semanticwb.model.User value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(mascara_hasFriend,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Friend
   * @param value org.semanticwb.model.User to add
   */

    public void addFriend(org.semanticwb.model.User value)
    {
        getSemanticObject().addObjectProperty(mascara_hasFriend, value.getSemanticObject());
    }
   /**
   * Removes all the Friend
   */

    public void removeAllFriend()
    {
        getSemanticObject().removeProperty(mascara_hasFriend);
    }
   /**
   * Removes a Friend
   * @param value org.semanticwb.model.User to remove
   */

    public void removeFriend(org.semanticwb.model.User value)
    {
        getSemanticObject().removeObjectProperty(mascara_hasFriend,value.getSemanticObject());
    }

   /**
   * Gets the Friend
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getFriend()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(mascara_hasFriend);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
