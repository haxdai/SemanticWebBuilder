package mx.gob.inmujeres.swb.base;


public abstract class NivelBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass inm_Nivel=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Nivel");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.bpmninfotec.com/inm#Nivel");

    public static class ClassMgr
    {
       /**
       * Returns a list of Nivel for a model
       * @param model Model to find
       * @return Iterator of mx.gob.inmujeres.swb.Nivel
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Nivel> listNivels(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Nivel>(it, true);
        }
       /**
       * Returns a list of mx.gob.inmujeres.swb.Nivel for all models
       * @return Iterator of mx.gob.inmujeres.swb.Nivel
       */

        public static java.util.Iterator<mx.gob.inmujeres.swb.Nivel> listNivels()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<mx.gob.inmujeres.swb.Nivel>(it, true);
        }

        public static mx.gob.inmujeres.swb.Nivel createNivel(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return mx.gob.inmujeres.swb.Nivel.ClassMgr.createNivel(String.valueOf(id), model);
        }
       /**
       * Gets a mx.gob.inmujeres.swb.Nivel
       * @param id Identifier for mx.gob.inmujeres.swb.Nivel
       * @param model Model of the mx.gob.inmujeres.swb.Nivel
       * @return A mx.gob.inmujeres.swb.Nivel
       */
        public static mx.gob.inmujeres.swb.Nivel getNivel(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Nivel)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a mx.gob.inmujeres.swb.Nivel
       * @param id Identifier for mx.gob.inmujeres.swb.Nivel
       * @param model Model of the mx.gob.inmujeres.swb.Nivel
       * @return A mx.gob.inmujeres.swb.Nivel
       */
        public static mx.gob.inmujeres.swb.Nivel createNivel(String id, org.semanticwb.model.SWBModel model)
        {
            return (mx.gob.inmujeres.swb.Nivel)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a mx.gob.inmujeres.swb.Nivel
       * @param id Identifier for mx.gob.inmujeres.swb.Nivel
       * @param model Model of the mx.gob.inmujeres.swb.Nivel
       */
        public static void removeNivel(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a mx.gob.inmujeres.swb.Nivel
       * @param id Identifier for mx.gob.inmujeres.swb.Nivel
       * @param model Model of the mx.gob.inmujeres.swb.Nivel
       * @return true if the mx.gob.inmujeres.swb.Nivel exists, false otherwise
       */

        public static boolean hasNivel(String id, org.semanticwb.model.SWBModel model)
        {
            return (getNivel(id, model)!=null);
        }
    }

    public static NivelBase.ClassMgr getNivelClassMgr()
    {
        return new NivelBase.ClassMgr();
    }

   /**
   * Constructs a NivelBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Nivel
   */
    public NivelBase(org.semanticwb.platform.SemanticObject base)
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
