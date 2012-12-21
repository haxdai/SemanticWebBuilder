package mx.gob.inmujeres.swb.base;


public abstract class EvaluacionDesempenioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_Desempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Desempenio");
    public static final org.semanticwb.platform.SemanticProperty inm_desempeño=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#desempeño");
    public static final org.semanticwb.platform.SemanticProperty inm_reporteResultadosCuestionarios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#reporteResultadosCuestionarios");
    public static final org.semanticwb.platform.SemanticProperty inm_reporteMetas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#reporteMetas");
    public static final org.semanticwb.platform.SemanticProperty inm_reporteResultadosDnc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#reporteResultadosDnc");
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
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionDesempenio with a determined Desempeño
       * @param value Desempeño of the type mx.gob.inmujeres.swb.Desempenio
       * @param model Model of the mx.gob.inmujeres.swb.EvaluacionDesempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionDesempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionDesempenio> listEvaluacionDesempenioByDesempeño(mx.gob.inmujeres.swb.Desempenio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionDesempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_desempeño, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.EvaluacionDesempenio with a determined Desempeño
       * @param value Desempeño of the type mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.EvaluacionDesempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.EvaluacionDesempenio> listEvaluacionDesempenioByDesempeño(mx.gob.inmujeres.swb.Desempenio value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.EvaluacionDesempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_desempeño,value.getSemanticObject(),sclass));
            return it;
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
   * Sets the value for the property Desempeño
   * @param value Desempeño to set
   */

    public void setDesempeño(mx.gob.inmujeres.swb.Desempenio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_desempeño, value.getSemanticObject());
        }else
        {
            removeDesempeño();
        }
    }
   /**
   * Remove the value for Desempeño property
   */

    public void removeDesempeño()
    {
        getSemanticObject().removeProperty(inm_desempeño);
    }

   /**
   * Gets the Desempeño
   * @return a mx.gob.inmujeres.swb.Desempenio
   */
    public mx.gob.inmujeres.swb.Desempenio getDesempeño()
    {
         mx.gob.inmujeres.swb.Desempenio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_desempeño);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Desempenio)obj.createGenericInstance();
         }
         return ret;
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
