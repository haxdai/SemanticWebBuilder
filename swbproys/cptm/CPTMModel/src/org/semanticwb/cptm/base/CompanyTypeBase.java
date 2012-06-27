package org.semanticwb.cptm.base;


public abstract class CompanyTypeBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Interface para datos generales de Cadenas, Marcas y Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeneralCompany=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeneralCompany");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompanyTypeInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompanyTypeInv");
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyType");

    public static class ClassMgr
    {
       /**
       * Returns a list of CompanyType for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.CompanyType for all models
       * @return Iterator of org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.CompanyType
       * @param id Identifier for org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.CompanyType
       * @return A org.semanticwb.cptm.CompanyType
       */
        public static org.semanticwb.cptm.CompanyType getCompanyType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.CompanyType
       * @param id Identifier for org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.CompanyType
       * @return A org.semanticwb.cptm.CompanyType
       */
        public static org.semanticwb.cptm.CompanyType createCompanyType(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.CompanyType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.CompanyType
       * @param id Identifier for org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.CompanyType
       */
        public static void removeCompanyType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.CompanyType
       * @param id Identifier for org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.CompanyType
       * @return true if the org.semanticwb.cptm.CompanyType exists, false otherwise
       */

        public static boolean hasCompanyType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompanyType(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CompanyType
       * @return Iterator with all the org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypeByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyType with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypeByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyType with a determined CompanyTypeInv
       * @param value CompanyTypeInv of the type org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.CompanyType
       * @return Iterator with all the org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypeByCompanyTypeInv(org.semanticwb.cptm.GeneralCompany value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyTypeInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyType with a determined CompanyTypeInv
       * @param value CompanyTypeInv of the type org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypeByCompanyTypeInv(org.semanticwb.cptm.GeneralCompany value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyTypeInv,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.CompanyType
       * @return Iterator with all the org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypeByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.CompanyType with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.CompanyType
       */

        public static java.util.Iterator<org.semanticwb.cptm.CompanyType> listCompanyTypeByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompanyTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CompanyType
   */
    public CompanyTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
   * Gets all the org.semanticwb.cptm.GeneralCompany
   * @return A GenericIterator with all the org.semanticwb.cptm.GeneralCompany
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> listCompanyTypeInvs()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany>(getSemanticObject().listObjectProperties(cptm_hasCompanyTypeInv));
    }

   /**
   * Gets true if has a CompanyTypeInv
   * @param value org.semanticwb.cptm.GeneralCompany to verify
   * @return true if the org.semanticwb.cptm.GeneralCompany exists, false otherwise
   */
    public boolean hasCompanyTypeInv(org.semanticwb.cptm.GeneralCompany value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompanyTypeInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the CompanyTypeInv
   * @return a org.semanticwb.cptm.GeneralCompany
   */
    public org.semanticwb.cptm.GeneralCompany getCompanyTypeInv()
    {
         org.semanticwb.cptm.GeneralCompany ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompanyTypeInv);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.GeneralCompany)obj.createGenericInstance();
         }
         return ret;
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
}
