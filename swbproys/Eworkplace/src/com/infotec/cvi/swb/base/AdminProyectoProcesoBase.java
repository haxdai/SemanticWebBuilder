package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para Administrador de procesos o proyectos 
   */
public abstract class AdminProyectoProcesoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para Administrador de procesos o proyectos
   */
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
       * @return Iterator of com.infotec.cvi.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AdminProyectoProceso> listAdminProyectoProcesos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AdminProyectoProceso>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.AdminProyectoProceso for all models
       * @return Iterator of com.infotec.cvi.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AdminProyectoProceso> listAdminProyectoProcesos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AdminProyectoProceso>(it, true);
        }

        public static com.infotec.cvi.swb.AdminProyectoProceso createAdminProyectoProceso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.AdminProyectoProceso.ClassMgr.createAdminProyectoProceso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.cvi.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.cvi.swb.AdminProyectoProceso
       * @return A com.infotec.cvi.swb.AdminProyectoProceso
       */
        public static com.infotec.cvi.swb.AdminProyectoProceso getAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AdminProyectoProceso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.cvi.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.cvi.swb.AdminProyectoProceso
       * @return A com.infotec.cvi.swb.AdminProyectoProceso
       */
        public static com.infotec.cvi.swb.AdminProyectoProceso createAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.AdminProyectoProceso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.cvi.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.cvi.swb.AdminProyectoProceso
       */
        public static void removeAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.AdminProyectoProceso
       * @param id Identifier for com.infotec.cvi.swb.AdminProyectoProceso
       * @param model Model of the com.infotec.cvi.swb.AdminProyectoProceso
       * @return true if the com.infotec.cvi.swb.AdminProyectoProceso exists, false otherwise
       */

        public static boolean hasAdminProyectoProceso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAdminProyectoProceso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.AdminProyectoProceso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AdminProyectoProceso
       * @return Iterator with all the com.infotec.cvi.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AdminProyectoProceso> listAdminProyectoProcesoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AdminProyectoProceso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AdminProyectoProceso> listAdminProyectoProcesoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AdminProyectoProceso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.AdminProyectoProceso
       * @return Iterator with all the com.infotec.cvi.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AdminProyectoProceso> listAdminProyectoProcesoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.AdminProyectoProceso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.AdminProyectoProceso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.AdminProyectoProceso> listAdminProyectoProcesoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.AdminProyectoProceso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static AdminProyectoProcesoBase.ClassMgr getAdminProyectoProcesoClassMgr()
    {
        return new AdminProyectoProcesoBase.ClassMgr();
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
