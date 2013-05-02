package com.infotec.lodp.swb.base;


public abstract class ApplicationTypeBase extends org.semanticwb.model.base.GenericObjectBase 
{
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticProperty lodp_appTypeDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appTypeDescription");
    public static final org.semanticwb.platform.SemanticProperty lodp_appTypeTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#appTypeTitle");
    public static final org.semanticwb.platform.SemanticClass lodpcg_ApplicationType=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#ApplicationType");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#ApplicationType");

    public static class ClassMgr
    {
       /**
       * Returns a list of ApplicationType for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.ApplicationType
       */

        public static java.util.Iterator<com.infotec.lodp.swb.ApplicationType> listApplicationTypes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.ApplicationType>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.ApplicationType for all models
       * @return Iterator of com.infotec.lodp.swb.ApplicationType
       */

        public static java.util.Iterator<com.infotec.lodp.swb.ApplicationType> listApplicationTypes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.ApplicationType>(it, true);
        }

        public static com.infotec.lodp.swb.ApplicationType createApplicationType(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.ApplicationType.ClassMgr.createApplicationType(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.ApplicationType
       * @param id Identifier for com.infotec.lodp.swb.ApplicationType
       * @param model Model of the com.infotec.lodp.swb.ApplicationType
       * @return A com.infotec.lodp.swb.ApplicationType
       */
        public static com.infotec.lodp.swb.ApplicationType getApplicationType(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.ApplicationType)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.ApplicationType
       * @param id Identifier for com.infotec.lodp.swb.ApplicationType
       * @param model Model of the com.infotec.lodp.swb.ApplicationType
       * @return A com.infotec.lodp.swb.ApplicationType
       */
        public static com.infotec.lodp.swb.ApplicationType createApplicationType(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.ApplicationType)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.ApplicationType
       * @param id Identifier for com.infotec.lodp.swb.ApplicationType
       * @param model Model of the com.infotec.lodp.swb.ApplicationType
       */
        public static void removeApplicationType(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.ApplicationType
       * @param id Identifier for com.infotec.lodp.swb.ApplicationType
       * @param model Model of the com.infotec.lodp.swb.ApplicationType
       * @return true if the com.infotec.lodp.swb.ApplicationType exists, false otherwise
       */

        public static boolean hasApplicationType(String id, org.semanticwb.model.SWBModel model)
        {
            return (getApplicationType(id, model)!=null);
        }
    }

    public static ApplicationTypeBase.ClassMgr getApplicationTypeClassMgr()
    {
        return new ApplicationTypeBase.ClassMgr();
    }

   /**
   * Constructs a ApplicationTypeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ApplicationType
   */
    public ApplicationTypeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in ApplicationType object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in ApplicationType object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

/**
* Gets the AppTypeDescription property
* @return String with the AppTypeDescription
*/
    public String getAppTypeDescription()
    {
        return getSemanticObject().getProperty(lodp_appTypeDescription);
    }

/**
* Sets the AppTypeDescription property
* @param value long with the AppTypeDescription
*/
    public void setAppTypeDescription(String value)
    {
        getSemanticObject().setProperty(lodp_appTypeDescription, value);
    }

/**
* Gets the AppTypeTitle property
* @return String with the AppTypeTitle
*/
    public String getAppTypeTitle()
    {
        return getSemanticObject().getProperty(lodp_appTypeTitle);
    }

/**
* Sets the AppTypeTitle property
* @param value long with the AppTypeTitle
*/
    public void setAppTypeTitle(String value)
    {
        getSemanticObject().setProperty(lodp_appTypeTitle, value);
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
