package com.infotec.eworkplace.swb.base;


public abstract class AdminProyectoProcesoBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_AdminProyectoProceso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AdminProyectoProceso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#AdminProyectoProceso");

    public static class ClassMgr
    {
       /**
       * Returns a list of AdminProyectoProceso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.AdminProyectoProceso> listAdminProyectoProcesos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AdminProyectoProceso>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.AdminProyectoProceso for all models
       * @return Iterator of com.infotec.eworkplace.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.AdminProyectoProceso> listAdminProyectoProcesos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AdminProyectoProceso>(it, true);
        }

        public static com.infotec.eworkplace.swb.AdminProyectoProceso createAdminProyectoProceso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.AdminProyectoProceso.ClassMgr.createAdminProyectoProceso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.eworkplace.swb.AdminProyectoProceso
       * @return A com.infotec.eworkplace.swb.AdminProyectoProceso
       */
        public static com.infotec.eworkplace.swb.AdminProyectoProceso getAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.AdminProyectoProceso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.eworkplace.swb.AdminProyectoProceso
       * @return A com.infotec.eworkplace.swb.AdminProyectoProceso
       */
        public static com.infotec.eworkplace.swb.AdminProyectoProceso createAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.AdminProyectoProceso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.eworkplace.swb.AdminProyectoProceso
       */
        public static void removeAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.eworkplace.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.eworkplace.swb.AdminProyectoProceso
       * @return true if the com.infotec.eworkplace.swb.AdminProyectoProceso exists, false otherwise
       */

        public static boolean hasAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAdminProyectoProceso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.AdminProyectoProceso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.AdminProyectoProceso
       * @return Iterator with all the com.infotec.eworkplace.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.AdminProyectoProceso> listAdminProyectoProcesoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.AdminProyectoProceso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.AdminProyectoProceso> listAdminProyectoProcesoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.AdminProyectoProceso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.AdminProyectoProceso
       * @return Iterator with all the com.infotec.eworkplace.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.AdminProyectoProceso> listAdminProyectoProcesoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.AdminProyectoProceso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.AdminProyectoProceso> listAdminProyectoProcesoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AdminProyectoProcesoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the AdminProyectoProceso
   */
    public AdminProyectoProcesoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
