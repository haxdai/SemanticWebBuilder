package mx.gob.inmujeres.swb.base;


public abstract class TiempoRLBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Sortable
{
    public static final org.semanticwb.platform.SemanticClass inm_TiempoRL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TiempoRL");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TiempoRL");

    public static class ClassMgr
    {
       /**
       * Returns a list of TiempoRL for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.TiempoRL
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TiempoRL> listTiempoRLs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TiempoRL>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.TiempoRL for all models
       * @return Iterator of mx.gob.inmujeres.swb.TiempoRL
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.TiempoRL> listTiempoRLs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.TiempoRL>(it, true);
        }

        public static mx.gob.inmujeres.swb.TiempoRL createTiempoRL(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.TiempoRL.ClassMgr.createTiempoRL(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.TiempoRL
       * @param id Identifier for mx.gob.inmujeres.swb.TiempoRL
       * @param model Model of the mx.gob.inmujeres.swb.TiempoRL
       * @return A mx.gob.inmujeres.swb.TiempoRL
       */
        public static mx.gob.inmujeres.swb.TiempoRL getTiempoRL(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TiempoRL)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.TiempoRL
       * @param id Identifier for mx.gob.inmujeres.swb.TiempoRL
       * @param model Model of the mx.gob.inmujeres.swb.TiempoRL
       * @return A mx.gob.inmujeres.swb.TiempoRL
       */
        public static mx.gob.inmujeres.swb.TiempoRL createTiempoRL(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.TiempoRL)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.TiempoRL
       * @param id Identifier for mx.gob.inmujeres.swb.TiempoRL
       * @param model Model of the mx.gob.inmujeres.swb.TiempoRL
       */
        public static void removeTiempoRL(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.TiempoRL
       * @param id Identifier for mx.gob.inmujeres.swb.TiempoRL
       * @param model Model of the mx.gob.inmujeres.swb.TiempoRL
       * @return true if the mx.gob.inmujeres.swb.TiempoRL exists, false otherwise
       */

        public static boolean hasTiempoRL(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTiempoRL(id, model)!=null);
        }
    }

    public static TiempoRLBase.ClassMgr getTiempoRLClassMgr()
    {
        return new TiempoRLBase.ClassMgr();
    }

   /**
   * Constructs a TiempoRLBase with a SemanticObject
   * @param base The SemanticObject with the properties for the TiempoRL
   */
    public TiempoRLBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Index property
* @return int with the Index
*/
    public int getIndex()
    {
        return getSemanticObject().getIntProperty(swb_index);
    }

/**
* Sets the Index property
* @param value long with the Index
*/
    public void setIndex(int value)
    {
        getSemanticObject().setIntProperty(swb_index, value);
    }
}
