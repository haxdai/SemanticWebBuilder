package mx.gob.inmujeres.swb.base;


public abstract class TipoNivelGestionBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_TipoNivelGestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoNivelGestion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoNivelGestion");

    public static class ClassMgr
    {
       /**
       * Returns a list of TipoNivelGestion for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.TipoNivelGestion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TipoNivelGestion> listTipoNivelGestions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TipoNivelGestion>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.TipoNivelGestion for all models
       * @return Iterator of mx.gob.inmujeres.swb.TipoNivelGestion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TipoNivelGestion> listTipoNivelGestions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TipoNivelGestion>(it, true);
        }

        public static mx.gob.inmujeres.swb.TipoNivelGestion createTipoNivelGestion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.TipoNivelGestion.ClassMgr.createTipoNivelGestion(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.TipoNivelGestion
       * @param id Identifier for mx.gob.inmujeres.swb.TipoNivelGestion
       * @param model Model of the mx.gob.inmujeres.swb.TipoNivelGestion
       * @return A mx.gob.inmujeres.swb.TipoNivelGestion
       */
        public static mx.gob.inmujeres.swb.TipoNivelGestion getTipoNivelGestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TipoNivelGestion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.TipoNivelGestion
       * @param id Identifier for mx.gob.inmujeres.swb.TipoNivelGestion
       * @param model Model of the mx.gob.inmujeres.swb.TipoNivelGestion
       * @return A mx.gob.inmujeres.swb.TipoNivelGestion
       */
        public static mx.gob.inmujeres.swb.TipoNivelGestion createTipoNivelGestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TipoNivelGestion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.TipoNivelGestion
       * @param id Identifier for mx.gob.inmujeres.swb.TipoNivelGestion
       * @param model Model of the mx.gob.inmujeres.swb.TipoNivelGestion
       */
        public static void removeTipoNivelGestion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.TipoNivelGestion
       * @param id Identifier for mx.gob.inmujeres.swb.TipoNivelGestion
       * @param model Model of the mx.gob.inmujeres.swb.TipoNivelGestion
       * @return true if the mx.gob.inmujeres.swb.TipoNivelGestion exists, false otherwise
       */

        public static boolean hasTipoNivelGestion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTipoNivelGestion(id, model)!=null);
        }
    }

    public static TipoNivelGestionBase.ClassMgr getTipoNivelGestionClassMgr()
    {
        return new TipoNivelGestionBase.ClassMgr();
    }

   /**
   * Constructs a TipoNivelGestionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TipoNivelGestion
   */
    public TipoNivelGestionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
