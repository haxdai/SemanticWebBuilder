package com.infotec.cvi.swb.base;


   /**
   * Elemento que almacena el Estudio Superior de la persona 
   */
public abstract class EstudioSuperiorBase extends org.semanticwb.model.SWBClass implements com.infotec.cvi.swb.Periodo
{
   /**
   * Catálogo utilizado para indicar el grado de avance del Estudio
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Avance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Avance");
    public static final org.semanticwb.platform.SemanticProperty intranet_gradoAvance=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#gradoAvance");
    public static final org.semanticwb.platform.SemanticProperty intranet_otroEstudio=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#otroEstudio");
   /**
   * Catálogo utilizado para almacenar los diferentes Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Estudios=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Estudios");
    public static final org.semanticwb.platform.SemanticProperty intranet_estudiosSuperiores=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#estudiosSuperiores");
   /**
   * Elemento que almacena el Estudio Superior de la persona
   */
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
       * @return Iterator of com.infotec.cvi.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EstudioSuperior> listEstudioSuperiors(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.EstudioSuperior for all models
       * @return Iterator of com.infotec.cvi.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EstudioSuperior> listEstudioSuperiors()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior>(it, true);
        }

        public static com.infotec.cvi.swb.EstudioSuperior createEstudioSuperior(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.EstudioSuperior.ClassMgr.createEstudioSuperior(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.EstudioSuperior
       * @param id Identifier for com.infotec.cvi.swb.EstudioSuperior
       * @param model Model of the com.infotec.cvi.swb.EstudioSuperior
       * @return A com.infotec.cvi.swb.EstudioSuperior
       */
        public static com.infotec.cvi.swb.EstudioSuperior getEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.EstudioSuperior)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.EstudioSuperior
       * @param id Identifier for com.infotec.cvi.swb.EstudioSuperior
       * @param model Model of the com.infotec.cvi.swb.EstudioSuperior
       * @return A com.infotec.cvi.swb.EstudioSuperior
       */
        public static com.infotec.cvi.swb.EstudioSuperior createEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.EstudioSuperior)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.EstudioSuperior
       * @param id Identifier for com.infotec.cvi.swb.EstudioSuperior
       * @param model Model of the com.infotec.cvi.swb.EstudioSuperior
       */
        public static void removeEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.EstudioSuperior
       * @param id Identifier for com.infotec.cvi.swb.EstudioSuperior
       * @param model Model of the com.infotec.cvi.swb.EstudioSuperior
       * @return true if the com.infotec.cvi.swb.EstudioSuperior exists, false otherwise
       */

        public static boolean hasEstudioSuperior(String id, org.semanticwb.model.SWBModel model)
        {
            return (getEstudioSuperior(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.EstudioSuperior with a determined GradoAvance
       * @param value GradoAvance of the type com.infotec.cvi.swb.Avance
       * @param model Model of the com.infotec.cvi.swb.EstudioSuperior
       * @return Iterator with all the com.infotec.cvi.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EstudioSuperior> listEstudioSuperiorByGradoAvance(com.infotec.cvi.swb.Avance value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_gradoAvance, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EstudioSuperior with a determined GradoAvance
       * @param value GradoAvance of the type com.infotec.cvi.swb.Avance
       * @return Iterator with all the com.infotec.cvi.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EstudioSuperior> listEstudioSuperiorByGradoAvance(com.infotec.cvi.swb.Avance value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_gradoAvance,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EstudioSuperior with a determined EstudiosSuperiores
       * @param value EstudiosSuperiores of the type com.infotec.cvi.swb.Estudios
       * @param model Model of the com.infotec.cvi.swb.EstudioSuperior
       * @return Iterator with all the com.infotec.cvi.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EstudioSuperior> listEstudioSuperiorByEstudiosSuperiores(com.infotec.cvi.swb.Estudios value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_estudiosSuperiores, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.EstudioSuperior with a determined EstudiosSuperiores
       * @param value EstudiosSuperiores of the type com.infotec.cvi.swb.Estudios
       * @return Iterator with all the com.infotec.cvi.swb.EstudioSuperior
       */

        public static java.util.Iterator<com.infotec.cvi.swb.EstudioSuperior> listEstudioSuperiorByEstudiosSuperiores(com.infotec.cvi.swb.Estudios value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_estudiosSuperiores,value.getSemanticObject(),sclass));
            return it;
        }
    }

    public static EstudioSuperiorBase.ClassMgr getEstudioSuperiorClassMgr()
    {
        return new EstudioSuperiorBase.ClassMgr();
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

    public void setGradoAvance(com.infotec.cvi.swb.Avance value)
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
   * @return a com.infotec.cvi.swb.Avance
   */
    public com.infotec.cvi.swb.Avance getGradoAvance()
    {
         com.infotec.cvi.swb.Avance ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_gradoAvance);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Avance)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the OtroEstudio property
* @return String with the OtroEstudio
*/
    public String getOtroEstudio()
    {
        return getSemanticObject().getProperty(intranet_otroEstudio);
    }

/**
* Sets the OtroEstudio property
* @param value long with the OtroEstudio
*/
    public void setOtroEstudio(String value)
    {
        getSemanticObject().setProperty(intranet_otroEstudio, value);
    }
   /**
   * Sets the value for the property EstudiosSuperiores
   * @param value EstudiosSuperiores to set
   */

    public void setEstudiosSuperiores(com.infotec.cvi.swb.Estudios value)
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
   * @return a com.infotec.cvi.swb.Estudios
   */
    public com.infotec.cvi.swb.Estudios getEstudiosSuperiores()
    {
         com.infotec.cvi.swb.Estudios ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_estudiosSuperiores);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.Estudios)obj.createGenericInstance();
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
