package com.infotec.cvi.swb.base;


   /**
   * Elemento para agrupar los Estudios como Grado Académico, Estudios Superiores asociados a la persona 
   */
public abstract class AcademiaBase extends org.semanticwb.model.SWBClass 
{
   /**
   * Elemento que almacena la información del Grado Académico de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_GradoAcademico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#GradoAcademico");
   /**
   * Lista de Grados Académicos asociados a la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasGradoAcademico=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasGradoAcademico");
   /**
   * Indicador si aplica o no Estudios Superiores
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_noAplicaEstudioSuperior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#noAplicaEstudioSuperior");
   /**
   * Elemento que almacena el Estudio Superior de la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_EstudioSuperior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#EstudioSuperior");
   /**
   * Lista de Estudios Superiores existentes de la persona
   */
    public static final org.semanticwb.platform.SemanticProperty intranet_hasEstudioSuperior=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticProperty("http://www.infotec.com.mx/intranet#hasEstudioSuperior");
   /**
   * Elemento para agrupar los Estudios como Grado Académico, Estudios Superiores asociados a la persona
   */
    public static final org.semanticwb.platform.SemanticClass intranet_Academia=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");
   /**
   * The semantic class that represents the currentObject
   */
    public static final org.semanticwb.platform.SemanticClass sclass=org.semanticwb.SWBPlatform.getSemanticMgr().getVocabulary().getSemanticClass("http://www.infotec.com.mx/intranet#Academia");

    public static class ClassMgr
    {
       /**
       * Returns a list of Academia for a model
       * @param model Model to find
       * @return Iterator of com.infotec.cvi.swb.Academia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Academia> listAcademias(org.semanticwb.model.SWBModel model)
        {
            java.util.Iterator it=model.getSemanticObject().getModel().listInstancesOfClass(sclass);
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Academia>(it, true);
        }
       /**
       * Returns a list of com.infotec.cvi.swb.Academia for all models
       * @return Iterator of com.infotec.cvi.swb.Academia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Academia> listAcademias()
        {
            java.util.Iterator it=sclass.listInstances();
            return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Academia>(it, true);
        }

        public static com.infotec.cvi.swb.Academia createAcademia(org.semanticwb.model.SWBModel model)
        {
            long id=model.getSemanticObject().getModel().getCounter(sclass);
            return com.infotec.cvi.swb.Academia.ClassMgr.createAcademia(String.valueOf(id), model);
        }
       /**
       * Gets a com.infotec.cvi.swb.Academia
       * @param id Identifier for com.infotec.cvi.swb.Academia
       * @param model Model of the com.infotec.cvi.swb.Academia
       * @return A com.infotec.cvi.swb.Academia
       */
        public static com.infotec.cvi.swb.Academia getAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Academia)model.getSemanticObject().getModel().getGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Create a com.infotec.cvi.swb.Academia
       * @param id Identifier for com.infotec.cvi.swb.Academia
       * @param model Model of the com.infotec.cvi.swb.Academia
       * @return A com.infotec.cvi.swb.Academia
       */
        public static com.infotec.cvi.swb.Academia createAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (com.infotec.cvi.swb.Academia)model.getSemanticObject().getModel().createGenericObject(model.getSemanticObject().getModel().getObjectUri(id,sclass),sclass);
        }
       /**
       * Remove a com.infotec.cvi.swb.Academia
       * @param id Identifier for com.infotec.cvi.swb.Academia
       * @param model Model of the com.infotec.cvi.swb.Academia
       */
        public static void removeAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            model.getSemanticObject().getModel().removeSemanticObject(model.getSemanticObject().getModel().getObjectUri(id,sclass));
        }
       /**
       * Returns true if exists a com.infotec.cvi.swb.Academia
       * @param id Identifier for com.infotec.cvi.swb.Academia
       * @param model Model of the com.infotec.cvi.swb.Academia
       * @return true if the com.infotec.cvi.swb.Academia exists, false otherwise
       */

        public static boolean hasAcademia(String id, org.semanticwb.model.SWBModel model)
        {
            return (getAcademia(id, model)!=null);
        }
       /**
       * Gets all com.infotec.cvi.swb.Academia with a determined GradoAcademico
       * @param value GradoAcademico of the type com.infotec.cvi.swb.GradoAcademico
       * @param model Model of the com.infotec.cvi.swb.Academia
       * @return Iterator with all the com.infotec.cvi.swb.Academia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Academia> listAcademiaByGradoAcademico(com.infotec.cvi.swb.GradoAcademico value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGradoAcademico, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Academia with a determined GradoAcademico
       * @param value GradoAcademico of the type com.infotec.cvi.swb.GradoAcademico
       * @return Iterator with all the com.infotec.cvi.swb.Academia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Academia> listAcademiaByGradoAcademico(com.infotec.cvi.swb.GradoAcademico value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasGradoAcademico,value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Academia with a determined EstudioSuperior
       * @param value EstudioSuperior of the type com.infotec.cvi.swb.EstudioSuperior
       * @param model Model of the com.infotec.cvi.swb.Academia
       * @return Iterator with all the com.infotec.cvi.swb.Academia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Academia> listAcademiaByEstudioSuperior(com.infotec.cvi.swb.EstudioSuperior value,org.semanticwb.model.SWBModel model)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Academia> it=new org.semanticwb.model.GenericIterator(model.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstudioSuperior, value.getSemanticObject(),sclass));
            return it;
        }
       /**
       * Gets all com.infotec.cvi.swb.Academia with a determined EstudioSuperior
       * @param value EstudioSuperior of the type com.infotec.cvi.swb.EstudioSuperior
       * @return Iterator with all the com.infotec.cvi.swb.Academia
       */

        public static java.util.Iterator<com.infotec.cvi.swb.Academia> listAcademiaByEstudioSuperior(com.infotec.cvi.swb.EstudioSuperior value)
        {
            org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.Academia> it=new org.semanticwb.model.GenericIterator(value.getSemanticObject().getModel().listSubjectsByClass(intranet_hasEstudioSuperior,value.getSemanticObject(),sclass));
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
   * Gets all the com.infotec.cvi.swb.GradoAcademico
   * @return A GenericIterator with all the com.infotec.cvi.swb.GradoAcademico
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico> listGradoAcademicos()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.GradoAcademico>(getSemanticObject().listObjectProperties(intranet_hasGradoAcademico));
    }

   /**
   * Gets true if has a GradoAcademico
   * @param value com.infotec.cvi.swb.GradoAcademico to verify
   * @return true if the com.infotec.cvi.swb.GradoAcademico exists, false otherwise
   */
    public boolean hasGradoAcademico(com.infotec.cvi.swb.GradoAcademico value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasGradoAcademico,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a GradoAcademico
   * @param value com.infotec.cvi.swb.GradoAcademico to add
   */

    public void addGradoAcademico(com.infotec.cvi.swb.GradoAcademico value)
    {
        getSemanticObject().addObjectProperty(intranet_hasGradoAcademico, value.getSemanticObject());
    }
   /**
   * Removes all the GradoAcademico
   */

    public void removeAllGradoAcademico()
    {
        getSemanticObject().removeProperty(intranet_hasGradoAcademico);
    }
   /**
   * Removes a GradoAcademico
   * @param value com.infotec.cvi.swb.GradoAcademico to remove
   */

    public void removeGradoAcademico(com.infotec.cvi.swb.GradoAcademico value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasGradoAcademico,value.getSemanticObject());
    }

   /**
   * Gets the GradoAcademico
   * @return a com.infotec.cvi.swb.GradoAcademico
   */
    public com.infotec.cvi.swb.GradoAcademico getGradoAcademico()
    {
         com.infotec.cvi.swb.GradoAcademico ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasGradoAcademico);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.GradoAcademico)obj.createGenericInstance();
         }
         return ret;
    }

/**
* Gets the NoAplicaEstudioSuperior property
* @return boolean with the NoAplicaEstudioSuperior
*/
    public boolean isNoAplicaEstudioSuperior()
    {
        return getSemanticObject().getBooleanProperty(intranet_noAplicaEstudioSuperior);
    }

/**
* Sets the NoAplicaEstudioSuperior property
* @param value long with the NoAplicaEstudioSuperior
*/
    public void setNoAplicaEstudioSuperior(boolean value)
    {
        getSemanticObject().setBooleanProperty(intranet_noAplicaEstudioSuperior, value);
    }
   /**
   * Gets all the com.infotec.cvi.swb.EstudioSuperior
   * @return A GenericIterator with all the com.infotec.cvi.swb.EstudioSuperior
   */

    public org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior> listEstudioSuperiors()
    {
        return new org.semanticwb.model.GenericIterator<com.infotec.cvi.swb.EstudioSuperior>(getSemanticObject().listObjectProperties(intranet_hasEstudioSuperior));
    }

   /**
   * Gets true if has a EstudioSuperior
   * @param value com.infotec.cvi.swb.EstudioSuperior to verify
   * @return true if the com.infotec.cvi.swb.EstudioSuperior exists, false otherwise
   */
    public boolean hasEstudioSuperior(com.infotec.cvi.swb.EstudioSuperior value)
    {
        boolean ret=false;
        if(value!=null)
        {
           ret=getSemanticObject().hasObjectProperty(intranet_hasEstudioSuperior,value.getSemanticObject());
        }
        return ret;
    }
   /**
   * Adds a EstudioSuperior
   * @param value com.infotec.cvi.swb.EstudioSuperior to add
   */

    public void addEstudioSuperior(com.infotec.cvi.swb.EstudioSuperior value)
    {
        getSemanticObject().addObjectProperty(intranet_hasEstudioSuperior, value.getSemanticObject());
    }
   /**
   * Removes all the EstudioSuperior
   */

    public void removeAllEstudioSuperior()
    {
        getSemanticObject().removeProperty(intranet_hasEstudioSuperior);
    }
   /**
   * Removes a EstudioSuperior
   * @param value com.infotec.cvi.swb.EstudioSuperior to remove
   */

    public void removeEstudioSuperior(com.infotec.cvi.swb.EstudioSuperior value)
    {
        getSemanticObject().removeObjectProperty(intranet_hasEstudioSuperior,value.getSemanticObject());
    }

   /**
   * Gets the EstudioSuperior
   * @return a com.infotec.cvi.swb.EstudioSuperior
   */
    public com.infotec.cvi.swb.EstudioSuperior getEstudioSuperior()
    {
         com.infotec.cvi.swb.EstudioSuperior ret=null;
         org.semanticwb.platform.SemanticObject obj=getSemanticObject().getObjectProperty(intranet_hasEstudioSuperior);
         if(obj!=null)
         {
             ret=(com.infotec.cvi.swb.EstudioSuperior)obj.createGenericInstance();
         }
         return ret;
    }
}
