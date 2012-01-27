package com.infotec.eworkplace.swb.base;


public abstract class CursoBase extends org.semanticwb.model.base.GenericObjectBase implements org.semanticwb.model.Descriptiveable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Curso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Curso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Curso");

    public static class ClassMgr
    {
       /**
       * Returns a list of Curso for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Curso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Curso> listCursos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Curso>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Curso for all models
       * @return Iterator of com.infotec.eworkplace.swb.Curso
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Curso> listCursos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Curso>(it, true);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       * @return A com.infotec.eworkplace.swb.Curso
       */
        public static com.infotec.eworkplace.swb.Curso getCurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Curso)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       * @return A com.infotec.eworkplace.swb.Curso
       */
        public static com.infotec.eworkplace.swb.Curso createCurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Curso)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       */
        public static void removeCurso(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Curso
       * @param id Identifier for com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Curso
       * @return true if the com.infotec.eworkplace.swb.Curso exists, false otherwise
       */

        public static boolean hasCurso(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCurso(id, model)!=null);
        }
    }

   /**
   * Constructs a CursoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Curso
   */
    public CursoBase(org.semanticwb.platform.SemanticObject base)
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

    public void remove()
    {
        getSemanticObject().remove();
    }

    public java.util.Iterator<org.semanticwb.model.GenericObject> listRelatedObjects()
    {
        return new org.semanticwb.model.GenericIterator(getSemanticObject().listRelatedObjects(),true);
    }
}
