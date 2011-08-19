package gob.sep.becas.base;


public abstract class MunicipioBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass becas_Estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Estado");
    public static final org.semanticwb.platform.SemanticProperty becas_PerteneceA=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#PerteneceA");
    public static final org.semanticwb.platform.SemanticClass becas_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Municipio");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Municipio");

    public static class ClassMgr
    {
       /**
       * Returns a list of Municipio for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.Municipio
       */

        public static java.util.Iterator<gob.sep.becas.Municipio> listMunicipios(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Municipio>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.Municipio for all models
       * @return Iterator of gob.sep.becas.Municipio
       */

        public static java.util.Iterator<gob.sep.becas.Municipio> listMunicipios()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Municipio>(it, true);
        }
       /**
       * Gets a gob.sep.becas.Municipio
       * @param id Identifier for gob.sep.becas.Municipio
       * @param model Model of the gob.sep.becas.Municipio
       * @return A gob.sep.becas.Municipio
       */
        public static gob.sep.becas.Municipio getMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Municipio)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.Municipio
       * @param id Identifier for gob.sep.becas.Municipio
       * @param model Model of the gob.sep.becas.Municipio
       * @return A gob.sep.becas.Municipio
       */
        public static gob.sep.becas.Municipio createMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Municipio)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.Municipio
       * @param id Identifier for gob.sep.becas.Municipio
       * @param model Model of the gob.sep.becas.Municipio
       */
        public static void removeMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.Municipio
       * @param id Identifier for gob.sep.becas.Municipio
       * @param model Model of the gob.sep.becas.Municipio
       * @return true if the gob.sep.becas.Municipio exists, false otherwise
       */

        public static boolean hasMunicipio(String id, org.semanticwb.model.SWBModel model)
        {
            return (getMunicipio(id, model)!=null);
        }
       /**
       * Gets all gob.sep.becas.Municipio with a determined PerteneceA
       * @param value PerteneceA of the type gob.sep.becas.Estado
       * @param model Model of the gob.sep.becas.Municipio
       * @return Iterator with all the gob.sep.becas.Municipio
       */

        public static java.util.Iterator<gob.sep.becas.Municipio> listMunicipioByPerteneceA(gob.sep.becas.Estado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Municipio> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_PerteneceA, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.Municipio with a determined PerteneceA
       * @param value PerteneceA of the type gob.sep.becas.Estado
       * @return Iterator with all the gob.sep.becas.Municipio
       */

        public static java.util.Iterator<gob.sep.becas.Municipio> listMunicipioByPerteneceA(gob.sep.becas.Estado value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Municipio> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_PerteneceA,value.getSemanticObject(),sclass));
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
   * Sets the value for the property PerteneceA
   * @param value PerteneceA to set
   */

    public void setPerteneceA(gob.sep.becas.Estado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(becas_PerteneceA, value.getSemanticObject());
        }else
        {
            removePerteneceA();
        }
    }
   /**
   * Remove the value for PerteneceA property
   */

    public void removePerteneceA()
    {
        getSemanticObject().removeProperty(becas_PerteneceA);
    }

   /**
   * Gets the PerteneceA
   * @return a gob.sep.becas.Estado
   */
    public gob.sep.becas.Estado getPerteneceA()
    {
         gob.sep.becas.Estado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_PerteneceA);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Estado)obj.createGenericInstance();
         }
         return ret;
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
