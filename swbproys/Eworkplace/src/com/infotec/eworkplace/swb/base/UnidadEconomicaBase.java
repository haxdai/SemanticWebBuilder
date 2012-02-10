package com.infotec.eworkplace.swb.base;


public abstract class UnidadEconomicaBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Sector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sector");
    public static final org.semanticwb.platform.SemanticProperty intranet_invSector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#invSector");
    public static final org.semanticwb.platform.SemanticClass intranet_UnidadEconomica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#UnidadEconomica");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#UnidadEconomica");

    public static class ClassMgr
    {
       /**
       * Returns a list of UnidadEconomica for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.UnidadEconomica for all models
       * @return Iterator of com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica>(it, true);
        }

        public static com.infotec.eworkplace.swb.UnidadEconomica createUnidadEconomica(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.UnidadEconomica.ClassMgr.createUnidadEconomica(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.UnidadEconomica
       * @param id Identifier for com.infotec.eworkplace.swb.UnidadEconomica
       * @param model Model of the com.infotec.eworkplace.swb.UnidadEconomica
       * @return A com.infotec.eworkplace.swb.UnidadEconomica
       */
        public static com.infotec.eworkplace.swb.UnidadEconomica getUnidadEconomica(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.UnidadEconomica)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.UnidadEconomica
       * @param id Identifier for com.infotec.eworkplace.swb.UnidadEconomica
       * @param model Model of the com.infotec.eworkplace.swb.UnidadEconomica
       * @return A com.infotec.eworkplace.swb.UnidadEconomica
       */
        public static com.infotec.eworkplace.swb.UnidadEconomica createUnidadEconomica(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.UnidadEconomica)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.UnidadEconomica
       * @param id Identifier for com.infotec.eworkplace.swb.UnidadEconomica
       * @param model Model of the com.infotec.eworkplace.swb.UnidadEconomica
       */
        public static void removeUnidadEconomica(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.UnidadEconomica
       * @param id Identifier for com.infotec.eworkplace.swb.UnidadEconomica
       * @param model Model of the com.infotec.eworkplace.swb.UnidadEconomica
       * @return true if the com.infotec.eworkplace.swb.UnidadEconomica exists, false otherwise
       */

        public static boolean hasUnidadEconomica(String id, org.semanticwb.model.SWBModel model)
        {
            return (getUnidadEconomica(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.UnidadEconomica with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.UnidadEconomica
       * @return Iterator with all the com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.UnidadEconomica with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.UnidadEconomica with a determined InvSector
       * @param value InvSector of the type com.infotec.eworkplace.swb.Sector
       * @param model Model of the com.infotec.eworkplace.swb.UnidadEconomica
       * @return Iterator with all the com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicaByInvSector(com.infotec.eworkplace.swb.Sector value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_invSector, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.UnidadEconomica with a determined InvSector
       * @param value InvSector of the type com.infotec.eworkplace.swb.Sector
       * @return Iterator with all the com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicaByInvSector(com.infotec.eworkplace.swb.Sector value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_invSector,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.UnidadEconomica with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.UnidadEconomica
       * @return Iterator with all the com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.UnidadEconomica with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.UnidadEconomica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.UnidadEconomica> listUnidadEconomicaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.UnidadEconomica> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a UnidadEconomicaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UnidadEconomica
   */
    public UnidadEconomicaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property InvSector
   * @param value InvSector to set
   */

    public void setInvSector(com.infotec.eworkplace.swb.Sector value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_invSector, value.getSemanticObject());
        }else
        {
            removeInvSector();
        }
    }
   /**
   * Remove the value for InvSector property
   */

    public void removeInvSector()
    {
        getSemanticObject().removeProperty(intranet_invSector);
    }

   /**
   * Gets the InvSector
   * @return a com.infotec.eworkplace.swb.Sector
   */
    public com.infotec.eworkplace.swb.Sector getInvSector()
    {
         com.infotec.eworkplace.swb.Sector ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_invSector);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Sector)obj.createGenericInstance();
         }
         return ret;
    }
}
