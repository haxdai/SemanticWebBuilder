package mx.gob.inmujeres.swb.base;


public abstract class EvaluacionCuestionarioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass inm_Respuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Respuesta");
    public static final org.semanticwb.platform.SemanticProperty inm_hasRespuestas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasRespuestas");
    public static final org.semanticwb.platform.SemanticClass inm_EvaluacionCuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#EvaluacionCuestionario");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#EvaluacionCuestionario");

    public static class ClassMgr
    {
       /**
       * Returns a list of EvaluacionCuestionario for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.EvaluacionCuestionario for all models
       * @return Iterator of mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario>(it, true);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @return A mx.gob.inmujeres.swb.EvaluacionCuestionario
       */
        public static mx.gob.inmujeres.swb.EvaluacionCuestionario getEvaluacionCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.EvaluacionCuestionario)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @return A mx.gob.inmujeres.swb.EvaluacionCuestionario
       */
        public static mx.gob.inmujeres.swb.EvaluacionCuestionario createEvaluacionCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.EvaluacionCuestionario)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionCuestionario
       */
        public static void removeEvaluacionCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @return true if the mx.gob.inmujeres.swb.EvaluacionCuestionario exists, false otherwise
       */

        public static boolean hasEvaluacionCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEvaluacionCuestionario(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionCuestionario with a determined Respuestas
       * @param value Respuestas of the type mx.gob.inmujeres.swb.Respuesta
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarioByRespuestas(mx.gob.inmujeres.swb.Respuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_hasRespuestas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionCuestionario with a determined Respuestas
       * @param value Respuestas of the type mx.gob.inmujeres.swb.Respuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarioByRespuestas(mx.gob.inmujeres.swb.Respuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_hasRespuestas,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static EvaluacionCuestionarioBase.ClassMgr getEvaluacionCuestionarioClassMgr()
    {
        return new EvaluacionCuestionarioBase.ClassMgr();
    }

   /**
   * Constructs a EvaluacionCuestionarioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EvaluacionCuestionario
   */
    public EvaluacionCuestionarioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the mx.gob.inmujeres.swb.Respuesta
   * @return A GenericIterator with all the mx.gob.inmujeres.swb.Respuesta
   */

    public org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta> listRespuestases()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta>(getSemanticObject().listObjectProperties(inm_hasRespuestas));
    }

   /**
   * Gets true if has a Respuestas
   * @param value mx.gob.inmujeres.swb.Respuesta to verify
   * @return true if the mx.gob.inmujeres.swb.Respuesta exists, false otherwise
   */
    public boolean hasRespuestas(mx.gob.inmujeres.swb.Respuesta value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_hasRespuestas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Respuestas
   * @param value mx.gob.inmujeres.swb.Respuesta to add
   */

    public void addRespuestas(mx.gob.inmujeres.swb.Respuesta value)
    {
        getSemanticObject().addObjectProperty(inm_hasRespuestas, value.getSemanticObject());
    }
   /**
   * Removes all the Respuestas
   */

    public void removeAllRespuestas()
    {
        getSemanticObject().removeProperty(inm_hasRespuestas);
    }
   /**
   * Removes a Respuestas
   * @param value mx.gob.inmujeres.swb.Respuesta to remove
   */

    public void removeRespuestas(mx.gob.inmujeres.swb.Respuesta value)
    {
        getSemanticObject().removeObjectProperty(inm_hasRespuestas,value.getSemanticObject());
    }

   /**
   * Gets the Respuestas
   * @return a mx.gob.inmujeres.swb.Respuesta
   */
    public mx.gob.inmujeres.swb.Respuesta getRespuestas()
    {
         mx.gob.inmujeres.swb.Respuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_hasRespuestas);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Respuesta)obj.createGenericInstance();
         }
         return ret;
    }
}
