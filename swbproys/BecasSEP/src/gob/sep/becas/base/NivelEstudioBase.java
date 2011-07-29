package gob.sep.becas.base;


public abstract class NivelEstudioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass becas_NivelEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#NivelEstudio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#NivelEstudio");

    public static class ClassMgr
    {
       /**
       * Returns a list of NivelEstudio for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.NivelEstudio
       */

        public static java.util.Iterator<gob.sep.becas.NivelEstudio> listNivelEstudios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.NivelEstudio>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.NivelEstudio for all models
       * @return Iterator of gob.sep.becas.NivelEstudio
       */

        public static java.util.Iterator<gob.sep.becas.NivelEstudio> listNivelEstudios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.NivelEstudio>(it, true);
        }

        public static gob.sep.becas.NivelEstudio createNivelEstudio(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return gob.sep.becas.NivelEstudio.ClassMgr.createNivelEstudio(String.valueOf(id), model);
        }
       /**
       * Gets a gob.sep.becas.NivelEstudio
       * @param id Identifier for gob.sep.becas.NivelEstudio
       * @param model Model of the gob.sep.becas.NivelEstudio
       * @return A gob.sep.becas.NivelEstudio
       */
        public static gob.sep.becas.NivelEstudio getNivelEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.NivelEstudio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.NivelEstudio
       * @param id Identifier for gob.sep.becas.NivelEstudio
       * @param model Model of the gob.sep.becas.NivelEstudio
       * @return A gob.sep.becas.NivelEstudio
       */
        public static gob.sep.becas.NivelEstudio createNivelEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.NivelEstudio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.NivelEstudio
       * @param id Identifier for gob.sep.becas.NivelEstudio
       * @param model Model of the gob.sep.becas.NivelEstudio
       */
        public static void removeNivelEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.NivelEstudio
       * @param id Identifier for gob.sep.becas.NivelEstudio
       * @param model Model of the gob.sep.becas.NivelEstudio
       * @return true if the gob.sep.becas.NivelEstudio exists, false otherwise
       */

        public static boolean hasNivelEstudio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNivelEstudio(id, model)!=null);
        }
    }

   /**
   * Constructs a NivelEstudioBase with a SemanticObject
   * @param base The SemanticObject with the properties for the NivelEstudio
   */
    public NivelEstudioBase(org.semanticwb.platform.SemanticObject base)
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
