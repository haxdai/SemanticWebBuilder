package mx.gob.inmujeres.swb.base;


public abstract class EvaluacionDesempenioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty inm_reporteMetas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#reporteMetas");
    public static final org.semanticwb.platform.SemanticProperty inm_reporteResultadosDnc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#reporteResultadosDnc");
    public static final org.semanticwb.platform.SemanticClass inm_Cuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");
    public static final org.semanticwb.platform.SemanticProperty inm_cuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#cuestionario");
    public static final org.semanticwb.platform.SemanticProperty inm_reporteResultadosCuestionarios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#reporteResultadosCuestionarios");
    public static final org.semanticwb.platform.SemanticProperty inm_reporteResultadosRetro=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#reporteResultadosRetro");
    public static final org.semanticwb.platform.SemanticClass inm_EvaluacionDesempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#EvaluacionDesempenio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#EvaluacionDesempenio");

    public static class ClassMgr
    {
       /**
       * Returns a list of EvaluacionDesempenio for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.EvaluacionDesempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionDesempenio> listEvaluacionDesempenios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionDesempenio>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.EvaluacionDesempenio for all models
       * @return Iterator of mx.gob.inmujeres.swb.EvaluacionDesempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionDesempenio> listEvaluacionDesempenios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionDesempenio>(it, true);
        }

        public static mx.gob.inmujeres.swb.EvaluacionDesempenio createEvaluacionDesempenio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.EvaluacionDesempenio.ClassMgr.createEvaluacionDesempenio(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @return A mx.gob.inmujeres.swb.EvaluacionDesempenio
       */
        public static mx.gob.inmujeres.swb.EvaluacionDesempenio getEvaluacionDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.EvaluacionDesempenio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @return A mx.gob.inmujeres.swb.EvaluacionDesempenio
       */
        public static mx.gob.inmujeres.swb.EvaluacionDesempenio createEvaluacionDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.EvaluacionDesempenio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionDesempenio
       */
        public static void removeEvaluacionDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param id Identifier for mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @return true if the mx.gob.inmujeres.swb.EvaluacionDesempenio exists, false otherwise
       */

        public static boolean hasEvaluacionDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEvaluacionDesempenio(id, model)!=null);
        }
    }

    public static EvaluacionDesempenioBase.ClassMgr getEvaluacionDesempenioClassMgr()
    {
        return new EvaluacionDesempenioBase.ClassMgr();
    }

   /**
   * Constructs a EvaluacionDesempenioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EvaluacionDesempenio
   */
    public EvaluacionDesempenioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ReporteMetas property
* @return String with the ReporteMetas
*/
    public String getReporteMetas()
    {
        return getSemanticObject().getProperty(inm_reporteMetas);
    }

/**
* Sets the ReporteMetas property
* @param value long with the ReporteMetas
*/
    public void setReporteMetas(String value)
    {
        getSemanticObject().setProperty(inm_reporteMetas, value);
    }

/**
* Gets the ReporteResultadosDnc property
* @return String with the ReporteResultadosDnc
*/
    public String getReporteResultadosDnc()
    {
        return getSemanticObject().getProperty(inm_reporteResultadosDnc);
    }

/**
* Sets the ReporteResultadosDnc property
* @param value long with the ReporteResultadosDnc
*/
    public void setReporteResultadosDnc(String value)
    {
        getSemanticObject().setProperty(inm_reporteResultadosDnc, value);
    }
   /**
   * Sets the value for the property Cuestionario
   * @param value Cuestionario to set
   */

    public void setCuestionario(mx.gob.inmujeres.swb.Cuestionario value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_cuestionario, value.getSemanticObject());
        }else
        {
            removeCuestionario();
        }
    }
   /**
   * Remove the value for Cuestionario property
   */

    public void removeCuestionario()
    {
        getSemanticObject().removeProperty(inm_cuestionario);
    }

   /**
   * Gets the Cuestionario
   * @return a mx.gob.inmujeres.swb.Cuestionario
   */
    public mx.gob.inmujeres.swb.Cuestionario getCuestionario()
    {
         mx.gob.inmujeres.swb.Cuestionario ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_cuestionario);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Cuestionario)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ReporteResultadosCuestionarios property
* @return String with the ReporteResultadosCuestionarios
*/
    public String getReporteResultadosCuestionarios()
    {
        return getSemanticObject().getProperty(inm_reporteResultadosCuestionarios);
    }

/**
* Sets the ReporteResultadosCuestionarios property
* @param value long with the ReporteResultadosCuestionarios
*/
    public void setReporteResultadosCuestionarios(String value)
    {
        getSemanticObject().setProperty(inm_reporteResultadosCuestionarios, value);
    }

/**
* Gets the ReporteResultadosRetro property
* @return String with the ReporteResultadosRetro
*/
    public String getReporteResultadosRetro()
    {
        return getSemanticObject().getProperty(inm_reporteResultadosRetro);
    }

/**
* Sets the ReporteResultadosRetro property
* @param value long with the ReporteResultadosRetro
*/
    public void setReporteResultadosRetro(String value)
    {
        getSemanticObject().setProperty(inm_reporteResultadosRetro, value);
    }
}
