package com.infotec.cvi.swb.base;


   /**
   * Elemento que contiene la información del Kit de nuevo ingreso de  la persona 
   */
public abstract class KitNuevoIngresoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Solicitable,org.semanticwb.model.Descriptiveable,org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitaTarjetaAcceso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitaTarjetaAcceso");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelPrivilegioLlamadas=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelPrivilegioLlamadas");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereMSI=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereMSI");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoProjectServer=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoProjectServer");
    public static final org.semanticwb.platform.SemanticProperty intranet_validaSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#validaSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoMultifuncional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoMultifuncional");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitaExtensionTelefonica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitaExtensionTelefonica");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_encargadoValidaRH=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#encargadoValidaRH");
   /**
   * Elemento utilizado para la Justificación de un Teléfono para la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_JustificacionTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#JustificacionTelefono");
    public static final org.semanticwb.platform.SemanticProperty intranet_equipoTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#equipoTelefono");
    public static final org.semanticwb.platform.SemanticProperty intranet_equipoComputadora=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#equipoComputadora");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoCentroDatos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoCentroDatos");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoServiceManager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoServiceManager");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoOficinaCentroDatos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoOficinaCentroDatos");
   /**
   * Elemento utilizado para la Justificación del Celular para la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_JustificacionCelular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#JustificacionCelular");
    public static final org.semanticwb.platform.SemanticProperty intranet_equipoCelular=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#equipoCelular");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoRedInalambrica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoRedInalambrica");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitaListaCorreoInterna=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitaListaCorreoInterna");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoDominio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoDominio");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoLMS=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoLMS");
    public static final org.semanticwb.platform.SemanticProperty intranet_nuevoRecurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nuevoRecurso");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitaCorreoElectronico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitaCorreoElectronico");
   /**
   * Descripción detallada de la ubicación física
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_describirUbicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#describirUbicacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_otrosServicios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#otrosServicios");
    public static final org.semanticwb.platform.SemanticProperty intranet_equipoDiadema=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#equipoDiadema");
    public static final org.semanticwb.platform.SemanticProperty intranet_FechaSolicitud=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#FechaSolicitud");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoImpresora=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoImpresora");
   /**
   * Sirve para espeficiar si requiere curso de inducción
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereInducciónKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereInducciónKit");
    public static final org.semanticwb.platform.SemanticProperty intranet_otroSW=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#otroSW");
    public static final org.semanticwb.platform.SemanticProperty intranet_equipoLaptop=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#equipoLaptop");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitaClaveTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitaClaveTelefono");
    public static final org.semanticwb.platform.SemanticProperty intranet_solicitaListaCorreoExterno=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#solicitaListaCorreoExterno");
    public static final org.semanticwb.platform.SemanticProperty intranet_ubicacionEdificio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ubicacionEdificio");
    public static final org.semanticwb.platform.SemanticProperty intranet_requiereTarjetonEstacionamiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#requiereTarjetonEstacionamiento");
    public static final org.semanticwb.platform.SemanticProperty intranet_accesoIntranet=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#accesoIntranet");
   /**
   * Fecha en que enviá el Kit a MSI
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaEnvioMsiKit=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaEnvioMsiKit");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaValidaRH=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaValidaRH");
    public static final org.semanticwb.platform.SemanticProperty intranet_vigenciaTarjeta=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigenciaTarjeta");
   /**
   * Elemento que contiene la información del Kit de nuevo ingreso de  la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_KitNuevoIngreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#KitNuevoIngreso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#KitNuevoIngreso");

    public static class ClassMgr
    {
       /**
       * Returns a list of KitNuevoIngreso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.KitNuevoIngreso for all models
       * @return Iterator of com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso>(it, true);
        }

        public static com.infotec.cvi.swb.KitNuevoIngreso createKitNuevoIngreso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.KitNuevoIngreso.ClassMgr.createKitNuevoIngreso(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.KitNuevoIngreso
       * @param id Identifier for com.infotec.cvi.swb.KitNuevoIngreso
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return A com.infotec.cvi.swb.KitNuevoIngreso
       */
        public static com.infotec.cvi.swb.KitNuevoIngreso getKitNuevoIngreso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.KitNuevoIngreso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.KitNuevoIngreso
       * @param id Identifier for com.infotec.cvi.swb.KitNuevoIngreso
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return A com.infotec.cvi.swb.KitNuevoIngreso
       */
        public static com.infotec.cvi.swb.KitNuevoIngreso createKitNuevoIngreso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.KitNuevoIngreso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.KitNuevoIngreso
       * @param id Identifier for com.infotec.cvi.swb.KitNuevoIngreso
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       */
        public static void removeKitNuevoIngreso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.KitNuevoIngreso
       * @param id Identifier for com.infotec.cvi.swb.KitNuevoIngreso
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return true if the com.infotec.cvi.swb.KitNuevoIngreso exists, false otherwise
       */

        public static boolean hasKitNuevoIngreso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getKitNuevoIngreso(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoBySolicitante(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined Solicitante
       * @param value Solicitante of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoBySolicitante(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_solicitante,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined EncargadoValidaRH
       * @param value EncargadoValidaRH of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByEncargadoValidaRH(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoValidaRH, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined EncargadoValidaRH
       * @param value EncargadoValidaRH of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByEncargadoValidaRH(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_encargadoValidaRH,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined EquipoTelefono
       * @param value EquipoTelefono of the type com.infotec.eworkplace.swb.JustificacionTelefono
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByEquipoTelefono(com.infotec.eworkplace.swb.JustificacionTelefono value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_equipoTelefono, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined EquipoTelefono
       * @param value EquipoTelefono of the type com.infotec.eworkplace.swb.JustificacionTelefono
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByEquipoTelefono(com.infotec.eworkplace.swb.JustificacionTelefono value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_equipoTelefono,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined EquipoCelular
       * @param value EquipoCelular of the type com.infotec.cvi.swb.JustificacionCelular
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByEquipoCelular(com.infotec.cvi.swb.JustificacionCelular value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_equipoCelular, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined EquipoCelular
       * @param value EquipoCelular of the type com.infotec.cvi.swb.JustificacionCelular
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByEquipoCelular(com.infotec.cvi.swb.JustificacionCelular value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_equipoCelular,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined NuevoRecurso
       * @param value NuevoRecurso of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByNuevoRecurso(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nuevoRecurso, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined NuevoRecurso
       * @param value NuevoRecurso of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByNuevoRecurso(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nuevoRecurso,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.cvi.swb.KitNuevoIngreso
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByUsuarioAutoriza(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.KitNuevoIngreso with a determined UsuarioAutoriza
       * @param value UsuarioAutoriza of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.cvi.swb.KitNuevoIngreso
       */

        public static java.util.Iterator<com.infotec.cvi.swb.KitNuevoIngreso> listKitNuevoIngresoByUsuarioAutoriza(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.KitNuevoIngreso> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_usuarioAutoriza,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a KitNuevoIngresoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the KitNuevoIngreso
   */
    public KitNuevoIngresoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NumeroEmpleado property
* @return int with the NumeroEmpleado
*/
    public int getNumeroEmpleado()
    {
        return getSemanticObject().getIntProperty(intranet_numeroEmpleado);
    }

/**
* Sets the NumeroEmpleado property
* @param value long with the NumeroEmpleado
*/
    public void setNumeroEmpleado(int value)
    {
        getSemanticObject().setIntProperty(intranet_numeroEmpleado, value);
    }

/**
* Gets the SolicitaTarjetaAcceso property
* @return boolean with the SolicitaTarjetaAcceso
*/
    public boolean isSolicitaTarjetaAcceso()
    {
        return getSemanticObject().getBooleanProperty(intranet_solicitaTarjetaAcceso);
    }

/**
* Sets the SolicitaTarjetaAcceso property
* @param value long with the SolicitaTarjetaAcceso
*/
    public void setSolicitaTarjetaAcceso(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_solicitaTarjetaAcceso, value);
    }
   /**
   * Sets the value for the property Solicitante
   * @param value Solicitante to set
   */

    public void setSolicitante(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_solicitante, value.getSemanticObject());
        }else
        {
            removeSolicitante();
        }
    }
   /**
   * Remove the value for Solicitante property
   */

    public void removeSolicitante()
    {
        getSemanticObject().removeProperty(intranet_solicitante);
    }

   /**
   * Gets the Solicitante
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getSolicitante()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_solicitante);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
* Gets the NivelPrivilegioLlamadas property
* @return String with the NivelPrivilegioLlamadas
*/
    public String getNivelPrivilegioLlamadas()
    {
        return getSemanticObject().getProperty(intranet_nivelPrivilegioLlamadas);
    }

/**
* Sets the NivelPrivilegioLlamadas property
* @param value long with the NivelPrivilegioLlamadas
*/
    public void setNivelPrivilegioLlamadas(String value)
    {
        getSemanticObject().setProperty(intranet_nivelPrivilegioLlamadas, value);
    }

/**
* Gets the FechaSolicita property
* @return java.util.Date with the FechaSolicita
*/
    public java.util.Date getFechaSolicita()
    {
        return getSemanticObject().getDateProperty(intranet_fechaSolicita);
    }

/**
* Sets the FechaSolicita property
* @param value long with the FechaSolicita
*/
    public void setFechaSolicita(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaSolicita, value);
    }

/**
* Gets the RequiereMSI property
* @return boolean with the RequiereMSI
*/
    public boolean isRequiereMSI()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereMSI);
    }

/**
* Sets the RequiereMSI property
* @param value long with the RequiereMSI
*/
    public void setRequiereMSI(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereMSI, value);
    }

/**
* Gets the AccesoProjectServer property
* @return boolean with the AccesoProjectServer
*/
    public boolean isAccesoProjectServer()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoProjectServer);
    }

/**
* Sets the AccesoProjectServer property
* @param value long with the AccesoProjectServer
*/
    public void setAccesoProjectServer(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoProjectServer, value);
    }

/**
* Gets the ValidaSolicitante property
* @return boolean with the ValidaSolicitante
*/
    public boolean isValidaSolicitante()
    {
        return getSemanticObject().getBooleanProperty(intranet_validaSolicitante);
    }

/**
* Sets the ValidaSolicitante property
* @param value long with the ValidaSolicitante
*/
    public void setValidaSolicitante(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_validaSolicitante, value);
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
* Gets the AccesoMultifuncional property
* @return boolean with the AccesoMultifuncional
*/
    public boolean isAccesoMultifuncional()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoMultifuncional);
    }

/**
* Sets the AccesoMultifuncional property
* @param value long with the AccesoMultifuncional
*/
    public void setAccesoMultifuncional(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoMultifuncional, value);
    }

/**
* Gets the SolicitaExtensionTelefonica property
* @return boolean with the SolicitaExtensionTelefonica
*/
    public boolean isSolicitaExtensionTelefonica()
    {
        return getSemanticObject().getBooleanProperty(intranet_solicitaExtensionTelefonica);
    }

/**
* Sets the SolicitaExtensionTelefonica property
* @param value long with the SolicitaExtensionTelefonica
*/
    public void setSolicitaExtensionTelefonica(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_solicitaExtensionTelefonica, value);
    }
   /**
   * Sets the value for the property EncargadoValidaRH
   * @param value EncargadoValidaRH to set
   */

    public void setEncargadoValidaRH(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_encargadoValidaRH, value.getSemanticObject());
        }else
        {
            removeEncargadoValidaRH();
        }
    }
   /**
   * Remove the value for EncargadoValidaRH property
   */

    public void removeEncargadoValidaRH()
    {
        getSemanticObject().removeProperty(intranet_encargadoValidaRH);
    }

   /**
   * Gets the EncargadoValidaRH
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getEncargadoValidaRH()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_encargadoValidaRH);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EquipoTelefono
   * @param value EquipoTelefono to set
   */

    public void setEquipoTelefono(com.infotec.eworkplace.swb.JustificacionTelefono value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_equipoTelefono, value.getSemanticObject());
        }else
        {
            removeEquipoTelefono();
        }
    }
   /**
   * Remove the value for EquipoTelefono property
   */

    public void removeEquipoTelefono()
    {
        getSemanticObject().removeProperty(intranet_equipoTelefono);
    }

   /**
   * Gets the EquipoTelefono
   * @return a com.infotec.eworkplace.swb.JustificacionTelefono
   */
    public com.infotec.eworkplace.swb.JustificacionTelefono getEquipoTelefono()
    {
         com.infotec.eworkplace.swb.JustificacionTelefono ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_equipoTelefono);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.JustificacionTelefono)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the EquipoComputadora property
* @return boolean with the EquipoComputadora
*/
    public boolean isEquipoComputadora()
    {
        return getSemanticObject().getBooleanProperty(intranet_equipoComputadora);
    }

/**
* Sets the EquipoComputadora property
* @param value long with the EquipoComputadora
*/
    public void setEquipoComputadora(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_equipoComputadora, value);
    }

/**
* Gets the AccesoCentroDatos property
* @return boolean with the AccesoCentroDatos
*/
    public boolean isAccesoCentroDatos()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoCentroDatos);
    }

/**
* Sets the AccesoCentroDatos property
* @param value long with the AccesoCentroDatos
*/
    public void setAccesoCentroDatos(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoCentroDatos, value);
    }

/**
* Gets the AccesoServiceManager property
* @return boolean with the AccesoServiceManager
*/
    public boolean isAccesoServiceManager()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoServiceManager);
    }

/**
* Sets the AccesoServiceManager property
* @param value long with the AccesoServiceManager
*/
    public void setAccesoServiceManager(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoServiceManager, value);
    }

/**
* Gets the AccesoOficinaCentroDatos property
* @return boolean with the AccesoOficinaCentroDatos
*/
    public boolean isAccesoOficinaCentroDatos()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoOficinaCentroDatos);
    }

/**
* Sets the AccesoOficinaCentroDatos property
* @param value long with the AccesoOficinaCentroDatos
*/
    public void setAccesoOficinaCentroDatos(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoOficinaCentroDatos, value);
    }
   /**
   * Sets the value for the property EquipoCelular
   * @param value EquipoCelular to set
   */

    public void setEquipoCelular(com.infotec.cvi.swb.JustificacionCelular value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_equipoCelular, value.getSemanticObject());
        }else
        {
            removeEquipoCelular();
        }
    }
   /**
   * Remove the value for EquipoCelular property
   */

    public void removeEquipoCelular()
    {
        getSemanticObject().removeProperty(intranet_equipoCelular);
    }

   /**
   * Gets the EquipoCelular
   * @return a com.infotec.cvi.swb.JustificacionCelular
   */
    public com.infotec.cvi.swb.JustificacionCelular getEquipoCelular()
    {
         com.infotec.cvi.swb.JustificacionCelular ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_equipoCelular);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.JustificacionCelular)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the AccesoRedInalambrica property
* @return boolean with the AccesoRedInalambrica
*/
    public boolean isAccesoRedInalambrica()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoRedInalambrica);
    }

/**
* Sets the AccesoRedInalambrica property
* @param value long with the AccesoRedInalambrica
*/
    public void setAccesoRedInalambrica(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoRedInalambrica, value);
    }

/**
* Gets the SolicitaListaCorreoInterna property
* @return boolean with the SolicitaListaCorreoInterna
*/
    public boolean isSolicitaListaCorreoInterna()
    {
        return getSemanticObject().getBooleanProperty(intranet_solicitaListaCorreoInterna);
    }

/**
* Sets the SolicitaListaCorreoInterna property
* @param value long with the SolicitaListaCorreoInterna
*/
    public void setSolicitaListaCorreoInterna(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_solicitaListaCorreoInterna, value);
    }

/**
* Gets the AccesoDominio property
* @return boolean with the AccesoDominio
*/
    public boolean isAccesoDominio()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoDominio);
    }

/**
* Sets the AccesoDominio property
* @param value long with the AccesoDominio
*/
    public void setAccesoDominio(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoDominio, value);
    }

/**
* Gets the AccesoLMS property
* @return boolean with the AccesoLMS
*/
    public boolean isAccesoLMS()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoLMS);
    }

/**
* Sets the AccesoLMS property
* @param value long with the AccesoLMS
*/
    public void setAccesoLMS(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoLMS, value);
    }
   /**
   * Sets the value for the property NuevoRecurso
   * @param value NuevoRecurso to set
   */

    public void setNuevoRecurso(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nuevoRecurso, value.getSemanticObject());
        }else
        {
            removeNuevoRecurso();
        }
    }
   /**
   * Remove the value for NuevoRecurso property
   */

    public void removeNuevoRecurso()
    {
        getSemanticObject().removeProperty(intranet_nuevoRecurso);
    }

   /**
   * Gets the NuevoRecurso
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getNuevoRecurso()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nuevoRecurso);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the CargoSolicitante property
* @return String with the CargoSolicitante
*/
    public String getCargoSolicitante()
    {
        return getSemanticObject().getProperty(intranet_cargoSolicitante);
    }

/**
* Sets the CargoSolicitante property
* @param value long with the CargoSolicitante
*/
    public void setCargoSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_cargoSolicitante, value);
    }

/**
* Gets the AdscripcionSolicitante property
* @return String with the AdscripcionSolicitante
*/
    public String getAdscripcionSolicitante()
    {
        return getSemanticObject().getProperty(intranet_adscripcionSolicitante);
    }

/**
* Sets the AdscripcionSolicitante property
* @param value long with the AdscripcionSolicitante
*/
    public void setAdscripcionSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_adscripcionSolicitante, value);
    }

/**
* Gets the Folio property
* @return String with the Folio
*/
    public String getFolio()
    {
        return getSemanticObject().getProperty(intranet_folio);
    }

/**
* Sets the Folio property
* @param value long with the Folio
*/
    public void setFolio(String value)
    {
        getSemanticObject().setProperty(intranet_folio, value);
    }

/**
* Gets the SolicitaCorreoElectronico property
* @return boolean with the SolicitaCorreoElectronico
*/
    public boolean isSolicitaCorreoElectronico()
    {
        return getSemanticObject().getBooleanProperty(intranet_solicitaCorreoElectronico);
    }

/**
* Sets the SolicitaCorreoElectronico property
* @param value long with the SolicitaCorreoElectronico
*/
    public void setSolicitaCorreoElectronico(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_solicitaCorreoElectronico, value);
    }

/**
* Gets the DescribirUbicacion property
* @return String with the DescribirUbicacion
*/
    public String getDescribirUbicacion()
    {
        return getSemanticObject().getProperty(intranet_describirUbicacion);
    }

/**
* Sets the DescribirUbicacion property
* @param value long with the DescribirUbicacion
*/
    public void setDescribirUbicacion(String value)
    {
        getSemanticObject().setProperty(intranet_describirUbicacion, value);
    }

/**
* Gets the OtrosServicios property
* @return String with the OtrosServicios
*/
    public String getOtrosServicios()
    {
        return getSemanticObject().getProperty(intranet_otrosServicios);
    }

/**
* Sets the OtrosServicios property
* @param value long with the OtrosServicios
*/
    public void setOtrosServicios(String value)
    {
        getSemanticObject().setProperty(intranet_otrosServicios, value);
    }

/**
* Gets the EquipoDiadema property
* @return boolean with the EquipoDiadema
*/
    public boolean isEquipoDiadema()
    {
        return getSemanticObject().getBooleanProperty(intranet_equipoDiadema);
    }

/**
* Sets the EquipoDiadema property
* @param value long with the EquipoDiadema
*/
    public void setEquipoDiadema(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_equipoDiadema, value);
    }

/**
* Gets the FechaSolicitud property
* @return java.util.Date with the FechaSolicitud
*/
    public java.util.Date getFechaSolicitud()
    {
        return getSemanticObject().getDateProperty(intranet_FechaSolicitud);
    }

/**
* Sets the FechaSolicitud property
* @param value long with the FechaSolicitud
*/
    public void setFechaSolicitud(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_FechaSolicitud, value);
    }

/**
* Gets the AccesoImpresora property
* @return boolean with the AccesoImpresora
*/
    public boolean isAccesoImpresora()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoImpresora);
    }

/**
* Sets the AccesoImpresora property
* @param value long with the AccesoImpresora
*/
    public void setAccesoImpresora(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoImpresora, value);
    }

/**
* Gets the RequiereInducciónKit property
* @return boolean with the RequiereInducciónKit
*/
    public boolean isRequiereInducciónKit()
    {
        return getSemanticObject().getBooleanProperty(intranet_requiereInducciónKit);
    }

/**
* Sets the RequiereInducciónKit property
* @param value long with the RequiereInducciónKit
*/
    public void setRequiereInducciónKit(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_requiereInducciónKit, value);
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
* Gets the OtroSW property
* @return String with the OtroSW
*/
    public String getOtroSW()
    {
        return getSemanticObject().getProperty(intranet_otroSW);
    }

/**
* Sets the OtroSW property
* @param value long with the OtroSW
*/
    public void setOtroSW(String value)
    {
        getSemanticObject().setProperty(intranet_otroSW, value);
    }

/**
* Gets the EquipoLaptop property
* @return boolean with the EquipoLaptop
*/
    public boolean isEquipoLaptop()
    {
        return getSemanticObject().getBooleanProperty(intranet_equipoLaptop);
    }

/**
* Sets the EquipoLaptop property
* @param value long with the EquipoLaptop
*/
    public void setEquipoLaptop(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_equipoLaptop, value);
    }

/**
* Gets the SolicitaClaveTelefono property
* @return boolean with the SolicitaClaveTelefono
*/
    public boolean isSolicitaClaveTelefono()
    {
        return getSemanticObject().getBooleanProperty(intranet_solicitaClaveTelefono);
    }

/**
* Sets the SolicitaClaveTelefono property
* @param value long with the SolicitaClaveTelefono
*/
    public void setSolicitaClaveTelefono(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_solicitaClaveTelefono, value);
    }

/**
* Gets the ExtensionSolicitante property
* @return String with the ExtensionSolicitante
*/
    public String getExtensionSolicitante()
    {
        return getSemanticObject().getProperty(intranet_extensionSolicitante);
    }

/**
* Sets the ExtensionSolicitante property
* @param value long with the ExtensionSolicitante
*/
    public void setExtensionSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_extensionSolicitante, value);
    }

/**
* Gets the SolicitaListaCorreoExterno property
* @return boolean with the SolicitaListaCorreoExterno
*/
    public boolean isSolicitaListaCorreoExterno()
    {
        return getSemanticObject().getBooleanProperty(intranet_solicitaListaCorreoExterno);
    }

/**
* Sets the SolicitaListaCorreoExterno property
* @param value long with the SolicitaListaCorreoExterno
*/
    public void setSolicitaListaCorreoExterno(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_solicitaListaCorreoExterno, value);
    }
   /**
   * Sets the value for the property UsuarioAutoriza
   * @param value UsuarioAutoriza to set
   */

    public void setUsuarioAutoriza(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_usuarioAutoriza, value.getSemanticObject());
        }else
        {
            removeUsuarioAutoriza();
        }
    }
   /**
   * Remove the value for UsuarioAutoriza property
   */

    public void removeUsuarioAutoriza()
    {
        getSemanticObject().removeProperty(intranet_usuarioAutoriza);
    }

   /**
   * Gets the UsuarioAutoriza
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getUsuarioAutoriza()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_usuarioAutoriza);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the UbicacionEdificio property
* @return String with the UbicacionEdificio
*/
    public String getUbicacionEdificio()
    {
        return getSemanticObject().getProperty(intranet_ubicacionEdificio);
    }

/**
* Sets the UbicacionEdificio property
* @param value long with the UbicacionEdificio
*/
    public void setUbicacionEdificio(String value)
    {
        getSemanticObject().setProperty(intranet_ubicacionEdificio, value);
    }

/**
* Gets the RequiereTarjetonEstacionamiento property
* @return String with the RequiereTarjetonEstacionamiento
*/
    public String getRequiereTarjetonEstacionamiento()
    {
        return getSemanticObject().getProperty(intranet_requiereTarjetonEstacionamiento);
    }

/**
* Sets the RequiereTarjetonEstacionamiento property
* @param value long with the RequiereTarjetonEstacionamiento
*/
    public void setRequiereTarjetonEstacionamiento(String value)
    {
        getSemanticObject().setProperty(intranet_requiereTarjetonEstacionamiento, value);
    }

/**
* Gets the AccesoIntranet property
* @return boolean with the AccesoIntranet
*/
    public boolean isAccesoIntranet()
    {
        return getSemanticObject().getBooleanProperty(intranet_accesoIntranet);
    }

/**
* Sets the AccesoIntranet property
* @param value long with the AccesoIntranet
*/
    public void setAccesoIntranet(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_accesoIntranet, value);
    }

/**
* Gets the FechaEnvioMsiKit property
* @return java.util.Date with the FechaEnvioMsiKit
*/
    public java.util.Date getFechaEnvioMsiKit()
    {
        return getSemanticObject().getDateProperty(intranet_fechaEnvioMsiKit);
    }

/**
* Sets the FechaEnvioMsiKit property
* @param value long with the FechaEnvioMsiKit
*/
    public void setFechaEnvioMsiKit(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaEnvioMsiKit, value);
    }

/**
* Gets the NombreSolicitante property
* @return String with the NombreSolicitante
*/
    public String getNombreSolicitante()
    {
        return getSemanticObject().getProperty(intranet_nombreSolicitante);
    }

/**
* Sets the NombreSolicitante property
* @param value long with the NombreSolicitante
*/
    public void setNombreSolicitante(String value)
    {
        getSemanticObject().setProperty(intranet_nombreSolicitante, value);
    }

/**
* Gets the Autoriza property
* @return String with the Autoriza
*/
    public String getAutoriza()
    {
        return getSemanticObject().getProperty(intranet_autoriza);
    }

/**
* Sets the Autoriza property
* @param value long with the Autoriza
*/
    public void setAutoriza(String value)
    {
        getSemanticObject().setProperty(intranet_autoriza, value);
    }

/**
* Gets the FechaValidaRH property
* @return java.util.Date with the FechaValidaRH
*/
    public java.util.Date getFechaValidaRH()
    {
        return getSemanticObject().getDateProperty(intranet_fechaValidaRH);
    }

/**
* Sets the FechaValidaRH property
* @param value long with the FechaValidaRH
*/
    public void setFechaValidaRH(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaValidaRH, value);
    }

/**
* Gets the VigenciaTarjeta property
* @return java.util.Date with the VigenciaTarjeta
*/
    public java.util.Date getVigenciaTarjeta()
    {
        return getSemanticObject().getDateProperty(intranet_vigenciaTarjeta);
    }

/**
* Sets the VigenciaTarjeta property
* @param value long with the VigenciaTarjeta
*/
    public void setVigenciaTarjeta(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_vigenciaTarjeta, value);
    }
}
