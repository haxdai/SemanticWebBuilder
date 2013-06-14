package org.semanticwb.questionnaire.base;


public abstract class PartBase extends org.semanticwb.model.base.GenericObjectBase implements org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty que_namePart=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#namePart");
    public static final org.semanticwb.platform.SemanticClass que_Part=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Part");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Part");

    public static class ClassMgr
    {
       /**
       * Returns a list of Part for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.Part
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Part> listParts(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Part>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.Part for all models
       * @return Iterator of org.semanticwb.questionnaire.Part
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Part> listParts()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Part>(it, true);
        }

        public static org.semanticwb.questionnaire.Part createPart(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.Part.ClassMgr.createPart(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.Part
       * @param id Identifier for org.semanticwb.questionnaire.Part
       * @param model Model of the org.semanticwb.questionnaire.Part
       * @return A org.semanticwb.questionnaire.Part
       */
        public static org.semanticwb.questionnaire.Part getPart(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Part)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.Part
       * @param id Identifier for org.semanticwb.questionnaire.Part
       * @param model Model of the org.semanticwb.questionnaire.Part
       * @return A org.semanticwb.questionnaire.Part
       */
        public static org.semanticwb.questionnaire.Part createPart(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Part)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.Part
       * @param id Identifier for org.semanticwb.questionnaire.Part
       * @param model Model of the org.semanticwb.questionnaire.Part
       */
        public static void removePart(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.Part
       * @param id Identifier for org.semanticwb.questionnaire.Part
       * @param model Model of the org.semanticwb.questionnaire.Part
       * @return true if the org.semanticwb.questionnaire.Part exists, false otherwise
       */

        public static boolean hasPart(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPart(id, model)!=null);
        }
    }

    public static PartBase.ClassMgr getPartClassMgr()
    {
        return new PartBase.ClassMgr();
    }

   /**
   * Constructs a PartBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Part
   */
    public PartBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Active property
* @return boolean with the Active
*/
    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

/**
* Sets the Active property
* @param value long with the Active
*/
    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
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
* Gets the NamePart property
* @return String with the NamePart
*/
    public String getNamePart()
    {
        return getSemanticObject().getProperty(que_namePart);
    }

/**
* Sets the NamePart property
* @param value long with the NamePart
*/
    public void setNamePart(String value)
    {
        getSemanticObject().setProperty(que_namePart, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
