package com.infotec.eworkplace.swb.base;


public abstract class MunicipioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Entidad federativa
   */
    public static final org.semanticwb.platform.SemanticClass ewp_Estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Estado");
    public static final org.semanticwb.platform.SemanticProperty ewp_estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#estado");
    public static final org.semanticwb.platform.SemanticClass ewp_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Municipio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Municipio");

    public static class ClassMgr
    {
       /**
       * Returns a list of Municipio for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Municipio> listMunicipios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Municipio>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Municipio for all models
       * @return Iterator of com.infotec.eworkplace.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Municipio> listMunicipios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Municipio>(it, true);
        }

        public static com.infotec.eworkplace.swb.Municipio createMunicipio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Municipio.ClassMgr.createMunicipio(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       * @return A com.infotec.eworkplace.swb.Municipio
       */
        public static com.infotec.eworkplace.swb.Municipio getMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Municipio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       * @return A com.infotec.eworkplace.swb.Municipio
       */
        public static com.infotec.eworkplace.swb.Municipio createMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Municipio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       */
        public static void removeMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Municipio
       * @param id Identifier for com.infotec.eworkplace.swb.Municipio
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       * @return true if the com.infotec.eworkplace.swb.Municipio exists, false otherwise
       */

        public static boolean hasMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMunicipio(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Municipio with a determined Estado
       * @param value Estado of the type com.infotec.eworkplace.swb.Estado
       * @param model Model of the com.infotec.eworkplace.swb.Municipio
       * @return Iterator with all the com.infotec.eworkplace.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Municipio> listMunicipioByEstado(com.infotec.eworkplace.swb.Estado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Municipio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_estado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Municipio with a determined Estado
       * @param value Estado of the type com.infotec.eworkplace.swb.Estado
       * @return Iterator with all the com.infotec.eworkplace.swb.Municipio
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Municipio> listMunicipioByEstado(com.infotec.eworkplace.swb.Estado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Municipio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_estado,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a MunicipioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Municipio
   */
    public MunicipioBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Title property
* @return String with the Title
*/
    public String getTitle()
    {
        return getSemanticObject().getProperty(swb_title);
    }

/**
* Sets the Title property
* @param value long with the Title
*/
    public void setTitle(String value)
    {
        getSemanticObject().setProperty(swb_title, value);
    }

    public String getTitle(String lang)
    {
        return getSemanticObject().getProperty(swb_title, null, lang);
    }

    public String getDisplayTitle(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_title, lang);
    }

    public void setTitle(String title, String lang)
    {
        getSemanticObject().setProperty(swb_title, title, lang);
    }

/**
* Gets the Description property
* @return String with the Description
*/
    public String getDescription()
    {
        return getSemanticObject().getProperty(swb_description);
    }

/**
* Sets the Description property
* @param value long with the Description
*/
    public void setDescription(String value)
    {
        getSemanticObject().setProperty(swb_description, value);
    }

    public String getDescription(String lang)
    {
        return getSemanticObject().getProperty(swb_description, null, lang);
    }

    public String getDisplayDescription(String lang)
    {
        return getSemanticObject().getLocaleProperty(swb_description, lang);
    }

    public void setDescription(String description, String lang)
    {
        getSemanticObject().setProperty(swb_description, description, lang);
    }
   /**
   * Sets the value for the property Estado
   * @param value Estado to set
   */

    public void setEstado(com.infotec.eworkplace.swb.Estado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_estado, value.getSemanticObject());
        }else
        {
            removeEstado();
        }
    }
   /**
   * Remove the value for Estado property
   */

    public void removeEstado()
    {
        getSemanticObject().removeProperty(ewp_estado);
    }

   /**
   * Gets the Estado
   * @return a com.infotec.eworkplace.swb.Estado
   */
    public com.infotec.eworkplace.swb.Estado getEstado()
    {
         com.infotec.eworkplace.swb.Estado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_estado);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Estado)obj.createGenericInstance();
         }
         return ret;
    }
}
