package com.infotec.eworkplace.swb.base;


public abstract class SalaBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Placeable,com.infotec.eworkplace.swb.Status,org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty ewp_tieneProyector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#tieneProyector");
    public static final org.semanticwb.platform.SemanticProperty ewp_capacidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#capacidad");
    public static final org.semanticwb.platform.SemanticClass ewp_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Sala");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Sala");

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

        public static com.infotec.eworkplace.swb.Sala createSala(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Sala.ClassMgr.createSala(String.valueOf(id), model);
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
* Gets the Status property
* @return String with the Status
*/
    public String getStatus()
    {
        return getSemanticObject().getProperty(ewp_status);
    }

/**
* Sets the Status property
* @param value long with the Status
*/
    public void setStatus(String value)
    {
        getSemanticObject().setProperty(ewp_status, value);
    }

/**
* Gets the TieneProyector property
* @return boolean with the TieneProyector
*/
    public boolean isTieneProyector()
    {
        return getSemanticObject().getBooleanProperty(ewp_tieneProyector);
    }

/**
* Sets the TieneProyector property
* @param value long with the TieneProyector
*/
    public void setTieneProyector(boolean value)
    {
        getSemanticObject().setBooleanProperty(ewp_tieneProyector, value);
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
* Gets the Capacidad property
* @return int with the Capacidad
*/
    public int getCapacidad()
    {
        return getSemanticObject().getIntProperty(ewp_capacidad);
    }

/**
* Sets the Capacidad property
* @param value long with the Capacidad
*/
    public void setCapacidad(int value)
    {
        getSemanticObject().setIntProperty(ewp_capacidad, value);
    }

/**
* Gets the Ubicacion property
* @return String with the Ubicacion
*/
    public String getUbicacion()
    {
        return getSemanticObject().getProperty(ewp_ubicacion);
    }

/**
* Sets the Ubicacion property
* @param value long with the Ubicacion
*/
    public void setUbicacion(String value)
    {
        getSemanticObject().setProperty(ewp_ubicacion, value);
    }
}
