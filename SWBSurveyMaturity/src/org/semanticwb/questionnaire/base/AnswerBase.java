package org.semanticwb.questionnaire.base;


public abstract class AnswerBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty que_answers=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#answers");
    public static final org.semanticwb.platform.SemanticClass que_Answer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Answer");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Answer");

    public static class ClassMgr
    {
       /**
       * Returns a list of Answer for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.Answer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Answer> listAnswers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Answer>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.Answer for all models
       * @return Iterator of org.semanticwb.questionnaire.Answer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Answer> listAnswers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Answer>(it, true);
        }

        public static org.semanticwb.questionnaire.Answer createAnswer(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.Answer.ClassMgr.createAnswer(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.Answer
       * @param id Identifier for org.semanticwb.questionnaire.Answer
       * @param model Model of the org.semanticwb.questionnaire.Answer
       * @return A org.semanticwb.questionnaire.Answer
       */
        public static org.semanticwb.questionnaire.Answer getAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Answer)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.Answer
       * @param id Identifier for org.semanticwb.questionnaire.Answer
       * @param model Model of the org.semanticwb.questionnaire.Answer
       * @return A org.semanticwb.questionnaire.Answer
       */
        public static org.semanticwb.questionnaire.Answer createAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Answer)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.Answer
       * @param id Identifier for org.semanticwb.questionnaire.Answer
       * @param model Model of the org.semanticwb.questionnaire.Answer
       */
        public static void removeAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.Answer
       * @param id Identifier for org.semanticwb.questionnaire.Answer
       * @param model Model of the org.semanticwb.questionnaire.Answer
       * @return true if the org.semanticwb.questionnaire.Answer exists, false otherwise
       */

        public static boolean hasAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAnswer(id, model)!=null);
        }
    }

    public static AnswerBase.ClassMgr getAnswerClassMgr()
    {
        return new AnswerBase.ClassMgr();
    }

   /**
   * Constructs a AnswerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Answer
   */
    public AnswerBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Answers property
* @return String with the Answers
*/
    public String getAnswers()
    {
        return getSemanticObject().getProperty(que_answers);
    }

/**
* Sets the Answers property
* @param value long with the Answers
*/
    public void setAnswers(String value)
    {
        getSemanticObject().setProperty(que_answers, value);
    }
}
