package org.semanticwb.social.base;


   /**
   * Clase red social para Google+ 
   */
public abstract class GoogleBase extends org.semanticwb.social.SocialNetwork implements org.semanticwb.social.Messageable,org.semanticwb.social.DeveloperKeyable,org.semanticwb.social.PostOutMonitorable,org.semanticwb.social.SocialNetPostable,org.semanticwb.social.Listenerable,org.semanticwb.social.Oauthable,org.semanticwb.model.Descriptiveable,org.semanticwb.social.Photoable,org.semanticwb.social.Relationable,org.semanticwb.model.FilterableNode,org.semanticwb.model.Trashable,org.semanticwb.model.Activeable,org.semanticwb.social.Secreteable,org.semanticwb.model.Traceable,org.semanticwb.social.Videoable,org.semanticwb.social.Kloutable,org.semanticwb.model.FilterableClass,org.semanticwb.model.Filterable
{
   /**
   * Clase red social para Google+
   */
    public static final org.semanticwb.platform.SemanticClass social_Google=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Google");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Google");

    public static class ClassMgr
    {
       /**
       * Returns a list of Google for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Google>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.Google for all models
       * @return Iterator of org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Google>(it, true);
        }
       /**
       * Gets a org.semanticwb.social.Google
       * @param id Identifier for org.semanticwb.social.Google
       * @param model Model of the org.semanticwb.social.Google
       * @return A org.semanticwb.social.Google
       */
        public static org.semanticwb.social.Google getGoogle(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Google)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.Google
       * @param id Identifier for org.semanticwb.social.Google
       * @param model Model of the org.semanticwb.social.Google
       * @return A org.semanticwb.social.Google
       */
        public static org.semanticwb.social.Google createGoogle(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Google)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.Google
       * @param id Identifier for org.semanticwb.social.Google
       * @param model Model of the org.semanticwb.social.Google
       */
        public static void removeGoogle(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.Google
       * @param id Identifier for org.semanticwb.social.Google
       * @param model Model of the org.semanticwb.social.Google
       * @return true if the org.semanticwb.social.Google exists, false otherwise
       */

        public static boolean hasGoogle(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGoogle(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined SocialNetworkPostOutInv
       * @param value SocialNetworkPostOutInv of the type org.semanticwb.social.PostOut
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleBySocialNetworkPostOutInv(org.semanticwb.social.PostOut value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetworkPostOutInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined SocialNetworkPostOutInv
       * @param value SocialNetworkPostOutInv of the type org.semanticwb.social.PostOut
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleBySocialNetworkPostOutInv(org.semanticwb.social.PostOut value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetworkPostOutInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined SocialNetStreamSearchInv
       * @param value SocialNetStreamSearchInv of the type org.semanticwb.social.SocialNetStreamSearch
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleBySocialNetStreamSearchInv(org.semanticwb.social.SocialNetStreamSearch value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetStreamSearchInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined SocialNetStreamSearchInv
       * @param value SocialNetStreamSearchInv of the type org.semanticwb.social.SocialNetStreamSearch
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleBySocialNetStreamSearchInv(org.semanticwb.social.SocialNetStreamSearch value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialNetStreamSearchInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined Podur_SocialNetworkInv
       * @param value Podur_SocialNetworkInv of the type org.semanticwb.social.PostOutDirectUserRelation
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPodur_SocialNetworkInv(org.semanticwb.social.PostOutDirectUserRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_haspodur_SocialNetworkInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined Podur_SocialNetworkInv
       * @param value Podur_SocialNetworkInv of the type org.semanticwb.social.PostOutDirectUserRelation
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPodur_SocialNetworkInv(org.semanticwb.social.PostOutDirectUserRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_haspodur_SocialNetworkInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostListenerContainer
       * @param value PostListenerContainer of the type org.semanticwb.social.PostInContainer
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostListenerContainer(org.semanticwb.social.PostInContainer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostListenerContainer, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostListenerContainer
       * @param value PostListenerContainer of the type org.semanticwb.social.PostInContainer
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostListenerContainer(org.semanticwb.social.PostInContainer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostListenerContainer,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostContainer
       * @param value PostContainer of the type org.semanticwb.social.PostOutContainer
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostContainer(org.semanticwb.social.PostOutContainer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostContainer, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostContainer
       * @param value PostContainer of the type org.semanticwb.social.PostOutContainer
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostContainer(org.semanticwb.social.PostOutContainer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostContainer,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostInSocialNetworkInv
       * @param value PostInSocialNetworkInv of the type org.semanticwb.social.PostIn
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostInSocialNetworkInv(org.semanticwb.social.PostIn value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostInSocialNetworkInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostInSocialNetworkInv
       * @param value PostInSocialNetworkInv of the type org.semanticwb.social.PostIn
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostInSocialNetworkInv(org.semanticwb.social.PostIn value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostInSocialNetworkInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostOutLinksInv
       * @param value PostOutLinksInv of the type org.semanticwb.social.PostOutLinksHits
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostOutLinksInv(org.semanticwb.social.PostOutLinksHits value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasPostOutLinksInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined PostOutLinksInv
       * @param value PostOutLinksInv of the type org.semanticwb.social.PostOutLinksHits
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPostOutLinksInv(org.semanticwb.social.PostOutLinksHits value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasPostOutLinksInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined SocialPostInv
       * @param value SocialPostInv of the type org.semanticwb.social.PostOutNet
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleBySocialPostInv(org.semanticwb.social.PostOutNet value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialPostInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined SocialPostInv
       * @param value SocialPostInv of the type org.semanticwb.social.PostOutNet
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleBySocialPostInv(org.semanticwb.social.PostOutNet value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_hasSocialPostInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined Popr_socialNetworkInv
       * @param value Popr_socialNetworkInv of the type org.semanticwb.social.PostOutPrivacyRelation
       * @param model Model of the org.semanticwb.social.Google
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPopr_socialNetworkInv(org.semanticwb.social.PostOutPrivacyRelation value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(social_haspopr_socialNetworkInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Google with a determined Popr_socialNetworkInv
       * @param value Popr_socialNetworkInv of the type org.semanticwb.social.PostOutPrivacyRelation
       * @return Iterator with all the org.semanticwb.social.Google
       */

        public static java.util.Iterator<org.semanticwb.social.Google> listGoogleByPopr_socialNetworkInv(org.semanticwb.social.PostOutPrivacyRelation value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Google> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(social_haspopr_socialNetworkInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static GoogleBase.ClassMgr getGoogleClassMgr()
    {
        return new GoogleBase.ClassMgr();
    }

   /**
   * Constructs a GoogleBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Google
   */
    public GoogleBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the DeveloperKey property
* @return String with the DeveloperKey
*/
    public String getDeveloperKey()
    {
        return getSemanticObject().getProperty(social_developerKey);
    }

/**
* Sets the DeveloperKey property
* @param value long with the DeveloperKey
*/
    public void setDeveloperKey(String value)
    {
        getSemanticObject().setProperty(social_developerKey, value);
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

/**
* Gets the RefreshToken property
* @return String with the RefreshToken
*/
    public String getRefreshToken()
    {
        return getSemanticObject().getProperty(social_refreshToken);
    }

/**
* Sets the RefreshToken property
* @param value long with the RefreshToken
*/
    public void setRefreshToken(String value)
    {
        getSemanticObject().setProperty(social_refreshToken, value);
    }
}
