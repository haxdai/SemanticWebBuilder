package com.infotec.eworkplace.swb.base;


public abstract class EstudioSuperiorBase extends org.semanticwb.model.SWBClass implements com.infotec.eworkplace.swb.Periodo
{
    public static final org.semanticwb.platform.SemanticClass intranet_Avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Avance");
    public static final org.semanticwb.platform.SemanticProperty intranet_gradoAvance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#gradoAvance");
    public static final org.semanticwb.platform.SemanticClass intranet_Estudios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estudios");
    public static final org.semanticwb.platform.SemanticProperty intranet_estudiosSuperiores=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#estudiosSuperiores");
    public static final org.semanticwb.platform.SemanticClass intranet_EstudioSuperior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EstudioSuperior");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EstudioSuperior");

    public static class ClassMgr
    {
       /**
       * Returns a list of EstudioSuperior for a model
       * @param model Model to find
       * @return Iterator of com.infotec.eworkplace.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EstudioSuperior> listEstudioSuperiors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior>(it, true);
        }
       /**
       * Returns a list of com.infotec.eworkplace.swb.EstudioSuperior for all models
       * @return Iterator of com.infotec.eworkplace.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EstudioSuperior> listEstudioSuperiors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior>(it, true);
        }

        public static com.infotec.eworkplace.swb.EstudioSuperior createEstudioSuperior(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.eworkplace.swb.EstudioSuperior.ClassMgr.createEstudioSuperior(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.eworkplace.swb.EstudioSuperior
       * @param id Identifier for com.infotec.eworkplace.swb.EstudioSuperior
       * @param model Model of the com.infotec.eworkplace.swb.EstudioSuperior
       * @return A com.infotec.eworkplace.swb.EstudioSuperior
       */
        public static com.infotec.eworkplace.swb.EstudioSuperior getEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EstudioSuperior)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.eworkplace.swb.EstudioSuperior
       * @param id Identifier for com.infotec.eworkplace.swb.EstudioSuperior
       * @param model Model of the com.infotec.eworkplace.swb.EstudioSuperior
       * @return A com.infotec.eworkplace.swb.EstudioSuperior
       */
        public static com.infotec.eworkplace.swb.EstudioSuperior createEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.eworkplace.swb.EstudioSuperior)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.eworkplace.swb.EstudioSuperior
       * @param id Identifier for com.infotec.eworkplace.swb.EstudioSuperior
       * @param model Model of the com.infotec.eworkplace.swb.EstudioSuperior
       */
        public static void removeEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.eworkplace.swb.EstudioSuperior
       * @param id Identifier for com.infotec.eworkplace.swb.EstudioSuperior
       * @param model Model of the com.infotec.eworkplace.swb.EstudioSuperior
       * @return true if the com.infotec.eworkplace.swb.EstudioSuperior exists, false otherwise
       */

        public static boolean hasEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEstudioSuperior(id, model)!=null);
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EstudioSuperior with a determined GradoAvance
       * @param value GradoAvance of the type com.infotec.eworkplace.swb.Avance
       * @param model Model of the com.infotec.eworkplace.swb.EstudioSuperior
       * @return Iterator with all the com.infotec.eworkplace.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EstudioSuperior> listEstudioSuperiorByGradoAvance(com.infotec.eworkplace.swb.Avance value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_gradoAvance, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EstudioSuperior with a determined GradoAvance
       * @param value GradoAvance of the type com.infotec.eworkplace.swb.Avance
       * @return Iterator with all the com.infotec.eworkplace.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EstudioSuperior> listEstudioSuperiorByGradoAvance(com.infotec.eworkplace.swb.Avance value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_gradoAvance,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EstudioSuperior with a determined EstudiosSuperiores
       * @param value EstudiosSuperiores of the type com.infotec.eworkplace.swb.Estudios
       * @param model Model of the com.infotec.eworkplace.swb.EstudioSuperior
       * @return Iterator with all the com.infotec.eworkplace.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EstudioSuperior> listEstudioSuperiorByEstudiosSuperiores(com.infotec.eworkplace.swb.Estudios value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_estudiosSuperiores, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.eworkplace.swb.EstudioSuperior with a determined EstudiosSuperiores
       * @param value EstudiosSuperiores of the type com.infotec.eworkplace.swb.Estudios
       * @return Iterator with all the com.infotec.eworkplace.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.eworkplace.swb.EstudioSuperior> listEstudioSuperiorByEstudiosSuperiores(com.infotec.eworkplace.swb.Estudios value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.eworkplace.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_estudiosSuperiores,value.getSemanticObject(),sclass));
            return it;
        }
    }

   /**
   * Constructs a EstudioSuperiorBase with a SemanticObject
   * @param base The SemanticObject with the properties for the EstudioSuperior
   */
    public EstudioSuperiorBase(org.semanticwb.platform.SemanticObject base)
    {
        super(base);
    }
   /**
   * Sets the value for the property GradoAvance
   * @param value GradoAvance to set
   */

    public void setGradoAvance(com.infotec.eworkplace.swb.Avance value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_gradoAvance, value.getSemanticObject());
        }else
        {
            removeGradoAvance();
        }
    }
   /**
   * Remove the value for GradoAvance property
   */

    public void removeGradoAvance()
    {
        getSemanticObject().removeProperty(intranet_gradoAvance);
    }

   /**
   * Gets the GradoAvance
   * @return a com.infotec.eworkplace.swb.Avance
   */
    public com.infotec.eworkplace.swb.Avance getGradoAvance()
    {
         com.infotec.eworkplace.swb.Avance ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_gradoAvance);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Avance)obj.createGenericInstance();
         }
         return ret;
    }
   /**
   * Sets the value for the property EstudiosSuperiores
   * @param value EstudiosSuperiores to set
   */

    public void setEstudiosSuperiores(com.infotec.eworkplace.swb.Estudios value)
    {
        if(value!=null)
        {
            getSemanticObject().setObjectProperty(intranet_estudiosSuperiores, value.getSemanticObject());
        }else
        {
            removeEstudiosSuperiores();
        }
    }
   /**
   * Remove the value for EstudiosSuperiores property
   */

    public void removeEstudiosSuperiores()
    {
        getSemanticObject().removeProperty(intranet_estudiosSuperiores);
    }

   /**
   * Gets the EstudiosSuperiores
   * @return a com.infotec.eworkplace.swb.Estudios
   */
    public com.infotec.eworkplace.swb.Estudios getEstudiosSuperiores()
    {
         com.infotec.eworkplace.swb.Estudios ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_estudiosSuperiores);
         if(obj!=null)
         {
             ret=(com.infotec.eworkplace.swb.Estudios)obj.createGenericInstance();
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
}
