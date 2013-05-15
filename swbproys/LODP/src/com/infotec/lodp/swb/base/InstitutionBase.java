package com.infotec.lodp.swb.base;


public abstract class InstitutionBase extends org.semanticwb.model.base.GenericObjectBase 
{
    public static final org.semanticwb.platform.SemanticClass lodpcg_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Sector");
    public static final org.semanticwb.platform.SemanticProperty lodp_sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#sector");
    public static final org.semanticwb.platform.SemanticProperty lodp_institutionTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#institutionTitle");
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticClass lodp_Publisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#Publisher");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasPublisher=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasPublisher");
    public static final org.semanticwb.platform.SemanticProperty lodp_institutionDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#institutionDescription");
   /**
   * URL del sitio web de la institución
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_institutionHome=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#institutionHome");
   /**
   * Enlace de alto nivel
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_topLevelName=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#topLevelName");
   /**
   * Logotipo de la institución
   */
    public static final org.semanticwb.platform.SemanticProperty lodp_institutionLogo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#institutionLogo");
    public static final org.semanticwb.platform.SemanticProperty lodp_institutionCreated=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#institutionCreated");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Institution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Institution");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Institution");

    public static class ClassMgr
    {
       /**
       * Returns a list of Institution for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Institution
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Institution> listInstitutions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Institution>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Institution for all models
       * @return Iterator of com.infotec.lodp.swb.Institution
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Institution> listInstitutions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Institution>(it, true);
        }

        public static com.infotec.lodp.swb.Institution createInstitution(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Institution.ClassMgr.createInstitution(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Institution
       * @param id Identifier for com.infotec.lodp.swb.Institution
       * @param model Model of the com.infotec.lodp.swb.Institution
       * @return A com.infotec.lodp.swb.Institution
       */
        public static com.infotec.lodp.swb.Institution getInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Institution)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Institution
       * @param id Identifier for com.infotec.lodp.swb.Institution
       * @param model Model of the com.infotec.lodp.swb.Institution
       * @return A com.infotec.lodp.swb.Institution
       */
        public static com.infotec.lodp.swb.Institution createInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Institution)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Institution
       * @param id Identifier for com.infotec.lodp.swb.Institution
       * @param model Model of the com.infotec.lodp.swb.Institution
       */
        public static void removeInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Institution
       * @param id Identifier for com.infotec.lodp.swb.Institution
       * @param model Model of the com.infotec.lodp.swb.Institution
       * @return true if the com.infotec.lodp.swb.Institution exists, false otherwise
       */

        public static boolean hasInstitution(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInstitution(id, model)!=null);
        }
       /**
       * Gets all com.infotec.lodp.swb.Institution with a determined Sector
       * @param value Sector of the type com.infotec.lodp.swb.Sector
       * @param model Model of the com.infotec.lodp.swb.Institution
       * @return Iterator with all the com.infotec.lodp.swb.Institution
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Institution> listInstitutionBySector(com.infotec.lodp.swb.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Institution> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(lodp_sector, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.lodp.swb.Institution with a determined Sector
       * @param value Sector of the type com.infotec.lodp.swb.Sector
       * @return Iterator with all the com.infotec.lodp.swb.Institution
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Institution> listInstitutionBySector(com.infotec.lodp.swb.Sector value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Institution> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(lodp_sector,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static InstitutionBase.ClassMgr getInstitutionClassMgr()
    {
        return new InstitutionBase.ClassMgr();
    }

   /**
   * Constructs a InstitutionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Institution
   */
    public InstitutionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Sector
   * @param value Sector to set
   */

    public void setSector(com.infotec.lodp.swb.Sector value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(lodp_sector, value.getSemanticObject());
        }else
        {
            removeSector();
        }
    }
   /**
   * Remove the value for Sector property
   */

    public void removeSector()
    {
        getSemanticObject().removeProperty(lodp_sector);
    }

   /**
   * Gets the Sector
   * @return a com.infotec.lodp.swb.Sector
   */
    public com.infotec.lodp.swb.Sector getSector()
    {
         com.infotec.lodp.swb.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(lodp_sector);
         if(obj!=null)
         {
             ret=(com.infotec.lodp.swb.Sector)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the InstitutionTitle property
* @return String with the InstitutionTitle
*/
    public String getInstitutionTitle()
    {
        return getSemanticObject().getProperty(lodp_institutionTitle);
    }

/**
* Sets the InstitutionTitle property
* @param value long with the InstitutionTitle
*/
    public void setInstitutionTitle(String value)
    {
        getSemanticObject().setProperty(lodp_institutionTitle, value);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in Institution object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in Institution object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

    public org.semanticwb.platform.SemanticIterator<org.semanticwb.platform.SemanticObject> listPublishers()
    {
        com.hp.hpl.jena.rdf.model.StmtIterator stit=getSemanticObject().getRDFResource().listProperties(lodp_hasPublisher.getRDFProperty());
        return new org.semanticwb.platform.SemanticIterator<org.semanticwb.platform.SemanticObject>(stit);
    }

/**
* Gets the Publisher property
* @return the value for the property as org.semanticwb.platform.SemanticObject
*/
    public org.semanticwb.platform.SemanticObject getPublisher()
    {
         org.semanticwb.platform.SemanticObject ret=null;
         ret=getSemanticObject().getObjectProperty(lodp_hasPublisher);
         return ret;
    }

/**
* Gets the InstitutionDescription property
* @return String with the InstitutionDescription
*/
    public String getInstitutionDescription()
    {
        return getSemanticObject().getProperty(lodp_institutionDescription);
    }

/**
* Sets the InstitutionDescription property
* @param value long with the InstitutionDescription
*/
    public void setInstitutionDescription(String value)
    {
        getSemanticObject().setProperty(lodp_institutionDescription, value);
    }

/**
* Gets the InstitutionHome property
* @return String with the InstitutionHome
*/
    public String getInstitutionHome()
    {
        return getSemanticObject().getProperty(lodp_institutionHome);
    }

/**
* Sets the InstitutionHome property
* @param value long with the InstitutionHome
*/
    public void setInstitutionHome(String value)
    {
        getSemanticObject().setProperty(lodp_institutionHome, value);
    }

/**
* Gets the TopLevelName property
* @return String with the TopLevelName
*/
    public String getTopLevelName()
    {
        return getSemanticObject().getProperty(lodp_topLevelName);
    }

/**
* Sets the TopLevelName property
* @param value long with the TopLevelName
*/
    public void setTopLevelName(String value)
    {
        getSemanticObject().setProperty(lodp_topLevelName, value);
    }

/**
* Gets the InstitutionLogo property
* @return String with the InstitutionLogo
*/
    public String getInstitutionLogo()
    {
        return getSemanticObject().getProperty(lodp_institutionLogo);
    }

/**
* Sets the InstitutionLogo property
* @param value long with the InstitutionLogo
*/
    public void setInstitutionLogo(String value)
    {
        getSemanticObject().setProperty(lodp_institutionLogo, value);
    }

/**
* Gets the InstitutionCreated property
* @return java.util.Date with the InstitutionCreated
*/
    public java.util.Date getInstitutionCreated()
    {
        return getSemanticObject().getDateProperty(lodp_institutionCreated);
    }

/**
* Sets the InstitutionCreated property
* @param value long with the InstitutionCreated
*/
    public void setInstitutionCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(lodp_institutionCreated, value);
    }

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
