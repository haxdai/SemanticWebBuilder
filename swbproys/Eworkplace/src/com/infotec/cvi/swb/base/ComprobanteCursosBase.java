package com.infotec.cvi.swb.base;


public abstract class ComprobanteCursosBase extends com.infotec.cvi.swb.DocumentoProbatorio implements com.infotec.cvi.swb.Documento,org.semanticwb.model.Traceable,org.semanticwb.model.Iconable
{
    public static final org.semanticwb.platform.SemanticClass intranet_ComprobanteCursos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ComprobanteCursos");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ComprobanteCursos");

    public static class ClassMgr
    {
       /**
       * Returns a list of ComprobanteCursos for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.ComprobanteCursos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteCursos> listComprobanteCursoses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteCursos>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.ComprobanteCursos for all models
       * @return Iterator of com.infotec.cvi.swb.ComprobanteCursos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteCursos> listComprobanteCursoses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteCursos>(it, true);
        }

        public static com.infotec.cvi.swb.ComprobanteCursos createComprobanteCursos(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.ComprobanteCursos.ClassMgr.createComprobanteCursos(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.ComprobanteCursos
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteCursos
       * @param model Model of the com.infotec.cvi.swb.ComprobanteCursos
       * @return A com.infotec.cvi.swb.ComprobanteCursos
       */
        public static com.infotec.cvi.swb.ComprobanteCursos getComprobanteCursos(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ComprobanteCursos)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.ComprobanteCursos
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteCursos
       * @param model Model of the com.infotec.cvi.swb.ComprobanteCursos
       * @return A com.infotec.cvi.swb.ComprobanteCursos
       */
        public static com.infotec.cvi.swb.ComprobanteCursos createComprobanteCursos(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.ComprobanteCursos)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.ComprobanteCursos
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteCursos
       * @param model Model of the com.infotec.cvi.swb.ComprobanteCursos
       */
        public static void removeComprobanteCursos(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.ComprobanteCursos
       * @param id Identifier for com.infotec.cvi.swb.ComprobanteCursos
       * @param model Model of the com.infotec.cvi.swb.ComprobanteCursos
       * @return true if the com.infotec.cvi.swb.ComprobanteCursos exists, false otherwise
       */

        public static boolean hasComprobanteCursos(String id, org.semanticwb.model.SWBModel model)
        {
            return (getComprobanteCursos(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteCursos with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ComprobanteCursos
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteCursos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteCursos> listComprobanteCursosByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteCursos> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteCursos with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteCursos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteCursos> listComprobanteCursosByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteCursos> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteCursos with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.ComprobanteCursos
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteCursos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteCursos> listComprobanteCursosByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteCursos> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.ComprobanteCursos with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.ComprobanteCursos
       */

        public static java.util.Iterator<com.infotec.cvi.swb.ComprobanteCursos> listComprobanteCursosByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.ComprobanteCursos> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a ComprobanteCursosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the ComprobanteCursos
   */
    public ComprobanteCursosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
