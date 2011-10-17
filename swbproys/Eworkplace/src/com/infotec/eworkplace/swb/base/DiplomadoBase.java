package com.infotec.eworkplace.swb.base;


public abstract class DiplomadoBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Fecha en la que se concluyó el curso
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_fin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#fin");
   /**
   * Nombre del documentos obtenido
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_documentoObtenido=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#documentoObtenido");
   /**
   * Fecha en la que se inició el curso
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_inicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#inicio");
    public static final org.semanticwb.platform.SemanticProperty ewp_nombreDiplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#nombreDiplomado");
   /**
   * Escuela donde se obtuvo el grado académico
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#institucion");
    public static final org.semanticwb.platform.SemanticClass ewp_Diplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Diplomado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Diplomado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Diplomado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Diplomado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Diplomado> listDiplomados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Diplomado for all models
       * @return Iterator of com.infotec.eworkplace.swb.Diplomado
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Diplomado> listDiplomados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado>(it, true);
        }

        public static com.infotec.eworkplace.swb.Diplomado createDiplomado(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Diplomado.ClassMgr.createDiplomado(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       * @return A com.infotec.eworkplace.swb.Diplomado
       */
        public static com.infotec.eworkplace.swb.Diplomado getDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Diplomado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       * @return A com.infotec.eworkplace.swb.Diplomado
       */
        public static com.infotec.eworkplace.swb.Diplomado createDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Diplomado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       */
        public static void removeDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Diplomado
       * @param id Identifier for com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Diplomado
       * @return true if the com.infotec.eworkplace.swb.Diplomado exists, false otherwise
       */

        public static boolean hasDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDiplomado(id, model)!=null);
        }
    }

   /**
   * Constructs a DiplomadoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Diplomado
   */
    public DiplomadoBase(org.semanticwb.platform.SemanticObject base)
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
* Gets the NombreDiplomado property
* @return String with the NombreDiplomado
*/
    public String getNombreDiplomado()
    {
        return getSemanticObject().getProperty(ewp_nombreDiplomado);
    }

/**
* Sets the NombreDiplomado property
* @param value long with the NombreDiplomado
*/
    public void setNombreDiplomado(String value)
    {
        getSemanticObject().setProperty(ewp_nombreDiplomado, value);
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
