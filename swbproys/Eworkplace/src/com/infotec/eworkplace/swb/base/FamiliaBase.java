package com.infotec.eworkplace.swb.base;


public abstract class FamiliaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty intranet_direccion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#direccion");
    public static final org.semanticwb.platform.SemanticProperty intranet_parentesco=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#parentesco");
    public static final org.semanticwb.platform.SemanticProperty intranet_nombre=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nombre");
    public static final org.semanticwb.platform.SemanticProperty intranet_telefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#telefono");
    public static final org.semanticwb.platform.SemanticClass intranet_Familia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Familia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Familia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Familia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Familia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Familia> listFamilias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Familia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Familia for all models
       * @return Iterator of com.infotec.eworkplace.swb.Familia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Familia> listFamilias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Familia>(it, true);
        }

        public static com.infotec.eworkplace.swb.Familia createFamilia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Familia.ClassMgr.createFamilia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Familia
       * @param id Identifier for com.infotec.eworkplace.swb.Familia
       * @param model Model of the com.infotec.eworkplace.swb.Familia
       * @return A com.infotec.eworkplace.swb.Familia
       */
        public static com.infotec.eworkplace.swb.Familia getFamilia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Familia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Familia
       * @param id Identifier for com.infotec.eworkplace.swb.Familia
       * @param model Model of the com.infotec.eworkplace.swb.Familia
       * @return A com.infotec.eworkplace.swb.Familia
       */
        public static com.infotec.eworkplace.swb.Familia createFamilia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Familia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Familia
       * @param id Identifier for com.infotec.eworkplace.swb.Familia
       * @param model Model of the com.infotec.eworkplace.swb.Familia
       */
        public static void removeFamilia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Familia
       * @param id Identifier for com.infotec.eworkplace.swb.Familia
       * @param model Model of the com.infotec.eworkplace.swb.Familia
       * @return true if the com.infotec.eworkplace.swb.Familia exists, false otherwise
       */

        public static boolean hasFamilia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getFamilia(id, model)!=null);
        }
    }

   /**
   * Constructs a FamiliaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Familia
   */
    public FamiliaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Direccion property
* @return String with the Direccion
*/
    public String getDireccion()
    {
        return getSemanticObject().getProperty(intranet_direccion);
    }

/**
* Sets the Direccion property
* @param value long with the Direccion
*/
    public void setDireccion(String value)
    {
        getSemanticObject().setProperty(intranet_direccion, value);
    }

/**
* Gets the Parentesco property
* @return String with the Parentesco
*/
    public String getParentesco()
    {
        return getSemanticObject().getProperty(intranet_parentesco);
    }

/**
* Sets the Parentesco property
* @param value long with the Parentesco
*/
    public void setParentesco(String value)
    {
        getSemanticObject().setProperty(intranet_parentesco, value);
    }

/**
* Gets the Nombre property
* @return String with the Nombre
*/
    public String getNombre()
    {
        return getSemanticObject().getProperty(intranet_nombre);
    }

/**
* Sets the Nombre property
* @param value long with the Nombre
*/
    public void setNombre(String value)
    {
        getSemanticObject().setProperty(intranet_nombre, value);
    }

/**
* Gets the Telefono property
* @return String with the Telefono
*/
    public String getTelefono()
    {
        return getSemanticObject().getProperty(intranet_telefono);
    }

/**
* Sets the Telefono property
* @param value long with the Telefono
*/
    public void setTelefono(String value)
    {
        getSemanticObject().setProperty(intranet_telefono, value);
    }
}
