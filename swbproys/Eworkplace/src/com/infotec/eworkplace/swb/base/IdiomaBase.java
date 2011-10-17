package com.infotec.eworkplace.swb.base;


public abstract class IdiomaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty ewp_lectura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#lectura");
    public static final org.semanticwb.platform.SemanticProperty ewp_conversacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#conversacion");
    public static final org.semanticwb.platform.SemanticProperty ewp_tecnico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#tecnico");
    public static final org.semanticwb.platform.SemanticProperty ewp_nombre=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#nombre");
    public static final org.semanticwb.platform.SemanticProperty ewp_escritura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#escritura");
    public static final org.semanticwb.platform.SemanticClass ewp_Idioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Idioma");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Idioma");

    public static class ClassMgr
    {
       /**
       * Returns a list of Idioma for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Idioma for all models
       * @return Iterator of com.infotec.eworkplace.swb.Idioma
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Idioma> listIdiomas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(it, true);
        }

        public static com.infotec.eworkplace.swb.Idioma createIdioma(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Idioma.ClassMgr.createIdioma(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return A com.infotec.eworkplace.swb.Idioma
       */
        public static com.infotec.eworkplace.swb.Idioma getIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Idioma)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return A com.infotec.eworkplace.swb.Idioma
       */
        public static com.infotec.eworkplace.swb.Idioma createIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Idioma)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       */
        public static void removeIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Idioma
       * @param id Identifier for com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Idioma
       * @return true if the com.infotec.eworkplace.swb.Idioma exists, false otherwise
       */

        public static boolean hasIdioma(String id, org.semanticwb.model.SWBModel model)
        {
            return (getIdioma(id, model)!=null);
        }
    }

   /**
   * Constructs a IdiomaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Idioma
   */
    public IdiomaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Lectura property
* @return int with the Lectura
*/
    public int getLectura()
    {
        return getSemanticObject().getIntProperty(ewp_lectura);
    }

/**
* Sets the Lectura property
* @param value long with the Lectura
*/
    public void setLectura(int value)
    {
        getSemanticObject().setIntProperty(ewp_lectura, value);
    }

/**
* Gets the Conversacion property
* @return int with the Conversacion
*/
    public int getConversacion()
    {
        return getSemanticObject().getIntProperty(ewp_conversacion);
    }

/**
* Sets the Conversacion property
* @param value long with the Conversacion
*/
    public void setConversacion(int value)
    {
        getSemanticObject().setIntProperty(ewp_conversacion, value);
    }

/**
* Gets the Tecnico property
* @return boolean with the Tecnico
*/
    public boolean isTecnico()
    {
        return getSemanticObject().getBooleanProperty(ewp_tecnico);
    }

/**
* Sets the Tecnico property
* @param value long with the Tecnico
*/
    public void setTecnico(boolean value)
    {
        getSemanticObject().setBooleanProperty(ewp_tecnico, value);
    }

/**
* Gets the Nombre property
* @return String with the Nombre
*/
    public String getNombre()
    {
        return getSemanticObject().getProperty(ewp_nombre);
    }

/**
* Sets the Nombre property
* @param value long with the Nombre
*/
    public void setNombre(String value)
    {
        getSemanticObject().setProperty(ewp_nombre, value);
    }

/**
* Gets the Escritura property
* @return int with the Escritura
*/
    public int getEscritura()
    {
        return getSemanticObject().getIntProperty(ewp_escritura);
    }

/**
* Sets the Escritura property
* @param value long with the Escritura
*/
    public void setEscritura(int value)
    {
        getSemanticObject().setIntProperty(ewp_escritura, value);
    }
}
