package com.infotec.eworkplace.swb.base;


public abstract class AcademiaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ewp_Curso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Curso");
    public static final org.semanticwb.platform.SemanticProperty ewp_hasCurso=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasCurso");
   /**
   * Nombre del documentos obtenido
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_documentoObtenido=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#documentoObtenido");
    public static final org.semanticwb.platform.SemanticClass ewp_Idioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Idioma");
    public static final org.semanticwb.platform.SemanticProperty ewp_hasIdioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasIdioma");
   /**
   * Fecha en la que se concluyó el curso
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_fin=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#fin");
    public static final org.semanticwb.platform.SemanticProperty ewp_situacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#situacion");
    public static final org.semanticwb.platform.SemanticClass ewp_Certificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Certificacion");
    public static final org.semanticwb.platform.SemanticProperty ewp_hasCertificacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasCertificacion");
   /**
   * Fecha en la que se inició el curso
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_inicio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#inicio");
    public static final org.semanticwb.platform.SemanticProperty ewp_grado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#grado");
   /**
   * Carrera o especialidad
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_carrera=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#carrera");
   /**
   * Escuela donde se obtuvo el grado académico
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_institucion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#institucion");
    public static final org.semanticwb.platform.SemanticClass ewp_Diplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Diplomado");
    public static final org.semanticwb.platform.SemanticProperty ewp_hasDiplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasDiplomado");
    public static final org.semanticwb.platform.SemanticClass ewp_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Academia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Academia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Academia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Academia for all models
       * @return Iterator of com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia>(it, true);
        }

        public static com.infotec.eworkplace.swb.Academia createAcademia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Academia.ClassMgr.createAcademia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return A com.infotec.eworkplace.swb.Academia
       */
        public static com.infotec.eworkplace.swb.Academia getAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Academia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return A com.infotec.eworkplace.swb.Academia
       */
        public static com.infotec.eworkplace.swb.Academia createAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Academia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       */
        public static void removeAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Academia
       * @param id Identifier for com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return true if the com.infotec.eworkplace.swb.Academia exists, false otherwise
       */

        public static boolean hasAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAcademia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Curso
       * @param value Curso of the type com.infotec.eworkplace.swb.Curso
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByCurso(com.infotec.eworkplace.swb.Curso value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_hasCurso, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Curso
       * @param value Curso of the type com.infotec.eworkplace.swb.Curso
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByCurso(com.infotec.eworkplace.swb.Curso value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_hasCurso,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Idioma
       * @param value Idioma of the type com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByIdioma(com.infotec.eworkplace.swb.Idioma value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_hasIdioma, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Idioma
       * @param value Idioma of the type com.infotec.eworkplace.swb.Idioma
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByIdioma(com.infotec.eworkplace.swb.Idioma value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_hasIdioma,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Certificacion
       * @param value Certificacion of the type com.infotec.eworkplace.swb.Certificacion
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByCertificacion(com.infotec.eworkplace.swb.Certificacion value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_hasCertificacion, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Certificacion
       * @param value Certificacion of the type com.infotec.eworkplace.swb.Certificacion
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByCertificacion(com.infotec.eworkplace.swb.Certificacion value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_hasCertificacion,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Diplomado
       * @param value Diplomado of the type com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByDiplomado(com.infotec.eworkplace.swb.Diplomado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_hasDiplomado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Academia with a determined Diplomado
       * @param value Diplomado of the type com.infotec.eworkplace.swb.Diplomado
       * @return Iterator with all the com.infotec.eworkplace.swb.Academia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Academia> listAcademiaByDiplomado(com.infotec.eworkplace.swb.Diplomado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_hasDiplomado,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a AcademiaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Academia
   */
    public AcademiaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Curso
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Curso
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Curso> listCursos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Curso>(getSemanticObject().listObjectProperties(ewp_hasCurso));
    }

   /**
   * Gets true if has a Curso
   * @param value com.infotec.eworkplace.swb.Curso to verify
   * @return true if the com.infotec.eworkplace.swb.Curso exists, false otherwise
   */
    public boolean hasCurso(com.infotec.eworkplace.swb.Curso value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ewp_hasCurso,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Curso
   * @param value com.infotec.eworkplace.swb.Curso to add
   */

    public void addCurso(com.infotec.eworkplace.swb.Curso value)
    {
        getSemanticObject().addObjectProperty(ewp_hasCurso, value.getSemanticObject());
    }
   /**
   * Removes all the Curso
   */

    public void removeAllCurso()
    {
        getSemanticObject().removeProperty(ewp_hasCurso);
    }
   /**
   * Removes a Curso
   * @param value com.infotec.eworkplace.swb.Curso to remove
   */

    public void removeCurso(com.infotec.eworkplace.swb.Curso value)
    {
        getSemanticObject().removeObjectProperty(ewp_hasCurso,value.getSemanticObject());
    }

   /**
   * Gets the Curso
   * @return a com.infotec.eworkplace.swb.Curso
   */
    public com.infotec.eworkplace.swb.Curso getCurso()
    {
         com.infotec.eworkplace.swb.Curso ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_hasCurso);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Curso)obj.createGenericInstance();
         }
         return ret;
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
   * Gets all the com.infotec.eworkplace.swb.Idioma
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Idioma
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> listIdiomas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(getSemanticObject().listObjectProperties(ewp_hasIdioma));
    }

   /**
   * Gets true if has a Idioma
   * @param value com.infotec.eworkplace.swb.Idioma to verify
   * @return true if the com.infotec.eworkplace.swb.Idioma exists, false otherwise
   */
    public boolean hasIdioma(com.infotec.eworkplace.swb.Idioma value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ewp_hasIdioma,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Idioma
   * @param value com.infotec.eworkplace.swb.Idioma to add
   */

    public void addIdioma(com.infotec.eworkplace.swb.Idioma value)
    {
        getSemanticObject().addObjectProperty(ewp_hasIdioma, value.getSemanticObject());
    }
   /**
   * Removes all the Idioma
   */

    public void removeAllIdioma()
    {
        getSemanticObject().removeProperty(ewp_hasIdioma);
    }
   /**
   * Removes a Idioma
   * @param value com.infotec.eworkplace.swb.Idioma to remove
   */

    public void removeIdioma(com.infotec.eworkplace.swb.Idioma value)
    {
        getSemanticObject().removeObjectProperty(ewp_hasIdioma,value.getSemanticObject());
    }

   /**
   * Gets the Idioma
   * @return a com.infotec.eworkplace.swb.Idioma
   */
    public com.infotec.eworkplace.swb.Idioma getIdioma()
    {
         com.infotec.eworkplace.swb.Idioma ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_hasIdioma);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Idioma)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Situacion property
* @return String with the Situacion
*/
    public String getSituacion()
    {
        return getSemanticObject().getProperty(ewp_situacion);
    }

/**
* Sets the Situacion property
* @param value long with the Situacion
*/
    public void setSituacion(String value)
    {
        getSemanticObject().setProperty(ewp_situacion, value);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Certificacion
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Certificacion
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Certificacion> listCertificacions()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Certificacion>(getSemanticObject().listObjectProperties(ewp_hasCertificacion));
    }

   /**
   * Gets true if has a Certificacion
   * @param value com.infotec.eworkplace.swb.Certificacion to verify
   * @return true if the com.infotec.eworkplace.swb.Certificacion exists, false otherwise
   */
    public boolean hasCertificacion(com.infotec.eworkplace.swb.Certificacion value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ewp_hasCertificacion,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Certificacion
   * @param value com.infotec.eworkplace.swb.Certificacion to add
   */

    public void addCertificacion(com.infotec.eworkplace.swb.Certificacion value)
    {
        getSemanticObject().addObjectProperty(ewp_hasCertificacion, value.getSemanticObject());
    }
   /**
   * Removes all the Certificacion
   */

    public void removeAllCertificacion()
    {
        getSemanticObject().removeProperty(ewp_hasCertificacion);
    }
   /**
   * Removes a Certificacion
   * @param value com.infotec.eworkplace.swb.Certificacion to remove
   */

    public void removeCertificacion(com.infotec.eworkplace.swb.Certificacion value)
    {
        getSemanticObject().removeObjectProperty(ewp_hasCertificacion,value.getSemanticObject());
    }

   /**
   * Gets the Certificacion
   * @return a com.infotec.eworkplace.swb.Certificacion
   */
    public com.infotec.eworkplace.swb.Certificacion getCertificacion()
    {
         com.infotec.eworkplace.swb.Certificacion ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_hasCertificacion);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Certificacion)obj.createGenericInstance();
         }
         return ret;
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
* Gets the Grado property
* @return String with the Grado
*/
    public String getGrado()
    {
        return getSemanticObject().getProperty(ewp_grado);
    }

/**
* Sets the Grado property
* @param value long with the Grado
*/
    public void setGrado(String value)
    {
        getSemanticObject().setProperty(ewp_grado, value);
    }

/**
* Gets the Carrera property
* @return String with the Carrera
*/
    public String getCarrera()
    {
        return getSemanticObject().getProperty(ewp_carrera);
    }

/**
* Sets the Carrera property
* @param value long with the Carrera
*/
    public void setCarrera(String value)
    {
        getSemanticObject().setProperty(ewp_carrera, value);
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
   /**
   * Gets all the com.infotec.eworkplace.swb.Diplomado
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Diplomado
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado> listDiplomados()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado>(getSemanticObject().listObjectProperties(ewp_hasDiplomado));
    }

   /**
   * Gets true if has a Diplomado
   * @param value com.infotec.eworkplace.swb.Diplomado to verify
   * @return true if the com.infotec.eworkplace.swb.Diplomado exists, false otherwise
   */
    public boolean hasDiplomado(com.infotec.eworkplace.swb.Diplomado value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ewp_hasDiplomado,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Diplomado
   * @param value com.infotec.eworkplace.swb.Diplomado to add
   */

    public void addDiplomado(com.infotec.eworkplace.swb.Diplomado value)
    {
        getSemanticObject().addObjectProperty(ewp_hasDiplomado, value.getSemanticObject());
    }
   /**
   * Removes all the Diplomado
   */

    public void removeAllDiplomado()
    {
        getSemanticObject().removeProperty(ewp_hasDiplomado);
    }
   /**
   * Removes a Diplomado
   * @param value com.infotec.eworkplace.swb.Diplomado to remove
   */

    public void removeDiplomado(com.infotec.eworkplace.swb.Diplomado value)
    {
        getSemanticObject().removeObjectProperty(ewp_hasDiplomado,value.getSemanticObject());
    }

   /**
   * Gets the Diplomado
   * @return a com.infotec.eworkplace.swb.Diplomado
   */
    public com.infotec.eworkplace.swb.Diplomado getDiplomado()
    {
         com.infotec.eworkplace.swb.Diplomado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_hasDiplomado);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Diplomado)obj.createGenericInstance();
         }
         return ret;
    }
}
