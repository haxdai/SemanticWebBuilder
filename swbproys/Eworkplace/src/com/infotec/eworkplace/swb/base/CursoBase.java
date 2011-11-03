package com.infotec.eworkplace.swb.base;


public abstract class CursoBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Institucion
{
    public static final org.semanticwb.platform.SemanticProperty ewp_nombreCurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#nombreCurso");
    public static final org.semanticwb.platform.SemanticClass ewp_Curso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Curso");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Curso");

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

        public static com.infotec.eworkplace.swb.Curso createCurso(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Curso.ClassMgr.createCurso(String.valueOf(id), model);
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
* Gets the Fin property
* @return java.util.Date with the Fin
*/
    public java.util.Date getFin()
    {
        return getSemanticObject().getDateProperty(ewp_fin);
    }

/**
* Sets the Fin property
* @param value long with the Fin
*/
    public void setFin(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_fin, value);
    }

/**
* Gets the DocumentoObtenido property
* @return String with the DocumentoObtenido
*/
    public String getDocumentoObtenido()
    {
        return getSemanticObject().getProperty(ewp_documentoObtenido);
    }

/**
* Sets the DocumentoObtenido property
* @param value long with the DocumentoObtenido
*/
    public void setDocumentoObtenido(String value)
    {
        getSemanticObject().setProperty(ewp_documentoObtenido, value);
    }

/**
* Gets the Inicio property
* @return java.util.Date with the Inicio
*/
    public java.util.Date getInicio()
    {
        return getSemanticObject().getDateProperty(ewp_inicio);
    }

/**
* Sets the Inicio property
* @param value long with the Inicio
*/
    public void setInicio(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_inicio, value);
    }

/**
* Gets the NombreCurso property
* @return String with the NombreCurso
*/
    public String getNombreCurso()
    {
        return getSemanticObject().getProperty(ewp_nombreCurso);
    }

/**
* Sets the NombreCurso property
* @param value long with the NombreCurso
*/
    public void setNombreCurso(String value)
    {
        getSemanticObject().setProperty(ewp_nombreCurso, value);
    }

/**
* Gets the Institucion property
* @return String with the Institucion
*/
    public String getInstitucion()
    {
        return getSemanticObject().getProperty(ewp_institucion);
    }

/**
* Sets the Institucion property
* @param value long with the Institucion
*/
    public void setInstitucion(String value)
    {
        getSemanticObject().setProperty(ewp_institucion, value);
    }
}
