package mx.gob.inmujeres.swb.base;


public abstract class TemasProgramaBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_TemasPrograma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TemasPrograma");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TemasPrograma");

    public static class ClassMgr
    {
       /**
       * Returns a list of TemasPrograma for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.TemasPrograma
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TemasPrograma> listTemasProgramas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TemasPrograma>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.TemasPrograma for all models
       * @return Iterator of mx.gob.inmujeres.swb.TemasPrograma
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TemasPrograma> listTemasProgramas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TemasPrograma>(it, true);
        }

        public static mx.gob.inmujeres.swb.TemasPrograma createTemasPrograma(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.TemasPrograma.ClassMgr.createTemasPrograma(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.TemasPrograma
       * @param id Identifier for mx.gob.inmujeres.swb.TemasPrograma
       * @param model Model of the mx.gob.inmujeres.swb.TemasPrograma
       * @return A mx.gob.inmujeres.swb.TemasPrograma
       */
        public static mx.gob.inmujeres.swb.TemasPrograma getTemasPrograma(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TemasPrograma)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.TemasPrograma
       * @param id Identifier for mx.gob.inmujeres.swb.TemasPrograma
       * @param model Model of the mx.gob.inmujeres.swb.TemasPrograma
       * @return A mx.gob.inmujeres.swb.TemasPrograma
       */
        public static mx.gob.inmujeres.swb.TemasPrograma createTemasPrograma(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TemasPrograma)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.TemasPrograma
       * @param id Identifier for mx.gob.inmujeres.swb.TemasPrograma
       * @param model Model of the mx.gob.inmujeres.swb.TemasPrograma
       */
        public static void removeTemasPrograma(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.TemasPrograma
       * @param id Identifier for mx.gob.inmujeres.swb.TemasPrograma
       * @param model Model of the mx.gob.inmujeres.swb.TemasPrograma
       * @return true if the mx.gob.inmujeres.swb.TemasPrograma exists, false otherwise
       */

        public static boolean hasTemasPrograma(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTemasPrograma(id, model)!=null);
        }
    }

    public static TemasProgramaBase.ClassMgr getTemasProgramaClassMgr()
    {
        return new TemasProgramaBase.ClassMgr();
    }

   /**
   * Constructs a TemasProgramaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TemasPrograma
   */
    public TemasProgramaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
