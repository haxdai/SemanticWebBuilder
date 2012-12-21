package mx.gob.inmujeres.swb.base;


public abstract class MetaEvaluacionBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty inm_meta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#meta");
    public static final org.semanticwb.platform.SemanticClass inm_TipoMedida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoMedida");
    public static final org.semanticwb.platform.SemanticProperty inm_medida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#medida");
    public static final org.semanticwb.platform.SemanticClass inm_MetaEvaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#MetaEvaluacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#MetaEvaluacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of MetaEvaluacion for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.MetaEvaluacion for all models
       * @return Iterator of mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion>(it, true);
        }

        public static mx.gob.inmujeres.swb.MetaEvaluacion createMetaEvaluacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.MetaEvaluacion.ClassMgr.createMetaEvaluacion(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.MetaEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.MetaEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.MetaEvaluacion
       * @return A mx.gob.inmujeres.swb.MetaEvaluacion
       */
        public static mx.gob.inmujeres.swb.MetaEvaluacion getMetaEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.MetaEvaluacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.MetaEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.MetaEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.MetaEvaluacion
       * @return A mx.gob.inmujeres.swb.MetaEvaluacion
       */
        public static mx.gob.inmujeres.swb.MetaEvaluacion createMetaEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.MetaEvaluacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.MetaEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.MetaEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.MetaEvaluacion
       */
        public static void removeMetaEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.MetaEvaluacion
       * @param id Identifier for mx.gob.inmujeres.swb.MetaEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.MetaEvaluacion
       * @return true if the mx.gob.inmujeres.swb.MetaEvaluacion exists, false otherwise
       */

        public static boolean hasMetaEvaluacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMetaEvaluacion(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.MetaEvaluacion with a determined Medida
       * @param value Medida of the type mx.gob.inmujeres.swb.TipoMedida
       * @param model Model of the mx.gob.inmujeres.swb.MetaEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacionByMedida(mx.gob.inmujeres.swb.TipoMedida value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_medida, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.MetaEvaluacion with a determined Medida
       * @param value Medida of the type mx.gob.inmujeres.swb.TipoMedida
       * @return Iterator with all the mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacionByMedida(mx.gob.inmujeres.swb.TipoMedida value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_medida,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static MetaEvaluacionBase.ClassMgr getMetaEvaluacionClassMgr()
    {
        return new MetaEvaluacionBase.ClassMgr();
    }

   /**
   * Constructs a MetaEvaluacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the MetaEvaluacion
   */
    public MetaEvaluacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Meta property
* @return String with the Meta
*/
    public String getMeta()
    {
        return getSemanticObject().getProperty(inm_meta);
    }

/**
* Sets the Meta property
* @param value long with the Meta
*/
    public void setMeta(String value)
    {
        getSemanticObject().setProperty(inm_meta, value);
    }
   /**
   * Sets the value for the property Medida
   * @param value Medida to set
   */

    public void setMedida(mx.gob.inmujeres.swb.TipoMedida value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_medida, value.getSemanticObject());
        }else
        {
            removeMedida();
        }
    }
   /**
   * Remove the value for Medida property
   */

    public void removeMedida()
    {
        getSemanticObject().removeProperty(inm_medida);
    }

   /**
   * Gets the Medida
   * @return a mx.gob.inmujeres.swb.TipoMedida
   */
    public mx.gob.inmujeres.swb.TipoMedida getMedida()
    {
         mx.gob.inmujeres.swb.TipoMedida ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_medida);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoMedida)obj.createGenericInstance();
         }
         return ret;
    }
}
