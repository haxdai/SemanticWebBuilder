package org.semanticwb.questionnaire.base;


public abstract class BankQuestionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty que_note=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#note");
    public static final org.semanticwb.platform.SemanticProperty que_textQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#textQuestion");
    public static final org.semanticwb.platform.SemanticClass que_BankQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankQuestion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankQuestion");

    public static class ClassMgr
    {
       /**
       * Returns a list of BankQuestion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.BankQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankQuestion> listBankQuestions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankQuestion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.BankQuestion for all models
       * @return Iterator of org.semanticwb.questionnaire.BankQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankQuestion> listBankQuestions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankQuestion>(it, true);
        }

        public static org.semanticwb.questionnaire.BankQuestion createBankQuestion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.BankQuestion.ClassMgr.createBankQuestion(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.BankQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankQuestion
       * @return A org.semanticwb.questionnaire.BankQuestion
       */
        public static org.semanticwb.questionnaire.BankQuestion getBankQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankQuestion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.BankQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankQuestion
       * @return A org.semanticwb.questionnaire.BankQuestion
       */
        public static org.semanticwb.questionnaire.BankQuestion createBankQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankQuestion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.BankQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankQuestion
       */
        public static void removeBankQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.BankQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankQuestion
       * @return true if the org.semanticwb.questionnaire.BankQuestion exists, false otherwise
       */

        public static boolean hasBankQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBankQuestion(id, model)!=null);
        }
    }

    public static BankQuestionBase.ClassMgr getBankQuestionClassMgr()
    {
        return new BankQuestionBase.ClassMgr();
    }

   /**
   * Constructs a BankQuestionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BankQuestion
   */
    public BankQuestionBase(org.semanticwb.platform.SemanticObject base)
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
