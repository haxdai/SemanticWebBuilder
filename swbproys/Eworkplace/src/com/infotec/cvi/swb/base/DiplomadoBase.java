package com.infotec.cvi.swb.base;


   /**
   * Contiene el Diplomado que ha cursado la persona 
   */
public abstract class DiplomadoBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Descriptiveable,com.infotec.cvi.swb.Curso,com.infotec.cvi.swb.Institucion
{
   /**
   * Contiene el Diplomado que ha cursado la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Diplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Diplomado");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Diplomado");

    public static class ClassMgr
    {
       /**
       * Returns a list of Diplomado for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Diplomado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Diplomado> listDiplomados(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Diplomado>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Diplomado for all models
       * @return Iterator of com.infotec.cvi.swb.Diplomado
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Diplomado> listDiplomados()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Diplomado>(it, true);
        }

        public static com.infotec.cvi.swb.Diplomado createDiplomado(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Diplomado.ClassMgr.createDiplomado(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Diplomado
       * @param id Identifier for com.infotec.cvi.swb.Diplomado
       * @param model Model of the com.infotec.cvi.swb.Diplomado
       * @return A com.infotec.cvi.swb.Diplomado
       */
        public static com.infotec.cvi.swb.Diplomado getDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Diplomado)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Diplomado
       * @param id Identifier for com.infotec.cvi.swb.Diplomado
       * @param model Model of the com.infotec.cvi.swb.Diplomado
       * @return A com.infotec.cvi.swb.Diplomado
       */
        public static com.infotec.cvi.swb.Diplomado createDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Diplomado)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Diplomado
       * @param id Identifier for com.infotec.cvi.swb.Diplomado
       * @param model Model of the com.infotec.cvi.swb.Diplomado
       */
        public static void removeDiplomado(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Diplomado
       * @param id Identifier for com.infotec.cvi.swb.Diplomado
       * @param model Model of the com.infotec.cvi.swb.Diplomado
       * @return true if the com.infotec.cvi.swb.Diplomado exists, false otherwise
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
* @return int with the Fin
*/
    public int getFin()
    {
        return getSemanticObject().getIntProperty(intranet_fin);
    }

/**
* Sets the Fin property
* @param value long with the Fin
*/
    public void setFin(int value)
    {
        getSemanticObject().setIntProperty(intranet_fin, value);
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
* @return int with the Inicio
*/
    public int getInicio()
    {
        return getSemanticObject().getIntProperty(intranet_inicio);
    }

/**
* Sets the Inicio property
* @param value long with the Inicio
*/
    public void setInicio(int value)
    {
        getSemanticObject().setIntProperty(intranet_inicio, value);
    }
}
