package mx.gob.inmujeres.swb.base;


public abstract class EvaluacionCuestionarioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass inm_Respuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Respuesta");
    public static final org.semanticwb.platform.SemanticProperty inm_hasRespuestas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasRespuestas");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluado");
    public static final org.semanticwb.platform.SemanticProperty inm_fechaevaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#fechaevaluacion");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluador");
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
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionCuestionario with a determined Evaluado
       * @param value Evaluado of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarioByEvaluado(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_evaluado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionCuestionario with a determined Evaluado
       * @param value Evaluado of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarioByEvaluado(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_evaluado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionCuestionario with a determined Evaluador
       * @param value Evaluador of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarioByEvaluador(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_evaluador, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionCuestionario with a determined Evaluador
       * @param value Evaluador of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionCuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> listEvaluacionCuestionarioByEvaluador(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionCuestionario> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_evaluador,value.getSemanticObject(),sclass));
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
   /**
   * Sets the value for the property Evaluado
   * @param value Evaluado to set
   */

    public void setEvaluado(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_evaluado, value.getSemanticObject());
        }else
        {
            removeEvaluado();
        }
    }
   /**
   * Remove the value for Evaluado property
   */

    public void removeEvaluado()
    {
        getSemanticObject().removeProperty(inm_evaluado);
    }

   /**
   * Gets the Evaluado
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEvaluado()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_evaluado);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Fechaevaluacion property
* @return java.util.Date with the Fechaevaluacion
*/
    public java.util.Date getFechaevaluacion()
    {
        return getSemanticObject().getDateProperty(inm_fechaevaluacion);
    }

/**
* Sets the Fechaevaluacion property
* @param value long with the Fechaevaluacion
*/
    public void setFechaevaluacion(java.util.Date value)
    {
        getSemanticObject().setDateProperty(inm_fechaevaluacion, value);
    }
   /**
   * Sets the value for the property Evaluador
   * @param value Evaluador to set
   */

    public void setEvaluador(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_evaluador, value.getSemanticObject());
        }else
        {
            removeEvaluador();
        }
    }
   /**
   * Remove the value for Evaluador property
   */

    public void removeEvaluador()
    {
        getSemanticObject().removeProperty(inm_evaluador);
    }

   /**
   * Gets the Evaluador
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEvaluador()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_evaluador);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
