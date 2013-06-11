package org.semanticwb.questionnaire.base;


public abstract class QuestionnaireBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty que_instructions=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#instructions");
    public static final org.semanticwb.platform.SemanticClass que_Titular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Titular");
    public static final org.semanticwb.platform.SemanticProperty que_titular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#titular");
    public static final org.semanticwb.platform.SemanticProperty que_image=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#image");
    public static final org.semanticwb.platform.SemanticProperty que_presentation=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#presentation");
    public static final org.semanticwb.platform.SemanticProperty que_title=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#title");
    public static final org.semanticwb.platform.SemanticClass que_Question=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Question");
    public static final org.semanticwb.platform.SemanticProperty que_question=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#question");
    public static final org.semanticwb.platform.SemanticClass que_BankInstitution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankInstitution");
    public static final org.semanticwb.platform.SemanticProperty que_institution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#institution");
    public static final org.semanticwb.platform.SemanticClass que_Questionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Questionnaire");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Questionnaire");

    public static class ClassMgr
    {
       /**
       * Returns a list of Questionnaire for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaires(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.Questionnaire for all models
       * @return Iterator of org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaires()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire>(it, true);
        }

        public static org.semanticwb.questionnaire.Questionnaire createQuestionnaire(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.Questionnaire.ClassMgr.createQuestionnaire(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.Questionnaire
       * @param id Identifier for org.semanticwb.questionnaire.Questionnaire
       * @param model Model of the org.semanticwb.questionnaire.Questionnaire
       * @return A org.semanticwb.questionnaire.Questionnaire
       */
        public static org.semanticwb.questionnaire.Questionnaire getQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Questionnaire)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.Questionnaire
       * @param id Identifier for org.semanticwb.questionnaire.Questionnaire
       * @param model Model of the org.semanticwb.questionnaire.Questionnaire
       * @return A org.semanticwb.questionnaire.Questionnaire
       */
        public static org.semanticwb.questionnaire.Questionnaire createQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.Questionnaire)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.Questionnaire
       * @param id Identifier for org.semanticwb.questionnaire.Questionnaire
       * @param model Model of the org.semanticwb.questionnaire.Questionnaire
       */
        public static void removeQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.Questionnaire
       * @param id Identifier for org.semanticwb.questionnaire.Questionnaire
       * @param model Model of the org.semanticwb.questionnaire.Questionnaire
       * @return true if the org.semanticwb.questionnaire.Questionnaire exists, false otherwise
       */

        public static boolean hasQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            return (getQuestionnaire(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.Questionnaire with a determined Titular
       * @param value Titular of the type org.semanticwb.questionnaire.Titular
       * @param model Model of the org.semanticwb.questionnaire.Questionnaire
       * @return Iterator with all the org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaireByTitular(org.semanticwb.questionnaire.Titular value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_titular, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Questionnaire with a determined Titular
       * @param value Titular of the type org.semanticwb.questionnaire.Titular
       * @return Iterator with all the org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaireByTitular(org.semanticwb.questionnaire.Titular value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_titular,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Questionnaire with a determined Question
       * @param value Question of the type org.semanticwb.questionnaire.Question
       * @param model Model of the org.semanticwb.questionnaire.Questionnaire
       * @return Iterator with all the org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaireByQuestion(org.semanticwb.questionnaire.Question value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_question, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Questionnaire with a determined Question
       * @param value Question of the type org.semanticwb.questionnaire.Question
       * @return Iterator with all the org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaireByQuestion(org.semanticwb.questionnaire.Question value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_question,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Questionnaire with a determined Institution
       * @param value Institution of the type org.semanticwb.questionnaire.BankInstitution
       * @param model Model of the org.semanticwb.questionnaire.Questionnaire
       * @return Iterator with all the org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaireByInstitution(org.semanticwb.questionnaire.BankInstitution value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_institution, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.Questionnaire with a determined Institution
       * @param value Institution of the type org.semanticwb.questionnaire.BankInstitution
       * @return Iterator with all the org.semanticwb.questionnaire.Questionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.Questionnaire> listQuestionnaireByInstitution(org.semanticwb.questionnaire.BankInstitution value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.Questionnaire> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_institution,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static QuestionnaireBase.ClassMgr getQuestionnaireClassMgr()
    {
        return new QuestionnaireBase.ClassMgr();
    }

   /**
   * Constructs a QuestionnaireBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Questionnaire
   */
    public QuestionnaireBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Instructions property
* @return String with the Instructions
*/
    public String getInstructions()
    {
        return getSemanticObject().getProperty(que_instructions);
    }

/**
* Sets the Instructions property
* @param value long with the Instructions
*/
    public void setInstructions(String value)
    {
        getSemanticObject().setProperty(que_instructions, value);
    }
   /**
   * Sets the value for the property Titular
   * @param value Titular to set
   */

    public void setTitular(org.semanticwb.questionnaire.Titular value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_titular, value.getSemanticObject());
        }else
        {
            removeTitular();
        }
    }
   /**
   * Remove the value for Titular property
   */

    public void removeTitular()
    {
        getSemanticObject().removeProperty(que_titular);
    }

   /**
   * Gets the Titular
   * @return a org.semanticwb.questionnaire.Titular
   */
    public org.semanticwb.questionnaire.Titular getTitular()
    {
         org.semanticwb.questionnaire.Titular ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_titular);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.Titular)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Image property
* @return String with the Image
*/
    public String getImage()
    {
        return getSemanticObject().getProperty(que_image);
    }

/**
* Sets the Image property
* @param value long with the Image
*/
    public void setImage(String value)
    {
        getSemanticObject().setProperty(que_image, value);
    }

/**
* Gets the Presentation property
* @return String with the Presentation
*/
    public String getPresentation()
    {
        return getSemanticObject().getProperty(que_presentation);
    }

/**
* Sets the Presentation property
* @param value long with the Presentation
*/
    public void setPresentation(String value)
    {
        getSemanticObject().setProperty(que_presentation, value);
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(que_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(que_title, value);
    }
   /**
   * Sets the value for the property Question
   * @param value Question to set
   */

    public void setQuestion(org.semanticwb.questionnaire.Question value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_question, value.getSemanticObject());
        }else
        {
            removeQuestion();
        }
    }
   /**
   * Remove the value for Question property
   */

    public void removeQuestion()
    {
        getSemanticObject().removeProperty(que_question);
    }

   /**
   * Gets the Question
   * @return a org.semanticwb.questionnaire.Question
   */
    public org.semanticwb.questionnaire.Question getQuestion()
    {
         org.semanticwb.questionnaire.Question ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_question);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.Question)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Institution
   * @param value Institution to set
   */

    public void setInstitution(org.semanticwb.questionnaire.BankInstitution value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_institution, value.getSemanticObject());
        }else
        {
            removeInstitution();
        }
    }
   /**
   * Remove the value for Institution property
   */

    public void removeInstitution()
    {
        getSemanticObject().removeProperty(que_institution);
    }

   /**
   * Gets the Institution
   * @return a org.semanticwb.questionnaire.BankInstitution
   */
    public org.semanticwb.questionnaire.BankInstitution getInstitution()
    {
         org.semanticwb.questionnaire.BankInstitution ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_institution);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.BankInstitution)obj.createGenericInstance();
         }
         return ret;
    }
}
