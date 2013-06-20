package org.semanticwb.questionnaire.base;


public abstract class BankAnswerBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass que_MultipleBankAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#MultipleBankAnswer");
    public static final org.semanticwb.platform.SemanticProperty que_hasMultipleBankAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#hasMultipleBankAnswer");
    public static final org.semanticwb.platform.SemanticProperty que_typeAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#typeAnswer");
    public static final org.semanticwb.platform.SemanticClass que_BankAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankAnswer");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankAnswer");

    public static class ClassMgr
    {
       /**
       * Returns a list of BankAnswer for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.BankAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankAnswer> listBankAnswers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankAnswer>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.BankAnswer for all models
       * @return Iterator of org.semanticwb.questionnaire.BankAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankAnswer> listBankAnswers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankAnswer>(it, true);
        }

        public static org.semanticwb.questionnaire.BankAnswer createBankAnswer(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.BankAnswer.ClassMgr.createBankAnswer(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.BankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.BankAnswer
       * @param model Model of the org.semanticwb.questionnaire.BankAnswer
       * @return A org.semanticwb.questionnaire.BankAnswer
       */
        public static org.semanticwb.questionnaire.BankAnswer getBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankAnswer)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.BankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.BankAnswer
       * @param model Model of the org.semanticwb.questionnaire.BankAnswer
       * @return A org.semanticwb.questionnaire.BankAnswer
       */
        public static org.semanticwb.questionnaire.BankAnswer createBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankAnswer)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.BankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.BankAnswer
       * @param model Model of the org.semanticwb.questionnaire.BankAnswer
       */
        public static void removeBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.BankAnswer
       * @param id Identifier for org.semanticwb.questionnaire.BankAnswer
       * @param model Model of the org.semanticwb.questionnaire.BankAnswer
       * @return true if the org.semanticwb.questionnaire.BankAnswer exists, false otherwise
       */

        public static boolean hasBankAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBankAnswer(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.BankAnswer with a determined MultipleBankAnswer
       * @param value MultipleBankAnswer of the type org.semanticwb.questionnaire.MultipleBankAnswer
       * @param model Model of the org.semanticwb.questionnaire.BankAnswer
       * @return Iterator with all the org.semanticwb.questionnaire.BankAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankAnswer> listBankAnswerByMultipleBankAnswer(org.semanticwb.questionnaire.MultipleBankAnswer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankAnswer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_hasMultipleBankAnswer, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.BankAnswer with a determined MultipleBankAnswer
       * @param value MultipleBankAnswer of the type org.semanticwb.questionnaire.MultipleBankAnswer
       * @return Iterator with all the org.semanticwb.questionnaire.BankAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankAnswer> listBankAnswerByMultipleBankAnswer(org.semanticwb.questionnaire.MultipleBankAnswer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankAnswer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_hasMultipleBankAnswer,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static BankAnswerBase.ClassMgr getBankAnswerClassMgr()
    {
        return new BankAnswerBase.ClassMgr();
    }

   /**
   * Constructs a BankAnswerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BankAnswer
   */
    public BankAnswerBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.questionnaire.MultipleBankAnswer
   * @return A GenericIterator with all the org.semanticwb.questionnaire.MultipleBankAnswer
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.MultipleBankAnswer> listMultipleBankAnswers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.MultipleBankAnswer>(getSemanticObject().listObjectProperties(que_hasMultipleBankAnswer));
    }

   /**
   * Gets true if has a MultipleBankAnswer
   * @param value org.semanticwb.questionnaire.MultipleBankAnswer to verify
   * @return true if the org.semanticwb.questionnaire.MultipleBankAnswer exists, false otherwise
   */
    public boolean hasMultipleBankAnswer(org.semanticwb.questionnaire.MultipleBankAnswer value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(que_hasMultipleBankAnswer,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a MultipleBankAnswer
   * @param value org.semanticwb.questionnaire.MultipleBankAnswer to add
   */

    public void addMultipleBankAnswer(org.semanticwb.questionnaire.MultipleBankAnswer value)
    {
        getSemanticObject().addObjectProperty(que_hasMultipleBankAnswer, value.getSemanticObject());
    }
   /**
   * Removes all the MultipleBankAnswer
   */

    public void removeAllMultipleBankAnswer()
    {
        getSemanticObject().removeProperty(que_hasMultipleBankAnswer);
    }
   /**
   * Removes a MultipleBankAnswer
   * @param value org.semanticwb.questionnaire.MultipleBankAnswer to remove
   */

    public void removeMultipleBankAnswer(org.semanticwb.questionnaire.MultipleBankAnswer value)
    {
        getSemanticObject().removeObjectProperty(que_hasMultipleBankAnswer,value.getSemanticObject());
    }

   /**
   * Gets the MultipleBankAnswer
   * @return a org.semanticwb.questionnaire.MultipleBankAnswer
   */
    public org.semanticwb.questionnaire.MultipleBankAnswer getMultipleBankAnswer()
    {
         org.semanticwb.questionnaire.MultipleBankAnswer ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_hasMultipleBankAnswer);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.MultipleBankAnswer)obj.createGenericInstance();
         }
         return ret;
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
* Gets the TypeAnswer property
* @return String with the TypeAnswer
*/
    public String getTypeAnswer()
    {
        return getSemanticObject().getProperty(que_typeAnswer);
    }

/**
* Sets the TypeAnswer property
* @param value long with the TypeAnswer
*/
    public void setTypeAnswer(String value)
    {
        getSemanticObject().setProperty(que_typeAnswer, value);
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
