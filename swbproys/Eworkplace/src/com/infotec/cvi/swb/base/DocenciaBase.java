package com.infotec.cvi.swb.base;


public abstract class DocenciaBase extends com.infotec.cvi.swb.InvestigacionDocencia 
{
   /**
   * Catálogo utilizado para indicar el nivel en el cual se a impartido cursos en Docencia
   */
    public static final org.semanticwb.platform.SemanticClass intranet_NivelDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#NivelDocencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_nivelDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#nivelDocencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_aniosDocencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#aniosDocencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_asignatura=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#asignatura");
    public static final org.semanticwb.platform.SemanticProperty intranet_institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#institucion");
    public static final org.semanticwb.platform.SemanticClass intranet_Docencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Docencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Docencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Docencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Docencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Docencia> listDocencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Docencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Docencia for all models
       * @return Iterator of com.infotec.cvi.swb.Docencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Docencia> listDocencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Docencia>(it, true);
        }

        public static com.infotec.cvi.swb.Docencia createDocencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Docencia.ClassMgr.createDocencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Docencia
       * @param id Identifier for com.infotec.cvi.swb.Docencia
       * @param model Model of the com.infotec.cvi.swb.Docencia
       * @return A com.infotec.cvi.swb.Docencia
       */
        public static com.infotec.cvi.swb.Docencia getDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Docencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Docencia
       * @param id Identifier for com.infotec.cvi.swb.Docencia
       * @param model Model of the com.infotec.cvi.swb.Docencia
       * @return A com.infotec.cvi.swb.Docencia
       */
        public static com.infotec.cvi.swb.Docencia createDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Docencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Docencia
       * @param id Identifier for com.infotec.cvi.swb.Docencia
       * @param model Model of the com.infotec.cvi.swb.Docencia
       */
        public static void removeDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Docencia
       * @param id Identifier for com.infotec.cvi.swb.Docencia
       * @param model Model of the com.infotec.cvi.swb.Docencia
       * @return true if the com.infotec.cvi.swb.Docencia exists, false otherwise
       */

        public static boolean hasDocencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getDocencia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Docencia with a determined NivelDocencia
       * @param value NivelDocencia of the type com.infotec.cvi.swb.NivelDocencia
       * @param model Model of the com.infotec.cvi.swb.Docencia
       * @return Iterator with all the com.infotec.cvi.swb.Docencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Docencia> listDocenciaByNivelDocencia(com.infotec.cvi.swb.NivelDocencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Docencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelDocencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Docencia with a determined NivelDocencia
       * @param value NivelDocencia of the type com.infotec.cvi.swb.NivelDocencia
       * @return Iterator with all the com.infotec.cvi.swb.Docencia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Docencia> listDocenciaByNivelDocencia(com.infotec.cvi.swb.NivelDocencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Docencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_nivelDocencia,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static DocenciaBase.ClassMgr getDocenciaClassMgr()
    {
        return new DocenciaBase.ClassMgr();
    }

   /**
   * Constructs a DocenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Docencia
   */
    public DocenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property NivelDocencia
   * @param value NivelDocencia to set
   */

    public void setNivelDocencia(com.infotec.cvi.swb.NivelDocencia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_nivelDocencia, value.getSemanticObject());
        }else
        {
            removeNivelDocencia();
        }
    }
   /**
   * Remove the value for NivelDocencia property
   */

    public void removeNivelDocencia()
    {
        getSemanticObject().removeProperty(intranet_nivelDocencia);
    }

   /**
   * Gets the NivelDocencia
   * @return a com.infotec.cvi.swb.NivelDocencia
   */
    public com.infotec.cvi.swb.NivelDocencia getNivelDocencia()
    {
         com.infotec.cvi.swb.NivelDocencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_nivelDocencia);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.NivelDocencia)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the AniosDocencia property
* @return int with the AniosDocencia
*/
    public int getAniosDocencia()
    {
        return getSemanticObject().getIntProperty(intranet_aniosDocencia);
    }

/**
* Sets the AniosDocencia property
* @param value long with the AniosDocencia
*/
    public void setAniosDocencia(int value)
    {
        getSemanticObject().setIntProperty(intranet_aniosDocencia, value);
    }

/**
* Gets the Asignatura property
* @return String with the Asignatura
*/
    public String getAsignatura()
    {
        return getSemanticObject().getProperty(intranet_asignatura);
    }

/**
* Sets the Asignatura property
* @param value long with the Asignatura
*/
    public void setAsignatura(String value)
    {
        getSemanticObject().setProperty(intranet_asignatura, value);
    }

/**
* Gets the Institucion property
* @return String with the Institucion
*/
    public String getInstitucion()
    {
        return getSemanticObject().getProperty(intranet_institucion);
    }

/**
* Sets the Institucion property
* @param value long with the Institucion
*/
    public void setInstitucion(String value)
    {
        getSemanticObject().setProperty(intranet_institucion, value);
    }
}
