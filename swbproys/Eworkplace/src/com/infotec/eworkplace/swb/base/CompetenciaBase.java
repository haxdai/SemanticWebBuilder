package com.infotec.eworkplace.swb.base;


public abstract class CompetenciaBase extends org.semanticwb.model.SWBClass 
{
    public static final org.semanticwb.platform.SemanticClass ewp_Conocimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Conocimiento");
    public static final org.semanticwb.platform.SemanticProperty ewp_hasConocimiento=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasConocimiento");
    public static final org.semanticwb.platform.SemanticClass ewp_Habilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Habilidad");
    public static final org.semanticwb.platform.SemanticProperty ewp_hasHabilidad=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://infotec.com.mx/eworkplace#hasHabilidad");
    public static final org.semanticwb.platform.SemanticClass ewp_Competencia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Competencia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://infotec.com.mx/eworkplace#Competencia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Competencia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Competencia> listCompetencias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Competencia>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.Competencia for all models
       * @return Iterator of com.infotec.eworkplace.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Competencia> listCompetencias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Competencia>(it, true);
        }

        public static com.infotec.eworkplace.swb.Competencia createCompetencia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.Competencia.ClassMgr.createCompetencia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.Competencia
       * @param id Identifier for com.infotec.eworkplace.swb.Competencia
       * @param model Model of the com.infotec.eworkplace.swb.Competencia
       * @return A com.infotec.eworkplace.swb.Competencia
       */
        public static com.infotec.eworkplace.swb.Competencia getCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Competencia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.Competencia
       * @param id Identifier for com.infotec.eworkplace.swb.Competencia
       * @param model Model of the com.infotec.eworkplace.swb.Competencia
       * @return A com.infotec.eworkplace.swb.Competencia
       */
        public static com.infotec.eworkplace.swb.Competencia createCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.Competencia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.Competencia
       * @param id Identifier for com.infotec.eworkplace.swb.Competencia
       * @param model Model of the com.infotec.eworkplace.swb.Competencia
       */
        public static void removeCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.Competencia
       * @param id Identifier for com.infotec.eworkplace.swb.Competencia
       * @param model Model of the com.infotec.eworkplace.swb.Competencia
       * @return true if the com.infotec.eworkplace.swb.Competencia exists, false otherwise
       */

        public static boolean hasCompetencia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getCompetencia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Competencia with a determined Conocimiento
       * @param value Conocimiento of the type com.infotec.eworkplace.swb.Conocimiento
       * @param model Model of the com.infotec.eworkplace.swb.Competencia
       * @return Iterator with all the com.infotec.eworkplace.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Competencia> listCompetenciaByConocimiento(com.infotec.eworkplace.swb.Conocimiento value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Competencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_hasConocimiento, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Competencia with a determined Conocimiento
       * @param value Conocimiento of the type com.infotec.eworkplace.swb.Conocimiento
       * @return Iterator with all the com.infotec.eworkplace.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Competencia> listCompetenciaByConocimiento(com.infotec.eworkplace.swb.Conocimiento value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Competencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_hasConocimiento,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Competencia with a determined Habilidad
       * @param value Habilidad of the type com.infotec.eworkplace.swb.Habilidad
       * @param model Model of the com.infotec.eworkplace.swb.Competencia
       * @return Iterator with all the com.infotec.eworkplace.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Competencia> listCompetenciaByHabilidad(com.infotec.eworkplace.swb.Habilidad value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Competencia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(ewp_hasHabilidad, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.Competencia with a determined Habilidad
       * @param value Habilidad of the type com.infotec.eworkplace.swb.Habilidad
       * @return Iterator with all the com.infotec.eworkplace.swb.Competencia
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.Competencia> listCompetenciaByHabilidad(com.infotec.eworkplace.swb.Habilidad value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Competencia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(ewp_hasHabilidad,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a CompetenciaBase with a SemanticObject
   * @param base The SemanticObject with the properties for the Competencia
   */
    public CompetenciaBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Conocimiento
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Conocimiento
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conocimiento> listConocimientos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Conocimiento>(getSemanticObject().listObjectProperties(ewp_hasConocimiento));
    }

   /**
   * Gets true if has a Conocimiento
   * @param value com.infotec.eworkplace.swb.Conocimiento to verify
   * @return true if the com.infotec.eworkplace.swb.Conocimiento exists, false otherwise
   */
    public boolean hasConocimiento(com.infotec.eworkplace.swb.Conocimiento value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ewp_hasConocimiento,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Conocimiento
   * @param value com.infotec.eworkplace.swb.Conocimiento to add
   */

    public void addConocimiento(com.infotec.eworkplace.swb.Conocimiento value)
    {
        getSemanticObject().addObjectProperty(ewp_hasConocimiento, value.getSemanticObject());
    }
   /**
   * Removes all the Conocimiento
   */

    public void removeAllConocimiento()
    {
        getSemanticObject().removeProperty(ewp_hasConocimiento);
    }
   /**
   * Removes a Conocimiento
   * @param value com.infotec.eworkplace.swb.Conocimiento to remove
   */

    public void removeConocimiento(com.infotec.eworkplace.swb.Conocimiento value)
    {
        getSemanticObject().removeObjectProperty(ewp_hasConocimiento,value.getSemanticObject());
    }

   /**
   * Gets the Conocimiento
   * @return a com.infotec.eworkplace.swb.Conocimiento
   */
    public com.infotec.eworkplace.swb.Conocimiento getConocimiento()
    {
         com.infotec.eworkplace.swb.Conocimiento ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_hasConocimiento);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Conocimiento)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Gets all the com.infotec.eworkplace.swb.Habilidad
   * @return A GenericIterator with all the com.infotec.eworkplace.swb.Habilidad
   */

    public org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidad> listHabilidads()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.Habilidad>(getSemanticObject().listObjectProperties(ewp_hasHabilidad));
    }

   /**
   * Gets true if has a Habilidad
   * @param value com.infotec.eworkplace.swb.Habilidad to verify
   * @return true if the com.infotec.eworkplace.swb.Habilidad exists, false otherwise
   */
    public boolean hasHabilidad(com.infotec.eworkplace.swb.Habilidad value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(ewp_hasHabilidad,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a Habilidad
   * @param value com.infotec.eworkplace.swb.Habilidad to add
   */

    public void addHabilidad(com.infotec.eworkplace.swb.Habilidad value)
    {
        getSemanticObject().addObjectProperty(ewp_hasHabilidad, value.getSemanticObject());
    }
   /**
   * Removes all the Habilidad
   */

    public void removeAllHabilidad()
    {
        getSemanticObject().removeProperty(ewp_hasHabilidad);
    }
   /**
   * Removes a Habilidad
   * @param value com.infotec.eworkplace.swb.Habilidad to remove
   */

    public void removeHabilidad(com.infotec.eworkplace.swb.Habilidad value)
    {
        getSemanticObject().removeObjectProperty(ewp_hasHabilidad,value.getSemanticObject());
    }

   /**
   * Gets the Habilidad
   * @return a com.infotec.eworkplace.swb.Habilidad
   */
    public com.infotec.eworkplace.swb.Habilidad getHabilidad()
    {
         com.infotec.eworkplace.swb.Habilidad ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(ewp_hasHabilidad);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Habilidad)obj.createGenericInstance();
         }
         return ret;
    }
}
