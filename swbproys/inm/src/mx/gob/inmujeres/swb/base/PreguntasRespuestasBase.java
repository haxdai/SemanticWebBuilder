package mx.gob.inmujeres.swb.base;


public abstract class PreguntasRespuestasBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty inm_anio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#anio");
    public static final org.semanticwb.platform.SemanticProperty inm_subgrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#subgrupo");
    public static final org.semanticwb.platform.SemanticProperty inm_grupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#grupo");
    public static final org.semanticwb.platform.SemanticProperty inm_respuestaIdeal=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#respuestaIdeal");
    public static final org.semanticwb.platform.SemanticClass inm_TipoRespuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoRespuesta");
    public static final org.semanticwb.platform.SemanticProperty inm_respuesta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#respuesta");
    public static final org.semanticwb.platform.SemanticProperty inm_pregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pregunta");
    public static final org.semanticwb.platform.SemanticClass inm_PreguntasRespuestas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#PreguntasRespuestas");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#PreguntasRespuestas");

    public static class ClassMgr
    {
       /**
       * Returns a list of PreguntasRespuestas for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.PreguntasRespuestas
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.PreguntasRespuestas> listPreguntasRespuestases(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.PreguntasRespuestas>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.PreguntasRespuestas for all models
       * @return Iterator of mx.gob.inmujeres.swb.PreguntasRespuestas
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.PreguntasRespuestas> listPreguntasRespuestases()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.PreguntasRespuestas>(it, true);
        }

        public static mx.gob.inmujeres.swb.PreguntasRespuestas createPreguntasRespuestas(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.PreguntasRespuestas.ClassMgr.createPreguntasRespuestas(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param id Identifier for mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param model Model of the mx.gob.inmujeres.swb.PreguntasRespuestas
       * @return A mx.gob.inmujeres.swb.PreguntasRespuestas
       */
        public static mx.gob.inmujeres.swb.PreguntasRespuestas getPreguntasRespuestas(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.PreguntasRespuestas)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param id Identifier for mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param model Model of the mx.gob.inmujeres.swb.PreguntasRespuestas
       * @return A mx.gob.inmujeres.swb.PreguntasRespuestas
       */
        public static mx.gob.inmujeres.swb.PreguntasRespuestas createPreguntasRespuestas(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.PreguntasRespuestas)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param id Identifier for mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param model Model of the mx.gob.inmujeres.swb.PreguntasRespuestas
       */
        public static void removePreguntasRespuestas(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param id Identifier for mx.gob.inmujeres.swb.PreguntasRespuestas
       * @param model Model of the mx.gob.inmujeres.swb.PreguntasRespuestas
       * @return true if the mx.gob.inmujeres.swb.PreguntasRespuestas exists, false otherwise
       */

        public static boolean hasPreguntasRespuestas(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPreguntasRespuestas(id, model)!=null);
        }
    }

    public static PreguntasRespuestasBase.ClassMgr getPreguntasRespuestasClassMgr()
    {
        return new PreguntasRespuestasBase.ClassMgr();
    }

   /**
   * Constructs a PreguntasRespuestasBase with a SemanticObject
   * @param base The SemanticObject with the properties for the PreguntasRespuestas
   */
    public PreguntasRespuestasBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Anio property
* @return int with the Anio
*/
    public int getAnio()
    {
        return getSemanticObject().getIntProperty(inm_anio);
    }

/**
* Sets the Anio property
* @param value long with the Anio
*/
    public void setAnio(int value)
    {
        getSemanticObject().setIntProperty(inm_anio, value);
    }

/**
* Gets the Subgrupo property
* @return int with the Subgrupo
*/
    public int getSubgrupo()
    {
        return getSemanticObject().getIntProperty(inm_subgrupo);
    }

/**
* Sets the Subgrupo property
* @param value long with the Subgrupo
*/
    public void setSubgrupo(int value)
    {
        getSemanticObject().setIntProperty(inm_subgrupo, value);
    }

/**
* Gets the Grupo property
* @return int with the Grupo
*/
    public int getGrupo()
    {
        return getSemanticObject().getIntProperty(inm_grupo);
    }

/**
* Sets the Grupo property
* @param value long with the Grupo
*/
    public void setGrupo(int value)
    {
        getSemanticObject().setIntProperty(inm_grupo, value);
    }

/**
* Gets the RespuestaIdeal property
* @return int with the RespuestaIdeal
*/
    public int getRespuestaIdeal()
    {
        return getSemanticObject().getIntProperty(inm_respuestaIdeal);
    }

/**
* Sets the RespuestaIdeal property
* @param value long with the RespuestaIdeal
*/
    public void setRespuestaIdeal(int value)
    {
        getSemanticObject().setIntProperty(inm_respuestaIdeal, value);
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
* Gets the Pregunta property
* @return String with the Pregunta
*/
    public String getPregunta()
    {
        return getSemanticObject().getProperty(inm_pregunta);
    }

/**
* Sets the Pregunta property
* @param value long with the Pregunta
*/
    public void setPregunta(String value)
    {
        getSemanticObject().setProperty(inm_pregunta, value);
    }
}
