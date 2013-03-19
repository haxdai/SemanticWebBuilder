package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula la información relacionada con un capítulo presupuestal 
   */
public abstract class CapituloPresupuestoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Encapsula la información relacionada con una partida presupuestal
   */
    public static final org.semanticwb.platform.SemanticClass intranet_PartidaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PartidaPresupuesto");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPartidaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPartidaPresupuesto");
   /**
   * Encapsula la información relacionada con un capítulo presupuestal
   */
    public static final org.semanticwb.platform.SemanticClass intranet_CapituloPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CapituloPresupuesto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CapituloPresupuesto");

    public static class ClassMgr
    {
       /**
       * Returns a list of CapituloPresupuesto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.CapituloPresupuesto for all models
       * @return Iterator of com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto>(it, true);
        }

        public static com.infotec.rh.syr.swb.CapituloPresupuesto createCapituloPresupuesto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.CapituloPresupuesto.ClassMgr.createCapituloPresupuesto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.CapituloPresupuesto
       * @return A com.infotec.rh.syr.swb.CapituloPresupuesto
       */
        public static com.infotec.rh.syr.swb.CapituloPresupuesto getCapituloPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.CapituloPresupuesto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.CapituloPresupuesto
       * @return A com.infotec.rh.syr.swb.CapituloPresupuesto
       */
        public static com.infotec.rh.syr.swb.CapituloPresupuesto createCapituloPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.CapituloPresupuesto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.CapituloPresupuesto
       */
        public static void removeCapituloPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.CapituloPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.CapituloPresupuesto
       * @return true if the com.infotec.rh.syr.swb.CapituloPresupuesto exists, false otherwise
       */

        public static boolean hasCapituloPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCapituloPresupuesto(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CapituloPresupuesto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.CapituloPresupuesto
       * @return Iterator with all the com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CapituloPresupuesto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CapituloPresupuesto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.CapituloPresupuesto
       * @return Iterator with all the com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CapituloPresupuesto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CapituloPresupuesto with a determined PartidaPresupuesto
       * @param value PartidaPresupuesto of the type com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.CapituloPresupuesto
       * @return Iterator with all the com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestoByPartidaPresupuesto(com.infotec.rh.syr.swb.PartidaPresupuesto value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPartidaPresupuesto, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.CapituloPresupuesto with a determined PartidaPresupuesto
       * @param value PartidaPresupuesto of the type com.infotec.rh.syr.swb.PartidaPresupuesto
       * @return Iterator with all the com.infotec.rh.syr.swb.CapituloPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.CapituloPresupuesto> listCapituloPresupuestoByPartidaPresupuesto(com.infotec.rh.syr.swb.PartidaPresupuesto value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.CapituloPresupuesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasPartidaPresupuesto,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static CapituloPresupuestoBase.ClassMgr getCapituloPresupuestoClassMgr()
    {
        return new CapituloPresupuestoBase.ClassMgr();
    }

   /**
   * Constructs a CapituloPresupuestoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CapituloPresupuesto
   */
    public CapituloPresupuestoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.rh.syr.swb.PartidaPresupuesto
   * @return A GenericIterator with all the com.infotec.rh.syr.swb.PartidaPresupuesto
   */

    public org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto> listPartidaPresupuestos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto>(getSemanticObject().listObjectProperties(intranet_hasPartidaPresupuesto));
    }

   /**
   * Gets true if has a PartidaPresupuesto
   * @param value com.infotec.rh.syr.swb.PartidaPresupuesto to verify
   * @return true if the com.infotec.rh.syr.swb.PartidaPresupuesto exists, false otherwise
   */
    public boolean hasPartidaPresupuesto(com.infotec.rh.syr.swb.PartidaPresupuesto value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasPartidaPresupuesto,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a PartidaPresupuesto
   * @param value com.infotec.rh.syr.swb.PartidaPresupuesto to add
   */

    public void addPartidaPresupuesto(com.infotec.rh.syr.swb.PartidaPresupuesto value)
    {
        getSemanticObject().addObjectProperty(intranet_hasPartidaPresupuesto, value.getSemanticObject());
    }
   /**
   * Removes all the PartidaPresupuesto
   */

    public void removeAllPartidaPresupuesto()
    {
        getSemanticObject().removeProperty(intranet_hasPartidaPresupuesto);
    }
   /**
   * Removes a PartidaPresupuesto
   * @param value com.infotec.rh.syr.swb.PartidaPresupuesto to remove
   */

    public void removePartidaPresupuesto(com.infotec.rh.syr.swb.PartidaPresupuesto value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasPartidaPresupuesto,value.getSemanticObject());
    }

   /**
   * Gets the PartidaPresupuesto
   * @return a com.infotec.rh.syr.swb.PartidaPresupuesto
   */
    public com.infotec.rh.syr.swb.PartidaPresupuesto getPartidaPresupuesto()
    {
         com.infotec.rh.syr.swb.PartidaPresupuesto ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasPartidaPresupuesto);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.PartidaPresupuesto)obj.createGenericInstance();
         }
         return ret;
    }
}
