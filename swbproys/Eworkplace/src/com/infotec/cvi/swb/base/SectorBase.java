package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el Sector en el cual has tenido Experiencia Laboral 
   */
public abstract class SectorBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para almacenar las diferentes Unidades Económicas
   */
    public static final org.semanticwb.platform.SemanticClass intranet_UnidadEconomica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#UnidadEconomica");
   /**
   * Economical unit
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasUnidadEconomica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasUnidadEconomica");
   /**
   * Catálogo utilizado para indicar el Sector en el cual has tenido Experiencia Laboral
   */
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
       * @return Iterator of com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Sector for all models
       * @return Iterator of com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector>(it, true);
        }

        public static com.infotec.cvi.swb.Sector createSector(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Sector.ClassMgr.createSector(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Sector
       * @param id Identifier for com.infotec.cvi.swb.Sector
       * @param model Model of the com.infotec.cvi.swb.Sector
       * @return A com.infotec.cvi.swb.Sector
       */
        public static com.infotec.cvi.swb.Sector getSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Sector)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Sector
       * @param id Identifier for com.infotec.cvi.swb.Sector
       * @param model Model of the com.infotec.cvi.swb.Sector
       * @return A com.infotec.cvi.swb.Sector
       */
        public static com.infotec.cvi.swb.Sector createSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Sector)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Sector
       * @param id Identifier for com.infotec.cvi.swb.Sector
       * @param model Model of the com.infotec.cvi.swb.Sector
       */
        public static void removeSector(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Sector
       * @param id Identifier for com.infotec.cvi.swb.Sector
       * @param model Model of the com.infotec.cvi.swb.Sector
       * @return true if the com.infotec.cvi.swb.Sector exists, false otherwise
       */

        public static boolean hasSector(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSector(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Sector with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Sector
       * @return Iterator with all the com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectorByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Sector with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectorByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Sector with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.Sector
       * @return Iterator with all the com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectorByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Sector with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectorByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Sector with a determined UnidadEconomica
       * @param value UnidadEconomica of the type com.infotec.cvi.swb.UnidadEconomica
       * @param model Model of the com.infotec.cvi.swb.Sector
       * @return Iterator with all the com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectorByUnidadEconomica(com.infotec.cvi.swb.UnidadEconomica value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasUnidadEconomica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Sector with a determined UnidadEconomica
       * @param value UnidadEconomica of the type com.infotec.cvi.swb.UnidadEconomica
       * @return Iterator with all the com.infotec.cvi.swb.Sector
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Sector> listSectorByUnidadEconomica(com.infotec.cvi.swb.UnidadEconomica value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Sector> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasUnidadEconomica,value.getSemanticObject(),sclass));
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
   * Gets all the com.infotec.cvi.swb.UnidadEconomica
   * @return A GenericIterator with all the com.infotec.cvi.swb.UnidadEconomica
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UnidadEconomica> listUnidadEconomicas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.UnidadEconomica>(getSemanticObject().listObjectProperties(intranet_hasUnidadEconomica));
    }

   /**
   * Gets true if has a UnidadEconomica
   * @param value com.infotec.cvi.swb.UnidadEconomica to verify
   * @return true if the com.infotec.cvi.swb.UnidadEconomica exists, false otherwise
   */
    public boolean hasUnidadEconomica(com.infotec.cvi.swb.UnidadEconomica value)
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
   * @param value com.infotec.cvi.swb.UnidadEconomica to add
   */

    public void addUnidadEconomica(com.infotec.cvi.swb.UnidadEconomica value)
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
   * @param value com.infotec.cvi.swb.UnidadEconomica to remove
   */

    public void removeUnidadEconomica(com.infotec.cvi.swb.UnidadEconomica value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasUnidadEconomica,value.getSemanticObject());
    }

   /**
   * Gets the UnidadEconomica
   * @return a com.infotec.cvi.swb.UnidadEconomica
   */
    public com.infotec.cvi.swb.UnidadEconomica getUnidadEconomica()
    {
         com.infotec.cvi.swb.UnidadEconomica ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasUnidadEconomica);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.UnidadEconomica)obj.createGenericInstance();
         }
         return ret;
    }
}
