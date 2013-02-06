package mx.gob.inmujeres.swb.base;


   /**
   * Representa una sala de juntas 
   */
public abstract class SalaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,org.semanticwb.model.Activeable
{
    public static final org.semanticwb.platform.SemanticProperty inm_tienePantalla=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#tienePantalla");
    public static final org.semanticwb.platform.SemanticProperty inm_tieneMultimedia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#tieneMultimedia");
    public static final org.semanticwb.platform.SemanticProperty inm_tieneProyector=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#tieneProyector");
    public static final org.semanticwb.platform.SemanticProperty inm_ubicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#ubicacion");
    public static final org.semanticwb.platform.SemanticProperty inm_capacidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#capacidad");
    public static final org.semanticwb.platform.SemanticProperty inm_requiereCarpa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#requiereCarpa");
    public static final org.semanticwb.platform.SemanticProperty inm_tieneWifi=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#tieneWifi");
   /**
   * Representa una sala de juntas
   */
    public static final org.semanticwb.platform.SemanticClass inm_Sala=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Sala");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Sala");

    public static class ClassMgr
    {
       /**
       * Returns a list of Sala for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Sala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Sala> listSalas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Sala>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Sala for all models
       * @return Iterator of mx.gob.inmujeres.swb.Sala
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Sala> listSalas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Sala>(it, true);
        }

        public static mx.gob.inmujeres.swb.Sala createSala(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Sala.ClassMgr.createSala(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Sala
       * @param id Identifier for mx.gob.inmujeres.swb.Sala
       * @param model Model of the mx.gob.inmujeres.swb.Sala
       * @return A mx.gob.inmujeres.swb.Sala
       */
        public static mx.gob.inmujeres.swb.Sala getSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Sala)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Sala
       * @param id Identifier for mx.gob.inmujeres.swb.Sala
       * @param model Model of the mx.gob.inmujeres.swb.Sala
       * @return A mx.gob.inmujeres.swb.Sala
       */
        public static mx.gob.inmujeres.swb.Sala createSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Sala)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Sala
       * @param id Identifier for mx.gob.inmujeres.swb.Sala
       * @param model Model of the mx.gob.inmujeres.swb.Sala
       */
        public static void removeSala(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Sala
       * @param id Identifier for mx.gob.inmujeres.swb.Sala
       * @param model Model of the mx.gob.inmujeres.swb.Sala
       * @return true if the mx.gob.inmujeres.swb.Sala exists, false otherwise
       */

        public static boolean hasSala(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSala(id, model)!=null);
        }
    }

    public static SalaBase.ClassMgr getSalaClassMgr()
    {
        return new SalaBase.ClassMgr();
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
* Gets the TienePantalla property
* @return boolean with the TienePantalla
*/
    public boolean isTienePantalla()
    {
        return getSemanticObject().getBooleanProperty(inm_tienePantalla);
    }

/**
* Sets the TienePantalla property
* @param value long with the TienePantalla
*/
    public void setTienePantalla(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_tienePantalla, value);
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
* Gets the TieneMultimedia property
* @return boolean with the TieneMultimedia
*/
    public boolean isTieneMultimedia()
    {
        return getSemanticObject().getBooleanProperty(inm_tieneMultimedia);
    }

/**
* Sets the TieneMultimedia property
* @param value long with the TieneMultimedia
*/
    public void setTieneMultimedia(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_tieneMultimedia, value);
    }

/**
* Gets the TieneProyector property
* @return boolean with the TieneProyector
*/
    public boolean isTieneProyector()
    {
        return getSemanticObject().getBooleanProperty(inm_tieneProyector);
    }

/**
* Sets the TieneProyector property
* @param value long with the TieneProyector
*/
    public void setTieneProyector(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_tieneProyector, value);
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
* Gets the Ubicacion property
* @return String with the Ubicacion
*/
    public String getUbicacion()
    {
        return getSemanticObject().getProperty(inm_ubicacion);
    }

/**
* Sets the Ubicacion property
* @param value long with the Ubicacion
*/
    public void setUbicacion(String value)
    {
        getSemanticObject().setProperty(inm_ubicacion, value);
    }

/**
* Gets the Capacidad property
* @return int with the Capacidad
*/
    public int getCapacidad()
    {
        return getSemanticObject().getIntProperty(inm_capacidad);
    }

/**
* Sets the Capacidad property
* @param value long with the Capacidad
*/
    public void setCapacidad(int value)
    {
        getSemanticObject().setIntProperty(inm_capacidad, value);
    }

/**
* Gets the RequiereCarpa property
* @return boolean with the RequiereCarpa
*/
    public boolean isRequiereCarpa()
    {
        return getSemanticObject().getBooleanProperty(inm_requiereCarpa);
    }

/**
* Sets the RequiereCarpa property
* @param value long with the RequiereCarpa
*/
    public void setRequiereCarpa(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_requiereCarpa, value);
    }

/**
* Gets the TieneWifi property
* @return boolean with the TieneWifi
*/
    public boolean isTieneWifi()
    {
        return getSemanticObject().getBooleanProperty(inm_tieneWifi);
    }

/**
* Sets the TieneWifi property
* @param value long with the TieneWifi
*/
    public void setTieneWifi(boolean value)
    {
        getSemanticObject().setBooleanProperty(inm_tieneWifi, value);
    }
}
