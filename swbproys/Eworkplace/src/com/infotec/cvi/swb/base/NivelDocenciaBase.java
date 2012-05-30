package com.infotec.cvi.swb.base;


   /**
   * Catálogo utilizado para indicar el nivel en el cual se a impartido cursos en Docencia 
   */
public abstract class NivelDocenciaBase extends com.infotec.cvi.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
   /**
   * Catálogo utilizado para indicar el nivel en el cual se a impartido cursos en Docencia
   */
    public static final org.semanticwb.platform.SemanticClass intranet_NivelDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#NivelDocencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#NivelDocencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of NivelDocencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.NivelDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.NivelDocencia> listNivelDocencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.NivelDocencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.NivelDocencia for all models
       * @return Iterator of com.infotec.cvi.swb.NivelDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.NivelDocencia> listNivelDocencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.NivelDocencia>(it, true);
        }

        public static com.infotec.cvi.swb.NivelDocencia createNivelDocencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.NivelDocencia.ClassMgr.createNivelDocencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.NivelDocencia
       * @param id Identifier for com.infotec.cvi.swb.NivelDocencia
       * @param model Model of the com.infotec.cvi.swb.NivelDocencia
       * @return A com.infotec.cvi.swb.NivelDocencia
       */
        public static com.infotec.cvi.swb.NivelDocencia getNivelDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.NivelDocencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.NivelDocencia
       * @param id Identifier for com.infotec.cvi.swb.NivelDocencia
       * @param model Model of the com.infotec.cvi.swb.NivelDocencia
       * @return A com.infotec.cvi.swb.NivelDocencia
       */
        public static com.infotec.cvi.swb.NivelDocencia createNivelDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.NivelDocencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.NivelDocencia
       * @param id Identifier for com.infotec.cvi.swb.NivelDocencia
       * @param model Model of the com.infotec.cvi.swb.NivelDocencia
       */
        public static void removeNivelDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.NivelDocencia
       * @param id Identifier for com.infotec.cvi.swb.NivelDocencia
       * @param model Model of the com.infotec.cvi.swb.NivelDocencia
       * @return true if the com.infotec.cvi.swb.NivelDocencia exists, false otherwise
       */

        public static boolean hasNivelDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNivelDocencia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.NivelDocencia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.NivelDocencia
       * @return Iterator with all the com.infotec.cvi.swb.NivelDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.NivelDocencia> listNivelDocenciaByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.NivelDocencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.NivelDocencia with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.NivelDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.NivelDocencia> listNivelDocenciaByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.NivelDocencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.NivelDocencia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.NivelDocencia
       * @return Iterator with all the com.infotec.cvi.swb.NivelDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.NivelDocencia> listNivelDocenciaByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.NivelDocencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.NivelDocencia with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.NivelDocencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.NivelDocencia> listNivelDocenciaByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.NivelDocencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a NivelDocenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the NivelDocencia
   */
    public NivelDocenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
