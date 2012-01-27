package com.infotec.eworkplace.swb.base;


public abstract class CVBase extends org.semanticwb.model.SWBClass implements org.semanticwb.model.Traceable
{
    public static final org.semanticwb.platform.SemanticClass intranet_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");
    public static final org.semanticwb.platform.SemanticProperty intranet_academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#academia");
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_actualizacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#actualizacion");
    public static final org.semanticwb.platform.SemanticClass intranet_CursoTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CursoTIC");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasCursosTIC=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasCursosTIC");
    public static final org.semanticwb.platform.SemanticClass intranet_Idioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Idioma");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasIdioma=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasIdioma");
    public static final org.semanticwb.platform.SemanticClass intranet_ExperienciaProfesional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#ExperienciaProfesional");
    public static final org.semanticwb.platform.SemanticProperty intranet_experienciaProfesional=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#experienciaProfesional");
    public static final org.semanticwb.platform.SemanticClass intranet_Diplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Diplomado");
    public static final org.semanticwb.platform.SemanticProperty intranet_hasDiplomado=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasDiplomado");
   /**
   * Un usuario es una persona que tiene relación con el portal a través de un método de acceso.
   */
    public static final org.semanticwb.platform.SemanticClass swb_User=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.semanticwebbuilder.org/swb4/ontology#User");
    public static final org.semanticwb.platform.SemanticProperty intranet_propietario=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#propietario");
    public static final org.semanticwb.platform.SemanticClass intranet_Persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Persona");
    public static final org.semanticwb.platform.SemanticProperty intranet_persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#persona");
    public static final org.semanticwb.platform.SemanticClass intranet_CV=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CV");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#CV");

    public static class ClassMgr
    {
       /**
       * Returns a list of CV for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVs(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.CV for all models
       * @return Iterator of com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVs()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV>(it, true);
        }

        public static com.infotec.eworkplace.swb.CV createCV(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.CV.ClassMgr.createCV(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return A com.infotec.eworkplace.swb.CV
       */
        public static com.infotec.eworkplace.swb.CV getCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CV)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return A com.infotec.eworkplace.swb.CV
       */
        public static com.infotec.eworkplace.swb.CV createCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.CV)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       */
        public static void removeCV(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.CV
       * @param id Identifier for com.infotec.eworkplace.swb.CV
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return true if the com.infotec.eworkplace.swb.CV exists, false otherwise
       */

        public static boolean hasCV(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCV(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByModifiedBy(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ModifiedBy
       * @param value ModifiedBy of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByModifiedBy(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_modifiedBy,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAcademia(com.infotec.eworkplace.swb.Academia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_academia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAcademia(com.infotec.eworkplace.swb.Academia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_academia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Competencia
       * @param value Competencia of the type com.infotec.eworkplace.swb.Competencia
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCompetencia(com.infotec.eworkplace.swb.Competencia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_competencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Competencia
       * @param value Competencia of the type com.infotec.eworkplace.swb.Competencia
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCompetencia(com.infotec.eworkplace.swb.Competencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_competencia,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined CursosTIC
       * @param value CursosTIC of the type com.infotec.eworkplace.swb.CursoTIC
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCursosTIC(com.infotec.eworkplace.swb.CursoTIC value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCursosTIC, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined CursosTIC
       * @param value CursosTIC of the type com.infotec.eworkplace.swb.CursoTIC
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasCursosTIC,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Idioma
       * @param value Idioma of the type com.infotec.eworkplace.swb.Idioma
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByIdioma(com.infotec.eworkplace.swb.Idioma value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasIdioma, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Idioma
       * @param value Idioma of the type com.infotec.eworkplace.swb.Idioma
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByIdioma(com.infotec.eworkplace.swb.Idioma value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasIdioma,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCreator(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(swb_creator, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Creator
       * @param value Creator of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCreator(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(swb_creator,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ExperienciaProfesional
       * @param value ExperienciaProfesional of the type com.infotec.eworkplace.swb.ExperienciaProfesional
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByExperienciaProfesional(com.infotec.eworkplace.swb.ExperienciaProfesional value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_experienciaProfesional, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined ExperienciaProfesional
       * @param value ExperienciaProfesional of the type com.infotec.eworkplace.swb.ExperienciaProfesional
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByExperienciaProfesional(com.infotec.eworkplace.swb.ExperienciaProfesional value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_experienciaProfesional,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Diplomado
       * @param value Diplomado of the type com.infotec.eworkplace.swb.Diplomado
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDiplomado(com.infotec.eworkplace.swb.Diplomado value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDiplomado, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Diplomado
       * @param value Diplomado of the type com.infotec.eworkplace.swb.Diplomado
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByDiplomado(com.infotec.eworkplace.swb.Diplomado value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasDiplomado,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Propietario
       * @param value Propietario of the type org.semanticwb.model.User
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPropietario(org.semanticwb.model.User value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_propietario, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Propietario
       * @param value Propietario of the type org.semanticwb.model.User
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPropietario(org.semanticwb.model.User value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_propietario,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Persona
       * @param value Persona of the type com.infotec.eworkplace.swb.Persona
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPersona(com.infotec.eworkplace.swb.Persona value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_persona, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Persona
       * @param value Persona of the type com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPersona(com.infotec.eworkplace.swb.Persona value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_persona,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CVBase with a SemanticObject
   * @param base The SemanticObject with the properties for the CV
   */
    public CVBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property ModifiedBy
   * @param value ModifiedBy to set
   */

    public void setModifiedBy(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_modifiedBy, value.getSemanticObject());
        }else
        {
            removeModifiedBy();
        }
    }
   /**
   * Remove the value for ModifiedBy property
   */

    public void removeModifiedBy()
    {
        getSemanticObject().removeProperty(swb_modifiedBy);
    }

   /**
   * Gets the ModifiedBy
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getModifiedBy()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_modifiedBy);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Academia
   * @param value Academia to set
   */

    public void setAcademia(com.infotec.eworkplace.swb.Academia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_academia, value.getSemanticObject());
        }else
        {
            removeAcademia();
        }
    }
   /**
   * Remove the value for Academia property
   */

    public void removeAcademia()
    {
        getSemanticObject().removeProperty(intranet_academia);
    }

   /**
   * Gets the Academia
   * @return a com.infotec.eworkplace.swb.Academia
   */
    public com.infotec.eworkplace.swb.Academia getAcademia()
    {
         com.infotec.eworkplace.swb.Academia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_academia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Academia)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Competencia
   * @param value Competencia to set
   */

    public void setCompetencia(com.infotec.eworkplace.swb.Competencia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_competencia, value.getSemanticObject());
        }else
        {
            removeCompetencia();
        }
    }
   /**
   * Remove the value for Competencia property
   */

    public void removeCompetencia()
    {
        getSemanticObject().removeProperty(intranet_competencia);
    }

   /**
   * Gets the Competencia
   * @return a com.infotec.eworkplace.swb.Competencia
   */
    public com.infotec.eworkplace.swb.Competencia getCompetencia()
    {
         com.infotec.eworkplace.swb.Competencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_competencia);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Competencia)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Actualizacion property
* @return java.util.Date with the Actualizacion
*/
    public java.util.Date getActualizacion()
    {
        return getSemanticObject().getDateProperty(intranet_actualizacion);
    }

/**
* Sets the Actualizacion property
* @param value long with the Actualizacion
*/
    public void setActualizacion(java.util.Date value)
    {
        getSemanticObject().setDateProperty(intranet_actualizacion, value);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.CursoTIC
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.CursoTIC
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CursoTIC> listCursosTICs()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CursoTIC>(getSemanticObject().listObjectProperties(intranet_hasCursosTIC));
    }

   /**
   * Gets true if has a CursosTIC
   * @param value com.infotec.eworkplace.swb.CursoTIC to verify
   * @return true if the com.infotec.eworkplace.swb.CursoTIC exists, false otherwise
   */
    public boolean hasCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasCursosTIC,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a CursosTIC
   * @param value com.infotec.eworkplace.swb.CursoTIC to add
   */

    public void addCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
    {
        getSemanticObject().addObjectProperty(intranet_hasCursosTIC, value.getSemanticObject());
    }
   /**
   * Removes all the CursosTIC
   */

    public void removeAllCursosTIC()
    {
        getSemanticObject().removeProperty(intranet_hasCursosTIC);
    }
   /**
   * Removes a CursosTIC
   * @param value com.infotec.eworkplace.swb.CursoTIC to remove
   */

    public void removeCursosTIC(com.infotec.eworkplace.swb.CursoTIC value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasCursosTIC,value.getSemanticObject());
    }

   /**
   * Gets the CursosTIC
   * @return a com.infotec.eworkplace.swb.CursoTIC
   */
    public com.infotec.eworkplace.swb.CursoTIC getCursosTIC()
    {
         com.infotec.eworkplace.swb.CursoTIC ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasCursosTIC);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.CursoTIC)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the Updated property
* @return java.util.Date with the Updated
*/
    public java.util.Date getUpdated()
    {
        return getSemanticObject().getDateProperty(swb_updated);
    }

/**
* Sets the Updated property
* @param value long with the Updated
*/
    public void setUpdated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_updated, value);
    }

/**
* Gets the Created property
* @return java.util.Date with the Created
*/
    public java.util.Date getCreated()
    {
        return getSemanticObject().getDateProperty(swb_created);
    }

/**
* Sets the Created property
* @param value long with the Created
*/
    public void setCreated(java.util.Date value)
    {
        getSemanticObject().setDateProperty(swb_created, value);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Idioma
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Idioma
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma> listIdiomas()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Idioma>(getSemanticObject().listObjectProperties(intranet_hasIdioma));
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
           ret=getSemanticObject().hasObjectProperty(intranet_hasIdioma,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Idioma
   * @param value com.infotec.eworkplace.swb.Idioma to add
   */

    public void addIdioma(com.infotec.eworkplace.swb.Idioma value)
    {
        getSemanticObject().addObjectProperty(intranet_hasIdioma, value.getSemanticObject());
    }
   /**
   * Removes all the Idioma
   */

    public void removeAllIdioma()
    {
        getSemanticObject().removeProperty(intranet_hasIdioma);
    }
   /**
   * Removes a Idioma
   * @param value com.infotec.eworkplace.swb.Idioma to remove
   */

    public void removeIdioma(com.infotec.eworkplace.swb.Idioma value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasIdioma,value.getSemanticObject());
    }

   /**
   * Gets the Idioma
   * @return a com.infotec.eworkplace.swb.Idioma
   */
    public com.infotec.eworkplace.swb.Idioma getIdioma()
    {
         com.infotec.eworkplace.swb.Idioma ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasIdioma);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Idioma)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Creator
   * @param value Creator to set
   */

    public void setCreator(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(swb_creator, value.getSemanticObject());
        }else
        {
            removeCreator();
        }
    }
   /**
   * Remove the value for Creator property
   */

    public void removeCreator()
    {
        getSemanticObject().removeProperty(swb_creator);
    }

   /**
   * Gets the Creator
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getCreator()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(swb_creator);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property ExperienciaProfesional
   * @param value ExperienciaProfesional to set
   */

    public void setExperienciaProfesional(com.infotec.eworkplace.swb.ExperienciaProfesional value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_experienciaProfesional, value.getSemanticObject());
        }else
        {
            removeExperienciaProfesional();
        }
    }
   /**
   * Remove the value for ExperienciaProfesional property
   */

    public void removeExperienciaProfesional()
    {
        getSemanticObject().removeProperty(intranet_experienciaProfesional);
    }

   /**
   * Gets the ExperienciaProfesional
   * @return a com.infotec.eworkplace.swb.ExperienciaProfesional
   */
    public com.infotec.eworkplace.swb.ExperienciaProfesional getExperienciaProfesional()
    {
         com.infotec.eworkplace.swb.ExperienciaProfesional ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_experienciaProfesional);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.ExperienciaProfesional)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Diplomado
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Diplomado
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado> listDiplomados()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Diplomado>(getSemanticObject().listObjectProperties(intranet_hasDiplomado));
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
           ret=getSemanticObject().hasObjectProperty(intranet_hasDiplomado,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Diplomado
   * @param value com.infotec.eworkplace.swb.Diplomado to add
   */

    public void addDiplomado(com.infotec.eworkplace.swb.Diplomado value)
    {
        getSemanticObject().addObjectProperty(intranet_hasDiplomado, value.getSemanticObject());
    }
   /**
   * Removes all the Diplomado
   */

    public void removeAllDiplomado()
    {
        getSemanticObject().removeProperty(intranet_hasDiplomado);
    }
   /**
   * Removes a Diplomado
   * @param value com.infotec.eworkplace.swb.Diplomado to remove
   */

    public void removeDiplomado(com.infotec.eworkplace.swb.Diplomado value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasDiplomado,value.getSemanticObject());
    }

   /**
   * Gets the Diplomado
   * @return a com.infotec.eworkplace.swb.Diplomado
   */
    public com.infotec.eworkplace.swb.Diplomado getDiplomado()
    {
         com.infotec.eworkplace.swb.Diplomado ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasDiplomado);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Diplomado)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Propietario
   * @param value Propietario to set
   */

    public void setPropietario(org.semanticwb.model.User value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_propietario, value.getSemanticObject());
        }else
        {
            removePropietario();
        }
    }
   /**
   * Remove the value for Propietario property
   */

    public void removePropietario()
    {
        getSemanticObject().removeProperty(intranet_propietario);
    }

   /**
   * Gets the Propietario
   * @return a org.semanticwb.model.User
   */
    public org.semanticwb.model.User getPropietario()
    {
         org.semanticwb.model.User ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_propietario);
         if(obj!=null)
         {
             ret=(org.semanticwb.model.User)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property Persona
   * @param value Persona to set
   */

    public void setPersona(com.infotec.eworkplace.swb.Persona value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_persona, value.getSemanticObject());
        }else
        {
            removePersona();
        }
    }
   /**
   * Remove the value for Persona property
   */

    public void removePersona()
    {
        getSemanticObject().removeProperty(intranet_persona);
    }

   /**
   * Gets the Persona
   * @return a com.infotec.eworkplace.swb.Persona
   */
    public com.infotec.eworkplace.swb.Persona getPersona()
    {
         com.infotec.eworkplace.swb.Persona ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_persona);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Persona)obj.createGenericInstance();
         }
         return ret;
    }
}
