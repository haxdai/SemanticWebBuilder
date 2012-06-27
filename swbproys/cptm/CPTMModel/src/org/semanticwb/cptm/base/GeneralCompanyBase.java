package org.semanticwb.cptm.base;


   /**
   * Interface para datos generales de Cadenas, Marcas y Empresas 
   */
public abstract class GeneralCompanyBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Tagable,org.semanticwb.cptm.CptmgeneralData,org.semanticwb.model.Resourceable,org.semanticwb.model.Geolocalizable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Searchable,org.semanticwb.model.Traceable,org.semanticwb.portal.community.Addressable,org.semanticwb.model.Indexable
{
    public static final org.semanticwb.platform.SemanticClass cptm_Promotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#Promotion");
   /**
   * Promociones de la Compañia
   */
    public static final org.semanticwb.platform.SemanticProperty cptm_hasPromotion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasPromotion");
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyLine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyLine");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompanyLine=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompanyLine");
   /**
   * Interfaz que define propiedades en comun para un Punto Geografico y una Marca Regional
   */
    public static final org.semanticwb.platform.SemanticClass cptm_LocalityInt=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#LocalityInt");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompLocality=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompLocality");
    public static final org.semanticwb.platform.SemanticClass cptm_CompanyType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#CompanyType");
    public static final org.semanticwb.platform.SemanticProperty cptm_hasCompanyType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/cptm#hasCompanyType");
   /**
   * Interface para datos generales de Cadenas, Marcas y Empresas
   */
    public static final org.semanticwb.platform.SemanticClass cptm_GeneralCompany=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeneralCompany");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#GeneralCompany");

    public static class ClassMgr
    {
       /**
       * Returns a list of GeneralCompany for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanies(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.GeneralCompany for all models
       * @return Iterator of org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanies()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.GeneralCompany
       * @param id Identifier for org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return A org.semanticwb.cptm.GeneralCompany
       */
        public static org.semanticwb.cptm.GeneralCompany getGeneralCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.GeneralCompany)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.GeneralCompany
       * @param id Identifier for org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return A org.semanticwb.cptm.GeneralCompany
       */
        public static org.semanticwb.cptm.GeneralCompany createGeneralCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.GeneralCompany)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.GeneralCompany
       * @param id Identifier for org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       */
        public static void removeGeneralCompany(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.GeneralCompany
       * @param id Identifier for org.semanticwb.cptm.GeneralCompany
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return true if the org.semanticwb.cptm.GeneralCompany exists, false otherwise
       */

        public static boolean hasGeneralCompany(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGeneralCompany(id, model)!=null);
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByPromotion(org.semanticwb.cptm.Promotion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined Promotion
       * @param value Promotion of the type org.semanticwb.cptm.Promotion
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByPromotion(org.semanticwb.cptm.Promotion value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasPromotion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCompanyLine(org.semanticwb.cptm.CompanyLine value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined CompanyLine
       * @param value CompanyLine of the type org.semanticwb.cptm.CompanyLine
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCompanyLine(org.semanticwb.cptm.CompanyLine value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyLine,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCompLocality(org.semanticwb.cptm.LocalityInt value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined CompLocality
       * @param value CompLocality of the type org.semanticwb.cptm.LocalityInt
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCompLocality(org.semanticwb.cptm.LocalityInt value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompLocality,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByResource(org.semanticwb.model.Resource value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined Resource
       * @param value Resource of the type org.semanticwb.model.Resource
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByResource(org.semanticwb.model.Resource value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_hasResource,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCompanyType(org.semanticwb.cptm.CompanyType value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined CompanyType
       * @param value CompanyType of the type org.semanticwb.cptm.CompanyType
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByCompanyType(org.semanticwb.cptm.CompanyType value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasCompanyType,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @param model Model of the org.semanticwb.cptm.GeneralCompany
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByMorePhoto(org.semanticwb.cptm.Photo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all org.semanticwb.cptm.GeneralCompany with a determined MorePhoto
       * @param value MorePhoto of the type org.semanticwb.cptm.Photo
       * @return Iterator with all the org.semanticwb.cptm.GeneralCompany
       */

        public static java.util.Iterator<org.semanticwb.cptm.GeneralCompany> listGeneralCompanyByMorePhoto(org.semanticwb.cptm.Photo value)
        {
            org.semanticwb.model.GenericIterator<org.semanticwb.cptm.GeneralCompany> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(cptm_hasMorePhoto,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GeneralCompanyBase with a SemanticObject
   * @param base The SemanticObject with the properties for the GeneralCompany
   */
    public GeneralCompanyBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the org.semanticwb.cptm.Promotion
   * @return A GenericIterator with all the org.semanticwb.cptm.Promotion
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion> listPromotions()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Promotion>(getSemanticObject().listObjectProperties(cptm_hasPromotion));
    }

   /**
   * Gets true if has a Promotion
   * @param value org.semanticwb.cptm.Promotion to verify
   * @return true if the org.semanticwb.cptm.Promotion exists, false otherwise
   */
    public boolean hasPromotion(org.semanticwb.cptm.Promotion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasPromotion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Promotion
   * @param value org.semanticwb.cptm.Promotion to add
   */

    public void addPromotion(org.semanticwb.cptm.Promotion value)
    {
        getSemanticObject().addObjectProperty(cptm_hasPromotion, value.getSemanticObject());
    }
   /**
   * Removes all the Promotion
   */

    public void removeAllPromotion()
    {
        getSemanticObject().removeProperty(cptm_hasPromotion);
    }
   /**
   * Removes a Promotion
   * @param value org.semanticwb.cptm.Promotion to remove
   */

    public void removePromotion(org.semanticwb.cptm.Promotion value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasPromotion,value.getSemanticObject());
    }

   /**
   * Gets the Promotion
   * @return a org.semanticwb.cptm.Promotion
   */
    public org.semanticwb.cptm.Promotion getPromotion()
    {
         org.semanticwb.cptm.Promotion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasPromotion);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Promotion)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Indexable property
* @return boolean with the Indexable
*/
    public boolean isIndexable()
    {
        return getSemanticObject().getBooleanProperty(swb_indexable);
    }

/**
* Sets the Indexable property
* @param value long with the Indexable
*/
    public void setIndexable(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_indexable, value);
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
   * Gets all the org.semanticwb.cptm.CompanyLine
   * @return A GenericIterator with all the org.semanticwb.cptm.CompanyLine
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyLine> listCompanyLines()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyLine>(getSemanticObject().listObjectProperties(cptm_hasCompanyLine));
    }

   /**
   * Gets true if has a CompanyLine
   * @param value org.semanticwb.cptm.CompanyLine to verify
   * @return true if the org.semanticwb.cptm.CompanyLine exists, false otherwise
   */
    public boolean hasCompanyLine(org.semanticwb.cptm.CompanyLine value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompanyLine,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CompanyLine
   * @param value org.semanticwb.cptm.CompanyLine to add
   */

    public void addCompanyLine(org.semanticwb.cptm.CompanyLine value)
    {
        getSemanticObject().addObjectProperty(cptm_hasCompanyLine, value.getSemanticObject());
    }
   /**
   * Removes all the CompanyLine
   */

    public void removeAllCompanyLine()
    {
        getSemanticObject().removeProperty(cptm_hasCompanyLine);
    }
   /**
   * Removes a CompanyLine
   * @param value org.semanticwb.cptm.CompanyLine to remove
   */

    public void removeCompanyLine(org.semanticwb.cptm.CompanyLine value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasCompanyLine,value.getSemanticObject());
    }

   /**
   * Gets the CompanyLine
   * @return a org.semanticwb.cptm.CompanyLine
   */
    public org.semanticwb.cptm.CompanyLine getCompanyLine()
    {
         org.semanticwb.cptm.CompanyLine ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompanyLine);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.CompanyLine)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the City property
* @return String with the City
*/
    public String getCity()
    {
        return getSemanticObject().getProperty(swbcomm_city);
    }

/**
* Sets the City property
* @param value long with the City
*/
    public void setCity(String value)
    {
        getSemanticObject().setProperty(swbcomm_city, value);
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
* Gets the PhotoEscudoAlt property
* @return String with the PhotoEscudoAlt
*/
    public String getPhotoEscudoAlt()
    {
        return getSemanticObject().getProperty(cptm_photoEscudoAlt);
    }

/**
* Sets the PhotoEscudoAlt property
* @param value long with the PhotoEscudoAlt
*/
    public void setPhotoEscudoAlt(String value)
    {
        getSemanticObject().setProperty(cptm_photoEscudoAlt, value);
    }

    public String getPhotoEscudoAlt(String lang)
    {
        return getSemanticObject().getProperty(cptm_photoEscudoAlt, null, lang);
    }

    public String getDisplayPhotoEscudoAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_photoEscudoAlt, lang);
    }

    public void setPhotoEscudoAlt(String photoEscudoAlt, String lang)
    {
        getSemanticObject().setProperty(cptm_photoEscudoAlt, photoEscudoAlt, lang);
    }

/**
* Gets the Step property
* @return int with the Step
*/
    public int getStep()
    {
        return getSemanticObject().getIntProperty(swb_geoStep);
    }

/**
* Sets the Step property
* @param value long with the Step
*/
    public void setStep(int value)
    {
        getSemanticObject().setIntProperty(swb_geoStep, value);
    }

/**
* Gets the Latitude property
* @return double with the Latitude
*/
    public double getLatitude()
    {
        return getSemanticObject().getDoubleProperty(swb_latitude);
    }

/**
* Sets the Latitude property
* @param value long with the Latitude
*/
    public void setLatitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_latitude, value);
    }

/**
* Gets the PhotoAuthor property
* @return String with the PhotoAuthor
*/
    public String getPhotoAuthor()
    {
        return getSemanticObject().getProperty(cptm_photoAuthor);
    }

/**
* Sets the PhotoAuthor property
* @param value long with the PhotoAuthor
*/
    public void setPhotoAuthor(String value)
    {
        getSemanticObject().setProperty(cptm_photoAuthor, value);
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
* Gets the PhotoEscudo property
* @return String with the PhotoEscudo
*/
    public String getPhotoEscudo()
    {
        return getSemanticObject().getProperty(cptm_photoEscudo);
    }

/**
* Sets the PhotoEscudo property
* @param value long with the PhotoEscudo
*/
    public void setPhotoEscudo(String value)
    {
        getSemanticObject().setProperty(cptm_photoEscudo, value);
    }

/**
* Gets the PhotoAlt property
* @return String with the PhotoAlt
*/
    public String getPhotoAlt()
    {
        return getSemanticObject().getProperty(cptm_photoAlt);
    }

/**
* Sets the PhotoAlt property
* @param value long with the PhotoAlt
*/
    public void setPhotoAlt(String value)
    {
        getSemanticObject().setProperty(cptm_photoAlt, value);
    }

    public String getPhotoAlt(String lang)
    {
        return getSemanticObject().getProperty(cptm_photoAlt, null, lang);
    }

    public String getDisplayPhotoAlt(String lang)
    {
        return getSemanticObject().getLocaleProperty(cptm_photoAlt, lang);
    }

    public void setPhotoAlt(String photoAlt, String lang)
    {
        getSemanticObject().setProperty(cptm_photoAlt, photoAlt, lang);
    }

/**
* Gets the ExtNumber property
* @return String with the ExtNumber
*/
    public String getExtNumber()
    {
        return getSemanticObject().getProperty(swbcomm_extNumber);
    }

/**
* Sets the ExtNumber property
* @param value long with the ExtNumber
*/
    public void setExtNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_extNumber, value);
    }

/**
* Gets the Tags property
* @return String with the Tags
*/
    public String getTags()
    {
        return getSemanticObject().getProperty(swb_tags);
    }

/**
* Sets the Tags property
* @param value long with the Tags
*/
    public void setTags(String value)
    {
        getSemanticObject().setProperty(swb_tags, value);
    }

    public String getTags(String lang)
    {
        return getSemanticObject().getProperty(swb_tags, null, lang);
    }

    public String getDisplayTags(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_tags, lang);
    }

    public void setTags(String tags, String lang)
    {
        getSemanticObject().setProperty(swb_tags, tags, lang);
    }

/**
* Gets the IntNumber property
* @return String with the IntNumber
*/
    public String getIntNumber()
    {
        return getSemanticObject().getProperty(swbcomm_intNumber);
    }

/**
* Sets the IntNumber property
* @param value long with the IntNumber
*/
    public void setIntNumber(String value)
    {
        getSemanticObject().setProperty(swbcomm_intNumber, value);
    }

/**
* Gets the CityCouncil property
* @return String with the CityCouncil
*/
    public String getCityCouncil()
    {
        return getSemanticObject().getProperty(swbcomm_cityCouncil);
    }

/**
* Sets the CityCouncil property
* @param value long with the CityCouncil
*/
    public void setCityCouncil(String value)
    {
        getSemanticObject().setProperty(swbcomm_cityCouncil, value);
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
* Gets the Longitude property
* @return double with the Longitude
*/
    public double getLongitude()
    {
        return getSemanticObject().getDoubleProperty(swb_longitude);
    }

/**
* Sets the Longitude property
* @param value long with the Longitude
*/
    public void setLongitude(double value)
    {
        getSemanticObject().setDoubleProperty(swb_longitude, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.LocalityInt
   * @return A GenericIterator with all the org.semanticwb.cptm.LocalityInt
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt> listCompLocalities()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.LocalityInt>(getSemanticObject().listObjectProperties(cptm_hasCompLocality));
    }

   /**
   * Gets true if has a CompLocality
   * @param value org.semanticwb.cptm.LocalityInt to verify
   * @return true if the org.semanticwb.cptm.LocalityInt exists, false otherwise
   */
    public boolean hasCompLocality(org.semanticwb.cptm.LocalityInt value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompLocality,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CompLocality
   * @param value org.semanticwb.cptm.LocalityInt to add
   */

    public void addCompLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().addObjectProperty(cptm_hasCompLocality, value.getSemanticObject());
    }
   /**
   * Removes all the CompLocality
   */

    public void removeAllCompLocality()
    {
        getSemanticObject().removeProperty(cptm_hasCompLocality);
    }
   /**
   * Removes a CompLocality
   * @param value org.semanticwb.cptm.LocalityInt to remove
   */

    public void removeCompLocality(org.semanticwb.cptm.LocalityInt value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasCompLocality,value.getSemanticObject());
    }

   /**
   * Gets the CompLocality
   * @return a org.semanticwb.cptm.LocalityInt
   */
    public org.semanticwb.cptm.LocalityInt getCompLocality()
    {
         org.semanticwb.cptm.LocalityInt ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompLocality);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.LocalityInt)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the State property
* @return String with the State
*/
    public String getState()
    {
        return getSemanticObject().getProperty(swbcomm_state);
    }

/**
* Sets the State property
* @param value long with the State
*/
    public void setState(String value)
    {
        getSemanticObject().setProperty(swbcomm_state, value);
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
   * Gets all the org.semanticwb.model.Resource
   * @return A GenericIterator with all the org.semanticwb.model.Resource
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource> listResources()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.model.Resource>(getSemanticObject().listObjectProperties(swb_hasResource));
    }

   /**
   * Gets true if has a Resource
   * @param value org.semanticwb.model.Resource to verify
   * @return true if the org.semanticwb.model.Resource exists, false otherwise
   */
    public boolean hasResource(org.semanticwb.model.Resource value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(swb_hasResource,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Resource
   * @param value org.semanticwb.model.Resource to add
   */

    public void addResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().addObjectProperty(swb_hasResource, value.getSemanticObject());
    }
   /**
   * Removes all the Resource
   */

    public void removeAllResource()
    {
        getSemanticObject().removeProperty(swb_hasResource);
    }
   /**
   * Removes a Resource
   * @param value org.semanticwb.model.Resource to remove
   */

    public void removeResource(org.semanticwb.model.Resource value)
    {
        getSemanticObject().removeObjectProperty(swb_hasResource,value.getSemanticObject());
    }

   /**
   * Gets the Resource
   * @return a org.semanticwb.model.Resource
   */
    public org.semanticwb.model.Resource getResource()
    {
         org.semanticwb.model.Resource ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_hasResource);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Resource)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the org.semanticwb.cptm.CompanyType
   * @return A GenericIterator with all the org.semanticwb.cptm.CompanyType
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType> listCompanyTypes()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.CompanyType>(getSemanticObject().listObjectProperties(cptm_hasCompanyType));
    }

   /**
   * Gets true if has a CompanyType
   * @param value org.semanticwb.cptm.CompanyType to verify
   * @return true if the org.semanticwb.cptm.CompanyType exists, false otherwise
   */
    public boolean hasCompanyType(org.semanticwb.cptm.CompanyType value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasCompanyType,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CompanyType
   * @param value org.semanticwb.cptm.CompanyType to add
   */

    public void addCompanyType(org.semanticwb.cptm.CompanyType value)
    {
        getSemanticObject().addObjectProperty(cptm_hasCompanyType, value.getSemanticObject());
    }
   /**
   * Removes all the CompanyType
   */

    public void removeAllCompanyType()
    {
        getSemanticObject().removeProperty(cptm_hasCompanyType);
    }
   /**
   * Removes a CompanyType
   * @param value org.semanticwb.cptm.CompanyType to remove
   */

    public void removeCompanyType(org.semanticwb.cptm.CompanyType value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasCompanyType,value.getSemanticObject());
    }

   /**
   * Gets the CompanyType
   * @return a org.semanticwb.cptm.CompanyType
   */
    public org.semanticwb.cptm.CompanyType getCompanyType()
    {
         org.semanticwb.cptm.CompanyType ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasCompanyType);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.CompanyType)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the StreetName property
* @return String with the StreetName
*/
    public String getStreetName()
    {
        return getSemanticObject().getProperty(swbcomm_streetName);
    }

/**
* Sets the StreetName property
* @param value long with the StreetName
*/
    public void setStreetName(String value)
    {
        getSemanticObject().setProperty(swbcomm_streetName, value);
    }
   /**
   * Gets all the org.semanticwb.cptm.Photo
   * @return A GenericIterator with all the org.semanticwb.cptm.Photo
   */

    public org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo> listMorePhotos()
    {
        return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.Photo>(getSemanticObject().listObjectProperties(cptm_hasMorePhoto));
    }

   /**
   * Gets true if has a MorePhoto
   * @param value org.semanticwb.cptm.Photo to verify
   * @return true if the org.semanticwb.cptm.Photo exists, false otherwise
   */
    public boolean hasMorePhoto(org.semanticwb.cptm.Photo value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(cptm_hasMorePhoto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a MorePhoto
   * @param value org.semanticwb.cptm.Photo to add
   */

    public void addMorePhoto(org.semanticwb.cptm.Photo value)
    {
        getSemanticObject().addObjectProperty(cptm_hasMorePhoto, value.getSemanticObject());
    }
   /**
   * Removes all the MorePhoto
   */

    public void removeAllMorePhoto()
    {
        getSemanticObject().removeProperty(cptm_hasMorePhoto);
    }
   /**
   * Removes a MorePhoto
   * @param value org.semanticwb.cptm.Photo to remove
   */

    public void removeMorePhoto(org.semanticwb.cptm.Photo value)
    {
        getSemanticObject().removeObjectProperty(cptm_hasMorePhoto,value.getSemanticObject());
    }

   /**
   * Gets the MorePhoto
   * @return a org.semanticwb.cptm.Photo
   */
    public org.semanticwb.cptm.Photo getMorePhoto()
    {
         org.semanticwb.cptm.Photo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(cptm_hasMorePhoto);
         if(obj!=null)
         {
             ret=(org.semanticwb.cptm.Photo)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Photo property
* @return String with the Photo
*/
    public String getPhoto()
    {
        return getSemanticObject().getProperty(cptm_photo);
    }

/**
* Sets the Photo property
* @param value long with the Photo
*/
    public void setPhoto(String value)
    {
        getSemanticObject().setProperty(cptm_photo, value);
    }
}
