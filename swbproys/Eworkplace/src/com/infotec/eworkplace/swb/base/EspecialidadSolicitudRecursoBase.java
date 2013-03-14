package com.infotec.eworkplace.swb.base;


public abstract class EspecialidadSolicitudRecursoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_EspecialidadSolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EspecialidadSolicitudRecurso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EspecialidadSolicitudRecurso");

    public static class ClassMgr
    {
       /**
       * Returns a list of EspecialidadSolicitudRecurso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> listEspecialidadSolicitudRecursos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso for all models
       * @return Iterator of com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> listEspecialidadSolicitudRecursos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso>(it, true);
        }

        public static com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso createEspecialidadSolicitudRecurso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso.ClassMgr.createEspecialidadSolicitudRecurso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param model Model of the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @return A com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */
        public static com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso getEspecialidadSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param model Model of the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @return A com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */
        public static com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso createEspecialidadSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param model Model of the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */
        public static void removeEspecialidadSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @param model Model of the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @return true if the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso exists, false otherwise
       */

        public static boolean hasEspecialidadSolicitudRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEspecialidadSolicitudRecurso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @return Iterator with all the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> listEspecialidadSolicitudRecursoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> listEspecialidadSolicitudRecursoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       * @return Iterator with all the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> listEspecialidadSolicitudRecursoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> listEspecialidadSolicitudRecursoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EspecialidadSolicitudRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static EspecialidadSolicitudRecursoBase.ClassMgr getEspecialidadSolicitudRecursoClassMgr()
    {
        return new EspecialidadSolicitudRecursoBase.ClassMgr();
    }

   /**
   * Constructs a EspecialidadSolicitudRecursoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EspecialidadSolicitudRecurso
   */
    public EspecialidadSolicitudRecursoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
