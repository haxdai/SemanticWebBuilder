package com.infotec.rh.syr.swb.base;


   /**
   * Encapsula las propiedades de la generación del contrato 
   */
public abstract class ContratoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_referenciaContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#referenciaContratacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_compensacionGarantizada=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#compensacionGarantizada");
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudBajaRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudBajaRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudBajaContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudBajaContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_fileContratoFirmado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileContratoFirmado");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioProceso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioProceso");
    public static final org.semanticwb.platform.SemanticProperty intranet_colaboradoAnteriormente=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#colaboradoAnteriormente");
    public static final org.semanticwb.platform.SemanticClass intranet_PeriodoPagos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#PeriodoPagos");
    public static final org.semanticwb.platform.SemanticProperty intranet_periodoPagos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#periodoPagos");
   /**
   * Elemento utilizado para guardar los Documentos Probatorios que respalda la información del CV capturada por el usuario
   */
    public static final org.semanticwb.platform.SemanticClass intranet_DocumentoProbatorio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#DocumentoProbatorio");
    public static final org.semanticwb.platform.SemanticProperty intranet_documentosContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentosContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_FechaEnvioContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#FechaEnvioContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_numEmpleado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numEmpleado");
    public static final org.semanticwb.platform.SemanticProperty intranet_clabeInterbancaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#clabeInterbancaria");
    public static final org.semanticwb.platform.SemanticProperty intranet_RFC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#RFC");
    public static final org.semanticwb.platform.SemanticProperty intranet_seguridadSocial=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#seguridadSocial");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaEntregaRH=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaEntregaRH");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaIngresoInfotec=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaIngresoInfotec");
   /**
   * Elemento que contiene la información del perfil del usuario requerido
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudRecursoContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudRecursoContrato");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_encargadoCotejo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#encargadoCotejo");
    public static final org.semanticwb.platform.SemanticProperty intranet_documentosPresentados=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#documentosPresentados");
    public static final org.semanticwb.platform.SemanticClass intranet_SedeRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SedeRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_sedeRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sedeRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_fileConstanciaSFP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fileConstanciaSFP");
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaMesesLetra=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaMesesLetra");
    public static final org.semanticwb.platform.SemanticProperty intranet_estatusContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#estatusContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_creditoInfonavitFonacot=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#creditoInfonavitFonacot");
    public static final org.semanticwb.platform.SemanticProperty intranet_importeMensualLetra=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#importeMensualLetra");
    public static final org.semanticwb.platform.SemanticProperty intranet_importePagosLetra=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#importePagosLetra");
    public static final org.semanticwb.platform.SemanticClass intranet_Banco=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Banco");
    public static final org.semanticwb.platform.SemanticProperty intranet_banco=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#banco");
    public static final org.semanticwb.platform.SemanticProperty intranet_numeroPagos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numeroPagos");
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudPromocion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudPromocion");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitudPromocionContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitudPromocionContrato");
   /**
   * Registra observaciones al contrato
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_observacionesContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#observacionesContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoDeContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoDeContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_presentaDeclaracion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#presentaDeclaracion");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereKit");
    public static final org.semanticwb.platform.SemanticProperty intranet_cargoAutorizasolicitudContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cargoAutorizasolicitudContrato");
    public static final org.semanticwb.platform.SemanticClass intranet_NivelEstudioContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#NivelEstudioContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelEstudioContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelEstudioContrato");
    public static final org.semanticwb.platform.SemanticProperty intranet_folioContrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#folioContrato");
   /**
   * Encapsula las propiedades de la generación del contrato
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Contrato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Contrato");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Contrato");

    public static class ClassMgr
    {
       /**
       * Returns a list of Contrato for a model
       * @param model Model to find
       * @return Iterator of com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato>(it, true);
        }
       /**
       * Returns a list of com.infotec.rh.syr.swb.Contrato for all models
       * @return Iterator of com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato>(it, true);
        }

        public static com.infotec.rh.syr.swb.Contrato createContrato(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.rh.syr.swb.Contrato.ClassMgr.createContrato(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return A com.infotec.rh.syr.swb.Contrato
       */
        public static com.infotec.rh.syr.swb.Contrato getContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Contrato)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return A com.infotec.rh.syr.swb.Contrato
       */
        public static com.infotec.rh.syr.swb.Contrato createContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.rh.syr.swb.Contrato)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       */
        public static void removeContrato(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.rh.syr.swb.Contrato
       * @param id Identifier for com.infotec.rh.syr.swb.Contrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return true if the com.infotec.rh.syr.swb.Contrato exists, false otherwise
       */

        public static boolean hasContrato(String id, org.semanticwb.model.SWBModel model)
        {
            return (getContrato(id, model)!=null);
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudBajaContrato
       * @param value SolicitudBajaContrato of the type com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudBajaContrato(com.infotec.rh.syr.swb.SolicitudBajaRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudBajaContrato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudBajaContrato
       * @param value SolicitudBajaContrato of the type com.infotec.rh.syr.swb.SolicitudBajaRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudBajaContrato(com.infotec.rh.syr.swb.SolicitudBajaRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudBajaContrato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined PeriodoPagos
       * @param value PeriodoPagos of the type com.infotec.cvi.swb.PeriodoPagos
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByPeriodoPagos(com.infotec.cvi.swb.PeriodoPagos value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_periodoPagos, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined PeriodoPagos
       * @param value PeriodoPagos of the type com.infotec.cvi.swb.PeriodoPagos
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByPeriodoPagos(com.infotec.cvi.swb.PeriodoPagos value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_periodoPagos,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined DocumentosContrato
       * @param value DocumentosContrato of the type com.infotec.cvi.swb.DocumentoProbatorio
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByDocumentosContrato(com.infotec.cvi.swb.DocumentoProbatorio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_documentosContrato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined DocumentosContrato
       * @param value DocumentosContrato of the type com.infotec.cvi.swb.DocumentoProbatorio
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByDocumentosContrato(com.infotec.cvi.swb.DocumentoProbatorio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_documentosContrato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudRecursoContrato
       * @param value SolicitudRecursoContrato of the type com.infotec.cvi.swb.SolicitudRecurso
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudRecursoContrato(com.infotec.cvi.swb.SolicitudRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecursoContrato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudRecursoContrato
       * @param value SolicitudRecursoContrato of the type com.infotec.cvi.swb.SolicitudRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudRecursoContrato(com.infotec.cvi.swb.SolicitudRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudRecursoContrato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined EncargadoCotejo
       * @param value EncargadoCotejo of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByEncargadoCotejo(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoCotejo, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined EncargadoCotejo
       * @param value EncargadoCotejo of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByEncargadoCotejo(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoCotejo,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SedeRecurso
       * @param value SedeRecurso of the type com.infotec.eworkplace.swb.SedeRecurso
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySedeRecurso(com.infotec.eworkplace.swb.SedeRecurso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_sedeRecurso, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SedeRecurso
       * @param value SedeRecurso of the type com.infotec.eworkplace.swb.SedeRecurso
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySedeRecurso(com.infotec.eworkplace.swb.SedeRecurso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_sedeRecurso,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Banco
       * @param value Banco of the type com.infotec.eworkplace.swb.Banco
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByBanco(com.infotec.eworkplace.swb.Banco value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_banco, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined Banco
       * @param value Banco of the type com.infotec.eworkplace.swb.Banco
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByBanco(com.infotec.eworkplace.swb.Banco value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_banco,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudPromocionContrato
       * @param value SolicitudPromocionContrato of the type com.infotec.rh.syr.swb.SolicitudPromocion
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudPromocionContrato(com.infotec.rh.syr.swb.SolicitudPromocion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudPromocionContrato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined SolicitudPromocionContrato
       * @param value SolicitudPromocionContrato of the type com.infotec.rh.syr.swb.SolicitudPromocion
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoBySolicitudPromocionContrato(com.infotec.rh.syr.swb.SolicitudPromocion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitudPromocionContrato,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined NivelEstudioContrato
       * @param value NivelEstudioContrato of the type com.infotec.eworkplace.swb.NivelEstudioContrato
       * @param model Model of the com.infotec.rh.syr.swb.Contrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByNivelEstudioContrato(com.infotec.eworkplace.swb.NivelEstudioContrato value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelEstudioContrato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.rh.syr.swb.Contrato with a determined NivelEstudioContrato
       * @param value NivelEstudioContrato of the type com.infotec.eworkplace.swb.NivelEstudioContrato
       * @return Iterator with all the com.infotec.rh.syr.swb.Contrato
       */

        public static java.util.Iterator<com.infotec.rh.syr.swb.Contrato> listContratoByNivelEstudioContrato(com.infotec.eworkplace.swb.NivelEstudioContrato value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.rh.syr.swb.Contrato> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelEstudioContrato,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static ContratoBase.ClassMgr getContratoClassMgr()
    {
        return new ContratoBase.ClassMgr();
    }

   /**
   * Constructs a ContratoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Contrato
   */
    public ContratoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the ReferenciaContratacion property
* @return String with the ReferenciaContratacion
*/
    public String getReferenciaContratacion()
    {
        return getSemanticObject().getProperty(intranet_referenciaContratacion);
    }

/**
* Sets the ReferenciaContratacion property
* @param value long with the ReferenciaContratacion
*/
    public void setReferenciaContratacion(String value)
    {
        getSemanticObject().setProperty(intranet_referenciaContratacion, value);
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
* Gets the CompensacionGarantizada property
* @return String with the CompensacionGarantizada
*/
    public String getCompensacionGarantizada()
    {
        return getSemanticObject().getProperty(intranet_compensacionGarantizada);
    }

/**
* Sets the CompensacionGarantizada property
* @param value long with the CompensacionGarantizada
*/
    public void setCompensacionGarantizada(String value)
    {
        getSemanticObject().setProperty(intranet_compensacionGarantizada, value);
    }
   /**
   * Sets the value for the property SolicitudBajaContrato
   * @param value SolicitudBajaContrato to set
   */

    public void setSolicitudBajaContrato(com.infotec.rh.syr.swb.SolicitudBajaRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudBajaContrato, value.getSemanticObject());
        }else
        {
            removeSolicitudBajaContrato();
        }
    }
   /**
   * Remove the value for SolicitudBajaContrato property
   */

    public void removeSolicitudBajaContrato()
    {
        getSemanticObject().removeProperty(intranet_solicitudBajaContrato);
    }

   /**
   * Gets the SolicitudBajaContrato
   * @return a com.infotec.rh.syr.swb.SolicitudBajaRecurso
   */
    public com.infotec.rh.syr.swb.SolicitudBajaRecurso getSolicitudBajaContrato()
    {
         com.infotec.rh.syr.swb.SolicitudBajaRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudBajaContrato);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.SolicitudBajaRecurso)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FileContratoFirmado property
* @return String with the FileContratoFirmado
*/
    public String getFileContratoFirmado()
    {
        return getSemanticObject().getProperty(intranet_fileContratoFirmado);
    }

/**
* Sets the FileContratoFirmado property
* @param value long with the FileContratoFirmado
*/
    public void setFileContratoFirmado(String value)
    {
        getSemanticObject().setProperty(intranet_fileContratoFirmado, value);
    }

/**
* Gets the FolioProceso property
* @return String with the FolioProceso
*/
    public String getFolioProceso()
    {
        return getSemanticObject().getProperty(intranet_folioProceso);
    }

/**
* Sets the FolioProceso property
* @param value long with the FolioProceso
*/
    public void setFolioProceso(String value)
    {
        getSemanticObject().setProperty(intranet_folioProceso, value);
    }

/**
* Gets the ColaboradoAnteriormente property
* @return boolean with the ColaboradoAnteriormente
*/
    public boolean isColaboradoAnteriormente()
    {
        return getSemanticObject().getBooleanProperty(intranet_colaboradoAnteriormente);
    }

/**
* Sets the ColaboradoAnteriormente property
* @param value long with the ColaboradoAnteriormente
*/
    public void setColaboradoAnteriormente(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_colaboradoAnteriormente, value);
    }
   /**
   * Sets the value for the property PeriodoPagos
   * @param value PeriodoPagos to set
   */

    public void setPeriodoPagos(com.infotec.cvi.swb.PeriodoPagos value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_periodoPagos, value.getSemanticObject());
        }else
        {
            removePeriodoPagos();
        }
    }
   /**
   * Remove the value for PeriodoPagos property
   */

    public void removePeriodoPagos()
    {
        getSemanticObject().removeProperty(intranet_periodoPagos);
    }

   /**
   * Gets the PeriodoPagos
   * @return a com.infotec.cvi.swb.PeriodoPagos
   */
    public com.infotec.cvi.swb.PeriodoPagos getPeriodoPagos()
    {
         com.infotec.cvi.swb.PeriodoPagos ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_periodoPagos);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.PeriodoPagos)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property DocumentosContrato
   * @param value DocumentosContrato to set
   */

    public void setDocumentosContrato(com.infotec.cvi.swb.DocumentoProbatorio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_documentosContrato, value.getSemanticObject());
        }else
        {
            removeDocumentosContrato();
        }
    }
   /**
   * Remove the value for DocumentosContrato property
   */

    public void removeDocumentosContrato()
    {
        getSemanticObject().removeProperty(intranet_documentosContrato);
    }

   /**
   * Gets the DocumentosContrato
   * @return a com.infotec.cvi.swb.DocumentoProbatorio
   */
    public com.infotec.cvi.swb.DocumentoProbatorio getDocumentosContrato()
    {
         com.infotec.cvi.swb.DocumentoProbatorio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_documentosContrato);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.DocumentoProbatorio)obj.createGenericInstance();
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
* Gets the FechaEnvioContrato property
* @return java.util.Date with the FechaEnvioContrato
*/
    public java.util.Date getFechaEnvioContrato()
    {
        return getSemanticObject().getDateProperty(intranet_FechaEnvioContrato);
    }

/**
* Sets the FechaEnvioContrato property
* @param value long with the FechaEnvioContrato
*/
    public void setFechaEnvioContrato(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_FechaEnvioContrato, value);
    }

/**
* Gets the NumEmpleado property
* @return int with the NumEmpleado
*/
    public int getNumEmpleado()
    {
        return getSemanticObject().getIntProperty(intranet_numEmpleado);
    }

/**
* Sets the NumEmpleado property
* @param value long with the NumEmpleado
*/
    public void setNumEmpleado(int value)
    {
        getSemanticObject().setIntProperty(intranet_numEmpleado, value);
    }

/**
* Gets the ClabeInterbancaria property
* @return int with the ClabeInterbancaria
*/
    public int getClabeInterbancaria()
    {
        return getSemanticObject().getIntProperty(intranet_clabeInterbancaria);
    }

/**
* Sets the ClabeInterbancaria property
* @param value long with the ClabeInterbancaria
*/
    public void setClabeInterbancaria(int value)
    {
        getSemanticObject().setIntProperty(intranet_clabeInterbancaria, value);
    }

/**
* Gets the RFC property
* @return String with the RFC
*/
    public String getRFC()
    {
        return getSemanticObject().getProperty(intranet_RFC);
    }

/**
* Sets the RFC property
* @param value long with the RFC
*/
    public void setRFC(String value)
    {
        getSemanticObject().setProperty(intranet_RFC, value);
    }

/**
* Gets the SeguridadSocial property
* @return String with the SeguridadSocial
*/
    public String getSeguridadSocial()
    {
        return getSemanticObject().getProperty(intranet_seguridadSocial);
    }

/**
* Sets the SeguridadSocial property
* @param value long with the SeguridadSocial
*/
    public void setSeguridadSocial(String value)
    {
        getSemanticObject().setProperty(intranet_seguridadSocial, value);
    }

/**
* Gets the FechaEntregaRH property
* @return java.util.Date with the FechaEntregaRH
*/
    public java.util.Date getFechaEntregaRH()
    {
        return getSemanticObject().getDateProperty(intranet_fechaEntregaRH);
    }

/**
* Sets the FechaEntregaRH property
* @param value long with the FechaEntregaRH
*/
    public void setFechaEntregaRH(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaEntregaRH, value);
    }

/**
* Gets the FechaIngresoInfotec property
* @return java.util.Date with the FechaIngresoInfotec
*/
    public java.util.Date getFechaIngresoInfotec()
    {
        return getSemanticObject().getDateProperty(intranet_fechaIngresoInfotec);
    }

/**
* Sets the FechaIngresoInfotec property
* @param value long with the FechaIngresoInfotec
*/
    public void setFechaIngresoInfotec(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaIngresoInfotec, value);
    }
   /**
   * Sets the value for the property SolicitudRecursoContrato
   * @param value SolicitudRecursoContrato to set
   */

    public void setSolicitudRecursoContrato(com.infotec.cvi.swb.SolicitudRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudRecursoContrato, value.getSemanticObject());
        }else
        {
            removeSolicitudRecursoContrato();
        }
    }
   /**
   * Remove the value for SolicitudRecursoContrato property
   */

    public void removeSolicitudRecursoContrato()
    {
        getSemanticObject().removeProperty(intranet_solicitudRecursoContrato);
    }

   /**
   * Gets the SolicitudRecursoContrato
   * @return a com.infotec.cvi.swb.SolicitudRecurso
   */
    public com.infotec.cvi.swb.SolicitudRecurso getSolicitudRecursoContrato()
    {
         com.infotec.cvi.swb.SolicitudRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudRecursoContrato);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.SolicitudRecurso)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EncargadoCotejo
   * @param value EncargadoCotejo to set
   */

    public void setEncargadoCotejo(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_encargadoCotejo, value.getSemanticObject());
        }else
        {
            removeEncargadoCotejo();
        }
    }
   /**
   * Remove the value for EncargadoCotejo property
   */

    public void removeEncargadoCotejo()
    {
        getSemanticObject().removeProperty(intranet_encargadoCotejo);
    }

   /**
   * Gets the EncargadoCotejo
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEncargadoCotejo()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_encargadoCotejo);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the DocumentosPresentados property
* @return String with the DocumentosPresentados
*/
    public String getDocumentosPresentados()
    {
        return getSemanticObject().getProperty(intranet_documentosPresentados);
    }

/**
* Sets the DocumentosPresentados property
* @param value long with the DocumentosPresentados
*/
    public void setDocumentosPresentados(String value)
    {
        getSemanticObject().setProperty(intranet_documentosPresentados, value);
    }
   /**
   * Sets the value for the property SedeRecurso
   * @param value SedeRecurso to set
   */

    public void setSedeRecurso(com.infotec.eworkplace.swb.SedeRecurso value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_sedeRecurso, value.getSemanticObject());
        }else
        {
            removeSedeRecurso();
        }
    }
   /**
   * Remove the value for SedeRecurso property
   */

    public void removeSedeRecurso()
    {
        getSemanticObject().removeProperty(intranet_sedeRecurso);
    }

   /**
   * Gets the SedeRecurso
   * @return a com.infotec.eworkplace.swb.SedeRecurso
   */
    public com.infotec.eworkplace.swb.SedeRecurso getSedeRecurso()
    {
         com.infotec.eworkplace.swb.SedeRecurso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_sedeRecurso);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.SedeRecurso)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FileConstanciaSFP property
* @return String with the FileConstanciaSFP
*/
    public String getFileConstanciaSFP()
    {
        return getSemanticObject().getProperty(intranet_fileConstanciaSFP);
    }

/**
* Sets the FileConstanciaSFP property
* @param value long with the FileConstanciaSFP
*/
    public void setFileConstanciaSFP(String value)
    {
        getSemanticObject().setProperty(intranet_fileConstanciaSFP, value);
    }

/**
* Gets the VigenciaMesesLetra property
* @return String with the VigenciaMesesLetra
*/
    public String getVigenciaMesesLetra()
    {
        return getSemanticObject().getProperty(intranet_vigenciaMesesLetra);
    }

/**
* Sets the VigenciaMesesLetra property
* @param value long with the VigenciaMesesLetra
*/
    public void setVigenciaMesesLetra(String value)
    {
        getSemanticObject().setProperty(intranet_vigenciaMesesLetra, value);
    }

/**
* Gets the EstatusContrato property
* @return String with the EstatusContrato
*/
    public String getEstatusContrato()
    {
        return getSemanticObject().getProperty(intranet_estatusContrato);
    }

/**
* Sets the EstatusContrato property
* @param value long with the EstatusContrato
*/
    public void setEstatusContrato(String value)
    {
        getSemanticObject().setProperty(intranet_estatusContrato, value);
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
* Gets the CreditoInfonavitFonacot property
* @return String with the CreditoInfonavitFonacot
*/
    public String getCreditoInfonavitFonacot()
    {
        return getSemanticObject().getProperty(intranet_creditoInfonavitFonacot);
    }

/**
* Sets the CreditoInfonavitFonacot property
* @param value long with the CreditoInfonavitFonacot
*/
    public void setCreditoInfonavitFonacot(String value)
    {
        getSemanticObject().setProperty(intranet_creditoInfonavitFonacot, value);
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
* Gets the ImporteMensualLetra property
* @return String with the ImporteMensualLetra
*/
    public String getImporteMensualLetra()
    {
        return getSemanticObject().getProperty(intranet_importeMensualLetra);
    }

/**
* Sets the ImporteMensualLetra property
* @param value long with the ImporteMensualLetra
*/
    public void setImporteMensualLetra(String value)
    {
        getSemanticObject().setProperty(intranet_importeMensualLetra, value);
    }

/**
* Gets the ImportePagosLetra property
* @return String with the ImportePagosLetra
*/
    public String getImportePagosLetra()
    {
        return getSemanticObject().getProperty(intranet_importePagosLetra);
    }

/**
* Sets the ImportePagosLetra property
* @param value long with the ImportePagosLetra
*/
    public void setImportePagosLetra(String value)
    {
        getSemanticObject().setProperty(intranet_importePagosLetra, value);
    }
   /**
   * Sets the value for the property Banco
   * @param value Banco to set
   */

    public void setBanco(com.infotec.eworkplace.swb.Banco value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_banco, value.getSemanticObject());
        }else
        {
            removeBanco();
        }
    }
   /**
   * Remove the value for Banco property
   */

    public void removeBanco()
    {
        getSemanticObject().removeProperty(intranet_banco);
    }

   /**
   * Gets the Banco
   * @return a com.infotec.eworkplace.swb.Banco
   */
    public com.infotec.eworkplace.swb.Banco getBanco()
    {
         com.infotec.eworkplace.swb.Banco ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_banco);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Banco)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NumeroPagos property
* @return int with the NumeroPagos
*/
    public int getNumeroPagos()
    {
        return getSemanticObject().getIntProperty(intranet_numeroPagos);
    }

/**
* Sets the NumeroPagos property
* @param value long with the NumeroPagos
*/
    public void setNumeroPagos(int value)
    {
        getSemanticObject().setIntProperty(intranet_numeroPagos, value);
    }
   /**
   * Sets the value for the property SolicitudPromocionContrato
   * @param value SolicitudPromocionContrato to set
   */

    public void setSolicitudPromocionContrato(com.infotec.rh.syr.swb.SolicitudPromocion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitudPromocionContrato, value.getSemanticObject());
        }else
        {
            removeSolicitudPromocionContrato();
        }
    }
   /**
   * Remove the value for SolicitudPromocionContrato property
   */

    public void removeSolicitudPromocionContrato()
    {
        getSemanticObject().removeProperty(intranet_solicitudPromocionContrato);
    }

   /**
   * Gets the SolicitudPromocionContrato
   * @return a com.infotec.rh.syr.swb.SolicitudPromocion
   */
    public com.infotec.rh.syr.swb.SolicitudPromocion getSolicitudPromocionContrato()
    {
         com.infotec.rh.syr.swb.SolicitudPromocion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitudPromocionContrato);
         if(obj!=null)
         {
             ret=(com.infotec.rh.syr.swb.SolicitudPromocion)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the ObservacionesContrato property
* @return String with the ObservacionesContrato
*/
    public String getObservacionesContrato()
    {
        return getSemanticObject().getProperty(intranet_observacionesContrato);
    }

/**
* Sets the ObservacionesContrato property
* @param value long with the ObservacionesContrato
*/
    public void setObservacionesContrato(String value)
    {
        getSemanticObject().setProperty(intranet_observacionesContrato, value);
    }

/**
* Gets the TipoDeContrato property
* @return int with the TipoDeContrato
*/
    public int getTipoDeContrato()
    {
        return getSemanticObject().getIntProperty(intranet_tipoDeContrato);
    }

/**
* Sets the TipoDeContrato property
* @param value long with the TipoDeContrato
*/
    public void setTipoDeContrato(int value)
    {
        getSemanticObject().setIntProperty(intranet_tipoDeContrato, value);
    }

/**
* Gets the PresentaDeclaracion property
* @return boolean with the PresentaDeclaracion
*/
    public boolean isPresentaDeclaracion()
    {
        return getSemanticObject().getBooleanProperty(intranet_presentaDeclaracion);
    }

/**
* Sets the PresentaDeclaracion property
* @param value long with the PresentaDeclaracion
*/
    public void setPresentaDeclaracion(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_presentaDeclaracion, value);
    }

/**
* Gets the RequiereKit property
* @return boolean with the RequiereKit
*/
    public boolean isRequiereKit()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereKit);
    }

/**
* Sets the RequiereKit property
* @param value long with the RequiereKit
*/
    public void setRequiereKit(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereKit, value);
    }

/**
* Gets the CargoAutorizasolicitudContrato property
* @return String with the CargoAutorizasolicitudContrato
*/
    public String getCargoAutorizasolicitudContrato()
    {
        return getSemanticObject().getProperty(intranet_cargoAutorizasolicitudContrato);
    }

/**
* Sets the CargoAutorizasolicitudContrato property
* @param value long with the CargoAutorizasolicitudContrato
*/
    public void setCargoAutorizasolicitudContrato(String value)
    {
        getSemanticObject().setProperty(intranet_cargoAutorizasolicitudContrato, value);
    }
   /**
   * Sets the value for the property NivelEstudioContrato
   * @param value NivelEstudioContrato to set
   */

    public void setNivelEstudioContrato(com.infotec.eworkplace.swb.NivelEstudioContrato value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelEstudioContrato, value.getSemanticObject());
        }else
        {
            removeNivelEstudioContrato();
        }
    }
   /**
   * Remove the value for NivelEstudioContrato property
   */

    public void removeNivelEstudioContrato()
    {
        getSemanticObject().removeProperty(intranet_nivelEstudioContrato);
    }

   /**
   * Gets the NivelEstudioContrato
   * @return a com.infotec.eworkplace.swb.NivelEstudioContrato
   */
    public com.infotec.eworkplace.swb.NivelEstudioContrato getNivelEstudioContrato()
    {
         com.infotec.eworkplace.swb.NivelEstudioContrato ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelEstudioContrato);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.NivelEstudioContrato)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the FolioContrato property
* @return String with the FolioContrato
*/
    public String getFolioContrato()
    {
        return getSemanticObject().getProperty(intranet_folioContrato);
    }

/**
* Sets the FolioContrato property
* @param value long with the FolioContrato
*/
    public void setFolioContrato(String value)
    {
        getSemanticObject().setProperty(intranet_folioContrato, value);
    }
}
