package org.semanticwb.questionnaire.base;


public abstract class QuestionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass que_Section=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Section");
    public static final org.semanticwb.platform.SemanticProperty que_optionSection=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#optionSection");
    public static final org.semanticwb.platform.SemanticClass que_OptionAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#OptionAnswer");
    public static final org.semanticwb.platform.SemanticProperty que_optionsAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#optionsAnswer");
    public static final org.semanticwb.platform.SemanticClass que_Part=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Part");
    public static final org.semanticwb.platform.SemanticProperty que_optionPart=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#optionPart");
    public static final org.semanticwb.platform.SemanticClass que_BankQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankQuestion");
    public static final org.semanticwb.platform.SemanticProperty que_questionBank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#questionBank");
    public static final org.semanticwb.platform.SemanticClass que_OptionQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#OptionQuestion");
    public static final org.semanticwb.platform.SemanticProperty que_optionsQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#optionsQuestion");
    public static final org.semanticwb.platform.SemanticClass que_Question=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Question");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Question");

    public static class ClassMgr
    {
       /**
       * Returns a list of Question for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.Question for all models
       * @return Iterator of org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question>(it, true);
        }

        public static org.semanticwb.questionnaire.Question createQuestion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.Question.ClassMgr.createQuestion(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.Question
       * @param id Identifier for org.semanticwb.questionnaire.Question
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return A org.semanticwb.questionnaire.Question
       */
        public static org.semanticwb.questionnaire.Question getQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Question)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.Question
       * @param id Identifier for org.semanticwb.questionnaire.Question
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return A org.semanticwb.questionnaire.Question
       */
        public static org.semanticwb.questionnaire.Question createQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Question)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.Question
       * @param id Identifier for org.semanticwb.questionnaire.Question
       * @param model Model of the org.semanticwb.questionnaire.Question
       */
        public static void removeQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.Question
       * @param id Identifier for org.semanticwb.questionnaire.Question
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return true if the org.semanticwb.questionnaire.Question exists, false otherwise
       */

        public static boolean hasQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getQuestion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionSection
       * @param value OptionSection of the type org.semanticwb.questionnaire.Section
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionSection(org.semanticwb.questionnaire.Section value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_optionSection, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionSection
       * @param value OptionSection of the type org.semanticwb.questionnaire.Section
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionSection(org.semanticwb.questionnaire.Section value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_optionSection,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionsAnswer
       * @param value OptionsAnswer of the type org.semanticwb.questionnaire.OptionAnswer
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionsAnswer(org.semanticwb.questionnaire.OptionAnswer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_optionsAnswer, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionsAnswer
       * @param value OptionsAnswer of the type org.semanticwb.questionnaire.OptionAnswer
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionsAnswer(org.semanticwb.questionnaire.OptionAnswer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_optionsAnswer,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionPart
       * @param value OptionPart of the type org.semanticwb.questionnaire.Part
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionPart(org.semanticwb.questionnaire.Part value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_optionPart, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionPart
       * @param value OptionPart of the type org.semanticwb.questionnaire.Part
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionPart(org.semanticwb.questionnaire.Part value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_optionPart,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined QuestionBank
       * @param value QuestionBank of the type org.semanticwb.questionnaire.BankQuestion
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByQuestionBank(org.semanticwb.questionnaire.BankQuestion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_questionBank, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined QuestionBank
       * @param value QuestionBank of the type org.semanticwb.questionnaire.BankQuestion
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByQuestionBank(org.semanticwb.questionnaire.BankQuestion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_questionBank,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionsQuestion
       * @param value OptionsQuestion of the type org.semanticwb.questionnaire.OptionQuestion
       * @param model Model of the org.semanticwb.questionnaire.Question
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionsQuestion(org.semanticwb.questionnaire.OptionQuestion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_optionsQuestion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Question with a determined OptionsQuestion
       * @param value OptionsQuestion of the type org.semanticwb.questionnaire.OptionQuestion
       * @return Iterator with all the org.semanticwb.questionnaire.Question
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Question> listQuestionByOptionsQuestion(org.semanticwb.questionnaire.OptionQuestion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Question> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_optionsQuestion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static QuestionBase.ClassMgr getQuestionClassMgr()
    {
        return new QuestionBase.ClassMgr();
    }

   /**
   * Constructs a QuestionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Question
   */
    public QuestionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property OptionSection
   * @param value OptionSection to set
   */

    public void setOptionSection(org.semanticwb.questionnaire.Section value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_optionSection, value.getSemanticObject());
        }else
        {
            removeOptionSection();
        }
    }
   /**
   * Remove the value for OptionSection property
   */

    public void removeOptionSection()
    {
        getSemanticObject().removeProperty(que_optionSection);
    }

   /**
   * Gets the OptionSection
   * @return a org.semanticwb.questionnaire.Section
   */
    public org.semanticwb.questionnaire.Section getOptionSection()
    {
         org.semanticwb.questionnaire.Section ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_optionSection);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.Section)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property OptionsAnswer
   * @param value OptionsAnswer to set
   */

    public void setOptionsAnswer(org.semanticwb.questionnaire.OptionAnswer value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_optionsAnswer, value.getSemanticObject());
        }else
        {
            removeOptionsAnswer();
        }
    }
   /**
   * Remove the value for OptionsAnswer property
   */

    public void removeOptionsAnswer()
    {
        getSemanticObject().removeProperty(que_optionsAnswer);
    }

   /**
   * Gets the OptionsAnswer
   * @return a org.semanticwb.questionnaire.OptionAnswer
   */
    public org.semanticwb.questionnaire.OptionAnswer getOptionsAnswer()
    {
         org.semanticwb.questionnaire.OptionAnswer ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_optionsAnswer);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.OptionAnswer)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property OptionPart
   * @param value OptionPart to set
   */

    public void setOptionPart(org.semanticwb.questionnaire.Part value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_optionPart, value.getSemanticObject());
        }else
        {
            removeOptionPart();
        }
    }
   /**
   * Remove the value for OptionPart property
   */

    public void removeOptionPart()
    {
        getSemanticObject().removeProperty(que_optionPart);
    }

   /**
   * Gets the OptionPart
   * @return a org.semanticwb.questionnaire.Part
   */
    public org.semanticwb.questionnaire.Part getOptionPart()
    {
         org.semanticwb.questionnaire.Part ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_optionPart);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.Part)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property QuestionBank
   * @param value QuestionBank to set
   */

    public void setQuestionBank(org.semanticwb.questionnaire.BankQuestion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_questionBank, value.getSemanticObject());
        }else
        {
            removeQuestionBank();
        }
    }
   /**
   * Remove the value for QuestionBank property
   */

    public void removeQuestionBank()
    {
        getSemanticObject().removeProperty(que_questionBank);
    }

   /**
   * Gets the QuestionBank
   * @return a org.semanticwb.questionnaire.BankQuestion
   */
    public org.semanticwb.questionnaire.BankQuestion getQuestionBank()
    {
         org.semanticwb.questionnaire.BankQuestion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_questionBank);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.BankQuestion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property OptionsQuestion
   * @param value OptionsQuestion to set
   */

    public void setOptionsQuestion(org.semanticwb.questionnaire.OptionQuestion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_optionsQuestion, value.getSemanticObject());
        }else
        {
            removeOptionsQuestion();
        }
    }
   /**
   * Remove the value for OptionsQuestion property
   */

    public void removeOptionsQuestion()
    {
        getSemanticObject().removeProperty(que_optionsQuestion);
    }

   /**
   * Gets the OptionsQuestion
   * @return a org.semanticwb.questionnaire.OptionQuestion
   */
    public org.semanticwb.questionnaire.OptionQuestion getOptionsQuestion()
    {
         org.semanticwb.questionnaire.OptionQuestion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_optionsQuestion);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.OptionQuestion)obj.createGenericInstance();
         }
         return ret;
    }
}
