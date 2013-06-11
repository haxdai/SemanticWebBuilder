package org.semanticwb.questionnaire.base;


public abstract class OptionAnswerBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass que_BankAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankAnswer");
    public static final org.semanticwb.platform.SemanticProperty que_hasAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#hasAnswer");
    public static final org.semanticwb.platform.SemanticClass que_OptionAnswer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#OptionAnswer");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#OptionAnswer");

    public static class ClassMgr
    {
       /**
       * Returns a list of OptionAnswer for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.OptionAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionAnswer> listOptionAnswers(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionAnswer>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.OptionAnswer for all models
       * @return Iterator of org.semanticwb.questionnaire.OptionAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionAnswer> listOptionAnswers()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionAnswer>(it, true);
        }

        public static org.semanticwb.questionnaire.OptionAnswer createOptionAnswer(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.OptionAnswer.ClassMgr.createOptionAnswer(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.OptionAnswer
       * @param id Identifier for org.semanticwb.questionnaire.OptionAnswer
       * @param model Model of the org.semanticwb.questionnaire.OptionAnswer
       * @return A org.semanticwb.questionnaire.OptionAnswer
       */
        public static org.semanticwb.questionnaire.OptionAnswer getOptionAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.OptionAnswer)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.OptionAnswer
       * @param id Identifier for org.semanticwb.questionnaire.OptionAnswer
       * @param model Model of the org.semanticwb.questionnaire.OptionAnswer
       * @return A org.semanticwb.questionnaire.OptionAnswer
       */
        public static org.semanticwb.questionnaire.OptionAnswer createOptionAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.OptionAnswer)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.OptionAnswer
       * @param id Identifier for org.semanticwb.questionnaire.OptionAnswer
       * @param model Model of the org.semanticwb.questionnaire.OptionAnswer
       */
        public static void removeOptionAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.OptionAnswer
       * @param id Identifier for org.semanticwb.questionnaire.OptionAnswer
       * @param model Model of the org.semanticwb.questionnaire.OptionAnswer
       * @return true if the org.semanticwb.questionnaire.OptionAnswer exists, false otherwise
       */

        public static boolean hasOptionAnswer(String id, org.semanticwb.model.SWBModel model)
        {
            return (getOptionAnswer(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.OptionAnswer with a determined Answer
       * @param value Answer of the type org.semanticwb.questionnaire.BankAnswer
       * @param model Model of the org.semanticwb.questionnaire.OptionAnswer
       * @return Iterator with all the org.semanticwb.questionnaire.OptionAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionAnswer> listOptionAnswerByAnswer(org.semanticwb.questionnaire.BankAnswer value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionAnswer> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_hasAnswer, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.OptionAnswer with a determined Answer
       * @param value Answer of the type org.semanticwb.questionnaire.BankAnswer
       * @return Iterator with all the org.semanticwb.questionnaire.OptionAnswer
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionAnswer> listOptionAnswerByAnswer(org.semanticwb.questionnaire.BankAnswer value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionAnswer> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_hasAnswer,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static OptionAnswerBase.ClassMgr getOptionAnswerClassMgr()
    {
        return new OptionAnswerBase.ClassMgr();
    }

   /**
   * Constructs a OptionAnswerBase with a SemanticObject
   * @param base The SemanticObject with the properties for the OptionAnswer
   */
    public OptionAnswerBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.questionnaire.BankAnswer
   * @return A GenericIterator with all the org.semanticwb.questionnaire.BankAnswer
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankAnswer> listAnswers()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankAnswer>(getSemanticObject().listObjectProperties(que_hasAnswer));
    }

   /**
   * Gets true if has a Answer
   * @param value org.semanticwb.questionnaire.BankAnswer to verify
   * @return true if the org.semanticwb.questionnaire.BankAnswer exists, false otherwise
   */
    public boolean hasAnswer(org.semanticwb.questionnaire.BankAnswer value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(que_hasAnswer,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Answer
   * @param value org.semanticwb.questionnaire.BankAnswer to add
   */

    public void addAnswer(org.semanticwb.questionnaire.BankAnswer value)
    {
        getSemanticObject().addObjectProperty(que_hasAnswer, value.getSemanticObject());
    }
   /**
   * Removes all the Answer
   */

    public void removeAllAnswer()
    {
        getSemanticObject().removeProperty(que_hasAnswer);
    }
   /**
   * Removes a Answer
   * @param value org.semanticwb.questionnaire.BankAnswer to remove
   */

    public void removeAnswer(org.semanticwb.questionnaire.BankAnswer value)
    {
        getSemanticObject().removeObjectProperty(que_hasAnswer,value.getSemanticObject());
    }

   /**
   * Gets the Answer
   * @return a org.semanticwb.questionnaire.BankAnswer
   */
    public org.semanticwb.questionnaire.BankAnswer getAnswer()
    {
         org.semanticwb.questionnaire.BankAnswer ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_hasAnswer);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.BankAnswer)obj.createGenericInstance();
         }
         return ret;
    }
}
