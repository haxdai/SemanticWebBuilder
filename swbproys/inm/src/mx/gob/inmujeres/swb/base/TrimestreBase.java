package mx.gob.inmujeres.swb.base;


public abstract class TrimestreBase extends mx.gob.inmujeres.swb.Catalogo implements org.semanticwb.model.Sortable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_Trimestre=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Trimestre");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Trimestre");

    public static class ClassMgr
    {
       /**
       * Returns a list of Trimestre for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Trimestre
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Trimestre> listTrimestres(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Trimestre>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Trimestre for all models
       * @return Iterator of mx.gob.inmujeres.swb.Trimestre
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Trimestre> listTrimestres()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Trimestre>(it, true);
        }

        public static mx.gob.inmujeres.swb.Trimestre createTrimestre(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Trimestre.ClassMgr.createTrimestre(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Trimestre
       * @param id Identifier for mx.gob.inmujeres.swb.Trimestre
       * @param model Model of the mx.gob.inmujeres.swb.Trimestre
       * @return A mx.gob.inmujeres.swb.Trimestre
       */
        public static mx.gob.inmujeres.swb.Trimestre getTrimestre(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Trimestre)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Trimestre
       * @param id Identifier for mx.gob.inmujeres.swb.Trimestre
       * @param model Model of the mx.gob.inmujeres.swb.Trimestre
       * @return A mx.gob.inmujeres.swb.Trimestre
       */
        public static mx.gob.inmujeres.swb.Trimestre createTrimestre(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Trimestre)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Trimestre
       * @param id Identifier for mx.gob.inmujeres.swb.Trimestre
       * @param model Model of the mx.gob.inmujeres.swb.Trimestre
       */
        public static void removeTrimestre(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Trimestre
       * @param id Identifier for mx.gob.inmujeres.swb.Trimestre
       * @param model Model of the mx.gob.inmujeres.swb.Trimestre
       * @return true if the mx.gob.inmujeres.swb.Trimestre exists, false otherwise
       */

        public static boolean hasTrimestre(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTrimestre(id, model)!=null);
        }
    }

    public static TrimestreBase.ClassMgr getTrimestreClassMgr()
    {
        return new TrimestreBase.ClassMgr();
    }

   /**
   * Constructs a TrimestreBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Trimestre
   */
    public TrimestreBase(org.semanticwb.platform.SemanticObject base)
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
