package com.infotec.eworkplace.swb.base;


public abstract class DomicilioBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticProperty ewp_ciudad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#ciudad");
    public static final org.semanticwb.platform.SemanticProperty ewp_cp=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#cp");
    public static final org.semanticwb.platform.SemanticProperty ewp_entidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#entidad");
    public static final org.semanticwb.platform.SemanticProperty ewp_calle=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#calle");
   /**
   * Catalogo de paises
   */
    public static final org.semanticwb.platform.SemanticClass swb_Country=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#Country");
    public static final org.semanticwb.platform.SemanticProperty ewp_pais=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#pais");
    public static final org.semanticwb.platform.SemanticProperty ewp_colonia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#colonia");
    public static final org.semanticwb.platform.SemanticProperty ewp_municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#municipio");
    public static final org.semanticwb.platform.SemanticClass ewp_Domicilio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Domicilio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Domicilio");

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
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Pais
       * @param value Pais of the type org.semanticwb.model.Country
       * @param model Model of the com.infotec.eworkplace.swb.Domicilio
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByPais(org.semanticwb.model.Country value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_pais, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Domicilio with a determined Pais
       * @param value Pais of the type org.semanticwb.model.Country
       * @return Iterator with all the com.infotec.eworkplace.swb.Domicilio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Domicilio> listDomicilioByPais(org.semanticwb.model.Country value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Domicilio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_pais,value.getSemanticObject(),sclass));
            return it;
        }
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
* Gets the Ciudad property
* @return String with the Ciudad
*/
    public String getCiudad()
    {
        return getSemanticObject().getProperty(ewp_ciudad);
    }

/**
* Sets the Ciudad property
* @param value long with the Ciudad
*/
    public void setCiudad(String value)
    {
        getSemanticObject().setProperty(ewp_ciudad, value);
    }

/**
* Gets the Cp property
* @return String with the Cp
*/
    public String getCp()
    {
        return getSemanticObject().getProperty(ewp_cp);
    }

/**
* Sets the Cp property
* @param value long with the Cp
*/
    public void setCp(String value)
    {
        getSemanticObject().setProperty(ewp_cp, value);
    }

/**
* Gets the Entidad property
* @return String with the Entidad
*/
    public String getEntidad()
    {
        return getSemanticObject().getProperty(ewp_entidad);
    }

/**
* Sets the Entidad property
* @param value long with the Entidad
*/
    public void setEntidad(String value)
    {
        getSemanticObject().setProperty(ewp_entidad, value);
    }

/**
* Gets the Calle property
* @return String with the Calle
*/
    public String getCalle()
    {
        return getSemanticObject().getProperty(ewp_calle);
    }

/**
* Sets the Calle property
* @param value long with the Calle
*/
    public void setCalle(String value)
    {
        getSemanticObject().setProperty(ewp_calle, value);
    }
   /**
   * Sets the value for the property Pais
   * @param value Pais to set
   */

    public void setPais(org.semanticwb.model.Country value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_pais, value.getSemanticObject());
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
        getSemanticObject().removeProperty(ewp_pais);
    }

   /**
   * Gets the Pais
   * @return a org.semanticwb.model.Country
   */
    public org.semanticwb.model.Country getPais()
    {
         org.semanticwb.model.Country ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_pais);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.Country)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Colonia property
* @return String with the Colonia
*/
    public String getColonia()
    {
        return getSemanticObject().getProperty(ewp_colonia);
    }

/**
* Sets the Colonia property
* @param value long with the Colonia
*/
    public void setColonia(String value)
    {
        getSemanticObject().setProperty(ewp_colonia, value);
    }

/**
* Gets the Municipio property
* @return String with the Municipio
*/
    public String getMunicipio()
    {
        return getSemanticObject().getProperty(ewp_municipio);
    }

/**
* Sets the Municipio property
* @param value long with the Municipio
*/
    public void setMunicipio(String value)
    {
        getSemanticObject().setProperty(ewp_municipio, value);
    }
}
