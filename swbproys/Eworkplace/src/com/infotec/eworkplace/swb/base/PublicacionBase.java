package com.infotec.eworkplace.swb.base;


public abstract class PublicacionBase extends com.infotec.eworkplace.swb.InvestigacionDocencia implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty intranet_fechapublicado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#fechapublicado");
    public static final org.semanticwb.platform.SemanticProperty intranet_publicado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#publicado");
    public static final org.semanticwb.platform.SemanticClass intranet_Publicacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Publicacion");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Publicacion");

    public static class ClassMgr
    {
       /**
       * Returns a list of Publicacion for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Publicacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Publicacion> listPublicacions(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Publicacion>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Publicacion for all models
       * @return Iterator of com.infotec.eworkplace.swb.Publicacion
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Publicacion> listPublicacions()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Publicacion>(it, true);
        }

        public static com.infotec.eworkplace.swb.Publicacion createPublicacion(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Publicacion.ClassMgr.createPublicacion(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Publicacion
       * @param id Identifier for com.infotec.eworkplace.swb.Publicacion
       * @param model Model of the com.infotec.eworkplace.swb.Publicacion
       * @return A com.infotec.eworkplace.swb.Publicacion
       */
        public static com.infotec.eworkplace.swb.Publicacion getPublicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Publicacion)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Publicacion
       * @param id Identifier for com.infotec.eworkplace.swb.Publicacion
       * @param model Model of the com.infotec.eworkplace.swb.Publicacion
       * @return A com.infotec.eworkplace.swb.Publicacion
       */
        public static com.infotec.eworkplace.swb.Publicacion createPublicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Publicacion)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Publicacion
       * @param id Identifier for com.infotec.eworkplace.swb.Publicacion
       * @param model Model of the com.infotec.eworkplace.swb.Publicacion
       */
        public static void removePublicacion(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Publicacion
       * @param id Identifier for com.infotec.eworkplace.swb.Publicacion
       * @param model Model of the com.infotec.eworkplace.swb.Publicacion
       * @return true if the com.infotec.eworkplace.swb.Publicacion exists, false otherwise
       */

        public static boolean hasPublicacion(String id, org.semanticwb.model.SWBModel model)
        {
            return (getPublicacion(id, model)!=null);
        }
    }

   /**
   * Constructs a PublicacionBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Publicacion
   */
    public PublicacionBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Fechapublicado property
* @return java.util.Date with the Fechapublicado
*/
    public java.util.Date getFechapublicado()
    {
        return getSemanticObject().getDateProperty(intranet_fechapublicado);
    }

/**
* Sets the Fechapublicado property
* @param value long with the Fechapublicado
*/
    public void setFechapublicado(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fechapublicado, value);
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
* Gets the Publicado property
* @return String with the Publicado
*/
    public String getPublicado()
    {
        return getSemanticObject().getProperty(intranet_publicado);
    }

/**
* Sets the Publicado property
* @param value long with the Publicado
*/
    public void setPublicado(String value)
    {
        getSemanticObject().setProperty(intranet_publicado, value);
    }
}
