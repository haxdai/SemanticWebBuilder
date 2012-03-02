package com.infotec.eworkplace.swb.base;


public abstract class SolicitudMantenimientoBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty intranet_terceros=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#terceros");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaSolicita=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaSolicita");
    public static final org.semanticwb.platform.SemanticProperty intranet_cargoSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cargoSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_adscripcionSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#adscripcionSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_extensionSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#extensionSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombreSolicitante=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombreSolicitante");
    public static final org.semanticwb.platform.SemanticProperty intranet_descripcionServicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#descripcionServicio");
    public static final org.semanticwb.platform.SemanticProperty intranet_autoriza=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#autoriza");
    public static final org.semanticwb.platform.SemanticClass intranet_SolicitudMantenimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudMantenimiento");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SolicitudMantenimiento");

    public static class ClassMgr
    {
       /**
       * Returns a list of SolicitudMantenimiento for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.SolicitudMantenimiento for all models
       * @return Iterator of com.infotec.eworkplace.swb.SolicitudMantenimiento
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.SolicitudMantenimiento> listSolicitudMantenimientos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.SolicitudMantenimiento>(it, true);
        }

        public static com.infotec.eworkplace.swb.SolicitudMantenimiento createSolicitudMantenimiento(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.SolicitudMantenimiento.ClassMgr.createSolicitudMantenimiento(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return A com.infotec.eworkplace.swb.SolicitudMantenimiento
       */
        public static com.infotec.eworkplace.swb.SolicitudMantenimiento getSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SolicitudMantenimiento)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return A com.infotec.eworkplace.swb.SolicitudMantenimiento
       */
        public static com.infotec.eworkplace.swb.SolicitudMantenimiento createSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.SolicitudMantenimiento)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       */
        public static void removeSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param id Identifier for com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @param model Model of the com.infotec.eworkplace.swb.SolicitudMantenimiento
       * @return true if the com.infotec.eworkplace.swb.SolicitudMantenimiento exists, false otherwise
       */

        public static boolean hasSolicitudMantenimiento(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSolicitudMantenimiento(id, model)!=null);
        }
    }

   /**
   * Constructs a SolicitudMantenimientoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SolicitudMantenimiento
   */
    public SolicitudMantenimientoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Terceros property
* @return boolean with the Terceros
*/
    public boolean isTerceros()
    {
        return getSemanticObject().getBooleanProperty(intranet_terceros);
    }

/**
* Sets the Terceros property
* @param value long with the Terceros
*/
    public void setTerceros(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_terceros, value);
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
* Gets the DescripcionServicio property
* @return String with the DescripcionServicio
*/
    public String getDescripcionServicio()
    {
        return getSemanticObject().getProperty(intranet_descripcionServicio);
    }

/**
* Sets the DescripcionServicio property
* @param value long with the DescripcionServicio
*/
    public void setDescripcionServicio(String value)
    {
        getSemanticObject().setProperty(intranet_descripcionServicio, value);
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
}
