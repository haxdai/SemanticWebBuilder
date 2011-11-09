package com.infotec.eworkplace.swb.base;


   /**
   * Entidad federativa 
   */
public abstract class EntidadFederativaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
   /**
   * Entidad federativa
   */
    public static final org.semanticwb.platform.SemanticClass ewp_EntidadFederativa=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#EntidadFederativa");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#EntidadFederativa");

    public static class ClassMgr
    {
       /**
       * Returns a list of EntidadFederativa for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EntidadFederativa> listEntidadFederativas(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EntidadFederativa>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.EntidadFederativa for all models
       * @return Iterator of com.infotec.eworkplace.swb.EntidadFederativa
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EntidadFederativa> listEntidadFederativas()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EntidadFederativa>(it, true);
        }

        public static com.infotec.eworkplace.swb.EntidadFederativa createEntidadFederativa(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.EntidadFederativa.ClassMgr.createEntidadFederativa(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.EntidadFederativa
       * @param id Identifier for com.infotec.eworkplace.swb.EntidadFederativa
       * @param model Model of the com.infotec.eworkplace.swb.EntidadFederativa
       * @return A com.infotec.eworkplace.swb.EntidadFederativa
       */
        public static com.infotec.eworkplace.swb.EntidadFederativa getEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EntidadFederativa)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.EntidadFederativa
       * @param id Identifier for com.infotec.eworkplace.swb.EntidadFederativa
       * @param model Model of the com.infotec.eworkplace.swb.EntidadFederativa
       * @return A com.infotec.eworkplace.swb.EntidadFederativa
       */
        public static com.infotec.eworkplace.swb.EntidadFederativa createEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EntidadFederativa)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.EntidadFederativa
       * @param id Identifier for com.infotec.eworkplace.swb.EntidadFederativa
       * @param model Model of the com.infotec.eworkplace.swb.EntidadFederativa
       */
        public static void removeEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.EntidadFederativa
       * @param id Identifier for com.infotec.eworkplace.swb.EntidadFederativa
       * @param model Model of the com.infotec.eworkplace.swb.EntidadFederativa
       * @return true if the com.infotec.eworkplace.swb.EntidadFederativa exists, false otherwise
       */

        public static boolean hasEntidadFederativa(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEntidadFederativa(id, model)!=null);
        }
    }

   /**
   * Constructs a EntidadFederativaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EntidadFederativa
   */
    public EntidadFederativaBase(org.semanticwb.platform.SemanticObject base)
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
}
