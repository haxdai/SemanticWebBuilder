package org.swb.social.model.base;


   /**
   * Usuario que ha escrito un post en una red social 
   */
public abstract class SocialUserBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
   /**
   * Objeto que se encarga de almacenar todos los datos de una red social
   */
    public static final org.semanticwb.platform.SemanticClass smcc_SocialNetwork=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#SocialNetwork");
    public static final org.semanticwb.platform.SemanticProperty smcc_userSocialNetwork=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#userSocialNetwork");
    public static final org.semanticwb.platform.SemanticProperty smcc_userId=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#userId");
   /**
   * Clase Post, esta es la principal, es donde se guarda cada post que trae el listener
   */
    public static final org.semanticwb.platform.SemanticClass smcc_Post=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#Post");
    public static final org.semanticwb.platform.SemanticProperty smcc_userPostInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#userPostInv");
    public static final org.semanticwb.platform.SemanticProperty smcc_postToUserInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postToUserInv");
   /**
   * Usuario que ha escrito un post en una red social
   */
    public static final org.semanticwb.platform.SemanticClass smcc_SocialUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#SocialUser");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#SocialUser");

    public static class ClassMgr
    {
       /**
       * Returns a list of SocialUser for a model
       * @param model Model to find
       * @return Iterator of org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUsers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser>(it, true);
        }
       /**
       * Returns a list of org.swb.social.model.SocialUser for all models
       * @return Iterator of org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUsers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser>(it, true);
        }
       /**
       * Gets a org.swb.social.model.SocialUser
       * @param id Identifier for org.swb.social.model.SocialUser
       * @param model Model of the org.swb.social.model.SocialUser
       * @return A org.swb.social.model.SocialUser
       */
        public static org.swb.social.model.SocialUser getSocialUser(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.swb.social.model.SocialUser)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.swb.social.model.SocialUser
       * @param id Identifier for org.swb.social.model.SocialUser
       * @param model Model of the org.swb.social.model.SocialUser
       * @return A org.swb.social.model.SocialUser
       */
        public static org.swb.social.model.SocialUser createSocialUser(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.swb.social.model.SocialUser)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.swb.social.model.SocialUser
       * @param id Identifier for org.swb.social.model.SocialUser
       * @param model Model of the org.swb.social.model.SocialUser
       */
        public static void removeSocialUser(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.swb.social.model.SocialUser
       * @param id Identifier for org.swb.social.model.SocialUser
       * @param model Model of the org.swb.social.model.SocialUser
       * @return true if the org.swb.social.model.SocialUser exists, false otherwise
       */

        public static boolean hasSocialUser(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSocialUser(id, model)!=null);
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined UserSocialNetwork
       * @param value UserSocialNetwork of the type org.swb.social.model.SocialNetwork
       * @param model Model of the org.swb.social.model.SocialUser
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByUserSocialNetwork(org.swb.social.model.SocialNetwork value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(smcc_userSocialNetwork, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined UserSocialNetwork
       * @param value UserSocialNetwork of the type org.swb.social.model.SocialNetwork
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByUserSocialNetwork(org.swb.social.model.SocialNetwork value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(smcc_userSocialNetwork,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.swb.social.model.SocialUser
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.swb.social.model.SocialUser
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined UserPostInv
       * @param value UserPostInv of the type org.swb.social.model.Post
       * @param model Model of the org.swb.social.model.SocialUser
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByUserPostInv(org.swb.social.model.Post value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(smcc_userPostInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined UserPostInv
       * @param value UserPostInv of the type org.swb.social.model.Post
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByUserPostInv(org.swb.social.model.Post value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(smcc_userPostInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined PostToUserInv
       * @param value PostToUserInv of the type org.swb.social.model.Post
       * @param model Model of the org.swb.social.model.SocialUser
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByPostToUserInv(org.swb.social.model.Post value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(smcc_postToUserInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialUser with a determined PostToUserInv
       * @param value PostToUserInv of the type org.swb.social.model.Post
       * @return Iterator with all the org.swb.social.model.SocialUser
       */

        public static java.util.Iterator<org.swb.social.model.SocialUser> listSocialUserByPostToUserInv(org.swb.social.model.Post value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialUser> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(smcc_postToUserInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SocialUserBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SocialUser
   */
    public SocialUserBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property UserSocialNetwork
   * @param value UserSocialNetwork to set
   */

    public void setUserSocialNetwork(org.swb.social.model.SocialNetwork value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(smcc_userSocialNetwork, value.getSemanticObject());
        }else
        {
            removeUserSocialNetwork();
        }
    }
   /**
   * Remove the value for UserSocialNetwork property
   */

    public void removeUserSocialNetwork()
    {
        getSemanticObject().removeProperty(smcc_userSocialNetwork);
    }

   /**
   * Gets the UserSocialNetwork
   * @return a org.swb.social.model.SocialNetwork
   */
    public org.swb.social.model.SocialNetwork getUserSocialNetwork()
    {
         org.swb.social.model.SocialNetwork ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(smcc_userSocialNetwork);
         if(obj!=null)
         {
             ret=(org.swb.social.model.SocialNetwork)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }

/**
* Gets the UserId property
* @return String with the UserId
*/
    public String getUserId()
    {
        return getSemanticObject().getProperty(smcc_userId);
    }

/**
* Sets the UserId property
* @param value long with the UserId
*/
    public void setUserId(String value)
    {
        getSemanticObject().setProperty(smcc_userId, value);
    }
   /**
   * Sets the value for the property UserPostInv
   * @param value UserPostInv to set
   */

    public void setUserPostInv(org.swb.social.model.Post value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(smcc_userPostInv, value.getSemanticObject());
        }else
        {
            removeUserPostInv();
        }
    }
   /**
   * Remove the value for UserPostInv property
   */

    public void removeUserPostInv()
    {
        getSemanticObject().removeProperty(smcc_userPostInv);
    }

   /**
   * Gets the UserPostInv
   * @return a org.swb.social.model.Post
   */
    public org.swb.social.model.Post getUserPostInv()
    {
         org.swb.social.model.Post ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(smcc_userPostInv);
         if(obj!=null)
         {
             ret=(org.swb.social.model.Post)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property PostToUserInv
   * @param value PostToUserInv to set
   */

    public void setPostToUserInv(org.swb.social.model.Post value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(smcc_postToUserInv, value.getSemanticObject());
        }else
        {
            removePostToUserInv();
        }
    }
   /**
   * Remove the value for PostToUserInv property
   */

    public void removePostToUserInv()
    {
        getSemanticObject().removeProperty(smcc_postToUserInv);
    }

   /**
   * Gets the PostToUserInv
   * @return a org.swb.social.model.Post
   */
    public org.swb.social.model.Post getPostToUserInv()
    {
         org.swb.social.model.Post ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(smcc_postToUserInv);
         if(obj!=null)
         {
             ret=(org.swb.social.model.Post)obj.createGenericInstance();
         }
         return ret;
    }
}
