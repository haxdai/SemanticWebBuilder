package org.swb.social.model.base;


   /**
   * Objeto que se encarga de almacenar todos los datos de una red social 
   */
public abstract class SocialNetworkBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Login de conexión a la red social
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_sn_login=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#sn_login");
   /**
   * Url de conexión a la red social
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_sn_url=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#sn_url");
    public static final org.semanticwb.platform.SemanticProperty smcc_sn_name=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#sn_name");
   /**
   * Password de conexión a la Red Social
   */
    public static final org.semanticwb.platform.SemanticProperty smcc_sn_password=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.owl-ontologies.com/ssmcc#sn_password");
   /**
   * Objeto que se encarga de almacenar todos los datos de una red social
   */
    public static final org.semanticwb.platform.SemanticClass smcc_SocialNetwork=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#SocialNetwork");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.owl-ontologies.com/ssmcc#SocialNetwork");

    public static class ClassMgr
    {
       /**
       * Returns a list of SocialNetwork for a model
       * @param model Model to find
       * @return Iterator of org.swb.social.model.SocialNetwork
       */

        public static java.util.Iterator<org.swb.social.model.SocialNetwork> listSocialNetworks(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.swb.social.model.SocialNetwork>(it, true);
        }
       /**
       * Returns a list of org.swb.social.model.SocialNetwork for all models
       * @return Iterator of org.swb.social.model.SocialNetwork
       */

        public static java.util.Iterator<org.swb.social.model.SocialNetwork> listSocialNetworks()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.swb.social.model.SocialNetwork>(it, true);
        }
       /**
       * Gets a org.swb.social.model.SocialNetwork
       * @param id Identifier for org.swb.social.model.SocialNetwork
       * @param model Model of the org.swb.social.model.SocialNetwork
       * @return A org.swb.social.model.SocialNetwork
       */
        public static org.swb.social.model.SocialNetwork getSocialNetwork(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.swb.social.model.SocialNetwork)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.swb.social.model.SocialNetwork
       * @param id Identifier for org.swb.social.model.SocialNetwork
       * @param model Model of the org.swb.social.model.SocialNetwork
       * @return A org.swb.social.model.SocialNetwork
       */
        public static org.swb.social.model.SocialNetwork createSocialNetwork(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.swb.social.model.SocialNetwork)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.swb.social.model.SocialNetwork
       * @param id Identifier for org.swb.social.model.SocialNetwork
       * @param model Model of the org.swb.social.model.SocialNetwork
       */
        public static void removeSocialNetwork(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.swb.social.model.SocialNetwork
       * @param id Identifier for org.swb.social.model.SocialNetwork
       * @param model Model of the org.swb.social.model.SocialNetwork
       * @return true if the org.swb.social.model.SocialNetwork exists, false otherwise
       */

        public static boolean hasSocialNetwork(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSocialNetwork(id, model)!=null);
        }
       /**
       * Gets all org.swb.social.model.SocialNetwork with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.swb.social.model.SocialNetwork
       * @return Iterator with all the org.swb.social.model.SocialNetwork
       */

        public static java.util.Iterator<org.swb.social.model.SocialNetwork> listSocialNetworkByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialNetwork> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialNetwork with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.swb.social.model.SocialNetwork
       */

        public static java.util.Iterator<org.swb.social.model.SocialNetwork> listSocialNetworkByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialNetwork> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialNetwork with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.swb.social.model.SocialNetwork
       * @return Iterator with all the org.swb.social.model.SocialNetwork
       */

        public static java.util.Iterator<org.swb.social.model.SocialNetwork> listSocialNetworkByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialNetwork> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.swb.social.model.SocialNetwork with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.swb.social.model.SocialNetwork
       */

        public static java.util.Iterator<org.swb.social.model.SocialNetwork> listSocialNetworkByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.swb.social.model.SocialNetwork> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SocialNetworkBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SocialNetwork
   */
    public SocialNetworkBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the Sn_login property
* @return String with the Sn_login
*/
    public String getSn_login()
    {
        return getSemanticObject().getProperty(smcc_sn_login);
    }

/**
* Sets the Sn_login property
* @param value long with the Sn_login
*/
    public void setSn_login(String value)
    {
        getSemanticObject().setProperty(smcc_sn_login, value);
    }

/**
* Gets the Sn_url property
* @return String with the Sn_url
*/
    public String getSn_url()
    {
        return getSemanticObject().getProperty(smcc_sn_url);
    }

/**
* Sets the Sn_url property
* @param value long with the Sn_url
*/
    public void setSn_url(String value)
    {
        getSemanticObject().setProperty(smcc_sn_url, value);
    }

/**
* Gets the Sn_name property
* @return String with the Sn_name
*/
    public String getSn_name()
    {
        return getSemanticObject().getProperty(smcc_sn_name);
    }

/**
* Sets the Sn_name property
* @param value long with the Sn_name
*/
    public void setSn_name(String value)
    {
        getSemanticObject().setProperty(smcc_sn_name, value);
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
* Gets the Sn_password property
* @return String with the Sn_password
*/
    public String getSn_password()
    {
        return getSemanticObject().getProperty(smcc_sn_password);
    }

/**
* Sets the Sn_password property
* @param value long with the Sn_password
*/
    public void setSn_password(String value)
    {
        getSemanticObject().setProperty(smcc_sn_password, value);
    }
}
