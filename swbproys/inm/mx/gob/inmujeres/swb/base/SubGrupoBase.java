package mx.gob.inmujeres.swb.base;


public abstract class SubGrupoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticProperty inm_numsubgrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.bpmninfotec.com/inm#numsubgrupo");
    public static final org.semanticwb.platform.SemanticClass inm_SubGrupo=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SubGrupo");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#SubGrupo");

    public static class ClassMgr
    {
       /**
       * Returns a list of SubGrupo for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.SubGrupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SubGrupo> listSubGrupos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.SubGrupo for all models
       * @return Iterator of mx.gob.inmujeres.swb.SubGrupo
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.SubGrupo> listSubGrupos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.SubGrupo>(it, true);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       * @return A mx.gob.inmujeres.swb.SubGrupo
       */
        public static mx.gob.inmujeres.swb.SubGrupo getSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SubGrupo)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       * @return A mx.gob.inmujeres.swb.SubGrupo
       */
        public static mx.gob.inmujeres.swb.SubGrupo createSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.SubGrupo)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       */
        public static void removeSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.SubGrupo
       * @param id Identifier for mx.gob.inmujeres.swb.SubGrupo
       * @param model Model of the mx.gob.inmujeres.swb.SubGrupo
       * @return true if the mx.gob.inmujeres.swb.SubGrupo exists, false otherwise
       */

        public static boolean hasSubGrupo(String id, org.semanticwb.model.SWBModel model)
        {
            return (getSubGrupo(id, model)!=null);
        }
    }

   /**
   * Constructs a SubGrupoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the SubGrupo
   */
    public SubGrupoBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the Numsubgrupo property
* @return int with the Numsubgrupo
*/
    public int getNumsubgrupo()
    {
        return getSemanticObject().getIntProperty(inm_numsubgrupo);
    }

/**
* Sets the Numsubgrupo property
* @param value long with the Numsubgrupo
*/
    public void setNumsubgrupo(int value)
    {
        getSemanticObject().setIntProperty(inm_numsubgrupo, value);
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
