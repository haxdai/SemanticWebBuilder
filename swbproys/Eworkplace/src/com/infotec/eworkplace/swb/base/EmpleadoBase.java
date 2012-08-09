package com.infotec.eworkplace.swb.base;


public abstract class EmpleadoBase extends org.semanticwb.model.UserTypeDef implements com.infotec.eworkplace.swb.Extensible
{
   /**
   * Vigencia de contratación
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_vigencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_noe=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaIngreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaIngreso");
    public static final org.semanticwb.platform.SemanticProperty intranet_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#rfc");
    public static final org.semanticwb.platform.SemanticProperty intranet_nss=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nss");
    public static final org.semanticwb.platform.SemanticClass intranet_Empleado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Empleado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Empleado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Empleado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Empleado for all models
       * @return Iterator of com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Empleado
       * @param id Identifier for com.infotec.eworkplace.swb.Empleado
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       * @return A com.infotec.eworkplace.swb.Empleado
       */
        public static com.infotec.eworkplace.swb.Empleado getEmpleado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Empleado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Empleado
       * @param id Identifier for com.infotec.eworkplace.swb.Empleado
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       * @return A com.infotec.eworkplace.swb.Empleado
       */
        public static com.infotec.eworkplace.swb.Empleado createEmpleado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Empleado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Empleado
       * @param id Identifier for com.infotec.eworkplace.swb.Empleado
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       */
        public static void removeEmpleado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Empleado
       * @param id Identifier for com.infotec.eworkplace.swb.Empleado
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       * @return true if the com.infotec.eworkplace.swb.Empleado exists, false otherwise
       */

        public static boolean hasEmpleado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEmpleado(id, model)!=null);
        }
    }

   /**
   * Constructs a EmpleadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Empleado
   */
    public EmpleadoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Vigencia property
* @return java.util.Date with the Vigencia
*/
    public java.util.Date getVigencia()
    {
        return getSemanticObject().getDateProperty(intranet_vigencia);
    }

/**
* Sets the Vigencia property
* @param value long with the Vigencia
*/
    public void setVigencia(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_vigencia, value);
    }

/**
* Gets the Noe property
* @return int with the Noe
*/
    public int getNoe()
    {
        return getSemanticObject().getIntProperty(intranet_noe);
    }

/**
* Sets the Noe property
* @param value long with the Noe
*/
    public void setNoe(int value)
    {
        getSemanticObject().setIntProperty(intranet_noe, value);
    }

/**
* Gets the FechaIngreso property
* @return java.util.Date with the FechaIngreso
*/
    public java.util.Date getFechaIngreso()
    {
        return getSemanticObject().getDateProperty(intranet_fechaIngreso);
    }

/**
* Sets the FechaIngreso property
* @param value long with the FechaIngreso
*/
    public void setFechaIngreso(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechaIngreso, value);
    }

/**
* Gets the Rfc property
* @return String with the Rfc
*/
    public String getRfc()
    {
        return getSemanticObject().getProperty(intranet_rfc);
    }

/**
* Sets the Rfc property
* @param value long with the Rfc
*/
    public void setRfc(String value)
    {
        getSemanticObject().setProperty(intranet_rfc, value);
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
* Gets the Nss property
* @return int with the Nss
*/
    public int getNss()
    {
        return getSemanticObject().getIntProperty(intranet_nss);
    }

/**
* Sets the Nss property
* @param value long with the Nss
*/
    public void setNss(int value)
    {
        getSemanticObject().setIntProperty(intranet_nss, value);
    }
}
