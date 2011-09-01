package gob.sep.becas.base;


public abstract class GeneroBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass becas_Genero=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Genero");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Genero");

    public static class ClassMgr
    {
       /**
       * Returns a list of Genero for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.Genero
       */

        public static java.util.Iterator<gob.sep.becas.Genero> listGeneros(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Genero>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.Genero for all models
       * @return Iterator of gob.sep.becas.Genero
       */

        public static java.util.Iterator<gob.sep.becas.Genero> listGeneros()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Genero>(it, true);
        }

        public static gob.sep.becas.Genero createGenero(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return gob.sep.becas.Genero.ClassMgr.createGenero(String.valueOf(id), model);
        }
       /**
       * Gets a gob.sep.becas.Genero
       * @param id Identifier for gob.sep.becas.Genero
       * @param model Model of the gob.sep.becas.Genero
       * @return A gob.sep.becas.Genero
       */
        public static gob.sep.becas.Genero getGenero(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Genero)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.Genero
       * @param id Identifier for gob.sep.becas.Genero
       * @param model Model of the gob.sep.becas.Genero
       * @return A gob.sep.becas.Genero
       */
        public static gob.sep.becas.Genero createGenero(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Genero)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.Genero
       * @param id Identifier for gob.sep.becas.Genero
       * @param model Model of the gob.sep.becas.Genero
       */
        public static void removeGenero(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.Genero
       * @param id Identifier for gob.sep.becas.Genero
       * @param model Model of the gob.sep.becas.Genero
       * @return true if the gob.sep.becas.Genero exists, false otherwise
       */

        public static boolean hasGenero(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGenero(id, model)!=null);
        }
    }

   /**
   * Constructs a GeneroBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Genero
   */
    public GeneroBase(org.semanticwb.platform.SemanticObject base)
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
