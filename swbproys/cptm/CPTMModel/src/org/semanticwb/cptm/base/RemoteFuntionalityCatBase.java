package org.semanticwb.cptm.base;


public abstract class RemoteFuntionalityCatBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass cptm_RemoteFuntionalityCat=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RemoteFuntionalityCat");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/cptm#RemoteFuntionalityCat");

    public static class ClassMgr
    {
       /**
       * Returns a list of RemoteFuntionalityCat for a model
       * @param model Model to find
       * @return Iterator of org.semanticwb.cptm.RemoteFuntionalityCat
       */

        public static java.util.Iterator<org.semanticwb.cptm.RemoteFuntionalityCat> listRemoteFuntionalityCats(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RemoteFuntionalityCat>(it, true);
        }
       /**
       * Returns a list of org.semanticwb.cptm.RemoteFuntionalityCat for all models
       * @return Iterator of org.semanticwb.cptm.RemoteFuntionalityCat
       */

        public static java.util.Iterator<org.semanticwb.cptm.RemoteFuntionalityCat> listRemoteFuntionalityCats()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<org.semanticwb.cptm.RemoteFuntionalityCat>(it, true);
        }
       /**
       * Gets a org.semanticwb.cptm.RemoteFuntionalityCat
       * @param id Identifier for org.semanticwb.cptm.RemoteFuntionalityCat
       * @param model Model of the org.semanticwb.cptm.RemoteFuntionalityCat
       * @return A org.semanticwb.cptm.RemoteFuntionalityCat
       */
        public static org.semanticwb.cptm.RemoteFuntionalityCat getRemoteFuntionalityCat(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.RemoteFuntionalityCat)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a org.semanticwb.cptm.RemoteFuntionalityCat
       * @param id Identifier for org.semanticwb.cptm.RemoteFuntionalityCat
       * @param model Model of the org.semanticwb.cptm.RemoteFuntionalityCat
       * @return A org.semanticwb.cptm.RemoteFuntionalityCat
       */
        public static org.semanticwb.cptm.RemoteFuntionalityCat createRemoteFuntionalityCat(String id, org.semanticwb.model.SWBModel model)
        {
            return (org.semanticwb.cptm.RemoteFuntionalityCat)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a org.semanticwb.cptm.RemoteFuntionalityCat
       * @param id Identifier for org.semanticwb.cptm.RemoteFuntionalityCat
       * @param model Model of the org.semanticwb.cptm.RemoteFuntionalityCat
       */
        public static void removeRemoteFuntionalityCat(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a org.semanticwb.cptm.RemoteFuntionalityCat
       * @param id Identifier for org.semanticwb.cptm.RemoteFuntionalityCat
       * @param model Model of the org.semanticwb.cptm.RemoteFuntionalityCat
       * @return true if the org.semanticwb.cptm.RemoteFuntionalityCat exists, false otherwise
       */

        public static boolean hasRemoteFuntionalityCat(String id, org.semanticwb.model.SWBModel model)
        {
            return (getRemoteFuntionalityCat(id, model)!=null);
        }
    }

   /**
   * Constructs a RemoteFuntionalityCatBase with a SemanticObject
   * @param base The SemanticObject with the properties for the RemoteFuntionalityCat
   */
    public RemoteFuntionalityCatBase(org.semanticwb.platform.SemanticObject base)
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
