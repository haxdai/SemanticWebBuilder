package org.semanticwb.questionnaire.base;


public abstract class BankInstitutionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty que_sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#sector");
    public static final org.semanticwb.platform.SemanticProperty que_nameInstitution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#nameInstitution");
    public static final org.semanticwb.platform.SemanticProperty que_state=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#state");
    public static final org.semanticwb.platform.SemanticProperty que_acronym=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#acronym");
    public static final org.semanticwb.platform.SemanticProperty que_address=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#address");
    public static final org.semanticwb.platform.SemanticClass que_BankUnitsSubstantive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankUnitsSubstantive");
    public static final org.semanticwb.platform.SemanticProperty que_hasUnitsSubstantive=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://org.semanticwb.resources/Questionnaire#hasUnitsSubstantive");
    public static final org.semanticwb.platform.SemanticClass que_BankInstitution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankInstitution");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://org.semanticwb.resources/Questionnaire#BankInstitution");

    public static class ClassMgr
    {
       /**
       * Returns a list of BankInstitution for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.questionnaire.BankInstitution
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankInstitution> listBankInstitutions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankInstitution>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.questionnaire.BankInstitution for all models
       * @return Iterator of org.semanticwb.questionnaire.BankInstitution
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankInstitution> listBankInstitutions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankInstitution>(it, true);
        }

        public static org.semanticwb.questionnaire.BankInstitution createBankInstitution(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return org.semanticwb.questionnaire.BankInstitution.ClassMgr.createBankInstitution(String.valueOf(id), model);
        }
       /**
       * Gets a org.semanticwb.questionnaire.BankInstitution
       * @param id Identifier for org.semanticwb.questionnaire.BankInstitution
       * @param model Model of the org.semanticwb.questionnaire.BankInstitution
       * @return A org.semanticwb.questionnaire.BankInstitution
       */
        public static org.semanticwb.questionnaire.BankInstitution getBankInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankInstitution)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.questionnaire.BankInstitution
       * @param id Identifier for org.semanticwb.questionnaire.BankInstitution
       * @param model Model of the org.semanticwb.questionnaire.BankInstitution
       * @return A org.semanticwb.questionnaire.BankInstitution
       */
        public static org.semanticwb.questionnaire.BankInstitution createBankInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.questionnaire.BankInstitution)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.questionnaire.BankInstitution
       * @param id Identifier for org.semanticwb.questionnaire.BankInstitution
       * @param model Model of the org.semanticwb.questionnaire.BankInstitution
       */
        public static void removeBankInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.questionnaire.BankInstitution
       * @param id Identifier for org.semanticwb.questionnaire.BankInstitution
       * @param model Model of the org.semanticwb.questionnaire.BankInstitution
       * @return true if the org.semanticwb.questionnaire.BankInstitution exists, false otherwise
       */

        public static boolean hasBankInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBankInstitution(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.questionnaire.BankInstitution with a determined UnitsSubstantive
       * @param value UnitsSubstantive of the type org.semanticwb.questionnaire.BankUnitsSubstantive
       * @param model Model of the org.semanticwb.questionnaire.BankInstitution
       * @return Iterator with all the org.semanticwb.questionnaire.BankInstitution
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankInstitution> listBankInstitutionByUnitsSubstantive(org.semanticwb.questionnaire.BankUnitsSubstantive value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankInstitution> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(que_hasUnitsSubstantive, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.questionnaire.BankInstitution with a determined UnitsSubstantive
       * @param value UnitsSubstantive of the type org.semanticwb.questionnaire.BankUnitsSubstantive
       * @return Iterator with all the org.semanticwb.questionnaire.BankInstitution
       */

        public static java.util.Iterator<org.semanticwb.questionnaire.BankInstitution> listBankInstitutionByUnitsSubstantive(org.semanticwb.questionnaire.BankUnitsSubstantive value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankInstitution> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(que_hasUnitsSubstantive,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static BankInstitutionBase.ClassMgr getBankInstitutionClassMgr()
    {
        return new BankInstitutionBase.ClassMgr();
    }

   /**
   * Constructs a BankInstitutionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the BankInstitution
   */
    public BankInstitutionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Sector property
* @return String with the Sector
*/
    public String getSector()
    {
        return getSemanticObject().getProperty(que_sector);
    }

/**
* Sets the Sector property
* @param value long with the Sector
*/
    public void setSector(String value)
    {
        getSemanticObject().setProperty(que_sector, value);
    }

/**
* Gets the NameInstitution property
* @return String with the NameInstitution
*/
    public String getNameInstitution()
    {
        return getSemanticObject().getProperty(que_nameInstitution);
    }

/**
* Sets the NameInstitution property
* @param value long with the NameInstitution
*/
    public void setNameInstitution(String value)
    {
        getSemanticObject().setProperty(que_nameInstitution, value);
    }

/**
* Gets the State property
* @return String with the State
*/
    public String getState()
    {
        return getSemanticObject().getProperty(que_state);
    }

/**
* Sets the State property
* @param value long with the State
*/
    public void setState(String value)
    {
        getSemanticObject().setProperty(que_state, value);
    }

/**
* Gets the Acronym property
* @return String with the Acronym
*/
    public String getAcronym()
    {
        return getSemanticObject().getProperty(que_acronym);
    }

/**
* Sets the Acronym property
* @param value long with the Acronym
*/
    public void setAcronym(String value)
    {
        getSemanticObject().setProperty(que_acronym, value);
    }

/**
* Gets the Address property
* @return String with the Address
*/
    public String getAddress()
    {
        return getSemanticObject().getProperty(que_address);
    }

/**
* Sets the Address property
* @param value long with the Address
*/
    public void setAddress(String value)
    {
        getSemanticObject().setProperty(que_address, value);
    }
   /**
   * Gets all the org.semanticwb.questionnaire.BankUnitsSubstantive
   * @return A GenericIterator with all the org.semanticwb.questionnaire.BankUnitsSubstantive
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankUnitsSubstantive> listUnitsSubstantives()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.questionnaire.BankUnitsSubstantive>(getSemanticObject().listObjectProperties(que_hasUnitsSubstantive));
    }

   /**
   * Gets true if has a UnitsSubstantive
   * @param value org.semanticwb.questionnaire.BankUnitsSubstantive to verify
   * @return true if the org.semanticwb.questionnaire.BankUnitsSubstantive exists, false otherwise
   */
    public boolean hasUnitsSubstantive(org.semanticwb.questionnaire.BankUnitsSubstantive value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(que_hasUnitsSubstantive,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a UnitsSubstantive
   * @param value org.semanticwb.questionnaire.BankUnitsSubstantive to add
   */

    public void addUnitsSubstantive(org.semanticwb.questionnaire.BankUnitsSubstantive value)
    {
        getSemanticObject().addObjectProperty(que_hasUnitsSubstantive, value.getSemanticObject());
    }
   /**
   * Removes all the UnitsSubstantive
   */

    public void removeAllUnitsSubstantive()
    {
        getSemanticObject().removeProperty(que_hasUnitsSubstantive);
    }
   /**
   * Removes a UnitsSubstantive
   * @param value org.semanticwb.questionnaire.BankUnitsSubstantive to remove
   */

    public void removeUnitsSubstantive(org.semanticwb.questionnaire.BankUnitsSubstantive value)
    {
        getSemanticObject().removeObjectProperty(que_hasUnitsSubstantive,value.getSemanticObject());
    }

   /**
   * Gets the UnitsSubstantive
   * @return a org.semanticwb.questionnaire.BankUnitsSubstantive
   */
    public org.semanticwb.questionnaire.BankUnitsSubstantive getUnitsSubstantive()
    {
         org.semanticwb.questionnaire.BankUnitsSubstantive ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(que_hasUnitsSubstantive);
         if(obj!=null)
         {
             ret=(org.semanticwb.questionnaire.BankUnitsSubstantive)obj.createGenericInstance();
         }
         return ret;
    }
}
