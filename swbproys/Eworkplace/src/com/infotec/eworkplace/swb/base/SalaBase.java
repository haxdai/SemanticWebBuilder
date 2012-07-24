package com.infotec.eworkplace.swb.base;


public abstract class SalaBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Placeable,org.semanticwb.model.Activeable,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_tieneProyector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tieneProyector");
   /**
   * Indica si la sala está reservada
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_reservada=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#reservada");
    public static final org.semanticwb.platform.SemanticProperty intranet_capacidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#capacidad");
    public static final org.semanticwb.platform.SemanticClass intranet_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sala");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Sala");

    public static class ClassMgr
    {
       /**
       * Returns a list of Sala for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Sala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sala> listSalas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sala>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Sala for all models
       * @return Iterator of com.infotec.eworkplace.swb.Sala
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Sala> listSalas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Sala>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Sala
       * @param id Identifier for com.infotec.eworkplace.swb.Sala
       * @param model Model of the com.infotec.eworkplace.swb.Sala
       * @return A com.infotec.eworkplace.swb.Sala
       */
        public static com.infotec.eworkplace.swb.Sala getSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Sala)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Sala
       * @param id Identifier for com.infotec.eworkplace.swb.Sala
       * @param model Model of the com.infotec.eworkplace.swb.Sala
       * @return A com.infotec.eworkplace.swb.Sala
       */
        public static com.infotec.eworkplace.swb.Sala createSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Sala)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Sala
       * @param id Identifier for com.infotec.eworkplace.swb.Sala
       * @param model Model of the com.infotec.eworkplace.swb.Sala
       */
        public static void removeSala(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Sala
       * @param id Identifier for com.infotec.eworkplace.swb.Sala
       * @param model Model of the com.infotec.eworkplace.swb.Sala
       * @return true if the com.infotec.eworkplace.swb.Sala exists, false otherwise
       */

        public static boolean hasSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSala(id, model)!=null);
        }
    }

   /**
   * Constructs a SalaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Sala
   */
    public SalaBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the TieneProyector property
* @return boolean with the TieneProyector
*/
    public boolean isTieneProyector()
    {
        return getSemanticObject().getBooleanProperty(intranet_tieneProyector);
    }

/**
* Sets the TieneProyector property
* @param value long with the TieneProyector
*/
    public void setTieneProyector(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_tieneProyector, value);
    }

/**
* Gets the Active property
* @return boolean with the Active
*/
    public boolean isActive()
    {
        return getSemanticObject().getBooleanProperty(swb_active);
    }

/**
* Sets the Active property
* @param value long with the Active
*/
    public void setActive(boolean value)
    {
        getSemanticObject().setBooleanProperty(swb_active, value);
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
* Gets the Reservada property
* @return boolean with the Reservada
*/
    public boolean isReservada()
    {
        return getSemanticObject().getBooleanProperty(intranet_reservada);
    }

/**
* Sets the Reservada property
* @param value long with the Reservada
*/
    public void setReservada(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_reservada, value);
    }

/**
* Gets the Capacidad property
* @return int with the Capacidad
*/
    public int getCapacidad()
    {
        return getSemanticObject().getIntProperty(intranet_capacidad);
    }

/**
* Sets the Capacidad property
* @param value long with the Capacidad
*/
    public void setCapacidad(int value)
    {
        getSemanticObject().setIntProperty(intranet_capacidad, value);
    }

/**
* Gets the Ubicacion property
* @return String with the Ubicacion
*/
    public String getUbicacion()
    {
        return getSemanticObject().getProperty(intranet_ubicacion);
    }

/**
* Sets the Ubicacion property
* @param value long with the Ubicacion
*/
    public void setUbicacion(String value)
    {
        getSemanticObject().setProperty(intranet_ubicacion, value);
    }
}
