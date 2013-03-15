package mx.gob.inmujeres.swb.base;


public abstract class MontajeBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_Montaje=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Montaje");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Montaje");

    public static class ClassMgr
    {
       /**
       * Returns a list of Montaje for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Montaje
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Montaje> listMontajes(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Montaje>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Montaje for all models
       * @return Iterator of mx.gob.inmujeres.swb.Montaje
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Montaje> listMontajes()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Montaje>(it, true);
        }

        public static mx.gob.inmujeres.swb.Montaje createMontaje(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Montaje.ClassMgr.createMontaje(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Montaje
       * @param id Identifier for mx.gob.inmujeres.swb.Montaje
       * @param model Model of the mx.gob.inmujeres.swb.Montaje
       * @return A mx.gob.inmujeres.swb.Montaje
       */
        public static mx.gob.inmujeres.swb.Montaje getMontaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Montaje)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Montaje
       * @param id Identifier for mx.gob.inmujeres.swb.Montaje
       * @param model Model of the mx.gob.inmujeres.swb.Montaje
       * @return A mx.gob.inmujeres.swb.Montaje
       */
        public static mx.gob.inmujeres.swb.Montaje createMontaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Montaje)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Montaje
       * @param id Identifier for mx.gob.inmujeres.swb.Montaje
       * @param model Model of the mx.gob.inmujeres.swb.Montaje
       */
        public static void removeMontaje(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Montaje
       * @param id Identifier for mx.gob.inmujeres.swb.Montaje
       * @param model Model of the mx.gob.inmujeres.swb.Montaje
       * @return true if the mx.gob.inmujeres.swb.Montaje exists, false otherwise
       */

        public static boolean hasMontaje(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMontaje(id, model)!=null);
        }
    }

   /**
   * Constructs a MontajeBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Montaje
   */
    public MontajeBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
}
