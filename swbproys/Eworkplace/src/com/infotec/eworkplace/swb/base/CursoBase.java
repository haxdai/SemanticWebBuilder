package com.infotec.eworkplace.swb.base;


public abstract class CursoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Curso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Curso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Curso");

    public static class ClassMgr
    {
       /**
       * Returns a list of Curso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Curso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Curso> listCursos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Curso>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Curso for all models
       * @return Iterator of com.infotec.eworkplace.swb.Curso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Curso> listCursos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Curso>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       * @return A com.infotec.eworkplace.swb.Curso
       */
        public static com.infotec.eworkplace.swb.Curso getCurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Curso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       * @return A com.infotec.eworkplace.swb.Curso
       */
        public static com.infotec.eworkplace.swb.Curso createCurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Curso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       */
        public static void removeCurso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       * @return true if the com.infotec.eworkplace.swb.Curso exists, false otherwise
       */

        public static boolean hasCurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCurso(id, model)!=null);
        }
    }

   /**
   * Constructs a CursoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Curso
   */
    public CursoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
