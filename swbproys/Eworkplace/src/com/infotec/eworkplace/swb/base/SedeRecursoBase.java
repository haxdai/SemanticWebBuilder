package com.infotec.eworkplace.swb.base;


public abstract class SedeRecursoBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_SedeRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SedeRecurso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SedeRecurso");

    public static class ClassMgr
    {
       /**
       * Returns a list of SedeRecurso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SedeRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SedeRecurso> listSedeRecursos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SedeRecurso>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SedeRecurso for all models
       * @return Iterator of com.infotec.eworkplace.swb.SedeRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SedeRecurso> listSedeRecursos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SedeRecurso>(it, true);
        }

        public static com.infotec.eworkplace.swb.SedeRecurso createSedeRecurso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.SedeRecurso.ClassMgr.createSedeRecurso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SedeRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.SedeRecurso
       * @param model Model of the com.infotec.eworkplace.swb.SedeRecurso
       * @return A com.infotec.eworkplace.swb.SedeRecurso
       */
        public static com.infotec.eworkplace.swb.SedeRecurso getSedeRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SedeRecurso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SedeRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.SedeRecurso
       * @param model Model of the com.infotec.eworkplace.swb.SedeRecurso
       * @return A com.infotec.eworkplace.swb.SedeRecurso
       */
        public static com.infotec.eworkplace.swb.SedeRecurso createSedeRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SedeRecurso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SedeRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.SedeRecurso
       * @param model Model of the com.infotec.eworkplace.swb.SedeRecurso
       */
        public static void removeSedeRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SedeRecurso
       * @param id Identifier for com.infotec.eworkplace.swb.SedeRecurso
       * @param model Model of the com.infotec.eworkplace.swb.SedeRecurso
       * @return true if the com.infotec.eworkplace.swb.SedeRecurso exists, false otherwise
       */

        public static boolean hasSedeRecurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSedeRecurso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SedeRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SedeRecurso
       * @return Iterator with all the com.infotec.eworkplace.swb.SedeRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SedeRecurso> listSedeRecursoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SedeRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SedeRecurso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SedeRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SedeRecurso> listSedeRecursoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SedeRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SedeRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SedeRecurso
       * @return Iterator with all the com.infotec.eworkplace.swb.SedeRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SedeRecurso> listSedeRecursoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SedeRecurso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SedeRecurso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SedeRecurso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SedeRecurso> listSedeRecursoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SedeRecurso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static SedeRecursoBase.ClassMgr getSedeRecursoClassMgr()
    {
        return new SedeRecursoBase.ClassMgr();
    }

   /**
   * Constructs a SedeRecursoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SedeRecurso
   */
    public SedeRecursoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
