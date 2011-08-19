package gob.sep.becas.base;


public abstract class EstadoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass becas_Municipio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Municipio");
    public static final org.semanticwb.platform.SemanticProperty becas_hasMunicipioInv=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#hasMunicipioInv");
    public static final org.semanticwb.platform.SemanticClass becas_Estado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Estado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/sep/becas.owl#Estado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Estado for a model
       * @param model Model to find
       * @return Iterator of gob.sep.becas.Estado
       */

        public static java.util.Iterator<gob.sep.becas.Estado> listEstados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Estado>(it, true);
        }
       /**
       * Returns a list of gob.sep.becas.Estado for all models
       * @return Iterator of gob.sep.becas.Estado
       */

        public static java.util.Iterator<gob.sep.becas.Estado> listEstados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<gob.sep.becas.Estado>(it, true);
        }
       /**
       * Gets a gob.sep.becas.Estado
       * @param id Identifier for gob.sep.becas.Estado
       * @param model Model of the gob.sep.becas.Estado
       * @return A gob.sep.becas.Estado
       */
        public static gob.sep.becas.Estado getEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Estado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a gob.sep.becas.Estado
       * @param id Identifier for gob.sep.becas.Estado
       * @param model Model of the gob.sep.becas.Estado
       * @return A gob.sep.becas.Estado
       */
        public static gob.sep.becas.Estado createEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (gob.sep.becas.Estado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a gob.sep.becas.Estado
       * @param id Identifier for gob.sep.becas.Estado
       * @param model Model of the gob.sep.becas.Estado
       */
        public static void removeEstado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a gob.sep.becas.Estado
       * @param id Identifier for gob.sep.becas.Estado
       * @param model Model of the gob.sep.becas.Estado
       * @return true if the gob.sep.becas.Estado exists, false otherwise
       */

        public static boolean hasEstado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEstado(id, model)!=null);
        }
       /**
       * Gets all gob.sep.becas.Estado with a determined MunicipioInv
       * @param value MunicipioInv of the type gob.sep.becas.Municipio
       * @param model Model of the gob.sep.becas.Estado
       * @return Iterator with all the gob.sep.becas.Estado
       */

        public static java.util.Iterator<gob.sep.becas.Estado> listEstadoByMunicipioInv(gob.sep.becas.Municipio value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Estado> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(becas_hasMunicipioInv, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all gob.sep.becas.Estado with a determined MunicipioInv
       * @param value MunicipioInv of the type gob.sep.becas.Municipio
       * @return Iterator with all the gob.sep.becas.Estado
       */

        public static java.util.Iterator<gob.sep.becas.Estado> listEstadoByMunicipioInv(gob.sep.becas.Municipio value)
        {
            org.semanticwb.model.GenericIterator<gob.sep.becas.Estado> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(becas_hasMunicipioInv,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EstadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Estado
   */
    public EstadoBase(org.semanticwb.platform.SemanticObject base)
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
   * Gets all the gob.sep.becas.Municipio
   * @return A GenericIterator with all the gob.sep.becas.Municipio
   */

    public org.semanticwb.model.GenericIterator<gob.sep.becas.Municipio> listMunicipioInvs()
    {
        return new org.semanticwb.model.GenericIterator<gob.sep.becas.Municipio>(getSemanticObject().listObjectProperties(becas_hasMunicipioInv));
    }

   /**
   * Gets true if has a MunicipioInv
   * @param value gob.sep.becas.Municipio to verify
   * @return true if the gob.sep.becas.Municipio exists, false otherwise
   */
    public boolean hasMunicipioInv(gob.sep.becas.Municipio value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(becas_hasMunicipioInv,value.getSemanticObject());
        }
        return ret;
    }

   /**
   * Gets the MunicipioInv
   * @return a gob.sep.becas.Municipio
   */
    public gob.sep.becas.Municipio getMunicipioInv()
    {
         gob.sep.becas.Municipio ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(becas_hasMunicipioInv);
         if(obj!=null)
         {
             ret=(gob.sep.becas.Municipio)obj.createGenericInstance();
         }
         return ret;
    }
}
