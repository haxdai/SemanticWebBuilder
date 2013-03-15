package mx.gob.inmujeres.swb.base;


public abstract class TipoMedidaBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_TipoMedida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoMedida");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoMedida");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoMedida for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.TipoMedida
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TipoMedida> listTipoMedidas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TipoMedida>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.TipoMedida for all models
       * @return Iterator of mx.gob.inmujeres.swb.TipoMedida
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TipoMedida> listTipoMedidas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TipoMedida>(it, true);
        }

        public static mx.gob.inmujeres.swb.TipoMedida createTipoMedida(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.TipoMedida.ClassMgr.createTipoMedida(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.TipoMedida
       * @param id Identifier for mx.gob.inmujeres.swb.TipoMedida
       * @param model Model of the mx.gob.inmujeres.swb.TipoMedida
       * @return A mx.gob.inmujeres.swb.TipoMedida
       */
        public static mx.gob.inmujeres.swb.TipoMedida getTipoMedida(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TipoMedida)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.TipoMedida
       * @param id Identifier for mx.gob.inmujeres.swb.TipoMedida
       * @param model Model of the mx.gob.inmujeres.swb.TipoMedida
       * @return A mx.gob.inmujeres.swb.TipoMedida
       */
        public static mx.gob.inmujeres.swb.TipoMedida createTipoMedida(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TipoMedida)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.TipoMedida
       * @param id Identifier for mx.gob.inmujeres.swb.TipoMedida
       * @param model Model of the mx.gob.inmujeres.swb.TipoMedida
       */
        public static void removeTipoMedida(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.TipoMedida
       * @param id Identifier for mx.gob.inmujeres.swb.TipoMedida
       * @param model Model of the mx.gob.inmujeres.swb.TipoMedida
       * @return true if the mx.gob.inmujeres.swb.TipoMedida exists, false otherwise
       */

        public static boolean hasTipoMedida(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoMedida(id, model)!=null);
        }
    }

   /**
   * Constructs a TipoMedidaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoMedida
   */
    public TipoMedidaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
