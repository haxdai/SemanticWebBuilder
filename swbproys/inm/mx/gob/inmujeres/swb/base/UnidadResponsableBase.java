package mx.gob.inmujeres.swb.base;


public abstract class UnidadResponsableBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_UnidadResponsable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#UnidadResponsable");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#UnidadResponsable");

    public static class ClassMgr
    {
       /**
       * Returns a list of UnidadResponsable for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.UnidadResponsable
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.UnidadResponsable> listUnidadResponsables(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.UnidadResponsable>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.UnidadResponsable for all models
       * @return Iterator of mx.gob.inmujeres.swb.UnidadResponsable
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.UnidadResponsable> listUnidadResponsables()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.UnidadResponsable>(it, true);
        }

        public static mx.gob.inmujeres.swb.UnidadResponsable createUnidadResponsable(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.UnidadResponsable.ClassMgr.createUnidadResponsable(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.UnidadResponsable
       * @param id Identifier for mx.gob.inmujeres.swb.UnidadResponsable
       * @param model Model of the mx.gob.inmujeres.swb.UnidadResponsable
       * @return A mx.gob.inmujeres.swb.UnidadResponsable
       */
        public static mx.gob.inmujeres.swb.UnidadResponsable getUnidadResponsable(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.UnidadResponsable)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.UnidadResponsable
       * @param id Identifier for mx.gob.inmujeres.swb.UnidadResponsable
       * @param model Model of the mx.gob.inmujeres.swb.UnidadResponsable
       * @return A mx.gob.inmujeres.swb.UnidadResponsable
       */
        public static mx.gob.inmujeres.swb.UnidadResponsable createUnidadResponsable(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.UnidadResponsable)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.UnidadResponsable
       * @param id Identifier for mx.gob.inmujeres.swb.UnidadResponsable
       * @param model Model of the mx.gob.inmujeres.swb.UnidadResponsable
       */
        public static void removeUnidadResponsable(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.UnidadResponsable
       * @param id Identifier for mx.gob.inmujeres.swb.UnidadResponsable
       * @param model Model of the mx.gob.inmujeres.swb.UnidadResponsable
       * @return true if the mx.gob.inmujeres.swb.UnidadResponsable exists, false otherwise
       */

        public static boolean hasUnidadResponsable(String id, org.semanticwb.model.SWBModel model)
        {
            return (getUnidadResponsable(id, model)!=null);
        }
    }

   /**
   * Constructs a UnidadResponsableBase with a SemanticObject
   * @param base The SemanticObject with the properties for the UnidadResponsable
   */
    public UnidadResponsableBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
