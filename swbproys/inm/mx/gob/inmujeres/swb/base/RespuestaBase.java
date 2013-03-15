package mx.gob.inmujeres.swb.base;


public abstract class RespuestaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass inm_TipoRespuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoRespuesta");
    public static final org.semanticwb.platform.SemanticProperty inm_respuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#respuesta");
    public static final org.semanticwb.platform.SemanticClass inm_Pregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Pregunta");
    public static final org.semanticwb.platform.SemanticProperty inm_pregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pregunta");
    public static final org.semanticwb.platform.SemanticClass inm_Respuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Respuesta");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Respuesta");

    public static class ClassMgr
    {
       /**
       * Returns a list of Respuesta for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Respuesta for all models
       * @return Iterator of mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta>(it, true);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Respuesta
       * @param id Identifier for mx.gob.inmujeres.swb.Respuesta
       * @param model Model of the mx.gob.inmujeres.swb.Respuesta
       * @return A mx.gob.inmujeres.swb.Respuesta
       */
        public static mx.gob.inmujeres.swb.Respuesta getRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Respuesta)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Respuesta
       * @param id Identifier for mx.gob.inmujeres.swb.Respuesta
       * @param model Model of the mx.gob.inmujeres.swb.Respuesta
       * @return A mx.gob.inmujeres.swb.Respuesta
       */
        public static mx.gob.inmujeres.swb.Respuesta createRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Respuesta)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Respuesta
       * @param id Identifier for mx.gob.inmujeres.swb.Respuesta
       * @param model Model of the mx.gob.inmujeres.swb.Respuesta
       */
        public static void removeRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Respuesta
       * @param id Identifier for mx.gob.inmujeres.swb.Respuesta
       * @param model Model of the mx.gob.inmujeres.swb.Respuesta
       * @return true if the mx.gob.inmujeres.swb.Respuesta exists, false otherwise
       */

        public static boolean hasRespuesta(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRespuesta(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Respuesta with a determined Respuesta
       * @param value Respuesta of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @param model Model of the mx.gob.inmujeres.swb.Respuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestaByRespuesta(mx.gob.inmujeres.swb.TipoRespuesta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_respuesta, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Respuesta with a determined Respuesta
       * @param value Respuesta of the type mx.gob.inmujeres.swb.TipoRespuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestaByRespuesta(mx.gob.inmujeres.swb.TipoRespuesta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_respuesta,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Respuesta with a determined Pregunta
       * @param value Pregunta of the type mx.gob.inmujeres.swb.Pregunta
       * @param model Model of the mx.gob.inmujeres.swb.Respuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestaByPregunta(mx.gob.inmujeres.swb.Pregunta value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_pregunta, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Respuesta with a determined Pregunta
       * @param value Pregunta of the type mx.gob.inmujeres.swb.Pregunta
       * @return Iterator with all the mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestaByPregunta(mx.gob.inmujeres.swb.Pregunta value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_pregunta,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a RespuestaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Respuesta
   */
    public RespuestaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property Respuesta
   * @param value Respuesta to set
   */

    public void setRespuesta(mx.gob.inmujeres.swb.TipoRespuesta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_respuesta, value.getSemanticObject());
        }else
        {
            removeRespuesta();
        }
    }
   /**
   * Remove the value for Respuesta property
   */

    public void removeRespuesta()
    {
        getSemanticObject().removeProperty(inm_respuesta);
    }

   /**
   * Gets the Respuesta
   * @return a mx.gob.inmujeres.swb.TipoRespuesta
   */
    public mx.gob.inmujeres.swb.TipoRespuesta getRespuesta()
    {
         mx.gob.inmujeres.swb.TipoRespuesta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_respuesta);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoRespuesta)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Pregunta
   * @param value Pregunta to set
   */

    public void setPregunta(mx.gob.inmujeres.swb.Pregunta value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_pregunta, value.getSemanticObject());
        }else
        {
            removePregunta();
        }
    }
   /**
   * Remove the value for Pregunta property
   */

    public void removePregunta()
    {
        getSemanticObject().removeProperty(inm_pregunta);
    }

   /**
   * Gets the Pregunta
   * @return a mx.gob.inmujeres.swb.Pregunta
   */
    public mx.gob.inmujeres.swb.Pregunta getPregunta()
    {
         mx.gob.inmujeres.swb.Pregunta ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_pregunta);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Pregunta)obj.createGenericInstance();
         }
         return ret;
    }
}
