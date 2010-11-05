package org.semanticwb.ecosikan.innova.base;


public abstract class SecretariaBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass ecoskn_Secretaria=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Secretaria");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://ecosikan.infotec.com.mx#Secretaria");

    public static class ClassMgr
    {
       /**
       * Returns a list of Secretaria for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.ecosikan.innova.Secretaria
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Secretaria> listSecretarias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Secretaria>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.ecosikan.innova.Secretaria for all models
       * @return Iterator of org.semanticwb.ecosikan.innova.Secretaria
       */

        public static java.util.Iterator<org.semanticwb.ecosikan.innova.Secretaria> listSecretarias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.ecosikan.innova.Secretaria>(it, true);
        }
       /**
       * Gets a org.semanticwb.ecosikan.innova.Secretaria
       * @param id Identifier for org.semanticwb.ecosikan.innova.Secretaria
       * @param model Model of the org.semanticwb.ecosikan.innova.Secretaria
       * @return A org.semanticwb.ecosikan.innova.Secretaria
       */
        public static org.semanticwb.ecosikan.innova.Secretaria getSecretaria(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Secretaria)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.ecosikan.innova.Secretaria
       * @param id Identifier for org.semanticwb.ecosikan.innova.Secretaria
       * @param model Model of the org.semanticwb.ecosikan.innova.Secretaria
       * @return A org.semanticwb.ecosikan.innova.Secretaria
       */
        public static org.semanticwb.ecosikan.innova.Secretaria createSecretaria(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.ecosikan.innova.Secretaria)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.ecosikan.innova.Secretaria
       * @param id Identifier for org.semanticwb.ecosikan.innova.Secretaria
       * @param model Model of the org.semanticwb.ecosikan.innova.Secretaria
       */
        public static void removeSecretaria(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.ecosikan.innova.Secretaria
       * @param id Identifier for org.semanticwb.ecosikan.innova.Secretaria
       * @param model Model of the org.semanticwb.ecosikan.innova.Secretaria
       * @return true if the org.semanticwb.ecosikan.innova.Secretaria exists, false otherwise
       */

        public static boolean hasSecretaria(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSecretaria(id, model)!=null);
        }
    }

   /**
   * Constructs a SecretariaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Secretaria
   */
    public SecretariaBase(org.semanticwb.platform.SemanticObject base)
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
