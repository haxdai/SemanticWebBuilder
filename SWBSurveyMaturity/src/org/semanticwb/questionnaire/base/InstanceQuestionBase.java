package org.semanticwb.questionnaire.base;


public abstract class InstanceQuestionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass que_InstanceQuestionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#InstanceQuestionnaire");
    public static final org.semanticwb.platform.SemanticProperty que_instanceQuestionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#instanceQuestionnaire");
    public static final org.semanticwb.platform.SemanticClass que_Answer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Answer");
    public static final org.semanticwb.platform.SemanticProperty que_answerInstanceQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#answerInstanceQuestion");
    public static final org.semanticwb.platform.SemanticClass que_InstanceQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#InstanceQuestion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#InstanceQuestion");

    public static class ClassMgr
    {
       /**
       * Returns a list of InstanceQuestion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.InstanceQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestion> listInstanceQuestions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.InstanceQuestion for all models
       * @return Iterator of org.semanticwb.questionnaire.InstanceQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestion> listInstanceQuestions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestion>(it, true);
        }

        public static org.semanticwb.questionnaire.InstanceQuestion createInstanceQuestion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.InstanceQuestion.ClassMgr.createInstanceQuestion(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.InstanceQuestion
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestion
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestion
       * @return A org.semanticwb.questionnaire.InstanceQuestion
       */
        public static org.semanticwb.questionnaire.InstanceQuestion getInstanceQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.InstanceQuestion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.InstanceQuestion
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestion
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestion
       * @return A org.semanticwb.questionnaire.InstanceQuestion
       */
        public static org.semanticwb.questionnaire.InstanceQuestion createInstanceQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.InstanceQuestion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.InstanceQuestion
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestion
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestion
       */
        public static void removeInstanceQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.InstanceQuestion
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestion
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestion
       * @return true if the org.semanticwb.questionnaire.InstanceQuestion exists, false otherwise
       */

        public static boolean hasInstanceQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInstanceQuestion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.InstanceQuestion with a determined InstanceQuestionnaire
       * @param value InstanceQuestionnaire of the type org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestion
       * @return Iterator with all the org.semanticwb.questionnaire.InstanceQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestion> listInstanceQuestionByInstanceQuestionnaire(org.semanticwb.questionnaire.InstanceQuestionnaire value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_instanceQuestionnaire, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.InstanceQuestion with a determined InstanceQuestionnaire
       * @param value InstanceQuestionnaire of the type org.semanticwb.questionnaire.InstanceQuestionnaire
       * @return Iterator with all the org.semanticwb.questionnaire.InstanceQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestion> listInstanceQuestionByInstanceQuestionnaire(org.semanticwb.questionnaire.InstanceQuestionnaire value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_instanceQuestionnaire,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.InstanceQuestion with a determined AnswerInstanceQuestion
       * @param value AnswerInstanceQuestion of the type org.semanticwb.questionnaire.Answer
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestion
       * @return Iterator with all the org.semanticwb.questionnaire.InstanceQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestion> listInstanceQuestionByAnswerInstanceQuestion(org.semanticwb.questionnaire.Answer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_answerInstanceQuestion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.InstanceQuestion with a determined AnswerInstanceQuestion
       * @param value AnswerInstanceQuestion of the type org.semanticwb.questionnaire.Answer
       * @return Iterator with all the org.semanticwb.questionnaire.InstanceQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestion> listInstanceQuestionByAnswerInstanceQuestion(org.semanticwb.questionnaire.Answer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_answerInstanceQuestion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static InstanceQuestionBase.ClassMgr getInstanceQuestionClassMgr()
    {
        return new InstanceQuestionBase.ClassMgr();
    }

   /**
   * Constructs a InstanceQuestionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the InstanceQuestion
   */
    public InstanceQuestionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property InstanceQuestionnaire
   * @param value InstanceQuestionnaire to set
   */

    public void setInstanceQuestionnaire(org.semanticwb.questionnaire.InstanceQuestionnaire value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_instanceQuestionnaire, value.getSemanticObject());
        }else
        {
            removeInstanceQuestionnaire();
        }
    }
   /**
   * Remove the value for InstanceQuestionnaire property
   */

    public void removeInstanceQuestionnaire()
    {
        getSemanticObject().removeProperty(que_instanceQuestionnaire);
    }

   /**
   * Gets the InstanceQuestionnaire
   * @return a org.semanticwb.questionnaire.InstanceQuestionnaire
   */
    public org.semanticwb.questionnaire.InstanceQuestionnaire getInstanceQuestionnaire()
    {
         org.semanticwb.questionnaire.InstanceQuestionnaire ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_instanceQuestionnaire);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.InstanceQuestionnaire)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property AnswerInstanceQuestion
   * @param value AnswerInstanceQuestion to set
   */

    public void setAnswerInstanceQuestion(org.semanticwb.questionnaire.Answer value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_answerInstanceQuestion, value.getSemanticObject());
        }else
        {
            removeAnswerInstanceQuestion();
        }
    }
   /**
   * Remove the value for AnswerInstanceQuestion property
   */

    public void removeAnswerInstanceQuestion()
    {
        getSemanticObject().removeProperty(que_answerInstanceQuestion);
    }

   /**
   * Gets the AnswerInstanceQuestion
   * @return a org.semanticwb.questionnaire.Answer
   */
    public org.semanticwb.questionnaire.Answer getAnswerInstanceQuestion()
    {
         org.semanticwb.questionnaire.Answer ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_answerInstanceQuestion);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.Answer)obj.createGenericInstance();
         }
         return ret;
    }
}
