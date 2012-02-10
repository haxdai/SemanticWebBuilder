package com.infotec.eworkplace.swb.base;


public abstract class EmpleadoBase extends org.semanticwb.model.UserTypeDef implements com.infotec.eworkplace.swb.Extensible
{
    public static final org.semanticwb.platform.SemanticClass intranet_Organo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Organo");
    public static final org.semanticwb.platform.SemanticProperty intranet_adscripcion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#adscripcion");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_jefeInmediato=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#jefeInmediato");
    public static final org.semanticwb.platform.SemanticProperty intranet_noe=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noe");
    public static final org.semanticwb.platform.SemanticProperty intranet_fechaIngreso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechaIngreso");
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
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined Adscripcion
       * @param value Adscripcion of the type com.infotec.eworkplace.swb.Organo
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByAdscripcion(com.infotec.eworkplace.swb.Organo value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_adscripcion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined Adscripcion
       * @param value Adscripcion of the type com.infotec.eworkplace.swb.Organo
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByAdscripcion(com.infotec.eworkplace.swb.Organo value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_adscripcion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined JefeInmediato
       * @param value JefeInmediato of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Empleado
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByJefeInmediato(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_jefeInmediato, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Empleado with a determined JefeInmediato
       * @param value JefeInmediato of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Empleado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Empleado> listEmpleadoByJefeInmediato(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Empleado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_jefeInmediato,value.getSemanticObject(),sclass));
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
   * Sets the value for the property Adscripcion
   * @param value Adscripcion to set
   */

    public void setAdscripcion(com.infotec.eworkplace.swb.Organo value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_adscripcion, value.getSemanticObject());
        }else
        {
            removeAdscripcion();
        }
    }
   /**
   * Remove the value for Adscripcion property
   */

    public void removeAdscripcion()
    {
        getSemanticObject().removeProperty(intranet_adscripcion);
    }

   /**
   * Gets the Adscripcion
   * @return a com.infotec.eworkplace.swb.Organo
   */
    public com.infotec.eworkplace.swb.Organo getAdscripcion()
    {
         com.infotec.eworkplace.swb.Organo ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_adscripcion);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Organo)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property JefeInmediato
   * @param value JefeInmediato to set
   */

    public void setJefeInmediato(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_jefeInmediato, value.getSemanticObject());
        }else
        {
            removeJefeInmediato();
        }
    }
   /**
   * Remove the value for JefeInmediato property
   */

    public void removeJefeInmediato()
    {
        getSemanticObject().removeProperty(intranet_jefeInmediato);
    }

   /**
   * Gets the JefeInmediato
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getJefeInmediato()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_jefeInmediato);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
