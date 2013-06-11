package org.semanticwb.questionnaire.base;


public abstract class InstanceQuestionnaireBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass que_Questionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#Questionnaire");
    public static final org.semanticwb.platform.SemanticProperty que_questionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#questionnaire");
    public static final org.semanticwb.platform.SemanticClass que_InstanceQuestionnaire=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#InstanceQuestionnaire");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#InstanceQuestionnaire");

    public static class ClassMgr
    {
       /**
       * Returns a list of InstanceQuestionnaire for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.InstanceQuestionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestionnaire> listInstanceQuestionnaires(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestionnaire>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.InstanceQuestionnaire for all models
       * @return Iterator of org.semanticwb.questionnaire.InstanceQuestionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestionnaire> listInstanceQuestionnaires()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestionnaire>(it, true);
        }

        public static org.semanticwb.questionnaire.InstanceQuestionnaire createInstanceQuestionnaire(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.InstanceQuestionnaire.ClassMgr.createInstanceQuestionnaire(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestionnaire
       * @return A org.semanticwb.questionnaire.InstanceQuestionnaire
       */
        public static org.semanticwb.questionnaire.InstanceQuestionnaire getInstanceQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.InstanceQuestionnaire)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestionnaire
       * @return A org.semanticwb.questionnaire.InstanceQuestionnaire
       */
        public static org.semanticwb.questionnaire.InstanceQuestionnaire createInstanceQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.InstanceQuestionnaire)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestionnaire
       */
        public static void removeInstanceQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param id Identifier for org.semanticwb.questionnaire.InstanceQuestionnaire
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestionnaire
       * @return true if the org.semanticwb.questionnaire.InstanceQuestionnaire exists, false otherwise
       */

        public static boolean hasInstanceQuestionnaire(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInstanceQuestionnaire(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.InstanceQuestionnaire with a determined Questionnaire
       * @param value Questionnaire of the type org.semanticwb.questionnaire.Questionnaire
       * @param model Model of the org.semanticwb.questionnaire.InstanceQuestionnaire
       * @return Iterator with all the org.semanticwb.questionnaire.InstanceQuestionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestionnaire> listInstanceQuestionnaireByQuestionnaire(org.semanticwb.questionnaire.Questionnaire value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestionnaire> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_questionnaire, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.InstanceQuestionnaire with a determined Questionnaire
       * @param value Questionnaire of the type org.semanticwb.questionnaire.Questionnaire
       * @return Iterator with all the org.semanticwb.questionnaire.InstanceQuestionnaire
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.InstanceQuestionnaire> listInstanceQuestionnaireByQuestionnaire(org.semanticwb.questionnaire.Questionnaire value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.InstanceQuestionnaire> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_questionnaire,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static InstanceQuestionnaireBase.ClassMgr getInstanceQuestionnaireClassMgr()
    {
        return new InstanceQuestionnaireBase.ClassMgr();
    }

   /**
   * Constructs a InstanceQuestionnaireBase with a SemanticObject
   * @param base The SemanticObject with the properties for the InstanceQuestionnaire
   */
    public InstanceQuestionnaireBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Questionnaire
   * @param value Questionnaire to set
   */

    public void setQuestionnaire(org.semanticwb.questionnaire.Questionnaire value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(que_questionnaire, value.getSemanticObject());
        }else
        {
            removeQuestionnaire();
        }
    }
   /**
   * Remove the value for Questionnaire property
   */

    public void removeQuestionnaire()
    {
        getSemanticObject().removeProperty(que_questionnaire);
    }

   /**
   * Gets the Questionnaire
   * @return a org.semanticwb.questionnaire.Questionnaire
   */
    public org.semanticwb.questionnaire.Questionnaire getQuestionnaire()
    {
         org.semanticwb.questionnaire.Questionnaire ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_questionnaire);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.Questionnaire)obj.createGenericInstance();
         }
         return ret;
    }
}
