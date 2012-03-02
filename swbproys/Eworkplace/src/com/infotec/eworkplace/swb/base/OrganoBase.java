package com.infotec.eworkplace.swb.base;


public abstract class OrganoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Mision,org.semanticwb.model.Descriptiveable,com.infotec.eworkplace.swb.Vision,com.infotec.eworkplace.swb.Extensible
{
    public static final org.semanticwb.platform.SemanticClass intranet_Organo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Organo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Organo");

    public static class ClassMgr
    {
       /**
       * Returns a list of Organo for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Organo
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Organo> listOrganos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Organo>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Organo for all models
       * @return Iterator of com.infotec.eworkplace.swb.Organo
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Organo> listOrganos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Organo>(it, true);
        }

        public static com.infotec.eworkplace.swb.Organo createOrgano(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Organo.ClassMgr.createOrgano(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Organo
       * @param id Identifier for com.infotec.eworkplace.swb.Organo
       * @param model Model of the com.infotec.eworkplace.swb.Organo
       * @return A com.infotec.eworkplace.swb.Organo
       */
        public static com.infotec.eworkplace.swb.Organo getOrgano(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Organo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Organo
       * @param id Identifier for com.infotec.eworkplace.swb.Organo
       * @param model Model of the com.infotec.eworkplace.swb.Organo
       * @return A com.infotec.eworkplace.swb.Organo
       */
        public static com.infotec.eworkplace.swb.Organo createOrgano(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Organo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Organo
       * @param id Identifier for com.infotec.eworkplace.swb.Organo
       * @param model Model of the com.infotec.eworkplace.swb.Organo
       */
        public static void removeOrgano(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Organo
       * @param id Identifier for com.infotec.eworkplace.swb.Organo
       * @param model Model of the com.infotec.eworkplace.swb.Organo
       * @return true if the com.infotec.eworkplace.swb.Organo exists, false otherwise
       */

        public static boolean hasOrgano(String id, org.semanticwb.model.SWBModel model)
        {
            return (getOrgano(id, model)!=null);
        }
    }

   /**
   * Constructs a OrganoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Organo
   */
    public OrganoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
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
* Gets the Mision property
* @return String with the Mision
*/
    public String getMision()
    {
        return getSemanticObject().getProperty(intranet_mision);
    }

/**
* Sets the Mision property
* @param value long with the Mision
*/
    public void setMision(String value)
    {
        getSemanticObject().setProperty(intranet_mision, value);
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
* Gets the Vision property
* @return String with the Vision
*/
    public String getVision()
    {
        return getSemanticObject().getProperty(intranet_vision);
    }

/**
* Sets the Vision property
* @param value long with the Vision
*/
    public void setVision(String value)
    {
        getSemanticObject().setProperty(intranet_vision, value);
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
