package mx.gob.inmujeres.swb.base;


public abstract class TipoRespuestaBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty inm_valor=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#valor");
    public static final org.semanticwb.platform.SemanticClass inm_TipoRespuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoRespuesta");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoRespuesta");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoRespuesta for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.TipoRespuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TipoRespuesta> listTipoRespuestas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TipoRespuesta>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.TipoRespuesta for all models
       * @return Iterator of mx.gob.inmujeres.swb.TipoRespuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TipoRespuesta> listTipoRespuestas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TipoRespuesta>(it, true);
        }

        public static mx.gob.inmujeres.swb.TipoRespuesta createTipoRespuesta(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.TipoRespuesta.ClassMgr.createTipoRespuesta(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.TipoRespuesta
       * @param id Identifier for mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.TipoRespuesta
       * @return A mx.gob.inmujeres.swb.TipoRespuesta
       */
        public static mx.gob.inmujeres.swb.TipoRespuesta getTipoRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TipoRespuesta)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.TipoRespuesta
       * @param id Identifier for mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.TipoRespuesta
       * @return A mx.gob.inmujeres.swb.TipoRespuesta
       */
        public static mx.gob.inmujeres.swb.TipoRespuesta createTipoRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TipoRespuesta)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.TipoRespuesta
       * @param id Identifier for mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.TipoRespuesta
       */
        public static void removeTipoRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.TipoRespuesta
       * @param id Identifier for mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.TipoRespuesta
       * @return true if the mx.gob.inmujeres.swb.TipoRespuesta exists, false otherwise
       */

        public static boolean hasTipoRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoRespuesta(id, model)!=null);
        }
    }

   /**
   * Constructs a TipoRespuestaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoRespuesta
   */
    public TipoRespuestaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Valor property
* @return int with the Valor
*/
    public int getValor()
    {
        return getSemanticObject().getIntProperty(inm_valor);
    }

/**
* Sets the Valor property
* @param value long with the Valor
*/
    public void setValor(int value)
    {
        getSemanticObject().setIntProperty(inm_valor, value);
    }
}
