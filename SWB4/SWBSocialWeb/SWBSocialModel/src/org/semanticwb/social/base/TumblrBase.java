package org.semanticwb.social.base;


   /**
   * Clase que almacenará las diferentes cuentas de una organización para la red social Tumblr. 
   */
public abstract class TumblrBase extends org.semanticwb.social.SocialNetwork implements org.semanticwb.social.Relationable,org.semanticwb.social.Secreteable,org.semanticwb.social.Videoable,org.semanticwb.model.FilterableClass,org.semanticwb.model.FilterableNode,org.semanticwb.model.Activeable,org.semanticwb.social.Messageable,org.semanticwb.social.SocialNetPostable,org.semanticwb.social.Photoable,org.semanticwb.model.Filterable,org.semanticwb.social.Listenerable,org.semanticwb.model.Descriptiveable,org.semanticwb.social.Oauthable,org.semanticwb.model.Traceable,org.semanticwb.model.Trashable
{
   /**
   * Clase que almacenará las diferentes cuentas de una organización para la red social Tumblr.
   */
    public static final org.semanticwb.platform.SemanticClass social_Tumblr=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Tumblr");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Tumblr");

    public static class ClassMgr
    {
       /**
       * Returns a list of Tumblr for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.Tumblr for all models
       * @return Iterator of org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr>(it, true);
        }

        public static org.semanticwb.social.Tumblr createTumblr(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.social.Tumblr.ClassMgr.createTumblr(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.social.Tumblr
       * @param id Identifier for org.semanticwb.social.Tumblr
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return A org.semanticwb.social.Tumblr
       */
        public static org.semanticwb.social.Tumblr getTumblr(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Tumblr)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.Tumblr
       * @param id Identifier for org.semanticwb.social.Tumblr
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return A org.semanticwb.social.Tumblr
       */
        public static org.semanticwb.social.Tumblr createTumblr(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Tumblr)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.Tumblr
       * @param id Identifier for org.semanticwb.social.Tumblr
       * @param model Model of the org.semanticwb.social.Tumblr
       */
        public static void removeTumblr(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.Tumblr
       * @param id Identifier for org.semanticwb.social.Tumblr
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return true if the org.semanticwb.social.Tumblr exists, false otherwise
       */

        public static boolean hasTumblr(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTumblr(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostListenerContainer
       * @param value PostListenerContainer of the type org.semanticwb.social.PostInContainer
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostListenerContainer(org.semanticwb.social.PostInContainer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostListenerContainer, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostListenerContainer
       * @param value PostListenerContainer of the type org.semanticwb.social.PostInContainer
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostListenerContainer(org.semanticwb.social.PostInContainer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostListenerContainer,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostContainer
       * @param value PostContainer of the type org.semanticwb.social.PostOutContainer
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostContainer(org.semanticwb.social.PostOutContainer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostContainer, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostContainer
       * @param value PostContainer of the type org.semanticwb.social.PostOutContainer
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostContainer(org.semanticwb.social.PostOutContainer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostContainer,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostInSocialNetworkInv
       * @param value PostInSocialNetworkInv of the type org.semanticwb.social.PostIn
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostInSocialNetworkInv(org.semanticwb.social.PostIn value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostInSocialNetworkInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostInSocialNetworkInv
       * @param value PostInSocialNetworkInv of the type org.semanticwb.social.PostIn
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostInSocialNetworkInv(org.semanticwb.social.PostIn value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostInSocialNetworkInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined SocialNetStreamSearchInv
       * @param value SocialNetStreamSearchInv of the type org.semanticwb.social.SocialNetStreamSearch
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrBySocialNetStreamSearchInv(org.semanticwb.social.SocialNetStreamSearch value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetStreamSearchInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined SocialNetStreamSearchInv
       * @param value SocialNetStreamSearchInv of the type org.semanticwb.social.SocialNetStreamSearch
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrBySocialNetStreamSearchInv(org.semanticwb.social.SocialNetStreamSearch value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetStreamSearchInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined SocialPostInv
       * @param value SocialPostInv of the type org.semanticwb.social.PostOutNet
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrBySocialPostInv(org.semanticwb.social.PostOutNet value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialPostInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined SocialPostInv
       * @param value SocialPostInv of the type org.semanticwb.social.PostOutNet
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrBySocialPostInv(org.semanticwb.social.PostOutNet value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialPostInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined Podur_SocialNetworkInv
       * @param value Podur_SocialNetworkInv of the type org.semanticwb.social.PostOutDirectUserRelation
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPodur_SocialNetworkInv(org.semanticwb.social.PostOutDirectUserRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_haspodur_SocialNetworkInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined Podur_SocialNetworkInv
       * @param value Podur_SocialNetworkInv of the type org.semanticwb.social.PostOutDirectUserRelation
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPodur_SocialNetworkInv(org.semanticwb.social.PostOutDirectUserRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_haspodur_SocialNetworkInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined SocialNetworkPostOutInv
       * @param value SocialNetworkPostOutInv of the type org.semanticwb.social.PostOut
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrBySocialNetworkPostOutInv(org.semanticwb.social.PostOut value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetworkPostOutInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined SocialNetworkPostOutInv
       * @param value SocialNetworkPostOutInv of the type org.semanticwb.social.PostOut
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrBySocialNetworkPostOutInv(org.semanticwb.social.PostOut value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetworkPostOutInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostOutLinksInv
       * @param value PostOutLinksInv of the type org.semanticwb.social.PostOutLinksHits
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostOutLinksInv(org.semanticwb.social.PostOutLinksHits value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostOutLinksInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined PostOutLinksInv
       * @param value PostOutLinksInv of the type org.semanticwb.social.PostOutLinksHits
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPostOutLinksInv(org.semanticwb.social.PostOutLinksHits value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostOutLinksInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined Popr_socialNetworkInv
       * @param value Popr_socialNetworkInv of the type org.semanticwb.social.PostOutPrivacyRelation
       * @param model Model of the org.semanticwb.social.Tumblr
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPopr_socialNetworkInv(org.semanticwb.social.PostOutPrivacyRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_haspopr_socialNetworkInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Tumblr with a determined Popr_socialNetworkInv
       * @param value Popr_socialNetworkInv of the type org.semanticwb.social.PostOutPrivacyRelation
       * @return Iterator with all the org.semanticwb.social.Tumblr
       */

        public static java.util.Iterator<org.semanticwb.social.Tumblr> listTumblrByPopr_socialNetworkInv(org.semanticwb.social.PostOutPrivacyRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Tumblr> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_haspopr_socialNetworkInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static TumblrBase.ClassMgr getTumblrClassMgr()
    {
        return new TumblrBase.ClassMgr();
    }

   /**
   * Constructs a TumblrBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Tumblr
   */
    public TumblrBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the TokenExpirationDate property
* @return java.util.Date with the TokenExpirationDate
*/
    public java.util.Date getTokenExpirationDate()
    {
        return getSemanticObject().getDateProperty(social_tokenExpirationDate);
    }

/**
* Sets the TokenExpirationDate property
* @param value long with the TokenExpirationDate
*/
    public void setTokenExpirationDate(java.util.Date value)
    {
        getSemanticObject().setDateProperty(social_tokenExpirationDate, value);
    }

/**
* Gets the AccessToken property
* @return String with the AccessToken
*/
    public String getAccessToken()
    {
        return getSemanticObject().getProperty(social_accessToken);
    }

/**
* Sets the AccessToken property
* @param value long with the AccessToken
*/
    public void setAccessToken(String value)
    {
        getSemanticObject().setProperty(social_accessToken, value);
    }

/**
* Gets the AccessTokenSecret property
* @return String with the AccessTokenSecret
*/
    public String getAccessTokenSecret()
    {
        return getSemanticObject().getProperty(social_accessTokenSecret);
    }

/**
* Sets the AccessTokenSecret property
* @param value long with the AccessTokenSecret
*/
    public void setAccessTokenSecret(String value)
    {
        getSemanticObject().setProperty(social_accessTokenSecret, value);
    }
}
