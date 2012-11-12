package mx.gob.inmujeres.swb.base;


public abstract class CuestionarioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty inm_anioCuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#anioCuestionario");
    public static final org.semanticwb.platform.SemanticProperty inm_observacionesCuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#observacionesCuestionario");
    public static final org.semanticwb.platform.SemanticClass inm_PreguntasRespuestas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#PreguntasRespuestas");
    public static final org.semanticwb.platform.SemanticProperty inm_haspreguntasRespuestas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#haspreguntasRespuestas");
    public static final org.semanticwb.platform.SemanticProperty inm_calificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#calificacion");
    public static final org.semanticwb.platform.SemanticClass inm_Cuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");

    public static class ClassMgr
    {
       /**
       * Returns a list of Cuestionario for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Cuestionario for all models
       * @return Iterator of mx.gob.inmujeres.swb.Cuestionario
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Cuestionario> listCuestionarios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Cuestionario>(it, true);
        }

        public static mx.gob.inmujeres.swb.Cuestionario createCuestionario(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Cuestionario.ClassMgr.createCuestionario(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return A mx.gob.inmujeres.swb.Cuestionario
       */
        public static mx.gob.inmujeres.swb.Cuestionario getCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Cuestionario)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return A mx.gob.inmujeres.swb.Cuestionario
       */
        public static mx.gob.inmujeres.swb.Cuestionario createCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Cuestionario)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       */
        public static void removeCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Cuestionario
       * @param id Identifier for mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Cuestionario
       * @return true if the mx.gob.inmujeres.swb.Cuestionario exists, false otherwise
       */

        public static boolean hasCuestionario(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCuestionario(id, model)!=null);
        }
    }

    public static CuestionarioBase.ClassMgr getCuestionarioClassMgr()
    {
        return new CuestionarioBase.ClassMgr();
    }

   /**
   * Constructs a CuestionarioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Cuestionario
   */
    public CuestionarioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the AnioCuestionario property
* @return int with the AnioCuestionario
*/
    public int getAnioCuestionario()
    {
        return getSemanticObject().getIntProperty(inm_anioCuestionario);
    }

/**
* Sets the AnioCuestionario property
* @param value long with the AnioCuestionario
*/
    public void setAnioCuestionario(int value)
    {
        getSemanticObject().setIntProperty(inm_anioCuestionario, value);
    }

/**
* Gets the ObservacionesCuestionario property
* @return String with the ObservacionesCuestionario
*/
    public String getObservacionesCuestionario()
    {
        return getSemanticObject().getProperty(inm_observacionesCuestionario);
    }

/**
* Sets the ObservacionesCuestionario property
* @param value long with the ObservacionesCuestionario
*/
    public void setObservacionesCuestionario(String value)
    {
        getSemanticObject().setProperty(inm_observacionesCuestionario, value);
    }
   /**
   * Gets all the mx.gob.inmujeres.swb.PreguntasRespuestas
   * @return A GenericIterator with all the mx.gob.inmujeres.swb.PreguntasRespuestas
   */

    public org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.PreguntasRespuestas> listpreguntasRespuestases()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.PreguntasRespuestas>(getSemanticObject().listObjectProperties(inm_haspreguntasRespuestas));
    }

   /**
   * Gets true if has a preguntasRespuestas
   * @param value mx.gob.inmujeres.swb.PreguntasRespuestas to verify
   * @return true if the mx.gob.inmujeres.swb.PreguntasRespuestas exists, false otherwise
   */
    public boolean haspreguntasRespuestas(mx.gob.inmujeres.swb.PreguntasRespuestas value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_haspreguntasRespuestas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a preguntasRespuestas
   * @param value mx.gob.inmujeres.swb.PreguntasRespuestas to add
   */

    public void addpreguntasRespuestas(mx.gob.inmujeres.swb.PreguntasRespuestas value)
    {
        getSemanticObject().addObjectProperty(inm_haspreguntasRespuestas, value.getSemanticObject());
    }
   /**
   * Removes all the preguntasRespuestas
   */

    public void removeAllpreguntasRespuestas()
    {
        getSemanticObject().removeProperty(inm_haspreguntasRespuestas);
    }
   /**
   * Removes a preguntasRespuestas
   * @param value mx.gob.inmujeres.swb.PreguntasRespuestas to remove
   */

    public void removepreguntasRespuestas(mx.gob.inmujeres.swb.PreguntasRespuestas value)
    {
        getSemanticObject().removeObjectProperty(inm_haspreguntasRespuestas,value.getSemanticObject());
    }

   /**
   * Gets the preguntasRespuestas
   * @return a mx.gob.inmujeres.swb.PreguntasRespuestas
   */
    public mx.gob.inmujeres.swb.PreguntasRespuestas getpreguntasRespuestas()
    {
         mx.gob.inmujeres.swb.PreguntasRespuestas ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_haspreguntasRespuestas);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.PreguntasRespuestas)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Calificacion property
* @return String with the Calificacion
*/
    public String getCalificacion()
    {
        return getSemanticObject().getProperty(inm_calificacion);
    }

/**
* Sets the Calificacion property
* @param value long with the Calificacion
*/
    public void setCalificacion(String value)
    {
        getSemanticObject().setProperty(inm_calificacion, value);
    }
}
