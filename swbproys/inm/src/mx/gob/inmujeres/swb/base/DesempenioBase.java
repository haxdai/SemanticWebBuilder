package mx.gob.inmujeres.swb.base;


public abstract class DesempenioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluado");
    public static final org.semanticwb.platform.SemanticProperty inm_nombreSuplente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#nombreSuplente");
    public static final org.semanticwb.platform.SemanticProperty inm_fechaevaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#fechaevaluacion");
    public static final org.semanticwb.platform.SemanticClass inm_TipoNivelGestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TipoNivelGestion");
    public static final org.semanticwb.platform.SemanticProperty inm_nivelGestion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#nivelGestion");
    public static final org.semanticwb.platform.SemanticClass inm_MetaEvaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#MetaEvaluacion");
    public static final org.semanticwb.platform.SemanticProperty inm_hasMetas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasMetas");
    public static final org.semanticwb.platform.SemanticClass inm_TiempoRL=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#TiempoRL");
    public static final org.semanticwb.platform.SemanticProperty inm_tiempoRelacionLaboral=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#tiempoRelacionLaboral");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluador=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluador");
    public static final org.semanticwb.platform.SemanticProperty inm_motivo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#motivo");
    public static final org.semanticwb.platform.SemanticProperty inm_folio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#folio");
    public static final org.semanticwb.platform.SemanticProperty inm_anio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#anio");
    public static final org.semanticwb.platform.SemanticProperty inm_acuerdos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#acuerdos");
    public static final org.semanticwb.platform.SemanticClass inm_CursoEvaluacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#CursoEvaluacion");
    public static final org.semanticwb.platform.SemanticProperty inm_hasCursos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#hasCursos");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluadoEvaluada=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluadoEvaluada");
    public static final org.semanticwb.platform.SemanticProperty inm_evaluadorEvaluadora=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#evaluadorEvaluadora");
    public static final org.semanticwb.platform.SemanticClass inm_EvaluacionCuestionario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#EvaluacionCuestionario");
    public static final org.semanticwb.platform.SemanticProperty inm_cuestionarioAplicado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#cuestionarioAplicado");
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
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Evaluado
       * @param value Evaluado of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByEvaluado(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_evaluado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Evaluado
       * @param value Evaluado of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByEvaluado(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_evaluado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
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
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Metas
       * @param value Metas of the type mx.gob.inmujeres.swb.MetaEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByMetas(mx.gob.inmujeres.swb.MetaEvaluacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_hasMetas, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Metas
       * @param value Metas of the type mx.gob.inmujeres.swb.MetaEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByMetas(mx.gob.inmujeres.swb.MetaEvaluacion value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_hasMetas,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined TiempoRelacionLaboral
       * @param value TiempoRelacionLaboral of the type mx.gob.inmujeres.swb.TiempoRL
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByTiempoRelacionLaboral(mx.gob.inmujeres.swb.TiempoRL value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_tiempoRelacionLaboral, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined TiempoRelacionLaboral
       * @param value TiempoRelacionLaboral of the type mx.gob.inmujeres.swb.TiempoRL
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByTiempoRelacionLaboral(mx.gob.inmujeres.swb.TiempoRL value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_tiempoRelacionLaboral,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Evaluador
       * @param value Evaluador of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByEvaluador(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_evaluador, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Evaluador
       * @param value Evaluador of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByEvaluador(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_evaluador,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Cursos
       * @param value Cursos of the type mx.gob.inmujeres.swb.CursoEvaluacion
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCursos(mx.gob.inmujeres.swb.CursoEvaluacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_hasCursos, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined Cursos
       * @param value Cursos of the type mx.gob.inmujeres.swb.CursoEvaluacion
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCursos(mx.gob.inmujeres.swb.CursoEvaluacion value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_hasCursos,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined CuestionarioAplicado
       * @param value CuestionarioAplicado of the type mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @param model Model of the mx.gob.inmujeres.swb.Desempenio
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCuestionarioAplicado(mx.gob.inmujeres.swb.EvaluacionCuestionario value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(inm_cuestionarioAplicado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all mx.gob.inmujeres.swb.Desempenio with a determined CuestionarioAplicado
       * @param value CuestionarioAplicado of the type mx.gob.inmujeres.swb.EvaluacionCuestionario
       * @return Iterator with all the mx.gob.inmujeres.swb.Desempenio
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Desempenio> listDesempenioByCuestionarioAplicado(mx.gob.inmujeres.swb.EvaluacionCuestionario value)
        {
            org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Desempenio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(inm_cuestionarioAplicado,value.getSemanticObject(),sclass));
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
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
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
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
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
   * Gets all the mx.gob.inmujeres.swb.MetaEvaluacion
   * @return A GenericIterator with all the mx.gob.inmujeres.swb.MetaEvaluacion
   */

    public org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion> listMetases()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.MetaEvaluacion>(getSemanticObject().listObjectProperties(inm_hasMetas));
    }

   /**
   * Gets true if has a Metas
   * @param value mx.gob.inmujeres.swb.MetaEvaluacion to verify
   * @return true if the mx.gob.inmujeres.swb.MetaEvaluacion exists, false otherwise
   */
    public boolean hasMetas(mx.gob.inmujeres.swb.MetaEvaluacion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_hasMetas,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Metas
   * @param value mx.gob.inmujeres.swb.MetaEvaluacion to add
   */

    public void addMetas(mx.gob.inmujeres.swb.MetaEvaluacion value)
    {
        getSemanticObject().addObjectProperty(inm_hasMetas, value.getSemanticObject());
    }
   /**
   * Removes all the Metas
   */

    public void removeAllMetas()
    {
        getSemanticObject().removeProperty(inm_hasMetas);
    }
   /**
   * Removes a Metas
   * @param value mx.gob.inmujeres.swb.MetaEvaluacion to remove
   */

    public void removeMetas(mx.gob.inmujeres.swb.MetaEvaluacion value)
    {
        getSemanticObject().removeObjectProperty(inm_hasMetas,value.getSemanticObject());
    }

   /**
   * Gets the Metas
   * @return a mx.gob.inmujeres.swb.MetaEvaluacion
   */
    public mx.gob.inmujeres.swb.MetaEvaluacion getMetas()
    {
         mx.gob.inmujeres.swb.MetaEvaluacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_hasMetas);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.MetaEvaluacion)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property TiempoRelacionLaboral
   * @param value TiempoRelacionLaboral to set
   */

    public void setTiempoRelacionLaboral(mx.gob.inmujeres.swb.TiempoRL value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(inm_tiempoRelacionLaboral, value.getSemanticObject());
        }else
        {
            removeTiempoRelacionLaboral();
        }
    }
   /**
   * Remove the value for TiempoRelacionLaboral property
   */

    public void removeTiempoRelacionLaboral()
    {
        getSemanticObject().removeProperty(inm_tiempoRelacionLaboral);
    }

   /**
   * Gets the TiempoRelacionLaboral
   * @return a mx.gob.inmujeres.swb.TiempoRL
   */
    public mx.gob.inmujeres.swb.TiempoRL getTiempoRelacionLaboral()
    {
         mx.gob.inmujeres.swb.TiempoRL ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_tiempoRelacionLaboral);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.TiempoRL)obj.createGenericInstance();
         }
         return ret;
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
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
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
   * Gets all the mx.gob.inmujeres.swb.CursoEvaluacion
   * @return A GenericIterator with all the mx.gob.inmujeres.swb.CursoEvaluacion
   */

    public org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion> listCursoses()
    {
        return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.CursoEvaluacion>(getSemanticObject().listObjectProperties(inm_hasCursos));
    }

   /**
   * Gets true if has a Cursos
   * @param value mx.gob.inmujeres.swb.CursoEvaluacion to verify
   * @return true if the mx.gob.inmujeres.swb.CursoEvaluacion exists, false otherwise
   */
    public boolean hasCursos(mx.gob.inmujeres.swb.CursoEvaluacion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(inm_hasCursos,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Cursos
   * @param value mx.gob.inmujeres.swb.CursoEvaluacion to add
   */

    public void addCursos(mx.gob.inmujeres.swb.CursoEvaluacion value)
    {
        getSemanticObject().addObjectProperty(inm_hasCursos, value.getSemanticObject());
    }
   /**
   * Removes all the Cursos
   */

    public void removeAllCursos()
    {
        getSemanticObject().removeProperty(inm_hasCursos);
    }
   /**
   * Removes a Cursos
   * @param value mx.gob.inmujeres.swb.CursoEvaluacion to remove
   */

    public void removeCursos(mx.gob.inmujeres.swb.CursoEvaluacion value)
    {
        getSemanticObject().removeObjectProperty(inm_hasCursos,value.getSemanticObject());
    }

   /**
   * Gets the Cursos
   * @return a mx.gob.inmujeres.swb.CursoEvaluacion
   */
    public mx.gob.inmujeres.swb.CursoEvaluacion getCursos()
    {
         mx.gob.inmujeres.swb.CursoEvaluacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_hasCursos);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.CursoEvaluacion)obj.createGenericInstance();
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

    public void setCuestionarioAplicado(mx.gob.inmujeres.swb.EvaluacionCuestionario value)
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
   * @return a mx.gob.inmujeres.swb.EvaluacionCuestionario
   */
    public mx.gob.inmujeres.swb.EvaluacionCuestionario getCuestionarioAplicado()
    {
         mx.gob.inmujeres.swb.EvaluacionCuestionario ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(inm_cuestionarioAplicado);
         if(obj!=null)
         {
             ret=(mx.gob.inmujeres.swb.EvaluacionCuestionario)obj.createGenericInstance();
         }
         return ret;
    }
}
