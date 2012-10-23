package com.infotec.eworkplace.swb.base;


   /**
   * Elemento utilizado para almacenar toda la información del usuario 
   */
public abstract class PersonaBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Catálogo utilizado para los Municipios de las Entidades Federativas
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Municipio");
   /**
   * Elemento utilizado para almacenar el Municipio en el cual nació la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_lugarNacimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#lugarNacimiento");
   /**
   * Elemento utilizado para almacenar el Id de Twitter de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_twitter=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#twitter");
   /**
   * Alamcena el nombre de usuario de facebook de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_facebook=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#facebook");
   /**
   * Almacena el CURP de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_curp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#curp");
   /**
   * Elemento utilizado para almacenr la lista de correo electrónicos personales del usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasPEmail=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasPEmail");
   /**
   * Catalogo de paises
   */
    public static final org.semanticwb.platform.SemanticClass swb_Country=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Country");
   /**
   * Elemento utilizado para almacenar el país de nacimiento de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_nacionalidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nacionalidad");
   /**
   * Elemento utilizado para almacenar el Id de MSN de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_msn=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#msn");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
   /**
   * Elemento utilizado para relacionar Persona con User
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_owner=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#owner");
   /**
   * Almacena la cédula de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_cedula=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cedula");
   /**
   * Catálogo utilizado para almacenar las Entidades Federativas utilizadas en Domicilio de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_EntidadFederativa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EntidadFederativa");
   /**
   * Entidad Federativa en donde nació el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_estadoNacimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#estadoNacimiento");
    public static final org.semanticwb.platform.SemanticClass intranet_Telefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Telefono");
   /**
   * Elemento utilizado para almacenar lista de Telefono relaciondos a la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasTelefono=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasTelefono");
   /**
   * Almacena la aceptación de términos de uso del CVI por la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_aceptacionTerminos=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#aceptacionTerminos");
    public static final org.semanticwb.platform.SemanticClass intranet_Familia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Familia");
   /**
   * Elemento utilizado para almacenar la lista de tipo Familia del usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasFamilia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasFamilia");
   /**
   * Elemento que almacena la información del domicilio de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Domicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Domicilio");
   /**
   * Relaciona el domicilio definido por el usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_domicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#domicilio");
   /**
   * Almacena la fecha de nacimiento de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_nacimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nacimiento");
   /**
   * Elemento utilizado para almacenar el nombre de usuario de LinkedIn de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_linkedin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#linkedin");
   /**
   * Elemento utilizado para almacenar el género del usuario
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_genero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#genero");
   /**
   * Indica si la persona tiene FM2 vigente, si es el caso
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_FM2=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#FM2");
   /**
   * Elemento utilizado para almacenar el Id de usuario de Skype de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_skype=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#skype");
   /**
   * Elemento utilizado para almacenar toda la información del usuario
   */
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
       * @param value LugarNacimiento of the type com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByLugarNacimiento(com.infotec.cvi.swb.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_lugarNacimiento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined LugarNacimiento
       * @param value LugarNacimiento of the type com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByLugarNacimiento(com.infotec.cvi.swb.Municipio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_lugarNacimiento,value.getSemanticObject(),sclass));
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
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Owner
       * @param value Owner of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByOwner(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_owner, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Owner
       * @param value Owner of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByOwner(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_owner,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined EstadoNacimiento
       * @param value EstadoNacimiento of the type com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByEstadoNacimiento(com.infotec.cvi.swb.EntidadFederativa value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_estadoNacimiento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined EstadoNacimiento
       * @param value EstadoNacimiento of the type com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByEstadoNacimiento(com.infotec.cvi.swb.EntidadFederativa value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_estadoNacimiento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Telefono
       * @param value Telefono of the type com.infotec.eworkplace.swb.Telefono
       * @param model Model of the com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByTelefono(com.infotec.eworkplace.swb.Telefono value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasTelefono, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Persona with a determined Telefono
       * @param value Telefono of the type com.infotec.eworkplace.swb.Telefono
       * @return Iterator with all the com.infotec.eworkplace.swb.Persona
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Persona> listPersonaByTelefono(com.infotec.eworkplace.swb.Telefono value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Persona> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasTelefono,value.getSemanticObject(),sclass));
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

    public static PersonaBase.ClassMgr getPersonaClassMgr()
    {
        return new PersonaBase.ClassMgr();
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

    public void setLugarNacimiento(com.infotec.cvi.swb.Municipio value)
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
   * @return a com.infotec.cvi.swb.Municipio
   */
    public com.infotec.cvi.swb.Municipio getLugarNacimiento()
    {
         com.infotec.cvi.swb.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_lugarNacimiento);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Municipio)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Twitter property
* @return String with the Twitter
*/
    public String getTwitter()
    {
        return getSemanticObject().getProperty(intranet_twitter);
    }

/**
* Sets the Twitter property
* @param value long with the Twitter
*/
    public void setTwitter(String value)
    {
        getSemanticObject().setProperty(intranet_twitter, value);
    }

/**
* Gets the Facebook property
* @return String with the Facebook
*/
    public String getFacebook()
    {
        return getSemanticObject().getProperty(intranet_facebook);
    }

/**
* Sets the Facebook property
* @param value long with the Facebook
*/
    public void setFacebook(String value)
    {
        getSemanticObject().setProperty(intranet_facebook, value);
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

    public java.util.Iterator<String> listPEmails()
    {
        java.util.ArrayList<String> values=new java.util.ArrayList<String>();
        java.util.Iterator<org.semanticwb.platform.SemanticLiteral> it=getSemanticObject().listLiteralProperties(intranet_hasPEmail);
        while(it.hasNext())
        {
                org.semanticwb.platform.SemanticLiteral literal=it.next();
                values.add(literal.getString());
        }
        return values.iterator();
    }

    public void addPEmail(String value)
    {
        getSemanticObject().addLiteralProperty(intranet_hasPEmail, new org.semanticwb.platform.SemanticLiteral(value));
    }

    public void removeAllPEmail()
    {
        getSemanticObject().removeProperty(intranet_hasPEmail);
    }

    public void removePEmail(String value)
    {
        getSemanticObject().removeLiteralProperty(intranet_hasPEmail,new org.semanticwb.platform.SemanticLiteral(value));
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
* Gets the Msn property
* @return String with the Msn
*/
    public String getMsn()
    {
        return getSemanticObject().getProperty(intranet_msn);
    }

/**
* Sets the Msn property
* @param value long with the Msn
*/
    public void setMsn(String value)
    {
        getSemanticObject().setProperty(intranet_msn, value);
    }
   /**
   * Sets the value for the property Owner
   * @param value Owner to set
   */

    public void setOwner(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_owner, value.getSemanticObject());
        }else
        {
            removeOwner();
        }
    }
   /**
   * Remove the value for Owner property
   */

    public void removeOwner()
    {
        getSemanticObject().removeProperty(intranet_owner);
    }

   /**
   * Gets the Owner
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getOwner()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_owner);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
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
   * Sets the value for the property EstadoNacimiento
   * @param value EstadoNacimiento to set
   */

    public void setEstadoNacimiento(com.infotec.cvi.swb.EntidadFederativa value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_estadoNacimiento, value.getSemanticObject());
        }else
        {
            removeEstadoNacimiento();
        }
    }
   /**
   * Remove the value for EstadoNacimiento property
   */

    public void removeEstadoNacimiento()
    {
        getSemanticObject().removeProperty(intranet_estadoNacimiento);
    }

   /**
   * Gets the EstadoNacimiento
   * @return a com.infotec.cvi.swb.EntidadFederativa
   */
    public com.infotec.cvi.swb.EntidadFederativa getEstadoNacimiento()
    {
         com.infotec.cvi.swb.EntidadFederativa ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_estadoNacimiento);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.EntidadFederativa)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Telefono
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Telefono
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Telefono> listTelefonos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Telefono>(getSemanticObject().listObjectProperties(intranet_hasTelefono));
    }

   /**
   * Gets true if has a Telefono
   * @param value com.infotec.eworkplace.swb.Telefono to verify
   * @return true if the com.infotec.eworkplace.swb.Telefono exists, false otherwise
   */
    public boolean hasTelefono(com.infotec.eworkplace.swb.Telefono value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasTelefono,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Telefono
   * @param value com.infotec.eworkplace.swb.Telefono to add
   */

    public void addTelefono(com.infotec.eworkplace.swb.Telefono value)
    {
        getSemanticObject().addObjectProperty(intranet_hasTelefono, value.getSemanticObject());
    }
   /**
   * Removes all the Telefono
   */

    public void removeAllTelefono()
    {
        getSemanticObject().removeProperty(intranet_hasTelefono);
    }
   /**
   * Removes a Telefono
   * @param value com.infotec.eworkplace.swb.Telefono to remove
   */

    public void removeTelefono(com.infotec.eworkplace.swb.Telefono value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasTelefono,value.getSemanticObject());
    }

   /**
   * Gets the Telefono
   * @return a com.infotec.eworkplace.swb.Telefono
   */
    public com.infotec.eworkplace.swb.Telefono getTelefono()
    {
         com.infotec.eworkplace.swb.Telefono ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasTelefono);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Telefono)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the AceptacionTerminos property
* @return String with the AceptacionTerminos
*/
    public String getAceptacionTerminos()
    {
        return getSemanticObject().getProperty(intranet_aceptacionTerminos);
    }

/**
* Sets the AceptacionTerminos property
* @param value long with the AceptacionTerminos
*/
    public void setAceptacionTerminos(String value)
    {
        getSemanticObject().setProperty(intranet_aceptacionTerminos, value);
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
* Gets the Linkedin property
* @return String with the Linkedin
*/
    public String getLinkedin()
    {
        return getSemanticObject().getProperty(intranet_linkedin);
    }

/**
* Sets the Linkedin property
* @param value long with the Linkedin
*/
    public void setLinkedin(String value)
    {
        getSemanticObject().setProperty(intranet_linkedin, value);
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
* Gets the FM2 property
* @return boolean with the FM2
*/
    public boolean isFM2()
    {
        return getSemanticObject().getBooleanProperty(intranet_FM2);
    }

/**
* Sets the FM2 property
* @param value long with the FM2
*/
    public void setFM2(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_FM2, value);
    }

/**
* Gets the Skype property
* @return String with the Skype
*/
    public String getSkype()
    {
        return getSemanticObject().getProperty(intranet_skype);
    }

/**
* Sets the Skype property
* @param value long with the Skype
*/
    public void setSkype(String value)
    {
        getSemanticObject().setProperty(intranet_skype, value);
    }
}
