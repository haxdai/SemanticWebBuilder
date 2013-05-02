package com.infotec.lodp.swb.base;


public abstract class SectorBase extends org.semanticwb.model.base.GenericObjectBase 
{
   /**
   * Indica si el elemento es válido
   */
    public static final org.semanticwb.platform.SemanticProperty swb_valid=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/ontology#valid");
    public static final org.semanticwb.platform.SemanticProperty lodp_sectorTitle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#sectorTitle");
    public static final org.semanticwb.platform.SemanticClass lodp_Institution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#Institution");
    public static final org.semanticwb.platform.SemanticProperty lodp_hasInstitution=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#hasInstitution");
    public static final org.semanticwb.platform.SemanticProperty lodp_sectorDescription=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org.mx/ontology/lodp.owl#sectorDescription");
    public static final org.semanticwb.platform.SemanticClass lodpcg_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Sector");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/lodpCodeGen#Sector");

    public static class ClassMgr
    {
       /**
       * Returns a list of Sector for a model
       * @param model Model to find
       * @return Iterator of com.infotec.lodp.swb.Sector
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Sector> listSectors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Sector>(it, true);
        }
       /**
       * Returns a list of com.infotec.lodp.swb.Sector for all models
       * @return Iterator of com.infotec.lodp.swb.Sector
       */

        public static java.util.Iterator<com.infotec.lodp.swb.Sector> listSectors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.lodp.swb.Sector>(it, true);
        }

        public static com.infotec.lodp.swb.Sector createSector(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.lodp.swb.Sector.ClassMgr.createSector(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.lodp.swb.Sector
       * @param id Identifier for com.infotec.lodp.swb.Sector
       * @param model Model of the com.infotec.lodp.swb.Sector
       * @return A com.infotec.lodp.swb.Sector
       */
        public static com.infotec.lodp.swb.Sector getSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Sector)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.lodp.swb.Sector
       * @param id Identifier for com.infotec.lodp.swb.Sector
       * @param model Model of the com.infotec.lodp.swb.Sector
       * @return A com.infotec.lodp.swb.Sector
       */
        public static com.infotec.lodp.swb.Sector createSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.lodp.swb.Sector)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.lodp.swb.Sector
       * @param id Identifier for com.infotec.lodp.swb.Sector
       * @param model Model of the com.infotec.lodp.swb.Sector
       */
        public static void removeSector(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.lodp.swb.Sector
       * @param id Identifier for com.infotec.lodp.swb.Sector
       * @param model Model of the com.infotec.lodp.swb.Sector
       * @return true if the com.infotec.lodp.swb.Sector exists, false otherwise
       */

        public static boolean hasSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSector(id, model)!=null);
        }
    }

    public static SectorBase.ClassMgr getSectorClassMgr()
    {
        return new SectorBase.ClassMgr();
    }

   /**
   * Constructs a SectorBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Sector
   */
    public SectorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valid property
* @return boolean with the Valid
*/
    public boolean isValid()
    {
        //Override this method in Sector object
        return getSemanticObject().getBooleanProperty(swb_valid,false);
    }

/**
* Sets the Valid property
* @param value long with the Valid
*/
    public void setValid(boolean value)
    {
        //Override this method in Sector object
        getSemanticObject().setBooleanProperty(swb_valid, value,false);
    }

/**
* Gets the SectorTitle property
* @return String with the SectorTitle
*/
    public String getSectorTitle()
    {
        return getSemanticObject().getProperty(lodp_sectorTitle);
    }

/**
* Sets the SectorTitle property
* @param value long with the SectorTitle
*/
    public void setSectorTitle(String value)
    {
        getSemanticObject().setProperty(lodp_sectorTitle, value);
    }

/**
* Gets the SectorDescription property
* @return String with the SectorDescription
*/
    public String getSectorDescription()
    {
        return getSemanticObject().getProperty(lodp_sectorDescription);
    }

/**
* Sets the SectorDescription property
* @param value long with the SectorDescription
*/
    public void setSectorDescription(String value)
    {
        getSemanticObject().setProperty(lodp_sectorDescription, value);
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
