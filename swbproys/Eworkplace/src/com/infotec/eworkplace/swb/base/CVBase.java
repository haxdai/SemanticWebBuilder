package com.infotec.eworkplace.swb.base;


public abstract class CVBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ewp_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Academia");
    public static final org.semanticwb.platform.SemanticProperty ewp_academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#academia");
    public static final org.semanticwb.platform.SemanticClass ewp_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Competencia");
    public static final org.semanticwb.platform.SemanticProperty ewp_competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#competencia");
   /**
   * Fecha de la última actualización
   */
    public static final org.semanticwb.platform.SemanticProperty ewp_actualizacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#actualizacion");
    public static final org.semanticwb.platform.SemanticClass ewp_Persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Persona");
    public static final org.semanticwb.platform.SemanticProperty ewp_persona=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#persona");
    public static final org.semanticwb.platform.SemanticClass ewp_CV=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#CV");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#CV");

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
       * Gets all com.infotec.eworkplace.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.eworkplace.swb.Academia
       * @param model Model of the com.infotec.eworkplace.swb.CV
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAcademia(com.infotec.eworkplace.swb.Academia value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_academia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Academia
       * @param value Academia of the type com.infotec.eworkplace.swb.Academia
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByAcademia(com.infotec.eworkplace.swb.Academia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_academia,value.getSemanticObject(),sclass));
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
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_competencia, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Competencia
       * @param value Competencia of the type com.infotec.eworkplace.swb.Competencia
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByCompetencia(com.infotec.eworkplace.swb.Competencia value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_competencia,value.getSemanticObject(),sclass));
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
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_persona, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.CV with a determined Persona
       * @param value Persona of the type com.infotec.eworkplace.swb.Persona
       * @return Iterator with all the com.infotec.eworkplace.swb.CV
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.CV> listCVByPersona(com.infotec.eworkplace.swb.Persona value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.CV> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_persona,value.getSemanticObject(),sclass));
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
   * Sets the value for the property Academia
   * @param value Academia to set
   */

    public void setAcademia(com.infotec.eworkplace.swb.Academia value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_academia, value.getSemanticObject());
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
        getSemanticObject().removeProperty(ewp_academia);
    }

   /**
   * Gets the Academia
   * @return a com.infotec.eworkplace.swb.Academia
   */
    public com.infotec.eworkplace.swb.Academia getAcademia()
    {
         com.infotec.eworkplace.swb.Academia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_academia);
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
            getSemanticObject().setObjectProperty(ewp_competencia, value.getSemanticObject());
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
        getSemanticObject().removeProperty(ewp_competencia);
    }

   /**
   * Gets the Competencia
   * @return a com.infotec.eworkplace.swb.Competencia
   */
    public com.infotec.eworkplace.swb.Competencia getCompetencia()
    {
         com.infotec.eworkplace.swb.Competencia ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_competencia);
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
        return getSemanticObject().getDateProperty(ewp_actualizacion);
    }

/**
* Sets the Actualizacion property
* @param value long with the Actualizacion
*/
    public void setActualizacion(java.util.Date value)
    {
        getSemanticObject().setDateProperty(ewp_actualizacion, value);
    }
   /**
   * Sets the value for the property Persona
   * @param value Persona to set
   */

    public void setPersona(com.infotec.eworkplace.swb.Persona value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(ewp_persona, value.getSemanticObject());
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
        getSemanticObject().removeProperty(ewp_persona);
    }

   /**
   * Gets the Persona
   * @return a com.infotec.eworkplace.swb.Persona
   */
    public com.infotec.eworkplace.swb.Persona getPersona()
    {
         com.infotec.eworkplace.swb.Persona ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_persona);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Persona)obj.createGenericInstance();
         }
         return ret;
    }
}
