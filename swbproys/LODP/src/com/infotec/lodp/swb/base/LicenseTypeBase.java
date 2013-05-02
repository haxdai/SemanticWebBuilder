package com.infotec.lodp.swb.base;


public abstract class LicenseTypeBase extends org.semanticwb.model.base.GenericObjectBase 
{
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticProperty lodp_licenseDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#licenseDescription");
    public static final org.semanticwb.platform.SemanticProperty lodp_licenseTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#licenseTitle");
    public static final org.semanticwb.platform.SemanticClass lodpcg_LicenseType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#LicenseType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#LicenseType");

    public static class ClassMgr
    {
       /**
       * Returns a list of LicenseType for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.LicenseType
       */

        public static java.util.Iterator<com.infotec.lodp.swb.LicenseType> listLicenseTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.LicenseType>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.LicenseType for all models
       * @return Iterator of com.infotec.lodp.swb.LicenseType
       */

        public static java.util.Iterator<com.infotec.lodp.swb.LicenseType> listLicenseTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.LicenseType>(it, true);
        }

        public static com.infotec.lodp.swb.LicenseType createLicenseType(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.LicenseType.ClassMgr.createLicenseType(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.LicenseType
       * @param id Identifier for com.infotec.lodp.swb.LicenseType
       * @param model Model of the com.infotec.lodp.swb.LicenseType
       * @return A com.infotec.lodp.swb.LicenseType
       */
        public static com.infotec.lodp.swb.LicenseType getLicenseType(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.LicenseType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.LicenseType
       * @param id Identifier for com.infotec.lodp.swb.LicenseType
       * @param model Model of the com.infotec.lodp.swb.LicenseType
       * @return A com.infotec.lodp.swb.LicenseType
       */
        public static com.infotec.lodp.swb.LicenseType createLicenseType(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.LicenseType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.LicenseType
       * @param id Identifier for com.infotec.lodp.swb.LicenseType
       * @param model Model of the com.infotec.lodp.swb.LicenseType
       */
        public static void removeLicenseType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.LicenseType
       * @param id Identifier for com.infotec.lodp.swb.LicenseType
       * @param model Model of the com.infotec.lodp.swb.LicenseType
       * @return true if the com.infotec.lodp.swb.LicenseType exists, false otherwise
       */

        public static boolean hasLicenseType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getLicenseType(id, model)!=null);
        }
    }

    public static LicenseTypeBase.ClassMgr getLicenseTypeClassMgr()
    {
        return new LicenseTypeBase.ClassMgr();
    }

   /**
   * Constructs a LicenseTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the LicenseType
   */
    public LicenseTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in LicenseType object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in LicenseType object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

/**
* Gets the LicenseDescription property
* @return String with the LicenseDescription
*/
    public String getLicenseDescription()
    {
        return getSemanticObject().getProperty(lodp_licenseDescription);
    }

/**
* Sets the LicenseDescription property
* @param value long with the LicenseDescription
*/
    public void setLicenseDescription(String value)
    {
        getSemanticObject().setProperty(lodp_licenseDescription, value);
    }

/**
* Gets the LicenseTitle property
* @return String with the LicenseTitle
*/
    public String getLicenseTitle()
    {
        return getSemanticObject().getProperty(lodp_licenseTitle);
    }

/**
* Sets the LicenseTitle property
* @param value long with the LicenseTitle
*/
    public void setLicenseTitle(String value)
    {
        getSemanticObject().setProperty(lodp_licenseTitle, value);
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
