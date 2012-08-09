package com.infotec.cvi.swb.base;


   /**
   * Elemento que almacena la información del Grado Académico de la persona 
   */
public abstract class GradoAcademicoBase extends org.semanticwb.model.SWBClass implements com.infotec.cvi.swb.Periodo,com.infotec.cvi.swb.Institucion
{
   /**
   * Catálogo utilizado para indicar la Situación Académica del Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_SituacionAcademica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#SituacionAcademica");
    public static final org.semanticwb.platform.SemanticProperty intranet_situacionAcademica=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#situacionAcademica");
   /**
   * Catálogo utilizado para indicar el Grado Académico alcanzado.
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Grado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Grado");
    public static final org.semanticwb.platform.SemanticProperty intranet_grado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#grado");
   /**
   * Catálogo utilizado para las carreras utilizadas para la captura de Grado Académico
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Carrera");
    public static final org.semanticwb.platform.SemanticProperty intranet_carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#carrera");
   /**
   * Elemento que almacena la información del Grado Académico de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_GradoAcademico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#GradoAcademico");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#GradoAcademico");

    public static class ClassMgr
    {
       /**
       * Returns a list of GradoAcademico for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicos(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.GradoAcademico for all models
       * @return Iterator of com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicos()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico>(it, true);
        }

        public static com.infotec.cvi.swb.GradoAcademico createGradoAcademico(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.GradoAcademico.ClassMgr.createGradoAcademico(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.GradoAcademico
       * @param id Identifier for com.infotec.cvi.swb.GradoAcademico
       * @param model Model of the com.infotec.cvi.swb.GradoAcademico
       * @return A com.infotec.cvi.swb.GradoAcademico
       */
        public static com.infotec.cvi.swb.GradoAcademico getGradoAcademico(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.GradoAcademico)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.GradoAcademico
       * @param id Identifier for com.infotec.cvi.swb.GradoAcademico
       * @param model Model of the com.infotec.cvi.swb.GradoAcademico
       * @return A com.infotec.cvi.swb.GradoAcademico
       */
        public static com.infotec.cvi.swb.GradoAcademico createGradoAcademico(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.GradoAcademico)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.GradoAcademico
       * @param id Identifier for com.infotec.cvi.swb.GradoAcademico
       * @param model Model of the com.infotec.cvi.swb.GradoAcademico
       */
        public static void removeGradoAcademico(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.GradoAcademico
       * @param id Identifier for com.infotec.cvi.swb.GradoAcademico
       * @param model Model of the com.infotec.cvi.swb.GradoAcademico
       * @return true if the com.infotec.cvi.swb.GradoAcademico exists, false otherwise
       */

        public static boolean hasGradoAcademico(String id, org.semanticwb.model.SWBModel model)
        {
            return (getGradoAcademico(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.GradoAcademico with a determined SituacionAcademica
       * @param value SituacionAcademica of the type com.infotec.cvi.swb.SituacionAcademica
       * @param model Model of the com.infotec.cvi.swb.GradoAcademico
       * @return Iterator with all the com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicoBySituacionAcademica(com.infotec.cvi.swb.SituacionAcademica value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_situacionAcademica, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.GradoAcademico with a determined SituacionAcademica
       * @param value SituacionAcademica of the type com.infotec.cvi.swb.SituacionAcademica
       * @return Iterator with all the com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicoBySituacionAcademica(com.infotec.cvi.swb.SituacionAcademica value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_situacionAcademica,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.GradoAcademico with a determined Grado
       * @param value Grado of the type com.infotec.cvi.swb.Grado
       * @param model Model of the com.infotec.cvi.swb.GradoAcademico
       * @return Iterator with all the com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicoByGrado(com.infotec.cvi.swb.Grado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_grado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.GradoAcademico with a determined Grado
       * @param value Grado of the type com.infotec.cvi.swb.Grado
       * @return Iterator with all the com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicoByGrado(com.infotec.cvi.swb.Grado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_grado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.GradoAcademico with a determined Carrera
       * @param value Carrera of the type com.infotec.cvi.swb.Carrera
       * @param model Model of the com.infotec.cvi.swb.GradoAcademico
       * @return Iterator with all the com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicoByCarrera(com.infotec.cvi.swb.Carrera value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_carrera, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.GradoAcademico with a determined Carrera
       * @param value Carrera of the type com.infotec.cvi.swb.Carrera
       * @return Iterator with all the com.infotec.cvi.swb.GradoAcademico
       */

        public static java.util.Iterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicoByCarrera(com.infotec.cvi.swb.Carrera value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_carrera,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a GradoAcademicoBase with a SemanticObject
   * @param base The SemanticObject with the properties for the GradoAcademico
   */
    public GradoAcademicoBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property SituacionAcademica
   * @param value SituacionAcademica to set
   */

    public void setSituacionAcademica(com.infotec.cvi.swb.SituacionAcademica value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_situacionAcademica, value.getSemanticObject());
        }else
        {
            removeSituacionAcademica();
        }
    }
   /**
   * Remove the value for SituacionAcademica property
   */

    public void removeSituacionAcademica()
    {
        getSemanticObject().removeProperty(intranet_situacionAcademica);
    }

   /**
   * Gets the SituacionAcademica
   * @return a com.infotec.cvi.swb.SituacionAcademica
   */
    public com.infotec.cvi.swb.SituacionAcademica getSituacionAcademica()
    {
         com.infotec.cvi.swb.SituacionAcademica ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_situacionAcademica);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.SituacionAcademica)obj.createGenericInstance();
         }
         return ret;
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
   /**
   * Sets the value for the property Grado
   * @param value Grado to set
   */

    public void setGrado(com.infotec.cvi.swb.Grado value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_grado, value.getSemanticObject());
        }else
        {
            removeGrado();
        }
    }
   /**
   * Remove the value for Grado property
   */

    public void removeGrado()
    {
        getSemanticObject().removeProperty(intranet_grado);
    }

   /**
   * Gets the Grado
   * @return a com.infotec.cvi.swb.Grado
   */
    public com.infotec.cvi.swb.Grado getGrado()
    {
         com.infotec.cvi.swb.Grado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_grado);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Grado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Carrera
   * @param value Carrera to set
   */

    public void setCarrera(com.infotec.cvi.swb.Carrera value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_carrera, value.getSemanticObject());
        }else
        {
            removeCarrera();
        }
    }
   /**
   * Remove the value for Carrera property
   */

    public void removeCarrera()
    {
        getSemanticObject().removeProperty(intranet_carrera);
    }

   /**
   * Gets the Carrera
   * @return a com.infotec.cvi.swb.Carrera
   */
    public com.infotec.cvi.swb.Carrera getCarrera()
    {
         com.infotec.cvi.swb.Carrera ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_carrera);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Carrera)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the PeriodoYears property
* @return int with the PeriodoYears
*/
    public int getPeriodoYears()
    {
        return getSemanticObject().getIntProperty(intranet_periodoYears);
    }

/**
* Sets the PeriodoYears property
* @param value long with the PeriodoYears
*/
    public void setPeriodoYears(int value)
    {
        getSemanticObject().setIntProperty(intranet_periodoYears, value);
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
}
