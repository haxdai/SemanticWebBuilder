package org.semanticwb.questionnaire.base;


public abstract class BankUnitsSubstantiveBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty que_nameUnitSubstantive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#nameUnitSubstantive");
    public static final org.semanticwb.platform.SemanticClass que_BankUnitsSubstantive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankUnitsSubstantive");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankUnitsSubstantive");

    public static class ClassMgr
    {
       /**
       * Returns a list of BankUnitsSubstantive for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.BankUnitsSubstantive
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankUnitsSubstantive> listBankUnitsSubstantives(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankUnitsSubstantive>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.BankUnitsSubstantive for all models
       * @return Iterator of org.semanticwb.questionnaire.BankUnitsSubstantive
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankUnitsSubstantive> listBankUnitsSubstantives()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankUnitsSubstantive>(it, true);
        }

        public static org.semanticwb.questionnaire.BankUnitsSubstantive createBankUnitsSubstantive(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.BankUnitsSubstantive.ClassMgr.createBankUnitsSubstantive(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param id Identifier for org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param model Model of the org.semanticwb.questionnaire.BankUnitsSubstantive
       * @return A org.semanticwb.questionnaire.BankUnitsSubstantive
       */
        public static org.semanticwb.questionnaire.BankUnitsSubstantive getBankUnitsSubstantive(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankUnitsSubstantive)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param id Identifier for org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param model Model of the org.semanticwb.questionnaire.BankUnitsSubstantive
       * @return A org.semanticwb.questionnaire.BankUnitsSubstantive
       */
        public static org.semanticwb.questionnaire.BankUnitsSubstantive createBankUnitsSubstantive(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankUnitsSubstantive)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param id Identifier for org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param model Model of the org.semanticwb.questionnaire.BankUnitsSubstantive
       */
        public static void removeBankUnitsSubstantive(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param id Identifier for org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param model Model of the org.semanticwb.questionnaire.BankUnitsSubstantive
       * @return true if the org.semanticwb.questionnaire.BankUnitsSubstantive exists, false otherwise
       */

        public static boolean hasBankUnitsSubstantive(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBankUnitsSubstantive(id, model)!=null);
        }
    }

    public static BankUnitsSubstantiveBase.ClassMgr getBankUnitsSubstantiveClassMgr()
    {
        return new BankUnitsSubstantiveBase.ClassMgr();
    }

   /**
   * Constructs a BankUnitsSubstantiveBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BankUnitsSubstantive
   */
    public BankUnitsSubstantiveBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NameUnitSubstantive property
* @return String with the NameUnitSubstantive
*/
    public String getNameUnitSubstantive()
    {
        return getSemanticObject().getProperty(que_nameUnitSubstantive);
    }

/**
* Sets the NameUnitSubstantive property
* @param value long with the NameUnitSubstantive
*/
    public void setNameUnitSubstantive(String value)
    {
        getSemanticObject().setProperty(que_nameUnitSubstantive, value);
    }
}
