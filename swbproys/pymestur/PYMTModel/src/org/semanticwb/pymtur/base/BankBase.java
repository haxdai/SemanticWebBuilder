package org.semanticwb.pymtur.base;


   /**
   * Clase que se encarga de administrar el catalogo de bancos 
   */
public abstract class BankBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Número de cuenta de banco, aun no se define que tipo de cuenta va ha ir aqui (si la referencia, o como tal un número de cuenta), forma parte del modulo de administración aun no definido.
   */
    public static final org.semanticwb.platform.SemanticProperty pymtur_bankAccount=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/pymestur#bankAccount");
   /**
   * Clase que se encarga de administrar el catalogo de bancos
   */
    public static final org.semanticwb.platform.SemanticClass pymtur_Bank=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Bank");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/pymestur#Bank");

    public static class ClassMgr
    {
       /**
       * Returns a list of Bank for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.pymtur.Bank
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Bank> listBanks(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Bank>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.pymtur.Bank for all models
       * @return Iterator of org.semanticwb.pymtur.Bank
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Bank> listBanks()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Bank>(it, true);
        }
       /**
       * Gets a org.semanticwb.pymtur.Bank
       * @param id Identifier for org.semanticwb.pymtur.Bank
       * @param model Model of the org.semanticwb.pymtur.Bank
       * @return A org.semanticwb.pymtur.Bank
       */
        public static org.semanticwb.pymtur.Bank getBank(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Bank)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.pymtur.Bank
       * @param id Identifier for org.semanticwb.pymtur.Bank
       * @param model Model of the org.semanticwb.pymtur.Bank
       * @return A org.semanticwb.pymtur.Bank
       */
        public static org.semanticwb.pymtur.Bank createBank(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.pymtur.Bank)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.pymtur.Bank
       * @param id Identifier for org.semanticwb.pymtur.Bank
       * @param model Model of the org.semanticwb.pymtur.Bank
       */
        public static void removeBank(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.pymtur.Bank
       * @param id Identifier for org.semanticwb.pymtur.Bank
       * @param model Model of the org.semanticwb.pymtur.Bank
       * @return true if the org.semanticwb.pymtur.Bank exists, false otherwise
       */

        public static boolean hasBank(String id, org.semanticwb.model.SWBModel model)
        {
            return (getBank(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.pymtur.Bank with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Bank
       * @return Iterator with all the org.semanticwb.pymtur.Bank
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Bank> listBankByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Bank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Bank with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Bank
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Bank> listBankByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Bank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Bank with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.pymtur.Bank
       * @return Iterator with all the org.semanticwb.pymtur.Bank
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Bank> listBankByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Bank> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.pymtur.Bank with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.pymtur.Bank
       */

        public static java.util.Iterator<org.semanticwb.pymtur.Bank> listBankByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.pymtur.Bank> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a BankBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Bank
   */
    public BankBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the BankAccount property
* @return String with the BankAccount
*/
    public String getBankAccount()
    {
        return getSemanticObject().getProperty(pymtur_bankAccount);
    }

/**
* Sets the BankAccount property
* @param value long with the BankAccount
*/
    public void setBankAccount(String value)
    {
        getSemanticObject().setProperty(pymtur_bankAccount, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
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
   * Gets the PyMesWebSite
   * @return a instance of org.semanticwb.pymtur.PyMesWebSite
   */
    public org.semanticwb.pymtur.PyMesWebSite getPyMesWebSite()
    {
        return (org.semanticwb.pymtur.PyMesWebSite)getSemanticObject().getModel().getModelObject().createGenericInstance();
    }
}
