package com.infotec.eworkplace.swb.base;


   /**
   * Elemento que almacena la información del domicilio de la persona 
   */
public abstract class DomicilioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty intranet_numExterior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numExterior");
    public static final org.semanticwb.platform.SemanticProperty intranet_ciudad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#ciudad");
    public static final org.semanticwb.platform.SemanticProperty intranet_numInterior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#numInterior");
   /**
   * Catálogo utilizado para los Códigos Postales definidos en México
   */
    public static final org.semanticwb.platform.SemanticClass intranet_CP=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CP");
    public static final org.semanticwb.platform.SemanticProperty intranet_cp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#cp");
   /**
   * Catálogo utilizado para almacenar las Entidades Federativas utilizadas en Domicilio de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_EntidadFederativa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EntidadFederativa");
    public static final org.semanticwb.platform.SemanticProperty intranet_entidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#entidad");
    public static final org.semanticwb.platform.SemanticProperty intranet_calle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#calle");
   /**
   * Catalogo de paises
   */
    public static final org.semanticwb.platform.SemanticClass swb_Country=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Country");
    public static final org.semanticwb.platform.SemanticProperty intranet_pais=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#pais");
   /**
   * Catálogo utilizado para las colonias existentes en México
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Colonia");
    public static final org.semanticwb.platform.SemanticProperty intranet_colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#colonia");
   /**
   * Catálogo utilizado para los Municipios de las Entidades Federativas
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Municipio");
    public static final org.semanticwb.platform.SemanticProperty intranet_municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#municipio");
   /**
   * Elemento que almacena la información del domicilio de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Domicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Domicilio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Domicilio");

    public static class ClassMgr
    {
       /**
       * Returns a list of Domicilio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Domicilio for all models
       * @return Iterator of com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio>(it, true);
        }

        public static com.infotec.eworkplace.swb.Domicilio createDomicilio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Domicilio.ClassMgr.createDomicilio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Domicilio
       * @param id Identifier for com.infotec.eworkplace.swb.Domicilio
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return A com.infotec.eworkplace.swb.Domicilio
       */
        public static com.infotec.eworkplace.swb.Domicilio getDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Domicilio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Domicilio
       * @param id Identifier for com.infotec.eworkplace.swb.Domicilio
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return A com.infotec.eworkplace.swb.Domicilio
       */
        public static com.infotec.eworkplace.swb.Domicilio createDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Domicilio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Domicilio
       * @param id Identifier for com.infotec.eworkplace.swb.Domicilio
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       */
        public static void removeDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Domicilio
       * @param id Identifier for com.infotec.eworkplace.swb.Domicilio
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return true if the com.infotec.eworkplace.swb.Domicilio exists, false otherwise
       */

        public static boolean hasDomicilio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDomicilio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Cp
       * @param value Cp of the type com.infotec.cvi.swb.CP
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByCp(com.infotec.cvi.swb.CP value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_cp, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Cp
       * @param value Cp of the type com.infotec.cvi.swb.CP
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByCp(com.infotec.cvi.swb.CP value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_cp,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Entidad
       * @param value Entidad of the type com.infotec.cvi.swb.EntidadFederativa
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByEntidad(com.infotec.cvi.swb.EntidadFederativa value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_entidad, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Entidad
       * @param value Entidad of the type com.infotec.cvi.swb.EntidadFederativa
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByEntidad(com.infotec.cvi.swb.EntidadFederativa value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_entidad,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Pais
       * @param value Pais of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByPais(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_pais, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Pais
       * @param value Pais of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByPais(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_pais,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Colonia
       * @param value Colonia of the type com.infotec.cvi.swb.Colonia
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByColonia(com.infotec.cvi.swb.Colonia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_colonia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Colonia
       * @param value Colonia of the type com.infotec.cvi.swb.Colonia
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByColonia(com.infotec.cvi.swb.Colonia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_colonia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Municipio
       * @param value Municipio of the type com.infotec.cvi.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByMunicipio(com.infotec.cvi.swb.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_municipio, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Municipio
       * @param value Municipio of the type com.infotec.cvi.swb.Municipio
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByMunicipio(com.infotec.cvi.swb.Municipio value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_municipio,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DomicilioBase.ClassMgr getDomicilioClassMgr()
    {
        return new DomicilioBase.ClassMgr();
    }

   /**
   * Constructs a DomicilioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Domicilio
   */
    public DomicilioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the NumExterior property
* @return String with the NumExterior
*/
    public String getNumExterior()
    {
        return getSemanticObject().getProperty(intranet_numExterior);
    }

/**
* Sets the NumExterior property
* @param value long with the NumExterior
*/
    public void setNumExterior(String value)
    {
        getSemanticObject().setProperty(intranet_numExterior, value);
    }

/**
* Gets the Ciudad property
* @return String with the Ciudad
*/
    public String getCiudad()
    {
        return getSemanticObject().getProperty(intranet_ciudad);
    }

/**
* Sets the Ciudad property
* @param value long with the Ciudad
*/
    public void setCiudad(String value)
    {
        getSemanticObject().setProperty(intranet_ciudad, value);
    }

/**
* Gets the NumInterior property
* @return String with the NumInterior
*/
    public String getNumInterior()
    {
        return getSemanticObject().getProperty(intranet_numInterior);
    }

/**
* Sets the NumInterior property
* @param value long with the NumInterior
*/
    public void setNumInterior(String value)
    {
        getSemanticObject().setProperty(intranet_numInterior, value);
    }
   /**
   * Sets the value for the property Cp
   * @param value Cp to set
   */

    public void setCp(com.infotec.cvi.swb.CP value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_cp, value.getSemanticObject());
        }else
        {
            removeCp();
        }
    }
   /**
   * Remove the value for Cp property
   */

    public void removeCp()
    {
        getSemanticObject().removeProperty(intranet_cp);
    }

   /**
   * Gets the Cp
   * @return a com.infotec.cvi.swb.CP
   */
    public com.infotec.cvi.swb.CP getCp()
    {
         com.infotec.cvi.swb.CP ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_cp);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.CP)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Entidad
   * @param value Entidad to set
   */

    public void setEntidad(com.infotec.cvi.swb.EntidadFederativa value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_entidad, value.getSemanticObject());
        }else
        {
            removeEntidad();
        }
    }
   /**
   * Remove the value for Entidad property
   */

    public void removeEntidad()
    {
        getSemanticObject().removeProperty(intranet_entidad);
    }

   /**
   * Gets the Entidad
   * @return a com.infotec.cvi.swb.EntidadFederativa
   */
    public com.infotec.cvi.swb.EntidadFederativa getEntidad()
    {
         com.infotec.cvi.swb.EntidadFederativa ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_entidad);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.EntidadFederativa)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Calle property
* @return String with the Calle
*/
    public String getCalle()
    {
        return getSemanticObject().getProperty(intranet_calle);
    }

/**
* Sets the Calle property
* @param value long with the Calle
*/
    public void setCalle(String value)
    {
        getSemanticObject().setProperty(intranet_calle, value);
    }
   /**
   * Sets the value for the property Pais
   * @param value Pais to set
   */

    public void setPais(org.semanticwb.model.Country value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_pais, value.getSemanticObject());
        }else
        {
            removePais();
        }
    }
   /**
   * Remove the value for Pais property
   */

    public void removePais()
    {
        getSemanticObject().removeProperty(intranet_pais);
    }

   /**
   * Gets the Pais
   * @return a org.semanticwb.model.Country
   */
    public org.semanticwb.model.Country getPais()
    {
         org.semanticwb.model.Country ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_pais);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Country)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Colonia
   * @param value Colonia to set
   */

    public void setColonia(com.infotec.cvi.swb.Colonia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_colonia, value.getSemanticObject());
        }else
        {
            removeColonia();
        }
    }
   /**
   * Remove the value for Colonia property
   */

    public void removeColonia()
    {
        getSemanticObject().removeProperty(intranet_colonia);
    }

   /**
   * Gets the Colonia
   * @return a com.infotec.cvi.swb.Colonia
   */
    public com.infotec.cvi.swb.Colonia getColonia()
    {
         com.infotec.cvi.swb.Colonia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_colonia);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Colonia)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Municipio
   * @param value Municipio to set
   */

    public void setMunicipio(com.infotec.cvi.swb.Municipio value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_municipio, value.getSemanticObject());
        }else
        {
            removeMunicipio();
        }
    }
   /**
   * Remove the value for Municipio property
   */

    public void removeMunicipio()
    {
        getSemanticObject().removeProperty(intranet_municipio);
    }

   /**
   * Gets the Municipio
   * @return a com.infotec.cvi.swb.Municipio
   */
    public com.infotec.cvi.swb.Municipio getMunicipio()
    {
         com.infotec.cvi.swb.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_municipio);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Municipio)obj.createGenericInstance();
         }
         return ret;
    }
}
