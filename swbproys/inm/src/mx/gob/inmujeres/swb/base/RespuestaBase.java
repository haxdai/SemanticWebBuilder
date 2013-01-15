package mx.gob.inmujeres.swb.base;


public abstract class RespuestaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_Pregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Pregunta");
    public static final org.semanticwb.platform.SemanticProperty inm_pregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pregunta");
    public static final org.semanticwb.platform.SemanticClass inm_Score=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Score");
    public static final org.semanticwb.platform.SemanticProperty inm_scorePregunta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#scorePregunta");
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
       /**
       * Gets all mx.gob.inmujeres.swb.Respuesta with a determined ScorePregunta
       * @param value ScorePregunta of the type mx.gob.inmujeres.swb.Score
       * @param model Model of the mx.gob.inmujeres.swb.Respuesta
       * @return Iterator with all the mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestaByScorePregunta(mx.gob.inmujeres.swb.Score value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_scorePregunta, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Respuesta with a determined ScorePregunta
       * @param value ScorePregunta of the type mx.gob.inmujeres.swb.Score
       * @return Iterator with all the mx.gob.inmujeres.swb.Respuesta
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Respuesta> listRespuestaByScorePregunta(mx.gob.inmujeres.swb.Score value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Respuesta> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_scorePregunta,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static RespuestaBase.ClassMgr getRespuestaClassMgr()
    {
        return new RespuestaBase.ClassMgr();
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
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
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
   /**
   * Sets the value for the property ScorePregunta
   * @param value ScorePregunta to set
   */

    public void setScorePregunta(mx.gob.inmujeres.swb.Score value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_scorePregunta, value.getSemanticObject());
        }else
        {
            removeScorePregunta();
        }
    }
   /**
   * Remove the value for ScorePregunta property
   */

    public void removeScorePregunta()
    {
        getSemanticObject().removeProperty(inm_scorePregunta);
    }

   /**
   * Gets the ScorePregunta
   * @return a mx.gob.inmujeres.swb.Score
   */
    public mx.gob.inmujeres.swb.Score getScorePregunta()
    {
         mx.gob.inmujeres.swb.Score ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_scorePregunta);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Score)obj.createGenericInstance();
         }
         return ret;
    }
}
