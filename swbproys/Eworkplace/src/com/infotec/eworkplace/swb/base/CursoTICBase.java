package com.infotec.eworkplace.swb.base;


public abstract class CursoTICBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Institucion,org.semanticwb.model.Descriptiveable,com.infotec.eworkplace.swb.Curso
{
    public static final org.semanticwb.platform.SemanticClass intranet_CursoTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CursoTIC");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CursoTIC");

    public static class ClassMgr
    {
       /**
       * Returns a list of CursoTIC for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.CursoTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CursoTIC> listCursoTICs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CursoTIC>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.CursoTIC for all models
       * @return Iterator of com.infotec.eworkplace.swb.CursoTIC
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CursoTIC> listCursoTICs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CursoTIC>(it, true);
        }

        public static com.infotec.eworkplace.swb.CursoTIC createCursoTIC(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.CursoTIC.ClassMgr.createCursoTIC(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.CursoTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CursoTIC
       * @param model Model of the com.infotec.eworkplace.swb.CursoTIC
       * @return A com.infotec.eworkplace.swb.CursoTIC
       */
        public static com.infotec.eworkplace.swb.CursoTIC getCursoTIC(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CursoTIC)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.CursoTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CursoTIC
       * @param model Model of the com.infotec.eworkplace.swb.CursoTIC
       * @return A com.infotec.eworkplace.swb.CursoTIC
       */
        public static com.infotec.eworkplace.swb.CursoTIC createCursoTIC(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CursoTIC)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.CursoTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CursoTIC
       * @param model Model of the com.infotec.eworkplace.swb.CursoTIC
       */
        public static void removeCursoTIC(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.CursoTIC
       * @param id Identifier for com.infotec.eworkplace.swb.CursoTIC
       * @param model Model of the com.infotec.eworkplace.swb.CursoTIC
       * @return true if the com.infotec.eworkplace.swb.CursoTIC exists, false otherwise
       */

        public static boolean hasCursoTIC(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCursoTIC(id, model)!=null);
        }
    }

   /**
   * Constructs a CursoTICBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CursoTIC
   */
    public CursoTICBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }

/**
* Gets the Fin property
* @return java.util.Date with the Fin
*/
    public java.util.Date getFin()
    {
        return getSemanticObject().getDateProperty(intranet_fin);
    }

/**
* Sets the Fin property
* @param value long with the Fin
*/
    public void setFin(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_fin, value);
    }

/**
* Gets the DocumentoObtenido property
* @return String with the DocumentoObtenido
*/
    public String getDocumentoObtenido()
    {
        return getSemanticObject().getProperty(intranet_documentoObtenido);
    }

/**
* Sets the DocumentoObtenido property
* @param value long with the DocumentoObtenido
*/
    public void setDocumentoObtenido(String value)
    {
        getSemanticObject().setProperty(intranet_documentoObtenido, value);
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
* Gets the NombreInstitucion property
* @return String with the NombreInstitucion
*/
    public String getNombreInstitucion()
    {
        return getSemanticObject().getProperty(intranet_nombreInstitucion);
    }

/**
* Sets the NombreInstitucion property
* @param value long with the NombreInstitucion
*/
    public void setNombreInstitucion(String value)
    {
        getSemanticObject().setProperty(intranet_nombreInstitucion, value);
    }

/**
* Gets the Inicio property
* @return java.util.Date with the Inicio
*/
    public java.util.Date getInicio()
    {
        return getSemanticObject().getDateProperty(intranet_inicio);
    }

/**
* Sets the Inicio property
* @param value long with the Inicio
*/
    public void setInicio(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_inicio, value);
    }
}
