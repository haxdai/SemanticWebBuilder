package com.infotec.eworkplace.swb.base;


public abstract class EmpleadoBase extends org.semanticwb.model.UserTypeDef implements com.infotec.eworkplace.swb.Extensible
{
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_manager=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#manager");
   /**
   * Vigencia de contratación
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_vigencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#vigencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_noe=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaIngreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaIngreso");
   /**
   * Catálogo utilizado para indicar el Tipo de contratación
   */
    public static final org.semanticwb.platform.SemanticClass intranet_TipoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#TipoContratacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_tipoContratacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#tipoContratacion");
    public static final org.semanticwb.platform.SemanticProperty intranet_nss=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nss");
    public static final org.semanticwb.platform.SemanticProperty intranet_sede=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#sede");
    public static final org.semanticwb.platform.SemanticProperty intranet_rfc=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#rfc");
    public static final org.semanticwb.platform.SemanticProperty intranet_numEspecialidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numEspecialidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_numProyecto=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numProyecto");
    public static final org.semanticwb.platform.SemanticProperty intranet_noArea=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noArea");
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
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined Manager
       * @param value Manager of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByManager(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_manager, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined Manager
       * @param value Manager of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByManager(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_manager,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined TipoContratacion
       * @param value TipoContratacion of the type com.infotec.cvi.swb.TipoContratacion
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByTipoContratacion(com.infotec.cvi.swb.TipoContratacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoContratacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined TipoContratacion
       * @param value TipoContratacion of the type com.infotec.cvi.swb.TipoContratacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByTipoContratacion(com.infotec.cvi.swb.TipoContratacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_tipoContratacion,value.getSemanticObject(),sclass));
            return it;
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
   * Sets the value for the property Manager
   * @param value Manager to set
   */

    public void setManager(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_manager, value.getSemanticObject());
        }else
        {
            removeManager();
        }
    }
   /**
   * Remove the value for Manager property
   */

    public void removeManager()
    {
        getSemanticObject().removeProperty(intranet_manager);
    }

   /**
   * Gets the Manager
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getManager()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_manager);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
   * Sets the value for the property TipoContratacion
   * @param value TipoContratacion to set
   */

    public void setTipoContratacion(com.infotec.cvi.swb.TipoContratacion value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_tipoContratacion, value.getSemanticObject());
        }else
        {
            removeTipoContratacion();
        }
    }
   /**
   * Remove the value for TipoContratacion property
   */

    public void removeTipoContratacion()
    {
        getSemanticObject().removeProperty(intranet_tipoContratacion);
    }

   /**
   * Gets the TipoContratacion
   * @return a com.infotec.cvi.swb.TipoContratacion
   */
    public com.infotec.cvi.swb.TipoContratacion getTipoContratacion()
    {
         com.infotec.cvi.swb.TipoContratacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_tipoContratacion);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.TipoContratacion)obj.createGenericInstance();
         }
         return ret;
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

/**
* Gets the Sede property
* @return String with the Sede
*/
    public String getSede()
    {
        return getSemanticObject().getProperty(intranet_sede);
    }

/**
* Sets the Sede property
* @param value long with the Sede
*/
    public void setSede(String value)
    {
        getSemanticObject().setProperty(intranet_sede, value);
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
* Gets the NumEspecialidad property
* @return String with the NumEspecialidad
*/
    public String getNumEspecialidad()
    {
        return getSemanticObject().getProperty(intranet_numEspecialidad);
    }

/**
* Sets the NumEspecialidad property
* @param value long with the NumEspecialidad
*/
    public void setNumEspecialidad(String value)
    {
        getSemanticObject().setProperty(intranet_numEspecialidad, value);
    }

/**
* Gets the NumProyecto property
* @return String with the NumProyecto
*/
    public String getNumProyecto()
    {
        return getSemanticObject().getProperty(intranet_numProyecto);
    }

/**
* Sets the NumProyecto property
* @param value long with the NumProyecto
*/
    public void setNumProyecto(String value)
    {
        getSemanticObject().setProperty(intranet_numProyecto, value);
    }

/**
* Gets the NoArea property
* @return String with the NoArea
*/
    public String getNoArea()
    {
        return getSemanticObject().getProperty(intranet_noArea);
    }

/**
* Sets the NoArea property
* @param value long with the NoArea
*/
    public void setNoArea(String value)
    {
        getSemanticObject().setProperty(intranet_noArea, value);
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
}
