package org.semanticwb.questionnaire.base;


public abstract class OptionQuestionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass que_BankSubQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankSubQuestion");
    public static final org.semanticwb.platform.SemanticProperty que_hasSubquestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#hasSubquestion");
    public static final org.semanticwb.platform.SemanticClass que_OptionQuestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#OptionQuestion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#OptionQuestion");

    public static class ClassMgr
    {
       /**
       * Returns a list of OptionQuestion for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.OptionQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionQuestion> listOptionQuestions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionQuestion>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.OptionQuestion for all models
       * @return Iterator of org.semanticwb.questionnaire.OptionQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionQuestion> listOptionQuestions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionQuestion>(it, true);
        }

        public static org.semanticwb.questionnaire.OptionQuestion createOptionQuestion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.OptionQuestion.ClassMgr.createOptionQuestion(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.OptionQuestion
       * @param id Identifier for org.semanticwb.questionnaire.OptionQuestion
       * @param model Model of the org.semanticwb.questionnaire.OptionQuestion
       * @return A org.semanticwb.questionnaire.OptionQuestion
       */
        public static org.semanticwb.questionnaire.OptionQuestion getOptionQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.OptionQuestion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.OptionQuestion
       * @param id Identifier for org.semanticwb.questionnaire.OptionQuestion
       * @param model Model of the org.semanticwb.questionnaire.OptionQuestion
       * @return A org.semanticwb.questionnaire.OptionQuestion
       */
        public static org.semanticwb.questionnaire.OptionQuestion createOptionQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.OptionQuestion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.OptionQuestion
       * @param id Identifier for org.semanticwb.questionnaire.OptionQuestion
       * @param model Model of the org.semanticwb.questionnaire.OptionQuestion
       */
        public static void removeOptionQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.OptionQuestion
       * @param id Identifier for org.semanticwb.questionnaire.OptionQuestion
       * @param model Model of the org.semanticwb.questionnaire.OptionQuestion
       * @return true if the org.semanticwb.questionnaire.OptionQuestion exists, false otherwise
       */

        public static boolean hasOptionQuestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getOptionQuestion(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.OptionQuestion with a determined Subquestion
       * @param value Subquestion of the type org.semanticwb.questionnaire.BankSubQuestion
       * @param model Model of the org.semanticwb.questionnaire.OptionQuestion
       * @return Iterator with all the org.semanticwb.questionnaire.OptionQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionQuestion> listOptionQuestionBySubquestion(org.semanticwb.questionnaire.BankSubQuestion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionQuestion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_hasSubquestion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.OptionQuestion with a determined Subquestion
       * @param value Subquestion of the type org.semanticwb.questionnaire.BankSubQuestion
       * @return Iterator with all the org.semanticwb.questionnaire.OptionQuestion
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.OptionQuestion> listOptionQuestionBySubquestion(org.semanticwb.questionnaire.BankSubQuestion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.OptionQuestion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_hasSubquestion,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static OptionQuestionBase.ClassMgr getOptionQuestionClassMgr()
    {
        return new OptionQuestionBase.ClassMgr();
    }

   /**
   * Constructs a OptionQuestionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the OptionQuestion
   */
    public OptionQuestionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.questionnaire.BankSubQuestion
   * @return A GenericIterator with all the org.semanticwb.questionnaire.BankSubQuestion
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankSubQuestion> listSubquestions()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankSubQuestion>(getSemanticObject().listObjectProperties(que_hasSubquestion));
    }

   /**
   * Gets true if has a Subquestion
   * @param value org.semanticwb.questionnaire.BankSubQuestion to verify
   * @return true if the org.semanticwb.questionnaire.BankSubQuestion exists, false otherwise
   */
    public boolean hasSubquestion(org.semanticwb.questionnaire.BankSubQuestion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(que_hasSubquestion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Subquestion
   * @param value org.semanticwb.questionnaire.BankSubQuestion to add
   */

    public void addSubquestion(org.semanticwb.questionnaire.BankSubQuestion value)
    {
        getSemanticObject().addObjectProperty(que_hasSubquestion, value.getSemanticObject());
    }
   /**
   * Removes all the Subquestion
   */

    public void removeAllSubquestion()
    {
        getSemanticObject().removeProperty(que_hasSubquestion);
    }
   /**
   * Removes a Subquestion
   * @param value org.semanticwb.questionnaire.BankSubQuestion to remove
   */

    public void removeSubquestion(org.semanticwb.questionnaire.BankSubQuestion value)
    {
        getSemanticObject().removeObjectProperty(que_hasSubquestion,value.getSemanticObject());
    }

   /**
   * Gets the Subquestion
   * @return a org.semanticwb.questionnaire.BankSubQuestion
   */
    public org.semanticwb.questionnaire.BankSubQuestion getSubquestion()
    {
         org.semanticwb.questionnaire.BankSubQuestion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_hasSubquestion);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.BankSubQuestion)obj.createGenericInstance();
         }
         return ret;
    }
}
