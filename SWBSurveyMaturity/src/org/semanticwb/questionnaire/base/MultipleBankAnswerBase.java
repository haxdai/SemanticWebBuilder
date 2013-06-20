package org.semanticwb.questionnaire.base;


public abstract class MultipleBankAnswerBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass que_MultipleBankAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#MultipleBankAnswer");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#MultipleBankAnswer");

    public static class ClassMgr
    {
       /**
       * Returns a list of MultipleBankAnswer for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.MultipleBankAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.MultipleBankAnswer> listMultipleBankAnswers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.MultipleBankAnswer>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.MultipleBankAnswer for all models
       * @return Iterator of org.semanticwb.questionnaire.MultipleBankAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.MultipleBankAnswer> listMultipleBankAnswers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.MultipleBankAnswer>(it, true);
        }

        public static org.semanticwb.questionnaire.MultipleBankAnswer createMultipleBankAnswer(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.MultipleBankAnswer.ClassMgr.createMultipleBankAnswer(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.MultipleBankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.MultipleBankAnswer
       * @param model Model of the org.semanticwb.questionnaire.MultipleBankAnswer
       * @return A org.semanticwb.questionnaire.MultipleBankAnswer
       */
        public static org.semanticwb.questionnaire.MultipleBankAnswer getMultipleBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.MultipleBankAnswer)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.MultipleBankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.MultipleBankAnswer
       * @param model Model of the org.semanticwb.questionnaire.MultipleBankAnswer
       * @return A org.semanticwb.questionnaire.MultipleBankAnswer
       */
        public static org.semanticwb.questionnaire.MultipleBankAnswer createMultipleBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.MultipleBankAnswer)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.MultipleBankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.MultipleBankAnswer
       * @param model Model of the org.semanticwb.questionnaire.MultipleBankAnswer
       */
        public static void removeMultipleBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.MultipleBankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.MultipleBankAnswer
       * @param model Model of the org.semanticwb.questionnaire.MultipleBankAnswer
       * @return true if the org.semanticwb.questionnaire.MultipleBankAnswer exists, false otherwise
       */

        public static boolean hasMultipleBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMultipleBankAnswer(id, model)!=null);
        }
    }

    public static MultipleBankAnswerBase.ClassMgr getMultipleBankAnswerClassMgr()
    {
        return new MultipleBankAnswerBase.ClassMgr();
    }

   /**
   * Constructs a MultipleBankAnswerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the MultipleBankAnswer
   */
    public MultipleBankAnswerBase(org.semanticwb.platform.SemanticObject base)
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
}
