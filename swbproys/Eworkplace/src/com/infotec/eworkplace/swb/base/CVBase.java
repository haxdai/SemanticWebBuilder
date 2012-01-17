package com.infotec.eworkplace.swb.base;


public abstract class CVBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass intranet_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");
    public static final org.semanticwb.platform.SemanticProperty intranet_academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#academia");
    public static final org.semanticwb.platform.SemanticClass intranet_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#competencia");
    public static final org.semanticwb.platform.SemanticProperty intranet_actualizacion=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#actualizacion");
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
