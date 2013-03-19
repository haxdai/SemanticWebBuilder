package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula la información relacionada con una partida presupuestal 
   */
public abstract class PartidaPresupuestoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Encapsula la información relacionada con una partida presupuestal
   */
    public static final org.semanticwb.platform.SemanticClass intranet_PartidaPresupuesto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PartidaPresupuesto");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PartidaPresupuesto");

    public static class ClassMgr
    {
       /**
       * Returns a list of PartidaPresupuesto for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.PartidaPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PartidaPresupuesto> listPartidaPresupuestos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.PartidaPresupuesto for all models
       * @return Iterator of com.infotec.rh.syr.swb.PartidaPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PartidaPresupuesto> listPartidaPresupuestos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto>(it, true);
        }

        public static com.infotec.rh.syr.swb.PartidaPresupuesto createPartidaPresupuesto(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.PartidaPresupuesto.ClassMgr.createPartidaPresupuesto(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.PartidaPresupuesto
       * @return A com.infotec.rh.syr.swb.PartidaPresupuesto
       */
        public static com.infotec.rh.syr.swb.PartidaPresupuesto getPartidaPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.PartidaPresupuesto)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.PartidaPresupuesto
       * @return A com.infotec.rh.syr.swb.PartidaPresupuesto
       */
        public static com.infotec.rh.syr.swb.PartidaPresupuesto createPartidaPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.PartidaPresupuesto)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.PartidaPresupuesto
       */
        public static void removePartidaPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param id Identifier for com.infotec.rh.syr.swb.PartidaPresupuesto
       * @param model Model of the com.infotec.rh.syr.swb.PartidaPresupuesto
       * @return true if the com.infotec.rh.syr.swb.PartidaPresupuesto exists, false otherwise
       */

        public static boolean hasPartidaPresupuesto(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPartidaPresupuesto(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PartidaPresupuesto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.PartidaPresupuesto
       * @return Iterator with all the com.infotec.rh.syr.swb.PartidaPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PartidaPresupuesto> listPartidaPresupuestoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PartidaPresupuesto with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.PartidaPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PartidaPresupuesto> listPartidaPresupuestoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PartidaPresupuesto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.PartidaPresupuesto
       * @return Iterator with all the com.infotec.rh.syr.swb.PartidaPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PartidaPresupuesto> listPartidaPresupuestoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.PartidaPresupuesto with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.PartidaPresupuesto
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.PartidaPresupuesto> listPartidaPresupuestoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.PartidaPresupuesto> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static PartidaPresupuestoBase.ClassMgr getPartidaPresupuestoClassMgr()
    {
        return new PartidaPresupuestoBase.ClassMgr();
    }

   /**
   * Constructs a PartidaPresupuestoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PartidaPresupuesto
   */
    public PartidaPresupuestoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
