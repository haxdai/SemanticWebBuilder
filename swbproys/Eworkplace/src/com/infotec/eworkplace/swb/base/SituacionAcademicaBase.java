package com.infotec.eworkplace.swb.base;


public abstract class SituacionAcademicaBase extends com.infotec.eworkplace.swb.Catalogo implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_SituacionAcademica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SituacionAcademica");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SituacionAcademica");

    public static class ClassMgr
    {
       /**
       * Returns a list of SituacionAcademica for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SituacionAcademica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SituacionAcademica> listSituacionAcademicas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SituacionAcademica>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SituacionAcademica for all models
       * @return Iterator of com.infotec.eworkplace.swb.SituacionAcademica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SituacionAcademica> listSituacionAcademicas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SituacionAcademica>(it, true);
        }

        public static com.infotec.eworkplace.swb.SituacionAcademica createSituacionAcademica(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.SituacionAcademica.ClassMgr.createSituacionAcademica(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SituacionAcademica
       * @param id Identifier for com.infotec.eworkplace.swb.SituacionAcademica
       * @param model Model of the com.infotec.eworkplace.swb.SituacionAcademica
       * @return A com.infotec.eworkplace.swb.SituacionAcademica
       */
        public static com.infotec.eworkplace.swb.SituacionAcademica getSituacionAcademica(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SituacionAcademica)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SituacionAcademica
       * @param id Identifier for com.infotec.eworkplace.swb.SituacionAcademica
       * @param model Model of the com.infotec.eworkplace.swb.SituacionAcademica
       * @return A com.infotec.eworkplace.swb.SituacionAcademica
       */
        public static com.infotec.eworkplace.swb.SituacionAcademica createSituacionAcademica(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SituacionAcademica)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SituacionAcademica
       * @param id Identifier for com.infotec.eworkplace.swb.SituacionAcademica
       * @param model Model of the com.infotec.eworkplace.swb.SituacionAcademica
       */
        public static void removeSituacionAcademica(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SituacionAcademica
       * @param id Identifier for com.infotec.eworkplace.swb.SituacionAcademica
       * @param model Model of the com.infotec.eworkplace.swb.SituacionAcademica
       * @return true if the com.infotec.eworkplace.swb.SituacionAcademica exists, false otherwise
       */

        public static boolean hasSituacionAcademica(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSituacionAcademica(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SituacionAcademica with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SituacionAcademica
       * @return Iterator with all the com.infotec.eworkplace.swb.SituacionAcademica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SituacionAcademica> listSituacionAcademicaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SituacionAcademica> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SituacionAcademica with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SituacionAcademica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SituacionAcademica> listSituacionAcademicaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SituacionAcademica> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SituacionAcademica with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.SituacionAcademica
       * @return Iterator with all the com.infotec.eworkplace.swb.SituacionAcademica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SituacionAcademica> listSituacionAcademicaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SituacionAcademica> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.SituacionAcademica with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.SituacionAcademica
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SituacionAcademica> listSituacionAcademicaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SituacionAcademica> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a SituacionAcademicaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SituacionAcademica
   */
    public SituacionAcademicaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
