package mx.gob.inmujeres.swb.base;


public abstract class CentroCostosBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_CentroCostos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#CentroCostos");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#CentroCostos");

    public static class ClassMgr
    {
       /**
       * Returns a list of CentroCostos for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.CentroCostos
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CentroCostos> listCentroCostoses(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CentroCostos>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.CentroCostos for all models
       * @return Iterator of mx.gob.inmujeres.swb.CentroCostos
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.CentroCostos> listCentroCostoses()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CentroCostos>(it, true);
        }

        public static mx.gob.inmujeres.swb.CentroCostos createCentroCostos(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.CentroCostos.ClassMgr.createCentroCostos(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.CentroCostos
       * @param id Identifier for mx.gob.inmujeres.swb.CentroCostos
       * @param model Model of the mx.gob.inmujeres.swb.CentroCostos
       * @return A mx.gob.inmujeres.swb.CentroCostos
       */
        public static mx.gob.inmujeres.swb.CentroCostos getCentroCostos(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.CentroCostos)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.CentroCostos
       * @param id Identifier for mx.gob.inmujeres.swb.CentroCostos
       * @param model Model of the mx.gob.inmujeres.swb.CentroCostos
       * @return A mx.gob.inmujeres.swb.CentroCostos
       */
        public static mx.gob.inmujeres.swb.CentroCostos createCentroCostos(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.CentroCostos)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.CentroCostos
       * @param id Identifier for mx.gob.inmujeres.swb.CentroCostos
       * @param model Model of the mx.gob.inmujeres.swb.CentroCostos
       */
        public static void removeCentroCostos(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.CentroCostos
       * @param id Identifier for mx.gob.inmujeres.swb.CentroCostos
       * @param model Model of the mx.gob.inmujeres.swb.CentroCostos
       * @return true if the mx.gob.inmujeres.swb.CentroCostos exists, false otherwise
       */

        public static boolean hasCentroCostos(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCentroCostos(id, model)!=null);
        }
    }

   /**
   * Constructs a CentroCostosBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CentroCostos
   */
    public CentroCostosBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
