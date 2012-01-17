package com.infotec.eworkplace.swb.base;


public abstract class PersonaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Municipio");
    public static final org.semanticwb.platform.SemanticProperty intranet_lugarNacimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#lugarNacimiento");
    public static final org.semanticwb.platform.SemanticClass intranet_Familia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Familia");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasFamilia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasFamilia");
    public static final org.semanticwb.platform.SemanticProperty intranet_curp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#curp");
   /**
   * Catalogo de paises
   */
    public static final org.semanticwb.platform.SemanticClass swb_Country=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Country");
    public static final org.semanticwb.platform.SemanticProperty intranet_nacionalidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nacionalidad");
    public static final org.semanticwb.platform.SemanticClass intranet_Domicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Domicilio");
    public static final org.semanticwb.platform.SemanticProperty intranet_domicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#domicilio");
    public static final org.semanticwb.platform.SemanticProperty intranet_nacimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nacimiento");
    public static final org.semanticwb.platform.SemanticProperty intranet_pEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#pEmail");
    public static final org.semanticwb.platform.SemanticProperty intranet_telefonoFijo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#telefonoFijo");
    public static final org.semanticwb.platform.SemanticProperty intranet_genero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#genero");
    public static final org.semanticwb.platform.SemanticProperty intranet_cedula=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cedula");
    public static final org.semanticwb.platform.SemanticProperty intranet_telefonoMovil=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#telefonoMovil");
    public static final org.semanticwb.platform.SemanticClass intranet_Persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Persona");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Persona");

    public static class ClassMgr
    {
       /**
       * Returns a list of Persona for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Persona for all models
       * @return Iterator of com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona>(it, true);
        }

        public static com.infotec.eworkplace.swb.Persona createPersona(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Persona.ClassMgr.createPersona(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Persona
       * @param id Identifier for com.infotec.eworkplace.swb.Persona
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return A com.infotec.eworkplace.swb.Persona
       */
        public static com.infotec.eworkplace.swb.Persona getPersona(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Persona)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Persona
       * @param id Identifier for com.infotec.eworkplace.swb.Persona
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return A com.infotec.eworkplace.swb.Persona
       */
        public static com.infotec.eworkplace.swb.Persona createPersona(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Persona)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Persona
       * @param id Identifier for com.infotec.eworkplace.swb.Persona
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       */
        public static void removePersona(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Persona
       * @param id Identifier for com.infotec.eworkplace.swb.Persona
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return true if the com.infotec.eworkplace.swb.Persona exists, false otherwise
       */

        public static boolean hasPersona(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPersona(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined LugarNacimiento
       * @param value LugarNacimiento of the type com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByLugarNacimiento(com.infotec.eworkplace.swb.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_lugarNacimiento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined LugarNacimiento
       * @param value LugarNacimiento of the type com.infotec.eworkplace.swb.Municipio
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByLugarNacimiento(com.infotec.eworkplace.swb.Municipio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_lugarNacimiento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Familia
       * @param value Familia of the type com.infotec.eworkplace.swb.Familia
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByFamilia(com.infotec.eworkplace.swb.Familia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasFamilia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Familia
       * @param value Familia of the type com.infotec.eworkplace.swb.Familia
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByFamilia(com.infotec.eworkplace.swb.Familia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasFamilia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Nacionalidad
       * @param value Nacionalidad of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByNacionalidad(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nacionalidad, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Nacionalidad
       * @param value Nacionalidad of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByNacionalidad(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nacionalidad,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Domicilio
       * @param value Domicilio of the type com.infotec.eworkplace.swb.Domicilio
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByDomicilio(com.infotec.eworkplace.swb.Domicilio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_domicilio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Domicilio
       * @param value Domicilio of the type com.infotec.eworkplace.swb.Domicilio
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByDomicilio(com.infotec.eworkplace.swb.Domicilio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_domicilio,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a PersonaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Persona
   */
    public PersonaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property LugarNacimiento
   * @param value LugarNacimiento to set
   */

    public void setLugarNacimiento(com.infotec.eworkplace.swb.Municipio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_lugarNacimiento, value.getSemanticObject());
        }else
        {
            removeLugarNacimiento();
        }
    }
   /**
   * Remove the value for LugarNacimiento property
   */

    public void removeLugarNacimiento()
    {
        getSemanticObject().removeProperty(intranet_lugarNacimiento);
    }

   /**
   * Gets the LugarNacimiento
   * @return a com.infotec.eworkplace.swb.Municipio
   */
    public com.infotec.eworkplace.swb.Municipio getLugarNacimiento()
    {
         com.infotec.eworkplace.swb.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_lugarNacimiento);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Municipio)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Familia
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Familia
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Familia> listFamilias()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Familia>(getSemanticObject().listObjectProperties(intranet_hasFamilia));
    }

   /**
   * Gets true if has a Familia
   * @param value com.infotec.eworkplace.swb.Familia to verify
   * @return true if the com.infotec.eworkplace.swb.Familia exists, false otherwise
   */
    public boolean hasFamilia(com.infotec.eworkplace.swb.Familia value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasFamilia,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Familia
   * @param value com.infotec.eworkplace.swb.Familia to add
   */

    public void addFamilia(com.infotec.eworkplace.swb.Familia value)
    {
        getSemanticObject().addObjectProperty(intranet_hasFamilia, value.getSemanticObject());
    }
   /**
   * Removes all the Familia
   */

    public void removeAllFamilia()
    {
        getSemanticObject().removeProperty(intranet_hasFamilia);
    }
   /**
   * Removes a Familia
   * @param value com.infotec.eworkplace.swb.Familia to remove
   */

    public void removeFamilia(com.infotec.eworkplace.swb.Familia value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasFamilia,value.getSemanticObject());
    }

   /**
   * Gets the Familia
   * @return a com.infotec.eworkplace.swb.Familia
   */
    public com.infotec.eworkplace.swb.Familia getFamilia()
    {
         com.infotec.eworkplace.swb.Familia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasFamilia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Familia)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Curp property
* @return String with the Curp
*/
    public String getCurp()
    {
        return getSemanticObject().getProperty(intranet_curp);
    }

/**
* Sets the Curp property
* @param value long with the Curp
*/
    public void setCurp(String value)
    {
        getSemanticObject().setProperty(intranet_curp, value);
    }
   /**
   * Sets the value for the property Nacionalidad
   * @param value Nacionalidad to set
   */

    public void setNacionalidad(org.semanticwb.model.Country value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nacionalidad, value.getSemanticObject());
        }else
        {
            removeNacionalidad();
        }
    }
   /**
   * Remove the value for Nacionalidad property
   */

    public void removeNacionalidad()
    {
        getSemanticObject().removeProperty(intranet_nacionalidad);
    }

   /**
   * Gets the Nacionalidad
   * @return a org.semanticwb.model.Country
   */
    public org.semanticwb.model.Country getNacionalidad()
    {
         org.semanticwb.model.Country ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nacionalidad);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Country)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Domicilio
   * @param value Domicilio to set
   */

    public void setDomicilio(com.infotec.eworkplace.swb.Domicilio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_domicilio, value.getSemanticObject());
        }else
        {
            removeDomicilio();
        }
    }
   /**
   * Remove the value for Domicilio property
   */

    public void removeDomicilio()
    {
        getSemanticObject().removeProperty(intranet_domicilio);
    }

   /**
   * Gets the Domicilio
   * @return a com.infotec.eworkplace.swb.Domicilio
   */
    public com.infotec.eworkplace.swb.Domicilio getDomicilio()
    {
         com.infotec.eworkplace.swb.Domicilio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_domicilio);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Domicilio)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Nacimiento property
* @return java.util.Date with the Nacimiento
*/
    public java.util.Date getNacimiento()
    {
        return getSemanticObject().getDateProperty(intranet_nacimiento);
    }

/**
* Sets the Nacimiento property
* @param value long with the Nacimiento
*/
    public void setNacimiento(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_nacimiento, value);
    }

/**
* Gets the PEmail property
* @return String with the PEmail
*/
    public String getPEmail()
    {
        return getSemanticObject().getProperty(intranet_pEmail);
    }

/**
* Sets the PEmail property
* @param value long with the PEmail
*/
    public void setPEmail(String value)
    {
        getSemanticObject().setProperty(intranet_pEmail, value);
    }

/**
* Gets the TelefonoFijo property
* @return String with the TelefonoFijo
*/
    public String getTelefonoFijo()
    {
        return getSemanticObject().getProperty(intranet_telefonoFijo);
    }

/**
* Sets the TelefonoFijo property
* @param value long with the TelefonoFijo
*/
    public void setTelefonoFijo(String value)
    {
        getSemanticObject().setProperty(intranet_telefonoFijo, value);
    }

/**
* Gets the Genero property
* @return boolean with the Genero
*/
    public boolean isGenero()
    {
        return getSemanticObject().getBooleanProperty(intranet_genero);
    }

/**
* Sets the Genero property
* @param value long with the Genero
*/
    public void setGenero(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_genero, value);
    }

/**
* Gets the Cedula property
* @return String with the Cedula
*/
    public String getCedula()
    {
        return getSemanticObject().getProperty(intranet_cedula);
    }

/**
* Sets the Cedula property
* @param value long with the Cedula
*/
    public void setCedula(String value)
    {
        getSemanticObject().setProperty(intranet_cedula, value);
    }

/**
* Gets the TelefonoMovil property
* @return String with the TelefonoMovil
*/
    public String getTelefonoMovil()
    {
        return getSemanticObject().getProperty(intranet_telefonoMovil);
    }

/**
* Sets the TelefonoMovil property
* @param value long with the TelefonoMovil
*/
    public void setTelefonoMovil(String value)
    {
        getSemanticObject().setProperty(intranet_telefonoMovil, value);
    }
}
