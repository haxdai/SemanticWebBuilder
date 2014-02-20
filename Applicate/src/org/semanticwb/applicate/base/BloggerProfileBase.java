package org.semanticwb.applicate.base;


public abstract class BloggerProfileBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty app_userBlogger=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#userBlogger");
    public static final org.semanticwb.platform.SemanticProperty app_linkTwitter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#linkTwitter");
    public static final org.semanticwb.platform.SemanticProperty app_linkLinkedin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#linkLinkedin");
    public static final org.semanticwb.platform.SemanticProperty app_linkFacebook=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#linkFacebook");
    public static final org.semanticwb.platform.SemanticProperty app_imageBlogger=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#imageBlogger");
    public static final org.semanticwb.platform.SemanticProperty app_bloggerDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#bloggerDescription");
    public static final org.semanticwb.platform.SemanticProperty app_hasAreasExpertiseBlogger=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#hasAreasExpertiseBlogger");
    public static final org.semanticwb.platform.SemanticProperty app_puesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/applicate#puesto");
    public static final org.semanticwb.platform.SemanticClass app_BloggerProfile=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#BloggerProfile");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/applicate#BloggerProfile");

    public static class ClassMgr
    {
       /**
       * Returns a list of BloggerProfile for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.applicate.BloggerProfile
       */

        public static java.util.Iterator<org.semanticwb.applicate.BloggerProfile> listBloggerProfiles(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.BloggerProfile>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.applicate.BloggerProfile for all models
       * @return Iterator of org.semanticwb.applicate.BloggerProfile
       */

        public static java.util.Iterator<org.semanticwb.applicate.BloggerProfile> listBloggerProfiles()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.applicate.BloggerProfile>(it, true);
        }

        public static org.semanticwb.applicate.BloggerProfile createBloggerProfile(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.applicate.BloggerProfile.ClassMgr.createBloggerProfile(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.applicate.BloggerProfile
       * @param id Identifier for org.semanticwb.applicate.BloggerProfile
       * @param model Model of the org.semanticwb.applicate.BloggerProfile
       * @return A org.semanticwb.applicate.BloggerProfile
       */
        public static org.semanticwb.applicate.BloggerProfile getBloggerProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.BloggerProfile)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.applicate.BloggerProfile
       * @param id Identifier for org.semanticwb.applicate.BloggerProfile
       * @param model Model of the org.semanticwb.applicate.BloggerProfile
       * @return A org.semanticwb.applicate.BloggerProfile
       */
        public static org.semanticwb.applicate.BloggerProfile createBloggerProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.applicate.BloggerProfile)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.applicate.BloggerProfile
       * @param id Identifier for org.semanticwb.applicate.BloggerProfile
       * @param model Model of the org.semanticwb.applicate.BloggerProfile
       */
        public static void removeBloggerProfile(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.applicate.BloggerProfile
       * @param id Identifier for org.semanticwb.applicate.BloggerProfile
       * @param model Model of the org.semanticwb.applicate.BloggerProfile
       * @return true if the org.semanticwb.applicate.BloggerProfile exists, false otherwise
       */

        public static boolean hasBloggerProfile(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBloggerProfile(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.applicate.BloggerProfile with a determined UserBlogger
       * @param value UserBlogger of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.applicate.BloggerProfile
       * @return Iterator with all the org.semanticwb.applicate.BloggerProfile
       */

        public static java.util.Iterator<org.semanticwb.applicate.BloggerProfile> listBloggerProfileByUserBlogger(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.BloggerProfile> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(app_userBlogger, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.applicate.BloggerProfile with a determined UserBlogger
       * @param value UserBlogger of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.applicate.BloggerProfile
       */

        public static java.util.Iterator<org.semanticwb.applicate.BloggerProfile> listBloggerProfileByUserBlogger(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.applicate.BloggerProfile> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(app_userBlogger,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static BloggerProfileBase.ClassMgr getBloggerProfileClassMgr()
    {
        return new BloggerProfileBase.ClassMgr();
    }

   /**
   * Constructs a BloggerProfileBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BloggerProfile
   */
    public BloggerProfileBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property UserBlogger
   * @param value UserBlogger to set
   */

    public void setUserBlogger(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(app_userBlogger, value.getSemanticObject());
        }else
        {
            removeUserBlogger();
        }
    }
   /**
   * Remove the value for UserBlogger property
   */

    public void removeUserBlogger()
    {
        getSemanticObject().removeProperty(app_userBlogger);
    }

   /**
   * Gets the UserBlogger
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUserBlogger()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(app_userBlogger);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the LinkTwitter property
* @return String with the LinkTwitter
*/
    public String getLinkTwitter()
    {
        return getSemanticObject().getProperty(app_linkTwitter);
    }

/**
* Sets the LinkTwitter property
* @param value long with the LinkTwitter
*/
    public void setLinkTwitter(String value)
    {
        getSemanticObject().setProperty(app_linkTwitter, value);
    }

/**
* Gets the LinkLinkedin property
* @return String with the LinkLinkedin
*/
    public String getLinkLinkedin()
    {
        return getSemanticObject().getProperty(app_linkLinkedin);
    }

/**
* Sets the LinkLinkedin property
* @param value long with the LinkLinkedin
*/
    public void setLinkLinkedin(String value)
    {
        getSemanticObject().setProperty(app_linkLinkedin, value);
    }

/**
* Gets the LinkFacebook property
* @return String with the LinkFacebook
*/
    public String getLinkFacebook()
    {
        return getSemanticObject().getProperty(app_linkFacebook);
    }

/**
* Sets the LinkFacebook property
* @param value long with the LinkFacebook
*/
    public void setLinkFacebook(String value)
    {
        getSemanticObject().setProperty(app_linkFacebook, value);
    }

/**
* Gets the ImageBlogger property
* @return String with the ImageBlogger
*/
    public String getImageBlogger()
    {
        return getSemanticObject().getProperty(app_imageBlogger);
    }

/**
* Sets the ImageBlogger property
* @param value long with the ImageBlogger
*/
    public void setImageBlogger(String value)
    {
        getSemanticObject().setProperty(app_imageBlogger, value);
    }

/**
* Gets the BloggerDescription property
* @return String with the BloggerDescription
*/
    public String getBloggerDescription()
    {
        return getSemanticObject().getProperty(app_bloggerDescription);
    }

/**
* Sets the BloggerDescription property
* @param value long with the BloggerDescription
*/
    public void setBloggerDescription(String value)
    {
        getSemanticObject().setProperty(app_bloggerDescription, value);
    }

    public java.util.Iterator<String> listAreasExpertiseBloggers()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(app_hasAreasExpertiseBlogger);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addAreasExpertiseBlogger(String value)
    {
        getSemanticObject().addLiteralProperty(app_hasAreasExpertiseBlogger, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllAreasExpertiseBlogger()
    {
        getSemanticObject().removeProperty(app_hasAreasExpertiseBlogger);
    }

    public void removeAreasExpertiseBlogger(String value)
    {
        getSemanticObject().removeLiteralProperty(app_hasAreasExpertiseBlogger,new org.semanticwb.platform.SemanticLiteral(value));
    }

/**
* Gets the Puesto property
* @return String with the Puesto
*/
    public String getPuesto()
    {
        return getSemanticObject().getProperty(app_puesto);
    }

/**
* Sets the Puesto property
* @param value long with the Puesto
*/
    public void setPuesto(String value)
    {
        getSemanticObject().setProperty(app_puesto, value);
    }
}
