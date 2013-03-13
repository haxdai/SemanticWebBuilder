package mx.gob.inmujeres.swb.base;


public abstract class MetaEvaluacionBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty inm_pesoMeta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pesoMeta");
    public static final org.semanticwb.platform.SemanticProperty inm_meta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#meta");
    public static final org.semanticwb.platform.SemanticClass inm_InstrumentoG=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#InstrumentoG");
    public static final org.semanticwb.platform.SemanticProperty inm_Instrumentog=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#Instrumentog");
    public static final org.semanticwb.platform.SemanticProperty inm_pSatisfactorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pSatisfactorio");
    public static final org.semanticwb.platform.SemanticProperty inm_pMinimoaceptable=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pMinimoaceptable");
    public static final org.semanticwb.platform.SemanticProperty inm_pSobresaliente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pSobresaliente");
    public static final org.semanticwb.platform.SemanticClass inm_TipoMedida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoMedida");
    public static final org.semanticwb.platform.SemanticProperty inm_medida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#medida");
    public static final org.semanticwb.platform.SemanticClass inm_TemasPrograma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TemasPrograma");
    public static final org.semanticwb.platform.SemanticProperty inm_temasPrograma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#temasPrograma");
    public static final org.semanticwb.platform.SemanticProperty inm_pNoSatisfactorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#pNoSatisfactorio");
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
       * Gets all mx.gob.inmujeres.swb.MetaEvaluacion with a determined Instrumentog
       * @param value Instrumentog of the type mx.gob.inmujeres.swb.InstrumentoG
       * @param model Model of the mx.gob.inmujeres.swb.MetaEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacionByInstrumentog(mx.gob.inmujeres.swb.InstrumentoG value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_Instrumentog, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.MetaEvaluacion with a determined Instrumentog
       * @param value Instrumentog of the type mx.gob.inmujeres.swb.InstrumentoG
       * @return Iterator with all the mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacionByInstrumentog(mx.gob.inmujeres.swb.InstrumentoG value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_Instrumentog,value.getSemanticObject(),sclass));
            return it;
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
       /**
       * Gets all mx.gob.inmujeres.swb.MetaEvaluacion with a determined TemasPrograma
       * @param value TemasPrograma of the type mx.gob.inmujeres.swb.TemasPrograma
       * @param model Model of the mx.gob.inmujeres.swb.MetaEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacionByTemasPrograma(mx.gob.inmujeres.swb.TemasPrograma value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_temasPrograma, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.MetaEvaluacion with a determined TemasPrograma
       * @param value TemasPrograma of the type mx.gob.inmujeres.swb.TemasPrograma
       * @return Iterator with all the mx.gob.inmujeres.swb.MetaEvaluacion
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetaEvaluacionByTemasPrograma(mx.gob.inmujeres.swb.TemasPrograma value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_temasPrograma,value.getSemanticObject(),sclass));
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
* Gets the PesoMeta property
* @return String with the PesoMeta
*/
    public String getPesoMeta()
    {
        return getSemanticObject().getProperty(inm_pesoMeta);
    }

/**
* Sets the PesoMeta property
* @param value long with the PesoMeta
*/
    public void setPesoMeta(String value)
    {
        getSemanticObject().setProperty(inm_pesoMeta, value);
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
   * Sets the value for the property Instrumentog
   * @param value Instrumentog to set
   */

    public void setInstrumentog(mx.gob.inmujeres.swb.InstrumentoG value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_Instrumentog, value.getSemanticObject());
        }else
        {
            removeInstrumentog();
        }
    }
   /**
   * Remove the value for Instrumentog property
   */

    public void removeInstrumentog()
    {
        getSemanticObject().removeProperty(inm_Instrumentog);
    }

   /**
   * Gets the Instrumentog
   * @return a mx.gob.inmujeres.swb.InstrumentoG
   */
    public mx.gob.inmujeres.swb.InstrumentoG getInstrumentog()
    {
         mx.gob.inmujeres.swb.InstrumentoG ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_Instrumentog);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.InstrumentoG)obj.createGenericInstance();
         }
         return ret;
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
* Gets the PSatisfactorio property
* @return String with the PSatisfactorio
*/
    public String getPSatisfactorio()
    {
        return getSemanticObject().getProperty(inm_pSatisfactorio);
    }

/**
* Sets the PSatisfactorio property
* @param value long with the PSatisfactorio
*/
    public void setPSatisfactorio(String value)
    {
        getSemanticObject().setProperty(inm_pSatisfactorio, value);
    }

/**
* Gets the PMinimoaceptable property
* @return String with the PMinimoaceptable
*/
    public String getPMinimoaceptable()
    {
        return getSemanticObject().getProperty(inm_pMinimoaceptable);
    }

/**
* Sets the PMinimoaceptable property
* @param value long with the PMinimoaceptable
*/
    public void setPMinimoaceptable(String value)
    {
        getSemanticObject().setProperty(inm_pMinimoaceptable, value);
    }

/**
* Gets the PSobresaliente property
* @return String with the PSobresaliente
*/
    public String getPSobresaliente()
    {
        return getSemanticObject().getProperty(inm_pSobresaliente);
    }

/**
* Sets the PSobresaliente property
* @param value long with the PSobresaliente
*/
    public void setPSobresaliente(String value)
    {
        getSemanticObject().setProperty(inm_pSobresaliente, value);
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
   /**
   * Sets the value for the property TemasPrograma
   * @param value TemasPrograma to set
   */

    public void setTemasPrograma(mx.gob.inmujeres.swb.TemasPrograma value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_temasPrograma, value.getSemanticObject());
        }else
        {
            removeTemasPrograma();
        }
    }
   /**
   * Remove the value for TemasPrograma property
   */

    public void removeTemasPrograma()
    {
        getSemanticObject().removeProperty(inm_temasPrograma);
    }

   /**
   * Gets the TemasPrograma
   * @return a mx.gob.inmujeres.swb.TemasPrograma
   */
    public mx.gob.inmujeres.swb.TemasPrograma getTemasPrograma()
    {
         mx.gob.inmujeres.swb.TemasPrograma ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_temasPrograma);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TemasPrograma)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PNoSatisfactorio property
* @return String with the PNoSatisfactorio
*/
    public String getPNoSatisfactorio()
    {
        return getSemanticObject().getProperty(inm_pNoSatisfactorio);
    }

/**
* Sets the PNoSatisfactorio property
* @param value long with the PNoSatisfactorio
*/
    public void setPNoSatisfactorio(String value)
    {
        getSemanticObject().setProperty(inm_pNoSatisfactorio, value);
    }
}
