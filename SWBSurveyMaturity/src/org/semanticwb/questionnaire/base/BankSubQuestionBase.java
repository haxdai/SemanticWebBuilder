package org.semanticwb.questionnaire.base;


public abstract class BankSubQuestionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty que_typeSubquestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#typeSubquestion");
    public static final org.semanticwb.platform.SemanticClass que_BankSubQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankSubQuestion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankSubQuestion");

    public static class ClassMgr
    {
       /**
       * Returns a list of BankSubQuestion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.BankSubQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankSubQuestion> listBankSubQuestions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankSubQuestion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.BankSubQuestion for all models
       * @return Iterator of org.semanticwb.questionnaire.BankSubQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankSubQuestion> listBankSubQuestions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankSubQuestion>(it, true);
        }

        public static org.semanticwb.questionnaire.BankSubQuestion createBankSubQuestion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.BankSubQuestion.ClassMgr.createBankSubQuestion(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.BankSubQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankSubQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankSubQuestion
       * @return A org.semanticwb.questionnaire.BankSubQuestion
       */
        public static org.semanticwb.questionnaire.BankSubQuestion getBankSubQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankSubQuestion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.BankSubQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankSubQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankSubQuestion
       * @return A org.semanticwb.questionnaire.BankSubQuestion
       */
        public static org.semanticwb.questionnaire.BankSubQuestion createBankSubQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankSubQuestion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.BankSubQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankSubQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankSubQuestion
       */
        public static void removeBankSubQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.BankSubQuestion
       * @param id Identifier for org.semanticwb.questionnaire.BankSubQuestion
       * @param model Model of the org.semanticwb.questionnaire.BankSubQuestion
       * @return true if the org.semanticwb.questionnaire.BankSubQuestion exists, false otherwise
       */

        public static boolean hasBankSubQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBankSubQuestion(id, model)!=null);
        }
    }

    public static BankSubQuestionBase.ClassMgr getBankSubQuestionClassMgr()
    {
        return new BankSubQuestionBase.ClassMgr();
    }

   /**
   * Constructs a BankSubQuestionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BankSubQuestion
   */
    public BankSubQuestionBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the TypeSubquestion property
* @return String with the TypeSubquestion
*/
    public String getTypeSubquestion()
    {
        return getSemanticObject().getProperty(que_typeSubquestion);
    }

/**
* Sets the TypeSubquestion property
* @param value long with the TypeSubquestion
*/
    public void setTypeSubquestion(String value)
    {
        getSemanticObject().setProperty(que_typeSubquestion, value);
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
