package org.swb.social.model.base;


   /**
   * Clase Post, esta es la principal, es donde se guarda cada post que trae el listener 
   */
public abstract class PostBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Longitud desde donde se produjo el mensaje, esta la podemos representar en google maps
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_postLongitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postLongitude");
   /**
   * Imagen de perfil en la red social
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_postProfileImg=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postProfileImg");
   /**
   * Fuente desde la que se produce el mensaje (Twiitter para Iphone, Twiitter para Android, Web, etc)
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_postSourceDevice=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postSourceDevice");
   /**
   * Lenguaje en el que se encuentra el mensaje o post
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_postLang=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postLang");
   /**
   * Usuario que ha escrito un post en una red social
   */
    public static final org.semanticwb.platform.SemanticClass smcc_SocialUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#SocialUser");
   /**
   * Usuario del cual proviene el mensaje (post)
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_postFromUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postFromUser");
   /**
   * Latitud desde donde se producjo el mensaje, esta la podemos representar en google maps
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_postLatitude=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postLatitude");
    public static final org.semanticwb.platform.SemanticProperty smcc_postMsg=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postMsg");
   /**
   * Usuario al que va dirigido el mensaje (post)
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_postToUser=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#postToUser");
   /**
   * Clase Post, esta es la principal, es donde se guarda cada post que trae el listener
   */
    public static final org.semanticwb.platform.SemanticClass smcc_Post=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#Post");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#Post");

    public static class ClassMgr
    {
       /**
       * Returns a list of Post for a model
       * @param model Model to find
       * @return Iterator of org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPosts(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.swb.social.model.Post>(it, true);
        }
       /**
       * Returns a list of org.swb.social.model.Post for all models
       * @return Iterator of org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPosts()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.swb.social.model.Post>(it, true);
        }
       /**
       * Gets a org.swb.social.model.Post
       * @param id Identifier for org.swb.social.model.Post
       * @param model Model of the org.swb.social.model.Post
       * @return A org.swb.social.model.Post
       */
        public static org.swb.social.model.Post getPost(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.swb.social.model.Post)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.swb.social.model.Post
       * @param id Identifier for org.swb.social.model.Post
       * @param model Model of the org.swb.social.model.Post
       * @return A org.swb.social.model.Post
       */
        public static org.swb.social.model.Post createPost(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.swb.social.model.Post)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.swb.social.model.Post
       * @param id Identifier for org.swb.social.model.Post
       * @param model Model of the org.swb.social.model.Post
       */
        public static void removePost(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.swb.social.model.Post
       * @param id Identifier for org.swb.social.model.Post
       * @param model Model of the org.swb.social.model.Post
       * @return true if the org.swb.social.model.Post exists, false otherwise
       */

        public static boolean hasPost(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPost(id, model)!=null);
        }
       /**
       * Gets all org.swb.social.model.Post with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.swb.social.model.Post
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.Post with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.Post with a determined PostFromUser
       * @param value PostFromUser of the type org.swb.social.model.SocialUser
       * @param model Model of the org.swb.social.model.Post
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByPostFromUser(org.swb.social.model.SocialUser value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(smcc_postFromUser, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.Post with a determined PostFromUser
       * @param value PostFromUser of the type org.swb.social.model.SocialUser
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByPostFromUser(org.swb.social.model.SocialUser value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(smcc_postFromUser,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.Post with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.swb.social.model.Post
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.Post with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.Post with a determined PostToUser
       * @param value PostToUser of the type org.swb.social.model.SocialUser
       * @param model Model of the org.swb.social.model.Post
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByPostToUser(org.swb.social.model.SocialUser value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(smcc_postToUser, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.Post with a determined PostToUser
       * @param value PostToUser of the type org.swb.social.model.SocialUser
       * @return Iterator with all the org.swb.social.model.Post
       */

        public static java.util.Iterator<org.swb.social.model.Post> listPostByPostToUser(org.swb.social.model.SocialUser value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.Post> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(smcc_postToUser,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PostBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Post
   */
    public PostBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the PostLongitude property
* @return String with the PostLongitude
*/
    public String getPostLongitude()
    {
        return getSemanticObject().getProperty(smcc_postLongitude);
    }

/**
* Sets the PostLongitude property
* @param value long with the PostLongitude
*/
    public void setPostLongitude(String value)
    {
        getSemanticObject().setProperty(smcc_postLongitude, value);
    }

/**
* Gets the PostProfileImg property
* @return String with the PostProfileImg
*/
    public String getPostProfileImg()
    {
        return getSemanticObject().getProperty(smcc_postProfileImg);
    }

/**
* Sets the PostProfileImg property
* @param value long with the PostProfileImg
*/
    public void setPostProfileImg(String value)
    {
        getSemanticObject().setProperty(smcc_postProfileImg, value);
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
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }

/**
* Gets the PostSourceDevice property
* @return String with the PostSourceDevice
*/
    public String getPostSourceDevice()
    {
        return getSemanticObject().getProperty(smcc_postSourceDevice);
    }

/**
* Sets the PostSourceDevice property
* @param value long with the PostSourceDevice
*/
    public void setPostSourceDevice(String value)
    {
        getSemanticObject().setProperty(smcc_postSourceDevice, value);
    }

/**
* Gets the PostLang property
* @return String with the PostLang
*/
    public String getPostLang()
    {
        return getSemanticObject().getProperty(smcc_postLang);
    }

/**
* Sets the PostLang property
* @param value long with the PostLang
*/
    public void setPostLang(String value)
    {
        getSemanticObject().setProperty(smcc_postLang, value);
    }
   /**
   * Sets the value for the property PostFromUser
   * @param value PostFromUser to set
   */

    public void setPostFromUser(org.swb.social.model.SocialUser value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(smcc_postFromUser, value.getSemanticObject());
        }else
        {
            removePostFromUser();
        }
    }
   /**
   * Remove the value for PostFromUser property
   */

    public void removePostFromUser()
    {
        getSemanticObject().removeProperty(smcc_postFromUser);
    }

   /**
   * Gets the PostFromUser
   * @return a org.swb.social.model.SocialUser
   */
    public org.swb.social.model.SocialUser getPostFromUser()
    {
         org.swb.social.model.SocialUser ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(smcc_postFromUser);
         if(obj!=null)
         {
             ret=(org.swb.social.model.SocialUser)obj.createGenericInstance();
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
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the PostLatitude property
* @return String with the PostLatitude
*/
    public String getPostLatitude()
    {
        return getSemanticObject().getProperty(smcc_postLatitude);
    }

/**
* Sets the PostLatitude property
* @param value long with the PostLatitude
*/
    public void setPostLatitude(String value)
    {
        getSemanticObject().setProperty(smcc_postLatitude, value);
    }

/**
* Gets the PostMsg property
* @return String with the PostMsg
*/
    public String getPostMsg()
    {
        return getSemanticObject().getProperty(smcc_postMsg);
    }

/**
* Sets the PostMsg property
* @param value long with the PostMsg
*/
    public void setPostMsg(String value)
    {
        getSemanticObject().setProperty(smcc_postMsg, value);
    }
   /**
   * Sets the value for the property PostToUser
   * @param value PostToUser to set
   */

    public void setPostToUser(org.swb.social.model.SocialUser value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(smcc_postToUser, value.getSemanticObject());
        }else
        {
            removePostToUser();
        }
    }
   /**
   * Remove the value for PostToUser property
   */

    public void removePostToUser()
    {
        getSemanticObject().removeProperty(smcc_postToUser);
    }

   /**
   * Gets the PostToUser
   * @return a org.swb.social.model.SocialUser
   */
    public org.swb.social.model.SocialUser getPostToUser()
    {
         org.swb.social.model.SocialUser ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(smcc_postToUser);
         if(obj!=null)
         {
             ret=(org.swb.social.model.SocialUser)obj.createGenericInstance();
         }
         return ret;
    }
}
