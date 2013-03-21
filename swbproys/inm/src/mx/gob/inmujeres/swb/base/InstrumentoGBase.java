package mx.gob.inmujeres.swb.base;


public abstract class InstrumentoGBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Sortable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_InstrumentoG=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#InstrumentoG");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#InstrumentoG");

    public static class ClassMgr
    {
       /**
       * Returns a list of InstrumentoG for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.InstrumentoG
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.InstrumentoG> listInstrumentoGs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.InstrumentoG>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.InstrumentoG for all models
       * @return Iterator of mx.gob.inmujeres.swb.InstrumentoG
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.InstrumentoG> listInstrumentoGs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.InstrumentoG>(it, true);
        }

        public static mx.gob.inmujeres.swb.InstrumentoG createInstrumentoG(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.InstrumentoG.ClassMgr.createInstrumentoG(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.InstrumentoG
       * @param id Identifier for mx.gob.inmujeres.swb.InstrumentoG
       * @param model Model of the mx.gob.inmujeres.swb.InstrumentoG
       * @return A mx.gob.inmujeres.swb.InstrumentoG
       */
        public static mx.gob.inmujeres.swb.InstrumentoG getInstrumentoG(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.InstrumentoG)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.InstrumentoG
       * @param id Identifier for mx.gob.inmujeres.swb.InstrumentoG
       * @param model Model of the mx.gob.inmujeres.swb.InstrumentoG
       * @return A mx.gob.inmujeres.swb.InstrumentoG
       */
        public static mx.gob.inmujeres.swb.InstrumentoG createInstrumentoG(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.InstrumentoG)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.InstrumentoG
       * @param id Identifier for mx.gob.inmujeres.swb.InstrumentoG
       * @param model Model of the mx.gob.inmujeres.swb.InstrumentoG
       */
        public static void removeInstrumentoG(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.InstrumentoG
       * @param id Identifier for mx.gob.inmujeres.swb.InstrumentoG
       * @param model Model of the mx.gob.inmujeres.swb.InstrumentoG
       * @return true if the mx.gob.inmujeres.swb.InstrumentoG exists, false otherwise
       */

        public static boolean hasInstrumentoG(String id, org.semanticwb.model.SWBModel model)
        {
            return (getInstrumentoG(id, model)!=null);
        }
    }

    public static InstrumentoGBase.ClassMgr getInstrumentoGClassMgr()
    {
        return new InstrumentoGBase.ClassMgr();
    }

   /**
   * Constructs a InstrumentoGBase with a SemanticObject
   * @param base The SemanticObject with the properties for the InstrumentoG
   */
    public InstrumentoGBase(org.semanticwb.platform.SemanticObject base)
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
