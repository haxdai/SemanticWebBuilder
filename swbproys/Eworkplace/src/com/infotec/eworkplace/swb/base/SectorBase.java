package com.infotec.eworkplace.swb.base;


public abstract class SectorBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_UnidadEconomica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#UnidadEconomica");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasUnidadEconomica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasUnidadEconomica");
    public static final org.semanticwb.platform.SemanticClass intranet_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sector");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sector");

    public static class ClassMgr
    {
       /**
       * Returns a list of Sector for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Sector for all models
       * @return Iterator of com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector>(it, true);
        }

        public static com.infotec.eworkplace.swb.Sector createSector(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Sector.ClassMgr.createSector(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Sector
       * @param id Identifier for com.infotec.eworkplace.swb.Sector
       * @param model Model of the com.infotec.eworkplace.swb.Sector
       * @return A com.infotec.eworkplace.swb.Sector
       */
        public static com.infotec.eworkplace.swb.Sector getSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Sector)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Sector
       * @param id Identifier for com.infotec.eworkplace.swb.Sector
       * @param model Model of the com.infotec.eworkplace.swb.Sector
       * @return A com.infotec.eworkplace.swb.Sector
       */
        public static com.infotec.eworkplace.swb.Sector createSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Sector)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Sector
       * @param id Identifier for com.infotec.eworkplace.swb.Sector
       * @param model Model of the com.infotec.eworkplace.swb.Sector
       */
        public static void removeSector(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Sector
       * @param id Identifier for com.infotec.eworkplace.swb.Sector
       * @param model Model of the com.infotec.eworkplace.swb.Sector
       * @return true if the com.infotec.eworkplace.swb.Sector exists, false otherwise
       */

        public static boolean hasSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSector(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Sector with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Sector
       * @return Iterator with all the com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectorByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Sector with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectorByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Sector with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Sector
       * @return Iterator with all the com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectorByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Sector with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectorByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Sector with a determined UnidadEconomica
       * @param value UnidadEconomica of the type com.infotec.eworkplace.swb.UnidadEconomica
       * @param model Model of the com.infotec.eworkplace.swb.Sector
       * @return Iterator with all the com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectorByUnidadEconomica(com.infotec.eworkplace.swb.UnidadEconomica value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasUnidadEconomica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Sector with a determined UnidadEconomica
       * @param value UnidadEconomica of the type com.infotec.eworkplace.swb.UnidadEconomica
       * @return Iterator with all the com.infotec.eworkplace.swb.Sector
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sector> listSectorByUnidadEconomica(com.infotec.eworkplace.swb.UnidadEconomica value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasUnidadEconomica,value.getSemanticObject(),sclass));
            return it;
        }
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
   * Gets all the com.infotec.eworkplace.swb.UnidadEconomica
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.UnidadEconomica
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica>(getSemanticObject().listObjectProperties(intranet_hasUnidadEconomica));
    }

   /**
   * Gets true if has a UnidadEconomica
   * @param value com.infotec.eworkplace.swb.UnidadEconomica to verify
   * @return true if the com.infotec.eworkplace.swb.UnidadEconomica exists, false otherwise
   */
    public boolean hasUnidadEconomica(com.infotec.eworkplace.swb.UnidadEconomica value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasUnidadEconomica,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a UnidadEconomica
   * @param value com.infotec.eworkplace.swb.UnidadEconomica to add
   */

    public void addUnidadEconomica(com.infotec.eworkplace.swb.UnidadEconomica value)
    {
        getSemanticObject().addObjectProperty(intranet_hasUnidadEconomica, value.getSemanticObject());
    }
   /**
   * Removes all the UnidadEconomica
   */

    public void removeAllUnidadEconomica()
    {
        getSemanticObject().removeProperty(intranet_hasUnidadEconomica);
    }
   /**
   * Removes a UnidadEconomica
   * @param value com.infotec.eworkplace.swb.UnidadEconomica to remove
   */

    public void removeUnidadEconomica(com.infotec.eworkplace.swb.UnidadEconomica value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasUnidadEconomica,value.getSemanticObject());
    }

   /**
   * Gets the UnidadEconomica
   * @return a com.infotec.eworkplace.swb.UnidadEconomica
   */
    public com.infotec.eworkplace.swb.UnidadEconomica getUnidadEconomica()
    {
         com.infotec.eworkplace.swb.UnidadEconomica ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasUnidadEconomica);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.UnidadEconomica)obj.createGenericInstance();
         }
         return ret;
    }
}
