package org.semanticwb.social.base;


   /**
   * Clase que comprende todos los tipos de Post que pueden ir siendo creados en la herramienta. 
   */
public abstract class PostBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable,org.semanticwb.model.Tagable
{
   /**
   * Propiedad con valor entero que representa el tipo de Sentimientos que expresa el Post, estos se estan definiendo de esta manera: 0) Neutro 1) Positivo 2)Negativo, estos valores pueden ser mas y permanecer en un objeto tipo colección en lo futuro.
   */
    public static final org.semanticwb.platform.SemanticProperty social_PostSentimentType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#PostSentimentType");
    public static final org.semanticwb.platform.SemanticProperty social_SocialNetPostId=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#SocialNetPostId");
   /**
   * Valor que es resultado del algoritmo de intensidad, mediante este valor se puede determinar si la intencidad es alta, media o baja
   */
    public static final org.semanticwb.platform.SemanticProperty social_PostIntensityValue=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#PostIntensityValue");
   /**
   * Valor que resulta del algoritmo de analisis sentimental, aqui se puede ver el porque se pone cierto valir a la propiedad PostSentimentalType
   */
    public static final org.semanticwb.platform.SemanticProperty social_PostSentimentalValue=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/social#PostSentimentalValue");
   /**
   * Clase que comprende todos los tipos de Post que pueden ir siendo creados en la herramienta.
   */
    public static final org.semanticwb.platform.SemanticClass social_Post=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Post");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/social#Post");

    public static class ClassMgr
    {
       /**
       * Returns a list of Post for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.social.Post
       */

        public static java.util.Iterator<org.semanticwb.social.Post> listPosts(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Post>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.social.Post for all models
       * @return Iterator of org.semanticwb.social.Post
       */

        public static java.util.Iterator<org.semanticwb.social.Post> listPosts()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.social.Post>(it, true);
        }

        public static org.semanticwb.social.Post createPost(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.social.Post.ClassMgr.createPost(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.social.Post
       * @param id Identifier for org.semanticwb.social.Post
       * @param model Model of the org.semanticwb.social.Post
       * @return A org.semanticwb.social.Post
       */
        public static org.semanticwb.social.Post getPost(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Post)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.social.Post
       * @param id Identifier for org.semanticwb.social.Post
       * @param model Model of the org.semanticwb.social.Post
       * @return A org.semanticwb.social.Post
       */
        public static org.semanticwb.social.Post createPost(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.social.Post)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.social.Post
       * @param id Identifier for org.semanticwb.social.Post
       * @param model Model of the org.semanticwb.social.Post
       */
        public static void removePost(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.social.Post
       * @param id Identifier for org.semanticwb.social.Post
       * @param model Model of the org.semanticwb.social.Post
       * @return true if the org.semanticwb.social.Post exists, false otherwise
       */

        public static boolean hasPost(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPost(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.social.Post with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Post
       * @return Iterator with all the org.semanticwb.social.Post
       */

        public static java.util.Iterator<org.semanticwb.social.Post> listPostByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Post> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Post with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Post
       */

        public static java.util.Iterator<org.semanticwb.social.Post> listPostByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Post> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Post with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.social.Post
       * @return Iterator with all the org.semanticwb.social.Post
       */

        public static java.util.Iterator<org.semanticwb.social.Post> listPostByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Post> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.social.Post with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.social.Post
       */

        public static java.util.Iterator<org.semanticwb.social.Post> listPostByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.social.Post> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
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
* Gets the PostSentimentType property
* @return int with the PostSentimentType
*/
    public int getPostSentimentType()
    {
        return getSemanticObject().getIntProperty(social_PostSentimentType);
    }

/**
* Sets the PostSentimentType property
* @param value long with the PostSentimentType
*/
    public void setPostSentimentType(int value)
    {
        getSemanticObject().setIntProperty(social_PostSentimentType, value);
    }

/**
* Gets the SocialNetPostId property
* @return String with the SocialNetPostId
*/
    public String getSocialNetPostId()
    {
        return getSemanticObject().getProperty(social_SocialNetPostId);
    }

/**
* Sets the SocialNetPostId property
* @param value long with the SocialNetPostId
*/
    public void setSocialNetPostId(String value)
    {
        getSemanticObject().setProperty(social_SocialNetPostId, value);
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
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }

/**
* Gets the PostIntensityValue property
* @return float with the PostIntensityValue
*/
    public float getPostIntensityValue()
    {
        return getSemanticObject().getFloatProperty(social_PostIntensityValue);
    }

/**
* Sets the PostIntensityValue property
* @param value long with the PostIntensityValue
*/
    public void setPostIntensityValue(float value)
    {
        getSemanticObject().setFloatProperty(social_PostIntensityValue, value);
    }

/**
* Gets the PostSentimentalValue property
* @return float with the PostSentimentalValue
*/
    public float getPostSentimentalValue()
    {
        return getSemanticObject().getFloatProperty(social_PostSentimentalValue);
    }

/**
* Sets the PostSentimentalValue property
* @param value long with the PostSentimentalValue
*/
    public void setPostSentimentalValue(float value)
    {
        getSemanticObject().setFloatProperty(social_PostSentimentalValue, value);
    }
}
