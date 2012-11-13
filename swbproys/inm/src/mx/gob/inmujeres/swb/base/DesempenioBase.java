package mx.gob.inmujeres.swb.base;


public abstract class DesempenioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty inm_nombreSuplente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#nombreSuplente");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty inm_datosEvaluado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#datosEvaluado");
    public static final org.semanticwb.platform.SemanticClass inm_TipoNivelGestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoNivelGestion");
    public static final org.semanticwb.platform.SemanticProperty inm_nivelGestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#nivelGestion");
    public static final org.semanticwb.platform.SemanticProperty inm_tiempoRelacionLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#tiempoRelacionLaboral");
    public static final org.semanticwb.platform.SemanticProperty inm_metas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#metas");
    public static final org.semanticwb.platform.SemanticProperty inm_nombreCurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#nombreCurso");
    public static final org.semanticwb.platform.SemanticProperty inm_motivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#motivo");
    public static final org.semanticwb.platform.SemanticProperty inm_folio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#folio");
    public static final org.semanticwb.platform.SemanticProperty inm_justificacionObjetivoRelacionado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#justificacionObjetivoRelacionado");
    public static final org.semanticwb.platform.SemanticProperty inm_anio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#anio");
    public static final org.semanticwb.platform.SemanticProperty inm_acuerdos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#acuerdos");
    public static final org.semanticwb.platform.SemanticClass inm_Trimestre=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Trimestre");
    public static final org.semanticwb.platform.SemanticProperty inm_trimestreAnioAplicar=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#trimestreAnioAplicar");
    public static final org.semanticwb.platform.SemanticProperty inm_fecha=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#fecha");
    public static final org.semanticwb.platform.SemanticClass inm_TipoMedida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoMedida");
    public static final org.semanticwb.platform.SemanticProperty inm_medida=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#medida");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluadoEvaluada=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluadoEvaluada");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluadorEvaluadora=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluadorEvaluadora");
    public static final org.semanticwb.platform.SemanticClass inm_Cuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Cuestionario");
    public static final org.semanticwb.platform.SemanticProperty inm_cuestionarioAplicado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#cuestionarioAplicado");
    public static final org.semanticwb.platform.SemanticProperty inm_datosEvaluador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#datosEvaluador");
    public static final org.semanticwb.platform.SemanticClass inm_Desempenio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Desempenio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Desempenio");

    public static class ClassMgr
    {
       /**
       * Returns a list of Desempenio for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Desempenio for all models
       * @return Iterator of mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio>(it, true);
        }

        public static mx.gob.inmujeres.swb.Desempenio createDesempenio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Desempenio.ClassMgr.createDesempenio(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Desempenio
       * @param id Identifier for mx.gob.inmujeres.swb.Desempenio
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return A mx.gob.inmujeres.swb.Desempenio
       */
        public static mx.gob.inmujeres.swb.Desempenio getDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Desempenio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Desempenio
       * @param id Identifier for mx.gob.inmujeres.swb.Desempenio
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return A mx.gob.inmujeres.swb.Desempenio
       */
        public static mx.gob.inmujeres.swb.Desempenio createDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Desempenio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Desempenio
       * @param id Identifier for mx.gob.inmujeres.swb.Desempenio
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       */
        public static void removeDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Desempenio
       * @param id Identifier for mx.gob.inmujeres.swb.Desempenio
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return true if the mx.gob.inmujeres.swb.Desempenio exists, false otherwise
       */

        public static boolean hasDesempenio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDesempenio(id, model)!=null);
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined DatosEvaluado
       * @param value DatosEvaluado of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByDatosEvaluado(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_datosEvaluado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined DatosEvaluado
       * @param value DatosEvaluado of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByDatosEvaluado(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_datosEvaluado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined NivelGestion
       * @param value NivelGestion of the type mx.gob.inmujeres.swb.TipoNivelGestion
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByNivelGestion(mx.gob.inmujeres.swb.TipoNivelGestion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_nivelGestion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined NivelGestion
       * @param value NivelGestion of the type mx.gob.inmujeres.swb.TipoNivelGestion
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByNivelGestion(mx.gob.inmujeres.swb.TipoNivelGestion value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_nivelGestion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined TrimestreAnioAplicar
       * @param value TrimestreAnioAplicar of the type mx.gob.inmujeres.swb.Trimestre
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByTrimestreAnioAplicar(mx.gob.inmujeres.swb.Trimestre value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_trimestreAnioAplicar, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined TrimestreAnioAplicar
       * @param value TrimestreAnioAplicar of the type mx.gob.inmujeres.swb.Trimestre
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByTrimestreAnioAplicar(mx.gob.inmujeres.swb.Trimestre value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_trimestreAnioAplicar,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Medida
       * @param value Medida of the type mx.gob.inmujeres.swb.TipoMedida
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByMedida(mx.gob.inmujeres.swb.TipoMedida value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_medida, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Medida
       * @param value Medida of the type mx.gob.inmujeres.swb.TipoMedida
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByMedida(mx.gob.inmujeres.swb.TipoMedida value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_medida,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined CuestionarioAplicado
       * @param value CuestionarioAplicado of the type mx.gob.inmujeres.swb.Cuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCuestionarioAplicado(mx.gob.inmujeres.swb.Cuestionario value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_cuestionarioAplicado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined CuestionarioAplicado
       * @param value CuestionarioAplicado of the type mx.gob.inmujeres.swb.Cuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCuestionarioAplicado(mx.gob.inmujeres.swb.Cuestionario value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_cuestionarioAplicado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined DatosEvaluador
       * @param value DatosEvaluador of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByDatosEvaluador(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_datosEvaluador, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined DatosEvaluador
       * @param value DatosEvaluador of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByDatosEvaluador(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_datosEvaluador,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DesempenioBase.ClassMgr getDesempenioClassMgr()
    {
        return new DesempenioBase.ClassMgr();
    }

   /**
   * Constructs a DesempenioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Desempenio
   */
    public DesempenioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NombreSuplente property
* @return String with the NombreSuplente
*/
    public String getNombreSuplente()
    {
        return getSemanticObject().getProperty(inm_nombreSuplente);
    }

/**
* Sets the NombreSuplente property
* @param value long with the NombreSuplente
*/
    public void setNombreSuplente(String value)
    {
        getSemanticObject().setProperty(inm_nombreSuplente, value);
    }
   /**
   * Sets the value for the property DatosEvaluado
   * @param value DatosEvaluado to set
   */

    public void setDatosEvaluado(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_datosEvaluado, value.getSemanticObject());
        }else
        {
            removeDatosEvaluado();
        }
    }
   /**
   * Remove the value for DatosEvaluado property
   */

    public void removeDatosEvaluado()
    {
        getSemanticObject().removeProperty(inm_datosEvaluado);
    }

   /**
   * Gets the DatosEvaluado
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getDatosEvaluado()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_datosEvaluado);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property NivelGestion
   * @param value NivelGestion to set
   */

    public void setNivelGestion(mx.gob.inmujeres.swb.TipoNivelGestion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_nivelGestion, value.getSemanticObject());
        }else
        {
            removeNivelGestion();
        }
    }
   /**
   * Remove the value for NivelGestion property
   */

    public void removeNivelGestion()
    {
        getSemanticObject().removeProperty(inm_nivelGestion);
    }

   /**
   * Gets the NivelGestion
   * @return a mx.gob.inmujeres.swb.TipoNivelGestion
   */
    public mx.gob.inmujeres.swb.TipoNivelGestion getNivelGestion()
    {
         mx.gob.inmujeres.swb.TipoNivelGestion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_nivelGestion);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TipoNivelGestion)obj.createGenericInstance();
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
* Gets the TiempoRelacionLaboral property
* @return String with the TiempoRelacionLaboral
*/
    public String getTiempoRelacionLaboral()
    {
        return getSemanticObject().getProperty(inm_tiempoRelacionLaboral);
    }

/**
* Sets the TiempoRelacionLaboral property
* @param value long with the TiempoRelacionLaboral
*/
    public void setTiempoRelacionLaboral(String value)
    {
        getSemanticObject().setProperty(inm_tiempoRelacionLaboral, value);
    }

/**
* Gets the Metas property
* @return String with the Metas
*/
    public String getMetas()
    {
        return getSemanticObject().getProperty(inm_metas);
    }

/**
* Sets the Metas property
* @param value long with the Metas
*/
    public void setMetas(String value)
    {
        getSemanticObject().setProperty(inm_metas, value);
    }

/**
* Gets the NombreCurso property
* @return String with the NombreCurso
*/
    public String getNombreCurso()
    {
        return getSemanticObject().getProperty(inm_nombreCurso);
    }

/**
* Sets the NombreCurso property
* @param value long with the NombreCurso
*/
    public void setNombreCurso(String value)
    {
        getSemanticObject().setProperty(inm_nombreCurso, value);
    }

/**
* Gets the Motivo property
* @return String with the Motivo
*/
    public String getMotivo()
    {
        return getSemanticObject().getProperty(inm_motivo);
    }

/**
* Sets the Motivo property
* @param value long with the Motivo
*/
    public void setMotivo(String value)
    {
        getSemanticObject().setProperty(inm_motivo, value);
    }

/**
* Gets the Folio property
* @return String with the Folio
*/
    public String getFolio()
    {
        return getSemanticObject().getProperty(inm_folio);
    }

/**
* Sets the Folio property
* @param value long with the Folio
*/
    public void setFolio(String value)
    {
        getSemanticObject().setProperty(inm_folio, value);
    }

/**
* Gets the JustificacionObjetivoRelacionado property
* @return String with the JustificacionObjetivoRelacionado
*/
    public String getJustificacionObjetivoRelacionado()
    {
        return getSemanticObject().getProperty(inm_justificacionObjetivoRelacionado);
    }

/**
* Sets the JustificacionObjetivoRelacionado property
* @param value long with the JustificacionObjetivoRelacionado
*/
    public void setJustificacionObjetivoRelacionado(String value)
    {
        getSemanticObject().setProperty(inm_justificacionObjetivoRelacionado, value);
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
* Gets the Acuerdos property
* @return String with the Acuerdos
*/
    public String getAcuerdos()
    {
        return getSemanticObject().getProperty(inm_acuerdos);
    }

/**
* Sets the Acuerdos property
* @param value long with the Acuerdos
*/
    public void setAcuerdos(String value)
    {
        getSemanticObject().setProperty(inm_acuerdos, value);
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
   * Sets the value for the property TrimestreAnioAplicar
   * @param value TrimestreAnioAplicar to set
   */

    public void setTrimestreAnioAplicar(mx.gob.inmujeres.swb.Trimestre value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_trimestreAnioAplicar, value.getSemanticObject());
        }else
        {
            removeTrimestreAnioAplicar();
        }
    }
   /**
   * Remove the value for TrimestreAnioAplicar property
   */

    public void removeTrimestreAnioAplicar()
    {
        getSemanticObject().removeProperty(inm_trimestreAnioAplicar);
    }

   /**
   * Gets the TrimestreAnioAplicar
   * @return a mx.gob.inmujeres.swb.Trimestre
   */
    public mx.gob.inmujeres.swb.Trimestre getTrimestreAnioAplicar()
    {
         mx.gob.inmujeres.swb.Trimestre ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_trimestreAnioAplicar);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Trimestre)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Fecha property
* @return java.util.Date with the Fecha
*/
    public java.util.Date getFecha()
    {
        return getSemanticObject().getDateProperty(inm_fecha);
    }

/**
* Sets the Fecha property
* @param value long with the Fecha
*/
    public void setFecha(java.util.Date value)
    {
        getSemanticObject().setDateProperty(inm_fecha, value);
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
* Gets the EvaluadoEvaluada property
* @return String with the EvaluadoEvaluada
*/
    public String getEvaluadoEvaluada()
    {
        return getSemanticObject().getProperty(inm_evaluadoEvaluada);
    }

/**
* Sets the EvaluadoEvaluada property
* @param value long with the EvaluadoEvaluada
*/
    public void setEvaluadoEvaluada(String value)
    {
        getSemanticObject().setProperty(inm_evaluadoEvaluada, value);
    }

/**
* Gets the EvaluadorEvaluadora property
* @return String with the EvaluadorEvaluadora
*/
    public String getEvaluadorEvaluadora()
    {
        return getSemanticObject().getProperty(inm_evaluadorEvaluadora);
    }

/**
* Sets the EvaluadorEvaluadora property
* @param value long with the EvaluadorEvaluadora
*/
    public void setEvaluadorEvaluadora(String value)
    {
        getSemanticObject().setProperty(inm_evaluadorEvaluadora, value);
    }
   /**
   * Sets the value for the property CuestionarioAplicado
   * @param value CuestionarioAplicado to set
   */

    public void setCuestionarioAplicado(mx.gob.inmujeres.swb.Cuestionario value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_cuestionarioAplicado, value.getSemanticObject());
        }else
        {
            removeCuestionarioAplicado();
        }
    }
   /**
   * Remove the value for CuestionarioAplicado property
   */

    public void removeCuestionarioAplicado()
    {
        getSemanticObject().removeProperty(inm_cuestionarioAplicado);
    }

   /**
   * Gets the CuestionarioAplicado
   * @return a mx.gob.inmujeres.swb.Cuestionario
   */
    public mx.gob.inmujeres.swb.Cuestionario getCuestionarioAplicado()
    {
         mx.gob.inmujeres.swb.Cuestionario ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_cuestionarioAplicado);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.Cuestionario)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property DatosEvaluador
   * @param value DatosEvaluador to set
   */

    public void setDatosEvaluador(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_datosEvaluador, value.getSemanticObject());
        }else
        {
            removeDatosEvaluador();
        }
    }
   /**
   * Remove the value for DatosEvaluador property
   */

    public void removeDatosEvaluador()
    {
        getSemanticObject().removeProperty(inm_datosEvaluador);
    }

   /**
   * Gets the DatosEvaluador
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getDatosEvaluador()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_datosEvaluador);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
}
