package com.infotec.eworkplace.swb.base;


public abstract class TelefonoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Extensible
{
    public static final org.semanticwb.platform.SemanticProperty intranet_numero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numero");
    public static final org.semanticwb.platform.SemanticProperty intranet_lada=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#lada");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipo");
    public static final org.semanticwb.platform.SemanticClass intranet_Telefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Telefono");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Telefono");

    public static class ClassMgr
    {
       /**
       * Returns a list of Telefono for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Telefono
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Telefono> listTelefonos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Telefono>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Telefono for all models
       * @return Iterator of com.infotec.eworkplace.swb.Telefono
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Telefono> listTelefonos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Telefono>(it, true);
        }

        public static com.infotec.eworkplace.swb.Telefono createTelefono(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Telefono.ClassMgr.createTelefono(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Telefono
       * @param id Identifier for com.infotec.eworkplace.swb.Telefono
       * @param model Model of the com.infotec.eworkplace.swb.Telefono
       * @return A com.infotec.eworkplace.swb.Telefono
       */
        public static com.infotec.eworkplace.swb.Telefono getTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Telefono)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Telefono
       * @param id Identifier for com.infotec.eworkplace.swb.Telefono
       * @param model Model of the com.infotec.eworkplace.swb.Telefono
       * @return A com.infotec.eworkplace.swb.Telefono
       */
        public static com.infotec.eworkplace.swb.Telefono createTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Telefono)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Telefono
       * @param id Identifier for com.infotec.eworkplace.swb.Telefono
       * @param model Model of the com.infotec.eworkplace.swb.Telefono
       */
        public static void removeTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Telefono
       * @param id Identifier for com.infotec.eworkplace.swb.Telefono
       * @param model Model of the com.infotec.eworkplace.swb.Telefono
       * @return true if the com.infotec.eworkplace.swb.Telefono exists, false otherwise
       */

        public static boolean hasTelefono(String id, org.semanticwb.model.SWBModel model)
        {
            return (getTelefono(id, model)!=null);
        }
    }

   /**
   * Constructs a TelefonoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Telefono
   */
    public TelefonoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Numero property
* @return int with the Numero
*/
    public int getNumero()
    {
        return getSemanticObject().getIntProperty(intranet_numero);
    }

/**
* Sets the Numero property
* @param value long with the Numero
*/
    public void setNumero(int value)
    {
        getSemanticObject().setIntProperty(intranet_numero, value);
    }

/**
* Gets the Extension property
* @return int with the Extension
*/
    public int getExtension()
    {
        return getSemanticObject().getIntProperty(intranet_extension);
    }

/**
* Sets the Extension property
* @param value long with the Extension
*/
    public void setExtension(int value)
    {
        getSemanticObject().setIntProperty(intranet_extension, value);
    }

/**
* Gets the Lada property
* @return int with the Lada
*/
    public int getLada()
    {
        return getSemanticObject().getIntProperty(intranet_lada);
    }

/**
* Sets the Lada property
* @param value long with the Lada
*/
    public void setLada(int value)
    {
        getSemanticObject().setIntProperty(intranet_lada, value);
    }

/**
* Gets the Tipo property
* @return String with the Tipo
*/
    public String getTipo()
    {
        return getSemanticObject().getProperty(intranet_tipo);
    }

/**
* Sets the Tipo property
* @param value long with the Tipo
*/
    public void setTipo(String value)
    {
        getSemanticObject().setProperty(intranet_tipo, value);
    }
}
