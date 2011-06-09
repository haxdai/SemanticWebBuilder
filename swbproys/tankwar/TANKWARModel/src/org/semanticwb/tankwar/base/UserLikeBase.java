package org.semanticwb.tankwar.base;


   /**
   * Define la estructura de datos para almacenar los gustos del usuario 
   */
public abstract class UserLikeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Define la estructura de datos para almacenar los gustos del usuario
   */
    public static final org.semanticwb.platform.SemanticClass tank_UserLike=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#userLike");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/tankwar#userLike");

    public static class ClassMgr
    {
       /**
       * Returns a list of UserLike for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.tankwar.UserLike
       */

        public static java.util.Iterator<org.semanticwb.tankwar.UserLike> listUserLikes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.UserLike>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.tankwar.UserLike for all models
       * @return Iterator of org.semanticwb.tankwar.UserLike
       */

        public static java.util.Iterator<org.semanticwb.tankwar.UserLike> listUserLikes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.tankwar.UserLike>(it, true);
        }
       /**
       * Gets a org.semanticwb.tankwar.UserLike
       * @param id Identifier for org.semanticwb.tankwar.UserLike
       * @param model Model of the org.semanticwb.tankwar.UserLike
       * @return A org.semanticwb.tankwar.UserLike
       */
        public static org.semanticwb.tankwar.UserLike getUserLike(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.UserLike)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.tankwar.UserLike
       * @param id Identifier for org.semanticwb.tankwar.UserLike
       * @param model Model of the org.semanticwb.tankwar.UserLike
       * @return A org.semanticwb.tankwar.UserLike
       */
        public static org.semanticwb.tankwar.UserLike createUserLike(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.tankwar.UserLike)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.tankwar.UserLike
       * @param id Identifier for org.semanticwb.tankwar.UserLike
       * @param model Model of the org.semanticwb.tankwar.UserLike
       */
        public static void removeUserLike(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.tankwar.UserLike
       * @param id Identifier for org.semanticwb.tankwar.UserLike
       * @param model Model of the org.semanticwb.tankwar.UserLike
       * @return true if the org.semanticwb.tankwar.UserLike exists, false otherwise
       */

        public static boolean hasUserLike(String id, org.semanticwb.model.SWBModel model)
        {
            return (getUserLike(id, model)!=null);
        }
    }

   /**
   * Constructs a UserLikeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UserLike
   */
    public UserLikeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
}
